package com.tencent.mm.plugin.eggspring;

import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.ResultKt;
import kotlin.d.b.a.j;
import kotlin.g.a.m;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;
import kotlinx.coroutines.ai;
import kotlinx.coroutines.aj;
import kotlinx.coroutines.bu;
import kotlinx.coroutines.cs;
import kotlinx.coroutines.cu;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/eggspring/SpringLuckyEggHelper;", "", "()V", "interval", "", "lastCheckJob", "Lkotlinx/coroutines/Job;", "lastCheckTime", "", "playCallback", "Lkotlin/Function1;", "Lcom/tencent/mm/plugin/eggspring/model/LuckyBagInfo;", "", "getPlayCallback", "()Lkotlin/jvm/functions/Function1;", "setPlayCallback", "(Lkotlin/jvm/functions/Function1;)V", "scope", "Lkotlinx/coroutines/CoroutineScope;", "checkCanShowEgg", "appId", "", "keyword", "dispose", "Companion", "plugin-eggspring_release"})
public final class d
{
  public static final d.a qUU;
  private int gTn;
  private long lastCheckTime;
  private ai qUR;
  public bu qUS;
  public kotlin.g.a.b<? super com.tencent.mm.plugin.eggspring.c.c, x> qUT;
  
  static
  {
    AppMethodBeat.i(194563);
    qUU = new d.a((byte)0);
    AppMethodBeat.o(194563);
  }
  
  public d()
  {
    AppMethodBeat.i(194562);
    this.qUR = aj.hMI();
    AppMethodBeat.o(194562);
  }
  
  public final void fM(final String paramString1, final String paramString2)
  {
    AppMethodBeat.i(194561);
    p.h(paramString2, "keyword");
    Log.i("MicroMsg.SpringLuckyEggHelper", "start check egg: appId=" + paramString1 + ", keyword=" + paramString2);
    long l1 = SystemClock.elapsedRealtime();
    if ((this.lastCheckTime > 0L) && (this.gTn > 0))
    {
      long l2 = l1 - this.lastCheckTime;
      if (l2 < this.gTn * 1000)
      {
        Log.w("MicroMsg.SpringLuckyEggHelper", "The check is too frequent, interval=" + this.gTn + ", delta=" + l2);
        AppMethodBeat.o(194561);
        return;
      }
    }
    this.lastCheckTime = l1;
    bu localbu = this.qUS;
    if (localbu != null) {
      localbu.a(null);
    }
    this.qUS = kotlinx.coroutines.f.b(this.qUR, null, (m)new b(this, paramString2, paramString1, null), 3);
    AppMethodBeat.o(194561);
  }
  
  @kotlin.d.b.a.f(c="com.tencent.mm.plugin.eggspring.SpringLuckyEggHelper$checkCanShowEgg$1", f="SpringLuckyEggHelper.kt", hxM={41}, m="invokeSuspend")
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"})
  static final class b
    extends j
    implements m<ai, kotlin.d.d<? super x>, Object>
  {
    Object L$0;
    int label;
    private ai p$;
    
    b(d paramd, String paramString1, String paramString2, kotlin.d.d paramd1)
    {
      super(paramd1);
    }
    
    public final kotlin.d.d<x> create(Object paramObject, kotlin.d.d<?> paramd)
    {
      AppMethodBeat.i(194559);
      p.h(paramd, "completion");
      paramd = new b(this.qUV, paramString2, paramString1, paramd);
      paramd.p$ = ((ai)paramObject);
      AppMethodBeat.o(194559);
      return paramd;
    }
    
    public final Object invoke(Object paramObject1, Object paramObject2)
    {
      AppMethodBeat.i(194560);
      paramObject1 = ((b)create(paramObject1, (kotlin.d.d)paramObject2)).invokeSuspend(x.SXb);
      AppMethodBeat.o(194560);
      return paramObject1;
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(194558);
      Object localObject2 = kotlin.d.a.a.SXO;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(194558);
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
        paramObject = cu.a(10000L, (m)localObject1, this);
        localObject1 = paramObject;
        if (paramObject == localObject2)
        {
          AppMethodBeat.o(194558);
          return localObject2;
          ResultKt.throwOnFailure(paramObject);
          localObject1 = paramObject;
        }
        paramObject = (com.tencent.mm.t.a.d)localObject1;
        d.a(this.qUV, paramObject.gTn);
        Log.i("MicroMsg.SpringLuckyEggHelper", "should play lucky egg:" + paramObject.gTm + " interval=" + d.a(this.qUV) + ", traceId=" + paramObject.gTl);
        if (paramObject.gTm == 1)
        {
          localObject1 = this.qUV.qUT;
          if (localObject1 != null)
          {
            localObject2 = paramString1;
            ((kotlin.g.a.b)localObject1).invoke(new com.tencent.mm.plugin.eggspring.c.c(paramString2, paramObject.gTl, (String)localObject2, paramObject.gTn));
          }
        }
        this.qUV.qUT = null;
        paramObject = x.SXb;
        AppMethodBeat.o(194558);
        return paramObject;
      }
      catch (a paramObject)
      {
        Log.w("MicroMsg.SpringLuckyEggHelper", "Unable to check if we can show lucky egg: " + paramObject.getMessage());
        paramObject = x.SXb;
        return paramObject;
      }
      catch (cs paramObject)
      {
        Log.w("MicroMsg.SpringLuckyEggHelper", "Timeout to check can show luck egg");
        paramObject = x.SXb;
        return paramObject;
      }
      finally
      {
        this.qUV.qUT = null;
        AppMethodBeat.o(194558);
      }
    }
    
    @kotlin.d.b.a.f(c="com.tencent.mm.plugin.eggspring.SpringLuckyEggHelper$checkCanShowEgg$1$resp$1", f="SpringLuckyEggHelper.kt", hxM={42}, m="invokeSuspend")
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Lcom/tencent/mm/eggspring/model/GetInteractionADResp;", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"})
    static final class a
      extends j
      implements m<ai, kotlin.d.d<? super com.tencent.mm.t.a.d>, Object>
    {
      Object L$0;
      int label;
      private ai p$;
      
      a(d.b paramb, kotlin.d.d paramd)
      {
        super(paramd);
      }
      
      public final kotlin.d.d<x> create(Object paramObject, kotlin.d.d<?> paramd)
      {
        AppMethodBeat.i(194556);
        p.h(paramd, "completion");
        paramd = new a(this.qUX, paramd);
        paramd.p$ = ((ai)paramObject);
        AppMethodBeat.o(194556);
        return paramd;
      }
      
      public final Object invoke(Object paramObject1, Object paramObject2)
      {
        AppMethodBeat.i(194557);
        paramObject1 = ((a)create(paramObject1, (kotlin.d.d)paramObject2)).invokeSuspend(x.SXb);
        AppMethodBeat.o(194557);
        return paramObject1;
      }
      
      public final Object invokeSuspend(Object paramObject)
      {
        AppMethodBeat.i(194555);
        kotlin.d.a.a locala = kotlin.d.a.a.SXO;
        switch (this.label)
        {
        default: 
          paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
          AppMethodBeat.o(194555);
          throw paramObject;
        case 0: 
          ResultKt.throwOnFailure(paramObject);
          paramObject = this.p$;
          Object localObject = (com.tencent.mm.ak.c)new com.tencent.mm.plugin.eggspring.b.b(this.qUX.qUW, "");
          this.L$0 = paramObject;
          this.label = 1;
          localObject = b.a((com.tencent.mm.ak.c)localObject, this);
          paramObject = localObject;
          if (localObject == locala)
          {
            AppMethodBeat.o(194555);
            return locala;
          }
          break;
        case 1: 
          ResultKt.throwOnFailure(paramObject);
        }
        AppMethodBeat.o(194555);
        return paramObject;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.eggspring.d
 * JD-Core Version:    0.7.0.1
 */