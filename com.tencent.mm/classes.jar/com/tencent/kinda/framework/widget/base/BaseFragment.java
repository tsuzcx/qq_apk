package com.tencent.kinda.framework.widget.base;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewStub;
import android.view.Window;
import android.widget.FrameLayout;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.widget.ActionBarContainer;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.e;
import com.facebook.yoga.android.YogaLayout;
import com.tencent.kinda.framework.R.color;
import com.tencent.kinda.framework.R.drawable;
import com.tencent.kinda.framework.R.id;
import com.tencent.kinda.framework.R.layout;
import com.tencent.kinda.framework.R.raw;
import com.tencent.kinda.framework.animate.KindaAnimatorWatch;
import com.tencent.kinda.framework.app.UIPagePlatformFuncDelegateImpl;
import com.tencent.kinda.framework.widget.PlatformWrapLayout;
import com.tencent.kinda.framework.widget.tools.ColorUtil;
import com.tencent.kinda.gen.ITransmitKvData;
import com.tencent.kinda.gen.LeftBarButtonType;
import com.tencent.kinda.gen.NavigationBarConfig;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.a.d;
import com.tencent.mm.compatible.util.g;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMFragment;
import com.tencent.mm.ui.ar;
import com.tencent.mm.ui.au;
import com.tencent.mm.ui.b.b;
import com.tencent.mm.ui.w;
import com.tencent.mm.ui.y;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public abstract class BaseFragment
  extends LifecycleFragment
  implements View.OnTouchListener, FragmentLifecycle
{
  public static final String TAG = "MicroMsg.BaseFragment";
  public int enterAnimStyle = 1;
  protected IEventFragment fragEvent;
  private boolean isActive = false;
  private boolean isEnterBackground = false;
  public boolean isTinyApp = false;
  private FrLifeController.IFrLife life;
  private ActionBarContainer mActionBarContainer = null;
  private BaseFragment mCoveredFragment;
  public y mCustomActioinBarController = null;
  protected UIPagePlatformDelegateImpl pagePlatformDelegate;
  protected UIPagePlatformFuncDelegateImpl pagePlatformFuncDelegate;
  private long statusBarColor = -1L;
  protected FrameLayout statusBarSpaceView;
  public String tinyAppUserName = "";
  protected UIModalFuncDelegateImpl uiModalFuncDelegate;
  private boolean willBeRemoved = false;
  
  public BaseFragment()
  {
    KindaAnimatorWatch.didObjCreated(hashCode());
  }
  
  private void calculateStatusBarColor(int paramInt)
  {
    if (Build.VERSION.SDK_INT < 21) {
      return;
    }
    if ((Build.VERSION.SDK_INT >= 23) && (!g.isMIUIV8())) {}
    for (;;)
    {
      this.statusBarSpaceView.setBackgroundColor(paramInt);
      boolean bool = au.auk(paramInt);
      getController().updataStatusBarIcon(bool);
      getController().q(getActivity(), 0);
      getController().setNavigationbarColor(getResources().getColor(a.d.BG_0));
      return;
      if (Build.VERSION.SDK_INT >= 21) {
        paramInt = au.A(getResources().getColor(R.color.statusbar_fg_drak_color), paramInt);
      } else {
        paramInt = 0;
      }
    }
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
        this.mActionBarContainer = ((ActionBarContainer)((ViewStub)paramView.findViewById(R.id.kinda_custom_action_bar)).inflate());
      }
      y localy = this.mCustomActioinBarController;
      paramView = (ViewGroup)paramView;
      localy.WaO.Rx = paramView;
    }
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
  
  public BaseFragment getCoveredFragment()
  {
    return this.mCoveredFragment;
  }
  
  public abstract int getIUIHashCode();
  
  public boolean getIsEnterBackground()
  {
    return this.isEnterBackground;
  }
  
  public int getLayoutId()
  {
    return R.layout.kinda_main_container_layout_with_keyboard;
  }
  
  protected Fragment getPrevFragment()
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (getFragmentManager() != null)
    {
      List localList = getFragmentManager().getFragments();
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
    return localObject1;
  }
  
  public abstract String getTagName();
  
  public boolean getWillBeRemoved()
  {
    return this.willBeRemoved;
  }
  
  protected abstract void initOnCreate();
  
  public void initPagePlatformDelegate()
  {
    this.pagePlatformDelegate = new UIPagePlatformDelegateImpl(getActivity());
    this.pagePlatformFuncDelegate = new UIPagePlatformFuncDelegateImpl(this);
    this.uiModalFuncDelegate = new UIModalFuncDelegateImpl(this);
  }
  
  protected void initPageView()
  {
    YogaLayout localYogaLayout = new YogaLayout(getActivity());
    localYogaLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
    ((ViewGroup)getView().findViewById(R.id.container)).addView(localYogaLayout);
    Log.i("MicroMsg.BaseFragment", "initPageView rootLayout %s", new Object[] { localYogaLayout });
    onCreateLayout(new PlatformWrapLayout(localYogaLayout));
  }
  
  public void initWithNavigationBarConfig(NavigationBarConfig paramNavigationBarConfig)
  {
    Log.i("MicroMsg.BaseFragment", "NavigationBarConfig: %s", new Object[] { paramNavigationBarConfig });
    if ((paramNavigationBarConfig != null) && (getController().mActionBar != null))
    {
      if (paramNavigationBarConfig.mBackgroundColor != null)
      {
        getController().mActionBar.setBackgroundDrawable(new ColorDrawable((int)ColorUtil.getColorByMode(paramNavigationBarConfig.mBackgroundColor)));
        calculateStatusBarColor((int)ColorUtil.getColorByMode(paramNavigationBarConfig.mBackgroundColor));
      }
      if (paramNavigationBarConfig.mBarTitle != null) {
        setMMTitle(paramNavigationBarConfig.mBarTitle);
      }
      if (Util.isNullOrNil(paramNavigationBarConfig.mLeftButtonColor)) {}
    }
    for (;;)
    {
      try
      {
        localObject = getResources().getDrawable(R.drawable.actionbar_back_icon).mutate();
        if (!(localObject instanceof StateListDrawable)) {
          continue;
        }
        localObject = getResources().getDrawable(R.raw.back_icon_normal);
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
        setBackBtn(new MenuItem.OnMenuItemClickListener()
        {
          public boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
          {
            AppMethodBeat.i(265144);
            BaseFragment.this.popFragment();
            AppMethodBeat.o(265144);
            return true;
          }
        }, R.raw.actionbar_icon_dark_close);
        continue;
        if (paramNavigationBarConfig.mLeftBarButtonType != LeftBarButtonType.NONE) {
          continue;
        }
        getController().setBackBtnVisible(false);
        continue;
      }
      localObject = getController().mActionBar;
      if (localObject != null) {
        ((ActionBar)localObject).e(0.0F);
      }
      if (paramNavigationBarConfig.mLeftBarButtonType != LeftBarButtonType.BACK) {
        continue;
      }
      setBackBtn(new MenuItem.OnMenuItemClickListener()
      {
        public boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(18763);
          BaseFragment.this.popFragment();
          AppMethodBeat.o(18763);
          return true;
        }
      });
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
  
  public boolean isContainSecureView()
  {
    if (this.pagePlatformDelegate != null)
    {
      int i = this.pagePlatformDelegate.getSecureViews().size();
      Log.i("MicroMsg.BaseFragment", "Fragment contains secure view size: %s.", new Object[] { Integer.valueOf(i) });
      if (i > 0) {
        return true;
      }
    }
    return false;
  }
  
  public boolean isSupportCustomActionBar()
  {
    return true;
  }
  
  public void onActivityCreated(Bundle paramBundle)
  {
    super.onActivityCreated(paramBundle);
    Log.d("MicroMsg.BaseFragment", "onActivityCreated %s %s", new Object[] { getTagName(), this });
  }
  
  public void onAttach(Activity paramActivity)
  {
    Log.d("MicroMsg.BaseFragment", "onAttach %s %s", new Object[] { getTagName(), this });
    super.onAttach(paramActivity);
    try
    {
      this.fragEvent = ((IEventFragment)paramActivity);
      return;
    }
    catch (ClassCastException paramActivity)
    {
      Log.e("MicroMsg.BaseFragment", "error IEventFragment");
    }
  }
  
  public void onAttach(Context paramContext)
  {
    super.onAttach(paramContext);
    if (isSupportCustomActionBar())
    {
      this.mCustomActioinBarController = new y();
      paramContext = this.mCustomActioinBarController;
      paramContext.WaN = this;
      paramContext.WaO = new b(thisActivity(), paramContext);
      setActivityController(this.mCustomActioinBarController);
    }
  }
  
  public abstract boolean onBackPressed();
  
  public void onCreate(Bundle paramBundle)
  {
    Log.d("MicroMsg.BaseFragment", "onCreate %s %s", new Object[] { getTagName(), this });
    super.onCreate(paramBundle);
  }
  
  protected abstract void onCreateLayout(PlatformWrapLayout paramPlatformWrapLayout);
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    return super.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
  }
  
  public void onDestroyView()
  {
    super.onDestroyView();
    Log.d("MicroMsg.BaseFragment", "onDestroyView %s %s", new Object[] { getTagName(), this });
    this.pagePlatformDelegate = null;
    this.pagePlatformFuncDelegate = null;
    this.uiModalFuncDelegate = null;
    restoreActionBarColor();
    if (this.life != null) {
      this.life.onDestroyView();
    }
    this.life = null;
  }
  
  public void onDetach()
  {
    Log.d("MicroMsg.BaseFragment", "onDetach %s %s", new Object[] { getTagName(), this });
    super.onDetach();
    this.fragEvent = null;
  }
  
  protected void onFirstRenderFinish() {}
  
  public void onFragmentOnDestroy()
  {
    super.onFragmentOnDestroy();
    this.pagePlatformFuncDelegate = null;
    this.mCustomActioinBarController = null;
  }
  
  public void onFragmentOnPause()
  {
    super.onFragmentOnPause();
    if (isContainSecureView()) {
      getActivity().getWindow().clearFlags(8192);
    }
    Log.d("MicroMsg.BaseFragment", "lifecycle: onFragmentOnPause, class: %s", new Object[] { toString() });
  }
  
  public void onFragmentOnResume()
  {
    super.onFragmentOnResume();
    if (isContainSecureView()) {
      getActivity().getWindow().addFlags(8192);
    }
    Log.d("MicroMsg.BaseFragment", "lifecycle: onFragmentOnResume, class: %s", new Object[] { toString() });
  }
  
  public void onHiddenChanged(boolean paramBoolean)
  {
    super.onHiddenChanged(paramBoolean);
    if (paramBoolean) {
      getActivity().getWindow().clearFlags(8192);
    }
    for (;;)
    {
      Log.i("MicroMsg.BaseFragment", "onHiddenChanged %s", new Object[] { Boolean.valueOf(paramBoolean) });
      return;
      if (isContainSecureView()) {
        getActivity().getWindow().addFlags(8192);
      }
    }
  }
  
  public abstract void onKeyboardShow(boolean paramBoolean, int paramInt);
  
  public void onPause()
  {
    super.onPause();
    Log.d("MicroMsg.BaseFragment", "onPause %s %s", new Object[] { getTagName(), this });
    if (this.life != null) {
      this.life.onPause();
    }
  }
  
  public void onResume()
  {
    Log.d("MicroMsg.BaseFragment", "onResume %s %s", new Object[] { getTagName(), this });
    super.onResume();
    if (this.life != null) {
      this.life.onResume();
    }
  }
  
  public void onSwipeBack()
  {
    super.onSwipeBack();
    Log.d("MicroMsg.BaseFragment", "onSwipeBack %s %s", new Object[] { getTagName(), this });
    this.fragEvent.popFragment();
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    Log.v("MicroMsg.BaseFragment", "on touch");
    return true;
  }
  
  public void onViewCreated(final View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    this.statusBarSpaceView = ((FrameLayout)paramView.findViewById(R.id.kinda_status_bar_placeholder_view));
    int i = ar.getStatusBarHeight(getContext());
    ViewGroup.LayoutParams localLayoutParams = this.statusBarSpaceView.getLayoutParams();
    if (localLayoutParams != null)
    {
      localLayoutParams.height = i;
      this.statusBarSpaceView.setLayoutParams(localLayoutParams);
    }
    Log.d("MicroMsg.BaseFragment", "onViewCreated %s %s", new Object[] { getTagName(), this });
    this.pagePlatformDelegate = new UIPagePlatformDelegateImpl(getActivity());
    this.pagePlatformFuncDelegate = new UIPagePlatformFuncDelegateImpl(this);
    this.uiModalFuncDelegate = new UIModalFuncDelegateImpl(this);
    if (usePanelModalMode()) {
      paramView.setVisibility(4);
    }
    initOnCreate();
    KindaAnimatorWatch.didViewCreated(hashCode());
    paramView.setOnTouchListener(this);
    paramView.post(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(264063);
        BaseFragment.this.onFirstRenderFinish();
        if (BaseFragment.this.usePanelModalMode()) {
          paramView.setVisibility(0);
        }
        AppMethodBeat.o(264063);
      }
    });
    if (this.life != null) {
      this.life.onViewCreate(paramBundle);
    }
  }
  
  public void popFragment()
  {
    if (this.fragEvent != null) {
      this.fragEvent.popFragment();
    }
  }
  
  public void recordCoveredFragment(BaseFragment paramBaseFragment)
  {
    this.mCoveredFragment = paramBaseFragment;
  }
  
  protected void restoreActionBarColor() {}
  
  protected void setActionBarColor(int paramInt)
  {
    if (getContext() != null)
    {
      getController().mActionBar.setBackgroundDrawable(new ColorDrawable(paramInt));
      calculateStatusBarColor(paramInt);
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
  
  public boolean useKeyboardCoverMode()
  {
    return false;
  }
  
  protected boolean usePanelModalMode()
  {
    return false;
  }
  
  public void watchLife(FrLifeController.IFrLife paramIFrLife)
  {
    this.life = paramIFrLife;
  }
  
  public void willActive()
  {
    Log.d("MicroMsg.BaseFragment", "willActive %s %s", new Object[] { getTagName(), this });
    this.isActive = true;
  }
  
  public void willDeActive()
  {
    this.isActive = false;
    Log.d("MicroMsg.BaseFragment", "willDeActive %s %s", new Object[] { getTagName(), this });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.kinda.framework.widget.base.BaseFragment
 * JD-Core Version:    0.7.0.1
 */