package com.tencent.mm.plugin.appbrand.r.d;

import android.util.SparseArray;
import com.tencent.luggage.sdk.d.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.jsruntime.i;
import com.tencent.mm.plugin.appbrand.r;
import com.tencent.mm.plugin.appbrand.r.a;
import com.tencent.mm.plugin.appbrand.r.b;
import com.tencent.mm.plugin.appbrand.r.a.e.a;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;

public final class a
  extends com.tencent.mm.plugin.appbrand.r.a.e
{
  private r.b kWM;
  
  public a(e.a parama, com.tencent.mm.plugin.appbrand.q paramq)
  {
    super(parama, paramq);
  }
  
  public final void biJ()
  {
    AppMethodBeat.i(147405);
    this.kWM = new r.b()
    {
      public final void aND()
      {
        AppMethodBeat.i(147404);
        ad.i("MicroMsg.ProxyAppBrandServiceOnRuntimeReadyListener", "AppBrandRuntimeProfile| onRuntimeReady %s", new Object[] { a.this.chm.getAppId() });
        Object localObject2 = a.this.chm.getRuntime();
        if (localObject2 == null)
        {
          localObject1 = new IllegalStateException("onRuntimeReady runtime null");
          AppMethodBeat.o(147404);
          throw ((Throwable)localObject1);
        }
        Object localObject1 = (com.tencent.mm.plugin.appbrand.jsruntime.q)a.this.chm.aOf().P(com.tencent.mm.plugin.appbrand.jsruntime.q.class);
        localObject2 = new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(169499);
            if (this.iOB.isDestroyed())
            {
              AppMethodBeat.o(169499);
              return;
            }
            ad.i("MicroMsg.ProxyAppBrandServiceOnRuntimeReadyListener", "AppBrandRuntimeProfile| start prepareDataForNode %s", new Object[] { a.this.chm.getAppId() });
            HashMap localHashMap = new HashMap();
            Object localObject = ((c)this.iOB).cif;
            if (localObject == null) {
              ad.w("MicroMsg.ProxyAppBrandServiceOnRuntimeReadyListener", "fillPermissionBytes controller null");
            }
            for (;;)
            {
              localHashMap.put("state", com.tencent.mm.plugin.appbrand.b.b.iQK);
              localHashMap.put("wxaData", com.tencent.mm.plugin.appbrand.r.b.b.ah(this.iOB));
              a.this.Q(localHashMap);
              AppMethodBeat.o(169499);
              return;
              localObject = ((com.tencent.mm.plugin.appbrand.permission.e)localObject).blj();
              if (localObject == null)
              {
                ad.i("MicroMsg.ProxyAppBrandServiceOnRuntimeReadyListener", "fillPermissionBytes getPermissionBytes null");
              }
              else
              {
                localHashMap.put("fg", ((Vector)localObject).elementAt(0));
                localHashMap.put("bg", ((Vector)localObject).elementAt(1));
              }
            }
          }
        };
        if (((com.tencent.mm.plugin.appbrand.jsruntime.q)localObject1).Bq())
        {
          ((Runnable)localObject2).run();
          AppMethodBeat.o(147404);
          return;
        }
        ((com.tencent.mm.plugin.appbrand.jsruntime.q)localObject1).post((Runnable)localObject2);
        AppMethodBeat.o(147404);
      }
    };
    r localr = r.a.iHf;
    Object localObject1 = this.chm;
    r.b localb = this.kWM;
    int i = ((com.tencent.mm.plugin.appbrand.q)localObject1).aOd();
    ad.i("MicroMsg.AppBrandServiceOnRuntimeReadyListenerMgr", "addListener service:%d", new Object[] { Integer.valueOf(i) });
    try
    {
      List localList = (List)localr.iHd.get(i);
      localObject1 = localList;
      if (localList == null)
      {
        localObject1 = new ArrayList();
        localr.iHd.put(i, localObject1);
      }
      ((List)localObject1).add(localb);
      localr.e(i, (List)localObject1);
      return;
    }
    finally
    {
      AppMethodBeat.o(147405);
    }
  }
  
  public final int getType()
  {
    return 1;
  }
  
  public final void removeListener()
  {
    AppMethodBeat.i(147406);
    r localr = r.a.iHf;
    Object localObject2 = this.chm;
    r.b localb = this.kWM;
    int i = ((com.tencent.mm.plugin.appbrand.q)localObject2).aOd();
    ad.i("MicroMsg.AppBrandServiceOnRuntimeReadyListenerMgr", "removeListener service:%d", new Object[] { Integer.valueOf(i) });
    try
    {
      localObject2 = (List)localr.iHd.get(i);
      if (localObject2 == null) {
        return;
      }
      ((List)localObject2).remove(localb);
      if (((List)localObject2).isEmpty()) {
        localr.iHd.remove(i);
      }
      return;
    }
    finally
    {
      AppMethodBeat.o(147406);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.r.d.a
 * JD-Core Version:    0.7.0.1
 */