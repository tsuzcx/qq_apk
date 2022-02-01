package com.tencent.mm.plugin.appbrand.ui;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.LifecycleObserver;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Looper;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ab;
import com.tencent.mm.plugin.appbrand.appusage.t;
import com.tencent.mm.plugin.appbrand.appusage.t.d;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.service.p;
import com.tencent.mm.plugin.appbrand.ui.recents.RecentsFolderActivityContext;
import com.tencent.mm.plugin.appbrand.ui.recommend.c;
import com.tencent.mm.plugin.appbrand.ui.recommend.k;
import com.tencent.mm.plugin.websearch.api.ad;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.ay;
import com.tencent.mm.sdk.platformtools.bv;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.am.a;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMFragmentActivity.a;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.h.b;
import java.util.Locale;

@com.tencent.mm.kernel.i
public final class AppBrandLauncherUI
  extends MMActivity
  implements com.tencent.mm.plugin.appbrand.ui.launcher.a
{
  public static int mGL;
  public static final int mGM;
  private int enterScene;
  private int mGN = -1;
  private boolean mGO;
  private RecentsFolderActivityContext mGP;
  private boolean mGQ = false;
  public t.d mGR;
  
  static
  {
    AppMethodBeat.i(48653);
    mGL = ak.getContext().getResources().getColor(2131100705);
    mGM = ab.jDE;
    AppMethodBeat.o(48653);
  }
  
  private Fragment bAb()
  {
    AppMethodBeat.i(48638);
    Object localObject = super.getSupportFragmentManager().findFragmentById(16908290);
    if ((localObject == null) || (!(localObject instanceof Fragment)))
    {
      AppMethodBeat.o(48638);
      return null;
    }
    localObject = (Fragment)localObject;
    AppMethodBeat.o(48638);
    return localObject;
  }
  
  private void bAc()
  {
    AppMethodBeat.i(180388);
    AppBrandStatObject localAppBrandStatObject = new AppBrandStatObject();
    localAppBrandStatObject.scene = 1112;
    finish();
    overridePendingTransition(0, 0);
    com.tencent.mm.plugin.appbrand.api.f localf = new com.tencent.mm.plugin.appbrand.api.f();
    String str;
    if (com.tencent.mm.protocal.d.FFH >= 654314752)
    {
      localf.jFM = new k();
      ae.i("MicroMsg.AppBrandLauncherUI", "openFakeNativeRecommendUI, wechatNativeExtraData=%s", new Object[] { localf.jFM.aYO() });
      localObject = g.mHb;
      str = g.bAf();
      if (!"wxb6d22f922f37b35a".equals(str)) {
        break label199;
      }
    }
    label199:
    for (Object localObject = "gh_b489f391e008@app";; localObject = "gh_9bd4ec2ab601@app")
    {
      localf.username = ((String)localObject);
      localf.appId = str;
      localf.hSZ = 0;
      localf.version = 0;
      localf.scene = localAppBrandStatObject.scene;
      ((p)com.tencent.mm.kernel.g.ab(p.class)).a(ak.getContext(), localf);
      this.mGQ = true;
      AppMethodBeat.o(180388);
      return;
      localObject = String.format("?showOrderEntrance=%d", new Object[] { Integer.valueOf(1) });
      localf.jFL = ((String)localObject);
      ae.i("MicroMsg.AppBrandLauncherUI", "openFakeNativeRecommendUI, enterPath:%s", new Object[] { localObject });
      break;
    }
  }
  
  public final boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(48642);
    if (isFinishing())
    {
      AppMethodBeat.o(48642);
      return false;
    }
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    AppMethodBeat.o(48642);
    return bool;
  }
  
  public final int getLayoutId()
  {
    return -1;
  }
  
  public final void hF(boolean paramBoolean)
  {
    AppMethodBeat.i(48637);
    if (this.mGP != null) {
      this.mGP.hF(paramBoolean);
    }
    if ((paramBoolean) && (this.mGR != null)) {
      this.mGR.jSC[4] = "1";
    }
    AppMethodBeat.o(48637);
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(48646);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    this.mGN = paramInt1;
    if ((paramInt2 == -1) && (paramInt1 == 1))
    {
      String str = paramIntent.getStringExtra("key_session_id");
      paramInt1 = paramIntent.getIntExtra("ftsbizscene", 0);
      ae.i("MicroMsg.AppBrandLauncherUI", "onActivityResult oreh report weAppSearchClickStream(13929) statSessionId:%s, StatKeyWordId:%s", new Object[] { str, com.tencent.mm.modelappbrand.b.hNh });
      com.tencent.mm.plugin.report.service.g.yxI.f(13929, new Object[] { str, com.tencent.mm.modelappbrand.b.hNh, Integer.valueOf(2), Integer.valueOf(paramInt1) });
    }
    AppMethodBeat.o(48646);
  }
  
  public final void onBackPressed()
  {
    AppMethodBeat.i(48649);
    finish();
    AppMethodBeat.o(48649);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(48641);
    super.onCreate(paramBundle);
    if (getIntent() == null)
    {
      finish();
      AppMethodBeat.o(48641);
      return;
    }
    if (!com.tencent.mm.plugin.appbrand.appusage.i.bcv())
    {
      finish();
      AppMethodBeat.o(48641);
      return;
    }
    paramBundle = getLifecycle();
    Object localObject = com.tencent.mm.plugin.appbrand.report.e.mvX;
    paramBundle.addObserver(com.tencent.mm.plugin.appbrand.report.e.b(this));
    this.enterScene = getIntent().getIntExtra("extra_enter_scene", -1);
    overridePendingTransition(MMFragmentActivity.a.mTi, MMFragmentActivity.a.mTj);
    boolean bool1 = getIntent().getBooleanExtra("extra_show_recents_from_task_bar", false);
    ae.i("MicroMsg.AppBrandLauncherUI", "onCreate showRecentsListTagOnTop:%b", new Object[] { Boolean.valueOf(bool1) });
    paramBundle = g.mHb;
    if ((g.LD().getBoolean("KEY_FORCE_WE_USE_FAKE_NATIVE", false)) && (!bool1))
    {
      ae.i("MicroMsg.AppBrandLauncherUI", "onCreate isForceOpenWeUseFakeNative=TRUE");
      bAc();
      AppMethodBeat.o(48641);
      return;
    }
    paramBundle = g.mHb;
    boolean bool2 = g.LD().getBoolean("KEY_FORCE_NATIVE_LAUNCHER", false);
    this.mGO = getIntent().getBooleanExtra("extra_show_recommend", false);
    boolean bool3 = c.bBR();
    setTitleBarDoubleClickListener(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(48623);
        if ((AppBrandLauncherUI.this.activityHasDestroyed()) || (AppBrandLauncherUI.this.isFinishing()))
        {
          AppMethodBeat.o(48623);
          return;
        }
        AppBrandLauncherUI.Fragment localFragment = AppBrandLauncherUI.a(AppBrandLauncherUI.this);
        if (localFragment == null)
        {
          AppMethodBeat.o(48623);
          return;
        }
        localFragment.bAd();
        AppMethodBeat.o(48623);
      }
    });
    setMMTitle(getResources().getString(2131755401));
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(48624);
        AppBrandLauncherUI.this.onBackPressed();
        AppMethodBeat.o(48624);
        return true;
      }
    }, 2131689490);
    if (com.tencent.mm.plugin.appbrand.u.a.byV()) {
      addIconOptionMenu(AppBrandLauncherUI.a.mGX.ordinal(), 2131764452, 2131689494, new AppBrandLauncherUI.3(this), new View.OnLongClickListener()
      {
        public final boolean onLongClick(final View paramAnonymousView)
        {
          AppMethodBeat.i(48628);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/appbrand/ui/AppBrandLauncherUI$4", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, localb.ahF());
          if (bv.fpT())
          {
            paramAnonymousView = AppBrandLauncherUI.this;
            h.a(paramAnonymousView, paramAnonymousView.getResources().getString(2131755951), "", "", 2147483647, new h.b()
            {
              public final boolean onFinish(CharSequence paramAnonymous2CharSequence)
              {
                AppMethodBeat.i(48627);
                if (!TextUtils.isEmpty(paramAnonymous2CharSequence))
                {
                  paramAnonymous2CharSequence = paramAnonymous2CharSequence.toString();
                  AppBrandStatObject localAppBrandStatObject = new AppBrandStatObject();
                  localAppBrandStatObject.scene = 1001;
                  com.tencent.mm.plugin.appbrand.launching.e.f.lSd.a(paramAnonymousView, "", paramAnonymous2CharSequence, null, 0, 0, localAppBrandStatObject, null, null);
                  AppMethodBeat.o(48627);
                  return true;
                }
                AppMethodBeat.o(48627);
                return false;
              }
            });
            com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/plugin/appbrand/ui/AppBrandLauncherUI$4", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
            AppMethodBeat.o(48628);
            return true;
          }
          com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/plugin/appbrand/ui/AppBrandLauncherUI$4", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
          AppMethodBeat.o(48628);
          return false;
        }
      });
    }
    mGL = getContext().getResources().getColor(2131100705);
    setActionbarColor(mGL);
    findViewById(16908290).setBackgroundColor(mGL);
    ae.i("MicroMsg.AppBrandLauncherUI", "mShowRecommend:%b, recommendDataState:%b, isForceOpenNativeLauncherUI:%b", new Object[] { Boolean.valueOf(this.mGO), Boolean.valueOf(bool3), Boolean.valueOf(bool2) });
    if ((this.mGO) && (bool3) && (!bool2) && (!bool1))
    {
      bAc();
      AppMethodBeat.o(48641);
      return;
    }
    paramBundle = getLifecycle();
    localObject = new RecentsFolderActivityContext(this);
    this.mGP = ((RecentsFolderActivityContext)localObject);
    paramBundle.addObserver((LifecycleObserver)localObject);
    com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(465L, 0L, 1L, false);
    if (!com.tencent.mm.plugin.appbrand.u.a.byV())
    {
      ae.i("MicroMsg.AppBrandSearchLogic", "do not need to update search input hint, shouldShowSearchEntrance is false");
      com.tencent.mm.cp.d.fWU();
      if (t.bcO()) {
        this.mGR = new t.d();
      }
      t.bcQ();
      com.tencent.mm.plugin.appbrand.appusage.i.bcw();
      AppMethodBeat.o(48641);
      return;
    }
    long l2 = System.currentTimeMillis();
    paramBundle = com.tencent.mm.kernel.g.ajR().ajA().get(am.a.ISl, null);
    if ((paramBundle != null) && ((paramBundle instanceof Long))) {}
    for (long l1 = ((Long)paramBundle).longValue();; l1 = 0L)
    {
      paramBundle = Locale.getDefault().getLanguage();
      localObject = com.tencent.mm.kernel.g.ajR().ajA().get(am.a.ISg, null);
      if ((l2 - l1 >= 3600000L) || (localObject == null) || (!localObject.equals(paramBundle))) {
        com.tencent.mm.kernel.g.ajQ().gDv.a(new com.tencent.mm.plugin.appbrand.n.b(), 0);
      }
      ae.v("MicroMsg.AppBrandSearchLogic", "tryToUpdateSearchInputHint, lang(o : %s, c : %s), lastUpdateTime(o : %s, c : %s)", new Object[] { localObject, paramBundle, Long.valueOf(l1), Long.valueOf(l2) });
      break;
    }
  }
  
  public final void onCreateBeforeSetContentView()
  {
    AppMethodBeat.i(48640);
    super.onCreateBeforeSetContentView();
    getWindow().setSoftInputMode(3);
    AppMethodBeat.o(48640);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(48645);
    super.onDestroy();
    com.tencent.mm.plugin.appbrand.appusage.q.clearData();
    if (this.mGR != null)
    {
      t.d locald = this.mGR;
      com.tencent.mm.plugin.report.service.g.yxI.f(14113, (Object[])locald.jSC);
      this.mGR = null;
    }
    com.tencent.mm.kiss.a.b.akS();
    AppMethodBeat.o(48645);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(48643);
    Object localObject;
    if (this.mGN > 0)
    {
      if (this.mGN != 1) {
        break label87;
      }
      i = 7;
      this.mGN = 0;
      localObject = (Fragment)super.getSupportFragmentManager().findFragmentById(16908290);
      if (localObject != null) {
        ((Fragment)localObject).setScene(i);
      }
    }
    super.onResume();
    if (this.enterScene == 13) {}
    for (int i = 52;; i = 201)
    {
      localObject = com.tencent.mm.modelappbrand.b.aDR();
      ad.CJ(0L);
      ad.cu(i, (String)localObject);
      AppMethodBeat.o(48643);
      return;
      label87:
      if (this.mGN == 2)
      {
        i = 6;
        break;
      }
      if (this.mGN == 3)
      {
        i = 9;
        break;
      }
      if (this.mGN == 4)
      {
        i = 12;
        break;
      }
      i = 4;
      break;
    }
  }
  
  public final void onStop()
  {
    AppMethodBeat.i(48644);
    super.onStop();
    if (this.mGQ)
    {
      finish();
      overridePendingTransition(0, 0);
    }
    AppMethodBeat.o(48644);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public final void setTitle(int paramInt)
  {
    AppMethodBeat.i(48648);
    setMMTitle(paramInt);
    AppMethodBeat.o(48648);
  }
  
  public final void setTitle(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(48647);
    setMMTitle(paramCharSequence);
    AppMethodBeat.o(48647);
  }
  
  public final void startActivityForResult(Intent paramIntent, int paramInt, Bundle paramBundle)
  {
    AppMethodBeat.i(48650);
    super.startActivityForResult(paramIntent, paramInt, paramBundle);
    paramBundle = bAb();
    if (paramBundle != null) {
      paramBundle.a(paramIntent, paramInt);
    }
    AppMethodBeat.o(48650);
  }
  
  public static abstract class Fragment
    extends Fragment
  {
    private final aq jzz = new aq(Looper.getMainLooper());
    public View mContentView;
    public String mGW;
    public int mScene;
    
    protected void a(Intent paramIntent, int paramInt) {}
    
    public void bAd() {}
    
    public final <T extends View> T bAe()
    {
      return this.mContentView.findViewById(16908298);
    }
    
    public final View getContentView()
    {
      return this.mContentView;
    }
    
    public abstract int getLayoutId();
    
    public abstract void initView();
    
    @SuppressLint({"ResourceType"})
    public final View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
    {
      if (getLayoutId() < 0) {}
      for (this.mContentView = new FrameLayout(paramViewGroup.getContext());; this.mContentView = paramLayoutInflater.inflate(getLayoutId(), null))
      {
        initView();
        return this.mContentView;
      }
    }
    
    public void onDestroy()
    {
      super.onDestroy();
      this.jzz.removeCallbacksAndMessages(null);
    }
    
    public final void postOnUiThread(Runnable paramRunnable)
    {
      this.jzz.post(paramRunnable);
    }
    
    public final void runOnUiThread(Runnable paramRunnable)
    {
      FragmentActivity localFragmentActivity = getActivity();
      if ((localFragmentActivity == null) || (localFragmentActivity.isDestroyed())) {
        return;
      }
      localFragmentActivity.runOnUiThread(paramRunnable);
    }
    
    public void setScene(int paramInt)
    {
      this.mScene = paramInt;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.AppBrandLauncherUI
 * JD-Core Version:    0.7.0.1
 */