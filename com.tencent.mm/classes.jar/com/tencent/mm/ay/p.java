package com.tencent.mm.ay;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.b;
import com.tencent.mm.f.c.et;
import com.tencent.mm.kernel.f;
import com.tencent.mm.m.a;
import com.tencent.mm.m.a.a;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.bq;
import com.tencent.mm.model.bs;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.plugin.report.service.g;
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
import com.tencent.mm.vfs.u;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class p
{
  private static p lQd;
  ConcurrentHashMap<Long, d> lQb;
  public c lQc;
  public ConcurrentHashMap<Long, e> lQe;
  private ArrayList<Long> lQf;
  ArrayList<e> lQg;
  
  public p()
  {
    AppMethodBeat.i(150733);
    this.lQb = new ConcurrentHashMap();
    this.lQe = new ConcurrentHashMap();
    this.lQf = new ArrayList();
    this.lQg = new ArrayList();
    this.lQc = new c();
    AppMethodBeat.o(150733);
  }
  
  private boolean Wj(String paramString)
  {
    AppMethodBeat.i(150740);
    Iterator localIterator = this.lQg.iterator();
    while (localIterator.hasNext()) {
      if (((e)localIterator.next()).lQr.equals(paramString))
      {
        AppMethodBeat.o(150740);
        return true;
      }
    }
    AppMethodBeat.o(150740);
    return false;
  }
  
  public static p blV()
  {
    AppMethodBeat.i(150734);
    if (lQd == null) {}
    try
    {
      if (lQd == null) {
        lQd = new p();
      }
      p localp = lQd;
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
  
  public final boolean GI(long paramLong)
  {
    AppMethodBeat.i(150737);
    boolean bool = this.lQb.containsKey(Long.valueOf(paramLong));
    AppMethodBeat.o(150737);
    return bool;
  }
  
  public final d GJ(long paramLong)
  {
    AppMethodBeat.i(150738);
    d locald = (d)this.lQb.get(Long.valueOf(paramLong));
    AppMethodBeat.o(150738);
    return locald;
  }
  
  public final ArrayList<String> Wh(String paramString)
  {
    AppMethodBeat.i(150735);
    ArrayList localArrayList = new ArrayList();
    if (!Util.isNullOrNil(paramString))
    {
      Iterator localIterator = this.lQe.values().iterator();
      while (localIterator.hasNext())
      {
        e locale = (e)localIterator.next();
        if (paramString.equals(locale.fCl)) {
          localArrayList.add(locale.lQr);
        }
      }
    }
    AppMethodBeat.o(150735);
    return localArrayList;
  }
  
  public final ArrayList<Integer> Wi(String paramString)
  {
    AppMethodBeat.i(150736);
    Object localObject1 = this.lQe.values();
    Object localObject2 = ((Collection)localObject1).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      e locale = (e)((Iterator)localObject2).next();
      PString localPString = new PString();
      PInt localPInt1 = new PInt();
      PInt localPInt2 = new PInt();
      locale.lQu = q.bmh().a(locale.fCl, locale.lQr, locale.lNK, locale.source, locale.fJu, localPString, localPInt1, localPInt2, locale.lQs, locale.lQt, locale.msgId, locale.lQy, locale.lQz, locale.lQA, -1);
      ca localca = ((n)com.tencent.mm.kernel.h.ae(n.class)).eSe().Oq(locale.msgId);
      if (Util.isNullOrNil(localca.field_imgPath))
      {
        localca.Jn(localPString.value);
        localca.pW(localPInt1.value);
        localca.pX(localPInt2.value);
        ((n)com.tencent.mm.kernel.h.ae(n.class)).eSe().a(locale.msgId, localca);
      }
    }
    if (!Util.isNullOrNil(paramString))
    {
      localObject1 = ((Collection)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (e)((Iterator)localObject1).next();
        if (!paramString.equals(((e)localObject2).fCl))
        {
          this.lQe.remove(Long.valueOf(((e)localObject2).msgId));
          this.lQf.remove(Long.valueOf(((e)localObject2).msgId));
          Log.e("MicroMsg.SendImgSpeeder", "fatal!! Send user mis-match, want:%s, fact:%s", new Object[] { paramString, ((e)localObject2).fCl });
        }
      }
    }
    paramString = new ArrayList();
    int i = 0;
    while (i < this.lQf.size())
    {
      paramString.add(Integer.valueOf((int)((e)this.lQe.get(this.lQf.get(i))).lQu));
      i += 1;
    }
    this.lQe.clear();
    this.lQf.clear();
    Log.i("MicroMsg.SendImgSpeeder", "syncImgData, id size %d", new Object[] { Integer.valueOf(paramString.size()) });
    AppMethodBeat.o(150736);
    return paramString;
  }
  
  public final void a(int paramInt1, int paramInt2, String paramString1, String paramString2, boolean paramBoolean, int paramInt3)
  {
    AppMethodBeat.i(191107);
    if (Wj(paramString1))
    {
      AppMethodBeat.o(191107);
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
    if (blW())
    {
      localObject2 = this.lQc.ws(1);
      localObject1 = this.lQc.ws(2);
      localb1 = ((b)localObject2).lQo;
      localb2 = ((b)localObject1).lQo;
      localObject1 = ((b)localObject1).des;
      localObject2 = ((b)localObject2).des;
    }
    q.bmh().a(paramString2, paramString1, i, localPString, localPInt1, localPInt2, paramInt2, paramInt3, (String)localObject1);
    localObject1 = e.a(paramString1, i, paramInt1, paramInt2, (String)localObject1, (String)localObject2, localPString, localPInt1, localPInt2, localb1, localb2);
    ((e)localObject1).fCl = paramString2;
    this.lQg.add(localObject1);
    Log.i("MicroMsg.SendImgSpeeder", "summersafecdn img path %s has prebuild, user:%s", new Object[] { paramString1, paramString2 });
    AppMethodBeat.o(191107);
  }
  
  public final void a(ArrayList<String> paramArrayList, boolean paramBoolean, int paramInt1, int paramInt2, String paramString, int paramInt3)
  {
    AppMethodBeat.i(191096);
    Log.i("MicroMsg.SendImgSpeeder", "summersafecdn sendThumbImg fileSize:%d, compressImg[%b], source[%d], user:%s", new Object[] { Integer.valueOf(paramArrayList.size()), Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt1), paramString });
    Object localObject1 = this.lQg.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (e)((Iterator)localObject1).next();
      if ((!paramArrayList.contains(((e)localObject2).lQr)) || ((!Util.isNullOrNil(((e)localObject2).fCl)) && (!((e)localObject2).fCl.equalsIgnoreCase(paramString))) || ((!Util.isNullOrNil(paramString)) && (!paramString.equalsIgnoreCase(((e)localObject2).fCl)))) {
        ((Iterator)localObject1).remove();
      } else {
        ((e)localObject2).lNK = g(((e)localObject2).lQr, paramString, paramBoolean);
      }
    }
    localObject1 = new ArrayList();
    Object localObject2 = paramArrayList.iterator();
    String str;
    while (((Iterator)localObject2).hasNext())
    {
      str = (String)((Iterator)localObject2).next();
      Iterator localIterator = this.lQg.iterator();
      while (localIterator.hasNext())
      {
        e locale = (e)localIterator.next();
        if (locale.lQr.equals(str)) {
          ((ArrayList)localObject1).add(locale);
        }
      }
    }
    this.lQg.clear();
    this.lQg.addAll((Collection)localObject1);
    localObject1 = new ArrayList();
    if (paramArrayList.size() == 9)
    {
      g.ada(18);
      paramArrayList = paramArrayList.iterator();
    }
    for (;;)
    {
      if (!paramArrayList.hasNext()) {
        break label485;
      }
      localObject2 = (String)paramArrayList.next();
      if ((localObject2 == null) || (((String)localObject2).equals("")) || (!u.agG((String)localObject2)))
      {
        Log.d("MicroMsg.SendImgSpeeder", " doSendImage : filePath is null or empty");
        continue;
        if (paramArrayList.size() == 1)
        {
          boolean bool = NetStatusUtil.isWifi(MMApplicationContext.getContext());
          g.ada(25);
          if (!bool) {
            break;
          }
          if (z.f((String)paramArrayList.get(0), paramString, paramBoolean))
          {
            g.ada(23);
            break;
          }
          g.ada(21);
          break;
        }
        g.ada(24);
        break;
      }
      if (ImgUtil.isGif((String)localObject2)) {
        Log.i("MicroMsg.SendImgSpeeder", "[cpan] is gif coutinue. did not add filePath:%s filesize:%d", new Object[] { localObject2, Long.valueOf(u.bBQ((String)localObject2)) });
      } else if (!Wj((String)localObject2)) {
        ((ArrayList)localObject1).add(localObject2);
      }
    }
    label485:
    paramArrayList = ((ArrayList)localObject1).iterator();
    while (paramArrayList.hasNext()) {
      a(paramInt1, paramInt2, (String)paramArrayList.next(), paramString, paramBoolean, paramInt3);
    }
    paramArrayList = new ArrayList();
    long l1 = com.tencent.mm.kernel.h.aHG().kcF.beginTransaction(Thread.currentThread().getId());
    ((n)com.tencent.mm.kernel.h.ae(n.class)).eSe().aOC("SendImgSpeeder");
    paramInt1 = 1;
    paramInt2 = 0;
    if (paramInt2 < this.lQg.size())
    {
      localObject1 = (e)this.lQg.get(paramInt2);
      if (ImgUtil.isGif(((e)localObject1).lQr)) {
        Log.i("MicroMsg.SendImgSpeeder", "[cpan] is gif coutinue. did not add to msg table");
      }
      for (;;)
      {
        paramInt2 += 1;
        break;
        localObject2 = new ca();
        ((ca)localObject2).setType(ab.Ra(paramString));
        ((ca)localObject2).Jm(paramString);
        ((ca)localObject2).pJ(1);
        ((ca)localObject2).setStatus(1);
        ((ca)localObject2).Jn(((e)localObject1).lQv.value);
        ((ca)localObject2).pW(((e)localObject1).lQw.value);
        ((ca)localObject2).pX(((e)localObject1).lQx.value);
        str = bs.apc();
        if (((str != null) && (!str.equals(((et)localObject2).hxy))) || ((str == null) && (((et)localObject2).hxy != null))) {
          ((ca)localObject2).Ip(str);
        }
        a.a.atD().n((ca)localObject2);
        ((ca)localObject2).setCreateTime(bq.RP(((et)localObject2).field_talker));
        paramArrayList.add(localObject2);
        long l2 = ((n)com.tencent.mm.kernel.h.ae(n.class)).eSe().aM((ca)localObject2);
        if (l2 <= 0L)
        {
          Log.e("MicroMsg.SendImgSpeeder", "insert error! %s", new Object[] { paramString });
          paramInt1 = 0;
        }
        else
        {
          ((e)localObject1).msgId = l2;
          this.lQe.put(Long.valueOf(((e)localObject1).msgId), localObject1);
          this.lQf.add(Long.valueOf(((e)localObject1).msgId));
          paramInt1 = 0;
        }
      }
    }
    this.lQg.clear();
    if (l1 > 0L) {
      com.tencent.mm.kernel.h.aHG().kcF.endTransaction(l1);
    }
    if (paramInt1 != 0) {
      ((n)com.tencent.mm.kernel.h.ae(n.class)).eSe().aOD("SendImgSpeeder");
    }
    AppMethodBeat.o(191096);
  }
  
  public final boolean blW()
  {
    AppMethodBeat.i(150741);
    if ((this.lQg.size() > 0) && (g.a.fBC().IzA <= 2))
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
    static MMHandler eYn;
    private ReentrantLock eYl;
    private Condition eYm;
    int lNK;
    a lQh;
    
    public a()
    {
      AppMethodBeat.i(150721);
      this.eYl = new ReentrantLock();
      this.eYm = this.eYl.newCondition();
      AppMethodBeat.o(150721);
    }
    
    public static a a(final p.e parame)
    {
      AppMethodBeat.i(150722);
      try
      {
        if (eYn == null) {
          eYn = new MMHandler("big file gen Worker");
        }
        a locala1 = new a();
        parame.lQA = locala1;
        a locala2 = parame.lQA;
        eYn.post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(150720);
            long l = System.currentTimeMillis();
            p.a.a locala = new p.a.a();
            locala.lQk = new PString();
            locala.lQl = new PString();
            locala.lQm = new PString();
            locala.lQn = new PString();
            String str = h.VT(parame.lQr);
            locala.lNS = q.bmh().a(parame.fCl, parame.lQr, str, parame.lNK, true, locala.lQk, locala.lQl, locala.lQm, locala.lQn, parame.lQt, parame.lQy, -1);
            p.a.a(p.a.this).lock();
            try
            {
              p.a.this.lQh = locala;
              p.a.b(p.a.this).signal();
              Log.i("MicroMsg.SendImgSpeeder", "notify big file gen prepared %s last %d", new Object[] { parame.lQr, Long.valueOf(System.currentTimeMillis() - Long.valueOf(l).longValue()) });
              return;
            }
            finally
            {
              p.a.a(p.a.this).unlock();
              AppMethodBeat.o(150720);
            }
          }
        });
        locala1.lNK = parame.lNK;
        AppMethodBeat.o(150722);
        return locala1;
      }
      finally
      {
        AppMethodBeat.o(150722);
      }
    }
    
    /* Error */
    public final a blY()
    {
      // Byte code:
      //   0: ldc 83
      //   2: invokestatic 32	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   5: aload_0
      //   6: getfield 37	com/tencent/mm/ay/p$a:eYl	Ljava/util/concurrent/locks/ReentrantLock;
      //   9: invokevirtual 86	java/util/concurrent/locks/ReentrantLock:lock	()V
      //   12: aload_0
      //   13: getfield 88	com/tencent/mm/ay/p$a:lQh	Lcom/tencent/mm/ay/p$a$a;
      //   16: ifnonnull +42 -> 58
      //   19: ldc 90
      //   21: ldc 92
      //   23: invokestatic 97	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
      //   26: aload_0
      //   27: getfield 43	com/tencent/mm/ay/p$a:eYm	Ljava/util/concurrent/locks/Condition;
      //   30: invokeinterface 102 1 0
      //   35: goto -23 -> 12
      //   38: astore_1
      //   39: aload_0
      //   40: getfield 37	com/tencent/mm/ay/p$a:eYl	Ljava/util/concurrent/locks/ReentrantLock;
      //   43: invokevirtual 105	java/util/concurrent/locks/ReentrantLock:unlock	()V
      //   46: aload_0
      //   47: getfield 88	com/tencent/mm/ay/p$a:lQh	Lcom/tencent/mm/ay/p$a$a;
      //   50: astore_1
      //   51: ldc 83
      //   53: invokestatic 46	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   56: aload_1
      //   57: areturn
      //   58: aload_0
      //   59: getfield 37	com/tencent/mm/ay/p$a:eYl	Ljava/util/concurrent/locks/ReentrantLock;
      //   62: invokevirtual 105	java/util/concurrent/locks/ReentrantLock:unlock	()V
      //   65: goto -19 -> 46
      //   68: astore_1
      //   69: aload_0
      //   70: getfield 37	com/tencent/mm/ay/p$a:eYl	Ljava/util/concurrent/locks/ReentrantLock;
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
      String lNS;
      PString lQk;
      PString lQl;
      PString lQm;
      PString lQn;
    }
  }
  
  static final class b
  {
    String des;
    b lQo;
  }
  
  public static final class c
  {
    private LinkedList<p.b> lQp;
    private LinkedList<p.b> lQq;
    
    public c()
    {
      AppMethodBeat.i(150724);
      this.lQp = new LinkedList();
      this.lQq = new LinkedList();
      AppMethodBeat.o(150724);
    }
    
    private static boolean Wk(String paramString)
    {
      AppMethodBeat.i(150728);
      if (u.bBQ(paramString) > 0L)
      {
        Log.e("MicroMsg.SendImgSpeeder", "file has exist %s", new Object[] { paramString });
        AppMethodBeat.o(150728);
        return false;
      }
      AppMethodBeat.o(150728);
      return true;
    }
    
    private static p.b bma()
    {
      AppMethodBeat.i(150726);
      p.b localb = new p.b((byte)0);
      if (Util.isNullOrNil(null)) {}
      String str;
      for (localb.des = i.blQ();; localb.des = null)
      {
        str = q.bmh().Wb(localb.des);
        if (Wk(str)) {
          break;
        }
        AppMethodBeat.o(150726);
        return null;
      }
      localb.lQo = new b(str);
      AppMethodBeat.o(150726);
      return localb;
    }
    
    private static p.b bmb()
    {
      AppMethodBeat.i(150727);
      p.b localb = new p.b((byte)0);
      if (Util.isNullOrNil(null)) {}
      String str;
      for (localb.des = i.blQ();; localb.des = null)
      {
        str = q.bmh().Wa(localb.des);
        if (Wk(str)) {
          break;
        }
        AppMethodBeat.o(150727);
        return null;
      }
      localb.lQo = new b(str);
      AppMethodBeat.o(150727);
      return localb;
    }
    
    private void bmc()
    {
      for (;;)
      {
        int i;
        try
        {
          AppMethodBeat.i(150730);
          StringBuilder localStringBuilder = new StringBuilder();
          i = 0;
          if (i < this.lQp.size())
          {
            localStringBuilder.append(((p.b)this.lQp.get(i)).des);
            if (i != this.lQp.size() - 1) {
              localStringBuilder.append("-");
            }
          }
          else
          {
            Log.d("MicroMsg.SendImgSpeeder", "sync big des to file %s ", new Object[] { localStringBuilder.toString() });
            com.tencent.mm.kernel.h.aHG().aHp().i(348176, localStringBuilder.toString());
            AppMethodBeat.o(150730);
            return;
          }
        }
        finally {}
        i += 1;
      }
    }
    
    private void bmd()
    {
      for (;;)
      {
        int i;
        try
        {
          AppMethodBeat.i(150731);
          StringBuilder localStringBuilder = new StringBuilder();
          i = 0;
          if (i < this.lQq.size())
          {
            localStringBuilder.append(((p.b)this.lQq.get(i)).des);
            if (i != this.lQq.size() - 1) {
              localStringBuilder.append("-");
            }
          }
          else
          {
            Log.d("MicroMsg.SendImgSpeeder", "sync thumb des to file %s ", new Object[] { localStringBuilder.toString() });
            com.tencent.mm.kernel.h.aHG().aHp().i(348177, localStringBuilder.toString());
            AppMethodBeat.o(150731);
            return;
          }
        }
        finally {}
        i += 1;
      }
    }
    
    public final void blZ()
    {
      int j = 0;
      try
      {
        AppMethodBeat.i(150725);
        int i = this.lQp.size();
        int k;
        p.b localb;
        if (i < 0)
        {
          k = 5 - i;
          i = 0;
          while (i < k)
          {
            localb = bma();
            this.lQp.add(localb);
            i += 1;
          }
          Log.i("MicroMsg.SendImgSpeeder", "add big File pool added size %d , all size %d", new Object[] { Integer.valueOf(k), Integer.valueOf(this.lQp.size()) });
          bmc();
        }
        i = this.lQq.size();
        if (i < 0)
        {
          k = 5 - i;
          i = j;
          while (i < k)
          {
            localb = bmb();
            this.lQq.add(localb);
            i += 1;
          }
          bmd();
          Log.i("MicroMsg.SendImgSpeeder", "add big thumb pool added size %d , all size %d", new Object[] { Integer.valueOf(k), Integer.valueOf(this.lQq.size()) });
        }
        AppMethodBeat.o(150725);
        return;
      }
      finally {}
    }
    
    public final p.b ws(int paramInt)
    {
      for (;;)
      {
        try
        {
          AppMethodBeat.i(150729);
          p.b localb1 = null;
          if (paramInt == 1)
          {
            if (this.lQp.size() > 0)
            {
              localb1 = (p.b)this.lQp.remove();
              bmc();
              blZ();
              AppMethodBeat.o(150729);
              return localb1;
            }
            localb1 = bma();
            continue;
          }
          if (paramInt == 2) {
            if (this.lQq.size() > 0)
            {
              localb1 = (p.b)this.lQq.remove();
              bmd();
            }
            else
            {
              p.b localb2 = bmb();
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
    String fCl;
    int fJu;
    int lNK;
    p.a lQA;
    String lQr;
    String lQs;
    String lQt;
    long lQu;
    PString lQv;
    PInt lQw;
    PInt lQx;
    b lQy;
    b lQz;
    long msgId;
    int source;
    
    public static e a(String paramString1, int paramInt1, int paramInt2, int paramInt3, String paramString2, String paramString3, PString paramPString, PInt paramPInt1, PInt paramPInt2, b paramb1, b paramb2)
    {
      AppMethodBeat.i(150732);
      e locale = new e();
      locale.lQr = paramString1;
      locale.lNK = paramInt1;
      locale.source = paramInt2;
      locale.fJu = paramInt3;
      locale.lQs = paramString2;
      locale.lQv = paramPString;
      locale.lQx = paramPInt2;
      locale.lQw = paramPInt1;
      locale.lQt = paramString3;
      locale.lQz = paramb2;
      locale.lQy = paramb1;
      if (p.blX().blW()) {
        p.a.a(locale);
      }
      AppMethodBeat.o(150732);
      return locale;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ay.p
 * JD-Core Version:    0.7.0.1
 */