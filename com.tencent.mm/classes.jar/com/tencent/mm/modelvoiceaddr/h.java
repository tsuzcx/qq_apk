package com.tencent.mm.modelvoiceaddr;

import com.tencent.mm.bv.b;
import com.tencent.mm.protocal.c.bmk;
import com.tencent.mm.protocal.c.bml;
import com.tencent.mm.protocal.c.cdv;
import com.tencent.mm.sdk.platformtools.y;
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
  String eMj;
  LinkedHashMap<String, h.a> eMk = new LinkedHashMap();
  final ReadWriteLock eMl = new ReentrantReadWriteLock();
  private StringBuilder eMm = new StringBuilder();
  
  public h(String paramString)
  {
    this.eMj = paramString;
  }
  
  public final LinkedList<bml> TD()
  {
    LinkedList localLinkedList = new LinkedList();
    this.eMl.readLock().lock();
    Iterator localIterator = this.eMk.values().iterator();
    while (localIterator.hasNext())
    {
      h.a locala = (h.a)localIterator.next();
      if (locala.eMo) {
        localLinkedList.add(new bml().YI(locala.eMn));
      }
    }
    this.eMl.readLock().unlock();
    return localLinkedList;
  }
  
  public final boolean TE()
  {
    this.eMl.readLock().lock();
    if (this.eMk.size() == 0)
    {
      y.i("MicroMsg.ShortSentenceContainer", "isAllRespEnd innerContainer.size() == 0");
      return false;
    }
    Iterator localIterator = this.eMk.values().iterator();
    h.a locala;
    do
    {
      if (!localIterator.hasNext()) {
        break;
      }
      locala = (h.a)localIterator.next();
      y.d("MicroMsg.ShortSentenceContainer", "isAllRespEnd voiceId:%s isRequestEnd:%s isResponseEnd:%s", new Object[] { locala.eMn, Boolean.valueOf(locala.eMp), Boolean.valueOf(locala.eMt) });
    } while (locala.eMt);
    for (boolean bool = false;; bool = true)
    {
      this.eMl.readLock().unlock();
      return bool;
    }
  }
  
  public final void ac(List<cdv> paramList)
  {
    int i;
    Object localObject;
    if (paramList == null)
    {
      i = 0;
      this.eMl.readLock().lock();
      if (this.eMk.size() != 0) {
        break label102;
      }
      this.eMl.readLock().unlock();
      localObject = "[]";
    }
    for (;;)
    {
      y.d("MicroMsg.ShortSentenceContainer", "updateVoiceInfoResult respVTList size %s innerContainer %s", new Object[] { Integer.valueOf(i), localObject });
      if ((paramList != null) && (paramList.size() != 0)) {
        break label249;
      }
      y.i("MicroMsg.ShortSentenceContainer", "respList == null");
      return;
      i = paramList.size();
      break;
      label102:
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[");
      localIterator = this.eMk.values().iterator();
      while (localIterator.hasNext()) {
        ((StringBuilder)localObject).append(((h.a)localIterator.next()).eMn).append(", ");
      }
      if (((StringBuilder)localObject).length() <= 3)
      {
        this.eMl.readLock().unlock();
        localObject = "]";
      }
      else
      {
        ((StringBuilder)localObject).setLength(((StringBuilder)localObject).length() - 2);
        this.eMl.readLock().unlock();
        localObject = "]";
      }
    }
    label249:
    this.eMl.readLock().lock();
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      cdv localcdv = (cdv)localIterator.next();
      if (localcdv == null)
      {
        y.i("MicroMsg.ShortSentenceContainer", "setFetchedVoiceInfoResult voiceTransCell is null.");
      }
      else
      {
        h.a locala = (h.a)this.eMk.get(localcdv.sNM);
        if (locala == null)
        {
          y.i("MicroMsg.ShortSentenceContainer", "voiceInfoContainer not found the voiceId %s", new Object[] { localcdv.sNM });
        }
        else if (localcdv == null)
        {
          y.d("MicroMsg.ShortSentenceContainer", "update VoiceInfo cell is null");
        }
        else
        {
          String str1 = localcdv.sNM;
          i = localcdv.tSw;
          label401:
          boolean bool1;
          label412:
          int j;
          String str2;
          boolean bool2;
          boolean bool3;
          int k;
          int m;
          if ((localcdv.tQe == null) || (localcdv.tQe.tFM == null))
          {
            paramList = null;
            if (localcdv.euw == 0) {
              break label612;
            }
            bool1 = true;
            j = localcdv.euw;
            str2 = locala.eMn;
            bool2 = locala.eMo;
            bool3 = locala.eMp;
            k = locala.eMq;
            m = locala.eMs;
            if (locala.data != null) {
              break label618;
            }
          }
          label612:
          label618:
          for (localObject = null;; localObject = Integer.valueOf(locala.data.length()))
          {
            y.d("MicroMsg.ShortSentenceContainer", "update VoiceInfo get {cell} %s, seq %s, text %s, endFlag %s, endFlag %s {currentInfo} %s, isRequestStart %s, isRequestEnd %s, voiceFileMark %s, seq %s, data %s, isResponseEnd %s", new Object[] { str1, Integer.valueOf(i), paramList, Boolean.valueOf(bool1), Integer.valueOf(j), str2, Boolean.valueOf(bool2), Boolean.valueOf(bool3), Integer.valueOf(k), Integer.valueOf(m), localObject, Boolean.valueOf(locala.eMt) });
            if ((localcdv.tSw >= locala.eMs) && (!locala.eMt)) {
              break label634;
            }
            y.d("MicroMsg.ShortSentenceContainer", "update seq not fit.");
            break;
            paramList = Integer.valueOf(localcdv.tQe.tFK);
            break label401;
            bool1 = false;
            break label412;
          }
          label634:
          locala.eMs = localcdv.tSw;
          if ((localcdv.tQe == null) || (localcdv.tQe.tFM == null))
          {
            paramList = null;
            label665:
            locala.data = paramList;
            if (localcdv.euw == 0) {
              break label801;
            }
            bool1 = true;
            label682:
            locala.eMt = bool1;
            paramList = localcdv.sNM;
            j = locala.eMs;
            bool1 = locala.eMt;
            if (locala.data != null) {
              break label807;
            }
          }
          label801:
          label807:
          for (i = -1;; i = locala.data.length())
          {
            y.i("MicroMsg.ShortSentenceContainer", "update VoiceId = %s,respSeq = %s,isResponseEnd = %s,data.length = %s", new Object[] { paramList, Integer.valueOf(j), Boolean.valueOf(bool1), Integer.valueOf(i) });
            if (localcdv.euw != 2) {
              break;
            }
            y.e("MicroMsg.ShortSentenceContainer", "update cell.EndFlag = 2 VoiceId = %s", new Object[] { localcdv.sNM });
            break;
            paramList = localcdv.tQe.tFM.coM();
            break label665;
            bool1 = false;
            break label682;
          }
        }
      }
    }
    this.eMl.readLock().unlock();
  }
  
  public final String getResult()
  {
    this.eMm.setLength(0);
    this.eMl.readLock().lock();
    Iterator localIterator = this.eMk.values().iterator();
    while (localIterator.hasNext())
    {
      h.a locala = (h.a)localIterator.next();
      if (locala.data != null) {
        this.eMm.append(locala.data);
      }
    }
    this.eMl.readLock().unlock();
    return this.eMm.toString();
  }
  
  public final void jA(int paramInt)
  {
    y.i("MicroMsg.ShortSentenceContainer", "cutShortSentence markEnd:%s", new Object[] { Integer.valueOf(paramInt) });
    if (paramInt < 0) {
      throw new IllegalStateException("splitShortSentence file mark less than zero. mark: " + paramInt);
    }
    this.eMl.readLock().lock();
    if (this.eMk.size() == 0)
    {
      y.e("MicroMsg.ShortSentenceContainer", "splitShortSentence there is no last one");
      return;
    }
    Iterator localIterator = this.eMk.values().iterator();
    for (h.a locala = null; localIterator.hasNext(); locala = (h.a)localIterator.next()) {}
    if (locala == null) {
      throw new IllegalStateException("splitShortSentence last info is null");
    }
    y.d("MicroMsg.ShortSentenceContainer", "cutShortSentence voiceFileMarkEnd:%s voiceId:%s markEnd:%s", new Object[] { Integer.valueOf(locala.eMq), locala.eMn, Integer.valueOf(paramInt) });
    locala.eMq = paramInt;
    this.eMl.readLock().unlock();
  }
  
  public final h.a jB(int paramInt)
  {
    this.eMl.readLock().lock();
    if (this.eMk.size() == 0) {
      return null;
    }
    Iterator localIterator = this.eMk.values().iterator();
    h.a locala;
    do
    {
      if (!localIterator.hasNext()) {
        break;
      }
      locala = (h.a)localIterator.next();
      y.d("MicroMsg.ShortSentenceContainer", "locateCurrentShortSentence oldOffset = %s voiceFileMarkEnd = %s info.isRequestEnd = %s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(locala.eMq), Boolean.valueOf(locala.eMp) });
    } while ((locala.eMp) || (paramInt > locala.eMq));
    for (;;)
    {
      this.eMl.readLock().unlock();
      return locala;
      locala = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.modelvoiceaddr.h
 * JD-Core Version:    0.7.0.1
 */