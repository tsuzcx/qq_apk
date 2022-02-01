package com.tencent.kinda.framework.app;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout.LayoutParams;
import androidx.appcompat.app.ActionBar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.tencent.kinda.framework.R.color;
import com.tencent.kinda.framework.R.id;
import com.tencent.kinda.framework.widget.PlatformWrapLayout;
import com.tencent.kinda.framework.widget.base.BaseFragment;
import com.tencent.kinda.framework.widget.tools.ColorUtil;
import com.tencent.kinda.gen.DynamicColor;
import com.tencent.kinda.gen.IUIModal;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.aw;
import com.tencent.mm.ui.widget.pulldown.c;
import com.tencent.mm.ui.y;

@c(0)
public class ModalFragment
  extends BaseFragment
{
  public static final String TAG = "MicroMsg.ModalFragment";
  private Fragment mPreFragment;
  private View mViewCenterPadding;
  private IUIModal page;
  
  private int getBlackMaskColorRes()
  {
    AppMethodBeat.i(178766);
    if (aw.isDarkMode())
    {
      i = R.color.wallet_action_bar_black_mask_dark;
      AppMethodBeat.o(178766);
      return i;
    }
    int i = R.color.wallet_action_bar_black_mask_normal;
    AppMethodBeat.o(178766);
    return i;
  }
  
  private void initCenterPaddingView(View paramView)
  {
    AppMethodBeat.i(18559);
    if (paramView != null)
    {
      this.mViewCenterPadding = paramView.findViewById(R.id.view_center_padding);
      int i = aw.getStatusBarHeight(getContext());
      this.mViewCenterPadding.setVisibility(0);
      paramView = this.mViewCenterPadding.getLayoutParams();
      paramView.height = i;
      this.mViewCenterPadding.setLayoutParams(paramView);
    }
    AppMethodBeat.o(18559);
  }
  
  private void initPage()
  {
    AppMethodBeat.i(18545);
    if (this.page != null)
    {
      this.page.setPlatformDelegate(this.pagePlatformDelegate);
      this.page.setFuncDelegate(this.uiModalFuncDelegate);
      covertPlatformData(getActivity().getIntent().getBundleExtra("key_platform_data"));
      if (useKeyboardCoverMode())
      {
        Object localObject = (ViewGroup)findViewById(R.id.kinda_main_container);
        ViewGroup localViewGroup = (ViewGroup)findViewById(R.id.container_layout);
        View localView = findViewById(R.id.tenpay_keyboard_layout);
        localView.setVisibility(8);
        ((ViewGroup)localObject).removeView(localView);
        localObject = new FrameLayout.LayoutParams(-1, -2);
        ((FrameLayout.LayoutParams)localObject).gravity = 80;
        localViewGroup.addView(localView, (ViewGroup.LayoutParams)localObject);
      }
      Log.i("MicroMsg.ModalFragment", "finish init page");
    }
    AppMethodBeat.o(18545);
  }
  
  private void setCenterPaddingColor(int paramInt)
  {
    AppMethodBeat.i(18558);
    if (this.mViewCenterPadding != null) {
      this.mViewCenterPadding.setBackgroundColor(paramInt);
    }
    AppMethodBeat.o(18558);
  }
  
  private void setupActionAndStatusBarColor()
  {
    AppMethodBeat.i(178764);
    if ((this.page != null) && (this.page.statusbarColor() != null) && (this.page.statusbarColor().mNormalColor > 0L))
    {
      setActionBarColor((int)ColorUtil.getColorByModeNoCompat(this.page.statusbarColor()));
      AppMethodBeat.o(178764);
      return;
    }
    Log.w("MicroMsg.ModalFragment", "uimodal should override statusbarColor");
    this.mPreFragment = getPrevFragment();
    int i;
    if (this.mPreFragment == null)
    {
      i = getContext().getResources().getColor(getBlackMaskColorRes());
      setActionBarColor(i);
      setCenterPaddingColor(i);
      AppMethodBeat.o(178764);
      return;
    }
    if ((this.mPreFragment instanceof ModalFragment))
    {
      ((ModalFragment)this.mPreFragment).getController().jjR();
      setCenterPaddingColor(getContext().getResources().getColor(R.color.transparent));
      setActionBarColor(0);
      AppMethodBeat.o(178764);
      return;
    }
    if ((this.mPreFragment instanceof MainFragment))
    {
      i = ((MainFragment)this.mPreFragment).getController().jjR();
      int j = getContext().getResources().getColor(getBlackMaskColorRes());
      setActionBarColor((int)ColorUtil.MergeColors(i, j));
      setCenterPaddingColor(j);
    }
    AppMethodBeat.o(178764);
  }
  
  public void attachModal(IUIModal paramIUIModal)
  {
    this.page = paramIUIModal;
  }
  
  protected void finalize()
  {
    AppMethodBeat.i(18554);
    super.finalize();
    Log.i("MicroMsg.ModalFragment", "finalize " + this.page);
    AppMethodBeat.o(18554);
  }
  
  public String getReportUrl()
  {
    AppMethodBeat.i(226470);
    if (this.page != null)
    {
      String str = this.page.getReportUrl();
      AppMethodBeat.o(226470);
      return str;
    }
    AppMethodBeat.o(226470);
    return "";
  }
  
  public String getTagName()
  {
    return "MicroMsg.ModalFragment";
  }
  
  public void initOnCreate()
  {
    AppMethodBeat.i(18553);
    getController().mActionBar.hide();
    initPage();
    if (this.page != null) {
      initPageView();
    }
    AppMethodBeat.o(18553);
  }
  
  public boolean onBackPressed()
  {
    AppMethodBeat.i(18556);
    if (this.page != null)
    {
      this.page.onClickAndroidBack();
      AppMethodBeat.o(18556);
      return true;
    }
    AppMethodBeat.o(18556);
    return false;
  }
  
  public void onCreateLayout(PlatformWrapLayout paramPlatformWrapLayout)
  {
    AppMethodBeat.i(18546);
    this.page.onCreateLayout(paramPlatformWrapLayout);
    AppMethodBeat.o(18546);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    AppMethodBeat.i(18552);
    paramLayoutInflater = super.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    if ((getContext() != null) && (this.page.IsShowAndroidCenterPadding())) {
      initCenterPaddingView(paramLayoutInflater);
    }
    AppMethodBeat.o(18552);
    return paramLayoutInflater;
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(18549);
    super.onDestroy();
    if (this.page != null) {
      this.page.onDestroy();
    }
    this.page = null;
    AppMethodBeat.o(18549);
  }
  
  public void onFirstRenderFinish()
  {
    AppMethodBeat.i(226445);
    if (this.page != null) {
      this.page.onFirstRenderFinish();
    }
    AppMethodBeat.o(226445);
  }
  
  public void onFragmentOnResume()
  {
    AppMethodBeat.i(178765);
    super.onFragmentOnResume();
    setupActionAndStatusBarColor();
    AppMethodBeat.o(178765);
  }
  
  public void onKeyboardShow(boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(226455);
    if (this.pagePlatformFuncDelegate != null) {
      this.pagePlatformFuncDelegate.onKeyboardShow(paramBoolean, paramInt);
    }
    AppMethodBeat.o(226455);
  }
  
  public void onStart()
  {
    AppMethodBeat.i(18550);
    super.onStart();
    if ((this.page != null) && (getIsEnterBackground()))
    {
      this.page.onModalEnterForeground();
      setIsEnterBackground(false);
    }
    AppMethodBeat.o(18550);
  }
  
  public void onStop()
  {
    AppMethodBeat.i(18551);
    super.onStop();
    if ((this.page != null) && (!getWillBeRemoved()))
    {
      this.page.onModalEnterBackground();
      setIsEnterBackground(true);
    }
    AppMethodBeat.o(18551);
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    AppMethodBeat.i(226433);
    super.onViewCreated(paramView, paramBundle);
    setupActionAndStatusBarColor();
    AppMethodBeat.o(226433);
  }
  
  public void restoreActionBarColor()
  {
    AppMethodBeat.i(18557);
    AppMethodBeat.o(18557);
  }
  
  public void setTopRightBtnImage(String paramString)
  {
    AppMethodBeat.i(18560);
    this.pagePlatformFuncDelegate.setTopRightBtnImage(paramString);
    AppMethodBeat.o(18560);
  }
  
  public void setTopRightBtnTitle(String paramString1, String paramString2)
  {
    AppMethodBeat.i(18561);
    this.pagePlatformFuncDelegate.setTopRightBtnTitle(paramString1, paramString2);
    AppMethodBeat.o(18561);
  }
  
  public boolean useKeyboardCoverMode()
  {
    AppMethodBeat.i(226449);
    if (this.page != null)
    {
      boolean bool = this.page.useKeyboardCoverMode();
      AppMethodBeat.o(226449);
      return bool;
    }
    AppMethodBeat.o(226449);
    return false;
  }
  
  public boolean usePanelModalMode()
  {
    AppMethodBeat.i(226439);
    if (this.page != null)
    {
      boolean bool = this.page.usePanelModalMode();
      AppMethodBeat.o(226439);
      return bool;
    }
    AppMethodBeat.o(226439);
    return false;
  }
  
  public void willActive()
  {
    AppMethodBeat.i(18547);
    super.willActive();
    AppMethodBeat.o(18547);
  }
  
  public void willDeActive()
  {
    AppMethodBeat.i(18548);
    super.willDeActive();
    AppMethodBeat.o(18548);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.kinda.framework.app.ModalFragment
 * JD-Core Version:    0.7.0.1
 */