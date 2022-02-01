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
  private static final Comparator<a> abd = new Comparator() {};
  final int[] aaY;
  final List<b.d> aaZ;
  final TimingLogger aba = null;
  final b.b[] abb;
  private final float[] abc = new float[3];
  final int[] mColors;
  
  a(int[] paramArrayOfInt, int paramInt, b.b[] paramArrayOfb)
  {
    this.abb = paramArrayOfb;
    paramArrayOfb = new int[32768];
    this.aaY = paramArrayOfb;
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
        b.d(bp(i), this.abc);
        if (d(this.abc)) {
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
        this.aaZ = new ArrayList();
        i = paramArrayOfInt.length;
        paramInt = m;
        while (paramInt < i)
        {
          j = paramArrayOfInt[paramInt];
          this.aaZ.add(new b.d(bp(j), paramArrayOfb[j]));
          paramInt += 1;
        }
      }
      paramArrayOfInt = new PriorityQueue(paramInt, abd);
      paramArrayOfInt.offer(new a(0, this.mColors.length - 1));
      a(paramArrayOfInt, paramInt);
      this.aaZ = a(paramArrayOfInt);
      return;
    }
  }
  
  private List<b.d> a(Collection<a> paramCollection)
  {
    ArrayList localArrayList = new ArrayList(paramCollection.size());
    paramCollection = paramCollection.iterator();
    while (paramCollection.hasNext())
    {
      b.d locald = ((a)paramCollection.next()).hg();
      if (!d(locald.hn())) {
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
      if ((locala1 == null) || (!locala1.hc())) {
        break;
      }
      if (!locala1.hc()) {
        throw new IllegalStateException("Can not split a box with only 1 color");
      }
      int i = locala1.hf();
      a locala2 = new a(locala1.abo, i + 1, locala1.abf);
      locala1.abf = i;
      locala1.he();
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
  
  private static int bp(int paramInt)
  {
    return j(paramInt >> 10 & 0x1F, paramInt >> 5 & 0x1F, paramInt & 0x1F);
  }
  
  static int bq(int paramInt)
  {
    return paramInt >> 10 & 0x1F;
  }
  
  static int br(int paramInt)
  {
    return paramInt >> 5 & 0x1F;
  }
  
  static int bs(int paramInt)
  {
    return paramInt & 0x1F;
  }
  
  private boolean d(float[] paramArrayOfFloat)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    int j;
    int i;
    if (this.abb != null)
    {
      bool1 = bool2;
      if (this.abb.length > 0)
      {
        j = this.abb.length;
        i = 0;
      }
    }
    for (;;)
    {
      bool1 = bool2;
      if (i < j)
      {
        if (!this.abb[i].e(paramArrayOfFloat)) {
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
    private int abe;
    int abf;
    private int abg;
    private int abh;
    private int abj;
    private int abk;
    private int abl;
    private int abm;
    private int abn;
    
    a(int paramInt1, int paramInt2)
    {
      this.abe = paramInt1;
      this.abf = paramInt2;
      he();
    }
    
    private int hd()
    {
      return this.abf + 1 - this.abe;
    }
    
    final int getVolume()
    {
      return (this.abj - this.abh + 1) * (this.abl - this.abk + 1) * (this.abn - this.abm + 1);
    }
    
    final boolean hc()
    {
      return hd() > 1;
    }
    
    final void he()
    {
      int[] arrayOfInt1 = a.this.mColors;
      int[] arrayOfInt2 = a.this.aaY;
      int i4 = 0;
      int n = this.abe;
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
      if (n <= this.abf)
      {
        i1 = arrayOfInt1[n];
        i8 = i4 + arrayOfInt2[i1];
        int i7 = a.bq(i1);
        i6 = a.br(i1);
        i4 = a.bs(i1);
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
          this.abh = i3;
          this.abj = i5;
          this.abk = i;
          this.abl = j;
          this.abm = k;
          this.abn = m;
          this.abg = i4;
          return;
        }
      }
    }
    
    final int hf()
    {
      int i = this.abj - this.abh;
      int j = this.abl - this.abk;
      int k = this.abn - this.abm;
      int[] arrayOfInt1;
      int[] arrayOfInt2;
      if ((i >= j) && (i >= k))
      {
        i = -3;
        arrayOfInt1 = a.this.mColors;
        arrayOfInt2 = a.this.aaY;
        a.a(arrayOfInt1, i, this.abe, this.abf);
        Arrays.sort(arrayOfInt1, this.abe, this.abf + 1);
        a.a(arrayOfInt1, i, this.abe, this.abf);
        k = this.abg / 2;
        i = this.abe;
        j = 0;
      }
      for (;;)
      {
        if (i > this.abf) {
          break label180;
        }
        j += arrayOfInt2[arrayOfInt1[i]];
        if (j >= k)
        {
          return Math.min(this.abf - 1, i);
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
      return this.abe;
    }
    
    final b.d hg()
    {
      int[] arrayOfInt1 = a.this.mColors;
      int[] arrayOfInt2 = a.this.aaY;
      int j = this.abe;
      int n = 0;
      int i = 0;
      int k = 0;
      int m = 0;
      while (j <= this.abf)
      {
        int i2 = arrayOfInt1[j];
        int i1 = arrayOfInt2[i2];
        n += i1;
        m += a.bq(i2) * i1;
        k += a.br(i2) * i1;
        i2 = a.bs(i2);
        j += 1;
        i = i2 * i1 + i;
      }
      return new b.d(a.j(Math.round(m / n), Math.round(k / n), Math.round(i / n)), n);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     android.support.v7.d.a
 * JD-Core Version:    0.7.0.1
 */