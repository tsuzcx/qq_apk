package com.tencent.mm.plugin.appbrand.loading;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ap;
import d.g.b.k;
import d.l;
import d.y;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/appbrand/loading/PendingIntentPoster;", "", "()V", "TAG", "", "index", "", "pendingIntents", "Landroid/util/SparseArray;", "Lcom/tencent/mm/plugin/appbrand/loading/PendingIntentTask;", "add", "task", "execPendingIntent", "", "intentKey", "getPendingIntentAndRemoveAtomic", "peek", "updateCtx", "", "ctx", "Landroid/content/Context;", "plugin-appbrand-integration_release"})
public final class c
{
  private static int index;
  private static final SparseArray<e> lqy;
  public static final c lqz;
  
  static
  {
    AppMethodBeat.i(50838);
    lqz = new c();
    lqy = new SparseArray();
    AppMethodBeat.o(50838);
  }
  
  public final int a(e parame)
  {
    AppMethodBeat.i(50834);
    k.h(parame, "task");
    try
    {
      SparseArray localSparseArray = lqy;
      int i = index + 1;
      index = i;
      localSparseArray.append(i, parame);
      ap.n((Runnable)new d(index, "MicroMsg.AppBrand.PendingIntentPoster"), 12000L);
      i = index;
      return i;
    }
    finally
    {
      AppMethodBeat.o(50834);
    }
  }
  
  public final void a(int paramInt, Context paramContext)
  {
    AppMethodBeat.i(50836);
    k.h(paramContext, "ctx");
    try
    {
      e locale = (e)lqy.get(paramInt);
      if (locale == null)
      {
        ac.i("MicroMsg.AppBrand.PendingIntentPoster", "updateCtx: get a null task by intentKey = ".concat(String.valueOf(paramInt)));
        return;
      }
      k.h(paramContext, "<set-?>");
      locale.ctx = paramContext;
      paramContext = y.KTp;
      return;
    }
    finally
    {
      AppMethodBeat.o(50836);
    }
  }
  
  public final e tO(int paramInt)
  {
    AppMethodBeat.i(187345);
    try
    {
      e locale = (e)lqy.get(paramInt);
      return locale;
    }
    finally
    {
      AppMethodBeat.o(187345);
    }
  }
  
  /* Error */
  public final e tP(int paramInt)
  {
    // Byte code:
    //   0: ldc 131
    //   2: invokestatic 42	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: monitorenter
    //   7: getstatic 52	com/tencent/mm/plugin/appbrand/loading/c:lqy	Landroid/util/SparseArray;
    //   10: iload_1
    //   11: invokevirtual 97	android/util/SparseArray:get	(I)Ljava/lang/Object;
    //   14: checkcast 99	com/tencent/mm/plugin/appbrand/loading/e
    //   17: astore_2
    //   18: aload_2
    //   19: ifnonnull +33 -> 52
    //   22: ldc 77
    //   24: ldc 133
    //   26: iload_1
    //   27: invokestatic 107	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   30: invokevirtual 111	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   33: invokestatic 116	com/tencent/mm/sdk/platformtools/ac:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   36: getstatic 52	com/tencent/mm/plugin/appbrand/loading/c:lqy	Landroid/util/SparseArray;
    //   39: iload_1
    //   40: invokevirtual 136	android/util/SparseArray:remove	(I)V
    //   43: aload_0
    //   44: monitorexit
    //   45: ldc 131
    //   47: invokestatic 55	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   50: aload_2
    //   51: areturn
    //   52: ldc 77
    //   54: new 138	java/lang/StringBuilder
    //   57: dup
    //   58: ldc 140
    //   60: invokespecial 143	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   63: aload_2
    //   64: getfield 147	com/tencent/mm/plugin/appbrand/loading/e:liu	Lcom/tencent/mm/plugin/appbrand/config/AppBrandInitConfigWC;
    //   67: getfield 153	com/tencent/mm/plugin/appbrand/config/AppBrandInitConfigWC:ddh	Ljava/lang/String;
    //   70: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   73: invokevirtual 160	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   76: invokestatic 116	com/tencent/mm/sdk/platformtools/ac:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   79: goto -43 -> 36
    //   82: astore_2
    //   83: aload_0
    //   84: monitorexit
    //   85: ldc 131
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
  
  public final boolean tQ(int paramInt)
  {
    AppMethodBeat.i(50837);
    Object localObject = tP(paramInt);
    if (localObject == null)
    {
      AppMethodBeat.o(50837);
      return false;
    }
    Context localContext = ((e)localObject).ctx;
    Intent localIntent = ((e)localObject).intent;
    ac.i("MicroMsg.AppBrand.PendingIntentPoster", "execPendingIntent: ctx = " + ((e)localObject).ctx);
    localObject = new com.tencent.mm.hellhoundlib.b.a().ba(localIntent);
    com.tencent.mm.hellhoundlib.a.a.a(localContext, ((com.tencent.mm.hellhoundlib.b.a)localObject).aeD(), "com/tencent/mm/plugin/appbrand/loading/PendingIntentPoster", "execPendingIntent", "(I)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    localContext.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lR(0));
    com.tencent.mm.hellhoundlib.a.a.a(localContext, "com/tencent/mm/plugin/appbrand/loading/PendingIntentPoster", "execPendingIntent", "(I)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    if ((localContext instanceof Activity)) {
      ((Activity)localContext).overridePendingTransition(0, 0);
    }
    AppMethodBeat.o(50837);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.loading.c
 * JD-Core Version:    0.7.0.1
 */