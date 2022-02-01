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

public class icons_outlined_max_window
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
      localObject2 = c.setMatrixFloatArray((float[])localObject2, 1.0F, 0.0F, 9.0F, 0.0F, 1.0F, 6.0F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject2);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject1 = c.instancePaint(localPaint1, paramVarArgs);
      localObject2 = c.instancePath(paramVarArgs);
      ((Path)localObject2).moveTo(54.0F, 42.0F);
      ((Path)localObject2).lineTo(54.0F, 54.0F);
      ((Path)localObject2).cubicTo(54.0F, 55.656853F, 52.656853F, 57.0F, 51.0F, 57.0F);
      ((Path)localObject2).lineTo(39.0F, 57.0F);
      ((Path)localObject2).lineTo(39.0F, 53.400002F);
      ((Path)localObject2).lineTo(50.400002F, 53.400002F);
      ((Path)localObject2).lineTo(50.400002F, 42.0F);
      ((Path)localObject2).lineTo(54.0F, 42.0F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(15.0F, 3.0F);
      ((Path)localObject2).lineTo(15.0F, 6.6F);
      ((Path)localObject2).lineTo(3.6F, 6.6F);
      ((Path)localObject2).lineTo(3.6F, 18.0F);
      ((Path)localObject2).lineTo(0.0F, 18.0F);
      ((Path)localObject2).lineTo(0.0F, 6.0F);
      ((Path)localObject2).cubicTo(0.0F, 4.343146F, 1.343146F, 3.0F, 3.0F, 3.0F);
      ((Path)localObject2).lineTo(15.0F, 3.0F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(50.390564F, 9.136879F);
      ((Path)localObject2).lineTo(33.974762F, 25.552683F);
      ((Path)localObject2).lineTo(31.429176F, 23.007097F);
      ((Path)localObject2).lineTo(47.844952F, 6.591321F);
      ((Path)localObject2).lineTo(38.990562F, 6.591321F);
      ((Path)localObject2).lineTo(38.990562F, 2.99132F);
      ((Path)localObject2).lineTo(50.990562F, 2.99132F);
      ((Path)localObject2).cubicTo(52.647419F, 2.99132F, 53.990562F, 4.334466F, 53.990562F, 5.991321F);
      ((Path)localObject2).lineTo(53.990562F, 17.99132F);
      ((Path)localObject2).lineTo(50.390564F, 17.99132F);
      ((Path)localObject2).lineTo(50.390564F, 9.136879F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(3.609437F, 50.863121F);
      ((Path)localObject2).lineTo(20.02524F, 34.447319F);
      ((Path)localObject2).lineTo(22.570824F, 36.992901F);
      ((Path)localObject2).lineTo(6.155047F, 53.40868F);
      ((Path)localObject2).lineTo(15.009437F, 53.40868F);
      ((Path)localObject2).lineTo(15.009437F, 57.008678F);
      ((Path)localObject2).lineTo(3.009437F, 57.008678F);
      ((Path)localObject2).cubicTo(1.352583F, 57.008678F, 0.009436794F, 55.665535F, 0.009436794F, 54.008678F);
      ((Path)localObject2).lineTo(0.009436794F, 42.008678F);
      ((Path)localObject2).lineTo(3.609437F, 42.008678F);
      ((Path)localObject2).lineTo(3.609437F, 50.863121F);
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
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.icons_outlined_max_window
 * JD-Core Version:    0.7.0.1
 */