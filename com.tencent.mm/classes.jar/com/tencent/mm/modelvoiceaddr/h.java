package com.tencent.mm.modelvoiceaddr;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;
import com.tencent.mm.protocal.protobuf.etl;
import com.tencent.mm.protocal.protobuf.fzh;
import com.tencent.mm.protocal.protobuf.gol;
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
  String pgb;
  LinkedHashMap<String, a> pgc;
  final ReadWriteLock pgd;
  private StringBuilder pge;
  
  public h(String paramString)
  {
    AppMethodBeat.i(148591);
    this.pgd = new ReentrantReadWriteLock();
    this.pge = new StringBuilder();
    this.pgc = new LinkedHashMap();
    this.pgb = paramString;
    AppMethodBeat.o(148591);
  }
  
  public final boolean a(h paramh)
  {
    AppMethodBeat.i(148599);
    this.pgd.readLock().lock();
    Iterator localIterator = this.pgc.values().iterator();
    while (localIterator.hasNext())
    {
      a locala1 = (a)localIterator.next();
      a locala2 = new a(paramh.pgb);
      locala2.pgi = locala1.pgi;
      paramh.pgc.put(locala2.pgf, locala2);
    }
    this.pgd.readLock().unlock();
    AppMethodBeat.o(148599);
    return true;
  }
  
  public final LinkedList<etl> bPE()
  {
    AppMethodBeat.i(148592);
    LinkedList localLinkedList = new LinkedList();
    this.pgd.readLock().lock();
    Iterator localIterator = this.pgc.values().iterator();
    while (localIterator.hasNext())
    {
      a locala = (a)localIterator.next();
      if (locala.pgg) {
        localLinkedList.add(new etl().btH(locala.pgf));
      }
    }
    this.pgd.readLock().unlock();
    AppMethodBeat.o(148592);
    return localLinkedList;
  }
  
  public final boolean bPF()
  {
    AppMethodBeat.i(148594);
    this.pgd.readLock().lock();
    if (this.pgc.size() == 0)
    {
      Log.i("MicroMsg.ShortSentenceContainer", "isAllRespEnd innerContainer.size() == 0");
      this.pgd.readLock().unlock();
      AppMethodBeat.o(148594);
      return true;
    }
    Iterator localIterator = this.pgc.values().iterator();
    a locala;
    do
    {
      if (!localIterator.hasNext()) {
        break;
      }
      locala = (a)localIterator.next();
      Log.d("MicroMsg.ShortSentenceContainer", "isAllRespEnd voiceId:%s isRequestEnd:%s isResponseEnd:%s", new Object[] { locala.pgf, Boolean.valueOf(locala.pgh), Boolean.valueOf(locala.pgl) });
    } while (locala.pgl);
    for (boolean bool = false;; bool = true)
    {
      this.pgd.readLock().unlock();
      AppMethodBeat.o(148594);
      return bool;
    }
  }
  
  public final void bPG()
  {
    AppMethodBeat.i(148597);
    Log.i("MicroMsg.ShortSentenceContainer", "createNewShortSentence");
    this.pgd.writeLock().lock();
    a locala = new a();
    this.pgc.put(locala.pgf, locala);
    this.pgd.writeLock().unlock();
    AppMethodBeat.o(148597);
  }
  
  public final void cl(List<fzh> paramList)
  {
    AppMethodBeat.i(148595);
    int i;
    Object localObject;
    if (paramList == null)
    {
      i = 0;
      this.pgd.readLock().lock();
      if (this.pgc.size() != 0) {
        break label112;
      }
      this.pgd.readLock().unlock();
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
      localIterator = this.pgc.values().iterator();
      while (localIterator.hasNext()) {
        ((StringBuilder)localObject).append(((a)localIterator.next()).pgf).append(", ");
      }
      if (((StringBuilder)localObject).length() <= 3)
      {
        this.pgd.readLock().unlock();
        localObject = "]";
      }
      else
      {
        ((StringBuilder)localObject).setLength(((StringBuilder)localObject).length() - 2);
        this.pgd.readLock().unlock();
        localObject = "]";
      }
    }
    label259:
    this.pgd.readLock().lock();
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      fzh localfzh = (fzh)localIterator.next();
      if (localfzh == null)
      {
        Log.i("MicroMsg.ShortSentenceContainer", "setFetchedVoiceInfoResult voiceTransCell is null.");
      }
      else
      {
        a locala = (a)this.pgc.get(localfzh.YWC);
        if (locala == null)
        {
          Log.i("MicroMsg.ShortSentenceContainer", "voiceInfoContainer not found the voiceId %s", new Object[] { localfzh.YWC });
        }
        else if (localfzh == null)
        {
          Log.d("MicroMsg.ShortSentenceContainer", "update VoiceInfo cell is null");
        }
        else
        {
          String str1 = localfzh.YWC;
          i = localfzh.abWG;
          label411:
          boolean bool1;
          label422:
          int j;
          String str2;
          boolean bool2;
          boolean bool3;
          int k;
          int m;
          if ((localfzh.abRI == null) || (localfzh.abRI.aaxD == null))
          {
            paramList = null;
            if (localfzh.oOu == 0) {
              break label622;
            }
            bool1 = true;
            j = localfzh.oOu;
            str2 = locala.pgf;
            bool2 = locala.pgg;
            bool3 = locala.pgh;
            k = locala.pgi;
            m = locala.pgk;
            if (locala.data != null) {
              break label628;
            }
          }
          label622:
          label628:
          for (localObject = null;; localObject = Integer.valueOf(locala.data.length()))
          {
            Log.d("MicroMsg.ShortSentenceContainer", "update VoiceInfo get {cell} %s, seq %s, text %s, endFlag %s, endFlag %s {currentInfo} %s, isRequestStart %s, isRequestEnd %s, voiceFileMark %s, seq %s, data %s, isResponseEnd %s", new Object[] { str1, Integer.valueOf(i), paramList, Boolean.valueOf(bool1), Integer.valueOf(j), str2, Boolean.valueOf(bool2), Boolean.valueOf(bool3), Integer.valueOf(k), Integer.valueOf(m), localObject, Boolean.valueOf(locala.pgl) });
            if ((localfzh.abWG >= locala.pgk) && (!locala.pgl)) {
              break label644;
            }
            Log.d("MicroMsg.ShortSentenceContainer", "update seq not fit.");
            break;
            paramList = Integer.valueOf(localfzh.abRI.abwJ);
            break label411;
            bool1 = false;
            break label422;
          }
          label644:
          locala.pgk = localfzh.abWG;
          if ((localfzh.abRI == null) || (localfzh.abRI.aaxD == null))
          {
            paramList = null;
            label675:
            locala.data = paramList;
            if (localfzh.oOu == 0) {
              break label813;
            }
            bool1 = true;
            label692:
            locala.pgl = bool1;
            paramList = localfzh.YWC;
            j = locala.pgk;
            bool1 = locala.pgl;
            if (locala.data != null) {
              break label819;
            }
          }
          label813:
          label819:
          for (i = -1;; i = locala.data.length())
          {
            Log.i("MicroMsg.ShortSentenceContainer", "update VoiceId = %s,respSeq = %s,isResponseEnd = %s,data.length = %s", new Object[] { paramList, Integer.valueOf(j), Boolean.valueOf(bool1), Integer.valueOf(i) });
            if (localfzh.oOu != 2) {
              break;
            }
            Log.e("MicroMsg.ShortSentenceContainer", "update cell.EndFlag = 2 VoiceId = %s", new Object[] { localfzh.YWC });
            break;
            paramList = localfzh.abRI.aaxD.ZV();
            break label675;
            bool1 = false;
            break label692;
          }
        }
      }
    }
    this.pgd.readLock().unlock();
    AppMethodBeat.o(148595);
  }
  
  public final String getResult()
  {
    AppMethodBeat.i(148593);
    this.pge.setLength(0);
    this.pgd.readLock().lock();
    Object localObject = this.pgc.values().iterator();
    while (((Iterator)localObject).hasNext())
    {
      a locala = (a)((Iterator)localObject).next();
      if (locala.data != null) {
        this.pge.append(locala.data);
      }
    }
    this.pgd.readLock().unlock();
    localObject = this.pge.toString();
    AppMethodBeat.o(148593);
    return localObject;
  }
  
  public final boolean isValid()
  {
    AppMethodBeat.i(185490);
    if ((this.pgc == null) || (this.pgc.isEmpty()))
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
    this.pgd.readLock().lock();
    if (this.pgc.size() == 0)
    {
      Log.e("MicroMsg.ShortSentenceContainer", "splitShortSentence there is no last one");
      this.pgd.readLock().unlock();
      AppMethodBeat.o(148596);
      return;
    }
    Iterator localIterator = this.pgc.values().iterator();
    for (Object localObject = null; localIterator.hasNext(); localObject = (a)localIterator.next()) {}
    if (localObject == null)
    {
      localObject = new IllegalStateException("splitShortSentence last info is null");
      AppMethodBeat.o(148596);
      throw ((Throwable)localObject);
    }
    Log.d("MicroMsg.ShortSentenceContainer", "cutShortSentence voiceFileMarkEnd:%s voiceId:%s markEnd:%s", new Object[] { Integer.valueOf(((a)localObject).pgi), ((a)localObject).pgf, Integer.valueOf(paramInt) });
    ((a)localObject).pgi = paramInt;
    this.pgd.readLock().unlock();
    AppMethodBeat.o(148596);
  }
  
  public final a xm(int paramInt)
  {
    AppMethodBeat.i(148598);
    this.pgd.readLock().lock();
    if (this.pgc.size() == 0)
    {
      this.pgd.readLock().unlock();
      AppMethodBeat.o(148598);
      return null;
    }
    Iterator localIterator = this.pgc.values().iterator();
    a locala;
    do
    {
      if (!localIterator.hasNext()) {
        break;
      }
      locala = (a)localIterator.next();
      Log.d("MicroMsg.ShortSentenceContainer", "locateCurrentShortSentence oldOffset = %s voiceFileMarkEnd = %s info.isRequestEnd = %s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(locala.pgi), Boolean.valueOf(locala.pgh) });
    } while ((locala.pgh) || (paramInt > locala.pgi));
    for (;;)
    {
      this.pgd.readLock().unlock();
      AppMethodBeat.o(148598);
      return locala;
      locala = null;
    }
  }
  
  public final class a
  {
    public String data;
    public String pgf;
    public boolean pgg;
    public boolean pgh;
    public int pgi;
    public int pgj;
    public int pgk;
    public boolean pgl;
    
    public a()
    {
      AppMethodBeat.i(148588);
      this.pgg = false;
      this.pgh = false;
      this.pgi = 2147483647;
      this.pgj = 0;
      this.pgk = -1;
      this.data = null;
      this.pgl = false;
      this.pgf = QU(h.this.pgb);
      AppMethodBeat.o(148588);
    }
    
    public a(String paramString)
    {
      AppMethodBeat.i(148589);
      this.pgg = false;
      this.pgh = false;
      this.pgi = 2147483647;
      this.pgj = 0;
      this.pgk = -1;
      this.data = null;
      this.pgl = false;
      this.pgf = QU(paramString);
      AppMethodBeat.o(148589);
    }
    
    private static String QU(String paramString)
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.modelvoiceaddr.h
 * JD-Core Version:    0.7.0.1
 */