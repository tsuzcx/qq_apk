package androidx.compose.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Landroidx/compose/animation/core/CubicBezierEasing;", "Landroidx/compose/animation/core/Easing;", "a", "", "b", "c", "d", "(FFFF)V", "equals", "", "other", "", "evaluateCubic", "m", "hashCode", "", "transform", "fraction", "animation-core_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class s
  implements y
{
  private final float a;
  private final float b;
  private final float c;
  private final float d;
  
  public s(float paramFloat1, float paramFloat2)
  {
    this.a = paramFloat1;
    this.b = 0.0F;
    this.c = paramFloat2;
    this.d = 1.0F;
  }
  
  private static float c(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    return 3.0F * paramFloat1 * (1.0F - paramFloat3) * (1.0F - paramFloat3) * paramFloat3 + 3.0F * paramFloat2 * (1.0F - paramFloat3) * paramFloat3 * paramFloat3 + paramFloat3 * paramFloat3 * paramFloat3;
  }
  
  public final boolean equals(Object paramObject)
  {
    if ((paramObject instanceof s))
    {
      if (this.a == ((s)paramObject).a)
      {
        i = 1;
        if (i == 0) {
          break label113;
        }
        if (this.b != ((s)paramObject).b) {
          break label98;
        }
        i = 1;
        label45:
        if (i == 0) {
          break label113;
        }
        if (this.c != ((s)paramObject).c) {
          break label103;
        }
        i = 1;
        label66:
        if (i == 0) {
          break label113;
        }
        if (this.d != ((s)paramObject).d) {
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
    AppMethodBeat.i(203309);
    int i = Float.floatToIntBits(this.a);
    int j = Float.floatToIntBits(this.b);
    int k = Float.floatToIntBits(this.c);
    int m = Float.floatToIntBits(this.d);
    AppMethodBeat.o(203309);
    return ((i * 31 + j) * 31 + k) * 31 + m;
  }
  
  public final float r(float paramFloat)
  {
    float f2 = 1.0F;
    AppMethodBeat.i(203295);
    if ((paramFloat > 0.0F) && (paramFloat < 1.0F))
    {
      float f1 = 0.0F;
      for (;;)
      {
        float f3 = (f1 + f2) / 2.0F;
        float f4 = c(this.a, this.c, f3);
        if (Math.abs(paramFloat - f4) < 0.001F)
        {
          paramFloat = c(this.b, this.d, f3);
          AppMethodBeat.o(203295);
          return paramFloat;
        }
        if (f4 < paramFloat) {
          f1 = f3;
        } else {
          f2 = f3;
        }
      }
    }
    AppMethodBeat.o(203295);
    return paramFloat;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     androidx.compose.a.a.s
 * JD-Core Version:    0.7.0.1
 */