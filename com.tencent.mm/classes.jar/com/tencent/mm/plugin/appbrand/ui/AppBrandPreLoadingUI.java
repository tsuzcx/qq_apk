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
import androidx.fragment.app.FragmentActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.b.a.pa;
import com.tencent.mm.f.b.a.pa.a;
import com.tencent.mm.plugin.appbrand.au.c;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.WxaVersionInfo;
import com.tencent.mm.plugin.appbrand.launching.z;
import com.tencent.mm.plugin.appbrand.loading.b;
import com.tencent.mm.plugin.appbrand.report.j;
import com.tencent.mm.plugin.appbrand.report.quality.QualitySession;
import com.tencent.mm.plugin.appbrand.ui.wxa_container.AppBrandContainerFragmentActivity;
import com.tencent.mm.plugin.secdata.ui.MMSecDataFragmentActivity;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.WeChatEnvironment;
import com.tencent.mm.ui.MMActivity.a;
import com.tencent.mm.ui.MMFragmentActivity.a;
import java.util.HashMap;
import kotlin.g.b.ab;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.g.b.v;
import kotlin.l;
import kotlin.t;

@com.tencent.mm.ui.base.a(7)
@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/ui/AppBrandPreLoadingUI;", "Lcom/tencent/mm/plugin/secdata/ui/MMSecDataFragmentActivity;", "Lcom/tencent/mm/plugin/appbrand/launching/IMMActivityResultInstrumentation;", "()V", "appBrandUIEnterAnimationCompleteEventListener", "Lcom/tencent/mm/plugin/appbrand/ui/AppBrandPreLoadingUI$AppBrandUIEnterAnimationCompleteEventListener;", "appId", "", "connect", "Lcom/tencent/mm/plugin/appbrand/loading/AppBrandPreLoadingServiceConnection;", "isBindServiceSuccess", "", "isCloseByUser", "<set-?>", "isForeground", "()Z", "setForeground", "(Z)V", "isForeground$delegate", "Lkotlin/properties/ReadWriteProperty;", "kv14576", "Lcom/tencent/mm/plugin/appbrand/report/model/kv_14576;", "pendingIntent", "Landroid/content/Intent;", "pendingIntentKey", "", "pendingIntentTask", "Lcom/tencent/mm/plugin/appbrand/loading/PendingIntentTask;", "scene", "getScene", "()I", "scene$delegate", "Lkotlin/Lazy;", "serviceName", "splashView", "Lcom/tencent/mm/plugin/appbrand/ui/IAppBrandLoadingSplash;", "getSplashView", "()Lcom/tencent/mm/plugin/appbrand/ui/IAppBrandLoadingSplash;", "splashView$delegate", "targetUiName", "uiFlavor", "getUiFlavor", "uiFlavor$delegate", "versionInfo", "Lcom/tencent/mm/plugin/appbrand/config/WxaAttributes$WxaVersionInfo;", "attach", "", "intent", "lifecycle", "canStartActivityForResult", "finish", "isNfcFilterEnabled", "isSupportNavigationSwipeBack", "mayRainbowBackgroundForTest", "onBackPressed", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onNewIntent", "onPause", "onRestoreInstanceState", "onResume", "report", "startActivityForResult", "onActResult", "Lcom/tencent/mm/ui/MMActivity$IMMOnActivityResult;", "requestCode", "tryToInterruptPost", "clearFlags", "flags", "AppBrandUIEnterAnimationCompleteEventListener", "Companion", "plugin-appbrand-integration_release"})
public class AppBrandPreLoadingUI
  extends MMSecDataFragmentActivity
  implements z
{
  public static final AppBrandPreLoadingUI.c qWg;
  private HashMap _$_findViewCache;
  private String appId;
  private final kotlin.f mta;
  private WxaAttributes.WxaVersionInfo oaQ;
  private final kotlin.i.c pLC;
  private com.tencent.mm.plugin.appbrand.loading.e qVW;
  private Intent qVX;
  private boolean qVY;
  private boolean qVZ;
  private AppBrandPreLoadingUI.b qWa;
  private com.tencent.mm.plugin.appbrand.report.model.n qWb;
  private String qWc;
  private b qWd;
  private final kotlin.f qWe;
  private final kotlin.f qWf;
  private int qaa;
  private String serviceName;
  
  static
  {
    AppMethodBeat.i(51126);
    cMt = new kotlin.l.n[] { (kotlin.l.n)ab.a(new v(ab.bO(AppBrandPreLoadingUI.class), "isForeground", "isForeground()Z")) };
    qWg = new AppBrandPreLoadingUI.c((byte)0);
    AppMethodBeat.o(51126);
  }
  
  public AppBrandPreLoadingUI()
  {
    AppMethodBeat.i(51141);
    this.appId = "";
    Object localObject = kotlin.i.a.aaBH;
    localObject = Boolean.TRUE;
    this.pLC = ((kotlin.i.c)new AppBrandPreLoadingUI.a(localObject, localObject, this));
    this.qaa = -1;
    this.serviceName = "";
    this.qWb = new com.tencent.mm.plugin.appbrand.report.model.n();
    this.qWc = "";
    this.qWe = kotlin.g.ar((kotlin.g.a.a)new AppBrandPreLoadingUI.i(this));
    this.mta = kotlin.g.ar((kotlin.g.a.a)new AppBrandPreLoadingUI.g(this));
    this.qWf = kotlin.g.ar((kotlin.g.a.a)new h(this));
    AppMethodBeat.o(51141);
  }
  
  private final int cjQ()
  {
    AppMethodBeat.i(51128);
    int i = ((Number)this.qWe.getValue()).intValue();
    AppMethodBeat.o(51128);
    return i;
  }
  
  private final aa cjR()
  {
    AppMethodBeat.i(51129);
    aa localaa = (aa)this.qWf.getValue();
    AppMethodBeat.o(51129);
    return localaa;
  }
  
  private final void cjS()
  {
    AppMethodBeat.i(51137);
    this.qVW = com.tencent.mm.plugin.appbrand.loading.c.qan.BQ(this.qaa);
    Log.i("MicroMsg.AppBrand.AppBrandPreLoadingUI", "tryToInterruptPost: interrupt #" + this.qaa + " successful");
    AppMethodBeat.o(51137);
  }
  
  private final void d(Intent paramIntent, String paramString)
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
        this.oaQ = ((WxaAttributes.WxaVersionInfo)paramIntent.getParcelableExtra("MicroMsg.AppBrandPreLoadingLogic.versionInfo"));
        str2 = paramIntent.getStringExtra("MicroMsg.AppBrandPreLoadingLogic.targetActivityName");
        localObject2 = str2;
        if (str2 == null) {
          localObject2 = "";
        }
        this.qWc = ((String)localObject2);
        this.qaa = paramIntent.getIntExtra("MicroMsg.AppBrandPreLoadingLogic.intentKey", -1);
        com.tencent.mm.plugin.appbrand.loading.c.qan.b(this.qaa, (Context)this);
        localObject2 = this.qWa;
        if (localObject2 != null) {
          ((AppBrandPreLoadingUI.b)localObject2).dead();
        }
        this.qWa = new AppBrandPreLoadingUI.b(this);
        localObject2 = this.qWa;
        if (localObject2 == null) {
          p.iCn();
        }
        ((AppBrandPreLoadingUI.b)localObject2).alive();
        localObject2 = paramIntent.getStringExtra("MicroMsg.AppBrandPreLoadingLogic.serviceName");
        paramIntent = (Intent)localObject2;
        if (localObject2 == null) {
          paramIntent = "";
        }
        this.serviceName = paramIntent;
        cjR().eC((String)localObject1, str1);
        if ((cjR() instanceof ac))
        {
          paramIntent = cjR();
          if (paramIntent == null)
          {
            paramIntent = new t("null cannot be cast to non-null type com.tencent.mm.plugin.appbrand.ui.IAppBrandLoadingSplashCloseable");
            AppMethodBeat.o(175217);
            throw paramIntent;
          }
          ((ac)paramIntent).A((kotlin.g.a.a)new AppBrandPreLoadingUI.d(this));
        }
        Log.i("MicroMsg.AppBrand.AppBrandPreLoadingUI", "attach[" + paramString + "]: uiFlavor = " + cjQ() + ", iconUrl = " + (String)localObject1 + ", name = " + str1);
        paramIntent = new Intent();
        paramIntent.setClassName((Context)this, this.serviceName);
        this.qWd = new b(this.qaa, "MicroMsg.AppBrand.AppBrandPreLoadingUI", (kotlin.g.a.a)new AppBrandPreLoadingUI.e(this, paramString));
        try
        {
          localObject1 = this.qWd;
          if (localObject1 == null) {
            p.iCn();
          }
          this.qVZ = bindService(paramIntent, (ServiceConnection)localObject1, 65);
          Log.i("MicroMsg.AppBrand.AppBrandPreLoadingUI", "attach[" + paramString + "]: bind " + this.serviceName + " ret = " + this.qVZ);
        }
        catch (Exception paramIntent)
        {
          for (;;)
          {
            Log.e("MicroMsg.AppBrand.AppBrandPreLoadingUI", "attach[" + paramString + "]: bindService fail", new Object[] { paramIntent });
          }
        }
        this.qWb = new com.tencent.mm.plugin.appbrand.report.model.n();
        this.qWb.chZ();
        AppMethodBeat.o(175217);
        return;
      }
    }
  }
  
  private final void setForeground(boolean paramBoolean)
  {
    AppMethodBeat.i(51127);
    this.pLC.a(cMt[0], Boolean.valueOf(paramBoolean));
    AppMethodBeat.o(51127);
  }
  
  public void _$_clearFindViewByIdCache()
  {
    AppMethodBeat.i(279081);
    if (this._$_findViewCache != null) {
      this._$_findViewCache.clear();
    }
    AppMethodBeat.o(279081);
  }
  
  public View _$_findCachedViewById(int paramInt)
  {
    AppMethodBeat.i(279080);
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
    AppMethodBeat.o(279080);
    return localView1;
  }
  
  public final void a(MMActivity.a parama, Intent paramIntent, int paramInt) {}
  
  public final boolean bZv()
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
    Log.i("MicroMsg.AppBrand.AppBrandPreLoadingUI", "finish: isCloseByUser:" + this.qVY + ", appId:" + this.appId);
    if (this.qVY)
    {
      Object localObject3;
      if (this.qVW != null)
      {
        localObject1 = this.qVW;
        if (localObject1 == null) {
          p.iCn();
        }
        localObject1 = ((com.tencent.mm.plugin.appbrand.loading.e)localObject1).nyg;
        Object localObject2 = this.qWb;
        localObject3 = this.qVW;
        if (localObject3 == null) {
          p.iCn();
        }
        ((com.tencent.mm.plugin.appbrand.report.model.n)localObject2).f((AppBrandInitConfigWC)localObject1, ((com.tencent.mm.plugin.appbrand.loading.e)localObject3).cxf);
        this.qWb.report();
        localObject2 = ((AppBrandInitConfigWC)localObject1).nYk;
        localObject3 = new pa();
        ((pa)localObject3).FV(((QualitySession)localObject2).cBH);
        ((pa)localObject3).FW(((QualitySession)localObject2).appId);
        ((pa)localObject3).BA(((QualitySession)localObject2).qNx);
        ((pa)localObject3).a(pa.a.oB(((QualitySession)localObject2).qLQ));
        ((pa)localObject3).BB(((QualitySession)localObject2).apptype);
        ((pa)localObject3).BD(((QualitySession)localObject2).scene);
        ((pa)localObject3).FX(((AppBrandInitConfigWC)localObject1).username);
        ((pa)localObject3).aoG();
        ((pa)localObject3).aoH();
        ((pa)localObject3).FY(j.getNetworkType(MMApplicationContext.getContext()));
        if (!((AppBrandInitConfigWC)localObject1).Qt()) {
          break label365;
        }
      }
      label365:
      for (long l = 1L;; l = 0L)
      {
        ((pa)localObject3).BF(l);
        ((pa)localObject3).aoI();
        ((pa)localObject3).BE(((AppBrandInitConfigWC)localObject1).startTime);
        ((pa)localObject3).aoF();
        ((pa)localObject3).BC(((pa)localObject3).Su() - ((pa)localObject3).St());
        ((pa)localObject3).aoJ();
        ((pa)localObject3).bpa();
        this.qVW = null;
        if (cjQ() != 5) {
          break;
        }
        ((ah)com.tencent.luggage.a.e.K(ah.class)).k((Activity)this);
        AppMethodBeat.o(51138);
        return;
      }
      if (cjQ() == 4) {
        super.overridePendingTransition(MMFragmentActivity.a.ria, MMFragmentActivity.a.rib);
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
    this.qVY = true;
    cjS();
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
        paramBundle = new com.tencent.mm.hellhoundlib.b.a().bm(paramBundle);
        com.tencent.mm.hellhoundlib.a.a.b(this, paramBundle.aFh(), "com/tencent/mm/plugin/appbrand/ui/AppBrandPreLoadingUI", "onCreate", "(Landroid/os/Bundle;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        startActivity((Intent)paramBundle.sf(0));
        com.tencent.mm.hellhoundlib.a.a.c(this, "com/tencent/mm/plugin/appbrand/ui/AppBrandPreLoadingUI", "onCreate", "(Landroid/os/Bundle;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      }
    }
    paramBundle = new FrameLayout((Context)this);
    setContentView((View)paramBundle);
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-1, -1);
    if ((WeChatEnvironment.hasDebugger()) || (BuildInfo.IS_FLAVOR_RED) || (BuildInfo.IS_FLAVOR_PURPLE))
    {
      localObject = com.tencent.mm.plugin.appbrand.app.f.nCi.aal();
      if ((localObject != null) && (((MultiProcessMMKV)localObject).getBoolean("enable_pre_loading_rainbow", false) == true))
      {
        localObject = (kotlin.g.a.a)AppBrandPreLoadingUI.f.qWj;
        cjR().BU(Color.rgb(((Number)((kotlin.g.a.a)localObject).invoke()).intValue(), ((Number)((kotlin.g.a.a)localObject).invoke()).intValue(), ((Number)((kotlin.g.a.a)localObject).invoke()).intValue()));
      }
    }
    Log.i("MicroMsg.AppBrand.AppBrandPreLoadingUI", "onCreate: ");
    Object localObject = getIntent();
    p.j(localObject, "intent");
    d((Intent)localObject, "onCreate");
    paramBundle.addView(cjR().getView(), (ViewGroup.LayoutParams)localLayoutParams);
    AppBrandContainerFragmentActivity.e((Activity)this, androidx.core.content.a.w((Context)this, au.c.BG_1));
    AppMethodBeat.o(51134);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(51139);
    super.onDestroy();
    Object localObject = new Intent();
    ((Intent)localObject).setClassName((Context)this, this.serviceName);
    if (this.qVZ) {}
    try
    {
      if (this.qWd != null)
      {
        b localb = this.qWd;
        if (localb == null) {
          p.iCn();
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
    localObject = this.qWa;
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
    this.qVX = null;
    this.qVY = false;
    d(paramIntent, "onNewIntent");
    AppMethodBeat.o(51131);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(51135);
    super.onPause();
    Log.i("MicroMsg.AppBrand.AppBrandPreLoadingUI", "onPause: ");
    if (!this.qVY) {
      overridePendingTransition(0, 0);
    }
    setForeground(false);
    AppMethodBeat.o(51135);
  }
  
  public void onRestoreInstanceState(Bundle paramBundle)
  {
    AppMethodBeat.i(51140);
    super.onRestoreInstanceState(paramBundle);
    Log.i("MicroMsg.AppBrand.AppBrandPreLoadingUI", "onRestoreInstanceState: pendingIntent = " + this.qVX);
    if ((paramBundle != null) && (this.qVX != null)) {
      paramBundle.putParcelable("MicroMsg.AppBrandPreLoadingUI.intent", (Parcelable)this.qVX);
    }
    AppMethodBeat.o(51140);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(51133);
    super.onResume();
    Log.i("MicroMsg.AppBrand.AppBrandPreLoadingUI", "onResume: ");
    if (cjQ() == 4)
    {
      if (!com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.g.BT(((Number)this.mta.getValue()).intValue())) {
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
      overridePendingTransition(MMFragmentActivity.a.rhY, MMFragmentActivity.a.rhZ);
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Lcom/tencent/mm/plugin/appbrand/ui/IAppBrandLoadingSplash;", "invoke"})
  static final class h
    extends q
    implements kotlin.g.a.a<aa>
  {
    h(AppBrandPreLoadingUI paramAppBrandPreLoadingUI)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.AppBrandPreLoadingUI
 * JD-Core Version:    0.7.0.1
 */