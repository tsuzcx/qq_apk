package com.tencent.mm.plugin.appbrand.message;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.b.e;
import com.tencent.mm.an.aa;
import com.tencent.mm.an.aa.a;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.d.c;
import com.tencent.mm.an.q;
import com.tencent.mm.cd.a;
import com.tencent.mm.kernel.h;
import com.tencent.mm.modelappbrand.m.a;
import com.tencent.mm.protocal.protobuf.ceb;
import com.tencent.mm.protocal.protobuf.cec;
import com.tencent.mm.protocal.protobuf.ehu;
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
  implements com.tencent.mm.modelappbrand.m
{
  private static Map<String, Object> qhe;
  private static Map<String, List<a>> qhf;
  
  static
  {
    AppMethodBeat.i(47740);
    qhe = new HashMap();
    qhf = new HashMap();
    AppMethodBeat.o(47740);
  }
  
  public final com.tencent.mm.aj.b.d SJ(String paramString)
  {
    AppMethodBeat.i(47733);
    e locale = com.tencent.mm.plugin.appbrand.app.m.bFM();
    if (locale == null)
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
    com.tencent.mm.aj.b.d locald2 = new com.tencent.mm.aj.b.d();
    locald2.field_shareKeyHash = i;
    com.tencent.mm.aj.b.d locald1 = locald2;
    if (!locale.get(locald2, new String[] { "shareKeyHash" }))
    {
      Log.e("MicroMsg.WxaUpdateableMsgStorage", "WxaUpdateableMsg is null");
      locald1 = null;
    }
    if (locald1 == null)
    {
      Log.e("MicroMsg.WxaUpdateableMsgService", "shareKey:%s, shareKeyHash:%d, wxaUpdateableMsg is null", new Object[] { paramString, Integer.valueOf(paramString.hashCode()) });
      AppMethodBeat.o(47733);
      return null;
    }
    Log.d("MicroMsg.WxaUpdateableMsgService", "shareKey:%s, shareKeyHash:%d status:%s", new Object[] { paramString, Integer.valueOf(paramString.hashCode()), Integer.valueOf(locald1.field_btnState) });
    AppMethodBeat.o(47733);
    return locald1;
  }
  
  public final void SK(String paramString)
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(47737);
        Log.i("MicroMsg.WxaUpdateableMsgService", "removeOnUpdatbleMsgInfoChange token:%s", new Object[] { paramString });
        Object localObject = (List)qhf.get(paramString);
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
          b localb = b.qhi;
          Log.d("MicroMsg.WxaUpdateableMsgService", "[removeWorker]getUpdatableMsgWorkerList size:%d", new Object[] { Integer.valueOf(localb.qhj.size()) });
          localb.qhj.remove(Integer.valueOf(locala.cwU.hashCode()));
          continue;
        }
        qhf.remove(paramString);
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
        List localList = (List)qhf.get(paramString1);
        Object localObject = localList;
        if (localList == null)
        {
          Log.i("MicroMsg.WxaUpdateableMsgService", "addOnUpdatbleMsgInfoChange token:%s", new Object[] { paramString1 });
          localObject = new ArrayList();
          qhf.put(paramString1, localObject);
        }
        Log.i("MicroMsg.WxaUpdateableMsgService", "addOnUpdatbleMsgInfoChange shareKeyHash:%d", new Object[] { Integer.valueOf(paramString3.hashCode()) });
        Log.d("MicroMsg.WxaUpdateableMsgService", "addOnUpdatbleMsgInfoChange shareKey:%s", new Object[] { paramString3 });
        paramString1 = new a((byte)0);
        paramString1.appId = paramString2;
        paramString1.cwU = paramString3;
        paramString1.qhg = paramInt;
        paramString1.qhh = parama;
        if ((Util.isNullOrNil(paramString1.appId)) || (Util.isNullOrNil(paramString1.cwU)))
        {
          Log.w("MicroMsg.WxaUpdateableMsgService", "appId or shareKey is null, return");
          ((List)localObject).add(paramString1);
          AppMethodBeat.o(47736);
          continue;
        }
        paramString2 = b.qhi;
      }
      finally {}
      Log.d("MicroMsg.WxaUpdateableMsgService", "[addWorker]getUpdatableMsgWorkerList size:%d", new Object[] { Integer.valueOf(paramString2.qhj.size()) });
      paramString2.qhj.put(Integer.valueOf(paramString1.cwU.hashCode()), paramString1);
    }
  }
  
  public final boolean a(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(47735);
    e locale = com.tencent.mm.plugin.appbrand.app.m.bFM();
    if (locale == null)
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
      com.tencent.mm.aj.b.d locald = new com.tencent.mm.aj.b.d();
      locald.field_shareKeyHash = paramString1.hashCode();
      bool = locale.get(locald, new String[0]);
      locald.field_updatePeroid = paramInt1;
      locald.field_msgState = paramInt2;
      locald.field_content = paramString2;
      locald.field_contentColor = paramString3;
      if (bool) {
        bool = locale.update(locald, new String[0]);
      } else {
        bool = locale.insert(locald);
      }
    }
  }
  
  public final boolean aG(String paramString, int paramInt)
  {
    AppMethodBeat.i(47734);
    e locale = com.tencent.mm.plugin.appbrand.app.m.bFM();
    if (locale == null)
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
        qhe.get(paramString);
      }
      AppMethodBeat.o(47734);
      return bool;
      com.tencent.mm.aj.b.d locald = new com.tencent.mm.aj.b.d();
      locald.field_shareKeyHash = paramString.hashCode();
      bool = locale.get(locald, new String[0]);
      locald.field_btnState = paramInt;
      if (bool) {
        bool = locale.update(locald, new String[0]);
      } else {
        bool = locale.insert(locald);
      }
    }
  }
  
  public final void bgV()
  {
    AppMethodBeat.i(47738);
    Log.i("MicroMsg.WxaUpdateableMsgService", "startUpdatbleMsgInfoChange");
    b.qhi.start();
    AppMethodBeat.o(47738);
  }
  
  public final void bgW()
  {
    AppMethodBeat.i(47739);
    Log.i("MicroMsg.WxaUpdateableMsgService", "stopOnUpdatbleMsgInfoChange");
    b.qhi.stop();
    AppMethodBeat.o(47739);
  }
  
  static final class a
  {
    public String appId;
    public String cwU;
    public long lastUpdateTime;
    public int qhg;
    public m.a qhh;
    
    private long cbC()
    {
      AppMethodBeat.i(47719);
      long l = System.currentTimeMillis() - this.lastUpdateTime;
      Log.d("MicroMsg.WxaUpdateableMsgService", "consumeTime:%d", new Object[] { Long.valueOf(l) });
      AppMethodBeat.o(47719);
      return l;
    }
    
    public final boolean cbB()
    {
      AppMethodBeat.i(47718);
      if (this.qhg < 0)
      {
        AppMethodBeat.o(47718);
        return false;
      }
      if (this.qhg == 0)
      {
        if (cbC() > 10000L)
        {
          AppMethodBeat.o(47718);
          return true;
        }
        AppMethodBeat.o(47718);
        return false;
      }
      if (cbC() > this.qhg * 1000L)
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
    private AtomicBoolean fpU;
    Map<Integer, g.a> qhj;
    private Runnable qhk;
    
    static
    {
      AppMethodBeat.i(47732);
      qhi = new b("INSTANCE");
      qhl = new b[] { qhi };
      AppMethodBeat.o(47732);
    }
    
    private b()
    {
      AppMethodBeat.i(47724);
      this.qhj = new ConcurrentHashMap();
      this.fpU = new AtomicBoolean(true);
      this.qhk = new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(47720);
          LinkedList localLinkedList = new LinkedList();
          Object localObject1 = g.b.a(g.b.this).values().iterator();
          while (((Iterator)localObject1).hasNext())
          {
            localObject2 = (g.a)((Iterator)localObject1).next();
            if (((g.a)localObject2).cbB())
            {
              localObject3 = new ehu();
              ((ehu)localObject3).UjS = ((g.a)localObject2).cwU;
              ((ehu)localObject3).appid = ((g.a)localObject2).appId;
              localLinkedList.add(localObject3);
            }
          }
          localObject1 = g.b.this;
          if (localLinkedList.size() <= 0)
          {
            Log.d("MicroMsg.WxaUpdateableMsgService", "shareKeyInfoList is null, return");
            ((g.b)localObject1).cbD();
            AppMethodBeat.o(47720);
            return;
          }
          Log.d("MicroMsg.WxaUpdateableMsgService", "getUpdateableMsg shareKeyInfoList.size:%d", new Object[] { Integer.valueOf(localLinkedList.size()) });
          Object localObject2 = new d.a();
          ((d.a)localObject2).funcId = 2954;
          ((d.a)localObject2).uri = "/cgi-bin/mmbiz-bin/wxabusiness/getupdatablemsginfo";
          Object localObject3 = new ceb();
          ((ceb)localObject3).TlH = localLinkedList;
          ((d.a)localObject2).lBU = ((a)localObject3);
          ((d.a)localObject2).lBV = new cec();
          aa.a(((d.a)localObject2).bgN(), new g.b.2((g.b)localObject1));
          AppMethodBeat.o(47720);
        }
      };
      AppMethodBeat.o(47724);
    }
    
    final void cbD()
    {
      boolean bool1 = false;
      boolean bool2 = true;
      try
      {
        AppMethodBeat.i(47727);
        h.aHJ();
        MMHandlerThread.removeRunnable(this.qhk);
        if (this.fpU.get())
        {
          Log.d("MicroMsg.WxaUpdateableMsgService", "isPause, not sendUpdatableMsgRequest");
          AppMethodBeat.o(47727);
        }
        for (;;)
        {
          return;
          if (this.qhj.size() > 0) {
            break;
          }
          Log.d("MicroMsg.WxaUpdateableMsgService", "sGetUpdatableMsgWorkerMap is empty, not sendUpdatableMsgRequest");
          AppMethodBeat.o(47727);
        }
        l = 9223372036854775807L;
      }
      finally {}
      long l;
      Iterator localIterator = this.qhj.values().iterator();
      label101:
      g.a locala;
      if (localIterator.hasNext())
      {
        locala = (g.a)localIterator.next();
        if (locala.cbB())
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
          if (locala.qhg < 0) {
            break label101;
          }
          l = Math.min(locala.qhg, l);
          bool1 = true;
          break label101;
        }
        h.aHJ().postToWorkerDelayed(this.qhk, l * 1000L);
        AppMethodBeat.o(47727);
        break;
      }
    }
    
    public final void start()
    {
      try
      {
        AppMethodBeat.i(47725);
        this.fpU.set(false);
        cbD();
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
        this.fpU.set(true);
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