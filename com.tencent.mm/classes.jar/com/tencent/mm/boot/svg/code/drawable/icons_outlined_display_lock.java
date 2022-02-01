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

public class icons_outlined_display_lock
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
      ((Path)localObject).moveTo(66.0F, 45.0F);
      ((Path)localObject).lineTo(69.013809F, 45.0F);
      ((Path)localObject).cubicTo(70.663033F, 45.0F, 72.0F, 46.340096F, 72.0F, 47.987827F);
      ((Path)localObject).lineTo(72.0F, 64.512177F);
      ((Path)localObject).cubicTo(72.0F, 66.162308F, 70.633003F, 67.5F, 69.013809F, 67.5F);
      ((Path)localObject).lineTo(44.986191F, 67.5F);
      ((Path)localObject).cubicTo(43.336964F, 67.5F, 42.0F, 66.159904F, 42.0F, 64.512177F);
      ((Path)localObject).lineTo(42.0F, 64.5F);
      ((Path)localObject).lineTo(24.0F, 64.5F);
      ((Path)localObject).lineTo(24.0F, 62.699997F);
      ((Path)localObject).cubicTo(24.0F, 61.705887F, 24.798523F, 60.899998F, 25.8039F, 60.899998F);
      ((Path)localObject).lineTo(42.0F, 60.899998F);
      ((Path)localObject).lineTo(42.0F, 57.0F);
      ((Path)localObject).lineTo(9.0F, 57.0F);
      ((Path)localObject).cubicTo(7.343146F, 57.0F, 6.0F, 55.656853F, 6.0F, 54.0F);
      ((Path)localObject).lineTo(6.0F, 15.0F);
      ((Path)localObject).cubicTo(6.0F, 13.343145F, 7.343146F, 12.0F, 9.0F, 12.0F);
      ((Path)localObject).lineTo(63.0F, 12.0F);
      ((Path)localObject).cubicTo(64.656853F, 12.0F, 66.0F, 13.343145F, 66.0F, 15.0F);
      ((Path)localObject).lineTo(66.0F, 45.0F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(62.400002F, 36.419296F);
      ((Path)localObject).lineTo(62.400002F, 15.6F);
      ((Path)localObject).lineTo(9.6F, 15.6F);
      ((Path)localObject).lineTo(9.6F, 53.400002F);
      ((Path)localObject).lineTo(42.0F, 53.400002F);
      ((Path)localObject).lineTo(42.0F, 47.987827F);
      ((Path)localObject).cubicTo(42.0F, 46.337696F, 43.366993F, 45.0F, 44.986191F, 45.0F);
      ((Path)localObject).lineTo(48.0F, 45.0F);
      ((Path)localObject).lineTo(48.0F, 44.099998F);
      ((Path)localObject).cubicTo(48.0F, 38.798065F, 52.029438F, 34.5F, 57.0F, 34.5F);
      ((Path)localObject).cubicTo(59.026093F, 34.5F, 60.895809F, 35.214134F, 62.400002F, 36.419296F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(51.599998F, 45.0F);
      ((Path)localObject).lineTo(62.400002F, 45.0F);
      ((Path)localObject).lineTo(62.400002F, 44.099998F);
      ((Path)localObject).cubicTo(62.400002F, 40.736214F, 59.928551F, 38.099998F, 57.0F, 38.099998F);
      ((Path)localObject).cubicTo(54.071449F, 38.099998F, 51.599998F, 40.736214F, 51.599998F, 44.099998F);
      ((Path)localObject).lineTo(51.599998F, 45.0F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(45.599998F, 63.900002F);
      ((Path)localObject).lineTo(68.400002F, 63.900002F);
      ((Path)localObject).lineTo(68.400002F, 48.599998F);
      ((Path)localObject).lineTo(45.599998F, 48.599998F);
      ((Path)localObject).lineTo(45.599998F, 63.900002F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 1);
      localCanvas.drawPath((Path)localObject, localPaint);
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.icons_outlined_display_lock
 * JD-Core Version:    0.7.0.1
 */