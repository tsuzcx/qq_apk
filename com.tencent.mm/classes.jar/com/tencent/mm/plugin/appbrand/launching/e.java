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
import com.tencent.mm.plugin.appbrand.config.x;
import com.tencent.mm.plugin.appbrand.config.y;
import com.tencent.mm.plugin.appbrand.launching.params.LaunchParcel;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import org.json.JSONObject;

public class e
  implements Runnable
{
  protected volatile String appId;
  final AppBrandLaunchReferrer cce;
  protected final int hxM;
  protected AppBrandStatObject jjR;
  protected final String jjf;
  private final a lhp;
  protected final ActivityStarterIpcDelegate lhq;
  protected final int pkgVersion;
  protected final String username;
  
  public e(LaunchParcel paramLaunchParcel, a parama)
  {
    this.lhp = parama;
    this.hxM = paramLaunchParcel.hxM;
    this.appId = paramLaunchParcel.appId;
    this.username = paramLaunchParcel.username;
    this.pkgVersion = paramLaunchParcel.version;
    this.jjR = paramLaunchParcel.lpG;
    this.jjf = paramLaunchParcel.jjf;
    this.lhq = paramLaunchParcel.lhq;
    this.cce = paramLaunchParcel.cce;
  }
  
  protected final void b(AppBrandInitConfigLU paramAppBrandInitConfigLU, AppBrandStatObject paramAppBrandStatObject)
  {
    AppMethodBeat.i(147313);
    if (this.lhp != null) {
      this.lhp.a(paramAppBrandInitConfigLU, paramAppBrandStatObject);
    }
    AppMethodBeat.o(147313);
  }
  
  protected Pair<WxaAttributes, Boolean> bna()
  {
    AppMethodBeat.i(147309);
    x.baS();
    Pair localPair = new Pair(x.e(this.appId, new String[0]), Boolean.FALSE);
    AppMethodBeat.o(147309);
    return localPair;
  }
  
  protected boolean f(WxaAttributes paramWxaAttributes)
  {
    AppMethodBeat.i(147311);
    if ((j.a.rq(this.hxM)) && (1 == paramWxaAttributes.baN().ccg))
    {
      Toast.makeText(ai.getContext(), 2131755509, 1).show();
      AppMethodBeat.o(147311);
      return true;
    }
    AppMethodBeat.o(147311);
    return false;
  }
  
  protected final void onError()
  {
    AppMethodBeat.i(147312);
    if (this.lhp != null) {
      this.lhp.a(null, null);
    }
    AppMethodBeat.o(147312);
  }
  
  public void run()
  {
    AppMethodBeat.i(147308);
    Object localObject = (WxaAttributes)bna().first;
    if (localObject == null)
    {
      ac.i("Luggage.AppBrandPreLaunchProcess", "onGetWxaAttr null return");
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
    AppBrandInitConfigLU localAppBrandInitConfigLU = b.Cy().a((WxaAttributes)localObject);
    localAppBrandInitConfigLU.joY = this.hxM;
    this.appId = localAppBrandInitConfigLU.appId;
    if (this.hxM == 0) {
      localAppBrandInitConfigLU.jBP = ((WxaAttributes)localObject).baN().jFO;
    }
    for (;;)
    {
      if (this.jjR == null) {
        this.jjR = new AppBrandStatObject();
      }
      b(localAppBrandInitConfigLU, this.jjR);
      AppMethodBeat.o(147308);
      return;
      s.bnr();
      localAppBrandInitConfigLU.extInfo = s.bK(this.appId, this.hxM);
      try
      {
        localObject = h.tT(localAppBrandInitConfigLU.extInfo);
        localAppBrandInitConfigLU.jBP = ((JSONObject)localObject).optString("device_orientation");
        localAppBrandInitConfigLU.ccb = ((JSONObject)localObject).optBoolean("open_remote", false);
        localAppBrandInitConfigLU.cch = y.KB(localAppBrandInitConfigLU.extInfo);
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