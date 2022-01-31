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

public final class xo
  extends c
{
  private final int height = 72;
  private final int width = 80;
  
  public final int a(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 80;
      return 72;
      Canvas localCanvas = (Canvas)paramVarArgs[0];
      paramVarArgs = (Looper)paramVarArgs[1];
      Object localObject1 = c.h(paramVarArgs);
      float[] arrayOfFloat = c.g(paramVarArgs);
      Object localObject2 = c.k(paramVarArgs);
      ((Paint)localObject2).setFlags(385);
      ((Paint)localObject2).setStyle(Paint.Style.FILL);
      Paint localPaint = c.k(paramVarArgs);
      localPaint.setFlags(385);
      localPaint.setStyle(Paint.Style.STROKE);
      ((Paint)localObject2).setColor(-16777216);
      localPaint.setStrokeWidth(1.0F);
      localPaint.setStrokeCap(Paint.Cap.BUTT);
      localPaint.setStrokeJoin(Paint.Join.MITER);
      localPaint.setStrokeMiter(4.0F);
      localPaint.setPathEffect(null);
      arrayOfFloat = c.a(arrayOfFloat, 1.333333F, 0.0F, 0.0F, 0.0F, 1.333333F, 0.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject1 = c.a((Paint)localObject2, paramVarArgs);
      ((Paint)localObject1).setColor(-2171170);
      localObject2 = c.l(paramVarArgs);
      ((Path)localObject2).moveTo(10.02F, 4.03F);
      ((Path)localObject2).cubicTo(16.370001F, -0.03F, 25.25F, 2.32F, 30.0F, 7.82F);
      ((Path)localObject2).cubicTo(34.75F, 2.31F, 43.650002F, -0.03F, 50.0F, 4.04F);
      ((Path)localObject2).cubicTo(56.639999F, 8.75F, 57.400002F, 18.370001F, 54.619999F, 25.459999F);
      ((Path)localObject2).cubicTo(49.990002F, 36.689999F, 40.549999F, 45.380001F, 30.0F, 51.040001F);
      ((Path)localObject2).cubicTo(19.440001F, 45.380001F, 10.0F, 36.68F, 5.38F, 25.440001F);
      ((Path)localObject2).cubicTo(2.59F, 18.35F, 3.37F, 8.73F, 10.02F, 4.03F);
      ((Path)localObject2).moveTo(10.78F, 12.53F);
      ((Path)localObject2).cubicTo(9.05F, 17.389999F, 9.87F, 23.01F, 12.63F, 27.35F);
      ((Path)localObject2).cubicTo(16.91F, 34.259998F, 23.389999F, 39.459999F, 30.0F, 44.02F);
      ((Path)localObject2).cubicTo(35.84F, 40.009998F, 41.470001F, 35.490002F, 45.75F, 29.790001F);
      ((Path)localObject2).cubicTo(48.529999F, 26.15F, 50.43F, 21.67F, 50.080002F, 17.01F);
      ((Path)localObject2).cubicTo(50.119999F, 13.43F, 48.400002F, 9.15F, 44.52F, 8.35F);
      ((Path)localObject2).cubicTo(38.669998F, 6.6F, 34.27F, 11.91F, 30.0F, 14.96F);
      ((Path)localObject2).cubicTo(26.799999F, 12.47F, 23.719999F, 9.6F, 19.860001F, 8.15F);
      ((Path)localObject2).cubicTo(16.34F, 7.44F, 12.05F, 8.89F, 10.78F, 12.53F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 1);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      c.j(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.xo
 * JD-Core Version:    0.7.0.1
 */