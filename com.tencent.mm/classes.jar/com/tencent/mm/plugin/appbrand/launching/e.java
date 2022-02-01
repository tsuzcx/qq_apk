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
import com.tencent.mm.plugin.appbrand.config.y;
import com.tencent.mm.plugin.appbrand.config.z;
import com.tencent.mm.plugin.appbrand.launching.params.LaunchParcel;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import org.json.JSONObject;

public class e
  implements Runnable
{
  protected volatile String appId;
  final AppBrandLaunchReferrer cmx;
  protected final int hSZ;
  protected final String jFL;
  protected AppBrandStatObject jGF;
  private final a lIO;
  protected final ActivityStarterIpcDelegate lIP;
  protected final int pkgVersion;
  protected volatile String username;
  
  public e(LaunchParcel paramLaunchParcel, a parama)
  {
    this.lIO = parama;
    this.hSZ = paramLaunchParcel.hSZ;
    this.appId = paramLaunchParcel.appId;
    this.username = paramLaunchParcel.username;
    this.pkgVersion = paramLaunchParcel.version;
    this.jGF = paramLaunchParcel.lRA;
    this.jFL = paramLaunchParcel.jFL;
    this.lIP = paramLaunchParcel.lIP;
    this.cmx = paramLaunchParcel.cmx;
  }
  
  protected final void b(AppBrandInitConfigLU paramAppBrandInitConfigLU, AppBrandStatObject paramAppBrandStatObject)
  {
    AppMethodBeat.i(147313);
    if (this.lIO != null) {
      this.lIO.a(paramAppBrandInitConfigLU, paramAppBrandStatObject);
    }
    AppMethodBeat.o(147313);
  }
  
  protected Pair<WxaAttributes, Boolean> brv()
  {
    AppMethodBeat.i(147309);
    y.bfa();
    Pair localPair = new Pair(y.e(this.appId, new String[0]), Boolean.FALSE);
    AppMethodBeat.o(147309);
    return localPair;
  }
  
  protected boolean g(WxaAttributes paramWxaAttributes)
  {
    AppMethodBeat.i(147311);
    if ((j.a.rT(this.hSZ)) && (1 == paramWxaAttributes.beV().cmz))
    {
      Toast.makeText(ak.getContext(), 2131755509, 1).show();
      AppMethodBeat.o(147311);
      return true;
    }
    AppMethodBeat.o(147311);
    return false;
  }
  
  protected final void onError()
  {
    AppMethodBeat.i(147312);
    if (this.lIO != null) {
      this.lIO.a(null, null);
    }
    AppMethodBeat.o(147312);
  }
  
  public void run()
  {
    AppMethodBeat.i(147308);
    Object localObject = (WxaAttributes)brv().first;
    if (localObject == null)
    {
      ae.i("Luggage.AppBrandPreLaunchProcess", "onGetWxaAttr null return");
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
    AppBrandInitConfigLU localAppBrandInitConfigLU = b.Ea().a((WxaAttributes)localObject);
    if (localAppBrandInitConfigLU == null)
    {
      ae.e("Luggage.AppBrandPreLaunchProcess", "onGetWxaAttr, assembled NULL config with username(%s) appId(%s)", new Object[] { ((WxaAttributes)localObject).field_username, ((WxaAttributes)localObject).field_appId });
      onError();
      AppMethodBeat.o(147308);
      return;
    }
    localAppBrandInitConfigLU.dQv = this.hSZ;
    this.appId = localAppBrandInitConfigLU.appId;
    this.username = localAppBrandInitConfigLU.username;
    if (this.hSZ == 0) {
      localAppBrandInitConfigLU.cpm = ((WxaAttributes)localObject).beV().kdo;
    }
    for (;;)
    {
      if (this.jGF == null) {
        this.jGF = new AppBrandStatObject();
      }
      b(localAppBrandInitConfigLU, this.jGF);
      AppMethodBeat.o(147308);
      return;
      s.brN();
      localAppBrandInitConfigLU.extInfo = s.bQ(this.appId, this.hSZ);
      try
      {
        localObject = h.xs(localAppBrandInitConfigLU.extInfo);
        localAppBrandInitConfigLU.cpm = ((JSONObject)localObject).optString("device_orientation");
        localAppBrandInitConfigLU.cmu = ((JSONObject)localObject).optBoolean("open_remote", false);
        localAppBrandInitConfigLU.cmA = z.OB(localAppBrandInitConfigLU.extInfo);
      }
      catch (Exception localException) {}
    }
  }
  
  public static abstract interface a<T extends AppBrandInitConfigLU>
  {
    public abstract void a(T paramT, AppBrandStatObject paramAppBrandStatObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.e
 * JD-Core Version:    0.7.0.1
 */