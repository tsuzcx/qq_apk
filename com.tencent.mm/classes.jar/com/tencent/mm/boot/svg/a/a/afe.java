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

public final class afe
  extends c
{
  private final int height = 96;
  private final int width = 96;
  
  protected final int b(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 96;
      return 96;
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
      localPaint.setColor(-16896);
      localCanvas.save();
      localPaint = c.a(localPaint, paramVarArgs);
      localObject = c.j(paramVarArgs);
      ((Path)localObject).moveTo(5.208067F, 81.849251F);
      ((Path)localObject).cubicTo(3.954158F, 83.99987F, 4.950728F, 85.743301F, 7.447475F, 85.743301F);
      ((Path)localObject).lineTo(88.746384F, 85.743301F);
      ((Path)localObject).cubicTo(91.237083F, 85.743301F, 92.23893F, 83.998543F, 90.985794F, 81.849251F);
      ((Path)localObject).lineTo(50.367332F, 12.183118F);
      ((Path)localObject).cubicTo(49.113426F, 10.032495F, 47.079659F, 10.033827F, 45.826527F, 12.183118F);
      ((Path)localObject).lineTo(5.208067F, 81.849251F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(45.896564F, 36.946117F);
      ((Path)localObject).cubicTo(45.070587F, 36.946117F, 44.432064F, 37.617371F, 44.470753F, 38.453403F);
      ((Path)localObject).lineTo(45.63274F, 63.562759F);
      ((Path)localObject).lineTo(50.5597F, 63.562759F);
      ((Path)localObject).lineTo(51.721687F, 38.453403F);
      ((Path)localObject).cubicTo(51.760212F, 37.620953F, 51.122555F, 36.946117F, 50.295876F, 36.946117F);
      ((Path)localObject).lineTo(45.896564F, 36.946117F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(48.096222F, 75.39238F);
      ((Path)localObject).cubicTo(50.137035F, 75.39238F, 51.791443F, 73.737289F, 51.791443F, 71.695625F);
      ((Path)localObject).cubicTo(51.791443F, 69.653961F, 50.137035F, 67.998871F, 48.096222F, 67.998871F);
      ((Path)localObject).cubicTo(46.055405F, 67.998871F, 44.401001F, 69.653961F, 44.401001F, 71.695625F);
      ((Path)localObject).cubicTo(44.401001F, 73.737289F, 46.055405F, 75.39238F, 48.096222F, 75.39238F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 2);
      localCanvas.drawPath((Path)localObject, localPaint);
      localCanvas.restore();
      c.h(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.afe
 * JD-Core Version:    0.7.0.1
 */