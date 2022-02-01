package com.tencent.mm.av;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.b;
import com.tencent.mm.g.c.dy;
import com.tencent.mm.kernel.e;
import com.tencent.mm.l.a;
import com.tencent.mm.l.a.a;
import com.tencent.mm.model.bi;
import com.tencent.mm.model.bk;
import com.tencent.mm.model.u;
import com.tencent.mm.model.w;
import com.tencent.mm.plugin.messenger.foundation.a.k;
import com.tencent.mm.plugin.report.service.g.a;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.ax;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.sdk.platformtools.s;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.bo;
import com.tencent.mm.vfs.i;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class n
{
  private static n hJe;
  ConcurrentHashMap<Long, d> hJc;
  public c hJd;
  public ConcurrentHashMap<Long, e> hJf;
  private ArrayList<Long> hJg;
  ArrayList<e> hJh;
  
  public n()
  {
    AppMethodBeat.i(150733);
    this.hJc = new ConcurrentHashMap();
    this.hJf = new ConcurrentHashMap();
    this.hJg = new ArrayList();
    this.hJh = new ArrayList();
    this.hJd = new c();
    AppMethodBeat.o(150733);
  }
  
  private boolean Cu(String paramString)
  {
    AppMethodBeat.i(150740);
    Iterator localIterator = this.hJh.iterator();
    while (localIterator.hasNext()) {
      if (((e)localIterator.next()).hJt.equals(paramString))
      {
        AppMethodBeat.o(150740);
        return true;
      }
    }
    AppMethodBeat.o(150740);
    return false;
  }
  
  public static n aFl()
  {
    AppMethodBeat.i(150734);
    if (hJe == null) {}
    try
    {
      if (hJe == null) {
        hJe = new n();
      }
      n localn = hJe;
      AppMethodBeat.o(150734);
      return localn;
    }
    finally
    {
      AppMethodBeat.o(150734);
    }
  }
  
  private static int g(String paramString1, String paramString2, boolean paramBoolean)
  {
    AppMethodBeat.i(150743);
    if (u.f(paramString1, paramString2, paramBoolean))
    {
      AppMethodBeat.o(150743);
      return 1;
    }
    AppMethodBeat.o(150743);
    return 0;
  }
  
  public final ArrayList<String> Cs(String paramString)
  {
    AppMethodBeat.i(150735);
    ArrayList localArrayList = new ArrayList();
    if (!bs.isNullOrNil(paramString))
    {
      Iterator localIterator = this.hJf.values().iterator();
      while (localIterator.hasNext())
      {
        e locale = (e)localIterator.next();
        if (paramString.equals(locale.dfJ)) {
          localArrayList.add(locale.hJt);
        }
      }
    }
    AppMethodBeat.o(150735);
    return localArrayList;
  }
  
  public final ArrayList<Integer> Ct(String paramString)
  {
    AppMethodBeat.i(150736);
    Object localObject1 = this.hJf.values();
    Object localObject2 = ((Collection)localObject1).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      e locale = (e)((Iterator)localObject2).next();
      PString localPString = new PString();
      PInt localPInt1 = new PInt();
      PInt localPInt2 = new PInt();
      locale.hJw = o.aFx().a(locale.hJt, locale.hGP, locale.dbL, locale.dlE, localPString, localPInt1, localPInt2, locale.hJu, locale.hJv, locale.msgId, locale.hJA, locale.hJB, locale.hJC);
      bo localbo = ((k)com.tencent.mm.kernel.g.ab(k.class)).dcr().vP(locale.msgId);
      if (bs.isNullOrNil(localbo.field_imgPath))
      {
        localbo.rf(localPString.value);
        localbo.ke(localPInt1.value);
        localbo.kf(localPInt2.value);
        ((k)com.tencent.mm.kernel.g.ab(k.class)).dcr().a(locale.msgId, localbo);
      }
    }
    if (!bs.isNullOrNil(paramString))
    {
      localObject1 = ((Collection)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (e)((Iterator)localObject1).next();
        if (!paramString.equals(((e)localObject2).dfJ))
        {
          this.hJf.remove(Long.valueOf(((e)localObject2).msgId));
          this.hJg.remove(Long.valueOf(((e)localObject2).msgId));
          ac.e("MicroMsg.SendImgSpeeder", "fatal!! Send user mis-match, want:%s, fact:%s", new Object[] { paramString, ((e)localObject2).dfJ });
        }
      }
    }
    paramString = new ArrayList();
    int i = 0;
    while (i < this.hJg.size())
    {
      paramString.add(Integer.valueOf((int)((e)this.hJf.get(this.hJg.get(i))).hJw));
      i += 1;
    }
    this.hJf.clear();
    this.hJg.clear();
    ac.i("MicroMsg.SendImgSpeeder", "syncImgData, id size %d", new Object[] { Integer.valueOf(paramString.size()) });
    AppMethodBeat.o(150736);
    return paramString;
  }
  
  public final void a(int paramInt1, int paramInt2, String paramString1, String paramString2, boolean paramBoolean)
  {
    AppMethodBeat.i(150742);
    if (Cu(paramString1))
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
    if (aFm())
    {
      localObject2 = this.hJd.oY(1);
      localObject1 = this.hJd.oY(2);
      localb1 = ((b)localObject2).hJp;
      localb2 = ((b)localObject1).hJp;
      localObject1 = ((b)localObject1).hJq;
      localObject2 = ((b)localObject2).hJq;
    }
    o.aFx().a(paramString1, i, localPString, localPInt1, localPInt2, paramInt2, (String)localObject1);
    localObject1 = e.a(paramString1, i, paramInt1, paramInt2, (String)localObject1, (String)localObject2, localPString, localPInt1, localPInt2, localb1, localb2);
    ((e)localObject1).dfJ = paramString2;
    this.hJh.add(localObject1);
    ac.i("MicroMsg.SendImgSpeeder", "summersafecdn img path %s has prebuild, user:%s", new Object[] { paramString1, paramString2 });
    AppMethodBeat.o(150742);
  }
  
  public final void a(ArrayList<String> paramArrayList, boolean paramBoolean, int paramInt1, int paramInt2, String paramString)
  {
    AppMethodBeat.i(150739);
    ac.i("MicroMsg.SendImgSpeeder", "summersafecdn sendThumbImg fileSize:%d, compressImg[%b], source[%d], user:%s", new Object[] { Integer.valueOf(paramArrayList.size()), Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt1), paramString });
    Object localObject1 = this.hJh.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (e)((Iterator)localObject1).next();
      if ((!paramArrayList.contains(((e)localObject2).hJt)) || ((!bs.isNullOrNil(((e)localObject2).dfJ)) && (!((e)localObject2).dfJ.equalsIgnoreCase(paramString))) || ((!bs.isNullOrNil(paramString)) && (!paramString.equalsIgnoreCase(((e)localObject2).dfJ)))) {
        ((Iterator)localObject1).remove();
      } else {
        ((e)localObject2).hGP = g(((e)localObject2).hJt, paramString, paramBoolean);
      }
    }
    localObject1 = new ArrayList();
    Object localObject2 = paramArrayList.iterator();
    String str;
    while (((Iterator)localObject2).hasNext())
    {
      str = (String)((Iterator)localObject2).next();
      Iterator localIterator = this.hJh.iterator();
      while (localIterator.hasNext())
      {
        e locale = (e)localIterator.next();
        if (locale.hJt.equals(str)) {
          ((ArrayList)localObject1).add(locale);
        }
      }
    }
    this.hJh.clear();
    this.hJh.addAll((Collection)localObject1);
    localObject1 = new ArrayList();
    if (paramArrayList.size() == 9)
    {
      com.tencent.mm.plugin.report.service.g.MH(18);
      paramArrayList = paramArrayList.iterator();
    }
    for (;;)
    {
      if (!paramArrayList.hasNext()) {
        break label482;
      }
      localObject2 = (String)paramArrayList.next();
      if ((localObject2 == null) || (((String)localObject2).equals("")) || (!i.eA((String)localObject2)))
      {
        ac.d("MicroMsg.SendImgSpeeder", " doSendImage : filePath is null or empty");
        continue;
        if (paramArrayList.size() == 1)
        {
          boolean bool = ax.isWifi(ai.getContext());
          com.tencent.mm.plugin.report.service.g.MH(25);
          if (!bool) {
            break;
          }
          if (u.f((String)paramArrayList.get(0), paramString, paramBoolean))
          {
            com.tencent.mm.plugin.report.service.g.MH(23);
            break;
          }
          com.tencent.mm.plugin.report.service.g.MH(21);
          break;
        }
        com.tencent.mm.plugin.report.service.g.MH(24);
        break;
      }
      if (s.aKD((String)localObject2)) {
        ac.i("MicroMsg.SendImgSpeeder", "[cpan] is gif coutinue. did not add filePath:%s filesize:%d", new Object[] { localObject2, Long.valueOf(i.aSp((String)localObject2)) });
      } else if (!Cu((String)localObject2)) {
        ((ArrayList)localObject1).add(localObject2);
      }
    }
    label482:
    paramArrayList = ((ArrayList)localObject1).iterator();
    while (paramArrayList.hasNext()) {
      a(paramInt1, paramInt2, (String)paramArrayList.next(), paramString, paramBoolean);
    }
    paramArrayList = new ArrayList();
    long l1 = com.tencent.mm.kernel.g.agR().ghG.vE(Thread.currentThread().getId());
    ((k)com.tencent.mm.kernel.g.ab(k.class)).dcr().alf("SendImgSpeeder");
    paramInt1 = 1;
    paramInt2 = 0;
    if (paramInt2 < this.hJh.size())
    {
      localObject1 = (e)this.hJh.get(paramInt2);
      if (s.aKD(((e)localObject1).hJt)) {
        ac.i("MicroMsg.SendImgSpeeder", "[cpan] is gif coutinue. did not add to msg table");
      }
      for (;;)
      {
        paramInt2 += 1;
        break;
        localObject2 = new bo();
        ((bo)localObject2).setType(w.xu(paramString));
        ((bo)localObject2).re(paramString);
        ((bo)localObject2).jT(1);
        ((bo)localObject2).setStatus(1);
        ((bo)localObject2).rf(((e)localObject1).hJx.value);
        ((bo)localObject2).ke(((e)localObject1).hJy.value);
        ((bo)localObject2).kf(((e)localObject1).hJz.value);
        str = bk.TG();
        if (((str != null) && (!str.equals(((dy)localObject2).eul))) || ((str == null) && (((dy)localObject2).eul != null))) {
          ((bo)localObject2).qf(str);
        }
        a.a.Xf().n((bo)localObject2);
        ((bo)localObject2).oA(bi.yp(((dy)localObject2).field_talker));
        paramArrayList.add(localObject2);
        long l2 = ((k)com.tencent.mm.kernel.g.ab(k.class)).dcr().ap((bo)localObject2);
        if (l2 <= 0L)
        {
          ac.e("MicroMsg.SendImgSpeeder", "insert error! %s", new Object[] { paramString });
          paramInt1 = 0;
        }
        else
        {
          ((e)localObject1).msgId = l2;
          this.hJf.put(Long.valueOf(((e)localObject1).msgId), localObject1);
          this.hJg.add(Long.valueOf(((e)localObject1).msgId));
          paramInt1 = 0;
        }
      }
    }
    this.hJh.clear();
    if (l1 > 0L) {
      com.tencent.mm.kernel.g.agR().ghG.qL(l1);
    }
    if (paramInt1 != 0) {
      ((k)com.tencent.mm.kernel.g.ab(k.class)).dcr().alg("SendImgSpeeder");
    }
    AppMethodBeat.o(150739);
  }
  
  public final boolean aFm()
  {
    AppMethodBeat.i(150741);
    if ((this.hJh.size() > 0) && (g.a.dyR().wUh <= 2))
    {
      ac.i("MicroMsg.SendImgSpeeder", "cpu core is low ,do not use multi mode");
      AppMethodBeat.o(150741);
      return false;
    }
    AppMethodBeat.o(150741);
    return true;
  }
  
  public final boolean qi(long paramLong)
  {
    AppMethodBeat.i(150737);
    boolean bool = this.hJc.containsKey(Long.valueOf(paramLong));
    AppMethodBeat.o(150737);
    return bool;
  }
  
  public final d qj(long paramLong)
  {
    AppMethodBeat.i(150738);
    d locald = (d)this.hJc.get(Long.valueOf(paramLong));
    AppMethodBeat.o(150738);
    return locald;
  }
  
  public static class a
  {
    static ao cEw;
    private ReentrantLock cEu;
    private Condition cEv;
    int hGP;
    a hJi;
    
    public a()
    {
      AppMethodBeat.i(150721);
      this.cEu = new ReentrantLock();
      this.cEv = this.cEu.newCondition();
      AppMethodBeat.o(150721);
    }
    
    public static a a(final n.e parame)
    {
      AppMethodBeat.i(150722);
      try
      {
        if (cEw == null) {
          cEw = new ao("big file gen Worker");
        }
        a locala1 = new a();
        parame.hJC = locala1;
        a locala2 = parame.hJC;
        cEw.post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(150720);
            long l = System.currentTimeMillis();
            n.a.a locala = new n.a.a();
            locala.hJl = new PString();
            locala.hJm = new PString();
            locala.hJn = new PString();
            locala.hJo = new PString();
            String str = f.Ck(parame.hJt);
            locala.hGY = o.aFx().a(parame.hJt, str, parame.hGP, true, locala.hJl, locala.hJm, locala.hJn, locala.hJo, parame.hJv, parame.hJA);
            n.a.a(n.a.this).lock();
            try
            {
              n.a.this.hJi = locala;
              n.a.b(n.a.this).signal();
              ac.i("MicroMsg.SendImgSpeeder", "notify big file gen prepared %s last %d", new Object[] { parame.hJt, Long.valueOf(System.currentTimeMillis() - Long.valueOf(l).longValue()) });
              return;
            }
            finally
            {
              n.a.a(n.a.this).unlock();
              AppMethodBeat.o(150720);
            }
          }
        });
        locala1.hGP = parame.hGP;
        AppMethodBeat.o(150722);
        return locala1;
      }
      finally
      {
        AppMethodBeat.o(150722);
      }
    }
    
    /* Error */
    public final a aFo()
    {
      // Byte code:
      //   0: ldc 83
      //   2: invokestatic 32	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   5: aload_0
      //   6: getfield 37	com/tencent/mm/av/n$a:cEu	Ljava/util/concurrent/locks/ReentrantLock;
      //   9: invokevirtual 86	java/util/concurrent/locks/ReentrantLock:lock	()V
      //   12: aload_0
      //   13: getfield 88	com/tencent/mm/av/n$a:hJi	Lcom/tencent/mm/av/n$a$a;
      //   16: ifnonnull +42 -> 58
      //   19: ldc 90
      //   21: ldc 92
      //   23: invokestatic 97	com/tencent/mm/sdk/platformtools/ac:i	(Ljava/lang/String;Ljava/lang/String;)V
      //   26: aload_0
      //   27: getfield 43	com/tencent/mm/av/n$a:cEv	Ljava/util/concurrent/locks/Condition;
      //   30: invokeinterface 102 1 0
      //   35: goto -23 -> 12
      //   38: astore_1
      //   39: aload_0
      //   40: getfield 37	com/tencent/mm/av/n$a:cEu	Ljava/util/concurrent/locks/ReentrantLock;
      //   43: invokevirtual 105	java/util/concurrent/locks/ReentrantLock:unlock	()V
      //   46: aload_0
      //   47: getfield 88	com/tencent/mm/av/n$a:hJi	Lcom/tencent/mm/av/n$a$a;
      //   50: astore_1
      //   51: ldc 83
      //   53: invokestatic 46	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   56: aload_1
      //   57: areturn
      //   58: aload_0
      //   59: getfield 37	com/tencent/mm/av/n$a:cEu	Ljava/util/concurrent/locks/ReentrantLock;
      //   62: invokevirtual 105	java/util/concurrent/locks/ReentrantLock:unlock	()V
      //   65: goto -19 -> 46
      //   68: astore_1
      //   69: aload_0
      //   70: getfield 37	com/tencent/mm/av/n$a:cEu	Ljava/util/concurrent/locks/ReentrantLock;
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
      String hGY;
      PString hJl;
      PString hJm;
      PString hJn;
      PString hJo;
    }
  }
  
  static final class b
  {
    b hJp;
    String hJq;
  }
  
  public static final class c
  {
    private LinkedList<n.b> hJr;
    private LinkedList<n.b> hJs;
    
    public c()
    {
      AppMethodBeat.i(150724);
      this.hJr = new LinkedList();
      this.hJs = new LinkedList();
      AppMethodBeat.o(150724);
    }
    
    private static boolean Cv(String paramString)
    {
      AppMethodBeat.i(150728);
      if (i.aSp(paramString) > 0L)
      {
        ac.e("MicroMsg.SendImgSpeeder", "file has exist %s", new Object[] { paramString });
        AppMethodBeat.o(150728);
        return false;
      }
      AppMethodBeat.o(150728);
      return true;
    }
    
    private static n.b aFq()
    {
      AppMethodBeat.i(150726);
      n.b localb = new n.b((byte)0);
      if (bs.isNullOrNil(null)) {}
      String str;
      for (localb.hJq = g.aFg();; localb.hJq = null)
      {
        str = o.aFx().Co(localb.hJq);
        if (Cv(str)) {
          break;
        }
        AppMethodBeat.o(150726);
        return null;
      }
      localb.hJp = new b(str);
      AppMethodBeat.o(150726);
      return localb;
    }
    
    private static n.b aFr()
    {
      AppMethodBeat.i(150727);
      n.b localb = new n.b((byte)0);
      if (bs.isNullOrNil(null)) {}
      String str;
      for (localb.hJq = g.aFg();; localb.hJq = null)
      {
        str = o.aFx().Cn(localb.hJq);
        if (Cv(str)) {
          break;
        }
        AppMethodBeat.o(150727);
        return null;
      }
      localb.hJp = new b(str);
      AppMethodBeat.o(150727);
      return localb;
    }
    
    private void aFs()
    {
      for (;;)
      {
        int i;
        try
        {
          AppMethodBeat.i(150730);
          StringBuilder localStringBuilder = new StringBuilder();
          i = 0;
          if (i < this.hJr.size())
          {
            localStringBuilder.append(((n.b)this.hJr.get(i)).hJq);
            if (i != this.hJr.size() - 1) {
              localStringBuilder.append("-");
            }
          }
          else
          {
            ac.d("MicroMsg.SendImgSpeeder", "sync big des to file %s ", new Object[] { localStringBuilder.toString() });
            com.tencent.mm.kernel.g.agR().agA().set(348176, localStringBuilder.toString());
            AppMethodBeat.o(150730);
            return;
          }
        }
        finally {}
        i += 1;
      }
    }
    
    private void aFt()
    {
      for (;;)
      {
        int i;
        try
        {
          AppMethodBeat.i(150731);
          StringBuilder localStringBuilder = new StringBuilder();
          i = 0;
          if (i < this.hJs.size())
          {
            localStringBuilder.append(((n.b)this.hJs.get(i)).hJq);
            if (i != this.hJs.size() - 1) {
              localStringBuilder.append("-");
            }
          }
          else
          {
            ac.d("MicroMsg.SendImgSpeeder", "sync thumb des to file %s ", new Object[] { localStringBuilder.toString() });
            com.tencent.mm.kernel.g.agR().agA().set(348177, localStringBuilder.toString());
            AppMethodBeat.o(150731);
            return;
          }
        }
        finally {}
        i += 1;
      }
    }
    
    public final void aFp()
    {
      int j = 0;
      try
      {
        AppMethodBeat.i(150725);
        int i = this.hJr.size();
        int k;
        n.b localb;
        if (i < 0)
        {
          k = 5 - i;
          i = 0;
          while (i < k)
          {
            localb = aFq();
            this.hJr.add(localb);
            i += 1;
          }
          ac.i("MicroMsg.SendImgSpeeder", "add big File pool added size %d , all size %d", new Object[] { Integer.valueOf(k), Integer.valueOf(this.hJr.size()) });
          aFs();
        }
        i = this.hJs.size();
        if (i < 0)
        {
          k = 5 - i;
          i = j;
          while (i < k)
          {
            localb = aFr();
            this.hJs.add(localb);
            i += 1;
          }
          aFt();
          ac.i("MicroMsg.SendImgSpeeder", "add big thumb pool added size %d , all size %d", new Object[] { Integer.valueOf(k), Integer.valueOf(this.hJs.size()) });
        }
        AppMethodBeat.o(150725);
        return;
      }
      finally {}
    }
    
    public final n.b oY(int paramInt)
    {
      for (;;)
      {
        try
        {
          AppMethodBeat.i(150729);
          n.b localb1 = null;
          if (paramInt == 1)
          {
            if (this.hJr.size() > 0)
            {
              localb1 = (n.b)this.hJr.remove();
              aFs();
              aFp();
              AppMethodBeat.o(150729);
              return localb1;
            }
            localb1 = aFq();
            continue;
          }
          if (paramInt == 2) {
            if (this.hJs.size() > 0)
            {
              localb1 = (n.b)this.hJs.remove();
              aFt();
            }
            else
            {
              n.b localb2 = aFr();
            }
          }
        }
        finally {}
      }
    }
  }
  
  public static final class d
  {
    public long dne;
    public long offset;
  }
  
  public static final class e
  {
    int dbL;
    String dfJ;
    int dlE;
    int hGP;
    b hJA;
    b hJB;
    n.a hJC;
    String hJt;
    String hJu;
    String hJv;
    long hJw;
    PString hJx;
    PInt hJy;
    PInt hJz;
    long msgId;
    
    public static e a(String paramString1, int paramInt1, int paramInt2, int paramInt3, String paramString2, String paramString3, PString paramPString, PInt paramPInt1, PInt paramPInt2, b paramb1, b paramb2)
    {
      AppMethodBeat.i(150732);
      e locale = new e();
      locale.hJt = paramString1;
      locale.hGP = paramInt1;
      locale.dbL = paramInt2;
      locale.dlE = paramInt3;
      locale.hJu = paramString2;
      locale.hJx = paramPString;
      locale.hJz = paramPInt2;
      locale.hJy = paramPInt1;
      locale.hJv = paramString3;
      locale.hJB = paramb2;
      locale.hJA = paramb1;
      if (n.aFn().aFm()) {
        n.a.a(locale);
      }
      AppMethodBeat.o(150732);
      return locale;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.av.n
 * JD-Core Version:    0.7.0.1
 */