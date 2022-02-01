package androidx.constraintlayout.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class k
{
  static boolean[] Eh = new boolean[3];
  
  static void a(int paramInt, f paramf)
  {
    AppMethodBeat.i(229583);
    paramf.fy();
    m localm1 = paramf.Cp.Bs;
    m localm2 = paramf.Cq.Bs;
    m localm3 = paramf.Cr.Bs;
    m localm4 = paramf.Cs.Bs;
    int i;
    if ((paramInt & 0x8) == 8)
    {
      paramInt = 1;
      if ((paramf.Cz[0] != f.a.Dq) || (!d(paramf, 0))) {
        break label327;
      }
      i = 1;
      label77:
      if ((localm1.type != 4) && (localm3.type != 4))
      {
        if ((paramf.Cz[0] != f.a.Do) && ((i == 0) || (paramf.CX != 8))) {
          break label584;
        }
        if ((paramf.Cp.Bv != null) || (paramf.Cr.Bv != null)) {
          break label345;
        }
        localm1.type = 1;
        localm3.type = 1;
        if (paramInt == 0) {
          break label332;
        }
        localm3.a(localm1, 1, paramf.fA());
      }
      label165:
      if ((paramf.Cz[1] != f.a.Dq) || (!d(paramf, 1))) {
        break label863;
      }
      i = 1;
      label187:
      if ((localm2.type == 4) || (localm4.type == 4)) {
        break label1534;
      }
      if ((paramf.Cz[1] != f.a.Do) && ((i == 0) || (paramf.CX != 8))) {
        break label1200;
      }
      if ((paramf.Cq.Bv != null) || (paramf.Cs.Bv != null)) {
        break label882;
      }
      localm2.type = 1;
      localm4.type = 1;
      if (paramInt == 0) {
        break label868;
      }
      localm4.a(localm2, 1, paramf.fB());
    }
    for (;;)
    {
      if (paramf.Ct.Bv != null)
      {
        paramf.Ct.Bs.type = 1;
        localm2.a(paramf.Ct.Bs, -paramf.CN);
        AppMethodBeat.o(229583);
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
        if ((paramf.Cp.Bv != null) && (paramf.Cr.Bv == null))
        {
          localm1.type = 1;
          localm3.type = 1;
          if (paramInt != 0)
          {
            localm3.a(localm1, 1, paramf.fA());
            break label165;
          }
          localm3.b(localm1, paramf.getWidth());
          break label165;
        }
        if ((paramf.Cp.Bv == null) && (paramf.Cr.Bv != null))
        {
          localm1.type = 1;
          localm3.type = 1;
          localm1.b(localm3, -paramf.getWidth());
          if (paramInt != 0)
          {
            localm1.a(localm3, -1, paramf.fA());
            break label165;
          }
          localm1.b(localm3, -paramf.getWidth());
          break label165;
        }
        if ((paramf.Cp.Bv == null) || (paramf.Cr.Bv == null)) {
          break label165;
        }
        localm1.type = 2;
        localm3.type = 2;
        if (paramInt != 0)
        {
          paramf.fA().a(localm1);
          paramf.fA().a(localm3);
          localm1.b(localm3, -1, paramf.fA());
          localm3.b(localm1, 1, paramf.fA());
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
        if ((paramf.Cp.Bv == null) && (paramf.Cr.Bv == null))
        {
          if (paramInt != 0)
          {
            localm3.a(localm1, 1, paramf.fA());
            break label165;
          }
          localm3.b(localm1, i);
          break label165;
        }
        if ((paramf.Cp.Bv != null) && (paramf.Cr.Bv == null))
        {
          if (paramInt != 0)
          {
            localm3.a(localm1, 1, paramf.fA());
            break label165;
          }
          localm3.b(localm1, i);
          break label165;
        }
        if ((paramf.Cp.Bv == null) && (paramf.Cr.Bv != null))
        {
          if (paramInt != 0)
          {
            localm1.a(localm3, -1, paramf.fA());
            break label165;
          }
          localm1.b(localm3, -i);
          break label165;
        }
        if ((paramf.Cp.Bv == null) || (paramf.Cr.Bv == null)) {
          break label165;
        }
        if (paramInt != 0)
        {
          paramf.fA().a(localm1);
          paramf.fA().a(localm3);
        }
        if (paramf.CB == 0.0F)
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
        if ((paramf.Cq.Bv != null) && (paramf.Cs.Bv == null))
        {
          localm2.type = 1;
          localm4.type = 1;
          if (paramInt != 0) {
            localm4.a(localm2, 1, paramf.fB());
          }
        }
        while (paramf.CN > 0)
        {
          paramf.Ct.Bs.a(localm2, paramf.CN);
          AppMethodBeat.o(229583);
          return;
          localm4.b(localm2, paramf.getHeight());
          continue;
          if ((paramf.Cq.Bv == null) && (paramf.Cs.Bv != null))
          {
            localm2.type = 1;
            localm4.type = 1;
            if (paramInt != 0) {
              localm2.a(localm4, -1, paramf.fB());
            }
          }
          while (paramf.CN > 0)
          {
            paramf.Ct.Bs.a(localm2, paramf.CN);
            AppMethodBeat.o(229583);
            return;
            localm2.b(localm4, -paramf.getHeight());
            continue;
            if ((paramf.Cq.Bv != null) && (paramf.Cs.Bv != null))
            {
              localm2.type = 2;
              localm4.type = 2;
              if (paramInt != 0)
              {
                localm2.b(localm4, -1, paramf.fB());
                localm4.b(localm2, 1, paramf.fB());
                paramf.fB().a(localm2);
                paramf.fA().a(localm4);
              }
              while (paramf.CN > 0)
              {
                paramf.Ct.Bs.a(localm2, paramf.CN);
                AppMethodBeat.o(229583);
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
                  if ((paramf.Cq.Bv == null) && (paramf.Cs.Bv == null))
                  {
                    if (paramInt != 0)
                    {
                      localm4.a(localm2, 1, paramf.fB());
                      AppMethodBeat.o(229583);
                      return;
                    }
                    localm4.b(localm2, i);
                    AppMethodBeat.o(229583);
                    return;
                  }
                  if ((paramf.Cq.Bv != null) && (paramf.Cs.Bv == null))
                  {
                    if (paramInt != 0)
                    {
                      localm4.a(localm2, 1, paramf.fB());
                      AppMethodBeat.o(229583);
                      return;
                    }
                    localm4.b(localm2, i);
                    AppMethodBeat.o(229583);
                    return;
                  }
                  if ((paramf.Cq.Bv == null) && (paramf.Cs.Bv != null))
                  {
                    if (paramInt != 0)
                    {
                      localm2.a(localm4, -1, paramf.fB());
                      AppMethodBeat.o(229583);
                      return;
                    }
                    localm2.b(localm4, -i);
                    AppMethodBeat.o(229583);
                    return;
                  }
                  if ((paramf.Cq.Bv != null) && (paramf.Cs.Bv != null))
                  {
                    if (paramInt != 0)
                    {
                      paramf.fB().a(localm2);
                      paramf.fA().a(localm4);
                    }
                    if (paramf.CB == 0.0F)
                    {
                      localm2.type = 3;
                      localm4.type = 3;
                      localm2.b(localm4, 0.0F);
                      localm4.b(localm2, 0.0F);
                      AppMethodBeat.o(229583);
                      return;
                    }
                    localm2.type = 2;
                    localm4.type = 2;
                    localm2.b(localm4, -i);
                    localm4.b(localm2, i);
                    paramf.setHeight(i);
                    if (paramf.CN > 0) {
                      paramf.Ct.Bs.a(localm2, paramf.CN);
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
    AppMethodBeat.o(229583);
  }
  
  static void a(f paramf, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(229587);
    int i = paramInt1 * 2;
    int j = i + 1;
    paramf.Cx[i].Bs.Ek = paramf.CA.Cp.Bs;
    paramf.Cx[i].Bs.El = paramInt2;
    paramf.Cx[i].Bs.state = 1;
    paramf.Cx[j].Bs.Ek = paramf.Cx[i].Bs;
    paramf.Cx[j].Bs.El = paramf.aV(paramInt1);
    paramf.Cx[j].Bs.state = 1;
    AppMethodBeat.o(229587);
  }
  
  static void a(g paramg, androidx.constraintlayout.a.e parame, f paramf)
  {
    AppMethodBeat.i(229579);
    int i;
    int j;
    if ((paramg.Cz[0] != f.a.Dp) && (paramf.Cz[0] == f.a.Dr))
    {
      i = paramf.Cp.Bw;
      j = paramg.getWidth() - paramf.Cr.Bw;
      paramf.Cp.BB = parame.s(paramf.Cp);
      paramf.Cr.BB = parame.s(paramf.Cr);
      parame.a(paramf.Cp.BB, i);
      parame.a(paramf.Cr.BB, j);
      paramf.BV = 2;
      paramf.w(i, j);
    }
    if ((paramg.Cz[1] != f.a.Dp) && (paramf.Cz[1] == f.a.Dr))
    {
      i = paramf.Cq.Bw;
      j = paramg.getHeight() - paramf.Cs.Bw;
      paramf.Cq.BB = parame.s(paramf.Cq);
      paramf.Cs.BB = parame.s(paramf.Cs);
      parame.a(paramf.Cq.BB, i);
      parame.a(paramf.Cs.BB, j);
      if ((paramf.CN > 0) || (paramf.CX == 8))
      {
        paramf.Ct.BB = parame.s(paramf.Ct);
        parame.a(paramf.Ct.BB, paramf.CN + i);
      }
      paramf.BW = 2;
      paramf.x(i, j);
    }
    AppMethodBeat.o(229579);
  }
  
  static boolean a(androidx.constraintlayout.a.e parame, int paramInt1, int paramInt2, d paramd)
  {
    AppMethodBeat.i(229586);
    Object localObject1 = paramd.Bd;
    f localf1 = paramd.Bf;
    f localf2 = paramd.Be;
    f localf3 = paramd.Bg;
    Object localObject2 = paramd.Bh;
    int n = 0;
    int i1 = 0;
    float f6 = paramd.Bn;
    paramd = f.a.Dp;
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
      if (((f)localObject2).De == 0)
      {
        k = 1;
        if (((f)localObject2).De != 1) {
          break label285;
        }
        m = 1;
        if (((f)localObject2).De != 2) {
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
        if (((f)localObject2).CX == 8) {
          break label1726;
        }
        j += 1;
        if (paramInt1 != 0) {
          break label353;
        }
        f2 = ((f)localObject2).getWidth() + f5;
        f1 = f2;
        if (localObject2 != localf2) {
          f1 = f2 + localObject2.Cx[paramInt2].fv();
        }
        f2 = f1;
        if (localObject2 != localf3) {
          f2 = f1 + localObject2.Cx[(paramInt2 + 1)].fv();
        }
        f3 = f3 + localObject2.Cx[paramInt2].fv() + localObject2.Cx[(paramInt2 + 1)].fv();
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
      if (((f)localObject2).CX != 8)
      {
        i2 = i1;
        if (localObject2.Cz[paramInt1] == f.a.Dq)
        {
          if (paramInt1 == 0)
          {
            if (((f)localObject2).BZ != 0)
            {
              AppMethodBeat.o(229586);
              return false;
              k = 0;
              break;
              m = 0;
              break label78;
              i = 0;
              break label90;
              if (((f)localObject2).Df == 0)
              {
                k = 1;
                if (((f)localObject2).Df != 1) {
                  break label341;
                }
              }
              label341:
              for (m = 1;; m = 0)
              {
                if (((f)localObject2).Df != 2) {
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
            if ((((f)localObject2).Cc == 0) && (((f)localObject2).Cd == 0)) {
              break label428;
            }
            AppMethodBeat.o(229586);
            return false;
          }
          if (((f)localObject2).Ca != 0)
          {
            AppMethodBeat.o(229586);
            return false;
          }
          if ((((f)localObject2).Cf != 0) || (((f)localObject2).Cg != 0))
          {
            AppMethodBeat.o(229586);
            return false;
          }
          if (((f)localObject2).CB != 0.0F)
          {
            AppMethodBeat.o(229586);
            return false;
          }
          i2 = i1 + 1;
        }
      }
      paramd = localObject2.Cx[(paramInt2 + 1)].Bv;
      if (paramd != null)
      {
        localObject3 = paramd.Bt;
        if (localObject3.Cx[paramInt2].Bv != null)
        {
          paramd = (d)localObject3;
          if (localObject3.Cx[paramInt2].Bv.Bt == localObject2) {
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
      Object localObject3 = localObject1.Cx[paramInt2].Bs;
      paramd = localf1.Cx[(paramInt2 + 1)].Bs;
      if ((((m)localObject3).Ej == null) || (paramd.Ej == null))
      {
        AppMethodBeat.o(229586);
        return false;
      }
      if ((((m)localObject3).Ej.state != 1) || (paramd.Ej.state != 1))
      {
        AppMethodBeat.o(229586);
        return false;
      }
      if ((i1 > 0) && (i1 != j))
      {
        AppMethodBeat.o(229586);
        return false;
      }
      f1 = 0.0F;
      f2 = 0.0F;
      if ((i != 0) || (k != 0) || (m != 0))
      {
        if (localf2 != null) {
          f2 = localf2.Cx[paramInt2].fv();
        }
        f1 = f2;
        if (localf3 != null) {
          f1 = f2 + localf3.Cx[(paramInt2 + 1)].fv();
        }
      }
      float f4 = ((m)localObject3).Ej.El;
      f2 = paramd.Ej.El;
      if (f4 < f2) {
        f2 = f2 - f4 - f5;
      }
      for (;;)
      {
        if ((i1 > 0) && (i1 == j)) {
          if ((((f)localObject2).CA != null) && (localObject2.CA.Cz[paramInt1] == f.a.Dp))
          {
            AppMethodBeat.o(229586);
            return false;
            f2 = f4 - f2 - f5;
          }
          else
          {
            f3 = f2 + f5 - f3;
            f2 = f4;
            if (localObject1 != null)
            {
              if (androidx.constraintlayout.a.e.AF != null)
              {
                parame = androidx.constraintlayout.a.e.AF;
                AppMethodBeat.o(229586);
                throw null;
              }
              paramd = localObject1.Dk[paramInt1];
              if ((paramd == null) && (localObject1 != localf1)) {
                break label1719;
              }
              f1 = f3 / i1;
              if (f6 > 0.0F)
              {
                if (localObject1.Di[paramInt1] == -1.0F) {
                  f1 = 0.0F;
                }
              }
              else
              {
                label881:
                if (((f)localObject1).CX == 8) {
                  f1 = 0.0F;
                }
                f2 += localObject1.Cx[paramInt2].fv();
                localObject1.Cx[paramInt2].Bs.a(((m)localObject3).Ek, f2);
                localObject1.Cx[(paramInt2 + 1)].Bs.a(((m)localObject3).Ek, f2 + f1);
                localObject1.Cx[paramInt2].Bs.c(parame);
                localObject1.Cx[(paramInt2 + 1)].Bs.c(parame);
              }
            }
          }
        }
      }
      for (f1 = f1 + f2 + localObject1.Cx[(paramInt2 + 1)].fv();; f1 = f2)
      {
        localObject1 = paramd;
        f2 = f1;
        break;
        f1 = localObject1.Di[paramInt1] * f3 / f6;
        break label881;
        AppMethodBeat.o(229586);
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
              f3 = ((f)localObject1).CT;
            }
            for (;;)
            {
              f1 = f4 + f3 * (f2 - f1);
              if (localObject1 == null) {
                break label1670;
              }
              if (androidx.constraintlayout.a.e.AF == null) {
                break;
              }
              parame = androidx.constraintlayout.a.e.AF;
              AppMethodBeat.o(229586);
              throw null;
              if (paramInt1 == 1) {
                f3 = ((f)localObject1).CU;
              } else {
                f3 = -1.0F;
              }
            }
            paramd = localObject1.Dk[paramInt1];
            if ((paramd == null) && (localObject1 != localf1)) {
              break label1701;
            }
            if (paramInt1 == 0)
            {
              f2 = ((f)localObject1).getWidth();
              f1 += localObject1.Cx[paramInt2].fv();
              localObject1.Cx[paramInt2].Bs.a(((m)localObject3).Ek, f1);
              localObject1.Cx[(paramInt2 + 1)].Bs.a(((m)localObject3).Ek, f1 + f2);
              localObject1.Cx[paramInt2].Bs.c(parame);
              localObject1.Cx[(paramInt2 + 1)].Bs.c(parame);
              f1 = f2 + f1 + localObject1.Cx[(paramInt2 + 1)].fv();
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
                if (((f)localObject1).CX == 8) {
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
                    f3 = localf2.Cx[paramInt2].fv() + f4;
                  }
                }
                if ((m != 0) && (localf2 != null))
                {
                  f1 = f3 + localf2.Cx[paramInt2].fv();
                  paramd = (d)localObject1;
                }
                for (;;)
                {
                  if (paramd != null)
                  {
                    if (androidx.constraintlayout.a.e.AF != null)
                    {
                      parame = androidx.constraintlayout.a.e.AF;
                      AppMethodBeat.o(229586);
                      throw null;
                      if (k == 0) {
                        break label1694;
                      }
                      f1 = f2 - f1;
                      break;
                      f2 = f1 / 2.0F;
                      break label1344;
                    }
                    localObject1 = paramd.Dk[paramInt1];
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
                        f4 = f1 + paramd.Cx[paramInt2].fv();
                      }
                      paramd.Cx[paramInt2].Bs.a(((m)localObject3).Ek, f4);
                      paramd.Cx[(paramInt2 + 1)].Bs.a(((m)localObject3).Ek, f4 + f3);
                      paramd.Cx[paramInt2].Bs.c(parame);
                      paramd.Cx[(paramInt2 + 1)].Bs.c(parame);
                      f1 = f4 + (paramd.Cx[(paramInt2 + 1)].fv() + f3);
                      f3 = f1;
                      if (localObject1 != null)
                      {
                        f3 = f1;
                        if (((f)localObject1).CX != 8) {
                          f3 = f1 + f2;
                        }
                      }
                      paramd = (d)localObject1;
                      f1 = f3;
                      break;
                    }
                  }
                  AppMethodBeat.o(229586);
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
    if (paramf.Cz[paramInt] != f.a.Dq) {}
    do
    {
      for (;;)
      {
        return false;
        if (paramf.CB == 0.0F) {
          break;
        }
        paramf = paramf.Cz;
        if (paramInt == 0) {}
        for (paramInt = i; paramf[paramInt] == f.a.Dq; paramInt = 0) {
          return false;
        }
      }
      if (paramInt != 0) {
        break;
      }
    } while ((paramf.BZ != 0) || (paramf.Cc != 0) || (paramf.Cd != 0));
    do
    {
      return true;
      if ((paramf.Ca != 0) || (paramf.Cf != 0)) {
        break;
      }
    } while (paramf.Cg == 0);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     androidx.constraintlayout.a.a.k
 * JD-Core Version:    0.7.0.1
 */