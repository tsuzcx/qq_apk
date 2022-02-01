package com.google.android.exoplayer2.g;

import android.util.SparseArray;
import android.util.SparseBooleanArray;
import com.google.android.exoplayer2.s;
import com.google.android.exoplayer2.source.p;
import com.google.android.exoplayer2.source.q;
import com.google.android.exoplayer2.t;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Arrays;
import java.util.Map;

public abstract class e
  extends h
{
  private int aSG = 0;
  private final SparseArray<Map<q, b>> bwd = new SparseArray();
  private final SparseBooleanArray bwe = new SparseBooleanArray();
  private a bwf;
  
  public final i a(s[] paramArrayOfs, q paramq)
  {
    Object localObject4 = new int[paramArrayOfs.length + 1];
    Object localObject6 = new p[paramArrayOfs.length + 1][];
    int[][][] arrayOfInt = new int[paramArrayOfs.length + 1][][];
    int i = 0;
    while (i < localObject6.length)
    {
      localObject6[i] = new p[paramq.length];
      arrayOfInt[i] = new int[paramq.length][];
      i += 1;
    }
    Object localObject3 = new int[paramArrayOfs.length];
    i = 0;
    while (i < localObject3.length)
    {
      localObject3[i] = paramArrayOfs[i].ro();
      i += 1;
    }
    int k = 0;
    int j;
    int i1;
    Object localObject1;
    int m;
    int i2;
    if (k < paramq.length)
    {
      localObject2 = paramq.bmh[k];
      j = paramArrayOfs.length;
      i1 = 0;
      i = 0;
      while (i < paramArrayOfs.length)
      {
        localObject1 = paramArrayOfs[i];
        m = 0;
        n = j;
        for (j = i1; m < ((p)localObject2).length; j = i1)
        {
          i2 = ((s)localObject1).b(localObject2.blC[m]) & 0x7;
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
      label235:
      if (j == paramArrayOfs.length) {
        localObject1 = new int[((p)localObject2).length];
      }
      for (;;)
      {
        i = localObject4[j];
        localObject6[j][i] = localObject2;
        arrayOfInt[j][i] = localObject1;
        localObject4[j] += 1;
        k += 1;
        break;
        localObject5 = paramArrayOfs[j];
        localObject1 = new int[((p)localObject2).length];
        i = 0;
        while (i < ((p)localObject2).length)
        {
          localObject1[i] = ((s)localObject5).b(localObject2.blC[i]);
          i += 1;
        }
      }
    }
    Object localObject2 = new q[paramArrayOfs.length];
    Object localObject5 = new int[paramArrayOfs.length];
    i = 0;
    while (i < paramArrayOfs.length)
    {
      j = localObject4[i];
      localObject2[i] = new q((p[])Arrays.copyOf(localObject6[i], j));
      arrayOfInt[i] = ((int[][])Arrays.copyOf(arrayOfInt[i], j));
      localObject5[i] = paramArrayOfs[i].getTrackType();
      i += 1;
    }
    i = localObject4[paramArrayOfs.length];
    localObject6 = new q((p[])Arrays.copyOf(localObject6[paramArrayOfs.length], i));
    localObject4 = a(paramArrayOfs, (q[])localObject2, arrayOfInt);
    i = 0;
    Object localObject7;
    if (i < paramArrayOfs.length)
    {
      if (this.bwe.get(i)) {
        localObject1 = null;
      }
      for (;;)
      {
        localObject4[i] = localObject1;
        label590:
        for (;;)
        {
          i += 1;
          break;
          localObject1 = localObject2[i];
          localObject7 = (Map)this.bwd.get(i);
          if ((localObject7 != null) && (((Map)localObject7).containsKey(localObject1))) {}
          for (j = 1;; j = 0)
          {
            if (j == 0) {
              break label590;
            }
            localObject7 = (b)((Map)this.bwd.get(i)).get(localObject1);
            if (localObject7 != null) {
              break label592;
            }
            localObject1 = null;
            break;
          }
        }
        label592:
        f.a locala = ((b)localObject7).bwl;
        j = ((b)localObject7).bwm;
        localObject1 = locala.a(localObject1.bmh[j], ((b)localObject7).bvO);
      }
    }
    localObject3 = new a((int[])localObject5, (q[])localObject2, (int[])localObject3, arrayOfInt, (q)localObject6);
    localObject5 = new t[paramArrayOfs.length];
    i = 0;
    if (i < paramArrayOfs.length)
    {
      if (localObject4[i] != null) {}
      for (localObject1 = t.aSF;; localObject1 = null)
      {
        localObject5[i] = localObject1;
        i += 1;
        break;
      }
    }
    int n = this.aSG;
    if (n != 0)
    {
      m = -1;
      i = -1;
      j = 0;
      if (j >= paramArrayOfs.length) {
        break label976;
      }
      i1 = paramArrayOfs[j].getTrackType();
      localObject1 = localObject4[j];
      if (((i1 != 1) && (i1 != 2)) || (localObject1 == null)) {
        break label973;
      }
      localObject6 = arrayOfInt[j];
      localObject7 = localObject2[j];
      if (localObject1 != null) {
        break label864;
      }
      k = 0;
      label779:
      if (k == 0) {
        break label973;
      }
      if (i1 != 1) {
        break label950;
      }
      if (m == -1) {
        break label937;
      }
      j = 0;
    }
    for (;;)
    {
      label799:
      if ((m != -1) && (i != -1))
      {
        k = 1;
        label813:
        if ((k & j) != 0)
        {
          paramArrayOfs = new t(n);
          localObject5[m] = paramArrayOfs;
          localObject5[i] = paramArrayOfs;
        }
        return new i(paramq, new g((f[])localObject4), localObject3, (t[])localObject5);
        label864:
        i2 = ((q)localObject7).a(((f)localObject1).va());
        k = 0;
        for (;;)
        {
          if (k >= ((f)localObject1).length()) {
            break label931;
          }
          if ((localObject6[i2][localObject1.ff(k)] & 0x20) != 32)
          {
            k = 0;
            break;
          }
          k += 1;
        }
        label931:
        k = 1;
        break label779;
        label937:
        m = j;
      }
      label950:
      label973:
      for (;;)
      {
        j += 1;
        break;
        if (i != -1)
        {
          j = 0;
          break label799;
        }
        i = j;
        continue;
        k = 0;
        break label813;
      }
      label976:
      j = 1;
    }
  }
  
  protected abstract f[] a(s[] paramArrayOfs, q[] paramArrayOfq, int[][][] paramArrayOfInt);
  
  public final void ad(Object paramObject)
  {
    this.bwf = ((a)paramObject);
  }
  
  public static final class a
  {
    private final int[] bwg;
    private final q[] bwh;
    private final int[] bwi;
    private final int[][][] bwj;
    private final q bwk;
    public final int length;
    
    a(int[] paramArrayOfInt1, q[] paramArrayOfq, int[] paramArrayOfInt2, int[][][] paramArrayOfInt, q paramq)
    {
      AppMethodBeat.i(92948);
      this.bwg = paramArrayOfInt1;
      this.bwh = paramArrayOfq;
      this.bwj = paramArrayOfInt;
      this.bwi = paramArrayOfInt2;
      this.bwk = paramq;
      this.length = paramArrayOfq.length;
      AppMethodBeat.o(92948);
    }
  }
  
  public static final class b
  {
    public final int[] bvO;
    public final f.a bwl;
    public final int bwm;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.g.e
 * JD-Core Version:    0.7.0.1
 */