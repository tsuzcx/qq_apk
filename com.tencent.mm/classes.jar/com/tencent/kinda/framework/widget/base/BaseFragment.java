package com.tencent.kinda.framework.widget.base;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.ActionBarContainer;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewStub;
import com.facebook.yoga.android.YogaLayout;
import com.tencent.kinda.framework.animate.KindaAnimatorWatch;
import com.tencent.kinda.framework.app.UIPagePlatformFuncDelegateImpl;
import com.tencent.kinda.framework.widget.PlatformWrapLayout;
import com.tencent.kinda.gen.ITransmitKvData;
import com.tencent.kinda.gen.LeftBarButtonType;
import com.tencent.kinda.gen.NavigationBarConfig;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMFragment;
import com.tencent.mm.ui.b.b;
import com.tencent.mm.ui.q;
import com.tencent.mm.ui.r;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;

public abstract class BaseFragment
  extends MMFragment
  implements View.OnTouchListener
{
  public static final String TAG = "MicroMsg.BaseFragment";
  private static int mHasModifyActionBarColor = 0;
  private static int mOriginActionBarColor = 0;
  protected IEventFragment fragEvent;
  private boolean isActive = false;
  private boolean isEnterBackground = false;
  private FrLifeController.IFrLife life;
  private ActionBarContainer mActionBarContainer = null;
  public r mCustomActioinBarController = null;
  protected UIPagePlatformDelegateImpl pagePlatformDelegate;
  protected UIPagePlatformFuncDelegateImpl pagePlatformFuncDelegate;
  private PlatformWrapLayout rootWrapLayout;
  private boolean willBeRemoved = false;
  
  public BaseFragment()
  {
    KindaAnimatorWatch.didObjCreated(hashCode());
  }
  
  public ITransmitKvData covertPlatformData(Bundle paramBundle)
  {
    if (paramBundle != null)
    {
      ITransmitKvData localITransmitKvData = ITransmitKvData.create();
      Iterator localIterator = paramBundle.keySet().iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        Object localObject = paramBundle.get(str);
        if (localObject != null) {
          if ((localObject instanceof String))
          {
            localITransmitKvData.putString(str, (String)localObject);
          }
          else if ((localObject instanceof Long))
          {
            localITransmitKvData.putLong(str, ((Long)localObject).longValue());
          }
          else if ((localObject instanceof Integer))
          {
            localITransmitKvData.putInt(str, ((Integer)localObject).intValue());
          }
          else if ((localObject instanceof ArrayList))
          {
            localObject = (ArrayList)localObject;
            if ((((ArrayList)localObject).get(0) instanceof String)) {
              localITransmitKvData.putListString(str, (ArrayList)localObject);
            } else if ((((ArrayList)localObject).get(0) instanceof Long)) {
              localITransmitKvData.putListLong(str, (ArrayList)localObject);
            } else if ((((ArrayList)localObject).get(0) instanceof Integer)) {
              localITransmitKvData.putListInt(str, (ArrayList)localObject);
            }
          }
        }
      }
      return localITransmitKvData;
    }
    return null;
  }
  
  public void dealContentView(View paramView)
  {
    super.dealContentView(paramView);
    if (isSupportCustomActionBar())
    {
      if (this.mActionBarContainer == null) {
        this.mActionBarContainer = ((ActionBarContainer)((ViewStub)paramView.findViewById(2131825336)).inflate());
      }
      r localr = this.mCustomActioinBarController;
      paramView = (ViewGroup)paramView;
      localr.zbR.MO = paramView;
    }
  }
  
  public boolean dispatchActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    return false;
  }
  
  public boolean dispatchBackEvent()
  {
    ab.d("MicroMsg.BaseFragment", "dispatchBackEvent %s %s", new Object[] { getTagName(), this });
    return false;
  }
  
  public boolean dispatchCreateOptionsMenu(Menu paramMenu)
  {
    return true;
  }
  
  public boolean dispatchOptionsItemSelected(MenuItem paramMenuItem)
  {
    return true;
  }
  
  public View findViewById(int paramInt)
  {
    if (getView() != null) {
      return getView().findViewById(paramInt);
    }
    if (getActivity() != null) {
      return getActivity().findViewById(paramInt);
    }
    return null;
  }
  
  public abstract int getIUIHashCode();
  
  public boolean getIsEnterBackground()
  {
    return this.isEnterBackground;
  }
  
  public int getLayoutId()
  {
    return 2130969958;
  }
  
  public abstract String getTagName();
  
  public boolean getWillBeRemoved()
  {
    return this.willBeRemoved;
  }
  
  protected abstract void initOnCreate();
  
  protected void initPageView()
  {
    YogaLayout localYogaLayout = new YogaLayout(getActivity());
    localYogaLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
    ((ViewGroup)getView().findViewById(2131821084)).addView(localYogaLayout);
    ab.i("MicroMsg.BaseFragment", "initPageView rootLayout %s", new Object[] { localYogaLayout });
    this.rootWrapLayout = new PlatformWrapLayout(localYogaLayout);
    onCreateLayout(this.rootWrapLayout);
  }
  
  public void initWithNavigationBarConfig(NavigationBarConfig paramNavigationBarConfig)
  {
    ab.i("MicroMsg.BaseFragment", "NavigationBarConfig: %s", new Object[] { paramNavigationBarConfig });
    if ((paramNavigationBarConfig != null) && (getController().mActionBar != null))
    {
      if (!bo.isNullOrNil(paramNavigationBarConfig.mBackgroundColor))
      {
        getController().mActionBar.setBackgroundDrawable(new ColorDrawable(Color.parseColor(paramNavigationBarConfig.mBackgroundColor)));
        setActionBarColor(Color.parseColor(paramNavigationBarConfig.mBackgroundColor));
      }
      if (paramNavigationBarConfig.mBarTitle != null) {
        setMMTitle(paramNavigationBarConfig.mBarTitle);
      }
      if (bo.isNullOrNil(paramNavigationBarConfig.mLeftButtonColor)) {}
    }
    for (;;)
    {
      try
      {
        localObject = getResources().getDrawable(2130837612).mutate();
        if (!(localObject instanceof StateListDrawable)) {
          continue;
        }
        localObject = getResources().getDrawable(2131230945);
        ((Drawable)localObject).setColorFilter(Color.parseColor(paramNavigationBarConfig.mLeftButtonColor), PorterDuff.Mode.SRC_ATOP);
        getController().updateBackBtn((Drawable)localObject);
        getController().setBackBtnColorFilter(Color.parseColor(paramNavigationBarConfig.mLeftButtonColor));
      }
      catch (Exception localException)
      {
        Object localObject;
        continue;
        if (paramNavigationBarConfig.mLeftBarButtonType != LeftBarButtonType.CANCEL) {
          continue;
        }
        setBackBtn(new BaseFragment.2(this), 2131230739);
        continue;
        if (paramNavigationBarConfig.mLeftBarButtonType != LeftBarButtonType.NONE) {
          continue;
        }
        getController().setBackBtnVisible(false);
        continue;
      }
      localObject = getController().mActionBar;
      if (localObject != null) {
        ((ActionBar)localObject).setElevation(0.0F);
      }
      if (paramNavigationBarConfig.mLeftBarButtonType != LeftBarButtonType.BACK) {
        continue;
      }
      setBackBtn(new BaseFragment.1(this));
      setTopRightBtnImage(paramNavigationBarConfig.mRightButtonImage);
      setTopRightBtnTitle(paramNavigationBarConfig.mRightButtonTitle, paramNavigationBarConfig.mRightButtonColor);
      return;
      ((Drawable)localObject).setColorFilter(Color.parseColor(paramNavigationBarConfig.mLeftButtonColor), PorterDuff.Mode.SRC_ATOP);
    }
  }
  
  public boolean isActive()
  {
    return this.isActive;
  }
  
  public boolean isSupportCustomActionBar()
  {
    return true;
  }
  
  public void onActivityCreated(Bundle paramBundle)
  {
    super.onActivityCreated(paramBundle);
    ab.d("MicroMsg.BaseFragment", "onActivityCreated %s %s", new Object[] { getTagName(), this });
  }
  
  public void onAttach(Activity paramActivity)
  {
    ab.d("MicroMsg.BaseFragment", "onAttach %s %s", new Object[] { getTagName(), this });
    super.onAttach(paramActivity);
    try
    {
      this.fragEvent = ((IEventFragment)paramActivity);
      return;
    }
    catch (ClassCastException paramActivity)
    {
      ab.e("MicroMsg.BaseFragment", "error IEventFragment");
    }
  }
  
  public void onAttach(Context paramContext)
  {
    super.onAttach(paramContext);
    if (isSupportCustomActionBar())
    {
      this.mCustomActioinBarController = new r();
      paramContext = this.mCustomActioinBarController;
      paramContext.zbQ = this;
      paramContext.zbR = new b(thisActivity(), paramContext);
      setActivityController(this.mCustomActioinBarController);
    }
  }
  
  public abstract boolean onBackPressed();
  
  public void onCreate(Bundle paramBundle)
  {
    ab.d("MicroMsg.BaseFragment", "onCreate %s %s", new Object[] { getTagName(), this });
    super.onCreate(paramBundle);
    if (this.life != null) {
      this.life.onCreate(paramBundle);
    }
  }
  
  protected abstract void onCreateLayout(PlatformWrapLayout paramPlatformWrapLayout);
  
  public void onDestroy()
  {
    super.onDestroy();
    ab.d("MicroMsg.BaseFragment", "onDestroy %s %s", new Object[] { getTagName(), this });
    if (this.life != null) {
      this.life.onDestroy();
    }
    this.life = null;
  }
  
  public void onDestroyView()
  {
    super.onDestroyView();
    ab.d("MicroMsg.BaseFragment", "onDestroyView %s %s", new Object[] { getTagName(), this });
    this.pagePlatformDelegate = null;
    this.pagePlatformFuncDelegate = null;
    restoreActionBarColor();
  }
  
  public void onDetach()
  {
    ab.d("MicroMsg.BaseFragment", "onDetach %s %s", new Object[] { getTagName(), this });
    super.onDetach();
    this.fragEvent = null;
  }
  
  public void onHiddenChanged(boolean paramBoolean)
  {
    super.onHiddenChanged(paramBoolean);
    ab.i("MicroMsg.BaseFragment", "onHiddenChanged %s", new Object[] { Boolean.valueOf(paramBoolean) });
  }
  
  public abstract void onKeyboardShow(boolean paramBoolean);
  
  public void onPause()
  {
    super.onPause();
    ab.d("MicroMsg.BaseFragment", "onPause %s %s", new Object[] { getTagName(), this });
    if (this.life != null) {
      this.life.onPause();
    }
  }
  
  public void onResume()
  {
    ab.d("MicroMsg.BaseFragment", "onResume %s %s", new Object[] { getTagName(), this });
    super.onResume();
    if (this.life != null) {
      this.life.onResume();
    }
  }
  
  public void onStart()
  {
    super.onStart();
    ab.d("MicroMsg.BaseFragment", "onStart %s %s", new Object[] { getTagName(), this });
  }
  
  public void onStop()
  {
    super.onStop();
    ab.d("MicroMsg.BaseFragment", "onStop %s %s", new Object[] { getTagName(), this });
  }
  
  public void onSwipeBack()
  {
    super.onSwipeBack();
    ab.d("MicroMsg.BaseFragment", "onSwipeBack %s %s", new Object[] { getTagName(), this });
    this.fragEvent.popFragment();
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    return true;
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    ab.d("MicroMsg.BaseFragment", "onViewCreated %s %s", new Object[] { getTagName(), this });
    this.pagePlatformDelegate = new UIPagePlatformDelegateImpl(getActivity());
    this.pagePlatformFuncDelegate = new UIPagePlatformFuncDelegateImpl(this);
    initOnCreate();
    KindaAnimatorWatch.didViewCreated(hashCode());
    paramView.setOnTouchListener(this);
  }
  
  public void popFragment()
  {
    if (this.fragEvent != null) {
      this.fragEvent.popFragment();
    }
  }
  
  protected void restoreActionBarColor()
  {
    if (isFinishing()) {}
    while ((mOriginActionBarColor == 0) || (getController().dCs() != mHasModifyActionBarColor)) {
      return;
    }
    getController().setActionbarColor(mOriginActionBarColor);
    mHasModifyActionBarColor = 0;
    mOriginActionBarColor = 0;
  }
  
  protected void setActionBarColor(int paramInt)
  {
    mOriginActionBarColor = getController().dCs();
    if (getContext() != null)
    {
      mHasModifyActionBarColor = paramInt;
      getController().setActionbarColor(mHasModifyActionBarColor);
    }
  }
  
  public void setIsEnterBackground(boolean paramBoolean)
  {
    this.isEnterBackground = paramBoolean;
  }
  
  public abstract void setTopRightBtnImage(String paramString);
  
  public abstract void setTopRightBtnTitle(String paramString1, String paramString2);
  
  public void setWillBeRemoved(boolean paramBoolean)
  {
    this.willBeRemoved = paramBoolean;
  }
  
  public boolean supportNavigationSwipeBack()
  {
    return false;
  }
  
  public void watchLife(FrLifeController.IFrLife paramIFrLife)
  {
    this.life = paramIFrLife;
  }
  
  public void willActive()
  {
    ab.d("MicroMsg.BaseFragment", "willActive %s %s", new Object[] { getTagName(), this });
    this.isActive = true;
  }
  
  public void willDeActive()
  {
    this.isActive = false;
    ab.d("MicroMsg.BaseFragment", "willDeActive %s %s", new Object[] { getTagName(), this });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.kinda.framework.widget.base.BaseFragment
 * JD-Core Version:    0.7.0.1
 */