package com.tencent.mm.aw;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.b;
import com.tencent.mm.g.c.du;
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
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.ay;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.t;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.bl;
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
  private static n hiB;
  public c hiA;
  public ConcurrentHashMap<Long, e> hiC;
  private ArrayList<Long> hiD;
  ArrayList<e> hiE;
  ConcurrentHashMap<Long, d> hiz;
  
  public n()
  {
    AppMethodBeat.i(150733);
    this.hiz = new ConcurrentHashMap();
    this.hiC = new ConcurrentHashMap();
    this.hiD = new ArrayList();
    this.hiE = new ArrayList();
    this.hiA = new c();
    AppMethodBeat.o(150733);
  }
  
  public static n ayt()
  {
    AppMethodBeat.i(150734);
    if (hiB == null) {}
    try
    {
      if (hiB == null) {
        hiB = new n();
      }
      n localn = hiB;
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
  
  private boolean yp(String paramString)
  {
    AppMethodBeat.i(150740);
    Iterator localIterator = this.hiE.iterator();
    while (localIterator.hasNext()) {
      if (((e)localIterator.next()).hiQ.equals(paramString))
      {
        AppMethodBeat.o(150740);
        return true;
      }
    }
    AppMethodBeat.o(150740);
    return false;
  }
  
  public final void a(int paramInt1, int paramInt2, String paramString1, String paramString2, boolean paramBoolean)
  {
    AppMethodBeat.i(150742);
    if (yp(paramString1))
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
    if (ayu())
    {
      localObject2 = this.hiA.ok(1);
      localObject1 = this.hiA.ok(2);
      localb1 = ((b)localObject2).hiM;
      localb2 = ((b)localObject1).hiM;
      localObject1 = ((b)localObject1).hiN;
      localObject2 = ((b)localObject2).hiN;
    }
    o.ayF().a(paramString1, i, localPString, localPInt1, localPInt2, paramInt2, (String)localObject1);
    localObject1 = e.a(paramString1, i, paramInt1, paramInt2, (String)localObject1, (String)localObject2, localPString, localPInt1, localPInt2, localb1, localb2);
    ((e)localObject1).dio = paramString2;
    this.hiE.add(localObject1);
    ad.i("MicroMsg.SendImgSpeeder", "summersafecdn img path %s has prebuild, user:%s", new Object[] { paramString1, paramString2 });
    AppMethodBeat.o(150742);
  }
  
  public final void a(ArrayList<String> paramArrayList, boolean paramBoolean, int paramInt1, int paramInt2, String paramString)
  {
    AppMethodBeat.i(150739);
    ad.i("MicroMsg.SendImgSpeeder", "summersafecdn sendThumbImg fileSize:%d, compressImg[%b], source[%d], user:%s", new Object[] { Integer.valueOf(paramArrayList.size()), Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt1), paramString });
    Object localObject1 = this.hiE.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (e)((Iterator)localObject1).next();
      if ((!paramArrayList.contains(((e)localObject2).hiQ)) || ((!bt.isNullOrNil(((e)localObject2).dio)) && (!((e)localObject2).dio.equalsIgnoreCase(paramString))) || ((!bt.isNullOrNil(paramString)) && (!paramString.equalsIgnoreCase(((e)localObject2).dio)))) {
        ((Iterator)localObject1).remove();
      } else {
        ((e)localObject2).hgm = g(((e)localObject2).hiQ, paramString, paramBoolean);
      }
    }
    localObject1 = new ArrayList();
    Object localObject2 = paramArrayList.iterator();
    String str;
    while (((Iterator)localObject2).hasNext())
    {
      str = (String)((Iterator)localObject2).next();
      Iterator localIterator = this.hiE.iterator();
      while (localIterator.hasNext())
      {
        e locale = (e)localIterator.next();
        if (locale.hiQ.equals(str)) {
          ((ArrayList)localObject1).add(locale);
        }
      }
    }
    this.hiE.clear();
    this.hiE.addAll((Collection)localObject1);
    localObject1 = new ArrayList();
    if (paramArrayList.size() == 9)
    {
      com.tencent.mm.plugin.report.service.g.KI(18);
      paramArrayList = paramArrayList.iterator();
    }
    for (;;)
    {
      if (!paramArrayList.hasNext()) {
        break label477;
      }
      localObject2 = (String)paramArrayList.next();
      if ((localObject2 == null) || (((String)localObject2).equals("")) || (!i.eK((String)localObject2)))
      {
        ad.d("MicroMsg.SendImgSpeeder", " doSendImage : filePath is null or empty");
        continue;
        if (paramArrayList.size() == 1)
        {
          boolean bool = ay.isWifi(aj.getContext());
          com.tencent.mm.plugin.report.service.g.KI(25);
          if (!bool) {
            break;
          }
          if (u.f((String)paramArrayList.get(0), paramString, paramBoolean))
          {
            com.tencent.mm.plugin.report.service.g.KI(23);
            break;
          }
          com.tencent.mm.plugin.report.service.g.KI(21);
          break;
        }
        com.tencent.mm.plugin.report.service.g.KI(24);
        break;
      }
      if (t.aFm((String)localObject2)) {
        ad.i("MicroMsg.SendImgSpeeder", "[cpan] is gif coutinue. did not add filePath:%s filesize:%d", new Object[] { localObject2, Long.valueOf(i.aMN((String)localObject2)) });
      } else if (!yp((String)localObject2)) {
        ((ArrayList)localObject1).add(localObject2);
      }
    }
    label477:
    paramArrayList = ((ArrayList)localObject1).iterator();
    while (paramArrayList.hasNext()) {
      a(paramInt1, paramInt2, (String)paramArrayList.next(), paramString, paramBoolean);
    }
    paramArrayList = new ArrayList();
    long l1 = com.tencent.mm.kernel.g.afB().gda.rb(Thread.currentThread().getId());
    ((k)com.tencent.mm.kernel.g.ab(k.class)).cOI().agl("SendImgSpeeder");
    paramInt1 = 1;
    paramInt2 = 0;
    if (paramInt2 < this.hiE.size())
    {
      localObject1 = (e)this.hiE.get(paramInt2);
      if (t.aFm(((e)localObject1).hiQ)) {
        ad.i("MicroMsg.SendImgSpeeder", "[cpan] is gif coutinue. did not add to msg table");
      }
      for (;;)
      {
        paramInt2 += 1;
        break;
        localObject2 = new bl();
        ((bl)localObject2).setType(w.tr(paramString));
        ((bl)localObject2).nY(paramString);
        ((bl)localObject2).jV(1);
        ((bl)localObject2).setStatus(1);
        ((bl)localObject2).nZ(((e)localObject1).hiU.value);
        ((bl)localObject2).kh(((e)localObject1).hiV.value);
        ((bl)localObject2).ki(((e)localObject1).hiW.value);
        str = bk.SM();
        if (((str != null) && (!str.equals(((du)localObject2).esh))) || ((str == null) && (((du)localObject2).esh != null))) {
          ((bl)localObject2).mZ(str);
        }
        a.a.Wh().n((bl)localObject2);
        ((bl)localObject2).kY(bi.uj(((du)localObject2).field_talker));
        paramArrayList.add(localObject2);
        long l2 = ((k)com.tencent.mm.kernel.g.ab(k.class)).cOI().an((bl)localObject2);
        if (l2 <= 0L)
        {
          ad.e("MicroMsg.SendImgSpeeder", "insert error! %s", new Object[] { paramString });
          paramInt1 = 0;
        }
        else
        {
          ((e)localObject1).msgId = l2;
          this.hiC.put(Long.valueOf(((e)localObject1).msgId), localObject1);
          this.hiD.add(Long.valueOf(((e)localObject1).msgId));
          paramInt1 = 0;
        }
      }
    }
    this.hiE.clear();
    if (l1 > 0L) {
      com.tencent.mm.kernel.g.afB().gda.mX(l1);
    }
    if (paramInt1 != 0) {
      ((k)com.tencent.mm.kernel.g.ab(k.class)).cOI().agm("SendImgSpeeder");
    }
    AppMethodBeat.o(150739);
  }
  
  public final boolean ayu()
  {
    AppMethodBeat.i(150741);
    if ((this.hiE.size() > 0) && (g.a.dkO().vKd <= 2))
    {
      ad.i("MicroMsg.SendImgSpeeder", "cpu core is low ,do not use multi mode");
      AppMethodBeat.o(150741);
      return false;
    }
    AppMethodBeat.o(150741);
    return true;
  }
  
  public final boolean mu(long paramLong)
  {
    AppMethodBeat.i(150737);
    boolean bool = this.hiz.containsKey(Long.valueOf(paramLong));
    AppMethodBeat.o(150737);
    return bool;
  }
  
  public final d mv(long paramLong)
  {
    AppMethodBeat.i(150738);
    d locald = (d)this.hiz.get(Long.valueOf(paramLong));
    AppMethodBeat.o(150738);
    return locald;
  }
  
  public final ArrayList<String> yn(String paramString)
  {
    AppMethodBeat.i(150735);
    ArrayList localArrayList = new ArrayList();
    if (!bt.isNullOrNil(paramString))
    {
      Iterator localIterator = this.hiC.values().iterator();
      while (localIterator.hasNext())
      {
        e locale = (e)localIterator.next();
        if (paramString.equals(locale.dio)) {
          localArrayList.add(locale.hiQ);
        }
      }
    }
    AppMethodBeat.o(150735);
    return localArrayList;
  }
  
  public final ArrayList<Integer> yo(String paramString)
  {
    AppMethodBeat.i(150736);
    Object localObject1 = this.hiC.values();
    Object localObject2 = ((Collection)localObject1).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      e locale = (e)((Iterator)localObject2).next();
      PString localPString = new PString();
      PInt localPInt1 = new PInt();
      PInt localPInt2 = new PInt();
      locale.hiT = o.ayF().a(locale.hiQ, locale.hgm, locale.dep, locale.dnV, localPString, localPInt1, localPInt2, locale.hiR, locale.hiS, locale.msgId, locale.hiX, locale.hiY, locale.hiZ);
      bl localbl = ((k)com.tencent.mm.kernel.g.ab(k.class)).cOI().rm(locale.msgId);
      if (bt.isNullOrNil(localbl.field_imgPath))
      {
        localbl.nZ(localPString.value);
        localbl.kh(localPInt1.value);
        localbl.ki(localPInt2.value);
        ((k)com.tencent.mm.kernel.g.ab(k.class)).cOI().a(locale.msgId, localbl);
      }
    }
    if (!bt.isNullOrNil(paramString))
    {
      localObject1 = ((Collection)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (e)((Iterator)localObject1).next();
        if (!paramString.equals(((e)localObject2).dio))
        {
          this.hiC.remove(Long.valueOf(((e)localObject2).msgId));
          this.hiD.remove(Long.valueOf(((e)localObject2).msgId));
          ad.e("MicroMsg.SendImgSpeeder", "fatal!! Send user mis-match, want:%s, fact:%s", new Object[] { paramString, ((e)localObject2).dio });
        }
      }
    }
    paramString = new ArrayList();
    int i = 0;
    while (i < this.hiD.size())
    {
      paramString.add(Integer.valueOf((int)((e)this.hiC.get(this.hiD.get(i))).hiT));
      i += 1;
    }
    this.hiC.clear();
    this.hiD.clear();
    ad.i("MicroMsg.SendImgSpeeder", "syncImgData, id size %d", new Object[] { Integer.valueOf(paramString.size()) });
    AppMethodBeat.o(150736);
    return paramString;
  }
  
  public static class a
  {
    static ap cHo;
    private ReentrantLock cHm;
    private Condition cHn;
    int hgm;
    a hiF;
    
    public a()
    {
      AppMethodBeat.i(150721);
      this.cHm = new ReentrantLock();
      this.cHn = this.cHm.newCondition();
      AppMethodBeat.o(150721);
    }
    
    public static a a(final n.e parame)
    {
      AppMethodBeat.i(150722);
      try
      {
        if (cHo == null) {
          cHo = new ap("big file gen Worker");
        }
        a locala1 = new a();
        parame.hiZ = locala1;
        a locala2 = parame.hiZ;
        cHo.post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(150720);
            long l = System.currentTimeMillis();
            n.a.a locala = new n.a.a();
            locala.hiI = new PString();
            locala.hiJ = new PString();
            locala.hiK = new PString();
            locala.hiL = new PString();
            String str = f.yf(parame.hiQ);
            locala.hgv = o.ayF().a(parame.hiQ, str, parame.hgm, true, locala.hiI, locala.hiJ, locala.hiK, locala.hiL, parame.hiS, parame.hiX);
            n.a.a(n.a.this).lock();
            try
            {
              n.a.this.hiF = locala;
              n.a.b(n.a.this).signal();
              ad.i("MicroMsg.SendImgSpeeder", "notify big file gen prepared %s last %d", new Object[] { parame.hiQ, Long.valueOf(System.currentTimeMillis() - Long.valueOf(l).longValue()) });
              return;
            }
            finally
            {
              n.a.a(n.a.this).unlock();
              AppMethodBeat.o(150720);
            }
          }
        });
        locala1.hgm = parame.hgm;
        AppMethodBeat.o(150722);
        return locala1;
      }
      finally
      {
        AppMethodBeat.o(150722);
      }
    }
    
    /* Error */
    public final a ayw()
    {
      // Byte code:
      //   0: ldc 83
      //   2: invokestatic 32	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   5: aload_0
      //   6: getfield 37	com/tencent/mm/aw/n$a:cHm	Ljava/util/concurrent/locks/ReentrantLock;
      //   9: invokevirtual 86	java/util/concurrent/locks/ReentrantLock:lock	()V
      //   12: aload_0
      //   13: getfield 88	com/tencent/mm/aw/n$a:hiF	Lcom/tencent/mm/aw/n$a$a;
      //   16: ifnonnull +42 -> 58
      //   19: ldc 90
      //   21: ldc 92
      //   23: invokestatic 97	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;)V
      //   26: aload_0
      //   27: getfield 43	com/tencent/mm/aw/n$a:cHn	Ljava/util/concurrent/locks/Condition;
      //   30: invokeinterface 102 1 0
      //   35: goto -23 -> 12
      //   38: astore_1
      //   39: aload_0
      //   40: getfield 37	com/tencent/mm/aw/n$a:cHm	Ljava/util/concurrent/locks/ReentrantLock;
      //   43: invokevirtual 105	java/util/concurrent/locks/ReentrantLock:unlock	()V
      //   46: aload_0
      //   47: getfield 88	com/tencent/mm/aw/n$a:hiF	Lcom/tencent/mm/aw/n$a$a;
      //   50: astore_1
      //   51: ldc 83
      //   53: invokestatic 46	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   56: aload_1
      //   57: areturn
      //   58: aload_0
      //   59: getfield 37	com/tencent/mm/aw/n$a:cHm	Ljava/util/concurrent/locks/ReentrantLock;
      //   62: invokevirtual 105	java/util/concurrent/locks/ReentrantLock:unlock	()V
      //   65: goto -19 -> 46
      //   68: astore_1
      //   69: aload_0
      //   70: getfield 37	com/tencent/mm/aw/n$a:cHm	Ljava/util/concurrent/locks/ReentrantLock;
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
      String hgv;
      PString hiI;
      PString hiJ;
      PString hiK;
      PString hiL;
    }
  }
  
  static final class b
  {
    b hiM;
    String hiN;
  }
  
  public static final class c
  {
    private LinkedList<n.b> hiO;
    private LinkedList<n.b> hiP;
    
    public c()
    {
      AppMethodBeat.i(150724);
      this.hiO = new LinkedList();
      this.hiP = new LinkedList();
      AppMethodBeat.o(150724);
    }
    
    private void ayA()
    {
      for (;;)
      {
        int i;
        try
        {
          AppMethodBeat.i(150730);
          StringBuilder localStringBuilder = new StringBuilder();
          i = 0;
          if (i < this.hiO.size())
          {
            localStringBuilder.append(((n.b)this.hiO.get(i)).hiN);
            if (i != this.hiO.size() - 1) {
              localStringBuilder.append("-");
            }
          }
          else
          {
            ad.d("MicroMsg.SendImgSpeeder", "sync big des to file %s ", new Object[] { localStringBuilder.toString() });
            com.tencent.mm.kernel.g.afB().afk().set(348176, localStringBuilder.toString());
            AppMethodBeat.o(150730);
            return;
          }
        }
        finally {}
        i += 1;
      }
    }
    
    private void ayB()
    {
      for (;;)
      {
        int i;
        try
        {
          AppMethodBeat.i(150731);
          StringBuilder localStringBuilder = new StringBuilder();
          i = 0;
          if (i < this.hiP.size())
          {
            localStringBuilder.append(((n.b)this.hiP.get(i)).hiN);
            if (i != this.hiP.size() - 1) {
              localStringBuilder.append("-");
            }
          }
          else
          {
            ad.d("MicroMsg.SendImgSpeeder", "sync thumb des to file %s ", new Object[] { localStringBuilder.toString() });
            com.tencent.mm.kernel.g.afB().afk().set(348177, localStringBuilder.toString());
            AppMethodBeat.o(150731);
            return;
          }
        }
        finally {}
        i += 1;
      }
    }
    
    private static n.b ayy()
    {
      AppMethodBeat.i(150726);
      n.b localb = new n.b((byte)0);
      if (bt.isNullOrNil(null)) {}
      String str;
      for (localb.hiN = g.ayo();; localb.hiN = null)
      {
        str = o.ayF().yj(localb.hiN);
        if (yq(str)) {
          break;
        }
        AppMethodBeat.o(150726);
        return null;
      }
      localb.hiM = new b(str);
      AppMethodBeat.o(150726);
      return localb;
    }
    
    private static n.b ayz()
    {
      AppMethodBeat.i(150727);
      n.b localb = new n.b((byte)0);
      if (bt.isNullOrNil(null)) {}
      String str;
      for (localb.hiN = g.ayo();; localb.hiN = null)
      {
        str = o.ayF().yi(localb.hiN);
        if (yq(str)) {
          break;
        }
        AppMethodBeat.o(150727);
        return null;
      }
      localb.hiM = new b(str);
      AppMethodBeat.o(150727);
      return localb;
    }
    
    private static boolean yq(String paramString)
    {
      AppMethodBeat.i(150728);
      if (i.aMN(paramString) > 0L)
      {
        ad.e("MicroMsg.SendImgSpeeder", "file has exist %s", new Object[] { paramString });
        AppMethodBeat.o(150728);
        return false;
      }
      AppMethodBeat.o(150728);
      return true;
    }
    
    public final void ayx()
    {
      int j = 0;
      try
      {
        AppMethodBeat.i(150725);
        int i = this.hiO.size();
        int k;
        n.b localb;
        if (i < 0)
        {
          k = 5 - i;
          i = 0;
          while (i < k)
          {
            localb = ayy();
            this.hiO.add(localb);
            i += 1;
          }
          ad.i("MicroMsg.SendImgSpeeder", "add big File pool added size %d , all size %d", new Object[] { Integer.valueOf(k), Integer.valueOf(this.hiO.size()) });
          ayA();
        }
        i = this.hiP.size();
        if (i < 0)
        {
          k = 5 - i;
          i = j;
          while (i < k)
          {
            localb = ayz();
            this.hiP.add(localb);
            i += 1;
          }
          ayB();
          ad.i("MicroMsg.SendImgSpeeder", "add big thumb pool added size %d , all size %d", new Object[] { Integer.valueOf(k), Integer.valueOf(this.hiP.size()) });
        }
        AppMethodBeat.o(150725);
        return;
      }
      finally {}
    }
    
    public final n.b ok(int paramInt)
    {
      for (;;)
      {
        try
        {
          AppMethodBeat.i(150729);
          n.b localb1 = null;
          if (paramInt == 1)
          {
            if (this.hiO.size() > 0)
            {
              localb1 = (n.b)this.hiO.remove();
              ayA();
              ayx();
              AppMethodBeat.o(150729);
              return localb1;
            }
            localb1 = ayy();
            continue;
          }
          if (paramInt == 2) {
            if (this.hiP.size() > 0)
            {
              localb1 = (n.b)this.hiP.remove();
              ayB();
            }
            else
            {
              n.b localb2 = ayz();
            }
          }
        }
        finally {}
      }
    }
  }
  
  public static final class d
  {
    public long dpt;
    public long offset;
  }
  
  public static final class e
  {
    int dep;
    String dio;
    int dnV;
    int hgm;
    String hiQ;
    String hiR;
    String hiS;
    long hiT;
    PString hiU;
    PInt hiV;
    PInt hiW;
    b hiX;
    b hiY;
    n.a hiZ;
    long msgId;
    
    public static e a(String paramString1, int paramInt1, int paramInt2, int paramInt3, String paramString2, String paramString3, PString paramPString, PInt paramPInt1, PInt paramPInt2, b paramb1, b paramb2)
    {
      AppMethodBeat.i(150732);
      e locale = new e();
      locale.hiQ = paramString1;
      locale.hgm = paramInt1;
      locale.dep = paramInt2;
      locale.dnV = paramInt3;
      locale.hiR = paramString2;
      locale.hiU = paramPString;
      locale.hiW = paramPInt2;
      locale.hiV = paramPInt1;
      locale.hiS = paramString3;
      locale.hiY = paramb2;
      locale.hiX = paramb1;
      if (n.ayv().ayu()) {
        n.a.a(locale);
      }
      AppMethodBeat.o(150732);
      return locale;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.aw.n
 * JD-Core Version:    0.7.0.1
 */