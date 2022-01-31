package com.tencent.mm.plugin.a;

import android.util.Pair;
import com.tencent.mm.sdk.platformtools.y;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class h
  extends a
{
  private int[] aCR;
  long duration;
  List<g> eUA = new LinkedList();
  List<Pair> eUB = new LinkedList();
  long eUF;
  private long eUG;
  private long eUH;
  private long eUI;
  private long eUJ;
  private int[] eUK;
  private int[] eUL;
  private int[] eUM;
  private long[] eUN;
  private int[] eUO;
  private int[] eUP;
  long eUv;
  long[] eUy;
  
  public h(int paramInt1, long paramLong, int paramInt2)
  {
    super(paramInt1, paramLong, paramInt2, 0L);
  }
  
  private boolean Vg()
  {
    if (this.eUM != null) {}
    int m;
    for (int i = this.eUM.length;; i = this.eUN.length)
    {
      j = i - 1;
      m = this.eUK.length;
      i = 1;
      while (i < m)
      {
        this.eUK[(i - 1)] = (this.eUK[i] - this.eUK[(i - 1)]);
        i += 1;
      }
    }
    this.eUK[(m - 1)] = (j - this.eUK[(m - 1)] + 1);
    this.eUP = new int[j + 1];
    this.eUP[0] = 0;
    i = 0;
    int j = 1;
    int k;
    while (i < m)
    {
      int n = this.eUK[i];
      int i1 = this.eUL[i];
      k = 0;
      while (k < n)
      {
        this.eUP[j] = (this.eUP[(j - 1)] + i1);
        j += 1;
        k += 1;
      }
      i += 1;
    }
    i = 0;
    while (i < this.eUy.length)
    {
      k = (int)this.eUy[i];
      m = jN(k);
      j = this.eUP[(m - 1)] + 1;
      if (this.aCR.length == 1)
      {
        l2 = this.aCR[0] * (k - j);
        l1 = jO(m);
        this.eUy[i] = (l2 + l1);
        i += 1;
      }
      else
      {
        l1 = 0L;
        for (;;)
        {
          l2 = l1;
          if (j > k) {
            break;
          }
          l1 += this.aCR[j];
          j += 1;
        }
      }
    }
    Object localObject = this.eUA.iterator();
    long l1 = 0L;
    long l2 = 0L;
    j = 0;
    i = 1;
    if (((Iterator)localObject).hasNext())
    {
      g localg = (g)((Iterator)localObject).next();
      localg.size = this.aCR[i];
      k = jN(i);
      if (k != j) {}
      for (localg.start = jO(k);; localg.start = l2)
      {
        l2 = localg.start;
        long l3 = localg.size;
        l1 += localg.eUD;
        localg.eUD = (((float)l1 * 1.0F / (float)this.eUv * 1000.0F * 1000.0F));
        localg.id = i;
        l2 += l3;
        j = k;
        i += 1;
        break;
      }
    }
    i = 0;
    while (i < this.eUO.length)
    {
      localObject = (g)this.eUA.get(this.eUO[i] - 1);
      ((g)localObject).eUE = 1;
      localObject = new Pair(Integer.valueOf(this.eUO[i] - 1), Long.valueOf(((g)localObject).eUD));
      y.d("MicroMsg.StblAtom", "stss key frame [%s %s]", new Object[] { ((Pair)localObject).first, ((Pair)localObject).second });
      this.eUB.add(localObject);
      i += 1;
    }
    return true;
  }
  
  private long a(RandomAccessFile paramRandomAccessFile, int paramInt)
  {
    this.eUG = paramRandomAccessFile.getFilePointer();
    if (!c.a(paramRandomAccessFile, 4L)) {
      return -1L;
    }
    byte[] arrayOfByte = new byte[12];
    if (paramRandomAccessFile.read(arrayOfByte, 0, 4) < 4)
    {
      y.w("MicroMsg.StblAtom", "stsc read entry count error");
      return -1L;
    }
    int i = c.readInt(arrayOfByte, 0);
    long l3 = 12L * i;
    if ((l3 > paramInt - 16) || (l3 <= 0L))
    {
      y.w("MicroMsg.StblAtom", "stsc error entryCount : " + i);
      return -1L;
    }
    y.d("MicroMsg.StblAtom", "handle stsc entryCount : " + i);
    this.eUK = new int[i];
    this.eUL = new int[i];
    i = 0;
    long l1 = 0L;
    for (paramInt = paramRandomAccessFile.read(arrayOfByte);; paramInt = paramRandomAccessFile.read(arrayOfByte))
    {
      long l2 = l1;
      if (paramInt >= 12)
      {
        l1 += paramInt;
        this.eUK[i] = c.readInt(arrayOfByte, 0);
        this.eUL[i] = c.readInt(arrayOfByte, 4);
        i += 1;
        if (l1 >= l3)
        {
          y.d("MicroMsg.StblAtom", "read stsc atom end");
          l2 = l1;
        }
      }
      else
      {
        return l2 + 8L;
      }
    }
  }
  
  private long b(RandomAccessFile paramRandomAccessFile, int paramInt)
  {
    this.eUH = paramRandomAccessFile.getFilePointer();
    if (!c.a(paramRandomAccessFile, 4L)) {
      return -1L;
    }
    byte[] arrayOfByte = new byte[4];
    if (paramRandomAccessFile.read(arrayOfByte, 0, 4) < 4)
    {
      y.w("MicroMsg.StblAtom", "stco read entry count error");
      return -1L;
    }
    int i = c.readInt(arrayOfByte, 0);
    long l3 = i * 4L;
    if ((l3 <= 0L) || (l3 > paramInt - 16))
    {
      y.w("MicroMsg.StblAtom", "stco error entryCount : " + i);
      return -1L;
    }
    this.eUM = new int[i + 1];
    paramInt = 1;
    i = paramRandomAccessFile.read(arrayOfByte);
    long l1 = 0L;
    for (;;)
    {
      long l2 = l1;
      if (i >= 4)
      {
        l1 += i;
        this.eUM[paramInt] = c.readInt(arrayOfByte, 0);
        if (l1 >= l3)
        {
          y.d("MicroMsg.StblAtom", "read stco atom end");
          l2 = l1;
        }
      }
      else
      {
        return l2 + 8L;
      }
      i = paramRandomAccessFile.read(arrayOfByte);
      paramInt += 1;
    }
  }
  
  private long c(RandomAccessFile paramRandomAccessFile, int paramInt)
  {
    this.eUI = paramRandomAccessFile.getFilePointer();
    if (!c.a(paramRandomAccessFile, 4L)) {
      return -1L;
    }
    byte[] arrayOfByte = new byte[8];
    if (paramRandomAccessFile.read(arrayOfByte, 0, 4) < 4)
    {
      y.w("MicroMsg.StblAtom", "co64 read entry count error");
      return -1L;
    }
    int i = c.readInt(arrayOfByte, 0);
    long l3 = i * 8L;
    if ((l3 <= 0L) || (l3 > paramInt - 16))
    {
      y.w("MicroMsg.StblAtom", "stco error entryCount : " + i);
      return -1L;
    }
    this.eUN = new long[i + 1];
    paramInt = 1;
    i = paramRandomAccessFile.read(arrayOfByte);
    long l1 = 0L;
    for (;;)
    {
      long l2 = l1;
      if (i >= 8)
      {
        l1 += i;
        this.eUN[paramInt] = c.K(arrayOfByte);
        if (l1 >= l3)
        {
          y.d("MicroMsg.StblAtom", "read stco atom end");
          l2 = l1;
        }
      }
      else
      {
        return l2 + 8L;
      }
      i = paramRandomAccessFile.read(arrayOfByte);
      paramInt += 1;
    }
  }
  
  private long d(RandomAccessFile paramRandomAccessFile, int paramInt)
  {
    this.eUJ = paramRandomAccessFile.getFilePointer();
    if (!c.a(paramRandomAccessFile, 4L)) {
      return -1L;
    }
    byte[] arrayOfByte = new byte[4];
    if (paramRandomAccessFile.read(arrayOfByte, 0, 4) < 4)
    {
      y.w("MicroMsg.StblAtom", "stsz read sample size error");
      return -1L;
    }
    int i = c.readInt(arrayOfByte, 0);
    if (i > 0)
    {
      this.aCR = new int[1];
      this.aCR[0] = i;
      y.i("MicroMsg.StblAtom", "all sample size is the same. size : " + i);
      return 8L;
    }
    if (paramRandomAccessFile.read(arrayOfByte, 0, 4) < 4)
    {
      y.w("MicroMsg.StblAtom", "stsz read entry count error");
      return -1L;
    }
    i = c.readInt(arrayOfByte, 0);
    long l3 = 4L * i;
    if ((l3 <= 0L) || (l3 > paramInt - 20))
    {
      y.w("MicroMsg.StblAtom", "stco error entryCount : " + i);
      return -1L;
    }
    this.aCR = new int[i + 1];
    paramInt = 1;
    i = paramRandomAccessFile.read(arrayOfByte);
    long l1 = 0L;
    for (;;)
    {
      long l2 = l1;
      if (i >= 4)
      {
        l1 += i;
        this.aCR[paramInt] = c.readInt(arrayOfByte, 0);
        if (l1 >= l3)
        {
          y.d("MicroMsg.StblAtom", "read stsz atom end");
          l2 = l1;
        }
      }
      else
      {
        return l2 + 12L;
      }
      i = paramRandomAccessFile.read(arrayOfByte);
      paramInt += 1;
    }
  }
  
  private long e(RandomAccessFile paramRandomAccessFile, int paramInt)
  {
    if (!c.a(paramRandomAccessFile, 4L)) {
      return -1L;
    }
    byte[] arrayOfByte = new byte[4];
    if (paramRandomAccessFile.read(arrayOfByte, 0, 4) < 4)
    {
      y.w("MicroMsg.StblAtom", "stss rread entry count error");
      return -1L;
    }
    int i = c.readInt(arrayOfByte, 0);
    long l3 = i * 4L;
    if ((l3 <= 0L) || (l3 > paramInt - 16))
    {
      y.w("MicroMsg.StblAtom", "stss error entryCount : " + i);
      return -1L;
    }
    this.eUO = new int[i];
    i = paramRandomAccessFile.read(arrayOfByte);
    long l1 = 0L;
    paramInt = 0;
    for (;;)
    {
      long l2 = l1;
      if (i >= 4)
      {
        l1 += i;
        this.eUO[paramInt] = c.readInt(arrayOfByte, 0);
        if (l1 >= l3)
        {
          y.d("MicroMsg.StblAtom", "read stss atom end");
          l2 = l1;
        }
      }
      else
      {
        return l2 + 8L;
      }
      i = paramRandomAccessFile.read(arrayOfByte);
      paramInt += 1;
    }
  }
  
  private int jN(int paramInt)
  {
    int i = 0;
    while (i < this.eUP.length)
    {
      if (paramInt <= this.eUP[i]) {
        return i;
      }
      i += 1;
    }
    return 0;
  }
  
  private long jO(int paramInt)
  {
    if (this.eUM != null) {
      return this.eUM[paramInt];
    }
    if (this.eUN != null) {
      return this.eUN[paramInt];
    }
    return 0L;
  }
  
  public final void d(RandomAccessFile paramRandomAccessFile)
  {
    byte[] arrayOfByte1 = new byte[8];
    int i1 = paramRandomAccessFile.read(arrayOfByte1);
    int n = 0;
    int i2 = 0;
    int i = 0;
    int j = 0;
    int k = 0;
    int i7;
    int m;
    long l1;
    label84:
    int i3;
    if (i1 >= 8)
    {
      i7 = c.readInt(arrayOfByte1, 0);
      m = c.readInt(arrayOfByte1, 4);
      l1 = 0L;
      if (m == a.aAW)
      {
        this.eUF = paramRandomAccessFile.getFilePointer();
        if (!c.a(paramRandomAccessFile, 4L))
        {
          l1 = -1L;
          n = 1;
          i3 = k;
          m = i2;
          k = i;
          i = i3;
        }
      }
    }
    for (;;)
    {
      if (!c.a(paramRandomAccessFile, i7 - l1 - i1))
      {
        throw new IOException("skip file error.");
        byte[] arrayOfByte2 = new byte[8];
        if (paramRandomAccessFile.read(arrayOfByte2, 0, 4) < 4)
        {
          y.w("MicroMsg.StblAtom", "stts read entry count error");
          l1 = -1L;
          break label84;
        }
        m = c.readInt(arrayOfByte2, 0);
        long l3 = 8L * m;
        if ((l3 > i7 - 16) || (l3 <= 0L))
        {
          y.w("MicroMsg.StblAtom", "stts error entryCount : " + m);
          l1 = -1L;
          break label84;
        }
        i3 = 0;
        m = 0;
        this.eUy = new long[(int)(this.duration / this.eUv) + 2];
        Object localObject = this.eUy;
        n = 1;
        localObject[0] = 1L;
        l1 = 0L;
        int i5 = paramRandomAccessFile.read(arrayOfByte2);
        for (;;)
        {
          int i6 = n;
          int i4 = m;
          long l2 = l1;
          if (i5 >= 8)
          {
            l1 += i5;
            i6 = c.readInt(arrayOfByte2, 0);
            int i8 = c.readInt(arrayOfByte2, 4);
            i5 = 0;
            i4 = i3;
            i3 = i5;
            while (i3 < i6)
            {
              localObject = new g();
              ((g)localObject).eUD = i8;
              this.eUA.add(localObject);
              i4 += i8;
              i5 = m + 1;
              m = i4;
              while ((m >= this.eUv) && (n < this.eUy.length))
              {
                m = (int)(m - this.eUv);
                this.eUy[n] = i5;
                n += 1;
              }
              i3 += 1;
              i4 = m;
              m = i5;
            }
            if (l1 >= l3)
            {
              y.d("MicroMsg.StblAtom", "read stts Atom end");
              l2 = l1;
              i4 = m;
              i6 = n;
            }
          }
          else
          {
            if (i6 < this.eUy.length) {
              this.eUy[i6] = i4;
            }
            l1 = 8L + l2;
            break;
          }
          i5 = paramRandomAccessFile.read(arrayOfByte2);
          i3 = i4;
        }
        if (m == a.aAZ)
        {
          l1 = a(paramRandomAccessFile, i7);
          m = 1;
          i = k;
          k = m;
          m = i2;
          continue;
        }
        if (m == a.aBc)
        {
          l1 = b(paramRandomAccessFile, i7);
          i2 = 1;
          m = i;
          i = k;
          k = m;
          m = i2;
          continue;
        }
        if (m == a.aBd)
        {
          l1 = c(paramRandomAccessFile, i7);
          i2 = 1;
          m = i;
          i = k;
          k = m;
          m = i2;
          continue;
        }
        if (m == a.aBa)
        {
          l1 = d(paramRandomAccessFile, i7);
          m = 1;
          j = k;
          k = i;
          i = j;
          j = m;
          m = i2;
          continue;
        }
        if (m != a.aAX) {
          break label769;
        }
        l1 = e(paramRandomAccessFile, i7);
        m = 1;
        k = i;
        i = m;
        m = i2;
        continue;
      }
      if ((n != 0) && (m != 0) && (k != 0) && (j != 0) && (i != 0))
      {
        y.i("MicroMsg.StblAtom", "read stbl atom finish");
        Vg();
        return;
      }
      i1 = paramRandomAccessFile.read(arrayOfByte1);
      i2 = k;
      k = i;
      i = i2;
      i2 = m;
      break;
      label769:
      m = i;
      i = k;
      k = m;
      m = i2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.a.h
 * JD-Core Version:    0.7.0.1
 */