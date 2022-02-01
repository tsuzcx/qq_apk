package androidx.compose.b.a;

import androidx.compose.a.a.b;
import androidx.compose.a.a.h;
import androidx.compose.a.a.l;
import androidx.compose.runtime.an;
import androidx.compose.runtime.bj;
import androidx.compose.ui.d.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.ah;
import kotlin.d.b.a.k;
import kotlin.g.a.m;
import kotlinx.coroutines.ab;
import kotlinx.coroutines.aq;
import kotlinx.coroutines.ar;
import kotlinx.coroutines.cb;
import kotlinx.coroutines.j;

@Metadata(d1={""}, d2={"Landroidx/compose/material/ripple/RippleAnimation;", "", "origin", "Landroidx/compose/ui/geometry/Offset;", "radius", "Landroidx/compose/ui/unit/Dp;", "bounded", "", "(Landroidx/compose/ui/geometry/Offset;FZLkotlin/jvm/internal/DefaultConstructorMarker;)V", "animatedAlpha", "Landroidx/compose/animation/core/Animatable;", "", "Landroidx/compose/animation/core/AnimationVector1D;", "animatedCenterPercent", "animatedRadiusPercent", "<set-?>", "finishRequested", "getFinishRequested", "()Z", "setFinishRequested", "(Z)V", "finishRequested$delegate", "Landroidx/compose/runtime/MutableState;", "finishSignalDeferred", "Lkotlinx/coroutines/CompletableDeferred;", "", "finishedFadingIn", "getFinishedFadingIn", "setFinishedFadingIn", "finishedFadingIn$delegate", "F", "startRadius", "Ljava/lang/Float;", "targetCenter", "targetRadius", "animate", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "fadeIn", "fadeOut", "finish", "draw", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "color", "Landroidx/compose/ui/graphics/Color;", "draw-4WTKRHQ", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;J)V", "material-ripple_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class g
{
  final boolean ajS;
  e ako;
  Float akp;
  Float akq;
  e akr;
  final androidx.compose.a.a.a<Float, l> aks;
  final androidx.compose.a.a.a<Float, l> akt;
  final androidx.compose.a.a.a<Float, l> aku;
  private final kotlinx.coroutines.z<ah> akv;
  final an akw;
  final an akx;
  final float radius;
  
  private g(e parame, float paramFloat, boolean paramBoolean)
  {
    AppMethodBeat.i(201830);
    this.ako = parame;
    this.radius = paramFloat;
    this.ajS = paramBoolean;
    this.aks = b.lB();
    this.akt = b.lB();
    this.aku = b.lB();
    this.akv = ab.kBT();
    this.akw = bj.T(Boolean.FALSE);
    this.akx = bj.T(Boolean.FALSE);
    AppMethodBeat.o(201830);
  }
  
  private final Object c(kotlin.d.d<? super ah> paramd)
  {
    AppMethodBeat.i(201843);
    paramd = ar.c((m)new b(this, null), paramd);
    if (paramd == kotlin.d.a.a.aiwj)
    {
      AppMethodBeat.o(201843);
      return paramd;
    }
    paramd = ah.aiuX;
    AppMethodBeat.o(201843);
    return paramd;
  }
  
  private final Object d(kotlin.d.d<? super ah> paramd)
  {
    AppMethodBeat.i(201847);
    paramd = ar.c((m)new c(this, null), paramd);
    if (paramd == kotlin.d.a.a.aiwj)
    {
      AppMethodBeat.o(201847);
      return paramd;
    }
    paramd = ah.aiuX;
    AppMethodBeat.o(201847);
    return paramd;
  }
  
  private final void nE()
  {
    AppMethodBeat.i(201833);
    this.akw.setValue(Boolean.TRUE);
    AppMethodBeat.o(201833);
  }
  
  private final void nF()
  {
    AppMethodBeat.i(201838);
    this.akx.setValue(Boolean.TRUE);
    AppMethodBeat.o(201838);
  }
  
  public final Object b(kotlin.d.d<? super ah> paramd)
  {
    AppMethodBeat.i(201856);
    a locala;
    if ((paramd instanceof a))
    {
      locala = (a)paramd;
      if ((locala.label & 0x80000000) != 0) {
        locala.label += -2147483648;
      }
    }
    kotlin.d.a.a locala1;
    for (;;)
    {
      localObject = locala.result;
      locala1 = kotlin.d.a.a.aiwj;
      switch (locala.label)
      {
      default: 
        paramd = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(201856);
        throw paramd;
        locala = new a(this, paramd);
      }
    }
    ResultKt.throwOnFailure(localObject);
    locala.L$0 = this;
    locala.label = 1;
    paramd = this;
    if (c(locala) == locala1)
    {
      AppMethodBeat.o(201856);
      return locala1;
      paramd = (g)locala.L$0;
      ResultKt.throwOnFailure(localObject);
    }
    paramd.nE();
    Object localObject = paramd.akv;
    locala.L$0 = paramd;
    locala.label = 2;
    if (((kotlinx.coroutines.z)localObject).e(locala) == locala1)
    {
      AppMethodBeat.o(201856);
      return locala1;
      paramd = (g)locala.L$0;
      ResultKt.throwOnFailure(localObject);
    }
    locala.L$0 = null;
    locala.label = 3;
    if (paramd.d(locala) == locala1)
    {
      AppMethodBeat.o(201856);
      return locala1;
      ResultKt.throwOnFailure(localObject);
    }
    paramd = ah.aiuX;
    AppMethodBeat.o(201856);
    return paramd;
  }
  
  public final void finish()
  {
    AppMethodBeat.i(201861);
    nF();
    this.akv.iC(ah.aiuX);
    AppMethodBeat.o(201861);
  }
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends kotlin.d.b.a.d
  {
    Object L$0;
    int label;
    
    a(g paramg, kotlin.d.d<? super a> paramd)
    {
      super();
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(201752);
      this.result = paramObject;
      this.label |= 0x80000000;
      paramObject = this.aky.b((kotlin.d.d)this);
      AppMethodBeat.o(201752);
      return paramObject;
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lkotlinx/coroutines/Job;", "Lkotlinx/coroutines/CoroutineScope;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends k
    implements m<aq, kotlin.d.d<? super cb>, Object>
  {
    int label;
    
    b(g paramg, kotlin.d.d<? super b> paramd)
    {
      super(paramd);
    }
    
    public final kotlin.d.d<ah> create(Object paramObject, kotlin.d.d<?> paramd)
    {
      AppMethodBeat.i(201770);
      paramd = new b(this.aky, paramd);
      paramd.L$0 = paramObject;
      paramObject = (kotlin.d.d)paramd;
      AppMethodBeat.o(201770);
      return paramObject;
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(201764);
      kotlin.d.a.a locala = kotlin.d.a.a.aiwj;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(201764);
        throw paramObject;
      }
      ResultKt.throwOnFailure(paramObject);
      paramObject = (aq)this.L$0;
      j.a(paramObject, null, null, (m)new k(this.aky, null)
      {
        int label;
        
        public final kotlin.d.d<ah> create(Object paramAnonymousObject, kotlin.d.d<?> paramAnonymousd)
        {
          AppMethodBeat.i(201802);
          paramAnonymousObject = (kotlin.d.d)new 1(this.aky, paramAnonymousd);
          AppMethodBeat.o(201802);
          return paramAnonymousObject;
        }
        
        public final Object invokeSuspend(Object paramAnonymousObject)
        {
          AppMethodBeat.i(201794);
          kotlin.d.a.a locala = kotlin.d.a.a.aiwj;
          switch (this.label)
          {
          default: 
            paramAnonymousObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            AppMethodBeat.o(201794);
            throw paramAnonymousObject;
          case 0: 
            ResultKt.throwOnFailure(paramAnonymousObject);
            paramAnonymousObject = this.aky.aks;
            androidx.compose.a.a.g localg = (androidx.compose.a.a.g)h.a(75, androidx.compose.a.a.z.lM(), 2);
            kotlin.d.d locald = (kotlin.d.d)this;
            this.label = 1;
            if (androidx.compose.a.a.a.a(paramAnonymousObject, Float.valueOf(1.0F), localg, locald) == locala)
            {
              AppMethodBeat.o(201794);
              return locala;
            }
            break;
          case 1: 
            ResultKt.throwOnFailure(paramAnonymousObject);
          }
          paramAnonymousObject = ah.aiuX;
          AppMethodBeat.o(201794);
          return paramAnonymousObject;
        }
      }, 3);
      j.a(paramObject, null, null, (m)new k(this.aky, null)
      {
        int label;
        
        public final kotlin.d.d<ah> create(Object paramAnonymousObject, kotlin.d.d<?> paramAnonymousd)
        {
          AppMethodBeat.i(201797);
          paramAnonymousObject = (kotlin.d.d)new 2(this.aky, paramAnonymousd);
          AppMethodBeat.o(201797);
          return paramAnonymousObject;
        }
        
        public final Object invokeSuspend(Object paramAnonymousObject)
        {
          AppMethodBeat.i(201791);
          kotlin.d.a.a locala = kotlin.d.a.a.aiwj;
          switch (this.label)
          {
          default: 
            paramAnonymousObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            AppMethodBeat.o(201791);
            throw paramAnonymousObject;
          case 0: 
            ResultKt.throwOnFailure(paramAnonymousObject);
            paramAnonymousObject = this.aky.akt;
            androidx.compose.a.a.g localg = (androidx.compose.a.a.g)h.a(225, androidx.compose.a.a.z.lL(), 2);
            kotlin.d.d locald = (kotlin.d.d)this;
            this.label = 1;
            if (androidx.compose.a.a.a.a(paramAnonymousObject, Float.valueOf(1.0F), localg, locald) == locala)
            {
              AppMethodBeat.o(201791);
              return locala;
            }
            break;
          case 1: 
            ResultKt.throwOnFailure(paramAnonymousObject);
          }
          paramAnonymousObject = ah.aiuX;
          AppMethodBeat.o(201791);
          return paramAnonymousObject;
        }
      }, 3);
      paramObject = j.a(paramObject, null, null, (m)new k(this.aky, null)
      {
        int label;
        
        public final kotlin.d.d<ah> create(Object paramAnonymousObject, kotlin.d.d<?> paramAnonymousd)
        {
          AppMethodBeat.i(201811);
          paramAnonymousObject = (kotlin.d.d)new 3(this.aky, paramAnonymousd);
          AppMethodBeat.o(201811);
          return paramAnonymousObject;
        }
        
        public final Object invokeSuspend(Object paramAnonymousObject)
        {
          AppMethodBeat.i(201803);
          kotlin.d.a.a locala = kotlin.d.a.a.aiwj;
          switch (this.label)
          {
          default: 
            paramAnonymousObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            AppMethodBeat.o(201803);
            throw paramAnonymousObject;
          case 0: 
            ResultKt.throwOnFailure(paramAnonymousObject);
            paramAnonymousObject = this.aky.aku;
            androidx.compose.a.a.g localg = (androidx.compose.a.a.g)h.a(225, androidx.compose.a.a.z.lM(), 2);
            kotlin.d.d locald = (kotlin.d.d)this;
            this.label = 1;
            if (androidx.compose.a.a.a.a(paramAnonymousObject, Float.valueOf(1.0F), localg, locald) == locala)
            {
              AppMethodBeat.o(201803);
              return locala;
            }
            break;
          case 1: 
            ResultKt.throwOnFailure(paramAnonymousObject);
          }
          paramAnonymousObject = ah.aiuX;
          AppMethodBeat.o(201803);
          return paramAnonymousObject;
        }
      }, 3);
      AppMethodBeat.o(201764);
      return paramObject;
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lkotlinx/coroutines/Job;", "Lkotlinx/coroutines/CoroutineScope;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends k
    implements m<aq, kotlin.d.d<? super cb>, Object>
  {
    int label;
    
    c(g paramg, kotlin.d.d<? super c> paramd)
    {
      super(paramd);
    }
    
    public final kotlin.d.d<ah> create(Object paramObject, kotlin.d.d<?> paramd)
    {
      AppMethodBeat.i(201790);
      paramd = new c(this.aky, paramd);
      paramd.L$0 = paramObject;
      paramObject = (kotlin.d.d)paramd;
      AppMethodBeat.o(201790);
      return paramObject;
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(201774);
      kotlin.d.a.a locala = kotlin.d.a.a.aiwj;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(201774);
        throw paramObject;
      }
      ResultKt.throwOnFailure(paramObject);
      paramObject = j.a((aq)this.L$0, null, null, (m)new k(this.aky, null)
      {
        int label;
        
        public final kotlin.d.d<ah> create(Object paramAnonymousObject, kotlin.d.d<?> paramAnonymousd)
        {
          AppMethodBeat.i(201782);
          paramAnonymousObject = (kotlin.d.d)new 1(this.aky, paramAnonymousd);
          AppMethodBeat.o(201782);
          return paramAnonymousObject;
        }
        
        public final Object invokeSuspend(Object paramAnonymousObject)
        {
          AppMethodBeat.i(201779);
          kotlin.d.a.a locala = kotlin.d.a.a.aiwj;
          switch (this.label)
          {
          default: 
            paramAnonymousObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            AppMethodBeat.o(201779);
            throw paramAnonymousObject;
          case 0: 
            ResultKt.throwOnFailure(paramAnonymousObject);
            paramAnonymousObject = this.aky.aks;
            androidx.compose.a.a.g localg = (androidx.compose.a.a.g)h.a(150, androidx.compose.a.a.z.lM(), 2);
            kotlin.d.d locald = (kotlin.d.d)this;
            this.label = 1;
            if (androidx.compose.a.a.a.a(paramAnonymousObject, Float.valueOf(0.0F), localg, locald) == locala)
            {
              AppMethodBeat.o(201779);
              return locala;
            }
            break;
          case 1: 
            ResultKt.throwOnFailure(paramAnonymousObject);
          }
          paramAnonymousObject = ah.aiuX;
          AppMethodBeat.o(201779);
          return paramAnonymousObject;
        }
      }, 3);
      AppMethodBeat.o(201774);
      return paramObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.b.a.g
 * JD-Core Version:    0.7.0.1
 */