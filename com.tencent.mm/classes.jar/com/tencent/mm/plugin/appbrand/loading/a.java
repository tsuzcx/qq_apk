package com.tencent.mm.plugin.appbrand.loading;

import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.task.e;
import com.tencent.mm.plugin.appbrand.task.i;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.sdk.platformtools.ax;
import d.f;
import d.g.b.p;
import d.g.b.q;
import d.l;
import d.n.n;
import d.z;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/appbrand/loading/AppBrandPreLoadingLogic;", "", "ctx", "Landroid/content/Context;", "startAppBrandIntent", "Landroid/content/Intent;", "cfg", "Lcom/tencent/mm/plugin/appbrand/config/AppBrandInitConfigWC;", "task", "Lcom/tencent/mm/plugin/appbrand/task/AppBrandUITask;", "stat", "Lcom/tencent/mm/plugin/appbrand/report/AppBrandStatObject;", "(Landroid/content/Context;Landroid/content/Intent;Lcom/tencent/mm/plugin/appbrand/config/AppBrandInitConfigWC;Lcom/tencent/mm/plugin/appbrand/task/AppBrandUITask;Lcom/tencent/mm/plugin/appbrand/report/AppBrandStatObject;)V", "connect", "Lcom/tencent/mm/plugin/appbrand/loading/AppBrandPreLoadingServiceConnection;", "getConnect", "()Lcom/tencent/mm/plugin/appbrand/loading/AppBrandPreLoadingServiceConnection;", "connect$delegate", "Lkotlin/Lazy;", "pendingIntentKey", "", "forceDisable", "", "getUiFlavor", "needPreLoadingUi", "onNeedPreLoadingUI", "", "setupOpenAnim", "Landroid/app/Activity;", "startAppBrandProgress", "targetServiceClassName", "", "startPreLoadingActivity", "targetActivityName", "xLabIsOpen", "Companion", "plugin-appbrand-integration_release"})
public final class a
{
  private static ServiceConnection lNO;
  public static final a.a lNP;
  public final Context ctx;
  public final AppBrandInitConfigWC jDG;
  public final AppBrandStatObject jDH;
  public int lNK;
  private final f lNL;
  public final Intent lNM;
  public final i lNN;
  
  static
  {
    AppMethodBeat.i(50818);
    lNP = new a.a((byte)0);
    AppMethodBeat.o(50818);
  }
  
  public a(Context paramContext, Intent paramIntent, AppBrandInitConfigWC paramAppBrandInitConfigWC, i parami, AppBrandStatObject paramAppBrandStatObject)
  {
    AppMethodBeat.i(50817);
    this.ctx = paramContext;
    this.lNM = paramIntent;
    this.jDG = paramAppBrandInitConfigWC;
    this.lNN = parami;
    this.jDH = paramAppBrandStatObject;
    this.lNK = -1;
    this.lNL = d.g.O((d.g.a.a)new b(this));
    AppMethodBeat.o(50817);
  }
  
  public final b bsc()
  {
    AppMethodBeat.i(175200);
    b localb = (b)this.lNL.getValue();
    AppMethodBeat.o(175200);
    return localb;
  }
  
  public final int bsd()
  {
    if ((this.lNN instanceof com.tencent.mm.plugin.appbrand.task.b)) {
      return 4;
    }
    return 5;
  }
  
  public final boolean bse()
  {
    AppMethodBeat.i(50816);
    if ((this.lNN.byK() == e.myg) && (!this.jDG.jXB))
    {
      Object localObject = this.lNN.byL();
      p.g(localObject, "task.processTriggerServiceClass");
      localObject = (CharSequence)((Class)localObject).getCanonicalName();
      label102:
      label125:
      boolean bool;
      if ((localObject == null) || (n.aE((CharSequence)localObject)))
      {
        i = 1;
        if ((i != 0) || (com.tencent.mm.plugin.appbrand.ab.g.Vn(this.jDG.appId)) || (com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.g.e(this.jDG, this.jDH))) {
          break label191;
        }
        if (com.tencent.mm.protocal.d.Fnk) {
          break label171;
        }
        i = 1;
        if (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qDx, i) != 1) {
          break label176;
        }
        i = 1;
        if (i == 0) {
          break label191;
        }
        localObject = com.tencent.mm.plugin.appbrand.app.d.jDy;
        localObject = com.tencent.mm.plugin.appbrand.app.d.Lv();
        if (localObject == null) {
          break label181;
        }
        bool = ((ax)localObject).getBoolean("enable_pre_loading", true);
        label149:
        if (bool) {
          break label186;
        }
      }
      label171:
      label176:
      label181:
      label186:
      for (int i = 1;; i = 0)
      {
        if (i != 0) {
          break label191;
        }
        AppMethodBeat.o(50816);
        return true;
        i = 0;
        break;
        i = 0;
        break label102;
        i = 0;
        break label125;
        bool = true;
        break label149;
      }
    }
    label191:
    AppMethodBeat.o(50816);
    return false;
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "Lcom/tencent/mm/plugin/appbrand/loading/AppBrandPreLoadingServiceConnection;", "invoke"})
  static final class b
    extends q
    implements d.g.a.a<b>
  {
    b(a parama)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke"})
  public static final class c
    extends q
    implements d.g.a.a<z>
  {
    public c(a parama, String paramString)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.loading.a
 * JD-Core Version:    0.7.0.1
 */