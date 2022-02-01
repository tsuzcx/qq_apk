package com.tencent.mm.plugin.appbrand.jsapi.miniprogram_navigator;

import android.os.PersistableBundle;
import android.text.TextUtils;
import com.tencent.luggage.sdk.config.AppBrandInitConfigLU;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cw.f;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.launching.AppBrandPreInitTask.a;
import com.tencent.mm.plugin.appbrand.launching.params.LaunchParcel;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.s;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vending.g.b;
import com.tencent.mm.vending.g.c;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

public class l
  extends j
{
  public static final l pdl;
  
  static
  {
    AppMethodBeat.i(46646);
    pdl = new l();
    AppMethodBeat.o(46646);
  }
  
  public final c<AppBrandInitConfigLU> a(final com.tencent.mm.plugin.appbrand.g paramg, final LaunchParcel paramLaunchParcel, final JSONObject paramJSONObject)
  {
    AppMethodBeat.i(46645);
    if ((paramg.getRuntime() == null) || (paramg.getRuntime().aol) || (paramg.getRuntime().ntU.get()))
    {
      Log.e("MicroMsg.MiniProgramNavigatorWC", "prepareInitConfig but component not working, targetAppId:%s", new Object[] { paramLaunchParcel.appId });
      paramg = com.tencent.mm.cw.g.eE(null);
      AppMethodBeat.o(46645);
      return paramg;
    }
    s.abW(paramg.getAppId()).nwe = paramLaunchParcel.appId;
    s.abW(paramg.getAppId()).nwf = paramLaunchParcel.nBq;
    String str = paramJSONObject.optString("adUxInfo", null);
    if (!TextUtils.isEmpty(str))
    {
      if (paramLaunchParcel.nYe == null) {
        paramLaunchParcel.nYe = new PersistableBundle();
      }
      paramLaunchParcel.nYe.putString("adUxInfo", str);
    }
    com.tencent.mm.plugin.ac.a.C("AppBrandRuntime", "navigateToMiniProgram", str, "data");
    paramg = com.tencent.mm.cw.g.ijP().b(new com.tencent.mm.vending.c.a() {});
    AppMethodBeat.o(46645);
    return paramg;
  }
  
  public boolean a(com.tencent.mm.plugin.appbrand.g paramg, LaunchParcel paramLaunchParcel, c.b paramb)
  {
    AppMethodBeat.i(46644);
    NavigatorInterceptor localNavigatorInterceptor = NavigatorInterceptor.pdq;
    NavigatorInterceptor.b(paramg, paramLaunchParcel, paramb);
    AppMethodBeat.o(46644);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.miniprogram_navigator.l
 * JD-Core Version:    0.7.0.1
 */