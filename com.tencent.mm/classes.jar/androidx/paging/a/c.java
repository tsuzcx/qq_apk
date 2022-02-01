package androidx.paging.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.ah;
import kotlin.d.d<-Lkotlin.ah;>;
import kotlin.g.a.m;
import kotlin.g.b.q;
import kotlin.g.b.s;
import kotlinx.coroutines.a.ab;
import kotlinx.coroutines.aq;
import kotlinx.coroutines.cb;
import kotlinx.coroutines.z;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Landroidx/paging/multicast/ChannelManager;", "T", "", "scope", "Lkotlinx/coroutines/CoroutineScope;", "bufferSize", "", "piggybackingDownstream", "", "onEach", "Lkotlin/Function2;", "Lkotlin/coroutines/Continuation;", "", "keepUpstreamAlive", "upstream", "Lkotlinx/coroutines/flow/Flow;", "(Lkotlinx/coroutines/CoroutineScope;IZLkotlin/jvm/functions/Function2;ZLkotlinx/coroutines/flow/Flow;)V", "actor", "Landroidx/paging/multicast/ChannelManager$Actor;", "Lkotlin/jvm/functions/Function2;", "addDownstream", "channel", "Lkotlinx/coroutines/channels/SendChannel;", "Landroidx/paging/multicast/ChannelManager$Message$Dispatch$Value;", "(Lkotlinx/coroutines/channels/SendChannel;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "close", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "removeDownstream", "Actor", "ChannelEntry", "Message", "paging-common"}, k=1, mv={1, 4, 2})
public final class c<T>
{
  public final c<T>.a bSa;
  final boolean bSb;
  final m<T, kotlin.d.d<? super ah>, Object> bSc;
  final boolean bSd;
  final kotlinx.coroutines.b.g<T> bSe;
  final int bufferSize;
  final aq scope;
  
  public c(aq paramaq, int paramInt, boolean paramBoolean1, m<? super T, ? super kotlin.d.d<? super ah>, ? extends Object> paramm, boolean paramBoolean2, kotlinx.coroutines.b.g<? extends T> paramg)
  {
    AppMethodBeat.i(197137);
    this.scope = paramaq;
    this.bufferSize = paramInt;
    this.bSb = paramBoolean1;
    this.bSc = paramm;
    this.bSd = paramBoolean2;
    this.bSe = paramg;
    this.bSa = new a();
    AppMethodBeat.o(197137);
  }
  
  @Metadata(bv={1, 0, 3}, d1={""}, d2={"Landroidx/paging/multicast/ChannelManager$Actor;", "Landroidx/paging/multicast/StoreRealActor;", "Landroidx/paging/multicast/ChannelManager$Message;", "(Landroidx/paging/multicast/ChannelManager;)V", "buffer", "Landroidx/paging/multicast/Buffer;", "channels", "", "Landroidx/paging/multicast/ChannelManager$ChannelEntry;", "dispatchedValue", "", "lastDeliveryAck", "Lkotlinx/coroutines/CompletableDeferred;", "", "producer", "Landroidx/paging/multicast/SharedFlowProducer;", "activateIfNecessary", "addEntry", "entry", "(Landroidx/paging/multicast/ChannelManager$ChannelEntry;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "doAdd", "msg", "Landroidx/paging/multicast/ChannelManager$Message$AddChannel;", "(Landroidx/paging/multicast/ChannelManager$Message$AddChannel;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "doDispatchError", "Landroidx/paging/multicast/ChannelManager$Message$Dispatch$Error;", "doDispatchValue", "Landroidx/paging/multicast/ChannelManager$Message$Dispatch$Value;", "(Landroidx/paging/multicast/ChannelManager$Message$Dispatch$Value;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "doHandleUpstreamClose", "doRemove", "channel", "Lkotlinx/coroutines/channels/SendChannel;", "(Lkotlinx/coroutines/channels/SendChannel;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "handle", "(Landroidx/paging/multicast/ChannelManager$Message;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "newProducer", "onClosed", "paging-common"}, k=1, mv={1, 4, 2})
  public final class a
    extends g<c.c<T>>
  {
    private final a<T> bSf;
    private f<T> bSg;
    private boolean bSh;
    private z<ah> bSi;
    private final List<c.b<T>> bSj;
    
    public a()
    {
      super();
      AppMethodBeat.i(197157);
      int i = this$1.bufferSize;
      if (i > 0) {}
      for (this$1 = (a)new b(i);; this$1 = (a)new e())
      {
        this.bSf = this$1;
        this.bSj = ((List)new ArrayList());
        AppMethodBeat.o(197157);
        return;
      }
    }
    
    private final f<T> Io()
    {
      AppMethodBeat.i(197142);
      f localf = new f(this.bSk.scope, this.bSk.bSe, (m)new f((a)this));
      AppMethodBeat.o(197142);
      return localf;
    }
    
    private final void Iq()
    {
      AppMethodBeat.i(197149);
      if (this.bSg == null)
      {
        this.bSg = Io();
        this.bSh = false;
        f localf = this.bSg;
        s.checkNotNull(localf);
        localf.start();
      }
      AppMethodBeat.o(197149);
    }
    
    public final void Ip()
    {
      AppMethodBeat.i(197191);
      Object localObject = ((Iterable)this.bSj).iterator();
      while (((Iterator)localObject).hasNext()) {
        ((c.b)((Iterator)localObject).next()).close();
      }
      this.bSj.clear();
      localObject = this.bSg;
      if (localObject != null)
      {
        ((f)localObject).bSx.a(null);
        AppMethodBeat.o(197191);
        return;
      }
      AppMethodBeat.o(197191);
    }
    
    public final Object a(c.c<T> paramc, kotlin.d.d<? super ah> paramd)
    {
      AppMethodBeat.i(197179);
      Object localObject1;
      if ((paramd instanceof e))
      {
        localObject1 = (e)paramd;
        if ((((e)localObject1).label & 0x80000000) != 0) {
          ((e)localObject1).label += -2147483648;
        }
      }
      Object localObject2;
      for (paramd = (kotlin.d.d<? super ah>)localObject1;; paramd = new e(this, paramd))
      {
        localObject2 = paramd.result;
        localObject1 = kotlin.d.a.a.aiwj;
        switch (paramd.label)
        {
        default: 
          paramc = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
          AppMethodBeat.o(197179);
          throw paramc;
        }
      }
      ResultKt.throwOnFailure(localObject2);
      if ((paramc instanceof c.c.a))
      {
        paramc = (c.c.a)paramc;
        paramd.label = 1;
        if (a(paramc, paramd) == localObject1)
        {
          AppMethodBeat.o(197179);
          return localObject1;
          ResultKt.throwOnFailure(localObject2);
        }
      }
      label599:
      for (;;)
      {
        paramc = ah.aiuX;
        AppMethodBeat.o(197179);
        return paramc;
        if ((paramc instanceof c.c.c))
        {
          paramc = ((c.c.c)paramc).bLy;
          paramd.label = 2;
          if (a(paramc, paramd) == localObject1)
          {
            AppMethodBeat.o(197179);
            return localObject1;
            ResultKt.throwOnFailure(localObject2);
          }
        }
        else if ((paramc instanceof c.c.b.c))
        {
          paramc = (c.c.b.c)paramc;
          paramd.label = 3;
          if (a(paramc, paramd) == localObject1)
          {
            AppMethodBeat.o(197179);
            return localObject1;
            ResultKt.throwOnFailure(localObject2);
          }
        }
        else if ((paramc instanceof c.c.b.a))
        {
          paramc = (c.c.b.a)paramc;
          this.bSh = true;
          paramd = ((Iterable)this.bSj).iterator();
          while (paramd.hasNext())
          {
            localObject1 = (c.b)paramd.next();
            localObject2 = paramc.bSn;
            s.u(localObject2, "error");
            ((c.b)localObject1).bSm = true;
            ((c.b)localObject1).bLy.k((Throwable)localObject2);
          }
        }
        else if ((paramc instanceof c.c.b.b))
        {
          paramc = ((c.c.b.b)paramc).bSg;
          if (this.bSg == paramc)
          {
            paramc = (List)new ArrayList();
            paramd = (List)new ArrayList();
            localObject1 = ((Iterable)this.bSj).iterator();
            while (((Iterator)localObject1).hasNext())
            {
              localObject2 = (c.b)((Iterator)localObject1).next();
              if (((c.b)localObject2).bSm)
              {
                if (!this.bSk.bSb) {
                  ((c.b)localObject2).close();
                } else {
                  paramc.add(localObject2);
                }
              }
              else if (this.bSh) {
                paramd.add(localObject2);
              } else if (!this.bSk.bSb) {
                ((c.b)localObject2).close();
              } else {
                paramc.add(localObject2);
              }
            }
            this.bSj.clear();
            this.bSj.addAll((Collection)paramd);
            this.bSj.addAll((Collection)paramc);
            this.bSg = null;
            if (!((Collection)paramd).isEmpty()) {}
            for (int i = 1;; i = 0)
            {
              if (i == 0) {
                break label599;
              }
              Iq();
              break;
            }
          }
        }
      }
    }
    
    @Metadata(bv={1, 0, 3}, d1={""}, d2={"addEntry", "", "T", "entry", "Landroidx/paging/multicast/ChannelManager$ChannelEntry;", "continuation", "Lkotlin/coroutines/Continuation;", ""}, k=3, mv={1, 4, 2})
    static final class a
      extends kotlin.d.b.a.d
    {
      Object L$0;
      Object Uf;
      int label;
      
      a(c.a parama, kotlin.d.d paramd)
      {
        super();
      }
      
      public final Object invokeSuspend(Object paramObject)
      {
        AppMethodBeat.i(197139);
        this.result = paramObject;
        this.label |= 0x80000000;
        paramObject = this.bSl.a(null, this);
        AppMethodBeat.o(197139);
        return paramObject;
      }
    }
    
    @Metadata(bv={1, 0, 3}, d1={""}, d2={"doAdd", "", "T", "msg", "Landroidx/paging/multicast/ChannelManager$Message$AddChannel;", "continuation", "Lkotlin/coroutines/Continuation;", ""}, k=3, mv={1, 4, 2})
    static final class b
      extends kotlin.d.b.a.d
    {
      Object L$0;
      int label;
      
      b(c.a parama, kotlin.d.d paramd)
      {
        super();
      }
      
      public final Object invokeSuspend(Object paramObject)
      {
        AppMethodBeat.i(197124);
        this.result = paramObject;
        this.label |= 0x80000000;
        paramObject = this.bSl.a(null, this);
        AppMethodBeat.o(197124);
        return paramObject;
      }
    }
    
    @Metadata(bv={1, 0, 3}, d1={""}, d2={"doDispatchValue", "", "T", "msg", "Landroidx/paging/multicast/ChannelManager$Message$Dispatch$Value;", "continuation", "Lkotlin/coroutines/Continuation;", ""}, k=3, mv={1, 4, 2})
    static final class c
      extends kotlin.d.b.a.d
    {
      Object L$0;
      Object Uf;
      int label;
      
      c(c.a parama, kotlin.d.d paramd)
      {
        super();
      }
      
      public final Object invokeSuspend(Object paramObject)
      {
        AppMethodBeat.i(197130);
        this.result = paramObject;
        this.label |= 0x80000000;
        paramObject = this.bSl.a(null, this);
        AppMethodBeat.o(197130);
        return paramObject;
      }
    }
    
    @Metadata(bv={1, 0, 3}, d1={""}, d2={"doRemove", "", "T", "channel", "Lkotlinx/coroutines/channels/SendChannel;", "Landroidx/paging/multicast/ChannelManager$Message$Dispatch$Value;", "continuation", "Lkotlin/coroutines/Continuation;", ""}, k=3, mv={1, 4, 2})
    static final class d
      extends kotlin.d.b.a.d
    {
      int label;
      
      d(c.a parama, kotlin.d.d paramd)
      {
        super();
      }
      
      public final Object invokeSuspend(Object paramObject)
      {
        AppMethodBeat.i(197118);
        this.result = paramObject;
        this.label |= 0x80000000;
        paramObject = this.bSl.a(null, this);
        AppMethodBeat.o(197118);
        return paramObject;
      }
    }
    
    @Metadata(bv={1, 0, 3}, d1={""}, d2={"handle", "", "T", "msg", "Landroidx/paging/multicast/ChannelManager$Message;", "continuation", "Lkotlin/coroutines/Continuation;", ""}, k=3, mv={1, 4, 2})
    static final class e
      extends kotlin.d.b.a.d
    {
      int label;
      
      e(c.a parama, kotlin.d.d paramd)
      {
        super();
      }
      
      public final Object invokeSuspend(Object paramObject)
      {
        AppMethodBeat.i(197116);
        this.result = paramObject;
        this.label |= 0x80000000;
        paramObject = this.bSl.a(null, this);
        AppMethodBeat.o(197116);
        return paramObject;
      }
    }
  }
  
  @Metadata(bv={1, 0, 3}, d1={""}, d2={"Landroidx/paging/multicast/ChannelManager$ChannelEntry;", "T", "", "channel", "Lkotlinx/coroutines/channels/SendChannel;", "Landroidx/paging/multicast/ChannelManager$Message$Dispatch$Value;", "_receivedValue", "", "(Lkotlinx/coroutines/channels/SendChannel;Z)V", "receivedValue", "getReceivedValue", "()Z", "close", "", "component1", "component2", "copy", "dispatchError", "error", "", "dispatchValue", "value", "(Landroidx/paging/multicast/ChannelManager$Message$Dispatch$Value;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "equals", "other", "hasChannel", "entry", "hashCode", "", "toString", "", "paging-common"}, k=1, mv={1, 4, 2})
  public static final class b<T>
  {
    final ab<c.c.b.c<T>> bLy;
    boolean bSm;
    
    private b(ab<? super c.c.b.c<T>> paramab)
    {
      AppMethodBeat.i(197128);
      this.bLy = paramab;
      this.bSm = false;
      AppMethodBeat.o(197128);
    }
    
    public final boolean a(b<T> paramb)
    {
      AppMethodBeat.i(197150);
      s.u(paramb, "entry");
      if (this.bLy == paramb.bLy)
      {
        AppMethodBeat.o(197150);
        return true;
      }
      AppMethodBeat.o(197150);
      return false;
    }
    
    public final boolean a(ab<? super c.c.b.c<T>> paramab)
    {
      AppMethodBeat.i(197145);
      s.u(paramab, "channel");
      if (this.bLy == paramab)
      {
        AppMethodBeat.o(197145);
        return true;
      }
      AppMethodBeat.o(197145);
      return false;
    }
    
    public final Object b(c.c.b.c<T> paramc, kotlin.d.d<? super ah> paramd)
    {
      AppMethodBeat.i(197135);
      this.bSm = true;
      paramc = this.bLy.b(paramc, paramd);
      if (paramc == kotlin.d.a.a.aiwj)
      {
        AppMethodBeat.o(197135);
        return paramc;
      }
      paramc = ah.aiuX;
      AppMethodBeat.o(197135);
      return paramc;
    }
    
    public final void close()
    {
      AppMethodBeat.i(197140);
      this.bLy.k(null);
      AppMethodBeat.o(197140);
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(197167);
      if (this != paramObject)
      {
        if ((paramObject instanceof b))
        {
          paramObject = (b)paramObject;
          if ((!s.p(this.bLy, paramObject.bLy)) || (this.bSm != paramObject.bSm)) {}
        }
      }
      else
      {
        AppMethodBeat.o(197167);
        return true;
      }
      AppMethodBeat.o(197167);
      return false;
    }
    
    public final int hashCode()
    {
      throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
    }
    
    public final String toString()
    {
      AppMethodBeat.i(197153);
      String str = "ChannelEntry(channel=" + this.bLy + ", _receivedValue=" + this.bSm + ")";
      AppMethodBeat.o(197153);
      return str;
    }
  }
  
  @Metadata(bv={1, 0, 3}, d1={""}, d2={"Landroidx/paging/multicast/ChannelManager$Message;", "T", "", "()V", "AddChannel", "Dispatch", "RemoveChannel", "Landroidx/paging/multicast/ChannelManager$Message$AddChannel;", "Landroidx/paging/multicast/ChannelManager$Message$RemoveChannel;", "Landroidx/paging/multicast/ChannelManager$Message$Dispatch;", "paging-common"}, k=1, mv={1, 4, 2})
  public static abstract class c<T>
  {
    @Metadata(bv={1, 0, 3}, d1={""}, d2={"Landroidx/paging/multicast/ChannelManager$Message$AddChannel;", "T", "Landroidx/paging/multicast/ChannelManager$Message;", "channel", "Lkotlinx/coroutines/channels/SendChannel;", "Landroidx/paging/multicast/ChannelManager$Message$Dispatch$Value;", "(Lkotlinx/coroutines/channels/SendChannel;)V", "getChannel", "()Lkotlinx/coroutines/channels/SendChannel;", "paging-common"}, k=1, mv={1, 4, 2})
    public static final class a<T>
      extends c.c<T>
    {
      final ab<c.c.b.c<T>> bLy;
      
      public a(ab<? super c.c.b.c<T>> paramab)
      {
        super();
        AppMethodBeat.i(197098);
        this.bLy = paramab;
        AppMethodBeat.o(197098);
      }
    }
    
    @Metadata(bv={1, 0, 3}, d1={""}, d2={"Landroidx/paging/multicast/ChannelManager$Message$Dispatch;", "T", "Landroidx/paging/multicast/ChannelManager$Message;", "()V", "Error", "UpstreamFinished", "Value", "Landroidx/paging/multicast/ChannelManager$Message$Dispatch$Value;", "Landroidx/paging/multicast/ChannelManager$Message$Dispatch$Error;", "Landroidx/paging/multicast/ChannelManager$Message$Dispatch$UpstreamFinished;", "paging-common"}, k=1, mv={1, 4, 2})
    public static abstract class b<T>
      extends c.c<T>
    {
      private b()
      {
        super();
      }
      
      @Metadata(bv={1, 0, 3}, d1={""}, d2={"Landroidx/paging/multicast/ChannelManager$Message$Dispatch$Error;", "T", "Landroidx/paging/multicast/ChannelManager$Message$Dispatch;", "error", "", "(Ljava/lang/Throwable;)V", "getError", "()Ljava/lang/Throwable;", "paging-common"}, k=1, mv={1, 4, 2})
      public static final class a<T>
        extends c.c.b<T>
      {
        final Throwable bSn;
        
        public a(Throwable paramThrowable)
        {
          super();
          AppMethodBeat.i(197133);
          this.bSn = paramThrowable;
          AppMethodBeat.o(197133);
        }
      }
      
      @Metadata(bv={1, 0, 3}, d1={""}, d2={"Landroidx/paging/multicast/ChannelManager$Message$Dispatch$UpstreamFinished;", "T", "Landroidx/paging/multicast/ChannelManager$Message$Dispatch;", "producer", "Landroidx/paging/multicast/SharedFlowProducer;", "(Landroidx/paging/multicast/SharedFlowProducer;)V", "getProducer", "()Landroidx/paging/multicast/SharedFlowProducer;", "paging-common"}, k=1, mv={1, 4, 2})
      public static final class b<T>
        extends c.c.b<T>
      {
        final f<T> bSg;
        
        public b(f<T> paramf)
        {
          super();
          AppMethodBeat.i(197146);
          this.bSg = paramf;
          AppMethodBeat.o(197146);
        }
      }
      
      @Metadata(bv={1, 0, 3}, d1={""}, d2={"Landroidx/paging/multicast/ChannelManager$Message$Dispatch$Value;", "T", "Landroidx/paging/multicast/ChannelManager$Message$Dispatch;", "value", "delivered", "Lkotlinx/coroutines/CompletableDeferred;", "", "(Ljava/lang/Object;Lkotlinx/coroutines/CompletableDeferred;)V", "getDelivered", "()Lkotlinx/coroutines/CompletableDeferred;", "getValue", "()Ljava/lang/Object;", "Ljava/lang/Object;", "paging-common"}, k=1, mv={1, 4, 2})
      public static final class c<T>
        extends c.c.b<T>
      {
        final z<ah> bSo;
        final T value;
        
        public c(T paramT, z<ah> paramz)
        {
          super();
          AppMethodBeat.i(197138);
          this.value = paramT;
          this.bSo = paramz;
          AppMethodBeat.o(197138);
        }
      }
    }
    
    @Metadata(bv={1, 0, 3}, d1={""}, d2={"Landroidx/paging/multicast/ChannelManager$Message$RemoveChannel;", "T", "Landroidx/paging/multicast/ChannelManager$Message;", "channel", "Lkotlinx/coroutines/channels/SendChannel;", "Landroidx/paging/multicast/ChannelManager$Message$Dispatch$Value;", "(Lkotlinx/coroutines/channels/SendChannel;)V", "getChannel", "()Lkotlinx/coroutines/channels/SendChannel;", "paging-common"}, k=1, mv={1, 4, 2})
    public static final class c<T>
      extends c.c<T>
    {
      final ab<c.c.b.c<T>> bLy;
      
      public c(ab<? super c.c.b.c<T>> paramab)
      {
        super();
        AppMethodBeat.i(197096);
        this.bLy = paramab;
        AppMethodBeat.o(197096);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.paging.a.c
 * JD-Core Version:    0.7.0.1
 */