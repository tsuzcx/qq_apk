package com.tencent.mm.plugin.finder.live.viewmodel.data;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.b.a;
import com.tencent.mm.protocal.protobuf.esc;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.ah;
import kotlin.d.b.a.k;
import kotlin.d.h;
import kotlin.g.a.m;
import kotlin.g.b.s;
import kotlinx.coroutines.aq;
import kotlinx.coroutines.ar;
import kotlinx.coroutines.cb;
import kotlinx.coroutines.j;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/viewmodel/data/PollingHandler;", "", "task", "Lcom/tencent/mm/plugin/finder/live/viewmodel/data/PollingHandler$Task;", "coroutineContext", "Lkotlin/coroutines/CoroutineContext;", "minInterval", "", "(Lcom/tencent/mm/plugin/finder/live/viewmodel/data/PollingHandler$Task;Lkotlin/coroutines/CoroutineContext;J)V", "getCoroutineContext", "()Lkotlin/coroutines/CoroutineContext;", "job", "Lkotlinx/coroutines/Job;", "getJob", "()Lkotlinx/coroutines/Job;", "setJob", "(Lkotlinx/coroutines/Job;)V", "getMinInterval", "()J", "scope", "Lkotlinx/coroutines/CoroutineScope;", "getScope", "()Lkotlinx/coroutines/CoroutineScope;", "setScope", "(Lkotlinx/coroutines/CoroutineScope;)V", "getTask", "()Lcom/tencent/mm/plugin/finder/live/viewmodel/data/PollingHandler$Task;", "start", "", "stopAsync", "stopSync", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "BatchCgiTask", "CgiTask", "NextConfig", "Task", "plugin-finder-base_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class p
{
  final d akfM;
  final long akfN;
  private final kotlin.d.f bGV;
  private cb job;
  public aq scope;
  
  public p(d paramd, kotlin.d.f paramf)
  {
    AppMethodBeat.i(371602);
    this.akfM = paramd;
    this.bGV = paramf;
    this.akfN = 1000L;
    AppMethodBeat.o(371602);
  }
  
  public final void start()
  {
    AppMethodBeat.i(371608);
    aq localaq = ar.d(this.bGV);
    s.u(localaq, "<set-?>");
    this.scope = localaq;
    localaq = this.scope;
    if (localaq != null) {}
    for (;;)
    {
      this.job = j.a(localaq, null, null, (m)new p.e(this, null), 3);
      AppMethodBeat.o(371608);
      return;
      s.bIx("scope");
      localaq = null;
    }
  }
  
  public final void stopAsync()
  {
    AppMethodBeat.i(371610);
    cb localcb = this.job;
    if (localcb != null) {
      localcb.a(null);
    }
    this.job = null;
    AppMethodBeat.o(371610);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/viewmodel/data/PollingHandler$BatchCgiTask;", "T", "Lcom/tencent/mm/protocal/protobuf/ResponseProtoBuf;", "Lcom/tencent/mm/plugin/finder/live/viewmodel/data/PollingHandler$Task;", "()V", "generateCgi", "", "Lcom/tencent/mm/modelbase/Cgi;", "processResp", "Lcom/tencent/mm/plugin/finder/live/viewmodel/data/PollingHandler$NextConfig;", "cgi", "cgiBack", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "run", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "runCgi", "(Lcom/tencent/mm/modelbase/Cgi;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "plugin-finder-base_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static abstract class a<T extends esc>
    implements p.d
  {
    public abstract p.c a(com.tencent.mm.am.b<T> paramb, b.a<T> parama);
    
    public final Object aF(kotlin.d.d<? super p.c> paramd)
    {
      return a(this, paramd);
    }
    
    public abstract List<com.tencent.mm.am.b<T>> jKv();
    
    @Metadata(k=3, mv={1, 5, 1}, xi=48)
    static final class a
      extends kotlin.d.b.a.d
    {
      Object L$0;
      int label;
      
      a(p.a<T> parama, kotlin.d.d<? super a> paramd)
      {
        super();
      }
      
      public final Object invokeSuspend(Object paramObject)
      {
        AppMethodBeat.i(371599);
        this.result = paramObject;
        this.label |= 0x80000000;
        paramObject = p.a.a(this.akfO, (kotlin.d.d)this);
        AppMethodBeat.o(371599);
        return paramObject;
      }
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", "", "T", "Lcom/tencent/mm/protocal/protobuf/ResponseProtoBuf;", "Lkotlinx/coroutines/CoroutineScope;"}, k=3, mv={1, 5, 1}, xi=48)
    static final class b
      extends k
      implements m<aq, kotlin.d.d<? super ah>, Object>
    {
      int label;
      
      b(List<? extends com.tencent.mm.am.b<T>> paramList, ArrayList<p.c> paramArrayList, p.a<T> parama, kotlin.d.d<? super b> paramd)
      {
        super(paramd);
      }
      
      public final kotlin.d.d<ah> create(Object paramObject, kotlin.d.d<?> paramd)
      {
        AppMethodBeat.i(371604);
        paramd = new b(this.akfP, this.akfQ, this.akfO, paramd);
        paramd.L$0 = paramObject;
        paramObject = (kotlin.d.d)paramd;
        AppMethodBeat.o(371604);
        return paramObject;
      }
      
      public final Object invokeSuspend(Object paramObject)
      {
        AppMethodBeat.i(371597);
        Object localObject1 = kotlin.d.a.a.aiwj;
        switch (this.label)
        {
        default: 
          paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
          AppMethodBeat.o(371597);
          throw paramObject;
        }
        ResultKt.throwOnFailure(paramObject);
        paramObject = (aq)this.L$0;
        Object localObject2 = (Iterable)this.akfP;
        localObject1 = this.akfQ;
        final p.a locala = this.akfO;
        localObject2 = ((Iterable)localObject2).iterator();
        while (((Iterator)localObject2).hasNext()) {
          j.a(paramObject, null, null, (m)new a((ArrayList)localObject1, locala, (com.tencent.mm.am.b)((Iterator)localObject2).next(), null), 3);
        }
        paramObject = ah.aiuX;
        AppMethodBeat.o(371597);
        return paramObject;
      }
      
      @Metadata(d1={""}, d2={"<anonymous>", "", "T", "Lcom/tencent/mm/protocal/protobuf/ResponseProtoBuf;", "Lkotlinx/coroutines/CoroutineScope;"}, k=3, mv={1, 5, 1}, xi=48)
      static final class a
        extends k
        implements m<aq, kotlin.d.d<? super ah>, Object>
      {
        Object L$0;
        int label;
        
        a(ArrayList<p.c> paramArrayList, p.a<T> parama, com.tencent.mm.am.b<T> paramb, kotlin.d.d<? super a> paramd)
        {
          super(paramd);
        }
        
        public final kotlin.d.d<ah> create(Object paramObject, kotlin.d.d<?> paramd)
        {
          AppMethodBeat.i(371609);
          paramObject = (kotlin.d.d)new a(this.akfQ, locala, this.akfR, paramd);
          AppMethodBeat.o(371609);
          return paramObject;
        }
        
        public final Object invokeSuspend(Object paramObject)
        {
          AppMethodBeat.i(371605);
          Object localObject2 = kotlin.d.a.a.aiwj;
          Object localObject1;
          switch (this.label)
          {
          default: 
            paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            AppMethodBeat.o(371605);
            throw paramObject;
          case 0: 
            ResultKt.throwOnFailure(paramObject);
            paramObject = this.akfQ;
            localObject1 = locala;
            com.tencent.mm.am.b localb = this.akfR;
            kotlin.d.d locald1 = (kotlin.d.d)this;
            this.L$0 = paramObject;
            this.label = 1;
            h localh = new h(kotlin.d.a.b.au(locald1));
            kotlin.d.d locald2 = (kotlin.d.d)localh;
            localb.bFJ().g((com.tencent.mm.vending.c.a)new p.a.c((p.a)localObject1, localb, locald2));
            localObject1 = localh.kli();
            if (localObject1 == kotlin.d.a.a.aiwj) {
              s.u(locald1, "frame");
            }
            if (localObject1 == localObject2)
            {
              AppMethodBeat.o(371605);
              return localObject2;
            }
            break;
          case 1: 
            localObject2 = (ArrayList)this.L$0;
            ResultKt.throwOnFailure(paramObject);
            localObject1 = paramObject;
            paramObject = localObject2;
          }
          for (;;)
          {
            paramObject.add(localObject1);
            paramObject = ah.aiuX;
            AppMethodBeat.o(371605);
            return paramObject;
          }
        }
      }
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", "", "T", "Lcom/tencent/mm/protocal/protobuf/ResponseProtoBuf;", "cgiBack", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
    static final class c<_Ret, _Var>
      implements com.tencent.mm.vending.c.a
    {
      c(p.a<T> parama, com.tencent.mm.am.b<T> paramb, kotlin.d.d<? super p.c> paramd) {}
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/viewmodel/data/PollingHandler$CgiTask;", "T", "Lcom/tencent/mm/protocal/protobuf/ResponseProtoBuf;", "Lcom/tencent/mm/plugin/finder/live/viewmodel/data/PollingHandler$Task;", "()V", "generateCgi", "Lcom/tencent/mm/modelbase/Cgi;", "processResp", "Lcom/tencent/mm/plugin/finder/live/viewmodel/data/PollingHandler$NextConfig;", "cgi", "cgiBack", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "run", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "plugin-finder-base_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static abstract class b<T extends esc>
    implements p.d
  {
    public abstract p.c a(com.tencent.mm.am.b<T> paramb, b.a<T> parama);
    
    public final Object aF(kotlin.d.d<? super p.c> paramd)
    {
      Object localObject = new h(kotlin.d.a.b.au(paramd));
      final kotlin.d.d locald = (kotlin.d.d)localObject;
      final com.tencent.mm.am.b localb = jKw();
      localb.bFJ().g((com.tencent.mm.vending.c.a)new a(this, localb, locald));
      localObject = ((h)localObject).kli();
      if (localObject == kotlin.d.a.a.aiwj) {
        s.u(paramd, "frame");
      }
      return localObject;
    }
    
    public abstract com.tencent.mm.am.b<T> jKw();
    
    @Metadata(d1={""}, d2={"<anonymous>", "", "T", "Lcom/tencent/mm/protocal/protobuf/ResponseProtoBuf;", "cgiBack", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
    static final class a<_Ret, _Var>
      implements com.tencent.mm.vending.c.a
    {
      a(p.b<T> paramb, com.tencent.mm.am.b<T> paramb1, kotlin.d.d<? super p.c> paramd) {}
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/viewmodel/data/PollingHandler$NextConfig;", "", "continuePolling", "", "delayTimeMs", "", "(ZJ)V", "getContinuePolling", "()Z", "getDelayTimeMs", "()J", "component1", "component2", "copy", "equals", "other", "hashCode", "", "toString", "", "plugin-finder-base_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class c
  {
    final boolean akfT;
    final long akfU;
    
    public c(boolean paramBoolean, long paramLong)
    {
      this.akfT = paramBoolean;
      this.akfU = paramLong;
    }
    
    public final boolean equals(Object paramObject)
    {
      if (this == paramObject) {}
      do
      {
        return true;
        if (!(paramObject instanceof c)) {
          return false;
        }
        paramObject = (c)paramObject;
        if (this.akfT != paramObject.akfT) {
          return false;
        }
      } while (this.akfU == paramObject.akfU);
      return false;
    }
    
    public final int hashCode()
    {
      throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
    }
    
    public final String toString()
    {
      AppMethodBeat.i(371598);
      String str = "NextConfig(continuePolling=" + this.akfT + ", delayTimeMs=" + this.akfU + ')';
      AppMethodBeat.o(371598);
      return str;
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/viewmodel/data/PollingHandler$Task;", "", "run", "Lcom/tencent/mm/plugin/finder/live/viewmodel/data/PollingHandler$NextConfig;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "plugin-finder-base_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static abstract interface d
  {
    public abstract Object aF(kotlin.d.d<? super p.c> paramd);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.viewmodel.data.p
 * JD-Core Version:    0.7.0.1
 */