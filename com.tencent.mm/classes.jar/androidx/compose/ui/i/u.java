package androidx.compose.ui.i;

import androidx.compose.ui.f.c;
import androidx.compose.ui.h.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.Metadata;
import kotlin.a.p;

@Metadata(d1={""}, d2={"Landroidx/compose/ui/node/OnGloballyPositionedModifierWrapper;", "Landroidx/compose/ui/node/DelegatingLayoutNodeWrapper;", "Landroidx/compose/ui/layout/OnGloballyPositionedModifier;", "wrapped", "Landroidx/compose/ui/node/LayoutNodeWrapper;", "modifier", "(Landroidx/compose/ui/node/LayoutNodeWrapper;Landroidx/compose/ui/layout/OnGloballyPositionedModifier;)V", "providedAlignmentLines", "", "Landroidx/compose/ui/layout/AlignmentLine;", "getProvidedAlignmentLines", "()Ljava/util/Set;", "ui_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class u
  extends b<androidx.compose.ui.h.s>
{
  public u(j paramj, androidx.compose.ui.h.s params)
  {
    super(paramj, (f.c)params);
    AppMethodBeat.i(204536);
    AppMethodBeat.o(204536);
  }
  
  public final Set<a> xU()
  {
    AppMethodBeat.i(204539);
    Set localSet = (Set)new LinkedHashSet();
    for (j localj = this.aNN; localj != null; localj = localj.xg())
    {
      p.a((Collection)localSet, (Iterable)localj.xU());
      if (kotlin.g.b.s.p(localj, this.aOb.aOC)) {
        break;
      }
    }
    AppMethodBeat.o(204539);
    return localSet;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.ui.i.u
 * JD-Core Version:    0.7.0.1
 */