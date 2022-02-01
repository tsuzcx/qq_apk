package com.tencent.mm.modelvoiceaddr;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.b;
import com.tencent.mm.protocal.protobuf.eae;
import com.tencent.mm.protocal.protobuf.eaf;
import com.tencent.mm.protocal.protobuf.fcv;
import com.tencent.mm.sdk.platformtools.Log;
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
  String mmo;
  LinkedHashMap<String, a> mmp;
  final ReadWriteLock mmq;
  private StringBuilder mmr;
  
  public h(String paramString)
  {
    AppMethodBeat.i(148591);
    this.mmq = new ReentrantReadWriteLock();
    this.mmr = new StringBuilder();
    this.mmp = new LinkedHashMap();
    this.mmo = paramString;
    AppMethodBeat.o(148591);
  }
  
  public final boolean a(h paramh)
  {
    AppMethodBeat.i(148599);
    this.mmq.readLock().lock();
    Iterator localIterator = this.mmp.values().iterator();
    while (localIterator.hasNext())
    {
      a locala1 = (a)localIterator.next();
      a locala2 = new a(paramh.mmo);
      locala2.mmv = locala1.mmv;
      paramh.mmp.put(locala2.mms, locala2);
    }
    this.mmq.readLock().unlock();
    AppMethodBeat.o(148599);
    return true;
  }
  
  public final void aG(List<fcv> paramList)
  {
    AppMethodBeat.i(148595);
    int i;
    Object localObject;
    if (paramList == null)
    {
      i = 0;
      this.mmq.readLock().lock();
      if (this.mmp.size() != 0) {
        break label112;
      }
      this.mmq.readLock().unlock();
      localObject = "[]";
    }
    for (;;)
    {
      Log.d("MicroMsg.ShortSentenceContainer", "updateVoiceInfoResult respVTList size %s innerContainer %s", new Object[] { Integer.valueOf(i), localObject });
      if ((paramList != null) && (paramList.size() != 0)) {
        break label259;
      }
      Log.i("MicroMsg.ShortSentenceContainer", "respList == null");
      AppMethodBeat.o(148595);
      return;
      i = paramList.size();
      break;
      label112:
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[");
      localIterator = this.mmp.values().iterator();
      while (localIterator.hasNext()) {
        ((StringBuilder)localObject).append(((a)localIterator.next()).mms).append(", ");
      }
      if (((StringBuilder)localObject).length() <= 3)
      {
        this.mmq.readLock().unlock();
        localObject = "]";
      }
      else
      {
        ((StringBuilder)localObject).setLength(((StringBuilder)localObject).length() - 2);
        this.mmq.readLock().unlock();
        localObject = "]";
      }
    }
    label259:
    this.mmq.readLock().lock();
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      fcv localfcv = (fcv)localIterator.next();
      if (localfcv == null)
      {
        Log.i("MicroMsg.ShortSentenceContainer", "setFetchedVoiceInfoResult voiceTransCell is null.");
      }
      else
      {
        a locala = (a)this.mmp.get(localfcv.RYD);
        if (locala == null)
        {
          Log.i("MicroMsg.ShortSentenceContainer", "voiceInfoContainer not found the voiceId %s", new Object[] { localfcv.RYD });
        }
        else if (localfcv == null)
        {
          Log.d("MicroMsg.ShortSentenceContainer", "update VoiceInfo cell is null");
        }
        else
        {
          String str1 = localfcv.RYD;
          i = localfcv.UCw;
          label411:
          boolean bool1;
          label422:
          int j;
          String str2;
          boolean bool2;
          boolean bool3;
          int k;
          int m;
          if ((localfcv.Uyb == null) || (localfcv.Uyb.Tkb == null))
          {
            paramList = null;
            if (localfcv.lVs == 0) {
              break label622;
            }
            bool1 = true;
            j = localfcv.lVs;
            str2 = locala.mms;
            bool2 = locala.mmt;
            bool3 = locala.mmu;
            k = locala.mmv;
            m = locala.mmx;
            if (locala.data != null) {
              break label628;
            }
          }
          label622:
          label628:
          for (localObject = null;; localObject = Integer.valueOf(locala.data.length()))
          {
            Log.d("MicroMsg.ShortSentenceContainer", "update VoiceInfo get {cell} %s, seq %s, text %s, endFlag %s, endFlag %s {currentInfo} %s, isRequestStart %s, isRequestEnd %s, voiceFileMark %s, seq %s, data %s, isResponseEnd %s", new Object[] { str1, Integer.valueOf(i), paramList, Boolean.valueOf(bool1), Integer.valueOf(j), str2, Boolean.valueOf(bool2), Boolean.valueOf(bool3), Integer.valueOf(k), Integer.valueOf(m), localObject, Boolean.valueOf(locala.mmy) });
            if ((localfcv.UCw >= locala.mmx) && (!locala.mmy)) {
              break label644;
            }
            Log.d("MicroMsg.ShortSentenceContainer", "update seq not fit.");
            break;
            paramList = Integer.valueOf(localfcv.Uyb.Ufv);
            break label411;
            bool1 = false;
            break label422;
          }
          label644:
          locala.mmx = localfcv.UCw;
          if ((localfcv.Uyb == null) || (localfcv.Uyb.Tkb == null))
          {
            paramList = null;
            label675:
            locala.data = paramList;
            if (localfcv.lVs == 0) {
              break label811;
            }
            bool1 = true;
            label692:
            locala.mmy = bool1;
            paramList = localfcv.RYD;
            j = locala.mmx;
            bool1 = locala.mmy;
            if (locala.data != null) {
              break label817;
            }
          }
          label811:
          label817:
          for (i = -1;; i = locala.data.length())
          {
            Log.i("MicroMsg.ShortSentenceContainer", "update VoiceId = %s,respSeq = %s,isResponseEnd = %s,data.length = %s", new Object[] { paramList, Integer.valueOf(j), Boolean.valueOf(bool1), Integer.valueOf(i) });
            if (localfcv.lVs != 2) {
              break;
            }
            Log.e("MicroMsg.ShortSentenceContainer", "update cell.EndFlag = 2 VoiceId = %s", new Object[] { localfcv.RYD });
            break;
            paramList = localfcv.Uyb.Tkb.Ap();
            break label675;
            bool1 = false;
            break label692;
          }
        }
      }
    }
    this.mmq.readLock().unlock();
    AppMethodBeat.o(148595);
  }
  
  public final LinkedList<eaf> brY()
  {
    AppMethodBeat.i(148592);
    LinkedList localLinkedList = new LinkedList();
    this.mmq.readLock().lock();
    Iterator localIterator = this.mmp.values().iterator();
    while (localIterator.hasNext())
    {
      a locala = (a)localIterator.next();
      if (locala.mmt) {
        localLinkedList.add(new eaf().btQ(locala.mms));
      }
    }
    this.mmq.readLock().unlock();
    AppMethodBeat.o(148592);
    return localLinkedList;
  }
  
  public final boolean brZ()
  {
    AppMethodBeat.i(148594);
    this.mmq.readLock().lock();
    if (this.mmp.size() == 0)
    {
      Log.i("MicroMsg.ShortSentenceContainer", "isAllRespEnd innerContainer.size() == 0");
      this.mmq.readLock().unlock();
      AppMethodBeat.o(148594);
      return true;
    }
    Iterator localIterator = this.mmp.values().iterator();
    a locala;
    do
    {
      if (!localIterator.hasNext()) {
        break;
      }
      locala = (a)localIterator.next();
      Log.d("MicroMsg.ShortSentenceContainer", "isAllRespEnd voiceId:%s isRequestEnd:%s isResponseEnd:%s", new Object[] { locala.mms, Boolean.valueOf(locala.mmu), Boolean.valueOf(locala.mmy) });
    } while (locala.mmy);
    for (boolean bool = false;; bool = true)
    {
      this.mmq.readLock().unlock();
      AppMethodBeat.o(148594);
      return bool;
    }
  }
  
  public final void bsa()
  {
    AppMethodBeat.i(148597);
    Log.i("MicroMsg.ShortSentenceContainer", "createNewShortSentence");
    this.mmq.writeLock().lock();
    a locala = new a();
    this.mmp.put(locala.mms, locala);
    this.mmq.writeLock().unlock();
    AppMethodBeat.o(148597);
  }
  
  public final String getResult()
  {
    AppMethodBeat.i(148593);
    this.mmr.setLength(0);
    this.mmq.readLock().lock();
    Object localObject = this.mmp.values().iterator();
    while (((Iterator)localObject).hasNext())
    {
      a locala = (a)((Iterator)localObject).next();
      if (locala.data != null) {
        this.mmr.append(locala.data);
      }
    }
    this.mmq.readLock().unlock();
    localObject = this.mmr.toString();
    AppMethodBeat.o(148593);
    return localObject;
  }
  
  public final boolean isValid()
  {
    AppMethodBeat.i(185490);
    if ((this.mmp == null) || (this.mmp.isEmpty()))
    {
      AppMethodBeat.o(185490);
      return false;
    }
    AppMethodBeat.o(185490);
    return true;
  }
  
  public final void xl(int paramInt)
  {
    AppMethodBeat.i(148596);
    Log.i("MicroMsg.ShortSentenceContainer", "cutShortSentence markEnd:%s", new Object[] { Integer.valueOf(paramInt) });
    if (paramInt < 0)
    {
      localObject = new IllegalStateException("splitShortSentence file mark less than zero. mark: ".concat(String.valueOf(paramInt)));
      AppMethodBeat.o(148596);
      throw ((Throwable)localObject);
    }
    this.mmq.readLock().lock();
    if (this.mmp.size() == 0)
    {
      Log.e("MicroMsg.ShortSentenceContainer", "splitShortSentence there is no last one");
      this.mmq.readLock().unlock();
      AppMethodBeat.o(148596);
      return;
    }
    Iterator localIterator = this.mmp.values().iterator();
    for (Object localObject = null; localIterator.hasNext(); localObject = (a)localIterator.next()) {}
    if (localObject == null)
    {
      localObject = new IllegalStateException("splitShortSentence last info is null");
      AppMethodBeat.o(148596);
      throw ((Throwable)localObject);
    }
    Log.d("MicroMsg.ShortSentenceContainer", "cutShortSentence voiceFileMarkEnd:%s voiceId:%s markEnd:%s", new Object[] { Integer.valueOf(((a)localObject).mmv), ((a)localObject).mms, Integer.valueOf(paramInt) });
    ((a)localObject).mmv = paramInt;
    this.mmq.readLock().unlock();
    AppMethodBeat.o(148596);
  }
  
  public final a xm(int paramInt)
  {
    AppMethodBeat.i(148598);
    this.mmq.readLock().lock();
    if (this.mmp.size() == 0)
    {
      this.mmq.readLock().unlock();
      AppMethodBeat.o(148598);
      return null;
    }
    Iterator localIterator = this.mmp.values().iterator();
    a locala;
    do
    {
      if (!localIterator.hasNext()) {
        break;
      }
      locala = (a)localIterator.next();
      Log.d("MicroMsg.ShortSentenceContainer", "locateCurrentShortSentence oldOffset = %s voiceFileMarkEnd = %s info.isRequestEnd = %s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(locala.mmv), Boolean.valueOf(locala.mmu) });
    } while ((locala.mmu) || (paramInt > locala.mmv));
    for (;;)
    {
      this.mmq.readLock().unlock();
      AppMethodBeat.o(148598);
      return locala;
      locala = null;
    }
  }
  
  public final class a
  {
    public String data;
    public String mms;
    public boolean mmt;
    public boolean mmu;
    public int mmv;
    public int mmw;
    public int mmx;
    public boolean mmy;
    
    public a()
    {
      AppMethodBeat.i(148588);
      this.mmt = false;
      this.mmu = false;
      this.mmv = 2147483647;
      this.mmw = 0;
      this.mmx = -1;
      this.data = null;
      this.mmy = false;
      this.mms = YP(h.this.mmo);
      AppMethodBeat.o(148588);
    }
    
    public a(String paramString)
    {
      AppMethodBeat.i(148589);
      this.mmt = false;
      this.mmu = false;
      this.mmv = 2147483647;
      this.mmw = 0;
      this.mmx = -1;
      this.data = null;
      this.mmy = false;
      this.mms = YP(paramString);
      AppMethodBeat.o(148589);
    }
    
    private static String YP(String paramString)
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
      Log.i("MicroMsg.ShortSentenceContainer", "finally random = %s(%s) time = %s(%s) id = %s(%s) session = %s strId = %s", new Object[] { Long.valueOf(l4), Long.toBinaryString(l4), Long.valueOf(l3), Long.toBinaryString(l3), Long.valueOf(l1), Long.toBinaryString(l1), paramString, str });
      AppMethodBeat.o(148590);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.modelvoiceaddr.h
 * JD-Core Version:    0.7.0.1
 */