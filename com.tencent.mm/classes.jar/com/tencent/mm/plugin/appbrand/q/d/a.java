package com.tencent.mm.plugin.appbrand.q.d;

import android.util.SparseArray;
import com.tencent.luggage.sdk.d.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.jsruntime.i;
import com.tencent.mm.plugin.appbrand.q.a.e.a;
import com.tencent.mm.plugin.appbrand.r;
import com.tencent.mm.plugin.appbrand.r.a;
import com.tencent.mm.plugin.appbrand.r.b;
import com.tencent.mm.sdk.platformtools.ac;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;

public final class a
  extends com.tencent.mm.plugin.appbrand.q.a.e
{
  private r.b lyw;
  
  public a(e.a parama, com.tencent.mm.plugin.appbrand.q paramq)
  {
    super(parama, paramq);
  }
  
  public final void bpC()
  {
    AppMethodBeat.i(147405);
    this.lyw = new r.b()
    {
      public final void aUt()
      {
        AppMethodBeat.i(147404);
        ac.i("MicroMsg.ProxyAppBrandServiceOnRuntimeReadyListener", "AppBrandRuntimeProfile| onRuntimeReady %s", new Object[] { a.this.ceh.getAppId() });
        Object localObject2 = a.this.ceh.getRuntime();
        if (localObject2 == null)
        {
          localObject1 = new IllegalStateException("onRuntimeReady runtime null");
          AppMethodBeat.o(147404);
          throw ((Throwable)localObject1);
        }
        Object localObject1 = (com.tencent.mm.plugin.appbrand.jsruntime.q)a.this.ceh.aUV().P(com.tencent.mm.plugin.appbrand.jsruntime.q.class);
        localObject2 = new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(169499);
            if (this.joK.isDestroyed())
            {
              AppMethodBeat.o(169499);
              return;
            }
            ac.i("MicroMsg.ProxyAppBrandServiceOnRuntimeReadyListener", "AppBrandRuntimeProfile| start prepareDataForNode %s", new Object[] { a.this.ceh.getAppId() });
            HashMap localHashMap = new HashMap();
            Object localObject = ((c)this.joK).cfa;
            if (localObject == null) {
              ac.w("MicroMsg.ProxyAppBrandServiceOnRuntimeReadyListener", "fillPermissionBytes controller null");
            }
            for (;;)
            {
              localHashMap.put("state", com.tencent.mm.plugin.appbrand.b.b.jqU);
              localHashMap.put("wxaData", com.tencent.mm.plugin.appbrand.q.b.b.ah(this.joK));
              a.this.Q(localHashMap);
              AppMethodBeat.o(169499);
              return;
              localObject = ((com.tencent.mm.plugin.appbrand.permission.e)localObject).brY();
              if (localObject == null)
              {
                ac.i("MicroMsg.ProxyAppBrandServiceOnRuntimeReadyListener", "fillPermissionBytes getPermissionBytes null");
              }
              else
              {
                localHashMap.put("fg", ((Vector)localObject).elementAt(0));
                localHashMap.put("bg", ((Vector)localObject).elementAt(1));
              }
            }
          }
        };
        if (((com.tencent.mm.plugin.appbrand.jsruntime.q)localObject1).AU())
        {
          ((Runnable)localObject2).run();
          AppMethodBeat.o(147404);
          return;
        }
        ((com.tencent.mm.plugin.appbrand.jsruntime.q)localObject1).post((Runnable)localObject2);
        AppMethodBeat.o(147404);
      }
    };
    r localr = r.a.jhi;
    Object localObject1 = this.ceh;
    r.b localb = this.lyw;
    int i = ((com.tencent.mm.plugin.appbrand.q)localObject1).aUT();
    ac.i("MicroMsg.AppBrandServiceOnRuntimeReadyListenerMgr", "addListener service:%d", new Object[] { Integer.valueOf(i) });
    try
    {
      List localList = (List)localr.jhg.get(i);
      localObject1 = localList;
      if (localList == null)
      {
        localObject1 = new ArrayList();
        localr.jhg.put(i, localObject1);
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
    r localr = r.a.jhi;
    Object localObject2 = this.ceh;
    r.b localb = this.lyw;
    int i = ((com.tencent.mm.plugin.appbrand.q)localObject2).aUT();
    ac.i("MicroMsg.AppBrandServiceOnRuntimeReadyListenerMgr", "removeListener service:%d", new Object[] { Integer.valueOf(i) });
    try
    {
      localObject2 = (List)localr.jhg.get(i);
      if (localObject2 == null) {
        return;
      }
      ((List)localObject2).remove(localb);
      if (((List)localObject2).isEmpty()) {
        localr.jhg.remove(i);
      }
      return;
    }
    finally
    {
      AppMethodBeat.o(147406);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.q.d.a
 * JD-Core Version:    0.7.0.1
 */