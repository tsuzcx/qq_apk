package androidx.compose.ui.i;

import androidx.compose.ui.c.c;
import androidx.compose.ui.c.e;
import androidx.compose.ui.c.l;
import androidx.compose.ui.f.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Landroidx/compose/ui/node/ModifiedFocusNode;", "Landroidx/compose/ui/node/DelegatingLayoutNodeWrapper;", "Landroidx/compose/ui/focus/FocusModifier;", "wrapped", "Landroidx/compose/ui/node/LayoutNodeWrapper;", "modifier", "(Landroidx/compose/ui/node/LayoutNodeWrapper;Landroidx/compose/ui/focus/FocusModifier;)V", "value", "Landroidx/compose/ui/focus/FocusStateImpl;", "focusState", "getFocusState", "()Landroidx/compose/ui/focus/FocusStateImpl;", "setFocusState", "(Landroidx/compose/ui/focus/FocusStateImpl;)V", "focusedChild", "getFocusedChild", "()Landroidx/compose/ui/node/ModifiedFocusNode;", "setFocusedChild", "(Landroidx/compose/ui/node/ModifiedFocusNode;)V", "attach", "", "detach", "findNextFocusWrapper", "findPreviousFocusWrapper", "focusRect", "Landroidx/compose/ui/geometry/Rect;", "focusableChildren", "", "onModifierChanged", "populateFocusOrder", "focusOrder", "Landroidx/compose/ui/focus/FocusOrder;", "propagateFocusEvent", "Landroidx/compose/ui/focus/FocusState;", "sendOnFocusEvent", "ui_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class o
  extends b<e>
{
  public o(j paramj, e parame)
  {
    super(paramj, (f.c)parame);
    AppMethodBeat.i(204467);
    s.u(this, "<set-?>");
    parame.auR = this;
    AppMethodBeat.o(204467);
  }
  
  public final void a(androidx.compose.ui.c.g paramg)
  {
    AppMethodBeat.i(204533);
    s.u(paramg, "focusOrder");
    AppMethodBeat.o(204533);
  }
  
  public final void a(androidx.compose.ui.c.k paramk)
  {
    AppMethodBeat.i(204531);
    s.u(paramk, "focusState");
    AppMethodBeat.o(204531);
  }
  
  public final void a(l paraml)
  {
    AppMethodBeat.i(204478);
    s.u(paraml, "value");
    ((e)wb()).a(paraml);
    b((androidx.compose.ui.c.k)paraml);
    AppMethodBeat.o(204478);
  }
  
  public final void b(androidx.compose.ui.c.k paramk)
  {
    AppMethodBeat.i(204507);
    s.u(paramk, "focusState");
    j localj = this.aPj;
    if (localj != null) {
      localj.a(paramk);
    }
    AppMethodBeat.o(204507);
  }
  
  public final void d(o paramo)
  {
    AppMethodBeat.i(204490);
    ((e)wb()).auQ = paramo;
    AppMethodBeat.o(204490);
  }
  
  public final void detach()
  {
    AppMethodBeat.i(204521);
    Object localObject = yf();
    switch (a.$EnumSwitchMapping$0[localObject.ordinal()])
    {
    }
    for (;;)
    {
      super.detach();
      AppMethodBeat.o(204521);
      return;
      localObject = this.aOb.aOl;
      if (localObject != null)
      {
        localObject = ((y)localObject).getFocusManager();
        if (localObject != null)
        {
          ((c)localObject).sp();
          continue;
          localObject = this.aNN.xk();
          if (localObject == null) {
            localObject = androidx.compose.ui.c.f.a(this.aOb);
          }
          for (;;)
          {
            if (localObject == null) {
              break label147;
            }
            o localo = xZ();
            if (localo != null) {
              ((e)localo.wb()).auQ = ((o)localObject);
            }
            b((androidx.compose.ui.c.k)((o)localObject).yf());
            break;
          }
          label147:
          b((androidx.compose.ui.c.k)l.avj);
        }
      }
    }
  }
  
  public final void vV()
  {
    AppMethodBeat.i(204512);
    super.vV();
    b((androidx.compose.ui.c.k)yf());
    AppMethodBeat.o(204512);
  }
  
  public final void vX()
  {
    AppMethodBeat.i(204515);
    super.vX();
    b((androidx.compose.ui.c.k)yf());
    AppMethodBeat.o(204515);
  }
  
  public final o xj()
  {
    return this;
  }
  
  public final o xk()
  {
    return this;
  }
  
  public final l yf()
  {
    AppMethodBeat.i(204472);
    l locall = ((e)wb()).auP;
    AppMethodBeat.o(204472);
    return locall;
  }
  
  public final o yg()
  {
    AppMethodBeat.i(204484);
    o localo = ((e)wb()).auQ;
    AppMethodBeat.o(204484);
    return localo;
  }
  
  public final androidx.compose.ui.d.g yh()
  {
    AppMethodBeat.i(204495);
    androidx.compose.ui.d.g localg = androidx.compose.ui.h.k.d((androidx.compose.ui.h.j)this);
    AppMethodBeat.o(204495);
    return localg;
  }
  
  public final List<o> yi()
  {
    AppMethodBeat.i(204501);
    Object localObject = this.aNN.xk();
    if (localObject != null)
    {
      localObject = p.listOf(localObject);
      AppMethodBeat.o(204501);
      return localObject;
    }
    localObject = (List)new ArrayList();
    List localList = this.aOb.xt();
    int i = 0;
    int k = localList.size() - 1;
    if (k >= 0) {}
    for (;;)
    {
      int j = i + 1;
      androidx.compose.ui.c.f.a((f)localList.get(i), (List)localObject);
      if (j > k)
      {
        AppMethodBeat.o(204501);
        return localObject;
      }
      i = j;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.ui.i.o
 * JD-Core Version:    0.7.0.1
 */