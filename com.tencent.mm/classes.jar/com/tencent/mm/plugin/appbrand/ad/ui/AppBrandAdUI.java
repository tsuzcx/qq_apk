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
import com.tencent.mm.plugin.appbrand.ad.a.c;
import com.tencent.mm.plugin.appbrand.ad.f.1;
import com.tencent.mm.plugin.appbrand.ad.f.a;
import com.tencent.mm.plugin.appbrand.h;
import com.tencent.mm.plugin.appbrand.h.d;
import com.tencent.mm.plugin.appbrand.page.ac;
import com.tencent.mm.plugin.appbrand.page.ag;
import com.tencent.mm.plugin.appbrand.page.w;
import com.tencent.mm.plugin.appbrand.s;
import com.tencent.mm.plugin.appbrand.ui.ah;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMBaseActivity;
import com.tencent.mm.ui.MMFragmentActivity.a;
import com.tencent.mm.ui.ao;
import java.util.List;

public class AppBrandAdUI
  extends MMBaseActivity
{
  private AppBrandRuntime kGM;
  private com.tencent.mm.plugin.appbrand.ad.f kGV;
  private FrameLayout kHl;
  private a kHm;
  private IListener<b> kHn;
  
  public AppBrandAdUI()
  {
    AppMethodBeat.i(44058);
    this.kHn = new IListener() {};
    AppMethodBeat.o(44058);
  }
  
  public void onBackPressed()
  {
    AppMethodBeat.i(226280);
    super.onBackPressed();
    if (isFinishing()) {
      overridePendingTransition(MMFragmentActivity.a.ogo, MMFragmentActivity.a.ogp);
    }
    AppMethodBeat.o(226280);
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
      this.kHl = new FrameLayout(this);
      this.kHl.setBackgroundColor(0);
      setContentView(this.kHl);
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
    this.kGM = com.tencent.mm.plugin.appbrand.a.TQ(paramBundle);
    if ((this.kGM == null) || (this.kGM.isDestroyed()))
    {
      Log.e("MicroMsg.AppBrandAdUI[AppBrandSplashAd]", "onCreate, runtime is null");
      finish();
      AppMethodBeat.o(44060);
      return;
    }
    if (this.kGM.NY() != null) {
      this.kGM.NY().btf();
    }
    this.kGV = new com.tencent.mm.plugin.appbrand.ad.f(this, this.kGM);
    this.kGM.kAw = this.kGV;
    this.kGV.btL();
    this.kGV.setActionBarFullscreenMode(true);
    paramBundle = this.kGV;
    if (paramBundle.kGP != null) {
      paramBundle.kGP.gx(true);
    }
    this.kGV.btM();
    paramBundle = this.kGV;
    if (paramBundle.kGP != null) {
      paramBundle.kGP.gy(true);
    }
    this.kGV.setTitle(getResources().getString(2131755343));
    if (ao.isDarkMode())
    {
      this.kGV.setBackgroundColor(-16777216);
      this.kGV.setForegroundStyle(false);
      this.kGV.setBackButtonClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(44053);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bm(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/appbrand/ad/ui/AppBrandAdUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
          if (AppBrandAdUI.a(AppBrandAdUI.this) != null)
          {
            paramAnonymousView = new com.tencent.mm.plugin.appbrand.ad.a.b();
            paramAnonymousView.source = "menu";
            paramAnonymousView.type = "back";
            paramAnonymousView.d(AppBrandAdUI.a(AppBrandAdUI.this).NY());
          }
          AppBrandAdUI.this.finish();
          AppBrandAdUI.this.overridePendingTransition(MMFragmentActivity.a.ogo, MMFragmentActivity.a.ogp);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/ad/ui/AppBrandAdUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(44053);
        }
      });
      this.kGV.setCloseButtonClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(44054);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bm(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/appbrand/ad/ui/AppBrandAdUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
          if (AppBrandAdUI.a(AppBrandAdUI.this) != null)
          {
            paramAnonymousView = new com.tencent.mm.plugin.appbrand.ad.a.b();
            paramAnonymousView.source = "menu";
            paramAnonymousView.type = "close";
            paramAnonymousView.d(AppBrandAdUI.a(AppBrandAdUI.this).NY());
            h.a(AppBrandAdUI.a(AppBrandAdUI.this).mAppId, h.d.kzP);
            AppBrandAdUI.a(AppBrandAdUI.this).close();
            paramAnonymousView = new c();
            paramAnonymousView.source = "menu";
            paramAnonymousView.d(AppBrandAdUI.a(AppBrandAdUI.this).NY());
          }
          AppBrandAdUI.this.finish();
          ((ah)com.tencent.luggage.a.e.M(ah.class)).m(AppBrandAdUI.this);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/ad/ui/AppBrandAdUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(44054);
        }
      });
      this.kGV.setOptionButtonClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(44055);
          Object localObject = new com.tencent.mm.hellhoundlib.b.b();
          ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/appbrand/ad/ui/AppBrandAdUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
          if ((AppBrandAdUI.a(AppBrandAdUI.this) != null) && (AppBrandAdUI.a(AppBrandAdUI.this).brh() != null) && (AppBrandAdUI.a(AppBrandAdUI.this).brh().getPageView() != null))
          {
            paramAnonymousView = AppBrandAdUI.a(AppBrandAdUI.this).brh().getPageView();
            localObject = paramAnonymousView.bRh();
            if ((localObject != null) && (!((List)localObject).isEmpty()) && ((paramAnonymousView instanceof ag)))
            {
              AppBrandAdUI.a(AppBrandAdUI.this, new a(AppBrandAdUI.this, paramAnonymousView, (List)localObject));
              AppBrandAdUI.b(AppBrandAdUI.this).btY();
            }
          }
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/ad/ui/AppBrandAdUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(44055);
        }
      });
      this.kGV.setOnHideListener(new f.a()
      {
        public final void UB(String paramAnonymousString)
        {
          AppMethodBeat.i(44056);
          if ((AppBrandAdUI.a(AppBrandAdUI.this) != null) && ("menu".equalsIgnoreCase(paramAnonymousString)))
          {
            Object localObject = new com.tencent.mm.plugin.appbrand.ad.a.d();
            ((com.tencent.mm.plugin.appbrand.ad.a.d)localObject).source = paramAnonymousString;
            ((com.tencent.mm.plugin.appbrand.ad.a.d)localObject).d(AppBrandAdUI.a(AppBrandAdUI.this).NY());
            localObject = new c();
            ((c)localObject).source = paramAnonymousString;
            ((c)localObject).d(AppBrandAdUI.a(AppBrandAdUI.this).NY());
          }
          AppMethodBeat.o(44056);
        }
      });
      paramBundle = this.kGV;
      if (!MMHandlerThread.isMainThread()) {
        break label485;
      }
      paramBundle.btN();
    }
    for (;;)
    {
      this.kHl.addView(this.kGV, new ViewGroup.LayoutParams(-1, -1));
      this.kHn.alive();
      paramBundle = new com.tencent.mm.plugin.appbrand.ad.a.f();
      paramBundle.source = "menu";
      paramBundle.a(this.kGM.NY(), this);
      overridePendingTransition(MMFragmentActivity.a.ogm, MMFragmentActivity.a.ogn);
      AppMethodBeat.o(44060);
      return;
      this.kGV.setBackgroundColor(-1);
      this.kGV.setForegroundStyle(true);
      break;
      label485:
      MMHandlerThread.postToMainThread(new f.1(paramBundle));
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(44063);
    super.onDestroy();
    Log.i("MicroMsg.AppBrandAdUI[AppBrandSplashAd]", "onDestroy");
    if (this.kHn != null)
    {
      this.kHn.dead();
      this.kHn = null;
    }
    if (this.kHm != null) {
      this.kHm.btZ();
    }
    if (this.kGV != null)
    {
      this.kGV.k(false, "menu");
      if ((this.kGV.getParent() instanceof ViewGroup)) {
        ((ViewGroup)this.kGV.getParent()).removeView(this.kGV);
      }
      this.kGV = null;
    }
    if (this.kGM != null)
    {
      this.kGM.kAw = null;
      if (this.kGM.NY() != null) {
        this.kGM.NY().btf();
      }
    }
    AppMethodBeat.o(44063);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(44062);
    super.onPause();
    Log.i("MicroMsg.AppBrandAdUI[AppBrandSplashAd]", "onPause");
    if (this.kHm != null) {
      this.kHm.btZ();
    }
    if (this.kGM != null)
    {
      com.tencent.mm.plugin.appbrand.ad.a.d locald = new com.tencent.mm.plugin.appbrand.ad.a.d();
      locald.source = "menu";
      locald.d(this.kGM.NY());
    }
    AppMethodBeat.o(44062);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(44061);
    super.onResume();
    Log.i("MicroMsg.AppBrandAdUI[AppBrandSplashAd]", "onResume");
    if (this.kGM != null)
    {
      com.tencent.mm.plugin.appbrand.ad.a.e locale = new com.tencent.mm.plugin.appbrand.ad.a.e();
      locale.source = "menu";
      locale.d(this.kGM.NY());
    }
    AppMethodBeat.o(44061);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ad.ui.AppBrandAdUI
 * JD-Core Version:    0.7.0.1
 */