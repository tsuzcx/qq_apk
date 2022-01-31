package com.tencent.mm.plugin.appbrand.l;

import com.tencent.mm.ae.a.b;
import com.tencent.mm.ae.a.c;
import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.w;
import com.tencent.mm.bv.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelappbrand.k;
import com.tencent.mm.modelappbrand.k.a;
import com.tencent.mm.protocal.c.ali;
import com.tencent.mm.protocal.c.alj;
import com.tencent.mm.protocal.c.brw;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;

public final class e
  implements k
{
  private static Map<String, Object> gPP = new HashMap();
  private static Map<String, List<e.a>> gPQ = new HashMap();
  
  public final void Jq()
  {
    y.i("MicroMsg.WxaUpdateableMsgService", "startUpdatbleMsgInfoChange");
    b.gPT.start();
  }
  
  public final void Jr()
  {
    y.i("MicroMsg.WxaUpdateableMsgService", "stopOnUpdatbleMsgInfoChange");
    b.gPT.stop();
  }
  
  public final boolean L(String paramString, int paramInt)
  {
    c localc = com.tencent.mm.plugin.appbrand.app.e.aaX();
    boolean bool;
    if (bk.bl(paramString))
    {
      y.e("MicroMsg.WxaUpdateableMsgStorage", "shareKey is null, err");
      bool = false;
    }
    for (;;)
    {
      y.d("MicroMsg.WxaUpdateableMsgService", "shareKey:%s, shareKeyHash:%d, btnState:%d isOk:%b", new Object[] { paramString, Integer.valueOf(paramString.hashCode()), Integer.valueOf(paramInt), Boolean.valueOf(bool) });
      if (bool) {
        gPP.get(paramString);
      }
      return bool;
      b localb = new b();
      localb.field_shareKeyHash = paramString.hashCode();
      bool = localc.b(localb, new String[0]);
      localb.field_btnState = paramInt;
      if (bool) {
        bool = localc.c(localb, new String[0]);
      } else {
        bool = localc.b(localb);
      }
    }
  }
  
  public final void a(String paramString1, String paramString2, String paramString3, int paramInt, k.a parama)
  {
    for (;;)
    {
      try
      {
        if ((bk.bl(paramString1)) || (bk.bl(paramString2)) || (bk.bl(paramString3)))
        {
          y.e("MicroMsg.WxaUpdateableMsgService", "token appId or shareKey is null, return");
          return;
        }
        List localList = (List)gPQ.get(paramString1);
        Object localObject = localList;
        if (localList == null)
        {
          y.i("MicroMsg.WxaUpdateableMsgService", "addOnUpdatbleMsgInfoChange token:%s", new Object[] { paramString1 });
          localObject = new ArrayList();
          gPQ.put(paramString1, localObject);
        }
        y.i("MicroMsg.WxaUpdateableMsgService", "addOnUpdatbleMsgInfoChange shareKeyHash:%d", new Object[] { Integer.valueOf(paramString3.hashCode()) });
        y.d("MicroMsg.WxaUpdateableMsgService", "addOnUpdatbleMsgInfoChange shareKey:%s", new Object[] { paramString3 });
        paramString1 = new e.a((byte)0);
        paramString1.appId = paramString2;
        paramString1.dTX = paramString3;
        paramString1.gPR = paramInt;
        paramString1.gPS = parama;
        if ((bk.bl(paramString1.appId)) || (bk.bl(paramString1.dTX)))
        {
          y.w("MicroMsg.WxaUpdateableMsgService", "appId or shareKey is null, return");
          ((List)localObject).add(paramString1);
          continue;
        }
        paramString2 = b.gPT;
      }
      finally {}
      y.d("MicroMsg.WxaUpdateableMsgService", "[addWorker]getUpdatableMsgWorkerList size:%d", new Object[] { Integer.valueOf(paramString2.gPU.size()) });
      paramString2.gPU.put(Integer.valueOf(paramString1.dTX.hashCode()), paramString1);
    }
  }
  
  public final boolean a(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2)
  {
    c localc = com.tencent.mm.plugin.appbrand.app.e.aaX();
    boolean bool;
    if (bk.bl(paramString1))
    {
      y.e("MicroMsg.WxaUpdateableMsgStorage", "shareKey is null, err");
      bool = false;
    }
    for (;;)
    {
      y.d("MicroMsg.WxaUpdateableMsgService", "shareKey:%s, shareKeyHash:%d, content:%s contentColor:%s isOk:%b", new Object[] { paramString1, Integer.valueOf(paramString1.hashCode()), paramString2, paramString3, Boolean.valueOf(bool) });
      return bool;
      b localb = new b();
      localb.field_shareKeyHash = paramString1.hashCode();
      bool = localc.b(localb, new String[0]);
      localb.field_updatePeroid = paramInt1;
      localb.field_msgState = paramInt2;
      localb.field_content = paramString2;
      localb.field_contentColor = paramString3;
      if (bool) {
        bool = localc.c(localb, new String[0]);
      } else {
        bool = localc.b(localb);
      }
    }
  }
  
  public final b jv(String paramString)
  {
    c localc = com.tencent.mm.plugin.appbrand.app.e.aaX();
    int i = paramString.hashCode();
    b localb2 = new b();
    localb2.field_shareKeyHash = i;
    b localb1 = localb2;
    if (!localc.b(localb2, new String[] { "shareKeyHash" }))
    {
      y.e("MicroMsg.WxaUpdateableMsgStorage", "WxaUpdateableMsg is null");
      localb1 = null;
    }
    if (localb1 == null)
    {
      y.e("MicroMsg.WxaUpdateableMsgService", "shareKey:%s, shareKeyHash:%d, wxaUpdateableMsg is null", new Object[] { paramString, Integer.valueOf(paramString.hashCode()) });
      return null;
    }
    y.d("MicroMsg.WxaUpdateableMsgService", "shareKey:%s, shareKeyHash:%d status:%s", new Object[] { paramString, Integer.valueOf(paramString.hashCode()), Integer.valueOf(localb1.field_btnState) });
    return localb1;
  }
  
  public final void jw(String paramString)
  {
    for (;;)
    {
      try
      {
        y.i("MicroMsg.WxaUpdateableMsgService", "removeOnUpdatbleMsgInfoChange token:%s", new Object[] { paramString });
        Object localObject = (List)gPQ.get(paramString);
        if (localObject == null)
        {
          y.w("MicroMsg.WxaUpdateableMsgService", "[removeOnUpdatbleMsgInfoChange]getUpdatableMsgWorkers is null, err");
          return;
        }
        localObject = ((List)localObject).iterator();
        if (((Iterator)localObject).hasNext())
        {
          e.a locala = (e.a)((Iterator)localObject).next();
          b localb = b.gPT;
          y.d("MicroMsg.WxaUpdateableMsgService", "[removeWorker]getUpdatableMsgWorkerList size:%d", new Object[] { Integer.valueOf(localb.gPU.size()) });
          localb.gPU.remove(Integer.valueOf(locala.dTX.hashCode()));
        }
        else
        {
          gPQ.remove(paramString);
        }
      }
      finally {}
    }
  }
  
  public static enum b
  {
    Map<Integer, e.a> gPU = new ConcurrentHashMap();
    private AtomicBoolean gPV = new AtomicBoolean(true);
    private Runnable gPW = new Runnable()
    {
      public final void run()
      {
        LinkedList localLinkedList = new LinkedList();
        Object localObject1 = e.b.a(e.b.this).values().iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (e.a)((Iterator)localObject1).next();
          if (((e.a)localObject2).amx())
          {
            localObject3 = new brw();
            ((brw)localObject3).tIu = ((e.a)localObject2).dTX;
            ((brw)localObject3).bOL = ((e.a)localObject2).appId;
            localLinkedList.add(localObject3);
          }
        }
        localObject1 = e.b.this;
        if (localLinkedList.size() <= 0)
        {
          y.d("MicroMsg.WxaUpdateableMsgService", "shareKeyInfoList is null, return");
          ((e.b)localObject1).amz();
          return;
        }
        y.d("MicroMsg.WxaUpdateableMsgService", "getUpdateableMsg shareKeyInfoList.size:%d", new Object[] { Integer.valueOf(localLinkedList.size()) });
        Object localObject2 = new b.a();
        ((b.a)localObject2).ecG = 2954;
        ((b.a)localObject2).uri = "/cgi-bin/mmbiz-bin/wxabusiness/getupdatablemsginfo";
        Object localObject3 = new ali();
        ((ali)localObject3).thn = localLinkedList;
        ((b.a)localObject2).ecH = ((a)localObject3);
        ((b.a)localObject2).ecI = new alj();
        w.a(((b.a)localObject2).Kt(), new e.b.2((e.b)localObject1));
      }
    };
    
    private b() {}
    
    final void amz()
    {
      boolean bool1 = false;
      boolean bool2 = true;
      try
      {
        g.DS();
        ai.S(this.gPW);
        if (this.gPV.get()) {
          y.d("MicroMsg.WxaUpdateableMsgService", "isPause, not sendUpdatableMsgRequest");
        }
        for (;;)
        {
          return;
          if (this.gPU.size() > 0) {
            break;
          }
          y.d("MicroMsg.WxaUpdateableMsgService", "sGetUpdatableMsgWorkerMap is empty, not sendUpdatableMsgRequest");
        }
        l = 9223372036854775807L;
      }
      finally {}
      long l;
      Iterator localIterator = this.gPU.values().iterator();
      label86:
      e.a locala;
      if (localIterator.hasNext())
      {
        locala = (e.a)localIterator.next();
        if (locala.amx())
        {
          l = 0L;
          bool1 = bool2;
        }
      }
      for (;;)
      {
        y.d("MicroMsg.WxaUpdateableMsgService", "needUpdate:%b minDelayTime:%d", new Object[] { Boolean.valueOf(bool1), Long.valueOf(l) });
        if (!bool1) {
          break;
        }
        g.DS().k(this.gPW, l * 1000L);
        break;
        if (locala.gPR < 0) {
          break label86;
        }
        l = Math.min(locala.gPR, l);
        bool1 = true;
        break label86;
      }
    }
    
    public final void start()
    {
      try
      {
        this.gPV.set(false);
        amz();
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
        this.gPV.set(true);
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
 * Qualified Name:     com.tencent.mm.plugin.appbrand.l.e
 * JD-Core Version:    0.7.0.1
 */