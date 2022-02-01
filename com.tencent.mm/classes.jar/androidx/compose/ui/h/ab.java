package androidx.compose.ui.h;

import androidx.compose.ui.i.f.e;
import androidx.compose.ui.n.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Landroidx/compose/ui/layout/RootMeasurePolicy;", "Landroidx/compose/ui/node/LayoutNode$NoIntrinsicsMeasurePolicy;", "()V", "measure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "measurables", "", "Landroidx/compose/ui/layout/Measurable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Ljava/util/List;J)Landroidx/compose/ui/layout/MeasureResult;", "ui_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class ab
  extends f.e
{
  public static final ab aNd;
  
  static
  {
    AppMethodBeat.i(205571);
    aNd = new ab();
    AppMethodBeat.o(205571);
  }
  
  private ab()
  {
    super("Undefined intrinsics block and it is required");
  }
  
  public final q a(r paramr, List<? extends o> paramList, long paramLong)
  {
    AppMethodBeat.i(205587);
    s.u(paramr, "$receiver");
    s.u(paramList, "measurables");
    if (paramList.isEmpty())
    {
      paramr = r.a.a(paramr, androidx.compose.ui.n.b.aT(paramLong), androidx.compose.ui.n.b.aV(paramLong), (kotlin.g.a.b)ab.a.aNe);
      AppMethodBeat.o(205587);
      return paramr;
    }
    if (paramList.size() == 1)
    {
      paramList = ((o)paramList.get(0)).aw(paramLong);
      paramr = r.a.a(paramr, c.g(paramLong, paramList.width), c.h(paramLong, paramList.height), (kotlin.g.a.b)new ab.b(paramList));
      AppMethodBeat.o(205587);
      return paramr;
    }
    Object localObject1 = new ArrayList(paramList.size());
    int k = paramList.size() - 1;
    if (k >= 0) {}
    int j;
    for (int i = 0;; i = j)
    {
      j = i + 1;
      Object localObject2 = paramList.get(i);
      ((Collection)localObject1).add(((o)localObject2).aw(paramLong));
      if (j > k)
      {
        paramList = (List)localObject1;
        int n = paramList.size() - 1;
        int m;
        if (n >= 0)
        {
          i = 0;
          j = 0;
          k = 0;
          m = i + 1;
          localObject1 = (x)paramList.get(i);
          k = Math.max(((x)localObject1).width, k);
          j = Math.max(((x)localObject1).height, j);
          if (m <= n) {}
        }
        for (;;)
        {
          paramr = r.a.a(paramr, c.g(paramLong, k), c.h(paramLong, j), (kotlin.g.a.b)new ab.c(paramList));
          AppMethodBeat.o(205587);
          return paramr;
          i = m;
          break;
          j = 0;
          k = 0;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.ui.h.ab
 * JD-Core Version:    0.7.0.1
 */