package com.tencent.mm.plugin.appbrand.jsapi.miniprogram_navigator;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.PersistableBundle;
import android.text.TextUtils;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.luggage.sdk.config.AppBrandInitConfigLU;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.co.f;
import com.tencent.mm.co.g;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.launching.AppBrandPreInitTask.a;
import com.tencent.mm.plugin.appbrand.launching.params.LaunchParcel;
import com.tencent.mm.plugin.appbrand.p;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import org.json.JSONObject;

public class m
  extends j
{
  public static final m mfl;
  
  static
  {
    AppMethodBeat.i(46646);
    mfl = new m();
    AppMethodBeat.o(46646);
  }
  
  public final com.tencent.mm.vending.g.c<AppBrandInitConfigLU> a(final com.tencent.mm.plugin.appbrand.d paramd, final LaunchParcel paramLaunchParcel, final JSONObject paramJSONObject)
  {
    AppMethodBeat.i(46645);
    if ((paramd.getRuntime() == null) || (paramd.getRuntime().SO) || (paramd.getRuntime().isDestroyed()))
    {
      Log.e("MicroMsg.MiniProgramNavigatorWC", "prepareInitConfig but component not working, targetAppId:%s", new Object[] { paramLaunchParcel.appId });
      paramd = g.ey(null);
      AppMethodBeat.o(46645);
      return paramd;
    }
    p.Un(paramd.getAppId()).kCT = paramLaunchParcel.appId;
    p.Un(paramd.getAppId()).kCU = paramLaunchParcel.kHw;
    String str = paramJSONObject.optString("adUxInfo", null);
    if (!TextUtils.isEmpty(str))
    {
      if (paramLaunchParcel.ldQ == null) {
        paramLaunchParcel.ldQ = new PersistableBundle();
      }
      paramLaunchParcel.ldQ.putString("adUxInfo", str);
    }
    com.tencent.mm.plugin.s.a.x("AppBrandRuntime", "navigateToMiniProgram", str, "data");
    paramd = g.hio().b(new com.tencent.mm.vending.c.a() {});
    AppMethodBeat.o(46645);
    return paramd;
  }
  
  public boolean a(final com.tencent.mm.plugin.appbrand.d paramd, LaunchParcel paramLaunchParcel, final c.b paramb)
  {
    AppMethodBeat.i(46644);
    if (com.tencent.mm.model.gdpr.c.aXj())
    {
      com.tencent.mm.model.gdpr.c.a(paramd.getContext(), com.tencent.mm.model.gdpr.a.iGM, paramLaunchParcel.appId, new com.tencent.mm.model.gdpr.b()
      {
        public final void sx(int paramAnonymousInt)
        {
          AppMethodBeat.i(46640);
          if (paramAnonymousInt == 0)
          {
            paramb.proceed();
            AppMethodBeat.o(46640);
            return;
          }
          paramb.cancel();
          MMHandlerThread.postToMainThread(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(46639);
              com.tencent.mm.plugin.appbrand.widget.dialog.b localb = new com.tencent.mm.plugin.appbrand.widget.dialog.b(m.1.this.lAB.getContext());
              localb.setTitle(2131756087);
              localb.NIK.setVisibility(0);
              localb.NIC.setVisibility(0);
              localb.NIC.setText(2131756086);
              localb.setCanceledOnTouchOutside(false);
              localb.a(2131755921, new DialogInterface.OnClickListener()
              {
                public final void onClick(DialogInterface paramAnonymous3DialogInterface, int paramAnonymous3Int)
                {
                  AppMethodBeat.i(46638);
                  paramAnonymous3DialogInterface.dismiss();
                  AppMethodBeat.o(46638);
                }
              });
              m.1.this.lAB.getRuntime().jCK.b(localb);
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.miniprogram_navigator.m
 * JD-Core Version:    0.7.0.1
 */