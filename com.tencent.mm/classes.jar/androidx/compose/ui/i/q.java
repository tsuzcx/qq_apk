package androidx.compose.ui.i;

import androidx.compose.runtime.a.e;
import androidx.compose.ui.c.i;
import androidx.compose.ui.f.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Landroidx/compose/ui/node/ModifiedFocusRequesterNode;", "Landroidx/compose/ui/node/DelegatingLayoutNodeWrapper;", "Landroidx/compose/ui/focus/FocusRequesterModifier;", "wrapped", "Landroidx/compose/ui/node/LayoutNodeWrapper;", "modifier", "(Landroidx/compose/ui/node/LayoutNodeWrapper;Landroidx/compose/ui/focus/FocusRequesterModifier;)V", "value", "Landroidx/compose/ui/focus/FocusRequester;", "focusRequester", "setFocusRequester", "(Landroidx/compose/ui/focus/FocusRequester;)V", "attach", "", "detach", "findFocusNode", "Landroidx/compose/ui/node/ModifiedFocusNode;", "findFocusNode$ui_release", "onModifierChanged", "ui_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class q
  extends b<androidx.compose.ui.c.j>
{
  private i aPS;
  
  public q(j paramj, androidx.compose.ui.c.j paramj1)
  {
    super(paramj, (f.c)paramj1);
    AppMethodBeat.i(204474);
    AppMethodBeat.o(204474);
  }
  
  private final void a(i parami)
  {
    AppMethodBeat.i(204481);
    Object localObject = this.aPS;
    if (localObject != null)
    {
      localObject = ((i)localObject).avc;
      if (localObject != null) {
        ((e)localObject).remove(this);
      }
    }
    this.aPS = parami;
    parami = this.aPS;
    if (parami != null)
    {
      parami = parami.avc;
      if (parami != null) {
        parami.add(this);
      }
    }
    AppMethodBeat.o(204481);
  }
  
  public final void detach()
  {
    AppMethodBeat.i(204498);
    a(null);
    super.detach();
    AppMethodBeat.o(204498);
  }
  
  public final void vV()
  {
    AppMethodBeat.i(204486);
    super.vV();
    a(((androidx.compose.ui.c.j)wb()).st());
    AppMethodBeat.o(204486);
  }
  
  public final void vX()
  {
    AppMethodBeat.i(204492);
    super.vX();
    a(((androidx.compose.ui.c.j)wb()).st());
    AppMethodBeat.o(204492);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.ui.i.q
 * JD-Core Version:    0.7.0.1
 */