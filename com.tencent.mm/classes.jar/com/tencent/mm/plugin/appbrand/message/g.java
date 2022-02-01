package com.tencent.mm.plugin.appbrand.message;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.a.c;
import com.tencent.mm.ah.a.d;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.x;
import com.tencent.mm.ak.x.a;
import com.tencent.mm.bw.a;
import com.tencent.mm.modelappbrand.m;
import com.tencent.mm.modelappbrand.m.a;
import com.tencent.mm.plugin.appbrand.app.j;
import com.tencent.mm.protocal.protobuf.bfc;
import com.tencent.mm.protocal.protobuf.bfd;
import com.tencent.mm.protocal.protobuf.cyi;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bs;
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
  private static Map<String, Object> lvc;
  private static Map<String, List<a>> lvd;
  
  static
  {
    AppMethodBeat.i(47740);
    lvc = new HashMap();
    lvd = new HashMap();
    AppMethodBeat.o(47740);
  }
  
  public final void a(String paramString1, String paramString2, String paramString3, int paramInt, m.a parama)
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(47736);
        if ((bs.isNullOrNil(paramString1)) || (bs.isNullOrNil(paramString2)) || (bs.isNullOrNil(paramString3)))
        {
          ac.e("MicroMsg.WxaUpdateableMsgService", "token appId or shareKey is null, return");
          AppMethodBeat.o(47736);
          return;
        }
        List localList = (List)lvd.get(paramString1);
        Object localObject = localList;
        if (localList == null)
        {
          ac.i("MicroMsg.WxaUpdateableMsgService", "addOnUpdatbleMsgInfoChange token:%s", new Object[] { paramString1 });
          localObject = new ArrayList();
          lvd.put(paramString1, localObject);
        }
        ac.i("MicroMsg.WxaUpdateableMsgService", "addOnUpdatbleMsgInfoChange shareKeyHash:%d", new Object[] { Integer.valueOf(paramString3.hashCode()) });
        ac.d("MicroMsg.WxaUpdateableMsgService", "addOnUpdatbleMsgInfoChange shareKey:%s", new Object[] { paramString3 });
        paramString1 = new a((byte)0);
        paramString1.appId = paramString2;
        paramString1.ccd = paramString3;
        paramString1.lve = paramInt;
        paramString1.lvf = parama;
        if ((bs.isNullOrNil(paramString1.appId)) || (bs.isNullOrNil(paramString1.ccd)))
        {
          ac.w("MicroMsg.WxaUpdateableMsgService", "appId or shareKey is null, return");
          ((List)localObject).add(paramString1);
          AppMethodBeat.o(47736);
          continue;
        }
        paramString2 = b.lvg;
      }
      finally {}
      ac.d("MicroMsg.WxaUpdateableMsgService", "[addWorker]getUpdatableMsgWorkerList size:%d", new Object[] { Integer.valueOf(paramString2.lvh.size()) });
      paramString2.lvh.put(Integer.valueOf(paramString1.ccd.hashCode()), paramString1);
    }
  }
  
  public final boolean a(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(47735);
    d locald = j.aVz();
    if (locald == null)
    {
      ac.e("MicroMsg.WxaUpdateableMsgService", "wxaUpdateableMsgStorage is null, err");
      AppMethodBeat.o(47735);
      return false;
    }
    boolean bool;
    if (bs.isNullOrNil(paramString1))
    {
      ac.e("MicroMsg.WxaUpdateableMsgStorage", "shareKey is null, err");
      bool = false;
    }
    for (;;)
    {
      ac.d("MicroMsg.WxaUpdateableMsgService", "shareKey:%s, shareKeyHash:%d, content:%s contentColor:%s isOk:%b", new Object[] { paramString1, Integer.valueOf(paramString1.hashCode()), paramString2, paramString3, Boolean.valueOf(bool) });
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
  
  public final void aAG()
  {
    AppMethodBeat.i(47738);
    ac.i("MicroMsg.WxaUpdateableMsgService", "startUpdatbleMsgInfoChange");
    b.lvg.start();
    AppMethodBeat.o(47738);
  }
  
  public final void aAH()
  {
    AppMethodBeat.i(47739);
    ac.i("MicroMsg.WxaUpdateableMsgService", "stopOnUpdatbleMsgInfoChange");
    b.lvg.stop();
    AppMethodBeat.o(47739);
  }
  
  public final boolean af(String paramString, int paramInt)
  {
    AppMethodBeat.i(47734);
    d locald = j.aVz();
    if (locald == null)
    {
      ac.e("MicroMsg.WxaUpdateableMsgService", "wxaUpdateableMsgStorage is null, err");
      AppMethodBeat.o(47734);
      return false;
    }
    boolean bool;
    if (bs.isNullOrNil(paramString))
    {
      ac.e("MicroMsg.WxaUpdateableMsgStorage", "shareKey is null, err");
      bool = false;
    }
    for (;;)
    {
      ac.d("MicroMsg.WxaUpdateableMsgService", "shareKey:%s, shareKeyHash:%d, btnState:%d isOk:%b", new Object[] { paramString, Integer.valueOf(paramString.hashCode()), Integer.valueOf(paramInt), Boolean.valueOf(bool) });
      if (bool) {
        lvc.get(paramString);
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
  
  public final c ze(String paramString)
  {
    AppMethodBeat.i(47733);
    d locald = j.aVz();
    if (locald == null)
    {
      ac.e("MicroMsg.WxaUpdateableMsgService", "wxaUpdateableMsgStorage is null");
      AppMethodBeat.o(47733);
      return null;
    }
    if (bs.isNullOrNil(paramString))
    {
      ac.e("MicroMsg.WxaUpdateableMsgService", "shareKey is null, return");
      AppMethodBeat.o(47733);
      return null;
    }
    int i = paramString.hashCode();
    c localc2 = new c();
    localc2.field_shareKeyHash = i;
    c localc1 = localc2;
    if (!locald.get(localc2, new String[] { "shareKeyHash" }))
    {
      ac.e("MicroMsg.WxaUpdateableMsgStorage", "WxaUpdateableMsg is null");
      localc1 = null;
    }
    if (localc1 == null)
    {
      ac.e("MicroMsg.WxaUpdateableMsgService", "shareKey:%s, shareKeyHash:%d, wxaUpdateableMsg is null", new Object[] { paramString, Integer.valueOf(paramString.hashCode()) });
      AppMethodBeat.o(47733);
      return null;
    }
    ac.d("MicroMsg.WxaUpdateableMsgService", "shareKey:%s, shareKeyHash:%d status:%s", new Object[] { paramString, Integer.valueOf(paramString.hashCode()), Integer.valueOf(localc1.field_btnState) });
    AppMethodBeat.o(47733);
    return localc1;
  }
  
  public final void zf(String paramString)
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(47737);
        ac.i("MicroMsg.WxaUpdateableMsgService", "removeOnUpdatbleMsgInfoChange token:%s", new Object[] { paramString });
        Object localObject = (List)lvd.get(paramString);
        if (localObject == null)
        {
          ac.w("MicroMsg.WxaUpdateableMsgService", "[removeOnUpdatbleMsgInfoChange]getUpdatableMsgWorkers is null, err");
          AppMethodBeat.o(47737);
          return;
        }
        localObject = ((List)localObject).iterator();
        if (((Iterator)localObject).hasNext())
        {
          a locala = (a)((Iterator)localObject).next();
          b localb = b.lvg;
          ac.d("MicroMsg.WxaUpdateableMsgService", "[removeWorker]getUpdatableMsgWorkerList size:%d", new Object[] { Integer.valueOf(localb.lvh.size()) });
          localb.lvh.remove(Integer.valueOf(locala.ccd.hashCode()));
          continue;
        }
        lvd.remove(paramString);
      }
      finally {}
      AppMethodBeat.o(47737);
    }
  }
  
  static final class a
  {
    public String appId;
    public String ccd;
    public long lastUpdateTime;
    public int lve;
    public m.a lvf;
    
    private long bpa()
    {
      AppMethodBeat.i(47719);
      long l = System.currentTimeMillis() - this.lastUpdateTime;
      ac.d("MicroMsg.WxaUpdateableMsgService", "consumeTime:%d", new Object[] { Long.valueOf(l) });
      AppMethodBeat.o(47719);
      return l;
    }
    
    public final boolean boZ()
    {
      AppMethodBeat.i(47718);
      if (this.lve < 0)
      {
        AppMethodBeat.o(47718);
        return false;
      }
      if (this.lve == 0)
      {
        if (bpa() > 10000L)
        {
          AppMethodBeat.o(47718);
          return true;
        }
        AppMethodBeat.o(47718);
        return false;
      }
      if (bpa() > this.lve * 1000L)
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
    private AtomicBoolean cTG;
    Map<Integer, g.a> lvh;
    private Runnable lvi;
    
    static
    {
      AppMethodBeat.i(47732);
      lvg = new b("INSTANCE");
      lvj = new b[] { lvg };
      AppMethodBeat.o(47732);
    }
    
    private b()
    {
      AppMethodBeat.i(47724);
      this.lvh = new ConcurrentHashMap();
      this.cTG = new AtomicBoolean(true);
      this.lvi = new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(47720);
          LinkedList localLinkedList = new LinkedList();
          Object localObject1 = g.b.a(g.b.this).values().iterator();
          while (((Iterator)localObject1).hasNext())
          {
            localObject2 = (g.a)((Iterator)localObject1).next();
            if (((g.a)localObject2).boZ())
            {
              localObject3 = new cyi();
              ((cyi)localObject3).FHE = ((g.a)localObject2).ccd;
              ((cyi)localObject3).djj = ((g.a)localObject2).appId;
              localLinkedList.add(localObject3);
            }
          }
          localObject1 = g.b.this;
          if (localLinkedList.size() <= 0)
          {
            ac.d("MicroMsg.WxaUpdateableMsgService", "shareKeyInfoList is null, return");
            ((g.b)localObject1).bpb();
            AppMethodBeat.o(47720);
            return;
          }
          ac.d("MicroMsg.WxaUpdateableMsgService", "getUpdateableMsg shareKeyInfoList.size:%d", new Object[] { Integer.valueOf(localLinkedList.size()) });
          Object localObject2 = new b.a();
          ((b.a)localObject2).funcId = 2954;
          ((b.a)localObject2).uri = "/cgi-bin/mmbiz-bin/wxabusiness/getupdatablemsginfo";
          Object localObject3 = new bfc();
          ((bfc)localObject3).EUt = localLinkedList;
          ((b.a)localObject2).hvt = ((a)localObject3);
          ((b.a)localObject2).hvu = new bfd();
          x.a(((b.a)localObject2).aAz(), new g.b.2((g.b)localObject1));
          AppMethodBeat.o(47720);
        }
      };
      AppMethodBeat.o(47724);
    }
    
    final void bpb()
    {
      boolean bool1 = false;
      boolean bool2 = true;
      try
      {
        AppMethodBeat.i(47727);
        com.tencent.mm.kernel.g.agU();
        ap.aB(this.lvi);
        if (this.cTG.get())
        {
          ac.d("MicroMsg.WxaUpdateableMsgService", "isPause, not sendUpdatableMsgRequest");
          AppMethodBeat.o(47727);
        }
        for (;;)
        {
          return;
          if (this.lvh.size() > 0) {
            break;
          }
          ac.d("MicroMsg.WxaUpdateableMsgService", "sGetUpdatableMsgWorkerMap is empty, not sendUpdatableMsgRequest");
          AppMethodBeat.o(47727);
        }
        l = 9223372036854775807L;
      }
      finally {}
      long l;
      Iterator localIterator = this.lvh.values().iterator();
      label101:
      g.a locala;
      if (localIterator.hasNext())
      {
        locala = (g.a)localIterator.next();
        if (locala.boZ())
        {
          l = 0L;
          bool1 = bool2;
        }
      }
      for (;;)
      {
        ac.d("MicroMsg.WxaUpdateableMsgService", "needUpdate:%b minDelayTime:%d", new Object[] { Boolean.valueOf(bool1), Long.valueOf(l) });
        if (!bool1)
        {
          AppMethodBeat.o(47727);
          break;
          if (locala.lve < 0) {
            break label101;
          }
          l = Math.min(locala.lve, l);
          bool1 = true;
          break label101;
        }
        com.tencent.mm.kernel.g.agU().m(this.lvi, l * 1000L);
        AppMethodBeat.o(47727);
        break;
      }
    }
    
    public final void start()
    {
      try
      {
        AppMethodBeat.i(47725);
        this.cTG.set(false);
        bpb();
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
        this.cTG.set(true);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.message.g
 * JD-Core Version:    0.7.0.1
 */