package com.tencent.mm.plugin.appbrand.launching;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
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
import com.tencent.mm.plugin.appbrand.launching.e.e;
import com.tencent.mm.plugin.appbrand.launching.e.g;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.MMActivity.a;
import com.tencent.mm.ui.MMBaseActivity;
import com.tencent.mm.ui.statusbar.c.a;

@i
@com.tencent.mm.ui.base.a(7)
public final class AppBrandLaunchProxyUI
  extends MMBaseActivity
  implements ab, c.a
{
  private com.tencent.mm.sdk.b.c<com.tencent.mm.plugin.appbrand.ab.f> kwW;
  private g lEa;
  private View lEb;
  public final ap lEc;
  public final Runnable lEd;
  private int lEe;
  private MMActivity.a onActResult;
  
  public AppBrandLaunchProxyUI()
  {
    AppMethodBeat.i(47052);
    this.lEc = new ap(Looper.getMainLooper());
    this.lEd = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(174928);
        if ((!AppBrandLaunchProxyUI.this.isDestroyed()) && (!AppBrandLaunchProxyUI.this.isFinishing()) && (AppBrandLaunchProxyUI.a(AppBrandLaunchProxyUI.this) != null) && (AppBrandLaunchProxyUI.a(AppBrandLaunchProxyUI.this).bsa())) {
          try
          {
            if (AppBrandLaunchProxyUI.b(AppBrandLaunchProxyUI.this) == null)
            {
              FrameLayout localFrameLayout = (FrameLayout)AppBrandLaunchProxyUI.this.findViewById(16908290);
              View localView = View.inflate(AppBrandLaunchProxyUI.this, 2131494896, null);
              localFrameLayout.addView(localView, new FrameLayout.LayoutParams(-2, -2, 17));
              ((TextView)localView.findViewById(2131302339)).setText(2131760709);
              AppBrandLaunchProxyUI.a(AppBrandLaunchProxyUI.this, localView);
            }
            for (;;)
            {
              AppBrandLaunchProxyUI.this.ua(AppBrandLaunchProxyUI.c(AppBrandLaunchProxyUI.this));
              AppMethodBeat.o(174928);
              return;
              AppBrandLaunchProxyUI.b(AppBrandLaunchProxyUI.this).setVisibility(0);
            }
            AppMethodBeat.o(174928);
          }
          catch (Exception localException)
          {
            ad.e("MicroMsg.AppBrandLaunchProxyUI", "attach dialog View e=%s", new Object[] { localException });
          }
        }
      }
    };
    this.lEe = 0;
    this.onActResult = null;
    this.kwW = new AppBrandLaunchProxyUI.2(this);
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
    AppMethodBeat.i(188580);
    a(paramContext, paramString1, null, paramString2, paramInt1, paramInt2, paramAppBrandStatObject, null, paramLaunchParamsOptional);
    AppMethodBeat.o(188580);
  }
  
  public static boolean a(Context paramContext, String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, AppBrandStatObject paramAppBrandStatObject, AppBrandLaunchReferrer paramAppBrandLaunchReferrer, LaunchParamsOptional paramLaunchParamsOptional)
  {
    AppMethodBeat.i(47055);
    if ((bt.isNullOrNil(paramString1)) && (bt.isNullOrNil(paramString2)))
    {
      AppMethodBeat.o(47055);
      return false;
    }
    boolean bool = com.tencent.mm.plugin.appbrand.launching.e.f.lNC.a(paramContext, paramString1, paramString2, paramString3, paramInt1, paramInt2, paramAppBrandStatObject, paramAppBrandLaunchReferrer, paramLaunchParamsOptional);
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
  
  public final boolean bqI()
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
      ad.w("MicroMsg.AppBrandLaunchProxyUI", "AppBrandLaunchProxyUI finish() already finishing");
      AppMethodBeat.o(47063);
      return;
    }
    super.finish();
    ad.i("MicroMsg.AppBrandLaunchProxyUI", "AppBrandLaunchProxyUI finish");
    AppMethodBeat.o(47063);
  }
  
  protected final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(47065);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (this.onActResult != null) {
      this.onActResult.c(paramInt1, paramInt2, paramIntent);
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
    }
    catch (Exception paramBundle)
    {
      label144:
      break label144;
    }
    paramBundle = getIntent();
    if (!paramBundle.getBooleanExtra("extra_from_mm", true)) {
      paramBundle = new com.tencent.mm.plugin.appbrand.launching.e.c(this);
    }
    for (;;)
    {
      this.lEa = paramBundle;
      if (this.lEa == null) {
        break;
      }
      ad.i("MicroMsg.AppBrandLaunchProxyUI", "onCreate, uiDelegate %s", new Object[] { this.lEa.getClass().getSimpleName() });
      this.lEa.H(getIntent());
      if ((!isFinishing()) && (this.lEa.bsa())) {
        this.lEc.postDelayed(this.lEd, 500L);
      }
      this.kwW.alive();
      AppMethodBeat.o(47056);
      return;
      if (paramBundle.getBooleanExtra("extra_launch_weishi_video", false)) {
        paramBundle = new com.tencent.mm.plugin.appbrand.ab.a(this);
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
    ad.i("MicroMsg.AppBrandLaunchProxyUI", "AppBrandLaunchProxyUI onDestroy");
    this.lEc.removeCallbacksAndMessages(null);
    if (this.lEa != null)
    {
      this.lEa.onDestroy();
      if (!this.lEa.bsa()) {}
    }
    try
    {
      findViewById(16908290).setVisibility(4);
      label65:
      if (this.kwW != null) {
        this.kwW.dead();
      }
      Object localObject = com.tencent.mm.plugin.appbrand.loading.a.lNP;
      localObject = com.tencent.mm.plugin.appbrand.loading.a.bsf();
      if (localObject != null) {
        try
        {
          unbindService((ServiceConnection)localObject);
          localObject = com.tencent.mm.plugin.appbrand.loading.a.lNP;
          com.tencent.mm.plugin.appbrand.loading.a.a(null);
          ad.i("MicroMsg.AppBrandLaunchProxyUI", "onDestroy: unbindService");
          AppMethodBeat.o(47060);
          return;
        }
        catch (Exception localException)
        {
          ad.d("MicroMsg.AppBrandLaunchProxyUI", "onDestroy: ", new Object[] { localException });
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
    ad.i("MicroMsg.AppBrandLaunchProxyUI", "AppBrandLaunchProxyUI onPause");
    if (this.lEa != null)
    {
      this.lEa.onPause();
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
    ad.i("MicroMsg.AppBrandLaunchProxyUI", "AppBrandLaunchProxyUI onResume");
    if (this.lEa != null)
    {
      this.lEa.onResume();
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
  
  public final void ua(int paramInt)
  {
    AppMethodBeat.i(47057);
    if ((isFinishing()) || (isDestroyed()))
    {
      AppMethodBeat.o(47057);
      return;
    }
    this.lEe = paramInt;
    if ((this.lEb != null) && ((this.lEb.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)))
    {
      ((ViewGroup.MarginLayoutParams)this.lEb.getLayoutParams()).topMargin = paramInt;
      this.lEb.requestLayout();
    }
    AppMethodBeat.o(47057);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.AppBrandLaunchProxyUI
 * JD-Core Version:    0.7.0.1
 */