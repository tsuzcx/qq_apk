package com.tencent.mm.plugin.appbrand.message;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.a.c;
import com.tencent.mm.ai.a.d;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.n;
import com.tencent.mm.al.x;
import com.tencent.mm.al.x.a;
import com.tencent.mm.bx.a;
import com.tencent.mm.modelappbrand.m;
import com.tencent.mm.modelappbrand.m.a;
import com.tencent.mm.plugin.appbrand.app.j;
import com.tencent.mm.protocal.protobuf.bjk;
import com.tencent.mm.protocal.protobuf.bjl;
import com.tencent.mm.protocal.protobuf.ddv;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;

public final class g
  implements m
{
  private static Map<String, Object> lUl;
  private static Map<String, List<a>> lUm;
  
  static
  {
    AppMethodBeat.i(47740);
    lUl = new HashMap();
    lUm = new HashMap();
    AppMethodBeat.o(47740);
  }
  
  public final c Cd(String paramString)
  {
    AppMethodBeat.i(47733);
    d locald = j.aYU();
    if (locald == null)
    {
      ad.e("MicroMsg.WxaUpdateableMsgService", "wxaUpdateableMsgStorage is null");
      AppMethodBeat.o(47733);
      return null;
    }
    if (bt.isNullOrNil(paramString))
    {
      ad.e("MicroMsg.WxaUpdateableMsgService", "shareKey is null, return");
      AppMethodBeat.o(47733);
      return null;
    }
    int i = paramString.hashCode();
    c localc2 = new c();
    localc2.field_shareKeyHash = i;
    c localc1 = localc2;
    if (!locald.get(localc2, new String[] { "shareKeyHash" }))
    {
      ad.e("MicroMsg.WxaUpdateableMsgStorage", "WxaUpdateableMsg is null");
      localc1 = null;
    }
    if (localc1 == null)
    {
      ad.e("MicroMsg.WxaUpdateableMsgService", "shareKey:%s, shareKeyHash:%d, wxaUpdateableMsg is null", new Object[] { paramString, Integer.valueOf(paramString.hashCode()) });
      AppMethodBeat.o(47733);
      return null;
    }
    ad.d("MicroMsg.WxaUpdateableMsgService", "shareKey:%s, shareKeyHash:%d status:%s", new Object[] { paramString, Integer.valueOf(paramString.hashCode()), Integer.valueOf(localc1.field_btnState) });
    AppMethodBeat.o(47733);
    return localc1;
  }
  
  public final void Ce(String paramString)
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(47737);
        ad.i("MicroMsg.WxaUpdateableMsgService", "removeOnUpdatbleMsgInfoChange token:%s", new Object[] { paramString });
        Object localObject = (List)lUm.get(paramString);
        if (localObject == null)
        {
          ad.w("MicroMsg.WxaUpdateableMsgService", "[removeOnUpdatbleMsgInfoChange]getUpdatableMsgWorkers is null, err");
          AppMethodBeat.o(47737);
          return;
        }
        localObject = ((List)localObject).iterator();
        if (((Iterator)localObject).hasNext())
        {
          a locala = (a)((Iterator)localObject).next();
          b localb = b.lUp;
          ad.d("MicroMsg.WxaUpdateableMsgService", "[removeWorker]getUpdatableMsgWorkerList size:%d", new Object[] { Integer.valueOf(localb.lUq.size()) });
          localb.lUq.remove(Integer.valueOf(locala.cmu.hashCode()));
          continue;
        }
        lUm.remove(paramString);
      }
      finally {}
      AppMethodBeat.o(47737);
    }
  }
  
  public final void a(String paramString1, String paramString2, String paramString3, int paramInt, m.a parama)
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(47736);
        if ((bt.isNullOrNil(paramString1)) || (bt.isNullOrNil(paramString2)) || (bt.isNullOrNil(paramString3)))
        {
          ad.e("MicroMsg.WxaUpdateableMsgService", "token appId or shareKey is null, return");
          AppMethodBeat.o(47736);
          return;
        }
        List localList = (List)lUm.get(paramString1);
        Object localObject = localList;
        if (localList == null)
        {
          ad.i("MicroMsg.WxaUpdateableMsgService", "addOnUpdatbleMsgInfoChange token:%s", new Object[] { paramString1 });
          localObject = new ArrayList();
          lUm.put(paramString1, localObject);
        }
        ad.i("MicroMsg.WxaUpdateableMsgService", "addOnUpdatbleMsgInfoChange shareKeyHash:%d", new Object[] { Integer.valueOf(paramString3.hashCode()) });
        ad.d("MicroMsg.WxaUpdateableMsgService", "addOnUpdatbleMsgInfoChange shareKey:%s", new Object[] { paramString3 });
        paramString1 = new a((byte)0);
        paramString1.appId = paramString2;
        paramString1.cmu = paramString3;
        paramString1.lUn = paramInt;
        paramString1.lUo = parama;
        if ((bt.isNullOrNil(paramString1.appId)) || (bt.isNullOrNil(paramString1.cmu)))
        {
          ad.w("MicroMsg.WxaUpdateableMsgService", "appId or shareKey is null, return");
          ((List)localObject).add(paramString1);
          AppMethodBeat.o(47736);
          continue;
        }
        paramString2 = b.lUp;
      }
      finally {}
      ad.d("MicroMsg.WxaUpdateableMsgService", "[addWorker]getUpdatableMsgWorkerList size:%d", new Object[] { Integer.valueOf(paramString2.lUq.size()) });
      paramString2.lUq.put(Integer.valueOf(paramString1.cmu.hashCode()), paramString1);
    }
  }
  
  public final boolean a(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(47735);
    d locald = j.aYU();
    if (locald == null)
    {
      ad.e("MicroMsg.WxaUpdateableMsgService", "wxaUpdateableMsgStorage is null, err");
      AppMethodBeat.o(47735);
      return false;
    }
    boolean bool;
    if (bt.isNullOrNil(paramString1))
    {
      ad.e("MicroMsg.WxaUpdateableMsgStorage", "shareKey is null, err");
      bool = false;
    }
    for (;;)
    {
      ad.d("MicroMsg.WxaUpdateableMsgService", "shareKey:%s, shareKeyHash:%d, content:%s contentColor:%s isOk:%b", new Object[] { paramString1, Integer.valueOf(paramString1.hashCode()), paramString2, paramString3, Boolean.valueOf(bool) });
      AppMethodBeat.o(47735);
      return bool;
      c localc = new c();
      localc.field_shareKeyHash = paramString1.hashCode();
      bool = locald.get(localc, new String[0]);
      localc.field_updatePeroid = paramInt1;
      localc.field_msgState = paramInt2;
      localc.field_content = paramString2;
      localc.field_contentColor = paramString3;
      if (bool) {
        bool = locald.update(localc, new String[0]);
      } else {
        bool = locald.insert(localc);
      }
    }
  }
  
  public final void aDJ()
  {
    AppMethodBeat.i(47738);
    ad.i("MicroMsg.WxaUpdateableMsgService", "startUpdatbleMsgInfoChange");
    b.lUp.start();
    AppMethodBeat.o(47738);
  }
  
  public final void aDK()
  {
    AppMethodBeat.i(47739);
    ad.i("MicroMsg.WxaUpdateableMsgService", "stopOnUpdatbleMsgInfoChange");
    b.lUp.stop();
    AppMethodBeat.o(47739);
  }
  
  public final boolean aj(String paramString, int paramInt)
  {
    AppMethodBeat.i(47734);
    d locald = j.aYU();
    if (locald == null)
    {
      ad.e("MicroMsg.WxaUpdateableMsgService", "wxaUpdateableMsgStorage is null, err");
      AppMethodBeat.o(47734);
      return false;
    }
    boolean bool;
    if (bt.isNullOrNil(paramString))
    {
      ad.e("MicroMsg.WxaUpdateableMsgStorage", "shareKey is null, err");
      bool = false;
    }
    for (;;)
    {
      ad.d("MicroMsg.WxaUpdateableMsgService", "shareKey:%s, shareKeyHash:%d, btnState:%d isOk:%b", new Object[] { paramString, Integer.valueOf(paramString.hashCode()), Integer.valueOf(paramInt), Boolean.valueOf(bool) });
      if (bool) {
        lUl.get(paramString);
      }
      AppMethodBeat.o(47734);
      return bool;
      c localc = new c();
      localc.field_shareKeyHash = paramString.hashCode();
      bool = locald.get(localc, new String[0]);
      localc.field_btnState = paramInt;
      if (bool) {
        bool = locald.update(localc, new String[0]);
      } else {
        bool = locald.insert(localc);
      }
    }
  }
  
  static final class a
  {
    public String appId;
    public String cmu;
    public int lUn;
    public m.a lUo;
    public long lastUpdateTime;
    
    private long bsZ()
    {
      AppMethodBeat.i(47719);
      long l = System.currentTimeMillis() - this.lastUpdateTime;
      ad.d("MicroMsg.WxaUpdateableMsgService", "consumeTime:%d", new Object[] { Long.valueOf(l) });
      AppMethodBeat.o(47719);
      return l;
    }
    
    public final boolean bsY()
    {
      AppMethodBeat.i(47718);
      if (this.lUn < 0)
      {
        AppMethodBeat.o(47718);
        return false;
      }
      if (this.lUn == 0)
      {
        if (bsZ() > 10000L)
        {
          AppMethodBeat.o(47718);
          return true;
        }
        AppMethodBeat.o(47718);
        return false;
      }
      if (bsZ() > this.lUn * 1000L)
      {
        AppMethodBeat.o(47718);
        return true;
      }
      AppMethodBeat.o(47718);
      return false;
    }
  }
  
  public static enum b
  {
    private AtomicBoolean deW;
    Map<Integer, g.a> lUq;
    private Runnable lUr;
    
    static
    {
      AppMethodBeat.i(47732);
      lUp = new b("INSTANCE");
      lUs = new b[] { lUp };
      AppMethodBeat.o(47732);
    }
    
    private b()
    {
      AppMethodBeat.i(47724);
      this.lUq = new ConcurrentHashMap();
      this.deW = new AtomicBoolean(true);
      this.lUr = new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(47720);
          LinkedList localLinkedList = new LinkedList();
          Object localObject1 = g.b.a(g.b.this).values().iterator();
          while (((Iterator)localObject1).hasNext())
          {
            localObject2 = (g.a)((Iterator)localObject1).next();
            if (((g.a)localObject2).bsY())
            {
              localObject3 = new ddv();
              ((ddv)localObject3).Hsm = ((g.a)localObject2).cmu;
              ((ddv)localObject3).duW = ((g.a)localObject2).appId;
              localLinkedList.add(localObject3);
            }
          }
          localObject1 = g.b.this;
          if (localLinkedList.size() <= 0)
          {
            ad.d("MicroMsg.WxaUpdateableMsgService", "shareKeyInfoList is null, return");
            ((g.b)localObject1).bta();
            AppMethodBeat.o(47720);
            return;
          }
          ad.d("MicroMsg.WxaUpdateableMsgService", "getUpdateableMsg shareKeyInfoList.size:%d", new Object[] { Integer.valueOf(localLinkedList.size()) });
          Object localObject2 = new b.a();
          ((b.a)localObject2).funcId = 2954;
          ((b.a)localObject2).uri = "/cgi-bin/mmbiz-bin/wxabusiness/getupdatablemsginfo";
          Object localObject3 = new bjk();
          ((bjk)localObject3).GDQ = localLinkedList;
          ((b.a)localObject2).hNM = ((a)localObject3);
          ((b.a)localObject2).hNN = new bjl();
          x.a(((b.a)localObject2).aDC(), new g.b.2((g.b)localObject1));
          AppMethodBeat.o(47720);
        }
      };
      AppMethodBeat.o(47724);
    }
    
    final void bta()
    {
      boolean bool1 = false;
      boolean bool2 = true;
      try
      {
        AppMethodBeat.i(47727);
        com.tencent.mm.kernel.g.ajF();
        aq.aA(this.lUr);
        if (this.deW.get())
        {
          ad.d("MicroMsg.WxaUpdateableMsgService", "isPause, not sendUpdatableMsgRequest");
          AppMethodBeat.o(47727);
        }
        for (;;)
        {
          return;
          if (this.lUq.size() > 0) {
            break;
          }
          ad.d("MicroMsg.WxaUpdateableMsgService", "sGetUpdatableMsgWorkerMap is empty, not sendUpdatableMsgRequest");
          AppMethodBeat.o(47727);
        }
        l = 9223372036854775807L;
      }
      finally {}
      long l;
      Iterator localIterator = this.lUq.values().iterator();
      label101:
      g.a locala;
      if (localIterator.hasNext())
      {
        locala = (g.a)localIterator.next();
        if (locala.bsY())
        {
          l = 0L;
          bool1 = bool2;
        }
      }
      for (;;)
      {
        ad.d("MicroMsg.WxaUpdateableMsgService", "needUpdate:%b minDelayTime:%d", new Object[] { Boolean.valueOf(bool1), Long.valueOf(l) });
        if (!bool1)
        {
          AppMethodBeat.o(47727);
          break;
          if (locala.lUn < 0) {
            break label101;
          }
          l = Math.min(locala.lUn, l);
          bool1 = true;
          break label101;
        }
        com.tencent.mm.kernel.g.ajF().n(this.lUr, l * 1000L);
        AppMethodBeat.o(47727);
        break;
      }
    }
    
    public final void start()
    {
      try
      {
        AppMethodBeat.i(47725);
        this.deW.set(false);
        bta();
        AppMethodBeat.o(47725);
        return;
      }
      finally
      {
        localObject = finally;
        throw localObject;
      }
    }
    
    public final void stop()
    {
      try
      {
        AppMethodBeat.i(47726);
        this.deW.set(true);
        AppMethodBeat.o(47726);
        return;
      }
      finally
      {
        localObject = finally;
        throw localObject;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.message.g
 * JD-Core Version:    0.7.0.1
 */