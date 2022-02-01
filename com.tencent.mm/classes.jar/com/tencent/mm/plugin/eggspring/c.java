package com.tencent.mm.plugin.eggspring;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
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

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/eggspring/EggMiniAppHelper;", "", "()V", "TAG", "", "callback", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "showEgg", "data", "", "getCallback", "()Lkotlin/jvm/functions/Function2;", "setCallback", "(Lkotlin/jvm/functions/Function2;)V", "extraDataString", "getExtraDataString", "()Ljava/lang/String;", "setExtraDataString", "(Ljava/lang/String;)V", "interval", "", "lastCheckJob", "Lkotlinx/coroutines/Job;", "lastCheckTime", "", "scope", "Lkotlinx/coroutines/CoroutineScope;", "checkShowEgg", "sessionId", "(Ljava/lang/Long;)V", "dispose", "plugin-eggspring_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
{
  final String TAG;
  int interval;
  private long lastCheckTime;
  public m<? super Boolean, ? super String, ah> mgM;
  private aq scope;
  private cb xDh;
  public String xDi;
  
  public c()
  {
    AppMethodBeat.i(266516);
    this.TAG = "MicroMsg.EggMiniAppHelper";
    this.scope = ar.kBZ();
    this.xDi = "";
    AppMethodBeat.o(266516);
  }
  
  public final void y(final Long paramLong)
  {
    AppMethodBeat.i(369737);
    Log.i(this.TAG, s.X("checkShowEgg: ", paramLong));
    long l = Util.currentTicks();
    if (Util.ticksToNow(this.lastCheckTime) <= this.interval)
    {
      Log.w(this.TAG, "checkShowEgg: " + this.lastCheckTime + ", " + this.interval + ", " + l);
      AppMethodBeat.o(369737);
      return;
    }
    if (!((com.tencent.mm.plugin.eggspring.a.a)h.az(com.tencent.mm.plugin.eggspring.a.a.class)).enablePlayLuckyEffect())
    {
      AppMethodBeat.o(369737);
      return;
    }
    this.lastCheckTime = l;
    cb localcb = this.xDh;
    if (localcb != null) {
      localcb.a(null);
    }
    this.xDh = kotlinx.coroutines.j.a(this.scope, null, null, (m)new a(this, paramLong, null), 3);
    AppMethodBeat.o(369737);
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends k
    implements m<aq, d<? super ah>, Object>
  {
    int label;
    
    a(c paramc, Long paramLong, d<? super a> paramd)
    {
      super(paramd);
    }
    
    public final d<ah> create(Object paramObject, d<?> paramd)
    {
      AppMethodBeat.i(266526);
      paramObject = (d)new a(this.xDj, paramLong, paramd);
      AppMethodBeat.o(266526);
      return paramObject;
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(266522);
      Object localObject2 = kotlin.d.a.a.aiwj;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(266522);
        throw paramObject;
      case 0: 
        ResultKt.throwOnFailure(paramObject);
      }
      try
      {
        paramObject = (m)new a(paramLong, null);
        Object localObject1 = (d)this;
        this.label = 1;
        paramObject = dc.a(10000L, paramObject, (d)localObject1);
        localObject1 = paramObject;
        if (paramObject == localObject2)
        {
          AppMethodBeat.o(266522);
          return localObject2;
          ResultKt.throwOnFailure(paramObject);
          localObject1 = paramObject;
        }
        paramObject = (com.tencent.mm.r.a.j)localObject1;
        this.xDj.interval = (paramObject.mdL * 1000);
        Log.i(this.xDj.TAG, "checkShowEgg: " + paramObject.show_entrance + ", " + paramObject.mdM + ", " + paramObject.mdL);
        if ((paramObject.show_entrance) && (paramObject.mdM != null))
        {
          localObject1 = this.xDj;
          localObject2 = paramObject.mdM;
          s.s(localObject2, "resp.emoticon_prize");
          s.u(localObject2, "<set-?>");
          ((c)localObject1).xDi = ((String)localObject2);
          localObject1 = this.xDj.mgM;
          if (localObject1 != null)
          {
            localObject2 = Boolean.TRUE;
            paramObject = paramObject.mdM;
            s.s(paramObject, "resp.emoticon_prize");
            ((m)localObject1).invoke(localObject2, paramObject);
          }
        }
      }
      catch (a paramObject)
      {
        for (;;)
        {
          Log.w(this.xDj.TAG, s.X("Cgi error: ", paramObject.getMessage()));
        }
      }
      catch (da paramObject)
      {
        for (;;)
        {
          Log.w(this.xDj.TAG, "Cgi Timeout: ");
        }
      }
      paramObject = ah.aiuX;
      AppMethodBeat.o(266522);
      return paramObject;
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/eggspring/model/GetRedpacketCoverRecvEntranceResp;", "Lkotlinx/coroutines/CoroutineScope;"}, k=3, mv={1, 5, 1}, xi=48)
    static final class a
      extends k
      implements m<aq, d<? super com.tencent.mm.r.a.j>, Object>
    {
      int label;
      
      a(Long paramLong, d<? super a> paramd)
      {
        super(paramd);
      }
      
      public final d<ah> create(Object paramObject, d<?> paramd)
      {
        AppMethodBeat.i(266490);
        paramObject = (d)new a(this.CrL, paramd);
        AppMethodBeat.o(266490);
        return paramObject;
      }
      
      public final Object invokeSuspend(Object paramObject)
      {
        AppMethodBeat.i(266487);
        kotlin.d.a.a locala = kotlin.d.a.a.aiwj;
        switch (this.label)
        {
        default: 
          paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
          AppMethodBeat.o(266487);
          throw paramObject;
        case 0: 
          ResultKt.throwOnFailure(paramObject);
          paramObject = this.CrL;
          if (paramObject == null) {
            paramObject = "";
          }
          for (;;)
          {
            paramObject = (com.tencent.mm.am.b)new com.tencent.mm.plugin.eggspring.b.b(paramObject);
            Object localObject = (d)this;
            this.label = 1;
            localObject = b.b(paramObject, (d)localObject);
            paramObject = localObject;
            if (localObject != locala) {
              break;
            }
            AppMethodBeat.o(266487);
            return locala;
            localObject = paramObject.toString();
            paramObject = localObject;
            if (localObject == null) {
              paramObject = "";
            }
          }
        }
        ResultKt.throwOnFailure(paramObject);
        AppMethodBeat.o(266487);
        return paramObject;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.eggspring.c
 * JD-Core Version:    0.7.0.1
 */