package com.tencent.mm.plugin.finder.utils;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.a.a;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/utils/MultiDelayLoadingComponent;", "Lcom/tencent/mm/plugin/finder/utils/DelayLoadingComponent;", "()V", "loadingCount", "", "begin", "", "cancel", "end", "reset", "Companion", "plugin-finder_release"})
public final class ak
  extends b
{
  public static final a wan;
  public int wam;
  
  static
  {
    AppMethodBeat.i(253803);
    wan = new a((byte)0);
    AppMethodBeat.o(253803);
  }
  
  /* Error */
  public final void begin()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 57
    //   4: invokestatic 41	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: aload_0
    //   8: aload_0
    //   9: getfield 56	com/tencent/mm/plugin/finder/utils/ak:wam	I
    //   12: iconst_1
    //   13: iadd
    //   14: putfield 56	com/tencent/mm/plugin/finder/utils/ak:wam	I
    //   17: ldc 59
    //   19: new 61	java/lang/StringBuilder
    //   22: dup
    //   23: ldc 63
    //   25: invokespecial 66	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   28: aload_0
    //   29: getfield 56	com/tencent/mm/plugin/finder/utils/ak:wam	I
    //   32: invokevirtual 70	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   35: invokevirtual 74	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   38: invokestatic 79	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   41: aload_0
    //   42: getfield 56	com/tencent/mm/plugin/finder/utils/ak:wam	I
    //   45: iconst_1
    //   46: if_icmple +11 -> 57
    //   49: ldc 57
    //   51: invokestatic 50	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   54: aload_0
    //   55: monitorexit
    //   56: return
    //   57: aload_0
    //   58: getfield 83	com/tencent/mm/plugin/finder/utils/b:dialogRunnable	Lcom/tencent/f/i/d;
    //   61: astore_1
    //   62: aload_1
    //   63: ifnull +11 -> 74
    //   66: aload_1
    //   67: iconst_0
    //   68: invokeinterface 88 2 0
    //   73: pop
    //   74: aload_0
    //   75: getstatic 94	com/tencent/f/h:RTc	Lcom/tencent/f/i;
    //   78: new 9	com/tencent/mm/plugin/finder/utils/ak$b
    //   81: dup
    //   82: aload_0
    //   83: invokespecial 97	com/tencent/mm/plugin/finder/utils/ak$b:<init>	(Lcom/tencent/mm/plugin/finder/utils/ak;)V
    //   86: checkcast 99	java/lang/Runnable
    //   89: aload_0
    //   90: getfield 103	com/tencent/mm/plugin/finder/utils/b:gY	J
    //   93: invokeinterface 109 4 0
    //   98: putfield 83	com/tencent/mm/plugin/finder/utils/b:dialogRunnable	Lcom/tencent/f/i/d;
    //   101: ldc 57
    //   103: invokestatic 50	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   106: goto -52 -> 54
    //   109: astore_1
    //   110: aload_0
    //   111: monitorexit
    //   112: aload_1
    //   113: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	114	0	this	ak
    //   61	6	1	locald	com.tencent.f.i.d
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
    //   2: ldc 110
    //   4: invokestatic 41	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: aload_0
    //   8: aload_0
    //   9: getfield 56	com/tencent/mm/plugin/finder/utils/ak:wam	I
    //   12: iconst_1
    //   13: isub
    //   14: putfield 56	com/tencent/mm/plugin/finder/utils/ak:wam	I
    //   17: ldc 59
    //   19: new 61	java/lang/StringBuilder
    //   22: dup
    //   23: ldc 112
    //   25: invokespecial 66	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   28: aload_0
    //   29: getfield 56	com/tencent/mm/plugin/finder/utils/ak:wam	I
    //   32: invokevirtual 70	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   35: invokevirtual 74	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   38: invokestatic 79	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   41: aload_0
    //   42: getfield 56	com/tencent/mm/plugin/finder/utils/ak:wam	I
    //   45: ifle +11 -> 56
    //   48: ldc 110
    //   50: invokestatic 50	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   53: aload_0
    //   54: monitorexit
    //   55: return
    //   56: aload_0
    //   57: getfield 83	com/tencent/mm/plugin/finder/utils/b:dialogRunnable	Lcom/tencent/f/i/d;
    //   60: astore_1
    //   61: aload_1
    //   62: ifnull +11 -> 73
    //   65: aload_1
    //   66: iconst_0
    //   67: invokeinterface 88 2 0
    //   72: pop
    //   73: new 11	com/tencent/mm/plugin/finder/utils/ak$c
    //   76: dup
    //   77: aload_0
    //   78: invokespecial 113	com/tencent/mm/plugin/finder/utils/ak$c:<init>	(Lcom/tencent/mm/plugin/finder/utils/ak;)V
    //   81: checkcast 115	kotlin/g/a/a
    //   84: invokestatic 121	com/tencent/mm/ac/d:h	(Lkotlin/g/a/a;)V
    //   87: ldc 110
    //   89: invokestatic 50	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   92: goto -39 -> 53
    //   95: astore_1
    //   96: aload_0
    //   97: monitorexit
    //   98: aload_1
    //   99: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	100	0	this	ak
    //   60	6	1	locald	com.tencent.f.i.d
    //   95	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	53	95	finally
    //   56	61	95	finally
    //   65	73	95	finally
    //   73	92	95	finally
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/utils/MultiDelayLoadingComponent$Companion;", "", "()V", "TAG", "", "createLoadingDialog", "Lcom/tencent/mm/plugin/finder/utils/MultiDelayLoadingComponent;", "context", "Landroid/content/Context;", "wording", "delay", "", "onCancelListener", "Landroid/content/DialogInterface$OnCancelListener;", "createLoadingProgressBar", "progressBar", "Landroid/widget/ProgressBar;", "plugin-finder_release"})
  public static final class a {}
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class b
    implements Runnable
  {
    b(ak paramak) {}
    
    public final void run()
    {
      AppMethodBeat.i(253799);
      Log.i("MultiDelayLoadingComponent", "begin() show loadingCount:" + ak.a(this.wao));
      ai localai = this.wao.vUZ;
      if (localai != null) {
        localai.dismiss();
      }
      localai = this.wao.vUZ;
      if (localai != null)
      {
        localai.show();
        AppMethodBeat.o(253799);
        return;
      }
      AppMethodBeat.o(253799);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class c
    extends q
    implements a<x>
  {
    c(ak paramak)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.utils.ak
 * JD-Core Version:    0.7.0.1
 */