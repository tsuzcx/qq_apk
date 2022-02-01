package com.tencent.mm.plugin.eggspring.ui;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bb.e;
import com.tencent.mm.bb.k;
import com.tencent.mm.plugin.eggspring.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Iterator;
import kotlin.ResultKt;
import kotlin.g.a.m;
import kotlin.g.b.p;
import kotlin.x;
import kotlinx.coroutines.ai;
import kotlinx.coroutines.aj;
import kotlinx.coroutines.au;
import kotlinx.coroutines.ba;

@kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/eggspring/ui/SpringLuckyEggViewModel;", "Landroid/arch/lifecycle/ViewModel;", "eggName", "", "keyword", "appId", "traceId", "defaultBackgroundColor", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "acceptEvent", "Landroid/arch/lifecycle/MutableLiveData;", "Lcom/tencent/mm/plugin/eggspring/model/AcceptEvent;", "getAcceptEvent", "()Landroid/arch/lifecycle/MutableLiveData;", "acceptLink", "", "getAcceptLink", "accepted", "", "getAccepted", "backgroundColor", "getBackgroundColor", "bag", "Lcom/tencent/mm/modelpackage/LuckyBag;", "getBag", "bottomLink", "getBottomLink", "loading", "getLoading", "material", "Lcom/tencent/mm/eggspring/model/Material;", "getMaterial", "scope", "Lkotlinx/coroutines/CoroutineScope;", "startMills", "", "acceptCoupon", "", "stockId", "acceptEventHandled", "acceptMoney", "materialId", "amount", "loadEgg", "Lkotlinx/coroutines/Job;", "loadMaterial", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onCleared", "parseLink", "type", "", "info", "Lcom/tencent/mm/eggspring/model/MaterialPageInfo;", "sendAcceptError", "error", "Lcom/tencent/mm/plugin/eggspring/CgiException;", "Companion", "plugin-eggspring_release"})
public final class SpringLuckyEggViewModel
  extends ViewModel
{
  public static final SpringLuckyEggViewModel.a qWg;
  private String appId;
  private final String dDv;
  String kZe;
  final ai qUR;
  final MutableLiveData<Boolean> qVW;
  final MutableLiveData<com.tencent.mm.plugin.eggspring.c.a> qVX;
  final MutableLiveData<String> qVY;
  final MutableLiveData<Object> qVZ;
  final MutableLiveData<Object> qWa;
  final MutableLiveData<com.tencent.mm.t.a.j> qWb;
  final MutableLiveData<k> qWc;
  final MutableLiveData<Boolean> qWd;
  private final long qWe;
  private final String qWf;
  
  static
  {
    AppMethodBeat.i(194644);
    qWg = new SpringLuckyEggViewModel.a((byte)0);
    AppMethodBeat.o(194644);
  }
  
  public SpringLuckyEggViewModel(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    AppMethodBeat.i(194643);
    this.qWf = paramString1;
    this.dDv = paramString2;
    this.appId = paramString3;
    this.kZe = paramString4;
    this.qUR = aj.hMI();
    this.qVW = new MutableLiveData();
    this.qVX = new MutableLiveData();
    this.qVY = new MutableLiveData();
    this.qVZ = new MutableLiveData();
    this.qWa = new MutableLiveData();
    this.qWb = new MutableLiveData();
    this.qWc = new MutableLiveData();
    this.qWd = new MutableLiveData();
    this.qWe = Util.nowMilliSecond();
    this.qVY.setValue(paramString5);
    this.qVW.setValue(Boolean.TRUE);
    kotlinx.coroutines.f.b(this.qUR, null, (m)new d(this, null), 3);
    AppMethodBeat.o(194643);
  }
  
  private static Object a(int paramInt, com.tencent.mm.t.a.l paraml)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case 1: 
      return (com.tencent.mm.bw.a)paraml.gTO;
    case 4: 
    case 5: 
      return (com.tencent.mm.bw.a)paraml.gTR;
    case 3: 
      return (com.tencent.mm.bw.a)paraml.gTQ;
    }
    return (com.tencent.mm.bw.a)paraml.gTP;
  }
  
  public final void onCleared()
  {
    AppMethodBeat.i(194641);
    super.onCleared();
    Log.i("MicroMsg.SpringLuckyEggViewModel", "onCleared()");
    aj.b(this.qUR);
    AppMethodBeat.o(194641);
  }
  
  @kotlin.d.b.a.f(c="com.tencent.mm.plugin.eggspring.ui.SpringLuckyEggViewModel$acceptCoupon$1", f="SpringLuckyEggViewModel.kt", hxM={160}, m="invokeSuspend")
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"})
  static final class b
    extends kotlin.d.b.a.j
    implements m<ai, kotlin.d.d<? super x>, Object>
  {
    Object L$0;
    int label;
    private ai p$;
    
    b(SpringLuckyEggViewModel paramSpringLuckyEggViewModel, String paramString1, String paramString2, kotlin.d.d paramd)
    {
      super(paramd);
    }
    
    public final kotlin.d.d<x> create(Object paramObject, kotlin.d.d<?> paramd)
    {
      AppMethodBeat.i(194626);
      p.h(paramd, "completion");
      paramd = new b(this.qWh, this.kPQ, this.qWi, paramd);
      paramd.p$ = ((ai)paramObject);
      AppMethodBeat.o(194626);
      return paramd;
    }
    
    public final Object invoke(Object paramObject1, Object paramObject2)
    {
      AppMethodBeat.i(194627);
      paramObject1 = ((b)create(paramObject1, (kotlin.d.d)paramObject2)).invokeSuspend(x.SXb);
      AppMethodBeat.o(194627);
      return paramObject1;
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(194625);
      kotlin.d.a.a locala = kotlin.d.a.a.SXO;
      ai localai;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(194625);
        throw paramObject;
      case 0: 
        ResultKt.throwOnFailure(paramObject);
        localai = this.p$;
      }
      for (;;)
      {
        try
        {
          String str1 = this.kPQ;
          String str2 = this.qWi;
          localObject = SpringLuckyEggViewModel.d(this.qWh);
          paramObject = localObject;
          if (localObject == null) {
            paramObject = "";
          }
          paramObject = (com.tencent.mm.ak.c)new com.tencent.mm.plugin.eggspring.b.a(str1, str2, "CNY_EXPRESSION", paramObject);
          this.L$0 = localai;
          this.label = 1;
          paramObject = b.a(paramObject, this);
          localObject = paramObject;
          if (paramObject == locala)
          {
            AppMethodBeat.o(194625);
            return locala;
            ResultKt.throwOnFailure(paramObject);
            localObject = paramObject;
          }
          paramObject = (com.tencent.mm.t.a.h)localObject;
          Log.w("MicroMsg.SpringLuckyEggViewModel", "accept coupon result: " + paramObject.ret);
          if (paramObject.ret != 0) {
            continue;
          }
          this.qWh.qWd.setValue(Boolean.TRUE);
          paramObject = com.tencent.mm.plugin.eggspring.c.qUO;
          com.tencent.mm.plugin.eggspring.c.cEH().FF(13);
          this.qWh.qVX.postValue(com.tencent.mm.plugin.eggspring.c.a.qUY);
        }
        catch (com.tencent.mm.plugin.eggspring.a paramObject)
        {
          Object localObject = com.tencent.mm.plugin.eggspring.c.qUO;
          com.tencent.mm.plugin.eggspring.c.cEH().FF(14);
          SpringLuckyEggViewModel.a(this.qWh, paramObject);
          Log.w("MicroMsg.SpringLuckyEggViewModel", "Unable to accept money");
          continue;
        }
        paramObject = x.SXb;
        AppMethodBeat.o(194625);
        return paramObject;
        paramObject = com.tencent.mm.plugin.eggspring.c.qUO;
        com.tencent.mm.plugin.eggspring.c.cEH().FF(14);
        this.qWh.qVX.postValue(com.tencent.mm.plugin.eggspring.c.a.qUZ);
      }
    }
  }
  
  @kotlin.d.b.a.f(c="com.tencent.mm.plugin.eggspring.ui.SpringLuckyEggViewModel$acceptMoney$1", f="SpringLuckyEggViewModel.kt", hxM={131, 135}, m="invokeSuspend")
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"})
  static final class c
    extends kotlin.d.b.a.j
    implements m<ai, kotlin.d.d<? super x>, Object>
  {
    Object L$0;
    int label;
    private ai p$;
    long qWj;
    
    c(SpringLuckyEggViewModel paramSpringLuckyEggViewModel, long paramLong, String paramString, kotlin.d.d paramd)
    {
      super(paramd);
    }
    
    public final kotlin.d.d<x> create(Object paramObject, kotlin.d.d<?> paramd)
    {
      AppMethodBeat.i(194629);
      p.h(paramd, "completion");
      paramd = new c(this.qWh, this.qWk, this.qWl, paramd);
      paramd.p$ = ((ai)paramObject);
      AppMethodBeat.o(194629);
      return paramd;
    }
    
    public final Object invoke(Object paramObject1, Object paramObject2)
    {
      AppMethodBeat.i(194630);
      paramObject1 = ((c)create(paramObject1, (kotlin.d.d)paramObject2)).invokeSuspend(x.SXb);
      AppMethodBeat.o(194630);
      return paramObject1;
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(194628);
      kotlin.d.a.a locala = kotlin.d.a.a.SXO;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(194628);
        throw paramObject;
      case 0: 
        ResultKt.throwOnFailure(paramObject);
        localObject = this.p$;
      }
      try
      {
        l = this.qWk;
        str = SpringLuckyEggViewModel.d(this.qWh);
        paramObject = str;
        if (str == null) {
          paramObject = "";
        }
        paramObject = (com.tencent.mm.ak.c)new com.tencent.mm.plugin.eggspring.b.d("", l, paramObject);
        this.L$0 = localObject;
        this.label = 1;
        paramObject = b.a(paramObject, this);
        if (paramObject != locala) {
          break label448;
        }
        AppMethodBeat.o(194628);
        return locala;
      }
      catch (com.tencent.mm.plugin.eggspring.a paramObject)
      {
        for (;;)
        {
          long l;
          String str;
          localObject = com.tencent.mm.plugin.eggspring.c.qUO;
          com.tencent.mm.plugin.eggspring.c.cEH().FF(18);
          Log.w("MicroMsg.SpringLuckyEggViewModel", "unable to accept money: " + paramObject.getMessage());
          this.qWh.qVW.setValue(Boolean.FALSE);
          this.qWh.qWd.setValue(Boolean.TRUE);
        }
      }
      finally
      {
        this.qWh.qVW.setValue(Boolean.FALSE);
        this.qWh.qWd.setValue(Boolean.TRUE);
        AppMethodBeat.o(194628);
      }
      Object localObject = (ai)this.L$0;
      ResultKt.throwOnFailure(paramObject);
      label448:
      for (paramObject = localObject;; paramObject = localObject)
      {
        localObject = com.tencent.mm.plugin.eggspring.c.qUO;
        localObject = com.tencent.mm.plugin.eggspring.c.cEH();
        str = this.qWl;
        p.h(str, "amount");
        com.tencent.mm.plugin.report.service.h.CyF.a(18916, new Object[] { ((com.tencent.mm.plugin.eggspring.c)localObject).qUL, "", Integer.valueOf(17), "", "", "", "", str, ((com.tencent.mm.plugin.eggspring.c)localObject).appId });
        l = Util.milliSecondsToNow(SpringLuckyEggViewModel.e(this.qWh));
        if (l < 2000L)
        {
          this.L$0 = paramObject;
          this.qWj = l;
          this.label = 2;
          paramObject = au.a(2000L - l, this);
          if (paramObject == locala)
          {
            AppMethodBeat.o(194628);
            return locala;
            ResultKt.throwOnFailure(paramObject);
          }
        }
        this.qWh.qVW.setValue(Boolean.FALSE);
        this.qWh.qWd.setValue(Boolean.TRUE);
        paramObject = x.SXb;
        AppMethodBeat.o(194628);
        return paramObject;
      }
    }
  }
  
  @kotlin.d.b.a.f(c="com.tencent.mm.plugin.eggspring.ui.SpringLuckyEggViewModel$loadEgg$1", f="SpringLuckyEggViewModel.kt", hxM={77, 90}, m="invokeSuspend")
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"})
  static final class d
    extends kotlin.d.b.a.j
    implements m<ai, kotlin.d.d<? super x>, Object>
  {
    Object L$0;
    int label;
    private ai p$;
    Object pED;
    
    d(SpringLuckyEggViewModel paramSpringLuckyEggViewModel, kotlin.d.d paramd)
    {
      super(paramd);
    }
    
    public final kotlin.d.d<x> create(Object paramObject, kotlin.d.d<?> paramd)
    {
      AppMethodBeat.i(194635);
      p.h(paramd, "completion");
      paramd = new d(this.qWh, paramd);
      paramd.p$ = ((ai)paramObject);
      AppMethodBeat.o(194635);
      return paramd;
    }
    
    public final Object invoke(Object paramObject1, Object paramObject2)
    {
      AppMethodBeat.i(194636);
      paramObject1 = ((d)create(paramObject1, (kotlin.d.d)paramObject2)).invokeSuspend(x.SXb);
      AppMethodBeat.o(194636);
      return paramObject1;
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(194634);
      kotlin.d.a.a locala = kotlin.d.a.a.SXO;
      Object localObject1;
      Object localObject2;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(194634);
        throw paramObject;
      case 0: 
        ResultKt.throwOnFailure(paramObject);
        paramObject = this.p$;
        Log.i("MicroMsg.SpringLuckyEggViewModel", "load egg");
        localObject1 = (kotlin.d.f)ba.hMW();
        localObject2 = (m)new a(this, null);
        this.L$0 = paramObject;
        this.label = 1;
        localObject2 = kotlinx.coroutines.g.a((kotlin.d.f)localObject1, (m)localObject2, this);
        localObject1 = localObject2;
        if (localObject2 == locala)
        {
          AppMethodBeat.o(194634);
          return locala;
        }
      case 1: 
        localObject2 = (ai)this.L$0;
        ResultKt.throwOnFailure(paramObject);
        localObject1 = paramObject;
        paramObject = localObject2;
        localObject2 = (e)localObject1;
        if (localObject2 != null) {}
        for (localObject1 = ((e)localObject2).gXT; localObject1 == null; localObject1 = null)
        {
          Log.e("MicroMsg.SpringLuckyEggViewModel", "couldn't find the luck egg");
          this.qWh.qVX.setValue(com.tencent.mm.plugin.eggspring.c.a.qVb);
          paramObject = x.SXb;
          AppMethodBeat.o(194634);
          return paramObject;
        }
        this.qWh.qWc.setValue(((e)localObject2).gXT);
        this.qWh.qVY.setValue(((e)localObject2).gXT.jhc);
        SpringLuckyEggViewModel.a(this.qWh, ((e)localObject2).gXT.appId);
        localObject1 = this.qWh;
        this.L$0 = paramObject;
        this.pED = localObject2;
        this.label = 2;
        if (((SpringLuckyEggViewModel)localObject1).a(this) != locala) {
          break label283;
        }
        AppMethodBeat.o(194634);
        return locala;
      }
      ResultKt.throwOnFailure(paramObject);
      label283:
      paramObject = x.SXb;
      AppMethodBeat.o(194634);
      return paramObject;
    }
    
    @kotlin.d.b.a.f(c="com.tencent.mm.plugin.eggspring.ui.SpringLuckyEggViewModel$loadEgg$1$egg$1", f="SpringLuckyEggViewModel.kt", hxM={}, m="invokeSuspend")
    @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Lcom/tencent/mm/modelpackage/EggInfo;", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"})
    static final class a
      extends kotlin.d.b.a.j
      implements m<ai, kotlin.d.d<? super e>, Object>
    {
      int label;
      private ai p$;
      
      a(SpringLuckyEggViewModel.d paramd, kotlin.d.d paramd1)
      {
        super(paramd1);
      }
      
      public final kotlin.d.d<x> create(Object paramObject, kotlin.d.d<?> paramd)
      {
        AppMethodBeat.i(194632);
        p.h(paramd, "completion");
        paramd = new a(this.qWm, paramd);
        paramd.p$ = ((ai)paramObject);
        AppMethodBeat.o(194632);
        return paramd;
      }
      
      public final Object invoke(Object paramObject1, Object paramObject2)
      {
        AppMethodBeat.i(194633);
        paramObject1 = ((a)create(paramObject1, (kotlin.d.d)paramObject2)).invokeSuspend(x.SXb);
        AppMethodBeat.o(194633);
        return paramObject1;
      }
      
      public final Object invokeSuspend(Object paramObject)
      {
        AppMethodBeat.i(194631);
        Object localObject1 = kotlin.d.a.a.SXO;
        switch (this.label)
        {
        default: 
          paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
          AppMethodBeat.o(194631);
          throw paramObject;
        }
        ResultKt.throwOnFailure(paramObject);
        paramObject = com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.emoji.b.d.class);
        p.g(paramObject, "MMKernel.plugin(IPluginEmoji::class.java)");
        paramObject = ((com.tencent.mm.plugin.emoji.b.d)paramObject).getEmojiMgr();
        p.g(paramObject, "MMKernel.plugin(IPluginEmoji::class.java).emojiMgr");
        paramObject = paramObject.cFL().jgS;
        p.g(paramObject, "eggList.eggList");
        localObject1 = ((Iterable)paramObject).iterator();
        label267:
        label270:
        while (((Iterator)localObject1).hasNext())
        {
          Object localObject2 = ((Iterator)localObject1).next();
          paramObject = (e)localObject2;
          if ((paramObject.jgP >= 5) && (p.j(paramObject.gXT.appId, SpringLuckyEggViewModel.a(this.qWm.qWh))) && (p.j(paramObject.name, SpringLuckyEggViewModel.b(this.qWm.qWh))))
          {
            paramObject = paramObject.jgK;
            p.g(paramObject, "egg.keyWords");
            Iterator localIterator = ((Iterable)paramObject).iterator();
            while (localIterator.hasNext())
            {
              paramObject = localIterator.next();
              if (p.j(((com.tencent.mm.bb.f)paramObject).jgR, SpringLuckyEggViewModel.c(this.qWm.qWh))) {
                if (paramObject == null) {
                  break label267;
                }
              }
            }
          }
          for (int i = 1;; i = 0)
          {
            if (i == 0) {
              break label270;
            }
            AppMethodBeat.o(194631);
            return localObject2;
            paramObject = null;
            break;
          }
        }
        AppMethodBeat.o(194631);
        return null;
      }
    }
  }
  
  @kotlin.d.b.a.f(c="com.tencent.mm.plugin.eggspring.ui.SpringLuckyEggViewModel", f="SpringLuckyEggViewModel.kt", hxM={95}, m="loadMaterial")
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"loadMaterial", "", "continuation", "Lkotlin/coroutines/Continuation;", ""})
  static final class e
    extends kotlin.d.b.a.d
  {
    Object L$0;
    int label;
    
    e(SpringLuckyEggViewModel paramSpringLuckyEggViewModel, kotlin.d.d paramd)
    {
      super();
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(194637);
      this.result = paramObject;
      this.label |= 0x80000000;
      paramObject = this.qWh.a(this);
      AppMethodBeat.o(194637);
      return paramObject;
    }
  }
  
  @kotlin.d.b.a.f(c="com.tencent.mm.plugin.eggspring.ui.SpringLuckyEggViewModel$loadMaterial$resp$1", f="SpringLuckyEggViewModel.kt", hxM={96}, m="invokeSuspend")
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Lcom/tencent/mm/eggspring/model/GetInteractionMaterialResp;", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"})
  static final class f
    extends kotlin.d.b.a.j
    implements m<ai, kotlin.d.d<? super com.tencent.mm.t.a.f>, Object>
  {
    Object L$0;
    int label;
    private ai p$;
    
    f(SpringLuckyEggViewModel paramSpringLuckyEggViewModel, kotlin.d.d paramd)
    {
      super(paramd);
    }
    
    public final kotlin.d.d<x> create(Object paramObject, kotlin.d.d<?> paramd)
    {
      AppMethodBeat.i(194639);
      p.h(paramd, "completion");
      paramd = new f(this.qWh, paramd);
      paramd.p$ = ((ai)paramObject);
      AppMethodBeat.o(194639);
      return paramd;
    }
    
    public final Object invoke(Object paramObject1, Object paramObject2)
    {
      AppMethodBeat.i(194640);
      paramObject1 = ((f)create(paramObject1, (kotlin.d.d)paramObject2)).invokeSuspend(x.SXb);
      AppMethodBeat.o(194640);
      return paramObject1;
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(194638);
      kotlin.d.a.a locala = kotlin.d.a.a.SXO;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(194638);
        throw paramObject;
      case 0: 
        ResultKt.throwOnFailure(paramObject);
        paramObject = this.p$;
        Object localObject = (com.tencent.mm.ak.c)new com.tencent.mm.plugin.eggspring.b.c(SpringLuckyEggViewModel.c(this.qWh), "", "");
        this.L$0 = paramObject;
        this.label = 1;
        localObject = b.a((com.tencent.mm.ak.c)localObject, this);
        paramObject = localObject;
        if (localObject == locala)
        {
          AppMethodBeat.o(194638);
          return locala;
        }
        break;
      case 1: 
        ResultKt.throwOnFailure(paramObject);
      }
      AppMethodBeat.o(194638);
      return paramObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.eggspring.ui.SpringLuckyEggViewModel
 * JD-Core Version:    0.7.0.1
 */