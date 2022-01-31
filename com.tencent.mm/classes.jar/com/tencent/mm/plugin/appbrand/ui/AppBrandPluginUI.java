package com.tencent.mm.plugin.appbrand.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Looper;
import android.os.MessageQueue;
import android.view.KeyEvent;
import android.view.MotionEvent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ad;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.k;
import com.tencent.mm.plugin.appbrand.p;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.ui.MMFragmentActivity.a;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.b;

@a(1)
public class AppBrandPluginUI
  extends AppBrandUI
{
  private boolean iNd = false;
  
  protected final void J(Intent paramIntent)
  {
    AppMethodBeat.i(133008);
    super.J(paramIntent);
    if (this.iOW == null) {}
    for (paramIntent = null;; paramIntent = this.iOW.atG())
    {
      if (p.n(paramIntent)) {
        paramIntent.gPQ = true;
      }
      AppMethodBeat.o(133008);
      return;
    }
  }
  
  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(143595);
    if ((isFinishing()) || (this.iNd))
    {
      AppMethodBeat.o(143595);
      return false;
    }
    boolean bool = super.dispatchKeyEvent(paramKeyEvent);
    AppMethodBeat.o(143595);
    return bool;
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(143596);
    if ((isFinishing()) || (this.iNd))
    {
      AppMethodBeat.o(143596);
      return false;
    }
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    AppMethodBeat.o(143596);
    return bool;
  }
  
  protected void e(AppBrandInitConfigWC paramAppBrandInitConfigWC, AppBrandStatObject paramAppBrandStatObject)
  {
    AppMethodBeat.i(133005);
    if (k.a(this, paramAppBrandInitConfigWC, paramAppBrandStatObject))
    {
      b.a(this, null);
      AppMethodBeat.o(133005);
      return;
    }
    super.overridePendingTransition(MMFragmentActivity.a.zbX, MMFragmentActivity.a.zbY);
    AppMethodBeat.o(133005);
  }
  
  public void initActivityCloseAnimation()
  {
    AppMethodBeat.i(133006);
    if (this.iNd)
    {
      AppMethodBeat.o(133006);
      return;
    }
    super.overridePendingTransition(MMFragmentActivity.a.zbZ, MMFragmentActivity.a.zca);
    AppMethodBeat.o(133006);
  }
  
  public void onEnterAnimationComplete()
  {
    AppMethodBeat.i(133004);
    super.onEnterAnimationComplete();
    b.a(this, null);
    AppMethodBeat.o(133004);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(133003);
    super.onResume();
    if (Build.VERSION.SDK_INT < 21) {
      Looper.myQueue().addIdleHandler(new AppBrandPluginUI.1(this));
    }
    AppMethodBeat.o(133003);
  }
  
  public void onSwipeBack()
  {
    AppMethodBeat.i(133007);
    super.onSwipeBack();
    this.iNd = true;
    AppMethodBeat.o(133007);
  }
  
  public boolean onSwipeBackFinish()
  {
    return true;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.AppBrandPluginUI
 * JD-Core Version:    0.7.0.1
 */