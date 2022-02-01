package androidx.compose.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Landroidx/compose/animation/core/AnimationVector4D;", "Landroidx/compose/animation/core/AnimationVector;", "v1", "", "v2", "v3", "v4", "(FFFF)V", "size", "", "getSize$animation_core_release", "()I", "<set-?>", "getV1", "()F", "setV1$animation_core_release", "(F)V", "getV2", "setV2$animation_core_release", "getV3", "setV3$animation_core_release", "getV4", "setV4$animation_core_release", "equals", "", "other", "", "get", "index", "get$animation_core_release", "hashCode", "newVector", "newVector$animation_core_release", "reset", "", "reset$animation_core_release", "set", "value", "set$animation_core_release", "toString", "", "animation-core_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class n
  extends k
{
  public static final int Ue = 8;
  public float UA;
  public float UB;
  public float UC;
  public float UD;
  private final int size;
  
  public n(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    super((byte)0);
    this.UA = paramFloat1;
    this.UB = paramFloat2;
    this.UC = paramFloat3;
    this.UD = paramFloat4;
    this.size = 4;
  }
  
  public final float bq(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return 0.0F;
    case 0: 
      return this.UA;
    case 1: 
      return this.UB;
    case 2: 
      return this.UC;
    }
    return this.UD;
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
    case 1: 
      this.UB = paramFloat;
      return;
    case 2: 
      this.UC = paramFloat;
      return;
    }
    this.UD = paramFloat;
  }
  
  public final boolean equals(Object paramObject)
  {
    if ((paramObject instanceof n))
    {
      if (((n)paramObject).UA == this.UA)
      {
        i = 1;
        if (i == 0) {
          break label113;
        }
        if (((n)paramObject).UB != this.UB) {
          break label98;
        }
        i = 1;
        label45:
        if (i == 0) {
          break label113;
        }
        if (((n)paramObject).UC != this.UC) {
          break label103;
        }
        i = 1;
        label66:
        if (i == 0) {
          break label113;
        }
        if (((n)paramObject).UD != this.UD) {
          break label108;
        }
      }
      label98:
      label103:
      label108:
      for (int i = 1;; i = 0)
      {
        if (i == 0) {
          break label113;
        }
        return true;
        i = 0;
        break;
        i = 0;
        break label45;
        i = 0;
        break label66;
      }
    }
    label113:
    return false;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(203296);
    int i = Float.floatToIntBits(this.UA);
    int j = Float.floatToIntBits(this.UB);
    int k = Float.floatToIntBits(this.UC);
    int m = Float.floatToIntBits(this.UD);
    AppMethodBeat.o(203296);
    return ((i * 31 + j) * 31 + k) * 31 + m;
  }
  
  public final void lI()
  {
    this.UA = 0.0F;
    this.UB = 0.0F;
    this.UC = 0.0F;
    this.UD = 0.0F;
  }
  
  public final int lK()
  {
    return this.size;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(203293);
    String str = "AnimationVector4D: v1 = " + this.UA + ", v2 = " + this.UB + ", v3 = " + this.UC + ", v4 = " + this.UD;
    AppMethodBeat.o(203293);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.a.a.n
 * JD-Core Version:    0.7.0.1
 */