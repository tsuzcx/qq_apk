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
  private static final Comparator<a> aaQ = new Comparator() {};
  final int[] aaL;
  final List<b.d> aaM;
  final TimingLogger aaN = null;
  final b.b[] aaO;
  private final float[] aaP = new float[3];
  final int[] mColors;
  
  a(int[] paramArrayOfInt, int paramInt, b.b[] paramArrayOfb)
  {
    this.aaO = paramArrayOfb;
    paramArrayOfb = new int[32768];
    this.aaL = paramArrayOfb;
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
        b.d(bo(i), this.aaP);
        if (d(this.aaP)) {
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
        this.aaM = new ArrayList();
        i = paramArrayOfInt.length;
        paramInt = m;
        while (paramInt < i)
        {
          j = paramArrayOfInt[paramInt];
          this.aaM.add(new b.d(bo(j), paramArrayOfb[j]));
          paramInt += 1;
        }
      }
      paramArrayOfInt = new PriorityQueue(paramInt, aaQ);
      paramArrayOfInt.offer(new a(0, this.mColors.length - 1));
      a(paramArrayOfInt, paramInt);
      this.aaM = a(paramArrayOfInt);
      return;
    }
  }
  
  private List<b.d> a(Collection<a> paramCollection)
  {
    ArrayList localArrayList = new ArrayList(paramCollection.size());
    paramCollection = paramCollection.iterator();
    while (paramCollection.hasNext())
    {
      b.d locald = ((a)paramCollection.next()).gZ();
      if (!d(locald.he())) {
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
      if ((locala1 == null) || (!locala1.gV())) {
        break;
      }
      if (!locala1.gV()) {
        throw new IllegalStateException("Can not split a box with only 1 color");
      }
      int i = locala1.gY();
      a locala2 = new a(locala1.aba, i + 1, locala1.aaS);
      locala1.aaS = i;
      locala1.gX();
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
    if (this.aaO != null)
    {
      bool1 = bool2;
      if (this.aaO.length > 0)
      {
        j = this.aaO.length;
        i = 0;
      }
    }
    for (;;)
    {
      bool1 = bool2;
      if (i < j)
      {
        if (!this.aaO[i].e(paramArrayOfFloat)) {
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
    private int aaR;
    int aaS;
    private int aaT;
    private int aaU;
    private int aaV;
    private int aaW;
    private int aaX;
    private int aaY;
    private int aaZ;
    
    a(int paramInt1, int paramInt2)
    {
      this.aaR = paramInt1;
      this.aaS = paramInt2;
      gX();
    }
    
    private int gW()
    {
      return this.aaS + 1 - this.aaR;
    }
    
    final boolean gV()
    {
      return gW() > 1;
    }
    
    final void gX()
    {
      int[] arrayOfInt1 = a.this.mColors;
      int[] arrayOfInt2 = a.this.aaL;
      int i4 = 0;
      int n = this.aaR;
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
      if (n <= this.aaS)
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
          this.aaU = i3;
          this.aaV = i5;
          this.aaW = i;
          this.aaX = j;
          this.aaY = k;
          this.aaZ = m;
          this.aaT = i4;
          return;
        }
      }
    }
    
    final int gY()
    {
      int i = this.aaV - this.aaU;
      int j = this.aaX - this.aaW;
      int k = this.aaZ - this.aaY;
      int[] arrayOfInt1;
      int[] arrayOfInt2;
      if ((i >= j) && (i >= k))
      {
        i = -3;
        arrayOfInt1 = a.this.mColors;
        arrayOfInt2 = a.this.aaL;
        a.a(arrayOfInt1, i, this.aaR, this.aaS);
        Arrays.sort(arrayOfInt1, this.aaR, this.aaS + 1);
        a.a(arrayOfInt1, i, this.aaR, this.aaS);
        k = this.aaT / 2;
        i = this.aaR;
        j = 0;
      }
      for (;;)
      {
        if (i > this.aaS) {
          break label180;
        }
        j += arrayOfInt2[arrayOfInt1[i]];
        if (j >= k)
        {
          return Math.min(this.aaS - 1, i);
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
      return this.aaR;
    }
    
    final b.d gZ()
    {
      int[] arrayOfInt1 = a.this.mColors;
      int[] arrayOfInt2 = a.this.aaL;
      int j = this.aaR;
      int n = 0;
      int i = 0;
      int k = 0;
      int m = 0;
      while (j <= this.aaS)
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
      return (this.aaV - this.aaU + 1) * (this.aaX - this.aaW + 1) * (this.aaZ - this.aaY + 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     android.support.v7.d.a
 * JD-Core Version:    0.7.0.1
 */