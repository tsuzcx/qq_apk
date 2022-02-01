package com.tencent.mm.plugin.appbrand.launching;

import android.text.TextUtils;
import com.tencent.luggage.sdk.config.LaunchWxaAppInfoParcelized;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfig;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfigWC;
import com.tencent.mm.plugin.appbrand.ipc.MMToClientEvent.c;
import com.tencent.mm.plugin.appbrand.jsapi.c.a;
import com.tencent.mm.plugin.appbrand.jsapi.fakenative.OpenBusinessViewUtil;
import com.tencent.mm.plugin.appbrand.t;
import com.tencent.mm.plugin.appbrand.t.19;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.system.AndroidContextUtil;
import java.util.concurrent.atomic.AtomicBoolean;

public final class ILaunchWxaAppInfoNotify$a$1
  implements MMToClientEvent.c
{
  public ILaunchWxaAppInfoNotify$a$1(t paramt) {}
  
  public final void cq(final Object paramObject)
  {
    AppMethodBeat.i(47177);
    Object localObject;
    if ((paramObject instanceof ILaunchWxaAppInfoNotify.LaunchInfoIpcWrapper))
    {
      paramObject = (ILaunchWxaAppInfoNotify.LaunchInfoIpcWrapper)paramObject;
      if ((this.nsw.mAppId.equals(paramObject.appId)) && (this.nsw.ntz.cBI == paramObject.cBU))
      {
        if (paramObject.cxk.cxP != null)
        {
          AppBrandLaunchErrorAction localAppBrandLaunchErrorAction = (AppBrandLaunchErrorAction)paramObject.cxk.cxP;
          Log.i("MicroMsg.ILaunchWxaAppInfoNotify[permission]", "try notify update runtime(%s %d), error action %s ", new Object[] { this.nsw.mAppId, Integer.valueOf(this.nsw.ntz.cBI), localAppBrandLaunchErrorAction.getClass().getName() });
          localObject = this.nsw;
          paramObject = localObject;
          if (localObject == null) {
            paramObject = com.tencent.mm.plugin.appbrand.d.abA(localAppBrandLaunchErrorAction.appId);
          }
          if ((paramObject == null) || (localAppBrandLaunchErrorAction.cBU != paramObject.bDy().cBI)) {}
          for (;;)
          {
            OpenBusinessViewUtil.B(this.nsw);
            AppMethodBeat.o(47177);
            return;
            paramObject.S(new AppBrandLaunchErrorAction.1(localAppBrandLaunchErrorAction, AndroidContextUtil.castActivityOrNull(paramObject.mContext)));
          }
        }
        localObject = this.nsw.cCQ;
        if (localObject == null) {
          break label279;
        }
        ((com.tencent.mm.plugin.appbrand.permission.d)localObject).a(paramObject.cxk.cxO);
        if (!TextUtils.isEmpty(paramObject.cxk.cxQ)) {
          new a().i(this.nsw, paramObject.cxk.cxQ);
        }
      }
      for (;;)
      {
        if (paramObject.cxk.cxR) {
          this.nsw.O(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(279218);
              t localt = ILaunchWxaAppInfoNotify.a.1.this.nsw;
              AppBrandSysConfigWC localAppBrandSysConfigWC = localt.bDx();
              if (localAppBrandSysConfigWC == null)
              {
                AppMethodBeat.o(279218);
                return;
              }
              localAppBrandSysConfigWC.cxk.cxR = true;
              if (localt.nwL != null) {
                localt.nwL.dead();
              }
              localt.nwL = new t.19(localt);
              localt.nwL.alive();
              AppMethodBeat.o(279218);
            }
          });
        }
        AppMethodBeat.o(47177);
        return;
        label279:
        if (this.nsw.ntU.get())
        {
          Log.e("MicroMsg.ILaunchWxaAppInfoNotify[permission]", "try notify update, runtime(%s %d) destroyed", new Object[] { this.nsw.mAppId, Integer.valueOf(this.nsw.ntz.cBI) });
        }
        else
        {
          Log.i("MicroMsg.ILaunchWxaAppInfoNotify[permission]", "try notify update, runtime(%s %d) add deferred action", new Object[] { this.nsw.mAppId, Integer.valueOf(this.nsw.ntz.cBI) });
          this.nsw.U(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(47176);
              ILaunchWxaAppInfoNotify.a.1.this.nsw.cCQ.a(paramObject.cxk.cxO);
              if (!TextUtils.isEmpty(paramObject.cxk.cxQ)) {
                new a().i(ILaunchWxaAppInfoNotify.a.1.this.nsw, paramObject.cxk.cxQ);
              }
              AppMethodBeat.o(47176);
            }
          });
        }
      }
    }
    if ((paramObject instanceof ILaunchWxaAppInfoNotify.PluginIpcWrapper))
    {
      Log.i("MicroMsg.ILaunchWxaAppInfoNotify[permission]", "MMToClientEvent.OnCustomDataNotifyListener PluginIpcWrapper");
      paramObject = (ILaunchWxaAppInfoNotify.PluginIpcWrapper)paramObject;
      if ((this.nsw.mAppId.equals(paramObject.appId)) && (this.nsw.ntz.cBI == paramObject.cBU))
      {
        localObject = this.nsw.cCQ;
        if (localObject != null)
        {
          ((com.tencent.mm.plugin.appbrand.permission.d)localObject).g(paramObject.pVz);
          AppMethodBeat.o(47177);
          return;
        }
        if (this.nsw.ntU.get())
        {
          Log.e("MicroMsg.ILaunchWxaAppInfoNotify[permission]", "try notify update, runtime(%s %d) destroyed", new Object[] { this.nsw.mAppId, Integer.valueOf(this.nsw.ntz.cBI) });
          AppMethodBeat.o(47177);
          return;
        }
        Log.i("MicroMsg.ILaunchWxaAppInfoNotify[permission]", "try notify update, runtime(%s %d) add deferred action", new Object[] { this.nsw.mAppId, Integer.valueOf(this.nsw.ntz.cBI) });
        this.nsw.U(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(279246);
            ILaunchWxaAppInfoNotify.a.1.this.nsw.cCQ.g(paramObject.pVz);
            AppMethodBeat.o(279246);
          }
        });
      }
      AppMethodBeat.o(47177);
      return;
    }
    if ((paramObject instanceof ILaunchWxaAppInfoNotify.AppidABTestIpcWrapper))
    {
      Log.i("MicroMsg.ILaunchWxaAppInfoNotify[permission]", "MMToClientEvent.OnCustomDataNotifyListener AppidABTestIpcWrapper");
      paramObject = (ILaunchWxaAppInfoNotify.AppidABTestIpcWrapper)paramObject;
      if ((this.nsw.mAppId.equals(paramObject.appId)) && (this.nsw.ntz.cBI == paramObject.cBU))
      {
        localObject = this.nsw.cCQ;
        if (localObject != null)
        {
          ((com.tencent.mm.plugin.appbrand.permission.d)localObject).h(paramObject.pVy);
          AppMethodBeat.o(47177);
          return;
        }
        if (this.nsw.ntU.get())
        {
          Log.e("MicroMsg.ILaunchWxaAppInfoNotify[permission]", "try notify update, runtime(%s %d) destroyed", new Object[] { this.nsw.mAppId, Integer.valueOf(this.nsw.ntz.cBI) });
          AppMethodBeat.o(47177);
          return;
        }
        Log.i("MicroMsg.ILaunchWxaAppInfoNotify[permission]", "try notify update, runtime(%s %d) add deferred action", new Object[] { this.nsw.mAppId, Integer.valueOf(this.nsw.ntz.cBI) });
        this.nsw.U(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(265712);
            ILaunchWxaAppInfoNotify.a.1.this.nsw.cCQ.h(paramObject.pVy);
            AppMethodBeat.o(265712);
          }
        });
      }
    }
    AppMethodBeat.o(47177);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.ILaunchWxaAppInfoNotify.a.1
 * JD-Core Version:    0.7.0.1
 */