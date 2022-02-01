package com.tencent.mapsdk.internal;

import android.net.Uri;
import com.tencent.map.tools.net.NetRequest;
import com.tencent.map.tools.net.http.HttpProxy;
import com.tencent.map.tools.net.http.HttpProxyRule;
import com.tencent.map.tools.net.processor.RequestProcessor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.Proxy.Type;
import java.net.SocketAddress;
import java.util.List;

public final class ln
  implements RequestProcessor
{
  private final List<HttpProxyRule> a;
  private final boolean b;
  
  private ln(List<HttpProxyRule> paramList)
  {
    this.a = paramList;
    this.b = false;
  }
  
  private HttpProxy a(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(222535);
    int i;
    String str;
    if ((this.a != null) && (!this.a.isEmpty()))
    {
      i = 0;
      int j = 0;
      str = paramString;
      Object localObject;
      while (i < this.a.size())
      {
        localObject = (HttpProxyRule)this.a.get(i);
        if (((HttpProxyRule)localObject).match(paramString))
        {
          str = ((HttpProxyRule)localObject).replaceHost(paramString);
          j = 1;
        }
        i += 1;
      }
      if (j != 0)
      {
        paramString = Uri.parse(str);
        localObject = paramString.getHost();
        j = paramString.getPort();
        if (j >= 0)
        {
          i = j;
          if (j <= 65535) {}
        }
        else
        {
          if (!"https".equals(paramString.getScheme())) {
            break label181;
          }
          i = 443;
        }
        paramString = new InetSocketAddress((String)localObject, i);
      }
    }
    for (paramString = new HttpProxy(new Proxy(Proxy.Type.HTTP, paramString), str, paramBoolean);; paramString = null)
    {
      AppMethodBeat.o(222535);
      return paramString;
      label181:
      i = 80;
      break;
    }
  }
  
  public static ln a(List<HttpProxyRule> paramList)
  {
    AppMethodBeat.i(222520);
    paramList = new ln(paramList);
    AppMethodBeat.o(222520);
    return paramList;
  }
  
  private static ln b(List<HttpProxyRule> paramList)
  {
    AppMethodBeat.i(222513);
    paramList = a(paramList);
    AppMethodBeat.o(222513);
    return paramList;
  }
  
  public final void onRequest(NetRequest paramNetRequest)
  {
    AppMethodBeat.i(222544);
    Object localObject2 = paramNetRequest.url;
    boolean bool = this.b;
    int i;
    if ((this.a != null) && (!this.a.isEmpty()))
    {
      i = 0;
      int j = 0;
      localObject1 = localObject2;
      Object localObject3;
      while (i < this.a.size())
      {
        localObject3 = (HttpProxyRule)this.a.get(i);
        if (((HttpProxyRule)localObject3).match((String)localObject2))
        {
          localObject1 = ((HttpProxyRule)localObject3).replaceHost((String)localObject2);
          j = 1;
        }
        i += 1;
      }
      if (j != 0)
      {
        localObject2 = Uri.parse((String)localObject1);
        localObject3 = ((Uri)localObject2).getHost();
        j = ((Uri)localObject2).getPort();
        if (j >= 0)
        {
          i = j;
          if (j <= 65535) {}
        }
        else
        {
          if (!"https".equals(((Uri)localObject2).getScheme())) {
            break label202;
          }
          i = 443;
        }
        localObject2 = new InetSocketAddress((String)localObject3, i);
      }
    }
    for (Object localObject1 = new HttpProxy(new Proxy(Proxy.Type.HTTP, (SocketAddress)localObject2), (String)localObject1, bool);; localObject1 = null)
    {
      paramNetRequest.proxy = ((HttpProxy)localObject1);
      AppMethodBeat.o(222544);
      return;
      label202:
      i = 80;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mapsdk.internal.ln
 * JD-Core Version:    0.7.0.1
 */