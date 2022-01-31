package com.tencent.luggage.xweb_ext.extendplugin.b;

import android.graphics.SurfaceTexture;
import android.view.MotionEvent;
import com.tencent.luggage.xweb_ext.extendplugin.a.b;
import com.tencent.luggage.xweb_ext.extendplugin.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.concurrent.ConcurrentHashMap;

public final class a
  implements c
{
  private com.tencent.luggage.xweb_ext.extendplugin.a.c bJa;
  private ConcurrentHashMap<String, b> bJb;
  private com.tencent.luggage.xweb_ext.extendplugin.c bJc;
  
  public a()
  {
    AppMethodBeat.i(140003);
    this.bJb = new ConcurrentHashMap();
    AppMethodBeat.o(140003);
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
    //   8: getfield 29	com/tencent/luggage/xweb_ext/extendplugin/b/a:bJb	Ljava/util/concurrent/ConcurrentHashMap;
    //   11: aload_3
    //   12: invokevirtual 40	java/util/concurrent/ConcurrentHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   15: checkcast 42	com/tencent/luggage/xweb_ext/extendplugin/a/b
    //   18: astore 5
    //   20: aload 5
    //   22: astore 4
    //   24: aload 5
    //   26: ifnonnull +92 -> 118
    //   29: aload 5
    //   31: astore 4
    //   33: aload_0
    //   34: getfield 44	com/tencent/luggage/xweb_ext/extendplugin/b/a:bJa	Lcom/tencent/luggage/xweb_ext/extendplugin/a/c;
    //   37: ifnull +81 -> 118
    //   40: aload_0
    //   41: getfield 44	com/tencent/luggage/xweb_ext/extendplugin/b/a:bJa	Lcom/tencent/luggage/xweb_ext/extendplugin/a/c;
    //   44: aload_1
    //   45: invokeinterface 50 2 0
    //   50: astore 4
    //   52: aload 4
    //   54: ifnull +74 -> 128
    //   57: ldc 52
    //   59: ldc 54
    //   61: iconst_2
    //   62: anewarray 4	java/lang/Object
    //   65: dup
    //   66: iconst_0
    //   67: aload_3
    //   68: aastore
    //   69: dup
    //   70: iconst_1
    //   71: aload 4
    //   73: invokevirtual 58	java/lang/Object:hashCode	()I
    //   76: invokestatic 64	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   79: aastore
    //   80: invokestatic 70	com/tencent/mm/sdk/platformtools/ab:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   83: aload 4
    //   85: iload_2
    //   86: invokeinterface 73 2 0
    //   91: aload 4
    //   93: aload_1
    //   94: invokeinterface 77 2 0
    //   99: aload 4
    //   101: aload_0
    //   102: invokeinterface 81 2 0
    //   107: aload_0
    //   108: getfield 29	com/tencent/luggage/xweb_ext/extendplugin/b/a:bJb	Ljava/util/concurrent/ConcurrentHashMap;
    //   111: aload_3
    //   112: aload 4
    //   114: invokevirtual 85	java/util/concurrent/ConcurrentHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   117: pop
    //   118: ldc 36
    //   120: invokestatic 32	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   123: aload_0
    //   124: monitorexit
    //   125: aload 4
    //   127: areturn
    //   128: ldc 52
    //   130: ldc 87
    //   132: iconst_1
    //   133: anewarray 4	java/lang/Object
    //   136: dup
    //   137: iconst_0
    //   138: aload_3
    //   139: aastore
    //   140: invokestatic 90	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   143: goto -25 -> 118
    //   146: astore_1
    //   147: aload_0
    //   148: monitorexit
    //   149: aload_1
    //   150: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	151	0	this	a
    //   0	151	1	paramString1	String
    //   0	151	2	paramInt	int
    //   0	151	3	paramString2	String
    //   22	104	4	localb1	b
    //   18	12	5	localb2	b
    // Exception table:
    //   from	to	target	type
    //   2	20	146	finally
    //   33	52	146	finally
    //   57	118	146	finally
    //   118	123	146	finally
    //   128	143	146	finally
  }
  
  public final String a(String paramString, int paramInt, com.tencent.luggage.xweb_ext.extendplugin.a parama)
  {
    AppMethodBeat.i(140004);
    String str = d.m(paramString, paramInt);
    ab.i("MicroMsg.SameLayer.DefaultExtendPluginClientProxy", "handleJsApi, key:%s, jsapi:%s", new Object[] { str, parama.xl() });
    paramString = c(paramString, paramInt, str);
    if (paramString == null)
    {
      ab.w("MicroMsg.SameLayer.DefaultExtendPluginClientProxy", "handleJsApi, key:%s, handler is null", new Object[] { str });
      AppMethodBeat.o(140004);
      return "";
    }
    if (paramString.xp())
    {
      if (parama.xj())
      {
        paramString = paramString.a(parama);
        AppMethodBeat.o(140004);
        return paramString;
      }
      paramString.a(parama);
      AppMethodBeat.o(140004);
      return "";
    }
    if (parama.xj())
    {
      paramString = parama.ck("ok");
      AppMethodBeat.o(140004);
      return paramString;
    }
    AppMethodBeat.o(140004);
    return "";
  }
  
  public final void a(com.tencent.luggage.xweb_ext.extendplugin.a.c paramc)
  {
    this.bJa = paramc;
  }
  
  public final void a(com.tencent.luggage.xweb_ext.extendplugin.c paramc)
  {
    this.bJc = paramc;
  }
  
  public final void onPluginDestroy(String paramString, int paramInt)
  {
    AppMethodBeat.i(140006);
    String str = d.m(paramString, paramInt);
    ab.i("MicroMsg.SameLayer.DefaultExtendPluginClientProxy", "onPluginDestroy, key:%s", new Object[] { str });
    paramString = c(paramString, paramInt, str);
    if (paramString == null)
    {
      ab.w("MicroMsg.SameLayer.DefaultExtendPluginClientProxy", "onPluginDestroy, key:%s, no handler created for this key?", new Object[] { str });
      AppMethodBeat.o(140006);
      return;
    }
    paramString.xq();
    AppMethodBeat.o(140006);
  }
  
  public final void onPluginReady(String paramString, int paramInt, SurfaceTexture paramSurfaceTexture)
  {
    AppMethodBeat.i(140005);
    String str = d.m(paramString, paramInt);
    ab.i("MicroMsg.SameLayer.DefaultExtendPluginClientProxy", "onPluginReady, key:%s", new Object[] { str });
    paramString = c(paramString, paramInt, str);
    if (paramString == null)
    {
      ab.w("MicroMsg.SameLayer.DefaultExtendPluginClientProxy", "onPluginReady, key:%s, handler is null", new Object[] { str });
      AppMethodBeat.o(140005);
      return;
    }
    ab.i("MicroMsg.SameLayer.DefaultExtendPluginClientProxy", "onPluginReady, key:%s, handler is ready", new Object[] { str });
    paramString.d(paramSurfaceTexture);
    AppMethodBeat.o(140005);
  }
  
  public final void onPluginTouch(String paramString, int paramInt, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(140007);
    String str = d.m(paramString, paramInt);
    ab.i("MicroMsg.SameLayer.DefaultExtendPluginClientProxy", "onPluginTouch, key:%s", new Object[] { str });
    paramString = c(paramString, paramInt, str);
    if (paramString == null)
    {
      ab.w("MicroMsg.SameLayer.DefaultExtendPluginClientProxy", "onPluginTouch, key:%s, no handler created for this key?", new Object[] { str });
      AppMethodBeat.o(140007);
      return;
    }
    paramString.m(paramMotionEvent);
    AppMethodBeat.o(140007);
  }
  
  public final com.tencent.luggage.xweb_ext.extendplugin.c yi()
  {
    return this.bJc;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.luggage.xweb_ext.extendplugin.b.a
 * JD-Core Version:    0.7.0.1
 */