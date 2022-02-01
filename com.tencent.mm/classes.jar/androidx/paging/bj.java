package androidx.paging;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.ah;
import kotlin.d.a.a;
import kotlin.d.b.a.k;
import kotlin.d.d<-Lkotlin.ah;>;
import kotlin.d.f;
import kotlin.d.f.c;
import kotlin.g.a.b;
import kotlin.g.a.m;
import kotlin.g.b.s;
import kotlinx.coroutines.aq;
import kotlinx.coroutines.ar;
import kotlinx.coroutines.cb;
import kotlinx.coroutines.e.c;
import kotlinx.coroutines.e.e;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Landroidx/paging/SingleRunner;", "", "cancelPreviousInEqualPriority", "", "(Z)V", "holder", "Landroidx/paging/SingleRunner$Holder;", "runInIsolation", "", "priority", "", "block", "Lkotlin/Function1;", "Lkotlin/coroutines/Continuation;", "(ILkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "CancelIsolatedRunnerException", "Companion", "Holder", "paging-common"}, k=1, mv={1, 4, 2})
public final class bj
{
  public static final bj.b bRl;
  private final c bRk;
  
  static
  {
    AppMethodBeat.i(196994);
    bRl = new bj.b((byte)0);
    AppMethodBeat.o(196994);
  }
  
  public bj(boolean paramBoolean)
  {
    AppMethodBeat.i(196977);
    this.bRk = new c(this, paramBoolean);
    AppMethodBeat.o(196977);
  }
  
  public final Object a(final int paramInt, final b<? super kotlin.d.d<? super ah>, ? extends Object> paramb, kotlin.d.d<? super ah> paramd)
  {
    AppMethodBeat.i(196999);
    Object localObject1;
    if ((paramd instanceof d))
    {
      localObject1 = (d)paramd;
      if ((((d)localObject1).label & 0x80000000) != 0) {
        ((d)localObject1).label += -2147483648;
      }
    }
    Object localObject2;
    for (paramd = (kotlin.d.d<? super ah>)localObject1;; paramd = new d(this, paramd))
    {
      localObject2 = paramd.result;
      localObject1 = a.aiwj;
      switch (paramd.label)
      {
      default: 
        paramb = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(196999);
        throw paramb;
      }
    }
    ResultKt.throwOnFailure(localObject2);
    try
    {
      paramb = (m)new e(this, paramInt, paramb, null);
      paramd.L$0 = this;
      paramd.label = 1;
      paramb = ar.c(paramb, paramd);
      if (paramb == localObject1)
      {
        AppMethodBeat.o(196999);
        return localObject1;
        paramb = (bj)paramd.L$0;
      }
      while (paramd.bRm == (bj)paramb) {}
    }
    catch (a paramd)
    {
      try
      {
        ResultKt.throwOnFailure(localObject2);
        paramb = ah.aiuX;
        AppMethodBeat.o(196999);
        return paramb;
      }
      catch (a paramd)
      {
        break label191;
      }
      paramd = paramd;
      paramb = this;
    }
    label191:
    paramb = (Throwable)paramd;
    AppMethodBeat.o(196999);
    throw paramb;
  }
  
  @Metadata(bv={1, 0, 3}, d1={""}, d2={"Landroidx/paging/SingleRunner$CancelIsolatedRunnerException;", "Ljava/util/concurrent/CancellationException;", "Lkotlinx/coroutines/CancellationException;", "runner", "Landroidx/paging/SingleRunner;", "(Landroidx/paging/SingleRunner;)V", "getRunner", "()Landroidx/paging/SingleRunner;", "paging-common"}, k=1, mv={1, 4, 2})
  static final class a
    extends CancellationException
  {
    final bj bRm;
    
    public a(bj parambj)
    {
      AppMethodBeat.i(196611);
      this.bRm = parambj;
      AppMethodBeat.o(196611);
    }
  }
  
  @Metadata(bv={1, 0, 3}, d1={""}, d2={"Landroidx/paging/SingleRunner$Holder;", "", "singleRunner", "Landroidx/paging/SingleRunner;", "cancelPreviousInEqualPriority", "", "(Landroidx/paging/SingleRunner;Z)V", "mutex", "Lkotlinx/coroutines/sync/Mutex;", "previous", "Lkotlinx/coroutines/Job;", "previousPriority", "", "onFinish", "", "job", "(Lkotlinx/coroutines/Job;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "tryEnqueue", "priority", "(ILkotlinx/coroutines/Job;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "paging-common"}, k=1, mv={1, 4, 2})
  static final class c
  {
    private final c VA;
    private cb bRn;
    private int bRo;
    private final bj bRp;
    private final boolean bRq;
    
    public c(bj parambj, boolean paramBoolean)
    {
      AppMethodBeat.i(196626);
      this.bRp = parambj;
      this.bRq = paramBoolean;
      this.VA = e.kEM();
      AppMethodBeat.o(196626);
    }
    
    public final Object a(int paramInt, cb paramcb, kotlin.d.d<? super Boolean> paramd)
    {
      AppMethodBeat.i(196634);
      Object localObject2;
      if ((paramd instanceof b))
      {
        localObject2 = (b)paramd;
        if ((((b)localObject2).label & 0x80000000) != 0) {
          ((b)localObject2).label += -2147483648;
        }
      }
      a locala;
      for (;;)
      {
        localObject1 = ((b)localObject2).result;
        locala = a.aiwj;
        switch (((b)localObject2).label)
        {
        default: 
          paramcb = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
          AppMethodBeat.o(196634);
          throw paramcb;
          localObject2 = new b(this, paramd);
        }
      }
      ResultKt.throwOnFailure(localObject1);
      Object localObject1 = this.VA;
      ((b)localObject2).L$0 = this;
      ((b)localObject2).Uf = paramcb;
      ((b)localObject2).VC = localObject1;
      ((b)localObject2).aai = paramInt;
      ((b)localObject2).label = 1;
      cb localcb1;
      if (((c)localObject1).aD((kotlin.d.d)localObject2) == locala)
      {
        AppMethodBeat.o(196634);
        return locala;
        paramInt = ((b)localObject2).aai;
        paramcb = (c)((b)localObject2).VC;
        localcb1 = (cb)((b)localObject2).Uf;
        paramd = (c)((b)localObject2).L$0;
        ResultKt.throwOnFailure(localObject1);
      }
      for (;;)
      {
        localObject1 = paramcb;
        label497:
        for (;;)
        {
          try
          {
            cb localcb2 = paramd.bRn;
            if (localcb2 != null)
            {
              localObject1 = paramcb;
              if (localcb2.isActive())
              {
                localObject1 = paramcb;
                if (paramd.bRo >= paramInt)
                {
                  localObject1 = paramcb;
                  if (paramd.bRo != paramInt) {
                    continue;
                  }
                  localObject1 = paramcb;
                  if (!paramd.bRq) {
                    continue;
                  }
                }
              }
            }
            if (localcb2 != null)
            {
              localObject1 = paramcb;
              localcb2.a((CancellationException)new bj.a(paramd.bRp));
            }
            if (localcb2 != null)
            {
              localObject1 = paramcb;
              ((b)localObject2).L$0 = paramd;
              localObject1 = paramcb;
              ((b)localObject2).Uf = localcb1;
              localObject1 = paramcb;
              ((b)localObject2).VC = paramcb;
              localObject1 = paramcb;
              ((b)localObject2).aai = paramInt;
              localObject1 = paramcb;
              ((b)localObject2).label = 2;
              localObject1 = paramcb;
              localObject2 = localcb2.ay((kotlin.d.d)localObject2);
              if (localObject2 != locala) {
                break label497;
              }
              AppMethodBeat.o(196634);
              return locala;
              paramInt = ((b)localObject2).aai;
              paramcb = (c)((b)localObject2).VC;
              localcb1 = (cb)((b)localObject2).Uf;
              paramd = (c)((b)localObject2).L$0;
            }
          }
          finally
          {
            boolean bool;
            ((c)localObject1).jp(null);
            AppMethodBeat.o(196634);
          }
          try
          {
            ResultKt.throwOnFailure(localObject1);
            localObject1 = paramcb;
            paramd.bRn = localcb1;
            localObject1 = paramcb;
            paramd.bRo = paramInt;
            bool = true;
            paramcb.jp(null);
            AppMethodBeat.o(196634);
            return Boolean.valueOf(bool);
          }
          finally
          {
            localObject1 = paramcb;
            paramcb = paramd;
          }
          continue;
          bool = false;
        }
        paramd = this;
        localcb1 = paramcb;
        paramcb = (cb)localObject1;
      }
    }
    
    public final Object a(cb paramcb, kotlin.d.d<? super ah> paramd)
    {
      AppMethodBeat.i(196643);
      if ((paramd instanceof a))
      {
        localObject1 = (a)paramd;
        if ((((a)localObject1).label & 0x80000000) != 0) {
          ((a)localObject1).label += -2147483648;
        }
      }
      Object localObject3;
      Object localObject2;
      for (paramd = (kotlin.d.d<? super ah>)localObject1;; paramd = new a(this, paramd))
      {
        localObject3 = paramd.result;
        localObject2 = a.aiwj;
        switch (paramd.label)
        {
        default: 
          paramcb = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
          AppMethodBeat.o(196643);
          throw paramcb;
        }
      }
      ResultKt.throwOnFailure(localObject3);
      Object localObject1 = this.VA;
      paramd.L$0 = this;
      paramd.Uf = paramcb;
      paramd.VC = localObject1;
      paramd.label = 1;
      if (((c)localObject1).aD(paramd) == localObject2)
      {
        AppMethodBeat.o(196643);
        return localObject2;
        paramcb = (c)paramd.VC;
        localObject2 = (cb)paramd.Uf;
        localObject1 = (c)paramd.L$0;
        ResultKt.throwOnFailure(localObject3);
        paramd = paramcb;
      }
      for (;;)
      {
        try
        {
          if (localObject2 == ((c)localObject1).bRn) {
            ((c)localObject1).bRn = null;
          }
          paramcb = ah.aiuX;
          paramd.jp(null);
          paramcb = ah.aiuX;
          AppMethodBeat.o(196643);
          return paramcb;
        }
        finally
        {
          paramd.jp(null);
          AppMethodBeat.o(196643);
        }
        paramd = (kotlin.d.d<? super ah>)localObject1;
        localObject1 = this;
        localObject2 = paramcb;
      }
    }
    
    @Metadata(bv={1, 0, 3}, d1={""}, d2={"onFinish", "", "job", "Lkotlinx/coroutines/Job;", "continuation", "Lkotlin/coroutines/Continuation;", ""}, k=3, mv={1, 4, 2})
    static final class a
      extends kotlin.d.b.a.d
    {
      Object L$0;
      Object Uf;
      Object VC;
      int label;
      
      a(bj.c paramc, kotlin.d.d paramd)
      {
        super();
      }
      
      public final Object invokeSuspend(Object paramObject)
      {
        AppMethodBeat.i(196985);
        this.result = paramObject;
        this.label |= 0x80000000;
        paramObject = this.bRr.a(null, this);
        AppMethodBeat.o(196985);
        return paramObject;
      }
    }
    
    @Metadata(bv={1, 0, 3}, d1={""}, d2={"tryEnqueue", "", "priority", "", "job", "Lkotlinx/coroutines/Job;", "continuation", "Lkotlin/coroutines/Continuation;", ""}, k=3, mv={1, 4, 2})
    static final class b
      extends kotlin.d.b.a.d
    {
      Object L$0;
      Object Uf;
      Object VC;
      int aai;
      int label;
      
      b(bj.c paramc, kotlin.d.d paramd)
      {
        super();
      }
      
      public final Object invokeSuspend(Object paramObject)
      {
        AppMethodBeat.i(196993);
        this.result = paramObject;
        this.label |= 0x80000000;
        paramObject = this.bRr.a(0, null, this);
        AppMethodBeat.o(196993);
        return paramObject;
      }
    }
  }
  
  @Metadata(bv={1, 0, 3}, d1={""}, d2={"runInIsolation", "", "priority", "", "block", "Lkotlin/Function1;", "Lkotlin/coroutines/Continuation;", "", "continuation"}, k=3, mv={1, 4, 2})
  static final class d
    extends kotlin.d.b.a.d
  {
    Object L$0;
    int label;
    
    d(bj parambj, kotlin.d.d paramd)
    {
      super();
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(196644);
      this.result = paramObject;
      this.label |= 0x80000000;
      paramObject = this.bRs.a(0, null, this);
      AppMethodBeat.o(196644);
      return paramObject;
    }
  }
  
  @Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k=3, mv={1, 4, 2})
  static final class e
    extends k
    implements m<aq, kotlin.d.d<? super ah>, Object>
  {
    int label;
    
    e(bj parambj, int paramInt, b paramb, kotlin.d.d paramd)
    {
      super(paramd);
    }
    
    public final kotlin.d.d<ah> create(Object paramObject, kotlin.d.d<?> paramd)
    {
      AppMethodBeat.i(196647);
      s.u(paramd, "completion");
      paramd = new e(this.bRs, paramInt, paramb, paramd);
      paramd.L$0 = paramObject;
      AppMethodBeat.o(196647);
      return paramd;
    }
    
    public final Object invoke(Object paramObject1, Object paramObject2)
    {
      AppMethodBeat.i(196654);
      paramObject1 = ((e)create(paramObject1, (kotlin.d.d)paramObject2)).invokeSuspend(ah.aiuX);
      AppMethodBeat.o(196654);
      return paramObject1;
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(196637);
      a locala = a.aiwj;
      Object localObject1;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(196637);
        throw paramObject;
      case 0: 
        ResultKt.throwOnFailure(paramObject);
        paramObject = ((aq)this.L$0).getCoroutineContext().get((f.c)cb.ajws);
        if (paramObject == null)
        {
          paramObject = (Throwable)new IllegalStateException("Internal error. coroutineScope should've created a job.".toString());
          AppMethodBeat.o(196637);
          throw paramObject;
        }
        paramObject = (cb)paramObject;
        localObject1 = bj.a(this.bRs);
        int i = paramInt;
        this.L$0 = paramObject;
        this.label = 1;
        localObject1 = ((bj.c)localObject1).a(i, paramObject, this);
        if (localObject1 == locala)
        {
          AppMethodBeat.o(196637);
          return locala;
        }
        break;
      case 1: 
        cb localcb = (cb)this.L$0;
        ResultKt.throwOnFailure(paramObject);
        localObject1 = paramObject;
        paramObject = localcb;
      case 2: 
      case 3: 
      case 4: 
        for (;;)
        {
          if (((Boolean)localObject1).booleanValue()) {}
          try
          {
            localObject1 = paramb;
            this.L$0 = paramObject;
            this.label = 2;
            localObject1 = ((b)localObject1).invoke(this);
            if (localObject1 == locala)
            {
              AppMethodBeat.o(196637);
              return locala;
              localObject1 = (cb)this.L$0;
            }
            label308:
            bj.c localc;
          }
          finally
          {
            try
            {
              ResultKt.throwOnFailure(paramObject);
              paramObject = localObject1;
              localObject1 = bj.a(this.bRs);
              this.L$0 = null;
              this.label = 3;
              if (((bj.c)localObject1).a(paramObject, this) == locala)
              {
                AppMethodBeat.o(196637);
                return locala;
                ResultKt.throwOnFailure(paramObject);
              }
              paramObject = ah.aiuX;
              AppMethodBeat.o(196637);
              return paramObject;
            }
            finally
            {
              break label308;
            }
            localObject2 = finally;
            localObject1 = paramObject;
            paramObject = localObject2;
            localc = bj.a(this.bRs);
            this.L$0 = paramObject;
            this.label = 4;
            if (localc.a((cb)localObject1, this) == locala)
            {
              AppMethodBeat.o(196637);
              return locala;
              localObject1 = (Throwable)this.L$0;
              ResultKt.throwOnFailure(paramObject);
              paramObject = localObject1;
              AppMethodBeat.o(196637);
            }
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.paging.bj
 * JD-Core Version:    0.7.0.1
 */