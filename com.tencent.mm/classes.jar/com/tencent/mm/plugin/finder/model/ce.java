package com.tencent.mm.plugin.finder.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.findersdk.a.ck;
import com.tencent.mm.protocal.protobuf.aux;
import com.tencent.mm.protocal.protobuf.bqe;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.component.e;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.ah;
import kotlin.d.a.a;
import kotlin.d.b.a.k;
import kotlin.d.d;
import kotlin.g.a.m;
import kotlin.g.b.s;
import kotlin.r;
import kotlinx.coroutines.aq;
import kotlinx.coroutines.ar;
import kotlinx.coroutines.ay;
import kotlinx.coroutines.j;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/model/SetProfileCoverViewModel;", "Lcom/tencent/mm/ui/component/CoroutineViewModel;", "()V", "modifyResultListener", "Lcom/tencent/mm/plugin/findersdk/api/IModifyUserResult;", "Lcom/tencent/mm/protocal/protobuf/FinderModUserInfo;", "extractColor", "", "coverPath", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "mainLaunch", "Lkotlinx/coroutines/Job;", "context", "Lkotlin/coroutines/CoroutineContext;", "start", "Lkotlinx/coroutines/CoroutineStart;", "block", "Lkotlin/Function2;", "Lkotlinx/coroutines/CoroutineScope;", "Lkotlin/coroutines/Continuation;", "", "", "Lkotlin/ExtensionFunctionType;", "(Lkotlin/coroutines/CoroutineContext;Lkotlinx/coroutines/CoroutineStart;Lkotlin/jvm/functions/Function2;)Lkotlinx/coroutines/Job;", "modifyProfileCover", "Lkotlin/Pair;", "coverUrl", "modifyProfileCoverDirect", "uploadedUrl", "action", "Lcom/tencent/mm/plugin/finder/model/SetProfileCoverViewModel$ISettingProfileCoverAction;", "onCleared", "setProfileCover", "unSetProfileCover", "uploadCover", "Companion", "ISettingProfileCoverAction", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class ce
  extends e
{
  public static final ce.a EDJ;
  private ck<bqe> EDK;
  
  static
  {
    AppMethodBeat.i(332008);
    EDJ = new ce.a((byte)0);
    AppMethodBeat.o(332008);
  }
  
  public final void onCleared()
  {
    AppMethodBeat.i(332017);
    super.onCleared();
    ar.a(getLifecycleScope(), this + " onCleared.");
    ar.a(getMainScope(), this + " onCleared.");
    this.EDK = null;
    AppMethodBeat.o(332017);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/model/SetProfileCoverViewModel$ISettingProfileCoverAction;", "", "onSetCover", "", "coverUrl", "", "extractColor", "", "retCode", "hintMsg", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static abstract interface b
  {
    public abstract void l(String paramString1, int paramInt1, int paramInt2, String paramString2);
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/model/SetProfileCoverViewModel$modifyProfileCoverDirect$1", "Lcom/tencent/mm/plugin/findersdk/api/IModifyUserResult;", "Lcom/tencent/mm/protocal/protobuf/FinderModUserInfo;", "onModifyResult", "", "req", "ret", "Lcom/tencent/mm/protocal/protobuf/FinderCmdRet;", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class e
    implements ck<bqe>
  {
    e(ce paramce, ce.b paramb, String paramString, int paramInt) {}
    
    @Metadata(d1={""}, d2={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k=3, mv={1, 5, 1}, xi=48)
    static final class a
      extends k
      implements m<aq, d<? super ah>, Object>
    {
      int label;
      
      a(ce.b paramb, String paramString, int paramInt, aux paramaux, d<? super a> paramd)
      {
        super(paramd);
      }
      
      public final d<ah> create(Object paramObject, d<?> paramd)
      {
        AppMethodBeat.i(332242);
        paramObject = (d)new a(this.EDN, this.EDO, this.EDP, this.EDQ, paramd);
        AppMethodBeat.o(332242);
        return paramObject;
      }
      
      public final Object invokeSuspend(Object paramObject)
      {
        AppMethodBeat.i(332233);
        a locala = a.aiwj;
        switch (this.label)
        {
        default: 
          paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
          AppMethodBeat.o(332233);
          throw paramObject;
        }
        ResultKt.throwOnFailure(paramObject);
        this.EDN.l(this.EDO, this.EDP, this.EDQ.retCode, this.EDQ.wZb);
        paramObject = ah.aiuX;
        AppMethodBeat.o(332233);
        return paramObject;
      }
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k=3, mv={1, 5, 1}, xi=48)
  public static final class f
    extends k
    implements m<aq, d<? super ah>, Object>
  {
    int label;
    
    public f(String paramString, ce paramce, ce.b paramb, d<? super f> paramd)
    {
      super(paramd);
    }
    
    public final d<ah> create(Object paramObject, d<?> paramd)
    {
      AppMethodBeat.i(332027);
      paramd = new f(this.EDR, this.EDM, this.EDN, paramd);
      paramd.L$0 = paramObject;
      paramObject = (d)paramd;
      AppMethodBeat.o(332027);
      return paramObject;
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(332020);
      a locala = a.aiwj;
      Object localObject2;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(332020);
        throw paramObject;
      case 0: 
        ResultKt.throwOnFailure(paramObject);
        paramObject = (aq)this.L$0;
        Log.i("Finder.SetProfileCoverViewModel", s.X("setProfileCover :", this.EDR));
        localObject1 = j.a(paramObject, null, (m)new b(this.EDM, this.EDR, null), 3);
        paramObject = j.a(paramObject, null, (m)new a(this.EDM, this.EDR, null), 3);
        Log.i("Finder.SetProfileCoverViewModel", "setProfileCover await begin");
        localObject2 = (d)this;
        this.L$0 = paramObject;
        this.label = 1;
        localObject2 = ((ay)localObject1).e((d)localObject2);
        localObject1 = localObject2;
        if (localObject2 == locala)
        {
          AppMethodBeat.o(332020);
          return locala;
        }
      case 1: 
        localObject2 = (ay)this.L$0;
        ResultKt.throwOnFailure(paramObject);
        localObject1 = paramObject;
        paramObject = localObject2;
        localObject1 = (String)localObject1;
        Log.i("Finder.SetProfileCoverViewModel", "setProfileCover await 1");
        localObject2 = (d)this;
        this.L$0 = localObject1;
        this.label = 2;
        paramObject = paramObject.e((d)localObject2);
        if (paramObject != locala) {
          break label387;
        }
        AppMethodBeat.o(332020);
        return locala;
      }
      Object localObject1 = (String)this.L$0;
      ResultKt.throwOnFailure(paramObject);
      label387:
      for (;;)
      {
        int i = ((Number)paramObject).intValue();
        paramObject = Integer.toHexString(i);
        Log.i("Finder.SetProfileCoverViewModel", "setProfileCover await 2");
        Log.i("Finder.SetProfileCoverViewModel", "uploadedUrl :" + (String)localObject1 + " extractColor :" + i + " hexColor:" + paramObject);
        if (!Util.isNullOrNil((String)localObject1)) {}
        for (paramObject = (String)localObject1 + "&bgColor=" + paramObject;; paramObject = "")
        {
          ce.a(this.EDM, paramObject, i, this.EDN);
          paramObject = ah.aiuX;
          AppMethodBeat.o(332020);
          return paramObject;
        }
      }
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k=3, mv={1, 5, 1}, xi=48)
    static final class a
      extends k
      implements m<aq, d<? super Integer>, Object>
    {
      int label;
      
      a(ce paramce, String paramString, d<? super a> paramd)
      {
        super(paramd);
      }
      
      public final d<ah> create(Object paramObject, d<?> paramd)
      {
        AppMethodBeat.i(332006);
        paramObject = (d)new a(this.EDM, this.EDR, paramd);
        AppMethodBeat.o(332006);
        return paramObject;
      }
      
      public final Object invokeSuspend(Object paramObject)
      {
        AppMethodBeat.i(331996);
        a locala = a.aiwj;
        switch (this.label)
        {
        default: 
          paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
          AppMethodBeat.o(331996);
          throw paramObject;
        case 0: 
          ResultKt.throwOnFailure(paramObject);
          paramObject = this.EDR;
          this.label = 1;
          Object localObject = ce.ayS(paramObject);
          paramObject = localObject;
          if (localObject == locala)
          {
            AppMethodBeat.o(331996);
            return locala;
          }
          break;
        case 1: 
          ResultKt.throwOnFailure(paramObject);
        }
        AppMethodBeat.o(331996);
        return paramObject;
      }
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k=3, mv={1, 5, 1}, xi=48)
    static final class b
      extends k
      implements m<aq, d<? super String>, Object>
    {
      int label;
      
      b(ce paramce, String paramString, d<? super b> paramd)
      {
        super(paramd);
      }
      
      public final d<ah> create(Object paramObject, d<?> paramd)
      {
        AppMethodBeat.i(331979);
        paramObject = (d)new b(this.EDM, this.EDR, paramd);
        AppMethodBeat.o(331979);
        return paramObject;
      }
      
      public final Object invokeSuspend(Object paramObject)
      {
        AppMethodBeat.i(331973);
        a locala = a.aiwj;
        switch (this.label)
        {
        default: 
          paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
          AppMethodBeat.o(331973);
          throw paramObject;
        case 0: 
          ResultKt.throwOnFailure(paramObject);
          paramObject = this.EDR;
          Object localObject = (d)this;
          this.label = 1;
          localObject = ce.l(paramObject, (d)localObject);
          paramObject = localObject;
          if (localObject == locala)
          {
            AppMethodBeat.o(331973);
            return locala;
          }
          break;
        case 1: 
          ResultKt.throwOnFailure(paramObject);
        }
        AppMethodBeat.o(331973);
        return paramObject;
      }
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k=3, mv={1, 5, 1}, xi=48)
  public static final class g
    extends k
    implements m<aq, d<? super ah>, Object>
  {
    int label;
    
    public g(ce paramce, ce.b paramb, d<? super g> paramd)
    {
      super(paramd);
    }
    
    public final d<ah> create(Object paramObject, d<?> paramd)
    {
      AppMethodBeat.i(332133);
      paramObject = (d)new g(this.EDM, this.EDN, paramd);
      AppMethodBeat.o(332133);
      return paramObject;
    }
    
    public final Object invokeSuspend(final Object paramObject)
    {
      AppMethodBeat.i(332125);
      a locala = a.aiwj;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(332125);
        throw paramObject;
      case 0: 
        ResultKt.throwOnFailure(paramObject);
        paramObject = this.EDM;
        Object localObject = (d)this;
        this.label = 1;
        localObject = ce.a(paramObject, "", (d)localObject);
        paramObject = localObject;
        if (localObject == locala)
        {
          AppMethodBeat.o(332125);
          return locala;
        }
        break;
      case 1: 
        ResultKt.throwOnFailure(paramObject);
      }
      paramObject = (r)paramObject;
      ce.a(this.EDM, (m)new k(this.EDN, paramObject)
      {
        int label;
        
        public final d<ah> create(Object paramAnonymousObject, d<?> paramAnonymousd)
        {
          AppMethodBeat.i(331849);
          paramAnonymousObject = (d)new 1(this.EDN, paramObject, paramAnonymousd);
          AppMethodBeat.o(331849);
          return paramAnonymousObject;
        }
        
        public final Object invokeSuspend(Object paramAnonymousObject)
        {
          AppMethodBeat.i(331843);
          a locala = a.aiwj;
          switch (this.label)
          {
          default: 
            paramAnonymousObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            AppMethodBeat.o(331843);
            throw paramAnonymousObject;
          }
          ResultKt.throwOnFailure(paramAnonymousObject);
          this.EDN.l("", 0, ((Number)paramObject.bsC).intValue(), (String)paramObject.bsD);
          paramAnonymousObject = ah.aiuX;
          AppMethodBeat.o(331843);
          return paramAnonymousObject;
        }
      });
      paramObject = ah.aiuX;
      AppMethodBeat.o(332125);
      return paramObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.model.ce
 * JD-Core Version:    0.7.0.1
 */