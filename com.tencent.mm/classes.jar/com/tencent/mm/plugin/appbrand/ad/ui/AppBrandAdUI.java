package com.tencent.mm.plugin.appbrand.ad.ui;

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
import androidx.lifecycle.q;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.ad.f.a;
import com.tencent.mm.plugin.appbrand.as;
import com.tencent.mm.plugin.appbrand.ba.i;
import com.tencent.mm.plugin.appbrand.k;
import com.tencent.mm.plugin.appbrand.k.d;
import com.tencent.mm.plugin.appbrand.n.o;
import com.tencent.mm.plugin.appbrand.page.ad;
import com.tencent.mm.plugin.appbrand.page.ah;
import com.tencent.mm.plugin.appbrand.page.y;
import com.tencent.mm.plugin.appbrand.ui.ap;
import com.tencent.mm.plugin.appbrand.w;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMBaseActivity;
import com.tencent.mm.ui.MMFragmentActivity.a;
import com.tencent.mm.ui.aw;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.r;

public class AppBrandAdUI
  extends MMBaseActivity
{
  private FrameLayout ewq;
  private a qAr;
  private IListener<b> qAs;
  private w qxC;
  private com.tencent.mm.plugin.appbrand.ad.f qzH;
  
  public AppBrandAdUI()
  {
    AppMethodBeat.i(44058);
    this.qAs = new IListener(com.tencent.mm.app.f.hfK) {};
    AppMethodBeat.o(44058);
  }
  
  public void onBackPressed()
  {
    AppMethodBeat.i(321382);
    super.onBackPressed();
    if (isFinishing()) {
      overridePendingTransition(MMFragmentActivity.a.upW, MMFragmentActivity.a.upX);
    }
    AppMethodBeat.o(321382);
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
      com.tencent.mm.ui.statusbar.d.g(getWindow());
      com.tencent.mm.ui.statusbar.d.c(getWindow(), true);
      this.ewq = new FrameLayout(this);
      this.ewq.setBackgroundColor(0);
      setContentView(this.ewq);
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
    this.qxC = com.tencent.mm.plugin.appbrand.d.Uc(paramBundle);
    if ((this.qxC == null) || (this.qxC.qsE.get()))
    {
      Log.e("MicroMsg.AppBrandAdUI[AppBrandSplashAd]", "onCreate, runtime is null");
      finish();
      AppMethodBeat.o(44060);
      return;
    }
    if (this.qxC.ccO() != null) {
      this.qxC.ccO().ceh();
    }
    this.qzH = new com.tencent.mm.plugin.appbrand.ad.f(this, this.qxC);
    this.qxC.qso = this.qzH;
    this.qzH.cdV();
    this.qzH.setActionBarFullscreenMode(true);
    paramBundle = this.qzH;
    if (paramBundle.qzC != null) {
      paramBundle.qzC.ia(true);
    }
    this.qzH.cdW();
    paramBundle = this.qzH;
    if (paramBundle.qzC != null) {
      paramBundle.qzC.ib(true);
    }
    this.qzH.setTitle(getResources().getString(ba.i.app_brand_ad_title));
    if (aw.isDarkMode())
    {
      this.qzH.setBackgroundColor(-16777216);
      this.qzH.setForegroundStyle(false);
    }
    for (;;)
    {
      this.qzH.setBackButtonClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(44053);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.cH(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/appbrand/ad/ui/AppBrandAdUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
          if (AppBrandAdUI.a(AppBrandAdUI.this) != null)
          {
            paramAnonymousView = new com.tencent.mm.plugin.appbrand.ad.a.b();
            paramAnonymousView.source = "menu";
            paramAnonymousView.type = "back";
            paramAnonymousView.a(AppBrandAdUI.a(AppBrandAdUI.this).ccO());
          }
          AppBrandAdUI.this.finish();
          AppBrandAdUI.this.overridePendingTransition(MMFragmentActivity.a.upW, MMFragmentActivity.a.upX);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/ad/ui/AppBrandAdUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(44053);
        }
      });
      this.qzH.setCloseButtonClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(44054);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.cH(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/appbrand/ad/ui/AppBrandAdUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
          if (AppBrandAdUI.a(AppBrandAdUI.this) != null)
          {
            paramAnonymousView = new com.tencent.mm.plugin.appbrand.ad.a.b();
            paramAnonymousView.source = "menu";
            paramAnonymousView.type = "close";
            paramAnonymousView.a(AppBrandAdUI.a(AppBrandAdUI.this).ccO());
            k.a(AppBrandAdUI.a(AppBrandAdUI.this).mAppId, k.d.qrG);
            AppBrandAdUI.a(AppBrandAdUI.this).close();
            paramAnonymousView = new com.tencent.mm.plugin.appbrand.ad.a.c();
            paramAnonymousView.source = "menu";
            paramAnonymousView.a(AppBrandAdUI.a(AppBrandAdUI.this).ccO());
          }
          AppBrandAdUI.this.finish();
          ((ap)com.tencent.luggage.a.e.T(ap.class)).l(AppBrandAdUI.this);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/ad/ui/AppBrandAdUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(44054);
        }
      });
      this.qzH.setOptionButtonClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(44055);
          Object localObject = new com.tencent.mm.hellhoundlib.b.b();
          ((com.tencent.mm.hellhoundlib.b.b)localObject).cH(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/appbrand/ad/ui/AppBrandAdUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aYj());
          if ((AppBrandAdUI.a(AppBrandAdUI.this) != null) && (AppBrandAdUI.a(AppBrandAdUI.this).ccN() != null) && (AppBrandAdUI.a(AppBrandAdUI.this).ccN().getPageView() != null))
          {
            paramAnonymousView = AppBrandAdUI.a(AppBrandAdUI.this).ccN().getPageView();
            localObject = paramAnonymousView.cEB();
            if ((localObject != null) && (!((List)localObject).isEmpty()) && ((paramAnonymousView instanceof ah)))
            {
              AppBrandAdUI.a(AppBrandAdUI.this, new a(AppBrandAdUI.this, paramAnonymousView, (List)localObject));
              AppBrandAdUI.b(AppBrandAdUI.this).cem();
            }
          }
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/ad/ui/AppBrandAdUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(44055);
        }
      });
      this.qzH.setOnHideListener(new f.a()
      {
        public final void UL(String paramAnonymousString)
        {
          AppMethodBeat.i(44056);
          if ((AppBrandAdUI.a(AppBrandAdUI.this) != null) && ("menu".equalsIgnoreCase(paramAnonymousString)))
          {
            Object localObject = new com.tencent.mm.plugin.appbrand.ad.a.d();
            ((com.tencent.mm.plugin.appbrand.ad.a.d)localObject).source = paramAnonymousString;
            ((com.tencent.mm.plugin.appbrand.ad.a.d)localObject).a(AppBrandAdUI.a(AppBrandAdUI.this).ccO());
            localObject = new com.tencent.mm.plugin.appbrand.ad.a.c();
            ((com.tencent.mm.plugin.appbrand.ad.a.c)localObject).source = paramAnonymousString;
            ((com.tencent.mm.plugin.appbrand.ad.a.c)localObject).a(AppBrandAdUI.a(AppBrandAdUI.this).ccO());
          }
          AppMethodBeat.o(44056);
        }
      });
      this.qzH.show();
      this.ewq.addView(this.qzH, new ViewGroup.LayoutParams(-1, -1));
      this.qAs.alive();
      this.qxC.qvK.a(new as()
      {
        public final void a(o paramAnonymouso, r<Long, Long> paramAnonymousr, String paramAnonymousString)
        {
          AppMethodBeat.i(321333);
          if (paramAnonymouso == null)
          {
            AppMethodBeat.o(321333);
            return;
          }
          paramAnonymousr = new com.tencent.mm.plugin.appbrand.ad.a.f();
          paramAnonymousr.source = "menu";
          paramAnonymousr.a(AppBrandAdUI.a(AppBrandAdUI.this).ccO(), AppBrandAdUI.this, paramAnonymouso);
          AppMethodBeat.o(321333);
        }
      });
      overridePendingTransition(MMFragmentActivity.a.upU, MMFragmentActivity.a.upV);
      AppMethodBeat.o(44060);
      return;
      this.qzH.setBackgroundColor(-1);
      this.qzH.setForegroundStyle(true);
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(44063);
    super.onDestroy();
    Log.i("MicroMsg.AppBrandAdUI[AppBrandSplashAd]", "onDestroy");
    if (this.qAs != null)
    {
      this.qAs.dead();
      this.qAs = null;
    }
    if (this.qAr != null) {
      this.qAr.cen();
    }
    if (this.qzH != null)
    {
      this.qzH.B(false, "menu");
      if ((this.qzH.getParent() instanceof ViewGroup)) {
        ((ViewGroup)this.qzH.getParent()).removeView(this.qzH);
      }
      this.qzH = null;
    }
    if (this.qxC != null)
    {
      this.qxC.qso = null;
      if (this.qxC.ccO() != null) {
        this.qxC.ccO().ceh();
      }
    }
    AppMethodBeat.o(44063);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(44062);
    super.onPause();
    Log.i("MicroMsg.AppBrandAdUI[AppBrandSplashAd]", "onPause");
    if (this.qAr != null) {
      this.qAr.cen();
    }
    if (this.qxC != null)
    {
      com.tencent.mm.plugin.appbrand.ad.a.d locald = new com.tencent.mm.plugin.appbrand.ad.a.d();
      locald.source = "menu";
      locald.a(this.qxC.ccO());
    }
    AppMethodBeat.o(44062);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(44061);
    super.onResume();
    Log.i("MicroMsg.AppBrandAdUI[AppBrandSplashAd]", "onResume");
    if (this.qxC != null)
    {
      com.tencent.mm.plugin.appbrand.ad.a.e locale = new com.tencent.mm.plugin.appbrand.ad.a.e();
      locale.source = "menu";
      locale.a(this.qxC.ccO());
    }
    AppMethodBeat.o(44061);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ad.ui.AppBrandAdUI
 * JD-Core Version:    0.7.0.1
 */