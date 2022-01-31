package com.tencent.kinda.framework.app;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import com.tencent.kinda.framework.module.impl.PlatformUIRouterImpl;
import com.tencent.kinda.framework.widget.base.BaseFrActivity;
import com.tencent.kinda.framework.widget.base.BaseFragment;
import com.tencent.kinda.framework.widget.base.FrLifeController;
import com.tencent.kinda.framework.widget.base.IEventFragment;
import com.tencent.kinda.framework.widget.tools.ActivityController;
import com.tencent.kinda.gen.LeftBarButtonType;
import com.tencent.kinda.gen.NavigationBarConfig;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.jc;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;

@com.tencent.mm.ui.base.a(1)
public class UIPageFragmentActivity
  extends BaseFrActivity
  implements IEventFragment
{
  public static final String KEY_PAGE_NAME = "key_page_name";
  public static final String KEY_PAGE_UUID = "key_page_uuid";
  public static final String KEY_PLATFORM_DATA = "key_platform_data";
  public static final String KEY_SUPPORT_SWIPE_BACK = "key_support_swipe_back";
  public static final String TAG = "MicroMsg.UIPageFragmentActivity";
  private static HashMap<Integer, UIPageFragmentActivity.IntentHandler> intentHandler;
  public AtomicInteger REQUEST_CODE_COUNTER;
  private FrLifeController controller;
  private boolean supportSwipeBack;
  
  static
  {
    AppMethodBeat.i(144483);
    intentHandler = new HashMap();
    AppMethodBeat.o(144483);
  }
  
  public UIPageFragmentActivity()
  {
    AppMethodBeat.i(144463);
    this.REQUEST_CODE_COUNTER = new AtomicInteger(4);
    AppMethodBeat.o(144463);
  }
  
  private void initEnterPendingAnim()
  {
    AppMethodBeat.i(144467);
    this.supportSwipeBack = getIntent().getBooleanExtra("key_support_swipe_back", true);
    AppMethodBeat.o(144467);
  }
  
  public boolean addFragment(BaseFragment paramBaseFragment)
  {
    AppMethodBeat.i(144474);
    boolean bool = this.controller.addFragment(paramBaseFragment);
    AppMethodBeat.o(144474);
    return bool;
  }
  
  public boolean convertActivityFromTranslucent()
  {
    return false;
  }
  
  public int getLayoutId()
  {
    return 2130970067;
  }
  
  protected Boolean handleIntent(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(144480);
    UIPageFragmentActivity.IntentHandler localIntentHandler = (UIPageFragmentActivity.IntentHandler)intentHandler.get(Integer.valueOf(paramInt1));
    if (localIntentHandler != null)
    {
      localIntentHandler.handle(paramInt2, paramIntent);
      paramIntent = Boolean.TRUE;
      AppMethodBeat.o(144480);
      return paramIntent;
    }
    paramIntent = Boolean.FALSE;
    AppMethodBeat.o(144480);
    return paramIntent;
  }
  
  public void initView(Bundle paramBundle)
  {
    AppMethodBeat.i(144473);
    if (paramBundle == null)
    {
      AppMethodBeat.o(144473);
      return;
    }
    paramBundle = ActivityController.resolveFragment(paramBundle);
    if (paramBundle != null)
    {
      this.controller.addFragment(paramBundle);
      AppMethodBeat.o(144473);
      return;
    }
    super.onBackPressed();
    AppMethodBeat.o(144473);
  }
  
  public void initWithNavigationBarConfig(NavigationBarConfig paramNavigationBarConfig)
  {
    AppMethodBeat.i(144468);
    BaseFragment localBaseFragment = this.controller.getCurrent();
    ab.i("MicroMsg.UIPageFragmentActivity", "NavigationBarConfig: %s %s", new Object[] { paramNavigationBarConfig, localBaseFragment });
    if ((paramNavigationBarConfig != null) && (getSupportActionBar() != null) && (localBaseFragment != null))
    {
      if (!bo.isNullOrNil(paramNavigationBarConfig.mBackgroundColor)) {
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor(paramNavigationBarConfig.mBackgroundColor)));
      }
      if (!bo.isNullOrNil(paramNavigationBarConfig.mBarTitle)) {
        setMMTitle(paramNavigationBarConfig.mBarTitle);
      }
      if (bo.isNullOrNil(paramNavigationBarConfig.mLeftButtonColor)) {}
    }
    for (;;)
    {
      try
      {
        localDrawable = getResources().getDrawable(2130837612).mutate();
        if (!(localDrawable instanceof StateListDrawable)) {
          continue;
        }
        localDrawable = getResources().getDrawable(2131230945);
        localDrawable.setColorFilter(Color.parseColor(paramNavigationBarConfig.mLeftButtonColor), PorterDuff.Mode.SRC_ATOP);
        updateBackBtn(localDrawable);
        setBackBtnColorFilter(Color.parseColor(paramNavigationBarConfig.mLeftButtonColor));
      }
      catch (Exception localException)
      {
        Drawable localDrawable;
        continue;
        if ((paramNavigationBarConfig.mLeftBarButtonType == LeftBarButtonType.CANCEL) || (paramNavigationBarConfig.mLeftBarButtonType != LeftBarButtonType.NONE)) {
          continue;
        }
        setBackBtnVisible(false);
        continue;
      }
      if (paramNavigationBarConfig.mLeftBarButtonType != LeftBarButtonType.BACK) {
        continue;
      }
      setBackBtn(new UIPageFragmentActivity.1(this));
      localBaseFragment.setTopRightBtnImage(paramNavigationBarConfig.mRightButtonImage);
      localBaseFragment.setTopRightBtnTitle(paramNavigationBarConfig.mRightButtonTitle, paramNavigationBarConfig.mRightButtonColor);
      AppMethodBeat.o(144468);
      return;
      localDrawable.setColorFilter(Color.parseColor(paramNavigationBarConfig.mLeftButtonColor), PorterDuff.Mode.SRC_ATOP);
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(144481);
    ab.d("MicroMsg.UIPageFragmentActivity", "onActivityResult " + paramInt1 + " " + paramInt2);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (PlatformUIRouterImpl.processCallback(this, paramInt1, paramInt2, paramIntent))
    {
      AppMethodBeat.o(144481);
      return;
    }
    if ((this.controller != null) && (this.controller.getFragmentListSize() <= 0)) {
      finish();
    }
    if (handleIntent(paramInt1, paramInt2, paramIntent).booleanValue())
    {
      AppMethodBeat.o(144481);
      return;
    }
    AppMethodBeat.o(144481);
  }
  
  public void onBackPressed()
  {
    AppMethodBeat.i(144477);
    if (!this.controller.getCurrent().onBackPressed()) {
      popFragment();
    }
    AppMethodBeat.o(144477);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(144465);
    ab.d("MicroMsg.UIPageFragmentActivity", "MainFragmentActivity oncreate %s", new Object[] { this });
    h.qsU.cT(782, 37);
    this.controller = new FrLifeController(this);
    initEnterPendingAnim();
    super.onCreate(paramBundle);
    initView(getIntent().getBundleExtra("intent_bundle"));
    AppMethodBeat.o(144465);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(144472);
    super.onDestroy();
    h.qsU.cT(782, 44);
    AppMethodBeat.o(144472);
  }
  
  public void onKeyboardStateChanged()
  {
    boolean bool = true;
    AppMethodBeat.i(144466);
    BaseFragment localBaseFragment = this.controller.getCurrent();
    if (localBaseFragment != null) {
      if (keyboardState() != 1) {
        break label40;
      }
    }
    for (;;)
    {
      localBaseFragment.onKeyboardShow(bool);
      AppMethodBeat.o(144466);
      return;
      label40:
      bool = false;
    }
  }
  
  public void onNewIntent(Intent paramIntent)
  {
    AppMethodBeat.i(144464);
    super.onNewIntent(paramIntent);
    ab.d("MicroMsg.UIPageFragmentActivity", "onNewIntent");
    initView(paramIntent.getBundleExtra("intent_bundle"));
    AppMethodBeat.o(144464);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(144471);
    ab.i("MicroMsg.UIPageFragmentActivity", "onPause");
    super.onPause();
    h.qsU.cT(782, 42);
    com.tencent.mm.sdk.b.a.ymk.l(new jc());
    AppMethodBeat.o(144471);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(144469);
    ab.i("MicroMsg.UIPageFragmentActivity", "onResume");
    super.onResume();
    h.qsU.cT(782, 40);
    AppMethodBeat.o(144469);
  }
  
  public void onSwipe(float paramFloat)
  {
    AppMethodBeat.i(144482);
    ab.i("MicroMsg.UIPageFragmentActivity", "onSwipe %s", new Object[] { Float.valueOf(paramFloat) });
    super.onSwipe(paramFloat);
    AppMethodBeat.o(144482);
  }
  
  public void onSwipeBack()
  {
    AppMethodBeat.i(144478);
    ab.d("MicroMsg.UIPageFragmentActivity", "onSwipeBack onSwipeBack %s %s", new Object[] { Boolean.valueOf(this.supportSwipeBack), this });
    if (!this.supportSwipeBack)
    {
      AppMethodBeat.o(144478);
      return;
    }
    super.onSwipeBack();
    AppMethodBeat.o(144478);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    AppMethodBeat.i(144470);
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
    AppMethodBeat.o(144470);
  }
  
  public boolean popFragment()
  {
    AppMethodBeat.i(144476);
    if (this.controller.popFragment())
    {
      AppMethodBeat.o(144476);
      return true;
    }
    finish();
    AppMethodBeat.o(144476);
    return false;
  }
  
  public void registerIntentHandler(int paramInt, UIPageFragmentActivity.IntentHandler paramIntentHandler)
  {
    AppMethodBeat.i(144479);
    if (intentHandler.containsKey(Integer.valueOf(paramInt)))
    {
      paramIntentHandler = new RuntimeException("request code already registered");
      AppMethodBeat.o(144479);
      throw paramIntentHandler;
    }
    intentHandler.put(Integer.valueOf(paramInt), paramIntentHandler);
    AppMethodBeat.o(144479);
  }
  
  public boolean removeModal(BaseFragment paramBaseFragment)
  {
    AppMethodBeat.i(144475);
    if (this.controller.removeModal(paramBaseFragment))
    {
      AppMethodBeat.o(144475);
      return true;
    }
    if (!PlatformUIRouterImpl.hasWebViewCallbackInMap(this)) {
      finish();
    }
    AppMethodBeat.o(144475);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.kinda.framework.app.UIPageFragmentActivity
 * JD-Core Version:    0.7.0.1
 */