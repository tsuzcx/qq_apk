package com.tencent.luggage.k.a.c;

import android.graphics.Bitmap;
import android.graphics.SurfaceTexture;
import android.view.MotionEvent;
import com.tencent.luggage.k.a.b.b;
import com.tencent.luggage.k.a.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ac;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class a
  implements c
{
  private com.tencent.luggage.k.a.b.c ckU;
  private Map<String, b> ckV;
  private com.tencent.luggage.k.a.c ckW;
  
  public a()
  {
    AppMethodBeat.i(139354);
    this.ckV = new ConcurrentHashMap();
    AppMethodBeat.o(139354);
  }
  
  /* Error */
  private b c(String paramString1, int paramInt, String paramString2)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 36
    //   4: invokestatic 24	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: aload_0
    //   8: getfield 29	com/tencent/luggage/k/a/c/a:ckV	Ljava/util/Map;
    //   11: aload_3
    //   12: invokeinterface 42 2 0
    //   17: checkcast 44	com/tencent/luggage/k/a/b/b
    //   20: astore 5
    //   22: aload 5
    //   24: astore 4
    //   26: aload 5
    //   28: ifnonnull +113 -> 141
    //   31: aload_0
    //   32: invokespecial 48	com/tencent/luggage/k/a/c/a:getLogTag	()Ljava/lang/String;
    //   35: ldc 50
    //   37: iconst_1
    //   38: anewarray 4	java/lang/Object
    //   41: dup
    //   42: iconst_0
    //   43: aload_3
    //   44: aastore
    //   45: invokestatic 56	com/tencent/mm/sdk/platformtools/ac:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   48: aload 5
    //   50: astore 4
    //   52: aload_0
    //   53: getfield 58	com/tencent/luggage/k/a/c/a:ckU	Lcom/tencent/luggage/k/a/b/c;
    //   56: ifnull +85 -> 141
    //   59: aload_0
    //   60: getfield 58	com/tencent/luggage/k/a/c/a:ckU	Lcom/tencent/luggage/k/a/b/c;
    //   63: aload_1
    //   64: invokeinterface 64 2 0
    //   69: astore 4
    //   71: aload 4
    //   73: ifnull +78 -> 151
    //   76: aload_0
    //   77: invokespecial 48	com/tencent/luggage/k/a/c/a:getLogTag	()Ljava/lang/String;
    //   80: ldc 66
    //   82: iconst_2
    //   83: anewarray 4	java/lang/Object
    //   86: dup
    //   87: iconst_0
    //   88: aload_3
    //   89: aastore
    //   90: dup
    //   91: iconst_1
    //   92: aload 4
    //   94: invokevirtual 70	java/lang/Object:hashCode	()I
    //   97: invokestatic 76	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   100: aastore
    //   101: invokestatic 79	com/tencent/mm/sdk/platformtools/ac:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   104: aload 4
    //   106: iload_2
    //   107: invokeinterface 82 2 0
    //   112: aload 4
    //   114: aload_1
    //   115: invokeinterface 86 2 0
    //   120: aload 4
    //   122: aload_0
    //   123: invokeinterface 90 2 0
    //   128: aload_0
    //   129: getfield 29	com/tencent/luggage/k/a/c/a:ckV	Ljava/util/Map;
    //   132: aload_3
    //   133: aload 4
    //   135: invokeinterface 94 3 0
    //   140: pop
    //   141: ldc 36
    //   143: invokestatic 32	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   146: aload_0
    //   147: monitorexit
    //   148: aload 4
    //   150: areturn
    //   151: aload_0
    //   152: invokespecial 48	com/tencent/luggage/k/a/c/a:getLogTag	()Ljava/lang/String;
    //   155: ldc 96
    //   157: iconst_1
    //   158: anewarray 4	java/lang/Object
    //   161: dup
    //   162: iconst_0
    //   163: aload_3
    //   164: aastore
    //   165: invokestatic 56	com/tencent/mm/sdk/platformtools/ac:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
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
  
  private String getLogTag()
  {
    AppMethodBeat.i(139355);
    String str = String.format(Locale.US, "%s(%s)", new Object[] { "MicroMsg.SameLayer.DefaultExtendPluginClientProxy", Integer.valueOf(hashCode()) });
    AppMethodBeat.o(139355);
    return str;
  }
  
  public final com.tencent.luggage.k.a.c Fr()
  {
    return this.ckW;
  }
  
  public final String a(String paramString, int paramInt, com.tencent.luggage.k.a.a parama)
  {
    AppMethodBeat.i(139356);
    String str = d.l(paramString, paramInt);
    ac.i(getLogTag(), "handleJsApi, key:%s, jsapi:%s", new Object[] { str, parama.Ef() });
    paramString = c(paramString, paramInt, str);
    if (paramString == null)
    {
      ac.w(getLogTag(), "handleJsApi, key:%s, handler is null", new Object[] { str });
      AppMethodBeat.o(139356);
      return "";
    }
    if (paramString.g(parama))
    {
      if (parama.Ed())
      {
        paramString = paramString.h(parama);
        AppMethodBeat.o(139356);
        return paramString;
      }
      paramString.h(parama);
      AppMethodBeat.o(139356);
      return "";
    }
    if (parama.Ed())
    {
      paramString = parama.cs("ok");
      AppMethodBeat.o(139356);
      return paramString;
    }
    AppMethodBeat.o(139356);
    return "";
  }
  
  public final void a(com.tencent.luggage.k.a.b.c paramc)
  {
    this.ckU = paramc;
  }
  
  public final void a(com.tencent.luggage.k.a.c paramc)
  {
    this.ckW = paramc;
  }
  
  public final void m(String paramString, int paramInt)
  {
    try
    {
      AppMethodBeat.i(206661);
      paramString = d.l(paramString, paramInt);
      ac.i(getLogTag(), "removePlugin, key:%s", new Object[] { paramString });
      this.ckV.remove(paramString);
      AppMethodBeat.o(206661);
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
    ac.i(getLogTag(), "onPluginDestroy, key:%s", new Object[] { str });
    paramString = c(paramString, paramInt, str);
    if (paramString == null)
    {
      ac.w(getLogTag(), "onPluginDestroy, key:%s, handler is null", new Object[] { str });
      AppMethodBeat.o(139358);
      return;
    }
    paramString.EC();
    AppMethodBeat.o(139358);
  }
  
  public final void onPluginReady(String paramString, int paramInt, SurfaceTexture paramSurfaceTexture)
  {
    AppMethodBeat.i(139357);
    String str = d.l(paramString, paramInt);
    ac.i(getLogTag(), "onPluginReady, key:%s", new Object[] { str });
    paramString = c(paramString, paramInt, str);
    if (paramString == null)
    {
      ac.w(getLogTag(), "onPluginReady, key:%s, handler is null", new Object[] { str });
      AppMethodBeat.o(139357);
      return;
    }
    ac.i(getLogTag(), "onPluginReady, key:%s, handler is ready", new Object[] { str });
    paramString.e(paramSurfaceTexture);
    AppMethodBeat.o(139357);
  }
  
  public final void onPluginScreenshotTaken(String paramString, int paramInt, Bitmap paramBitmap)
  {
    AppMethodBeat.i(178851);
    String str = d.l(paramString, paramInt);
    ac.v(getLogTag(), "onPluginScreenshotTaken, key:%s", new Object[] { str });
    paramString = c(paramString, paramInt, str);
    if (paramString == null)
    {
      ac.w(getLogTag(), "onPluginScreenshotTaken, key:%s, handler is null", new Object[] { str });
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
    ac.v(getLogTag(), "onPluginTouch, key:%s", new Object[] { str });
    paramString = c(paramString, paramInt, str);
    if (paramString == null)
    {
      ac.w(getLogTag(), "onPluginTouch, key:%s, handler is null", new Object[] { str });
      AppMethodBeat.o(139359);
      return;
    }
    paramString.l(paramMotionEvent);
    AppMethodBeat.o(139359);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.luggage.k.a.c.a
 * JD-Core Version:    0.7.0.1
 */