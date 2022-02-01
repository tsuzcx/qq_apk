package com.tencent.mm.plugin.appbrand.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.j;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ak;
import com.tencent.mm.plugin.appbrand.api.g;
import com.tencent.mm.plugin.appbrand.appusage.s.d;
import com.tencent.mm.plugin.appbrand.ba.c;
import com.tencent.mm.plugin.appbrand.ba.h;
import com.tencent.mm.plugin.appbrand.ba.i;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.service.t;
import com.tencent.mm.plugin.appbrand.ui.recents.RecentsFolderActivityContext;
import com.tencent.mm.plugin.websearch.api.aj;
import com.tencent.mm.plugin.websearch.api.i;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import com.tencent.mm.ui.MMActivity;
import java.util.Locale;

@com.tencent.mm.kernel.k
public final class AppBrandLauncherUI
  extends MMActivity
  implements com.tencent.mm.plugin.appbrand.ui.launcher.a
{
  public static int uaO;
  public static final int uaP;
  private int enterScene;
  private int uaQ = -1;
  private boolean uaR;
  private RecentsFolderActivityContext uaS;
  private boolean uaT = false;
  public s.d uaU;
  
  static
  {
    AppMethodBeat.i(48653);
    uaO = MMApplicationContext.getContext().getResources().getColor(ba.c.normal_actionbar_color);
    uaP = ak.qxA;
    AppMethodBeat.o(48653);
  }
  
  private Fragment cKR()
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
  
  private void cKS()
  {
    AppMethodBeat.i(180388);
    AppBrandStatObject localAppBrandStatObject = new AppBrandStatObject();
    localAppBrandStatObject.scene = 1112;
    finish();
    overridePendingTransition(0, 0);
    g localg = new g();
    String str;
    if (com.tencent.mm.protocal.d.Yxh >= 654314752)
    {
      localg.qAG = new com.tencent.mm.plugin.appbrand.ui.recommend.k();
      Log.i("MicroMsg.AppBrandLauncherUI", "openFakeNativeRecommendUI, wechatNativeExtraData=%s", new Object[] { localg.qAG.toJsonString() });
      localObject = f.ube;
      str = f.cKU();
      if (!"wxb6d22f922f37b35a".equals(str)) {
        break label199;
      }
    }
    label199:
    for (Object localObject = "gh_b489f391e008@app";; localObject = "gh_9bd4ec2ab601@app")
    {
      localg.username = ((String)localObject);
      localg.appId = str;
      localg.euz = 0;
      localg.version = 0;
      localg.scene = localAppBrandStatObject.scene;
      ((t)com.tencent.mm.kernel.h.ax(t.class)).a(MMApplicationContext.getContext(), localg);
      this.uaT = true;
      AppMethodBeat.o(180388);
      return;
      localObject = String.format("?showOrderEntrance=%d", new Object[] { Integer.valueOf(1) });
      localg.qAF = ((String)localObject);
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
  
  public final void kT(boolean paramBoolean)
  {
    AppMethodBeat.i(48637);
    if (this.uaS != null) {
      this.uaS.kT(paramBoolean);
    }
    if ((paramBoolean) && (this.uaU != null)) {
      this.uaU.qPr[4] = "1";
    }
    AppMethodBeat.o(48637);
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(48646);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    this.uaQ = paramInt1;
    if ((paramInt2 == -1) && (paramInt1 == 1))
    {
      String str = paramIntent.getStringExtra("key_session_id");
      paramInt1 = paramIntent.getIntExtra("ftsbizscene", 0);
      Log.i("MicroMsg.AppBrandLauncherUI", "onActivityResult oreh report weAppSearchClickStream(13929) statSessionId:%s, StatKeyWordId:%s", new Object[] { str, com.tencent.mm.modelappbrand.c.opQ });
      com.tencent.mm.plugin.report.service.h.OAn.b(13929, new Object[] { str, com.tencent.mm.modelappbrand.c.opQ, Integer.valueOf(2), Integer.valueOf(paramInt1) });
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
    if (!com.tencent.mm.plugin.appbrand.appusage.h.ciD())
    {
      finish();
      AppMethodBeat.o(48641);
      return;
    }
    getLifecycle().addObserver(com.tencent.mm.plugin.appbrand.report.f.tNH.a(this));
    this.enterScene = getIntent().getIntExtra("extra_enter_scene", -1);
    boolean bool2 = getIntent().getBooleanExtra("extra_show_recents_from_task_bar", false);
    Log.i("MicroMsg.AppBrandLauncherUI", "onCreate showRecentsListTagOnTop:%b", new Object[] { Boolean.valueOf(bool2) });
    paramBundle = f.ube;
    if ((f.aBP().getBoolean("KEY_FORCE_WE_USE_FAKE_NATIVE", false)) && (!bool2))
    {
      Log.i("MicroMsg.AppBrandLauncherUI", "onCreate isForceOpenWeUseFakeNative=TRUE");
      cKS();
      AppMethodBeat.o(48641);
      return;
    }
    paramBundle = f.ube;
    boolean bool3 = f.aBP().getBoolean("KEY_FORCE_NATIVE_LAUNCHER", false);
    this.uaR = getIntent().getBooleanExtra("extra_show_recommend", false);
    if (((Integer)com.tencent.mm.kernel.h.baE().ban().get(at.a.acNJ, Integer.valueOf(0))).intValue() == 1) {}
    for (boolean bool1 = true;; bool1 = false)
    {
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
          localFragment.cKT();
          AppMethodBeat.o(48623);
        }
      });
      setMMTitle(getResources().getString(ba.i.app_brand_entrance));
      setBackBtn(new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(48624);
          AppBrandLauncherUI.this.onBackPressed();
          AppMethodBeat.o(48624);
          return true;
        }
      }, ba.h.actionbar_icon_dark_back);
      if (com.tencent.mm.plugin.appbrand.z.a.cJo()) {
        addIconOptionMenu(AppBrandLauncherUI.a.uba.ordinal(), ba.i.top_item_desc_search, ba.h.actionbar_icon_dark_search, new MenuItem.OnMenuItemClickListener()new AppBrandLauncherUI.4
        {
          public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
          {
            AppMethodBeat.i(48626);
            ((i)com.tencent.mm.kernel.h.ax(i.class)).a(MMApplicationContext.getContext(), new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(48625);
                ((com.tencent.mm.plugin.websearch.api.h)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.websearch.api.h.class)).bg(AppBrandLauncherUI.this, 201);
                AppMethodBeat.o(48625);
              }
            });
            AppMethodBeat.o(48626);
            return true;
          }
        }, new AppBrandLauncherUI.4(this));
      }
      paramBundle = com.tencent.mm.plugin.appbrand.ui.privacy.a.uiz;
      if (com.tencent.mm.plugin.appbrand.ui.privacy.a.cMr()) {
        addIconOptionMenu(AppBrandLauncherUI.a.ubb.ordinal(), ba.i.top_item_desc_more, ba.h.actionbar_icon_dark_more, new AppBrandLauncherUI..ExternalSyntheticLambda0(this));
      }
      uaO = getContext().getResources().getColor(ba.c.normal_actionbar_color);
      setActionbarColor(uaO);
      findViewById(16908290).setBackgroundColor(uaO);
      Log.i("MicroMsg.AppBrandLauncherUI", "mShowRecommend:%b, recommendDataState:%b, isForceOpenNativeLauncherUI:%b", new Object[] { Boolean.valueOf(this.uaR), Boolean.valueOf(bool1), Boolean.valueOf(bool3) });
      if ((!this.uaR) || (!bool1) || (bool3) || (bool2)) {
        break;
      }
      cKS();
      AppMethodBeat.o(48641);
      return;
    }
    paramBundle = getLifecycle();
    Object localObject = new RecentsFolderActivityContext(this);
    this.uaS = ((RecentsFolderActivityContext)localObject);
    paramBundle.addObserver((androidx.lifecycle.p)localObject);
    com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(465L, 0L, 1L, false);
    if (!com.tencent.mm.plugin.appbrand.z.a.cJo())
    {
      Log.i("MicroMsg.AppBrandSearchLogic", "do not need to update search input hint, shouldShowSearchEntrance is false");
      com.tencent.mm.xwebutil.c.jQE();
      if (com.tencent.mm.plugin.appbrand.appusage.s.ciW()) {
        this.uaU = new s.d();
      }
      com.tencent.mm.plugin.appbrand.appusage.s.ciY();
      com.tencent.mm.plugin.appbrand.appusage.h.ciE();
      AppMethodBeat.o(48641);
      return;
    }
    long l2 = System.currentTimeMillis();
    paramBundle = com.tencent.mm.kernel.h.baE().ban().get(at.a.acPL, null);
    if ((paramBundle != null) && ((paramBundle instanceof Long))) {}
    for (long l1 = ((Long)paramBundle).longValue();; l1 = 0L)
    {
      paramBundle = Locale.getDefault().getLanguage();
      localObject = com.tencent.mm.kernel.h.baE().ban().get(at.a.acPG, null);
      if ((l2 - l1 >= 3600000L) || (localObject == null) || (!localObject.equals(paramBundle))) {
        com.tencent.mm.kernel.h.baD().mCm.a(new com.tencent.mm.plugin.appbrand.s.b(), 0);
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
    com.tencent.mm.plugin.appbrand.appusage.p.clearData();
    if (this.uaU != null)
    {
      s.d locald = this.uaU;
      com.tencent.mm.plugin.report.service.h.OAn.b(14113, (Object[])locald.qPr);
      this.uaU = null;
    }
    com.tencent.mm.kiss.layout.b.bbH();
    AppMethodBeat.o(48645);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(48643);
    int i;
    if (this.uaQ > 0)
    {
      if (this.uaQ != 1) {
        break label65;
      }
      i = 7;
    }
    for (;;)
    {
      this.uaQ = 0;
      Fragment localFragment = (Fragment)super.getSupportFragmentManager().findFragmentById(16908290);
      if (localFragment != null) {
        localFragment.setScene(i);
      }
      super.onResume();
      aj.ipW();
      AppMethodBeat.o(48643);
      return;
      label65:
      if (this.uaQ == 2) {
        i = 6;
      } else if (this.uaQ == 3) {
        i = 9;
      } else if (this.uaQ == 4) {
        i = 12;
      } else {
        i = 4;
      }
    }
  }
  
  public final void onStop()
  {
    AppMethodBeat.i(48644);
    super.onStop();
    if (this.uaT)
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
    paramBundle = cKR();
    if (paramBundle != null) {
      paramBundle.a(paramIntent, paramInt);
    }
    AppMethodBeat.o(48650);
  }
  
  public static abstract class Fragment
    extends Fragment
  {
    public View mContentView;
    public int mScene;
    private final MMHandler qse = new MMHandler(Looper.getMainLooper());
    public String uaZ;
    
    protected void a(Intent paramIntent, int paramInt) {}
    
    public void cKT() {}
    
    public abstract int getLayoutId();
    
    public abstract void initView();
    
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
      this.qse.removeCallbacksAndMessages(null);
    }
    
    public final void postOnUiThread(Runnable paramRunnable)
    {
      this.qse.post(paramRunnable);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.AppBrandLauncherUI
 * JD-Core Version:    0.7.0.1
 */