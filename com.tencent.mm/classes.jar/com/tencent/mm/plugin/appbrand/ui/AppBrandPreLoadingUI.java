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
import com.tencent.mm.g.b.a.ih;
import com.tencent.mm.g.b.a.ih.a;
import com.tencent.mm.plugin.appbrand.app.d;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.WxaVersionInfo;
import com.tencent.mm.plugin.appbrand.report.h;
import com.tencent.mm.plugin.appbrand.report.model.n;
import com.tencent.mm.plugin.appbrand.report.quality.QualitySession;
import com.tencent.mm.plugin.appbrand.ui.wxa_container.BaseAppBrandUIClipped;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.ay;
import com.tencent.mm.sdk.platformtools.bv;
import com.tencent.mm.sdk.platformtools.j;
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
import d.v;

@com.tencent.mm.ui.base.a(7)
@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/appbrand/ui/AppBrandPreLoadingUI;", "Lcom/tencent/mm/ui/MMBaseActivity;", "Lcom/tencent/mm/plugin/appbrand/launching/IMMActivityResultInstrumentation;", "()V", "appBrandUIEnterAnimationCompleteEventListener", "Lcom/tencent/mm/plugin/appbrand/ui/AppBrandPreLoadingUI$AppBrandUIEnterAnimationCompleteEventListener;", "appId", "", "connect", "Lcom/tencent/mm/plugin/appbrand/loading/AppBrandPreLoadingServiceConnection;", "isBindServiceSuccess", "", "isCloseByUser", "<set-?>", "isForeground", "()Z", "setForeground", "(Z)V", "isForeground$delegate", "Lkotlin/properties/ReadWriteProperty;", "kv14576", "Lcom/tencent/mm/plugin/appbrand/report/model/kv_14576;", "pendingIntent", "Landroid/content/Intent;", "pendingIntentKey", "", "pendingIntentTask", "Lcom/tencent/mm/plugin/appbrand/loading/PendingIntentTask;", "scene", "getScene", "()I", "scene$delegate", "Lkotlin/Lazy;", "serviceName", "splashView", "Lcom/tencent/mm/plugin/appbrand/ui/IAppBrandLoadingSplash;", "getSplashView", "()Lcom/tencent/mm/plugin/appbrand/ui/IAppBrandLoadingSplash;", "splashView$delegate", "targetUiName", "uiFlavor", "getUiFlavor", "uiFlavor$delegate", "versionInfo", "Lcom/tencent/mm/plugin/appbrand/config/WxaAttributes$WxaVersionInfo;", "attach", "", "intent", "lifecycle", "canStartActivityForResult", "finish", "mayRainbowBackgroundForTest", "onBackPressed", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onNewIntent", "onPause", "onRestoreInstanceState", "onResume", "report", "startActivityForResult", "onActResult", "Lcom/tencent/mm/ui/MMActivity$IMMOnActivityResult;", "requestCode", "tryToInterruptPost", "clearFlags", "flags", "AppBrandUIEnterAnimationCompleteEventListener", "Companion", "plugin-appbrand-integration_release"})
public class AppBrandPreLoadingUI
  extends MMBaseActivity
  implements com.tencent.mm.plugin.appbrand.launching.ab
{
  public static final c mHJ;
  private String appId;
  private WxaAttributes.WxaVersionInfo kcL;
  private final d.i.c lDc;
  private int lSl;
  private boolean mHA;
  private boolean mHB;
  private AppBrandPreLoadingUI.b mHC;
  private n mHD;
  private String mHE;
  private com.tencent.mm.plugin.appbrand.loading.b mHF;
  private final f mHG;
  private final f mHH;
  private final f mHI;
  private com.tencent.mm.plugin.appbrand.loading.e mHy;
  private Intent mHz;
  private String mbz;
  
  static
  {
    AppMethodBeat.i(51126);
    cxA = new k[] { (k)z.a(new u(z.bp(AppBrandPreLoadingUI.class), "isForeground", "isForeground()Z")) };
    mHJ = new c((byte)0);
    AppMethodBeat.o(51126);
  }
  
  public AppBrandPreLoadingUI()
  {
    AppMethodBeat.i(51141);
    this.appId = "";
    Object localObject = d.i.a.Njd;
    localObject = Boolean.TRUE;
    this.lDc = ((d.i.c)new a(localObject, localObject, this));
    this.lSl = -1;
    this.mbz = "";
    this.mHD = new n();
    this.mHE = "";
    this.mHG = d.g.O((d.g.a.a)new i(this));
    this.mHH = d.g.O((d.g.a.a)new g(this));
    this.mHI = d.g.O((d.g.a.a)new h(this));
    AppMethodBeat.o(51141);
  }
  
  private final w bAn()
  {
    AppMethodBeat.i(51129);
    w localw = (w)this.mHI.getValue();
    AppMethodBeat.o(51129);
    return localw;
  }
  
  private final void bAo()
  {
    AppMethodBeat.i(51137);
    this.mHy = com.tencent.mm.plugin.appbrand.loading.c.lSy.uz(this.lSl);
    ae.i("MicroMsg.AppBrand.AppBrandPreLoadingUI", "tryToInterruptPost: interrupt #" + this.lSl + " successful");
    AppMethodBeat.o(51137);
  }
  
  private final int bsO()
  {
    AppMethodBeat.i(51128);
    int i = ((Number)this.mHG.getValue()).intValue();
    AppMethodBeat.o(51128);
    return i;
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
        this.kcL = ((WxaAttributes.WxaVersionInfo)paramIntent.getParcelableExtra("MicroMsg.AppBrandPreLoadingLogic.versionInfo"));
        str3 = paramIntent.getStringExtra("MicroMsg.AppBrandPreLoadingLogic.targetActivityName");
        localObject = str3;
        if (str3 == null) {
          localObject = "";
        }
        this.mHE = ((String)localObject);
        this.lSl = paramIntent.getIntExtra("MicroMsg.AppBrandPreLoadingLogic.intentKey", -1);
        com.tencent.mm.plugin.appbrand.loading.c.lSy.a(this.lSl, (Context)this);
        localObject = this.mHC;
        if (localObject != null) {
          ((AppBrandPreLoadingUI.b)localObject).dead();
        }
        this.mHC = new AppBrandPreLoadingUI.b(this);
        localObject = this.mHC;
        if (localObject == null) {
          p.gkB();
        }
        ((AppBrandPreLoadingUI.b)localObject).alive();
        localObject = paramIntent.getStringExtra("MicroMsg.AppBrandPreLoadingLogic.serviceName");
        paramIntent = (Intent)localObject;
        if (localObject == null) {
          paramIntent = "";
        }
        this.mbz = paramIntent;
        bAn().dX(str1, str2);
        if ((bAn() instanceof y))
        {
          paramIntent = bAn();
          if (paramIntent == null)
          {
            paramIntent = new v("null cannot be cast to non-null type com.tencent.mm.plugin.appbrand.ui.IAppBrandLoadingSplashCloseable");
            AppMethodBeat.o(175217);
            throw paramIntent;
          }
          ((y)paramIntent).x((d.g.a.a)new AppBrandPreLoadingUI.d(this));
        }
        ae.i("MicroMsg.AppBrand.AppBrandPreLoadingUI", "attach[" + paramString + "]: uiFlavor = " + bsO() + ", iconUrl = " + str1 + ", name = " + str2);
        paramIntent = new Intent();
        paramIntent.setClassName((Context)this, this.mbz);
        this.mHF = new com.tencent.mm.plugin.appbrand.loading.b(this.lSl, "MicroMsg.AppBrand.AppBrandPreLoadingUI", (d.g.a.a)new AppBrandPreLoadingUI.e(this, paramString));
        try
        {
          this.mHB = bindService(paramIntent, (ServiceConnection)this.mHF, 65);
          ae.i("MicroMsg.AppBrand.AppBrandPreLoadingUI", "attach[" + paramString + "]: bind " + this.mbz + " ret = " + this.mHB);
          this.mHD = new n();
          this.mHD.byw();
          AppMethodBeat.o(175217);
          return;
        }
        catch (Exception paramIntent)
        {
          for (;;)
          {
            ae.e("MicroMsg.AppBrand.AppBrandPreLoadingUI", "attach[" + paramString + "]: bindService fail", new Object[] { paramIntent });
          }
        }
      }
    }
  }
  
  private final void eG(boolean paramBoolean)
  {
    AppMethodBeat.i(51127);
    this.lDc.a(cxA[0], Boolean.valueOf(paramBoolean));
    AppMethodBeat.o(51127);
  }
  
  public final void a(MMActivity.a parama, Intent paramIntent, int paramInt) {}
  
  public final boolean brs()
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
    ae.i("MicroMsg.AppBrand.AppBrandPreLoadingUI", "finish: isCloseByUser:" + this.mHA + ", appId:" + this.appId);
    if (this.mHA)
    {
      Object localObject3;
      if (this.mHy != null)
      {
        localObject1 = this.mHy;
        if (localObject1 == null) {
          p.gkB();
        }
        localObject1 = ((com.tencent.mm.plugin.appbrand.loading.e)localObject1).lJW;
        Object localObject2 = this.mHD;
        localObject3 = this.mHy;
        if (localObject3 == null) {
          p.gkB();
        }
        ((n)localObject2).f((AppBrandInitConfigWC)localObject1, ((com.tencent.mm.plugin.appbrand.loading.e)localObject3).cmE);
        this.mHD.report();
        localObject2 = ((AppBrandInitConfigWC)localObject1).kaS;
        localObject3 = new ih();
        ((ih)localObject3).rm(((QualitySession)localObject2).lIU);
        ((ih)localObject3).rn(((QualitySession)localObject2).appId);
        ((ih)localObject3).nV(((QualitySession)localObject2).mAf);
        ((ih)localObject3).a(ih.a.jo(((QualitySession)localObject2).myD));
        ((ih)localObject3).nW(((QualitySession)localObject2).apptype);
        ((ih)localObject3).nY(((QualitySession)localObject2).scene);
        ((ih)localObject3).ro(((AppBrandInitConfigWC)localObject1).username);
        ((ih)localObject3).Vh();
        ((ih)localObject3).Vi();
        ((ih)localObject3).rp(h.getNetworkType(ak.getContext()));
        if (!((AppBrandInitConfigWC)localObject1).Ec()) {
          break label365;
        }
      }
      label365:
      for (long l = 1L;; l = 0L)
      {
        ((ih)localObject3).oa(l);
        ((ih)localObject3).Vj();
        ((ih)localObject3).nZ(((AppBrandInitConfigWC)localObject1).startTime);
        ((ih)localObject3).Vg();
        ((ih)localObject3).nX(((ih)localObject3).Vf() - ((ih)localObject3).Ve());
        ((ih)localObject3).Vk();
        ((ih)localObject3).aLH();
        this.mHy = null;
        if (bsO() != 5) {
          break;
        }
        ((ab)com.tencent.luggage.a.e.K(ab.class)).m((Activity)this);
        AppMethodBeat.o(51138);
        return;
      }
      if (bsO() == 4) {
        super.overridePendingTransition(MMFragmentActivity.a.mTk, MMFragmentActivity.a.mTl);
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
    this.mHA = true;
    bAo();
    ae.i("MicroMsg.AppBrand.AppBrandPreLoadingUI", "onBackPressed: ");
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
        ae.i("MicroMsg.AppBrand.AppBrandPreLoadingUI", "onCreate: saved intent != null");
        paramBundle = new com.tencent.mm.hellhoundlib.b.a().bc(paramBundle);
        com.tencent.mm.hellhoundlib.a.a.a(this, paramBundle.ahE(), "com/tencent/mm/plugin/appbrand/ui/AppBrandPreLoadingUI", "onCreate", "(Landroid/os/Bundle;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        startActivity((Intent)paramBundle.mt(0));
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/ui/AppBrandPreLoadingUI", "onCreate", "(Landroid/os/Bundle;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      }
    }
    requestWindowFeature(10);
    requestWindowFeature(1);
    paramBundle = new FrameLayout((Context)this);
    setContentView((View)paramBundle);
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-1, -1);
    if ((bv.fpT()) || (j.IS_FLAVOR_RED) || (j.IS_FLAVOR_PURPLE))
    {
      localObject = d.jGw;
      localObject = d.LD();
      if ((localObject != null) && (((ay)localObject).getBoolean("enable_pre_loading_rainbow", false) == true))
      {
        localObject = (d.g.a.a)f.mHM;
        bAn().uD(Color.rgb(((Number)((d.g.a.a)localObject).invoke()).intValue(), ((Number)((d.g.a.a)localObject).invoke()).intValue(), ((Number)((d.g.a.a)localObject).invoke()).intValue()));
      }
    }
    ae.i("MicroMsg.AppBrand.AppBrandPreLoadingUI", "onCreate: ");
    Object localObject = getIntent();
    p.g(localObject, "intent");
    d((Intent)localObject, "onCreate");
    paramBundle.addView(bAn().getView(), (ViewGroup.LayoutParams)localLayoutParams);
    BaseAppBrandUIClipped.d((Activity)this, android.support.v4.content.b.n((Context)this, 2131099649));
    AppMethodBeat.o(51134);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(51139);
    super.onDestroy();
    Object localObject = new Intent();
    ((Intent)localObject).setClassName((Context)this, this.mbz);
    if (this.mHB) {}
    try
    {
      if (this.mHF != null) {
        unbindService((ServiceConnection)this.mHF);
      }
      stopService((Intent)localObject);
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ae.i("MicroMsg.AppBrand.AppBrandPreLoadingUI", "onDestroy: ", new Object[] { localException });
      }
    }
    localObject = this.mHC;
    if (localObject != null) {
      ((AppBrandPreLoadingUI.b)localObject).dead();
    }
    ae.i("MicroMsg.AppBrand.AppBrandPreLoadingUI", "onDestroy: ");
    AppMethodBeat.o(51139);
  }
  
  public void onNewIntent(Intent paramIntent)
  {
    AppMethodBeat.i(51131);
    super.onNewIntent(paramIntent);
    ae.i("MicroMsg.AppBrand.AppBrandPreLoadingUI", "onNewIntent: ");
    if (paramIntent == null)
    {
      AppMethodBeat.o(51131);
      return;
    }
    this.mHz = null;
    this.mHA = false;
    d(paramIntent, "onNewIntent");
    AppMethodBeat.o(51131);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(51135);
    super.onPause();
    ae.i("MicroMsg.AppBrand.AppBrandPreLoadingUI", "onPause: ");
    if (!this.mHA) {
      overridePendingTransition(0, 0);
    }
    eG(false);
    AppMethodBeat.o(51135);
  }
  
  protected void onRestoreInstanceState(Bundle paramBundle)
  {
    AppMethodBeat.i(51140);
    super.onRestoreInstanceState(paramBundle);
    ae.i("MicroMsg.AppBrand.AppBrandPreLoadingUI", "onRestoreInstanceState: pendingIntent = " + this.mHz);
    if ((paramBundle != null) && (this.mHz != null)) {
      paramBundle.putParcelable("MicroMsg.AppBrandPreLoadingUI.intent", (Parcelable)this.mHz);
    }
    AppMethodBeat.o(51140);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(51133);
    super.onResume();
    ae.i("MicroMsg.AppBrand.AppBrandPreLoadingUI", "onResume: ");
    if (bsO() == 4)
    {
      if (!com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.g.uC(((Number)this.mHH.getValue()).intValue())) {
        break label66;
      }
      overridePendingTransition(0, 0);
    }
    for (;;)
    {
      eG(true);
      AppMethodBeat.o(51133);
      return;
      label66:
      overridePendingTransition(MMFragmentActivity.a.mTi, MMFragmentActivity.a.mTj);
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"kotlin/properties/Delegates$observable$1", "Lkotlin/properties/ObservableProperty;", "afterChange", "", "property", "Lkotlin/reflect/KProperty;", "oldValue", "newValue", "(Lkotlin/reflect/KProperty;Ljava/lang/Object;Ljava/lang/Object;)V", "kotlin-stdlib"})
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
        com.tencent.mm.hellhoundlib.a.a.a(paramk, paramBoolean1.ahE(), "com/tencent/mm/plugin/appbrand/ui/AppBrandPreLoadingUI$$special$$inlined$observable$1", "afterChange", "(Lkotlin/reflect/KProperty;Ljava/lang/Object;Ljava/lang/Object;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramk.startActivity((Intent)paramBoolean1.mt(0));
        com.tencent.mm.hellhoundlib.a.a.a(paramk, "com/tencent/mm/plugin/appbrand/ui/AppBrandPreLoadingUI$$special$$inlined$observable$1", "afterChange", "(Lkotlin/reflect/KProperty;Ljava/lang/Object;Ljava/lang/Object;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppBrandPreLoadingUI.a(jdField_this, null);
      }
      AppMethodBeat.o(51117);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/appbrand/ui/AppBrandPreLoadingUI$Companion;", "", "()V", "KEY_SAVED_INTENT", "", "MMKV_KEY", "TAG", "plugin-appbrand-integration_release"})
  public static final class c {}
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "invoke"})
  static final class f
    extends q
    implements d.g.a.a<Integer>
  {
    public static final f mHM;
    
    static
    {
      AppMethodBeat.i(51122);
      mHM = new f();
      AppMethodBeat.o(51122);
    }
    
    f()
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "invoke"})
  static final class g
    extends q
    implements d.g.a.a<Integer>
  {
    g(AppBrandPreLoadingUI paramAppBrandPreLoadingUI)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "Lcom/tencent/mm/plugin/appbrand/ui/IAppBrandLoadingSplash;", "invoke"})
  static final class h
    extends q
    implements d.g.a.a<w>
  {
    h(AppBrandPreLoadingUI paramAppBrandPreLoadingUI)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "invoke"})
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.AppBrandPreLoadingUI
 * JD-Core Version:    0.7.0.1
 */