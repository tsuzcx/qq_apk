package androidx.compose.a;

import androidx.compose.a.a.aa;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Landroidx/compose/animation/Fade;", "", "alpha", "", "animationSpec", "Landroidx/compose/animation/core/FiniteAnimationSpec;", "(FLandroidx/compose/animation/core/FiniteAnimationSpec;)V", "getAlpha", "()F", "getAnimationSpec", "()Landroidx/compose/animation/core/FiniteAnimationSpec;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "animation_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class p
{
  final aa<Float> SH;
  final float alpha;
  
  public p(aa<Float> paramaa)
  {
    AppMethodBeat.i(203074);
    this.alpha = 0.0F;
    this.SH = paramaa;
    AppMethodBeat.o(203074);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(203102);
    if (this == paramObject)
    {
      AppMethodBeat.o(203102);
      return true;
    }
    if (!(paramObject instanceof p))
    {
      AppMethodBeat.o(203102);
      return false;
    }
    paramObject = (p)paramObject;
    if (!s.p(Float.valueOf(this.alpha), Float.valueOf(paramObject.alpha)))
    {
      AppMethodBeat.o(203102);
      return false;
    }
    if (!s.p(this.SH, paramObject.SH))
    {
      AppMethodBeat.o(203102);
      return false;
    }
    AppMethodBeat.o(203102);
    return true;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(203092);
    int i = Float.floatToIntBits(this.alpha);
    int j = this.SH.hashCode();
    AppMethodBeat.o(203092);
    return i * 31 + j;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(203086);
    String str = "Fade(alpha=" + this.alpha + ", animationSpec=" + this.SH + ')';
    AppMethodBeat.o(203086);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.a.p
 * JD-Core Version:    0.7.0.1
 */