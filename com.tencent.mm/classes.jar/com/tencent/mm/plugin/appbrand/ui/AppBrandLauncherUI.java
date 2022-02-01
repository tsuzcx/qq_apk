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
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appusage.t;
import com.tencent.mm.plugin.appbrand.appusage.t.d;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.service.n;
import com.tencent.mm.plugin.appbrand.ui.recents.RecentsFolderActivityContext;
import com.tencent.mm.plugin.appbrand.ui.recommend.c;
import com.tencent.mm.plugin.appbrand.ui.recommend.k;
import com.tencent.mm.plugin.websearch.api.aa;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.ax;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.ae.a;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMFragmentActivity.a;
import com.tencent.mm.ui.base.h.b;
import java.util.Locale;

@com.tencent.mm.kernel.i
public final class AppBrandLauncherUI
  extends MMActivity
  implements com.tencent.mm.plugin.appbrand.ui.launcher.a
{
  public static int lzC;
  public static final int lzD;
  private int enterScene;
  private int lzE = -1;
  private boolean lzF;
  private RecentsFolderActivityContext lzG;
  private boolean lzH = false;
  public t.d lzI;
  
  static
  {
    AppMethodBeat.i(48653);
    lzC = aj.getContext().getResources().getColor(2131100705);
    lzD = com.tencent.mm.plugin.appbrand.ab.iHI;
    AppMethodBeat.o(48653);
  }
  
  private Fragment boe()
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
  
  private void bof()
  {
    AppMethodBeat.i(180388);
    AppBrandStatObject localAppBrandStatObject = new AppBrandStatObject();
    localAppBrandStatObject.scene = 1112;
    finish();
    overridePendingTransition(0, 0);
    com.tencent.mm.plugin.appbrand.a.f localf = new com.tencent.mm.plugin.appbrand.a.f();
    String str;
    if (com.tencent.mm.protocal.d.CpK >= 654314752)
    {
      localf.iJc = new k();
      ad.i("MicroMsg.AppBrandLauncherUI", "openFakeNativeRecommendUI, wechatNativeExtraData=%s", new Object[] { localf.iJc.aOj() });
      localObject = e.lzS;
      str = e.boi();
      if (!"wxb6d22f922f37b35a".equals(str)) {
        break label199;
      }
    }
    label199:
    for (Object localObject = "gh_b489f391e008@app";; localObject = "gh_9bd4ec2ab601@app")
    {
      localf.username = ((String)localObject);
      localf.appId = str;
      localf.gXn = 0;
      localf.version = 0;
      localf.scene = localAppBrandStatObject.scene;
      ((n)com.tencent.mm.kernel.g.ab(n.class)).a(aj.getContext(), localf);
      this.lzH = true;
      AppMethodBeat.o(180388);
      return;
      localObject = String.format("?showOrderEntrance=%d", new Object[] { Integer.valueOf(1) });
      localf.iJb = ((String)localObject);
      ad.i("MicroMsg.AppBrandLauncherUI", "openFakeNativeRecommendUI, enterPath:%s", new Object[] { localObject });
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
  
  public final void ha(boolean paramBoolean)
  {
    AppMethodBeat.i(48637);
    if (this.lzG != null) {
      this.lzG.ha(paramBoolean);
    }
    if ((paramBoolean) && (this.lzI != null)) {
      this.lzI.iVb[4] = "1";
    }
    AppMethodBeat.o(48637);
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(48646);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    this.lzE = paramInt1;
    if ((paramInt2 == -1) && (paramInt1 == 1))
    {
      String str = paramIntent.getStringExtra("key_session_id");
      paramInt1 = paramIntent.getIntExtra("ftsbizscene", 0);
      ad.i("MicroMsg.AppBrandLauncherUI", "onActivityResult oreh report weAppSearchClickStream(13929) statSessionId:%s, StatKeyWordId:%s", new Object[] { str, com.tencent.mm.modelappbrand.b.gRw });
      com.tencent.mm.plugin.report.service.h.vKh.f(13929, new Object[] { str, com.tencent.mm.modelappbrand.b.gRw, Integer.valueOf(2), Integer.valueOf(paramInt1) });
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
    if (!com.tencent.mm.plugin.appbrand.appusage.i.aRy())
    {
      finish();
      AppMethodBeat.o(48641);
      return;
    }
    paramBundle = getLifecycle();
    Object localObject = com.tencent.mm.plugin.appbrand.report.d.lpj;
    paramBundle.addObserver(com.tencent.mm.plugin.appbrand.report.d.b(this));
    this.enterScene = getIntent().getIntExtra("extra_enter_scene", -1);
    overridePendingTransition(MMFragmentActivity.a.lLF, MMFragmentActivity.a.lLG);
    boolean bool1 = getIntent().getBooleanExtra("extra_show_recents_from_task_bar", false);
    ad.i("MicroMsg.AppBrandLauncherUI", "onCreate showRecentsListTagOnTop:%b", new Object[] { Boolean.valueOf(bool1) });
    paramBundle = e.lzS;
    if ((e.Km().getBoolean("KEY_FORCE_WE_USE_FAKE_NATIVE", false)) && (!bool1))
    {
      ad.i("MicroMsg.AppBrandLauncherUI", "onCreate isForceOpenWeUseFakeNative=TRUE");
      bof();
      AppMethodBeat.o(48641);
      return;
    }
    paramBundle = e.lzS;
    boolean bool2 = e.Km().getBoolean("KEY_FORCE_NATIVE_LAUNCHER", false);
    this.lzF = getIntent().getBooleanExtra("extra_show_recommend", false);
    boolean bool3 = c.bpU();
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
        localFragment.bog();
        AppMethodBeat.o(48623);
      }
    });
    setMMTitle(getResources().getString(2131755401));
    setBackBtn(new AppBrandLauncherUI.2(this), 2131689490);
    if (com.tencent.mm.plugin.appbrand.w.a.bnb()) {
      addIconOptionMenu(AppBrandLauncherUI.a.lzO.ordinal(), 2131764452, 2131689494, new AppBrandLauncherUI.3(this), new View.OnLongClickListener()
      {
        public final boolean onLongClick(final View paramAnonymousView)
        {
          AppMethodBeat.i(48628);
          if (bu.eGT())
          {
            paramAnonymousView = AppBrandLauncherUI.this;
            com.tencent.mm.ui.base.h.a(paramAnonymousView, paramAnonymousView.getResources().getString(2131755951), "", "", 2147483647, new h.b()
            {
              public final boolean onFinish(CharSequence paramAnonymous2CharSequence)
              {
                AppMethodBeat.i(48627);
                if (!TextUtils.isEmpty(paramAnonymous2CharSequence))
                {
                  paramAnonymous2CharSequence = paramAnonymous2CharSequence.toString();
                  AppBrandStatObject localAppBrandStatObject = new AppBrandStatObject();
                  localAppBrandStatObject.scene = 1001;
                  com.tencent.mm.plugin.appbrand.launching.e.f.kOI.a(paramAnonymousView, "", paramAnonymous2CharSequence, null, 0, 0, localAppBrandStatObject, null, null);
                  AppMethodBeat.o(48627);
                  return true;
                }
                AppMethodBeat.o(48627);
                return false;
              }
            });
            AppMethodBeat.o(48628);
            return true;
          }
          AppMethodBeat.o(48628);
          return false;
        }
      });
    }
    lzC = getContext().getResources().getColor(2131100705);
    setActionbarColor(lzC);
    findViewById(16908290).setBackgroundColor(lzC);
    ad.i("MicroMsg.AppBrandLauncherUI", "mShowRecommend:%b, recommendDataState:%b, isForceOpenNativeLauncherUI:%b", new Object[] { Boolean.valueOf(this.lzF), Boolean.valueOf(bool3), Boolean.valueOf(bool2) });
    if ((this.lzF) && (bool3) && (!bool2) && (!bool1))
    {
      bof();
      AppMethodBeat.o(48641);
      return;
    }
    paramBundle = getLifecycle();
    localObject = new RecentsFolderActivityContext(this);
    this.lzG = ((RecentsFolderActivityContext)localObject);
    paramBundle.addObserver((LifecycleObserver)localObject);
    com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(465L, 0L, 1L, false);
    if (!com.tencent.mm.plugin.appbrand.w.a.bnb())
    {
      ad.i("MicroMsg.AppBrandSearchLogic", "do not need to update search input hint, shouldShowSearchEntrance is false");
      com.tencent.mm.cr.d.fkP();
      if (t.aRQ()) {
        this.lzI = new t.d();
      }
      t.aRS();
      com.tencent.mm.plugin.appbrand.appusage.i.aRz();
      AppMethodBeat.o(48641);
      return;
    }
    long l2 = System.currentTimeMillis();
    paramBundle = com.tencent.mm.kernel.g.afB().afk().get(ae.a.FnG, null);
    if ((paramBundle != null) && ((paramBundle instanceof Long))) {}
    for (long l1 = ((Long)paramBundle).longValue();; l1 = 0L)
    {
      paramBundle = Locale.getDefault().getLanguage();
      localObject = com.tencent.mm.kernel.g.afB().afk().get(ae.a.FnB, null);
      if ((l2 - l1 >= 3600000L) || (localObject == null) || (!localObject.equals(paramBundle))) {
        com.tencent.mm.kernel.g.afA().gcy.a(new com.tencent.mm.plugin.appbrand.p.b(), 0);
      }
      ad.v("MicroMsg.AppBrandSearchLogic", "tryToUpdateSearchInputHint, lang(o : %s, c : %s), lastUpdateTime(o : %s, c : %s)", new Object[] { localObject, paramBundle, Long.valueOf(l1), Long.valueOf(l2) });
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
    if (this.lzI != null)
    {
      t.d locald = this.lzI;
      com.tencent.mm.plugin.report.service.h.vKh.f(14113, (Object[])locald.iVb);
      this.lzI = null;
    }
    com.tencent.mm.kiss.a.b.agB();
    AppMethodBeat.o(48645);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(48643);
    Object localObject;
    if (this.lzE > 0)
    {
      if (this.lzE != 1) {
        break label88;
      }
      i = 7;
      this.lzE = 0;
      localObject = (Fragment)super.getSupportFragmentManager().findFragmentById(16908290);
      if (localObject != null) {
        ((Fragment)localObject).setScene(i);
      }
    }
    super.onResume();
    if (this.enterScene == 13) {}
    for (int i = 52;; i = 201)
    {
      localObject = com.tencent.mm.modelappbrand.b.atH();
      aa.cj(i, (String)localObject);
      aa.cl(i, (String)localObject);
      AppMethodBeat.o(48643);
      return;
      label88:
      if (this.lzE == 2)
      {
        i = 6;
        break;
      }
      if (this.lzE == 3)
      {
        i = 9;
        break;
      }
      if (this.lzE == 4)
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
    if (this.lzH)
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
    paramBundle = boe();
    if (paramBundle != null) {
      paramBundle.a(paramIntent, paramInt);
    }
    AppMethodBeat.o(48650);
  }
  
  public static abstract class Fragment
    extends Fragment
  {
    private final ap iDu = new ap(Looper.getMainLooper());
    public String lzN;
    public View mContentView;
    public int mScene;
    
    protected void a(Intent paramIntent, int paramInt) {}
    
    public void bog() {}
    
    public final <T extends View> T boh()
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
      this.iDu.removeCallbacksAndMessages(null);
    }
    
    public final void postOnUiThread(Runnable paramRunnable)
    {
      this.iDu.post(paramRunnable);
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