package androidx.compose.b.a;

import androidx.compose.a.a.g;
import androidx.compose.a.a.l;
import androidx.compose.runtime.bm;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.ah;
import kotlin.d.b.a.k;
import kotlin.d.d;
import kotlin.g.a.m;
import kotlinx.coroutines.aq;

@Metadata(d1={""}, d2={"Landroidx/compose/material/ripple/StateLayer;", "", "bounded", "", "rippleAlpha", "Landroidx/compose/runtime/State;", "Landroidx/compose/material/ripple/RippleAlpha;", "(ZLandroidx/compose/runtime/State;)V", "animatedAlpha", "Landroidx/compose/animation/core/Animatable;", "", "Landroidx/compose/animation/core/AnimationVector1D;", "currentInteraction", "Landroidx/compose/foundation/interaction/Interaction;", "interactions", "", "handleInteraction", "", "interaction", "scope", "Lkotlinx/coroutines/CoroutineScope;", "drawStateLayer", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "radius", "Landroidx/compose/ui/unit/Dp;", "color", "Landroidx/compose/ui/graphics/Color;", "drawStateLayer-H2RKhps", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;FJ)V", "material-ripple_release"}, k=1, mv={1, 5, 1}, xi=48)
final class p
{
  final boolean ajS;
  final bm<f> ajU;
  final List<androidx.compose.foundation.b.b> akY;
  androidx.compose.foundation.b.b akZ;
  final androidx.compose.a.a.a<Float, l> aks;
  
  public p(boolean paramBoolean, bm<f> parambm)
  {
    AppMethodBeat.i(201832);
    this.ajS = paramBoolean;
    this.ajU = parambm;
    this.aks = androidx.compose.a.a.b.lB();
    this.akY = ((List)new ArrayList());
    AppMethodBeat.o(201832);
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends k
    implements m<aq, d<? super ah>, Object>
  {
    int label;
    
    a(p paramp, float paramFloat, g<Float> paramg, d<? super a> paramd)
    {
      super(paramd);
    }
    
    public final d<ah> create(Object paramObject, d<?> paramd)
    {
      AppMethodBeat.i(201801);
      paramObject = (d)new a(this.ala, this.alb, this.alc, paramd);
      AppMethodBeat.o(201801);
      return paramObject;
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(201785);
      kotlin.d.a.a locala = kotlin.d.a.a.aiwj;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(201785);
        throw paramObject;
      case 0: 
        ResultKt.throwOnFailure(paramObject);
        paramObject = this.ala.aks;
        float f = this.alb;
        g localg = this.alc;
        d locald = (d)this;
        this.label = 1;
        if (androidx.compose.a.a.a.a(paramObject, Float.valueOf(f), localg, locald) == locala)
        {
          AppMethodBeat.o(201785);
          return locala;
        }
        break;
      case 1: 
        ResultKt.throwOnFailure(paramObject);
      }
      paramObject = ah.aiuX;
      AppMethodBeat.o(201785);
      return paramObject;
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends k
    implements m<aq, d<? super ah>, Object>
  {
    int label;
    
    b(p paramp, g<Float> paramg, d<? super b> paramd)
    {
      super(paramd);
    }
    
    public final d<ah> create(Object paramObject, d<?> paramd)
    {
      AppMethodBeat.i(201787);
      paramObject = (d)new b(this.ala, this.ald, paramd);
      AppMethodBeat.o(201787);
      return paramObject;
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(201777);
      kotlin.d.a.a locala = kotlin.d.a.a.aiwj;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(201777);
        throw paramObject;
      case 0: 
        ResultKt.throwOnFailure(paramObject);
        paramObject = this.ala.aks;
        g localg = this.ald;
        d locald = (d)this;
        this.label = 1;
        if (androidx.compose.a.a.a.a(paramObject, Float.valueOf(0.0F), localg, locald) == locala)
        {
          AppMethodBeat.o(201777);
          return locala;
        }
        break;
      case 1: 
        ResultKt.throwOnFailure(paramObject);
      }
      paramObject = ah.aiuX;
      AppMethodBeat.o(201777);
      return paramObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.b.a.p
 * JD-Core Version:    0.7.0.1
 */