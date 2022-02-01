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

public class connect_icon_closenoti_on_regular
  extends c
{
  private final int height = 162;
  private final int width = 162;
  
  public int doCommand(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 162;
      return 162;
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
      localCanvas.saveLayerAlpha(null, 128, 31);
      localCanvas.save();
      localObject2 = c.setMatrixFloatArray((float[])localObject2, 1.0F, 0.0F, 1.0F, 0.0F, 1.0F, 1.0F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject2);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject1 = c.instancePaint(localPaint1, paramVarArgs);
      ((Paint)localObject1).setColor(-1);
      localObject2 = c.instancePath(paramVarArgs);
      ((Path)localObject2).moveTo(0.0F, 80.0F);
      ((Path)localObject2).cubicTo(0.0F, 35.887928F, 35.887665F, 0.0F, 80.0F, 0.0F);
      ((Path)localObject2).cubicTo(124.11234F, 0.0F, 160.0F, 35.887928F, 160.0F, 80.0F);
      ((Path)localObject2).cubicTo(160.0F, 124.11208F, 124.11234F, 160.0F, 80.0F, 160.0F);
      ((Path)localObject2).cubicTo(35.887665F, 160.0F, 0.0F, 124.11208F, 0.0F, 80.0F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 2);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.save();
      localPaint1 = c.instancePaint(localPaint1, paramVarArgs);
      localPaint1.setColor(-16139513);
      localObject1 = c.instancePath(paramVarArgs);
      ((Path)localObject1).moveTo(62.284435F, 76.0F);
      ((Path)localObject1).lineTo(88.0F, 103.0F);
      ((Path)localObject1).lineTo(57.0F, 103.0F);
      ((Path)localObject1).cubicTo(59.590897F, 99.169113F, 62.478912F, 92.101761F, 61.938694F, 79.917107F);
      ((Path)localObject1).cubicTo(62.001358F, 78.552414F, 62.116966F, 77.244446F, 62.284435F, 76.0F);
      ((Path)localObject1).moveTo(59.032513F, 80.317619F);
      ((Path)localObject1).cubicTo(59.911308F, 98.651489F, 52.0F, 103.66564F, 52.0F, 103.66564F);
      ((Path)localObject1).lineTo(52.0F, 106.0F);
      ((Path)localObject1).lineTo(96.0F, 106.0F);
      ((Path)localObject1).lineTo(60.79871F, 70.0F);
      ((Path)localObject1).cubicTo(59.848923F, 72.816193F, 59.213223F, 76.217628F, 59.032513F, 80.317619F);
      ((Path)localObject1).close();
      ((Path)localObject1).moveTo(83.020508F, 57.952671F);
      ((Path)localObject1).lineTo(83.020508F, 56.067513F);
      ((Path)localObject1).cubicTo(83.020508F, 53.063652F, 80.875374F, 51.031452F, 77.884567F, 51.031452F);
      ((Path)localObject1).cubicTo(74.90136F, 51.031452F, 73.009521F, 53.103878F, 73.009521F, 56.096867F);
      ((Path)localObject1).lineTo(73.009521F, 57.952671F);
      ((Path)localObject1).cubicTo(70.486191F, 58.716953F, 67.183861F, 60.1031F, 64.882317F, 62.578594F);
      ((Path)localObject1).lineTo(52.303719F, 50.0F);
      ((Path)localObject1).lineTo(50.0F, 52.303719F);
      ((Path)localObject1).lineTo(107.69628F, 110.0F);
      ((Path)localObject1).lineTo(110.0F, 107.69628F);
      ((Path)localObject1).lineTo(99.066299F, 96.762581F);
      ((Path)localObject1).cubicTo(97.537735F, 93.186867F, 96.320099F, 87.874939F, 96.69735F, 80.202759F);
      ((Path)localObject1).cubicTo(96.029823F, 65.393288F, 89.036926F, 59.812824F, 83.020508F, 57.952671F);
      ((Path)localObject1).close();
      ((Path)localObject1).moveTo(67.192558F, 65.0466F);
      ((Path)localObject1).lineTo(67.270584F, 64.963394F);
      ((Path)localObject1).cubicTo(68.939957F, 63.198772F, 70.999466F, 61.943111F, 73.389778F, 61.230995F);
      ((Path)localObject1).lineTo(75.990479F, 60.549137F);
      ((Path)localObject1).lineTo(75.990479F, 58.143719F);
      ((Path)localObject1).lineTo(75.990479F, 56.299133F);
      ((Path)localObject1).cubicTo(75.990479F, 55.115875F, 76.795502F, 53.989075F, 77.994507F, 53.989075F);
      ((Path)localObject1).cubicTo(79.194611F, 53.989075F, 80.000916F, 55.115875F, 80.000916F, 56.299133F);
      ((Path)localObject1).lineTo(80.000916F, 58.157768F);
      ((Path)localObject1).lineTo(80.000916F, 60.549137F);
      ((Path)localObject1).lineTo(82.404823F, 61.254768F);
      ((Path)localObject1).cubicTo(85.330345F, 62.144104F, 87.738235F, 63.841728F, 89.56147F, 66.300095F);
      ((Path)localObject1).cubicTo(92.027611F, 69.622948F, 93.425529F, 74.323563F, 93.716759F, 80.27227F);
      ((Path)localObject1).cubicTo(93.515648F, 84.521194F, 93.772812F, 88.401627F, 94.482758F, 91.880081F);
      ((Path)localObject1).lineTo(67.192558F, 65.0466F);
      ((Path)localObject1).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject1, 2);
      localCanvas.drawPath((Path)localObject1, localPaint1);
      localCanvas.restore();
      localCanvas.restore();
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.connect_icon_closenoti_on_regular
 * JD-Core Version:    0.7.0.1
 */