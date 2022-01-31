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

public final class ahz
  extends c
{
  private final int height = 168;
  private final int width = 168;
  
  protected final int b(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 168;
      return 168;
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
      localPaint = c.a(localPaint, paramVarArgs);
      localPaint.setColor(-8617594);
      localCanvas.save();
      localPaint = c.a(localPaint, paramVarArgs);
      localObject = c.j(paramVarArgs);
      ((Path)localObject).moveTo(129.0F, 72.0F);
      ((Path)localObject).lineTo(129.0F, 60.0F);
      ((Path)localObject).cubicTo(129.0F, 58.343147F, 127.65685F, 57.0F, 126.0F, 57.0F);
      ((Path)localObject).lineTo(83.511108F, 57.0F);
      ((Path)localObject).lineTo(75.599998F, 49.0F);
      ((Path)localObject).lineTo(43.0F, 49.0F);
      ((Path)localObject).lineTo(43.0F, 49.0F);
      ((Path)localObject).cubicTo(41.343147F, 49.0F, 40.0F, 50.343147F, 40.0F, 52.0F);
      ((Path)localObject).lineTo(40.0F, 52.0F);
      ((Path)localObject).lineTo(40.0F, 60.5F);
      ((Path)localObject).lineTo(40.0F, 72.0F);
      ((Path)localObject).lineTo(129.0F, 72.0F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(129.0F, 77.0F);
      ((Path)localObject).lineTo(129.0F, 117.0F);
      ((Path)localObject).cubicTo(129.0F, 118.65685F, 127.65685F, 120.0F, 126.0F, 120.0F);
      ((Path)localObject).lineTo(43.0F, 120.0F);
      ((Path)localObject).cubicTo(41.343147F, 120.0F, 40.0F, 118.65685F, 40.0F, 117.0F);
      ((Path)localObject).lineTo(40.0F, 77.0F);
      ((Path)localObject).lineTo(129.0F, 77.0F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 2);
      localCanvas.drawPath((Path)localObject, localPaint);
      localCanvas.restore();
      c.h(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.ahz
 * JD-Core Version:    0.7.0.1
 */