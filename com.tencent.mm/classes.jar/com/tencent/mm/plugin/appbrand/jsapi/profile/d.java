package com.tencent.mm.plugin.appbrand.jsapi.profile;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.c;
import com.tencent.mm.g.a.sk;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ar.a;
import com.tencent.mm.model.ar.b;
import com.tencent.mm.model.ar.b.a;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.ProcessRequest;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.ProcessResult;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.storage.af;
import com.tencent.mm.storage.bg;
import com.tencent.mm.ui.MMActivity;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/appbrand/jsapi/profile/ProfileTask;", "Lcom/tencent/mm/plugin/appbrand/ipc/AppBrandProxyUIProcessTask;", "()V", "handleRequest", "", "request", "Lcom/tencent/mm/plugin/appbrand/ipc/AppBrandProxyUIProcessTask$ProcessRequest;", "plugin-appbrand-integration_release"})
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
      ad.w("ProfileTask", "handleRequest, request not instance of ProfileRequest");
      localProfileResult.bRZ = 0;
      b((AppBrandProxyUIProcessTask.ProcessResult)localProfileResult);
      AppMethodBeat.o(50656);
      return;
    }
    g.afz();
    if (!com.tencent.mm.kernel.a.aeH())
    {
      ad.e("ProfileTask", "handleRequest, MMKernel.account().hasLogin() is false");
      localProfileResult.bRZ = 0;
      b((AppBrandProxyUIProcessTask.ProcessResult)localProfileResult);
      AppMethodBeat.o(50656);
      return;
    }
    final int i = ((ProfileRequest)paramProcessRequest).scene;
    final String str = ((ProfileRequest)paramProcessRequest).username;
    paramProcessRequest = g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class);
    d.g.b.k.g(paramProcessRequest, "MMKernel.service(IMessengerStorage::class.java)");
    Object localObject = ((com.tencent.mm.plugin.messenger.foundation.a.k)paramProcessRequest).apM().aHY(str);
    if (localObject != null)
    {
      paramProcessRequest = (AppBrandProxyUIProcessTask.ProcessRequest)localObject;
      if (((af)localObject).ZV() > 0) {}
    }
    else
    {
      paramProcessRequest = g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class);
      d.g.b.k.g(paramProcessRequest, "MMKernel.service(IMessengerStorage::class.java)");
      paramProcessRequest = ((com.tencent.mm.plugin.messenger.foundation.a.k)paramProcessRequest).apM().aHU(str);
    }
    if ((paramProcessRequest != null) && (paramProcessRequest.ZV() > 0))
    {
      localObject = new Intent();
      ((Intent)localObject).putExtra("Contact_User", str);
      localProfileResult.username = paramProcessRequest.getUsername();
      if (paramProcessRequest.eKB())
      {
        com.tencent.mm.plugin.report.service.h.vKh.kvStat(10298, paramProcessRequest.getUsername() + "," + i);
        localProfileResult.khm |= 0x1;
        ((Intent)localObject).putExtra("Contact_Scene", i);
      }
      if (paramProcessRequest.ZJ())
      {
        localProfileResult.khm |= 0x2;
        paramProcessRequest = new sk();
        paramProcessRequest.dxW.intent = ((Intent)localObject);
        paramProcessRequest.dxW.username = str;
        com.tencent.mm.sdk.b.a.ESL.l((b)paramProcessRequest);
      }
      localProfileResult.bRZ = 1;
      b((AppBrandProxyUIProcessTask.ProcessResult)localProfileResult);
      AppMethodBeat.o(50656);
      return;
    }
    ad.i("ProfileTask", "handleRequest, request contact info");
    paramProcessRequest = (Context)aXi();
    aXi().getString(2131755906);
    paramProcessRequest = com.tencent.mm.ui.base.h.b(paramProcessRequest, aXi().getString(2131755936), true, (DialogInterface.OnCancelListener)new b(this, str, localProfileResult));
    ar.a.arF().a(str, "", (ar.b.a)new a(this, localProfileResult, paramProcessRequest, i));
    AppMethodBeat.o(50656);
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "username", "", "kotlin.jvm.PlatformType", "succ", "", "getContactCallBack"})
  static final class a
    implements ar.b.a
  {
    a(d paramd, ProfileResult paramProfileResult, com.tencent.mm.ui.base.p paramp, int paramInt) {}
    
    public final void p(String paramString, boolean paramBoolean)
    {
      AppMethodBeat.i(50654);
      if (d.a(this.khn) == null)
      {
        ad.w("ProfileTask", "handleRequest, getNow callback, context has already been detached!");
        localProfileResult.bRZ = 0;
        d.a(this.khn, (AppBrandProxyUIProcessTask.ProcessResult)localProfileResult);
        AppMethodBeat.o(50654);
        return;
      }
      Object localObject = paramProcessRequest;
      if (localObject != null) {
        ((com.tencent.mm.ui.base.p)localObject).dismiss();
      }
      localObject = g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class);
      d.g.b.k.g(localObject, "MMKernel.service(IMessengerStorage::class.java)");
      localObject = ((com.tencent.mm.plugin.messenger.foundation.a.k)localObject).apM().aHY(paramString);
      if ((localObject == null) || (((af)localObject).ZV() <= 0))
      {
        com.tencent.mm.kernel.c.a locala = g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class);
        d.g.b.k.g(locala, "MMKernel.service(IMessengerStorage::class.java)");
        ((com.tencent.mm.plugin.messenger.foundation.a.k)locala).apM().aHU(paramString);
        paramBoolean = false;
      }
      while (!paramBoolean)
      {
        ad.w("ProfileTask", "handleRequest, getNow callback fail");
        localProfileResult.bRZ = 0;
        d.a(this.khn, (AppBrandProxyUIProcessTask.ProcessResult)localProfileResult);
        AppMethodBeat.o(50654);
        return;
        paramString = ((af)localObject).getUsername();
      }
      c.ac(paramString, 3);
      com.tencent.mm.ak.p.auH().vP(paramString);
      if (localObject == null) {
        d.g.b.k.fvU();
      }
      if (((af)localObject).eKB())
      {
        com.tencent.mm.plugin.report.service.h.vKh.kvStat(10298, ((af)localObject).getUsername() + "," + i);
        localProfileResult.khm |= 0x1;
      }
      if (((af)localObject).ZJ()) {
        localProfileResult.khm |= 0x2;
      }
      localProfileResult.bRZ = 1;
      d.a(this.khn, (AppBrandProxyUIProcessTask.ProcessResult)localProfileResult);
      AppMethodBeat.o(50654);
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "onCancel"})
  static final class b
    implements DialogInterface.OnCancelListener
  {
    b(d paramd, String paramString, ProfileResult paramProfileResult) {}
    
    public final void onCancel(DialogInterface paramDialogInterface)
    {
      AppMethodBeat.i(50655);
      ar.a.arF().tX(str);
      localProfileResult.bRZ = 2;
      d.a(this.khn, (AppBrandProxyUIProcessTask.ProcessResult)localProfileResult);
      AppMethodBeat.o(50655);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.profile.d
 * JD-Core Version:    0.7.0.1
 */