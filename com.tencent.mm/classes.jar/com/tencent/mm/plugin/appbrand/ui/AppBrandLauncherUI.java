package com.tencent.mm.plugin.appbrand.ui;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.ActivityOptions;
import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.LifecycleObserver;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Looper;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Pair;
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
import com.tencent.mm.plugin.appbrand.service.o;
import com.tencent.mm.plugin.appbrand.ui.recents.RecentsFolderActivityContext;
import com.tencent.mm.plugin.appbrand.ui.recommend.c;
import com.tencent.mm.plugin.appbrand.ui.recommend.k;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.ax;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.al.a;
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
  public static int mBG;
  public static final int mBH;
  private int enterScene;
  private int mBI = -1;
  private boolean mBJ;
  private RecentsFolderActivityContext mBK;
  private boolean mBL = false;
  public t.d mBM;
  
  static
  {
    AppMethodBeat.i(48653);
    mBG = aj.getContext().getResources().getColor(2131100705);
    mBH = ab.jAT;
    AppMethodBeat.o(48653);
  }
  
  private Fragment bzg()
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
  
  private void bzh()
  {
    AppMethodBeat.i(180388);
    AppBrandStatObject localAppBrandStatObject = new AppBrandStatObject();
    localAppBrandStatObject.scene = 1112;
    finish();
    overridePendingTransition(0, 0);
    com.tencent.mm.plugin.appbrand.api.f localf = new com.tencent.mm.plugin.appbrand.api.f();
    String str;
    if (com.tencent.mm.protocal.d.Fnj >= 654314752)
    {
      localf.jCO = new k();
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.AppBrandLauncherUI", "openFakeNativeRecommendUI, wechatNativeExtraData=%s", new Object[] { localf.jCO.aYt() });
      localObject = f.mBW;
      str = f.bzk();
      if (!"wxb6d22f922f37b35a".equals(str)) {
        break label199;
      }
    }
    label199:
    for (Object localObject = "gh_b489f391e008@app";; localObject = "gh_9bd4ec2ab601@app")
    {
      localf.username = ((String)localObject);
      localf.appId = str;
      localf.hQh = 0;
      localf.version = 0;
      localf.scene = localAppBrandStatObject.scene;
      ((o)com.tencent.mm.kernel.g.ab(o.class)).a(aj.getContext(), localf);
      this.mBL = true;
      AppMethodBeat.o(180388);
      return;
      localObject = String.format("?showOrderEntrance=%d", new Object[] { Integer.valueOf(1) });
      localf.jCN = ((String)localObject);
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.AppBrandLauncherUI", "openFakeNativeRecommendUI, enterPath:%s", new Object[] { localObject });
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
  
  public final void hE(boolean paramBoolean)
  {
    AppMethodBeat.i(48637);
    if (this.mBK != null) {
      this.mBK.hE(paramBoolean);
    }
    if ((paramBoolean) && (this.mBM != null)) {
      this.mBM.jPk[4] = "1";
    }
    AppMethodBeat.o(48637);
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(48646);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    this.mBI = paramInt1;
    if ((paramInt2 == -1) && (paramInt1 == 1))
    {
      String str = paramIntent.getStringExtra("key_session_id");
      paramInt1 = paramIntent.getIntExtra("ftsbizscene", 0);
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.AppBrandLauncherUI", "onActivityResult oreh report weAppSearchClickStream(13929) statSessionId:%s, StatKeyWordId:%s", new Object[] { str, com.tencent.mm.modelappbrand.b.hKo });
      com.tencent.mm.plugin.report.service.g.yhR.f(13929, new Object[] { str, com.tencent.mm.modelappbrand.b.hKo, Integer.valueOf(2), Integer.valueOf(paramInt1) });
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
    if (!com.tencent.mm.plugin.appbrand.appusage.i.bbR())
    {
      finish();
      AppMethodBeat.o(48641);
      return;
    }
    paramBundle = getLifecycle();
    Object localObject = com.tencent.mm.plugin.appbrand.report.e.mqZ;
    paramBundle.addObserver(com.tencent.mm.plugin.appbrand.report.e.b(this));
    this.enterScene = getIntent().getIntExtra("extra_enter_scene", -1);
    overridePendingTransition(MMFragmentActivity.a.mOe, MMFragmentActivity.a.mOf);
    boolean bool1 = getIntent().getBooleanExtra("extra_show_recents_from_task_bar", false);
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.AppBrandLauncherUI", "onCreate showRecentsListTagOnTop:%b", new Object[] { Boolean.valueOf(bool1) });
    paramBundle = f.mBW;
    if ((f.Lv().getBoolean("KEY_FORCE_WE_USE_FAKE_NATIVE", false)) && (!bool1))
    {
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.AppBrandLauncherUI", "onCreate isForceOpenWeUseFakeNative=TRUE");
      bzh();
      AppMethodBeat.o(48641);
      return;
    }
    paramBundle = f.mBW;
    boolean bool2 = f.Lv().getBoolean("KEY_FORCE_NATIVE_LAUNCHER", false);
    this.mBJ = getIntent().getBooleanExtra("extra_show_recommend", false);
    boolean bool3 = c.bAX();
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
        localFragment.bzi();
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
    if (com.tencent.mm.plugin.appbrand.v.a.byc()) {
      addIconOptionMenu(AppBrandLauncherUI.a.mBS.ordinal(), 2131764452, 2131689494, new MenuItem.OnMenuItemClickListener()new View.OnLongClickListener
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(48626);
          ((com.tencent.mm.plugin.websearch.api.i)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.websearch.api.i.class)).a(aj.getContext(), new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(48625);
              Bundle localBundle = null;
              if (Build.VERSION.SDK_INT >= 21) {
                localBundle = ActivityOptions.makeSceneTransitionAnimation(AppBrandLauncherUI.this, new Pair[0]).toBundle();
              }
              if (AppBrandLauncherUI.b(AppBrandLauncherUI.this) == 13) {}
              for (int i = 52;; i = 201)
              {
                AppBrandLauncherUI localAppBrandLauncherUI = AppBrandLauncherUI.this;
                com.tencent.mm.plugin.appbrand.c.a locala = com.tencent.mm.plugin.appbrand.c.a.jVc;
                localAppBrandLauncherUI.startActivityForResult(com.tencent.mm.plugin.appbrand.c.a.I(AppBrandLauncherUI.this, i), 1, localBundle);
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
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/appbrand/ui/AppBrandLauncherUI$4", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, localb.ahq());
          if (bu.flY())
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
                  com.tencent.mm.plugin.appbrand.launching.e.f.lNC.a(paramAnonymousView, "", paramAnonymous2CharSequence, null, 0, 0, localAppBrandStatObject, null, null);
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
    mBG = getContext().getResources().getColor(2131100705);
    setActionbarColor(mBG);
    findViewById(16908290).setBackgroundColor(mBG);
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.AppBrandLauncherUI", "mShowRecommend:%b, recommendDataState:%b, isForceOpenNativeLauncherUI:%b", new Object[] { Boolean.valueOf(this.mBJ), Boolean.valueOf(bool3), Boolean.valueOf(bool2) });
    if ((this.mBJ) && (bool3) && (!bool2) && (!bool1))
    {
      bzh();
      AppMethodBeat.o(48641);
      return;
    }
    paramBundle = getLifecycle();
    localObject = new RecentsFolderActivityContext(this);
    this.mBK = ((RecentsFolderActivityContext)localObject);
    paramBundle.addObserver((LifecycleObserver)localObject);
    com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(465L, 0L, 1L, false);
    if (!com.tencent.mm.plugin.appbrand.v.a.byc())
    {
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.AppBrandSearchLogic", "do not need to update search input hint, shouldShowSearchEntrance is false");
      com.tencent.mm.cq.d.fSu();
      if (t.bcj()) {
        this.mBM = new t.d();
      }
      t.bcl();
      com.tencent.mm.plugin.appbrand.appusage.i.bbS();
      AppMethodBeat.o(48641);
      return;
    }
    long l2 = System.currentTimeMillis();
    paramBundle = com.tencent.mm.kernel.g.ajC().ajl().get(al.a.IxN, null);
    if ((paramBundle != null) && ((paramBundle instanceof Long))) {}
    for (long l1 = ((Long)paramBundle).longValue();; l1 = 0L)
    {
      paramBundle = Locale.getDefault().getLanguage();
      localObject = com.tencent.mm.kernel.g.ajC().ajl().get(al.a.IxI, null);
      if ((l2 - l1 >= 3600000L) || (localObject == null) || (!localObject.equals(paramBundle))) {
        com.tencent.mm.kernel.g.ajB().gAO.a(new com.tencent.mm.plugin.appbrand.n.b(), 0);
      }
      com.tencent.mm.sdk.platformtools.ad.v("MicroMsg.AppBrandSearchLogic", "tryToUpdateSearchInputHint, lang(o : %s, c : %s), lastUpdateTime(o : %s, c : %s)", new Object[] { localObject, paramBundle, Long.valueOf(l1), Long.valueOf(l2) });
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
    if (this.mBM != null)
    {
      t.d locald = this.mBM;
      com.tencent.mm.plugin.report.service.g.yhR.f(14113, (Object[])locald.jPk);
      this.mBM = null;
    }
    com.tencent.mm.kiss.a.b.akD();
    AppMethodBeat.o(48645);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(48643);
    Object localObject;
    if (this.mBI > 0)
    {
      if (this.mBI != 1) {
        break label87;
      }
      i = 7;
      this.mBI = 0;
      localObject = (Fragment)super.getSupportFragmentManager().findFragmentById(16908290);
      if (localObject != null) {
        ((Fragment)localObject).setScene(i);
      }
    }
    super.onResume();
    if (this.enterScene == 13) {}
    for (int i = 52;; i = 201)
    {
      localObject = com.tencent.mm.modelappbrand.b.aDB();
      com.tencent.mm.plugin.websearch.api.ad.Cl(0L);
      com.tencent.mm.plugin.websearch.api.ad.cu(i, (String)localObject);
      AppMethodBeat.o(48643);
      return;
      label87:
      if (this.mBI == 2)
      {
        i = 6;
        break;
      }
      if (this.mBI == 3)
      {
        i = 9;
        break;
      }
      if (this.mBI == 4)
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
    if (this.mBL)
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
    paramBundle = bzg();
    if (paramBundle != null) {
      paramBundle.a(paramIntent, paramInt);
    }
    AppMethodBeat.o(48650);
  }
  
  public static abstract class Fragment
    extends Fragment
  {
    private final ap jwD = new ap(Looper.getMainLooper());
    public String mBR;
    public View mContentView;
    public int mScene;
    
    protected void a(Intent paramIntent, int paramInt) {}
    
    public void bzi() {}
    
    public final <T extends View> T bzj()
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
      this.jwD.removeCallbacksAndMessages(null);
    }
    
    public final void postOnUiThread(Runnable paramRunnable)
    {
      this.jwD.post(paramRunnable);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.AppBrandLauncherUI
 * JD-Core Version:    0.7.0.1
 */