package com.tencent.mm.plugin.appbrand.ipc;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Looper;
import android.os.ResultReceiver;
import android.view.Window;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ui.AppBrandPluginUI;
import com.tencent.mm.plugin.appbrand.ui.AppBrandUI;
import com.tencent.mm.plugin.appbrand.ui.o;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.widget.b.c;

@a(7)
public class AppBrandProcessProxyUI
  extends MMActivity
  implements b
{
  public static String hvW = "appbrand_report_key_target_url";
  public static String hvX = "appbrand_report_key_target_activity";
  private int hvP = 0;
  private AppBrandProxyUIProcessTask hvQ;
  private AppBrandProxyUIProcessTask.ProcessRequest hvR;
  private boolean hvS = false;
  private volatile boolean hvT = false;
  private c hvU;
  private AppBrandProcessProxyUI.a hvV;
  
  public static boolean C(Intent paramIntent)
  {
    AppMethodBeat.i(73132);
    if (paramIntent != null) {}
    try
    {
      if ((paramIntent.getComponent() != null) && (paramIntent.getComponent().getShortClassName().equals(".plugin.appbrand.ipc.AppBrandProcessProxyUI")) && (paramIntent.getIntExtra("key_running_mode", -1) == 10000))
      {
        AppMethodBeat.o(73132);
        return true;
      }
      AppMethodBeat.o(73132);
      return false;
    }
    catch (Exception paramIntent)
    {
      AppMethodBeat.o(73132);
    }
    return false;
  }
  
  static <_Req extends AppBrandProxyUIProcessTask.ProcessRequest, _Result extends AppBrandProxyUIProcessTask.ProcessResult> void a(Context paramContext, Class<? extends AppBrandProcessProxyUI> paramClass, _Req param_Req, AppBrandProxyUIProcessTask.b<_Result> paramb, Intent paramIntent)
  {
    AppMethodBeat.i(73134);
    if (paramContext == null) {
      paramContext = ah.getContext();
    }
    for (;;)
    {
      String str = param_Req.aBo().getName();
      Object localObject;
      if (paramClass == null)
      {
        localObject = AppBrandProcessProxyUI.class;
        localObject = new Intent(paramContext, (Class)localObject).putExtra("key_model_class_name", str);
        if (paramb != null) {
          break label142;
        }
        paramb = null;
        label55:
        paramb = ((Intent)localObject).putExtra("key_result_receiver", paramb).putExtra(hvX, param_Req.aBn()).putExtra("key_running_mode", 1);
        paramb.putExtra("key_request_parcel", param_Req);
        if ((paramContext instanceof Activity)) {
          break label160;
        }
        paramb.addFlags(268435456);
      }
      for (;;)
      {
        if (paramIntent != null) {
          paramb.addFlags(paramIntent.getFlags());
        }
        al.d(new AppBrandProcessProxyUI.2(paramClass, paramContext, paramb));
        AppMethodBeat.o(73134);
        return;
        localObject = paramClass;
        break;
        label142:
        paramb = new AppBrandProcessProxyUI.1(ak.fetchFreeHandler(Looper.getMainLooper()), paramb);
        break label55;
        label160:
        paramb.putExtra("key_need_light_status", o.b(((Activity)paramContext).getWindow()));
      }
    }
  }
  
  static void a(Context paramContext, Class<? extends AppBrandProcessProxyUI> paramClass, String paramString1, String paramString2, String paramString3, String paramString4, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2, DialogInterface.OnClickListener paramOnClickListener3)
  {
    AppMethodBeat.i(73135);
    Context localContext = paramContext;
    if (paramContext == null) {
      localContext = ah.getContext();
    }
    paramContext = new Intent(localContext, paramClass).putExtra("key_running_mode", 2).putExtra("key_result_receiver", new AppBrandProcessProxyUI.3(ak.fetchFreeHandler(Looper.getMainLooper()), paramOnClickListener1, paramOnClickListener2, paramOnClickListener3)).putExtra("key_alert_message", paramString1).putExtra("key_alert_title", paramString2).putExtra("key_alert_confirm", paramString3).putExtra("key_alert_deny", paramString4);
    if (!(localContext instanceof Activity)) {
      paramContext.addFlags(268435456);
    }
    localContext.startActivity(paramContext);
    AppMethodBeat.o(73135);
  }
  
  private static String ca(String paramString1, String paramString2)
  {
    AppMethodBeat.i(73138);
    if (bo.isNullOrNil(paramString1))
    {
      AppMethodBeat.o(73138);
      return paramString2;
    }
    AppMethodBeat.o(73138);
    return paramString1;
  }
  
  public static void m(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(73133);
    if ((!(paramContext instanceof AppBrandUI)) || ((paramContext instanceof AppBrandPluginUI)))
    {
      paramContext.startActivity(paramIntent);
      AppMethodBeat.o(73133);
      return;
    }
    paramContext.startActivity(new Intent(paramContext, AppBrandProcessProxyUI.class).putExtra("key_running_mode", 10000).putExtra("key_proxy_launch_target_intent", paramIntent).putExtra("key_proxy_launch_appbrand_ui_class", paramContext.getClass()).addFlags(268435456));
    AppMethodBeat.o(73133);
  }
  
  public final void a(AppBrandProxyUIProcessTask.ProcessResult paramProcessResult)
  {
    AppMethodBeat.i(73143);
    this.hvT = true;
    runOnUiThread(new AppBrandProcessProxyUI.5(this, paramProcessResult));
    AppMethodBeat.o(73143);
  }
  
  public final MMActivity aBf()
  {
    return this;
  }
  
  public final boolean aBg()
  {
    AppMethodBeat.i(73144);
    if ((activityHasDestroyed()) || (isFinishing()) || (this.hvT))
    {
      AppMethodBeat.o(73144);
      return true;
    }
    AppMethodBeat.o(73144);
    return false;
  }
  
  public final void b(AppBrandProxyUIProcessTask.ProcessResult paramProcessResult)
  {
    AppMethodBeat.i(73145);
    ResultReceiver localResultReceiver = (ResultReceiver)getIntent().getParcelableExtra("key_result_receiver");
    if ((localResultReceiver != null) && (paramProcessResult != null))
    {
      Bundle localBundle = new Bundle(2);
      localBundle.putParcelable("key_result_parcel", paramProcessResult);
      localResultReceiver.send(0, localBundle);
    }
    AppMethodBeat.o(73145);
  }
  
  public void finish()
  {
    AppMethodBeat.i(73142);
    super.finish();
    overridePendingTransition(0, 0);
    if (this.hvQ != null) {
      this.hvQ.aBl();
    }
    AppMethodBeat.o(73142);
  }
  
  public int getLayoutId()
  {
    return -1;
  }
  
  public void initActivityCloseAnimation() {}
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(73141);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (this.hvR == null)
    {
      ab.e("MicroMsg.AppBrandProcessProxyUI", "onActivityResult, NULL mRequest");
      finish();
      AppMethodBeat.o(73141);
      return;
    }
    ab.d("MicroMsg.AppBrandProcessProxyUI", "onActivityResult, requestCode = %d, resultCode = %d, request = %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), this.hvR.getClass().getName() });
    this.hvS = false;
    AppMethodBeat.o(73141);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    int i = 0;
    AppMethodBeat.i(73137);
    super.onCreate(paramBundle);
    overridePendingTransition(0, 0);
    o.a(getWindow());
    o.a(getWindow(), getIntent().getBooleanExtra("key_need_light_status", false));
    getWindow().setBackgroundDrawable(new ColorDrawable(0));
    if (getIntent() == null)
    {
      finish();
      AppMethodBeat.o(73137);
      return;
    }
    switch (getIntent().getIntExtra("key_running_mode", 0))
    {
    default: 
      finish();
      AppMethodBeat.o(73137);
      return;
    case 1: 
      getIntent().setExtrasClassLoader(AppBrandProcessProxyUI.class.getClassLoader());
      paramBundle = getIntent().getStringExtra("key_model_class_name");
      ab.i("MicroMsg.AppBrandProcessProxyUI", "onCreate, modelClass = %s", new Object[] { paramBundle });
      if (bo.isNullOrNil(paramBundle)) {}
      while (i == 0)
      {
        finish();
        AppMethodBeat.o(73137);
        return;
        this.hvQ = AppBrandProxyUIProcessTask.a.BH(paramBundle);
        if (this.hvQ == null)
        {
          ab.e("MicroMsg.AppBrandProcessProxyUI", "onCreate unknown model class = %s", new Object[] { paramBundle });
        }
        else
        {
          if (getIntent().getBooleanExtra("key_request_need_params", true))
          {
            this.hvR = ((AppBrandProxyUIProcessTask.ProcessRequest)getIntent().getParcelableExtra("key_request_parcel"));
            if (this.hvR == null) {
              ab.e("MicroMsg.AppBrandProcessProxyUI", "onCreate unknown request class = %s", new Object[] { paramBundle });
            }
          }
          else
          {
            this.hvR = null;
            continue;
          }
          this.hvQ.hwr = this;
          this.hvQ.a(this.hvR);
          i = 1;
        }
      }
    case 2: 
      paramBundle = ca(getIntent().getStringExtra("key_alert_title"), "");
      String str1 = ca(getIntent().getStringExtra("key_alert_message"), getString(2131297087));
      String str2 = ca(getIntent().getStringExtra("key_alert_confirm"), "");
      String str3 = ca(getIntent().getStringExtra("key_alert_deny"), "");
      this.hvV = new AppBrandProcessProxyUI.a(this, (byte)0);
      this.hvU = h.a(this, str1, paramBundle, str2, str3, false, this.hvV, this.hvV);
      this.hvU.setOnDismissListener(this.hvV);
      this.hvU.setOnKeyListener(new AppBrandProcessProxyUI.4(this, str3));
      AppMethodBeat.o(73137);
      return;
    }
    paramBundle = (Intent)getIntent().getParcelableExtra("key_proxy_launch_target_intent");
    if (paramBundle != null)
    {
      if (paramBundle.getComponent() != null) {}
      try
      {
        Class.forName(paramBundle.getComponent().getClassName());
      }
      catch (Exception localException1)
      {
        for (;;)
        {
          try
          {
            startActivity(paramBundle);
            AppMethodBeat.o(73137);
            return;
          }
          catch (Exception localException2)
          {
            try
            {
              ab.e("MicroMsg.AppBrandProcessProxyUI", "start targetActivity, %s, e = %s", new Object[] { paramBundle, localException2 });
              AppMethodBeat.o(73137);
              return;
            }
            catch (Exception paramBundle)
            {
              AppMethodBeat.o(73137);
              return;
            }
          }
          localException1 = localException1;
          ab.e("MicroMsg.AppBrandProcessProxyUI", "proxyLaunch, Class.forName %s, e = %s", new Object[] { paramBundle.getComponent().getClassName(), localException1 });
        }
      }
    }
    finish();
    AppMethodBeat.o(73137);
  }
  
  public void onCreateBeforeSetContentView()
  {
    AppMethodBeat.i(73136);
    super.onCreateBeforeSetContentView();
    supportRequestWindowFeature(1);
    AppMethodBeat.o(73136);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(73140);
    super.onDestroy();
    if ((this.hvU != null) && (this.hvU.isShowing()))
    {
      this.hvU.dismiss();
      this.hvU = null;
      this.hvV = null;
    }
    AppMethodBeat.o(73140);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(73139);
    super.onResume();
    int i = getIntent().getIntExtra("key_running_mode", 0);
    if (i == 10000)
    {
      i = this.hvP + 1;
      this.hvP = i;
      if (i > 1) {
        try
        {
          Class localClass = (Class)getIntent().getSerializableExtra("key_proxy_launch_appbrand_ui_class");
          if (localClass == null)
          {
            finish();
            AppMethodBeat.o(73139);
            return;
          }
          startActivity(new Intent(this, localClass).putExtra("key_appbrand_bring_ui_to_front", true).addFlags(268435456));
          finish();
          AppMethodBeat.o(73139);
          return;
        }
        catch (Exception localException)
        {
          finish();
        }
      }
      AppMethodBeat.o(73139);
      return;
    }
    if (i == 2)
    {
      ab.d("MicroMsg.AppBrandProcessProxyUI", "onResume, RUNNING_MODE_SHOW_ALERT");
      AppMethodBeat.o(73139);
      return;
    }
    boolean bool = aBg();
    ab.d("MicroMsg.AppBrandProcessProxyUI", "onResume, mFinishOnNextResume = %b, finishing = %b, request = %s", new Object[] { Boolean.valueOf(this.hvS), Boolean.valueOf(bool), this.hvR.getClass().getName() });
    if ((this.hvS) && (this.hvR.aBm()) && (!bool)) {
      a(null);
    }
    this.hvS = true;
    AppMethodBeat.o(73139);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ipc.AppBrandProcessProxyUI
 * JD-Core Version:    0.7.0.1
 */