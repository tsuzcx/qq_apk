package com.tencent.mm.plugin.eggspring.ui;

import androidx.lifecycle.af;
import androidx.lifecycle.x;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelpackage.g;
import com.tencent.mm.r.a.n;
import com.tencent.mm.r.a.o;
import com.tencent.mm.r.a.p;
import com.tencent.mm.r.a.q;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.ah;
import kotlin.d.b.a.k;
import kotlin.d.d<-Lkotlin.ah;>;
import kotlin.g.b.s;
import kotlinx.coroutines.aq;
import kotlinx.coroutines.ar;
import kotlinx.coroutines.bb;
import kotlinx.coroutines.bg;
import kotlinx.coroutines.da;
import kotlinx.coroutines.dc;
import kotlinx.coroutines.j;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/eggspring/ui/SpringLuckyEggViewModel;", "Landroidx/lifecycle/ViewModel;", "eggName", "", "keyword", "appId", "traceId", "defaultBackgroundColor", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "acceptEvent", "Landroidx/lifecycle/MutableLiveData;", "Lcom/tencent/mm/plugin/eggspring/model/AcceptEvent;", "getAcceptEvent", "()Landroidx/lifecycle/MutableLiveData;", "acceptLink", "", "getAcceptLink", "accepted", "", "getAccepted", "backgroundColor", "getBackgroundColor", "bag", "Lcom/tencent/mm/modelpackage/LuckyBag;", "getBag", "bottomLink", "getBottomLink", "loading", "getLoading", "material", "Lcom/tencent/mm/eggspring/model/Material;", "getMaterial", "scope", "Lkotlinx/coroutines/CoroutineScope;", "startMills", "", "acceptCoupon", "", "stockId", "acceptEventHandled", "acceptMoney", "materialId", "amount", "loadEgg", "Lkotlinx/coroutines/Job;", "loadMaterial", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onCleared", "parseLink", "type", "", "info", "Lcom/tencent/mm/eggspring/model/MaterialPageInfo;", "sendAcceptError", "error", "Lcom/tencent/mm/plugin/eggspring/CgiException;", "Companion", "plugin-eggspring_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
  extends af
{
  public static final a xFn;
  private String appId;
  private final String hAB;
  String qTb;
  final aq scope;
  private final String xFo;
  final x<Boolean> xFp;
  final x<com.tencent.mm.plugin.eggspring.c.a> xFq;
  final x<String> xFr;
  final x<Object> xFs;
  final x<Object> xFt;
  final x<n> xFu;
  final x<com.tencent.mm.modelpackage.m> xFv;
  final x<Boolean> xFw;
  private final long xFx;
  
  static
  {
    AppMethodBeat.i(266630);
    xFn = new a((byte)0);
    AppMethodBeat.o(266630);
  }
  
  public c(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    AppMethodBeat.i(266566);
    this.xFo = paramString1;
    this.hAB = paramString2;
    this.appId = paramString3;
    this.qTb = paramString4;
    this.scope = ar.kBZ();
    this.xFp = new x();
    this.xFq = new x();
    this.xFr = new x();
    this.xFs = new x();
    this.xFt = new x();
    this.xFu = new x();
    this.xFv = new x();
    this.xFw = new x();
    this.xFx = Util.nowMilliSecond();
    this.xFr.setValue(paramString5);
    this.xFp.setValue(Boolean.TRUE);
    j.a(this.scope, null, null, (kotlin.g.a.m)new d(this, null), 3);
    AppMethodBeat.o(266566);
  }
  
  private static Object a(int paramInt, p paramp)
  {
    switch (paramInt)
    {
    case 6: 
    default: 
      return null;
    case 1: 
      return (com.tencent.mm.bx.a)paramp.mem;
    case 4: 
    case 5: 
      return (com.tencent.mm.bx.a)paramp.mep;
    case 3: 
      return (com.tencent.mm.bx.a)paramp.meo;
    case 2: 
      return (com.tencent.mm.bx.a)paramp.men;
    case 7: 
      return (com.tencent.mm.bx.a)paramp.meq;
    }
    return (com.tencent.mm.bx.a)paramp.mer;
  }
  
  private final Object ab(kotlin.d.d<? super ah> paramd)
  {
    AppMethodBeat.i(266588);
    if ((paramd instanceof e))
    {
      localObject1 = (e)paramd;
      if ((((e)localObject1).label & 0x80000000) != 0) {
        ((e)localObject1).label += -2147483648;
      }
    }
    Object localObject3;
    kotlin.d.a.a locala1;
    for (paramd = (kotlin.d.d<? super ah>)localObject1;; paramd = new e(this, paramd))
    {
      localObject3 = paramd.result;
      locala1 = kotlin.d.a.a.aiwj;
      switch (paramd.label)
      {
      default: 
        paramd = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(266588);
        throw paramd;
      }
    }
    ResultKt.throwOnFailure(localObject3);
    Object localObject1 = this;
    localObject2 = this;
    for (;;)
    {
      try
      {
        localObject3 = (kotlin.g.a.m)new f(this, null);
        localObject1 = this;
        localObject2 = this;
        paramd.L$0 = this;
        localObject1 = this;
        localObject2 = this;
        paramd.label = 1;
        localObject1 = this;
        localObject2 = this;
        paramd = dc.a(5000L, (kotlin.g.a.m)localObject3, paramd);
        localObject1 = paramd;
        localObject3 = localObject1;
        paramd = this;
        if (localObject1 == locala1)
        {
          AppMethodBeat.o(266588);
          return locala1;
          paramd = (c)paramd.L$0;
        }
        int i;
        long l;
        localObject1 = ((o)localObject1).mel;
      }
      catch (com.tencent.mm.plugin.eggspring.a paramd)
      {
        try
        {
          ResultKt.throwOnFailure(localObject3);
          localObject1 = paramd;
          localObject2 = paramd;
          localObject3 = (com.tencent.mm.r.a.h)localObject3;
          paramd.qTb = ((com.tencent.mm.r.a.h)localObject3).mdH;
          localObject1 = ((com.tencent.mm.r.a.h)localObject3).mdJ;
          paramd.xFu.setValue(localObject1);
          Log.i("MicroMsg.SpringLuckyEggViewModel", "got material success, type=" + ((n)localObject1).mdP + ", traceId=" + paramd.qTb);
          localObject2 = paramd.xFs;
          i = ((n)localObject1).mdV;
          localObject3 = ((n)localObject1).mdW;
          s.s(localObject3, "material.link_page");
          ((x)localObject2).setValue(a(i, (p)localObject3));
          localObject2 = paramd.xFt;
          i = ((n)localObject1).mdS;
          localObject3 = ((n)localObject1).mdT;
          s.s(localObject3, "material.button_page");
          ((x)localObject2).setValue(a(i, (p)localObject3));
          if (!a.b((n)localObject1)) {
            break label596;
          }
          l = ((n)localObject1).mea;
          localObject1 = ((n)localObject1).meb;
          if (localObject1 != null) {
            break label552;
          }
          localObject1 = "";
          Log.i("MicroMsg.SpringLuckyEggViewModel", "accept materialId=" + l + ", amount=" + (String)localObject1);
          j.a(paramd.scope, null, null, (kotlin.g.a.m)new c(l, paramd, null), 3);
          paramd = ah.aiuX;
          AppMethodBeat.o(266588);
          return paramd;
        }
        catch (da localda)
        {
          localObject2 = paramd;
          paramd = localda;
          continue;
        }
        catch (com.tencent.mm.plugin.eggspring.a locala)
        {
          kotlin.d.d<? super ah> locald = paramd;
          paramd = locala;
          continue;
        }
        paramd = paramd;
        Log.w("MicroMsg.SpringLuckyEggViewModel", s.X("Unable to fetch material: ", paramd.getMessage()));
        ((c)localObject1).xFq.setValue(com.tencent.mm.plugin.eggspring.c.a.xEz);
        paramd = ah.aiuX;
        AppMethodBeat.o(266588);
        return paramd;
      }
      catch (da paramd)
      {
        Log.w("MicroMsg.SpringLuckyEggViewModel", s.X("Timeout to fetch material: ", paramd.getMessage()));
        ((c)localObject2).xFq.setValue(com.tencent.mm.plugin.eggspring.c.a.xEz);
        paramd = ah.aiuX;
        AppMethodBeat.o(266588);
        return paramd;
      }
      label552:
      if (localObject1 == null)
      {
        localObject1 = "";
      }
      else
      {
        localObject2 = ((q)localObject1).mes;
        localObject1 = localObject2;
        if (localObject2 == null)
        {
          localObject1 = "";
          continue;
          label596:
          paramd.xFp.setValue(Boolean.FALSE);
        }
      }
    }
  }
  
  public final void onCleared()
  {
    AppMethodBeat.i(266635);
    super.onCleared();
    Log.i("MicroMsg.SpringLuckyEggViewModel", "onCleared()");
    ar.a(this.scope, null);
    AppMethodBeat.o(266635);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/eggspring/ui/SpringLuckyEggViewModel$Companion;", "", "()V", "LOAD_MATERIAL_TIMEOUT", "", "TAG", "", "plugin-eggspring_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends k
    implements kotlin.g.a.m<aq, kotlin.d.d<? super ah>, Object>
  {
    int label;
    
    b(String paramString1, String paramString2, c paramc, kotlin.d.d<? super b> paramd)
    {
      super(paramd);
    }
    
    public final kotlin.d.d<ah> create(Object paramObject, kotlin.d.d<?> paramd)
    {
      AppMethodBeat.i(266553);
      paramObject = (kotlin.d.d)new b(this.eug, this.xFy, this.xFz, paramd);
      AppMethodBeat.o(266553);
      return paramObject;
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(266548);
      kotlin.d.a.a locala = kotlin.d.a.a.aiwj;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(266548);
        throw paramObject;
      case 0: 
        ResultKt.throwOnFailure(paramObject);
      }
      for (;;)
      {
        try
        {
          String str1 = this.eug;
          String str2 = this.xFy;
          Object localObject = c.d(this.xFz);
          paramObject = localObject;
          if (localObject == null) {
            paramObject = "";
          }
          paramObject = (com.tencent.mm.am.b)new com.tencent.mm.plugin.eggspring.b.a(str1, str2, "CNY_EXPRESSION", paramObject);
          localObject = (kotlin.d.d)this;
          this.label = 1;
          paramObject = com.tencent.mm.plugin.eggspring.b.b(paramObject, (kotlin.d.d)localObject);
          localObject = paramObject;
          if (paramObject == locala)
          {
            AppMethodBeat.o(266548);
            return locala;
            ResultKt.throwOnFailure(paramObject);
            localObject = paramObject;
          }
          paramObject = (com.tencent.mm.r.a.l)localObject;
          Log.w("MicroMsg.SpringLuckyEggViewModel", s.X("accept coupon result: ", Integer.valueOf(paramObject.ret)));
          if (paramObject.ret != 0) {
            continue;
          }
          this.xFz.xFw.setValue(Boolean.TRUE);
          this.xFz.xFq.t(com.tencent.mm.plugin.eggspring.c.a.xEw);
        }
        catch (com.tencent.mm.plugin.eggspring.a paramObject)
        {
          c.a(this.xFz, paramObject);
          Log.w("MicroMsg.SpringLuckyEggViewModel", "Unable to accept money");
          continue;
        }
        paramObject = ah.aiuX;
        AppMethodBeat.o(266548);
        return paramObject;
        this.xFz.xFq.t(com.tencent.mm.plugin.eggspring.c.a.xEx);
      }
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends k
    implements kotlin.g.a.m<aq, kotlin.d.d<? super ah>, Object>
  {
    int label;
    
    c(long paramLong, c paramc, kotlin.d.d<? super c> paramd)
    {
      super(paramd);
    }
    
    public final kotlin.d.d<ah> create(Object paramObject, kotlin.d.d<?> paramd)
    {
      AppMethodBeat.i(266554);
      paramObject = (kotlin.d.d)new c(this.xFA, this.xFz, paramd);
      AppMethodBeat.o(266554);
      return paramObject;
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(266549);
      kotlin.d.a.a locala = kotlin.d.a.a.aiwj;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(266549);
        throw paramObject;
      case 0: 
        ResultKt.throwOnFailure(paramObject);
      }
      try
      {
        long l = this.xFA;
        Object localObject = c.d(this.xFz);
        paramObject = localObject;
        if (localObject == null) {
          paramObject = "";
        }
        paramObject = (com.tencent.mm.am.b)new com.tencent.mm.plugin.eggspring.b.e("", l, paramObject);
        localObject = (kotlin.d.d)this;
        this.label = 1;
        paramObject = com.tencent.mm.plugin.eggspring.b.b(paramObject, (kotlin.d.d)localObject);
        if (paramObject == locala)
        {
          AppMethodBeat.o(266549);
          return locala;
          ResultKt.throwOnFailure(paramObject);
        }
        l = Util.milliSecondsToNow(c.e(this.xFz));
        if (l < 2000L)
        {
          paramObject = (kotlin.d.d)this;
          this.label = 2;
          paramObject = bb.e(2000L - l, paramObject);
          if (paramObject == locala)
          {
            AppMethodBeat.o(266549);
            return locala;
            ResultKt.throwOnFailure(paramObject);
          }
        }
        this.xFz.xFp.setValue(Boolean.FALSE);
        this.xFz.xFw.setValue(Boolean.TRUE);
      }
      catch (com.tencent.mm.plugin.eggspring.a paramObject)
      {
        for (;;)
        {
          Log.w("MicroMsg.SpringLuckyEggViewModel", s.X("unable to accept money: ", paramObject.getMessage()));
          this.xFz.xFp.setValue(Boolean.FALSE);
          this.xFz.xFw.setValue(Boolean.TRUE);
        }
      }
      finally
      {
        this.xFz.xFp.setValue(Boolean.FALSE);
        this.xFz.xFw.setValue(Boolean.TRUE);
        AppMethodBeat.o(266549);
      }
      paramObject = ah.aiuX;
      AppMethodBeat.o(266549);
      return paramObject;
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends k
    implements kotlin.g.a.m<aq, kotlin.d.d<? super ah>, Object>
  {
    int label;
    
    d(c paramc, kotlin.d.d<? super d> paramd)
    {
      super(paramd);
    }
    
    public final kotlin.d.d<ah> create(Object paramObject, kotlin.d.d<?> paramd)
    {
      AppMethodBeat.i(266542);
      paramObject = (kotlin.d.d)new d(this.xFz, paramd);
      AppMethodBeat.o(266542);
      return paramObject;
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(266539);
      kotlin.d.a.a locala = kotlin.d.a.a.aiwj;
      Object localObject;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(266539);
        throw paramObject;
      case 0: 
        ResultKt.throwOnFailure(paramObject);
        Log.i("MicroMsg.SpringLuckyEggViewModel", "load egg");
        paramObject = (kotlin.d.f)bg.kCi();
        localObject = (kotlin.g.a.m)new a(this.xFz, null);
        kotlin.d.d locald = (kotlin.d.d)this;
        this.label = 1;
        localObject = kotlinx.coroutines.l.a(paramObject, (kotlin.g.a.m)localObject, locald);
        paramObject = localObject;
        if (localObject == locala)
        {
          AppMethodBeat.o(266539);
          return locala;
        }
      case 1: 
        ResultKt.throwOnFailure(paramObject);
        localObject = (com.tencent.mm.modelpackage.e)paramObject;
        if (localObject == null) {}
        for (paramObject = null; paramObject == null; paramObject = ((com.tencent.mm.modelpackage.e)localObject).mij)
        {
          Log.e("MicroMsg.SpringLuckyEggViewModel", "couldn't find the luck egg");
          this.xFz.xFq.setValue(com.tencent.mm.plugin.eggspring.c.a.xEz);
          paramObject = ah.aiuX;
          AppMethodBeat.o(266539);
          return paramObject;
        }
        this.xFz.xFv.setValue(((com.tencent.mm.modelpackage.e)localObject).mij);
        this.xFz.xFr.setValue(((com.tencent.mm.modelpackage.e)localObject).mij.oQI);
        c.a(this.xFz, ((com.tencent.mm.modelpackage.e)localObject).mij.appId);
        paramObject = this.xFz;
        localObject = (kotlin.d.d)this;
        this.label = 2;
        if (c.a(paramObject, (kotlin.d.d)localObject) != locala) {
          break label262;
        }
        AppMethodBeat.o(266539);
        return locala;
      }
      ResultKt.throwOnFailure(paramObject);
      label262:
      paramObject = ah.aiuX;
      AppMethodBeat.o(266539);
      return paramObject;
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/modelpackage/EggInfo;", "Lkotlinx/coroutines/CoroutineScope;"}, k=3, mv={1, 5, 1}, xi=48)
    static final class a
      extends k
      implements kotlin.g.a.m<aq, kotlin.d.d<? super com.tencent.mm.modelpackage.e>, Object>
    {
      int label;
      
      a(c paramc, kotlin.d.d<? super a> paramd)
      {
        super(paramd);
      }
      
      public final kotlin.d.d<ah> create(Object paramObject, kotlin.d.d<?> paramd)
      {
        AppMethodBeat.i(266564);
        paramObject = (kotlin.d.d)new a(this.xFz, paramd);
        AppMethodBeat.o(266564);
        return paramObject;
      }
      
      public final Object invokeSuspend(Object paramObject)
      {
        AppMethodBeat.i(266560);
        Object localObject1 = kotlin.d.a.a.aiwj;
        switch (this.label)
        {
        default: 
          paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
          AppMethodBeat.o(266560);
          throw paramObject;
        }
        ResultKt.throwOnFailure(paramObject);
        paramObject = ((com.tencent.mm.plugin.emoji.c.d)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.emoji.c.d.class)).getEmojiMgr().dzx().oQz;
        s.s(paramObject, "eggList.eggList");
        paramObject = (Iterable)paramObject;
        localObject1 = this.xFz;
        Iterator localIterator1 = paramObject.iterator();
        label250:
        label253:
        while (localIterator1.hasNext())
        {
          Object localObject2 = localIterator1.next();
          paramObject = (com.tencent.mm.modelpackage.e)localObject2;
          if ((paramObject.oQu >= 5) && (s.p(paramObject.name, c.b((c)localObject1))) && (paramObject.mij != null) && (s.p(paramObject.mij.appId, c.c((c)localObject1))))
          {
            paramObject = paramObject.oQp;
            s.s(paramObject, "egg.keyWords");
            Iterator localIterator2 = ((Iterable)paramObject).iterator();
            while (localIterator2.hasNext())
            {
              paramObject = localIterator2.next();
              if (s.p(((com.tencent.mm.modelpackage.f)paramObject).oQy, c.a((c)localObject1))) {
                if (paramObject == null) {
                  break label250;
                }
              }
            }
          }
          for (int i = 1;; i = 0)
          {
            if (i == 0) {
              break label253;
            }
            AppMethodBeat.o(266560);
            return localObject2;
            paramObject = null;
            break;
          }
        }
        AppMethodBeat.o(266560);
        return null;
      }
    }
  }
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  static final class e
    extends kotlin.d.b.a.d
  {
    Object L$0;
    int label;
    
    e(c paramc, kotlin.d.d<? super e> paramd)
    {
      super();
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(266536);
      this.result = paramObject;
      this.label |= 0x80000000;
      paramObject = c.a(this.xFz, (kotlin.d.d)this);
      AppMethodBeat.o(266536);
      return paramObject;
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/eggspring/model/GetInteractionMaterialResp;", "Lkotlinx/coroutines/CoroutineScope;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class f
    extends k
    implements kotlin.g.a.m<aq, kotlin.d.d<? super com.tencent.mm.r.a.h>, Object>
  {
    int label;
    
    f(c paramc, kotlin.d.d<? super f> paramd)
    {
      super(paramd);
    }
    
    public final kotlin.d.d<ah> create(Object paramObject, kotlin.d.d<?> paramd)
    {
      AppMethodBeat.i(266551);
      paramObject = (kotlin.d.d)new f(this.xFz, paramd);
      AppMethodBeat.o(266551);
      return paramObject;
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(266543);
      kotlin.d.a.a locala = kotlin.d.a.a.aiwj;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(266543);
        throw paramObject;
      case 0: 
        ResultKt.throwOnFailure(paramObject);
        paramObject = (com.tencent.mm.am.b)new com.tencent.mm.plugin.eggspring.b.d(c.a(this.xFz), "", "");
        Object localObject = (kotlin.d.d)this;
        this.label = 1;
        localObject = com.tencent.mm.plugin.eggspring.b.b(paramObject, (kotlin.d.d)localObject);
        paramObject = localObject;
        if (localObject == locala)
        {
          AppMethodBeat.o(266543);
          return locala;
        }
        break;
      case 1: 
        ResultKt.throwOnFailure(paramObject);
      }
      AppMethodBeat.o(266543);
      return paramObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.eggspring.ui.c
 * JD-Core Version:    0.7.0.1
 */