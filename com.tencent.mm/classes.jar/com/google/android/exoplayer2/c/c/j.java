package com.google.android.exoplayer2.c.c;

import android.util.SparseArray;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.c.f;
import com.google.android.exoplayer2.i.h.a;
import com.google.android.exoplayer2.i.h.b;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class j
  implements h
{
  private com.google.android.exoplayer2.c.k aCt;
  private final boolean[] aDJ;
  private long aDL;
  private long aDN;
  private final r aDU;
  private final boolean aDV;
  private final boolean aDW;
  private final n aDX;
  private final n aDY;
  private final n aDZ;
  private String aDt;
  private boolean aDx;
  private j.a aEa;
  private final com.google.android.exoplayer2.i.j aEb;
  
  public j(r paramr, boolean paramBoolean1, boolean paramBoolean2)
  {
    this.aDU = paramr;
    this.aDV = paramBoolean1;
    this.aDW = paramBoolean2;
    this.aDJ = new boolean[3];
    this.aDX = new n(7);
    this.aDY = new n(8);
    this.aDZ = new n(6);
    this.aEb = new com.google.android.exoplayer2.i.j();
  }
  
  private void e(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if ((!this.aDx) || (this.aEa.aDW))
    {
      this.aDX.f(paramArrayOfByte, paramInt1, paramInt2);
      this.aDY.f(paramArrayOfByte, paramInt1, paramInt2);
    }
    this.aDZ.f(paramArrayOfByte, paramInt1, paramInt2);
    j.a locala = this.aEa;
    int i2;
    int i3;
    if (locala.aDS)
    {
      paramInt2 -= paramInt1;
      if (locala.buffer.length < locala.aEf + paramInt2) {
        locala.buffer = Arrays.copyOf(locala.buffer, (locala.aEf + paramInt2) * 2);
      }
      System.arraycopy(paramArrayOfByte, paramInt1, locala.buffer, locala.aEf, paramInt2);
      locala.aEf = (paramInt2 + locala.aEf);
      locala.aEe.k(locala.buffer, 0, locala.aEf);
      if (locala.aEe.dC(8))
      {
        locala.aEe.ok();
        i2 = locala.aEe.dz(2);
        locala.aEe.dy(5);
        if (locala.aEe.ol())
        {
          locala.aEe.on();
          if (locala.aEe.ol())
          {
            i3 = locala.aEe.on();
            if (locala.aDW) {
              break label264;
            }
            locala.aDS = false;
            paramArrayOfByte = locala.aEk;
            paramArrayOfByte.aEq = i3;
            paramArrayOfByte.aEn = true;
          }
        }
      }
    }
    label263:
    label264:
    int i4;
    Object localObject;
    boolean bool2;
    int i5;
    boolean bool3;
    boolean bool1;
    boolean bool4;
    label498:
    int j;
    int n;
    int i1;
    do
    {
      do
      {
        do
        {
          do
          {
            boolean bool5;
            boolean bool6;
            do
            {
              do
              {
                do
                {
                  break label263;
                  break label263;
                  break label263;
                  break label263;
                  break label263;
                  break label263;
                  break label263;
                  do
                  {
                    return;
                  } while (!locala.aEe.ol());
                  i4 = locala.aEe.on();
                  if (locala.aEd.indexOfKey(i4) < 0)
                  {
                    locala.aDS = false;
                    return;
                  }
                  localObject = (h.a)locala.aEd.get(i4);
                  paramArrayOfByte = (h.b)locala.aEc.get(((h.a)localObject).aSr);
                  if (!paramArrayOfByte.aSu) {
                    break;
                  }
                } while (!locala.aEe.dC(2));
                locala.aEe.dy(2);
              } while (!locala.aEe.dC(paramArrayOfByte.aSw));
              bool2 = false;
              bool5 = false;
              bool6 = false;
              i5 = locala.aEe.dz(paramArrayOfByte.aSw);
              bool3 = bool6;
              bool1 = bool5;
              if (paramArrayOfByte.aSv) {
                break;
              }
            } while (!locala.aEe.dC(1));
            bool4 = locala.aEe.ob();
            bool3 = bool6;
            bool1 = bool5;
            bool2 = bool4;
            if (!bool4) {
              break;
            }
          } while (!locala.aEe.dC(1));
          bool3 = locala.aEe.ob();
          bool1 = true;
          bool2 = bool4;
          if (locala.aEg != 5) {
            break label758;
          }
          bool4 = true;
          j = 0;
          if (!bool4) {
            break;
          }
        } while (!locala.aEe.ol());
        j = locala.aEe.on();
        i = 0;
        n = 0;
        m = 0;
        k = 0;
        i1 = 0;
        if (paramArrayOfByte.aSx != 0) {
          break label764;
        }
      } while (!locala.aEe.dC(paramArrayOfByte.aSy));
      i = locala.aEe.dz(paramArrayOfByte.aSy);
      paramInt2 = k;
      paramInt1 = i;
      if (!((h.a)localObject).aSs) {
        break label871;
      }
      paramInt2 = k;
      paramInt1 = i;
      if (bool2) {
        break label871;
      }
    } while (!locala.aEe.ol());
    int k = locala.aEe.om();
    int m = 0;
    paramInt1 = i;
    paramInt2 = i1;
    int i = m;
    for (;;)
    {
      localObject = locala.aEk;
      ((j.a.a)localObject).aEo = paramArrayOfByte;
      ((j.a.a)localObject).aEp = i2;
      ((j.a.a)localObject).aEq = i3;
      ((j.a.a)localObject).frameNum = i5;
      ((j.a.a)localObject).aEr = i4;
      ((j.a.a)localObject).aEs = bool2;
      ((j.a.a)localObject).aEt = bool1;
      ((j.a.a)localObject).aEu = bool3;
      ((j.a.a)localObject).aEv = bool4;
      ((j.a.a)localObject).aEw = j;
      ((j.a.a)localObject).aEx = paramInt1;
      ((j.a.a)localObject).aEy = k;
      ((j.a.a)localObject).aEz = paramInt2;
      ((j.a.a)localObject).aEA = i;
      ((j.a.a)localObject).aEm = true;
      ((j.a.a)localObject).aEn = true;
      locala.aDS = false;
      return;
      label758:
      bool4 = false;
      break label498;
      label764:
      paramInt2 = k;
      paramInt1 = i;
      if (paramArrayOfByte.aSx == 1)
      {
        paramInt2 = k;
        paramInt1 = i;
        if (!paramArrayOfByte.aSz)
        {
          if (!locala.aEe.ol()) {
            break;
          }
          k = locala.aEe.om();
          paramInt2 = k;
          paramInt1 = i;
          if (((h.a)localObject).aSs)
          {
            paramInt2 = k;
            paramInt1 = i;
            if (!bool2)
            {
              if (!locala.aEe.ol()) {
                break;
              }
              i = locala.aEe.om();
              paramInt2 = k;
              k = m;
              paramInt1 = n;
              continue;
            }
          }
        }
      }
      label871:
      i = 0;
      k = m;
    }
  }
  
  public final void a(f paramf, u.d paramd)
  {
    paramd.mg();
    this.aDt = paramd.mi();
    this.aCt = paramf.cQ(paramd.mh());
    this.aEa = new j.a(this.aCt, this.aDV, this.aDW);
    this.aDU.a(paramf, paramd);
  }
  
  public final void b(com.google.android.exoplayer2.i.j paramj)
  {
    int i = paramj.position;
    int j = paramj.limit;
    byte[] arrayOfByte = paramj.data;
    this.aDL += paramj.oe();
    this.aCt.a(paramj, paramj.oe());
    int k = com.google.android.exoplayer2.i.h.a(arrayOfByte, i, j, this.aDJ);
    if (k == j)
    {
      e(arrayOfByte, i, j);
      return;
    }
    int m = com.google.android.exoplayer2.i.h.j(arrayOfByte, k);
    int i1 = k - i;
    if (i1 > 0) {
      e(arrayOfByte, i, k);
    }
    int n = j - k;
    long l1 = this.aDL - n;
    label126:
    long l2;
    Object localObject1;
    label361:
    int i3;
    if (i1 < 0)
    {
      i = -i1;
      l2 = this.aDN;
      Object localObject2;
      if ((!this.aDx) || (this.aEa.aDW))
      {
        this.aDX.dd(i);
        this.aDY.dd(i);
        if (this.aDx) {
          break label1051;
        }
        if ((this.aDX.aES) && (this.aDY.aES))
        {
          paramj = new ArrayList();
          paramj.add(Arrays.copyOf(this.aDX.aET, this.aDX.aEU));
          paramj.add(Arrays.copyOf(this.aDY.aET, this.aDY.aEU));
          localObject1 = com.google.android.exoplayer2.i.h.j(this.aDX.aET, 3, this.aDX.aEU);
          localObject2 = com.google.android.exoplayer2.i.h.l(this.aDY.aET, this.aDY.aEU);
          this.aCt.f(Format.a(this.aDt, "video/avc", ((h.b)localObject1).width, ((h.b)localObject1).height, paramj, ((h.b)localObject1).aSt));
          this.aDx = true;
          this.aEa.a((h.b)localObject1);
          this.aEa.a((h.a)localObject2);
          this.aDX.reset();
          this.aDY.reset();
        }
      }
      if (this.aDZ.dd(i))
      {
        i = com.google.android.exoplayer2.i.h.i(this.aDZ.aET, this.aDZ.aEU);
        this.aEb.m(this.aDZ.aET, i);
        this.aEb.setPosition(4);
        this.aDU.a(l2, this.aEb);
      }
      paramj = this.aEa;
      if (paramj.aEg != 9)
      {
        if (paramj.aDW)
        {
          localObject1 = paramj.aEk;
          localObject2 = paramj.aEj;
          if ((!((j.a.a)localObject1).aEm) || ((((j.a.a)localObject2).aEm) && (((j.a.a)localObject1).frameNum == ((j.a.a)localObject2).frameNum) && (((j.a.a)localObject1).aEr == ((j.a.a)localObject2).aEr) && (((j.a.a)localObject1).aEs == ((j.a.a)localObject2).aEs) && ((!((j.a.a)localObject1).aEt) || (!((j.a.a)localObject2).aEt) || (((j.a.a)localObject1).aEu == ((j.a.a)localObject2).aEu)) && ((((j.a.a)localObject1).aEp == ((j.a.a)localObject2).aEp) || ((((j.a.a)localObject1).aEp != 0) && (((j.a.a)localObject2).aEp != 0))) && ((((j.a.a)localObject1).aEo.aSx != 0) || (((j.a.a)localObject2).aEo.aSx != 0) || ((((j.a.a)localObject1).aEx == ((j.a.a)localObject2).aEx) && (((j.a.a)localObject1).aEy == ((j.a.a)localObject2).aEy))) && ((((j.a.a)localObject1).aEo.aSx != 1) || (((j.a.a)localObject2).aEo.aSx != 1) || ((((j.a.a)localObject1).aEz == ((j.a.a)localObject2).aEz) && (((j.a.a)localObject1).aEA == ((j.a.a)localObject2).aEA))) && (((j.a.a)localObject1).aEv == ((j.a.a)localObject2).aEv) && ((!((j.a.a)localObject1).aEv) || (!((j.a.a)localObject2).aEv) || (((j.a.a)localObject1).aEw == ((j.a.a)localObject2).aEw)))) {
            break label1144;
          }
          i = 1;
          label714:
          if (i == 0) {}
        }
      }
      else
      {
        if (paramj.aEl)
        {
          i1 = (int)(l1 - paramj.aEh);
          if (!paramj.aDP) {
            break label1149;
          }
          i = 1;
          label744:
          int i2 = (int)(paramj.aEh - paramj.aDO);
          paramj.aCt.a(paramj.aDG, i, i2, n + i1, null);
        }
        paramj.aDO = paramj.aEh;
        paramj.aDG = paramj.aEi;
        paramj.aDP = false;
        paramj.aEl = true;
      }
      i3 = paramj.aDP;
      if (paramj.aEg != 5)
      {
        if ((!paramj.aDV) || (paramj.aEg != 1)) {
          break label1159;
        }
        localObject1 = paramj.aEk;
        if ((!((j.a.a)localObject1).aEn) || ((((j.a.a)localObject1).aEq != 7) && (((j.a.a)localObject1).aEq != 2))) {
          break label1154;
        }
        i = 1;
        label868:
        if (i == 0) {
          break label1159;
        }
      }
    }
    label1154:
    label1159:
    for (i = 1;; i = 0)
    {
      paramj.aDP = (i | i3);
      l2 = this.aDN;
      if ((!this.aDx) || (this.aEa.aDW))
      {
        this.aDX.dc(m);
        this.aDY.dc(m);
      }
      this.aDZ.dc(m);
      paramj = this.aEa;
      paramj.aEg = m;
      paramj.aEi = l2;
      paramj.aEh = l1;
      if (((paramj.aDV) && (paramj.aEg == 1)) || ((paramj.aDW) && ((paramj.aEg == 5) || (paramj.aEg == 1) || (paramj.aEg == 2))))
      {
        localObject1 = paramj.aEj;
        paramj.aEj = paramj.aEk;
        paramj.aEk = ((j.a.a)localObject1);
        paramj.aEk.clear();
        paramj.aEf = 0;
        paramj.aDS = true;
      }
      i = k + 3;
      break;
      i = 0;
      break label126;
      label1051:
      if (this.aDX.aES)
      {
        paramj = com.google.android.exoplayer2.i.h.j(this.aDX.aET, 3, this.aDX.aEU);
        this.aEa.a(paramj);
        this.aDX.reset();
        break label361;
      }
      if (!this.aDY.aES) {
        break label361;
      }
      paramj = com.google.android.exoplayer2.i.h.l(this.aDY.aET, this.aDY.aEU);
      this.aEa.a(paramj);
      this.aDY.reset();
      break label361;
      label1144:
      i = 0;
      break label714;
      label1149:
      i = 0;
      break label744;
      i = 0;
      break label868;
    }
  }
  
  public final void d(long paramLong, boolean paramBoolean)
  {
    this.aDN = paramLong;
  }
  
  public final void lY()
  {
    com.google.android.exoplayer2.i.h.b(this.aDJ);
    this.aDX.reset();
    this.aDY.reset();
    this.aDZ.reset();
    this.aEa.reset();
    this.aDL = 0L;
  }
  
  public final void lZ() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.android.exoplayer2.c.c.j
 * JD-Core Version:    0.7.0.1
 */