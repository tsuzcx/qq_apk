package com.tencent.mm.plugin.appbrand.launching;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.util.Pair;
import com.tencent.mm.h.b.a.am;
import com.tencent.mm.h.b.a.am.c;
import com.tencent.mm.h.b.a.am.d;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.d;
import com.tencent.mm.plugin.appbrand.launching.params.LaunchParcel;
import com.tencent.mm.plugin.appbrand.r;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.report.quality.QualitySession;
import com.tencent.mm.plugin.appbrand.ui.AppBrand404PageUI;
import com.tencent.mm.plugin.appbrand.y.j;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import org.json.JSONArray;
import org.json.JSONObject;

public final class c
  implements Runnable
{
  private volatile String appId;
  private final int fEN;
  private final int fJy;
  private final String fPq;
  private final c.a gJi;
  private final String gJj = com.tencent.mm.plugin.appbrand.report.quality.d.aox();
  private AppBrandStatObject gJk;
  private final ActivityStarterIpcDelegate gJl;
  private final String username;
  
  public c(LaunchParcel paramLaunchParcel, c.a parama)
  {
    this.gJi = parama;
    this.fJy = paramLaunchParcel.fJy;
    this.appId = paramLaunchParcel.appId;
    this.username = paramLaunchParcel.username;
    this.fEN = paramLaunchParcel.version;
    this.gJk = paramLaunchParcel.gMm;
    this.fPq = paramLaunchParcel.fPq;
    this.gJl = paramLaunchParcel.gJl;
  }
  
  public c(String paramString, int paramInt, AppBrandStatObject paramAppBrandStatObject, ActivityStarterIpcDelegate paramActivityStarterIpcDelegate, c.a parama)
  {
    this.gJi = parama;
    this.appId = paramString;
    this.fJy = paramInt;
    this.username = null;
    this.fEN = 0;
    this.gJk = paramAppBrandStatObject;
    this.fPq = null;
    this.gJl = paramActivityStarterIpcDelegate;
  }
  
  private void onError()
  {
    if (this.gJi != null) {
      this.gJi.c(null, null);
    }
  }
  
  private static boolean uQ(String paramString)
  {
    if (bk.bl(paramString)) {}
    for (;;)
    {
      return false;
      try
      {
        paramString = new JSONObject(paramString).optJSONArray("call_plugin_info");
        if (paramString != null)
        {
          int i = paramString.length();
          if (i > 0) {
            return true;
          }
        }
      }
      catch (Exception paramString) {}
    }
    return false;
  }
  
  public final void run()
  {
    Object localObject1;
    int i;
    for (;;)
    {
      try
      {
        localObject1 = this.username;
        localObject2 = this.appId;
        int j = this.fJy;
        int k = this.fEN;
        if (this.gJk == null)
        {
          i = 0;
          localObject1 = new ab((String)localObject1, (String)localObject2, j, k, i, this.fPq);
        }
      }
      catch (Exception localException2)
      {
        Pair localPair;
        localObject2 = null;
        localObject1 = null;
      }
      try
      {
        localPair = (Pair)((ab)localObject1).alN();
      }
      catch (Exception localException3)
      {
        for (;;)
        {
          Object localObject5;
          Object localObject3;
          Object localObject6;
          Context localContext;
          localObject2 = null;
        }
      }
      try
      {
        localObject2 = (WxaAttributes)localPair.first;
        if (localObject2 != null) {
          break;
        }
        y.i("MicroMsg.AppBrandPreLaunchProcess", "onGetWxaAttr null return");
        onError();
        return;
      }
      catch (Exception localException4)
      {
        localObject2 = localException3;
        Object localObject4 = localException4;
        break label107;
      }
      i = this.gJk.scene;
      continue;
      label107:
      y.printErrStackTrace("MicroMsg.AppBrandPreLaunchProcess", localException2, "get attr ", new Object[0]);
      localObject5 = null;
      localObject3 = localObject2;
      localObject2 = localObject5;
    }
    localObject5 = ((WxaAttributes)localObject2).field_appId;
    localObject6 = new u((String)localObject5);
    if (com.tencent.mm.m.g.AA().getInt("WeAppForbiddenSwitch", 0) == 1)
    {
      y.i("MicroMsg.AppBrand.PreLaunchCheckForOversea", "startApp, WeAppForbiddenSwitch == 1, go webview, appId %s", new Object[] { ((u)localObject6).appId });
      localObject6 = new Intent().putExtra("rawUrl", r.qL(((u)localObject6).appId)).putExtra("forceHideShare", true);
      localContext = ae.getContext();
      if (!(localContext instanceof Activity)) {
        ((Intent)localObject6).addFlags(268435456);
      }
      com.tencent.mm.br.d.b(localContext, "webview", ".ui.tools.WebViewUI", (Intent)localObject6);
      i = 1;
      if (i == 0) {
        break label266;
      }
      i = 1;
    }
    for (;;)
    {
      if (i == 0) {
        break label616;
      }
      onError();
      return;
      i = 0;
      break;
      label266:
      if (2 == this.fJy)
      {
        boolean bool = com.tencent.mm.plugin.appbrand.task.g.wr((String)localObject5);
        i = new ad((String)localObject5, ac.aW((String)localObject5, 2), ac.aW((String)localObject5, 10001), bool).afv();
        y.i("MicroMsg.AppBrand.PrepareStepOpBan", "checkDemoInfo, appId %s, ret %d, ignoreCgiError %b", new Object[] { localObject5, Integer.valueOf(i), Boolean.valueOf(bool) });
        localObject6 = ad.a.lP(i);
        if (localObject6 == null) {
          switch (i)
          {
          default: 
            if (bool) {
              i = 1;
            }
            break;
          }
        }
        for (;;)
        {
          if (i != 0) {
            break label551;
          }
          i = 1;
          break;
          x.lO(y.j.app_brand_demo_pkg_has_been_deleted);
          com.tencent.mm.plugin.appbrand.report.c.H((String)localObject5, 13, 3);
          i = 0;
          continue;
          x.lO(y.j.app_brand_demo_pkg_user_not_in_white_list);
          com.tencent.mm.plugin.appbrand.report.c.H((String)localObject5, 12, 3);
          i = 0;
          continue;
          x.uV(ae.getResources().getString(y.j.app_brand_preparing_comm_err_code, new Object[] { Integer.valueOf(3), Integer.valueOf(i) }));
          i = 0;
          continue;
          if (bool) {
            i = 1;
          } else {
            switch (ac.1.gLw[localObject6.ordinal()])
            {
            default: 
              x.lO(y.j.app_brand_demo_pkg_cgi_fail);
              com.tencent.mm.plugin.appbrand.report.c.H((String)localObject5, 13, 3);
              i = 0;
              break;
            case 1: 
              i = 1;
              break;
            case 2: 
              x.lO(y.j.app_brand_demo_pkg_cgi_timeout);
              com.tencent.mm.plugin.appbrand.report.c.H((String)localObject5, 13, 3);
              i = 0;
            }
          }
        }
      }
      label551:
      if (this.fJy == 0)
      {
        localObject5 = this.gJl;
        if (1 == ((WxaAttributes)localObject2).aep().fPB)
        {
          AppBrand404PageUI.a(y.j.app_brand_launching_release_version_not_published_yet, (ActivityStarterIpcDelegate)localObject5);
          com.tencent.mm.plugin.appbrand.report.c.H(((WxaAttributes)localObject2).field_appId, 14, 1);
        }
        for (i = 0;; i = 1)
        {
          if (i != 0) {
            break label611;
          }
          i = 1;
          break;
        }
      }
      label611:
      i = 0;
    }
    label616:
    com.tencent.mm.plugin.appbrand.config.g.aed();
    localObject5 = com.tencent.mm.plugin.appbrand.config.g.a((WxaAttributes)localObject2);
    ((AppBrandInitConfigWC)localObject5).fEL = this.fJy;
    this.appId = ((AppBrandInitConfigWC)localObject5).appId;
    ((AppBrandInitConfigWC)localObject5).fPC = new QualitySession(this.gJj, (AppBrandInitConfigWC)localObject5, this.gJk);
    if (((Boolean)((Pair)localObject3).second).booleanValue())
    {
      ((AppBrandInitConfigWC)localObject5).fPD = true;
      localObject3 = com.tencent.mm.plugin.appbrand.report.quality.d.a(((AppBrandInitConfigWC)localObject5).fPC);
      ((am)localObject3).cns = am.d.cnJ;
      localObject1 = ((am)localObject3).aF(((ab)localObject1).gLb).aG(((ab)localObject1).gLc).aD(((ab)localObject1).gLd);
      ((am)localObject1).cnt = am.c.cnG;
      ((am)localObject1).cis = com.tencent.mm.plugin.appbrand.report.quality.d.getNetworkType();
      ((am)localObject1).QX();
      label756:
      if (this.fJy != 0) {
        break label856;
      }
      ((AppBrandInitConfigWC)localObject5).fNK = ((WxaAttributes)localObject2).aep().fRs;
      ((AppBrandInitConfigWC)localObject5).fPA = ((WxaAttributes)localObject2).aep().fPA;
    }
    for (;;)
    {
      ((AppBrandInitConfigWC)localObject5).fPz = uQ(((AppBrandInitConfigWC)localObject5).fPA);
      if (this.gJk == null) {
        this.gJk = new AppBrandStatObject();
      }
      localObject1 = this.gJk;
      if (this.gJi == null) {
        break;
      }
      this.gJi.c((AppBrandInitConfigWC)localObject5, (AppBrandStatObject)localObject1);
      return;
      ((AppBrandInitConfigWC)localObject5).fPD = false;
      break label756;
      label856:
      ((AppBrandInitConfigWC)localObject5).extInfo = ((h)com.tencent.mm.plugin.appbrand.app.e.G(h.class)).aV(this.appId, this.fJy);
      try
      {
        localObject1 = com.tencent.mm.ab.h.fU(((AppBrandInitConfigWC)localObject5).extInfo);
        ((AppBrandInitConfigWC)localObject5).fNK = ((JSONObject)localObject1).optString("device_orientation");
        ((AppBrandInitConfigWC)localObject5).fPA = ((JSONObject)localObject1).optString("client_js_ext_info");
        ((AppBrandInitConfigWC)localObject5).fPx = ((JSONObject)localObject1).optBoolean("open_remote", false);
      }
      catch (Exception localException1) {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.c
 * JD-Core Version:    0.7.0.1
 */