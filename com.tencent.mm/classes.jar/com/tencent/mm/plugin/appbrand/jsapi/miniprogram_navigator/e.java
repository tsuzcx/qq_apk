package com.tencent.mm.plugin.appbrand.jsapi.miniprogram_navigator;

import android.content.Intent;
import com.tencent.mm.model.gdpr.a;
import com.tencent.mm.model.gdpr.c;
import com.tencent.mm.plugin.appbrand.MiniProgramNavigationBackResult;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfig;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.config.AppBrandLaunchReferrer;
import com.tencent.mm.plugin.appbrand.d;
import com.tencent.mm.plugin.appbrand.i;
import com.tencent.mm.plugin.appbrand.launching.AppBrandPreInitTask;
import com.tencent.mm.plugin.appbrand.m;
import com.tencent.mm.plugin.appbrand.n;
import com.tencent.mm.plugin.appbrand.o;
import com.tencent.mm.plugin.appbrand.page.q;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity.a;
import org.json.JSONObject;

final class e
{
  private static final int gwY = e.class.hashCode() & 0xFFFF;
  
  static void a(d paramd, String paramString1, int paramInt, String paramString2, e.a parama, JSONObject paramJSONObject1, JSONObject paramJSONObject2, e.b paramb)
  {
    String str = paramd.getAppId();
    int i;
    Object localObject1;
    label63:
    Object localObject2;
    if (parama != null)
    {
      i = parama.bIl;
      y.i("MicroMsg.MiniProgramNavigator", "navigateTo fromAppID(%s) targetAppID(%s) sourceType:%d", new Object[] { str, paramString1, Integer.valueOf(i) });
      str = "";
      if (!(paramd instanceof q)) {
        break label502;
      }
      localObject1 = (q)paramd;
      if (localObject1 != null) {
        str = ((q)localObject1).ahc();
      }
      localObject2 = (n)paramd.getRuntime();
      localObject1 = paramd.getAppId() + ":" + ((n)localObject2).aac().fJO + ":" + (paramd.getRuntime().ZA().bFB + 1000);
      AppBrandStatObject localAppBrandStatObject = ((n)localObject2).aab();
      localObject2 = new AppBrandStatObject();
      if ((parama == null) || (parama.scene == 0)) {
        break label516;
      }
      i = parama.scene;
      label177:
      ((AppBrandStatObject)localObject2).scene = i;
      ((AppBrandStatObject)localObject2).caA = localAppBrandStatObject.caA;
      if ((parama == null) || (parama.scene == 0) || (bk.bl(parama.bFv))) {
        break label524;
      }
      localObject1 = String.format("%s:%s", new Object[] { localObject1, parama.bFv });
      label242:
      ((AppBrandStatObject)localObject2).bFv = ((String)localObject1);
      if (parama == null) {
        break label527;
      }
      i = parama.caB;
      label261:
      ((AppBrandStatObject)localObject2).caB = i;
      if (parama == null) {
        break label533;
      }
      localObject1 = parama.caC;
      label280:
      ((AppBrandStatObject)localObject2).caC = ((String)localObject1);
      if (parama == null) {
        break label539;
      }
      localObject1 = parama.gxg;
      label299:
      ((AppBrandStatObject)localObject2).gxg = ((String)localObject1);
      localObject1 = new AppBrandLaunchReferrer();
      ((AppBrandLaunchReferrer)localObject1).appId = paramd.getAppId();
      if (paramJSONObject1 != null) {
        break label545;
      }
      paramJSONObject1 = "{}";
      label333:
      ((AppBrandLaunchReferrer)localObject1).fPG = paramJSONObject1;
      if (paramJSONObject2 != null) {
        break label555;
      }
      paramJSONObject1 = "{}";
      label349:
      ((AppBrandLaunchReferrer)localObject1).fPH = paramJSONObject1;
      ((AppBrandLaunchReferrer)localObject1).fPF = 1;
      ((AppBrandLaunchReferrer)localObject1).url = str;
      if (parama == null) {
        break label565;
      }
      i = parama.bIl;
      label381:
      ((AppBrandLaunchReferrer)localObject1).bIl = i;
      if (parama == null) {
        break label571;
      }
    }
    label516:
    label524:
    label527:
    label533:
    label539:
    label545:
    label555:
    label565:
    label571:
    for (parama = parama.fPI;; parama = null)
    {
      ((AppBrandLaunchReferrer)localObject1).fPI = parama;
      long l = bk.UY();
      m.qI(paramd.getAppId()).fzx = paramString1;
      m.qI(paramd.getAppId()).fzy = paramString2;
      paramString2 = new AppBrandPreInitTask(paramd.getContext(), paramString1, paramInt, (AppBrandStatObject)localObject2, new e.1(paramb, paramString1, paramString2, (AppBrandStatObject)localObject2, l, (AppBrandLaunchReferrer)localObject1, paramd, paramInt));
      if (!c.IO()) {
        break label577;
      }
      c.a(paramd.getContext(), a.dYt, paramString1, new e.2(paramString2, paramd));
      return;
      i = 0;
      break;
      label502:
      localObject1 = ((o)paramd).E(q.class);
      break label63;
      i = 1037;
      break label177;
      break label242;
      i = 0;
      break label261;
      localObject1 = null;
      break label280;
      localObject1 = null;
      break label299;
      paramJSONObject1 = paramJSONObject1.toString();
      break label333;
      paramJSONObject1 = paramJSONObject2.toString();
      break label349;
      i = 0;
      break label381;
    }
    label577:
    paramString2.alC();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.miniprogram_navigator.e
 * JD-Core Version:    0.7.0.1
 */