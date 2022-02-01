package com.tencent.mm.plugin.appbrand.u.d;

import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.m.i;
import com.tencent.mm.plugin.appbrand.m.q;
import com.tencent.mm.plugin.appbrand.u.a.e;
import com.tencent.mm.plugin.appbrand.u.a.e.a;
import com.tencent.mm.plugin.appbrand.v;
import com.tencent.mm.plugin.appbrand.w;
import com.tencent.mm.plugin.appbrand.w.a;
import com.tencent.mm.plugin.appbrand.w.b;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;
import java.util.concurrent.atomic.AtomicBoolean;

public final class a
  extends e
{
  private w.b qlK;
  
  public a(e.a parama, v paramv)
  {
    super(parama, paramv);
  }
  
  public final void ccC()
  {
    AppMethodBeat.i(147405);
    this.qlK = new w.b()
    {
      public final void acr()
      {
        AppMethodBeat.i(147404);
        Log.i("MicroMsg.ProxyAppBrandServiceOnRuntimeReadyListener", "AppBrandRuntimeProfile| onRuntimeReady %s", new Object[] { a.this.czP.getAppId() });
        Object localObject2 = a.this.czP.getRuntime();
        if (localObject2 == null)
        {
          localObject1 = new IllegalStateException("onRuntimeReady runtime null");
          AppMethodBeat.o(147404);
          throw ((Throwable)localObject1);
        }
        Object localObject1 = (q)a.this.czP.getJsRuntime().Q(q.class);
        localObject2 = new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(169499);
            if (this.nNE.ntU.get())
            {
              AppMethodBeat.o(169499);
              return;
            }
            Log.i("MicroMsg.ProxyAppBrandServiceOnRuntimeReadyListener", "AppBrandRuntimeProfile| start prepareDataForNode %s", new Object[] { a.this.czP.getAppId() });
            HashMap localHashMap = new HashMap();
            Object localObject = ((com.tencent.luggage.sdk.e.d)this.nNE).cCQ;
            if (localObject == null) {
              Log.w("MicroMsg.ProxyAppBrandServiceOnRuntimeReadyListener", "fillPermissionBytes controller null");
            }
            for (;;)
            {
              localHashMap.put("state", com.tencent.mm.plugin.appbrand.a.b.nKP);
              localHashMap.put("wxaData", com.tencent.mm.plugin.appbrand.u.b.b.ac(this.nNE));
              a.this.T(localHashMap);
              AppMethodBeat.o(169499);
              return;
              localObject = ((com.tencent.mm.plugin.appbrand.permission.d)localObject).cfZ();
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
        if (((q)localObject1).OF())
        {
          ((Runnable)localObject2).run();
          AppMethodBeat.o(147404);
          return;
        }
        ((q)localObject1).post((Runnable)localObject2);
        AppMethodBeat.o(147404);
      }
    };
    w localw = w.a.nxH;
    Object localObject1 = this.czP;
    w.b localb = this.qlK;
    int i = ((v)localObject1).getComponentId();
    Log.i("MicroMsg.AppBrandServiceOnRuntimeReadyListenerMgr", "addListener service:%d", new Object[] { Integer.valueOf(i) });
    try
    {
      List localList = (List)localw.nxF.get(i);
      localObject1 = localList;
      if (localList == null)
      {
        localObject1 = new ArrayList();
        localw.nxF.put(i, localObject1);
      }
      ((List)localObject1).add(localb);
      localw.e(i, (List)localObject1);
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
    w localw = w.a.nxH;
    Object localObject2 = this.czP;
    w.b localb = this.qlK;
    int i = ((v)localObject2).getComponentId();
    Log.i("MicroMsg.AppBrandServiceOnRuntimeReadyListenerMgr", "removeListener service:%d", new Object[] { Integer.valueOf(i) });
    try
    {
      localObject2 = (List)localw.nxF.get(i);
      if (localObject2 == null) {
        return;
      }
      ((List)localObject2).remove(localb);
      if (((List)localObject2).isEmpty()) {
        localw.nxF.remove(i);
      }
      return;
    }
    finally
    {
      AppMethodBeat.o(147406);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.u.d.a
 * JD-Core Version:    0.7.0.1
 */