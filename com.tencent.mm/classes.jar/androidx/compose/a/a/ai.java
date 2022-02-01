package androidx.compose.a.a;

import androidx.compose.runtime.a.e;
import androidx.compose.runtime.aa;
import androidx.compose.runtime.bm;
import androidx.compose.runtime.h;
import androidx.compose.runtime.h.a;
import androidx.compose.runtime.x;
import androidx.compose.runtime.y;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.a.a;
import kotlin.g.a.b;
import kotlin.g.b.m;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"rememberInfiniteTransition", "Landroidx/compose/animation/core/InfiniteTransition;", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/animation/core/InfiniteTransition;", "animateFloat", "Landroidx/compose/runtime/State;", "", "initialValue", "targetValue", "animationSpec", "Landroidx/compose/animation/core/InfiniteRepeatableSpec;", "(Landroidx/compose/animation/core/InfiniteTransition;FFLandroidx/compose/animation/core/InfiniteRepeatableSpec;Landroidx/compose/runtime/Composer;I)Landroidx/compose/runtime/State;", "animateValue", "T", "V", "Landroidx/compose/animation/core/AnimationVector;", "typeConverter", "Landroidx/compose/animation/core/TwoWayConverter;", "(Landroidx/compose/animation/core/InfiniteTransition;Ljava/lang/Object;Ljava/lang/Object;Landroidx/compose/animation/core/TwoWayConverter;Landroidx/compose/animation/core/InfiniteRepeatableSpec;Landroidx/compose/runtime/Composer;I)Landroidx/compose/runtime/State;", "animation-core_release"}, k=2, mv={1, 5, 1}, xi=48)
public final class ai
{
  public static final bm<Float> a(ah paramah, ag<Float> paramag, h paramh)
  {
    AppMethodBeat.i(203405);
    s.u(paramah, "<this>");
    s.u(paramag, "animationSpec");
    paramh.bx(1399864148);
    paramah = a(paramah, Float.valueOf(0.0F), Float.valueOf(360.0F), ay.a(m.aiwV), paramag, paramh);
    paramh.od();
    AppMethodBeat.o(203405);
    return paramah;
  }
  
  public static final <T, V extends k> bm<T> a(ah paramah, T paramT1, final T paramT2, final aw<T, V> paramaw, final ag<T> paramag, h paramh)
  {
    AppMethodBeat.i(203400);
    s.u(paramah, "<this>");
    s.u(paramaw, "typeConverter");
    s.u(paramag, "animationSpec");
    paramh.bx(1847699412);
    paramh.bx(-3687241);
    Object localObject2 = paramh.or();
    Object localObject1 = h.alD;
    localObject1 = localObject2;
    if (localObject2 == h.a.ox())
    {
      localObject1 = new ah.a(paramah, paramT1, paramT2, paramaw, (g)paramag);
      paramh.F(localObject1);
    }
    paramh.od();
    paramaw = (ah.a)localObject1;
    aa.a((a)new a(paramT1, paramaw, paramT2, paramag), paramh);
    aa.a(paramaw, (b)new b(paramah, paramaw), paramh);
    paramh.od();
    paramah = (bm)paramaw;
    AppMethodBeat.o(203400);
    return paramah;
  }
  
  public static final ah c(h paramh)
  {
    AppMethodBeat.i(203392);
    paramh.bx(353815743);
    paramh.bx(-3687241);
    Object localObject2 = paramh.or();
    Object localObject1 = h.alD;
    localObject1 = localObject2;
    if (localObject2 == h.a.ox())
    {
      localObject1 = new ah();
      paramh.F(localObject1);
    }
    paramh.od();
    localObject1 = (ah)localObject1;
    ((ah)localObject1).a(paramh, 8);
    paramh.od();
    AppMethodBeat.o(203392);
    return localObject1;
  }
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends u
    implements a<kotlin.ah>
  {
    a(T paramT1, ah.a<T, V> parama, T paramT2, ag<T> paramag)
    {
      super();
    }
  }
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements b<y, x>
  {
    b(ah paramah, ah.a<T, V> parama)
    {
      super();
    }
    
    @Metadata(d1={""}, d2={"androidx/compose/runtime/DisposableEffectScope$onDispose$1", "Landroidx/compose/runtime/DisposableEffectResult;", "dispose", "", "runtime_release"}, k=1, mv={1, 5, 1}, xi=48)
    public static final class a
      implements x
    {
      public a(ah paramah, ah.a parama) {}
      
      public final void dispose()
      {
        AppMethodBeat.i(203186);
        ah localah = this.Vr;
        ah.a locala = this.Vs;
        s.u(locala, "animation");
        localah.Ve.remove(locala);
        AppMethodBeat.o(203186);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.a.a.ai
 * JD-Core Version:    0.7.0.1
 */