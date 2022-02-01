package com.tencent.mm.plugin.eggspring;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.ResultKt;
import kotlin.d.d;
import kotlin.g.a.m;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;
import kotlinx.coroutines.ak;
import kotlinx.coroutines.al;
import kotlinx.coroutines.by;
import kotlinx.coroutines.cy;
import kotlinx.coroutines.da;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/eggspring/EggRedEnvelopeHelper;", "", "()V", "TAG", "", "callback", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "showEgg", "url", "", "getCallback", "()Lkotlin/jvm/functions/Function2;", "setCallback", "(Lkotlin/jvm/functions/Function2;)V", "interval", "", "lastCheckJob", "Lkotlinx/coroutines/Job;", "lastCheckTime", "", "scope", "Lkotlinx/coroutines/CoroutineScope;", "checkShowEgg", "dispose", "plugin-eggspring_release"})
public final class c
{
  public final String TAG;
  public int interval;
  public m<? super Boolean, ? super String, x> jHk;
  public long lastCheckTime;
  public ak rcY;
  public by uwI;
  
  public c()
  {
    AppMethodBeat.i(249410);
    this.TAG = "MicroMsg.EggRedEnvelopeHelper";
    this.rcY = al.iRe();
    AppMethodBeat.o(249410);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"})
  public static final class a
    extends kotlin.d.b.a.j
    implements m<ak, d<? super x>, Object>
  {
    Object L$0;
    int label;
    private ak p$;
    
    public a(c paramc, d paramd)
    {
      super(paramd);
    }
    
    public final d<x> create(Object paramObject, d<?> paramd)
    {
      AppMethodBeat.i(249280);
      p.k(paramd, "completion");
      paramd = new a(this.uwJ, paramd);
      paramd.p$ = ((ak)paramObject);
      AppMethodBeat.o(249280);
      return paramd;
    }
    
    public final Object invoke(Object paramObject1, Object paramObject2)
    {
      AppMethodBeat.i(249281);
      paramObject1 = ((a)create(paramObject1, (d)paramObject2)).invokeSuspend(x.aazN);
      AppMethodBeat.o(249281);
      return paramObject1;
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(249276);
      Object localObject2 = kotlin.d.a.a.aaAA;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(249276);
        throw paramObject;
      case 0: 
        ResultKt.throwOnFailure(paramObject);
        paramObject = this.p$;
      }
      try
      {
        Object localObject1 = (m)new a(null);
        this.L$0 = paramObject;
        this.label = 1;
        paramObject = da.a(10000L, (m)localObject1, this);
        localObject1 = paramObject;
        if (paramObject == localObject2)
        {
          AppMethodBeat.o(249276);
          return localObject2;
          ResultKt.throwOnFailure(paramObject);
          localObject1 = paramObject;
        }
        localObject2 = (com.tencent.mm.t.a.j)localObject1;
        this.uwJ.interval = (((com.tencent.mm.t.a.j)localObject2).jDQ * 1000);
        Log.i(this.uwJ.TAG, "checkShowEgg: " + ((com.tencent.mm.t.a.j)localObject2).show_entrance + ", " + ((com.tencent.mm.t.a.j)localObject2).jDP + ", " + ((com.tencent.mm.t.a.j)localObject2).jDQ);
        if ((((com.tencent.mm.t.a.j)localObject2).show_entrance) && (((com.tencent.mm.t.a.j)localObject2).jDP != null))
        {
          paramObject = this.uwJ.jHk;
          if (paramObject != null)
          {
            localObject1 = Boolean.TRUE;
            localObject2 = ((com.tencent.mm.t.a.j)localObject2).jDP;
            p.j(localObject2, "resp.entrance_url");
            paramObject.invoke(localObject1, localObject2);
          }
        }
      }
      catch (a paramObject)
      {
        for (;;)
        {
          Log.w(this.uwJ.TAG, "Cgi error: " + paramObject.getMessage());
        }
      }
      catch (cy paramObject)
      {
        for (;;)
        {
          Log.w(this.uwJ.TAG, "Cgi Timeout: ");
        }
      }
      paramObject = x.aazN;
      AppMethodBeat.o(249276);
      return paramObject;
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Lcom/tencent/mm/eggspring/model/GetRedpacketCoverRecvEntranceResp;", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"})
    static final class a
      extends kotlin.d.b.a.j
      implements m<ak, d<? super com.tencent.mm.t.a.j>, Object>
    {
      Object L$0;
      int label;
      private ak p$;
      
      a(d paramd)
      {
        super(paramd);
      }
      
      public final d<x> create(Object paramObject, d<?> paramd)
      {
        AppMethodBeat.i(249415);
        p.k(paramd, "completion");
        paramd = new a(paramd);
        paramd.p$ = ((ak)paramObject);
        AppMethodBeat.o(249415);
        return paramd;
      }
      
      public final Object invoke(Object paramObject1, Object paramObject2)
      {
        AppMethodBeat.i(249416);
        paramObject1 = ((a)create(paramObject1, (d)paramObject2)).invokeSuspend(x.aazN);
        AppMethodBeat.o(249416);
        return paramObject1;
      }
      
      public final Object invokeSuspend(Object paramObject)
      {
        AppMethodBeat.i(249414);
        kotlin.d.a.a locala = kotlin.d.a.a.aaAA;
        switch (this.label)
        {
        default: 
          paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
          AppMethodBeat.o(249414);
          throw paramObject;
        case 0: 
          ResultKt.throwOnFailure(paramObject);
          paramObject = this.p$;
          Object localObject = (com.tencent.mm.an.c)new com.tencent.mm.plugin.eggspring.b.b();
          this.L$0 = paramObject;
          this.label = 1;
          localObject = b.a((com.tencent.mm.an.c)localObject, this);
          paramObject = localObject;
          if (localObject == locala)
          {
            AppMethodBeat.o(249414);
            return locala;
          }
          break;
        case 1: 
          ResultKt.throwOnFailure(paramObject);
        }
        AppMethodBeat.o(249414);
        return paramObject;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.eggspring.c
 * JD-Core Version:    0.7.0.1
 */