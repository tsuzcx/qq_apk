package com.tencent.mm.plugin.appbrand.report.quality;

import android.content.SharedPreferences.Editor;
import com.tencent.mars.smc.SmcLogic;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.ft;
import com.tencent.mm.plugin.appbrand.debugger.DebuggerShell;
import com.tencent.mm.plugin.appbrand.keylogger.base.b;
import com.tencent.mm.plugin.appbrand.keylogger.base.i;
import com.tencent.mm.plugin.appbrand.step.KSProcessWeAppLaunch;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.aw;
import com.tencent.mm.sdk.platformtools.bs;
import d.a.v;
import d.g.b.k;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/appbrand/report/quality/WAKeyStepKvLogger;", "Lcom/tencent/mm/plugin/appbrand/keylogger/base/IKeyStepListener;", "()V", "ENABLE", "", "()Z", "MMKV_KEY_SPLITOR_PROCESS_REPORTED_STARTED", "", "MMKV_KEY_SUFFIX_RUNNING_RESOURCE_PREPARING", "MMKV_MARK_RUNNING_PROCESS", "Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "kotlin.jvm.PlatformType", "getMMKV_MARK_RUNNING_PROCESS", "()Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "TAG", "mapAppId2InstanceId", "Ljava/util/concurrent/ConcurrentHashMap;", "mapChild2ParentNode", "Lcom/tencent/mm/plugin/appbrand/keylogger/base/IKeyStep;", "onProcessEnd", "", "sessionId", "onProcessStart", "onStepFail", "step", "cost", "", "onStepOK", "onStepStart", "reportStep", "_cost", "reason", "Lcom/tencent/mm/plugin/appbrand/report/quality/WAKeyStepKvLogger$REPORT_REASON;", "setAppId2InstanceId", "appId", "instanceId", "setChild2ParentMapping", "node", "Lcom/tencent/mm/plugin/appbrand/keylogger/base/StepNodeWrapper;", "reportCustom", "Lcom/tencent/mm/autogen/mmdata/rpt/WALifeCycleTimeAxisItemStruct;", "REPORT_REASON", "plugin-appbrand-integration_release"})
public final class n
  implements b
{
  private static final ConcurrentHashMap<String, String> lWl;
  private static final ConcurrentHashMap<com.tencent.mm.plugin.appbrand.keylogger.base.a, com.tencent.mm.plugin.appbrand.keylogger.base.a> lWm;
  public static final n lWn;
  
  static
  {
    AppMethodBeat.i(187399);
    lWn = new n();
    lWl = new ConcurrentHashMap();
    lWm = new ConcurrentHashMap();
    com.tencent.mm.plugin.appbrand.keylogger.base.h localh = com.tencent.mm.plugin.appbrand.keylogger.f.aA(KSProcessWeAppLaunch.class);
    k.g(localh, "root");
    c(localh);
    AppMethodBeat.o(187399);
  }
  
  private static void a(ft paramft)
  {
    AppMethodBeat.i(187393);
    boolean bool = DebuggerShell.baW();
    String str = paramft.PR();
    ac.d("MicroMsg.AppBrand.WAKeyStepKvLogger", "custom report 19175 " + str + " |reportNow:" + bool);
    com.tencent.mm.plugin.report.service.h.wUl.a(paramft.getId(), str, bool, true);
    AppMethodBeat.o(187393);
  }
  
  private final void a(final String paramString, final com.tencent.mm.plugin.appbrand.keylogger.base.a parama, long paramLong, a parama1)
  {
    AppMethodBeat.i(187394);
    if (!btU())
    {
      AppMethodBeat.o(187394);
      return;
    }
    if (parama == null)
    {
      AppMethodBeat.o(187394);
      return;
    }
    if (paramString == null)
    {
      AppMethodBeat.o(187394);
      return;
    }
    if (DebuggerShell.baW()) {
      SmcLogic.SetDebugFlag(true);
    }
    if ((parama instanceof i)) {
      Oi(paramString);
    }
    if (!aw.fK("WAKeyStepKvLogger_RUNNING_PROCESS", 2).getBoolean(paramString, false))
    {
      AppMethodBeat.o(187394);
      return;
    }
    Object localObject = (String)lWl.get(paramString);
    if (localObject == null)
    {
      AppMethodBeat.o(187394);
      return;
    }
    k.g(localObject, "mapAppId2InstanceId[appId] ?: return");
    localObject = new b((String)localObject, paramString, parama);
    if ((parama instanceof i))
    {
      paramString = ((b)localObject).btW();
      paramString.no("StartUp");
      paramString.kn(0L);
      paramString.km(bs.eWj());
      a(paramString);
      AppMethodBeat.o(187394);
      return;
    }
    if ((parama instanceof com.tencent.mm.plugin.appbrand.keylogger.base.f))
    {
      paramString = ((b)localObject).btW();
      paramString.no("StartUp");
      paramString.kn(1L);
      paramString.km(bs.eWj());
      a(paramString);
      AppMethodBeat.o(187394);
      return;
    }
    ft localft;
    switch (o.cfA[parama1.ordinal()])
    {
    default: 
      if (aw.fK("WAKeyStepKvLogger_RUNNING_PROCESS", 2).containsKey(paramString + "__SPLITOR_PROCESS_REPORTED_STARTED__" + parama.name()))
      {
        paramLong = bs.eWj();
        paramLong -= aw.fK("WAKeyStepKvLogger_RUNNING_PROCESS", 2).getLong(paramString + "__SPLITOR_PROCESS_REPORTED_STARTED__" + parama.name(), paramLong);
      }
      if (paramLong <= 0L) {
        break label568;
      }
      localft = ((b)localObject).btW();
      if (a.lWp != parama1) {
        break;
      }
    }
    for (long l = 1L;; l = 3L)
    {
      localft.kn(l);
      localft.km(bs.eWj());
      a(localft);
      if (aw.fK("WAKeyStepKvLogger_RUNNING_PROCESS", 2).containsKey(paramString + "__SPLITOR_PROCESS_REPORTED_STARTED__" + parama.name())) {
        break;
      }
      paramString = ((b)localObject).btW();
      paramString.kn(0L);
      paramString.km(bs.eWj() - paramLong);
      a(paramString);
      AppMethodBeat.o(187394);
      return;
      if (aw.fK("WAKeyStepKvLogger_RUNNING_PROCESS", 2).containsKey(paramString + "__SPLITOR_PROCESS_REPORTED_STARTED__" + parama.name()))
      {
        AppMethodBeat.o(187394);
        return;
      }
      parama1 = ((b)localObject).btW();
      parama1.kn(0L);
      parama1.km(bs.eWj());
      a(parama1);
      aw.fK("WAKeyStepKvLogger_RUNNING_PROCESS", 2).putLong(paramString + "__SPLITOR_PROCESS_REPORTED_STARTED__" + parama.name(), bs.eWj());
      AppMethodBeat.o(187394);
      return;
    }
    label568:
    paramString = ((b)localObject).btW();
    paramString.kn(2L);
    paramString.km(bs.eWj());
    a(paramString);
    AppMethodBeat.o(187394);
  }
  
  public static final boolean btU()
  {
    return (com.tencent.mm.sdk.platformtools.h.IS_FLAVOR_RED) || (com.tencent.mm.sdk.platformtools.h.IS_FLAVOR_PURPLE);
  }
  
  private static void c(com.tencent.mm.plugin.appbrand.keylogger.base.h paramh)
  {
    AppMethodBeat.i(187390);
    Object localObject2 = paramh.bmU();
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = (List)v.KTF;
    }
    localObject1 = ((Iterable)localObject1).iterator();
    if (((Iterator)localObject1).hasNext())
    {
      Object localObject3 = (com.tencent.mm.plugin.appbrand.keylogger.base.h)((Iterator)localObject1).next();
      k.g(localObject3, "child");
      localObject2 = (Collection)((com.tencent.mm.plugin.appbrand.keylogger.base.h)localObject3).bmU();
      if ((localObject2 == null) || (((Collection)localObject2).isEmpty())) {}
      for (int i = 1;; i = 0)
      {
        if (i == 0) {
          c((com.tencent.mm.plugin.appbrand.keylogger.base.h)localObject3);
        }
        if (paramh.bmV() == null) {
          break;
        }
        localObject2 = (Map)lWm;
        localObject3 = ((com.tencent.mm.plugin.appbrand.keylogger.base.h)localObject3).bmV();
        if (localObject3 == null) {
          k.fOy();
        }
        k.g(localObject3, "child.asStep()!!");
        com.tencent.mm.plugin.appbrand.keylogger.base.a locala = paramh.bmV();
        if (locala == null) {
          k.fOy();
        }
        k.g(locala, "node.asStep()!!");
        ((Map)localObject2).put(localObject3, locala);
        break;
      }
    }
    AppMethodBeat.o(187390);
  }
  
  public static void ec(String paramString1, String paramString2)
  {
    AppMethodBeat.i(187391);
    k.h(paramString2, "instanceId");
    CharSequence localCharSequence = (CharSequence)paramString1;
    if ((localCharSequence == null) || (localCharSequence.length() == 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(187391);
      return;
    }
    ((Map)lWl).put(paramString1, paramString2);
    AppMethodBeat.o(187391);
  }
  
  public final void Oi(String paramString)
  {
    AppMethodBeat.i(187398);
    if (paramString == null)
    {
      AppMethodBeat.o(187398);
      return;
    }
    Object localObject2 = aw.fK("WAKeyStepKvLogger_RUNNING_PROCESS", 2).allKeys();
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
      if (d.n.n.nb((String)localObject2, paramString)) {
        aw.fK("WAKeyStepKvLogger_RUNNING_PROCESS", 2).remove(str);
      }
      i += 1;
      break;
      aw.fK("WAKeyStepKvLogger_RUNNING_PROCESS", 2).putBoolean(paramString, true).apply();
      aw.fK("WAKeyStepKvLogger_RUNNING_PROCESS", 2).remove(paramString + "_RUNNING_RESOURCE_PREPARING");
      AppMethodBeat.o(187398);
      return;
    }
  }
  
  public final void Oj(String paramString)
  {
    AppMethodBeat.i(187397);
    if (paramString == null)
    {
      AppMethodBeat.o(187397);
      return;
    }
    aw.fK("WAKeyStepKvLogger_RUNNING_PROCESS", 2).remove(paramString).apply();
    aw.fK("WAKeyStepKvLogger_RUNNING_PROCESS", 2).remove(paramString + "_RUNNING_RESOURCE_PREPARING");
    AppMethodBeat.o(187397);
  }
  
  public final void b(String paramString, com.tencent.mm.plugin.appbrand.keylogger.base.a parama, long paramLong)
  {
    AppMethodBeat.i(187392);
    StringBuilder localStringBuilder = new StringBuilder("onStepOk id:").append(paramString).append(" step:");
    if (parama != null) {}
    for (String str = parama.name();; str = null)
    {
      ac.i("MicroMsg.AppBrand.WAKeyStepKvLogger", str + " cost:" + paramLong);
      a(paramString, parama, paramLong, a.lWp);
      AppMethodBeat.o(187392);
      return;
    }
  }
  
  public final void f(String paramString, com.tencent.mm.plugin.appbrand.keylogger.base.a parama)
  {
    AppMethodBeat.i(187396);
    StringBuilder localStringBuilder = new StringBuilder("onStepStart id:").append(paramString).append(" step:");
    if (parama != null) {}
    for (String str = parama.name();; str = null)
    {
      ac.i("MicroMsg.AppBrand.WAKeyStepKvLogger", str);
      a(this, paramString, parama, a.lWo);
      AppMethodBeat.o(187396);
      return;
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/appbrand/report/quality/WAKeyStepKvLogger$REPORT_REASON;", "", "(Ljava/lang/String;I)V", "START", "OK", "FAIL", "plugin-appbrand-integration_release"})
  static enum a
  {
    static
    {
      AppMethodBeat.i(187384);
      a locala1 = new a("START", 0);
      lWo = locala1;
      a locala2 = new a("OK", 1);
      lWp = locala2;
      a locala3 = new a("FAIL", 2);
      lWq = locala3;
      lWr = new a[] { locala1, locala2, locala3 };
      AppMethodBeat.o(187384);
    }
    
    private a() {}
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"makeStruct", "Lcom/tencent/mm/autogen/mmdata/rpt/WALifeCycleTimeAxisItemStruct;", "invoke"})
  static final class b
    extends d.g.b.l
    implements d.g.a.a<ft>
  {
    b(String paramString1, String paramString2, com.tencent.mm.plugin.appbrand.keylogger.base.a parama)
    {
      super();
    }
    
    public final ft btW()
    {
      AppMethodBeat.i(187389);
      ft localft = new ft();
      localft.nm(this.lSk);
      localft.nn(paramString);
      localft.no(parama.name());
      Object localObject = n.lWn;
      localObject = (com.tencent.mm.plugin.appbrand.keylogger.base.a)n.btV().get(parama);
      if (localObject == null)
      {
        localObject = null;
        localft.np((String)localObject);
        localObject = parama.bmQ();
        k.g(localObject, "step.desc()");
        if (!d.n.n.a((CharSequence)localObject, (CharSequence)"(Global)", false)) {
          break label143;
        }
        localft.ko(0L);
      }
      for (;;)
      {
        AppMethodBeat.o(187389);
        return localft;
        if (KSProcessWeAppLaunch.stepLaunch == localObject)
        {
          localObject = "StartUp";
          break;
        }
        localObject = ((com.tencent.mm.plugin.appbrand.keylogger.base.a)localObject).name();
        break;
        label143:
        localObject = parama.bmQ();
        k.g(localObject, "step.desc()");
        if (d.n.n.a((CharSequence)localObject, (CharSequence)"(View)", false))
        {
          localft.ko(1L);
        }
        else
        {
          localObject = parama.bmQ();
          k.g(localObject, "step.desc()");
          if (d.n.n.a((CharSequence)localObject, (CharSequence)"(Service)", false)) {
            localft.ko(2L);
          } else {
            localft.ko(3L);
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.report.quality.n
 * JD-Core Version:    0.7.0.1
 */