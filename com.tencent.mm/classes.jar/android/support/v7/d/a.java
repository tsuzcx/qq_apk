package android.support.v7.d;

import android.graphics.Color;
import android.support.v4.graphics.b;
import android.util.TimingLogger;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.PriorityQueue;

public final class a
{
  private static final Comparator<a.a> Rg = new a.1();
  final int[] Aq;
  public final List<b.c> Rc;
  final TimingLogger Rd = null;
  final b.b[] Re;
  private final float[] Rf = new float[3];
  final int[] mHistogram;
  
  public a(int[] paramArrayOfInt, int paramInt, b.b[] paramArrayOfb)
  {
    this.Re = paramArrayOfb;
    paramArrayOfb = new int[32768];
    this.mHistogram = paramArrayOfb;
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
        b.d(aV(i), this.Rf);
        if (c(this.Rf)) {
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
    this.Aq = paramArrayOfInt;
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
        this.Rc = new ArrayList();
        i = paramArrayOfInt.length;
        paramInt = m;
        while (paramInt < i)
        {
          j = paramArrayOfInt[paramInt];
          this.Rc.add(new b.c(aV(j), paramArrayOfb[j]));
          paramInt += 1;
        }
      }
      paramArrayOfInt = new PriorityQueue(paramInt, Rg);
      paramArrayOfInt.offer(new a.a(this, 0, this.Aq.length - 1));
      a(paramArrayOfInt, paramInt);
      this.Rc = b(paramArrayOfInt);
      return;
    }
  }
  
  private static void a(PriorityQueue<a.a> paramPriorityQueue, int paramInt)
  {
    while (paramPriorityQueue.size() < paramInt)
    {
      a.a locala1 = (a.a)paramPriorityQueue.poll();
      if ((locala1 == null) || (!locala1.fd())) {
        break;
      }
      if (!locala1.fd()) {
        throw new IllegalStateException("Can not split a box with only 1 color");
      }
      int i = locala1.fg();
      a.a locala2 = new a.a(locala1.Rq, i + 1, locala1.Ri);
      locala1.Ri = i;
      locala1.ff();
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
  
  private static int aV(int paramInt)
  {
    return i(paramInt >> 10 & 0x1F, paramInt >> 5 & 0x1F, paramInt & 0x1F);
  }
  
  static int aW(int paramInt)
  {
    return paramInt >> 10 & 0x1F;
  }
  
  static int aX(int paramInt)
  {
    return paramInt >> 5 & 0x1F;
  }
  
  static int aY(int paramInt)
  {
    return paramInt & 0x1F;
  }
  
  private List<b.c> b(Collection<a.a> paramCollection)
  {
    ArrayList localArrayList = new ArrayList(paramCollection.size());
    paramCollection = paramCollection.iterator();
    while (paramCollection.hasNext())
    {
      b.c localc = ((a.a)paramCollection.next()).fh();
      if (!c(localc.fj())) {
        localArrayList.add(localc);
      }
    }
    return localArrayList;
  }
  
  private boolean c(float[] paramArrayOfFloat)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    int j;
    int i;
    if (this.Re != null)
    {
      bool1 = bool2;
      if (this.Re.length > 0)
      {
        j = this.Re.length;
        i = 0;
      }
    }
    for (;;)
    {
      bool1 = bool2;
      if (i < j)
      {
        if (!this.Re[i].d(paramArrayOfFloat)) {
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