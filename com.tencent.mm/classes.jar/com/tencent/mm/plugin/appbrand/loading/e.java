package com.tencent.mm.plugin.appbrand.loading;

import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/loading/PendingIntentTask;", "", "ctx", "Landroid/content/Context;", "intent", "Landroid/content/Intent;", "initConfig", "Lcom/tencent/mm/plugin/appbrand/config/AppBrandInitConfigWC;", "statObject", "Lcom/tencent/mm/plugin/appbrand/report/AppBrandStatObject;", "(Landroid/content/Context;Landroid/content/Intent;Lcom/tencent/mm/plugin/appbrand/config/AppBrandInitConfigWC;Lcom/tencent/mm/plugin/appbrand/report/AppBrandStatObject;)V", "getCtx", "()Landroid/content/Context;", "setCtx", "(Landroid/content/Context;)V", "getInitConfig", "()Lcom/tencent/mm/plugin/appbrand/config/AppBrandInitConfigWC;", "getIntent", "()Landroid/content/Intent;", "setIntent", "(Landroid/content/Intent;)V", "getStatObject", "()Lcom/tencent/mm/plugin/appbrand/report/AppBrandStatObject;", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class e
{
  Context ctx;
  public final AppBrandStatObject epn;
  public final AppBrandInitConfigWC initConfig;
  public Intent intent;
  
  public e(Context paramContext, Intent paramIntent, AppBrandInitConfigWC paramAppBrandInitConfigWC, AppBrandStatObject paramAppBrandStatObject)
  {
    AppMethodBeat.i(50841);
    this.ctx = paramContext;
    this.intent = paramIntent;
    this.initConfig = paramAppBrandInitConfigWC;
    this.epn = paramAppBrandStatObject;
    AppMethodBeat.o(50841);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(50844);
    if (this == paramObject)
    {
      AppMethodBeat.o(50844);
      return true;
    }
    if (!(paramObject instanceof e))
    {
      AppMethodBeat.o(50844);
      return false;
    }
    paramObject = (e)paramObject;
    if (!s.p(this.ctx, paramObject.ctx))
    {
      AppMethodBeat.o(50844);
      return false;
    }
    if (!s.p(this.intent, paramObject.intent))
    {
      AppMethodBeat.o(50844);
      return false;
    }
    if (!s.p(this.initConfig, paramObject.initConfig))
    {
      AppMethodBeat.o(50844);
      return false;
    }
    if (!s.p(this.epn, paramObject.epn))
    {
      AppMethodBeat.o(50844);
      return false;
    }
    AppMethodBeat.o(50844);
    return true;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(50843);
    int i = this.ctx.hashCode();
    int j = this.intent.hashCode();
    int k = this.initConfig.hashCode();
    int m = this.epn.hashCode();
    AppMethodBeat.o(50843);
    return ((i * 31 + j) * 31 + k) * 31 + m;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(50842);
    String str = "PendingIntentTask(ctx=" + this.ctx + ", intent=" + this.intent + ", initConfig=" + this.initConfig + ", statObject=" + this.epn + ')';
    AppMethodBeat.o(50842);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.loading.e
 * JD-Core Version:    0.7.0.1
 */