package androidx.compose.a.a;

import androidx.compose.runtime.a.e;
import androidx.compose.runtime.bm;
import androidx.compose.runtime.h;
import androidx.compose.runtime.h.a;
import androidx.compose.runtime.x;
import androidx.compose.runtime.y;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.a.b;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"AnimationDebugDurationScale", "", "updateTransition", "Landroidx/compose/animation/core/Transition;", "T", "targetState", "label", "", "(Ljava/lang/Object;Ljava/lang/String;Landroidx/compose/runtime/Composer;II)Landroidx/compose/animation/core/Transition;", "transitionState", "Landroidx/compose/animation/core/MutableTransitionState;", "(Landroidx/compose/animation/core/MutableTransitionState;Ljava/lang/String;Landroidx/compose/runtime/Composer;II)Landroidx/compose/animation/core/Transition;", "animateDp", "Landroidx/compose/runtime/State;", "Landroidx/compose/ui/unit/Dp;", "S", "transitionSpec", "Lkotlin/Function1;", "Landroidx/compose/animation/core/Transition$Segment;", "Landroidx/compose/animation/core/FiniteAnimationSpec;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "targetValueByState", "Lkotlin/ParameterName;", "name", "state", "(Landroidx/compose/animation/core/Transition;Lkotlin/jvm/functions/Function3;Ljava/lang/String;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)Landroidx/compose/runtime/State;", "animateFloat", "", "animateInt", "animateIntOffset", "Landroidx/compose/ui/unit/IntOffset;", "animateIntSize", "Landroidx/compose/ui/unit/IntSize;", "animateOffset", "Landroidx/compose/ui/geometry/Offset;", "animateRect", "Landroidx/compose/ui/geometry/Rect;", "animateSize", "Landroidx/compose/ui/geometry/Size;", "animateValue", "V", "Landroidx/compose/animation/core/AnimationVector;", "typeConverter", "Landroidx/compose/animation/core/TwoWayConverter;", "(Landroidx/compose/animation/core/Transition;Landroidx/compose/animation/core/TwoWayConverter;Lkotlin/jvm/functions/Function3;Ljava/lang/String;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)Landroidx/compose/runtime/State;", "createChildTransition", "transformToChildState", "parentState", "(Landroidx/compose/animation/core/Transition;Ljava/lang/String;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)Landroidx/compose/animation/core/Transition;", "createChildTransitionInternal", "initialState", "(Landroidx/compose/animation/core/Transition;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/String;Landroidx/compose/runtime/Composer;I)Landroidx/compose/animation/core/Transition;", "createDeferredAnimation", "Landroidx/compose/animation/core/Transition$DeferredAnimation;", "(Landroidx/compose/animation/core/Transition;Landroidx/compose/animation/core/TwoWayConverter;Ljava/lang/String;Landroidx/compose/runtime/Composer;II)Landroidx/compose/animation/core/Transition$DeferredAnimation;", "createTransitionAnimation", "initialValue", "targetValue", "animationSpec", "(Landroidx/compose/animation/core/Transition;Ljava/lang/Object;Ljava/lang/Object;Landroidx/compose/animation/core/FiniteAnimationSpec;Landroidx/compose/animation/core/TwoWayConverter;Ljava/lang/String;Landroidx/compose/runtime/Composer;I)Landroidx/compose/runtime/State;", "animation-core_release"}, k=2, mv={1, 5, 1}, xi=48)
public final class au
{
  public static final <S, T, V extends k> at<S>.a<T, V> a(at<S> paramat, final aw<T, V> paramaw, String paramString, h paramh)
  {
    AppMethodBeat.i(203384);
    s.u(paramat, "<this>");
    s.u(paramaw, "typeConverter");
    paramh.bx(-44508410);
    paramh.bx(-3686930);
    boolean bool = paramh.G(paramat);
    Object localObject2 = paramh.or();
    Object localObject1;
    if (!bool)
    {
      localObject1 = h.alD;
      localObject1 = localObject2;
      if (localObject2 != h.a.ox()) {}
    }
    else
    {
      localObject1 = new at.a(paramat, paramaw, paramString);
      paramh.F(localObject1);
    }
    paramh.od();
    paramaw = (at.a)localObject1;
    androidx.compose.runtime.aa.a(paramaw, (b)new b(paramat, paramaw), paramh);
    if (paramat.lV()) {
      paramaw.lX();
    }
    paramh.od();
    AppMethodBeat.o(203384);
    return paramaw;
  }
  
  public static final <S, T> at<T> a(at<S> paramat, final T paramT1, T paramT2, String paramString, h paramh, int paramInt)
  {
    AppMethodBeat.i(203394);
    s.u(paramat, "<this>");
    s.u(paramString, "label");
    paramh.bx(-382165783);
    paramh.bx(-3686930);
    boolean bool = paramh.G(paramat);
    Object localObject2 = paramh.or();
    Object localObject1;
    if (!bool)
    {
      localObject1 = h.alD;
      localObject1 = localObject2;
      if (localObject2 != h.a.ox()) {}
    }
    else
    {
      localObject1 = new at(new aj(paramT1), paramString);
      paramh.F(localObject1);
    }
    paramh.od();
    paramT1 = (at)localObject1;
    androidx.compose.runtime.aa.a(paramT1, (b)new a(paramat, paramT1), paramh);
    paramT1.a(paramT2, paramh, paramInt >> 3 & 0x8 | paramInt >> 6 & 0xE);
    paramh.od();
    AppMethodBeat.o(203394);
    return paramT1;
  }
  
  public static final <S, T, V extends k> bm<T> a(at<S> paramat, T paramT1, T paramT2, aa<T> paramaa, final aw<T, V> paramaw, String paramString, h paramh)
  {
    AppMethodBeat.i(203401);
    s.u(paramat, "<this>");
    s.u(paramaa, "animationSpec");
    s.u(paramaw, "typeConverter");
    s.u(paramString, "label");
    paramh.bx(460678952);
    paramh.bx(-3686930);
    boolean bool = paramh.G(paramat);
    Object localObject2 = paramh.or();
    Object localObject1;
    if (!bool)
    {
      localObject1 = h.alD;
      localObject1 = localObject2;
      if (localObject2 != h.a.ox()) {}
    }
    else
    {
      localObject1 = new at.d(paramat, paramT1, j.a(paramaw, paramT2), paramaw, paramString);
      paramh.F(localObject1);
    }
    paramh.od();
    paramaw = (at.d)localObject1;
    if (paramat.lV()) {
      paramaw.a(paramT1, paramT2, paramaa);
    }
    for (;;)
    {
      androidx.compose.runtime.aa.a(paramaw, (b)new c(paramat, paramaw), paramh);
      paramh.od();
      paramat = (bm)paramaw;
      AppMethodBeat.o(203401);
      return paramat;
      paramaw.a(paramT2, paramaa);
    }
  }
  
  public static final <T> at<T> c(T paramT, h paramh, int paramInt)
  {
    AppMethodBeat.i(203375);
    paramh.bx(1641299311);
    paramh.bx(-3687241);
    Object localObject2 = paramh.or();
    Object localObject1 = h.alD;
    localObject1 = localObject2;
    if (localObject2 == h.a.ox())
    {
      localObject1 = new at(paramT);
      paramh.F(localObject1);
    }
    paramh.od();
    localObject1 = (at)localObject1;
    ((at)localObject1).b(paramT, paramh, paramInt & 0x8 | 0x30 | paramInt & 0xE);
    androidx.compose.runtime.aa.a(localObject1, (b)new d((at)localObject1), paramh);
    paramh.od();
    AppMethodBeat.o(203375);
    return localObject1;
  }
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends u
    implements b<y, x>
  {
    a(at<S> paramat, at<T> paramat1)
    {
      super();
    }
    
    @Metadata(d1={""}, d2={"androidx/compose/runtime/DisposableEffectScope$onDispose$1", "Landroidx/compose/runtime/DisposableEffectResult;", "dispose", "", "runtime_release"}, k=1, mv={1, 5, 1}, xi=48)
    public static final class a
      implements x
    {
      public a(at paramat1, at paramat2) {}
      
      public final void dispose()
      {
        AppMethodBeat.i(203207);
        at localat1 = this.WD;
        at localat2 = this.WE;
        s.u(localat2, "transition");
        localat1.Wj.remove(localat2);
        AppMethodBeat.o(203207);
      }
    }
  }
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements b<y, x>
  {
    b(at<S> paramat, at<S>.a<T, V> paramat1)
    {
      super();
    }
    
    @Metadata(d1={""}, d2={"androidx/compose/runtime/DisposableEffectScope$onDispose$1", "Landroidx/compose/runtime/DisposableEffectResult;", "dispose", "", "runtime_release"}, k=1, mv={1, 5, 1}, xi=48)
    public static final class a
      implements x
    {
      public a(at paramat, at.a parama) {}
      
      public final void dispose()
      {
        AppMethodBeat.i(203409);
        at localat = this.WH;
        Object localObject = this.WI;
        s.u(localObject, "deferredAnimation");
        localObject = ((at.a)localObject).Wo;
        if (localObject != null) {
          localat.b(((at.a.a)localObject).Wq);
        }
        AppMethodBeat.o(203409);
      }
    }
  }
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements b<y, x>
  {
    c(at<S> paramat, at<S>.d<T, V> paramat1)
    {
      super();
    }
    
    @Metadata(d1={""}, d2={"androidx/compose/runtime/DisposableEffectScope$onDispose$1", "Landroidx/compose/runtime/DisposableEffectResult;", "dispose", "", "runtime_release"}, k=1, mv={1, 5, 1}, xi=48)
    public static final class a
      implements x
    {
      public a(at paramat, at.d paramd) {}
      
      public final void dispose()
      {
        AppMethodBeat.i(203190);
        this.WL.b(this.WM);
        AppMethodBeat.o(203190);
      }
    }
  }
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends u
    implements b<y, x>
  {
    d(at<T> paramat)
    {
      super();
    }
    
    @Metadata(d1={""}, d2={"androidx/compose/runtime/DisposableEffectScope$onDispose$1", "Landroidx/compose/runtime/DisposableEffectResult;", "dispose", "", "runtime_release"}, k=1, mv={1, 5, 1}, xi=48)
    public static final class a
      implements x
    {
      public a(at paramat) {}
      
      public final void dispose()
      {
        AppMethodBeat.i(203325);
        this.WE.lW();
        AppMethodBeat.o(203325);
      }
    }
  }
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  public static final class e
    extends u
    implements b<y, x>
  {
    public e(at<T> paramat)
    {
      super();
    }
    
    @Metadata(d1={""}, d2={"androidx/compose/runtime/DisposableEffectScope$onDispose$1", "Landroidx/compose/runtime/DisposableEffectResult;", "dispose", "", "runtime_release"}, k=1, mv={1, 5, 1}, xi=48)
    public static final class a
      implements x
    {
      public a(at paramat) {}
      
      public final void dispose()
      {
        AppMethodBeat.i(203444);
        this.WE.lW();
        AppMethodBeat.o(203444);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.a.a.au
 * JD-Core Version:    0.7.0.1
 */