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
import com.tencent.luggage.sdk.config.AppBrandInitConfigLU;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.mmdata.rpt.st;
import com.tencent.mm.autogen.mmdata.rpt.st.a;
import com.tencent.mm.plugin.appbrand.app.f;
import com.tencent.mm.plugin.appbrand.ba.c;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfig;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.WxaVersionInfo;
import com.tencent.mm.plugin.appbrand.launching.ab;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.report.model.q;
import com.tencent.mm.plugin.appbrand.report.quality.QualitySession;
import com.tencent.mm.plugin.appbrand.ui.wxa_container.AppBrandContainerFragmentActivity;
import com.tencent.mm.plugin.secdata.ui.MMSecDataFragmentActivity;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatEnvironment;
import com.tencent.mm.ui.MMActivity.a;
import com.tencent.mm.ui.MMFragmentActivity.a;
import com.tencent.xweb.ao;
import kotlin.Metadata;
import kotlin.g.b.aa;
import kotlin.g.b.ai;
import kotlin.g.b.s;
import kotlin.g.b.z;
import kotlin.k;
import kotlin.l.o;

@com.tencent.mm.ui.base.a(7)
@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/ui/AppBrandPreLoadingUI;", "Lcom/tencent/mm/plugin/secdata/ui/MMSecDataFragmentActivity;", "Lcom/tencent/mm/plugin/appbrand/launching/IMMActivityResultInstrumentation;", "()V", "appBrandUIEnterAnimationCompleteEventListener", "Lcom/tencent/mm/plugin/appbrand/ui/AppBrandPreLoadingUI$AppBrandUIEnterAnimationCompleteEventListener;", "appId", "", "appbrandUIFinishEventListener", "Lcom/tencent/mm/plugin/appbrand/ui/AppBrandPreLoadingUI$AppBrandUIFinishEventListener;", "connect", "Lcom/tencent/mm/plugin/appbrand/loading/AppBrandPreLoadingServiceConnection;", "isBindServiceSuccess", "", "isCloseByUser", "<set-?>", "isForeground", "()Z", "setForeground", "(Z)V", "isForeground$delegate", "Lkotlin/properties/ReadWriteProperty;", "kv14576", "Lcom/tencent/mm/plugin/appbrand/report/model/kv_14576;", "pendingIntent", "Landroid/content/Intent;", "pendingIntentKey", "", "pendingIntentTask", "Lcom/tencent/mm/plugin/appbrand/loading/PendingIntentTask;", "scene", "getScene", "()I", "scene$delegate", "Lkotlin/Lazy;", "serviceName", "splashView", "Lcom/tencent/mm/plugin/appbrand/ui/IAppBrandLoadingSplash;", "getSplashView", "()Lcom/tencent/mm/plugin/appbrand/ui/IAppBrandLoadingSplash;", "splashView$delegate", "targetUiName", "uiFlavor", "getUiFlavor", "uiFlavor$delegate", "versionInfo", "Lcom/tencent/mm/plugin/appbrand/config/WxaAttributes$WxaVersionInfo;", "attach", "", "intent", "lifecycle", "canStartActivityForResult", "finish", "isNfcFilterEnabled", "isSupportNavigationSwipeBack", "mayRainbowBackgroundForTest", "onBackPressed", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onEnterAnimationComplete", "onNewIntent", "onPause", "onRestoreInstanceState", "onResume", "report", "startActivityForResult", "onActResult", "Lcom/tencent/mm/ui/MMActivity$IMMOnActivityResult;", "requestCode", "tryToInterruptPost", "clearFlags", "flags", "AppBrandUIEnterAnimationCompleteEventListener", "AppBrandUIFinishEventListener", "Companion", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public class AppBrandPreLoadingUI
  extends MMSecDataFragmentActivity
  implements ab
{
  public static final AppBrandPreLoadingUI.a ubE;
  private String appId;
  private final kotlin.j pmx;
  private WxaAttributes.WxaVersionInfo rbC;
  private final kotlin.i.c sQx;
  private String serviceName;
  private int tfj;
  private com.tencent.mm.plugin.appbrand.loading.e ubF;
  private Intent ubG;
  private boolean ubH;
  private boolean ubI;
  private AppBrandPreLoadingUI.AppBrandUIEnterAnimationCompleteEventListener ubJ;
  private AppBrandPreLoadingUI.AppBrandUIFinishEventListener ubK;
  private q ubL;
  private String ubM;
  private com.tencent.mm.plugin.appbrand.loading.b ubN;
  private final kotlin.j ubO;
  private final kotlin.j ubP;
  
  static
  {
    AppMethodBeat.i(51126);
    aYe = new o[] { (o)ai.a((z)new aa(AppBrandPreLoadingUI.class, "isForeground", "isForeground()Z", 0)) };
    ubE = new AppBrandPreLoadingUI.a((byte)0);
    AppMethodBeat.o(51126);
  }
  
  public AppBrandPreLoadingUI()
  {
    AppMethodBeat.i(51141);
    this.appId = "";
    Object localObject = kotlin.i.a.aixi;
    localObject = Boolean.TRUE;
    this.sQx = ((kotlin.i.c)new f(localObject, localObject, this));
    this.tfj = -1;
    this.serviceName = "";
    this.ubL = new q();
    this.ubM = "";
    this.ubO = k.cm((kotlin.g.a.a)new h(this));
    this.pmx = k.cm((kotlin.g.a.a)new e(this));
    this.ubP = k.cm((kotlin.g.a.a)new g(this));
    AppMethodBeat.o(51141);
  }
  
  private final int cBb()
  {
    AppMethodBeat.i(51128);
    int i = ((Number)this.ubO.getValue()).intValue();
    AppMethodBeat.o(51128);
    return i;
  }
  
  private final ah cLd()
  {
    AppMethodBeat.i(51129);
    ah localah = (ah)this.ubP.getValue();
    AppMethodBeat.o(51129);
    return localah;
  }
  
  private final void cLe()
  {
    AppMethodBeat.i(51137);
    this.ubF = com.tencent.mm.plugin.appbrand.loading.c.tfr.Cf(this.tfj);
    Log.i("MicroMsg.AppBrand.AppBrandPreLoadingUI", "tryToInterruptPost: interrupt #" + this.tfj + " successful");
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
      String str = paramIntent.getStringExtra("MicroMsg.AppBrandPreLoadingLogic.name");
      label39:
      Object localObject2;
      if (str == null)
      {
        str = "";
        Object localObject3 = paramIntent.getStringExtra("MicroMsg.AppBrandPreLoadingLogic.appId");
        localObject2 = localObject3;
        if (localObject3 == null) {
          localObject2 = "";
        }
        this.appId = ((String)localObject2);
        this.rbC = ((WxaAttributes.WxaVersionInfo)paramIntent.getParcelableExtra("MicroMsg.AppBrandPreLoadingLogic.versionInfo"));
        localObject3 = paramIntent.getStringExtra("MicroMsg.AppBrandPreLoadingLogic.targetActivityName");
        localObject2 = localObject3;
        if (localObject3 == null) {
          localObject2 = "";
        }
        this.ubM = ((String)localObject2);
        this.tfj = paramIntent.getIntExtra("MicroMsg.AppBrandPreLoadingLogic.intentKey", -1);
        com.tencent.mm.plugin.appbrand.loading.c.tfr.d(this.tfj, (Context)this);
        localObject2 = com.tencent.mm.plugin.appbrand.loading.c.tfr.Ce(this.tfj);
        if (localObject2 != null) {
          break label552;
        }
        localObject2 = null;
        if (localObject2 != null) {
          ((ap)com.tencent.luggage.a.e.T(ap.class)).a((Activity)this, (AppBrandInitConfig)localObject2);
        }
        localObject2 = this.ubJ;
        if (localObject2 != null) {
          ((AppBrandPreLoadingUI.AppBrandUIEnterAnimationCompleteEventListener)localObject2).dead();
        }
        localObject2 = new AppBrandPreLoadingUI.AppBrandUIEnterAnimationCompleteEventListener(this);
        ((AppBrandPreLoadingUI.AppBrandUIEnterAnimationCompleteEventListener)localObject2).alive();
        localObject3 = kotlin.ah.aiuX;
        this.ubJ = ((AppBrandPreLoadingUI.AppBrandUIEnterAnimationCompleteEventListener)localObject2);
        localObject2 = this.ubK;
        if (localObject2 != null) {
          ((AppBrandPreLoadingUI.AppBrandUIFinishEventListener)localObject2).dead();
        }
        localObject2 = new AppBrandPreLoadingUI.AppBrandUIFinishEventListener(this);
        ((AppBrandPreLoadingUI.AppBrandUIFinishEventListener)localObject2).alive();
        localObject3 = kotlin.ah.aiuX;
        this.ubK = ((AppBrandPreLoadingUI.AppBrandUIFinishEventListener)localObject2);
        localObject2 = paramIntent.getStringExtra("MicroMsg.AppBrandPreLoadingLogic.serviceName");
        paramIntent = (Intent)localObject2;
        if (localObject2 == null) {
          paramIntent = "";
        }
        this.serviceName = paramIntent;
        cLd().eT((String)localObject1, str);
        if ((cLd() instanceof aj)) {
          ((aj)cLd()).av((kotlin.g.a.a)new b(this));
        }
        Log.i("MicroMsg.AppBrand.AppBrandPreLoadingUI", "attach[" + paramString + "]: uiFlavor = " + cBb() + ", iconUrl = " + (String)localObject1 + ", name = " + str);
        paramIntent = new Intent();
        paramIntent.setClassName((Context)this, this.serviceName);
        this.ubN = new com.tencent.mm.plugin.appbrand.loading.b(this.tfj, "MicroMsg.AppBrand.AppBrandPreLoadingUI", (kotlin.g.a.a)new c(this, paramString));
      }
      try
      {
        localObject1 = this.ubN;
        s.checkNotNull(localObject1);
        this.ubI = bindService(paramIntent, (ServiceConnection)localObject1, 65);
        Log.i("MicroMsg.AppBrand.AppBrandPreLoadingUI", "attach[" + paramString + "]: bind " + this.serviceName + " ret = " + this.ubI);
        this.ubL = new q();
        this.ubL.tQo = Util.currentTicks();
        AppMethodBeat.o(175217);
        return;
        continue;
        break label39;
        label552:
        localObject2 = ((com.tencent.mm.plugin.appbrand.loading.e)localObject2).initConfig;
      }
      catch (Exception paramIntent)
      {
        for (;;)
        {
          Log.e("MicroMsg.AppBrand.AppBrandPreLoadingUI", "attach[" + paramString + "]: bindService fail", new Object[] { paramIntent });
        }
      }
    }
  }
  
  private final void setForeground(boolean paramBoolean)
  {
    AppMethodBeat.i(51127);
    this.sQx.a(aYe[0], Boolean.valueOf(paramBoolean));
    AppMethodBeat.o(51127);
  }
  
  public void _$_clearFindViewByIdCache() {}
  
  public final void a(MMActivity.a parama, Intent paramIntent, int paramInt) {}
  
  public final boolean czG()
  {
    return false;
  }
  
  public void finish()
  {
    int j = 1;
    AppMethodBeat.i(51138);
    if ((isFinishing()) || (isDestroyed()))
    {
      AppMethodBeat.o(51138);
      return;
    }
    super.finish();
    Log.i("MicroMsg.AppBrand.AppBrandPreLoadingUI", "finish: isCloseByUser:" + this.ubH + ", appId:" + this.appId);
    Object localObject1;
    if (this.ubH)
    {
      Object localObject3;
      int i;
      if (this.ubF != null)
      {
        localObject1 = this.ubF;
        s.checkNotNull(localObject1);
        localObject1 = ((com.tencent.mm.plugin.appbrand.loading.e)localObject1).initConfig;
        Object localObject2 = this.ubL;
        localObject3 = this.ubF;
        s.checkNotNull(localObject3);
        localObject3 = ((com.tencent.mm.plugin.appbrand.loading.e)localObject3).epn;
        ((q)localObject2).sessionId = ((AppBrandInitConfigLU)localObject1).eoP;
        com.tencent.mm.plugin.appbrand.u.Ux(((AppBrandInitConfigWC)localObject1).appId);
        ((q)localObject2).networkType = com.tencent.mm.plugin.appbrand.report.j.getNetworkType(MMApplicationContext.getContext());
        ((q)localObject2).appId = ((AppBrandInitConfigWC)localObject1).appId;
        ((q)localObject2).appVersion = ((AppBrandInitConfigWC)localObject1).appVersion;
        ((q)localObject2).hzw = ((AppBrandInitConfigWC)localObject1).eul;
        ((q)localObject2).scene = ((AppBrandStatObject)localObject3).scene;
        if (!((q)localObject2).tQp) {
          break label522;
        }
        i = 1;
        ((q)localObject2).tQq = i;
        if (!ao.kgm()) {
          break label527;
        }
        i = j;
        label222:
        ((q)localObject2).tQr = i;
        ((q)localObject2).tQs = Util.ticksToNow(((q)localObject2).tQo);
        ((q)localObject2).tQt = Util.nowMilliSecond();
        ((q)localObject2).username = ((AppBrandInitConfigWC)localObject1).username;
        ((q)localObject2).qMB = ((AppBrandInitConfigWC)localObject1).qYm.apptype;
        ((q)localObject2).eup = ((AppBrandInitConfigWC)localObject1).qYm.eup;
        this.ubL.report();
        localObject2 = ((AppBrandInitConfigWC)localObject1).qYm;
        localObject3 = new st();
        ((st)localObject3).zm(((QualitySession)localObject2).eup);
        ((st)localObject3).zn(((QualitySession)localObject2).appId);
        ((st)localObject3).ind = ((QualitySession)localObject2).tSh;
        ((st)localObject3).jzE = st.a.oO(((QualitySession)localObject2).tQx);
        ((st)localObject3).jax = ((QualitySession)localObject2).apptype;
        ((st)localObject3).iqr = ((QualitySession)localObject2).scene;
        ((st)localObject3).zo(((AppBrandInitConfigWC)localObject1).username);
        ((st)localObject3).jys = 2L;
        ((st)localObject3).jyp = 0L;
        ((st)localObject3).zp(com.tencent.mm.plugin.appbrand.report.j.getNetworkType(MMApplicationContext.getContext()));
        if (!((AppBrandInitConfigLU)localObject1).epl) {
          break label532;
        }
      }
      label522:
      label527:
      label532:
      for (long l = 1L;; l = 0L)
      {
        ((st)localObject3).jzF = l;
        ((st)localObject3).jzG = 2L;
        ((st)localObject3).fM(((AppBrandInitConfigWC)localObject1).startTime);
        ((st)localObject3).aJa();
        ((st)localObject3).fL(((st)localObject3).jyJ - ((st)localObject3).jyI);
        ((st)localObject3).jzH = 0L;
        ((st)localObject3).bMH();
        this.ubF = null;
        if (cBb() != 5) {
          break label537;
        }
        ((ap)com.tencent.luggage.a.e.T(ap.class)).l((Activity)this);
        AppMethodBeat.o(51138);
        return;
        i = 0;
        break;
        i = 0;
        break label222;
      }
      label537:
      if (cBb() == 4)
      {
        super.overridePendingTransition(MMFragmentActivity.a.upW, MMFragmentActivity.a.upX);
        AppMethodBeat.o(51138);
      }
    }
    else
    {
      localObject1 = findViewById(16908290);
      if (localObject1 != null) {
        ((View)localObject1).setVisibility(8);
      }
      super.overridePendingTransition(0, 0);
    }
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
    this.ubH = true;
    cLe();
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
        paramBundle = new com.tencent.mm.hellhoundlib.b.a().cG(paramBundle);
        com.tencent.mm.hellhoundlib.a.a.b(this, paramBundle.aYi(), "com/tencent/mm/plugin/appbrand/ui/AppBrandPreLoadingUI", "onCreate", "(Landroid/os/Bundle;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        startActivity((Intent)paramBundle.sb(0));
        com.tencent.mm.hellhoundlib.a.a.c(this, "com/tencent/mm/plugin/appbrand/ui/AppBrandPreLoadingUI", "onCreate", "(Landroid/os/Bundle;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      }
    }
    paramBundle = new FrameLayout((Context)this);
    setContentView((View)paramBundle);
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-1, -1);
    Object localObject;
    if ((BuildInfo.DEBUG) || (WeChatEnvironment.hasDebugger()) || (BuildInfo.IS_FLAVOR_RED) || (BuildInfo.IS_FLAVOR_PURPLE))
    {
      localObject = f.qBv;
      localObject = f.aBP();
      if ((localObject == null) || (((MultiProcessMMKV)localObject).getBoolean("enable_pre_loading_rainbow", false) != true)) {
        break label335;
      }
    }
    label335:
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        localObject = (kotlin.g.a.a)AppBrandPreLoadingUI.d.ubS;
        cLd().Cj(Color.rgb(((Number)((kotlin.g.a.a)localObject).invoke()).intValue(), ((Number)((kotlin.g.a.a)localObject).invoke()).intValue(), ((Number)((kotlin.g.a.a)localObject).invoke()).intValue()));
      }
      localObject = getIntent();
      s.s(localObject, "intent");
      d((Intent)localObject, "onCreate");
      paramBundle.addView(cLd().getView(), (ViewGroup.LayoutParams)localLayoutParams);
      AppBrandContainerFragmentActivity.e((Activity)this, androidx.core.content.a.w((Context)this, ba.c.BG_1));
      AppMethodBeat.o(51134);
      return;
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(51139);
    super.onDestroy();
    Object localObject = new Intent();
    ((Intent)localObject).setClassName((Context)this, this.serviceName);
    if (this.ubI) {}
    try
    {
      if (this.ubN != null)
      {
        com.tencent.mm.plugin.appbrand.loading.b localb = this.ubN;
        s.checkNotNull(localb);
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
    localObject = this.ubJ;
    if (localObject != null) {
      ((AppBrandPreLoadingUI.AppBrandUIEnterAnimationCompleteEventListener)localObject).dead();
    }
    localObject = this.ubK;
    if (localObject != null) {
      ((AppBrandPreLoadingUI.AppBrandUIFinishEventListener)localObject).dead();
    }
    AppMethodBeat.o(51139);
  }
  
  public void onEnterAnimationComplete()
  {
    AppMethodBeat.i(322372);
    super.onEnterAnimationComplete();
    com.tencent.mm.ui.base.b.a((Activity)this, null);
    AppMethodBeat.o(322372);
  }
  
  public void onNewIntent(Intent paramIntent)
  {
    AppMethodBeat.i(51131);
    super.onNewIntent(paramIntent);
    if (paramIntent == null)
    {
      AppMethodBeat.o(51131);
      return;
    }
    this.ubG = null;
    this.ubH = false;
    d(paramIntent, "onNewIntent");
    AppMethodBeat.o(51131);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(51135);
    super.onPause();
    if (!this.ubH) {
      overridePendingTransition(0, 0);
    }
    setForeground(false);
    AppMethodBeat.o(51135);
  }
  
  public void onRestoreInstanceState(Bundle paramBundle)
  {
    AppMethodBeat.i(51140);
    s.u(paramBundle, "savedInstanceState");
    super.onRestoreInstanceState(paramBundle);
    Log.i("MicroMsg.AppBrand.AppBrandPreLoadingUI", s.X("onRestoreInstanceState: pendingIntent = ", this.ubG));
    if (this.ubG != null) {
      paramBundle.putParcelable("MicroMsg.AppBrandPreLoadingUI.intent", (Parcelable)this.ubG);
    }
    AppMethodBeat.o(51140);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(51133);
    super.onResume();
    setForeground(true);
    AppMethodBeat.o(51133);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends kotlin.g.b.u
    implements kotlin.g.a.a<kotlin.ah>
  {
    b(AppBrandPreLoadingUI paramAppBrandPreLoadingUI)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends kotlin.g.b.u
    implements kotlin.g.a.a<kotlin.ah>
  {
    c(AppBrandPreLoadingUI paramAppBrandPreLoadingUI, String paramString)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class e
    extends kotlin.g.b.u
    implements kotlin.g.a.a<Integer>
  {
    e(AppBrandPreLoadingUI paramAppBrandPreLoadingUI)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"kotlin/properties/Delegates$observable$1", "Lkotlin/properties/ObservableProperty;", "afterChange", "", "property", "Lkotlin/reflect/KProperty;", "oldValue", "newValue", "(Lkotlin/reflect/KProperty;Ljava/lang/Object;Ljava/lang/Object;)V", "kotlin-stdlib"}, k=1, mv={1, 5, 1})
  public static final class f
    extends kotlin.i.b<Boolean>
  {
    public f(Object paramObject1, Object paramObject2, AppBrandPreLoadingUI paramAppBrandPreLoadingUI)
    {
      super();
    }
    
    public final void a(o<?> paramo, Boolean paramBoolean1, Boolean paramBoolean2)
    {
      AppMethodBeat.i(321996);
      s.u(paramo, "property");
      boolean bool1 = ((Boolean)paramBoolean2).booleanValue();
      boolean bool2 = ((Boolean)paramBoolean1).booleanValue();
      if ((bool1) && (!bool2) && (AppBrandPreLoadingUI.f(jdField_this) != null))
      {
        paramo = jdField_this;
        paramBoolean1 = AppBrandPreLoadingUI.f(jdField_this);
        paramBoolean1 = new com.tencent.mm.hellhoundlib.b.a().cG(paramBoolean1);
        com.tencent.mm.hellhoundlib.a.a.b(paramo, paramBoolean1.aYi(), "com/tencent/mm/plugin/appbrand/ui/AppBrandPreLoadingUI$special$$inlined$observable$1", "afterChange", "(Lkotlin/reflect/KProperty;Ljava/lang/Object;Ljava/lang/Object;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramo.startActivity((Intent)paramBoolean1.sb(0));
        com.tencent.mm.hellhoundlib.a.a.c(paramo, "com/tencent/mm/plugin/appbrand/ui/AppBrandPreLoadingUI$special$$inlined$observable$1", "afterChange", "(Lkotlin/reflect/KProperty;Ljava/lang/Object;Ljava/lang/Object;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppBrandPreLoadingUI.a(jdField_this, null);
      }
      AppMethodBeat.o(321996);
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/plugin/appbrand/ui/IAppBrandLoadingSplash;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class g
    extends kotlin.g.b.u
    implements kotlin.g.a.a<ah>
  {
    g(AppBrandPreLoadingUI paramAppBrandPreLoadingUI)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class h
    extends kotlin.g.b.u
    implements kotlin.g.a.a<Integer>
  {
    h(AppBrandPreLoadingUI paramAppBrandPreLoadingUI)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.AppBrandPreLoadingUI
 * JD-Core Version:    0.7.0.1
 */