package androidx.compose.ui.i;

import android.view.KeyEvent;
import androidx.compose.ui.f.c;
import androidx.compose.ui.g.a.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Landroidx/compose/ui/node/ModifiedKeyInputNode;", "Landroidx/compose/ui/node/DelegatingLayoutNodeWrapper;", "Landroidx/compose/ui/input/key/KeyInputModifier;", "wrapped", "Landroidx/compose/ui/node/LayoutNodeWrapper;", "modifier", "(Landroidx/compose/ui/node/LayoutNodeWrapper;Landroidx/compose/ui/input/key/KeyInputModifier;)V", "findNextKeyInputWrapper", "findPreviousKeyInputWrapper", "propagateKeyEvent", "", "keyEvent", "Landroidx/compose/ui/input/key/KeyEvent;", "propagateKeyEvent-ZmokQxo", "(Landroid/view/KeyEvent;)Z", "propagatePreviewKeyEvent", "propagatePreviewKeyEvent-ZmokQxo", "ui_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class r
  extends b<d>
{
  public r(j paramj, d paramd)
  {
    super(paramj, (f.c)paramd);
    AppMethodBeat.i(204482);
    s.u(this, "<set-?>");
    paramd.aKr = this;
    AppMethodBeat.o(204482);
  }
  
  public final boolean e(KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(204500);
    s.u(paramKeyEvent, "keyEvent");
    Object localObject = ya();
    if (localObject == null) {}
    for (localObject = null; s.p(localObject, Boolean.TRUE); localObject = Boolean.valueOf(((r)localObject).e(paramKeyEvent)))
    {
      bool = ((Boolean)localObject).booleanValue();
      AppMethodBeat.o(204500);
      return bool;
    }
    localObject = ((d)wb()).aKq;
    if (localObject == null)
    {
      AppMethodBeat.o(204500);
      return false;
    }
    paramKeyEvent = (Boolean)((kotlin.g.a.b)localObject).invoke(androidx.compose.ui.g.a.b.d(paramKeyEvent));
    if (paramKeyEvent == null)
    {
      AppMethodBeat.o(204500);
      return false;
    }
    boolean bool = paramKeyEvent.booleanValue();
    AppMethodBeat.o(204500);
    return bool;
  }
  
  public final boolean f(KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(204509);
    Object localObject1 = this;
    Object localObject2;
    do
    {
      s.u(paramKeyEvent, "keyEvent");
      localObject2 = ((d)((r)localObject1).wb()).aKp;
      if (localObject2 == null) {}
      for (localObject2 = null; s.p(localObject2, Boolean.TRUE); localObject2 = (Boolean)((kotlin.g.a.b)localObject2).invoke(androidx.compose.ui.g.a.b.d(paramKeyEvent)))
      {
        boolean bool = ((Boolean)localObject2).booleanValue();
        AppMethodBeat.o(204509);
        return bool;
      }
      localObject2 = ((r)localObject1).ya();
      localObject1 = localObject2;
    } while (localObject2 != null);
    AppMethodBeat.o(204509);
    return false;
  }
  
  public final r xm()
  {
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.ui.i.r
 * JD-Core Version:    0.7.0.1
 */