package com.tencent.luggage.sdk.processes;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.a.j;
import kotlin.f;
import kotlin.g.b.af;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.o;
import kotlin.t;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/luggage/sdk/processes/LuggageMiniProgramProcessManager;", "PROCESS", "Lcom/tencent/luggage/sdk/processes/LuggageMiniProgramProcess;", "PARAMS", "Lcom/tencent/luggage/sdk/processes/LuggageStartParams;", "", "()V", "availableProcess", "", "getAvailableProcess", "()Ljava/util/List;", "availableProcess$delegate", "Lkotlin/Lazy;", "processes", "", "getProcesses", "()[Lcom/tencent/luggage/sdk/processes/LuggageMiniProgramProcess;", "allAppRecords", "Lcom/tencent/luggage/sdk/processes/LuggageMiniProgramRecord;", "clearDuplicatedApp", "", "excludeProcessIndex", "", "appId", "", "closeByAppId", "versionType", "dumpDebugInfo", "findAliveAppRecord", "findProcess", "record", "(Lcom/tencent/luggage/sdk/processes/LuggageMiniProgramRecord;)Lcom/tencent/luggage/sdk/processes/LuggageMiniProgramProcess;", "index", "(I)Lcom/tencent/luggage/sdk/processes/LuggageMiniProgramProcess;", "(Ljava/lang/String;)Lcom/tencent/luggage/sdk/processes/LuggageMiniProgramProcess;", "findProcesses", "predicate", "Lkotlin/Function1;", "", "findRecord", "findRecords", "(Ljava/lang/String;I)[Lcom/tencent/luggage/sdk/processes/LuggageMiniProgramRecord;", "command", "Lkotlin/ParameterName;", "name", "getAliveInstanceId", "getAvailableProcessToPreload", "serviceType", "Lcom/tencent/luggage/sdk/processes/LuggageServiceType;", "(Lcom/tencent/luggage/sdk/processes/LuggageServiceType;)Lcom/tencent/luggage/sdk/processes/LuggageMiniProgramProcess;", "getAvailableProcessToStartup", "type", "(Ljava/lang/String;Lcom/tencent/luggage/sdk/processes/LuggageServiceType;)Lcom/tencent/luggage/sdk/processes/LuggageMiniProgramProcess;", "getAvailableTaskToPreRender", "ret", "Lkotlin/Function2;", "p", "getPersistentTask", "Lkotlin/Pair;", "Lcom/tencent/luggage/sdk/processes/LuggageStartStrategy;", "getPluginTaskToStartup", "getStartStrategyAndTask", "params", "isPersistentApp", "(Lcom/tencent/luggage/sdk/processes/LuggageStartParams;Z)Lkotlin/Pair;", "indexOf", "process", "(Lcom/tencent/luggage/sdk/processes/LuggageMiniProgramProcess;)I", "(Lcom/tencent/luggage/sdk/processes/LuggageStartParams;)Z", "killAll", "killType", "Lcom/tencent/luggage/sdk/processes/KillType;", "killByAppId", "killEmptyProcess", "onPreRenderedAdded", "processIndex", "(ILcom/tencent/luggage/sdk/processes/LuggageStartParams;)V", "onPreRenderedRemoved", "onRuntimeFinish", "onStartWxaApp", "context", "Landroid/content/Context;", "intent", "Landroid/content/Intent;", "strategy", "(Landroid/content/Context;Landroid/content/Intent;Lcom/tencent/luggage/sdk/processes/LuggageStartParams;Lcom/tencent/luggage/sdk/processes/LuggageStartStrategy;)V", "popPersistentApp", "removeApp", "reusePluginTaskIfHadRecords", "(Lcom/tencent/luggage/sdk/processes/LuggageMiniProgramRecord;Lcom/tencent/luggage/sdk/processes/LuggageStartParams;)Lkotlin/Pair;", "sendCloseRuntimeMessage", "sendFinishMessage", "startApp", "(Landroid/content/Context;Lcom/tencent/luggage/sdk/processes/LuggageStartParams;)Lcom/tencent/luggage/sdk/processes/LuggageStartStrategy;", "stashPersistentApp", "instanceId", "taskAlive", "Companion", "luggage-wechat-full-sdk_release"})
public abstract class d<PROCESS extends c<PARAMS>, PARAMS extends g>
{
  public static d<c<g>, g> cBx;
  public static final a cBy = new a((byte)0);
  private final f cBw = kotlin.g.ar((kotlin.g.a.a)new b(this));
  
  private final PROCESS a(String paramString, LuggageServiceType paramLuggageServiceType)
  {
    Object localObject1 = ee(paramString);
    paramString = (String)localObject1;
    int i;
    if (localObject1 == null)
    {
      localObject1 = ((Iterable)RS()).iterator();
      if (!((Iterator)localObject1).hasNext()) {
        break label241;
      }
      paramString = ((Iterator)localObject1).next();
      localObject2 = (c)paramString;
      if ((((c)localObject2).RK()) && (((c)localObject2).cBp.get()) && ((((c)localObject2).cBq == LuggageServiceType.cBR) || (((c)localObject2).cBq == paramLuggageServiceType)))
      {
        i = 1;
        label94:
        if (i == 0) {
          break label239;
        }
        label98:
        paramString = (c)paramString;
      }
    }
    else
    {
      localObject1 = paramString;
      if (paramString == null)
      {
        localObject1 = ((Iterable)RS()).iterator();
        label124:
        if (!((Iterator)localObject1).hasNext()) {
          break label251;
        }
        paramString = ((Iterator)localObject1).next();
        localObject2 = (c)paramString;
        if ((!((c)localObject2).RK()) || ((((c)localObject2).cBq != LuggageServiceType.cBR) && (((c)localObject2).cBq != paramLuggageServiceType))) {
          break label246;
        }
        i = 1;
        label178:
        if (i == 0) {
          break label249;
        }
        label182:
        localObject1 = (c)paramString;
      }
      paramString = (String)localObject1;
      if (localObject1 == null)
      {
        localObject1 = ((Iterable)RS()).iterator();
        if (((Iterator)localObject1).hasNext()) {
          break label256;
        }
        paramString = null;
      }
    }
    label239:
    label241:
    label246:
    label249:
    label251:
    do
    {
      if (paramString == null) {
        p.iCn();
      }
      paramString = (c)paramString;
      return paramString;
      i = 0;
      break label94;
      break;
      paramString = null;
      break label98;
      i = 0;
      break label178;
      break label124;
      paramString = null;
      break label182;
      paramString = ((Iterator)localObject1).next();
    } while (!((Iterator)localObject1).hasNext());
    label256:
    Object localObject2 = (Iterable)((c)paramString).RO();
    paramLuggageServiceType = (Collection)new ArrayList(j.a((Iterable)localObject2, 10));
    localObject2 = ((Iterable)localObject2).iterator();
    while (((Iterator)localObject2).hasNext()) {
      paramLuggageServiceType.add(Long.valueOf(((e)((Iterator)localObject2).next()).cBG));
    }
    paramLuggageServiceType = (Long)j.y((Iterable)paramLuggageServiceType);
    long l1;
    if (paramLuggageServiceType != null) {
      l1 = paramLuggageServiceType.longValue();
    }
    for (;;)
    {
      paramLuggageServiceType = ((Iterator)localObject1).next();
      Object localObject3 = (Iterable)((c)paramLuggageServiceType).RO();
      localObject2 = (Collection)new ArrayList(j.a((Iterable)localObject3, 10));
      localObject3 = ((Iterable)localObject3).iterator();
      for (;;)
      {
        if (((Iterator)localObject3).hasNext())
        {
          ((Collection)localObject2).add(Long.valueOf(((e)((Iterator)localObject3).next()).cBG));
          continue;
          l1 = 0L;
          break;
        }
      }
      localObject2 = (Long)j.y((Iterable)localObject2);
      long l2;
      if (localObject2 != null)
      {
        l2 = ((Long)localObject2).longValue();
        label495:
        if (l1 <= l2) {
          break label524;
        }
        paramString = paramLuggageServiceType;
      }
      for (;;)
      {
        if (((Iterator)localObject1).hasNext()) {
          break label531;
        }
        break;
        l2 = 0L;
        break label495;
        label524:
        l2 = l1;
      }
      label531:
      l1 = l2;
    }
  }
  
  protected abstract PROCESS[] RR();
  
  public final List<PROCESS> RS()
  {
    return (List)this.cBw.getValue();
  }
  
  public void RT()
  {
    Object localObject1 = new ConcurrentHashMap();
    Iterator localIterator = ((Iterable)RS()).iterator();
    Object localObject2;
    String str;
    while (localIterator.hasNext())
    {
      localObject2 = (c)localIterator.next();
      str = ((c)localObject2).getProcessName();
      if (str != null) {
        if (((c)localObject2).RK())
        {
          ((ConcurrentHashMap)localObject1).putIfAbsent(str, Boolean.TRUE);
        }
        else
        {
          localObject2 = (Map)localObject1;
          Boolean localBoolean = Boolean.FALSE;
          p.j(localBoolean, "java.lang.Boolean.FALSE");
          ((Map)localObject2).put(str, localBoolean);
        }
      }
    }
    localIterator = ((Map)localObject1).entrySet().iterator();
    while (localIterator.hasNext())
    {
      localObject1 = (Map.Entry)localIterator.next();
      str = (String)((Map.Entry)localObject1).getKey();
      if (((Boolean)((Map.Entry)localObject1).getValue()).booleanValue())
      {
        Log.i("Luggage.LuggageMiniProgramProcessManager", "killAll SILENT_IF_INACTIVE kill process(%s)", new Object[] { str });
        localObject2 = ((Iterable)RS()).iterator();
        do
        {
          if (!((Iterator)localObject2).hasNext()) {
            break;
          }
          localObject1 = ((Iterator)localObject2).next();
        } while (!p.h(((c)localObject1).getProcessName(), str));
        for (;;)
        {
          localObject1 = (c)localObject1;
          if (localObject1 == null) {
            break;
          }
          ((c)localObject1).RP();
          break;
          localObject1 = null;
        }
      }
    }
    Log.i("Luggage.LuggageMiniProgramProcessManager", "killAll SILENT_IF_INACTIVE");
  }
  
  public final h a(Context paramContext, PARAMS paramPARAMS)
  {
    p.k(paramContext, "context");
    p.k(paramPARAMS, "params");
    String str = paramPARAMS.appId;
    boolean bool2 = a(paramPARAMS);
    Object localObject1 = paramPARAMS.appId;
    int i = paramPARAMS.cBU;
    Object localObject2 = LuggageServiceType.cBT;
    Object localObject3 = LuggageServiceType.a.cj(paramPARAMS.csz);
    Object localObject4 = v((String)localObject1, i);
    boolean bool1;
    if (localObject4.length == 0)
    {
      i = 1;
      if (i != 0) {
        break label352;
      }
      bool1 = true;
      label76:
      Log.i("Luggage.LuggageMiniProgramProcessManager", "getStartStrategyAndTask: isPluginTask[%b]hasLocalRecords[%b]", new Object[] { Boolean.valueOf(bool2), Boolean.valueOf(bool1) });
      if ((!bool2) || (bool1)) {
        break label358;
      }
      i = 1;
      label117:
      if (1 != i) {
        break label363;
      }
      localObject1 = new o(h.cBV, ed((String)localObject1));
      label140:
      ((c)((o)localObject1).My).a((LuggageServiceType)localObject3);
      localObject2 = (h)((o)localObject1).Mx;
      localObject3 = (c)((o)localObject1).My;
      ((c)localObject3).a(paramPARAMS.appId, paramPARAMS.cBU, "", bool2);
      if (!bool2) {
        break label701;
      }
      localObject1 = ((c)localObject3).RN();
      label204:
      localObject4 = new Intent(paramContext, (Class)localObject1);
      if ((paramContext instanceof Activity)) {
        break label711;
      }
      i = 268435456;
    }
    for (;;)
    {
      ((Intent)localObject4).addFlags(i);
      ((Intent)localObject4).putExtra("key_index", RS().indexOf(localObject3));
      Log.i("Luggage.LuggageMiniProgramProcessManager", "startApp: appId:[%s] strategy:[%s] index:[%d] process:[%s],isPersistent:[%b],versionType:[%d],uiClass:[%s]", new Object[] { str, ((h)localObject2).name(), Integer.valueOf(b((c)localObject3)), ((c)localObject3).getProcessName(), Boolean.valueOf(bool2), Integer.valueOf(paramPARAMS.cBU), ((Class)localObject1).getName() });
      a(paramContext, (Intent)localObject4, paramPARAMS, (h)localObject2);
      ef(str);
      return localObject2;
      i = 0;
      break;
      label352:
      bool1 = false;
      break label76;
      label358:
      i = 0;
      break label117;
      label363:
      label375:
      int j;
      if ((bool2) && (bool1))
      {
        i = 1;
        if (1 != i) {
          break label469;
        }
        j = localObject4.length;
        i = 0;
        label387:
        if (i >= j) {
          break label451;
        }
        localObject1 = localObject4[i];
        if (!((e)localObject1).cxb) {
          break label444;
        }
      }
      for (;;)
      {
        if (localObject1 != null) {
          break label457;
        }
        Log.w("Luggage.LuggageMiniProgramProcessManager", "getStartStrategyAndTask: stash task lost, fallback");
        localObject1 = a((e)kotlin.a.e.T((Object[])localObject4), paramPARAMS);
        break;
        i = 0;
        break label375;
        label444:
        i += 1;
        break label387;
        label451:
        localObject1 = null;
      }
      label457:
      localObject1 = a((e)localObject1, paramPARAMS);
      break label140;
      label469:
      if ((!bool2) && (!bool1)) {}
      for (i = 1;; i = 0)
      {
        if (1 != i) {
          break label514;
        }
        localObject1 = new o(h.cBV, a((String)localObject1, (LuggageServiceType)localObject3));
        break;
      }
      label514:
      if ((!bool2) && (bool1))
      {
        i = 1;
        label526:
        if (1 != i) {
          break label687;
        }
        j = localObject4.length;
        i = 0;
        label538:
        if (i >= j) {
          break label641;
        }
        localObject1 = localObject4[i];
        if (!((e)localObject1).cxb) {
          break label634;
        }
        label558:
        if (localObject1 == null) {
          break label660;
        }
        j = localObject4.length;
        i = 0;
        label570:
        if (i >= j) {
          break label654;
        }
        localObject2 = localObject4[i];
        if (!((e)localObject2).cxb) {
          break label647;
        }
      }
      for (;;)
      {
        if (localObject2 == null) {
          p.iCn();
        }
        localObject2 = b((e)localObject2);
        ((e)localObject1).cxb = false;
        localObject1 = new o(h.cBW, localObject2);
        break;
        i = 0;
        break label526;
        label634:
        i += 1;
        break label538;
        label641:
        localObject1 = null;
        break label558;
        label647:
        i += 1;
        break label570;
        label654:
        localObject2 = null;
      }
      label660:
      localObject1 = new o(h.cBW, b((e)kotlin.a.e.T((Object[])localObject4)));
      break label140;
      label687:
      throw ((Throwable)new IllegalStateException("never!"));
      label701:
      localObject1 = ((c)localObject3).RM();
      break label204;
      label711:
      if (!bool2) {
        i = 268435456;
      } else {
        i = 0;
      }
    }
  }
  
  protected o<h, PROCESS> a(e parame, PARAMS paramPARAMS)
  {
    p.k(parame, "record");
    p.k(paramPARAMS, "params");
    paramPARAMS = b(parame);
    h localh = h.cBW;
    parame.cxb = true;
    return new o(localh, paramPARAMS);
  }
  
  public void a(Context paramContext, Intent paramIntent, PARAMS paramPARAMS, h paramh)
  {
    p.k(paramContext, "context");
    p.k(paramIntent, "intent");
    p.k(paramPARAMS, "params");
    p.k(paramh, "strategy");
    paramIntent = new com.tencent.mm.hellhoundlib.b.a().bm(paramIntent);
    com.tencent.mm.hellhoundlib.a.a.b(paramContext, paramIntent.aFh(), "com/tencent/luggage/sdk/processes/LuggageMiniProgramProcessManager", "onStartWxaApp", "(Landroid/content/Context;Landroid/content/Intent;Lcom/tencent/luggage/sdk/processes/LuggageStartParams;Lcom/tencent/luggage/sdk/processes/LuggageStartStrategy;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramContext.startActivity((Intent)paramIntent.sf(0));
    com.tencent.mm.hellhoundlib.a.a.c(paramContext, "com/tencent/luggage/sdk/processes/LuggageMiniProgramProcessManager", "onStartWxaApp", "(Landroid/content/Context;Landroid/content/Intent;Lcom/tencent/luggage/sdk/processes/LuggageStartParams;Lcom/tencent/luggage/sdk/processes/LuggageStartStrategy;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
  }
  
  public final void a(String paramString, int paramInt, kotlin.g.a.b<? super e, x> paramb)
  {
    p.k(paramString, "appId");
    p.k(paramb, "command");
    Object localObject2 = (Iterable)RS();
    Object localObject1 = (Collection)new ArrayList();
    localObject2 = ((Iterable)localObject2).iterator();
    Object localObject3;
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = ((c)((Iterator)localObject2).next()).ec(paramString);
      if (localObject3 != null) {
        ((Collection)localObject1).add(localObject3);
      }
    }
    localObject2 = (List)localObject1;
    if (((List)localObject2).isEmpty()) {
      Log.w("Luggage.LuggageMiniProgramProcessManager", "findRecords: ([%s][%s]) not found", new Object[] { paramString, Integer.valueOf(paramInt) });
    }
    localObject1 = (Iterable)localObject2;
    paramString = (Collection)new ArrayList();
    localObject1 = ((Iterable)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject3 = ((Iterator)localObject1).next();
      if (((e)localObject3).cxb) {
        paramString.add(localObject3);
      }
    }
    int j = ((List)paramString).size();
    localObject1 = (Iterable)localObject2;
    paramString = (Collection)new ArrayList();
    localObject1 = ((Iterable)localObject1).iterator();
    label290:
    while (((Iterator)localObject1).hasNext())
    {
      localObject3 = ((Iterator)localObject1).next();
      if (!((e)localObject3).cxb) {}
      for (i = 1;; i = 0)
      {
        if (i == 0) {
          break label290;
        }
        paramString.add(localObject3);
        break;
      }
    }
    int i = ((List)paramString).size();
    if (((((List)localObject2).size() > 2) || (j > 1) || (i > 1)) && ((BuildInfo.IS_FLAVOR_RED) || (BuildInfo.DEBUG)))
    {
      paramString = af.aaBG;
      paramString = String.format("records size[%d] persistent size[%d] !persistent size[%d]", Arrays.copyOf(new Object[] { Integer.valueOf(((List)localObject2).size()), Integer.valueOf(j), Integer.valueOf(i) }, 3));
      p.j(paramString, "java.lang.String.format(format, *args)");
      throw ((Throwable)new IllegalStateException(paramString));
    }
    localObject1 = ((Iterable)localObject2).iterator();
    if (((Iterator)localObject1).hasNext())
    {
      paramString = ((Iterator)localObject1).next();
      if (!((e)paramString).cxb)
      {
        i = 1;
        label448:
        if (i == 0) {
          break label570;
        }
        label453:
        localObject1 = (e)paramString;
        if (localObject1 == null) {
          break label577;
        }
        if (paramInt >= 0)
        {
          paramString = (String)localObject1;
          if (((e)localObject1).cBI != paramInt) {}
        }
        else
        {
          paramb.invoke(localObject1);
          paramString = (String)localObject1;
        }
        label492:
        if (paramString == null)
        {
          localObject1 = ((Iterable)localObject2).iterator();
          do
          {
            if (!((Iterator)localObject1).hasNext()) {
              break;
            }
            paramString = ((Iterator)localObject1).next();
          } while (!((e)paramString).cxb);
        }
      }
    }
    for (;;)
    {
      paramString = (e)paramString;
      if ((paramString != null) && ((paramInt < 0) || (paramString.cBI == paramInt))) {
        paramb.invoke(paramString);
      }
      return;
      i = 0;
      break label448;
      label570:
      break;
      paramString = null;
      break label453;
      label577:
      paramString = null;
      break label492;
      paramString = null;
    }
  }
  
  public abstract boolean a(PARAMS paramPARAMS);
  
  public final int b(PROCESS paramPROCESS)
  {
    p.k(paramPROCESS, "process");
    return RS().indexOf(paramPROCESS);
  }
  
  public final PROCESS b(e parame)
  {
    p.k(parame, "record");
    Iterator localIterator = ((Iterable)RS()).iterator();
    Object localObject;
    do
    {
      if (!localIterator.hasNext()) {
        break;
      }
      localObject = localIterator.next();
    } while (!((c)localObject).RO().contains(parame));
    for (parame = localObject;; parame = null)
    {
      if (parame == null) {
        p.iCn();
      }
      return (c)parame;
    }
  }
  
  public final void b(b paramb)
  {
    p.k(paramb, "killType");
    if (paramb == b.cBk) {
      RT();
    }
    for (;;)
    {
      return;
      Iterator localIterator = ((Iterable)RS()).iterator();
      while (localIterator.hasNext()) {
        ((c)localIterator.next()).a(paramb);
      }
    }
  }
  
  public abstract void c(e parame);
  
  public PROCESS d(LuggageServiceType paramLuggageServiceType)
  {
    p.k(paramLuggageServiceType, "serviceType");
    if (paramLuggageServiceType != LuggageServiceType.cBR) {}
    for (int i = 1; i == 0; i = 0) {
      throw ((Throwable)new IllegalArgumentException("Failed requirement.".toString()));
    }
    Object localObject2 = (Iterable)RS();
    Object localObject1 = (Collection)new ArrayList();
    localObject2 = ((Iterable)localObject2).iterator();
    Object localObject4;
    label135:
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = ((Iterator)localObject2).next();
      localObject4 = (c)localObject3;
      if ((paramLuggageServiceType == ((c)localObject4).cBq) && (((c)localObject4).RK())) {}
      for (i = 1;; i = 0)
      {
        if (i == 0) {
          break label135;
        }
        ((Collection)localObject1).add(localObject3);
        break;
      }
    }
    Object localObject3 = (List)localObject1;
    if (!((Collection)localObject3).isEmpty())
    {
      i = 1;
      if (i == 0) {
        break label536;
      }
      localObject2 = ((Iterable)localObject3).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject1 = ((Iterator)localObject2).next();
        if (((c)localObject1).cBp.get())
        {
          label205:
          localObject2 = (c)localObject1;
          localObject1 = localObject2;
          if (localObject2 == null) {
            localObject1 = (c)j.lo((List)localObject3);
          }
          Log.i("Luggage.LuggageMiniProgramProcessManager", "getAvailableTaskToPreload found empty task[%s], which can be used as [%s]", new Object[] { ((c)localObject1).RM().getSimpleName(), paramLuggageServiceType });
        }
      }
    }
    for (;;)
    {
      if (localObject1 == null)
      {
        localObject3 = (Iterable)RS();
        localObject2 = (Collection)new ArrayList();
        localObject3 = ((Iterable)localObject3).iterator();
        label289:
        label367:
        for (;;)
        {
          if (!((Iterator)localObject3).hasNext()) {
            break label369;
          }
          localObject4 = ((Iterator)localObject3).next();
          c localc = (c)localObject4;
          if ((localc.cBq == LuggageServiceType.cBR) && (localc.c(paramLuggageServiceType))) {}
          for (i = 1;; i = 0)
          {
            if (i == 0) {
              break label367;
            }
            ((Collection)localObject2).add(localObject4);
            break label289;
            i = 0;
            break;
            localObject1 = null;
            break label205;
          }
        }
        label369:
        localObject3 = (List)localObject2;
        if (!((Collection)localObject3).isEmpty())
        {
          i = 1;
          if (i == 0) {
            break label531;
          }
          localObject2 = ((Iterable)localObject3).iterator();
          for (;;)
          {
            if (((Iterator)localObject2).hasNext())
            {
              localObject1 = ((Iterator)localObject2).next();
              if (((c)localObject1).cBp.get())
              {
                label438:
                localObject2 = (c)localObject1;
                localObject1 = localObject2;
                if (localObject2 == null) {
                  localObject1 = (c)j.lo((List)localObject3);
                }
              }
            }
          }
        }
        label531:
        for (;;)
        {
          if (localObject1 != null)
          {
            localObject2 = ((c)localObject1).RM();
            if (localObject2 != null)
            {
              localObject3 = ((Class)localObject2).getSimpleName();
              localObject2 = localObject3;
              if (localObject3 != null) {
                break label497;
              }
            }
          }
          localObject2 = "null";
          label497:
          Log.i("Luggage.LuggageMiniProgramProcessManager", "tryPreloadNextTaskProcess serviceType = [%s] not reached max limit , got ui task = [%s]", new Object[] { paramLuggageServiceType, localObject2 });
          return localObject1;
          i = 0;
          break;
          localObject1 = null;
          break label438;
        }
      }
      return localObject1;
      label536:
      localObject1 = null;
    }
  }
  
  public final void d(e parame)
  {
    p.k(parame, "record");
    b(parame).a(parame);
  }
  
  public PROCESS ed(String paramString)
  {
    p.k(paramString, "appId");
    return a(paramString, LuggageServiceType.cBP);
  }
  
  public final PROCESS ee(String paramString)
  {
    p.k(paramString, "appId");
    Iterator localIterator = ((Iterable)RS()).iterator();
    Object localObject;
    do
    {
      if (!localIterator.hasNext()) {
        break;
      }
      localObject = localIterator.next();
    } while (!((c)localObject).RL().contains(paramString));
    for (paramString = localObject;; paramString = null) {
      return (c)paramString;
    }
  }
  
  public final void ef(String paramString)
  {
    p.k(paramString, "appId");
    a(paramString, -1, (kotlin.g.a.b)d.f.cBE);
  }
  
  public void eg(String paramString)
  {
    p.k(paramString, "appId");
  }
  
  public final boolean eh(String paramString)
  {
    return w(paramString, -1);
  }
  
  public final PROCESS iS(int paramInt)
  {
    return (c)RS().get(paramInt);
  }
  
  public final void l(final int paramInt, String paramString)
  {
    p.k(paramString, "appId");
    a(paramString, -1, (kotlin.g.a.b)new c(this, paramInt));
  }
  
  public final void u(final String paramString, int paramInt)
  {
    p.k(paramString, "appId");
    a(paramString, paramInt, (kotlin.g.a.b)new e(this, paramString));
  }
  
  public final e[] v(String paramString, int paramInt)
  {
    p.k(paramString, "appId");
    ArrayList localArrayList = new ArrayList();
    a(paramString, paramInt, (kotlin.g.a.b)new d.d(localArrayList));
    paramString = ((Collection)localArrayList).toArray(new e[0]);
    if (paramString == null) {
      throw new t("null cannot be cast to non-null type kotlin.Array<T>");
    }
    return (e[])paramString;
  }
  
  public final boolean w(String paramString, int paramInt)
  {
    p.k(paramString, "appId");
    paramString = x(paramString, paramInt);
    if (paramString == null) {
      return false;
    }
    return b(paramString).cBp.get();
  }
  
  public final e x(String paramString, int paramInt)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/luggage/sdk/processes/LuggageMiniProgramProcessManager$Companion;", "", "()V", "INSTANCE", "Lcom/tencent/luggage/sdk/processes/LuggageMiniProgramProcessManager;", "Lcom/tencent/luggage/sdk/processes/LuggageMiniProgramProcess;", "Lcom/tencent/luggage/sdk/processes/LuggageStartParams;", "INSTANCE$annotations", "getINSTANCE", "()Lcom/tencent/luggage/sdk/processes/LuggageMiniProgramProcessManager;", "setINSTANCE", "(Lcom/tencent/luggage/sdk/processes/LuggageMiniProgramProcessManager;)V", "KEY_PROCESS_INDEX", "", "TAG", "inject", "", "_instance", "luggage-wechat-full-sdk_release"})
  public static final class a
  {
    public static d<c<g>, g> RV()
    {
      AppMethodBeat.i(234084);
      d locald = d.RU();
      if (locald == null) {
        p.bGy("INSTANCE");
      }
      AppMethodBeat.o(234084);
      return locald;
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "PROCESS", "Lcom/tencent/luggage/sdk/processes/LuggageMiniProgramProcess;", "PARAMS", "Lcom/tencent/luggage/sdk/processes/LuggageStartParams;", "run"})
    public static final class a
      implements Runnable
    {
      public static final a cBz;
      
      static
      {
        AppMethodBeat.i(246079);
        cBz = new a();
        AppMethodBeat.o(246079);
      }
      
      public final void run()
      {
        AppMethodBeat.i(246077);
        Object localObject1 = d.cBy;
        localObject1 = ((Iterable)d.a.RV().RS()).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          Object localObject2 = (c)((Iterator)localObject1).next();
          String str = ((c)localObject2).getProcessName();
          if (str != null)
          {
            localObject2 = ((c)localObject2).cBp;
            Object localObject3 = c.cBt;
            localObject3 = MMApplicationContext.getContext();
            p.j(localObject3, "MMApplicationContext.getContext()");
            ((AtomicBoolean)localObject2).set(c.a.isProcessRunning((Context)localObject3, str));
          }
        }
        AppMethodBeat.o(246077);
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Ljava/util/concurrent/CopyOnWriteArrayList;", "PROCESS", "Lcom/tencent/luggage/sdk/processes/LuggageMiniProgramProcess;", "PARAMS", "Lcom/tencent/luggage/sdk/processes/LuggageStartParams;", "invoke"})
  static final class b
    extends q
    implements kotlin.g.a.a<CopyOnWriteArrayList<PROCESS>>
  {
    b(d paramd)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "PROCESS", "Lcom/tencent/luggage/sdk/processes/LuggageMiniProgramProcess;", "PARAMS", "Lcom/tencent/luggage/sdk/processes/LuggageStartParams;", "record", "Lcom/tencent/luggage/sdk/processes/LuggageMiniProgramRecord;", "invoke"})
  static final class c
    extends q
    implements kotlin.g.a.b<e, x>
  {
    c(d paramd, int paramInt)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "PROCESS", "Lcom/tencent/luggage/sdk/processes/LuggageMiniProgramProcess;", "PARAMS", "Lcom/tencent/luggage/sdk/processes/LuggageStartParams;", "record", "Lcom/tencent/luggage/sdk/processes/LuggageMiniProgramRecord;", "invoke"})
  static final class e
    extends q
    implements kotlin.g.a.b<e, x>
  {
    e(d paramd, String paramString)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.luggage.sdk.processes.d
 * JD-Core Version:    0.7.0.1
 */