package androidx.compose.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Landroidx/compose/animation/AndroidFlingSpline$FlingResult;", "", "distanceCoefficient", "", "velocityCoefficient", "(FF)V", "getDistanceCoefficient", "()F", "getVelocityCoefficient", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "animation_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a$a
{
  final float So;
  final float Sp;
  
  public a$a(float paramFloat1, float paramFloat2)
  {
    this.So = paramFloat1;
    this.Sp = paramFloat2;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(203165);
    if (this == paramObject)
    {
      AppMethodBeat.o(203165);
      return true;
    }
    if (!(paramObject instanceof a))
    {
      AppMethodBeat.o(203165);
      return false;
    }
    paramObject = (a)paramObject;
    if (!s.p(Float.valueOf(this.So), Float.valueOf(paramObject.So)))
    {
      AppMethodBeat.o(203165);
      return false;
    }
    if (!s.p(Float.valueOf(this.Sp), Float.valueOf(paramObject.Sp)))
    {
      AppMethodBeat.o(203165);
      return false;
    }
    AppMethodBeat.o(203165);
    return true;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(203161);
    int i = Float.floatToIntBits(this.So);
    int j = Float.floatToIntBits(this.Sp);
    AppMethodBeat.o(203161);
    return i * 31 + j;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(203157);
    String str = "FlingResult(distanceCoefficient=" + this.So + ", velocityCoefficient=" + this.Sp + ')';
    AppMethodBeat.o(203157);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     androidx.compose.a.a.a
 * JD-Core Version:    0.7.0.1
 */