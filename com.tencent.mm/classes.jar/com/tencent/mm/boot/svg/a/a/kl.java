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

public final class kl
  extends c
{
  private final int height = 144;
  private final int width = 144;
  
  protected final int b(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 144;
      return 144;
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
      localPaint.setColor(-9276814);
      localObject = c.j(paramVarArgs);
      ((Path)localObject).moveTo(120.0F, 12.0F);
      ((Path)localObject).lineTo(24.0F, 12.0F);
      ((Path)localObject).cubicTo(17.4F, 12.0F, 12.06F, 17.4F, 12.06F, 24.0F);
      ((Path)localObject).lineTo(12.0F, 132.0F);
      ((Path)localObject).lineTo(36.0F, 108.0F);
      ((Path)localObject).lineTo(120.0F, 108.0F);
      ((Path)localObject).cubicTo(126.6F, 108.0F, 132.0F, 102.6F, 132.0F, 96.0F);
      ((Path)localObject).lineTo(132.0F, 24.0F);
      ((Path)localObject).cubicTo(132.0F, 17.4F, 126.6F, 12.0F, 120.0F, 12.0F);
      ((Path)localObject).lineTo(120.0F, 12.0F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(108.0F, 84.0F);
      ((Path)localObject).lineTo(36.0F, 84.0F);
      ((Path)localObject).lineTo(36.0F, 72.0F);
      ((Path)localObject).lineTo(108.0F, 72.0F);
      ((Path)localObject).lineTo(108.0F, 84.0F);
      ((Path)localObject).lineTo(108.0F, 84.0F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(108.0F, 66.0F);
      ((Path)localObject).lineTo(36.0F, 66.0F);
      ((Path)localObject).lineTo(36.0F, 54.0F);
      ((Path)localObject).lineTo(108.0F, 54.0F);
      ((Path)localObject).lineTo(108.0F, 66.0F);
      ((Path)localObject).lineTo(108.0F, 66.0F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(108.0F, 48.0F);
      ((Path)localObject).lineTo(36.0F, 48.0F);
      ((Path)localObject).lineTo(36.0F, 36.0F);
      ((Path)localObject).lineTo(108.0F, 36.0F);
      ((Path)localObject).lineTo(108.0F, 48.0F);
      ((Path)localObject).lineTo(108.0F, 48.0F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 2);
      localCanvas.drawPath((Path)localObject, localPaint);
      localCanvas.restore();
      c.h(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.kl
 * JD-Core Version:    0.7.0.1
 */