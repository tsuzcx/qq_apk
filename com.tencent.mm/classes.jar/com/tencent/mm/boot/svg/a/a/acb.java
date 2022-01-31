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

public final class acb
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
      ((Path)localObject).moveTo(12.0F, 9.0F);
      ((Path)localObject).lineTo(60.0F, 9.0F);
      ((Path)localObject).cubicTo(61.656853F, 9.0F, 63.0F, 10.343145F, 63.0F, 12.0F);
      ((Path)localObject).lineTo(63.0F, 60.0F);
      ((Path)localObject).cubicTo(63.0F, 61.656853F, 61.656853F, 63.0F, 60.0F, 63.0F);
      ((Path)localObject).lineTo(12.0F, 63.0F);
      ((Path)localObject).cubicTo(10.343145F, 63.0F, 9.0F, 61.656853F, 9.0F, 60.0F);
      ((Path)localObject).lineTo(9.0F, 12.0F);
      ((Path)localObject).cubicTo(9.0F, 10.343145F, 10.343145F, 9.0F, 12.0F, 9.0F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(39.0F, 27.0F);
      ((Path)localObject).lineTo(49.5F, 27.0F);
      ((Path)localObject).lineTo(49.5F, 21.0F);
      ((Path)localObject).lineTo(22.5F, 21.0F);
      ((Path)localObject).lineTo(22.5F, 27.0F);
      ((Path)localObject).lineTo(33.0F, 27.0F);
      ((Path)localObject).lineTo(33.0F, 51.0F);
      ((Path)localObject).lineTo(39.0F, 51.0F);
      ((Path)localObject).lineTo(39.0F, 27.0F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 2);
      localCanvas.drawPath((Path)localObject, localPaint);
      localCanvas.restore();
      c.j(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.acb
 * JD-Core Version:    0.7.0.1
 */