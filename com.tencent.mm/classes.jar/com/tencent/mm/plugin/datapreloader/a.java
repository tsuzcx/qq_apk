package com.tencent.mm.plugin.datapreloader;

import androidx.lifecycle.j.b;
import androidx.lifecycle.p;
import androidx.lifecycle.q;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.cn;
import com.tencent.mm.plugin.datapreloader.a.c;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.ah;
import kotlin.d.d<-Lkotlin.ah;>;
import kotlin.g.a.m;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlinx.coroutines.al;
import kotlinx.coroutines.aq;
import kotlinx.coroutines.ar;
import kotlinx.coroutines.cb;
import kotlinx.coroutines.l;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/datapreloader/FutureTask;", "_key", "", "_value", "T", "Lcom/tencent/mm/plugin/datapreloader/IDataFuture;", "initLoader", "Lkotlin/Function0;", "parentJob", "Lkotlinx/coroutines/Job;", "lifecycleOwner", "Landroidx/lifecycle/LifecycleOwner;", "coroutineDispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "(Lkotlin/jvm/functions/Function0;Lkotlinx/coroutines/Job;Landroidx/lifecycle/LifecycleOwner;Lkotlinx/coroutines/CoroutineDispatcher;)V", "TAG", "", "future", "getFuture", "()Lcom/tencent/mm/plugin/datapreloader/IDataFuture;", "setFuture", "(Lcom/tencent/mm/plugin/datapreloader/IDataFuture;)V", "Lcom/tencent/mm/plugin/datapreloader/IDataFuture;", "initJob", "key", "getKey", "()Ljava/lang/Object;", "key$delegate", "Lkotlin/Lazy;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "getScope", "()Lkotlinx/coroutines/CoroutineScope;", "scope$delegate", "store", "Lcom/tencent/mm/plugin/datapreloader/cache/IDataCache;", "getStore", "()Lcom/tencent/mm/plugin/datapreloader/cache/IDataCache;", "store$delegate", "cancel", "", "generateDataStore", "preload", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "run", "checkCache", "", "(ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "waitInitDone", "plugin-datapreloader_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract class a<_key, _value, T extends b<_key, _value>>
{
  final String TAG = "FutureTask";
  private final kotlin.j mFt = kotlin.k.cm((kotlin.g.a.a)new g(this));
  cb nZW;
  protected T xfK;
  private final kotlin.j xfL = kotlin.k.cm((kotlin.g.a.a)new a(this));
  private final kotlin.j xfM;
  
  private a(final kotlin.g.a.a<? extends T> parama, cb paramcb, q paramq, final al paramal)
  {
    this.xfM = kotlin.k.cm((kotlin.g.a.a)new f(paramcb, paramal));
    kotlinx.coroutines.j.a(ar.kBZ(), null, null, (m)new kotlin.d.b.a.k(paramq, this)
    {
      int label;
      
      public final kotlin.d.d<ah> create(Object paramAnonymousObject, kotlin.d.d<?> paramAnonymousd)
      {
        AppMethodBeat.i(260481);
        paramAnonymousObject = (kotlin.d.d)new 1(this.eF, jdField_this, paramAnonymousd);
        AppMethodBeat.o(260481);
        return paramAnonymousObject;
      }
      
      public final Object invokeSuspend(Object paramAnonymousObject)
      {
        AppMethodBeat.i(260478);
        kotlin.d.a.a locala = kotlin.d.a.a.aiwj;
        switch (this.label)
        {
        default: 
          paramAnonymousObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
          AppMethodBeat.o(260478);
          throw paramAnonymousObject;
        }
        ResultKt.throwOnFailure(paramAnonymousObject);
        paramAnonymousObject = this.eF;
        int i;
        if (paramAnonymousObject != null)
        {
          paramAnonymousObject = paramAnonymousObject.getLifecycle();
          if (paramAnonymousObject != null)
          {
            if (paramAnonymousObject.getCurrentState() == j.b.bHg) {
              break label126;
            }
            i = 1;
            if (i == 0) {
              break label131;
            }
          }
        }
        for (;;)
        {
          if (paramAnonymousObject != null) {
            paramAnonymousObject.addObserver((p)new FutureTask.1.2(jdField_this, this.eF));
          }
          paramAnonymousObject = ah.aiuX;
          AppMethodBeat.o(260478);
          return paramAnonymousObject;
          label126:
          i = 0;
          break;
          label131:
          paramAnonymousObject = null;
        }
      }
    }, 3);
    this.nZW = kotlinx.coroutines.j.a(getScope(), null, null, (m)new kotlin.d.b.a.k(parama, null)
    {
      int label;
      
      public final kotlin.d.d<ah> create(Object paramAnonymousObject, kotlin.d.d<?> paramAnonymousd)
      {
        AppMethodBeat.i(260492);
        paramAnonymousObject = (kotlin.d.d)new 2(this.xfN, parama, paramAnonymousd);
        AppMethodBeat.o(260492);
        return paramAnonymousObject;
      }
      
      public final Object invokeSuspend(Object paramAnonymousObject)
      {
        AppMethodBeat.i(260485);
        kotlin.d.a.a locala = kotlin.d.a.a.aiwj;
        switch (this.label)
        {
        default: 
          paramAnonymousObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
          AppMethodBeat.o(260485);
          throw paramAnonymousObject;
        case 0: 
          ResultKt.throwOnFailure(paramAnonymousObject);
          paramAnonymousObject = this.xfN.getScope().getCoroutineContext();
          m localm = (m)new kotlin.d.b.a.k(this.xfN, parama)
          {
            int label;
            
            public final kotlin.d.d<ah> create(Object paramAnonymous2Object, kotlin.d.d<?> paramAnonymous2d)
            {
              AppMethodBeat.i(260449);
              paramAnonymous2Object = (kotlin.d.d)new 1(this.xfN, this.xfO, paramAnonymous2d);
              AppMethodBeat.o(260449);
              return paramAnonymous2Object;
            }
            
            public final Object invokeSuspend(Object paramAnonymous2Object)
            {
              AppMethodBeat.i(260444);
              kotlin.d.a.a locala = kotlin.d.a.a.aiwj;
              switch (this.label)
              {
              default: 
                paramAnonymous2Object = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                AppMethodBeat.o(260444);
                throw paramAnonymous2Object;
              }
              ResultKt.throwOnFailure(paramAnonymous2Object);
              this.xfN.a((b)this.xfO.invoke());
              paramAnonymous2Object = ah.aiuX;
              AppMethodBeat.o(260444);
              return paramAnonymous2Object;
            }
          };
          kotlin.d.d locald = (kotlin.d.d)this;
          this.label = 1;
          if (l.a(paramAnonymousObject, localm, locald) == locala)
          {
            AppMethodBeat.o(260485);
            return locala;
          }
          break;
        case 1: 
          ResultKt.throwOnFailure(paramAnonymousObject);
        }
        this.xfN.nZW = null;
        paramAnonymousObject = ah.aiuX;
        AppMethodBeat.o(260485);
        return paramAnonymousObject;
      }
    }, 3);
  }
  
  public Object X(kotlin.d.d<? super _value> paramd)
  {
    return a(this, paramd);
  }
  
  protected final Object Y(kotlin.d.d<? super ah> paramd)
  {
    Object localObject = this.nZW;
    if (localObject == null)
    {
      paramd = null;
      if (kotlin.d.a.a.aiwj != null) {}
    }
    else
    {
      do
      {
        return paramd;
        localObject = ((cb)localObject).ay(paramd);
        paramd = (kotlin.d.d<? super ah>)localObject;
      } while (localObject == kotlin.d.a.a.aiwj);
      return ah.aiuX;
    }
    return ah.aiuX;
  }
  
  protected final void a(T paramT)
  {
    s.u(paramT, "<set-?>");
    this.xfK = paramT;
  }
  
  protected final T dte()
  {
    b localb = this.xfK;
    if (localb != null) {
      return localb;
    }
    s.bIx("future");
    return null;
  }
  
  public final com.tencent.mm.plugin.datapreloader.a.b<_key, _value> dtf()
  {
    return (com.tencent.mm.plugin.datapreloader.a.b)this.mFt.getValue();
  }
  
  protected com.tencent.mm.plugin.datapreloader.a.b<_key, _value> dtg()
  {
    return (com.tencent.mm.plugin.datapreloader.a.b)new c(getKey());
  }
  
  public Object e(boolean paramBoolean, kotlin.d.d<? super _value> paramd)
  {
    return a(this, paramBoolean, paramd);
  }
  
  protected final _key getKey()
  {
    return this.xfL.getValue();
  }
  
  protected final aq getScope()
  {
    return (aq)this.xfM.getValue();
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "_key", "", "_value", "T", "Lcom/tencent/mm/plugin/datapreloader/IDataFuture;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends u
    implements kotlin.g.a.a<_key>
  {
    a(a<_key, _value, T> parama)
    {
      super();
    }
    
    public final _key invoke()
    {
      AppMethodBeat.i(260455);
      Object localObject = this.xfN.dte().getKey();
      AppMethodBeat.o(260455);
      return localObject;
    }
  }
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends kotlin.d.b.a.d
  {
    Object L$0;
    int label;
    
    b(a<_key, _value, T> parama, kotlin.d.d<? super b> paramd)
    {
      super();
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(260453);
      this.result = paramObject;
      this.label |= 0x80000000;
      paramObject = a.a(this.xfN, (kotlin.d.d)this);
      AppMethodBeat.o(260453);
      return paramObject;
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "_value", "_key", "", "T", "Lcom/tencent/mm/plugin/datapreloader/IDataFuture;", "Lkotlinx/coroutines/CoroutineScope;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends kotlin.d.b.a.k
    implements m<aq, kotlin.d.d<? super _value>, Object>
  {
    int label;
    
    c(a<_key, _value, T> parama, kotlin.d.d<? super c> paramd)
    {
      super(paramd);
    }
    
    public final kotlin.d.d<ah> create(Object paramObject, kotlin.d.d<?> paramd)
    {
      AppMethodBeat.i(260470);
      paramObject = (kotlin.d.d)new c(this.xfN, paramd);
      AppMethodBeat.o(260470);
      return paramObject;
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(260464);
      kotlin.d.a.a locala = kotlin.d.a.a.aiwj;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(260464);
        throw paramObject;
      case 0: 
        ResultKt.throwOnFailure(paramObject);
        paramObject = this.xfN;
        Object localObject = (kotlin.d.d)this;
        this.label = 1;
        localObject = paramObject.e(false, (kotlin.d.d)localObject);
        paramObject = localObject;
        if (localObject == locala)
        {
          AppMethodBeat.o(260464);
          return locala;
        }
        break;
      case 1: 
        ResultKt.throwOnFailure(paramObject);
      }
      this.xfN.dtf().nx(true);
      this.xfN.dtf().r(paramObject, cn.bDw());
      this.xfN.dtf().dtk();
      AppMethodBeat.o(260464);
      return paramObject;
    }
  }
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends kotlin.d.b.a.d
  {
    Object L$0;
    boolean YF;
    int label;
    
    d(a<_key, _value, T> parama, kotlin.d.d<? super d> paramd)
    {
      super();
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(260457);
      this.result = paramObject;
      this.label |= 0x80000000;
      paramObject = a.a(this.xfN, false, (kotlin.d.d)this);
      AppMethodBeat.o(260457);
      return paramObject;
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "_value", "_key", "", "T", "Lcom/tencent/mm/plugin/datapreloader/IDataFuture;", "Lkotlinx/coroutines/CoroutineScope;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class e
    extends kotlin.d.b.a.k
    implements m<aq, kotlin.d.d<? super _value>, Object>
  {
    int label;
    
    e(boolean paramBoolean, a<_key, _value, T> parama, kotlin.d.d<? super e> paramd)
    {
      super(paramd);
    }
    
    public final kotlin.d.d<ah> create(Object paramObject, kotlin.d.d<?> paramd)
    {
      AppMethodBeat.i(260462);
      paramObject = (kotlin.d.d)new e(this.xfP, this.xfN, paramd);
      AppMethodBeat.o(260462);
      return paramObject;
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(260452);
      kotlin.d.a.a locala = kotlin.d.a.a.aiwj;
      Object localObject;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(260452);
        throw paramObject;
      case 0: 
        ResultKt.throwOnFailure(paramObject);
        if (this.xfP)
        {
          paramObject = this.xfN.dtf();
          localObject = (kotlin.d.d)this;
          this.label = 1;
          localObject = paramObject.aa((kotlin.d.d)localObject);
          paramObject = localObject;
          if (localObject == locala)
          {
            AppMethodBeat.o(260452);
            return locala;
          }
        }
      case 1: 
        ResultKt.throwOnFailure(paramObject);
        if (paramObject == null) {
          paramObject = null;
        }
      case 2: 
        while (paramObject == null)
        {
          paramObject = this.xfN.dte();
          localObject = (kotlin.d.d)this;
          this.label = 2;
          localObject = paramObject.Z((kotlin.d.d)localObject);
          paramObject = localObject;
          if (localObject == locala)
          {
            AppMethodBeat.o(260452);
            return locala;
            localObject = this.xfN;
            ((a)localObject).dtf().nx(false);
            ((a)localObject).dte().ez(paramObject);
            continue;
            ResultKt.throwOnFailure(paramObject);
          }
          else
          {
            AppMethodBeat.o(260452);
            return paramObject;
          }
        }
        AppMethodBeat.o(260452);
        return paramObject;
        paramObject = this.xfN.dte();
        localObject = (kotlin.d.d)this;
        this.label = 3;
        localObject = paramObject.Z((kotlin.d.d)localObject);
        paramObject = localObject;
        if (localObject != locala) {
          break label253;
        }
        AppMethodBeat.o(260452);
        return locala;
      }
      ResultKt.throwOnFailure(paramObject);
      label253:
      AppMethodBeat.o(260452);
      return paramObject;
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lkotlinx/coroutines/CoroutineScope;", "_key", "", "_value", "T", "Lcom/tencent/mm/plugin/datapreloader/IDataFuture;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class f
    extends u
    implements kotlin.g.a.a<aq>
  {
    f(cb paramcb, al paramal)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/plugin/datapreloader/cache/IDataCache;", "_key", "_value", "", "T", "Lcom/tencent/mm/plugin/datapreloader/IDataFuture;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class g
    extends u
    implements kotlin.g.a.a<com.tencent.mm.plugin.datapreloader.a.b<_key, _value>>
  {
    g(a<_key, _value, T> parama)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.datapreloader.a
 * JD-Core Version:    0.7.0.1
 */