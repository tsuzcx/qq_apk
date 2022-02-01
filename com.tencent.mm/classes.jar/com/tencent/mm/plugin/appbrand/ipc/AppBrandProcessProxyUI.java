package com.tencent.mm.plugin.appbrand.ipc;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.DialogInterface.OnKeyListener;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.BadParcelableException;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.os.ResultReceiver;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import com.tencent.luggage.l.e.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.c;
import com.tencent.mm.plugin.appbrand.ba.i;
import com.tencent.mm.plugin.appbrand.ba.j;
import com.tencent.mm.plugin.appbrand.ui.AppBrandPluginUI;
import com.tencent.mm.plugin.appbrand.ui.AppBrandUI;
import com.tencent.mm.plugin.appbrand.ui.ae;
import com.tencent.mm.sdk.platformtools.IntentUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.k;

@com.tencent.mm.ui.base.a(7)
public class AppBrandProcessProxyUI
  extends MMActivity
  implements e.e, e
{
  public static String ruH = "appbrand_report_key_target_url";
  public static String ruI = "appbrand_report_key_target_activity";
  private AppBrandProxyUIProcessTask ruA;
  private AppBrandProxyUIProcessTask.ProcessRequest ruB;
  private boolean ruC = false;
  private volatile boolean ruD = false;
  private volatile boolean ruE = false;
  private com.tencent.mm.ui.widget.a.e ruF;
  private a ruG;
  private int ruz = 0;
  
  public static void D(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(45394);
    if ((!(paramContext instanceof AppBrandUI)) || ((paramContext instanceof AppBrandPluginUI)))
    {
      paramIntent = new com.tencent.mm.hellhoundlib.b.a().cG(paramIntent);
      com.tencent.mm.hellhoundlib.a.a.b(paramContext, paramIntent.aYi(), "com/tencent/mm/plugin/appbrand/ipc/AppBrandProcessProxyUI", "proxyLaunchByAppBrandUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramContext.startActivity((Intent)paramIntent.sb(0));
      com.tencent.mm.hellhoundlib.a.a.c(paramContext, "com/tencent/mm/plugin/appbrand/ipc/AppBrandProcessProxyUI", "proxyLaunchByAppBrandUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(45394);
      return;
    }
    paramIntent = new Intent(paramContext, AppBrandProcessProxyUI.class).putExtra("key_running_mode", 10000).putExtra("key_proxy_launch_target_intent", paramIntent).putExtra("key_proxy_launch_appbrand_ui_class", paramContext.getClass()).addFlags(268435456);
    paramIntent = new com.tencent.mm.hellhoundlib.b.a().cG(paramIntent);
    com.tencent.mm.hellhoundlib.a.a.b(paramContext, paramIntent.aYi(), "com/tencent/mm/plugin/appbrand/ipc/AppBrandProcessProxyUI", "proxyLaunchByAppBrandUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramContext.startActivity((Intent)paramIntent.sb(0));
    com.tencent.mm.hellhoundlib.a.a.c(paramContext, "com/tencent/mm/plugin/appbrand/ipc/AppBrandProcessProxyUI", "proxyLaunchByAppBrandUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(45394);
  }
  
  public static boolean E(Intent paramIntent)
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
  
  static <_Req extends AppBrandProxyUIProcessTask.ProcessRequest, _Result extends AppBrandProxyUIProcessTask.ProcessResult> void a(final Context paramContext, Class<? extends AppBrandProcessProxyUI> paramClass, final _Req param_Req, final AppBrandProxyUIProcessTask.b<_Result> paramb, Intent paramIntent)
  {
    AppMethodBeat.i(45395);
    if (paramContext == null) {
      paramContext = MMApplicationContext.getContext();
    }
    for (;;)
    {
      String str = param_Req.getTaskClass().getName();
      if (paramClass == null)
      {
        localObject = AppBrandProcessProxyUI.class;
        localObject = new Intent(paramContext, (Class)localObject).putExtra("key_model_class_name", str);
        if (paramb != null) {
          break label150;
        }
        paramb = null;
        label55:
        paramb = ((Intent)localObject).putExtra("key_result_receiver", paramb).putExtra(ruI, param_Req.getUIAlias()).putExtra("key_running_mode", 1);
        if (!param_Req.needParams()) {
          break label172;
        }
        paramb.putExtra("key_request_parcel", param_Req);
      }
      for (;;)
      {
        if ((paramContext instanceof Activity)) {
          break label183;
        }
        paramb.addFlags(268435456);
        if (paramIntent != null) {
          paramb.addFlags(paramIntent.getFlags());
        }
        MMHandlerThread.postToMainThread(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(45386);
            if ((AppBrandProcessProxyUI.class != AppBrandProcessProxyUI.this) && ((paramContext instanceof Activity)))
            {
              localObject1 = (Activity)paramContext;
              localObject2 = paramb;
              com.tencent.mm.hellhoundlib.a.a.a(localObject1, c.a(param_Req.getStartActivityRequestCode(), new com.tencent.mm.hellhoundlib.b.a()).cG(localObject2).aYi(), "com/tencent/mm/plugin/appbrand/ipc/AppBrandProcessProxyUI$2", "run", "()V", "android/app/Activity", "startActivityForResult", "(Landroid/content/Intent;I)V");
              AppMethodBeat.o(45386);
              return;
            }
            Object localObject1 = paramContext;
            Object localObject2 = paramb;
            localObject2 = new com.tencent.mm.hellhoundlib.b.a().cG(localObject2);
            com.tencent.mm.hellhoundlib.a.a.b(localObject1, ((com.tencent.mm.hellhoundlib.b.a)localObject2).aYi(), "com/tencent/mm/plugin/appbrand/ipc/AppBrandProcessProxyUI$2", "run", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            ((Context)localObject1).startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject2).sb(0));
            com.tencent.mm.hellhoundlib.a.a.c(localObject1, "com/tencent/mm/plugin/appbrand/ipc/AppBrandProcessProxyUI$2", "run", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            AppMethodBeat.o(45386);
          }
        });
        AppMethodBeat.o(45395);
        return;
        localObject = paramClass;
        break;
        label150:
        paramb = ResultReceiverFixLeak.a(new ResultReceiver(MMHandler.createFreeHandler(Looper.getMainLooper()))
        {
          public final void onReceiveResult(int paramAnonymousInt, Bundle paramAnonymousBundle)
          {
            AppMethodBeat.i(45385);
            if (paramAnonymousBundle == null)
            {
              paramb.onReceiveResult(null);
              AppMethodBeat.o(45385);
              return;
            }
            paramAnonymousBundle.setClassLoader(AppBrandProcessProxyUI.class.getClassLoader());
            paramAnonymousBundle = (AppBrandProxyUIProcessTask.ProcessResult)paramAnonymousBundle.getParcelable("key_result_parcel");
            paramb.onReceiveResult(paramAnonymousBundle);
            AppMethodBeat.o(45385);
          }
        }, paramContext);
        break label55;
        label172:
        paramb.putExtra("key_request_need_params", false);
      }
      label183:
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
      paramContext = MMApplicationContext.getContext();
    }
    for (;;)
    {
      paramClass = new Intent(paramContext, paramClass).putExtra("key_running_mode", 2).putExtra("key_result_receiver", ResultReceiverFixLeak.a(new ResultReceiver(MMHandler.createFreeHandler(Looper.getMainLooper()))
      {
        public final void onReceiveResult(int paramAnonymousInt, Bundle paramAnonymousBundle)
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
      }, paramContext)).putExtra("key_alert_message", paramString1).putExtra("key_alert_title", paramString2).putExtra("key_alert_confirm", paramString3).putExtra("key_alert_deny", paramString4);
      if (!(paramContext instanceof Activity)) {
        paramClass.addFlags(268435456);
      }
      try
      {
        paramClass = new com.tencent.mm.hellhoundlib.b.a().cG(paramClass);
        com.tencent.mm.hellhoundlib.a.a.b(paramContext, paramClass.aYi(), "com/tencent/mm/plugin/appbrand/ipc/AppBrandProcessProxyUI", "showAlert", "(Landroid/content/Context;Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Landroid/content/DialogInterface$OnClickListener;Landroid/content/DialogInterface$OnClickListener;Landroid/content/DialogInterface$OnClickListener;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramContext.startActivity((Intent)paramClass.sb(0));
        com.tencent.mm.hellhoundlib.a.a.c(paramContext, "com/tencent/mm/plugin/appbrand/ipc/AppBrandProcessProxyUI", "showAlert", "(Landroid/content/Context;Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Landroid/content/DialogInterface$OnClickListener;Landroid/content/DialogInterface$OnClickListener;Landroid/content/DialogInterface$OnClickListener;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(45396);
        return;
      }
      catch (BadParcelableException paramContext)
      {
        Log.printErrStackTrace("MicroMsg.AppBrandProcessProxyUI", paramContext, "showAlert get BadParcelableException", new Object[0]);
        AppMethodBeat.o(45396);
        return;
      }
    }
  }
  
  private static String dN(String paramString1, String paramString2)
  {
    AppMethodBeat.i(45399);
    if (Util.isNullOrNil(paramString1))
    {
      AppMethodBeat.o(45399);
      return paramString2;
    }
    AppMethodBeat.o(45399);
    return paramString1;
  }
  
  public void finish()
  {
    AppMethodBeat.i(45403);
    super.finish();
    overridePendingTransition(0, 0);
    if (this.ruA != null) {
      this.ruA.onProcessInterrupted();
    }
    AppMethodBeat.o(45403);
  }
  
  public final void finishProcess(final AppBrandProxyUIProcessTask.ProcessResult paramProcessResult)
  {
    AppMethodBeat.i(45404);
    this.ruD = true;
    runOnUiThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(45389);
        if ((AppBrandProcessProxyUI.c(AppBrandProcessProxyUI.this) != null) && (!AppBrandProcessProxyUI.c(AppBrandProcessProxyUI.this).onInterceptFinishActivityAction())) {
          AppBrandProcessProxyUI.this.finish();
        }
        for (;;)
        {
          AppBrandProcessProxyUI.this.sendResult(paramProcessResult);
          AppMethodBeat.o(45389);
          return;
          if (IntentUtil.getIntExtra(AppBrandProcessProxyUI.this.getIntent(), "key_running_mode", 0) == 2) {
            AppBrandProcessProxyUI.this.finish();
          }
        }
      }
    });
    AppMethodBeat.o(45404);
  }
  
  public final MMActivity getActivityContext()
  {
    return this;
  }
  
  public int getLayoutId()
  {
    return -1;
  }
  
  public void initActivityCloseAnimation() {}
  
  public final boolean isProcessTerminated()
  {
    AppMethodBeat.i(45405);
    if ((activityHasDestroyed()) || (isFinishing()) || (this.ruD))
    {
      AppMethodBeat.o(45405);
      return true;
    }
    AppMethodBeat.o(45405);
    return false;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(45402);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    com.tencent.luggage.l.e.bt(this).onActivityResult(paramInt1, paramInt2, paramIntent);
    if (this.ruB == null)
    {
      Log.e("MicroMsg.AppBrandProcessProxyUI", "onActivityResult, NULL mRequest");
      finish();
      AppMethodBeat.o(45402);
      return;
    }
    Log.d("MicroMsg.AppBrandProcessProxyUI", "onActivityResult, requestCode = %d, resultCode = %d, request = %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), this.ruB.getClass().getName() });
    this.ruC = false;
    AppMethodBeat.o(45402);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    int i = 0;
    AppMethodBeat.i(45398);
    setTheme(ba.j.MMTheme_NoTitleTranslucent);
    super.onCreate(paramBundle);
    overridePendingTransition(0, 0);
    ae.g(getWindow());
    ae.c(getWindow(), getIntent().getBooleanExtra("key_need_light_status", false));
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
      Log.i("MicroMsg.AppBrandProcessProxyUI", "onCreate, modelClass = %s", new Object[] { paramBundle });
      if (Util.isNullOrNil(paramBundle)) {}
      while (i == 0)
      {
        finish();
        AppMethodBeat.o(45398);
        return;
        this.ruA = AppBrandProxyUIProcessTask.a.ZE(paramBundle);
        if (this.ruA == null)
        {
          Log.e("MicroMsg.AppBrandProcessProxyUI", "onCreate unknown model class = %s", new Object[] { paramBundle });
        }
        else
        {
          if (getIntent().getBooleanExtra("key_request_need_params", true))
          {
            this.ruB = ((AppBrandProxyUIProcessTask.ProcessRequest)getIntent().getParcelableExtra("key_request_parcel"));
            if (this.ruB == null) {
              Log.e("MicroMsg.AppBrandProcessProxyUI", "onCreate unknown request class = %s", new Object[] { paramBundle });
            }
          }
          else
          {
            this.ruB = null;
            continue;
          }
          this.ruA.attach(this);
          this.ruA.handleRequest(this.ruB);
          i = 1;
        }
      }
    case 2: 
      paramBundle = dN(getIntent().getStringExtra("key_alert_title"), "");
      localObject = dN(getIntent().getStringExtra("key_alert_message"), getString(ba.i.app_tip));
      String str1 = dN(getIntent().getStringExtra("key_alert_confirm"), "");
      final String str2 = dN(getIntent().getStringExtra("key_alert_deny"), "");
      this.ruG = new a((byte)0);
      this.ruF = k.a(this, (String)localObject, paramBundle, str1, str2, false, this.ruG, this.ruG);
      this.ruF.setOnDismissListener(this.ruG);
      this.ruF.setOnKeyListener(new DialogInterface.OnKeyListener()
      {
        public final boolean onKey(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
        {
          AppMethodBeat.i(45388);
          if ((paramAnonymousInt == 4) && (paramAnonymousKeyEvent.getAction() == 1))
          {
            if (!Util.isNullOrNil(str2))
            {
              AppBrandProcessProxyUI.b(AppBrandProcessProxyUI.this).onClick(AppBrandProcessProxyUI.a(AppBrandProcessProxyUI.this), -3);
              paramAnonymousDialogInterface.dismiss();
            }
            AppBrandProcessProxyUI.this.finishProcess(null);
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
            localObject = new com.tencent.mm.hellhoundlib.b.a().cG(paramBundle);
            com.tencent.mm.hellhoundlib.a.a.b(this, ((com.tencent.mm.hellhoundlib.b.a)localObject).aYi(), "com/tencent/mm/plugin/appbrand/ipc/AppBrandProcessProxyUI", "onCreate", "(Landroid/os/Bundle;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sb(0));
            com.tencent.mm.hellhoundlib.a.a.c(this, "com/tencent/mm/plugin/appbrand/ipc/AppBrandProcessProxyUI", "onCreate", "(Landroid/os/Bundle;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            AppMethodBeat.o(45398);
            return;
          }
          catch (Exception localException2)
          {
            try
            {
              Log.e("MicroMsg.AppBrandProcessProxyUI", "start targetActivity, %s, e = %s", new Object[] { paramBundle, localException2 });
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
          Log.e("MicroMsg.AppBrandProcessProxyUI", "proxyLaunch, Class.forName %s, e = %s", new Object[] { paramBundle.getComponent().getClassName(), localException1 });
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
    if (!this.ruE)
    {
      Log.i("MicroMsg.AppBrandProcessProxyUI", "has result not be called when destory");
      ResultReceiver localResultReceiver = (ResultReceiver)getIntent().getParcelableExtra("key_result_receiver");
      if (localResultReceiver != null) {
        localResultReceiver.c(0, null);
      }
    }
    com.tencent.luggage.l.e.bu(this);
    if ((this.ruF != null) && (this.ruF.isShowing()))
    {
      this.ruF.dismiss();
      this.ruF = null;
      this.ruG = null;
    }
    AppMethodBeat.o(45401);
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(180200);
    super.onRequestPermissionsResult(paramInt, paramArrayOfString, paramArrayOfInt);
    if (this.ruA != null) {
      this.ruA.onRequestPermissionsResult(paramInt, paramArrayOfString, paramArrayOfInt);
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
      i = this.ruz + 1;
      this.ruz = i;
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
          localObject = new com.tencent.mm.hellhoundlib.b.a().cG(localObject);
          com.tencent.mm.hellhoundlib.a.a.b(this, ((com.tencent.mm.hellhoundlib.b.a)localObject).aYi(), "com/tencent/mm/plugin/appbrand/ipc/AppBrandProcessProxyUI", "onResume", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sb(0));
          com.tencent.mm.hellhoundlib.a.a.c(this, "com/tencent/mm/plugin/appbrand/ipc/AppBrandProcessProxyUI", "onResume", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
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
      Log.d("MicroMsg.AppBrandProcessProxyUI", "onResume, RUNNING_MODE_SHOW_ALERT");
      AppMethodBeat.o(45400);
      return;
    }
    boolean bool = isProcessTerminated();
    Log.d("MicroMsg.AppBrandProcessProxyUI", "onResume, mFinishOnNextResume = %b, finishing = %b, request = %s", new Object[] { Boolean.valueOf(this.ruC), Boolean.valueOf(bool), this.ruB.getClass().getName() });
    if ((this.ruC) && (this.ruB.oneShotForeground()) && (!bool)) {
      finishProcess(null);
    }
    this.ruC = true;
    AppMethodBeat.o(45400);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public final void sendResult(AppBrandProxyUIProcessTask.ProcessResult paramProcessResult)
  {
    AppMethodBeat.i(45406);
    this.ruE = true;
    ResultReceiver localResultReceiver = (ResultReceiver)getIntent().getParcelableExtra("key_result_receiver");
    if ((localResultReceiver != null) && (paramProcessResult != null))
    {
      Bundle localBundle = new Bundle(2);
      localBundle.putParcelable("key_result_parcel", paramProcessResult);
      localResultReceiver.c(0, localBundle);
    }
    AppMethodBeat.o(45406);
  }
  
  final class a
    implements DialogInterface.OnClickListener, DialogInterface.OnDismissListener
  {
    private boolean ruU = false;
    
    private a() {}
    
    private void Ai(int paramInt)
    {
      AppMethodBeat.i(45392);
      if (this.ruU)
      {
        AppMethodBeat.o(45392);
        return;
      }
      this.ruU = true;
      ResultReceiver localResultReceiver = (ResultReceiver)AppBrandProcessProxyUI.this.getIntent().getParcelableExtra("key_result_receiver");
      if (localResultReceiver != null) {
        localResultReceiver.c(paramInt, null);
      }
      AppMethodBeat.o(45392);
    }
    
    public final void onClick(DialogInterface paramDialogInterface, int paramInt)
    {
      AppMethodBeat.i(45390);
      Ai(paramInt);
      AppMethodBeat.o(45390);
    }
    
    public final void onDismiss(DialogInterface paramDialogInterface)
    {
      AppMethodBeat.i(45391);
      Ai(-2);
      AppBrandProcessProxyUI.this.finishProcess(null);
      AppMethodBeat.o(45391);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ipc.AppBrandProcessProxyUI
 * JD-Core Version:    0.7.0.1
 */