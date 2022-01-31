package com.tencent.mm.plugin.appbrand.jsapi.profile;

import a.l;
import android.content.Context;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.qr;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ao.a;
import com.tencent.mm.model.ao.b;
import com.tencent.mm.model.ao.b.a;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.ProcessRequest;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.ProcessResult;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bd;
import com.tencent.mm.ui.MMActivity;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/appbrand/jsapi/profile/ProfileTask;", "Lcom/tencent/mm/plugin/appbrand/ipc/AppBrandProxyUIProcessTask;", "()V", "handleRequest", "", "request", "Lcom/tencent/mm/plugin/appbrand/ipc/AppBrandProxyUIProcessTask$ProcessRequest;", "plugin-appbrand-integration_release"})
public final class d
  extends AppBrandProxyUIProcessTask
{
  public final void a(AppBrandProxyUIProcessTask.ProcessRequest paramProcessRequest)
  {
    AppMethodBeat.i(134708);
    a.f.b.j.q(paramProcessRequest, "request");
    ProfileResult localProfileResult = new ProfileResult();
    if (!(paramProcessRequest instanceof ProfileRequest))
    {
      ab.w("ProfileTask", "handleRequest, request not instance of ProfileRequest");
      localProfileResult.bpE = 0;
      a((AppBrandProxyUIProcessTask.ProcessResult)localProfileResult);
      AppMethodBeat.o(134708);
      return;
    }
    g.RJ();
    if (!com.tencent.mm.kernel.a.QT())
    {
      ab.e("ProfileTask", "handleRequest, MMKernel.account().hasLogin() is false");
      localProfileResult.bpE = 0;
      a((AppBrandProxyUIProcessTask.ProcessResult)localProfileResult);
      AppMethodBeat.o(134708);
      return;
    }
    int i = ((ProfileRequest)paramProcessRequest).scene;
    String str = ((ProfileRequest)paramProcessRequest).username;
    paramProcessRequest = g.E(com.tencent.mm.plugin.messenger.foundation.a.j.class);
    a.f.b.j.p(paramProcessRequest, "MMKernel.service(IMessengerStorage::class.java)");
    Object localObject = ((com.tencent.mm.plugin.messenger.foundation.a.j)paramProcessRequest).YA().arw(str);
    if (localObject != null)
    {
      paramProcessRequest = (AppBrandProxyUIProcessTask.ProcessRequest)localObject;
      if (((ad)localObject).Od() > 0) {}
    }
    else
    {
      paramProcessRequest = g.E(com.tencent.mm.plugin.messenger.foundation.a.j.class);
      a.f.b.j.p(paramProcessRequest, "MMKernel.service(IMessengerStorage::class.java)");
      paramProcessRequest = ((com.tencent.mm.plugin.messenger.foundation.a.j)paramProcessRequest).YA().ars(str);
    }
    if ((paramProcessRequest != null) && (paramProcessRequest.Od() > 0))
    {
      localObject = new Intent();
      ((Intent)localObject).putExtra("Contact_User", str);
      localProfileResult.username = paramProcessRequest.getUsername();
      if (paramProcessRequest.dwz())
      {
        com.tencent.mm.plugin.report.service.h.qsU.kvStat(10298, paramProcessRequest.getUsername() + "," + i);
        localProfileResult.hXn |= 0x1;
        ((Intent)localObject).putExtra("Contact_Scene", i);
      }
      if (paramProcessRequest.NT())
      {
        localProfileResult.hXn |= 0x2;
        paramProcessRequest = new qr();
        paramProcessRequest.cHh.intent = ((Intent)localObject);
        paramProcessRequest.cHh.username = str;
        com.tencent.mm.sdk.b.a.ymk.l((b)paramProcessRequest);
      }
      localProfileResult.bpE = 1;
      a((AppBrandProxyUIProcessTask.ProcessResult)localProfileResult);
      AppMethodBeat.o(134708);
      return;
    }
    ab.i("ProfileTask", "handleRequest, request contact info");
    paramProcessRequest = (Context)aBf();
    aBf().getString(2131297087);
    paramProcessRequest = com.tencent.mm.ui.base.h.b(paramProcessRequest, aBf().getString(2131297112), true, (DialogInterface.OnCancelListener)new d.b(this, str, localProfileResult));
    ao.a.aaj().a(str, "", (ao.b.a)new d.a(this, localProfileResult, paramProcessRequest, i));
    AppMethodBeat.o(134708);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.profile.d
 * JD-Core Version:    0.7.0.1
 */