package androidx.compose.a.a;

import androidx.compose.runtime.am;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.ah;
import kotlin.g.a.b;
import kotlin.g.a.m;
import kotlin.g.b.ah.f;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"animate", "", "T", "V", "Landroidx/compose/animation/core/AnimationVector;", "typeConverter", "Landroidx/compose/animation/core/TwoWayConverter;", "initialValue", "targetValue", "initialVelocity", "animationSpec", "Landroidx/compose/animation/core/AnimationSpec;", "block", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "value", "velocity", "(Landroidx/compose/animation/core/TwoWayConverter;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Landroidx/compose/animation/core/AnimationSpec;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "(FFFLandroidx/compose/animation/core/AnimationSpec;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "animateDecay", "Landroidx/compose/animation/core/FloatDecayAnimationSpec;", "(FFLandroidx/compose/animation/core/FloatDecayAnimationSpec;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Landroidx/compose/animation/core/AnimationState;", "animation", "Landroidx/compose/animation/core/Animation;", "startTimeNanos", "", "Lkotlin/Function1;", "Landroidx/compose/animation/core/AnimationScope;", "Lkotlin/ExtensionFunctionType;", "(Landroidx/compose/animation/core/AnimationState;Landroidx/compose/animation/core/Animation;JLkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Landroidx/compose/animation/core/DecayAnimationSpec;", "sequentialAnimation", "", "(Landroidx/compose/animation/core/AnimationState;Landroidx/compose/animation/core/DecayAnimationSpec;ZLkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "animateTo", "(Landroidx/compose/animation/core/AnimationState;Ljava/lang/Object;Landroidx/compose/animation/core/AnimationSpec;ZLkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "callWithFrameNanos", "R", "onFrame", "frameTimeNanos", "(Landroidx/compose/animation/core/Animation;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "doAnimationFrame", "anim", "state", "updateState", "animation-core_release"}, k=2, mv={1, 5, 1}, xi=48)
public final class ar
{
  private static final <R, T, V extends k> Object a(c<T, V> paramc, b<? super Long, ? extends R> paramb, kotlin.d.d<? super R> paramd)
  {
    AppMethodBeat.i(203417);
    if (paramc.lF())
    {
      paramc = af.a(paramb, paramd);
      AppMethodBeat.o(203417);
      return paramc;
    }
    paramc = am.b((b)new ar.g(paramb), paramd);
    AppMethodBeat.o(203417);
    return paramc;
  }
  
  public static final <T, V extends k> Object a(final i<T, V> parami, final c<T, V> paramc, long paramLong, final b<? super f<T, V>, ah> paramb, kotlin.d.d<? super ah> paramd)
  {
    AppMethodBeat.i(203411);
    if ((paramd instanceof b))
    {
      localObject1 = (b)paramd;
      if ((((b)localObject1).label & 0x80000000) != 0) {
        ((b)localObject1).label += -2147483648;
      }
    }
    Object localObject4;
    kotlin.d.a.a locala;
    for (paramd = (kotlin.d.d<? super ah>)localObject1;; paramd = new b(paramd))
    {
      localObject4 = paramd.result;
      locala = kotlin.d.a.a.aiwj;
      switch (paramd.label)
      {
      default: 
        parami = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(203411);
        throw parami;
      }
    }
    ResultKt.throwOnFailure(localObject4);
    final Object localObject2 = paramc.k(0L);
    Object localObject3 = paramc.l(0L);
    Object localObject1 = new ah.f();
    if (paramLong == -9223372036854775808L) {}
    try
    {
      localObject2 = (b)new c((ah.f)localObject1, localObject2, paramc, (k)localObject3, parami, paramb);
      paramd.L$0 = parami;
      paramd.Uf = paramc;
      paramd.VC = paramb;
      paramd.VD = localObject1;
      paramd.label = 1;
      localObject2 = a(paramc, (b)localObject2, paramd);
      if (localObject2 != locala) {
        break label718;
      }
      AppMethodBeat.o(203411);
      return locala;
    }
    catch (CancellationException paramd)
    {
      paramc = (c<T, V>)localObject1;
      paramb = parami;
      parami = paramd;
      paramd = (f)paramc.aqH;
      if (paramd == null) {
        break label610;
      }
      paramd.lG();
      paramc = (f)paramc.aqH;
      if ((paramc == null) || (paramc.Ux != paramb.Ux)) {
        break label656;
      }
      for (i = 1;; i = 0)
      {
        if (i != 0) {
          paramb.Uz = false;
        }
        AppMethodBeat.o(203411);
        throw parami;
      }
      parami = ah.aiuX;
      AppMethodBeat.o(203411);
      return parami;
    }
    localObject1 = (ah.f)paramd.VD;
    localObject3 = (b)paramd.VC;
    localObject2 = (c)paramd.Uf;
    paramb = (i)paramd.L$0;
    paramc = (c<T, V>)localObject1;
    parami = paramb;
    label656:
    label709:
    label718:
    for (;;)
    {
      try
      {
        ResultKt.throwOnFailure(localObject4);
        parami = (i<T, V>)localObject3;
        paramc = (c<T, V>)localObject2;
        localObject2 = paramb;
        paramb = parami;
        parami = (i<T, V>)localObject2;
        localObject3 = localObject1;
        localObject1 = paramc;
        localObject2 = paramd;
        paramc = parami;
        parami = (i<T, V>)localObject3;
      }
      catch (CancellationException paramb)
      {
        label610:
        int i;
        paramd = parami;
        parami = paramb;
        paramb = paramd;
        continue;
      }
      try
      {
        paramd = parami.aqH;
        s.checkNotNull(paramd);
        if (!((f)paramd).isRunning()) {
          continue;
        }
        paramd = (b)new e(parami, (c)localObject1, paramc, paramb);
        ((b)localObject2).L$0 = paramc;
        ((b)localObject2).Uf = localObject1;
        ((b)localObject2).VC = paramb;
        ((b)localObject2).VD = parami;
        ((b)localObject2).label = 2;
        paramd = a((c)localObject1, paramd, (kotlin.d.d)localObject2);
        if (paramd != locala) {
          break label709;
        }
        AppMethodBeat.o(203411);
        return locala;
      }
      catch (CancellationException paramb)
      {
        paramd = parami;
        localObject1 = paramc;
        parami = paramb;
        paramc = paramd;
        paramb = (b<? super f<T, V>, ah>)localObject1;
        continue;
        paramd = parami;
        parami = (i<T, V>)localObject1;
        continue;
      }
      localObject2 = new f(localObject2, paramc.lD(), (k)localObject3, paramLong, paramc.lE(), paramLong, (kotlin.g.a.a)new d(parami));
      a((f)localObject2, paramLong, paramc, parami, paramb);
      localObject3 = ah.aiuX;
      ((ah.f)localObject1).aqH = localObject2;
      localObject2 = parami;
      parami = (i<T, V>)localObject1;
      localObject1 = paramc;
      paramc = (c<T, V>)localObject2;
      localObject2 = paramd;
      continue;
      localObject1 = (ah.f)paramd.VD;
      localObject3 = (b)paramd.VC;
      localObject2 = (c)paramd.Uf;
      paramb = (i)paramd.L$0;
      paramc = (c<T, V>)localObject1;
      parami = paramb;
      ResultKt.throwOnFailure(localObject4);
      parami = (i<T, V>)localObject2;
      paramc = paramb;
      localObject2 = paramd;
      paramb = (b<? super f<T, V>, ah>)localObject3;
      paramd = (kotlin.d.d<? super ah>)localObject1;
      localObject1 = parami;
      parami = paramd;
    }
  }
  
  public static final <T, V extends k> Object a(i<T, V> parami, T paramT, g<T> paramg, boolean paramBoolean, b<? super f<T, V>, ah> paramb, kotlin.d.d<? super ah> paramd)
  {
    AppMethodBeat.i(203389);
    Object localObject = parami.getValue();
    paramT = (c)new as(paramg, parami.TT, localObject, paramT, parami.Uw);
    if (paramBoolean) {}
    for (long l = parami.Ux;; l = -9223372036854775808L)
    {
      parami = a(parami, paramT, l, paramb, paramd);
      if (parami != kotlin.d.a.a.aiwj) {
        break;
      }
      AppMethodBeat.o(203389);
      return parami;
    }
    parami = ah.aiuX;
    AppMethodBeat.o(203389);
    return parami;
  }
  
  private static final <T, V extends k> void a(f<T, V> paramf, long paramLong, c<T, V> paramc, i<T, V> parami, b<? super f<T, V>, ah> paramb)
  {
    AppMethodBeat.i(203431);
    paramf.Ux = paramLong;
    paramLong -= paramf.Ut;
    paramf.A(paramc.k(paramLong));
    paramf.a(paramc.l(paramLong));
    if (paramc.m(paramLong))
    {
      paramf.Uy = paramf.Ux;
      paramf.lG();
    }
    a(paramf, parami);
    paramb.invoke(paramf);
    AppMethodBeat.o(203431);
  }
  
  public static final <T, V extends k> void a(f<T, V> paramf, i<T, V> parami)
  {
    AppMethodBeat.i(203425);
    s.u(paramf, "<this>");
    s.u(parami, "state");
    parami.A(paramf.getValue());
    o.a(parami.Uw, paramf.Uw);
    parami.Uy = paramf.Uy;
    parami.Ux = paramf.Ux;
    parami.Uz = paramf.isRunning();
    AppMethodBeat.o(203425);
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "T", "V", "Landroidx/compose/animation/core/AnimationVector;", "Landroidx/compose/animation/core/AnimationScope;"}, k=3, mv={1, 5, 1}, xi=48)
  public static final class a
    extends u
    implements b<f<T, V>, ah>
  {
    public a(m<? super T, ? super T, ah> paramm, aw<T, V> paramaw)
    {
      super();
    }
  }
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  static final class b<T, V extends k>
    extends kotlin.d.b.a.d
  {
    Object L$0;
    Object Uf;
    Object VC;
    Object VD;
    int label;
    
    b(kotlin.d.d<? super b> paramd)
    {
      super();
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(203449);
      this.result = paramObject;
      this.label |= 0x80000000;
      paramObject = ar.a(null, null, 0L, null, (kotlin.d.d)this);
      AppMethodBeat.o(203449);
      return paramObject;
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "T", "V", "Landroidx/compose/animation/core/AnimationVector;", "it", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements b<Long, ah>
  {
    c(ah.f<f<T, V>> paramf, T paramT, c<T, V> paramc, V paramV, i<T, V> parami, b<? super f<T, V>, ah> paramb)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "T", "V", "Landroidx/compose/animation/core/AnimationVector;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends u
    implements kotlin.g.a.a<ah>
  {
    d(i<T, V> parami)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "T", "V", "Landroidx/compose/animation/core/AnimationVector;", "it", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class e
    extends u
    implements b<Long, ah>
  {
    e(ah.f<f<T, V>> paramf, c<T, V> paramc, i<T, V> parami, b<? super f<T, V>, ah> paramb)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.a.a.ar
 * JD-Core Version:    0.7.0.1
 */