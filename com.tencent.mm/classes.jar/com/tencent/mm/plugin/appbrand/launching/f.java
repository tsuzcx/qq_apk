package com.tencent.mm.plugin.appbrand.launching;

import android.util.Pair;
import android.widget.Toast;
import com.tencent.luggage.m.a.g;
import com.tencent.luggage.sdk.config.AppBrandInitConfigLU;
import com.tencent.luggage.sdk.config.b;
import com.tencent.luggage.sdk.launching.ActivityStarterIpcDelegate;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ad.h;
import com.tencent.mm.plugin.appbrand.appcache.k.a;
import com.tencent.mm.plugin.appbrand.config.AppBrandLaunchReferrer;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.WxaVersionInfo;
import com.tencent.mm.plugin.appbrand.config.ai;
import com.tencent.mm.plugin.appbrand.config.aj;
import com.tencent.mm.plugin.appbrand.launching.params.LaunchParcel;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import org.json.JSONObject;

public class f
  implements Runnable
{
  protected volatile String appId;
  final AppBrandLaunchReferrer eoV;
  protected final int euz;
  protected final int pkgVersion;
  protected final String qAF;
  protected AppBrandStatObject qxv;
  private final a sWk;
  protected final ActivityStarterIpcDelegate sWl;
  protected volatile String username;
  
  public f(LaunchParcel paramLaunchParcel, a parama)
  {
    this.sWk = parama;
    this.euz = paramLaunchParcel.euz;
    this.appId = paramLaunchParcel.appId;
    this.username = paramLaunchParcel.username;
    this.pkgVersion = paramLaunchParcel.version;
    this.qxv = paramLaunchParcel.siB;
    this.qAF = paramLaunchParcel.qAF;
    this.sWl = paramLaunchParcel.sWl;
    this.eoV = paramLaunchParcel.eoV;
  }
  
  protected final void atR()
  {
    AppMethodBeat.i(147312);
    if (this.sWk != null) {
      this.sWk.onResult(null, null, 2);
    }
    AppMethodBeat.o(147312);
  }
  
  protected final void b(AppBrandInitConfigLU paramAppBrandInitConfigLU, AppBrandStatObject paramAppBrandStatObject)
  {
    AppMethodBeat.i(147313);
    if (this.sWk != null) {
      this.sWk.onResult(paramAppBrandInitConfigLU, paramAppBrandStatObject, 1);
    }
    AppMethodBeat.o(147313);
  }
  
  protected Pair<WxaAttributes, Boolean> czI()
  {
    AppMethodBeat.i(147309);
    ai.clk();
    Pair localPair = new Pair(ai.e(this.appId, new String[0]), Boolean.FALSE);
    AppMethodBeat.o(147309);
    return localPair;
  }
  
  protected boolean i(WxaAttributes paramWxaAttributes)
  {
    AppMethodBeat.i(147311);
    if ((k.a.zn(this.euz)) && (1 == paramWxaAttributes.clf().eoZ))
    {
      Toast.makeText(MMApplicationContext.getContext(), a.g.app_brand_launching_release_version_not_published_yet, 1).show();
      AppMethodBeat.o(147311);
      return true;
    }
    AppMethodBeat.o(147311);
    return false;
  }
  
  public void run()
  {
    AppMethodBeat.i(147308);
    Object localObject = (WxaAttributes)czI().first;
    if (localObject == null)
    {
      Log.i("Luggage.AppBrandPreLaunchProcess", "onGetWxaAttr null return");
      atR();
      AppMethodBeat.o(147308);
      return;
    }
    if (i((WxaAttributes)localObject))
    {
      atR();
      AppMethodBeat.o(147308);
      return;
    }
    AppBrandInitConfigLU localAppBrandInitConfigLU = b.aqB().a((WxaAttributes)localObject);
    if (localAppBrandInitConfigLU == null)
    {
      Log.e("Luggage.AppBrandPreLaunchProcess", "onGetWxaAttr, assembled NULL config with username(%s) appId(%s)", new Object[] { ((WxaAttributes)localObject).field_username, ((WxaAttributes)localObject).field_appId });
      atR();
      AppMethodBeat.o(147308);
      return;
    }
    localAppBrandInitConfigLU.eul = this.euz;
    this.appId = localAppBrandInitConfigLU.appId;
    this.username = localAppBrandInitConfigLU.username;
    if (this.euz == 0) {
      localAppBrandInitConfigLU.euP = ((WxaAttributes)localObject).clf().rcm;
    }
    for (;;)
    {
      if (this.qxv == null) {
        this.qxv = new AppBrandStatObject();
      }
      b(localAppBrandInitConfigLU, this.qxv);
      AppMethodBeat.o(147308);
      return;
      s.cAa();
      localAppBrandInitConfigLU.extInfo = s.cR(this.appId, this.euz);
      try
      {
        localObject = h.Fn(localAppBrandInitConfigLU.extInfo);
        localAppBrandInitConfigLU.euP = ((JSONObject)localObject).optString("device_orientation");
        localAppBrandInitConfigLU.eoX = ((JSONObject)localObject).optBoolean("open_remote", false);
        localAppBrandInitConfigLU.epa = aj.Ya(localAppBrandInitConfigLU.extInfo);
      }
      catch (Exception localException) {}
    }
  }
  
  public static abstract interface a<T extends AppBrandInitConfigLU>
  {
    public abstract void onResult(T paramT, AppBrandStatObject paramAppBrandStatObject, int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.f
 * JD-Core Version:    0.7.0.1
 */