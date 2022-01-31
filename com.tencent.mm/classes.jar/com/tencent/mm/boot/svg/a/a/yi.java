package com.tencent.mm.boot.svg.a.a;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;

public final class yi
  extends c
{
  private final int height = 96;
  private final int width = 96;
  
  protected final int b(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 96;
      return 96;
      Canvas localCanvas = (Canvas)paramVarArgs[0];
      paramVarArgs = (Looper)paramVarArgs[1];
      Object localObject1 = c.f(paramVarArgs);
      Object localObject2 = c.e(paramVarArgs);
      Paint localPaint1 = c.i(paramVarArgs);
      localPaint1.setFlags(385);
      localPaint1.setStyle(Paint.Style.FILL);
      Paint localPaint2 = c.i(paramVarArgs);
      localPaint2.setFlags(385);
      localPaint2.setStyle(Paint.Style.STROKE);
      localPaint1.setColor(-16777216);
      localPaint2.setStrokeWidth(1.0F);
      localPaint2.setStrokeCap(Paint.Cap.BUTT);
      localPaint2.setStrokeJoin(Paint.Join.MITER);
      localPaint2.setStrokeMiter(4.0F);
      localPaint2.setPathEffect(null);
      c.a(localPaint2, paramVarArgs).setStrokeWidth(1.0F);
      localCanvas.save();
      localPaint1 = c.a(localPaint1, paramVarArgs);
      localPaint1.setColor(-4868683);
      localObject2 = c.a((float[])localObject2, 1.0F, 0.0F, 23.0F, 0.0F, 1.0F, 23.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject2);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject1 = c.a(localPaint1, paramVarArgs);
      localObject2 = c.j(paramVarArgs);
      ((Path)localObject2).moveTo(20.43F, 0.56F);
      ((Path)localObject2).cubicTo(26.75F, -0.88F, 33.580002F, 0.53F, 38.889999F, 4.21F);
      ((Path)localObject2).cubicTo(47.369999F, 10.01F, 51.779999F, 21.299999F, 49.259998F, 31.280001F);
      ((Path)localObject2).cubicTo(47.009998F, 40.43F, 39.16F, 47.82F, 29.91F, 49.59F);
      ((Path)localObject2).cubicTo(17.719999F, 51.880001F, 4.26F, 44.130001F, 0.95F, 32.0F);
      ((Path)localObject2).cubicTo(-3.19F, 18.459999F, 6.49F, 2.93F, 20.43F, 0.56F);
      ((Path)localObject2).lineTo(20.43F, 0.56F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(20.459999F, 3.53F);
      ((Path)localObject2).cubicTo(11.63F, 5.29F, 4.4F, 13.0F, 3.28F, 21.940001F);
      ((Path)localObject2).cubicTo(2.12F, 29.59F, 5.43F, 37.68F, 11.58F, 42.349998F);
      ((Path)localObject2).cubicTo(17.99F, 47.43F, 27.32F, 48.369999F, 34.619999F, 44.709999F);
      ((Path)localObject2).cubicTo(41.380001F, 41.48F, 46.200001F, 34.549999F, 46.830002F, 27.08F);
      ((Path)localObject2).cubicTo(47.610001F, 19.719999F, 44.290001F, 12.11F, 38.400002F, 7.64F);
      ((Path)localObject2).cubicTo(33.400002F, 3.72F, 26.66F, 2.21F, 20.459999F, 3.53F);
      ((Path)localObject2).lineTo(20.459999F, 3.53F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 2);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.save();
      localObject1 = c.a(localPaint1, paramVarArgs);
      localObject2 = c.j(paramVarArgs);
      ((Path)localObject2).moveTo(24.26F, 11.33F);
      ((Path)localObject2).cubicTo(27.01F, 9.64F, 29.549999F, 14.15F, 26.77F, 15.67F);
      ((Path)localObject2).cubicTo(24.01F, 17.4F, 21.42F, 12.82F, 24.26F, 11.33F);
      ((Path)localObject2).lineTo(24.26F, 11.33F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 2);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.save();
      localPaint1 = c.a(localPaint1, paramVarArgs);
      localObject1 = c.j(paramVarArgs);
      ((Path)localObject1).moveTo(21.0F, 19.0F);
      ((Path)localObject1).cubicTo(23.290001F, 19.0F, 25.58F, 19.0F, 27.870001F, 19.01F);
      ((Path)localObject1).cubicTo(27.860001F, 25.15F, 27.860001F, 31.299999F, 27.860001F, 37.450001F);
      ((Path)localObject1).cubicTo(28.91F, 37.459999F, 29.950001F, 37.470001F, 31.0F, 37.48F);
      ((Path)localObject1).lineTo(31.0F, 38.990002F);
      ((Path)localObject1).cubicTo(27.67F, 39.0F, 24.33F, 39.0F, 21.0F, 38.990002F);
      ((Path)localObject1).lineTo(21.0F, 37.490002F);
      ((Path)localObject1).cubicTo(22.049999F, 37.470001F, 23.1F, 37.439999F, 24.15F, 37.400002F);
      ((Path)localObject1).cubicTo(24.120001F, 31.780001F, 24.15F, 26.17F, 24.139999F, 20.549999F);
      ((Path)localObject1).cubicTo(23.09F, 20.540001F, 22.049999F, 20.530001F, 21.0F, 20.530001F);
      ((Path)localObject1).lineTo(21.0F, 19.0F);
      ((Path)localObject1).lineTo(21.0F, 19.0F);
      ((Path)localObject1).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject1, 2);
      localCanvas.drawPath((Path)localObject1, localPaint1);
      localCanvas.restore();
      localCanvas.restore();
      c.h(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.yi
 * JD-Core Version:    0.7.0.1
 */