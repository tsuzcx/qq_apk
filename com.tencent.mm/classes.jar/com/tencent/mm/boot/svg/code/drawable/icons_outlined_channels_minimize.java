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

public class icons_outlined_channels_minimize
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
      ((Path)localObject).moveTo(66.0F, 40.5F);
      ((Path)localObject).lineTo(66.0F, 59.142857F);
      ((Path)localObject).cubicTo(66.0F, 61.273098F, 64.273102F, 63.0F, 62.142857F, 63.0F);
      ((Path)localObject).lineTo(43.5F, 63.0F);
      ((Path)localObject).lineTo(43.5F, 59.398998F);
      ((Path)localObject).lineTo(59.854F, 59.398998F);
      ((Path)localObject).lineTo(43.727207F, 43.272793F);
      ((Path)localObject).lineTo(46.272793F, 40.727207F);
      ((Path)localObject).lineTo(62.400002F, 56.855F);
      ((Path)localObject).lineTo(62.400002F, 40.5F);
      ((Path)localObject).lineTo(66.0F, 40.5F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(56.997757F, 12.0F);
      ((Path)localObject).cubicTo(58.536266F, 12.0F, 59.79446F, 13.147984F, 59.967758F, 14.64F);
      ((Path)localObject).lineTo(59.997757F, 15.0F);
      ((Path)localObject).lineTo(59.997757F, 33.002182F);
      ((Path)localObject).lineTo(56.397758F, 33.002182F);
      ((Path)localObject).lineTo(56.397758F, 15.6F);
      ((Path)localObject).lineTo(12.6F, 15.6F);
      ((Path)localObject).lineTo(12.6F, 53.385899F);
      ((Path)localObject).lineTo(36.0F, 53.385899F);
      ((Path)localObject).lineTo(36.0F, 56.985897F);
      ((Path)localObject).lineTo(12.0F, 56.985897F);
      ((Path)localObject).cubicTo(10.461493F, 56.985897F, 9.193479F, 55.837914F, 9.020184F, 54.345898F);
      ((Path)localObject).lineTo(9.0F, 53.985897F);
      ((Path)localObject).lineTo(9.0F, 15.0F);
      ((Path)localObject).cubicTo(9.0F, 13.461493F, 10.15812F, 12.203296F, 11.650137F, 12.03F);
      ((Path)localObject).lineTo(12.0F, 12.0F);
      ((Path)localObject).lineTo(56.997757F, 12.0F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 1);
      localCanvas.drawPath((Path)localObject, localPaint);
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.icons_outlined_channels_minimize
 * JD-Core Version:    0.7.0.1
 */