package androidx.compose.foundation.a;

import androidx.compose.foundation.b.a.a;
import androidx.compose.foundation.b.a.b;
import androidx.compose.foundation.o;
import androidx.compose.runtime.an;
import androidx.compose.runtime.bm;
import androidx.compose.runtime.x;
import androidx.compose.runtime.y;
import androidx.compose.ui.platform.ad;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.ah;
import kotlin.g.a.q;
import kotlin.g.b.ah.c;
import kotlin.g.b.ah.f;
import kotlin.r;
import kotlinx.coroutines.a.ab;
import kotlinx.coroutines.aq;
import kotlinx.coroutines.ar;

@Metadata(d1={""}, d2={"DraggableState", "Landroidx/compose/foundation/gestures/DraggableState;", "onDelta", "Lkotlin/Function1;", "", "", "rememberDraggableState", "(Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;I)Landroidx/compose/foundation/gestures/DraggableState;", "awaitDownAndSlop", "Lkotlin/Pair;", "Landroidx/compose/ui/input/pointer/PointerInputChange;", "Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;", "canDrag", "Landroidx/compose/runtime/State;", "", "startDragImmediately", "Lkotlin/Function0;", "orientation", "Landroidx/compose/foundation/gestures/Orientation;", "(Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;Landroidx/compose/runtime/State;Landroidx/compose/runtime/State;Landroidx/compose/foundation/gestures/Orientation;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "awaitDrag", "dragStart", "velocityTracker", "Landroidx/compose/ui/input/pointer/util/VelocityTracker;", "channel", "Lkotlinx/coroutines/channels/SendChannel;", "Landroidx/compose/foundation/gestures/DragEvent;", "reverseDirection", "(Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;Lkotlin/Pair;Landroidx/compose/ui/input/pointer/util/VelocityTracker;Lkotlinx/coroutines/channels/SendChannel;ZLandroidx/compose/foundation/gestures/Orientation;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "draggable", "Landroidx/compose/ui/Modifier;", "state", "enabled", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "onDragStarted", "Lkotlin/Function3;", "Lkotlinx/coroutines/CoroutineScope;", "Landroidx/compose/ui/geometry/Offset;", "Lkotlin/ParameterName;", "name", "startedPosition", "Lkotlin/coroutines/Continuation;", "", "Lkotlin/ExtensionFunctionType;", "onDragStopped", "velocity", "(Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/gestures/DraggableState;Lkotlin/jvm/functions/Function1;Landroidx/compose/foundation/gestures/Orientation;ZLandroidx/compose/foundation/interaction/MutableInteractionSource;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function3;Z)Landroidx/compose/ui/Modifier;", "(Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/gestures/DraggableState;Landroidx/compose/foundation/gestures/Orientation;ZLandroidx/compose/foundation/interaction/MutableInteractionSource;ZLkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function3;Z)Landroidx/compose/ui/Modifier;", "toFloat", "toFloat-3MmeM6k", "(JLandroidx/compose/foundation/gestures/Orientation;)F", "Landroidx/compose/ui/unit/Velocity;", "toFloat-sF-c-tU", "toOffset", "(FLandroidx/compose/foundation/gestures/Orientation;)J", "foundation_release"}, k=2, mv={1, 5, 1}, xi=48)
public final class g
{
  static final float a(long paramLong, k paramk)
  {
    AppMethodBeat.i(204151);
    if (paramk == k.aaT)
    {
      f = androidx.compose.ui.d.e.G(paramLong);
      AppMethodBeat.o(204151);
      return f;
    }
    float f = androidx.compose.ui.d.e.F(paramLong);
    AppMethodBeat.o(204151);
    return f;
  }
  
  private static final Object a(androidx.compose.ui.g.c.a parama, bm<? extends kotlin.g.a.b<? super androidx.compose.ui.g.c.m, Boolean>> parambm, bm<? extends kotlin.g.a.a<Boolean>> parambm1, k paramk, kotlin.d.d<? super r<androidx.compose.ui.g.c.m, Float>> paramd)
  {
    AppMethodBeat.i(204148);
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
      paramd = locala.result;
      locala1 = kotlin.d.a.a.aiwj;
      switch (locala.label)
      {
      default: 
        parama = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(204148);
        throw parama;
        locala = new a(paramd);
      }
    }
    ResultKt.throwOnFailure(paramd);
    locala.L$0 = parama;
    locala.Uf = parambm;
    locala.VC = parambm1;
    locala.VD = paramk;
    locala.label = 1;
    Object localObject = v.a(parama, false, locala);
    paramd = localObject;
    if (localObject == locala1)
    {
      AppMethodBeat.o(204148);
      return locala1;
      paramk = (k)locala.VD;
      parambm1 = (bm)locala.VC;
      parambm = (bm)locala.Uf;
      parama = (androidx.compose.ui.g.c.a)locala.L$0;
      ResultKt.throwOnFailure(paramd);
    }
    paramd = (androidx.compose.ui.g.c.m)paramd;
    if (((Boolean)((kotlin.g.a.b)parambm.getValue()).invoke(paramd)).booleanValue())
    {
      if (((Boolean)((kotlin.g.a.a)parambm1.getValue()).invoke()).booleanValue())
      {
        parama = kotlin.v.Y(paramd, Float.valueOf(0.0F));
        AppMethodBeat.o(204148);
        return parama;
      }
      parambm = new ah.c();
      parambm1 = (kotlin.g.a.m)new b(parambm);
      long l;
      if (paramk == k.aaT)
      {
        l = paramd.id;
        locala.L$0 = parambm;
        locala.Uf = null;
        locala.VC = null;
        locala.VD = null;
        locala.label = 2;
        paramk = d.a(parama, l, parambm1, locala);
        parambm1 = paramk;
        parama = parambm;
        if (paramk == locala1)
        {
          AppMethodBeat.o(204148);
          return locala1;
          parama = (ah.c)locala.L$0;
          ResultKt.throwOnFailure(paramd);
          parambm1 = paramd;
        }
      }
      for (parambm = (androidx.compose.ui.g.c.m)parambm1; parambm != null; parambm = (androidx.compose.ui.g.c.m)parambm1)
      {
        parama = kotlin.v.Y(parambm, Float.valueOf(parama.aixa));
        AppMethodBeat.o(204148);
        return parama;
        l = paramd.id;
        locala.L$0 = parambm;
        locala.Uf = null;
        locala.VC = null;
        locala.VD = null;
        locala.label = 3;
        paramk = d.b(parama, l, parambm1, locala);
        parambm1 = paramk;
        parama = parambm;
        if (paramk == locala1)
        {
          AppMethodBeat.o(204148);
          return locala1;
          parama = (ah.c)locala.L$0;
          ResultKt.throwOnFailure(paramd);
          parambm1 = paramd;
        }
      }
    }
    AppMethodBeat.o(204148);
    return null;
  }
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends kotlin.d.b.a.d
  {
    Object L$0;
    Object Uf;
    Object VC;
    Object VD;
    int label;
    
    a(kotlin.d.d<? super a> paramd)
    {
      super();
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(204130);
      this.result = paramObject;
      this.label |= 0x80000000;
      paramObject = g.b(null, null, null, null, (kotlin.d.d)this);
      AppMethodBeat.o(204130);
      return paramObject;
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "event", "Landroidx/compose/ui/input/pointer/PointerInputChange;", "offset", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends kotlin.g.b.u
    implements kotlin.g.a.m<androidx.compose.ui.g.c.m, Float, ah>
  {
    b(ah.c paramc)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "event", "Landroidx/compose/ui/input/pointer/PointerInputChange;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends kotlin.g.b.u
    implements kotlin.g.a.b<androidx.compose.ui.g.c.m, ah>
  {
    c(androidx.compose.ui.g.c.a.f paramf, k paramk, ab<? super c> paramab, boolean paramBoolean)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "Landroidx/compose/ui/platform/InspectorInfo;", "androidx/compose/ui/platform/InspectableValueKt$debugInspectorInfo$1"}, k=3, mv={1, 5, 1}, xi=48)
  public static final class d
    extends kotlin.g.b.u
    implements kotlin.g.a.b<ad, ah>
  {
    public d(kotlin.g.a.b paramb, k paramk, boolean paramBoolean, androidx.compose.foundation.b.e parame, kotlin.g.a.a parama, q paramq1, q paramq2, h paramh)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroidx/compose/ui/Modifier;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class f
    extends kotlin.g.b.u
    implements q<androidx.compose.ui.f, androidx.compose.runtime.h, Integer, androidx.compose.ui.f>
  {
    f(androidx.compose.foundation.b.e parame, kotlin.g.a.a<Boolean> parama, kotlin.g.a.b<? super androidx.compose.ui.g.c.m, Boolean> paramb, q<? super aq, ? super androidx.compose.ui.d.e, ? super kotlin.d.d<? super ah>, ? extends Object> paramq, q<? super aq, ? super Float, ? super kotlin.d.d<? super ah>, ? extends Object> paramq1, h paramh, k paramk, boolean paramBoolean)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.foundation.a.g
 * JD-Core Version:    0.7.0.1
 */