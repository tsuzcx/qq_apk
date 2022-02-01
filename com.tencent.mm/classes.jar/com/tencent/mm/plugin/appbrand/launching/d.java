package com.tencent.mm.plugin.appbrand.launching;

import android.util.Pair;
import android.widget.Toast;
import com.tencent.luggage.l.a.g;
import com.tencent.luggage.sdk.config.AppBrandInitConfigLU;
import com.tencent.luggage.sdk.config.b;
import com.tencent.luggage.sdk.launching.ActivityStarterIpcDelegate;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ad.h;
import com.tencent.mm.plugin.appbrand.appcache.j.a;
import com.tencent.mm.plugin.appbrand.config.AppBrandLaunchReferrer;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.WxaVersionInfo;
import com.tencent.mm.plugin.appbrand.config.ab;
import com.tencent.mm.plugin.appbrand.config.ac;
import com.tencent.mm.plugin.appbrand.launching.params.LaunchParcel;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import org.json.JSONObject;

public class d
  implements Runnable
{
  protected volatile String appId;
  protected final int cBU;
  final AppBrandLaunchReferrer cwV;
  protected final String nBq;
  protected AppBrandStatObject nyh;
  private final d.a pRx;
  protected final ActivityStarterIpcDelegate pRy;
  protected final int pkgVersion;
  protected volatile String username;
  
  public d(LaunchParcel paramLaunchParcel, d.a parama)
  {
    this.pRx = parama;
    this.cBU = paramLaunchParcel.cBU;
    this.appId = paramLaunchParcel.appId;
    this.username = paramLaunchParcel.username;
    this.pkgVersion = paramLaunchParcel.version;
    this.nyh = paramLaunchParcel.pdk;
    this.nBq = paramLaunchParcel.nBq;
    this.pRy = paramLaunchParcel.pRy;
    this.cwV = paramLaunchParcel.cwV;
  }
  
  protected final void a(AppBrandInitConfigLU paramAppBrandInitConfigLU, AppBrandStatObject paramAppBrandStatObject)
  {
    AppMethodBeat.i(147313);
    if (this.pRx != null) {
      this.pRx.a(paramAppBrandInitConfigLU, paramAppBrandStatObject, 1);
    }
    AppMethodBeat.o(147313);
  }
  
  protected Pair<WxaAttributes, Boolean> bZx()
  {
    AppMethodBeat.i(147309);
    ab.bLM();
    Pair localPair = new Pair(ab.d(this.appId, new String[0]), Boolean.FALSE);
    AppMethodBeat.o(147309);
    return localPair;
  }
  
  protected boolean g(WxaAttributes paramWxaAttributes)
  {
    AppMethodBeat.i(147311);
    if ((j.a.za(this.cBU)) && (1 == paramWxaAttributes.bLH().cwX))
    {
      Toast.makeText(MMApplicationContext.getContext(), a.g.app_brand_launching_release_version_not_published_yet, 1).show();
      AppMethodBeat.o(147311);
      return true;
    }
    AppMethodBeat.o(147311);
    return false;
  }
  
  protected final void onError()
  {
    AppMethodBeat.i(147312);
    if (this.pRx != null) {
      this.pRx.a(null, null, 2);
    }
    AppMethodBeat.o(147312);
  }
  
  public void run()
  {
    AppMethodBeat.i(147308);
    Object localObject = (WxaAttributes)bZx().first;
    if (localObject == null)
    {
      Log.i("Luggage.AppBrandPreLaunchProcess", "onGetWxaAttr null return");
      onError();
      AppMethodBeat.o(147308);
      return;
    }
    if (g((WxaAttributes)localObject))
    {
      onError();
      AppMethodBeat.o(147308);
      return;
    }
    AppBrandInitConfigLU localAppBrandInitConfigLU = b.Qr().a((WxaAttributes)localObject);
    if (localAppBrandInitConfigLU == null)
    {
      Log.e("Luggage.AppBrandPreLaunchProcess", "onGetWxaAttr, assembled NULL config with username(%s) appId(%s)", new Object[] { ((WxaAttributes)localObject).field_username, ((WxaAttributes)localObject).field_appId });
      onError();
      AppMethodBeat.o(147308);
      return;
    }
    localAppBrandInitConfigLU.cBI = this.cBU;
    this.appId = localAppBrandInitConfigLU.appId;
    this.username = localAppBrandInitConfigLU.username;
    if (this.cBU == 0) {
      localAppBrandInitConfigLU.cCi = ((WxaAttributes)localObject).bLH().obz;
    }
    for (;;)
    {
      if (this.nyh == null) {
        this.nyh = new AppBrandStatObject();
      }
      a(localAppBrandInitConfigLU, this.nyh);
      AppMethodBeat.o(147308);
      return;
      r.bZP();
      localAppBrandInitConfigLU.extInfo = r.cs(this.appId, this.cBU);
      try
      {
        localObject = h.ME(localAppBrandInitConfigLU.extInfo);
        localAppBrandInitConfigLU.cCi = ((JSONObject)localObject).optString("device_orientation");
        localAppBrandInitConfigLU.cwS = ((JSONObject)localObject).optBoolean("open_remote", false);
        localAppBrandInitConfigLU.cwY = ac.afy(localAppBrandInitConfigLU.extInfo);
      }
      catch (Exception localException) {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.d
 * JD-Core Version:    0.7.0.1
 */