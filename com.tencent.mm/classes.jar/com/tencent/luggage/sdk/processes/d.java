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
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.ah;
import kotlin.g.a.m;
import kotlin.g.b.am;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.j;
import kotlin.r;

@Metadata(d1={""}, d2={"Lcom/tencent/luggage/sdk/processes/LuggageMiniProgramProcessManager;", "PROCESS", "Lcom/tencent/luggage/sdk/processes/LuggageMiniProgramProcess;", "PARAMS", "Lcom/tencent/luggage/sdk/processes/LuggageStartParams;", "", "()V", "availableProcess", "", "getAvailableProcess", "()Ljava/util/List;", "availableProcess$delegate", "Lkotlin/Lazy;", "processes", "", "getProcesses", "()[Lcom/tencent/luggage/sdk/processes/LuggageMiniProgramProcess;", "allAppRecords", "Lcom/tencent/luggage/sdk/processes/LuggageMiniProgramRecord;", "clearDuplicatedApp", "", "excludeProcessIndex", "", "appId", "", "closeByAppId", "versionType", "dumpDebugInfo", "findAliveAppRecord", "findProcess", "record", "(Lcom/tencent/luggage/sdk/processes/LuggageMiniProgramRecord;)Lcom/tencent/luggage/sdk/processes/LuggageMiniProgramProcess;", "index", "(I)Lcom/tencent/luggage/sdk/processes/LuggageMiniProgramProcess;", "(Ljava/lang/String;)Lcom/tencent/luggage/sdk/processes/LuggageMiniProgramProcess;", "findProcesses", "predicate", "Lkotlin/Function1;", "", "findRecord", "findRecords", "(Ljava/lang/String;I)[Lcom/tencent/luggage/sdk/processes/LuggageMiniProgramRecord;", "command", "Lkotlin/ParameterName;", "name", "getAliveInstanceId", "getAvailableProcessToPreload", "serviceType", "Lcom/tencent/luggage/sdk/processes/LuggageServiceType;", "(Lcom/tencent/luggage/sdk/processes/LuggageServiceType;)Lcom/tencent/luggage/sdk/processes/LuggageMiniProgramProcess;", "getAvailableProcessToStartup", "type", "(Ljava/lang/String;Lcom/tencent/luggage/sdk/processes/LuggageServiceType;)Lcom/tencent/luggage/sdk/processes/LuggageMiniProgramProcess;", "getAvailableTaskToPreRender", "ret", "Lkotlin/Function2;", "p", "getPersistentTask", "Lkotlin/Pair;", "Lcom/tencent/luggage/sdk/processes/LuggageStartStrategy;", "getPluginTaskToStartup", "getStartStrategyAndTask", "params", "isPersistentApp", "(Lcom/tencent/luggage/sdk/processes/LuggageStartParams;Z)Lkotlin/Pair;", "handleNotPersistentCase", "localRecords", "([Lcom/tencent/luggage/sdk/processes/LuggageMiniProgramRecord;)Lkotlin/Pair;", "indexOf", "process", "(Lcom/tencent/luggage/sdk/processes/LuggageMiniProgramProcess;)I", "(Lcom/tencent/luggage/sdk/processes/LuggageStartParams;)Z", "killAll", "killType", "Lcom/tencent/luggage/sdk/processes/KillType;", "killAllApps", "killByAppId", "sync", "killEmptyProcess", "onPreRenderedAdded", "processIndex", "(ILcom/tencent/luggage/sdk/processes/LuggageStartParams;)V", "onPreRenderedRemoved", "onRuntimeFinish", "onStartWxaApp", "context", "Landroid/content/Context;", "intent", "Landroid/content/Intent;", "strategy", "appRecord", "(Landroid/content/Context;Landroid/content/Intent;Lcom/tencent/luggage/sdk/processes/LuggageStartParams;Lcom/tencent/luggage/sdk/processes/LuggageStartStrategy;Lcom/tencent/luggage/sdk/processes/LuggageMiniProgramRecord;)V", "popPersistentApp", "removeApp", "reusePluginTaskIfHadRecords", "(Lcom/tencent/luggage/sdk/processes/LuggageMiniProgramRecord;Lcom/tencent/luggage/sdk/processes/LuggageStartParams;)Lkotlin/Pair;", "sendCloseRuntimeMessage", "sendFinishMessage", "sendFinishMessageSync", "startApp", "(Landroid/content/Context;Lcom/tencent/luggage/sdk/processes/LuggageStartParams;)Lcom/tencent/luggage/sdk/processes/LuggageStartStrategy;", "stashPersistentApp", "instanceId", "taskAlive", "Companion", "luggage-wechat-full-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract class d<PROCESS extends c<PARAMS>, PARAMS extends g>
{
  public static final a eua = new a((byte)0);
  public static d<c<g>, g> euc;
  private final j eub = kotlin.k.cm((kotlin.g.a.a)new b(this));
  
  private final PROCESS a(String paramString, LuggageServiceType paramLuggageServiceType)
  {
    Object localObject1 = fx(paramString);
    paramString = (String)localObject1;
    int i;
    if (localObject1 == null)
    {
      localObject1 = ((Iterable)asg()).iterator();
      if (!((Iterator)localObject1).hasNext()) {
        break label238;
      }
      paramString = ((Iterator)localObject1).next();
      localObject2 = (c)paramString;
      if ((((c)localObject2).arY()) && (((c)localObject2).etW.get()) && ((((c)localObject2).etX == LuggageServiceType.eux) || (((c)localObject2).etX == paramLuggageServiceType)))
      {
        i = 1;
        label94:
        if (i == 0) {
          break label236;
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
        localObject1 = ((Iterable)asg()).iterator();
        label124:
        if (!((Iterator)localObject1).hasNext()) {
          break label248;
        }
        paramString = ((Iterator)localObject1).next();
        localObject2 = (c)paramString;
        if ((!((c)localObject2).arY()) || ((((c)localObject2).etX != LuggageServiceType.eux) && (((c)localObject2).etX != paramLuggageServiceType))) {
          break label243;
        }
        i = 1;
        label178:
        if (i == 0) {
          break label246;
        }
        label182:
        localObject1 = (c)paramString;
      }
      paramString = (String)localObject1;
      if (localObject1 == null)
      {
        localObject1 = ((Iterable)asg()).iterator();
        if (((Iterator)localObject1).hasNext()) {
          break label253;
        }
        paramString = null;
      }
    }
    label236:
    label238:
    label243:
    label246:
    label248:
    label253:
    do
    {
      s.checkNotNull(paramString);
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
    Object localObject2 = (Iterable)((c)paramString).asd();
    paramLuggageServiceType = (Collection)new ArrayList(p.a((Iterable)localObject2, 10));
    localObject2 = ((Iterable)localObject2).iterator();
    while (((Iterator)localObject2).hasNext()) {
      paramLuggageServiceType.add(Long.valueOf(((e)((Iterator)localObject2).next()).euo));
    }
    paramLuggageServiceType = (Long)p.z((Iterable)paramLuggageServiceType);
    long l1;
    if (paramLuggageServiceType == null) {
      l1 = 0L;
    }
    for (;;)
    {
      paramLuggageServiceType = ((Iterator)localObject1).next();
      Object localObject3 = (Iterable)((c)paramLuggageServiceType).asd();
      localObject2 = (Collection)new ArrayList(p.a((Iterable)localObject3, 10));
      localObject3 = ((Iterable)localObject3).iterator();
      for (;;)
      {
        if (((Iterator)localObject3).hasNext())
        {
          ((Collection)localObject2).add(Long.valueOf(((e)((Iterator)localObject3).next()).euo));
          continue;
          l1 = paramLuggageServiceType.longValue();
          break;
        }
      }
      localObject2 = (Long)p.z((Iterable)localObject2);
      long l2;
      if (localObject2 == null)
      {
        l2 = 0L;
        label488:
        if (l1 <= l2) {
          break label521;
        }
        paramString = paramLuggageServiceType;
      }
      for (;;)
      {
        if (((Iterator)localObject1).hasNext()) {
          break label528;
        }
        break;
        l2 = ((Long)localObject2).longValue();
        break label488;
        label521:
        l2 = l1;
      }
      label528:
      l1 = l2;
    }
  }
  
  private final r<h, PROCESS> a(PARAMS paramPARAMS, boolean paramBoolean)
  {
    int k = 0;
    final String str = paramPARAMS.appId;
    int i = paramPARAMS.euz;
    Object localObject = LuggageServiceType.euu;
    final LuggageServiceType localLuggageServiceType = LuggageServiceType.a.cQ(paramPARAMS.ekt);
    e[] arrayOfe = B(str, i);
    localObject = kotlin.k.cm((kotlin.g.a.a)new e(this, str, localLuggageServiceType));
    label71:
    int j;
    if (arrayOfe.length == 0)
    {
      i = 1;
      if (i != 0) {
        break label124;
      }
      i = 1;
      if ((!paramBoolean) || (i != 0)) {
        break label129;
      }
      j = 1;
      label82:
      if (1 != j) {
        break label135;
      }
      paramPARAMS = new r(h.euA, fw(str));
    }
    for (;;)
    {
      ((c)paramPARAMS.bsD).a(localLuggageServiceType);
      return paramPARAMS;
      i = 0;
      break;
      label124:
      i = 0;
      break label71;
      label129:
      j = 0;
      break label82;
      label135:
      if ((paramBoolean) && (i != 0))
      {
        j = 1;
        label146:
        if (1 != j) {
          break label262;
        }
        j = arrayOfe.length;
        i = k;
        label160:
        if (i >= j) {
          break label245;
        }
        localObject = arrayOfe[i];
        if (!((e)localObject).epd) {
          break label238;
        }
      }
      for (;;)
      {
        if (localObject != null) {
          break label251;
        }
        Log.w("Luggage.LuggageMiniProgramProcessManager", "getStartStrategyAndTask(" + str + "): stash task lost, fallback");
        paramPARAMS = a((e)kotlin.a.k.X(arrayOfe), paramPARAMS);
        break;
        j = 0;
        break label146;
        label238:
        i += 1;
        break label160;
        label245:
        localObject = null;
      }
      label251:
      paramPARAMS = a((e)localObject, paramPARAMS);
      continue;
      label262:
      if ((!paramBoolean) && (i == 0)) {}
      for (j = 1;; j = 0)
      {
        if (1 != j) {
          break label299;
        }
        paramPARAMS = (r)((j)localObject).getValue();
        break;
      }
      label299:
      if ((!paramBoolean) && (i != 0))
      {
        i = 1;
        if (1 != i) {}
      }
      else
      {
        try
        {
          paramPARAMS = a(arrayOfe);
          continue;
          i = 0;
        }
        catch (i paramPARAMS)
        {
          for (;;)
          {
            Log.e("Luggage.LuggageMiniProgramProcessManager", "getStartStrategyAndTask(" + str + "): commit failed. fallback to create new strategy");
            paramPARAMS = (r)((j)localObject).getValue();
          }
        }
      }
    }
    throw new IllegalStateException("never!");
  }
  
  private final r<h, PROCESS> a(e[] paramArrayOfe)
  {
    int j = paramArrayOfe.length;
    int i = 0;
    e locale1;
    label23:
    label33:
    e locale2;
    if (i < j)
    {
      locale1 = paramArrayOfe[i];
      if (locale1.epd)
      {
        if (locale1 == null) {
          break label107;
        }
        j = paramArrayOfe.length;
        i = 0;
        if (i >= j) {
          break label102;
        }
        locale2 = paramArrayOfe[i];
        if (!locale2.epd) {
          break label95;
        }
      }
    }
    label95:
    label102:
    for (paramArrayOfe = locale2;; paramArrayOfe = null)
    {
      s.checkNotNull(paramArrayOfe);
      paramArrayOfe = b(paramArrayOfe);
      locale1.epd = false;
      return new r(h.euB, paramArrayOfe);
      i += 1;
      break;
      locale1 = null;
      break label23;
      i += 1;
      break label33;
    }
    label107:
    return new r(h.euB, b((e)kotlin.a.k.X(paramArrayOfe)));
  }
  
  public final e[] B(String paramString, int paramInt)
  {
    s.u(paramString, "appId");
    ArrayList localArrayList = new ArrayList();
    a(paramString, paramInt, (kotlin.g.a.b)new d.d(localArrayList));
    paramString = ((Collection)localArrayList).toArray(new e[0]);
    if (paramString == null) {
      throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
    }
    return (e[])paramString;
  }
  
  public final boolean C(String paramString, int paramInt)
  {
    s.u(paramString, "appId");
    paramString = E(paramString, paramInt);
    if (paramString == null) {
      return false;
    }
    return b(paramString).etW.get();
  }
  
  public final e D(String paramString, int paramInt)
  {
    s.u(paramString, "appId");
    paramString = E(paramString, paramInt);
    if (paramString == null) {}
    while (!b(paramString).etW.get()) {
      return null;
    }
    return paramString;
  }
  
  public final e E(String paramString, int paramInt)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public final void F(String paramString, int paramInt)
  {
    s.u(paramString, "appId");
    d(paramString, paramInt, false);
  }
  
  public final h a(Context paramContext, PARAMS paramPARAMS)
  {
    int i = 268435456;
    s.u(paramContext, "context");
    s.u(paramPARAMS, "params");
    String str = paramPARAMS.appId;
    boolean bool = a(paramPARAMS);
    Object localObject = a(paramPARAMS, bool);
    h localh = (h)((r)localObject).bsC;
    c localc = (c)((r)localObject).bsD;
    e locale = localc.a(paramPARAMS.appId, paramPARAMS.euz, "", bool);
    Intent localIntent;
    if (bool)
    {
      localObject = localc.asb();
      localIntent = new Intent(paramContext, (Class)localObject);
      if ((paramContext instanceof Activity)) {
        break label243;
      }
    }
    for (;;)
    {
      localIntent.addFlags(i);
      localIntent.putExtra("key_index", asg().indexOf(localc));
      Log.i("Luggage.LuggageMiniProgramProcessManager", "startApp: appId:[%s] strategy:[%s] index:[%d] process:[%s],isPersistent:[%b],versionType:[%d],uiClass:[%s]", new Object[] { str, localh.name(), Integer.valueOf(b(localc)), localc.getProcessName(), Boolean.valueOf(bool), Integer.valueOf(paramPARAMS.euz), ((Class)localObject).getName() });
      a(paramContext, localIntent, paramPARAMS, localh, locale);
      fy(str);
      return localh;
      localObject = localc.asa();
      break;
      label243:
      if (bool) {
        i = 0;
      }
    }
  }
  
  protected r<h, PROCESS> a(e parame, PARAMS paramPARAMS)
  {
    s.u(parame, "record");
    s.u(paramPARAMS, "params");
    paramPARAMS = b(parame);
    h localh = h.euB;
    parame.epd = true;
    return new r(localh, paramPARAMS);
  }
  
  public void a(Context paramContext, Intent paramIntent, PARAMS paramPARAMS, h paramh, e parame)
  {
    s.u(paramContext, "context");
    s.u(paramIntent, "intent");
    s.u(paramPARAMS, "params");
    s.u(paramh, "strategy");
    s.u(parame, "appRecord");
    paramIntent = new com.tencent.mm.hellhoundlib.b.a().cG(paramIntent);
    com.tencent.mm.hellhoundlib.a.a.b(paramContext, paramIntent.aYi(), "com/tencent/luggage/sdk/processes/LuggageMiniProgramProcessManager", "onStartWxaApp", "(Landroid/content/Context;Landroid/content/Intent;Lcom/tencent/luggage/sdk/processes/LuggageStartParams;Lcom/tencent/luggage/sdk/processes/LuggageStartStrategy;Lcom/tencent/luggage/sdk/processes/LuggageMiniProgramRecord;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramContext.startActivity((Intent)paramIntent.sb(0));
    com.tencent.mm.hellhoundlib.a.a.c(paramContext, "com/tencent/luggage/sdk/processes/LuggageMiniProgramProcessManager", "onStartWxaApp", "(Landroid/content/Context;Landroid/content/Intent;Lcom/tencent/luggage/sdk/processes/LuggageStartParams;Lcom/tencent/luggage/sdk/processes/LuggageStartStrategy;Lcom/tencent/luggage/sdk/processes/LuggageMiniProgramRecord;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
  }
  
  public final void a(String paramString, int paramInt, kotlin.g.a.b<? super e, ah> paramb)
  {
    s.u(paramString, "appId");
    s.u(paramb, "command");
    Object localObject2 = (Iterable)asg();
    Object localObject1 = (Collection)new ArrayList();
    localObject2 = ((Iterable)localObject2).iterator();
    Object localObject3;
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = ((c)((Iterator)localObject2).next()).fv(paramString);
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
      if (((e)localObject3).epd) {
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
      if (!((e)localObject3).epd) {}
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
      paramString = am.aixg;
      paramString = String.format("records size[%d] persistent size[%d] !persistent size[%d]", Arrays.copyOf(new Object[] { Integer.valueOf(((List)localObject2).size()), Integer.valueOf(j), Integer.valueOf(i) }, 3));
      s.s(paramString, "java.lang.String.format(format, *args)");
      throw new IllegalStateException(paramString);
    }
    localObject1 = ((Iterable)localObject2).iterator();
    if (((Iterator)localObject1).hasNext())
    {
      paramString = ((Iterator)localObject1).next();
      if (!((e)paramString).epd)
      {
        i = 1;
        label445:
        if (i == 0) {
          break label541;
        }
        label450:
        localObject1 = (e)paramString;
        if (localObject1 != null) {
          break label548;
        }
        paramString = null;
        label463:
        if (paramString == null)
        {
          localObject1 = ((Iterable)localObject2).iterator();
          do
          {
            if (!((Iterator)localObject1).hasNext()) {
              break;
            }
            paramString = ((Iterator)localObject1).next();
          } while (!((e)paramString).epd);
        }
      }
    }
    for (;;)
    {
      paramString = (e)paramString;
      if ((paramString != null) && ((paramInt < 0) || (paramString.eul == paramInt))) {
        paramb.invoke(paramString);
      }
      return;
      i = 0;
      break label445;
      label541:
      break;
      paramString = null;
      break label450;
      label548:
      if (paramInt >= 0)
      {
        paramString = (String)localObject1;
        if (((e)localObject1).eul != paramInt) {
          break label463;
        }
      }
      paramb.invoke(localObject1);
      paramString = (String)localObject1;
      break label463;
      paramString = null;
    }
  }
  
  public final void a(String paramString, m<? super PROCESS, ? super Integer, ah> paramm)
  {
    s.u(paramString, "appId");
    s.u(paramm, "ret");
    paramString = a(paramString, LuggageServiceType.euv);
    paramm.invoke(paramString, Integer.valueOf(asg().indexOf(paramString)));
  }
  
  public abstract boolean a(PARAMS paramPARAMS);
  
  protected abstract PROCESS[] asf();
  
  public final List<PROCESS> asg()
  {
    return (List)this.eub.getValue();
  }
  
  public void ash()
  {
    Object localObject1 = new ConcurrentHashMap();
    Iterator localIterator = ((Iterable)asg()).iterator();
    Object localObject2;
    String str;
    while (localIterator.hasNext())
    {
      localObject2 = (c)localIterator.next();
      str = ((c)localObject2).getProcessName();
      if (str != null) {
        if (((c)localObject2).arY())
        {
          ((ConcurrentHashMap)localObject1).putIfAbsent(str, Boolean.TRUE);
        }
        else
        {
          localObject2 = (Map)localObject1;
          Boolean localBoolean = Boolean.FALSE;
          s.s(localBoolean, "FALSE");
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
        localObject2 = ((Iterable)asg()).iterator();
        do
        {
          if (!((Iterator)localObject2).hasNext()) {
            break;
          }
          localObject1 = ((Iterator)localObject2).next();
        } while (!s.p(((c)localObject1).getProcessName(), str));
        for (;;)
        {
          localObject1 = (c)localObject1;
          if (localObject1 == null) {
            break;
          }
          ((c)localObject1).ase();
          break;
          localObject1 = null;
        }
      }
    }
    Log.i("Luggage.LuggageMiniProgramProcessManager", "killAll SILENT_IF_INACTIVE");
  }
  
  public final void asi()
  {
    Iterator localIterator1 = ((Iterable)asg()).iterator();
    while (localIterator1.hasNext())
    {
      Iterator localIterator2 = ((Iterable)((c)localIterator1.next()).asd()).iterator();
      while (localIterator2.hasNext())
      {
        e locale = (e)localIterator2.next();
        c(locale);
        e(locale);
      }
    }
  }
  
  public final List<e> asj()
  {
    Object localObject = (Iterable)asg();
    Collection localCollection = (Collection)new ArrayList();
    localObject = ((Iterable)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      p.a(localCollection, (Iterable)((c)((Iterator)localObject).next()).asd());
    }
    return (List)localCollection;
  }
  
  public final int b(PROCESS paramPROCESS)
  {
    s.u(paramPROCESS, "process");
    return asg().indexOf(paramPROCESS);
  }
  
  public final PROCESS b(e parame)
  {
    s.u(parame, "record");
    Iterator localIterator = ((Iterable)asg()).iterator();
    Object localObject;
    do
    {
      if (!localIterator.hasNext()) {
        break;
      }
      localObject = localIterator.next();
    } while (!((c)localObject).asd().contains(parame));
    for (parame = localObject;; parame = null)
    {
      parame = (c)parame;
      if (parame == null) {
        break;
      }
      return parame;
    }
    throw new i();
  }
  
  public final void b(b paramb)
  {
    s.u(paramb, "killType");
    if (paramb == b.etQ) {
      ash();
    }
    for (;;)
    {
      return;
      Iterator localIterator = ((Iterable)asg()).iterator();
      while (localIterator.hasNext()) {
        ((c)localIterator.next()).a(paramb);
      }
    }
  }
  
  public abstract void c(e parame);
  
  public PROCESS d(LuggageServiceType paramLuggageServiceType)
  {
    s.u(paramLuggageServiceType, "serviceType");
    if (paramLuggageServiceType != LuggageServiceType.eux) {}
    for (int i = 1; i == 0; i = 0) {
      throw ((Throwable)new IllegalArgumentException("Failed requirement.".toString()));
    }
    Object localObject2 = (Iterable)asg();
    Object localObject1 = (Collection)new ArrayList();
    localObject2 = ((Iterable)localObject2).iterator();
    Object localObject4;
    label135:
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = ((Iterator)localObject2).next();
      localObject4 = (c)localObject3;
      if ((paramLuggageServiceType == ((c)localObject4).etX) && (((c)localObject4).arY())) {}
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
        break label549;
      }
      localObject2 = ((Iterable)localObject3).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject1 = ((Iterator)localObject2).next();
        if (((c)localObject1).etW.get())
        {
          label205:
          localObject2 = (c)localObject1;
          localObject1 = localObject2;
          if (localObject2 == null) {
            localObject1 = (c)p.oK((List)localObject3);
          }
          Log.i("Luggage.LuggageMiniProgramProcessManager", "getAvailableTaskToPreload found empty task[%s], which can be used as [%s]", new Object[] { ((c)localObject1).asa().getSimpleName(), paramLuggageServiceType });
        }
      }
    }
    for (;;)
    {
      if (localObject1 == null)
      {
        localObject3 = (Iterable)asg();
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
          if ((localc.etX == LuggageServiceType.eux) && (localc.c(paramLuggageServiceType))) {}
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
            break label541;
          }
          localObject2 = ((Iterable)localObject3).iterator();
          for (;;)
          {
            if (((Iterator)localObject2).hasNext())
            {
              localObject1 = ((Iterator)localObject2).next();
              if (((c)localObject1).etW.get())
              {
                label438:
                localObject1 = (c)localObject1;
                localObject2 = localObject1;
                if (localObject1 != null) {
                  break;
                }
              }
            }
          }
        }
        label541:
        for (localObject2 = (c)p.oK((List)localObject3);; localObject2 = localObject1)
        {
          if (localObject2 == null) {
            localObject1 = "null";
          }
          for (;;)
          {
            Log.i("Luggage.LuggageMiniProgramProcessManager", "tryPreloadNextTaskProcess serviceType = [%s] not reached max limit , got ui task = [%s]", new Object[] { paramLuggageServiceType, localObject1 });
            return localObject2;
            i = 0;
            break;
            localObject1 = null;
            break label438;
            localObject1 = ((c)localObject2).asa();
            if (localObject1 == null)
            {
              localObject1 = "null";
            }
            else
            {
              localObject3 = ((Class)localObject1).getSimpleName();
              localObject1 = localObject3;
              if (localObject3 == null) {
                localObject1 = "null";
              }
            }
          }
        }
      }
      return localObject1;
      label549:
      localObject1 = null;
    }
  }
  
  public abstract void d(e parame);
  
  public final void d(final String paramString, int paramInt, boolean paramBoolean)
  {
    s.u(paramString, "appId");
    a(paramString, paramInt, (kotlin.g.a.b)new f(paramBoolean, this, paramString));
  }
  
  public final void e(e parame)
  {
    s.u(parame, "record");
    b(parame).a(parame);
  }
  
  public final boolean fA(String paramString)
  {
    s.u(paramString, "appId");
    return C(paramString, -1);
  }
  
  public PROCESS fw(String paramString)
  {
    s.u(paramString, "appId");
    return a(paramString, LuggageServiceType.euv);
  }
  
  public final PROCESS fx(String paramString)
  {
    s.u(paramString, "appId");
    Iterator localIterator = ((Iterable)asg()).iterator();
    Object localObject;
    do
    {
      if (!localIterator.hasNext()) {
        break;
      }
      localObject = localIterator.next();
    } while (!((c)localObject).arZ().contains(paramString));
    for (paramString = localObject;; paramString = null) {
      return (c)paramString;
    }
  }
  
  public final void fy(String paramString)
  {
    s.u(paramString, "appId");
    a(paramString, -1, (kotlin.g.a.b)g.euj);
  }
  
  public void fz(String paramString)
  {
    s.u(paramString, "appId");
  }
  
  public final void l(final int paramInt, String paramString)
  {
    s.u(paramString, "appId");
    a(paramString, -1, (kotlin.g.a.b)new c(this, paramInt));
  }
  
  public final PROCESS mt(int paramInt)
  {
    return (c)asg().get(paramInt);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/luggage/sdk/processes/LuggageMiniProgramProcessManager$Companion;", "", "()V", "INSTANCE", "Lcom/tencent/luggage/sdk/processes/LuggageMiniProgramProcessManager;", "Lcom/tencent/luggage/sdk/processes/LuggageMiniProgramProcess;", "Lcom/tencent/luggage/sdk/processes/LuggageStartParams;", "getINSTANCE", "()Lcom/tencent/luggage/sdk/processes/LuggageMiniProgramProcessManager;", "setINSTANCE", "(Lcom/tencent/luggage/sdk/processes/LuggageMiniProgramProcessManager;)V", "KEY_PROCESS_INDEX", "", "TAG", "inject", "", "_instance", "luggage-wechat-full-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    public static void a(d<c<g>, g> paramd)
    {
      AppMethodBeat.i(220439);
      s.u(paramd, "_instance");
      if (!MMApplicationContext.isMainProcess())
      {
        paramd = new IllegalAccessError("ProcessManager can only used by main process");
        AppMethodBeat.o(220439);
        throw paramd;
      }
      if (d.euc == null)
      {
        s.u(paramd, "<set-?>");
        d.euc = paramd;
        com.tencent.threadpool.h.ahAA.bm(d.a..ExternalSyntheticLambda0.INSTANCE);
      }
      AppMethodBeat.o(220439);
    }
    
    public static d<c<g>, g> ask()
    {
      AppMethodBeat.i(220431);
      d locald = d.euc;
      if (locald != null)
      {
        AppMethodBeat.o(220431);
        return locald;
      }
      s.bIx("INSTANCE");
      AppMethodBeat.o(220431);
      return null;
    }
    
    private static final void asl()
    {
      AppMethodBeat.i(220444);
      Object localObject = d.eua;
      localObject = ((Iterable)ask().asg()).iterator();
      while (((Iterator)localObject).hasNext()) {
        ((c)((Iterator)localObject).next()).asc();
      }
      AppMethodBeat.o(220444);
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Ljava/util/concurrent/CopyOnWriteArrayList;", "PROCESS", "Lcom/tencent/luggage/sdk/processes/LuggageMiniProgramProcess;", "PARAMS", "Lcom/tencent/luggage/sdk/processes/LuggageStartParams;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements kotlin.g.a.a<CopyOnWriteArrayList<PROCESS>>
  {
    b(d<PROCESS, PARAMS> paramd)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "PROCESS", "Lcom/tencent/luggage/sdk/processes/LuggageMiniProgramProcess;", "PARAMS", "Lcom/tencent/luggage/sdk/processes/LuggageStartParams;", "record", "Lcom/tencent/luggage/sdk/processes/LuggageMiniProgramRecord;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements kotlin.g.a.b<e, ah>
  {
    c(d<PROCESS, PARAMS> paramd, int paramInt)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lkotlin/Pair;", "Lcom/tencent/luggage/sdk/processes/LuggageStartStrategy;", "PROCESS", "Lcom/tencent/luggage/sdk/processes/LuggageMiniProgramProcess;", "PARAMS", "Lcom/tencent/luggage/sdk/processes/LuggageStartParams;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class e
    extends u
    implements kotlin.g.a.a<r<? extends h, ? extends PROCESS>>
  {
    e(d<PROCESS, PARAMS> paramd, String paramString, LuggageServiceType paramLuggageServiceType)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "PROCESS", "Lcom/tencent/luggage/sdk/processes/LuggageMiniProgramProcess;", "PARAMS", "Lcom/tencent/luggage/sdk/processes/LuggageStartParams;", "record", "Lcom/tencent/luggage/sdk/processes/LuggageMiniProgramRecord;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class f
    extends u
    implements kotlin.g.a.b<e, ah>
  {
    f(boolean paramBoolean, d<PROCESS, PARAMS> paramd, String paramString)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "PROCESS", "Lcom/tencent/luggage/sdk/processes/LuggageMiniProgramProcess;", "PARAMS", "Lcom/tencent/luggage/sdk/processes/LuggageStartParams;", "record", "Lcom/tencent/luggage/sdk/processes/LuggageMiniProgramRecord;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class g
    extends u
    implements kotlin.g.a.b<e, ah>
  {
    public static final g euj;
    
    static
    {
      AppMethodBeat.i(220427);
      euj = new g();
      AppMethodBeat.o(220427);
    }
    
    g()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.luggage.sdk.processes.d
 * JD-Core Version:    0.7.0.1
 */