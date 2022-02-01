package androidx.compose.a;

import androidx.compose.a.a.ac;
import androidx.compose.ui.n.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Landroidx/compose/animation/SplineBasedFloatDecayAnimationSpec;", "Landroidx/compose/animation/core/FloatDecayAnimationSpec;", "density", "Landroidx/compose/ui/unit/Density;", "(Landroidx/compose/ui/unit/Density;)V", "absVelocityThreshold", "", "getAbsVelocityThreshold", "()F", "flingCalculator", "Landroidx/compose/animation/FlingCalculator;", "flingDistance", "startVelocity", "getDurationNanos", "", "initialValue", "initialVelocity", "getTargetValue", "getValueFromNanos", "playTimeNanos", "getVelocityFromNanos", "animation_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class u
  implements ac
{
  private final q TO;
  
  public u(d paramd)
  {
    AppMethodBeat.i(203090);
    this.TO = new q(v.lA(), paramd);
    AppMethodBeat.o(203090);
  }
  
  public final float a(long paramLong, float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(203111);
    paramLong /= 1000000L;
    Object localObject = this.TO.n(paramFloat2);
    if (((q.a)localObject).duration > 0L) {}
    for (paramFloat2 = (float)paramLong / (float)((q.a)localObject).duration;; paramFloat2 = 1.0F)
    {
      float f1 = ((q.a)localObject).TG;
      float f2 = Math.signum(((q.a)localObject).TF);
      localObject = a.Sl;
      paramFloat2 = a.l(paramFloat2).So;
      AppMethodBeat.o(203111);
      return paramFloat2 * (f1 * f2) + paramFloat1;
    }
  }
  
  public final float b(long paramLong, float paramFloat)
  {
    AppMethodBeat.i(203124);
    paramLong /= 1000000L;
    q.a locala = this.TO.n(paramFloat);
    if (locala.duration > 0L) {}
    for (paramFloat = (float)paramLong / (float)locala.duration;; paramFloat = 1.0F)
    {
      a locala1 = a.Sl;
      paramFloat = a.l(paramFloat).Sp * Math.signum(locala.TF) * locala.TG / (float)locala.duration;
      AppMethodBeat.o(203124);
      return paramFloat * 1000.0F;
    }
  }
  
  public final float lz()
  {
    return 0.0F;
  }
  
  public final long p(float paramFloat)
  {
    AppMethodBeat.i(203118);
    long l = (Math.exp(this.TO.m(paramFloat) / (r.ly() - 1.0D)) * 1000.0D);
    AppMethodBeat.o(203118);
    return l * 1000000L;
  }
  
  public final float r(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(203105);
    q localq = this.TO;
    double d1 = localq.m(paramFloat2);
    double d2 = r.ly();
    float f = localq.TC;
    f = (float)(localq.TE * f * Math.exp(d1 * (r.ly() / (d2 - 1.0D))));
    paramFloat2 = Math.signum(paramFloat2);
    AppMethodBeat.o(203105);
    return f * paramFloat2 + paramFloat1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.a.u
 * JD-Core Version:    0.7.0.1
 */