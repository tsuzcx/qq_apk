package com.tencent.mm.media.j.c;

import android.graphics.Point;
import android.graphics.RectF;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.k.c;
import java.util.Arrays;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/media/render/util/RenderProcessCropUtil;", "", "()V", "calculateCropTextureCoord", "", "scaleType", "", "textureWidth", "textureHeight", "textureValidLTPoint", "Landroid/graphics/Point;", "textureValidRBPoint", "rotate", "drawWidth", "drawHeight", "textureCropRect", "Landroid/graphics/Rect;", "calculateCube", "getValidTextureArea", "Landroid/graphics/RectF;", "validLeftTopPoint", "validRightBottomPoint", "plugin-mediaeditor_release"})
public final class a
{
  public static final a lag;
  
  static
  {
    AppMethodBeat.i(260413);
    lag = new a();
    AppMethodBeat.o(260413);
  }
  
  public static RectF a(Point paramPoint1, Point paramPoint2, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(260409);
    paramPoint1 = new RectF(paramPoint1.x / paramInt1, (paramPoint1.y - 1.0F) / paramInt2, (paramPoint2.x - 1.0F) / paramInt1, paramPoint2.y / paramInt2);
    AppMethodBeat.o(260409);
    return paramPoint1;
  }
  
  public static float[] a(int paramInt1, Point paramPoint1, Point paramPoint2, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(260410);
    p.k(paramPoint1, "textureValidLTPoint");
    p.k(paramPoint2, "textureValidRBPoint");
    float[] arrayOfFloat = Arrays.copyOf(c.laj, c.laj.length);
    p.j(arrayOfFloat, "java.util.Arrays.copyOf(this, newSize)");
    float f4 = -1.0F;
    float f3 = 1.0F;
    float f2 = 1.0F;
    float f1;
    switch (paramInt1)
    {
    default: 
      f1 = -1.0F;
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
      AppMethodBeat.o(260410);
      return arrayOfFloat;
      label141:
      int i;
      int j;
      if ((paramInt2 == 90) || (paramInt2 == 270))
      {
        paramInt2 = 1;
        i = paramPoint2.x - paramPoint1.x;
        j = paramPoint1.y - paramPoint2.y;
        if (paramInt2 == 0) {
          break label235;
        }
        paramInt1 = j;
        label170:
        if (paramInt2 == 0) {
          break label241;
        }
      }
      float f5;
      for (;;)
      {
        f1 = paramInt3 / paramInt1;
        f5 = paramInt4 / i;
        if (f1 <= f5) {
          break label248;
        }
        f3 = (f1 - f5) * paramInt1 * 1.0F / paramInt3;
        f1 = f3 - 1.0F;
        f3 = 1.0F - f3;
        break;
        paramInt2 = 0;
        break label141;
        label235:
        paramInt1 = i;
        break label170;
        label241:
        i = j;
      }
      label248:
      f1 = i * (f5 - f1) * 1.0F / paramInt4;
      f4 = -1.0F + f1;
      f2 = 1.0F - f1;
      f1 = -1.0F;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.media.j.c.a
 * JD-Core Version:    0.7.0.1
 */