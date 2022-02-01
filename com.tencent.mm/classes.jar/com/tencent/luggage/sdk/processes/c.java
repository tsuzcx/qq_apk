package com.tencent.luggage.sdk.processes;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.os.Process;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.o;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/luggage/sdk/processes/LuggageMiniProgramProcess;", "PARAMS", "Lcom/tencent/luggage/sdk/processes/LuggageStartParams;", "", "()V", "allAppId", "", "", "getAllAppId", "()Ljava/util/Collection;", "appList", "", "Lcom/tencent/luggage/sdk/processes/LuggageMiniProgramRecord;", "getAppList", "()Ljava/util/Set;", "isNoAppAttached", "", "()Z", "isProcessAlive", "Ljava/util/concurrent/atomic/AtomicBoolean;", "pluginUIClass", "Ljava/lang/Class;", "Landroid/app/Activity;", "getPluginUIClass", "()Ljava/lang/Class;", "processName", "getProcessName", "()Ljava/lang/String;", "remoteProcDiedListener", "Lcom/tencent/mm/ipcinvoker/IRemoteProcDied;", "value", "Lcom/tencent/luggage/sdk/processes/LuggageServiceType;", "supportType", "getSupportType", "()Lcom/tencent/luggage/sdk/processes/LuggageServiceType;", "setSupportType", "(Lcom/tencent/luggage/sdk/processes/LuggageServiceType;)V", "uiClass", "getUiClass", "usedAs", "getUsedAs", "setUsedAs", "attachApp", "appId", "versionType", "", "instanceId", "isPersistentApp", "createRecord", "detachApp", "", "record", "findAppRecord", "getAllRecord", "initProcessIsAlive", "killAllRuntime", "type", "Lcom/tencent/luggage/sdk/processes/KillType;", "killProcess", "registerApp", "sendMessageToLuggageProcess", "message", "Lkotlin/Function0;", "onReceived", "Lcom/tencent/luggage/sdk/processes/client/LuggageClientProcessMessage;", "Lcom/tencent/luggage/sdk/runtime/AppBrandRuntimeLU;", "setProcessAlive", "support", "toString", "Companion", "luggage-wechat-full-sdk_release"})
public abstract class c<PARAMS extends g>
{
  public static final c.a cBt = new c.a((byte)0);
  final Set<e> cBo = (Set)new HashSet();
  public AtomicBoolean cBp = new AtomicBoolean(false);
  public LuggageServiceType cBq = LuggageServiceType.cBR;
  private LuggageServiceType cBr;
  public final o cBs = (o)new b(this);
  private final String processName;
  
  public final boolean RK()
  {
    return this.cBo.isEmpty();
  }
  
  public final Collection<String> RL()
  {
    synchronized (this.cBo)
    {
      Object localObject2 = (Iterable)this.cBo;
      Collection localCollection = (Collection)new ArrayList(j.a((Iterable)localObject2, 10));
      localObject2 = ((Iterable)localObject2).iterator();
      if (((Iterator)localObject2).hasNext()) {
        localCollection.add(((e)((Iterator)localObject2).next()).appId);
      }
    }
    ArrayList localArrayList = new ArrayList((Collection)localObject1);
    return (Collection)localArrayList;
  }
  
  public abstract Class<? extends Activity> RM();
  
  public abstract Class<? extends Activity> RN();
  
  public final Collection<e> RO()
  {
    synchronized (this.cBo)
    {
      ArrayList localArrayList = new ArrayList((Collection)this.cBo);
      return (Collection)localArrayList;
    }
  }
  
  public void RP()
  {
    Object localObject1 = MMApplicationContext.getContext().getSystemService("activity");
    if (localObject1 == null) {
      throw new t("null cannot be cast to non-null type android.app.ActivityManager");
    }
    localObject1 = ((ActivityManager)localObject1).getRunningAppProcesses().iterator();
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = (ActivityManager.RunningAppProcessInfo)((Iterator)localObject1).next();
      if ((((ActivityManager.RunningAppProcessInfo)localObject2).processName != null) && (p.h(((ActivityManager.RunningAppProcessInfo)localObject2).processName, getProcessName())))
      {
        localObject2 = com.tencent.mm.hellhoundlib.b.c.a(((ActivityManager.RunningAppProcessInfo)localObject2).pid, new com.tencent.mm.hellhoundlib.b.a());
        Object localObject3 = new Object();
        com.tencent.mm.hellhoundlib.a.a.b(localObject3, ((com.tencent.mm.hellhoundlib.b.a)localObject2).aFh(), "com/tencent/luggage/sdk/processes/LuggageMiniProgramProcess", "killProcess", "()V", "android/os/Process_EXEC_", "killProcess", "(I)V");
        Process.killProcess(((Integer)((com.tencent.mm.hellhoundlib.b.a)localObject2).sf(0)).intValue());
        com.tencent.mm.hellhoundlib.a.a.c(localObject3, "com/tencent/luggage/sdk/processes/LuggageMiniProgramProcess", "killProcess", "()V", "android/os/Process_EXEC_", "killProcess", "(I)V");
      }
    }
  }
  
  public e a(String paramString1, int paramInt, String paramString2, boolean paramBoolean)
  {
    p.k(paramString1, "appId");
    p.k(paramString2, "instanceId");
    return a(paramString1, paramBoolean, paramInt, paramString2);
  }
  
  public final e a(String arg1, boolean paramBoolean, int paramInt, String paramString2)
  {
    p.k(???, "appId");
    p.k(paramString2, "instanceId");
    e locale = ec(???);
    if ((locale != null) && (locale.cxb == paramBoolean) && (locale.cBI == paramInt)) {
      com.tencent.mm.sdk.platformtools.Log.i("Luggage.LuggageMiniProgramProcess", "registerApp: use existed");
    }
    for (;;)
    {
      com.tencent.mm.sdk.platformtools.Log.i("Luggage.LuggageMiniProgramProcess", "registerApp: appId[%s]isPersistent[%s]record_hash[%s]instanceId[%s]", new Object[] { ???, Boolean.valueOf(paramBoolean), Integer.valueOf(locale.hashCode()), paramString2 });
      locale.ei(paramString2);
      synchronized (this.cBo)
      {
        if (!this.cBo.add(locale)) {
          com.tencent.mm.sdk.platformtools.Log.w("Luggage.LuggageMiniProgramProcess", "registerApp: " + locale + " already added");
        }
        paramString2 = x.aazN;
        return locale;
        com.tencent.mm.sdk.platformtools.Log.i("Luggage.LuggageMiniProgramProcess", "registerApp: createRecord stack:[%s]", new Object[] { android.util.Log.getStackTraceString(new Throwable()) });
        locale = c(???, paramInt, paramBoolean);
      }
    }
  }
  
  public final void a(LuggageServiceType paramLuggageServiceType)
  {
    p.k(paramLuggageServiceType, "<set-?>");
    this.cBq = paramLuggageServiceType;
  }
  
  public abstract void a(b paramb);
  
  public final void a(e parame)
  {
    p.k(parame, "record");
    if (parame.cxb) {
      com.tencent.mm.sdk.platformtools.Log.i("Luggage.LuggageMiniProgramProcess", "detachApp: [%s][%d] is persistent, do not detach", new Object[] { parame.appId, Integer.valueOf(parame.cBI) });
    }
    for (;;)
    {
      return;
      synchronized (this.cBo)
      {
        boolean bool = this.cBo.remove(parame);
        if (!bool) {
          com.tencent.mm.sdk.platformtools.Log.w("Luggage.LuggageMiniProgramProcess", "detachApp: detach[%s] fail", new Object[] { parame });
        }
        if (!RK()) {
          continue;
        }
        this.cBq = LuggageServiceType.cBR;
        return;
      }
    }
  }
  
  public final void b(LuggageServiceType paramLuggageServiceType)
  {
    if (paramLuggageServiceType != LuggageServiceType.cBR) {}
    for (int i = 1; i == 0; i = 0) {
      throw ((Throwable)new IllegalStateException("Check failed.".toString()));
    }
    if (this.cBr != null) {
      throw ((Throwable)new IllegalStateException("const field"));
    }
    this.cBr = paramLuggageServiceType;
  }
  
  public e c(String paramString, int paramInt, boolean paramBoolean)
  {
    p.k(paramString, "appId");
    return new e(paramString, paramInt, f.cBL, paramBoolean);
  }
  
  public final boolean c(LuggageServiceType paramLuggageServiceType)
  {
    p.k(paramLuggageServiceType, "type");
    if (this.cBr == null) {}
    while (this.cBr == paramLuggageServiceType) {
      return true;
    }
    return false;
  }
  
  public final e ec(String paramString)
  {
    p.k(paramString, "appId");
    synchronized (this.cBo)
    {
      Iterator localIterator = ((Iterable)this.cBo).iterator();
      while (localIterator.hasNext())
      {
        Object localObject = localIterator.next();
        if (p.h(((e)localObject).appId, paramString))
        {
          paramString = localObject;
          paramString = (e)paramString;
          return paramString;
        }
      }
      paramString = null;
    }
  }
  
  public final String getProcessName()
  {
    if (this.processName == null) {
      return c.a.U(RM());
    }
    return this.processName;
  }
  
  public String toString()
  {
    return "LuggageMiniProgramProcess(appList=" + this.cBo + ", isProcessAlive=" + this.cBp + ", processName='" + getProcessName() + "', usedAs=" + this.cBq + ", isNoAppAttached=" + RK() + ", allAppId=" + RL() + ", supportType=" + this.cBr + ", uiClass=" + RM() + ", pluginUIClass=" + RN() + ')';
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "PARAMS", "Lcom/tencent/luggage/sdk/processes/LuggageStartParams;", "onDied"})
  static final class b
    implements o
  {
    b(c paramc) {}
    
    public final void RQ()
    {
      AppMethodBeat.i(243525);
      boolean bool = this.cBu.cBp.get();
      if (bool) {
        this.cBu.cBo.clear();
      }
      c.a(this.cBu).set(false);
      com.tencent.mm.sdk.platformtools.Log.i("Luggage.LuggageMiniProgramProcess", "[%s] died, isAliveBefore[%b]", new Object[] { this.cBu.getProcessName(), Boolean.valueOf(bool) });
      AppMethodBeat.o(243525);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.luggage.sdk.processes.c
 * JD-Core Version:    0.7.0.1
 */