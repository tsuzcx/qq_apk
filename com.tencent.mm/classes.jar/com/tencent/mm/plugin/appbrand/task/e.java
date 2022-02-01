package com.tencent.mm.plugin.appbrand.task;

import android.app.Activity;
import android.app.Service;
import com.tencent.luggage.sdk.processes.LuggageServiceType;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/task/AppBrandMiniProgramProcessGameOnly;", "Lcom/tencent/mm/plugin/appbrand/task/AppBrandMiniProgramProcess;", "uiClass", "Ljava/lang/Class;", "Landroid/app/Activity;", "pluginUIClass", "keepAliveServiceClass", "Landroid/app/Service;", "foregroundServiceClass", "processTriggerServiceClass", "appBrandPreLoadingUIClass", "(Ljava/lang/Class;Ljava/lang/Class;Ljava/lang/Class;Ljava/lang/Class;Ljava/lang/Class;Ljava/lang/Class;)V", "plugin-appbrand-integration_release"})
public final class e
  extends d
{
  public e(Class<? extends Activity> paramClass1, Class<? extends Activity> paramClass2, Class<? extends Service> paramClass3, Class<? extends Service> paramClass4, Class<? extends Service> paramClass5, Class<? extends Activity> paramClass6)
  {
    super(paramClass1, paramClass2, paramClass3, paramClass4, paramClass5, paramClass6);
    AppMethodBeat.i(280042);
    b(LuggageServiceType.cBQ);
    AppMethodBeat.o(280042);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.task.e
 * JD-Core Version:    0.7.0.1
 */