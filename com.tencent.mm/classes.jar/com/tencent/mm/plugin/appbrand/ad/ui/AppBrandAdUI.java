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
import com.tencent.mm.plugin.appbrand.ad.a.f;
import com.tencent.mm.plugin.appbrand.ad.e.1;
import com.tencent.mm.plugin.appbrand.ad.e.a;
import com.tencent.mm.plugin.appbrand.g;
import com.tencent.mm.plugin.appbrand.g.d;
import com.tencent.mm.plugin.appbrand.page.aa;
import com.tencent.mm.plugin.appbrand.page.ae;
import com.tencent.mm.plugin.appbrand.page.u;
import com.tencent.mm.plugin.appbrand.q;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.MMBaseActivity;
import com.tencent.mm.ui.al;
import java.util.List;

public class AppBrandAdUI
  extends MMBaseActivity
{
  private FrameLayout jCD;
  private a jCE;
  private com.tencent.mm.sdk.b.c<b> jCF;
  private AppBrandRuntime jCe;
  private com.tencent.mm.plugin.appbrand.ad.e jCn;
  
  public AppBrandAdUI()
  {
    AppMethodBeat.i(44058);
    this.jCF = new com.tencent.mm.sdk.b.c() {};
    AppMethodBeat.o(44058);
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
      com.tencent.mm.ui.statusbar.d.b(getWindow());
      com.tencent.mm.ui.statusbar.d.c(getWindow(), true);
      this.jCD = new FrameLayout(this);
      this.jCD.setBackgroundColor(0);
      setContentView(this.jCD);
      paramBundle = getIntent().getStringExtra("appId");
      if (!bt.isNullOrNil(paramBundle)) {
        break;
      }
      ad.e("MicroMsg.AppBrandAdUI[AppBrandSplashAd]", "onCreate, appId is null");
      finish();
      AppMethodBeat.o(44060);
      return;
      paramBundle.setSystemUiVisibility(1280);
    }
    this.jCe = com.tencent.mm.plugin.appbrand.a.Kj(paramBundle);
    if ((this.jCe == null) || (this.jCe.isDestroyed()))
    {
      ad.e("MicroMsg.AppBrandAdUI[AppBrandSplashAd]", "onCreate, runtime is null");
      finish();
      AppMethodBeat.o(44060);
      return;
    }
    if (this.jCe.Ew() != null) {
      this.jCe.Ew().aXE();
    }
    this.jCn = new com.tencent.mm.plugin.appbrand.ad.e(this, this.jCe);
    this.jCe.jwL = this.jCn;
    this.jCn.aYd();
    this.jCn.setActionBarFullscreenMode(true);
    paramBundle = this.jCn;
    if (paramBundle.jCh != null) {
      paramBundle.jCh.hW(true);
    }
    this.jCn.aYe();
    paramBundle = this.jCn;
    if (paramBundle.jCh != null) {
      paramBundle.jCh.hX(true);
    }
    this.jCn.setTitle(getResources().getString(2131755307));
    if (al.isDarkMode())
    {
      this.jCn.setBackgroundColor(-16777216);
      this.jCn.setForegroundStyle(false);
      this.jCn.setBackButtonClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(44053);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/appbrand/ad/ui/AppBrandAdUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
          if (AppBrandAdUI.a(AppBrandAdUI.this) != null)
          {
            paramAnonymousView = new com.tencent.mm.plugin.appbrand.ad.a.b();
            paramAnonymousView.source = "menu";
            paramAnonymousView.type = "back";
            paramAnonymousView.c(AppBrandAdUI.a(AppBrandAdUI.this).Ew());
          }
          AppBrandAdUI.this.finish();
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/ad/ui/AppBrandAdUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(44053);
        }
      });
      this.jCn.setCloseButtonClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(44054);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/appbrand/ad/ui/AppBrandAdUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
          if (AppBrandAdUI.a(AppBrandAdUI.this) != null)
          {
            paramAnonymousView = new com.tencent.mm.plugin.appbrand.ad.a.b();
            paramAnonymousView.source = "menu";
            paramAnonymousView.type = "close";
            paramAnonymousView.c(AppBrandAdUI.a(AppBrandAdUI.this).Ew());
            g.a(AppBrandAdUI.a(AppBrandAdUI.this).mAppId, g.d.jwl);
            AppBrandAdUI.a(AppBrandAdUI.this).close();
            paramAnonymousView = new com.tencent.mm.plugin.appbrand.ad.a.c();
            paramAnonymousView.source = "menu";
            paramAnonymousView.c(AppBrandAdUI.a(AppBrandAdUI.this).Ew());
          }
          AppBrandAdUI.this.finish();
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/ad/ui/AppBrandAdUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(44054);
        }
      });
      this.jCn.setOptionButtonClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(44055);
          Object localObject = new com.tencent.mm.hellhoundlib.b.b();
          ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/appbrand/ad/ui/AppBrandAdUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahq());
          if ((AppBrandAdUI.a(AppBrandAdUI.this) != null) && (AppBrandAdUI.a(AppBrandAdUI.this).aVN() != null) && (AppBrandAdUI.a(AppBrandAdUI.this).aVN().getPageView() != null))
          {
            paramAnonymousView = AppBrandAdUI.a(AppBrandAdUI.this).aVN().getPageView();
            localObject = paramAnonymousView.buw();
            if ((localObject != null) && (!((List)localObject).isEmpty()) && ((paramAnonymousView instanceof ae)))
            {
              AppBrandAdUI.a(AppBrandAdUI.this, new a(AppBrandAdUI.this, paramAnonymousView, (List)localObject));
              AppBrandAdUI.b(AppBrandAdUI.this).aYr();
            }
          }
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/ad/ui/AppBrandAdUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(44055);
        }
      });
      this.jCn.setOnHideListener(new e.a()
      {
        public final void KS(String paramAnonymousString)
        {
          AppMethodBeat.i(44056);
          if ((AppBrandAdUI.a(AppBrandAdUI.this) != null) && ("menu".equalsIgnoreCase(paramAnonymousString)))
          {
            Object localObject = new com.tencent.mm.plugin.appbrand.ad.a.d();
            ((com.tencent.mm.plugin.appbrand.ad.a.d)localObject).source = paramAnonymousString;
            ((com.tencent.mm.plugin.appbrand.ad.a.d)localObject).c(AppBrandAdUI.a(AppBrandAdUI.this).Ew());
            localObject = new com.tencent.mm.plugin.appbrand.ad.a.c();
            ((com.tencent.mm.plugin.appbrand.ad.a.c)localObject).source = paramAnonymousString;
            ((com.tencent.mm.plugin.appbrand.ad.a.c)localObject).c(AppBrandAdUI.a(AppBrandAdUI.this).Ew());
          }
          AppMethodBeat.o(44056);
        }
      });
      paramBundle = this.jCn;
      if (!aq.isMainThread()) {
        break label475;
      }
      paramBundle.aYf();
    }
    for (;;)
    {
      this.jCD.addView(this.jCn, new ViewGroup.LayoutParams(-1, -1));
      this.jCF.alive();
      paramBundle = new f();
      paramBundle.source = "menu";
      paramBundle.a(this.jCe.Ew(), this);
      AppMethodBeat.o(44060);
      return;
      this.jCn.setBackgroundColor(-1);
      this.jCn.setForegroundStyle(true);
      break;
      label475:
      aq.f(new e.1(paramBundle));
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(44063);
    super.onDestroy();
    ad.i("MicroMsg.AppBrandAdUI[AppBrandSplashAd]", "onDestroy");
    if (this.jCF != null)
    {
      this.jCF.dead();
      this.jCF = null;
    }
    if (this.jCE != null) {
      this.jCE.aYs();
    }
    if (this.jCn != null)
    {
      this.jCn.j(false, "menu");
      if ((this.jCn.getParent() instanceof ViewGroup)) {
        ((ViewGroup)this.jCn.getParent()).removeView(this.jCn);
      }
      this.jCn = null;
    }
    if (this.jCe != null)
    {
      this.jCe.jwL = null;
      if (this.jCe.Ew() != null) {
        this.jCe.Ew().aXE();
      }
    }
    AppMethodBeat.o(44063);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(44062);
    super.onPause();
    ad.i("MicroMsg.AppBrandAdUI[AppBrandSplashAd]", "onPause");
    if (this.jCE != null) {
      this.jCE.aYs();
    }
    if (this.jCe != null)
    {
      com.tencent.mm.plugin.appbrand.ad.a.d locald = new com.tencent.mm.plugin.appbrand.ad.a.d();
      locald.source = "menu";
      locald.c(this.jCe.Ew());
    }
    AppMethodBeat.o(44062);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(44061);
    super.onResume();
    ad.i("MicroMsg.AppBrandAdUI[AppBrandSplashAd]", "onResume");
    if (this.jCe != null)
    {
      com.tencent.mm.plugin.appbrand.ad.a.e locale = new com.tencent.mm.plugin.appbrand.ad.a.e();
      locale.source = "menu";
      locale.c(this.jCe.Ew());
    }
    AppMethodBeat.o(44061);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ad.ui.AppBrandAdUI
 * JD-Core Version:    0.7.0.1
 */