package androidx.compose.ui.g.c.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"AssumePointerMoveStoppedMilliseconds", "", "DefaultWeight", "", "HistorySize", "HorizonMilliseconds", "MinSampleSize", "polyFitLeastSquares", "Landroidx/compose/ui/input/pointer/util/PolynomialFit;", "x", "", "y", "degree", "ui_release"}, k=2, mv={1, 5, 1}, xi=48)
public final class g
{
  public static final c e(List<Float> paramList1, List<Float> paramList2)
  {
    AppMethodBeat.i(205890);
    s.u(paramList1, "x");
    s.u(paramList2, "y");
    if (paramList1.size() != paramList2.size())
    {
      paramList1 = new IllegalArgumentException("x and y must be the same length");
      AppMethodBeat.o(205890);
      throw paramList1;
    }
    if (paramList1.isEmpty())
    {
      paramList1 = new IllegalArgumentException("At least one point must be provided");
      AppMethodBeat.o(205890);
      throw paramList1;
    }
    if (2 >= paramList1.size()) {}
    for (int i = paramList1.size() - 1;; i = 2)
    {
      localObject1 = new ArrayList(3);
      j = 0;
      while (j < 3)
      {
        ((ArrayList)localObject1).add(Float.valueOf(0.0F));
        j += 1;
      }
    }
    Object localObject1 = (List)localObject1;
    int i2 = paramList1.size();
    int i3 = i + 1;
    Object localObject2 = new a(i3, i2);
    int k;
    if (i2 > 0)
    {
      i = 0;
      k = i + 1;
      ((a)localObject2).b(0, i, 1.0F);
      if (1 >= i3) {}
    }
    int m;
    for (int j = 1;; j = m)
    {
      m = j + 1;
      float f1 = ((a)localObject2).ab(j - 1, i);
      ((a)localObject2).b(j, i, ((Number)paramList1.get(i)).floatValue() * f1);
      if (m >= i3)
      {
        if (k >= i2)
        {
          a locala1 = new a(i3, i2);
          a locala2 = new a(i3, i3);
          if (i3 > 0)
          {
            i = 0;
            m = i + 1;
            j = 0;
            if (i2 <= 0) {}
          }
          for (;;)
          {
            k = j + 1;
            locala1.b(i, j, ((a)localObject2).ab(i, j));
            if (k >= i2)
            {
              j = 0;
              label349:
              int n;
              if (i > 0)
              {
                n = j + 1;
                f1 = locala1.aMn[i].a(locala1.aMn[j]);
                k = 0;
                if (i2 <= 0) {}
              }
              for (;;)
              {
                int i1 = k + 1;
                locala1.b(i, k, locala1.ab(i, k) - locala1.ab(j, k) * f1);
                if (i1 >= i2)
                {
                  if (n >= i)
                  {
                    f1 = locala1.aMn[i].wy();
                    if (f1 < 1.0E-006D)
                    {
                      paramList1 = new IllegalArgumentException("Vectors are linearly dependent or zero so no solution. TODO(shepshapard), actually determine what this means");
                      AppMethodBeat.o(205890);
                      throw paramList1;
                    }
                    f1 = 1.0F / f1;
                    j = 0;
                    if (i2 > 0) {}
                    for (;;)
                    {
                      k = j + 1;
                      locala1.b(i, j, locala1.ab(i, j) * f1);
                      if (k >= i2)
                      {
                        if (i3 > 0) {}
                        for (j = 0;; j = k)
                        {
                          k = j + 1;
                          if (j < i)
                          {
                            f1 = 0.0F;
                            locala2.b(i, j, f1);
                            if (k < i3) {
                              continue;
                            }
                            if (m < i3) {
                              break label1115;
                            }
                            localObject2 = new d(i2);
                            if (i2 <= 0) {}
                          }
                          for (i = 0;; i = j)
                          {
                            j = i + 1;
                            ((d)localObject2).f(i, ((Number)paramList2.get(i)).floatValue() * 1.0F);
                            if (j >= i2)
                            {
                              i = i3 - 1;
                              if (i >= 0)
                              {
                                label629:
                                k = i - 1;
                                ((List)localObject1).set(i, Float.valueOf(locala1.aMn[i].a((d)localObject2)));
                                j = i3 - 1;
                                m = i + 1;
                                if (m > j) {}
                              }
                              for (;;)
                              {
                                f1 = ((Number)((List)localObject1).get(i)).floatValue();
                                float f2 = locala2.ab(i, j);
                                ((List)localObject1).set(i, Float.valueOf(f1 - ((Number)((List)localObject1).get(j)).floatValue() * f2));
                                if (j == m)
                                {
                                  ((List)localObject1).set(i, Float.valueOf(((Number)((List)localObject1).get(i)).floatValue() / locala2.ab(i, i)));
                                  if (k < 0)
                                  {
                                    i = 0;
                                    if (i2 > 0)
                                    {
                                      f1 = 0.0F;
                                      label798:
                                      j = i + 1;
                                      f1 += ((Number)paramList2.get(i)).floatValue();
                                      if (j < i2) {}
                                    }
                                    for (;;)
                                    {
                                      float f5 = f1 / i2;
                                      f2 = 0.0F;
                                      if (i2 > 0)
                                      {
                                        i = 0;
                                        f1 = 0.0F;
                                        f2 = 0.0F;
                                        label849:
                                        k = i + 1;
                                        float f4 = 1.0F;
                                        float f3 = ((Number)paramList2.get(i)).floatValue() - ((Number)((List)localObject1).get(0)).floatValue();
                                        if (1 < i3)
                                        {
                                          j = 1;
                                          label898:
                                          m = j + 1;
                                          f4 *= ((Number)paramList1.get(i)).floatValue();
                                          f3 -= ((Number)((List)localObject1).get(j)).floatValue() * f4;
                                          if (m < i3) {
                                            break label1068;
                                          }
                                          label953:
                                          f2 += f3 * (1.0F * f3);
                                          f3 = ((Number)paramList2.get(i)).floatValue() - f5;
                                          f1 = f3 * (1.0F * f3) + f1;
                                          if (k < i2) {
                                            break label1061;
                                          }
                                        }
                                      }
                                      for (;;)
                                      {
                                        if (f1 <= 1.0E-006F) {}
                                        for (f1 = 1.0F;; f1 = 1.0F - f2 / f1)
                                        {
                                          paramList1 = new c((List)localObject1, f1);
                                          AppMethodBeat.o(205890);
                                          return paramList1;
                                          f1 = locala1.aMn[i].a(localObject2.aMn[j]);
                                          break;
                                        }
                                        break label953;
                                        label1061:
                                        i = k;
                                        break label849;
                                        label1068:
                                        j = m;
                                        break label898;
                                        f1 = 0.0F;
                                      }
                                      i = j;
                                      break label798;
                                      f1 = 0.0F;
                                    }
                                  }
                                  i = k;
                                  break label629;
                                }
                                j -= 1;
                              }
                            }
                          }
                          label1115:
                          i = m;
                          break;
                        }
                      }
                      j = k;
                    }
                  }
                  j = n;
                  break label349;
                }
                k = i1;
              }
            }
            j = k;
          }
        }
        i = k;
        break;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.ui.g.c.a.g
 * JD-Core Version:    0.7.0.1
 */