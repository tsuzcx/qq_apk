package com.tencent.mm.boot.svg.code.drawable;

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

public class icons_outlined_link
  extends c
{
  private final int height = 72;
  private final int width = 72;
  
  public int doCommand(int paramInt, Object... paramVarArgs)
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
      Object localObject1 = c.instanceMatrix(paramVarArgs);
      Object localObject2 = c.instanceMatrixArray(paramVarArgs);
      Paint localPaint1 = c.instancePaint(paramVarArgs);
      localPaint1.setFlags(385);
      localPaint1.setStyle(Paint.Style.FILL);
      Paint localPaint2 = c.instancePaint(paramVarArgs);
      localPaint2.setFlags(385);
      localPaint2.setStyle(Paint.Style.STROKE);
      localPaint1.setColor(-16777216);
      localPaint2.setStrokeWidth(1.0F);
      localPaint2.setStrokeCap(Paint.Cap.BUTT);
      localPaint2.setStrokeJoin(Paint.Join.MITER);
      localPaint2.setStrokeMiter(4.0F);
      localPaint2.setPathEffect(null);
      c.instancePaint(localPaint2, paramVarArgs).setStrokeWidth(1.0F);
      localCanvas.save();
      localPaint1 = c.instancePaint(localPaint1, paramVarArgs);
      localPaint1.setColor(-16777216);
      localObject2 = c.setMatrixFloatArray((float[])localObject2, 1.0F, 0.0F, 9.0F, 0.0F, 1.0F, 9.0F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject2);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject1 = c.instancePaint(localPaint1, paramVarArgs);
      localObject2 = c.instancePath(paramVarArgs);
      ((Path)localObject2).moveTo(43.970562F, 27.0F);
      ((Path)localObject2).lineTo(41.42498F, 24.454416F);
      ((Path)localObject2).lineTo(47.78894F, 18.090454F);
      ((Path)localObject2).cubicTo(51.069344F, 14.810051F, 51.069344F, 9.491465F, 47.78894F, 6.211061F);
      ((Path)localObject2).cubicTo(44.508533F, 2.930657F, 39.189949F, 2.930657F, 35.909546F, 6.211061F);
      ((Path)localObject2).lineTo(24.242283F, 17.878323F);
      ((Path)localObject2).cubicTo(20.96188F, 21.158726F, 20.96188F, 26.477312F, 24.242283F, 29.757717F);
      ((Path)localObject2).lineTo(21.696699F, 32.303303F);
      ((Path)localObject2).cubicTo(17.010408F, 27.61701F, 17.010408F, 20.01903F, 21.696699F, 15.332738F);
      ((Path)localObject2).lineTo(33.36396F, 3.665476F);
      ((Path)localObject2).cubicTo(38.050251F, -1.020815F, 45.648232F, -1.020815F, 50.334522F, 3.665476F);
      ((Path)localObject2).cubicTo(55.020817F, 8.351768F, 55.020817F, 15.949747F, 50.334522F, 20.63604F);
      ((Path)localObject2).lineTo(43.970562F, 27.0F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(10.029437F, 27.0F);
      ((Path)localObject2).lineTo(12.575022F, 29.545584F);
      ((Path)localObject2).lineTo(6.211061F, 35.909546F);
      ((Path)localObject2).cubicTo(2.930657F, 39.189949F, 2.930657F, 44.508533F, 6.211061F, 47.78894F);
      ((Path)localObject2).cubicTo(9.491465F, 51.069344F, 14.810051F, 51.069344F, 18.090454F, 47.78894F);
      ((Path)localObject2).lineTo(29.757717F, 36.121677F);
      ((Path)localObject2).cubicTo(33.03812F, 32.841274F, 33.03812F, 27.522688F, 29.757717F, 24.242283F);
      ((Path)localObject2).lineTo(32.303303F, 21.696699F);
      ((Path)localObject2).cubicTo(36.989594F, 26.38299F, 36.989594F, 33.980972F, 32.303303F, 38.667263F);
      ((Path)localObject2).lineTo(20.63604F, 50.334522F);
      ((Path)localObject2).cubicTo(15.949747F, 55.020817F, 8.351768F, 55.020817F, 3.665476F, 50.334522F);
      ((Path)localObject2).cubicTo(-1.020815F, 45.648232F, -1.020815F, 38.050251F, 3.665476F, 33.36396F);
      ((Path)localObject2).lineTo(10.029437F, 27.0F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 1);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.icons_outlined_link
 * JD-Core Version:    0.7.0.1
 */