package com.tencent.mm.plugin.appbrand.message;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ag.a.c;
import com.tencent.mm.ak.aa;
import com.tencent.mm.ak.aa.a;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.ak.q;
import com.tencent.mm.bw.a;
import com.tencent.mm.modelappbrand.m;
import com.tencent.mm.modelappbrand.m.a;
import com.tencent.mm.plugin.appbrand.app.n;
import com.tencent.mm.protocal.protobuf.bwl;
import com.tencent.mm.protocal.protobuf.bwm;
import com.tencent.mm.protocal.protobuf.dxt;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
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
  private static Map<String, Object> ngu;
  private static Map<String, List<a>> ngv;
  
  static
  {
    AppMethodBeat.i(47740);
    ngu = new HashMap();
    ngv = new HashMap();
    AppMethodBeat.o(47740);
  }
  
  public final c Lq(String paramString)
  {
    AppMethodBeat.i(47733);
    com.tencent.mm.ag.a.d locald = n.buI();
    if (locald == null)
    {
      Log.e("MicroMsg.WxaUpdateableMsgService", "wxaUpdateableMsgStorage is null");
      AppMethodBeat.o(47733);
      return null;
    }
    if (Util.isNullOrNil(paramString))
    {
      Log.e("MicroMsg.WxaUpdateableMsgService", "shareKey is null, return");
      AppMethodBeat.o(47733);
      return null;
    }
    int i = paramString.hashCode();
    c localc2 = new c();
    localc2.field_shareKeyHash = i;
    c localc1 = localc2;
    if (!locald.get(localc2, new String[] { "shareKeyHash" }))
    {
      Log.e("MicroMsg.WxaUpdateableMsgStorage", "WxaUpdateableMsg is null");
      localc1 = null;
    }
    if (localc1 == null)
    {
      Log.e("MicroMsg.WxaUpdateableMsgService", "shareKey:%s, shareKeyHash:%d, wxaUpdateableMsg is null", new Object[] { paramString, Integer.valueOf(paramString.hashCode()) });
      AppMethodBeat.o(47733);
      return null;
    }
    Log.d("MicroMsg.WxaUpdateableMsgService", "shareKey:%s, shareKeyHash:%d status:%s", new Object[] { paramString, Integer.valueOf(paramString.hashCode()), Integer.valueOf(localc1.field_btnState) });
    AppMethodBeat.o(47733);
    return localc1;
  }
  
  public final void Lr(String paramString)
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(47737);
        Log.i("MicroMsg.WxaUpdateableMsgService", "removeOnUpdatbleMsgInfoChange token:%s", new Object[] { paramString });
        Object localObject = (List)ngv.get(paramString);
        if (localObject == null)
        {
          Log.w("MicroMsg.WxaUpdateableMsgService", "[removeOnUpdatbleMsgInfoChange]getUpdatableMsgWorkers is null, err");
          AppMethodBeat.o(47737);
          return;
        }
        localObject = ((List)localObject).iterator();
        if (((Iterator)localObject).hasNext())
        {
          a locala = (a)((Iterator)localObject).next();
          b localb = b.ngy;
          Log.d("MicroMsg.WxaUpdateableMsgService", "[removeWorker]getUpdatableMsgWorkerList size:%d", new Object[] { Integer.valueOf(localb.ngz.size()) });
          localb.ngz.remove(Integer.valueOf(locala.cyr.hashCode()));
          continue;
        }
        ngv.remove(paramString);
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
        if ((Util.isNullOrNil(paramString1)) || (Util.isNullOrNil(paramString2)) || (Util.isNullOrNil(paramString3)))
        {
          Log.e("MicroMsg.WxaUpdateableMsgService", "token appId or shareKey is null, return");
          AppMethodBeat.o(47736);
          return;
        }
        List localList = (List)ngv.get(paramString1);
        Object localObject = localList;
        if (localList == null)
        {
          Log.i("MicroMsg.WxaUpdateableMsgService", "addOnUpdatbleMsgInfoChange token:%s", new Object[] { paramString1 });
          localObject = new ArrayList();
          ngv.put(paramString1, localObject);
        }
        Log.i("MicroMsg.WxaUpdateableMsgService", "addOnUpdatbleMsgInfoChange shareKeyHash:%d", new Object[] { Integer.valueOf(paramString3.hashCode()) });
        Log.d("MicroMsg.WxaUpdateableMsgService", "addOnUpdatbleMsgInfoChange shareKey:%s", new Object[] { paramString3 });
        paramString1 = new a((byte)0);
        paramString1.appId = paramString2;
        paramString1.cyr = paramString3;
        paramString1.ngw = paramInt;
        paramString1.ngx = parama;
        if ((Util.isNullOrNil(paramString1.appId)) || (Util.isNullOrNil(paramString1.cyr)))
        {
          Log.w("MicroMsg.WxaUpdateableMsgService", "appId or shareKey is null, return");
          ((List)localObject).add(paramString1);
          AppMethodBeat.o(47736);
          continue;
        }
        paramString2 = b.ngy;
      }
      finally {}
      Log.d("MicroMsg.WxaUpdateableMsgService", "[addWorker]getUpdatableMsgWorkerList size:%d", new Object[] { Integer.valueOf(paramString2.ngz.size()) });
      paramString2.ngz.put(Integer.valueOf(paramString1.cyr.hashCode()), paramString1);
    }
  }
  
  public final boolean a(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(47735);
    com.tencent.mm.ag.a.d locald = n.buI();
    if (locald == null)
    {
      Log.e("MicroMsg.WxaUpdateableMsgService", "wxaUpdateableMsgStorage is null, err");
      AppMethodBeat.o(47735);
      return false;
    }
    boolean bool;
    if (Util.isNullOrNil(paramString1))
    {
      Log.e("MicroMsg.WxaUpdateableMsgStorage", "shareKey is null, err");
      bool = false;
    }
    for (;;)
    {
      Log.d("MicroMsg.WxaUpdateableMsgService", "shareKey:%s, shareKeyHash:%d, content:%s contentColor:%s isOk:%b", new Object[] { paramString1, Integer.valueOf(paramString1.hashCode()), paramString2, paramString3, Boolean.valueOf(bool) });
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
  
  public final void aXM()
  {
    AppMethodBeat.i(47738);
    Log.i("MicroMsg.WxaUpdateableMsgService", "startUpdatbleMsgInfoChange");
    b.ngy.start();
    AppMethodBeat.o(47738);
  }
  
  public final void aXN()
  {
    AppMethodBeat.i(47739);
    Log.i("MicroMsg.WxaUpdateableMsgService", "stopOnUpdatbleMsgInfoChange");
    b.ngy.stop();
    AppMethodBeat.o(47739);
  }
  
  public final boolean ao(String paramString, int paramInt)
  {
    AppMethodBeat.i(47734);
    com.tencent.mm.ag.a.d locald = n.buI();
    if (locald == null)
    {
      Log.e("MicroMsg.WxaUpdateableMsgService", "wxaUpdateableMsgStorage is null, err");
      AppMethodBeat.o(47734);
      return false;
    }
    boolean bool;
    if (Util.isNullOrNil(paramString))
    {
      Log.e("MicroMsg.WxaUpdateableMsgStorage", "shareKey is null, err");
      bool = false;
    }
    for (;;)
    {
      Log.d("MicroMsg.WxaUpdateableMsgService", "shareKey:%s, shareKeyHash:%d, btnState:%d isOk:%b", new Object[] { paramString, Integer.valueOf(paramString.hashCode()), Integer.valueOf(paramInt), Boolean.valueOf(bool) });
      if (bool) {
        ngu.get(paramString);
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
    public String cyr;
    public long lastUpdateTime;
    public int ngw;
    public m.a ngx;
    
    private long bPl()
    {
      AppMethodBeat.i(47719);
      long l = System.currentTimeMillis() - this.lastUpdateTime;
      Log.d("MicroMsg.WxaUpdateableMsgService", "consumeTime:%d", new Object[] { Long.valueOf(l) });
      AppMethodBeat.o(47719);
      return l;
    }
    
    public final boolean bPk()
    {
      AppMethodBeat.i(47718);
      if (this.ngw < 0)
      {
        AppMethodBeat.o(47718);
        return false;
      }
      if (this.ngw == 0)
      {
        if (bPl() > 10000L)
        {
          AppMethodBeat.o(47718);
          return true;
        }
        AppMethodBeat.o(47718);
        return false;
      }
      if (bPl() > this.ngw * 1000L)
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
    private AtomicBoolean dxi;
    private Runnable ngA;
    Map<Integer, g.a> ngz;
    
    static
    {
      AppMethodBeat.i(47732);
      ngy = new b("INSTANCE");
      ngB = new b[] { ngy };
      AppMethodBeat.o(47732);
    }
    
    private b()
    {
      AppMethodBeat.i(47724);
      this.ngz = new ConcurrentHashMap();
      this.dxi = new AtomicBoolean(true);
      this.ngA = new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(47720);
          LinkedList localLinkedList = new LinkedList();
          Object localObject1 = g.b.a(g.b.this).values().iterator();
          while (((Iterator)localObject1).hasNext())
          {
            localObject2 = (g.a)((Iterator)localObject1).next();
            if (((g.a)localObject2).bPk())
            {
              localObject3 = new dxt();
              ((dxt)localObject3).MXx = ((g.a)localObject2).cyr;
              ((dxt)localObject3).dNI = ((g.a)localObject2).appId;
              localLinkedList.add(localObject3);
            }
          }
          localObject1 = g.b.this;
          if (localLinkedList.size() <= 0)
          {
            Log.d("MicroMsg.WxaUpdateableMsgService", "shareKeyInfoList is null, return");
            ((g.b)localObject1).bPm();
            AppMethodBeat.o(47720);
            return;
          }
          Log.d("MicroMsg.WxaUpdateableMsgService", "getUpdateableMsg shareKeyInfoList.size:%d", new Object[] { Integer.valueOf(localLinkedList.size()) });
          Object localObject2 = new d.a();
          ((d.a)localObject2).funcId = 2954;
          ((d.a)localObject2).uri = "/cgi-bin/mmbiz-bin/wxabusiness/getupdatablemsginfo";
          Object localObject3 = new bwl();
          ((bwl)localObject3).Mci = localLinkedList;
          ((d.a)localObject2).iLN = ((a)localObject3);
          ((d.a)localObject2).iLO = new bwm();
          aa.a(((d.a)localObject2).aXF(), new g.b.2((g.b)localObject1));
          AppMethodBeat.o(47720);
        }
      };
      AppMethodBeat.o(47724);
    }
    
    final void bPm()
    {
      boolean bool1 = false;
      boolean bool2 = true;
      try
      {
        AppMethodBeat.i(47727);
        com.tencent.mm.kernel.g.aAk();
        MMHandlerThread.removeRunnable(this.ngA);
        if (this.dxi.get())
        {
          Log.d("MicroMsg.WxaUpdateableMsgService", "isPause, not sendUpdatableMsgRequest");
          AppMethodBeat.o(47727);
        }
        for (;;)
        {
          return;
          if (this.ngz.size() > 0) {
            break;
          }
          Log.d("MicroMsg.WxaUpdateableMsgService", "sGetUpdatableMsgWorkerMap is empty, not sendUpdatableMsgRequest");
          AppMethodBeat.o(47727);
        }
        l = 9223372036854775807L;
      }
      finally {}
      long l;
      Iterator localIterator = this.ngz.values().iterator();
      label101:
      g.a locala;
      if (localIterator.hasNext())
      {
        locala = (g.a)localIterator.next();
        if (locala.bPk())
        {
          l = 0L;
          bool1 = bool2;
        }
      }
      for (;;)
      {
        Log.d("MicroMsg.WxaUpdateableMsgService", "needUpdate:%b minDelayTime:%d", new Object[] { Boolean.valueOf(bool1), Long.valueOf(l) });
        if (!bool1)
        {
          AppMethodBeat.o(47727);
          break;
          if (locala.ngw < 0) {
            break label101;
          }
          l = Math.min(locala.ngw, l);
          bool1 = true;
          break label101;
        }
        com.tencent.mm.kernel.g.aAk().postToWorkerDelayed(this.ngA, l * 1000L);
        AppMethodBeat.o(47727);
        break;
      }
    }
    
    public final void start()
    {
      try
      {
        AppMethodBeat.i(47725);
        this.dxi.set(false);
        bPm();
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
        this.dxi.set(true);
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