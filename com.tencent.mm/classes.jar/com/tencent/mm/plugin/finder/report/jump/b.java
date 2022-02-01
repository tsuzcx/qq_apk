package com.tencent.mm.plugin.finder.report.jump;

import android.app.Activity;
import android.app.Application;
import android.app.Application.ActivityLifecycleCallbacks;
import android.content.Context;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.MMFragmentActivity;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.ah;
import kotlin.d.b.a.k;
import kotlin.d.d;
import kotlin.d.f;
import kotlin.d.g;
import kotlin.g.a.m;
import kotlin.g.b.s;
import kotlinx.coroutines.ac;
import kotlinx.coroutines.aq;
import kotlinx.coroutines.ar;
import kotlinx.coroutines.as;
import kotlinx.coroutines.bg;
import kotlinx.coroutines.cx;
import kotlinx.coroutines.l;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/report/jump/FinderJumpDataManager;", "", "()V", "clearListenerMap", "Ljava/util/HashMap;", "", "Lcom/tencent/mm/plugin/finder/report/jump/OnClearListener;", "Lkotlin/collections/HashMap;", "finderTaskId", "jumpDataMap", "Ljava/util/concurrent/ConcurrentHashMap;", "Lcom/tencent/mm/plugin/finder/report/jump/FinderJumpData;", "lifecycleScope", "Lkotlinx/coroutines/CoroutineScope;", "getLifecycleScope", "()Lkotlinx/coroutines/CoroutineScope;", "taskIdMap", "checkAndGetTaskId", "", "activity", "Lcom/tencent/mm/ui/MMFragmentActivity;", "clearIds", "Landroid/app/Activity;", "clearTaskId", "activityId", "getOrCreateJumpData", "key", "getTaskIdAsync", "handleInit", "intent", "Landroid/content/Intent;", "fromCommentScene", "toCommentScene", "entranceType", "onClearListener", "initJumpData", "isFinderHomeUI", "", "launch", "Lkotlinx/coroutines/Job;", "context", "Lkotlin/coroutines/CoroutineContext;", "start", "Lkotlinx/coroutines/CoroutineStart;", "block", "Lkotlin/Function2;", "Lkotlin/coroutines/Continuation;", "Lkotlin/ExtensionFunctionType;", "(Lkotlin/coroutines/CoroutineContext;Lkotlinx/coroutines/CoroutineStart;Lkotlin/jvm/functions/Function2;)Lkotlinx/coroutines/Job;", "register", "Companion", "SingletonHolder", "plugin-finder-base_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
{
  public static final a FuP;
  private static final b FuU;
  public final ConcurrentHashMap<Integer, Integer> FuQ;
  public final ConcurrentHashMap<Integer, a> FuR;
  public final HashMap<Integer, c> FuS;
  public int FuT;
  final aq lifecycleScope;
  
  static
  {
    AppMethodBeat.i(331648);
    FuP = new a((byte)0);
    b localb = b.FuW;
    FuU = b.eOb();
    AppMethodBeat.o(331648);
  }
  
  private b()
  {
    AppMethodBeat.i(331590);
    this.lifecycleScope = ar.d(cx.g(null).plus((f)bg.kCi()));
    this.FuQ = new ConcurrentHashMap();
    this.FuR = new ConcurrentHashMap();
    this.FuS = new HashMap();
    Object localObject = MMApplicationContext.getContext().getApplicationContext();
    if (localObject == null)
    {
      localObject = new NullPointerException("null cannot be cast to non-null type android.app.Application");
      AppMethodBeat.o(331590);
      throw ((Throwable)localObject);
    }
    ((Application)localObject).registerActivityLifecycleCallbacks((Application.ActivityLifecycleCallbacks)new Application.ActivityLifecycleCallbacks()
    {
      public final void onActivityCreated(Activity paramAnonymousActivity, Bundle paramAnonymousBundle)
      {
        AppMethodBeat.i(331579);
        s.u(paramAnonymousActivity, "activity");
        if ((paramAnonymousActivity instanceof MMFragmentActivity))
        {
          b localb = this.FuV;
          Object localObject = (MMFragmentActivity)paramAnonymousActivity;
          s.u(localObject, "activity");
          int i = ((MMFragmentActivity)localObject).hashCode();
          paramAnonymousBundle = (Integer)localb.FuQ.get(Integer.valueOf(i));
          paramAnonymousActivity = paramAnonymousBundle;
          if (paramAnonymousBundle == null) {
            paramAnonymousActivity = Integer.valueOf(0);
          }
          if (((Number)paramAnonymousActivity).intValue() <= 0)
          {
            paramAnonymousActivity = (m)new b.c((MMFragmentActivity)localObject, localb, i, null);
            paramAnonymousBundle = (f)g.aiwf;
            localObject = as.ajvK;
            s.u(paramAnonymousBundle, "context");
            s.u(localObject, "start");
            s.u(paramAnonymousActivity, "block");
            l.b(localb.lifecycleScope, paramAnonymousBundle, (as)localObject, paramAnonymousActivity);
          }
        }
        AppMethodBeat.o(331579);
      }
      
      public final void onActivityDestroyed(Activity paramAnonymousActivity)
      {
        AppMethodBeat.i(331631);
        s.u(paramAnonymousActivity, "activity");
        b localb = this.FuV;
        int i = paramAnonymousActivity.hashCode();
        localb.FuQ.remove(Integer.valueOf(i));
        Log.i("FinderJumpDataManager", "[clearTaskId] activityId=" + i + ", taskIdMap.size=" + localb.FuQ.size());
        AppMethodBeat.o(331631);
      }
      
      public final void onActivityPaused(Activity paramAnonymousActivity)
      {
        AppMethodBeat.i(331606);
        s.u(paramAnonymousActivity, "activity");
        AppMethodBeat.o(331606);
      }
      
      public final void onActivityResumed(Activity paramAnonymousActivity)
      {
        AppMethodBeat.i(331597);
        s.u(paramAnonymousActivity, "activity");
        b localb = this.FuV;
        s.u(paramAnonymousActivity, "activity");
        int i = paramAnonymousActivity.hashCode();
        Object localObject = (Integer)localb.FuQ.get(Integer.valueOf(i));
        if (localObject != null)
        {
          int j = ((Number)localObject).intValue();
          localObject = (a)localb.FuR.get(Integer.valueOf(j));
          if ((localObject != null) && (((a)localObject).FuO == i))
          {
            localb.FuR.remove(Integer.valueOf(j));
            c localc = (c)localb.FuS.get(Integer.valueOf(i));
            if (localc != null) {
              localc.gQ((Context)paramAnonymousActivity);
            }
            localb.FuS.remove(Integer.valueOf(i));
            Log.i("FinderJumpDataManager", "[clearIds] activityId=" + i + ", sourceId=" + ((a)localObject).sourceId + " jumpDataMap.size=" + localb.FuR.size());
          }
        }
        AppMethodBeat.o(331597);
      }
      
      public final void onActivitySaveInstanceState(Activity paramAnonymousActivity, Bundle paramAnonymousBundle)
      {
        AppMethodBeat.i(331621);
        s.u(paramAnonymousActivity, "activity");
        s.u(paramAnonymousBundle, "outState");
        AppMethodBeat.o(331621);
      }
      
      public final void onActivityStarted(Activity paramAnonymousActivity)
      {
        AppMethodBeat.i(331586);
        s.u(paramAnonymousActivity, "activity");
        AppMethodBeat.o(331586);
      }
      
      public final void onActivityStopped(Activity paramAnonymousActivity)
      {
        AppMethodBeat.i(331613);
        s.u(paramAnonymousActivity, "activity");
        AppMethodBeat.o(331613);
      }
    });
    AppMethodBeat.o(331590);
  }
  
  public static void aoW()
  {
    AppMethodBeat.i(331598);
    Log.i("FinderJumpDataManager", "register ");
    AppMethodBeat.o(331598);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/report/jump/FinderJumpDataManager$Companion;", "", "()V", "TAG", "", "instance", "Lcom/tencent/mm/plugin/finder/report/jump/FinderJumpDataManager;", "getInstance", "()Lcom/tencent/mm/plugin/finder/report/jump/FinderJumpDataManager;", "plugin-finder-base_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/report/jump/FinderJumpDataManager$SingletonHolder;", "", "()V", "holder", "Lcom/tencent/mm/plugin/finder/report/jump/FinderJumpDataManager;", "getHolder", "()Lcom/tencent/mm/plugin/finder/report/jump/FinderJumpDataManager;", "plugin-finder-base_release"}, k=1, mv={1, 5, 1}, xi=48)
  static final class b
  {
    public static final b FuW;
    private static final b FuX;
    
    static
    {
      AppMethodBeat.i(331577);
      FuW = new b();
      FuX = new b((byte)0);
      AppMethodBeat.o(331577);
    }
    
    public static b eOb()
    {
      return FuX;
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends k
    implements m<aq, d<? super ah>, Object>
  {
    int label;
    
    c(MMFragmentActivity paramMMFragmentActivity, b paramb, int paramInt, d<? super c> paramd)
    {
      super(paramd);
    }
    
    public final d<ah> create(Object paramObject, d<?> paramd)
    {
      AppMethodBeat.i(331557);
      paramObject = (d)new c(this.BvA, this.FuV, this.FuY, paramd);
      AppMethodBeat.o(331557);
      return paramObject;
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(331547);
      kotlin.d.a.a locala = kotlin.d.a.a.aiwj;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(331547);
        throw paramObject;
      }
      ResultKt.throwOnFailure(paramObject);
      int i = this.BvA.getTaskId();
      ((Map)b.a(this.FuV)).put(Integer.valueOf(this.FuY), Integer.valueOf(i));
      if (b.a(this.BvA)) {
        b.a(this.FuV, i);
      }
      Log.i("FinderJumpDataManager", "[getTaskIdAsync] taskId=" + i + ", finderTaskId=" + b.b(this.FuV));
      paramObject = ah.aiuX;
      AppMethodBeat.o(331547);
      return paramObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.report.jump.b
 * JD-Core Version:    0.7.0.1
 */