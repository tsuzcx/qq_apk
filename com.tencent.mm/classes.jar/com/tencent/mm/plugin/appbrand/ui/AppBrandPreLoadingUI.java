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
import com.tencent.mm.g.b.a.hb;
import com.tencent.mm.g.b.a.hb.a;
import com.tencent.mm.plugin.appbrand.app.d;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.WxaVersionInfo;
import com.tencent.mm.plugin.appbrand.launching.ab;
import com.tencent.mm.plugin.appbrand.report.model.n;
import com.tencent.mm.plugin.appbrand.report.quality.QualitySession;
import com.tencent.mm.plugin.appbrand.ui.wxa_container.BaseAppBrandUIClipped;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.aw;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.h;
import com.tencent.mm.ui.MMActivity.a;
import com.tencent.mm.ui.MMBaseActivity;
import com.tencent.mm.ui.MMFragmentActivity.a;
import d.g.b.o;
import d.g.b.w;

@com.tencent.mm.ui.base.a(7)
@d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/appbrand/ui/AppBrandPreLoadingUI;", "Lcom/tencent/mm/ui/MMBaseActivity;", "Lcom/tencent/mm/plugin/appbrand/launching/IMMActivityResultInstrumentation;", "()V", "appBrandUIEnterAnimationCompleteEventListener", "Lcom/tencent/mm/plugin/appbrand/ui/AppBrandPreLoadingUI$AppBrandUIEnterAnimationCompleteEventListener;", "appId", "", "connect", "Lcom/tencent/mm/plugin/appbrand/loading/AppBrandPreLoadingServiceConnection;", "isBindServiceSuccess", "", "isCloseByUser", "<set-?>", "isForeground", "()Z", "setForeground", "(Z)V", "isForeground$delegate", "Lkotlin/properties/ReadWriteProperty;", "kv14576", "Lcom/tencent/mm/plugin/appbrand/report/model/kv_14576;", "pendingIntent", "Landroid/content/Intent;", "pendingIntentKey", "", "pendingIntentTask", "Lcom/tencent/mm/plugin/appbrand/loading/PendingIntentTask;", "scene", "getScene", "()I", "scene$delegate", "Lkotlin/Lazy;", "serviceName", "splashView", "Lcom/tencent/mm/plugin/appbrand/ui/IAppBrandLoadingSplash;", "getSplashView", "()Lcom/tencent/mm/plugin/appbrand/ui/IAppBrandLoadingSplash;", "splashView$delegate", "targetUiName", "uiFlavor", "getUiFlavor", "uiFlavor$delegate", "versionInfo", "Lcom/tencent/mm/plugin/appbrand/config/WxaAttributes$WxaVersionInfo;", "attach", "", "intent", "lifecycle", "canStartActivityForResult", "finish", "mayRainbowBackgroundForTest", "onBackPressed", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onNewIntent", "onPause", "onRestoreInstanceState", "onResume", "report", "startActivityForResult", "onActResult", "Lcom/tencent/mm/ui/MMActivity$IMMOnActivityResult;", "requestCode", "tryToInterruptPost", "clearFlags", "flags", "AppBrandUIEnterAnimationCompleteEventListener", "Companion", "plugin-appbrand-integration_release"})
public class AppBrandPreLoadingUI
  extends MMBaseActivity
  implements ab
{
  public static final c mcw;
  private String appId;
  private WxaAttributes.WxaVersionInfo jFp;
  private final d.i.c lbE;
  private int lqm;
  private String lxF;
  private com.tencent.mm.plugin.appbrand.loading.e mcl;
  private Intent mcm;
  private boolean mcn;
  private boolean mco;
  private AppBrandPreLoadingUI.b mcp;
  private n mcq;
  private String mcr;
  private com.tencent.mm.plugin.appbrand.loading.b mcs;
  private final d.f mct;
  private final d.f mcu;
  private final d.f mcv;
  
  static
  {
    AppMethodBeat.i(51126);
    $$delegatedProperties = new d.l.k[] { (d.l.k)w.a(new o(w.bn(AppBrandPreLoadingUI.class), "isForeground", "isForeground()Z")), (d.l.k)w.a(new d.g.b.u(w.bn(AppBrandPreLoadingUI.class), "uiFlavor", "getUiFlavor()I")), (d.l.k)w.a(new d.g.b.u(w.bn(AppBrandPreLoadingUI.class), "scene", "getScene()I")), (d.l.k)w.a(new d.g.b.u(w.bn(AppBrandPreLoadingUI.class), "splashView", "getSplashView()Lcom/tencent/mm/plugin/appbrand/ui/IAppBrandLoadingSplash;")) };
    mcw = new c((byte)0);
    AppMethodBeat.o(51126);
  }
  
  public AppBrandPreLoadingUI()
  {
    AppMethodBeat.i(51141);
    this.appId = "";
    Object localObject = d.i.a.KUU;
    localObject = Boolean.TRUE;
    this.lbE = ((d.i.c)new a(localObject, localObject, this));
    this.lqm = -1;
    this.lxF = "";
    this.mcq = new n();
    this.mcr = "";
    this.mct = d.g.K((d.g.a.a)new i(this));
    this.mcu = d.g.K((d.g.a.a)new g(this));
    this.mcv = d.g.K((d.g.a.a)new h(this));
    AppMethodBeat.o(51141);
  }
  
  private final int bok()
  {
    AppMethodBeat.i(51128);
    int i = ((Number)this.mct.getValue()).intValue();
    AppMethodBeat.o(51128);
    return i;
  }
  
  private final u bvm()
  {
    AppMethodBeat.i(51129);
    u localu = (u)this.mcv.getValue();
    AppMethodBeat.o(51129);
    return localu;
  }
  
  private final void bvn()
  {
    AppMethodBeat.i(51137);
    this.mcl = com.tencent.mm.plugin.appbrand.loading.c.lqz.tP(this.lqm);
    ac.i("MicroMsg.AppBrand.AppBrandPreLoadingUI", "tryToInterruptPost: interrupt #" + this.lqm + " successful");
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
        this.jFp = ((WxaAttributes.WxaVersionInfo)paramIntent.getParcelableExtra("MicroMsg.AppBrandPreLoadingLogic.versionInfo"));
        str3 = paramIntent.getStringExtra("MicroMsg.AppBrandPreLoadingLogic.targetActivityName");
        localObject = str3;
        if (str3 == null) {
          localObject = "";
        }
        this.mcr = ((String)localObject);
        this.lqm = paramIntent.getIntExtra("MicroMsg.AppBrandPreLoadingLogic.intentKey", -1);
        com.tencent.mm.plugin.appbrand.loading.c.lqz.a(this.lqm, (Context)this);
        localObject = this.mcp;
        if (localObject != null) {
          ((AppBrandPreLoadingUI.b)localObject).dead();
        }
        this.mcp = new AppBrandPreLoadingUI.b(this);
        localObject = this.mcp;
        if (localObject == null) {
          d.g.b.k.fOy();
        }
        ((AppBrandPreLoadingUI.b)localObject).alive();
        localObject = paramIntent.getStringExtra("MicroMsg.AppBrandPreLoadingLogic.serviceName");
        paramIntent = (Intent)localObject;
        if (localObject == null) {
          paramIntent = "";
        }
        this.lxF = paramIntent;
        bvm().dN(str1, str2);
        if ((bvm() instanceof v))
        {
          paramIntent = bvm();
          if (paramIntent == null)
          {
            paramIntent = new d.v("null cannot be cast to non-null type com.tencent.mm.plugin.appbrand.ui.IAppBrandLoadingSplashCloseable");
            AppMethodBeat.o(175217);
            throw paramIntent;
          }
          ((v)paramIntent).u((d.g.a.a)new AppBrandPreLoadingUI.d(this));
        }
        ac.i("MicroMsg.AppBrand.AppBrandPreLoadingUI", "attach[" + paramString + "]: uiFlavor = " + bok() + ", iconUrl = " + str1 + ", name = " + str2);
        paramIntent = new Intent();
        paramIntent.setClassName((Context)this, this.lxF);
        this.mcs = new com.tencent.mm.plugin.appbrand.loading.b(this.lqm, "MicroMsg.AppBrand.AppBrandPreLoadingUI", (d.g.a.a)new AppBrandPreLoadingUI.e(this, paramString));
        try
        {
          this.mco = bindService(paramIntent, (ServiceConnection)this.mcs, 65);
          ac.i("MicroMsg.AppBrand.AppBrandPreLoadingUI", "attach[" + paramString + "]: bind " + this.lxF + " ret = " + this.mco);
          this.mcq = new n();
          this.mcq.bty();
          AppMethodBeat.o(175217);
          return;
        }
        catch (Exception paramIntent)
        {
          for (;;)
          {
            ac.e("MicroMsg.AppBrand.AppBrandPreLoadingUI", "attach[" + paramString + "]: bindService fail", new Object[] { paramIntent });
          }
        }
      }
    }
  }
  
  private final void eC(boolean paramBoolean)
  {
    AppMethodBeat.i(51127);
    this.lbE.a($$delegatedProperties[0], Boolean.valueOf(paramBoolean));
    AppMethodBeat.o(51127);
  }
  
  public final void a(MMActivity.a parama, Intent paramIntent, int paramInt) {}
  
  public final boolean bmX()
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
    ac.i("MicroMsg.AppBrand.AppBrandPreLoadingUI", "finish: isCloseByUser:" + this.mcn + ", appId:" + this.appId);
    if (this.mcn)
    {
      Object localObject3;
      if (this.mcl != null)
      {
        localObject1 = this.mcl;
        if (localObject1 == null) {
          d.g.b.k.fOy();
        }
        localObject1 = ((com.tencent.mm.plugin.appbrand.loading.e)localObject1).liu;
        Object localObject2 = this.mcq;
        localObject3 = this.mcl;
        if (localObject3 == null) {
          d.g.b.k.fOy();
        }
        ((n)localObject2).e((AppBrandInitConfigWC)localObject1, ((com.tencent.mm.plugin.appbrand.loading.e)localObject3).ccl);
        this.mcq.report();
        localObject2 = ((AppBrandInitConfigWC)localObject1).jDH;
        localObject3 = new hb();
        ((hb)localObject3).on(((QualitySession)localObject2).lht);
        ((hb)localObject3).oo(((QualitySession)localObject2).appId);
        ((hb)localObject3).lL(((QualitySession)localObject2).lVs);
        ((hb)localObject3).a(hb.a.iQ(((QualitySession)localObject2).lTR));
        ((hb)localObject3).lM(((QualitySession)localObject2).apptype);
        ((hb)localObject3).lO(((QualitySession)localObject2).scene);
        ((hb)localObject3).op(((AppBrandInitConfigWC)localObject1).username);
        ((hb)localObject3).SN();
        ((hb)localObject3).SO();
        ((hb)localObject3).oq(com.tencent.mm.plugin.appbrand.report.g.getNetworkType(ai.getContext()));
        if (!((AppBrandInitConfigWC)localObject1).CA()) {
          break label365;
        }
      }
      label365:
      for (long l = 1L;; l = 0L)
      {
        ((hb)localObject3).lQ(l);
        ((hb)localObject3).SP();
        ((hb)localObject3).lP(((AppBrandInitConfigWC)localObject1).startTime);
        ((hb)localObject3).SM();
        ((hb)localObject3).lN(((hb)localObject3).SL() - ((hb)localObject3).SK());
        ((hb)localObject3).SQ();
        ((hb)localObject3).aHZ();
        this.mcl = null;
        if (bok() != 5) {
          break;
        }
        ((y)com.tencent.luggage.a.e.K(y.class)).m((Activity)this);
        AppMethodBeat.o(51138);
        return;
      }
      if (bok() == 4) {
        super.overridePendingTransition(MMFragmentActivity.a.mnE, MMFragmentActivity.a.mnF);
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
    this.mcn = true;
    bvn();
    ac.i("MicroMsg.AppBrand.AppBrandPreLoadingUI", "onBackPressed: ");
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
        ac.i("MicroMsg.AppBrand.AppBrandPreLoadingUI", "onCreate: saved intent != null");
        paramBundle = new com.tencent.mm.hellhoundlib.b.a().ba(paramBundle);
        com.tencent.mm.hellhoundlib.a.a.a(this, paramBundle.aeD(), "com/tencent/mm/plugin/appbrand/ui/AppBrandPreLoadingUI", "onCreate", "(Landroid/os/Bundle;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        startActivity((Intent)paramBundle.lR(0));
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/ui/AppBrandPreLoadingUI", "onCreate", "(Landroid/os/Bundle;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      }
    }
    requestWindowFeature(10);
    requestWindowFeature(1);
    paramBundle = new FrameLayout((Context)this);
    setContentView((View)paramBundle);
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-1, -1);
    if ((bt.eWo()) || (h.IS_FLAVOR_RED) || (h.IS_FLAVOR_PURPLE))
    {
      localObject = d.jjJ;
      localObject = d.JW();
      if ((localObject != null) && (((aw)localObject).getBoolean("enable_pre_loading_rainbow", false) == true))
      {
        localObject = (d.g.a.a)AppBrandPreLoadingUI.f.mcz;
        bvm().tT(Color.rgb(((Number)((d.g.a.a)localObject).invoke()).intValue(), ((Number)((d.g.a.a)localObject).invoke()).intValue(), ((Number)((d.g.a.a)localObject).invoke()).intValue()));
      }
    }
    ac.i("MicroMsg.AppBrand.AppBrandPreLoadingUI", "onCreate: ");
    Object localObject = getIntent();
    d.g.b.k.g(localObject, "intent");
    d((Intent)localObject, "onCreate");
    paramBundle.addView(bvm().getView(), (ViewGroup.LayoutParams)localLayoutParams);
    BaseAppBrandUIClipped.d((Activity)this, android.support.v4.content.b.n((Context)this, 2131099649));
    AppMethodBeat.o(51134);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(51139);
    super.onDestroy();
    Object localObject = new Intent();
    ((Intent)localObject).setClassName((Context)this, this.lxF);
    if (this.mco) {}
    try
    {
      if (this.mcs != null) {
        unbindService((ServiceConnection)this.mcs);
      }
      stopService((Intent)localObject);
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ac.i("MicroMsg.AppBrand.AppBrandPreLoadingUI", "onDestroy: ", new Object[] { localException });
      }
    }
    localObject = this.mcp;
    if (localObject != null) {
      ((AppBrandPreLoadingUI.b)localObject).dead();
    }
    ac.i("MicroMsg.AppBrand.AppBrandPreLoadingUI", "onDestroy: ");
    AppMethodBeat.o(51139);
  }
  
  public void onNewIntent(Intent paramIntent)
  {
    AppMethodBeat.i(51131);
    super.onNewIntent(paramIntent);
    ac.i("MicroMsg.AppBrand.AppBrandPreLoadingUI", "onNewIntent: ");
    if (paramIntent == null)
    {
      AppMethodBeat.o(51131);
      return;
    }
    this.mcm = null;
    this.mcn = false;
    d(paramIntent, "onNewIntent");
    AppMethodBeat.o(51131);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(51135);
    super.onPause();
    ac.i("MicroMsg.AppBrand.AppBrandPreLoadingUI", "onPause: ");
    if (!this.mcn) {
      overridePendingTransition(0, 0);
    }
    eC(false);
    AppMethodBeat.o(51135);
  }
  
  protected void onRestoreInstanceState(Bundle paramBundle)
  {
    AppMethodBeat.i(51140);
    super.onRestoreInstanceState(paramBundle);
    ac.i("MicroMsg.AppBrand.AppBrandPreLoadingUI", "onRestoreInstanceState: pendingIntent = " + this.mcm);
    if ((paramBundle != null) && (this.mcm != null)) {
      paramBundle.putParcelable("MicroMsg.AppBrandPreLoadingUI.intent", (Parcelable)this.mcm);
    }
    AppMethodBeat.o(51140);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(51133);
    super.onResume();
    ac.i("MicroMsg.AppBrand.AppBrandPreLoadingUI", "onResume: ");
    if (bok() == 4)
    {
      if (!com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.f.tS(((Number)this.mcu.getValue()).intValue())) {
        break label66;
      }
      overridePendingTransition(0, 0);
    }
    for (;;)
    {
      eC(true);
      AppMethodBeat.o(51133);
      return;
      label66:
      overridePendingTransition(MMFragmentActivity.a.mnC, MMFragmentActivity.a.mnD);
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"kotlin/properties/Delegates$observable$1", "Lkotlin/properties/ObservableProperty;", "afterChange", "", "property", "Lkotlin/reflect/KProperty;", "oldValue", "newValue", "(Lkotlin/reflect/KProperty;Ljava/lang/Object;Ljava/lang/Object;)V", "kotlin-stdlib"})
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
        paramBoolean1 = new com.tencent.mm.hellhoundlib.b.a().ba(paramBoolean1);
        com.tencent.mm.hellhoundlib.a.a.a(paramk, paramBoolean1.aeD(), "com/tencent/mm/plugin/appbrand/ui/AppBrandPreLoadingUI$$special$$inlined$observable$1", "afterChange", "(Lkotlin/reflect/KProperty;Ljava/lang/Object;Ljava/lang/Object;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramk.startActivity((Intent)paramBoolean1.lR(0));
        com.tencent.mm.hellhoundlib.a.a.a(paramk, "com/tencent/mm/plugin/appbrand/ui/AppBrandPreLoadingUI$$special$$inlined$observable$1", "afterChange", "(Lkotlin/reflect/KProperty;Ljava/lang/Object;Ljava/lang/Object;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppBrandPreLoadingUI.a(jdField_this, null);
      }
      AppMethodBeat.o(51117);
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/appbrand/ui/AppBrandPreLoadingUI$Companion;", "", "()V", "KEY_SAVED_INTENT", "", "MMKV_KEY", "TAG", "plugin-appbrand-integration_release"})
  public static final class c {}
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "invoke"})
  static final class g
    extends d.g.b.l
    implements d.g.a.a<Integer>
  {
    g(AppBrandPreLoadingUI paramAppBrandPreLoadingUI)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "Lcom/tencent/mm/plugin/appbrand/ui/IAppBrandLoadingSplash;", "invoke"})
  static final class h
    extends d.g.b.l
    implements d.g.a.a<u>
  {
    h(AppBrandPreLoadingUI paramAppBrandPreLoadingUI)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "invoke"})
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.AppBrandPreLoadingUI
 * JD-Core Version:    0.7.0.1
 */