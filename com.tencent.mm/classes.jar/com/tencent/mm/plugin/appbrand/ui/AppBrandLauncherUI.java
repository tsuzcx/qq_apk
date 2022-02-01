package com.tencent.mm.plugin.appbrand.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnLongClickListener;
import android.view.Window;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ag;
import com.tencent.mm.plugin.appbrand.appusage.q;
import com.tencent.mm.plugin.appbrand.appusage.t.d;
import com.tencent.mm.plugin.appbrand.au.c;
import com.tencent.mm.plugin.appbrand.au.h;
import com.tencent.mm.plugin.appbrand.au.i;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.service.r;
import com.tencent.mm.plugin.appbrand.ui.recents.RecentsFolderActivityContext;
import com.tencent.mm.plugin.websearch.api.ai;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.WeChatEnvironment;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h.b;
import java.util.Locale;

@com.tencent.mm.kernel.k
public final class AppBrandLauncherUI
  extends MMActivity
  implements com.tencent.mm.plugin.appbrand.ui.launcher.a
{
  public static int qVi;
  public static final int qVj;
  private int enterScene;
  private int qVk = -1;
  private boolean qVl;
  private RecentsFolderActivityContext qVm;
  private boolean qVn = false;
  public t.d qVo;
  
  static
  {
    AppMethodBeat.i(48653);
    qVi = MMApplicationContext.getContext().getResources().getColor(au.c.normal_actionbar_color);
    qVj = ag.nym;
    AppMethodBeat.o(48653);
  }
  
  private AppBrandLauncherUI.Fragment cjD()
  {
    AppMethodBeat.i(48638);
    Object localObject = super.getSupportFragmentManager().findFragmentById(16908290);
    if ((localObject == null) || (!(localObject instanceof AppBrandLauncherUI.Fragment)))
    {
      AppMethodBeat.o(48638);
      return null;
    }
    localObject = (AppBrandLauncherUI.Fragment)localObject;
    AppMethodBeat.o(48638);
    return localObject;
  }
  
  private void cjE()
  {
    AppMethodBeat.i(180388);
    AppBrandStatObject localAppBrandStatObject = new AppBrandStatObject();
    localAppBrandStatObject.scene = 1112;
    finish();
    overridePendingTransition(0, 0);
    com.tencent.mm.plugin.appbrand.api.g localg = new com.tencent.mm.plugin.appbrand.api.g();
    String str;
    if (com.tencent.mm.protocal.d.RAD >= 654314752)
    {
      localg.nBr = new com.tencent.mm.plugin.appbrand.ui.recommend.k();
      Log.i("MicroMsg.AppBrandLauncherUI", "openFakeNativeRecommendUI, wechatNativeExtraData=%s", new Object[] { localg.nBr.bFa() });
      localObject = g.qVy;
      str = g.cjH();
      if (!"wxb6d22f922f37b35a".equals(str)) {
        break label199;
      }
    }
    label199:
    for (Object localObject = "gh_b489f391e008@app";; localObject = "gh_9bd4ec2ab601@app")
    {
      localg.username = ((String)localObject);
      localg.appId = str;
      localg.cBU = 0;
      localg.version = 0;
      localg.scene = localAppBrandStatObject.scene;
      ((r)com.tencent.mm.kernel.h.ae(r.class)).a(MMApplicationContext.getContext(), localg);
      this.qVn = true;
      AppMethodBeat.o(180388);
      return;
      localObject = String.format("?showOrderEntrance=%d", new Object[] { Integer.valueOf(1) });
      localg.nBq = ((String)localObject);
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
  
  public final void jE(boolean paramBoolean)
  {
    AppMethodBeat.i(48637);
    if (this.qVm != null) {
      this.qVm.jE(paramBoolean);
    }
    if ((paramBoolean) && (this.qVo != null)) {
      this.qVo.nPz[4] = "1";
    }
    AppMethodBeat.o(48637);
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(48646);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    this.qVk = paramInt1;
    if ((paramInt2 == -1) && (paramInt1 == 1))
    {
      String str = paramIntent.getStringExtra("key_session_id");
      paramInt1 = paramIntent.getIntExtra("ftsbizscene", 0);
      Log.i("MicroMsg.AppBrandLauncherUI", "onActivityResult oreh report weAppSearchClickStream(13929) statSessionId:%s, StatKeyWordId:%s", new Object[] { str, com.tencent.mm.modelappbrand.b.lyp });
      com.tencent.mm.plugin.report.service.h.IzE.a(13929, new Object[] { str, com.tencent.mm.modelappbrand.b.lyp, Integer.valueOf(2), Integer.valueOf(paramInt1) });
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
    if (!com.tencent.mm.plugin.appbrand.appusage.i.bIZ())
    {
      finish();
      AppMethodBeat.o(48641);
      return;
    }
    paramBundle = getLifecycle();
    Object localObject = com.tencent.mm.plugin.appbrand.report.f.qJg;
    paramBundle.a(com.tencent.mm.plugin.appbrand.report.f.b(this));
    this.enterScene = getIntent().getIntExtra("extra_enter_scene", -1);
    boolean bool2 = getIntent().getBooleanExtra("extra_show_recents_from_task_bar", false);
    Log.i("MicroMsg.AppBrandLauncherUI", "onCreate showRecentsListTagOnTop:%b", new Object[] { Boolean.valueOf(bool2) });
    paramBundle = g.qVy;
    if ((g.aal().getBoolean("KEY_FORCE_WE_USE_FAKE_NATIVE", false)) && (!bool2))
    {
      Log.i("MicroMsg.AppBrandLauncherUI", "onCreate isForceOpenWeUseFakeNative=TRUE");
      cjE();
      AppMethodBeat.o(48641);
      return;
    }
    paramBundle = g.qVy;
    boolean bool3 = g.aal().getBoolean("KEY_FORCE_NATIVE_LAUNCHER", false);
    this.qVl = getIntent().getBooleanExtra("extra_show_recommend", false);
    if (((Integer)com.tencent.mm.kernel.h.aHG().aHp().get(ar.a.Vmo, Integer.valueOf(0))).intValue() == 1) {}
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
          localFragment.cjF();
          AppMethodBeat.o(48623);
        }
      });
      setMMTitle(getResources().getString(au.i.app_brand_entrance));
      setBackBtn(new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(48624);
          AppBrandLauncherUI.this.onBackPressed();
          AppMethodBeat.o(48624);
          return true;
        }
      }, au.h.actionbar_icon_dark_back);
      if (com.tencent.mm.plugin.appbrand.y.a.ciz()) {
        addIconOptionMenu(AppBrandLauncherUI.a.qVu.ordinal(), au.i.top_item_desc_search, au.h.actionbar_icon_dark_search, new MenuItem.OnMenuItemClickListener()new View.OnLongClickListener
        {
          public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
          {
            AppMethodBeat.i(48626);
            ((com.tencent.mm.plugin.websearch.api.i)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.websearch.api.i.class)).a(MMApplicationContext.getContext(), new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(48625);
                if (AppBrandLauncherUI.b(AppBrandLauncherUI.this) == 13) {}
                for (int i = 52;; i = 201)
                {
                  AppBrandLauncherUI localAppBrandLauncherUI = AppBrandLauncherUI.this;
                  com.tencent.mm.plugin.appbrand.c.a locala = com.tencent.mm.plugin.appbrand.c.a.nVA;
                  localAppBrandLauncherUI.startActivityForResult(com.tencent.mm.plugin.appbrand.c.a.P(AppBrandLauncherUI.this, i), 1);
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
            localb.bn(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/appbrand/ui/AppBrandLauncherUI$4", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, localb.aFi());
            if (WeChatEnvironment.hasDebugger())
            {
              paramAnonymousView = AppBrandLauncherUI.this;
              com.tencent.mm.ui.base.h.a(paramAnonymousView, paramAnonymousView.getResources().getString(au.i.appbrand_debugger_search_by_appid_title), "", "", 2147483647, new h.b()
              {
                public final boolean onFinish(CharSequence paramAnonymous2CharSequence)
                {
                  AppMethodBeat.i(48627);
                  if (!TextUtils.isEmpty(paramAnonymous2CharSequence))
                  {
                    paramAnonymous2CharSequence = paramAnonymous2CharSequence.toString();
                    AppBrandStatObject localAppBrandStatObject = new AppBrandStatObject();
                    localAppBrandStatObject.scene = 1001;
                    com.tencent.mm.plugin.appbrand.launching.e.f.pZN.a(paramAnonymousView, "", paramAnonymous2CharSequence, null, 0, 0, localAppBrandStatObject, null, null);
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
      qVi = getContext().getResources().getColor(au.c.normal_actionbar_color);
      setActionbarColor(qVi);
      findViewById(16908290).setBackgroundColor(qVi);
      Log.i("MicroMsg.AppBrandLauncherUI", "mShowRecommend:%b, recommendDataState:%b, isForceOpenNativeLauncherUI:%b", new Object[] { Boolean.valueOf(this.qVl), Boolean.valueOf(bool1), Boolean.valueOf(bool3) });
      if ((!this.qVl) || (!bool1) || (bool3) || (bool2)) {
        break;
      }
      cjE();
      AppMethodBeat.o(48641);
      return;
    }
    paramBundle = getLifecycle();
    localObject = new RecentsFolderActivityContext(this);
    this.qVm = ((RecentsFolderActivityContext)localObject);
    paramBundle.a((androidx.lifecycle.k)localObject);
    com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(465L, 0L, 1L, false);
    if (!com.tencent.mm.plugin.appbrand.y.a.ciz())
    {
      Log.i("MicroMsg.AppBrandSearchLogic", "do not need to update search input hint, shouldShowSearchEntrance is false");
      com.tencent.mm.xwebutil.c.ikh();
      if (com.tencent.mm.plugin.appbrand.appusage.t.bJs()) {
        this.qVo = new t.d();
      }
      com.tencent.mm.plugin.appbrand.appusage.t.bJu();
      com.tencent.mm.plugin.appbrand.appusage.i.bJa();
      AppMethodBeat.o(48641);
      return;
    }
    long l2 = System.currentTimeMillis();
    paramBundle = com.tencent.mm.kernel.h.aHG().aHp().get(ar.a.Vop, null);
    if ((paramBundle != null) && ((paramBundle instanceof Long))) {}
    for (long l1 = ((Long)paramBundle).longValue();; l1 = 0L)
    {
      paramBundle = Locale.getDefault().getLanguage();
      localObject = com.tencent.mm.kernel.h.aHG().aHp().get(ar.a.Vok, null);
      if ((l2 - l1 >= 3600000L) || (localObject == null) || (!localObject.equals(paramBundle))) {
        com.tencent.mm.kernel.h.aHF().kcd.a(new com.tencent.mm.plugin.appbrand.r.b(), 0);
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
    if (this.qVo != null)
    {
      t.d locald = this.qVo;
      com.tencent.mm.plugin.report.service.h.IzE.a(14113, (Object[])locald.nPz);
      this.qVo = null;
    }
    com.tencent.mm.kiss.a.b.aIL();
    AppMethodBeat.o(48645);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(48643);
    int i;
    if (this.qVk > 0)
    {
      if (this.qVk != 1) {
        break label66;
      }
      i = 7;
    }
    for (;;)
    {
      this.qVk = 0;
      AppBrandLauncherUI.Fragment localFragment = (AppBrandLauncherUI.Fragment)super.getSupportFragmentManager().findFragmentById(16908290);
      if (localFragment != null) {
        localFragment.setScene(i);
      }
      super.onResume();
      ai.Tv(0L);
      AppMethodBeat.o(48643);
      return;
      label66:
      if (this.qVk == 2) {
        i = 6;
      } else if (this.qVk == 3) {
        i = 9;
      } else if (this.qVk == 4) {
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
    if (this.qVn)
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
    paramBundle = cjD();
    if (paramBundle != null) {
      paramBundle.a(paramIntent, paramInt);
    }
    AppMethodBeat.o(48650);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.AppBrandLauncherUI
 * JD-Core Version:    0.7.0.1
 */