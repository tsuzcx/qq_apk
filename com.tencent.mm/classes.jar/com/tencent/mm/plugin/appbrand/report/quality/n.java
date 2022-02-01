package com.tencent.mm.plugin.appbrand.report.quality;

import android.content.SharedPreferences.Editor;
import com.tencent.mars.smc.SmcLogic;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.mmdata.rpt.rb;
import com.tencent.mm.plugin.appbrand.debugger.DebuggerShell;
import com.tencent.mm.plugin.appbrand.keylogger.base.b;
import com.tencent.mm.plugin.appbrand.keylogger.base.h;
import com.tencent.mm.plugin.appbrand.keylogger.base.i;
import com.tencent.mm.plugin.appbrand.step.KSProcessWeAppLaunch;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatEnvironment;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.a.ab;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/report/quality/WAKeyStepKvLogger;", "Lcom/tencent/mm/plugin/appbrand/keylogger/base/IKeyStepListener;", "()V", "ENABLE", "", "()Z", "MMKV_KEY_SPLITOR_PROCESS_REPORTED_STARTED", "", "MMKV_KEY_SUFFIX_PROCESS_START_TICK", "MMKV_KEY_SUFFIX_RUNNING_RESOURCE_PREPARING", "MMKV_MARK_RUNNING_PROCESS", "Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "kotlin.jvm.PlatformType", "getMMKV_MARK_RUNNING_PROCESS", "()Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "TAG", "mapAppId2InstanceId", "Ljava/util/concurrent/ConcurrentHashMap;", "mapChild2ParentNode", "Lcom/tencent/mm/plugin/appbrand/keylogger/base/IKeyStep;", "checkReportDebugFlag", "", "onProcessEnd", "sessionId", "onProcessStart", "onStepFail", "step", "cost", "", "onStepOK", "onStepStart", "reportStep", "_cost", "reason", "Lcom/tencent/mm/plugin/appbrand/report/quality/WAKeyStepKvLogger$REPORT_REASON;", "setAppId2InstanceId", "appId", "instanceId", "setChild2ParentMapping", "node", "Lcom/tencent/mm/plugin/appbrand/keylogger/base/StepNodeWrapper;", "reportCustom", "Lcom/tencent/mm/autogen/mmdata/rpt/WALifeCycleTimeAxisItemStruct;", "REPORT_REASON", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class n
  implements b
{
  public static final n tTb;
  private static final ConcurrentHashMap<String, String> tTc;
  private static final ConcurrentHashMap<com.tencent.mm.plugin.appbrand.keylogger.base.a, com.tencent.mm.plugin.appbrand.keylogger.base.a> tTd;
  
  static
  {
    AppMethodBeat.i(321442);
    tTb = new n();
    tTc = new ConcurrentHashMap();
    tTd = new ConcurrentHashMap();
    cJn();
    h localh = com.tencent.mm.plugin.appbrand.keylogger.f.g(KSProcessWeAppLaunch.class, "mp");
    s.s(localh, "root");
    c(localh);
    AppMethodBeat.o(321442);
  }
  
  public static final void a(rb paramrb)
  {
    AppMethodBeat.i(321420);
    s.u(paramrb, "<this>");
    boolean bool = DebuggerShell.cls();
    paramrb = paramrb.aIE();
    if (bool) {}
    for (int i = 1;; i = 0)
    {
      Log.d("MicroMsg.AppBrand.WAKeyStepKvLogger", "custom report 19175 " + paramrb + " |reportNow:" + bool);
      com.tencent.mm.plugin.appbrand.report.a locala = com.tencent.mm.plugin.appbrand.report.a.tMQ;
      s.s(paramrb, "rptValue");
      com.tencent.mm.plugin.appbrand.report.a.a(19175, i, bool, bool, bool, paramrb);
      AppMethodBeat.o(321420);
      return;
    }
  }
  
  private static void a(String paramString, com.tencent.mm.plugin.appbrand.keylogger.base.a parama, long paramLong, a parama1)
  {
    AppMethodBeat.i(321434);
    if (!cJm())
    {
      AppMethodBeat.o(321434);
      return;
    }
    if (parama == null)
    {
      AppMethodBeat.o(321434);
      return;
    }
    if (paramString == null)
    {
      AppMethodBeat.o(321434);
      return;
    }
    if (DebuggerShell.cls()) {
      SmcLogic.SetDebugFlag(true);
    }
    if (!MultiProcessMMKV.getMMKV("WAKeyStepKvLogger_RUNNING_PROCESS", 2).getBoolean(paramString, false))
    {
      AppMethodBeat.o(321434);
      return;
    }
    String str = (String)tTc.get(paramString);
    if (str == null)
    {
      AppMethodBeat.o(321434);
      return;
    }
    if ((parama instanceof i))
    {
      paramString = c(str, paramString, parama);
      paramString.yb("StartUp");
      paramString.iTb = 0L;
      paramString.juC = Util.nowMilliSecond();
      a(paramString);
      AppMethodBeat.o(321434);
      return;
    }
    if ((parama instanceof com.tencent.mm.plugin.appbrand.keylogger.base.f))
    {
      paramString = c(str, paramString, parama);
      paramString.yb("StartUp");
      paramString.iTb = 1L;
      paramString.juC = Util.nowMilliSecond();
      a(paramString);
      AppMethodBeat.o(321434);
      return;
    }
    Object localObject;
    if (b.$EnumSwitchMapping$0[parama1.ordinal()] == 1)
    {
      if (MultiProcessMMKV.getMMKV("WAKeyStepKvLogger_RUNNING_PROCESS", 2).containsKey(paramString + "__SPLITOR_PROCESS_REPORTED_STARTED__" + parama.name()))
      {
        AppMethodBeat.o(321434);
        return;
      }
      localObject = new StringBuilder("onStepStart id:").append(paramString).append(" step:");
      if (parama == null) {}
      for (parama1 = null;; parama1 = parama.name())
      {
        Log.i("MicroMsg.AppBrand.WAKeyStepKvLogger", parama1);
        parama1 = c(str, paramString, parama);
        parama1.iTb = 0L;
        parama1.juC = Util.nowMilliSecond();
        a(parama1);
        MultiProcessMMKV.getMMKV("WAKeyStepKvLogger_RUNNING_PROCESS", 2).putLong(paramString + "__SPLITOR_PROCESS_REPORTED_STARTED__" + parama.name(), Util.nowMilliSecond());
        AppMethodBeat.o(321434);
        return;
      }
    }
    if (MultiProcessMMKV.getMMKV("WAKeyStepKvLogger_RUNNING_PROCESS", 2).containsKey(paramString + "__SPLITOR_PROCESS_REPORTED_STARTED__" + parama.name()))
    {
      paramLong = Util.nowMilliSecond();
      paramLong -= MultiProcessMMKV.getMMKV("WAKeyStepKvLogger_RUNNING_PROCESS", 2).getLong(paramString + "__SPLITOR_PROCESS_REPORTED_STARTED__" + parama.name(), paramLong);
    }
    switch (b.$EnumSwitchMapping$0[parama1.ordinal()])
    {
    default: 
      if (paramLong <= 0L) {
        break label746;
      }
      localObject = c(str, paramString, parama);
      if (a.tTf != parama1) {
        break;
      }
    }
    for (long l = 1L;; l = 3L)
    {
      ((rb)localObject).iTb = l;
      ((rb)localObject).juC = Util.nowMilliSecond();
      a((rb)localObject);
      if (MultiProcessMMKV.getMMKV("WAKeyStepKvLogger_RUNNING_PROCESS", 2).containsKey(paramString + "__SPLITOR_PROCESS_REPORTED_STARTED__" + parama.name())) {
        break label772;
      }
      paramString = c(str, paramString, parama);
      paramString.iTb = 0L;
      paramString.juC = (Util.nowMilliSecond() - paramLong);
      a(paramString);
      AppMethodBeat.o(321434);
      return;
      StringBuilder localStringBuilder = new StringBuilder("onStepFail id:").append(paramString).append(" step:");
      if (parama == null) {}
      for (localObject = null;; localObject = parama.name())
      {
        Log.i("MicroMsg.AppBrand.WAKeyStepKvLogger", localObject + " cost:" + paramLong);
        break;
      }
      localStringBuilder = new StringBuilder("onStepOK id:").append(paramString).append(" step:");
      if (parama == null) {}
      for (localObject = null;; localObject = parama.name())
      {
        Log.i("MicroMsg.AppBrand.WAKeyStepKvLogger", localObject + " cost:" + paramLong);
        break;
      }
    }
    label746:
    paramString = c(str, paramString, parama);
    paramString.iTb = 2L;
    paramString.juC = Util.nowMilliSecond();
    a(paramString);
    label772:
    AppMethodBeat.o(321434);
  }
  
  private static final rb c(String paramString1, String paramString2, com.tencent.mm.plugin.appbrand.keylogger.base.a parama)
  {
    AppMethodBeat.i(321437);
    rb localrb = new rb();
    localrb.xZ(paramString1);
    localrb.ya(paramString2);
    localrb.yb(parama.name());
    paramString1 = (com.tencent.mm.plugin.appbrand.keylogger.base.a)tTd.get(parama);
    if (paramString1 == null)
    {
      paramString1 = null;
      localrb.yc(paramString1);
      paramString1 = parama.czz();
      s.s(paramString1, "step.desc()");
      if (!kotlin.n.n.a((CharSequence)paramString1, (CharSequence)"(Global)", false)) {
        break label127;
      }
      localrb.juF = 0L;
    }
    for (;;)
    {
      AppMethodBeat.o(321437);
      return localrb;
      if (KSProcessWeAppLaunch.stepLaunch == paramString1)
      {
        paramString1 = "StartUp";
        break;
      }
      paramString1 = paramString1.name();
      break;
      label127:
      paramString1 = parama.czz();
      s.s(paramString1, "step.desc()");
      if (kotlin.n.n.a((CharSequence)paramString1, (CharSequence)"(View)", false))
      {
        localrb.juF = 1L;
      }
      else
      {
        paramString1 = parama.czz();
        s.s(paramString1, "step.desc()");
        if (kotlin.n.n.a((CharSequence)paramString1, (CharSequence)"(Service)", false)) {
          localrb.juF = 2L;
        } else {
          localrb.juF = 3L;
        }
      }
    }
  }
  
  private static void c(h paramh)
  {
    AppMethodBeat.i(321407);
    Object localObject2 = paramh.sUX;
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = (List)ab.aivy;
    }
    localObject1 = ((Iterable)localObject1).iterator();
    if (((Iterator)localObject1).hasNext())
    {
      Object localObject3 = (h)((Iterator)localObject1).next();
      localObject2 = (Collection)((h)localObject3).sUX;
      if ((localObject2 == null) || (((Collection)localObject2).isEmpty())) {}
      for (int i = 1;; i = 0)
      {
        if (i == 0)
        {
          s.s(localObject3, "child");
          c((h)localObject3);
        }
        if (paramh.czE() == null) {
          break;
        }
        localObject2 = (Map)tTd;
        localObject3 = ((h)localObject3).czE();
        s.checkNotNull(localObject3);
        s.s(localObject3, "child.asStep()!!");
        com.tencent.mm.plugin.appbrand.keylogger.base.a locala = paramh.czE();
        s.checkNotNull(locala);
        s.s(locala, "node.asStep()!!");
        ((Map)localObject2).put(localObject3, locala);
        break;
      }
    }
    AppMethodBeat.o(321407);
  }
  
  public static final boolean cJm()
  {
    AppMethodBeat.i(321398);
    if ((BuildInfo.IS_FLAVOR_RED) || (BuildInfo.DEBUG) || (BuildInfo.IS_FLAVOR_PURPLE) || (DebuggerShell.cls()) || (WeChatEnvironment.hasDebugger()))
    {
      AppMethodBeat.o(321398);
      return true;
    }
    AppMethodBeat.o(321398);
    return false;
  }
  
  /* Error */
  public static final void cJn()
  {
    // Byte code:
    //   0: ldc_w 399
    //   3: invokestatic 78	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: invokestatic 132	com/tencent/mm/plugin/appbrand/debugger/DebuggerShell:cls	()Z
    //   9: ifeq +26 -> 35
    //   12: invokestatic 184	com/tencent/mm/plugin/appbrand/report/quality/n:cJm	()Z
    //   15: ifeq +20 -> 35
    //   18: iconst_1
    //   19: invokestatic 190	com/tencent/mars/smc/SmcLogic:SetDebugFlag	(Z)V
    //   22: iconst_1
    //   23: putstatic 404	com/tencent/mm/plugin/report/a/c:Ozj	Z
    //   26: iconst_0
    //   27: iconst_0
    //   28: invokestatic 408	com/tencent/mm/sdk/platformtools/Log:setLevel	(IZ)V
    //   31: iconst_1
    //   32: invokestatic 411	com/tencent/mm/sdk/platformtools/Log:setConsoleLogOpen	(Z)V
    //   35: ldc_w 399
    //   38: invokestatic 118	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   41: return
    //   42: astore_0
    //   43: iconst_1
    //   44: putstatic 404	com/tencent/mm/plugin/report/a/c:Ozj	Z
    //   47: goto -21 -> 26
    //   50: astore_0
    //   51: iconst_1
    //   52: putstatic 404	com/tencent/mm/plugin/report/a/c:Ozj	Z
    //   55: ldc_w 399
    //   58: invokestatic 118	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
  
  public static void fn(String paramString1, String paramString2)
  {
    AppMethodBeat.i(321413);
    s.u(paramString2, "instanceId");
    CharSequence localCharSequence = (CharSequence)paramString1;
    if ((localCharSequence == null) || (localCharSequence.length() == 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(321413);
      return;
    }
    ((Map)tTc).put(paramString1, paramString2);
    AppMethodBeat.o(321413);
  }
  
  public final void acQ(String paramString)
  {
    AppMethodBeat.i(321457);
    if (paramString == null)
    {
      AppMethodBeat.o(321457);
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
        break label163;
      }
    }
    label163:
    for (localObject2 = "";; localObject2 = str)
    {
      if (kotlin.n.n.U((String)localObject2, paramString, false)) {
        MultiProcessMMKV.getMMKV("WAKeyStepKvLogger_RUNNING_PROCESS", 2).remove(str);
      }
      i += 1;
      break;
      MultiProcessMMKV.getMMKV("WAKeyStepKvLogger_RUNNING_PROCESS", 2).putBoolean(paramString, true).apply();
      MultiProcessMMKV.getMMKV("WAKeyStepKvLogger_RUNNING_PROCESS", 2).putLong(s.X(paramString, "_PROCESS_START_TICK"), Util.currentTicks()).apply();
      MultiProcessMMKV.getMMKV("WAKeyStepKvLogger_RUNNING_PROCESS", 2).remove(s.X(paramString, "_RUNNING_RESOURCE_PREPARING"));
      AppMethodBeat.o(321457);
      return;
    }
  }
  
  public final void acR(String paramString)
  {
    AppMethodBeat.i(321454);
    if (paramString == null)
    {
      AppMethodBeat.o(321454);
      return;
    }
    long l = MultiProcessMMKV.getMMKV("WAKeyStepKvLogger_RUNNING_PROCESS", 2).getLong(s.X(paramString, "_PROCESS_START_TICK"), 9223372036854775807L);
    MultiProcessMMKV.getMMKV("WAKeyStepKvLogger_RUNNING_PROCESS", 2).removeValueForKey(s.X(paramString, "_PROCESS_START_TICK"));
    if (l < 9223372036854775807L) {
      Log.i("MicroMsg.AppBrand.WAKeyStepKvLogger", "onProcessEnd id:" + paramString + ", cost:" + (Util.currentTicks() - l));
    }
    MultiProcessMMKV.getMMKV("WAKeyStepKvLogger_RUNNING_PROCESS", 2).remove(paramString).apply();
    MultiProcessMMKV.getMMKV("WAKeyStepKvLogger_RUNNING_PROCESS", 2).remove(s.X(paramString, "_RUNNING_RESOURCE_PREPARING"));
    if (DebuggerShell.cls()) {
      com.tencent.mm.plugin.appbrand.report.a.cIh();
    }
    AppMethodBeat.o(321454);
  }
  
  public final void b(String paramString, com.tencent.mm.plugin.appbrand.keylogger.base.a parama, long paramLong)
  {
    AppMethodBeat.i(321445);
    a(paramString, parama, paramLong, a.tTf);
    AppMethodBeat.o(321445);
  }
  
  public final void f(String paramString, com.tencent.mm.plugin.appbrand.keylogger.base.a parama)
  {
    AppMethodBeat.i(321448);
    a(paramString, parama, 0L, a.tTe);
    AppMethodBeat.o(321448);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/report/quality/WAKeyStepKvLogger$REPORT_REASON;", "", "(Ljava/lang/String;I)V", "START", "OK", "FAIL", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
  static enum a
  {
    static
    {
      AppMethodBeat.i(321396);
      tTe = new a("START", 0);
      tTf = new a("OK", 1);
      tTg = new a("FAIL", 2);
      tTh = new a[] { tTe, tTf, tTg };
      AppMethodBeat.o(321396);
    }
    
    private a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.report.quality.n
 * JD-Core Version:    0.7.0.1
 */