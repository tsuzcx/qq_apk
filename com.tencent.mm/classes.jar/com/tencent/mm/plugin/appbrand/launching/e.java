package com.tencent.mm.plugin.appbrand.launching;

import android.util.Pair;
import android.widget.Toast;
import com.tencent.luggage.sdk.config.AppBrandInitConfigLU;
import com.tencent.luggage.sdk.config.b;
import com.tencent.luggage.sdk.launching.ActivityStarterIpcDelegate;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ac.h;
import com.tencent.mm.plugin.appbrand.appcache.j.a;
import com.tencent.mm.plugin.appbrand.config.AppBrandLaunchReferrer;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.WxaVersionInfo;
import com.tencent.mm.plugin.appbrand.config.x;
import com.tencent.mm.plugin.appbrand.config.y;
import com.tencent.mm.plugin.appbrand.launching.params.LaunchParcel;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import org.json.JSONObject;

public class e
  implements Runnable
{
  protected volatile String appId;
  final AppBrandLaunchReferrer cfi;
  protected final int gXn;
  protected AppBrandStatObject iJL;
  protected final String iJb;
  private final a kFW;
  protected final ActivityStarterIpcDelegate kFX;
  protected final int pkgVersion;
  protected final String username;
  
  public e(LaunchParcel paramLaunchParcel, a parama)
  {
    this.kFW = parama;
    this.gXn = paramLaunchParcel.gXn;
    this.appId = paramLaunchParcel.appId;
    this.username = paramLaunchParcel.username;
    this.pkgVersion = paramLaunchParcel.version;
    this.iJL = paramLaunchParcel.kOh;
    this.iJb = paramLaunchParcel.iJb;
    this.kFX = paramLaunchParcel.kFX;
    this.cfi = paramLaunchParcel.cfi;
  }
  
  protected final void b(AppBrandInitConfigLU paramAppBrandInitConfigLU, AppBrandStatObject paramAppBrandStatObject)
  {
    AppMethodBeat.i(147313);
    if (this.kFW != null) {
      this.kFW.a(paramAppBrandInitConfigLU, paramAppBrandStatObject);
    }
    AppMethodBeat.o(147313);
  }
  
  protected Pair<WxaAttributes, Boolean> bgg()
  {
    AppMethodBeat.i(147309);
    x.aTU();
    Pair localPair = new Pair(x.e(this.appId, new String[0]), Boolean.FALSE);
    AppMethodBeat.o(147309);
    return localPair;
  }
  
  protected boolean f(WxaAttributes paramWxaAttributes)
  {
    AppMethodBeat.i(147311);
    if ((j.a.qD(this.gXn)) && (1 == paramWxaAttributes.aTP().cfk))
    {
      Toast.makeText(aj.getContext(), 2131755509, 1).show();
      AppMethodBeat.o(147311);
      return true;
    }
    AppMethodBeat.o(147311);
    return false;
  }
  
  protected final void onError()
  {
    AppMethodBeat.i(147312);
    if (this.kFW != null) {
      this.kFW.a(null, null);
    }
    AppMethodBeat.o(147312);
  }
  
  public void run()
  {
    AppMethodBeat.i(147308);
    Object localObject = (WxaAttributes)bgg().first;
    if (localObject == null)
    {
      ad.i("Luggage.AppBrandPreLaunchProcess", "onGetWxaAttr null return");
      onError();
      AppMethodBeat.o(147308);
      return;
    }
    if (f((WxaAttributes)localObject))
    {
      onError();
      AppMethodBeat.o(147308);
      return;
    }
    AppBrandInitConfigLU localAppBrandInitConfigLU = b.CV().a((WxaAttributes)localObject);
    localAppBrandInitConfigLU.iOP = this.gXn;
    this.appId = localAppBrandInitConfigLU.appId;
    if (this.gXn == 0) {
      localAppBrandInitConfigLU.jbC = ((WxaAttributes)localObject).aTP().jfz;
    }
    for (;;)
    {
      if (this.iJL == null) {
        this.iJL = new AppBrandStatObject();
      }
      b(localAppBrandInitConfigLU, this.iJL);
      AppMethodBeat.o(147308);
      return;
      s.bgx();
      localAppBrandInitConfigLU.extInfo = s.bG(this.appId, this.gXn);
      try
      {
        localObject = h.qE(localAppBrandInitConfigLU.extInfo);
        localAppBrandInitConfigLU.jbC = ((JSONObject)localObject).optString("device_orientation");
        localAppBrandInitConfigLU.cfe = ((JSONObject)localObject).optBoolean("open_remote", false);
        localAppBrandInitConfigLU.cfl = y.Gx(localAppBrandInitConfigLU.extInfo);
      }
      catch (Exception localException) {}
    }
  }
  
  public static abstract interface a<T extends AppBrandInitConfigLU>
  {
    public abstract void a(T paramT, AppBrandStatObject paramAppBrandStatObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.e
 * JD-Core Version:    0.7.0.1
 */