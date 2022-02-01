package com.tencent.mm.plugin.appbrand.q.d;

import android.util.SparseArray;
import com.tencent.luggage.sdk.d.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.jsruntime.i;
import com.tencent.mm.plugin.appbrand.permission.d;
import com.tencent.mm.plugin.appbrand.q.a.e;
import com.tencent.mm.plugin.appbrand.q.a.e.a;
import com.tencent.mm.plugin.appbrand.r;
import com.tencent.mm.plugin.appbrand.r.a;
import com.tencent.mm.plugin.appbrand.r.b;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;

public final class a
  extends e
{
  private r.b lXU;
  
  public a(e.a parama, com.tencent.mm.plugin.appbrand.q paramq)
  {
    super(parama, paramq);
  }
  
  public final void btD()
  {
    AppMethodBeat.i(147405);
    this.lXU = new r.b()
    {
      public final void aXF()
      {
        AppMethodBeat.i(147404);
        ad.i("MicroMsg.ProxyAppBrandServiceOnRuntimeReadyListener", "AppBrandRuntimeProfile| onRuntimeReady %s", new Object[] { a.this.cox.getAppId() });
        Object localObject2 = a.this.cox.getRuntime();
        if (localObject2 == null)
        {
          localObject1 = new IllegalStateException("onRuntimeReady runtime null");
          AppMethodBeat.o(147404);
          throw ((Throwable)localObject1);
        }
        Object localObject1 = (com.tencent.mm.plugin.appbrand.jsruntime.q)a.this.cox.aYh().P(com.tencent.mm.plugin.appbrand.jsruntime.q.class);
        localObject2 = new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(169499);
            if (this.jIG.isDestroyed())
            {
              AppMethodBeat.o(169499);
              return;
            }
            ad.i("MicroMsg.ProxyAppBrandServiceOnRuntimeReadyListener", "AppBrandRuntimeProfile| start prepareDataForNode %s", new Object[] { a.this.cox.getAppId() });
            HashMap localHashMap = new HashMap();
            Object localObject = ((c)this.jIG).cpr;
            if (localObject == null) {
              ad.w("MicroMsg.ProxyAppBrandServiceOnRuntimeReadyListener", "fillPermissionBytes controller null");
            }
            for (;;)
            {
              localHashMap.put("state", com.tencent.mm.plugin.appbrand.a.b.jKO);
              localHashMap.put("wxaData", com.tencent.mm.plugin.appbrand.q.b.b.ab(this.jIG));
              a.this.Q(localHashMap);
              AppMethodBeat.o(169499);
              return;
              localObject = ((d)localObject).bvW();
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
        if (((com.tencent.mm.plugin.appbrand.jsruntime.q)localObject1).Ct())
        {
          ((Runnable)localObject2).run();
          AppMethodBeat.o(147404);
          return;
        }
        ((com.tencent.mm.plugin.appbrand.jsruntime.q)localObject1).post((Runnable)localObject2);
        AppMethodBeat.o(147404);
      }
    };
    r localr = r.a.jAn;
    Object localObject1 = this.cox;
    r.b localb = this.lXU;
    int i = ((com.tencent.mm.plugin.appbrand.q)localObject1).aXC();
    ad.i("MicroMsg.AppBrandServiceOnRuntimeReadyListenerMgr", "addListener service:%d", new Object[] { Integer.valueOf(i) });
    try
    {
      List localList = (List)localr.jAl.get(i);
      localObject1 = localList;
      if (localList == null)
      {
        localObject1 = new ArrayList();
        localr.jAl.put(i, localObject1);
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
    r localr = r.a.jAn;
    Object localObject2 = this.cox;
    r.b localb = this.lXU;
    int i = ((com.tencent.mm.plugin.appbrand.q)localObject2).aXC();
    ad.i("MicroMsg.AppBrandServiceOnRuntimeReadyListenerMgr", "removeListener service:%d", new Object[] { Integer.valueOf(i) });
    try
    {
      localObject2 = (List)localr.jAl.get(i);
      if (localObject2 == null) {
        return;
      }
      ((List)localObject2).remove(localb);
      if (((List)localObject2).isEmpty()) {
        localr.jAl.remove(i);
      }
      return;
    }
    finally
    {
      AppMethodBeat.o(147406);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.q.d.a
 * JD-Core Version:    0.7.0.1
 */