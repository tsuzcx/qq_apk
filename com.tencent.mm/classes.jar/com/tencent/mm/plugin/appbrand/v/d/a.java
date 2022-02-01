package com.tencent.mm.plugin.appbrand.v.d;

import android.util.SparseArray;
import com.tencent.luggage.sdk.e.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.n.i;
import com.tencent.mm.plugin.appbrand.n.q;
import com.tencent.mm.plugin.appbrand.v.a.e;
import com.tencent.mm.plugin.appbrand.v.a.e.a;
import com.tencent.mm.plugin.appbrand.y;
import com.tencent.mm.plugin.appbrand.z;
import com.tencent.mm.plugin.appbrand.z.a;
import com.tencent.mm.plugin.appbrand.z.b;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

public final class a
  extends e
{
  private z.b tqI;
  
  public a(e.a parama, y paramy)
  {
    super(parama, paramy);
  }
  
  public final void cCY()
  {
    AppMethodBeat.i(147405);
    this.tqI = new z.b()
    {
      public final void aEr()
      {
        AppMethodBeat.i(147404);
        Log.i("MicroMsg.ProxyAppBrandServiceOnRuntimeReadyListener", "AppBrandRuntimeProfile| onRuntimeReady %s", new Object[] { a.this.esk.getAppId() });
        Object localObject2 = a.this.esk.getRuntime();
        if (localObject2 == null)
        {
          localObject1 = new IllegalStateException("onRuntimeReady runtime null");
          AppMethodBeat.o(147404);
          throw ((Throwable)localObject1);
        }
        Object localObject1 = (q)a.this.esk.getJsRuntime().Z(q.class);
        localObject2 = new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(169499);
            if (this.sap.qsE.get())
            {
              AppMethodBeat.o(169499);
              return;
            }
            Log.i("MicroMsg.ProxyAppBrandServiceOnRuntimeReadyListener", "AppBrandRuntimeProfile| start prepareDataForNode %s", new Object[] { a.this.esk.getAppId() });
            HashMap localHashMap = new HashMap();
            a.a(localHashMap, ((d)this.sap).evw);
            localHashMap.put("state", Integer.valueOf(com.tencent.mm.plugin.appbrand.b.b.qKw.ordinal()));
            localHashMap.put("wxaData", com.tencent.mm.plugin.appbrand.v.b.b.aq(this.sap));
            a.this.aa(localHashMap);
            AppMethodBeat.o(169499);
          }
        };
        if (((q)localObject1).aoN())
        {
          ((Runnable)localObject2).run();
          AppMethodBeat.o(147404);
          return;
        }
        ((q)localObject1).post((Runnable)localObject2);
        AppMethodBeat.o(147404);
      }
    };
    z localz = z.a.qwV;
    Object localObject1 = this.esk;
    z.b localb = this.tqI;
    int i = ((y)localObject1).getComponentId();
    Log.i("MicroMsg.AppBrandServiceOnRuntimeReadyListenerMgr", "addListener service:%d", new Object[] { Integer.valueOf(i) });
    try
    {
      List localList = (List)localz.qwT.get(i);
      localObject1 = localList;
      if (localList == null)
      {
        localObject1 = new ArrayList();
        localz.qwT.put(i, localObject1);
      }
      ((List)localObject1).add(localb);
      localz.t(i, (List)localObject1);
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
    z localz = z.a.qwV;
    Object localObject2 = this.esk;
    z.b localb = this.tqI;
    int i = ((y)localObject2).getComponentId();
    Log.i("MicroMsg.AppBrandServiceOnRuntimeReadyListenerMgr", "removeListener service:%d", new Object[] { Integer.valueOf(i) });
    try
    {
      localObject2 = (List)localz.qwT.get(i);
      if (localObject2 == null) {
        return;
      }
      ((List)localObject2).remove(localb);
      if (((List)localObject2).isEmpty()) {
        localz.qwT.remove(i);
      }
      return;
    }
    finally
    {
      AppMethodBeat.o(147406);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.v.d.a
 * JD-Core Version:    0.7.0.1
 */