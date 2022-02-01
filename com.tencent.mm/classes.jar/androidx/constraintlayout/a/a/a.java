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
    AppMethodBeat.i(194183);
    int i = -1;
    if (paramf.CV() == f.a.bjy) {
      if (paramf.biK == 0)
      {
        i = (int)(paramf.getHeight() * paramf.biJ);
        paramf.setWidth(i);
      }
    }
    while (paramf.CW() != f.a.bjy) {
      for (;;)
      {
        AppMethodBeat.o(194183);
        return i;
        i = (int)(paramf.getHeight() / paramf.biJ);
      }
    }
    if (paramf.biK == 1) {}
    for (i = (int)(paramf.getWidth() * paramf.biJ);; i = (int)(paramf.getWidth() / paramf.biJ))
    {
      paramf.setHeight(i);
      break;
    }
  }
  
  private static int a(f paramf, int paramInt)
  {
    AppMethodBeat.i(194178);
    int i = paramInt * 2;
    e locale1 = paramf.biF[i];
    e locale2 = paramf.biF[(i + 1)];
    if ((locale1.bhD != null) && (locale1.bhD.bhB == paramf.biI) && (locale2.bhD != null) && (locale2.bhD.bhB == paramf.biI))
    {
      i = paramf.biI.dL(paramInt);
      if (paramInt == 0) {}
      for (float f = paramf.bja;; f = paramf.bjb)
      {
        paramInt = paramf.dL(paramInt);
        paramInt = (int)(f * (i - locale1.CE() - locale2.CE() - paramInt));
        AppMethodBeat.o(194178);
        return paramInt;
      }
    }
    AppMethodBeat.o(194178);
    return 0;
  }
  
  private static int a(f paramf, int paramInt1, boolean paramBoolean, int paramInt2)
  {
    AppMethodBeat.i(194148);
    if (!paramf.bjj)
    {
      AppMethodBeat.o(194148);
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
    if ((paramf.biB.bhD != null) && (paramInt1 == 1))
    {
      k = 1;
      if (!paramBoolean) {
        break label229;
      }
      i1 = paramf.biV;
      n = paramf.getHeight() - paramf.biV;
      j = paramInt1 * 2;
      i = j + 1;
      if ((paramf.biF[i].bhD == null) || (paramf.biF[j].bhD != null)) {
        break label260;
      }
      i2 = -1;
      m = i;
      i3 = paramInt2;
      if (k != 0) {
        i3 = paramInt2 - i1;
      }
      i6 = paramf.biF[m].CE() * i2 + a(paramf, paramInt1);
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
      localObject = paramf.biF[m].bhA.bkA.iterator();
      for (paramInt2 = 0; ((Iterator)localObject).hasNext(); paramInt2 = Math.max(paramInt2, a(((m)((Iterator)localObject).next()).bkq.bhB, paramInt1, paramBoolean, i8))) {}
      k = 0;
      break;
      label229:
      i1 = paramf.getHeight() - paramf.biV;
      n = paramf.biV;
      i = paramInt1 * 2;
      j = i + 1;
      break label69;
      i2 = 1;
      m = j;
      j = i;
      break label102;
    }
    Object localObject = paramf.biF[j].bhA.bkA.iterator();
    for (int i = 0; ((Iterator)localObject).hasNext(); i = Math.max(i, a(((m)((Iterator)localObject).next()).bkq.bhB, paramInt1, paramBoolean, i7 + i8))) {}
    int i4;
    int i5;
    if (k != 0)
    {
      i4 = i + n;
      i5 = paramInt2 - i1;
      if (paramInt1 == 1)
      {
        localObject = paramf.biB.bhA.bkA.iterator();
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
          paramInt2 = Math.max(paramInt2, a(localm.bkq.bhB, paramInt1, paramBoolean, i1 + i8));
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
          paramInt2 = Math.max(paramInt2, a(localm.bkq.bhB, paramInt1, paramBoolean, n * i2 + i8));
        }
      }
      label513:
      i = paramInt2;
      if (paramf.biB.bhA.bkA.size() > 0)
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
          paramf.q(i, paramInt2, paramInt1);
        }
        for (;;)
        {
          if ((paramf.dM(paramInt1) == f.a.bjy) && (paramf.biJ != 0.0F)) {
            paramf.bit.c(paramf, paramInt1);
          }
          if ((paramf.biF[m].bhD != null) && (paramf.biF[j].bhD != null))
          {
            localObject = paramf.biI;
            if ((paramf.biF[m].bhD.bhB == localObject) && (paramf.biF[j].bhD.bhB == localObject)) {
              paramf.bit.c(paramf, paramInt1);
            }
          }
          AppMethodBeat.o(194148);
          return n + i6;
          label720:
          i = paramInt2 - n;
          break;
          paramf.bit.c(paramf, paramInt1);
          paramf.as(i, paramInt1);
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
    AppMethodBeat.i(194134);
    int k = paramInt * 2;
    List localList;
    int i;
    int j;
    label33:
    f localf;
    if (paramInt == 0)
    {
      localList = paramh.bka;
      int m = localList.size();
      i = 0;
      j = 0;
      if (i >= m) {
        break label148;
      }
      localf = (f)localList.get(i);
      if ((localf.biF[(k + 1)].bhD != null) && ((localf.biF[k].bhD == null) || (localf.biF[(k + 1)].bhD == null))) {
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
        localList = paramh.bkb;
        break;
      }
      localList = null;
      break;
    }
    label148:
    paramh.bjZ[paramInt] = j;
    AppMethodBeat.o(194134);
    return j;
  }
  
  public static void a(g paramg)
  {
    AppMethodBeat.i(194095);
    if ((paramg.bjR & 0x20) != 32)
    {
      b(paramg);
      AppMethodBeat.o(194095);
      return;
    }
    paramg.bjS = true;
    paramg.bjM = false;
    paramg.bjN = false;
    paramg.bjO = false;
    Object localObject1 = paramg.bkE;
    List localList = paramg.bjL;
    int i;
    int j;
    if (paramg.CV() == f.a.bjx)
    {
      i = 1;
      if (paramg.CW() != f.a.bjx) {
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
        ((f)localObject3).bit = null;
        ((f)localObject3).bjl = false;
        ((f)localObject3).CA();
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
      if (((f)localObject2).bit == null)
      {
        localObject3 = new h(new ArrayList(), (byte)0);
        localList.add(localObject3);
        if (!a((f)localObject2, (h)localObject3, localList, bool))
        {
          b(paramg);
          paramg.bjS = false;
          AppMethodBeat.o(194095);
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
      paramg.a(f.a.bjw);
      paramg.setWidth(m);
      paramg.bjM = true;
      paramg.bjN = true;
      paramg.bjP = m;
    }
    if (j != 0)
    {
      paramg.b(f.a.bjw);
      paramg.setHeight(k);
      paramg.bjM = true;
      paramg.bjO = true;
      paramg.bjQ = k;
    }
    g(localList, 0, paramg.getWidth());
    g(localList, 1, paramg.getHeight());
    AppMethodBeat.o(194095);
  }
  
  private static void a(g paramg, f paramf, h paramh)
  {
    paramh.bjS = false;
    paramg.bjS = false;
    paramf.bjj = false;
  }
  
  private static boolean a(f paramf, h paramh, List<h> paramList, boolean paramBoolean)
  {
    AppMethodBeat.i(194121);
    if (paramf == null)
    {
      AppMethodBeat.o(194121);
      return true;
    }
    paramf.bjk = false;
    g localg = (g)paramf.biI;
    if (paramf.bit == null)
    {
      paramf.bjj = true;
      paramh.bjW.add(paramf);
      paramf.bit = paramh;
      if ((paramf.biw.bhD == null) && (paramf.biy.bhD == null) && (paramf.bix.bhD == null) && (paramf.biA.bhD == null) && (paramf.biB.bhD == null) && (paramf.biE.bhD == null))
      {
        a(localg, paramf, paramh);
        if (paramBoolean)
        {
          AppMethodBeat.o(194121);
          return false;
        }
      }
      if ((paramf.bix.bhD != null) && (paramf.biA.bhD != null))
      {
        localg.CW();
        localObject = f.a.bjx;
        if (paramBoolean)
        {
          a(localg, paramf, paramh);
          AppMethodBeat.o(194121);
          return false;
        }
        if ((paramf.bix.bhD.bhB != paramf.biI) || (paramf.biA.bhD.bhB != paramf.biI)) {
          a(localg, paramf, paramh);
        }
      }
      if ((paramf.biw.bhD != null) && (paramf.biy.bhD != null))
      {
        localg.CV();
        localObject = f.a.bjx;
        if (paramBoolean)
        {
          a(localg, paramf, paramh);
          AppMethodBeat.o(194121);
          return false;
        }
        if ((paramf.biw.bhD.bhB != paramf.biI) || (paramf.biy.bhD.bhB != paramf.biI)) {
          a(localg, paramf, paramh);
        }
      }
      if (paramf.CV() == f.a.bjy)
      {
        i = 1;
        if (paramf.CW() != f.a.bjy) {
          break label777;
        }
        j = 1;
        label347:
        if (((i ^ j) == 0) || (paramf.biJ == 0.0F)) {
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
          if (((paramf.biw.bhD == null) && (paramf.biy.bhD == null)) || ((paramf.biw.bhD != null) && (paramf.biw.bhD.bhB == paramf.biI) && (paramf.biy.bhD == null)) || ((paramf.biy.bhD != null) && (paramf.biy.bhD.bhB == paramf.biI) && (paramf.biw.bhD == null)) || ((paramf.biw.bhD != null) && (paramf.biw.bhD.bhB == paramf.biI) && (paramf.biy.bhD != null) && (paramf.biy.bhD.bhB == paramf.biI) && (paramf.biE.bhD == null) && (!(paramf instanceof i)) && (!(paramf instanceof j)))) {
            paramh.bka.add(paramf);
          }
          if (((paramf.bix.bhD == null) && (paramf.biA.bhD == null)) || ((paramf.bix.bhD != null) && (paramf.bix.bhD.bhB == paramf.biI) && (paramf.biA.bhD == null)) || ((paramf.biA.bhD != null) && (paramf.biA.bhD.bhB == paramf.biI) && (paramf.bix.bhD == null)) || ((paramf.bix.bhD != null) && (paramf.bix.bhD.bhB == paramf.biI) && (paramf.biA.bhD != null) && (paramf.biA.bhD.bhB == paramf.biI) && (paramf.biE.bhD == null) && (paramf.biB.bhD == null) && (!(paramf instanceof i)) && (!(paramf instanceof j)))) {
            paramh.bkb.add(paramf);
          }
          if (!(paramf instanceof j)) {
            break label1006;
          }
          a(localg, paramf, paramh);
          if (!paramBoolean) {
            break label953;
          }
          AppMethodBeat.o(194121);
          return false;
          i = 0;
          break;
          j = 0;
          break label347;
        } while ((paramf.CV() != f.a.bjy) && (paramf.CW() != f.a.bjy));
        a(localg, paramf, paramh);
      } while (!paramBoolean);
      AppMethodBeat.o(194121);
      return false;
    }
    if (paramf.bit != paramh)
    {
      paramh.bjW.addAll(paramf.bit.bjW);
      paramh.bka.addAll(paramf.bit.bka);
      paramh.bkb.addAll(paramf.bit.bkb);
      if (!paramf.bit.bjS) {
        paramh.bjS = false;
      }
      paramList.remove(paramf.bit);
      paramf = paramf.bit.bjW.iterator();
      while (paramf.hasNext()) {
        ((f)paramf.next()).bit = paramh;
      }
    }
    AppMethodBeat.o(194121);
    return true;
    label953:
    Object localObject = (j)paramf;
    int i = 0;
    while (i < ((j)localObject).bht)
    {
      if (!a(localObject.bko[i], paramh, paramList, paramBoolean))
      {
        AppMethodBeat.o(194121);
        return false;
      }
      i += 1;
    }
    label1006:
    int j = paramf.biF.length;
    i = 0;
    while (i < j)
    {
      localObject = paramf.biF[i];
      if ((((e)localObject).bhD != null) && (((e)localObject).bhD.bhB != paramf.biI))
      {
        if (((e)localObject).bhC == e.c.bhY)
        {
          a(localg, paramf, paramh);
          if (paramBoolean)
          {
            AppMethodBeat.o(194121);
            return false;
          }
        }
        else
        {
          m localm = ((e)localObject).bhA;
          if ((((e)localObject).bhD != null) && (((e)localObject).bhD.bhD != localObject)) {
            ((e)localObject).bhD.bhA.a(localm);
          }
        }
        if (!a(((e)localObject).bhD.bhB, paramh, paramList, paramBoolean))
        {
          AppMethodBeat.o(194121);
          return false;
        }
      }
      i += 1;
    }
    AppMethodBeat.o(194121);
    return true;
  }
  
  private static void b(g paramg)
  {
    AppMethodBeat.i(194156);
    paramg.bjL.clear();
    paramg.bjL.add(0, new h(paramg.bkE));
    AppMethodBeat.o(194156);
  }
  
  public static void g(List<h> paramList, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(194167);
    int k = paramList.size();
    int j = 0;
    while (j < k)
    {
      Object localObject = (h)paramList.get(j);
      if (paramInt1 == 0)
      {
        localObject = ((h)localObject).bkc;
        localObject = ((Set)localObject).iterator();
      }
      label183:
      for (;;)
      {
        label57:
        if (((Iterator)localObject).hasNext())
        {
          f localf = (f)((Iterator)localObject).next();
          if (localf.bjj)
          {
            int m = paramInt1 * 2;
            e locale1 = localf.biF[m];
            e locale2 = localf.biF[(m + 1)];
            if ((locale1.bhD != null) && (locale2.bhD != null)) {}
            for (int i = 1;; i = 0)
            {
              if (i == 0) {
                break label183;
              }
              k.a(localf, paramInt1, a(localf, paramInt1) + locale1.CE());
              break label57;
              if (paramInt1 == 1)
              {
                localObject = ((h)localObject).bkd;
                break;
              }
              localObject = null;
              break;
            }
            if ((localf.biJ != 0.0F) && (localf.dM(paramInt1) == f.a.bjy))
            {
              i = a(localf);
              m = (int)localf.biF[m].bhA.bkt;
              locale2.bhA.bks = locale1.bhA;
              locale2.bhA.bkt = i;
              locale2.bhA.state = 1;
              localf.q(m, m + i, paramInt1);
            }
            else
            {
              if (paramInt1 == 0) {
                i = localf.biN;
              }
              for (;;)
              {
                i = paramInt2 - i;
                m = i - localf.dL(paramInt1);
                localf.q(m, i, paramInt1);
                k.a(localf, paramInt1, m);
                break;
                if (paramInt1 == 1) {
                  i = localf.biO;
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
    AppMethodBeat.o(194167);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     androidx.constraintlayout.a.a.a
 * JD-Core Version:    0.7.0.1
 */