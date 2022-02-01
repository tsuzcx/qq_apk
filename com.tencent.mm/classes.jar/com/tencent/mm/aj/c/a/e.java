package com.tencent.mm.aj.c.a;

import androidx.compose.a.a.ar;
import androidx.compose.a.a.f;
import androidx.compose.a.a.g;
import androidx.compose.a.a.j;
import androidx.compose.a.a.l;
import androidx.compose.a.a.w;
import androidx.compose.foundation.a.p;
import androidx.compose.runtime.an;
import androidx.compose.runtime.bj;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.ah;
import kotlin.d.a.a;
import kotlin.d.d<-Ljava.lang.Float;>;
import kotlin.g.a.b;
import kotlin.g.b.ah.a;
import kotlin.g.b.ah.c;
import kotlin.g.b.q;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/mm_compose/widget/page_snapper/SnapperFlingBehavior;", "Landroidx/compose/foundation/gestures/FlingBehavior;", "layoutInfo", "Lcom/tencent/mm/mm_compose/widget/page_snapper/SnapperLayoutInfo;", "maximumFlingDistance", "Lkotlin/Function1;", "", "decayAnimationSpec", "Landroidx/compose/animation/core/DecayAnimationSpec;", "springAnimationSpec", "Landroidx/compose/animation/core/AnimationSpec;", "(Lcom/tencent/mm/mm_compose/widget/page_snapper/SnapperLayoutInfo;Lkotlin/jvm/functions/Function1;Landroidx/compose/animation/core/DecayAnimationSpec;Landroidx/compose/animation/core/AnimationSpec;)V", "<set-?>", "", "animationTarget", "getAnimationTarget", "()Ljava/lang/Integer;", "setAnimationTarget", "(Ljava/lang/Integer;)V", "animationTarget$delegate", "Landroidx/compose/runtime/MutableState;", "calculateSnapBack", "initialVelocity", "currentItem", "Lcom/tencent/mm/mm_compose/widget/page_snapper/SnapperLayoutItemInfo;", "targetIndex", "consumeVelocityIfNotAtScrollEdge", "velocity", "canDecayBeyondCurrentItem", "", "flingToIndex", "Landroidx/compose/foundation/gestures/ScrollScope;", "index", "(Landroidx/compose/foundation/gestures/ScrollScope;IFLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "performDecayFling", "initialItem", "flingThenSpring", "(Landroidx/compose/foundation/gestures/ScrollScope;Lcom/tencent/mm/mm_compose/widget/page_snapper/SnapperLayoutItemInfo;IFZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "performFling", "(Landroidx/compose/foundation/gestures/ScrollScope;FLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "performSnapBackIfNeeded", "Landroidx/compose/animation/core/AnimationScope;", "Landroidx/compose/animation/core/AnimationVector1D;", "scrollBy", "Lkotlin/ParameterName;", "name", "pixels", "performSpringFling", "(Landroidx/compose/foundation/gestures/ScrollScope;Lcom/tencent/mm/mm_compose/widget/page_snapper/SnapperLayoutItemInfo;IFLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "compose-base_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class e
  implements androidx.compose.foundation.a.i
{
  final h ohC;
  private final b<h, Float> ohD;
  private final androidx.compose.a.a.u<Float> ohE;
  private final g<Float> ohF;
  public final an ohG;
  
  public e(h paramh, b<? super h, Float> paramb, androidx.compose.a.a.u<Float> paramu, g<Float> paramg)
  {
    AppMethodBeat.i(238869);
    this.ohC = paramh;
    this.ohD = paramb;
    this.ohE = paramu;
    this.ohF = paramg;
    this.ohG = bj.T(null);
    AppMethodBeat.o(238869);
  }
  
  private final float bs(float paramFloat)
  {
    AppMethodBeat.i(238874);
    if ((paramFloat < 0.0F) && (!this.ohC.bzc()))
    {
      AppMethodBeat.o(238874);
      return paramFloat;
    }
    if ((paramFloat > 0.0F) && (!this.ohC.bzd()))
    {
      AppMethodBeat.o(238874);
      return paramFloat;
    }
    AppMethodBeat.o(238874);
    return 0.0F;
  }
  
  private final void k(Integer paramInteger)
  {
    AppMethodBeat.i(238871);
    this.ohG.setValue(paramInteger);
    AppMethodBeat.o(238871);
  }
  
  public final Object a(p paramp, float paramFloat, kotlin.d.d<? super Float> paramd)
  {
    AppMethodBeat.i(238887);
    if ((!this.ohC.bzc()) || (!this.ohC.bzd()))
    {
      AppMethodBeat.o(238887);
      return Float.valueOf(paramFloat);
    }
    Log.i("SnapperFlingBehavior", s.X("initialVelocity: ", Float.valueOf(paramFloat)));
    float f = ((Number)this.ohD.invoke(this.ohC)).floatValue();
    if (f > 0.0F) {}
    for (int i = 1; i == 0; i = 0)
    {
      paramp = (Throwable)new IllegalArgumentException("Distance returned by maximumFlingDistance should be greater than 0".toString());
      AppMethodBeat.o(238887);
      throw paramp;
    }
    int j = this.ohC.a(paramFloat, this.ohE, f);
    i locali = this.ohC.bza();
    if (locali == null)
    {
      AppMethodBeat.o(238887);
      return Float.valueOf(paramFloat);
    }
    if ((locali.getIndex() == j) && (this.ohC.uQ(locali.getIndex()) == 0))
    {
      Log.i("SnapperFlingBehavior", "Skipping fling: already at target. vel:" + paramFloat + ", initial item: " + locali + ", target: " + j);
      paramFloat = bs(paramFloat);
      AppMethodBeat.o(238887);
      return Float.valueOf(paramFloat);
    }
    androidx.compose.a.a.u localu = this.ohE;
    if (Math.abs(paramFloat) >= 0.5F)
    {
      f = w.a(localu, paramFloat);
      Log.i("SnapperFlingBehavior", "canDecayBeyondCurrentItem. initialVelocity: " + paramFloat + ", flingDistance: " + f + ", current item: " + locali);
      if (paramFloat < 0.0F) {
        if (f <= this.ohC.uQ(locali.getIndex())) {
          i = 1;
        }
      }
    }
    while (i != 0)
    {
      paramp = a(paramp, locali, j, paramFloat, true, paramd);
      AppMethodBeat.o(238887);
      return paramp;
      i = 0;
      continue;
      if (f >= this.ohC.uQ(locali.getIndex() + 1)) {
        i = 1;
      } else {
        i = 0;
      }
    }
    paramp = a(paramp, locali, j, paramFloat, paramd);
    AppMethodBeat.o(238887);
    return paramp;
  }
  
  final Object a(final p paramp, i parami, final int paramInt, float paramFloat, kotlin.d.d<? super Float> paramd)
  {
    AppMethodBeat.i(238897);
    if ((paramd instanceof c))
    {
      localObject1 = (c)paramd;
      if ((((c)localObject1).label & 0x80000000) != 0) {
        ((c)localObject1).label += -2147483648;
      }
    }
    Object localObject2;
    a locala;
    for (paramd = (kotlin.d.d<? super Float>)localObject1;; paramd = new c(this, paramd))
    {
      localObject2 = paramd.result;
      locala = a.aiwj;
      switch (paramd.label)
      {
      default: 
        paramp = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(238897);
        throw paramp;
      }
    }
    ResultKt.throwOnFailure(localObject2);
    Log.i("SnapperFlingBehavior", "Performing spring. vel:" + paramFloat + ", initial item: " + parami + ", target: " + paramInt);
    Object localObject1 = new ah.c();
    float f;
    if ((paramInt > parami.getIndex()) && (paramFloat > 0.0F)) {
      f = paramFloat;
    }
    for (;;)
    {
      ((ah.c)localObject1).aixa = f;
      parami = new ah.c();
      try
      {
        k(Integer.valueOf(paramInt));
        localObject2 = j.s(parami.aixa, ((ah.c)localObject1).aixa);
        paramFloat = this.ohC.uQ(paramInt);
        g localg = this.ohF;
        paramp = (b)new d(parami, paramp, (ah.c)localObject1, this, paramInt);
        paramd.L$0 = this;
        paramd.Uf = localObject1;
        paramd.VC = parami;
        paramd.label = 1;
        paramp = ar.a((androidx.compose.a.a.i)localObject2, Float.valueOf(paramFloat), localg, false, paramp, paramd, 4);
        if (paramp != locala) {
          break label488;
        }
        AppMethodBeat.o(238897);
        return locala;
      }
      finally
      {
        try
        {
          ResultKt.throwOnFailure(localObject2);
          paramd = parami;
          parami = (i)localObject1;
          paramp.k(null);
          Log.i("SnapperFlingBehavior", "Spring fling finished. Distance: " + parami.aixa + ". Final vel: " + paramd.aixa);
          paramFloat = paramp.bs(paramd.aixa);
          AppMethodBeat.o(238897);
          return Float.valueOf(paramFloat);
        }
        finally
        {
          parami = paramp;
          paramp = paramd;
        }
        paramp = finally;
        parami = this;
        parami.k(null);
        AppMethodBeat.o(238897);
      }
      if (paramInt <= parami.getIndex())
      {
        f = paramFloat;
        if (paramFloat < 0.0F) {}
      }
      else
      {
        f = 0.0F;
      }
    }
    localObject1 = (ah.c)paramd.VC;
    parami = (ah.c)paramd.Uf;
    for (paramp = (e)paramd.L$0;; paramp = this) {
      label488:
      paramd = (kotlin.d.d<? super Float>)localObject1;
    }
  }
  
  final Object a(final p paramp, i parami, final int paramInt, float paramFloat, final boolean paramBoolean, kotlin.d.d<? super Float> paramd)
  {
    AppMethodBeat.i(238891);
    if ((paramd instanceof a))
    {
      localObject1 = (a)paramd;
      if ((((a)localObject1).label & 0x80000000) != 0) {
        ((a)localObject1).label += -2147483648;
      }
    }
    Object localObject2;
    a locala1;
    for (paramd = (kotlin.d.d<? super Float>)localObject1;; paramd = new a(this, paramd))
    {
      localObject2 = paramd.result;
      locala1 = a.aiwj;
      switch (paramd.label)
      {
      default: 
        paramp = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(238891);
        throw paramp;
      }
    }
    ResultKt.throwOnFailure(localObject2);
    if ((parami.getIndex() == paramInt) && (this.ohC.uQ(parami.getIndex()) == 0))
    {
      Log.i("SnapperFlingBehavior", "Skipping decay: already at target. vel:" + paramFloat + ", current item: " + parami + ", target: " + paramInt);
      paramFloat = bs(paramFloat);
      AppMethodBeat.o(238891);
      return Float.valueOf(paramFloat);
    }
    Log.i("SnapperFlingBehavior", "Performing decay fling. vel:" + paramFloat + ", current item: " + parami + ", target: " + paramInt);
    Object localObject1 = new ah.c();
    ((ah.c)localObject1).aixa = paramFloat;
    ah.c localc = new ah.c();
    int i;
    final ah.a locala;
    if ((paramBoolean) && (Math.abs(paramInt - parami.getIndex()) >= 2))
    {
      i = 1;
      locala = new ah.a();
    }
    for (;;)
    {
      try
      {
        k(Integer.valueOf(paramInt));
        parami = j.s(0.0F, paramFloat);
        localObject2 = this.ohE;
        if (i != 0)
        {
          paramBoolean = true;
          b localb = (b)new b(localc, paramp, (ah.c)localObject1, this, paramBoolean, paramInt, locala);
          paramd.L$0 = this;
          paramd.Uf = paramp;
          paramd.VC = localObject1;
          paramd.VD = localc;
          paramd.Ze = locala;
          paramd.aai = paramInt;
          paramd.label = 1;
          parami = ar.a(parami, (androidx.compose.a.a.u)localObject2, localb, paramd);
          if (parami != locala1) {
            break label718;
          }
          AppMethodBeat.o(238891);
          return locala1;
          i = 0;
          break;
        }
        paramBoolean = false;
        continue;
        paramInt = paramd.aai;
        locala = (ah.a)paramd.Ze;
        localc = (ah.c)paramd.VD;
        localObject1 = (ah.c)paramd.VC;
        parami = (p)paramd.Uf;
        paramp = (e)paramd.L$0;
        ResultKt.throwOnFailure(localObject2);
      }
      finally
      {
        try
        {
          ResultKt.throwOnFailure(localObject2);
          localObject2 = parami;
          parami = paramp;
          parami.k(null);
          Log.i("SnapperFlingBehavior", "Decay fling finished. Distance: " + localc.aixa + ". Final vel: " + ((ah.c)localObject1).aixa);
          if (!locala.aiwY) {
            break label685;
          }
          paramp = parami.ohC.bza();
          s.checkNotNull(paramp);
          paramFloat = ((ah.c)localObject1).aixa;
          paramd.L$0 = null;
          paramd.Uf = null;
          paramd.VC = null;
          paramd.VD = null;
          paramd.Ze = null;
          paramd.label = 2;
          parami = parami.a((p)localObject2, paramp, paramInt, paramFloat, paramd);
          paramp = parami;
          if (parami != locala1) {
            break label677;
          }
          AppMethodBeat.o(238891);
          return locala1;
        }
        finally
        {
          parami = paramp;
          paramp = paramd;
          continue;
        }
        paramp = finally;
        parami = this;
        parami.k(null);
        AppMethodBeat.o(238891);
      }
      paramp = (p)localObject2;
      label677:
      AppMethodBeat.o(238891);
      return paramp;
      label685:
      paramFloat = parami.bs(((ah.c)localObject1).aixa);
      AppMethodBeat.o(238891);
      return Float.valueOf(paramFloat);
      label718:
      parami = this;
      localObject2 = paramp;
    }
  }
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends kotlin.d.b.a.d
  {
    Object L$0;
    Object Uf;
    Object VC;
    Object VD;
    Object Ze;
    int aai;
    int label;
    
    a(e parame, kotlin.d.d<? super a> paramd)
    {
      super();
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(238846);
      this.result = paramObject;
      this.label |= 0x80000000;
      paramObject = this.ohH.a(null, null, 0, 0.0F, false, (kotlin.d.d)this);
      AppMethodBeat.o(238846);
      return paramObject;
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "Landroidx/compose/animation/core/AnimationScope;", "", "Landroidx/compose/animation/core/AnimationVector1D;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends kotlin.g.b.u
    implements b<f<Float, l>, ah>
  {
    b(ah.c paramc1, p paramp, ah.c paramc2, e parame, boolean paramBoolean, int paramInt, ah.a parama)
    {
      super();
    }
  }
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends kotlin.d.b.a.d
  {
    Object L$0;
    Object Uf;
    Object VC;
    int label;
    
    c(e parame, kotlin.d.d<? super c> paramd)
    {
      super();
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(238836);
      this.result = paramObject;
      this.label |= 0x80000000;
      paramObject = this.ohH.a(null, null, 0, 0.0F, (kotlin.d.d)this);
      AppMethodBeat.o(238836);
      return paramObject;
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "Landroidx/compose/animation/core/AnimationScope;", "", "Landroidx/compose/animation/core/AnimationVector1D;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends kotlin.g.b.u
    implements b<f<Float, l>, ah>
  {
    d(ah.c paramc1, p paramp, ah.c paramc2, e parame, int paramInt)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.aj.c.a.e
 * JD-Core Version:    0.7.0.1
 */