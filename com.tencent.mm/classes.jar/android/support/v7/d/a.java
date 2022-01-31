package android.support.v7.d;

import android.graphics.Color;
import android.support.v4.a.b;
import android.util.TimingLogger;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.PriorityQueue;

public final class a
{
  private static final Comparator<a.a> Rz = new a.1();
  final int[] Jq;
  final int[] Ru;
  public final List<b.c> Rv;
  final TimingLogger Rw = null;
  final b.b[] Rx;
  private final float[] Ry = new float[3];
  
  public a(int[] paramArrayOfInt, int paramInt, b.b[] paramArrayOfb)
  {
    this.Rx = paramArrayOfb;
    paramArrayOfb = new int[32768];
    this.Ru = paramArrayOfb;
    int i = 0;
    int n;
    while (i < paramArrayOfInt.length)
    {
      j = paramArrayOfInt[i];
      k = j(Color.red(j), 8, 5);
      n = j(Color.green(j), 8, 5);
      j = j(Color.blue(j), 8, 5) | k << 10 | n << 5;
      paramArrayOfInt[i] = j;
      paramArrayOfb[j] += 1;
      i += 1;
    }
    i = 0;
    for (int j = 0; i < 32768; j = k)
    {
      if (paramArrayOfb[i] > 0)
      {
        b.d(aZ(i), this.Ry);
        if (c(this.Ry)) {
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
    this.Jq = paramArrayOfInt;
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
        this.Rv = new ArrayList();
        i = paramArrayOfInt.length;
        paramInt = m;
        while (paramInt < i)
        {
          j = paramArrayOfInt[paramInt];
          this.Rv.add(new b.c(aZ(j), paramArrayOfb[j]));
          paramInt += 1;
        }
      }
      paramArrayOfInt = new PriorityQueue(paramInt, Rz);
      paramArrayOfInt.offer(new a.a(this, 0, this.Jq.length - 1));
      a(paramArrayOfInt, paramInt);
      this.Rv = b(paramArrayOfInt);
      return;
    }
  }
  
  private static void a(PriorityQueue<a.a> paramPriorityQueue, int paramInt)
  {
    while (paramPriorityQueue.size() < paramInt)
    {
      a.a locala1 = (a.a)paramPriorityQueue.poll();
      if ((locala1 == null) || (!locala1.ez())) {
        break;
      }
      if (!locala1.ez()) {
        throw new IllegalStateException("Can not split a box with only 1 color");
      }
      int i = locala1.eB();
      a.a locala2 = new a.a(locala1.RJ, i + 1, locala1.RB);
      locala1.RB = i;
      locala1.eA();
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
  
  private static int aZ(int paramInt)
  {
    return i(paramInt >> 10 & 0x1F, paramInt >> 5 & 0x1F, paramInt & 0x1F);
  }
  
  private List<b.c> b(Collection<a.a> paramCollection)
  {
    ArrayList localArrayList = new ArrayList(paramCollection.size());
    paramCollection = paramCollection.iterator();
    while (paramCollection.hasNext())
    {
      b.c localc = ((a.a)paramCollection.next()).eC();
      if (!c(localc.eE())) {
        localArrayList.add(localc);
      }
    }
    return localArrayList;
  }
  
  static int ba(int paramInt)
  {
    return paramInt >> 10 & 0x1F;
  }
  
  static int bb(int paramInt)
  {
    return paramInt >> 5 & 0x1F;
  }
  
  static int bc(int paramInt)
  {
    return paramInt & 0x1F;
  }
  
  private boolean c(float[] paramArrayOfFloat)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    int j;
    int i;
    if (this.Rx != null)
    {
      bool1 = bool2;
      if (this.Rx.length > 0)
      {
        j = this.Rx.length;
        i = 0;
      }
    }
    for (;;)
    {
      bool1 = bool2;
      if (i < j)
      {
        if (!this.Rx[i].d(paramArrayOfFloat)) {
          bool1 = true;
        }
      }
      else {
        return bool1;
      }
      i += 1;
    }
  }
  
  static int i(int paramInt1, int paramInt2, int paramInt3)
  {
    return Color.rgb(j(paramInt1, 5, 8), j(paramInt2, 5, 8), j(paramInt3, 5, 8));
  }
  
  private static int j(int paramInt1, int paramInt2, int paramInt3)
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     android.support.v7.d.a
 * JD-Core Version:    0.7.0.1
 */