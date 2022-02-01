package com.tencent.mm.plugin.appbrand.loading;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfig;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.ui.ah;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/loading/AppBrandPreLoadingLogic;", "", "ctx", "Landroid/content/Context;", "startAppBrandIntent", "Landroid/content/Intent;", "cfg", "Lcom/tencent/mm/plugin/appbrand/config/AppBrandInitConfigWC;", "task", "Lcom/tencent/mm/plugin/appbrand/task/AppBrandUITask;", "stat", "Lcom/tencent/mm/plugin/appbrand/report/AppBrandStatObject;", "(Landroid/content/Context;Landroid/content/Intent;Lcom/tencent/mm/plugin/appbrand/config/AppBrandInitConfigWC;Lcom/tencent/mm/plugin/appbrand/task/AppBrandUITask;Lcom/tencent/mm/plugin/appbrand/report/AppBrandStatObject;)V", "connect", "Lcom/tencent/mm/plugin/appbrand/loading/AppBrandPreLoadingServiceConnection;", "getConnect", "()Lcom/tencent/mm/plugin/appbrand/loading/AppBrandPreLoadingServiceConnection;", "connect$delegate", "Lkotlin/Lazy;", "pendingIntentKey", "", "forceDisable", "", "getUiFlavor", "needPreLoadingUi", "onNeedPreLoadingUI", "", "setupOpenAnim", "Landroid/app/Activity;", "startAppBrandProgress", "targetServiceClassName", "", "startPreLoadingActivity", "targetActivityName", "xLabIsOpen", "Companion", "plugin-appbrand-integration_release"})
public final class a
{
  private static ServiceConnection mZP;
  public static final a mZQ;
  private final Context ctx;
  private final AppBrandStatObject kEH;
  private final AppBrandInitConfigWC kID;
  private int mZL;
  private final kotlin.f mZM;
  private final Intent mZN;
  private final com.tencent.mm.plugin.appbrand.task.n mZO;
  
  static
  {
    AppMethodBeat.i(50818);
    mZQ = new a((byte)0);
    AppMethodBeat.o(50818);
  }
  
  public a(Context paramContext, Intent paramIntent, AppBrandInitConfigWC paramAppBrandInitConfigWC, com.tencent.mm.plugin.appbrand.task.n paramn, AppBrandStatObject paramAppBrandStatObject)
  {
    AppMethodBeat.i(50817);
    this.ctx = paramContext;
    this.mZN = paramIntent;
    this.kID = paramAppBrandInitConfigWC;
    this.mZO = paramn;
    this.kEH = paramAppBrandStatObject;
    this.mZL = -1;
    this.mZM = kotlin.g.ah((kotlin.g.a.a)new b(this));
    AppMethodBeat.o(50817);
  }
  
  private final int bOs()
  {
    if ((this.mZO instanceof com.tencent.mm.plugin.appbrand.task.d)) {
      return 4;
    }
    return 5;
  }
  
  public final b bOq()
  {
    AppMethodBeat.i(175200);
    b localb = (b)this.mZM.getValue();
    AppMethodBeat.o(175200);
    return localb;
  }
  
  public final void bOr()
  {
    AppMethodBeat.i(228822);
    this.mZL = c.mZY.a(new e(this.ctx, this.mZN, this.kID, this.kEH));
    Class localClass = this.mZO.bWy();
    Object localObject1 = new StringBuilder("onNeedPreLoadingUI: triggerService = ");
    p.g(localClass, "processTriggerServiceClass");
    Log.i("MicroMsg.AppBrand.AppBrandPreLoadingLogic", localClass.getCanonicalName());
    final String str = localClass.getCanonicalName();
    if (str == null) {
      p.hyc();
    }
    p.g(str, "processTriggerServiceClass.canonicalName!!");
    localObject1 = this.mZN.getComponent();
    if (localObject1 != null)
    {
      localObject2 = ((ComponentName)localObject1).getClassName();
      localObject1 = localObject2;
      if (localObject2 != null) {}
    }
    else
    {
      localObject1 = "";
    }
    Object localObject2 = new Intent(this.ctx, this.mZO.bWz());
    Log.i("MicroMsg.AppBrand.AppBrandPreLoadingLogic", "startPreLoadingActivity, ctx = " + this.ctx);
    ((Intent)localObject2).putExtra("MicroMsg.AppBrandPreLoadingLogic.name", this.kID.brandName);
    ((Intent)localObject2).putExtra("MicroMsg.AppBrandPreLoadingLogic.icon", this.kID.iconUrl);
    ((Intent)localObject2).putExtra("MicroMsg.AppBrandPreLoadingLogic.serviceName", str);
    ((Intent)localObject2).putExtra("MicroMsg.AppBrandPreLoadingLogic.intentKey", this.mZL);
    ((Intent)localObject2).putExtra("MicroMsg.AppBrandPreLoadingLogic.targetActivityName", (String)localObject1);
    ((Intent)localObject2).putExtra("MicroMsg.AppBrandPreLoadingLogic.splashFlavor", bOs());
    ((Intent)localObject2).putExtra("MicroMsg.AppBrandPreLoadingLogic.appId", this.kID.appId);
    ((Intent)localObject2).putExtra("MicroMsg.AppBrandPreLoadingLogic.scene", this.kEH.scene);
    ((Intent)localObject2).putExtra("MicroMsg.AppBrandPreLoadingLogic.versionInfo", (Parcelable)this.kID.cyv);
    ((Intent)localObject2).addFlags(268435456);
    localObject1 = this.ctx;
    localObject2 = new com.tencent.mm.hellhoundlib.b.a().bl(localObject2);
    com.tencent.mm.hellhoundlib.a.a.a(localObject1, ((com.tencent.mm.hellhoundlib.b.a)localObject2).axQ(), "com/tencent/mm/plugin/appbrand/loading/AppBrandPreLoadingLogic", "startPreLoadingActivity", "(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    ((Context)localObject1).startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject2).pG(0));
    com.tencent.mm.hellhoundlib.a.a.a(localObject1, "com/tencent/mm/plugin/appbrand/loading/AppBrandPreLoadingLogic", "startPreLoadingActivity", "(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    if ((this.ctx instanceof Activity))
    {
      localObject1 = (Activity)this.ctx;
      switch (bOs())
      {
      }
    }
    for (;;)
    {
      com.tencent.mm.ac.d.b("MicroMsg.AppBrand.AppBrandPreLoadingLogic:startService:".concat(String.valueOf(str)), (kotlin.g.a.a)new c(this, str));
      this.kID.ldT = localClass.getCanonicalName();
      AppMethodBeat.o(228822);
      return;
      ((ah)com.tencent.luggage.a.e.M(ah.class)).a((Activity)localObject1, (AppBrandInitConfig)this.kID);
    }
  }
  
  public final boolean bOt()
  {
    AppMethodBeat.i(50816);
    if ((this.mZO.bWq() == com.tencent.mm.plugin.appbrand.task.g.nPD) && (!this.kID.ldU))
    {
      Object localObject = this.mZO.bWy();
      p.g(localObject, "task.processTriggerServiceClass");
      localObject = (CharSequence)((Class)localObject).getCanonicalName();
      label104:
      boolean bool;
      if ((localObject == null) || (kotlin.n.n.aL((CharSequence)localObject)))
      {
        i = 1;
        if ((i != 0) || (com.tencent.mm.plugin.appbrand.af.g.afU(this.kID.appId)) || (com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.g.e(this.kID, this.kEH))) {
          break label195;
        }
        if (com.tencent.mm.protocal.d.KyP) {
          break label175;
        }
        i = 1;
        if (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.sgY, i) != 1) {
          break label180;
        }
        i = 1;
        label128:
        if (i == 0) {
          break label195;
        }
        localObject = com.tencent.mm.plugin.appbrand.app.f.kIs.VQ();
        if (localObject == null) {
          break label185;
        }
        bool = ((MultiProcessMMKV)localObject).getBoolean("enable_pre_loading", true);
        label152:
        if (bool) {
          break label190;
        }
      }
      label175:
      label180:
      label185:
      label190:
      for (int i = 1;; i = 0)
      {
        if (i != 0) {
          break label195;
        }
        AppMethodBeat.o(50816);
        return true;
        i = 0;
        break;
        i = 0;
        break label104;
        i = 0;
        break label128;
        bool = true;
        break label152;
      }
    }
    label195:
    AppMethodBeat.o(50816);
    return false;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/loading/AppBrandPreLoadingLogic$Companion;", "", "()V", "INTENT_KEY_APP_ID", "", "INTENT_KEY_ATTR_VERSION_INFO", "INTENT_KEY_ICON", "INTENT_KEY_NAME", "INTENT_KEY_PENDING_INTENT", "INTENT_KEY_SCENE", "INTENT_KEY_SERVICE_NAME", "INTENT_KEY_SPLASH_FLAVOR", "INTENT_KEY_TARGET_ACTIVITY_NAME", "IPC_PRE_LOAD_SUCCESS", "", "IPC_TRIGGER_PROGRESS", "IPC_TRIGGER_PROGRESS_FAIL", "IPC_TRIGGER_PROGRESS_SUCCESS", "NORMAL", "PLUGIN", "TAG", "connectionRefForUnbind", "Landroid/content/ServiceConnection;", "getConnectionRefForUnbind", "()Landroid/content/ServiceConnection;", "setConnectionRefForUnbind", "(Landroid/content/ServiceConnection;)V", "plugin-appbrand-integration_release"})
  public static final class a {}
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Lcom/tencent/mm/plugin/appbrand/loading/AppBrandPreLoadingServiceConnection;", "invoke"})
  static final class b
    extends q
    implements kotlin.g.a.a<b>
  {
    b(a parama)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class c
    extends q
    implements kotlin.g.a.a<x>
  {
    c(a parama, String paramString)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.loading.a
 * JD-Core Version:    0.7.0.1
 */