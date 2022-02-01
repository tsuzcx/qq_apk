package com.tencent.kinda.framework.app;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.ActionBar;
import androidx.fragment.app.FragmentActivity;
import com.tencent.kinda.framework.R.layout;
import com.tencent.kinda.framework.widget.PlatformWrapLayout;
import com.tencent.kinda.framework.widget.base.BaseFragment;
import com.tencent.kinda.framework.widget.base.MMKViewLayout;
import com.tencent.kinda.framework.widget.tools.ColorUtil;
import com.tencent.kinda.gen.IUIPage;
import com.tencent.kinda.gen.NavigationBarConfig;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.widget.SwipeBackLayout;
import com.tencent.mm.ui.widget.pulldown.c;
import com.tencent.mm.ui.y;

@c(0)
public class MainFragment
  extends BaseFragment
{
  public static final String TAG = "MicroMsg.MainFragment";
  private IUIPage page;
  private MMKViewLayout root;
  
  private void initPage()
  {
    AppMethodBeat.i(18531);
    if (this.page != null)
    {
      this.page.setPlatformFuncDelegate(this.pagePlatformFuncDelegate);
      this.page.setPlatformDelegate(this.pagePlatformDelegate);
      covertPlatformData(getActivity().getIntent().getBundleExtra("key_platform_data"));
      initWithNavigationBarConfig(this.page.defaultNavigationBarConfig());
      if ((this.page.fullPageMode()) && (getController().mActionBar != null))
      {
        Log.i("MicroMsg.MainFragment", "UIPage is fullPageMode, so hide Actionbar.");
        getController().mActionBar.hide();
      }
      Log.i("MicroMsg.MainFragment", "finish init page");
    }
    AppMethodBeat.o(18531);
  }
  
  private void setSystemUIByFullMode()
  {
    AppMethodBeat.i(178763);
    int i = (int)ColorUtil.getColorByMode(this.page.defaultNavigationBarConfig().mBackgroundColor);
    setActionBarColor(i);
    getController().setNavigationbarColor(i);
    AppMethodBeat.o(178763);
  }
  
  public void attachPage(IUIPage paramIUIPage)
  {
    this.page = paramIUIPage;
  }
  
  protected void finalize()
  {
    AppMethodBeat.i(18539);
    super.finalize();
    Log.i("MicroMsg.MainFragment", "finalize " + this.page);
    AppMethodBeat.o(18539);
  }
  
  public int getLayoutId()
  {
    return R.layout.kinda_main_container_layout_with_keyboard;
  }
  
  public String getReportUrl()
  {
    AppMethodBeat.i(226404);
    if (this.page != null)
    {
      String str = this.page.getReportUrl();
      AppMethodBeat.o(226404);
      return str;
    }
    AppMethodBeat.o(226404);
    return "";
  }
  
  public String getTagName()
  {
    return "MicroMsg.MainFragment";
  }
  
  public void initOnCreate()
  {
    AppMethodBeat.i(18537);
    initPage();
    if (this.page != null)
    {
      this.page.onCreate();
      initPageView();
    }
    AppMethodBeat.o(18537);
  }
  
  public void initPagePlatformDelegate()
  {
    AppMethodBeat.i(226367);
    super.initPagePlatformDelegate();
    if (this.page != null)
    {
      this.page.setPlatformFuncDelegate(this.pagePlatformFuncDelegate);
      this.page.setPlatformDelegate(this.pagePlatformDelegate);
    }
    AppMethodBeat.o(226367);
  }
  
  public boolean onBackPressed()
  {
    AppMethodBeat.i(18541);
    if (this.page != null)
    {
      this.page.onClickAndroidBack();
      AppMethodBeat.o(18541);
      return true;
    }
    AppMethodBeat.o(18541);
    return false;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(226375);
    if ((this.mCustomActioinBarController != null) && (this.page != null) && (this.page.forceShowInLightMode())) {
      this.mCustomActioinBarController.adEj = false;
    }
    super.onCreate(paramBundle);
    AppMethodBeat.o(226375);
  }
  
  public void onCreateLayout(PlatformWrapLayout paramPlatformWrapLayout)
  {
    AppMethodBeat.i(18538);
    this.root = paramPlatformWrapLayout;
    this.page.onCreateLayout(paramPlatformWrapLayout);
    AppMethodBeat.o(18538);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(18536);
    super.onDestroy();
    if (this.page != null)
    {
      this.page.onBack();
      this.page.onDestroy();
    }
    this.page = null;
    AppMethodBeat.o(18536);
  }
  
  public void onFirstLayoutFinished()
  {
    AppMethodBeat.i(226386);
    if (this.page != null) {
      this.page.onFirstLayoutFinished();
    }
    AppMethodBeat.o(226386);
  }
  
  public void onFragmentOnResume()
  {
    AppMethodBeat.i(178762);
    super.onFragmentOnResume();
    setSystemUIByFullMode();
    AppMethodBeat.o(178762);
  }
  
  public void onKeyboardShow(boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(226395);
    if (this.pagePlatformFuncDelegate != null) {
      this.pagePlatformFuncDelegate.onKeyboardShow(paramBoolean, paramInt);
    }
    if (paramBoolean)
    {
      this.page.keyboardWillShow(paramInt);
      AppMethodBeat.o(226395);
      return;
    }
    this.page.keyboardWillHide();
    AppMethodBeat.o(226395);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(18535);
    super.onPause();
    AppMethodBeat.o(18535);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(18534);
    super.onResume();
    AppMethodBeat.o(18534);
  }
  
  public void setTopRightBtnImage(String paramString)
  {
    AppMethodBeat.i(18542);
    this.pagePlatformFuncDelegate.setTopRightBtnImage(paramString);
    AppMethodBeat.o(18542);
  }
  
  public void setTopRightBtnTitle(String paramString1, String paramString2)
  {
    AppMethodBeat.i(18543);
    this.pagePlatformFuncDelegate.setTopRightBtnTitle(paramString1, paramString2);
    AppMethodBeat.o(18543);
  }
  
  public void willActive()
  {
    AppMethodBeat.i(18532);
    super.willActive();
    if (this.page != null) {
      this.page.onVisible();
    }
    if (getSwipeBackLayout() != null) {
      getSwipeBackLayout().setEnableGesture(false);
    }
    AppMethodBeat.o(18532);
  }
  
  public void willDeActive()
  {
    AppMethodBeat.i(18533);
    super.willDeActive();
    if (this.page != null)
    {
      this.page.onInvisible();
      hideKeyboard();
    }
    AppMethodBeat.o(18533);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.kinda.framework.app.MainFragment
 * JD-Core Version:    0.7.0.1
 */