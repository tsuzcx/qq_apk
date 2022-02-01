package com.tencent.mm.plugin.appbrand.q.d;

import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.jsruntime.i;
import com.tencent.mm.plugin.appbrand.jsruntime.q;
import com.tencent.mm.plugin.appbrand.q.a.e;
import com.tencent.mm.plugin.appbrand.q.a.e.a;
import com.tencent.mm.plugin.appbrand.r;
import com.tencent.mm.plugin.appbrand.s;
import com.tencent.mm.plugin.appbrand.s.a;
import com.tencent.mm.plugin.appbrand.s.b;
import com.tencent.mm.sdk.platformtools.ae;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;

public final class a
  extends e
{
  private s.b mcB;
  
  public a(e.a parama, r paramr)
  {
    super(parama, paramr);
  }
  
  public final void buo()
  {
    AppMethodBeat.i(147405);
    this.mcB = new s.b()
    {
      public final void aYa()
      {
        AppMethodBeat.i(147404);
        ae.i("MicroMsg.ProxyAppBrandServiceOnRuntimeReadyListener", "AppBrandRuntimeProfile| onRuntimeReady %s", new Object[] { a.this.coz.getAppId() });
        Object localObject2 = a.this.coz.getRuntime();
        if (localObject2 == null)
        {
          localObject1 = new IllegalStateException("onRuntimeReady runtime null");
          AppMethodBeat.o(147404);
          throw ((Throwable)localObject1);
        }
        Object localObject1 = (q)a.this.coz.aYB().P(q.class);
        localObject2 = new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(169499);
            if (this.jLH.isDestroyed())
            {
              AppMethodBeat.o(169499);
              return;
            }
            ae.i("MicroMsg.ProxyAppBrandServiceOnRuntimeReadyListener", "AppBrandRuntimeProfile| start prepareDataForNode %s", new Object[] { a.this.coz.getAppId() });
            HashMap localHashMap = new HashMap();
            Object localObject = ((com.tencent.luggage.sdk.d.d)this.jLH).cpU;
            if (localObject == null) {
              ae.w("MicroMsg.ProxyAppBrandServiceOnRuntimeReadyListener", "fillPermissionBytes controller null");
            }
            for (;;)
            {
              localHashMap.put("state", com.tencent.mm.plugin.appbrand.a.b.jOa);
              localHashMap.put("wxaData", com.tencent.mm.plugin.appbrand.q.b.b.ab(this.jLH));
              a.this.X(localHashMap);
              AppMethodBeat.o(169499);
              return;
              localObject = ((com.tencent.mm.plugin.appbrand.permission.d)localObject).bwN();
              if (localObject == null)
              {
                ae.i("MicroMsg.ProxyAppBrandServiceOnRuntimeReadyListener", "fillPermissionBytes getPermissionBytes null");
              }
              else
              {
                localHashMap.put("fg", ((Vector)localObject).elementAt(0));
                localHashMap.put("bg", ((Vector)localObject).elementAt(1));
              }
            }
          }
        };
        if (((q)localObject1).Cw())
        {
          ((Runnable)localObject2).run();
          AppMethodBeat.o(147404);
          return;
        }
        ((q)localObject1).post((Runnable)localObject2);
        AppMethodBeat.o(147404);
      }
    };
    s locals = s.a.jDq;
    Object localObject1 = this.coz;
    s.b localb = this.mcB;
    int i = ((r)localObject1).aXX();
    ae.i("MicroMsg.AppBrandServiceOnRuntimeReadyListenerMgr", "addListener service:%d", new Object[] { Integer.valueOf(i) });
    try
    {
      List localList = (List)locals.jDo.get(i);
      localObject1 = localList;
      if (localList == null)
      {
        localObject1 = new ArrayList();
        locals.jDo.put(i, localObject1);
      }
      ((List)localObject1).add(localb);
      locals.e(i, (List)localObject1);
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
    s locals = s.a.jDq;
    Object localObject2 = this.coz;
    s.b localb = this.mcB;
    int i = ((r)localObject2).aXX();
    ae.i("MicroMsg.AppBrandServiceOnRuntimeReadyListenerMgr", "removeListener service:%d", new Object[] { Integer.valueOf(i) });
    try
    {
      localObject2 = (List)locals.jDo.get(i);
      if (localObject2 == null) {
        return;
      }
      ((List)localObject2).remove(localb);
      if (((List)localObject2).isEmpty()) {
        locals.jDo.remove(i);
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