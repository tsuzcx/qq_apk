package androidx.compose.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Landroidx/compose/animation/core/InfiniteRepeatableSpec;", "T", "Landroidx/compose/animation/core/AnimationSpec;", "animation", "Landroidx/compose/animation/core/DurationBasedAnimationSpec;", "repeatMode", "Landroidx/compose/animation/core/RepeatMode;", "(Landroidx/compose/animation/core/DurationBasedAnimationSpec;Landroidx/compose/animation/core/RepeatMode;)V", "getAnimation", "()Landroidx/compose/animation/core/DurationBasedAnimationSpec;", "getRepeatMode", "()Landroidx/compose/animation/core/RepeatMode;", "equals", "", "other", "", "hashCode", "", "vectorize", "Landroidx/compose/animation/core/VectorizedAnimationSpec;", "V", "Landroidx/compose/animation/core/AnimationVector;", "converter", "Landroidx/compose/animation/core/TwoWayConverter;", "animation-core_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class ag<T>
  implements g<T>
{
  public static final int Ue = 8;
  private final x<T> Vc;
  private final am Vd;
  
  public ag(x<T> paramx, am paramam)
  {
    AppMethodBeat.i(203388);
    this.Vc = paramx;
    this.Vd = paramam;
    AppMethodBeat.o(203388);
  }
  
  public final <V extends k> az<V> a(aw<T, V> paramaw)
  {
    AppMethodBeat.i(203397);
    s.u(paramaw, "converter");
    paramaw = (az)new bg(this.Vc.c(paramaw), this.Vd);
    AppMethodBeat.o(203397);
    return paramaw;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(203403);
    if ((paramObject instanceof ag))
    {
      if ((s.p(((ag)paramObject).Vc, this.Vc)) && (((ag)paramObject).Vd == this.Vd))
      {
        AppMethodBeat.o(203403);
        return true;
      }
      AppMethodBeat.o(203403);
      return false;
    }
    AppMethodBeat.o(203403);
    return false;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(203407);
    int i = this.Vc.hashCode();
    int j = this.Vd.hashCode();
    AppMethodBeat.o(203407);
    return i * 31 + j;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.a.a.ag
 * JD-Core Version:    0.7.0.1
 */