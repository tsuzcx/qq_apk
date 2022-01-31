package com.tencent.mm.plugin.appbrand.jsapi;

import android.content.Context;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import com.tencent.mm.h.a.pk;
import com.tencent.mm.model.am.a;
import com.tencent.mm.model.am.b;
import com.tencent.mm.model.am.b.a;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.ProcessRequest;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.ProcessResult;
import com.tencent.mm.plugin.appbrand.y.j;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bd;
import com.tencent.mm.ui.MMActivity;

final class JsApiProfile$b
  extends AppBrandProxyUIProcessTask
{
  protected final void a(AppBrandProxyUIProcessTask.ProcessRequest paramProcessRequest)
  {
    a.d.b.g.k(paramProcessRequest, "request");
    JsApiProfile.ProfileResult localProfileResult = new JsApiProfile.ProfileResult();
    if (!(paramProcessRequest instanceof JsApiProfile.ProfileRequest))
    {
      y.w("MicroMsg.JsApiProfile", "handleRequest !(request instanceof ProfileRequest)");
      localProfileResult.aYY = 0;
      a((AppBrandProxyUIProcessTask.ProcessResult)localProfileResult);
      return;
    }
    int i = ((JsApiProfile.ProfileRequest)paramProcessRequest).scene;
    String str = ((JsApiProfile.ProfileRequest)paramProcessRequest).username;
    com.tencent.mm.kernel.g.DN();
    if (!com.tencent.mm.kernel.a.Db())
    {
      y.e("MicroMsg.JsApiProfile", "doProfile, MMKernel.account().hasLogin() is false");
      localProfileResult.aYY = 0;
      a((AppBrandProxyUIProcessTask.ProcessResult)localProfileResult);
      return;
    }
    paramProcessRequest = com.tencent.mm.kernel.g.r(j.class);
    a.d.b.g.j(paramProcessRequest, "service(IMessengerStorage::class.java)");
    Object localObject = ((j)paramProcessRequest).Fw().abl(str);
    if (localObject != null)
    {
      paramProcessRequest = (AppBrandProxyUIProcessTask.ProcessRequest)localObject;
      if (((ad)localObject).Bo() > 0) {}
    }
    else
    {
      paramProcessRequest = com.tencent.mm.kernel.g.r(j.class);
      a.d.b.g.j(paramProcessRequest, "service(IMessengerStorage::class.java)");
      paramProcessRequest = ((j)paramProcessRequest).Fw().abh(str);
    }
    if ((paramProcessRequest != null) && (paramProcessRequest.Bo() > 0))
    {
      localObject = new Intent();
      ((Intent)localObject).putExtra("Contact_User", str);
      localProfileResult.username = paramProcessRequest.getUsername();
      if (paramProcessRequest.cua())
      {
        com.tencent.mm.plugin.report.service.h.nFQ.aC(10298, paramProcessRequest.getUsername() + "," + i);
        localProfileResult.ggZ |= 0x1;
        ((Intent)localObject).putExtra("Contact_Scene", i);
      }
      if (paramProcessRequest.Bd())
      {
        localProfileResult.ggZ |= 0x2;
        paramProcessRequest = new pk();
        paramProcessRequest.bYW.intent = ((Intent)localObject);
        paramProcessRequest.bYW.username = str;
        com.tencent.mm.sdk.b.a.udP.m((b)paramProcessRequest);
      }
      localProfileResult.aYY = 1;
      a((AppBrandProxyUIProcessTask.ProcessResult)localProfileResult);
      return;
    }
    paramProcessRequest = (Context)ahy();
    ahy().getString(y.j.app_tip);
    paramProcessRequest = com.tencent.mm.ui.base.h.b(paramProcessRequest, ahy().getString(y.j.app_waiting), true, (DialogInterface.OnCancelListener)new JsApiProfile.b.b(this, str, localProfileResult));
    am.a.Hh().a(str, "", (am.b.a)new JsApiProfile.b.a(this, localProfileResult, paramProcessRequest, i));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.JsApiProfile.b
 * JD-Core Version:    0.7.0.1
 */