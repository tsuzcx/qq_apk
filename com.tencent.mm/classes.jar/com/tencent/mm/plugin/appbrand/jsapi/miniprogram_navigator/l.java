package com.tencent.mm.plugin.appbrand.jsapi.miniprogram_navigator;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.PersistableBundle;
import android.text.TextUtils;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.luggage.sdk.config.AppBrandInitConfigLU;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cn.g;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.launching.AppBrandPreInitTask.a;
import com.tencent.mm.plugin.appbrand.launching.params.LaunchParcel;
import com.tencent.mm.plugin.appbrand.report.s;
import com.tencent.mm.plugin.appbrand.widget.dialog.h;
import com.tencent.mm.plugin.appbrand.widget.dialog.k.a;
import com.tencent.mm.plugin.appbrand.widget.dialog.m;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ap;
import org.json.JSONObject;

public class l
  extends i
{
  public static final l kAf;
  
  static
  {
    AppMethodBeat.i(46646);
    kAf = new l();
    AppMethodBeat.o(46646);
  }
  
  public final com.tencent.mm.vending.g.c<AppBrandInitConfigLU> a(final com.tencent.mm.plugin.appbrand.d paramd, final LaunchParcel paramLaunchParcel, final JSONObject paramJSONObject)
  {
    AppMethodBeat.i(46645);
    if ((paramd.getRuntime() == null) || (paramd.getRuntime().QM) || (paramd.getRuntime().isDestroyed()))
    {
      ac.e("MicroMsg.MiniProgramNavigatorWC", "prepareInitConfig but component not working, targetAppId:%s", new Object[] { paramLaunchParcel.appId });
      paramd = g.eo(null);
      AppMethodBeat.o(46645);
      return paramd;
    }
    com.tencent.mm.plugin.appbrand.n.Hs(paramd.getAppId()).jfR = paramLaunchParcel.appId;
    com.tencent.mm.plugin.appbrand.n.Hs(paramd.getAppId()).jfS = paramLaunchParcel.jjf;
    final String str1 = com.tencent.mm.plugin.appbrand.report.quality.f.a(paramd, paramLaunchParcel);
    String str2 = paramJSONObject.optString("adUxInfo", null);
    if (!TextUtils.isEmpty(str2))
    {
      if (paramLaunchParcel.jDB == null) {
        paramLaunchParcel.jDB = new PersistableBundle();
      }
      paramLaunchParcel.jDB.putString("adUxInfo", str2);
      Object localObject = s.lSi;
      s.b(paramLaunchParcel, str1);
      localObject = com.tencent.mm.plugin.appbrand.report.quality.n.lWn;
      com.tencent.mm.plugin.appbrand.report.quality.n.ec(paramLaunchParcel.appId, str1);
    }
    com.tencent.mm.plugin.t.a.t("AppBrandRuntime", "navigateToMiniProgram", str2, "data");
    paramd = g.fBc().b(new com.tencent.mm.vending.c.a() {});
    AppMethodBeat.o(46645);
    return paramd;
  }
  
  public boolean a(final com.tencent.mm.plugin.appbrand.d paramd, LaunchParcel paramLaunchParcel, final c.b paramb)
  {
    AppMethodBeat.i(46644);
    if (com.tencent.mm.model.gdpr.c.aAe())
    {
      com.tencent.mm.model.gdpr.c.a(paramd.getContext(), com.tencent.mm.model.gdpr.a.hqz, paramLaunchParcel.appId, new com.tencent.mm.model.gdpr.b()
      {
        public final void og(int paramAnonymousInt)
        {
          AppMethodBeat.i(46640);
          if (paramAnonymousInt == 0)
          {
            paramb.proceed();
            AppMethodBeat.o(46640);
            return;
          }
          paramb.cancel();
          ap.f(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(46639);
              com.tencent.mm.plugin.appbrand.widget.dialog.b localb = new com.tencent.mm.plugin.appbrand.widget.dialog.b(l.1.this.jYK.getContext());
              localb.setTitle(2131755981);
              localb.Gpr.setVisibility(0);
              localb.Gpj.setVisibility(0);
              localb.Gpj.setText(2131755980);
              localb.setCanceledOnTouchOutside(false);
              localb.a(2131755835, new DialogInterface.OnClickListener()
              {
                public final void onClick(DialogInterface paramAnonymous3DialogInterface, int paramAnonymous3Int)
                {
                  AppMethodBeat.i(46638);
                  paramAnonymous3DialogInterface.dismiss();
                  AppMethodBeat.o(46638);
                }
              });
              l.1.this.jYK.getRuntime().iky.b(localb);
              AppMethodBeat.o(46639);
            }
          });
          AppMethodBeat.o(46640);
        }
      });
      AppMethodBeat.o(46644);
      return true;
    }
    AppMethodBeat.o(46644);
    return false;
  }
  
  protected final k.a ae(AppBrandRuntime paramAppBrandRuntime)
  {
    AppMethodBeat.i(46643);
    Activity localActivity = com.tencent.mm.sdk.f.a.jg(paramAppBrandRuntime.mContext);
    if (localActivity == null) {}
    for (paramAppBrandRuntime = paramAppBrandRuntime.mContext;; paramAppBrandRuntime = localActivity)
    {
      if (paramAppBrandRuntime == null)
      {
        AppMethodBeat.o(46643);
        return null;
      }
      paramAppBrandRuntime = new h(paramAppBrandRuntime);
      AppMethodBeat.o(46643);
      return paramAppBrandRuntime;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.miniprogram_navigator.l
 * JD-Core Version:    0.7.0.1
 */