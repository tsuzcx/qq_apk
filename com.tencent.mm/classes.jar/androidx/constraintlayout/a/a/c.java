package androidx.constraintlayout.a.a;

import androidx.constraintlayout.a.a;
import androidx.constraintlayout.a.b;
import androidx.constraintlayout.a.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;

final class c
{
  static void a(g paramg, androidx.constraintlayout.a.e parame, int paramInt)
  {
    AppMethodBeat.i(194046);
    int m;
    d[] arrayOfd;
    int n;
    int i1;
    Object localObject5;
    f localf1;
    f localf2;
    Object localObject1;
    f localf3;
    Object localObject6;
    int i5;
    float f2;
    int i3;
    label140:
    int i;
    label155:
    int j;
    label167:
    int k;
    label179:
    int i4;
    Object localObject3;
    int i2;
    if (paramInt == 0)
    {
      m = paramg.bjH;
      arrayOfd = paramg.bjK;
      n = 0;
      i1 = 0;
      if (i1 >= m) {
        break label2805;
      }
      localObject5 = arrayOfd[i1];
      if (!((d)localObject5).bhz) {
        ((d)localObject5).CC();
      }
      ((d)localObject5).bhz = true;
      if ((paramg.dO(4)) && (k.a(parame, paramInt, n, (d)localObject5))) {
        break label1669;
      }
      localf1 = ((d)localObject5).bhl;
      localf2 = ((d)localObject5).bhn;
      localObject1 = ((d)localObject5).bhm;
      localf3 = ((d)localObject5).bho;
      localObject6 = ((d)localObject5).bhp;
      i5 = 0;
      f2 = ((d)localObject5).bhv;
      if (paramg.biH[paramInt] != f.a.bjx) {
        break label532;
      }
      i3 = 1;
      if (paramInt != 0) {
        break label556;
      }
      if (((f)localObject6).bjm != 0) {
        break label538;
      }
      i = 1;
      if (((f)localObject6).bjm != 1) {
        break label544;
      }
      j = 1;
      if (((f)localObject6).bjm != 2) {
        break label550;
      }
      k = 1;
      i4 = k;
      localObject3 = localf1;
      i2 = i;
      k = j;
    }
    label195:
    Object localObject2;
    for (;;)
    {
      if (i5 != 0) {
        break label688;
      }
      localObject2 = localObject3.biF[n];
      i = 4;
      if ((i3 != 0) || (i4 != 0)) {
        i = 1;
      }
      j = ((e)localObject2).CE();
      int i6 = j;
      if (((e)localObject2).bhD != null)
      {
        i6 = j;
        if (localObject3 != localf1) {
          i6 = j + ((e)localObject2).bhD.CE();
        }
      }
      if ((i4 != 0) && (localObject3 != localf1) && (localObject3 != localObject1))
      {
        j = 6;
        label292:
        if (((e)localObject2).bhD != null)
        {
          if (localObject3 != localObject1) {
            break label652;
          }
          parame.a(((e)localObject2).bhJ, ((e)localObject2).bhD.bhJ, i6, 5);
          label327:
          parame.c(((e)localObject2).bhJ, ((e)localObject2).bhD.bhJ, i6, j);
        }
        if (i3 != 0)
        {
          if ((((f)localObject3).bje != 8) && (localObject3.biH[paramInt] == f.a.bjy)) {
            parame.a(localObject3.biF[(n + 1)].bhJ, localObject3.biF[n].bhJ, 0, 5);
          }
          parame.a(localObject3.biF[n].bhJ, paramg.biF[n].bhJ, 0, 6);
        }
        localObject2 = localObject3.biF[(n + 1)].bhD;
        if (localObject2 == null) {
          break label676;
        }
        localObject4 = ((e)localObject2).bhB;
        if (localObject4.biF[n].bhD != null)
        {
          localObject2 = localObject4;
          if (localObject4.biF[n].bhD.bhB == localObject3) {
            break label502;
          }
        }
      }
      label532:
      label538:
      label544:
      label676:
      for (localObject2 = null;; localObject2 = null)
      {
        label502:
        if (localObject2 == null) {
          break label682;
        }
        localObject3 = localObject2;
        break label195;
        m = paramg.bjI;
        arrayOfd = paramg.bjJ;
        n = 2;
        break;
        i3 = 0;
        break label140;
        i = 0;
        break label155;
        j = 0;
        break label167;
        label550:
        k = 0;
        break label179;
        label556:
        if (((f)localObject6).bjn == 0)
        {
          i = 1;
          label567:
          if (((f)localObject6).bjn != 1) {
            break label616;
          }
          j = 1;
          label579:
          if (((f)localObject6).bjn != 2) {
            break label622;
          }
        }
        label616:
        label622:
        for (k = 1;; k = 0)
        {
          localObject3 = localf1;
          i4 = k;
          k = j;
          i2 = i;
          break;
          i = 0;
          break label567;
          j = 0;
          break label579;
        }
        j = i;
        if (i2 == 0) {
          break label292;
        }
        j = i;
        if (i3 == 0) {
          break label292;
        }
        j = 4;
        break label292;
        parame.a(((e)localObject2).bhJ, ((e)localObject2).bhD.bhJ, i6, 6);
        break label327;
      }
      label652:
      label682:
      i5 = 1;
    }
    label688:
    if ((localf3 != null) && (localf2.biF[(n + 1)].bhD != null))
    {
      localObject2 = localf3.biF[(n + 1)];
      parame.b(((e)localObject2).bhJ, localf2.biF[(n + 1)].bhD.bhJ, -((e)localObject2).CE(), 5);
    }
    if (i3 != 0) {
      parame.a(paramg.biF[(n + 1)].bhJ, localf2.biF[(n + 1)].bhJ, localf2.biF[(n + 1)].CE(), 6);
    }
    Object localObject4 = ((d)localObject5).bhs;
    float f3;
    if (localObject4 != null)
    {
      j = ((ArrayList)localObject4).size();
      if (j > 1)
      {
        localObject2 = null;
        f3 = 0.0F;
        if ((!((d)localObject5).bhw) || (((d)localObject5).bhy)) {
          break label2849;
        }
        f2 = ((d)localObject5).bhu;
      }
    }
    label1566:
    label2849:
    for (;;)
    {
      i = 0;
      float f1;
      label989:
      Object localObject7;
      Object localObject8;
      h localh;
      Object localObject9;
      if (i < j)
      {
        localObject3 = (f)((ArrayList)localObject4).get(i);
        float f4 = localObject3.bjq[paramInt];
        f1 = f4;
        if (f4 < 0.0F) {
          if (((d)localObject5).bhy) {
            parame.c(localObject3.biF[(n + 1)].bhJ, localObject3.biF[n].bhJ, 0, 4);
          }
        }
        for (;;)
        {
          i += 1;
          break;
          f1 = 1.0F;
          if (f1 != 0.0F) {
            break label989;
          }
          parame.c(localObject3.biF[(n + 1)].bhJ, localObject3.biF[n].bhJ, 0, 6);
        }
        if (localObject2 != null)
        {
          localObject7 = localObject2.biF[n].bhJ;
          localObject2 = localObject2.biF[(n + 1)].bhJ;
          localObject8 = localObject3.biF[n].bhJ;
          localh = localObject3.biF[(n + 1)].bhJ;
          localObject9 = parame.Cv();
          ((b)localObject9).bgs = 0.0F;
          if ((f2 != 0.0F) && (f3 != f1)) {
            break label1138;
          }
          ((b)localObject9).bgu.a((h)localObject7, 1.0F);
          ((b)localObject9).bgu.a((h)localObject2, -1.0F);
          ((b)localObject9).bgu.a(localh, 1.0F);
          ((b)localObject9).bgu.a((h)localObject8, -1.0F);
        }
        for (;;)
        {
          parame.b((b)localObject9);
          localObject2 = localObject3;
          f3 = f1;
          break;
          label1138:
          if (f3 == 0.0F)
          {
            ((b)localObject9).bgu.a((h)localObject7, 1.0F);
            ((b)localObject9).bgu.a((h)localObject2, -1.0F);
          }
          else if (f1 == 0.0F)
          {
            ((b)localObject9).bgu.a((h)localObject8, 1.0F);
            ((b)localObject9).bgu.a(localh, -1.0F);
          }
          else
          {
            f3 = f3 / f2 / (f1 / f2);
            ((b)localObject9).bgu.a((h)localObject7, 1.0F);
            ((b)localObject9).bgu.a((h)localObject2, -1.0F);
            ((b)localObject9).bgu.a(localh, f3);
            ((b)localObject9).bgu.a((h)localObject8, -f3);
          }
        }
      }
      if ((localObject1 != null) && ((localObject1 == localf3) || (i4 != 0)))
      {
        localObject5 = localf1.biF[n];
        localObject4 = localf2.biF[(n + 1)];
        if (localf1.biF[n].bhD != null)
        {
          localObject2 = localf1.biF[n].bhD.bhJ;
          label1335:
          if (localf2.biF[(n + 1)].bhD == null) {
            break label1684;
          }
          localObject3 = localf2.biF[(n + 1)].bhD.bhJ;
          label1369:
          if (localObject1 == localf3)
          {
            localObject5 = localObject1.biF[n];
            localObject4 = localObject1.biF[(n + 1)];
          }
          if ((localObject2 != null) && (localObject3 != null)) {
            if (paramInt != 0) {
              break label1690;
            }
          }
        }
        for (f1 = ((f)localObject6).bja;; f1 = ((f)localObject6).bjb)
        {
          i = ((e)localObject5).CE();
          j = ((e)localObject4).CE();
          parame.a(((e)localObject5).bhJ, (h)localObject2, i, f1, (h)localObject3, ((e)localObject4).bhJ, j, 5);
          if (((i2 != 0) || (k != 0)) && (localObject1 != null))
          {
            localObject5 = localObject1.biF[n];
            localObject4 = localf3.biF[(n + 1)];
            if (((e)localObject5).bhD == null) {
              break label2787;
            }
            localObject3 = ((e)localObject5).bhD.bhJ;
            label1511:
            if (((e)localObject4).bhD == null) {
              break label2793;
            }
            localObject2 = ((e)localObject4).bhD.bhJ;
            label1529:
            if (localf2 != localf3)
            {
              localObject2 = localf2.biF[(n + 1)];
              if (((e)localObject2).bhD == null) {
                break label2799;
              }
              localObject2 = ((e)localObject2).bhD.bhJ;
            }
            if (localObject1 != localf3) {
              break label2818;
            }
            localObject4 = localObject1.biF[n];
            localObject5 = localObject1.biF[(n + 1)];
            localObject1 = localObject4;
            localObject4 = localObject5;
            label1603:
            if ((localObject3 != null) && (localObject2 != null))
            {
              i = ((e)localObject1).CE();
              if (localf3 != null) {
                break label2811;
              }
              localObject5 = localf2;
              label1629:
              j = localObject5.biF[(n + 1)].CE();
              parame.a(((e)localObject1).bhJ, (h)localObject3, i, 0.5F, (h)localObject2, ((e)localObject4).bhJ, j, 5);
            }
          }
          i1 += 1;
          break;
          localObject2 = null;
          break label1335;
          localObject3 = null;
          break label1369;
        }
      }
      if ((i2 != 0) && (localObject1 != null))
      {
        if ((((d)localObject5).bhu > 0) && (((d)localObject5).bht == ((d)localObject5).bhu)) {}
        for (i3 = 1;; i3 = 0)
        {
          localObject5 = localObject1;
          localObject4 = localObject1;
          label1741:
          if (localObject4 == null) {
            break label2086;
          }
          for (localObject3 = localObject4.bjs[paramInt]; (localObject3 != null) && (((f)localObject3).bje == 8); localObject3 = localObject3.bjs[paramInt]) {}
        }
        if ((localObject3 != null) || (localObject4 == localf3))
        {
          localObject7 = localObject4.biF[n];
          localh = ((e)localObject7).bhJ;
          if (((e)localObject7).bhD == null) {
            break label2088;
          }
          localObject2 = ((e)localObject7).bhD.bhJ;
          label1835:
          if (localObject5 == localObject4) {
            break label2094;
          }
          localObject2 = localObject5.biF[(n + 1)].bhJ;
          label1857:
          localObject6 = localObject2;
          label1861:
          localObject2 = null;
          i4 = ((e)localObject7).CE();
          j = localObject4.biF[(n + 1)].CE();
          if (localObject3 == null) {
            break label2155;
          }
          localObject7 = localObject3.biF[n];
          localObject2 = ((e)localObject7).bhJ;
          label1908:
          localObject8 = localObject4.biF[(n + 1)].bhJ;
          i = j;
          if (localObject7 != null) {
            i = j + ((e)localObject7).CE();
          }
          j = i4;
          if (localObject5 != null) {
            j = i4 + localObject5.biF[(n + 1)].CE();
          }
          if ((localh != null) && (localObject6 != null) && (localObject2 != null) && (localObject8 != null))
          {
            if (localObject4 == localObject1) {
              j = localObject1.biF[n].CE();
            }
            if (localObject4 == localf3) {
              i = localf3.biF[(n + 1)].CE();
            }
            i4 = 4;
            if (i3 != 0) {
              i4 = 6;
            }
            parame.a(localh, (h)localObject6, j, 0.5F, (h)localObject2, (h)localObject8, i, i4);
          }
        }
        if (((f)localObject4).bje == 8) {
          break label2842;
        }
      }
      for (localObject2 = localObject4;; localObject2 = localObject5)
      {
        localObject4 = localObject3;
        localObject5 = localObject2;
        break label1741;
        label2086:
        break;
        label2088:
        localObject2 = null;
        break label1835;
        label2094:
        localObject6 = localObject2;
        if (localObject4 != localObject1) {
          break label1861;
        }
        localObject6 = localObject2;
        if (localObject5 != localObject4) {
          break label1861;
        }
        if (localf1.biF[n].bhD != null)
        {
          localObject2 = localf1.biF[n].bhD.bhJ;
          break label1857;
        }
        localObject2 = null;
        break label1857;
        label2155:
        localObject8 = localf2.biF[(n + 1)].bhD;
        localObject7 = localObject8;
        if (localObject8 == null) {
          break label1908;
        }
        localObject2 = ((e)localObject8).bhJ;
        localObject7 = localObject8;
        break label1908;
        if ((k == 0) || (localObject1 == null)) {
          break;
        }
        if ((((d)localObject5).bhu > 0) && (((d)localObject5).bht == ((d)localObject5).bhu)) {}
        for (i = 1;; i = 0)
        {
          localObject4 = localObject1;
          localObject3 = localObject1;
          label2235:
          if (localObject3 == null) {
            break label2622;
          }
          for (localObject2 = localObject3.bjs[paramInt]; (localObject2 != null) && (((f)localObject2).bje == 8); localObject2 = localObject2.bjs[paramInt]) {}
        }
        if ((localObject3 != localObject1) && (localObject3 != localf3) && (localObject2 != null)) {
          if (localObject2 == localf3)
          {
            localObject2 = null;
            localObject6 = localObject3.biF[n];
            localh = ((e)localObject6).bhJ;
            localObject9 = localObject4.biF[(n + 1)].bhJ;
            localObject5 = null;
            i4 = ((e)localObject6).CE();
            i3 = localObject3.biF[(n + 1)].CE();
            if (localObject2 != null)
            {
              localObject8 = localObject2.biF[n];
              localObject6 = ((e)localObject8).bhJ;
              if (((e)localObject8).bhD != null)
              {
                localObject5 = ((e)localObject8).bhD.bhJ;
                label2408:
                localObject7 = localObject5;
                localObject5 = localObject8;
                label2416:
                j = i3;
                if (localObject5 != null) {
                  j = i3 + ((e)localObject5).CE();
                }
                i3 = i4;
                if (localObject4 != null) {
                  i3 = i4 + localObject4.biF[(n + 1)].CE();
                }
                i4 = 4;
                if (i != 0) {
                  i4 = 6;
                }
                localObject5 = localObject2;
                if (localh != null)
                {
                  localObject5 = localObject2;
                  if (localObject9 != null)
                  {
                    localObject5 = localObject2;
                    if (localObject6 != null)
                    {
                      localObject5 = localObject2;
                      if (localObject7 != null) {
                        parame.a(localh, (h)localObject9, i3, 0.5F, (h)localObject6, (h)localObject7, j, i4);
                      }
                    }
                  }
                }
              }
            }
          }
        }
        for (localObject5 = localObject2;; localObject5 = localObject2)
        {
          if (((f)localObject3).bje != 8) {}
          for (localObject2 = localObject3;; localObject2 = localObject4)
          {
            localObject3 = localObject5;
            localObject4 = localObject2;
            break label2235;
            localObject5 = null;
            break label2408;
            localObject7 = localObject3.biF[(n + 1)].bhD;
            if (localObject7 != null) {
              localObject5 = ((e)localObject7).bhJ;
            }
            localObject8 = localObject3.biF[(n + 1)].bhJ;
            localObject6 = localObject5;
            localObject5 = localObject7;
            localObject7 = localObject8;
            break label2416;
            label2622:
            localObject2 = localObject1.biF[n];
            localObject3 = localf1.biF[n].bhD;
            localObject4 = localf3.biF[(n + 1)];
            localObject5 = localf2.biF[(n + 1)].bhD;
            if (localObject3 != null)
            {
              if (localObject1 == localf3) {
                break label2742;
              }
              parame.c(((e)localObject2).bhJ, ((e)localObject3).bhJ, ((e)localObject2).CE(), 5);
            }
            for (;;)
            {
              if ((localObject5 == null) || (localObject1 == localf3)) {
                break label2785;
              }
              parame.c(((e)localObject4).bhJ, ((e)localObject5).bhJ, -((e)localObject4).CE(), 5);
              break;
              label2742:
              if (localObject5 != null) {
                parame.a(((e)localObject2).bhJ, ((e)localObject3).bhJ, ((e)localObject2).CE(), 0.5F, ((e)localObject4).bhJ, ((e)localObject5).bhJ, ((e)localObject4).CE(), 5);
              }
            }
            label2785:
            break;
            label2787:
            localObject3 = null;
            break label1511;
            label2793:
            localObject2 = null;
            break label1529;
            label2799:
            localObject2 = null;
            break label1566;
            label2805:
            AppMethodBeat.o(194046);
            return;
            label2811:
            localObject5 = localf3;
            break label1629;
            localObject1 = localObject5;
            break label1603;
          }
          break label2311;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     androidx.constraintlayout.a.a.c
 * JD-Core Version:    0.7.0.1
 */