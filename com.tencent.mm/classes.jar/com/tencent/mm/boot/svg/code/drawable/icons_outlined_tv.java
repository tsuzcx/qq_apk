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

public class icons_outlined_tv
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
      ((Path)localObject).moveTo(9.6F, 15.6F);
      ((Path)localObject).lineTo(9.6F, 53.400002F);
      ((Path)localObject).lineTo(62.400002F, 53.400002F);
      ((Path)localObject).lineTo(62.400002F, 15.6F);
      ((Path)localObject).lineTo(9.6F, 15.6F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(6.0F, 15.0F);
      ((Path)localObject).cubicTo(6.0F, 13.343145F, 7.343146F, 12.0F, 9.0F, 12.0F);
      ((Path)localObject).lineTo(63.0F, 12.0F);
      ((Path)localObject).cubicTo(64.656853F, 12.0F, 66.0F, 13.343145F, 66.0F, 15.0F);
      ((Path)localObject).lineTo(66.0F, 54.0F);
      ((Path)localObject).cubicTo(66.0F, 55.656853F, 64.656853F, 57.0F, 63.0F, 57.0F);
      ((Path)localObject).lineTo(9.0F, 57.0F);
      ((Path)localObject).cubicTo(7.343146F, 57.0F, 6.0F, 55.656853F, 6.0F, 54.0F);
      ((Path)localObject).lineTo(6.0F, 15.0F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(24.0F, 62.699997F);
      ((Path)localObject).cubicTo(24.0F, 61.705887F, 24.798523F, 60.899998F, 25.8039F, 60.899998F);
      ((Path)localObject).lineTo(46.196098F, 60.899998F);
      ((Path)localObject).cubicTo(47.192368F, 60.899998F, 48.0F, 61.698956F, 48.0F, 62.699997F);
      ((Path)localObject).lineTo(48.0F, 64.5F);
      ((Path)localObject).lineTo(24.0F, 64.5F);
      ((Path)localObject).lineTo(24.0F, 62.699997F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(29.428711F, 45.0F);
      ((Path)localObject).lineTo(26.147461F, 45.0F);
      ((Path)localObject).lineTo(26.147461F, 26.689453F);
      ((Path)localObject).lineTo(19.672852F, 26.689453F);
      ((Path)localObject).lineTo(19.672852F, 23.862305F);
      ((Path)localObject).lineTo(35.888672F, 23.862305F);
      ((Path)localObject).lineTo(35.888672F, 26.689453F);
      ((Path)localObject).lineTo(29.428711F, 26.689453F);
      ((Path)localObject).lineTo(29.428711F, 45.0F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(45.120117F, 45.0F);
      ((Path)localObject).lineTo(41.53125F, 45.0F);
      ((Path)localObject).lineTo(33.987305F, 23.862305F);
      ((Path)localObject).lineTo(37.546875F, 23.862305F);
      ((Path)localObject).lineTo(43.303711F, 41.308594F);
      ((Path)localObject).lineTo(43.391602F, 41.308594F);
      ((Path)localObject).lineTo(49.163086F, 23.862305F);
      ((Path)localObject).lineTo(52.664063F, 23.862305F);
      ((Path)localObject).lineTo(45.120117F, 45.0F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 1);
      localCanvas.drawPath((Path)localObject, localPaint);
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.icons_outlined_tv
 * JD-Core Version:    0.7.0.1
 */