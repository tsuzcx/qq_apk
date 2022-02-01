package com.tencent.mm.modelvoiceaddr;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.cwt;
import com.tencent.mm.protocal.protobuf.dwm;
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
  String iyD;
  LinkedHashMap<String, a> iyE;
  final ReadWriteLock iyF;
  private StringBuilder iyG;
  
  public h(String paramString)
  {
    AppMethodBeat.i(148591);
    this.iyF = new ReentrantReadWriteLock();
    this.iyG = new StringBuilder();
    this.iyE = new LinkedHashMap();
    this.iyD = paramString;
    AppMethodBeat.o(148591);
  }
  
  public final boolean a(h paramh)
  {
    AppMethodBeat.i(148599);
    this.iyF.readLock().lock();
    Iterator localIterator = this.iyE.values().iterator();
    while (localIterator.hasNext())
    {
      a locala1 = (a)localIterator.next();
      a locala2 = new a(paramh.iyD);
      locala2.iyK = locala1.iyK;
      paramh.iyE.put(locala2.iyH, locala2);
    }
    this.iyF.readLock().unlock();
    AppMethodBeat.o(148599);
    return true;
  }
  
  public final LinkedList<cwt> aNV()
  {
    AppMethodBeat.i(148592);
    LinkedList localLinkedList = new LinkedList();
    this.iyF.readLock().lock();
    Iterator localIterator = this.iyE.values().iterator();
    while (localIterator.hasNext())
    {
      a locala = (a)localIterator.next();
      if (locala.iyI) {
        localLinkedList.add(new cwt().aPy(locala.iyH));
      }
    }
    this.iyF.readLock().unlock();
    AppMethodBeat.o(148592);
    return localLinkedList;
  }
  
  public final boolean aNW()
  {
    AppMethodBeat.i(148594);
    this.iyF.readLock().lock();
    if (this.iyE.size() == 0)
    {
      ad.i("MicroMsg.ShortSentenceContainer", "isAllRespEnd innerContainer.size() == 0");
      this.iyF.readLock().unlock();
      AppMethodBeat.o(148594);
      return true;
    }
    Iterator localIterator = this.iyE.values().iterator();
    a locala;
    do
    {
      if (!localIterator.hasNext()) {
        break;
      }
      locala = (a)localIterator.next();
      ad.d("MicroMsg.ShortSentenceContainer", "isAllRespEnd voiceId:%s isRequestEnd:%s isResponseEnd:%s", new Object[] { locala.iyH, Boolean.valueOf(locala.iyJ), Boolean.valueOf(locala.iyN) });
    } while (locala.iyN);
    for (boolean bool = false;; bool = true)
    {
      this.iyF.readLock().unlock();
      AppMethodBeat.o(148594);
      return bool;
    }
  }
  
  public final void aNX()
  {
    AppMethodBeat.i(148597);
    ad.i("MicroMsg.ShortSentenceContainer", "createNewShortSentence");
    this.iyF.writeLock().lock();
    a locala = new a();
    this.iyE.put(locala.iyH, locala);
    this.iyF.writeLock().unlock();
    AppMethodBeat.o(148597);
  }
  
  public final void az(List<dwm> paramList)
  {
    AppMethodBeat.i(148595);
    int i;
    Object localObject;
    if (paramList == null)
    {
      i = 0;
      this.iyF.readLock().lock();
      if (this.iyE.size() != 0) {
        break label112;
      }
      this.iyF.readLock().unlock();
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
      localIterator = this.iyE.values().iterator();
      while (localIterator.hasNext()) {
        ((StringBuilder)localObject).append(((a)localIterator.next()).iyH).append(", ");
      }
      if (((StringBuilder)localObject).length() <= 3)
      {
        this.iyF.readLock().unlock();
        localObject = "]";
      }
      else
      {
        ((StringBuilder)localObject).setLength(((StringBuilder)localObject).length() - 2);
        this.iyF.readLock().unlock();
        localObject = "]";
      }
    }
    label259:
    this.iyF.readLock().lock();
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      dwm localdwm = (dwm)localIterator.next();
      if (localdwm == null)
      {
        ad.i("MicroMsg.ShortSentenceContainer", "setFetchedVoiceInfoResult voiceTransCell is null.");
      }
      else
      {
        a locala = (a)this.iyE.get(localdwm.FKD);
        if (locala == null)
        {
          ad.i("MicroMsg.ShortSentenceContainer", "voiceInfoContainer not found the voiceId %s", new Object[] { localdwm.FKD });
        }
        else if (localdwm == null)
        {
          ad.d("MicroMsg.ShortSentenceContainer", "update VoiceInfo cell is null");
        }
        else
        {
          String str1 = localdwm.FKD;
          i = localdwm.HIU;
          label411:
          boolean bool1;
          label422:
          int j;
          String str2;
          boolean bool2;
          boolean bool3;
          int k;
          int m;
          if ((localdwm.HFw == null) || (localdwm.HFw.getBuffer() == null))
          {
            paramList = null;
            if (localdwm.ihf == 0) {
              break label622;
            }
            bool1 = true;
            j = localdwm.ihf;
            str2 = locala.iyH;
            bool2 = locala.iyI;
            bool3 = locala.iyJ;
            k = locala.iyK;
            m = locala.iyM;
            if (locala.data != null) {
              break label628;
            }
          }
          label622:
          label628:
          for (localObject = null;; localObject = Integer.valueOf(locala.data.length()))
          {
            ad.d("MicroMsg.ShortSentenceContainer", "update VoiceInfo get {cell} %s, seq %s, text %s, endFlag %s, endFlag %s {currentInfo} %s, isRequestStart %s, isRequestEnd %s, voiceFileMark %s, seq %s, data %s, isResponseEnd %s", new Object[] { str1, Integer.valueOf(i), paramList, Boolean.valueOf(bool1), Integer.valueOf(j), str2, Boolean.valueOf(bool2), Boolean.valueOf(bool3), Integer.valueOf(k), Integer.valueOf(m), localObject, Boolean.valueOf(locala.iyN) });
            if ((localdwm.HIU >= locala.iyM) && (!locala.iyN)) {
              break label644;
            }
            ad.d("MicroMsg.ShortSentenceContainer", "update seq not fit.");
            break;
            paramList = Integer.valueOf(localdwm.HFw.getILen());
            break label411;
            bool1 = false;
            break label422;
          }
          label644:
          locala.iyM = localdwm.HIU;
          if ((localdwm.HFw == null) || (localdwm.HFw.getBuffer() == null))
          {
            paramList = null;
            label675:
            locala.data = paramList;
            if (localdwm.ihf == 0) {
              break label813;
            }
            bool1 = true;
            label692:
            locala.iyN = bool1;
            paramList = localdwm.FKD;
            j = locala.iyM;
            bool1 = locala.iyN;
            if (locala.data != null) {
              break label819;
            }
          }
          label813:
          label819:
          for (i = -1;; i = locala.data.length())
          {
            ad.i("MicroMsg.ShortSentenceContainer", "update VoiceId = %s,respSeq = %s,isResponseEnd = %s,data.length = %s", new Object[] { paramList, Integer.valueOf(j), Boolean.valueOf(bool1), Integer.valueOf(i) });
            if (localdwm.ihf != 2) {
              break;
            }
            ad.e("MicroMsg.ShortSentenceContainer", "update cell.EndFlag = 2 VoiceId = %s", new Object[] { localdwm.FKD });
            break;
            paramList = localdwm.HFw.getBuffer().ffY();
            break label675;
            bool1 = false;
            break label692;
          }
        }
      }
    }
    this.iyF.readLock().unlock();
    AppMethodBeat.o(148595);
  }
  
  public final String getResult()
  {
    AppMethodBeat.i(148593);
    this.iyG.setLength(0);
    this.iyF.readLock().lock();
    Object localObject = this.iyE.values().iterator();
    while (((Iterator)localObject).hasNext())
    {
      a locala = (a)((Iterator)localObject).next();
      if (locala.data != null) {
        this.iyG.append(locala.data);
      }
    }
    this.iyF.readLock().unlock();
    localObject = this.iyG.toString();
    AppMethodBeat.o(148593);
    return localObject;
  }
  
  public final boolean isValid()
  {
    AppMethodBeat.i(185490);
    if ((this.iyE == null) || (this.iyE.isEmpty()))
    {
      AppMethodBeat.o(185490);
      return false;
    }
    AppMethodBeat.o(185490);
    return true;
  }
  
  public final void qt(int paramInt)
  {
    AppMethodBeat.i(148596);
    ad.i("MicroMsg.ShortSentenceContainer", "cutShortSentence markEnd:%s", new Object[] { Integer.valueOf(paramInt) });
    if (paramInt < 0)
    {
      localObject = new IllegalStateException("splitShortSentence file mark less than zero. mark: ".concat(String.valueOf(paramInt)));
      AppMethodBeat.o(148596);
      throw ((Throwable)localObject);
    }
    this.iyF.readLock().lock();
    if (this.iyE.size() == 0)
    {
      ad.e("MicroMsg.ShortSentenceContainer", "splitShortSentence there is no last one");
      this.iyF.readLock().unlock();
      AppMethodBeat.o(148596);
      return;
    }
    Iterator localIterator = this.iyE.values().iterator();
    for (Object localObject = null; localIterator.hasNext(); localObject = (a)localIterator.next()) {}
    if (localObject == null)
    {
      localObject = new IllegalStateException("splitShortSentence last info is null");
      AppMethodBeat.o(148596);
      throw ((Throwable)localObject);
    }
    ad.d("MicroMsg.ShortSentenceContainer", "cutShortSentence voiceFileMarkEnd:%s voiceId:%s markEnd:%s", new Object[] { Integer.valueOf(((a)localObject).iyK), ((a)localObject).iyH, Integer.valueOf(paramInt) });
    ((a)localObject).iyK = paramInt;
    this.iyF.readLock().unlock();
    AppMethodBeat.o(148596);
  }
  
  public final a qu(int paramInt)
  {
    AppMethodBeat.i(148598);
    this.iyF.readLock().lock();
    if (this.iyE.size() == 0)
    {
      this.iyF.readLock().unlock();
      AppMethodBeat.o(148598);
      return null;
    }
    Iterator localIterator = this.iyE.values().iterator();
    a locala;
    do
    {
      if (!localIterator.hasNext()) {
        break;
      }
      locala = (a)localIterator.next();
      ad.d("MicroMsg.ShortSentenceContainer", "locateCurrentShortSentence oldOffset = %s voiceFileMarkEnd = %s info.isRequestEnd = %s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(locala.iyK), Boolean.valueOf(locala.iyJ) });
    } while ((locala.iyJ) || (paramInt > locala.iyK));
    for (;;)
    {
      this.iyF.readLock().unlock();
      AppMethodBeat.o(148598);
      return locala;
      locala = null;
    }
  }
  
  public final class a
  {
    public String data;
    public String iyH;
    public boolean iyI;
    public boolean iyJ;
    public int iyK;
    public int iyL;
    public int iyM;
    public boolean iyN;
    
    public a()
    {
      AppMethodBeat.i(148588);
      this.iyI = false;
      this.iyJ = false;
      this.iyK = 2147483647;
      this.iyL = 0;
      this.iyM = -1;
      this.data = null;
      this.iyN = false;
      this.iyH = Ie(h.this.iyD);
      AppMethodBeat.o(148588);
    }
    
    public a(String paramString)
    {
      AppMethodBeat.i(148589);
      this.iyI = false;
      this.iyJ = false;
      this.iyK = 2147483647;
      this.iyL = 0;
      this.iyM = -1;
      this.data = null;
      this.iyN = false;
      this.iyH = Ie(paramString);
      AppMethodBeat.o(148589);
    }
    
    private static String Ie(String paramString)
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.modelvoiceaddr.h
 * JD-Core Version:    0.7.0.1
 */