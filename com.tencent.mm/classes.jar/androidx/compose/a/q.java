package androidx.compose.a;

import androidx.compose.ui.n.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Landroidx/compose/animation/FlingCalculator;", "", "friction", "", "density", "Landroidx/compose/ui/unit/Density;", "(FLandroidx/compose/ui/unit/Density;)V", "getDensity", "()Landroidx/compose/ui/unit/Density;", "magicPhysicalCoefficient", "computeDeceleration", "flingDistance", "velocity", "flingDuration", "", "flingInfo", "Landroidx/compose/animation/FlingCalculator$FlingInfo;", "getSplineDeceleration", "", "FlingInfo", "animation_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class q
{
  final float TC;
  private final d TD;
  final float TE;
  
  public q(float paramFloat, d paramd)
  {
    AppMethodBeat.i(203064);
    this.TC = paramFloat;
    this.TD = paramd;
    this.TE = r.o(this.TD.mn());
    AppMethodBeat.o(203064);
  }
  
  final double m(float paramFloat)
  {
    AppMethodBeat.i(203069);
    a locala = a.Sl;
    double d = a.q(paramFloat, this.TC * this.TE);
    AppMethodBeat.o(203069);
    return d;
  }
  
  public final q.a n(float paramFloat)
  {
    AppMethodBeat.i(203081);
    double d1 = m(paramFloat);
    double d2 = r.ly() - 1.0D;
    q.a locala = new q.a(paramFloat, (float)(this.TC * this.TE * Math.exp(r.ly() / d2 * d1)), (Math.exp(d1 / d2) * 1000.0D));
    AppMethodBeat.o(203081);
    return locala;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.a.q
 * JD-Core Version:    0.7.0.1
 */