package com.tencent.mm.modelvoiceaddr;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.dqi;
import com.tencent.mm.protocal.protobuf.esk;
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
  String jwL;
  LinkedHashMap<String, a> jwM;
  final ReadWriteLock jwN;
  private StringBuilder jwO;
  
  public h(String paramString)
  {
    AppMethodBeat.i(148591);
    this.jwN = new ReentrantReadWriteLock();
    this.jwO = new StringBuilder();
    this.jwM = new LinkedHashMap();
    this.jwL = paramString;
    AppMethodBeat.o(148591);
  }
  
  public final boolean a(h paramh)
  {
    AppMethodBeat.i(148599);
    this.jwN.readLock().lock();
    Iterator localIterator = this.jwM.values().iterator();
    while (localIterator.hasNext())
    {
      a locala1 = (a)localIterator.next();
      a locala2 = new a(paramh.jwL);
      locala2.jwS = locala1.jwS;
      paramh.jwM.put(locala2.jwP, locala2);
    }
    this.jwN.readLock().unlock();
    AppMethodBeat.o(148599);
    return true;
  }
  
  public final void aI(List<esk> paramList)
  {
    AppMethodBeat.i(148595);
    int i;
    Object localObject;
    if (paramList == null)
    {
      i = 0;
      this.jwN.readLock().lock();
      if (this.jwM.size() != 0) {
        break label112;
      }
      this.jwN.readLock().unlock();
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
      localIterator = this.jwM.values().iterator();
      while (localIterator.hasNext()) {
        ((StringBuilder)localObject).append(((a)localIterator.next()).jwP).append(", ");
      }
      if (((StringBuilder)localObject).length() <= 3)
      {
        this.jwN.readLock().unlock();
        localObject = "]";
      }
      else
      {
        ((StringBuilder)localObject).setLength(((StringBuilder)localObject).length() - 2);
        this.jwN.readLock().unlock();
        localObject = "]";
      }
    }
    label259:
    this.jwN.readLock().lock();
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      esk localesk = (esk)localIterator.next();
      if (localesk == null)
      {
        Log.i("MicroMsg.ShortSentenceContainer", "setFetchedVoiceInfoResult voiceTransCell is null.");
      }
      else
      {
        a locala = (a)this.jwM.get(localesk.KXr);
        if (locala == null)
        {
          Log.i("MicroMsg.ShortSentenceContainer", "voiceInfoContainer not found the voiceId %s", new Object[] { localesk.KXr });
        }
        else if (localesk == null)
        {
          Log.d("MicroMsg.ShortSentenceContainer", "update VoiceInfo cell is null");
        }
        else
        {
          String str1 = localesk.KXr;
          i = localesk.NpA;
          label411:
          boolean bool1;
          label422:
          int j;
          String str2;
          boolean bool2;
          boolean bool3;
          int k;
          int m;
          if ((localesk.Nlq == null) || (localesk.Nlq.getBuffer() == null))
          {
            paramList = null;
            if (localesk.jeU == 0) {
              break label622;
            }
            bool1 = true;
            j = localesk.jeU;
            str2 = locala.jwP;
            bool2 = locala.jwQ;
            bool3 = locala.jwR;
            k = locala.jwS;
            m = locala.jwU;
            if (locala.data != null) {
              break label628;
            }
          }
          label622:
          label628:
          for (localObject = null;; localObject = Integer.valueOf(locala.data.length()))
          {
            Log.d("MicroMsg.ShortSentenceContainer", "update VoiceInfo get {cell} %s, seq %s, text %s, endFlag %s, endFlag %s {currentInfo} %s, isRequestStart %s, isRequestEnd %s, voiceFileMark %s, seq %s, data %s, isResponseEnd %s", new Object[] { str1, Integer.valueOf(i), paramList, Boolean.valueOf(bool1), Integer.valueOf(j), str2, Boolean.valueOf(bool2), Boolean.valueOf(bool3), Integer.valueOf(k), Integer.valueOf(m), localObject, Boolean.valueOf(locala.jwV) });
            if ((localesk.NpA >= locala.jwU) && (!locala.jwV)) {
              break label644;
            }
            Log.d("MicroMsg.ShortSentenceContainer", "update seq not fit.");
            break;
            paramList = Integer.valueOf(localesk.Nlq.getILen());
            break label411;
            bool1 = false;
            break label422;
          }
          label644:
          locala.jwU = localesk.NpA;
          if ((localesk.Nlq == null) || (localesk.Nlq.getBuffer() == null))
          {
            paramList = null;
            label675:
            locala.data = paramList;
            if (localesk.jeU == 0) {
              break label811;
            }
            bool1 = true;
            label692:
            locala.jwV = bool1;
            paramList = localesk.KXr;
            j = locala.jwU;
            bool1 = locala.jwV;
            if (locala.data != null) {
              break label817;
            }
          }
          label811:
          label817:
          for (i = -1;; i = locala.data.length())
          {
            Log.i("MicroMsg.ShortSentenceContainer", "update VoiceId = %s,respSeq = %s,isResponseEnd = %s,data.length = %s", new Object[] { paramList, Integer.valueOf(j), Boolean.valueOf(bool1), Integer.valueOf(i) });
            if (localesk.jeU != 2) {
              break;
            }
            Log.e("MicroMsg.ShortSentenceContainer", "update cell.EndFlag = 2 VoiceId = %s", new Object[] { localesk.KXr });
            break;
            paramList = localesk.Nlq.getBuffer().yO();
            break label675;
            bool1 = false;
            break label692;
          }
        }
      }
    }
    this.jwN.readLock().unlock();
    AppMethodBeat.o(148595);
  }
  
  public final LinkedList<dqi> biA()
  {
    AppMethodBeat.i(148592);
    LinkedList localLinkedList = new LinkedList();
    this.jwN.readLock().lock();
    Iterator localIterator = this.jwM.values().iterator();
    while (localIterator.hasNext())
    {
      a locala = (a)localIterator.next();
      if (locala.jwQ) {
        localLinkedList.add(new dqi().bhy(locala.jwP));
      }
    }
    this.jwN.readLock().unlock();
    AppMethodBeat.o(148592);
    return localLinkedList;
  }
  
  public final boolean biB()
  {
    AppMethodBeat.i(148594);
    this.jwN.readLock().lock();
    if (this.jwM.size() == 0)
    {
      Log.i("MicroMsg.ShortSentenceContainer", "isAllRespEnd innerContainer.size() == 0");
      this.jwN.readLock().unlock();
      AppMethodBeat.o(148594);
      return true;
    }
    Iterator localIterator = this.jwM.values().iterator();
    a locala;
    do
    {
      if (!localIterator.hasNext()) {
        break;
      }
      locala = (a)localIterator.next();
      Log.d("MicroMsg.ShortSentenceContainer", "isAllRespEnd voiceId:%s isRequestEnd:%s isResponseEnd:%s", new Object[] { locala.jwP, Boolean.valueOf(locala.jwR), Boolean.valueOf(locala.jwV) });
    } while (locala.jwV);
    for (boolean bool = false;; bool = true)
    {
      this.jwN.readLock().unlock();
      AppMethodBeat.o(148594);
      return bool;
    }
  }
  
  public final void biC()
  {
    AppMethodBeat.i(148597);
    Log.i("MicroMsg.ShortSentenceContainer", "createNewShortSentence");
    this.jwN.writeLock().lock();
    a locala = new a();
    this.jwM.put(locala.jwP, locala);
    this.jwN.writeLock().unlock();
    AppMethodBeat.o(148597);
  }
  
  public final String getResult()
  {
    AppMethodBeat.i(148593);
    this.jwO.setLength(0);
    this.jwN.readLock().lock();
    Object localObject = this.jwM.values().iterator();
    while (((Iterator)localObject).hasNext())
    {
      a locala = (a)((Iterator)localObject).next();
      if (locala.data != null) {
        this.jwO.append(locala.data);
      }
    }
    this.jwN.readLock().unlock();
    localObject = this.jwO.toString();
    AppMethodBeat.o(148593);
    return localObject;
  }
  
  public final boolean isValid()
  {
    AppMethodBeat.i(185490);
    if ((this.jwM == null) || (this.jwM.isEmpty()))
    {
      AppMethodBeat.o(185490);
      return false;
    }
    AppMethodBeat.o(185490);
    return true;
  }
  
  public final void ul(int paramInt)
  {
    AppMethodBeat.i(148596);
    Log.i("MicroMsg.ShortSentenceContainer", "cutShortSentence markEnd:%s", new Object[] { Integer.valueOf(paramInt) });
    if (paramInt < 0)
    {
      localObject = new IllegalStateException("splitShortSentence file mark less than zero. mark: ".concat(String.valueOf(paramInt)));
      AppMethodBeat.o(148596);
      throw ((Throwable)localObject);
    }
    this.jwN.readLock().lock();
    if (this.jwM.size() == 0)
    {
      Log.e("MicroMsg.ShortSentenceContainer", "splitShortSentence there is no last one");
      this.jwN.readLock().unlock();
      AppMethodBeat.o(148596);
      return;
    }
    Iterator localIterator = this.jwM.values().iterator();
    for (Object localObject = null; localIterator.hasNext(); localObject = (a)localIterator.next()) {}
    if (localObject == null)
    {
      localObject = new IllegalStateException("splitShortSentence last info is null");
      AppMethodBeat.o(148596);
      throw ((Throwable)localObject);
    }
    Log.d("MicroMsg.ShortSentenceContainer", "cutShortSentence voiceFileMarkEnd:%s voiceId:%s markEnd:%s", new Object[] { Integer.valueOf(((a)localObject).jwS), ((a)localObject).jwP, Integer.valueOf(paramInt) });
    ((a)localObject).jwS = paramInt;
    this.jwN.readLock().unlock();
    AppMethodBeat.o(148596);
  }
  
  public final a um(int paramInt)
  {
    AppMethodBeat.i(148598);
    this.jwN.readLock().lock();
    if (this.jwM.size() == 0)
    {
      this.jwN.readLock().unlock();
      AppMethodBeat.o(148598);
      return null;
    }
    Iterator localIterator = this.jwM.values().iterator();
    a locala;
    do
    {
      if (!localIterator.hasNext()) {
        break;
      }
      locala = (a)localIterator.next();
      Log.d("MicroMsg.ShortSentenceContainer", "locateCurrentShortSentence oldOffset = %s voiceFileMarkEnd = %s info.isRequestEnd = %s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(locala.jwS), Boolean.valueOf(locala.jwR) });
    } while ((locala.jwR) || (paramInt > locala.jwS));
    for (;;)
    {
      this.jwN.readLock().unlock();
      AppMethodBeat.o(148598);
      return locala;
      locala = null;
    }
  }
  
  public final class a
  {
    public String data;
    public String jwP;
    public boolean jwQ;
    public boolean jwR;
    public int jwS;
    public int jwT;
    public int jwU;
    public boolean jwV;
    
    public a()
    {
      AppMethodBeat.i(148588);
      this.jwQ = false;
      this.jwR = false;
      this.jwS = 2147483647;
      this.jwT = 0;
      this.jwU = -1;
      this.data = null;
      this.jwV = false;
      this.jwP = Rs(h.this.jwL);
      AppMethodBeat.o(148588);
    }
    
    public a(String paramString)
    {
      AppMethodBeat.i(148589);
      this.jwQ = false;
      this.jwR = false;
      this.jwS = 2147483647;
      this.jwT = 0;
      this.jwU = -1;
      this.data = null;
      this.jwV = false;
      this.jwP = Rs(paramString);
      AppMethodBeat.o(148589);
    }
    
    private static String Rs(String paramString)
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.modelvoiceaddr.h
 * JD-Core Version:    0.7.0.1
 */