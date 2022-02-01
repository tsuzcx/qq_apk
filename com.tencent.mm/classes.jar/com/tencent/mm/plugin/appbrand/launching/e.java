package com.tencent.mm.plugin.appbrand.launching;

import android.util.Pair;
import android.widget.Toast;
import com.tencent.luggage.sdk.config.AppBrandInitConfigLU;
import com.tencent.luggage.sdk.config.b;
import com.tencent.luggage.sdk.launching.ActivityStarterIpcDelegate;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ab.h;
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

public class e
  implements Runnable
{
  protected volatile String appId;
  final AppBrandLaunchReferrer cys;
  protected final int iOo;
  protected AppBrandStatObject kEH;
  protected final String kHw;
  private final a mQB;
  protected final ActivityStarterIpcDelegate mQC;
  protected final int pkgVersion;
  protected volatile String username;
  
  public e(LaunchParcel paramLaunchParcel, a parama)
  {
    this.mQB = parama;
    this.iOo = paramLaunchParcel.iOo;
    this.appId = paramLaunchParcel.appId;
    this.username = paramLaunchParcel.username;
    this.pkgVersion = paramLaunchParcel.version;
    this.kEH = paramLaunchParcel.mYK;
    this.kHw = paramLaunchParcel.kHw;
    this.mQC = paramLaunchParcel.mQC;
    this.cys = paramLaunchParcel.cys;
  }
  
  protected final void a(AppBrandInitConfigLU paramAppBrandInitConfigLU, AppBrandStatObject paramAppBrandStatObject)
  {
    AppMethodBeat.i(147313);
    if (this.mQB != null) {
      this.mQB.a(paramAppBrandInitConfigLU, paramAppBrandStatObject, 1);
    }
    AppMethodBeat.o(147313);
  }
  
  protected Pair<WxaAttributes, Boolean> bNg()
  {
    AppMethodBeat.i(147309);
    ab.bAu();
    Pair localPair = new Pair(ab.e(this.appId, new String[0]), Boolean.FALSE);
    AppMethodBeat.o(147309);
    return localPair;
  }
  
  protected boolean g(WxaAttributes paramWxaAttributes)
  {
    AppMethodBeat.i(147311);
    if ((j.a.vP(this.iOo)) && (1 == paramWxaAttributes.bAp().cyu))
    {
      Toast.makeText(MMApplicationContext.getContext(), 2131755547, 1).show();
      AppMethodBeat.o(147311);
      return true;
    }
    AppMethodBeat.o(147311);
    return false;
  }
  
  protected final void onError()
  {
    AppMethodBeat.i(147312);
    if (this.mQB != null) {
      this.mQB.a(null, null, 2);
    }
    AppMethodBeat.o(147312);
  }
  
  public void run()
  {
    AppMethodBeat.i(147308);
    Object localObject = (WxaAttributes)bNg().first;
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
    AppBrandInitConfigLU localAppBrandInitConfigLU = b.Nw().a((WxaAttributes)localObject);
    if (localAppBrandInitConfigLU == null)
    {
      Log.e("Luggage.AppBrandPreLaunchProcess", "onGetWxaAttr, assembled NULL config with username(%s) appId(%s)", new Object[] { ((WxaAttributes)localObject).field_username, ((WxaAttributes)localObject).field_appId });
      onError();
      AppMethodBeat.o(147308);
      return;
    }
    localAppBrandInitConfigLU.eix = this.iOo;
    this.appId = localAppBrandInitConfigLU.appId;
    this.username = localAppBrandInitConfigLU.username;
    if (this.iOo == 0) {
      localAppBrandInitConfigLU.cBG = ((WxaAttributes)localObject).bAp().lgT;
    }
    for (;;)
    {
      if (this.kEH == null) {
        this.kEH = new AppBrandStatObject();
      }
      a(localAppBrandInitConfigLU, this.kEH);
      AppMethodBeat.o(147308);
      return;
      s.bNx();
      localAppBrandInitConfigLU.extInfo = s.bU(this.appId, this.iOo);
      try
      {
        localObject = h.FE(localAppBrandInitConfigLU.extInfo);
        localAppBrandInitConfigLU.cBG = ((JSONObject)localObject).optString("device_orientation");
        localAppBrandInitConfigLU.cyp = ((JSONObject)localObject).optBoolean("open_remote", false);
        localAppBrandInitConfigLU.cyv = ac.XM(localAppBrandInitConfigLU.extInfo);
      }
      catch (Exception localException) {}
    }
  }
  
  public static abstract interface a<T extends AppBrandInitConfigLU>
  {
    public abstract void a(T paramT, AppBrandStatObject paramAppBrandStatObject, int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.e
 * JD-Core Version:    0.7.0.1
 */