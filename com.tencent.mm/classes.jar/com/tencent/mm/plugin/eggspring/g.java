package com.tencent.mm.plugin.eggspring;

import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.r.a.f;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.ah;
import kotlin.d.b.a.k;
import kotlin.d.d;
import kotlin.g.a.m;
import kotlin.g.b.s;
import kotlinx.coroutines.aq;
import kotlinx.coroutines.ar;
import kotlinx.coroutines.cb;
import kotlinx.coroutines.da;
import kotlinx.coroutines.dc;
import kotlinx.coroutines.j;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/eggspring/SpringLuckyEggHelper;", "", "()V", "interval", "", "lastCheckJob", "Lkotlinx/coroutines/Job;", "lastCheckTime", "", "playCallback", "Lkotlin/Function1;", "Lcom/tencent/mm/plugin/eggspring/model/LuckyBagInfo;", "", "getPlayCallback", "()Lkotlin/jvm/functions/Function1;", "setPlayCallback", "(Lkotlin/jvm/functions/Function1;)V", "scope", "Lkotlinx/coroutines/CoroutineScope;", "checkCanShowEgg", "appId", "", "keyword", "dispose", "Companion", "plugin-eggspring_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class g
{
  public static final a xEs;
  private int interval;
  private long lastCheckTime;
  private aq scope;
  public cb xDh;
  public kotlin.g.a.b<? super com.tencent.mm.plugin.eggspring.c.c, ah> xEt;
  
  static
  {
    AppMethodBeat.i(266528);
    xEs = new a((byte)0);
    AppMethodBeat.o(266528);
  }
  
  public g()
  {
    AppMethodBeat.i(266517);
    this.scope = ar.kBZ();
    AppMethodBeat.o(266517);
  }
  
  public final void gD(final String paramString1, final String paramString2)
  {
    AppMethodBeat.i(266535);
    s.u(paramString2, "keyword");
    Log.i("MicroMsg.SpringLuckyEggHelper", "start check egg: appId=" + paramString1 + ", keyword=" + paramString2);
    long l1 = SystemClock.elapsedRealtime();
    if ((this.lastCheckTime > 0L) && (this.interval > 0))
    {
      long l2 = l1 - this.lastCheckTime;
      if (l2 < this.interval * 1000)
      {
        Log.w("MicroMsg.SpringLuckyEggHelper", "The check is too frequent, interval=" + this.interval + ", delta=" + l2);
        AppMethodBeat.o(266535);
        return;
      }
    }
    this.lastCheckTime = l1;
    cb localcb = this.xDh;
    if (localcb != null) {
      localcb.a(null);
    }
    this.xDh = j.a(this.scope, null, null, (m)new b(this, paramString2, paramString1, null), 3);
    AppMethodBeat.o(266535);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/eggspring/SpringLuckyEggHelper$Companion;", "", "()V", "TAG", "", "plugin-eggspring_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends k
    implements m<aq, d<? super ah>, Object>
  {
    int label;
    
    b(g paramg, String paramString1, String paramString2, d<? super b> paramd)
    {
      super(paramd);
    }
    
    public final d<ah> create(Object paramObject, d<?> paramd)
    {
      AppMethodBeat.i(266524);
      paramObject = (d)new b(this.xEu, paramString2, paramString1, paramd);
      AppMethodBeat.o(266524);
      return paramObject;
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(266521);
      Object localObject2 = kotlin.d.a.a.aiwj;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(266521);
        throw paramObject;
      case 0: 
        ResultKt.throwOnFailure(paramObject);
      }
      try
      {
        paramObject = (m)new a(paramString2, null);
        Object localObject1 = (d)this;
        this.label = 1;
        paramObject = dc.a(10000L, paramObject, (d)localObject1);
        localObject1 = paramObject;
        if (paramObject == localObject2)
        {
          AppMethodBeat.o(266521);
          return localObject2;
          ResultKt.throwOnFailure(paramObject);
          localObject1 = paramObject;
        }
        paramObject = (f)localObject1;
        g.a(this.xEu, paramObject.interval);
        Log.i("MicroMsg.SpringLuckyEggHelper", "should play lucky egg:" + paramObject.mdI + " interval=" + g.a(this.xEu) + ", traceId=" + paramObject.mdH);
        if (paramObject.mdI == 1)
        {
          localObject1 = this.xEu.xEt;
          if (localObject1 != null)
          {
            localObject2 = paramObject.mdH;
            int i = paramObject.interval;
            ((kotlin.g.a.b)localObject1).invoke(new com.tencent.mm.plugin.eggspring.c.c(paramString2, (String)localObject2, paramString1, true, i, 32));
          }
        }
        this.xEu.xEt = null;
        paramObject = ah.aiuX;
        AppMethodBeat.o(266521);
        return paramObject;
      }
      catch (a paramObject)
      {
        Log.w("MicroMsg.SpringLuckyEggHelper", s.X("Unable to check if we can show lucky egg: ", paramObject.getMessage()));
        paramObject = ah.aiuX;
        return paramObject;
      }
      catch (da paramObject)
      {
        Log.w("MicroMsg.SpringLuckyEggHelper", "Timeout to check can show luck egg");
        paramObject = ah.aiuX;
        return paramObject;
      }
      finally
      {
        this.xEu.xEt = null;
        AppMethodBeat.o(266521);
      }
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/eggspring/model/GetInteractionADResp;", "Lkotlinx/coroutines/CoroutineScope;"}, k=3, mv={1, 5, 1}, xi=48)
    static final class a
      extends k
      implements m<aq, d<? super f>, Object>
    {
      int label;
      
      a(String paramString, d<? super a> paramd)
      {
        super(paramd);
      }
      
      public final d<ah> create(Object paramObject, d<?> paramd)
      {
        AppMethodBeat.i(266500);
        paramObject = (d)new a(this.xEv, paramd);
        AppMethodBeat.o(266500);
        return paramObject;
      }
      
      public final Object invokeSuspend(Object paramObject)
      {
        AppMethodBeat.i(266496);
        kotlin.d.a.a locala = kotlin.d.a.a.aiwj;
        switch (this.label)
        {
        default: 
          paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
          AppMethodBeat.o(266496);
          throw paramObject;
        case 0: 
          ResultKt.throwOnFailure(paramObject);
          paramObject = (com.tencent.mm.am.b)new com.tencent.mm.plugin.eggspring.b.c(this.xEv, "");
          Object localObject = (d)this;
          this.label = 1;
          localObject = b.b(paramObject, (d)localObject);
          paramObject = localObject;
          if (localObject == locala)
          {
            AppMethodBeat.o(266496);
            return locala;
          }
          break;
        case 1: 
          ResultKt.throwOnFailure(paramObject);
        }
        AppMethodBeat.o(266496);
        return paramObject;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.eggspring.g
 * JD-Core Version:    0.7.0.1
 */