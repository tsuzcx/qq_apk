package com.tencent.mm.plugin.eggspring.ui;

import androidx.lifecycle.r;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.c;
import com.tencent.mm.plugin.eggspring.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.t.a.n;
import java.util.Iterator;
import kotlin.ResultKt;
import kotlin.d.b.a.j;
import kotlin.g.a.m;
import kotlinx.coroutines.ak;
import kotlinx.coroutines.al;
import kotlinx.coroutines.aw;
import kotlinx.coroutines.bc;
import kotlinx.coroutines.i;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/eggspring/ui/SpringLuckyEggViewModel;", "Landroidx/lifecycle/ViewModel;", "eggName", "", "keyword", "appId", "traceId", "defaultBackgroundColor", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "acceptEvent", "Landroidx/lifecycle/MutableLiveData;", "Lcom/tencent/mm/plugin/eggspring/model/AcceptEvent;", "getAcceptEvent", "()Landroidx/lifecycle/MutableLiveData;", "acceptLink", "", "getAcceptLink", "accepted", "", "getAccepted", "backgroundColor", "getBackgroundColor", "bag", "Lcom/tencent/mm/modelpackage/LuckyBag;", "getBag", "bottomLink", "getBottomLink", "loading", "getLoading", "material", "Lcom/tencent/mm/eggspring/model/Material;", "getMaterial", "scope", "Lkotlinx/coroutines/CoroutineScope;", "startMills", "", "acceptCoupon", "", "stockId", "acceptEventHandled", "acceptMoney", "materialId", "amount", "loadEgg", "Lkotlinx/coroutines/Job;", "loadMaterial", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onCleared", "parseLink", "type", "", "info", "Lcom/tencent/mm/eggspring/model/MaterialPageInfo;", "sendAcceptError", "error", "Lcom/tencent/mm/plugin/eggspring/CgiException;", "Companion", "plugin-eggspring_release"})
public final class d
  extends androidx.lifecycle.x
{
  public static final a uyR;
  private String appId;
  private final String fwe;
  String nTp;
  final ak rcY;
  final r<Boolean> uyH;
  final r<com.tencent.mm.plugin.eggspring.c.a> uyI;
  final r<String> uyJ;
  final r<Object> uyK;
  final r<Object> uyL;
  final r<n> uyM;
  final r<com.tencent.mm.be.l> uyN;
  final r<Boolean> uyO;
  private final long uyP;
  private final String uyQ;
  
  static
  {
    AppMethodBeat.i(249574);
    uyR = new a((byte)0);
    AppMethodBeat.o(249574);
  }
  
  public d(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    AppMethodBeat.i(249573);
    this.uyQ = paramString1;
    this.fwe = paramString2;
    this.appId = paramString3;
    this.nTp = paramString4;
    this.rcY = al.iRe();
    this.uyH = new r();
    this.uyI = new r();
    this.uyJ = new r();
    this.uyK = new r();
    this.uyL = new r();
    this.uyM = new r();
    this.uyN = new r();
    this.uyO = new r();
    this.uyP = Util.nowMilliSecond();
    this.uyJ.setValue(paramString5);
    this.uyH.setValue(Boolean.TRUE);
    kotlinx.coroutines.g.b(this.rcY, null, (m)new d(this, null), 3);
    AppMethodBeat.o(249573);
  }
  
  private static Object a(int paramInt, com.tencent.mm.t.a.p paramp)
  {
    switch (paramInt)
    {
    case 6: 
    default: 
      return null;
    case 1: 
      return (com.tencent.mm.cd.a)paramp.jEq;
    case 4: 
    case 5: 
      return (com.tencent.mm.cd.a)paramp.jEt;
    case 3: 
      return (com.tencent.mm.cd.a)paramp.jEs;
    case 2: 
      return (com.tencent.mm.cd.a)paramp.jEr;
    case 7: 
      return (com.tencent.mm.cd.a)paramp.jEu;
    }
    return (com.tencent.mm.cd.a)paramp.jEv;
  }
  
  public final void onCleared()
  {
    AppMethodBeat.i(249571);
    super.onCleared();
    Log.i("MicroMsg.SpringLuckyEggViewModel", "onCleared()");
    al.a(this.rcY, null);
    AppMethodBeat.o(249571);
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/eggspring/ui/SpringLuckyEggViewModel$Companion;", "", "()V", "LOAD_MATERIAL_TIMEOUT", "", "TAG", "", "plugin-eggspring_release"})
  public static final class a {}
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"})
  static final class b
    extends j
    implements m<ak, kotlin.d.d<? super kotlin.x>, Object>
  {
    Object L$0;
    int label;
    private ak p$;
    
    b(d paramd, String paramString1, String paramString2, kotlin.d.d paramd1)
    {
      super(paramd1);
    }
    
    public final kotlin.d.d<kotlin.x> create(Object paramObject, kotlin.d.d<?> paramd)
    {
      AppMethodBeat.i(249661);
      kotlin.g.b.p.k(paramd, "completion");
      paramd = new b(this.uyS, this.cBD, this.uyT, paramd);
      paramd.p$ = ((ak)paramObject);
      AppMethodBeat.o(249661);
      return paramd;
    }
    
    public final Object invoke(Object paramObject1, Object paramObject2)
    {
      AppMethodBeat.i(249662);
      paramObject1 = ((b)create(paramObject1, (kotlin.d.d)paramObject2)).invokeSuspend(kotlin.x.aazN);
      AppMethodBeat.o(249662);
      return paramObject1;
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(249660);
      kotlin.d.a.a locala = kotlin.d.a.a.aaAA;
      ak localak;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(249660);
        throw paramObject;
      case 0: 
        ResultKt.throwOnFailure(paramObject);
        localak = this.p$;
      }
      for (;;)
      {
        try
        {
          String str1 = this.cBD;
          String str2 = this.uyT;
          Object localObject = d.d(this.uyS);
          paramObject = localObject;
          if (localObject == null) {
            paramObject = "";
          }
          paramObject = (c)new com.tencent.mm.plugin.eggspring.b.a(str1, str2, "CNY_EXPRESSION", paramObject);
          this.L$0 = localak;
          this.label = 1;
          paramObject = b.a(paramObject, this);
          localObject = paramObject;
          if (paramObject == locala)
          {
            AppMethodBeat.o(249660);
            return locala;
            ResultKt.throwOnFailure(paramObject);
            localObject = paramObject;
          }
          paramObject = (com.tencent.mm.t.a.l)localObject;
          Log.w("MicroMsg.SpringLuckyEggViewModel", "accept coupon result: " + paramObject.ret);
          if (paramObject.ret != 0) {
            continue;
          }
          this.uyS.uyO.setValue(Boolean.TRUE);
          this.uyS.uyI.L(com.tencent.mm.plugin.eggspring.c.a.uxL);
        }
        catch (com.tencent.mm.plugin.eggspring.a paramObject)
        {
          d.a(this.uyS, paramObject);
          Log.w("MicroMsg.SpringLuckyEggViewModel", "Unable to accept money");
          continue;
        }
        paramObject = kotlin.x.aazN;
        AppMethodBeat.o(249660);
        return paramObject;
        this.uyS.uyI.L(com.tencent.mm.plugin.eggspring.c.a.uxM);
      }
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"})
  static final class c
    extends j
    implements m<ak, kotlin.d.d<? super kotlin.x>, Object>
  {
    Object L$0;
    int label;
    private ak p$;
    long uyU;
    
    c(d paramd, long paramLong, kotlin.d.d paramd1)
    {
      super(paramd1);
    }
    
    public final kotlin.d.d<kotlin.x> create(Object paramObject, kotlin.d.d<?> paramd)
    {
      AppMethodBeat.i(249344);
      kotlin.g.b.p.k(paramd, "completion");
      paramd = new c(this.uyS, this.uyV, paramd);
      paramd.p$ = ((ak)paramObject);
      AppMethodBeat.o(249344);
      return paramd;
    }
    
    public final Object invoke(Object paramObject1, Object paramObject2)
    {
      AppMethodBeat.i(249345);
      paramObject1 = ((c)create(paramObject1, (kotlin.d.d)paramObject2)).invokeSuspend(kotlin.x.aazN);
      AppMethodBeat.o(249345);
      return paramObject1;
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(249342);
      kotlin.d.a.a locala = kotlin.d.a.a.aaAA;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(249342);
        throw paramObject;
      case 0: 
        ResultKt.throwOnFailure(paramObject);
        localak = this.p$;
      }
      try
      {
        l = this.uyV;
        String str = d.d(this.uyS);
        paramObject = str;
        if (str == null) {
          paramObject = "";
        }
        paramObject = (c)new com.tencent.mm.plugin.eggspring.b.e("", l, paramObject);
        this.L$0 = localak;
        this.label = 1;
        paramObject = b.a(paramObject, this);
        if (paramObject != locala) {
          break label341;
        }
        AppMethodBeat.o(249342);
        return locala;
      }
      catch (com.tencent.mm.plugin.eggspring.a paramObject)
      {
        for (;;)
        {
          long l;
          Log.w("MicroMsg.SpringLuckyEggViewModel", "unable to accept money: " + paramObject.getMessage());
          this.uyS.uyH.setValue(Boolean.FALSE);
          this.uyS.uyO.setValue(Boolean.TRUE);
        }
      }
      finally
      {
        this.uyS.uyH.setValue(Boolean.FALSE);
        this.uyS.uyO.setValue(Boolean.TRUE);
        AppMethodBeat.o(249342);
      }
      ak localak = (ak)this.L$0;
      ResultKt.throwOnFailure(paramObject);
      label341:
      for (paramObject = localak;; paramObject = localak)
      {
        l = Util.milliSecondsToNow(d.e(this.uyS));
        if (l < 2000L)
        {
          this.L$0 = paramObject;
          this.uyU = l;
          this.label = 2;
          paramObject = aw.a(2000L - l, this);
          if (paramObject == locala)
          {
            AppMethodBeat.o(249342);
            return locala;
            ResultKt.throwOnFailure(paramObject);
          }
        }
        this.uyS.uyH.setValue(Boolean.FALSE);
        this.uyS.uyO.setValue(Boolean.TRUE);
        paramObject = kotlin.x.aazN;
        AppMethodBeat.o(249342);
        return paramObject;
      }
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"})
  static final class d
    extends j
    implements m<ak, kotlin.d.d<? super kotlin.x>, Object>
  {
    Object L$0;
    int label;
    Object oDA;
    private ak p$;
    
    d(d paramd, kotlin.d.d paramd1)
    {
      super(paramd1);
    }
    
    public final kotlin.d.d<kotlin.x> create(Object paramObject, kotlin.d.d<?> paramd)
    {
      AppMethodBeat.i(249352);
      kotlin.g.b.p.k(paramd, "completion");
      paramd = new d(this.uyS, paramd);
      paramd.p$ = ((ak)paramObject);
      AppMethodBeat.o(249352);
      return paramd;
    }
    
    public final Object invoke(Object paramObject1, Object paramObject2)
    {
      AppMethodBeat.i(249353);
      paramObject1 = ((d)create(paramObject1, (kotlin.d.d)paramObject2)).invokeSuspend(kotlin.x.aazN);
      AppMethodBeat.o(249353);
      return paramObject1;
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(249351);
      kotlin.d.a.a locala = kotlin.d.a.a.aaAA;
      Object localObject1;
      Object localObject2;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(249351);
        throw paramObject;
      case 0: 
        ResultKt.throwOnFailure(paramObject);
        paramObject = this.p$;
        Log.i("MicroMsg.SpringLuckyEggViewModel", "load egg");
        localObject1 = (kotlin.d.f)bc.iRs();
        localObject2 = (m)new a(this, null);
        this.L$0 = paramObject;
        this.label = 1;
        localObject2 = i.a((kotlin.d.f)localObject1, (m)localObject2, this);
        localObject1 = localObject2;
        if (localObject2 == locala)
        {
          AppMethodBeat.o(249351);
          return locala;
        }
      case 1: 
        localObject2 = (ak)this.L$0;
        ResultKt.throwOnFailure(paramObject);
        localObject1 = paramObject;
        paramObject = localObject2;
        localObject2 = (com.tencent.mm.be.e)localObject1;
        if (localObject2 != null) {}
        for (localObject1 = ((com.tencent.mm.be.e)localObject2).jIS; localObject1 == null; localObject1 = null)
        {
          Log.e("MicroMsg.SpringLuckyEggViewModel", "couldn't find the luck egg");
          this.uyS.uyI.setValue(com.tencent.mm.plugin.eggspring.c.a.uxO);
          paramObject = kotlin.x.aazN;
          AppMethodBeat.o(249351);
          return paramObject;
        }
        this.uyS.uyN.setValue(((com.tencent.mm.be.e)localObject2).jIS);
        this.uyS.uyJ.setValue(((com.tencent.mm.be.e)localObject2).jIS.lXE);
        d.a(this.uyS, ((com.tencent.mm.be.e)localObject2).jIS.appId);
        localObject1 = this.uyS;
        this.L$0 = paramObject;
        this.oDA = localObject2;
        this.label = 2;
        if (((d)localObject1).d(this) != locala) {
          break label283;
        }
        AppMethodBeat.o(249351);
        return locala;
      }
      ResultKt.throwOnFailure(paramObject);
      label283:
      paramObject = kotlin.x.aazN;
      AppMethodBeat.o(249351);
      return paramObject;
    }
    
    @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Lcom/tencent/mm/modelpackage/EggInfo;", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"})
    static final class a
      extends j
      implements m<ak, kotlin.d.d<? super com.tencent.mm.be.e>, Object>
    {
      int label;
      private ak p$;
      
      a(d.d paramd, kotlin.d.d paramd1)
      {
        super(paramd1);
      }
      
      public final kotlin.d.d<kotlin.x> create(Object paramObject, kotlin.d.d<?> paramd)
      {
        AppMethodBeat.i(249684);
        kotlin.g.b.p.k(paramd, "completion");
        paramd = new a(this.uyW, paramd);
        paramd.p$ = ((ak)paramObject);
        AppMethodBeat.o(249684);
        return paramd;
      }
      
      public final Object invoke(Object paramObject1, Object paramObject2)
      {
        AppMethodBeat.i(249685);
        paramObject1 = ((a)create(paramObject1, (kotlin.d.d)paramObject2)).invokeSuspend(kotlin.x.aazN);
        AppMethodBeat.o(249685);
        return paramObject1;
      }
      
      public final Object invokeSuspend(Object paramObject)
      {
        AppMethodBeat.i(249683);
        Object localObject1 = kotlin.d.a.a.aaAA;
        switch (this.label)
        {
        default: 
          paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
          AppMethodBeat.o(249683);
          throw paramObject;
        }
        ResultKt.throwOnFailure(paramObject);
        paramObject = com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.emoji.b.d.class);
        kotlin.g.b.p.j(paramObject, "MMKernel.plugin(IPluginEmoji::class.java)");
        paramObject = ((com.tencent.mm.plugin.emoji.b.d)paramObject).getEmojiMgr();
        kotlin.g.b.p.j(paramObject, "MMKernel.plugin(IPluginEmoji::class.java).emojiMgr");
        paramObject = paramObject.cUq().lXv;
        kotlin.g.b.p.j(paramObject, "eggList.eggList");
        localObject1 = ((Iterable)paramObject).iterator();
        label274:
        label277:
        while (((Iterator)localObject1).hasNext())
        {
          Object localObject2 = ((Iterator)localObject1).next();
          paramObject = (com.tencent.mm.be.e)localObject2;
          if ((paramObject.lXs >= 5) && (kotlin.g.b.p.h(paramObject.name, d.a(this.uyW.uyS))) && (paramObject.jIS != null) && (kotlin.g.b.p.h(paramObject.jIS.appId, d.b(this.uyW.uyS))))
          {
            paramObject = paramObject.lXn;
            kotlin.g.b.p.j(paramObject, "egg.keyWords");
            Iterator localIterator = ((Iterable)paramObject).iterator();
            while (localIterator.hasNext())
            {
              paramObject = localIterator.next();
              if (kotlin.g.b.p.h(((com.tencent.mm.be.f)paramObject).lXu, d.c(this.uyW.uyS))) {
                if (paramObject == null) {
                  break label274;
                }
              }
            }
          }
          for (int i = 1;; i = 0)
          {
            if (i == 0) {
              break label277;
            }
            AppMethodBeat.o(249683);
            return localObject2;
            paramObject = null;
            break;
          }
        }
        AppMethodBeat.o(249683);
        return null;
      }
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"loadMaterial", "", "continuation", "Lkotlin/coroutines/Continuation;", ""})
  static final class e
    extends kotlin.d.b.a.d
  {
    Object L$0;
    int label;
    
    e(d paramd, kotlin.d.d paramd1)
    {
      super();
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(249505);
      this.result = paramObject;
      this.label |= 0x80000000;
      paramObject = this.uyS.d(this);
      AppMethodBeat.o(249505);
      return paramObject;
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Lcom/tencent/mm/eggspring/model/GetInteractionMaterialResp;", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"})
  static final class f
    extends j
    implements m<ak, kotlin.d.d<? super com.tencent.mm.t.a.h>, Object>
  {
    Object L$0;
    int label;
    private ak p$;
    
    f(d paramd, kotlin.d.d paramd1)
    {
      super(paramd1);
    }
    
    public final kotlin.d.d<kotlin.x> create(Object paramObject, kotlin.d.d<?> paramd)
    {
      AppMethodBeat.i(249524);
      kotlin.g.b.p.k(paramd, "completion");
      paramd = new f(this.uyS, paramd);
      paramd.p$ = ((ak)paramObject);
      AppMethodBeat.o(249524);
      return paramd;
    }
    
    public final Object invoke(Object paramObject1, Object paramObject2)
    {
      AppMethodBeat.i(249525);
      paramObject1 = ((f)create(paramObject1, (kotlin.d.d)paramObject2)).invokeSuspend(kotlin.x.aazN);
      AppMethodBeat.o(249525);
      return paramObject1;
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(249523);
      kotlin.d.a.a locala = kotlin.d.a.a.aaAA;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(249523);
        throw paramObject;
      case 0: 
        ResultKt.throwOnFailure(paramObject);
        paramObject = this.p$;
        Object localObject = (c)new com.tencent.mm.plugin.eggspring.b.d(d.c(this.uyS), "", "");
        this.L$0 = paramObject;
        this.label = 1;
        localObject = b.a((c)localObject, this);
        paramObject = localObject;
        if (localObject == locala)
        {
          AppMethodBeat.o(249523);
          return locala;
        }
        break;
      case 1: 
        ResultKt.throwOnFailure(paramObject);
      }
      AppMethodBeat.o(249523);
      return paramObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.eggspring.ui.d
 * JD-Core Version:    0.7.0.1
 */