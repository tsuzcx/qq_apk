package com.tencent.mm.plugin.appbrand.permission;

import android.content.res.Resources;
import android.util.SparseIntArray;
import com.tencent.mm.plugin.appbrand.i;
import com.tencent.mm.plugin.appbrand.jsapi.b;
import com.tencent.mm.plugin.appbrand.v.c;
import com.tencent.mm.plugin.appbrand.y.j;
import com.tencent.mm.sdk.platformtools.ae;
import java.util.HashSet;
import java.util.Set;

final class a
{
  private static final SparseIntArray gWA = new a.1();
  private static final Set<String> gWB = new HashSet();
  
  static
  {
    gWA.put("requestPayment".hashCode(), y.j.app_brand_jsapi_ban_banner_hint_api_name_pay);
    gWA.put("playVoice".hashCode(), y.j.app_brand_jsapi_ban_banner_hint_api_name_play);
    gWA.put("operateMusicPlayer".hashCode(), y.j.app_brand_jsapi_ban_banner_hint_api_name_play);
    gWA.put("shareAppMessage".hashCode(), y.j.app_brand_jsapi_ban_banner_hint_api_name_share);
    gWA.put("onShareAppMessage".hashCode(), y.j.app_brand_jsapi_ban_banner_hint_api_name_share);
    gWA.put("shareAppMessageDirectly".hashCode(), y.j.app_brand_jsapi_ban_banner_hint_api_name_share);
    gWA.put("shareTimeline".hashCode(), y.j.app_brand_jsapi_ban_banner_hint_api_name_share);
    gWA.put("onMenuShareTimeline".hashCode(), y.j.app_brand_jsapi_ban_banner_hint_api_name_share);
    gWA.put("launchMiniProgram".hashCode(), y.j.app_brand_jsapi_ban_banner_hint_api_name_launch);
    gWB.add("requestPayment");
    gWB.add("playVoice");
    gWB.add("operateMusicPlayer");
    gWB.add("shareAppMessage");
    gWB.add("onShareAppMessage");
    gWB.add("shareAppMessageDirectly");
    gWB.add("shareTimeline");
    gWB.add("onMenuShareTimeline");
    gWB.add("launchMiniProgram");
    gWB.add("makeVoIPCall");
    gWB.add("addCard");
    gWB.add("chooseContact");
    gWB.add("openCard");
    gWB.add("openOfflinePayView");
  }
  
  static void a(i parami, b paramb)
  {
    if ((parami == null) || (paramb == null)) {}
    while (!gWB.contains(paramb.getName())) {
      return;
    }
    paramb = ae.getResources().getString(gWA.get(paramb.getName().hashCode()));
    c.runOnUiThread(new a.2(parami, ae.getResources().getString(y.j.app_brand_jsapi_ban_banner_hint_format_wording, new Object[] { paramb })));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.permission.a
 * JD-Core Version:    0.7.0.1
 */