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

public final class awi
  extends c
{
  private final int height = 116;
  private final int width = 132;
  
  protected final int b(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 132;
      return 116;
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
      localPaint.setColor(-15028967);
      localCanvas.save();
      localPaint = c.a(localPaint, paramVarArgs);
      localObject = c.j(paramVarArgs);
      ((Path)localObject).moveTo(48.0F, 73.0F);
      ((Path)localObject).cubicTo(47.410728F, 73.675827F, 46.739857F, 73.847969F, 46.0F, 74.0F);
      ((Path)localObject).cubicTo(44.377869F, 73.847969F, 42.943207F, 72.942841F, 42.0F, 71.0F);
      ((Path)localObject).lineTo(42.0F, 71.0F);
      ((Path)localObject).lineTo(30.0F, 45.0F);
      ((Path)localObject).cubicTo(29.756216F, 44.430573F, 29.674448F, 44.108505F, 30.0F, 44.0F);
      ((Path)localObject).cubicTo(29.674448F, 42.583309F, 30.659384F, 41.602299F, 32.0F, 41.0F);
      ((Path)localObject).cubicTo(32.369083F, 41.602299F, 32.824383F, 41.763332F, 33.0F, 42.0F);
      ((Path)localObject).lineTo(48.0F, 52.0F);
      ((Path)localObject).cubicTo(48.406815F, 52.767323F, 49.644489F, 53.163429F, 51.0F, 53.0F);
      ((Path)localObject).cubicTo(51.768604F, 53.163429F, 52.526821F, 53.01535F, 53.0F, 53.0F);
      ((Path)localObject).lineTo(120.0F, 23.0F);
      ((Path)localObject).cubicTo(107.96013F, 9.169683F, 88.276276F, 0.0F, 66.0F, 0.0F);
      ((Path)localObject).cubicTo(29.548079F, 0.0F, 0.0F, 24.525291F, 0.0F, 54.0F);
      ((Path)localObject).cubicTo(0.0F, 71.289932F, 8.890441F, 86.147629F, 23.0F, 96.0F);
      ((Path)localObject).cubicTo(23.920935F, 96.985031F, 24.651274F, 98.288109F, 25.0F, 100.0F);
      ((Path)localObject).cubicTo(24.651274F, 100.24644F, 24.547205F, 100.69251F, 25.0F, 101.0F);
      ((Path)localObject).cubicTo(23.307673F, 105.28476F, 21.529213F, 111.89641F, 21.0F, 112.0F);
      ((Path)localObject).cubicTo(21.308067F, 112.72379F, 21.090637F, 113.26427F, 21.0F, 114.0F);
      ((Path)localObject).cubicTo(21.090637F, 115.01899F, 22.075573F, 116.0F, 23.0F, 116.0F);
      ((Path)localObject).cubicTo(23.768549F, 116.0F, 24.158806F, 115.8223F, 25.0F, 116.0F);
      ((Path)localObject).lineTo(39.0F, 107.0F);
      ((Path)localObject).cubicTo(40.098042F, 106.65818F, 41.248375F, 106.27132F, 42.0F, 106.0F);
      ((Path)localObject).cubicTo(43.190369F, 106.27132F, 43.842659F, 106.37498F, 45.0F, 106.0F);
      ((Path)localObject).cubicTo(51.198086F, 108.49249F, 58.469887F, 109.56605F, 66.0F, 110.0F);
      ((Path)localObject).cubicTo(102.45007F, 109.56605F, 132.0F, 85.038902F, 132.0F, 54.0F);
      ((Path)localObject).cubicTo(132.0F, 45.617043F, 129.27563F, 36.987843F, 124.0F, 29.0F);
      ((Path)localObject).lineTo(48.0F, 73.0F);
      ((Path)localObject).lineTo(48.0F, 73.0F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 2);
      localCanvas.drawPath((Path)localObject, localPaint);
      localCanvas.restore();
      c.h(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.awi
 * JD-Core Version:    0.7.0.1
 */