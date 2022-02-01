package com.tencent.mm.plugin.appbrand.loading;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ar;
import d.g.b.p;
import d.l;
import d.z;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/appbrand/loading/PendingIntentPoster;", "", "()V", "TAG", "", "index", "", "pendingIntents", "Landroid/util/SparseArray;", "Lcom/tencent/mm/plugin/appbrand/loading/PendingIntentTask;", "add", "task", "execPendingIntent", "", "intentKey", "getPendingIntentAndRemoveAtomic", "peek", "updateCtx", "", "ctx", "Landroid/content/Context;", "plugin-appbrand-integration_release"})
public final class c
{
  private static int index;
  private static final SparseArray<e> lSx;
  public static final c lSy;
  
  static
  {
    AppMethodBeat.i(50838);
    lSy = new c();
    lSx = new SparseArray();
    AppMethodBeat.o(50838);
  }
  
  public final int a(e parame)
  {
    AppMethodBeat.i(50834);
    p.h(parame, "task");
    try
    {
      SparseArray localSparseArray = lSx;
      int i = index + 1;
      index = i;
      localSparseArray.append(i, parame);
      ar.o((Runnable)new d(index, "MicroMsg.AppBrand.PendingIntentPoster"), 12000L);
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
    p.h(paramContext, "ctx");
    try
    {
      e locale = (e)lSx.get(paramInt);
      if (locale == null)
      {
        ae.i("MicroMsg.AppBrand.PendingIntentPoster", "updateCtx: get a null task by intentKey = ".concat(String.valueOf(paramInt)));
        return;
      }
      p.h(paramContext, "<set-?>");
      locale.ctx = paramContext;
      paramContext = z.Nhr;
      return;
    }
    finally
    {
      AppMethodBeat.o(50836);
    }
  }
  
  public final boolean uA(int paramInt)
  {
    AppMethodBeat.i(50837);
    Object localObject = uz(paramInt);
    if (localObject == null)
    {
      AppMethodBeat.o(50837);
      return false;
    }
    Context localContext = ((e)localObject).ctx;
    Intent localIntent = ((e)localObject).intent;
    ae.i("MicroMsg.AppBrand.PendingIntentPoster", "execPendingIntent: ctx = " + ((e)localObject).ctx);
    localObject = new com.tencent.mm.hellhoundlib.b.a().bc(localIntent);
    com.tencent.mm.hellhoundlib.a.a.a(localContext, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahE(), "com/tencent/mm/plugin/appbrand/loading/PendingIntentPoster", "execPendingIntent", "(I)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    localContext.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mt(0));
    com.tencent.mm.hellhoundlib.a.a.a(localContext, "com/tencent/mm/plugin/appbrand/loading/PendingIntentPoster", "execPendingIntent", "(I)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    if ((localContext instanceof Activity)) {
      ((Activity)localContext).overridePendingTransition(0, 0);
    }
    AppMethodBeat.o(50837);
    return true;
  }
  
  public final e uy(int paramInt)
  {
    AppMethodBeat.i(223607);
    try
    {
      e locale = (e)lSx.get(paramInt);
      return locale;
    }
    finally
    {
      AppMethodBeat.o(223607);
    }
  }
  
  /* Error */
  public final e uz(int paramInt)
  {
    // Byte code:
    //   0: ldc 197
    //   2: invokestatic 42	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: monitorenter
    //   7: getstatic 52	com/tencent/mm/plugin/appbrand/loading/c:lSx	Landroid/util/SparseArray;
    //   10: iload_1
    //   11: invokevirtual 96	android/util/SparseArray:get	(I)Ljava/lang/Object;
    //   14: checkcast 98	com/tencent/mm/plugin/appbrand/loading/e
    //   17: astore_2
    //   18: aload_2
    //   19: ifnonnull +33 -> 52
    //   22: ldc 77
    //   24: ldc 199
    //   26: iload_1
    //   27: invokestatic 106	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   30: invokevirtual 110	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   33: invokestatic 115	com/tencent/mm/sdk/platformtools/ae:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   36: getstatic 52	com/tencent/mm/plugin/appbrand/loading/c:lSx	Landroid/util/SparseArray;
    //   39: iload_1
    //   40: invokevirtual 202	android/util/SparseArray:remove	(I)V
    //   43: aload_0
    //   44: monitorexit
    //   45: ldc 197
    //   47: invokestatic 55	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   50: aload_2
    //   51: areturn
    //   52: ldc 77
    //   54: new 138	java/lang/StringBuilder
    //   57: dup
    //   58: ldc 204
    //   60: invokespecial 143	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   63: aload_2
    //   64: getfield 208	com/tencent/mm/plugin/appbrand/loading/e:lJW	Lcom/tencent/mm/plugin/appbrand/config/AppBrandInitConfigWC;
    //   67: getfield 214	com/tencent/mm/plugin/appbrand/config/AppBrandInitConfigWC:dpI	Ljava/lang/String;
    //   70: invokevirtual 217	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   73: invokevirtual 150	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   76: invokestatic 115	com/tencent/mm/sdk/platformtools/ae:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   79: goto -43 -> 36
    //   82: astore_2
    //   83: aload_0
    //   84: monitorexit
    //   85: ldc 197
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.loading.c
 * JD-Core Version:    0.7.0.1
 */