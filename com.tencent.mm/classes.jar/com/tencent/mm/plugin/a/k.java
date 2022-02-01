package com.tencent.mm.plugin.a;

import android.annotation.TargetApi;
import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.s;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class k
  implements f
{
  private long duration;
  private String filePath;
  public int jQB;
  private List<long[]> jQC;
  private Pair[] jQD;
  private long jQE;
  private o jQF;
  private long jQG;
  private o jQH;
  protected boolean jQI;
  private int jQJ;
  private ArrayList<Pair<Integer, Integer>> jQK;
  private Comparator<Pair<Integer, Integer>> jQL;
  private long jQs;
  private long[] jQv;
  private int jQw;
  private List<n> jQx;
  private List<Pair> jQy;
  private RandomAccessFile randomAccessFile;
  
  public k()
  {
    AppMethodBeat.i(133873);
    this.jQC = new ArrayList();
    this.jQE = -1L;
    this.jQF = null;
    this.jQG = -1L;
    this.jQH = null;
    this.jQI = false;
    this.jQJ = 0;
    this.jQK = new ArrayList();
    this.jQL = new k.1(this);
    this.jQB = 0;
    blT();
    AppMethodBeat.o(133873);
  }
  
  private long[] a(RandomAccessFile paramRandomAccessFile, long paramLong, byte[] paramArrayOfByte, boolean paramBoolean)
  {
    AppMethodBeat.i(133879);
    long l = Util.currentTicks();
    Log.i("MicroMsg.Mp4Parser2", "createTimeTable, minfFilePos:%s, isVideo:%s", new Object[] { Long.valueOf(paramLong), Boolean.valueOf(paramBoolean) });
    paramRandomAccessFile.seek(paramLong);
    paramArrayOfByte = (o)c.a(paramRandomAccessFile, paramArrayOfByte, a.blp);
    Log.i("MicroMsg.Mp4Parser2", "createTimeTable, stblAtom:%s, duration:%s, timeScale:%s", new Object[] { paramArrayOfByte, Long.valueOf(this.duration), Long.valueOf(this.jQs) });
    if (paramArrayOfByte != null)
    {
      paramArrayOfByte.duration = this.duration;
      paramArrayOfByte.jQs = this.jQs;
      paramArrayOfByte.f(paramRandomAccessFile);
      paramRandomAccessFile = paramArrayOfByte.jQv;
      if (paramBoolean)
      {
        this.jQx = paramArrayOfByte.jQx;
        this.jQy = paramArrayOfByte.jQy;
      }
      if ((this.jQx != null) && (this.jQy != null)) {
        Log.d("MicroMsg.Mp4Parser2", "parser stbl atom finish, sampleList:%s, stssList:%s", new Object[] { Integer.valueOf(this.jQx.size()), Integer.valueOf(this.jQy.size()) });
      }
      if (paramRandomAccessFile != null) {
        Log.i("MicroMsg.Mp4Parser2", "createTimeTable cost:%s, length:%s", new Object[] { Long.valueOf(Util.ticksToNow(l)), Integer.valueOf(paramRandomAccessFile.length) });
      }
      AppMethodBeat.o(133879);
      return paramRandomAccessFile;
    }
    AppMethodBeat.o(133879);
    return new long[0];
  }
  
  private long[] a(RandomAccessFile paramRandomAccessFile, o paramo)
  {
    AppMethodBeat.i(175943);
    long l3 = Util.currentTicks();
    Log.i("MicroMsg.Mp4Parser2", "createTimeTable, stblAtom:%s, duration:%s, timeScale:%s", new Object[] { paramo, Long.valueOf(this.duration), Long.valueOf(this.jQs) });
    if (paramo != null)
    {
      paramo.duration = this.duration;
      paramo.jQs = this.jQs;
      long l1 = paramo.getSize();
      byte[] arrayOfByte = new byte[8];
      int j = 0;
      int m = 0;
      int k = 0;
      int n = 0;
      int i1 = 0;
      long l4 = Util.currentTicks();
      long l2 = l1 - 8L;
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
        long l5 = Util.currentTicks();
        if (i7 == a.blV)
        {
          paramo.jQQ = paramRandomAccessFile.getFilePointer();
          l1 = paramo.a(paramRandomAccessFile, i6);
          Log.i("MicroMsg.StblAtom", "handleSttsAtom cost:%sms", new Object[] { Long.valueOf(Util.ticksToNow(l5)) });
          i4 = 1;
          i = m;
          i3 = k;
          i2 = n;
        }
        while (!c.a(paramRandomAccessFile, i6 - l1 - i5))
        {
          paramRandomAccessFile = new IOException("skip file error.");
          AppMethodBeat.o(175943);
          throw paramRandomAccessFile;
          if (i7 == a.blY)
          {
            paramo.jQR = paramRandomAccessFile.getFilePointer();
            l1 = paramo.b(paramRandomAccessFile, i6);
            Log.i("MicroMsg.StblAtom", "handleStscAtom cost:%sms", new Object[] { Long.valueOf(Util.ticksToNow(l5)) });
            i3 = 1;
            i2 = n;
            i = m;
            i4 = j;
          }
          else if (i7 == a.bmb)
          {
            paramo.jQS = paramRandomAccessFile.getFilePointer();
            l1 = paramo.c(paramRandomAccessFile, i6);
            Log.i("MicroMsg.StblAtom", "handleStcoAtom cost:%sms", new Object[] { Long.valueOf(Util.ticksToNow(l5)) });
            i = 1;
            i2 = n;
            i3 = k;
            i4 = j;
          }
          else if (i7 == a.bmc)
          {
            paramo.jQT = paramRandomAccessFile.getFilePointer();
            l1 = paramo.d(paramRandomAccessFile, i6);
            Log.i("MicroMsg.StblAtom", "handleCo64Atom cost:%sms", new Object[] { Long.valueOf(Util.ticksToNow(l5)) });
            i = 1;
            i2 = n;
            i3 = k;
            i4 = j;
          }
          else if (i7 == a.blZ)
          {
            paramo.jQU = paramRandomAccessFile.getFilePointer();
            paramo.jQW = i6;
            Log.i("MicroMsg.StblAtom", "stsz atom pos:%s", new Object[] { Long.valueOf(paramo.jQU) });
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
              paramo.jQV = paramRandomAccessFile.getFilePointer();
              l1 = paramo.f(paramRandomAccessFile, i6);
              Log.i("MicroMsg.StblAtom", "handleStssAtom cost:%sms", new Object[] { Long.valueOf(Util.ticksToNow(l5)) });
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
        paramo.jRe = true;
        if (paramo.jQU > 0L)
        {
          l2 = Util.currentTicks();
          paramRandomAccessFile.seek(paramo.jQU);
          i = paramo.jQW;
          if (c.a(paramRandomAccessFile, 4L)) {
            break label1070;
          }
          l1 = -1L;
          label705:
          Log.i("MicroMsg.StblAtom", "handleStszAtom cost:%sms, ret:%s, sampleSizeTable.length:%s", new Object[] { Long.valueOf(Util.ticksToNow(l2)), Long.valueOf(l1), Integer.valueOf(paramo.boF.length) });
          if (paramo.jQY != null) {
            break label1350;
          }
        }
      }
      label1070:
      label1350:
      for (paramo.jQD = new Pair[paramo.jQx.size()];; paramo.jQD = new Pair[paramo.jQY.length])
      {
        Log.i("MicroMsg.StblAtom", "parse lazy, stssArray.size:%s", new Object[] { Integer.valueOf(paramo.jQD.length) });
        l1 = Util.currentTicks();
        paramo.b(paramRandomAccessFile, 0, 5);
        paramo.jRb = 5L;
        Log.i("MicroMsg.StblAtom", "createTimeTable cost:%sms, size:%s, lazyDurationSecond:%s", new Object[] { Long.valueOf(Util.ticksToNow(l1)), Integer.valueOf(paramo.jQv.length), Integer.valueOf(5) });
        if (5 >= paramo.jQv.length)
        {
          paramo.jRe = false;
          Log.i("MicroMsg.StblAtom", "lazyDurationSecond:%s, timeTable.length:%s, not need lazy", new Object[] { Integer.valueOf(5), Integer.valueOf(paramo.jQv.length) });
        }
        Log.i("MicroMsg.StblAtom", "lazy parse finish cost:%sms", new Object[] { Long.valueOf(Util.ticksToNow(l4)) });
        paramRandomAccessFile = paramo.jQv;
        this.jQx = paramo.jQx;
        this.jQy = paramo.jQy;
        this.jQD = paramo.jQD;
        if ((this.jQx != null) && (this.jQD != null)) {
          Log.d("MicroMsg.Mp4Parser2", "parser stbl atom lazy finish, sampleList.size:%s, stssArray.length:%s", new Object[] { Integer.valueOf(this.jQx.size()), Integer.valueOf(this.jQD.length) });
        }
        if (paramRandomAccessFile != null) {
          Log.i("MicroMsg.Mp4Parser2", "createTimeTableLazy cost:%s, length:%s", new Object[] { Long.valueOf(Util.ticksToNow(l3)), Integer.valueOf(paramRandomAccessFile.length) });
        }
        AppMethodBeat.o(175943);
        return paramRandomAccessFile;
        l2 -= i6;
        n = i2;
        k = i3;
        m = i;
        j = i4;
        break;
        arrayOfByte = new byte[4];
        if (paramRandomAccessFile.read(arrayOfByte, 0, 4) < 4)
        {
          Log.w("MicroMsg.StblAtom", "stsz read sample size error");
          l1 = -1L;
          break label705;
        }
        j = c.readInt(arrayOfByte, 0);
        if (j > 0)
        {
          paramo.boF = new int[1];
          paramo.boF[0] = j;
          Log.i("MicroMsg.StblAtom", "all sample size is the same. size : ".concat(String.valueOf(j)));
          l1 = 8L;
          break label705;
        }
        if (paramRandomAccessFile.read(arrayOfByte, 0, 4) < 4)
        {
          Log.w("MicroMsg.StblAtom", "stsz read entry count error");
          l1 = -1L;
          break label705;
        }
        j = c.readInt(arrayOfByte, 0);
        l1 = j * 4L;
        if ((l1 <= 0L) || (l1 > i - 20))
        {
          Log.w("MicroMsg.StblAtom", "stco error entryCount : ".concat(String.valueOf(j)));
          l1 = -1L;
          break label705;
        }
        paramo.jRd = l1;
        paramo.boF = new int[j + 1];
        paramo.jRh = new byte[paramo.boF.length * 4];
        paramo.jRc = paramRandomAccessFile.getFilePointer();
        l1 = paramRandomAccessFile.read(paramo.jRh);
        Log.i("MicroMsg.StblAtom", "handleStszAtomLazy start parse stsz filePos:%s, sampleSizeReaded:%s, sampleSizeTableData.length:%s", new Object[] { Long.valueOf(paramo.jRc), Long.valueOf(l1), Integer.valueOf(paramo.jRh.length) });
        paramo.a(paramRandomAccessFile, 0, 5);
        l1 += 12L;
        break label705;
      }
    }
    AppMethodBeat.o(175943);
    return new long[0];
  }
  
  private void blU()
  {
    AppMethodBeat.i(133880);
    Log.i("MicroMsg.Mp4Parser2", "timeTableLength, length:%s", new Object[] { Integer.valueOf(this.jQw) });
    this.jQv = new long[this.jQw + 2];
    Iterator localIterator = this.jQC.iterator();
    while (localIterator.hasNext())
    {
      long[] arrayOfLong1 = (long[])localIterator.next();
      int i = 0;
      while (i < arrayOfLong1.length)
      {
        long[] arrayOfLong2 = this.jQv;
        arrayOfLong2[i] = Math.max(arrayOfLong2[i], arrayOfLong1[i]);
        i += 1;
      }
    }
    AppMethodBeat.o(133880);
  }
  
  private boolean e(RandomAccessFile paramRandomAccessFile)
  {
    AppMethodBeat.i(133881);
    reset();
    Object localObject1 = l.jQN;
    l.ge(this.jQI);
    long l3;
    long l1;
    long l2;
    int j;
    int k;
    g localg;
    for (;;)
    {
      int i;
      try
      {
        localObject1 = new byte[8];
        Log.i("MicroMsg.Mp4Parser2", "parserExtractor");
        l3 = Util.currentTicks();
        localObject2 = c.a(paramRandomAccessFile, (byte[])localObject1, a.blk);
        Log.d("MicroMsg.Mp4Parser2", "find moov atom finish, cost:%s, beginPos:%s, size:%s", new Object[] { Long.valueOf(Util.ticksToNow(l3)), Long.valueOf(((a)localObject2).jPV), Long.valueOf(((a)localObject2).getSize()) });
        l1 = ((a)localObject2).jPV;
        l2 = ((a)localObject2).getSize();
        i = 0;
        l2 -= 8L;
        l1 += 8L;
        if (l2 > 0L)
        {
          paramRandomAccessFile.seek(l1);
          paramRandomAccessFile.read((byte[])localObject1);
          j = c.readInt((byte[])localObject1, 0);
          k = c.readInt((byte[])localObject1, 4);
          Log.i("MicroMsg.Mp4Parser2", "read atomSize:%s, atomType:%s", new Object[] { Integer.valueOf(j), Integer.valueOf(k) });
          if (k != a.blm) {
            break label1089;
          }
          localObject2 = (p)i.f(j, k, l1);
          localg = p.b(paramRandomAccessFile, (byte[])localObject1);
          Log.i("MicroMsg.Mp4Parser2", "found track atom, mdiaAtom:%s, trakAtom:%s", new Object[] { localg, localObject2 });
          if ((localg == null) || (!localg.a(paramRandomAccessFile, (byte[])localObject1))) {
            break label1089;
          }
          if (localg.jQt != g.jQp) {
            break label783;
          }
          this.jQs = localg.jQs;
          this.duration = localg.duration;
          Log.i("MicroMsg.Mp4Parser2", "this trak atom is video trak. timeScale: " + this.jQs + " duration: " + this.duration);
          this.jQE = localg.jQu;
          if (this.jQI)
          {
            long l4 = this.jQE;
            long l5 = Util.currentTicks();
            Log.i("MicroMsg.Mp4Parser2", "findStblAtomInfo, minfFilePos:%s", new Object[] { Long.valueOf(l4) });
            paramRandomAccessFile.seek(l4);
            localObject2 = (o)c.a(paramRandomAccessFile, (byte[])localObject1, a.blp);
            Log.i("MicroMsg.Mp4Parser2", "findStblAtomInfo, stblAtom:%s, duration:%s, timeScale:%s, cost:%s", new Object[] { localObject2, Long.valueOf(this.duration), Long.valueOf(this.jQs), Long.valueOf(Util.ticksToNow(l5)) });
            this.jQF = ((o)localObject2);
            this.jQv = a(paramRandomAccessFile, this.jQF);
            this.jQI = this.jQF.jRe;
            this.jQK.add(new Pair(Integer.valueOf(0), Integer.valueOf(5)));
            this.jQJ = ((Integer)((Pair)this.jQK.get(this.jQK.size() - 1)).second).intValue();
            this.jQw = (this.jQv.length - 2);
            Log.i("MicroMsg.Mp4Parser2", "lazy parse finish, isLazyParse:%s", new Object[] { Boolean.valueOf(this.jQI) });
            i = 1;
            if (this.jQw <= 30) {
              break label765;
            }
            Log.i("MicroMsg.Mp4Parser2", "current timeTableLength is:%s too long, ignore parse other track", new Object[] { Integer.valueOf(this.jQw) });
          }
        }
        else
        {
          label593:
          if (this.jQI) {
            break label1049;
          }
          Log.i("MicroMsg.Mp4Parser2", "parse finish, start merge time table, cost:%s", new Object[] { Long.valueOf(Util.ticksToNow(l3)) });
          blU();
          l1 = Util.ticksToNow(l3);
          label634:
          Log.i("MicroMsg.Mp4Parser2", "parseExtractor finish, totalCost:%sms, isLazyParse:%s", new Object[] { Long.valueOf(l1), Boolean.valueOf(this.jQI) });
          paramRandomAccessFile = l.jQN;
          l.a(this.jQI, l1, this.jQw);
          AppMethodBeat.o(133881);
          return true;
        }
        localObject2 = a(paramRandomAccessFile, localg.jQu, (byte[])localObject1, true);
        Log.i("MicroMsg.Mp4Parser2", "createTimeTable finish");
        this.jQC.add(localObject2);
        this.jQw = Math.max(this.jQw, localObject2.length - 2);
        continue;
        if (!this.jQI) {
          break label968;
        }
      }
      catch (Exception paramRandomAccessFile)
      {
        Log.printErrStackTrace("MicroMsg.Mp4Parser2", paramRandomAccessFile, "parser mp4 error", new Object[0]);
        AppMethodBeat.o(133881);
        return false;
      }
      label765:
      Log.i("MicroMsg.Mp4Parser2", "lazy parse, ignore other trak atom");
      continue;
      label783:
      if (localg.jQt != g.jQq) {
        break label1038;
      }
      if ((this.jQI) && (i != 0))
      {
        Log.i("MicroMsg.Mp4Parser2", "lazy parse, ignore sound trak atom");
      }
      else
      {
        if (this.jQw <= 30) {
          break;
        }
        Log.i("MicroMsg.Mp4Parser2", "current timeTableLength is:%s too long, ignore parse sound track", new Object[] { Integer.valueOf(this.jQw) });
      }
    }
    this.jQs = localg.jQs;
    this.duration = localg.duration;
    Log.i("MicroMsg.Mp4Parser2", "this trak atom is sound trak. timeScale: " + this.jQs + " duration: " + this.duration);
    this.jQG = localg.jQu;
    Object localObject2 = a(paramRandomAccessFile, localg.jQu, (byte[])localObject1, false);
    Log.i("MicroMsg.Mp4Parser2", "createTimeTable finish");
    this.jQC.add(localObject2);
    this.jQw = Math.max(this.jQw, localObject2.length - 2);
    label1038:
    label1049:
    label1089:
    for (;;)
    {
      label968:
      l2 -= j;
      l1 += j;
      Log.d("MicroMsg.Mp4Parser2", "atomSize:%s, atomType:%s, remains:%s, beginPos:%s, timeTableLength:%s", new Object[] { Integer.valueOf(j), Integer.valueOf(k), Long.valueOf(l2), Long.valueOf(l1), Integer.valueOf(this.jQw) });
      break;
      Log.i("MicroMsg.Mp4Parser2", "unknown mdiaAtom");
      break label593;
      l1 = Util.ticksToNow(l3);
      Log.i("MicroMsg.Mp4Parser2", "lazy parse finish, cost:%s, timeTableLength:%s", new Object[] { Long.valueOf(l1), Integer.valueOf(this.jQw) });
      break label634;
    }
  }
  
  private void reset()
  {
    AppMethodBeat.i(133874);
    this.filePath = null;
    this.jQv = null;
    this.jQC.clear();
    this.jQw = 0;
    this.duration = 0L;
    this.jQs = 0L;
    if (this.jQx != null) {
      this.jQx.clear();
    }
    if (this.jQy != null) {
      this.jQy.clear();
    }
    if (this.jQK != null) {
      this.jQK.clear();
    }
    this.jQD = null;
    this.jQB = 0;
    AppMethodBeat.o(133874);
  }
  
  private Pair<Integer, Integer> uU(int paramInt)
  {
    AppMethodBeat.i(175940);
    Pair localPair1;
    if (this.jQK.size() > 0)
    {
      localPair1 = new Pair(Integer.valueOf(Math.max(paramInt - 1, 1)), Integer.valueOf(Math.min(paramInt + 5, this.jQv.length - 1)));
      Iterator localIterator = this.jQK.iterator();
      while (localIterator.hasNext())
      {
        Pair localPair2 = (Pair)localIterator.next();
        if ((((Integer)localPair2.first).equals(localPair1.first)) && (((Integer)localPair2.second).equals(localPair1.second)))
        {
          AppMethodBeat.o(175940);
          return null;
        }
        if ((((Integer)localPair2.first).intValue() > ((Integer)localPair1.first).intValue()) && (((Integer)localPair2.second).intValue() < ((Integer)localPair1.second).intValue())) {
          break label501;
        }
        if ((((Integer)localPair2.first).intValue() >= ((Integer)localPair1.first).intValue()) || (((Integer)localPair2.second).intValue() <= ((Integer)localPair1.second).intValue())) {
          if ((((Integer)localPair2.first).intValue() <= ((Integer)localPair1.first).intValue()) && (((Integer)localPair1.first).intValue() <= ((Integer)localPair2.second).intValue()) && (((Integer)localPair2.second).intValue() <= ((Integer)localPair1.second).intValue()))
          {
            localPair1 = new Pair(Integer.valueOf(Math.min(((Integer)localPair2.second).intValue() + 1, this.jQv.length - 1)), localPair1.second);
          }
          else
          {
            if ((((Integer)localPair2.first).intValue() < ((Integer)localPair1.first).intValue()) || (((Integer)localPair1.second).intValue() < ((Integer)localPair2.first).intValue()) || (((Integer)localPair2.second).intValue() < ((Integer)localPair1.second).intValue())) {
              break label501;
            }
            localPair1 = new Pair(localPair1.first, Integer.valueOf(Math.max(((Integer)localPair2.first).intValue() - 1, 1)));
          }
        }
      }
    }
    label501:
    for (;;)
    {
      break;
      if (((Integer)localPair1.first).intValue() > ((Integer)localPair1.second).intValue())
      {
        AppMethodBeat.o(175940);
        return null;
      }
      AppMethodBeat.o(175940);
      return localPair1;
      localPair1 = new Pair(Integer.valueOf(1), Integer.valueOf(paramInt));
      AppMethodBeat.o(175940);
      return localPair1;
    }
  }
  
  private void uV(int paramInt)
  {
    AppMethodBeat.i(175941);
    if (this.jQF != null)
    {
      long l2 = Util.currentTicks();
      Log.i("MicroMsg.Mp4Parser2", "checkUpdateLazyParseTimeTable currentLazyParseSeconds:%s, second:%s", new Object[] { Integer.valueOf(this.jQJ), Integer.valueOf(paramInt) });
      Object localObject = uU(paramInt);
      Log.i("MicroMsg.Mp4Parser2", "calcLazyParseRange cost:%sms", new Object[] { Long.valueOf(Util.ticksToNow(l2)) });
      if (localObject != null)
      {
        Log.i("MicroMsg.Mp4Parser2", "checkUpdateLazyParseTimeTable, newParseRange:[%s, %s]", new Object[] { ((Pair)localObject).first, ((Pair)localObject).second });
        boolean bool = this.jQF.b(this.randomAccessFile, ((Integer)((Pair)localObject).first).intValue(), ((Integer)((Pair)localObject).second).intValue());
        this.jQv = this.jQF.jQv;
        this.jQx = this.jQF.jQx;
        this.jQy = this.jQF.jQy;
        this.jQD = this.jQF.jQD;
        this.jQK.add(localObject);
        long l1 = Util.currentTicks();
        Collections.sort(this.jQK, this.jQL);
        this.jQJ = ((Integer)((Pair)this.jQK.get(this.jQK.size() - 1)).second).intValue();
        l2 = Util.ticksToNow(l2);
        Log.i("MicroMsg.Mp4Parser2", "checkUpdateLazyParseTimeTable incrementCreateTimeTable finish, ret:%s, cost:%sms, sort cost:%s, range:[%s, %s]", new Object[] { Boolean.valueOf(bool), Long.valueOf(l2), Long.valueOf(Util.ticksToNow(l1)), ((Pair)localObject).first, ((Pair)localObject).second });
        localObject = l.jQN;
        l.AS(l2);
      }
    }
    AppMethodBeat.o(175941);
  }
  
  public final boolean L(String paramString, long paramLong)
  {
    AppMethodBeat.i(208739);
    reset();
    this.filePath = paramString;
    if (!new com.tencent.mm.vfs.o(this.filePath).exists())
    {
      AppMethodBeat.o(208739);
      return false;
    }
    try
    {
      this.randomAccessFile = s.dB(this.filePath, false);
      boolean bool = e(this.randomAccessFile);
      AppMethodBeat.o(208739);
      return bool;
    }
    catch (Exception paramString)
    {
      AppMethodBeat.o(208739);
    }
    return false;
  }
  
  public final boolean a(int paramInt1, int paramInt2, PInt paramPInt1, PInt paramPInt2)
  {
    AppMethodBeat.i(133877);
    Log.i("MicroMsg.Mp4Parser2", "[before] curPlaySecond %d, cacheSecond %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (this.jQv == null)
    {
      AppMethodBeat.o(133877);
      return false;
    }
    long l1 = Util.currentTicks();
    int i = paramInt1;
    if (paramInt1 < 0) {
      i = 0;
    }
    int j = this.jQv.length;
    if (i < j)
    {
      paramInt1 = paramInt2;
      if (paramInt2 < j) {}
    }
    else
    {
      i = j - 2;
      paramInt1 = j - 1;
    }
    if (this.jQI) {}
    try
    {
      uV(Math.max(i, paramInt1));
      l2 = this.jQv[i];
      l3 = this.jQv[paramInt1];
      Log.d("MicroMsg.Mp4Parser2", "curPos %d, cachePos %d", new Object[] { Long.valueOf(l2), Long.valueOf(l3) });
      if ((l2 < 0L) || (l3 < 0L)) {
        Log.e("MicroMsg.Mp4Parser2", "videoTimeToFilePos error, not parse this entry now");
      }
      if (i == 0)
      {
        paramPInt1.value = 0;
        paramPInt2.value = ((int)l3);
        Log.i("MicroMsg.Mp4Parser2", "[after] curPlaySecond %d, cacheSecond %d, offset.value %d, length.value %d, cost %sms", new Object[] { Integer.valueOf(i), Integer.valueOf(paramInt1), Integer.valueOf(paramPInt1.value), Integer.valueOf(paramPInt2.value), Long.valueOf(Util.ticksToNow(l1)) });
        AppMethodBeat.o(133877);
        return true;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        long l2;
        long l3;
        Log.printErrStackTrace("MicroMsg.Mp4Parser2", localException, "videoTimeToFilePos, checkUpdateLazyParseTimeTable error", new Object[0]);
        continue;
        paramPInt1.value = ((int)l2);
        paramPInt2.value = ((int)l3 - (int)l2);
      }
    }
  }
  
  @TargetApi(5)
  public final boolean b(int paramInt, PInt paramPInt1, PInt paramPInt2)
  {
    AppMethodBeat.i(133876);
    bool4 = false;
    bool3 = false;
    for (;;)
    {
      try
      {
        if (this.jQI) {
          continue;
        }
        if ((this.jQy == null) || (this.jQy.size() <= 0)) {
          continue;
        }
        j = this.jQy.size();
        l = paramInt;
        paramPInt2.value = 0;
        paramPInt1.value = 0;
        i = 0;
        if (i >= j) {
          continue;
        }
        localPair = (Pair)this.jQy.get(i);
        if (((Long)localPair.second).longValue() <= 1000L * (l * 1000L)) {
          continue;
        }
        paramPInt2.value = ((int)(((Long)localPair.second).longValue() / 1000L / 1000L));
        bool1 = true;
      }
      catch (Exception localException1)
      {
        int j;
        long l;
        int i;
        Pair localPair;
        boolean bool2 = false;
        Log.printErrStackTrace("MicroMsg.Mp4Parser2", localException1, "seekVFrame seekTime[%d]", new Object[] { Integer.valueOf(paramInt) });
        continue;
        Log.i("MicroMsg.Mp4Parser2", "lazy parse seek key Frame seekTime[%d] pre[%d] next[%d], find:%s, fromLastFrame:%s, stssList.size:%s, stssArray.length:%s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(paramPInt1.value), Integer.valueOf(paramPInt2.value), Boolean.valueOf(bool2), Boolean.valueOf(bool3), Integer.valueOf(this.jQy.size()), Integer.valueOf(this.jQD.length) });
        continue;
        bool2 = false;
        continue;
        boolean bool1 = false;
        continue;
      }
      if (bool1) {
        continue;
      }
      bool2 = bool1;
      try
      {
        paramPInt1.value = ((int)(((Long)((Pair)this.jQy.get(j - 1)).second).longValue() / 1000L / 1000L));
        bool2 = bool1;
        paramPInt2.value = paramInt;
        bool1 = true;
        bool2 = true;
        bool3 = bool2;
        bool2 = bool1;
        if (this.jQI) {
          continue;
        }
        Log.i("MicroMsg.Mp4Parser2", "seek key Frame seekTime[%d] pre[%d] next[%d], stssList.size:%s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(paramPInt1.value), Integer.valueOf(paramPInt2.value), Integer.valueOf(this.jQy.size()) });
        AppMethodBeat.o(133876);
        return bool2;
      }
      catch (Exception localException2)
      {
        continue;
        bool2 = bool1;
        bool1 = bool4;
        continue;
        bool1 = false;
        continue;
      }
      paramPInt1.value = ((int)(((Long)localPair.second).longValue() / 1000L / 1000L));
      i += 1;
    }
    AppMethodBeat.o(133876);
    return false;
    if ((this.jQD != null) && (this.jQD.length > 0))
    {
      uV(paramInt);
      uV(this.jQv.length);
      j = this.jQD.length;
      l = paramInt;
      paramPInt2.value = 0;
      paramPInt1.value = 0;
      i = 0;
      for (;;)
      {
        if (i >= j) {
          break label695;
        }
        localPair = this.jQD[i];
        if (localPair != null)
        {
          if (((Long)localPair.second).longValue() > 1000L * (l * 1000L))
          {
            paramPInt2.value = ((int)(((Long)localPair.second).longValue() / 1000L / 1000L));
            bool1 = true;
            if (bool1) {
              break label684;
            }
            bool2 = bool1;
            localPair = this.jQD[(j - 1)];
            if (localPair == null) {
              break label684;
            }
            bool2 = bool1;
            paramPInt1.value = ((int)(((Long)localPair.second).longValue() / 1000L / 1000L));
            bool2 = bool1;
            paramPInt2.value = paramInt;
            bool2 = true;
            bool1 = true;
            bool3 = bool1;
            break;
          }
          paramPInt1.value = ((int)(((Long)localPair.second).longValue() / 1000L / 1000L));
        }
        i += 1;
      }
    }
    AppMethodBeat.o(133876);
    return false;
  }
  
  public final int blR()
  {
    AppMethodBeat.i(133875);
    for (;;)
    {
      try
      {
        if (this.jQI) {
          continue;
        }
        if (this.jQy == null) {
          continue;
        }
        if (this.jQB == 0) {
          this.jQB = ((int)(((Long)((Pair)this.jQy.get(this.jQy.size() - 1)).second).longValue() / 1000L / 1000L));
        }
        i = this.jQB;
      }
      catch (Exception localException)
      {
        Pair localPair;
        Log.printErrStackTrace("MicroMsg.Mp4Parser2", localException, "get last key frame error.", new Object[0]);
        int i = 0;
        continue;
      }
      AppMethodBeat.o(133875);
      return i;
      i = 0;
      continue;
      if ((this.jQD != null) && (this.jQD.length > 0))
      {
        if (this.jQD[(this.jQD.length - 1)] == null) {
          uV(this.jQv.length - 1);
        }
        localPair = this.jQD[(this.jQD.length - 1)];
        if ((localPair != null) && (this.jQB == 0)) {
          this.jQB = ((int)(((Long)localPair.second).longValue() / 1000L / 1000L));
        }
        i = this.jQB;
      }
      else
      {
        i = 0;
      }
    }
  }
  
  public final int blS()
  {
    return this.jQw;
  }
  
  public void blT()
  {
    AppMethodBeat.i(208738);
    if (((b)com.tencent.mm.kernel.g.af(b.class)).a(b.a.skM, 0) == 1)
    {
      Log.i("MicroMsg.Mp4Parser2", "config to use lazy parse");
      this.jQI = true;
      AppMethodBeat.o(208738);
      return;
    }
    Log.i("MicroMsg.Mp4Parser2", "not use lazy parse");
    this.jQI = false;
    AppMethodBeat.o(208738);
  }
  
  public final int dG(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(175942);
    if (this.jQv == null)
    {
      AppMethodBeat.o(175942);
      return 0;
    }
    long l1 = Util.currentTicks();
    long l2 = paramInt1 + paramInt2;
    int j = 0;
    int k = this.jQv.length;
    int i;
    if (this.jQI)
    {
      if (this.jQJ >= this.jQv.length) {
        break label205;
      }
      i = this.jQJ;
    }
    int m;
    for (;;)
    {
      Log.i("MicroMsg.Mp4Parser2", "filePosToVideoTime lazy parse try search from time table, count:%s", new Object[] { Integer.valueOf(i) });
      try
      {
        uV(i);
        k = i;
        i = 0;
        m = j;
        if (i < k) {
          if ((!this.jQI) || (this.jQv[i] >= 0L)) {}
        }
      }
      catch (Exception localException1)
      {
        try
        {
          uV(i);
          if (this.jQv[i] == l2)
          {
            m = i;
            label143:
            Log.i("MicroMsg.Mp4Parser2", "filePosToVideoTime, offset:%s, length:%s, filePos:%s, playtime:%s, cost:%sms", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Long.valueOf(l2), Integer.valueOf(m), Long.valueOf(Util.ticksToNow(l1)) });
            AppMethodBeat.o(175942);
            return m;
            label205:
            i = this.jQv.length;
            continue;
            localException1 = localException1;
            Log.printErrStackTrace("MicroMsg.Mp4Parser2", localException1, "", new Object[0]);
            k = i;
          }
        }
        catch (Exception localException2)
        {
          for (;;)
          {
            Log.printErrStackTrace("MicroMsg.Mp4Parser2", localException2, "", new Object[0]);
          }
        }
      }
    }
    if (this.jQv[i] < l2) {
      j = i;
    }
    for (;;)
    {
      i += 1;
      break;
      m = j;
      if (this.jQv[i] > l2) {
        break label143;
      }
    }
  }
  
  /* Error */
  public final void release()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc_w 674
    //   5: invokestatic 52	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_0
    //   9: getfield 571	com/tencent/mm/plugin/a/k:randomAccessFile	Ljava/io/RandomAccessFile;
    //   12: astore_1
    //   13: aload_1
    //   14: ifnull +110 -> 124
    //   17: ldc 100
    //   19: ldc_w 676
    //   22: iconst_0
    //   23: anewarray 4	java/lang/Object
    //   26: invokestatic 679	com/tencent/mm/sdk/platformtools/Log:printInfoStack	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   29: aload_0
    //   30: getfield 571	com/tencent/mm/plugin/a/k:randomAccessFile	Ljava/io/RandomAccessFile;
    //   33: invokevirtual 682	java/io/RandomAccessFile:close	()V
    //   36: aload_0
    //   37: aconst_null
    //   38: putfield 571	com/tencent/mm/plugin/a/k:randomAccessFile	Ljava/io/RandomAccessFile;
    //   41: aload_0
    //   42: iconst_0
    //   43: putfield 71	com/tencent/mm/plugin/a/k:jQJ	I
    //   46: aload_0
    //   47: getfield 73	com/tencent/mm/plugin/a/k:jQK	Ljava/util/ArrayList;
    //   50: invokevirtual 544	java/util/ArrayList:clear	()V
    //   53: aload_0
    //   54: aconst_null
    //   55: putfield 63	com/tencent/mm/plugin/a/k:jQF	Lcom/tencent/mm/plugin/a/o;
    //   58: aload_0
    //   59: aconst_null
    //   60: putfield 67	com/tencent/mm/plugin/a/k:jQH	Lcom/tencent/mm/plugin/a/o;
    //   63: aload_0
    //   64: aconst_null
    //   65: putfield 571	com/tencent/mm/plugin/a/k:randomAccessFile	Ljava/io/RandomAccessFile;
    //   68: ldc_w 674
    //   71: invokestatic 88	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   74: aload_0
    //   75: monitorexit
    //   76: return
    //   77: astore_1
    //   78: ldc 100
    //   80: aload_1
    //   81: ldc_w 672
    //   84: iconst_0
    //   85: anewarray 4	java/lang/Object
    //   88: invokestatic 520	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   91: aload_0
    //   92: aconst_null
    //   93: putfield 571	com/tencent/mm/plugin/a/k:randomAccessFile	Ljava/io/RandomAccessFile;
    //   96: ldc_w 674
    //   99: invokestatic 88	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   102: goto -28 -> 74
    //   105: astore_1
    //   106: aload_0
    //   107: monitorexit
    //   108: aload_1
    //   109: athrow
    //   110: astore_1
    //   111: aload_0
    //   112: aconst_null
    //   113: putfield 571	com/tencent/mm/plugin/a/k:randomAccessFile	Ljava/io/RandomAccessFile;
    //   116: ldc_w 674
    //   119: invokestatic 88	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   122: aload_1
    //   123: athrow
    //   124: ldc_w 674
    //   127: invokestatic 88	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   130: goto -56 -> 74
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	133	0	this	k
    //   12	2	1	localRandomAccessFile	RandomAccessFile
    //   77	4	1	localIOException	IOException
    //   105	4	1	localObject1	Object
    //   110	13	1	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   17	63	77	java/io/IOException
    //   2	13	105	finally
    //   63	74	105	finally
    //   91	102	105	finally
    //   111	124	105	finally
    //   124	130	105	finally
    //   17	63	110	finally
    //   78	91	110	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.a.k
 * JD-Core Version:    0.7.0.1
 */