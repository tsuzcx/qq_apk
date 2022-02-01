package com.tencent.mm.plugin.a;

import android.annotation.TargetApi;
import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.a.b;
import com.tencent.mm.plugin.expt.a.b.a;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.vfs.e;
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
  private int ixA;
  private List<n> ixB;
  private List<Pair> ixC;
  public int ixF;
  private List<long[]> ixG;
  private Pair[] ixH;
  private long ixI;
  private o ixJ;
  private long ixK;
  private o ixL;
  protected boolean ixM;
  private int ixN;
  private ArrayList<Pair<Integer, Integer>> ixO;
  private Comparator<Pair<Integer, Integer>> ixP;
  private long ixw;
  private long[] ixz;
  private RandomAccessFile randomAccessFile;
  
  public k()
  {
    AppMethodBeat.i(133873);
    this.ixG = new ArrayList();
    this.ixI = -1L;
    this.ixJ = null;
    this.ixK = -1L;
    this.ixL = null;
    this.ixM = false;
    this.ixN = 0;
    this.ixO = new ArrayList();
    this.ixP = new k.1(this);
    this.ixF = 0;
    aNE();
    AppMethodBeat.o(133873);
  }
  
  private long[] a(RandomAccessFile paramRandomAccessFile, long paramLong, byte[] paramArrayOfByte, boolean paramBoolean)
  {
    AppMethodBeat.i(133879);
    long l = bs.Gn();
    ac.i("MicroMsg.Mp4Parser2", "createTimeTable, minfFilePos:%s, isVideo:%s", new Object[] { Long.valueOf(paramLong), Boolean.valueOf(paramBoolean) });
    paramRandomAccessFile.seek(paramLong);
    paramArrayOfByte = (o)c.a(paramRandomAccessFile, paramArrayOfByte, a.baZ);
    ac.i("MicroMsg.Mp4Parser2", "createTimeTable, stblAtom:%s, duration:%s, timeScale:%s", new Object[] { paramArrayOfByte, Long.valueOf(this.duration), Long.valueOf(this.ixw) });
    if (paramArrayOfByte != null)
    {
      paramArrayOfByte.duration = this.duration;
      paramArrayOfByte.ixw = this.ixw;
      paramArrayOfByte.f(paramRandomAccessFile);
      paramRandomAccessFile = paramArrayOfByte.ixz;
      if (paramBoolean)
      {
        this.ixB = paramArrayOfByte.ixB;
        this.ixC = paramArrayOfByte.ixC;
      }
      if ((this.ixB != null) && (this.ixC != null)) {
        ac.d("MicroMsg.Mp4Parser2", "parser stbl atom finish, sampleList:%s, stssList:%s", new Object[] { Integer.valueOf(this.ixB.size()), Integer.valueOf(this.ixC.size()) });
      }
      if (paramRandomAccessFile != null) {
        ac.i("MicroMsg.Mp4Parser2", "createTimeTable cost:%s, length:%s", new Object[] { Long.valueOf(bs.aO(l)), Integer.valueOf(paramRandomAccessFile.length) });
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
    long l3 = bs.Gn();
    ac.i("MicroMsg.Mp4Parser2", "createTimeTable, stblAtom:%s, duration:%s, timeScale:%s", new Object[] { paramo, Long.valueOf(this.duration), Long.valueOf(this.ixw) });
    if (paramo != null)
    {
      paramo.duration = this.duration;
      paramo.ixw = this.ixw;
      long l1 = paramo.getSize();
      byte[] arrayOfByte = new byte[8];
      int j = 0;
      int m = 0;
      int k = 0;
      int n = 0;
      int i1 = 0;
      long l4 = bs.Gn();
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
        ac.i("MicroMsg.StblAtom", "readAtom, type:%s, size:%s", new Object[] { Integer.valueOf(i7), Integer.valueOf(i6) });
        l1 = 0L;
        long l5 = bs.Gn();
        if (i7 == a.bbF)
        {
          paramo.ixU = paramRandomAccessFile.getFilePointer();
          l1 = paramo.a(paramRandomAccessFile, i6);
          ac.i("MicroMsg.StblAtom", "handleSttsAtom cost:%sms", new Object[] { Long.valueOf(bs.aO(l5)) });
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
          if (i7 == a.bbI)
          {
            paramo.ixV = paramRandomAccessFile.getFilePointer();
            l1 = paramo.b(paramRandomAccessFile, i6);
            ac.i("MicroMsg.StblAtom", "handleStscAtom cost:%sms", new Object[] { Long.valueOf(bs.aO(l5)) });
            i3 = 1;
            i2 = n;
            i = m;
            i4 = j;
          }
          else if (i7 == a.bbL)
          {
            paramo.ixW = paramRandomAccessFile.getFilePointer();
            l1 = paramo.c(paramRandomAccessFile, i6);
            ac.i("MicroMsg.StblAtom", "handleStcoAtom cost:%sms", new Object[] { Long.valueOf(bs.aO(l5)) });
            i = 1;
            i2 = n;
            i3 = k;
            i4 = j;
          }
          else if (i7 == a.bbM)
          {
            paramo.ixX = paramRandomAccessFile.getFilePointer();
            l1 = paramo.d(paramRandomAccessFile, i6);
            ac.i("MicroMsg.StblAtom", "handleCo64Atom cost:%sms", new Object[] { Long.valueOf(bs.aO(l5)) });
            i = 1;
            i2 = n;
            i3 = k;
            i4 = j;
          }
          else if (i7 == a.bbJ)
          {
            paramo.ixY = paramRandomAccessFile.getFilePointer();
            paramo.iya = i6;
            ac.i("MicroMsg.StblAtom", "stsz atom pos:%s", new Object[] { Long.valueOf(paramo.ixY) });
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
              paramo.ixZ = paramRandomAccessFile.getFilePointer();
              l1 = paramo.f(paramRandomAccessFile, i6);
              ac.i("MicroMsg.StblAtom", "handleStssAtom cost:%sms", new Object[] { Long.valueOf(bs.aO(l5)) });
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
        paramo.iyi = true;
        if (paramo.ixY > 0L)
        {
          l2 = bs.Gn();
          paramRandomAccessFile.seek(paramo.ixY);
          i = paramo.iya;
          if (c.a(paramRandomAccessFile, 4L)) {
            break label1070;
          }
          l1 = -1L;
          label705:
          ac.i("MicroMsg.StblAtom", "handleStszAtom cost:%sms, ret:%s, sampleSizeTable.length:%s", new Object[] { Long.valueOf(bs.aO(l2)), Long.valueOf(l1), Integer.valueOf(paramo.bep.length) });
          if (paramo.iyc != null) {
            break label1350;
          }
        }
      }
      label1070:
      label1350:
      for (paramo.ixH = new Pair[paramo.ixB.size()];; paramo.ixH = new Pair[paramo.iyc.length])
      {
        ac.i("MicroMsg.StblAtom", "parse lazy, stssArray.size:%s", new Object[] { Integer.valueOf(paramo.ixH.length) });
        l1 = bs.Gn();
        paramo.b(paramRandomAccessFile, 0, 5);
        paramo.iyf = 5L;
        ac.i("MicroMsg.StblAtom", "createTimeTable cost:%sms, size:%s, lazyDurationSecond:%s", new Object[] { Long.valueOf(bs.aO(l1)), Integer.valueOf(paramo.ixz.length), Integer.valueOf(5) });
        if (5 >= paramo.ixz.length)
        {
          paramo.iyi = false;
          ac.i("MicroMsg.StblAtom", "lazyDurationSecond:%s, timeTable.length:%s, not need lazy", new Object[] { Integer.valueOf(5), Integer.valueOf(paramo.ixz.length) });
        }
        ac.i("MicroMsg.StblAtom", "lazy parse finish cost:%sms", new Object[] { Long.valueOf(bs.aO(l4)) });
        paramRandomAccessFile = paramo.ixz;
        this.ixB = paramo.ixB;
        this.ixC = paramo.ixC;
        this.ixH = paramo.ixH;
        if ((this.ixB != null) && (this.ixH != null)) {
          ac.d("MicroMsg.Mp4Parser2", "parser stbl atom lazy finish, sampleList.size:%s, stssArray.length:%s", new Object[] { Integer.valueOf(this.ixB.size()), Integer.valueOf(this.ixH.length) });
        }
        if (paramRandomAccessFile != null) {
          ac.i("MicroMsg.Mp4Parser2", "createTimeTableLazy cost:%s, length:%s", new Object[] { Long.valueOf(bs.aO(l3)), Integer.valueOf(paramRandomAccessFile.length) });
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
          ac.w("MicroMsg.StblAtom", "stsz read sample size error");
          l1 = -1L;
          break label705;
        }
        j = c.readInt(arrayOfByte, 0);
        if (j > 0)
        {
          paramo.bep = new int[1];
          paramo.bep[0] = j;
          ac.i("MicroMsg.StblAtom", "all sample size is the same. size : ".concat(String.valueOf(j)));
          l1 = 8L;
          break label705;
        }
        if (paramRandomAccessFile.read(arrayOfByte, 0, 4) < 4)
        {
          ac.w("MicroMsg.StblAtom", "stsz read entry count error");
          l1 = -1L;
          break label705;
        }
        j = c.readInt(arrayOfByte, 0);
        l1 = j * 4L;
        if ((l1 <= 0L) || (l1 > i - 20))
        {
          ac.w("MicroMsg.StblAtom", "stco error entryCount : ".concat(String.valueOf(j)));
          l1 = -1L;
          break label705;
        }
        paramo.iyh = l1;
        paramo.bep = new int[j + 1];
        paramo.iyl = new byte[paramo.bep.length * 4];
        paramo.iyg = paramRandomAccessFile.getFilePointer();
        l1 = paramRandomAccessFile.read(paramo.iyl);
        ac.i("MicroMsg.StblAtom", "handleStszAtomLazy start parse stsz filePos:%s, sampleSizeReaded:%s, sampleSizeTableData.length:%s", new Object[] { Long.valueOf(paramo.iyg), Long.valueOf(l1), Integer.valueOf(paramo.iyl.length) });
        paramo.a(paramRandomAccessFile, 0, 5);
        l1 += 12L;
        break label705;
      }
    }
    AppMethodBeat.o(175943);
    return new long[0];
  }
  
  private void aNF()
  {
    AppMethodBeat.i(133880);
    ac.i("MicroMsg.Mp4Parser2", "timeTableLength, length:%s", new Object[] { Integer.valueOf(this.ixA) });
    this.ixz = new long[this.ixA + 2];
    Iterator localIterator = this.ixG.iterator();
    while (localIterator.hasNext())
    {
      long[] arrayOfLong1 = (long[])localIterator.next();
      int i = 0;
      while (i < arrayOfLong1.length)
      {
        long[] arrayOfLong2 = this.ixz;
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
    Object localObject1 = l.ixR;
    l.fh(this.ixM);
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
        ac.i("MicroMsg.Mp4Parser2", "parserExtractor");
        l3 = bs.Gn();
        localObject2 = c.a(paramRandomAccessFile, (byte[])localObject1, a.baU);
        ac.d("MicroMsg.Mp4Parser2", "find moov atom finish, cost:%s, beginPos:%s, size:%s", new Object[] { Long.valueOf(bs.aO(l3)), Long.valueOf(((a)localObject2).iwZ), Long.valueOf(((a)localObject2).getSize()) });
        l1 = ((a)localObject2).iwZ;
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
          ac.i("MicroMsg.Mp4Parser2", "read atomSize:%s, atomType:%s", new Object[] { Integer.valueOf(j), Integer.valueOf(k) });
          if (k != a.baW) {
            break label1089;
          }
          localObject2 = (p)i.d(j, k, l1);
          localg = p.b(paramRandomAccessFile, (byte[])localObject1);
          ac.i("MicroMsg.Mp4Parser2", "found track atom, mdiaAtom:%s, trakAtom:%s", new Object[] { localg, localObject2 });
          if ((localg == null) || (!localg.a(paramRandomAccessFile, (byte[])localObject1))) {
            break label1089;
          }
          if (localg.ixx != g.ixt) {
            break label783;
          }
          this.ixw = localg.ixw;
          this.duration = localg.duration;
          ac.i("MicroMsg.Mp4Parser2", "this trak atom is video trak. timeScale: " + this.ixw + " duration: " + this.duration);
          this.ixI = localg.ixy;
          if (this.ixM)
          {
            long l4 = this.ixI;
            long l5 = bs.Gn();
            ac.i("MicroMsg.Mp4Parser2", "findStblAtomInfo, minfFilePos:%s", new Object[] { Long.valueOf(l4) });
            paramRandomAccessFile.seek(l4);
            localObject2 = (o)c.a(paramRandomAccessFile, (byte[])localObject1, a.baZ);
            ac.i("MicroMsg.Mp4Parser2", "findStblAtomInfo, stblAtom:%s, duration:%s, timeScale:%s, cost:%s", new Object[] { localObject2, Long.valueOf(this.duration), Long.valueOf(this.ixw), Long.valueOf(bs.aO(l5)) });
            this.ixJ = ((o)localObject2);
            this.ixz = a(paramRandomAccessFile, this.ixJ);
            this.ixM = this.ixJ.iyi;
            this.ixO.add(new Pair(Integer.valueOf(0), Integer.valueOf(5)));
            this.ixN = ((Integer)((Pair)this.ixO.get(this.ixO.size() - 1)).second).intValue();
            this.ixA = (this.ixz.length - 2);
            ac.i("MicroMsg.Mp4Parser2", "lazy parse finish, isLazyParse:%s", new Object[] { Boolean.valueOf(this.ixM) });
            i = 1;
            if (this.ixA <= 30) {
              break label765;
            }
            ac.i("MicroMsg.Mp4Parser2", "current timeTableLength is:%s too long, ignore parse other track", new Object[] { Integer.valueOf(this.ixA) });
          }
        }
        else
        {
          label593:
          if (this.ixM) {
            break label1049;
          }
          ac.i("MicroMsg.Mp4Parser2", "parse finish, start merge time table, cost:%s", new Object[] { Long.valueOf(bs.aO(l3)) });
          aNF();
          l1 = bs.aO(l3);
          label634:
          ac.i("MicroMsg.Mp4Parser2", "parseExtractor finish, totalCost:%sms, isLazyParse:%s", new Object[] { Long.valueOf(l1), Boolean.valueOf(this.ixM) });
          paramRandomAccessFile = l.ixR;
          l.a(this.ixM, l1, this.ixA);
          AppMethodBeat.o(133881);
          return true;
        }
        localObject2 = a(paramRandomAccessFile, localg.ixy, (byte[])localObject1, true);
        ac.i("MicroMsg.Mp4Parser2", "createTimeTable finish");
        this.ixG.add(localObject2);
        this.ixA = Math.max(this.ixA, localObject2.length - 2);
        continue;
        if (!this.ixM) {
          break label968;
        }
      }
      catch (Exception paramRandomAccessFile)
      {
        ac.printErrStackTrace("MicroMsg.Mp4Parser2", paramRandomAccessFile, "parser mp4 error", new Object[0]);
        AppMethodBeat.o(133881);
        return false;
      }
      label765:
      ac.i("MicroMsg.Mp4Parser2", "lazy parse, ignore other trak atom");
      continue;
      label783:
      if (localg.ixx != g.ixu) {
        break label1038;
      }
      if ((this.ixM) && (i != 0))
      {
        ac.i("MicroMsg.Mp4Parser2", "lazy parse, ignore sound trak atom");
      }
      else
      {
        if (this.ixA <= 30) {
          break;
        }
        ac.i("MicroMsg.Mp4Parser2", "current timeTableLength is:%s too long, ignore parse sound track", new Object[] { Integer.valueOf(this.ixA) });
      }
    }
    this.ixw = localg.ixw;
    this.duration = localg.duration;
    ac.i("MicroMsg.Mp4Parser2", "this trak atom is sound trak. timeScale: " + this.ixw + " duration: " + this.duration);
    this.ixK = localg.ixy;
    Object localObject2 = a(paramRandomAccessFile, localg.ixy, (byte[])localObject1, false);
    ac.i("MicroMsg.Mp4Parser2", "createTimeTable finish");
    this.ixG.add(localObject2);
    this.ixA = Math.max(this.ixA, localObject2.length - 2);
    label1038:
    label1049:
    label1089:
    for (;;)
    {
      label968:
      l2 -= j;
      l1 += j;
      ac.d("MicroMsg.Mp4Parser2", "atomSize:%s, atomType:%s, remains:%s, beginPos:%s, timeTableLength:%s", new Object[] { Integer.valueOf(j), Integer.valueOf(k), Long.valueOf(l2), Long.valueOf(l1), Integer.valueOf(this.ixA) });
      break;
      ac.i("MicroMsg.Mp4Parser2", "unknown mdiaAtom");
      break label593;
      l1 = bs.aO(l3);
      ac.i("MicroMsg.Mp4Parser2", "lazy parse finish, cost:%s, timeTableLength:%s", new Object[] { Long.valueOf(l1), Integer.valueOf(this.ixA) });
      break label634;
    }
  }
  
  private Pair<Integer, Integer> qA(int paramInt)
  {
    AppMethodBeat.i(175940);
    Pair localPair1;
    if (this.ixO.size() > 0)
    {
      localPair1 = new Pair(Integer.valueOf(Math.max(paramInt - 1, 1)), Integer.valueOf(Math.min(paramInt + 5, this.ixz.length - 1)));
      Iterator localIterator = this.ixO.iterator();
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
            localPair1 = new Pair(Integer.valueOf(Math.min(((Integer)localPair2.second).intValue() + 1, this.ixz.length - 1)), localPair1.second);
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
  
  private void qB(int paramInt)
  {
    AppMethodBeat.i(175941);
    if (this.ixJ != null)
    {
      long l2 = bs.Gn();
      ac.i("MicroMsg.Mp4Parser2", "checkUpdateLazyParseTimeTable currentLazyParseSeconds:%s, second:%s", new Object[] { Integer.valueOf(this.ixN), Integer.valueOf(paramInt) });
      Object localObject = qA(paramInt);
      ac.i("MicroMsg.Mp4Parser2", "calcLazyParseRange cost:%sms", new Object[] { Long.valueOf(bs.aO(l2)) });
      if (localObject != null)
      {
        ac.i("MicroMsg.Mp4Parser2", "checkUpdateLazyParseTimeTable, newParseRange:[%s, %s]", new Object[] { ((Pair)localObject).first, ((Pair)localObject).second });
        boolean bool = this.ixJ.b(this.randomAccessFile, ((Integer)((Pair)localObject).first).intValue(), ((Integer)((Pair)localObject).second).intValue());
        this.ixz = this.ixJ.ixz;
        this.ixB = this.ixJ.ixB;
        this.ixC = this.ixJ.ixC;
        this.ixH = this.ixJ.ixH;
        this.ixO.add(localObject);
        long l1 = bs.Gn();
        Collections.sort(this.ixO, this.ixP);
        this.ixN = ((Integer)((Pair)this.ixO.get(this.ixO.size() - 1)).second).intValue();
        l2 = bs.aO(l2);
        ac.i("MicroMsg.Mp4Parser2", "checkUpdateLazyParseTimeTable incrementCreateTimeTable finish, ret:%s, cost:%sms, sort cost:%s, range:[%s, %s]", new Object[] { Boolean.valueOf(bool), Long.valueOf(l2), Long.valueOf(bs.aO(l1)), ((Pair)localObject).first, ((Pair)localObject).second });
        localObject = l.ixR;
        l.qB(l2);
      }
    }
    AppMethodBeat.o(175941);
  }
  
  private void reset()
  {
    AppMethodBeat.i(133874);
    this.filePath = null;
    this.ixz = null;
    this.ixG.clear();
    this.ixA = 0;
    this.duration = 0L;
    this.ixw = 0L;
    if (this.ixB != null) {
      this.ixB.clear();
    }
    if (this.ixC != null) {
      this.ixC.clear();
    }
    if (this.ixO != null) {
      this.ixO.clear();
    }
    this.ixH = null;
    this.ixF = 0;
    AppMethodBeat.o(133874);
  }
  
  public final boolean F(String paramString, long paramLong)
  {
    AppMethodBeat.i(191671);
    reset();
    this.filePath = paramString;
    if (!new e(this.filePath).exists())
    {
      AppMethodBeat.o(191671);
      return false;
    }
    try
    {
      this.randomAccessFile = com.tencent.mm.vfs.i.cY(this.filePath, false);
      boolean bool = e(this.randomAccessFile);
      AppMethodBeat.o(191671);
      return bool;
    }
    catch (Exception paramString)
    {
      AppMethodBeat.o(191671);
    }
    return false;
  }
  
  public final boolean a(int paramInt1, int paramInt2, PInt paramPInt1, PInt paramPInt2)
  {
    AppMethodBeat.i(133877);
    ac.i("MicroMsg.Mp4Parser2", "[before] curPlaySecond %d, cacheSecond %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (this.ixz == null)
    {
      AppMethodBeat.o(133877);
      return false;
    }
    long l1 = bs.Gn();
    int i = paramInt1;
    if (paramInt1 < 0) {
      i = 0;
    }
    int j = this.ixz.length;
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
    if (this.ixM) {}
    try
    {
      qB(Math.max(i, paramInt1));
      l2 = this.ixz[i];
      l3 = this.ixz[paramInt1];
      ac.d("MicroMsg.Mp4Parser2", "curPos %d, cachePos %d", new Object[] { Long.valueOf(l2), Long.valueOf(l3) });
      if ((l2 < 0L) || (l3 < 0L)) {
        ac.e("MicroMsg.Mp4Parser2", "videoTimeToFilePos error, not parse this entry now");
      }
      if (i == 0)
      {
        paramPInt1.value = 0;
        paramPInt2.value = ((int)l3);
        ac.i("MicroMsg.Mp4Parser2", "[after] curPlaySecond %d, cacheSecond %d, offset.value %d, length.value %d, cost %sms", new Object[] { Integer.valueOf(i), Integer.valueOf(paramInt1), Integer.valueOf(paramPInt1.value), Integer.valueOf(paramPInt2.value), Long.valueOf(bs.aO(l1)) });
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
        ac.printErrStackTrace("MicroMsg.Mp4Parser2", localException, "videoTimeToFilePos, checkUpdateLazyParseTimeTable error", new Object[0]);
        continue;
        paramPInt1.value = ((int)l2);
        paramPInt2.value = ((int)l3 - (int)l2);
      }
    }
  }
  
  public final int aNC()
  {
    AppMethodBeat.i(133875);
    for (;;)
    {
      try
      {
        if (this.ixM) {
          continue;
        }
        if (this.ixC == null) {
          continue;
        }
        if (this.ixF == 0) {
          this.ixF = ((int)(((Long)((Pair)this.ixC.get(this.ixC.size() - 1)).second).longValue() / 1000L / 1000L));
        }
        i = this.ixF;
      }
      catch (Exception localException)
      {
        Pair localPair;
        ac.printErrStackTrace("MicroMsg.Mp4Parser2", localException, "get last key frame error.", new Object[0]);
        int i = 0;
        continue;
      }
      AppMethodBeat.o(133875);
      return i;
      i = 0;
      continue;
      if ((this.ixH != null) && (this.ixH.length > 0))
      {
        if (this.ixH[(this.ixH.length - 1)] == null) {
          qB(this.ixz.length - 1);
        }
        localPair = this.ixH[(this.ixH.length - 1)];
        if ((localPair != null) && (this.ixF == 0)) {
          this.ixF = ((int)(((Long)localPair.second).longValue() / 1000L / 1000L));
        }
        i = this.ixF;
      }
      else
      {
        i = 0;
      }
    }
  }
  
  public final int aND()
  {
    return this.ixA;
  }
  
  public void aNE()
  {
    AppMethodBeat.i(191670);
    if (((b)com.tencent.mm.kernel.g.ab(b.class)).a(b.a.qaL, 0) == 1)
    {
      ac.i("MicroMsg.Mp4Parser2", "config to use lazy parse");
      this.ixM = true;
      AppMethodBeat.o(191670);
      return;
    }
    ac.i("MicroMsg.Mp4Parser2", "not use lazy parse");
    this.ixM = false;
    AppMethodBeat.o(191670);
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
        if (this.ixM) {
          continue;
        }
        if ((this.ixC == null) || (this.ixC.size() <= 0)) {
          continue;
        }
        j = this.ixC.size();
        l = paramInt;
        paramPInt2.value = 0;
        paramPInt1.value = 0;
        i = 0;
        if (i >= j) {
          continue;
        }
        localPair = (Pair)this.ixC.get(i);
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
        ac.printErrStackTrace("MicroMsg.Mp4Parser2", localException1, "seekVFrame seekTime[%d]", new Object[] { Integer.valueOf(paramInt) });
        continue;
        ac.i("MicroMsg.Mp4Parser2", "lazy parse seek key Frame seekTime[%d] pre[%d] next[%d], find:%s, fromLastFrame:%s, stssList.size:%s, stssArray.length:%s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(paramPInt1.value), Integer.valueOf(paramPInt2.value), Boolean.valueOf(bool2), Boolean.valueOf(bool3), Integer.valueOf(this.ixC.size()), Integer.valueOf(this.ixH.length) });
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
        paramPInt1.value = ((int)(((Long)((Pair)this.ixC.get(j - 1)).second).longValue() / 1000L / 1000L));
        bool2 = bool1;
        paramPInt2.value = paramInt;
        bool1 = true;
        bool2 = true;
        bool3 = bool2;
        bool2 = bool1;
        if (this.ixM) {
          continue;
        }
        ac.i("MicroMsg.Mp4Parser2", "seek key Frame seekTime[%d] pre[%d] next[%d], stssList.size:%s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(paramPInt1.value), Integer.valueOf(paramPInt2.value), Integer.valueOf(this.ixC.size()) });
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
    if ((this.ixH != null) && (this.ixH.length > 0))
    {
      qB(paramInt);
      qB(this.ixz.length);
      j = this.ixH.length;
      l = paramInt;
      paramPInt2.value = 0;
      paramPInt1.value = 0;
      i = 0;
      for (;;)
      {
        if (i >= j) {
          break label695;
        }
        localPair = this.ixH[i];
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
            localPair = this.ixH[(j - 1)];
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
    if (this.ixz == null)
    {
      AppMethodBeat.o(175942);
      return 0;
    }
    long l1 = bs.Gn();
    long l2 = paramInt1 + paramInt2;
    int j = 0;
    int k = this.ixz.length;
    int i;
    if (this.ixM)
    {
      if (this.ixN >= this.ixz.length) {
        break label205;
      }
      i = this.ixN;
    }
    int m;
    for (;;)
    {
      ac.i("MicroMsg.Mp4Parser2", "filePosToVideoTime lazy parse try search from time table, count:%s", new Object[] { Integer.valueOf(i) });
      try
      {
        qB(i);
        k = i;
        i = 0;
        m = j;
        if (i < k) {
          if ((!this.ixM) || (this.ixz[i] >= 0L)) {}
        }
      }
      catch (Exception localException1)
      {
        try
        {
          qB(i);
          if (this.ixz[i] == l2)
          {
            m = i;
            label143:
            ac.i("MicroMsg.Mp4Parser2", "filePosToVideoTime, offset:%s, length:%s, filePos:%s, playtime:%s, cost:%sms", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Long.valueOf(l2), Integer.valueOf(m), Long.valueOf(bs.aO(l1)) });
            AppMethodBeat.o(175942);
            return m;
            label205:
            i = this.ixz.length;
            continue;
            localException1 = localException1;
            ac.printErrStackTrace("MicroMsg.Mp4Parser2", localException1, "", new Object[0]);
            k = i;
          }
        }
        catch (Exception localException2)
        {
          for (;;)
          {
            ac.printErrStackTrace("MicroMsg.Mp4Parser2", localException2, "", new Object[0]);
          }
        }
      }
    }
    if (this.ixz[i] < l2) {
      j = i;
    }
    for (;;)
    {
      i += 1;
      break;
      m = j;
      if (this.ixz[i] > l2) {
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
    //   2: ldc_w 673
    //   5: invokestatic 52	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_0
    //   9: getfield 564	com/tencent/mm/plugin/a/k:randomAccessFile	Ljava/io/RandomAccessFile;
    //   12: astore_1
    //   13: aload_1
    //   14: ifnull +110 -> 124
    //   17: ldc 100
    //   19: ldc_w 675
    //   22: iconst_0
    //   23: anewarray 4	java/lang/Object
    //   26: invokestatic 678	com/tencent/mm/sdk/platformtools/ac:m	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   29: aload_0
    //   30: getfield 564	com/tencent/mm/plugin/a/k:randomAccessFile	Ljava/io/RandomAccessFile;
    //   33: invokevirtual 681	java/io/RandomAccessFile:close	()V
    //   36: aload_0
    //   37: aconst_null
    //   38: putfield 564	com/tencent/mm/plugin/a/k:randomAccessFile	Ljava/io/RandomAccessFile;
    //   41: aload_0
    //   42: iconst_0
    //   43: putfield 71	com/tencent/mm/plugin/a/k:ixN	I
    //   46: aload_0
    //   47: getfield 73	com/tencent/mm/plugin/a/k:ixO	Ljava/util/ArrayList;
    //   50: invokevirtual 581	java/util/ArrayList:clear	()V
    //   53: aload_0
    //   54: aconst_null
    //   55: putfield 63	com/tencent/mm/plugin/a/k:ixJ	Lcom/tencent/mm/plugin/a/o;
    //   58: aload_0
    //   59: aconst_null
    //   60: putfield 67	com/tencent/mm/plugin/a/k:ixL	Lcom/tencent/mm/plugin/a/o;
    //   63: aload_0
    //   64: aconst_null
    //   65: putfield 564	com/tencent/mm/plugin/a/k:randomAccessFile	Ljava/io/RandomAccessFile;
    //   68: ldc_w 673
    //   71: invokestatic 88	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   74: aload_0
    //   75: monitorexit
    //   76: return
    //   77: astore_1
    //   78: ldc 100
    //   80: aload_1
    //   81: ldc_w 671
    //   84: iconst_0
    //   85: anewarray 4	java/lang/Object
    //   88: invokestatic 520	com/tencent/mm/sdk/platformtools/ac:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   91: aload_0
    //   92: aconst_null
    //   93: putfield 564	com/tencent/mm/plugin/a/k:randomAccessFile	Ljava/io/RandomAccessFile;
    //   96: ldc_w 673
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
    //   113: putfield 564	com/tencent/mm/plugin/a/k:randomAccessFile	Ljava/io/RandomAccessFile;
    //   116: ldc_w 673
    //   119: invokestatic 88	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   122: aload_1
    //   123: athrow
    //   124: ldc_w 673
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.a.k
 * JD-Core Version:    0.7.0.1
 */