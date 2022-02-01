package com.tencent.mm.plugin.appbrand.report.quality;

import android.content.SharedPreferences.Editor;
import com.tencent.mars.smc.SmcLogic;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.gw;
import com.tencent.mm.plugin.appbrand.debugger.DebuggerShell;
import com.tencent.mm.plugin.appbrand.keylogger.base.b;
import com.tencent.mm.plugin.appbrand.keylogger.base.h;
import com.tencent.mm.plugin.appbrand.step.KSProcessWeAppLaunch;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ax;
import com.tencent.mm.sdk.platformtools.bt;
import d.a.v;
import d.g.b.p;
import d.g.b.q;
import d.l;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/appbrand/report/quality/WAKeyStepKvLogger;", "Lcom/tencent/mm/plugin/appbrand/keylogger/base/IKeyStepListener;", "()V", "ENABLE", "", "()Z", "MMKV_KEY_SPLITOR_PROCESS_REPORTED_STARTED", "", "MMKV_KEY_SUFFIX_RUNNING_RESOURCE_PREPARING", "MMKV_MARK_RUNNING_PROCESS", "Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "kotlin.jvm.PlatformType", "getMMKV_MARK_RUNNING_PROCESS", "()Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "TAG", "mapAppId2InstanceId", "Ljava/util/concurrent/ConcurrentHashMap;", "mapChild2ParentNode", "Lcom/tencent/mm/plugin/appbrand/keylogger/base/IKeyStep;", "checkReportDebugFlag", "", "onProcessEnd", "sessionId", "onProcessStart", "onStepFail", "step", "cost", "", "onStepOK", "onStepStart", "reportStep", "_cost", "reason", "Lcom/tencent/mm/plugin/appbrand/report/quality/WAKeyStepKvLogger$REPORT_REASON;", "setAppId2InstanceId", "appId", "instanceId", "setChild2ParentMapping", "node", "Lcom/tencent/mm/plugin/appbrand/keylogger/base/StepNodeWrapper;", "reportCustom", "Lcom/tencent/mm/autogen/mmdata/rpt/WALifeCycleTimeAxisItemStruct;", "REPORT_REASON", "plugin-appbrand-integration_release"})
public final class n
  implements b
{
  private static final ConcurrentHashMap<String, String> mwa;
  private static final ConcurrentHashMap<com.tencent.mm.plugin.appbrand.keylogger.base.a, com.tencent.mm.plugin.appbrand.keylogger.base.a> mwb;
  public static final n mwc;
  
  static
  {
    AppMethodBeat.i(189612);
    mwc = new n();
    mwa = new ConcurrentHashMap();
    mwb = new ConcurrentHashMap();
    bxZ();
    h localh = com.tencent.mm.plugin.appbrand.keylogger.f.aA(KSProcessWeAppLaunch.class);
    p.g(localh, "root");
    c(localh);
    AppMethodBeat.o(189612);
  }
  
  public static final void a(gw paramgw)
  {
    AppMethodBeat.i(189606);
    p.h(paramgw, "$this$reportCustom");
    boolean bool = DebuggerShell.bew();
    String str = paramgw.RD();
    ad.d("MicroMsg.AppBrand.WAKeyStepKvLogger", "custom report 19175 " + str + " |reportNow:" + bool);
    com.tencent.mm.plugin.appbrand.report.a locala = com.tencent.mm.plugin.appbrand.report.a.mqo;
    int i = paramgw.getId();
    p.g(str, "rptValue");
    com.tencent.mm.plugin.appbrand.report.a.a(i, bool, bool, bool, new Object[] { str });
    AppMethodBeat.o(189606);
  }
  
  private final void a(final String paramString, final com.tencent.mm.plugin.appbrand.keylogger.base.a parama, long paramLong, n.a parama1)
  {
    AppMethodBeat.i(189607);
    if (!bxY())
    {
      AppMethodBeat.o(189607);
      return;
    }
    if (parama == null)
    {
      AppMethodBeat.o(189607);
      return;
    }
    if (paramString == null)
    {
      AppMethodBeat.o(189607);
      return;
    }
    if (DebuggerShell.bew()) {
      SmcLogic.SetDebugFlag(true);
    }
    if ((parama instanceof com.tencent.mm.plugin.appbrand.keylogger.base.i)) {
      RG(paramString);
    }
    if (!ax.gh("WAKeyStepKvLogger_RUNNING_PROCESS", 2).getBoolean(paramString, false))
    {
      AppMethodBeat.o(189607);
      return;
    }
    Object localObject = (String)mwa.get(paramString);
    if (localObject == null)
    {
      AppMethodBeat.o(189607);
      return;
    }
    p.g(localObject, "mapAppId2InstanceId[appId] ?: return");
    localObject = new b((String)localObject, paramString, parama);
    if ((parama instanceof com.tencent.mm.plugin.appbrand.keylogger.base.i))
    {
      paramString = ((b)localObject).byb();
      paramString.pN("StartUp");
      paramString.mg(0L);
      paramString.mf(bt.flT());
      a(paramString);
      AppMethodBeat.o(189607);
      return;
    }
    if ((parama instanceof com.tencent.mm.plugin.appbrand.keylogger.base.f))
    {
      paramString = ((b)localObject).byb();
      paramString.pN("StartUp");
      paramString.mg(1L);
      paramString.mf(bt.flT());
      a(paramString);
      AppMethodBeat.o(189607);
      return;
    }
    gw localgw;
    switch (o.cpQ[parama1.ordinal()])
    {
    default: 
      if (ax.gh("WAKeyStepKvLogger_RUNNING_PROCESS", 2).containsKey(paramString + "__SPLITOR_PROCESS_REPORTED_STARTED__" + parama.name()))
      {
        paramLong = bt.flT();
        paramLong -= ax.gh("WAKeyStepKvLogger_RUNNING_PROCESS", 2).getLong(paramString + "__SPLITOR_PROCESS_REPORTED_STARTED__" + parama.name(), paramLong);
      }
      if (paramLong <= 0L) {
        break label568;
      }
      localgw = ((b)localObject).byb();
      if (n.a.mwe != parama1) {
        break;
      }
    }
    for (long l = 1L;; l = 3L)
    {
      localgw.mg(l);
      localgw.mf(bt.flT());
      a(localgw);
      if (ax.gh("WAKeyStepKvLogger_RUNNING_PROCESS", 2).containsKey(paramString + "__SPLITOR_PROCESS_REPORTED_STARTED__" + parama.name())) {
        break;
      }
      paramString = ((b)localObject).byb();
      paramString.mg(0L);
      paramString.mf(bt.flT() - paramLong);
      a(paramString);
      AppMethodBeat.o(189607);
      return;
      if (ax.gh("WAKeyStepKvLogger_RUNNING_PROCESS", 2).containsKey(paramString + "__SPLITOR_PROCESS_REPORTED_STARTED__" + parama.name()))
      {
        AppMethodBeat.o(189607);
        return;
      }
      parama1 = ((b)localObject).byb();
      parama1.mg(0L);
      parama1.mf(bt.flT());
      a(parama1);
      ax.gh("WAKeyStepKvLogger_RUNNING_PROCESS", 2).putLong(paramString + "__SPLITOR_PROCESS_REPORTED_STARTED__" + parama.name(), bt.flT());
      AppMethodBeat.o(189607);
      return;
    }
    label568:
    paramString = ((b)localObject).byb();
    paramString.mg(2L);
    paramString.mf(bt.flT());
    a(paramString);
    AppMethodBeat.o(189607);
  }
  
  public static final boolean bxY()
  {
    return (com.tencent.mm.sdk.platformtools.i.IS_FLAVOR_RED) || (com.tencent.mm.sdk.platformtools.i.IS_FLAVOR_PURPLE);
  }
  
  /* Error */
  public static final void bxZ()
  {
    // Byte code:
    //   0: ldc_w 292
    //   3: invokestatic 72	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: invokestatic 125	com/tencent/mm/plugin/appbrand/debugger/DebuggerShell:bew	()Z
    //   9: ifeq +25 -> 34
    //   12: invokestatic 182	com/tencent/mm/plugin/appbrand/report/quality/n:bxY	()Z
    //   15: ifeq +19 -> 34
    //   18: iconst_1
    //   19: invokestatic 188	com/tencent/mars/smc/SmcLogic:SetDebugFlag	(Z)V
    //   22: iconst_1
    //   23: putstatic 297	com/tencent/mm/plugin/report/a/c:ygP	Z
    //   26: iconst_0
    //   27: invokestatic 300	com/tencent/mm/sdk/platformtools/ad:aax	(I)V
    //   30: iconst_1
    //   31: invokestatic 303	com/tencent/mm/sdk/platformtools/ad:setConsoleLogOpen	(Z)V
    //   34: ldc_w 292
    //   37: invokestatic 110	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   40: return
    //   41: astore_0
    //   42: iconst_1
    //   43: putstatic 297	com/tencent/mm/plugin/report/a/c:ygP	Z
    //   46: goto -20 -> 26
    //   49: astore_0
    //   50: iconst_1
    //   51: putstatic 297	com/tencent/mm/plugin/report/a/c:ygP	Z
    //   54: ldc_w 292
    //   57: invokestatic 110	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   60: aload_0
    //   61: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   41	1	0	localUnsatisfiedLinkError	java.lang.UnsatisfiedLinkError
    //   49	12	0	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   18	22	41	java/lang/UnsatisfiedLinkError
    //   18	22	49	finally
  }
  
  private static void c(h paramh)
  {
    AppMethodBeat.i(189603);
    Object localObject2 = paramh.bqF();
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = (List)v.MKE;
    }
    localObject1 = ((Iterable)localObject1).iterator();
    if (((Iterator)localObject1).hasNext())
    {
      Object localObject3 = (h)((Iterator)localObject1).next();
      p.g(localObject3, "child");
      localObject2 = (Collection)((h)localObject3).bqF();
      if ((localObject2 == null) || (((Collection)localObject2).isEmpty())) {}
      for (int i = 1;; i = 0)
      {
        if (i == 0) {
          c((h)localObject3);
        }
        if (paramh.bqG() == null) {
          break;
        }
        localObject2 = (Map)mwb;
        localObject3 = ((h)localObject3).bqG();
        if (localObject3 == null) {
          p.gfZ();
        }
        p.g(localObject3, "child.asStep()!!");
        com.tencent.mm.plugin.appbrand.keylogger.base.a locala = paramh.bqG();
        if (locala == null) {
          p.gfZ();
        }
        p.g(locala, "node.asStep()!!");
        ((Map)localObject2).put(localObject3, locala);
        break;
      }
    }
    AppMethodBeat.o(189603);
  }
  
  public static void em(String paramString1, String paramString2)
  {
    AppMethodBeat.i(189604);
    p.h(paramString2, "instanceId");
    CharSequence localCharSequence = (CharSequence)paramString1;
    if ((localCharSequence == null) || (localCharSequence.length() == 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(189604);
      return;
    }
    ((Map)mwa).put(paramString1, paramString2);
    AppMethodBeat.o(189604);
  }
  
  public final void RG(String paramString)
  {
    AppMethodBeat.i(189611);
    if (paramString == null)
    {
      AppMethodBeat.o(189611);
      return;
    }
    Object localObject2 = ax.gh("WAKeyStepKvLogger_RUNNING_PROCESS", 2).allKeys();
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
      if (d.n.n.nz((String)localObject2, paramString)) {
        ax.gh("WAKeyStepKvLogger_RUNNING_PROCESS", 2).remove(str);
      }
      i += 1;
      break;
      ax.gh("WAKeyStepKvLogger_RUNNING_PROCESS", 2).putBoolean(paramString, true).apply();
      ax.gh("WAKeyStepKvLogger_RUNNING_PROCESS", 2).remove(paramString + "_RUNNING_RESOURCE_PREPARING");
      AppMethodBeat.o(189611);
      return;
    }
  }
  
  public final void RH(String paramString)
  {
    AppMethodBeat.i(189610);
    if (paramString == null)
    {
      AppMethodBeat.o(189610);
      return;
    }
    ax.gh("WAKeyStepKvLogger_RUNNING_PROCESS", 2).remove(paramString).apply();
    ax.gh("WAKeyStepKvLogger_RUNNING_PROCESS", 2).remove(paramString + "_RUNNING_RESOURCE_PREPARING");
    if (DebuggerShell.bew()) {
      com.tencent.mm.plugin.appbrand.report.a.bwZ();
    }
    AppMethodBeat.o(189610);
  }
  
  public final void b(String paramString, com.tencent.mm.plugin.appbrand.keylogger.base.a parama, long paramLong)
  {
    AppMethodBeat.i(189605);
    StringBuilder localStringBuilder = new StringBuilder("onStepOk id:").append(paramString).append(" step:");
    if (parama != null) {}
    for (String str = parama.name();; str = null)
    {
      ad.i("MicroMsg.AppBrand.WAKeyStepKvLogger", str + " cost:" + paramLong);
      a(paramString, parama, paramLong, n.a.mwe);
      AppMethodBeat.o(189605);
      return;
    }
  }
  
  public final void f(String paramString, com.tencent.mm.plugin.appbrand.keylogger.base.a parama)
  {
    AppMethodBeat.i(189609);
    StringBuilder localStringBuilder = new StringBuilder("onStepStart id:").append(paramString).append(" step:");
    if (parama != null) {}
    for (String str = parama.name();; str = null)
    {
      ad.i("MicroMsg.AppBrand.WAKeyStepKvLogger", str);
      a(this, paramString, parama, n.a.mwd);
      AppMethodBeat.o(189609);
      return;
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"makeStruct", "Lcom/tencent/mm/autogen/mmdata/rpt/WALifeCycleTimeAxisItemStruct;", "invoke"})
  static final class b
    extends q
    implements d.g.a.a<gw>
  {
    b(String paramString1, String paramString2, com.tencent.mm.plugin.appbrand.keylogger.base.a parama)
    {
      super();
    }
    
    public final gw byb()
    {
      AppMethodBeat.i(189601);
      gw localgw = new gw();
      localgw.pL(this.msa);
      localgw.pM(paramString);
      localgw.pN(parama.name());
      Object localObject = n.mwc;
      localObject = (com.tencent.mm.plugin.appbrand.keylogger.base.a)n.bya().get(parama);
      if (localObject == null)
      {
        localObject = null;
        localgw.pO((String)localObject);
        localObject = parama.bqB();
        p.g(localObject, "step.desc()");
        if (!d.n.n.a((CharSequence)localObject, (CharSequence)"(Global)", false)) {
          break label143;
        }
        localgw.mh(0L);
      }
      for (;;)
      {
        AppMethodBeat.o(189601);
        return localgw;
        if (KSProcessWeAppLaunch.stepLaunch == localObject)
        {
          localObject = "StartUp";
          break;
        }
        localObject = ((com.tencent.mm.plugin.appbrand.keylogger.base.a)localObject).name();
        break;
        label143:
        localObject = parama.bqB();
        p.g(localObject, "step.desc()");
        if (d.n.n.a((CharSequence)localObject, (CharSequence)"(View)", false))
        {
          localgw.mh(1L);
        }
        else
        {
          localObject = parama.bqB();
          p.g(localObject, "step.desc()");
          if (d.n.n.a((CharSequence)localObject, (CharSequence)"(Service)", false)) {
            localgw.mh(2L);
          } else {
            localgw.mh(3L);
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