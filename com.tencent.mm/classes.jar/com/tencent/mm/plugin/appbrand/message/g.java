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
import com.tencent.mm.protocal.protobuf.bkc;
import com.tencent.mm.protocal.protobuf.bkd;
import com.tencent.mm.protocal.protobuf.dep;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.bu;
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
  private static Map<String, Object> lYO;
  private static Map<String, List<a>> lYP;
  
  static
  {
    AppMethodBeat.i(47740);
    lYO = new HashMap();
    lYP = new HashMap();
    AppMethodBeat.o(47740);
  }
  
  public final c CF(String paramString)
  {
    AppMethodBeat.i(47733);
    d locald = j.aZr();
    if (locald == null)
    {
      ae.e("MicroMsg.WxaUpdateableMsgService", "wxaUpdateableMsgStorage is null");
      AppMethodBeat.o(47733);
      return null;
    }
    if (bu.isNullOrNil(paramString))
    {
      ae.e("MicroMsg.WxaUpdateableMsgService", "shareKey is null, return");
      AppMethodBeat.o(47733);
      return null;
    }
    int i = paramString.hashCode();
    c localc2 = new c();
    localc2.field_shareKeyHash = i;
    c localc1 = localc2;
    if (!locald.get(localc2, new String[] { "shareKeyHash" }))
    {
      ae.e("MicroMsg.WxaUpdateableMsgStorage", "WxaUpdateableMsg is null");
      localc1 = null;
    }
    if (localc1 == null)
    {
      ae.e("MicroMsg.WxaUpdateableMsgService", "shareKey:%s, shareKeyHash:%d, wxaUpdateableMsg is null", new Object[] { paramString, Integer.valueOf(paramString.hashCode()) });
      AppMethodBeat.o(47733);
      return null;
    }
    ae.d("MicroMsg.WxaUpdateableMsgService", "shareKey:%s, shareKeyHash:%d status:%s", new Object[] { paramString, Integer.valueOf(paramString.hashCode()), Integer.valueOf(localc1.field_btnState) });
    AppMethodBeat.o(47733);
    return localc1;
  }
  
  public final void CG(String paramString)
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(47737);
        ae.i("MicroMsg.WxaUpdateableMsgService", "removeOnUpdatbleMsgInfoChange token:%s", new Object[] { paramString });
        Object localObject = (List)lYP.get(paramString);
        if (localObject == null)
        {
          ae.w("MicroMsg.WxaUpdateableMsgService", "[removeOnUpdatbleMsgInfoChange]getUpdatableMsgWorkers is null, err");
          AppMethodBeat.o(47737);
          return;
        }
        localObject = ((List)localObject).iterator();
        if (((Iterator)localObject).hasNext())
        {
          a locala = (a)((Iterator)localObject).next();
          b localb = b.lYS;
          ae.d("MicroMsg.WxaUpdateableMsgService", "[removeWorker]getUpdatableMsgWorkerList size:%d", new Object[] { Integer.valueOf(localb.lYT.size()) });
          localb.lYT.remove(Integer.valueOf(locala.cmw.hashCode()));
          continue;
        }
        lYP.remove(paramString);
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
        if ((bu.isNullOrNil(paramString1)) || (bu.isNullOrNil(paramString2)) || (bu.isNullOrNil(paramString3)))
        {
          ae.e("MicroMsg.WxaUpdateableMsgService", "token appId or shareKey is null, return");
          AppMethodBeat.o(47736);
          return;
        }
        List localList = (List)lYP.get(paramString1);
        Object localObject = localList;
        if (localList == null)
        {
          ae.i("MicroMsg.WxaUpdateableMsgService", "addOnUpdatbleMsgInfoChange token:%s", new Object[] { paramString1 });
          localObject = new ArrayList();
          lYP.put(paramString1, localObject);
        }
        ae.i("MicroMsg.WxaUpdateableMsgService", "addOnUpdatbleMsgInfoChange shareKeyHash:%d", new Object[] { Integer.valueOf(paramString3.hashCode()) });
        ae.d("MicroMsg.WxaUpdateableMsgService", "addOnUpdatbleMsgInfoChange shareKey:%s", new Object[] { paramString3 });
        paramString1 = new a((byte)0);
        paramString1.appId = paramString2;
        paramString1.cmw = paramString3;
        paramString1.lYQ = paramInt;
        paramString1.lYR = parama;
        if ((bu.isNullOrNil(paramString1.appId)) || (bu.isNullOrNil(paramString1.cmw)))
        {
          ae.w("MicroMsg.WxaUpdateableMsgService", "appId or shareKey is null, return");
          ((List)localObject).add(paramString1);
          AppMethodBeat.o(47736);
          continue;
        }
        paramString2 = b.lYS;
      }
      finally {}
      ae.d("MicroMsg.WxaUpdateableMsgService", "[addWorker]getUpdatableMsgWorkerList size:%d", new Object[] { Integer.valueOf(paramString2.lYT.size()) });
      paramString2.lYT.put(Integer.valueOf(paramString1.cmw.hashCode()), paramString1);
    }
  }
  
  public final boolean a(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(47735);
    d locald = j.aZr();
    if (locald == null)
    {
      ae.e("MicroMsg.WxaUpdateableMsgService", "wxaUpdateableMsgStorage is null, err");
      AppMethodBeat.o(47735);
      return false;
    }
    boolean bool;
    if (bu.isNullOrNil(paramString1))
    {
      ae.e("MicroMsg.WxaUpdateableMsgStorage", "shareKey is null, err");
      bool = false;
    }
    for (;;)
    {
      ae.d("MicroMsg.WxaUpdateableMsgService", "shareKey:%s, shareKeyHash:%d, content:%s contentColor:%s isOk:%b", new Object[] { paramString1, Integer.valueOf(paramString1.hashCode()), paramString2, paramString3, Boolean.valueOf(bool) });
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
  
  public final void aDZ()
  {
    AppMethodBeat.i(47738);
    ae.i("MicroMsg.WxaUpdateableMsgService", "startUpdatbleMsgInfoChange");
    b.lYS.start();
    AppMethodBeat.o(47738);
  }
  
  public final void aEa()
  {
    AppMethodBeat.i(47739);
    ae.i("MicroMsg.WxaUpdateableMsgService", "stopOnUpdatbleMsgInfoChange");
    b.lYS.stop();
    AppMethodBeat.o(47739);
  }
  
  public final boolean ak(String paramString, int paramInt)
  {
    AppMethodBeat.i(47734);
    d locald = j.aZr();
    if (locald == null)
    {
      ae.e("MicroMsg.WxaUpdateableMsgService", "wxaUpdateableMsgStorage is null, err");
      AppMethodBeat.o(47734);
      return false;
    }
    boolean bool;
    if (bu.isNullOrNil(paramString))
    {
      ae.e("MicroMsg.WxaUpdateableMsgStorage", "shareKey is null, err");
      bool = false;
    }
    for (;;)
    {
      ae.d("MicroMsg.WxaUpdateableMsgService", "shareKey:%s, shareKeyHash:%d, btnState:%d isOk:%b", new Object[] { paramString, Integer.valueOf(paramString.hashCode()), Integer.valueOf(paramInt), Boolean.valueOf(bool) });
      if (bool) {
        lYO.get(paramString);
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
    public String cmw;
    public int lYQ;
    public m.a lYR;
    public long lastUpdateTime;
    
    private long btK()
    {
      AppMethodBeat.i(47719);
      long l = System.currentTimeMillis() - this.lastUpdateTime;
      ae.d("MicroMsg.WxaUpdateableMsgService", "consumeTime:%d", new Object[] { Long.valueOf(l) });
      AppMethodBeat.o(47719);
      return l;
    }
    
    public final boolean btJ()
    {
      AppMethodBeat.i(47718);
      if (this.lYQ < 0)
      {
        AppMethodBeat.o(47718);
        return false;
      }
      if (this.lYQ == 0)
      {
        if (btK() > 10000L)
        {
          AppMethodBeat.o(47718);
          return true;
        }
        AppMethodBeat.o(47718);
        return false;
      }
      if (btK() > this.lYQ * 1000L)
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
    private AtomicBoolean dfY;
    Map<Integer, g.a> lYT;
    private Runnable lYU;
    
    static
    {
      AppMethodBeat.i(47732);
      lYS = new b("INSTANCE");
      lYV = new b[] { lYS };
      AppMethodBeat.o(47732);
    }
    
    private b()
    {
      AppMethodBeat.i(47724);
      this.lYT = new ConcurrentHashMap();
      this.dfY = new AtomicBoolean(true);
      this.lYU = new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(47720);
          LinkedList localLinkedList = new LinkedList();
          Object localObject1 = g.b.a(g.b.this).values().iterator();
          while (((Iterator)localObject1).hasNext())
          {
            localObject2 = (g.a)((Iterator)localObject1).next();
            if (((g.a)localObject2).btJ())
            {
              localObject3 = new dep();
              ((dep)localObject3).HLO = ((g.a)localObject2).cmw;
              ((dep)localObject3).dwb = ((g.a)localObject2).appId;
              localLinkedList.add(localObject3);
            }
          }
          localObject1 = g.b.this;
          if (localLinkedList.size() <= 0)
          {
            ae.d("MicroMsg.WxaUpdateableMsgService", "shareKeyInfoList is null, return");
            ((g.b)localObject1).btL();
            AppMethodBeat.o(47720);
            return;
          }
          ae.d("MicroMsg.WxaUpdateableMsgService", "getUpdateableMsg shareKeyInfoList.size:%d", new Object[] { Integer.valueOf(localLinkedList.size()) });
          Object localObject2 = new b.a();
          ((b.a)localObject2).funcId = 2954;
          ((b.a)localObject2).uri = "/cgi-bin/mmbiz-bin/wxabusiness/getupdatablemsginfo";
          Object localObject3 = new bkc();
          ((bkc)localObject3).GXt = localLinkedList;
          ((b.a)localObject2).hQF = ((a)localObject3);
          ((b.a)localObject2).hQG = new bkd();
          x.a(((b.a)localObject2).aDS(), new g.b.2((g.b)localObject1));
          AppMethodBeat.o(47720);
        }
      };
      AppMethodBeat.o(47724);
    }
    
    final void btL()
    {
      boolean bool1 = false;
      boolean bool2 = true;
      try
      {
        AppMethodBeat.i(47727);
        com.tencent.mm.kernel.g.ajU();
        ar.ay(this.lYU);
        if (this.dfY.get())
        {
          ae.d("MicroMsg.WxaUpdateableMsgService", "isPause, not sendUpdatableMsgRequest");
          AppMethodBeat.o(47727);
        }
        for (;;)
        {
          return;
          if (this.lYT.size() > 0) {
            break;
          }
          ae.d("MicroMsg.WxaUpdateableMsgService", "sGetUpdatableMsgWorkerMap is empty, not sendUpdatableMsgRequest");
          AppMethodBeat.o(47727);
        }
        l = 9223372036854775807L;
      }
      finally {}
      long l;
      Iterator localIterator = this.lYT.values().iterator();
      label101:
      g.a locala;
      if (localIterator.hasNext())
      {
        locala = (g.a)localIterator.next();
        if (locala.btJ())
        {
          l = 0L;
          bool1 = bool2;
        }
      }
      for (;;)
      {
        ae.d("MicroMsg.WxaUpdateableMsgService", "needUpdate:%b minDelayTime:%d", new Object[] { Boolean.valueOf(bool1), Long.valueOf(l) });
        if (!bool1)
        {
          AppMethodBeat.o(47727);
          break;
          if (locala.lYQ < 0) {
            break label101;
          }
          l = Math.min(locala.lYQ, l);
          bool1 = true;
          break label101;
        }
        com.tencent.mm.kernel.g.ajU().n(this.lYU, l * 1000L);
        AppMethodBeat.o(47727);
        break;
      }
    }
    
    public final void start()
    {
      try
      {
        AppMethodBeat.i(47725);
        this.dfY.set(false);
        btL();
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
        this.dfY.set(true);
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