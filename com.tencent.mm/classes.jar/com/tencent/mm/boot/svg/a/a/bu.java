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

public final class bu
  extends c
{
  private final int height = 46;
  private final int width = 46;
  
  protected final int b(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 46;
      return 46;
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
      localPaint.setColor(-11184811);
      localObject = c.j(paramVarArgs);
      ((Path)localObject).moveTo(33.0F, 23.0F);
      ((Path)localObject).lineTo(32.0F, 23.0F);
      ((Path)localObject).lineTo(32.0F, 23.0F);
      ((Path)localObject).lineTo(32.0F, 4.497515F);
      ((Path)localObject).cubicTo(32.0F, 3.12162F, 30.880713F, 2.0F, 29.5F, 2.0F);
      ((Path)localObject).cubicTo(28.109663F, 2.0F, 27.0F, 3.118176F, 27.0F, 4.497515F);
      ((Path)localObject).lineTo(27.0F, 23.0F);
      ((Path)localObject).lineTo(26.0F, 23.0F);
      ((Path)localObject).lineTo(26.0F, 2.497515F);
      ((Path)localObject).cubicTo(26.0F, 1.121621F, 24.880713F, -3.552714E-015F, 23.5F, -3.552714E-015F);
      ((Path)localObject).cubicTo(22.109663F, -3.552714E-015F, 21.0F, 1.118176F, 21.0F, 2.497515F);
      ((Path)localObject).lineTo(21.0F, 23.0F);
      ((Path)localObject).lineTo(21.0F, 23.0F);
      ((Path)localObject).lineTo(20.0F, 23.0F);
      ((Path)localObject).lineTo(20.0F, 23.0F);
      ((Path)localObject).lineTo(20.0F, 4.497623F);
      ((Path)localObject).cubicTo(20.0F, 3.119065F, 18.880713F, 2.0F, 17.5F, 2.0F);
      ((Path)localObject).cubicTo(16.109663F, 2.0F, 15.0F, 3.118224F, 15.0F, 4.497623F);
      ((Path)localObject).lineTo(15.0F, 23.0F);
      ((Path)localObject).lineTo(14.0F, 23.0F);
      ((Path)localObject).lineTo(14.0F, 7.492989F);
      ((Path)localObject).cubicTo(14.0F, 6.117188F, 12.880712F, 5.0F, 11.5F, 5.0F);
      ((Path)localObject).cubicTo(10.109662F, 5.0F, 9.0F, 6.116149F, 9.0F, 7.492989F);
      ((Path)localObject).lineTo(9.0F, 25.753506F);
      ((Path)localObject).lineTo(9.0F, 25.753506F);
      ((Path)localObject).lineTo(9.0F, 33.0F);
      ((Path)localObject).lineTo(9.07604F, 33.0F);
      ((Path)localObject).cubicTo(9.823915F, 40.30732F, 15.996335F, 46.0F, 23.5F, 46.0F);
      ((Path)localObject).cubicTo(31.008278F, 46.0F, 37.176189F, 40.302929F, 37.923923F, 33.0F);
      ((Path)localObject).lineTo(37.923923F, 33.0F);
      ((Path)localObject).lineTo(38.0F, 33.0F);
      ((Path)localObject).lineTo(38.0F, 26.245796F);
      ((Path)localObject).lineTo(38.0F, 17.508408F);
      ((Path)localObject).cubicTo(38.0F, 16.115417F, 36.880711F, 15.0F, 35.5F, 15.0F);
      ((Path)localObject).cubicTo(34.109661F, 15.0F, 33.0F, 16.123053F, 33.0F, 17.508408F);
      ((Path)localObject).lineTo(33.0F, 23.0F);
      ((Path)localObject).lineTo(33.0F, 23.0F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 2);
      localCanvas.drawPath((Path)localObject, localPaint);
      localCanvas.restore();
      c.h(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.bu
 * JD-Core Version:    0.7.0.1
 */