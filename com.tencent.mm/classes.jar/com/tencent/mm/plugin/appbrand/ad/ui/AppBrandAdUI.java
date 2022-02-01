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
import com.tencent.mm.plugin.appbrand.ad.a.e;
import com.tencent.mm.plugin.appbrand.ad.f.1;
import com.tencent.mm.plugin.appbrand.ad.f.a;
import com.tencent.mm.plugin.appbrand.h;
import com.tencent.mm.plugin.appbrand.h.d;
import com.tencent.mm.plugin.appbrand.page.ad;
import com.tencent.mm.plugin.appbrand.page.t;
import com.tencent.mm.plugin.appbrand.page.z;
import com.tencent.mm.plugin.appbrand.r;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.ui.MMBaseActivity;
import com.tencent.mm.ui.al;
import java.util.List;

public class AppBrandAdUI
  extends MMBaseActivity
{
  private FrameLayout jFB;
  private a jFC;
  private com.tencent.mm.sdk.b.c<b> jFD;
  private AppBrandRuntime jFc;
  private com.tencent.mm.plugin.appbrand.ad.f jFl;
  
  public AppBrandAdUI()
  {
    AppMethodBeat.i(44058);
    this.jFD = new com.tencent.mm.sdk.b.c() {};
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
      this.jFB = new FrameLayout(this);
      this.jFB.setBackgroundColor(0);
      setContentView(this.jFB);
      paramBundle = getIntent().getStringExtra("appId");
      if (!bu.isNullOrNil(paramBundle)) {
        break;
      }
      ae.e("MicroMsg.AppBrandAdUI[AppBrandSplashAd]", "onCreate, appId is null");
      finish();
      AppMethodBeat.o(44060);
      return;
      paramBundle.setSystemUiVisibility(1280);
    }
    this.jFc = com.tencent.mm.plugin.appbrand.a.KI(paramBundle);
    if ((this.jFc == null) || (this.jFc.isDestroyed()))
    {
      ae.e("MicroMsg.AppBrandAdUI[AppBrandSplashAd]", "onCreate, runtime is null");
      finish();
      AppMethodBeat.o(44060);
      return;
    }
    if (this.jFc.Ey() != null) {
      this.jFc.Ey().aXZ();
    }
    this.jFl = new com.tencent.mm.plugin.appbrand.ad.f(this, this.jFc);
    this.jFc.jzI = this.jFl;
    this.jFl.aYx();
    this.jFl.setActionBarFullscreenMode(true);
    paramBundle = this.jFl;
    if (paramBundle.jFf != null) {
      paramBundle.jFf.fC(true);
    }
    this.jFl.aYy();
    paramBundle = this.jFl;
    if (paramBundle.jFf != null) {
      paramBundle.jFf.fD(true);
    }
    this.jFl.setTitle(getResources().getString(2131755307));
    if (al.isDarkMode())
    {
      this.jFl.setBackgroundColor(-16777216);
      this.jFl.setForegroundStyle(false);
      this.jFl.setBackButtonClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(44053);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/appbrand/ad/ui/AppBrandAdUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
          if (AppBrandAdUI.a(AppBrandAdUI.this) != null)
          {
            paramAnonymousView = new com.tencent.mm.plugin.appbrand.ad.a.b();
            paramAnonymousView.source = "menu";
            paramAnonymousView.type = "back";
            paramAnonymousView.c(AppBrandAdUI.a(AppBrandAdUI.this).Ey());
          }
          AppBrandAdUI.this.finish();
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/ad/ui/AppBrandAdUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(44053);
        }
      });
      this.jFl.setCloseButtonClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(44054);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/appbrand/ad/ui/AppBrandAdUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
          if (AppBrandAdUI.a(AppBrandAdUI.this) != null)
          {
            paramAnonymousView = new com.tencent.mm.plugin.appbrand.ad.a.b();
            paramAnonymousView.source = "menu";
            paramAnonymousView.type = "close";
            paramAnonymousView.c(AppBrandAdUI.a(AppBrandAdUI.this).Ey());
            h.a(AppBrandAdUI.a(AppBrandAdUI.this).mAppId, h.d.jzh);
            AppBrandAdUI.a(AppBrandAdUI.this).close();
            paramAnonymousView = new com.tencent.mm.plugin.appbrand.ad.a.c();
            paramAnonymousView.source = "menu";
            paramAnonymousView.c(AppBrandAdUI.a(AppBrandAdUI.this).Ey());
          }
          AppBrandAdUI.this.finish();
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/ad/ui/AppBrandAdUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(44054);
        }
      });
      this.jFl.setOptionButtonClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(44055);
          Object localObject = new com.tencent.mm.hellhoundlib.b.b();
          ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/appbrand/ad/ui/AppBrandAdUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahF());
          if ((AppBrandAdUI.a(AppBrandAdUI.this) != null) && (AppBrandAdUI.a(AppBrandAdUI.this).aWm() != null) && (AppBrandAdUI.a(AppBrandAdUI.this).aWm().getPageView() != null))
          {
            paramAnonymousView = AppBrandAdUI.a(AppBrandAdUI.this).aWm().getPageView();
            localObject = paramAnonymousView.bvh();
            if ((localObject != null) && (!((List)localObject).isEmpty()) && ((paramAnonymousView instanceof ad)))
            {
              AppBrandAdUI.a(AppBrandAdUI.this, new a(AppBrandAdUI.this, paramAnonymousView, (List)localObject));
              AppBrandAdUI.b(AppBrandAdUI.this).aYM();
            }
          }
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/ad/ui/AppBrandAdUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(44055);
        }
      });
      this.jFl.setOnHideListener(new f.a()
      {
        public final void Ls(String paramAnonymousString)
        {
          AppMethodBeat.i(44056);
          if ((AppBrandAdUI.a(AppBrandAdUI.this) != null) && ("menu".equalsIgnoreCase(paramAnonymousString)))
          {
            Object localObject = new com.tencent.mm.plugin.appbrand.ad.a.d();
            ((com.tencent.mm.plugin.appbrand.ad.a.d)localObject).source = paramAnonymousString;
            ((com.tencent.mm.plugin.appbrand.ad.a.d)localObject).c(AppBrandAdUI.a(AppBrandAdUI.this).Ey());
            localObject = new com.tencent.mm.plugin.appbrand.ad.a.c();
            ((com.tencent.mm.plugin.appbrand.ad.a.c)localObject).source = paramAnonymousString;
            ((com.tencent.mm.plugin.appbrand.ad.a.c)localObject).c(AppBrandAdUI.a(AppBrandAdUI.this).Ey());
          }
          AppMethodBeat.o(44056);
        }
      });
      paramBundle = this.jFl;
      if (!ar.isMainThread()) {
        break label475;
      }
      paramBundle.aYz();
    }
    for (;;)
    {
      this.jFB.addView(this.jFl, new ViewGroup.LayoutParams(-1, -1));
      this.jFD.alive();
      paramBundle = new com.tencent.mm.plugin.appbrand.ad.a.f();
      paramBundle.source = "menu";
      paramBundle.a(this.jFc.Ey(), this);
      AppMethodBeat.o(44060);
      return;
      this.jFl.setBackgroundColor(-1);
      this.jFl.setForegroundStyle(true);
      break;
      label475:
      ar.f(new f.1(paramBundle));
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(44063);
    super.onDestroy();
    ae.i("MicroMsg.AppBrandAdUI[AppBrandSplashAd]", "onDestroy");
    if (this.jFD != null)
    {
      this.jFD.dead();
      this.jFD = null;
    }
    if (this.jFC != null) {
      this.jFC.aYN();
    }
    if (this.jFl != null)
    {
      this.jFl.j(false, "menu");
      if ((this.jFl.getParent() instanceof ViewGroup)) {
        ((ViewGroup)this.jFl.getParent()).removeView(this.jFl);
      }
      this.jFl = null;
    }
    if (this.jFc != null)
    {
      this.jFc.jzI = null;
      if (this.jFc.Ey() != null) {
        this.jFc.Ey().aXZ();
      }
    }
    AppMethodBeat.o(44063);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(44062);
    super.onPause();
    ae.i("MicroMsg.AppBrandAdUI[AppBrandSplashAd]", "onPause");
    if (this.jFC != null) {
      this.jFC.aYN();
    }
    if (this.jFc != null)
    {
      com.tencent.mm.plugin.appbrand.ad.a.d locald = new com.tencent.mm.plugin.appbrand.ad.a.d();
      locald.source = "menu";
      locald.c(this.jFc.Ey());
    }
    AppMethodBeat.o(44062);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(44061);
    super.onResume();
    ae.i("MicroMsg.AppBrandAdUI[AppBrandSplashAd]", "onResume");
    if (this.jFc != null)
    {
      e locale = new e();
      locale.source = "menu";
      locale.c(this.jFc.Ey());
    }
    AppMethodBeat.o(44061);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ad.ui.AppBrandAdUI
 * JD-Core Version:    0.7.0.1
 */