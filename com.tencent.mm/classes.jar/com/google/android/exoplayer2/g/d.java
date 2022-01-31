package com.google.android.exoplayer2.g;

import android.util.SparseArray;
import android.util.SparseBooleanArray;
import com.google.android.exoplayer2.s;
import com.google.android.exoplayer2.source.l;
import com.google.android.exoplayer2.source.m;
import com.google.android.exoplayer2.t;
import java.util.Arrays;
import java.util.Map;

public abstract class d
  extends g
{
  private final SparseArray<Map<m, d.b>> aQx = new SparseArray();
  private final SparseBooleanArray aQy = new SparseBooleanArray();
  private d.a aQz;
  private int auW = 0;
  
  public final void Q(Object paramObject)
  {
    this.aQz = ((d.a)paramObject);
  }
  
  public final h a(s[] paramArrayOfs, m paramm)
  {
    Object localObject4 = new int[paramArrayOfs.length + 1];
    Object localObject6 = new l[paramArrayOfs.length + 1][];
    int[][][] arrayOfInt = new int[paramArrayOfs.length + 1][][];
    int i = 0;
    while (i < localObject6.length)
    {
      localObject6[i] = new l[paramm.length];
      arrayOfInt[i] = new int[paramm.length][];
      i += 1;
    }
    Object localObject3 = new int[paramArrayOfs.length];
    i = 0;
    while (i < localObject3.length)
    {
      localObject3[i] = paramArrayOfs[i].ky();
      i += 1;
    }
    int k = 0;
    int j;
    int i1;
    Object localObject1;
    int m;
    int i2;
    if (k < paramm.length)
    {
      localObject2 = paramm.aIZ[k];
      j = paramArrayOfs.length;
      i1 = 0;
      i = 0;
      while (i < paramArrayOfs.length)
      {
        localObject1 = paramArrayOfs[i];
        m = 0;
        n = j;
        for (j = i1; m < ((l)localObject2).length; j = i1)
        {
          i2 = ((s)localObject1).b(localObject2.aIs[m]) & 0x7;
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
        localObject1 = new int[((l)localObject2).length];
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
        localObject1 = new int[((l)localObject2).length];
        i = 0;
        while (i < ((l)localObject2).length)
        {
          localObject1[i] = ((s)localObject5).b(localObject2.aIs[i]);
          i += 1;
        }
      }
    }
    Object localObject2 = new m[paramArrayOfs.length];
    Object localObject5 = new int[paramArrayOfs.length];
    i = 0;
    while (i < paramArrayOfs.length)
    {
      j = localObject4[i];
      localObject2[i] = new m((l[])Arrays.copyOf(localObject6[i], j));
      arrayOfInt[i] = ((int[][])Arrays.copyOf(arrayOfInt[i], j));
      localObject5[i] = paramArrayOfs[i].getTrackType();
      i += 1;
    }
    i = localObject4[paramArrayOfs.length];
    localObject6 = new m((l[])Arrays.copyOf(localObject6[paramArrayOfs.length], i));
    localObject4 = a(paramArrayOfs, (m[])localObject2, arrayOfInt);
    i = 0;
    Object localObject7;
    if (i < paramArrayOfs.length)
    {
      if (this.aQy.get(i)) {
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
          localObject7 = (Map)this.aQx.get(i);
          if ((localObject7 != null) && (((Map)localObject7).containsKey(localObject1))) {}
          for (j = 1;; j = 0)
          {
            if (j == 0) {
              break label590;
            }
            localObject7 = (d.b)((Map)this.aQx.get(i)).get(localObject1);
            if (localObject7 != null) {
              break label592;
            }
            localObject1 = null;
            break;
          }
        }
        label592:
        localObject7 = ((d.b)localObject7).aQF;
        localObject1 = ((m)localObject1).aIZ;
        localObject1 = ((e.a)localObject7).nK();
      }
    }
    localObject3 = new d.a((int[])localObject5, (m[])localObject2, (int[])localObject3, arrayOfInt, (m)localObject6);
    localObject5 = new t[paramArrayOfs.length];
    i = 0;
    if (i < paramArrayOfs.length)
    {
      if (localObject4[i] != null) {}
      for (localObject1 = t.auV;; localObject1 = null)
      {
        localObject5[i] = localObject1;
        i += 1;
        break;
      }
    }
    int n = this.auW;
    if (n != 0)
    {
      m = -1;
      i = -1;
      j = 0;
      if (j >= paramArrayOfs.length) {
        break label963;
      }
      i1 = paramArrayOfs[j].getTrackType();
      localObject1 = localObject4[j];
      if (((i1 != 1) && (i1 != 2)) || (localObject1 == null)) {
        break label960;
      }
      localObject6 = arrayOfInt[j];
      localObject7 = localObject2[j];
      if (localObject1 != null) {
        break label851;
      }
      k = 0;
      label766:
      if (k == 0) {
        break label960;
      }
      if (i1 != 1) {
        break label937;
      }
      if (m == -1) {
        break label924;
      }
      j = 0;
    }
    for (;;)
    {
      label786:
      if ((m != -1) && (i != -1))
      {
        k = 1;
        label800:
        if ((k & j) != 0)
        {
          paramArrayOfs = new t(n);
          localObject5[m] = paramArrayOfs;
          localObject5[i] = paramArrayOfs;
        }
        return new h(paramm, new f((e[])localObject4), localObject3, (t[])localObject5);
        label851:
        i2 = ((m)localObject7).a(((e)localObject1).nH());
        k = 0;
        for (;;)
        {
          if (k >= ((e)localObject1).length()) {
            break label918;
          }
          if ((localObject6[i2][localObject1.du(k)] & 0x20) != 32)
          {
            k = 0;
            break;
          }
          k += 1;
        }
        label918:
        k = 1;
        break label766;
        label924:
        m = j;
      }
      label937:
      label960:
      for (;;)
      {
        j += 1;
        break;
        if (i != -1)
        {
          j = 0;
          break label786;
        }
        i = j;
        continue;
        k = 0;
        break label800;
      }
      label963:
      j = 1;
    }
  }
  
  protected abstract e[] a(s[] paramArrayOfs, m[] paramArrayOfm, int[][][] paramArrayOfInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.android.exoplayer2.g.d
 * JD-Core Version:    0.7.0.1
 */