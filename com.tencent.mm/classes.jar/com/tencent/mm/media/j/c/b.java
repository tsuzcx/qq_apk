package com.tencent.mm.media.j.c;

import android.graphics.Point;
import android.graphics.RectF;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.util.c;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/media/render/util/RenderProcessCropUtil;", "", "()V", "calculateCropTextureCoord", "", "scaleType", "", "textureWidth", "textureHeight", "textureValidLTPoint", "Landroid/graphics/Point;", "textureValidRBPoint", "rotate", "drawWidth", "drawHeight", "textureCropRect", "Landroid/graphics/Rect;", "calculateCube", "getValidTextureArea", "Landroid/graphics/RectF;", "validLeftTopPoint", "validRightBottomPoint", "plugin-mediaeditor_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
{
  public static final b nFq;
  
  static
  {
    AppMethodBeat.i(237739);
    nFq = new b();
    AppMethodBeat.o(237739);
  }
  
  public static RectF a(Point paramPoint1, Point paramPoint2, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(237733);
    paramPoint1 = new RectF(paramPoint1.x / paramInt1, (paramPoint1.y - 1.0F) / paramInt2, (paramPoint2.x - 1.0F) / paramInt1, paramPoint2.y / paramInt2);
    AppMethodBeat.o(237733);
    return paramPoint1;
  }
  
  public static float[] a(int paramInt1, Point paramPoint1, Point paramPoint2, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(237735);
    s.u(paramPoint1, "textureValidLTPoint");
    s.u(paramPoint2, "textureValidRBPoint");
    float[] arrayOfFloat = Arrays.copyOf(c.nFt, c.nFt.length);
    s.s(arrayOfFloat, "java.util.Arrays.copyOf(this, newSize)");
    float f4 = -1.0F;
    float f3 = 1.0F;
    float f2 = 1.0F;
    int i;
    int j;
    label96:
    label100:
    float f1;
    float f5;
    if (paramInt1 == 6) {
      if ((paramInt2 == 90) || (paramInt2 == 270))
      {
        paramInt2 = 1;
        i = paramPoint2.x - paramPoint1.x;
        j = paramPoint1.y - paramPoint2.y;
        if (paramInt2 == 0) {
          break label216;
        }
        paramInt1 = j;
        if (paramInt2 == 0) {
          break label222;
        }
        f1 = paramInt3 / paramInt1;
        f5 = paramInt4 / i;
        if (f1 <= f5) {
          break label229;
        }
        f3 = (f1 - f5) * paramInt1 * 1.0F / paramInt3;
        f1 = f3 - 1.0F;
        f3 = 1.0F - f3;
      }
    }
    for (;;)
    {
      arrayOfFloat[0] = f4;
      arrayOfFloat[1] = f1;
      arrayOfFloat[2] = f2;
      arrayOfFloat[3] = f1;
      arrayOfFloat[4] = f4;
      arrayOfFloat[5] = f3;
      arrayOfFloat[6] = f2;
      arrayOfFloat[7] = f3;
      AppMethodBeat.o(237735);
      return arrayOfFloat;
      paramInt2 = 0;
      break;
      label216:
      paramInt1 = i;
      break label96;
      label222:
      i = j;
      break label100;
      label229:
      f1 = i * (f5 - f1) * 1.0F / paramInt4;
      f4 = -1.0F + f1;
      f2 = 1.0F - f1;
      f1 = -1.0F;
      continue;
      f1 = -1.0F;
    }
  }
  
  public static final float bp(float paramFloat)
  {
    float f;
    if (paramFloat > 1.0F) {
      f = 1.0F;
    }
    do
    {
      return f;
      f = paramFloat;
    } while (paramFloat >= 0.0F);
    return 0.0F;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.media.j.c.b
 * JD-Core Version:    0.7.0.1
 */