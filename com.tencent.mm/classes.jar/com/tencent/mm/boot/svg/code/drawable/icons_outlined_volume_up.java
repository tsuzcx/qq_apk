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

public class icons_outlined_volume_up
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
      localCanvas.save();
      localPaint = c.instancePaint(localPaint, paramVarArgs);
      localPaint.setColor(-16777216);
      localObject = c.instancePath(paramVarArgs);
      ((Path)localObject).moveTo(36.0F, 16.23F);
      ((Path)localObject).lineTo(23.742641F, 28.48736F);
      ((Path)localObject).lineTo(9.0F, 28.48736F);
      ((Path)localObject).lineTo(9.0F, 43.487358F);
      ((Path)localObject).lineTo(23.742641F, 43.487358F);
      ((Path)localObject).lineTo(36.0F, 55.74472F);
      ((Path)localObject).lineTo(36.0F, 16.23F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(22.5F, 25.48736F);
      ((Path)localObject).lineTo(33.878681F, 14.10868F);
      ((Path)localObject).cubicTo(35.050251F, 12.937107F, 36.949749F, 12.937107F, 38.121319F, 14.10868F);
      ((Path)localObject).cubicTo(38.683929F, 14.671288F, 39.0F, 15.434351F, 39.0F, 16.23F);
      ((Path)localObject).lineTo(39.0F, 55.74472F);
      ((Path)localObject).cubicTo(39.0F, 57.401573F, 37.656853F, 58.74472F, 36.0F, 58.74472F);
      ((Path)localObject).cubicTo(35.20435F, 58.74472F, 34.441288F, 58.42865F, 33.878681F, 57.866039F);
      ((Path)localObject).lineTo(22.5F, 46.487358F);
      ((Path)localObject).lineTo(9.0F, 46.487358F);
      ((Path)localObject).cubicTo(7.343146F, 46.487358F, 6.0F, 45.144215F, 6.0F, 43.487358F);
      ((Path)localObject).lineTo(6.0F, 28.48736F);
      ((Path)localObject).cubicTo(6.0F, 26.830505F, 7.343146F, 25.48736F, 9.0F, 25.48736F);
      ((Path)localObject).lineTo(22.5F, 25.48736F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(51.92498F, 50.412338F);
      ((Path)localObject).cubicTo(55.728367F, 46.608952F, 57.900002F, 41.474628F, 57.900002F, 35.987358F);
      ((Path)localObject).cubicTo(57.900002F, 30.50009F, 55.728367F, 25.365768F, 51.92498F, 21.562382F);
      ((Path)localObject).lineTo(54.470562F, 19.016796F);
      ((Path)localObject).cubicTo(58.813709F, 23.359941F, 61.5F, 29.359941F, 61.5F, 35.987358F);
      ((Path)localObject).cubicTo(61.5F, 42.614777F, 58.813709F, 48.614777F, 54.470562F, 52.957924F);
      ((Path)localObject).lineTo(51.92498F, 50.412338F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(45.985283F, 44.472641F);
      ((Path)localObject).cubicTo(48.22353F, 42.234394F, 49.5F, 39.216476F, 49.5F, 35.987358F);
      ((Path)localObject).cubicTo(49.5F, 32.75824F, 48.22353F, 29.740326F, 45.985283F, 27.502077F);
      ((Path)localObject).lineTo(48.530865F, 24.956493F);
      ((Path)localObject).cubicTo(51.353912F, 27.779539F, 53.099998F, 31.679539F, 53.099998F, 35.987358F);
      ((Path)localObject).cubicTo(53.099998F, 40.295181F, 51.353912F, 44.195179F, 48.530865F, 47.018227F);
      ((Path)localObject).lineTo(45.985283F, 44.472641F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 2);
      localCanvas.drawPath((Path)localObject, localPaint);
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.icons_outlined_volume_up
 * JD-Core Version:    0.7.0.1
 */