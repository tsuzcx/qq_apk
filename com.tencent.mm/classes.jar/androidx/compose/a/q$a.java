package androidx.compose.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Landroidx/compose/animation/FlingCalculator$FlingInfo;", "", "initialVelocity", "", "distance", "duration", "", "(FFJ)V", "getDistance", "()F", "getDuration", "()J", "getInitialVelocity", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "position", "time", "toString", "", "velocity", "animation_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class q$a
{
  final float TF;
  final float TG;
  final long duration;
  
  public q$a(float paramFloat1, float paramFloat2, long paramLong)
  {
    this.TF = paramFloat1;
    this.TG = paramFloat2;
    this.duration = paramLong;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(203154);
    if (this == paramObject)
    {
      AppMethodBeat.o(203154);
      return true;
    }
    if (!(paramObject instanceof a))
    {
      AppMethodBeat.o(203154);
      return false;
    }
    paramObject = (a)paramObject;
    if (!s.p(Float.valueOf(this.TF), Float.valueOf(paramObject.TF)))
    {
      AppMethodBeat.o(203154);
      return false;
    }
    if (!s.p(Float.valueOf(this.TG), Float.valueOf(paramObject.TG)))
    {
      AppMethodBeat.o(203154);
      return false;
    }
    if (this.duration != paramObject.duration)
    {
      AppMethodBeat.o(203154);
      return false;
    }
    AppMethodBeat.o(203154);
    return true;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(203151);
    int i = Float.floatToIntBits(this.TF);
    int j = Float.floatToIntBits(this.TG);
    int k = q.a..ExternalSyntheticBackport0.m(this.duration);
    AppMethodBeat.o(203151);
    return (i * 31 + j) * 31 + k;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(203142);
    String str = "FlingInfo(initialVelocity=" + this.TF + ", distance=" + this.TG + ", duration=" + this.duration + ')';
    AppMethodBeat.o(203142);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     androidx.compose.a.q.a
 * JD-Core Version:    0.7.0.1
 */