package com.tencent.mm.modelcdntran;

import androidx.lifecycle.q;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.g;
import com.tencent.mm.kernel.h;
import com.tencent.mm.kernel.mvvm.MvvmPlugin;
import com.tencent.mm.plugin.expt.b.c;
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.sdk.coroutines.LifecycleScope;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.ah;
import kotlin.g.a.m;
import kotlin.g.b.s;
import kotlin.j;
import kotlinx.coroutines.aq;
import kotlinx.coroutines.b.w;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/modelcdntran/CdnPLC;", "Lcom/tencent/mm/kernel/mvvm/PluginComponent;", "plugin", "Lcom/tencent/mm/kernel/mvvm/MvvmPlugin;", "(Lcom/tencent/mm/kernel/mvvm/MvvmPlugin;)V", "runningDownloadTaskMap", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Lcom/tencent/mm/modelcdntran/CdnPLC$RunningObj;", "runningUploadTaskMap", "workerScope", "Lcom/tencent/mm/sdk/coroutines/LifecycleScope;", "getWorkerScope", "()Lcom/tencent/mm/sdk/coroutines/LifecycleScope;", "workerScope$delegate", "Lkotlin/Lazy;", "cancelDownloadTask", "Lkotlinx/coroutines/flow/SharedFlow;", "Lcom/tencent/mm/modelcdntran/CdnTransportEvent;", "mediaId", "cancelTask", "", "runningMap", "handler", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "Lcom/tencent/mm/cdn/keep_TaskInfo;", "task", "cancelUploadTask", "doCancel", "doStart", "taskInfo", "logD", "", "log", "logI", "onAccountInit", "upgrade", "Lcom/tencent/mm/kernel/CoreStorage$UpgradeInfo;", "onAccountRelease", "realStart", "mutableSharedFlow", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "startDownloadTask", "startJniTask", "obj", "Lkotlin/Function1;", "startUploadTask", "emitInner", "event", "Companion", "RunningObj", "plugin-comm_release"}, k=1, mv={1, 5, 1}, xi=48)
public class a
  extends com.tencent.mm.kernel.mvvm.e
{
  public static final a.a oyY;
  private final j oyZ;
  ConcurrentHashMap<String, b> oza;
  private ConcurrentHashMap<String, b> ozb;
  
  static
  {
    AppMethodBeat.i(237969);
    oyY = new a.a((byte)0);
    AppMethodBeat.o(237969);
  }
  
  public a(MvvmPlugin paramMvvmPlugin)
  {
    super(paramMvvmPlugin);
    AppMethodBeat.i(237870);
    this.oyZ = kotlin.k.cm((kotlin.g.a.a)new a.i(paramMvvmPlugin));
    AppMethodBeat.o(237870);
  }
  
  public static void Np(String paramString)
  {
    AppMethodBeat.i(237896);
    s.u(paramString, "log");
    Log.i("MicroMsg.Cdn.CdnPLC", paramString);
    AppMethodBeat.o(237896);
  }
  
  public static int a(g paramg)
  {
    AppMethodBeat.i(237881);
    s.u(paramg, "taskInfo");
    if (paramg.field_fileType == 40001)
    {
      i = k.bHX().a(paramg.field_mediaId, paramg.lwO, paramg.field_fullpath, paramg.field_fileType, paramg.field_aesKey, paramg.field_authKey, paramg.field_totalLen, false);
      AppMethodBeat.o(237881);
      return i;
    }
    if (paramg.field_fileType == 19)
    {
      boolean bool = ((c)h.ax(c.class)).a(c.a.zpR, false);
      i = k.bHX().a(paramg.field_mediaId, paramg.lwO, paramg.field_fullpath, paramg.field_fileType, paramg.field_aesKey, paramg.field_authKey, paramg.field_totalLen, bool);
      AppMethodBeat.o(237881);
      return i;
    }
    if ((paramg.field_fileType == com.tencent.mm.g.a.lwn) || (paramg.field_fileType == com.tencent.mm.g.a.lwp) || (paramg.field_fileType == com.tencent.mm.g.a.lwt))
    {
      i = k.bHX().a(paramg.field_mediaId, paramg.lwO, paramg.field_fullpath, paramg.field_fileType, paramg.lwP, paramg.lwQ, paramg.lwR, paramg.lwS, paramg.lwZ, paramg.lxa);
      AppMethodBeat.o(237881);
      return i;
    }
    if (paramg.lwU)
    {
      i = k.bHX().a(paramg.field_mediaId, paramg.field_fullpath, paramg.lwO, paramg.lwV, paramg.lwW, paramg.allow_mobile_net_download, paramg.lwP, paramg.lwQ, paramg.is_resume_task, paramg.lwT, paramg.lwR);
      AppMethodBeat.o(237881);
      return i;
    }
    if (paramg.lwX)
    {
      if ((paramg instanceof com.tencent.mm.g.f))
      {
        i = k.bHX().a((com.tencent.mm.g.f)paramg);
        AppMethodBeat.o(237881);
        return i;
      }
      if ((paramg instanceof com.tencent.mm.g.e))
      {
        i = k.bHX().a((com.tencent.mm.g.e)paramg);
        AppMethodBeat.o(237881);
        return i;
      }
      AppMethodBeat.o(237881);
      return -1;
    }
    if (paramg.ihD)
    {
      i = k.bHX().d(paramg);
      AppMethodBeat.o(237881);
      return i;
    }
    int i = k.bHX().e(paramg);
    AppMethodBeat.o(237881);
    return i;
  }
  
  public static int a(String paramString, g paramg)
  {
    AppMethodBeat.i(237894);
    s.u(paramString, "mediaId");
    s.u(paramg, "task");
    if (paramg.ihD)
    {
      k.bHX();
      i = d.Nq(paramString);
      AppMethodBeat.o(237894);
      return i;
    }
    k.bHX();
    int i = d.Nr(paramString);
    AppMethodBeat.o(237894);
    return i;
  }
  
  private static final void a(final a parama, e parame)
  {
    AppMethodBeat.i(237906);
    s.u(parama, "this$0");
    s.u(parame, "event");
    String str = "event:" + parame.ozK + " mediaId:" + parame.mediaId + " ret:" + parame.ret;
    s.u(str, "log");
    Log.d("MicroMsg.Cdn.CdnPLC", str);
    LifecycleScope.launchDefault$default(parama.bHH(), null, (m)new e(parame, parama, null), 1, null);
    AppMethodBeat.o(237906);
  }
  
  public final void a(w<e> paramw, e parame)
  {
    AppMethodBeat.i(238020);
    s.u(paramw, "<this>");
    s.u(parame, "event");
    LifecycleScope.launchDefault$default(bHH(), null, (m)new a.d(paramw, parame, null), 1, null);
    AppMethodBeat.o(238020);
  }
  
  final LifecycleScope bHH()
  {
    AppMethodBeat.i(237985);
    LifecycleScope localLifecycleScope = (LifecycleScope)this.oyZ.getValue();
    AppMethodBeat.o(237985);
    return localLifecycleScope;
  }
  
  public final void bbz()
  {
    AppMethodBeat.i(237994);
    this.oza = new ConcurrentHashMap();
    this.ozb = new ConcurrentHashMap();
    k.bHX().ozE.observe((q)bby(), new a..ExternalSyntheticLambda0(this));
    AppMethodBeat.o(237994);
  }
  
  public final void onAccountRelease()
  {
    this.oza = null;
    this.ozb = null;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/modelcdntran/CdnPLC$RunningObj;", "", "task", "Lcom/tencent/mm/cdn/keep_TaskInfo;", "mutableSharedFlow", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "Lcom/tencent/mm/modelcdntran/CdnTransportEvent;", "(Lcom/tencent/mm/modelcdntran/CdnPLC;Lcom/tencent/mm/cdn/keep_TaskInfo;Lkotlinx/coroutines/flow/MutableSharedFlow;)V", "getMutableSharedFlow", "()Lkotlinx/coroutines/flow/MutableSharedFlow;", "getTask", "()Lcom/tencent/mm/cdn/keep_TaskInfo;", "plugin-comm_release"}, k=1, mv={1, 5, 1}, xi=48)
  public final class b
  {
    final g ozc;
    final w<e> ozd;
    
    public b(w<e> paramw)
    {
      AppMethodBeat.i(237874);
      this.ozc = paramw;
      this.ozd = localObject;
      AppMethodBeat.o(237874);
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends kotlin.d.b.a.k
    implements m<aq, kotlin.d.d<? super ah>, Object>
  {
    int label;
    
    c(a parama, String paramString, w<e> paramw, kotlin.d.d<? super c> paramd)
    {
      super(paramd);
    }
    
    public final kotlin.d.d<ah> create(Object paramObject, kotlin.d.d<?> paramd)
    {
      AppMethodBeat.i(237883);
      paramObject = (kotlin.d.d)new c(this.oze, this.mrQ, this.ozf, paramd);
      AppMethodBeat.o(237883);
      return paramObject;
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(237877);
      Object localObject1 = kotlin.d.a.a.aiwj;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(237877);
        throw paramObject;
      }
      ResultKt.throwOnFailure(paramObject);
      Object localObject2 = a.a(this.oze);
      if (localObject2 != null)
      {
        paramObject = this.oze;
        Object localObject3 = this.mrQ;
        localObject1 = this.ozf;
        int i = a.a((ConcurrentHashMap)localObject2, (String)localObject3, (m)new a.c.a(paramObject));
        localObject2 = new e(e.a.ozY, (String)localObject3);
        ((e)localObject2).ret = i;
        localObject3 = ah.aiuX;
        paramObject.a((w)localObject1, (e)localObject2);
      }
      paramObject = ah.aiuX;
      AppMethodBeat.o(237877);
      return paramObject;
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class e
    extends kotlin.d.b.a.k
    implements m<aq, kotlin.d.d<? super ah>, Object>
  {
    int label;
    
    e(e parame, a parama, kotlin.d.d<? super e> paramd)
    {
      super(paramd);
    }
    
    public final kotlin.d.d<ah> create(Object paramObject, kotlin.d.d<?> paramd)
    {
      AppMethodBeat.i(237901);
      paramObject = (kotlin.d.d)new e(this.ozh, parama, paramd);
      AppMethodBeat.o(237901);
      return paramObject;
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      Object localObject2 = null;
      Object localObject1 = null;
      AppMethodBeat.i(237897);
      kotlin.d.a.a locala = kotlin.d.a.a.aiwj;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(237897);
        throw paramObject;
      }
      ResultKt.throwOnFailure(paramObject);
      paramObject = this.ozh.ozK;
      switch (a.$EnumSwitchMapping$0[paramObject.ordinal()])
      {
      }
      label343:
      for (;;)
      {
        paramObject = ah.aiuX;
        AppMethodBeat.o(237897);
        return paramObject;
        if (this.ozh.ozK == e.a.ozP)
        {
          paramObject = a.a(parama);
          if (paramObject == null) {
            paramObject = localObject1;
          }
        }
        while (paramObject != null)
        {
          paramObject = paramObject.ozd;
          localObject1 = parama;
          localObject2 = this.ozh;
          s.s(localObject2, "event");
          ((a)localObject1).a(paramObject, (e)localObject2);
          break;
          paramObject = (a.b)paramObject.get(this.ozh.mediaId);
          continue;
          localObject2 = a.a(parama);
          paramObject = localObject1;
          if (localObject2 != null) {
            paramObject = (a.b)((ConcurrentHashMap)localObject2).remove(this.ozh.mediaId);
          }
        }
        if (this.ozh.ozK == e.a.ozS)
        {
          paramObject = a.b(parama);
          if (paramObject == null) {
            paramObject = localObject2;
          }
        }
        for (;;)
        {
          if (paramObject == null) {
            break label343;
          }
          paramObject = paramObject.ozd;
          localObject1 = parama;
          localObject2 = this.ozh;
          s.s(localObject2, "event");
          ((a)localObject1).a(paramObject, (e)localObject2);
          break;
          paramObject = (a.b)paramObject.get(this.ozh.mediaId);
          continue;
          localObject1 = a.b(parama);
          paramObject = localObject2;
          if (localObject1 != null) {
            paramObject = (a.b)((ConcurrentHashMap)localObject1).remove(this.ozh.mediaId);
          }
        }
      }
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class g
    extends kotlin.d.b.a.k
    implements m<aq, kotlin.d.d<? super ah>, Object>
  {
    int label;
    
    g(a parama, g paramg, w<e> paramw, kotlin.d.d<? super g> paramd)
    {
      super(paramd);
    }
    
    public final kotlin.d.d<ah> create(Object paramObject, kotlin.d.d<?> paramd)
    {
      AppMethodBeat.i(237841);
      paramObject = (kotlin.d.d)new g(this.oze, this.ozi, this.ozj, paramd);
      AppMethodBeat.o(237841);
      return paramObject;
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(237833);
      kotlin.d.a.a locala = kotlin.d.a.a.aiwj;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(237833);
        throw paramObject;
      }
      ResultKt.throwOnFailure(paramObject);
      paramObject = a.a(this.oze);
      if (paramObject != null) {
        a.a(this.oze, paramObject, this.ozi, this.ozj);
      }
      paramObject = ah.aiuX;
      AppMethodBeat.o(237833);
      return paramObject;
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class h
    extends kotlin.d.b.a.k
    implements m<aq, kotlin.d.d<? super ah>, Object>
  {
    int label;
    
    h(a parama, g paramg, w<e> paramw, kotlin.d.d<? super h> paramd)
    {
      super(paramd);
    }
    
    public final kotlin.d.d<ah> create(Object paramObject, kotlin.d.d<?> paramd)
    {
      AppMethodBeat.i(237842);
      paramObject = (kotlin.d.d)new h(this.oze, this.ozi, this.ozf, paramd);
      AppMethodBeat.o(237842);
      return paramObject;
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(237834);
      kotlin.d.a.a locala = kotlin.d.a.a.aiwj;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(237834);
        throw paramObject;
      }
      ResultKt.throwOnFailure(paramObject);
      paramObject = a.b(this.oze);
      if (paramObject != null) {
        a.a(this.oze, paramObject, this.ozi, this.ozf);
      }
      paramObject = ah.aiuX;
      AppMethodBeat.o(237834);
      return paramObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.modelcdntran.a
 * JD-Core Version:    0.7.0.1
 */