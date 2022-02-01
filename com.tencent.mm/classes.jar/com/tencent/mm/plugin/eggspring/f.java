package com.tencent.mm.plugin.eggspring;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.ResultKt;
import kotlin.d.b.a.j;
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

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/eggspring/SpringLuckyEggHelper;", "", "()V", "interval", "", "lastCheckJob", "Lkotlinx/coroutines/Job;", "lastCheckTime", "", "playCallback", "Lkotlin/Function1;", "Lcom/tencent/mm/plugin/eggspring/model/LuckyBagInfo;", "", "getPlayCallback", "()Lkotlin/jvm/functions/Function1;", "setPlayCallback", "(Lkotlin/jvm/functions/Function1;)V", "scope", "Lkotlinx/coroutines/CoroutineScope;", "checkCanShowEgg", "appId", "", "keyword", "dispose", "Companion", "plugin-eggspring_release"})
public final class f
{
  public static final a uxH;
  public int interval;
  public long lastCheckTime;
  public ak rcY;
  public by uwI;
  public kotlin.g.a.b<? super com.tencent.mm.plugin.eggspring.c.c, x> uxG;
  
  static
  {
    AppMethodBeat.i(249653);
    uxH = new a((byte)0);
    AppMethodBeat.o(249653);
  }
  
  public f()
  {
    AppMethodBeat.i(249650);
    this.rcY = al.iRe();
    AppMethodBeat.o(249650);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/eggspring/SpringLuckyEggHelper$Companion;", "", "()V", "TAG", "", "plugin-eggspring_release"})
  public static final class a {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"})
  public static final class b
    extends j
    implements m<ak, d<? super x>, Object>
  {
    Object L$0;
    int label;
    private ak p$;
    
    public b(f paramf, String paramString1, String paramString2, d paramd)
    {
      super(paramd);
    }
    
    public final d<x> create(Object paramObject, d<?> paramd)
    {
      AppMethodBeat.i(249286);
      p.k(paramd, "completion");
      paramd = new b(this.uxI, this.uxJ, this.cBD, paramd);
      paramd.p$ = ((ak)paramObject);
      AppMethodBeat.o(249286);
      return paramd;
    }
    
    public final Object invoke(Object paramObject1, Object paramObject2)
    {
      AppMethodBeat.i(249287);
      paramObject1 = ((b)create(paramObject1, (d)paramObject2)).invokeSuspend(x.aazN);
      AppMethodBeat.o(249287);
      return paramObject1;
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(249285);
      Object localObject2 = kotlin.d.a.a.aaAA;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(249285);
        throw paramObject;
      case 0: 
        ResultKt.throwOnFailure(paramObject);
        paramObject = this.p$;
      }
      try
      {
        Object localObject1 = (m)new a(this, null);
        this.L$0 = paramObject;
        this.label = 1;
        paramObject = da.a(10000L, (m)localObject1, this);
        localObject1 = paramObject;
        if (paramObject == localObject2)
        {
          AppMethodBeat.o(249285);
          return localObject2;
          ResultKt.throwOnFailure(paramObject);
          localObject1 = paramObject;
        }
        paramObject = (com.tencent.mm.t.a.f)localObject1;
        f.a(this.uxI, paramObject.interval);
        Log.i("MicroMsg.SpringLuckyEggHelper", "should play lucky egg:" + paramObject.jDN + " interval=" + f.a(this.uxI) + ", traceId=" + paramObject.jDM);
        if (paramObject.jDN == 1)
        {
          localObject1 = this.uxI.uxG;
          if (localObject1 != null)
          {
            localObject2 = this.cBD;
            ((kotlin.g.a.b)localObject1).invoke(new com.tencent.mm.plugin.eggspring.c.c(this.uxJ, paramObject.jDM, (String)localObject2, true, paramObject.interval, 32));
          }
        }
        this.uxI.uxG = null;
        paramObject = x.aazN;
        AppMethodBeat.o(249285);
        return paramObject;
      }
      catch (a paramObject)
      {
        Log.w("MicroMsg.SpringLuckyEggHelper", "Unable to check if we can show lucky egg: " + paramObject.getMessage());
        paramObject = x.aazN;
        return paramObject;
      }
      catch (cy paramObject)
      {
        Log.w("MicroMsg.SpringLuckyEggHelper", "Timeout to check can show luck egg");
        paramObject = x.aazN;
        return paramObject;
      }
      finally
      {
        this.uxI.uxG = null;
        AppMethodBeat.o(249285);
      }
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Lcom/tencent/mm/eggspring/model/GetInteractionADResp;", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"})
    static final class a
      extends j
      implements m<ak, d<? super com.tencent.mm.t.a.f>, Object>
    {
      Object L$0;
      int label;
      private ak p$;
      
      a(f.b paramb, d paramd)
      {
        super(paramd);
      }
      
      public final d<x> create(Object paramObject, d<?> paramd)
      {
        AppMethodBeat.i(249312);
        p.k(paramd, "completion");
        paramd = new a(this.uxK, paramd);
        paramd.p$ = ((ak)paramObject);
        AppMethodBeat.o(249312);
        return paramd;
      }
      
      public final Object invoke(Object paramObject1, Object paramObject2)
      {
        AppMethodBeat.i(249313);
        paramObject1 = ((a)create(paramObject1, (d)paramObject2)).invokeSuspend(x.aazN);
        AppMethodBeat.o(249313);
        return paramObject1;
      }
      
      public final Object invokeSuspend(Object paramObject)
      {
        AppMethodBeat.i(249311);
        kotlin.d.a.a locala = kotlin.d.a.a.aaAA;
        switch (this.label)
        {
        default: 
          paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
          AppMethodBeat.o(249311);
          throw paramObject;
        case 0: 
          ResultKt.throwOnFailure(paramObject);
          paramObject = this.p$;
          Object localObject = (com.tencent.mm.an.c)new com.tencent.mm.plugin.eggspring.b.c(this.uxK.uxJ, "");
          this.L$0 = paramObject;
          this.label = 1;
          localObject = b.a((com.tencent.mm.an.c)localObject, this);
          paramObject = localObject;
          if (localObject == locala)
          {
            AppMethodBeat.o(249311);
            return locala;
          }
          break;
        case 1: 
          ResultKt.throwOnFailure(paramObject);
        }
        AppMethodBeat.o(249311);
        return paramObject;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.eggspring.f
 * JD-Core Version:    0.7.0.1
 */