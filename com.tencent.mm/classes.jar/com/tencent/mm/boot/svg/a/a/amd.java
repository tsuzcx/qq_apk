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

public final class amd
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
      localCanvas.save();
      localPaint = c.a(localPaint, paramVarArgs);
      localPaint.setColor(-16777216);
      localObject = c.n(paramVarArgs);
      ((Path)localObject).moveTo(12.0F, 9.0F);
      ((Path)localObject).lineTo(60.0F, 9.0F);
      ((Path)localObject).cubicTo(61.656853F, 9.0F, 63.0F, 10.343145F, 63.0F, 12.0F);
      ((Path)localObject).lineTo(63.0F, 60.0F);
      ((Path)localObject).cubicTo(63.0F, 61.656853F, 61.656853F, 63.0F, 60.0F, 63.0F);
      ((Path)localObject).lineTo(12.0F, 63.0F);
      ((Path)localObject).cubicTo(10.343145F, 63.0F, 9.0F, 61.656853F, 9.0F, 60.0F);
      ((Path)localObject).lineTo(9.0F, 12.0F);
      ((Path)localObject).cubicTo(9.0F, 10.343145F, 10.343145F, 9.0F, 12.0F, 9.0F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(21.594F, 26.544001F);
      ((Path)localObject).lineTo(21.594F, 29.976F);
      ((Path)localObject).lineTo(26.610001F, 29.976F);
      ((Path)localObject).cubicTo(27.996F, 34.761002F, 30.471001F, 38.952F, 34.035F, 42.582001F);
      ((Path)localObject).cubicTo(30.603001F, 45.486F, 26.247F, 47.598F, 21.0F, 48.951F);
      ((Path)localObject).lineTo(22.848F, 51.987F);
      ((Path)localObject).cubicTo(28.226999F, 50.469002F, 32.780998F, 48.060001F, 36.477001F, 44.792999F);
      ((Path)localObject).cubicTo(39.974998F, 47.696999F, 44.363998F, 50.139F, 49.644001F, 52.118999F);
      ((Path)localObject).lineTo(51.557999F, 49.181999F);
      ((Path)localObject).cubicTo(46.542F, 47.334F, 42.318001F, 45.09F, 38.918999F, 42.383999F);
      ((Path)localObject).cubicTo(41.955002F, 39.050999F, 44.264999F, 34.925999F, 45.848999F, 29.976F);
      ((Path)localObject).lineTo(50.832001F, 29.976F);
      ((Path)localObject).lineTo(50.832001F, 26.544001F);
      ((Path)localObject).lineTo(38.358002F, 26.544001F);
      ((Path)localObject).cubicTo(37.368F, 24.399F, 36.278999F, 22.551001F, 35.091F, 21.0F);
      ((Path)localObject).lineTo(31.625999F, 22.254F);
      ((Path)localObject).cubicTo(32.813999F, 23.607F, 33.837002F, 25.025999F, 34.661999F, 26.544001F);
      ((Path)localObject).lineTo(21.594F, 26.544001F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(29.91F, 29.976F);
      ((Path)localObject).lineTo(42.285F, 29.976F);
      ((Path)localObject).cubicTo(40.998001F, 33.969002F, 39.050999F, 37.401001F, 36.477001F, 40.238998F);
      ((Path)localObject).cubicTo(33.441002F, 37.269001F, 31.263F, 33.869999F, 29.91F, 29.976F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 2);
      localCanvas.drawPath((Path)localObject, localPaint);
      localCanvas.restore();
      c.l(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.amd
 * JD-Core Version:    0.7.0.1
 */