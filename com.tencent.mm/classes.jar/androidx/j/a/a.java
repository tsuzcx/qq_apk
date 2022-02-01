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
  private static final Comparator<a> aeJ;
  final int[] aeE;
  final List<b.d> aeF;
  final TimingLogger aeG;
  final b.b[] aeH;
  private final float[] aeI;
  final int[] mColors;
  
  static
  {
    AppMethodBeat.i(242990);
    aeJ = new Comparator() {};
    AppMethodBeat.o(242990);
  }
  
  a(int[] paramArrayOfInt, int paramInt, b.b[] paramArrayOfb)
  {
    AppMethodBeat.i(242981);
    this.aeI = new float[3];
    this.aeG = null;
    this.aeH = paramArrayOfb;
    paramArrayOfb = new int[32768];
    this.aeE = paramArrayOfb;
    int i = 0;
    int n;
    while (i < paramArrayOfInt.length)
    {
      j = paramArrayOfInt[i];
      k = h(Color.red(j), 8, 5);
      n = h(Color.green(j), 8, 5);
      j = h(Color.blue(j), 8, 5) | k << 10 | n << 5;
      paramArrayOfInt[i] = j;
      paramArrayOfb[j] += 1;
      i += 1;
    }
    i = 0;
    for (int j = 0; i < 32768; j = k)
    {
      if (paramArrayOfb[i] > 0)
      {
        b.d(cg(i), this.aeI);
        if (d(this.aeI)) {
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
        this.aeF = new ArrayList();
        i = paramArrayOfInt.length;
        paramInt = m;
        while (paramInt < i)
        {
          j = paramArrayOfInt[paramInt];
          this.aeF.add(new b.d(cg(j), paramArrayOfb[j]));
          paramInt += 1;
        }
        AppMethodBeat.o(242981);
        return;
      }
      paramArrayOfInt = new PriorityQueue(paramInt, aeJ);
      paramArrayOfInt.offer(new a(0, this.mColors.length - 1));
      a(paramArrayOfInt, paramInt);
      this.aeF = a(paramArrayOfInt);
      AppMethodBeat.o(242981);
      return;
    }
  }
  
  private List<b.d> a(Collection<a> paramCollection)
  {
    AppMethodBeat.i(242984);
    ArrayList localArrayList = new ArrayList(paramCollection.size());
    paramCollection = paramCollection.iterator();
    while (paramCollection.hasNext())
    {
      b.d locald = ((a)paramCollection.next()).jS();
      if (!d(locald.jZ())) {
        localArrayList.add(locald);
      }
    }
    AppMethodBeat.o(242984);
    return localArrayList;
  }
  
  private static void a(PriorityQueue<a> paramPriorityQueue, int paramInt)
  {
    AppMethodBeat.i(242983);
    while (paramPriorityQueue.size() < paramInt)
    {
      a locala1 = (a)paramPriorityQueue.poll();
      if ((locala1 != null) && (locala1.jO()))
      {
        if (!locala1.jO())
        {
          paramPriorityQueue = new IllegalStateException("Can not split a box with only 1 color");
          AppMethodBeat.o(242983);
          throw paramPriorityQueue;
        }
        int i = locala1.jR();
        a locala2 = new a(locala1.aeT, i + 1, locala1.aeL);
        locala1.aeL = i;
        locala1.jQ();
        paramPriorityQueue.offer(locala2);
        paramPriorityQueue.offer(locala1);
      }
      else
      {
        AppMethodBeat.o(242983);
        return;
      }
    }
    AppMethodBeat.o(242983);
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
  
  private static int cg(int paramInt)
  {
    AppMethodBeat.i(242989);
    paramInt = g(paramInt >> 10 & 0x1F, paramInt >> 5 & 0x1F, paramInt & 0x1F);
    AppMethodBeat.o(242989);
    return paramInt;
  }
  
  static int ch(int paramInt)
  {
    return paramInt >> 10 & 0x1F;
  }
  
  static int ci(int paramInt)
  {
    return paramInt >> 5 & 0x1F;
  }
  
  static int cj(int paramInt)
  {
    return paramInt & 0x1F;
  }
  
  private boolean d(float[] paramArrayOfFloat)
  {
    AppMethodBeat.i(242986);
    if ((this.aeH != null) && (this.aeH.length > 0))
    {
      int j = this.aeH.length;
      int i = 0;
      while (i < j)
      {
        if (!this.aeH[i].e(paramArrayOfFloat))
        {
          AppMethodBeat.o(242986);
          return true;
        }
        i += 1;
      }
    }
    AppMethodBeat.o(242986);
    return false;
  }
  
  static int g(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(242988);
    paramInt1 = Color.rgb(h(paramInt1, 5, 8), h(paramInt2, 5, 8), h(paramInt3, 5, 8));
    AppMethodBeat.o(242988);
    return paramInt1;
  }
  
  private static int h(int paramInt1, int paramInt2, int paramInt3)
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
    private int aeK;
    int aeL;
    private int aeM;
    private int aeN;
    private int aeO;
    private int aeP;
    private int aeQ;
    private int aeR;
    private int aeS;
    
    a(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(242971);
      this.aeK = paramInt1;
      this.aeL = paramInt2;
      jQ();
      AppMethodBeat.o(242971);
    }
    
    private int jP()
    {
      return this.aeL + 1 - this.aeK;
    }
    
    final int jN()
    {
      return (this.aeO - this.aeN + 1) * (this.aeQ - this.aeP + 1) * (this.aeS - this.aeR + 1);
    }
    
    final boolean jO()
    {
      AppMethodBeat.i(242972);
      if (jP() > 1)
      {
        AppMethodBeat.o(242972);
        return true;
      }
      AppMethodBeat.o(242972);
      return false;
    }
    
    final void jQ()
    {
      AppMethodBeat.i(242974);
      int[] arrayOfInt1 = a.this.mColors;
      int[] arrayOfInt2 = a.this.aeE;
      int i4 = 0;
      int n = this.aeK;
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
      if (n <= this.aeL)
      {
        i1 = arrayOfInt1[n];
        i8 = i4 + arrayOfInt2[i1];
        int i7 = a.ch(i1);
        i6 = a.ci(i1);
        i4 = a.cj(i1);
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
          this.aeN = i3;
          this.aeO = i5;
          this.aeP = i;
          this.aeQ = j;
          this.aeR = k;
          this.aeS = m;
          this.aeM = i4;
          AppMethodBeat.o(242974);
          return;
        }
      }
    }
    
    final int jR()
    {
      AppMethodBeat.i(242975);
      int i = this.aeO - this.aeN;
      int j = this.aeQ - this.aeP;
      int k = this.aeS - this.aeR;
      int[] arrayOfInt1;
      int[] arrayOfInt2;
      if ((i >= j) && (i >= k))
      {
        i = -3;
        arrayOfInt1 = a.this.mColors;
        arrayOfInt2 = a.this.aeE;
        a.a(arrayOfInt1, i, this.aeK, this.aeL);
        Arrays.sort(arrayOfInt1, this.aeK, this.aeL + 1);
        a.a(arrayOfInt1, i, this.aeK, this.aeL);
        k = this.aeM / 2;
        i = this.aeK;
        j = 0;
      }
      for (;;)
      {
        if (i > this.aeL) {
          break label192;
        }
        j += arrayOfInt2[arrayOfInt1[i]];
        if (j >= k)
        {
          i = Math.min(this.aeL - 1, i);
          AppMethodBeat.o(242975);
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
      i = this.aeK;
      AppMethodBeat.o(242975);
      return i;
    }
    
    final b.d jS()
    {
      AppMethodBeat.i(242976);
      Object localObject = a.this.mColors;
      int[] arrayOfInt = a.this.aeE;
      int j = this.aeK;
      int n = 0;
      int i = 0;
      int k = 0;
      int m = 0;
      while (j <= this.aeL)
      {
        int i2 = localObject[j];
        int i1 = arrayOfInt[i2];
        n += i1;
        m += a.ch(i2) * i1;
        k += a.ci(i2) * i1;
        i2 = a.cj(i2);
        j += 1;
        i = i2 * i1 + i;
      }
      localObject = new b.d(a.g(Math.round(m / n), Math.round(k / n), Math.round(i / n)), n);
      AppMethodBeat.o(242976);
      return localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     androidx.j.a.a
 * JD-Core Version:    0.7.0.1
 */