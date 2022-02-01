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
import com.tencent.mm.plugin.appbrand.ad.e.a;
import com.tencent.mm.plugin.appbrand.g;
import com.tencent.mm.plugin.appbrand.g.d;
import com.tencent.mm.plugin.appbrand.page.aa;
import com.tencent.mm.plugin.appbrand.page.ae;
import com.tencent.mm.plugin.appbrand.page.u;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.aj;
import java.util.List;

public class AppBrandAdUI
  extends MMActivity
{
  private AppBrandRuntime jiI;
  private com.tencent.mm.plugin.appbrand.ad.e jiR;
  private FrameLayout jiV;
  private a jiW;
  private com.tencent.mm.sdk.b.c<b> jiX;
  
  public AppBrandAdUI()
  {
    AppMethodBeat.i(44058);
    this.jiX = new com.tencent.mm.sdk.b.c() {};
    AppMethodBeat.o(44058);
  }
  
  public int getForceOrientation()
  {
    return 1;
  }
  
  public int getLayoutId()
  {
    return -1;
  }
  
  public boolean noActionBar()
  {
    return true;
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
    customfixStatusbar(true);
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
      paramBundle = getIntent().getStringExtra("appId");
      if (!bs.isNullOrNil(paramBundle)) {
        break;
      }
      ac.e("MicroMsg.AppBrandAdUI", "onCreate, appId is null");
      finish();
      AppMethodBeat.o(44060);
      return;
      paramBundle.setSystemUiVisibility(1280);
    }
    this.jiI = com.tencent.mm.plugin.appbrand.a.GU(paramBundle);
    if ((this.jiI == null) || (this.jiI.isDestroyed()))
    {
      ac.e("MicroMsg.AppBrandAdUI", "onCreate, runtime is null");
      finish();
      AppMethodBeat.o(44060);
      return;
    }
    this.jiR = this.jiI.aTc();
    if (this.jiR == null)
    {
      ac.e("MicroMsg.AppBrandAdUI", "onCreate, runtime adViewContainer is null");
      finish();
      AppMethodBeat.o(44060);
      return;
    }
    if ((this.jiR.getParent() instanceof ViewGroup))
    {
      ac.i("MicroMsg.AppBrandAdUI", "onCreate, reuse runtime adViewContainer");
      ((ViewGroup)this.jiR.getParent()).removeView(this.jiR);
    }
    this.jiR.aUQ();
    this.jiR.setActionBarFullscreenMode(true);
    paramBundle = this.jiR;
    if (paramBundle.jiL != null) {
      paramBundle.jiL.hM(true);
    }
    this.jiR.aUR();
    paramBundle = this.jiR;
    if (paramBundle.jiL != null) {
      paramBundle.jiL.hN(true);
    }
    this.jiR.setTitle(getResources().getString(2131755307));
    if (aj.DT())
    {
      this.jiR.setBackgroundColor(-16777216);
      this.jiR.setForegroundStyle(false);
    }
    for (;;)
    {
      this.jiR.setBackButtonClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(44053);
          if (AppBrandAdUI.a(AppBrandAdUI.this) != null)
          {
            paramAnonymousView = new com.tencent.mm.plugin.appbrand.ad.a.b();
            paramAnonymousView.source = "menu";
            paramAnonymousView.type = "back";
            paramAnonymousView.c(AppBrandAdUI.a(AppBrandAdUI.this).CX());
          }
          AppBrandAdUI.this.finish();
          AppMethodBeat.o(44053);
        }
      });
      this.jiR.setCloseButtonClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(44054);
          if (AppBrandAdUI.a(AppBrandAdUI.this) != null)
          {
            paramAnonymousView = new com.tencent.mm.plugin.appbrand.ad.a.b();
            paramAnonymousView.source = "menu";
            paramAnonymousView.type = "close";
            paramAnonymousView.c(AppBrandAdUI.a(AppBrandAdUI.this).CX());
            g.a(AppBrandAdUI.a(AppBrandAdUI.this).mAppId, g.d.jdc);
            AppBrandAdUI.a(AppBrandAdUI.this).close();
            paramAnonymousView = new com.tencent.mm.plugin.appbrand.ad.a.c();
            paramAnonymousView.source = "menu";
            paramAnonymousView.c(AppBrandAdUI.a(AppBrandAdUI.this).CX());
          }
          AppBrandAdUI.this.finish();
          AppMethodBeat.o(44054);
        }
      });
      this.jiR.setOptionButtonClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(44055);
          if ((AppBrandAdUI.a(AppBrandAdUI.this) != null) && (AppBrandAdUI.a(AppBrandAdUI.this).aSA() != null) && (AppBrandAdUI.a(AppBrandAdUI.this).aSA().getPageView() != null))
          {
            paramAnonymousView = AppBrandAdUI.a(AppBrandAdUI.this).aSA().getPageView();
            List localList = paramAnonymousView.bqx();
            if ((localList != null) && (!localList.isEmpty()) && ((paramAnonymousView instanceof ae)))
            {
              AppBrandAdUI.a(AppBrandAdUI.this, new a(AppBrandAdUI.this, paramAnonymousView, localList));
              AppBrandAdUI.b(AppBrandAdUI.this).aUX();
            }
          }
          AppMethodBeat.o(44055);
        }
      });
      this.jiR.setOnHideListener(new e.a()
      {
        public final void Hl(String paramAnonymousString)
        {
          AppMethodBeat.i(44056);
          if ((AppBrandAdUI.a(AppBrandAdUI.this) != null) && ("menu".equalsIgnoreCase(paramAnonymousString)))
          {
            Object localObject = new com.tencent.mm.plugin.appbrand.ad.a.d();
            ((com.tencent.mm.plugin.appbrand.ad.a.d)localObject).source = paramAnonymousString;
            ((com.tencent.mm.plugin.appbrand.ad.a.d)localObject).c(AppBrandAdUI.a(AppBrandAdUI.this).CX());
            localObject = new com.tencent.mm.plugin.appbrand.ad.a.c();
            ((com.tencent.mm.plugin.appbrand.ad.a.c)localObject).source = paramAnonymousString;
            ((com.tencent.mm.plugin.appbrand.ad.a.c)localObject).c(AppBrandAdUI.a(AppBrandAdUI.this).CX());
          }
          AppMethodBeat.o(44056);
        }
      });
      this.jiR.show();
      this.jiV.addView(this.jiR, new ViewGroup.LayoutParams(-1, -1));
      this.jiX.alive();
      paramBundle = new f();
      paramBundle.source = "menu";
      paramBundle.a(this.jiI.CX(), this);
      AppMethodBeat.o(44060);
      return;
      this.jiR.setBackgroundColor(-1);
      this.jiR.setForegroundStyle(true);
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(44063);
    super.onDestroy();
    ac.i("MicroMsg.AppBrandAdUI", "onDestroy");
    if (this.jiX != null)
    {
      this.jiX.dead();
      this.jiX = null;
    }
    if (this.jiW != null) {
      this.jiW.aUY();
    }
    if (this.jiR != null)
    {
      this.jiR.i(false, "menu");
      if ((this.jiR.getParent() instanceof ViewGroup)) {
        ((ViewGroup)this.jiR.getParent()).removeView(this.jiR);
      }
      if (this.jiI != null)
      {
        ac.i("MicroMsg.AppBrandAdUI", "onDestroy, restore runtime adViewContainer back to runtime");
        this.jiI.jdA.addView(this.jiR);
      }
    }
    AppMethodBeat.o(44063);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(44062);
    super.onPause();
    ac.i("MicroMsg.AppBrandAdUI", "onPause");
    if (this.jiW != null) {
      this.jiW.aUY();
    }
    if (this.jiI != null)
    {
      com.tencent.mm.plugin.appbrand.ad.a.d locald = new com.tencent.mm.plugin.appbrand.ad.a.d();
      locald.source = "menu";
      locald.c(this.jiI.CX());
    }
    AppMethodBeat.o(44062);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(44061);
    super.onResume();
    ac.i("MicroMsg.AppBrandAdUI", "onResume");
    if (this.jiI != null)
    {
      com.tencent.mm.plugin.appbrand.ad.a.e locale = new com.tencent.mm.plugin.appbrand.ad.a.e();
      locale.source = "menu";
      locale.c(this.jiI.CX());
    }
    AppMethodBeat.o(44061);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public final View provideCustomActivityContentView()
  {
    AppMethodBeat.i(44059);
    this.jiV = new FrameLayout(this);
    this.jiV.setBackgroundColor(0);
    FrameLayout localFrameLayout = this.jiV;
    AppMethodBeat.o(44059);
    return localFrameLayout;
  }
  
  public boolean supportNavigationSwipeBack()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ad.ui.AppBrandAdUI
 * JD-Core Version:    0.7.0.1
 */