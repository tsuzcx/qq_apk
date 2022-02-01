package com.tencent.mm.plugin.appbrand.p;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.aa.e.h;
import com.tencent.mm.plugin.appbrand.aa.f.b;
import com.tencent.mm.plugin.appbrand.jsapi.j.g;
import com.tencent.mm.plugin.appbrand.jsapi.websocket.e;
import com.tencent.mm.plugin.appbrand.jsapi.websocket.e.a;
import com.tencent.mm.plugin.appbrand.utils.w;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.ax;
import com.tencent.mm.sdk.platformtools.bs;
import java.net.Proxy;
import java.net.Socket;
import java.net.URI;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import org.json.JSONObject;

public final class k
  implements com.tencent.mm.plugin.appbrand.jsapi.websocket.d
{
  private SSLSocketFactory jHH;
  private final String kXC;
  private int kXD;
  protected final ArrayList<e> kXZ;
  private boolean lxj;
  
  public k(a parama)
  {
    AppMethodBeat.i(144405);
    this.kXZ = new ArrayList();
    SSLContext localSSLContext = j.a(parama);
    if (localSSLContext != null) {
      this.jHH = localSSLContext.getSocketFactory();
    }
    this.kXC = parama.lwh;
    this.kXD = parama.lwd;
    this.lxj = parama.ccB;
    ac.i("MicroMsg.AppBrandNetworkWebSocket", "mTLSSkipHostnameCheck is %b", new Object[] { Boolean.valueOf(this.lxj) });
    AppMethodBeat.o(144405);
  }
  
  private void c(e parame)
  {
    AppMethodBeat.i(144407);
    synchronized (this.kXZ)
    {
      if ("0".equals(parame.aLs())) {
        this.kXZ.clear();
      }
      this.kXZ.add(parame);
      AppMethodBeat.o(144407);
      return;
    }
  }
  
  /* Error */
  private void d(e parame)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 126
    //   4: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: aload_1
    //   8: ifnonnull +11 -> 19
    //   11: ldc 126
    //   13: invokestatic 97	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   16: aload_0
    //   17: monitorexit
    //   18: return
    //   19: aload_0
    //   20: getfield 49	com/tencent/mm/plugin/appbrand/p/k:kXZ	Ljava/util/ArrayList;
    //   23: astore_2
    //   24: aload_2
    //   25: monitorenter
    //   26: aload_0
    //   27: getfield 49	com/tencent/mm/plugin/appbrand/p/k:kXZ	Ljava/util/ArrayList;
    //   30: aload_1
    //   31: invokevirtual 129	java/util/ArrayList:remove	(Ljava/lang/Object;)Z
    //   34: pop
    //   35: aload_2
    //   36: monitorexit
    //   37: ldc 126
    //   39: invokestatic 97	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   42: goto -26 -> 16
    //   45: astore_1
    //   46: aload_0
    //   47: monitorexit
    //   48: aload_1
    //   49: athrow
    //   50: astore_1
    //   51: aload_2
    //   52: monitorexit
    //   53: ldc 126
    //   55: invokestatic 97	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   58: aload_1
    //   59: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	60	0	this	k
    //   0	60	1	parame	e
    // Exception table:
    //   from	to	target	type
    //   2	7	45	finally
    //   11	16	45	finally
    //   19	26	45	finally
    //   37	42	45	finally
    //   53	60	45	finally
    //   26	37	50	finally
    //   51	53	50	finally
  }
  
  private static void e(e parame)
  {
    AppMethodBeat.i(144415);
    if (parame == null)
    {
      AppMethodBeat.o(144415);
      return;
    }
    Timer localTimer = parame.blm();
    ac.i("MicroMsg.AppBrandNetworkWebSocket", "try to stop connectTimer");
    if (localTimer != null)
    {
      localTimer.cancel();
      parame.a(null);
    }
    AppMethodBeat.o(144415);
  }
  
  public final e NL(String paramString)
  {
    AppMethodBeat.i(144416);
    if (paramString == null)
    {
      AppMethodBeat.o(144416);
      return null;
    }
    synchronized (this.kXZ)
    {
      Iterator localIterator = this.kXZ.iterator();
      while (localIterator.hasNext())
      {
        e locale = (e)localIterator.next();
        if (paramString.equals(locale.aLs()))
        {
          AppMethodBeat.o(144416);
          return locale;
        }
      }
      AppMethodBeat.o(144416);
      return null;
    }
  }
  
  public final void a(e parame)
  {
    AppMethodBeat.i(144409);
    if (parame != null) {}
    try
    {
      ac.i("MicroMsg.AppBrandNetworkWebSocket", "try to close socket");
      parame.close();
      d(parame);
      AppMethodBeat.o(144409);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ac.printErrStackTrace("MicroMsg.AppBrandNetworkWebSocket", localException, "Exception: send error", new Object[0]);
        e(parame);
      }
    }
  }
  
  public final void a(e parame, int paramInt, String paramString)
  {
    AppMethodBeat.i(144410);
    if (parame != null) {}
    try
    {
      ac.i("MicroMsg.AppBrandNetworkWebSocket", "try to close socket");
      parame.bF(paramString, paramInt);
      d(parame);
      AppMethodBeat.o(144410);
      return;
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        ac.printErrStackTrace("MicroMsg.AppBrandNetworkWebSocket", paramString, "Exception: send error", new Object[0]);
      }
    }
  }
  
  public final void a(e parame, String paramString)
  {
    AppMethodBeat.i(144412);
    if (parame != null) {
      parame.NN(paramString);
    }
    AppMethodBeat.o(144412);
  }
  
  public final void a(e parame, ByteBuffer paramByteBuffer)
  {
    AppMethodBeat.i(144413);
    parame.p(paramByteBuffer);
    AppMethodBeat.o(144413);
  }
  
  public final void a(final String paramString1, final String paramString2, int paramInt1, int paramInt2, final JSONObject paramJSONObject, Map<String, String> paramMap, final com.tencent.mm.plugin.appbrand.jsapi.websocket.d.a parama)
  {
    AppMethodBeat.i(144406);
    synchronized (this.kXZ)
    {
      if (this.kXZ.size() >= this.kXD)
      {
        parama.KI("max connected");
        ac.i("MicroMsg.AppBrandNetworkWebSocket", "max connected mTaskList.size():%d,mMaxWebsocketConnect:%d", new Object[] { Integer.valueOf(this.kXZ.size()), Integer.valueOf(this.kXD) });
        AppMethodBeat.o(144406);
        return;
      }
      ??? = paramJSONObject.optString("url");
    }
    try
    {
      URI localURI = new URI((String)???);
      boolean bool = paramJSONObject.optBoolean("tcpNoDelay", false);
      ac.i("MicroMsg.AppBrandNetworkWebSocket", "connectSocket, url= %s, timeout = %d, tcpNoDelay = %b, taskId=%s", new Object[] { ???, Integer.valueOf(paramInt2), Boolean.valueOf(bool), paramString2 });
      paramMap.put("User-Agent", this.kXC);
      paramJSONObject = j.Z(paramJSONObject);
      if (!bs.isNullOrNil(paramJSONObject))
      {
        ac.i("MicroMsg.AppBrandNetworkWebSocket", "protocols %s", new Object[] { paramJSONObject });
        paramMap.put("Sec-WebSocket-Protocol", paramJSONObject);
      }
      paramJSONObject = j.a(localURI);
      if (!bs.isNullOrNil(paramJSONObject))
      {
        ac.i("MicroMsg.AppBrandNetworkWebSocket", "Origin %s", new Object[] { paramJSONObject });
        paramMap.put("Origin", paramJSONObject);
      }
      try
      {
        paramJSONObject = new com.tencent.mm.plugin.appbrand.jsapi.websocket.c(localURI, new com.tencent.mm.plugin.appbrand.aa.b.d(), paramMap, paramInt2)
        {
          private com.tencent.mm.plugin.appbrand.aa.d.d jHI = null;
          
          public final void KM(String paramAnonymousString)
          {
            AppMethodBeat.i(144398);
            String str = this.val$url;
            if (paramAnonymousString != null) {}
            for (int i = paramAnonymousString.length();; i = -1)
            {
              ac.i("MicroMsg.AppBrandNetworkWebSocket", "url is %s ,socket onmessage length :%d, taskId=%s", new Object[] { str, Integer.valueOf(i), paramString2 });
              parama.MK(paramAnonymousString);
              AppMethodBeat.o(144398);
              return;
            }
          }
          
          public final void Z(int paramAnonymousInt, String paramAnonymousString)
          {
            AppMethodBeat.i(144399);
            ac.i("MicroMsg.AppBrandNetworkWebSocket", "url is %s ,state: closed ,reason: %s, errCode = %d, taskId=%s", new Object[] { this.val$url, paramAnonymousString, Integer.valueOf(paramAnonymousInt), paramString2 });
            k.g(this);
            k.a(k.this, this);
            if ((paramAnonymousInt == -1) || (paramAnonymousInt == -2) || (paramAnonymousInt == -3))
            {
              com.tencent.mm.plugin.appbrand.jsapi.websocket.d.a locala;
              String str;
              if (!ax.isConnected(ai.getContext()))
              {
                locala = parama;
                str = "network is down";
              }
              for (;;)
              {
                locala.KH(str);
                parama.Y(1006, paramAnonymousString);
                AppMethodBeat.o(144399);
                return;
                locala = parama;
                if (bs.isNullOrNil(paramAnonymousString)) {
                  str = "abnormal closure";
                } else {
                  str = paramAnonymousString;
                }
              }
            }
            parama.Y(paramAnonymousInt, paramAnonymousString);
            AppMethodBeat.o(144399);
          }
          
          public final void a(com.tencent.mm.plugin.appbrand.aa.d.d paramAnonymousd)
          {
            AppMethodBeat.i(144402);
            if ((paramAnonymousd.bxH() != com.tencent.mm.plugin.appbrand.aa.d.d.a.mqu) && (!paramAnonymousd.bxF()))
            {
              this.jHI = paramAnonymousd;
              AppMethodBeat.o(144402);
              return;
            }
            if (paramAnonymousd.bxH() == com.tencent.mm.plugin.appbrand.aa.d.d.a.mqu)
            {
              if (this.jHI == null)
              {
                AppMethodBeat.o(144402);
                return;
              }
              if (this.jHI.bxE().position() > 10485760)
              {
                ac.e("MicroMsg.AppBrandNetworkWebSocket", "Pending Frame exploded");
                this.jHI = null;
                AppMethodBeat.o(144402);
                return;
              }
              try
              {
                this.jHI.e(paramAnonymousd);
                if (!paramAnonymousd.bxF())
                {
                  AppMethodBeat.o(144402);
                  return;
                }
              }
              catch (Exception localException)
              {
                for (;;)
                {
                  ac.printErrStackTrace("MicroMsg.AppBrandNetworkWebSocket", localException, "Exception: Framedata append fail", new Object[0]);
                }
              }
              if (this.jHI.bxH() != com.tencent.mm.plugin.appbrand.aa.d.d.a.mqw) {
                break label177;
              }
              m(this.jHI.bxE());
            }
            for (;;)
            {
              this.jHI = null;
              AppMethodBeat.o(144402);
              return;
              label177:
              if (this.jHI.bxH() == com.tencent.mm.plugin.appbrand.aa.d.d.a.mqv) {
                try
                {
                  KM(bs.nullAsNil(b.B(this.jHI.bxE())));
                }
                catch (Exception paramAnonymousd)
                {
                  ac.printErrStackTrace("MicroMsg.AppBrandNetworkWebSocket", paramAnonymousd, "Exception: stringUtf8 error", new Object[0]);
                }
              }
            }
          }
          
          public final void a(h paramAnonymoush)
          {
            AppMethodBeat.i(144396);
            ac.i("MicroMsg.AppBrandNetworkWebSocket", "url is %s ,state: opened, taskId=%s", new Object[] { this.val$url, paramString2 });
            k.g(this);
            parama.a(paramAnonymoush, null);
            AppMethodBeat.o(144396);
          }
          
          public final void a(e.a paramAnonymousa) {}
          
          public final void b(com.tencent.mm.plugin.appbrand.aa.e.a paramAnonymousa)
          {
            AppMethodBeat.i(144397);
            parama.a(paramAnonymousa);
            AppMethodBeat.o(144397);
          }
          
          public final void m(ByteBuffer paramAnonymousByteBuffer)
          {
            AppMethodBeat.i(144401);
            String str = this.val$url;
            if (paramAnonymousByteBuffer != null) {}
            for (int i = paramAnonymousByteBuffer.capacity();; i = -1)
            {
              ac.i("MicroMsg.AppBrandNetworkWebSocket", "url is %s , socket onMessage buffer length : %d, taskId=%s", new Object[] { str, Integer.valueOf(i), paramString2 });
              parama.l(paramAnonymousByteBuffer);
              AppMethodBeat.o(144401);
              return;
            }
          }
          
          public final void onError(Exception paramAnonymousException)
          {
            AppMethodBeat.i(144400);
            ac.printErrStackTrace("MicroMsg.AppBrandNetworkWebSocket", paramAnonymousException, "onError Exception: url %s, taskId=%s", new Object[] { this.val$url, paramString2 });
            k.g(this);
            k.a(k.this, this);
            parama.KH("exception " + paramAnonymousException.getMessage());
            AppMethodBeat.o(144400);
          }
        };
        paramJSONObject.NM(paramString2);
        paramJSONObject.setTcpNoDelay(bool);
        if (!w.B((String)???, "ws://")) {
          break label477;
        }
        ac.i("MicroMsg.AppBrandNetworkWebSocket", "url is %s ,user ws connect", new Object[] { ??? });
        paramJSONObject.a(new Socket(Proxy.NO_PROXY));
        paramJSONObject.connect();
        c(paramJSONObject);
        paramString1 = new Timer();
        paramString2 = new TimerTask()
        {
          public final void run()
          {
            AppMethodBeat.i(144403);
            ac.e("MicroMsg.AppBrandNetworkWebSocket", "connect response time out");
            paramJSONObject.close();
            k.a(k.this, paramJSONObject);
            parama.KH("connect response time out");
            cancel();
            paramString1.cancel();
            AppMethodBeat.o(144403);
          }
        };
        paramJSONObject.a(paramString1);
        paramString1.schedule(paramString2, paramInt2);
        AppMethodBeat.o(144406);
        return;
      }
      catch (Exception paramString1)
      {
        ac.printErrStackTrace("MicroMsg.AppBrandNetworkWebSocket", paramString1, "Exception: url %s", new Object[] { ??? });
        parama.KH(paramString1.getMessage());
        AppMethodBeat.o(144406);
        return;
      }
      paramString1 = finally;
      AppMethodBeat.o(144406);
      throw paramString1;
    }
    catch (Exception paramString1)
    {
      ac.printErrStackTrace("MicroMsg.AppBrandNetworkWebSocket", paramString1, "Exception: connect fail", new Object[0]);
      parama.KI("url not well format");
      AppMethodBeat.o(144406);
      return;
    }
    label477:
    if (w.B((String)???, "wss://"))
    {
      ac.i("MicroMsg.AppBrandNetworkWebSocket", "url is %s ,user wss connect", new Object[] { ??? });
      if (this.jHH != null) {}
      for (paramString2 = this.jHH;; paramString2 = (SSLSocketFactory)SSLSocketFactory.getDefault())
      {
        paramJSONObject.a(paramString2.createSocket());
        if ((paramString1.equals("wx577c74fb940daaea")) || (paramString1.equals("wx850d691fd02de8a1")))
        {
          paramString1 = (SSLSocket)paramJSONObject.getSocket();
          paramString2 = paramString1.getSupportedCipherSuites();
          if (paramString2 != null) {
            paramString1.setEnabledCipherSuites(paramString2);
          }
        }
        paramJSONObject.connect();
        c(paramJSONObject);
        paramString1 = new Timer();
        paramString2 = new TimerTask()
        {
          public final void run()
          {
            AppMethodBeat.i(144404);
            ac.e("MicroMsg.AppBrandNetworkWebSocket", "connect response time out");
            paramJSONObject.close();
            k.a(k.this, paramJSONObject);
            parama.KH("connect response time out");
            cancel();
            paramString1.cancel();
            AppMethodBeat.o(144404);
          }
        };
        paramJSONObject.a(paramString1);
        paramString1.schedule(paramString2, paramInt2);
        AppMethodBeat.o(144406);
        return;
      }
    }
    ac.i("MicroMsg.AppBrandNetworkWebSocket", "url error: %s not ws:// or wss://", new Object[] { ??? });
    parama.KI("url not ws or wss");
    AppMethodBeat.o(144406);
  }
  
  public final boolean b(e parame)
  {
    AppMethodBeat.i(144411);
    if (parame != null)
    {
      boolean bool = parame.isOpen();
      AppMethodBeat.o(144411);
      return bool;
    }
    AppMethodBeat.o(144411);
    return false;
  }
  
  public final void release()
  {
    AppMethodBeat.i(144414);
    a(NL("0"));
    AppMethodBeat.o(144414);
  }
  
  public static abstract interface a
  {
    public abstract void a(com.tencent.mm.plugin.appbrand.jsapi.c paramc, String paramString, g paramg);
    
    public abstract void d(com.tencent.mm.plugin.appbrand.jsapi.c paramc, String paramString);
  }
  
  public static abstract interface b
  {
    public abstract void KH(String paramString);
    
    public abstract void KI(String paramString);
    
    public abstract void Y(int paramInt, String paramString);
    
    public abstract void bbi();
    
    public abstract void bbj();
    
    public abstract void l(ByteBuffer paramByteBuffer);
  }
  
  public static abstract interface c
  {
    public abstract boolean HA(String paramString);
    
    public abstract boolean aUH();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.p.k
 * JD-Core Version:    0.7.0.1
 */