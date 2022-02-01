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

public class app_brand_open_material_badge_icon
  extends c
{
  private final int height = 96;
  private final int width = 96;
  
  public int doCommand(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 96;
      return 96;
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
      localPaint.setColor(-1);
      localCanvas.save();
      localPaint = c.instancePaint(localPaint, paramVarArgs);
      localObject = c.instancePath(paramVarArgs);
      ((Path)localObject).moveTo(61.0F, 21.0F);
      ((Path)localObject).cubicTo(57.693001F, 21.0F, 54.613998F, 21.879F, 52.0F, 23.374001F);
      ((Path)localObject).cubicTo(47.205002F, 26.118F, 44.0F, 30.968F, 44.0F, 36.5F);
      ((Path)localObject).lineTo(44.0F, 59.5F);
      ((Path)localObject).cubicTo(44.0F, 63.641998F, 39.970001F, 67.0F, 35.0F, 67.0F);
      ((Path)localObject).cubicTo(30.028999F, 67.0F, 26.0F, 63.641998F, 26.0F, 59.5F);
      ((Path)localObject).cubicTo(26.0F, 56.551998F, 28.046F, 54.008999F, 31.014999F, 52.783001F);
      ((Path)localObject).cubicTo(31.229F, 52.695F, 31.445999F, 52.611F, 31.669001F, 52.536999F);
      ((Path)localObject).cubicTo(33.537998F, 51.786999F, 35.140999F, 50.379002F, 35.736F, 48.743999F);
      ((Path)localObject).cubicTo(36.615002F, 46.330002F, 34.979F, 44.374001F, 32.083F, 44.374001F);
      ((Path)localObject).cubicTo(31.361F, 44.374001F, 30.629F, 44.495998F, 29.923F, 44.716F);
      ((Path)localObject).cubicTo(29.92F, 44.716999F, 29.917F, 44.717999F, 29.913F, 44.719002F);
      ((Path)localObject).cubicTo(25.726F, 45.921001F, 22.231001F, 48.556999F, 20.132999F, 52.0F);
      ((Path)localObject).cubicTo(18.778F, 54.224998F, 18.0F, 56.779999F, 18.0F, 59.5F);
      ((Path)localObject).cubicTo(18.0F, 68.046997F, 25.625999F, 75.0F, 35.0F, 75.0F);
      ((Path)localObject).cubicTo(38.306999F, 75.0F, 41.386002F, 74.121002F, 44.0F, 72.625999F);
      ((Path)localObject).cubicTo(48.794998F, 69.882004F, 52.0F, 65.031998F, 52.0F, 59.5F);
      ((Path)localObject).lineTo(52.0F, 36.5F);
      ((Path)localObject).cubicTo(52.0F, 32.358002F, 56.028999F, 29.0F, 61.0F, 29.0F);
      ((Path)localObject).cubicTo(65.970001F, 29.0F, 70.0F, 32.358002F, 70.0F, 36.5F);
      ((Path)localObject).cubicTo(70.0F, 39.574001F, 67.780998F, 42.216F, 64.603996F, 43.374001F);
      ((Path)localObject).cubicTo(62.555F, 44.061001F, 60.875999F, 45.543999F, 60.236F, 47.300999F);
      ((Path)localObject).cubicTo(59.362F, 49.702999F, 60.990002F, 51.651001F, 63.873001F, 51.651001F);
      ((Path)localObject).cubicTo(64.526001F, 51.651001F, 65.185997F, 51.539001F, 65.829002F, 51.356998F);
      ((Path)localObject).cubicTo(65.933998F, 51.327999F, 66.038002F, 51.296001F, 66.141998F, 51.264999F);
      ((Path)localObject).cubicTo(70.304001F, 50.056F, 73.778F, 47.428001F, 75.865997F, 44.0F);
      ((Path)localObject).cubicTo(77.222F, 41.776001F, 78.0F, 39.220001F, 78.0F, 36.5F);
      ((Path)localObject).cubicTo(78.0F, 27.952999F, 70.374001F, 21.0F, 61.0F, 21.0F);
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 2);
      localCanvas.drawPath((Path)localObject, localPaint);
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.app_brand_open_material_badge_icon
 * JD-Core Version:    0.7.0.1
 */