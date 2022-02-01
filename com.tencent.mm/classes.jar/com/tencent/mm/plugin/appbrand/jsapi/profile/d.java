package com.tencent.mm.plugin.appbrand.jsapi.profile;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.e;
import com.tencent.mm.am.q;
import com.tencent.mm.f.a.vm;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.c.a;
import com.tencent.mm.model.az.a;
import com.tencent.mm.model.az.b;
import com.tencent.mm.model.az.b.a;
import com.tencent.mm.plugin.appbrand.au.i;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.ProcessRequest;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.ProcessResult;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.s;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/jsapi/profile/ProfileTask;", "Lcom/tencent/mm/plugin/appbrand/ipc/AppBrandProxyUIProcessTask;", "()V", "handleRequest", "", "request", "Lcom/tencent/mm/plugin/appbrand/ipc/AppBrandProxyUIProcessTask$ProcessRequest;", "plugin-appbrand-integration_release"})
public final class d
  extends AppBrandProxyUIProcessTask
{
  public final void a(final AppBrandProxyUIProcessTask.ProcessRequest paramProcessRequest)
  {
    AppMethodBeat.i(50656);
    p.k(paramProcessRequest, "request");
    final ProfileResult localProfileResult = new ProfileResult();
    if (!(paramProcessRequest instanceof ProfileRequest))
    {
      Log.w("ProfileTask", "handleRequest, request not instance of ProfileRequest");
      localProfileResult.resultCode = 0;
      b((AppBrandProxyUIProcessTask.ProcessResult)localProfileResult);
      AppMethodBeat.o(50656);
      return;
    }
    com.tencent.mm.kernel.h.aHE();
    if (!b.aGL())
    {
      Log.e("ProfileTask", "handleRequest, MMKernel.account().hasLogin() is false");
      localProfileResult.resultCode = 0;
      b((AppBrandProxyUIProcessTask.ProcessResult)localProfileResult);
      AppMethodBeat.o(50656);
      return;
    }
    final int i = ((ProfileRequest)paramProcessRequest).scene;
    final String str = ((ProfileRequest)paramProcessRequest).username;
    paramProcessRequest = com.tencent.mm.kernel.h.ae(n.class);
    p.j(paramProcessRequest, "MMKernel.service(IMessengerStorage::class.java)");
    Object localObject = ((n)paramProcessRequest).bbL().RG(str);
    if (localObject != null)
    {
      paramProcessRequest = (AppBrandProxyUIProcessTask.ProcessRequest)localObject;
      if (((as)localObject).ayq() > 0) {}
    }
    else
    {
      paramProcessRequest = com.tencent.mm.kernel.h.ae(n.class);
      p.j(paramProcessRequest, "MMKernel.service(IMessengerStorage::class.java)");
      paramProcessRequest = ((n)paramProcessRequest).bbL().bwe(str);
    }
    if ((paramProcessRequest != null) && (paramProcessRequest.ayq() > 0))
    {
      localObject = new Intent();
      ((Intent)localObject).putExtra("Contact_User", str);
      localProfileResult.username = paramProcessRequest.getUsername();
      if (paramProcessRequest.hxX())
      {
        com.tencent.mm.plugin.report.service.h.IzE.kvStat(10298, paramProcessRequest.getUsername() + "," + i);
        localProfileResult.plN |= 0x1;
        ((Intent)localObject).putExtra("Contact_Scene", i);
      }
      if (paramProcessRequest.axZ())
      {
        localProfileResult.plN |= 0x2;
        paramProcessRequest = new vm();
        paramProcessRequest.fUF.intent = ((Intent)localObject);
        paramProcessRequest.fUF.username = str;
        EventCenter.instance.publish((IEvent)paramProcessRequest);
      }
      localProfileResult.resultCode = 1;
      b((AppBrandProxyUIProcessTask.ProcessResult)localProfileResult);
      AppMethodBeat.o(50656);
      return;
    }
    Log.i("ProfileTask", "handleRequest, request contact info");
    paramProcessRequest = (Context)bPf();
    bPf().getString(au.i.app_tip);
    paramProcessRequest = com.tencent.mm.ui.base.h.a(paramProcessRequest, bPf().getString(au.i.app_waiting), true, (DialogInterface.OnCancelListener)new b(this, str, localProfileResult));
    az.a.ber().a(str, "", (az.b.a)new a(this, localProfileResult, paramProcessRequest, i));
    AppMethodBeat.o(50656);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "username", "", "kotlin.jvm.PlatformType", "succ", "", "getContactCallBack"})
  static final class a
    implements az.b.a
  {
    a(d paramd, ProfileResult paramProfileResult, s params, int paramInt) {}
    
    public final void s(String paramString, boolean paramBoolean)
    {
      AppMethodBeat.i(50654);
      if (d.a(this.plO) == null)
      {
        Log.w("ProfileTask", "handleRequest, getNow callback, context has already been detached!");
        localProfileResult.resultCode = 0;
        d.a(this.plO, (AppBrandProxyUIProcessTask.ProcessResult)localProfileResult);
        AppMethodBeat.o(50654);
        return;
      }
      Object localObject = paramProcessRequest;
      if (localObject != null) {
        ((s)localObject).dismiss();
      }
      localObject = com.tencent.mm.kernel.h.ae(n.class);
      p.j(localObject, "MMKernel.service(IMessengerStorage::class.java)");
      localObject = ((n)localObject).bbL().RG(paramString);
      if ((localObject == null) || (((as)localObject).ayq() <= 0))
      {
        a locala = com.tencent.mm.kernel.h.ae(n.class);
        p.j(locala, "MMKernel.service(IMessengerStorage::class.java)");
        ((n)locala).bbL().bwe(paramString);
        paramBoolean = false;
      }
      while (!paramBoolean)
      {
        Log.w("ProfileTask", "handleRequest, getNow callback fail");
        localProfileResult.resultCode = 0;
        d.a(this.plO, (AppBrandProxyUIProcessTask.ProcessResult)localProfileResult);
        AppMethodBeat.o(50654);
        return;
        paramString = ((as)localObject).getUsername();
      }
      com.tencent.mm.am.d.aH(paramString, 3);
      q.bhR().TB(paramString);
      if (localObject == null) {
        p.iCn();
      }
      if (((as)localObject).hxX())
      {
        com.tencent.mm.plugin.report.service.h.IzE.kvStat(10298, ((as)localObject).getUsername() + "," + i);
        localProfileResult.plN |= 0x1;
      }
      if (((as)localObject).axZ()) {
        localProfileResult.plN |= 0x2;
      }
      localProfileResult.resultCode = 1;
      d.a(this.plO, (AppBrandProxyUIProcessTask.ProcessResult)localProfileResult);
      AppMethodBeat.o(50654);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "onCancel"})
  static final class b
    implements DialogInterface.OnCancelListener
  {
    b(d paramd, String paramString, ProfileResult paramProfileResult) {}
    
    public final void onCancel(DialogInterface paramDialogInterface)
    {
      AppMethodBeat.i(50655);
      az.a.ber().Rr(str);
      localProfileResult.resultCode = 2;
      d.a(this.plO, (AppBrandProxyUIProcessTask.ProcessResult)localProfileResult);
      AppMethodBeat.o(50655);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.profile.d
 * JD-Core Version:    0.7.0.1
 */