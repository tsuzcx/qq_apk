package com.tencent.mm.plugin.finder.utils;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.findersdk.b.b;
import com.tencent.mm.plugin.findersdk.b.e;
import com.tencent.mm.plugin.findersdk.b.g;
import com.tencent.mm.sdk.platformtools.Log;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.a;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/utils/MultiDelayLoadingComponent;", "Lcom/tencent/mm/plugin/findersdk/cgi/DelayLoadingComponent;", "()V", "loadingCount", "", "begin", "", "cancel", "end", "reset", "Companion", "plugin-finder-base_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class bh
  extends b
{
  public static final a GlM;
  public int GlN;
  
  static
  {
    AppMethodBeat.i(333083);
    GlM = new a((byte)0);
    AppMethodBeat.o(333083);
  }
  
  private static final void a(bh parambh)
  {
    AppMethodBeat.i(333051);
    s.u(parambh, "this$0");
    Log.i("MultiDelayLoadingComponent", s.X("begin() show loadingCount:", Integer.valueOf(parambh.GlN)));
    g localg = parambh.HcF;
    if (localg != null) {
      localg.dismiss();
    }
    parambh = parambh.HcF;
    if (parambh != null) {
      parambh.show();
    }
    AppMethodBeat.o(333051);
  }
  
  /* Error */
  public final void begin()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 117
    //   4: invokestatic 43	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: aload_0
    //   8: aload_0
    //   9: getfield 74	com/tencent/mm/plugin/finder/utils/bh:GlN	I
    //   12: iconst_1
    //   13: iadd
    //   14: putfield 74	com/tencent/mm/plugin/finder/utils/bh:GlN	I
    //   17: ldc 70
    //   19: ldc 119
    //   21: aload_0
    //   22: getfield 74	com/tencent/mm/plugin/finder/utils/bh:GlN	I
    //   25: invokestatic 80	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   28: invokestatic 84	kotlin/g/b/s:X	(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/String;
    //   31: invokestatic 89	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   34: aload_0
    //   35: getfield 74	com/tencent/mm/plugin/finder/utils/bh:GlN	I
    //   38: iconst_1
    //   39: if_icmple +11 -> 50
    //   42: ldc 117
    //   44: invokestatic 48	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   47: aload_0
    //   48: monitorexit
    //   49: return
    //   50: aload_0
    //   51: invokevirtual 123	com/tencent/mm/plugin/finder/utils/bh:frU	()Lcom/tencent/threadpool/i/d;
    //   54: astore_1
    //   55: aload_1
    //   56: ifnull +11 -> 67
    //   59: aload_1
    //   60: iconst_0
    //   61: invokeinterface 128 2 0
    //   66: pop
    //   67: aload_0
    //   68: getstatic 134	com/tencent/threadpool/h:ahAA	Lcom/tencent/threadpool/i;
    //   71: new 136	com/tencent/mm/plugin/finder/utils/bh$$ExternalSyntheticLambda0
    //   74: dup
    //   75: aload_0
    //   76: invokespecial 138	com/tencent/mm/plugin/finder/utils/bh$$ExternalSyntheticLambda0:<init>	(Lcom/tencent/mm/plugin/finder/utils/bh;)V
    //   79: aload_0
    //   80: getfield 106	com/tencent/mm/plugin/findersdk/b/b:delay	J
    //   83: invokeinterface 143 4 0
    //   88: invokevirtual 146	com/tencent/mm/plugin/finder/utils/bh:b	(Lcom/tencent/threadpool/i/d;)V
    //   91: ldc 117
    //   93: invokestatic 48	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   96: goto -49 -> 47
    //   99: astore_1
    //   100: aload_0
    //   101: monitorexit
    //   102: aload_1
    //   103: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	104	0	this	bh
    //   54	6	1	locald	com.tencent.threadpool.i.d
    //   99	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	47	99	finally
    //   50	55	99	finally
    //   59	67	99	finally
    //   67	96	99	finally
  }
  
  /* Error */
  public final void end()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 147
    //   4: invokestatic 43	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: aload_0
    //   8: aload_0
    //   9: getfield 74	com/tencent/mm/plugin/finder/utils/bh:GlN	I
    //   12: iconst_1
    //   13: isub
    //   14: putfield 74	com/tencent/mm/plugin/finder/utils/bh:GlN	I
    //   17: ldc 70
    //   19: ldc 149
    //   21: aload_0
    //   22: getfield 74	com/tencent/mm/plugin/finder/utils/bh:GlN	I
    //   25: invokestatic 80	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   28: invokestatic 84	kotlin/g/b/s:X	(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/String;
    //   31: invokestatic 89	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   34: aload_0
    //   35: getfield 74	com/tencent/mm/plugin/finder/utils/bh:GlN	I
    //   38: ifle +11 -> 49
    //   41: ldc 147
    //   43: invokestatic 48	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   46: aload_0
    //   47: monitorexit
    //   48: return
    //   49: aload_0
    //   50: invokevirtual 123	com/tencent/mm/plugin/finder/utils/bh:frU	()Lcom/tencent/threadpool/i/d;
    //   53: astore_1
    //   54: aload_1
    //   55: ifnull +11 -> 66
    //   58: aload_1
    //   59: iconst_0
    //   60: invokeinterface 128 2 0
    //   65: pop
    //   66: new 9	com/tencent/mm/plugin/finder/utils/bh$b
    //   69: dup
    //   70: aload_0
    //   71: invokespecial 150	com/tencent/mm/plugin/finder/utils/bh$b:<init>	(Lcom/tencent/mm/plugin/finder/utils/bh;)V
    //   74: checkcast 152	kotlin/g/a/a
    //   77: invokestatic 158	com/tencent/mm/ae/d:uiThread	(Lkotlin/g/a/a;)V
    //   80: ldc 147
    //   82: invokestatic 48	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   85: goto -39 -> 46
    //   88: astore_1
    //   89: aload_0
    //   90: monitorexit
    //   91: aload_1
    //   92: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	93	0	this	bh
    //   53	6	1	locald	com.tencent.threadpool.i.d
    //   88	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	46	88	finally
    //   49	54	88	finally
    //   58	66	88	finally
    //   66	85	88	finally
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/utils/MultiDelayLoadingComponent$Companion;", "", "()V", "TAG", "", "createLoadingDialog", "Lcom/tencent/mm/plugin/finder/utils/MultiDelayLoadingComponent;", "context", "Landroid/content/Context;", "wording", "delay", "", "onCancelListener", "Landroid/content/DialogInterface$OnCancelListener;", "createLoadingProgressBar", "progressBar", "Landroid/widget/ProgressBar;", "plugin-finder-base_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    private static bh c(Context paramContext, String paramString, long paramLong)
    {
      AppMethodBeat.i(333629);
      s.u(paramContext, "context");
      bh localbh = new bh();
      bh.a(localbh, paramLong);
      bh.a(localbh, new WeakReference(paramContext));
      e locale = new e();
      if (paramString != null) {
        locale.ayQ(paramString);
      }
      locale.qbI = null;
      locale.context = new WeakReference(paramContext);
      paramContext = ah.aiuX;
      bh.a(localbh, (g)locale);
      AppMethodBeat.o(333629);
      return localbh;
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements a<ah>
  {
    b(bh parambh)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.utils.bh
 * JD-Core Version:    0.7.0.1
 */