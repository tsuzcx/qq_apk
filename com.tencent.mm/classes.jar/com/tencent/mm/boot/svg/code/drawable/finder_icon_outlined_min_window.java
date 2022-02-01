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

public class finder_icon_outlined_min_window
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
      localPaint.setColor(-436207616);
      localCanvas.save();
      localPaint = c.instancePaint(localPaint, paramVarArgs);
      localObject = c.instancePath(paramVarArgs);
      ((Path)localObject).moveTo(28.598009F, 40.41F);
      ((Path)localObject).cubicTo(30.254864F, 40.41F, 31.598009F, 41.753147F, 31.598009F, 43.41F);
      ((Path)localObject).lineTo(31.598009F, 57.66F);
      ((Path)localObject).lineTo(27.098009F, 57.66F);
      ((Path)localObject).lineTo(27.098009F, 48.091515F);
      ((Path)localObject).lineTo(12.72F, 62.464516F);
      ((Path)localObject).lineTo(9.54F, 59.284515F);
      ((Path)localObject).lineTo(23.912008F, 44.911514F);
      ((Path)localObject).lineTo(14.348009F, 44.91F);
      ((Path)localObject).lineTo(14.348009F, 40.41F);
      ((Path)localObject).lineTo(28.598009F, 40.41F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(59.28801F, 9.530009F);
      ((Path)localObject).lineTo(62.46801F, 12.71001F);
      ((Path)localObject).lineTo(48.096001F, 27.08301F);
      ((Path)localObject).lineTo(57.66F, 27.084524F);
      ((Path)localObject).lineTo(57.66F, 31.584524F);
      ((Path)localObject).lineTo(43.41F, 31.584524F);
      ((Path)localObject).cubicTo(41.753147F, 31.584524F, 40.41F, 30.241379F, 40.41F, 28.584524F);
      ((Path)localObject).lineTo(40.41F, 14.334524F);
      ((Path)localObject).lineTo(44.91F, 14.334524F);
      ((Path)localObject).lineTo(44.91F, 23.903009F);
      ((Path)localObject).lineTo(59.28801F, 9.530009F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 2);
      localCanvas.drawPath((Path)localObject, localPaint);
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.finder_icon_outlined_min_window
 * JD-Core Version:    0.7.0.1
 */