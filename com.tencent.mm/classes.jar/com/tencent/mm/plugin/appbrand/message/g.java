package com.tencent.mm.plugin.appbrand.message;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.p;
import com.tencent.mm.am.z;
import com.tencent.mm.am.z.a;
import com.tencent.mm.bx.a;
import com.tencent.mm.kernel.h;
import com.tencent.mm.message.c.d;
import com.tencent.mm.message.c.e;
import com.tencent.mm.modelappbrand.m;
import com.tencent.mm.modelappbrand.m.a;
import com.tencent.mm.plugin.appbrand.app.n;
import com.tencent.mm.protocal.protobuf.cud;
import com.tencent.mm.protocal.protobuf.cue;
import com.tencent.mm.protocal.protobuf.fbu;
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
  private static Map<String, Object> tlP;
  private static Map<String, List<a>> tlQ;
  
  static
  {
    AppMethodBeat.i(47740);
    tlP = new HashMap();
    tlQ = new HashMap();
    AppMethodBeat.o(47740);
  }
  
  public final d KL(String paramString)
  {
    AppMethodBeat.i(47733);
    e locale = n.cfj();
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
    d locald2 = new d();
    locald2.field_shareKeyHash = i;
    d locald1 = locald2;
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
  
  public final void KM(String paramString)
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(47737);
        Log.i("MicroMsg.WxaUpdateableMsgService", "removeOnUpdatbleMsgInfoChange token:%s", new Object[] { paramString });
        Object localObject = (List)tlQ.get(paramString);
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
          b localb = b.tlT;
          Log.d("MicroMsg.WxaUpdateableMsgService", "[removeWorker]getUpdatableMsgWorkerList size:%d", new Object[] { Integer.valueOf(localb.tlU.size()) });
          localb.tlU.remove(Integer.valueOf(locala.eoU.hashCode()));
          continue;
        }
        tlQ.remove(paramString);
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
        List localList = (List)tlQ.get(paramString1);
        Object localObject = localList;
        if (localList == null)
        {
          Log.i("MicroMsg.WxaUpdateableMsgService", "addOnUpdatbleMsgInfoChange token:%s", new Object[] { paramString1 });
          localObject = new ArrayList();
          tlQ.put(paramString1, localObject);
        }
        Log.i("MicroMsg.WxaUpdateableMsgService", "addOnUpdatbleMsgInfoChange shareKeyHash:%d", new Object[] { Integer.valueOf(paramString3.hashCode()) });
        Log.d("MicroMsg.WxaUpdateableMsgService", "addOnUpdatbleMsgInfoChange shareKey:%s", new Object[] { paramString3 });
        paramString1 = new a((byte)0);
        paramString1.appId = paramString2;
        paramString1.eoU = paramString3;
        paramString1.tlR = paramInt;
        paramString1.tlS = parama;
        if ((Util.isNullOrNil(paramString1.appId)) || (Util.isNullOrNil(paramString1.eoU)))
        {
          Log.w("MicroMsg.WxaUpdateableMsgService", "appId or shareKey is null, return");
          ((List)localObject).add(paramString1);
          AppMethodBeat.o(47736);
          continue;
        }
        paramString2 = b.tlT;
      }
      finally {}
      Log.d("MicroMsg.WxaUpdateableMsgService", "[addWorker]getUpdatableMsgWorkerList size:%d", new Object[] { Integer.valueOf(paramString2.tlU.size()) });
      paramString2.tlU.put(Integer.valueOf(paramString1.eoU.hashCode()), paramString1);
    }
  }
  
  public final boolean a(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(47735);
    e locale = n.cfj();
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
      d locald = new d();
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
  
  public final boolean aR(String paramString, int paramInt)
  {
    AppMethodBeat.i(47734);
    e locale = n.cfj();
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
        tlP.get(paramString);
      }
      AppMethodBeat.o(47734);
      return bool;
      d locald = new d();
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
  
  public final void bEM()
  {
    AppMethodBeat.i(47738);
    Log.i("MicroMsg.WxaUpdateableMsgService", "startUpdatbleMsgInfoChange");
    b.tlT.start();
    AppMethodBeat.o(47738);
  }
  
  public final void bEN()
  {
    AppMethodBeat.i(47739);
    Log.i("MicroMsg.WxaUpdateableMsgService", "stopOnUpdatbleMsgInfoChange");
    b.tlT.stop();
    AppMethodBeat.o(47739);
  }
  
  static final class a
  {
    public String appId;
    public String eoU;
    public long lastUpdateTime;
    public int tlR;
    public m.a tlS;
    
    private long cBV()
    {
      AppMethodBeat.i(47719);
      long l = System.currentTimeMillis() - this.lastUpdateTime;
      Log.d("MicroMsg.WxaUpdateableMsgService", "consumeTime:%d", new Object[] { Long.valueOf(l) });
      AppMethodBeat.o(47719);
      return l;
    }
    
    public final boolean cBU()
    {
      AppMethodBeat.i(47718);
      if (this.tlR < 0)
      {
        AppMethodBeat.o(47718);
        return false;
      }
      if (this.tlR == 0)
      {
        if (cBV() > 10000L)
        {
          AppMethodBeat.o(47718);
          return true;
        }
        AppMethodBeat.o(47718);
        return false;
      }
      if (cBV() > this.tlR * 1000L)
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
    private AtomicBoolean hud;
    Map<Integer, g.a> tlU;
    private Runnable tlV;
    
    static
    {
      AppMethodBeat.i(47732);
      tlT = new b("INSTANCE");
      tlW = new b[] { tlT };
      AppMethodBeat.o(47732);
    }
    
    private b()
    {
      AppMethodBeat.i(47724);
      this.tlU = new ConcurrentHashMap();
      this.hud = new AtomicBoolean(true);
      this.tlV = new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(47720);
          LinkedList localLinkedList = new LinkedList();
          Object localObject1 = g.b.a(g.b.this).values().iterator();
          while (((Iterator)localObject1).hasNext())
          {
            localObject2 = (g.a)((Iterator)localObject1).next();
            if (((g.a)localObject2).cBU())
            {
              localObject3 = new fbu();
              ((fbu)localObject3).abBw = ((g.a)localObject2).eoU;
              ((fbu)localObject3).appid = ((g.a)localObject2).appId;
              localLinkedList.add(localObject3);
            }
          }
          localObject1 = g.b.this;
          if (localLinkedList.size() <= 0)
          {
            Log.d("MicroMsg.WxaUpdateableMsgService", "shareKeyInfoList is null, return");
            ((g.b)localObject1).cBW();
            AppMethodBeat.o(47720);
            return;
          }
          Log.d("MicroMsg.WxaUpdateableMsgService", "getUpdateableMsg shareKeyInfoList.size:%d", new Object[] { Integer.valueOf(localLinkedList.size()) });
          Object localObject2 = new c.a();
          ((c.a)localObject2).funcId = 2954;
          ((c.a)localObject2).uri = "/cgi-bin/mmbiz-bin/wxabusiness/getupdatablemsginfo";
          Object localObject3 = new cud();
          ((cud)localObject3).aazD = localLinkedList;
          ((c.a)localObject2).otE = ((a)localObject3);
          ((c.a)localObject2).otF = new cue();
          z.a(((c.a)localObject2).bEF(), new g.b.2((g.b)localObject1));
          AppMethodBeat.o(47720);
        }
      };
      AppMethodBeat.o(47724);
    }
    
    final void cBW()
    {
      boolean bool1 = false;
      boolean bool2 = true;
      try
      {
        AppMethodBeat.i(47727);
        h.baH();
        MMHandlerThread.removeRunnable(this.tlV);
        if (this.hud.get())
        {
          Log.d("MicroMsg.WxaUpdateableMsgService", "isPause, not sendUpdatableMsgRequest");
          AppMethodBeat.o(47727);
        }
        for (;;)
        {
          return;
          if (this.tlU.size() > 0) {
            break;
          }
          Log.d("MicroMsg.WxaUpdateableMsgService", "sGetUpdatableMsgWorkerMap is empty, not sendUpdatableMsgRequest");
          AppMethodBeat.o(47727);
        }
        l = 9223372036854775807L;
      }
      finally {}
      long l;
      Iterator localIterator = this.tlU.values().iterator();
      label101:
      g.a locala;
      if (localIterator.hasNext())
      {
        locala = (g.a)localIterator.next();
        if (locala.cBU())
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
          if (locala.tlR < 0) {
            break label101;
          }
          l = Math.min(locala.tlR, l);
          bool1 = true;
          break label101;
        }
        h.baH().postToWorkerDelayed(this.tlV, l * 1000L);
        AppMethodBeat.o(47727);
        break;
      }
    }
    
    public final void start()
    {
      try
      {
        AppMethodBeat.i(47725);
        this.hud.set(false);
        cBW();
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
        this.hud.set(true);
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