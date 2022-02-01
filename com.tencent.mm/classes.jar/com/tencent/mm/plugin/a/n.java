package com.tencent.mm.plugin.a;

import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public final class n
  extends a
{
  int[] bdD;
  long duration;
  Pair<Integer, Long>[] hXD;
  long hXQ;
  long hXR;
  long hXS;
  long hXT;
  long hXU;
  long hXV;
  int hXW;
  private int[] hXX;
  int[] hXY;
  private int[] hXZ;
  long hXs;
  long[] hXv;
  List<m> hXx;
  List<Pair> hXy;
  private int[] hYa;
  long hYb;
  long hYc;
  long hYd;
  boolean hYe;
  private long[] hYf;
  private long[] hYg;
  byte[] hYh;
  private byte[] hYi;
  private long hYj;
  private long hYk;
  private long hYl;
  private long hYm;
  private int hYn;
  private HashMap<Integer, Long> hYo;
  private int[] hYp;
  
  public n(int paramInt1, long paramLong, int paramInt2)
  {
    super(paramInt1, paramLong, paramInt2, 0L);
    AppMethodBeat.i(133883);
    this.hXx = new ArrayList();
    this.hXy = new ArrayList();
    this.hYb = 0L;
    this.hYc = 0L;
    this.hYd = 0L;
    this.hYe = false;
    this.hYf = null;
    this.hYh = null;
    this.hYi = new byte[4];
    this.hYj = 0L;
    this.hYk = 0L;
    this.hYl = 0L;
    this.hYm = 0L;
    this.hYn = 0;
    this.hYo = new HashMap();
    AppMethodBeat.o(133883);
  }
  
  private boolean aGS()
  {
    AppMethodBeat.i(133891);
    long l1 = bt.GC();
    aGT();
    ad.i("MicroMsg.StblAtom", "createChunkTable cost:%sms", new Object[] { Long.valueOf(bt.aS(l1)) });
    int i = 0;
    int k;
    while (i < this.hXv.length)
    {
      j = (int)this.hXv[i];
      k = pQ(j);
      int m = this.hYp[(k - 1)] + 1;
      ad.d("MicroMsg.StblAtom", "sampleId : " + j + " chunkId : " + k + ", sampleBeginId: " + m);
      l1 = dx(m, j);
      l2 = pR(k);
      this.hXv[i] = (l2 + l1);
      i += 1;
    }
    this.hYm = this.hXv[(this.hXv.length - 1)];
    long l3 = bt.GC();
    i = 1;
    int j = 0;
    l1 = 0L;
    Object localObject = this.hXx.iterator();
    long l2 = 0L;
    if (((Iterator)localObject).hasNext())
    {
      m localm = (m)((Iterator)localObject).next();
      localm.size = this.bdD[i];
      k = pQ(i);
      if (k != j) {}
      for (localm.start = pR(k);; localm.start = l2)
      {
        l2 = localm.start + localm.size;
        l1 += localm.grd;
        localm.grd = (((float)l1 * 1.0F / (float)this.hXs * 1000.0F * 1000.0F));
        localm.id = i;
        j = k;
        i += 1;
        break;
      }
    }
    ad.i("MicroMsg.StblAtom", "parse sampleList cost:%sms, size:%s", new Object[] { Long.valueOf(bt.aS(l3)), Integer.valueOf(this.hXx.size()) });
    l1 = bt.GC();
    if (this.hXY == null)
    {
      i = 0;
      while (i < this.hXx.size())
      {
        localObject = (m)this.hXx.get(i);
        ((m)localObject).hXP = 1;
        localObject = new Pair(Integer.valueOf(i), Long.valueOf(((m)localObject).grd));
        ad.v("MicroMsg.StblAtom", "stss key frame from sampleList [%s %s], current stssList.size:%d", new Object[] { ((Pair)localObject).first, ((Pair)localObject).second, Integer.valueOf(this.hXy.size()) });
        this.hXy.add(localObject);
        i += 1;
      }
    }
    i = 0;
    while (i < this.hXY.length)
    {
      localObject = (m)this.hXx.get(this.hXY[i] - 1);
      ((m)localObject).hXP = 1;
      localObject = new Pair(Integer.valueOf(this.hXY[i] - 1), Long.valueOf(((m)localObject).grd));
      ad.v("MicroMsg.StblAtom", "stss key frame from sampleId [%s %s], current stssList.size:%d", new Object[] { ((Pair)localObject).first, ((Pair)localObject).second, Integer.valueOf(this.hXy.size()) });
      this.hXy.add(localObject);
      i += 1;
    }
    ad.i("MicroMsg.StblAtom", "parse stssList cost:%sms, size:%s", new Object[] { Long.valueOf(bt.aS(l1)), Integer.valueOf(this.hXy.size()) });
    AppMethodBeat.o(133891);
    return true;
  }
  
  private void aGT()
  {
    AppMethodBeat.i(175948);
    if (this.hXX != null) {}
    int m;
    for (int i = this.hXX.length;; i = this.hYg.length)
    {
      j = i - 1;
      m = this.hXZ.length;
      i = 1;
      while (i < m)
      {
        this.hXZ[(i - 1)] = (this.hXZ[i] - this.hXZ[(i - 1)]);
        i += 1;
      }
    }
    this.hXZ[(m - 1)] = (j - this.hXZ[(m - 1)] + 1);
    this.hYp = new int[j + 1];
    this.hYp[0] = 0;
    int j = 1;
    i = 0;
    while (i < m)
    {
      int n = this.hXZ[i];
      int i1 = this.hYa[i];
      int k = 0;
      while (k < n)
      {
        int[] arrayOfInt = this.hYp;
        arrayOfInt[j] = (arrayOfInt[(j - 1)] + i1);
        j += 1;
        k += 1;
      }
      i += 1;
    }
    ad.i("MicroMsg.StblAtom", "create chunkTable size:%s", new Object[] { Integer.valueOf(this.hYp.length) });
    AppMethodBeat.o(175948);
  }
  
  private long dx(int paramInt1, int paramInt2)
  {
    long l2;
    if (this.bdD.length == 1)
    {
      l2 = this.bdD[0] * (paramInt2 - paramInt1);
      return l2;
    }
    long l1 = 0L;
    for (;;)
    {
      l2 = l1;
      if (paramInt1 > paramInt2) {
        break;
      }
      l1 += this.bdD[paramInt1];
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
      ad.w("MicroMsg.StblAtom", "stsz read sample size error");
      AppMethodBeat.o(133889);
      return -1L;
    }
    int j = c.readInt(arrayOfByte, 0);
    if (j > 0)
    {
      this.bdD = new int[1];
      this.bdD[0] = j;
      ad.i("MicroMsg.StblAtom", "all sample size is the same. size : ".concat(String.valueOf(j)));
      AppMethodBeat.o(133889);
      return 8L;
    }
    if (paramRandomAccessFile.read(arrayOfByte, 0, 4) < 4)
    {
      ad.w("MicroMsg.StblAtom", "stsz read entry count error");
      AppMethodBeat.o(133889);
      return -1L;
    }
    j = c.readInt(arrayOfByte, 0);
    long l3 = j * 4L;
    if ((l3 <= 0L) || (l3 > paramInt - 20))
    {
      ad.w("MicroMsg.StblAtom", "stco error entryCount : ".concat(String.valueOf(j)));
      AppMethodBeat.o(133889);
      return -1L;
    }
    this.bdD = new int[j + 1];
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
        this.bdD[paramInt] = c.readInt(arrayOfByte, 0);
        if (l1 >= l3)
        {
          ad.d("MicroMsg.StblAtom", "read stsz atom end");
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
  
  private Pair<Integer, Integer> pP(int paramInt)
  {
    int i = 0;
    AppMethodBeat.i(175946);
    if (this.hYp == null)
    {
      long l = bt.GC();
      aGT();
      ad.i("MicroMsg.StblAtom", "createChunkTable cost:%sms", new Object[] { Long.valueOf(bt.aS(l)) });
    }
    if (paramInt < this.hXv.length)
    {
      int j = (int)this.hXv[paramInt];
      if (j < 0)
      {
        ad.e("MicroMsg.StblAtom", "calcSampleBeginEndId %s not found in timeTable", new Object[] { Integer.valueOf(paramInt) });
        AppMethodBeat.o(175946);
        return null;
      }
      int k = pQ(j);
      paramInt = i;
      if (k > 0) {
        paramInt = k - 1;
      }
      Pair localPair = new Pair(Integer.valueOf(this.hYp[paramInt] + 1), Integer.valueOf(j));
      AppMethodBeat.o(175946);
      return localPair;
    }
    AppMethodBeat.o(175946);
    return null;
  }
  
  private int pQ(int paramInt)
  {
    int i = 0;
    while (i < this.hYp.length)
    {
      if (paramInt <= this.hYp[i]) {
        return i;
      }
      i += 1;
    }
    return 0;
  }
  
  private long pR(int paramInt)
  {
    if (this.hXX != null) {
      return this.hXX[paramInt];
    }
    if (this.hYg != null) {
      return this.hYg[paramInt];
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
      ad.w("MicroMsg.StblAtom", "stts read entry count error");
      AppMethodBeat.o(133885);
      return -1L;
    }
    int i = c.readInt(arrayOfByte, 0);
    long l3 = i * 8L;
    if ((l3 > paramInt - 16) || (l3 <= 0L))
    {
      ad.w("MicroMsg.StblAtom", "stts error entryCount : ".concat(String.valueOf(i)));
      AppMethodBeat.o(133885);
      return -1L;
    }
    int k = 0;
    i = 0;
    this.hXv = new long[(int)(this.duration / this.hXs) + 2];
    Arrays.fill(this.hXv, -1L);
    Object localObject = this.hXv;
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
        this.hYf = new long[n];
        Arrays.fill(this.hYf, 0L);
        j = 0;
        while (j < n)
        {
          localObject = new m();
          ((m)localObject).grd = i1;
          if (j == 0) {}
          for (m = 0;; m = j - 1)
          {
            long[] arrayOfLong = this.hYf;
            arrayOfLong[m] += ((m)localObject).grd;
            this.hXx.add(localObject);
            k += i1;
            m = i + 1;
            i = k;
            while ((i >= this.hXs) && (paramInt < this.hXv.length))
            {
              i = (int)(i - this.hXs);
              this.hXv[paramInt] = m;
              paramInt += 1;
            }
          }
          j += 1;
          k = i;
          i = m;
        }
        if (l1 >= l3)
        {
          ad.d("MicroMsg.StblAtom", "read stts Atom end");
          l2 = l1;
          m = paramInt;
          n = i;
        }
      }
      else
      {
        if (m < this.hXv.length) {
          this.hXv[m] = n;
        }
        AppMethodBeat.o(133885);
        return 8L + l2;
      }
    }
  }
  
  final long a(RandomAccessFile paramRandomAccessFile, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(175945);
    Pair localPair1 = pP(paramInt1);
    Pair localPair2 = pP(paramInt2);
    if ((localPair1 != null) && (localPair2 != null))
    {
      if (this.hYb == 0L) {}
      int i;
      for (Integer localInteger = (Integer)localPair1.first;; localInteger = (Integer)localPair1.second)
      {
        paramInt2 = localInteger.intValue();
        i = ((Integer)localPair2.second).intValue();
        ad.i("MicroMsg.StblAtom", "incrementParseStsz, startSampleId:%s, endSampleId:%s, sampleSizeTable.size:%s, startRange:%s, endRange:%s, stszLazyStartPos:%s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(i), Integer.valueOf(this.bdD.length), localPair1, localPair2, Long.valueOf(this.hYc) });
        if (paramInt2 <= i) {
          break;
        }
        AppMethodBeat.o(175945);
        return -1L;
      }
      if ((paramInt2 > this.bdD.length) || (i > this.bdD.length))
      {
        AppMethodBeat.o(175945);
        return -1L;
      }
      if (this.hYc < 0L)
      {
        AppMethodBeat.o(175945);
        return -1L;
      }
      if (this.hYh == null)
      {
        AppMethodBeat.o(175945);
        return -1L;
      }
      paramInt1 = (paramInt2 - 1) * 4;
      for (;;)
      {
        if ((paramInt1 < this.hYh.length) && (paramInt2 <= i))
        {
          int j = c.readInt(this.hYh, paramInt1);
          this.bdD[paramInt2] = j;
          paramInt2 += 1;
          if (0L >= this.hYd) {
            ad.d("MicroMsg.StblAtom", "read stsz atom end");
          }
        }
        else
        {
          ad.i("MicroMsg.StblAtom", "incrementParseStsz finish, filePos:%s, offset:%s, sampleSizeTableData.length:%s", new Object[] { Long.valueOf(paramRandomAccessFile.getFilePointer()), Integer.valueOf(paramInt1), Integer.valueOf(this.hYh.length) });
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
      ad.w("MicroMsg.StblAtom", "stsc read entry count error");
      AppMethodBeat.o(133886);
      return -1L;
    }
    int i = c.readInt(arrayOfByte, 0);
    long l3 = i * 12L;
    if ((l3 > paramInt - 16) || (l3 <= 0L))
    {
      ad.w("MicroMsg.StblAtom", "stsc error entryCount : ".concat(String.valueOf(i)));
      AppMethodBeat.o(133886);
      return -1L;
    }
    ad.d("MicroMsg.StblAtom", "handle stsc entryCount : ".concat(String.valueOf(i)));
    this.hXZ = new int[i];
    this.hYa = new int[i];
    long l1 = 0L;
    paramInt = paramRandomAccessFile.read(arrayOfByte);
    i = 0;
    for (;;)
    {
      long l2 = l1;
      if (paramInt >= 12)
      {
        l1 += paramInt;
        this.hXZ[i] = c.readInt(arrayOfByte, 0);
        this.hYa[i] = c.readInt(arrayOfByte, 4);
        i += 1;
        if (l1 >= l3)
        {
          ad.d("MicroMsg.StblAtom", "read stsc atom end");
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
    ad.i("MicroMsg.StblAtom", "incrementCreateTimeTable, startSecond:%s, endSecond:%s, timeTable.length:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(this.hXv.length) });
    long l1 = bt.GC();
    if (this.hYp == null)
    {
      aGT();
      ad.i("MicroMsg.StblAtom", "createChunkTable cost:%sms", new Object[] { Long.valueOf(bt.aS(l1)) });
    }
    long l3;
    if (paramInt1 > 0)
    {
      l2 = bt.GC();
      l3 = a(paramRandomAccessFile, paramInt1, paramInt2);
      ad.i("MicroMsg.StblAtom", "incrementCreateTimeTable, incrementParseStsz ret:%s, cost:%sms", new Object[] { Long.valueOf(l3), Long.valueOf(bt.aS(l2)) });
      if (l3 < 0L)
      {
        AppMethodBeat.o(175947);
        return false;
      }
    }
    long l2 = bt.GC();
    int i = Math.min(paramInt1, this.hXv.length - 1);
    int j = Math.min(paramInt2, this.hXv.length - 1);
    paramRandomAccessFile = pP(paramInt1);
    Pair localPair = pP(paramInt2);
    ad.i("MicroMsg.StblAtom", "incrementCreateTimeTable, start:%s, end:%s, startSampleIdRange:%s, endSampleIdRange:%s, calcSampleRangeCost:%sms, chunkTable.size:%s", new Object[] { Integer.valueOf(i), Integer.valueOf(j), paramRandomAccessFile, localPair, Long.valueOf(bt.aS(l2)), Integer.valueOf(this.hYp.length) });
    l2 = bt.GC();
    paramInt1 = i;
    int k;
    if (paramInt1 <= j)
    {
      i = (int)this.hXv[paramInt1];
      l3 = bt.GC();
      k = pQ(i);
      l3 = bt.aS(l3);
      if (k > 0) {}
      for (paramInt2 = k - 1;; paramInt2 = 0)
      {
        paramInt2 = this.hYp[paramInt2] + 1;
        long l5 = bt.GC();
        long l4 = dx(paramInt2, i);
        l5 = bt.aS(l5);
        long l6 = pR(k);
        this.hXv[paramInt1] = (l6 + l4);
        ad.d("MicroMsg.StblAtom", "sampleId:%s, sampleBeginId:%s, chunkId:%s, sampleSize:%s, chunkOffset:%s, calcChunkId cost:%sms, calcSampleSizeCost:%sms", new Object[] { Integer.valueOf(i), Integer.valueOf(paramInt2), Integer.valueOf(k), Long.valueOf(l4), Long.valueOf(l6), Long.valueOf(l3), Long.valueOf(l5) });
        paramInt1 += 1;
        break;
      }
    }
    ad.d("MicroMsg.StblAtom", "updateTimeTable cost:%sms", new Object[] { Long.valueOf(bt.aS(l2)) });
    this.hYm = this.hXv[(j - 1)];
    int i5;
    int i6;
    int i4;
    int i3;
    if ((paramRandomAccessFile != null) && (localPair != null))
    {
      if (this.hYb == 0L) {}
      for (paramRandomAccessFile = (Integer)paramRandomAccessFile.first;; paramRandomAccessFile = (Integer)paramRandomAccessFile.second)
      {
        i5 = paramRandomAccessFile.intValue();
        i6 = ((Integer)localPair.second).intValue();
        int i1 = -1;
        j = -1;
        int i2 = -1;
        int m = -1;
        l2 = bt.GC();
        paramInt1 = 0;
        for (;;)
        {
          paramInt2 = m;
          i4 = i2;
          i = j;
          i3 = i1;
          if (paramInt1 >= this.hXY.length) {
            break;
          }
          int n = i2;
          k = i1;
          if (i1 < 0)
          {
            n = i2;
            k = i1;
            if (this.hXY[paramInt1] - 1 >= i5 - 1)
            {
              n = this.hXY[paramInt1] - 1;
              k = paramInt1;
            }
          }
          i2 = m;
          i1 = j;
          if (j < 0)
          {
            i2 = m;
            i1 = j;
            if (this.hXY[paramInt1] - 1 >= i6 - 1)
            {
              i2 = this.hXY[paramInt1] - 1;
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
      ad.i("MicroMsg.StblAtom", "not found stssStart, set to last %s", new Object[] { Integer.valueOf(this.hXY.length - 1) });
      paramInt1 = this.hXY.length - 1;
      k = this.hXY[paramInt1] - 1;
    }
    for (;;)
    {
      if (i < 0)
      {
        ad.i("MicroMsg.StblAtom", "not found stssEnd, set to last %s", new Object[] { Integer.valueOf(this.hXY.length - 1) });
        j = this.hXY.length - 1;
        paramInt2 = this.hXY[j] - 1;
      }
      for (;;)
      {
        if (paramInt2 > i6) {}
        for (i = paramInt2;; i = i6)
        {
          if (i >= this.hXx.size()) {
            i = this.hXx.size() - 1;
          }
          for (;;)
          {
            ad.i("MicroMsg.StblAtom", "sample id range, start:%s, end:%s, sampleList.size:%s, stssStart:%s, stssEnd:%s, stssStartSampleId:%s, stssEndSampleId:%s, lastCalcSampleTimeOffset:%s, stssSampleId.length:%s, search cost:%sms", new Object[] { Integer.valueOf(i5), Integer.valueOf(i), Integer.valueOf(this.hXx.size()), Integer.valueOf(paramInt1), Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(paramInt2), Integer.valueOf(this.hYn), Integer.valueOf(this.hXY.length), Long.valueOf(bt.aS(l2)) });
            if ((i > i5) && (i < this.hXx.size()) && (this.hYf != null) && (i < this.hYf.length))
            {
              l2 = bt.GC();
              paramInt2 = i5;
              while (paramInt2 <= i)
              {
                paramRandomAccessFile = (m)this.hXx.get(paramInt2);
                k = paramInt2 + 1;
                paramRandomAccessFile.size = this.bdD[k];
                paramRandomAccessFile.grd = (((float)this.hYf[paramInt2] * 1.0F / (float)this.hXs * 1000.0F * 1000.0F));
                paramRandomAccessFile.id = k;
                paramInt2 += 1;
              }
              ad.i("MicroMsg.StblAtom", "increment parse sampleList cost:%sms, start:%s, lastCalcSampleTimeOffset:%s, end:%s", new Object[] { Long.valueOf(bt.aS(l2)), Integer.valueOf(i5), Integer.valueOf(this.hYn), Integer.valueOf(i) });
              this.hYn = i;
              l2 = bt.GC();
              if (this.hXY == null) {
                while (i5 <= i)
                {
                  if (this.hXD[i5] == null)
                  {
                    paramRandomAccessFile = (m)this.hXx.get(i5);
                    paramRandomAccessFile.hXP = 1;
                    paramRandomAccessFile = new Pair(Integer.valueOf(i5), Long.valueOf(paramRandomAccessFile.grd));
                    ad.v("MicroMsg.StblAtom", "stss key frame from sampleList [%s %s], current stssList.size:%d", new Object[] { paramRandomAccessFile.first, paramRandomAccessFile.second, Integer.valueOf(this.hXy.size()) });
                    this.hXD[i5] = paramRandomAccessFile;
                  }
                  i5 += 1;
                }
              }
              ad.i("MicroMsg.StblAtom", "increment parse stssList from sampleId, stssStart:%s, stssEnd:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(j) });
              if (j >= paramInt1) {
                while (paramInt1 <= j)
                {
                  if (this.hXD[paramInt1] == null)
                  {
                    paramRandomAccessFile = (m)this.hXx.get(this.hXY[paramInt1] - 1);
                    paramRandomAccessFile.hXP = 1;
                    paramRandomAccessFile = new Pair(Integer.valueOf(this.hXY[paramInt1] - 1), Long.valueOf(paramRandomAccessFile.grd));
                    ad.v("MicroMsg.StblAtom", "stss key frame from sampleId [%s %s], current stssList.size:%d", new Object[] { paramRandomAccessFile.first, paramRandomAccessFile.second, Integer.valueOf(this.hXy.size()) });
                    this.hXD[paramInt1] = paramRandomAccessFile;
                  }
                  paramInt1 += 1;
                }
              }
              ad.i("MicroMsg.StblAtom", "increment parse stssList cost:%sms, size:%s", new Object[] { Long.valueOf(bt.aS(l2)), Integer.valueOf(this.hXy.size()) });
            }
            ad.i("MicroMsg.StblAtom", "incrementCreateTimeTable cost:%sms", new Object[] { Long.valueOf(bt.aS(l1)) });
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
      ad.w("MicroMsg.StblAtom", "stco read entry count error");
      AppMethodBeat.o(133887);
      return -1L;
    }
    int i = c.readInt(arrayOfByte, 0);
    long l3 = 4L * i;
    if ((l3 <= 0L) || (l3 > paramInt - 16))
    {
      ad.w("MicroMsg.StblAtom", "stco error entryCount : ".concat(String.valueOf(i)));
      AppMethodBeat.o(133887);
      return -1L;
    }
    this.hXX = new int[i + 1];
    paramInt = 1;
    long l1 = 0L;
    i = paramRandomAccessFile.read(arrayOfByte);
    for (;;)
    {
      long l2 = l1;
      if (i >= 4)
      {
        l1 += i;
        this.hXX[paramInt] = c.readInt(arrayOfByte, 0);
        if (l1 >= l3)
        {
          ad.d("MicroMsg.StblAtom", "read stco atom end");
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
      ad.w("MicroMsg.StblAtom", "co64 read entry count error");
      AppMethodBeat.o(133888);
      return -1L;
    }
    int i = c.readInt(arrayOfByte, 0);
    long l3 = i * 8L;
    if ((l3 <= 0L) || (l3 > paramInt - 16))
    {
      ad.w("MicroMsg.StblAtom", "stco error entryCount : ".concat(String.valueOf(i)));
      AppMethodBeat.o(133888);
      return -1L;
    }
    this.hYg = new long[i + 1];
    paramInt = 1;
    i = paramRandomAccessFile.read(arrayOfByte);
    long l1 = 0L;
    for (;;)
    {
      long l2 = l1;
      if (i >= 8)
      {
        l1 += i;
        this.hYg[paramInt] = c.ao(arrayOfByte);
        if (l1 >= l3)
        {
          ad.d("MicroMsg.StblAtom", "read stco atom end");
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
      ad.w("MicroMsg.StblAtom", "stss rread entry count error");
      AppMethodBeat.o(133890);
      return -1L;
    }
    int i = c.readInt(arrayOfByte, 0);
    long l3 = 4L * i;
    if ((l3 <= 0L) || (l3 > paramInt - 16))
    {
      ad.w("MicroMsg.StblAtom", "stss error entryCount : ".concat(String.valueOf(i)));
      AppMethodBeat.o(133890);
      return -1L;
    }
    this.hXY = new int[i];
    paramInt = 0;
    i = paramRandomAccessFile.read(arrayOfByte);
    long l1 = 0L;
    for (;;)
    {
      long l2 = l1;
      if (i >= 4)
      {
        l1 += i;
        this.hXY[paramInt] = c.readInt(arrayOfByte, 0);
        if (l1 >= l3)
        {
          ad.d("MicroMsg.StblAtom", "read stss atom end");
          l2 = l1;
        }
      }
      else
      {
        ad.i("MicroMsg.StblAtom", "handleStssAtom, stssSampleId.size:%s", new Object[] { Integer.valueOf(this.hXY.length) });
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
    long l3 = bt.GC();
    long l1 = getSize();
    byte[] arrayOfByte = new byte[8];
    int j = 0;
    int m = 0;
    int k = 0;
    int n = 0;
    int i1 = 0;
    long l4 = bt.GC();
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
        ad.i("MicroMsg.StblAtom", "readAtom, type:%s, size:%s", new Object[] { Integer.valueOf(i7), Integer.valueOf(i6) });
        l1 = 0L;
        if (i7 == a.baT)
        {
          this.hXQ = paramRandomAccessFile.getFilePointer();
          l1 = a(paramRandomAccessFile, i6);
          ad.i("MicroMsg.StblAtom", "handleSttsAtom cost:%sms", new Object[] { Long.valueOf(bt.aS(l3)) });
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
          if (i7 == a.baW)
          {
            this.hXR = paramRandomAccessFile.getFilePointer();
            l1 = b(paramRandomAccessFile, i6);
            ad.i("MicroMsg.StblAtom", "handleStscAtom cost:%sms", new Object[] { Long.valueOf(bt.aS(l3)) });
            i3 = 1;
            i2 = n;
            i = m;
            i4 = j;
          }
          else if (i7 == a.baZ)
          {
            this.hXS = paramRandomAccessFile.getFilePointer();
            l1 = c(paramRandomAccessFile, i6);
            ad.i("MicroMsg.StblAtom", "handleStcoAtom cost:%sms", new Object[] { Long.valueOf(bt.aS(l3)) });
            i = 1;
            i2 = n;
            i3 = k;
            i4 = j;
          }
          else if (i7 == a.bba)
          {
            this.hXT = paramRandomAccessFile.getFilePointer();
            l1 = d(paramRandomAccessFile, i6);
            ad.i("MicroMsg.StblAtom", "handleCo64Atom cost:%sms", new Object[] { Long.valueOf(bt.aS(l3)) });
            i = 1;
            i2 = n;
            i3 = k;
            i4 = j;
          }
          else if (i7 == a.baX)
          {
            this.hXU = paramRandomAccessFile.getFilePointer();
            ad.i("MicroMsg.StblAtom", "stsz atom pos:%s", new Object[] { Long.valueOf(this.hXU) });
            l1 = e(paramRandomAccessFile, i6);
            ad.i("MicroMsg.StblAtom", "handleStszAtom cost:%sms", new Object[] { Long.valueOf(bt.aS(l3)) });
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
            if (i7 == a.baU)
            {
              this.hXV = paramRandomAccessFile.getFilePointer();
              l1 = f(paramRandomAccessFile, i6);
              ad.i("MicroMsg.StblAtom", "handleStssAtom cost:%sms", new Object[] { Long.valueOf(bt.aS(l3)) });
              i1 = 1;
              i2 = n;
              i3 = k;
              i = m;
              i4 = j;
            }
          }
        }
        if ((i4 != 0) && (i != 0) && (i3 != 0) && (i2 != 0) && (i1 != 0)) {
          ad.i("MicroMsg.StblAtom", "read stbl atom finish");
        }
      }
      else
      {
        ad.i("MicroMsg.StblAtom", "parse all atoms cost %sms", new Object[] { Long.valueOf(bt.aS(l4)) });
        l1 = bt.GC();
        aGS();
        ad.i("MicroMsg.StblAtom", "createTimeTable cost:%sms", new Object[] { Long.valueOf(bt.aS(l1)) });
        ad.i("MicroMsg.StblAtom", "parse stbl atom cost:%sms", new Object[] { Long.valueOf(bt.aS(l3)) });
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
 * Qualified Name:     com.tencent.mm.plugin.a.n
 * JD-Core Version:    0.7.0.1
 */