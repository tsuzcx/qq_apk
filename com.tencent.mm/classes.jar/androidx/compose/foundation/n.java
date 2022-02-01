package androidx.compose.foundation;

import androidx.compose.ui.b.h;
import androidx.compose.ui.b.h.a;
import androidx.compose.ui.e.b.c;
import androidx.compose.ui.f;
import androidx.compose.ui.f.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.a.b;
import kotlin.g.a.m;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Landroidx/compose/foundation/IndicationModifier;", "Landroidx/compose/ui/draw/DrawModifier;", "indicationInstance", "Landroidx/compose/foundation/IndicationInstance;", "(Landroidx/compose/foundation/IndicationInstance;)V", "getIndicationInstance", "()Landroidx/compose/foundation/IndicationInstance;", "draw", "", "Landroidx/compose/ui/graphics/drawscope/ContentDrawScope;", "foundation_release"}, k=1, mv={1, 5, 1}, xi=48)
final class n
  implements h
{
  private final l YY;
  
  public n(l paraml)
  {
    AppMethodBeat.i(203574);
    this.YY = paraml;
    AppMethodBeat.o(203574);
  }
  
  public final f a(f paramf)
  {
    AppMethodBeat.i(203596);
    paramf = h.a.a((h)this, paramf);
    AppMethodBeat.o(203596);
    return paramf;
  }
  
  public final <R> R a(R paramR, m<? super R, ? super f.c, ? extends R> paramm)
  {
    AppMethodBeat.i(203582);
    paramR = h.a.a((h)this, paramR, paramm);
    AppMethodBeat.o(203582);
    return paramR;
  }
  
  public final void a(c paramc)
  {
    AppMethodBeat.i(203579);
    s.u(paramc, "<this>");
    this.YY.b(paramc);
    AppMethodBeat.o(203579);
  }
  
  public final boolean a(b<? super f.c, Boolean> paramb)
  {
    AppMethodBeat.i(203593);
    boolean bool = h.a.a((h)this, paramb);
    AppMethodBeat.o(203593);
    return bool;
  }
  
  public final <R> R b(R paramR, m<? super f.c, ? super R, ? extends R> paramm)
  {
    AppMethodBeat.i(203588);
    paramR = h.a.b((h)this, paramR, paramm);
    AppMethodBeat.o(203588);
    return paramR;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.foundation.n
 * JD-Core Version:    0.7.0.1
 */