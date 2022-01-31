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

public final class acp
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
      c.h(paramVarArgs);
      c.g(paramVarArgs);
      Paint localPaint = c.k(paramVarArgs);
      localPaint.setFlags(385);
      localPaint.setStyle(Paint.Style.FILL);
      Object localObject = c.k(paramVarArgs);
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
      localObject = c.l(paramVarArgs);
      ((Path)localObject).moveTo(15.0F, 9.0F);
      ((Path)localObject).cubicTo(15.0F, 7.343146F, 16.343145F, 6.0F, 18.0F, 6.0F);
      ((Path)localObject).lineTo(54.0F, 6.0F);
      ((Path)localObject).cubicTo(55.656853F, 6.0F, 57.0F, 7.343146F, 57.0F, 9.0F);
      ((Path)localObject).lineTo(57.0F, 63.0F);
      ((Path)localObject).cubicTo(57.0F, 64.656853F, 55.656853F, 66.0F, 54.0F, 66.0F);
      ((Path)localObject).lineTo(18.0F, 66.0F);
      ((Path)localObject).cubicTo(16.343145F, 66.0F, 15.0F, 64.656853F, 15.0F, 63.0F);
      ((Path)localObject).lineTo(15.0F, 9.0F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(18.6F, 9.6F);
      ((Path)localObject).lineTo(18.6F, 62.400002F);
      ((Path)localObject).lineTo(53.400002F, 62.400002F);
      ((Path)localObject).lineTo(53.400002F, 9.6F);
      ((Path)localObject).lineTo(18.6F, 9.6F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(36.0F, 60.0F);
      ((Path)localObject).cubicTo(34.343147F, 60.0F, 33.0F, 58.656853F, 33.0F, 57.0F);
      ((Path)localObject).cubicTo(33.0F, 55.343147F, 34.343147F, 54.0F, 36.0F, 54.0F);
      ((Path)localObject).cubicTo(37.656853F, 54.0F, 39.0F, 55.343147F, 39.0F, 57.0F);
      ((Path)localObject).cubicTo(39.0F, 58.656853F, 37.656853F, 60.0F, 36.0F, 60.0F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 1);
      localCanvas.drawPath((Path)localObject, localPaint);
      localCanvas.restore();
      c.j(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.acp
 * JD-Core Version:    0.7.0.1
 */