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
  private p aRY;
  private h.a blc;
  private final int blo;
  private final b blr;
  private final d bnN;
  private final com.google.android.exoplayer2.source.a.a bnO;
  private final IdentityHashMap<l, Integer> bnP;
  final Handler bnQ;
  private int bnR;
  j[] bnS;
  private j[] bnT;
  private com.google.android.exoplayer2.source.e bnU;
  private final k bnb;
  final com.google.android.exoplayer2.source.b.a.e bnd;
  
  public g(com.google.android.exoplayer2.source.b.a.e parame, d paramd, int paramInt, com.google.android.exoplayer2.source.a.a parama, b paramb)
  {
    AppMethodBeat.i(62834);
    this.bnd = parame;
    this.bnN = paramd;
    this.blo = paramInt;
    this.bnO = parama;
    this.blr = paramb;
    this.bnP = new IdentityHashMap();
    this.bnb = new k();
    this.bnQ = new Handler();
    this.bnS = new j[0];
    this.bnT = new j[0];
    AppMethodBeat.o(62834);
  }
  
  private j a(int paramInt, com.google.android.exoplayer2.source.b.a.a.a[] paramArrayOfa, Format paramFormat, List<Format> paramList, long paramLong)
  {
    AppMethodBeat.i(62847);
    paramArrayOfa = new j(paramInt, this, new c(this.bnd, paramArrayOfa, this.bnN, this.bnb, paramList), this.blr, paramLong, paramFormat, this.blo, this.bnO);
    AppMethodBeat.o(62847);
    return paramArrayOfa;
  }
  
  private static boolean a(com.google.android.exoplayer2.source.b.a.a.a parama, String paramString)
  {
    AppMethodBeat.i(62849);
    parama = parama.aTo.aSV;
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
  
  private void uo()
  {
    AppMethodBeat.i(62848);
    if (this.aRY != null)
    {
      this.blc.a(this);
      AppMethodBeat.o(62848);
      return;
    }
    j[] arrayOfj = this.bnS;
    int j = arrayOfj.length;
    int i = 0;
    while (i < j)
    {
      arrayOfj[i].up();
      i += 1;
    }
    AppMethodBeat.o(62848);
  }
  
  public final void V(long paramLong)
  {
    AppMethodBeat.i(62838);
    j[] arrayOfj = this.bnT;
    int k = arrayOfj.length;
    int i = 0;
    while (i < k)
    {
      j localj = arrayOfj[i];
      int m = localj.blA.length;
      int j = 0;
      while (j < m)
      {
        localj.blA[j].h(paramLong, localj.boi[j]);
        j += 1;
      }
      i += 1;
    }
    AppMethodBeat.o(62838);
  }
  
  public final long W(long paramLong)
  {
    AppMethodBeat.i(62842);
    if (this.bnT.length > 0)
    {
      boolean bool = this.bnT[0].i(paramLong, false);
      int i = 1;
      while (i < this.bnT.length)
      {
        this.bnT[i].i(paramLong, bool);
        i += 1;
      }
      if (bool) {
        this.bnb.bom.clear();
      }
    }
    AppMethodBeat.o(62842);
    return paramLong;
  }
  
  public final boolean X(long paramLong)
  {
    AppMethodBeat.i(62839);
    boolean bool = this.bnU.X(paramLong);
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
          localObject1 = paramArrayOff[i].uU();
          j = 0;
        }
      }
      for (;;)
      {
        if (j < this.bnS.length)
        {
          if (this.bnS[j].aRY.a((o)localObject1) != -1) {
            arrayOfInt2[i] = j;
          }
        }
        else
        {
          i += 1;
          break;
          j = ((Integer)this.bnP.get(paramArrayOfl[i])).intValue();
          break label37;
        }
        j += 1;
      }
    }
    boolean bool1 = false;
    this.bnP.clear();
    l[] arrayOfl1 = new l[paramArrayOff.length];
    l[] arrayOfl2 = new l[paramArrayOff.length];
    com.google.android.exoplayer2.g.f[] arrayOff = new com.google.android.exoplayer2.g.f[paramArrayOff.length];
    int m = 0;
    j[] arrayOfj = new j[this.bnS.length];
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
    if (k < this.bnS.length)
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
      localj = this.bnS[k];
      com.google.android.exoplayer2.i.a.checkState(localj.aSG);
      j = localj.blF;
      i = 0;
      while (i < arrayOff.length)
      {
        if ((arrayOfl2[i] != null) && ((arrayOff[i] == null) || (paramArrayOfBoolean1[i] == 0)))
        {
          localj.n(((i)arrayOfl2[i]).bnX, false);
          arrayOfl2[i] = null;
        }
        i += 1;
      }
      if (!bool1)
      {
        if (localj.blD) {
          if (j != 0) {
            break label588;
          }
        }
      }
      else
      {
        i = 1;
        localf = localj.boa.bnn;
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
        n = localj.aRY.a(((com.google.android.exoplayer2.g.f)localObject2).uU());
        localj.n(n, true);
        if (n == localj.bog)
        {
          localj.boa.bnn = ((com.google.android.exoplayer2.g.f)localObject2);
          localObject1 = localObject2;
        }
        arrayOfl2[j] = new i(localj, n);
        paramArrayOfBoolean2[j] = true;
        localObject2 = localObject1;
        if (i != 0) {
          break label1167;
        }
        localObject2 = localj.blA[n];
        ((com.google.android.exoplayer2.source.k)localObject2).rewind();
        if ((((com.google.android.exoplayer2.source.k)localObject2).f(paramLong, true)) || (((com.google.android.exoplayer2.source.k)localObject2).bms.ua() == 0)) {
          break label594;
        }
        i = 1;
      }
    }
    for (;;)
    {
      j += 1;
      break label409;
      if (paramLong != localj.blK) {
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
      if (localj.blF == 0)
      {
        localj.boa.bni = null;
        localj.boe = null;
        localj.bod.clear();
        if (localj.blu.isLoading())
        {
          localObject1 = localj.blA;
          n = localObject1.length;
          j = 0;
          while (j < n)
          {
            localObject1[j].uh();
            j += 1;
          }
          localj.blu.cancelLoading();
        }
        for (j = i;; j = i)
        {
          localj.blD = true;
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
            this.bnP.put(arrayOfl2[i], Integer.valueOf(k));
            label769:
            i += 1;
            n = i1;
          }
          localj.uq();
        }
      }
      if ((!localj.bod.isEmpty()) && (!x.g(localObject1, localf))) {
        if (!localj.blD)
        {
          ((com.google.android.exoplayer2.g.f)localObject1).af(0L);
          j = localj.boa.bne.j(((f)localj.bod.getLast()).bmO);
          if (((com.google.android.exoplayer2.g.f)localObject1).uW() == j) {
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
          localj.bok = true;
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
            localj.aT(true);
            if ((j == 0) && (this.bnT.length != 0) && (localj == this.bnT[0])) {
              break label1099;
            }
            this.bnb.bom.clear();
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
          System.arraycopy(arrayOfl1, 0, paramArrayOfl, 0, arrayOfl1.length);
          this.bnT = ((j[])Arrays.copyOf(arrayOfj, m));
          this.bnU = new com.google.android.exoplayer2.source.e(this.bnT);
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
    ((e.a)this.bnd.bpm.get(parama)).ut();
    AppMethodBeat.o(62844);
  }
  
  public final void a(h.a parama, long paramLong)
  {
    AppMethodBeat.i(62835);
    this.blc = parama;
    this.bnd.listeners.add(this);
    Object localObject2 = this.bnd.bnt;
    parama = new ArrayList(((com.google.android.exoplayer2.source.b.a.a)localObject2).bor);
    Object localObject1 = new ArrayList();
    Object localObject3 = new ArrayList();
    int i = 0;
    Object localObject4;
    if (i < parama.size())
    {
      localObject4 = (com.google.android.exoplayer2.source.b.a.a.a)parama.get(i);
      if ((((com.google.android.exoplayer2.source.b.a.a.a)localObject4).aTo.height > 0) || (a((com.google.android.exoplayer2.source.b.a.a.a)localObject4, "avc"))) {
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
      localObject1 = ((com.google.android.exoplayer2.source.b.a.a)localObject2).bos;
      this.bnS = new j[((List)localObject3).size() + 1 + ((List)localObject1).size()];
      this.bnR = this.bnS.length;
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
      parama = a(0, (com.google.android.exoplayer2.source.b.a.a.a[])localObject4, ((com.google.android.exoplayer2.source.b.a.a)localObject2).bob, ((com.google.android.exoplayer2.source.b.a.a)localObject2).bnf, paramLong);
      this.bnS[0] = parama;
      parama.aT(true);
      parama.up();
      i = 1;
      j = 0;
      while (j < ((List)localObject3).size())
      {
        parama = (com.google.android.exoplayer2.source.b.a.a.a)((List)localObject3).get(j);
        localObject2 = Collections.emptyList();
        parama = a(1, new com.google.android.exoplayer2.source.b.a.a.a[] { parama }, null, (List)localObject2, paramLong);
        this.bnS[i] = parama;
        parama.up();
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
      parama = parama.aTo;
      ((j)localObject2).eD(0).f(parama);
      ((j)localObject2).blC = true;
      ((j)localObject2).ur();
      this.bnS[i] = localObject2;
      i += 1;
      j += 1;
    }
    this.bnT = this.bnS;
    AppMethodBeat.o(62835);
  }
  
  public final void b(com.google.android.exoplayer2.source.b.a.a.a parama)
  {
    AppMethodBeat.i(62846);
    j[] arrayOfj = this.bnS;
    int j = arrayOfj.length;
    int i = 0;
    while (i < j)
    {
      c localc = arrayOfj[i].boa;
      int k = localc.bne.j(parama.aTo);
      if (k != -1)
      {
        k = localc.bnn.indexOf(k);
        if (k != -1) {
          localc.bnn.eT(k);
        }
      }
      i += 1;
    }
    uo();
    AppMethodBeat.o(62846);
  }
  
  public final void rB()
  {
    AppMethodBeat.i(62843);
    int i = this.bnR - 1;
    this.bnR = i;
    if (i > 0)
    {
      AppMethodBeat.o(62843);
      return;
    }
    Object localObject = this.bnS;
    int k = localObject.length;
    i = 0;
    int j = 0;
    while (i < k)
    {
      j += localObject[i].aRY.length;
      i += 1;
    }
    localObject = new o[j];
    j[] arrayOfj = this.bnS;
    int m = arrayOfj.length;
    j = 0;
    i = 0;
    while (i < m)
    {
      j localj = arrayOfj[i];
      int n = localj.aRY.length;
      k = 0;
      while (k < n)
      {
        localObject[j] = localj.aRY.bmM[k];
        k += 1;
        j += 1;
      }
      i += 1;
    }
    this.aRY = new p((o[])localObject);
    this.blc.a(this);
    AppMethodBeat.o(62843);
  }
  
  public final void tI()
  {
    AppMethodBeat.i(62836);
    j[] arrayOfj = this.bnS;
    int j = arrayOfj.length;
    int i = 0;
    while (i < j)
    {
      arrayOfj[i].boa.tN();
      i += 1;
    }
    AppMethodBeat.o(62836);
  }
  
  public final p tJ()
  {
    return this.aRY;
  }
  
  public final long tK()
  {
    return -9223372036854775807L;
  }
  
  public final long tL()
  {
    AppMethodBeat.i(62841);
    long l = this.bnU.tL();
    AppMethodBeat.o(62841);
    return l;
  }
  
  public final long tM()
  {
    AppMethodBeat.i(62840);
    long l = this.bnU.tM();
    AppMethodBeat.o(62840);
    return l;
  }
  
  public final void un()
  {
    AppMethodBeat.i(62845);
    uo();
    AppMethodBeat.o(62845);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.source.b.g
 * JD-Core Version:    0.7.0.1
 */