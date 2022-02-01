package com.tencent.luggage.k.a.c;

import android.graphics.Bitmap;
import android.graphics.SurfaceTexture;
import android.view.MotionEvent;
import com.tencent.luggage.k.a.b.b;
import com.tencent.luggage.k.a.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class a
  implements c
{
  private com.tencent.luggage.k.a.b.c cnS;
  private Map<String, b> cnT;
  private com.tencent.luggage.k.a.c cnU;
  
  public a()
  {
    AppMethodBeat.i(139354);
    this.cnT = new ConcurrentHashMap();
    AppMethodBeat.o(139354);
  }
  
  private String EE()
  {
    AppMethodBeat.i(139355);
    String str = String.format(Locale.US, "%s(%s)", new Object[] { "MicroMsg.SameLayer.DefaultExtendPluginClientProxy", Integer.valueOf(hashCode()) });
    AppMethodBeat.o(139355);
    return str;
  }
  
  /* Error */
  private b c(String paramString1, int paramInt, String paramString2)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 65
    //   4: invokestatic 24	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: aload_0
    //   8: getfield 29	com/tencent/luggage/k/a/c/a:cnT	Ljava/util/Map;
    //   11: aload_3
    //   12: invokeinterface 71 2 0
    //   17: checkcast 73	com/tencent/luggage/k/a/b/b
    //   20: astore 5
    //   22: aload 5
    //   24: astore 4
    //   26: aload 5
    //   28: ifnonnull +113 -> 141
    //   31: aload_0
    //   32: invokespecial 75	com/tencent/luggage/k/a/c/a:EE	()Ljava/lang/String;
    //   35: ldc 77
    //   37: iconst_1
    //   38: anewarray 4	java/lang/Object
    //   41: dup
    //   42: iconst_0
    //   43: aload_3
    //   44: aastore
    //   45: invokestatic 83	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   48: aload 5
    //   50: astore 4
    //   52: aload_0
    //   53: getfield 85	com/tencent/luggage/k/a/c/a:cnS	Lcom/tencent/luggage/k/a/b/c;
    //   56: ifnull +85 -> 141
    //   59: aload_0
    //   60: getfield 85	com/tencent/luggage/k/a/c/a:cnS	Lcom/tencent/luggage/k/a/b/c;
    //   63: aload_1
    //   64: invokeinterface 91 2 0
    //   69: astore 4
    //   71: aload 4
    //   73: ifnull +78 -> 151
    //   76: aload_0
    //   77: invokespecial 75	com/tencent/luggage/k/a/c/a:EE	()Ljava/lang/String;
    //   80: ldc 93
    //   82: iconst_2
    //   83: anewarray 4	java/lang/Object
    //   86: dup
    //   87: iconst_0
    //   88: aload_3
    //   89: aastore
    //   90: dup
    //   91: iconst_1
    //   92: aload 4
    //   94: invokevirtual 50	java/lang/Object:hashCode	()I
    //   97: invokestatic 56	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   100: aastore
    //   101: invokestatic 96	com/tencent/mm/sdk/platformtools/ad:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   104: aload 4
    //   106: iload_2
    //   107: invokeinterface 99 2 0
    //   112: aload 4
    //   114: aload_1
    //   115: invokeinterface 103 2 0
    //   120: aload 4
    //   122: aload_0
    //   123: invokeinterface 107 2 0
    //   128: aload_0
    //   129: getfield 29	com/tencent/luggage/k/a/c/a:cnT	Ljava/util/Map;
    //   132: aload_3
    //   133: aload 4
    //   135: invokeinterface 111 3 0
    //   140: pop
    //   141: ldc 65
    //   143: invokestatic 32	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   146: aload_0
    //   147: monitorexit
    //   148: aload 4
    //   150: areturn
    //   151: aload_0
    //   152: invokespecial 75	com/tencent/luggage/k/a/c/a:EE	()Ljava/lang/String;
    //   155: ldc 113
    //   157: iconst_1
    //   158: anewarray 4	java/lang/Object
    //   161: dup
    //   162: iconst_0
    //   163: aload_3
    //   164: aastore
    //   165: invokestatic 83	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   168: goto -27 -> 141
    //   171: astore_1
    //   172: aload_0
    //   173: monitorexit
    //   174: aload_1
    //   175: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	176	0	this	a
    //   0	176	1	paramString1	String
    //   0	176	2	paramInt	int
    //   0	176	3	paramString2	String
    //   24	125	4	localb1	b
    //   20	29	5	localb2	b
    // Exception table:
    //   from	to	target	type
    //   2	22	171	finally
    //   31	48	171	finally
    //   52	71	171	finally
    //   76	141	171	finally
    //   141	146	171	finally
    //   151	168	171	finally
  }
  
  public final com.tencent.luggage.k.a.c FJ()
  {
    return this.cnU;
  }
  
  public final String a(String paramString, int paramInt, com.tencent.luggage.k.a.a parama)
  {
    AppMethodBeat.i(139356);
    String str = d.l(paramString, paramInt);
    ad.i(EE(), "handleJsApi, key:%s, jsapi:%s", new Object[] { str, parama.EC() });
    paramString = c(paramString, paramInt, str);
    if (paramString == null)
    {
      ad.w(EE(), "handleJsApi, key:%s, handler is null", new Object[] { str });
      AppMethodBeat.o(139356);
      return "";
    }
    if (paramString.h(parama))
    {
      if (parama.EA())
      {
        paramString = paramString.i(parama);
        AppMethodBeat.o(139356);
        return paramString;
      }
      paramString.i(parama);
      AppMethodBeat.o(139356);
      return "";
    }
    if (parama.EA())
    {
      paramString = parama.cD("ok");
      AppMethodBeat.o(139356);
      return paramString;
    }
    AppMethodBeat.o(139356);
    return "";
  }
  
  public final void a(com.tencent.luggage.k.a.b.c paramc)
  {
    this.cnS = paramc;
  }
  
  public final void a(com.tencent.luggage.k.a.c paramc)
  {
    this.cnU = paramc;
  }
  
  public final void m(String paramString, int paramInt)
  {
    try
    {
      AppMethodBeat.i(195031);
      paramString = d.l(paramString, paramInt);
      ad.i(EE(), "removePlugin, key:%s", new Object[] { paramString });
      this.cnT.remove(paramString);
      AppMethodBeat.o(195031);
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public final void onPluginDestroy(String paramString, int paramInt)
  {
    AppMethodBeat.i(139358);
    String str = d.l(paramString, paramInt);
    ad.i(EE(), "onPluginDestroy, key:%s", new Object[] { str });
    paramString = c(paramString, paramInt, str);
    if (paramString == null)
    {
      ad.w(EE(), "onPluginDestroy, key:%s, handler is null", new Object[] { str });
      AppMethodBeat.o(139358);
      return;
    }
    paramString.EY();
    AppMethodBeat.o(139358);
  }
  
  public final void onPluginReady(String paramString, int paramInt, SurfaceTexture paramSurfaceTexture)
  {
    AppMethodBeat.i(139357);
    String str = d.l(paramString, paramInt);
    ad.i(EE(), "onPluginReady, key:%s", new Object[] { str });
    paramString = c(paramString, paramInt, str);
    if (paramString == null)
    {
      ad.w(EE(), "onPluginReady, key:%s, handler is null", new Object[] { str });
      AppMethodBeat.o(139357);
      return;
    }
    ad.i(EE(), "onPluginReady, key:%s, handler is ready", new Object[] { str });
    paramString.e(paramSurfaceTexture);
    AppMethodBeat.o(139357);
  }
  
  public final void onPluginScreenshotTaken(String paramString, int paramInt, Bitmap paramBitmap)
  {
    AppMethodBeat.i(178851);
    String str = d.l(paramString, paramInt);
    ad.v(EE(), "onPluginScreenshotTaken, key:%s", new Object[] { str });
    paramString = c(paramString, paramInt, str);
    if (paramString == null)
    {
      ad.w(EE(), "onPluginScreenshotTaken, key:%s, handler is null", new Object[] { str });
      AppMethodBeat.o(178851);
      return;
    }
    paramString.r(paramBitmap);
    AppMethodBeat.o(178851);
  }
  
  public final void onPluginTouch(String paramString, int paramInt, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(139359);
    String str = d.l(paramString, paramInt);
    ad.v(EE(), "onPluginTouch, key:%s", new Object[] { str });
    paramString = c(paramString, paramInt, str);
    if (paramString == null)
    {
      ad.w(EE(), "onPluginTouch, key:%s, handler is null", new Object[] { str });
      AppMethodBeat.o(139359);
      return;
    }
    paramString.n(paramMotionEvent);
    AppMethodBeat.o(139359);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.luggage.k.a.c.a
 * JD-Core Version:    0.7.0.1
 */