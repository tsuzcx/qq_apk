package com.tencent.mm.plugin.appbrand.jsapi.miniprogram_navigator;

import android.app.Activity;
import com.tencent.mm.plugin.appbrand.a;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.config.AppBrandLaunchReferrer;
import com.tencent.mm.plugin.appbrand.g;
import com.tencent.mm.plugin.appbrand.g.c;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.MMToClientEvent;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.jsapi.i;
import com.tencent.mm.plugin.appbrand.launching.AppBrandLaunchProxyUI;
import com.tencent.mm.plugin.appbrand.n;
import com.tencent.mm.plugin.appbrand.o;
import com.tencent.mm.plugin.appbrand.p;
import com.tencent.mm.plugin.appbrand.page.q;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import junit.framework.Assert;

final class JsApiLaunchMiniProgram$1
  implements Runnable
{
  JsApiLaunchMiniProgram$1(JsApiLaunchMiniProgram paramJsApiLaunchMiniProgram, p paramp, String paramString1, int paramInt1, String paramString2, String paramString3, int paramInt2) {}
  
  public final void run()
  {
    Object localObject3 = this.gwK;
    p localp = this.gbW;
    String str1 = this.val$appId;
    int i = this.gwI;
    String str2 = this.dlh;
    String str3 = this.gwJ;
    int j = this.dIS;
    Object localObject1 = new JsApiLaunchMiniProgram.LaunchPreconditionTask();
    JsApiLaunchMiniProgram.LaunchPreconditionTask.a((JsApiLaunchMiniProgram.LaunchPreconditionTask)localObject1, str1);
    JsApiLaunchMiniProgram.LaunchPreconditionTask.a((JsApiLaunchMiniProgram.LaunchPreconditionTask)localObject1, i);
    if (!AppBrandMainProcessService.b((MainProcessTask)localObject1)) {
      localp.C(j, ((i)localObject3).h("fail precondition error", null));
    }
    do
    {
      return;
      localObject2 = JsApiLaunchMiniProgram.LaunchPreconditionTask.a.ly(JsApiLaunchMiniProgram.LaunchPreconditionTask.a((JsApiLaunchMiniProgram.LaunchPreconditionTask)localObject1));
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = JsApiLaunchMiniProgram.LaunchPreconditionTask.a.gwQ;
      }
      if (JsApiLaunchMiniProgram.LaunchPreconditionTask.a.gwS != localObject1)
      {
        localp.C(j, ((i)localObject3).h(((JsApiLaunchMiniProgram.LaunchPreconditionTask.a)localObject1).bHk, null));
        return;
      }
      g.a(localp.mAppId, g.c.fyf);
      MMToClientEvent.a(localp.mAppId, new JsApiLaunchMiniProgram.2((JsApiLaunchMiniProgram)localObject3, str1, i, localp, j));
    } while ((localp.getContext() == null) || (!(localp.getContext() instanceof Activity)) || (((Activity)localp.getContext()).isFinishing()));
    Object localObject2 = new AppBrandStatObject();
    ((AppBrandStatObject)localObject2).scene = 1037;
    localObject1 = a.qp(localp.mAppId);
    if (localObject1 != null) {
      ((AppBrandStatObject)localObject2).caA = ((AppBrandStatObject)localObject1).caA;
    }
    localObject1 = "";
    localObject3 = localp.E(q.class);
    if (localObject3 != null) {
      localObject1 = ((q)localObject3).ahc();
    }
    ((AppBrandStatObject)localObject2).bFv = (localp.mAppId + ":" + localp.getRuntime().aac().fJO);
    localObject3 = new AppBrandLaunchReferrer();
    ((AppBrandLaunchReferrer)localObject3).appId = localp.mAppId;
    ((AppBrandLaunchReferrer)localObject3).fPG = str3;
    ((AppBrandLaunchReferrer)localObject3).fPF = 1;
    ((AppBrandLaunchReferrer)localObject3).url = ((String)localObject1);
    AppBrandLaunchProxyUI.a(localp.getContext(), null, str1, str2, i, -1, (AppBrandStatObject)localObject2, (AppBrandLaunchReferrer)localObject3, null);
    Assert.assertTrue(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.miniprogram_navigator.JsApiLaunchMiniProgram.1
 * JD-Core Version:    0.7.0.1
 */