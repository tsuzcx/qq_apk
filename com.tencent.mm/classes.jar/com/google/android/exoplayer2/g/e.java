package com.google.android.exoplayer2.g;

import android.util.SparseArray;
import android.util.SparseBooleanArray;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.i.x;
import com.google.android.exoplayer2.s;
import com.google.android.exoplayer2.source.q;
import com.google.android.exoplayer2.source.r;
import com.google.android.exoplayer2.t;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Arrays;
import java.util.Map;

public abstract class e
  extends h
{
  private int aNr = 0;
  private final SparseArray<Map<r, b>> bnX = new SparseArray();
  private final SparseBooleanArray bnY = new SparseBooleanArray();
  public a bnZ;
  
  public final void Z(Object paramObject)
  {
    this.bnZ = ((a)paramObject);
  }
  
  public final i a(s[] paramArrayOfs, r paramr)
  {
    Object localObject4 = new int[paramArrayOfs.length + 1];
    Object localObject5 = new q[paramArrayOfs.length + 1][];
    int[][][] arrayOfInt = new int[paramArrayOfs.length + 1][][];
    int i = 0;
    while (i < localObject5.length)
    {
      localObject5[i] = new q[paramr.length];
      arrayOfInt[i] = new int[paramr.length][];
      i += 1;
    }
    Object localObject3 = new int[paramArrayOfs.length];
    i = 0;
    while (i < localObject3.length)
    {
      localObject3[i] = paramArrayOfs[i].qR();
      i += 1;
    }
    int k = 0;
    int j;
    int i1;
    int m;
    int i2;
    label235:
    Object localObject6;
    if (k < paramr.length)
    {
      localObject2 = paramr.bgK[k];
      j = paramArrayOfs.length;
      i1 = 0;
      i = 0;
      while (i < paramArrayOfs.length)
      {
        localObject1 = paramArrayOfs[i];
        m = 0;
        n = j;
        for (j = i1; m < ((q)localObject2).length; j = i1)
        {
          i2 = ((s)localObject1).b(localObject2.bgf[m]) & 0x7;
          i1 = j;
          if (i2 > j)
          {
            j = i;
            if (i2 == 4) {
              break label235;
            }
            i1 = i2;
            n = i;
          }
          m += 1;
        }
        i += 1;
        i1 = j;
        j = n;
      }
      if (j == paramArrayOfs.length) {
        localObject1 = new int[((q)localObject2).length];
      }
      for (;;)
      {
        i = localObject4[j];
        localObject5[j][i] = localObject2;
        arrayOfInt[j][i] = localObject1;
        localObject4[j] += 1;
        k += 1;
        break;
        localObject6 = paramArrayOfs[j];
        localObject1 = new int[((q)localObject2).length];
        i = 0;
        while (i < ((q)localObject2).length)
        {
          localObject1[i] = ((s)localObject6).b(localObject2.bgf[i]);
          i += 1;
        }
      }
    }
    Object localObject2 = new r[paramArrayOfs.length];
    Object localObject1 = new int[paramArrayOfs.length];
    i = 0;
    while (i < paramArrayOfs.length)
    {
      j = localObject4[i];
      localObject2[i] = new r((q[])Arrays.copyOf(localObject5[i], j));
      arrayOfInt[i] = ((int[][])Arrays.copyOf(arrayOfInt[i], j));
      localObject1[i] = paramArrayOfs[i].getTrackType();
      i += 1;
    }
    i = localObject4[paramArrayOfs.length];
    localObject5 = new r((q[])Arrays.copyOf(localObject5[paramArrayOfs.length], i));
    localObject4 = a(paramArrayOfs, (r[])localObject2, arrayOfInt);
    i = 0;
    Map localMap;
    if (i < paramArrayOfs.length)
    {
      if (this.bnY.get(i)) {
        localObject4[i] = null;
      }
      label579:
      for (;;)
      {
        i += 1;
        break;
        localObject6 = localObject2[i];
        localMap = (Map)this.bnX.get(i);
        if ((localMap != null) && (localMap.containsKey(localObject6))) {}
        for (j = 1;; j = 0)
        {
          if (j == 0) {
            break label579;
          }
          if ((b)((Map)this.bnX.get(i)).get(localObject6) != null) {
            break label581;
          }
          break;
        }
      }
      label581:
      throw null;
    }
    localObject3 = new a((int[])localObject1, (r[])localObject2, (int[])localObject3, arrayOfInt, (r)localObject5);
    localObject5 = new t[paramArrayOfs.length];
    i = 0;
    if (i < paramArrayOfs.length)
    {
      if (localObject4[i] != null) {}
      for (localObject1 = t.aNq;; localObject1 = null)
      {
        localObject5[i] = localObject1;
        i += 1;
        break;
      }
    }
    int n = this.aNr;
    if (n != 0)
    {
      m = -1;
      i = -1;
      j = 0;
      if (j >= paramArrayOfs.length) {
        break label928;
      }
      i1 = paramArrayOfs[j].getTrackType();
      localObject1 = localObject4[j];
      if (((i1 != 1) && (i1 != 2)) || (localObject1 == null)) {
        break label925;
      }
      localObject6 = arrayOfInt[j];
      localMap = localObject2[j];
      if (localObject1 != null) {
        break label816;
      }
      k = 0;
      label731:
      if (k == 0) {
        break label925;
      }
      if (i1 != 1) {
        break label902;
      }
      if (m == -1) {
        break label889;
      }
      j = 0;
    }
    for (;;)
    {
      label751:
      if ((m != -1) && (i != -1))
      {
        k = 1;
        label765:
        if ((k & j) != 0)
        {
          paramArrayOfs = new t(n);
          localObject5[m] = paramArrayOfs;
          localObject5[i] = paramArrayOfs;
        }
        return new i(paramr, new g((f[])localObject4), localObject3, (t[])localObject5);
        i2 = localMap.a(((f)localObject1).uz());
        k = 0;
        for (;;)
        {
          if (k >= ((f)localObject1).length()) {
            break label883;
          }
          if ((localObject6[i2][localObject1.fn(k)] & 0x20) != 32)
          {
            k = 0;
            break;
          }
          k += 1;
        }
        label883:
        k = 1;
        break label731;
        label889:
        m = j;
      }
      label902:
      label925:
      for (;;)
      {
        label816:
        j += 1;
        break;
        if (i != -1)
        {
          j = 0;
          break label751;
        }
        i = j;
        continue;
        k = 0;
        break label765;
      }
      label928:
      j = 1;
    }
  }
  
  protected abstract f[] a(s[] paramArrayOfs, r[] paramArrayOfr, int[][][] paramArrayOfInt);
  
  public static final class a
  {
    private final int[] boa;
    public final r[] bob;
    private final int[] boc;
    private final int[][][] bod;
    public final r boe;
    public final int length;
    
    a(int[] paramArrayOfInt1, r[] paramArrayOfr, int[] paramArrayOfInt2, int[][][] paramArrayOfInt, r paramr)
    {
      AppMethodBeat.i(92948);
      this.boa = paramArrayOfInt1;
      this.bob = paramArrayOfr;
      this.bod = paramArrayOfInt;
      this.boc = paramArrayOfInt2;
      this.boe = paramr;
      this.length = paramArrayOfr.length;
      AppMethodBeat.o(92948);
    }
    
    public final int bo(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(198581);
      int m = this.bob[paramInt1].bgK[paramInt2].length;
      Object localObject = new int[m];
      int j = 0;
      int i = 0;
      int k;
      if (j < m)
      {
        if (o(paramInt1, paramInt2, j) != 4) {
          break label237;
        }
        k = i + 1;
        localObject[i] = j;
        i = k;
      }
      label237:
      for (;;)
      {
        j += 1;
        break;
        int[] arrayOfInt = Arrays.copyOf((int[])localObject, i);
        localObject = null;
        j = 0;
        m = 0;
        k = 16;
        i = 0;
        while (j < arrayOfInt.length)
        {
          int n = arrayOfInt[j];
          String str = this.bob[paramInt1].bgK[paramInt2].bgf[n].aMQ;
          if (i == 0)
          {
            localObject = str;
            k = Math.min(k, this.bod[paramInt1][paramInt2][j] & 0x18);
            j += 1;
            i += 1;
          }
          else
          {
            if (!x.h(localObject, str)) {}
            for (n = 1;; n = 0)
            {
              m |= n;
              break;
            }
          }
        }
        if (m != 0)
        {
          paramInt1 = Math.min(k, this.boc[paramInt1]);
          AppMethodBeat.o(198581);
          return paramInt1;
        }
        AppMethodBeat.o(198581);
        return k;
      }
    }
    
    public final int o(int paramInt1, int paramInt2, int paramInt3)
    {
      return this.bod[paramInt1][paramInt2][paramInt3] & 0x7;
    }
  }
  
  public static final class b {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.google.android.exoplayer2.g.e
 * JD-Core Version:    0.7.0.1
 */