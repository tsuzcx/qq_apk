package com.tencent.mm.modelvoiceaddr;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.cxn;
import com.tencent.mm.protocal.protobuf.dyd;
import com.tencent.mm.sdk.platformtools.ae;
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
  String iBw;
  LinkedHashMap<String, a> iBx;
  final ReadWriteLock iBy;
  private StringBuilder iBz;
  
  public h(String paramString)
  {
    AppMethodBeat.i(148591);
    this.iBy = new ReentrantReadWriteLock();
    this.iBz = new StringBuilder();
    this.iBx = new LinkedHashMap();
    this.iBw = paramString;
    AppMethodBeat.o(148591);
  }
  
  public final boolean a(h paramh)
  {
    AppMethodBeat.i(148599);
    this.iBy.readLock().lock();
    Iterator localIterator = this.iBx.values().iterator();
    while (localIterator.hasNext())
    {
      a locala1 = (a)localIterator.next();
      a locala2 = new a(paramh.iBw);
      locala2.iBD = locala1.iBD;
      paramh.iBx.put(locala2.iBA, locala2);
    }
    this.iBy.readLock().unlock();
    AppMethodBeat.o(148599);
    return true;
  }
  
  public final LinkedList<cxn> aOt()
  {
    AppMethodBeat.i(148592);
    LinkedList localLinkedList = new LinkedList();
    this.iBy.readLock().lock();
    Iterator localIterator = this.iBx.values().iterator();
    while (localIterator.hasNext())
    {
      a locala = (a)localIterator.next();
      if (locala.iBB) {
        localLinkedList.add(new cxn().aQV(locala.iBA));
      }
    }
    this.iBy.readLock().unlock();
    AppMethodBeat.o(148592);
    return localLinkedList;
  }
  
  public final boolean aOu()
  {
    AppMethodBeat.i(148594);
    this.iBy.readLock().lock();
    if (this.iBx.size() == 0)
    {
      ae.i("MicroMsg.ShortSentenceContainer", "isAllRespEnd innerContainer.size() == 0");
      this.iBy.readLock().unlock();
      AppMethodBeat.o(148594);
      return true;
    }
    Iterator localIterator = this.iBx.values().iterator();
    a locala;
    do
    {
      if (!localIterator.hasNext()) {
        break;
      }
      locala = (a)localIterator.next();
      ae.d("MicroMsg.ShortSentenceContainer", "isAllRespEnd voiceId:%s isRequestEnd:%s isResponseEnd:%s", new Object[] { locala.iBA, Boolean.valueOf(locala.iBC), Boolean.valueOf(locala.iBG) });
    } while (locala.iBG);
    for (boolean bool = false;; bool = true)
    {
      this.iBy.readLock().unlock();
      AppMethodBeat.o(148594);
      return bool;
    }
  }
  
  public final void aOv()
  {
    AppMethodBeat.i(148597);
    ae.i("MicroMsg.ShortSentenceContainer", "createNewShortSentence");
    this.iBy.writeLock().lock();
    a locala = new a();
    this.iBx.put(locala.iBA, locala);
    this.iBy.writeLock().unlock();
    AppMethodBeat.o(148597);
  }
  
  public final void az(List<dyd> paramList)
  {
    AppMethodBeat.i(148595);
    int i;
    Object localObject;
    if (paramList == null)
    {
      i = 0;
      this.iBy.readLock().lock();
      if (this.iBx.size() != 0) {
        break label112;
      }
      this.iBy.readLock().unlock();
      localObject = "[]";
    }
    for (;;)
    {
      ae.d("MicroMsg.ShortSentenceContainer", "updateVoiceInfoResult respVTList size %s innerContainer %s", new Object[] { Integer.valueOf(i), localObject });
      if ((paramList != null) && (paramList.size() != 0)) {
        break label259;
      }
      ae.i("MicroMsg.ShortSentenceContainer", "respList == null");
      AppMethodBeat.o(148595);
      return;
      i = paramList.size();
      break;
      label112:
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[");
      localIterator = this.iBx.values().iterator();
      while (localIterator.hasNext()) {
        ((StringBuilder)localObject).append(((a)localIterator.next()).iBA).append(", ");
      }
      if (((StringBuilder)localObject).length() <= 3)
      {
        this.iBy.readLock().unlock();
        localObject = "]";
      }
      else
      {
        ((StringBuilder)localObject).setLength(((StringBuilder)localObject).length() - 2);
        this.iBy.readLock().unlock();
        localObject = "]";
      }
    }
    label259:
    this.iBy.readLock().lock();
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      dyd localdyd = (dyd)localIterator.next();
      if (localdyd == null)
      {
        ae.i("MicroMsg.ShortSentenceContainer", "setFetchedVoiceInfoResult voiceTransCell is null.");
      }
      else
      {
        a locala = (a)this.iBx.get(localdyd.Gdc);
        if (locala == null)
        {
          ae.i("MicroMsg.ShortSentenceContainer", "voiceInfoContainer not found the voiceId %s", new Object[] { localdyd.Gdc });
        }
        else if (localdyd == null)
        {
          ae.d("MicroMsg.ShortSentenceContainer", "update VoiceInfo cell is null");
        }
        else
        {
          String str1 = localdyd.Gdc;
          i = localdyd.Idc;
          label411:
          boolean bool1;
          label422:
          int j;
          String str2;
          boolean bool2;
          boolean bool3;
          int k;
          int m;
          if ((localdyd.HZj == null) || (localdyd.HZj.getBuffer() == null))
          {
            paramList = null;
            if (localdyd.ijY == 0) {
              break label622;
            }
            bool1 = true;
            j = localdyd.ijY;
            str2 = locala.iBA;
            bool2 = locala.iBB;
            bool3 = locala.iBC;
            k = locala.iBD;
            m = locala.iBF;
            if (locala.data != null) {
              break label628;
            }
          }
          label622:
          label628:
          for (localObject = null;; localObject = Integer.valueOf(locala.data.length()))
          {
            ae.d("MicroMsg.ShortSentenceContainer", "update VoiceInfo get {cell} %s, seq %s, text %s, endFlag %s, endFlag %s {currentInfo} %s, isRequestStart %s, isRequestEnd %s, voiceFileMark %s, seq %s, data %s, isResponseEnd %s", new Object[] { str1, Integer.valueOf(i), paramList, Boolean.valueOf(bool1), Integer.valueOf(j), str2, Boolean.valueOf(bool2), Boolean.valueOf(bool3), Integer.valueOf(k), Integer.valueOf(m), localObject, Boolean.valueOf(locala.iBG) });
            if ((localdyd.Idc >= locala.iBF) && (!locala.iBG)) {
              break label644;
            }
            ae.d("MicroMsg.ShortSentenceContainer", "update seq not fit.");
            break;
            paramList = Integer.valueOf(localdyd.HZj.getILen());
            break label411;
            bool1 = false;
            break label422;
          }
          label644:
          locala.iBF = localdyd.Idc;
          if ((localdyd.HZj == null) || (localdyd.HZj.getBuffer() == null))
          {
            paramList = null;
            label675:
            locala.data = paramList;
            if (localdyd.ijY == 0) {
              break label813;
            }
            bool1 = true;
            label692:
            locala.iBG = bool1;
            paramList = localdyd.Gdc;
            j = locala.iBF;
            bool1 = locala.iBG;
            if (locala.data != null) {
              break label819;
            }
          }
          label813:
          label819:
          for (i = -1;; i = locala.data.length())
          {
            ae.i("MicroMsg.ShortSentenceContainer", "update VoiceId = %s,respSeq = %s,isResponseEnd = %s,data.length = %s", new Object[] { paramList, Integer.valueOf(j), Boolean.valueOf(bool1), Integer.valueOf(i) });
            if (localdyd.ijY != 2) {
              break;
            }
            ae.e("MicroMsg.ShortSentenceContainer", "update cell.EndFlag = 2 VoiceId = %s", new Object[] { localdyd.Gdc });
            break;
            paramList = localdyd.HZj.getBuffer().fjO();
            break label675;
            bool1 = false;
            break label692;
          }
        }
      }
    }
    this.iBy.readLock().unlock();
    AppMethodBeat.o(148595);
  }
  
  public final String getResult()
  {
    AppMethodBeat.i(148593);
    this.iBz.setLength(0);
    this.iBy.readLock().lock();
    Object localObject = this.iBx.values().iterator();
    while (((Iterator)localObject).hasNext())
    {
      a locala = (a)((Iterator)localObject).next();
      if (locala.data != null) {
        this.iBz.append(locala.data);
      }
    }
    this.iBy.readLock().unlock();
    localObject = this.iBz.toString();
    AppMethodBeat.o(148593);
    return localObject;
  }
  
  public final boolean isValid()
  {
    AppMethodBeat.i(185490);
    if ((this.iBx == null) || (this.iBx.isEmpty()))
    {
      AppMethodBeat.o(185490);
      return false;
    }
    AppMethodBeat.o(185490);
    return true;
  }
  
  public final void qw(int paramInt)
  {
    AppMethodBeat.i(148596);
    ae.i("MicroMsg.ShortSentenceContainer", "cutShortSentence markEnd:%s", new Object[] { Integer.valueOf(paramInt) });
    if (paramInt < 0)
    {
      localObject = new IllegalStateException("splitShortSentence file mark less than zero. mark: ".concat(String.valueOf(paramInt)));
      AppMethodBeat.o(148596);
      throw ((Throwable)localObject);
    }
    this.iBy.readLock().lock();
    if (this.iBx.size() == 0)
    {
      ae.e("MicroMsg.ShortSentenceContainer", "splitShortSentence there is no last one");
      this.iBy.readLock().unlock();
      AppMethodBeat.o(148596);
      return;
    }
    Iterator localIterator = this.iBx.values().iterator();
    for (Object localObject = null; localIterator.hasNext(); localObject = (a)localIterator.next()) {}
    if (localObject == null)
    {
      localObject = new IllegalStateException("splitShortSentence last info is null");
      AppMethodBeat.o(148596);
      throw ((Throwable)localObject);
    }
    ae.d("MicroMsg.ShortSentenceContainer", "cutShortSentence voiceFileMarkEnd:%s voiceId:%s markEnd:%s", new Object[] { Integer.valueOf(((a)localObject).iBD), ((a)localObject).iBA, Integer.valueOf(paramInt) });
    ((a)localObject).iBD = paramInt;
    this.iBy.readLock().unlock();
    AppMethodBeat.o(148596);
  }
  
  public final a qx(int paramInt)
  {
    AppMethodBeat.i(148598);
    this.iBy.readLock().lock();
    if (this.iBx.size() == 0)
    {
      this.iBy.readLock().unlock();
      AppMethodBeat.o(148598);
      return null;
    }
    Iterator localIterator = this.iBx.values().iterator();
    a locala;
    do
    {
      if (!localIterator.hasNext()) {
        break;
      }
      locala = (a)localIterator.next();
      ae.d("MicroMsg.ShortSentenceContainer", "locateCurrentShortSentence oldOffset = %s voiceFileMarkEnd = %s info.isRequestEnd = %s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(locala.iBD), Boolean.valueOf(locala.iBC) });
    } while ((locala.iBC) || (paramInt > locala.iBD));
    for (;;)
    {
      this.iBy.readLock().unlock();
      AppMethodBeat.o(148598);
      return locala;
      locala = null;
    }
  }
  
  public final class a
  {
    public String data;
    public String iBA;
    public boolean iBB;
    public boolean iBC;
    public int iBD;
    public int iBE;
    public int iBF;
    public boolean iBG;
    
    public a()
    {
      AppMethodBeat.i(148588);
      this.iBB = false;
      this.iBC = false;
      this.iBD = 2147483647;
      this.iBE = 0;
      this.iBF = -1;
      this.data = null;
      this.iBG = false;
      this.iBA = IG(h.this.iBw);
      AppMethodBeat.o(148588);
    }
    
    public a(String paramString)
    {
      AppMethodBeat.i(148589);
      this.iBB = false;
      this.iBC = false;
      this.iBD = 2147483647;
      this.iBE = 0;
      this.iBF = -1;
      this.data = null;
      this.iBG = false;
      this.iBA = IG(paramString);
      AppMethodBeat.o(148589);
    }
    
    private static String IG(String paramString)
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
      ae.i("MicroMsg.ShortSentenceContainer", "finally random = %s(%s) time = %s(%s) id = %s(%s) session = %s strId = %s", new Object[] { Long.valueOf(l4), Long.toBinaryString(l4), Long.valueOf(l3), Long.toBinaryString(l3), Long.valueOf(l1), Long.toBinaryString(l1), paramString, str });
      AppMethodBeat.o(148590);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.modelvoiceaddr.h
 * JD-Core Version:    0.7.0.1
 */