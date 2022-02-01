package androidx.compose.ui.k;

import androidx.compose.ui.i.f;
import androidx.compose.ui.i.j;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.List<Landroidx.compose.ui.k.e;>;
import kotlin.Metadata;
import kotlin.g.a.b;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"findNodeByPredicateTraversal", "Landroidx/compose/ui/node/LayoutNode;", "predicate", "Lkotlin/Function1;", "", "findOneLayerOfSemanticsWrappersSortedByBounds", "", "Landroidx/compose/ui/semantics/SemanticsWrapper;", "list", "", "findWrapperToGetBounds", "Landroidx/compose/ui/node/LayoutNodeWrapper;", "ui_release"}, k=2, mv={1, 5, 1}, xi=48)
public final class v
{
  public static final j I(f paramf)
  {
    AppMethodBeat.i(205457);
    s.u(paramf, "<this>");
    w localw = p.H(paramf);
    if (localw == null)
    {
      localw = p.G(paramf);
      if (localw == null)
      {
        paramf = paramf.aOC;
        AppMethodBeat.o(205457);
        return paramf;
      }
      paramf = (j)localw;
      AppMethodBeat.o(205457);
      return paramf;
    }
    paramf = (j)localw;
    AppMethodBeat.o(205457);
    return paramf;
  }
  
  private static final List<e> T(List<e> paramList)
  {
    AppMethodBeat.i(205465);
    try
    {
      Object localObject = e.aWo;
      e.a.b(e.b.aWt);
      localObject = kotlin.a.p.J((Collection)paramList);
      kotlin.a.p.N((List)localObject);
      paramList = (List<e>)localObject;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      for (;;)
      {
        e.a locala = e.aWo;
        e.a.b(e.b.aWu);
        paramList = kotlin.a.p.J((Collection)paramList);
        kotlin.a.p.N(paramList);
      }
    }
    AppMethodBeat.o(205465);
    return paramList;
  }
  
  public static final f b(f paramf, b<? super f, Boolean> paramb)
  {
    AppMethodBeat.i(205451);
    s.u(paramf, "<this>");
    s.u(paramb, "predicate");
    if (((Boolean)paramb.invoke(paramf)).booleanValue())
    {
      AppMethodBeat.o(205451);
      return paramf;
    }
    paramf = paramf.xr().qp();
    int i = 0;
    int k = paramf.size() - 1;
    if (k >= 0) {}
    for (;;)
    {
      int j = i + 1;
      f localf = b((f)paramf.get(i), paramb);
      if (localf != null)
      {
        AppMethodBeat.o(205451);
        return localf;
      }
      if (j > k)
      {
        AppMethodBeat.o(205451);
        return null;
      }
      i = j;
    }
  }
  
  public static final List<w> c(f paramf, List<w> paramList)
  {
    int j = 0;
    AppMethodBeat.i(205442);
    s.u(paramf, "<this>");
    s.u(paramList, "list");
    if (!paramf.isAttached())
    {
      AppMethodBeat.o(205442);
      return paramList;
    }
    Object localObject1 = new ArrayList();
    Object localObject2 = paramf.xt();
    int m = ((List)localObject2).size() - 1;
    if (m >= 0) {}
    int k;
    for (int i = 0;; i = k)
    {
      k = i + 1;
      f localf = (f)((List)localObject2).get(i);
      if (localf.isAttached()) {
        ((ArrayList)localObject1).add(new e(paramf, localf));
      }
      if (k > m)
      {
        paramf = T((List)localObject1);
        localObject1 = new ArrayList(paramf.size());
        m = paramf.size() - 1;
        if (m >= 0) {}
        for (i = 0;; i = k)
        {
          k = i + 1;
          localObject2 = paramf.get(i);
          ((Collection)localObject1).add(((e)localObject2).aWq);
          if (k > m)
          {
            paramf = (List)localObject1;
            k = paramf.size() - 1;
            if (k >= 0) {}
            for (i = j;; i = j)
            {
              j = i + 1;
              localObject1 = (f)paramf.get(i);
              localObject2 = p.G((f)localObject1);
              if (localObject2 != null) {
                paramList.add(localObject2);
              }
              while (j > k)
              {
                AppMethodBeat.o(205442);
                return paramList;
                c((f)localObject1, paramList);
              }
            }
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.ui.k.v
 * JD-Core Version:    0.7.0.1
 */