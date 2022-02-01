package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;

public class icons_filled_eyes_off
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
      c.instanceMatrix(paramVarArgs);
      c.instanceMatrixArray(paramVarArgs);
      Paint localPaint = c.instancePaint(paramVarArgs);
      localPaint.setFlags(385);
      localPaint.setStyle(Paint.Style.FILL);
      Object localObject = c.instancePaint(paramVarArgs);
      ((Paint)localObject).setFlags(385);
      ((Paint)localObject).setStyle(Paint.Style.STROKE);
      localPaint.setColor(-16777216);
      ((Paint)localObject).setStrokeWidth(1.0F);
      ((Paint)localObject).setStrokeCap(Paint.Cap.BUTT);
      ((Paint)localObject).setStrokeJoin(Paint.Join.MITER);
      ((Paint)localObject).setStrokeMiter(4.0F);
      ((Paint)localObject).setPathEffect(null);
      c.instancePaint((Paint)localObject, paramVarArgs).setStrokeWidth(1.0F);
      localPaint = c.instancePaint(localPaint, paramVarArgs);
      localPaint.setColor(-16777216);
      localCanvas.save();
      localPaint = c.instancePaint(localPaint, paramVarArgs);
      localObject = c.instancePath(paramVarArgs);
      ((Path)localObject).moveTo(56.765636F, 50.401676F);
      ((Path)localObject).lineTo(66.27565F, 59.91169F);
      ((Path)localObject).lineTo(63.09367F, 63.09367F);
      ((Path)localObject).lineTo(12.18198F, 12.18198F);
      ((Path)localObject).lineTo(15.363961F, 9.0F);
      ((Path)localObject).lineTo(23.576626F, 17.212666F);
      ((Path)localObject).cubicTo(27.459063F, 15.780132F, 31.641382F, 15.0F, 36.0F, 15.0F);
      ((Path)localObject).cubicTo(50.42337F, 15.0F, 62.916191F, 23.542883F, 69.0F, 36.0F);
      ((Path)localObject).cubicTo(66.163643F, 41.807686F, 61.934246F, 46.764591F, 56.765636F, 50.401676F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(32.471539F, 26.107576F);
      ((Path)localObject).lineTo(45.892422F, 39.528461F);
      ((Path)localObject).cubicTo(46.285793F, 38.425701F, 46.5F, 37.237865F, 46.5F, 36.0F);
      ((Path)localObject).cubicTo(46.5F, 30.20101F, 41.798988F, 25.5F, 36.0F, 25.5F);
      ((Path)localObject).cubicTo(34.762135F, 25.5F, 33.574299F, 25.714207F, 32.471539F, 26.107576F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(48.423374F, 54.787334F);
      ((Path)localObject).cubicTo(44.540939F, 56.219868F, 40.358616F, 57.0F, 36.0F, 57.0F);
      ((Path)localObject).cubicTo(21.576628F, 57.0F, 9.08381F, 48.457119F, 3.0F, 36.0F);
      ((Path)localObject).cubicTo(5.83636F, 30.192312F, 10.065755F, 25.235407F, 15.234364F, 21.598326F);
      ((Path)localObject).lineTo(26.107576F, 32.471539F);
      ((Path)localObject).cubicTo(25.714207F, 33.574299F, 25.5F, 34.762135F, 25.5F, 36.0F);
      ((Path)localObject).cubicTo(25.5F, 41.798988F, 30.20101F, 46.5F, 36.0F, 46.5F);
      ((Path)localObject).cubicTo(37.237865F, 46.5F, 38.425701F, 46.285793F, 39.528461F, 45.892422F);
      ((Path)localObject).lineTo(48.423374F, 54.787334F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 1);
      localCanvas.drawPath((Path)localObject, localPaint);
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.icons_filled_eyes_off
 * JD-Core Version:    0.7.0.1
 */