package com.tencent.mm.plugin.appbrand.report.quality;

import android.content.SharedPreferences.Editor;
import com.tencent.mars.smc.SmcLogic;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.ed;
import com.tencent.mm.plugin.appbrand.debugger.DebuggerShell;
import com.tencent.mm.plugin.appbrand.keylogger.base.b;
import com.tencent.mm.plugin.appbrand.keylogger.base.i;
import com.tencent.mm.plugin.appbrand.step.KSProcessWeAppLaunch;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ax;
import com.tencent.mm.sdk.platformtools.bt;
import d.a.v;
import d.g.b.k;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/appbrand/report/quality/WAKeyStepKvLogger;", "Lcom/tencent/mm/plugin/appbrand/keylogger/base/IKeyStepListener;", "()V", "ENABLE", "", "()Z", "MMKV_KEY_SPLITOR_PROCESS_REPORTED_STARTED", "", "MMKV_KEY_SUFFIX_RUNNING_RESOURCE_PREPARING", "MMKV_MARK_RUNNING_PROCESS", "Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "kotlin.jvm.PlatformType", "getMMKV_MARK_RUNNING_PROCESS", "()Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "TAG", "mapAppId2InstanceId", "Ljava/util/concurrent/ConcurrentHashMap;", "mapChild2ParentNode", "Lcom/tencent/mm/plugin/appbrand/keylogger/base/IKeyStep;", "onProcessEnd", "", "sessionId", "onProcessStart", "onStepFail", "step", "cost", "", "onStepOK", "onStepStart", "reportStep", "_cost", "reason", "Lcom/tencent/mm/plugin/appbrand/report/quality/WAKeyStepKvLogger$REPORT_REASON;", "setAppId2InstanceId", "appId", "instanceId", "setChild2ParentMapping", "node", "Lcom/tencent/mm/plugin/appbrand/keylogger/base/StepNodeWrapper;", "reportCustom", "Lcom/tencent/mm/autogen/mmdata/rpt/WALifeCycleTimeAxisItemStruct;", "REPORT_REASON", "plugin-appbrand-integration_release"})
public final class n
  implements b
{
  private static final ConcurrentHashMap<String, String> lur;
  private static final ConcurrentHashMap<com.tencent.mm.plugin.appbrand.keylogger.base.a, com.tencent.mm.plugin.appbrand.keylogger.base.a> lus;
  public static final n lut;
  
  static
  {
    AppMethodBeat.i(196438);
    lut = new n();
    lur = new ConcurrentHashMap();
    lus = new ConcurrentHashMap();
    com.tencent.mm.plugin.appbrand.keylogger.base.h localh = com.tencent.mm.plugin.appbrand.keylogger.f.aA(KSProcessWeAppLaunch.class);
    k.g(localh, "root");
    c(localh);
    AppMethodBeat.o(196438);
  }
  
  private static void a(ed paramed)
  {
    AppMethodBeat.i(196432);
    boolean bool = DebuggerShell.aTY();
    String str = paramed.PV();
    ad.d("MicroMsg.AppBrand.WAKeyStepKvLogger", "custom report 19175 " + str + " |reportNow:" + bool);
    com.tencent.mm.plugin.report.service.h.vKh.a(paramed.getId(), str, bool, true);
    AppMethodBeat.o(196432);
  }
  
  private final void a(final String paramString, final com.tencent.mm.plugin.appbrand.keylogger.base.a parama, long paramLong, a parama1)
  {
    AppMethodBeat.i(196433);
    if (!bmY())
    {
      AppMethodBeat.o(196433);
      return;
    }
    if (parama == null)
    {
      AppMethodBeat.o(196433);
      return;
    }
    if (paramString == null)
    {
      AppMethodBeat.o(196433);
      return;
    }
    if (DebuggerShell.aTY()) {
      SmcLogic.SetDebugFlag(true);
    }
    if ((parama instanceof i)) {
      Kb(paramString);
    }
    if (!ax.fF("WAKeyStepKvLogger_RUNNING_PROCESS", 2).getBoolean(paramString, false))
    {
      AppMethodBeat.o(196433);
      return;
    }
    Object localObject = (String)lur.get(paramString);
    if (localObject == null)
    {
      AppMethodBeat.o(196433);
      return;
    }
    k.g(localObject, "mapAppId2InstanceId[appId] ?: return");
    localObject = new b((String)localObject, paramString, parama);
    if ((parama instanceof i))
    {
      paramString = ((b)localObject).bna();
      paramString.kw("StartUp");
      paramString.gS(0L);
      paramString.gR(bt.eGO());
      a(paramString);
      AppMethodBeat.o(196433);
      return;
    }
    if ((parama instanceof com.tencent.mm.plugin.appbrand.keylogger.base.f))
    {
      paramString = ((b)localObject).bna();
      paramString.kw("StartUp");
      paramString.gS(1L);
      paramString.gR(bt.eGO());
      a(paramString);
      AppMethodBeat.o(196433);
      return;
    }
    ed localed;
    switch (o.ciE[parama1.ordinal()])
    {
    default: 
      if (ax.fF("WAKeyStepKvLogger_RUNNING_PROCESS", 2).containsKey(paramString + "__SPLITOR_PROCESS_REPORTED_STARTED__" + parama.name()))
      {
        paramLong = bt.eGO();
        paramLong -= ax.fF("WAKeyStepKvLogger_RUNNING_PROCESS", 2).getLong(paramString + "__SPLITOR_PROCESS_REPORTED_STARTED__" + parama.name(), paramLong);
      }
      if (paramLong <= 0L) {
        break label568;
      }
      localed = ((b)localObject).bna();
      if (a.luv != parama1) {
        break;
      }
    }
    for (long l = 1L;; l = 3L)
    {
      localed.gS(l);
      localed.gR(bt.eGO());
      a(localed);
      if (ax.fF("WAKeyStepKvLogger_RUNNING_PROCESS", 2).containsKey(paramString + "__SPLITOR_PROCESS_REPORTED_STARTED__" + parama.name())) {
        break;
      }
      paramString = ((b)localObject).bna();
      paramString.gS(0L);
      paramString.gR(bt.eGO() - paramLong);
      a(paramString);
      AppMethodBeat.o(196433);
      return;
      if (ax.fF("WAKeyStepKvLogger_RUNNING_PROCESS", 2).containsKey(paramString + "__SPLITOR_PROCESS_REPORTED_STARTED__" + parama.name()))
      {
        AppMethodBeat.o(196433);
        return;
      }
      parama1 = ((b)localObject).bna();
      parama1.gS(0L);
      parama1.gR(bt.eGO());
      a(parama1);
      ax.fF("WAKeyStepKvLogger_RUNNING_PROCESS", 2).putLong(paramString + "__SPLITOR_PROCESS_REPORTED_STARTED__" + parama.name(), bt.eGO());
      AppMethodBeat.o(196433);
      return;
    }
    label568:
    paramString = ((b)localObject).bna();
    paramString.gS(2L);
    paramString.gR(bt.eGO());
    a(paramString);
    AppMethodBeat.o(196433);
  }
  
  public static final boolean bmY()
  {
    return (com.tencent.mm.sdk.platformtools.h.IS_FLAVOR_RED) || (com.tencent.mm.sdk.platformtools.h.IS_FLAVOR_PURPLE);
  }
  
  private static void c(com.tencent.mm.plugin.appbrand.keylogger.base.h paramh)
  {
    AppMethodBeat.i(196429);
    Object localObject2 = paramh.bga();
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = (List)v.Jgl;
    }
    localObject1 = ((Iterable)localObject1).iterator();
    if (((Iterator)localObject1).hasNext())
    {
      Object localObject3 = (com.tencent.mm.plugin.appbrand.keylogger.base.h)((Iterator)localObject1).next();
      k.g(localObject3, "child");
      localObject2 = (Collection)((com.tencent.mm.plugin.appbrand.keylogger.base.h)localObject3).bga();
      if ((localObject2 == null) || (((Collection)localObject2).isEmpty())) {}
      for (int i = 1;; i = 0)
      {
        if (i == 0) {
          c((com.tencent.mm.plugin.appbrand.keylogger.base.h)localObject3);
        }
        if (paramh.bgb() == null) {
          break;
        }
        localObject2 = (Map)lus;
        localObject3 = ((com.tencent.mm.plugin.appbrand.keylogger.base.h)localObject3).bgb();
        if (localObject3 == null) {
          k.fvU();
        }
        k.g(localObject3, "child.asStep()!!");
        com.tencent.mm.plugin.appbrand.keylogger.base.a locala = paramh.bgb();
        if (locala == null) {
          k.fvU();
        }
        k.g(locala, "node.asStep()!!");
        ((Map)localObject2).put(localObject3, locala);
        break;
      }
    }
    AppMethodBeat.o(196429);
  }
  
  public static void dQ(String paramString1, String paramString2)
  {
    AppMethodBeat.i(196430);
    k.h(paramString2, "instanceId");
    CharSequence localCharSequence = (CharSequence)paramString1;
    if ((localCharSequence == null) || (localCharSequence.length() == 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(196430);
      return;
    }
    ((Map)lur).put(paramString1, paramString2);
    AppMethodBeat.o(196430);
  }
  
  public final void Kb(String paramString)
  {
    AppMethodBeat.i(196437);
    if (paramString == null)
    {
      AppMethodBeat.o(196437);
      return;
    }
    Object localObject2 = ax.fF("WAKeyStepKvLogger_RUNNING_PROCESS", 2).allKeys();
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = new String[0];
    }
    int j = localObject1.length;
    int i = 0;
    String str;
    if (i < j)
    {
      str = localObject1[i];
      if (str != null) {
        break label151;
      }
    }
    label151:
    for (localObject2 = "";; localObject2 = str)
    {
      if (d.n.n.mA((String)localObject2, paramString)) {
        ax.fF("WAKeyStepKvLogger_RUNNING_PROCESS", 2).remove(str);
      }
      i += 1;
      break;
      ax.fF("WAKeyStepKvLogger_RUNNING_PROCESS", 2).putBoolean(paramString, true).apply();
      ax.fF("WAKeyStepKvLogger_RUNNING_PROCESS", 2).remove(paramString + "_RUNNING_RESOURCE_PREPARING");
      AppMethodBeat.o(196437);
      return;
    }
  }
  
  public final void Kc(String paramString)
  {
    AppMethodBeat.i(196436);
    if (paramString == null)
    {
      AppMethodBeat.o(196436);
      return;
    }
    ax.fF("WAKeyStepKvLogger_RUNNING_PROCESS", 2).remove(paramString).apply();
    ax.fF("WAKeyStepKvLogger_RUNNING_PROCESS", 2).remove(paramString + "_RUNNING_RESOURCE_PREPARING");
    AppMethodBeat.o(196436);
  }
  
  public final void b(String paramString, com.tencent.mm.plugin.appbrand.keylogger.base.a parama, long paramLong)
  {
    AppMethodBeat.i(196431);
    StringBuilder localStringBuilder = new StringBuilder("onStepOk id:").append(paramString).append(" step:");
    if (parama != null) {}
    for (String str = parama.name();; str = null)
    {
      ad.i("MicroMsg.AppBrand.WAKeyStepKvLogger", str + " cost:" + paramLong);
      a(paramString, parama, paramLong, a.luv);
      AppMethodBeat.o(196431);
      return;
    }
  }
  
  public final void f(String paramString, com.tencent.mm.plugin.appbrand.keylogger.base.a parama)
  {
    AppMethodBeat.i(196435);
    StringBuilder localStringBuilder = new StringBuilder("onStepStart id:").append(paramString).append(" step:");
    if (parama != null) {}
    for (String str = parama.name();; str = null)
    {
      ad.i("MicroMsg.AppBrand.WAKeyStepKvLogger", str);
      a(this, paramString, parama, a.luu);
      AppMethodBeat.o(196435);
      return;
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/appbrand/report/quality/WAKeyStepKvLogger$REPORT_REASON;", "", "(Ljava/lang/String;I)V", "START", "OK", "FAIL", "plugin-appbrand-integration_release"})
  static enum a
  {
    static
    {
      AppMethodBeat.i(196423);
      a locala1 = new a("START", 0);
      luu = locala1;
      a locala2 = new a("OK", 1);
      luv = locala2;
      a locala3 = new a("FAIL", 2);
      luw = locala3;
      luy = new a[] { locala1, locala2, locala3 };
      AppMethodBeat.o(196423);
    }
    
    private a() {}
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"makeStruct", "Lcom/tencent/mm/autogen/mmdata/rpt/WALifeCycleTimeAxisItemStruct;", "invoke"})
  static final class b
    extends d.g.b.l
    implements d.g.a.a<ed>
  {
    b(String paramString1, String paramString2, com.tencent.mm.plugin.appbrand.keylogger.base.a parama)
    {
      super();
    }
    
    public final ed bna()
    {
      AppMethodBeat.i(196428);
      ed localed = new ed();
      localed.ku(this.lqp);
      localed.kv(paramString);
      localed.kw(parama.name());
      Object localObject = n.lut;
      localObject = (com.tencent.mm.plugin.appbrand.keylogger.base.a)n.bmZ().get(parama);
      if (localObject == null)
      {
        localObject = null;
        localed.kx((String)localObject);
        localObject = parama.bfW();
        k.g(localObject, "step.desc()");
        if (!d.n.n.a((CharSequence)localObject, (CharSequence)"(Global)", false)) {
          break label143;
        }
        localed.gT(0L);
      }
      for (;;)
      {
        AppMethodBeat.o(196428);
        return localed;
        if (KSProcessWeAppLaunch.stepLaunch == localObject)
        {
          localObject = "StartUp";
          break;
        }
        localObject = ((com.tencent.mm.plugin.appbrand.keylogger.base.a)localObject).name();
        break;
        label143:
        localObject = parama.bfW();
        k.g(localObject, "step.desc()");
        if (d.n.n.a((CharSequence)localObject, (CharSequence)"(View)", false))
        {
          localed.gT(1L);
        }
        else
        {
          localObject = parama.bfW();
          k.g(localObject, "step.desc()");
          if (d.n.n.a((CharSequence)localObject, (CharSequence)"(Service)", false)) {
            localed.gT(2L);
          } else {
            localed.gT(3L);
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.report.quality.n
 * JD-Core Version:    0.7.0.1
 */