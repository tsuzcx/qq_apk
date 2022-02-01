package androidx.compose.ui.i;

import androidx.compose.ui.f.c;
import androidx.compose.ui.h.v;
import androidx.compose.ui.h.x;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.a;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Landroidx/compose/ui/node/RemeasureModifierWrapper;", "Landroidx/compose/ui/node/DelegatingLayoutNodeWrapper;", "Landroidx/compose/ui/layout/OnRemeasuredModifier;", "wrapped", "Landroidx/compose/ui/node/LayoutNodeWrapper;", "modifier", "(Landroidx/compose/ui/node/LayoutNodeWrapper;Landroidx/compose/ui/layout/OnRemeasuredModifier;)V", "measure", "Landroidx/compose/ui/layout/Placeable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "measure-BRTryo0", "(J)Landroidx/compose/ui/layout/Placeable;", "ui_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class ad
  extends b<v>
{
  public ad(j paramj, v paramv)
  {
    super(paramj, (f.c)paramv);
    AppMethodBeat.i(204663);
    AppMethodBeat.o(204663);
  }
  
  public final x aw(long paramLong)
  {
    ah localah = null;
    AppMethodBeat.i(204672);
    x localx = super.aw(paramLong);
    a locala = (a)new a(this);
    Object localObject = this.aOb.aOl;
    if (localObject == null) {}
    for (;;)
    {
      if (localah == null) {
        locala.invoke();
      }
      AppMethodBeat.o(204672);
      return localx;
      localObject = ((y)localObject).getSnapshotObserver();
      if (localObject != null)
      {
        ((aa)localObject).k(locala);
        localah = ah.aiuX;
      }
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends u
    implements a<ah>
  {
    a(ad paramad)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.ui.i.ad
 * JD-Core Version:    0.7.0.1
 */