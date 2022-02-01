package com.tencent.mm.plugin.appbrand.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.mc;
import com.tencent.mm.g.b.a.mc.a;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.WxaVersionInfo;
import com.tencent.mm.plugin.appbrand.report.i;
import com.tencent.mm.plugin.appbrand.report.model.n;
import com.tencent.mm.plugin.appbrand.report.quality.QualitySession;
import com.tencent.mm.plugin.appbrand.ui.wxa_container.BaseAppBrandUIClipped;
import com.tencent.mm.plugin.secdata.ui.MMSecDataFragmentActivity;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.WeChatEnvironment;
import com.tencent.mm.ui.MMActivity.a;
import com.tencent.mm.ui.MMFragmentActivity.a;
import java.util.HashMap;
import kotlin.g.b.aa;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.g.b.v;
import kotlin.l;
import kotlin.l.k;
import kotlin.t;
import kotlin.x;

@com.tencent.mm.ui.base.a(7)
@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/ui/AppBrandPreLoadingUI;", "Lcom/tencent/mm/plugin/secdata/ui/MMSecDataFragmentActivity;", "Lcom/tencent/mm/plugin/appbrand/launching/IMMActivityResultInstrumentation;", "()V", "appBrandUIEnterAnimationCompleteEventListener", "Lcom/tencent/mm/plugin/appbrand/ui/AppBrandPreLoadingUI$AppBrandUIEnterAnimationCompleteEventListener;", "appId", "", "connect", "Lcom/tencent/mm/plugin/appbrand/loading/AppBrandPreLoadingServiceConnection;", "isBindServiceSuccess", "", "isCloseByUser", "<set-?>", "isForeground", "()Z", "setForeground", "(Z)V", "isForeground$delegate", "Lkotlin/properties/ReadWriteProperty;", "kv14576", "Lcom/tencent/mm/plugin/appbrand/report/model/kv_14576;", "pendingIntent", "Landroid/content/Intent;", "pendingIntentKey", "", "pendingIntentTask", "Lcom/tencent/mm/plugin/appbrand/loading/PendingIntentTask;", "scene", "getScene", "()I", "scene$delegate", "Lkotlin/Lazy;", "serviceName", "splashView", "Lcom/tencent/mm/plugin/appbrand/ui/IAppBrandLoadingSplash;", "getSplashView", "()Lcom/tencent/mm/plugin/appbrand/ui/IAppBrandLoadingSplash;", "splashView$delegate", "targetUiName", "uiFlavor", "getUiFlavor", "uiFlavor$delegate", "versionInfo", "Lcom/tencent/mm/plugin/appbrand/config/WxaAttributes$WxaVersionInfo;", "attach", "", "intent", "lifecycle", "canStartActivityForResult", "finish", "isNfcFilterEnabled", "isSupportNavigationSwipeBack", "mayRainbowBackgroundForTest", "onBackPressed", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onNewIntent", "onPause", "onRestoreInstanceState", "onResume", "report", "startActivityForResult", "onActResult", "Lcom/tencent/mm/ui/MMActivity$IMMOnActivityResult;", "requestCode", "tryToInterruptPost", "clearFlags", "flags", "AppBrandUIEnterAnimationCompleteEventListener", "Companion", "plugin-appbrand-integration_release"})
public class AppBrandPreLoadingUI
  extends MMSecDataFragmentActivity
  implements com.tencent.mm.plugin.appbrand.launching.ab
{
  public static final c nUG;
  private HashMap _$_findViewCache;
  private String appId;
  private final kotlin.f jCN;
  private WxaAttributes.WxaVersionInfo lgq;
  private final kotlin.i.c mKK;
  private int mZL;
  private AppBrandPreLoadingUI.b nUA;
  private n nUB;
  private String nUC;
  private com.tencent.mm.plugin.appbrand.loading.b nUD;
  private final kotlin.f nUE;
  private final kotlin.f nUF;
  private com.tencent.mm.plugin.appbrand.loading.e nUw;
  private Intent nUx;
  private boolean nUy;
  private boolean nUz;
  private String serviceName;
  
  static
  {
    AppMethodBeat.i(51126);
    cLI = new k[] { (k)aa.a(new v(aa.bp(AppBrandPreLoadingUI.class), "isForeground", "isForeground()Z")) };
    nUG = new c((byte)0);
    AppMethodBeat.o(51126);
  }
  
  public AppBrandPreLoadingUI()
  {
    AppMethodBeat.i(51141);
    this.appId = "";
    Object localObject = kotlin.i.a.SYL;
    localObject = Boolean.TRUE;
    this.mKK = ((kotlin.i.c)new a(localObject, localObject, this));
    this.mZL = -1;
    this.serviceName = "";
    this.nUB = new n();
    this.nUC = "";
    this.nUE = kotlin.g.ah((kotlin.g.a.a)new AppBrandPreLoadingUI.i(this));
    this.jCN = kotlin.g.ah((kotlin.g.a.a)new AppBrandPreLoadingUI.g(this));
    this.nUF = kotlin.g.ah((kotlin.g.a.a)new h(this));
    AppMethodBeat.o(51141);
  }
  
  private final int bOs()
  {
    AppMethodBeat.i(51128);
    int i = ((Number)this.nUE.getValue()).intValue();
    AppMethodBeat.o(51128);
    return i;
  }
  
  private final ab bXm()
  {
    AppMethodBeat.i(51129);
    ab localab = (ab)this.nUF.getValue();
    AppMethodBeat.o(51129);
    return localab;
  }
  
  private final void bXn()
  {
    AppMethodBeat.i(51137);
    this.nUw = com.tencent.mm.plugin.appbrand.loading.c.mZY.yq(this.mZL);
    Log.i("MicroMsg.AppBrand.AppBrandPreLoadingUI", "tryToInterruptPost: interrupt #" + this.mZL + " successful");
    AppMethodBeat.o(51137);
  }
  
  private final void d(Intent paramIntent, final String paramString)
  {
    AppMethodBeat.i(175217);
    Object localObject1 = paramIntent.getStringExtra("MicroMsg.AppBrandPreLoadingLogic.icon");
    if (localObject1 == null) {
      localObject1 = "";
    }
    for (;;)
    {
      String str1 = paramIntent.getStringExtra("MicroMsg.AppBrandPreLoadingLogic.name");
      if (str1 == null) {
        str1 = "";
      }
      for (;;)
      {
        String str2 = paramIntent.getStringExtra("MicroMsg.AppBrandPreLoadingLogic.appId");
        Object localObject2 = str2;
        if (str2 == null) {
          localObject2 = "";
        }
        this.appId = ((String)localObject2);
        this.lgq = ((WxaAttributes.WxaVersionInfo)paramIntent.getParcelableExtra("MicroMsg.AppBrandPreLoadingLogic.versionInfo"));
        str2 = paramIntent.getStringExtra("MicroMsg.AppBrandPreLoadingLogic.targetActivityName");
        localObject2 = str2;
        if (str2 == null) {
          localObject2 = "";
        }
        this.nUC = ((String)localObject2);
        this.mZL = paramIntent.getIntExtra("MicroMsg.AppBrandPreLoadingLogic.intentKey", -1);
        com.tencent.mm.plugin.appbrand.loading.c.mZY.a(this.mZL, (Context)this);
        localObject2 = this.nUA;
        if (localObject2 != null) {
          ((AppBrandPreLoadingUI.b)localObject2).dead();
        }
        this.nUA = new AppBrandPreLoadingUI.b(this);
        localObject2 = this.nUA;
        if (localObject2 == null) {
          p.hyc();
        }
        ((AppBrandPreLoadingUI.b)localObject2).alive();
        localObject2 = paramIntent.getStringExtra("MicroMsg.AppBrandPreLoadingLogic.serviceName");
        paramIntent = (Intent)localObject2;
        if (localObject2 == null) {
          paramIntent = "";
        }
        this.serviceName = paramIntent;
        bXm().eo((String)localObject1, str1);
        if ((bXm() instanceof ad))
        {
          paramIntent = bXm();
          if (paramIntent == null)
          {
            paramIntent = new t("null cannot be cast to non-null type com.tencent.mm.plugin.appbrand.ui.IAppBrandLoadingSplashCloseable");
            AppMethodBeat.o(175217);
            throw paramIntent;
          }
          ((ad)paramIntent).C((kotlin.g.a.a)new d(this));
        }
        Log.i("MicroMsg.AppBrand.AppBrandPreLoadingUI", "attach[" + paramString + "]: uiFlavor = " + bOs() + ", iconUrl = " + (String)localObject1 + ", name = " + str1);
        paramIntent = new Intent();
        paramIntent.setClassName((Context)this, this.serviceName);
        this.nUD = new com.tencent.mm.plugin.appbrand.loading.b(this.mZL, "MicroMsg.AppBrand.AppBrandPreLoadingUI", (kotlin.g.a.a)new e(this, paramString));
        try
        {
          localObject1 = this.nUD;
          if (localObject1 == null) {
            p.hyc();
          }
          this.nUz = bindService(paramIntent, (ServiceConnection)localObject1, 65);
          Log.i("MicroMsg.AppBrand.AppBrandPreLoadingUI", "attach[" + paramString + "]: bind " + this.serviceName + " ret = " + this.nUz);
        }
        catch (Exception paramIntent)
        {
          for (;;)
          {
            Log.e("MicroMsg.AppBrand.AppBrandPreLoadingUI", "attach[" + paramString + "]: bindService fail", new Object[] { paramIntent });
          }
        }
        this.nUB = new n();
        this.nUB.bUO();
        AppMethodBeat.o(175217);
        return;
      }
    }
  }
  
  private final void setForeground(boolean paramBoolean)
  {
    AppMethodBeat.i(51127);
    this.mKK.a(cLI[0], Boolean.valueOf(paramBoolean));
    AppMethodBeat.o(51127);
  }
  
  public void _$_clearFindViewByIdCache()
  {
    AppMethodBeat.i(229493);
    if (this._$_findViewCache != null) {
      this._$_findViewCache.clear();
    }
    AppMethodBeat.o(229493);
  }
  
  public View _$_findCachedViewById(int paramInt)
  {
    AppMethodBeat.i(229492);
    if (this._$_findViewCache == null) {
      this._$_findViewCache = new HashMap();
    }
    View localView2 = (View)this._$_findViewCache.get(Integer.valueOf(paramInt));
    View localView1 = localView2;
    if (localView2 == null)
    {
      localView1 = findViewById(paramInt);
      this._$_findViewCache.put(Integer.valueOf(paramInt), localView1);
    }
    AppMethodBeat.o(229492);
    return localView1;
  }
  
  public final void a(MMActivity.a parama, Intent paramIntent, int paramInt) {}
  
  public final boolean bNd()
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
    Log.i("MicroMsg.AppBrand.AppBrandPreLoadingUI", "finish: isCloseByUser:" + this.nUy + ", appId:" + this.appId);
    if (this.nUy)
    {
      Object localObject3;
      if (this.nUw != null)
      {
        localObject1 = this.nUw;
        if (localObject1 == null) {
          p.hyc();
        }
        localObject1 = ((com.tencent.mm.plugin.appbrand.loading.e)localObject1).kEG;
        Object localObject2 = this.nUB;
        localObject3 = this.nUw;
        if (localObject3 == null) {
          p.hyc();
        }
        ((n)localObject2).f((AppBrandInitConfigWC)localObject1, ((com.tencent.mm.plugin.appbrand.loading.e)localObject3).cyA);
        this.nUB.report();
        localObject2 = ((AppBrandInitConfigWC)localObject1).ldW;
        localObject3 = new mc();
        ((mc)localObject3).zp(((QualitySession)localObject2).kEY);
        ((mc)localObject3).zq(((QualitySession)localObject2).appId);
        ((mc)localObject3).vF(((QualitySession)localObject2).nLk);
        ((mc)localObject3).a(mc.a.mq(((QualitySession)localObject2).nJE));
        ((mc)localObject3).vG(((QualitySession)localObject2).apptype);
        ((mc)localObject3).vI(((QualitySession)localObject2).scene);
        ((mc)localObject3).zr(((AppBrandInitConfigWC)localObject1).username);
        ((mc)localObject3).aiY();
        ((mc)localObject3).aiZ();
        ((mc)localObject3).zs(i.getNetworkType(MMApplicationContext.getContext()));
        if (!((AppBrandInitConfigWC)localObject1).Ny()) {
          break label365;
        }
      }
      label365:
      for (long l = 1L;; l = 0L)
      {
        ((mc)localObject3).vK(l);
        ((mc)localObject3).aja();
        ((mc)localObject3).vJ(((AppBrandInitConfigWC)localObject1).startTime);
        ((mc)localObject3).aiX();
        ((mc)localObject3).vH(((mc)localObject3).aiW() - ((mc)localObject3).aiV());
        ((mc)localObject3).ajb();
        ((mc)localObject3).bfK();
        this.nUw = null;
        if (bOs() != 5) {
          break;
        }
        ((ah)com.tencent.luggage.a.e.M(ah.class)).m((Activity)this);
        AppMethodBeat.o(51138);
        return;
      }
      if (bOs() == 4) {
        super.overridePendingTransition(MMFragmentActivity.a.ogo, MMFragmentActivity.a.ogp);
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
  
  public boolean isNfcFilterEnabled()
  {
    return false;
  }
  
  public boolean isSupportNavigationSwipeBack()
  {
    return false;
  }
  
  public void onBackPressed()
  {
    AppMethodBeat.i(51136);
    this.nUy = true;
    bXn();
    Log.i("MicroMsg.AppBrand.AppBrandPreLoadingUI", "onBackPressed: ");
    super.onBackPressed();
    AppMethodBeat.o(51136);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(51134);
    requestWindowFeature(10);
    requestWindowFeature(1);
    super.onCreate(paramBundle);
    if (paramBundle != null)
    {
      paramBundle = (Intent)paramBundle.getParcelable("MicroMsg.AppBrandPreLoadingUI.intent");
      if (paramBundle != null)
      {
        Log.i("MicroMsg.AppBrand.AppBrandPreLoadingUI", "onCreate: saved intent != null");
        paramBundle = new com.tencent.mm.hellhoundlib.b.a().bl(paramBundle);
        com.tencent.mm.hellhoundlib.a.a.a(this, paramBundle.axQ(), "com/tencent/mm/plugin/appbrand/ui/AppBrandPreLoadingUI", "onCreate", "(Landroid/os/Bundle;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        startActivity((Intent)paramBundle.pG(0));
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/ui/AppBrandPreLoadingUI", "onCreate", "(Landroid/os/Bundle;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      }
    }
    paramBundle = new FrameLayout((Context)this);
    setContentView((View)paramBundle);
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-1, -1);
    if ((WeChatEnvironment.hasDebugger()) || (BuildInfo.IS_FLAVOR_RED) || (BuildInfo.IS_FLAVOR_PURPLE))
    {
      localObject = com.tencent.mm.plugin.appbrand.app.f.kIs.VQ();
      if ((localObject != null) && (((MultiProcessMMKV)localObject).getBoolean("enable_pre_loading_rainbow", false) == true))
      {
        localObject = (kotlin.g.a.a)f.nUJ;
        bXm().yu(Color.rgb(((Number)((kotlin.g.a.a)localObject).invoke()).intValue(), ((Number)((kotlin.g.a.a)localObject).invoke()).intValue(), ((Number)((kotlin.g.a.a)localObject).invoke()).intValue()));
      }
    }
    Log.i("MicroMsg.AppBrand.AppBrandPreLoadingUI", "onCreate: ");
    Object localObject = getIntent();
    p.g(localObject, "intent");
    d((Intent)localObject, "onCreate");
    paramBundle.addView(bXm().getView(), (ViewGroup.LayoutParams)localLayoutParams);
    BaseAppBrandUIClipped.d((Activity)this, android.support.v4.content.b.n((Context)this, 2131099649));
    AppMethodBeat.o(51134);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(51139);
    super.onDestroy();
    Object localObject = new Intent();
    ((Intent)localObject).setClassName((Context)this, this.serviceName);
    if (this.nUz) {}
    try
    {
      if (this.nUD != null)
      {
        com.tencent.mm.plugin.appbrand.loading.b localb = this.nUD;
        if (localb == null) {
          p.hyc();
        }
        unbindService((ServiceConnection)localb);
      }
      stopService((Intent)localObject);
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Log.i("MicroMsg.AppBrand.AppBrandPreLoadingUI", "onDestroy: ", new Object[] { localException });
      }
    }
    localObject = this.nUA;
    if (localObject != null) {
      ((AppBrandPreLoadingUI.b)localObject).dead();
    }
    Log.i("MicroMsg.AppBrand.AppBrandPreLoadingUI", "onDestroy: ");
    AppMethodBeat.o(51139);
  }
  
  public void onNewIntent(Intent paramIntent)
  {
    AppMethodBeat.i(51131);
    super.onNewIntent(paramIntent);
    Log.i("MicroMsg.AppBrand.AppBrandPreLoadingUI", "onNewIntent: ");
    if (paramIntent == null)
    {
      AppMethodBeat.o(51131);
      return;
    }
    this.nUx = null;
    this.nUy = false;
    d(paramIntent, "onNewIntent");
    AppMethodBeat.o(51131);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(51135);
    super.onPause();
    Log.i("MicroMsg.AppBrand.AppBrandPreLoadingUI", "onPause: ");
    if (!this.nUy) {
      overridePendingTransition(0, 0);
    }
    setForeground(false);
    AppMethodBeat.o(51135);
  }
  
  public void onRestoreInstanceState(Bundle paramBundle)
  {
    AppMethodBeat.i(51140);
    super.onRestoreInstanceState(paramBundle);
    Log.i("MicroMsg.AppBrand.AppBrandPreLoadingUI", "onRestoreInstanceState: pendingIntent = " + this.nUx);
    if ((paramBundle != null) && (this.nUx != null)) {
      paramBundle.putParcelable("MicroMsg.AppBrandPreLoadingUI.intent", (Parcelable)this.nUx);
    }
    AppMethodBeat.o(51140);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(51133);
    super.onResume();
    Log.i("MicroMsg.AppBrand.AppBrandPreLoadingUI", "onResume: ");
    if (bOs() == 4)
    {
      if (!com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.g.yt(((Number)this.jCN.getValue()).intValue())) {
        break label66;
      }
      overridePendingTransition(0, 0);
    }
    for (;;)
    {
      setForeground(true);
      AppMethodBeat.o(51133);
      return;
      label66:
      overridePendingTransition(MMFragmentActivity.a.ogm, MMFragmentActivity.a.ogn);
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"kotlin/properties/Delegates$observable$1", "Lkotlin/properties/ObservableProperty;", "afterChange", "", "property", "Lkotlin/reflect/KProperty;", "oldValue", "newValue", "(Lkotlin/reflect/KProperty;Ljava/lang/Object;Ljava/lang/Object;)V", "kotlin-stdlib"})
  public static final class a
    extends kotlin.i.b<Boolean>
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
        paramBoolean1 = new com.tencent.mm.hellhoundlib.b.a().bl(paramBoolean1);
        com.tencent.mm.hellhoundlib.a.a.a(paramk, paramBoolean1.axQ(), "com/tencent/mm/plugin/appbrand/ui/AppBrandPreLoadingUI$$special$$inlined$observable$1", "afterChange", "(Lkotlin/reflect/KProperty;Ljava/lang/Object;Ljava/lang/Object;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramk.startActivity((Intent)paramBoolean1.pG(0));
        com.tencent.mm.hellhoundlib.a.a.a(paramk, "com/tencent/mm/plugin/appbrand/ui/AppBrandPreLoadingUI$$special$$inlined$observable$1", "afterChange", "(Lkotlin/reflect/KProperty;Ljava/lang/Object;Ljava/lang/Object;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppBrandPreLoadingUI.a(jdField_this, null);
      }
      AppMethodBeat.o(51117);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/ui/AppBrandPreLoadingUI$Companion;", "", "()V", "KEY_SAVED_INTENT", "", "MMKV_KEY", "TAG", "plugin-appbrand-integration_release"})
  public static final class c {}
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class d
    extends q
    implements kotlin.g.a.a<x>
  {
    d(AppBrandPreLoadingUI paramAppBrandPreLoadingUI)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class e
    extends q
    implements kotlin.g.a.a<x>
  {
    e(AppBrandPreLoadingUI paramAppBrandPreLoadingUI, String paramString)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class f
    extends q
    implements kotlin.g.a.a<Integer>
  {
    public static final f nUJ;
    
    static
    {
      AppMethodBeat.i(51122);
      nUJ = new f();
      AppMethodBeat.o(51122);
    }
    
    f()
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Lcom/tencent/mm/plugin/appbrand/ui/IAppBrandLoadingSplash;", "invoke"})
  static final class h
    extends q
    implements kotlin.g.a.a<ab>
  {
    h(AppBrandPreLoadingUI paramAppBrandPreLoadingUI)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.AppBrandPreLoadingUI
 * JD-Core Version:    0.7.0.1
 */