package com.tencent.mm.plugin.a;

import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
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
  long[] iTB;
  List<n> iTD;
  List<Pair> iTE;
  Pair<Integer, Long>[] iTJ;
  long iTW;
  long iTX;
  long iTY;
  long iTZ;
  long iTy;
  long iUa;
  long iUb;
  int iUc;
  private int[] iUd;
  int[] iUe;
  private int[] iUf;
  private int[] iUg;
  long iUh;
  long iUi;
  long iUj;
  boolean iUk;
  private long[] iUl;
  private long[] iUm;
  byte[] iUn;
  private byte[] iUo;
  private long iUp;
  private long iUq;
  private long iUr;
  private long iUs;
  private int iUt;
  private HashMap<Integer, Long> iUu;
  private int[] iUv;
  
  public o(int paramInt1, long paramLong, int paramInt2)
  {
    super(paramInt1, paramLong, paramInt2, 0L);
    AppMethodBeat.i(133883);
    this.iTD = new ArrayList();
    this.iTE = new ArrayList();
    this.iUh = 0L;
    this.iUi = 0L;
    this.iUj = 0L;
    this.iUk = false;
    this.iUl = null;
    this.iUn = null;
    this.iUo = new byte[4];
    this.iUp = 0L;
    this.iUq = 0L;
    this.iUr = 0L;
    this.iUs = 0L;
    this.iUt = 0;
    this.iUu = new HashMap();
    AppMethodBeat.o(133883);
  }
  
  private boolean aRr()
  {
    AppMethodBeat.i(133891);
    long l1 = bu.HQ();
    aRs();
    ae.i("MicroMsg.StblAtom", "createChunkTable cost:%sms", new Object[] { Long.valueOf(bu.aO(l1)) });
    int i = 0;
    int k;
    while (i < this.iTB.length)
    {
      j = (int)this.iTB[i];
      k = rg(j);
      int m = this.iUv[(k - 1)] + 1;
      ae.d("MicroMsg.StblAtom", "sampleId : " + j + " chunkId : " + k + ", sampleBeginId: " + m);
      l1 = dz(m, j);
      l2 = rh(k);
      this.iTB[i] = (l2 + l1);
      i += 1;
    }
    this.iUs = this.iTB[(this.iTB.length - 1)];
    long l3 = bu.HQ();
    i = 1;
    int j = 0;
    l1 = 0L;
    Object localObject = this.iTD.iterator();
    long l2 = 0L;
    if (((Iterator)localObject).hasNext())
    {
      n localn = (n)((Iterator)localObject).next();
      localn.size = this.boK[i];
      k = rg(i);
      if (k != j) {}
      for (localn.start = rh(k);; localn.start = l2)
      {
        l2 = localn.start + localn.size;
        l1 += localn.hmR;
        localn.hmR = (((float)l1 * 1.0F / (float)this.iTy * 1000.0F * 1000.0F));
        localn.id = i;
        j = k;
        i += 1;
        break;
      }
    }
    ae.i("MicroMsg.StblAtom", "parse sampleList cost:%sms, size:%s", new Object[] { Long.valueOf(bu.aO(l3)), Integer.valueOf(this.iTD.size()) });
    l1 = bu.HQ();
    if (this.iUe == null)
    {
      i = 0;
      while (i < this.iTD.size())
      {
        localObject = (n)this.iTD.get(i);
        ((n)localObject).iTV = 1;
        localObject = new Pair(Integer.valueOf(i), Long.valueOf(((n)localObject).hmR));
        ae.v("MicroMsg.StblAtom", "stss key frame from sampleList [%s %s], current stssList.size:%d", new Object[] { ((Pair)localObject).first, ((Pair)localObject).second, Integer.valueOf(this.iTE.size()) });
        this.iTE.add(localObject);
        i += 1;
      }
    }
    i = 0;
    while (i < this.iUe.length)
    {
      localObject = (n)this.iTD.get(this.iUe[i] - 1);
      ((n)localObject).iTV = 1;
      localObject = new Pair(Integer.valueOf(this.iUe[i] - 1), Long.valueOf(((n)localObject).hmR));
      ae.v("MicroMsg.StblAtom", "stss key frame from sampleId [%s %s], current stssList.size:%d", new Object[] { ((Pair)localObject).first, ((Pair)localObject).second, Integer.valueOf(this.iTE.size()) });
      this.iTE.add(localObject);
      i += 1;
    }
    ae.i("MicroMsg.StblAtom", "parse stssList cost:%sms, size:%s", new Object[] { Long.valueOf(bu.aO(l1)), Integer.valueOf(this.iTE.size()) });
    AppMethodBeat.o(133891);
    return true;
  }
  
  private void aRs()
  {
    AppMethodBeat.i(175948);
    if (this.iUd != null) {}
    int m;
    for (int i = this.iUd.length;; i = this.iUm.length)
    {
      j = i - 1;
      m = this.iUf.length;
      i = 1;
      while (i < m)
      {
        this.iUf[(i - 1)] = (this.iUf[i] - this.iUf[(i - 1)]);
        i += 1;
      }
    }
    this.iUf[(m - 1)] = (j - this.iUf[(m - 1)] + 1);
    this.iUv = new int[j + 1];
    this.iUv[0] = 0;
    int j = 1;
    i = 0;
    while (i < m)
    {
      int n = this.iUf[i];
      int i1 = this.iUg[i];
      int k = 0;
      while (k < n)
      {
        int[] arrayOfInt = this.iUv;
        arrayOfInt[j] = (arrayOfInt[(j - 1)] + i1);
        j += 1;
        k += 1;
      }
      i += 1;
    }
    ae.i("MicroMsg.StblAtom", "create chunkTable size:%s", new Object[] { Integer.valueOf(this.iUv.length) });
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
      ae.w("MicroMsg.StblAtom", "stsz read sample size error");
      AppMethodBeat.o(133889);
      return -1L;
    }
    int j = c.readInt(arrayOfByte, 0);
    if (j > 0)
    {
      this.boK = new int[1];
      this.boK[0] = j;
      ae.i("MicroMsg.StblAtom", "all sample size is the same. size : ".concat(String.valueOf(j)));
      AppMethodBeat.o(133889);
      return 8L;
    }
    if (paramRandomAccessFile.read(arrayOfByte, 0, 4) < 4)
    {
      ae.w("MicroMsg.StblAtom", "stsz read entry count error");
      AppMethodBeat.o(133889);
      return -1L;
    }
    j = c.readInt(arrayOfByte, 0);
    long l3 = j * 4L;
    if ((l3 <= 0L) || (l3 > paramInt - 20))
    {
      ae.w("MicroMsg.StblAtom", "stco error entryCount : ".concat(String.valueOf(j)));
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
          ae.d("MicroMsg.StblAtom", "read stsz atom end");
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
  
  private Pair<Integer, Integer> rf(int paramInt)
  {
    int i = 0;
    AppMethodBeat.i(175946);
    if (this.iUv == null)
    {
      long l = bu.HQ();
      aRs();
      ae.i("MicroMsg.StblAtom", "createChunkTable cost:%sms", new Object[] { Long.valueOf(bu.aO(l)) });
    }
    if (paramInt < this.iTB.length)
    {
      int j = (int)this.iTB[paramInt];
      if (j < 0)
      {
        ae.e("MicroMsg.StblAtom", "calcSampleBeginEndId %s not found in timeTable", new Object[] { Integer.valueOf(paramInt) });
        AppMethodBeat.o(175946);
        return null;
      }
      int k = rg(j);
      paramInt = i;
      if (k > 0) {
        paramInt = k - 1;
      }
      Pair localPair = new Pair(Integer.valueOf(this.iUv[paramInt] + 1), Integer.valueOf(j));
      AppMethodBeat.o(175946);
      return localPair;
    }
    AppMethodBeat.o(175946);
    return null;
  }
  
  private int rg(int paramInt)
  {
    int i = 0;
    while (i < this.iUv.length)
    {
      if (paramInt <= this.iUv[i]) {
        return i;
      }
      i += 1;
    }
    return 0;
  }
  
  private long rh(int paramInt)
  {
    if (this.iUd != null) {
      return this.iUd[paramInt];
    }
    if (this.iUm != null) {
      return this.iUm[paramInt];
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
      ae.w("MicroMsg.StblAtom", "stts read entry count error");
      AppMethodBeat.o(133885);
      return -1L;
    }
    int i = c.readInt(arrayOfByte, 0);
    long l3 = i * 8L;
    if ((l3 > paramInt - 16) || (l3 <= 0L))
    {
      ae.w("MicroMsg.StblAtom", "stts error entryCount : ".concat(String.valueOf(i)));
      AppMethodBeat.o(133885);
      return -1L;
    }
    int k = 0;
    i = 0;
    this.iTB = new long[(int)(this.duration / this.iTy) + 2];
    Arrays.fill(this.iTB, -1L);
    Object localObject = this.iTB;
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
        this.iUl = new long[n];
        Arrays.fill(this.iUl, 0L);
        j = 0;
        while (j < n)
        {
          localObject = new n();
          ((n)localObject).hmR = i1;
          if (j == 0) {}
          for (m = 0;; m = j - 1)
          {
            long[] arrayOfLong = this.iUl;
            arrayOfLong[m] += ((n)localObject).hmR;
            this.iTD.add(localObject);
            k += i1;
            m = i + 1;
            i = k;
            while ((i >= this.iTy) && (paramInt < this.iTB.length))
            {
              i = (int)(i - this.iTy);
              this.iTB[paramInt] = m;
              paramInt += 1;
            }
          }
          j += 1;
          k = i;
          i = m;
        }
        if (l1 >= l3)
        {
          ae.d("MicroMsg.StblAtom", "read stts Atom end");
          l2 = l1;
          m = paramInt;
          n = i;
        }
      }
      else
      {
        if (m < this.iTB.length) {
          this.iTB[m] = n;
        }
        AppMethodBeat.o(133885);
        return 8L + l2;
      }
    }
  }
  
  final long a(RandomAccessFile paramRandomAccessFile, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(175945);
    Pair localPair1 = rf(paramInt1);
    Pair localPair2 = rf(paramInt2);
    if ((localPair1 != null) && (localPair2 != null))
    {
      if (this.iUh == 0L) {}
      int i;
      for (Integer localInteger = (Integer)localPair1.first;; localInteger = (Integer)localPair1.second)
      {
        paramInt2 = localInteger.intValue();
        i = ((Integer)localPair2.second).intValue();
        ae.i("MicroMsg.StblAtom", "incrementParseStsz, startSampleId:%s, endSampleId:%s, sampleSizeTable.size:%s, startRange:%s, endRange:%s, stszLazyStartPos:%s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(i), Integer.valueOf(this.boK.length), localPair1, localPair2, Long.valueOf(this.iUi) });
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
      if (this.iUi < 0L)
      {
        AppMethodBeat.o(175945);
        return -1L;
      }
      if (this.iUn == null)
      {
        AppMethodBeat.o(175945);
        return -1L;
      }
      paramInt1 = (paramInt2 - 1) * 4;
      for (;;)
      {
        if ((paramInt1 < this.iUn.length) && (paramInt2 <= i))
        {
          int j = c.readInt(this.iUn, paramInt1);
          this.boK[paramInt2] = j;
          paramInt2 += 1;
          if (0L >= this.iUj) {
            ae.d("MicroMsg.StblAtom", "read stsz atom end");
          }
        }
        else
        {
          ae.i("MicroMsg.StblAtom", "incrementParseStsz finish, filePos:%s, offset:%s, sampleSizeTableData.length:%s", new Object[] { Long.valueOf(paramRandomAccessFile.getFilePointer()), Integer.valueOf(paramInt1), Integer.valueOf(this.iUn.length) });
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
      ae.w("MicroMsg.StblAtom", "stsc read entry count error");
      AppMethodBeat.o(133886);
      return -1L;
    }
    int i = c.readInt(arrayOfByte, 0);
    long l3 = i * 12L;
    if ((l3 > paramInt - 16) || (l3 <= 0L))
    {
      ae.w("MicroMsg.StblAtom", "stsc error entryCount : ".concat(String.valueOf(i)));
      AppMethodBeat.o(133886);
      return -1L;
    }
    ae.d("MicroMsg.StblAtom", "handle stsc entryCount : ".concat(String.valueOf(i)));
    this.iUf = new int[i];
    this.iUg = new int[i];
    long l1 = 0L;
    paramInt = paramRandomAccessFile.read(arrayOfByte);
    i = 0;
    for (;;)
    {
      long l2 = l1;
      if (paramInt >= 12)
      {
        l1 += paramInt;
        this.iUf[i] = c.readInt(arrayOfByte, 0);
        this.iUg[i] = c.readInt(arrayOfByte, 4);
        i += 1;
        if (l1 >= l3)
        {
          ae.d("MicroMsg.StblAtom", "read stsc atom end");
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
    ae.i("MicroMsg.StblAtom", "incrementCreateTimeTable, startSecond:%s, endSecond:%s, timeTable.length:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(this.iTB.length) });
    long l1 = bu.HQ();
    if (this.iUv == null)
    {
      aRs();
      ae.i("MicroMsg.StblAtom", "createChunkTable cost:%sms", new Object[] { Long.valueOf(bu.aO(l1)) });
    }
    long l3;
    if (paramInt1 > 0)
    {
      l2 = bu.HQ();
      l3 = a(paramRandomAccessFile, paramInt1, paramInt2);
      ae.i("MicroMsg.StblAtom", "incrementCreateTimeTable, incrementParseStsz ret:%s, cost:%sms", new Object[] { Long.valueOf(l3), Long.valueOf(bu.aO(l2)) });
      if (l3 < 0L)
      {
        AppMethodBeat.o(175947);
        return false;
      }
    }
    long l2 = bu.HQ();
    int i = Math.min(paramInt1, this.iTB.length - 1);
    int j = Math.min(paramInt2, this.iTB.length - 1);
    paramRandomAccessFile = rf(paramInt1);
    Pair localPair = rf(paramInt2);
    ae.i("MicroMsg.StblAtom", "incrementCreateTimeTable, start:%s, end:%s, startSampleIdRange:%s, endSampleIdRange:%s, calcSampleRangeCost:%sms, chunkTable.size:%s", new Object[] { Integer.valueOf(i), Integer.valueOf(j), paramRandomAccessFile, localPair, Long.valueOf(bu.aO(l2)), Integer.valueOf(this.iUv.length) });
    l2 = bu.HQ();
    paramInt1 = i;
    int k;
    if (paramInt1 <= j)
    {
      i = (int)this.iTB[paramInt1];
      l3 = bu.HQ();
      k = rg(i);
      l3 = bu.aO(l3);
      if (k > 0) {}
      for (paramInt2 = k - 1;; paramInt2 = 0)
      {
        paramInt2 = this.iUv[paramInt2] + 1;
        long l5 = bu.HQ();
        long l4 = dz(paramInt2, i);
        l5 = bu.aO(l5);
        long l6 = rh(k);
        this.iTB[paramInt1] = (l6 + l4);
        ae.d("MicroMsg.StblAtom", "sampleId:%s, sampleBeginId:%s, chunkId:%s, sampleSize:%s, chunkOffset:%s, calcChunkId cost:%sms, calcSampleSizeCost:%sms", new Object[] { Integer.valueOf(i), Integer.valueOf(paramInt2), Integer.valueOf(k), Long.valueOf(l4), Long.valueOf(l6), Long.valueOf(l3), Long.valueOf(l5) });
        paramInt1 += 1;
        break;
      }
    }
    ae.d("MicroMsg.StblAtom", "updateTimeTable cost:%sms", new Object[] { Long.valueOf(bu.aO(l2)) });
    this.iUs = this.iTB[(j - 1)];
    int i5;
    int i6;
    int i4;
    int i3;
    if ((paramRandomAccessFile != null) && (localPair != null))
    {
      if (this.iUh == 0L) {}
      for (paramRandomAccessFile = (Integer)paramRandomAccessFile.first;; paramRandomAccessFile = (Integer)paramRandomAccessFile.second)
      {
        i5 = paramRandomAccessFile.intValue();
        i6 = ((Integer)localPair.second).intValue();
        int i1 = -1;
        j = -1;
        int i2 = -1;
        int m = -1;
        l2 = bu.HQ();
        paramInt1 = 0;
        for (;;)
        {
          paramInt2 = m;
          i4 = i2;
          i = j;
          i3 = i1;
          if (paramInt1 >= this.iUe.length) {
            break;
          }
          int n = i2;
          k = i1;
          if (i1 < 0)
          {
            n = i2;
            k = i1;
            if (this.iUe[paramInt1] - 1 >= i5 - 1)
            {
              n = this.iUe[paramInt1] - 1;
              k = paramInt1;
            }
          }
          i2 = m;
          i1 = j;
          if (j < 0)
          {
            i2 = m;
            i1 = j;
            if (this.iUe[paramInt1] - 1 >= i6 - 1)
            {
              i2 = this.iUe[paramInt1] - 1;
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
      ae.i("MicroMsg.StblAtom", "not found stssStart, set to last %s", new Object[] { Integer.valueOf(this.iUe.length - 1) });
      paramInt1 = this.iUe.length - 1;
      k = this.iUe[paramInt1] - 1;
    }
    for (;;)
    {
      if (i < 0)
      {
        ae.i("MicroMsg.StblAtom", "not found stssEnd, set to last %s", new Object[] { Integer.valueOf(this.iUe.length - 1) });
        j = this.iUe.length - 1;
        paramInt2 = this.iUe[j] - 1;
      }
      for (;;)
      {
        if (paramInt2 > i6) {}
        for (i = paramInt2;; i = i6)
        {
          if (i >= this.iTD.size()) {
            i = this.iTD.size() - 1;
          }
          for (;;)
          {
            ae.i("MicroMsg.StblAtom", "sample id range, start:%s, end:%s, sampleList.size:%s, stssStart:%s, stssEnd:%s, stssStartSampleId:%s, stssEndSampleId:%s, lastCalcSampleTimeOffset:%s, stssSampleId.length:%s, search cost:%sms", new Object[] { Integer.valueOf(i5), Integer.valueOf(i), Integer.valueOf(this.iTD.size()), Integer.valueOf(paramInt1), Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(paramInt2), Integer.valueOf(this.iUt), Integer.valueOf(this.iUe.length), Long.valueOf(bu.aO(l2)) });
            if ((i > i5) && (i < this.iTD.size()) && (this.iUl != null) && (i < this.iUl.length))
            {
              l2 = bu.HQ();
              paramInt2 = i5;
              while (paramInt2 <= i)
              {
                paramRandomAccessFile = (n)this.iTD.get(paramInt2);
                k = paramInt2 + 1;
                paramRandomAccessFile.size = this.boK[k];
                paramRandomAccessFile.hmR = (((float)this.iUl[paramInt2] * 1.0F / (float)this.iTy * 1000.0F * 1000.0F));
                paramRandomAccessFile.id = k;
                paramInt2 += 1;
              }
              ae.i("MicroMsg.StblAtom", "increment parse sampleList cost:%sms, start:%s, lastCalcSampleTimeOffset:%s, end:%s", new Object[] { Long.valueOf(bu.aO(l2)), Integer.valueOf(i5), Integer.valueOf(this.iUt), Integer.valueOf(i) });
              this.iUt = i;
              l2 = bu.HQ();
              if (this.iUe == null) {
                while (i5 <= i)
                {
                  if (this.iTJ[i5] == null)
                  {
                    paramRandomAccessFile = (n)this.iTD.get(i5);
                    paramRandomAccessFile.iTV = 1;
                    paramRandomAccessFile = new Pair(Integer.valueOf(i5), Long.valueOf(paramRandomAccessFile.hmR));
                    ae.v("MicroMsg.StblAtom", "stss key frame from sampleList [%s %s], current stssList.size:%d", new Object[] { paramRandomAccessFile.first, paramRandomAccessFile.second, Integer.valueOf(this.iTE.size()) });
                    this.iTJ[i5] = paramRandomAccessFile;
                  }
                  i5 += 1;
                }
              }
              ae.i("MicroMsg.StblAtom", "increment parse stssList from sampleId, stssStart:%s, stssEnd:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(j) });
              if (j >= paramInt1) {
                while (paramInt1 <= j)
                {
                  if (this.iTJ[paramInt1] == null)
                  {
                    paramRandomAccessFile = (n)this.iTD.get(this.iUe[paramInt1] - 1);
                    paramRandomAccessFile.iTV = 1;
                    paramRandomAccessFile = new Pair(Integer.valueOf(this.iUe[paramInt1] - 1), Long.valueOf(paramRandomAccessFile.hmR));
                    ae.v("MicroMsg.StblAtom", "stss key frame from sampleId [%s %s], current stssList.size:%d", new Object[] { paramRandomAccessFile.first, paramRandomAccessFile.second, Integer.valueOf(this.iTE.size()) });
                    this.iTJ[paramInt1] = paramRandomAccessFile;
                  }
                  paramInt1 += 1;
                }
              }
              ae.i("MicroMsg.StblAtom", "increment parse stssList cost:%sms, size:%s", new Object[] { Long.valueOf(bu.aO(l2)), Integer.valueOf(this.iTE.size()) });
            }
            ae.i("MicroMsg.StblAtom", "incrementCreateTimeTable cost:%sms", new Object[] { Long.valueOf(bu.aO(l1)) });
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
      ae.w("MicroMsg.StblAtom", "stco read entry count error");
      AppMethodBeat.o(133887);
      return -1L;
    }
    int i = c.readInt(arrayOfByte, 0);
    long l3 = 4L * i;
    if ((l3 <= 0L) || (l3 > paramInt - 16))
    {
      ae.w("MicroMsg.StblAtom", "stco error entryCount : ".concat(String.valueOf(i)));
      AppMethodBeat.o(133887);
      return -1L;
    }
    this.iUd = new int[i + 1];
    paramInt = 1;
    long l1 = 0L;
    i = paramRandomAccessFile.read(arrayOfByte);
    for (;;)
    {
      long l2 = l1;
      if (i >= 4)
      {
        l1 += i;
        this.iUd[paramInt] = c.readInt(arrayOfByte, 0);
        if (l1 >= l3)
        {
          ae.d("MicroMsg.StblAtom", "read stco atom end");
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
      ae.w("MicroMsg.StblAtom", "co64 read entry count error");
      AppMethodBeat.o(133888);
      return -1L;
    }
    int i = c.readInt(arrayOfByte, 0);
    long l3 = i * 8L;
    if ((l3 <= 0L) || (l3 > paramInt - 16))
    {
      ae.w("MicroMsg.StblAtom", "stco error entryCount : ".concat(String.valueOf(i)));
      AppMethodBeat.o(133888);
      return -1L;
    }
    this.iUm = new long[i + 1];
    paramInt = 1;
    i = paramRandomAccessFile.read(arrayOfByte);
    long l1 = 0L;
    for (;;)
    {
      long l2 = l1;
      if (i >= 8)
      {
        l1 += i;
        this.iUm[paramInt] = c.an(arrayOfByte);
        if (l1 >= l3)
        {
          ae.d("MicroMsg.StblAtom", "read stco atom end");
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
      ae.w("MicroMsg.StblAtom", "stss rread entry count error");
      AppMethodBeat.o(133890);
      return -1L;
    }
    int i = c.readInt(arrayOfByte, 0);
    long l3 = 4L * i;
    if ((l3 <= 0L) || (l3 > paramInt - 16))
    {
      ae.w("MicroMsg.StblAtom", "stss error entryCount : ".concat(String.valueOf(i)));
      AppMethodBeat.o(133890);
      return -1L;
    }
    this.iUe = new int[i];
    paramInt = 0;
    i = paramRandomAccessFile.read(arrayOfByte);
    long l1 = 0L;
    for (;;)
    {
      long l2 = l1;
      if (i >= 4)
      {
        l1 += i;
        this.iUe[paramInt] = c.readInt(arrayOfByte, 0);
        if (l1 >= l3)
        {
          ae.d("MicroMsg.StblAtom", "read stss atom end");
          l2 = l1;
        }
      }
      else
      {
        ae.i("MicroMsg.StblAtom", "handleStssAtom, stssSampleId.size:%s", new Object[] { Integer.valueOf(this.iUe.length) });
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
    long l3 = bu.HQ();
    long l1 = getSize();
    byte[] arrayOfByte = new byte[8];
    int j = 0;
    int m = 0;
    int k = 0;
    int n = 0;
    int i1 = 0;
    long l4 = bu.HQ();
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
        ae.i("MicroMsg.StblAtom", "readAtom, type:%s, size:%s", new Object[] { Integer.valueOf(i7), Integer.valueOf(i6) });
        l1 = 0L;
        if (i7 == a.bma)
        {
          this.iTW = paramRandomAccessFile.getFilePointer();
          l1 = a(paramRandomAccessFile, i6);
          ae.i("MicroMsg.StblAtom", "handleSttsAtom cost:%sms", new Object[] { Long.valueOf(bu.aO(l3)) });
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
            this.iTX = paramRandomAccessFile.getFilePointer();
            l1 = b(paramRandomAccessFile, i6);
            ae.i("MicroMsg.StblAtom", "handleStscAtom cost:%sms", new Object[] { Long.valueOf(bu.aO(l3)) });
            i3 = 1;
            i2 = n;
            i = m;
            i4 = j;
          }
          else if (i7 == a.bmg)
          {
            this.iTY = paramRandomAccessFile.getFilePointer();
            l1 = c(paramRandomAccessFile, i6);
            ae.i("MicroMsg.StblAtom", "handleStcoAtom cost:%sms", new Object[] { Long.valueOf(bu.aO(l3)) });
            i = 1;
            i2 = n;
            i3 = k;
            i4 = j;
          }
          else if (i7 == a.bmh)
          {
            this.iTZ = paramRandomAccessFile.getFilePointer();
            l1 = d(paramRandomAccessFile, i6);
            ae.i("MicroMsg.StblAtom", "handleCo64Atom cost:%sms", new Object[] { Long.valueOf(bu.aO(l3)) });
            i = 1;
            i2 = n;
            i3 = k;
            i4 = j;
          }
          else if (i7 == a.bme)
          {
            this.iUa = paramRandomAccessFile.getFilePointer();
            ae.i("MicroMsg.StblAtom", "stsz atom pos:%s", new Object[] { Long.valueOf(this.iUa) });
            l1 = e(paramRandomAccessFile, i6);
            ae.i("MicroMsg.StblAtom", "handleStszAtom cost:%sms", new Object[] { Long.valueOf(bu.aO(l3)) });
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
              this.iUb = paramRandomAccessFile.getFilePointer();
              l1 = f(paramRandomAccessFile, i6);
              ae.i("MicroMsg.StblAtom", "handleStssAtom cost:%sms", new Object[] { Long.valueOf(bu.aO(l3)) });
              i1 = 1;
              i2 = n;
              i3 = k;
              i = m;
              i4 = j;
            }
          }
        }
        if ((i4 != 0) && (i != 0) && (i3 != 0) && (i2 != 0) && (i1 != 0)) {
          ae.i("MicroMsg.StblAtom", "read stbl atom finish");
        }
      }
      else
      {
        ae.i("MicroMsg.StblAtom", "parse all atoms cost %sms", new Object[] { Long.valueOf(bu.aO(l4)) });
        l1 = bu.HQ();
        aRr();
        ae.i("MicroMsg.StblAtom", "createTimeTable cost:%sms", new Object[] { Long.valueOf(bu.aO(l1)) });
        ae.i("MicroMsg.StblAtom", "parse stbl atom cost:%sms", new Object[] { Long.valueOf(bu.aO(l3)) });
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