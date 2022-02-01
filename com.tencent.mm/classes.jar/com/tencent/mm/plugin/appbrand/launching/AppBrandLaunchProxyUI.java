package com.tencent.mm.plugin.appbrand.launching;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.graphics.drawable.ColorDrawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Looper;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.k;
import com.tencent.mm.modelappbrand.LaunchParamsOptional;
import com.tencent.mm.plugin.appbrand.au.f;
import com.tencent.mm.plugin.appbrand.au.g;
import com.tencent.mm.plugin.appbrand.au.i;
import com.tencent.mm.plugin.appbrand.config.AppBrandLaunchReferrer;
import com.tencent.mm.plugin.appbrand.launching.e.c;
import com.tencent.mm.plugin.appbrand.launching.e.e;
import com.tencent.mm.plugin.appbrand.launching.e.g;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.secdata.ui.MMSecDataFragmentActivity;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity.a;
import com.tencent.mm.ui.ar;
import com.tencent.mm.ui.statusbar.c.a;

@k
@com.tencent.mm.ui.base.a(7)
public final class AppBrandLaunchProxyUI
  extends MMSecDataFragmentActivity
  implements z, c.a
{
  private IListener<com.tencent.mm.plugin.appbrand.ag.f> oAf;
  private MMActivity.a onActResult;
  private g pRg;
  private View pRh;
  public final MMHandler pRi;
  public final Runnable pRj;
  private int pRk;
  
  public AppBrandLaunchProxyUI()
  {
    AppMethodBeat.i(47052);
    this.pRi = new MMHandler(Looper.getMainLooper());
    this.pRj = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(174928);
        if ((!AppBrandLaunchProxyUI.this.isDestroyed()) && (!AppBrandLaunchProxyUI.this.isFinishing()) && (AppBrandLaunchProxyUI.a(AppBrandLaunchProxyUI.this) != null) && (AppBrandLaunchProxyUI.a(AppBrandLaunchProxyUI.this).caC())) {
          try
          {
            if (AppBrandLaunchProxyUI.b(AppBrandLaunchProxyUI.this) == null)
            {
              FrameLayout localFrameLayout = (FrameLayout)AppBrandLaunchProxyUI.this.findViewById(16908290);
              View localView = View.inflate(AppBrandLaunchProxyUI.this, au.g.mm_progress_dialog, null);
              localFrameLayout.addView(localView, new FrameLayout.LayoutParams(-2, -2, 17));
              ((TextView)localView.findViewById(au.f.mm_progress_dialog_msg)).setText(au.i.loading_tips);
              AppBrandLaunchProxyUI.a(AppBrandLaunchProxyUI.this, localView);
            }
            for (;;)
            {
              AppBrandLaunchProxyUI.this.BF(AppBrandLaunchProxyUI.c(AppBrandLaunchProxyUI.this));
              AppMethodBeat.o(174928);
              return;
              AppBrandLaunchProxyUI.b(AppBrandLaunchProxyUI.this).setVisibility(0);
            }
            AppMethodBeat.o(174928);
          }
          catch (Exception localException)
          {
            Log.e("MicroMsg.AppBrandLaunchProxyUI", "attach dialog View e=%s", new Object[] { localException });
          }
        }
      }
    };
    this.pRk = 0;
    this.onActResult = null;
    this.oAf = new AppBrandLaunchProxyUI.2(this);
    AppMethodBeat.o(47052);
  }
  
  public static boolean H(Intent paramIntent)
  {
    AppMethodBeat.i(47053);
    if (paramIntent != null) {}
    try
    {
      if ((paramIntent.getComponent() != null) && (paramIntent.getComponent().getShortClassName().equals(".plugin.appbrand.launching.AppBrandLaunchProxyUI")))
      {
        AppMethodBeat.o(47053);
        return true;
      }
      AppMethodBeat.o(47053);
      return false;
    }
    catch (Exception paramIntent)
    {
      AppMethodBeat.o(47053);
    }
    return false;
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2, int paramInt1, int paramInt2, AppBrandStatObject paramAppBrandStatObject, LaunchParamsOptional paramLaunchParamsOptional)
  {
    AppMethodBeat.i(282586);
    a(paramContext, paramString1, null, paramString2, paramInt1, paramInt2, paramAppBrandStatObject, null, paramLaunchParamsOptional);
    AppMethodBeat.o(282586);
  }
  
  public static boolean a(Context paramContext, String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, AppBrandStatObject paramAppBrandStatObject, AppBrandLaunchReferrer paramAppBrandLaunchReferrer, LaunchParamsOptional paramLaunchParamsOptional)
  {
    AppMethodBeat.i(47055);
    if ((Util.isNullOrNil(paramString1)) && (Util.isNullOrNil(paramString2)))
    {
      AppMethodBeat.o(47055);
      return false;
    }
    boolean bool = com.tencent.mm.plugin.appbrand.launching.e.f.pZN.a(paramContext, paramString1, paramString2, paramString3, paramInt1, paramInt2, paramAppBrandStatObject, paramAppBrandLaunchReferrer, paramLaunchParamsOptional);
    AppMethodBeat.o(47055);
    return bool;
  }
  
  public static boolean a(Context paramContext, String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, String paramString4, AppBrandStatObject paramAppBrandStatObject, AppBrandLaunchReferrer paramAppBrandLaunchReferrer, LaunchParamsOptional paramLaunchParamsOptional)
  {
    AppMethodBeat.i(282588);
    if ((Util.isNullOrNil(paramString1)) && (Util.isNullOrNil(paramString2)))
    {
      AppMethodBeat.o(282588);
      return false;
    }
    boolean bool = com.tencent.mm.plugin.appbrand.launching.e.f.pZN.a(paramContext, paramString1, paramString2, paramString3, paramInt1, paramInt2, paramAppBrandStatObject, paramAppBrandLaunchReferrer, paramLaunchParamsOptional, paramString4);
    AppMethodBeat.o(282588);
    return bool;
  }
  
  private void ajS(String paramString)
  {
    AppMethodBeat.i(282589);
    Log.i("MicroMsg.AppBrandLaunchProxyUI", "onLifecycle:%s, instance:%d", new Object[] { paramString, Integer.valueOf(hashCode()) });
    AppMethodBeat.o(282589);
  }
  
  public final void BF(int paramInt)
  {
    AppMethodBeat.i(47057);
    if ((isFinishing()) || (isDestroyed()))
    {
      AppMethodBeat.o(47057);
      return;
    }
    this.pRk = paramInt;
    if ((this.pRh != null) && ((this.pRh.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)))
    {
      ((ViewGroup.MarginLayoutParams)this.pRh.getLayoutParams()).topMargin = paramInt;
      this.pRh.requestLayout();
    }
    AppMethodBeat.o(47057);
  }
  
  public final void a(MMActivity.a parama, Intent paramIntent, int paramInt)
  {
    AppMethodBeat.i(47064);
    this.onActResult = parama;
    startActivityForResult(paramIntent, paramInt);
    AppMethodBeat.o(47064);
  }
  
  public final boolean bZv()
  {
    AppMethodBeat.i(47066);
    if (!isFinishing())
    {
      AppMethodBeat.o(47066);
      return true;
    }
    AppMethodBeat.o(47066);
    return false;
  }
  
  public final boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(47061);
    if (isFinishing())
    {
      AppMethodBeat.o(47061);
      return false;
    }
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    AppMethodBeat.o(47061);
    return bool;
  }
  
  public final void finish()
  {
    AppMethodBeat.i(47063);
    if ((isFinishing()) || (isDestroyed()))
    {
      Log.w("MicroMsg.AppBrandLaunchProxyUI", "AppBrandLaunchProxyUI finish() already finishing");
      AppMethodBeat.o(47063);
      return;
    }
    super.finish();
    Log.i("MicroMsg.AppBrandLaunchProxyUI", "AppBrandLaunchProxyUI finish");
    AppMethodBeat.o(47063);
  }
  
  public final boolean isNfcFilterEnabled()
  {
    return false;
  }
  
  public final boolean isSupportNavigationSwipeBack()
  {
    return false;
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(47065);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (this.onActResult != null) {
      this.onActResult.d(paramInt1, paramInt2, paramIntent);
    }
    this.onActResult = null;
    AppMethodBeat.o(47065);
  }
  
  public final void onBackPressed()
  {
    AppMethodBeat.i(47062);
    finish();
    AppMethodBeat.o(47062);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(47056);
    super.onCreate(paramBundle);
    if (getIntent() == null)
    {
      finish();
      AppMethodBeat.o(47056);
      return;
    }
    ajS("onCreate-start");
    try
    {
      paramBundle = (WindowManager.LayoutParams)getIntent().getParcelableExtra("extra_from_activity_window_attributes");
      if (paramBundle != null) {
        getWindow().setAttributes(paramBundle);
      }
      if (Build.VERSION.SDK_INT >= 21)
      {
        if (getIntent().hasExtra("extra_from_activity_status_bar_color")) {
          getWindow().setStatusBarColor(getIntent().getIntExtra("extra_from_activity_status_bar_color", 0));
        }
        if (getIntent().hasExtra("extra_from_activity_navigation_bar_color")) {
          getWindow().setNavigationBarColor(getIntent().getIntExtra("extra_from_activity_navigation_bar_color", 0));
        }
      }
      ar.kX(this);
      getWindow().setBackgroundDrawable(new ColorDrawable(0));
    }
    catch (Exception paramBundle)
    {
      label147:
      break label147;
    }
    paramBundle = getIntent();
    if (!paramBundle.getBooleanExtra("extra_from_mm", true))
    {
      paramBundle = new c(this);
      this.pRg = paramBundle;
      if (this.pRg == null) {
        break label322;
      }
      Log.i("MicroMsg.AppBrandLaunchProxyUI", "onCreate, instance:%d, uiDelegate %s", new Object[] { Integer.valueOf(hashCode()), this.pRg.getClass().getCanonicalName() });
      this.pRg.I(getIntent());
      if ((!isFinishing()) && (this.pRg.caC())) {
        this.pRi.postDelayed(this.pRj, 500L);
      }
      this.oAf.alive();
    }
    for (;;)
    {
      ajS("onCreate-end");
      AppMethodBeat.o(47056);
      return;
      if (paramBundle.getBooleanExtra("extra_launch_weishi_video", false))
      {
        paramBundle = new com.tencent.mm.plugin.appbrand.ag.a(this);
        break;
      }
      paramBundle = new e(this);
      break;
      label322:
      Log.e("MicroMsg.AppBrandLaunchProxyUI", "onCreate, instance:%d, null uiDelegate", new Object[] { Integer.valueOf(hashCode()) });
      finish();
    }
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(47060);
    super.onDestroy();
    ajS("onDestroy");
    this.pRi.removeCallbacksAndMessages(null);
    if (this.pRg != null)
    {
      this.pRg.onDestroy();
      if (!this.pRg.caC()) {}
    }
    try
    {
      findViewById(16908290).setVisibility(4);
      label64:
      if (this.oAf != null) {
        this.oAf.dead();
      }
      Object localObject = com.tencent.mm.plugin.appbrand.loading.a.qaf;
      localObject = com.tencent.mm.plugin.appbrand.loading.a.caK();
      if (localObject != null) {
        try
        {
          unbindService((ServiceConnection)localObject);
          localObject = com.tencent.mm.plugin.appbrand.loading.a.qaf;
          com.tencent.mm.plugin.appbrand.loading.a.a(null);
          Log.i("MicroMsg.AppBrandLaunchProxyUI", "onDestroy: unbindService");
          AppMethodBeat.o(47060);
          return;
        }
        catch (Exception localException)
        {
          Log.d("MicroMsg.AppBrandLaunchProxyUI", "onDestroy: ", new Object[] { localException });
        }
      }
      AppMethodBeat.o(47060);
      return;
    }
    catch (NullPointerException localNullPointerException)
    {
      break label64;
    }
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(47059);
    super.onPause();
    ajS("onPause");
    if (this.pRg != null)
    {
      this.pRg.onPause();
      AppMethodBeat.o(47059);
      return;
    }
    super.finish();
    AppMethodBeat.o(47059);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(47058);
    super.onResume();
    ajS("onResume");
    if (this.pRg != null)
    {
      this.pRg.onResume();
      AppMethodBeat.o(47058);
      return;
    }
    super.finish();
    AppMethodBeat.o(47058);
  }
  
  public final void onStart()
  {
    AppMethodBeat.i(282592);
    super.onStart();
    ajS("onStart");
    AppMethodBeat.o(282592);
  }
  
  public final void onStop()
  {
    AppMethodBeat.i(282593);
    super.onStop();
    ajS("onStop");
    AppMethodBeat.o(282593);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.AppBrandLaunchProxyUI
 * JD-Core Version:    0.7.0.1
 */