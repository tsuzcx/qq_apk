package androidx.compose.ui.i;

import androidx.compose.ui.c.g;
import androidx.compose.ui.c.h;
import androidx.compose.ui.f.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Landroidx/compose/ui/node/ModifiedFocusOrderNode;", "Landroidx/compose/ui/node/DelegatingLayoutNodeWrapper;", "Landroidx/compose/ui/focus/FocusOrderModifier;", "wrapped", "Landroidx/compose/ui/node/LayoutNodeWrapper;", "modifier", "(Landroidx/compose/ui/node/LayoutNodeWrapper;Landroidx/compose/ui/focus/FocusOrderModifier;)V", "populateFocusOrder", "", "focusOrder", "Landroidx/compose/ui/focus/FocusOrder;", "ui_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class p
  extends b<h>
{
  public p(j paramj, h paramh)
  {
    super(paramj, (f.c)paramh);
    AppMethodBeat.i(204450);
    AppMethodBeat.o(204450);
  }
  
  public final void a(g paramg)
  {
    AppMethodBeat.i(204455);
    s.u(paramg, "focusOrder");
    wb();
    super.a(paramg);
    AppMethodBeat.o(204455);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.ui.i.p
 * JD-Core Version:    0.7.0.1
 */