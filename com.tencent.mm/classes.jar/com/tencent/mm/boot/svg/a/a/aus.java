package com.tencent.mm.boot.svg.a.a;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;

public final class aus
  extends c
{
  private final int height = 75;
  private final int width = 75;
  
  public final int a(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 75;
      return 75;
      Canvas localCanvas = (Canvas)paramVarArgs[0];
      paramVarArgs = (Looper)paramVarArgs[1];
      c.j(paramVarArgs);
      c.i(paramVarArgs);
      Paint localPaint = c.m(paramVarArgs);
      localPaint.setFlags(385);
      localPaint.setStyle(Paint.Style.FILL);
      Object localObject = c.m(paramVarArgs);
      ((Paint)localObject).setFlags(385);
      ((Paint)localObject).setStyle(Paint.Style.STROKE);
      localPaint.setColor(-16777216);
      ((Paint)localObject).setStrokeWidth(1.0F);
      ((Paint)localObject).setStrokeCap(Paint.Cap.BUTT);
      ((Paint)localObject).setStrokeJoin(Paint.Join.MITER);
      ((Paint)localObject).setStrokeMiter(4.0F);
      ((Paint)localObject).setPathEffect(null);
      c.a((Paint)localObject, paramVarArgs).setStrokeWidth(1.0F);
      localPaint = c.a(localPaint, paramVarArgs);
      localPaint.setColor(-15028967);
      localCanvas.save();
      localPaint = c.a(localPaint, paramVarArgs);
      localObject = c.n(paramVarArgs);
      ((Path)localObject).moveTo(4.0F, 60.0F);
      ((Path)localObject).lineTo(4.0F, 71.990364F);
      ((Path)localObject).cubicTo(4.0F, 73.652542F, 5.348283F, 75.0F, 7.007385F, 75.0F);
      ((Path)localObject).lineTo(66.992615F, 75.0F);
      ((Path)localObject).cubicTo(68.653549F, 75.0F, 70.0F, 73.666405F, 70.0F, 71.990364F);
      ((Path)localObject).lineTo(70.0F, 3.009635F);
      ((Path)localObject).cubicTo(70.0F, 1.347459F, 68.651718F, 0.0F, 66.992615F, 0.0F);
      ((Path)localObject).lineTo(7.007385F, 0.0F);
      ((Path)localObject).cubicTo(5.346452F, 0.0F, 4.0F, 1.333597F, 4.0F, 3.009635F);
      ((Path)localObject).lineTo(4.0F, 15.0F);
      ((Path)localObject).cubicTo(6.485282F, 15.0F, 8.5F, 17.014719F, 8.5F, 19.5F);
      ((Path)localObject).cubicTo(8.5F, 21.985281F, 6.485282F, 24.0F, 4.0F, 24.0F);
      ((Path)localObject).lineTo(4.0F, 51.0F);
      ((Path)localObject).cubicTo(6.485282F, 51.0F, 8.5F, 53.014717F, 8.5F, 55.5F);
      ((Path)localObject).cubicTo(8.5F, 57.985283F, 6.485282F, 60.0F, 4.0F, 60.0F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(35.160728F, 42.339272F);
      ((Path)localObject).cubicTo(31.262531F, 38.441074F, 29.434139F, 34.747486F, 29.54121F, 33.381584F);
      ((Path)localObject).cubicTo(29.648281F, 32.015678F, 31.987486F, 28.614197F, 31.95635F, 27.008419F);
      ((Path)localObject).cubicTo(31.941387F, 26.23667F, 28.530704F, 21.19352F, 28.136374F, 20.583046F);
      ((Path)localObject).cubicTo(27.742043F, 19.972572F, 27.281416F, 19.406528F, 26.698536F, 19.512964F);
      ((Path)localObject).cubicTo(26.115658F, 19.6194F, 19.695259F, 21.835806F, 20.584337F, 27.494286F);
      ((Path)localObject).cubicTo(21.473415F, 33.152767F, 27.573353F, 41.041481F, 31.963337F, 45.536663F);
      ((Path)localObject).lineTo(35.160728F, 42.339272F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(35.160728F, 42.339272F);
      ((Path)localObject).cubicTo(39.058926F, 46.237469F, 42.752514F, 48.065861F, 44.118416F, 47.95879F);
      ((Path)localObject).cubicTo(45.484322F, 47.851719F, 48.885803F, 45.512516F, 50.491581F, 45.543652F);
      ((Path)localObject).cubicTo(51.263332F, 45.558613F, 56.30648F, 48.969296F, 56.916954F, 49.363625F);
      ((Path)localObject).cubicTo(57.527428F, 49.757957F, 58.093472F, 50.218586F, 57.987034F, 50.801464F);
      ((Path)localObject).cubicTo(57.8806F, 51.384342F, 55.664196F, 57.804741F, 50.005714F, 56.915665F);
      ((Path)localObject).cubicTo(44.347233F, 56.026585F, 36.458519F, 49.926647F, 31.963337F, 45.536663F);
      ((Path)localObject).lineTo(35.160728F, 42.339272F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 2);
      localCanvas.drawPath((Path)localObject, localPaint);
      localCanvas.restore();
      c.l(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.aus
 * JD-Core Version:    0.7.0.1
 */