package androidx.j.a;

import android.graphics.Color;
import android.util.TimingLogger;
import androidx.core.graphics.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.PriorityQueue;

final class a
{
  private static final Comparator<a> bSO;
  final int[] bSJ;
  final List<b.d> bSK;
  final TimingLogger bSL;
  final b.b[] bSM;
  private final float[] bSN;
  final int[] mColors;
  
  static
  {
    AppMethodBeat.i(192849);
    bSO = new Comparator() {};
    AppMethodBeat.o(192849);
  }
  
  a(int[] paramArrayOfInt, int paramInt, b.b[] paramArrayOfb)
  {
    AppMethodBeat.i(192733);
    this.bSN = new float[3];
    this.bSL = null;
    this.bSM = paramArrayOfb;
    paramArrayOfb = new int[32768];
    this.bSJ = paramArrayOfb;
    int i = 0;
    int n;
    while (i < paramArrayOfInt.length)
    {
      j = paramArrayOfInt[i];
      k = v(Color.red(j), 8, 5);
      n = v(Color.green(j), 8, 5);
      j = v(Color.blue(j), 8, 5) | k << 10 | n << 5;
      paramArrayOfInt[i] = j;
      paramArrayOfb[j] += 1;
      i += 1;
    }
    i = 0;
    for (int j = 0; i < 32768; j = k)
    {
      if (paramArrayOfb[i] > 0)
      {
        b.d(fq(i), this.bSN);
        if (m(this.bSN)) {
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
        break label390;
      }
      n = i + 1;
      paramArrayOfInt[i] = k;
      i = n;
    }
    label390:
    for (;;)
    {
      k += 1;
      break;
      if (j <= paramInt)
      {
        this.bSK = new ArrayList();
        i = paramArrayOfInt.length;
        paramInt = m;
        while (paramInt < i)
        {
          j = paramArrayOfInt[paramInt];
          this.bSK.add(new b.d(fq(j), paramArrayOfb[j]));
          paramInt += 1;
        }
        AppMethodBeat.o(192733);
        return;
      }
      paramArrayOfInt = new PriorityQueue(paramInt, bSO);
      paramArrayOfInt.offer(new a(0, this.mColors.length - 1));
      a(paramArrayOfInt, paramInt);
      this.bSK = p(paramArrayOfInt);
      AppMethodBeat.o(192733);
      return;
    }
  }
  
  private static void a(PriorityQueue<a> paramPriorityQueue, int paramInt)
  {
    AppMethodBeat.i(192749);
    while (paramPriorityQueue.size() < paramInt)
    {
      a locala1 = (a)paramPriorityQueue.poll();
      if ((locala1 != null) && (locala1.Iu()))
      {
        if (!locala1.Iu())
        {
          paramPriorityQueue = new IllegalStateException("Can not split a box with only 1 color");
          AppMethodBeat.o(192749);
          throw paramPriorityQueue;
        }
        int i = locala1.Ix();
        a locala2 = new a(locala1.bSY, i + 1, locala1.bSQ);
        locala1.bSQ = i;
        locala1.Iw();
        paramPriorityQueue.offer(locala2);
        paramPriorityQueue.offer(locala1);
      }
      else
      {
        AppMethodBeat.o(192749);
        return;
      }
    }
    AppMethodBeat.o(192749);
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
  
  private static int fq(int paramInt)
  {
    AppMethodBeat.i(192800);
    paramInt = u(paramInt >> 10 & 0x1F, paramInt >> 5 & 0x1F, paramInt & 0x1F);
    AppMethodBeat.o(192800);
    return paramInt;
  }
  
  static int fr(int paramInt)
  {
    return paramInt >> 10 & 0x1F;
  }
  
  static int fs(int paramInt)
  {
    return paramInt >> 5 & 0x1F;
  }
  
  static int ft(int paramInt)
  {
    return paramInt & 0x1F;
  }
  
  private boolean m(float[] paramArrayOfFloat)
  {
    AppMethodBeat.i(192782);
    if ((this.bSM != null) && (this.bSM.length > 0))
    {
      int j = this.bSM.length;
      int i = 0;
      while (i < j)
      {
        if (!this.bSM[i].n(paramArrayOfFloat))
        {
          AppMethodBeat.o(192782);
          return true;
        }
        i += 1;
      }
    }
    AppMethodBeat.o(192782);
    return false;
  }
  
  private List<b.d> p(Collection<a> paramCollection)
  {
    AppMethodBeat.i(192761);
    ArrayList localArrayList = new ArrayList(paramCollection.size());
    paramCollection = paramCollection.iterator();
    while (paramCollection.hasNext())
    {
      b.d locald = ((a)paramCollection.next()).Iy();
      if (!m(locald.IF())) {
        localArrayList.add(locald);
      }
    }
    AppMethodBeat.o(192761);
    return localArrayList;
  }
  
  static int u(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(192791);
    paramInt1 = Color.rgb(v(paramInt1, 5, 8), v(paramInt2, 5, 8), v(paramInt3, 5, 8));
    AppMethodBeat.o(192791);
    return paramInt1;
  }
  
  private static int v(int paramInt1, int paramInt2, int paramInt3)
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
    private int bSP;
    int bSQ;
    private int bSR;
    private int bSS;
    private int bST;
    private int bSU;
    private int bSV;
    private int bSW;
    private int bSX;
    
    a(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(192732);
      this.bSP = paramInt1;
      this.bSQ = paramInt2;
      Iw();
      AppMethodBeat.o(192732);
    }
    
    private int Iv()
    {
      return this.bSQ + 1 - this.bSP;
    }
    
    final int It()
    {
      return (this.bST - this.bSS + 1) * (this.bSV - this.bSU + 1) * (this.bSX - this.bSW + 1);
    }
    
    final boolean Iu()
    {
      AppMethodBeat.i(192763);
      if (Iv() > 1)
      {
        AppMethodBeat.o(192763);
        return true;
      }
      AppMethodBeat.o(192763);
      return false;
    }
    
    final void Iw()
    {
      AppMethodBeat.i(192775);
      int[] arrayOfInt1 = a.this.mColors;
      int[] arrayOfInt2 = a.this.bSJ;
      int i4 = 0;
      int n = this.bSP;
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
      if (n <= this.bSQ)
      {
        i1 = arrayOfInt1[n];
        i8 = i4 + arrayOfInt2[i1];
        int i7 = a.fr(i1);
        i6 = a.fs(i1);
        i4 = a.ft(i1);
        i1 = i5;
        if (i7 > i5) {
          i1 = i7;
        }
        i2 = i3;
        if (i7 < i3) {
          i2 = i7;
        }
        if (i6 <= j) {
          break label252;
        }
        j = i6;
      }
      label252:
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
          this.bSS = i3;
          this.bST = i5;
          this.bSU = i;
          this.bSV = j;
          this.bSW = k;
          this.bSX = m;
          this.bSR = i4;
          AppMethodBeat.o(192775);
          return;
        }
      }
    }
    
    final int Ix()
    {
      AppMethodBeat.i(192783);
      int i = this.bST - this.bSS;
      int j = this.bSV - this.bSU;
      int k = this.bSX - this.bSW;
      int[] arrayOfInt1;
      int[] arrayOfInt2;
      if ((i >= j) && (i >= k))
      {
        i = -3;
        arrayOfInt1 = a.this.mColors;
        arrayOfInt2 = a.this.bSJ;
        a.a(arrayOfInt1, i, this.bSP, this.bSQ);
        Arrays.sort(arrayOfInt1, this.bSP, this.bSQ + 1);
        a.a(arrayOfInt1, i, this.bSP, this.bSQ);
        k = this.bSR / 2;
        i = this.bSP;
        j = 0;
      }
      for (;;)
      {
        if (i > this.bSQ) {
          break label192;
        }
        j += arrayOfInt2[arrayOfInt1[i]];
        if (j >= k)
        {
          i = Math.min(this.bSQ - 1, i);
          AppMethodBeat.o(192783);
          return i;
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
      label192:
      i = this.bSP;
      AppMethodBeat.o(192783);
      return i;
    }
    
    final b.d Iy()
    {
      AppMethodBeat.i(192792);
      Object localObject = a.this.mColors;
      int[] arrayOfInt = a.this.bSJ;
      int j = this.bSP;
      int n = 0;
      int i = 0;
      int k = 0;
      int m = 0;
      while (j <= this.bSQ)
      {
        int i2 = localObject[j];
        int i1 = arrayOfInt[i2];
        n += i1;
        m += a.fr(i2) * i1;
        k += a.fs(i2) * i1;
        i2 = a.ft(i2);
        j += 1;
        i = i2 * i1 + i;
      }
      localObject = new b.d(a.u(Math.round(m / n), Math.round(k / n), Math.round(i / n)), n);
      AppMethodBeat.o(192792);
      return localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     androidx.j.a.a
 * JD-Core Version:    0.7.0.1
 */