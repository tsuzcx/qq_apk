package com.tencent.mm.plugin.appbrand.loading;

import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.app.f;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.config.HalfScreenConfig;
import com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.g;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.task.d;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.u;
import kotlin.j;
import kotlin.k;
import kotlin.n.n;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/loading/AppBrandPreLoadingLogic;", "", "ctx", "Landroid/content/Context;", "startAppBrandIntent", "Landroid/content/Intent;", "cfg", "Lcom/tencent/mm/plugin/appbrand/config/AppBrandInitConfigWC;", "task", "Lcom/tencent/mm/plugin/appbrand/task/AppBrandMiniProgramProcess;", "stat", "Lcom/tencent/mm/plugin/appbrand/report/AppBrandStatObject;", "(Landroid/content/Context;Landroid/content/Intent;Lcom/tencent/mm/plugin/appbrand/config/AppBrandInitConfigWC;Lcom/tencent/mm/plugin/appbrand/task/AppBrandMiniProgramProcess;Lcom/tencent/mm/plugin/appbrand/report/AppBrandStatObject;)V", "connect", "Lcom/tencent/mm/plugin/appbrand/loading/AppBrandPreLoadingServiceConnection;", "getConnect", "()Lcom/tencent/mm/plugin/appbrand/loading/AppBrandPreLoadingServiceConnection;", "connect$delegate", "Lkotlin/Lazy;", "pendingIntentKey", "", "forceDisable", "", "getUiFlavor", "isAccessibilityServiceOpen", "needPreLoadingUi", "onNeedPreLoadingUI", "", "setupOpenAnim", "Landroid/app/Activity;", "startAppBrandProgress", "targetServiceClassName", "", "startPreLoadingActivity", "targetActivityName", "xLabIsOpen", "Companion", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
{
  public static final a.a tfg;
  private static ServiceConnection tfl;
  public final Context ctx;
  public final AppBrandInitConfigWC qBH;
  public final AppBrandStatObject qxv;
  public final Intent tfh;
  public final d tfi;
  public int tfj;
  private final j tfk;
  
  static
  {
    AppMethodBeat.i(50818);
    tfg = new a.a((byte)0);
    AppMethodBeat.o(50818);
  }
  
  public a(Context paramContext, Intent paramIntent, AppBrandInitConfigWC paramAppBrandInitConfigWC, d paramd, AppBrandStatObject paramAppBrandStatObject)
  {
    AppMethodBeat.i(317023);
    this.ctx = paramContext;
    this.tfh = paramIntent;
    this.qBH = paramAppBrandInitConfigWC;
    this.tfi = paramd;
    this.qxv = paramAppBrandStatObject;
    this.tfj = -1;
    this.tfk = k.cm((kotlin.g.a.a)new b(this));
    AppMethodBeat.o(317023);
  }
  
  public static int cBb()
  {
    return 5;
  }
  
  public final b cBa()
  {
    AppMethodBeat.i(175200);
    b localb = (b)this.tfk.getValue();
    AppMethodBeat.o(175200);
    return localb;
  }
  
  public final boolean cBc()
  {
    AppMethodBeat.i(50816);
    if ((!this.qBH.aqJ()) && (!this.qBH.qYd) && (!this.qBH.qYk))
    {
      Object localObject = (CharSequence)this.tfi.tVN.getCanonicalName();
      boolean bool;
      if ((localObject == null) || (n.bp((CharSequence)localObject)))
      {
        i = 1;
        if ((i != 0) || ("wxfe02ecfe70800f46".equalsIgnoreCase(this.qBH.appId)) || (g.d(this.qBH, this.qxv))) {
          break label169;
        }
        localObject = f.qBv;
        localObject = f.aBP();
        if (localObject != null) {
          break label153;
        }
        bool = true;
        label109:
        if (bool) {
          break label164;
        }
      }
      label153:
      label164:
      for (int i = 1;; i = 0)
      {
        if ((i != 0) || (this.qBH.qAT.isEnable()) || (com.tencent.mm.ui.a.a.a.jlv().jls())) {
          break label169;
        }
        AppMethodBeat.o(50816);
        return true;
        i = 0;
        break;
        bool = ((MultiProcessMMKV)localObject).getBoolean("enable_pre_loading", true);
        break label109;
      }
    }
    label169:
    AppMethodBeat.o(50816);
    return false;
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/plugin/appbrand/loading/AppBrandPreLoadingServiceConnection;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements kotlin.g.a.a<b>
  {
    b(a parama)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  public static final class c
    extends u
    implements kotlin.g.a.a<ah>
  {
    public c(a parama, String paramString)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.loading.a
 * JD-Core Version:    0.7.0.1
 */