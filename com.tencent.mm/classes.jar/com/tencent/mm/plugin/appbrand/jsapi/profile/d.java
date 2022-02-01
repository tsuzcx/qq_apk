package com.tencent.mm.plugin.appbrand.jsapi.profile;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.c;
import com.tencent.mm.g.a.st;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ar.a;
import com.tencent.mm.model.ar.b;
import com.tencent.mm.model.ar.b.a;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.ProcessRequest;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.ProcessResult;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.bj;
import com.tencent.mm.ui.MMActivity;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/appbrand/jsapi/profile/ProfileTask;", "Lcom/tencent/mm/plugin/appbrand/ipc/AppBrandProxyUIProcessTask;", "()V", "handleRequest", "", "request", "Lcom/tencent/mm/plugin/appbrand/ipc/AppBrandProxyUIProcessTask$ProcessRequest;", "plugin-appbrand-integration_release"})
public final class d
  extends AppBrandProxyUIProcessTask
{
  public final void a(final AppBrandProxyUIProcessTask.ProcessRequest paramProcessRequest)
  {
    AppMethodBeat.i(50656);
    d.g.b.k.h(paramProcessRequest, "request");
    final ProfileResult localProfileResult = new ProfileResult();
    if (!(paramProcessRequest instanceof ProfileRequest))
    {
      ac.w("ProfileTask", "handleRequest, request not instance of ProfileRequest");
      localProfileResult.bPH = 0;
      b((AppBrandProxyUIProcessTask.ProcessResult)localProfileResult);
      AppMethodBeat.o(50656);
      return;
    }
    g.agP();
    if (!com.tencent.mm.kernel.a.afX())
    {
      ac.e("ProfileTask", "handleRequest, MMKernel.account().hasLogin() is false");
      localProfileResult.bPH = 0;
      b((AppBrandProxyUIProcessTask.ProcessResult)localProfileResult);
      AppMethodBeat.o(50656);
      return;
    }
    final int i = ((ProfileRequest)paramProcessRequest).scene;
    final String str = ((ProfileRequest)paramProcessRequest).username;
    paramProcessRequest = g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class);
    d.g.b.k.g(paramProcessRequest, "MMKernel.service(IMessengerStorage::class.java)");
    Object localObject = ((com.tencent.mm.plugin.messenger.foundation.a.k)paramProcessRequest).awB().aNt(str);
    if (localObject != null)
    {
      paramProcessRequest = (AppBrandProxyUIProcessTask.ProcessRequest)localObject;
      if (((ai)localObject).aaQ() > 0) {}
    }
    else
    {
      paramProcessRequest = g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class);
      d.g.b.k.g(paramProcessRequest, "MMKernel.service(IMessengerStorage::class.java)");
      paramProcessRequest = ((com.tencent.mm.plugin.messenger.foundation.a.k)paramProcessRequest).awB().aNp(str);
    }
    if ((paramProcessRequest != null) && (paramProcessRequest.aaQ() > 0))
    {
      localObject = new Intent();
      ((Intent)localObject).putExtra("Contact_User", str);
      localProfileResult.username = paramProcessRequest.getUsername();
      if (paramProcessRequest.fad())
      {
        com.tencent.mm.plugin.report.service.h.wUl.kvStat(10298, paramProcessRequest.getUsername() + "," + i);
        localProfileResult.kIe |= 0x1;
        ((Intent)localObject).putExtra("Contact_Scene", i);
      }
      if (paramProcessRequest.aaE())
      {
        localProfileResult.kIe |= 0x2;
        paramProcessRequest = new st();
        paramProcessRequest.dvI.intent = ((Intent)localObject);
        paramProcessRequest.dvI.username = str;
        com.tencent.mm.sdk.b.a.GpY.l((b)paramProcessRequest);
      }
      localProfileResult.bPH = 1;
      b((AppBrandProxyUIProcessTask.ProcessResult)localProfileResult);
      AppMethodBeat.o(50656);
      return;
    }
    ac.i("ProfileTask", "handleRequest, request contact info");
    paramProcessRequest = (Context)bef();
    bef().getString(2131755906);
    paramProcessRequest = com.tencent.mm.ui.base.h.b(paramProcessRequest, bef().getString(2131755936), true, (DialogInterface.OnCancelListener)new b(this, str, localProfileResult));
    ar.a.ayw().a(str, "", (ar.b.a)new a(this, localProfileResult, paramProcessRequest, i));
    AppMethodBeat.o(50656);
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "username", "", "kotlin.jvm.PlatformType", "succ", "", "getContactCallBack"})
  static final class a
    implements ar.b.a
  {
    a(d paramd, ProfileResult paramProfileResult, com.tencent.mm.ui.base.p paramp, int paramInt) {}
    
    public final void p(String paramString, boolean paramBoolean)
    {
      AppMethodBeat.i(50654);
      if (d.a(this.kIf) == null)
      {
        ac.w("ProfileTask", "handleRequest, getNow callback, context has already been detached!");
        localProfileResult.bPH = 0;
        d.a(this.kIf, (AppBrandProxyUIProcessTask.ProcessResult)localProfileResult);
        AppMethodBeat.o(50654);
        return;
      }
      Object localObject = paramProcessRequest;
      if (localObject != null) {
        ((com.tencent.mm.ui.base.p)localObject).dismiss();
      }
      localObject = g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class);
      d.g.b.k.g(localObject, "MMKernel.service(IMessengerStorage::class.java)");
      localObject = ((com.tencent.mm.plugin.messenger.foundation.a.k)localObject).awB().aNt(paramString);
      if ((localObject == null) || (((ai)localObject).aaQ() <= 0))
      {
        com.tencent.mm.kernel.c.a locala = g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class);
        d.g.b.k.g(locala, "MMKernel.service(IMessengerStorage::class.java)");
        ((com.tencent.mm.plugin.messenger.foundation.a.k)locala).awB().aNp(paramString);
        paramBoolean = false;
      }
      while (!paramBoolean)
      {
        ac.w("ProfileTask", "handleRequest, getNow callback fail");
        localProfileResult.bPH = 0;
        d.a(this.kIf, (AppBrandProxyUIProcessTask.ProcessResult)localProfileResult);
        AppMethodBeat.o(50654);
        return;
        paramString = ((ai)localObject).getUsername();
      }
      c.ag(paramString, 3);
      com.tencent.mm.aj.p.aBy().zV(paramString);
      if (localObject == null) {
        d.g.b.k.fOy();
      }
      if (((ai)localObject).fad())
      {
        com.tencent.mm.plugin.report.service.h.wUl.kvStat(10298, ((ai)localObject).getUsername() + "," + i);
        localProfileResult.kIe |= 0x1;
      }
      if (((ai)localObject).aaE()) {
        localProfileResult.kIe |= 0x2;
      }
      localProfileResult.bPH = 1;
      d.a(this.kIf, (AppBrandProxyUIProcessTask.ProcessResult)localProfileResult);
      AppMethodBeat.o(50654);
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "onCancel"})
  static final class b
    implements DialogInterface.OnCancelListener
  {
    b(d paramd, String paramString, ProfileResult paramProfileResult) {}
    
    public final void onCancel(DialogInterface paramDialogInterface)
    {
      AppMethodBeat.i(50655);
      ar.a.ayw().yd(str);
      localProfileResult.bPH = 2;
      d.a(this.kIf, (AppBrandProxyUIProcessTask.ProcessResult)localProfileResult);
      AppMethodBeat.o(50655);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.profile.d
 * JD-Core Version:    0.7.0.1
 */