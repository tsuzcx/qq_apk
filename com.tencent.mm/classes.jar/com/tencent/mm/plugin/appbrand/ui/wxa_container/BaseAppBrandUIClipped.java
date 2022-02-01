package com.tencent.mm.plugin.appbrand.ui.wxa_container;

import android.app.Activity;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.FrameLayout;
import com.tencent.luggage.sdk.g.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.ui.MMFragmentActivity;
import com.tencent.mm.ui.MMFragmentActivity.a;
import com.tencent.mm.ui.am;
import com.tencent.mm.ui.r;

public abstract class BaseAppBrandUIClipped
  extends MMFragmentActivity
  implements com.tencent.mm.plugin.appbrand.widget.input.ad
{
  protected a lLE = new a();
  public View mContentView;
  
  static
  {
    r.initLanguage(aj.getContext());
  }
  
  private boolean cP(View paramView)
  {
    if (paramView == null) {}
    InputMethodManager localInputMethodManager;
    do
    {
      do
      {
        return false;
        localInputMethodManager = (InputMethodManager)getSystemService("input_method");
      } while (localInputMethodManager == null);
      paramView = paramView.getWindowToken();
    } while (paramView == null);
    try
    {
      bool = localInputMethodManager.hideSoftInputFromWindow(paramView, 0);
      return bool;
    }
    catch (IllegalArgumentException paramView)
    {
      for (;;)
      {
        com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.AppBrand.BaseAppBrandUIClipped", "hide VKB(View) exception %s", new Object[] { paramView });
        boolean bool = false;
      }
    }
  }
  
  public static void d(Activity paramActivity, int paramInt)
  {
    if ((paramActivity.isFinishing()) || (paramActivity.isDestroyed()) || (paramActivity.getWindow() == null)) {}
    while ((Build.VERSION.SDK_INT < 26) || (r.eRb())) {
      return;
    }
    paramActivity.getWindow().setNavigationBarColor(paramInt);
    boolean bool = am.XC(paramInt);
    paramActivity = paramActivity.getWindow().getDecorView();
    paramInt = paramActivity.getSystemUiVisibility();
    if (bool) {
      paramInt &= 0xFFFFFFEF;
    }
    for (;;)
    {
      paramActivity.setSystemUiVisibility(paramInt);
      return;
      paramInt |= 0x10;
    }
  }
  
  public final void hideVKB()
  {
    hideVKBHavingResult();
  }
  
  public final void hideVKB(View paramView)
  {
    cP(paramView);
  }
  
  public final boolean hideVKBHavingResult()
  {
    View localView = getCurrentFocus();
    if (localView == null) {
      return cP(this.mContentView);
    }
    return cP(localView);
  }
  
  public final boolean initNavigationSwipeBack()
  {
    return false;
  }
  
  public final boolean isNfcFilterEnabled()
  {
    return false;
  }
  
  public final boolean isSupportNavigationSwipeBack()
  {
    return false;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if ((Build.VERSION.SDK_INT >= 28) && (getWindow() != null))
    {
      paramBundle = getWindow().getAttributes();
      paramBundle.layoutInDisplayCutoutMode = 1;
      getWindow().setAttributes(paramBundle);
    }
    onCreateBeforeSetContentView();
    paramBundle = new FrameLayout(this);
    this.mContentView = paramBundle;
    setContentView(paramBundle);
  }
  
  protected void onCreateBeforeSetContentView()
  {
    a.b(this, 10);
    a.b(this, 1);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public final void showVKB()
  {
    r.showVKB(this);
  }
  
  public static final class a
  {
    public int lLF = MMFragmentActivity.a.lLF;
    public int lLG = MMFragmentActivity.a.lLG;
    public int lLH = MMFragmentActivity.a.lLH;
    public int lLI = MMFragmentActivity.a.lLI;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.wxa_container.BaseAppBrandUIClipped
 * JD-Core Version:    0.7.0.1
 */