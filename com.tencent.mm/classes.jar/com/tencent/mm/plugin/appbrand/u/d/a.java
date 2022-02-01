package com.tencent.mm.plugin.appbrand.u.d;

import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.m.i;
import com.tencent.mm.plugin.appbrand.m.q;
import com.tencent.mm.plugin.appbrand.s;
import com.tencent.mm.plugin.appbrand.t;
import com.tencent.mm.plugin.appbrand.t.a;
import com.tencent.mm.plugin.appbrand.t.b;
import com.tencent.mm.plugin.appbrand.u.a.e;
import com.tencent.mm.plugin.appbrand.u.a.e.a;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;

public final class a
  extends e
{
  private t.b nkm;
  
  public a(e.a parama, s params)
  {
    super(parama, params);
  }
  
  public final void bPV()
  {
    AppMethodBeat.i(147405);
    this.nkm = new t.b()
    {
      public final void btg()
      {
        AppMethodBeat.i(147404);
        Log.i("MicroMsg.ProxyAppBrandServiceOnRuntimeReadyListener", "AppBrandRuntimeProfile| onRuntimeReady %s", new Object[] { a.this.cAJ.getAppId() });
        Object localObject2 = a.this.cAJ.getRuntime();
        if (localObject2 == null)
        {
          localObject1 = new IllegalStateException("onRuntimeReady runtime null");
          AppMethodBeat.o(147404);
          throw ((Throwable)localObject1);
        }
        Object localObject1 = (q)a.this.cAJ.getJsRuntime().R(q.class);
        localObject2 = new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(169499);
            if (this.kTg.isDestroyed())
            {
              AppMethodBeat.o(169499);
              return;
            }
            Log.i("MicroMsg.ProxyAppBrandServiceOnRuntimeReadyListener", "AppBrandRuntimeProfile| start prepareDataForNode %s", new Object[] { a.this.cAJ.getAppId() });
            HashMap localHashMap = new HashMap();
            Object localObject = ((com.tencent.luggage.sdk.d.d)this.kTg).cCn;
            if (localObject == null) {
              Log.w("MicroMsg.ProxyAppBrandServiceOnRuntimeReadyListener", "fillPermissionBytes controller null");
            }
            for (;;)
            {
              localHashMap.put("state", com.tencent.mm.plugin.appbrand.a.b.kQH);
              localHashMap.put("wxaData", com.tencent.mm.plugin.appbrand.u.b.b.ac(this.kTg));
              a.this.aa(localHashMap);
              AppMethodBeat.o(169499);
              return;
              localObject = ((com.tencent.mm.plugin.appbrand.permission.d)localObject).bSW();
              if (localObject == null)
              {
                Log.i("MicroMsg.ProxyAppBrandServiceOnRuntimeReadyListener", "fillPermissionBytes getPermissionBytes null");
              }
              else
              {
                localHashMap.put("fg", ((Vector)localObject).elementAt(0));
                localHashMap.put("bg", ((Vector)localObject).elementAt(1));
              }
            }
          }
        };
        if (((q)localObject1).LO())
        {
          ((Runnable)localObject2).run();
          AppMethodBeat.o(147404);
          return;
        }
        ((q)localObject1).post((Runnable)localObject2);
        AppMethodBeat.o(147404);
      }
    };
    t localt = t.a.kEr;
    Object localObject1 = this.cAJ;
    t.b localb = this.nkm;
    int i = ((s)localObject1).getComponentId();
    Log.i("MicroMsg.AppBrandServiceOnRuntimeReadyListenerMgr", "addListener service:%d", new Object[] { Integer.valueOf(i) });
    try
    {
      List localList = (List)localt.kEp.get(i);
      localObject1 = localList;
      if (localList == null)
      {
        localObject1 = new ArrayList();
        localt.kEp.put(i, localObject1);
      }
      ((List)localObject1).add(localb);
      localt.e(i, (List)localObject1);
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
    t localt = t.a.kEr;
    Object localObject2 = this.cAJ;
    t.b localb = this.nkm;
    int i = ((s)localObject2).getComponentId();
    Log.i("MicroMsg.AppBrandServiceOnRuntimeReadyListenerMgr", "removeListener service:%d", new Object[] { Integer.valueOf(i) });
    try
    {
      localObject2 = (List)localt.kEp.get(i);
      if (localObject2 == null) {
        return;
      }
      ((List)localObject2).remove(localb);
      if (((List)localObject2).isEmpty()) {
        localt.kEp.remove(i);
      }
      return;
    }
    finally
    {
      AppMethodBeat.o(147406);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.u.d.a
 * JD-Core Version:    0.7.0.1
 */