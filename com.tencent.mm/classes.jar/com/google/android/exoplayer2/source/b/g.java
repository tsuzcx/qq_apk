package com.google.android.exoplayer2.source.b;

import android.os.Handler;
import android.text.TextUtils;
import android.util.SparseArray;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.h.b;
import com.google.android.exoplayer2.h.t;
import com.google.android.exoplayer2.i.x;
import com.google.android.exoplayer2.source.b.a;
import com.google.android.exoplayer2.source.b.a.a.a;
import com.google.android.exoplayer2.source.b.a.e;
import com.google.android.exoplayer2.source.b.a.e.a;
import com.google.android.exoplayer2.source.b.a.e.b;
import com.google.android.exoplayer2.source.l;
import com.google.android.exoplayer2.source.m;
import com.google.android.exoplayer2.source.n;
import com.google.android.exoplayer2.source.q;
import com.google.android.exoplayer2.source.r;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.LinkedList;
import java.util.List;

public final class g
  implements e.b, j.a, com.google.android.exoplayer2.source.j
{
  private r bcq;
  private final int bvE;
  private final b bvH;
  private com.google.android.exoplayer2.source.j.a bvs;
  private final k bxx;
  final e bxz;
  private final d byk;
  private final b.a byl;
  private final IdentityHashMap<n, Integer> bym;
  final Handler byn;
  private int byo;
  j[] byp;
  private j[] byq;
  private com.google.android.exoplayer2.source.f byr;
  
  public g(e parame, d paramd, int paramInt, b.a parama, b paramb)
  {
    AppMethodBeat.i(62834);
    this.bxz = parame;
    this.byk = paramd;
    this.bvE = paramInt;
    this.byl = parama;
    this.bvH = paramb;
    this.bym = new IdentityHashMap();
    this.bxx = new k();
    this.byn = new Handler();
    this.byp = new j[0];
    this.byq = new j[0];
    AppMethodBeat.o(62834);
  }
  
  private j a(int paramInt, a.a[] paramArrayOfa, Format paramFormat, List<Format> paramList, long paramLong)
  {
    AppMethodBeat.i(62847);
    paramArrayOfa = new j(paramInt, this, new c(this.bxz, paramArrayOfa, this.byk, this.bxx, paramList), this.bvH, paramLong, paramFormat, this.bvE, this.byl);
    AppMethodBeat.o(62847);
    return paramArrayOfa;
  }
  
  private static boolean a(a.a parama, String paramString)
  {
    AppMethodBeat.i(62849);
    parama = parama.bdF.bdn;
    if (TextUtils.isEmpty(parama))
    {
      AppMethodBeat.o(62849);
      return false;
    }
    parama = parama.split("(\\s*,\\s*)|(\\s*$)");
    int j = parama.length;
    int i = 0;
    while (i < j)
    {
      if (parama[i].startsWith(paramString))
      {
        AppMethodBeat.o(62849);
        return true;
      }
      i += 1;
    }
    AppMethodBeat.o(62849);
    return false;
  }
  
  private void vS()
  {
    AppMethodBeat.i(62848);
    if (this.bcq != null)
    {
      this.bvs.a(this);
      AppMethodBeat.o(62848);
      return;
    }
    j[] arrayOfj = this.byp;
    int j = arrayOfj.length;
    int i = 0;
    while (i < j)
    {
      arrayOfj[i].vT();
      i += 1;
    }
    AppMethodBeat.o(62848);
  }
  
  public final void V(long paramLong)
  {
    AppMethodBeat.i(62838);
    j[] arrayOfj = this.byq;
    int k = arrayOfj.length;
    int i = 0;
    while (i < k)
    {
      j localj = arrayOfj[i];
      int m = localj.bvQ.length;
      int j = 0;
      while (j < m)
      {
        localj.bvQ[j].h(paramLong, localj.byF[j]);
        j += 1;
      }
      i += 1;
    }
    AppMethodBeat.o(62838);
  }
  
  public final long W(long paramLong)
  {
    AppMethodBeat.i(62842);
    if (this.byq.length > 0)
    {
      boolean bool = this.byq[0].i(paramLong, false);
      int i = 1;
      while (i < this.byq.length)
      {
        this.byq[i].i(paramLong, bool);
        i += 1;
      }
      if (bool) {
        this.bxx.byJ.clear();
      }
    }
    AppMethodBeat.o(62842);
    return paramLong;
  }
  
  public final boolean X(long paramLong)
  {
    AppMethodBeat.i(62839);
    boolean bool = this.byr.X(paramLong);
    AppMethodBeat.o(62839);
    return bool;
  }
  
  public final long a(com.google.android.exoplayer2.g.f[] paramArrayOff, boolean[] paramArrayOfBoolean1, n[] paramArrayOfn, boolean[] paramArrayOfBoolean2, long paramLong)
  {
    AppMethodBeat.i(62837);
    int[] arrayOfInt1 = new int[paramArrayOff.length];
    int[] arrayOfInt2 = new int[paramArrayOff.length];
    int i = 0;
    int j;
    label37:
    Object localObject1;
    if (i < paramArrayOff.length)
    {
      if (paramArrayOfn[i] == null)
      {
        j = -1;
        arrayOfInt1[i] = j;
        arrayOfInt2[i] = -1;
        if (paramArrayOff[i] != null)
        {
          localObject1 = paramArrayOff[i].wy();
          j = 0;
        }
      }
      for (;;)
      {
        if (j < this.byp.length)
        {
          if (this.byp[j].bcq.a((q)localObject1) != -1) {
            arrayOfInt2[i] = j;
          }
        }
        else
        {
          i += 1;
          break;
          j = ((Integer)this.bym.get(paramArrayOfn[i])).intValue();
          break label37;
        }
        j += 1;
      }
    }
    boolean bool1 = false;
    this.bym.clear();
    n[] arrayOfn1 = new n[paramArrayOff.length];
    n[] arrayOfn2 = new n[paramArrayOff.length];
    com.google.android.exoplayer2.g.f[] arrayOff = new com.google.android.exoplayer2.g.f[paramArrayOff.length];
    int m = 0;
    j[] arrayOfj = new j[this.byp.length];
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
    if (k < this.byp.length)
    {
      i = 0;
      if (i < paramArrayOff.length)
      {
        if (arrayOfInt1[i] == k)
        {
          localObject1 = paramArrayOfn[i];
          arrayOfn2[i] = localObject1;
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
      localj = this.byp[k];
      com.google.android.exoplayer2.i.a.checkState(localj.bcY);
      j = localj.bvV;
      i = 0;
      while (i < arrayOff.length)
      {
        if ((arrayOfn2[i] != null) && ((arrayOff[i] == null) || (paramArrayOfBoolean1[i] == 0)))
        {
          localj.p(((i)arrayOfn2[i]).byu, false);
          arrayOfn2[i] = null;
        }
        i += 1;
      }
      if (!bool1)
      {
        if (localj.bvT) {
          if (j != 0) {
            break label588;
          }
        }
      }
      else
      {
        i = 1;
        localf = localj.byx.bxJ;
        j = 0;
        localObject1 = localf;
        if (j >= arrayOff.length) {
          break label600;
        }
        localObject2 = localObject1;
        if (arrayOfn2[j] != null) {
          break label1167;
        }
        localObject2 = localObject1;
        if (arrayOff[j] == null) {
          break label1167;
        }
        localObject2 = arrayOff[j];
        n = localj.bcq.a(((com.google.android.exoplayer2.g.f)localObject2).wy());
        localj.p(n, true);
        if (n == localj.byD)
        {
          localj.byx.bxJ = ((com.google.android.exoplayer2.g.f)localObject2);
          localObject1 = localObject2;
        }
        arrayOfn2[j] = new i(localj, n);
        paramArrayOfBoolean2[j] = true;
        localObject2 = localObject1;
        if (i != 0) {
          break label1167;
        }
        localObject2 = localj.bvQ[n];
        ((m)localObject2).rewind();
        if ((((m)localObject2).f(paramLong, true)) || (((m)localObject2).bwO.vE() == 0)) {
          break label594;
        }
        i = 1;
      }
    }
    for (;;)
    {
      j += 1;
      break label409;
      if (paramLong != localj.bwa) {
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
      if (localj.bvV == 0)
      {
        localj.byx.bxE = null;
        localj.byB = null;
        localj.byA.clear();
        if (localj.bvK.isLoading())
        {
          localObject1 = localj.bvQ;
          n = localObject1.length;
          j = 0;
          while (j < n)
          {
            localObject1[j].vL();
            j += 1;
          }
          localj.bvK.cancelLoading();
        }
        for (j = i;; j = i)
        {
          localj.bvT = true;
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
            if (arrayOfn2[i] == null) {
              break;
            }
            bool2 = true;
            com.google.android.exoplayer2.i.a.checkState(bool2);
            arrayOfn1[i] = arrayOfn2[i];
            i1 = 1;
            this.bym.put(arrayOfn2[i], Integer.valueOf(k));
            label769:
            i += 1;
            n = i1;
          }
          localj.vU();
        }
      }
      if ((!localj.byA.isEmpty()) && (!x.j(localObject1, localf))) {
        if (!localj.bvT)
        {
          ((com.google.android.exoplayer2.g.f)localObject1).af(0L);
          j = localj.byx.bxA.j(((f)localj.byA.getLast()).bxk);
          if (((com.google.android.exoplayer2.g.f)localObject1).wA() == j) {
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
          localj.byH = true;
        }
        for (;;)
        {
          j = i;
          if (i == 0) {
            break label693;
          }
          localj.i(paramLong, bool2);
          n = 0;
          for (;;)
          {
            j = i;
            if (n >= arrayOfn2.length) {
              break;
            }
            if (arrayOfn2[n] != null) {
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
          if (arrayOfn2[i] == null) {}
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
            localj.aT(true);
            if ((j == 0) && (this.byq.length != 0) && (localj == this.byq[0])) {
              break label1099;
            }
            this.bxx.byJ.clear();
          }
          label1093:
          label1099:
          for (bool2 = true;; bool2 = bool1)
          {
            k += 1;
            m = i;
            bool1 = bool2;
            break;
            localj.aT(false);
          }
          System.arraycopy(arrayOfn1, 0, paramArrayOfn, 0, arrayOfn1.length);
          this.byq = ((j[])Arrays.copyOf(arrayOfj, m));
          this.byr = new com.google.android.exoplayer2.source.f(this.byq);
          AppMethodBeat.o(62837);
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
  
  public final void a(a.a parama)
  {
    AppMethodBeat.i(62844);
    ((e.a)this.bxz.bzJ.get(parama)).vX();
    AppMethodBeat.o(62844);
  }
  
  public final void a(com.google.android.exoplayer2.source.j.a parama, long paramLong)
  {
    AppMethodBeat.i(62835);
    this.bvs = parama;
    this.bxz.listeners.add(this);
    Object localObject2 = this.bxz.bxQ;
    parama = new ArrayList(((com.google.android.exoplayer2.source.b.a.a)localObject2).byO);
    Object localObject1 = new ArrayList();
    Object localObject3 = new ArrayList();
    int i = 0;
    Object localObject4;
    if (i < parama.size())
    {
      localObject4 = (a.a)parama.get(i);
      if ((((a.a)localObject4).bdF.height > 0) || (a((a.a)localObject4, "avc"))) {
        ((ArrayList)localObject1).add(localObject4);
      }
      for (;;)
      {
        i += 1;
        break;
        if (a((a.a)localObject4, "mp4a")) {
          ((ArrayList)localObject3).add(localObject4);
        }
      }
    }
    if (!((ArrayList)localObject1).isEmpty())
    {
      parama = (com.google.android.exoplayer2.source.j.a)localObject1;
      localObject3 = ((com.google.android.exoplayer2.source.b.a.a)localObject2).audios;
      localObject1 = ((com.google.android.exoplayer2.source.b.a.a)localObject2).byP;
      this.byp = new j[((List)localObject3).size() + 1 + ((List)localObject1).size()];
      this.byo = this.byp.length;
      if (parama.isEmpty()) {
        break label390;
      }
    }
    label390:
    for (boolean bool = true;; bool = false)
    {
      com.google.android.exoplayer2.i.a.checkArgument(bool);
      localObject4 = new a.a[parama.size()];
      parama.toArray((Object[])localObject4);
      parama = a(0, (a.a[])localObject4, ((com.google.android.exoplayer2.source.b.a.a)localObject2).byy, ((com.google.android.exoplayer2.source.b.a.a)localObject2).bxB, paramLong);
      this.byp[0] = parama;
      parama.aT(true);
      parama.vT();
      i = 1;
      j = 0;
      while (j < ((List)localObject3).size())
      {
        parama = (a.a)((List)localObject3).get(j);
        localObject2 = Collections.emptyList();
        parama = a(1, new a.a[] { parama }, null, (List)localObject2, paramLong);
        this.byp[i] = parama;
        parama.vT();
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
      parama = (a.a)((List)localObject1).get(j);
      localObject2 = Collections.emptyList();
      localObject2 = a(3, new a.a[] { parama }, null, (List)localObject2, paramLong);
      parama = parama.bdF;
      ((j)localObject2).eG(0).f(parama);
      ((j)localObject2).bvS = true;
      ((j)localObject2).vV();
      this.byp[i] = localObject2;
      i += 1;
      j += 1;
    }
    this.byq = this.byp;
    AppMethodBeat.o(62835);
  }
  
  public final void b(a.a parama)
  {
    AppMethodBeat.i(62846);
    j[] arrayOfj = this.byp;
    int j = arrayOfj.length;
    int i = 0;
    while (i < j)
    {
      c localc = arrayOfj[i].byx;
      int k = localc.bxA.j(parama.bdF);
      if (k != -1)
      {
        k = localc.bxJ.indexOf(k);
        if (k != -1) {
          localc.bxJ.k(k, 60000L);
        }
      }
      i += 1;
    }
    vS();
    AppMethodBeat.o(62846);
  }
  
  public final void tf()
  {
    AppMethodBeat.i(62843);
    int i = this.byo - 1;
    this.byo = i;
    if (i > 0)
    {
      AppMethodBeat.o(62843);
      return;
    }
    Object localObject = this.byp;
    int k = localObject.length;
    i = 0;
    int j = 0;
    while (i < k)
    {
      j += localObject[i].bcq.length;
      i += 1;
    }
    localObject = new q[j];
    j[] arrayOfj = this.byp;
    int m = arrayOfj.length;
    j = 0;
    i = 0;
    while (i < m)
    {
      j localj = arrayOfj[i];
      int n = localj.bcq.length;
      k = 0;
      while (k < n)
      {
        localObject[j] = localj.bcq.bxi[k];
        k += 1;
        j += 1;
      }
      i += 1;
    }
    this.bcq = new r((q[])localObject);
    this.bvs.a(this);
    AppMethodBeat.o(62843);
  }
  
  public final void vR()
  {
    AppMethodBeat.i(62845);
    vS();
    AppMethodBeat.o(62845);
  }
  
  public final void vn()
  {
    AppMethodBeat.i(62836);
    j[] arrayOfj = this.byp;
    int j = arrayOfj.length;
    int i = 0;
    while (i < j)
    {
      arrayOfj[i].byx.vs();
      i += 1;
    }
    AppMethodBeat.o(62836);
  }
  
  public final r vo()
  {
    return this.bcq;
  }
  
  public final long vp()
  {
    return -9223372036854775807L;
  }
  
  public final long vq()
  {
    AppMethodBeat.i(62841);
    long l = this.byr.vq();
    AppMethodBeat.o(62841);
    return l;
  }
  
  public final long vr()
  {
    AppMethodBeat.i(62840);
    long l = this.byr.vr();
    AppMethodBeat.o(62840);
    return l;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.google.android.exoplayer2.source.b.g
 * JD-Core Version:    0.7.0.1
 */