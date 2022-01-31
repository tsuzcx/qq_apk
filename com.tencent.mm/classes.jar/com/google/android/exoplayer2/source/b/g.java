package com.google.android.exoplayer2.source.b;

import android.os.Handler;
import android.text.TextUtils;
import android.util.SparseArray;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.h.b;
import com.google.android.exoplayer2.h.t;
import com.google.android.exoplayer2.i.x;
import com.google.android.exoplayer2.source.b.a.e.a;
import com.google.android.exoplayer2.source.b.a.e.b;
import com.google.android.exoplayer2.source.h;
import com.google.android.exoplayer2.source.h.a;
import com.google.android.exoplayer2.source.l;
import com.google.android.exoplayer2.source.o;
import com.google.android.exoplayer2.source.p;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.LinkedList;
import java.util.List;

public final class g
  implements e.b, j.a, h
{
  private h.a aOX;
  private final int aPj;
  private final b aPm;
  private final k aQW;
  final com.google.android.exoplayer2.source.b.a.e aQY;
  private final d aRI;
  private final com.google.android.exoplayer2.source.a.a aRJ;
  private final IdentityHashMap<l, Integer> aRK;
  final Handler aRL;
  private int aRM;
  j[] aRN;
  private j[] aRO;
  private com.google.android.exoplayer2.source.e aRP;
  private p avL;
  
  public g(com.google.android.exoplayer2.source.b.a.e parame, d paramd, int paramInt, com.google.android.exoplayer2.source.a.a parama, b paramb)
  {
    AppMethodBeat.i(125910);
    this.aQY = parame;
    this.aRI = paramd;
    this.aPj = paramInt;
    this.aRJ = parama;
    this.aPm = paramb;
    this.aRK = new IdentityHashMap();
    this.aQW = new k();
    this.aRL = new Handler();
    this.aRN = new j[0];
    this.aRO = new j[0];
    AppMethodBeat.o(125910);
  }
  
  private j a(int paramInt, com.google.android.exoplayer2.source.b.a.a.a[] paramArrayOfa, Format paramFormat, List<Format> paramList, long paramLong)
  {
    AppMethodBeat.i(125923);
    paramArrayOfa = new j(paramInt, this, new c(this.aQY, paramArrayOfa, this.aRI, this.aQW, paramList), this.aPm, paramLong, paramFormat, this.aPj, this.aRJ);
    AppMethodBeat.o(125923);
    return paramArrayOfa;
  }
  
  private static boolean a(com.google.android.exoplayer2.source.b.a.a.a parama, String paramString)
  {
    AppMethodBeat.i(125925);
    parama = parama.axd.awH;
    if (TextUtils.isEmpty(parama))
    {
      AppMethodBeat.o(125925);
      return false;
    }
    parama = parama.split("(\\s*,\\s*)|(\\s*$)");
    int j = parama.length;
    int i = 0;
    while (i < j)
    {
      if (parama[i].startsWith(paramString))
      {
        AppMethodBeat.o(125925);
        return true;
      }
      i += 1;
    }
    AppMethodBeat.o(125925);
    return false;
  }
  
  private void pz()
  {
    AppMethodBeat.i(125924);
    if (this.avL != null)
    {
      this.aOX.a(this);
      AppMethodBeat.o(125924);
      return;
    }
    j[] arrayOfj = this.aRN;
    int j = arrayOfj.length;
    int i = 0;
    while (i < j)
    {
      arrayOfj[i].pA();
      i += 1;
    }
    AppMethodBeat.o(125924);
  }
  
  public final void O(long paramLong)
  {
    AppMethodBeat.i(125914);
    j[] arrayOfj = this.aRO;
    int k = arrayOfj.length;
    int i = 0;
    while (i < k)
    {
      j localj = arrayOfj[i];
      int m = localj.aPv.length;
      int j = 0;
      while (j < m)
      {
        localj.aPv[j].i(paramLong, localj.aSd[j]);
        j += 1;
      }
      i += 1;
    }
    AppMethodBeat.o(125914);
  }
  
  public final long P(long paramLong)
  {
    AppMethodBeat.i(125918);
    if (this.aRO.length > 0)
    {
      boolean bool = this.aRO[0].j(paramLong, false);
      int i = 1;
      while (i < this.aRO.length)
      {
        this.aRO[i].j(paramLong, bool);
        i += 1;
      }
      if (bool) {
        this.aQW.aSh.clear();
      }
    }
    AppMethodBeat.o(125918);
    return paramLong;
  }
  
  public final boolean Q(long paramLong)
  {
    AppMethodBeat.i(125915);
    boolean bool = this.aRP.Q(paramLong);
    AppMethodBeat.o(125915);
    return bool;
  }
  
  public final long a(com.google.android.exoplayer2.g.f[] paramArrayOff, boolean[] paramArrayOfBoolean1, l[] paramArrayOfl, boolean[] paramArrayOfBoolean2, long paramLong)
  {
    AppMethodBeat.i(125913);
    int[] arrayOfInt1 = new int[paramArrayOff.length];
    int[] arrayOfInt2 = new int[paramArrayOff.length];
    int i = 0;
    int j;
    label37:
    Object localObject1;
    if (i < paramArrayOff.length)
    {
      if (paramArrayOfl[i] == null)
      {
        j = -1;
        arrayOfInt1[i] = j;
        arrayOfInt2[i] = -1;
        if (paramArrayOff[i] != null)
        {
          localObject1 = paramArrayOff[i].qg();
          j = 0;
        }
      }
      for (;;)
      {
        if (j < this.aRN.length)
        {
          if (this.aRN[j].avL.a((o)localObject1) != -1) {
            arrayOfInt2[i] = j;
          }
        }
        else
        {
          i += 1;
          break;
          j = ((Integer)this.aRK.get(paramArrayOfl[i])).intValue();
          break label37;
        }
        j += 1;
      }
    }
    boolean bool1 = false;
    this.aRK.clear();
    l[] arrayOfl1 = new l[paramArrayOff.length];
    l[] arrayOfl2 = new l[paramArrayOff.length];
    com.google.android.exoplayer2.g.f[] arrayOff = new com.google.android.exoplayer2.g.f[paramArrayOff.length];
    int m = 0;
    j[] arrayOfj = new j[this.aRN.length];
    int k = 0;
    label230:
    j localj;
    label275:
    com.google.android.exoplayer2.g.f localf;
    label389:
    label392:
    label409:
    Object localObject2;
    int n;
    if (k < this.aRN.length)
    {
      i = 0;
      if (i < paramArrayOff.length)
      {
        if (arrayOfInt1[i] == k)
        {
          localObject1 = paramArrayOfl[i];
          arrayOfl2[i] = localObject1;
          if (arrayOfInt2[i] != k) {
            break label275;
          }
        }
        for (localObject1 = paramArrayOff[i];; localObject1 = null)
        {
          arrayOff[i] = localObject1;
          i += 1;
          break;
          localObject1 = null;
          break label230;
        }
      }
      localj = this.aRN[k];
      com.google.android.exoplayer2.i.a.checkState(localj.prepared);
      j = localj.aPA;
      i = 0;
      while (i < arrayOff.length)
      {
        if ((arrayOfl2[i] != null) && ((arrayOff[i] == null) || (paramArrayOfBoolean1[i] == 0)))
        {
          localj.o(((i)arrayOfl2[i]).aRS, false);
          arrayOfl2[i] = null;
        }
        i += 1;
      }
      if (!bool1)
      {
        if (localj.aPy) {
          if (j != 0) {
            break label588;
          }
        }
      }
      else
      {
        i = 1;
        localf = localj.aRV.aRi;
        j = 0;
        localObject1 = localf;
        if (j >= arrayOff.length) {
          break label600;
        }
        localObject2 = localObject1;
        if (arrayOfl2[j] != null) {
          break label1167;
        }
        localObject2 = localObject1;
        if (arrayOff[j] == null) {
          break label1167;
        }
        localObject2 = arrayOff[j];
        n = localj.avL.a(((com.google.android.exoplayer2.g.f)localObject2).qg());
        localj.o(n, true);
        if (n == localj.aSb)
        {
          localj.aRV.aRi = ((com.google.android.exoplayer2.g.f)localObject2);
          localObject1 = localObject2;
        }
        arrayOfl2[j] = new i(localj, n);
        paramArrayOfBoolean2[j] = true;
        localObject2 = localObject1;
        if (i != 0) {
          break label1167;
        }
        localObject2 = localj.aPv[n];
        ((com.google.android.exoplayer2.source.k)localObject2).rewind();
        if ((((com.google.android.exoplayer2.source.k)localObject2).g(paramLong, true)) || (((com.google.android.exoplayer2.source.k)localObject2).aQn.pk() == 0)) {
          break label594;
        }
        i = 1;
      }
    }
    for (;;)
    {
      j += 1;
      break label409;
      if (paramLong != localj.aPG) {
        break label389;
      }
      label588:
      i = 0;
      break label392;
      label594:
      i = 0;
      continue;
      label600:
      boolean bool2;
      label693:
      label733:
      int i1;
      if (localj.aPA == 0)
      {
        localj.aRV.aRd = null;
        localj.aRZ = null;
        localj.aRY.clear();
        if (localj.aPp.isLoading())
        {
          localObject1 = localj.aPv;
          n = localObject1.length;
          j = 0;
          while (j < n)
          {
            localObject1[j].pr();
            j += 1;
          }
          localj.aPp.cancelLoading();
        }
        for (j = i;; j = i)
        {
          localj.aPy = true;
          n = 0;
          i = 0;
          for (;;)
          {
            if (i >= paramArrayOff.length) {
              break label1002;
            }
            if (arrayOfInt2[i] != k) {
              break label959;
            }
            if (arrayOfl2[i] == null) {
              break;
            }
            bool2 = true;
            com.google.android.exoplayer2.i.a.checkState(bool2);
            arrayOfl1[i] = arrayOfl2[i];
            i1 = 1;
            this.aRK.put(arrayOfl2[i], Integer.valueOf(k));
            label769:
            i += 1;
            n = i1;
          }
          localj.pB();
        }
      }
      if ((!localj.aRY.isEmpty()) && (!x.e(localObject1, localf))) {
        if (!localj.aPy)
        {
          ((com.google.android.exoplayer2.g.f)localObject1).Y(0L);
          j = localj.aRV.aQZ.j(((f)localj.aRY.getLast()).aQJ);
          if (((com.google.android.exoplayer2.g.f)localObject1).qi() == j) {
            break label1161;
          }
          j = 1;
        }
      }
      for (;;)
      {
        label873:
        if (j != 0)
        {
          bool2 = true;
          i = 1;
          localj.aSf = true;
        }
        for (;;)
        {
          j = i;
          if (i == 0) {
            break label693;
          }
          localj.j(paramLong, bool2);
          n = 0;
          for (;;)
          {
            j = i;
            if (n >= arrayOfl2.length) {
              break;
            }
            if (arrayOfl2[n] != null) {
              paramArrayOfBoolean2[n] = true;
            }
            n += 1;
          }
          j = 1;
          break label873;
          bool2 = false;
          break label733;
          label959:
          i1 = n;
          if (arrayOfInt1[i] != k) {
            break label769;
          }
          if (arrayOfl2[i] == null) {}
          for (bool2 = true;; bool2 = false)
          {
            com.google.android.exoplayer2.i.a.checkState(bool2);
            i1 = n;
            break;
          }
          label1002:
          i = m;
          bool2 = bool1;
          if (n != 0)
          {
            arrayOfj[m] = localj;
            i = m + 1;
            if (m != 0) {
              break label1093;
            }
            localj.aH(true);
            if ((j == 0) && (this.aRO.length != 0) && (localj == this.aRO[0])) {
              break label1099;
            }
            this.aQW.aSh.clear();
          }
          label1093:
          label1099:
          for (bool2 = true;; bool2 = bool1)
          {
            k += 1;
            m = i;
            bool1 = bool2;
            break;
            localj.aH(false);
          }
          System.arraycopy(arrayOfl1, 0, paramArrayOfl, 0, arrayOfl1.length);
          this.aRO = ((j[])Arrays.copyOf(arrayOfj, m));
          this.aRP = new com.google.android.exoplayer2.source.e(this.aRO);
          AppMethodBeat.o(125913);
          return paramLong;
          bool2 = bool1;
        }
        label1161:
        j = 0;
      }
      label1167:
      localObject1 = localObject2;
    }
  }
  
  public final void a(com.google.android.exoplayer2.source.b.a.a.a parama)
  {
    AppMethodBeat.i(125920);
    ((e.a)this.aQY.aTj.get(parama)).pE();
    AppMethodBeat.o(125920);
  }
  
  public final void a(h.a parama, long paramLong)
  {
    AppMethodBeat.i(125911);
    this.aOX = parama;
    this.aQY.aTm.add(this);
    Object localObject2 = this.aQY.aRo;
    parama = new ArrayList(((com.google.android.exoplayer2.source.b.a.a)localObject2).aSm);
    Object localObject1 = new ArrayList();
    Object localObject3 = new ArrayList();
    int i = 0;
    Object localObject4;
    if (i < parama.size())
    {
      localObject4 = (com.google.android.exoplayer2.source.b.a.a.a)parama.get(i);
      if ((((com.google.android.exoplayer2.source.b.a.a.a)localObject4).axd.height > 0) || (a((com.google.android.exoplayer2.source.b.a.a.a)localObject4, "avc"))) {
        ((ArrayList)localObject1).add(localObject4);
      }
      for (;;)
      {
        i += 1;
        break;
        if (a((com.google.android.exoplayer2.source.b.a.a.a)localObject4, "mp4a")) {
          ((ArrayList)localObject3).add(localObject4);
        }
      }
    }
    if (!((ArrayList)localObject1).isEmpty())
    {
      parama = (h.a)localObject1;
      localObject3 = ((com.google.android.exoplayer2.source.b.a.a)localObject2).aSn;
      localObject1 = ((com.google.android.exoplayer2.source.b.a.a)localObject2).aSo;
      this.aRN = new j[((List)localObject3).size() + 1 + ((List)localObject1).size()];
      this.aRM = this.aRN.length;
      if (parama.isEmpty()) {
        break label390;
      }
    }
    label390:
    for (boolean bool = true;; bool = false)
    {
      com.google.android.exoplayer2.i.a.checkArgument(bool);
      localObject4 = new com.google.android.exoplayer2.source.b.a.a.a[parama.size()];
      parama.toArray((Object[])localObject4);
      parama = a(0, (com.google.android.exoplayer2.source.b.a.a.a[])localObject4, ((com.google.android.exoplayer2.source.b.a.a)localObject2).aRW, ((com.google.android.exoplayer2.source.b.a.a)localObject2).aRa, paramLong);
      this.aRN[0] = parama;
      parama.aH(true);
      parama.pA();
      i = 1;
      j = 0;
      while (j < ((List)localObject3).size())
      {
        parama = (com.google.android.exoplayer2.source.b.a.a.a)((List)localObject3).get(j);
        localObject2 = Collections.emptyList();
        parama = a(1, new com.google.android.exoplayer2.source.b.a.a.a[] { parama }, null, (List)localObject2, paramLong);
        this.aRN[i] = parama;
        parama.pA();
        i += 1;
        j += 1;
      }
      if (((ArrayList)localObject3).size() < parama.size()) {
        parama.removeAll((Collection)localObject3);
      }
      break;
    }
    int j = 0;
    while (j < ((List)localObject1).size())
    {
      parama = (com.google.android.exoplayer2.source.b.a.a.a)((List)localObject1).get(j);
      localObject2 = Collections.emptyList();
      localObject2 = a(3, new com.google.android.exoplayer2.source.b.a.a.a[] { parama }, null, (List)localObject2, paramLong);
      parama = parama.axd;
      ((j)localObject2).dS(0).f(parama);
      ((j)localObject2).aPx = true;
      ((j)localObject2).pC();
      this.aRN[i] = localObject2;
      i += 1;
      j += 1;
    }
    this.aRO = this.aRN;
    AppMethodBeat.o(125911);
  }
  
  public final void b(com.google.android.exoplayer2.source.b.a.a.a parama)
  {
    AppMethodBeat.i(125922);
    j[] arrayOfj = this.aRN;
    int j = arrayOfj.length;
    int i = 0;
    while (i < j)
    {
      c localc = arrayOfj[i].aRV;
      int k = localc.aQZ.j(parama.axd);
      if (k != -1)
      {
        k = localc.aRi.indexOf(k);
        if (k != -1) {
          localc.aRi.ei(k);
        }
      }
      i += 1;
    }
    pz();
    AppMethodBeat.o(125922);
  }
  
  public final void mG()
  {
    AppMethodBeat.i(125919);
    int i = this.aRM - 1;
    this.aRM = i;
    if (i > 0)
    {
      AppMethodBeat.o(125919);
      return;
    }
    Object localObject = this.aRN;
    int k = localObject.length;
    i = 0;
    int j = 0;
    while (i < k)
    {
      j += localObject[i].avL.length;
      i += 1;
    }
    localObject = new o[j];
    j[] arrayOfj = this.aRN;
    int m = arrayOfj.length;
    j = 0;
    i = 0;
    while (i < m)
    {
      j localj = arrayOfj[i];
      int n = localj.avL.length;
      k = 0;
      while (k < n)
      {
        localObject[j] = localj.avL.aQH[k];
        k += 1;
        j += 1;
      }
      i += 1;
    }
    this.avL = new p((o[])localObject);
    this.aOX.a(this);
    AppMethodBeat.o(125919);
  }
  
  public final void oS()
  {
    AppMethodBeat.i(125912);
    j[] arrayOfj = this.aRN;
    int j = arrayOfj.length;
    int i = 0;
    while (i < j)
    {
      arrayOfj[i].aRV.oX();
      i += 1;
    }
    AppMethodBeat.o(125912);
  }
  
  public final p oT()
  {
    return this.avL;
  }
  
  public final long oU()
  {
    return -9223372036854775807L;
  }
  
  public final long oV()
  {
    AppMethodBeat.i(125917);
    long l = this.aRP.oV();
    AppMethodBeat.o(125917);
    return l;
  }
  
  public final long oW()
  {
    AppMethodBeat.i(125916);
    long l = this.aRP.oW();
    AppMethodBeat.o(125916);
    return l;
  }
  
  public final void py()
  {
    AppMethodBeat.i(125921);
    pz();
    AppMethodBeat.o(125921);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.google.android.exoplayer2.source.b.g
 * JD-Core Version:    0.7.0.1
 */