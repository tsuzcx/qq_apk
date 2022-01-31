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

public final class mn
  extends c
{
  private final int height = 115;
  private final int width = 115;
  
  protected final int b(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 115;
      return 115;
      Canvas localCanvas = (Canvas)paramVarArgs[0];
      paramVarArgs = (Looper)paramVarArgs[1];
      Object localObject2 = c.f(paramVarArgs);
      Object localObject3 = c.e(paramVarArgs);
      Paint localPaint = c.i(paramVarArgs);
      localPaint.setFlags(385);
      localPaint.setStyle(Paint.Style.FILL);
      Object localObject1 = c.i(paramVarArgs);
      ((Paint)localObject1).setFlags(385);
      ((Paint)localObject1).setStyle(Paint.Style.STROKE);
      localPaint.setColor(-16777216);
      ((Paint)localObject1).setStrokeWidth(1.0F);
      ((Paint)localObject1).setStrokeCap(Paint.Cap.BUTT);
      ((Paint)localObject1).setStrokeJoin(Paint.Join.MITER);
      ((Paint)localObject1).setStrokeMiter(4.0F);
      ((Paint)localObject1).setPathEffect(null);
      localObject1 = c.a((Paint)localObject1, paramVarArgs);
      ((Paint)localObject1).setStrokeWidth(1.0F);
      localCanvas.save();
      localObject3 = c.a((float[])localObject3, 1.0F, 0.0F, -330.0F, 0.0F, 1.0F, -386.0F);
      ((Matrix)localObject2).reset();
      ((Matrix)localObject2).setValues((float[])localObject3);
      localCanvas.concat((Matrix)localObject2);
      localCanvas.save();
      localObject3 = c.a((float[])localObject3, 1.0F, 0.0F, 330.0F, 0.0F, 1.0F, 386.0F);
      ((Matrix)localObject2).reset();
      ((Matrix)localObject2).setValues((float[])localObject3);
      localCanvas.concat((Matrix)localObject2);
      localObject2 = c.a(localPaint, paramVarArgs);
      ((Paint)localObject2).setColor(1711276032);
      localCanvas.save();
      localObject2 = c.a((Paint)localObject2, paramVarArgs);
      localObject3 = c.j(paramVarArgs);
      ((Path)localObject3).moveTo(57.391304F, 0.0F);
      ((Path)localObject3).cubicTo(89.087646F, 0.0F, 114.78261F, 25.69496F, 114.78261F, 57.391304F);
      ((Path)localObject3).cubicTo(114.78261F, 89.087646F, 89.087646F, 114.78261F, 57.391304F, 114.78261F);
      ((Path)localObject3).cubicTo(25.69496F, 114.78261F, 0.0F, 89.087646F, 0.0F, 57.391304F);
      ((Path)localObject3).cubicTo(0.0F, 25.69496F, 25.69496F, 0.0F, 57.391304F, 0.0F);
      ((Path)localObject3).close();
      localCanvas.drawPath((Path)localObject3, (Paint)localObject2);
      localCanvas.restore();
      localCanvas.save();
      localObject2 = c.a((Paint)localObject1, paramVarArgs);
      ((Paint)localObject2).setColor(-1);
      ((Paint)localObject2).setStrokeWidth(6.0F);
      localObject3 = c.j(paramVarArgs);
      ((Path)localObject3).moveTo(57.391304F, 3.0F);
      ((Path)localObject3).cubicTo(87.430794F, 3.0F, 111.78261F, 27.351814F, 111.78261F, 57.391304F);
      ((Path)localObject3).cubicTo(111.78261F, 87.430794F, 87.430794F, 111.78261F, 57.391304F, 111.78261F);
      ((Path)localObject3).cubicTo(27.351814F, 111.78261F, 3.0F, 87.430794F, 3.0F, 57.391304F);
      ((Path)localObject3).cubicTo(3.0F, 27.351814F, 27.351814F, 3.0F, 57.391304F, 3.0F);
      ((Path)localObject3).close();
      localCanvas.drawPath((Path)localObject3, (Paint)localObject2);
      localCanvas.restore();
      localCanvas.save();
      localObject1 = c.a((Paint)localObject1, paramVarArgs);
      ((Paint)localObject1).setColor(419430400);
      ((Paint)localObject1).setStrokeWidth(6.0F);
      localObject2 = c.j(paramVarArgs);
      ((Path)localObject2).moveTo(57.391304F, 3.0F);
      ((Path)localObject2).cubicTo(87.430794F, 3.0F, 111.78261F, 27.351814F, 111.78261F, 57.391304F);
      ((Path)localObject2).cubicTo(111.78261F, 87.430794F, 87.430794F, 111.78261F, 57.391304F, 111.78261F);
      ((Path)localObject2).cubicTo(27.351814F, 111.78261F, 3.0F, 87.430794F, 3.0F, 57.391304F);
      ((Path)localObject2).cubicTo(3.0F, 27.351814F, 27.351814F, 3.0F, 57.391304F, 3.0F);
      ((Path)localObject2).close();
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localObject1 = c.a(localPaint, paramVarArgs);
      ((Paint)localObject1).setColor(-1);
      localCanvas.save();
      localObject1 = c.a((Paint)localObject1, paramVarArgs);
      localObject2 = c.j(paramVarArgs);
      ((Path)localObject2).moveTo(75.873352F, 59.571442F);
      ((Path)localObject2).lineTo(50.798225F, 76.710197F);
      ((Path)localObject2).lineTo(50.798225F, 76.710197F);
      ((Path)localObject2).cubicTo(49.69112F, 77.466904F, 48.180206F, 77.182846F, 47.423504F, 76.075737F);
      ((Path)localObject2).cubicTo(47.147606F, 75.672089F, 47.0F, 75.194542F, 47.0F, 74.705612F);
      ((Path)localObject2).lineTo(47.0F, 40.428093F);
      ((Path)localObject2).lineTo(47.0F, 40.428093F);
      ((Path)localObject2).cubicTo(47.0F, 39.087093F, 48.087093F, 38.0F, 49.428093F, 38.0F);
      ((Path)localObject2).cubicTo(49.917027F, 38.0F, 50.394569F, 38.147606F, 50.798225F, 38.423504F);
      ((Path)localObject2).lineTo(75.873352F, 55.562263F);
      ((Path)localObject2).lineTo(75.873352F, 55.562263F);
      ((Path)localObject2).cubicTo(76.980461F, 56.318962F, 77.264519F, 57.829876F, 76.507813F, 58.936981F);
      ((Path)localObject2).cubicTo(76.337578F, 59.186047F, 76.122421F, 59.401207F, 75.873352F, 59.571442F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 2);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localPaint = c.a(localPaint, paramVarArgs);
      localPaint.setColor(419430400);
      localCanvas.save();
      localPaint = c.a(localPaint, paramVarArgs);
      localObject1 = c.j(paramVarArgs);
      ((Path)localObject1).moveTo(75.873352F, 59.571442F);
      ((Path)localObject1).lineTo(50.798225F, 76.710197F);
      ((Path)localObject1).lineTo(50.798225F, 76.710197F);
      ((Path)localObject1).cubicTo(49.69112F, 77.466904F, 48.180206F, 77.182846F, 47.423504F, 76.075737F);
      ((Path)localObject1).cubicTo(47.147606F, 75.672089F, 47.0F, 75.194542F, 47.0F, 74.705612F);
      ((Path)localObject1).lineTo(47.0F, 40.428093F);
      ((Path)localObject1).lineTo(47.0F, 40.428093F);
      ((Path)localObject1).cubicTo(47.0F, 39.087093F, 48.087093F, 38.0F, 49.428093F, 38.0F);
      ((Path)localObject1).cubicTo(49.917027F, 38.0F, 50.394569F, 38.147606F, 50.798225F, 38.423504F);
      ((Path)localObject1).lineTo(75.873352F, 55.562263F);
      ((Path)localObject1).lineTo(75.873352F, 55.562263F);
      ((Path)localObject1).cubicTo(76.980461F, 56.318962F, 77.264519F, 57.829876F, 76.507813F, 58.936981F);
      ((Path)localObject1).cubicTo(76.337578F, 59.186047F, 76.122421F, 59.401207F, 75.873352F, 59.571442F);
      ((Path)localObject1).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject1, 2);
      localCanvas.drawPath((Path)localObject1, localPaint);
      localCanvas.restore();
      localCanvas.restore();
      localCanvas.restore();
      c.h(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.mn
 * JD-Core Version:    0.7.0.1
 */