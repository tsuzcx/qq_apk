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
  private r cFN;
  private com.google.android.exoplayer2.source.j.a cYN;
  private final int cYZ;
  private final b cZc;
  private final k daT;
  final e daV;
  private final d dbG;
  private final b.a dbH;
  private final IdentityHashMap<n, Integer> dbI;
  final Handler dbJ;
  private int dbK;
  j[] dbL;
  private j[] dbM;
  private com.google.android.exoplayer2.source.f dbN;
  
  public g(e parame, d paramd, int paramInt, b.a parama, b paramb)
  {
    AppMethodBeat.i(62834);
    this.daV = parame;
    this.dbG = paramd;
    this.cYZ = paramInt;
    this.dbH = parama;
    this.cZc = paramb;
    this.dbI = new IdentityHashMap();
    this.daT = new k();
    this.dbJ = new Handler();
    this.dbL = new j[0];
    this.dbM = new j[0];
    AppMethodBeat.o(62834);
  }
  
  private void Tt()
  {
    AppMethodBeat.i(62848);
    if (this.cFN != null)
    {
      this.cYN.a(this);
      AppMethodBeat.o(62848);
      return;
    }
    j[] arrayOfj = this.dbL;
    int j = arrayOfj.length;
    int i = 0;
    while (i < j)
    {
      arrayOfj[i].Tu();
      i += 1;
    }
    AppMethodBeat.o(62848);
  }
  
  private j a(int paramInt, a.a[] paramArrayOfa, Format paramFormat, List<Format> paramList, long paramLong)
  {
    AppMethodBeat.i(62847);
    paramArrayOfa = new j(paramInt, this, new c(this.daV, paramArrayOfa, this.dbG, this.daT, paramList), this.cZc, paramLong, paramFormat, this.cYZ, this.dbH);
    AppMethodBeat.o(62847);
    return paramArrayOfa;
  }
  
  private static boolean a(a.a parama, String paramString)
  {
    AppMethodBeat.i(62849);
    parama = parama.cHc.cGK;
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
  
  public final void Qz()
  {
    AppMethodBeat.i(62843);
    int i = this.dbK - 1;
    this.dbK = i;
    if (i > 0)
    {
      AppMethodBeat.o(62843);
      return;
    }
    Object localObject = this.dbL;
    int k = localObject.length;
    i = 0;
    int j = 0;
    while (i < k)
    {
      j += localObject[i].cFN.length;
      i += 1;
    }
    localObject = new q[j];
    j[] arrayOfj = this.dbL;
    int m = arrayOfj.length;
    j = 0;
    i = 0;
    while (i < m)
    {
      j localj = arrayOfj[i];
      int n = localj.cFN.length;
      k = 0;
      while (k < n)
      {
        localObject[j] = localj.cFN.daE[k];
        k += 1;
        j += 1;
      }
      i += 1;
    }
    this.cFN = new r((q[])localObject);
    this.cYN.a(this);
    AppMethodBeat.o(62843);
  }
  
  public final void SO()
  {
    AppMethodBeat.i(62836);
    j[] arrayOfj = this.dbL;
    int j = arrayOfj.length;
    int i = 0;
    while (i < j)
    {
      arrayOfj[i].ST();
      i += 1;
    }
    AppMethodBeat.o(62836);
  }
  
  public final r SP()
  {
    return this.cFN;
  }
  
  public final long SQ()
  {
    return -9223372036854775807L;
  }
  
  public final long SR()
  {
    AppMethodBeat.i(62841);
    long l = this.dbN.SR();
    AppMethodBeat.o(62841);
    return l;
  }
  
  public final long SS()
  {
    AppMethodBeat.i(62840);
    long l = this.dbN.SS();
    AppMethodBeat.o(62840);
    return l;
  }
  
  public final void Ts()
  {
    AppMethodBeat.i(62845);
    Tt();
    AppMethodBeat.o(62845);
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
          localObject1 = paramArrayOff[i].Uc();
          j = 0;
        }
      }
      for (;;)
      {
        if (j < this.dbL.length)
        {
          if (this.dbL[j].cFN.a((q)localObject1) != -1) {
            arrayOfInt2[i] = j;
          }
        }
        else
        {
          i += 1;
          break;
          j = ((Integer)this.dbI.get(paramArrayOfn[i])).intValue();
          break label37;
        }
        j += 1;
      }
    }
    boolean bool1 = false;
    this.dbI.clear();
    n[] arrayOfn1 = new n[paramArrayOff.length];
    n[] arrayOfn2 = new n[paramArrayOff.length];
    com.google.android.exoplayer2.g.f[] arrayOff = new com.google.android.exoplayer2.g.f[paramArrayOff.length];
    int m = 0;
    j[] arrayOfj = new j[this.dbL.length];
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
    if (k < this.dbL.length)
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
      localj = this.dbL[k];
      com.google.android.exoplayer2.i.a.checkState(localj.cGv);
      j = localj.cZq;
      i = 0;
      while (i < arrayOff.length)
      {
        if ((arrayOfn2[i] != null) && ((arrayOff[i] == null) || (paramArrayOfBoolean1[i] == 0)))
        {
          localj.C(((i)arrayOfn2[i]).group, false);
          arrayOfn2[i] = null;
        }
        i += 1;
      }
      if (!bool1)
      {
        if (localj.cZo) {
          if (j != 0) {
            break label588;
          }
        }
      }
      else
      {
        i = 1;
        localf = localj.dbS.dbf;
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
        n = localj.cFN.a(((com.google.android.exoplayer2.g.f)localObject2).Uc());
        localj.C(n, true);
        if (n == localj.dbY)
        {
          localj.dbS.dbf = ((com.google.android.exoplayer2.g.f)localObject2);
          localObject1 = localObject2;
        }
        arrayOfn2[j] = new i(localj, n);
        paramArrayOfBoolean2[j] = true;
        localObject2 = localObject1;
        if (i != 0) {
          break label1167;
        }
        localObject2 = localj.cZl[n];
        ((m)localObject2).bh();
        if ((((m)localObject2).k(paramLong, true)) || (((m)localObject2).daj.Tf() == 0)) {
          break label594;
        }
        i = 1;
      }
    }
    for (;;)
    {
      j += 1;
      break label409;
      if (paramLong != localj.cZv) {
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
      if (localj.cZq == 0)
      {
        localj.dbS.dba = null;
        localj.dbW = null;
        localj.dbV.clear();
        if (localj.cZf.isLoading())
        {
          localObject1 = localj.cZl;
          n = localObject1.length;
          j = 0;
          while (j < n)
          {
            localObject1[j].Tm();
            j += 1;
          }
          localj.cZf.cancelLoading();
        }
        for (j = i;; j = i)
        {
          localj.cZo = true;
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
            this.dbI.put(arrayOfn2[i], Integer.valueOf(k));
            label769:
            i += 1;
            n = i1;
          }
          localj.Tv();
        }
      }
      if ((!localj.dbV.isEmpty()) && (!x.p(localObject1, localf))) {
        if (!localj.cZo)
        {
          ((com.google.android.exoplayer2.g.f)localObject1).cw(0L);
          j = localj.dbS.daW.j(((f)localj.dbV.getLast()).daG);
          if (((com.google.android.exoplayer2.g.f)localObject1).Ue() == j) {
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
          localj.dcc = true;
        }
        for (;;)
        {
          j = i;
          if (i == 0) {
            break label693;
          }
          localj.n(paramLong, bool2);
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
            localj.bz(true);
            if ((j == 0) && (this.dbM.length != 0) && (localj == this.dbM[0])) {
              break label1099;
            }
            this.daT.dce.clear();
          }
          label1093:
          label1099:
          for (bool2 = true;; bool2 = bool1)
          {
            k += 1;
            m = i;
            bool1 = bool2;
            break;
            localj.bz(false);
          }
          System.arraycopy(arrayOfn1, 0, paramArrayOfn, 0, arrayOfn1.length);
          this.dbM = ((j[])Arrays.copyOf(arrayOfj, m));
          this.dbN = new com.google.android.exoplayer2.source.f(this.dbM);
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
    ((e.a)this.daV.dde.get(parama)).Tz();
    AppMethodBeat.o(62844);
  }
  
  public final void a(com.google.android.exoplayer2.source.j.a parama, long paramLong)
  {
    AppMethodBeat.i(62835);
    this.cYN = parama;
    this.daV.listeners.add(this);
    Object localObject2 = this.daV.dbl;
    parama = new ArrayList(((com.google.android.exoplayer2.source.b.a.a)localObject2).dcj);
    Object localObject1 = new ArrayList();
    Object localObject3 = new ArrayList();
    int i = 0;
    Object localObject4;
    if (i < parama.size())
    {
      localObject4 = (a.a)parama.get(i);
      if ((((a.a)localObject4).cHc.height > 0) || (a((a.a)localObject4, "avc"))) {
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
      localObject1 = ((com.google.android.exoplayer2.source.b.a.a)localObject2).dck;
      this.dbL = new j[((List)localObject3).size() + 1 + ((List)localObject1).size()];
      this.dbK = this.dbL.length;
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
      parama = a(0, (a.a[])localObject4, ((com.google.android.exoplayer2.source.b.a.a)localObject2).dbT, ((com.google.android.exoplayer2.source.b.a.a)localObject2).daX, paramLong);
      this.dbL[0] = parama;
      parama.bz(true);
      parama.Tu();
      i = 1;
      j = 0;
      while (j < ((List)localObject3).size())
      {
        parama = (a.a)((List)localObject3).get(j);
        localObject2 = Collections.emptyList();
        parama = a(1, new a.a[] { parama }, null, (List)localObject2, paramLong);
        this.dbL[i] = parama;
        parama.Tu();
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
      parama = parama.cHc;
      ((j)localObject2).im(0).f(parama);
      ((j)localObject2).cZn = true;
      ((j)localObject2).Tw();
      this.dbL[i] = localObject2;
      i += 1;
      j += 1;
    }
    this.dbM = this.dbL;
    AppMethodBeat.o(62835);
  }
  
  public final void b(a.a parama)
  {
    AppMethodBeat.i(62846);
    j[] arrayOfj = this.dbL;
    int j = arrayOfj.length;
    int i = 0;
    while (i < j)
    {
      c localc = arrayOfj[i].dbS;
      int k = localc.daW.j(parama.cHc);
      if (k != -1)
      {
        k = localc.dbf.es(k);
        if (k != -1) {
          localc.dbf.k(k, 60000L);
        }
      }
      i += 1;
    }
    Tt();
    AppMethodBeat.o(62846);
  }
  
  public final void cm(long paramLong)
  {
    AppMethodBeat.i(62838);
    j[] arrayOfj = this.dbM;
    int k = arrayOfj.length;
    int i = 0;
    while (i < k)
    {
      j localj = arrayOfj[i];
      int m = localj.cZl.length;
      int j = 0;
      while (j < m)
      {
        localj.cZl[j].m(paramLong, localj.dca[j]);
        j += 1;
      }
      i += 1;
    }
    AppMethodBeat.o(62838);
  }
  
  public final long cn(long paramLong)
  {
    AppMethodBeat.i(62842);
    if (this.dbM.length > 0)
    {
      boolean bool = this.dbM[0].n(paramLong, false);
      int i = 1;
      while (i < this.dbM.length)
      {
        this.dbM[i].n(paramLong, bool);
        i += 1;
      }
      if (bool) {
        this.daT.dce.clear();
      }
    }
    AppMethodBeat.o(62842);
    return paramLong;
  }
  
  public final boolean co(long paramLong)
  {
    AppMethodBeat.i(62839);
    boolean bool = this.dbN.co(paramLong);
    AppMethodBeat.o(62839);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.google.android.exoplayer2.source.b.g
 * JD-Core Version:    0.7.0.1
 */