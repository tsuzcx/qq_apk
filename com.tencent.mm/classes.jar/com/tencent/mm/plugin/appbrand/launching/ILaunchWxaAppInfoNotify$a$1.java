package com.tencent.mm.plugin.appbrand.launching;

import com.tencent.mm.plugin.appbrand.a;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfig;
import com.tencent.mm.plugin.appbrand.i;
import com.tencent.mm.plugin.appbrand.ipc.MMToClientEvent.c;
import com.tencent.mm.plugin.appbrand.permission.d;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;

public final class ILaunchWxaAppInfoNotify$a$1
  implements MMToClientEvent.c
{
  public ILaunchWxaAppInfoNotify$a$1(com.tencent.mm.plugin.appbrand.n paramn) {}
  
  public final void aG(final Object paramObject)
  {
    AppBrandLaunchErrorAction localAppBrandLaunchErrorAction;
    if ((paramObject instanceof ILaunchWxaAppInfoNotify.LaunchInfoIpcWrapper))
    {
      paramObject = (ILaunchWxaAppInfoNotify.LaunchInfoIpcWrapper)paramObject;
      if ((this.gKu.mAppId.equals(paramObject.appId)) && (this.gKu.fyn.fEL == paramObject.fJy))
      {
        if (paramObject.gKt == null) {
          break label153;
        }
        localAppBrandLaunchErrorAction = paramObject.gKt;
        localObject = this.gKu;
        paramObject = localObject;
        if (localObject == null) {
          paramObject = a.qn(localAppBrandLaunchErrorAction.appId);
        }
        if ((paramObject != null) && (localAppBrandLaunchErrorAction.fJy == paramObject.ZA().fEL)) {
          break label96;
        }
      }
    }
    return;
    label96:
    Object localObject = paramObject.Zx();
    paramObject.finish();
    if (localObject == null) {
      paramObject = ae.getContext();
    }
    do
    {
      localAppBrandLaunchErrorAction.cr(paramObject);
      return;
      paramObject = ((i)localObject).Zz();
      if (paramObject == null) {
        break;
      }
      localObject = (MMActivity)paramObject.getContext();
      if (((MMActivity)localObject).isFinishing()) {
        break;
      }
      paramObject = localObject;
    } while (!((MMActivity)localObject).uMr);
    return;
    label153:
    localObject = this.gKu.fzB;
    if (localObject != null)
    {
      ((d)localObject).a(paramObject.fPW);
      return;
    }
    if (this.gKu.mFinished)
    {
      y.e("MicroMsg.ILaunchWxaAppInfoNotify", "try notify update, runtime(%s) finished", new Object[] { this.gKu.mAppId });
      return;
    }
    this.gKu.s(new Runnable()
    {
      public final void run()
      {
        ILaunchWxaAppInfoNotify.a.1.this.gKu.fzB.a(paramObject.fPW);
      }
    });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.ILaunchWxaAppInfoNotify.a.1
 * JD-Core Version:    0.7.0.1
 */