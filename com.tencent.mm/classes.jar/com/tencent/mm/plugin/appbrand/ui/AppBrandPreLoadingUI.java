package com.tencent.mm.plugin.appbrand.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.fj;
import com.tencent.mm.g.b.a.fj.a;
import com.tencent.mm.plugin.appbrand.app.d;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.WxaVersionInfo;
import com.tencent.mm.plugin.appbrand.launching.ab;
import com.tencent.mm.plugin.appbrand.report.model.n;
import com.tencent.mm.plugin.appbrand.report.quality.QualitySession;
import com.tencent.mm.plugin.appbrand.ui.wxa_container.BaseAppBrandUIClipped;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ax;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.ui.MMActivity.a;
import com.tencent.mm.ui.MMBaseActivity;
import com.tencent.mm.ui.MMFragmentActivity.a;
import d.g;
import d.g.b.o;
import d.g.b.u;

@com.tencent.mm.ui.base.a(7)
@d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/appbrand/ui/AppBrandPreLoadingUI;", "Lcom/tencent/mm/ui/MMBaseActivity;", "Lcom/tencent/mm/plugin/appbrand/launching/IMMActivityResultInstrumentation;", "()V", "appBrandUIEnterAnimationCompleteEventListener", "Lcom/tencent/mm/plugin/appbrand/ui/AppBrandPreLoadingUI$AppBrandUIEnterAnimationCompleteEventListener;", "appId", "", "connect", "Lcom/tencent/mm/plugin/appbrand/loading/AppBrandPreLoadingServiceConnection;", "isBindServiceSuccess", "", "isCloseByUser", "<set-?>", "isForeground", "()Z", "setForeground", "(Z)V", "isForeground$delegate", "Lkotlin/properties/ReadWriteProperty;", "kv14576", "Lcom/tencent/mm/plugin/appbrand/report/model/kv_14576;", "pendingIntent", "Landroid/content/Intent;", "pendingIntentKey", "", "pendingIntentTask", "Lcom/tencent/mm/plugin/appbrand/loading/PendingIntentTask;", "scene", "getScene", "()I", "scene$delegate", "Lkotlin/Lazy;", "serviceName", "splashView", "Lcom/tencent/mm/plugin/appbrand/ui/IAppBrandLoadingSplash;", "getSplashView", "()Lcom/tencent/mm/plugin/appbrand/ui/IAppBrandLoadingSplash;", "splashView$delegate", "targetUiName", "uiFlavor", "getUiFlavor", "uiFlavor$delegate", "versionInfo", "Lcom/tencent/mm/plugin/appbrand/config/WxaAttributes$WxaVersionInfo;", "attach", "", "intent", "lifecycle", "canStartActivityForResult", "finish", "mayRainbowBackgroundForTest", "onBackPressed", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onNewIntent", "onPause", "onRestoreInstanceState", "onResume", "report", "startActivityForResult", "onActResult", "Lcom/tencent/mm/ui/MMActivity$IMMOnActivityResult;", "requestCode", "tryToInterruptPost", "clearFlags", "flags", "AppBrandUIEnterAnimationCompleteEventListener", "Companion", "plugin-appbrand-integration_release"})
public class AppBrandPreLoadingUI
  extends MMBaseActivity
  implements ab
{
  public static final c lAA;
  private String appId;
  private WxaAttributes.WxaVersionInfo jfa;
  private final d.i.c kAm;
  private int kON;
  private String kVV;
  private com.tencent.mm.plugin.appbrand.loading.e lAp;
  private Intent lAq;
  private boolean lAr;
  private boolean lAs;
  private AppBrandPreLoadingUI.b lAt;
  private n lAu;
  private String lAv;
  private com.tencent.mm.plugin.appbrand.loading.b lAw;
  private final d.f lAx;
  private final d.f lAy;
  private final d.f lAz;
  
  static
  {
    AppMethodBeat.i(51126);
    $$delegatedProperties = new d.l.k[] { (d.l.k)d.g.b.w.a(new o(d.g.b.w.bk(AppBrandPreLoadingUI.class), "isForeground", "isForeground()Z")), (d.l.k)d.g.b.w.a(new u(d.g.b.w.bk(AppBrandPreLoadingUI.class), "uiFlavor", "getUiFlavor()I")), (d.l.k)d.g.b.w.a(new u(d.g.b.w.bk(AppBrandPreLoadingUI.class), "scene", "getScene()I")), (d.l.k)d.g.b.w.a(new u(d.g.b.w.bk(AppBrandPreLoadingUI.class), "splashView", "getSplashView()Lcom/tencent/mm/plugin/appbrand/ui/IAppBrandLoadingSplash;")) };
    lAA = new c((byte)0);
    AppMethodBeat.o(51126);
  }
  
  public AppBrandPreLoadingUI()
  {
    AppMethodBeat.i(51141);
    this.appId = "";
    Object localObject = d.i.a.JhA;
    localObject = Boolean.TRUE;
    this.kAm = ((d.i.c)new a(localObject, localObject, this));
    this.kON = -1;
    this.kVV = "";
    this.lAu = new n();
    this.lAv = "";
    this.lAx = g.E((d.g.a.a)new i(this));
    this.lAy = g.E((d.g.a.a)new g(this));
    this.lAz = g.E((d.g.a.a)new h(this));
    AppMethodBeat.o(51141);
  }
  
  private final int bhq()
  {
    AppMethodBeat.i(51128);
    int i = ((Number)this.lAx.getValue()).intValue();
    AppMethodBeat.o(51128);
    return i;
  }
  
  private final v boq()
  {
    AppMethodBeat.i(51129);
    v localv = (v)this.lAz.getValue();
    AppMethodBeat.o(51129);
    return localv;
  }
  
  private final void bor()
  {
    AppMethodBeat.i(51137);
    this.lAp = com.tencent.mm.plugin.appbrand.loading.c.kPa.sY(this.kON);
    ad.i("MicroMsg.AppBrand.AppBrandPreLoadingUI", "tryToInterruptPost: interrupt #" + this.kON + " successful");
    AppMethodBeat.o(51137);
  }
  
  private final void d(Intent paramIntent, String paramString)
  {
    AppMethodBeat.i(175217);
    String str1 = paramIntent.getStringExtra("MicroMsg.AppBrandPreLoadingLogic.icon");
    if (str1 == null) {
      str1 = "";
    }
    for (;;)
    {
      String str2 = paramIntent.getStringExtra("MicroMsg.AppBrandPreLoadingLogic.name");
      if (str2 == null) {
        str2 = "";
      }
      for (;;)
      {
        String str3 = paramIntent.getStringExtra("MicroMsg.AppBrandPreLoadingLogic.appId");
        Object localObject = str3;
        if (str3 == null) {
          localObject = "";
        }
        this.appId = ((String)localObject);
        this.jfa = ((WxaAttributes.WxaVersionInfo)paramIntent.getParcelableExtra("MicroMsg.AppBrandPreLoadingLogic.versionInfo"));
        str3 = paramIntent.getStringExtra("MicroMsg.AppBrandPreLoadingLogic.targetActivityName");
        localObject = str3;
        if (str3 == null) {
          localObject = "";
        }
        this.lAv = ((String)localObject);
        this.kON = paramIntent.getIntExtra("MicroMsg.AppBrandPreLoadingLogic.intentKey", -1);
        com.tencent.mm.plugin.appbrand.loading.c.kPa.a(this.kON, (Context)this);
        localObject = this.lAt;
        if (localObject != null) {
          ((AppBrandPreLoadingUI.b)localObject).dead();
        }
        this.lAt = new AppBrandPreLoadingUI.b(this);
        localObject = this.lAt;
        if (localObject == null) {
          d.g.b.k.fvU();
        }
        ((AppBrandPreLoadingUI.b)localObject).alive();
        localObject = paramIntent.getStringExtra("MicroMsg.AppBrandPreLoadingLogic.serviceName");
        paramIntent = (Intent)localObject;
        if (localObject == null) {
          paramIntent = "";
        }
        this.kVV = paramIntent;
        boq().dB(str1, str2);
        if ((boq() instanceof w))
        {
          paramIntent = boq();
          if (paramIntent == null)
          {
            paramIntent = new d.v("null cannot be cast to non-null type com.tencent.mm.plugin.appbrand.ui.IAppBrandLoadingSplashCloseable");
            AppMethodBeat.o(175217);
            throw paramIntent;
          }
          ((w)paramIntent).q((d.g.a.a)new AppBrandPreLoadingUI.d(this));
        }
        ad.i("MicroMsg.AppBrand.AppBrandPreLoadingUI", "attach[" + paramString + "]: uiFlavor = " + bhq() + ", iconUrl = " + str1 + ", name = " + str2);
        paramIntent = new Intent();
        paramIntent.setClassName((Context)this, this.kVV);
        this.lAw = new com.tencent.mm.plugin.appbrand.loading.b(this.kON, "MicroMsg.AppBrand.AppBrandPreLoadingUI", (d.g.a.a)new AppBrandPreLoadingUI.e(this, paramString));
        try
        {
          this.lAs = bindService(paramIntent, (ServiceConnection)this.lAw, 65);
          ad.i("MicroMsg.AppBrand.AppBrandPreLoadingUI", "attach[" + paramString + "]: bind " + this.kVV + " ret = " + this.lAs);
          this.lAu = new n();
          this.lAu.bmC();
          AppMethodBeat.o(175217);
          return;
        }
        catch (Exception paramIntent)
        {
          for (;;)
          {
            ad.e("MicroMsg.AppBrand.AppBrandPreLoadingUI", "attach[" + paramString + "]: bindService fail", new Object[] { paramIntent });
          }
        }
      }
    }
  }
  
  private final void eh(boolean paramBoolean)
  {
    AppMethodBeat.i(51127);
    this.kAm.a($$delegatedProperties[0], Boolean.valueOf(paramBoolean));
    AppMethodBeat.o(51127);
  }
  
  public final void a(MMActivity.a parama, Intent paramIntent, int paramInt) {}
  
  public final boolean bgd()
  {
    return false;
  }
  
  public void finish()
  {
    AppMethodBeat.i(51138);
    if ((isFinishing()) || (isDestroyed()))
    {
      AppMethodBeat.o(51138);
      return;
    }
    super.finish();
    ad.i("MicroMsg.AppBrand.AppBrandPreLoadingUI", "finish: isCloseByUser:" + this.lAr + ", appId:" + this.appId);
    if (this.lAr)
    {
      Object localObject3;
      if (this.lAp != null)
      {
        localObject1 = this.lAp;
        if (localObject1 == null) {
          d.g.b.k.fvU();
        }
        localObject1 = ((com.tencent.mm.plugin.appbrand.loading.e)localObject1).kHa;
        Object localObject2 = this.lAu;
        localObject3 = this.lAp;
        if (localObject3 == null) {
          d.g.b.k.fvU();
        }
        ((n)localObject2).e((AppBrandInitConfigWC)localObject1, ((com.tencent.mm.plugin.appbrand.loading.e)localObject3).cfo);
        this.lAu.report();
        localObject2 = ((AppBrandInitConfigWC)localObject1).jdu;
        localObject3 = new fj();
        ((fj)localObject3).li(((QualitySession)localObject2).kGa);
        ((fj)localObject3).lj(((QualitySession)localObject2).appId);
        ((fj)localObject3).ij(((QualitySession)localObject2).lty);
        ((fj)localObject3).a(fj.a.iS(((QualitySession)localObject2).lrW));
        ((fj)localObject3).ik(((QualitySession)localObject2).apptype);
        ((fj)localObject3).im(((QualitySession)localObject2).scene);
        ((fj)localObject3).lk(((AppBrandInitConfigWC)localObject1).username);
        ((fj)localObject3).RU();
        ((fj)localObject3).RV();
        ((fj)localObject3).ll(com.tencent.mm.plugin.appbrand.report.h.getNetworkType(aj.getContext()));
        if (!((AppBrandInitConfigWC)localObject1).CX()) {
          break label365;
        }
      }
      label365:
      for (long l = 1L;; l = 0L)
      {
        ((fj)localObject3).io(l);
        ((fj)localObject3).RW();
        ((fj)localObject3).in(((AppBrandInitConfigWC)localObject1).startTime);
        ((fj)localObject3).RT();
        ((fj)localObject3).il(((fj)localObject3).RS() - ((fj)localObject3).RR());
        ((fj)localObject3).RX();
        ((fj)localObject3).aBj();
        this.lAp = null;
        if (bhq() != 5) {
          break;
        }
        ((z)com.tencent.luggage.a.e.K(z.class)).m((Activity)this);
        AppMethodBeat.o(51138);
        return;
      }
      if (bhq() == 4) {
        super.overridePendingTransition(MMFragmentActivity.a.lLH, MMFragmentActivity.a.lLI);
      }
      AppMethodBeat.o(51138);
      return;
    }
    Object localObject1 = findViewById(16908290);
    if (localObject1 != null) {
      ((View)localObject1).setVisibility(8);
    }
    super.overridePendingTransition(0, 0);
    AppMethodBeat.o(51138);
  }
  
  public void onBackPressed()
  {
    AppMethodBeat.i(51136);
    this.lAr = true;
    bor();
    ad.i("MicroMsg.AppBrand.AppBrandPreLoadingUI", "onBackPressed: ");
    super.onBackPressed();
    AppMethodBeat.o(51136);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(51134);
    super.onCreate(paramBundle);
    if (paramBundle != null)
    {
      paramBundle = (Intent)paramBundle.getParcelable("MicroMsg.AppBrandPreLoadingUI.intent");
      if (paramBundle != null)
      {
        ad.i("MicroMsg.AppBrand.AppBrandPreLoadingUI", "onCreate: saved intent != null");
        paramBundle = new com.tencent.mm.hellhoundlib.b.a().bd(paramBundle);
        com.tencent.mm.hellhoundlib.a.a.a(this, paramBundle.adn(), "com/tencent/mm/plugin/appbrand/ui/AppBrandPreLoadingUI", "onCreate", "(Landroid/os/Bundle;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        startActivity((Intent)paramBundle.lS(0));
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/ui/AppBrandPreLoadingUI", "onCreate", "(Landroid/os/Bundle;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      }
    }
    requestWindowFeature(10);
    requestWindowFeature(1);
    paramBundle = new FrameLayout((Context)this);
    setContentView((View)paramBundle);
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-1, -1);
    if ((bu.eGT()) || (com.tencent.mm.sdk.platformtools.h.IS_FLAVOR_RED) || (com.tencent.mm.sdk.platformtools.h.IS_FLAVOR_PURPLE))
    {
      localObject = d.iJD;
      localObject = d.Km();
      if ((localObject != null) && (((ax)localObject).getBoolean("enable_pre_loading_rainbow", false) == true))
      {
        localObject = (d.g.a.a)AppBrandPreLoadingUI.f.lAD;
        boq().tc(Color.rgb(((Number)((d.g.a.a)localObject).invoke()).intValue(), ((Number)((d.g.a.a)localObject).invoke()).intValue(), ((Number)((d.g.a.a)localObject).invoke()).intValue()));
      }
    }
    ad.i("MicroMsg.AppBrand.AppBrandPreLoadingUI", "onCreate: ");
    Object localObject = getIntent();
    d.g.b.k.g(localObject, "intent");
    d((Intent)localObject, "onCreate");
    paramBundle.addView(boq().getView(), (ViewGroup.LayoutParams)localLayoutParams);
    BaseAppBrandUIClipped.d((Activity)this, android.support.v4.content.b.n((Context)this, 2131099649));
    AppMethodBeat.o(51134);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(51139);
    super.onDestroy();
    Object localObject = new Intent();
    ((Intent)localObject).setClassName((Context)this, this.kVV);
    if (this.lAs) {}
    try
    {
      if (this.lAw != null) {
        unbindService((ServiceConnection)this.lAw);
      }
      stopService((Intent)localObject);
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ad.i("MicroMsg.AppBrand.AppBrandPreLoadingUI", "onDestroy: ", new Object[] { localException });
      }
    }
    localObject = this.lAt;
    if (localObject != null) {
      ((AppBrandPreLoadingUI.b)localObject).dead();
    }
    ad.i("MicroMsg.AppBrand.AppBrandPreLoadingUI", "onDestroy: ");
    AppMethodBeat.o(51139);
  }
  
  public void onNewIntent(Intent paramIntent)
  {
    AppMethodBeat.i(51131);
    super.onNewIntent(paramIntent);
    ad.i("MicroMsg.AppBrand.AppBrandPreLoadingUI", "onNewIntent: ");
    if (paramIntent == null)
    {
      AppMethodBeat.o(51131);
      return;
    }
    this.lAq = null;
    this.lAr = false;
    d(paramIntent, "onNewIntent");
    AppMethodBeat.o(51131);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(51135);
    super.onPause();
    ad.i("MicroMsg.AppBrand.AppBrandPreLoadingUI", "onPause: ");
    if (!this.lAr) {
      overridePendingTransition(0, 0);
    }
    eh(false);
    AppMethodBeat.o(51135);
  }
  
  protected void onRestoreInstanceState(Bundle paramBundle)
  {
    AppMethodBeat.i(51140);
    super.onRestoreInstanceState(paramBundle);
    ad.i("MicroMsg.AppBrand.AppBrandPreLoadingUI", "onRestoreInstanceState: pendingIntent = " + this.lAq);
    if ((paramBundle != null) && (this.lAq != null)) {
      paramBundle.putParcelable("MicroMsg.AppBrandPreLoadingUI.intent", (Parcelable)this.lAq);
    }
    AppMethodBeat.o(51140);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(51133);
    super.onResume();
    ad.i("MicroMsg.AppBrand.AppBrandPreLoadingUI", "onResume: ");
    if (bhq() == 4)
    {
      if (!com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.f.tb(((Number)this.lAy.getValue()).intValue())) {
        break label66;
      }
      overridePendingTransition(0, 0);
    }
    for (;;)
    {
      eh(true);
      AppMethodBeat.o(51133);
      return;
      label66:
      overridePendingTransition(MMFragmentActivity.a.lLF, MMFragmentActivity.a.lLG);
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"kotlin/properties/Delegates$observable$1", "Lkotlin/properties/ObservableProperty;", "afterChange", "", "property", "Lkotlin/reflect/KProperty;", "oldValue", "newValue", "(Lkotlin/reflect/KProperty;Ljava/lang/Object;Ljava/lang/Object;)V", "kotlin-stdlib"})
  public static final class a
    extends d.i.b<Boolean>
  {
    public a(Object paramObject1, Object paramObject2, AppBrandPreLoadingUI paramAppBrandPreLoadingUI)
    {
      super();
    }
    
    public final void a(d.l.k<?> paramk, Boolean paramBoolean1, Boolean paramBoolean2)
    {
      AppMethodBeat.i(51117);
      d.g.b.k.h(paramk, "property");
      boolean bool1 = ((Boolean)paramBoolean2).booleanValue();
      boolean bool2 = ((Boolean)paramBoolean1).booleanValue();
      if ((bool1) && (!bool2) && (AppBrandPreLoadingUI.f(jdField_this) != null))
      {
        paramk = jdField_this;
        paramBoolean1 = AppBrandPreLoadingUI.f(jdField_this);
        paramBoolean1 = new com.tencent.mm.hellhoundlib.b.a().bd(paramBoolean1);
        com.tencent.mm.hellhoundlib.a.a.a(paramk, paramBoolean1.adn(), "com/tencent/mm/plugin/appbrand/ui/AppBrandPreLoadingUI$$special$$inlined$observable$1", "afterChange", "(Lkotlin/reflect/KProperty;Ljava/lang/Object;Ljava/lang/Object;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramk.startActivity((Intent)paramBoolean1.lS(0));
        com.tencent.mm.hellhoundlib.a.a.a(paramk, "com/tencent/mm/plugin/appbrand/ui/AppBrandPreLoadingUI$$special$$inlined$observable$1", "afterChange", "(Lkotlin/reflect/KProperty;Ljava/lang/Object;Ljava/lang/Object;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppBrandPreLoadingUI.a(jdField_this, null);
      }
      AppMethodBeat.o(51117);
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/appbrand/ui/AppBrandPreLoadingUI$Companion;", "", "()V", "KEY_SAVED_INTENT", "", "MMKV_KEY", "TAG", "plugin-appbrand-integration_release"})
  public static final class c {}
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "invoke"})
  static final class g
    extends d.g.b.l
    implements d.g.a.a<Integer>
  {
    g(AppBrandPreLoadingUI paramAppBrandPreLoadingUI)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "Lcom/tencent/mm/plugin/appbrand/ui/IAppBrandLoadingSplash;", "invoke"})
  static final class h
    extends d.g.b.l
    implements d.g.a.a<v>
  {
    h(AppBrandPreLoadingUI paramAppBrandPreLoadingUI)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "invoke"})
  static final class i
    extends d.g.b.l
    implements d.g.a.a<Integer>
  {
    i(AppBrandPreLoadingUI paramAppBrandPreLoadingUI)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.AppBrandPreLoadingUI
 * JD-Core Version:    0.7.0.1
 */