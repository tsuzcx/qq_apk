package com.tencent.mm.plugin.appbrand.loading;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/loading/PendingIntentPoster;", "", "()V", "TAG", "", "index", "", "pendingIntents", "Landroid/util/SparseArray;", "Lcom/tencent/mm/plugin/appbrand/loading/PendingIntentTask;", "add", "task", "execPendingIntent", "", "intentKey", "getPendingIntentAndRemoveAtomic", "peek", "updateCtx", "", "ctx", "Landroid/content/Context;", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
{
  private static int index;
  public static final c tfr;
  private static final SparseArray<e> tfs;
  
  static
  {
    AppMethodBeat.i(50838);
    tfr = new c();
    tfs = new SparseArray();
    AppMethodBeat.o(50838);
  }
  
  public final e Ce(int paramInt)
  {
    AppMethodBeat.i(317025);
    try
    {
      e locale = (e)tfs.get(paramInt);
      return locale;
    }
    finally
    {
      AppMethodBeat.o(317025);
    }
  }
  
  /* Error */
  public final e Cf(int paramInt)
  {
    // Byte code:
    //   0: ldc 71
    //   2: invokestatic 45	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: monitorenter
    //   7: getstatic 55	com/tencent/mm/plugin/appbrand/loading/c:tfs	Landroid/util/SparseArray;
    //   10: iload_1
    //   11: invokevirtual 67	android/util/SparseArray:get	(I)Ljava/lang/Object;
    //   14: checkcast 69	com/tencent/mm/plugin/appbrand/loading/e
    //   17: astore_2
    //   18: aload_2
    //   19: ifnonnull +33 -> 52
    //   22: ldc 73
    //   24: ldc 75
    //   26: iload_1
    //   27: invokestatic 81	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   30: invokestatic 87	kotlin/g/b/s:X	(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/String;
    //   33: invokestatic 92	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   36: getstatic 55	com/tencent/mm/plugin/appbrand/loading/c:tfs	Landroid/util/SparseArray;
    //   39: iload_1
    //   40: invokevirtual 95	android/util/SparseArray:remove	(I)V
    //   43: aload_0
    //   44: monitorexit
    //   45: ldc 71
    //   47: invokestatic 58	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   50: aload_2
    //   51: areturn
    //   52: ldc 73
    //   54: ldc 97
    //   56: aload_2
    //   57: getfield 101	com/tencent/mm/plugin/appbrand/loading/e:initConfig	Lcom/tencent/mm/plugin/appbrand/config/AppBrandInitConfigWC;
    //   60: getfield 107	com/tencent/mm/plugin/appbrand/config/AppBrandInitConfigWC:hEy	Ljava/lang/String;
    //   63: invokestatic 87	kotlin/g/b/s:X	(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/String;
    //   66: invokestatic 92	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   69: goto -33 -> 36
    //   72: astore_2
    //   73: aload_0
    //   74: monitorexit
    //   75: ldc 71
    //   77: invokestatic 58	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   80: aload_2
    //   81: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	82	0	this	c
    //   0	82	1	paramInt	int
    //   17	40	2	locale	e
    //   72	9	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   7	18	72	finally
    //   22	36	72	finally
    //   36	43	72	finally
    //   52	69	72	finally
  }
  
  public final boolean Cg(int paramInt)
  {
    AppMethodBeat.i(50837);
    Object localObject = Cf(paramInt);
    if (localObject == null)
    {
      AppMethodBeat.o(50837);
      return false;
    }
    Context localContext = ((e)localObject).ctx;
    Intent localIntent = ((e)localObject).intent;
    Log.i("MicroMsg.AppBrand.PendingIntentPoster", s.X("execPendingIntent: ctx = ", ((e)localObject).ctx));
    localObject = new com.tencent.mm.hellhoundlib.b.a().cG(localIntent);
    com.tencent.mm.hellhoundlib.a.a.b(localContext, ((com.tencent.mm.hellhoundlib.b.a)localObject).aYi(), "com/tencent/mm/plugin/appbrand/loading/PendingIntentPoster", "execPendingIntent", "(I)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    localContext.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sb(0));
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
    s.u(parame, "task");
    try
    {
      SparseArray localSparseArray = tfs;
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
  
  public final void d(int paramInt, Context paramContext)
  {
    AppMethodBeat.i(50836);
    s.u(paramContext, "ctx");
    try
    {
      e locale = (e)tfs.get(paramInt);
      if (locale == null)
      {
        Log.i("MicroMsg.AppBrand.PendingIntentPoster", s.X("updateCtx: get a null task by intentKey = ", Integer.valueOf(paramInt)));
        return;
      }
      s.u(paramContext, "<set-?>");
      locale.ctx = paramContext;
      paramContext = ah.aiuX;
      return;
    }
    finally
    {
      AppMethodBeat.o(50836);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.loading.c
 * JD-Core Version:    0.7.0.1
 */