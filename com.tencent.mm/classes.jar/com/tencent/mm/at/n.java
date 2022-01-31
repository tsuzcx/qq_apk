package com.tencent.mm.at;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.b;
import com.tencent.mm.g.c.dd;
import com.tencent.mm.l.a;
import com.tencent.mm.l.a.a;
import com.tencent.mm.model.bf;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.t;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.plugin.report.service.g.a;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.bi;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;

public class n
{
  private static n fGb;
  ConcurrentHashMap<Long, n.d> fFZ;
  public n.c fGa;
  public ConcurrentHashMap<Long, n.e> fGc;
  private ArrayList<Long> fGd;
  ArrayList<n.e> fGe;
  
  public n()
  {
    AppMethodBeat.i(78370);
    this.fFZ = new ConcurrentHashMap();
    this.fGc = new ConcurrentHashMap();
    this.fGd = new ArrayList();
    this.fGe = new ArrayList();
    this.fGa = new n.c();
    AppMethodBeat.o(78370);
  }
  
  public static n ahs()
  {
    AppMethodBeat.i(78371);
    if (fGb == null) {}
    try
    {
      if (fGb == null) {
        fGb = new n();
      }
      n localn = fGb;
      AppMethodBeat.o(78371);
      return localn;
    }
    finally
    {
      AppMethodBeat.o(78371);
    }
  }
  
  private static int h(String paramString1, String paramString2, boolean paramBoolean)
  {
    AppMethodBeat.i(78380);
    if (com.tencent.mm.model.r.g(paramString1, paramString2, paramBoolean))
    {
      AppMethodBeat.o(78380);
      return 1;
    }
    AppMethodBeat.o(78380);
    return 0;
  }
  
  private boolean tn(String paramString)
  {
    AppMethodBeat.i(78377);
    Iterator localIterator = this.fGe.iterator();
    while (localIterator.hasNext()) {
      if (((n.e)localIterator.next()).fGq.equals(paramString))
      {
        AppMethodBeat.o(78377);
        return true;
      }
    }
    AppMethodBeat.o(78377);
    return false;
  }
  
  public final void a(int paramInt1, int paramInt2, String paramString1, String paramString2, boolean paramBoolean)
  {
    AppMethodBeat.i(78379);
    if (tn(paramString1))
    {
      AppMethodBeat.o(78379);
      return;
    }
    int i = h(paramString1, paramString2, paramBoolean);
    PString localPString = new PString();
    PInt localPInt1 = new PInt();
    PInt localPInt2 = new PInt();
    b localb1 = null;
    b localb2 = null;
    Object localObject1 = null;
    Object localObject2 = null;
    if (aht())
    {
      localObject2 = this.fGa.lC(1);
      localObject1 = this.fGa.lC(2);
      localb1 = ((n.b)localObject2).fGm;
      localb2 = ((n.b)localObject1).fGm;
      localObject1 = ((n.b)localObject1).fGn;
      localObject2 = ((n.b)localObject2).fGn;
    }
    o.ahC().a(paramString1, i, localPString, localPInt1, localPInt2, paramInt2, (String)localObject1);
    localObject1 = n.e.a(paramString1, i, paramInt1, paramInt2, (String)localObject1, (String)localObject2, localPString, localPInt1, localPInt2, localb1, localb2);
    ((n.e)localObject1).toUserName = paramString2;
    this.fGe.add(localObject1);
    ab.i("MicroMsg.SendImgSpeeder", "summersafecdn img path %s has prebuild, user:%s", new Object[] { paramString1, paramString2 });
    AppMethodBeat.o(78379);
  }
  
  public final void a(ArrayList<String> paramArrayList, boolean paramBoolean, int paramInt1, int paramInt2, String paramString)
  {
    AppMethodBeat.i(78376);
    ab.i("MicroMsg.SendImgSpeeder", "summersafecdn sendThumbImg fileSize:%d, compressImg[%b], source[%d], user:%s", new Object[] { Integer.valueOf(paramArrayList.size()), Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt1), paramString });
    Object localObject1 = this.fGe.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (n.e)((Iterator)localObject1).next();
      if ((!paramArrayList.contains(((n.e)localObject2).fGq)) || ((!bo.isNullOrNil(((n.e)localObject2).toUserName)) && (!((n.e)localObject2).toUserName.equalsIgnoreCase(paramString))) || ((!bo.isNullOrNil(paramString)) && (!paramString.equalsIgnoreCase(((n.e)localObject2).toUserName)))) {
        ((Iterator)localObject1).remove();
      } else {
        ((n.e)localObject2).fDP = h(((n.e)localObject2).fGq, paramString, paramBoolean);
      }
    }
    localObject1 = new ArrayList();
    Object localObject2 = paramArrayList.iterator();
    String str;
    while (((Iterator)localObject2).hasNext())
    {
      str = (String)((Iterator)localObject2).next();
      Iterator localIterator = this.fGe.iterator();
      while (localIterator.hasNext())
      {
        n.e locale = (n.e)localIterator.next();
        if (locale.fGq.equals(str)) {
          ((ArrayList)localObject1).add(locale);
        }
      }
    }
    this.fGe.clear();
    this.fGe.addAll((Collection)localObject1);
    localObject1 = new ArrayList();
    if (paramArrayList.size() == 9)
    {
      com.tencent.mm.plugin.report.service.g.Cx(18);
      paramArrayList = paramArrayList.iterator();
    }
    for (;;)
    {
      if (!paramArrayList.hasNext()) {
        break label477;
      }
      localObject2 = (String)paramArrayList.next();
      if ((localObject2 == null) || (((String)localObject2).equals("")) || (!com.tencent.mm.vfs.e.cN((String)localObject2)))
      {
        ab.d("MicroMsg.SendImgSpeeder", " doSendImage : filePath is null or empty");
        continue;
        if (paramArrayList.size() == 1)
        {
          boolean bool = at.isWifi(ah.getContext());
          com.tencent.mm.plugin.report.service.g.Cx(25);
          if (!bool) {
            break;
          }
          if (com.tencent.mm.model.r.g((String)paramArrayList.get(0), paramString, paramBoolean))
          {
            com.tencent.mm.plugin.report.service.g.Cx(23);
            break;
          }
          com.tencent.mm.plugin.report.service.g.Cx(21);
          break;
        }
        com.tencent.mm.plugin.report.service.g.Cx(24);
        break;
      }
      if (com.tencent.mm.sdk.platformtools.r.aoY((String)localObject2)) {
        ab.i("MicroMsg.SendImgSpeeder", "[cpan] is gif coutinue. did not add filePath:%s filesize:%d", new Object[] { localObject2, Long.valueOf(com.tencent.mm.vfs.e.avI((String)localObject2)) });
      } else if (!tn((String)localObject2)) {
        ((ArrayList)localObject1).add(localObject2);
      }
    }
    label477:
    paramArrayList = ((ArrayList)localObject1).iterator();
    while (paramArrayList.hasNext()) {
      a(paramInt1, paramInt2, (String)paramArrayList.next(), paramString, paramBoolean);
    }
    paramArrayList = new ArrayList();
    long l1 = com.tencent.mm.kernel.g.RL().eHS.kr(Thread.currentThread().getId());
    ((j)com.tencent.mm.kernel.g.E(j.class)).bPQ().Th("SendImgSpeeder");
    paramInt1 = 1;
    paramInt2 = 0;
    if (paramInt2 < this.fGe.size())
    {
      localObject1 = (n.e)this.fGe.get(paramInt2);
      if (com.tencent.mm.sdk.platformtools.r.aoY(((n.e)localObject1).fGq)) {
        ab.i("MicroMsg.SendImgSpeeder", "[cpan] is gif coutinue. did not add to msg table");
      }
      for (;;)
      {
        paramInt2 += 1;
        break;
        localObject2 = new bi();
        ((bi)localObject2).setType(t.oG(paramString));
        ((bi)localObject2).kj(paramString);
        ((bi)localObject2).hL(1);
        ((bi)localObject2).setStatus(1);
        ((bi)localObject2).kk(((n.e)localObject1).fGu.value);
        ((bi)localObject2).hW(((n.e)localObject1).fGv.value);
        ((bi)localObject2).hX(((n.e)localObject1).fGw.value);
        str = bh.aaQ();
        if (((str != null) && (!str.equals(((dd)localObject2).dns))) || ((str == null) && (((dd)localObject2).dns != null))) {
          ((bi)localObject2).jl(str);
        }
        a.a.Ky().g((bi)localObject2);
        ((bi)localObject2).fQ(bf.py(((dd)localObject2).field_talker));
        paramArrayList.add(localObject2);
        long l2 = ((j)com.tencent.mm.kernel.g.E(j.class)).bPQ().Z((bi)localObject2);
        if (l2 <= 0L)
        {
          ab.e("MicroMsg.SendImgSpeeder", "insert error! %s", new Object[] { paramString });
          paramInt1 = 0;
        }
        else
        {
          ((n.e)localObject1).cpO = l2;
          this.fGc.put(Long.valueOf(((n.e)localObject1).cpO), localObject1);
          this.fGd.add(Long.valueOf(((n.e)localObject1).cpO));
          paramInt1 = 0;
        }
      }
    }
    this.fGe.clear();
    if (l1 > 0L) {
      com.tencent.mm.kernel.g.RL().eHS.nY(l1);
    }
    if (paramInt1 != 0) {
      ((j)com.tencent.mm.kernel.g.E(j.class)).bPQ().Ti("SendImgSpeeder");
    }
    AppMethodBeat.o(78376);
  }
  
  public final boolean aht()
  {
    AppMethodBeat.i(78378);
    if ((this.fGe.size() > 0) && (g.a.chR().qsQ <= 2))
    {
      ab.i("MicroMsg.SendImgSpeeder", "cpu core is low ,do not use multi mode");
      AppMethodBeat.o(78378);
      return false;
    }
    AppMethodBeat.o(78378);
    return true;
  }
  
  public final boolean gV(long paramLong)
  {
    AppMethodBeat.i(78374);
    boolean bool = this.fFZ.containsKey(Long.valueOf(paramLong));
    AppMethodBeat.o(78374);
    return bool;
  }
  
  public final n.d gW(long paramLong)
  {
    AppMethodBeat.i(78375);
    n.d locald = (n.d)this.fFZ.get(Long.valueOf(paramLong));
    AppMethodBeat.o(78375);
    return locald;
  }
  
  public final ArrayList<String> tl(String paramString)
  {
    AppMethodBeat.i(78372);
    ArrayList localArrayList = new ArrayList();
    if (!bo.isNullOrNil(paramString))
    {
      Iterator localIterator = this.fGc.values().iterator();
      while (localIterator.hasNext())
      {
        n.e locale = (n.e)localIterator.next();
        if (paramString.equals(locale.toUserName)) {
          localArrayList.add(locale.fGq);
        }
      }
    }
    AppMethodBeat.o(78372);
    return localArrayList;
  }
  
  public final ArrayList<Integer> tm(String paramString)
  {
    AppMethodBeat.i(78373);
    Object localObject1 = this.fGc.values();
    Object localObject2 = ((Collection)localObject1).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      n.e locale = (n.e)((Iterator)localObject2).next();
      PString localPString = new PString();
      PInt localPInt1 = new PInt();
      PInt localPInt2 = new PInt();
      locale.fGt = o.ahC().a(locale.fGq, locale.fDP, locale.cpt, locale.cyn, localPString, localPInt1, localPInt2, locale.fGr, locale.fGs, locale.cpO, locale.fGx, locale.fGy, locale.fGz);
      bi localbi = ((j)com.tencent.mm.kernel.g.E(j.class)).bPQ().kB(locale.cpO);
      if (bo.isNullOrNil(localbi.field_imgPath))
      {
        localbi.kk(localPString.value);
        localbi.hW(localPInt1.value);
        localbi.hX(localPInt2.value);
        ((j)com.tencent.mm.kernel.g.E(j.class)).bPQ().a(locale.cpO, localbi);
      }
    }
    if (!bo.isNullOrNil(paramString))
    {
      localObject1 = ((Collection)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (n.e)((Iterator)localObject1).next();
        if (!paramString.equals(((n.e)localObject2).toUserName))
        {
          this.fGc.remove(Long.valueOf(((n.e)localObject2).cpO));
          this.fGd.remove(Long.valueOf(((n.e)localObject2).cpO));
          ab.e("MicroMsg.SendImgSpeeder", "fatal!! Send user mis-match, want:%s, fact:%s", new Object[] { paramString, ((n.e)localObject2).toUserName });
        }
      }
    }
    paramString = new ArrayList();
    int i = 0;
    while (i < this.fGd.size())
    {
      paramString.add(Integer.valueOf((int)((n.e)this.fGc.get(this.fGd.get(i))).fGt));
      i += 1;
    }
    this.fGc.clear();
    this.fGd.clear();
    ab.i("MicroMsg.SendImgSpeeder", "syncImgData, id size %d", new Object[] { Integer.valueOf(paramString.size()) });
    AppMethodBeat.o(78373);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.at.n
 * JD-Core Version:    0.7.0.1
 */