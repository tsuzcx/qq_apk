package androidx.compose.foundation.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.d.a.a;
import kotlin.d.d;
import kotlin.g.b.s;
import kotlinx.coroutines.a.g;
import kotlinx.coroutines.b.ad;
import kotlinx.coroutines.b.w;

@Metadata(d1={""}, d2={"Landroidx/compose/foundation/interaction/MutableInteractionSourceImpl;", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "()V", "interactions", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "Landroidx/compose/foundation/interaction/Interaction;", "getInteractions", "()Lkotlinx/coroutines/flow/MutableSharedFlow;", "emit", "", "interaction", "(Landroidx/compose/foundation/interaction/Interaction;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "tryEmit", "", "foundation_release"}, k=1, mv={1, 5, 1}, xi=48)
final class f
  implements e
{
  private final w<b> abG;
  
  public f()
  {
    AppMethodBeat.i(203572);
    this.abG = ad.a(0, 16, g.ajxy, 1);
    AppMethodBeat.o(203572);
  }
  
  public final Object a(b paramb, d<? super ah> paramd)
  {
    AppMethodBeat.i(203578);
    paramb = this.abG.a(paramb, paramd);
    if (paramb == a.aiwj)
    {
      AppMethodBeat.o(203578);
      return paramb;
    }
    paramb = ah.aiuX;
    AppMethodBeat.o(203578);
    return paramb;
  }
  
  public final boolean a(b paramb)
  {
    AppMethodBeat.i(203586);
    s.u(paramb, "interaction");
    boolean bool = this.abG.jc(paramb);
    AppMethodBeat.o(203586);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.foundation.b.f
 * JD-Core Version:    0.7.0.1
 */