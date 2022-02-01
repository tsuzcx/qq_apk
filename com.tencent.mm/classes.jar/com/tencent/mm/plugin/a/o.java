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

public final class o
  extends a
{
  int[] boK;
  long duration;
  long iQF;
  long[] iQI;
  List<n> iQK;
  List<Pair> iQL;
  Pair<Integer, Long>[] iQQ;
  private int iRA;
  private HashMap<Integer, Long> iRB;
  private int[] iRC;
  long iRd;
  long iRe;
  long iRf;
  long iRg;
  long iRh;
  long iRi;
  int iRj;
  private int[] iRk;
  int[] iRl;
  private int[] iRm;
  private int[] iRn;
  long iRo;
  long iRp;
  long iRq;
  boolean iRr;
  private long[] iRs;
  private long[] iRt;
  byte[] iRu;
  private byte[] iRv;
  private long iRw;
  private long iRx;
  private long iRy;
  private long iRz;
  
  public o(int paramInt1, long paramLong, int paramInt2)
  {
    super(paramInt1, paramLong, paramInt2, 0L);
    AppMethodBeat.i(133883);
    this.iQK = new ArrayList();
    this.iQL = new ArrayList();
    this.iRo = 0L;
    this.iRp = 0L;
    this.iRq = 0L;
    this.iRr = false;
    this.iRs = null;
    this.iRu = null;
    this.iRv = new byte[4];
    this.iRw = 0L;
    this.iRx = 0L;
    this.iRy = 0L;
    this.iRz = 0L;
    this.iRA = 0;
    this.iRB = new HashMap();
    AppMethodBeat.o(133883);
  }
  
  private boolean aQS()
  {
    AppMethodBeat.i(133891);
    long l1 = bt.HI();
    aQT();
    ad.i("MicroMsg.StblAtom", "createChunkTable cost:%sms", new Object[] { Long.valueOf(bt.aO(l1)) });
    int i = 0;
    int k;
    while (i < this.iQI.length)
    {
      j = (int)this.iQI[i];
      k = rd(j);
      int m = this.iRC[(k - 1)] + 1;
      ad.d("MicroMsg.StblAtom", "sampleId : " + j + " chunkId : " + k + ", sampleBeginId: " + m);
      l1 = dz(m, j);
      l2 = re(k);
      this.iQI[i] = (l2 + l1);
      i += 1;
    }
    this.iRz = this.iQI[(this.iQI.length - 1)];
    long l3 = bt.HI();
    i = 1;
    int j = 0;
    l1 = 0L;
    Object localObject = this.iQK.iterator();
    long l2 = 0L;
    if (((Iterator)localObject).hasNext())
    {
      n localn = (n)((Iterator)localObject).next();
      localn.size = this.boK[i];
      k = rd(i);
      if (k != j) {}
      for (localn.start = re(k);; localn.start = l2)
      {
        l2 = localn.start + localn.size;
        l1 += localn.hkd;
        localn.hkd = (((float)l1 * 1.0F / (float)this.iQF * 1000.0F * 1000.0F));
        localn.id = i;
        j = k;
        i += 1;
        break;
      }
    }
    ad.i("MicroMsg.StblAtom", "parse sampleList cost:%sms, size:%s", new Object[] { Long.valueOf(bt.aO(l3)), Integer.valueOf(this.iQK.size()) });
    l1 = bt.HI();
    if (this.iRl == null)
    {
      i = 0;
      while (i < this.iQK.size())
      {
        localObject = (n)this.iQK.get(i);
        ((n)localObject).iRc = 1;
        localObject = new Pair(Integer.valueOf(i), Long.valueOf(((n)localObject).hkd));
        ad.v("MicroMsg.StblAtom", "stss key frame from sampleList [%s %s], current stssList.size:%d", new Object[] { ((Pair)localObject).first, ((Pair)localObject).second, Integer.valueOf(this.iQL.size()) });
        this.iQL.add(localObject);
        i += 1;
      }
    }
    i = 0;
    while (i < this.iRl.length)
    {
      localObject = (n)this.iQK.get(this.iRl[i] - 1);
      ((n)localObject).iRc = 1;
      localObject = new Pair(Integer.valueOf(this.iRl[i] - 1), Long.valueOf(((n)localObject).hkd));
      ad.v("MicroMsg.StblAtom", "stss key frame from sampleId [%s %s], current stssList.size:%d", new Object[] { ((Pair)localObject).first, ((Pair)localObject).second, Integer.valueOf(this.iQL.size()) });
      this.iQL.add(localObject);
      i += 1;
    }
    ad.i("MicroMsg.StblAtom", "parse stssList cost:%sms, size:%s", new Object[] { Long.valueOf(bt.aO(l1)), Integer.valueOf(this.iQL.size()) });
    AppMethodBeat.o(133891);
    return true;
  }
  
  private void aQT()
  {
    AppMethodBeat.i(175948);
    if (this.iRk != null) {}
    int m;
    for (int i = this.iRk.length;; i = this.iRt.length)
    {
      j = i - 1;
      m = this.iRm.length;
      i = 1;
      while (i < m)
      {
        this.iRm[(i - 1)] = (this.iRm[i] - this.iRm[(i - 1)]);
        i += 1;
      }
    }
    this.iRm[(m - 1)] = (j - this.iRm[(m - 1)] + 1);
    this.iRC = new int[j + 1];
    this.iRC[0] = 0;
    int j = 1;
    i = 0;
    while (i < m)
    {
      int n = this.iRm[i];
      int i1 = this.iRn[i];
      int k = 0;
      while (k < n)
      {
        int[] arrayOfInt = this.iRC;
        arrayOfInt[j] = (arrayOfInt[(j - 1)] + i1);
        j += 1;
        k += 1;
      }
      i += 1;
    }
    ad.i("MicroMsg.StblAtom", "create chunkTable size:%s", new Object[] { Integer.valueOf(this.iRC.length) });
    AppMethodBeat.o(175948);
  }
  
  private long dz(int paramInt1, int paramInt2)
  {
    long l2;
    if (this.boK.length == 1)
    {
      l2 = this.boK[0] * (paramInt2 - paramInt1);
      return l2;
    }
    long l1 = 0L;
    for (;;)
    {
      l2 = l1;
      if (paramInt1 > paramInt2) {
        break;
      }
      l1 += this.boK[paramInt1];
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
      this.boK = new int[1];
      this.boK[0] = j;
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
    this.boK = new int[j + 1];
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
        this.boK[paramInt] = c.readInt(arrayOfByte, 0);
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
  
  private Pair<Integer, Integer> rc(int paramInt)
  {
    int i = 0;
    AppMethodBeat.i(175946);
    if (this.iRC == null)
    {
      long l = bt.HI();
      aQT();
      ad.i("MicroMsg.StblAtom", "createChunkTable cost:%sms", new Object[] { Long.valueOf(bt.aO(l)) });
    }
    if (paramInt < this.iQI.length)
    {
      int j = (int)this.iQI[paramInt];
      if (j < 0)
      {
        ad.e("MicroMsg.StblAtom", "calcSampleBeginEndId %s not found in timeTable", new Object[] { Integer.valueOf(paramInt) });
        AppMethodBeat.o(175946);
        return null;
      }
      int k = rd(j);
      paramInt = i;
      if (k > 0) {
        paramInt = k - 1;
      }
      Pair localPair = new Pair(Integer.valueOf(this.iRC[paramInt] + 1), Integer.valueOf(j));
      AppMethodBeat.o(175946);
      return localPair;
    }
    AppMethodBeat.o(175946);
    return null;
  }
  
  private int rd(int paramInt)
  {
    int i = 0;
    while (i < this.iRC.length)
    {
      if (paramInt <= this.iRC[i]) {
        return i;
      }
      i += 1;
    }
    return 0;
  }
  
  private long re(int paramInt)
  {
    if (this.iRk != null) {
      return this.iRk[paramInt];
    }
    if (this.iRt != null) {
      return this.iRt[paramInt];
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
    this.iQI = new long[(int)(this.duration / this.iQF) + 2];
    Arrays.fill(this.iQI, -1L);
    Object localObject = this.iQI;
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
        this.iRs = new long[n];
        Arrays.fill(this.iRs, 0L);
        j = 0;
        while (j < n)
        {
          localObject = new n();
          ((n)localObject).hkd = i1;
          if (j == 0) {}
          for (m = 0;; m = j - 1)
          {
            long[] arrayOfLong = this.iRs;
            arrayOfLong[m] += ((n)localObject).hkd;
            this.iQK.add(localObject);
            k += i1;
            m = i + 1;
            i = k;
            while ((i >= this.iQF) && (paramInt < this.iQI.length))
            {
              i = (int)(i - this.iQF);
              this.iQI[paramInt] = m;
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
        if (m < this.iQI.length) {
          this.iQI[m] = n;
        }
        AppMethodBeat.o(133885);
        return 8L + l2;
      }
    }
  }
  
  final long a(RandomAccessFile paramRandomAccessFile, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(175945);
    Pair localPair1 = rc(paramInt1);
    Pair localPair2 = rc(paramInt2);
    if ((localPair1 != null) && (localPair2 != null))
    {
      if (this.iRo == 0L) {}
      int i;
      for (Integer localInteger = (Integer)localPair1.first;; localInteger = (Integer)localPair1.second)
      {
        paramInt2 = localInteger.intValue();
        i = ((Integer)localPair2.second).intValue();
        ad.i("MicroMsg.StblAtom", "incrementParseStsz, startSampleId:%s, endSampleId:%s, sampleSizeTable.size:%s, startRange:%s, endRange:%s, stszLazyStartPos:%s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(i), Integer.valueOf(this.boK.length), localPair1, localPair2, Long.valueOf(this.iRp) });
        if (paramInt2 <= i) {
          break;
        }
        AppMethodBeat.o(175945);
        return -1L;
      }
      if ((paramInt2 > this.boK.length) || (i > this.boK.length))
      {
        AppMethodBeat.o(175945);
        return -1L;
      }
      if (this.iRp < 0L)
      {
        AppMethodBeat.o(175945);
        return -1L;
      }
      if (this.iRu == null)
      {
        AppMethodBeat.o(175945);
        return -1L;
      }
      paramInt1 = (paramInt2 - 1) * 4;
      for (;;)
      {
        if ((paramInt1 < this.iRu.length) && (paramInt2 <= i))
        {
          int j = c.readInt(this.iRu, paramInt1);
          this.boK[paramInt2] = j;
          paramInt2 += 1;
          if (0L >= this.iRq) {
            ad.d("MicroMsg.StblAtom", "read stsz atom end");
          }
        }
        else
        {
          ad.i("MicroMsg.StblAtom", "incrementParseStsz finish, filePos:%s, offset:%s, sampleSizeTableData.length:%s", new Object[] { Long.valueOf(paramRandomAccessFile.getFilePointer()), Integer.valueOf(paramInt1), Integer.valueOf(this.iRu.length) });
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
    this.iRm = new int[i];
    this.iRn = new int[i];
    long l1 = 0L;
    paramInt = paramRandomAccessFile.read(arrayOfByte);
    i = 0;
    for (;;)
    {
      long l2 = l1;
      if (paramInt >= 12)
      {
        l1 += paramInt;
        this.iRm[i] = c.readInt(arrayOfByte, 0);
        this.iRn[i] = c.readInt(arrayOfByte, 4);
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
    ad.i("MicroMsg.StblAtom", "incrementCreateTimeTable, startSecond:%s, endSecond:%s, timeTable.length:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(this.iQI.length) });
    long l1 = bt.HI();
    if (this.iRC == null)
    {
      aQT();
      ad.i("MicroMsg.StblAtom", "createChunkTable cost:%sms", new Object[] { Long.valueOf(bt.aO(l1)) });
    }
    long l3;
    if (paramInt1 > 0)
    {
      l2 = bt.HI();
      l3 = a(paramRandomAccessFile, paramInt1, paramInt2);
      ad.i("MicroMsg.StblAtom", "incrementCreateTimeTable, incrementParseStsz ret:%s, cost:%sms", new Object[] { Long.valueOf(l3), Long.valueOf(bt.aO(l2)) });
      if (l3 < 0L)
      {
        AppMethodBeat.o(175947);
        return false;
      }
    }
    long l2 = bt.HI();
    int i = Math.min(paramInt1, this.iQI.length - 1);
    int j = Math.min(paramInt2, this.iQI.length - 1);
    paramRandomAccessFile = rc(paramInt1);
    Pair localPair = rc(paramInt2);
    ad.i("MicroMsg.StblAtom", "incrementCreateTimeTable, start:%s, end:%s, startSampleIdRange:%s, endSampleIdRange:%s, calcSampleRangeCost:%sms, chunkTable.size:%s", new Object[] { Integer.valueOf(i), Integer.valueOf(j), paramRandomAccessFile, localPair, Long.valueOf(bt.aO(l2)), Integer.valueOf(this.iRC.length) });
    l2 = bt.HI();
    paramInt1 = i;
    int k;
    if (paramInt1 <= j)
    {
      i = (int)this.iQI[paramInt1];
      l3 = bt.HI();
      k = rd(i);
      l3 = bt.aO(l3);
      if (k > 0) {}
      for (paramInt2 = k - 1;; paramInt2 = 0)
      {
        paramInt2 = this.iRC[paramInt2] + 1;
        long l5 = bt.HI();
        long l4 = dz(paramInt2, i);
        l5 = bt.aO(l5);
        long l6 = re(k);
        this.iQI[paramInt1] = (l6 + l4);
        ad.d("MicroMsg.StblAtom", "sampleId:%s, sampleBeginId:%s, chunkId:%s, sampleSize:%s, chunkOffset:%s, calcChunkId cost:%sms, calcSampleSizeCost:%sms", new Object[] { Integer.valueOf(i), Integer.valueOf(paramInt2), Integer.valueOf(k), Long.valueOf(l4), Long.valueOf(l6), Long.valueOf(l3), Long.valueOf(l5) });
        paramInt1 += 1;
        break;
      }
    }
    ad.d("MicroMsg.StblAtom", "updateTimeTable cost:%sms", new Object[] { Long.valueOf(bt.aO(l2)) });
    this.iRz = this.iQI[(j - 1)];
    int i5;
    int i6;
    int i4;
    int i3;
    if ((paramRandomAccessFile != null) && (localPair != null))
    {
      if (this.iRo == 0L) {}
      for (paramRandomAccessFile = (Integer)paramRandomAccessFile.first;; paramRandomAccessFile = (Integer)paramRandomAccessFile.second)
      {
        i5 = paramRandomAccessFile.intValue();
        i6 = ((Integer)localPair.second).intValue();
        int i1 = -1;
        j = -1;
        int i2 = -1;
        int m = -1;
        l2 = bt.HI();
        paramInt1 = 0;
        for (;;)
        {
          paramInt2 = m;
          i4 = i2;
          i = j;
          i3 = i1;
          if (paramInt1 >= this.iRl.length) {
            break;
          }
          int n = i2;
          k = i1;
          if (i1 < 0)
          {
            n = i2;
            k = i1;
            if (this.iRl[paramInt1] - 1 >= i5 - 1)
            {
              n = this.iRl[paramInt1] - 1;
              k = paramInt1;
            }
          }
          i2 = m;
          i1 = j;
          if (j < 0)
          {
            i2 = m;
            i1 = j;
            if (this.iRl[paramInt1] - 1 >= i6 - 1)
            {
              i2 = this.iRl[paramInt1] - 1;
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
      ad.i("MicroMsg.StblAtom", "not found stssStart, set to last %s", new Object[] { Integer.valueOf(this.iRl.length - 1) });
      paramInt1 = this.iRl.length - 1;
      k = this.iRl[paramInt1] - 1;
    }
    for (;;)
    {
      if (i < 0)
      {
        ad.i("MicroMsg.StblAtom", "not found stssEnd, set to last %s", new Object[] { Integer.valueOf(this.iRl.length - 1) });
        j = this.iRl.length - 1;
        paramInt2 = this.iRl[j] - 1;
      }
      for (;;)
      {
        if (paramInt2 > i6) {}
        for (i = paramInt2;; i = i6)
        {
          if (i >= this.iQK.size()) {
            i = this.iQK.size() - 1;
          }
          for (;;)
          {
            ad.i("MicroMsg.StblAtom", "sample id range, start:%s, end:%s, sampleList.size:%s, stssStart:%s, stssEnd:%s, stssStartSampleId:%s, stssEndSampleId:%s, lastCalcSampleTimeOffset:%s, stssSampleId.length:%s, search cost:%sms", new Object[] { Integer.valueOf(i5), Integer.valueOf(i), Integer.valueOf(this.iQK.size()), Integer.valueOf(paramInt1), Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(paramInt2), Integer.valueOf(this.iRA), Integer.valueOf(this.iRl.length), Long.valueOf(bt.aO(l2)) });
            if ((i > i5) && (i < this.iQK.size()) && (this.iRs != null) && (i < this.iRs.length))
            {
              l2 = bt.HI();
              paramInt2 = i5;
              while (paramInt2 <= i)
              {
                paramRandomAccessFile = (n)this.iQK.get(paramInt2);
                k = paramInt2 + 1;
                paramRandomAccessFile.size = this.boK[k];
                paramRandomAccessFile.hkd = (((float)this.iRs[paramInt2] * 1.0F / (float)this.iQF * 1000.0F * 1000.0F));
                paramRandomAccessFile.id = k;
                paramInt2 += 1;
              }
              ad.i("MicroMsg.StblAtom", "increment parse sampleList cost:%sms, start:%s, lastCalcSampleTimeOffset:%s, end:%s", new Object[] { Long.valueOf(bt.aO(l2)), Integer.valueOf(i5), Integer.valueOf(this.iRA), Integer.valueOf(i) });
              this.iRA = i;
              l2 = bt.HI();
              if (this.iRl == null) {
                while (i5 <= i)
                {
                  if (this.iQQ[i5] == null)
                  {
                    paramRandomAccessFile = (n)this.iQK.get(i5);
                    paramRandomAccessFile.iRc = 1;
                    paramRandomAccessFile = new Pair(Integer.valueOf(i5), Long.valueOf(paramRandomAccessFile.hkd));
                    ad.v("MicroMsg.StblAtom", "stss key frame from sampleList [%s %s], current stssList.size:%d", new Object[] { paramRandomAccessFile.first, paramRandomAccessFile.second, Integer.valueOf(this.iQL.size()) });
                    this.iQQ[i5] = paramRandomAccessFile;
                  }
                  i5 += 1;
                }
              }
              ad.i("MicroMsg.StblAtom", "increment parse stssList from sampleId, stssStart:%s, stssEnd:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(j) });
              if (j >= paramInt1) {
                while (paramInt1 <= j)
                {
                  if (this.iQQ[paramInt1] == null)
                  {
                    paramRandomAccessFile = (n)this.iQK.get(this.iRl[paramInt1] - 1);
                    paramRandomAccessFile.iRc = 1;
                    paramRandomAccessFile = new Pair(Integer.valueOf(this.iRl[paramInt1] - 1), Long.valueOf(paramRandomAccessFile.hkd));
                    ad.v("MicroMsg.StblAtom", "stss key frame from sampleId [%s %s], current stssList.size:%d", new Object[] { paramRandomAccessFile.first, paramRandomAccessFile.second, Integer.valueOf(this.iQL.size()) });
                    this.iQQ[paramInt1] = paramRandomAccessFile;
                  }
                  paramInt1 += 1;
                }
              }
              ad.i("MicroMsg.StblAtom", "increment parse stssList cost:%sms, size:%s", new Object[] { Long.valueOf(bt.aO(l2)), Integer.valueOf(this.iQL.size()) });
            }
            ad.i("MicroMsg.StblAtom", "incrementCreateTimeTable cost:%sms", new Object[] { Long.valueOf(bt.aO(l1)) });
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
    this.iRk = new int[i + 1];
    paramInt = 1;
    long l1 = 0L;
    i = paramRandomAccessFile.read(arrayOfByte);
    for (;;)
    {
      long l2 = l1;
      if (i >= 4)
      {
        l1 += i;
        this.iRk[paramInt] = c.readInt(arrayOfByte, 0);
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
    this.iRt = new long[i + 1];
    paramInt = 1;
    i = paramRandomAccessFile.read(arrayOfByte);
    long l1 = 0L;
    for (;;)
    {
      long l2 = l1;
      if (i >= 8)
      {
        l1 += i;
        this.iRt[paramInt] = c.an(arrayOfByte);
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
    this.iRl = new int[i];
    paramInt = 0;
    i = paramRandomAccessFile.read(arrayOfByte);
    long l1 = 0L;
    for (;;)
    {
      long l2 = l1;
      if (i >= 4)
      {
        l1 += i;
        this.iRl[paramInt] = c.readInt(arrayOfByte, 0);
        if (l1 >= l3)
        {
          ad.d("MicroMsg.StblAtom", "read stss atom end");
          l2 = l1;
        }
      }
      else
      {
        ad.i("MicroMsg.StblAtom", "handleStssAtom, stssSampleId.size:%s", new Object[] { Integer.valueOf(this.iRl.length) });
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
    long l3 = bt.HI();
    long l1 = getSize();
    byte[] arrayOfByte = new byte[8];
    int j = 0;
    int m = 0;
    int k = 0;
    int n = 0;
    int i1 = 0;
    long l4 = bt.HI();
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
        if (i7 == a.bma)
        {
          this.iRd = paramRandomAccessFile.getFilePointer();
          l1 = a(paramRandomAccessFile, i6);
          ad.i("MicroMsg.StblAtom", "handleSttsAtom cost:%sms", new Object[] { Long.valueOf(bt.aO(l3)) });
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
          if (i7 == a.bmd)
          {
            this.iRe = paramRandomAccessFile.getFilePointer();
            l1 = b(paramRandomAccessFile, i6);
            ad.i("MicroMsg.StblAtom", "handleStscAtom cost:%sms", new Object[] { Long.valueOf(bt.aO(l3)) });
            i3 = 1;
            i2 = n;
            i = m;
            i4 = j;
          }
          else if (i7 == a.bmg)
          {
            this.iRf = paramRandomAccessFile.getFilePointer();
            l1 = c(paramRandomAccessFile, i6);
            ad.i("MicroMsg.StblAtom", "handleStcoAtom cost:%sms", new Object[] { Long.valueOf(bt.aO(l3)) });
            i = 1;
            i2 = n;
            i3 = k;
            i4 = j;
          }
          else if (i7 == a.bmh)
          {
            this.iRg = paramRandomAccessFile.getFilePointer();
            l1 = d(paramRandomAccessFile, i6);
            ad.i("MicroMsg.StblAtom", "handleCo64Atom cost:%sms", new Object[] { Long.valueOf(bt.aO(l3)) });
            i = 1;
            i2 = n;
            i3 = k;
            i4 = j;
          }
          else if (i7 == a.bme)
          {
            this.iRh = paramRandomAccessFile.getFilePointer();
            ad.i("MicroMsg.StblAtom", "stsz atom pos:%s", new Object[] { Long.valueOf(this.iRh) });
            l1 = e(paramRandomAccessFile, i6);
            ad.i("MicroMsg.StblAtom", "handleStszAtom cost:%sms", new Object[] { Long.valueOf(bt.aO(l3)) });
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
            if (i7 == a.bmb)
            {
              this.iRi = paramRandomAccessFile.getFilePointer();
              l1 = f(paramRandomAccessFile, i6);
              ad.i("MicroMsg.StblAtom", "handleStssAtom cost:%sms", new Object[] { Long.valueOf(bt.aO(l3)) });
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
        ad.i("MicroMsg.StblAtom", "parse all atoms cost %sms", new Object[] { Long.valueOf(bt.aO(l4)) });
        l1 = bt.HI();
        aQS();
        ad.i("MicroMsg.StblAtom", "createTimeTable cost:%sms", new Object[] { Long.valueOf(bt.aO(l1)) });
        ad.i("MicroMsg.StblAtom", "parse stbl atom cost:%sms", new Object[] { Long.valueOf(bt.aO(l3)) });
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.a.o
 * JD-Core Version:    0.7.0.1
 */