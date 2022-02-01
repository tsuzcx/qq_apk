package com.tencent.mm.plugin.a;

import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public final class o
  extends a
{
  int[] bep;
  long duration;
  List<n> ixB;
  List<Pair> ixC;
  Pair<Integer, Long>[] ixH;
  long ixU;
  long ixV;
  long ixW;
  long ixX;
  long ixY;
  long ixZ;
  long ixw;
  long[] ixz;
  int iya;
  private int[] iyb;
  int[] iyc;
  private int[] iyd;
  private int[] iye;
  long iyf;
  long iyg;
  long iyh;
  boolean iyi;
  private long[] iyj;
  private long[] iyk;
  byte[] iyl;
  private byte[] iym;
  private long iyn;
  private long iyo;
  private long iyp;
  private long iyq;
  private int iyr;
  private HashMap<Integer, Long> iys;
  private int[] iyt;
  
  public o(int paramInt1, long paramLong, int paramInt2)
  {
    super(paramInt1, paramLong, paramInt2, 0L);
    AppMethodBeat.i(133883);
    this.ixB = new ArrayList();
    this.ixC = new ArrayList();
    this.iyf = 0L;
    this.iyg = 0L;
    this.iyh = 0L;
    this.iyi = false;
    this.iyj = null;
    this.iyl = null;
    this.iym = new byte[4];
    this.iyn = 0L;
    this.iyo = 0L;
    this.iyp = 0L;
    this.iyq = 0L;
    this.iyr = 0;
    this.iys = new HashMap();
    AppMethodBeat.o(133883);
  }
  
  private boolean aNG()
  {
    AppMethodBeat.i(133891);
    long l1 = bs.Gn();
    aNH();
    ac.i("MicroMsg.StblAtom", "createChunkTable cost:%sms", new Object[] { Long.valueOf(bs.aO(l1)) });
    int i = 0;
    int k;
    while (i < this.ixz.length)
    {
      j = (int)this.ixz[i];
      k = qD(j);
      int m = this.iyt[(k - 1)] + 1;
      ac.d("MicroMsg.StblAtom", "sampleId : " + j + " chunkId : " + k + ", sampleBeginId: " + m);
      l1 = dx(m, j);
      l2 = qE(k);
      this.ixz[i] = (l2 + l1);
      i += 1;
    }
    this.iyq = this.ixz[(this.ixz.length - 1)];
    long l3 = bs.Gn();
    i = 1;
    int j = 0;
    l1 = 0L;
    Object localObject = this.ixB.iterator();
    long l2 = 0L;
    if (((Iterator)localObject).hasNext())
    {
      n localn = (n)((Iterator)localObject).next();
      localn.size = this.bep[i];
      k = qD(i);
      if (k != j) {}
      for (localn.start = qE(k);; localn.start = l2)
      {
        l2 = localn.start + localn.size;
        l1 += localn.gRL;
        localn.gRL = (((float)l1 * 1.0F / (float)this.ixw * 1000.0F * 1000.0F));
        localn.id = i;
        j = k;
        i += 1;
        break;
      }
    }
    ac.i("MicroMsg.StblAtom", "parse sampleList cost:%sms, size:%s", new Object[] { Long.valueOf(bs.aO(l3)), Integer.valueOf(this.ixB.size()) });
    l1 = bs.Gn();
    if (this.iyc == null)
    {
      i = 0;
      while (i < this.ixB.size())
      {
        localObject = (n)this.ixB.get(i);
        ((n)localObject).ixT = 1;
        localObject = new Pair(Integer.valueOf(i), Long.valueOf(((n)localObject).gRL));
        ac.v("MicroMsg.StblAtom", "stss key frame from sampleList [%s %s], current stssList.size:%d", new Object[] { ((Pair)localObject).first, ((Pair)localObject).second, Integer.valueOf(this.ixC.size()) });
        this.ixC.add(localObject);
        i += 1;
      }
    }
    i = 0;
    while (i < this.iyc.length)
    {
      localObject = (n)this.ixB.get(this.iyc[i] - 1);
      ((n)localObject).ixT = 1;
      localObject = new Pair(Integer.valueOf(this.iyc[i] - 1), Long.valueOf(((n)localObject).gRL));
      ac.v("MicroMsg.StblAtom", "stss key frame from sampleId [%s %s], current stssList.size:%d", new Object[] { ((Pair)localObject).first, ((Pair)localObject).second, Integer.valueOf(this.ixC.size()) });
      this.ixC.add(localObject);
      i += 1;
    }
    ac.i("MicroMsg.StblAtom", "parse stssList cost:%sms, size:%s", new Object[] { Long.valueOf(bs.aO(l1)), Integer.valueOf(this.ixC.size()) });
    AppMethodBeat.o(133891);
    return true;
  }
  
  private void aNH()
  {
    AppMethodBeat.i(175948);
    if (this.iyb != null) {}
    int m;
    for (int i = this.iyb.length;; i = this.iyk.length)
    {
      j = i - 1;
      m = this.iyd.length;
      i = 1;
      while (i < m)
      {
        this.iyd[(i - 1)] = (this.iyd[i] - this.iyd[(i - 1)]);
        i += 1;
      }
    }
    this.iyd[(m - 1)] = (j - this.iyd[(m - 1)] + 1);
    this.iyt = new int[j + 1];
    this.iyt[0] = 0;
    int j = 1;
    i = 0;
    while (i < m)
    {
      int n = this.iyd[i];
      int i1 = this.iye[i];
      int k = 0;
      while (k < n)
      {
        int[] arrayOfInt = this.iyt;
        arrayOfInt[j] = (arrayOfInt[(j - 1)] + i1);
        j += 1;
        k += 1;
      }
      i += 1;
    }
    ac.i("MicroMsg.StblAtom", "create chunkTable size:%s", new Object[] { Integer.valueOf(this.iyt.length) });
    AppMethodBeat.o(175948);
  }
  
  private long dx(int paramInt1, int paramInt2)
  {
    long l2;
    if (this.bep.length == 1)
    {
      l2 = this.bep[0] * (paramInt2 - paramInt1);
      return l2;
    }
    long l1 = 0L;
    for (;;)
    {
      l2 = l1;
      if (paramInt1 > paramInt2) {
        break;
      }
      l1 += this.bep[paramInt1];
      paramInt1 += 1;
    }
  }
  
  private long e(RandomAccessFile paramRandomAccessFile, int paramInt)
  {
    int i = 1;
    AppMethodBeat.i(133889);
    if (!c.a(paramRandomAccessFile, 4L))
    {
      AppMethodBeat.o(133889);
      return -1L;
    }
    byte[] arrayOfByte = new byte[4];
    if (paramRandomAccessFile.read(arrayOfByte, 0, 4) < 4)
    {
      ac.w("MicroMsg.StblAtom", "stsz read sample size error");
      AppMethodBeat.o(133889);
      return -1L;
    }
    int j = c.readInt(arrayOfByte, 0);
    if (j > 0)
    {
      this.bep = new int[1];
      this.bep[0] = j;
      ac.i("MicroMsg.StblAtom", "all sample size is the same. size : ".concat(String.valueOf(j)));
      AppMethodBeat.o(133889);
      return 8L;
    }
    if (paramRandomAccessFile.read(arrayOfByte, 0, 4) < 4)
    {
      ac.w("MicroMsg.StblAtom", "stsz read entry count error");
      AppMethodBeat.o(133889);
      return -1L;
    }
    j = c.readInt(arrayOfByte, 0);
    long l3 = j * 4L;
    if ((l3 <= 0L) || (l3 > paramInt - 20))
    {
      ac.w("MicroMsg.StblAtom", "stco error entryCount : ".concat(String.valueOf(j)));
      AppMethodBeat.o(133889);
      return -1L;
    }
    this.bep = new int[j + 1];
    j = paramRandomAccessFile.read(arrayOfByte);
    long l1 = 0L;
    paramInt = i;
    i = j;
    for (;;)
    {
      long l2 = l1;
      if (i >= 4)
      {
        l1 += i;
        this.bep[paramInt] = c.readInt(arrayOfByte, 0);
        if (l1 >= l3)
        {
          ac.d("MicroMsg.StblAtom", "read stsz atom end");
          l2 = l1;
        }
      }
      else
      {
        AppMethodBeat.o(133889);
        return l2 + 12L;
      }
      i = paramRandomAccessFile.read(arrayOfByte);
      paramInt += 1;
    }
  }
  
  private Pair<Integer, Integer> qC(int paramInt)
  {
    int i = 0;
    AppMethodBeat.i(175946);
    if (this.iyt == null)
    {
      long l = bs.Gn();
      aNH();
      ac.i("MicroMsg.StblAtom", "createChunkTable cost:%sms", new Object[] { Long.valueOf(bs.aO(l)) });
    }
    if (paramInt < this.ixz.length)
    {
      int j = (int)this.ixz[paramInt];
      if (j < 0)
      {
        ac.e("MicroMsg.StblAtom", "calcSampleBeginEndId %s not found in timeTable", new Object[] { Integer.valueOf(paramInt) });
        AppMethodBeat.o(175946);
        return null;
      }
      int k = qD(j);
      paramInt = i;
      if (k > 0) {
        paramInt = k - 1;
      }
      Pair localPair = new Pair(Integer.valueOf(this.iyt[paramInt] + 1), Integer.valueOf(j));
      AppMethodBeat.o(175946);
      return localPair;
    }
    AppMethodBeat.o(175946);
    return null;
  }
  
  private int qD(int paramInt)
  {
    int i = 0;
    while (i < this.iyt.length)
    {
      if (paramInt <= this.iyt[i]) {
        return i;
      }
      i += 1;
    }
    return 0;
  }
  
  private long qE(int paramInt)
  {
    if (this.iyb != null) {
      return this.iyb[paramInt];
    }
    if (this.iyk != null) {
      return this.iyk[paramInt];
    }
    return 0L;
  }
  
  final long a(RandomAccessFile paramRandomAccessFile, int paramInt)
  {
    AppMethodBeat.i(133885);
    if (!c.a(paramRandomAccessFile, 4L))
    {
      AppMethodBeat.o(133885);
      return -1L;
    }
    byte[] arrayOfByte = new byte[8];
    if (paramRandomAccessFile.read(arrayOfByte, 0, 4) < 4)
    {
      ac.w("MicroMsg.StblAtom", "stts read entry count error");
      AppMethodBeat.o(133885);
      return -1L;
    }
    int i = c.readInt(arrayOfByte, 0);
    long l3 = i * 8L;
    if ((l3 > paramInt - 16) || (l3 <= 0L))
    {
      ac.w("MicroMsg.StblAtom", "stts error entryCount : ".concat(String.valueOf(i)));
      AppMethodBeat.o(133885);
      return -1L;
    }
    int k = 0;
    i = 0;
    this.ixz = new long[(int)(this.duration / this.ixw) + 2];
    Arrays.fill(this.ixz, -1L);
    Object localObject = this.ixz;
    paramInt = 1;
    localObject[0] = 1L;
    long l1 = 0L;
    for (int j = paramRandomAccessFile.read(arrayOfByte);; j = paramRandomAccessFile.read(arrayOfByte))
    {
      int n = i;
      int m = paramInt;
      long l2 = l1;
      if (j >= 8)
      {
        l1 = j + l1;
        n = c.readInt(arrayOfByte, 0);
        int i1 = c.readInt(arrayOfByte, 4);
        this.iyj = new long[n];
        Arrays.fill(this.iyj, 0L);
        j = 0;
        while (j < n)
        {
          localObject = new n();
          ((n)localObject).gRL = i1;
          if (j == 0) {}
          for (m = 0;; m = j - 1)
          {
            long[] arrayOfLong = this.iyj;
            arrayOfLong[m] += ((n)localObject).gRL;
            this.ixB.add(localObject);
            k += i1;
            m = i + 1;
            i = k;
            while ((i >= this.ixw) && (paramInt < this.ixz.length))
            {
              i = (int)(i - this.ixw);
              this.ixz[paramInt] = m;
              paramInt += 1;
            }
          }
          j += 1;
          k = i;
          i = m;
        }
        if (l1 >= l3)
        {
          ac.d("MicroMsg.StblAtom", "read stts Atom end");
          l2 = l1;
          m = paramInt;
          n = i;
        }
      }
      else
      {
        if (m < this.ixz.length) {
          this.ixz[m] = n;
        }
        AppMethodBeat.o(133885);
        return 8L + l2;
      }
    }
  }
  
  final long a(RandomAccessFile paramRandomAccessFile, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(175945);
    Pair localPair1 = qC(paramInt1);
    Pair localPair2 = qC(paramInt2);
    if ((localPair1 != null) && (localPair2 != null))
    {
      if (this.iyf == 0L) {}
      int i;
      for (Integer localInteger = (Integer)localPair1.first;; localInteger = (Integer)localPair1.second)
      {
        paramInt2 = localInteger.intValue();
        i = ((Integer)localPair2.second).intValue();
        ac.i("MicroMsg.StblAtom", "incrementParseStsz, startSampleId:%s, endSampleId:%s, sampleSizeTable.size:%s, startRange:%s, endRange:%s, stszLazyStartPos:%s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(i), Integer.valueOf(this.bep.length), localPair1, localPair2, Long.valueOf(this.iyg) });
        if (paramInt2 <= i) {
          break;
        }
        AppMethodBeat.o(175945);
        return -1L;
      }
      if ((paramInt2 > this.bep.length) || (i > this.bep.length))
      {
        AppMethodBeat.o(175945);
        return -1L;
      }
      if (this.iyg < 0L)
      {
        AppMethodBeat.o(175945);
        return -1L;
      }
      if (this.iyl == null)
      {
        AppMethodBeat.o(175945);
        return -1L;
      }
      paramInt1 = (paramInt2 - 1) * 4;
      for (;;)
      {
        if ((paramInt1 < this.iyl.length) && (paramInt2 <= i))
        {
          int j = c.readInt(this.iyl, paramInt1);
          this.bep[paramInt2] = j;
          paramInt2 += 1;
          if (0L >= this.iyh) {
            ac.d("MicroMsg.StblAtom", "read stsz atom end");
          }
        }
        else
        {
          ac.i("MicroMsg.StblAtom", "incrementParseStsz finish, filePos:%s, offset:%s, sampleSizeTableData.length:%s", new Object[] { Long.valueOf(paramRandomAccessFile.getFilePointer()), Integer.valueOf(paramInt1), Integer.valueOf(this.iyl.length) });
          AppMethodBeat.o(175945);
          return 0L;
        }
        paramInt1 += 4;
      }
    }
    AppMethodBeat.o(175945);
    return 0L;
  }
  
  final long b(RandomAccessFile paramRandomAccessFile, int paramInt)
  {
    AppMethodBeat.i(133886);
    if (!c.a(paramRandomAccessFile, 4L))
    {
      AppMethodBeat.o(133886);
      return -1L;
    }
    byte[] arrayOfByte = new byte[12];
    if (paramRandomAccessFile.read(arrayOfByte, 0, 4) < 4)
    {
      ac.w("MicroMsg.StblAtom", "stsc read entry count error");
      AppMethodBeat.o(133886);
      return -1L;
    }
    int i = c.readInt(arrayOfByte, 0);
    long l3 = i * 12L;
    if ((l3 > paramInt - 16) || (l3 <= 0L))
    {
      ac.w("MicroMsg.StblAtom", "stsc error entryCount : ".concat(String.valueOf(i)));
      AppMethodBeat.o(133886);
      return -1L;
    }
    ac.d("MicroMsg.StblAtom", "handle stsc entryCount : ".concat(String.valueOf(i)));
    this.iyd = new int[i];
    this.iye = new int[i];
    long l1 = 0L;
    paramInt = paramRandomAccessFile.read(arrayOfByte);
    i = 0;
    for (;;)
    {
      long l2 = l1;
      if (paramInt >= 12)
      {
        l1 += paramInt;
        this.iyd[i] = c.readInt(arrayOfByte, 0);
        this.iye[i] = c.readInt(arrayOfByte, 4);
        i += 1;
        if (l1 >= l3)
        {
          ac.d("MicroMsg.StblAtom", "read stsc atom end");
          l2 = l1;
        }
      }
      else
      {
        AppMethodBeat.o(133886);
        return l2 + 8L;
      }
      paramInt = paramRandomAccessFile.read(arrayOfByte);
    }
  }
  
  public final boolean b(RandomAccessFile paramRandomAccessFile, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(175947);
    if (paramInt2 < paramInt1)
    {
      AppMethodBeat.o(175947);
      return false;
    }
    ac.i("MicroMsg.StblAtom", "incrementCreateTimeTable, startSecond:%s, endSecond:%s, timeTable.length:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(this.ixz.length) });
    long l1 = bs.Gn();
    if (this.iyt == null)
    {
      aNH();
      ac.i("MicroMsg.StblAtom", "createChunkTable cost:%sms", new Object[] { Long.valueOf(bs.aO(l1)) });
    }
    long l3;
    if (paramInt1 > 0)
    {
      l2 = bs.Gn();
      l3 = a(paramRandomAccessFile, paramInt1, paramInt2);
      ac.i("MicroMsg.StblAtom", "incrementCreateTimeTable, incrementParseStsz ret:%s, cost:%sms", new Object[] { Long.valueOf(l3), Long.valueOf(bs.aO(l2)) });
      if (l3 < 0L)
      {
        AppMethodBeat.o(175947);
        return false;
      }
    }
    long l2 = bs.Gn();
    int i = Math.min(paramInt1, this.ixz.length - 1);
    int j = Math.min(paramInt2, this.ixz.length - 1);
    paramRandomAccessFile = qC(paramInt1);
    Pair localPair = qC(paramInt2);
    ac.i("MicroMsg.StblAtom", "incrementCreateTimeTable, start:%s, end:%s, startSampleIdRange:%s, endSampleIdRange:%s, calcSampleRangeCost:%sms, chunkTable.size:%s", new Object[] { Integer.valueOf(i), Integer.valueOf(j), paramRandomAccessFile, localPair, Long.valueOf(bs.aO(l2)), Integer.valueOf(this.iyt.length) });
    l2 = bs.Gn();
    paramInt1 = i;
    int k;
    if (paramInt1 <= j)
    {
      i = (int)this.ixz[paramInt1];
      l3 = bs.Gn();
      k = qD(i);
      l3 = bs.aO(l3);
      if (k > 0) {}
      for (paramInt2 = k - 1;; paramInt2 = 0)
      {
        paramInt2 = this.iyt[paramInt2] + 1;
        long l5 = bs.Gn();
        long l4 = dx(paramInt2, i);
        l5 = bs.aO(l5);
        long l6 = qE(k);
        this.ixz[paramInt1] = (l6 + l4);
        ac.d("MicroMsg.StblAtom", "sampleId:%s, sampleBeginId:%s, chunkId:%s, sampleSize:%s, chunkOffset:%s, calcChunkId cost:%sms, calcSampleSizeCost:%sms", new Object[] { Integer.valueOf(i), Integer.valueOf(paramInt2), Integer.valueOf(k), Long.valueOf(l4), Long.valueOf(l6), Long.valueOf(l3), Long.valueOf(l5) });
        paramInt1 += 1;
        break;
      }
    }
    ac.d("MicroMsg.StblAtom", "updateTimeTable cost:%sms", new Object[] { Long.valueOf(bs.aO(l2)) });
    this.iyq = this.ixz[(j - 1)];
    int i5;
    int i6;
    int i4;
    int i3;
    if ((paramRandomAccessFile != null) && (localPair != null))
    {
      if (this.iyf == 0L) {}
      for (paramRandomAccessFile = (Integer)paramRandomAccessFile.first;; paramRandomAccessFile = (Integer)paramRandomAccessFile.second)
      {
        i5 = paramRandomAccessFile.intValue();
        i6 = ((Integer)localPair.second).intValue();
        int i1 = -1;
        j = -1;
        int i2 = -1;
        int m = -1;
        l2 = bs.Gn();
        paramInt1 = 0;
        for (;;)
        {
          paramInt2 = m;
          i4 = i2;
          i = j;
          i3 = i1;
          if (paramInt1 >= this.iyc.length) {
            break;
          }
          int n = i2;
          k = i1;
          if (i1 < 0)
          {
            n = i2;
            k = i1;
            if (this.iyc[paramInt1] - 1 >= i5 - 1)
            {
              n = this.iyc[paramInt1] - 1;
              k = paramInt1;
            }
          }
          i2 = m;
          i1 = j;
          if (j < 0)
          {
            i2 = m;
            i1 = j;
            if (this.iyc[paramInt1] - 1 >= i6 - 1)
            {
              i2 = this.iyc[paramInt1] - 1;
              i1 = paramInt1;
            }
          }
          if (k >= 0)
          {
            paramInt2 = i2;
            i4 = n;
            i = i1;
            i3 = k;
            if (i1 >= 0) {
              break;
            }
          }
          paramInt1 += 1;
          m = i2;
          i2 = n;
          j = i1;
          i1 = k;
        }
      }
      if (i3 >= 0) {
        break label1511;
      }
      ac.i("MicroMsg.StblAtom", "not found stssStart, set to last %s", new Object[] { Integer.valueOf(this.iyc.length - 1) });
      paramInt1 = this.iyc.length - 1;
      k = this.iyc[paramInt1] - 1;
    }
    for (;;)
    {
      if (i < 0)
      {
        ac.i("MicroMsg.StblAtom", "not found stssEnd, set to last %s", new Object[] { Integer.valueOf(this.iyc.length - 1) });
        j = this.iyc.length - 1;
        paramInt2 = this.iyc[j] - 1;
      }
      for (;;)
      {
        if (paramInt2 > i6) {}
        for (i = paramInt2;; i = i6)
        {
          if (i >= this.ixB.size()) {
            i = this.ixB.size() - 1;
          }
          for (;;)
          {
            ac.i("MicroMsg.StblAtom", "sample id range, start:%s, end:%s, sampleList.size:%s, stssStart:%s, stssEnd:%s, stssStartSampleId:%s, stssEndSampleId:%s, lastCalcSampleTimeOffset:%s, stssSampleId.length:%s, search cost:%sms", new Object[] { Integer.valueOf(i5), Integer.valueOf(i), Integer.valueOf(this.ixB.size()), Integer.valueOf(paramInt1), Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(paramInt2), Integer.valueOf(this.iyr), Integer.valueOf(this.iyc.length), Long.valueOf(bs.aO(l2)) });
            if ((i > i5) && (i < this.ixB.size()) && (this.iyj != null) && (i < this.iyj.length))
            {
              l2 = bs.Gn();
              paramInt2 = i5;
              while (paramInt2 <= i)
              {
                paramRandomAccessFile = (n)this.ixB.get(paramInt2);
                k = paramInt2 + 1;
                paramRandomAccessFile.size = this.bep[k];
                paramRandomAccessFile.gRL = (((float)this.iyj[paramInt2] * 1.0F / (float)this.ixw * 1000.0F * 1000.0F));
                paramRandomAccessFile.id = k;
                paramInt2 += 1;
              }
              ac.i("MicroMsg.StblAtom", "increment parse sampleList cost:%sms, start:%s, lastCalcSampleTimeOffset:%s, end:%s", new Object[] { Long.valueOf(bs.aO(l2)), Integer.valueOf(i5), Integer.valueOf(this.iyr), Integer.valueOf(i) });
              this.iyr = i;
              l2 = bs.Gn();
              if (this.iyc == null) {
                while (i5 <= i)
                {
                  if (this.ixH[i5] == null)
                  {
                    paramRandomAccessFile = (n)this.ixB.get(i5);
                    paramRandomAccessFile.ixT = 1;
                    paramRandomAccessFile = new Pair(Integer.valueOf(i5), Long.valueOf(paramRandomAccessFile.gRL));
                    ac.v("MicroMsg.StblAtom", "stss key frame from sampleList [%s %s], current stssList.size:%d", new Object[] { paramRandomAccessFile.first, paramRandomAccessFile.second, Integer.valueOf(this.ixC.size()) });
                    this.ixH[i5] = paramRandomAccessFile;
                  }
                  i5 += 1;
                }
              }
              ac.i("MicroMsg.StblAtom", "increment parse stssList from sampleId, stssStart:%s, stssEnd:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(j) });
              if (j >= paramInt1) {
                while (paramInt1 <= j)
                {
                  if (this.ixH[paramInt1] == null)
                  {
                    paramRandomAccessFile = (n)this.ixB.get(this.iyc[paramInt1] - 1);
                    paramRandomAccessFile.ixT = 1;
                    paramRandomAccessFile = new Pair(Integer.valueOf(this.iyc[paramInt1] - 1), Long.valueOf(paramRandomAccessFile.gRL));
                    ac.v("MicroMsg.StblAtom", "stss key frame from sampleId [%s %s], current stssList.size:%d", new Object[] { paramRandomAccessFile.first, paramRandomAccessFile.second, Integer.valueOf(this.ixC.size()) });
                    this.ixH[paramInt1] = paramRandomAccessFile;
                  }
                  paramInt1 += 1;
                }
              }
              ac.i("MicroMsg.StblAtom", "increment parse stssList cost:%sms, size:%s", new Object[] { Long.valueOf(bs.aO(l2)), Integer.valueOf(this.ixC.size()) });
            }
            ac.i("MicroMsg.StblAtom", "incrementCreateTimeTable cost:%sms", new Object[] { Long.valueOf(bs.aO(l1)) });
            AppMethodBeat.o(175947);
            return true;
          }
        }
        j = i;
      }
      label1511:
      k = i4;
      paramInt1 = i3;
    }
  }
  
  final long c(RandomAccessFile paramRandomAccessFile, int paramInt)
  {
    AppMethodBeat.i(133887);
    if (!c.a(paramRandomAccessFile, 4L))
    {
      AppMethodBeat.o(133887);
      return -1L;
    }
    byte[] arrayOfByte = new byte[4];
    if (paramRandomAccessFile.read(arrayOfByte, 0, 4) < 4)
    {
      ac.w("MicroMsg.StblAtom", "stco read entry count error");
      AppMethodBeat.o(133887);
      return -1L;
    }
    int i = c.readInt(arrayOfByte, 0);
    long l3 = 4L * i;
    if ((l3 <= 0L) || (l3 > paramInt - 16))
    {
      ac.w("MicroMsg.StblAtom", "stco error entryCount : ".concat(String.valueOf(i)));
      AppMethodBeat.o(133887);
      return -1L;
    }
    this.iyb = new int[i + 1];
    paramInt = 1;
    long l1 = 0L;
    i = paramRandomAccessFile.read(arrayOfByte);
    for (;;)
    {
      long l2 = l1;
      if (i >= 4)
      {
        l1 += i;
        this.iyb[paramInt] = c.readInt(arrayOfByte, 0);
        if (l1 >= l3)
        {
          ac.d("MicroMsg.StblAtom", "read stco atom end");
          l2 = l1;
        }
      }
      else
      {
        AppMethodBeat.o(133887);
        return l2 + 8L;
      }
      i = paramRandomAccessFile.read(arrayOfByte);
      paramInt += 1;
    }
  }
  
  final long d(RandomAccessFile paramRandomAccessFile, int paramInt)
  {
    AppMethodBeat.i(133888);
    if (!c.a(paramRandomAccessFile, 4L))
    {
      AppMethodBeat.o(133888);
      return -1L;
    }
    byte[] arrayOfByte = new byte[8];
    if (paramRandomAccessFile.read(arrayOfByte, 0, 4) < 4)
    {
      ac.w("MicroMsg.StblAtom", "co64 read entry count error");
      AppMethodBeat.o(133888);
      return -1L;
    }
    int i = c.readInt(arrayOfByte, 0);
    long l3 = i * 8L;
    if ((l3 <= 0L) || (l3 > paramInt - 16))
    {
      ac.w("MicroMsg.StblAtom", "stco error entryCount : ".concat(String.valueOf(i)));
      AppMethodBeat.o(133888);
      return -1L;
    }
    this.iyk = new long[i + 1];
    paramInt = 1;
    i = paramRandomAccessFile.read(arrayOfByte);
    long l1 = 0L;
    for (;;)
    {
      long l2 = l1;
      if (i >= 8)
      {
        l1 += i;
        this.iyk[paramInt] = c.an(arrayOfByte);
        if (l1 >= l3)
        {
          ac.d("MicroMsg.StblAtom", "read stco atom end");
          l2 = l1;
        }
      }
      else
      {
        AppMethodBeat.o(133888);
        return l2 + 8L;
      }
      i = paramRandomAccessFile.read(arrayOfByte);
      paramInt += 1;
    }
  }
  
  final long f(RandomAccessFile paramRandomAccessFile, int paramInt)
  {
    AppMethodBeat.i(133890);
    if (!c.a(paramRandomAccessFile, 4L))
    {
      AppMethodBeat.o(133890);
      return -1L;
    }
    byte[] arrayOfByte = new byte[4];
    if (paramRandomAccessFile.read(arrayOfByte, 0, 4) < 4)
    {
      ac.w("MicroMsg.StblAtom", "stss rread entry count error");
      AppMethodBeat.o(133890);
      return -1L;
    }
    int i = c.readInt(arrayOfByte, 0);
    long l3 = 4L * i;
    if ((l3 <= 0L) || (l3 > paramInt - 16))
    {
      ac.w("MicroMsg.StblAtom", "stss error entryCount : ".concat(String.valueOf(i)));
      AppMethodBeat.o(133890);
      return -1L;
    }
    this.iyc = new int[i];
    paramInt = 0;
    i = paramRandomAccessFile.read(arrayOfByte);
    long l1 = 0L;
    for (;;)
    {
      long l2 = l1;
      if (i >= 4)
      {
        l1 += i;
        this.iyc[paramInt] = c.readInt(arrayOfByte, 0);
        if (l1 >= l3)
        {
          ac.d("MicroMsg.StblAtom", "read stss atom end");
          l2 = l1;
        }
      }
      else
      {
        ac.i("MicroMsg.StblAtom", "handleStssAtom, stssSampleId.size:%s", new Object[] { Integer.valueOf(this.iyc.length) });
        AppMethodBeat.o(133890);
        return l2 + 8L;
      }
      i = paramRandomAccessFile.read(arrayOfByte);
      paramInt += 1;
    }
  }
  
  public final void f(RandomAccessFile paramRandomAccessFile)
  {
    AppMethodBeat.i(133884);
    long l3 = bs.Gn();
    long l1 = getSize();
    byte[] arrayOfByte = new byte[8];
    int j = 0;
    int m = 0;
    int k = 0;
    int n = 0;
    int i1 = 0;
    long l4 = bs.Gn();
    long l2 = l1 - 8L;
    for (;;)
    {
      int i6;
      int i4;
      int i;
      int i3;
      int i2;
      if (l2 > 0L)
      {
        int i5 = paramRandomAccessFile.read(arrayOfByte);
        i6 = c.readInt(arrayOfByte, 0);
        int i7 = c.readInt(arrayOfByte, 4);
        ac.i("MicroMsg.StblAtom", "readAtom, type:%s, size:%s", new Object[] { Integer.valueOf(i7), Integer.valueOf(i6) });
        l1 = 0L;
        if (i7 == a.bbF)
        {
          this.ixU = paramRandomAccessFile.getFilePointer();
          l1 = a(paramRandomAccessFile, i6);
          ac.i("MicroMsg.StblAtom", "handleSttsAtom cost:%sms", new Object[] { Long.valueOf(bs.aO(l3)) });
          i4 = 1;
          i = m;
          i3 = k;
          i2 = n;
        }
        while (!c.a(paramRandomAccessFile, i6 - l1 - i5))
        {
          paramRandomAccessFile = new IOException("skip file error.");
          AppMethodBeat.o(133884);
          throw paramRandomAccessFile;
          if (i7 == a.bbI)
          {
            this.ixV = paramRandomAccessFile.getFilePointer();
            l1 = b(paramRandomAccessFile, i6);
            ac.i("MicroMsg.StblAtom", "handleStscAtom cost:%sms", new Object[] { Long.valueOf(bs.aO(l3)) });
            i3 = 1;
            i2 = n;
            i = m;
            i4 = j;
          }
          else if (i7 == a.bbL)
          {
            this.ixW = paramRandomAccessFile.getFilePointer();
            l1 = c(paramRandomAccessFile, i6);
            ac.i("MicroMsg.StblAtom", "handleStcoAtom cost:%sms", new Object[] { Long.valueOf(bs.aO(l3)) });
            i = 1;
            i2 = n;
            i3 = k;
            i4 = j;
          }
          else if (i7 == a.bbM)
          {
            this.ixX = paramRandomAccessFile.getFilePointer();
            l1 = d(paramRandomAccessFile, i6);
            ac.i("MicroMsg.StblAtom", "handleCo64Atom cost:%sms", new Object[] { Long.valueOf(bs.aO(l3)) });
            i = 1;
            i2 = n;
            i3 = k;
            i4 = j;
          }
          else if (i7 == a.bbJ)
          {
            this.ixY = paramRandomAccessFile.getFilePointer();
            ac.i("MicroMsg.StblAtom", "stsz atom pos:%s", new Object[] { Long.valueOf(this.ixY) });
            l1 = e(paramRandomAccessFile, i6);
            ac.i("MicroMsg.StblAtom", "handleStszAtom cost:%sms", new Object[] { Long.valueOf(bs.aO(l3)) });
            i2 = 1;
            i3 = k;
            i = m;
            i4 = j;
          }
          else
          {
            i2 = n;
            i3 = k;
            i = m;
            i4 = j;
            if (i7 == a.bbG)
            {
              this.ixZ = paramRandomAccessFile.getFilePointer();
              l1 = f(paramRandomAccessFile, i6);
              ac.i("MicroMsg.StblAtom", "handleStssAtom cost:%sms", new Object[] { Long.valueOf(bs.aO(l3)) });
              i1 = 1;
              i2 = n;
              i3 = k;
              i = m;
              i4 = j;
            }
          }
        }
        if ((i4 != 0) && (i != 0) && (i3 != 0) && (i2 != 0) && (i1 != 0)) {
          ac.i("MicroMsg.StblAtom", "read stbl atom finish");
        }
      }
      else
      {
        ac.i("MicroMsg.StblAtom", "parse all atoms cost %sms", new Object[] { Long.valueOf(bs.aO(l4)) });
        l1 = bs.Gn();
        aNG();
        ac.i("MicroMsg.StblAtom", "createTimeTable cost:%sms", new Object[] { Long.valueOf(bs.aO(l1)) });
        ac.i("MicroMsg.StblAtom", "parse stbl atom cost:%sms", new Object[] { Long.valueOf(bs.aO(l3)) });
        AppMethodBeat.o(133884);
        return;
      }
      l2 -= i6;
      n = i2;
      k = i3;
      m = i;
      j = i4;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.a.o
 * JD-Core Version:    0.7.0.1
 */