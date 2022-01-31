package com.tencent.mm.plugin.appbrand.ui;

import android.app.Activity;
import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.LifecycleObserver;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.k;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnLongClickListener;
import android.view.Window;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.p;
import com.tencent.mm.cn.d;
import com.tencent.mm.kernel.e;
import com.tencent.mm.plugin.appbrand.appusage.q;
import com.tencent.mm.plugin.appbrand.appusage.r;
import com.tencent.mm.plugin.appbrand.appusage.r.d;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.service.j;
import com.tencent.mm.plugin.appbrand.ui.recents.RecentsFolderActivityContext;
import com.tencent.mm.plugin.appbrand.ui.recommend.AppBrandLauncherRecommendList;
import com.tencent.mm.plugin.appbrand.ui.recommend.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bp;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMFragmentActivity.a;
import java.util.Locale;

@com.tencent.mm.kernel.i
public final class AppBrandLauncherUI
  extends MMActivity
  implements com.tencent.mm.plugin.appbrand.ui.launcher.a
{
  public static final int iMF = com.tencent.mm.plugin.appbrand.aa.gSb;
  private int cxS;
  private int iMG = -1;
  private boolean iMH;
  private RecentsFolderActivityContext iMI;
  private boolean iMJ = false;
  public r.d iMK;
  
  public final boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(132980);
    if (isFinishing())
    {
      AppMethodBeat.o(132980);
      return false;
    }
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    AppMethodBeat.o(132980);
    return bool;
  }
  
  public final void eP(boolean paramBoolean)
  {
    AppMethodBeat.i(132977);
    if (this.iMI != null) {
      this.iMI.eP(paramBoolean);
    }
    if ((paramBoolean) && (this.iMK != null)) {
      this.iMK.hca[4] = "1";
    }
    AppMethodBeat.o(132977);
  }
  
  public final int getLayoutId()
  {
    return -1;
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(132983);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    this.iMG = paramInt1;
    if ((paramInt2 == -1) && (paramInt1 == 1))
    {
      String str = paramIntent.getStringExtra("key_session_id");
      paramInt1 = paramIntent.getIntExtra("ftsbizscene", 0);
      ab.i("MicroMsg.AppBrandLauncherUI", "onActivityResult oreh report weAppSearchClickStream(13929) statSessionId:%s, StatKeyWordId:%s", new Object[] { str, com.tencent.mm.modelappbrand.b.fpR });
      com.tencent.mm.plugin.report.service.h.qsU.e(13929, new Object[] { str, com.tencent.mm.modelappbrand.b.fpR, Integer.valueOf(2), Integer.valueOf(paramInt1) });
    }
    AppMethodBeat.o(132983);
  }
  
  public final void onBackPressed()
  {
    AppMethodBeat.i(132986);
    finish();
    AppMethodBeat.o(132986);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(132979);
    super.onCreate(paramBundle);
    if (getIntent() == null)
    {
      finish();
      AppMethodBeat.o(132979);
      return;
    }
    if (!com.tencent.mm.plugin.appbrand.appusage.i.awU())
    {
      finish();
      AppMethodBeat.o(132979);
      return;
    }
    this.cxS = getIntent().getIntExtra("extra_enter_scene", -1);
    overridePendingTransition(MMFragmentActivity.a.zbX, MMFragmentActivity.a.zbY);
    this.iMH = getIntent().getBooleanExtra("extra_show_recommend", false);
    boolean bool1 = getIntent().getBooleanExtra("extra_show_recents_from_task_bar", false);
    boolean bool2 = c.aNB();
    setTitleBarDoubleClickListener(new AppBrandLauncherUI.1(this));
    setMMTitle(getResources().getString(2131296630));
    setBackBtn(new AppBrandLauncherUI.2(this), 2131230737);
    if (com.tencent.mm.plugin.appbrand.p.a.aLv()) {
      addIconOptionMenu(a.iMR.ordinal(), 2131304318, 2131230741, new AppBrandLauncherUI.3(this), new View.OnLongClickListener()
      {
        public final boolean onLongClick(View paramAnonymousView)
        {
          AppMethodBeat.i(143589);
          if (bp.dud())
          {
            paramAnonymousView = AppBrandLauncherUI.this;
            com.tencent.mm.ui.base.h.a(paramAnonymousView, paramAnonymousView.getResources().getString(2131306126), "", "", 2147483647, new AppBrandLauncherUI.4.1(this, paramAnonymousView));
            AppMethodBeat.o(143589);
            return true;
          }
          AppMethodBeat.o(143589);
          return false;
        }
      });
    }
    setActionbarColor(-855310);
    findViewById(16908290).setBackgroundColor(-855310);
    ab.i("MicroMsg.AppBrandLauncherUI", "mShowRecommend:%b, recommendDataState:%b", new Object[] { Boolean.valueOf(this.iMH), Boolean.valueOf(bool2) });
    if ((this.iMH) && (bool2) && (!bool1))
    {
      if (c.aNC())
      {
        paramBundle = new AppBrandStatObject();
        paramBundle.scene = 1112;
        finish();
        overridePendingTransition(0, 0);
        ((j)com.tencent.mm.kernel.g.E(j.class)).a(ah.getContext(), "gh_b489f391e008@app", "wxb6d22f922f37b35a", 0, 0, null, paramBundle);
        this.iMJ = true;
        AppMethodBeat.o(132979);
        return;
      }
      getSupportFragmentManager().beginTransaction().b(16908290, new AppBrandLauncherRecommendList()).commit();
    }
    Object localObject;
    for (;;)
    {
      com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(465L, 0L, 1L, false);
      if (com.tencent.mm.plugin.appbrand.p.a.aLv()) {
        break;
      }
      ab.i("MicroMsg.AppBrandSearchLogic", "do not need to update search input hint, shouldShowSearchEntrance is false");
      d.aNX();
      if (r.axo()) {
        this.iMK = new r.d();
      }
      r.axq();
      com.tencent.mm.plugin.appbrand.appusage.i.awV();
      AppMethodBeat.o(132979);
      return;
      paramBundle = getLifecycle();
      localObject = new RecentsFolderActivityContext(this);
      this.iMI = ((RecentsFolderActivityContext)localObject);
      paramBundle.addObserver((LifecycleObserver)localObject);
    }
    long l2 = System.currentTimeMillis();
    paramBundle = com.tencent.mm.kernel.g.RL().Ru().get(ac.a.yEX, null);
    if ((paramBundle != null) && ((paramBundle instanceof Long))) {}
    for (long l1 = ((Long)paramBundle).longValue();; l1 = 0L)
    {
      paramBundle = Locale.getDefault().getLanguage();
      localObject = com.tencent.mm.kernel.g.RL().Ru().get(ac.a.yEU, null);
      if ((l2 - l1 >= 3600000L) || (localObject == null) || (!localObject.equals(paramBundle))) {
        com.tencent.mm.kernel.g.RK().eHt.a(new com.tencent.mm.plugin.appbrand.l.b(), 0);
      }
      ab.v("MicroMsg.AppBrandSearchLogic", "tryToUpdateSearchInputHint, lang(o : %s, c : %s), lastUpdateTime(o : %s, c : %s)", new Object[] { localObject, paramBundle, Long.valueOf(l1), Long.valueOf(l2) });
      break;
    }
  }
  
  public final void onCreateBeforeSetContentView()
  {
    AppMethodBeat.i(132978);
    super.onCreateBeforeSetContentView();
    getWindow().setSoftInputMode(3);
    AppMethodBeat.o(132978);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(132982);
    super.onDestroy();
    q.clearData();
    if (this.iMK != null)
    {
      r.d locald = this.iMK;
      com.tencent.mm.plugin.report.service.h.qsU.e(14113, (Object[])locald.hca);
      this.iMK = null;
    }
    com.tencent.mm.kiss.a.b.SI();
    AppMethodBeat.o(132982);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(132981);
    int i;
    if (this.iMG > 0)
    {
      if (this.iMG != 1) {
        break label74;
      }
      i = 7;
    }
    for (;;)
    {
      this.iMG = 0;
      Object localObject = (AppBrandLauncherUI.Fragment)super.getSupportFragmentManager().findFragmentById(16908290);
      if (localObject != null) {
        ((AppBrandLauncherUI.Fragment)localObject).setScene(i);
      }
      super.onResume();
      localObject = com.tencent.mm.modelappbrand.b.ach();
      com.tencent.mm.plugin.websearch.api.aa.agr((String)localObject);
      com.tencent.mm.plugin.websearch.api.aa.ags((String)localObject);
      AppMethodBeat.o(132981);
      return;
      label74:
      if (this.iMG == 2) {
        i = 6;
      } else if (this.iMG == 3) {
        i = 9;
      } else if (this.iMG == 4) {
        i = 12;
      } else {
        i = 4;
      }
    }
  }
  
  public final void onStop()
  {
    AppMethodBeat.i(143590);
    super.onStop();
    if (this.iMJ)
    {
      finish();
      overridePendingTransition(0, 0);
    }
    AppMethodBeat.o(143590);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public final void setTitle(int paramInt)
  {
    AppMethodBeat.i(132985);
    setMMTitle(paramInt);
    AppMethodBeat.o(132985);
  }
  
  public final void setTitle(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(132984);
    setMMTitle(paramCharSequence);
    AppMethodBeat.o(132984);
  }
  
  static enum a
  {
    static
    {
      AppMethodBeat.i(132976);
      iMR = new a("WebSearch", 0);
      iMS = new a("StarList", 1);
      iMT = new a[] { iMR, iMS };
      AppMethodBeat.o(132976);
    }
    
    private a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.AppBrandLauncherUI
 * JD-Core Version:    0.7.0.1
 */