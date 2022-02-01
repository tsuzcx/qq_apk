package androidx.compose.foundation.lazy;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;
import java.util.List<Ljava.lang.Integer;>;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"findOrComposeLazyListHeader", "Landroidx/compose/foundation/lazy/LazyMeasuredItem;", "composedVisibleItems", "", "notUsedButComposedItems", "", "itemProvider", "Landroidx/compose/foundation/lazy/LazyMeasuredItemProvider;", "headerIndexes", "", "startContentPadding", "foundation_release"}, k=2, mv={1, 5, 1}, xi=48)
public final class j
{
  public static final ac a(List<ac> paramList1, List<ac> paramList2, ad paramad, List<Integer> paramList, int paramInt)
  {
    AppMethodBeat.i(204229);
    s.u(paramList1, "composedVisibleItems");
    s.u(paramad, "itemProvider");
    s.u(paramList, "headerIndexes");
    Object localObject2 = null;
    int i = -2147483648;
    int j = -1;
    int i1 = ((ac)p.oK(paramList1)).index;
    int i2 = paramList.size() - 1;
    int m;
    int k;
    int n;
    Object localObject1;
    if (i2 >= 0)
    {
      m = 0;
      k = -1;
      n = m + 1;
      if (((Number)paramList.get(m)).intValue() <= i1)
      {
        j = ((Number)paramList.get(m)).intValue();
        k = m + 1;
        if ((k < 0) || (k > p.oE(paramList))) {
          break label245;
        }
        localObject1 = paramList.get(k);
        k = ((Number)localObject1).intValue();
        if (n <= i2) {
          break label497;
        }
      }
    }
    for (;;)
    {
      n = 0;
      i2 = paramList1.size() - 1;
      if (i2 >= 0)
      {
        m = -2147483648;
        paramList = localObject2;
        label179:
        i1 = n + 1;
        localObject1 = (ac)paramList1.get(n);
        if (((ac)localObject1).index == j)
        {
          i = ((ac)localObject1).offset;
          paramList = (List<Integer>)localObject1;
          label218:
          if (i1 <= i2) {
            break label480;
          }
          k = m;
        }
      }
      for (localObject1 = paramList;; localObject1 = null)
      {
        if (j == -1)
        {
          AppMethodBeat.o(204229);
          return null;
          label245:
          localObject1 = Integer.valueOf(-1);
          break;
          if (((ac)localObject1).index != k) {
            break label477;
          }
          m = ((ac)localObject1).offset;
          break label218;
        }
        paramList = (List<Integer>)localObject1;
        if (localObject1 == null)
        {
          if (paramList2 != null) {
            break label364;
          }
          paramList2 = null;
          paramList = paramList2;
          if (paramList2 == null)
          {
            paramList = paramad.bv(j);
            paramList1.add(0, paramList);
          }
        }
        if (i != -2147483648)
        {
          paramInt = Math.max(-paramInt, i);
          label326:
          i = paramInt;
          if (k != -2147483648) {
            i = Math.min(paramInt, k - paramList.size);
          }
          paramList.offset = i;
          AppMethodBeat.o(204229);
          return paramList;
          label364:
          m = 0;
          i1 = paramList2.size() - 1;
          if (i1 < 0) {}
        }
        for (;;)
        {
          n = m + 1;
          paramList = paramList2.get(m);
          if (((ac)paramList).index == j)
          {
            m = 1;
            label412:
            if (m == 0) {
              break label439;
            }
          }
          for (paramList2 = paramList;; paramList2 = null)
          {
            paramList2 = (ac)paramList2;
            if (paramList2 != null) {
              break label451;
            }
            paramList2 = null;
            break;
            m = 0;
            break label412;
            label439:
            if (n <= i1) {
              break label470;
            }
          }
          label451:
          paramList1.add(0, paramList2);
          break;
          paramInt = -paramInt;
          break label326;
          label470:
          m = n;
        }
        label477:
        break label218;
        label480:
        n = i1;
        break label179;
        k = -2147483648;
      }
      label497:
      m = n;
      break;
      k = -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.foundation.lazy.j
 * JD-Core Version:    0.7.0.1
 */