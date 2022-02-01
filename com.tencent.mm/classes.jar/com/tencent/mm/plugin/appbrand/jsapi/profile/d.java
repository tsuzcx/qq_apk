package com.tencent.mm.plugin.appbrand.jsapi.profile;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.c;
import com.tencent.mm.g.a.tk;
import com.tencent.mm.model.as.a;
import com.tencent.mm.model.as.b;
import com.tencent.mm.model.as.b.a;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.ProcessRequest;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.ProcessResult;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.storage.am;
import com.tencent.mm.storage.bp;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;

@d.l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/appbrand/jsapi/profile/ProfileTask;", "Lcom/tencent/mm/plugin/appbrand/ipc/AppBrandProxyUIProcessTask;", "()V", "handleRequest", "", "request", "Lcom/tencent/mm/plugin/appbrand/ipc/AppBrandProxyUIProcessTask$ProcessRequest;", "plugin-appbrand-integration_release"})
public final class d
  extends AppBrandProxyUIProcessTask
{
  public final void a(final AppBrandProxyUIProcessTask.ProcessRequest paramProcessRequest)
  {
    AppMethodBeat.i(50656);
    d.g.b.p.h(paramProcessRequest, "request");
    final ProfileResult localProfileResult = new ProfileResult();
    if (!(paramProcessRequest instanceof ProfileRequest))
    {
      ad.w("ProfileTask", "handleRequest, request not instance of ProfileRequest");
      localProfileResult.bZU = 0;
      b((AppBrandProxyUIProcessTask.ProcessResult)localProfileResult);
      AppMethodBeat.o(50656);
      return;
    }
    com.tencent.mm.kernel.g.ajA();
    if (!com.tencent.mm.kernel.a.aiJ())
    {
      ad.e("ProfileTask", "handleRequest, MMKernel.account().hasLogin() is false");
      localProfileResult.bZU = 0;
      b((AppBrandProxyUIProcessTask.ProcessResult)localProfileResult);
      AppMethodBeat.o(50656);
      return;
    }
    final int i = ((ProfileRequest)paramProcessRequest).scene;
    final String str = ((ProfileRequest)paramProcessRequest).username;
    paramProcessRequest = com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class);
    d.g.b.p.g(paramProcessRequest, "MMKernel.service(IMessengerStorage::class.java)");
    Object localObject = ((com.tencent.mm.plugin.messenger.foundation.a.l)paramProcessRequest).azp().Bf(str);
    if (localObject != null)
    {
      paramProcessRequest = (AppBrandProxyUIProcessTask.ProcessRequest)localObject;
      if (((am)localObject).adt() > 0) {}
    }
    else
    {
      paramProcessRequest = com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class);
      d.g.b.p.g(paramProcessRequest, "MMKernel.service(IMessengerStorage::class.java)");
      paramProcessRequest = ((com.tencent.mm.plugin.messenger.foundation.a.l)paramProcessRequest).azp().aTh(str);
    }
    if ((paramProcessRequest != null) && (paramProcessRequest.adt() > 0))
    {
      localObject = new Intent();
      ((Intent)localObject).putExtra("Contact_User", str);
      localProfileResult.username = paramProcessRequest.getUsername();
      if (paramProcessRequest.fqg())
      {
        com.tencent.mm.plugin.report.service.g.yhR.kvStat(10298, paramProcessRequest.getUsername() + "," + i);
        localProfileResult.lex |= 0x1;
        ((Intent)localObject).putExtra("Contact_Scene", i);
      }
      if (paramProcessRequest.adh())
      {
        localProfileResult.lex |= 0x2;
        paramProcessRequest = new tk();
        paramProcessRequest.dHR.intent = ((Intent)localObject);
        paramProcessRequest.dHR.username = str;
        com.tencent.mm.sdk.b.a.IbL.l((b)paramProcessRequest);
      }
      localProfileResult.bZU = 1;
      b((AppBrandProxyUIProcessTask.ProcessResult)localProfileResult);
      AppMethodBeat.o(50656);
      return;
    }
    ad.i("ProfileTask", "handleRequest, request contact info");
    paramProcessRequest = (Context)bhJ();
    bhJ().getString(2131755906);
    paramProcessRequest = h.b(paramProcessRequest, bhJ().getString(2131755936), true, (DialogInterface.OnCancelListener)new b(this, str, localProfileResult));
    as.a.aBA().a(str, "", (as.b.a)new a(this, localProfileResult, paramProcessRequest, i));
    AppMethodBeat.o(50656);
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "username", "", "kotlin.jvm.PlatformType", "succ", "", "getContactCallBack"})
  static final class a
    implements as.b.a
  {
    a(d paramd, ProfileResult paramProfileResult, com.tencent.mm.ui.base.p paramp, int paramInt) {}
    
    public final void p(String paramString, boolean paramBoolean)
    {
      AppMethodBeat.i(50654);
      if (d.a(this.ley) == null)
      {
        ad.w("ProfileTask", "handleRequest, getNow callback, context has already been detached!");
        localProfileResult.bZU = 0;
        d.a(this.ley, (AppBrandProxyUIProcessTask.ProcessResult)localProfileResult);
        AppMethodBeat.o(50654);
        return;
      }
      Object localObject = paramProcessRequest;
      if (localObject != null) {
        ((com.tencent.mm.ui.base.p)localObject).dismiss();
      }
      localObject = com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class);
      d.g.b.p.g(localObject, "MMKernel.service(IMessengerStorage::class.java)");
      localObject = ((com.tencent.mm.plugin.messenger.foundation.a.l)localObject).azp().Bf(paramString);
      if ((localObject == null) || (((am)localObject).adt() <= 0))
      {
        com.tencent.mm.kernel.c.a locala = com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class);
        d.g.b.p.g(locala, "MMKernel.service(IMessengerStorage::class.java)");
        ((com.tencent.mm.plugin.messenger.foundation.a.l)locala).azp().aTh(paramString);
        paramBoolean = false;
      }
      while (!paramBoolean)
      {
        ad.w("ProfileTask", "handleRequest, getNow callback fail");
        localProfileResult.bZU = 0;
        d.a(this.ley, (AppBrandProxyUIProcessTask.ProcessResult)localProfileResult);
        AppMethodBeat.o(50654);
        return;
        paramString = ((am)localObject).getUsername();
      }
      c.ak(paramString, 3);
      com.tencent.mm.ak.p.aEz().CU(paramString);
      if (localObject == null) {
        d.g.b.p.gfZ();
      }
      if (((am)localObject).fqg())
      {
        com.tencent.mm.plugin.report.service.g.yhR.kvStat(10298, ((am)localObject).getUsername() + "," + i);
        localProfileResult.lex |= 0x1;
      }
      if (((am)localObject).adh()) {
        localProfileResult.lex |= 0x2;
      }
      localProfileResult.bZU = 1;
      d.a(this.ley, (AppBrandProxyUIProcessTask.ProcessResult)localProfileResult);
      AppMethodBeat.o(50654);
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "onCancel"})
  static final class b
    implements DialogInterface.OnCancelListener
  {
    b(d paramd, String paramString, ProfileResult paramProfileResult) {}
    
    public final void onCancel(DialogInterface paramDialogInterface)
    {
      AppMethodBeat.i(50655);
      as.a.aBA().AJ(str);
      localProfileResult.bZU = 2;
      d.a(this.ley, (AppBrandProxyUIProcessTask.ProcessResult)localProfileResult);
      AppMethodBeat.o(50655);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.profile.d
 * JD-Core Version:    0.7.0.1
 */