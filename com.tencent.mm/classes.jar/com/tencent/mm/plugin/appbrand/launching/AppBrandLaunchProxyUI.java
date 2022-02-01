package com.tencent.mm.plugin.appbrand.launching;

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
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.TextView;
import androidx.lifecycle.q;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.k;
import com.tencent.mm.modelappbrand.LaunchParamsOptional;
import com.tencent.mm.plugin.appbrand.ba.f;
import com.tencent.mm.plugin.appbrand.ba.g;
import com.tencent.mm.plugin.appbrand.ba.i;
import com.tencent.mm.plugin.appbrand.config.AppBrandLaunchReferrer;
import com.tencent.mm.plugin.appbrand.launching.precondition.c;
import com.tencent.mm.plugin.appbrand.launching.precondition.e;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.secdata.ui.MMSecDataFragmentActivity;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity.a;
import com.tencent.mm.ui.aw;
import com.tencent.mm.ui.statusbar.c.a;

@k
@com.tencent.mm.ui.base.a(7)
public final class AppBrandLaunchProxyUI
  extends MMSecDataFragmentActivity
  implements ab, c.a
{
  private MMActivity.a onActResult;
  private IListener<com.tencent.mm.plugin.appbrand.weishi.g> rDY;
  private com.tencent.mm.plugin.appbrand.launching.precondition.g sVP;
  private View sVQ;
  public final MMHandler sVR;
  public final Runnable sVS;
  private int sVT;
  
  public AppBrandLaunchProxyUI()
  {
    AppMethodBeat.i(47052);
    this.sVR = new MMHandler(Looper.getMainLooper());
    this.sVS = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(174928);
        if ((!AppBrandLaunchProxyUI.this.isDestroyed()) && (!AppBrandLaunchProxyUI.this.isFinishing()) && (AppBrandLaunchProxyUI.a(AppBrandLaunchProxyUI.this) != null) && (AppBrandLaunchProxyUI.a(AppBrandLaunchProxyUI.this).cAU())) {
          try
          {
            if (AppBrandLaunchProxyUI.b(AppBrandLaunchProxyUI.this) == null)
            {
              FrameLayout localFrameLayout = (FrameLayout)AppBrandLaunchProxyUI.this.findViewById(16908290);
              View localView = View.inflate(AppBrandLaunchProxyUI.this, ba.g.mm_progress_dialog, null);
              localFrameLayout.addView(localView, new FrameLayout.LayoutParams(-2, -2, 17));
              ((TextView)localView.findViewById(ba.f.mm_progress_dialog_msg)).setText(ba.i.loading_tips);
              AppBrandLaunchProxyUI.a(AppBrandLaunchProxyUI.this, localView);
            }
            for (;;)
            {
              AppBrandLaunchProxyUI.this.onStatusBarHeightChange(AppBrandLaunchProxyUI.c(AppBrandLaunchProxyUI.this));
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
    this.sVT = 0;
    this.onActResult = null;
    this.rDY = new IListener(com.tencent.mm.app.f.hfK) {};
    AppMethodBeat.o(47052);
  }
  
  public static boolean K(Intent paramIntent)
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
    AppMethodBeat.i(320950);
    a(paramContext, paramString1, null, paramString2, paramInt1, paramInt2, paramAppBrandStatObject, null, paramLaunchParamsOptional);
    AppMethodBeat.o(320950);
  }
  
  public static boolean a(Context paramContext, String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, AppBrandStatObject paramAppBrandStatObject, AppBrandLaunchReferrer paramAppBrandLaunchReferrer, LaunchParamsOptional paramLaunchParamsOptional)
  {
    AppMethodBeat.i(47055);
    if ((Util.isNullOrNil(paramString1)) && (Util.isNullOrNil(paramString2)))
    {
      AppMethodBeat.o(47055);
      return false;
    }
    boolean bool = com.tencent.mm.plugin.appbrand.launching.precondition.f.teH.a(paramContext, paramString1, paramString2, paramString3, paramInt1, paramInt2, paramAppBrandStatObject, paramAppBrandLaunchReferrer, paramLaunchParamsOptional);
    AppMethodBeat.o(47055);
    return bool;
  }
  
  public static boolean a(Context paramContext, String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, String paramString4, AppBrandStatObject paramAppBrandStatObject, AppBrandLaunchReferrer paramAppBrandLaunchReferrer, LaunchParamsOptional paramLaunchParamsOptional)
  {
    AppMethodBeat.i(320961);
    if ((Util.isNullOrNil(paramString1)) && (Util.isNullOrNil(paramString2)))
    {
      AppMethodBeat.o(320961);
      return false;
    }
    boolean bool = com.tencent.mm.plugin.appbrand.launching.precondition.f.teH.a(paramContext, paramString1, paramString2, paramString3, paramInt1, paramInt2, paramAppBrandStatObject, paramAppBrandLaunchReferrer, paramLaunchParamsOptional, paramString4);
    AppMethodBeat.o(320961);
    return bool;
  }
  
  private void acT(String paramString)
  {
    AppMethodBeat.i(320966);
    Log.i("MicroMsg.AppBrandLaunchProxyUI", "onLifecycle:%s, instance:%d", new Object[] { paramString, Integer.valueOf(hashCode()) });
    AppMethodBeat.o(320966);
  }
  
  public final void a(MMActivity.a parama, Intent paramIntent, int paramInt)
  {
    AppMethodBeat.i(47064);
    this.onActResult = parama;
    startActivityForResult(paramIntent, paramInt);
    AppMethodBeat.o(47064);
  }
  
  public final boolean czG()
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
      this.onActResult.mmOnActivityResult(paramInt1, paramInt2, paramIntent);
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
    acT("onCreate-start");
    try
    {
      if (Build.VERSION.SDK_INT >= 21)
      {
        if (getIntent().hasExtra("extra_from_activity_status_bar_color")) {
          getWindow().setStatusBarColor(getIntent().getIntExtra("extra_from_activity_status_bar_color", 0));
        }
        if (getIntent().hasExtra("extra_from_activity_navigation_bar_color")) {
          getWindow().setNavigationBarColor(getIntent().getIntExtra("extra_from_activity_navigation_bar_color", 0));
        }
      }
      aw.mM(this);
      getWindow().setBackgroundDrawable(new ColorDrawable(0));
    }
    catch (Exception paramBundle)
    {
      label118:
      break label118;
    }
    paramBundle = getIntent();
    if (!paramBundle.getBooleanExtra("extra_from_mm", true))
    {
      paramBundle = new c(this);
      this.sVP = paramBundle;
      if (this.sVP == null) {
        break label292;
      }
      Log.i("MicroMsg.AppBrandLaunchProxyUI", "onCreate, instance:%d, uiDelegate %s", new Object[] { Integer.valueOf(hashCode()), this.sVP.getClass().getCanonicalName() });
      this.sVP.L(getIntent());
      if ((!isFinishing()) && (this.sVP.cAU())) {
        this.sVR.postDelayed(this.sVS, 500L);
      }
      this.rDY.alive();
    }
    for (;;)
    {
      acT("onCreate-end");
      AppMethodBeat.o(47056);
      return;
      if (paramBundle.getBooleanExtra("extra_launch_weishi_video", false))
      {
        paramBundle = new com.tencent.mm.plugin.appbrand.weishi.a(this);
        break;
      }
      paramBundle = new e(this);
      break;
      label292:
      Log.e("MicroMsg.AppBrandLaunchProxyUI", "onCreate, instance:%d, null uiDelegate", new Object[] { Integer.valueOf(hashCode()) });
      finish();
    }
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(47060);
    super.onDestroy();
    acT("onDestroy");
    this.sVR.removeCallbacksAndMessages(null);
    if (this.sVP != null)
    {
      this.sVP.onDestroy();
      if (!this.sVP.cAU()) {}
    }
    try
    {
      findViewById(16908290).setVisibility(4);
      label64:
      if (this.rDY != null) {
        this.rDY.dead();
      }
      Object localObject = com.tencent.mm.plugin.appbrand.loading.a.tfg;
      localObject = com.tencent.mm.plugin.appbrand.loading.a.cBd();
      if (localObject != null) {
        try
        {
          unbindService((ServiceConnection)localObject);
          localObject = com.tencent.mm.plugin.appbrand.loading.a.tfg;
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
    acT("onPause");
    if (this.sVP != null)
    {
      this.sVP.onPause();
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
    acT("onResume");
    if (this.sVP != null)
    {
      this.sVP.onResume();
      AppMethodBeat.o(47058);
      return;
    }
    super.finish();
    AppMethodBeat.o(47058);
  }
  
  public final void onStart()
  {
    AppMethodBeat.i(320998);
    super.onStart();
    acT("onStart");
    AppMethodBeat.o(320998);
  }
  
  public final void onStatusBarHeightChange(int paramInt)
  {
    AppMethodBeat.i(47057);
    if ((isFinishing()) || (isDestroyed()))
    {
      AppMethodBeat.o(47057);
      return;
    }
    this.sVT = paramInt;
    if ((this.sVQ != null) && ((this.sVQ.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)))
    {
      ((ViewGroup.MarginLayoutParams)this.sVQ.getLayoutParams()).topMargin = paramInt;
      this.sVQ.requestLayout();
    }
    AppMethodBeat.o(47057);
  }
  
  public final void onStop()
  {
    AppMethodBeat.i(321001);
    super.onStop();
    acT("onStop");
    AppMethodBeat.o(321001);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.AppBrandLaunchProxyUI
 * JD-Core Version:    0.7.0.1
 */