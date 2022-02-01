package com.tencent.mm.boot.svg.a.a;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;

public final class aho
  extends c
{
  private final int height = 32;
  private final int width = 32;
  
  public final int a(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 32;
      return 32;
      Canvas localCanvas = (Canvas)paramVarArgs[0];
      paramVarArgs = (Looper)paramVarArgs[1];
      Object localObject1 = c.j(paramVarArgs);
      Object localObject2 = c.i(paramVarArgs);
      Paint localPaint1 = c.m(paramVarArgs);
      localPaint1.setFlags(385);
      localPaint1.setStyle(Paint.Style.FILL);
      Paint localPaint2 = c.m(paramVarArgs);
      localPaint2.setFlags(385);
      localPaint2.setStyle(Paint.Style.STROKE);
      localPaint1.setColor(-16777216);
      localPaint2.setStrokeWidth(1.0F);
      localPaint2.setStrokeCap(Paint.Cap.BUTT);
      localPaint2.setStrokeJoin(Paint.Join.MITER);
      localPaint2.setStrokeMiter(4.0F);
      localPaint2.setPathEffect(null);
      c.a(localPaint2, paramVarArgs).setStrokeWidth(1.0F);
      localCanvas.saveLayerAlpha(null, 204, 31);
      localCanvas.save();
      localPaint1 = c.a(localPaint1, paramVarArgs);
      localPaint1.setColor(-1);
      localObject2 = c.a((float[])localObject2, 6.123234E-017F, -1.0F, 32.0F, -1.0F, -6.123234E-017F, 32.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject2);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject2 = c.a((float[])localObject2, 1.0F, 0.0F, 2.666667F, 0.0F, 1.0F, 2.666667F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject2);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject1 = c.a(localPaint1, paramVarArgs);
      localObject2 = c.n(paramVarArgs);
      ((Path)localObject2).moveTo(13.333333F, 0.0F);
      ((Path)localObject2).cubicTo(20.69713F, 0.0F, 26.666666F, 5.969537F, 26.666666F, 13.333333F);
      ((Path)localObject2).cubicTo(26.666666F, 20.69713F, 20.69713F, 26.666666F, 13.333333F, 26.666666F);
      ((Path)localObject2).cubicTo(5.969537F, 26.666666F, 0.0F, 20.69713F, 0.0F, 13.333333F);
      ((Path)localObject2).cubicTo(0.0F, 5.969537F, 5.969537F, 0.0F, 13.333333F, 0.0F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(14.604089F, 7.333334F);
      ((Path)localObject2).lineTo(9.476052F, 12.621493F);
      ((Path)localObject2).cubicTo(9.098584F, 13.010747F, 9.094818F, 13.652035F, 9.476052F, 14.045174F);
      ((Path)localObject2).lineTo(9.476052F, 14.045174F);
      ((Path)localObject2).lineTo(14.604089F, 19.333334F);
      ((Path)localObject2).lineTo(15.998045F, 17.916666F);
      ((Path)localObject2).lineTo(11.57368F, 13.333333F);
      ((Path)localObject2).lineTo(15.998045F, 8.75F);
      ((Path)localObject2).lineTo(14.604089F, 7.333334F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 2);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.restore();
      localCanvas.restore();
      localCanvas.restore();
      c.l(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.aho
 * JD-Core Version:    0.7.0.1
 */