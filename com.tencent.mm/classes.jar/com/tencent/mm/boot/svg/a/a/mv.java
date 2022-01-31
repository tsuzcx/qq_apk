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

public final class mv
  extends c
{
  private final int height = 48;
  private final int width = 63;
  
  public final int a(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 63;
      return 48;
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
      localPaint.setColor(-5066062);
      localCanvas.save();
      localPaint = c.a(localPaint, paramVarArgs);
      localObject = c.l(paramVarArgs);
      ((Path)localObject).moveTo(2.0F, 0.0F);
      ((Path)localObject).lineTo(61.0F, 0.0F);
      ((Path)localObject).cubicTo(61.110001F, 1.2F, 61.669998F, 1.83F, 63.0F, 2.0F);
      ((Path)localObject).lineTo(63.0F, 46.0F);
      ((Path)localObject).cubicTo(61.799999F, 46.099998F, 61.18F, 46.66F, 61.0F, 48.0F);
      ((Path)localObject).lineTo(2.0F, 48.0F);
      ((Path)localObject).cubicTo(1.89F, 46.799999F, 1.34F, 46.169998F, 0.0F, 46.0F);
      ((Path)localObject).lineTo(0.0F, 2.0F);
      ((Path)localObject).cubicTo(1.2F, 1.9F, 1.82F, 1.34F, 2.0F, 0.0F);
      ((Path)localObject).lineTo(2.0F, 0.0F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(6.0F, 6.0F);
      ((Path)localObject).cubicTo(6.009992F, 14.688017F, 6.039969F, 23.386019F, 6.0F, 32.0F);
      ((Path)localObject).cubicTo(9.807015F, 26.681475F, 14.5433F, 21.658401F, 20.0F, 19.0F);
      ((Path)localObject).cubicTo(23.536245F, 16.894972F, 26.683777F, 19.161846F, 29.0F, 21.0F);
      ((Path)localObject).cubicTo(33.988049F, 25.31336F, 38.404583F, 30.196625F, 43.0F, 35.0F);
      ((Path)localObject).cubicTo(41.642044F, 32.882919F, 40.323078F, 30.815771F, 39.0F, 29.0F);
      ((Path)localObject).cubicTo(41.272335F, 26.441805F, 43.510578F, 23.286158F, 47.0F, 23.0F);
      ((Path)localObject).cubicTo(51.614223F, 24.234848F, 54.332092F, 28.598829F, 57.0F, 32.0F);
      ((Path)localObject).cubicTo(56.96003F, 23.425964F, 56.990009F, 14.707989F, 57.0F, 6.0F);
      ((Path)localObject).lineTo(6.0F, 6.0F);
      ((Path)localObject).lineTo(6.0F, 6.0F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 2);
      localCanvas.drawPath((Path)localObject, localPaint);
      localCanvas.restore();
      c.j(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.mv
 * JD-Core Version:    0.7.0.1
 */