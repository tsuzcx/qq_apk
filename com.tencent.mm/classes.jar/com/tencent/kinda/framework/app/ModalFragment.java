package com.tencent.kinda.framework.app;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.ActionBar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.kinda.framework.widget.PlatformWrapLayout;
import com.tencent.kinda.framework.widget.base.BaseFragment;
import com.tencent.kinda.framework.widget.tools.ColorUtil;
import com.tencent.kinda.gen.DynamicColor;
import com.tencent.kinda.gen.IUIModal;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.ui.ai;
import com.tencent.mm.ui.r;

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
    if (ai.Eq())
    {
      AppMethodBeat.o(178766);
      return 2131101096;
    }
    AppMethodBeat.o(178766);
    return 2131101097;
  }
  
  private void initCenterPaddingView(View paramView)
  {
    AppMethodBeat.i(18559);
    if (paramView != null)
    {
      this.mViewCenterPadding = paramView.findViewById(2131306427);
      int i = ai.iX(getContext());
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
      covertPlatformData(getActivity().getIntent().getBundleExtra("key_platform_data"));
      ad.i("MicroMsg.ModalFragment", "finish init page");
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
      i = ((ModalFragment)this.mPreFragment).getController().eQV();
      setCenterPaddingColor(getContext().getResources().getColor(2131101053));
      setActionBarColor(i);
      AppMethodBeat.o(178764);
      return;
    }
    if ((this.mPreFragment instanceof MainFragment))
    {
      if ((this.page != null) && (this.page.statusbarColor() != null) && (this.page.statusbarColor().mNormalColor > 0L))
      {
        setActionBarColor((int)ColorUtil.getColorByModeNoCompat(this.page.statusbarColor()));
        AppMethodBeat.o(178764);
        return;
      }
      i = ((MainFragment)this.mPreFragment).getController().eQV();
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
    ad.i("MicroMsg.ModalFragment", "finalize " + this.page);
    AppMethodBeat.o(18554);
  }
  
  public int getIUIHashCode()
  {
    AppMethodBeat.i(18562);
    if (this.page != null)
    {
      int i = this.page.hashCode();
      AppMethodBeat.o(18562);
      return i;
    }
    AppMethodBeat.o(18562);
    return 0;
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
    if (getContext() != null)
    {
      if (this.page.IsShowAndroidCenterPadding()) {
        initCenterPaddingView(paramLayoutInflater);
      }
      setupActionAndStatusBarColor();
    }
    AppMethodBeat.o(18552);
    return paramLayoutInflater;
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(18549);
    super.onDestroy();
    this.page = null;
    AppMethodBeat.o(18549);
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
    AppMethodBeat.i(186415);
    if (this.pagePlatformFuncDelegate != null) {
      this.pagePlatformFuncDelegate.onKeyboardShow(paramBoolean, paramInt);
    }
    AppMethodBeat.o(186415);
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
  
  public void restoreActionBarColor()
  {
    AppMethodBeat.i(18557);
    if ((this.mPreFragment == null) && (isFinishing()))
    {
      if (getContext() != null)
      {
        setActionBarColor(16777216);
        AppMethodBeat.o(18557);
      }
    }
    else {
      super.restoreActionBarColor();
    }
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.kinda.framework.app.ModalFragment
 * JD-Core Version:    0.7.0.1
 */