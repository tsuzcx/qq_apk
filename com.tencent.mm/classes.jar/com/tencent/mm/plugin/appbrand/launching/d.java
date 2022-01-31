package com.tencent.mm.plugin.appbrand.launching;

import android.util.Pair;
import android.widget.Toast;
import com.tencent.luggage.sdk.config.AppBrandInitConfigLU;
import com.tencent.luggage.sdk.config.b;
import com.tencent.luggage.sdk.launching.ActivityStarterIpcDelegate;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aa.h;
import com.tencent.mm.plugin.appbrand.appcache.j.a;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.WxaVersionInfo;
import com.tencent.mm.plugin.appbrand.config.t;
import com.tencent.mm.plugin.appbrand.launching.params.LaunchParcel;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.sdk.g.a.e;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.Locale;
import org.json.JSONArray;
import org.json.JSONObject;

public class d
  implements Runnable
{
  protected volatile String appId;
  protected final int gXf;
  protected final int hcr;
  protected final String hiw;
  private final d.a ijO;
  protected AppBrandStatObject ijP;
  protected final ActivityStarterIpcDelegate ijQ;
  protected final String username;
  
  public d(LaunchParcel paramLaunchParcel, d.a parama)
  {
    this.ijO = parama;
    this.hcr = paramLaunchParcel.hcr;
    this.appId = paramLaunchParcel.appId;
    this.username = paramLaunchParcel.username;
    this.gXf = paramLaunchParcel.version;
    this.ijP = paramLaunchParcel.inG;
    this.hiw = paramLaunchParcel.hiw;
    this.ijQ = paramLaunchParcel.ijQ;
  }
  
  static boolean Dj(String paramString)
  {
    AppMethodBeat.i(102098);
    if (bo.isNullOrNil(paramString))
    {
      AppMethodBeat.o(102098);
      return false;
    }
    try
    {
      paramString = new JSONObject(paramString).optJSONArray("call_plugin_info");
      if ((paramString != null) && (paramString.length() > 0))
      {
        AppMethodBeat.o(102098);
        return true;
      }
      AppMethodBeat.o(102098);
      return false;
    }
    catch (Exception paramString)
    {
      AppMethodBeat.o(102098);
    }
    return false;
  }
  
  protected final void a(AppBrandInitConfigLU paramAppBrandInitConfigLU, AppBrandStatObject paramAppBrandStatObject)
  {
    AppMethodBeat.i(102100);
    if (this.ijO != null) {
      this.ijO.a(paramAppBrandInitConfigLU, paramAppBrandStatObject, 1);
    }
    AppMethodBeat.o(102100);
  }
  
  public final void aGI()
  {
    AppMethodBeat.i(138194);
    com.tencent.mm.sdk.g.d.ysm.b(this, String.format(Locale.US, "Luggage.AppBrandPreLaunchProcess|appId[%s]", new Object[] { this.appId }));
    AppMethodBeat.o(138194);
  }
  
  protected Pair<WxaAttributes, Boolean> aGJ()
  {
    AppMethodBeat.i(102097);
    t.ayI();
    Pair localPair = new Pair(t.AF(this.appId), Boolean.FALSE);
    AppMethodBeat.o(102097);
    return localPair;
  }
  
  protected boolean e(WxaAttributes paramWxaAttributes)
  {
    AppMethodBeat.i(140850);
    if ((j.a.nk(this.hcr)) && (1 == paramWxaAttributes.ayE().bDd))
    {
      Toast.makeText(ah.getContext(), 2131296728, 1).show();
      AppMethodBeat.o(140850);
      return true;
    }
    AppMethodBeat.o(140850);
    return false;
  }
  
  protected final void onError()
  {
    AppMethodBeat.i(102099);
    if (this.ijO != null) {
      this.ijO.a(null, null, 2);
    }
    AppMethodBeat.o(102099);
  }
  
  public void run()
  {
    AppMethodBeat.i(102096);
    Object localObject = (WxaAttributes)aGJ().first;
    if (localObject == null)
    {
      ab.i("Luggage.AppBrandPreLaunchProcess", "onGetWxaAttr null return");
      onError();
      AppMethodBeat.o(102096);
      return;
    }
    if (e((WxaAttributes)localObject))
    {
      onError();
      AppMethodBeat.o(102096);
      return;
    }
    AppBrandInitConfigLU localAppBrandInitConfigLU = b.vW().a((WxaAttributes)localObject);
    localAppBrandInitConfigLU.gXd = this.hcr;
    this.appId = localAppBrandInitConfigLU.appId;
    if (this.hcr == 0)
    {
      localAppBrandInitConfigLU.hha = ((WxaAttributes)localObject).ayE().hke;
      localAppBrandInitConfigLU.bDb = ((WxaAttributes)localObject).ayE().bDb;
    }
    for (;;)
    {
      localAppBrandInitConfigLU.bCX = Dj(localAppBrandInitConfigLU.bDb);
      if (this.ijP == null) {
        this.ijP = new AppBrandStatObject();
      }
      a(localAppBrandInitConfigLU, this.ijP);
      AppMethodBeat.o(102096);
      return;
      l.aGS();
      localAppBrandInitConfigLU.extInfo = l.bm(this.appId, this.hcr);
      try
      {
        localObject = h.mo(localAppBrandInitConfigLU.extInfo);
        localAppBrandInitConfigLU.hha = ((JSONObject)localObject).optString("device_orientation");
        localAppBrandInitConfigLU.bDb = ((JSONObject)localObject).optString("client_js_ext_info");
        localAppBrandInitConfigLU.bCW = ((JSONObject)localObject).optBoolean("open_remote", false);
      }
      catch (Exception localException) {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.d
 * JD-Core Version:    0.7.0.1
 */