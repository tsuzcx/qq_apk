package com.tencent.mm.plugin.a;

import android.annotation.TargetApi;
import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
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
  private long[] iTB;
  private int iTC;
  private List<n> iTD;
  private List<Pair> iTE;
  public int iTH;
  private List<long[]> iTI;
  private Pair[] iTJ;
  private long iTK;
  private o iTL;
  private long iTM;
  private o iTN;
  protected boolean iTO;
  private int iTP;
  private ArrayList<Pair<Integer, Integer>> iTQ;
  private Comparator<Pair<Integer, Integer>> iTR;
  private long iTy;
  private RandomAccessFile randomAccessFile;
  
  public k()
  {
    AppMethodBeat.i(133873);
    this.iTI = new ArrayList();
    this.iTK = -1L;
    this.iTL = null;
    this.iTM = -1L;
    this.iTN = null;
    this.iTO = false;
    this.iTP = 0;
    this.iTQ = new ArrayList();
    this.iTR = new k.1(this);
    this.iTH = 0;
    aRp();
    AppMethodBeat.o(133873);
  }
  
  private long[] a(RandomAccessFile paramRandomAccessFile, long paramLong, byte[] paramArrayOfByte, boolean paramBoolean)
  {
    AppMethodBeat.i(133879);
    long l = bu.HQ();
    ae.i("MicroMsg.Mp4Parser2", "createTimeTable, minfFilePos:%s, isVideo:%s", new Object[] { Long.valueOf(paramLong), Boolean.valueOf(paramBoolean) });
    paramRandomAccessFile.seek(paramLong);
    paramArrayOfByte = (o)c.a(paramRandomAccessFile, paramArrayOfByte, a.blu);
    ae.i("MicroMsg.Mp4Parser2", "createTimeTable, stblAtom:%s, duration:%s, timeScale:%s", new Object[] { paramArrayOfByte, Long.valueOf(this.duration), Long.valueOf(this.iTy) });
    if (paramArrayOfByte != null)
    {
      paramArrayOfByte.duration = this.duration;
      paramArrayOfByte.iTy = this.iTy;
      paramArrayOfByte.f(paramRandomAccessFile);
      paramRandomAccessFile = paramArrayOfByte.iTB;
      if (paramBoolean)
      {
        this.iTD = paramArrayOfByte.iTD;
        this.iTE = paramArrayOfByte.iTE;
      }
      if ((this.iTD != null) && (this.iTE != null)) {
        ae.d("MicroMsg.Mp4Parser2", "parser stbl atom finish, sampleList:%s, stssList:%s", new Object[] { Integer.valueOf(this.iTD.size()), Integer.valueOf(this.iTE.size()) });
      }
      if (paramRandomAccessFile != null) {
        ae.i("MicroMsg.Mp4Parser2", "createTimeTable cost:%s, length:%s", new Object[] { Long.valueOf(bu.aO(l)), Integer.valueOf(paramRandomAccessFile.length) });
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
    long l3 = bu.HQ();
    ae.i("MicroMsg.Mp4Parser2", "createTimeTable, stblAtom:%s, duration:%s, timeScale:%s", new Object[] { paramo, Long.valueOf(this.duration), Long.valueOf(this.iTy) });
    if (paramo != null)
    {
      paramo.duration = this.duration;
      paramo.iTy = this.iTy;
      long l1 = paramo.getSize();
      byte[] arrayOfByte = new byte[8];
      int j = 0;
      int m = 0;
      int k = 0;
      int n = 0;
      int i1 = 0;
      long l4 = bu.HQ();
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
        ae.i("MicroMsg.StblAtom", "readAtom, type:%s, size:%s", new Object[] { Integer.valueOf(i7), Integer.valueOf(i6) });
        l1 = 0L;
        long l5 = bu.HQ();
        if (i7 == a.bma)
        {
          paramo.iTW = paramRandomAccessFile.getFilePointer();
          l1 = paramo.a(paramRandomAccessFile, i6);
          ae.i("MicroMsg.StblAtom", "handleSttsAtom cost:%sms", new Object[] { Long.valueOf(bu.aO(l5)) });
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
          if (i7 == a.bmd)
          {
            paramo.iTX = paramRandomAccessFile.getFilePointer();
            l1 = paramo.b(paramRandomAccessFile, i6);
            ae.i("MicroMsg.StblAtom", "handleStscAtom cost:%sms", new Object[] { Long.valueOf(bu.aO(l5)) });
            i3 = 1;
            i2 = n;
            i = m;
            i4 = j;
          }
          else if (i7 == a.bmg)
          {
            paramo.iTY = paramRandomAccessFile.getFilePointer();
            l1 = paramo.c(paramRandomAccessFile, i6);
            ae.i("MicroMsg.StblAtom", "handleStcoAtom cost:%sms", new Object[] { Long.valueOf(bu.aO(l5)) });
            i = 1;
            i2 = n;
            i3 = k;
            i4 = j;
          }
          else if (i7 == a.bmh)
          {
            paramo.iTZ = paramRandomAccessFile.getFilePointer();
            l1 = paramo.d(paramRandomAccessFile, i6);
            ae.i("MicroMsg.StblAtom", "handleCo64Atom cost:%sms", new Object[] { Long.valueOf(bu.aO(l5)) });
            i = 1;
            i2 = n;
            i3 = k;
            i4 = j;
          }
          else if (i7 == a.bme)
          {
            paramo.iUa = paramRandomAccessFile.getFilePointer();
            paramo.iUc = i6;
            ae.i("MicroMsg.StblAtom", "stsz atom pos:%s", new Object[] { Long.valueOf(paramo.iUa) });
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
              paramo.iUb = paramRandomAccessFile.getFilePointer();
              l1 = paramo.f(paramRandomAccessFile, i6);
              ae.i("MicroMsg.StblAtom", "handleStssAtom cost:%sms", new Object[] { Long.valueOf(bu.aO(l5)) });
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
        paramo.iUk = true;
        if (paramo.iUa > 0L)
        {
          l2 = bu.HQ();
          paramRandomAccessFile.seek(paramo.iUa);
          i = paramo.iUc;
          if (c.a(paramRandomAccessFile, 4L)) {
            break label1070;
          }
          l1 = -1L;
          label705:
          ae.i("MicroMsg.StblAtom", "handleStszAtom cost:%sms, ret:%s, sampleSizeTable.length:%s", new Object[] { Long.valueOf(bu.aO(l2)), Long.valueOf(l1), Integer.valueOf(paramo.boK.length) });
          if (paramo.iUe != null) {
            break label1350;
          }
        }
      }
      label1070:
      label1350:
      for (paramo.iTJ = new Pair[paramo.iTD.size()];; paramo.iTJ = new Pair[paramo.iUe.length])
      {
        ae.i("MicroMsg.StblAtom", "parse lazy, stssArray.size:%s", new Object[] { Integer.valueOf(paramo.iTJ.length) });
        l1 = bu.HQ();
        paramo.b(paramRandomAccessFile, 0, 5);
        paramo.iUh = 5L;
        ae.i("MicroMsg.StblAtom", "createTimeTable cost:%sms, size:%s, lazyDurationSecond:%s", new Object[] { Long.valueOf(bu.aO(l1)), Integer.valueOf(paramo.iTB.length), Integer.valueOf(5) });
        if (5 >= paramo.iTB.length)
        {
          paramo.iUk = false;
          ae.i("MicroMsg.StblAtom", "lazyDurationSecond:%s, timeTable.length:%s, not need lazy", new Object[] { Integer.valueOf(5), Integer.valueOf(paramo.iTB.length) });
        }
        ae.i("MicroMsg.StblAtom", "lazy parse finish cost:%sms", new Object[] { Long.valueOf(bu.aO(l4)) });
        paramRandomAccessFile = paramo.iTB;
        this.iTD = paramo.iTD;
        this.iTE = paramo.iTE;
        this.iTJ = paramo.iTJ;
        if ((this.iTD != null) && (this.iTJ != null)) {
          ae.d("MicroMsg.Mp4Parser2", "parser stbl atom lazy finish, sampleList.size:%s, stssArray.length:%s", new Object[] { Integer.valueOf(this.iTD.size()), Integer.valueOf(this.iTJ.length) });
        }
        if (paramRandomAccessFile != null) {
          ae.i("MicroMsg.Mp4Parser2", "createTimeTableLazy cost:%s, length:%s", new Object[] { Long.valueOf(bu.aO(l3)), Integer.valueOf(paramRandomAccessFile.length) });
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
          ae.w("MicroMsg.StblAtom", "stsz read sample size error");
          l1 = -1L;
          break label705;
        }
        j = c.readInt(arrayOfByte, 0);
        if (j > 0)
        {
          paramo.boK = new int[1];
          paramo.boK[0] = j;
          ae.i("MicroMsg.StblAtom", "all sample size is the same. size : ".concat(String.valueOf(j)));
          l1 = 8L;
          break label705;
        }
        if (paramRandomAccessFile.read(arrayOfByte, 0, 4) < 4)
        {
          ae.w("MicroMsg.StblAtom", "stsz read entry count error");
          l1 = -1L;
          break label705;
        }
        j = c.readInt(arrayOfByte, 0);
        l1 = j * 4L;
        if ((l1 <= 0L) || (l1 > i - 20))
        {
          ae.w("MicroMsg.StblAtom", "stco error entryCount : ".concat(String.valueOf(j)));
          l1 = -1L;
          break label705;
        }
        paramo.iUj = l1;
        paramo.boK = new int[j + 1];
        paramo.iUn = new byte[paramo.boK.length * 4];
        paramo.iUi = paramRandomAccessFile.getFilePointer();
        l1 = paramRandomAccessFile.read(paramo.iUn);
        ae.i("MicroMsg.StblAtom", "handleStszAtomLazy start parse stsz filePos:%s, sampleSizeReaded:%s, sampleSizeTableData.length:%s", new Object[] { Long.valueOf(paramo.iUi), Long.valueOf(l1), Integer.valueOf(paramo.iUn.length) });
        paramo.a(paramRandomAccessFile, 0, 5);
        l1 += 12L;
        break label705;
      }
    }
    AppMethodBeat.o(175943);
    return new long[0];
  }
  
  private void aRq()
  {
    AppMethodBeat.i(133880);
    ae.i("MicroMsg.Mp4Parser2", "timeTableLength, length:%s", new Object[] { Integer.valueOf(this.iTC) });
    this.iTB = new long[this.iTC + 2];
    Iterator localIterator = this.iTI.iterator();
    while (localIterator.hasNext())
    {
      long[] arrayOfLong1 = (long[])localIterator.next();
      int i = 0;
      while (i < arrayOfLong1.length)
      {
        long[] arrayOfLong2 = this.iTB;
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
    Object localObject1 = l.iTT;
    l.fm(this.iTO);
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
        ae.i("MicroMsg.Mp4Parser2", "parserExtractor");
        l3 = bu.HQ();
        localObject2 = c.a(paramRandomAccessFile, (byte[])localObject1, a.blp);
        ae.d("MicroMsg.Mp4Parser2", "find moov atom finish, cost:%s, beginPos:%s, size:%s", new Object[] { Long.valueOf(bu.aO(l3)), Long.valueOf(((a)localObject2).iTb), Long.valueOf(((a)localObject2).getSize()) });
        l1 = ((a)localObject2).iTb;
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
          ae.i("MicroMsg.Mp4Parser2", "read atomSize:%s, atomType:%s", new Object[] { Integer.valueOf(j), Integer.valueOf(k) });
          if (k != a.blr) {
            break label1089;
          }
          localObject2 = (p)i.d(j, k, l1);
          localg = p.b(paramRandomAccessFile, (byte[])localObject1);
          ae.i("MicroMsg.Mp4Parser2", "found track atom, mdiaAtom:%s, trakAtom:%s", new Object[] { localg, localObject2 });
          if ((localg == null) || (!localg.a(paramRandomAccessFile, (byte[])localObject1))) {
            break label1089;
          }
          if (localg.iTz != g.iTv) {
            break label783;
          }
          this.iTy = localg.iTy;
          this.duration = localg.duration;
          ae.i("MicroMsg.Mp4Parser2", "this trak atom is video trak. timeScale: " + this.iTy + " duration: " + this.duration);
          this.iTK = localg.iTA;
          if (this.iTO)
          {
            long l4 = this.iTK;
            long l5 = bu.HQ();
            ae.i("MicroMsg.Mp4Parser2", "findStblAtomInfo, minfFilePos:%s", new Object[] { Long.valueOf(l4) });
            paramRandomAccessFile.seek(l4);
            localObject2 = (o)c.a(paramRandomAccessFile, (byte[])localObject1, a.blu);
            ae.i("MicroMsg.Mp4Parser2", "findStblAtomInfo, stblAtom:%s, duration:%s, timeScale:%s, cost:%s", new Object[] { localObject2, Long.valueOf(this.duration), Long.valueOf(this.iTy), Long.valueOf(bu.aO(l5)) });
            this.iTL = ((o)localObject2);
            this.iTB = a(paramRandomAccessFile, this.iTL);
            this.iTO = this.iTL.iUk;
            this.iTQ.add(new Pair(Integer.valueOf(0), Integer.valueOf(5)));
            this.iTP = ((Integer)((Pair)this.iTQ.get(this.iTQ.size() - 1)).second).intValue();
            this.iTC = (this.iTB.length - 2);
            ae.i("MicroMsg.Mp4Parser2", "lazy parse finish, isLazyParse:%s", new Object[] { Boolean.valueOf(this.iTO) });
            i = 1;
            if (this.iTC <= 30) {
              break label765;
            }
            ae.i("MicroMsg.Mp4Parser2", "current timeTableLength is:%s too long, ignore parse other track", new Object[] { Integer.valueOf(this.iTC) });
          }
        }
        else
        {
          label593:
          if (this.iTO) {
            break label1049;
          }
          ae.i("MicroMsg.Mp4Parser2", "parse finish, start merge time table, cost:%s", new Object[] { Long.valueOf(bu.aO(l3)) });
          aRq();
          l1 = bu.aO(l3);
          label634:
          ae.i("MicroMsg.Mp4Parser2", "parseExtractor finish, totalCost:%sms, isLazyParse:%s", new Object[] { Long.valueOf(l1), Boolean.valueOf(this.iTO) });
          paramRandomAccessFile = l.iTT;
          l.a(this.iTO, l1, this.iTC);
          AppMethodBeat.o(133881);
          return true;
        }
        localObject2 = a(paramRandomAccessFile, localg.iTA, (byte[])localObject1, true);
        ae.i("MicroMsg.Mp4Parser2", "createTimeTable finish");
        this.iTI.add(localObject2);
        this.iTC = Math.max(this.iTC, localObject2.length - 2);
        continue;
        if (!this.iTO) {
          break label968;
        }
      }
      catch (Exception paramRandomAccessFile)
      {
        ae.printErrStackTrace("MicroMsg.Mp4Parser2", paramRandomAccessFile, "parser mp4 error", new Object[0]);
        AppMethodBeat.o(133881);
        return false;
      }
      label765:
      ae.i("MicroMsg.Mp4Parser2", "lazy parse, ignore other trak atom");
      continue;
      label783:
      if (localg.iTz != g.iTw) {
        break label1038;
      }
      if ((this.iTO) && (i != 0))
      {
        ae.i("MicroMsg.Mp4Parser2", "lazy parse, ignore sound trak atom");
      }
      else
      {
        if (this.iTC <= 30) {
          break;
        }
        ae.i("MicroMsg.Mp4Parser2", "current timeTableLength is:%s too long, ignore parse sound track", new Object[] { Integer.valueOf(this.iTC) });
      }
    }
    this.iTy = localg.iTy;
    this.duration = localg.duration;
    ae.i("MicroMsg.Mp4Parser2", "this trak atom is sound trak. timeScale: " + this.iTy + " duration: " + this.duration);
    this.iTM = localg.iTA;
    Object localObject2 = a(paramRandomAccessFile, localg.iTA, (byte[])localObject1, false);
    ae.i("MicroMsg.Mp4Parser2", "createTimeTable finish");
    this.iTI.add(localObject2);
    this.iTC = Math.max(this.iTC, localObject2.length - 2);
    label1038:
    label1049:
    label1089:
    for (;;)
    {
      label968:
      l2 -= j;
      l1 += j;
      ae.d("MicroMsg.Mp4Parser2", "atomSize:%s, atomType:%s, remains:%s, beginPos:%s, timeTableLength:%s", new Object[] { Integer.valueOf(j), Integer.valueOf(k), Long.valueOf(l2), Long.valueOf(l1), Integer.valueOf(this.iTC) });
      break;
      ae.i("MicroMsg.Mp4Parser2", "unknown mdiaAtom");
      break label593;
      l1 = bu.aO(l3);
      ae.i("MicroMsg.Mp4Parser2", "lazy parse finish, cost:%s, timeTableLength:%s", new Object[] { Long.valueOf(l1), Integer.valueOf(this.iTC) });
      break label634;
    }
  }
  
  private Pair<Integer, Integer> rd(int paramInt)
  {
    AppMethodBeat.i(175940);
    Pair localPair1;
    if (this.iTQ.size() > 0)
    {
      localPair1 = new Pair(Integer.valueOf(Math.max(paramInt - 1, 1)), Integer.valueOf(Math.min(paramInt + 5, this.iTB.length - 1)));
      Iterator localIterator = this.iTQ.iterator();
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
            localPair1 = new Pair(Integer.valueOf(Math.min(((Integer)localPair2.second).intValue() + 1, this.iTB.length - 1)), localPair1.second);
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
  
  private void re(int paramInt)
  {
    AppMethodBeat.i(175941);
    if (this.iTL != null)
    {
      long l2 = bu.HQ();
      ae.i("MicroMsg.Mp4Parser2", "checkUpdateLazyParseTimeTable currentLazyParseSeconds:%s, second:%s", new Object[] { Integer.valueOf(this.iTP), Integer.valueOf(paramInt) });
      Object localObject = rd(paramInt);
      ae.i("MicroMsg.Mp4Parser2", "calcLazyParseRange cost:%sms", new Object[] { Long.valueOf(bu.aO(l2)) });
      if (localObject != null)
      {
        ae.i("MicroMsg.Mp4Parser2", "checkUpdateLazyParseTimeTable, newParseRange:[%s, %s]", new Object[] { ((Pair)localObject).first, ((Pair)localObject).second });
        boolean bool = this.iTL.b(this.randomAccessFile, ((Integer)((Pair)localObject).first).intValue(), ((Integer)((Pair)localObject).second).intValue());
        this.iTB = this.iTL.iTB;
        this.iTD = this.iTL.iTD;
        this.iTE = this.iTL.iTE;
        this.iTJ = this.iTL.iTJ;
        this.iTQ.add(localObject);
        long l1 = bu.HQ();
        Collections.sort(this.iTQ, this.iTR);
        this.iTP = ((Integer)((Pair)this.iTQ.get(this.iTQ.size() - 1)).second).intValue();
        l2 = bu.aO(l2);
        ae.i("MicroMsg.Mp4Parser2", "checkUpdateLazyParseTimeTable incrementCreateTimeTable finish, ret:%s, cost:%sms, sort cost:%s, range:[%s, %s]", new Object[] { Boolean.valueOf(bool), Long.valueOf(l2), Long.valueOf(bu.aO(l1)), ((Pair)localObject).first, ((Pair)localObject).second });
        localObject = l.iTT;
        l.sN(l2);
      }
    }
    AppMethodBeat.o(175941);
  }
  
  private void reset()
  {
    AppMethodBeat.i(133874);
    this.filePath = null;
    this.iTB = null;
    this.iTI.clear();
    this.iTC = 0;
    this.duration = 0L;
    this.iTy = 0L;
    if (this.iTD != null) {
      this.iTD.clear();
    }
    if (this.iTE != null) {
      this.iTE.clear();
    }
    if (this.iTQ != null) {
      this.iTQ.clear();
    }
    this.iTJ = null;
    this.iTH = 0;
    AppMethodBeat.o(133874);
  }
  
  public final boolean L(String paramString, long paramLong)
  {
    AppMethodBeat.i(220258);
    reset();
    this.filePath = paramString;
    if (!new com.tencent.mm.vfs.k(this.filePath).exists())
    {
      AppMethodBeat.o(220258);
      return false;
    }
    try
    {
      this.randomAccessFile = com.tencent.mm.vfs.o.dg(this.filePath, false);
      boolean bool = e(this.randomAccessFile);
      AppMethodBeat.o(220258);
      return bool;
    }
    catch (Exception paramString)
    {
      AppMethodBeat.o(220258);
    }
    return false;
  }
  
  public final boolean a(int paramInt1, int paramInt2, PInt paramPInt1, PInt paramPInt2)
  {
    AppMethodBeat.i(133877);
    ae.i("MicroMsg.Mp4Parser2", "[before] curPlaySecond %d, cacheSecond %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (this.iTB == null)
    {
      AppMethodBeat.o(133877);
      return false;
    }
    long l1 = bu.HQ();
    int i = paramInt1;
    if (paramInt1 < 0) {
      i = 0;
    }
    int j = this.iTB.length;
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
    if (this.iTO) {}
    try
    {
      re(Math.max(i, paramInt1));
      l2 = this.iTB[i];
      l3 = this.iTB[paramInt1];
      ae.d("MicroMsg.Mp4Parser2", "curPos %d, cachePos %d", new Object[] { Long.valueOf(l2), Long.valueOf(l3) });
      if ((l2 < 0L) || (l3 < 0L)) {
        ae.e("MicroMsg.Mp4Parser2", "videoTimeToFilePos error, not parse this entry now");
      }
      if (i == 0)
      {
        paramPInt1.value = 0;
        paramPInt2.value = ((int)l3);
        ae.i("MicroMsg.Mp4Parser2", "[after] curPlaySecond %d, cacheSecond %d, offset.value %d, length.value %d, cost %sms", new Object[] { Integer.valueOf(i), Integer.valueOf(paramInt1), Integer.valueOf(paramPInt1.value), Integer.valueOf(paramPInt2.value), Long.valueOf(bu.aO(l1)) });
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
        ae.printErrStackTrace("MicroMsg.Mp4Parser2", localException, "videoTimeToFilePos, checkUpdateLazyParseTimeTable error", new Object[0]);
        continue;
        paramPInt1.value = ((int)l2);
        paramPInt2.value = ((int)l3 - (int)l2);
      }
    }
  }
  
  public final int aRn()
  {
    AppMethodBeat.i(133875);
    for (;;)
    {
      try
      {
        if (this.iTO) {
          continue;
        }
        if (this.iTE == null) {
          continue;
        }
        if (this.iTH == 0) {
          this.iTH = ((int)(((Long)((Pair)this.iTE.get(this.iTE.size() - 1)).second).longValue() / 1000L / 1000L));
        }
        i = this.iTH;
      }
      catch (Exception localException)
      {
        Pair localPair;
        ae.printErrStackTrace("MicroMsg.Mp4Parser2", localException, "get last key frame error.", new Object[0]);
        int i = 0;
        continue;
      }
      AppMethodBeat.o(133875);
      return i;
      i = 0;
      continue;
      if ((this.iTJ != null) && (this.iTJ.length > 0))
      {
        if (this.iTJ[(this.iTJ.length - 1)] == null) {
          re(this.iTB.length - 1);
        }
        localPair = this.iTJ[(this.iTJ.length - 1)];
        if ((localPair != null) && (this.iTH == 0)) {
          this.iTH = ((int)(((Long)localPair.second).longValue() / 1000L / 1000L));
        }
        i = this.iTH;
      }
      else
      {
        i = 0;
      }
    }
  }
  
  public final int aRo()
  {
    return this.iTC;
  }
  
  public void aRp()
  {
    AppMethodBeat.i(220257);
    if (((b)com.tencent.mm.kernel.g.ab(b.class)).a(b.a.qNO, 0) == 1)
    {
      ae.i("MicroMsg.Mp4Parser2", "config to use lazy parse");
      this.iTO = true;
      AppMethodBeat.o(220257);
      return;
    }
    ae.i("MicroMsg.Mp4Parser2", "not use lazy parse");
    this.iTO = false;
    AppMethodBeat.o(220257);
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
        if (this.iTO) {
          continue;
        }
        if ((this.iTE == null) || (this.iTE.size() <= 0)) {
          continue;
        }
        j = this.iTE.size();
        l = paramInt;
        paramPInt2.value = 0;
        paramPInt1.value = 0;
        i = 0;
        if (i >= j) {
          continue;
        }
        localPair = (Pair)this.iTE.get(i);
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
        ae.printErrStackTrace("MicroMsg.Mp4Parser2", localException1, "seekVFrame seekTime[%d]", new Object[] { Integer.valueOf(paramInt) });
        continue;
        ae.i("MicroMsg.Mp4Parser2", "lazy parse seek key Frame seekTime[%d] pre[%d] next[%d], find:%s, fromLastFrame:%s, stssList.size:%s, stssArray.length:%s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(paramPInt1.value), Integer.valueOf(paramPInt2.value), Boolean.valueOf(bool2), Boolean.valueOf(bool3), Integer.valueOf(this.iTE.size()), Integer.valueOf(this.iTJ.length) });
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
        paramPInt1.value = ((int)(((Long)((Pair)this.iTE.get(j - 1)).second).longValue() / 1000L / 1000L));
        bool2 = bool1;
        paramPInt2.value = paramInt;
        bool1 = true;
        bool2 = true;
        bool3 = bool2;
        bool2 = bool1;
        if (this.iTO) {
          continue;
        }
        ae.i("MicroMsg.Mp4Parser2", "seek key Frame seekTime[%d] pre[%d] next[%d], stssList.size:%s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(paramPInt1.value), Integer.valueOf(paramPInt2.value), Integer.valueOf(this.iTE.size()) });
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
    if ((this.iTJ != null) && (this.iTJ.length > 0))
    {
      re(paramInt);
      re(this.iTB.length);
      j = this.iTJ.length;
      l = paramInt;
      paramPInt2.value = 0;
      paramPInt1.value = 0;
      i = 0;
      for (;;)
      {
        if (i >= j) {
          break label695;
        }
        localPair = this.iTJ[i];
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
            localPair = this.iTJ[(j - 1)];
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
  
  public final int dy(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(175942);
    if (this.iTB == null)
    {
      AppMethodBeat.o(175942);
      return 0;
    }
    long l1 = bu.HQ();
    long l2 = paramInt1 + paramInt2;
    int j = 0;
    int k = this.iTB.length;
    int i;
    if (this.iTO)
    {
      if (this.iTP >= this.iTB.length) {
        break label205;
      }
      i = this.iTP;
    }
    int m;
    for (;;)
    {
      ae.i("MicroMsg.Mp4Parser2", "filePosToVideoTime lazy parse try search from time table, count:%s", new Object[] { Integer.valueOf(i) });
      try
      {
        re(i);
        k = i;
        i = 0;
        m = j;
        if (i < k) {
          if ((!this.iTO) || (this.iTB[i] >= 0L)) {}
        }
      }
      catch (Exception localException1)
      {
        try
        {
          re(i);
          if (this.iTB[i] == l2)
          {
            m = i;
            label143:
            ae.i("MicroMsg.Mp4Parser2", "filePosToVideoTime, offset:%s, length:%s, filePos:%s, playtime:%s, cost:%sms", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Long.valueOf(l2), Integer.valueOf(m), Long.valueOf(bu.aO(l1)) });
            AppMethodBeat.o(175942);
            return m;
            label205:
            i = this.iTB.length;
            continue;
            localException1 = localException1;
            ae.printErrStackTrace("MicroMsg.Mp4Parser2", localException1, "", new Object[0]);
            k = i;
          }
        }
        catch (Exception localException2)
        {
          for (;;)
          {
            ae.printErrStackTrace("MicroMsg.Mp4Parser2", localException2, "", new Object[0]);
          }
        }
      }
    }
    if (this.iTB[i] < l2) {
      j = i;
    }
    for (;;)
    {
      i += 1;
      break;
      m = j;
      if (this.iTB[i] > l2) {
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
    //   9: getfield 564	com/tencent/mm/plugin/a/k:randomAccessFile	Ljava/io/RandomAccessFile;
    //   12: astore_1
    //   13: aload_1
    //   14: ifnull +110 -> 124
    //   17: ldc 100
    //   19: ldc_w 676
    //   22: iconst_0
    //   23: anewarray 4	java/lang/Object
    //   26: invokestatic 679	com/tencent/mm/sdk/platformtools/ae:m	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   29: aload_0
    //   30: getfield 564	com/tencent/mm/plugin/a/k:randomAccessFile	Ljava/io/RandomAccessFile;
    //   33: invokevirtual 682	java/io/RandomAccessFile:close	()V
    //   36: aload_0
    //   37: aconst_null
    //   38: putfield 564	com/tencent/mm/plugin/a/k:randomAccessFile	Ljava/io/RandomAccessFile;
    //   41: aload_0
    //   42: iconst_0
    //   43: putfield 71	com/tencent/mm/plugin/a/k:iTP	I
    //   46: aload_0
    //   47: getfield 73	com/tencent/mm/plugin/a/k:iTQ	Ljava/util/ArrayList;
    //   50: invokevirtual 582	java/util/ArrayList:clear	()V
    //   53: aload_0
    //   54: aconst_null
    //   55: putfield 63	com/tencent/mm/plugin/a/k:iTL	Lcom/tencent/mm/plugin/a/o;
    //   58: aload_0
    //   59: aconst_null
    //   60: putfield 67	com/tencent/mm/plugin/a/k:iTN	Lcom/tencent/mm/plugin/a/o;
    //   63: aload_0
    //   64: aconst_null
    //   65: putfield 564	com/tencent/mm/plugin/a/k:randomAccessFile	Ljava/io/RandomAccessFile;
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
    //   88: invokestatic 520	com/tencent/mm/sdk/platformtools/ae:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   91: aload_0
    //   92: aconst_null
    //   93: putfield 564	com/tencent/mm/plugin/a/k:randomAccessFile	Ljava/io/RandomAccessFile;
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
    //   113: putfield 564	com/tencent/mm/plugin/a/k:randomAccessFile	Ljava/io/RandomAccessFile;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.a.k
 * JD-Core Version:    0.7.0.1
 */