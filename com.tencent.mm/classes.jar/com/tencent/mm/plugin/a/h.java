package com.tencent.mm.plugin.a;

import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class h
  extends a
{
  private int[] aIl;
  long duration;
  private long gmC;
  private long gmD;
  private long gmE;
  private long gmF;
  private long gmG;
  private int[] gmH;
  private int[] gmI;
  private int[] gmJ;
  private long[] gmK;
  private int[] gmL;
  private int[] gmM;
  long gmt;
  long[] gmw;
  List<g> gmy;
  List<Pair> gmz;
  
  public h(int paramInt1, long paramLong, int paramInt2)
  {
    super(paramInt1, paramLong, paramInt2, 0L);
    AppMethodBeat.i(117852);
    this.gmy = new LinkedList();
    this.gmz = new LinkedList();
    AppMethodBeat.o(117852);
  }
  
  private boolean aoE()
  {
    AppMethodBeat.i(117854);
    if (this.gmJ != null) {}
    int m;
    for (int i = this.gmJ.length;; i = this.gmK.length)
    {
      j = i - 1;
      m = this.gmH.length;
      i = 1;
      while (i < m)
      {
        this.gmH[(i - 1)] = (this.gmH[i] - this.gmH[(i - 1)]);
        i += 1;
      }
    }
    this.gmH[(m - 1)] = (j - this.gmH[(m - 1)] + 1);
    this.gmM = new int[j + 1];
    this.gmM[0] = 0;
    int j = 1;
    i = 0;
    int k;
    while (i < m)
    {
      int n = this.gmH[i];
      int i1 = this.gmI[i];
      k = 0;
      while (k < n)
      {
        localObject = this.gmM;
        localObject[j] = (localObject[(j - 1)] + i1);
        j += 1;
        k += 1;
      }
      i += 1;
    }
    i = 0;
    while (i < this.gmw.length)
    {
      k = (int)this.gmw[i];
      m = mJ(k);
      j = this.gmM[(m - 1)] + 1;
      if (this.aIl.length == 1)
      {
        l2 = this.aIl[0] * (k - j);
        l1 = mK(m);
        this.gmw[i] = (l2 + l1);
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
          l1 += this.aIl[j];
          j += 1;
        }
      }
    }
    i = 1;
    j = 0;
    long l1 = 0L;
    Object localObject = this.gmy.iterator();
    long l2 = 0L;
    if (((Iterator)localObject).hasNext())
    {
      g localg = (g)((Iterator)localObject).next();
      localg.size = this.aIl[i];
      k = mJ(i);
      if (k != j) {}
      for (localg.start = mK(k);; localg.start = l2)
      {
        l2 = localg.start + localg.size;
        l1 += localg.eUW;
        localg.eUW = (((float)l1 * 1.0F / (float)this.gmt * 1000.0F * 1000.0F));
        localg.id = i;
        i += 1;
        j = k;
        break;
      }
    }
    i = 0;
    while (i < this.gmL.length)
    {
      localObject = (g)this.gmy.get(this.gmL[i] - 1);
      ((g)localObject).gmB = 1;
      localObject = new Pair(Integer.valueOf(this.gmL[i] - 1), Long.valueOf(((g)localObject).eUW));
      ab.d("MicroMsg.StblAtom", "stss key frame [%s %s]", new Object[] { ((Pair)localObject).first, ((Pair)localObject).second });
      this.gmz.add(localObject);
      i += 1;
    }
    AppMethodBeat.o(117854);
    return true;
  }
  
  private int mJ(int paramInt)
  {
    int i = 0;
    while (i < this.gmM.length)
    {
      if (paramInt <= this.gmM[i]) {
        return i;
      }
      i += 1;
    }
    return 0;
  }
  
  private long mK(int paramInt)
  {
    if (this.gmJ != null) {
      return this.gmJ[paramInt];
    }
    if (this.gmK != null) {
      return this.gmK[paramInt];
    }
    return 0L;
  }
  
  public final void d(RandomAccessFile paramRandomAccessFile)
  {
    AppMethodBeat.i(117853);
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
    label89:
    int i3;
    if (i1 >= 8)
    {
      i7 = c.readInt(arrayOfByte1, 0);
      m = c.readInt(arrayOfByte1, 4);
      l1 = 0L;
      if (m == a.aFB)
      {
        this.gmC = paramRandomAccessFile.getFilePointer();
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
        paramRandomAccessFile = new IOException("skip file error.");
        AppMethodBeat.o(117853);
        throw paramRandomAccessFile;
        byte[] arrayOfByte2 = new byte[8];
        if (paramRandomAccessFile.read(arrayOfByte2, 0, 4) < 4)
        {
          ab.w("MicroMsg.StblAtom", "stts read entry count error");
          l1 = -1L;
          break label89;
        }
        m = c.readInt(arrayOfByte2, 0);
        long l3 = 8L * m;
        if ((l3 > i7 - 16) || (l3 <= 0L))
        {
          ab.w("MicroMsg.StblAtom", "stts error entryCount : ".concat(String.valueOf(m)));
          l1 = -1L;
          break label89;
        }
        i3 = 0;
        m = 0;
        this.gmw = new long[(int)(this.duration / this.gmt) + 2];
        Object localObject = this.gmw;
        n = 1;
        localObject[0] = 1L;
        l1 = 0L;
        int i5 = paramRandomAccessFile.read(arrayOfByte2);
        long l2;
        for (;;)
        {
          int i6 = n;
          int i4 = m;
          l2 = l1;
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
              ((g)localObject).eUW = i8;
              this.gmy.add(localObject);
              i4 += i8;
              i5 = m + 1;
              m = i4;
              while ((m >= this.gmt) && (n < this.gmw.length))
              {
                m = (int)(m - this.gmt);
                this.gmw[n] = i5;
                n += 1;
              }
              i3 += 1;
              i4 = m;
              m = i5;
            }
            if (l1 >= l3)
            {
              ab.d("MicroMsg.StblAtom", "read stts Atom end");
              l2 = l1;
              i4 = m;
              i6 = n;
            }
          }
          else
          {
            if (i6 < this.gmw.length) {
              this.gmw[i6] = i4;
            }
            l1 = 8L + l2;
            break;
          }
          i5 = paramRandomAccessFile.read(arrayOfByte2);
          i3 = i4;
        }
        if (m == a.aFE)
        {
          this.gmD = paramRandomAccessFile.getFilePointer();
          if (!c.a(paramRandomAccessFile, 4L)) {
            l1 = -1L;
          }
          for (;;)
          {
            m = 1;
            i = k;
            k = m;
            m = i2;
            break;
            arrayOfByte2 = new byte[12];
            if (paramRandomAccessFile.read(arrayOfByte2, 0, 4) < 4)
            {
              ab.w("MicroMsg.StblAtom", "stsc read entry count error");
              l1 = -1L;
            }
            else
            {
              i = c.readInt(arrayOfByte2, 0);
              l3 = 12L * i;
              if ((l3 <= i7 - 16) && (l3 > 0L)) {
                break label666;
              }
              ab.w("MicroMsg.StblAtom", "stsc error entryCount : ".concat(String.valueOf(i)));
              l1 = -1L;
            }
          }
          label666:
          ab.d("MicroMsg.StblAtom", "handle stsc entryCount : ".concat(String.valueOf(i)));
          this.gmH = new int[i];
          this.gmI = new int[i];
          m = 0;
          l1 = 0L;
          for (i = paramRandomAccessFile.read(arrayOfByte2);; i = paramRandomAccessFile.read(arrayOfByte2))
          {
            l2 = l1;
            if (i >= 12)
            {
              l1 += i;
              this.gmH[m] = c.readInt(arrayOfByte2, 0);
              this.gmI[m] = c.readInt(arrayOfByte2, 4);
              m += 1;
              if (l1 >= l3)
              {
                ab.d("MicroMsg.StblAtom", "read stsc atom end");
                l2 = l1;
              }
            }
            else
            {
              l1 = l2 + 8L;
              break;
            }
          }
        }
        if (m == a.aFH)
        {
          this.gmE = paramRandomAccessFile.getFilePointer();
          if (!c.a(paramRandomAccessFile, 4L)) {
            l1 = -1L;
          }
          for (;;)
          {
            i2 = 1;
            m = i;
            i = k;
            k = m;
            m = i2;
            break;
            arrayOfByte2 = new byte[4];
            if (paramRandomAccessFile.read(arrayOfByte2, 0, 4) < 4)
            {
              ab.w("MicroMsg.StblAtom", "stco read entry count error");
              l1 = -1L;
            }
            else
            {
              m = c.readInt(arrayOfByte2, 0);
              l3 = 4L * m;
              if ((l3 > 0L) && (l3 <= i7 - 16)) {
                break label938;
              }
              ab.w("MicroMsg.StblAtom", "stco error entryCount : ".concat(String.valueOf(m)));
              l1 = -1L;
            }
          }
          label938:
          this.gmJ = new int[m + 1];
          m = 1;
          l1 = 0L;
          i2 = paramRandomAccessFile.read(arrayOfByte2);
          for (;;)
          {
            l2 = l1;
            if (i2 >= 4)
            {
              l1 += i2;
              this.gmJ[m] = c.readInt(arrayOfByte2, 0);
              if (l1 >= l3)
              {
                ab.d("MicroMsg.StblAtom", "read stco atom end");
                l2 = l1;
              }
            }
            else
            {
              l1 = l2 + 8L;
              break;
            }
            i2 = paramRandomAccessFile.read(arrayOfByte2);
            m += 1;
          }
        }
        if (m == a.aFI)
        {
          this.gmF = paramRandomAccessFile.getFilePointer();
          if (!c.a(paramRandomAccessFile, 4L)) {
            l1 = -1L;
          }
          for (;;)
          {
            i2 = 1;
            m = i;
            i = k;
            k = m;
            m = i2;
            break;
            arrayOfByte2 = new byte[8];
            if (paramRandomAccessFile.read(arrayOfByte2, 0, 4) < 4)
            {
              ab.w("MicroMsg.StblAtom", "co64 read entry count error");
              l1 = -1L;
            }
            else
            {
              m = c.readInt(arrayOfByte2, 0);
              l3 = 8L * m;
              if ((l3 > 0L) && (l3 <= i7 - 16)) {
                break label1184;
              }
              ab.w("MicroMsg.StblAtom", "stco error entryCount : ".concat(String.valueOf(m)));
              l1 = -1L;
            }
          }
          label1184:
          this.gmK = new long[m + 1];
          m = 1;
          i2 = paramRandomAccessFile.read(arrayOfByte2);
          l1 = 0L;
          for (;;)
          {
            l2 = l1;
            if (i2 >= 8)
            {
              l1 += i2;
              this.gmK[m] = c.ae(arrayOfByte2);
              if (l1 >= l3)
              {
                ab.d("MicroMsg.StblAtom", "read stco atom end");
                l2 = l1;
              }
            }
            else
            {
              l1 = l2 + 8L;
              break;
            }
            i2 = paramRandomAccessFile.read(arrayOfByte2);
            m += 1;
          }
        }
        if (m == a.aFF)
        {
          this.gmG = paramRandomAccessFile.getFilePointer();
          if (!c.a(paramRandomAccessFile, 4L)) {
            l1 = -1L;
          }
          for (;;)
          {
            m = 1;
            j = k;
            k = i;
            i = j;
            j = m;
            m = i2;
            break;
            arrayOfByte2 = new byte[4];
            if (paramRandomAccessFile.read(arrayOfByte2, 0, 4) < 4)
            {
              ab.w("MicroMsg.StblAtom", "stsz read sample size error");
              l1 = -1L;
            }
            else
            {
              j = c.readInt(arrayOfByte2, 0);
              if (j > 0)
              {
                this.aIl = new int[1];
                this.aIl[0] = j;
                ab.i("MicroMsg.StblAtom", "all sample size is the same. size : ".concat(String.valueOf(j)));
                l1 = 8L;
              }
              else if (paramRandomAccessFile.read(arrayOfByte2, 0, 4) < 4)
              {
                ab.w("MicroMsg.StblAtom", "stsz read entry count error");
                l1 = -1L;
              }
              else
              {
                j = c.readInt(arrayOfByte2, 0);
                l3 = 4L * j;
                if ((l3 > 0L) && (l3 <= i7 - 20)) {
                  break label1503;
                }
                ab.w("MicroMsg.StblAtom", "stco error entryCount : ".concat(String.valueOf(j)));
                l1 = -1L;
              }
            }
          }
          label1503:
          this.aIl = new int[j + 1];
          j = 1;
          m = paramRandomAccessFile.read(arrayOfByte2);
          l1 = 0L;
          for (;;)
          {
            l2 = l1;
            if (m >= 4)
            {
              l1 += m;
              this.aIl[j] = c.readInt(arrayOfByte2, 0);
              if (l1 >= l3)
              {
                ab.d("MicroMsg.StblAtom", "read stsz atom end");
                l2 = l1;
              }
            }
            else
            {
              l1 = l2 + 12L;
              break;
            }
            m = paramRandomAccessFile.read(arrayOfByte2);
            j += 1;
          }
        }
        if (m != a.aFC) {
          break label1901;
        }
        if (!c.a(paramRandomAccessFile, 4L)) {
          l1 = -1L;
        }
        for (;;)
        {
          m = 1;
          k = i;
          i = m;
          m = i2;
          break;
          arrayOfByte2 = new byte[4];
          if (paramRandomAccessFile.read(arrayOfByte2, 0, 4) < 4)
          {
            ab.w("MicroMsg.StblAtom", "stss rread entry count error");
            l1 = -1L;
          }
          else
          {
            k = c.readInt(arrayOfByte2, 0);
            l3 = 4L * k;
            if ((l3 > 0L) && (l3 <= i7 - 16)) {
              break label1733;
            }
            ab.w("MicroMsg.StblAtom", "stss error entryCount : ".concat(String.valueOf(k)));
            l1 = -1L;
          }
        }
        label1733:
        this.gmL = new int[k];
        k = 0;
        m = paramRandomAccessFile.read(arrayOfByte2);
        l1 = 0L;
        for (;;)
        {
          l2 = l1;
          if (m >= 4)
          {
            l1 += m;
            this.gmL[k] = c.readInt(arrayOfByte2, 0);
            if (l1 >= l3)
            {
              ab.d("MicroMsg.StblAtom", "read stss atom end");
              l2 = l1;
            }
          }
          else
          {
            l1 = l2 + 8L;
            break;
          }
          m = paramRandomAccessFile.read(arrayOfByte2);
          k += 1;
        }
      }
      if ((n != 0) && (m != 0) && (k != 0) && (j != 0) && (i != 0))
      {
        ab.i("MicroMsg.StblAtom", "read stbl atom finish");
        aoE();
        AppMethodBeat.o(117853);
        return;
      }
      i1 = paramRandomAccessFile.read(arrayOfByte1);
      i2 = k;
      k = i;
      i = i2;
      i2 = m;
      break;
      label1901:
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