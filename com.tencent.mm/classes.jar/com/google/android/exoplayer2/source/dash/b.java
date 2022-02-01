package com.google.android.exoplayer2.source.dash;

import android.util.Pair;
import android.util.SparseIntArray;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.h.u;
import com.google.android.exoplayer2.source.a.f.a;
import com.google.android.exoplayer2.source.dash.manifest.d;
import com.google.android.exoplayer2.source.i;
import com.google.android.exoplayer2.source.i.a;
import com.google.android.exoplayer2.source.l;
import com.google.android.exoplayer2.source.m;
import com.google.android.exoplayer2.source.n.a;
import com.google.android.exoplayer2.source.p;
import com.google.android.exoplayer2.source.q;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

final class b
  implements i, n.a<com.google.android.exoplayer2.source.a.f<a>>
{
  private final q aRd;
  private final int bkJ;
  private final com.google.android.exoplayer2.h.b bkM;
  private i.a bkx;
  private int blw;
  private final com.google.android.exoplayer2.source.a.a bmE;
  private final a.a bmU;
  private final long bmV;
  private final u bmW;
  private final a[] bmX;
  com.google.android.exoplayer2.source.a.f<a>[] bmY;
  private com.google.android.exoplayer2.source.e bmZ;
  private com.google.android.exoplayer2.source.dash.manifest.b bna;
  private List<com.google.android.exoplayer2.source.dash.manifest.a> bnb;
  final int id;
  
  public b(int paramInt1, com.google.android.exoplayer2.source.dash.manifest.b paramb, int paramInt2, a.a parama, int paramInt3, com.google.android.exoplayer2.source.a.a parama1, long paramLong, u paramu, com.google.android.exoplayer2.h.b paramb1)
  {
    AppMethodBeat.i(10450);
    this.id = paramInt1;
    this.bna = paramb;
    this.blw = paramInt2;
    this.bmU = parama;
    this.bkJ = paramInt3;
    this.bmE = parama1;
    this.bmV = paramLong;
    this.bmW = paramu;
    this.bkM = paramb1;
    this.bmY = new com.google.android.exoplayer2.source.a.f[0];
    this.bmZ = new com.google.android.exoplayer2.source.e(this.bmY);
    this.bnb = paramb.eL(paramInt2).bnb;
    paramb = w(this.bnb);
    this.aRd = ((q)paramb.first);
    this.bmX = ((a[])paramb.second);
    AppMethodBeat.o(10450);
  }
  
  private static void a(m paramm)
  {
    AppMethodBeat.i(10463);
    if ((paramm instanceof f.a)) {
      ((f.a)paramm).release();
    }
    AppMethodBeat.o(10463);
  }
  
  private static boolean a(List<com.google.android.exoplayer2.source.dash.manifest.a> paramList, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(10461);
    int k = paramArrayOfInt.length;
    int i = 0;
    while (i < k)
    {
      List localList = ((com.google.android.exoplayer2.source.dash.manifest.a)paramList.get(paramArrayOfInt[i])).bnK;
      int j = 0;
      while (j < localList.size())
      {
        if (!((com.google.android.exoplayer2.source.dash.manifest.g)localList.get(j)).boj.isEmpty())
        {
          AppMethodBeat.o(10461);
          return true;
        }
        j += 1;
      }
      i += 1;
    }
    AppMethodBeat.o(10461);
    return false;
  }
  
  private static boolean b(List<com.google.android.exoplayer2.source.dash.manifest.a> paramList, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(10462);
    int k = paramArrayOfInt.length;
    int i = 0;
    while (i < k)
    {
      List localList = ((com.google.android.exoplayer2.source.dash.manifest.a)paramList.get(paramArrayOfInt[i])).bnL;
      int j = 0;
      while (j < localList.size())
      {
        if ("urn:scte:dash:cc:cea-608:2015".equals(((d)localList.get(j)).bjo))
        {
          AppMethodBeat.o(10462);
          return true;
        }
        j += 1;
      }
      i += 1;
    }
    AppMethodBeat.o(10462);
    return false;
  }
  
  private static Pair<q, a[]> w(List<com.google.android.exoplayer2.source.dash.manifest.a> paramList)
  {
    AppMethodBeat.i(10459);
    int m = paramList.size();
    Object localObject2 = new SparseIntArray(m);
    int i = 0;
    while (i < m)
    {
      ((SparseIntArray)localObject2).put(((com.google.android.exoplayer2.source.dash.manifest.a)paramList.get(i)).id, i);
      i += 1;
    }
    Object localObject1 = new int[m][];
    boolean[] arrayOfBoolean = new boolean[m];
    i = 0;
    int j = 0;
    Object localObject3;
    int k;
    if (j < m)
    {
      if (arrayOfBoolean[j] != 0) {
        break label707;
      }
      arrayOfBoolean[j] = true;
      localObject3 = x(((com.google.android.exoplayer2.source.dash.manifest.a)paramList.get(j)).bnM);
      if (localObject3 == null)
      {
        k = i + 1;
        localObject1[i] = { j };
        i = k;
      }
    }
    label704:
    label707:
    for (;;)
    {
      j += 1;
      break;
      localObject3 = ((d)localObject3).value.split(",");
      Object localObject4 = new int[localObject3.length + 1];
      localObject4[0] = j;
      k = 0;
      int n;
      while (k < localObject3.length)
      {
        n = ((SparseIntArray)localObject2).get(Integer.parseInt(localObject3[k]));
        arrayOfBoolean[n] = true;
        localObject4[(k + 1)] = n;
        k += 1;
      }
      k = i + 1;
      localObject1[i] = localObject4;
      i = k;
      continue;
      if (i < m) {
        localObject1 = (int[][])Arrays.copyOf((Object[])localObject1, i);
      }
      for (;;)
      {
        m = localObject1.length;
        localObject2 = new boolean[m];
        arrayOfBoolean = new boolean[m];
        k = 0;
        i = m;
        while (k < m)
        {
          j = i;
          if (a(paramList, localObject1[k]))
          {
            localObject2[k] = 1;
            j = i + 1;
          }
          i = j;
          if (b(paramList, localObject1[k]))
          {
            arrayOfBoolean[k] = true;
            i = j + 1;
          }
          k += 1;
        }
      }
      localObject3 = new p[i];
      localObject4 = new a[i];
      k = 0;
      j = 0;
      int[] arrayOfInt;
      Object localObject5;
      int i2;
      if (j < m)
      {
        arrayOfInt = localObject1[j];
        localObject5 = new ArrayList();
        n = arrayOfInt.length;
        i = 0;
        while (i < n)
        {
          ((List)localObject5).addAll(((com.google.android.exoplayer2.source.dash.manifest.a)paramList.get(arrayOfInt[i])).bnK);
          i += 1;
        }
        Format[] arrayOfFormat = new Format[((List)localObject5).size()];
        i = 0;
        while (i < arrayOfFormat.length)
        {
          arrayOfFormat[i] = ((com.google.android.exoplayer2.source.dash.manifest.g)((List)localObject5).get(i)).aSv;
          i += 1;
        }
        localObject5 = (com.google.android.exoplayer2.source.dash.manifest.a)paramList.get(arrayOfInt[0]);
        int i1 = localObject2[j];
        i2 = arrayOfBoolean[j];
        localObject3[k] = new p(arrayOfFormat);
        i = k + 1;
        localObject4[k] = new a(((com.google.android.exoplayer2.source.dash.manifest.a)localObject5).type, arrayOfInt, k, true, i1, i2);
        if (i1 == 0) {
          break label704;
        }
        localObject3[i] = new p(new Format[] { Format.j(((com.google.android.exoplayer2.source.dash.manifest.a)localObject5).id + ":emsg", "application/x-emsg") });
        localObject4[i] = new a(4, arrayOfInt, k, false, false, false);
        i += 1;
      }
      for (;;)
      {
        if (i2 != 0)
        {
          localObject3[i] = new p(new Format[] { Format.h(((com.google.android.exoplayer2.source.dash.manifest.a)localObject5).id + ":cea608", "application/cea-608") });
          localObject4[i] = new a(3, arrayOfInt, k, false, false, false);
          i += 1;
        }
        for (;;)
        {
          j += 1;
          k = i;
          break;
          paramList = Pair.create(new q((p[])localObject3), localObject4);
          AppMethodBeat.o(10459);
          return paramList;
        }
      }
    }
  }
  
  private static d x(List<d> paramList)
  {
    AppMethodBeat.i(10460);
    int i = 0;
    while (i < paramList.size())
    {
      d locald = (d)paramList.get(i);
      if ("urn:mpeg:dash:adaptation-set-switching:2016".equals(locald.bjo))
      {
        AppMethodBeat.o(10460);
        return locald;
      }
      i += 1;
    }
    AppMethodBeat.o(10460);
    return null;
  }
  
  public final void U(long paramLong)
  {
    AppMethodBeat.i(10454);
    com.google.android.exoplayer2.source.a.f[] arrayOff = this.bmY;
    int k = arrayOff.length;
    int i = 0;
    while (i < k)
    {
      com.google.android.exoplayer2.source.a.f localf = arrayOff[i];
      int j = 0;
      while (j < localf.bmJ.length)
      {
        localf.bmJ[j].b(paramLong, true, localf.bmB[j]);
        j += 1;
      }
      i += 1;
    }
    AppMethodBeat.o(10454);
  }
  
  public final long V(long paramLong)
  {
    AppMethodBeat.i(10458);
    com.google.android.exoplayer2.source.a.f[] arrayOff = this.bmY;
    int j = arrayOff.length;
    int i = 0;
    while (i < j)
    {
      arrayOff[i].af(paramLong);
      i += 1;
    }
    AppMethodBeat.o(10458);
    return paramLong;
  }
  
  public final boolean W(long paramLong)
  {
    AppMethodBeat.i(10455);
    boolean bool = this.bmZ.W(paramLong);
    AppMethodBeat.o(10455);
    return bool;
  }
  
  public final long a(com.google.android.exoplayer2.g.f[] paramArrayOff, boolean[] paramArrayOfBoolean1, m[] paramArrayOfm, boolean[] paramArrayOfBoolean2, long paramLong)
  {
    AppMethodBeat.i(10453);
    HashMap localHashMap = new HashMap();
    int j = 0;
    Object localObject1;
    label68:
    int m;
    Object localObject2;
    Object localObject3;
    int i;
    boolean bool1;
    boolean bool2;
    if (j < paramArrayOff.length) {
      if ((paramArrayOfm[j] instanceof com.google.android.exoplayer2.source.a.f))
      {
        localObject1 = (com.google.android.exoplayer2.source.a.f)paramArrayOfm[j];
        if ((paramArrayOff[j] == null) || (paramArrayOfBoolean1[j] == 0))
        {
          ((com.google.android.exoplayer2.source.a.f)localObject1).release();
          paramArrayOfm[j] = null;
        }
      }
      else if ((paramArrayOfm[j] == null) && (paramArrayOff[j] != null))
      {
        m = this.aRd.a(paramArrayOff[j].va());
        localObject2 = this.bmX[m];
        if (((a)localObject2).bnd)
        {
          localObject3 = paramArrayOff[j];
          i = 0;
          localObject1 = new int[2];
          bool1 = ((a)localObject2).bnf;
          if (bool1)
          {
            i = 1;
            localObject1[0] = 4;
          }
          bool2 = ((a)localObject2).bng;
          int k = i;
          if (bool2)
          {
            localObject1[i] = 3;
            k = i + 1;
          }
          if (k >= 2) {
            break label614;
          }
          localObject1 = Arrays.copyOf((int[])localObject1, k);
        }
      }
    }
    label468:
    label614:
    for (;;)
    {
      localObject3 = this.bmU.a(this.bmW, this.bna, this.blw, ((a)localObject2).bnc, (com.google.android.exoplayer2.g.f)localObject3, ((a)localObject2).aQq, this.bmV, bool1, bool2);
      localObject1 = new com.google.android.exoplayer2.source.a.f(((a)localObject2).aQq, (int[])localObject1, (com.google.android.exoplayer2.source.a.g)localObject3, this, this.bkM, paramLong, this.bkJ, this.bmE);
      localHashMap.put(Integer.valueOf(m), localObject1);
      paramArrayOfm[j] = localObject1;
      paramArrayOfBoolean2[j] = true;
      j += 1;
      break;
      localHashMap.put(Integer.valueOf(this.aRd.a(paramArrayOff[j].va())), localObject1);
      break label68;
      i = 0;
      if (i < paramArrayOff.length)
      {
        if ((((paramArrayOfm[i] instanceof f.a)) || ((paramArrayOfm[i] instanceof com.google.android.exoplayer2.source.f))) && ((paramArrayOff[i] == null) || (paramArrayOfBoolean1[i] == 0)))
        {
          a(paramArrayOfm[i]);
          paramArrayOfm[i] = null;
        }
        if (paramArrayOff[i] != null)
        {
          j = this.aRd.a(paramArrayOff[i].va());
          localObject1 = this.bmX[j];
          if (!((a)localObject1).bnd)
          {
            localObject2 = (com.google.android.exoplayer2.source.a.f)localHashMap.get(Integer.valueOf(((a)localObject1).bne));
            localObject3 = paramArrayOfm[i];
            if (localObject2 != null) {
              break label513;
            }
            bool1 = localObject3 instanceof com.google.android.exoplayer2.source.f;
            if (!bool1)
            {
              a((m)localObject3);
              if (localObject2 != null) {
                break label546;
              }
            }
          }
        }
        for (localObject1 = new com.google.android.exoplayer2.source.f();; localObject1 = ((com.google.android.exoplayer2.source.a.f)localObject2).b(paramLong, ((a)localObject1).aQq))
        {
          paramArrayOfm[i] = localObject1;
          paramArrayOfBoolean2[i] = true;
          i += 1;
          break;
          if (((localObject3 instanceof f.a)) && (((f.a)localObject3).bmM == localObject2))
          {
            bool1 = true;
            break label468;
          }
          bool1 = false;
          break label468;
        }
      }
      this.bmY = new com.google.android.exoplayer2.source.a.f[localHashMap.size()];
      localHashMap.values().toArray(this.bmY);
      this.bmZ = new com.google.android.exoplayer2.source.e(this.bmY);
      AppMethodBeat.o(10453);
      return paramLong;
    }
  }
  
  public final void a(com.google.android.exoplayer2.source.dash.manifest.b paramb, int paramInt)
  {
    AppMethodBeat.i(10451);
    this.bna = paramb;
    this.blw = paramInt;
    this.bnb = paramb.eL(paramInt).bnb;
    if (this.bmY != null)
    {
      com.google.android.exoplayer2.source.a.f[] arrayOff = this.bmY;
      int j = arrayOff.length;
      int i = 0;
      while (i < j)
      {
        ((a)arrayOff[i].bmC).a(paramb, paramInt);
        i += 1;
      }
      this.bkx.a(this);
    }
    AppMethodBeat.o(10451);
  }
  
  public final void a(i.a parama, long paramLong)
  {
    AppMethodBeat.i(10452);
    this.bkx = parama;
    parama.a(this);
    AppMethodBeat.o(10452);
  }
  
  public final void tA() {}
  
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
    AppMethodBeat.i(10457);
    long l = this.bmZ.tD();
    AppMethodBeat.o(10457);
    return l;
  }
  
  public final long tE()
  {
    AppMethodBeat.i(10456);
    long l = this.bmZ.tE();
    AppMethodBeat.o(10456);
    return l;
  }
  
  static final class a
  {
    public final int aQq;
    public final int[] bnc;
    public final boolean bnd;
    public final int bne;
    public final boolean bnf;
    public final boolean bng;
    
    public a(int paramInt1, int[] paramArrayOfInt, int paramInt2, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
    {
      this.aQq = paramInt1;
      this.bnc = paramArrayOfInt;
      this.bne = paramInt2;
      this.bnd = paramBoolean1;
      this.bnf = paramBoolean2;
      this.bng = paramBoolean3;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.source.dash.b
 * JD-Core Version:    0.7.0.1
 */