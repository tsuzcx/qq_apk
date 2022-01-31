package com.tencent.mm.plugin.appbrand.o;

import android.text.TextUtils;
import com.tencent.mm.plugin.appbrand.v.o;
import com.tencent.mm.plugin.appbrand.w.b.d;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.net.Proxy;
import java.net.Socket;
import java.net.URI;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Timer;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import org.json.JSONArray;
import org.json.JSONObject;

public final class k
{
  private SSLSocketFactory fSP;
  private final String gQK;
  protected final ArrayList<com.tencent.mm.plugin.appbrand.w.a.a> gRw = new ArrayList();
  private int gRx;
  
  public k(a parama)
  {
    SSLContext localSSLContext = j.a(parama);
    if (localSSLContext != null) {
      this.fSP = localSSLContext.getSocketFactory();
    }
    this.gQK = parama.gQG;
    this.gRx = parama.gQC;
  }
  
  private static String E(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {
      return null;
    }
    LinkedList localLinkedList = new LinkedList();
    paramJSONObject = paramJSONObject.optJSONArray("protocols");
    if ((paramJSONObject != null) && (paramJSONObject.length() > 0))
    {
      int i = 0;
      while (i < paramJSONObject.length())
      {
        localLinkedList.add(paramJSONObject.optString(i));
        i += 1;
      }
    }
    if (!bk.dk(localLinkedList)) {
      return TextUtils.join(", ", localLinkedList);
    }
    return null;
  }
  
  private void a(com.tencent.mm.plugin.appbrand.w.a.a parama)
  {
    synchronized (this.gRw)
    {
      if ("0".equals(parama.gep)) {
        this.gRw.clear();
      }
      this.gRw.add(parama);
      return;
    }
  }
  
  static void d(com.tencent.mm.plugin.appbrand.w.a.a parama)
  {
    if (parama == null) {}
    Timer localTimer;
    do
    {
      return;
      localTimer = parama.mTimer;
      y.i("MicroMsg.AppBrandNetworkWebSocket", "try to stop connectTimer");
    } while (localTimer == null);
    localTimer.cancel();
    parama.mTimer = null;
  }
  
  public final void a(String paramString, int paramInt, JSONObject paramJSONObject, Map<String, String> paramMap, k.b paramb)
  {
    String str;
    synchronized (this.gRw)
    {
      if (this.gRw.size() >= this.gRx)
      {
        paramb.sN("max connected");
        y.i("MicroMsg.AppBrandNetworkWebSocket", "max connected");
        return;
      }
      str = paramJSONObject.optString("url");
    }
    URI localURI;
    try
    {
      localURI = new URI(str);
      boolean bool = paramJSONObject.optBoolean("tcpNoDelay", false);
      y.i("MicroMsg.AppBrandNetworkWebSocket", "connectSocket, url= %s, timeout = %d, tcpNoDelay = %b", new Object[] { str, Integer.valueOf(paramInt), Boolean.valueOf(bool) });
      paramMap.put("User-Agent", this.gQK);
      paramJSONObject = E(paramJSONObject);
      if (!bk.bl(paramJSONObject))
      {
        y.i("MicroMsg.AppBrandNetworkWebSocket", "protocols %s", new Object[] { paramJSONObject });
        paramMap.put("Sec-WebSocket-Protocol", paramJSONObject);
      }
      ??? = localURI.getScheme();
      if (bk.bl((String)???))
      {
        paramJSONObject = null;
        if (!bk.bl(paramJSONObject))
        {
          y.i("MicroMsg.AppBrandNetworkWebSocket", "Origin %s", new Object[] { paramJSONObject });
          paramMap.put("Origin", paramJSONObject);
        }
        try
        {
          paramJSONObject = new k.1(this, localURI, new d(), paramMap, paramInt, str, paramb);
          paramJSONObject.gep = paramString;
          paramJSONObject.hmi = bool;
          if (!o.n(str, "ws://")) {
            break label559;
          }
          y.i("MicroMsg.AppBrandNetworkWebSocket", "url is %s ,user ws connect", new Object[] { str });
          paramJSONObject.a(new Socket(Proxy.NO_PROXY));
          paramJSONObject.connect();
          a(paramJSONObject);
          paramString = new Timer();
          paramMap = new k.2(this, paramb, paramJSONObject, paramString);
          paramJSONObject.mTimer = paramString;
          paramString.schedule(paramMap, paramInt);
          return;
        }
        catch (Exception paramString)
        {
          y.e("MicroMsg.AppBrandNetworkWebSocket", "url %s exception %s", new Object[] { str, paramString.toString() });
          paramb.sL(paramString.getMessage());
          return;
        }
        paramString = finally;
        throw paramString;
      }
    }
    catch (Exception paramString)
    {
      y.e("MicroMsg.AppBrandNetworkWebSocket", "connect fail : %s ", new Object[] { paramString.toString() });
      paramb.sN("url not well format");
      return;
    }
    if (((String)???).equalsIgnoreCase("wss"))
    {
      paramJSONObject = "https";
      label417:
      ??? = new StringBuilder(paramJSONObject);
      ((StringBuilder)???).append("://");
      ((StringBuilder)???).append(localURI.getHost());
      i = localURI.getPort();
      if ((i != -1) && ((!paramJSONObject.equalsIgnoreCase("http")) || (i != 80)) && ((!paramJSONObject.equalsIgnoreCase("https")) || (i != 443))) {
        break label553;
      }
    }
    label553:
    for (int i = 1;; i = 0)
    {
      if (i == 0)
      {
        ((StringBuilder)???).append(":");
        ((StringBuilder)???).append(localURI.getPort());
      }
      paramJSONObject = ((StringBuilder)???).toString();
      break;
      paramJSONObject = (JSONObject)???;
      if (!((String)???).equalsIgnoreCase("ws")) {
        break label417;
      }
      paramJSONObject = "http";
      break label417;
    }
    label559:
    if (o.n(str, "wss://"))
    {
      y.i("MicroMsg.AppBrandNetworkWebSocket", "url is %s ,user wss connect", new Object[] { str });
      if (this.fSP != null) {}
      for (paramString = this.fSP;; paramString = (SSLSocketFactory)SSLSocketFactory.getDefault())
      {
        paramJSONObject.a(paramString.createSocket());
        paramJSONObject.connect();
        a(paramJSONObject);
        paramString = new Timer();
        paramMap = new k.3(this, paramb, paramJSONObject, paramString);
        paramJSONObject.mTimer = paramString;
        paramString.schedule(paramMap, paramInt);
        return;
      }
    }
    y.i("MicroMsg.AppBrandNetworkWebSocket", "url error: %s not ws:// or wss://", new Object[] { str });
    paramb.sN("url not ws or wss");
  }
  
  /* Error */
  public final void b(com.tencent.mm.plugin.appbrand.w.a.a parama)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: ifnonnull +6 -> 9
    //   6: aload_0
    //   7: monitorexit
    //   8: return
    //   9: aload_0
    //   10: getfield 27	com/tencent/mm/plugin/appbrand/o/k:gRw	Ljava/util/ArrayList;
    //   13: astore_2
    //   14: aload_2
    //   15: monitorenter
    //   16: aload_0
    //   17: getfield 27	com/tencent/mm/plugin/appbrand/o/k:gRw	Ljava/util/ArrayList;
    //   20: aload_1
    //   21: invokevirtual 333	java/util/ArrayList:remove	(Ljava/lang/Object;)Z
    //   24: pop
    //   25: aload_2
    //   26: monitorexit
    //   27: goto -21 -> 6
    //   30: astore_1
    //   31: aload_2
    //   32: monitorexit
    //   33: aload_1
    //   34: athrow
    //   35: astore_1
    //   36: aload_0
    //   37: monitorexit
    //   38: aload_1
    //   39: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	40	0	this	k
    //   0	40	1	parama	com.tencent.mm.plugin.appbrand.w.a.a
    // Exception table:
    //   from	to	target	type
    //   16	27	30	finally
    //   31	33	30	finally
    //   9	16	35	finally
    //   33	35	35	finally
  }
  
  public final void c(com.tencent.mm.plugin.appbrand.w.a.a parama)
  {
    if (parama != null) {}
    try
    {
      y.i("MicroMsg.AppBrandNetworkWebSocket", "try to close socket");
      parama.close();
      b(parama);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        y.e("MicroMsg.AppBrandNetworkWebSocket", "send error" + localException.toString());
        d(parama);
      }
    }
  }
  
  public final com.tencent.mm.plugin.appbrand.w.a.a vB(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    synchronized (this.gRw)
    {
      Iterator localIterator = this.gRw.iterator();
      while (localIterator.hasNext())
      {
        com.tencent.mm.plugin.appbrand.w.a.a locala = (com.tencent.mm.plugin.appbrand.w.a.a)localIterator.next();
        if (paramString.equals(locala.gep)) {
          return locala;
        }
      }
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.o.k
 * JD-Core Version:    0.7.0.1
 */