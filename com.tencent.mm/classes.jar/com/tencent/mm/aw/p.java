package com.tencent.mm.aw;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.b;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.m.a;
import com.tencent.mm.m.a.a;
import com.tencent.mm.model.bj;
import com.tencent.mm.model.bl;
import com.tencent.mm.model.u;
import com.tencent.mm.model.w;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.plugin.report.service.f;
import com.tencent.mm.plugin.report.service.f.a;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.ay;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.t;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.bu;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class p
{
  private static p ibU;
  ConcurrentHashMap<Long, d> ibS;
  public c ibT;
  public ConcurrentHashMap<Long, e> ibV;
  private ArrayList<Long> ibW;
  ArrayList<e> ibX;
  
  public p()
  {
    AppMethodBeat.i(150733);
    this.ibS = new ConcurrentHashMap();
    this.ibV = new ConcurrentHashMap();
    this.ibW = new ArrayList();
    this.ibX = new ArrayList();
    this.ibT = new c();
    AppMethodBeat.o(150733);
  }
  
  private boolean Fy(String paramString)
  {
    AppMethodBeat.i(150740);
    Iterator localIterator = this.ibX.iterator();
    while (localIterator.hasNext()) {
      if (((e)localIterator.next()).icj.equals(paramString))
      {
        AppMethodBeat.o(150740);
        return true;
      }
    }
    AppMethodBeat.o(150740);
    return false;
  }
  
  public static p aIt()
  {
    AppMethodBeat.i(150734);
    if (ibU == null) {}
    try
    {
      if (ibU == null) {
        ibU = new p();
      }
      p localp = ibU;
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
    if (u.f(paramString1, paramString2, paramBoolean))
    {
      AppMethodBeat.o(150743);
      return 1;
    }
    AppMethodBeat.o(150743);
    return 0;
  }
  
  public final ArrayList<String> Fw(String paramString)
  {
    AppMethodBeat.i(150735);
    ArrayList localArrayList = new ArrayList();
    if (!bt.isNullOrNil(paramString))
    {
      Iterator localIterator = this.ibV.values().iterator();
      while (localIterator.hasNext())
      {
        e locale = (e)localIterator.next();
        if (paramString.equals(locale.drf)) {
          localArrayList.add(locale.icj);
        }
      }
    }
    AppMethodBeat.o(150735);
    return localArrayList;
  }
  
  public final ArrayList<Integer> Fx(String paramString)
  {
    AppMethodBeat.i(150736);
    Object localObject1 = this.ibV.values();
    Object localObject2 = ((Collection)localObject1).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      e locale = (e)((Iterator)localObject2).next();
      PString localPString = new PString();
      PInt localPInt1 = new PInt();
      PInt localPInt2 = new PInt();
      locale.icm = q.aIF().a(locale.drf, locale.icj, locale.hZz, locale.dnh, locale.dxr, localPString, localPInt1, localPInt2, locale.ick, locale.icl, locale.msgId, locale.icq, locale.icr, locale.ics);
      bu localbu = ((l)g.ab(l.class)).dlK().xY(locale.msgId);
      if (bt.isNullOrNil(localbu.field_imgPath))
      {
        localbu.tO(localPString.value);
        localbu.kB(localPInt1.value);
        localbu.kC(localPInt2.value);
        ((l)g.ab(l.class)).dlK().a(locale.msgId, localbu);
      }
    }
    if (!bt.isNullOrNil(paramString))
    {
      localObject1 = ((Collection)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (e)((Iterator)localObject1).next();
        if (!paramString.equals(((e)localObject2).drf))
        {
          this.ibV.remove(Long.valueOf(((e)localObject2).msgId));
          this.ibW.remove(Long.valueOf(((e)localObject2).msgId));
          ad.e("MicroMsg.SendImgSpeeder", "fatal!! Send user mis-match, want:%s, fact:%s", new Object[] { paramString, ((e)localObject2).drf });
        }
      }
    }
    paramString = new ArrayList();
    int i = 0;
    while (i < this.ibW.size())
    {
      paramString.add(Integer.valueOf((int)((e)this.ibV.get(this.ibW.get(i))).icm));
      i += 1;
    }
    this.ibV.clear();
    this.ibW.clear();
    ad.i("MicroMsg.SendImgSpeeder", "syncImgData, id size %d", new Object[] { Integer.valueOf(paramString.size()) });
    AppMethodBeat.o(150736);
    return paramString;
  }
  
  public final void a(int paramInt1, int paramInt2, String paramString1, String paramString2, boolean paramBoolean)
  {
    AppMethodBeat.i(150742);
    if (Fy(paramString1))
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
    if (aIu())
    {
      localObject2 = this.ibT.pB(1);
      localObject1 = this.ibT.pB(2);
      localb1 = ((b)localObject2).icf;
      localb2 = ((b)localObject1).icf;
      localObject1 = ((b)localObject1).icg;
      localObject2 = ((b)localObject2).icg;
    }
    q.aIF().a(paramString2, paramString1, i, localPString, localPInt1, localPInt2, paramInt2, (String)localObject1);
    localObject1 = e.a(paramString1, i, paramInt1, paramInt2, (String)localObject1, (String)localObject2, localPString, localPInt1, localPInt2, localb1, localb2);
    ((e)localObject1).drf = paramString2;
    this.ibX.add(localObject1);
    ad.i("MicroMsg.SendImgSpeeder", "summersafecdn img path %s has prebuild, user:%s", new Object[] { paramString1, paramString2 });
    AppMethodBeat.o(150742);
  }
  
  public final void a(ArrayList<String> paramArrayList, boolean paramBoolean, int paramInt1, int paramInt2, String paramString)
  {
    AppMethodBeat.i(150739);
    ad.i("MicroMsg.SendImgSpeeder", "summersafecdn sendThumbImg fileSize:%d, compressImg[%b], source[%d], user:%s", new Object[] { Integer.valueOf(paramArrayList.size()), Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt1), paramString });
    Object localObject1 = this.ibX.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (e)((Iterator)localObject1).next();
      if ((!paramArrayList.contains(((e)localObject2).icj)) || ((!bt.isNullOrNil(((e)localObject2).drf)) && (!((e)localObject2).drf.equalsIgnoreCase(paramString))) || ((!bt.isNullOrNil(paramString)) && (!paramString.equalsIgnoreCase(((e)localObject2).drf)))) {
        ((Iterator)localObject1).remove();
      } else {
        ((e)localObject2).hZz = g(((e)localObject2).icj, paramString, paramBoolean);
      }
    }
    localObject1 = new ArrayList();
    Object localObject2 = paramArrayList.iterator();
    String str;
    while (((Iterator)localObject2).hasNext())
    {
      str = (String)((Iterator)localObject2).next();
      Iterator localIterator = this.ibX.iterator();
      while (localIterator.hasNext())
      {
        e locale = (e)localIterator.next();
        if (locale.icj.equals(str)) {
          ((ArrayList)localObject1).add(locale);
        }
      }
    }
    this.ibX.clear();
    this.ibX.addAll((Collection)localObject1);
    localObject1 = new ArrayList();
    if (paramArrayList.size() == 9)
    {
      f.Oj(18);
      paramArrayList = paramArrayList.iterator();
    }
    for (;;)
    {
      if (!paramArrayList.hasNext()) {
        break label482;
      }
      localObject2 = (String)paramArrayList.next();
      if ((localObject2 == null) || (((String)localObject2).equals("")) || (!com.tencent.mm.vfs.i.fv((String)localObject2)))
      {
        ad.d("MicroMsg.SendImgSpeeder", " doSendImage : filePath is null or empty");
        continue;
        if (paramArrayList.size() == 1)
        {
          boolean bool = ay.isWifi(aj.getContext());
          f.Oj(25);
          if (!bool) {
            break;
          }
          if (u.f((String)paramArrayList.get(0), paramString, paramBoolean))
          {
            f.Oj(23);
            break;
          }
          f.Oj(21);
          break;
        }
        f.Oj(24);
        break;
      }
      if (t.aQj((String)localObject2)) {
        ad.i("MicroMsg.SendImgSpeeder", "[cpan] is gif coutinue. did not add filePath:%s filesize:%d", new Object[] { localObject2, Long.valueOf(com.tencent.mm.vfs.i.aYo((String)localObject2)) });
      } else if (!Fy((String)localObject2)) {
        ((ArrayList)localObject1).add(localObject2);
      }
    }
    label482:
    paramArrayList = ((ArrayList)localObject1).iterator();
    while (paramArrayList.hasNext()) {
      a(paramInt1, paramInt2, (String)paramArrayList.next(), paramString, paramBoolean);
    }
    paramArrayList = new ArrayList();
    long l1 = g.ajC().gBq.xO(Thread.currentThread().getId());
    ((l)g.ab(l.class)).dlK().apS("SendImgSpeeder");
    paramInt1 = 1;
    paramInt2 = 0;
    if (paramInt2 < this.ibX.size())
    {
      localObject1 = (e)this.ibX.get(paramInt2);
      if (t.aQj(((e)localObject1).icj)) {
        ad.i("MicroMsg.SendImgSpeeder", "[cpan] is gif coutinue. did not add to msg table");
      }
      for (;;)
      {
        paramInt2 += 1;
        break;
        localObject2 = new bu();
        ((bu)localObject2).setType(w.As(paramString));
        ((bu)localObject2).tN(paramString);
        ((bu)localObject2).kr(1);
        ((bu)localObject2).setStatus(1);
        ((bu)localObject2).tO(((e)localObject1).icn.value);
        ((bu)localObject2).kB(((e)localObject1).ico.value);
        ((bu)localObject2).kC(((e)localObject1).icp.value);
        str = bl.VW();
        if (((str != null) && (!str.equals(((ei)localObject2).eLs))) || ((str == null) && (((ei)localObject2).eLs != null))) {
          ((bu)localObject2).sP(str);
        }
        a.a.ZG().n((bu)localObject2);
        ((bu)localObject2).qA(bj.Bo(((ei)localObject2).field_talker));
        paramArrayList.add(localObject2);
        long l2 = ((l)g.ab(l.class)).dlK().as((bu)localObject2);
        if (l2 <= 0L)
        {
          ad.e("MicroMsg.SendImgSpeeder", "insert error! %s", new Object[] { paramString });
          paramInt1 = 0;
        }
        else
        {
          ((e)localObject1).msgId = l2;
          this.ibV.put(Long.valueOf(((e)localObject1).msgId), localObject1);
          this.ibW.add(Long.valueOf(((e)localObject1).msgId));
          paramInt1 = 0;
        }
      }
    }
    this.ibX.clear();
    if (l1 > 0L) {
      g.ajC().gBq.sJ(l1);
    }
    if (paramInt1 != 0) {
      ((l)g.ab(l.class)).dlK().apT("SendImgSpeeder");
    }
    AppMethodBeat.o(150739);
  }
  
  public final boolean aIu()
  {
    AppMethodBeat.i(150741);
    if ((this.ibX.size() > 0) && (f.a.dKp().yhN <= 2))
    {
      ad.i("MicroMsg.SendImgSpeeder", "cpu core is low ,do not use multi mode");
      AppMethodBeat.o(150741);
      return false;
    }
    AppMethodBeat.o(150741);
    return true;
  }
  
  public final boolean sh(long paramLong)
  {
    AppMethodBeat.i(150737);
    boolean bool = this.ibS.containsKey(Long.valueOf(paramLong));
    AppMethodBeat.o(150737);
    return bool;
  }
  
  public final d si(long paramLong)
  {
    AppMethodBeat.i(150738);
    d locald = (d)this.ibS.get(Long.valueOf(paramLong));
    AppMethodBeat.o(150738);
    return locald;
  }
  
  public static class a
  {
    static ap cPB;
    private Condition cPA;
    private ReentrantLock cPz;
    int hZz;
    a ibY;
    
    public a()
    {
      AppMethodBeat.i(150721);
      this.cPz = new ReentrantLock();
      this.cPA = this.cPz.newCondition();
      AppMethodBeat.o(150721);
    }
    
    public static a a(final p.e parame)
    {
      AppMethodBeat.i(150722);
      try
      {
        if (cPB == null) {
          cPB = new ap("big file gen Worker");
        }
        a locala1 = new a();
        parame.ics = locala1;
        a locala2 = parame.ics;
        cPB.post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(150720);
            long l = System.currentTimeMillis();
            p.a.a locala = new p.a.a();
            locala.icb = new PString();
            locala.icc = new PString();
            locala.icd = new PString();
            locala.ice = new PString();
            String str = h.Fj(parame.icj);
            locala.hZI = q.aIF().a(parame.drf, parame.icj, str, parame.hZz, true, locala.icb, locala.icc, locala.icd, locala.ice, parame.icl, parame.icq);
            p.a.a(p.a.this).lock();
            try
            {
              p.a.this.ibY = locala;
              p.a.b(p.a.this).signal();
              ad.i("MicroMsg.SendImgSpeeder", "notify big file gen prepared %s last %d", new Object[] { parame.icj, Long.valueOf(System.currentTimeMillis() - Long.valueOf(l).longValue()) });
              return;
            }
            finally
            {
              p.a.a(p.a.this).unlock();
              AppMethodBeat.o(150720);
            }
          }
        });
        locala1.hZz = parame.hZz;
        AppMethodBeat.o(150722);
        return locala1;
      }
      finally
      {
        AppMethodBeat.o(150722);
      }
    }
    
    /* Error */
    public final a aIw()
    {
      // Byte code:
      //   0: ldc 83
      //   2: invokestatic 32	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   5: aload_0
      //   6: getfield 37	com/tencent/mm/aw/p$a:cPz	Ljava/util/concurrent/locks/ReentrantLock;
      //   9: invokevirtual 86	java/util/concurrent/locks/ReentrantLock:lock	()V
      //   12: aload_0
      //   13: getfield 88	com/tencent/mm/aw/p$a:ibY	Lcom/tencent/mm/aw/p$a$a;
      //   16: ifnonnull +42 -> 58
      //   19: ldc 90
      //   21: ldc 92
      //   23: invokestatic 97	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;)V
      //   26: aload_0
      //   27: getfield 43	com/tencent/mm/aw/p$a:cPA	Ljava/util/concurrent/locks/Condition;
      //   30: invokeinterface 102 1 0
      //   35: goto -23 -> 12
      //   38: astore_1
      //   39: aload_0
      //   40: getfield 37	com/tencent/mm/aw/p$a:cPz	Ljava/util/concurrent/locks/ReentrantLock;
      //   43: invokevirtual 105	java/util/concurrent/locks/ReentrantLock:unlock	()V
      //   46: aload_0
      //   47: getfield 88	com/tencent/mm/aw/p$a:ibY	Lcom/tencent/mm/aw/p$a$a;
      //   50: astore_1
      //   51: ldc 83
      //   53: invokestatic 46	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   56: aload_1
      //   57: areturn
      //   58: aload_0
      //   59: getfield 37	com/tencent/mm/aw/p$a:cPz	Ljava/util/concurrent/locks/ReentrantLock;
      //   62: invokevirtual 105	java/util/concurrent/locks/ReentrantLock:unlock	()V
      //   65: goto -19 -> 46
      //   68: astore_1
      //   69: aload_0
      //   70: getfield 37	com/tencent/mm/aw/p$a:cPz	Ljava/util/concurrent/locks/ReentrantLock;
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
      String hZI;
      PString icb;
      PString icc;
      PString icd;
      PString ice;
    }
  }
  
  static final class b
  {
    b icf;
    String icg;
  }
  
  public static final class c
  {
    private LinkedList<p.b> ich;
    private LinkedList<p.b> ici;
    
    public c()
    {
      AppMethodBeat.i(150724);
      this.ich = new LinkedList();
      this.ici = new LinkedList();
      AppMethodBeat.o(150724);
    }
    
    private static boolean Fz(String paramString)
    {
      AppMethodBeat.i(150728);
      if (com.tencent.mm.vfs.i.aYo(paramString) > 0L)
      {
        ad.e("MicroMsg.SendImgSpeeder", "file has exist %s", new Object[] { paramString });
        AppMethodBeat.o(150728);
        return false;
      }
      AppMethodBeat.o(150728);
      return true;
    }
    
    private void aIA()
    {
      for (;;)
      {
        int i;
        try
        {
          AppMethodBeat.i(150730);
          StringBuilder localStringBuilder = new StringBuilder();
          i = 0;
          if (i < this.ich.size())
          {
            localStringBuilder.append(((p.b)this.ich.get(i)).icg);
            if (i != this.ich.size() - 1) {
              localStringBuilder.append("-");
            }
          }
          else
          {
            ad.d("MicroMsg.SendImgSpeeder", "sync big des to file %s ", new Object[] { localStringBuilder.toString() });
            g.ajC().ajl().set(348176, localStringBuilder.toString());
            AppMethodBeat.o(150730);
            return;
          }
        }
        finally {}
        i += 1;
      }
    }
    
    private void aIB()
    {
      for (;;)
      {
        int i;
        try
        {
          AppMethodBeat.i(150731);
          StringBuilder localStringBuilder = new StringBuilder();
          i = 0;
          if (i < this.ici.size())
          {
            localStringBuilder.append(((p.b)this.ici.get(i)).icg);
            if (i != this.ici.size() - 1) {
              localStringBuilder.append("-");
            }
          }
          else
          {
            ad.d("MicroMsg.SendImgSpeeder", "sync thumb des to file %s ", new Object[] { localStringBuilder.toString() });
            g.ajC().ajl().set(348177, localStringBuilder.toString());
            AppMethodBeat.o(150731);
            return;
          }
        }
        finally {}
        i += 1;
      }
    }
    
    private static p.b aIy()
    {
      AppMethodBeat.i(150726);
      p.b localb = new p.b((byte)0);
      if (bt.isNullOrNil(null)) {}
      String str;
      for (localb.icg = i.aIo();; localb.icg = null)
      {
        str = q.aIF().Fq(localb.icg);
        if (Fz(str)) {
          break;
        }
        AppMethodBeat.o(150726);
        return null;
      }
      localb.icf = new b(str);
      AppMethodBeat.o(150726);
      return localb;
    }
    
    private static p.b aIz()
    {
      AppMethodBeat.i(150727);
      p.b localb = new p.b((byte)0);
      if (bt.isNullOrNil(null)) {}
      String str;
      for (localb.icg = i.aIo();; localb.icg = null)
      {
        str = q.aIF().Fp(localb.icg);
        if (Fz(str)) {
          break;
        }
        AppMethodBeat.o(150727);
        return null;
      }
      localb.icf = new b(str);
      AppMethodBeat.o(150727);
      return localb;
    }
    
    public final void aIx()
    {
      int j = 0;
      try
      {
        AppMethodBeat.i(150725);
        int i = this.ich.size();
        int k;
        p.b localb;
        if (i < 0)
        {
          k = 5 - i;
          i = 0;
          while (i < k)
          {
            localb = aIy();
            this.ich.add(localb);
            i += 1;
          }
          ad.i("MicroMsg.SendImgSpeeder", "add big File pool added size %d , all size %d", new Object[] { Integer.valueOf(k), Integer.valueOf(this.ich.size()) });
          aIA();
        }
        i = this.ici.size();
        if (i < 0)
        {
          k = 5 - i;
          i = j;
          while (i < k)
          {
            localb = aIz();
            this.ici.add(localb);
            i += 1;
          }
          aIB();
          ad.i("MicroMsg.SendImgSpeeder", "add big thumb pool added size %d , all size %d", new Object[] { Integer.valueOf(k), Integer.valueOf(this.ici.size()) });
        }
        AppMethodBeat.o(150725);
        return;
      }
      finally {}
    }
    
    public final p.b pB(int paramInt)
    {
      for (;;)
      {
        try
        {
          AppMethodBeat.i(150729);
          p.b localb1 = null;
          if (paramInt == 1)
          {
            if (this.ich.size() > 0)
            {
              localb1 = (p.b)this.ich.remove();
              aIA();
              aIx();
              AppMethodBeat.o(150729);
              return localb1;
            }
            localb1 = aIy();
            continue;
          }
          if (paramInt == 2) {
            if (this.ici.size() > 0)
            {
              localb1 = (p.b)this.ici.remove();
              aIB();
            }
            else
            {
              p.b localb2 = aIz();
            }
          }
        }
        finally {}
      }
    }
  }
  
  public static final class d
  {
    public long dyS;
    public long offset;
  }
  
  public static final class e
  {
    int dnh;
    String drf;
    int dxr;
    int hZz;
    String icj;
    String ick;
    String icl;
    long icm;
    PString icn;
    PInt ico;
    PInt icp;
    b icq;
    b icr;
    p.a ics;
    long msgId;
    
    public static e a(String paramString1, int paramInt1, int paramInt2, int paramInt3, String paramString2, String paramString3, PString paramPString, PInt paramPInt1, PInt paramPInt2, b paramb1, b paramb2)
    {
      AppMethodBeat.i(150732);
      e locale = new e();
      locale.icj = paramString1;
      locale.hZz = paramInt1;
      locale.dnh = paramInt2;
      locale.dxr = paramInt3;
      locale.ick = paramString2;
      locale.icn = paramPString;
      locale.icp = paramPInt2;
      locale.ico = paramPInt1;
      locale.icl = paramString3;
      locale.icr = paramb2;
      locale.icq = paramb1;
      if (p.aIv().aIu()) {
        p.a.a(locale);
      }
      AppMethodBeat.o(150732);
      return locale;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.aw.p
 * JD-Core Version:    0.7.0.1
 */