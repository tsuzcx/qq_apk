package com.tencent.mm.plugin.a;

import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
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
  int[] cSd;
  long duration;
  long pEA;
  long pEB;
  long pEC;
  long pED;
  long pEE;
  long pEF;
  int pEG;
  private int[] pEH;
  int[] pEI;
  private int[] pEJ;
  private int[] pEK;
  long pEL;
  long pEM;
  long pEN;
  boolean pEO;
  private long[] pEP;
  private long[] pEQ;
  byte[] pER;
  private byte[] pES;
  private long pET;
  private long pEU;
  private long pEV;
  private long pEW;
  private int pEX;
  private HashMap<Integer, Long> pEY;
  private int[] pEZ;
  long pEc;
  long[] pEf;
  List<n> pEh;
  List<Pair> pEi;
  Pair<Integer, Long>[] pEn;
  
  public o(int paramInt1, long paramLong, int paramInt2)
  {
    super(paramInt1, paramLong, paramInt2, 0L);
    AppMethodBeat.i(133883);
    this.pEh = new ArrayList();
    this.pEi = new ArrayList();
    this.pEL = 0L;
    this.pEM = 0L;
    this.pEN = 0L;
    this.pEO = false;
    this.pEP = null;
    this.pER = null;
    this.pES = new byte[4];
    this.pET = 0L;
    this.pEU = 0L;
    this.pEV = 0L;
    this.pEW = 0L;
    this.pEX = 0;
    this.pEY = new HashMap();
    AppMethodBeat.o(133883);
  }
  
  private boolean bTX()
  {
    AppMethodBeat.i(133891);
    long l1 = Util.currentTicks();
    bTY();
    Log.i("MicroMsg.StblAtom", "createChunkTable cost:%sms", new Object[] { Long.valueOf(Util.ticksToNow(l1)) });
    int i = 0;
    int k;
    while (i < this.pEf.length)
    {
      j = (int)this.pEf[i];
      k = yg(j);
      int m = this.pEZ[(k - 1)] + 1;
      Log.d("MicroMsg.StblAtom", "sampleId : " + j + " chunkId : " + k + ", sampleBeginId: " + m);
      l1 = eY(m, j);
      l2 = yh(k);
      this.pEf[i] = (l2 + l1);
      i += 1;
    }
    this.pEW = this.pEf[(this.pEf.length - 1)];
    long l3 = Util.currentTicks();
    i = 1;
    int j = 0;
    l1 = 0L;
    Object localObject = this.pEh.iterator();
    long l2 = 0L;
    if (((Iterator)localObject).hasNext())
    {
      n localn = (n)((Iterator)localObject).next();
      localn.size = this.cSd[i];
      k = yg(i);
      if (k != j) {}
      for (localn.start = yh(k);; localn.start = l2)
      {
        l2 = localn.start + localn.size;
        l1 += localn.nAv;
        localn.nAv = (((float)l1 * 1.0F / (float)this.pEc * 1000.0F * 1000.0F));
        localn.id = i;
        j = k;
        i += 1;
        break;
      }
    }
    Log.i("MicroMsg.StblAtom", "parse sampleList cost:%sms, size:%s", new Object[] { Long.valueOf(Util.ticksToNow(l3)), Integer.valueOf(this.pEh.size()) });
    l1 = Util.currentTicks();
    if (this.pEI == null)
    {
      i = 0;
      while (i < this.pEh.size())
      {
        localObject = (n)this.pEh.get(i);
        ((n)localObject).pEz = 1;
        localObject = new Pair(Integer.valueOf(i), Long.valueOf(((n)localObject).nAv));
        Log.v("MicroMsg.StblAtom", "stss key frame from sampleList [%s %s], current stssList.size:%d", new Object[] { ((Pair)localObject).first, ((Pair)localObject).second, Integer.valueOf(this.pEi.size()) });
        this.pEi.add(localObject);
        i += 1;
      }
    }
    i = 0;
    while (i < this.pEI.length)
    {
      localObject = (n)this.pEh.get(this.pEI[i] - 1);
      ((n)localObject).pEz = 1;
      localObject = new Pair(Integer.valueOf(this.pEI[i] - 1), Long.valueOf(((n)localObject).nAv));
      Log.v("MicroMsg.StblAtom", "stss key frame from sampleId [%s %s], current stssList.size:%d", new Object[] { ((Pair)localObject).first, ((Pair)localObject).second, Integer.valueOf(this.pEi.size()) });
      this.pEi.add(localObject);
      i += 1;
    }
    Log.i("MicroMsg.StblAtom", "parse stssList cost:%sms, size:%s", new Object[] { Long.valueOf(Util.ticksToNow(l1)), Integer.valueOf(this.pEi.size()) });
    AppMethodBeat.o(133891);
    return true;
  }
  
  private void bTY()
  {
    AppMethodBeat.i(175948);
    if (this.pEH != null) {}
    int m;
    for (int i = this.pEH.length;; i = this.pEQ.length)
    {
      j = i - 1;
      m = this.pEJ.length;
      i = 1;
      while (i < m)
      {
        this.pEJ[(i - 1)] = (this.pEJ[i] - this.pEJ[(i - 1)]);
        i += 1;
      }
    }
    this.pEJ[(m - 1)] = (j - this.pEJ[(m - 1)] + 1);
    this.pEZ = new int[j + 1];
    this.pEZ[0] = 0;
    int j = 1;
    i = 0;
    while (i < m)
    {
      int n = this.pEJ[i];
      int i1 = this.pEK[i];
      int k = 0;
      while (k < n)
      {
        int[] arrayOfInt = this.pEZ;
        arrayOfInt[j] = (arrayOfInt[(j - 1)] + i1);
        j += 1;
        k += 1;
      }
      i += 1;
    }
    Log.i("MicroMsg.StblAtom", "create chunkTable size:%s", new Object[] { Integer.valueOf(this.pEZ.length) });
    AppMethodBeat.o(175948);
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
      Log.w("MicroMsg.StblAtom", "stsz read sample size error");
      AppMethodBeat.o(133889);
      return -1L;
    }
    int j = c.readInt(arrayOfByte, 0);
    if (j > 0)
    {
      this.cSd = new int[1];
      this.cSd[0] = j;
      Log.i("MicroMsg.StblAtom", "all sample size is the same. size : ".concat(String.valueOf(j)));
      AppMethodBeat.o(133889);
      return 8L;
    }
    if (paramRandomAccessFile.read(arrayOfByte, 0, 4) < 4)
    {
      Log.w("MicroMsg.StblAtom", "stsz read entry count error");
      AppMethodBeat.o(133889);
      return -1L;
    }
    j = c.readInt(arrayOfByte, 0);
    long l3 = j * 4L;
    if ((l3 <= 0L) || (l3 > paramInt - 20))
    {
      Log.w("MicroMsg.StblAtom", "stco error entryCount : ".concat(String.valueOf(j)));
      AppMethodBeat.o(133889);
      return -1L;
    }
    this.cSd = new int[j + 1];
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
        this.cSd[paramInt] = c.readInt(arrayOfByte, 0);
        if (l1 >= l3)
        {
          Log.d("MicroMsg.StblAtom", "read stsz atom end");
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
  
  private long eY(int paramInt1, int paramInt2)
  {
    long l2;
    if (this.cSd.length == 1)
    {
      l2 = this.cSd[0] * (paramInt2 - paramInt1);
      return l2;
    }
    long l1 = 0L;
    for (;;)
    {
      l2 = l1;
      if (paramInt1 > paramInt2) {
        break;
      }
      l1 += this.cSd[paramInt1];
      paramInt1 += 1;
    }
  }
  
  private Pair<Integer, Integer> yf(int paramInt)
  {
    int i = 0;
    AppMethodBeat.i(175946);
    if (this.pEZ == null)
    {
      long l = Util.currentTicks();
      bTY();
      Log.i("MicroMsg.StblAtom", "createChunkTable cost:%sms", new Object[] { Long.valueOf(Util.ticksToNow(l)) });
    }
    if (paramInt < this.pEf.length)
    {
      int j = (int)this.pEf[paramInt];
      if (j < 0)
      {
        Log.e("MicroMsg.StblAtom", "calcSampleBeginEndId %s not found in timeTable", new Object[] { Integer.valueOf(paramInt) });
        AppMethodBeat.o(175946);
        return null;
      }
      int k = yg(j);
      paramInt = i;
      if (k > 0) {
        paramInt = k - 1;
      }
      Pair localPair = new Pair(Integer.valueOf(this.pEZ[paramInt] + 1), Integer.valueOf(j));
      AppMethodBeat.o(175946);
      return localPair;
    }
    AppMethodBeat.o(175946);
    return null;
  }
  
  private int yg(int paramInt)
  {
    int i = 0;
    while (i < this.pEZ.length)
    {
      if (paramInt <= this.pEZ[i]) {
        return i;
      }
      i += 1;
    }
    return 0;
  }
  
  private long yh(int paramInt)
  {
    if (this.pEH != null) {
      return this.pEH[paramInt];
    }
    if (this.pEQ != null) {
      return this.pEQ[paramInt];
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
      Log.w("MicroMsg.StblAtom", "stts read entry count error");
      AppMethodBeat.o(133885);
      return -1L;
    }
    int i = c.readInt(arrayOfByte, 0);
    long l3 = i * 8L;
    if ((l3 > paramInt - 16) || (l3 <= 0L))
    {
      Log.w("MicroMsg.StblAtom", "stts error entryCount : ".concat(String.valueOf(i)));
      AppMethodBeat.o(133885);
      return -1L;
    }
    int k = 0;
    i = 0;
    this.pEf = new long[(int)(this.duration / this.pEc) + 2];
    Arrays.fill(this.pEf, -1L);
    Object localObject = this.pEf;
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
        this.pEP = new long[n];
        Arrays.fill(this.pEP, 0L);
        j = 0;
        while (j < n)
        {
          localObject = new n();
          ((n)localObject).nAv = i1;
          if (j == 0) {}
          for (m = 0;; m = j - 1)
          {
            long[] arrayOfLong = this.pEP;
            arrayOfLong[m] += ((n)localObject).nAv;
            this.pEh.add(localObject);
            k += i1;
            m = i + 1;
            i = k;
            while ((i >= this.pEc) && (paramInt < this.pEf.length))
            {
              i = (int)(i - this.pEc);
              this.pEf[paramInt] = m;
              paramInt += 1;
            }
          }
          j += 1;
          k = i;
          i = m;
        }
        if (l1 >= l3)
        {
          Log.d("MicroMsg.StblAtom", "read stts Atom end");
          l2 = l1;
          m = paramInt;
          n = i;
        }
      }
      else
      {
        if (m < this.pEf.length) {
          this.pEf[m] = n;
        }
        AppMethodBeat.o(133885);
        return 8L + l2;
      }
    }
  }
  
  final long a(RandomAccessFile paramRandomAccessFile, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(175945);
    Pair localPair1 = yf(paramInt1);
    Pair localPair2 = yf(paramInt2);
    if ((localPair1 != null) && (localPair2 != null))
    {
      if (this.pEL == 0L) {}
      int i;
      for (Integer localInteger = (Integer)localPair1.first;; localInteger = (Integer)localPair1.second)
      {
        paramInt2 = localInteger.intValue();
        i = ((Integer)localPair2.second).intValue();
        Log.i("MicroMsg.StblAtom", "incrementParseStsz, startSampleId:%s, endSampleId:%s, sampleSizeTable.size:%s, startRange:%s, endRange:%s, stszLazyStartPos:%s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(i), Integer.valueOf(this.cSd.length), localPair1, localPair2, Long.valueOf(this.pEM) });
        if (paramInt2 <= i) {
          break;
        }
        AppMethodBeat.o(175945);
        return -1L;
      }
      if ((paramInt2 > this.cSd.length) || (i > this.cSd.length))
      {
        AppMethodBeat.o(175945);
        return -1L;
      }
      if (this.pEM < 0L)
      {
        AppMethodBeat.o(175945);
        return -1L;
      }
      if (this.pER == null)
      {
        AppMethodBeat.o(175945);
        return -1L;
      }
      paramInt1 = (paramInt2 - 1) * 4;
      for (;;)
      {
        if ((paramInt1 < this.pER.length) && (paramInt2 <= i))
        {
          int j = c.readInt(this.pER, paramInt1);
          this.cSd[paramInt2] = j;
          paramInt2 += 1;
          if (0L >= this.pEN) {
            Log.d("MicroMsg.StblAtom", "read stsz atom end");
          }
        }
        else
        {
          Log.i("MicroMsg.StblAtom", "incrementParseStsz finish, filePos:%s, offset:%s, sampleSizeTableData.length:%s", new Object[] { Long.valueOf(paramRandomAccessFile.getFilePointer()), Integer.valueOf(paramInt1), Integer.valueOf(this.pER.length) });
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
      Log.w("MicroMsg.StblAtom", "stsc read entry count error");
      AppMethodBeat.o(133886);
      return -1L;
    }
    int i = c.readInt(arrayOfByte, 0);
    long l3 = i * 12L;
    if ((l3 > paramInt - 16) || (l3 <= 0L))
    {
      Log.w("MicroMsg.StblAtom", "stsc error entryCount : ".concat(String.valueOf(i)));
      AppMethodBeat.o(133886);
      return -1L;
    }
    Log.d("MicroMsg.StblAtom", "handle stsc entryCount : ".concat(String.valueOf(i)));
    this.pEJ = new int[i];
    this.pEK = new int[i];
    long l1 = 0L;
    paramInt = paramRandomAccessFile.read(arrayOfByte);
    i = 0;
    for (;;)
    {
      long l2 = l1;
      if (paramInt >= 12)
      {
        l1 += paramInt;
        this.pEJ[i] = c.readInt(arrayOfByte, 0);
        this.pEK[i] = c.readInt(arrayOfByte, 4);
        i += 1;
        if (l1 >= l3)
        {
          Log.d("MicroMsg.StblAtom", "read stsc atom end");
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
    Log.i("MicroMsg.StblAtom", "incrementCreateTimeTable, startSecond:%s, endSecond:%s, timeTable.length:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(this.pEf.length) });
    long l1 = Util.currentTicks();
    if (this.pEZ == null)
    {
      bTY();
      Log.i("MicroMsg.StblAtom", "createChunkTable cost:%sms", new Object[] { Long.valueOf(Util.ticksToNow(l1)) });
    }
    long l3;
    if (paramInt1 > 0)
    {
      l2 = Util.currentTicks();
      l3 = a(paramRandomAccessFile, paramInt1, paramInt2);
      Log.i("MicroMsg.StblAtom", "incrementCreateTimeTable, incrementParseStsz ret:%s, cost:%sms", new Object[] { Long.valueOf(l3), Long.valueOf(Util.ticksToNow(l2)) });
      if (l3 < 0L)
      {
        AppMethodBeat.o(175947);
        return false;
      }
    }
    long l2 = Util.currentTicks();
    int i = Math.min(paramInt1, this.pEf.length - 1);
    int j = Math.min(paramInt2, this.pEf.length - 1);
    paramRandomAccessFile = yf(paramInt1);
    Pair localPair = yf(paramInt2);
    Log.i("MicroMsg.StblAtom", "incrementCreateTimeTable, start:%s, end:%s, startSampleIdRange:%s, endSampleIdRange:%s, calcSampleRangeCost:%sms, chunkTable.size:%s", new Object[] { Integer.valueOf(i), Integer.valueOf(j), paramRandomAccessFile, localPair, Long.valueOf(Util.ticksToNow(l2)), Integer.valueOf(this.pEZ.length) });
    l2 = Util.currentTicks();
    paramInt1 = i;
    int k;
    if (paramInt1 <= j)
    {
      i = (int)this.pEf[paramInt1];
      l3 = Util.currentTicks();
      k = yg(i);
      l3 = Util.ticksToNow(l3);
      if (k > 0) {}
      for (paramInt2 = k - 1;; paramInt2 = 0)
      {
        paramInt2 = this.pEZ[paramInt2] + 1;
        long l5 = Util.currentTicks();
        long l4 = eY(paramInt2, i);
        l5 = Util.ticksToNow(l5);
        long l6 = yh(k);
        this.pEf[paramInt1] = (l6 + l4);
        Log.d("MicroMsg.StblAtom", "sampleId:%s, sampleBeginId:%s, chunkId:%s, sampleSize:%s, chunkOffset:%s, calcChunkId cost:%sms, calcSampleSizeCost:%sms", new Object[] { Integer.valueOf(i), Integer.valueOf(paramInt2), Integer.valueOf(k), Long.valueOf(l4), Long.valueOf(l6), Long.valueOf(l3), Long.valueOf(l5) });
        paramInt1 += 1;
        break;
      }
    }
    Log.d("MicroMsg.StblAtom", "updateTimeTable cost:%sms", new Object[] { Long.valueOf(Util.ticksToNow(l2)) });
    this.pEW = this.pEf[(j - 1)];
    int i5;
    int i6;
    int i4;
    int i3;
    if ((paramRandomAccessFile != null) && (localPair != null))
    {
      if (this.pEL == 0L) {}
      for (paramRandomAccessFile = (Integer)paramRandomAccessFile.first;; paramRandomAccessFile = (Integer)paramRandomAccessFile.second)
      {
        i5 = paramRandomAccessFile.intValue();
        i6 = ((Integer)localPair.second).intValue();
        int i1 = -1;
        j = -1;
        int i2 = -1;
        int m = -1;
        l2 = Util.currentTicks();
        paramInt1 = 0;
        for (;;)
        {
          paramInt2 = m;
          i4 = i2;
          i = j;
          i3 = i1;
          if (paramInt1 >= this.pEI.length) {
            break;
          }
          int n = i2;
          k = i1;
          if (i1 < 0)
          {
            n = i2;
            k = i1;
            if (this.pEI[paramInt1] - 1 >= i5 - 1)
            {
              n = this.pEI[paramInt1] - 1;
              k = paramInt1;
            }
          }
          i2 = m;
          i1 = j;
          if (j < 0)
          {
            i2 = m;
            i1 = j;
            if (this.pEI[paramInt1] - 1 >= i6 - 1)
            {
              i2 = this.pEI[paramInt1] - 1;
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
      Log.i("MicroMsg.StblAtom", "not found stssStart, set to last %s", new Object[] { Integer.valueOf(this.pEI.length - 1) });
      paramInt1 = this.pEI.length - 1;
      k = this.pEI[paramInt1] - 1;
    }
    for (;;)
    {
      if (i < 0)
      {
        Log.i("MicroMsg.StblAtom", "not found stssEnd, set to last %s", new Object[] { Integer.valueOf(this.pEI.length - 1) });
        j = this.pEI.length - 1;
        paramInt2 = this.pEI[j] - 1;
      }
      for (;;)
      {
        if (paramInt2 > i6) {}
        for (i = paramInt2;; i = i6)
        {
          if (i >= this.pEh.size()) {
            i = this.pEh.size() - 1;
          }
          for (;;)
          {
            Log.i("MicroMsg.StblAtom", "sample id range, start:%s, end:%s, sampleList.size:%s, stssStart:%s, stssEnd:%s, stssStartSampleId:%s, stssEndSampleId:%s, lastCalcSampleTimeOffset:%s, stssSampleId.length:%s, search cost:%sms", new Object[] { Integer.valueOf(i5), Integer.valueOf(i), Integer.valueOf(this.pEh.size()), Integer.valueOf(paramInt1), Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(paramInt2), Integer.valueOf(this.pEX), Integer.valueOf(this.pEI.length), Long.valueOf(Util.ticksToNow(l2)) });
            if ((i > i5) && (i < this.pEh.size()) && (this.pEP != null) && (i < this.pEP.length))
            {
              l2 = Util.currentTicks();
              paramInt2 = i5;
              while (paramInt2 <= i)
              {
                paramRandomAccessFile = (n)this.pEh.get(paramInt2);
                k = paramInt2 + 1;
                paramRandomAccessFile.size = this.cSd[k];
                paramRandomAccessFile.nAv = (((float)this.pEP[paramInt2] * 1.0F / (float)this.pEc * 1000.0F * 1000.0F));
                paramRandomAccessFile.id = k;
                paramInt2 += 1;
              }
              Log.i("MicroMsg.StblAtom", "increment parse sampleList cost:%sms, start:%s, lastCalcSampleTimeOffset:%s, end:%s", new Object[] { Long.valueOf(Util.ticksToNow(l2)), Integer.valueOf(i5), Integer.valueOf(this.pEX), Integer.valueOf(i) });
              this.pEX = i;
              l2 = Util.currentTicks();
              if (this.pEI == null) {
                while (i5 <= i)
                {
                  if (this.pEn[i5] == null)
                  {
                    paramRandomAccessFile = (n)this.pEh.get(i5);
                    paramRandomAccessFile.pEz = 1;
                    paramRandomAccessFile = new Pair(Integer.valueOf(i5), Long.valueOf(paramRandomAccessFile.nAv));
                    Log.v("MicroMsg.StblAtom", "stss key frame from sampleList [%s %s], current stssList.size:%d", new Object[] { paramRandomAccessFile.first, paramRandomAccessFile.second, Integer.valueOf(this.pEi.size()) });
                    this.pEn[i5] = paramRandomAccessFile;
                  }
                  i5 += 1;
                }
              }
              Log.i("MicroMsg.StblAtom", "increment parse stssList from sampleId, stssStart:%s, stssEnd:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(j) });
              if (j >= paramInt1) {
                while (paramInt1 <= j)
                {
                  if (this.pEn[paramInt1] == null)
                  {
                    paramRandomAccessFile = (n)this.pEh.get(this.pEI[paramInt1] - 1);
                    paramRandomAccessFile.pEz = 1;
                    paramRandomAccessFile = new Pair(Integer.valueOf(this.pEI[paramInt1] - 1), Long.valueOf(paramRandomAccessFile.nAv));
                    Log.v("MicroMsg.StblAtom", "stss key frame from sampleId [%s %s], current stssList.size:%d", new Object[] { paramRandomAccessFile.first, paramRandomAccessFile.second, Integer.valueOf(this.pEi.size()) });
                    this.pEn[paramInt1] = paramRandomAccessFile;
                  }
                  paramInt1 += 1;
                }
              }
              Log.i("MicroMsg.StblAtom", "increment parse stssList cost:%sms, size:%s", new Object[] { Long.valueOf(Util.ticksToNow(l2)), Integer.valueOf(this.pEi.size()) });
            }
            Log.i("MicroMsg.StblAtom", "incrementCreateTimeTable cost:%sms", new Object[] { Long.valueOf(Util.ticksToNow(l1)) });
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
      Log.w("MicroMsg.StblAtom", "stco read entry count error");
      AppMethodBeat.o(133887);
      return -1L;
    }
    int i = c.readInt(arrayOfByte, 0);
    long l3 = 4L * i;
    if ((l3 <= 0L) || (l3 > paramInt - 16))
    {
      Log.w("MicroMsg.StblAtom", "stco error entryCount : ".concat(String.valueOf(i)));
      AppMethodBeat.o(133887);
      return -1L;
    }
    this.pEH = new int[i + 1];
    paramInt = 1;
    long l1 = 0L;
    i = paramRandomAccessFile.read(arrayOfByte);
    for (;;)
    {
      long l2 = l1;
      if (i >= 4)
      {
        l1 += i;
        this.pEH[paramInt] = c.readInt(arrayOfByte, 0);
        if (l1 >= l3)
        {
          Log.d("MicroMsg.StblAtom", "read stco atom end");
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
      Log.w("MicroMsg.StblAtom", "co64 read entry count error");
      AppMethodBeat.o(133888);
      return -1L;
    }
    int i = c.readInt(arrayOfByte, 0);
    long l3 = i * 8L;
    if ((l3 <= 0L) || (l3 > paramInt - 16))
    {
      Log.w("MicroMsg.StblAtom", "stco error entryCount : ".concat(String.valueOf(i)));
      AppMethodBeat.o(133888);
      return -1L;
    }
    this.pEQ = new long[i + 1];
    paramInt = 1;
    i = paramRandomAccessFile.read(arrayOfByte);
    long l1 = 0L;
    for (;;)
    {
      long l2 = l1;
      if (i >= 8)
      {
        l1 += i;
        this.pEQ[paramInt] = c.aP(arrayOfByte);
        if (l1 >= l3)
        {
          Log.d("MicroMsg.StblAtom", "read stco atom end");
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
      Log.w("MicroMsg.StblAtom", "stss rread entry count error");
      AppMethodBeat.o(133890);
      return -1L;
    }
    int i = c.readInt(arrayOfByte, 0);
    long l3 = 4L * i;
    if ((l3 <= 0L) || (l3 > paramInt - 16))
    {
      Log.w("MicroMsg.StblAtom", "stss error entryCount : ".concat(String.valueOf(i)));
      AppMethodBeat.o(133890);
      return -1L;
    }
    this.pEI = new int[i];
    paramInt = 0;
    i = paramRandomAccessFile.read(arrayOfByte);
    long l1 = 0L;
    for (;;)
    {
      long l2 = l1;
      if (i >= 4)
      {
        l1 += i;
        this.pEI[paramInt] = c.readInt(arrayOfByte, 0);
        if (l1 >= l3)
        {
          Log.d("MicroMsg.StblAtom", "read stss atom end");
          l2 = l1;
        }
      }
      else
      {
        Log.i("MicroMsg.StblAtom", "handleStssAtom, stssSampleId.size:%s", new Object[] { Integer.valueOf(this.pEI.length) });
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
    long l3 = Util.currentTicks();
    long l1 = getSize();
    byte[] arrayOfByte = new byte[8];
    int j = 0;
    int m = 0;
    int k = 0;
    int n = 0;
    int i1 = 0;
    long l4 = Util.currentTicks();
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
        Log.i("MicroMsg.StblAtom", "readAtom, type:%s, size:%s", new Object[] { Integer.valueOf(i7), Integer.valueOf(i6) });
        l1 = 0L;
        if (i7 == a.cPt)
        {
          this.pEA = paramRandomAccessFile.getFilePointer();
          l1 = a(paramRandomAccessFile, i6);
          Log.i("MicroMsg.StblAtom", "handleSttsAtom cost:%sms", new Object[] { Long.valueOf(Util.ticksToNow(l3)) });
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
          if (i7 == a.cPw)
          {
            this.pEB = paramRandomAccessFile.getFilePointer();
            l1 = b(paramRandomAccessFile, i6);
            Log.i("MicroMsg.StblAtom", "handleStscAtom cost:%sms", new Object[] { Long.valueOf(Util.ticksToNow(l3)) });
            i3 = 1;
            i2 = n;
            i = m;
            i4 = j;
          }
          else if (i7 == a.cPz)
          {
            this.pEC = paramRandomAccessFile.getFilePointer();
            l1 = c(paramRandomAccessFile, i6);
            Log.i("MicroMsg.StblAtom", "handleStcoAtom cost:%sms", new Object[] { Long.valueOf(Util.ticksToNow(l3)) });
            i = 1;
            i2 = n;
            i3 = k;
            i4 = j;
          }
          else if (i7 == a.cPA)
          {
            this.pED = paramRandomAccessFile.getFilePointer();
            l1 = d(paramRandomAccessFile, i6);
            Log.i("MicroMsg.StblAtom", "handleCo64Atom cost:%sms", new Object[] { Long.valueOf(Util.ticksToNow(l3)) });
            i = 1;
            i2 = n;
            i3 = k;
            i4 = j;
          }
          else if (i7 == a.cPx)
          {
            this.pEE = paramRandomAccessFile.getFilePointer();
            Log.i("MicroMsg.StblAtom", "stsz atom pos:%s", new Object[] { Long.valueOf(this.pEE) });
            l1 = e(paramRandomAccessFile, i6);
            Log.i("MicroMsg.StblAtom", "handleStszAtom cost:%sms", new Object[] { Long.valueOf(Util.ticksToNow(l3)) });
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
            if (i7 == a.cPu)
            {
              this.pEF = paramRandomAccessFile.getFilePointer();
              l1 = f(paramRandomAccessFile, i6);
              Log.i("MicroMsg.StblAtom", "handleStssAtom cost:%sms", new Object[] { Long.valueOf(Util.ticksToNow(l3)) });
              i1 = 1;
              i2 = n;
              i3 = k;
              i = m;
              i4 = j;
            }
          }
        }
        if ((i4 != 0) && (i != 0) && (i3 != 0) && (i2 != 0) && (i1 != 0)) {
          Log.i("MicroMsg.StblAtom", "read stbl atom finish");
        }
      }
      else
      {
        Log.i("MicroMsg.StblAtom", "parse all atoms cost %sms", new Object[] { Long.valueOf(Util.ticksToNow(l4)) });
        l1 = Util.currentTicks();
        bTX();
        Log.i("MicroMsg.StblAtom", "createTimeTable cost:%sms", new Object[] { Long.valueOf(Util.ticksToNow(l1)) });
        Log.i("MicroMsg.StblAtom", "parse stbl atom cost:%sms", new Object[] { Long.valueOf(Util.ticksToNow(l3)) });
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.mm.plugin.a.o
 * JD-Core Version:    0.7.0.1
 */