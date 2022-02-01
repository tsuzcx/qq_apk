package androidx.compose.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Landroidx/compose/animation/core/SpringSpec;", "T", "Landroidx/compose/animation/core/FiniteAnimationSpec;", "dampingRatio", "", "stiffness", "visibilityThreshold", "(FFLjava/lang/Object;)V", "getDampingRatio", "()F", "getStiffness", "getVisibilityThreshold", "()Ljava/lang/Object;", "Ljava/lang/Object;", "equals", "", "other", "", "hashCode", "", "vectorize", "Landroidx/compose/animation/core/VectorizedSpringSpec;", "V", "Landroidx/compose/animation/core/AnimationVector;", "converter", "Landroidx/compose/animation/core/TwoWayConverter;", "animation-core_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class aq<T>
  implements aa<T>
{
  private final T TU;
  private final float UV;
  private final float UW;
  
  public aq()
  {
    this(0.0F, 0.0F, null, 7);
  }
  
  public aq(float paramFloat1, float paramFloat2, T paramT)
  {
    this.UV = paramFloat1;
    this.UW = paramFloat2;
    this.TU = paramT;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(203372);
    if ((paramObject instanceof aq))
    {
      if (((aq)paramObject).UV == this.UV)
      {
        i = 1;
        if (i == 0) {
          break label88;
        }
        if (((aq)paramObject).UW != this.UW) {
          break label83;
        }
      }
      label83:
      for (int i = 1;; i = 0)
      {
        if ((i == 0) || (!s.p(((aq)paramObject).TU, this.TU))) {
          break label88;
        }
        AppMethodBeat.o(203372);
        return true;
        i = 0;
        break;
      }
      label88:
      AppMethodBeat.o(203372);
      return false;
    }
    AppMethodBeat.o(203372);
    return false;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(203379);
    Object localObject = this.TU;
    if (localObject != null) {}
    for (int i = localObject.hashCode();; i = 0)
    {
      int j = Float.floatToIntBits(this.UV);
      int k = Float.floatToIntBits(this.UW);
      AppMethodBeat.o(203379);
      return (i * 31 + j) * 31 + k;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.a.a.aq
 * JD-Core Version:    0.7.0.1
 */