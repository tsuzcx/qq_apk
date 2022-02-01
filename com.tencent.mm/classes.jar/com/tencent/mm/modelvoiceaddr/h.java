package com.tencent.mm.modelvoiceaddr;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.crm;
import com.tencent.mm.protocal.protobuf.dqs;
import com.tencent.mm.sdk.platformtools.ac;
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
  String ifj;
  LinkedHashMap<String, a> ifk;
  final ReadWriteLock ifl;
  private StringBuilder ifm;
  
  public h(String paramString)
  {
    AppMethodBeat.i(148591);
    this.ifl = new ReentrantReadWriteLock();
    this.ifm = new StringBuilder();
    this.ifk = new LinkedHashMap();
    this.ifj = paramString;
    AppMethodBeat.o(148591);
  }
  
  public final boolean a(h paramh)
  {
    AppMethodBeat.i(148599);
    this.ifl.readLock().lock();
    Iterator localIterator = this.ifk.values().iterator();
    while (localIterator.hasNext())
    {
      a locala1 = (a)localIterator.next();
      a locala2 = new a(paramh.ifj);
      locala2.ifq = locala1.ifq;
      paramh.ifk.put(locala2.ifn, locala2);
    }
    this.ifl.readLock().unlock();
    AppMethodBeat.o(148599);
    return true;
  }
  
  public final LinkedList<crm> aKM()
  {
    AppMethodBeat.i(148592);
    LinkedList localLinkedList = new LinkedList();
    this.ifl.readLock().lock();
    Iterator localIterator = this.ifk.values().iterator();
    while (localIterator.hasNext())
    {
      a locala = (a)localIterator.next();
      if (locala.ifo) {
        localLinkedList.add(new crm().aJV(locala.ifn));
      }
    }
    this.ifl.readLock().unlock();
    AppMethodBeat.o(148592);
    return localLinkedList;
  }
  
  public final boolean aKN()
  {
    AppMethodBeat.i(148594);
    this.ifl.readLock().lock();
    if (this.ifk.size() == 0)
    {
      ac.i("MicroMsg.ShortSentenceContainer", "isAllRespEnd innerContainer.size() == 0");
      this.ifl.readLock().unlock();
      AppMethodBeat.o(148594);
      return true;
    }
    Iterator localIterator = this.ifk.values().iterator();
    a locala;
    do
    {
      if (!localIterator.hasNext()) {
        break;
      }
      locala = (a)localIterator.next();
      ac.d("MicroMsg.ShortSentenceContainer", "isAllRespEnd voiceId:%s isRequestEnd:%s isResponseEnd:%s", new Object[] { locala.ifn, Boolean.valueOf(locala.ifp), Boolean.valueOf(locala.ift) });
    } while (locala.ift);
    for (boolean bool = false;; bool = true)
    {
      this.ifl.readLock().unlock();
      AppMethodBeat.o(148594);
      return bool;
    }
  }
  
  public final void aKO()
  {
    AppMethodBeat.i(148597);
    ac.i("MicroMsg.ShortSentenceContainer", "createNewShortSentence");
    this.ifl.writeLock().lock();
    a locala = new a();
    this.ifk.put(locala.ifn, locala);
    this.ifl.writeLock().unlock();
    AppMethodBeat.o(148597);
  }
  
  public final void ay(List<dqs> paramList)
  {
    AppMethodBeat.i(148595);
    int i;
    Object localObject;
    if (paramList == null)
    {
      i = 0;
      this.ifl.readLock().lock();
      if (this.ifk.size() != 0) {
        break label112;
      }
      this.ifl.readLock().unlock();
      localObject = "[]";
    }
    for (;;)
    {
      ac.d("MicroMsg.ShortSentenceContainer", "updateVoiceInfoResult respVTList size %s innerContainer %s", new Object[] { Integer.valueOf(i), localObject });
      if ((paramList != null) && (paramList.size() != 0)) {
        break label259;
      }
      ac.i("MicroMsg.ShortSentenceContainer", "respList == null");
      AppMethodBeat.o(148595);
      return;
      i = paramList.size();
      break;
      label112:
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[");
      localIterator = this.ifk.values().iterator();
      while (localIterator.hasNext()) {
        ((StringBuilder)localObject).append(((a)localIterator.next()).ifn).append(", ");
      }
      if (((StringBuilder)localObject).length() <= 3)
      {
        this.ifl.readLock().unlock();
        localObject = "]";
      }
      else
      {
        ((StringBuilder)localObject).setLength(((StringBuilder)localObject).length() - 2);
        this.ifl.readLock().unlock();
        localObject = "]";
      }
    }
    label259:
    this.ifl.readLock().lock();
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      dqs localdqs = (dqs)localIterator.next();
      if (localdqs == null)
      {
        ac.i("MicroMsg.ShortSentenceContainer", "setFetchedVoiceInfoResult voiceTransCell is null.");
      }
      else
      {
        a locala = (a)this.ifk.get(localdqs.Eee);
        if (locala == null)
        {
          ac.i("MicroMsg.ShortSentenceContainer", "voiceInfoContainer not found the voiceId %s", new Object[] { localdqs.Eee });
        }
        else if (localdqs == null)
        {
          ac.d("MicroMsg.ShortSentenceContainer", "update VoiceInfo cell is null");
        }
        else
        {
          String str1 = localdqs.Eee;
          i = localdqs.FXY;
          label411:
          boolean bool1;
          label422:
          int j;
          String str2;
          boolean bool2;
          boolean bool3;
          int k;
          int m;
          if ((localdqs.FUI == null) || (localdqs.FUI.getBuffer() == null))
          {
            paramList = null;
            if (localdqs.hNR == 0) {
              break label622;
            }
            bool1 = true;
            j = localdqs.hNR;
            str2 = locala.ifn;
            bool2 = locala.ifo;
            bool3 = locala.ifp;
            k = locala.ifq;
            m = locala.ifs;
            if (locala.data != null) {
              break label628;
            }
          }
          label622:
          label628:
          for (localObject = null;; localObject = Integer.valueOf(locala.data.length()))
          {
            ac.d("MicroMsg.ShortSentenceContainer", "update VoiceInfo get {cell} %s, seq %s, text %s, endFlag %s, endFlag %s {currentInfo} %s, isRequestStart %s, isRequestEnd %s, voiceFileMark %s, seq %s, data %s, isResponseEnd %s", new Object[] { str1, Integer.valueOf(i), paramList, Boolean.valueOf(bool1), Integer.valueOf(j), str2, Boolean.valueOf(bool2), Boolean.valueOf(bool3), Integer.valueOf(k), Integer.valueOf(m), localObject, Boolean.valueOf(locala.ift) });
            if ((localdqs.FXY >= locala.ifs) && (!locala.ift)) {
              break label644;
            }
            ac.d("MicroMsg.ShortSentenceContainer", "update seq not fit.");
            break;
            paramList = Integer.valueOf(localdqs.FUI.getILen());
            break label411;
            bool1 = false;
            break label422;
          }
          label644:
          locala.ifs = localdqs.FXY;
          if ((localdqs.FUI == null) || (localdqs.FUI.getBuffer() == null))
          {
            paramList = null;
            label675:
            locala.data = paramList;
            if (localdqs.hNR == 0) {
              break label813;
            }
            bool1 = true;
            label692:
            locala.ift = bool1;
            paramList = localdqs.Eee;
            j = locala.ifs;
            bool1 = locala.ift;
            if (locala.data != null) {
              break label819;
            }
          }
          label813:
          label819:
          for (i = -1;; i = locala.data.length())
          {
            ac.i("MicroMsg.ShortSentenceContainer", "update VoiceId = %s,respSeq = %s,isResponseEnd = %s,data.length = %s", new Object[] { paramList, Integer.valueOf(j), Boolean.valueOf(bool1), Integer.valueOf(i) });
            if (localdqs.hNR != 2) {
              break;
            }
            ac.e("MicroMsg.ShortSentenceContainer", "update cell.EndFlag = 2 VoiceId = %s", new Object[] { localdqs.Eee });
            break;
            paramList = localdqs.FUI.getBuffer().eQU();
            break label675;
            bool1 = false;
            break label692;
          }
        }
      }
    }
    this.ifl.readLock().unlock();
    AppMethodBeat.o(148595);
  }
  
  public final String getResult()
  {
    AppMethodBeat.i(148593);
    this.ifm.setLength(0);
    this.ifl.readLock().lock();
    Object localObject = this.ifk.values().iterator();
    while (((Iterator)localObject).hasNext())
    {
      a locala = (a)((Iterator)localObject).next();
      if (locala.data != null) {
        this.ifm.append(locala.data);
      }
    }
    this.ifl.readLock().unlock();
    localObject = this.ifm.toString();
    AppMethodBeat.o(148593);
    return localObject;
  }
  
  public final boolean isValid()
  {
    AppMethodBeat.i(185490);
    if ((this.ifk == null) || (this.ifk.isEmpty()))
    {
      AppMethodBeat.o(185490);
      return false;
    }
    AppMethodBeat.o(185490);
    return true;
  }
  
  public final void pR(int paramInt)
  {
    AppMethodBeat.i(148596);
    ac.i("MicroMsg.ShortSentenceContainer", "cutShortSentence markEnd:%s", new Object[] { Integer.valueOf(paramInt) });
    if (paramInt < 0)
    {
      localObject = new IllegalStateException("splitShortSentence file mark less than zero. mark: ".concat(String.valueOf(paramInt)));
      AppMethodBeat.o(148596);
      throw ((Throwable)localObject);
    }
    this.ifl.readLock().lock();
    if (this.ifk.size() == 0)
    {
      ac.e("MicroMsg.ShortSentenceContainer", "splitShortSentence there is no last one");
      this.ifl.readLock().unlock();
      AppMethodBeat.o(148596);
      return;
    }
    Iterator localIterator = this.ifk.values().iterator();
    for (Object localObject = null; localIterator.hasNext(); localObject = (a)localIterator.next()) {}
    if (localObject == null)
    {
      localObject = new IllegalStateException("splitShortSentence last info is null");
      AppMethodBeat.o(148596);
      throw ((Throwable)localObject);
    }
    ac.d("MicroMsg.ShortSentenceContainer", "cutShortSentence voiceFileMarkEnd:%s voiceId:%s markEnd:%s", new Object[] { Integer.valueOf(((a)localObject).ifq), ((a)localObject).ifn, Integer.valueOf(paramInt) });
    ((a)localObject).ifq = paramInt;
    this.ifl.readLock().unlock();
    AppMethodBeat.o(148596);
  }
  
  public final a pS(int paramInt)
  {
    AppMethodBeat.i(148598);
    this.ifl.readLock().lock();
    if (this.ifk.size() == 0)
    {
      this.ifl.readLock().unlock();
      AppMethodBeat.o(148598);
      return null;
    }
    Iterator localIterator = this.ifk.values().iterator();
    a locala;
    do
    {
      if (!localIterator.hasNext()) {
        break;
      }
      locala = (a)localIterator.next();
      ac.d("MicroMsg.ShortSentenceContainer", "locateCurrentShortSentence oldOffset = %s voiceFileMarkEnd = %s info.isRequestEnd = %s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(locala.ifq), Boolean.valueOf(locala.ifp) });
    } while ((locala.ifp) || (paramInt > locala.ifq));
    for (;;)
    {
      this.ifl.readLock().unlock();
      AppMethodBeat.o(148598);
      return locala;
      locala = null;
    }
  }
  
  public final class a
  {
    public String data;
    public String ifn;
    public boolean ifo;
    public boolean ifp;
    public int ifq;
    public int ifr;
    public int ifs;
    public boolean ift;
    
    public a()
    {
      AppMethodBeat.i(148588);
      this.ifo = false;
      this.ifp = false;
      this.ifq = 2147483647;
      this.ifr = 0;
      this.ifs = -1;
      this.data = null;
      this.ift = false;
      this.ifn = EP(h.this.ifj);
      AppMethodBeat.o(148588);
    }
    
    public a(String paramString)
    {
      AppMethodBeat.i(148589);
      this.ifo = false;
      this.ifp = false;
      this.ifq = 2147483647;
      this.ifr = 0;
      this.ifs = -1;
      this.data = null;
      this.ift = false;
      this.ifn = EP(paramString);
      AppMethodBeat.o(148589);
    }
    
    private static String EP(String paramString)
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
      ac.i("MicroMsg.ShortSentenceContainer", "finally random = %s(%s) time = %s(%s) id = %s(%s) session = %s strId = %s", new Object[] { Long.valueOf(l4), Long.toBinaryString(l4), Long.valueOf(l3), Long.toBinaryString(l3), Long.valueOf(l1), Long.toBinaryString(l1), paramString, str });
      AppMethodBeat.o(148590);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.modelvoiceaddr.h
 * JD-Core Version:    0.7.0.1
 */