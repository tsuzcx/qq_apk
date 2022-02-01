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
  int[] aYh;
  long duration;
  long mHC;
  long[] mHF;
  List<n> mHH;
  List<Pair> mHI;
  Pair<Integer, Long>[] mHN;
  private int[] mIA;
  long mIa;
  long mIb;
  long mIc;
  long mIe;
  long mIf;
  long mIg;
  int mIh;
  private int[] mIi;
  int[] mIj;
  private int[] mIk;
  private int[] mIl;
  long mIm;
  long mIn;
  long mIo;
  boolean mIp;
  private long[] mIq;
  private long[] mIr;
  byte[] mIs;
  private byte[] mIt;
  private long mIu;
  private long mIv;
  private long mIw;
  private long mIx;
  private int mIy;
  private HashMap<Integer, Long> mIz;
  
  public o(int paramInt1, long paramLong, int paramInt2)
  {
    super(paramInt1, paramLong, paramInt2, 0L);
    AppMethodBeat.i(133883);
    this.mHH = new ArrayList();
    this.mHI = new ArrayList();
    this.mIm = 0L;
    this.mIn = 0L;
    this.mIo = 0L;
    this.mIp = false;
    this.mIq = null;
    this.mIs = null;
    this.mIt = new byte[4];
    this.mIu = 0L;
    this.mIv = 0L;
    this.mIw = 0L;
    this.mIx = 0L;
    this.mIy = 0;
    this.mIz = new HashMap();
    AppMethodBeat.o(133883);
  }
  
  private boolean bvL()
  {
    AppMethodBeat.i(133891);
    long l1 = Util.currentTicks();
    bvM();
    Log.i("MicroMsg.StblAtom", "createChunkTable cost:%sms", new Object[] { Long.valueOf(Util.ticksToNow(l1)) });
    int i = 0;
    int k;
    while (i < this.mHF.length)
    {
      j = (int)this.mHF[i];
      k = yb(j);
      int m = this.mIA[(k - 1)] + 1;
      Log.d("MicroMsg.StblAtom", "sampleId : " + j + " chunkId : " + k + ", sampleBeginId: " + m);
      l1 = ef(m, j);
      l2 = yc(k);
      this.mHF[i] = (l2 + l1);
      i += 1;
    }
    this.mIx = this.mHF[(this.mHF.length - 1)];
    long l3 = Util.currentTicks();
    i = 1;
    int j = 0;
    l1 = 0L;
    Object localObject = this.mHH.iterator();
    long l2 = 0L;
    if (((Iterator)localObject).hasNext())
    {
      n localn = (n)((Iterator)localObject).next();
      localn.size = this.aYh[i];
      k = yb(i);
      if (k != j) {}
      for (localn.start = yc(k);; localn.start = l2)
      {
        l2 = localn.start + localn.size;
        l1 += localn.kUY;
        localn.kUY = (((float)l1 * 1.0F / (float)this.mHC * 1000.0F * 1000.0F));
        localn.id = i;
        j = k;
        i += 1;
        break;
      }
    }
    Log.i("MicroMsg.StblAtom", "parse sampleList cost:%sms, size:%s", new Object[] { Long.valueOf(Util.ticksToNow(l3)), Integer.valueOf(this.mHH.size()) });
    l1 = Util.currentTicks();
    if (this.mIj == null)
    {
      i = 0;
      while (i < this.mHH.size())
      {
        localObject = (n)this.mHH.get(i);
        ((n)localObject).mHZ = 1;
        localObject = new Pair(Integer.valueOf(i), Long.valueOf(((n)localObject).kUY));
        Log.v("MicroMsg.StblAtom", "stss key frame from sampleList [%s %s], current stssList.size:%d", new Object[] { ((Pair)localObject).first, ((Pair)localObject).second, Integer.valueOf(this.mHI.size()) });
        this.mHI.add(localObject);
        i += 1;
      }
    }
    i = 0;
    while (i < this.mIj.length)
    {
      localObject = (n)this.mHH.get(this.mIj[i] - 1);
      ((n)localObject).mHZ = 1;
      localObject = new Pair(Integer.valueOf(this.mIj[i] - 1), Long.valueOf(((n)localObject).kUY));
      Log.v("MicroMsg.StblAtom", "stss key frame from sampleId [%s %s], current stssList.size:%d", new Object[] { ((Pair)localObject).first, ((Pair)localObject).second, Integer.valueOf(this.mHI.size()) });
      this.mHI.add(localObject);
      i += 1;
    }
    Log.i("MicroMsg.StblAtom", "parse stssList cost:%sms, size:%s", new Object[] { Long.valueOf(Util.ticksToNow(l1)), Integer.valueOf(this.mHI.size()) });
    AppMethodBeat.o(133891);
    return true;
  }
  
  private void bvM()
  {
    AppMethodBeat.i(175948);
    if (this.mIi != null) {}
    int m;
    for (int i = this.mIi.length;; i = this.mIr.length)
    {
      j = i - 1;
      m = this.mIk.length;
      i = 1;
      while (i < m)
      {
        this.mIk[(i - 1)] = (this.mIk[i] - this.mIk[(i - 1)]);
        i += 1;
      }
    }
    this.mIk[(m - 1)] = (j - this.mIk[(m - 1)] + 1);
    this.mIA = new int[j + 1];
    this.mIA[0] = 0;
    int j = 1;
    i = 0;
    while (i < m)
    {
      int n = this.mIk[i];
      int i1 = this.mIl[i];
      int k = 0;
      while (k < n)
      {
        int[] arrayOfInt = this.mIA;
        arrayOfInt[j] = (arrayOfInt[(j - 1)] + i1);
        j += 1;
        k += 1;
      }
      i += 1;
    }
    Log.i("MicroMsg.StblAtom", "create chunkTable size:%s", new Object[] { Integer.valueOf(this.mIA.length) });
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
      this.aYh = new int[1];
      this.aYh[0] = j;
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
    this.aYh = new int[j + 1];
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
        this.aYh[paramInt] = c.readInt(arrayOfByte, 0);
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
  
  private long ef(int paramInt1, int paramInt2)
  {
    long l2;
    if (this.aYh.length == 1)
    {
      l2 = this.aYh[0] * (paramInt2 - paramInt1);
      return l2;
    }
    long l1 = 0L;
    for (;;)
    {
      l2 = l1;
      if (paramInt1 > paramInt2) {
        break;
      }
      l1 += this.aYh[paramInt1];
      paramInt1 += 1;
    }
  }
  
  private Pair<Integer, Integer> ya(int paramInt)
  {
    int i = 0;
    AppMethodBeat.i(175946);
    if (this.mIA == null)
    {
      long l = Util.currentTicks();
      bvM();
      Log.i("MicroMsg.StblAtom", "createChunkTable cost:%sms", new Object[] { Long.valueOf(Util.ticksToNow(l)) });
    }
    if (paramInt < this.mHF.length)
    {
      int j = (int)this.mHF[paramInt];
      if (j < 0)
      {
        Log.e("MicroMsg.StblAtom", "calcSampleBeginEndId %s not found in timeTable", new Object[] { Integer.valueOf(paramInt) });
        AppMethodBeat.o(175946);
        return null;
      }
      int k = yb(j);
      paramInt = i;
      if (k > 0) {
        paramInt = k - 1;
      }
      Pair localPair = new Pair(Integer.valueOf(this.mIA[paramInt] + 1), Integer.valueOf(j));
      AppMethodBeat.o(175946);
      return localPair;
    }
    AppMethodBeat.o(175946);
    return null;
  }
  
  private int yb(int paramInt)
  {
    int i = 0;
    while (i < this.mIA.length)
    {
      if (paramInt <= this.mIA[i]) {
        return i;
      }
      i += 1;
    }
    return 0;
  }
  
  private long yc(int paramInt)
  {
    if (this.mIi != null) {
      return this.mIi[paramInt];
    }
    if (this.mIr != null) {
      return this.mIr[paramInt];
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
    this.mHF = new long[(int)(this.duration / this.mHC) + 2];
    Arrays.fill(this.mHF, -1L);
    Object localObject = this.mHF;
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
        this.mIq = new long[n];
        Arrays.fill(this.mIq, 0L);
        j = 0;
        while (j < n)
        {
          localObject = new n();
          ((n)localObject).kUY = i1;
          if (j == 0) {}
          for (m = 0;; m = j - 1)
          {
            long[] arrayOfLong = this.mIq;
            arrayOfLong[m] += ((n)localObject).kUY;
            this.mHH.add(localObject);
            k += i1;
            m = i + 1;
            i = k;
            while ((i >= this.mHC) && (paramInt < this.mHF.length))
            {
              i = (int)(i - this.mHC);
              this.mHF[paramInt] = m;
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
        if (m < this.mHF.length) {
          this.mHF[m] = n;
        }
        AppMethodBeat.o(133885);
        return 8L + l2;
      }
    }
  }
  
  final long a(RandomAccessFile paramRandomAccessFile, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(175945);
    Pair localPair1 = ya(paramInt1);
    Pair localPair2 = ya(paramInt2);
    if ((localPair1 != null) && (localPair2 != null))
    {
      if (this.mIm == 0L) {}
      int i;
      for (Integer localInteger = (Integer)localPair1.first;; localInteger = (Integer)localPair1.second)
      {
        paramInt2 = localInteger.intValue();
        i = ((Integer)localPair2.second).intValue();
        Log.i("MicroMsg.StblAtom", "incrementParseStsz, startSampleId:%s, endSampleId:%s, sampleSizeTable.size:%s, startRange:%s, endRange:%s, stszLazyStartPos:%s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(i), Integer.valueOf(this.aYh.length), localPair1, localPair2, Long.valueOf(this.mIn) });
        if (paramInt2 <= i) {
          break;
        }
        AppMethodBeat.o(175945);
        return -1L;
      }
      if ((paramInt2 > this.aYh.length) || (i > this.aYh.length))
      {
        AppMethodBeat.o(175945);
        return -1L;
      }
      if (this.mIn < 0L)
      {
        AppMethodBeat.o(175945);
        return -1L;
      }
      if (this.mIs == null)
      {
        AppMethodBeat.o(175945);
        return -1L;
      }
      paramInt1 = (paramInt2 - 1) * 4;
      for (;;)
      {
        if ((paramInt1 < this.mIs.length) && (paramInt2 <= i))
        {
          int j = c.readInt(this.mIs, paramInt1);
          this.aYh[paramInt2] = j;
          paramInt2 += 1;
          if (0L >= this.mIo) {
            Log.d("MicroMsg.StblAtom", "read stsz atom end");
          }
        }
        else
        {
          Log.i("MicroMsg.StblAtom", "incrementParseStsz finish, filePos:%s, offset:%s, sampleSizeTableData.length:%s", new Object[] { Long.valueOf(paramRandomAccessFile.getFilePointer()), Integer.valueOf(paramInt1), Integer.valueOf(this.mIs.length) });
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
    this.mIk = new int[i];
    this.mIl = new int[i];
    long l1 = 0L;
    paramInt = paramRandomAccessFile.read(arrayOfByte);
    i = 0;
    for (;;)
    {
      long l2 = l1;
      if (paramInt >= 12)
      {
        l1 += paramInt;
        this.mIk[i] = c.readInt(arrayOfByte, 0);
        this.mIl[i] = c.readInt(arrayOfByte, 4);
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
    Log.i("MicroMsg.StblAtom", "incrementCreateTimeTable, startSecond:%s, endSecond:%s, timeTable.length:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(this.mHF.length) });
    long l1 = Util.currentTicks();
    if (this.mIA == null)
    {
      bvM();
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
    int i = Math.min(paramInt1, this.mHF.length - 1);
    int j = Math.min(paramInt2, this.mHF.length - 1);
    paramRandomAccessFile = ya(paramInt1);
    Pair localPair = ya(paramInt2);
    Log.i("MicroMsg.StblAtom", "incrementCreateTimeTable, start:%s, end:%s, startSampleIdRange:%s, endSampleIdRange:%s, calcSampleRangeCost:%sms, chunkTable.size:%s", new Object[] { Integer.valueOf(i), Integer.valueOf(j), paramRandomAccessFile, localPair, Long.valueOf(Util.ticksToNow(l2)), Integer.valueOf(this.mIA.length) });
    l2 = Util.currentTicks();
    paramInt1 = i;
    int k;
    if (paramInt1 <= j)
    {
      i = (int)this.mHF[paramInt1];
      l3 = Util.currentTicks();
      k = yb(i);
      l3 = Util.ticksToNow(l3);
      if (k > 0) {}
      for (paramInt2 = k - 1;; paramInt2 = 0)
      {
        paramInt2 = this.mIA[paramInt2] + 1;
        long l5 = Util.currentTicks();
        long l4 = ef(paramInt2, i);
        l5 = Util.ticksToNow(l5);
        long l6 = yc(k);
        this.mHF[paramInt1] = (l6 + l4);
        Log.d("MicroMsg.StblAtom", "sampleId:%s, sampleBeginId:%s, chunkId:%s, sampleSize:%s, chunkOffset:%s, calcChunkId cost:%sms, calcSampleSizeCost:%sms", new Object[] { Integer.valueOf(i), Integer.valueOf(paramInt2), Integer.valueOf(k), Long.valueOf(l4), Long.valueOf(l6), Long.valueOf(l3), Long.valueOf(l5) });
        paramInt1 += 1;
        break;
      }
    }
    Log.d("MicroMsg.StblAtom", "updateTimeTable cost:%sms", new Object[] { Long.valueOf(Util.ticksToNow(l2)) });
    this.mIx = this.mHF[(j - 1)];
    int i5;
    int i6;
    int i4;
    int i3;
    if ((paramRandomAccessFile != null) && (localPair != null))
    {
      if (this.mIm == 0L) {}
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
          if (paramInt1 >= this.mIj.length) {
            break;
          }
          int n = i2;
          k = i1;
          if (i1 < 0)
          {
            n = i2;
            k = i1;
            if (this.mIj[paramInt1] - 1 >= i5 - 1)
            {
              n = this.mIj[paramInt1] - 1;
              k = paramInt1;
            }
          }
          i2 = m;
          i1 = j;
          if (j < 0)
          {
            i2 = m;
            i1 = j;
            if (this.mIj[paramInt1] - 1 >= i6 - 1)
            {
              i2 = this.mIj[paramInt1] - 1;
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
      Log.i("MicroMsg.StblAtom", "not found stssStart, set to last %s", new Object[] { Integer.valueOf(this.mIj.length - 1) });
      paramInt1 = this.mIj.length - 1;
      k = this.mIj[paramInt1] - 1;
    }
    for (;;)
    {
      if (i < 0)
      {
        Log.i("MicroMsg.StblAtom", "not found stssEnd, set to last %s", new Object[] { Integer.valueOf(this.mIj.length - 1) });
        j = this.mIj.length - 1;
        paramInt2 = this.mIj[j] - 1;
      }
      for (;;)
      {
        if (paramInt2 > i6) {}
        for (i = paramInt2;; i = i6)
        {
          if (i >= this.mHH.size()) {
            i = this.mHH.size() - 1;
          }
          for (;;)
          {
            Log.i("MicroMsg.StblAtom", "sample id range, start:%s, end:%s, sampleList.size:%s, stssStart:%s, stssEnd:%s, stssStartSampleId:%s, stssEndSampleId:%s, lastCalcSampleTimeOffset:%s, stssSampleId.length:%s, search cost:%sms", new Object[] { Integer.valueOf(i5), Integer.valueOf(i), Integer.valueOf(this.mHH.size()), Integer.valueOf(paramInt1), Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(paramInt2), Integer.valueOf(this.mIy), Integer.valueOf(this.mIj.length), Long.valueOf(Util.ticksToNow(l2)) });
            if ((i > i5) && (i < this.mHH.size()) && (this.mIq != null) && (i < this.mIq.length))
            {
              l2 = Util.currentTicks();
              paramInt2 = i5;
              while (paramInt2 <= i)
              {
                paramRandomAccessFile = (n)this.mHH.get(paramInt2);
                k = paramInt2 + 1;
                paramRandomAccessFile.size = this.aYh[k];
                paramRandomAccessFile.kUY = (((float)this.mIq[paramInt2] * 1.0F / (float)this.mHC * 1000.0F * 1000.0F));
                paramRandomAccessFile.id = k;
                paramInt2 += 1;
              }
              Log.i("MicroMsg.StblAtom", "increment parse sampleList cost:%sms, start:%s, lastCalcSampleTimeOffset:%s, end:%s", new Object[] { Long.valueOf(Util.ticksToNow(l2)), Integer.valueOf(i5), Integer.valueOf(this.mIy), Integer.valueOf(i) });
              this.mIy = i;
              l2 = Util.currentTicks();
              if (this.mIj == null) {
                while (i5 <= i)
                {
                  if (this.mHN[i5] == null)
                  {
                    paramRandomAccessFile = (n)this.mHH.get(i5);
                    paramRandomAccessFile.mHZ = 1;
                    paramRandomAccessFile = new Pair(Integer.valueOf(i5), Long.valueOf(paramRandomAccessFile.kUY));
                    Log.v("MicroMsg.StblAtom", "stss key frame from sampleList [%s %s], current stssList.size:%d", new Object[] { paramRandomAccessFile.first, paramRandomAccessFile.second, Integer.valueOf(this.mHI.size()) });
                    this.mHN[i5] = paramRandomAccessFile;
                  }
                  i5 += 1;
                }
              }
              Log.i("MicroMsg.StblAtom", "increment parse stssList from sampleId, stssStart:%s, stssEnd:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(j) });
              if (j >= paramInt1) {
                while (paramInt1 <= j)
                {
                  if (this.mHN[paramInt1] == null)
                  {
                    paramRandomAccessFile = (n)this.mHH.get(this.mIj[paramInt1] - 1);
                    paramRandomAccessFile.mHZ = 1;
                    paramRandomAccessFile = new Pair(Integer.valueOf(this.mIj[paramInt1] - 1), Long.valueOf(paramRandomAccessFile.kUY));
                    Log.v("MicroMsg.StblAtom", "stss key frame from sampleId [%s %s], current stssList.size:%d", new Object[] { paramRandomAccessFile.first, paramRandomAccessFile.second, Integer.valueOf(this.mHI.size()) });
                    this.mHN[paramInt1] = paramRandomAccessFile;
                  }
                  paramInt1 += 1;
                }
              }
              Log.i("MicroMsg.StblAtom", "increment parse stssList cost:%sms, size:%s", new Object[] { Long.valueOf(Util.ticksToNow(l2)), Integer.valueOf(this.mHI.size()) });
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
    this.mIi = new int[i + 1];
    paramInt = 1;
    long l1 = 0L;
    i = paramRandomAccessFile.read(arrayOfByte);
    for (;;)
    {
      long l2 = l1;
      if (i >= 4)
      {
        l1 += i;
        this.mIi[paramInt] = c.readInt(arrayOfByte, 0);
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
    this.mIr = new long[i + 1];
    paramInt = 1;
    i = paramRandomAccessFile.read(arrayOfByte);
    long l1 = 0L;
    for (;;)
    {
      long l2 = l1;
      if (i >= 8)
      {
        l1 += i;
        this.mIr[paramInt] = c.aP(arrayOfByte);
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
    this.mIj = new int[i];
    paramInt = 0;
    i = paramRandomAccessFile.read(arrayOfByte);
    long l1 = 0L;
    for (;;)
    {
      long l2 = l1;
      if (i >= 4)
      {
        l1 += i;
        this.mIj[paramInt] = c.readInt(arrayOfByte, 0);
        if (l1 >= l3)
        {
          Log.d("MicroMsg.StblAtom", "read stss atom end");
          l2 = l1;
        }
      }
      else
      {
        Log.i("MicroMsg.StblAtom", "handleStssAtom, stssSampleId.size:%s", new Object[] { Integer.valueOf(this.mIj.length) });
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
        if (i7 == a.aVx)
        {
          this.mIa = paramRandomAccessFile.getFilePointer();
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
          if (i7 == a.aVA)
          {
            this.mIb = paramRandomAccessFile.getFilePointer();
            l1 = b(paramRandomAccessFile, i6);
            Log.i("MicroMsg.StblAtom", "handleStscAtom cost:%sms", new Object[] { Long.valueOf(Util.ticksToNow(l3)) });
            i3 = 1;
            i2 = n;
            i = m;
            i4 = j;
          }
          else if (i7 == a.aVD)
          {
            this.mIc = paramRandomAccessFile.getFilePointer();
            l1 = c(paramRandomAccessFile, i6);
            Log.i("MicroMsg.StblAtom", "handleStcoAtom cost:%sms", new Object[] { Long.valueOf(Util.ticksToNow(l3)) });
            i = 1;
            i2 = n;
            i3 = k;
            i4 = j;
          }
          else if (i7 == a.aVE)
          {
            this.mIe = paramRandomAccessFile.getFilePointer();
            l1 = d(paramRandomAccessFile, i6);
            Log.i("MicroMsg.StblAtom", "handleCo64Atom cost:%sms", new Object[] { Long.valueOf(Util.ticksToNow(l3)) });
            i = 1;
            i2 = n;
            i3 = k;
            i4 = j;
          }
          else if (i7 == a.aVB)
          {
            this.mIf = paramRandomAccessFile.getFilePointer();
            Log.i("MicroMsg.StblAtom", "stsz atom pos:%s", new Object[] { Long.valueOf(this.mIf) });
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
            if (i7 == a.aVy)
            {
              this.mIg = paramRandomAccessFile.getFilePointer();
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
        bvL();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.a.o
 * JD-Core Version:    0.7.0.1
 */