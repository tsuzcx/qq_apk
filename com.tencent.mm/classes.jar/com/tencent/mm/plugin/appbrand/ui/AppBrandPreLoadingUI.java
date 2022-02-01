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
import com.tencent.mm.g.b.a.if;
import com.tencent.mm.g.b.a.if.a;
import com.tencent.mm.plugin.appbrand.app.d;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.WxaVersionInfo;
import com.tencent.mm.plugin.appbrand.launching.ab;
import com.tencent.mm.plugin.appbrand.report.h;
import com.tencent.mm.plugin.appbrand.report.model.n;
import com.tencent.mm.plugin.appbrand.report.quality.QualitySession;
import com.tencent.mm.plugin.appbrand.ui.wxa_container.BaseAppBrandUIClipped;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ax;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.sdk.platformtools.i;
import com.tencent.mm.ui.MMActivity.a;
import com.tencent.mm.ui.MMBaseActivity;
import com.tencent.mm.ui.MMFragmentActivity.a;
import d.f;
import d.g.b.p;
import d.g.b.q;
import d.g.b.u;
import d.g.b.z;
import d.l;
import d.l.k;

@com.tencent.mm.ui.base.a(7)
@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/appbrand/ui/AppBrandPreLoadingUI;", "Lcom/tencent/mm/ui/MMBaseActivity;", "Lcom/tencent/mm/plugin/appbrand/launching/IMMActivityResultInstrumentation;", "()V", "appBrandUIEnterAnimationCompleteEventListener", "Lcom/tencent/mm/plugin/appbrand/ui/AppBrandPreLoadingUI$AppBrandUIEnterAnimationCompleteEventListener;", "appId", "", "connect", "Lcom/tencent/mm/plugin/appbrand/loading/AppBrandPreLoadingServiceConnection;", "isBindServiceSuccess", "", "isCloseByUser", "<set-?>", "isForeground", "()Z", "setForeground", "(Z)V", "isForeground$delegate", "Lkotlin/properties/ReadWriteProperty;", "kv14576", "Lcom/tencent/mm/plugin/appbrand/report/model/kv_14576;", "pendingIntent", "Landroid/content/Intent;", "pendingIntentKey", "", "pendingIntentTask", "Lcom/tencent/mm/plugin/appbrand/loading/PendingIntentTask;", "scene", "getScene", "()I", "scene$delegate", "Lkotlin/Lazy;", "serviceName", "splashView", "Lcom/tencent/mm/plugin/appbrand/ui/IAppBrandLoadingSplash;", "getSplashView", "()Lcom/tencent/mm/plugin/appbrand/ui/IAppBrandLoadingSplash;", "splashView$delegate", "targetUiName", "uiFlavor", "getUiFlavor", "uiFlavor$delegate", "versionInfo", "Lcom/tencent/mm/plugin/appbrand/config/WxaAttributes$WxaVersionInfo;", "attach", "", "intent", "lifecycle", "canStartActivityForResult", "finish", "mayRainbowBackgroundForTest", "onBackPressed", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onNewIntent", "onPause", "onRestoreInstanceState", "onResume", "report", "startActivityForResult", "onActResult", "Lcom/tencent/mm/ui/MMActivity$IMMOnActivityResult;", "requestCode", "tryToInterruptPost", "clearFlags", "flags", "AppBrandUIEnterAnimationCompleteEventListener", "Companion", "plugin-appbrand-integration_release"})
public class AppBrandPreLoadingUI
  extends MMBaseActivity
  implements ab
{
  public static final AppBrandPreLoadingUI.c mCE;
  private String appId;
  private WxaAttributes.WxaVersionInfo jZu;
  private int lNK;
  private String lWT;
  private final d.i.c lyE;
  private com.tencent.mm.plugin.appbrand.loading.b mCA;
  private final f mCB;
  private final f mCC;
  private final f mCD;
  private com.tencent.mm.plugin.appbrand.loading.e mCt;
  private Intent mCu;
  private boolean mCv;
  private boolean mCw;
  private AppBrandPreLoadingUI.b mCx;
  private n mCy;
  private String mCz;
  
  static
  {
    AppMethodBeat.i(51126);
    cwV = new k[] { (k)z.a(new u(z.bp(AppBrandPreLoadingUI.class), "isForeground", "isForeground()Z")) };
    mCE = new AppBrandPreLoadingUI.c((byte)0);
    AppMethodBeat.o(51126);
  }
  
  public AppBrandPreLoadingUI()
  {
    AppMethodBeat.i(51141);
    this.appId = "";
    Object localObject = d.i.a.MMa;
    localObject = Boolean.TRUE;
    this.lyE = ((d.i.c)new a(localObject, localObject, this));
    this.lNK = -1;
    this.lWT = "";
    this.mCy = new n();
    this.mCz = "";
    this.mCB = d.g.O((d.g.a.a)new i(this));
    this.mCC = d.g.O((d.g.a.a)new g(this));
    this.mCD = d.g.O((d.g.a.a)new h(this));
    AppMethodBeat.o(51141);
  }
  
  private final int bsd()
  {
    AppMethodBeat.i(51128);
    int i = ((Number)this.mCB.getValue()).intValue();
    AppMethodBeat.o(51128);
    return i;
  }
  
  private final v bzs()
  {
    AppMethodBeat.i(51129);
    v localv = (v)this.mCD.getValue();
    AppMethodBeat.o(51129);
    return localv;
  }
  
  private final void bzt()
  {
    AppMethodBeat.i(51137);
    this.mCt = com.tencent.mm.plugin.appbrand.loading.c.lNX.ut(this.lNK);
    ad.i("MicroMsg.AppBrand.AppBrandPreLoadingUI", "tryToInterruptPost: interrupt #" + this.lNK + " successful");
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
        this.jZu = ((WxaAttributes.WxaVersionInfo)paramIntent.getParcelableExtra("MicroMsg.AppBrandPreLoadingLogic.versionInfo"));
        str3 = paramIntent.getStringExtra("MicroMsg.AppBrandPreLoadingLogic.targetActivityName");
        localObject = str3;
        if (str3 == null) {
          localObject = "";
        }
        this.mCz = ((String)localObject);
        this.lNK = paramIntent.getIntExtra("MicroMsg.AppBrandPreLoadingLogic.intentKey", -1);
        com.tencent.mm.plugin.appbrand.loading.c.lNX.a(this.lNK, (Context)this);
        localObject = this.mCx;
        if (localObject != null) {
          ((AppBrandPreLoadingUI.b)localObject).dead();
        }
        this.mCx = new AppBrandPreLoadingUI.b(this);
        localObject = this.mCx;
        if (localObject == null) {
          p.gfZ();
        }
        ((AppBrandPreLoadingUI.b)localObject).alive();
        localObject = paramIntent.getStringExtra("MicroMsg.AppBrandPreLoadingLogic.serviceName");
        paramIntent = (Intent)localObject;
        if (localObject == null) {
          paramIntent = "";
        }
        this.lWT = paramIntent;
        bzs().dV(str1, str2);
        if ((bzs() instanceof x))
        {
          paramIntent = bzs();
          if (paramIntent == null)
          {
            paramIntent = new d.v("null cannot be cast to non-null type com.tencent.mm.plugin.appbrand.ui.IAppBrandLoadingSplashCloseable");
            AppMethodBeat.o(175217);
            throw paramIntent;
          }
          ((x)paramIntent).w((d.g.a.a)new AppBrandPreLoadingUI.d(this));
        }
        ad.i("MicroMsg.AppBrand.AppBrandPreLoadingUI", "attach[" + paramString + "]: uiFlavor = " + bsd() + ", iconUrl = " + str1 + ", name = " + str2);
        paramIntent = new Intent();
        paramIntent.setClassName((Context)this, this.lWT);
        this.mCA = new com.tencent.mm.plugin.appbrand.loading.b(this.lNK, "MicroMsg.AppBrand.AppBrandPreLoadingUI", (d.g.a.a)new AppBrandPreLoadingUI.e(this, paramString));
        try
        {
          this.mCw = bindService(paramIntent, (ServiceConnection)this.mCA, 65);
          ad.i("MicroMsg.AppBrand.AppBrandPreLoadingUI", "attach[" + paramString + "]: bind " + this.lWT + " ret = " + this.mCw);
          this.mCy = new n();
          this.mCy.bxD();
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
  
  private final void eE(boolean paramBoolean)
  {
    AppMethodBeat.i(51127);
    this.lyE.a(cwV[0], Boolean.valueOf(paramBoolean));
    AppMethodBeat.o(51127);
  }
  
  public final void a(MMActivity.a parama, Intent paramIntent, int paramInt) {}
  
  public final boolean bqI()
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
    ad.i("MicroMsg.AppBrand.AppBrandPreLoadingUI", "finish: isCloseByUser:" + this.mCv + ", appId:" + this.appId);
    if (this.mCv)
    {
      Object localObject3;
      if (this.mCt != null)
      {
        localObject1 = this.mCt;
        if (localObject1 == null) {
          p.gfZ();
        }
        localObject1 = ((com.tencent.mm.plugin.appbrand.loading.e)localObject1).lFx;
        Object localObject2 = this.mCy;
        localObject3 = this.mCt;
        if (localObject3 == null) {
          p.gfZ();
        }
        ((n)localObject2).f((AppBrandInitConfigWC)localObject1, ((com.tencent.mm.plugin.appbrand.loading.e)localObject3).cmC);
        this.mCy.report();
        localObject2 = ((AppBrandInitConfigWC)localObject1).jXD;
        localObject3 = new if();
        ((if)localObject3).qR(((QualitySession)localObject2).lEv);
        ((if)localObject3).qS(((QualitySession)localObject2).appId);
        ((if)localObject3).nJ(((QualitySession)localObject2).mvi);
        ((if)localObject3).a(if.a.jm(((QualitySession)localObject2).mtG));
        ((if)localObject3).nK(((QualitySession)localObject2).apptype);
        ((if)localObject3).nM(((QualitySession)localObject2).scene);
        ((if)localObject3).qT(((AppBrandInitConfigWC)localObject1).username);
        ((if)localObject3).Vb();
        ((if)localObject3).Vc();
        ((if)localObject3).qU(h.getNetworkType(aj.getContext()));
        if (!((AppBrandInitConfigWC)localObject1).DZ()) {
          break label365;
        }
      }
      label365:
      for (long l = 1L;; l = 0L)
      {
        ((if)localObject3).nO(l);
        ((if)localObject3).Vd();
        ((if)localObject3).nN(((AppBrandInitConfigWC)localObject1).startTime);
        ((if)localObject3).Va();
        ((if)localObject3).nL(((if)localObject3).UZ() - ((if)localObject3).UY());
        ((if)localObject3).Ve();
        ((if)localObject3).aLk();
        this.mCt = null;
        if (bsd() != 5) {
          break;
        }
        ((aa)com.tencent.luggage.a.e.K(aa.class)).m((Activity)this);
        AppMethodBeat.o(51138);
        return;
      }
      if (bsd() == 4) {
        super.overridePendingTransition(MMFragmentActivity.a.mOg, MMFragmentActivity.a.mOh);
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
    this.mCv = true;
    bzt();
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
        paramBundle = new com.tencent.mm.hellhoundlib.b.a().bc(paramBundle);
        com.tencent.mm.hellhoundlib.a.a.a(this, paramBundle.ahp(), "com/tencent/mm/plugin/appbrand/ui/AppBrandPreLoadingUI", "onCreate", "(Landroid/os/Bundle;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        startActivity((Intent)paramBundle.mq(0));
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/ui/AppBrandPreLoadingUI", "onCreate", "(Landroid/os/Bundle;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      }
    }
    requestWindowFeature(10);
    requestWindowFeature(1);
    paramBundle = new FrameLayout((Context)this);
    setContentView((View)paramBundle);
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-1, -1);
    if ((bu.flY()) || (i.IS_FLAVOR_RED) || (i.IS_FLAVOR_PURPLE))
    {
      localObject = d.jDy;
      localObject = d.Lv();
      if ((localObject != null) && (((ax)localObject).getBoolean("enable_pre_loading_rainbow", false) == true))
      {
        localObject = (d.g.a.a)AppBrandPreLoadingUI.f.mCH;
        bzs().ux(Color.rgb(((Number)((d.g.a.a)localObject).invoke()).intValue(), ((Number)((d.g.a.a)localObject).invoke()).intValue(), ((Number)((d.g.a.a)localObject).invoke()).intValue()));
      }
    }
    ad.i("MicroMsg.AppBrand.AppBrandPreLoadingUI", "onCreate: ");
    Object localObject = getIntent();
    p.g(localObject, "intent");
    d((Intent)localObject, "onCreate");
    paramBundle.addView(bzs().getView(), (ViewGroup.LayoutParams)localLayoutParams);
    BaseAppBrandUIClipped.d((Activity)this, android.support.v4.content.b.n((Context)this, 2131099649));
    AppMethodBeat.o(51134);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(51139);
    super.onDestroy();
    Object localObject = new Intent();
    ((Intent)localObject).setClassName((Context)this, this.lWT);
    if (this.mCw) {}
    try
    {
      if (this.mCA != null) {
        unbindService((ServiceConnection)this.mCA);
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
    localObject = this.mCx;
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
    this.mCu = null;
    this.mCv = false;
    d(paramIntent, "onNewIntent");
    AppMethodBeat.o(51131);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(51135);
    super.onPause();
    ad.i("MicroMsg.AppBrand.AppBrandPreLoadingUI", "onPause: ");
    if (!this.mCv) {
      overridePendingTransition(0, 0);
    }
    eE(false);
    AppMethodBeat.o(51135);
  }
  
  protected void onRestoreInstanceState(Bundle paramBundle)
  {
    AppMethodBeat.i(51140);
    super.onRestoreInstanceState(paramBundle);
    ad.i("MicroMsg.AppBrand.AppBrandPreLoadingUI", "onRestoreInstanceState: pendingIntent = " + this.mCu);
    if ((paramBundle != null) && (this.mCu != null)) {
      paramBundle.putParcelable("MicroMsg.AppBrandPreLoadingUI.intent", (Parcelable)this.mCu);
    }
    AppMethodBeat.o(51140);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(51133);
    super.onResume();
    ad.i("MicroMsg.AppBrand.AppBrandPreLoadingUI", "onResume: ");
    if (bsd() == 4)
    {
      if (!com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.g.uw(((Number)this.mCC.getValue()).intValue())) {
        break label66;
      }
      overridePendingTransition(0, 0);
    }
    for (;;)
    {
      eE(true);
      AppMethodBeat.o(51133);
      return;
      label66:
      overridePendingTransition(MMFragmentActivity.a.mOe, MMFragmentActivity.a.mOf);
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"kotlin/properties/Delegates$observable$1", "Lkotlin/properties/ObservableProperty;", "afterChange", "", "property", "Lkotlin/reflect/KProperty;", "oldValue", "newValue", "(Lkotlin/reflect/KProperty;Ljava/lang/Object;Ljava/lang/Object;)V", "kotlin-stdlib"})
  public static final class a
    extends d.i.b<Boolean>
  {
    public a(Object paramObject1, Object paramObject2, AppBrandPreLoadingUI paramAppBrandPreLoadingUI)
    {
      super();
    }
    
    public final void a(k<?> paramk, Boolean paramBoolean1, Boolean paramBoolean2)
    {
      AppMethodBeat.i(51117);
      p.h(paramk, "property");
      boolean bool1 = ((Boolean)paramBoolean2).booleanValue();
      boolean bool2 = ((Boolean)paramBoolean1).booleanValue();
      if ((bool1) && (!bool2) && (AppBrandPreLoadingUI.f(jdField_this) != null))
      {
        paramk = jdField_this;
        paramBoolean1 = AppBrandPreLoadingUI.f(jdField_this);
        paramBoolean1 = new com.tencent.mm.hellhoundlib.b.a().bc(paramBoolean1);
        com.tencent.mm.hellhoundlib.a.a.a(paramk, paramBoolean1.ahp(), "com/tencent/mm/plugin/appbrand/ui/AppBrandPreLoadingUI$$special$$inlined$observable$1", "afterChange", "(Lkotlin/reflect/KProperty;Ljava/lang/Object;Ljava/lang/Object;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramk.startActivity((Intent)paramBoolean1.mq(0));
        com.tencent.mm.hellhoundlib.a.a.a(paramk, "com/tencent/mm/plugin/appbrand/ui/AppBrandPreLoadingUI$$special$$inlined$observable$1", "afterChange", "(Lkotlin/reflect/KProperty;Ljava/lang/Object;Ljava/lang/Object;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppBrandPreLoadingUI.a(jdField_this, null);
      }
      AppMethodBeat.o(51117);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke"})
  static final class g
    extends q
    implements d.g.a.a<Integer>
  {
    g(AppBrandPreLoadingUI paramAppBrandPreLoadingUI)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "Lcom/tencent/mm/plugin/appbrand/ui/IAppBrandLoadingSplash;", "invoke"})
  static final class h
    extends q
    implements d.g.a.a<v>
  {
    h(AppBrandPreLoadingUI paramAppBrandPreLoadingUI)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke"})
  static final class i
    extends q
    implements d.g.a.a<Integer>
  {
    i(AppBrandPreLoadingUI paramAppBrandPreLoadingUI)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.AppBrandPreLoadingUI
 * JD-Core Version:    0.7.0.1
 */