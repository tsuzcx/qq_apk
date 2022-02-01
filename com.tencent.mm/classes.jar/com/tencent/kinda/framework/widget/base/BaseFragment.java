package com.tencent.kinda.framework.widget.base;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
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
import androidx.fragment.app.FragmentManager;
import com.facebook.yoga.android.YogaLayout;
import com.tencent.kinda.framework.R.color;
import com.tencent.kinda.framework.R.id;
import com.tencent.kinda.framework.R.layout;
import com.tencent.kinda.framework.R.raw;
import com.tencent.kinda.framework.animate.KindaAnimatorWatch;
import com.tencent.kinda.framework.app.UIPagePlatformFuncDelegateImpl;
import com.tencent.kinda.framework.widget.PlatformWrapLayout;
import com.tencent.kinda.framework.widget.tools.ColorUtil;
import com.tencent.kinda.gen.DynamicColor;
import com.tencent.kinda.gen.ITransmitKvData;
import com.tencent.kinda.gen.LeftBarButtonType;
import com.tencent.kinda.gen.NavigationBarConfig;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.a.d;
import com.tencent.mm.compatible.util.g;
import com.tencent.mm.plugin.wxpayreport.j;
import com.tencent.mm.plugin.wxpayreport.j.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMFragment;
import com.tencent.mm.ui.aa;
import com.tencent.mm.ui.aw;
import com.tencent.mm.ui.bb;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import com.tencent.mm.ui.y;
import com.tencent.mm.wallet_core.keyboard.WcPayKeyboard;
import java.lang.ref.WeakReference;
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
  public aa mCustomActioinBarController = null;
  private j mReportUIC;
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
      boolean bool = bb.aAF(paramInt);
      getController().updataStatusBarIcon(bool);
      getController().s(getActivity(), 0);
      getController().setNavigationbarColor(getResources().getColor(a.d.BG_0));
      return;
      if (Build.VERSION.SDK_INT >= 21) {
        paramInt = bb.av(getResources().getColor(R.color.statusbar_fg_drak_color), paramInt);
      } else {
        paramInt = 0;
      }
    }
  }
  
  public void addCustomReportEvent(String paramString, com.tencent.mm.plugin.wxpayreport.a.b paramb)
  {
    this.mReportUIC.addCustomReportEvent(paramString, paramb);
  }
  
  public void addLifecycleReportEvent(j.b paramb, com.tencent.mm.plugin.wxpayreport.a.b paramb1)
  {
    this.mReportUIC.addLifecycleReportEvent(paramb, paramb1);
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
      aa localaa = this.mCustomActioinBarController;
      paramView = (ViewGroup)paramView;
      localaa.adFj.bxO = paramView;
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
  
  public abstract String getReportUrl();
  
  public abstract String getTagName();
  
  public boolean getWillBeRemoved()
  {
    return this.willBeRemoved;
  }
  
  protected void hideKeyboard()
  {
    getController().hideVKB();
    Object localObject = findViewById(R.id.tenpay_keyboard_layout);
    if ((localObject != null) && ((getActivity() instanceof BaseFrActivity)))
    {
      WeakReference localWeakReference = new WeakReference(this);
      ((BaseFrActivity)getActivity()).hideTenpayKB((View)localObject, localWeakReference);
    }
    localObject = (WcPayKeyboard)findViewById(R.id.wc_pay_keyboard);
    if (localObject != null) {
      ((WcPayKeyboard)localObject).hideWcKb();
    }
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
    int i = 1;
    Log.i("MicroMsg.BaseFragment", "NavigationBarConfig: %s", new Object[] { paramNavigationBarConfig });
    Object localObject;
    if ((paramNavigationBarConfig != null) && (getController().mActionBar != null))
    {
      if (paramNavigationBarConfig.mBackgroundColor != null)
      {
        j = (int)ColorUtil.getColorByMode(paramNavigationBarConfig.mBackgroundColor);
        getController().mActionBar.setBackgroundDrawable(new ColorDrawable(j));
        calculateStatusBarColor(j);
        getController().setNavigationbarColor(j);
      }
      if (paramNavigationBarConfig.mBarTitle != null) {
        setMMTitle(paramNavigationBarConfig.mBarTitle);
      }
      if ((paramNavigationBarConfig.mTitleColor != null) && (paramNavigationBarConfig.mTitleColor.mNormalColor != 0L)) {
        getController().setMMTitleColor((int)paramNavigationBarConfig.mTitleColor.mNormalColor);
      }
      if (Util.isNullOrNil(paramNavigationBarConfig.mLeftButtonColor)) {
        break label352;
      }
      if (Color.parseColor(paramNavigationBarConfig.mLeftButtonColor) != -1) {
        break label274;
      }
      localObject = getController();
      if (((y)localObject).adEb != null) {
        ((y)localObject).adEb.clearColorFilter();
      }
      localObject = getController();
      j = i;
      if (((y)localObject).adEb != null) {
        ((y)localObject).adEb.setEnableColorFilter(false);
      }
    }
    label274:
    label352:
    for (int j = i;; j = 0)
    {
      localObject = getController().mActionBar;
      if (localObject != null) {
        ((ActionBar)localObject).g(0.0F);
      }
      if (paramNavigationBarConfig.mLeftBarButtonType == LeftBarButtonType.BACK)
      {
        localObject = new MenuItem.OnMenuItemClickListener()
        {
          public boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
          {
            AppMethodBeat.i(18763);
            BaseFragment.this.popFragment();
            AppMethodBeat.o(18763);
            return true;
          }
        };
        if (j != 0)
        {
          i = R.raw.actionbar_icon_light_back;
          label246:
          setBackBtn((MenuItem.OnMenuItemClickListener)localObject, i);
        }
      }
      for (;;)
      {
        setTopRightBtnImage(paramNavigationBarConfig.mRightButtonImage);
        setTopRightBtnTitle(paramNavigationBarConfig.mRightButtonTitle, paramNavigationBarConfig.mRightButtonColor);
        return;
        i = 0;
        break;
        i = R.raw.actionbar_icon_dark_back;
        break label246;
        if (paramNavigationBarConfig.mLeftBarButtonType == LeftBarButtonType.CANCEL)
        {
          localObject = new MenuItem.OnMenuItemClickListener()
          {
            public boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
            {
              AppMethodBeat.i(226625);
              BaseFragment.this.popFragment();
              AppMethodBeat.o(226625);
              return true;
            }
          };
          if (j != 0) {}
          for (i = R.raw.actionbar_icon_light_close;; i = R.raw.actionbar_icon_dark_close)
          {
            setBackBtn((MenuItem.OnMenuItemClickListener)localObject, i);
            break;
          }
        }
        if (paramNavigationBarConfig.mLeftBarButtonType == LeftBarButtonType.NONE) {
          getController().setBackBtnVisible(false);
        }
      }
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
      this.mCustomActioinBarController = new aa();
      paramContext = this.mCustomActioinBarController;
      paramContext.adFi = this;
      paramContext.adFj = new com.tencent.mm.ui.b.b(thisActivity(), paramContext);
      setActivityController(this.mCustomActioinBarController);
    }
    this.mReportUIC = new j(this);
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
  
  protected void onFirstLayoutFinished() {}
  
  protected void onFirstRenderFinish() {}
  
  public void onFragmentOnDestroy()
  {
    super.onFragmentOnDestroy();
    this.pagePlatformFuncDelegate = null;
    this.mCustomActioinBarController = null;
    this.mReportUIC.onDestroy();
  }
  
  public void onFragmentOnPause()
  {
    super.onFragmentOnPause();
    if (isContainSecureView()) {
      getActivity().getWindow().clearFlags(8192);
    }
    this.mReportUIC.onPause();
    Log.d("MicroMsg.BaseFragment", "lifecycle: onFragmentOnPause, class: %s", new Object[] { toString() });
  }
  
  public void onFragmentOnResume()
  {
    super.onFragmentOnResume();
    if (isContainSecureView()) {
      getActivity().getWindow().addFlags(8192);
    }
    this.mReportUIC.onResume();
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
    int i = aw.getStatusBarHeight(getContext());
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
    paramView.setClickable(true);
    paramView.setImportantForAccessibility(2);
    paramView.post(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(226624);
        BaseFragment.this.onFirstRenderFinish();
        BaseFragment.this.onFirstLayoutFinished();
        if (BaseFragment.this.usePanelModalMode()) {
          paramView.setVisibility(0);
        }
        AppMethodBeat.o(226624);
      }
    });
    if (this.life != null) {
      this.life.onViewCreate(paramBundle);
    }
    this.mReportUIC.onCreate(null);
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
  
  public void triggerReport(j.b paramb, String paramString)
  {
    this.mReportUIC.triggerReport(paramb, paramString);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.kinda.framework.widget.base.BaseFragment
 * JD-Core Version:    0.7.0.1
 */