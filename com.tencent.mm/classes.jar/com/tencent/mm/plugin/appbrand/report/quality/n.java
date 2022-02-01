package com.tencent.mm.plugin.appbrand.report.quality;

import android.content.SharedPreferences.Editor;
import com.tencent.mars.smc.SmcLogic;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.gy;
import com.tencent.mm.plugin.appbrand.debugger.DebuggerShell;
import com.tencent.mm.plugin.appbrand.keylogger.base.b;
import com.tencent.mm.plugin.appbrand.keylogger.base.h;
import com.tencent.mm.plugin.appbrand.keylogger.base.i;
import com.tencent.mm.plugin.appbrand.step.KSProcessWeAppLaunch;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ay;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.sdk.platformtools.j;
import d.a.v;
import d.g.b.p;
import d.g.b.q;
import d.l;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/appbrand/report/quality/WAKeyStepKvLogger;", "Lcom/tencent/mm/plugin/appbrand/keylogger/base/IKeyStepListener;", "()V", "ENABLE", "", "()Z", "MMKV_KEY_SPLITOR_PROCESS_REPORTED_STARTED", "", "MMKV_KEY_SUFFIX_RUNNING_RESOURCE_PREPARING", "MMKV_MARK_RUNNING_PROCESS", "Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "kotlin.jvm.PlatformType", "getMMKV_MARK_RUNNING_PROCESS", "()Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "TAG", "mapAppId2InstanceId", "Ljava/util/concurrent/ConcurrentHashMap;", "mapChild2ParentNode", "Lcom/tencent/mm/plugin/appbrand/keylogger/base/IKeyStep;", "checkReportDebugFlag", "", "onProcessEnd", "sessionId", "onProcessStart", "onStepFail", "step", "cost", "", "onStepOK", "onStepStart", "reportStep", "_cost", "reason", "Lcom/tencent/mm/plugin/appbrand/report/quality/WAKeyStepKvLogger$REPORT_REASON;", "setAppId2InstanceId", "appId", "instanceId", "setChild2ParentMapping", "node", "Lcom/tencent/mm/plugin/appbrand/keylogger/base/StepNodeWrapper;", "reportCustom", "Lcom/tencent/mm/autogen/mmdata/rpt/WALifeCycleTimeAxisItemStruct;", "REPORT_REASON", "plugin-appbrand-integration_release"})
public final class n
  implements b
{
  private static final ConcurrentHashMap<String, String> mAX;
  private static final ConcurrentHashMap<com.tencent.mm.plugin.appbrand.keylogger.base.a, com.tencent.mm.plugin.appbrand.keylogger.base.a> mAY;
  public static final n mAZ;
  
  static
  {
    AppMethodBeat.i(223882);
    mAZ = new n();
    mAX = new ConcurrentHashMap();
    mAY = new ConcurrentHashMap();
    byS();
    h localh = com.tencent.mm.plugin.appbrand.keylogger.f.aA(KSProcessWeAppLaunch.class);
    p.g(localh, "root");
    c(localh);
    AppMethodBeat.o(223882);
  }
  
  public static final void a(gy paramgy)
  {
    AppMethodBeat.i(223876);
    p.h(paramgy, "$this$reportCustom");
    boolean bool = DebuggerShell.bfe();
    String str = paramgy.RC();
    ae.d("MicroMsg.AppBrand.WAKeyStepKvLogger", "custom report 19175 " + str + " |reportNow:" + bool);
    com.tencent.mm.plugin.appbrand.report.a locala = com.tencent.mm.plugin.appbrand.report.a.mvm;
    int i = paramgy.getId();
    p.g(str, "rptValue");
    com.tencent.mm.plugin.appbrand.report.a.a(i, bool, bool, bool, new Object[] { str });
    AppMethodBeat.o(223876);
  }
  
  private final void a(final String paramString, final com.tencent.mm.plugin.appbrand.keylogger.base.a parama, long paramLong, a parama1)
  {
    AppMethodBeat.i(223877);
    if (!byR())
    {
      AppMethodBeat.o(223877);
      return;
    }
    if (parama == null)
    {
      AppMethodBeat.o(223877);
      return;
    }
    if (paramString == null)
    {
      AppMethodBeat.o(223877);
      return;
    }
    if (DebuggerShell.bfe()) {
      SmcLogic.SetDebugFlag(true);
    }
    if ((parama instanceof i)) {
      Sp(paramString);
    }
    if (!ay.gq("WAKeyStepKvLogger_RUNNING_PROCESS", 2).getBoolean(paramString, false))
    {
      AppMethodBeat.o(223877);
      return;
    }
    Object localObject = (String)mAX.get(paramString);
    if (localObject == null)
    {
      AppMethodBeat.o(223877);
      return;
    }
    p.g(localObject, "mapAppId2InstanceId[appId] ?: return");
    localObject = new b((String)localObject, paramString, parama);
    if ((parama instanceof i))
    {
      paramString = ((b)localObject).byU();
      paramString.qi("StartUp");
      paramString.ms(0L);
      paramString.mr(bu.fpO());
      a(paramString);
      AppMethodBeat.o(223877);
      return;
    }
    if ((parama instanceof com.tencent.mm.plugin.appbrand.keylogger.base.f))
    {
      paramString = ((b)localObject).byU();
      paramString.qi("StartUp");
      paramString.ms(1L);
      paramString.mr(bu.fpO());
      a(paramString);
      AppMethodBeat.o(223877);
      return;
    }
    gy localgy;
    switch (o.cqt[parama1.ordinal()])
    {
    default: 
      if (ay.gq("WAKeyStepKvLogger_RUNNING_PROCESS", 2).containsKey(paramString + "__SPLITOR_PROCESS_REPORTED_STARTED__" + parama.name()))
      {
        paramLong = bu.fpO();
        paramLong -= ay.gq("WAKeyStepKvLogger_RUNNING_PROCESS", 2).getLong(paramString + "__SPLITOR_PROCESS_REPORTED_STARTED__" + parama.name(), paramLong);
      }
      if (paramLong <= 0L) {
        break label568;
      }
      localgy = ((b)localObject).byU();
      if (a.mBb != parama1) {
        break;
      }
    }
    for (long l = 1L;; l = 3L)
    {
      localgy.ms(l);
      localgy.mr(bu.fpO());
      a(localgy);
      if (ay.gq("WAKeyStepKvLogger_RUNNING_PROCESS", 2).containsKey(paramString + "__SPLITOR_PROCESS_REPORTED_STARTED__" + parama.name())) {
        break;
      }
      paramString = ((b)localObject).byU();
      paramString.ms(0L);
      paramString.mr(bu.fpO() - paramLong);
      a(paramString);
      AppMethodBeat.o(223877);
      return;
      if (ay.gq("WAKeyStepKvLogger_RUNNING_PROCESS", 2).containsKey(paramString + "__SPLITOR_PROCESS_REPORTED_STARTED__" + parama.name()))
      {
        AppMethodBeat.o(223877);
        return;
      }
      parama1 = ((b)localObject).byU();
      parama1.ms(0L);
      parama1.mr(bu.fpO());
      a(parama1);
      ay.gq("WAKeyStepKvLogger_RUNNING_PROCESS", 2).putLong(paramString + "__SPLITOR_PROCESS_REPORTED_STARTED__" + parama.name(), bu.fpO());
      AppMethodBeat.o(223877);
      return;
    }
    label568:
    paramString = ((b)localObject).byU();
    paramString.ms(2L);
    paramString.mr(bu.fpO());
    a(paramString);
    AppMethodBeat.o(223877);
  }
  
  public static final boolean byR()
  {
    AppMethodBeat.i(223871);
    if ((j.IS_FLAVOR_RED) || (j.IS_FLAVOR_PURPLE) || (DebuggerShell.bfe()))
    {
      AppMethodBeat.o(223871);
      return true;
    }
    AppMethodBeat.o(223871);
    return false;
  }
  
  /* Error */
  public static final void byS()
  {
    // Byte code:
    //   0: ldc_w 293
    //   3: invokestatic 73	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: invokestatic 125	com/tencent/mm/plugin/appbrand/debugger/DebuggerShell:bfe	()Z
    //   9: ifeq +25 -> 34
    //   12: invokestatic 182	com/tencent/mm/plugin/appbrand/report/quality/n:byR	()Z
    //   15: ifeq +19 -> 34
    //   18: iconst_1
    //   19: invokestatic 188	com/tencent/mars/smc/SmcLogic:SetDebugFlag	(Z)V
    //   22: iconst_1
    //   23: putstatic 298	com/tencent/mm/plugin/report/a/c:ywG	Z
    //   26: iconst_0
    //   27: invokestatic 301	com/tencent/mm/sdk/platformtools/ae:abd	(I)V
    //   30: iconst_1
    //   31: invokestatic 304	com/tencent/mm/sdk/platformtools/ae:setConsoleLogOpen	(Z)V
    //   34: ldc_w 293
    //   37: invokestatic 111	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   40: return
    //   41: astore_0
    //   42: iconst_1
    //   43: putstatic 298	com/tencent/mm/plugin/report/a/c:ywG	Z
    //   46: goto -20 -> 26
    //   49: astore_0
    //   50: iconst_1
    //   51: putstatic 298	com/tencent/mm/plugin/report/a/c:ywG	Z
    //   54: ldc_w 293
    //   57: invokestatic 111	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
    AppMethodBeat.i(223873);
    Object localObject2 = paramh.brp();
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = (List)v.NhH;
    }
    localObject1 = ((Iterable)localObject1).iterator();
    if (((Iterator)localObject1).hasNext())
    {
      Object localObject3 = (h)((Iterator)localObject1).next();
      p.g(localObject3, "child");
      localObject2 = (Collection)((h)localObject3).brp();
      if ((localObject2 == null) || (((Collection)localObject2).isEmpty())) {}
      for (int i = 1;; i = 0)
      {
        if (i == 0) {
          c((h)localObject3);
        }
        if (paramh.brq() == null) {
          break;
        }
        localObject2 = (Map)mAY;
        localObject3 = ((h)localObject3).brq();
        if (localObject3 == null) {
          p.gkB();
        }
        p.g(localObject3, "child.asStep()!!");
        com.tencent.mm.plugin.appbrand.keylogger.base.a locala = paramh.brq();
        if (locala == null) {
          p.gkB();
        }
        p.g(locala, "node.asStep()!!");
        ((Map)localObject2).put(localObject3, locala);
        break;
      }
    }
    AppMethodBeat.o(223873);
  }
  
  public static void ep(String paramString1, String paramString2)
  {
    AppMethodBeat.i(223874);
    p.h(paramString2, "instanceId");
    CharSequence localCharSequence = (CharSequence)paramString1;
    if ((localCharSequence == null) || (localCharSequence.length() == 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(223874);
      return;
    }
    ((Map)mAX).put(paramString1, paramString2);
    AppMethodBeat.o(223874);
  }
  
  public final void Sp(String paramString)
  {
    AppMethodBeat.i(223881);
    if (paramString == null)
    {
      AppMethodBeat.o(223881);
      return;
    }
    Object localObject2 = ay.gq("WAKeyStepKvLogger_RUNNING_PROCESS", 2).allKeys();
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
      if (d.n.n.nF((String)localObject2, paramString)) {
        ay.gq("WAKeyStepKvLogger_RUNNING_PROCESS", 2).remove(str);
      }
      i += 1;
      break;
      ay.gq("WAKeyStepKvLogger_RUNNING_PROCESS", 2).putBoolean(paramString, true).apply();
      ay.gq("WAKeyStepKvLogger_RUNNING_PROCESS", 2).remove(paramString + "_RUNNING_RESOURCE_PREPARING");
      AppMethodBeat.o(223881);
      return;
    }
  }
  
  public final void Sq(String paramString)
  {
    AppMethodBeat.i(223880);
    if (paramString == null)
    {
      AppMethodBeat.o(223880);
      return;
    }
    ay.gq("WAKeyStepKvLogger_RUNNING_PROCESS", 2).remove(paramString).apply();
    ay.gq("WAKeyStepKvLogger_RUNNING_PROCESS", 2).remove(paramString + "_RUNNING_RESOURCE_PREPARING");
    if (DebuggerShell.bfe()) {
      com.tencent.mm.plugin.appbrand.report.a.bxS();
    }
    AppMethodBeat.o(223880);
  }
  
  public final void b(String paramString, com.tencent.mm.plugin.appbrand.keylogger.base.a parama, long paramLong)
  {
    AppMethodBeat.i(223875);
    StringBuilder localStringBuilder = new StringBuilder("onStepOk id:").append(paramString).append(" step:");
    if (parama != null) {}
    for (String str = parama.name();; str = null)
    {
      ae.i("MicroMsg.AppBrand.WAKeyStepKvLogger", str + " cost:" + paramLong);
      a(paramString, parama, paramLong, a.mBb);
      AppMethodBeat.o(223875);
      return;
    }
  }
  
  public final void f(String paramString, com.tencent.mm.plugin.appbrand.keylogger.base.a parama)
  {
    AppMethodBeat.i(223879);
    StringBuilder localStringBuilder = new StringBuilder("onStepStart id:").append(paramString).append(" step:");
    if (parama != null) {}
    for (String str = parama.name();; str = null)
    {
      ae.i("MicroMsg.AppBrand.WAKeyStepKvLogger", str);
      a(this, paramString, parama, a.mBa);
      AppMethodBeat.o(223879);
      return;
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/appbrand/report/quality/WAKeyStepKvLogger$REPORT_REASON;", "", "(Ljava/lang/String;I)V", "START", "OK", "FAIL", "plugin-appbrand-integration_release"})
  static enum a
  {
    static
    {
      AppMethodBeat.i(223865);
      a locala1 = new a("START", 0);
      mBa = locala1;
      a locala2 = new a("OK", 1);
      mBb = locala2;
      a locala3 = new a("FAIL", 2);
      mBc = locala3;
      mBd = new a[] { locala1, locala2, locala3 };
      AppMethodBeat.o(223865);
    }
    
    private a() {}
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"makeStruct", "Lcom/tencent/mm/autogen/mmdata/rpt/WALifeCycleTimeAxisItemStruct;", "invoke"})
  static final class b
    extends q
    implements d.g.a.a<gy>
  {
    b(String paramString1, String paramString2, com.tencent.mm.plugin.appbrand.keylogger.base.a parama)
    {
      super();
    }
    
    public final gy byU()
    {
      AppMethodBeat.i(223870);
      gy localgy = new gy();
      localgy.qg(this.mwY);
      localgy.qh(paramString);
      localgy.qi(parama.name());
      Object localObject = n.mAZ;
      localObject = (com.tencent.mm.plugin.appbrand.keylogger.base.a)n.byT().get(parama);
      if (localObject == null)
      {
        localObject = null;
        localgy.qj((String)localObject);
        localObject = parama.brl();
        p.g(localObject, "step.desc()");
        if (!d.n.n.a((CharSequence)localObject, (CharSequence)"(Global)", false)) {
          break label143;
        }
        localgy.mt(0L);
      }
      for (;;)
      {
        AppMethodBeat.o(223870);
        return localgy;
        if (KSProcessWeAppLaunch.stepLaunch == localObject)
        {
          localObject = "StartUp";
          break;
        }
        localObject = ((com.tencent.mm.plugin.appbrand.keylogger.base.a)localObject).name();
        break;
        label143:
        localObject = parama.brl();
        p.g(localObject, "step.desc()");
        if (d.n.n.a((CharSequence)localObject, (CharSequence)"(View)", false))
        {
          localgy.mt(1L);
        }
        else
        {
          localObject = parama.brl();
          p.g(localObject, "step.desc()");
          if (d.n.n.a((CharSequence)localObject, (CharSequence)"(Service)", false)) {
            localgy.mt(2L);
          } else {
            localgy.mt(3L);
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