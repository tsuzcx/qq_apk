package com.tencent.mm.plugin.appbrand.launching;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.a;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfig;
import com.tencent.mm.plugin.appbrand.i;
import com.tencent.mm.plugin.appbrand.ipc.MMToClientEvent.c;
import com.tencent.mm.plugin.appbrand.jsapi.fakenative.OpenBusinessViewUtil;
import com.tencent.mm.plugin.appbrand.o;
import com.tencent.mm.plugin.appbrand.page.r;
import com.tencent.mm.plugin.appbrand.permission.e;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.ui.MMActivity;

public final class ILaunchWxaAppInfoNotify$a$1
  implements MMToClientEvent.c
{
  public ILaunchWxaAppInfoNotify$a$1(o paramo) {}
  
  public final void aZ(final Object paramObject)
  {
    AppMethodBeat.i(131826);
    if ((paramObject instanceof ILaunchWxaAppInfoNotify.LaunchInfoIpcWrapper))
    {
      paramObject = (ILaunchWxaAppInfoNotify.LaunchInfoIpcWrapper)paramObject;
      if ((this.gOJ.mAppId.equals(paramObject.appId)) && (this.gOJ.gPz.gXd == paramObject.hcr))
      {
        if (paramObject.ilk != null)
        {
          ab.i("MicroMsg.ILaunchWxaAppInfoNotify[permission]", "try notify update runtime(%s %d), error action %s ", new Object[] { this.gOJ.mAppId, Integer.valueOf(this.gOJ.gPz.gXd), paramObject.ilk.getClass().getName() });
          AppBrandLaunchErrorAction localAppBrandLaunchErrorAction = paramObject.ilk;
          localObject = this.gOJ;
          paramObject = localObject;
          if (localObject == null) {
            paramObject = a.xL(localAppBrandLaunchErrorAction.appId);
          }
          if ((paramObject == null) || (localAppBrandLaunchErrorAction.hcr != paramObject.wZ().gXd)) {}
          for (;;)
          {
            OpenBusinessViewUtil.z(this.gOJ);
            AppMethodBeat.o(131826);
            return;
            localObject = paramObject.ati();
            paramObject.finish();
            if (localObject == null) {
              paramObject = ah.getContext();
            }
            do
            {
              localAppBrandLaunchErrorAction.cS(paramObject);
              break;
              paramObject = ((i)localObject).atj();
              if (paramObject == null) {
                break;
              }
              localObject = (MMActivity)paramObject.getContext();
              if (((MMActivity)localObject).isFinishing()) {
                break;
              }
              paramObject = localObject;
            } while (!((MMActivity)localObject).activityHasDestroyed());
          }
        }
        Object localObject = this.gOJ.wO();
        if (localObject != null)
        {
          ((e)localObject).a(paramObject.bDn);
          AppMethodBeat.o(131826);
          return;
        }
        if (this.gOJ.mFinished)
        {
          ab.e("MicroMsg.ILaunchWxaAppInfoNotify[permission]", "try notify update, runtime(%s %d) finished", new Object[] { this.gOJ.mAppId, Integer.valueOf(this.gOJ.gPz.gXd) });
          AppMethodBeat.o(131826);
          return;
        }
        ab.i("MicroMsg.ILaunchWxaAppInfoNotify[permission]", "try notify update, runtime(%s %d) add deferred action", new Object[] { this.gOJ.mAppId, Integer.valueOf(this.gOJ.gPz.gXd) });
        this.gOJ.z(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(131825);
            ILaunchWxaAppInfoNotify.a.1.this.gOJ.wO().a(paramObject.bDn);
            AppMethodBeat.o(131825);
          }
        });
      }
    }
    AppMethodBeat.o(131826);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.ILaunchWxaAppInfoNotify.a.1
 * JD-Core Version:    0.7.0.1
 */