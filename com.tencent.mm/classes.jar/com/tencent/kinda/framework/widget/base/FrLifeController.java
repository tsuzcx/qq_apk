package com.tencent.kinda.framework.widget.base;

import android.app.FragmentManager;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.g.c;
import android.support.v4.app.k;
import com.tencent.kinda.framework.app.MainFragment;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.api.f;
import com.tencent.mm.plugin.appbrand.service.o;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.widget.SwipeBackLayout;
import com.tencent.mm.wallet_core.ui.e;
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
    android.support.v4.app.g.enableDebugLogging(true);
    this.activity.getSupportFragmentManager().addOnBackStackChangedListener(new g.c()
    {
      public void onBackStackChanged()
      {
        AppMethodBeat.i(178767);
        android.support.v4.app.g localg = FrLifeController.this.activity.getSupportFragmentManager();
        ad.i("MicroMsg.FragmentController", "onBackstackChanged: %s, fragments: %s", new Object[] { Integer.valueOf(localg.getBackStackEntryCount()), localg.getFragments() });
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
    ad.i("MicroMsg.FragmentController", "checkSwipeBackLayout %s %s", new Object[] { Integer.valueOf(i), Integer.valueOf(this.activity.getFragmentManager().getBackStackEntryCount()) });
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
  
  private void watchLife(final BaseFragment paramBaseFragment)
  {
    AppMethodBeat.i(18783);
    if (paramBaseFragment == null)
    {
      ad.e("MicroMsg.FragmentController", bt.n(new Throwable("Watch a null fragment!!")));
      AppMethodBeat.o(18783);
      return;
    }
    paramBaseFragment.watchLife(new IFrLife()
    {
      public void onDestroyView()
      {
        AppMethodBeat.i(178769);
        BaseFragment localBaseFragment = paramBaseFragment.getCoveredFragment();
        if ((localBaseFragment != null) && (localBaseFragment.equals(FrLifeController.access$100(FrLifeController.this, -1))))
        {
          ad.i("MicroMsg.FragmentController", "From onDestroyView, active covered fragment: ".concat(String.valueOf(localBaseFragment)));
          localBaseFragment.willActive();
        }
        AppMethodBeat.o(178769);
      }
      
      public void onPause() {}
      
      public void onResume() {}
      
      public void onViewCreate(Bundle paramAnonymousBundle)
      {
        AppMethodBeat.i(178768);
        if (!paramBaseFragment.isActive())
        {
          ad.i("MicroMsg.FragmentController", "From onResume, Active create view fragment: " + paramBaseFragment);
          paramBaseFragment.willActive();
        }
        paramAnonymousBundle = FrLifeController.access$100(FrLifeController.this, -2);
        if ((paramAnonymousBundle != null) && ((paramBaseFragment instanceof MainFragment)) && (paramAnonymousBundle.isActive()))
        {
          ad.i("MicroMsg.FragmentController", "From onCreateView, DeActive covered fragment: " + paramBaseFragment);
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
    k localk2 = this.activity.getSupportFragmentManager().beginTransaction();
    k localk1 = localk2;
    if ((paramBaseFragment instanceof MainFragment)) {
      localk1 = localk2.u(2130772144, 2130772141);
    }
    localk1.a(2131300236, paramBaseFragment);
    watchLife(paramBaseFragment);
    this.mFragmentBackStack.add(paramBaseFragment);
    localk1.commitAllowingStateLoss();
    ad.i("MicroMsg.FragmentController", "fragment [" + paramBaseFragment + "] has add! current fragmentCount: " + this.fragmentCount);
    AppMethodBeat.o(18785);
    return true;
  }
  
  public BaseFragment getCurrent()
  {
    AppMethodBeat.i(18788);
    Object localObject = this.activity.getSupportFragmentManager().getFragments();
    if (((List)localObject).size() > 0)
    {
      localObject = (Fragment)((List)localObject).get(((List)localObject).size() - 1);
      if ((localObject instanceof BaseFragment))
      {
        localObject = (BaseFragment)localObject;
        AppMethodBeat.o(18788);
        return localObject;
      }
      AppMethodBeat.o(18788);
      return null;
    }
    AppMethodBeat.o(18788);
    return null;
  }
  
  public int getFragmentListSize()
  {
    AppMethodBeat.i(18790);
    ad.i("MicroMsg.FragmentController", "getFragmentListSize: %d", new Object[] { Integer.valueOf(this.fragmentCount) });
    int i = this.fragmentCount;
    AppMethodBeat.o(18790);
    return i;
  }
  
  public boolean hasOpenH5OrTinyApp()
  {
    AppMethodBeat.i(18794);
    ad.i("MicroMsg.FragmentController", "hasOpenH5OrTinyApp, webviewCount: %d, tinyappCount: %d", new Object[] { Integer.valueOf(this.webviewCount), Integer.valueOf(this.tinyappCount) });
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
    AppMethodBeat.i(199454);
    this.mFragmentBackStack.clear();
    AppMethodBeat.o(199454);
  }
  
  public boolean popFragment()
  {
    AppMethodBeat.i(18786);
    ad.i("MicroMsg.FragmentController", "popFragment, fragmentCount: %d, isStateSaved: %b", new Object[] { Integer.valueOf(this.fragmentCount), Boolean.valueOf(this.activity.getSupportFragmentManager().isStateSaved()) });
    if ((this.fragmentCount > 1) && (!this.activity.getSupportFragmentManager().isStateSaved()))
    {
      removeModal((BaseFragment)this.mFragmentBackStack.peek());
      ad.i("MicroMsg.FragmentController", "popFragment to remove, fragmentCount: %d", new Object[] { Integer.valueOf(this.fragmentCount) });
      if (this.fragmentCount > 0)
      {
        AppMethodBeat.o(18786);
        return true;
      }
      AppMethodBeat.o(18786);
      return false;
    }
    ad.i("MicroMsg.FragmentController", "NO popFragment before return, fragmentCount: %d", new Object[] { Integer.valueOf(this.fragmentCount) });
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
    if (this.fragmentCount > 0)
    {
      if (paramBaseFragment.isActive()) {
        paramBaseFragment.willDeActive();
      }
      this.fragmentCount -= 1;
      paramBaseFragment.setWillBeRemoved(true);
      k localk = this.activity.getSupportFragmentManager().beginTransaction();
      localk.a(paramBaseFragment);
      localk.commitAllowingStateLoss();
      this.mFragmentBackStack.remove(paramBaseFragment);
    }
    ad.i("MicroMsg.FragmentController", "removeModal [%s] before return, fragmentCount: %d", new Object[] { paramBaseFragment, Integer.valueOf(this.fragmentCount) });
    if (this.fragmentCount > 0)
    {
      AppMethodBeat.o(18787);
      return true;
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
    paramBundle = new f();
    paramBundle.username = str1;
    paramBundle.jCN = bt.bI(str2, "");
    paramBundle.scene = 1034;
    if (i == 0) {}
    for (paramBundle.hQh = 0;; paramBundle.hQh = 2)
    {
      i = bt.getInt(str3, 0);
      if (i > 0) {
        paramBundle.version = i;
      }
      paramBundle.jCT = 3;
      ((o)com.tencent.mm.kernel.g.ab(o.class)).a(this.activity, paramBundle);
      this.tinyAppFragment = paramMainFragment;
      this.tinyappCount += 1;
      if (this.fragmentCount != 0) {
        break;
      }
      ad.i("MicroMsg.FragmentController", "only tinyApp,dont need TinyCallback");
      this.needTinyCallback = false;
      AppMethodBeat.o(18792);
      return;
    }
    this.needTinyCallback = true;
    AppMethodBeat.o(18792);
  }
  
  public void startWebViewUIPage(Bundle paramBundle, MainFragment paramMainFragment)
  {
    AppMethodBeat.i(18791);
    paramBundle = paramBundle.getString("intent_webview_url", "");
    e.a(this.activity, paramBundle, false, 2);
    this.webViewFragment = paramMainFragment;
    this.webviewCount += 1;
    AppMethodBeat.o(18791);
  }
  
  public static abstract interface IFrLife
  {
    public abstract void onDestroyView();
    
    public abstract void onPause();
    
    public abstract void onResume();
    
    public abstract void onViewCreate(Bundle paramBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.kinda.framework.widget.base.FrLifeController
 * JD-Core Version:    0.7.0.1
 */