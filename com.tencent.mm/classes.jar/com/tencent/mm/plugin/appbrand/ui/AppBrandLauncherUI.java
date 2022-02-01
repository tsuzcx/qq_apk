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
import com.tencent.mm.kernel.e;
import com.tencent.mm.plugin.appbrand.ac;
import com.tencent.mm.plugin.appbrand.appusage.q;
import com.tencent.mm.plugin.appbrand.appusage.t.d;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.service.r;
import com.tencent.mm.plugin.appbrand.ui.recents.RecentsFolderActivityContext;
import com.tencent.mm.plugin.appbrand.ui.recommend.c;
import com.tencent.mm.plugin.appbrand.ui.recommend.k;
import com.tencent.mm.plugin.websearch.api.ai;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.WeChatEnvironment;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h.b;
import java.util.Locale;

@com.tencent.mm.kernel.i
public final class AppBrandLauncherUI
  extends MMActivity
  implements com.tencent.mm.plugin.appbrand.ui.launcher.a
{
  public static int nTJ;
  public static final int nTK;
  private int enterScene;
  private int nTL = -1;
  private boolean nTM;
  private RecentsFolderActivityContext nTN;
  private boolean nTO = false;
  public t.d nTP;
  
  static
  {
    AppMethodBeat.i(48653);
    nTJ = MMApplicationContext.getContext().getResources().getColor(2131100898);
    nTK = ac.kEM;
    AppMethodBeat.o(48653);
  }
  
  private Fragment bWZ()
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
  
  private void bXa()
  {
    AppMethodBeat.i(180388);
    AppBrandStatObject localAppBrandStatObject = new AppBrandStatObject();
    localAppBrandStatObject.scene = 1112;
    finish();
    overridePendingTransition(0, 0);
    com.tencent.mm.plugin.appbrand.api.g localg = new com.tencent.mm.plugin.appbrand.api.g();
    String str;
    if (com.tencent.mm.protocal.d.KyO >= 654314752)
    {
      localg.kHx = new k();
      Log.i("MicroMsg.AppBrandLauncherUI", "openFakeNativeRecommendUI, wechatNativeExtraData=%s", new Object[] { localg.kHx.bua() });
      localObject = i.nTZ;
      str = i.bXd();
      if (!"wxb6d22f922f37b35a".equals(str)) {
        break label199;
      }
    }
    label199:
    for (Object localObject = "gh_b489f391e008@app";; localObject = "gh_9bd4ec2ab601@app")
    {
      localg.username = ((String)localObject);
      localg.appId = str;
      localg.iOo = 0;
      localg.version = 0;
      localg.scene = localAppBrandStatObject.scene;
      ((r)com.tencent.mm.kernel.g.af(r.class)).a(MMApplicationContext.getContext(), localg);
      this.nTO = true;
      AppMethodBeat.o(180388);
      return;
      localObject = String.format("?showOrderEntrance=%d", new Object[] { Integer.valueOf(1) });
      localg.kHw = ((String)localObject);
      Log.i("MicroMsg.AppBrandLauncherUI", "openFakeNativeRecommendUI, enterPath:%s", new Object[] { localObject });
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
  
  public final void iI(boolean paramBoolean)
  {
    AppMethodBeat.i(48637);
    if (this.nTN != null) {
      this.nTN.iI(paramBoolean);
    }
    if ((paramBoolean) && (this.nTP != null)) {
      this.nTP.kVm[4] = "1";
    }
    AppMethodBeat.o(48637);
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(48646);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    this.nTL = paramInt1;
    if ((paramInt2 == -1) && (paramInt1 == 1))
    {
      String str = paramIntent.getStringExtra("key_session_id");
      paramInt1 = paramIntent.getIntExtra("ftsbizscene", 0);
      Log.i("MicroMsg.AppBrandLauncherUI", "onActivityResult oreh report weAppSearchClickStream(13929) statSessionId:%s, StatKeyWordId:%s", new Object[] { str, com.tencent.mm.modelappbrand.b.iIn });
      com.tencent.mm.plugin.report.service.h.CyF.a(13929, new Object[] { str, com.tencent.mm.modelappbrand.b.iIn, Integer.valueOf(2), Integer.valueOf(paramInt1) });
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
    if (!com.tencent.mm.plugin.appbrand.appusage.i.bxK())
    {
      finish();
      AppMethodBeat.o(48641);
      return;
    }
    paramBundle = getLifecycle();
    Object localObject = com.tencent.mm.plugin.appbrand.report.f.nGV;
    paramBundle.addObserver(com.tencent.mm.plugin.appbrand.report.f.b(this));
    this.enterScene = getIntent().getIntExtra("extra_enter_scene", -1);
    boolean bool1 = getIntent().getBooleanExtra("extra_show_recents_from_task_bar", false);
    Log.i("MicroMsg.AppBrandLauncherUI", "onCreate showRecentsListTagOnTop:%b", new Object[] { Boolean.valueOf(bool1) });
    paramBundle = i.nTZ;
    if ((i.VQ().getBoolean("KEY_FORCE_WE_USE_FAKE_NATIVE", false)) && (!bool1))
    {
      Log.i("MicroMsg.AppBrandLauncherUI", "onCreate isForceOpenWeUseFakeNative=TRUE");
      bXa();
      AppMethodBeat.o(48641);
      return;
    }
    paramBundle = i.nTZ;
    boolean bool2 = i.VQ().getBoolean("KEY_FORCE_NATIVE_LAUNCHER", false);
    this.nTM = getIntent().getBooleanExtra("extra_show_recommend", false);
    boolean bool3 = c.bYR();
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
        localFragment.bXb();
        AppMethodBeat.o(48623);
      }
    });
    setMMTitle(getResources().getString(2131755440));
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(48624);
        AppBrandLauncherUI.this.onBackPressed();
        AppMethodBeat.o(48624);
        return true;
      }
    }, 2131689492);
    if (com.tencent.mm.plugin.appbrand.y.a.bVo()) {
      addIconOptionMenu(AppBrandLauncherUI.a.nTV.ordinal(), 2131766796, 2131689496, new MenuItem.OnMenuItemClickListener()new View.OnLongClickListener
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(48626);
          ((com.tencent.mm.plugin.websearch.api.i)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.websearch.api.i.class)).a(MMApplicationContext.getContext(), new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(48625);
              if (AppBrandLauncherUI.b(AppBrandLauncherUI.this) == 13) {}
              for (int i = 52;; i = 201)
              {
                AppBrandLauncherUI localAppBrandLauncherUI = AppBrandLauncherUI.this;
                com.tencent.mm.plugin.appbrand.c.a locala = com.tencent.mm.plugin.appbrand.c.a.lbr;
                localAppBrandLauncherUI.startActivityForResult(com.tencent.mm.plugin.appbrand.c.a.M(AppBrandLauncherUI.this, i), 1);
                AppMethodBeat.o(48625);
                return;
              }
            }
          });
          AppMethodBeat.o(48626);
          return true;
        }
      }, new View.OnLongClickListener()
      {
        public final boolean onLongClick(final View paramAnonymousView)
        {
          AppMethodBeat.i(48628);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bm(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/appbrand/ui/AppBrandLauncherUI$4", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, localb.axR());
          if (WeChatEnvironment.hasDebugger())
          {
            paramAnonymousView = AppBrandLauncherUI.this;
            com.tencent.mm.ui.base.h.a(paramAnonymousView, paramAnonymousView.getResources().getString(2131756049), "", "", 2147483647, new h.b()
            {
              public final boolean onFinish(CharSequence paramAnonymous2CharSequence)
              {
                AppMethodBeat.i(48627);
                if (!TextUtils.isEmpty(paramAnonymous2CharSequence))
                {
                  paramAnonymous2CharSequence = paramAnonymous2CharSequence.toString();
                  AppBrandStatObject localAppBrandStatObject = new AppBrandStatObject();
                  localAppBrandStatObject.scene = 1001;
                  com.tencent.mm.plugin.appbrand.launching.e.f.mZp.a(paramAnonymousView, "", paramAnonymous2CharSequence, null, 0, 0, localAppBrandStatObject, null, null);
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
    nTJ = getContext().getResources().getColor(2131100898);
    setActionbarColor(nTJ);
    findViewById(16908290).setBackgroundColor(nTJ);
    Log.i("MicroMsg.AppBrandLauncherUI", "mShowRecommend:%b, recommendDataState:%b, isForceOpenNativeLauncherUI:%b", new Object[] { Boolean.valueOf(this.nTM), Boolean.valueOf(bool3), Boolean.valueOf(bool2) });
    if ((this.nTM) && (bool3) && (!bool2) && (!bool1))
    {
      bXa();
      AppMethodBeat.o(48641);
      return;
    }
    paramBundle = getLifecycle();
    localObject = new RecentsFolderActivityContext(this);
    this.nTN = ((RecentsFolderActivityContext)localObject);
    paramBundle.addObserver((LifecycleObserver)localObject);
    com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(465L, 0L, 1L, false);
    if (!com.tencent.mm.plugin.appbrand.y.a.bVo())
    {
      Log.i("MicroMsg.AppBrandSearchLogic", "do not need to update search input hint, shouldShowSearchEntrance is false");
      com.tencent.mm.cr.d.hiy();
      if (com.tencent.mm.plugin.appbrand.appusage.t.byd()) {
        this.nTP = new t.d();
      }
      com.tencent.mm.plugin.appbrand.appusage.t.byf();
      com.tencent.mm.plugin.appbrand.appusage.i.bxL();
      AppMethodBeat.o(48641);
      return;
    }
    long l2 = System.currentTimeMillis();
    paramBundle = com.tencent.mm.kernel.g.aAh().azQ().get(ar.a.Oan, null);
    if ((paramBundle != null) && ((paramBundle instanceof Long))) {}
    for (long l1 = ((Long)paramBundle).longValue();; l1 = 0L)
    {
      paramBundle = Locale.getDefault().getLanguage();
      localObject = com.tencent.mm.kernel.g.aAh().azQ().get(ar.a.Oai, null);
      if ((l2 - l1 >= 3600000L) || (localObject == null) || (!localObject.equals(paramBundle))) {
        com.tencent.mm.kernel.g.aAg().hqi.a(new com.tencent.mm.plugin.appbrand.r.b(), 0);
      }
      Log.v("MicroMsg.AppBrandSearchLogic", "tryToUpdateSearchInputHint, lang(o : %s, c : %s), lastUpdateTime(o : %s, c : %s)", new Object[] { localObject, paramBundle, Long.valueOf(l1), Long.valueOf(l2) });
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
    q.clearData();
    if (this.nTP != null)
    {
      t.d locald = this.nTP;
      com.tencent.mm.plugin.report.service.h.CyF.a(14113, (Object[])locald.kVm);
      this.nTP = null;
    }
    com.tencent.mm.kiss.a.b.aBi();
    AppMethodBeat.o(48645);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(48643);
    Object localObject;
    if (this.nTL > 0)
    {
      if (this.nTL != 1) {
        break label87;
      }
      i = 7;
      this.nTL = 0;
      localObject = (Fragment)super.getSupportFragmentManager().findFragmentById(16908290);
      if (localObject != null) {
        ((Fragment)localObject).setScene(i);
      }
    }
    super.onResume();
    if (this.enterScene == 13) {}
    for (int i = 52;; i = 201)
    {
      localObject = com.tencent.mm.modelappbrand.b.aXE();
      ai.LX(0L);
      ai.cM(i, (String)localObject);
      AppMethodBeat.o(48643);
      return;
      label87:
      if (this.nTL == 2)
      {
        i = 6;
        break;
      }
      if (this.nTL == 3)
      {
        i = 9;
        break;
      }
      if (this.nTL == 4)
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
    if (this.nTO)
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
    paramBundle = bWZ();
    if (paramBundle != null) {
      paramBundle.a(paramIntent, paramInt);
    }
    AppMethodBeat.o(48650);
  }
  
  public static abstract class Fragment
    extends Fragment
  {
    private final MMHandler kAn = new MMHandler(Looper.getMainLooper());
    public View mContentView;
    public int mScene;
    public String nTU;
    
    protected void a(Intent paramIntent, int paramInt) {}
    
    public void bXb() {}
    
    public final <T extends View> T bXc()
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
      this.kAn.removeCallbacksAndMessages(null);
    }
    
    public final void postOnUiThread(Runnable paramRunnable)
    {
      this.kAn.post(paramRunnable);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.AppBrandLauncherUI
 * JD-Core Version:    0.7.0.1
 */