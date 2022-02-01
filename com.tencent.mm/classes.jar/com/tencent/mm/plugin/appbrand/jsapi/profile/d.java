package com.tencent.mm.plugin.appbrand.jsapi.profile;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.c;
import com.tencent.mm.g.a.uj;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ay.a;
import com.tencent.mm.model.ay.b;
import com.tencent.mm.model.ay.b.a;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.ProcessRequest;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.ProcessResult;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.q;

@kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/jsapi/profile/ProfileTask;", "Lcom/tencent/mm/plugin/appbrand/ipc/AppBrandProxyUIProcessTask;", "()V", "handleRequest", "", "request", "Lcom/tencent/mm/plugin/appbrand/ipc/AppBrandProxyUIProcessTask$ProcessRequest;", "plugin-appbrand-integration_release"})
public final class d
  extends AppBrandProxyUIProcessTask
{
  public final void a(final AppBrandProxyUIProcessTask.ProcessRequest paramProcessRequest)
  {
    AppMethodBeat.i(50656);
    kotlin.g.b.p.h(paramProcessRequest, "request");
    final ProfileResult localProfileResult = new ProfileResult();
    if (!(paramProcessRequest instanceof ProfileRequest))
    {
      Log.w("ProfileTask", "handleRequest, request not instance of ProfileRequest");
      localProfileResult.resultCode = 0;
      b((AppBrandProxyUIProcessTask.ProcessResult)localProfileResult);
      AppMethodBeat.o(50656);
      return;
    }
    g.aAf();
    if (!com.tencent.mm.kernel.a.azo())
    {
      Log.e("ProfileTask", "handleRequest, MMKernel.account().hasLogin() is false");
      localProfileResult.resultCode = 0;
      b((AppBrandProxyUIProcessTask.ProcessResult)localProfileResult);
      AppMethodBeat.o(50656);
      return;
    }
    final int i = ((ProfileRequest)paramProcessRequest).scene;
    final String str = ((ProfileRequest)paramProcessRequest).username;
    paramProcessRequest = g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class);
    kotlin.g.b.p.g(paramProcessRequest, "MMKernel.service(IMessengerStorage::class.java)");
    Object localObject = ((com.tencent.mm.plugin.messenger.foundation.a.l)paramProcessRequest).aSN().Kn(str);
    if (localObject != null)
    {
      paramProcessRequest = (AppBrandProxyUIProcessTask.ProcessRequest)localObject;
      if (((as)localObject).arH() > 0) {}
    }
    else
    {
      paramProcessRequest = g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class);
      kotlin.g.b.p.g(paramProcessRequest, "MMKernel.service(IMessengerStorage::class.java)");
      paramProcessRequest = ((com.tencent.mm.plugin.messenger.foundation.a.l)paramProcessRequest).aSN().bjH(str);
    }
    if ((paramProcessRequest != null) && (paramProcessRequest.arH() > 0))
    {
      localObject = new Intent();
      ((Intent)localObject).putExtra("Contact_User", str);
      localProfileResult.username = paramProcessRequest.getUsername();
      if (paramProcessRequest.gBM())
      {
        com.tencent.mm.plugin.report.service.h.CyF.kvStat(10298, paramProcessRequest.getUsername() + "," + i);
        localProfileResult.mnH |= 0x1;
        ((Intent)localObject).putExtra("Contact_Scene", i);
      }
      if (paramProcessRequest.arv())
      {
        localProfileResult.mnH |= 0x2;
        paramProcessRequest = new uj();
        paramProcessRequest.eaI.intent = ((Intent)localObject);
        paramProcessRequest.eaI.username = str;
        EventCenter.instance.publish((IEvent)paramProcessRequest);
      }
      localProfileResult.resultCode = 1;
      b((AppBrandProxyUIProcessTask.ProcessResult)localProfileResult);
      AppMethodBeat.o(50656);
      return;
    }
    Log.i("ProfileTask", "handleRequest, request contact info");
    paramProcessRequest = (Context)bDF();
    bDF().getString(2131755998);
    paramProcessRequest = com.tencent.mm.ui.base.h.a(paramProcessRequest, bDF().getString(2131756029), true, (DialogInterface.OnCancelListener)new b(this, str, localProfileResult));
    ay.a.aVo().a(str, "", (ay.b.a)new a(this, localProfileResult, paramProcessRequest, i));
    AppMethodBeat.o(50656);
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "username", "", "kotlin.jvm.PlatformType", "succ", "", "getContactCallBack"})
  static final class a
    implements ay.b.a
  {
    a(d paramd, ProfileResult paramProfileResult, q paramq, int paramInt) {}
    
    public final void p(String paramString, boolean paramBoolean)
    {
      AppMethodBeat.i(50654);
      if (d.a(this.mnI) == null)
      {
        Log.w("ProfileTask", "handleRequest, getNow callback, context has already been detached!");
        localProfileResult.resultCode = 0;
        d.a(this.mnI, (AppBrandProxyUIProcessTask.ProcessResult)localProfileResult);
        AppMethodBeat.o(50654);
        return;
      }
      Object localObject = paramProcessRequest;
      if (localObject != null) {
        ((q)localObject).dismiss();
      }
      localObject = g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class);
      kotlin.g.b.p.g(localObject, "MMKernel.service(IMessengerStorage::class.java)");
      localObject = ((com.tencent.mm.plugin.messenger.foundation.a.l)localObject).aSN().Kn(paramString);
      if ((localObject == null) || (((as)localObject).arH() <= 0))
      {
        com.tencent.mm.kernel.c.a locala = g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class);
        kotlin.g.b.p.g(locala, "MMKernel.service(IMessengerStorage::class.java)");
        ((com.tencent.mm.plugin.messenger.foundation.a.l)locala).aSN().bjH(paramString);
        paramBoolean = false;
      }
      while (!paramBoolean)
      {
        Log.w("ProfileTask", "handleRequest, getNow callback fail");
        localProfileResult.resultCode = 0;
        d.a(this.mnI, (AppBrandProxyUIProcessTask.ProcessResult)localProfileResult);
        AppMethodBeat.o(50654);
        return;
        paramString = ((as)localObject).getUsername();
      }
      c.ap(paramString, 3);
      com.tencent.mm.aj.p.aYD().Mg(paramString);
      if (localObject == null) {
        kotlin.g.b.p.hyc();
      }
      if (((as)localObject).gBM())
      {
        com.tencent.mm.plugin.report.service.h.CyF.kvStat(10298, ((as)localObject).getUsername() + "," + i);
        localProfileResult.mnH |= 0x1;
      }
      if (((as)localObject).arv()) {
        localProfileResult.mnH |= 0x2;
      }
      localProfileResult.resultCode = 1;
      d.a(this.mnI, (AppBrandProxyUIProcessTask.ProcessResult)localProfileResult);
      AppMethodBeat.o(50654);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "onCancel"})
  static final class b
    implements DialogInterface.OnCancelListener
  {
    b(d paramd, String paramString, ProfileResult paramProfileResult) {}
    
    public final void onCancel(DialogInterface paramDialogInterface)
    {
      AppMethodBeat.i(50655);
      ay.a.aVo().JZ(str);
      localProfileResult.resultCode = 2;
      d.a(this.mnI, (AppBrandProxyUIProcessTask.ProcessResult)localProfileResult);
      AppMethodBeat.o(50655);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.profile.d
 * JD-Core Version:    0.7.0.1
 */