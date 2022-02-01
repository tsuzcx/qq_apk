package com.tencent.mm.plugin.appbrand.s;

import com.tencent.luggage.h.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ae.e.h;
import com.tencent.mm.plugin.appbrand.ae.f.b;
import com.tencent.mm.plugin.appbrand.jsapi.websocket.c;
import com.tencent.mm.plugin.appbrand.jsapi.websocket.e;
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

public final class k
  implements com.tencent.mm.plugin.appbrand.jsapi.websocket.d
{
  private SSLSocketFactory liT;
  protected final ArrayList<e> mGL;
  private final String mGo;
  private int mGp;
  private boolean niN;
  
  public k(a parama)
  {
    AppMethodBeat.i(144405);
    this.mGL = new ArrayList();
    SSLContext localSSLContext = j.a(parama);
    if (localSSLContext != null) {
      this.liT = localSSLContext.getSocketFactory();
    }
    this.mGo = parama.nhM;
    this.mGp = parama.nhI;
    this.niN = parama.cyQ;
    Log.i("MicroMsg.AppBrandNetworkWebSocket", "mTLSSkipHostnameCheck is %b", new Object[] { Boolean.valueOf(this.niN) });
    AppMethodBeat.o(144405);
  }
  
  private void c(e parame)
  {
    AppMethodBeat.i(144407);
    synchronized (this.mGL)
    {
      if ("0".equals(parame.bjl())) {
        this.mGL.clear();
      }
      this.mGL.add(parame);
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
    //   4: invokestatic 42	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: aload_1
    //   8: ifnonnull +11 -> 19
    //   11: ldc 126
    //   13: invokestatic 96	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   16: aload_0
    //   17: monitorexit
    //   18: return
    //   19: aload_0
    //   20: getfield 47	com/tencent/mm/plugin/appbrand/s/k:mGL	Ljava/util/ArrayList;
    //   23: astore_2
    //   24: aload_2
    //   25: monitorenter
    //   26: aload_0
    //   27: getfield 47	com/tencent/mm/plugin/appbrand/s/k:mGL	Ljava/util/ArrayList;
    //   30: aload_1
    //   31: invokevirtual 129	java/util/ArrayList:remove	(Ljava/lang/Object;)Z
    //   34: pop
    //   35: aload_2
    //   36: monitorexit
    //   37: ldc 126
    //   39: invokestatic 96	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
    //   55: invokestatic 96	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
    Timer localTimer = parame.bLn();
    Log.i("MicroMsg.AppBrandNetworkWebSocket", "try to stop connectTimer");
    if (localTimer != null)
    {
      localTimer.cancel();
      parame.a(null);
    }
    AppMethodBeat.o(144415);
  }
  
  public final void a(e parame)
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
  
  public final void a(e parame, int paramInt, String paramString)
  {
    AppMethodBeat.i(144410);
    if (parame != null) {}
    try
    {
      Log.i("MicroMsg.AppBrandNetworkWebSocket", "try to close socket");
      parame.bQ(paramString, paramInt);
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
  
  public final void a(e parame, String paramString)
  {
    AppMethodBeat.i(144412);
    if (parame != null) {
      parame.abA(paramString);
    }
    AppMethodBeat.o(144412);
  }
  
  public final void a(e parame, ByteBuffer paramByteBuffer)
  {
    AppMethodBeat.i(144413);
    parame.o(paramByteBuffer);
    AppMethodBeat.o(144413);
  }
  
  public final void a(final String paramString1, final String paramString2, int paramInt1, int paramInt2, final JSONObject paramJSONObject, Map<String, String> paramMap, final com.tencent.mm.plugin.appbrand.jsapi.websocket.d.a parama)
  {
    AppMethodBeat.i(144406);
    synchronized (this.mGL)
    {
      if (this.mGL.size() >= this.mGp)
      {
        parama.XU("max connected");
        Log.i("MicroMsg.AppBrandNetworkWebSocket", "max connected mTaskList.size():%d,mMaxWebsocketConnect:%d", new Object[] { Integer.valueOf(this.mGL.size()), Integer.valueOf(this.mGp) });
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
      paramMap.put("User-Agent", this.mGo);
      paramJSONObject = j.ap(paramJSONObject);
      if (!Util.isNullOrNil(paramJSONObject))
      {
        Log.i("MicroMsg.AppBrandNetworkWebSocket", "protocols %s", new Object[] { paramJSONObject });
        paramMap.put("Sec-WebSocket-Protocol", paramJSONObject);
      }
      paramJSONObject = j.a(localURI);
      if (!Util.isNullOrNil(paramJSONObject))
      {
        Log.i("MicroMsg.AppBrandNetworkWebSocket", "Origin %s", new Object[] { paramJSONObject });
        paramMap.put("Origin", paramJSONObject);
      }
      try
      {
        paramJSONObject = new c(localURI, new com.tencent.mm.plugin.appbrand.ae.b.d(), paramMap, paramInt2)
        {
          private com.tencent.mm.plugin.appbrand.ae.d.d liU = null;
          
          public final void XY(String paramAnonymousString)
          {
            AppMethodBeat.i(144398);
            String str = this.val$url;
            if (paramAnonymousString != null) {}
            for (int i = paramAnonymousString.length();; i = -1)
            {
              Log.i("MicroMsg.AppBrandNetworkWebSocket", "url is %s ,socket onmessage length :%d, taskId=%s", new Object[] { str, Integer.valueOf(i), paramString2 });
              parama.aar(paramAnonymousString);
              AppMethodBeat.o(144398);
              return;
            }
          }
          
          public final void a(com.tencent.mm.plugin.appbrand.ae.d.d paramAnonymousd)
          {
            AppMethodBeat.i(144402);
            if ((paramAnonymousd.bZK() != com.tencent.mm.plugin.appbrand.ae.d.d.a.oji) && (!paramAnonymousd.bZI()))
            {
              this.liU = paramAnonymousd;
              AppMethodBeat.o(144402);
              return;
            }
            if (paramAnonymousd.bZK() == com.tencent.mm.plugin.appbrand.ae.d.d.a.oji)
            {
              if (this.liU == null)
              {
                AppMethodBeat.o(144402);
                return;
              }
              if (this.liU.bZH().position() > 10485760)
              {
                Log.e("MicroMsg.AppBrandNetworkWebSocket", "Pending Frame exploded");
                this.liU = null;
                AppMethodBeat.o(144402);
                return;
              }
              try
              {
                this.liU.e(paramAnonymousd);
                if (!paramAnonymousd.bZI())
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
              if (this.liU.bZK() != com.tencent.mm.plugin.appbrand.ae.d.d.a.ojk) {
                break label177;
              }
              l(this.liU.bZH());
            }
            for (;;)
            {
              this.liU = null;
              AppMethodBeat.o(144402);
              return;
              label177:
              if (this.liU.bZK() == com.tencent.mm.plugin.appbrand.ae.d.d.a.ojj) {
                try
                {
                  XY(Util.nullAsNil(b.B(this.liU.bZH())));
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
            k.g(this);
            parama.a(paramAnonymoush, null);
            AppMethodBeat.o(144396);
          }
          
          public final void a(e.a paramAnonymousa) {}
          
          public final void af(int paramAnonymousInt, String paramAnonymousString)
          {
            AppMethodBeat.i(144399);
            Log.i("MicroMsg.AppBrandNetworkWebSocket", "url is %s ,state: closed ,reason: %s, errCode = %d, taskId=%s", new Object[] { this.val$url, paramAnonymousString, Integer.valueOf(paramAnonymousInt), paramString2 });
            k.g(this);
            k.a(k.this, this);
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
                locala.XT(str);
                parama.ae(1006, paramAnonymousString);
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
            parama.ae(paramAnonymousInt, paramAnonymousString);
            AppMethodBeat.o(144399);
          }
          
          public final void b(com.tencent.mm.plugin.appbrand.ae.e.a paramAnonymousa)
          {
            AppMethodBeat.i(144397);
            parama.a(paramAnonymousa);
            AppMethodBeat.o(144397);
          }
          
          public final void l(ByteBuffer paramAnonymousByteBuffer)
          {
            AppMethodBeat.i(144401);
            String str = this.val$url;
            if (paramAnonymousByteBuffer != null) {}
            for (int i = paramAnonymousByteBuffer.capacity();; i = -1)
            {
              Log.i("MicroMsg.AppBrandNetworkWebSocket", "url is %s , socket onMessage buffer length : %d, taskId=%s", new Object[] { str, Integer.valueOf(i), paramString2 });
              parama.k(paramAnonymousByteBuffer);
              AppMethodBeat.o(144401);
              return;
            }
          }
          
          public final void onError(Exception paramAnonymousException)
          {
            AppMethodBeat.i(144400);
            Log.printErrStackTrace("MicroMsg.AppBrandNetworkWebSocket", paramAnonymousException, "onError Exception: url %s, taskId=%s", new Object[] { this.val$url, paramString2 });
            k.g(this);
            k.a(k.this, this);
            parama.XT("exception " + paramAnonymousException.getMessage());
            AppMethodBeat.o(144400);
          }
        };
        paramJSONObject.abz(paramString2);
        paramJSONObject.setTcpNoDelay(bool);
        if (!l.C((String)???, "ws://")) {
          break label473;
        }
        Log.i("MicroMsg.AppBrandNetworkWebSocket", "url is %s ,user ws connect", new Object[] { ??? });
        paramJSONObject.a(new Socket(Proxy.NO_PROXY));
        paramJSONObject.connect();
        c(paramJSONObject);
        paramString1 = new Timer();
        paramString2 = new TimerTask()
        {
          public final void run()
          {
            AppMethodBeat.i(144403);
            Log.e("MicroMsg.AppBrandNetworkWebSocket", "connect response time out");
            paramJSONObject.close();
            k.a(k.this, paramJSONObject);
            parama.XT("connect response time out");
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
        parama.XT(paramString1.getMessage());
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
      parama.XU("url not well format");
      AppMethodBeat.o(144406);
      return;
    }
    label473:
    if (l.C((String)???, "wss://"))
    {
      Log.i("MicroMsg.AppBrandNetworkWebSocket", "url is %s ,user wss connect", new Object[] { ??? });
      if (this.liT != null) {}
      for (paramString2 = this.liT;; paramString2 = (SSLSocketFactory)SSLSocketFactory.getDefault())
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
            Log.e("MicroMsg.AppBrandNetworkWebSocket", "connect response time out");
            paramJSONObject.close();
            k.a(k.this, paramJSONObject);
            parama.XT("connect response time out");
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
    parama.XU("url not ws or wss");
    AppMethodBeat.o(144406);
  }
  
  public final e aby(String paramString)
  {
    AppMethodBeat.i(144416);
    if (paramString == null)
    {
      AppMethodBeat.o(144416);
      return null;
    }
    synchronized (this.mGL)
    {
      Iterator localIterator = this.mGL.iterator();
      while (localIterator.hasNext())
      {
        e locale = (e)localIterator.next();
        if (paramString.equals(locale.bjl()))
        {
          AppMethodBeat.o(144416);
          return locale;
        }
      }
      AppMethodBeat.o(144416);
      return null;
    }
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
    a(aby("0"));
    AppMethodBeat.o(144414);
  }
  
  public static abstract interface b
  {
    public abstract void XT(String paramString);
    
    public abstract void XU(String paramString);
    
    public abstract void ae(int paramInt, String paramString);
    
    public abstract void bAN();
    
    public abstract void bAO();
    
    public abstract void k(ByteBuffer paramByteBuffer);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.s.k
 * JD-Core Version:    0.7.0.1
 */