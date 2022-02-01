package androidx.compose.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Landroidx/compose/animation/core/AnimationVector1D;", "Landroidx/compose/animation/core/AnimationVector;", "initVal", "", "(F)V", "size", "", "getSize$animation_core_release", "()I", "<set-?>", "value", "getValue", "()F", "setValue$animation_core_release", "equals", "", "other", "", "get", "index", "get$animation_core_release", "hashCode", "newVector", "newVector$animation_core_release", "reset", "", "reset$animation_core_release", "set", "set$animation_core_release", "toString", "", "animation-core_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class l
  extends k
{
  public static final int Ue = 8;
  private final int size;
  float value;
  
  public l(float paramFloat)
  {
    super((byte)0);
    this.value = paramFloat;
    this.size = 1;
  }
  
  public final float bq(int paramInt)
  {
    if (paramInt == 0) {
      return this.value;
    }
    return 0.0F;
  }
  
  public final void e(int paramInt, float paramFloat)
  {
    if (paramInt == 0) {
      this.value = paramFloat;
    }
  }
  
  public final boolean equals(Object paramObject)
  {
    if ((paramObject instanceof l))
    {
      if (((l)paramObject).value == this.value) {}
      for (int i = 1; i != 0; i = 0) {
        return true;
      }
    }
    return false;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(203301);
    int i = Float.floatToIntBits(this.value);
    AppMethodBeat.o(203301);
    return i;
  }
  
  public final void lI()
  {
    this.value = 0.0F;
  }
  
  public final int lK()
  {
    return this.size;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(203294);
    String str = s.X("AnimationVector1D: value = ", Float.valueOf(this.value));
    AppMethodBeat.o(203294);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.a.a.l
 * JD-Core Version:    0.7.0.1
 */