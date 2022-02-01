package com.tencent.mm.av;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.b;
import com.tencent.mm.g.c.eo;
import com.tencent.mm.kernel.e;
import com.tencent.mm.m.a;
import com.tencent.mm.m.a.a;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.bp;
import com.tencent.mm.model.br;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.plugin.report.service.g.a;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.sdk.platformtools.ImgUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ca;
import com.tencent.mm.vfs.s;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class p
{
  private static p iZI;
  ConcurrentHashMap<Long, d> iZG;
  public c iZH;
  public ConcurrentHashMap<Long, e> iZJ;
  private ArrayList<Long> iZK;
  ArrayList<e> iZL;
  
  public p()
  {
    AppMethodBeat.i(150733);
    this.iZG = new ConcurrentHashMap();
    this.iZJ = new ConcurrentHashMap();
    this.iZK = new ArrayList();
    this.iZL = new ArrayList();
    this.iZH = new c();
    AppMethodBeat.o(150733);
  }
  
  private boolean OL(String paramString)
  {
    AppMethodBeat.i(150740);
    Iterator localIterator = this.iZL.iterator();
    while (localIterator.hasNext()) {
      if (((e)localIterator.next()).iZX.equals(paramString))
      {
        AppMethodBeat.o(150740);
        return true;
      }
    }
    AppMethodBeat.o(150740);
    return false;
  }
  
  public static p bcF()
  {
    AppMethodBeat.i(150734);
    if (iZI == null) {}
    try
    {
      if (iZI == null) {
        iZI = new p();
      }
      p localp = iZI;
      AppMethodBeat.o(150734);
      return localp;
    }
    finally
    {
      AppMethodBeat.o(150734);
    }
  }
  
  private static int g(String paramString1, String paramString2, boolean paramBoolean)
  {
    AppMethodBeat.i(150743);
    if (z.f(paramString1, paramString2, paramBoolean))
    {
      AppMethodBeat.o(150743);
      return 1;
    }
    AppMethodBeat.o(150743);
    return 0;
  }
  
  public final boolean AA(long paramLong)
  {
    AppMethodBeat.i(150737);
    boolean bool = this.iZG.containsKey(Long.valueOf(paramLong));
    AppMethodBeat.o(150737);
    return bool;
  }
  
  public final d AB(long paramLong)
  {
    AppMethodBeat.i(150738);
    d locald = (d)this.iZG.get(Long.valueOf(paramLong));
    AppMethodBeat.o(150738);
    return locald;
  }
  
  public final ArrayList<String> OJ(String paramString)
  {
    AppMethodBeat.i(150735);
    ArrayList localArrayList = new ArrayList();
    if (!Util.isNullOrNil(paramString))
    {
      Iterator localIterator = this.iZJ.values().iterator();
      while (localIterator.hasNext())
      {
        e locale = (e)localIterator.next();
        if (paramString.equals(locale.dJw)) {
          localArrayList.add(locale.iZX);
        }
      }
    }
    AppMethodBeat.o(150735);
    return localArrayList;
  }
  
  public final ArrayList<Integer> OK(String paramString)
  {
    AppMethodBeat.i(150736);
    Object localObject1 = this.iZJ.values();
    Object localObject2 = ((Collection)localObject1).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      e locale = (e)((Iterator)localObject2).next();
      PString localPString = new PString();
      PInt localPInt1 = new PInt();
      PInt localPInt2 = new PInt();
      locale.jaa = q.bcR().a(locale.dJw, locale.iZX, locale.iXp, locale.source, locale.dQd, localPString, localPInt1, localPInt2, locale.iZY, locale.iZZ, locale.msgId, locale.jae, locale.jaf, locale.jag, -1);
      ca localca = ((l)com.tencent.mm.kernel.g.af(l.class)).eiy().Hb(locale.msgId);
      if (Util.isNullOrNil(localca.field_imgPath))
      {
        localca.Cz(localPString.value);
        localca.nG(localPInt1.value);
        localca.nH(localPInt2.value);
        ((l)com.tencent.mm.kernel.g.af(l.class)).eiy().a(locale.msgId, localca);
      }
    }
    if (!Util.isNullOrNil(paramString))
    {
      localObject1 = ((Collection)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (e)((Iterator)localObject1).next();
        if (!paramString.equals(((e)localObject2).dJw))
        {
          this.iZJ.remove(Long.valueOf(((e)localObject2).msgId));
          this.iZK.remove(Long.valueOf(((e)localObject2).msgId));
          Log.e("MicroMsg.SendImgSpeeder", "fatal!! Send user mis-match, want:%s, fact:%s", new Object[] { paramString, ((e)localObject2).dJw });
        }
      }
    }
    paramString = new ArrayList();
    int i = 0;
    while (i < this.iZK.size())
    {
      paramString.add(Integer.valueOf((int)((e)this.iZJ.get(this.iZK.get(i))).jaa));
      i += 1;
    }
    this.iZJ.clear();
    this.iZK.clear();
    Log.i("MicroMsg.SendImgSpeeder", "syncImgData, id size %d", new Object[] { Integer.valueOf(paramString.size()) });
    AppMethodBeat.o(150736);
    return paramString;
  }
  
  public final void a(int paramInt1, int paramInt2, String paramString1, String paramString2, boolean paramBoolean)
  {
    AppMethodBeat.i(150742);
    if (OL(paramString1))
    {
      AppMethodBeat.o(150742);
      return;
    }
    int i = g(paramString1, paramString2, paramBoolean);
    PString localPString = new PString();
    PInt localPInt1 = new PInt();
    PInt localPInt2 = new PInt();
    b localb1 = null;
    b localb2 = null;
    Object localObject1 = null;
    Object localObject2 = null;
    if (bcG())
    {
      localObject2 = this.iZH.ts(1);
      localObject1 = this.iZH.ts(2);
      localb1 = ((b)localObject2).iZT;
      localb2 = ((b)localObject1).iZT;
      localObject1 = ((b)localObject1).iZU;
      localObject2 = ((b)localObject2).iZU;
    }
    q.bcR().a(paramString2, paramString1, i, localPString, localPInt1, localPInt2, paramInt2, 2131231628, (String)localObject1);
    localObject1 = e.a(paramString1, i, paramInt1, paramInt2, (String)localObject1, (String)localObject2, localPString, localPInt1, localPInt2, localb1, localb2);
    ((e)localObject1).dJw = paramString2;
    this.iZL.add(localObject1);
    Log.i("MicroMsg.SendImgSpeeder", "summersafecdn img path %s has prebuild, user:%s", new Object[] { paramString1, paramString2 });
    AppMethodBeat.o(150742);
  }
  
  public final void a(ArrayList<String> paramArrayList, boolean paramBoolean, int paramInt1, int paramInt2, String paramString)
  {
    AppMethodBeat.i(150739);
    Log.i("MicroMsg.SendImgSpeeder", "summersafecdn sendThumbImg fileSize:%d, compressImg[%b], source[%d], user:%s", new Object[] { Integer.valueOf(paramArrayList.size()), Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt1), paramString });
    Object localObject1 = this.iZL.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (e)((Iterator)localObject1).next();
      if ((!paramArrayList.contains(((e)localObject2).iZX)) || ((!Util.isNullOrNil(((e)localObject2).dJw)) && (!((e)localObject2).dJw.equalsIgnoreCase(paramString))) || ((!Util.isNullOrNil(paramString)) && (!paramString.equalsIgnoreCase(((e)localObject2).dJw)))) {
        ((Iterator)localObject1).remove();
      } else {
        ((e)localObject2).iXp = g(((e)localObject2).iZX, paramString, paramBoolean);
      }
    }
    localObject1 = new ArrayList();
    Object localObject2 = paramArrayList.iterator();
    String str;
    while (((Iterator)localObject2).hasNext())
    {
      str = (String)((Iterator)localObject2).next();
      Iterator localIterator = this.iZL.iterator();
      while (localIterator.hasNext())
      {
        e locale = (e)localIterator.next();
        if (locale.iZX.equals(str)) {
          ((ArrayList)localObject1).add(locale);
        }
      }
    }
    this.iZL.clear();
    this.iZL.addAll((Collection)localObject1);
    localObject1 = new ArrayList();
    if (paramArrayList.size() == 9)
    {
      com.tencent.mm.plugin.report.service.g.Wl(18);
      paramArrayList = paramArrayList.iterator();
    }
    for (;;)
    {
      if (!paramArrayList.hasNext()) {
        break label485;
      }
      localObject2 = (String)paramArrayList.next();
      if ((localObject2 == null) || (((String)localObject2).equals("")) || (!s.YS((String)localObject2)))
      {
        Log.d("MicroMsg.SendImgSpeeder", " doSendImage : filePath is null or empty");
        continue;
        if (paramArrayList.size() == 1)
        {
          boolean bool = NetStatusUtil.isWifi(MMApplicationContext.getContext());
          com.tencent.mm.plugin.report.service.g.Wl(25);
          if (!bool) {
            break;
          }
          if (z.f((String)paramArrayList.get(0), paramString, paramBoolean))
          {
            com.tencent.mm.plugin.report.service.g.Wl(23);
            break;
          }
          com.tencent.mm.plugin.report.service.g.Wl(21);
          break;
        }
        com.tencent.mm.plugin.report.service.g.Wl(24);
        break;
      }
      if (ImgUtil.isGif((String)localObject2)) {
        Log.i("MicroMsg.SendImgSpeeder", "[cpan] is gif coutinue. did not add filePath:%s filesize:%d", new Object[] { localObject2, Long.valueOf(s.boW((String)localObject2)) });
      } else if (!OL((String)localObject2)) {
        ((ArrayList)localObject1).add(localObject2);
      }
    }
    label485:
    paramArrayList = ((ArrayList)localObject1).iterator();
    while (paramArrayList.hasNext()) {
      a(paramInt1, paramInt2, (String)paramArrayList.next(), paramString, paramBoolean);
    }
    paramArrayList = new ArrayList();
    long l1 = com.tencent.mm.kernel.g.aAh().hqK.beginTransaction(Thread.currentThread().getId());
    ((l)com.tencent.mm.kernel.g.af(l.class)).eiy().aEs("SendImgSpeeder");
    paramInt1 = 1;
    paramInt2 = 0;
    if (paramInt2 < this.iZL.size())
    {
      localObject1 = (e)this.iZL.get(paramInt2);
      if (ImgUtil.isGif(((e)localObject1).iZX)) {
        Log.i("MicroMsg.SendImgSpeeder", "[cpan] is gif coutinue. did not add to msg table");
      }
      for (;;)
      {
        paramInt2 += 1;
        break;
        localObject2 = new ca();
        ((ca)localObject2).setType(ab.JH(paramString));
        ((ca)localObject2).Cy(paramString);
        ((ca)localObject2).nv(1);
        ((ca)localObject2).setStatus(1);
        ((ca)localObject2).Cz(((e)localObject1).jab.value);
        ((ca)localObject2).nG(((e)localObject1).jac.value);
        ((ca)localObject2).nH(((e)localObject1).jad.value);
        str = br.ajw();
        if (((str != null) && (!str.equals(((eo)localObject2).fqK))) || ((str == null) && (((eo)localObject2).fqK != null))) {
          ((ca)localObject2).BB(str);
        }
        a.a.anC().n((ca)localObject2);
        ((ca)localObject2).setCreateTime(bp.Kw(((eo)localObject2).field_talker));
        paramArrayList.add(localObject2);
        long l2 = ((l)com.tencent.mm.kernel.g.af(l.class)).eiy().aC((ca)localObject2);
        if (l2 <= 0L)
        {
          Log.e("MicroMsg.SendImgSpeeder", "insert error! %s", new Object[] { paramString });
          paramInt1 = 0;
        }
        else
        {
          ((e)localObject1).msgId = l2;
          this.iZJ.put(Long.valueOf(((e)localObject1).msgId), localObject1);
          this.iZK.add(Long.valueOf(((e)localObject1).msgId));
          paramInt1 = 0;
        }
      }
    }
    this.iZL.clear();
    if (l1 > 0L) {
      com.tencent.mm.kernel.g.aAh().hqK.endTransaction(l1);
    }
    if (paramInt1 != 0) {
      ((l)com.tencent.mm.kernel.g.af(l.class)).eiy().aEt("SendImgSpeeder");
    }
    AppMethodBeat.o(150739);
  }
  
  public final boolean bcG()
  {
    AppMethodBeat.i(150741);
    if ((this.iZL.size() > 0) && (g.a.eOH().CyB <= 2))
    {
      Log.i("MicroMsg.SendImgSpeeder", "cpu core is low ,do not use multi mode");
      AppMethodBeat.o(150741);
      return false;
    }
    AppMethodBeat.o(150741);
    return true;
  }
  
  public static class a
  {
    static MMHandler dgG;
    private ReentrantLock dgE;
    private Condition dgF;
    int iXp;
    a iZM;
    
    public a()
    {
      AppMethodBeat.i(150721);
      this.dgE = new ReentrantLock();
      this.dgF = this.dgE.newCondition();
      AppMethodBeat.o(150721);
    }
    
    public static a a(final p.e parame)
    {
      AppMethodBeat.i(150722);
      try
      {
        if (dgG == null) {
          dgG = new MMHandler("big file gen Worker");
        }
        a locala1 = new a();
        parame.jag = locala1;
        a locala2 = parame.jag;
        dgG.post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(150720);
            long l = System.currentTimeMillis();
            p.a.a locala = new p.a.a();
            locala.iZP = new PString();
            locala.iZQ = new PString();
            locala.iZR = new PString();
            locala.iZS = new PString();
            String str = h.Ow(parame.iZX);
            locala.iXy = q.bcR().a(parame.dJw, parame.iZX, str, parame.iXp, true, locala.iZP, locala.iZQ, locala.iZR, locala.iZS, parame.iZZ, parame.jae, -1);
            p.a.a(p.a.this).lock();
            try
            {
              p.a.this.iZM = locala;
              p.a.b(p.a.this).signal();
              Log.i("MicroMsg.SendImgSpeeder", "notify big file gen prepared %s last %d", new Object[] { parame.iZX, Long.valueOf(System.currentTimeMillis() - Long.valueOf(l).longValue()) });
              return;
            }
            finally
            {
              p.a.a(p.a.this).unlock();
              AppMethodBeat.o(150720);
            }
          }
        });
        locala1.iXp = parame.iXp;
        AppMethodBeat.o(150722);
        return locala1;
      }
      finally
      {
        AppMethodBeat.o(150722);
      }
    }
    
    /* Error */
    public final a bcI()
    {
      // Byte code:
      //   0: ldc 83
      //   2: invokestatic 32	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   5: aload_0
      //   6: getfield 37	com/tencent/mm/av/p$a:dgE	Ljava/util/concurrent/locks/ReentrantLock;
      //   9: invokevirtual 86	java/util/concurrent/locks/ReentrantLock:lock	()V
      //   12: aload_0
      //   13: getfield 88	com/tencent/mm/av/p$a:iZM	Lcom/tencent/mm/av/p$a$a;
      //   16: ifnonnull +42 -> 58
      //   19: ldc 90
      //   21: ldc 92
      //   23: invokestatic 97	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
      //   26: aload_0
      //   27: getfield 43	com/tencent/mm/av/p$a:dgF	Ljava/util/concurrent/locks/Condition;
      //   30: invokeinterface 102 1 0
      //   35: goto -23 -> 12
      //   38: astore_1
      //   39: aload_0
      //   40: getfield 37	com/tencent/mm/av/p$a:dgE	Ljava/util/concurrent/locks/ReentrantLock;
      //   43: invokevirtual 105	java/util/concurrent/locks/ReentrantLock:unlock	()V
      //   46: aload_0
      //   47: getfield 88	com/tencent/mm/av/p$a:iZM	Lcom/tencent/mm/av/p$a$a;
      //   50: astore_1
      //   51: ldc 83
      //   53: invokestatic 46	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   56: aload_1
      //   57: areturn
      //   58: aload_0
      //   59: getfield 37	com/tencent/mm/av/p$a:dgE	Ljava/util/concurrent/locks/ReentrantLock;
      //   62: invokevirtual 105	java/util/concurrent/locks/ReentrantLock:unlock	()V
      //   65: goto -19 -> 46
      //   68: astore_1
      //   69: aload_0
      //   70: getfield 37	com/tencent/mm/av/p$a:dgE	Ljava/util/concurrent/locks/ReentrantLock;
      //   73: invokevirtual 105	java/util/concurrent/locks/ReentrantLock:unlock	()V
      //   76: ldc 83
      //   78: invokestatic 46	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   81: aload_1
      //   82: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	83	0	this	a
      //   38	1	1	localException	java.lang.Exception
      //   50	7	1	locala	a
      //   68	14	1	localObject	Object
      // Exception table:
      //   from	to	target	type
      //   12	35	38	java/lang/Exception
      //   12	35	68	finally
    }
    
    public static final class a
    {
      String iXy;
      PString iZP;
      PString iZQ;
      PString iZR;
      PString iZS;
    }
  }
  
  static final class b
  {
    b iZT;
    String iZU;
  }
  
  public static final class c
  {
    private LinkedList<p.b> iZV;
    private LinkedList<p.b> iZW;
    
    public c()
    {
      AppMethodBeat.i(150724);
      this.iZV = new LinkedList();
      this.iZW = new LinkedList();
      AppMethodBeat.o(150724);
    }
    
    private static boolean OM(String paramString)
    {
      AppMethodBeat.i(150728);
      if (s.boW(paramString) > 0L)
      {
        Log.e("MicroMsg.SendImgSpeeder", "file has exist %s", new Object[] { paramString });
        AppMethodBeat.o(150728);
        return false;
      }
      AppMethodBeat.o(150728);
      return true;
    }
    
    private static p.b bcK()
    {
      AppMethodBeat.i(150726);
      p.b localb = new p.b((byte)0);
      if (Util.isNullOrNil(null)) {}
      String str;
      for (localb.iZU = i.bcA();; localb.iZU = null)
      {
        str = q.bcR().OD(localb.iZU);
        if (OM(str)) {
          break;
        }
        AppMethodBeat.o(150726);
        return null;
      }
      localb.iZT = new b(str);
      AppMethodBeat.o(150726);
      return localb;
    }
    
    private static p.b bcL()
    {
      AppMethodBeat.i(150727);
      p.b localb = new p.b((byte)0);
      if (Util.isNullOrNil(null)) {}
      String str;
      for (localb.iZU = i.bcA();; localb.iZU = null)
      {
        str = q.bcR().OC(localb.iZU);
        if (OM(str)) {
          break;
        }
        AppMethodBeat.o(150727);
        return null;
      }
      localb.iZT = new b(str);
      AppMethodBeat.o(150727);
      return localb;
    }
    
    private void bcM()
    {
      for (;;)
      {
        int i;
        try
        {
          AppMethodBeat.i(150730);
          StringBuilder localStringBuilder = new StringBuilder();
          i = 0;
          if (i < this.iZV.size())
          {
            localStringBuilder.append(((p.b)this.iZV.get(i)).iZU);
            if (i != this.iZV.size() - 1) {
              localStringBuilder.append("-");
            }
          }
          else
          {
            Log.d("MicroMsg.SendImgSpeeder", "sync big des to file %s ", new Object[] { localStringBuilder.toString() });
            com.tencent.mm.kernel.g.aAh().azQ().set(348176, localStringBuilder.toString());
            AppMethodBeat.o(150730);
            return;
          }
        }
        finally {}
        i += 1;
      }
    }
    
    private void bcN()
    {
      for (;;)
      {
        int i;
        try
        {
          AppMethodBeat.i(150731);
          StringBuilder localStringBuilder = new StringBuilder();
          i = 0;
          if (i < this.iZW.size())
          {
            localStringBuilder.append(((p.b)this.iZW.get(i)).iZU);
            if (i != this.iZW.size() - 1) {
              localStringBuilder.append("-");
            }
          }
          else
          {
            Log.d("MicroMsg.SendImgSpeeder", "sync thumb des to file %s ", new Object[] { localStringBuilder.toString() });
            com.tencent.mm.kernel.g.aAh().azQ().set(348177, localStringBuilder.toString());
            AppMethodBeat.o(150731);
            return;
          }
        }
        finally {}
        i += 1;
      }
    }
    
    public final void bcJ()
    {
      int j = 0;
      try
      {
        AppMethodBeat.i(150725);
        int i = this.iZV.size();
        int k;
        p.b localb;
        if (i < 0)
        {
          k = 5 - i;
          i = 0;
          while (i < k)
          {
            localb = bcK();
            this.iZV.add(localb);
            i += 1;
          }
          Log.i("MicroMsg.SendImgSpeeder", "add big File pool added size %d , all size %d", new Object[] { Integer.valueOf(k), Integer.valueOf(this.iZV.size()) });
          bcM();
        }
        i = this.iZW.size();
        if (i < 0)
        {
          k = 5 - i;
          i = j;
          while (i < k)
          {
            localb = bcL();
            this.iZW.add(localb);
            i += 1;
          }
          bcN();
          Log.i("MicroMsg.SendImgSpeeder", "add big thumb pool added size %d , all size %d", new Object[] { Integer.valueOf(k), Integer.valueOf(this.iZW.size()) });
        }
        AppMethodBeat.o(150725);
        return;
      }
      finally {}
    }
    
    public final p.b ts(int paramInt)
    {
      for (;;)
      {
        try
        {
          AppMethodBeat.i(150729);
          p.b localb1 = null;
          if (paramInt == 1)
          {
            if (this.iZV.size() > 0)
            {
              localb1 = (p.b)this.iZV.remove();
              bcM();
              bcJ();
              AppMethodBeat.o(150729);
              return localb1;
            }
            localb1 = bcK();
            continue;
          }
          if (paramInt == 2) {
            if (this.iZW.size() > 0)
            {
              localb1 = (p.b)this.iZW.remove();
              bcN();
            }
            else
            {
              p.b localb2 = bcL();
            }
          }
        }
        finally {}
      }
    }
  }
  
  public static final class d
  {
    public long offset;
    public long total;
  }
  
  public static final class e
  {
    String dJw;
    int dQd;
    int iXp;
    String iZX;
    String iZY;
    String iZZ;
    long jaa;
    PString jab;
    PInt jac;
    PInt jad;
    b jae;
    b jaf;
    p.a jag;
    long msgId;
    int source;
    
    public static e a(String paramString1, int paramInt1, int paramInt2, int paramInt3, String paramString2, String paramString3, PString paramPString, PInt paramPInt1, PInt paramPInt2, b paramb1, b paramb2)
    {
      AppMethodBeat.i(150732);
      e locale = new e();
      locale.iZX = paramString1;
      locale.iXp = paramInt1;
      locale.source = paramInt2;
      locale.dQd = paramInt3;
      locale.iZY = paramString2;
      locale.jab = paramPString;
      locale.jad = paramPInt2;
      locale.jac = paramPInt1;
      locale.iZZ = paramString3;
      locale.jaf = paramb2;
      locale.jae = paramb1;
      if (p.bcH().bcG()) {
        p.a.a(locale);
      }
      AppMethodBeat.o(150732);
      return locale;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.av.p
 * JD-Core Version:    0.7.0.1
 */