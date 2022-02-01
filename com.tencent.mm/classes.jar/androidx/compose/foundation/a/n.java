package androidx.compose.foundation.a;

import androidx.compose.foundation.o;
import androidx.compose.runtime.bm;
import androidx.compose.ui.g.b.g;
import androidx.compose.ui.g.b.g.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.ah;
import kotlin.d.a.a;
import kotlin.d.b.a.k;
import kotlin.d.d;
import kotlin.g.a.m;

@Metadata(d1={""}, d2={"Landroidx/compose/foundation/gestures/ScrollDraggableState;", "Landroidx/compose/foundation/gestures/DraggableState;", "Landroidx/compose/foundation/gestures/DragScope;", "scrollLogic", "Landroidx/compose/runtime/State;", "Landroidx/compose/foundation/gestures/ScrollingLogic;", "(Landroidx/compose/runtime/State;)V", "latestScrollScope", "Landroidx/compose/foundation/gestures/ScrollScope;", "getLatestScrollScope", "()Landroidx/compose/foundation/gestures/ScrollScope;", "setLatestScrollScope", "(Landroidx/compose/foundation/gestures/ScrollScope;)V", "getScrollLogic", "()Landroidx/compose/runtime/State;", "dispatchRawDelta", "", "delta", "", "drag", "dragPriority", "Landroidx/compose/foundation/MutatePriority;", "block", "Lkotlin/Function2;", "Lkotlin/coroutines/Continuation;", "", "Lkotlin/ExtensionFunctionType;", "(Landroidx/compose/foundation/MutatePriority;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "dragBy", "pixels", "foundation_release"}, k=1, mv={1, 5, 1}, xi=48)
final class n
  implements f, h
{
  private final bm<u> aaY;
  p aaZ;
  
  public n(bm<u> parambm)
  {
    AppMethodBeat.i(204179);
    this.aaY = parambm;
    this.aaZ = r.mp();
    AppMethodBeat.o(204179);
  }
  
  public final Object b(o paramo, final m<? super f, ? super d<? super ah>, ? extends Object> paramm, d<? super ah> paramd)
  {
    AppMethodBeat.i(204195);
    paramo = ((u)this.aaY.getValue()).ZF.a(paramo, (m)new a(this, paramm, null), paramd);
    if (paramo == a.aiwj)
    {
      AppMethodBeat.o(204195);
      return paramo;
    }
    paramo = ah.aiuX;
    AppMethodBeat.o(204195);
    return paramo;
  }
  
  public final void u(float paramFloat)
  {
    AppMethodBeat.i(204187);
    u localu = (u)this.aaY.getValue();
    p localp = this.aaZ;
    g.a locala = g.aKL;
    localu.a(localp, paramFloat, g.wg());
    AppMethodBeat.o(204187);
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "Landroidx/compose/foundation/gestures/ScrollScope;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends k
    implements m<p, d<? super ah>, Object>
  {
    int label;
    
    a(n paramn, m<? super f, ? super d<? super ah>, ? extends Object> paramm, d<? super a> paramd)
    {
      super(paramd);
    }
    
    public final d<ah> create(Object paramObject, d<?> paramd)
    {
      AppMethodBeat.i(204052);
      paramd = new a(this.aba, paramm, paramd);
      paramd.L$0 = paramObject;
      paramObject = (d)paramd;
      AppMethodBeat.o(204052);
      return paramObject;
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(204042);
      a locala = a.aiwj;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(204042);
        throw paramObject;
      case 0: 
        ResultKt.throwOnFailure(paramObject);
        paramObject = (p)this.L$0;
        n localn = this.aba;
        kotlin.g.b.s.u(paramObject, "<set-?>");
        localn.aaZ = paramObject;
        paramObject = paramm;
        localn = this.aba;
        this.label = 1;
        if (paramObject.invoke(localn, this) == locala)
        {
          AppMethodBeat.o(204042);
          return locala;
        }
        break;
      case 1: 
        ResultKt.throwOnFailure(paramObject);
      }
      paramObject = ah.aiuX;
      AppMethodBeat.o(204042);
      return paramObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.foundation.a.n
 * JD-Core Version:    0.7.0.1
 */