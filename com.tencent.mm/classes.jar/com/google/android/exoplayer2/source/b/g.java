package com.google.android.exoplayer2.source.b;

import android.os.Handler;
import android.text.TextUtils;
import android.util.SparseArray;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.h.b;
import com.google.android.exoplayer2.h.r;
import com.google.android.exoplayer2.i.t;
import com.google.android.exoplayer2.source.b.a.e.b;
import com.google.android.exoplayer2.source.h;
import com.google.android.exoplayer2.source.l;
import com.google.android.exoplayer2.source.m;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.LinkedList;
import java.util.List;

public final class g
  implements e.b, j.a, com.google.android.exoplayer2.source.e
{
  private final b aIC;
  private com.google.android.exoplayer2.source.e.a aId;
  private final k aJq;
  final com.google.android.exoplayer2.source.b.a.e aJs;
  private final d aKd;
  private final int aKe;
  private final com.google.android.exoplayer2.source.a.a aKf;
  private final IdentityHashMap<com.google.android.exoplayer2.source.i, Integer> aKg;
  final Handler aKh;
  private int aKi;
  j[] aKj;
  private j[] aKk;
  private com.google.android.exoplayer2.source.d aKl;
  private m att;
  
  public g(com.google.android.exoplayer2.source.b.a.e parame, d paramd, int paramInt, com.google.android.exoplayer2.source.a.a parama, b paramb)
  {
    this.aJs = parame;
    this.aKd = paramd;
    this.aKe = paramInt;
    this.aKf = parama;
    this.aIC = paramb;
    this.aKg = new IdentityHashMap();
    this.aJq = new k();
    this.aKh = new Handler();
    this.aKj = new j[0];
    this.aKk = new j[0];
  }
  
  private j a(int paramInt, com.google.android.exoplayer2.source.b.a.a.a[] paramArrayOfa, Format paramFormat, List<Format> paramList, long paramLong)
  {
    return new j(paramInt, this, new c(this.aJs, paramArrayOfa, this.aKd, this.aJq, paramList), this.aIC, paramLong, paramFormat, this.aKe, this.aKf);
  }
  
  private static boolean a(com.google.android.exoplayer2.source.b.a.a.a parama, String paramString)
  {
    parama = parama.auL.aup;
    if (TextUtils.isEmpty(parama)) {}
    for (;;)
    {
      return false;
      parama = parama.split("(\\s*,\\s*)|(\\s*$)");
      int j = parama.length;
      int i = 0;
      while (i < j)
      {
        if (parama[i].startsWith(paramString)) {
          return true;
        }
        i += 1;
      }
    }
  }
  
  private void na()
  {
    if (this.att != null) {
      this.aId.a(this);
    }
    for (;;)
    {
      return;
      j[] arrayOfj = this.aKj;
      int j = arrayOfj.length;
      int i = 0;
      while (i < j)
      {
        arrayOfj[i].nb();
        i += 1;
      }
    }
  }
  
  public final void H(long paramLong)
  {
    j[] arrayOfj = this.aKk;
    int k = arrayOfj.length;
    int i = 0;
    while (i < k)
    {
      j localj = arrayOfj[i];
      int m = localj.aKx.length;
      int j = 0;
      while (j < m)
      {
        h localh = localj.aKx[j];
        int n = localj.aKF[j];
        localh.O(localh.aIE.f(paramLong, n));
        j += 1;
      }
      i += 1;
    }
  }
  
  public final long I(long paramLong)
  {
    if (this.aKk.length > 0)
    {
      boolean bool = this.aKk[0].g(paramLong, false);
      int i = 1;
      while (i < this.aKk.length)
      {
        this.aKk[i].g(paramLong, bool);
        i += 1;
      }
      if (bool) {
        this.aJq.aKN.clear();
      }
    }
    return paramLong;
  }
  
  public final boolean J(long paramLong)
  {
    return this.aKl.J(paramLong);
  }
  
  public final long a(com.google.android.exoplayer2.g.e[] paramArrayOfe, boolean[] paramArrayOfBoolean1, com.google.android.exoplayer2.source.i[] paramArrayOfi, boolean[] paramArrayOfBoolean2, long paramLong)
  {
    int[] arrayOfInt1 = new int[paramArrayOfe.length];
    int[] arrayOfInt2 = new int[paramArrayOfe.length];
    int i = 0;
    int j;
    label32:
    Object localObject1;
    if (i < paramArrayOfe.length)
    {
      if (paramArrayOfi[i] == null)
      {
        j = -1;
        arrayOfInt1[i] = j;
        arrayOfInt2[i] = -1;
        if (paramArrayOfe[i] != null)
        {
          localObject1 = paramArrayOfe[i].nH();
          j = 0;
        }
      }
      for (;;)
      {
        if (j < this.aKj.length)
        {
          if (this.aKj[j].att.a((l)localObject1) != -1) {
            arrayOfInt2[i] = j;
          }
        }
        else
        {
          i += 1;
          break;
          j = ((Integer)this.aKg.get(paramArrayOfi[i])).intValue();
          break label32;
        }
        j += 1;
      }
    }
    boolean bool1 = false;
    this.aKg.clear();
    com.google.android.exoplayer2.source.i[] arrayOfi1 = new com.google.android.exoplayer2.source.i[paramArrayOfe.length];
    com.google.android.exoplayer2.source.i[] arrayOfi2 = new com.google.android.exoplayer2.source.i[paramArrayOfe.length];
    com.google.android.exoplayer2.g.e[] arrayOfe = new com.google.android.exoplayer2.g.e[paramArrayOfe.length];
    int m = 0;
    j[] arrayOfj = new j[this.aKj.length];
    int k = 0;
    label225:
    j localj;
    label270:
    com.google.android.exoplayer2.g.e locale;
    label384:
    label387:
    label404:
    Object localObject2;
    int n;
    if (k < this.aKj.length)
    {
      i = 0;
      if (i < paramArrayOfe.length)
      {
        if (arrayOfInt1[i] == k)
        {
          localObject1 = paramArrayOfi[i];
          arrayOfi2[i] = localObject1;
          if (arrayOfInt2[i] != k) {
            break label270;
          }
        }
        for (localObject1 = paramArrayOfe[i];; localObject1 = null)
        {
          arrayOfe[i] = localObject1;
          i += 1;
          break;
          localObject1 = null;
          break label225;
        }
      }
      localj = this.aKj[k];
      com.google.android.exoplayer2.i.a.aC(localj.prepared);
      j = localj.aKA;
      i = 0;
      while (i < arrayOfe.length)
      {
        if ((arrayOfi2[i] != null) && ((arrayOfe[i] == null) || (paramArrayOfBoolean1[i] == 0)))
        {
          localj.r(((i)arrayOfi2[i]).group, false);
          arrayOfi2[i] = null;
        }
        i += 1;
      }
      if (!bool1)
      {
        if (localj.aKK) {
          if (j != 0) {
            break label597;
          }
        }
      }
      else
      {
        i = 1;
        locale = localj.aKr.aJC;
        j = 0;
        localObject1 = locale;
        if (j >= arrayOfe.length) {
          break label609;
        }
        localObject2 = localObject1;
        if (arrayOfi2[j] != null) {
          break label1170;
        }
        localObject2 = localObject1;
        if (arrayOfe[j] == null) {
          break label1170;
        }
        localObject2 = arrayOfe[j];
        n = localj.att.a(((com.google.android.exoplayer2.g.e)localObject2).nH());
        localj.r(n, true);
        if (n == localj.aKD)
        {
          localj.aKr.aJC = ((com.google.android.exoplayer2.g.e)localObject2);
          localObject1 = localObject2;
        }
        arrayOfi2[j] = new i(localj, n);
        paramArrayOfBoolean2[j] = true;
        localObject2 = localObject1;
        if (i != 0) {
          break label1170;
        }
        localObject2 = localj.aKx[n];
        ((h)localObject2).rewind();
        if (((h)localObject2).e(paramLong, true)) {
          break label603;
        }
        localObject2 = ((h)localObject2).aIE;
        i = ((com.google.android.exoplayer2.source.g)localObject2).aIt;
        if (((com.google.android.exoplayer2.source.g)localObject2).aIv + i == 0) {
          break label603;
        }
        i = 1;
      }
    }
    for (;;)
    {
      j += 1;
      break label404;
      if (paramLong != localj.aKH) {
        break label384;
      }
      label597:
      i = 0;
      break label387;
      label603:
      i = 0;
      continue;
      label609:
      boolean bool2;
      label702:
      label742:
      int i1;
      if (localj.aKA == 0)
      {
        localj.aKr.aJx = null;
        localj.aKB = null;
        localj.aKv.clear();
        if (localj.aKt.isLoading())
        {
          localObject1 = localj.aKx;
          n = localObject1.length;
          j = 0;
          while (j < n)
          {
            localObject1[j].mN();
            j += 1;
          }
          localj.aKt.cancelLoading();
        }
        for (j = i;; j = i)
        {
          localj.aKK = true;
          n = 0;
          i = 0;
          for (;;)
          {
            if (i >= paramArrayOfe.length) {
              break label1010;
            }
            if (arrayOfInt2[i] != k) {
              break label967;
            }
            if (arrayOfi2[i] == null) {
              break;
            }
            bool2 = true;
            com.google.android.exoplayer2.i.a.aC(bool2);
            arrayOfi1[i] = arrayOfi2[i];
            i1 = 1;
            this.aKg.put(arrayOfi2[i], Integer.valueOf(k));
            label778:
            i += 1;
            n = i1;
          }
          localj.nd();
        }
      }
      if ((!localj.aKv.isEmpty()) && (!t.e(localObject1, locale))) {
        if (!localj.aKK)
        {
          ((com.google.android.exoplayer2.g.e)localObject1).mV();
          j = localj.aKr.aJt.j(((f)localj.aKv.getLast()).aJb);
          if (((com.google.android.exoplayer2.g.e)localObject1).nJ() == j) {
            break label1164;
          }
          j = 1;
        }
      }
      for (;;)
      {
        label881:
        if (j != 0)
        {
          bool2 = true;
          i = 1;
          localj.aKJ = true;
        }
        for (;;)
        {
          j = i;
          if (i == 0) {
            break label702;
          }
          localj.g(paramLong, bool2);
          n = 0;
          for (;;)
          {
            j = i;
            if (n >= arrayOfi2.length) {
              break;
            }
            if (arrayOfi2[n] != null) {
              paramArrayOfBoolean2[n] = true;
            }
            n += 1;
          }
          j = 1;
          break label881;
          bool2 = false;
          break label742;
          label967:
          i1 = n;
          if (arrayOfInt1[i] != k) {
            break label778;
          }
          if (arrayOfi2[i] == null) {}
          for (bool2 = true;; bool2 = false)
          {
            com.google.android.exoplayer2.i.a.aC(bool2);
            i1 = n;
            break;
          }
          label1010:
          i = m;
          bool2 = bool1;
          if (n != 0)
          {
            arrayOfj[m] = localj;
            i = m + 1;
            if (m != 0) {
              break label1101;
            }
            localj.ay(true);
            if ((j == 0) && (this.aKk.length != 0) && (localj == this.aKk[0])) {
              break label1107;
            }
            this.aJq.aKN.clear();
          }
          label1101:
          label1107:
          for (bool2 = true;; bool2 = bool1)
          {
            k += 1;
            m = i;
            bool1 = bool2;
            break;
            localj.ay(false);
          }
          System.arraycopy(arrayOfi1, 0, paramArrayOfi, 0, arrayOfi1.length);
          this.aKk = ((j[])Arrays.copyOf(arrayOfj, m));
          this.aKl = new com.google.android.exoplayer2.source.d(this.aKk);
          return paramLong;
          bool2 = bool1;
        }
        label1164:
        j = 0;
      }
      label1170:
      localObject1 = localObject2;
    }
  }
  
  public final void a(com.google.android.exoplayer2.source.b.a.a.a parama)
  {
    ((com.google.android.exoplayer2.source.b.a.e.a)this.aJs.aLP.get(parama)).nh();
  }
  
  public final void a(com.google.android.exoplayer2.source.e.a parama, long paramLong)
  {
    this.aId = parama;
    this.aJs.aLS.add(this);
    Object localObject2 = this.aJs.aJI;
    parama = new ArrayList(((com.google.android.exoplayer2.source.b.a.a)localObject2).aKS);
    Object localObject1 = new ArrayList();
    Object localObject3 = new ArrayList();
    int i = 0;
    Object localObject4;
    if (i < parama.size())
    {
      localObject4 = (com.google.android.exoplayer2.source.b.a.a.a)parama.get(i);
      if ((((com.google.android.exoplayer2.source.b.a.a.a)localObject4).auL.height > 0) || (a((com.google.android.exoplayer2.source.b.a.a.a)localObject4, "avc"))) {
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
      parama = (com.google.android.exoplayer2.source.e.a)localObject1;
      localObject3 = ((com.google.android.exoplayer2.source.b.a.a)localObject2).aKT;
      localObject1 = ((com.google.android.exoplayer2.source.b.a.a)localObject2).aKU;
      this.aKj = new j[((List)localObject3).size() + 1 + ((List)localObject1).size()];
      this.aKi = this.aKj.length;
      if (parama.isEmpty()) {
        break label384;
      }
    }
    label384:
    for (boolean bool = true;; bool = false)
    {
      com.google.android.exoplayer2.i.a.aB(bool);
      localObject4 = new com.google.android.exoplayer2.source.b.a.a.a[parama.size()];
      parama.toArray((Object[])localObject4);
      parama = a(0, (com.google.android.exoplayer2.source.b.a.a.a[])localObject4, ((com.google.android.exoplayer2.source.b.a.a)localObject2).aKs, ((com.google.android.exoplayer2.source.b.a.a)localObject2).aJu, paramLong);
      this.aKj[0] = parama;
      parama.ay(true);
      parama.nb();
      i = 1;
      j = 0;
      while (j < ((List)localObject3).size())
      {
        parama = (com.google.android.exoplayer2.source.b.a.a.a)((List)localObject3).get(j);
        localObject2 = Collections.emptyList();
        parama = a(1, new com.google.android.exoplayer2.source.b.a.a.a[] { parama }, null, (List)localObject2, paramLong);
        this.aKj[i] = parama;
        parama.nb();
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
      parama = parama.auL;
      ((j)localObject2).dm(0).f(parama);
      ((j)localObject2).aKz = true;
      ((j)localObject2).ne();
      this.aKj[i] = localObject2;
      i += 1;
      j += 1;
    }
    this.aKk = this.aKj;
  }
  
  public final void b(com.google.android.exoplayer2.source.b.a.a.a parama)
  {
    j[] arrayOfj = this.aKj;
    int j = arrayOfj.length;
    int i = 0;
    while (i < j)
    {
      c localc = arrayOfj[i].aKr;
      int k = localc.aJt.j(parama.auL);
      if (k != -1)
      {
        k = localc.aJC.indexOf(k);
        if (k != -1) {
          localc.aJC.dv(k);
        }
      }
      i += 1;
    }
    na();
  }
  
  public final void kA()
  {
    int i = this.aKi - 1;
    this.aKi = i;
    if (i > 0) {
      return;
    }
    Object localObject = this.aKj;
    int k = localObject.length;
    i = 0;
    int j = 0;
    while (i < k)
    {
      j += localObject[i].att.length;
      i += 1;
    }
    localObject = new l[j];
    j[] arrayOfj = this.aKj;
    int m = arrayOfj.length;
    j = 0;
    i = 0;
    while (i < m)
    {
      j localj = arrayOfj[i];
      int n = localj.att.length;
      k = 0;
      while (k < n)
      {
        localObject[j] = localj.att.aIZ[k];
        k += 1;
        j += 1;
      }
      i += 1;
    }
    this.att = new m((l[])localObject);
    this.aId.a(this);
  }
  
  public final long mA()
  {
    return -9223372036854775807L;
  }
  
  public final long mB()
  {
    return this.aKl.mB();
  }
  
  public final long mC()
  {
    return this.aKl.mC();
  }
  
  public final void mZ()
  {
    na();
  }
  
  public final void my()
  {
    j[] arrayOfj = this.aKj;
    int j = arrayOfj.length;
    int i = 0;
    while (i < j)
    {
      arrayOfj[i].mD();
      i += 1;
    }
  }
  
  public final m mz()
  {
    return this.att;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.google.android.exoplayer2.source.b.g
 * JD-Core Version:    0.7.0.1
 */