package com.tencent.mm.plugin.appbrand.ipc;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.ResultReceiver;
import android.view.Window;
import com.tencent.mm.plugin.appbrand.k.a.a;
import com.tencent.mm.plugin.appbrand.ui.l;
import com.tencent.mm.plugin.appbrand.ui.o;
import com.tencent.mm.plugin.appbrand.ui.p;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.widget.a.c;

@a(7)
public class AppBrandProcessProxyUI
  extends MMActivity
  implements b
{
  public static String gdZ = "appbrand_report_key_target_url";
  public static String gea = "appbrand_report_key_target_activity";
  private int gdS = 0;
  private AppBrandProxyUIProcessTask gdT;
  private AppBrandProxyUIProcessTask.ProcessRequest gdU;
  private boolean gdV = false;
  private volatile boolean gdW = false;
  private c gdX;
  private AppBrandProcessProxyUI.a gdY;
  
  static <_Req extends AppBrandProxyUIProcessTask.ProcessRequest, _Result extends AppBrandProxyUIProcessTask.ProcessResult> void a(Context paramContext, Class<? extends AppBrandProcessProxyUI> paramClass, _Req param_Req, final AppBrandProxyUIProcessTask.b<_Result> paramb)
  {
    if (paramContext == null) {
      paramContext = ae.getContext();
    }
    for (;;)
    {
      String str = param_Req.ahH().getName();
      Object localObject;
      if (paramClass == null)
      {
        localObject = AppBrandProcessProxyUI.class;
        localObject = new Intent(paramContext, (Class)localObject).putExtra("key_model_class_name", str);
        if (paramb != null) {
          break label126;
        }
        paramb = null;
        label50:
        paramb = ((Intent)localObject).putExtra("key_result_receiver", paramb).putExtra(gea, param_Req.ahG()).putExtra("key_running_mode", 1);
        paramb.putExtra("key_request_parcel", param_Req);
        if ((paramContext instanceof Activity)) {
          break label144;
        }
        paramb.addFlags(268435456);
      }
      for (;;)
      {
        if ((AppBrandProcessProxyUI.class == paramClass) || (!(paramContext instanceof Activity))) {
          break label164;
        }
        ((Activity)paramContext).startActivityForResult(paramb, 0);
        return;
        localObject = paramClass;
        break;
        label126:
        paramb = new ResultReceiver(ah.fetchFreeHandler(Looper.getMainLooper()))
        {
          protected final void onReceiveResult(int paramAnonymousInt, Bundle paramAnonymousBundle)
          {
            if (paramAnonymousBundle == null)
            {
              paramb.c(null);
              return;
            }
            paramAnonymousBundle.setClassLoader(AppBrandProcessProxyUI.class.getClassLoader());
            paramAnonymousBundle = (AppBrandProxyUIProcessTask.ProcessResult)paramAnonymousBundle.getParcelable("key_result_parcel");
            paramb.c(paramAnonymousBundle);
          }
        };
        break label50;
        label144:
        paramb.putExtra("key_need_light_status", l.c(((Activity)paramContext).getWindow()));
      }
      label164:
      paramContext.startActivity(paramb);
      return;
    }
  }
  
  static void a(Context paramContext, Class<? extends AppBrandProcessProxyUI> paramClass, String paramString1, String paramString2, String paramString3, String paramString4, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2, DialogInterface.OnClickListener paramOnClickListener3)
  {
    Context localContext = paramContext;
    if (paramContext == null) {
      localContext = ae.getContext();
    }
    paramContext = new Intent(localContext, paramClass).putExtra("key_running_mode", 2).putExtra("key_result_receiver", new AppBrandProcessProxyUI.2(ah.fetchFreeHandler(Looper.getMainLooper()), paramOnClickListener1, paramOnClickListener2, paramOnClickListener3)).putExtra("key_alert_message", paramString1).putExtra("key_alert_title", paramString2).putExtra("key_alert_confirm", paramString3).putExtra("key_alert_deny", paramString4);
    if (!(localContext instanceof Activity)) {
      paramContext.addFlags(268435456);
    }
    localContext.startActivity(paramContext);
  }
  
  public static void k(Context paramContext, Intent paramIntent)
  {
    if ((!(paramContext instanceof p)) || ((paramContext instanceof o)))
    {
      paramContext.startActivity(paramIntent);
      return;
    }
    paramContext.startActivity(new Intent(paramContext, AppBrandProcessProxyUI.class).putExtra("key_running_mode", 10000).putExtra("key_proxy_launch_target_intent", paramIntent).putExtra("key_proxy_launch_appbrand_ui_class", paramContext.getClass()).addFlags(268435456));
  }
  
  public static boolean m(Intent paramIntent)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramIntent != null) {
      bool1 = bool2;
    }
    try
    {
      if (paramIntent.getComponent() != null)
      {
        bool1 = bool2;
        if (paramIntent.getComponent().getShortClassName().equals(".plugin.appbrand.ipc.AppBrandProcessProxyUI"))
        {
          int i = paramIntent.getIntExtra("key_running_mode", -1);
          bool1 = bool2;
          if (i == 10000) {
            bool1 = true;
          }
        }
      }
      return bool1;
    }
    catch (Exception paramIntent) {}
    return false;
  }
  
  private static String nilAs(String paramString1, String paramString2)
  {
    if (bk.bl(paramString1)) {
      return paramString2;
    }
    return paramString1;
  }
  
  public final void a(AppBrandProxyUIProcessTask.ProcessResult paramProcessResult)
  {
    this.gdW = true;
    runOnUiThread(new AppBrandProcessProxyUI.4(this, paramProcessResult));
  }
  
  public final MMActivity ahy()
  {
    return this;
  }
  
  public final boolean ahz()
  {
    return (this.uMr) || (isFinishing()) || (this.gdW);
  }
  
  public final void b(AppBrandProxyUIProcessTask.ProcessResult paramProcessResult)
  {
    ResultReceiver localResultReceiver = (ResultReceiver)getIntent().getParcelableExtra("key_result_receiver");
    if ((localResultReceiver != null) && (paramProcessResult != null))
    {
      Bundle localBundle = new Bundle(2);
      localBundle.putParcelable("key_result_parcel", paramProcessResult);
      localResultReceiver.send(0, localBundle);
    }
  }
  
  public void finish()
  {
    super.finish();
    overridePendingTransition(0, 0);
    if (this.gdT != null) {
      this.gdT.ahE();
    }
  }
  
  public final int getLayoutId()
  {
    return -1;
  }
  
  protected void initActivityCloseAnimation() {}
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    y.d("MicroMsg.AppBrandProcessProxyUI", "onActivityResult, requestCode = %d, resultCode = %d, request = %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), this.gdU.getClass().getName() });
    this.gdV = false;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    int i = 0;
    super.onCreate(paramBundle);
    overridePendingTransition(0, 0);
    l.a(getWindow());
    l.a(getWindow(), getIntent().getBooleanExtra("key_need_light_status", false));
    getWindow().setBackgroundDrawable(new ColorDrawable(0));
    if (getIntent() == null)
    {
      finish();
      return;
    }
    switch (getIntent().getIntExtra("key_running_mode", 0))
    {
    default: 
      finish();
      return;
    case 1: 
      getIntent().setExtrasClassLoader(AppBrandProcessProxyUI.class.getClassLoader());
      paramBundle = getIntent().getStringExtra("key_model_class_name");
      y.i("MicroMsg.AppBrandProcessProxyUI", "onCreate, modelClass = %s", new Object[] { paramBundle });
      if (bk.bl(paramBundle)) {}
      while (i == 0)
      {
        finish();
        return;
        this.gdT = AppBrandProxyUIProcessTask.a.tI(paramBundle);
        if (this.gdT == null)
        {
          y.e("MicroMsg.AppBrandProcessProxyUI", "onCreate unknown model class = %s", new Object[] { paramBundle });
        }
        else
        {
          if (getIntent().getBooleanExtra("key_request_need_params", true))
          {
            this.gdU = ((AppBrandProxyUIProcessTask.ProcessRequest)getIntent().getParcelableExtra("key_request_parcel"));
            if (this.gdU == null) {
              y.e("MicroMsg.AppBrandProcessProxyUI", "onCreate unknown request class = %s", new Object[] { paramBundle });
            }
          }
          else
          {
            this.gdU = null;
            continue;
          }
          this.gdT.ger = this;
          this.gdT.a(this.gdU);
          i = 1;
        }
      }
    case 2: 
      paramBundle = nilAs(getIntent().getStringExtra("key_alert_title"), "");
      String str1 = nilAs(getIntent().getStringExtra("key_alert_message"), getString(a.a.app_tip));
      String str2 = nilAs(getIntent().getStringExtra("key_alert_confirm"), "");
      String str3 = nilAs(getIntent().getStringExtra("key_alert_deny"), "");
      this.gdY = new AppBrandProcessProxyUI.a(this, (byte)0);
      this.gdX = h.a(this, str1, paramBundle, str2, str3, false, this.gdY, this.gdY);
      this.gdX.setOnDismissListener(this.gdY);
      this.gdX.setOnKeyListener(new AppBrandProcessProxyUI.3(this, str3));
      return;
    }
    paramBundle = (Intent)getIntent().getParcelableExtra("key_proxy_launch_target_intent");
    if (paramBundle != null)
    {
      if (paramBundle.getComponent() != null) {}
      try
      {
        Class.forName(paramBundle.getComponent().getClassName());
        try
        {
          startActivity(paramBundle);
          return;
        }
        catch (Exception localException1)
        {
          try
          {
            y.e("MicroMsg.AppBrandProcessProxyUI", "start targetActivity, %s, e = %s", new Object[] { paramBundle, localException1 });
            return;
          }
          catch (Exception paramBundle)
          {
            return;
          }
        }
      }
      catch (Exception localException2)
      {
        for (;;)
        {
          y.e("MicroMsg.AppBrandProcessProxyUI", "proxyLaunch, Class.forName %s, e = %s", new Object[] { paramBundle.getComponent().getClassName(), localException2 });
        }
      }
    }
    finish();
  }
  
  protected final void onCreateBeforeSetContentView()
  {
    super.onCreateBeforeSetContentView();
    supportRequestWindowFeature(1);
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    if ((this.gdX != null) && (this.gdX.isShowing()))
    {
      this.gdX.dismiss();
      this.gdX = null;
      this.gdY = null;
    }
  }
  
  protected void onResume()
  {
    super.onResume();
    int i = getIntent().getIntExtra("key_running_mode", 0);
    if (i == 10000)
    {
      i = this.gdS + 1;
      this.gdS = i;
      if (i <= 1) {
        return;
      }
      try
      {
        Class localClass = (Class)getIntent().getSerializableExtra("key_proxy_launch_appbrand_ui_class");
        if (localClass == null)
        {
          finish();
          return;
        }
        startActivity(new Intent(this, localClass).putExtra("key_appbrand_bring_ui_to_front", true).addFlags(268435456));
        finish();
        return;
      }
      catch (Exception localException)
      {
        finish();
        return;
      }
    }
    if (i == 2)
    {
      y.d("MicroMsg.AppBrandProcessProxyUI", "onResume, RUNNING_MODE_SHOW_ALERT");
      return;
    }
    boolean bool = ahz();
    y.d("MicroMsg.AppBrandProcessProxyUI", "onResume, mFinishOnNextResume = %b, finishing = %b, request = %s", new Object[] { Boolean.valueOf(this.gdV), Boolean.valueOf(bool), this.gdU.getClass().getName() });
    if ((this.gdV) && (this.gdU.ahF()) && (!bool)) {
      a(null);
    }
    this.gdV = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ipc.AppBrandProcessProxyUI
 * JD-Core Version:    0.7.0.1
 */