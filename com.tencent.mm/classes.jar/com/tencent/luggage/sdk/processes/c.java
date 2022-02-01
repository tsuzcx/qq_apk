package com.tencent.luggage.sdk.processes;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.os.Process;
import com.tencent.mm.ipcinvoker.o;
import com.tencent.mm.ipcinvoker.type.IPCVoid;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.ah;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/luggage/sdk/processes/LuggageMiniProgramProcess;", "PARAMS", "Lcom/tencent/luggage/sdk/processes/LuggageStartParams;", "", "()V", "allAppId", "", "", "getAllAppId", "()Ljava/util/Collection;", "appList", "", "Lcom/tencent/luggage/sdk/processes/LuggageMiniProgramRecord;", "getAppList", "()Ljava/util/Set;", "isNoAppAttached", "", "()Z", "isProcessAlive", "Ljava/util/concurrent/atomic/AtomicBoolean;", "pluginUIClass", "Ljava/lang/Class;", "Landroid/app/Activity;", "getPluginUIClass", "()Ljava/lang/Class;", "processName", "getProcessName", "()Ljava/lang/String;", "remoteProcDiedListener", "Lcom/tencent/mm/ipcinvoker/IRemoteProcDied;", "value", "Lcom/tencent/luggage/sdk/processes/LuggageServiceType;", "supportType", "getSupportType", "()Lcom/tencent/luggage/sdk/processes/LuggageServiceType;", "setSupportType", "(Lcom/tencent/luggage/sdk/processes/LuggageServiceType;)V", "uiClass", "getUiClass", "usedAs", "getUsedAs", "setUsedAs", "attachApp", "appId", "versionType", "", "instanceId", "isPersistentApp", "createRecord", "detachApp", "", "record", "findAppRecord", "getAllRecord", "initProcessIsAlive", "killAllRuntime", "type", "Lcom/tencent/luggage/sdk/processes/KillType;", "killProcess", "registerApp", "reset", "sendMessageToLuggageProcess", "message", "Lkotlin/Function0;", "onReceived", "Lcom/tencent/luggage/sdk/processes/client/LuggageClientProcessMessage;", "Lcom/tencent/luggage/sdk/runtime/AppBrandRuntimeLU;", "sendMessageToLuggageProcessSync", "setProcessAlive", "support", "toString", "Companion", "luggage-wechat-full-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract class c<PARAMS extends g>
{
  public static final c.a etU = new c.a((byte)0);
  public final Set<e> etV = (Set)new HashSet();
  public AtomicBoolean etW = new AtomicBoolean(false);
  public LuggageServiceType etX = LuggageServiceType.eux;
  public LuggageServiceType etY;
  public final o etZ = new c..ExternalSyntheticLambda1(this);
  private final String processName;
  
  private static final void a(c paramc)
  {
    s.u(paramc, "this$0");
    boolean bool = paramc.etW.get();
    if (bool) {
      paramc.etV.clear();
    }
    paramc.etW.set(false);
    com.tencent.mm.sdk.platformtools.Log.i("Luggage.LuggageMiniProgramProcess", "[%s] died, isAliveBefore[%b]", new Object[] { paramc.getProcessName(), Boolean.valueOf(bool) });
  }
  
  private static final void a(kotlin.g.a.a parama, IPCVoid paramIPCVoid)
  {
    if (parama != null) {
      parama.invoke();
    }
  }
  
  public e a(String paramString1, int paramInt, String paramString2, boolean paramBoolean)
  {
    s.u(paramString1, "appId");
    s.u(paramString2, "instanceId");
    return a(paramString1, paramBoolean, paramInt, paramString2);
  }
  
  public final e a(String arg1, boolean paramBoolean, int paramInt, String paramString2)
  {
    s.u(???, "appId");
    s.u(paramString2, "instanceId");
    e locale = fv(???);
    if ((locale != null) && (locale.epd == paramBoolean) && (locale.eul == paramInt)) {
      com.tencent.mm.sdk.platformtools.Log.i("Luggage.LuggageMiniProgramProcess", "registerApp: use existed");
    }
    for (;;)
    {
      com.tencent.mm.sdk.platformtools.Log.i("Luggage.LuggageMiniProgramProcess", "registerApp: appId[%s]isPersistent[%s]record_hash[%s]instanceId[%s]", new Object[] { ???, Boolean.valueOf(paramBoolean), Integer.valueOf(locale.hashCode()), paramString2 });
      locale.fB(paramString2);
      synchronized (this.etV)
      {
        if (!this.etV.add(locale)) {
          com.tencent.mm.sdk.platformtools.Log.w("Luggage.LuggageMiniProgramProcess", "registerApp: " + locale + " already added");
        }
        paramString2 = ah.aiuX;
        return locale;
        com.tencent.mm.sdk.platformtools.Log.i("Luggage.LuggageMiniProgramProcess", "registerApp: createRecord stack:[%s]", new Object[] { android.util.Log.getStackTraceString(new Throwable()) });
        locale = c(???, paramInt, paramBoolean);
      }
    }
  }
  
  public final void a(LuggageServiceType paramLuggageServiceType)
  {
    s.u(paramLuggageServiceType, "<set-?>");
    this.etX = paramLuggageServiceType;
  }
  
  public abstract void a(b paramb);
  
  public final void a(e parame)
  {
    s.u(parame, "record");
    if (parame.epd) {
      com.tencent.mm.sdk.platformtools.Log.i("Luggage.LuggageMiniProgramProcess", "detachApp: [%s][%d] is persistent, do not detach", new Object[] { parame.appId, Integer.valueOf(parame.eul) });
    }
    for (;;)
    {
      return;
      synchronized (this.etV)
      {
        boolean bool = this.etV.remove(parame);
        if (!bool) {
          com.tencent.mm.sdk.platformtools.Log.w("Luggage.LuggageMiniProgramProcess", "detachApp: detach[%s] fail", new Object[] { parame });
        }
        if (!arY()) {
          continue;
        }
        this.etX = LuggageServiceType.eux;
        return;
      }
    }
  }
  
  public final boolean arY()
  {
    return this.etV.isEmpty();
  }
  
  public final Collection<String> arZ()
  {
    synchronized (this.etV)
    {
      Object localObject2 = (Iterable)this.etV;
      Collection localCollection = (Collection)new ArrayList(p.a((Iterable)localObject2, 10));
      localObject2 = ((Iterable)localObject2).iterator();
      if (((Iterator)localObject2).hasNext()) {
        localCollection.add(((e)((Iterator)localObject2).next()).appId);
      }
    }
    ArrayList localArrayList = new ArrayList((Collection)localObject1);
    return (Collection)localArrayList;
  }
  
  public abstract Class<? extends Activity> asa();
  
  public abstract Class<? extends Activity> asb();
  
  public final void asc()
  {
    String str = getProcessName();
    if (str != null)
    {
      AtomicBoolean localAtomicBoolean = this.etW;
      Context localContext = MMApplicationContext.getContext();
      s.s(localContext, "getContext()");
      localAtomicBoolean.set(c.a.isProcessRunning(localContext, str));
    }
  }
  
  public final Collection<e> asd()
  {
    synchronized (this.etV)
    {
      ArrayList localArrayList = new ArrayList((Collection)this.etV);
      return (Collection)localArrayList;
    }
  }
  
  public void ase()
  {
    Object localObject1 = MMApplicationContext.getContext().getSystemService("activity");
    if (localObject1 == null) {
      throw new NullPointerException("null cannot be cast to non-null type android.app.ActivityManager");
    }
    localObject1 = ((ActivityManager)localObject1).getRunningAppProcesses().iterator();
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = (ActivityManager.RunningAppProcessInfo)((Iterator)localObject1).next();
      if ((((ActivityManager.RunningAppProcessInfo)localObject2).processName != null) && (s.p(((ActivityManager.RunningAppProcessInfo)localObject2).processName, getProcessName())))
      {
        localObject2 = com.tencent.mm.hellhoundlib.b.c.a(((ActivityManager.RunningAppProcessInfo)localObject2).pid, new com.tencent.mm.hellhoundlib.b.a());
        Object localObject3 = new Object();
        com.tencent.mm.hellhoundlib.a.a.b(localObject3, ((com.tencent.mm.hellhoundlib.b.a)localObject2).aYi(), "com/tencent/luggage/sdk/processes/LuggageMiniProgramProcess", "killProcess", "()V", "android/os/Process_EXEC_", "killProcess", "(I)V");
        Process.killProcess(((Integer)((com.tencent.mm.hellhoundlib.b.a)localObject2).sb(0)).intValue());
        com.tencent.mm.hellhoundlib.a.a.c(localObject3, "com/tencent/luggage/sdk/processes/LuggageMiniProgramProcess", "killProcess", "()V", "android/os/Process_EXEC_", "killProcess", "(I)V");
      }
    }
  }
  
  public final void b(LuggageServiceType paramLuggageServiceType)
  {
    if (paramLuggageServiceType != LuggageServiceType.eux) {}
    for (int i = 1; i == 0; i = 0) {
      throw ((Throwable)new IllegalStateException("Check failed.".toString()));
    }
    if (this.etY != null) {
      throw new IllegalStateException("const field");
    }
    this.etY = paramLuggageServiceType;
  }
  
  public e c(String paramString, int paramInt, boolean paramBoolean)
  {
    s.u(paramString, "appId");
    return new e(paramString, paramInt, f.euq, paramBoolean);
  }
  
  public final boolean c(LuggageServiceType paramLuggageServiceType)
  {
    s.u(paramLuggageServiceType, "type");
    if (this.etY == null) {}
    while (this.etY == paramLuggageServiceType) {
      return true;
    }
    return false;
  }
  
  public final e fv(String paramString)
  {
    s.u(paramString, "appId");
    synchronized (this.etV)
    {
      Iterator localIterator = ((Iterable)this.etV).iterator();
      while (localIterator.hasNext())
      {
        Object localObject = localIterator.next();
        if (s.p(((e)localObject).appId, paramString))
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
      return c.a.ad(asa());
    }
    return this.processName;
  }
  
  public String toString()
  {
    return "LuggageMiniProgramProcess(appList=" + this.etV + ", isProcessAlive=" + this.etW + ", processName='" + getProcessName() + "', usedAs=" + this.etX + ", isNoAppAttached=" + arY() + ", allAppId=" + arZ() + ", supportType=" + this.etY + ", uiClass=" + asa() + ", pluginUIClass=" + asb() + ')';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.luggage.sdk.processes.c
 * JD-Core Version:    0.7.0.1
 */