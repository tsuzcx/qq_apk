package com.tencent.mm.plugin.appbrand.report.quality;

import android.content.SharedPreferences.Editor;
import com.tencent.mars.smc.SmcLogic;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.kn;
import com.tencent.mm.plugin.appbrand.debugger.DebuggerShell;
import com.tencent.mm.plugin.appbrand.keylogger.base.b;
import com.tencent.mm.plugin.appbrand.keylogger.base.h;
import com.tencent.mm.plugin.appbrand.keylogger.base.i;
import com.tencent.mm.plugin.appbrand.step.KSProcessWeAppLaunch;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.a.v;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.n.n;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/report/quality/WAKeyStepKvLogger;", "Lcom/tencent/mm/plugin/appbrand/keylogger/base/IKeyStepListener;", "()V", "ENABLE", "", "()Z", "MMKV_KEY_SPLITOR_PROCESS_REPORTED_STARTED", "", "MMKV_KEY_SUFFIX_RUNNING_RESOURCE_PREPARING", "MMKV_MARK_RUNNING_PROCESS", "Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "kotlin.jvm.PlatformType", "getMMKV_MARK_RUNNING_PROCESS", "()Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "TAG", "mapAppId2InstanceId", "Ljava/util/concurrent/ConcurrentHashMap;", "mapChild2ParentNode", "Lcom/tencent/mm/plugin/appbrand/keylogger/base/IKeyStep;", "checkReportDebugFlag", "", "onProcessEnd", "sessionId", "onProcessStart", "onStepFail", "step", "cost", "", "onStepOK", "onStepStart", "reportStep", "_cost", "reason", "Lcom/tencent/mm/plugin/appbrand/report/quality/WAKeyStepKvLogger$REPORT_REASON;", "setAppId2InstanceId", "appId", "instanceId", "setChild2ParentMapping", "node", "Lcom/tencent/mm/plugin/appbrand/keylogger/base/StepNodeWrapper;", "reportCustom", "Lcom/tencent/mm/autogen/mmdata/rpt/WALifeCycleTimeAxisItemStruct;", "REPORT_REASON", "plugin-appbrand-integration_release"})
public final class o
  implements b
{
  private static final ConcurrentHashMap<String, String> nMc;
  private static final ConcurrentHashMap<com.tencent.mm.plugin.appbrand.keylogger.base.a, com.tencent.mm.plugin.appbrand.keylogger.base.a> nMd;
  public static final o nMe;
  
  static
  {
    AppMethodBeat.i(229339);
    nMe = new o();
    nMc = new ConcurrentHashMap();
    nMd = new ConcurrentHashMap();
    bVl();
    h localh = com.tencent.mm.plugin.appbrand.keylogger.f.h(KSProcessWeAppLaunch.class, "mp");
    p.g(localh, "root");
    c(localh);
    AppMethodBeat.o(229339);
  }
  
  public static final void a(kn paramkn)
  {
    AppMethodBeat.i(229333);
    p.h(paramkn, "$this$reportCustom");
    boolean bool = DebuggerShell.bAx();
    String str = paramkn.abV();
    Log.d("MicroMsg.AppBrand.WAKeyStepKvLogger", "custom report 19175 " + str + " |reportNow:" + bool);
    com.tencent.mm.plugin.appbrand.report.a locala = com.tencent.mm.plugin.appbrand.report.a.nFX;
    int i = paramkn.getId();
    p.g(str, "rptValue");
    com.tencent.mm.plugin.appbrand.report.a.a(i, bool, bool, bool, new Object[] { str });
    AppMethodBeat.o(229333);
  }
  
  private final void a(final String paramString, final com.tencent.mm.plugin.appbrand.keylogger.base.a parama, long paramLong, a parama1)
  {
    AppMethodBeat.i(229334);
    if (!bVk())
    {
      AppMethodBeat.o(229334);
      return;
    }
    if (parama == null)
    {
      AppMethodBeat.o(229334);
      return;
    }
    if (paramString == null)
    {
      AppMethodBeat.o(229334);
      return;
    }
    if (DebuggerShell.bAx()) {
      SmcLogic.SetDebugFlag(true);
    }
    if ((parama instanceof i)) {
      abV(paramString);
    }
    if (!MultiProcessMMKV.getMMKV("WAKeyStepKvLogger_RUNNING_PROCESS", 2).getBoolean(paramString, false))
    {
      AppMethodBeat.o(229334);
      return;
    }
    Object localObject = (String)nMc.get(paramString);
    if (localObject == null)
    {
      AppMethodBeat.o(229334);
      return;
    }
    p.g(localObject, "mapAppId2InstanceId[appId] ?: return");
    localObject = new b((String)localObject, paramString, parama);
    if ((parama instanceof i))
    {
      paramString = ((b)localObject).bVn();
      paramString.xU("StartUp");
      paramString.tL(0L);
      paramString.tK(Util.nowMilliSecond());
      a(paramString);
      AppMethodBeat.o(229334);
      return;
    }
    if ((parama instanceof com.tencent.mm.plugin.appbrand.keylogger.base.f))
    {
      paramString = ((b)localObject).bVn();
      paramString.xU("StartUp");
      paramString.tL(1L);
      paramString.tK(Util.nowMilliSecond());
      a(paramString);
      AppMethodBeat.o(229334);
      return;
    }
    kn localkn;
    switch (p.$EnumSwitchMapping$0[parama1.ordinal()])
    {
    default: 
      if (MultiProcessMMKV.getMMKV("WAKeyStepKvLogger_RUNNING_PROCESS", 2).containsKey(paramString + "__SPLITOR_PROCESS_REPORTED_STARTED__" + parama.name()))
      {
        paramLong = Util.nowMilliSecond();
        paramLong -= MultiProcessMMKV.getMMKV("WAKeyStepKvLogger_RUNNING_PROCESS", 2).getLong(paramString + "__SPLITOR_PROCESS_REPORTED_STARTED__" + parama.name(), paramLong);
      }
      if (paramLong <= 0L) {
        break label568;
      }
      localkn = ((b)localObject).bVn();
      if (a.nMg != parama1) {
        break;
      }
    }
    for (long l = 1L;; l = 3L)
    {
      localkn.tL(l);
      localkn.tK(Util.nowMilliSecond());
      a(localkn);
      if (MultiProcessMMKV.getMMKV("WAKeyStepKvLogger_RUNNING_PROCESS", 2).containsKey(paramString + "__SPLITOR_PROCESS_REPORTED_STARTED__" + parama.name())) {
        break;
      }
      paramString = ((b)localObject).bVn();
      paramString.tL(0L);
      paramString.tK(Util.nowMilliSecond() - paramLong);
      a(paramString);
      AppMethodBeat.o(229334);
      return;
      if (MultiProcessMMKV.getMMKV("WAKeyStepKvLogger_RUNNING_PROCESS", 2).containsKey(paramString + "__SPLITOR_PROCESS_REPORTED_STARTED__" + parama.name()))
      {
        AppMethodBeat.o(229334);
        return;
      }
      parama1 = ((b)localObject).bVn();
      parama1.tL(0L);
      parama1.tK(Util.nowMilliSecond());
      a(parama1);
      MultiProcessMMKV.getMMKV("WAKeyStepKvLogger_RUNNING_PROCESS", 2).putLong(paramString + "__SPLITOR_PROCESS_REPORTED_STARTED__" + parama.name(), Util.nowMilliSecond());
      AppMethodBeat.o(229334);
      return;
    }
    label568:
    paramString = ((b)localObject).bVn();
    paramString.tL(2L);
    paramString.tK(Util.nowMilliSecond());
    a(paramString);
    AppMethodBeat.o(229334);
  }
  
  public static final boolean bVk()
  {
    AppMethodBeat.i(229328);
    if ((BuildInfo.IS_FLAVOR_RED) || (BuildInfo.IS_FLAVOR_PURPLE) || (DebuggerShell.bAx()))
    {
      AppMethodBeat.o(229328);
      return true;
    }
    AppMethodBeat.o(229328);
    return false;
  }
  
  /* Error */
  public static final void bVl()
  {
    // Byte code:
    //   0: ldc_w 293
    //   3: invokestatic 73	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: invokestatic 126	com/tencent/mm/plugin/appbrand/debugger/DebuggerShell:bAx	()Z
    //   9: ifeq +26 -> 35
    //   12: invokestatic 183	com/tencent/mm/plugin/appbrand/report/quality/o:bVk	()Z
    //   15: ifeq +20 -> 35
    //   18: iconst_1
    //   19: invokestatic 189	com/tencent/mars/smc/SmcLogic:SetDebugFlag	(Z)V
    //   22: iconst_1
    //   23: putstatic 298	com/tencent/mm/plugin/report/a/c:CxC	Z
    //   26: iconst_0
    //   27: iconst_0
    //   28: invokestatic 302	com/tencent/mm/sdk/platformtools/Log:setLevel	(IZ)V
    //   31: iconst_1
    //   32: invokestatic 305	com/tencent/mm/sdk/platformtools/Log:setConsoleLogOpen	(Z)V
    //   35: ldc_w 293
    //   38: invokestatic 113	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   41: return
    //   42: astore_0
    //   43: iconst_1
    //   44: putstatic 298	com/tencent/mm/plugin/report/a/c:CxC	Z
    //   47: goto -21 -> 26
    //   50: astore_0
    //   51: iconst_1
    //   52: putstatic 298	com/tencent/mm/plugin/report/a/c:CxC	Z
    //   55: ldc_w 293
    //   58: invokestatic 113	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   61: aload_0
    //   62: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   42	1	0	localUnsatisfiedLinkError	java.lang.UnsatisfiedLinkError
    //   50	12	0	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   18	22	42	java/lang/UnsatisfiedLinkError
    //   18	22	50	finally
  }
  
  private static void c(h paramh)
  {
    AppMethodBeat.i(229330);
    Object localObject2 = paramh.bNa();
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = (List)v.SXr;
    }
    localObject1 = ((Iterable)localObject1).iterator();
    if (((Iterator)localObject1).hasNext())
    {
      Object localObject3 = (h)((Iterator)localObject1).next();
      p.g(localObject3, "child");
      localObject2 = (Collection)((h)localObject3).bNa();
      if ((localObject2 == null) || (((Collection)localObject2).isEmpty())) {}
      for (int i = 1;; i = 0)
      {
        if (i == 0) {
          c((h)localObject3);
        }
        if (paramh.bNb() == null) {
          break;
        }
        localObject2 = (Map)nMd;
        localObject3 = ((h)localObject3).bNb();
        if (localObject3 == null) {
          p.hyc();
        }
        p.g(localObject3, "child.asStep()!!");
        com.tencent.mm.plugin.appbrand.keylogger.base.a locala = paramh.bNb();
        if (locala == null) {
          p.hyc();
        }
        p.g(locala, "node.asStep()!!");
        ((Map)localObject2).put(localObject3, locala);
        break;
      }
    }
    AppMethodBeat.o(229330);
  }
  
  public static void eI(String paramString1, String paramString2)
  {
    AppMethodBeat.i(229331);
    p.h(paramString2, "instanceId");
    CharSequence localCharSequence = (CharSequence)paramString1;
    if ((localCharSequence == null) || (localCharSequence.length() == 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(229331);
      return;
    }
    ((Map)nMc).put(paramString1, paramString2);
    AppMethodBeat.o(229331);
  }
  
  public final void abV(String paramString)
  {
    AppMethodBeat.i(229338);
    if (paramString == null)
    {
      AppMethodBeat.o(229338);
      return;
    }
    Object localObject2 = MultiProcessMMKV.getMMKV("WAKeyStepKvLogger_RUNNING_PROCESS", 2).allKeys();
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
        break label152;
      }
    }
    label152:
    for (localObject2 = "";; localObject2 = str)
    {
      if (n.J((String)localObject2, paramString, false)) {
        MultiProcessMMKV.getMMKV("WAKeyStepKvLogger_RUNNING_PROCESS", 2).remove(str);
      }
      i += 1;
      break;
      MultiProcessMMKV.getMMKV("WAKeyStepKvLogger_RUNNING_PROCESS", 2).putBoolean(paramString, true).apply();
      MultiProcessMMKV.getMMKV("WAKeyStepKvLogger_RUNNING_PROCESS", 2).remove(paramString + "_RUNNING_RESOURCE_PREPARING");
      AppMethodBeat.o(229338);
      return;
    }
  }
  
  public final void abW(String paramString)
  {
    AppMethodBeat.i(229337);
    if (paramString == null)
    {
      AppMethodBeat.o(229337);
      return;
    }
    MultiProcessMMKV.getMMKV("WAKeyStepKvLogger_RUNNING_PROCESS", 2).remove(paramString).apply();
    MultiProcessMMKV.getMMKV("WAKeyStepKvLogger_RUNNING_PROCESS", 2).remove(paramString + "_RUNNING_RESOURCE_PREPARING");
    if (DebuggerShell.bAx()) {
      com.tencent.mm.plugin.appbrand.report.a.bUe();
    }
    AppMethodBeat.o(229337);
  }
  
  public final void b(String paramString, com.tencent.mm.plugin.appbrand.keylogger.base.a parama, long paramLong)
  {
    AppMethodBeat.i(229332);
    StringBuilder localStringBuilder = new StringBuilder("onStepOk id:").append(paramString).append(" step:");
    if (parama != null) {}
    for (String str = parama.name();; str = null)
    {
      Log.i("MicroMsg.AppBrand.WAKeyStepKvLogger", str + " cost:" + paramLong);
      a(paramString, parama, paramLong, a.nMg);
      AppMethodBeat.o(229332);
      return;
    }
  }
  
  public final void f(String paramString, com.tencent.mm.plugin.appbrand.keylogger.base.a parama)
  {
    AppMethodBeat.i(229336);
    StringBuilder localStringBuilder = new StringBuilder("onStepStart id:").append(paramString).append(" step:");
    if (parama != null) {}
    for (String str = parama.name();; str = null)
    {
      Log.i("MicroMsg.AppBrand.WAKeyStepKvLogger", str);
      a(this, paramString, parama, a.nMf);
      AppMethodBeat.o(229336);
      return;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/report/quality/WAKeyStepKvLogger$REPORT_REASON;", "", "(Ljava/lang/String;I)V", "START", "OK", "FAIL", "plugin-appbrand-integration_release"})
  static enum a
  {
    static
    {
      AppMethodBeat.i(229322);
      a locala1 = new a("START", 0);
      nMf = locala1;
      a locala2 = new a("OK", 1);
      nMg = locala2;
      a locala3 = new a("FAIL", 2);
      nMh = locala3;
      nMi = new a[] { locala1, locala2, locala3 };
      AppMethodBeat.o(229322);
    }
    
    private a() {}
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"makeStruct", "Lcom/tencent/mm/autogen/mmdata/rpt/WALifeCycleTimeAxisItemStruct;", "invoke"})
  static final class b
    extends q
    implements kotlin.g.a.a<kn>
  {
    b(String paramString1, String paramString2, com.tencent.mm.plugin.appbrand.keylogger.base.a parama)
    {
      super();
    }
    
    public final kn bVn()
    {
      AppMethodBeat.i(229327);
      kn localkn = new kn();
      localkn.xS(this.nIb);
      localkn.xT(paramString);
      localkn.xU(parama.name());
      Object localObject = o.nMe;
      localObject = (com.tencent.mm.plugin.appbrand.keylogger.base.a)o.bVm().get(parama);
      if (localObject == null)
      {
        localObject = null;
        localkn.xV((String)localObject);
        localObject = parama.bMW();
        p.g(localObject, "step.desc()");
        if (!n.a((CharSequence)localObject, (CharSequence)"(Global)", false)) {
          break label143;
        }
        localkn.tM(0L);
      }
      for (;;)
      {
        AppMethodBeat.o(229327);
        return localkn;
        if (KSProcessWeAppLaunch.stepLaunch == localObject)
        {
          localObject = "StartUp";
          break;
        }
        localObject = ((com.tencent.mm.plugin.appbrand.keylogger.base.a)localObject).name();
        break;
        label143:
        localObject = parama.bMW();
        p.g(localObject, "step.desc()");
        if (n.a((CharSequence)localObject, (CharSequence)"(View)", false))
        {
          localkn.tM(1L);
        }
        else
        {
          localObject = parama.bMW();
          p.g(localObject, "step.desc()");
          if (n.a((CharSequence)localObject, (CharSequence)"(Service)", false)) {
            localkn.tM(2L);
          } else {
            localkn.tM(3L);
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.report.quality.o
 * JD-Core Version:    0.7.0.1
 */