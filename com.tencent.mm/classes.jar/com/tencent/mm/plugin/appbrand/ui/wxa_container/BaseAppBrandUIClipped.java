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
import com.tencent.mm.plugin.appbrand.widget.input.ad;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.ui.MMFragmentActivity;
import com.tencent.mm.ui.MMFragmentActivity.a;
import com.tencent.mm.ui.am;
import com.tencent.mm.ui.s;

public abstract class BaseAppBrandUIClipped
  extends MMFragmentActivity
  implements ad
{
  public View mContentView;
  protected a mnB = new a();
  
  static
  {
    s.initLanguage(ai.getContext());
  }
  
  private boolean cR(View paramView)
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
        ac.e("MicroMsg.AppBrand.BaseAppBrandUIClipped", "hide VKB(View) exception %s", new Object[] { paramView });
        boolean bool = false;
      }
    }
  }
  
  public static void d(Activity paramActivity, int paramInt)
  {
    if ((paramActivity.isFinishing()) || (paramActivity.isDestroyed()) || (paramActivity.getWindow() == null)) {}
    while ((Build.VERSION.SDK_INT < 26) || (s.fgK())) {
      return;
    }
    paramActivity.getWindow().setNavigationBarColor(paramInt);
    boolean bool = am.ZN(paramInt);
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
    cR(paramView);
  }
  
  public final boolean hideVKBHavingResult()
  {
    View localView = getCurrentFocus();
    if (localView == null) {
      return cR(this.mContentView);
    }
    return cR(localView);
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
    s.showVKB(this);
  }
  
  public static final class a
  {
    public int mnC = MMFragmentActivity.a.mnC;
    public int mnD = MMFragmentActivity.a.mnD;
    public int mnE = MMFragmentActivity.a.mnE;
    public int mnF = MMFragmentActivity.a.mnF;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.wxa_container.BaseAppBrandUIClipped
 * JD-Core Version:    0.7.0.1
 */