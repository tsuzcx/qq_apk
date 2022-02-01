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
import com.tencent.mm.plugin.appbrand.config.y;
import com.tencent.mm.plugin.appbrand.config.z;
import com.tencent.mm.plugin.appbrand.launching.params.LaunchParcel;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import org.json.JSONObject;

public class e
  implements Runnable
{
  protected volatile String appId;
  final AppBrandLaunchReferrer cmv;
  protected final int hQh;
  protected final String jCN;
  protected AppBrandStatObject jDH;
  private final a lEp;
  protected final ActivityStarterIpcDelegate lEq;
  protected final int pkgVersion;
  protected volatile String username;
  
  public e(LaunchParcel paramLaunchParcel, a parama)
  {
    this.lEp = parama;
    this.hQh = paramLaunchParcel.hQh;
    this.appId = paramLaunchParcel.appId;
    this.username = paramLaunchParcel.username;
    this.pkgVersion = paramLaunchParcel.version;
    this.jDH = paramLaunchParcel.lMZ;
    this.jCN = paramLaunchParcel.jCN;
    this.lEq = paramLaunchParcel.lEq;
    this.cmv = paramLaunchParcel.cmv;
  }
  
  protected final void b(AppBrandInitConfigLU paramAppBrandInitConfigLU, AppBrandStatObject paramAppBrandStatObject)
  {
    AppMethodBeat.i(147313);
    if (this.lEp != null) {
      this.lEp.a(paramAppBrandInitConfigLU, paramAppBrandStatObject);
    }
    AppMethodBeat.o(147313);
  }
  
  protected Pair<WxaAttributes, Boolean> bqL()
  {
    AppMethodBeat.i(147309);
    y.bes();
    Pair localPair = new Pair(y.e(this.appId, new String[0]), Boolean.FALSE);
    AppMethodBeat.o(147309);
    return localPair;
  }
  
  protected boolean g(WxaAttributes paramWxaAttributes)
  {
    AppMethodBeat.i(147311);
    if ((j.a.rQ(this.hQh)) && (1 == paramWxaAttributes.ben().cmx))
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
    if (this.lEp != null) {
      this.lEp.a(null, null);
    }
    AppMethodBeat.o(147312);
  }
  
  public void run()
  {
    AppMethodBeat.i(147308);
    Object localObject = (WxaAttributes)bqL().first;
    if (localObject == null)
    {
      ad.i("Luggage.AppBrandPreLaunchProcess", "onGetWxaAttr null return");
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
    AppBrandInitConfigLU localAppBrandInitConfigLU = b.DX().a((WxaAttributes)localObject);
    if (localAppBrandInitConfigLU == null)
    {
      ad.e("Luggage.AppBrandPreLaunchProcess", "onGetWxaAttr, assembled NULL config with username(%s) appId(%s)", new Object[] { ((WxaAttributes)localObject).field_username, ((WxaAttributes)localObject).field_appId });
      onError();
      AppMethodBeat.o(147308);
      return;
    }
    localAppBrandInitConfigLU.dPf = this.hQh;
    this.appId = localAppBrandInitConfigLU.appId;
    this.username = localAppBrandInitConfigLU.username;
    if (this.hQh == 0) {
      localAppBrandInitConfigLU.jVL = ((WxaAttributes)localObject).ben().jZX;
    }
    for (;;)
    {
      if (this.jDH == null) {
        this.jDH = new AppBrandStatObject();
      }
      b(localAppBrandInitConfigLU, this.jDH);
      AppMethodBeat.o(147308);
      return;
      s.brd();
      localAppBrandInitConfigLU.extInfo = s.bN(this.appId, this.hQh);
      try
      {
        localObject = h.wJ(localAppBrandInitConfigLU.extInfo);
        localAppBrandInitConfigLU.jVL = ((JSONObject)localObject).optString("device_orientation");
        localAppBrandInitConfigLU.cms = ((JSONObject)localObject).optBoolean("open_remote", false);
        localAppBrandInitConfigLU.cmy = z.NU(localAppBrandInitConfigLU.extInfo);
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