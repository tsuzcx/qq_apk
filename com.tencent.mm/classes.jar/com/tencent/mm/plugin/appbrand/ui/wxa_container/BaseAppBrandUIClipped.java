package com.tencent.mm.plugin.appbrand.ui.wxa_container;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.FrameLayout;
import com.tencent.luggage.sdk.g.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.config.HalfScreenConfig;
import com.tencent.mm.plugin.appbrand.widget.input.ad;
import com.tencent.mm.plugin.secdata.ui.MMSecDataFragmentActivity;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.MMFragmentActivity.a;
import com.tencent.mm.ui.ar;
import com.tencent.mm.ui.base.h.c;
import com.tencent.mm.ui.r;
import com.tencent.mm.ui.t;
import java.util.ArrayList;

public abstract class BaseAppBrandUIClipped
  extends MMSecDataFragmentActivity
  implements ad, h.c
{
  public View mContentView;
  protected a ogk = new a();
  private ArrayList<Dialog> ogl;
  
  static
  {
    t.initLanguage(MMApplicationContext.getContext());
  }
  
  private boolean cL(View paramView)
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
        Log.e("MicroMsg.AppBrand.BaseAppBrandUIClipped", "hide VKB(View) exception %s", new Object[] { paramView });
        boolean bool = false;
      }
    }
  }
  
  public static void d(Activity paramActivity, int paramInt)
  {
    if ((paramActivity.isFinishing()) || (paramActivity.isDestroyed()) || (paramActivity.getWindow() == null)) {}
    while ((Build.VERSION.SDK_INT < 26) || (r.gII())) {
      return;
    }
    paramActivity.getWindow().setNavigationBarColor(paramInt);
    boolean bool = ar.aln(paramInt);
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
  
  public void addDialog(Dialog paramDialog)
  {
    if (paramDialog == null) {
      return;
    }
    if (this.ogl == null) {
      this.ogl = new ArrayList();
    }
    this.ogl.add(paramDialog);
  }
  
  protected final HalfScreenConfig bZi()
  {
    AppBrandInitConfigWC localAppBrandInitConfigWC = bsC();
    if (localAppBrandInitConfigWC == null) {
      return null;
    }
    return localAppBrandInitConfigWC.kHL;
  }
  
  protected final AppBrandInitConfigWC bsC()
  {
    try
    {
      AppBrandInitConfigWC localAppBrandInitConfigWC = (AppBrandInitConfigWC)getIntent().getParcelableExtra("key_appbrand_init_config");
      return localAppBrandInitConfigWC;
    }
    catch (Exception localException)
    {
      Log.e("MicroMsg.AppBrand.BaseAppBrandUIClipped", "AppBrandInitConfigWC unmarshalling fail! " + localException.getMessage(), new Object[] { "" });
    }
    return null;
  }
  
  public final void hideVKB()
  {
    hideVKBHavingResult();
  }
  
  public final void hideVKB(View paramView)
  {
    cL(paramView);
  }
  
  public final boolean hideVKBHavingResult()
  {
    View localView = getCurrentFocus();
    if (localView == null) {
      return cL(this.mContentView);
    }
    return cL(localView);
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
  
  public void onDestroy()
  {
    super.onDestroy();
    if (this.ogl != null)
    {
      int j = this.ogl.size();
      int i = 0;
      while (i < j)
      {
        Dialog localDialog = (Dialog)this.ogl.get(i);
        if ((localDialog != null) && (localDialog.isShowing())) {
          localDialog.dismiss();
        }
        i += 1;
      }
      this.ogl.clear();
      this.ogl = null;
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public final void setNavigationbarColor(int paramInt)
  {
    d(this, paramInt);
  }
  
  public final void showVKB()
  {
    t.showVKB(this);
  }
  
  public static final class a
  {
    public int ogm = MMFragmentActivity.a.ogm;
    public int ogn = MMFragmentActivity.a.ogn;
    public int ogo = MMFragmentActivity.a.ogo;
    public int ogp = MMFragmentActivity.a.ogp;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.wxa_container.BaseAppBrandUIClipped
 * JD-Core Version:    0.7.0.1
 */