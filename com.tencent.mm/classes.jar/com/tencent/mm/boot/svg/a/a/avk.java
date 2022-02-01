package com.tencent.mm.boot.svg.a.a;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;

public final class avk
  extends c
{
  private final int height = 72;
  private final int width = 72;
  
  public final int a(int paramInt, Object... paramVarArgs)
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
      c.j(paramVarArgs);
      c.i(paramVarArgs);
      Paint localPaint = c.m(paramVarArgs);
      localPaint.setFlags(385);
      localPaint.setStyle(Paint.Style.FILL);
      Object localObject = c.m(paramVarArgs);
      ((Paint)localObject).setFlags(385);
      ((Paint)localObject).setStyle(Paint.Style.STROKE);
      localPaint.setColor(-16777216);
      ((Paint)localObject).setStrokeWidth(1.0F);
      ((Paint)localObject).setStrokeCap(Paint.Cap.BUTT);
      ((Paint)localObject).setStrokeJoin(Paint.Join.MITER);
      ((Paint)localObject).setStrokeMiter(4.0F);
      ((Paint)localObject).setPathEffect(null);
      c.a((Paint)localObject, paramVarArgs).setStrokeWidth(1.0F);
      localPaint = c.a(localPaint, paramVarArgs);
      localPaint.setColor(-16777216);
      localCanvas.save();
      localPaint = c.a(localPaint, paramVarArgs);
      localObject = c.n(paramVarArgs);
      ((Path)localObject).moveTo(63.02459F, 12.0F);
      ((Path)localObject).cubicTo(64.667862F, 12.0F, 66.0F, 13.333893F, 66.0F, 15.002615F);
      ((Path)localObject).lineTo(66.0F, 56.997383F);
      ((Path)localObject).cubicTo(66.0F, 58.655682F, 64.634087F, 60.0F, 63.02459F, 60.0F);
      ((Path)localObject).lineTo(8.97541F, 60.0F);
      ((Path)localObject).cubicTo(7.332136F, 60.0F, 6.0F, 58.666107F, 6.0F, 56.997383F);
      ((Path)localObject).lineTo(6.0F, 15.002615F);
      ((Path)localObject).cubicTo(6.0F, 13.344316F, 7.365917F, 12.0F, 8.97541F, 12.0F);
      ((Path)localObject).lineTo(63.02459F, 12.0F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(62.400002F, 15.6F);
      ((Path)localObject).lineTo(9.6F, 15.6F);
      ((Path)localObject).lineTo(9.6F, 56.400002F);
      ((Path)localObject).lineTo(62.400002F, 56.400002F);
      ((Path)localObject).lineTo(62.400002F, 15.6F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(24.0F, 36.0F);
      ((Path)localObject).cubicTo(25.656855F, 36.0F, 27.0F, 37.343147F, 27.0F, 39.0F);
      ((Path)localObject).lineTo(27.0F, 45.0F);
      ((Path)localObject).cubicTo(27.0F, 46.656853F, 25.656855F, 48.0F, 24.0F, 48.0F);
      ((Path)localObject).lineTo(18.0F, 48.0F);
      ((Path)localObject).cubicTo(16.343145F, 48.0F, 15.0F, 46.656853F, 15.0F, 45.0F);
      ((Path)localObject).lineTo(15.0F, 39.0F);
      ((Path)localObject).cubicTo(15.0F, 37.343147F, 16.343145F, 36.0F, 18.0F, 36.0F);
      ((Path)localObject).lineTo(24.0F, 36.0F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(23.4F, 39.599998F);
      ((Path)localObject).lineTo(18.6F, 39.599998F);
      ((Path)localObject).lineTo(18.6F, 44.400002F);
      ((Path)localObject).lineTo(23.4F, 44.400002F);
      ((Path)localObject).lineTo(23.4F, 39.599998F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(57.0F, 24.0F);
      ((Path)localObject).lineTo(57.0F, 27.6F);
      ((Path)localObject).lineTo(15.0F, 27.6F);
      ((Path)localObject).lineTo(15.0F, 24.0F);
      ((Path)localObject).lineTo(57.0F, 24.0F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 1);
      localCanvas.drawPath((Path)localObject, localPaint);
      localCanvas.restore();
      c.l(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.avk
 * JD-Core Version:    0.7.0.1
 */