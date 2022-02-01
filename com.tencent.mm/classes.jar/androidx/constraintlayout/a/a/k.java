package androidx.constraintlayout.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class k
{
  static boolean[] bkp = new boolean[3];
  
  static void a(int paramInt, f paramf)
  {
    AppMethodBeat.i(194145);
    paramf.CH();
    m localm1 = paramf.biw.bhA;
    m localm2 = paramf.bix.bhA;
    m localm3 = paramf.biy.bhA;
    m localm4 = paramf.biA.bhA;
    int i;
    if ((paramInt & 0x8) == 8)
    {
      paramInt = 1;
      if ((paramf.biH[0] != f.a.bjy) || (!d(paramf, 0))) {
        break label327;
      }
      i = 1;
      label77:
      if ((localm1.type != 4) && (localm3.type != 4))
      {
        if ((paramf.biH[0] != f.a.bjw) && ((i == 0) || (paramf.bje != 8))) {
          break label584;
        }
        if ((paramf.biw.bhD != null) || (paramf.biy.bhD != null)) {
          break label345;
        }
        localm1.type = 1;
        localm3.type = 1;
        if (paramInt == 0) {
          break label332;
        }
        localm3.a(localm1, 1, paramf.CJ());
      }
      label165:
      if ((paramf.biH[1] != f.a.bjy) || (!d(paramf, 1))) {
        break label863;
      }
      i = 1;
      label187:
      if ((localm2.type == 4) || (localm4.type == 4)) {
        break label1534;
      }
      if ((paramf.biH[1] != f.a.bjw) && ((i == 0) || (paramf.bje != 8))) {
        break label1200;
      }
      if ((paramf.bix.bhD != null) || (paramf.biA.bhD != null)) {
        break label882;
      }
      localm2.type = 1;
      localm4.type = 1;
      if (paramInt == 0) {
        break label868;
      }
      localm4.a(localm2, 1, paramf.CK());
    }
    for (;;)
    {
      if (paramf.biB.bhD != null)
      {
        paramf.biB.bhA.type = 1;
        localm2.a(paramf.biB.bhA, -paramf.biV);
        AppMethodBeat.o(194145);
        return;
        paramInt = 0;
        break;
        label327:
        i = 0;
        break label77;
        label332:
        localm3.b(localm1, paramf.getWidth());
        break label165;
        label345:
        if ((paramf.biw.bhD != null) && (paramf.biy.bhD == null))
        {
          localm1.type = 1;
          localm3.type = 1;
          if (paramInt != 0)
          {
            localm3.a(localm1, 1, paramf.CJ());
            break label165;
          }
          localm3.b(localm1, paramf.getWidth());
          break label165;
        }
        if ((paramf.biw.bhD == null) && (paramf.biy.bhD != null))
        {
          localm1.type = 1;
          localm3.type = 1;
          localm1.b(localm3, -paramf.getWidth());
          if (paramInt != 0)
          {
            localm1.a(localm3, -1, paramf.CJ());
            break label165;
          }
          localm1.b(localm3, -paramf.getWidth());
          break label165;
        }
        if ((paramf.biw.bhD == null) || (paramf.biy.bhD == null)) {
          break label165;
        }
        localm1.type = 2;
        localm3.type = 2;
        if (paramInt != 0)
        {
          paramf.CJ().a(localm1);
          paramf.CJ().a(localm3);
          localm1.b(localm3, -1, paramf.CJ());
          localm3.b(localm1, 1, paramf.CJ());
          break label165;
        }
        localm1.b(localm3, -paramf.getWidth());
        localm3.b(localm1, paramf.getWidth());
        break label165;
        label584:
        if (i == 0) {
          break label165;
        }
        i = paramf.getWidth();
        localm1.type = 1;
        localm3.type = 1;
        if ((paramf.biw.bhD == null) && (paramf.biy.bhD == null))
        {
          if (paramInt != 0)
          {
            localm3.a(localm1, 1, paramf.CJ());
            break label165;
          }
          localm3.b(localm1, i);
          break label165;
        }
        if ((paramf.biw.bhD != null) && (paramf.biy.bhD == null))
        {
          if (paramInt != 0)
          {
            localm3.a(localm1, 1, paramf.CJ());
            break label165;
          }
          localm3.b(localm1, i);
          break label165;
        }
        if ((paramf.biw.bhD == null) && (paramf.biy.bhD != null))
        {
          if (paramInt != 0)
          {
            localm1.a(localm3, -1, paramf.CJ());
            break label165;
          }
          localm1.b(localm3, -i);
          break label165;
        }
        if ((paramf.biw.bhD == null) || (paramf.biy.bhD == null)) {
          break label165;
        }
        if (paramInt != 0)
        {
          paramf.CJ().a(localm1);
          paramf.CJ().a(localm3);
        }
        if (paramf.biJ == 0.0F)
        {
          localm1.type = 3;
          localm3.type = 3;
          localm1.b(localm3, 0.0F);
          localm3.b(localm1, 0.0F);
          break label165;
        }
        localm1.type = 2;
        localm3.type = 2;
        localm1.b(localm3, -i);
        localm3.b(localm1, i);
        paramf.setWidth(i);
        break label165;
        label863:
        i = 0;
        break label187;
        label868:
        localm4.b(localm2, paramf.getHeight());
        continue;
        label882:
        if ((paramf.bix.bhD != null) && (paramf.biA.bhD == null))
        {
          localm2.type = 1;
          localm4.type = 1;
          if (paramInt != 0) {
            localm4.a(localm2, 1, paramf.CK());
          }
        }
        while (paramf.biV > 0)
        {
          paramf.biB.bhA.a(localm2, paramf.biV);
          AppMethodBeat.o(194145);
          return;
          localm4.b(localm2, paramf.getHeight());
          continue;
          if ((paramf.bix.bhD == null) && (paramf.biA.bhD != null))
          {
            localm2.type = 1;
            localm4.type = 1;
            if (paramInt != 0) {
              localm2.a(localm4, -1, paramf.CK());
            }
          }
          while (paramf.biV > 0)
          {
            paramf.biB.bhA.a(localm2, paramf.biV);
            AppMethodBeat.o(194145);
            return;
            localm2.b(localm4, -paramf.getHeight());
            continue;
            if ((paramf.bix.bhD != null) && (paramf.biA.bhD != null))
            {
              localm2.type = 2;
              localm4.type = 2;
              if (paramInt != 0)
              {
                localm2.b(localm4, -1, paramf.CK());
                localm4.b(localm2, 1, paramf.CK());
                paramf.CK().a(localm2);
                paramf.CJ().a(localm4);
              }
              while (paramf.biV > 0)
              {
                paramf.biB.bhA.a(localm2, paramf.biV);
                AppMethodBeat.o(194145);
                return;
                localm2.b(localm4, -paramf.getHeight());
                localm4.b(localm2, paramf.getHeight());
                continue;
                label1200:
                if (i != 0)
                {
                  i = paramf.getHeight();
                  localm2.type = 1;
                  localm4.type = 1;
                  if ((paramf.bix.bhD == null) && (paramf.biA.bhD == null))
                  {
                    if (paramInt != 0)
                    {
                      localm4.a(localm2, 1, paramf.CK());
                      AppMethodBeat.o(194145);
                      return;
                    }
                    localm4.b(localm2, i);
                    AppMethodBeat.o(194145);
                    return;
                  }
                  if ((paramf.bix.bhD != null) && (paramf.biA.bhD == null))
                  {
                    if (paramInt != 0)
                    {
                      localm4.a(localm2, 1, paramf.CK());
                      AppMethodBeat.o(194145);
                      return;
                    }
                    localm4.b(localm2, i);
                    AppMethodBeat.o(194145);
                    return;
                  }
                  if ((paramf.bix.bhD == null) && (paramf.biA.bhD != null))
                  {
                    if (paramInt != 0)
                    {
                      localm2.a(localm4, -1, paramf.CK());
                      AppMethodBeat.o(194145);
                      return;
                    }
                    localm2.b(localm4, -i);
                    AppMethodBeat.o(194145);
                    return;
                  }
                  if ((paramf.bix.bhD != null) && (paramf.biA.bhD != null))
                  {
                    if (paramInt != 0)
                    {
                      paramf.CK().a(localm2);
                      paramf.CJ().a(localm4);
                    }
                    if (paramf.biJ == 0.0F)
                    {
                      localm2.type = 3;
                      localm4.type = 3;
                      localm2.b(localm4, 0.0F);
                      localm4.b(localm2, 0.0F);
                      AppMethodBeat.o(194145);
                      return;
                    }
                    localm2.type = 2;
                    localm4.type = 2;
                    localm2.b(localm4, -i);
                    localm4.b(localm2, i);
                    paramf.setHeight(i);
                    if (paramf.biV > 0) {
                      paramf.biB.bhA.a(localm2, paramf.biV);
                    }
                  }
                }
              }
            }
          }
        }
      }
    }
    label1534:
    AppMethodBeat.o(194145);
  }
  
  static void a(f paramf, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(194193);
    int i = paramInt1 * 2;
    int j = i + 1;
    paramf.biF[i].bhA.bks = paramf.biI.biw.bhA;
    paramf.biF[i].bhA.bkt = paramInt2;
    paramf.biF[i].bhA.state = 1;
    paramf.biF[j].bhA.bks = paramf.biF[i].bhA;
    paramf.biF[j].bhA.bkt = paramf.dL(paramInt1);
    paramf.biF[j].bhA.state = 1;
    AppMethodBeat.o(194193);
  }
  
  static void a(g paramg, androidx.constraintlayout.a.e parame, f paramf)
  {
    AppMethodBeat.i(194093);
    int i;
    int j;
    if ((paramg.biH[0] != f.a.bjx) && (paramf.biH[0] == f.a.bjz))
    {
      i = paramf.biw.bhE;
      j = paramg.getWidth() - paramf.biy.bhE;
      paramf.biw.bhJ = parame.ar(paramf.biw);
      paramf.biy.bhJ = parame.ar(paramf.biy);
      parame.a(paramf.biw.bhJ, i);
      parame.a(paramf.biy.bhJ, j);
      paramf.bic = 2;
      paramf.aq(i, j);
    }
    if ((paramg.biH[1] != f.a.bjx) && (paramf.biH[1] == f.a.bjz))
    {
      i = paramf.bix.bhE;
      j = paramg.getHeight() - paramf.biA.bhE;
      paramf.bix.bhJ = parame.ar(paramf.bix);
      paramf.biA.bhJ = parame.ar(paramf.biA);
      parame.a(paramf.bix.bhJ, i);
      parame.a(paramf.biA.bhJ, j);
      if ((paramf.biV > 0) || (paramf.bje == 8))
      {
        paramf.biB.bhJ = parame.ar(paramf.biB);
        parame.a(paramf.biB.bhJ, paramf.biV + i);
      }
      paramf.bid = 2;
      paramf.ar(i, j);
    }
    AppMethodBeat.o(194093);
  }
  
  static boolean a(androidx.constraintlayout.a.e parame, int paramInt1, int paramInt2, d paramd)
  {
    AppMethodBeat.i(194188);
    Object localObject1 = paramd.bhl;
    f localf1 = paramd.bhn;
    f localf2 = paramd.bhm;
    f localf3 = paramd.bho;
    Object localObject2 = paramd.bhp;
    int n = 0;
    int i1 = 0;
    float f6 = paramd.bhv;
    paramd = f.a.bjx;
    int k;
    int m;
    label78:
    int i;
    label90:
    float f5;
    float f3;
    int j;
    label103:
    float f2;
    label139:
    float f1;
    if (paramInt1 == 0) {
      if (((f)localObject2).bjm == 0)
      {
        k = 1;
        if (((f)localObject2).bjm != 1) {
          break label285;
        }
        m = 1;
        if (((f)localObject2).bjm != 2) {
          break label291;
        }
        i = 1;
        f5 = 0.0F;
        f3 = 0.0F;
        j = 0;
        localObject2 = localObject1;
        if (n != 0) {
          break label539;
        }
        if (((f)localObject2).bje == 8) {
          break label1726;
        }
        j += 1;
        if (paramInt1 != 0) {
          break label353;
        }
        f2 = ((f)localObject2).getWidth() + f5;
        f1 = f2;
        if (localObject2 != localf2) {
          f1 = f2 + localObject2.biF[paramInt2].CE();
        }
        f2 = f1;
        if (localObject2 != localf3) {
          f2 = f1 + localObject2.biF[(paramInt2 + 1)].CE();
        }
        f3 = f3 + localObject2.biF[paramInt2].CE() + localObject2.biF[(paramInt2 + 1)].CE();
        f5 = f2;
      }
    }
    label285:
    label291:
    label308:
    label1719:
    label1726:
    for (;;)
    {
      int i2 = i1;
      if (((f)localObject2).bje != 8)
      {
        i2 = i1;
        if (localObject2.biH[paramInt1] == f.a.bjy)
        {
          if (paramInt1 == 0)
          {
            if (((f)localObject2).big != 0)
            {
              AppMethodBeat.o(194188);
              return false;
              k = 0;
              break;
              m = 0;
              break label78;
              i = 0;
              break label90;
              if (((f)localObject2).bjn == 0)
              {
                k = 1;
                if (((f)localObject2).bjn != 1) {
                  break label341;
                }
              }
              label341:
              for (m = 1;; m = 0)
              {
                if (((f)localObject2).bjn != 2) {
                  break label347;
                }
                i = 1;
                break;
                k = 0;
                break label308;
              }
              label347:
              i = 0;
              break label90;
              label353:
              f2 = ((f)localObject2).getHeight() + f5;
              break label139;
            }
            if ((((f)localObject2).bij == 0) && (((f)localObject2).bik == 0)) {
              break label428;
            }
            AppMethodBeat.o(194188);
            return false;
          }
          if (((f)localObject2).bih != 0)
          {
            AppMethodBeat.o(194188);
            return false;
          }
          if ((((f)localObject2).bim != 0) || (((f)localObject2).bin != 0))
          {
            AppMethodBeat.o(194188);
            return false;
          }
          if (((f)localObject2).biJ != 0.0F)
          {
            AppMethodBeat.o(194188);
            return false;
          }
          i2 = i1 + 1;
        }
      }
      paramd = localObject2.biF[(paramInt2 + 1)].bhD;
      if (paramd != null)
      {
        localObject3 = paramd.bhB;
        if (localObject3.biF[paramInt2].bhD != null)
        {
          paramd = (d)localObject3;
          if (localObject3.biF[paramInt2].bhD.bhB == localObject2) {
            break label510;
          }
        }
      }
      for (paramd = null;; paramd = null)
      {
        label510:
        if (paramd == null) {
          break label529;
        }
        i1 = i2;
        localObject2 = paramd;
        break;
      }
      n = 1;
      i1 = i2;
      break label103;
      Object localObject3 = localObject1.biF[paramInt2].bhA;
      paramd = localf1.biF[(paramInt2 + 1)].bhA;
      if ((((m)localObject3).bkr == null) || (paramd.bkr == null))
      {
        AppMethodBeat.o(194188);
        return false;
      }
      if ((((m)localObject3).bkr.state != 1) || (paramd.bkr.state != 1))
      {
        AppMethodBeat.o(194188);
        return false;
      }
      if ((i1 > 0) && (i1 != j))
      {
        AppMethodBeat.o(194188);
        return false;
      }
      f1 = 0.0F;
      f2 = 0.0F;
      if ((i != 0) || (k != 0) || (m != 0))
      {
        if (localf2 != null) {
          f2 = localf2.biF[paramInt2].CE();
        }
        f1 = f2;
        if (localf3 != null) {
          f1 = f2 + localf3.biF[(paramInt2 + 1)].CE();
        }
      }
      float f4 = ((m)localObject3).bkr.bkt;
      f2 = paramd.bkr.bkt;
      if (f4 < f2) {
        f2 = f2 - f4 - f5;
      }
      for (;;)
      {
        if ((i1 > 0) && (i1 == j)) {
          if ((((f)localObject2).biI != null) && (localObject2.biI.biH[paramInt1] == f.a.bjx))
          {
            AppMethodBeat.o(194188);
            return false;
            f2 = f4 - f2 - f5;
          }
          else
          {
            f3 = f2 + f5 - f3;
            f2 = f4;
            if (localObject1 != null)
            {
              if (androidx.constraintlayout.a.e.bgN != null)
              {
                parame = androidx.constraintlayout.a.e.bgN;
                AppMethodBeat.o(194188);
                throw null;
              }
              paramd = localObject1.bjs[paramInt1];
              if ((paramd == null) && (localObject1 != localf1)) {
                break label1719;
              }
              f1 = f3 / i1;
              if (f6 > 0.0F)
              {
                if (localObject1.bjq[paramInt1] == -1.0F) {
                  f1 = 0.0F;
                }
              }
              else
              {
                label881:
                if (((f)localObject1).bje == 8) {
                  f1 = 0.0F;
                }
                f2 += localObject1.biF[paramInt2].CE();
                localObject1.biF[paramInt2].bhA.a(((m)localObject3).bks, f2);
                localObject1.biF[(paramInt2 + 1)].bhA.a(((m)localObject3).bks, f2 + f1);
                localObject1.biF[paramInt2].bhA.c(parame);
                localObject1.biF[(paramInt2 + 1)].bhA.c(parame);
              }
            }
          }
        }
      }
      for (f1 = f1 + f2 + localObject1.biF[(paramInt2 + 1)].CE();; f1 = f2)
      {
        localObject1 = paramd;
        f2 = f1;
        break;
        f1 = localObject1.bjq[paramInt1] * f3 / f6;
        break label881;
        AppMethodBeat.o(194188);
        return true;
        if (f2 < 0.0F)
        {
          i = 1;
          k = 0;
        }
        for (m = 0;; m = n)
        {
          if (i != 0)
          {
            if (paramInt1 == 0) {
              f3 = ((f)localObject1).bja;
            }
            for (;;)
            {
              f1 = f4 + f3 * (f2 - f1);
              if (localObject1 == null) {
                break label1670;
              }
              if (androidx.constraintlayout.a.e.bgN == null) {
                break;
              }
              parame = androidx.constraintlayout.a.e.bgN;
              AppMethodBeat.o(194188);
              throw null;
              if (paramInt1 == 1) {
                f3 = ((f)localObject1).bjb;
              } else {
                f3 = -1.0F;
              }
            }
            paramd = localObject1.bjs[paramInt1];
            if ((paramd == null) && (localObject1 != localf1)) {
              break label1701;
            }
            if (paramInt1 == 0)
            {
              f2 = ((f)localObject1).getWidth();
              f1 += localObject1.biF[paramInt2].CE();
              localObject1.biF[paramInt2].bhA.a(((m)localObject3).bks, f1);
              localObject1.biF[(paramInt2 + 1)].bhA.a(((m)localObject3).bks, f1 + f2);
              localObject1.biF[paramInt2].bhA.c(parame);
              localObject1.biF[(paramInt2 + 1)].bhA.c(parame);
              f1 = f2 + f1 + localObject1.biF[(paramInt2 + 1)].CE();
            }
          }
          for (;;)
          {
            localObject1 = paramd;
            break;
            f2 = ((f)localObject1).getHeight();
            break label1162;
            if ((m != 0) || (k != 0)) {
              if (m != 0) {
                f1 = f2 - f1;
              }
            }
            for (;;)
            {
              f2 = f1 / (j + 1);
              if (k != 0)
              {
                if (j > 1) {
                  f2 = f1 / (j - 1);
                }
              }
              else {
                label1344:
                if (((f)localObject1).bje == 8) {
                  break label1687;
                }
              }
              for (f1 = f4 + f2;; f1 = f4)
              {
                f3 = f1;
                if (k != 0)
                {
                  f3 = f1;
                  if (j > 1) {
                    f3 = localf2.biF[paramInt2].CE() + f4;
                  }
                }
                if ((m != 0) && (localf2 != null))
                {
                  f1 = f3 + localf2.biF[paramInt2].CE();
                  paramd = (d)localObject1;
                }
                for (;;)
                {
                  if (paramd != null)
                  {
                    if (androidx.constraintlayout.a.e.bgN != null)
                    {
                      parame = androidx.constraintlayout.a.e.bgN;
                      AppMethodBeat.o(194188);
                      throw null;
                      if (k == 0) {
                        break label1694;
                      }
                      f1 = f2 - f1;
                      break;
                      f2 = f1 / 2.0F;
                      break label1344;
                    }
                    localObject1 = paramd.bjs[paramInt1];
                    if (localObject1 == null)
                    {
                      f3 = f1;
                      if (paramd != localf1) {}
                    }
                    else
                    {
                      if (paramInt1 != 0) {
                        break label1660;
                      }
                    }
                    label1660:
                    for (f3 = paramd.getWidth();; f3 = paramd.getHeight())
                    {
                      f4 = f1;
                      if (paramd != localf2) {
                        f4 = f1 + paramd.biF[paramInt2].CE();
                      }
                      paramd.biF[paramInt2].bhA.a(((m)localObject3).bks, f4);
                      paramd.biF[(paramInt2 + 1)].bhA.a(((m)localObject3).bks, f4 + f3);
                      paramd.biF[paramInt2].bhA.c(parame);
                      paramd.biF[(paramInt2 + 1)].bhA.c(parame);
                      f1 = f4 + (paramd.biF[(paramInt2 + 1)].CE() + f3);
                      f3 = f1;
                      if (localObject1 != null)
                      {
                        f3 = f1;
                        if (((f)localObject1).bje != 8) {
                          f3 = f1 + f2;
                        }
                      }
                      paramd = (d)localObject1;
                      f1 = f3;
                      break;
                    }
                  }
                  AppMethodBeat.o(194188);
                  return true;
                  paramd = (d)localObject1;
                  f1 = f3;
                }
              }
              f1 = f2;
            }
          }
          n = k;
          k = m;
        }
      }
    }
  }
  
  private static boolean d(f paramf, int paramInt)
  {
    int i = 1;
    if (paramf.biH[paramInt] != f.a.bjy) {}
    do
    {
      for (;;)
      {
        return false;
        if (paramf.biJ == 0.0F) {
          break;
        }
        paramf = paramf.biH;
        if (paramInt == 0) {}
        for (paramInt = i; paramf[paramInt] == f.a.bjy; paramInt = 0) {
          return false;
        }
      }
      if (paramInt != 0) {
        break;
      }
    } while ((paramf.big != 0) || (paramf.bij != 0) || (paramf.bik != 0));
    do
    {
      return true;
      if ((paramf.bih != 0) || (paramf.bim != 0)) {
        break;
      }
    } while (paramf.bin == 0);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     androidx.constraintlayout.a.a.k
 * JD-Core Version:    0.7.0.1
 */