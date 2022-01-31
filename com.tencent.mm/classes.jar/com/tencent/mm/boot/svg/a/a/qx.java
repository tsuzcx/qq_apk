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

public final class qx
  extends c
{
  private final int height = 48;
  private final int width = 48;
  
  protected final int b(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 48;
      return 48;
      Canvas localCanvas = (Canvas)paramVarArgs[0];
      paramVarArgs = (Looper)paramVarArgs[1];
      c.f(paramVarArgs);
      c.e(paramVarArgs);
      Paint localPaint = c.i(paramVarArgs);
      localPaint.setFlags(385);
      localPaint.setStyle(Paint.Style.FILL);
      Object localObject = c.i(paramVarArgs);
      ((Paint)localObject).setFlags(385);
      ((Paint)localObject).setStyle(Paint.Style.STROKE);
      localPaint.setColor(-16777216);
      ((Paint)localObject).setStrokeWidth(1.0F);
      ((Paint)localObject).setStrokeCap(Paint.Cap.BUTT);
      ((Paint)localObject).setStrokeJoin(Paint.Join.MITER);
      ((Paint)localObject).setStrokeMiter(4.0F);
      ((Paint)localObject).setPathEffect(null);
      c.a((Paint)localObject, paramVarArgs).setStrokeWidth(1.0F);
      localCanvas.save();
      localPaint = c.a(localPaint, paramVarArgs);
      localPaint.setColor(-855310);
      localObject = c.j(paramVarArgs);
      ((Path)localObject).moveTo(19.757359F, 24.0F);
      ((Path)localObject).lineTo(11.272078F, 32.485283F);
      ((Path)localObject).lineTo(15.514719F, 36.727921F);
      ((Path)localObject).lineTo(24.0F, 28.242641F);
      ((Path)localObject).lineTo(32.485283F, 36.727921F);
      ((Path)localObject).lineTo(36.727921F, 32.485283F);
      ((Path)localObject).lineTo(28.242641F, 24.0F);
      ((Path)localObject).lineTo(36.727921F, 15.514719F);
      ((Path)localObject).lineTo(32.485283F, 11.272078F);
      ((Path)localObject).lineTo(24.0F, 19.757359F);
      ((Path)localObject).lineTo(15.514719F, 11.272078F);
      ((Path)localObject).lineTo(11.272078F, 15.514719F);
      ((Path)localObject).lineTo(19.757359F, 24.0F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(24.0F, 48.0F);
      ((Path)localObject).cubicTo(10.745166F, 48.0F, 0.0F, 37.254833F, 0.0F, 24.0F);
      ((Path)localObject).cubicTo(0.0F, 10.745166F, 10.745166F, 0.0F, 24.0F, 0.0F);
      ((Path)localObject).cubicTo(37.254833F, 0.0F, 48.0F, 10.745166F, 48.0F, 24.0F);
      ((Path)localObject).cubicTo(48.0F, 37.254833F, 37.254833F, 48.0F, 24.0F, 48.0F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 2);
      localCanvas.drawPath((Path)localObject, localPaint);
      localCanvas.restore();
      c.h(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.qx
 * JD-Core Version:    0.7.0.1
 */