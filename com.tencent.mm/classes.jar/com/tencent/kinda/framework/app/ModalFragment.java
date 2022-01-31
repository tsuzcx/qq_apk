package com.tencent.kinda.framework.app;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.g;
import android.support.v7.app.ActionBar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.kinda.framework.widget.PlatformWrapLayout;
import com.tencent.kinda.framework.widget.base.BaseFragment;
import com.tencent.kinda.framework.widget.tools.ColorUtil;
import com.tencent.kinda.gen.IUIModal;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.af;
import com.tencent.mm.ui.q;
import java.util.List;

public class ModalFragment
  extends BaseFragment
{
  public static final String TAG = "MicroMsg.ModalFragment";
  private Fragment mPreFragment;
  private View mViewCenterPadding;
  private IUIModal page;
  
  private Fragment getPrevFragment()
  {
    AppMethodBeat.i(144454);
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (getFragmentManager() != null)
    {
      List localList = getFragmentManager().getFragments();
      localObject1 = localObject2;
      if (localList != null)
      {
        localObject1 = localObject2;
        if (localList.size() > 1)
        {
          int i = localList.indexOf(this);
          localObject1 = localObject2;
          if (i - 1 >= 0) {
            localObject1 = (Fragment)localList.get(i - 1);
          }
        }
      }
    }
    AppMethodBeat.o(144454);
    return localObject1;
  }
  
  private void initCenterPaddingView(View paramView)
  {
    AppMethodBeat.i(144450);
    if (paramView != null)
    {
      this.mViewCenterPadding = paramView.findViewById(2131825337);
      int i = af.getStatusBarHeight(getContext());
      this.mViewCenterPadding.setVisibility(0);
      paramView = this.mViewCenterPadding.getLayoutParams();
      paramView.height = i;
      this.mViewCenterPadding.setLayoutParams(paramView);
    }
    AppMethodBeat.o(144450);
  }
  
  private void initPage()
  {
    AppMethodBeat.i(144436);
    if (this.page != null)
    {
      this.page.setPlatformDelegate(this.pagePlatformDelegate);
      covertPlatformData(getActivity().getIntent().getBundleExtra("key_platform_data"));
      ab.i("MicroMsg.ModalFragment", "finish init page");
    }
    AppMethodBeat.o(144436);
  }
  
  private void setCenterPaddingColor(int paramInt)
  {
    AppMethodBeat.i(144449);
    if (this.mViewCenterPadding != null) {
      this.mViewCenterPadding.setBackgroundColor(paramInt);
    }
    AppMethodBeat.o(144449);
  }
  
  public void attachModal(IUIModal paramIUIModal)
  {
    this.page = paramIUIModal;
  }
  
  protected void finalize()
  {
    AppMethodBeat.i(144445);
    super.finalize();
    ab.i("MicroMsg.ModalFragment", "finalize " + this.page);
    AppMethodBeat.o(144445);
  }
  
  public int getIUIHashCode()
  {
    AppMethodBeat.i(144453);
    if (this.page != null)
    {
      int i = this.page.hashCode();
      AppMethodBeat.o(144453);
      return i;
    }
    AppMethodBeat.o(144453);
    return 0;
  }
  
  public String getTagName()
  {
    return "MicroMsg.ModalFragment";
  }
  
  public void initOnCreate()
  {
    AppMethodBeat.i(144444);
    getController().mActionBar.hide();
    initPage();
    if (this.page != null) {
      initPageView();
    }
    AppMethodBeat.o(144444);
  }
  
  public boolean onBackPressed()
  {
    AppMethodBeat.i(144447);
    if (this.page != null)
    {
      this.page.onClickAndroidBack();
      AppMethodBeat.o(144447);
      return true;
    }
    AppMethodBeat.o(144447);
    return false;
  }
  
  public void onCreateLayout(PlatformWrapLayout paramPlatformWrapLayout)
  {
    AppMethodBeat.i(144437);
    this.page.onCreateLayout(paramPlatformWrapLayout);
    AppMethodBeat.o(144437);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    AppMethodBeat.i(144443);
    paramLayoutInflater = super.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    int i;
    if (getContext() != null)
    {
      initCenterPaddingView(paramLayoutInflater);
      this.mPreFragment = getPrevFragment();
      if (this.mPreFragment != null) {
        break label73;
      }
      i = getContext().getResources().getColor(2131690633);
      setActionBarColor(i);
      setCenterPaddingColor(i);
    }
    for (;;)
    {
      AppMethodBeat.o(144443);
      return paramLayoutInflater;
      label73:
      if ((this.mPreFragment instanceof ModalFragment))
      {
        i = ((ModalFragment)this.mPreFragment).getController().dCs();
        setCenterPaddingColor(getContext().getResources().getColor(2131690605));
        setActionBarColor(i);
      }
      else if ((this.mPreFragment instanceof MainFragment))
      {
        i = ((MainFragment)this.mPreFragment).getController().dCs();
        int j = getContext().getResources().getColor(2131690633);
        setActionBarColor((int)ColorUtil.MergeColors(i, j));
        setCenterPaddingColor(j);
      }
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(144440);
    super.onDestroy();
    this.page = null;
    AppMethodBeat.o(144440);
  }
  
  public void onKeyboardShow(boolean paramBoolean)
  {
    AppMethodBeat.i(144446);
    this.pagePlatformFuncDelegate.onKeyboardShow(paramBoolean);
    AppMethodBeat.o(144446);
  }
  
  public void onStart()
  {
    AppMethodBeat.i(144441);
    super.onStart();
    if ((this.page != null) && (getIsEnterBackground()))
    {
      this.page.onModalEnterForeground();
      setIsEnterBackground(false);
    }
    AppMethodBeat.o(144441);
  }
  
  public void onStop()
  {
    AppMethodBeat.i(144442);
    super.onStop();
    if ((this.page != null) && (!getWillBeRemoved()))
    {
      this.page.onModalEnterBackground();
      setIsEnterBackground(true);
    }
    AppMethodBeat.o(144442);
  }
  
  public void restoreActionBarColor()
  {
    AppMethodBeat.i(144448);
    if ((this.mPreFragment instanceof MainFragment))
    {
      super.restoreActionBarColor();
      AppMethodBeat.o(144448);
      return;
    }
    if ((this.mPreFragment == null) && (isFinishing()) && (getContext() != null)) {
      setActionBarColor(16777216);
    }
    AppMethodBeat.o(144448);
  }
  
  public void setTopRightBtnImage(String paramString)
  {
    AppMethodBeat.i(144451);
    this.pagePlatformFuncDelegate.setTopRightBtnImage(paramString);
    AppMethodBeat.o(144451);
  }
  
  public void setTopRightBtnTitle(String paramString1, String paramString2)
  {
    AppMethodBeat.i(144452);
    this.pagePlatformFuncDelegate.setTopRightBtnTitle(paramString1, paramString2);
    AppMethodBeat.o(144452);
  }
  
  public void willActive()
  {
    AppMethodBeat.i(144438);
    super.willActive();
    AppMethodBeat.o(144438);
  }
  
  public void willDeActive()
  {
    AppMethodBeat.i(144439);
    super.willDeActive();
    AppMethodBeat.o(144439);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.kinda.framework.app.ModalFragment
 * JD-Core Version:    0.7.0.1
 */