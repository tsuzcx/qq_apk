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

public class lucky_money_group_icon_new
  extends c
{
  private final int height = 48;
  private final int width = 48;
  
  public int doCommand(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 48;
      return 48;
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
      localObject2 = c.setMatrixFloatArray((float[])localObject2, 1.0F, 0.0F, -301.0F, 0.0F, 1.0F, -363.0F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject2);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject2 = c.setMatrixFloatArray((float[])localObject2, 1.0F, 0.0F, 301.0F, 0.0F, 1.0F, 363.0F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject2);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject1 = c.instancePaint(localPaint1, paramVarArgs);
      ((Paint)localObject1).setColor(-3232652);
      localObject2 = c.instancePath(paramVarArgs);
      ((Path)localObject2).moveTo(0.0F, 5.333334F);
      ((Path)localObject2).cubicTo(0.0F, 2.387815F, 2.387815F, 0.0F, 5.333334F, 0.0F);
      ((Path)localObject2).lineTo(42.666668F, 0.0F);
      ((Path)localObject2).cubicTo(45.612186F, 0.0F, 48.0F, 2.387815F, 48.0F, 5.333334F);
      ((Path)localObject2).lineTo(48.0F, 42.666668F);
      ((Path)localObject2).cubicTo(48.0F, 45.612186F, 45.612186F, 48.0F, 42.666668F, 48.0F);
      ((Path)localObject2).lineTo(5.333334F, 48.0F);
      ((Path)localObject2).cubicTo(2.387815F, 48.0F, 0.0F, 45.612186F, 0.0F, 42.666668F);
      ((Path)localObject2).lineTo(0.0F, 5.333334F);
      ((Path)localObject2).close();
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.save();
      localPaint1 = c.instancePaint(localPaint1, paramVarArgs);
      localPaint1.setColor(-1);
      localObject1 = c.instancePath(paramVarArgs);
      ((Path)localObject1).moveTo(21.169895F, 37.390083F);
      ((Path)localObject1).cubicTo(23.281897F, 36.216751F, 24.80723F, 34.54475F, 25.745895F, 32.374084F);
      ((Path)localObject1).cubicTo(26.332563F, 30.907415F, 26.772562F, 29.147415F, 27.036562F, 27.064749F);
      ((Path)localObject1).lineTo(31.641895F, 27.064749F);
      ((Path)localObject1).lineTo(31.641895F, 37.126083F);
      ((Path)localObject1).lineTo(34.340561F, 37.126083F);
      ((Path)localObject1).lineTo(34.340561F, 27.064749F);
      ((Path)localObject1).lineTo(38.065895F, 27.064749F);
      ((Path)localObject1).lineTo(38.065895F, 24.454082F);
      ((Path)localObject1).lineTo(34.340561F, 24.454082F);
      ((Path)localObject1).lineTo(34.340561F, 18.147415F);
      ((Path)localObject1).lineTo(37.479229F, 18.147415F);
      ((Path)localObject1).lineTo(37.479229F, 15.536749F);
      ((Path)localObject1).lineTo(33.900562F, 15.536749F);
      ((Path)localObject1).cubicTo(34.663231F, 14.158083F, 35.367229F, 12.603416F, 36.012562F, 10.872749F);
      ((Path)localObject1).lineTo(33.401897F, 9.934083F);
      ((Path)localObject1).cubicTo(32.697895F, 11.928749F, 31.905895F, 13.806083F, 30.996563F, 15.536749F);
      ((Path)localObject1).lineTo(26.156563F, 15.536749F);
      ((Path)localObject1).lineTo(28.004562F, 14.627416F);
      ((Path)localObject1).cubicTo(27.036562F, 12.984749F, 26.039228F, 11.459416F, 25.041895F, 10.051416F);
      ((Path)localObject1).lineTo(22.724562F, 11.136749F);
      ((Path)localObject1).cubicTo(23.721895F, 12.427416F, 24.660563F, 13.894083F, 25.540562F, 15.536749F);
      ((Path)localObject1).lineTo(21.375229F, 15.536749F);
      ((Path)localObject1).lineTo(21.375229F, 18.147415F);
      ((Path)localObject1).lineTo(24.631229F, 18.147415F);
      ((Path)localObject1).lineTo(24.631229F, 23.046083F);
      ((Path)localObject1).cubicTo(24.631229F, 23.515415F, 24.601896F, 23.984749F, 24.572563F, 24.454082F);
      ((Path)localObject1).lineTo(20.847229F, 24.454082F);
      ((Path)localObject1).lineTo(20.847229F, 27.064749F);
      ((Path)localObject1).lineTo(24.337896F, 27.064749F);
      ((Path)localObject1).cubicTo(24.161896F, 28.355415F, 23.897896F, 29.499416F, 23.545897F, 30.526083F);
      ((Path)localObject1).cubicTo(22.841896F, 32.315414F, 21.551229F, 33.811417F, 19.644562F, 34.984749F);
      ((Path)localObject1).lineTo(21.169895F, 37.390083F);
      ((Path)localObject1).close();
      ((Path)localObject1).moveTo(14.775229F, 37.038082F);
      ((Path)localObject1).cubicTo(16.681896F, 37.038082F, 17.649897F, 36.070084F, 17.649897F, 34.163418F);
      ((Path)localObject1).lineTo(17.649897F, 25.803415F);
      ((Path)localObject1).cubicTo(18.559229F, 25.363417F, 19.468563F, 24.894083F, 20.348562F, 24.395416F);
      ((Path)localObject1).lineTo(20.348562F, 21.550083F);
      ((Path)localObject1).cubicTo(19.468563F, 22.078083F, 18.559229F, 22.547417F, 17.649897F, 23.016748F);
      ((Path)localObject1).lineTo(17.649897F, 18.030083F);
      ((Path)localObject1).lineTo(20.407228F, 18.030083F);
      ((Path)localObject1).lineTo(20.407228F, 15.360749F);
      ((Path)localObject1).lineTo(17.649897F, 15.360749F);
      ((Path)localObject1).lineTo(17.649897F, 10.286082F);
      ((Path)localObject1).lineTo(14.833896F, 10.286082F);
      ((Path)localObject1).lineTo(14.833896F, 15.360749F);
      ((Path)localObject1).lineTo(11.343229F, 15.360749F);
      ((Path)localObject1).lineTo(11.343229F, 18.030083F);
      ((Path)localObject1).lineTo(14.833896F, 18.030083F);
      ((Path)localObject1).lineTo(14.833896F, 24.248749F);
      ((Path)localObject1).cubicTo(13.543229F, 24.718082F, 12.252563F, 25.12875F, 10.932563F, 25.451416F);
      ((Path)localObject1).lineTo(11.636562F, 28.267416F);
      ((Path)localObject1).cubicTo(12.692562F, 27.886084F, 13.777896F, 27.475416F, 14.833896F, 27.064749F);
      ((Path)localObject1).lineTo(14.833896F, 33.459415F);
      ((Path)localObject1).cubicTo(14.833896F, 34.134083F, 14.481895F, 34.486084F, 13.807229F, 34.486084F);
      ((Path)localObject1).cubicTo(13.161896F, 34.486084F, 12.457896F, 34.427418F, 11.724563F, 34.339417F);
      ((Path)localObject1).lineTo(12.340563F, 37.038082F);
      ((Path)localObject1).lineTo(14.775229F, 37.038082F);
      ((Path)localObject1).close();
      ((Path)localObject1).moveTo(31.641895F, 24.454082F);
      ((Path)localObject1).lineTo(27.271229F, 24.454082F);
      ((Path)localObject1).lineTo(27.329895F, 23.046083F);
      ((Path)localObject1).lineTo(27.329895F, 18.147415F);
      ((Path)localObject1).lineTo(31.641895F, 18.147415F);
      ((Path)localObject1).lineTo(31.641895F, 24.454082F);
      ((Path)localObject1).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject1, 1);
      localCanvas.drawPath((Path)localObject1, localPaint1);
      localCanvas.restore();
      localCanvas.restore();
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.lucky_money_group_icon_new
 * JD-Core Version:    0.7.0.1
 */