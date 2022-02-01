package com.tencent.mm.plugin.appbrand.task;

import android.app.Activity;
import android.app.Service;
import android.content.Intent;
import android.os.Parcelable;
import android.os.SystemClock;
import com.tencent.luggage.sdk.processes.LuggageServiceType;
import com.tencent.luggage.sdk.processes.b;
import com.tencent.luggage.sdk.processes.client.LuggageClientProcessMessage;
import com.tencent.luggage.sdk.processes.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.extension.XIPCInvoker;
import com.tencent.mm.plugin.appbrand.task.ipc.AppBrandKillByClientMessage;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/task/AppBrandMiniProgramProcess;", "Lcom/tencent/luggage/sdk/processes/LuggageMiniProgramProcess;", "Lcom/tencent/mm/plugin/appbrand/task/AppBrandStartParams;", "uiClass", "Ljava/lang/Class;", "Landroid/app/Activity;", "pluginUIClass", "keepAliveServiceClass", "Landroid/app/Service;", "foregroundServiceClass", "processTriggerServiceClass", "preLoadingUIClass", "(Ljava/lang/Class;Ljava/lang/Class;Ljava/lang/Class;Ljava/lang/Class;Ljava/lang/Class;Ljava/lang/Class;)V", "<set-?>", "", "commLibVersion", "getCommLibVersion", "()I", "setCommLibVersion$plugin_appbrand_integration_release", "(I)V", "getForegroundServiceClass", "()Ljava/lang/Class;", "getKeepAliveServiceClass", "maxStartActivityTimestamp", "", "getMaxStartActivityTimestamp", "()J", "getPluginUIClass", "getPreLoadingUIClass", "getProcessTriggerServiceClass", "getUiClass", "attachApp", "Lcom/tencent/luggage/sdk/processes/LuggageMiniProgramRecord;", "appId", "", "versionType", "instanceId", "isPersistentApp", "", "createRecord", "killAllNonPersistentRuntime", "", "predicate", "Lkotlin/Function2;", "killAllRuntime", "type", "Lcom/tencent/luggage/sdk/processes/KillType;", "killProcess", "preload", "preloadLevel", "enableKeepAlive", "processIndex", "Companion", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public class d
  extends com.tencent.luggage.sdk.processes.c<n>
{
  private static final d.a tVI;
  final Class<? extends Activity> tVJ;
  private final Class<? extends Activity> tVK;
  private final Class<? extends Service> tVL;
  public final Class<? extends Service> tVM;
  public final Class<? extends Service> tVN;
  public final Class<? extends Activity> tVO;
  public int tVP;
  
  static
  {
    AppMethodBeat.i(318586);
    tVI = new d.a((byte)0);
    AppMethodBeat.o(318586);
  }
  
  public d(Class<? extends Activity> paramClass1, Class<? extends Activity> paramClass2, Class<? extends Service> paramClass3, Class<? extends Service> paramClass4, Class<? extends Service> paramClass5, Class<? extends Activity> paramClass6)
  {
    AppMethodBeat.i(318577);
    this.tVJ = paramClass1;
    this.tVK = paramClass2;
    this.tVL = paramClass3;
    this.tVM = paramClass4;
    this.tVN = paramClass5;
    this.tVO = paramClass6;
    this.tVP = -1;
    AppMethodBeat.o(318577);
  }
  
  public final e a(String paramString1, int paramInt, String paramString2, boolean paramBoolean)
  {
    AppMethodBeat.i(318617);
    s.u(paramString1, "appId");
    s.u(paramString2, "instanceId");
    paramString1 = a(paramString1, paramBoolean, paramInt, paramString2);
    AppMethodBeat.o(318617);
    return paramString1;
  }
  
  public final void a(b paramb)
  {
    AppMethodBeat.i(318600);
    s.u(paramb, "type");
    Iterator localIterator = ((Iterable)arZ()).iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      com.tencent.luggage.sdk.processes.c.a((com.tencent.luggage.sdk.processes.c)this, (LuggageClientProcessMessage)new AppBrandKillByClientMessage(str, paramb.ordinal()));
    }
    AppMethodBeat.o(318600);
  }
  
  public final Class<? extends Activity> asa()
  {
    return this.tVJ;
  }
  
  public final Class<? extends Activity> asb()
  {
    return this.tVK;
  }
  
  public final void ase()
  {
    AppMethodBeat.i(318595);
    super.ase();
    com.tencent.mm.modelappbrand.c.bEE();
    AppMethodBeat.o(318595);
  }
  
  public final e c(String paramString, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(318609);
    s.u(paramString, "appId");
    paramString = (e)new f(paramString, paramInt, com.tencent.luggage.sdk.processes.f.euq, paramBoolean);
    AppMethodBeat.o(318609);
    return paramString;
  }
  
  public final void d(int paramInt1, boolean paramBoolean, int paramInt2)
  {
    AppMethodBeat.i(318606);
    Intent localIntent = new Intent(MMApplicationContext.getContext(), this.tVN);
    Object localObject = new AppBrandPreloadProfiler();
    ((AppBrandPreloadProfiler)localObject).tVS = SystemClock.elapsedRealtime();
    ((AppBrandPreloadProfiler)localObject).tVV = this.tVK.getName();
    ((AppBrandPreloadProfiler)localObject).tVU = this.tVJ.getName();
    localIntent.putExtra("preloadProfiler", (Parcelable)localObject);
    if (paramBoolean) {
      localIntent.putExtra("EXTRA_KEY_AGGRESSIVE", true);
    }
    localIntent.putExtra("EXTRA_KEY_LEVEL", paramInt1);
    localIntent.addFlags(268435456);
    localIntent.putExtra("EXTRA_KEY_TRIGGER_TIME", SystemClock.elapsedRealtime());
    localIntent.putExtra("EXTRA_KEY_PROCESS_INDEX", paramInt2);
    localObject = this.etX;
    s.u(localIntent, "intent");
    localIntent.putExtra("Luggage.LuggageServiceType", ((LuggageServiceType)localObject).ordinal());
    XIPCInvoker.a(getProcessName(), localIntent, com.tencent.mm.plugin.appbrand.task.preload.d.class, (com.tencent.mm.ipcinvoker.f)new d.b(this));
    AppMethodBeat.o(318606);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.task.d
 * JD-Core Version:    0.7.0.1
 */