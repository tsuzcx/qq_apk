package com.tencent.mm.plugin.appbrand.ipc;

import android.app.Activity;
import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.LifecycleObserver;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.DialogInterface.OnKeyListener;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.ResultReceiver;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import com.tencent.luggage.h.e;
import com.tencent.luggage.h.e.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ui.AppBrandPluginUI;
import com.tencent.mm.plugin.appbrand.ui.AppBrandUI;
import com.tencent.mm.plugin.appbrand.ui.r;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.widget.a.d;

@com.tencent.mm.ui.base.a(7)
public class AppBrandProcessProxyUI
  extends MMActivity
  implements e.d, c
{
  public static String juv = "appbrand_report_key_target_url";
  public static String juw = "appbrand_report_key_target_activity";
  private int jun = 0;
  private AppBrandProxyUIProcessTask juo;
  private AppBrandProxyUIProcessTask.ProcessRequest jup;
  private boolean juq = false;
  private volatile boolean jur = false;
  private volatile boolean jus = false;
  private d jut;
  private a juu;
  
  public static boolean B(Intent paramIntent)
  {
    AppMethodBeat.i(45393);
    if (paramIntent != null) {}
    try
    {
      if ((paramIntent.getComponent() != null) && (paramIntent.getComponent().getShortClassName().equals(".plugin.appbrand.ipc.AppBrandProcessProxyUI")) && (paramIntent.getIntExtra("key_running_mode", -1) == 10000))
      {
        AppMethodBeat.o(45393);
        return true;
      }
      AppMethodBeat.o(45393);
      return false;
    }
    catch (Exception paramIntent)
    {
      AppMethodBeat.o(45393);
    }
    return false;
  }
  
  static <_Req extends AppBrandProxyUIProcessTask.ProcessRequest, _Result extends AppBrandProxyUIProcessTask.ProcessResult> void a(Context paramContext, Class<? extends AppBrandProcessProxyUI> paramClass, _Req param_Req, AppBrandProxyUIProcessTask.b<_Result> paramb, Intent paramIntent)
  {
    AppMethodBeat.i(45395);
    if (paramContext == null) {
      paramContext = aj.getContext();
    }
    for (;;)
    {
      String str = param_Req.aWl().getName();
      if (paramClass == null)
      {
        localObject = AppBrandProcessProxyUI.class;
        localObject = new Intent(paramContext, (Class)localObject).putExtra("key_model_class_name", str);
        if (paramb != null) {
          break label143;
        }
      }
      label143:
      for (paramb = null;; paramb = new AppBrandProcessProxyUI.1(ap.createFreeHandler(Looper.getMainLooper()), paramb))
      {
        paramb = ((Intent)localObject).putExtra("key_result_receiver", paramb).putExtra(juw, param_Req.aXr()).putExtra("key_running_mode", 1);
        paramb.putExtra("key_request_parcel", param_Req);
        if ((paramContext instanceof Activity)) {
          break label161;
        }
        paramb.addFlags(268435456);
        if (paramIntent != null) {
          paramb.addFlags(paramIntent.getFlags());
        }
        aq.f(new AppBrandProcessProxyUI.2(paramClass, paramContext, paramb, param_Req));
        AppMethodBeat.o(45395);
        return;
        localObject = paramClass;
        break;
      }
      label161:
      Object localObject = ((Activity)paramContext).getWindow();
      boolean bool;
      if ((localObject == null) || (((Window)localObject).getDecorView() == null)) {
        bool = false;
      }
      for (;;)
      {
        paramb.putExtra("key_need_light_status", bool);
        break;
        if ((Build.VERSION.SDK_INT >= 23) && ((((Window)localObject).getDecorView().getSystemUiVisibility() & 0x2000) != 0)) {
          bool = true;
        } else {
          bool = false;
        }
      }
    }
  }
  
  static void a(Context paramContext, Class<? extends AppBrandProcessProxyUI> paramClass, String paramString1, String paramString2, String paramString3, String paramString4, final DialogInterface.OnClickListener paramOnClickListener1, final DialogInterface.OnClickListener paramOnClickListener2, final DialogInterface.OnClickListener paramOnClickListener3)
  {
    AppMethodBeat.i(45396);
    if (paramContext == null) {
      paramContext = aj.getContext();
    }
    for (;;)
    {
      paramClass = new Intent(paramContext, paramClass).putExtra("key_running_mode", 2).putExtra("key_result_receiver", new ResultReceiver(ap.createFreeHandler(Looper.getMainLooper()))
      {
        protected final void onReceiveResult(int paramAnonymousInt, Bundle paramAnonymousBundle)
        {
          AppMethodBeat.i(45387);
          if ((-1 == paramAnonymousInt) && (paramOnClickListener1 != null)) {
            paramOnClickListener1.onClick(null, paramAnonymousInt);
          }
          if ((-2 == paramAnonymousInt) && (paramOnClickListener2 != null)) {
            paramOnClickListener2.onClick(null, paramAnonymousInt);
          }
          if ((-3 == paramAnonymousInt) && (paramOnClickListener3 != null)) {
            paramOnClickListener3.onClick(null, paramAnonymousInt);
          }
          AppMethodBeat.o(45387);
        }
      }).putExtra("key_alert_message", paramString1).putExtra("key_alert_title", paramString2).putExtra("key_alert_confirm", paramString3).putExtra("key_alert_deny", paramString4);
      if (!(paramContext instanceof Activity)) {
        paramClass.addFlags(268435456);
      }
      paramClass = new com.tencent.mm.hellhoundlib.b.a().bd(paramClass);
      com.tencent.mm.hellhoundlib.a.a.a(paramContext, paramClass.adn(), "com/tencent/mm/plugin/appbrand/ipc/AppBrandProcessProxyUI", "showAlert", "(Landroid/content/Context;Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Landroid/content/DialogInterface$OnClickListener;Landroid/content/DialogInterface$OnClickListener;Landroid/content/DialogInterface$OnClickListener;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramContext.startActivity((Intent)paramClass.lS(0));
      com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/plugin/appbrand/ipc/AppBrandProcessProxyUI", "showAlert", "(Landroid/content/Context;Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Landroid/content/DialogInterface$OnClickListener;Landroid/content/DialogInterface$OnClickListener;Landroid/content/DialogInterface$OnClickListener;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(45396);
      return;
    }
  }
  
  private static String cI(String paramString1, String paramString2)
  {
    AppMethodBeat.i(45399);
    if (bt.isNullOrNil(paramString1))
    {
      AppMethodBeat.o(45399);
      return paramString2;
    }
    AppMethodBeat.o(45399);
    return paramString1;
  }
  
  public static void l(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(45394);
    if ((!(paramContext instanceof AppBrandUI)) || ((paramContext instanceof AppBrandPluginUI)))
    {
      paramIntent = new com.tencent.mm.hellhoundlib.b.a().bd(paramIntent);
      com.tencent.mm.hellhoundlib.a.a.a(paramContext, paramIntent.adn(), "com/tencent/mm/plugin/appbrand/ipc/AppBrandProcessProxyUI", "proxyLaunchByAppBrandUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramContext.startActivity((Intent)paramIntent.lS(0));
      com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/plugin/appbrand/ipc/AppBrandProcessProxyUI", "proxyLaunchByAppBrandUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(45394);
      return;
    }
    paramIntent = new Intent(paramContext, AppBrandProcessProxyUI.class).putExtra("key_running_mode", 10000).putExtra("key_proxy_launch_target_intent", paramIntent).putExtra("key_proxy_launch_appbrand_ui_class", paramContext.getClass()).addFlags(268435456);
    paramIntent = new com.tencent.mm.hellhoundlib.b.a().bd(paramIntent);
    com.tencent.mm.hellhoundlib.a.a.a(paramContext, paramIntent.adn(), "com/tencent/mm/plugin/appbrand/ipc/AppBrandProcessProxyUI", "proxyLaunchByAppBrandUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramContext.startActivity((Intent)paramIntent.lS(0));
    com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/plugin/appbrand/ipc/AppBrandProcessProxyUI", "proxyLaunchByAppBrandUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(45394);
  }
  
  public final MMActivity aXi()
  {
    return this;
  }
  
  public final boolean aXj()
  {
    AppMethodBeat.i(45405);
    if ((activityHasDestroyed()) || (isFinishing()) || (this.jur))
    {
      AppMethodBeat.o(45405);
      return true;
    }
    AppMethodBeat.o(45405);
    return false;
  }
  
  public final void b(final AppBrandProxyUIProcessTask.ProcessResult paramProcessResult)
  {
    AppMethodBeat.i(45404);
    this.jur = true;
    runOnUiThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(45389);
        AppBrandProcessProxyUI.this.finish();
        AppBrandProcessProxyUI.this.c(paramProcessResult);
        AppMethodBeat.o(45389);
      }
    });
    AppMethodBeat.o(45404);
  }
  
  public final void c(AppBrandProxyUIProcessTask.ProcessResult paramProcessResult)
  {
    AppMethodBeat.i(45406);
    this.jus = true;
    ResultReceiver localResultReceiver = (ResultReceiver)getIntent().getParcelableExtra("key_result_receiver");
    if ((localResultReceiver != null) && (paramProcessResult != null))
    {
      Bundle localBundle = new Bundle(2);
      localBundle.putParcelable("key_result_parcel", paramProcessResult);
      localResultReceiver.send(0, localBundle);
    }
    AppMethodBeat.o(45406);
  }
  
  public void finish()
  {
    AppMethodBeat.i(45403);
    super.finish();
    overridePendingTransition(0, 0);
    if (this.juo != null) {
      this.juo.aXp();
    }
    AppMethodBeat.o(45403);
  }
  
  public int getLayoutId()
  {
    return -1;
  }
  
  public void initActivityCloseAnimation() {}
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(45402);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    e.az(this).onActivityResult(paramInt1, paramInt2, paramIntent);
    if (this.jup == null)
    {
      ad.e("MicroMsg.AppBrandProcessProxyUI", "onActivityResult, NULL mRequest");
      finish();
      AppMethodBeat.o(45402);
      return;
    }
    ad.d("MicroMsg.AppBrandProcessProxyUI", "onActivityResult, requestCode = %d, resultCode = %d, request = %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), this.jup.getClass().getName() });
    this.juq = false;
    AppMethodBeat.o(45402);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    int i = 0;
    AppMethodBeat.i(45398);
    super.onCreate(paramBundle);
    overridePendingTransition(0, 0);
    r.b(getWindow());
    r.c(getWindow(), getIntent().getBooleanExtra("key_need_light_status", false));
    getWindow().setBackgroundDrawable(new ColorDrawable(0));
    if (getIntent() == null)
    {
      finish();
      AppMethodBeat.o(45398);
      return;
    }
    Object localObject;
    switch (getIntent().getIntExtra("key_running_mode", 0))
    {
    default: 
      finish();
      AppMethodBeat.o(45398);
      return;
    case 1: 
      getIntent().setExtrasClassLoader(AppBrandProcessProxyUI.class.getClassLoader());
      paramBundle = getIntent().getStringExtra("key_model_class_name");
      ad.i("MicroMsg.AppBrandProcessProxyUI", "onCreate, modelClass = %s", new Object[] { paramBundle });
      if (bt.isNullOrNil(paramBundle)) {}
      while (i == 0)
      {
        finish();
        AppMethodBeat.o(45398);
        return;
        this.juo = AppBrandProxyUIProcessTask.a.HC(paramBundle);
        if (this.juo == null)
        {
          ad.e("MicroMsg.AppBrandProcessProxyUI", "onCreate unknown model class = %s", new Object[] { paramBundle });
        }
        else
        {
          if (getIntent().getBooleanExtra("key_request_need_params", true))
          {
            this.jup = ((AppBrandProxyUIProcessTask.ProcessRequest)getIntent().getParcelableExtra("key_request_parcel"));
            if (this.jup == null) {
              ad.e("MicroMsg.AppBrandProcessProxyUI", "onCreate unknown request class = %s", new Object[] { paramBundle });
            }
          }
          else
          {
            this.jup = null;
            continue;
          }
          paramBundle = this.juo;
          paramBundle.juQ = this;
          if ((paramBundle instanceof LifecycleObserver)) {
            paramBundle.aXi().getLifecycle().addObserver((LifecycleObserver)paramBundle);
          }
          this.juo.a(this.jup);
          i = 1;
        }
      }
    case 2: 
      paramBundle = cI(getIntent().getStringExtra("key_alert_title"), "");
      localObject = cI(getIntent().getStringExtra("key_alert_message"), getString(2131755906));
      String str1 = cI(getIntent().getStringExtra("key_alert_confirm"), "");
      final String str2 = cI(getIntent().getStringExtra("key_alert_deny"), "");
      this.juu = new a((byte)0);
      this.jut = h.a(this, (String)localObject, paramBundle, str1, str2, false, this.juu, this.juu);
      this.jut.setOnDismissListener(this.juu);
      this.jut.setOnKeyListener(new DialogInterface.OnKeyListener()
      {
        public final boolean onKey(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
        {
          AppMethodBeat.i(45388);
          if ((paramAnonymousInt == 4) && (paramAnonymousKeyEvent.getAction() == 1))
          {
            if (!bt.isNullOrNil(str2))
            {
              AppBrandProcessProxyUI.b(AppBrandProcessProxyUI.this).onClick(AppBrandProcessProxyUI.a(AppBrandProcessProxyUI.this), -3);
              paramAnonymousDialogInterface.dismiss();
            }
            AppBrandProcessProxyUI.this.b(null);
          }
          AppMethodBeat.o(45388);
          return false;
        }
      });
      AppMethodBeat.o(45398);
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
            localObject = new com.tencent.mm.hellhoundlib.b.a().bd(paramBundle);
            com.tencent.mm.hellhoundlib.a.a.a(this, ((com.tencent.mm.hellhoundlib.b.a)localObject).adn(), "com/tencent/mm/plugin/appbrand/ipc/AppBrandProcessProxyUI", "onCreate", "(Landroid/os/Bundle;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lS(0));
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/ipc/AppBrandProcessProxyUI", "onCreate", "(Landroid/os/Bundle;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            AppMethodBeat.o(45398);
            return;
          }
          catch (Exception localException2)
          {
            try
            {
              ad.e("MicroMsg.AppBrandProcessProxyUI", "start targetActivity, %s, e = %s", new Object[] { paramBundle, localException2 });
              AppMethodBeat.o(45398);
              return;
            }
            catch (Exception paramBundle)
            {
              AppMethodBeat.o(45398);
              return;
            }
          }
          localException1 = localException1;
          ad.e("MicroMsg.AppBrandProcessProxyUI", "proxyLaunch, Class.forName %s, e = %s", new Object[] { paramBundle.getComponent().getClassName(), localException1 });
        }
      }
    }
    finish();
    AppMethodBeat.o(45398);
  }
  
  public void onCreateBeforeSetContentView()
  {
    AppMethodBeat.i(45397);
    super.onCreateBeforeSetContentView();
    supportRequestWindowFeature(1);
    AppMethodBeat.o(45397);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(45401);
    super.onDestroy();
    if (!this.jus)
    {
      ad.i("MicroMsg.AppBrandProcessProxyUI", "has result not be called when destory");
      ResultReceiver localResultReceiver = (ResultReceiver)getIntent().getParcelableExtra("key_result_receiver");
      if (localResultReceiver != null) {
        localResultReceiver.send(0, null);
      }
    }
    e.aA(this);
    if ((this.jut != null) && (this.jut.isShowing()))
    {
      this.jut.dismiss();
      this.jut = null;
      this.juu = null;
    }
    AppMethodBeat.o(45401);
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(180200);
    super.onRequestPermissionsResult(paramInt, paramArrayOfString, paramArrayOfInt);
    if (this.juo != null) {
      this.juo.s(paramArrayOfInt);
    }
    AppMethodBeat.o(180200);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(45400);
    super.onResume();
    int i = getIntent().getIntExtra("key_running_mode", 0);
    if (i == 10000)
    {
      i = this.jun + 1;
      this.jun = i;
      if (i > 1) {
        try
        {
          Object localObject = (Class)getIntent().getSerializableExtra("key_proxy_launch_appbrand_ui_class");
          if (localObject == null)
          {
            finish();
            AppMethodBeat.o(45400);
            return;
          }
          localObject = new Intent(this, (Class)localObject).putExtra("key_appbrand_bring_ui_to_front", true).addFlags(268435456);
          localObject = new com.tencent.mm.hellhoundlib.b.a().bd(localObject);
          com.tencent.mm.hellhoundlib.a.a.a(this, ((com.tencent.mm.hellhoundlib.b.a)localObject).adn(), "com/tencent/mm/plugin/appbrand/ipc/AppBrandProcessProxyUI", "onResume", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lS(0));
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/ipc/AppBrandProcessProxyUI", "onResume", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          finish();
          AppMethodBeat.o(45400);
          return;
        }
        catch (Exception localException)
        {
          finish();
        }
      }
      AppMethodBeat.o(45400);
      return;
    }
    if (i == 2)
    {
      ad.d("MicroMsg.AppBrandProcessProxyUI", "onResume, RUNNING_MODE_SHOW_ALERT");
      AppMethodBeat.o(45400);
      return;
    }
    boolean bool = aXj();
    ad.d("MicroMsg.AppBrandProcessProxyUI", "onResume, mFinishOnNextResume = %b, finishing = %b, request = %s", new Object[] { Boolean.valueOf(this.juq), Boolean.valueOf(bool), this.jup.getClass().getName() });
    if ((this.juq) && (this.jup.aXq()) && (!bool)) {
      b(null);
    }
    this.juq = true;
    AppMethodBeat.o(45400);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  final class a
    implements DialogInterface.OnClickListener, DialogInterface.OnDismissListener
  {
    private boolean juI = false;
    
    private a() {}
    
    private void rn(int paramInt)
    {
      AppMethodBeat.i(45392);
      if (this.juI)
      {
        AppMethodBeat.o(45392);
        return;
      }
      this.juI = true;
      ResultReceiver localResultReceiver = (ResultReceiver)AppBrandProcessProxyUI.this.getIntent().getParcelableExtra("key_result_receiver");
      if (localResultReceiver != null) {
        localResultReceiver.send(paramInt, null);
      }
      AppMethodBeat.o(45392);
    }
    
    public final void onClick(DialogInterface paramDialogInterface, int paramInt)
    {
      AppMethodBeat.i(45390);
      rn(paramInt);
      AppMethodBeat.o(45390);
    }
    
    public final void onDismiss(DialogInterface paramDialogInterface)
    {
      AppMethodBeat.i(45391);
      rn(-2);
      AppBrandProcessProxyUI.this.b(null);
      AppMethodBeat.o(45391);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ipc.AppBrandProcessProxyUI
 * JD-Core Version:    0.7.0.1
 */