package android.support.v7.d;

import android.graphics.Color;
import android.support.v4.graphics.b;
import android.util.TimingLogger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.PriorityQueue;

final class a
{
  private static final Comparator<a> Zb = new Comparator() {};
  final int[] YW;
  final List<b.d> YX;
  final TimingLogger YY = null;
  final b.b[] YZ;
  private final float[] Za = new float[3];
  final int[] mColors;
  
  a(int[] paramArrayOfInt, int paramInt, b.b[] paramArrayOfb)
  {
    this.YZ = paramArrayOfb;
    paramArrayOfb = new int[32768];
    this.YW = paramArrayOfb;
    int i = 0;
    int n;
    while (i < paramArrayOfInt.length)
    {
      j = paramArrayOfInt[i];
      k = k(Color.red(j), 8, 5);
      n = k(Color.green(j), 8, 5);
      j = k(Color.blue(j), 8, 5) | k << 10 | n << 5;
      paramArrayOfInt[i] = j;
      paramArrayOfb[j] += 1;
      i += 1;
    }
    i = 0;
    for (int j = 0; i < 32768; j = k)
    {
      if (paramArrayOfb[i] > 0)
      {
        b.d(bo(i), this.Za);
        if (d(this.Za)) {
          paramArrayOfb[i] = 0;
        }
      }
      k = j;
      if (paramArrayOfb[i] > 0) {
        k = j + 1;
      }
      i += 1;
    }
    paramArrayOfInt = new int[j];
    this.mColors = paramArrayOfInt;
    int k = 0;
    i = 0;
    if (k < 32768)
    {
      if (paramArrayOfb[k] <= 0) {
        break label374;
      }
      n = i + 1;
      paramArrayOfInt[i] = k;
      i = n;
    }
    label374:
    for (;;)
    {
      k += 1;
      break;
      if (j <= paramInt)
      {
        this.YX = new ArrayList();
        i = paramArrayOfInt.length;
        paramInt = m;
        while (paramInt < i)
        {
          j = paramArrayOfInt[paramInt];
          this.YX.add(new b.d(bo(j), paramArrayOfb[j]));
          paramInt += 1;
        }
      }
      paramArrayOfInt = new PriorityQueue(paramInt, Zb);
      paramArrayOfInt.offer(new a(0, this.mColors.length - 1));
      a(paramArrayOfInt, paramInt);
      this.YX = a(paramArrayOfInt);
      return;
    }
  }
  
  private List<b.d> a(Collection<a> paramCollection)
  {
    ArrayList localArrayList = new ArrayList(paramCollection.size());
    paramCollection = paramCollection.iterator();
    while (paramCollection.hasNext())
    {
      b.d locald = ((a)paramCollection.next()).gI();
      if (!d(locald.gN())) {
        localArrayList.add(locald);
      }
    }
    return localArrayList;
  }
  
  private static void a(PriorityQueue<a> paramPriorityQueue, int paramInt)
  {
    while (paramPriorityQueue.size() < paramInt)
    {
      a locala1 = (a)paramPriorityQueue.poll();
      if ((locala1 == null) || (!locala1.gE())) {
        break;
      }
      if (!locala1.gE()) {
        throw new IllegalStateException("Can not split a box with only 1 color");
      }
      int i = locala1.gH();
      a locala2 = new a(locala1.Zl, i + 1, locala1.Zd);
      locala1.Zd = i;
      locala1.gG();
      paramPriorityQueue.offer(locala2);
      paramPriorityQueue.offer(locala1);
    }
  }
  
  static void a(int[] paramArrayOfInt, int paramInt1, int paramInt2, int paramInt3)
  {
    int i = paramInt2;
    switch (paramInt1)
    {
    }
    for (;;)
    {
      return;
      while (i <= paramInt3)
      {
        paramInt1 = paramArrayOfInt[i];
        paramArrayOfInt[i] = (paramInt1 & 0x1F | (paramInt1 >> 5 & 0x1F) << 10 | (paramInt1 >> 10 & 0x1F) << 5);
        i += 1;
      }
      while (paramInt2 <= paramInt3)
      {
        paramInt1 = paramArrayOfInt[paramInt2];
        paramArrayOfInt[paramInt2] = (paramInt1 >> 10 & 0x1F | (paramInt1 & 0x1F) << 10 | (paramInt1 >> 5 & 0x1F) << 5);
        paramInt2 += 1;
      }
    }
  }
  
  private static int bo(int paramInt)
  {
    return j(paramInt >> 10 & 0x1F, paramInt >> 5 & 0x1F, paramInt & 0x1F);
  }
  
  static int bp(int paramInt)
  {
    return paramInt >> 10 & 0x1F;
  }
  
  static int bq(int paramInt)
  {
    return paramInt >> 5 & 0x1F;
  }
  
  static int br(int paramInt)
  {
    return paramInt & 0x1F;
  }
  
  private boolean d(float[] paramArrayOfFloat)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    int j;
    int i;
    if (this.YZ != null)
    {
      bool1 = bool2;
      if (this.YZ.length > 0)
      {
        j = this.YZ.length;
        i = 0;
      }
    }
    for (;;)
    {
      bool1 = bool2;
      if (i < j)
      {
        if (!this.YZ[i].e(paramArrayOfFloat)) {
          bool1 = true;
        }
      }
      else {
        return bool1;
      }
      i += 1;
    }
  }
  
  static int j(int paramInt1, int paramInt2, int paramInt3)
  {
    return Color.rgb(k(paramInt1, 5, 8), k(paramInt2, 5, 8), k(paramInt3, 5, 8));
  }
  
  private static int k(int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramInt3 > paramInt2) {
      paramInt1 <<= paramInt3 - paramInt2;
    }
    for (;;)
    {
      return paramInt1 & (1 << paramInt3) - 1;
      paramInt1 >>= paramInt2 - paramInt3;
    }
  }
  
  final class a
  {
    private int Zc;
    int Zd;
    private int Ze;
    private int Zf;
    private int Zg;
    private int Zh;
    private int Zi;
    private int Zj;
    private int Zk;
    
    a(int paramInt1, int paramInt2)
    {
      this.Zc = paramInt1;
      this.Zd = paramInt2;
      gG();
    }
    
    private int gF()
    {
      return this.Zd + 1 - this.Zc;
    }
    
    final boolean gE()
    {
      return gF() > 1;
    }
    
    final void gG()
    {
      int[] arrayOfInt1 = a.this.mColors;
      int[] arrayOfInt2 = a.this.YW;
      int i4 = 0;
      int n = this.Zc;
      int i5 = -2147483648;
      int j = -2147483648;
      int m = -2147483648;
      int i3 = 2147483647;
      int i = 2147483647;
      int k = 2147483647;
      int i1;
      int i8;
      int i6;
      int i2;
      if (n <= this.Zd)
      {
        i1 = arrayOfInt1[n];
        i8 = i4 + arrayOfInt2[i1];
        int i7 = a.bp(i1);
        i6 = a.bq(i1);
        i4 = a.br(i1);
        i1 = i5;
        if (i7 > i5) {
          i1 = i7;
        }
        i2 = i3;
        if (i7 < i3) {
          i2 = i7;
        }
        if (i6 <= j) {
          break label242;
        }
        j = i6;
      }
      label242:
      for (;;)
      {
        if (i6 < i) {
          i = i6;
        }
        for (;;)
        {
          i3 = m;
          if (i4 > m) {
            i3 = i4;
          }
          i6 = k;
          if (i4 < k) {
            i6 = i4;
          }
          n += 1;
          i4 = i8;
          i5 = i1;
          m = i3;
          i3 = i2;
          k = i6;
          break;
          this.Zf = i3;
          this.Zg = i5;
          this.Zh = i;
          this.Zi = j;
          this.Zj = k;
          this.Zk = m;
          this.Ze = i4;
          return;
        }
      }
    }
    
    final int gH()
    {
      int i = this.Zg - this.Zf;
      int j = this.Zi - this.Zh;
      int k = this.Zk - this.Zj;
      int[] arrayOfInt1;
      int[] arrayOfInt2;
      if ((i >= j) && (i >= k))
      {
        i = -3;
        arrayOfInt1 = a.this.mColors;
        arrayOfInt2 = a.this.YW;
        a.a(arrayOfInt1, i, this.Zc, this.Zd);
        Arrays.sort(arrayOfInt1, this.Zc, this.Zd + 1);
        a.a(arrayOfInt1, i, this.Zc, this.Zd);
        k = this.Ze / 2;
        i = this.Zc;
        j = 0;
      }
      for (;;)
      {
        if (i > this.Zd) {
          break label180;
        }
        j += arrayOfInt2[arrayOfInt1[i]];
        if (j >= k)
        {
          return Math.min(this.Zd - 1, i);
          if ((j >= i) && (j >= k))
          {
            i = -2;
            break;
          }
          i = -1;
          break;
        }
        i += 1;
      }
      label180:
      return this.Zc;
    }
    
    final b.d gI()
    {
      int[] arrayOfInt1 = a.this.mColors;
      int[] arrayOfInt2 = a.this.YW;
      int j = this.Zc;
      int n = 0;
      int i = 0;
      int k = 0;
      int m = 0;
      while (j <= this.Zd)
      {
        int i2 = arrayOfInt1[j];
        int i1 = arrayOfInt2[i2];
        n += i1;
        m += a.bp(i2) * i1;
        k += a.bq(i2) * i1;
        i2 = a.br(i2);
        j += 1;
        i = i2 * i1 + i;
      }
      return new b.d(a.j(Math.round(m / n), Math.round(k / n), Math.round(i / n)), n);
    }
    
    final int getVolume()
    {
      return (this.Zg - this.Zf + 1) * (this.Zi - this.Zh + 1) * (this.Zk - this.Zj + 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     android.support.v7.d.a
 * JD-Core Version:    0.7.0.1
 */