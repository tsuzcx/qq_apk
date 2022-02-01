package androidx.compose.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Landroidx/compose/animation/core/AnimationVector2D;", "Landroidx/compose/animation/core/AnimationVector;", "v1", "", "v2", "(FF)V", "size", "", "getSize$animation_core_release", "()I", "<set-?>", "getV1", "()F", "setV1$animation_core_release", "(F)V", "getV2", "setV2$animation_core_release", "equals", "", "other", "", "get", "index", "get$animation_core_release", "hashCode", "newVector", "newVector$animation_core_release", "reset", "", "reset$animation_core_release", "set", "value", "set$animation_core_release", "toString", "", "animation-core_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class m
  extends k
{
  public static final int Ue = 8;
  float UA;
  float UB;
  private final int size;
  
  public m(float paramFloat1, float paramFloat2)
  {
    super((byte)0);
    this.UA = paramFloat1;
    this.UB = paramFloat2;
    this.size = 2;
  }
  
  public final float bq(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return 0.0F;
    case 0: 
      return this.UA;
    }
    return this.UB;
  }
  
  public final void e(int paramInt, float paramFloat)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 0: 
      this.UA = paramFloat;
      return;
    }
    this.UB = paramFloat;
  }
  
  public final boolean equals(Object paramObject)
  {
    if ((paramObject instanceof m))
    {
      if (((m)paramObject).UA == this.UA)
      {
        i = 1;
        if (i == 0) {
          break label61;
        }
        if (((m)paramObject).UB != this.UB) {
          break label56;
        }
      }
      label56:
      for (int i = 1;; i = 0)
      {
        if (i == 0) {
          break label61;
        }
        return true;
        i = 0;
        break;
      }
    }
    label61:
    return false;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(203322);
    int i = Float.floatToIntBits(this.UA);
    int j = Float.floatToIntBits(this.UB);
    AppMethodBeat.o(203322);
    return i * 31 + j;
  }
  
  public final void lI()
  {
    this.UA = 0.0F;
    this.UB = 0.0F;
  }
  
  public final int lK()
  {
    return this.size;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(203308);
    String str = "AnimationVector2D: v1 = " + this.UA + ", v2 = " + this.UB;
    AppMethodBeat.o(203308);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.a.a.m
 * JD-Core Version:    0.7.0.1
 */