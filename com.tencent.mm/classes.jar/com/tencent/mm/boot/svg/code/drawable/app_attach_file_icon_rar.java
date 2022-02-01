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

public class app_attach_file_icon_rar
  extends c
{
  private final int height = 120;
  private final int width = 120;
  
  public int doCommand(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 120;
      return 120;
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
      localObject2 = c.setMatrixFloatArray((float[])localObject2, 1.0F, 0.0F, 15.0F, 0.0F, 1.0F, 0.0F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject2);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject1 = c.instancePaint(localPaint1, paramVarArgs);
      ((Paint)localObject1).setColor(-7645398);
      localObject2 = c.instancePath(paramVarArgs);
      ((Path)localObject2).moveTo(90.0F, 116.66666F);
      ((Path)localObject2).cubicTo(90.0F, 118.50761F, 88.507614F, 120.0F, 86.666664F, 120.0F);
      ((Path)localObject2).lineTo(3.333333F, 120.0F);
      ((Path)localObject2).cubicTo(1.492384F, 120.0F, 2.242283E-013F, 118.50761F, 2.131628E-013F, 116.66666F);
      ((Path)localObject2).lineTo(2.131628E-013F, 3.333333F);
      ((Path)localObject2).cubicTo(2.129374E-013F, 1.492384F, 1.492384F, 3.002712E-015F, 3.333333F, 0.0F);
      ((Path)localObject2).lineTo(60.0F, 0.0F);
      ((Path)localObject2).lineTo(90.0F, 30.0F);
      ((Path)localObject2).lineTo(90.0F, 116.66666F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 2);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localObject2 = c.instancePaint(localPaint1, paramVarArgs);
      ((Paint)localObject2).setColor(-16777216);
      localObject1 = c.instancePath(paramVarArgs);
      ((Path)localObject1).moveTo(90.0F, 30.0F);
      ((Path)localObject1).lineTo(63.333332F, 30.0F);
      ((Path)localObject1).cubicTo(61.492386F, 30.0F, 60.0F, 28.507616F, 60.0F, 26.666666F);
      ((Path)localObject1).lineTo(60.0F, 0.0F);
      ((Path)localObject1).lineTo(60.0F, 0.0F);
      ((Path)localObject1).lineTo(90.0F, 30.0F);
      ((Path)localObject1).close();
      localCanvas.saveLayerAlpha(null, 51, 31);
      localObject2 = c.instancePaint((Paint)localObject2, paramVarArgs);
      WeChatSVGRenderC2Java.setFillType((Path)localObject1, 2);
      localCanvas.drawPath((Path)localObject1, (Paint)localObject2);
      localCanvas.restore();
      localCanvas.save();
      localObject1 = c.instancePaint(localPaint1, paramVarArgs);
      ((Paint)localObject1).setColor(-1);
      localObject2 = c.instancePath(paramVarArgs);
      ((Path)localObject2).moveTo(39.666668F, 40.0F);
      ((Path)localObject2).cubicTo(38.746193F, 40.0F, 38.0F, 39.253807F, 38.0F, 38.333332F);
      ((Path)localObject2).lineTo(38.0F, 31.666666F);
      ((Path)localObject2).cubicTo(38.0F, 30.746193F, 38.746193F, 30.0F, 39.666668F, 30.0F);
      ((Path)localObject2).lineTo(44.0F, 30.0F);
      ((Path)localObject2).lineTo(44.0F, 20.0F);
      ((Path)localObject2).lineTo(39.666668F, 20.0F);
      ((Path)localObject2).cubicTo(38.746193F, 20.0F, 38.0F, 19.253807F, 38.0F, 18.333334F);
      ((Path)localObject2).lineTo(38.0F, 11.666667F);
      ((Path)localObject2).cubicTo(38.0F, 10.746192F, 38.746193F, 10.0F, 39.666668F, 10.0F);
      ((Path)localObject2).lineTo(44.0F, 10.0F);
      ((Path)localObject2).lineTo(44.0F, 0.0F);
      ((Path)localObject2).lineTo(50.333332F, 0.0F);
      ((Path)localObject2).cubicTo(51.253807F, 5.295617E-017F, 52.0F, 0.746192F, 52.0F, 1.666667F);
      ((Path)localObject2).lineTo(52.0F, 8.333333F);
      ((Path)localObject2).cubicTo(52.0F, 9.253808F, 51.253807F, 10.0F, 50.333332F, 10.0F);
      ((Path)localObject2).lineTo(46.0F, 10.0F);
      ((Path)localObject2).lineTo(46.0F, 20.0F);
      ((Path)localObject2).lineTo(50.333332F, 20.0F);
      ((Path)localObject2).cubicTo(51.253807F, 20.0F, 52.0F, 20.746193F, 52.0F, 21.666666F);
      ((Path)localObject2).lineTo(52.0F, 28.333334F);
      ((Path)localObject2).cubicTo(52.0F, 29.253807F, 51.253807F, 30.0F, 50.333332F, 30.0F);
      ((Path)localObject2).lineTo(46.0F, 30.0F);
      ((Path)localObject2).lineTo(46.0F, 40.0F);
      ((Path)localObject2).lineTo(50.333332F, 40.0F);
      ((Path)localObject2).cubicTo(51.253807F, 40.0F, 52.0F, 40.746193F, 52.0F, 41.666668F);
      ((Path)localObject2).lineTo(52.0F, 48.333332F);
      ((Path)localObject2).cubicTo(52.0F, 49.253807F, 51.253807F, 50.0F, 50.333332F, 50.0F);
      ((Path)localObject2).lineTo(44.0F, 50.0F);
      ((Path)localObject2).lineTo(44.0F, 40.0F);
      ((Path)localObject2).lineTo(39.666668F, 40.0F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 2);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.save();
      localPaint1 = c.instancePaint(localPaint1, paramVarArgs);
      localPaint1.setColor(-1);
      localObject1 = c.instancePath(paramVarArgs);
      ((Path)localObject1).moveTo(50.333332F, 56.0F);
      ((Path)localObject1).cubicTo(51.253807F, 56.0F, 52.0F, 56.746193F, 52.0F, 57.666668F);
      ((Path)localObject1).lineTo(52.0F, 84.333336F);
      ((Path)localObject1).cubicTo(52.0F, 85.253807F, 51.253807F, 86.0F, 50.333332F, 86.0F);
      ((Path)localObject1).lineTo(39.666668F, 86.0F);
      ((Path)localObject1).cubicTo(38.746193F, 86.0F, 38.0F, 85.253807F, 38.0F, 84.333336F);
      ((Path)localObject1).lineTo(38.0F, 57.666668F);
      ((Path)localObject1).cubicTo(38.0F, 56.746193F, 38.746193F, 56.0F, 39.666668F, 56.0F);
      ((Path)localObject1).lineTo(50.333332F, 56.0F);
      ((Path)localObject1).close();
      ((Path)localObject1).moveTo(49.0F, 72.0F);
      ((Path)localObject1).lineTo(41.0F, 72.0F);
      ((Path)localObject1).lineTo(41.0F, 83.0F);
      ((Path)localObject1).lineTo(49.0F, 83.0F);
      ((Path)localObject1).lineTo(49.0F, 72.0F);
      ((Path)localObject1).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject1, 2);
      localCanvas.drawPath((Path)localObject1, localPaint1);
      localCanvas.restore();
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.app_attach_file_icon_rar
 * JD-Core Version:    0.7.0.1
 */