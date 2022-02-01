package com.tencent.mm.plugin.appbrand.o;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.websocket.e.a;
import com.tencent.mm.plugin.appbrand.utils.y;
import com.tencent.mm.plugin.appbrand.z.e.h;
import com.tencent.mm.plugin.appbrand.z.f.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.az;
import com.tencent.mm.sdk.platformtools.bu;
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
  private SSLSocketFactory kfk;
  private final String lza;
  private int lzb;
  protected final ArrayList<com.tencent.mm.plugin.appbrand.jsapi.websocket.e> lzx;
  private boolean mbc;
  
  public k(a parama)
  {
    AppMethodBeat.i(144405);
    this.lzx = new ArrayList();
    SSLContext localSSLContext = j.a(parama);
    if (localSSLContext != null) {
      this.kfk = localSSLContext.getSocketFactory();
    }
    this.lza = parama.lZX;
    this.lzb = parama.lZT;
    this.mbc = parama.cmU;
    ae.i("MicroMsg.AppBrandNetworkWebSocket", "mTLSSkipHostnameCheck is %b", new Object[] { Boolean.valueOf(this.mbc) });
    AppMethodBeat.o(144405);
  }
  
  private void c(com.tencent.mm.plugin.appbrand.jsapi.websocket.e parame)
  {
    AppMethodBeat.i(144407);
    synchronized (this.lzx)
    {
      if ("0".equals(parame.aOZ())) {
        this.lzx.clear();
      }
      this.lzx.add(parame);
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
    //   20: getfield 49	com/tencent/mm/plugin/appbrand/o/k:lzx	Ljava/util/ArrayList;
    //   23: astore_2
    //   24: aload_2
    //   25: monitorenter
    //   26: aload_0
    //   27: getfield 49	com/tencent/mm/plugin/appbrand/o/k:lzx	Ljava/util/ArrayList;
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
    //   0	60	1	parame	com.tencent.mm.plugin.appbrand.jsapi.websocket.e
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
  
  private static void e(com.tencent.mm.plugin.appbrand.jsapi.websocket.e parame)
  {
    AppMethodBeat.i(144415);
    if (parame == null)
    {
      AppMethodBeat.o(144415);
      return;
    }
    Timer localTimer = parame.bpH();
    ae.i("MicroMsg.AppBrandNetworkWebSocket", "try to stop connectTimer");
    if (localTimer != null)
    {
      localTimer.cancel();
      parame.a(null);
    }
    AppMethodBeat.o(144415);
  }
  
  public final com.tencent.mm.plugin.appbrand.jsapi.websocket.e RT(String paramString)
  {
    AppMethodBeat.i(144416);
    if (paramString == null)
    {
      AppMethodBeat.o(144416);
      return null;
    }
    synchronized (this.lzx)
    {
      Iterator localIterator = this.lzx.iterator();
      while (localIterator.hasNext())
      {
        com.tencent.mm.plugin.appbrand.jsapi.websocket.e locale = (com.tencent.mm.plugin.appbrand.jsapi.websocket.e)localIterator.next();
        if (paramString.equals(locale.aOZ()))
        {
          AppMethodBeat.o(144416);
          return locale;
        }
      }
      AppMethodBeat.o(144416);
      return null;
    }
  }
  
  public final void a(com.tencent.mm.plugin.appbrand.jsapi.websocket.e parame)
  {
    AppMethodBeat.i(144409);
    if (parame != null) {}
    try
    {
      ae.i("MicroMsg.AppBrandNetworkWebSocket", "try to close socket");
      parame.close();
      d(parame);
      AppMethodBeat.o(144409);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ae.printErrStackTrace("MicroMsg.AppBrandNetworkWebSocket", localException, "Exception: send error", new Object[0]);
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
      ae.i("MicroMsg.AppBrandNetworkWebSocket", "try to close socket");
      parame.bL(paramString, paramInt);
      d(parame);
      AppMethodBeat.o(144410);
      return;
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        ae.printErrStackTrace("MicroMsg.AppBrandNetworkWebSocket", paramString, "Exception: send error", new Object[0]);
      }
    }
  }
  
  public final void a(com.tencent.mm.plugin.appbrand.jsapi.websocket.e parame, String paramString)
  {
    AppMethodBeat.i(144412);
    if (parame != null) {
      parame.RV(paramString);
    }
    AppMethodBeat.o(144412);
  }
  
  public final void a(com.tencent.mm.plugin.appbrand.jsapi.websocket.e parame, ByteBuffer paramByteBuffer)
  {
    AppMethodBeat.i(144413);
    parame.o(paramByteBuffer);
    AppMethodBeat.o(144413);
  }
  
  public final void a(final String paramString1, final String paramString2, int paramInt1, int paramInt2, final JSONObject paramJSONObject, Map<String, String> paramMap, final com.tencent.mm.plugin.appbrand.jsapi.websocket.d.a parama)
  {
    AppMethodBeat.i(144406);
    synchronized (this.lzx)
    {
      if (this.lzx.size() >= this.lzb)
      {
        parama.OJ("max connected");
        ae.i("MicroMsg.AppBrandNetworkWebSocket", "max connected mTaskList.size():%d,mMaxWebsocketConnect:%d", new Object[] { Integer.valueOf(this.lzx.size()), Integer.valueOf(this.lzb) });
        AppMethodBeat.o(144406);
        return;
      }
      ??? = paramJSONObject.optString("url");
    }
    try
    {
      URI localURI = new URI((String)???);
      boolean bool = paramJSONObject.optBoolean("tcpNoDelay", false);
      ae.i("MicroMsg.AppBrandNetworkWebSocket", "connectSocket, url= %s, timeout = %d, tcpNoDelay = %b, taskId=%s", new Object[] { ???, Integer.valueOf(paramInt2), Boolean.valueOf(bool), paramString2 });
      paramMap.put("User-Agent", this.lza);
      paramJSONObject = j.ac(paramJSONObject);
      if (!bu.isNullOrNil(paramJSONObject))
      {
        ae.i("MicroMsg.AppBrandNetworkWebSocket", "protocols %s", new Object[] { paramJSONObject });
        paramMap.put("Sec-WebSocket-Protocol", paramJSONObject);
      }
      paramJSONObject = j.a(localURI);
      if (!bu.isNullOrNil(paramJSONObject))
      {
        ae.i("MicroMsg.AppBrandNetworkWebSocket", "Origin %s", new Object[] { paramJSONObject });
        paramMap.put("Origin", paramJSONObject);
      }
      try
      {
        paramJSONObject = new com.tencent.mm.plugin.appbrand.jsapi.websocket.c(localURI, new com.tencent.mm.plugin.appbrand.z.b.d(), paramMap, paramInt2)
        {
          private com.tencent.mm.plugin.appbrand.z.d.d kfl = null;
          
          public final void ON(String paramAnonymousString)
          {
            AppMethodBeat.i(144398);
            String str = this.val$url;
            if (paramAnonymousString != null) {}
            for (int i = paramAnonymousString.length();; i = -1)
            {
              ae.i("MicroMsg.AppBrandNetworkWebSocket", "url is %s ,socket onmessage length :%d, taskId=%s", new Object[] { str, Integer.valueOf(i), paramString2 });
              parama.QQ(paramAnonymousString);
              AppMethodBeat.o(144398);
              return;
            }
          }
          
          public final void a(e.a paramAnonymousa) {}
          
          public final void a(com.tencent.mm.plugin.appbrand.z.d.d paramAnonymousd)
          {
            AppMethodBeat.i(144402);
            if ((paramAnonymousd.bCG() != com.tencent.mm.plugin.appbrand.z.d.d.a.mWj) && (!paramAnonymousd.bCE()))
            {
              this.kfl = paramAnonymousd;
              AppMethodBeat.o(144402);
              return;
            }
            if (paramAnonymousd.bCG() == com.tencent.mm.plugin.appbrand.z.d.d.a.mWj)
            {
              if (this.kfl == null)
              {
                AppMethodBeat.o(144402);
                return;
              }
              if (this.kfl.bCD().position() > 10485760)
              {
                ae.e("MicroMsg.AppBrandNetworkWebSocket", "Pending Frame exploded");
                this.kfl = null;
                AppMethodBeat.o(144402);
                return;
              }
              try
              {
                this.kfl.e(paramAnonymousd);
                if (!paramAnonymousd.bCE())
                {
                  AppMethodBeat.o(144402);
                  return;
                }
              }
              catch (Exception localException)
              {
                for (;;)
                {
                  ae.printErrStackTrace("MicroMsg.AppBrandNetworkWebSocket", localException, "Exception: Framedata append fail", new Object[0]);
                }
              }
              if (this.kfl.bCG() != com.tencent.mm.plugin.appbrand.z.d.d.a.mWl) {
                break label177;
              }
              l(this.kfl.bCD());
            }
            for (;;)
            {
              this.kfl = null;
              AppMethodBeat.o(144402);
              return;
              label177:
              if (this.kfl.bCG() == com.tencent.mm.plugin.appbrand.z.d.d.a.mWk) {
                try
                {
                  ON(bu.nullAsNil(b.B(this.kfl.bCD())));
                }
                catch (Exception paramAnonymousd)
                {
                  ae.printErrStackTrace("MicroMsg.AppBrandNetworkWebSocket", paramAnonymousd, "Exception: stringUtf8 error", new Object[0]);
                }
              }
            }
          }
          
          public final void a(h paramAnonymoush)
          {
            AppMethodBeat.i(144396);
            ae.i("MicroMsg.AppBrandNetworkWebSocket", "url is %s ,state: opened, taskId=%s", new Object[] { this.val$url, paramString2 });
            k.g(this);
            parama.a(paramAnonymoush, null);
            AppMethodBeat.o(144396);
          }
          
          public final void ab(int paramAnonymousInt, String paramAnonymousString)
          {
            AppMethodBeat.i(144399);
            ae.i("MicroMsg.AppBrandNetworkWebSocket", "url is %s ,state: closed ,reason: %s, errCode = %d, taskId=%s", new Object[] { this.val$url, paramAnonymousString, Integer.valueOf(paramAnonymousInt), paramString2 });
            k.g(this);
            k.a(k.this, this);
            if ((paramAnonymousInt == -1) || (paramAnonymousInt == -2) || (paramAnonymousInt == -3))
            {
              com.tencent.mm.plugin.appbrand.jsapi.websocket.d.a locala;
              String str;
              if (!az.isConnected(ak.getContext()))
              {
                locala = parama;
                str = "network is down";
              }
              for (;;)
              {
                locala.OI(str);
                parama.aa(1006, paramAnonymousString);
                AppMethodBeat.o(144399);
                return;
                locala = parama;
                if (bu.isNullOrNil(paramAnonymousString)) {
                  str = "abnormal closure";
                } else {
                  str = paramAnonymousString;
                }
              }
            }
            parama.aa(paramAnonymousInt, paramAnonymousString);
            AppMethodBeat.o(144399);
          }
          
          public final void b(com.tencent.mm.plugin.appbrand.z.e.a paramAnonymousa)
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
              ae.i("MicroMsg.AppBrandNetworkWebSocket", "url is %s , socket onMessage buffer length : %d, taskId=%s", new Object[] { str, Integer.valueOf(i), paramString2 });
              parama.k(paramAnonymousByteBuffer);
              AppMethodBeat.o(144401);
              return;
            }
          }
          
          public final void onError(Exception paramAnonymousException)
          {
            AppMethodBeat.i(144400);
            ae.printErrStackTrace("MicroMsg.AppBrandNetworkWebSocket", paramAnonymousException, "onError Exception: url %s, taskId=%s", new Object[] { this.val$url, paramString2 });
            k.g(this);
            k.a(k.this, this);
            parama.OI("exception " + paramAnonymousException.getMessage());
            AppMethodBeat.o(144400);
          }
        };
        paramJSONObject.RU(paramString2);
        paramJSONObject.setTcpNoDelay(bool);
        if (!y.C((String)???, "ws://")) {
          break label477;
        }
        ae.i("MicroMsg.AppBrandNetworkWebSocket", "url is %s ,user ws connect", new Object[] { ??? });
        paramJSONObject.a(new Socket(Proxy.NO_PROXY));
        paramJSONObject.connect();
        c(paramJSONObject);
        paramString1 = new Timer();
        paramString2 = new TimerTask()
        {
          public final void run()
          {
            AppMethodBeat.i(144403);
            ae.e("MicroMsg.AppBrandNetworkWebSocket", "connect response time out");
            paramJSONObject.close();
            k.a(k.this, paramJSONObject);
            parama.OI("connect response time out");
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
        ae.printErrStackTrace("MicroMsg.AppBrandNetworkWebSocket", paramString1, "Exception: url %s", new Object[] { ??? });
        parama.OI(paramString1.getMessage());
        AppMethodBeat.o(144406);
        return;
      }
      paramString1 = finally;
      AppMethodBeat.o(144406);
      throw paramString1;
    }
    catch (Exception paramString1)
    {
      ae.printErrStackTrace("MicroMsg.AppBrandNetworkWebSocket", paramString1, "Exception: connect fail", new Object[0]);
      parama.OJ("url not well format");
      AppMethodBeat.o(144406);
      return;
    }
    label477:
    if (y.C((String)???, "wss://"))
    {
      ae.i("MicroMsg.AppBrandNetworkWebSocket", "url is %s ,user wss connect", new Object[] { ??? });
      if (this.kfk != null) {}
      for (paramString2 = this.kfk;; paramString2 = (SSLSocketFactory)SSLSocketFactory.getDefault())
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
            ae.e("MicroMsg.AppBrandNetworkWebSocket", "connect response time out");
            paramJSONObject.close();
            k.a(k.this, paramJSONObject);
            parama.OI("connect response time out");
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
    ae.i("MicroMsg.AppBrandNetworkWebSocket", "url error: %s not ws:// or wss://", new Object[] { ??? });
    parama.OJ("url not ws or wss");
    AppMethodBeat.o(144406);
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
    a(RT("0"));
    AppMethodBeat.o(144414);
  }
  
  public static abstract interface a
  {
    public abstract void a(com.tencent.mm.plugin.appbrand.jsapi.c paramc, String paramString, com.tencent.mm.plugin.appbrand.jsapi.m.e parame);
    
    public abstract void d(com.tencent.mm.plugin.appbrand.jsapi.c paramc, String paramString);
  }
  
  public static abstract interface b
  {
    public abstract void OI(String paramString);
    
    public abstract void OJ(String paramString);
    
    public abstract void aa(int paramInt, String paramString);
    
    public abstract void bfu();
    
    public abstract void bfv();
    
    public abstract void k(ByteBuffer paramByteBuffer);
  }
  
  public static abstract interface c
  {
    public abstract boolean Ln(String paramString);
    
    public abstract boolean aYm();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.o.k
 * JD-Core Version:    0.7.0.1
 */