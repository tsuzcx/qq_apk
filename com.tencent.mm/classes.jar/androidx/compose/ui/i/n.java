package androidx.compose.ui.i;

import androidx.compose.ui.c.e;
import androidx.compose.ui.c.f;
import androidx.compose.ui.c.k;
import androidx.compose.ui.c.l;
import androidx.compose.ui.f.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Landroidx/compose/ui/node/ModifiedFocusEventNode;", "Landroidx/compose/ui/node/DelegatingLayoutNodeWrapper;", "Landroidx/compose/ui/focus/FocusEventModifier;", "wrapped", "Landroidx/compose/ui/node/LayoutNodeWrapper;", "modifier", "(Landroidx/compose/ui/node/LayoutNodeWrapper;Landroidx/compose/ui/focus/FocusEventModifier;)V", "onModifierChanged", "", "propagateFocusEvent", "focusState", "Landroidx/compose/ui/focus/FocusState;", "ui_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class n
  extends b<androidx.compose.ui.c.b>
{
  public n(j paramj, androidx.compose.ui.c.b paramb)
  {
    super(paramj, (f.c)paramb);
    AppMethodBeat.i(204456);
    AppMethodBeat.o(204456);
  }
  
  public final void a(k paramk)
  {
    AppMethodBeat.i(204461);
    s.u(paramk, "focusState");
    wb();
    super.a(paramk);
    AppMethodBeat.o(204461);
  }
  
  public final void vV()
  {
    AppMethodBeat.i(204468);
    super.vV();
    o localo = this.aNN.xk();
    Object localObject = localo;
    if (localo == null) {
      localObject = f.a(this.aOb);
    }
    wb();
    if (localObject == null) {
      localObject = null;
    }
    for (;;)
    {
      if (localObject == null) {
        localObject = l.avj;
      }
      AppMethodBeat.o(204468);
      return;
      localObject = (e)((o)localObject).wb();
      if (localObject == null) {
        localObject = null;
      } else {
        localObject = ((e)localObject).auP;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.ui.i.n
 * JD-Core Version:    0.7.0.1
 */