package com.tencent.mm.plugin.appbrand.task;

import android.app.Activity;
import android.app.Service;
import android.content.Intent;
import android.os.Parcelable;
import android.os.SystemClock;
import com.tencent.luggage.sdk.processes.LuggageServiceType;
import com.tencent.luggage.sdk.processes.c;
import com.tencent.luggage.sdk.processes.client.LuggageClientProcessMessage;
import com.tencent.luggage.sdk.processes.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.extension.XIPCInvoker;
import com.tencent.mm.ipcinvoker.g;
import com.tencent.mm.ipcinvoker.type.IPCVoid;
import com.tencent.mm.plugin.appbrand.task.ipc.AppBrandKillByClientMessage;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.util.Iterator;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/task/AppBrandMiniProgramProcess;", "Lcom/tencent/luggage/sdk/processes/LuggageMiniProgramProcess;", "Lcom/tencent/mm/plugin/appbrand/task/AppBrandStartParams;", "uiClass", "Ljava/lang/Class;", "Landroid/app/Activity;", "pluginUIClass", "keepAliveServiceClass", "Landroid/app/Service;", "foregroundServiceClass", "processTriggerServiceClass", "preLoadingUIClass", "(Ljava/lang/Class;Ljava/lang/Class;Ljava/lang/Class;Ljava/lang/Class;Ljava/lang/Class;Ljava/lang/Class;)V", "<set-?>", "", "commLibVersion", "getCommLibVersion", "()I", "setCommLibVersion$plugin_appbrand_integration_release", "(I)V", "getForegroundServiceClass", "()Ljava/lang/Class;", "getKeepAliveServiceClass", "getPluginUIClass", "getPreLoadingUIClass", "getProcessTriggerServiceClass", "getUiClass", "attachApp", "Lcom/tencent/luggage/sdk/processes/LuggageMiniProgramRecord;", "appId", "", "versionType", "instanceId", "isPersistentApp", "", "createRecord", "killAllNonPersistentRuntime", "", "killAllRuntime", "type", "Lcom/tencent/luggage/sdk/processes/KillType;", "killProcess", "preload", "preloadLevel", "enableKeepAlive", "processIndex", "Companion", "plugin-appbrand-integration_release"})
public class d
  extends c<p>
{
  @Deprecated
  public static final d.a qRh;
  public int qRa;
  final Class<? extends Activity> qRb;
  private final Class<? extends Activity> qRc;
  private final Class<? extends Service> qRd;
  public final Class<? extends Service> qRe;
  public final Class<? extends Service> qRf;
  public final Class<? extends Activity> qRg;
  
  static
  {
    AppMethodBeat.i(282313);
    qRh = new d.a((byte)0);
    AppMethodBeat.o(282313);
  }
  
  public d(Class<? extends Activity> paramClass1, Class<? extends Activity> paramClass2, Class<? extends Service> paramClass3, Class<? extends Service> paramClass4, Class<? extends Service> paramClass5, Class<? extends Activity> paramClass6)
  {
    AppMethodBeat.i(282312);
    this.qRb = paramClass1;
    this.qRc = paramClass2;
    this.qRd = paramClass3;
    this.qRe = paramClass4;
    this.qRf = paramClass5;
    this.qRg = paramClass6;
    this.qRa = -1;
    AppMethodBeat.o(282312);
  }
  
  public final Class<? extends Activity> RM()
  {
    return this.qRb;
  }
  
  public final Class<? extends Activity> RN()
  {
    return this.qRc;
  }
  
  public final void RP()
  {
    AppMethodBeat.i(282305);
    super.RP();
    com.tencent.mm.modelappbrand.b.bgM();
    AppMethodBeat.o(282305);
  }
  
  public final e a(String paramString1, int paramInt, String paramString2, boolean paramBoolean)
  {
    AppMethodBeat.i(282311);
    kotlin.g.b.p.k(paramString1, "appId");
    kotlin.g.b.p.k(paramString2, "instanceId");
    paramString1 = a(paramString1, paramBoolean, paramInt, paramString2);
    AppMethodBeat.o(282311);
    return paramString1;
  }
  
  public final void a(com.tencent.luggage.sdk.processes.b paramb)
  {
    AppMethodBeat.i(282307);
    kotlin.g.b.p.k(paramb, "type");
    Iterator localIterator = ((Iterable)RL()).iterator();
    while (localIterator.hasNext()) {
      c.a(this, (LuggageClientProcessMessage)new AppBrandKillByClientMessage((String)localIterator.next(), paramb.ordinal()));
    }
    AppMethodBeat.o(282307);
  }
  
  public final e c(String paramString, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(282310);
    kotlin.g.b.p.k(paramString, "appId");
    paramString = (e)new f(paramString, paramInt, com.tencent.luggage.sdk.processes.f.cBL, paramBoolean);
    AppMethodBeat.o(282310);
    return paramString;
  }
  
  public final void d(int paramInt1, boolean paramBoolean, int paramInt2)
  {
    AppMethodBeat.i(282308);
    s.cjg();
    Intent localIntent = new Intent(MMApplicationContext.getContext(), this.qRf);
    Object localObject = new AppBrandPreloadProfiler();
    ((AppBrandPreloadProfiler)localObject).ciU();
    ((AppBrandPreloadProfiler)localObject).qRn = this.qRc.getName();
    ((AppBrandPreloadProfiler)localObject).qRm = this.qRb.getName();
    localIntent.putExtra("preloadProfiler", (Parcelable)localObject);
    if (paramBoolean) {
      localIntent.putExtra("EXTRA_KEY_AGGRESSIVE", true);
    }
    localIntent.putExtra("EXTRA_KEY_LEVEL", paramInt1);
    localIntent.addFlags(268435456);
    localIntent.putExtra("EXTRA_KEY_TRIGGER_TIME", SystemClock.elapsedRealtime());
    localIntent.putExtra("EXTRA_KEY_PROCESS_INDEX", paramInt2);
    localObject = this.cBq;
    kotlin.g.b.p.k(localIntent, "intent");
    localIntent.putExtra("Luggage.LuggageServiceType", ((LuggageServiceType)localObject).ordinal());
    XIPCInvoker.a(getProcessName(), localIntent, com.tencent.mm.plugin.appbrand.task.preload.d.class, (com.tencent.mm.ipcinvoker.f)new b(this));
    AppMethodBeat.o(282308);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/appbrand/task/AppBrandMiniProgramProcess$preload$1", "Lcom/tencent/mm/ipcinvoker/IPCInvokeCallbackEx;", "Lcom/tencent/mm/ipcinvoker/type/IPCVoid;", "onBridgeNotFound", "", "onCallback", "data", "onCaughtInvokeException", "e", "Ljava/lang/Exception;", "plugin-appbrand-integration_release"})
  public static final class b
    implements g<IPCVoid>
  {
    public final void aFq()
    {
      AppMethodBeat.i(282581);
      d.ciT();
      com.tencent.mm.sdk.platformtools.Log.w("MicroMsg.AppBrandMiniProgramProcess", "onBridgeNotFound: proc [%s]", new Object[] { this.qRi.getProcessName() });
      AppMethodBeat.o(282581);
    }
    
    public final void g(Exception paramException)
    {
      AppMethodBeat.i(282583);
      d.ciT();
      com.tencent.mm.sdk.platformtools.Log.e("MicroMsg.AppBrandMiniProgramProcess", "onCaughtInvokeException: %s, process %s", new Object[] { android.util.Log.getStackTraceString((Throwable)paramException), this.qRi.getProcessName() });
      AppMethodBeat.o(282583);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.task.d
 * JD-Core Version:    0.7.0.1
 */