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
import com.tencent.mm.kernel.i;
import com.tencent.mm.modelappbrand.LaunchParamsOptional;
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
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.statusbar.c.a;

@i
@com.tencent.mm.ui.base.a(7)
public final class AppBrandLaunchProxyUI
  extends MMSecDataFragmentActivity
  implements ab, c.a
{
  private IListener<com.tencent.mm.plugin.appbrand.af.f> lEE;
  private g mQn;
  private View mQo;
  public final MMHandler mQp;
  public final Runnable mQq;
  private int mQr;
  private MMActivity.a onActResult;
  
  public AppBrandLaunchProxyUI()
  {
    AppMethodBeat.i(47052);
    this.mQp = new MMHandler(Looper.getMainLooper());
    this.mQq = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(174928);
        if ((!AppBrandLaunchProxyUI.this.isDestroyed()) && (!AppBrandLaunchProxyUI.this.isFinishing()) && (AppBrandLaunchProxyUI.a(AppBrandLaunchProxyUI.this) != null) && (AppBrandLaunchProxyUI.a(AppBrandLaunchProxyUI.this).bOi())) {
          try
          {
            if (AppBrandLaunchProxyUI.b(AppBrandLaunchProxyUI.this) == null)
            {
              FrameLayout localFrameLayout = (FrameLayout)AppBrandLaunchProxyUI.this.findViewById(16908290);
              View localView = View.inflate(AppBrandLaunchProxyUI.this, 2131495634, null);
              localFrameLayout.addView(localView, new FrameLayout.LayoutParams(-2, -2, 17));
              ((TextView)localView.findViewById(2131304734)).setText(2131762446);
              AppBrandLaunchProxyUI.a(AppBrandLaunchProxyUI.this, localView);
            }
            for (;;)
            {
              AppBrandLaunchProxyUI.this.yf(AppBrandLaunchProxyUI.c(AppBrandLaunchProxyUI.this));
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
    this.mQr = 0;
    this.onActResult = null;
    this.lEE = new IListener() {};
    AppMethodBeat.o(47052);
  }
  
  public static boolean G(Intent paramIntent)
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
    AppMethodBeat.i(227051);
    a(paramContext, paramString1, null, paramString2, paramInt1, paramInt2, paramAppBrandStatObject, null, paramLaunchParamsOptional);
    AppMethodBeat.o(227051);
  }
  
  public static boolean a(Context paramContext, String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, AppBrandStatObject paramAppBrandStatObject, AppBrandLaunchReferrer paramAppBrandLaunchReferrer, LaunchParamsOptional paramLaunchParamsOptional)
  {
    AppMethodBeat.i(47055);
    if ((Util.isNullOrNil(paramString1)) && (Util.isNullOrNil(paramString2)))
    {
      AppMethodBeat.o(47055);
      return false;
    }
    boolean bool = com.tencent.mm.plugin.appbrand.launching.e.f.mZp.a(paramContext, paramString1, paramString2, paramString3, paramInt1, paramInt2, paramAppBrandStatObject, paramAppBrandLaunchReferrer, paramLaunchParamsOptional);
    AppMethodBeat.o(47055);
    return bool;
  }
  
  public final void a(MMActivity.a parama, Intent paramIntent, int paramInt)
  {
    AppMethodBeat.i(47064);
    this.onActResult = parama;
    startActivityForResult(paramIntent, paramInt);
    AppMethodBeat.o(47064);
  }
  
  public final boolean bNd()
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
    setRequestedOrientation(-1);
    int i = getIntent().getIntExtra("key_from_activity_requested_orientation", -1);
    if (i != -1) {
      setRequestedOrientation(i);
    }
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
      ao.jV(this);
      getWindow().setBackgroundDrawable(new ColorDrawable(0));
    }
    catch (Exception paramBundle)
    {
      label163:
      break label163;
    }
    paramBundle = getIntent();
    if (!paramBundle.getBooleanExtra("extra_from_mm", true)) {
      paramBundle = new c(this);
    }
    for (;;)
    {
      this.mQn = paramBundle;
      if (this.mQn == null) {
        break;
      }
      Log.i("MicroMsg.AppBrandLaunchProxyUI", "onCreate, uiDelegate %s", new Object[] { this.mQn.getClass().getSimpleName() });
      this.mQn.H(getIntent());
      if ((!isFinishing()) && (this.mQn.bOi())) {
        this.mQp.postDelayed(this.mQq, 500L);
      }
      this.lEE.alive();
      AppMethodBeat.o(47056);
      return;
      if (paramBundle.getBooleanExtra("extra_launch_weishi_video", false)) {
        paramBundle = new com.tencent.mm.plugin.appbrand.af.a(this);
      } else {
        paramBundle = new e(this);
      }
    }
    finish();
    AppMethodBeat.o(47056);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(47060);
    super.onDestroy();
    Log.i("MicroMsg.AppBrandLaunchProxyUI", "AppBrandLaunchProxyUI onDestroy");
    this.mQp.removeCallbacksAndMessages(null);
    if (this.mQn != null)
    {
      this.mQn.onDestroy();
      if (!this.mQn.bOi()) {}
    }
    try
    {
      findViewById(16908290).setVisibility(4);
      label65:
      if (this.lEE != null) {
        this.lEE.dead();
      }
      Object localObject = com.tencent.mm.plugin.appbrand.loading.a.mZQ;
      localObject = com.tencent.mm.plugin.appbrand.loading.a.bOu();
      if (localObject != null) {
        try
        {
          unbindService((ServiceConnection)localObject);
          localObject = com.tencent.mm.plugin.appbrand.loading.a.mZQ;
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
      break label65;
    }
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(47059);
    super.onPause();
    Log.i("MicroMsg.AppBrandLaunchProxyUI", "AppBrandLaunchProxyUI onPause");
    if (this.mQn != null)
    {
      this.mQn.onPause();
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
    Log.i("MicroMsg.AppBrandLaunchProxyUI", "AppBrandLaunchProxyUI onResume");
    if (this.mQn != null)
    {
      this.mQn.onResume();
      AppMethodBeat.o(47058);
      return;
    }
    super.finish();
    AppMethodBeat.o(47058);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public final void yf(int paramInt)
  {
    AppMethodBeat.i(47057);
    if ((isFinishing()) || (isDestroyed()))
    {
      AppMethodBeat.o(47057);
      return;
    }
    this.mQr = paramInt;
    if ((this.mQo != null) && ((this.mQo.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)))
    {
      ((ViewGroup.MarginLayoutParams)this.mQo.getLayoutParams()).topMargin = paramInt;
      this.mQo.requestLayout();
    }
    AppMethodBeat.o(47057);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.AppBrandLaunchProxyUI
 * JD-Core Version:    0.7.0.1
 */