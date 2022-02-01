package com.tencent.mm.plugin.appbrand.jsapi.profile;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.c;
import com.tencent.mm.g.a.tl;
import com.tencent.mm.model.au.a;
import com.tencent.mm.model.au.b;
import com.tencent.mm.model.au.b.a;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.ProcessRequest;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.ProcessResult;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.storage.an;
import com.tencent.mm.storage.bq;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;

@d.l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/appbrand/jsapi/profile/ProfileTask;", "Lcom/tencent/mm/plugin/appbrand/ipc/AppBrandProxyUIProcessTask;", "()V", "handleRequest", "", "request", "Lcom/tencent/mm/plugin/appbrand/ipc/AppBrandProxyUIProcessTask$ProcessRequest;", "plugin-appbrand-integration_release"})
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
      ae.w("ProfileTask", "handleRequest, request not instance of ProfileRequest");
      localProfileResult.bZU = 0;
      b((AppBrandProxyUIProcessTask.ProcessResult)localProfileResult);
      AppMethodBeat.o(50656);
      return;
    }
    com.tencent.mm.kernel.g.ajP();
    if (!com.tencent.mm.kernel.a.aiY())
    {
      ae.e("ProfileTask", "handleRequest, MMKernel.account().hasLogin() is false");
      localProfileResult.bZU = 0;
      b((AppBrandProxyUIProcessTask.ProcessResult)localProfileResult);
      AppMethodBeat.o(50656);
      return;
    }
    final int i = ((ProfileRequest)paramProcessRequest).scene;
    final String str = ((ProfileRequest)paramProcessRequest).username;
    paramProcessRequest = com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class);
    d.g.b.p.g(paramProcessRequest, "MMKernel.service(IMessengerStorage::class.java)");
    Object localObject = ((com.tencent.mm.plugin.messenger.foundation.a.l)paramProcessRequest).azF().BH(str);
    if (localObject != null)
    {
      paramProcessRequest = (AppBrandProxyUIProcessTask.ProcessRequest)localObject;
      if (((an)localObject).adE() > 0) {}
    }
    else
    {
      paramProcessRequest = com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class);
      d.g.b.p.g(paramProcessRequest, "MMKernel.service(IMessengerStorage::class.java)");
      paramProcessRequest = ((com.tencent.mm.plugin.messenger.foundation.a.l)paramProcessRequest).azF().aUI(str);
    }
    if ((paramProcessRequest != null) && (paramProcessRequest.adE() > 0))
    {
      localObject = new Intent();
      ((Intent)localObject).putExtra("Contact_User", str);
      localProfileResult.username = paramProcessRequest.getUsername();
      if (paramProcessRequest.fug())
      {
        com.tencent.mm.plugin.report.service.g.yxI.kvStat(10298, paramProcessRequest.getUsername() + "," + i);
        localProfileResult.lii |= 0x1;
        ((Intent)localObject).putExtra("Contact_Scene", i);
      }
      if (paramProcessRequest.ads())
      {
        localProfileResult.lii |= 0x2;
        paramProcessRequest = new tl();
        paramProcessRequest.dIV.intent = ((Intent)localObject);
        paramProcessRequest.dIV.username = str;
        com.tencent.mm.sdk.b.a.IvT.l((b)paramProcessRequest);
      }
      localProfileResult.bZU = 1;
      b((AppBrandProxyUIProcessTask.ProcessResult)localProfileResult);
      AppMethodBeat.o(50656);
      return;
    }
    ae.i("ProfileTask", "handleRequest, request contact info");
    paramProcessRequest = (Context)bis();
    bis().getString(2131755906);
    paramProcessRequest = h.b(paramProcessRequest, bis().getString(2131755936), true, (DialogInterface.OnCancelListener)new b(this, str, localProfileResult));
    au.a.aBQ().a(str, "", (au.b.a)new a(this, localProfileResult, paramProcessRequest, i));
    AppMethodBeat.o(50656);
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "username", "", "kotlin.jvm.PlatformType", "succ", "", "getContactCallBack"})
  static final class a
    implements au.b.a
  {
    a(d paramd, ProfileResult paramProfileResult, com.tencent.mm.ui.base.p paramp, int paramInt) {}
    
    public final void p(String paramString, boolean paramBoolean)
    {
      AppMethodBeat.i(50654);
      if (d.a(this.lij) == null)
      {
        ae.w("ProfileTask", "handleRequest, getNow callback, context has already been detached!");
        localProfileResult.bZU = 0;
        d.a(this.lij, (AppBrandProxyUIProcessTask.ProcessResult)localProfileResult);
        AppMethodBeat.o(50654);
        return;
      }
      Object localObject = paramProcessRequest;
      if (localObject != null) {
        ((com.tencent.mm.ui.base.p)localObject).dismiss();
      }
      localObject = com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class);
      d.g.b.p.g(localObject, "MMKernel.service(IMessengerStorage::class.java)");
      localObject = ((com.tencent.mm.plugin.messenger.foundation.a.l)localObject).azF().BH(paramString);
      if ((localObject == null) || (((an)localObject).adE() <= 0))
      {
        com.tencent.mm.kernel.c.a locala = com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class);
        d.g.b.p.g(locala, "MMKernel.service(IMessengerStorage::class.java)");
        ((com.tencent.mm.plugin.messenger.foundation.a.l)locala).azF().aUI(paramString);
        paramBoolean = false;
      }
      while (!paramBoolean)
      {
        ae.w("ProfileTask", "handleRequest, getNow callback fail");
        localProfileResult.bZU = 0;
        d.a(this.lij, (AppBrandProxyUIProcessTask.ProcessResult)localProfileResult);
        AppMethodBeat.o(50654);
        return;
        paramString = ((an)localObject).getUsername();
      }
      c.al(paramString, 3);
      com.tencent.mm.aj.p.aEP().Dw(paramString);
      if (localObject == null) {
        d.g.b.p.gkB();
      }
      if (((an)localObject).fug())
      {
        com.tencent.mm.plugin.report.service.g.yxI.kvStat(10298, ((an)localObject).getUsername() + "," + i);
        localProfileResult.lii |= 0x1;
      }
      if (((an)localObject).ads()) {
        localProfileResult.lii |= 0x2;
      }
      localProfileResult.bZU = 1;
      d.a(this.lij, (AppBrandProxyUIProcessTask.ProcessResult)localProfileResult);
      AppMethodBeat.o(50654);
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "onCancel"})
  static final class b
    implements DialogInterface.OnCancelListener
  {
    b(d paramd, String paramString, ProfileResult paramProfileResult) {}
    
    public final void onCancel(DialogInterface paramDialogInterface)
    {
      AppMethodBeat.i(50655);
      au.a.aBQ().Bt(str);
      localProfileResult.bZU = 2;
      d.a(this.lij, (AppBrandProxyUIProcessTask.ProcessResult)localProfileResult);
      AppMethodBeat.o(50655);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.profile.d
 * JD-Core Version:    0.7.0.1
 */