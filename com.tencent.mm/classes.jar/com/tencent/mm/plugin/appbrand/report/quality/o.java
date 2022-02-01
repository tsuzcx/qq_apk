package com.tencent.mm.plugin.appbrand.report.quality;

import android.content.SharedPreferences.Editor;
import com.tencent.mars.smc.SmcLogic;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.b.a.nj;
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

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/report/quality/WAKeyStepKvLogger;", "Lcom/tencent/mm/plugin/appbrand/keylogger/base/IKeyStepListener;", "()V", "ENABLE", "", "()Z", "MMKV_KEY_SPLITOR_PROCESS_REPORTED_STARTED", "", "MMKV_KEY_SUFFIX_PROCESS_START_TICK", "MMKV_KEY_SUFFIX_RUNNING_RESOURCE_PREPARING", "MMKV_MARK_RUNNING_PROCESS", "Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "kotlin.jvm.PlatformType", "getMMKV_MARK_RUNNING_PROCESS", "()Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "TAG", "mapAppId2InstanceId", "Ljava/util/concurrent/ConcurrentHashMap;", "mapChild2ParentNode", "Lcom/tencent/mm/plugin/appbrand/keylogger/base/IKeyStep;", "checkReportDebugFlag", "", "onProcessEnd", "sessionId", "onProcessStart", "onStepFail", "step", "cost", "", "onStepOK", "onStepStart", "reportStep", "_cost", "reason", "Lcom/tencent/mm/plugin/appbrand/report/quality/WAKeyStepKvLogger$REPORT_REASON;", "setAppId2InstanceId", "appId", "instanceId", "setChild2ParentMapping", "node", "Lcom/tencent/mm/plugin/appbrand/keylogger/base/StepNodeWrapper;", "reportCustom", "Lcom/tencent/mm/autogen/mmdata/rpt/WALifeCycleTimeAxisItemStruct;", "REPORT_REASON", "plugin-appbrand-integration_release"})
public final class o
  implements b
{
  private static final ConcurrentHashMap<String, String> qOr;
  private static final ConcurrentHashMap<com.tencent.mm.plugin.appbrand.keylogger.base.a, com.tencent.mm.plugin.appbrand.keylogger.base.a> qOs;
  public static final o qOt;
  
  static
  {
    AppMethodBeat.i(274893);
    qOt = new o();
    qOr = new ConcurrentHashMap();
    qOs = new ConcurrentHashMap();
    ciw();
    h localh = com.tencent.mm.plugin.appbrand.keylogger.f.g(KSProcessWeAppLaunch.class, "mp");
    p.j(localh, "root");
    c(localh);
    AppMethodBeat.o(274893);
  }
  
  public static final void a(nj paramnj)
  {
    AppMethodBeat.i(274886);
    p.k(paramnj, "$this$reportCustom");
    boolean bool = DebuggerShell.bLS();
    String str = paramnj.agH();
    if (bool) {}
    for (int i = 1;; i = 0)
    {
      Log.d("MicroMsg.AppBrand.WAKeyStepKvLogger", "custom report 19175 " + str + " |reportNow:" + bool);
      com.tencent.mm.plugin.appbrand.report.a locala = com.tencent.mm.plugin.appbrand.report.a.qIj;
      int j = paramnj.getId();
      p.j(str, "rptValue");
      com.tencent.mm.plugin.appbrand.report.a.a(j, i, bool, bool, bool, str);
      AppMethodBeat.o(274886);
      return;
    }
  }
  
  private static void a(final String paramString, final com.tencent.mm.plugin.appbrand.keylogger.base.a parama, long paramLong, a parama1)
  {
    AppMethodBeat.i(274887);
    if (!civ())
    {
      AppMethodBeat.o(274887);
      return;
    }
    if (parama == null)
    {
      AppMethodBeat.o(274887);
      return;
    }
    if (paramString == null)
    {
      AppMethodBeat.o(274887);
      return;
    }
    if (DebuggerShell.bLS()) {
      SmcLogic.SetDebugFlag(true);
    }
    if (!MultiProcessMMKV.getMMKV("WAKeyStepKvLogger_RUNNING_PROCESS", 2).getBoolean(paramString, false))
    {
      AppMethodBeat.o(274887);
      return;
    }
    Object localObject = (String)qOr.get(paramString);
    if (localObject == null)
    {
      AppMethodBeat.o(274887);
      return;
    }
    p.j(localObject, "mapAppId2InstanceId[appId] ?: return");
    localObject = new b((String)localObject, paramString, parama);
    if ((parama instanceof i))
    {
      paramString = ((b)localObject).ciy();
      paramString.Em("StartUp");
      paramString.zA(0L);
      paramString.zz(Util.nowMilliSecond());
      a(paramString);
      AppMethodBeat.o(274887);
      return;
    }
    if ((parama instanceof com.tencent.mm.plugin.appbrand.keylogger.base.f))
    {
      paramString = ((b)localObject).ciy();
      paramString.Em("StartUp");
      paramString.zA(1L);
      paramString.zz(Util.nowMilliSecond());
      a(paramString);
      AppMethodBeat.o(274887);
      return;
    }
    nj localnj;
    switch (p.jLJ[parama1.ordinal()])
    {
    default: 
      if (MultiProcessMMKV.getMMKV("WAKeyStepKvLogger_RUNNING_PROCESS", 2).containsKey(paramString + "__SPLITOR_PROCESS_REPORTED_STARTED__" + parama.name()))
      {
        paramLong = Util.nowMilliSecond();
        paramLong -= MultiProcessMMKV.getMMKV("WAKeyStepKvLogger_RUNNING_PROCESS", 2).getLong(paramString + "__SPLITOR_PROCESS_REPORTED_STARTED__" + parama.name(), paramLong);
      }
      switch (p.$EnumSwitchMapping$0[parama1.ordinal()])
      {
      default: 
        if (paramLong <= 0L) {
          break label724;
        }
        localnj = ((b)localObject).ciy();
        if (a.qOv != parama1) {}
        break;
      }
      break;
    }
    for (long l = 1L;; l = 3L)
    {
      localnj.zA(l);
      localnj.zz(Util.nowMilliSecond());
      a(localnj);
      if (MultiProcessMMKV.getMMKV("WAKeyStepKvLogger_RUNNING_PROCESS", 2).containsKey(paramString + "__SPLITOR_PROCESS_REPORTED_STARTED__" + parama.name())) {
        break label750;
      }
      paramString = ((b)localObject).ciy();
      paramString.zA(0L);
      paramString.zz(Util.nowMilliSecond() - paramLong);
      a(paramString);
      AppMethodBeat.o(274887);
      return;
      if (MultiProcessMMKV.getMMKV("WAKeyStepKvLogger_RUNNING_PROCESS", 2).containsKey(paramString + "__SPLITOR_PROCESS_REPORTED_STARTED__" + parama.name()))
      {
        AppMethodBeat.o(274887);
        return;
      }
      Log.i("MicroMsg.AppBrand.WAKeyStepKvLogger", "onStepStart id:" + paramString + " step:" + parama.name());
      parama1 = ((b)localObject).ciy();
      parama1.zA(0L);
      parama1.zz(Util.nowMilliSecond());
      a(parama1);
      MultiProcessMMKV.getMMKV("WAKeyStepKvLogger_RUNNING_PROCESS", 2).putLong(paramString + "__SPLITOR_PROCESS_REPORTED_STARTED__" + parama.name(), Util.nowMilliSecond());
      AppMethodBeat.o(274887);
      return;
      Log.i("MicroMsg.AppBrand.WAKeyStepKvLogger", "onStepFail id:" + paramString + " step:" + parama.name() + " cost:" + paramLong);
      break;
      Log.i("MicroMsg.AppBrand.WAKeyStepKvLogger", "onStepOK id:" + paramString + " step:" + parama.name() + " cost:" + paramLong);
      break;
    }
    label724:
    paramString = ((b)localObject).ciy();
    paramString.zA(2L);
    paramString.zz(Util.nowMilliSecond());
    a(paramString);
    label750:
    AppMethodBeat.o(274887);
  }
  
  private static void c(h paramh)
  {
    AppMethodBeat.i(274883);
    Object localObject2 = paramh.bZs();
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = (List)v.aaAd;
    }
    localObject1 = ((Iterable)localObject1).iterator();
    if (((Iterator)localObject1).hasNext())
    {
      Object localObject3 = (h)((Iterator)localObject1).next();
      p.j(localObject3, "child");
      localObject2 = (Collection)((h)localObject3).bZs();
      if ((localObject2 == null) || (((Collection)localObject2).isEmpty())) {}
      for (int i = 1;; i = 0)
      {
        if (i == 0) {
          c((h)localObject3);
        }
        if (paramh.bZt() == null) {
          break;
        }
        localObject2 = (Map)qOs;
        localObject3 = ((h)localObject3).bZt();
        if (localObject3 == null) {
          p.iCn();
        }
        p.j(localObject3, "child.asStep()!!");
        com.tencent.mm.plugin.appbrand.keylogger.base.a locala = paramh.bZt();
        if (locala == null) {
          p.iCn();
        }
        p.j(locala, "node.asStep()!!");
        ((Map)localObject2).put(localObject3, locala);
        break;
      }
    }
    AppMethodBeat.o(274883);
  }
  
  public static final boolean civ()
  {
    AppMethodBeat.i(274880);
    if ((BuildInfo.IS_FLAVOR_RED) || (BuildInfo.DEBUG) || (BuildInfo.IS_FLAVOR_PURPLE) || (DebuggerShell.bLS()))
    {
      AppMethodBeat.o(274880);
      return true;
    }
    AppMethodBeat.o(274880);
    return false;
  }
  
  /* Error */
  public static final void ciw()
  {
    // Byte code:
    //   0: ldc_w 364
    //   3: invokestatic 74	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: invokestatic 128	com/tencent/mm/plugin/appbrand/debugger/DebuggerShell:bLS	()Z
    //   9: ifeq +26 -> 35
    //   12: invokestatic 181	com/tencent/mm/plugin/appbrand/report/quality/o:civ	()Z
    //   15: ifeq +20 -> 35
    //   18: iconst_1
    //   19: invokestatic 187	com/tencent/mars/smc/SmcLogic:SetDebugFlag	(Z)V
    //   22: iconst_1
    //   23: putstatic 369	com/tencent/mm/plugin/report/a/c:IyE	Z
    //   26: iconst_0
    //   27: iconst_0
    //   28: invokestatic 373	com/tencent/mm/sdk/platformtools/Log:setLevel	(IZ)V
    //   31: iconst_1
    //   32: invokestatic 376	com/tencent/mm/sdk/platformtools/Log:setConsoleLogOpen	(Z)V
    //   35: ldc_w 364
    //   38: invokestatic 114	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   41: return
    //   42: astore_0
    //   43: iconst_1
    //   44: putstatic 369	com/tencent/mm/plugin/report/a/c:IyE	Z
    //   47: goto -21 -> 26
    //   50: astore_0
    //   51: iconst_1
    //   52: putstatic 369	com/tencent/mm/plugin/report/a/c:IyE	Z
    //   55: ldc_w 364
    //   58: invokestatic 114	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
  
  public static void eW(String paramString1, String paramString2)
  {
    AppMethodBeat.i(274884);
    p.k(paramString2, "instanceId");
    CharSequence localCharSequence = (CharSequence)paramString1;
    if ((localCharSequence == null) || (localCharSequence.length() == 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(274884);
      return;
    }
    ((Map)qOr).put(paramString1, paramString2);
    AppMethodBeat.o(274884);
  }
  
  public final void ajQ(String paramString)
  {
    AppMethodBeat.i(274892);
    if (paramString == null)
    {
      AppMethodBeat.o(274892);
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
        break label189;
      }
    }
    label189:
    for (localObject2 = "";; localObject2 = str)
    {
      if (n.M((String)localObject2, paramString, false)) {
        MultiProcessMMKV.getMMKV("WAKeyStepKvLogger_RUNNING_PROCESS", 2).remove(str);
      }
      i += 1;
      break;
      MultiProcessMMKV.getMMKV("WAKeyStepKvLogger_RUNNING_PROCESS", 2).putBoolean(paramString, true).apply();
      MultiProcessMMKV.getMMKV("WAKeyStepKvLogger_RUNNING_PROCESS", 2).putLong(paramString + "_PROCESS_START_TICK", Util.currentTicks()).apply();
      MultiProcessMMKV.getMMKV("WAKeyStepKvLogger_RUNNING_PROCESS", 2).remove(paramString + "_RUNNING_RESOURCE_PREPARING");
      AppMethodBeat.o(274892);
      return;
    }
  }
  
  public final void ajR(String paramString)
  {
    AppMethodBeat.i(274891);
    if (paramString == null)
    {
      AppMethodBeat.o(274891);
      return;
    }
    long l = MultiProcessMMKV.getMMKV("WAKeyStepKvLogger_RUNNING_PROCESS", 2).getLong(paramString + "_PROCESS_START_TICK", 9223372036854775807L);
    MultiProcessMMKV.getMMKV("WAKeyStepKvLogger_RUNNING_PROCESS", 2).removeValueForKey(paramString + "_PROCESS_START_TICK");
    if (l < 9223372036854775807L) {
      Log.i("MicroMsg.AppBrand.WAKeyStepKvLogger", "onProcessEnd id:" + paramString + ", cost:" + (Util.currentTicks() - l));
    }
    MultiProcessMMKV.getMMKV("WAKeyStepKvLogger_RUNNING_PROCESS", 2).remove(paramString).apply();
    MultiProcessMMKV.getMMKV("WAKeyStepKvLogger_RUNNING_PROCESS", 2).remove(paramString + "_RUNNING_RESOURCE_PREPARING");
    if (DebuggerShell.bLS()) {
      com.tencent.mm.plugin.appbrand.report.a.chk();
    }
    AppMethodBeat.o(274891);
  }
  
  public final void b(String paramString, com.tencent.mm.plugin.appbrand.keylogger.base.a parama, long paramLong)
  {
    AppMethodBeat.i(274885);
    a(paramString, parama, paramLong, a.qOv);
    AppMethodBeat.o(274885);
  }
  
  public final void f(String paramString, com.tencent.mm.plugin.appbrand.keylogger.base.a parama)
  {
    AppMethodBeat.i(274889);
    a(paramString, parama, 0L, a.qOu);
    AppMethodBeat.o(274889);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/report/quality/WAKeyStepKvLogger$REPORT_REASON;", "", "(Ljava/lang/String;I)V", "START", "OK", "FAIL", "plugin-appbrand-integration_release"})
  static enum a
  {
    static
    {
      AppMethodBeat.i(266163);
      a locala1 = new a("START", 0);
      qOu = locala1;
      a locala2 = new a("OK", 1);
      qOv = locala2;
      a locala3 = new a("FAIL", 2);
      qOw = locala3;
      qOx = new a[] { locala1, locala2, locala3 };
      AppMethodBeat.o(266163);
    }
    
    private a() {}
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"makeStruct", "Lcom/tencent/mm/autogen/mmdata/rpt/WALifeCycleTimeAxisItemStruct;", "invoke"})
  static final class b
    extends q
    implements kotlin.g.a.a<nj>
  {
    b(String paramString1, String paramString2, com.tencent.mm.plugin.appbrand.keylogger.base.a parama)
    {
      super();
    }
    
    public final nj ciy()
    {
      AppMethodBeat.i(284020);
      nj localnj = new nj();
      localnj.Ek(this.qKn);
      localnj.El(paramString);
      localnj.Em(parama.name());
      Object localObject = o.qOt;
      localObject = (com.tencent.mm.plugin.appbrand.keylogger.base.a)o.cix().get(parama);
      if (localObject == null)
      {
        localObject = null;
        localnj.En((String)localObject);
        localObject = parama.bZn();
        p.j(localObject, "step.desc()");
        if (!n.a((CharSequence)localObject, (CharSequence)"(Global)", false)) {
          break label143;
        }
        localnj.zB(0L);
      }
      for (;;)
      {
        AppMethodBeat.o(284020);
        return localnj;
        if (KSProcessWeAppLaunch.stepLaunch == localObject)
        {
          localObject = "StartUp";
          break;
        }
        localObject = ((com.tencent.mm.plugin.appbrand.keylogger.base.a)localObject).name();
        break;
        label143:
        localObject = parama.bZn();
        p.j(localObject, "step.desc()");
        if (n.a((CharSequence)localObject, (CharSequence)"(View)", false))
        {
          localnj.zB(1L);
        }
        else
        {
          localObject = parama.bZn();
          p.j(localObject, "step.desc()");
          if (n.a((CharSequence)localObject, (CharSequence)"(Service)", false)) {
            localnj.zB(2L);
          } else {
            localnj.zB(3L);
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.report.quality.o
 * JD-Core Version:    0.7.0.1
 */