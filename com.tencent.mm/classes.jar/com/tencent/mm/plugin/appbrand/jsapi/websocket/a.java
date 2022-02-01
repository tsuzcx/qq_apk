package com.tencent.mm.plugin.appbrand.jsapi.websocket;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.o.j;
import com.tencent.mm.plugin.appbrand.utils.y;
import com.tencent.mm.plugin.appbrand.z.e.h;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.az;
import com.tencent.mm.sdk.platformtools.bu;
import java.net.URI;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import org.json.JSONObject;

public final class a
  implements d
{
  private com.tencent.mm.plugin.appbrand.o.a cnU;
  private final String lza;
  private int lzb;
  
  public a(com.tencent.mm.plugin.appbrand.o.a parama)
  {
    this.lza = parama.lZX;
    this.lzb = parama.lZT;
    this.cnU = parama;
  }
  
  private static void c(e parame)
  {
    AppMethodBeat.i(144261);
    synchronized (lzx)
    {
      if ("0".equals(parame.aOZ())) {
        lzx.clear();
      }
      lzx.add(parame);
      AppMethodBeat.o(144261);
      return;
    }
  }
  
  /* Error */
  private void d(e parame)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 81
    //   4: invokestatic 45	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: aload_1
    //   8: ifnonnull +11 -> 19
    //   11: ldc 81
    //   13: invokestatic 52	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   16: aload_0
    //   17: monitorexit
    //   18: return
    //   19: getstatic 58	com/tencent/mm/plugin/appbrand/jsapi/websocket/a:lzx	Ljava/util/ArrayList;
    //   22: astore_2
    //   23: aload_2
    //   24: monitorenter
    //   25: getstatic 58	com/tencent/mm/plugin/appbrand/jsapi/websocket/a:lzx	Ljava/util/ArrayList;
    //   28: aload_1
    //   29: invokevirtual 84	java/util/ArrayList:remove	(Ljava/lang/Object;)Z
    //   32: pop
    //   33: aload_2
    //   34: monitorexit
    //   35: ldc 81
    //   37: invokestatic 52	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   40: goto -24 -> 16
    //   43: astore_1
    //   44: aload_0
    //   45: monitorexit
    //   46: aload_1
    //   47: athrow
    //   48: astore_1
    //   49: aload_2
    //   50: monitorexit
    //   51: ldc 81
    //   53: invokestatic 52	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   56: aload_1
    //   57: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	58	0	this	a
    //   0	58	1	parame	e
    // Exception table:
    //   from	to	target	type
    //   2	7	43	finally
    //   11	16	43	finally
    //   19	25	43	finally
    //   35	40	43	finally
    //   51	58	43	finally
    //   25	35	48	finally
    //   49	51	48	finally
  }
  
  private static void e(e parame)
  {
    AppMethodBeat.i(144263);
    if (parame == null)
    {
      AppMethodBeat.o(144263);
      return;
    }
    Timer localTimer = parame.bpH();
    ae.i("MicroMsg.AppBrandNetworkWcWssSocket", "try to stop connectTimer");
    if (localTimer != null)
    {
      localTimer.cancel();
      parame.a(null);
    }
    AppMethodBeat.o(144263);
  }
  
  public final e RT(String paramString)
  {
    AppMethodBeat.i(144260);
    if (paramString == null)
    {
      AppMethodBeat.o(144260);
      return null;
    }
    synchronized (lzx)
    {
      Iterator localIterator = lzx.iterator();
      while (localIterator.hasNext())
      {
        e locale = (e)localIterator.next();
        if (paramString.equals(locale.aOZ()))
        {
          AppMethodBeat.o(144260);
          return locale;
        }
      }
      AppMethodBeat.o(144260);
      return null;
    }
  }
  
  public final void a(e parame)
  {
    AppMethodBeat.i(144255);
    if (parame != null) {}
    try
    {
      ae.i("MicroMsg.AppBrandNetworkWcWssSocket", "try to close socket");
      parame.close();
      d(parame);
      AppMethodBeat.o(144255);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ae.printErrStackTrace("MicroMsg.AppBrandNetworkWcWssSocket", localException, "send error Exception", new Object[0]);
        e(parame);
      }
    }
  }
  
  public final void a(e parame, int paramInt, String paramString)
  {
    AppMethodBeat.i(144256);
    if (parame != null) {}
    try
    {
      ae.i("MicroMsg.AppBrandNetworkWcWssSocket", "try to close socket code:%d,reason:%s", new Object[] { Integer.valueOf(paramInt), paramString });
      parame.bL(paramString, paramInt);
      d(parame);
      AppMethodBeat.o(144256);
      return;
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        ae.printErrStackTrace("MicroMsg.AppBrandNetworkWcWssSocket", paramString, "send error Exception", new Object[0]);
      }
    }
  }
  
  public final void a(e parame, String paramString)
  {
    AppMethodBeat.i(144258);
    if (parame != null) {
      parame.RV(paramString);
    }
    AppMethodBeat.o(144258);
  }
  
  public final void a(e parame, ByteBuffer paramByteBuffer)
  {
    AppMethodBeat.i(144259);
    if (parame != null) {
      parame.o(paramByteBuffer);
    }
    AppMethodBeat.o(144259);
  }
  
  public final void a(final String paramString1, final String paramString2, int paramInt1, int paramInt2, JSONObject paramJSONObject, Map<String, String> paramMap, final d.a parama)
  {
    AppMethodBeat.i(144254);
    synchronized (lzx)
    {
      if (lzx.size() >= this.lzb)
      {
        parama.OJ("max connected");
        ae.i("MicroMsg.AppBrandNetworkWcWssSocket", "max connected mTaskList.size():%d,mMaxWebsocketConnect:%d", new Object[] { Integer.valueOf(lzx.size()), Integer.valueOf(this.lzb) });
        AppMethodBeat.o(144254);
        return;
      }
      ??? = paramJSONObject.optString("url");
    }
    try
    {
      URI localURI = new URI((String)???);
      boolean bool2 = paramJSONObject.optBoolean("tcpNoDelay", false);
      boolean bool3 = paramJSONObject.optBoolean("perMessageDeflate", false);
      paramMap.put("User-Agent", this.lza);
      paramJSONObject = j.ac(paramJSONObject);
      if (!bu.isNullOrNil(paramJSONObject))
      {
        ae.i("MicroMsg.AppBrandNetworkWcWssSocket", "protocols %s", new Object[] { paramJSONObject });
        paramMap.put("Sec-WebSocket-Protocol", paramJSONObject);
      }
      paramJSONObject = j.a(localURI);
      if (!bu.isNullOrNil(paramJSONObject))
      {
        ae.i("MicroMsg.AppBrandNetworkWcWssSocket", "Origin %s", new Object[] { paramJSONObject });
        paramMap.put("Origin", paramJSONObject);
      }
      boolean bool1 = false;
      if (y.C((String)???, "ws://")) {
        bool1 = true;
      }
      ae.i("MicroMsg.AppBrandNetworkWcWssSocket", "connectSocket, taskId=%s, url= %s, appType = %d, timeout = %d, tcpNoDelay = %b, skipDimain = %b, perMessageDeflate = %b", new Object[] { paramString2, ???, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Boolean.valueOf(bool2), Boolean.valueOf(bool1), Boolean.valueOf(bool3) });
      try
      {
        paramString1 = new b(paramString1, (String)???, localURI, paramMap, new WssConfig(paramInt2, paramInt2, bool2, bool1, paramInt1, bool3), new ArrayList(), this.cnU);
        paramString1.a(new e.a()
        {
          public final void OI(String paramAnonymousString)
          {
            AppMethodBeat.i(144248);
            ae.e("MicroMsg.AppBrandNetworkWcWssSocket", "onSocketError url is %s ,error is %s,taskId=%s", new Object[] { this.val$url, paramAnonymousString, paramString2 });
            a.f(paramString1);
            a.a(a.this, paramString1);
            parama.OI("exception ".concat(String.valueOf(paramAnonymousString)));
            AppMethodBeat.o(144248);
          }
          
          public final void QQ(String paramAnonymousString)
          {
            AppMethodBeat.i(144249);
            ae.d("MicroMsg.AppBrandNetworkWcWssSocket", "onSocketMessage url is %s ,socket onmessage length :%d,taskId=%s", new Object[] { this.val$url, Integer.valueOf(paramAnonymousString.length()), paramString2 });
            parama.QQ(paramAnonymousString);
            AppMethodBeat.o(144249);
          }
          
          public final void a(com.tencent.mm.plugin.appbrand.z.e.a paramAnonymousa)
          {
            AppMethodBeat.i(144247);
            ae.i("MicroMsg.AppBrandNetworkWcWssSocket", "onWebsocketHandshakeSentAsClient");
            parama.a(paramAnonymousa);
            AppMethodBeat.o(144247);
          }
          
          public final void a(h paramAnonymoush, Map<String, Long> paramAnonymousMap)
          {
            AppMethodBeat.i(175386);
            ae.i("MicroMsg.AppBrandNetworkWcWssSocket", "onSocketOpen taskId=%s", new Object[] { paramString2 });
            a.f(paramString1);
            parama.a(paramAnonymoush, paramAnonymousMap);
            AppMethodBeat.o(175386);
          }
          
          public final void aa(int paramAnonymousInt, String paramAnonymousString)
          {
            AppMethodBeat.i(144251);
            ae.i("MicroMsg.AppBrandNetworkWcWssSocket", "onSocketClose url is %s ,state: closed ,reason: %s, errCode = %d,taskId=%s", new Object[] { this.val$url, paramAnonymousString, Integer.valueOf(paramAnonymousInt), paramString2 });
            a.f(paramString1);
            a.a(a.this, paramString1);
            if (paramAnonymousInt == -1)
            {
              d.a locala;
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
                AppMethodBeat.o(144251);
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
            AppMethodBeat.o(144251);
          }
          
          public final void k(ByteBuffer paramAnonymousByteBuffer)
          {
            AppMethodBeat.i(144250);
            String str = this.val$url;
            if (paramAnonymousByteBuffer != null) {}
            for (int i = paramAnonymousByteBuffer.capacity();; i = -1)
            {
              ae.d("MicroMsg.AppBrandNetworkWcWssSocket", "onSocketMessage url is %s , socket onMessage buffer length : %d,taskId=%s", new Object[] { str, Integer.valueOf(i), paramString2 });
              parama.k(paramAnonymousByteBuffer);
              AppMethodBeat.o(144250);
              return;
            }
          }
        });
        paramString1.RU(paramString2);
        if ((!y.C((String)???, "ws://")) && (!y.C((String)???, "wss://"))) {
          break label520;
        }
        paramString2 = new Timer();
        paramJSONObject = new TimerTask()
        {
          public final void run()
          {
            AppMethodBeat.i(144252);
            ae.e("MicroMsg.AppBrandNetworkWcWssSocket", "connect response time out taskid:%s", new Object[] { paramString1.aOZ() });
            parama.OI("connect response time out");
            paramString1.close();
            a.a(a.this, paramString1);
            cancel();
            paramString2.cancel();
            AppMethodBeat.o(144252);
          }
        };
        c(paramString1);
        paramString1.a(paramString2);
        paramString2.schedule(paramJSONObject, paramInt2);
        paramString1.connect();
        AppMethodBeat.o(144254);
        return;
      }
      catch (Exception paramString1)
      {
        ae.printErrStackTrace("MicroMsg.AppBrandNetworkWcWssSocket", paramString1, "Exception: url %s", new Object[] { ??? });
        parama.OI(paramString1.getMessage());
        AppMethodBeat.o(144254);
        return;
      }
      paramString1 = finally;
      AppMethodBeat.o(144254);
      throw paramString1;
    }
    catch (Exception paramString1)
    {
      ae.printErrStackTrace("MicroMsg.AppBrandNetworkWcWssSocket", paramString1, "connect fail Exception", new Object[0]);
      parama.OJ("url not well format");
      AppMethodBeat.o(144254);
      return;
    }
    label520:
    ae.w("MicroMsg.AppBrandNetworkWcWssSocket", "url error: %s not ws:// or wss://", new Object[] { ??? });
    parama.OJ("url not ws or wss");
    AppMethodBeat.o(144254);
  }
  
  public final boolean b(e parame)
  {
    AppMethodBeat.i(144257);
    if (parame != null)
    {
      boolean bool = parame.isOpen();
      AppMethodBeat.o(144257);
      return bool;
    }
    AppMethodBeat.o(144257);
    return false;
  }
  
  public final void release()
  {
    AppMethodBeat.i(144253);
    a(RT("0"));
    AppMethodBeat.o(144253);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.websocket.a
 * JD-Core Version:    0.7.0.1
 */