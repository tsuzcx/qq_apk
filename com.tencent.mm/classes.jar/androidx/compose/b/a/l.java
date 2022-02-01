package androidx.compose.b.a;

import androidx.compose.a.a.a;
import androidx.compose.a.a.i;
import androidx.compose.foundation.b.g.b;
import androidx.compose.runtime.bm;
import androidx.compose.ui.d.k;
import androidx.compose.ui.e.b.e;
import androidx.compose.ui.e.b.e.b;
import androidx.compose.ui.e.b.g;
import androidx.compose.ui.e.u;
import androidx.compose.ui.e.y;
import androidx.compose.ui.e.z;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlinx.coroutines.aq;

@Metadata(d1={""}, d2={"Landroidx/compose/material/ripple/RippleIndicationInstance;", "Landroidx/compose/foundation/IndicationInstance;", "bounded", "", "rippleAlpha", "Landroidx/compose/runtime/State;", "Landroidx/compose/material/ripple/RippleAlpha;", "(ZLandroidx/compose/runtime/State;)V", "stateLayer", "Landroidx/compose/material/ripple/StateLayer;", "addRipple", "", "interaction", "Landroidx/compose/foundation/interaction/PressInteraction$Press;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "removeRipple", "updateStateLayer", "Landroidx/compose/foundation/interaction/Interaction;", "updateStateLayer$material_ripple_release", "drawStateLayer", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "radius", "Landroidx/compose/ui/unit/Dp;", "color", "Landroidx/compose/ui/graphics/Color;", "drawStateLayer-H2RKhps", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;FJ)V", "material-ripple_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract class l
  implements androidx.compose.foundation.l
{
  final p akP;
  
  public l(boolean paramBoolean, bm<f> parambm)
  {
    this.akP = new p(paramBoolean, parambm);
  }
  
  public abstract void a(g.b paramb);
  
  public abstract void a(g.b paramb, aq paramaq);
  
  public final void a(e parame, float paramFloat, long paramLong)
  {
    s.u(parame, "$receiver");
    Object localObject = this.akP;
    s.u(parame, "$receiver");
    if (Float.isNaN(paramFloat)) {}
    for (paramFloat = h.a((androidx.compose.ui.n.d)parame, ((p)localObject).ajS, parame.sf());; paramFloat = parame.w(paramFloat))
    {
      float f1 = ((Number)((p)localObject).aks.TV.getValue()).floatValue();
      if (f1 > 0.0F)
      {
        paramLong = z.g(paramLong, f1);
        if (!((p)localObject).ajS) {
          break;
        }
        f1 = k.Q(parame.sf());
        float f2 = k.R(parame.sf());
        localObject = y.awI;
        int i = y.tu();
        localObject = parame.uG();
        long l = ((androidx.compose.ui.e.b.d)localObject).sf();
        ((androidx.compose.ui.e.b.d)localObject).uH().sz();
        ((androidx.compose.ui.e.b.d)localObject).uI().a(0.0F, 0.0F, f1, f2, i);
        e.b.a(parame, paramLong, paramFloat, 0L, 0.0F, null, 0, 124);
        ((androidx.compose.ui.e.b.d)localObject).uH().restore();
        ((androidx.compose.ui.e.b.d)localObject).ao(l);
      }
      return;
    }
    e.b.a(parame, paramLong, paramFloat, 0L, 0.0F, null, 0, 124);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.b.a.l
 * JD-Core Version:    0.7.0.1
 */