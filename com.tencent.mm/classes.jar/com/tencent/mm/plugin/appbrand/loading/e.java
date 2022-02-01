package com.tencent.mm.plugin.appbrand.loading;

import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/loading/PendingIntentTask;", "", "ctx", "Landroid/content/Context;", "intent", "Landroid/content/Intent;", "initConfig", "Lcom/tencent/mm/plugin/appbrand/config/AppBrandInitConfigWC;", "statObject", "Lcom/tencent/mm/plugin/appbrand/report/AppBrandStatObject;", "(Landroid/content/Context;Landroid/content/Intent;Lcom/tencent/mm/plugin/appbrand/config/AppBrandInitConfigWC;Lcom/tencent/mm/plugin/appbrand/report/AppBrandStatObject;)V", "getCtx", "()Landroid/content/Context;", "setCtx", "(Landroid/content/Context;)V", "getInitConfig", "()Lcom/tencent/mm/plugin/appbrand/config/AppBrandInitConfigWC;", "getIntent", "()Landroid/content/Intent;", "setIntent", "(Landroid/content/Intent;)V", "getStatObject", "()Lcom/tencent/mm/plugin/appbrand/report/AppBrandStatObject;", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "", "plugin-appbrand-integration_release"})
public final class e
{
  Context ctx;
  public final AppBrandStatObject cyA;
  public Intent intent;
  public final AppBrandInitConfigWC kEG;
  
  public e(Context paramContext, Intent paramIntent, AppBrandInitConfigWC paramAppBrandInitConfigWC, AppBrandStatObject paramAppBrandStatObject)
  {
    AppMethodBeat.i(50841);
    this.ctx = paramContext;
    this.intent = paramIntent;
    this.kEG = paramAppBrandInitConfigWC;
    this.cyA = paramAppBrandStatObject;
    AppMethodBeat.o(50841);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(50844);
    if (this != paramObject)
    {
      if ((paramObject instanceof e))
      {
        paramObject = (e)paramObject;
        if ((!p.j(this.ctx, paramObject.ctx)) || (!p.j(this.intent, paramObject.intent)) || (!p.j(this.kEG, paramObject.kEG)) || (!p.j(this.cyA, paramObject.cyA))) {}
      }
    }
    else
    {
      AppMethodBeat.o(50844);
      return true;
    }
    AppMethodBeat.o(50844);
    return false;
  }
  
  public final int hashCode()
  {
    int m = 0;
    AppMethodBeat.i(50843);
    Object localObject = this.ctx;
    int i;
    int j;
    if (localObject != null)
    {
      i = localObject.hashCode();
      localObject = this.intent;
      if (localObject == null) {
        break label105;
      }
      j = localObject.hashCode();
      label42:
      localObject = this.kEG;
      if (localObject == null) {
        break label110;
      }
    }
    label105:
    label110:
    for (int k = localObject.hashCode();; k = 0)
    {
      localObject = this.cyA;
      if (localObject != null) {
        m = localObject.hashCode();
      }
      AppMethodBeat.o(50843);
      return (k + (j + i * 31) * 31) * 31 + m;
      i = 0;
      break;
      j = 0;
      break label42;
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(50842);
    String str = "PendingIntentTask(ctx=" + this.ctx + ", intent=" + this.intent + ", initConfig=" + this.kEG + ", statObject=" + this.cyA + ")";
    AppMethodBeat.o(50842);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.loading.e
 * JD-Core Version:    0.7.0.1
 */