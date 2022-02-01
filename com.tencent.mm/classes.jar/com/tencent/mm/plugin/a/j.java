package com.tencent.mm.plugin.a;

import android.annotation.TargetApi;
import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.expt.a.b;
import com.tencent.mm.plugin.expt.a.b.a;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.vfs.e;
import com.tencent.mm.vfs.i;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class j
  implements p
{
  private long duration;
  private String filePath;
  public int hXB;
  private List<long[]> hXC;
  private Pair[] hXD;
  private long hXE;
  private n hXF;
  private long hXG;
  private n hXH;
  protected boolean hXI;
  private int hXJ;
  private ArrayList<Pair<Integer, Integer>> hXK;
  private Comparator<Pair<Integer, Integer>> hXL;
  private long hXs;
  private long[] hXv;
  private int hXw;
  private List<m> hXx;
  private List<Pair> hXy;
  private RandomAccessFile randomAccessFile;
  
  public j()
  {
    AppMethodBeat.i(133873);
    this.hXC = new ArrayList();
    this.hXE = -1L;
    this.hXF = null;
    this.hXG = -1L;
    this.hXH = null;
    this.hXI = false;
    this.hXJ = 0;
    this.hXK = new ArrayList();
    this.hXL = new j.1(this);
    this.hXB = 0;
    fQP();
    AppMethodBeat.o(133873);
  }
  
  private long[] a(RandomAccessFile paramRandomAccessFile, long paramLong, byte[] paramArrayOfByte, boolean paramBoolean)
  {
    AppMethodBeat.i(133879);
    long l = bt.GC();
    ad.i("MicroMsg.Mp4Parser2", "createTimeTable, minfFilePos:%s, isVideo:%s", new Object[] { Long.valueOf(paramLong), Boolean.valueOf(paramBoolean) });
    paramRandomAccessFile.seek(paramLong);
    paramArrayOfByte = (n)c.a(paramRandomAccessFile, paramArrayOfByte, a.ban);
    ad.i("MicroMsg.Mp4Parser2", "createTimeTable, stblAtom:%s, duration:%s, timeScale:%s", new Object[] { paramArrayOfByte, Long.valueOf(this.duration), Long.valueOf(this.hXs) });
    if (paramArrayOfByte != null)
    {
      paramArrayOfByte.duration = this.duration;
      paramArrayOfByte.hXs = this.hXs;
      paramArrayOfByte.f(paramRandomAccessFile);
      paramRandomAccessFile = paramArrayOfByte.hXv;
      if (paramBoolean)
      {
        this.hXx = paramArrayOfByte.hXx;
        this.hXy = paramArrayOfByte.hXy;
      }
      if ((this.hXx != null) && (this.hXy != null)) {
        ad.d("MicroMsg.Mp4Parser2", "parser stbl atom finish, sampleList:%s, stssList:%s", new Object[] { Integer.valueOf(this.hXx.size()), Integer.valueOf(this.hXy.size()) });
      }
      if (paramRandomAccessFile != null) {
        ad.i("MicroMsg.Mp4Parser2", "createTimeTable cost:%s, length:%s", new Object[] { Long.valueOf(bt.aS(l)), Integer.valueOf(paramRandomAccessFile.length) });
      }
      AppMethodBeat.o(133879);
      return paramRandomAccessFile;
    }
    AppMethodBeat.o(133879);
    return new long[0];
  }
  
  private long[] a(RandomAccessFile paramRandomAccessFile, n paramn)
  {
    AppMethodBeat.i(175943);
    long l3 = bt.GC();
    ad.i("MicroMsg.Mp4Parser2", "createTimeTable, stblAtom:%s, duration:%s, timeScale:%s", new Object[] { paramn, Long.valueOf(this.duration), Long.valueOf(this.hXs) });
    if (paramn != null)
    {
      paramn.duration = this.duration;
      paramn.hXs = this.hXs;
      long l1 = paramn.getSize();
      byte[] arrayOfByte = new byte[8];
      int j = 0;
      int m = 0;
      int k = 0;
      int n = 0;
      int i1 = 0;
      long l4 = bt.GC();
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
        ad.i("MicroMsg.StblAtom", "readAtom, type:%s, size:%s", new Object[] { Integer.valueOf(i7), Integer.valueOf(i6) });
        l1 = 0L;
        long l5 = bt.GC();
        if (i7 == a.baT)
        {
          paramn.hXQ = paramRandomAccessFile.getFilePointer();
          l1 = paramn.a(paramRandomAccessFile, i6);
          ad.i("MicroMsg.StblAtom", "handleSttsAtom cost:%sms", new Object[] { Long.valueOf(bt.aS(l5)) });
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
          if (i7 == a.baW)
          {
            paramn.hXR = paramRandomAccessFile.getFilePointer();
            l1 = paramn.b(paramRandomAccessFile, i6);
            ad.i("MicroMsg.StblAtom", "handleStscAtom cost:%sms", new Object[] { Long.valueOf(bt.aS(l5)) });
            i3 = 1;
            i2 = n;
            i = m;
            i4 = j;
          }
          else if (i7 == a.baZ)
          {
            paramn.hXS = paramRandomAccessFile.getFilePointer();
            l1 = paramn.c(paramRandomAccessFile, i6);
            ad.i("MicroMsg.StblAtom", "handleStcoAtom cost:%sms", new Object[] { Long.valueOf(bt.aS(l5)) });
            i = 1;
            i2 = n;
            i3 = k;
            i4 = j;
          }
          else if (i7 == a.bba)
          {
            paramn.hXT = paramRandomAccessFile.getFilePointer();
            l1 = paramn.d(paramRandomAccessFile, i6);
            ad.i("MicroMsg.StblAtom", "handleCo64Atom cost:%sms", new Object[] { Long.valueOf(bt.aS(l5)) });
            i = 1;
            i2 = n;
            i3 = k;
            i4 = j;
          }
          else if (i7 == a.baX)
          {
            paramn.hXU = paramRandomAccessFile.getFilePointer();
            paramn.hXW = i6;
            ad.i("MicroMsg.StblAtom", "stsz atom pos:%s", new Object[] { Long.valueOf(paramn.hXU) });
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
              paramn.hXV = paramRandomAccessFile.getFilePointer();
              l1 = paramn.f(paramRandomAccessFile, i6);
              ad.i("MicroMsg.StblAtom", "handleStssAtom cost:%sms", new Object[] { Long.valueOf(bt.aS(l5)) });
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
        paramn.hYe = true;
        if (paramn.hXU > 0L)
        {
          l2 = bt.GC();
          paramRandomAccessFile.seek(paramn.hXU);
          i = paramn.hXW;
          if (c.a(paramRandomAccessFile, 4L)) {
            break label1070;
          }
          l1 = -1L;
          label705:
          ad.i("MicroMsg.StblAtom", "handleStszAtom cost:%sms, ret:%s, sampleSizeTable.length:%s", new Object[] { Long.valueOf(bt.aS(l2)), Long.valueOf(l1), Integer.valueOf(paramn.bdD.length) });
          if (paramn.hXY != null) {
            break label1350;
          }
        }
      }
      label1070:
      label1350:
      for (paramn.hXD = new Pair[paramn.hXx.size()];; paramn.hXD = new Pair[paramn.hXY.length])
      {
        ad.i("MicroMsg.StblAtom", "parse lazy, stssArray.size:%s", new Object[] { Integer.valueOf(paramn.hXD.length) });
        l1 = bt.GC();
        paramn.b(paramRandomAccessFile, 0, 5);
        paramn.hYb = 5L;
        ad.i("MicroMsg.StblAtom", "createTimeTable cost:%sms, size:%s, lazyDurationSecond:%s", new Object[] { Long.valueOf(bt.aS(l1)), Integer.valueOf(paramn.hXv.length), Integer.valueOf(5) });
        if (5 >= paramn.hXv.length)
        {
          paramn.hYe = false;
          ad.i("MicroMsg.StblAtom", "lazyDurationSecond:%s, timeTable.length:%s, not need lazy", new Object[] { Integer.valueOf(5), Integer.valueOf(paramn.hXv.length) });
        }
        ad.i("MicroMsg.StblAtom", "lazy parse finish cost:%sms", new Object[] { Long.valueOf(bt.aS(l4)) });
        paramRandomAccessFile = paramn.hXv;
        this.hXx = paramn.hXx;
        this.hXy = paramn.hXy;
        this.hXD = paramn.hXD;
        if ((this.hXx != null) && (this.hXD != null)) {
          ad.d("MicroMsg.Mp4Parser2", "parser stbl atom lazy finish, sampleList.size:%s, stssArray.length:%s", new Object[] { Integer.valueOf(this.hXx.size()), Integer.valueOf(this.hXD.length) });
        }
        if (paramRandomAccessFile != null) {
          ad.i("MicroMsg.Mp4Parser2", "createTimeTableLazy cost:%s, length:%s", new Object[] { Long.valueOf(bt.aS(l3)), Integer.valueOf(paramRandomAccessFile.length) });
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
          ad.w("MicroMsg.StblAtom", "stsz read sample size error");
          l1 = -1L;
          break label705;
        }
        j = c.readInt(arrayOfByte, 0);
        if (j > 0)
        {
          paramn.bdD = new int[1];
          paramn.bdD[0] = j;
          ad.i("MicroMsg.StblAtom", "all sample size is the same. size : ".concat(String.valueOf(j)));
          l1 = 8L;
          break label705;
        }
        if (paramRandomAccessFile.read(arrayOfByte, 0, 4) < 4)
        {
          ad.w("MicroMsg.StblAtom", "stsz read entry count error");
          l1 = -1L;
          break label705;
        }
        j = c.readInt(arrayOfByte, 0);
        l1 = j * 4L;
        if ((l1 <= 0L) || (l1 > i - 20))
        {
          ad.w("MicroMsg.StblAtom", "stco error entryCount : ".concat(String.valueOf(j)));
          l1 = -1L;
          break label705;
        }
        paramn.hYd = l1;
        paramn.bdD = new int[j + 1];
        paramn.hYh = new byte[paramn.bdD.length * 4];
        paramn.hYc = paramRandomAccessFile.getFilePointer();
        l1 = paramRandomAccessFile.read(paramn.hYh);
        ad.i("MicroMsg.StblAtom", "handleStszAtomLazy start parse stsz filePos:%s, sampleSizeReaded:%s, sampleSizeTableData.length:%s", new Object[] { Long.valueOf(paramn.hYc), Long.valueOf(l1), Integer.valueOf(paramn.hYh.length) });
        paramn.a(paramRandomAccessFile, 0, 5);
        l1 += 12L;
        break label705;
      }
    }
    AppMethodBeat.o(175943);
    return new long[0];
  }
  
  private void aGQ()
  {
    AppMethodBeat.i(133880);
    ad.i("MicroMsg.Mp4Parser2", "timeTableLength, length:%s", new Object[] { Integer.valueOf(this.hXw) });
    this.hXv = new long[this.hXw + 2];
    Iterator localIterator = this.hXC.iterator();
    while (localIterator.hasNext())
    {
      long[] arrayOfLong1 = (long[])localIterator.next();
      int i = 0;
      while (i < arrayOfLong1.length)
      {
        long[] arrayOfLong2 = this.hXv;
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
    Object localObject1 = k.hXN;
    k.eN(this.hXI);
    long l3;
    long l1;
    long l2;
    int j;
    int k;
    f localf;
    for (;;)
    {
      int i;
      try
      {
        localObject1 = new byte[8];
        ad.i("MicroMsg.Mp4Parser2", "parserExtractor");
        l3 = bt.GC();
        localObject2 = c.a(paramRandomAccessFile, (byte[])localObject1, a.bai);
        ad.d("MicroMsg.Mp4Parser2", "find moov atom finish, cost:%s, beginPos:%s, size:%s", new Object[] { Long.valueOf(bt.aS(l3)), Long.valueOf(((a)localObject2).hWV), Long.valueOf(((a)localObject2).getSize()) });
        l1 = ((a)localObject2).hWV;
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
          ad.i("MicroMsg.Mp4Parser2", "read atomSize:%s, atomType:%s", new Object[] { Integer.valueOf(j), Integer.valueOf(k) });
          if (k != a.bak) {
            break label1089;
          }
          localObject2 = (o)h.d(j, k, l1);
          localf = o.b(paramRandomAccessFile, (byte[])localObject1);
          ad.i("MicroMsg.Mp4Parser2", "found track atom, mdiaAtom:%s, trakAtom:%s", new Object[] { localf, localObject2 });
          if ((localf == null) || (!localf.a(paramRandomAccessFile, (byte[])localObject1))) {
            break label1089;
          }
          if (localf.hXt != f.hXp) {
            break label783;
          }
          this.hXs = localf.hXs;
          this.duration = localf.duration;
          ad.i("MicroMsg.Mp4Parser2", "this trak atom is video trak. timeScale: " + this.hXs + " duration: " + this.duration);
          this.hXE = localf.hXu;
          if (this.hXI)
          {
            long l4 = this.hXE;
            long l5 = bt.GC();
            ad.i("MicroMsg.Mp4Parser2", "findStblAtomInfo, minfFilePos:%s", new Object[] { Long.valueOf(l4) });
            paramRandomAccessFile.seek(l4);
            localObject2 = (n)c.a(paramRandomAccessFile, (byte[])localObject1, a.ban);
            ad.i("MicroMsg.Mp4Parser2", "findStblAtomInfo, stblAtom:%s, duration:%s, timeScale:%s, cost:%s", new Object[] { localObject2, Long.valueOf(this.duration), Long.valueOf(this.hXs), Long.valueOf(bt.aS(l5)) });
            this.hXF = ((n)localObject2);
            this.hXv = a(paramRandomAccessFile, this.hXF);
            this.hXI = this.hXF.hYe;
            this.hXK.add(new Pair(Integer.valueOf(0), Integer.valueOf(5)));
            this.hXJ = ((Integer)((Pair)this.hXK.get(this.hXK.size() - 1)).second).intValue();
            this.hXw = (this.hXv.length - 2);
            ad.i("MicroMsg.Mp4Parser2", "lazy parse finish, isLazyParse:%s", new Object[] { Boolean.valueOf(this.hXI) });
            i = 1;
            if (this.hXw <= 30) {
              break label765;
            }
            ad.i("MicroMsg.Mp4Parser2", "current timeTableLength is:%s too long, ignore parse other track", new Object[] { Integer.valueOf(this.hXw) });
          }
        }
        else
        {
          label593:
          if (this.hXI) {
            break label1049;
          }
          ad.i("MicroMsg.Mp4Parser2", "parse finish, start merge time table, cost:%s", new Object[] { Long.valueOf(bt.aS(l3)) });
          aGQ();
          l1 = bt.aS(l3);
          label634:
          ad.i("MicroMsg.Mp4Parser2", "parseExtractor finish, totalCost:%sms, isLazyParse:%s", new Object[] { Long.valueOf(l1), Boolean.valueOf(this.hXI) });
          paramRandomAccessFile = k.hXN;
          k.a(this.hXI, l1, this.hXw);
          AppMethodBeat.o(133881);
          return true;
        }
        localObject2 = a(paramRandomAccessFile, localf.hXu, (byte[])localObject1, true);
        ad.i("MicroMsg.Mp4Parser2", "createTimeTable finish");
        this.hXC.add(localObject2);
        this.hXw = Math.max(this.hXw, localObject2.length - 2);
        continue;
        if (!this.hXI) {
          break label968;
        }
      }
      catch (Exception paramRandomAccessFile)
      {
        ad.printErrStackTrace("MicroMsg.Mp4Parser2", paramRandomAccessFile, "parser mp4 error", new Object[0]);
        AppMethodBeat.o(133881);
        return false;
      }
      label765:
      ad.i("MicroMsg.Mp4Parser2", "lazy parse, ignore other trak atom");
      continue;
      label783:
      if (localf.hXt != f.hXq) {
        break label1038;
      }
      if ((this.hXI) && (i != 0))
      {
        ad.i("MicroMsg.Mp4Parser2", "lazy parse, ignore sound trak atom");
      }
      else
      {
        if (this.hXw <= 30) {
          break;
        }
        ad.i("MicroMsg.Mp4Parser2", "current timeTableLength is:%s too long, ignore parse sound track", new Object[] { Integer.valueOf(this.hXw) });
      }
    }
    this.hXs = localf.hXs;
    this.duration = localf.duration;
    ad.i("MicroMsg.Mp4Parser2", "this trak atom is sound trak. timeScale: " + this.hXs + " duration: " + this.duration);
    this.hXG = localf.hXu;
    Object localObject2 = a(paramRandomAccessFile, localf.hXu, (byte[])localObject1, false);
    ad.i("MicroMsg.Mp4Parser2", "createTimeTable finish");
    this.hXC.add(localObject2);
    this.hXw = Math.max(this.hXw, localObject2.length - 2);
    label1038:
    label1049:
    label1089:
    for (;;)
    {
      label968:
      l2 -= j;
      l1 += j;
      ad.d("MicroMsg.Mp4Parser2", "atomSize:%s, atomType:%s, remains:%s, beginPos:%s, timeTableLength:%s", new Object[] { Integer.valueOf(j), Integer.valueOf(k), Long.valueOf(l2), Long.valueOf(l1), Integer.valueOf(this.hXw) });
      break;
      ad.i("MicroMsg.Mp4Parser2", "unknown mdiaAtom");
      break label593;
      l1 = bt.aS(l3);
      ad.i("MicroMsg.Mp4Parser2", "lazy parse finish, cost:%s, timeTableLength:%s", new Object[] { Long.valueOf(l1), Integer.valueOf(this.hXw) });
      break label634;
    }
  }
  
  private Pair<Integer, Integer> pN(int paramInt)
  {
    AppMethodBeat.i(175940);
    Pair localPair1;
    if (this.hXK.size() > 0)
    {
      localPair1 = new Pair(Integer.valueOf(Math.max(paramInt - 1, 1)), Integer.valueOf(Math.min(paramInt + 5, this.hXv.length - 1)));
      Iterator localIterator = this.hXK.iterator();
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
            localPair1 = new Pair(Integer.valueOf(Math.min(((Integer)localPair2.second).intValue() + 1, this.hXv.length - 1)), localPair1.second);
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
  
  private void pO(int paramInt)
  {
    AppMethodBeat.i(175941);
    if (this.hXF != null)
    {
      long l2 = bt.GC();
      ad.i("MicroMsg.Mp4Parser2", "checkUpdateLazyParseTimeTable currentLazyParseSeconds:%s, second:%s", new Object[] { Integer.valueOf(this.hXJ), Integer.valueOf(paramInt) });
      Object localObject = pN(paramInt);
      ad.i("MicroMsg.Mp4Parser2", "calcLazyParseRange cost:%sms", new Object[] { Long.valueOf(bt.aS(l2)) });
      if (localObject != null)
      {
        ad.i("MicroMsg.Mp4Parser2", "checkUpdateLazyParseTimeTable, newParseRange:[%s, %s]", new Object[] { ((Pair)localObject).first, ((Pair)localObject).second });
        boolean bool = this.hXF.b(this.randomAccessFile, ((Integer)((Pair)localObject).first).intValue(), ((Integer)((Pair)localObject).second).intValue());
        this.hXv = this.hXF.hXv;
        this.hXx = this.hXF.hXx;
        this.hXy = this.hXF.hXy;
        this.hXD = this.hXF.hXD;
        this.hXK.add(localObject);
        long l1 = bt.GC();
        Collections.sort(this.hXK, this.hXL);
        this.hXJ = ((Integer)((Pair)this.hXK.get(this.hXK.size() - 1)).second).intValue();
        l2 = bt.aS(l2);
        ad.i("MicroMsg.Mp4Parser2", "checkUpdateLazyParseTimeTable incrementCreateTimeTable finish, ret:%s, cost:%sms, sort cost:%s, range:[%s, %s]", new Object[] { Boolean.valueOf(bool), Long.valueOf(l2), Long.valueOf(bt.aS(l1)), ((Pair)localObject).first, ((Pair)localObject).second });
        localObject = k.hXN;
        k.mM(l2);
      }
    }
    AppMethodBeat.o(175941);
  }
  
  private void reset()
  {
    AppMethodBeat.i(133874);
    this.filePath = null;
    this.hXv = null;
    this.hXC.clear();
    this.hXw = 0;
    this.duration = 0L;
    this.hXs = 0L;
    if (this.hXx != null) {
      this.hXx.clear();
    }
    if (this.hXy != null) {
      this.hXy.clear();
    }
    if (this.hXK != null) {
      this.hXK.clear();
    }
    this.hXD = null;
    this.hXB = 0;
    AppMethodBeat.o(133874);
  }
  
  public final boolean E(String paramString, long paramLong)
  {
    AppMethodBeat.i(204036);
    reset();
    this.filePath = paramString;
    if (!new e(this.filePath).exists())
    {
      AppMethodBeat.o(204036);
      return false;
    }
    try
    {
      this.randomAccessFile = i.cS(this.filePath, false);
      boolean bool = e(this.randomAccessFile);
      AppMethodBeat.o(204036);
      return bool;
    }
    catch (Exception paramString)
    {
      AppMethodBeat.o(204036);
    }
    return false;
  }
  
  public final boolean a(int paramInt1, int paramInt2, PInt paramPInt1, PInt paramPInt2)
  {
    AppMethodBeat.i(133877);
    ad.i("MicroMsg.Mp4Parser2", "[before] curPlaySecond %d, cacheSecond %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (this.hXv == null)
    {
      AppMethodBeat.o(133877);
      return false;
    }
    long l1 = bt.GC();
    int i = paramInt1;
    if (paramInt1 < 0) {
      i = 0;
    }
    int j = this.hXv.length;
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
    if (this.hXI) {}
    try
    {
      pO(Math.max(i, paramInt1));
      l2 = this.hXv[i];
      l3 = this.hXv[paramInt1];
      ad.d("MicroMsg.Mp4Parser2", "curPos %d, cachePos %d", new Object[] { Long.valueOf(l2), Long.valueOf(l3) });
      if ((l2 < 0L) || (l3 < 0L)) {
        ad.e("MicroMsg.Mp4Parser2", "videoTimeToFilePos error, not parse this entry now");
      }
      if (i == 0)
      {
        paramPInt1.value = 0;
        paramPInt2.value = ((int)l3);
        ad.i("MicroMsg.Mp4Parser2", "[after] curPlaySecond %d, cacheSecond %d, offset.value %d, length.value %d, cost %sms", new Object[] { Integer.valueOf(i), Integer.valueOf(paramInt1), Integer.valueOf(paramPInt1.value), Integer.valueOf(paramPInt2.value), Long.valueOf(bt.aS(l1)) });
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
        ad.printErrStackTrace("MicroMsg.Mp4Parser2", localException, "videoTimeToFilePos, checkUpdateLazyParseTimeTable error", new Object[0]);
        continue;
        paramPInt1.value = ((int)l2);
        paramPInt2.value = ((int)l3 - (int)l2);
      }
    }
  }
  
  public final int aGP()
  {
    AppMethodBeat.i(133875);
    for (;;)
    {
      try
      {
        if (this.hXI) {
          continue;
        }
        if (this.hXy == null) {
          continue;
        }
        if (this.hXB == 0) {
          this.hXB = ((int)(((Long)((Pair)this.hXy.get(this.hXy.size() - 1)).second).longValue() / 1000L / 1000L));
        }
        i = this.hXB;
      }
      catch (Exception localException)
      {
        Pair localPair;
        ad.printErrStackTrace("MicroMsg.Mp4Parser2", localException, "get last key frame error.", new Object[0]);
        int i = 0;
        continue;
      }
      AppMethodBeat.o(133875);
      return i;
      i = 0;
      continue;
      if ((this.hXD != null) && (this.hXD.length > 0))
      {
        if (this.hXD[(this.hXD.length - 1)] == null) {
          pO(this.hXv.length - 1);
        }
        localPair = this.hXD[(this.hXD.length - 1)];
        if ((localPair != null) && (this.hXB == 0)) {
          this.hXB = ((int)(((Long)localPair.second).longValue() / 1000L / 1000L));
        }
        i = this.hXB;
      }
      else
      {
        i = 0;
      }
    }
  }
  
  public final int aGR()
  {
    return this.hXw;
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
        if (this.hXI) {
          continue;
        }
        if ((this.hXy == null) || (this.hXy.size() <= 0)) {
          continue;
        }
        j = this.hXy.size();
        l = paramInt;
        paramPInt2.value = 0;
        paramPInt1.value = 0;
        i = 0;
        if (i >= j) {
          continue;
        }
        localPair = (Pair)this.hXy.get(i);
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
        ad.printErrStackTrace("MicroMsg.Mp4Parser2", localException1, "seekVFrame seekTime[%d]", new Object[] { Integer.valueOf(paramInt) });
        continue;
        ad.i("MicroMsg.Mp4Parser2", "lazy parse seek key Frame seekTime[%d] pre[%d] next[%d], find:%s, fromLastFrame:%s, stssList.size:%s, stssArray.length:%s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(paramPInt1.value), Integer.valueOf(paramPInt2.value), Boolean.valueOf(bool2), Boolean.valueOf(bool3), Integer.valueOf(this.hXy.size()), Integer.valueOf(this.hXD.length) });
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
        paramPInt1.value = ((int)(((Long)((Pair)this.hXy.get(j - 1)).second).longValue() / 1000L / 1000L));
        bool2 = bool1;
        paramPInt2.value = paramInt;
        bool1 = true;
        bool2 = true;
        bool3 = bool2;
        bool2 = bool1;
        if (this.hXI) {
          continue;
        }
        ad.i("MicroMsg.Mp4Parser2", "seek key Frame seekTime[%d] pre[%d] next[%d], stssList.size:%s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(paramPInt1.value), Integer.valueOf(paramPInt2.value), Integer.valueOf(this.hXy.size()) });
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
    if ((this.hXD != null) && (this.hXD.length > 0))
    {
      pO(paramInt);
      pO(this.hXv.length);
      j = this.hXD.length;
      l = paramInt;
      paramPInt2.value = 0;
      paramPInt1.value = 0;
      i = 0;
      for (;;)
      {
        if (i >= j) {
          break label695;
        }
        localPair = this.hXD[i];
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
            localPair = this.hXD[(j - 1)];
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
  
  public final int dw(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(175942);
    if (this.hXv == null)
    {
      AppMethodBeat.o(175942);
      return 0;
    }
    long l1 = bt.GC();
    long l2 = paramInt1 + paramInt2;
    int j = 0;
    int k = this.hXv.length;
    int i;
    if (this.hXI)
    {
      if (this.hXJ >= this.hXv.length) {
        break label205;
      }
      i = this.hXJ;
    }
    int m;
    for (;;)
    {
      ad.i("MicroMsg.Mp4Parser2", "filePosToVideoTime lazy parse try search from time table, count:%s", new Object[] { Integer.valueOf(i) });
      try
      {
        pO(i);
        k = i;
        i = 0;
        m = j;
        if (i < k) {
          if ((!this.hXI) || (this.hXv[i] >= 0L)) {}
        }
      }
      catch (Exception localException1)
      {
        try
        {
          pO(i);
          if (this.hXv[i] == l2)
          {
            m = i;
            label143:
            ad.i("MicroMsg.Mp4Parser2", "filePosToVideoTime, offset:%s, length:%s, filePos:%s, playtime:%s, cost:%sms", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Long.valueOf(l2), Integer.valueOf(m), Long.valueOf(bt.aS(l1)) });
            AppMethodBeat.o(175942);
            return m;
            label205:
            i = this.hXv.length;
            continue;
            localException1 = localException1;
            ad.printErrStackTrace("MicroMsg.Mp4Parser2", localException1, "", new Object[0]);
            k = i;
          }
        }
        catch (Exception localException2)
        {
          for (;;)
          {
            ad.printErrStackTrace("MicroMsg.Mp4Parser2", localException2, "", new Object[0]);
          }
        }
      }
    }
    if (this.hXv[i] < l2) {
      j = i;
    }
    for (;;)
    {
      i += 1;
      break;
      m = j;
      if (this.hXv[i] > l2) {
        break label143;
      }
    }
  }
  
  public void fQP()
  {
    AppMethodBeat.i(204035);
    if (((b)g.ab(b.class)).a(b.a.pwx, 0) == 1)
    {
      ad.i("MicroMsg.Mp4Parser2", "config to use lazy parse");
      this.hXI = true;
      AppMethodBeat.o(204035);
      return;
    }
    ad.i("MicroMsg.Mp4Parser2", "not use lazy parse");
    this.hXI = false;
    AppMethodBeat.o(204035);
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
    //   9: getfield 564	com/tencent/mm/plugin/a/j:randomAccessFile	Ljava/io/RandomAccessFile;
    //   12: astore_1
    //   13: aload_1
    //   14: ifnull +110 -> 124
    //   17: ldc 100
    //   19: ldc_w 676
    //   22: iconst_0
    //   23: anewarray 4	java/lang/Object
    //   26: invokestatic 679	com/tencent/mm/sdk/platformtools/ad:m	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   29: aload_0
    //   30: getfield 564	com/tencent/mm/plugin/a/j:randomAccessFile	Ljava/io/RandomAccessFile;
    //   33: invokevirtual 682	java/io/RandomAccessFile:close	()V
    //   36: aload_0
    //   37: aconst_null
    //   38: putfield 564	com/tencent/mm/plugin/a/j:randomAccessFile	Ljava/io/RandomAccessFile;
    //   41: aload_0
    //   42: iconst_0
    //   43: putfield 71	com/tencent/mm/plugin/a/j:hXJ	I
    //   46: aload_0
    //   47: getfield 73	com/tencent/mm/plugin/a/j:hXK	Ljava/util/ArrayList;
    //   50: invokevirtual 582	java/util/ArrayList:clear	()V
    //   53: aload_0
    //   54: aconst_null
    //   55: putfield 63	com/tencent/mm/plugin/a/j:hXF	Lcom/tencent/mm/plugin/a/n;
    //   58: aload_0
    //   59: aconst_null
    //   60: putfield 67	com/tencent/mm/plugin/a/j:hXH	Lcom/tencent/mm/plugin/a/n;
    //   63: aload_0
    //   64: aconst_null
    //   65: putfield 564	com/tencent/mm/plugin/a/j:randomAccessFile	Ljava/io/RandomAccessFile;
    //   68: ldc_w 674
    //   71: invokestatic 88	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   74: aload_0
    //   75: monitorexit
    //   76: return
    //   77: astore_1
    //   78: ldc 100
    //   80: aload_1
    //   81: ldc_w 650
    //   84: iconst_0
    //   85: anewarray 4	java/lang/Object
    //   88: invokestatic 520	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   91: aload_0
    //   92: aconst_null
    //   93: putfield 564	com/tencent/mm/plugin/a/j:randomAccessFile	Ljava/io/RandomAccessFile;
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
    //   113: putfield 564	com/tencent/mm/plugin/a/j:randomAccessFile	Ljava/io/RandomAccessFile;
    //   116: ldc_w 674
    //   119: invokestatic 88	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   122: aload_1
    //   123: athrow
    //   124: ldc_w 674
    //   127: invokestatic 88	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   130: goto -56 -> 74
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	133	0	this	j
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.a.j
 * JD-Core Version:    0.7.0.1
 */