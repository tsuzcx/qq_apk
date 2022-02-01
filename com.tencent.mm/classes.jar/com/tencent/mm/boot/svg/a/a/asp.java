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

public final class asp
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
      ((Path)localObject).moveTo(48.0F, 54.0F);
      ((Path)localObject).lineTo(48.0F, 63.0F);
      ((Path)localObject).cubicTo(48.0F, 64.656853F, 46.656853F, 66.0F, 45.0F, 66.0F);
      ((Path)localObject).lineTo(15.0F, 66.0F);
      ((Path)localObject).cubicTo(13.343145F, 66.0F, 12.0F, 64.656853F, 12.0F, 63.0F);
      ((Path)localObject).lineTo(12.0F, 21.0F);
      ((Path)localObject).cubicTo(12.0F, 19.343145F, 13.343145F, 18.0F, 15.0F, 18.0F);
      ((Path)localObject).lineTo(24.0F, 18.0F);
      ((Path)localObject).lineTo(24.0F, 9.0F);
      ((Path)localObject).cubicTo(24.0F, 7.343146F, 25.343145F, 6.0F, 27.0F, 6.0F);
      ((Path)localObject).lineTo(57.0F, 6.0F);
      ((Path)localObject).cubicTo(58.656853F, 6.0F, 60.0F, 7.343146F, 60.0F, 9.0F);
      ((Path)localObject).lineTo(60.0F, 51.0F);
      ((Path)localObject).cubicTo(60.0F, 52.656853F, 58.656853F, 54.0F, 57.0F, 54.0F);
      ((Path)localObject).lineTo(48.0F, 54.0F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(48.0F, 50.400002F);
      ((Path)localObject).lineTo(56.400002F, 50.400002F);
      ((Path)localObject).lineTo(56.400002F, 9.6F);
      ((Path)localObject).lineTo(27.6F, 9.6F);
      ((Path)localObject).lineTo(27.6F, 18.0F);
      ((Path)localObject).lineTo(45.0F, 18.0F);
      ((Path)localObject).cubicTo(46.656853F, 18.0F, 48.0F, 19.343145F, 48.0F, 21.0F);
      ((Path)localObject).lineTo(48.0F, 50.400002F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(44.400002F, 62.400002F);
      ((Path)localObject).lineTo(44.400002F, 21.6F);
      ((Path)localObject).lineTo(15.6F, 21.6F);
      ((Path)localObject).lineTo(15.6F, 62.400002F);
      ((Path)localObject).lineTo(44.400002F, 62.400002F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(30.0F, 60.0F);
      ((Path)localObject).cubicTo(28.343145F, 60.0F, 27.0F, 58.656853F, 27.0F, 57.0F);
      ((Path)localObject).cubicTo(27.0F, 55.343147F, 28.343145F, 54.0F, 30.0F, 54.0F);
      ((Path)localObject).cubicTo(31.656855F, 54.0F, 33.0F, 55.343147F, 33.0F, 57.0F);
      ((Path)localObject).cubicTo(33.0F, 58.656853F, 31.656855F, 60.0F, 30.0F, 60.0F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 1);
      localCanvas.drawPath((Path)localObject, localPaint);
      localCanvas.restore();
      c.l(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.asp
 * JD-Core Version:    0.7.0.1
 */