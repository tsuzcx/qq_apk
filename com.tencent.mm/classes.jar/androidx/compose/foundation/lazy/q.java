package androidx.compose.foundation.lazy;

import androidx.compose.foundation.c.a.d;
import androidx.compose.foundation.c.a.l;
import androidx.compose.ui.n.c;
import androidx.compose.ui.n.d;
import androidx.compose.ui.n.n;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.a.ab;
import kotlin.a.p;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"calculateItemsOffsets", "", "items", "", "Landroidx/compose/foundation/lazy/LazyMeasuredItem;", "mainAxisLayoutSize", "", "usedMainAxisSize", "itemsScrollOffset", "isVertical", "", "verticalArrangement", "Landroidx/compose/foundation/layout/Arrangement$Vertical;", "horizontalArrangement", "Landroidx/compose/foundation/layout/Arrangement$Horizontal;", "reverseLayout", "density", "Landroidx/compose/ui/unit/Density;", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "measureLazyList", "Landroidx/compose/foundation/lazy/LazyListMeasureResult;", "itemsCount", "itemProvider", "Landroidx/compose/foundation/lazy/LazyMeasuredItemProvider;", "mainAxisMaxSize", "startContentPadding", "endContentPadding", "firstVisibleItemIndex", "Landroidx/compose/foundation/lazy/DataIndex;", "firstVisibleItemScrollOffset", "scrollToBeConsumed", "", "constraints", "Landroidx/compose/ui/unit/Constraints;", "headerIndexes", "measureLazyList-9CW8viI", "(ILandroidx/compose/foundation/lazy/LazyMeasuredItemProvider;IIIIIFJZLjava/util/List;Landroidx/compose/foundation/layout/Arrangement$Vertical;Landroidx/compose/foundation/layout/Arrangement$Horizontal;ZLandroidx/compose/ui/unit/Density;Landroidx/compose/ui/unit/LayoutDirection;)Landroidx/compose/foundation/lazy/LazyListMeasureResult;", "foundation_release"}, k=2, mv={1, 5, 1}, xi=48)
public final class q
{
  public static final r a(int paramInt1, ad paramad, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, float paramFloat, long paramLong, boolean paramBoolean1, List<Integer> paramList, a.l paraml, a.d paramd, boolean paramBoolean2, d paramd1, n paramn)
  {
    AppMethodBeat.i(204243);
    s.u(paramad, "itemProvider");
    s.u(paramList, "headerIndexes");
    s.u(paramd1, "density");
    s.u(paramn, "layoutDirection");
    if (paramInt3 >= 0) {}
    for (int i = 1; i == 0; i = 0)
    {
      paramad = (Throwable)new IllegalArgumentException("Failed requirement.".toString());
      AppMethodBeat.o(204243);
      throw paramad;
    }
    if (paramInt4 >= 0) {}
    for (i = 1; i == 0; i = 0)
    {
      paramad = (Throwable)new IllegalArgumentException("Failed requirement.".toString());
      AppMethodBeat.o(204243);
      throw paramad;
    }
    if (paramInt1 <= 0)
    {
      paramad = new r(null, 0, false, 0.0F, null, androidx.compose.ui.n.b.aT(paramLong), androidx.compose.ui.n.b.aV(paramLong), (kotlin.g.a.b)q.a.aeT, (List)ab.aivy, -paramInt3, paramInt4, 0);
      AppMethodBeat.o(204243);
      return paramad;
    }
    i = paramInt5;
    if (paramInt5 >= paramInt1)
    {
      i = paramInt1 - 1;
      paramInt6 = 0;
    }
    int j = kotlin.h.a.eH(paramFloat);
    paramInt5 = paramInt6 - j;
    if ((a.C(i, 0)) && (paramInt5 < 0))
    {
      paramInt6 = 0;
      j += paramInt5;
      paramInt5 = paramInt6;
    }
    for (;;)
    {
      List localList = (List)new ArrayList();
      int k = paramInt5 - paramInt3;
      int n = -paramInt3;
      paramInt6 = 0;
      paramInt5 = i;
      i = k;
      Object localObject1;
      while ((i < 0) && (paramInt5 + 0 > 0))
      {
        paramInt5 -= 1;
        localObject1 = paramad.bv(paramInt5);
        localList.add(0, localObject1);
        paramInt6 = Math.max(paramInt6, ((ac)localObject1).ags);
        i += ((ac)localObject1).agr;
      }
      if (i < n)
      {
        k = j + i;
        i = n;
      }
      for (;;)
      {
        int i1 = i + paramInt3;
        localObject1 = null;
        i = -i1;
        j = 0;
        int i3 = localList.size() - 1;
        int m;
        int i2;
        Object localObject2;
        if (i3 >= 0)
        {
          m = i;
          i = paramInt5;
          i2 = j + 1;
          localObject2 = (ac)localList.get(j);
          i += 1;
          m += ((ac)localObject2).agr;
          if (i2 > i3)
          {
            j = m;
            m = i;
            i = j;
            j = i1;
          }
        }
        for (;;)
        {
          if ((i <= paramInt2 + paramInt4) && (m < paramInt1))
          {
            localObject2 = paramad.bv(m);
            i1 = i + ((ac)localObject2).agr;
            if (i1 < n)
            {
              i2 = m + 1;
              paramInt5 = j - ((ac)localObject2).agr;
              if (localObject1 != null) {
                break label1205;
              }
              localObject1 = (List)new ArrayList();
            }
          }
          label655:
          label1057:
          label1074:
          label1205:
          for (;;)
          {
            ((List)localObject1).add(localObject2);
            i = paramInt6;
            paramInt6 = i2;
            for (;;)
            {
              i2 = m + 1;
              j = paramInt6;
              m = paramInt5;
              paramInt6 = i;
              paramInt5 = j;
              j = m;
              i = i1;
              m = i2;
              break;
              i = Math.max(paramInt6, ((ac)localObject2).ags);
              localList.add(localObject2);
              paramInt6 = paramInt5;
              paramInt5 = j;
            }
            if (i < paramInt2)
            {
              i1 = paramInt2 - i;
              m = j - i1;
              n = i + i1;
              j = paramInt6;
              if ((m < 0) && (paramInt5 + 0 > 0))
              {
                paramInt6 = paramInt5 - 1;
                if (localObject1 == null)
                {
                  paramInt5 = -1;
                  if (paramInt5 < 0) {
                    break label728;
                  }
                  s.checkNotNull(localObject1);
                }
                label728:
                for (localObject2 = (ac)((List)localObject1).remove(paramInt5);; localObject2 = paramad.bv(paramInt6))
                {
                  localList.add(0, localObject2);
                  j = Math.max(j, ((ac)localObject2).ags);
                  m += ((ac)localObject2).agr;
                  paramInt5 = paramInt6;
                  break;
                  paramInt5 = p.oE((List)localObject1);
                  break label655;
                }
              }
              i1 = k + i1;
              paramInt5 = n;
              k = i1;
              i = j;
              paramInt6 = m;
              if (m < 0)
              {
                k = i1 + m;
                paramInt5 = n + m;
                paramInt6 = 0;
                i = j;
              }
            }
            for (;;)
            {
              float f = paramFloat;
              if (kotlin.h.a.aKq(kotlin.h.a.eH(paramFloat)) == kotlin.h.a.aKq(k))
              {
                f = paramFloat;
                if (Math.abs(kotlin.h.a.eH(paramFloat)) >= Math.abs(k)) {
                  f = k;
                }
              }
              m = -paramInt6;
              ac localac = (ac)p.oL(localList);
              localObject2 = localac;
              j = paramInt6;
              if (paramInt3 > 0)
              {
                k = 0;
                n = localList.size() - 1;
                localObject2 = localac;
                j = paramInt6;
                if (n >= 0) {
                  localObject2 = localac;
                }
              }
              for (j = k;; j = k)
              {
                k = j + 1;
                i1 = ((ac)localList.get(j)).agr;
                if ((i1 <= paramInt6) && (j != p.oE(localList)))
                {
                  paramInt6 -= i1;
                  localObject2 = (ac)localList.get(j + 1);
                  if (k <= n) {
                    continue;
                  }
                  j = paramInt6;
                  paramInt6 = j;
                  if (!paramBoolean1) {
                    break label1152;
                  }
                  j = i;
                  label982:
                  j = c.g(paramLong, j);
                  if (paramBoolean1) {
                    i = paramInt5;
                  }
                  k = c.h(paramLong, i);
                  if (!paramBoolean1) {
                    break label1159;
                  }
                  i = k;
                  label1018:
                  a(localList, i, paramInt5, m, paramBoolean1, paraml, paramd, paramBoolean2, paramd1, paramn);
                  if (((Collection)paramList).isEmpty()) {
                    break label1166;
                  }
                  i = 1;
                  if (i == 0) {
                    break label1172;
                  }
                  paramad = j.a(localList, (List)localObject1, paramad, paramList, paramInt3);
                  i = Math.min(paramInt5, paramInt2);
                  if (paramInt5 <= paramInt2) {
                    break label1177;
                  }
                }
                for (paramBoolean1 = true;; paramBoolean1 = false)
                {
                  paramInt2 = -paramInt3;
                  paramad = new r((ac)localObject2, paramInt6, paramBoolean1, f, (List)localObject1, j, k, (kotlin.g.a.b)new q.b(localList, paramad, j, k), localList, paramInt2, i + paramInt4, paramInt1);
                  AppMethodBeat.o(204243);
                  return paramad;
                  break;
                  j = paramInt5;
                  break label982;
                  i = j;
                  break label1018;
                  i = 0;
                  break label1057;
                  paramad = null;
                  break label1074;
                }
              }
              paramInt5 = i;
              i = paramInt6;
              paramInt6 = j;
            }
          }
          label1152:
          label1159:
          label1166:
          label1172:
          label1177:
          j = i2;
          break;
          m = paramInt5;
          j = i1;
        }
        k = j;
      }
    }
  }
  
  private static final void a(List<ac> paramList, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean1, a.l paraml, a.d paramd, boolean paramBoolean2, d paramd1, n paramn)
  {
    AppMethodBeat.i(204252);
    if (paramInt2 < paramInt1)
    {
      paramInt2 = 1;
      if (paramInt2 == 0) {
        break label62;
      }
      if (paramInt3 != 0) {
        break label56;
      }
    }
    label56:
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        break label62;
      }
      paramList = (Throwable)new IllegalStateException("Check failed.".toString());
      AppMethodBeat.o(204252);
      throw paramList;
      paramInt2 = 0;
      break;
    }
    label62:
    if (paramInt2 != 0)
    {
      int k = paramList.size();
      paramInt2 = 0;
      int[] arrayOfInt2 = new int[k];
      if (paramInt2 < k)
      {
        if (!paramBoolean2) {}
        for (paramInt3 = paramInt2;; paramInt3 = k - paramInt2 - 1)
        {
          arrayOfInt2[paramInt2] = ((ac)paramList.get(paramInt3)).size;
          paramInt2 += 1;
          break;
        }
      }
      paramInt2 = 0;
      int[] arrayOfInt1 = new int[k];
      while (paramInt2 < k)
      {
        arrayOfInt1[paramInt2] = 0;
        paramInt2 += 1;
      }
      label207:
      int j;
      if (paramBoolean1)
      {
        if (paraml == null)
        {
          paramList = (Throwable)new IllegalArgumentException("Required value was null.".toString());
          AppMethodBeat.o(204252);
          throw paramList;
        }
        paraml.a(paramd1, paramInt1, arrayOfInt2, arrayOfInt1);
        paramInt2 = 0;
        i = 0;
        if (i >= k) {
          break label335;
        }
        j = arrayOfInt1[i];
        if (paramBoolean2) {
          break label325;
        }
      }
      label325:
      for (paramInt3 = paramInt2;; paramInt3 = k - paramInt2 - 1)
      {
        paraml = (ac)paramList.get(paramInt3);
        paramInt3 = j;
        if (paramBoolean2) {
          paramInt3 = paramInt1 - j - paraml.size;
        }
        paraml.offset = paramInt3;
        paramInt2 += 1;
        i += 1;
        break label207;
        if (paramd == null)
        {
          paramList = (Throwable)new IllegalArgumentException("Required value was null.".toString());
          AppMethodBeat.o(204252);
          throw paramList;
        }
        paramd.a(paramd1, paramInt1, arrayOfInt2, paramn, arrayOfInt1);
        break;
      }
      label335:
      AppMethodBeat.o(204252);
      return;
    }
    paramInt1 = 0;
    i = paramList.size() - 1;
    if (i >= 0) {}
    for (;;)
    {
      paramInt2 = paramInt1 + 1;
      paraml = (ac)paramList.get(paramInt1);
      paraml.offset = paramInt3;
      paramInt3 += paraml.agr;
      if (paramInt2 > i)
      {
        AppMethodBeat.o(204252);
        return;
      }
      paramInt1 = paramInt2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.foundation.lazy.q
 * JD-Core Version:    0.7.0.1
 */