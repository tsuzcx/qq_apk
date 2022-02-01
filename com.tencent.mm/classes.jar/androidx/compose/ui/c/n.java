package androidx.compose.ui.c;

import androidx.compose.ui.i.o;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlin.p;

@Metadata(d1={""}, d2={"invalidFocusDirection", "", "customFocusSearch", "Landroidx/compose/ui/focus/FocusRequester;", "Landroidx/compose/ui/node/ModifiedFocusNode;", "focusDirection", "Landroidx/compose/ui/focus/FocusDirection;", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "customFocusSearch--OM-vw8", "(Landroidx/compose/ui/node/ModifiedFocusNode;ILandroidx/compose/ui/unit/LayoutDirection;)Landroidx/compose/ui/focus/FocusRequester;", "findActiveFocusNode", "moveFocus", "", "moveFocus-Mxy_nc0", "(Landroidx/compose/ui/node/ModifiedFocusNode;I)Z", "ui_release"}, k=2, mv={1, 5, 1}, xi=48)
public final class n
{
  public static final o c(o paramo)
  {
    AppMethodBeat.i(204376);
    Object localObject;
    do
    {
      s.u(paramo, "<this>");
      localObject = paramo.yf();
      switch (a.avl[localObject.ordinal()])
      {
      default: 
        paramo = new p();
        AppMethodBeat.o(204376);
        throw paramo;
      case 1: 
      case 2: 
        AppMethodBeat.o(204376);
        return paramo;
      case 3: 
        localObject = paramo.yg();
        paramo = (o)localObject;
      }
    } while (localObject != null);
    AppMethodBeat.o(204376);
    return null;
    AppMethodBeat.o(204376);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.ui.c.n
 * JD-Core Version:    0.7.0.1
 */