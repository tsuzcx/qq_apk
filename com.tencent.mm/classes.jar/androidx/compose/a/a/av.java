package androidx.compose.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Landroidx/compose/animation/core/TweenSpec;", "T", "Landroidx/compose/animation/core/DurationBasedAnimationSpec;", "durationMillis", "", "delay", "easing", "Landroidx/compose/animation/core/Easing;", "(IILandroidx/compose/animation/core/Easing;)V", "getDelay", "()I", "getDurationMillis", "getEasing", "()Landroidx/compose/animation/core/Easing;", "equals", "", "other", "", "hashCode", "vectorize", "Landroidx/compose/animation/core/VectorizedTweenSpec;", "V", "Landroidx/compose/animation/core/AnimationVector;", "converter", "Landroidx/compose/animation/core/TwoWayConverter;", "animation-core_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class av<T>
  implements x<T>
{
  private final int UZ;
  private final y Va;
  private final int WN;
  
  public av()
  {
    this(0, null, 7);
  }
  
  public av(int paramInt1, int paramInt2, y paramy)
  {
    AppMethodBeat.i(203346);
    this.WN = paramInt1;
    this.UZ = paramInt2;
    this.Va = paramy;
    AppMethodBeat.o(203346);
  }
  
  private <V extends k> bi<V> d(aw<T, V> paramaw)
  {
    AppMethodBeat.i(203353);
    s.u(paramaw, "converter");
    paramaw = new bi(this.WN, this.UZ, this.Va);
    AppMethodBeat.o(203353);
    return paramaw;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(203363);
    if ((paramObject instanceof av))
    {
      if ((((av)paramObject).WN == this.WN) && (((av)paramObject).UZ == this.UZ) && (s.p(((av)paramObject).Va, this.Va)))
      {
        AppMethodBeat.o(203363);
        return true;
      }
      AppMethodBeat.o(203363);
      return false;
    }
    AppMethodBeat.o(203363);
    return false;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(203373);
    int i = this.WN;
    int j = this.Va.hashCode();
    int k = this.UZ;
    AppMethodBeat.o(203373);
    return (i * 31 + j) * 31 + k;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.a.a.av
 * JD-Core Version:    0.7.0.1
 */