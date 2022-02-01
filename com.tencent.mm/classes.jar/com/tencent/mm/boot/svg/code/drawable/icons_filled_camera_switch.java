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

public class icons_filled_camera_switch
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
      localObject2 = c.setMatrixFloatArray((float[])localObject2, 1.0F, 0.0F, 6.0F, 0.0F, 1.0F, 12.0F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject2);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject1 = c.instancePaint(localPaint1, paramVarArgs);
      localObject2 = c.instancePath(paramVarArgs);
      ((Path)localObject2).moveTo(38.197224F, 5.551115E-015F);
      ((Path)localObject2).cubicTo(38.698753F, 5.458986E-015F, 39.167103F, 0.2506517F, 39.445301F, 0.6679497F);
      ((Path)localObject2).lineTo(45.0F, 9.0F);
      ((Path)localObject2).lineTo(57.0F, 9.0F);
      ((Path)localObject2).cubicTo(58.656853F, 9.0F, 60.0F, 10.343145F, 60.0F, 12.0F);
      ((Path)localObject2).lineTo(60.0F, 45.0F);
      ((Path)localObject2).cubicTo(60.0F, 46.656853F, 58.656853F, 48.0F, 57.0F, 48.0F);
      ((Path)localObject2).lineTo(3.0F, 48.0F);
      ((Path)localObject2).cubicTo(1.343146F, 48.0F, 6.864245E-015F, 46.656853F, 6.661338E-015F, 45.0F);
      ((Path)localObject2).lineTo(7.105427E-015F, 12.0F);
      ((Path)localObject2).cubicTo(6.902521E-015F, 10.343145F, 1.343146F, 9.0F, 3.0F, 9.0F);
      ((Path)localObject2).lineTo(15.0F, 9.0F);
      ((Path)localObject2).lineTo(20.554701F, 0.6679497F);
      ((Path)localObject2).cubicTo(20.832899F, 0.2506517F, 21.301247F, -3.46466E-015F, 21.802776F, -2.220446E-015F);
      ((Path)localObject2).lineTo(38.197224F, 0.0F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(23.1F, 36.819073F);
      ((Path)localObject2).cubicTo(25.051779F, 38.193138F, 27.431664F, 39.0F, 30.0F, 39.0F);
      ((Path)localObject2).cubicTo(36.627419F, 39.0F, 42.0F, 33.627419F, 42.0F, 27.0F);
      ((Path)localObject2).lineTo(38.400002F, 27.0F);
      ((Path)localObject2).cubicTo(38.400002F, 31.639193F, 34.639191F, 35.400002F, 30.0F, 35.400002F);
      ((Path)localObject2).cubicTo(28.070463F, 35.400002F, 26.254343F, 34.746292F, 24.801285F, 33.599998F);
      ((Path)localObject2).lineTo(28.5F, 33.599998F);
      ((Path)localObject2).lineTo(28.5F, 30.0F);
      ((Path)localObject2).lineTo(21.0F, 30.0F);
      ((Path)localObject2).cubicTo(20.171574F, 30.0F, 19.5F, 30.671574F, 19.5F, 31.5F);
      ((Path)localObject2).lineTo(19.5F, 33.599998F);
      ((Path)localObject2).lineTo(19.5F, 39.0F);
      ((Path)localObject2).lineTo(23.1F, 39.0F);
      ((Path)localObject2).lineTo(23.1F, 36.819073F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(36.900002F, 17.180929F);
      ((Path)localObject2).cubicTo(34.948219F, 15.806861F, 32.568336F, 15.0F, 30.0F, 15.0F);
      ((Path)localObject2).cubicTo(23.372583F, 15.0F, 18.0F, 20.372583F, 18.0F, 27.0F);
      ((Path)localObject2).lineTo(21.6F, 27.0F);
      ((Path)localObject2).cubicTo(21.6F, 22.360807F, 25.360807F, 18.6F, 30.0F, 18.6F);
      ((Path)localObject2).cubicTo(31.931503F, 18.6F, 33.747807F, 19.255857F, 35.198837F, 20.4F);
      ((Path)localObject2).lineTo(31.5F, 20.4F);
      ((Path)localObject2).lineTo(31.5F, 24.0F);
      ((Path)localObject2).lineTo(36.900002F, 24.0F);
      ((Path)localObject2).lineTo(39.0F, 24.0F);
      ((Path)localObject2).cubicTo(39.828426F, 24.0F, 40.5F, 23.328426F, 40.5F, 22.5F);
      ((Path)localObject2).lineTo(40.5F, 15.0F);
      ((Path)localObject2).lineTo(36.900002F, 15.0F);
      ((Path)localObject2).lineTo(36.900002F, 17.180929F);
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
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.icons_filled_camera_switch
 * JD-Core Version:    0.7.0.1
 */