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
import com.google.android.exoplayer2.source.i.a;
import com.google.android.exoplayer2.source.l;
import com.google.android.exoplayer2.source.m;
import com.google.android.exoplayer2.source.p;
import com.google.android.exoplayer2.source.q;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.LinkedList;
import java.util.List;

public final class g
  implements e.b, j.a, com.google.android.exoplayer2.source.i
{
  private q aRd;
  private final int bkJ;
  private final b bkM;
  private i.a bkx;
  private final com.google.android.exoplayer2.source.a.a bmE;
  private com.google.android.exoplayer2.source.e bmZ;
  private final k boJ;
  final com.google.android.exoplayer2.source.b.a.e boL;
  private final d bpq;
  private final IdentityHashMap<m, Integer> bpr;
  final Handler bps;
  private int bpt;
  j[] bpu;
  private j[] bpv;
  
  public g(com.google.android.exoplayer2.source.b.a.e parame, d paramd, int paramInt, com.google.android.exoplayer2.source.a.a parama, b paramb)
  {
    AppMethodBeat.i(62834);
    this.boL = parame;
    this.bpq = paramd;
    this.bkJ = paramInt;
    this.bmE = parama;
    this.bkM = paramb;
    this.bpr = new IdentityHashMap();
    this.boJ = new k();
    this.bps = new Handler();
    this.bpu = new j[0];
    this.bpv = new j[0];
    AppMethodBeat.o(62834);
  }
  
  private j a(int paramInt, com.google.android.exoplayer2.source.b.a.a.a[] paramArrayOfa, Format paramFormat, List<Format> paramList, long paramLong)
  {
    AppMethodBeat.i(62847);
    paramArrayOfa = new j(paramInt, this, new c(this.boL, paramArrayOfa, this.bpq, this.boJ, paramList), this.bkM, paramLong, paramFormat, this.bkJ, this.bmE);
    AppMethodBeat.o(62847);
    return paramArrayOfa;
  }
  
  private static boolean a(com.google.android.exoplayer2.source.b.a.a.a parama, String paramString)
  {
    AppMethodBeat.i(62849);
    parama = parama.aSv.aSa;
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
  
  private void us()
  {
    AppMethodBeat.i(62848);
    if (this.aRd != null)
    {
      this.bkx.a(this);
      AppMethodBeat.o(62848);
      return;
    }
    j[] arrayOfj = this.bpu;
    int j = arrayOfj.length;
    int i = 0;
    while (i < j)
    {
      arrayOfj[i].ut();
      i += 1;
    }
    AppMethodBeat.o(62848);
  }
  
  public final void U(long paramLong)
  {
    AppMethodBeat.i(62838);
    j[] arrayOfj = this.bpv;
    int k = arrayOfj.length;
    int i = 0;
    while (i < k)
    {
      j localj = arrayOfj[i];
      int m = localj.bkV.length;
      int j = 0;
      while (j < m)
      {
        localj.bkV[j].b(paramLong, false, localj.bpG[j]);
        j += 1;
      }
      i += 1;
    }
    AppMethodBeat.o(62838);
  }
  
  public final long V(long paramLong)
  {
    AppMethodBeat.i(62842);
    if (this.bpv.length > 0)
    {
      boolean bool = this.bpv[0].g(paramLong, false);
      int i = 1;
      while (i < this.bpv.length)
      {
        this.bpv[i].g(paramLong, bool);
        i += 1;
      }
      if (bool) {
        this.boJ.bpK.clear();
      }
    }
    AppMethodBeat.o(62842);
    return paramLong;
  }
  
  public final boolean W(long paramLong)
  {
    AppMethodBeat.i(62839);
    boolean bool = this.bmZ.W(paramLong);
    AppMethodBeat.o(62839);
    return bool;
  }
  
  public final long a(com.google.android.exoplayer2.g.f[] paramArrayOff, boolean[] paramArrayOfBoolean1, m[] paramArrayOfm, boolean[] paramArrayOfBoolean2, long paramLong)
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
      if (paramArrayOfm[i] == null)
      {
        j = -1;
        arrayOfInt1[i] = j;
        arrayOfInt2[i] = -1;
        if (paramArrayOff[i] != null)
        {
          localObject1 = paramArrayOff[i].va();
          j = 0;
        }
      }
      for (;;)
      {
        if (j < this.bpu.length)
        {
          if (this.bpu[j].aRd.a((p)localObject1) != -1) {
            arrayOfInt2[i] = j;
          }
        }
        else
        {
          i += 1;
          break;
          j = ((Integer)this.bpr.get(paramArrayOfm[i])).intValue();
          break label37;
        }
        j += 1;
      }
    }
    boolean bool1 = false;
    this.bpr.clear();
    m[] arrayOfm1 = new m[paramArrayOff.length];
    m[] arrayOfm2 = new m[paramArrayOff.length];
    com.google.android.exoplayer2.g.f[] arrayOff = new com.google.android.exoplayer2.g.f[paramArrayOff.length];
    int m = 0;
    j[] arrayOfj = new j[this.bpu.length];
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
    if (k < this.bpu.length)
    {
      i = 0;
      if (i < paramArrayOff.length)
      {
        if (arrayOfInt1[i] == k)
        {
          localObject1 = paramArrayOfm[i];
          arrayOfm2[i] = localObject1;
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
      localj = this.bpu[k];
      com.google.android.exoplayer2.i.a.checkState(localj.aRL);
      j = localj.bla;
      i = 0;
      while (i < arrayOff.length)
      {
        if ((arrayOfm2[i] != null) && ((arrayOff[i] == null) || (paramArrayOfBoolean1[i] == 0)))
        {
          localj.n(((i)arrayOfm2[i]).bpx, false);
          arrayOfm2[i] = null;
        }
        i += 1;
      }
      if (!bool1)
      {
        if (localj.bkY) {
          if (j != 0) {
            break label588;
          }
        }
      }
      else
      {
        i = 1;
        localf = localj.bpA.bnC;
        j = 0;
        localObject1 = localf;
        if (j >= arrayOff.length) {
          break label600;
        }
        localObject2 = localObject1;
        if (arrayOfm2[j] != null) {
          break label1167;
        }
        localObject2 = localObject1;
        if (arrayOff[j] == null) {
          break label1167;
        }
        localObject2 = arrayOff[j];
        n = localj.aRd.a(((com.google.android.exoplayer2.g.f)localObject2).va());
        localj.n(n, true);
        if (n == localj.bne)
        {
          localj.bpA.bnC = ((com.google.android.exoplayer2.g.f)localObject2);
          localObject1 = localObject2;
        }
        arrayOfm2[j] = new i(localj, n);
        paramArrayOfBoolean2[j] = true;
        localObject2 = localObject1;
        if (i != 0) {
          break label1167;
        }
        localObject2 = localj.bkV[n];
        ((l)localObject2).rewind();
        if ((((l)localObject2).f(paramLong, true)) || (((l)localObject2).blN.tS() == 0)) {
          break label594;
        }
        i = 1;
      }
    }
    for (;;)
    {
      j += 1;
      break label409;
      if (paramLong != localj.blf) {
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
      if (localj.bla == 0)
      {
        localj.bpA.bnF = null;
        localj.bpD = null;
        localj.bmG.clear();
        if (localj.bkP.isLoading())
        {
          localObject1 = localj.bkV;
          n = localObject1.length;
          j = 0;
          while (j < n)
          {
            localObject1[j].tZ();
            j += 1;
          }
          localj.bkP.cancelLoading();
        }
        for (j = i;; j = i)
        {
          localj.bkY = true;
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
            if (arrayOfm2[i] == null) {
              break;
            }
            bool2 = true;
            com.google.android.exoplayer2.i.a.checkState(bool2);
            arrayOfm1[i] = arrayOfm2[i];
            i1 = 1;
            this.bpr.put(arrayOfm2[i], Integer.valueOf(k));
            label769:
            i += 1;
            n = i1;
          }
          localj.uu();
        }
      }
      if ((!localj.bmG.isEmpty()) && (!x.g(localObject1, localf))) {
        if (!localj.bkY)
        {
          ((com.google.android.exoplayer2.g.f)localObject1).aj(0L);
          j = localj.bpA.boM.j(((f)localj.bmG.getLast()).bmm);
          if (((com.google.android.exoplayer2.g.f)localObject1).vc() == j) {
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
          localj.bpI = true;
        }
        for (;;)
        {
          j = i;
          if (i == 0) {
            break label693;
          }
          localj.g(paramLong, bool2);
          n = 0;
          for (;;)
          {
            j = i;
            if (n >= arrayOfm2.length) {
              break;
            }
            if (arrayOfm2[n] != null) {
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
          if (arrayOfm2[i] == null) {}
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
            if ((j == 0) && (this.bpv.length != 0) && (localj == this.bpv[0])) {
              break label1099;
            }
            this.boJ.bpK.clear();
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
          System.arraycopy(arrayOfm1, 0, paramArrayOfm, 0, arrayOfm1.length);
          this.bpv = ((j[])Arrays.copyOf(arrayOfj, m));
          this.bmZ = new com.google.android.exoplayer2.source.e(this.bpv);
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
    ((e.a)this.boL.bqM.get(parama)).ux();
    AppMethodBeat.o(62844);
  }
  
  public final void a(i.a parama, long paramLong)
  {
    AppMethodBeat.i(62835);
    this.bkx = parama;
    this.boL.listeners.add(this);
    Object localObject2 = this.boL.boY;
    parama = new ArrayList(((com.google.android.exoplayer2.source.b.a.a)localObject2).bpP);
    Object localObject1 = new ArrayList();
    Object localObject3 = new ArrayList();
    int i = 0;
    Object localObject4;
    if (i < parama.size())
    {
      localObject4 = (com.google.android.exoplayer2.source.b.a.a.a)parama.get(i);
      if ((((com.google.android.exoplayer2.source.b.a.a.a)localObject4).aSv.height > 0) || (a((com.google.android.exoplayer2.source.b.a.a.a)localObject4, "avc"))) {
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
      parama = (i.a)localObject1;
      localObject3 = ((com.google.android.exoplayer2.source.b.a.a)localObject2).audios;
      localObject1 = ((com.google.android.exoplayer2.source.b.a.a)localObject2).bpR;
      this.bpu = new j[((List)localObject3).size() + 1 + ((List)localObject1).size()];
      this.bpt = this.bpu.length;
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
      parama = a(0, (com.google.android.exoplayer2.source.b.a.a.a[])localObject4, ((com.google.android.exoplayer2.source.b.a.a)localObject2).bpB, ((com.google.android.exoplayer2.source.b.a.a)localObject2).boN, paramLong);
      this.bpu[0] = parama;
      parama.aU(true);
      parama.ut();
      i = 1;
      j = 0;
      while (j < ((List)localObject3).size())
      {
        parama = (com.google.android.exoplayer2.source.b.a.a.a)((List)localObject3).get(j);
        localObject2 = Collections.emptyList();
        parama = a(1, new com.google.android.exoplayer2.source.b.a.a.a[] { parama }, null, (List)localObject2, paramLong);
        this.bpu[i] = parama;
        parama.ut();
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
      parama = parama.aSv;
      ((j)localObject2).eP(0).f(parama);
      ((j)localObject2).bkX = true;
      ((j)localObject2).uv();
      this.bpu[i] = localObject2;
      i += 1;
      j += 1;
    }
    this.bpv = this.bpu;
    AppMethodBeat.o(62835);
  }
  
  public final void b(com.google.android.exoplayer2.source.b.a.a.a parama)
  {
    AppMethodBeat.i(62846);
    j[] arrayOfj = this.bpu;
    int j = arrayOfj.length;
    int i = 0;
    while (i < j)
    {
      c localc = arrayOfj[i].bpA;
      int k = localc.boM.j(parama.aSv);
      if (k != -1)
      {
        k = localc.bnC.indexOf(k);
        if (k != -1) {
          localc.bnC.fg(k);
        }
      }
      i += 1;
    }
    us();
    AppMethodBeat.o(62846);
  }
  
  public final void rq()
  {
    AppMethodBeat.i(62843);
    int i = this.bpt - 1;
    this.bpt = i;
    if (i > 0)
    {
      AppMethodBeat.o(62843);
      return;
    }
    Object localObject = this.bpu;
    int k = localObject.length;
    i = 0;
    int j = 0;
    while (i < k)
    {
      j += localObject[i].aRd.length;
      i += 1;
    }
    localObject = new p[j];
    j[] arrayOfj = this.bpu;
    int m = arrayOfj.length;
    j = 0;
    i = 0;
    while (i < m)
    {
      j localj = arrayOfj[i];
      int n = localj.aRd.length;
      k = 0;
      while (k < n)
      {
        localObject[j] = localj.aRd.bmh[k];
        k += 1;
        j += 1;
      }
      i += 1;
    }
    this.aRd = new q((p[])localObject);
    this.bkx.a(this);
    AppMethodBeat.o(62843);
  }
  
  public final void tA()
  {
    AppMethodBeat.i(62836);
    j[] arrayOfj = this.bpu;
    int j = arrayOfj.length;
    int i = 0;
    while (i < j)
    {
      arrayOfj[i].bpA.tF();
      i += 1;
    }
    AppMethodBeat.o(62836);
  }
  
  public final q tB()
  {
    return this.aRd;
  }
  
  public final long tC()
  {
    return -9223372036854775807L;
  }
  
  public final long tD()
  {
    AppMethodBeat.i(62841);
    long l = this.bmZ.tD();
    AppMethodBeat.o(62841);
    return l;
  }
  
  public final long tE()
  {
    AppMethodBeat.i(62840);
    long l = this.bmZ.tE();
    AppMethodBeat.o(62840);
    return l;
  }
  
  public final void ur()
  {
    AppMethodBeat.i(62845);
    us();
    AppMethodBeat.o(62845);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.source.b.g
 * JD-Core Version:    0.7.0.1
 */