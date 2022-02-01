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

public final class arr
  extends c
{
  private final int height = 72;
  private final int width = 72;
  
  public final int a(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 72;
      return 72;
      Canvas localCanvas = (Canvas)paramVarArgs[0];
      paramVarArgs = (Looper)paramVarArgs[1];
      Object localObject1 = c.j(paramVarArgs);
      float[] arrayOfFloat = c.i(paramVarArgs);
      Object localObject2 = c.m(paramVarArgs);
      ((Paint)localObject2).setFlags(385);
      ((Paint)localObject2).setStyle(Paint.Style.FILL);
      Paint localPaint = c.m(paramVarArgs);
      localPaint.setFlags(385);
      localPaint.setStyle(Paint.Style.STROKE);
      ((Paint)localObject2).setColor(-16777216);
      localPaint.setStrokeWidth(1.0F);
      localPaint.setStrokeCap(Paint.Cap.BUTT);
      localPaint.setStrokeJoin(Paint.Join.MITER);
      localPaint.setStrokeMiter(4.0F);
      localPaint.setPathEffect(null);
      c.a(localPaint, paramVarArgs).setStrokeWidth(1.0F);
      localCanvas.save();
      arrayOfFloat = c.a(arrayOfFloat, 1.0F, 0.0F, 6.0F, 0.0F, 1.0F, 12.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject1);
      localObject1 = c.a((Paint)localObject2, paramVarArgs);
      ((Paint)localObject1).setColor(-16777216);
      localCanvas.save();
      localObject1 = c.a((Paint)localObject1, paramVarArgs);
      localObject2 = c.n(paramVarArgs);
      ((Path)localObject2).moveTo(58.5F, 34.5F);
      ((Path)localObject2).cubicTo(59.328426F, 34.5F, 60.0F, 35.171574F, 60.0F, 36.0F);
      ((Path)localObject2).cubicTo(60.0F, 36.43211F, 59.813652F, 36.843231F, 59.488693F, 37.128044F);
      ((Path)localObject2).lineTo(44.690472F, 50.098175F);
      ((Path)localObject2).cubicTo(44.19207F, 50.535007F, 43.433914F, 50.485096F, 42.997082F, 49.986694F);
      ((Path)localObject2).cubicTo(42.636261F, 49.57502F, 42.599781F, 48.971336F, 42.908401F, 48.519211F);
      ((Path)localObject2).lineTo(50.310001F, 38.099998F);
      ((Path)localObject2).lineTo(23.996721F, 38.099998F);
      ((Path)localObject2).lineTo(23.996721F, 34.5F);
      ((Path)localObject2).lineTo(58.5F, 34.5F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(57.02459F, 0.0F);
      ((Path)localObject2).cubicTo(58.667866F, 0.0F, 60.0F, 1.333893F, 60.0F, 3.002615F);
      ((Path)localObject2).lineTo(60.0F, 18.0F);
      ((Path)localObject2).lineTo(56.398998F, 18.0F);
      ((Path)localObject2).lineTo(56.400002F, 3.6F);
      ((Path)localObject2).lineTo(3.6F, 3.6F);
      ((Path)localObject2).lineTo(3.6F, 44.400002F);
      ((Path)localObject2).lineTo(36.0F, 44.400002F);
      ((Path)localObject2).lineTo(36.0F, 48.0F);
      ((Path)localObject2).lineTo(2.975409F, 48.0F);
      ((Path)localObject2).cubicTo(1.332136F, 48.0F, 0.0F, 46.666107F, 0.0F, 44.997383F);
      ((Path)localObject2).lineTo(0.0F, 3.002615F);
      ((Path)localObject2).cubicTo(0.0F, 1.344317F, 1.365917F, 0.0F, 2.975409F, 0.0F);
      ((Path)localObject2).lineTo(57.02459F, 0.0F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(40.999641F, 13.013306F);
      ((Path)localObject2).cubicTo(41.360462F, 13.42498F, 41.396938F, 14.028662F, 41.088318F, 14.48079F);
      ((Path)localObject2).lineTo(33.689999F, 24.9F);
      ((Path)localObject2).lineTo(60.0F, 24.9F);
      ((Path)localObject2).lineTo(60.0F, 28.5F);
      ((Path)localObject2).lineTo(25.496721F, 28.5F);
      ((Path)localObject2).cubicTo(24.668295F, 28.5F, 23.996721F, 27.828426F, 23.996721F, 27.0F);
      ((Path)localObject2).cubicTo(23.996721F, 26.56789F, 24.183069F, 26.156771F, 24.50803F, 25.871954F);
      ((Path)localObject2).lineTo(39.306252F, 12.901824F);
      ((Path)localObject2).cubicTo(39.804653F, 12.464992F, 40.562809F, 12.514904F, 40.999641F, 13.013306F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 1);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.restore();
      c.l(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.arr
 * JD-Core Version:    0.7.0.1
 */