package com.tencent.mm.plugin.appbrand.jsapi.websocket;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.m.j;
import com.tencent.mm.plugin.appbrand.t.r;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.net.URI;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Timer;
import org.json.JSONObject;

public final class a
  implements d
{
  private final String igf;
  private int igg;
  private com.tencent.mm.plugin.appbrand.m.a igh;
  
  public a(com.tencent.mm.plugin.appbrand.m.a parama)
  {
    this.igf = parama.isv;
    this.igg = parama.isr;
    this.igh = parama;
  }
  
  private static void c(e parame)
  {
    AppMethodBeat.i(108094);
    synchronized (igD)
    {
      if ("0".equals(parame.aAR())) {
        igD.clear();
      }
      igD.add(parame);
      AppMethodBeat.o(108094);
      return;
    }
  }
  
  /* Error */
  private void d(e parame)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 77
    //   4: invokestatic 41	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: aload_1
    //   8: ifnonnull +11 -> 19
    //   11: ldc 77
    //   13: invokestatic 48	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   16: aload_0
    //   17: monitorexit
    //   18: return
    //   19: getstatic 54	com/tencent/mm/plugin/appbrand/jsapi/websocket/a:igD	Ljava/util/ArrayList;
    //   22: astore_2
    //   23: aload_2
    //   24: monitorenter
    //   25: getstatic 54	com/tencent/mm/plugin/appbrand/jsapi/websocket/a:igD	Ljava/util/ArrayList;
    //   28: aload_1
    //   29: invokevirtual 80	java/util/ArrayList:remove	(Ljava/lang/Object;)Z
    //   32: pop
    //   33: aload_2
    //   34: monitorexit
    //   35: ldc 77
    //   37: invokestatic 48	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   40: goto -24 -> 16
    //   43: astore_1
    //   44: aload_0
    //   45: monitorexit
    //   46: aload_1
    //   47: athrow
    //   48: astore_1
    //   49: aload_2
    //   50: monitorexit
    //   51: ldc 77
    //   53: invokestatic 48	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
    AppMethodBeat.i(108096);
    if (parame == null)
    {
      AppMethodBeat.o(108096);
      return;
    }
    Timer localTimer = parame.aGh();
    ab.i("MicroMsg.AppBrandNetworkWcWssSocket", "try to stop connectTimer");
    if (localTimer != null)
    {
      localTimer.cancel();
      parame.a(null);
    }
    AppMethodBeat.o(108096);
  }
  
  public final e CX(String paramString)
  {
    AppMethodBeat.i(108093);
    if (paramString == null)
    {
      AppMethodBeat.o(108093);
      return null;
    }
    synchronized (igD)
    {
      Iterator localIterator = igD.iterator();
      while (localIterator.hasNext())
      {
        e locale = (e)localIterator.next();
        if (paramString.equals(locale.aAR()))
        {
          AppMethodBeat.o(108093);
          return locale;
        }
      }
      AppMethodBeat.o(108093);
      return null;
    }
  }
  
  public final void a(e parame)
  {
    AppMethodBeat.i(108088);
    if (parame != null) {}
    try
    {
      ab.i("MicroMsg.AppBrandNetworkWcWssSocket", "try to close socket");
      parame.close();
      d(parame);
      AppMethodBeat.o(108088);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ab.printErrStackTrace("MicroMsg.AppBrandNetworkWcWssSocket", localException, "send error Exception", new Object[0]);
        e(parame);
      }
    }
  }
  
  public final void a(e parame, int paramInt, String paramString)
  {
    AppMethodBeat.i(108089);
    if (parame != null) {}
    try
    {
      ab.i("MicroMsg.AppBrandNetworkWcWssSocket", "try to close socket code:%d,reason:%s", new Object[] { Integer.valueOf(paramInt), paramString });
      parame.bj(paramString, paramInt);
      d(parame);
      AppMethodBeat.o(108089);
      return;
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        ab.printErrStackTrace("MicroMsg.AppBrandNetworkWcWssSocket", paramString, "send error Exception", new Object[0]);
      }
    }
  }
  
  public final void a(e parame, String paramString)
  {
    AppMethodBeat.i(108091);
    if (parame != null) {
      parame.CZ(paramString);
    }
    AppMethodBeat.o(108091);
  }
  
  public final void a(e parame, ByteBuffer paramByteBuffer)
  {
    AppMethodBeat.i(108092);
    if (parame != null) {
      parame.l(paramByteBuffer);
    }
    AppMethodBeat.o(108092);
  }
  
  public final void a(String paramString1, String paramString2, int paramInt1, int paramInt2, JSONObject paramJSONObject, Map<String, String> paramMap, d.a parama)
  {
    AppMethodBeat.i(108087);
    synchronized (igD)
    {
      if (igD.size() >= this.igg)
      {
        parama.AN("max connected");
        ab.i("MicroMsg.AppBrandNetworkWcWssSocket", "max connected mTaskList.size():%d,mMaxWebsocketConnect:%d", new Object[] { Integer.valueOf(igD.size()), Integer.valueOf(this.igg) });
        AppMethodBeat.o(108087);
        return;
      }
      ??? = paramJSONObject.optString("url");
    }
    try
    {
      URI localURI = new URI((String)???);
      boolean bool2 = paramJSONObject.optBoolean("tcpNoDelay", false);
      boolean bool3 = paramJSONObject.optBoolean("perMessageDeflate", false);
      paramMap.put("User-Agent", this.igf);
      paramJSONObject = j.L(paramJSONObject);
      if (!bo.isNullOrNil(paramJSONObject))
      {
        ab.i("MicroMsg.AppBrandNetworkWcWssSocket", "protocols %s", new Object[] { paramJSONObject });
        paramMap.put("Sec-WebSocket-Protocol", paramJSONObject);
      }
      paramJSONObject = j.a(localURI);
      if (!bo.isNullOrNil(paramJSONObject))
      {
        ab.i("MicroMsg.AppBrandNetworkWcWssSocket", "Origin %s", new Object[] { paramJSONObject });
        paramMap.put("Origin", paramJSONObject);
      }
      boolean bool1 = false;
      if (r.x((String)???, "ws://")) {
        bool1 = true;
      }
      ab.i("MicroMsg.AppBrandNetworkWcWssSocket", "connectSocket, taskId=%s, url= %s, appType = %d, timeout = %d, tcpNoDelay = %b, skipDimain = %b, perMessageDeflate = %b", new Object[] { paramString2, ???, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Boolean.valueOf(bool2), Boolean.valueOf(bool1), Boolean.valueOf(bool3) });
      try
      {
        paramString1 = new b(paramString1, (String)???, localURI, paramMap, new WssConfig(paramInt2, paramInt2, bool2, bool1, paramInt1, bool3), new ArrayList(), this.igh);
        paramString1.a(new a.1(this, paramString2, paramString1, parama, (String)???));
        paramString1.CY(paramString2);
        if ((!r.x((String)???, "ws://")) && (!r.x((String)???, "wss://"))) {
          break label520;
        }
        paramString2 = new Timer();
        paramJSONObject = new a.2(this, paramString1, parama, paramString2);
        c(paramString1);
        paramString1.a(paramString2);
        paramString2.schedule(paramJSONObject, paramInt2);
        paramString1.connect();
        AppMethodBeat.o(108087);
        return;
      }
      catch (Exception paramString1)
      {
        ab.printErrStackTrace("MicroMsg.AppBrandNetworkWcWssSocket", paramString1, "Exception: url %s", new Object[] { ??? });
        parama.AM(paramString1.getMessage());
        AppMethodBeat.o(108087);
        return;
      }
      paramString1 = finally;
      AppMethodBeat.o(108087);
      throw paramString1;
    }
    catch (Exception paramString1)
    {
      ab.printErrStackTrace("MicroMsg.AppBrandNetworkWcWssSocket", paramString1, "connect fail Exception", new Object[0]);
      parama.AN("url not well format");
      AppMethodBeat.o(108087);
      return;
    }
    label520:
    ab.w("MicroMsg.AppBrandNetworkWcWssSocket", "url error: %s not ws:// or wss://", new Object[] { ??? });
    parama.AN("url not ws or wss");
    AppMethodBeat.o(108087);
  }
  
  public final boolean b(e parame)
  {
    AppMethodBeat.i(108090);
    if (parame != null)
    {
      boolean bool = parame.isOpen();
      AppMethodBeat.o(108090);
      return bool;
    }
    AppMethodBeat.o(108090);
    return false;
  }
  
  public final void release()
  {
    AppMethodBeat.i(108086);
    a(CX("0"));
    AppMethodBeat.o(108086);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.websocket.a
 * JD-Core Version:    0.7.0.1
 */