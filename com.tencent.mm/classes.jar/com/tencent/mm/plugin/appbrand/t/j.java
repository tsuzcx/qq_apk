package com.tencent.mm.plugin.appbrand.t;

import com.tencent.luggage.l.m;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ah.e.h;
import com.tencent.mm.plugin.appbrand.ah.f.b;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.jsapi.websocket.c;
import com.tencent.mm.plugin.appbrand.jsapi.websocket.e.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
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

public final class j
  implements com.tencent.mm.plugin.appbrand.jsapi.websocket.d
{
  private SSLSocketFactory rew;
  private final String sKB;
  private int sKC;
  protected final ArrayList<com.tencent.mm.plugin.appbrand.jsapi.websocket.e> sKY;
  private boolean ton;
  
  public j(a parama)
  {
    AppMethodBeat.i(144405);
    this.sKY = new ArrayList();
    SSLContext localSSLContext = i.a(parama);
    if (localSSLContext != null) {
      this.rew = localSSLContext.getSocketFactory();
    }
    this.sKB = parama.tnh;
    this.sKC = parama.tnd;
    this.ton = parama.epN;
    Log.i("MicroMsg.AppBrandNetworkWebSocket", "mTLSSkipHostnameCheck is %b", new Object[] { Boolean.valueOf(this.ton) });
    AppMethodBeat.o(144405);
  }
  
  private void c(com.tencent.mm.plugin.appbrand.jsapi.websocket.e parame)
  {
    AppMethodBeat.i(144407);
    synchronized (this.sKY)
    {
      if ("0".equals(parame.bQs())) {
        this.sKY.clear();
      }
      this.sKY.add(parame);
      AppMethodBeat.o(144407);
      return;
    }
  }
  
  /* Error */
  private void d(com.tencent.mm.plugin.appbrand.jsapi.websocket.e parame)
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
    //   20: getfield 49	com/tencent/mm/plugin/appbrand/t/j:sKY	Ljava/util/ArrayList;
    //   23: astore_2
    //   24: aload_2
    //   25: monitorenter
    //   26: aload_0
    //   27: getfield 49	com/tencent/mm/plugin/appbrand/t/j:sKY	Ljava/util/ArrayList;
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
    //   0	60	0	this	j
    //   0	60	1	parame	com.tencent.mm.plugin.appbrand.jsapi.websocket.e
    // Exception table:
    //   from	to	target	type
    //   2	7	45	finally
    //   11	16	45	finally
    //   19	26	45	finally
    //   37	42	45	finally
    //   51	60	45	finally
    //   26	37	50	finally
  }
  
  private static void e(com.tencent.mm.plugin.appbrand.jsapi.websocket.e parame)
  {
    AppMethodBeat.i(144415);
    if (parame == null)
    {
      AppMethodBeat.o(144415);
      return;
    }
    Timer localTimer = parame.cxz();
    Log.i("MicroMsg.AppBrandNetworkWebSocket", "try to stop connectTimer");
    if (localTimer != null)
    {
      localTimer.cancel();
      parame.a(null);
    }
    AppMethodBeat.o(144415);
  }
  
  public final void a(com.tencent.mm.plugin.appbrand.jsapi.websocket.e parame)
  {
    AppMethodBeat.i(144409);
    if (parame != null) {}
    try
    {
      Log.i("MicroMsg.AppBrandNetworkWebSocket", "try to close socket");
      parame.close();
      d(parame);
      AppMethodBeat.o(144409);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Log.printErrStackTrace("MicroMsg.AppBrandNetworkWebSocket", localException, "Exception: send error", new Object[0]);
        e(parame);
      }
    }
  }
  
  public final void a(com.tencent.mm.plugin.appbrand.jsapi.websocket.e parame, int paramInt, String paramString)
  {
    AppMethodBeat.i(144410);
    if (parame != null) {}
    try
    {
      Log.i("MicroMsg.AppBrandNetworkWebSocket", "try to close socket");
      parame.cN(paramString, paramInt);
      d(parame);
      AppMethodBeat.o(144410);
      return;
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        Log.printErrStackTrace("MicroMsg.AppBrandNetworkWebSocket", paramString, "Exception: send error", new Object[0]);
      }
    }
  }
  
  public final void a(com.tencent.mm.plugin.appbrand.jsapi.websocket.e parame, String paramString)
  {
    AppMethodBeat.i(144412);
    if (parame != null) {
      parame.acv(paramString);
    }
    AppMethodBeat.o(144412);
  }
  
  public final void a(com.tencent.mm.plugin.appbrand.jsapi.websocket.e parame, ByteBuffer paramByteBuffer)
  {
    AppMethodBeat.i(144413);
    parame.r(paramByteBuffer);
    AppMethodBeat.o(144413);
  }
  
  public final void a(final String paramString1, final String paramString2, int paramInt1, int paramInt2, final JSONObject paramJSONObject, Map<String, String> paramMap, final com.tencent.mm.plugin.appbrand.jsapi.websocket.d.a parama)
  {
    AppMethodBeat.i(144406);
    synchronized (this.sKY)
    {
      if (this.sKY.size() >= this.sKC)
      {
        parama.Yg("max connected");
        Log.i("MicroMsg.AppBrandNetworkWebSocket", "max connected mTaskList.size():%d,mMaxWebsocketConnect:%d", new Object[] { Integer.valueOf(this.sKY.size()), Integer.valueOf(this.sKC) });
        AppMethodBeat.o(144406);
        return;
      }
      ??? = paramJSONObject.optString("url");
    }
    try
    {
      URI localURI = new URI((String)???);
      boolean bool = paramJSONObject.optBoolean("tcpNoDelay", false);
      Log.i("MicroMsg.AppBrandNetworkWebSocket", "connectSocket, url= %s, timeout = %d, tcpNoDelay = %b, taskId=%s", new Object[] { ???, Integer.valueOf(paramInt2), Boolean.valueOf(bool), paramString2 });
      paramMap.put("User-Agent", this.sKB);
      paramJSONObject = i.aD(paramJSONObject);
      if (!Util.isNullOrNil(paramJSONObject))
      {
        Log.i("MicroMsg.AppBrandNetworkWebSocket", "protocols %s", new Object[] { paramJSONObject });
        paramMap.put("Sec-WebSocket-Protocol", paramJSONObject);
      }
      paramJSONObject = i.a(localURI);
      if (!Util.isNullOrNil(paramJSONObject))
      {
        Log.i("MicroMsg.AppBrandNetworkWebSocket", "Origin %s", new Object[] { paramJSONObject });
        paramMap.put("Origin", paramJSONObject);
      }
      try
      {
        paramJSONObject = new c(localURI, new com.tencent.mm.plugin.appbrand.ah.b.d(), paramMap, paramInt2)
        {
          private com.tencent.mm.plugin.appbrand.ah.d.d rex = null;
          
          public final void Yk(String paramAnonymousString)
          {
            AppMethodBeat.i(144398);
            String str = this.val$url;
            if (paramAnonymousString != null) {}
            for (int i = paramAnonymousString.length();; i = -1)
            {
              Log.i("MicroMsg.AppBrandNetworkWebSocket", "url is %s ,socket onmessage length :%d, taskId=%s", new Object[] { str, Integer.valueOf(i), paramString2 });
              parama.abg(paramAnonymousString);
              AppMethodBeat.o(144398);
              return;
            }
          }
          
          public final void a(com.tencent.mm.plugin.appbrand.ah.d.d paramAnonymousd)
          {
            AppMethodBeat.i(144402);
            if ((paramAnonymousd.cOq() != com.tencent.mm.plugin.appbrand.ah.d.d.a.uvf) && (!paramAnonymousd.cOo()))
            {
              this.rex = paramAnonymousd;
              AppMethodBeat.o(144402);
              return;
            }
            if (paramAnonymousd.cOq() == com.tencent.mm.plugin.appbrand.ah.d.d.a.uvf)
            {
              if (this.rex == null)
              {
                AppMethodBeat.o(144402);
                return;
              }
              if (this.rex.cOn().position() > 10485760)
              {
                Log.e("MicroMsg.AppBrandNetworkWebSocket", "Pending Frame exploded");
                this.rex = null;
                AppMethodBeat.o(144402);
                return;
              }
              try
              {
                this.rex.e(paramAnonymousd);
                if (!paramAnonymousd.cOo())
                {
                  AppMethodBeat.o(144402);
                  return;
                }
              }
              catch (Exception localException)
              {
                for (;;)
                {
                  Log.printErrStackTrace("MicroMsg.AppBrandNetworkWebSocket", localException, "Exception: Framedata append fail", new Object[0]);
                }
              }
              if (this.rex.cOq() != com.tencent.mm.plugin.appbrand.ah.d.d.a.uvh) {
                break label177;
              }
              o(this.rex.cOn());
            }
            for (;;)
            {
              this.rex = null;
              AppMethodBeat.o(144402);
              return;
              label177:
              if (this.rex.cOq() == com.tencent.mm.plugin.appbrand.ah.d.d.a.uvg) {
                try
                {
                  Yk(Util.nullAsNil(b.E(this.rex.cOn())));
                }
                catch (Exception paramAnonymousd)
                {
                  Log.printErrStackTrace("MicroMsg.AppBrandNetworkWebSocket", paramAnonymousd, "Exception: stringUtf8 error", new Object[0]);
                }
              }
            }
          }
          
          public final void a(h paramAnonymoush)
          {
            AppMethodBeat.i(144396);
            Log.i("MicroMsg.AppBrandNetworkWebSocket", "url is %s ,state: opened, taskId=%s", new Object[] { this.val$url, paramString2 });
            j.g(this);
            parama.a(paramAnonymoush, null);
            AppMethodBeat.o(144396);
          }
          
          public final void a(e.a paramAnonymousa) {}
          
          public final void aq(int paramAnonymousInt, String paramAnonymousString)
          {
            AppMethodBeat.i(144399);
            Log.i("MicroMsg.AppBrandNetworkWebSocket", "url is %s ,state: closed ,reason: %s, errCode = %d, taskId=%s", new Object[] { this.val$url, paramAnonymousString, Integer.valueOf(paramAnonymousInt), paramString2 });
            j.g(this);
            j.a(j.this, this);
            if ((paramAnonymousInt == -1) || (paramAnonymousInt == -2) || (paramAnonymousInt == -3))
            {
              com.tencent.mm.plugin.appbrand.jsapi.websocket.d.a locala;
              String str;
              if (!NetStatusUtil.isConnected(MMApplicationContext.getContext()))
              {
                locala = parama;
                str = "network is down";
              }
              for (;;)
              {
                locala.Yf(str);
                parama.ap(1006, paramAnonymousString);
                AppMethodBeat.o(144399);
                return;
                locala = parama;
                if (Util.isNullOrNil(paramAnonymousString)) {
                  str = "abnormal closure";
                } else {
                  str = paramAnonymousString;
                }
              }
            }
            parama.ap(paramAnonymousInt, paramAnonymousString);
            AppMethodBeat.o(144399);
          }
          
          public final void b(com.tencent.mm.plugin.appbrand.ah.e.a paramAnonymousa)
          {
            AppMethodBeat.i(144397);
            parama.a(paramAnonymousa);
            AppMethodBeat.o(144397);
          }
          
          public final void f(Exception paramAnonymousException)
          {
            AppMethodBeat.i(144400);
            Log.printErrStackTrace("MicroMsg.AppBrandNetworkWebSocket", paramAnonymousException, "onError Exception: url %s, taskId=%s", new Object[] { this.val$url, paramString2 });
            j.g(this);
            j.a(j.this, this);
            parama.Yf("exception " + paramAnonymousException.getMessage());
            AppMethodBeat.o(144400);
          }
          
          public final void o(ByteBuffer paramAnonymousByteBuffer)
          {
            AppMethodBeat.i(144401);
            String str = this.val$url;
            if (paramAnonymousByteBuffer != null) {}
            for (int i = paramAnonymousByteBuffer.capacity();; i = -1)
            {
              Log.i("MicroMsg.AppBrandNetworkWebSocket", "url is %s , socket onMessage buffer length : %d, taskId=%s", new Object[] { str, Integer.valueOf(i), paramString2 });
              parama.n(paramAnonymousByteBuffer);
              AppMethodBeat.o(144401);
              return;
            }
          }
        };
        paramJSONObject.acu(paramString2);
        paramJSONObject.setTcpNoDelay(bool);
        if (!m.M((String)???, "ws://")) {
          break label476;
        }
        Log.i("MicroMsg.AppBrandNetworkWebSocket", "url is %s ,user ws connect", new Object[] { ??? });
        paramJSONObject.b(new Socket(Proxy.NO_PROXY));
        paramJSONObject.connect();
        c(paramJSONObject);
        paramString1 = new Timer("AppNetSocket");
        paramString2 = new TimerTask()
        {
          public final void run()
          {
            AppMethodBeat.i(144403);
            Log.e("MicroMsg.AppBrandNetworkWebSocket", "connect response time out");
            paramJSONObject.close();
            j.a(j.this, paramJSONObject);
            parama.Yf("connect response time out");
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
        Log.printErrStackTrace("MicroMsg.AppBrandNetworkWebSocket", paramString1, "Exception: url %s", new Object[] { ??? });
        parama.Yf(paramString1.getMessage());
        AppMethodBeat.o(144406);
        return;
      }
      paramString1 = finally;
      AppMethodBeat.o(144406);
      throw paramString1;
    }
    catch (Exception paramString1)
    {
      Log.printErrStackTrace("MicroMsg.AppBrandNetworkWebSocket", paramString1, "Exception: connect fail", new Object[0]);
      parama.Yg("url not well format");
      AppMethodBeat.o(144406);
      return;
    }
    label476:
    if (m.M((String)???, "wss://"))
    {
      Log.i("MicroMsg.AppBrandNetworkWebSocket", "url is %s ,user wss connect", new Object[] { ??? });
      if (this.rew != null) {}
      for (paramString2 = this.rew;; paramString2 = (SSLSocketFactory)SSLSocketFactory.getDefault())
      {
        paramJSONObject.b(paramString2.createSocket());
        if ((paramString1.equals("wx577c74fb940daaea")) || (paramString1.equals("wx850d691fd02de8a1")))
        {
          paramString1 = (SSLSocket)paramJSONObject.cxA();
          paramString2 = paramString1.getSupportedCipherSuites();
          if (paramString2 != null) {
            paramString1.setEnabledCipherSuites(paramString2);
          }
        }
        paramJSONObject.connect();
        c(paramJSONObject);
        paramString1 = new Timer("AppTestSocket");
        paramString2 = new TimerTask()
        {
          public final void run()
          {
            AppMethodBeat.i(144404);
            Log.e("MicroMsg.AppBrandNetworkWebSocket", "connect response time out");
            paramJSONObject.close();
            j.a(j.this, paramJSONObject);
            parama.Yf("connect response time out");
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
    Log.i("MicroMsg.AppBrandNetworkWebSocket", "url error: %s not ws:// or wss://", new Object[] { ??? });
    parama.Yg("url not ws or wss");
    AppMethodBeat.o(144406);
  }
  
  public final com.tencent.mm.plugin.appbrand.jsapi.websocket.e act(String paramString)
  {
    AppMethodBeat.i(144416);
    if (paramString == null)
    {
      AppMethodBeat.o(144416);
      return null;
    }
    synchronized (this.sKY)
    {
      Iterator localIterator = this.sKY.iterator();
      while (localIterator.hasNext())
      {
        com.tencent.mm.plugin.appbrand.jsapi.websocket.e locale = (com.tencent.mm.plugin.appbrand.jsapi.websocket.e)localIterator.next();
        if (paramString.equals(locale.bQs()))
        {
          AppMethodBeat.o(144416);
          return locale;
        }
      }
      AppMethodBeat.o(144416);
      return null;
    }
  }
  
  public final boolean b(com.tencent.mm.plugin.appbrand.jsapi.websocket.e parame)
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
    a(act("0"));
    AppMethodBeat.o(144414);
  }
  
  public static abstract interface a
  {
    public abstract void a(f paramf, String paramString, com.tencent.mm.plugin.appbrand.jsapi.s.e parame);
    
    public abstract void d(f paramf, String paramString);
  }
  
  public static abstract interface b
  {
    public abstract void Yf(String paramString);
    
    public abstract void Yg(String paramString);
    
    public abstract void ap(int paramInt, String paramString);
    
    public abstract void clI();
    
    public abstract void clJ();
    
    public abstract void n(ByteBuffer paramByteBuffer);
  }
  
  public static abstract interface c
  {
    public abstract boolean UG(String paramString);
    
    public abstract boolean cdI();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.t.j
 * JD-Core Version:    0.7.0.1
 */