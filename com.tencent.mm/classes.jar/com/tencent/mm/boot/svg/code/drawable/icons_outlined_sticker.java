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

public class icons_outlined_sticker
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
      ((Path)localObject).moveTo(36.0F, 66.0F);
      ((Path)localObject).cubicTo(19.431458F, 66.0F, 6.0F, 52.568542F, 6.0F, 36.0F);
      ((Path)localObject).cubicTo(6.0F, 19.431458F, 19.431458F, 6.0F, 36.0F, 6.0F);
      ((Path)localObject).cubicTo(52.568542F, 6.0F, 66.0F, 19.431458F, 66.0F, 36.0F);
      ((Path)localObject).cubicTo(66.0F, 52.568542F, 52.568542F, 66.0F, 36.0F, 66.0F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(36.0F, 62.400002F);
      ((Path)localObject).cubicTo(50.580318F, 62.400002F, 62.400002F, 50.580318F, 62.400002F, 36.0F);
      ((Path)localObject).cubicTo(62.400002F, 21.419683F, 50.580318F, 9.6F, 36.0F, 9.6F);
      ((Path)localObject).cubicTo(21.419683F, 9.6F, 9.6F, 21.419683F, 9.6F, 36.0F);
      ((Path)localObject).cubicTo(9.6F, 50.580318F, 21.419683F, 62.400002F, 36.0F, 62.400002F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(18.0F, 37.5F);
      ((Path)localObject).lineTo(54.0F, 37.5F);
      ((Path)localObject).cubicTo(54.0F, 47.441124F, 45.941124F, 55.5F, 36.0F, 55.5F);
      ((Path)localObject).cubicTo(26.058874F, 55.5F, 18.0F, 47.441124F, 18.0F, 37.5F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(36.0F, 51.900002F);
      ((Path)localObject).cubicTo(42.709824F, 51.900002F, 48.347782F, 47.310818F, 49.946339F, 41.099998F);
      ((Path)localObject).lineTo(22.053663F, 41.099998F);
      ((Path)localObject).cubicTo(23.652218F, 47.310818F, 29.290178F, 51.900002F, 36.0F, 51.900002F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(25.5F, 31.5F);
      ((Path)localObject).cubicTo(23.014719F, 31.5F, 21.0F, 29.485281F, 21.0F, 27.0F);
      ((Path)localObject).cubicTo(21.0F, 24.514719F, 23.014719F, 22.5F, 25.5F, 22.5F);
      ((Path)localObject).cubicTo(27.985281F, 22.5F, 30.0F, 24.514719F, 30.0F, 27.0F);
      ((Path)localObject).cubicTo(30.0F, 29.485281F, 27.985281F, 31.5F, 25.5F, 31.5F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(46.5F, 31.5F);
      ((Path)localObject).cubicTo(44.014717F, 31.5F, 42.0F, 29.485281F, 42.0F, 27.0F);
      ((Path)localObject).cubicTo(42.0F, 24.514719F, 44.014717F, 22.5F, 46.5F, 22.5F);
      ((Path)localObject).cubicTo(48.985283F, 22.5F, 51.0F, 24.514719F, 51.0F, 27.0F);
      ((Path)localObject).cubicTo(51.0F, 29.485281F, 48.985283F, 31.5F, 46.5F, 31.5F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 1);
      localCanvas.drawPath((Path)localObject, localPaint);
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.icons_outlined_sticker
 * JD-Core Version:    0.7.0.1
 */