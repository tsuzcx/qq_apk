package com.squareup.okhttp.internal.http;

import com.squareup.okhttp.Address;
import com.squareup.okhttp.Dns;
import com.squareup.okhttp.HttpUrl;
import com.squareup.okhttp.Route;
import com.squareup.okhttp.internal.RouteDatabase;
import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.Proxy.Type;
import java.net.ProxySelector;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;

public final class RouteSelector
{
  private final Address address;
  private List<InetSocketAddress> inetSocketAddresses = Collections.emptyList();
  private InetSocketAddress lastInetSocketAddress;
  private Proxy lastProxy;
  private int nextInetSocketAddressIndex;
  private int nextProxyIndex;
  private final List<Route> postponedRoutes = new ArrayList();
  private List<Proxy> proxies = Collections.emptyList();
  private final RouteDatabase routeDatabase;
  
  public RouteSelector(Address paramAddress, RouteDatabase paramRouteDatabase)
  {
    this.address = paramAddress;
    this.routeDatabase = paramRouteDatabase;
    resetNextProxy(paramAddress.url(), paramAddress.getProxy());
  }
  
  static String getHostString(InetSocketAddress paramInetSocketAddress)
  {
    InetAddress localInetAddress = paramInetSocketAddress.getAddress();
    if (localInetAddress == null) {
      return paramInetSocketAddress.getHostName();
    }
    return localInetAddress.getHostAddress();
  }
  
  private boolean hasNextInetSocketAddress()
  {
    return this.nextInetSocketAddressIndex < this.inetSocketAddresses.size();
  }
  
  private boolean hasNextPostponed()
  {
    return !this.postponedRoutes.isEmpty();
  }
  
  private boolean hasNextProxy()
  {
    return this.nextProxyIndex < this.proxies.size();
  }
  
  private InetSocketAddress nextInetSocketAddress()
    throws IOException
  {
    if (!hasNextInetSocketAddress()) {
      throw new SocketException("No route to " + this.address.getUriHost() + "; exhausted inet socket addresses: " + this.inetSocketAddresses);
    }
    List localList = this.inetSocketAddresses;
    int i = this.nextInetSocketAddressIndex;
    this.nextInetSocketAddressIndex = (i + 1);
    return (InetSocketAddress)localList.get(i);
  }
  
  private Route nextPostponed()
  {
    return (Route)this.postponedRoutes.remove(0);
  }
  
  private Proxy nextProxy()
    throws IOException
  {
    if (!hasNextProxy()) {
      throw new SocketException("No route to " + this.address.getUriHost() + "; exhausted proxy configurations: " + this.proxies);
    }
    Object localObject = this.proxies;
    int i = this.nextProxyIndex;
    this.nextProxyIndex = (i + 1);
    localObject = (Proxy)((List)localObject).get(i);
    resetNextInetSocketAddress((Proxy)localObject);
    return localObject;
  }
  
  private void resetNextInetSocketAddress(Proxy paramProxy)
    throws IOException
  {
    this.inetSocketAddresses = new ArrayList();
    Object localObject;
    if ((paramProxy.type() == Proxy.Type.DIRECT) || (paramProxy.type() == Proxy.Type.SOCKS)) {
      localObject = this.address.getUriHost();
    }
    InetSocketAddress localInetSocketAddress;
    for (int i = this.address.getUriPort(); (i < 1) || (i > 65535); i = localInetSocketAddress.getPort())
    {
      throw new SocketException("No route to " + (String)localObject + ":" + i + "; port is out of range");
      localObject = paramProxy.address();
      if (!(localObject instanceof InetSocketAddress)) {
        throw new IllegalArgumentException("Proxy.address() is not an InetSocketAddress: " + localObject.getClass());
      }
      localInetSocketAddress = (InetSocketAddress)localObject;
      localObject = getHostString(localInetSocketAddress);
    }
    if (paramProxy.type() == Proxy.Type.SOCKS) {
      this.inetSocketAddresses.add(InetSocketAddress.createUnresolved((String)localObject, i));
    }
    for (;;)
    {
      this.nextInetSocketAddressIndex = 0;
      return;
      paramProxy = this.address.getDns().lookup((String)localObject);
      int j = 0;
      int k = paramProxy.size();
      while (j < k)
      {
        localObject = (InetAddress)paramProxy.get(j);
        this.inetSocketAddresses.add(new InetSocketAddress((InetAddress)localObject, i));
        j += 1;
      }
    }
  }
  
  private void resetNextProxy(HttpUrl paramHttpUrl, Proxy paramProxy)
  {
    if (paramProxy != null) {
      this.proxies = Collections.singletonList(paramProxy);
    }
    for (;;)
    {
      this.nextProxyIndex = 0;
      return;
      this.proxies = new ArrayList();
      paramHttpUrl = this.address.getProxySelector().select(paramHttpUrl.uri());
      if (paramHttpUrl != null) {
        this.proxies.addAll(paramHttpUrl);
      }
      this.proxies.removeAll(Collections.singleton(Proxy.NO_PROXY));
      this.proxies.add(Proxy.NO_PROXY);
    }
  }
  
  public void connectFailed(Route paramRoute, IOException paramIOException)
  {
    if ((paramRoute.getProxy().type() != Proxy.Type.DIRECT) && (this.address.getProxySelector() != null)) {
      this.address.getProxySelector().connectFailed(this.address.url().uri(), paramRoute.getProxy().address(), paramIOException);
    }
    this.routeDatabase.failed(paramRoute);
  }
  
  public boolean hasNext()
  {
    return (hasNextInetSocketAddress()) || (hasNextProxy()) || (hasNextPostponed());
  }
  
  public Route next()
    throws IOException
  {
    Object localObject;
    if (!hasNextInetSocketAddress()) {
      if (!hasNextProxy())
      {
        if (!hasNextPostponed()) {
          throw new NoSuchElementException();
        }
        localObject = nextPostponed();
      }
    }
    Route localRoute;
    do
    {
      return localObject;
      this.lastProxy = nextProxy();
      this.lastInetSocketAddress = nextInetSocketAddress();
      localRoute = new Route(this.address, this.lastProxy, this.lastInetSocketAddress);
      localObject = localRoute;
    } while (!this.routeDatabase.shouldPostpone(localRoute));
    this.postponedRoutes.add(localRoute);
    return next();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.squareup.okhttp.internal.http.RouteSelector
 * JD-Core Version:    0.7.0.1
 */