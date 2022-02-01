package com.tencent.mm.plugin.appbrand.loading;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/loading/PendingIntentPoster;", "", "()V", "TAG", "", "index", "", "pendingIntents", "Landroid/util/SparseArray;", "Lcom/tencent/mm/plugin/appbrand/loading/PendingIntentTask;", "add", "task", "execPendingIntent", "", "intentKey", "getPendingIntentAndRemoveAtomic", "peek", "updateCtx", "", "ctx", "Landroid/content/Context;", "plugin-appbrand-integration_release"})
public final class c
{
  private static int index;
  private static final SparseArray<e> qam;
  public static final c qan;
  
  static
  {
    AppMethodBeat.i(50838);
    qan = new c();
    qam = new SparseArray();
    AppMethodBeat.o(50838);
  }
  
  public final e BP(int paramInt)
  {
    AppMethodBeat.i(273320);
    try
    {
      e locale = (e)qam.get(paramInt);
      return locale;
    }
    finally
    {
      AppMethodBeat.o(273320);
    }
  }
  
  /* Error */
  public final e BQ(int paramInt)
  {
    // Byte code:
    //   0: ldc 68
    //   2: invokestatic 42	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: monitorenter
    //   7: getstatic 52	com/tencent/mm/plugin/appbrand/loading/c:qam	Landroid/util/SparseArray;
    //   10: iload_1
    //   11: invokevirtual 64	android/util/SparseArray:get	(I)Ljava/lang/Object;
    //   14: checkcast 66	com/tencent/mm/plugin/appbrand/loading/e
    //   17: astore_2
    //   18: aload_2
    //   19: ifnonnull +33 -> 52
    //   22: ldc 70
    //   24: ldc 72
    //   26: iload_1
    //   27: invokestatic 78	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   30: invokevirtual 82	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   33: invokestatic 87	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   36: getstatic 52	com/tencent/mm/plugin/appbrand/loading/c:qam	Landroid/util/SparseArray;
    //   39: iload_1
    //   40: invokevirtual 90	android/util/SparseArray:remove	(I)V
    //   43: aload_0
    //   44: monitorexit
    //   45: ldc 68
    //   47: invokestatic 55	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   50: aload_2
    //   51: areturn
    //   52: ldc 70
    //   54: new 92	java/lang/StringBuilder
    //   57: dup
    //   58: ldc 94
    //   60: invokespecial 97	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   63: aload_2
    //   64: getfield 101	com/tencent/mm/plugin/appbrand/loading/e:nyg	Lcom/tencent/mm/plugin/appbrand/config/AppBrandInitConfigWC;
    //   67: getfield 107	com/tencent/mm/plugin/appbrand/config/AppBrandInitConfigWC:fzM	Ljava/lang/String;
    //   70: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   73: invokevirtual 115	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   76: invokestatic 87	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   79: goto -43 -> 36
    //   82: astore_2
    //   83: aload_0
    //   84: monitorexit
    //   85: ldc 68
    //   87: invokestatic 55	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   90: aload_2
    //   91: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	92	0	this	c
    //   0	92	1	paramInt	int
    //   17	47	2	locale	e
    //   82	9	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   7	18	82	finally
    //   22	36	82	finally
    //   36	43	82	finally
    //   52	79	82	finally
  }
  
  public final boolean BR(int paramInt)
  {
    AppMethodBeat.i(50837);
    Object localObject = BQ(paramInt);
    if (localObject == null)
    {
      AppMethodBeat.o(50837);
      return false;
    }
    Context localContext = ((e)localObject).ctx;
    Intent localIntent = ((e)localObject).intent;
    Log.i("MicroMsg.AppBrand.PendingIntentPoster", "execPendingIntent: ctx = " + ((e)localObject).ctx);
    localObject = new com.tencent.mm.hellhoundlib.b.a().bm(localIntent);
    com.tencent.mm.hellhoundlib.a.a.b(localContext, ((com.tencent.mm.hellhoundlib.b.a)localObject).aFh(), "com/tencent/mm/plugin/appbrand/loading/PendingIntentPoster", "execPendingIntent", "(I)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    localContext.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sf(0));
    com.tencent.mm.hellhoundlib.a.a.c(localContext, "com/tencent/mm/plugin/appbrand/loading/PendingIntentPoster", "execPendingIntent", "(I)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    if ((localContext instanceof Activity)) {
      ((Activity)localContext).overridePendingTransition(0, 0);
    }
    AppMethodBeat.o(50837);
    return true;
  }
  
  public final int a(e parame)
  {
    AppMethodBeat.i(50834);
    p.k(parame, "task");
    try
    {
      SparseArray localSparseArray = qam;
      int i = index + 1;
      index = i;
      localSparseArray.append(i, parame);
      MMHandlerThread.postToMainThreadDelayed((Runnable)new d(index, "MicroMsg.AppBrand.PendingIntentPoster"), 12000L);
      i = index;
      return i;
    }
    finally
    {
      AppMethodBeat.o(50834);
    }
  }
  
  public final void b(int paramInt, Context paramContext)
  {
    AppMethodBeat.i(50836);
    p.k(paramContext, "ctx");
    try
    {
      e locale = (e)qam.get(paramInt);
      if (locale == null)
      {
        Log.i("MicroMsg.AppBrand.PendingIntentPoster", "updateCtx: get a null task by intentKey = ".concat(String.valueOf(paramInt)));
        return;
      }
      p.k(paramContext, "<set-?>");
      locale.ctx = paramContext;
      paramContext = x.aazN;
      return;
    }
    finally
    {
      AppMethodBeat.o(50836);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.loading.c
 * JD-Core Version:    0.7.0.1
 */