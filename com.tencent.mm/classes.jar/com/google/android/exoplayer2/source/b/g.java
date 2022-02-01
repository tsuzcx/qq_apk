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
  private p bct;
  private final int bvJ;
  private final b bvM;
  private h.a bvx;
  private final k bxw;
  final com.google.android.exoplayer2.source.b.a.e bxy;
  private final d byi;
  private final com.google.android.exoplayer2.source.a.a byj;
  private final IdentityHashMap<l, Integer> byk;
  final Handler byl;
  private int bym;
  j[] byn;
  private j[] byo;
  private com.google.android.exoplayer2.source.e byp;
  
  public g(com.google.android.exoplayer2.source.b.a.e parame, d paramd, int paramInt, com.google.android.exoplayer2.source.a.a parama, b paramb)
  {
    AppMethodBeat.i(62834);
    this.bxy = parame;
    this.byi = paramd;
    this.bvJ = paramInt;
    this.byj = parama;
    this.bvM = paramb;
    this.byk = new IdentityHashMap();
    this.bxw = new k();
    this.byl = new Handler();
    this.byn = new j[0];
    this.byo = new j[0];
    AppMethodBeat.o(62834);
  }
  
  private j a(int paramInt, com.google.android.exoplayer2.source.b.a.a.a[] paramArrayOfa, Format paramFormat, List<Format> paramList, long paramLong)
  {
    AppMethodBeat.i(62847);
    paramArrayOfa = new j(paramInt, this, new c(this.bxy, paramArrayOfa, this.byi, this.bxw, paramList), this.bvM, paramLong, paramFormat, this.bvJ, this.byj);
    AppMethodBeat.o(62847);
    return paramArrayOfa;
  }
  
  private static boolean a(com.google.android.exoplayer2.source.b.a.a.a parama, String paramString)
  {
    AppMethodBeat.i(62849);
    parama = parama.bdI.bdq;
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
  
  private void vN()
  {
    AppMethodBeat.i(62848);
    if (this.bct != null)
    {
      this.bvx.a(this);
      AppMethodBeat.o(62848);
      return;
    }
    j[] arrayOfj = this.byn;
    int j = arrayOfj.length;
    int i = 0;
    while (i < j)
    {
      arrayOfj[i].vO();
      i += 1;
    }
    AppMethodBeat.o(62848);
  }
  
  public final void V(long paramLong)
  {
    AppMethodBeat.i(62838);
    j[] arrayOfj = this.byo;
    int k = arrayOfj.length;
    int i = 0;
    while (i < k)
    {
      j localj = arrayOfj[i];
      int m = localj.bvV.length;
      int j = 0;
      while (j < m)
      {
        localj.bvV[j].h(paramLong, localj.byD[j]);
        j += 1;
      }
      i += 1;
    }
    AppMethodBeat.o(62838);
  }
  
  public final long W(long paramLong)
  {
    AppMethodBeat.i(62842);
    if (this.byo.length > 0)
    {
      boolean bool = this.byo[0].i(paramLong, false);
      int i = 1;
      while (i < this.byo.length)
      {
        this.byo[i].i(paramLong, bool);
        i += 1;
      }
      if (bool) {
        this.bxw.byH.clear();
      }
    }
    AppMethodBeat.o(62842);
    return paramLong;
  }
  
  public final boolean X(long paramLong)
  {
    AppMethodBeat.i(62839);
    boolean bool = this.byp.X(paramLong);
    AppMethodBeat.o(62839);
    return bool;
  }
  
  public final long a(com.google.android.exoplayer2.g.f[] paramArrayOff, boolean[] paramArrayOfBoolean1, l[] paramArrayOfl, boolean[] paramArrayOfBoolean2, long paramLong)
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
      if (paramArrayOfl[i] == null)
      {
        j = -1;
        arrayOfInt1[i] = j;
        arrayOfInt2[i] = -1;
        if (paramArrayOff[i] != null)
        {
          localObject1 = paramArrayOff[i].wt();
          j = 0;
        }
      }
      for (;;)
      {
        if (j < this.byn.length)
        {
          if (this.byn[j].bct.a((o)localObject1) != -1) {
            arrayOfInt2[i] = j;
          }
        }
        else
        {
          i += 1;
          break;
          j = ((Integer)this.byk.get(paramArrayOfl[i])).intValue();
          break label37;
        }
        j += 1;
      }
    }
    boolean bool1 = false;
    this.byk.clear();
    l[] arrayOfl1 = new l[paramArrayOff.length];
    l[] arrayOfl2 = new l[paramArrayOff.length];
    com.google.android.exoplayer2.g.f[] arrayOff = new com.google.android.exoplayer2.g.f[paramArrayOff.length];
    int m = 0;
    j[] arrayOfj = new j[this.byn.length];
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
    if (k < this.byn.length)
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
      localj = this.byn[k];
      com.google.android.exoplayer2.i.a.checkState(localj.bdb);
      j = localj.bwa;
      i = 0;
      while (i < arrayOff.length)
      {
        if ((arrayOfl2[i] != null) && ((arrayOff[i] == null) || (paramArrayOfBoolean1[i] == 0)))
        {
          localj.n(((i)arrayOfl2[i]).bys, false);
          arrayOfl2[i] = null;
        }
        i += 1;
      }
      if (!bool1)
      {
        if (localj.bvY) {
          if (j != 0) {
            break label588;
          }
        }
      }
      else
      {
        i = 1;
        localf = localj.byv.bxI;
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
        n = localj.bct.a(((com.google.android.exoplayer2.g.f)localObject2).wt());
        localj.n(n, true);
        if (n == localj.byB)
        {
          localj.byv.bxI = ((com.google.android.exoplayer2.g.f)localObject2);
          localObject1 = localObject2;
        }
        arrayOfl2[j] = new i(localj, n);
        paramArrayOfBoolean2[j] = true;
        localObject2 = localObject1;
        if (i != 0) {
          break label1167;
        }
        localObject2 = localj.bvV[n];
        ((com.google.android.exoplayer2.source.k)localObject2).rewind();
        if ((((com.google.android.exoplayer2.source.k)localObject2).f(paramLong, true)) || (((com.google.android.exoplayer2.source.k)localObject2).bwN.vz() == 0)) {
          break label594;
        }
        i = 1;
      }
    }
    for (;;)
    {
      j += 1;
      break label409;
      if (paramLong != localj.bwf) {
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
      if (localj.bwa == 0)
      {
        localj.byv.bxD = null;
        localj.byz = null;
        localj.byy.clear();
        if (localj.bvP.isLoading())
        {
          localObject1 = localj.bvV;
          n = localObject1.length;
          j = 0;
          while (j < n)
          {
            localObject1[j].vG();
            j += 1;
          }
          localj.bvP.cancelLoading();
        }
        for (j = i;; j = i)
        {
          localj.bvY = true;
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
            this.byk.put(arrayOfl2[i], Integer.valueOf(k));
            label769:
            i += 1;
            n = i1;
          }
          localj.vP();
        }
      }
      if ((!localj.byy.isEmpty()) && (!x.i(localObject1, localf))) {
        if (!localj.bvY)
        {
          ((com.google.android.exoplayer2.g.f)localObject1).af(0L);
          j = localj.byv.bxz.j(((f)localj.byy.getLast()).bxj);
          if (((com.google.android.exoplayer2.g.f)localObject1).wv() == j) {
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
          localj.byF = true;
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
            localj.aU(true);
            if ((j == 0) && (this.byo.length != 0) && (localj == this.byo[0])) {
              break label1099;
            }
            this.bxw.byH.clear();
          }
          label1093:
          label1099:
          for (bool2 = true;; bool2 = bool1)
          {
            k += 1;
            m = i;
            bool1 = bool2;
            break;
            localj.aU(false);
          }
          System.arraycopy(arrayOfl1, 0, paramArrayOfl, 0, arrayOfl1.length);
          this.byo = ((j[])Arrays.copyOf(arrayOfj, m));
          this.byp = new com.google.android.exoplayer2.source.e(this.byo);
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
  
  public final void a(com.google.android.exoplayer2.source.b.a.a.a parama)
  {
    AppMethodBeat.i(62844);
    ((e.a)this.bxy.bzH.get(parama)).vS();
    AppMethodBeat.o(62844);
  }
  
  public final void a(h.a parama, long paramLong)
  {
    AppMethodBeat.i(62835);
    this.bvx = parama;
    this.bxy.listeners.add(this);
    Object localObject2 = this.bxy.bxO;
    parama = new ArrayList(((com.google.android.exoplayer2.source.b.a.a)localObject2).byM);
    Object localObject1 = new ArrayList();
    Object localObject3 = new ArrayList();
    int i = 0;
    Object localObject4;
    if (i < parama.size())
    {
      localObject4 = (com.google.android.exoplayer2.source.b.a.a.a)parama.get(i);
      if ((((com.google.android.exoplayer2.source.b.a.a.a)localObject4).bdI.height > 0) || (a((com.google.android.exoplayer2.source.b.a.a.a)localObject4, "avc"))) {
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
      localObject3 = ((com.google.android.exoplayer2.source.b.a.a)localObject2).audios;
      localObject1 = ((com.google.android.exoplayer2.source.b.a.a)localObject2).byN;
      this.byn = new j[((List)localObject3).size() + 1 + ((List)localObject1).size()];
      this.bym = this.byn.length;
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
      parama = a(0, (com.google.android.exoplayer2.source.b.a.a.a[])localObject4, ((com.google.android.exoplayer2.source.b.a.a)localObject2).byw, ((com.google.android.exoplayer2.source.b.a.a)localObject2).bxA, paramLong);
      this.byn[0] = parama;
      parama.aU(true);
      parama.vO();
      i = 1;
      j = 0;
      while (j < ((List)localObject3).size())
      {
        parama = (com.google.android.exoplayer2.source.b.a.a.a)((List)localObject3).get(j);
        localObject2 = Collections.emptyList();
        parama = a(1, new com.google.android.exoplayer2.source.b.a.a.a[] { parama }, null, (List)localObject2, paramLong);
        this.byn[i] = parama;
        parama.vO();
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
      parama = parama.bdI;
      ((j)localObject2).eH(0).f(parama);
      ((j)localObject2).bvX = true;
      ((j)localObject2).vQ();
      this.byn[i] = localObject2;
      i += 1;
      j += 1;
    }
    this.byo = this.byn;
    AppMethodBeat.o(62835);
  }
  
  public final void b(com.google.android.exoplayer2.source.b.a.a.a parama)
  {
    AppMethodBeat.i(62846);
    j[] arrayOfj = this.byn;
    int j = arrayOfj.length;
    int i = 0;
    while (i < j)
    {
      c localc = arrayOfj[i].byv;
      int k = localc.bxz.j(parama.bdI);
      if (k != -1)
      {
        k = localc.bxI.indexOf(k);
        if (k != -1) {
          localc.bxI.eX(k);
        }
      }
      i += 1;
    }
    vN();
    AppMethodBeat.o(62846);
  }
  
  public final void ta()
  {
    AppMethodBeat.i(62843);
    int i = this.bym - 1;
    this.bym = i;
    if (i > 0)
    {
      AppMethodBeat.o(62843);
      return;
    }
    Object localObject = this.byn;
    int k = localObject.length;
    i = 0;
    int j = 0;
    while (i < k)
    {
      j += localObject[i].bct.length;
      i += 1;
    }
    localObject = new o[j];
    j[] arrayOfj = this.byn;
    int m = arrayOfj.length;
    j = 0;
    i = 0;
    while (i < m)
    {
      j localj = arrayOfj[i];
      int n = localj.bct.length;
      k = 0;
      while (k < n)
      {
        localObject[j] = localj.bct.bxh[k];
        k += 1;
        j += 1;
      }
      i += 1;
    }
    this.bct = new p((o[])localObject);
    this.bvx.a(this);
    AppMethodBeat.o(62843);
  }
  
  public final void vM()
  {
    AppMethodBeat.i(62845);
    vN();
    AppMethodBeat.o(62845);
  }
  
  public final void vh()
  {
    AppMethodBeat.i(62836);
    j[] arrayOfj = this.byn;
    int j = arrayOfj.length;
    int i = 0;
    while (i < j)
    {
      arrayOfj[i].byv.vm();
      i += 1;
    }
    AppMethodBeat.o(62836);
  }
  
  public final p vi()
  {
    return this.bct;
  }
  
  public final long vj()
  {
    return -9223372036854775807L;
  }
  
  public final long vk()
  {
    AppMethodBeat.i(62841);
    long l = this.byp.vk();
    AppMethodBeat.o(62841);
    return l;
  }
  
  public final long vl()
  {
    AppMethodBeat.i(62840);
    long l = this.byp.vl();
    AppMethodBeat.o(62840);
    return l;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.android.exoplayer2.source.b.g
 * JD-Core Version:    0.7.0.1
 */