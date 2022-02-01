package androidx.constraintlayout.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public final class a
{
  private static int a(f paramf)
  {
    AppMethodBeat.i(229217);
    int i = -1;
    if (paramf.fM() == f.a.Dq) {
      if (paramf.CC == 0)
      {
        i = (int)(paramf.getHeight() * paramf.CB);
        paramf.setWidth(i);
      }
    }
    while (paramf.fN() != f.a.Dq) {
      for (;;)
      {
        AppMethodBeat.o(229217);
        return i;
        i = (int)(paramf.getHeight() / paramf.CB);
      }
    }
    if (paramf.CC == 1) {}
    for (i = (int)(paramf.getWidth() * paramf.CB);; i = (int)(paramf.getWidth() / paramf.CB))
    {
      paramf.setHeight(i);
      break;
    }
  }
  
  private static int a(f paramf, int paramInt)
  {
    AppMethodBeat.i(229213);
    int i = paramInt * 2;
    e locale1 = paramf.Cx[i];
    e locale2 = paramf.Cx[(i + 1)];
    if ((locale1.Bv != null) && (locale1.Bv.Bt == paramf.CA) && (locale2.Bv != null) && (locale2.Bv.Bt == paramf.CA))
    {
      i = paramf.CA.aV(paramInt);
      if (paramInt == 0) {}
      for (float f = paramf.CT;; f = paramf.CU)
      {
        paramInt = paramf.aV(paramInt);
        paramInt = (int)(f * (i - locale1.fv() - locale2.fv() - paramInt));
        AppMethodBeat.o(229213);
        return paramInt;
      }
    }
    AppMethodBeat.o(229213);
    return 0;
  }
  
  private static int a(f paramf, int paramInt1, boolean paramBoolean, int paramInt2)
  {
    AppMethodBeat.i(229181);
    if (!paramf.Db)
    {
      AppMethodBeat.o(229181);
      return 0;
    }
    int k;
    int i1;
    int n;
    int j;
    label69:
    int i2;
    int m;
    label102:
    int i3;
    int i6;
    int i8;
    if ((paramf.Ct.Bv != null) && (paramInt1 == 1))
    {
      k = 1;
      if (!paramBoolean) {
        break label229;
      }
      i1 = paramf.CN;
      n = paramf.getHeight() - paramf.CN;
      j = paramInt1 * 2;
      i = j + 1;
      if ((paramf.Cx[i].Bv == null) || (paramf.Cx[j].Bv != null)) {
        break label260;
      }
      i2 = -1;
      m = i;
      i3 = paramInt2;
      if (k != 0) {
        i3 = paramInt2 - i1;
      }
      i6 = paramf.Cx[m].fv() * i2 + a(paramf, paramInt1);
      i8 = i6 + i3;
      if (paramInt1 != 0) {
        break label274;
      }
    }
    int i7;
    label260:
    label274:
    for (paramInt2 = paramf.getWidth();; paramInt2 = paramf.getHeight())
    {
      i7 = paramInt2 * i2;
      localObject = paramf.Cx[m].Bs.Es.iterator();
      for (paramInt2 = 0; ((Iterator)localObject).hasNext(); paramInt2 = Math.max(paramInt2, a(((m)((Iterator)localObject).next()).Ei.Bt, paramInt1, paramBoolean, i8))) {}
      k = 0;
      break;
      label229:
      i1 = paramf.getHeight() - paramf.CN;
      n = paramf.CN;
      i = paramInt1 * 2;
      j = i + 1;
      break label69;
      i2 = 1;
      m = j;
      j = i;
      break label102;
    }
    Object localObject = paramf.Cx[j].Bs.Es.iterator();
    for (int i = 0; ((Iterator)localObject).hasNext(); i = Math.max(i, a(((m)((Iterator)localObject).next()).Ei.Bt, paramInt1, paramBoolean, i7 + i8))) {}
    int i4;
    int i5;
    if (k != 0)
    {
      i4 = i + n;
      i5 = paramInt2 - i1;
      if (paramInt1 == 1)
      {
        localObject = paramf.Ct.Bs.Es.iterator();
        paramInt2 = 0;
      }
    }
    else
    {
      for (;;)
      {
        if (!((Iterator)localObject).hasNext()) {
          break label513;
        }
        m localm = (m)((Iterator)localObject).next();
        if (i2 == 1)
        {
          paramInt2 = Math.max(paramInt2, a(localm.Ei.Bt, paramInt1, paramBoolean, i1 + i8));
          continue;
          if (paramInt1 == 0) {}
          for (i4 = paramf.getWidth();; i4 = paramf.getHeight())
          {
            i4 = i4 * i2 + i;
            i5 = paramInt2;
            break;
          }
        }
        else
        {
          paramInt2 = Math.max(paramInt2, a(localm.Ei.Bt, paramInt1, paramBoolean, n * i2 + i8));
        }
      }
      label513:
      i = paramInt2;
      if (paramf.Ct.Bs.Es.size() > 0)
      {
        i = paramInt2;
        if (k == 0)
        {
          if (i2 != 1) {
            break label720;
          }
          i = paramInt2 + i1;
        }
      }
    }
    for (;;)
    {
      n = Math.max(i5, Math.max(i4, i));
      paramInt2 = i3 + i6;
      i = paramInt2 + i7;
      if (i2 == -1) {}
      for (;;)
      {
        if (paramBoolean)
        {
          k.a(paramf, paramInt1, i);
          paramf.c(i, paramInt2, paramInt1);
        }
        for (;;)
        {
          if ((paramf.aW(paramInt1) == f.a.Dq) && (paramf.CB != 0.0F)) {
            paramf.Cm.c(paramf, paramInt1);
          }
          if ((paramf.Cx[m].Bv != null) && (paramf.Cx[j].Bv != null))
          {
            localObject = paramf.CA;
            if ((paramf.Cx[m].Bv.Bt == localObject) && (paramf.Cx[j].Bv.Bt == localObject)) {
              paramf.Cm.c(paramf, paramInt1);
            }
          }
          AppMethodBeat.o(229181);
          return n + i6;
          label720:
          i = paramInt2 - n;
          break;
          paramf.Cm.c(paramf, paramInt1);
          paramf.y(i, paramInt1);
        }
        k = paramInt2;
        paramInt2 = i;
        i = k;
      }
      i = 0;
    }
  }
  
  private static int a(h paramh, int paramInt)
  {
    AppMethodBeat.i(229152);
    int k = paramInt * 2;
    List localList;
    int i;
    int j;
    label33:
    f localf;
    if (paramInt == 0)
    {
      localList = paramh.DS;
      int m = localList.size();
      i = 0;
      j = 0;
      if (i >= m) {
        break label148;
      }
      localf = (f)localList.get(i);
      if ((localf.Cx[(k + 1)].Bv != null) && ((localf.Cx[k].Bv == null) || (localf.Cx[(k + 1)].Bv == null))) {
        break label142;
      }
    }
    label142:
    for (boolean bool = true;; bool = false)
    {
      j = Math.max(j, a(localf, paramInt, bool, 0));
      i += 1;
      break label33;
      if (paramInt == 1)
      {
        localList = paramh.DT;
        break;
      }
      localList = null;
      break;
    }
    label148:
    paramh.DR[paramInt] = j;
    AppMethodBeat.o(229152);
    return j;
  }
  
  public static void a(g paramg)
  {
    AppMethodBeat.i(229124);
    if ((paramg.DJ & 0x20) != 32)
    {
      b(paramg);
      AppMethodBeat.o(229124);
      return;
    }
    paramg.DK = true;
    paramg.DE = false;
    paramg.DF = false;
    paramg.DG = false;
    Object localObject1 = paramg.Ew;
    List localList = paramg.DD;
    int i;
    int j;
    if (paramg.fM() == f.a.Dp)
    {
      i = 1;
      if (paramg.fN() != f.a.Dp) {
        break label157;
      }
      j = 1;
      label83:
      if ((i == 0) && (j == 0)) {
        break label162;
      }
    }
    Object localObject2;
    Object localObject3;
    label157:
    label162:
    for (boolean bool = true;; bool = false)
    {
      localList.clear();
      localObject2 = ((List)localObject1).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (f)((Iterator)localObject2).next();
        ((f)localObject3).Cm = null;
        ((f)localObject3).Dd = false;
        ((f)localObject3).fr();
      }
      i = 0;
      break;
      j = 0;
      break label83;
    }
    localObject1 = ((List)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (f)((Iterator)localObject1).next();
      if (((f)localObject2).Cm == null)
      {
        localObject3 = new h(new ArrayList(), (byte)0);
        localList.add(localObject3);
        if (!a((f)localObject2, (h)localObject3, localList, bool))
        {
          b(paramg);
          paramg.DK = false;
          AppMethodBeat.o(229124);
          return;
        }
      }
    }
    localObject1 = localList.iterator();
    int k = 0;
    int m = 0;
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (h)((Iterator)localObject1).next();
      m = Math.max(m, a((h)localObject2, 0));
      k = Math.max(k, a((h)localObject2, 1));
    }
    if (i != 0)
    {
      paramg.a(f.a.Do);
      paramg.setWidth(m);
      paramg.DE = true;
      paramg.DF = true;
      paramg.DH = m;
    }
    if (j != 0)
    {
      paramg.b(f.a.Do);
      paramg.setHeight(k);
      paramg.DE = true;
      paramg.DG = true;
      paramg.DI = k;
    }
    a(localList, 0, paramg.getWidth());
    a(localList, 1, paramg.getHeight());
    AppMethodBeat.o(229124);
  }
  
  private static void a(g paramg, f paramf, h paramh)
  {
    paramh.DK = false;
    paramg.DK = false;
    paramf.Db = false;
  }
  
  public static void a(List<h> paramList, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(229200);
    int k = paramList.size();
    int j = 0;
    while (j < k)
    {
      Object localObject = (h)paramList.get(j);
      if (paramInt1 == 0)
      {
        localObject = ((h)localObject).DU;
        localObject = ((Set)localObject).iterator();
      }
      label183:
      for (;;)
      {
        label57:
        if (((Iterator)localObject).hasNext())
        {
          f localf = (f)((Iterator)localObject).next();
          if (localf.Db)
          {
            int m = paramInt1 * 2;
            e locale1 = localf.Cx[m];
            e locale2 = localf.Cx[(m + 1)];
            if ((locale1.Bv != null) && (locale2.Bv != null)) {}
            for (int i = 1;; i = 0)
            {
              if (i == 0) {
                break label183;
              }
              k.a(localf, paramInt1, a(localf, paramInt1) + locale1.fv());
              break label57;
              if (paramInt1 == 1)
              {
                localObject = ((h)localObject).DV;
                break;
              }
              localObject = null;
              break;
            }
            if ((localf.CB != 0.0F) && (localf.aW(paramInt1) == f.a.Dq))
            {
              i = a(localf);
              m = (int)localf.Cx[m].Bs.El;
              locale2.Bs.Ek = locale1.Bs;
              locale2.Bs.El = i;
              locale2.Bs.state = 1;
              localf.c(m, m + i, paramInt1);
            }
            else
            {
              if (paramInt1 == 0) {
                i = localf.CF;
              }
              for (;;)
              {
                i = paramInt2 - i;
                m = i - localf.aV(paramInt1);
                localf.c(m, i, paramInt1);
                k.a(localf, paramInt1, m);
                break;
                if (paramInt1 == 1) {
                  i = localf.CG;
                } else {
                  i = 0;
                }
              }
            }
          }
        }
      }
      j += 1;
    }
    AppMethodBeat.o(229200);
  }
  
  private static boolean a(f paramf, h paramh, List<h> paramList, boolean paramBoolean)
  {
    AppMethodBeat.i(229147);
    if (paramf == null)
    {
      AppMethodBeat.o(229147);
      return true;
    }
    paramf.Dc = false;
    g localg = (g)paramf.CA;
    if (paramf.Cm == null)
    {
      paramf.Db = true;
      paramh.DO.add(paramf);
      paramf.Cm = paramh;
      if ((paramf.Cp.Bv == null) && (paramf.Cr.Bv == null) && (paramf.Cq.Bv == null) && (paramf.Cs.Bv == null) && (paramf.Ct.Bv == null) && (paramf.Cw.Bv == null))
      {
        a(localg, paramf, paramh);
        if (paramBoolean)
        {
          AppMethodBeat.o(229147);
          return false;
        }
      }
      if ((paramf.Cq.Bv != null) && (paramf.Cs.Bv != null))
      {
        localg.fN();
        localObject = f.a.Dp;
        if (paramBoolean)
        {
          a(localg, paramf, paramh);
          AppMethodBeat.o(229147);
          return false;
        }
        if ((paramf.Cq.Bv.Bt != paramf.CA) || (paramf.Cs.Bv.Bt != paramf.CA)) {
          a(localg, paramf, paramh);
        }
      }
      if ((paramf.Cp.Bv != null) && (paramf.Cr.Bv != null))
      {
        localg.fM();
        localObject = f.a.Dp;
        if (paramBoolean)
        {
          a(localg, paramf, paramh);
          AppMethodBeat.o(229147);
          return false;
        }
        if ((paramf.Cp.Bv.Bt != paramf.CA) || (paramf.Cr.Bv.Bt != paramf.CA)) {
          a(localg, paramf, paramh);
        }
      }
      if (paramf.fM() == f.a.Dq)
      {
        i = 1;
        if (paramf.fN() != f.a.Dq) {
          break label777;
        }
        j = 1;
        label347:
        if (((i ^ j) == 0) || (paramf.CB == 0.0F)) {
          break label783;
        }
        a(paramf);
      }
      label777:
      label783:
      do
      {
        do
        {
          if (((paramf.Cp.Bv == null) && (paramf.Cr.Bv == null)) || ((paramf.Cp.Bv != null) && (paramf.Cp.Bv.Bt == paramf.CA) && (paramf.Cr.Bv == null)) || ((paramf.Cr.Bv != null) && (paramf.Cr.Bv.Bt == paramf.CA) && (paramf.Cp.Bv == null)) || ((paramf.Cp.Bv != null) && (paramf.Cp.Bv.Bt == paramf.CA) && (paramf.Cr.Bv != null) && (paramf.Cr.Bv.Bt == paramf.CA) && (paramf.Cw.Bv == null) && (!(paramf instanceof i)) && (!(paramf instanceof j)))) {
            paramh.DS.add(paramf);
          }
          if (((paramf.Cq.Bv == null) && (paramf.Cs.Bv == null)) || ((paramf.Cq.Bv != null) && (paramf.Cq.Bv.Bt == paramf.CA) && (paramf.Cs.Bv == null)) || ((paramf.Cs.Bv != null) && (paramf.Cs.Bv.Bt == paramf.CA) && (paramf.Cq.Bv == null)) || ((paramf.Cq.Bv != null) && (paramf.Cq.Bv.Bt == paramf.CA) && (paramf.Cs.Bv != null) && (paramf.Cs.Bv.Bt == paramf.CA) && (paramf.Cw.Bv == null) && (paramf.Ct.Bv == null) && (!(paramf instanceof i)) && (!(paramf instanceof j)))) {
            paramh.DT.add(paramf);
          }
          if (!(paramf instanceof j)) {
            break label1006;
          }
          a(localg, paramf, paramh);
          if (!paramBoolean) {
            break label953;
          }
          AppMethodBeat.o(229147);
          return false;
          i = 0;
          break;
          j = 0;
          break label347;
        } while ((paramf.fM() != f.a.Dq) && (paramf.fN() != f.a.Dq));
        a(localg, paramf, paramh);
      } while (!paramBoolean);
      AppMethodBeat.o(229147);
      return false;
    }
    if (paramf.Cm != paramh)
    {
      paramh.DO.addAll(paramf.Cm.DO);
      paramh.DS.addAll(paramf.Cm.DS);
      paramh.DT.addAll(paramf.Cm.DT);
      if (!paramf.Cm.DK) {
        paramh.DK = false;
      }
      paramList.remove(paramf.Cm);
      paramf = paramf.Cm.DO.iterator();
      while (paramf.hasNext()) {
        ((f)paramf.next()).Cm = paramh;
      }
    }
    AppMethodBeat.o(229147);
    return true;
    label953:
    Object localObject = (j)paramf;
    int i = 0;
    while (i < ((j)localObject).Bl)
    {
      if (!a(localObject.Eg[i], paramh, paramList, paramBoolean))
      {
        AppMethodBeat.o(229147);
        return false;
      }
      i += 1;
    }
    label1006:
    int j = paramf.Cx.length;
    i = 0;
    while (i < j)
    {
      localObject = paramf.Cx[i];
      if ((((e)localObject).Bv != null) && (((e)localObject).Bv.Bt != paramf.CA))
      {
        if (((e)localObject).Bu == e.c.BR)
        {
          a(localg, paramf, paramh);
          if (paramBoolean)
          {
            AppMethodBeat.o(229147);
            return false;
          }
        }
        else
        {
          m localm = ((e)localObject).Bs;
          if ((((e)localObject).Bv != null) && (((e)localObject).Bv.Bv != localObject)) {
            ((e)localObject).Bv.Bs.a(localm);
          }
        }
        if (!a(((e)localObject).Bv.Bt, paramh, paramList, paramBoolean))
        {
          AppMethodBeat.o(229147);
          return false;
        }
      }
      i += 1;
    }
    AppMethodBeat.o(229147);
    return true;
  }
  
  private static void b(g paramg)
  {
    AppMethodBeat.i(229186);
    paramg.DD.clear();
    paramg.DD.add(0, new h(paramg.Ew));
    AppMethodBeat.o(229186);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     androidx.constraintlayout.a.a.a
 * JD-Core Version:    0.7.0.1
 */