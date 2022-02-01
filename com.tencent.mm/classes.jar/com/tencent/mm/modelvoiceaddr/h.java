package com.tencent.mm.modelvoiceaddr;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.cmf;
import com.tencent.mm.protocal.protobuf.dlb;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public final class h
{
  String hEH;
  LinkedHashMap<String, a> hEI;
  final ReadWriteLock hEJ;
  private StringBuilder hEK;
  
  public h(String paramString)
  {
    AppMethodBeat.i(148591);
    this.hEJ = new ReentrantReadWriteLock();
    this.hEK = new StringBuilder();
    this.hEI = new LinkedHashMap();
    this.hEH = paramString;
    AppMethodBeat.o(148591);
  }
  
  public final boolean a(h paramh)
  {
    AppMethodBeat.i(148599);
    this.hEJ.readLock().lock();
    Iterator localIterator = this.hEI.values().iterator();
    while (localIterator.hasNext())
    {
      a locala1 = (a)localIterator.next();
      a locala2 = new a(paramh.hEH);
      locala2.hEO = locala1.hEO;
      paramh.hEI.put(locala2.hEL, locala2);
    }
    this.hEJ.readLock().unlock();
    AppMethodBeat.o(148599);
    return true;
  }
  
  public final void aB(List<dlb> paramList)
  {
    AppMethodBeat.i(148595);
    int i;
    Object localObject;
    if (paramList == null)
    {
      i = 0;
      this.hEJ.readLock().lock();
      if (this.hEI.size() != 0) {
        break label112;
      }
      this.hEJ.readLock().unlock();
      localObject = "[]";
    }
    for (;;)
    {
      ad.d("MicroMsg.ShortSentenceContainer", "updateVoiceInfoResult respVTList size %s innerContainer %s", new Object[] { Integer.valueOf(i), localObject });
      if ((paramList != null) && (paramList.size() != 0)) {
        break label259;
      }
      ad.i("MicroMsg.ShortSentenceContainer", "respList == null");
      AppMethodBeat.o(148595);
      return;
      i = paramList.size();
      break;
      label112:
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[");
      localIterator = this.hEI.values().iterator();
      while (localIterator.hasNext()) {
        ((StringBuilder)localObject).append(((a)localIterator.next()).hEL).append(", ");
      }
      if (((StringBuilder)localObject).length() <= 3)
      {
        this.hEJ.readLock().unlock();
        localObject = "]";
      }
      else
      {
        ((StringBuilder)localObject).setLength(((StringBuilder)localObject).length() - 2);
        this.hEJ.readLock().unlock();
        localObject = "]";
      }
    }
    label259:
    this.hEJ.readLock().lock();
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      dlb localdlb = (dlb)localIterator.next();
      if (localdlb == null)
      {
        ad.i("MicroMsg.ShortSentenceContainer", "setFetchedVoiceInfoResult voiceTransCell is null.");
      }
      else
      {
        a locala = (a)this.hEI.get(localdlb.CLB);
        if (locala == null)
        {
          ad.i("MicroMsg.ShortSentenceContainer", "voiceInfoContainer not found the voiceId %s", new Object[] { localdlb.CLB });
        }
        else if (localdlb == null)
        {
          ad.d("MicroMsg.ShortSentenceContainer", "update VoiceInfo cell is null");
        }
        else
        {
          String str1 = localdlb.CLB;
          i = localdlb.EAL;
          label411:
          boolean bool1;
          label422:
          int j;
          String str2;
          boolean bool2;
          boolean bool3;
          int k;
          int m;
          if ((localdlb.ExG == null) || (localdlb.ExG.getBuffer() == null))
          {
            paramList = null;
            if (localdlb.hno == 0) {
              break label622;
            }
            bool1 = true;
            j = localdlb.hno;
            str2 = locala.hEL;
            bool2 = locala.hEM;
            bool3 = locala.hEN;
            k = locala.hEO;
            m = locala.hEQ;
            if (locala.data != null) {
              break label628;
            }
          }
          label622:
          label628:
          for (localObject = null;; localObject = Integer.valueOf(locala.data.length()))
          {
            ad.d("MicroMsg.ShortSentenceContainer", "update VoiceInfo get {cell} %s, seq %s, text %s, endFlag %s, endFlag %s {currentInfo} %s, isRequestStart %s, isRequestEnd %s, voiceFileMark %s, seq %s, data %s, isResponseEnd %s", new Object[] { str1, Integer.valueOf(i), paramList, Boolean.valueOf(bool1), Integer.valueOf(j), str2, Boolean.valueOf(bool2), Boolean.valueOf(bool3), Integer.valueOf(k), Integer.valueOf(m), localObject, Boolean.valueOf(locala.hER) });
            if ((localdlb.EAL >= locala.hEQ) && (!locala.hER)) {
              break label644;
            }
            ad.d("MicroMsg.ShortSentenceContainer", "update seq not fit.");
            break;
            paramList = Integer.valueOf(localdlb.ExG.getILen());
            break label411;
            bool1 = false;
            break label422;
          }
          label644:
          locala.hEQ = localdlb.EAL;
          if ((localdlb.ExG == null) || (localdlb.ExG.getBuffer() == null))
          {
            paramList = null;
            label675:
            locala.data = paramList;
            if (localdlb.hno == 0) {
              break label811;
            }
            bool1 = true;
            label692:
            locala.hER = bool1;
            paramList = localdlb.CLB;
            j = locala.hEQ;
            bool1 = locala.hER;
            if (locala.data != null) {
              break label817;
            }
          }
          label811:
          label817:
          for (i = -1;; i = locala.data.length())
          {
            ad.i("MicroMsg.ShortSentenceContainer", "update VoiceId = %s,respSeq = %s,isResponseEnd = %s,data.length = %s", new Object[] { paramList, Integer.valueOf(j), Boolean.valueOf(bool1), Integer.valueOf(i) });
            if (localdlb.hno != 2) {
              break;
            }
            ad.e("MicroMsg.ShortSentenceContainer", "update cell.EndFlag = 2 VoiceId = %s", new Object[] { localdlb.CLB });
            break;
            paramList = localdlb.ExG.getBuffer().eBA();
            break label675;
            bool1 = false;
            break label692;
          }
        }
      }
    }
    this.hEJ.readLock().unlock();
    AppMethodBeat.o(148595);
  }
  
  public final LinkedList<cmf> aDV()
  {
    AppMethodBeat.i(148592);
    LinkedList localLinkedList = new LinkedList();
    this.hEJ.readLock().lock();
    Iterator localIterator = this.hEI.values().iterator();
    while (localIterator.hasNext())
    {
      a locala = (a)localIterator.next();
      if (locala.hEM) {
        localLinkedList.add(new cmf().aEE(locala.hEL));
      }
    }
    this.hEJ.readLock().unlock();
    AppMethodBeat.o(148592);
    return localLinkedList;
  }
  
  public final boolean aDW()
  {
    AppMethodBeat.i(148594);
    this.hEJ.readLock().lock();
    if (this.hEI.size() == 0)
    {
      ad.i("MicroMsg.ShortSentenceContainer", "isAllRespEnd innerContainer.size() == 0");
      this.hEJ.readLock().unlock();
      AppMethodBeat.o(148594);
      return true;
    }
    Iterator localIterator = this.hEI.values().iterator();
    a locala;
    do
    {
      if (!localIterator.hasNext()) {
        break;
      }
      locala = (a)localIterator.next();
      ad.d("MicroMsg.ShortSentenceContainer", "isAllRespEnd voiceId:%s isRequestEnd:%s isResponseEnd:%s", new Object[] { locala.hEL, Boolean.valueOf(locala.hEN), Boolean.valueOf(locala.hER) });
    } while (locala.hER);
    for (boolean bool = false;; bool = true)
    {
      this.hEJ.readLock().unlock();
      AppMethodBeat.o(148594);
      return bool;
    }
  }
  
  public final void aDX()
  {
    AppMethodBeat.i(148597);
    ad.i("MicroMsg.ShortSentenceContainer", "createNewShortSentence");
    this.hEJ.writeLock().lock();
    a locala = new a();
    this.hEI.put(locala.hEL, locala);
    this.hEJ.writeLock().unlock();
    AppMethodBeat.o(148597);
  }
  
  public final String getResult()
  {
    AppMethodBeat.i(148593);
    this.hEK.setLength(0);
    this.hEJ.readLock().lock();
    Object localObject = this.hEI.values().iterator();
    while (((Iterator)localObject).hasNext())
    {
      a locala = (a)((Iterator)localObject).next();
      if (locala.data != null) {
        this.hEK.append(locala.data);
      }
    }
    this.hEJ.readLock().unlock();
    localObject = this.hEK.toString();
    AppMethodBeat.o(148593);
    return localObject;
  }
  
  public final boolean isValid()
  {
    AppMethodBeat.i(185490);
    if ((this.hEI == null) || (this.hEI.isEmpty()))
    {
      AppMethodBeat.o(185490);
      return false;
    }
    AppMethodBeat.o(185490);
    return true;
  }
  
  public final void pc(int paramInt)
  {
    AppMethodBeat.i(148596);
    ad.i("MicroMsg.ShortSentenceContainer", "cutShortSentence markEnd:%s", new Object[] { Integer.valueOf(paramInt) });
    if (paramInt < 0)
    {
      localObject = new IllegalStateException("splitShortSentence file mark less than zero. mark: ".concat(String.valueOf(paramInt)));
      AppMethodBeat.o(148596);
      throw ((Throwable)localObject);
    }
    this.hEJ.readLock().lock();
    if (this.hEI.size() == 0)
    {
      ad.e("MicroMsg.ShortSentenceContainer", "splitShortSentence there is no last one");
      this.hEJ.readLock().unlock();
      AppMethodBeat.o(148596);
      return;
    }
    Iterator localIterator = this.hEI.values().iterator();
    for (Object localObject = null; localIterator.hasNext(); localObject = (a)localIterator.next()) {}
    if (localObject == null)
    {
      localObject = new IllegalStateException("splitShortSentence last info is null");
      AppMethodBeat.o(148596);
      throw ((Throwable)localObject);
    }
    ad.d("MicroMsg.ShortSentenceContainer", "cutShortSentence voiceFileMarkEnd:%s voiceId:%s markEnd:%s", new Object[] { Integer.valueOf(((a)localObject).hEO), ((a)localObject).hEL, Integer.valueOf(paramInt) });
    ((a)localObject).hEO = paramInt;
    this.hEJ.readLock().unlock();
    AppMethodBeat.o(148596);
  }
  
  public final a pd(int paramInt)
  {
    AppMethodBeat.i(148598);
    this.hEJ.readLock().lock();
    if (this.hEI.size() == 0)
    {
      this.hEJ.readLock().unlock();
      AppMethodBeat.o(148598);
      return null;
    }
    Iterator localIterator = this.hEI.values().iterator();
    a locala;
    do
    {
      if (!localIterator.hasNext()) {
        break;
      }
      locala = (a)localIterator.next();
      ad.d("MicroMsg.ShortSentenceContainer", "locateCurrentShortSentence oldOffset = %s voiceFileMarkEnd = %s info.isRequestEnd = %s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(locala.hEO), Boolean.valueOf(locala.hEN) });
    } while ((locala.hEN) || (paramInt > locala.hEO));
    for (;;)
    {
      this.hEJ.readLock().unlock();
      AppMethodBeat.o(148598);
      return locala;
      locala = null;
    }
  }
  
  public final class a
  {
    public String data;
    public String hEL;
    public boolean hEM;
    public boolean hEN;
    public int hEO;
    public int hEP;
    public int hEQ;
    public boolean hER;
    
    public a()
    {
      AppMethodBeat.i(148588);
      this.hEM = false;
      this.hEN = false;
      this.hEO = 2147483647;
      this.hEP = 0;
      this.hEQ = -1;
      this.data = null;
      this.hER = false;
      this.hEL = AK(h.this.hEH);
      AppMethodBeat.o(148588);
    }
    
    public a(String paramString)
    {
      AppMethodBeat.i(148589);
      this.hEM = false;
      this.hEN = false;
      this.hEO = 2147483647;
      this.hEP = 0;
      this.hEQ = -1;
      this.data = null;
      this.hER = false;
      this.hEL = AK(paramString);
      AppMethodBeat.o(148589);
    }
    
    private static String AK(String paramString)
    {
      AppMethodBeat.i(148590);
      long l3 = 0xFFFFFFFF & System.currentTimeMillis();
      long l4 = 0xFFFFFFFF & new Random(System.currentTimeMillis()).nextInt();
      long l2 = l3 << 32 | l4;
      long l1 = l2;
      if (l2 < 0L) {
        l1 = Math.abs(l2);
      }
      String str = paramString + l1;
      ad.i("MicroMsg.ShortSentenceContainer", "finally random = %s(%s) time = %s(%s) id = %s(%s) session = %s strId = %s", new Object[] { Long.valueOf(l4), Long.toBinaryString(l4), Long.valueOf(l3), Long.toBinaryString(l3), Long.valueOf(l1), Long.toBinaryString(l1), paramString, str });
      AppMethodBeat.o(148590);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.modelvoiceaddr.h
 * JD-Core Version:    0.7.0.1
 */