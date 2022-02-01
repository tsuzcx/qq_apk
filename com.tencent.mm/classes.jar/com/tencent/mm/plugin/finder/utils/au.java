package com.tencent.mm.plugin.finder.utils;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.findersdk.b.b;
import com.tencent.mm.plugin.findersdk.b.d;
import com.tencent.mm.plugin.findersdk.b.f;
import com.tencent.mm.sdk.platformtools.Log;
import java.lang.ref.WeakReference;
import kotlin.g.a.a;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/utils/MultiDelayLoadingComponent;", "Lcom/tencent/mm/plugin/findersdk/cgi/DelayLoadingComponent;", "()V", "loadingCount", "", "begin", "", "cancel", "end", "reset", "Companion", "plugin-finder_release"})
public final class au
  extends b
{
  public static final a AJj;
  public int AJi;
  
  static
  {
    AppMethodBeat.i(267389);
    AJj = new a((byte)0);
    AppMethodBeat.o(267389);
  }
  
  /* Error */
  public final void begin()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 74
    //   4: invokestatic 41	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: aload_0
    //   8: aload_0
    //   9: getfield 56	com/tencent/mm/plugin/finder/utils/au:AJi	I
    //   12: iconst_1
    //   13: iadd
    //   14: putfield 56	com/tencent/mm/plugin/finder/utils/au:AJi	I
    //   17: ldc 76
    //   19: new 78	java/lang/StringBuilder
    //   22: dup
    //   23: ldc 80
    //   25: invokespecial 83	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   28: aload_0
    //   29: getfield 56	com/tencent/mm/plugin/finder/utils/au:AJi	I
    //   32: invokevirtual 87	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   35: invokevirtual 91	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   38: invokestatic 96	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   41: aload_0
    //   42: getfield 56	com/tencent/mm/plugin/finder/utils/au:AJi	I
    //   45: iconst_1
    //   46: if_icmple +11 -> 57
    //   49: ldc 74
    //   51: invokestatic 50	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   54: aload_0
    //   55: monitorexit
    //   56: return
    //   57: aload_0
    //   58: invokevirtual 100	com/tencent/mm/plugin/finder/utils/au:enl	()Lcom/tencent/e/i/d;
    //   61: astore_1
    //   62: aload_1
    //   63: ifnull +11 -> 74
    //   66: aload_1
    //   67: iconst_0
    //   68: invokeinterface 105 2 0
    //   73: pop
    //   74: aload_0
    //   75: getstatic 111	com/tencent/e/h:ZvG	Lcom/tencent/e/i;
    //   78: new 9	com/tencent/mm/plugin/finder/utils/au$b
    //   81: dup
    //   82: aload_0
    //   83: invokespecial 114	com/tencent/mm/plugin/finder/utils/au$b:<init>	(Lcom/tencent/mm/plugin/finder/utils/au;)V
    //   86: checkcast 116	java/lang/Runnable
    //   89: aload_0
    //   90: getfield 61	com/tencent/mm/plugin/findersdk/b/b:delay	J
    //   93: invokeinterface 122 4 0
    //   98: invokevirtual 125	com/tencent/mm/plugin/finder/utils/au:b	(Lcom/tencent/e/i/d;)V
    //   101: ldc 74
    //   103: invokestatic 50	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   106: goto -52 -> 54
    //   109: astore_1
    //   110: aload_0
    //   111: monitorexit
    //   112: aload_1
    //   113: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	114	0	this	au
    //   61	6	1	locald	com.tencent.e.i.d
    //   109	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	54	109	finally
    //   57	62	109	finally
    //   66	74	109	finally
    //   74	106	109	finally
  }
  
  /* Error */
  public final void end()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 126
    //   4: invokestatic 41	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: aload_0
    //   8: aload_0
    //   9: getfield 56	com/tencent/mm/plugin/finder/utils/au:AJi	I
    //   12: iconst_1
    //   13: isub
    //   14: putfield 56	com/tencent/mm/plugin/finder/utils/au:AJi	I
    //   17: ldc 76
    //   19: new 78	java/lang/StringBuilder
    //   22: dup
    //   23: ldc 128
    //   25: invokespecial 83	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   28: aload_0
    //   29: getfield 56	com/tencent/mm/plugin/finder/utils/au:AJi	I
    //   32: invokevirtual 87	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   35: invokevirtual 91	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   38: invokestatic 96	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   41: aload_0
    //   42: getfield 56	com/tencent/mm/plugin/finder/utils/au:AJi	I
    //   45: ifle +11 -> 56
    //   48: ldc 126
    //   50: invokestatic 50	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   53: aload_0
    //   54: monitorexit
    //   55: return
    //   56: aload_0
    //   57: invokevirtual 100	com/tencent/mm/plugin/finder/utils/au:enl	()Lcom/tencent/e/i/d;
    //   60: astore_1
    //   61: aload_1
    //   62: ifnull +11 -> 73
    //   65: aload_1
    //   66: iconst_0
    //   67: invokeinterface 105 2 0
    //   72: pop
    //   73: new 11	com/tencent/mm/plugin/finder/utils/au$c
    //   76: dup
    //   77: aload_0
    //   78: invokespecial 129	com/tencent/mm/plugin/finder/utils/au$c:<init>	(Lcom/tencent/mm/plugin/finder/utils/au;)V
    //   81: checkcast 131	kotlin/g/a/a
    //   84: invokestatic 137	com/tencent/mm/ae/d:uiThread	(Lkotlin/g/a/a;)V
    //   87: ldc 126
    //   89: invokestatic 50	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   92: goto -39 -> 53
    //   95: astore_1
    //   96: aload_0
    //   97: monitorexit
    //   98: aload_1
    //   99: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	100	0	this	au
    //   60	6	1	locald	com.tencent.e.i.d
    //   95	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	53	95	finally
    //   56	61	95	finally
    //   65	73	95	finally
    //   73	92	95	finally
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/utils/MultiDelayLoadingComponent$Companion;", "", "()V", "TAG", "", "createLoadingDialog", "Lcom/tencent/mm/plugin/finder/utils/MultiDelayLoadingComponent;", "context", "Landroid/content/Context;", "wording", "delay", "", "onCancelListener", "Landroid/content/DialogInterface$OnCancelListener;", "createLoadingProgressBar", "progressBar", "Landroid/widget/ProgressBar;", "plugin-finder_release"})
  public static final class a
  {
    private static au c(Context paramContext, String paramString, long paramLong)
    {
      AppMethodBeat.i(283287);
      p.k(paramContext, "context");
      au localau = new au();
      au.a(localau, paramLong);
      au.a(localau, new WeakReference(paramContext));
      d locald = new d();
      if (paramString != null) {
        locald.aDu(paramString);
      }
      locald.nbU = null;
      locald.context = new WeakReference(paramContext);
      au.a(localau, (f)locald);
      AppMethodBeat.o(283287);
      return localau;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class b
    implements Runnable
  {
    b(au paramau) {}
    
    public final void run()
    {
      AppMethodBeat.i(286713);
      Log.i("MultiDelayLoadingComponent", "begin() show loadingCount:" + au.a(this.AJk));
      f localf = au.b(this.AJk);
      if (localf != null) {
        localf.dismiss();
      }
      localf = au.b(this.AJk);
      if (localf != null)
      {
        localf.show();
        AppMethodBeat.o(286713);
        return;
      }
      AppMethodBeat.o(286713);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class c
    extends q
    implements a<x>
  {
    c(au paramau)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.utils.au
 * JD-Core Version:    0.7.0.1
 */