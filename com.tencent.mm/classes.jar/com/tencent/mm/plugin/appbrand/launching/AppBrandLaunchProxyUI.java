package com.tencent.mm.plugin.appbrand.launching;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.i;
import com.tencent.mm.modelappbrand.LaunchParamsOptional;
import com.tencent.mm.plugin.appbrand.config.AppBrandLaunchReferrer;
import com.tencent.mm.plugin.appbrand.launching.precondition.c;
import com.tencent.mm.plugin.appbrand.launching.precondition.e;
import com.tencent.mm.plugin.appbrand.launching.precondition.f;
import com.tencent.mm.plugin.appbrand.launching.precondition.g;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity.a;
import com.tencent.mm.ui.MMBaseActivity;

@i
@com.tencent.mm.ui.base.a(7)
public final class AppBrandLaunchProxyUI
  extends MMBaseActivity
  implements p
{
  private g ijG;
  private MMActivity.a onActResult = null;
  
  public static boolean E(Intent paramIntent)
  {
    AppMethodBeat.i(131706);
    if (paramIntent != null) {}
    try
    {
      if ((paramIntent.getComponent() != null) && (paramIntent.getComponent().getShortClassName().equals(".plugin.appbrand.launching.AppBrandLaunchProxyUI")))
      {
        AppMethodBeat.o(131706);
        return true;
      }
      AppMethodBeat.o(131706);
      return false;
    }
    catch (Exception paramIntent)
    {
      AppMethodBeat.o(131706);
    }
    return false;
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2, int paramInt1, int paramInt2, AppBrandStatObject paramAppBrandStatObject, AppBrandLaunchReferrer paramAppBrandLaunchReferrer, LaunchParamsOptional paramLaunchParamsOptional)
  {
    AppMethodBeat.i(131707);
    a(paramContext, paramString1, null, paramString2, paramInt1, paramInt2, paramAppBrandStatObject, paramAppBrandLaunchReferrer, paramLaunchParamsOptional);
    AppMethodBeat.o(131707);
  }
  
  public static boolean a(Context paramContext, String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, AppBrandStatObject paramAppBrandStatObject, AppBrandLaunchReferrer paramAppBrandLaunchReferrer, LaunchParamsOptional paramLaunchParamsOptional)
  {
    AppMethodBeat.i(131708);
    if ((bo.isNullOrNil(paramString1)) && (bo.isNullOrNil(paramString2)))
    {
      AppMethodBeat.o(131708);
      return false;
    }
    boolean bool = f.ioc.a(paramContext, paramString1, paramString2, paramString3, paramInt1, paramInt2, paramAppBrandStatObject, paramAppBrandLaunchReferrer, paramLaunchParamsOptional);
    AppMethodBeat.o(131708);
    return bool;
  }
  
  public final void a(MMActivity.a parama, Intent paramIntent, int paramInt)
  {
    AppMethodBeat.i(131714);
    this.onActResult = parama;
    startActivityForResult(paramIntent, paramInt);
    AppMethodBeat.o(131714);
  }
  
  public final boolean aGH()
  {
    AppMethodBeat.i(131716);
    if (!isFinishing())
    {
      AppMethodBeat.o(131716);
      return true;
    }
    AppMethodBeat.o(131716);
    return false;
  }
  
  public final boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(143441);
    if (isFinishing())
    {
      AppMethodBeat.o(143441);
      return false;
    }
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    AppMethodBeat.o(143441);
    return bool;
  }
  
  public final void finish()
  {
    AppMethodBeat.i(131713);
    if ((isFinishing()) || (isDestroyed()))
    {
      ab.w("MicroMsg.AppBrandLaunchProxyUI", "finish() already finishing");
      AppMethodBeat.o(131713);
      return;
    }
    super.finish();
    ab.i("MicroMsg.AppBrandLaunchProxyUI", "finish");
    AppMethodBeat.o(131713);
  }
  
  protected final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(131715);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (this.onActResult != null) {
      this.onActResult.c(paramInt1, paramInt2, paramIntent);
    }
    this.onActResult = null;
    AppMethodBeat.o(131715);
  }
  
  public final void onBackPressed()
  {
    AppMethodBeat.i(143442);
    finish();
    AppMethodBeat.o(143442);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(131709);
    super.onCreate(paramBundle);
    if (getIntent() == null)
    {
      finish();
      AppMethodBeat.o(131709);
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
      label353:
      break label144;
    }
    paramBundle = getIntent();
    if (!paramBundle.getBooleanExtra("extra_from_mm", true)) {
      paramBundle = new c(this);
    }
    for (;;)
    {
      this.ijG = paramBundle;
      if (this.ijG == null) {
        break;
      }
      ab.i("MicroMsg.AppBrandLaunchProxyUI", "onCreate, uiDelegate %s", new Object[] { this.ijG.getClass().getSimpleName() });
      this.ijG.F(getIntent());
      if ((isFinishing()) || (!this.ijG.aHw())) {
        break label353;
      }
      try
      {
        paramBundle = (FrameLayout)findViewById(16908290);
        View localView = View.inflate(this, 2130970266, null);
        paramBundle.addView(localView, new FrameLayout.LayoutParams(-2, -2, 17));
        ((TextView)localView.findViewById(2131821848)).setText(2131301086);
        AppMethodBeat.o(131709);
        return;
      }
      catch (Exception paramBundle)
      {
        ab.e("MicroMsg.AppBrandLaunchProxyUI", "attach dialog View e=%s", new Object[] { paramBundle });
        AppMethodBeat.o(131709);
        return;
      }
      if (paramBundle.getBooleanExtra("extra_launch_weishi_video", false)) {
        paramBundle = new com.tencent.mm.plugin.appbrand.weishi.a(this);
      } else {
        paramBundle = new e(this);
      }
    }
    finish();
    AppMethodBeat.o(131709);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(131712);
    super.onDestroy();
    ab.i("MicroMsg.AppBrandLaunchProxyUI", "onDestroy");
    if (this.ijG != null)
    {
      this.ijG.onDestroy();
      if (this.ijG.aHw()) {
        try
        {
          findViewById(16908290).setVisibility(4);
          AppMethodBeat.o(131712);
          return;
        }
        catch (NullPointerException localNullPointerException) {}
      }
    }
    AppMethodBeat.o(131712);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(131711);
    super.onPause();
    ab.i("MicroMsg.AppBrandLaunchProxyUI", "onPause");
    if (this.ijG != null)
    {
      this.ijG.onPause();
      AppMethodBeat.o(131711);
      return;
    }
    super.finish();
    AppMethodBeat.o(131711);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(131710);
    super.onResume();
    ab.i("MicroMsg.AppBrandLaunchProxyUI", "onResume");
    if (this.ijG != null)
    {
      this.ijG.onResume();
      AppMethodBeat.o(131710);
      return;
    }
    super.finish();
    AppMethodBeat.o(131710);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.AppBrandLaunchProxyUI
 * JD-Core Version:    0.7.0.1
 */