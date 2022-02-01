package com.tencent.kinda.framework.widget.base;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.g;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.ActionBarContainer;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
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
import com.tencent.kinda.framework.widget.tools.ColorUtil;
import com.tencent.kinda.gen.ITransmitKvData;
import com.tencent.kinda.gen.LeftBarButtonType;
import com.tencent.kinda.gen.NavigationBarConfig;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMFragment;
import com.tencent.mm.ui.s;
import com.tencent.mm.ui.u;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public abstract class BaseFragment
  extends LifecycleFragment
  implements View.OnTouchListener, FragmentLifecycle
{
  public static final String TAG = "MicroMsg.BaseFragment";
  private byte _hellAccFlag_;
  protected IEventFragment fragEvent;
  private boolean isActive = false;
  private boolean isEnterBackground = false;
  private FrLifeController.IFrLife life;
  private ActionBarContainer mActionBarContainer = null;
  private BaseFragment mCoveredFragment;
  public u mCustomActioinBarController = null;
  protected UIPagePlatformDelegateImpl pagePlatformDelegate;
  protected UIPagePlatformFuncDelegateImpl pagePlatformFuncDelegate;
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
        this.mActionBarContainer = ((ActionBarContainer)((ViewStub)paramView.findViewById(2131301269)).inflate());
      }
      u localu = this.mCustomActioinBarController;
      paramView = (ViewGroup)paramView;
      localu.JwZ.WA = paramView;
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
    return 2131494538;
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
  
  protected void initPageView()
  {
    YogaLayout localYogaLayout = new YogaLayout(getActivity());
    localYogaLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
    ((ViewGroup)getView().findViewById(2131298736)).addView(localYogaLayout);
    ae.i("MicroMsg.BaseFragment", "initPageView rootLayout %s", new Object[] { localYogaLayout });
    onCreateLayout(new PlatformWrapLayout(localYogaLayout));
  }
  
  public void initWithNavigationBarConfig(NavigationBarConfig paramNavigationBarConfig)
  {
    ae.i("MicroMsg.BaseFragment", "NavigationBarConfig: %s", new Object[] { paramNavigationBarConfig });
    if ((paramNavigationBarConfig != null) && (getController().mActionBar != null))
    {
      if (paramNavigationBarConfig.mBackgroundColor != null)
      {
        getController().mActionBar.setBackgroundDrawable(new ColorDrawable((int)ColorUtil.getColorByMode(paramNavigationBarConfig.mBackgroundColor)));
        setActionBarColor((int)ColorUtil.getColorByModeNoCompat(paramNavigationBarConfig.mBackgroundColor));
      }
      if (paramNavigationBarConfig.mBarTitle != null) {
        setMMTitle(paramNavigationBarConfig.mBarTitle);
      }
      if (bu.isNullOrNil(paramNavigationBarConfig.mLeftButtonColor)) {}
    }
    for (;;)
    {
      try
      {
        localObject = getResources().getDrawable(2131230837).mutate();
        if (!(localObject instanceof StateListDrawable)) {
          continue;
        }
        localObject = getResources().getDrawable(2131689726);
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
            AppMethodBeat.i(18763);
            BaseFragment.this.popFragment();
            AppMethodBeat.o(18763);
            return true;
          }
        }, 2131689492);
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
      setBackBtn(new MenuItem.OnMenuItemClickListener()
      {
        public boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(18762);
          BaseFragment.this.popFragment();
          AppMethodBeat.o(18762);
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
  
  public boolean isSupportCustomActionBar()
  {
    return true;
  }
  
  public void onActivityCreated(Bundle paramBundle)
  {
    super.onActivityCreated(paramBundle);
    ae.d("MicroMsg.BaseFragment", "onActivityCreated %s %s", new Object[] { getTagName(), this });
  }
  
  public void onAttach(Activity paramActivity)
  {
    ae.d("MicroMsg.BaseFragment", "onAttach %s %s", new Object[] { getTagName(), this });
    super.onAttach(paramActivity);
    try
    {
      this.fragEvent = ((IEventFragment)paramActivity);
      return;
    }
    catch (ClassCastException paramActivity)
    {
      ae.e("MicroMsg.BaseFragment", "error IEventFragment");
    }
  }
  
  public void onAttach(Context paramContext)
  {
    super.onAttach(paramContext);
    if (isSupportCustomActionBar())
    {
      this.mCustomActioinBarController = new u();
      paramContext = this.mCustomActioinBarController;
      paramContext.JwY = this;
      paramContext.JwZ = new com.tencent.mm.ui.b.b(thisActivity(), paramContext);
      setActivityController(this.mCustomActioinBarController);
    }
  }
  
  public abstract boolean onBackPressed();
  
  public void onCreate(Bundle paramBundle)
  {
    ae.d("MicroMsg.BaseFragment", "onCreate %s %s", new Object[] { getTagName(), this });
    super.onCreate(paramBundle);
  }
  
  protected abstract void onCreateLayout(PlatformWrapLayout paramPlatformWrapLayout);
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    KindaActionBarColorManager.getInstance().pushActionBarColorItem(this, getController().fAS());
    return super.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
  }
  
  public void onDestroyView()
  {
    super.onDestroyView();
    ae.d("MicroMsg.BaseFragment", "onDestroyView %s %s", new Object[] { getTagName(), this });
    this.pagePlatformDelegate = null;
    this.pagePlatformFuncDelegate = null;
    restoreActionBarColor();
    if (this.life != null) {
      this.life.onDestroyView();
    }
    this.life = null;
  }
  
  public void onDetach()
  {
    ae.d("MicroMsg.BaseFragment", "onDetach %s %s", new Object[] { getTagName(), this });
    super.onDetach();
    this.fragEvent = null;
  }
  
  public void onFragmentOnDestroy()
  {
    super.onFragmentOnDestroy();
    this.pagePlatformFuncDelegate = null;
    this.mCustomActioinBarController = null;
  }
  
  public void onHiddenChanged(boolean paramBoolean)
  {
    super.onHiddenChanged(paramBoolean);
    ae.i("MicroMsg.BaseFragment", "onHiddenChanged %s", new Object[] { Boolean.valueOf(paramBoolean) });
  }
  
  public abstract void onKeyboardShow(boolean paramBoolean, int paramInt);
  
  public void onPause()
  {
    super.onPause();
    ae.d("MicroMsg.BaseFragment", "onPause %s %s", new Object[] { getTagName(), this });
    if (this.life != null) {
      this.life.onPause();
    }
  }
  
  public void onResume()
  {
    ae.d("MicroMsg.BaseFragment", "onResume %s %s", new Object[] { getTagName(), this });
    super.onResume();
    if (this.life != null) {
      this.life.onResume();
    }
  }
  
  public void onSwipeBack()
  {
    super.onSwipeBack();
    ae.d("MicroMsg.BaseFragment", "onSwipeBack %s %s", new Object[] { getTagName(), this });
    this.fragEvent.popFragment();
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.bd(paramView);
    localb.bd(paramMotionEvent);
    a.b("com/tencent/kinda/framework/widget/base/BaseFragment", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", this, localb.ahF());
    ae.v("MicroMsg.BaseFragment", "on touch");
    a.a(true, this, "com/tencent/kinda/framework/widget/base/BaseFragment", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z");
    return true;
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    ae.d("MicroMsg.BaseFragment", "onViewCreated %s %s", new Object[] { getTagName(), this });
    this.pagePlatformDelegate = new UIPagePlatformDelegateImpl(getActivity());
    this.pagePlatformFuncDelegate = new UIPagePlatformFuncDelegateImpl(this);
    initOnCreate();
    KindaAnimatorWatch.didViewCreated(hashCode());
    paramView.setOnTouchListener(this);
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
  
  protected void restoreActionBarColor()
  {
    if (isFinishing()) {}
    FragmentActivity localFragmentActivity;
    do
    {
      return;
      localFragmentActivity = getActivity();
    } while ((localFragmentActivity == null) || (((localFragmentActivity instanceof MMActivity)) && (((MMActivity)localFragmentActivity).activityHasDestroyed())));
    KindaActionBarColorManager.getInstance().onRestoreActionBarColor(this);
  }
  
  protected void setActionBarColor(int paramInt)
  {
    if (getContext() != null)
    {
      getController().setActionbarColor(paramInt);
      KindaActionBarColorManager.getInstance().pushActionBarColorItem(this, paramInt);
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
    ae.d("MicroMsg.BaseFragment", "willActive %s %s", new Object[] { getTagName(), this });
    this.isActive = true;
  }
  
  public void willDeActive()
  {
    this.isActive = false;
    ae.d("MicroMsg.BaseFragment", "willDeActive %s %s", new Object[] { getTagName(), this });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.kinda.framework.widget.base.BaseFragment
 * JD-Core Version:    0.7.0.1
 */