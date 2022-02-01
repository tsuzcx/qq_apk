package com.tencent.mm.plugin.appbrand.ad.ui;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.ad.f.1;
import com.tencent.mm.plugin.appbrand.ad.f.a;
import com.tencent.mm.plugin.appbrand.au.i;
import com.tencent.mm.plugin.appbrand.b.b;
import com.tencent.mm.plugin.appbrand.k;
import com.tencent.mm.plugin.appbrand.k.d;
import com.tencent.mm.plugin.appbrand.page.ad;
import com.tencent.mm.plugin.appbrand.page.y;
import com.tencent.mm.plugin.appbrand.t;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMBaseActivity;
import com.tencent.mm.ui.MMFragmentActivity.a;
import com.tencent.mm.ui.ar;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public class AppBrandAdUI
  extends MMBaseActivity
{
  private com.tencent.mm.plugin.appbrand.ad.f nAC;
  private t nAH;
  private FrameLayout nBf;
  private a nBg;
  private IListener<b> nBh;
  
  public AppBrandAdUI()
  {
    AppMethodBeat.i(44058);
    this.nBh = new IListener() {};
    AppMethodBeat.o(44058);
  }
  
  public void onBackPressed()
  {
    AppMethodBeat.i(280524);
    super.onBackPressed();
    if (isFinishing()) {
      overridePendingTransition(MMFragmentActivity.a.ria, MMFragmentActivity.a.rib);
    }
    AppMethodBeat.o(280524);
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(44064);
    super.onConfigurationChanged(paramConfiguration);
    setRequestedOrientation(1);
    AppMethodBeat.o(44064);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(44060);
    setRequestedOrientation(1);
    super.onCreate(paramBundle);
    paramBundle = getWindow().getDecorView();
    paramBundle.requestApplyInsets();
    if (Build.VERSION.SDK_INT >= 26) {
      paramBundle.setSystemUiVisibility(1296);
    }
    for (;;)
    {
      com.tencent.mm.ui.statusbar.d.e(getWindow());
      com.tencent.mm.ui.statusbar.d.d(getWindow(), true);
      this.nBf = new FrameLayout(this);
      this.nBf.setBackgroundColor(0);
      setContentView(this.nBf);
      paramBundle = getIntent().getStringExtra("appId");
      if (!Util.isNullOrNil(paramBundle)) {
        break;
      }
      Log.e("MicroMsg.AppBrandAdUI[AppBrandSplashAd]", "onCreate, appId is null");
      finish();
      AppMethodBeat.o(44060);
      return;
      paramBundle.setSystemUiVisibility(1280);
    }
    this.nAH = com.tencent.mm.plugin.appbrand.d.abA(paramBundle);
    if ((this.nAH == null) || (this.nAH.ntU.get()))
    {
      Log.e("MicroMsg.AppBrandAdUI[AppBrandSplashAd]", "onCreate, runtime is null");
      finish();
      AppMethodBeat.o(44060);
      return;
    }
    if (this.nAH.bDA() != null) {
      this.nAH.bDA().bEU();
    }
    this.nAC = new com.tencent.mm.plugin.appbrand.ad.f(this, this.nAH);
    this.nAH.ntF = this.nAC;
    this.nAC.bEK();
    this.nAC.setActionBarFullscreenMode(true);
    paramBundle = this.nAC;
    if (paramBundle.nAw != null) {
      paramBundle.nAw.hi(true);
    }
    this.nAC.bEL();
    paramBundle = this.nAC;
    if (paramBundle.nAw != null) {
      paramBundle.nAw.hj(true);
    }
    this.nAC.setTitle(getResources().getString(au.i.app_brand_ad_title));
    if (ar.isDarkMode())
    {
      this.nAC.setBackgroundColor(-16777216);
      this.nAC.setForegroundStyle(false);
      this.nAC.setBackButtonClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(44053);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/appbrand/ad/ui/AppBrandAdUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
          if (AppBrandAdUI.a(AppBrandAdUI.this) != null)
          {
            paramAnonymousView = new com.tencent.mm.plugin.appbrand.ad.a.b();
            paramAnonymousView.source = "menu";
            paramAnonymousView.type = "back";
            paramAnonymousView.a(AppBrandAdUI.a(AppBrandAdUI.this).bDA());
          }
          AppBrandAdUI.this.finish();
          AppBrandAdUI.this.overridePendingTransition(MMFragmentActivity.a.ria, MMFragmentActivity.a.rib);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/ad/ui/AppBrandAdUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(44053);
        }
      });
      this.nAC.setCloseButtonClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(44054);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/appbrand/ad/ui/AppBrandAdUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
          if (AppBrandAdUI.a(AppBrandAdUI.this) != null)
          {
            paramAnonymousView = new com.tencent.mm.plugin.appbrand.ad.a.b();
            paramAnonymousView.source = "menu";
            paramAnonymousView.type = "close";
            paramAnonymousView.a(AppBrandAdUI.a(AppBrandAdUI.this).bDA());
            k.a(AppBrandAdUI.a(AppBrandAdUI.this).mAppId, k.d.ntb);
            AppBrandAdUI.a(AppBrandAdUI.this).close();
            paramAnonymousView = new com.tencent.mm.plugin.appbrand.ad.a.c();
            paramAnonymousView.source = "menu";
            paramAnonymousView.a(AppBrandAdUI.a(AppBrandAdUI.this).bDA());
          }
          AppBrandAdUI.this.finish();
          ((com.tencent.mm.plugin.appbrand.ui.ah)com.tencent.luggage.a.e.K(com.tencent.mm.plugin.appbrand.ui.ah.class)).k(AppBrandAdUI.this);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/ad/ui/AppBrandAdUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(44054);
        }
      });
      this.nAC.setOptionButtonClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(44055);
          Object localObject = new com.tencent.mm.hellhoundlib.b.b();
          ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/appbrand/ad/ui/AppBrandAdUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
          if ((AppBrandAdUI.a(AppBrandAdUI.this) != null) && (AppBrandAdUI.a(AppBrandAdUI.this).bDz() != null) && (AppBrandAdUI.a(AppBrandAdUI.this).bDz().getPageView() != null))
          {
            paramAnonymousView = AppBrandAdUI.a(AppBrandAdUI.this).bDz().getPageView();
            localObject = paramAnonymousView.cdX();
            if ((localObject != null) && (!((List)localObject).isEmpty()) && ((paramAnonymousView instanceof com.tencent.mm.plugin.appbrand.page.ah)))
            {
              AppBrandAdUI.a(AppBrandAdUI.this, new a(AppBrandAdUI.this, paramAnonymousView, (List)localObject));
              AppBrandAdUI.b(AppBrandAdUI.this).bEY();
            }
          }
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/ad/ui/AppBrandAdUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(44055);
        }
      });
      this.nAC.setOnHideListener(new f.a()
      {
        public final void acl(String paramAnonymousString)
        {
          AppMethodBeat.i(44056);
          if ((AppBrandAdUI.a(AppBrandAdUI.this) != null) && ("menu".equalsIgnoreCase(paramAnonymousString)))
          {
            Object localObject = new com.tencent.mm.plugin.appbrand.ad.a.d();
            ((com.tencent.mm.plugin.appbrand.ad.a.d)localObject).source = paramAnonymousString;
            ((com.tencent.mm.plugin.appbrand.ad.a.d)localObject).a(AppBrandAdUI.a(AppBrandAdUI.this).bDA());
            localObject = new com.tencent.mm.plugin.appbrand.ad.a.c();
            ((com.tencent.mm.plugin.appbrand.ad.a.c)localObject).source = paramAnonymousString;
            ((com.tencent.mm.plugin.appbrand.ad.a.c)localObject).a(AppBrandAdUI.a(AppBrandAdUI.this).bDA());
          }
          AppMethodBeat.o(44056);
        }
      });
      paramBundle = this.nAC;
      if (!MMHandlerThread.isMainThread()) {
        break label481;
      }
      paramBundle.bEM();
    }
    for (;;)
    {
      this.nBf.addView(this.nAC, new ViewGroup.LayoutParams(-1, -1));
      this.nBh.alive();
      this.nAH.nwF.a(new b.b()
      {
        public final void a(com.tencent.mm.plugin.appbrand.m.o paramAnonymouso, kotlin.o<Long, Long> paramAnonymouso1)
        {
          AppMethodBeat.i(283332);
          if (paramAnonymouso == null)
          {
            AppMethodBeat.o(283332);
            return;
          }
          paramAnonymouso1 = new com.tencent.mm.plugin.appbrand.ad.a.f();
          paramAnonymouso1.source = "menu";
          paramAnonymouso1.a(AppBrandAdUI.a(AppBrandAdUI.this).bDA(), AppBrandAdUI.this, paramAnonymouso);
          AppMethodBeat.o(283332);
        }
      });
      overridePendingTransition(MMFragmentActivity.a.rhY, MMFragmentActivity.a.rhZ);
      AppMethodBeat.o(44060);
      return;
      this.nAC.setBackgroundColor(-1);
      this.nAC.setForegroundStyle(true);
      break;
      label481:
      MMHandlerThread.postToMainThread(new f.1(paramBundle));
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(44063);
    super.onDestroy();
    Log.i("MicroMsg.AppBrandAdUI[AppBrandSplashAd]", "onDestroy");
    if (this.nBh != null)
    {
      this.nBh.dead();
      this.nBh = null;
    }
    if (this.nBg != null) {
      this.nBg.bEZ();
    }
    if (this.nAC != null)
    {
      this.nAC.o(false, "menu");
      if ((this.nAC.getParent() instanceof ViewGroup)) {
        ((ViewGroup)this.nAC.getParent()).removeView(this.nAC);
      }
      this.nAC = null;
    }
    if (this.nAH != null)
    {
      this.nAH.ntF = null;
      if (this.nAH.bDA() != null) {
        this.nAH.bDA().bEU();
      }
    }
    AppMethodBeat.o(44063);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(44062);
    super.onPause();
    Log.i("MicroMsg.AppBrandAdUI[AppBrandSplashAd]", "onPause");
    if (this.nBg != null) {
      this.nBg.bEZ();
    }
    if (this.nAH != null)
    {
      com.tencent.mm.plugin.appbrand.ad.a.d locald = new com.tencent.mm.plugin.appbrand.ad.a.d();
      locald.source = "menu";
      locald.a(this.nAH.bDA());
    }
    AppMethodBeat.o(44062);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(44061);
    super.onResume();
    Log.i("MicroMsg.AppBrandAdUI[AppBrandSplashAd]", "onResume");
    if (this.nAH != null)
    {
      com.tencent.mm.plugin.appbrand.ad.a.e locale = new com.tencent.mm.plugin.appbrand.ad.a.e();
      locale.source = "menu";
      locale.a(this.nAH.bDA());
    }
    AppMethodBeat.o(44061);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ad.ui.AppBrandAdUI
 * JD-Core Version:    0.7.0.1
 */