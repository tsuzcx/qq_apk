package com.tencent.mm.modelvoiceaddr;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bv.b;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.bwc;
import com.tencent.mm.protocal.protobuf.crg;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public final class h
{
  String gbP;
  public LinkedHashMap<String, h.a> gbQ;
  final ReadWriteLock gbR;
  private StringBuilder gbS;
  
  public h(String paramString)
  {
    AppMethodBeat.i(116747);
    this.gbR = new ReentrantReadWriteLock();
    this.gbS = new StringBuilder();
    this.gbQ = new LinkedHashMap();
    this.gbP = paramString;
    AppMethodBeat.o(116747);
  }
  
  public final boolean a(h paramh)
  {
    AppMethodBeat.i(155554);
    Iterator localIterator = this.gbQ.values().iterator();
    while (localIterator.hasNext())
    {
      h.a locala1 = (h.a)localIterator.next();
      h.a locala2 = new h.a(this, paramh.gbP);
      locala2.gbW = locala1.gbW;
      paramh.gbQ.put(locala2.gbT, locala2);
    }
    AppMethodBeat.o(155554);
    return true;
  }
  
  public final void aj(List<crg> paramList)
  {
    AppMethodBeat.i(116751);
    int i;
    Object localObject;
    if (paramList == null)
    {
      i = 0;
      this.gbR.readLock().lock();
      if (this.gbQ.size() != 0) {
        break label112;
      }
      this.gbR.readLock().unlock();
      localObject = "[]";
    }
    for (;;)
    {
      ab.d("MicroMsg.ShortSentenceContainer", "updateVoiceInfoResult respVTList size %s innerContainer %s", new Object[] { Integer.valueOf(i), localObject });
      if ((paramList != null) && (paramList.size() != 0)) {
        break label259;
      }
      ab.i("MicroMsg.ShortSentenceContainer", "respList == null");
      AppMethodBeat.o(116751);
      return;
      i = paramList.size();
      break;
      label112:
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[");
      localIterator = this.gbQ.values().iterator();
      while (localIterator.hasNext()) {
        ((StringBuilder)localObject).append(((h.a)localIterator.next()).gbT).append(", ");
      }
      if (((StringBuilder)localObject).length() <= 3)
      {
        this.gbR.readLock().unlock();
        localObject = "]";
      }
      else
      {
        ((StringBuilder)localObject).setLength(((StringBuilder)localObject).length() - 2);
        this.gbR.readLock().unlock();
        localObject = "]";
      }
    }
    label259:
    this.gbR.readLock().lock();
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      crg localcrg = (crg)localIterator.next();
      if (localcrg == null)
      {
        ab.i("MicroMsg.ShortSentenceContainer", "setFetchedVoiceInfoResult voiceTransCell is null.");
      }
      else
      {
        h.a locala = (h.a)this.gbQ.get(localcrg.wAs);
        if (locala == null)
        {
          ab.i("MicroMsg.ShortSentenceContainer", "voiceInfoContainer not found the voiceId %s", new Object[] { localcrg.wAs });
        }
        else if (localcrg == null)
        {
          ab.d("MicroMsg.ShortSentenceContainer", "update VoiceInfo cell is null");
        }
        else
        {
          String str1 = localcrg.wAs;
          i = localcrg.xZO;
          label411:
          boolean bool1;
          label422:
          int j;
          String str2;
          boolean bool2;
          boolean bool3;
          int k;
          int m;
          if ((localcrg.xWZ == null) || (localcrg.xWZ.getBuffer() == null))
          {
            paramList = null;
            if (localcrg.fKi == 0) {
              break label622;
            }
            bool1 = true;
            j = localcrg.fKi;
            str2 = locala.gbT;
            bool2 = locala.gbU;
            bool3 = locala.gbV;
            k = locala.gbW;
            m = locala.gbY;
            if (locala.data != null) {
              break label628;
            }
          }
          label622:
          label628:
          for (localObject = null;; localObject = Integer.valueOf(locala.data.length()))
          {
            ab.d("MicroMsg.ShortSentenceContainer", "update VoiceInfo get {cell} %s, seq %s, text %s, endFlag %s, endFlag %s {currentInfo} %s, isRequestStart %s, isRequestEnd %s, voiceFileMark %s, seq %s, data %s, isResponseEnd %s", new Object[] { str1, Integer.valueOf(i), paramList, Boolean.valueOf(bool1), Integer.valueOf(j), str2, Boolean.valueOf(bool2), Boolean.valueOf(bool3), Integer.valueOf(k), Integer.valueOf(m), localObject, Boolean.valueOf(locala.gbZ) });
            if ((localcrg.xZO >= locala.gbY) && (!locala.gbZ)) {
              break label644;
            }
            ab.d("MicroMsg.ShortSentenceContainer", "update seq not fit.");
            break;
            paramList = Integer.valueOf(localcrg.xWZ.getILen());
            break label411;
            bool1 = false;
            break label422;
          }
          label644:
          locala.gbY = localcrg.xZO;
          if ((localcrg.xWZ == null) || (localcrg.xWZ.getBuffer() == null))
          {
            paramList = null;
            label675:
            locala.data = paramList;
            if (localcrg.fKi == 0) {
              break label811;
            }
            bool1 = true;
            label692:
            locala.gbZ = bool1;
            paramList = localcrg.wAs;
            j = locala.gbY;
            bool1 = locala.gbZ;
            if (locala.data != null) {
              break label817;
            }
          }
          label811:
          label817:
          for (i = -1;; i = locala.data.length())
          {
            ab.i("MicroMsg.ShortSentenceContainer", "update VoiceId = %s,respSeq = %s,isResponseEnd = %s,data.length = %s", new Object[] { paramList, Integer.valueOf(j), Boolean.valueOf(bool1), Integer.valueOf(i) });
            if (localcrg.fKi != 2) {
              break;
            }
            ab.e("MicroMsg.ShortSentenceContainer", "update cell.EndFlag = 2 VoiceId = %s", new Object[] { localcrg.wAs });
            break;
            paramList = localcrg.xWZ.getBuffer().dqj();
            break label675;
            bool1 = false;
            break label692;
          }
        }
      }
    }
    this.gbR.readLock().unlock();
    AppMethodBeat.o(116751);
  }
  
  public final LinkedList<bwc> amP()
  {
    AppMethodBeat.i(116748);
    LinkedList localLinkedList = new LinkedList();
    this.gbR.readLock().lock();
    Iterator localIterator = this.gbQ.values().iterator();
    while (localIterator.hasNext())
    {
      h.a locala = (h.a)localIterator.next();
      if (locala.gbU) {
        localLinkedList.add(new bwc().aoF(locala.gbT));
      }
    }
    this.gbR.readLock().unlock();
    AppMethodBeat.o(116748);
    return localLinkedList;
  }
  
  public final boolean amQ()
  {
    AppMethodBeat.i(116750);
    this.gbR.readLock().lock();
    if (this.gbQ.size() == 0)
    {
      ab.i("MicroMsg.ShortSentenceContainer", "isAllRespEnd innerContainer.size() == 0");
      AppMethodBeat.o(116750);
      return false;
    }
    Iterator localIterator = this.gbQ.values().iterator();
    h.a locala;
    do
    {
      if (!localIterator.hasNext()) {
        break;
      }
      locala = (h.a)localIterator.next();
      ab.d("MicroMsg.ShortSentenceContainer", "isAllRespEnd voiceId:%s isRequestEnd:%s isResponseEnd:%s", new Object[] { locala.gbT, Boolean.valueOf(locala.gbV), Boolean.valueOf(locala.gbZ) });
    } while (locala.gbZ);
    for (boolean bool = false;; bool = true)
    {
      this.gbR.readLock().unlock();
      AppMethodBeat.o(116750);
      return bool;
    }
  }
  
  public final void amR()
  {
    AppMethodBeat.i(155553);
    ab.i("MicroMsg.ShortSentenceContainer", "createNewShortSentence");
    this.gbR.writeLock().lock();
    h.a locala = new h.a(this);
    this.gbQ.put(locala.gbT, locala);
    this.gbR.writeLock().unlock();
    AppMethodBeat.o(155553);
  }
  
  public final String getResult()
  {
    AppMethodBeat.i(116749);
    this.gbS.setLength(0);
    this.gbR.readLock().lock();
    Object localObject = this.gbQ.values().iterator();
    while (((Iterator)localObject).hasNext())
    {
      h.a locala = (h.a)((Iterator)localObject).next();
      if (locala.data != null) {
        this.gbS.append(locala.data);
      }
    }
    this.gbR.readLock().unlock();
    localObject = this.gbS.toString();
    AppMethodBeat.o(116749);
    return localObject;
  }
  
  public final void mt(int paramInt)
  {
    AppMethodBeat.i(116752);
    ab.i("MicroMsg.ShortSentenceContainer", "cutShortSentence markEnd:%s", new Object[] { Integer.valueOf(paramInt) });
    if (paramInt < 0)
    {
      localObject = new IllegalStateException("splitShortSentence file mark less than zero. mark: ".concat(String.valueOf(paramInt)));
      AppMethodBeat.o(116752);
      throw ((Throwable)localObject);
    }
    this.gbR.readLock().lock();
    if (this.gbQ.size() == 0)
    {
      ab.e("MicroMsg.ShortSentenceContainer", "splitShortSentence there is no last one");
      AppMethodBeat.o(116752);
      return;
    }
    Iterator localIterator = this.gbQ.values().iterator();
    for (Object localObject = null; localIterator.hasNext(); localObject = (h.a)localIterator.next()) {}
    if (localObject == null)
    {
      localObject = new IllegalStateException("splitShortSentence last info is null");
      AppMethodBeat.o(116752);
      throw ((Throwable)localObject);
    }
    ab.d("MicroMsg.ShortSentenceContainer", "cutShortSentence voiceFileMarkEnd:%s voiceId:%s markEnd:%s", new Object[] { Integer.valueOf(((h.a)localObject).gbW), ((h.a)localObject).gbT, Integer.valueOf(paramInt) });
    ((h.a)localObject).gbW = paramInt;
    this.gbR.readLock().unlock();
    AppMethodBeat.o(116752);
  }
  
  public final h.a mu(int paramInt)
  {
    AppMethodBeat.i(116753);
    this.gbR.readLock().lock();
    if (this.gbQ.size() == 0)
    {
      AppMethodBeat.o(116753);
      return null;
    }
    Iterator localIterator = this.gbQ.values().iterator();
    h.a locala;
    do
    {
      if (!localIterator.hasNext()) {
        break;
      }
      locala = (h.a)localIterator.next();
      ab.d("MicroMsg.ShortSentenceContainer", "locateCurrentShortSentence oldOffset = %s voiceFileMarkEnd = %s info.isRequestEnd = %s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(locala.gbW), Boolean.valueOf(locala.gbV) });
    } while ((locala.gbV) || (paramInt > locala.gbW));
    for (;;)
    {
      this.gbR.readLock().unlock();
      AppMethodBeat.o(116753);
      return locala;
      locala = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.modelvoiceaddr.h
 * JD-Core Version:    0.7.0.1
 */