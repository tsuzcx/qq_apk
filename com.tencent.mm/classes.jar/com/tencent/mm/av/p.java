package com.tencent.mm.av;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.b;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.m.a;
import com.tencent.mm.m.a.a;
import com.tencent.mm.model.bl;
import com.tencent.mm.model.bn;
import com.tencent.mm.model.v;
import com.tencent.mm.model.x;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.plugin.report.service.f;
import com.tencent.mm.plugin.report.service.f.a;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.az;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.sdk.platformtools.u;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.bv;
import com.tencent.mm.vfs.o;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class p
{
  private static p ieN;
  ConcurrentHashMap<Long, d> ieL;
  public c ieM;
  public ConcurrentHashMap<Long, e> ieO;
  private ArrayList<Long> ieP;
  ArrayList<e> ieQ;
  
  public p()
  {
    AppMethodBeat.i(150733);
    this.ieL = new ConcurrentHashMap();
    this.ieO = new ConcurrentHashMap();
    this.ieP = new ArrayList();
    this.ieQ = new ArrayList();
    this.ieM = new c();
    AppMethodBeat.o(150733);
  }
  
  private boolean Ga(String paramString)
  {
    AppMethodBeat.i(150740);
    Iterator localIterator = this.ieQ.iterator();
    while (localIterator.hasNext()) {
      if (((e)localIterator.next()).ifc.equals(paramString))
      {
        AppMethodBeat.o(150740);
        return true;
      }
    }
    AppMethodBeat.o(150740);
    return false;
  }
  
  public static p aIL()
  {
    AppMethodBeat.i(150734);
    if (ieN == null) {}
    try
    {
      if (ieN == null) {
        ieN = new p();
      }
      p localp = ieN;
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
    if (v.f(paramString1, paramString2, paramBoolean))
    {
      AppMethodBeat.o(150743);
      return 1;
    }
    AppMethodBeat.o(150743);
    return 0;
  }
  
  public final ArrayList<String> FY(String paramString)
  {
    AppMethodBeat.i(150735);
    ArrayList localArrayList = new ArrayList();
    if (!bu.isNullOrNil(paramString))
    {
      Iterator localIterator = this.ieO.values().iterator();
      while (localIterator.hasNext())
      {
        e locale = (e)localIterator.next();
        if (paramString.equals(locale.dsk)) {
          localArrayList.add(locale.ifc);
        }
      }
    }
    AppMethodBeat.o(150735);
    return localArrayList;
  }
  
  public final ArrayList<Integer> FZ(String paramString)
  {
    AppMethodBeat.i(150736);
    Object localObject1 = this.ieO.values();
    Object localObject2 = ((Collection)localObject1).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      e locale = (e)((Iterator)localObject2).next();
      PString localPString = new PString();
      PInt localPInt1 = new PInt();
      PInt localPInt2 = new PInt();
      locale.iff = q.aIX().a(locale.dsk, locale.ifc, locale.icr, locale.doj, locale.dyw, localPString, localPInt1, localPInt2, locale.ifd, locale.ife, locale.msgId, locale.ifj, locale.ifk, locale.ifl);
      bv localbv = ((l)g.ab(l.class)).doJ().ys(locale.msgId);
      if (bu.isNullOrNil(localbv.field_imgPath))
      {
        localbv.uj(localPString.value);
        localbv.kD(localPInt1.value);
        localbv.kE(localPInt2.value);
        ((l)g.ab(l.class)).doJ().a(locale.msgId, localbv);
      }
    }
    if (!bu.isNullOrNil(paramString))
    {
      localObject1 = ((Collection)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (e)((Iterator)localObject1).next();
        if (!paramString.equals(((e)localObject2).dsk))
        {
          this.ieO.remove(Long.valueOf(((e)localObject2).msgId));
          this.ieP.remove(Long.valueOf(((e)localObject2).msgId));
          ae.e("MicroMsg.SendImgSpeeder", "fatal!! Send user mis-match, want:%s, fact:%s", new Object[] { paramString, ((e)localObject2).dsk });
        }
      }
    }
    paramString = new ArrayList();
    int i = 0;
    while (i < this.ieP.size())
    {
      paramString.add(Integer.valueOf((int)((e)this.ieO.get(this.ieP.get(i))).iff));
      i += 1;
    }
    this.ieO.clear();
    this.ieP.clear();
    ae.i("MicroMsg.SendImgSpeeder", "syncImgData, id size %d", new Object[] { Integer.valueOf(paramString.size()) });
    AppMethodBeat.o(150736);
    return paramString;
  }
  
  public final void a(int paramInt1, int paramInt2, String paramString1, String paramString2, boolean paramBoolean)
  {
    AppMethodBeat.i(150742);
    if (Ga(paramString1))
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
    if (aIM())
    {
      localObject2 = this.ieM.pE(1);
      localObject1 = this.ieM.pE(2);
      localb1 = ((b)localObject2).ieY;
      localb2 = ((b)localObject1).ieY;
      localObject1 = ((b)localObject1).ieZ;
      localObject2 = ((b)localObject2).ieZ;
    }
    q.aIX().a(paramString2, paramString1, i, localPString, localPInt1, localPInt2, paramInt2, (String)localObject1);
    localObject1 = e.a(paramString1, i, paramInt1, paramInt2, (String)localObject1, (String)localObject2, localPString, localPInt1, localPInt2, localb1, localb2);
    ((e)localObject1).dsk = paramString2;
    this.ieQ.add(localObject1);
    ae.i("MicroMsg.SendImgSpeeder", "summersafecdn img path %s has prebuild, user:%s", new Object[] { paramString1, paramString2 });
    AppMethodBeat.o(150742);
  }
  
  public final void a(ArrayList<String> paramArrayList, boolean paramBoolean, int paramInt1, int paramInt2, String paramString)
  {
    AppMethodBeat.i(150739);
    ae.i("MicroMsg.SendImgSpeeder", "summersafecdn sendThumbImg fileSize:%d, compressImg[%b], source[%d], user:%s", new Object[] { Integer.valueOf(paramArrayList.size()), Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt1), paramString });
    Object localObject1 = this.ieQ.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (e)((Iterator)localObject1).next();
      if ((!paramArrayList.contains(((e)localObject2).ifc)) || ((!bu.isNullOrNil(((e)localObject2).dsk)) && (!((e)localObject2).dsk.equalsIgnoreCase(paramString))) || ((!bu.isNullOrNil(paramString)) && (!paramString.equalsIgnoreCase(((e)localObject2).dsk)))) {
        ((Iterator)localObject1).remove();
      } else {
        ((e)localObject2).icr = g(((e)localObject2).ifc, paramString, paramBoolean);
      }
    }
    localObject1 = new ArrayList();
    Object localObject2 = paramArrayList.iterator();
    String str;
    while (((Iterator)localObject2).hasNext())
    {
      str = (String)((Iterator)localObject2).next();
      Iterator localIterator = this.ieQ.iterator();
      while (localIterator.hasNext())
      {
        e locale = (e)localIterator.next();
        if (locale.ifc.equals(str)) {
          ((ArrayList)localObject1).add(locale);
        }
      }
    }
    this.ieQ.clear();
    this.ieQ.addAll((Collection)localObject1);
    localObject1 = new ArrayList();
    if (paramArrayList.size() == 9)
    {
      f.OP(18);
      paramArrayList = paramArrayList.iterator();
    }
    for (;;)
    {
      if (!paramArrayList.hasNext()) {
        break label482;
      }
      localObject2 = (String)paramArrayList.next();
      if ((localObject2 == null) || (((String)localObject2).equals("")) || (!o.fB((String)localObject2)))
      {
        ae.d("MicroMsg.SendImgSpeeder", " doSendImage : filePath is null or empty");
        continue;
        if (paramArrayList.size() == 1)
        {
          boolean bool = az.isWifi(ak.getContext());
          f.OP(25);
          if (!bool) {
            break;
          }
          if (v.f((String)paramArrayList.get(0), paramString, paramBoolean))
          {
            f.OP(23);
            break;
          }
          f.OP(21);
          break;
        }
        f.OP(24);
        break;
      }
      if (u.aRG((String)localObject2)) {
        ae.i("MicroMsg.SendImgSpeeder", "[cpan] is gif coutinue. did not add filePath:%s filesize:%d", new Object[] { localObject2, Long.valueOf(o.aZR((String)localObject2)) });
      } else if (!Ga((String)localObject2)) {
        ((ArrayList)localObject1).add(localObject2);
      }
    }
    label482:
    paramArrayList = ((ArrayList)localObject1).iterator();
    while (paramArrayList.hasNext()) {
      a(paramInt1, paramInt2, (String)paramArrayList.next(), paramString, paramBoolean);
    }
    paramArrayList = new ArrayList();
    long l1 = g.ajR().gDX.yi(Thread.currentThread().getId());
    ((l)g.ab(l.class)).doJ().aqX("SendImgSpeeder");
    paramInt1 = 1;
    paramInt2 = 0;
    if (paramInt2 < this.ieQ.size())
    {
      localObject1 = (e)this.ieQ.get(paramInt2);
      if (u.aRG(((e)localObject1).ifc)) {
        ae.i("MicroMsg.SendImgSpeeder", "[cpan] is gif coutinue. did not add to msg table");
      }
      for (;;)
      {
        paramInt2 += 1;
        break;
        localObject2 = new bv();
        ((bv)localObject2).setType(x.Bc(paramString));
        ((bv)localObject2).ui(paramString);
        ((bv)localObject2).kt(1);
        ((bv)localObject2).setStatus(1);
        ((bv)localObject2).uj(((e)localObject1).ifg.value);
        ((bv)localObject2).kD(((e)localObject1).ifh.value);
        ((bv)localObject2).kE(((e)localObject1).ifi.value);
        str = bn.We();
        if (((str != null) && (!str.equals(((ei)localObject2).eNd))) || ((str == null) && (((ei)localObject2).eNd != null))) {
          ((bv)localObject2).tk(str);
        }
        a.a.ZP().n((bv)localObject2);
        ((bv)localObject2).qN(bl.BQ(((ei)localObject2).field_talker));
        paramArrayList.add(localObject2);
        long l2 = ((l)g.ab(l.class)).doJ().ar((bv)localObject2);
        if (l2 <= 0L)
        {
          ae.e("MicroMsg.SendImgSpeeder", "insert error! %s", new Object[] { paramString });
          paramInt1 = 0;
        }
        else
        {
          ((e)localObject1).msgId = l2;
          this.ieO.put(Long.valueOf(((e)localObject1).msgId), localObject1);
          this.ieP.add(Long.valueOf(((e)localObject1).msgId));
          paramInt1 = 0;
        }
      }
    }
    this.ieQ.clear();
    if (l1 > 0L) {
      g.ajR().gDX.sW(l1);
    }
    if (paramInt1 != 0) {
      ((l)g.ab(l.class)).doJ().aqY("SendImgSpeeder");
    }
    AppMethodBeat.o(150739);
  }
  
  public final boolean aIM()
  {
    AppMethodBeat.i(150741);
    if ((this.ieQ.size() > 0) && (f.a.dNH().yxE <= 2))
    {
      ae.i("MicroMsg.SendImgSpeeder", "cpu core is low ,do not use multi mode");
      AppMethodBeat.o(150741);
      return false;
    }
    AppMethodBeat.o(150741);
    return true;
  }
  
  public final boolean su(long paramLong)
  {
    AppMethodBeat.i(150737);
    boolean bool = this.ieL.containsKey(Long.valueOf(paramLong));
    AppMethodBeat.o(150737);
    return bool;
  }
  
  public final d sv(long paramLong)
  {
    AppMethodBeat.i(150738);
    d locald = (d)this.ieL.get(Long.valueOf(paramLong));
    AppMethodBeat.o(150738);
    return locald;
  }
  
  public static class a
  {
    static aq cQl;
    private ReentrantLock cQj;
    private Condition cQk;
    int icr;
    a ieR;
    
    public a()
    {
      AppMethodBeat.i(150721);
      this.cQj = new ReentrantLock();
      this.cQk = this.cQj.newCondition();
      AppMethodBeat.o(150721);
    }
    
    public static a a(final p.e parame)
    {
      AppMethodBeat.i(150722);
      try
      {
        if (cQl == null) {
          cQl = new aq("big file gen Worker");
        }
        a locala1 = new a();
        parame.ifl = locala1;
        a locala2 = parame.ifl;
        cQl.post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(150720);
            long l = System.currentTimeMillis();
            p.a.a locala = new p.a.a();
            locala.ieU = new PString();
            locala.ieV = new PString();
            locala.ieW = new PString();
            locala.ieX = new PString();
            String str = h.FL(parame.ifc);
            locala.icA = q.aIX().a(parame.dsk, parame.ifc, str, parame.icr, true, locala.ieU, locala.ieV, locala.ieW, locala.ieX, parame.ife, parame.ifj);
            p.a.a(p.a.this).lock();
            try
            {
              p.a.this.ieR = locala;
              p.a.b(p.a.this).signal();
              ae.i("MicroMsg.SendImgSpeeder", "notify big file gen prepared %s last %d", new Object[] { parame.ifc, Long.valueOf(System.currentTimeMillis() - Long.valueOf(l).longValue()) });
              return;
            }
            finally
            {
              p.a.a(p.a.this).unlock();
              AppMethodBeat.o(150720);
            }
          }
        });
        locala1.icr = parame.icr;
        AppMethodBeat.o(150722);
        return locala1;
      }
      finally
      {
        AppMethodBeat.o(150722);
      }
    }
    
    /* Error */
    public final a aIO()
    {
      // Byte code:
      //   0: ldc 83
      //   2: invokestatic 32	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   5: aload_0
      //   6: getfield 37	com/tencent/mm/av/p$a:cQj	Ljava/util/concurrent/locks/ReentrantLock;
      //   9: invokevirtual 86	java/util/concurrent/locks/ReentrantLock:lock	()V
      //   12: aload_0
      //   13: getfield 88	com/tencent/mm/av/p$a:ieR	Lcom/tencent/mm/av/p$a$a;
      //   16: ifnonnull +42 -> 58
      //   19: ldc 90
      //   21: ldc 92
      //   23: invokestatic 97	com/tencent/mm/sdk/platformtools/ae:i	(Ljava/lang/String;Ljava/lang/String;)V
      //   26: aload_0
      //   27: getfield 43	com/tencent/mm/av/p$a:cQk	Ljava/util/concurrent/locks/Condition;
      //   30: invokeinterface 102 1 0
      //   35: goto -23 -> 12
      //   38: astore_1
      //   39: aload_0
      //   40: getfield 37	com/tencent/mm/av/p$a:cQj	Ljava/util/concurrent/locks/ReentrantLock;
      //   43: invokevirtual 105	java/util/concurrent/locks/ReentrantLock:unlock	()V
      //   46: aload_0
      //   47: getfield 88	com/tencent/mm/av/p$a:ieR	Lcom/tencent/mm/av/p$a$a;
      //   50: astore_1
      //   51: ldc 83
      //   53: invokestatic 46	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   56: aload_1
      //   57: areturn
      //   58: aload_0
      //   59: getfield 37	com/tencent/mm/av/p$a:cQj	Ljava/util/concurrent/locks/ReentrantLock;
      //   62: invokevirtual 105	java/util/concurrent/locks/ReentrantLock:unlock	()V
      //   65: goto -19 -> 46
      //   68: astore_1
      //   69: aload_0
      //   70: getfield 37	com/tencent/mm/av/p$a:cQj	Ljava/util/concurrent/locks/ReentrantLock;
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
      String icA;
      PString ieU;
      PString ieV;
      PString ieW;
      PString ieX;
    }
  }
  
  static final class b
  {
    b ieY;
    String ieZ;
  }
  
  public static final class c
  {
    private LinkedList<p.b> ifa;
    private LinkedList<p.b> ifb;
    
    public c()
    {
      AppMethodBeat.i(150724);
      this.ifa = new LinkedList();
      this.ifb = new LinkedList();
      AppMethodBeat.o(150724);
    }
    
    private static boolean Gb(String paramString)
    {
      AppMethodBeat.i(150728);
      if (o.aZR(paramString) > 0L)
      {
        ae.e("MicroMsg.SendImgSpeeder", "file has exist %s", new Object[] { paramString });
        AppMethodBeat.o(150728);
        return false;
      }
      AppMethodBeat.o(150728);
      return true;
    }
    
    private static p.b aIQ()
    {
      AppMethodBeat.i(150726);
      p.b localb = new p.b((byte)0);
      if (bu.isNullOrNil(null)) {}
      String str;
      for (localb.ieZ = i.aIG();; localb.ieZ = null)
      {
        str = q.aIX().FS(localb.ieZ);
        if (Gb(str)) {
          break;
        }
        AppMethodBeat.o(150726);
        return null;
      }
      localb.ieY = new b(str);
      AppMethodBeat.o(150726);
      return localb;
    }
    
    private static p.b aIR()
    {
      AppMethodBeat.i(150727);
      p.b localb = new p.b((byte)0);
      if (bu.isNullOrNil(null)) {}
      String str;
      for (localb.ieZ = i.aIG();; localb.ieZ = null)
      {
        str = q.aIX().FR(localb.ieZ);
        if (Gb(str)) {
          break;
        }
        AppMethodBeat.o(150727);
        return null;
      }
      localb.ieY = new b(str);
      AppMethodBeat.o(150727);
      return localb;
    }
    
    private void aIS()
    {
      for (;;)
      {
        int i;
        try
        {
          AppMethodBeat.i(150730);
          StringBuilder localStringBuilder = new StringBuilder();
          i = 0;
          if (i < this.ifa.size())
          {
            localStringBuilder.append(((p.b)this.ifa.get(i)).ieZ);
            if (i != this.ifa.size() - 1) {
              localStringBuilder.append("-");
            }
          }
          else
          {
            ae.d("MicroMsg.SendImgSpeeder", "sync big des to file %s ", new Object[] { localStringBuilder.toString() });
            g.ajR().ajA().set(348176, localStringBuilder.toString());
            AppMethodBeat.o(150730);
            return;
          }
        }
        finally {}
        i += 1;
      }
    }
    
    private void aIT()
    {
      for (;;)
      {
        int i;
        try
        {
          AppMethodBeat.i(150731);
          StringBuilder localStringBuilder = new StringBuilder();
          i = 0;
          if (i < this.ifb.size())
          {
            localStringBuilder.append(((p.b)this.ifb.get(i)).ieZ);
            if (i != this.ifb.size() - 1) {
              localStringBuilder.append("-");
            }
          }
          else
          {
            ae.d("MicroMsg.SendImgSpeeder", "sync thumb des to file %s ", new Object[] { localStringBuilder.toString() });
            g.ajR().ajA().set(348177, localStringBuilder.toString());
            AppMethodBeat.o(150731);
            return;
          }
        }
        finally {}
        i += 1;
      }
    }
    
    public final void aIP()
    {
      int j = 0;
      try
      {
        AppMethodBeat.i(150725);
        int i = this.ifa.size();
        int k;
        p.b localb;
        if (i < 0)
        {
          k = 5 - i;
          i = 0;
          while (i < k)
          {
            localb = aIQ();
            this.ifa.add(localb);
            i += 1;
          }
          ae.i("MicroMsg.SendImgSpeeder", "add big File pool added size %d , all size %d", new Object[] { Integer.valueOf(k), Integer.valueOf(this.ifa.size()) });
          aIS();
        }
        i = this.ifb.size();
        if (i < 0)
        {
          k = 5 - i;
          i = j;
          while (i < k)
          {
            localb = aIR();
            this.ifb.add(localb);
            i += 1;
          }
          aIT();
          ae.i("MicroMsg.SendImgSpeeder", "add big thumb pool added size %d , all size %d", new Object[] { Integer.valueOf(k), Integer.valueOf(this.ifb.size()) });
        }
        AppMethodBeat.o(150725);
        return;
      }
      finally {}
    }
    
    public final p.b pE(int paramInt)
    {
      for (;;)
      {
        try
        {
          AppMethodBeat.i(150729);
          p.b localb1 = null;
          if (paramInt == 1)
          {
            if (this.ifa.size() > 0)
            {
              localb1 = (p.b)this.ifa.remove();
              aIS();
              aIP();
              AppMethodBeat.o(150729);
              return localb1;
            }
            localb1 = aIQ();
            continue;
          }
          if (paramInt == 2) {
            if (this.ifb.size() > 0)
            {
              localb1 = (p.b)this.ifb.remove();
              aIT();
            }
            else
            {
              p.b localb2 = aIR();
            }
          }
        }
        finally {}
      }
    }
  }
  
  public static final class d
  {
    public long dzX;
    public long offset;
  }
  
  public static final class e
  {
    int doj;
    String dsk;
    int dyw;
    int icr;
    String ifc;
    String ifd;
    String ife;
    long iff;
    PString ifg;
    PInt ifh;
    PInt ifi;
    b ifj;
    b ifk;
    p.a ifl;
    long msgId;
    
    public static e a(String paramString1, int paramInt1, int paramInt2, int paramInt3, String paramString2, String paramString3, PString paramPString, PInt paramPInt1, PInt paramPInt2, b paramb1, b paramb2)
    {
      AppMethodBeat.i(150732);
      e locale = new e();
      locale.ifc = paramString1;
      locale.icr = paramInt1;
      locale.doj = paramInt2;
      locale.dyw = paramInt3;
      locale.ifd = paramString2;
      locale.ifg = paramPString;
      locale.ifi = paramPInt2;
      locale.ifh = paramPInt1;
      locale.ife = paramString3;
      locale.ifk = paramb2;
      locale.ifj = paramb1;
      if (p.aIN().aIM()) {
        p.a.a(locale);
      }
      AppMethodBeat.o(150732);
      return locale;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.av.p
 * JD-Core Version:    0.7.0.1
 */