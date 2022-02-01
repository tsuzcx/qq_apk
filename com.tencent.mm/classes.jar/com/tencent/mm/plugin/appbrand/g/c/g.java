package com.tencent.mm.plugin.appbrand.g.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;

public class g
{
  private static final String TAG;
  private static List<NetworkInterface> lkZ;
  
  static
  {
    AppMethodBeat.i(158991);
    TAG = g.class.getSimpleName();
    lkZ = new ArrayList();
    AppMethodBeat.o(158991);
  }
  
  public static String bBA()
  {
    AppMethodBeat.i(158989);
    Object localObject1 = null;
    label93:
    for (;;)
    {
      try
      {
        Enumeration localEnumeration1 = NetworkInterface.getNetworkInterfaces();
        localObject1 = null;
        Enumeration localEnumeration2;
        Object localObject2;
        boolean bool;
        new StringBuilder("can not get host ip : ").append(localSocketException1.getCause());
      }
      catch (SocketException localSocketException1)
      {
        try
        {
          if (localEnumeration1.hasMoreElements())
          {
            localEnumeration2 = ((NetworkInterface)localEnumeration1.nextElement()).getInetAddresses();
            if (!localEnumeration2.hasMoreElements()) {
              continue;
            }
            localObject2 = (InetAddress)localEnumeration2.nextElement();
            if ((localObject2 instanceof Inet6Address)) {
              continue;
            }
            localObject2 = ((InetAddress)localObject2).getHostAddress();
            bool = "127.0.0.1".equals(localObject2);
            if (bool) {
              continue;
            }
            localObject1 = localObject2;
            continue;
          }
          AppMethodBeat.o(158989);
          return localObject1;
        }
        catch (SocketException localSocketException2)
        {
          break label93;
        }
        localSocketException1 = localSocketException1;
      }
    }
  }
  
  public static List<NetworkInterface> bBz()
  {
    AppMethodBeat.i(158988);
    lkZ.clear();
    for (;;)
    {
      try
      {
        localObject = NetworkInterface.getNetworkInterfaces();
        if (localObject != null) {
          continue;
        }
      }
      catch (SocketException localSocketException)
      {
        Object localObject;
        NetworkInterface localNetworkInterface;
        Iterator localIterator;
        continue;
      }
      localObject = lkZ;
      AppMethodBeat.o(158988);
      return localObject;
      localObject = Collections.list((Enumeration)localObject).iterator();
      if (((Iterator)localObject).hasNext())
      {
        localNetworkInterface = (NetworkInterface)((Iterator)localObject).next();
        localIterator = Collections.list(localNetworkInterface.getInetAddresses()).iterator();
        if (localIterator.hasNext()) {
          if (((InetAddress)localIterator.next()).getHostAddress().startsWith("192.168")) {
            lkZ.add(localNetworkInterface);
          }
        }
      }
    }
  }
  
  public static String u(String paramString1, int paramInt, String paramString2)
  {
    AppMethodBeat.i(158990);
    if (paramString2.startsWith("/"))
    {
      paramString1 = "http://" + paramString1 + ":" + paramInt + paramString2;
      AppMethodBeat.o(158990);
      return paramString1;
    }
    paramString1 = "http://" + paramString1 + ":" + paramInt + "/" + paramString2;
    AppMethodBeat.o(158990);
    return paramString1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.g.c.g
 * JD-Core Version:    0.7.0.1
 */