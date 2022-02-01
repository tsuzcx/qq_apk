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
  int[] boF;
  long duration;
  Pair<Integer, Long>[] jQD;
  long jQQ;
  long jQR;
  long jQS;
  long jQT;
  long jQU;
  long jQV;
  int jQW;
  private int[] jQX;
  int[] jQY;
  private int[] jQZ;
  long jQs;
  long[] jQv;
  List<n> jQx;
  List<Pair> jQy;
  private int[] jRa;
  long jRb;
  long jRc;
  long jRd;
  boolean jRe;
  private long[] jRf;
  private long[] jRg;
  byte[] jRh;
  private byte[] jRi;
  private long jRj;
  private long jRk;
  private long jRl;
  private long jRm;
  private int jRn;
  private HashMap<Integer, Long> jRo;
  private int[] jRp;
  
  public o(int paramInt1, long paramLong, int paramInt2)
  {
    super(paramInt1, paramLong, paramInt2, 0L);
    AppMethodBeat.i(133883);
    this.jQx = new ArrayList();
    this.jQy = new ArrayList();
    this.jRb = 0L;
    this.jRc = 0L;
    this.jRd = 0L;
    this.jRe = false;
    this.jRf = null;
    this.jRh = null;
    this.jRi = new byte[4];
    this.jRj = 0L;
    this.jRk = 0L;
    this.jRl = 0L;
    this.jRm = 0L;
    this.jRn = 0;
    this.jRo = new HashMap();
    AppMethodBeat.o(133883);
  }
  
  private boolean blV()
  {
    AppMethodBeat.i(133891);
    long l1 = Util.currentTicks();
    blW();
    Log.i("MicroMsg.StblAtom", "createChunkTable cost:%sms", new Object[] { Long.valueOf(Util.ticksToNow(l1)) });
    int i = 0;
    int k;
    while (i < this.jQv.length)
    {
      j = (int)this.jQv[i];
      k = uX(j);
      int m = this.jRp[(k - 1)] + 1;
      Log.d("MicroMsg.StblAtom", "sampleId : " + j + " chunkId : " + k + ", sampleBeginId: " + m);
      l1 = dH(m, j);
      l2 = uY(k);
      this.jQv[i] = (l2 + l1);
      i += 1;
    }
    this.jRm = this.jQv[(this.jQv.length - 1)];
    long l3 = Util.currentTicks();
    i = 1;
    int j = 0;
    l1 = 0L;
    Object localObject = this.jQx.iterator();
    long l2 = 0L;
    if (((Iterator)localObject).hasNext())
    {
      n localn = (n)((Iterator)localObject).next();
      localn.size = this.boF[i];
      k = uX(i);
      if (k != j) {}
      for (localn.start = uY(k);; localn.start = l2)
      {
        l2 = localn.start + localn.size;
        l1 += localn.igk;
        localn.igk = (((float)l1 * 1.0F / (float)this.jQs * 1000.0F * 1000.0F));
        localn.id = i;
        j = k;
        i += 1;
        break;
      }
    }
    Log.i("MicroMsg.StblAtom", "parse sampleList cost:%sms, size:%s", new Object[] { Long.valueOf(Util.ticksToNow(l3)), Integer.valueOf(this.jQx.size()) });
    l1 = Util.currentTicks();
    if (this.jQY == null)
    {
      i = 0;
      while (i < this.jQx.size())
      {
        localObject = (n)this.jQx.get(i);
        ((n)localObject).jQP = 1;
        localObject = new Pair(Integer.valueOf(i), Long.valueOf(((n)localObject).igk));
        Log.v("MicroMsg.StblAtom", "stss key frame from sampleList [%s %s], current stssList.size:%d", new Object[] { ((Pair)localObject).first, ((Pair)localObject).second, Integer.valueOf(this.jQy.size()) });
        this.jQy.add(localObject);
        i += 1;
      }
    }
    i = 0;
    while (i < this.jQY.length)
    {
      localObject = (n)this.jQx.get(this.jQY[i] - 1);
      ((n)localObject).jQP = 1;
      localObject = new Pair(Integer.valueOf(this.jQY[i] - 1), Long.valueOf(((n)localObject).igk));
      Log.v("MicroMsg.StblAtom", "stss key frame from sampleId [%s %s], current stssList.size:%d", new Object[] { ((Pair)localObject).first, ((Pair)localObject).second, Integer.valueOf(this.jQy.size()) });
      this.jQy.add(localObject);
      i += 1;
    }
    Log.i("MicroMsg.StblAtom", "parse stssList cost:%sms, size:%s", new Object[] { Long.valueOf(Util.ticksToNow(l1)), Integer.valueOf(this.jQy.size()) });
    AppMethodBeat.o(133891);
    return true;
  }
  
  private void blW()
  {
    AppMethodBeat.i(175948);
    if (this.jQX != null) {}
    int m;
    for (int i = this.jQX.length;; i = this.jRg.length)
    {
      j = i - 1;
      m = this.jQZ.length;
      i = 1;
      while (i < m)
      {
        this.jQZ[(i - 1)] = (this.jQZ[i] - this.jQZ[(i - 1)]);
        i += 1;
      }
    }
    this.jQZ[(m - 1)] = (j - this.jQZ[(m - 1)] + 1);
    this.jRp = new int[j + 1];
    this.jRp[0] = 0;
    int j = 1;
    i = 0;
    while (i < m)
    {
      int n = this.jQZ[i];
      int i1 = this.jRa[i];
      int k = 0;
      while (k < n)
      {
        int[] arrayOfInt = this.jRp;
        arrayOfInt[j] = (arrayOfInt[(j - 1)] + i1);
        j += 1;
        k += 1;
      }
      i += 1;
    }
    Log.i("MicroMsg.StblAtom", "create chunkTable size:%s", new Object[] { Integer.valueOf(this.jRp.length) });
    AppMethodBeat.o(175948);
  }
  
  private long dH(int paramInt1, int paramInt2)
  {
    long l2;
    if (this.boF.length == 1)
    {
      l2 = this.boF[0] * (paramInt2 - paramInt1);
      return l2;
    }
    long l1 = 0L;
    for (;;)
    {
      l2 = l1;
      if (paramInt1 > paramInt2) {
        break;
      }
      l1 += this.boF[paramInt1];
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
      Log.w("MicroMsg.StblAtom", "stsz read sample size error");
      AppMethodBeat.o(133889);
      return -1L;
    }
    int j = c.readInt(arrayOfByte, 0);
    if (j > 0)
    {
      this.boF = new int[1];
      this.boF[0] = j;
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
    this.boF = new int[j + 1];
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
        this.boF[paramInt] = c.readInt(arrayOfByte, 0);
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
  
  private Pair<Integer, Integer> uW(int paramInt)
  {
    int i = 0;
    AppMethodBeat.i(175946);
    if (this.jRp == null)
    {
      long l = Util.currentTicks();
      blW();
      Log.i("MicroMsg.StblAtom", "createChunkTable cost:%sms", new Object[] { Long.valueOf(Util.ticksToNow(l)) });
    }
    if (paramInt < this.jQv.length)
    {
      int j = (int)this.jQv[paramInt];
      if (j < 0)
      {
        Log.e("MicroMsg.StblAtom", "calcSampleBeginEndId %s not found in timeTable", new Object[] { Integer.valueOf(paramInt) });
        AppMethodBeat.o(175946);
        return null;
      }
      int k = uX(j);
      paramInt = i;
      if (k > 0) {
        paramInt = k - 1;
      }
      Pair localPair = new Pair(Integer.valueOf(this.jRp[paramInt] + 1), Integer.valueOf(j));
      AppMethodBeat.o(175946);
      return localPair;
    }
    AppMethodBeat.o(175946);
    return null;
  }
  
  private int uX(int paramInt)
  {
    int i = 0;
    while (i < this.jRp.length)
    {
      if (paramInt <= this.jRp[i]) {
        return i;
      }
      i += 1;
    }
    return 0;
  }
  
  private long uY(int paramInt)
  {
    if (this.jQX != null) {
      return this.jQX[paramInt];
    }
    if (this.jRg != null) {
      return this.jRg[paramInt];
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
    this.jQv = new long[(int)(this.duration / this.jQs) + 2];
    Arrays.fill(this.jQv, -1L);
    Object localObject = this.jQv;
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
        this.jRf = new long[n];
        Arrays.fill(this.jRf, 0L);
        j = 0;
        while (j < n)
        {
          localObject = new n();
          ((n)localObject).igk = i1;
          if (j == 0) {}
          for (m = 0;; m = j - 1)
          {
            long[] arrayOfLong = this.jRf;
            arrayOfLong[m] += ((n)localObject).igk;
            this.jQx.add(localObject);
            k += i1;
            m = i + 1;
            i = k;
            while ((i >= this.jQs) && (paramInt < this.jQv.length))
            {
              i = (int)(i - this.jQs);
              this.jQv[paramInt] = m;
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
        if (m < this.jQv.length) {
          this.jQv[m] = n;
        }
        AppMethodBeat.o(133885);
        return 8L + l2;
      }
    }
  }
  
  final long a(RandomAccessFile paramRandomAccessFile, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(175945);
    Pair localPair1 = uW(paramInt1);
    Pair localPair2 = uW(paramInt2);
    if ((localPair1 != null) && (localPair2 != null))
    {
      if (this.jRb == 0L) {}
      int i;
      for (Integer localInteger = (Integer)localPair1.first;; localInteger = (Integer)localPair1.second)
      {
        paramInt2 = localInteger.intValue();
        i = ((Integer)localPair2.second).intValue();
        Log.i("MicroMsg.StblAtom", "incrementParseStsz, startSampleId:%s, endSampleId:%s, sampleSizeTable.size:%s, startRange:%s, endRange:%s, stszLazyStartPos:%s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(i), Integer.valueOf(this.boF.length), localPair1, localPair2, Long.valueOf(this.jRc) });
        if (paramInt2 <= i) {
          break;
        }
        AppMethodBeat.o(175945);
        return -1L;
      }
      if ((paramInt2 > this.boF.length) || (i > this.boF.length))
      {
        AppMethodBeat.o(175945);
        return -1L;
      }
      if (this.jRc < 0L)
      {
        AppMethodBeat.o(175945);
        return -1L;
      }
      if (this.jRh == null)
      {
        AppMethodBeat.o(175945);
        return -1L;
      }
      paramInt1 = (paramInt2 - 1) * 4;
      for (;;)
      {
        if ((paramInt1 < this.jRh.length) && (paramInt2 <= i))
        {
          int j = c.readInt(this.jRh, paramInt1);
          this.boF[paramInt2] = j;
          paramInt2 += 1;
          if (0L >= this.jRd) {
            Log.d("MicroMsg.StblAtom", "read stsz atom end");
          }
        }
        else
        {
          Log.i("MicroMsg.StblAtom", "incrementParseStsz finish, filePos:%s, offset:%s, sampleSizeTableData.length:%s", new Object[] { Long.valueOf(paramRandomAccessFile.getFilePointer()), Integer.valueOf(paramInt1), Integer.valueOf(this.jRh.length) });
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
    this.jQZ = new int[i];
    this.jRa = new int[i];
    long l1 = 0L;
    paramInt = paramRandomAccessFile.read(arrayOfByte);
    i = 0;
    for (;;)
    {
      long l2 = l1;
      if (paramInt >= 12)
      {
        l1 += paramInt;
        this.jQZ[i] = c.readInt(arrayOfByte, 0);
        this.jRa[i] = c.readInt(arrayOfByte, 4);
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
    Log.i("MicroMsg.StblAtom", "incrementCreateTimeTable, startSecond:%s, endSecond:%s, timeTable.length:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(this.jQv.length) });
    long l1 = Util.currentTicks();
    if (this.jRp == null)
    {
      blW();
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
    int i = Math.min(paramInt1, this.jQv.length - 1);
    int j = Math.min(paramInt2, this.jQv.length - 1);
    paramRandomAccessFile = uW(paramInt1);
    Pair localPair = uW(paramInt2);
    Log.i("MicroMsg.StblAtom", "incrementCreateTimeTable, start:%s, end:%s, startSampleIdRange:%s, endSampleIdRange:%s, calcSampleRangeCost:%sms, chunkTable.size:%s", new Object[] { Integer.valueOf(i), Integer.valueOf(j), paramRandomAccessFile, localPair, Long.valueOf(Util.ticksToNow(l2)), Integer.valueOf(this.jRp.length) });
    l2 = Util.currentTicks();
    paramInt1 = i;
    int k;
    if (paramInt1 <= j)
    {
      i = (int)this.jQv[paramInt1];
      l3 = Util.currentTicks();
      k = uX(i);
      l3 = Util.ticksToNow(l3);
      if (k > 0) {}
      for (paramInt2 = k - 1;; paramInt2 = 0)
      {
        paramInt2 = this.jRp[paramInt2] + 1;
        long l5 = Util.currentTicks();
        long l4 = dH(paramInt2, i);
        l5 = Util.ticksToNow(l5);
        long l6 = uY(k);
        this.jQv[paramInt1] = (l6 + l4);
        Log.d("MicroMsg.StblAtom", "sampleId:%s, sampleBeginId:%s, chunkId:%s, sampleSize:%s, chunkOffset:%s, calcChunkId cost:%sms, calcSampleSizeCost:%sms", new Object[] { Integer.valueOf(i), Integer.valueOf(paramInt2), Integer.valueOf(k), Long.valueOf(l4), Long.valueOf(l6), Long.valueOf(l3), Long.valueOf(l5) });
        paramInt1 += 1;
        break;
      }
    }
    Log.d("MicroMsg.StblAtom", "updateTimeTable cost:%sms", new Object[] { Long.valueOf(Util.ticksToNow(l2)) });
    this.jRm = this.jQv[(j - 1)];
    int i5;
    int i6;
    int i4;
    int i3;
    if ((paramRandomAccessFile != null) && (localPair != null))
    {
      if (this.jRb == 0L) {}
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
          if (paramInt1 >= this.jQY.length) {
            break;
          }
          int n = i2;
          k = i1;
          if (i1 < 0)
          {
            n = i2;
            k = i1;
            if (this.jQY[paramInt1] - 1 >= i5 - 1)
            {
              n = this.jQY[paramInt1] - 1;
              k = paramInt1;
            }
          }
          i2 = m;
          i1 = j;
          if (j < 0)
          {
            i2 = m;
            i1 = j;
            if (this.jQY[paramInt1] - 1 >= i6 - 1)
            {
              i2 = this.jQY[paramInt1] - 1;
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
      Log.i("MicroMsg.StblAtom", "not found stssStart, set to last %s", new Object[] { Integer.valueOf(this.jQY.length - 1) });
      paramInt1 = this.jQY.length - 1;
      k = this.jQY[paramInt1] - 1;
    }
    for (;;)
    {
      if (i < 0)
      {
        Log.i("MicroMsg.StblAtom", "not found stssEnd, set to last %s", new Object[] { Integer.valueOf(this.jQY.length - 1) });
        j = this.jQY.length - 1;
        paramInt2 = this.jQY[j] - 1;
      }
      for (;;)
      {
        if (paramInt2 > i6) {}
        for (i = paramInt2;; i = i6)
        {
          if (i >= this.jQx.size()) {
            i = this.jQx.size() - 1;
          }
          for (;;)
          {
            Log.i("MicroMsg.StblAtom", "sample id range, start:%s, end:%s, sampleList.size:%s, stssStart:%s, stssEnd:%s, stssStartSampleId:%s, stssEndSampleId:%s, lastCalcSampleTimeOffset:%s, stssSampleId.length:%s, search cost:%sms", new Object[] { Integer.valueOf(i5), Integer.valueOf(i), Integer.valueOf(this.jQx.size()), Integer.valueOf(paramInt1), Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(paramInt2), Integer.valueOf(this.jRn), Integer.valueOf(this.jQY.length), Long.valueOf(Util.ticksToNow(l2)) });
            if ((i > i5) && (i < this.jQx.size()) && (this.jRf != null) && (i < this.jRf.length))
            {
              l2 = Util.currentTicks();
              paramInt2 = i5;
              while (paramInt2 <= i)
              {
                paramRandomAccessFile = (n)this.jQx.get(paramInt2);
                k = paramInt2 + 1;
                paramRandomAccessFile.size = this.boF[k];
                paramRandomAccessFile.igk = (((float)this.jRf[paramInt2] * 1.0F / (float)this.jQs * 1000.0F * 1000.0F));
                paramRandomAccessFile.id = k;
                paramInt2 += 1;
              }
              Log.i("MicroMsg.StblAtom", "increment parse sampleList cost:%sms, start:%s, lastCalcSampleTimeOffset:%s, end:%s", new Object[] { Long.valueOf(Util.ticksToNow(l2)), Integer.valueOf(i5), Integer.valueOf(this.jRn), Integer.valueOf(i) });
              this.jRn = i;
              l2 = Util.currentTicks();
              if (this.jQY == null) {
                while (i5 <= i)
                {
                  if (this.jQD[i5] == null)
                  {
                    paramRandomAccessFile = (n)this.jQx.get(i5);
                    paramRandomAccessFile.jQP = 1;
                    paramRandomAccessFile = new Pair(Integer.valueOf(i5), Long.valueOf(paramRandomAccessFile.igk));
                    Log.v("MicroMsg.StblAtom", "stss key frame from sampleList [%s %s], current stssList.size:%d", new Object[] { paramRandomAccessFile.first, paramRandomAccessFile.second, Integer.valueOf(this.jQy.size()) });
                    this.jQD[i5] = paramRandomAccessFile;
                  }
                  i5 += 1;
                }
              }
              Log.i("MicroMsg.StblAtom", "increment parse stssList from sampleId, stssStart:%s, stssEnd:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(j) });
              if (j >= paramInt1) {
                while (paramInt1 <= j)
                {
                  if (this.jQD[paramInt1] == null)
                  {
                    paramRandomAccessFile = (n)this.jQx.get(this.jQY[paramInt1] - 1);
                    paramRandomAccessFile.jQP = 1;
                    paramRandomAccessFile = new Pair(Integer.valueOf(this.jQY[paramInt1] - 1), Long.valueOf(paramRandomAccessFile.igk));
                    Log.v("MicroMsg.StblAtom", "stss key frame from sampleId [%s %s], current stssList.size:%d", new Object[] { paramRandomAccessFile.first, paramRandomAccessFile.second, Integer.valueOf(this.jQy.size()) });
                    this.jQD[paramInt1] = paramRandomAccessFile;
                  }
                  paramInt1 += 1;
                }
              }
              Log.i("MicroMsg.StblAtom", "increment parse stssList cost:%sms, size:%s", new Object[] { Long.valueOf(Util.ticksToNow(l2)), Integer.valueOf(this.jQy.size()) });
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
    this.jQX = new int[i + 1];
    paramInt = 1;
    long l1 = 0L;
    i = paramRandomAccessFile.read(arrayOfByte);
    for (;;)
    {
      long l2 = l1;
      if (i >= 4)
      {
        l1 += i;
        this.jQX[paramInt] = c.readInt(arrayOfByte, 0);
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
    this.jRg = new long[i + 1];
    paramInt = 1;
    i = paramRandomAccessFile.read(arrayOfByte);
    long l1 = 0L;
    for (;;)
    {
      long l2 = l1;
      if (i >= 8)
      {
        l1 += i;
        this.jRg[paramInt] = c.aE(arrayOfByte);
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
    this.jQY = new int[i];
    paramInt = 0;
    i = paramRandomAccessFile.read(arrayOfByte);
    long l1 = 0L;
    for (;;)
    {
      long l2 = l1;
      if (i >= 4)
      {
        l1 += i;
        this.jQY[paramInt] = c.readInt(arrayOfByte, 0);
        if (l1 >= l3)
        {
          Log.d("MicroMsg.StblAtom", "read stss atom end");
          l2 = l1;
        }
      }
      else
      {
        Log.i("MicroMsg.StblAtom", "handleStssAtom, stssSampleId.size:%s", new Object[] { Integer.valueOf(this.jQY.length) });
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
        if (i7 == a.blV)
        {
          this.jQQ = paramRandomAccessFile.getFilePointer();
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
          if (i7 == a.blY)
          {
            this.jQR = paramRandomAccessFile.getFilePointer();
            l1 = b(paramRandomAccessFile, i6);
            Log.i("MicroMsg.StblAtom", "handleStscAtom cost:%sms", new Object[] { Long.valueOf(Util.ticksToNow(l3)) });
            i3 = 1;
            i2 = n;
            i = m;
            i4 = j;
          }
          else if (i7 == a.bmb)
          {
            this.jQS = paramRandomAccessFile.getFilePointer();
            l1 = c(paramRandomAccessFile, i6);
            Log.i("MicroMsg.StblAtom", "handleStcoAtom cost:%sms", new Object[] { Long.valueOf(Util.ticksToNow(l3)) });
            i = 1;
            i2 = n;
            i3 = k;
            i4 = j;
          }
          else if (i7 == a.bmc)
          {
            this.jQT = paramRandomAccessFile.getFilePointer();
            l1 = d(paramRandomAccessFile, i6);
            Log.i("MicroMsg.StblAtom", "handleCo64Atom cost:%sms", new Object[] { Long.valueOf(Util.ticksToNow(l3)) });
            i = 1;
            i2 = n;
            i3 = k;
            i4 = j;
          }
          else if (i7 == a.blZ)
          {
            this.jQU = paramRandomAccessFile.getFilePointer();
            Log.i("MicroMsg.StblAtom", "stsz atom pos:%s", new Object[] { Long.valueOf(this.jQU) });
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
            if (i7 == a.blW)
            {
              this.jQV = paramRandomAccessFile.getFilePointer();
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
        blV();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.a.o
 * JD-Core Version:    0.7.0.1
 */