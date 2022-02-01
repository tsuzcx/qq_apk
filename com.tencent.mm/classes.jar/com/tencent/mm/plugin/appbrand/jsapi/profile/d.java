package com.tencent.mm.plugin.appbrand.jsapi.profile;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.xc;
import com.tencent.mm.autogen.b.az;
import com.tencent.mm.kernel.b;
import com.tencent.mm.model.az.a;
import com.tencent.mm.model.az.b;
import com.tencent.mm.modelavatar.e;
import com.tencent.mm.modelavatar.q;
import com.tencent.mm.plugin.appbrand.ba.i;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.ProcessRequest;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.ProcessResult;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.bx;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.k;
import com.tencent.mm.ui.base.w;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/profile/ProfileTask;", "Lcom/tencent/mm/plugin/appbrand/ipc/AppBrandProxyUIProcessTask;", "()V", "handleRequest", "", "request", "Lcom/tencent/mm/plugin/appbrand/ipc/AppBrandProxyUIProcessTask$ProcessRequest;", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class d
  extends AppBrandProxyUIProcessTask
{
  private static final void a(d paramd, ProfileResult paramProfileResult, w paramw, int paramInt, String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(325859);
    s.u(paramd, "this$0");
    s.u(paramProfileResult, "$profileResult");
    if (paramd.getActivityContext() == null)
    {
      Log.w("ProfileTask", "handleRequest, getNow callback, context has already been detached!");
      paramProfileResult.resultCode = 0;
      paramd.finishProcess((AppBrandProxyUIProcessTask.ProcessResult)paramProfileResult);
      AppMethodBeat.o(325859);
      return;
    }
    if (paramw != null) {
      paramw.dismiss();
    }
    paramw = ((n)com.tencent.mm.kernel.h.ax(n.class)).bzA().JE(paramString);
    if ((paramw == null) || ((int)paramw.maN <= 0))
    {
      ((n)com.tencent.mm.kernel.h.ax(n.class)).bzA().bxs(paramString);
      paramBoolean = false;
    }
    while (!paramBoolean)
    {
      Log.w("ProfileTask", "handleRequest, getNow callback fail");
      paramProfileResult.resultCode = 0;
      paramd.finishProcess((AppBrandProxyUIProcessTask.ProcessResult)paramProfileResult);
      AppMethodBeat.o(325859);
      return;
      paramString = paramw.field_username;
    }
    com.tencent.mm.modelavatar.d.aS(paramString, 3);
    q.bFG().LB(paramString);
    s.checkNotNull(paramw);
    if (paramw.iZC())
    {
      com.tencent.mm.plugin.report.service.h.OAn.kvStat(10298, paramw.field_username + ',' + paramInt);
      paramProfileResult.sqJ |= 0x1;
    }
    if (com.tencent.mm.contact.d.rs(paramw.field_type)) {
      paramProfileResult.sqJ |= 0x2;
    }
    paramProfileResult.resultCode = 1;
    paramd.finishProcess((AppBrandProxyUIProcessTask.ProcessResult)paramProfileResult);
    AppMethodBeat.o(325859);
  }
  
  private static final void a(String paramString, ProfileResult paramProfileResult, d paramd, DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(325852);
    s.u(paramProfileResult, "$profileResult");
    s.u(paramd, "this$0");
    az.a.okP.Jq(paramString);
    paramProfileResult.resultCode = 2;
    paramd.finishProcess((AppBrandProxyUIProcessTask.ProcessResult)paramProfileResult);
    AppMethodBeat.o(325852);
  }
  
  public final void handleRequest(AppBrandProxyUIProcessTask.ProcessRequest paramProcessRequest)
  {
    AppMethodBeat.i(50656);
    s.u(paramProcessRequest, "request");
    ProfileResult localProfileResult = new ProfileResult();
    if (!(paramProcessRequest instanceof ProfileRequest))
    {
      Log.w("ProfileTask", "handleRequest, request not instance of ProfileRequest");
      localProfileResult.resultCode = 0;
      finishProcess((AppBrandProxyUIProcessTask.ProcessResult)localProfileResult);
      AppMethodBeat.o(50656);
      return;
    }
    com.tencent.mm.kernel.h.baC();
    if (!b.aZM())
    {
      Log.e("ProfileTask", "handleRequest, MMKernel.account().hasLogin() is false");
      localProfileResult.resultCode = 0;
      finishProcess((AppBrandProxyUIProcessTask.ProcessResult)localProfileResult);
      AppMethodBeat.o(50656);
      return;
    }
    int i = ((ProfileRequest)paramProcessRequest).scene;
    String str = ((ProfileRequest)paramProcessRequest).username;
    Object localObject = ((n)com.tencent.mm.kernel.h.ax(n.class)).bzA().JE(str);
    if (localObject != null)
    {
      paramProcessRequest = (AppBrandProxyUIProcessTask.ProcessRequest)localObject;
      if ((int)((com.tencent.mm.contact.d)localObject).maN > 0) {}
    }
    else
    {
      paramProcessRequest = ((n)com.tencent.mm.kernel.h.ax(n.class)).bzA().bxs(str);
    }
    if ((paramProcessRequest != null) && ((int)paramProcessRequest.maN > 0))
    {
      localObject = new Intent();
      ((Intent)localObject).putExtra("Contact_User", str);
      localProfileResult.username = paramProcessRequest.field_username;
      if (paramProcessRequest.iZC())
      {
        com.tencent.mm.plugin.report.service.h.OAn.kvStat(10298, paramProcessRequest.field_username + ',' + i);
        localProfileResult.sqJ |= 0x1;
        ((Intent)localObject).putExtra("Contact_Scene", i);
      }
      if (com.tencent.mm.contact.d.rs(paramProcessRequest.field_type))
      {
        localProfileResult.sqJ |= 0x2;
        paramProcessRequest = new xc();
        paramProcessRequest.iaC.intent = ((Intent)localObject);
        paramProcessRequest.iaC.username = str;
        paramProcessRequest.publish();
      }
      localProfileResult.resultCode = 1;
      finishProcess((AppBrandProxyUIProcessTask.ProcessResult)localProfileResult);
      AppMethodBeat.o(50656);
      return;
    }
    Log.i("ProfileTask", "handleRequest, request contact info");
    paramProcessRequest = (Context)getActivityContext();
    getActivityContext().getString(ba.i.app_tip);
    paramProcessRequest = k.a(paramProcessRequest, getActivityContext().getString(ba.i.app_waiting), true, new d..ExternalSyntheticLambda0(str, localProfileResult, this));
    az.a.okP.a(str, "", new d..ExternalSyntheticLambda1(this, localProfileResult, paramProcessRequest, i));
    AppMethodBeat.o(50656);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.profile.d
 * JD-Core Version:    0.7.0.1
 */