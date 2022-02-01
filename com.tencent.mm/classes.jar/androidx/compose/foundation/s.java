package androidx.compose.foundation;

import androidx.compose.foundation.a.p;
import androidx.compose.foundation.a.t;
import androidx.compose.foundation.b.e;
import androidx.compose.runtime.an;
import androidx.compose.runtime.bj;
import androidx.compose.runtime.bm;
import androidx.compose.runtime.e.i;
import androidx.compose.runtime.e.j;
import androidx.compose.runtime.e.k;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.d.a.a;
import kotlin.g.a.b;
import kotlin.g.a.m;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Landroidx/compose/foundation/ScrollState;", "Landroidx/compose/foundation/gestures/ScrollableState;", "initial", "", "(I)V", "_maxValueState", "Landroidx/compose/runtime/MutableState;", "accumulator", "", "interactionSource", "Landroidx/compose/foundation/interaction/InteractionSource;", "getInteractionSource", "()Landroidx/compose/foundation/interaction/InteractionSource;", "internalInteractionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "getInternalInteractionSource$foundation_release", "()Landroidx/compose/foundation/interaction/MutableInteractionSource;", "isScrollInProgress", "", "()Z", "newMax", "maxValue", "getMaxValue", "()I", "setMaxValue$foundation_release", "scrollableState", "<set-?>", "value", "getValue", "setValue", "value$delegate", "Landroidx/compose/runtime/MutableState;", "animateScrollTo", "", "animationSpec", "Landroidx/compose/animation/core/AnimationSpec;", "(ILandroidx/compose/animation/core/AnimationSpec;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "dispatchRawDelta", "delta", "scroll", "scrollPriority", "Landroidx/compose/foundation/MutatePriority;", "block", "Lkotlin/Function2;", "Landroidx/compose/foundation/gestures/ScrollScope;", "Lkotlin/coroutines/Continuation;", "", "Lkotlin/ExtensionFunctionType;", "(Landroidx/compose/foundation/MutatePriority;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "scrollTo", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "foundation_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class s
  implements androidx.compose.foundation.a.s
{
  public static final s.a ZB;
  private static final i<s, ?> ZG;
  private final an Uv;
  final e ZC;
  an<Integer> ZD;
  private float ZE;
  private final androidx.compose.foundation.a.s ZF;
  
  static
  {
    AppMethodBeat.i(203589);
    ZB = new s.a((byte)0);
    ZG = j.b((m)b.ZH, (b)c.ZI);
    AppMethodBeat.o(203589);
  }
  
  public s(int paramInt)
  {
    AppMethodBeat.i(203559);
    this.Uv = bj.b(Integer.valueOf(paramInt), bj.qi());
    this.ZC = androidx.compose.foundation.b.d.ms();
    this.ZD = bj.b(Integer.valueOf(2147483647), bj.qi());
    this.ZF = t.d((b)new d(this));
    AppMethodBeat.o(203559);
  }
  
  public final Object a(o paramo, m<? super p, ? super kotlin.d.d<? super ah>, ? extends Object> paramm, kotlin.d.d<? super ah> paramd)
  {
    AppMethodBeat.i(203620);
    paramo = this.ZF.a(paramo, paramm, paramd);
    if (paramo == a.aiwj)
    {
      AppMethodBeat.o(203620);
      return paramo;
    }
    paramo = ah.aiuX;
    AppMethodBeat.o(203620);
    return paramo;
  }
  
  public final int getMaxValue()
  {
    AppMethodBeat.i(203607);
    int i = ((Number)this.ZD.getValue()).intValue();
    AppMethodBeat.o(203607);
    return i;
  }
  
  public final int getValue()
  {
    AppMethodBeat.i(203595);
    int i = ((Number)((bm)this.Uv).getValue()).intValue();
    AppMethodBeat.o(203595);
    return i;
  }
  
  public final boolean ml()
  {
    AppMethodBeat.i(203634);
    boolean bool = this.ZF.ml();
    AppMethodBeat.o(203634);
    return bool;
  }
  
  public final float s(float paramFloat)
  {
    AppMethodBeat.i(203626);
    paramFloat = this.ZF.s(paramFloat);
    AppMethodBeat.o(203626);
    return paramFloat;
  }
  
  final void setValue(int paramInt)
  {
    AppMethodBeat.i(203598);
    this.Uv.setValue(Integer.valueOf(paramInt));
    AppMethodBeat.o(203598);
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "Landroidx/compose/runtime/saveable/SaverScope;", "it", "Landroidx/compose/foundation/ScrollState;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements m<k, s, Integer>
  {
    public static final b ZH;
    
    static
    {
      AppMethodBeat.i(203599);
      ZH = new b();
      AppMethodBeat.o(203599);
    }
    
    b()
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroidx/compose/foundation/ScrollState;", "it", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements b<Integer, s>
  {
    public static final c ZI;
    
    static
    {
      AppMethodBeat.i(203604);
      ZI = new c();
      AppMethodBeat.o(203604);
    }
    
    c()
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it"}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends u
    implements b<Float, Float>
  {
    d(s params)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.foundation.s
 * JD-Core Version:    0.7.0.1
 */