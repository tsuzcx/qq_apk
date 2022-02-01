package com.tencent.kinda.framework.widget.base;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager.e;
import androidx.fragment.app.r;
import com.tencent.kinda.framework.R.anim;
import com.tencent.kinda.framework.R.id;
import com.tencent.kinda.framework.app.MainFragment;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.appbrand.api.g;
import com.tencent.mm.plugin.appbrand.service.t;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.widget.SwipeBackLayout;
import com.tencent.mm.wallet_core.ui.i;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class FrLifeController
{
  public static final String TAG = "MicroMsg.FragmentController";
  private BaseFrActivity activity;
  private int fragmentCount;
  private Stack<BaseFragment> mFragmentBackStack;
  private boolean needTinyCallback;
  private MainFragment tinyAppFragment;
  private int tinyappCount;
  private MainFragment webViewFragment;
  private int webviewCount;
  
  public FrLifeController(BaseFrActivity paramBaseFrActivity)
  {
    AppMethodBeat.i(18782);
    this.fragmentCount = 0;
    this.webviewCount = 0;
    this.tinyappCount = 0;
    this.needTinyCallback = true;
    this.webViewFragment = null;
    this.tinyAppFragment = null;
    this.activity = paramBaseFrActivity;
    androidx.fragment.app.FragmentManager.enableDebugLogging(true);
    this.activity.getSupportFragmentManager().addOnBackStackChangedListener(new FragmentManager.e()
    {
      public void onBackStackChanged()
      {
        AppMethodBeat.i(178767);
        androidx.fragment.app.FragmentManager localFragmentManager = FrLifeController.this.activity.getSupportFragmentManager();
        Log.i("MicroMsg.FragmentController", "onBackstackChanged: %s, fragments: %s", new Object[] { Integer.valueOf(localFragmentManager.getBackStackEntryCount()), localFragmentManager.getFragments() });
        AppMethodBeat.o(178767);
      }
    });
    this.mFragmentBackStack = new Stack();
    AppMethodBeat.o(18782);
  }
  
  private void checkSwipeBackLayout()
  {
    AppMethodBeat.i(18784);
    if (!this.activity.isSupportNavigationSwipeBack())
    {
      AppMethodBeat.o(18784);
      return;
    }
    int i = this.mFragmentBackStack.size();
    Log.i("MicroMsg.FragmentController", "checkSwipeBackLayout %s %s", new Object[] { Integer.valueOf(i), Integer.valueOf(this.activity.getFragmentManager().getBackStackEntryCount()) });
    if (i > 1)
    {
      this.activity.getSwipeBackLayout().setEnableGesture(false);
      AppMethodBeat.o(18784);
      return;
    }
    this.activity.getSwipeBackLayout().setEnableGesture(true);
    AppMethodBeat.o(18784);
  }
  
  private BaseFragment getFragMent(int paramInt)
  {
    AppMethodBeat.i(18789);
    if ((this.mFragmentBackStack == null) || (this.mFragmentBackStack.size() == 0))
    {
      AppMethodBeat.o(18789);
      return null;
    }
    BaseFragment localBaseFragment;
    if (paramInt < 0)
    {
      int i = this.mFragmentBackStack.size() + paramInt;
      if ((i >= 0) && (i < this.mFragmentBackStack.size()))
      {
        localBaseFragment = (BaseFragment)this.mFragmentBackStack.get(this.mFragmentBackStack.size() + paramInt);
        AppMethodBeat.o(18789);
        return localBaseFragment;
      }
      AppMethodBeat.o(18789);
      return null;
    }
    if (paramInt < this.mFragmentBackStack.size())
    {
      localBaseFragment = (BaseFragment)this.mFragmentBackStack.get(paramInt);
      AppMethodBeat.o(18789);
      return localBaseFragment;
    }
    AppMethodBeat.o(18789);
    return null;
  }
  
  private void setAccessibilityState(boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(226473);
    BaseFragment localBaseFragment = getFragMent(paramInt);
    if (localBaseFragment == null)
    {
      Log.i("MicroMsg.FragmentController", "fragment is null");
      AppMethodBeat.o(226473);
      return;
    }
    if (localBaseFragment.getView() == null)
    {
      Log.i("MicroMsg.FragmentController", "fragment " + localBaseFragment + " getView() is null");
      AppMethodBeat.o(226473);
      return;
    }
    ViewGroup localViewGroup = (ViewGroup)localBaseFragment.getView().findViewById(R.id.kinda_main_container);
    if (localViewGroup == null)
    {
      Log.e("MicroMsg.FragmentController", "fragment " + localBaseFragment + " container is null");
      AppMethodBeat.o(226473);
      return;
    }
    if (paramBoolean) {
      localViewGroup.setImportantForAccessibility(1);
    }
    for (;;)
    {
      Log.d("MicroMsg.FragmentController", "accessibility fragment " + localBaseFragment + " set %s", new Object[] { Boolean.valueOf(paramBoolean) });
      AppMethodBeat.o(226473);
      return;
      localViewGroup.setImportantForAccessibility(4);
    }
  }
  
  private void watchLife(final BaseFragment paramBaseFragment)
  {
    AppMethodBeat.i(18783);
    if (paramBaseFragment == null)
    {
      Log.e("MicroMsg.FragmentController", Util.stackTraceToString(new Throwable("Watch a null fragment!!")));
      AppMethodBeat.o(18783);
      return;
    }
    paramBaseFragment.watchLife(new FrLifeController.IFrLife()
    {
      public void onDestroyView()
      {
        AppMethodBeat.i(178769);
        Log.i("MicroMsg.FragmentController", "onDestroyView " + paramBaseFragment);
        if (FrLifeController.this.mFragmentBackStack.search(paramBaseFragment) > 0)
        {
          if (FrLifeController.access$100(FrLifeController.this, -1) != paramBaseFragment) {
            break label122;
          }
          FrLifeController.access$300(FrLifeController.this, true, -2);
        }
        for (;;)
        {
          BaseFragment localBaseFragment = paramBaseFragment.getCoveredFragment();
          if ((localBaseFragment != null) && (localBaseFragment.equals(FrLifeController.access$100(FrLifeController.this, -1))))
          {
            Log.i("MicroMsg.FragmentController", "From onDestroyView, active covered fragment: ".concat(String.valueOf(localBaseFragment)));
            localBaseFragment.willActive();
          }
          AppMethodBeat.o(178769);
          return;
          label122:
          FrLifeController.access$300(FrLifeController.this, true, -1);
        }
      }
      
      public void onPause() {}
      
      public void onResume() {}
      
      public void onViewCreate(Bundle paramAnonymousBundle)
      {
        AppMethodBeat.i(178768);
        Log.i("MicroMsg.FragmentController", "onViewCreate " + paramBaseFragment);
        if (!paramBaseFragment.isActive())
        {
          Log.i("MicroMsg.FragmentController", "From onResume, Active create view fragment: " + paramBaseFragment);
          paramBaseFragment.willActive();
        }
        paramAnonymousBundle = FrLifeController.access$100(FrLifeController.this, -2);
        if ((paramAnonymousBundle != null) && ((paramBaseFragment instanceof MainFragment)) && (paramAnonymousBundle.isActive()))
        {
          Log.i("MicroMsg.FragmentController", "From onCreateView, DeActive covered fragment: " + paramBaseFragment);
          paramAnonymousBundle.willDeActive();
          paramBaseFragment.recordCoveredFragment(paramAnonymousBundle);
        }
        AppMethodBeat.o(178768);
      }
    });
    AppMethodBeat.o(18783);
  }
  
  public boolean addFragment(BaseFragment paramBaseFragment)
  {
    AppMethodBeat.i(18785);
    this.fragmentCount += 1;
    r localr2 = this.activity.getSupportFragmentManager().beginTransaction();
    r localr1 = localr2;
    if ((paramBaseFragment instanceof MainFragment))
    {
      if (paramBaseFragment.enterAnimStyle != 1) {
        break label141;
      }
      localr1 = localr2.aJ(R.anim.slide_right_in, R.anim.slide_left_out);
    }
    for (;;)
    {
      localr1.a(R.id.fragment_content, paramBaseFragment);
      watchLife(paramBaseFragment);
      this.mFragmentBackStack.add(paramBaseFragment);
      localr1.FX();
      Log.i("MicroMsg.FragmentController", "fragment [" + paramBaseFragment + "] has add! current fragmentCount: " + this.fragmentCount);
      if (this.fragmentCount > 1) {
        setAccessibilityState(false, -2);
      }
      AppMethodBeat.o(18785);
      return true;
      label141:
      localr1 = localr2;
      if (paramBaseFragment.enterAnimStyle == 2) {
        localr1 = localr2.aJ(R.anim.sight_slide_bottom_in, 0);
      }
    }
  }
  
  public BaseFragment getCurrent()
  {
    AppMethodBeat.i(18788);
    BaseFragment localBaseFragment = BaseFrActivity.topShowFragmentOf(getFragmentList());
    AppMethodBeat.o(18788);
    return localBaseFragment;
  }
  
  public List<Fragment> getFragmentList()
  {
    AppMethodBeat.i(226482);
    if (this.mFragmentBackStack == null)
    {
      localArrayList = new ArrayList();
      AppMethodBeat.o(226482);
      return localArrayList;
    }
    ArrayList localArrayList = new ArrayList(this.mFragmentBackStack);
    AppMethodBeat.o(226482);
    return localArrayList;
  }
  
  public int getFragmentListSize()
  {
    AppMethodBeat.i(18790);
    Log.i("MicroMsg.FragmentController", "getFragmentListSize: %d", new Object[] { Integer.valueOf(this.fragmentCount) });
    int i = this.fragmentCount;
    AppMethodBeat.o(18790);
    return i;
  }
  
  public boolean hasOpenH5OrTinyApp()
  {
    AppMethodBeat.i(18794);
    Log.i("MicroMsg.FragmentController", "hasOpenH5OrTinyApp, webviewCount: %d, tinyappCount: %d", new Object[] { Integer.valueOf(this.webviewCount), Integer.valueOf(this.tinyappCount) });
    if ((this.webviewCount > 0) || (this.tinyappCount > 0))
    {
      AppMethodBeat.o(18794);
      return true;
    }
    AppMethodBeat.o(18794);
    return false;
  }
  
  public void onActivityDestroy()
  {
    AppMethodBeat.i(226485);
    this.mFragmentBackStack.clear();
    AppMethodBeat.o(226485);
  }
  
  public boolean popFragment()
  {
    AppMethodBeat.i(18786);
    Log.i("MicroMsg.FragmentController", "popFragment, fragmentCount: %d, isStateSaved: %b", new Object[] { Integer.valueOf(this.fragmentCount), Boolean.valueOf(this.activity.getSupportFragmentManager().isStateSaved()) });
    if ((this.fragmentCount > 1) && (!this.activity.getSupportFragmentManager().isStateSaved()))
    {
      removeModal(BaseFrActivity.topShowFragmentOf(getFragmentList()));
      Log.i("MicroMsg.FragmentController", "popFragment to remove, fragmentCount: %d", new Object[] { Integer.valueOf(this.fragmentCount) });
      if (this.fragmentCount > 0)
      {
        AppMethodBeat.o(18786);
        return true;
      }
      AppMethodBeat.o(18786);
      return false;
    }
    Log.i("MicroMsg.FragmentController", "NO popFragment before return, fragmentCount: %d", new Object[] { Integer.valueOf(this.fragmentCount) });
    AppMethodBeat.o(18786);
    return false;
  }
  
  public boolean processCallback(int paramInt)
  {
    AppMethodBeat.i(18793);
    if ((paramInt == 2) && (this.webviewCount > 0) && (this.webViewFragment != null))
    {
      this.webViewFragment.onDestroy();
      this.webViewFragment = null;
      this.webviewCount -= 1;
      AppMethodBeat.o(18793);
      return true;
    }
    if ((paramInt == 3) && (this.tinyappCount > 0) && (this.tinyAppFragment != null) && (this.needTinyCallback))
    {
      this.tinyAppFragment.onDestroy();
      this.tinyAppFragment = null;
      this.tinyappCount -= 1;
      AppMethodBeat.o(18793);
      return true;
    }
    AppMethodBeat.o(18793);
    return false;
  }
  
  public boolean removeModal(BaseFragment paramBaseFragment)
  {
    AppMethodBeat.i(18787);
    r localr2;
    r localr1;
    if (this.fragmentCount > 0)
    {
      if (paramBaseFragment.isActive()) {
        paramBaseFragment.willDeActive();
      }
      this.fragmentCount -= 1;
      paramBaseFragment.setWillBeRemoved(true);
      localr2 = this.activity.getSupportFragmentManager().beginTransaction();
      localr1 = localr2;
      if ((paramBaseFragment instanceof MainFragment))
      {
        if (paramBaseFragment.enterAnimStyle != 1) {
          break label145;
        }
        localr1 = localr2.aJ(R.anim.slide_right_in, R.anim.slide_right_out);
      }
    }
    for (;;)
    {
      localr1.a(paramBaseFragment);
      localr1.FX();
      this.mFragmentBackStack.remove(paramBaseFragment);
      setAccessibilityState(true, -1);
      Log.i("MicroMsg.FragmentController", "removeModal [%s] before return, fragmentCount: %d", new Object[] { paramBaseFragment, Integer.valueOf(this.fragmentCount) });
      if (this.fragmentCount <= 0) {
        break;
      }
      AppMethodBeat.o(18787);
      return true;
      label145:
      localr1 = localr2;
      if (paramBaseFragment.enterAnimStyle == 2) {
        localr1 = localr2.aJ(0, R.anim.sight_slide_bottom_out);
      }
    }
    AppMethodBeat.o(18787);
    return false;
  }
  
  public void setTinyCallbackTag(boolean paramBoolean)
  {
    this.needTinyCallback = paramBoolean;
  }
  
  public void startTinyAppUIPage(Bundle paramBundle, MainFragment paramMainFragment)
  {
    AppMethodBeat.i(18792);
    String str1 = paramBundle.getString("intent_tinyapp_username", "");
    String str2 = paramBundle.getString("intent_tinyapp_path", "");
    String str3 = paramBundle.getString("intent_tinyapp_version", "");
    int i = paramBundle.getInt("intent_tinyapp_type", 0);
    int j = paramBundle.getInt("intent_tinyapp_scene", 0);
    paramMainFragment.isTinyApp = true;
    paramMainFragment.tinyAppUserName = str1;
    paramMainFragment.initPagePlatformDelegate();
    paramBundle = new g();
    paramBundle.username = str1;
    paramBundle.qAF = Util.nullAs(str2, "");
    if (j == 0)
    {
      paramBundle.scene = 1034;
      if (i != 0) {
        break label214;
      }
    }
    label214:
    for (paramBundle.euz = 0;; paramBundle.euz = 2)
    {
      i = Util.getInt(str3, 0);
      if (i > 0) {
        paramBundle.version = i;
      }
      paramBundle.qAL = 3;
      ((t)h.ax(t.class)).a(this.activity, paramBundle);
      this.tinyAppFragment = paramMainFragment;
      this.tinyappCount += 1;
      if (this.fragmentCount != 0) {
        break label222;
      }
      Log.i("MicroMsg.FragmentController", "only tinyApp,dont need TinyCallback");
      this.needTinyCallback = false;
      AppMethodBeat.o(18792);
      return;
      paramBundle.scene = j;
      break;
    }
    label222:
    this.needTinyCallback = true;
    AppMethodBeat.o(18792);
  }
  
  public void startWebViewUIPage(Bundle paramBundle, MainFragment paramMainFragment)
  {
    AppMethodBeat.i(18791);
    paramBundle = paramBundle.getString("intent_webview_url", "");
    i.a(this.activity, paramBundle, true, 2);
    this.webViewFragment = paramMainFragment;
    this.webviewCount += 1;
    AppMethodBeat.o(18791);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.kinda.framework.widget.base.FrLifeController
 * JD-Core Version:    0.7.0.1
 */