package com.tencent.mm.plugin.appbrand.ui.wxa_container;

import android.app.Activity;
import android.app.Dialog;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.widget.input.ah;
import com.tencent.mm.plugin.secdata.ui.MMSecDataFragmentActivity;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.MMFragmentActivity.a;
import com.tencent.mm.ui.au;
import com.tencent.mm.ui.base.h.c;
import com.tencent.mm.ui.t;
import com.tencent.mm.ui.w;
import java.util.ArrayList;
import java.util.Iterator;

public abstract class AppBrandContainerFragmentActivity
  extends MMSecDataFragmentActivity
  implements ah, h.c
{
  private View mContentView;
  protected a rhW = new a();
  private ArrayList<Dialog> rhX;
  
  static
  {
    w.initLanguage(MMApplicationContext.getContext());
  }
  
  private boolean de(View paramView)
  {
    if (paramView == null) {
      return false;
    }
    InputMethodManager localInputMethodManager = (InputMethodManager)getSystemService("input_method");
    if (localInputMethodManager == null) {
      return false;
    }
    paramView = paramView.getWindowToken();
    if (paramView == null) {
      return false;
    }
    try
    {
      boolean bool = localInputMethodManager.hideSoftInputFromWindow(paramView, 0);
      return bool;
    }
    catch (IllegalArgumentException paramView)
    {
      Log.e("MicroMsg.AppBrand.AppBrandContainerFragmentActivity", "hide VKB(View) exception %s", new Object[] { paramView });
    }
    return false;
  }
  
  public static void e(Activity paramActivity, int paramInt)
  {
    if ((paramActivity.isFinishing()) || (paramActivity.isDestroyed()) || (paramActivity.getWindow() == null)) {}
    while ((Build.VERSION.SDK_INT < 26) || (t.hHy())) {
      return;
    }
    paramActivity.getWindow().setNavigationBarColor(paramInt);
    boolean bool = au.auk(paramInt);
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
  
  public final void De(int paramInt)
  {
    e(this, paramInt);
  }
  
  public void addDialog(Dialog paramDialog)
  {
    if (paramDialog == null) {
      return;
    }
    if ((isFinishing()) || (isDestroyed()))
    {
      paramDialog.dismiss();
      return;
    }
    if (this.rhX == null) {
      this.rhX = new ArrayList();
    }
    this.rhX.add(paramDialog);
  }
  
  public final View getContentView()
  {
    return this.mContentView;
  }
  
  public Activity getHostActivity()
  {
    return this;
  }
  
  public final void hideVKB()
  {
    hideVKBHavingResult();
  }
  
  public final void hideVKB(View paramView)
  {
    de(paramView);
  }
  
  public final boolean hideVKBHavingResult()
  {
    View localView = getCurrentFocus();
    if (localView == null) {
      return de(this.mContentView);
    }
    return de(localView);
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
    paramBundle = new a(this);
    this.mContentView = paramBundle;
    setContentView(paramBundle);
  }
  
  protected void onCreateBeforeSetContentView()
  {
    com.tencent.luggage.sdk.h.a.b(this, 10);
    com.tencent.luggage.sdk.h.a.b(this, 1);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (this.rhX != null)
    {
      Iterator localIterator = this.rhX.iterator();
      while (localIterator.hasNext())
      {
        Dialog localDialog = (Dialog)localIterator.next();
        if ((localDialog != null) && (localDialog.isShowing())) {
          localDialog.dismiss();
        }
      }
      this.rhX.clear();
      this.rhX = null;
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public final void showVKB()
  {
    w.showVKB(this);
  }
  
  public static final class a
  {
    public int rhY = MMFragmentActivity.a.rhY;
    public int rhZ = MMFragmentActivity.a.rhZ;
    public int ria = MMFragmentActivity.a.ria;
    public int rib = MMFragmentActivity.a.rib;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.wxa_container.AppBrandContainerFragmentActivity
 * JD-Core Version:    0.7.0.1
 */