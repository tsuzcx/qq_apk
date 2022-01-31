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

public final class oy
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
      Object localObject = c.h(paramVarArgs);
      float[] arrayOfFloat = c.g(paramVarArgs);
      Paint localPaint1 = c.k(paramVarArgs);
      localPaint1.setFlags(385);
      localPaint1.setStyle(Paint.Style.FILL);
      Paint localPaint2 = c.k(paramVarArgs);
      localPaint2.setFlags(385);
      localPaint2.setStyle(Paint.Style.STROKE);
      localPaint1.setColor(-16777216);
      localPaint2.setStrokeWidth(1.0F);
      localPaint2.setStrokeCap(Paint.Cap.BUTT);
      localPaint2.setStrokeJoin(Paint.Join.MITER);
      localPaint2.setStrokeMiter(4.0F);
      localPaint2.setPathEffect(null);
      c.a(localPaint2, paramVarArgs).setStrokeWidth(1.0F);
      localCanvas.saveLayerAlpha(null, 230, 4);
      localCanvas.save();
      arrayOfFloat = c.a(arrayOfFloat, -1.0F, 0.0F, 72.0F, 0.0F, 1.0F, 0.0F);
      ((Matrix)localObject).reset();
      ((Matrix)localObject).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject);
      localCanvas.restore();
      localCanvas.save();
      localPaint1 = c.a(localPaint1, paramVarArgs);
      localPaint1.setColor(-16777216);
      arrayOfFloat = c.a(arrayOfFloat, -1.0F, 0.0F, 83.550003F, 0.0F, 1.0F, 0.0F);
      ((Matrix)localObject).reset();
      ((Matrix)localObject).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject);
      localObject = c.l(paramVarArgs);
      ((Path)localObject).moveTo(46.217442F, 20.4F);
      ((Path)localObject).cubicTo(50.099129F, 24.392387F, 52.5F, 29.907822F, 52.5F, 36.0F);
      ((Path)localObject).cubicTo(52.5F, 42.092178F, 50.099129F, 47.607613F, 46.217442F, 51.599998F);
      ((Path)localObject).lineTo(42.717262F, 48.0F);
      ((Path)localObject).cubicTo(45.703175F, 44.928932F, 47.549999F, 40.686291F, 47.549999F, 36.0F);
      ((Path)localObject).cubicTo(47.549999F, 31.313709F, 45.703175F, 27.071068F, 42.717262F, 24.0F);
      ((Path)localObject).lineTo(46.217442F, 20.4F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(38.050358F, 28.799999F);
      ((Path)localObject).cubicTo(39.841904F, 30.642641F, 40.950001F, 33.188225F, 40.950001F, 36.0F);
      ((Path)localObject).cubicTo(40.950001F, 38.811775F, 39.841904F, 41.357361F, 38.050358F, 43.200001F);
      ((Path)localObject).lineTo(31.049999F, 36.0F);
      ((Path)localObject).lineTo(38.050358F, 28.799999F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 1);
      localCanvas.drawPath((Path)localObject, localPaint1);
      localCanvas.restore();
      localCanvas.restore();
      c.j(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.oy
 * JD-Core Version:    0.7.0.1
 */