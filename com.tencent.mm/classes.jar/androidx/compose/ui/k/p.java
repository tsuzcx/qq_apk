package androidx.compose.ui.k;

import androidx.compose.runtime.a.e;
import androidx.compose.ui.i.f;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;
import kotlin.Metadata;
import kotlin.g.a.b;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"outerMergingSemantics", "Landroidx/compose/ui/semantics/SemanticsWrapper;", "Landroidx/compose/ui/node/LayoutNode;", "getOuterMergingSemantics", "(Landroidx/compose/ui/node/LayoutNode;)Landroidx/compose/ui/semantics/SemanticsWrapper;", "outerSemantics", "getOuterSemantics", "role", "Landroidx/compose/ui/semantics/Role;", "Landroidx/compose/ui/semantics/SemanticsNode;", "getRole", "(Landroidx/compose/ui/semantics/SemanticsNode;)Landroidx/compose/ui/semantics/Role;", "contentDescriptionFakeNodeId", "", "findClosestParentNode", "selector", "Lkotlin/Function1;", "", "findOneLayerOfSemanticsWrappers", "", "list", "", "nearestSemantics", "Landroidx/compose/ui/node/LayoutNodeWrapper;", "predicate", "roleFakeNodeId", "ui_release"}, k=2, mv={1, 5, 1}, xi=48)
public final class p
{
  public static final w G(f paramf)
  {
    AppMethodBeat.i(205470);
    s.u(paramf, "<this>");
    for (paramf = paramf.aOD.aPZ; paramf != null; paramf = paramf.xg()) {
      if ((paramf instanceof w))
      {
        paramf = (w)paramf;
        AppMethodBeat.o(205470);
        return paramf;
      }
    }
    AppMethodBeat.o(205470);
    return null;
  }
  
  public static final w H(f paramf)
  {
    AppMethodBeat.i(205474);
    s.u(paramf, "<this>");
    for (paramf = paramf.aOD.aPZ; paramf != null; paramf = paramf.xg()) {
      if (((paramf instanceof w)) && (((l)((w)paramf).wb()).zV().aXd))
      {
        paramf = (w)paramf;
        AppMethodBeat.o(205474);
        return paramf;
      }
    }
    AppMethodBeat.o(205474);
    return null;
  }
  
  static final f a(f paramf, b<? super f, Boolean> paramb)
  {
    AppMethodBeat.i(205482);
    for (paramf = paramf.xu(); paramf != null; paramf = paramf.xu()) {
      if (((Boolean)paramb.invoke(paramf)).booleanValue())
      {
        AppMethodBeat.o(205482);
        return paramf;
      }
    }
    AppMethodBeat.o(205482);
    return null;
  }
  
  static final List<w> b(f paramf, List<w> paramList)
  {
    AppMethodBeat.i(205477);
    paramf = paramf.xx();
    int j = paramf.size;
    int i;
    if (j > 0)
    {
      paramf = paramf.aqq;
      i = 0;
    }
    for (;;)
    {
      f localf = (f)paramf[i];
      w localw = G(localf);
      if (localw != null) {
        paramList.add(localw);
      }
      for (;;)
      {
        i += 1;
        if (i < j) {
          break;
        }
        AppMethodBeat.o(205477);
        return paramList;
        b(localf, paramList);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.ui.k.p
 * JD-Core Version:    0.7.0.1
 */