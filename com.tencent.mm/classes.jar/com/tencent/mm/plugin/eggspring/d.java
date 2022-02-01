package com.tencent.mm.plugin.eggspring;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.ah;
import kotlin.d.b.a.k;
import kotlin.g.a.m;
import kotlin.g.b.s;
import kotlinx.coroutines.aq;
import kotlinx.coroutines.ar;
import kotlinx.coroutines.cb;
import kotlinx.coroutines.da;
import kotlinx.coroutines.dc;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/eggspring/EggRedEnvelopeHelper;", "", "()V", "TAG", "", "callback", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "showEgg", "url", "", "getCallback", "()Lkotlin/jvm/functions/Function2;", "setCallback", "(Lkotlin/jvm/functions/Function2;)V", "interval", "", "lastCheckJob", "Lkotlinx/coroutines/Job;", "lastCheckTime", "", "scope", "Lkotlinx/coroutines/CoroutineScope;", "checkShowEgg", "dispose", "plugin-eggspring_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class d
{
  public final String TAG;
  int interval;
  private long lastCheckTime;
  public m<? super Boolean, ? super String, ah> mgM;
  private aq scope;
  public cb xDh;
  
  public d()
  {
    AppMethodBeat.i(266515);
    this.TAG = "MicroMsg.EggRedEnvelopeHelper";
    this.scope = ar.kBZ();
    AppMethodBeat.o(266515);
  }
  
  public final void dxG()
  {
    AppMethodBeat.i(266518);
    Log.i(this.TAG, "checkShowEgg: ");
    long l = Util.currentTicks();
    if (Util.ticksToNow(this.lastCheckTime) <= this.interval)
    {
      Log.w(this.TAG, "checkShowEgg: " + this.lastCheckTime + ", " + this.interval + ", " + l);
      AppMethodBeat.o(266518);
      return;
    }
    int i = ((com.tencent.mm.plugin.expt.b.c)h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.znq, 100);
    Object localObject = kotlin.j.c.aixl;
    int j = kotlin.j.c.klI().Pa(100);
    Log.i(this.TAG, "checkShowEgg: percent " + i + ", " + j);
    if (j >= i)
    {
      AppMethodBeat.o(266518);
      return;
    }
    this.lastCheckTime = l;
    localObject = this.xDh;
    if (localObject != null) {
      ((cb)localObject).a(null);
    }
    this.xDh = kotlinx.coroutines.j.a(this.scope, null, null, (m)new a(this, null), 3);
    AppMethodBeat.o(266518);
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends k
    implements m<aq, kotlin.d.d<? super ah>, Object>
  {
    int label;
    
    a(d paramd, kotlin.d.d<? super a> paramd1)
    {
      super(paramd1);
    }
    
    public final kotlin.d.d<ah> create(Object paramObject, kotlin.d.d<?> paramd)
    {
      AppMethodBeat.i(266494);
      paramObject = (kotlin.d.d)new a(this.xDk, paramd);
      AppMethodBeat.o(266494);
      return paramObject;
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(266491);
      Object localObject2 = kotlin.d.a.a.aiwj;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(266491);
        throw paramObject;
      case 0: 
        ResultKt.throwOnFailure(paramObject);
      }
      try
      {
        paramObject = (m)new a(null);
        Object localObject1 = (kotlin.d.d)this;
        this.label = 1;
        paramObject = dc.a(10000L, paramObject, (kotlin.d.d)localObject1);
        localObject1 = paramObject;
        if (paramObject == localObject2)
        {
          AppMethodBeat.o(266491);
          return localObject2;
          ResultKt.throwOnFailure(paramObject);
          localObject1 = paramObject;
        }
        localObject2 = (com.tencent.mm.r.a.j)localObject1;
        this.xDk.interval = (((com.tencent.mm.r.a.j)localObject2).mdL * 1000);
        Log.i(this.xDk.TAG, "checkShowEgg: " + ((com.tencent.mm.r.a.j)localObject2).show_entrance + ", " + ((com.tencent.mm.r.a.j)localObject2).mdK + ", " + ((com.tencent.mm.r.a.j)localObject2).mdL);
        if ((((com.tencent.mm.r.a.j)localObject2).show_entrance) && (((com.tencent.mm.r.a.j)localObject2).mdK != null))
        {
          paramObject = this.xDk.mgM;
          if (paramObject != null)
          {
            localObject1 = Boolean.TRUE;
            localObject2 = ((com.tencent.mm.r.a.j)localObject2).mdK;
            s.s(localObject2, "resp.entrance_url");
            paramObject.invoke(localObject1, localObject2);
          }
        }
      }
      catch (a paramObject)
      {
        for (;;)
        {
          Log.w(this.xDk.TAG, s.X("Cgi error: ", paramObject.getMessage()));
        }
      }
      catch (da paramObject)
      {
        for (;;)
        {
          Log.w(this.xDk.TAG, "Cgi Timeout: ");
        }
      }
      paramObject = ah.aiuX;
      AppMethodBeat.o(266491);
      return paramObject;
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/eggspring/model/GetRedpacketCoverRecvEntranceResp;", "Lkotlinx/coroutines/CoroutineScope;"}, k=3, mv={1, 5, 1}, xi=48)
    static final class a
      extends k
      implements m<aq, kotlin.d.d<? super com.tencent.mm.r.a.j>, Object>
    {
      int label;
      
      a(kotlin.d.d<? super a> paramd)
      {
        super(paramd);
      }
      
      public final kotlin.d.d<ah> create(Object paramObject, kotlin.d.d<?> paramd)
      {
        AppMethodBeat.i(266502);
        paramObject = (kotlin.d.d)new a(paramd);
        AppMethodBeat.o(266502);
        return paramObject;
      }
      
      public final Object invokeSuspend(Object paramObject)
      {
        AppMethodBeat.i(266499);
        kotlin.d.a.a locala = kotlin.d.a.a.aiwj;
        switch (this.label)
        {
        default: 
          paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
          AppMethodBeat.o(266499);
          throw paramObject;
        case 0: 
          ResultKt.throwOnFailure(paramObject);
          paramObject = (com.tencent.mm.am.b)new com.tencent.mm.plugin.eggspring.b.b();
          Object localObject = (kotlin.d.d)this;
          this.label = 1;
          localObject = b.b(paramObject, (kotlin.d.d)localObject);
          paramObject = localObject;
          if (localObject == locala)
          {
            AppMethodBeat.o(266499);
            return locala;
          }
          break;
        case 1: 
          ResultKt.throwOnFailure(paramObject);
        }
        AppMethodBeat.o(266499);
        return paramObject;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.eggspring.d
 * JD-Core Version:    0.7.0.1
 */