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

public class app_brand_desktop_full_empty_icon
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
      localCanvas.saveLayerAlpha(null, 230, 31);
      localPaint = c.instancePaint(localPaint, paramVarArgs);
      localPaint.setColor(-1);
      localCanvas.save();
      localPaint = c.instancePaint(localPaint, paramVarArgs);
      localObject = c.instancePath(paramVarArgs);
      ((Path)localObject).moveTo(49.0F, 9.0F);
      ((Path)localObject).cubicTo(45.693001F, 9.0F, 42.613998F, 9.879F, 40.0F, 11.374F);
      ((Path)localObject).cubicTo(35.205002F, 14.118F, 32.0F, 18.968F, 32.0F, 24.5F);
      ((Path)localObject).lineTo(32.0F, 47.5F);
      ((Path)localObject).cubicTo(32.0F, 51.641998F, 27.969999F, 55.0F, 23.0F, 55.0F);
      ((Path)localObject).cubicTo(18.028999F, 55.0F, 14.0F, 51.641998F, 14.0F, 47.5F);
      ((Path)localObject).cubicTo(14.0F, 44.551998F, 16.046F, 42.008999F, 19.014999F, 40.783001F);
      ((Path)localObject).cubicTo(19.229F, 40.695F, 19.445999F, 40.611F, 19.669001F, 40.536999F);
      ((Path)localObject).cubicTo(21.538F, 39.786999F, 23.141001F, 38.379002F, 23.736F, 36.743999F);
      ((Path)localObject).cubicTo(24.615F, 34.330002F, 22.979F, 32.374001F, 20.083F, 32.374001F);
      ((Path)localObject).cubicTo(19.361F, 32.374001F, 18.629F, 32.495998F, 17.923F, 32.716F);
      ((Path)localObject).cubicTo(17.92F, 32.716999F, 17.917F, 32.717999F, 17.913F, 32.719002F);
      ((Path)localObject).cubicTo(13.726F, 33.921001F, 10.231F, 36.556999F, 8.133F, 40.0F);
      ((Path)localObject).cubicTo(6.778F, 42.224998F, 6.0F, 44.779999F, 6.0F, 47.5F);
      ((Path)localObject).cubicTo(6.0F, 56.047001F, 13.626F, 63.0F, 23.0F, 63.0F);
      ((Path)localObject).cubicTo(26.306999F, 63.0F, 29.386F, 62.120998F, 32.0F, 60.625999F);
      ((Path)localObject).cubicTo(36.794998F, 57.882F, 40.0F, 53.032001F, 40.0F, 47.5F);
      ((Path)localObject).lineTo(40.0F, 24.5F);
      ((Path)localObject).cubicTo(40.0F, 20.358F, 44.028999F, 17.0F, 49.0F, 17.0F);
      ((Path)localObject).cubicTo(53.970001F, 17.0F, 58.0F, 20.358F, 58.0F, 24.5F);
      ((Path)localObject).cubicTo(58.0F, 27.573999F, 55.780998F, 30.216F, 52.604F, 31.374001F);
      ((Path)localObject).cubicTo(50.555F, 32.061001F, 48.875999F, 33.543999F, 48.236F, 35.300999F);
      ((Path)localObject).cubicTo(47.362F, 37.702999F, 48.990002F, 39.651001F, 51.873001F, 39.651001F);
      ((Path)localObject).cubicTo(52.526001F, 39.651001F, 53.186001F, 39.539001F, 53.828999F, 39.356998F);
      ((Path)localObject).cubicTo(53.933998F, 39.327999F, 54.037998F, 39.296001F, 54.141998F, 39.264999F);
      ((Path)localObject).cubicTo(58.304001F, 38.056F, 61.778F, 35.428001F, 63.866001F, 32.0F);
      ((Path)localObject).cubicTo(65.222F, 29.775999F, 66.0F, 27.219999F, 66.0F, 24.5F);
      ((Path)localObject).cubicTo(66.0F, 15.953F, 58.374001F, 9.0F, 49.0F, 9.0F);
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 1);
      localCanvas.drawPath((Path)localObject, localPaint);
      localCanvas.restore();
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.app_brand_desktop_full_empty_icon
 * JD-Core Version:    0.7.0.1
 */