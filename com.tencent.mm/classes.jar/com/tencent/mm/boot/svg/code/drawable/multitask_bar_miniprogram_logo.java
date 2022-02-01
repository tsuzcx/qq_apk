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

public class multitask_bar_miniprogram_logo
  extends c
{
  private final int height = 54;
  private final int width = 60;
  
  public int doCommand(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 60;
      return 54;
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
      localPaint.setColor(-8421505);
      localObject = c.instancePath(paramVarArgs);
      ((Path)localObject).moveTo(43.0F, 0.0F);
      ((Path)localObject).cubicTo(39.693001F, 0.0F, 36.613998F, 0.879F, 34.0F, 2.374F);
      ((Path)localObject).cubicTo(29.205F, 5.118F, 26.0F, 9.968F, 26.0F, 15.5F);
      ((Path)localObject).lineTo(26.0F, 38.5F);
      ((Path)localObject).cubicTo(26.0F, 42.641998F, 21.969999F, 46.0F, 17.0F, 46.0F);
      ((Path)localObject).cubicTo(12.029F, 46.0F, 8.0F, 42.641998F, 8.0F, 38.5F);
      ((Path)localObject).cubicTo(8.0F, 35.551998F, 10.046F, 33.008999F, 13.015F, 31.783001F);
      ((Path)localObject).cubicTo(13.229F, 31.695F, 13.446F, 31.611F, 13.669F, 31.537001F);
      ((Path)localObject).cubicTo(15.538F, 30.787001F, 17.141001F, 29.379F, 17.736F, 27.743999F);
      ((Path)localObject).cubicTo(18.615F, 25.33F, 16.979F, 23.374001F, 14.083F, 23.374001F);
      ((Path)localObject).cubicTo(13.361F, 23.374001F, 12.629F, 23.496F, 11.923F, 23.716F);
      ((Path)localObject).cubicTo(11.92F, 23.716999F, 11.917F, 23.718F, 11.913F, 23.719F);
      ((Path)localObject).cubicTo(7.726F, 24.921F, 4.231F, 27.556999F, 2.133F, 31.0F);
      ((Path)localObject).cubicTo(0.778F, 33.224998F, 0.0F, 35.779999F, 0.0F, 38.5F);
      ((Path)localObject).cubicTo(0.0F, 47.047001F, 7.626F, 54.0F, 17.0F, 54.0F);
      ((Path)localObject).cubicTo(20.306999F, 54.0F, 23.386F, 53.120998F, 26.0F, 51.625999F);
      ((Path)localObject).cubicTo(30.795F, 48.882F, 34.0F, 44.032001F, 34.0F, 38.5F);
      ((Path)localObject).lineTo(34.0F, 15.5F);
      ((Path)localObject).cubicTo(34.0F, 11.358F, 38.028999F, 8.0F, 43.0F, 8.0F);
      ((Path)localObject).cubicTo(47.970001F, 8.0F, 52.0F, 11.358F, 52.0F, 15.5F);
      ((Path)localObject).cubicTo(52.0F, 18.573999F, 49.780998F, 21.216F, 46.604F, 22.374001F);
      ((Path)localObject).cubicTo(44.555F, 23.061001F, 42.875999F, 24.544001F, 42.236F, 26.301001F);
      ((Path)localObject).cubicTo(41.362F, 28.702999F, 42.990002F, 30.650999F, 45.873001F, 30.650999F);
      ((Path)localObject).cubicTo(46.526001F, 30.650999F, 47.186001F, 30.539F, 47.828999F, 30.357F);
      ((Path)localObject).cubicTo(47.933998F, 30.327999F, 48.037998F, 30.296F, 48.141998F, 30.264999F);
      ((Path)localObject).cubicTo(52.304001F, 29.056F, 55.778F, 26.427999F, 57.866001F, 23.0F);
      ((Path)localObject).cubicTo(59.222F, 20.775999F, 60.0F, 18.219999F, 60.0F, 15.5F);
      ((Path)localObject).cubicTo(60.0F, 6.953F, 52.374001F, 0.0F, 43.0F, 0.0F);
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 1);
      localCanvas.drawPath((Path)localObject, localPaint);
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.multitask_bar_miniprogram_logo
 * JD-Core Version:    0.7.0.1
 */