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

public final class aii
  extends c
{
  private final int height = 48;
  private final int width = 48;
  
  public final int a(int paramInt, Object... paramVarArgs)
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
      Object localObject = c.j(paramVarArgs);
      float[] arrayOfFloat = c.i(paramVarArgs);
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
      localCanvas.save();
      arrayOfFloat = c.a(arrayOfFloat, 1.0F, 0.0F, -164.0F, 0.0F, 1.0F, -81.0F);
      ((Matrix)localObject).reset();
      ((Matrix)localObject).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject);
      localCanvas.save();
      arrayOfFloat = c.a(arrayOfFloat, 1.0F, 0.0F, 164.0F, 0.0F, 1.0F, 81.0F);
      ((Matrix)localObject).reset();
      ((Matrix)localObject).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject);
      localObject = c.n(paramVarArgs);
      ((Path)localObject).moveTo(0.0F, 0.0F);
      ((Path)localObject).lineTo(48.0F, 0.0F);
      ((Path)localObject).lineTo(48.0F, 48.0F);
      ((Path)localObject).lineTo(0.0F, 48.0F);
      ((Path)localObject).lineTo(0.0F, 0.0F);
      ((Path)localObject).close();
      localCanvas.save();
      localPaint1 = c.a(localPaint1, paramVarArgs);
      localPaint1.setColor(-1);
      localObject = c.n(paramVarArgs);
      ((Path)localObject).moveTo(17.0F, 8.0F);
      ((Path)localObject).cubicTo(17.552284F, 8.0F, 18.0F, 8.447715F, 18.0F, 9.0F);
      ((Path)localObject).lineTo(18.0F, 39.0F);
      ((Path)localObject).cubicTo(18.0F, 39.552284F, 17.552284F, 40.0F, 17.0F, 40.0F);
      ((Path)localObject).lineTo(7.0F, 40.0F);
      ((Path)localObject).cubicTo(6.447715F, 40.0F, 6.0F, 39.552284F, 6.0F, 39.0F);
      ((Path)localObject).lineTo(6.0F, 9.0F);
      ((Path)localObject).cubicTo(6.0F, 8.447715F, 6.447715F, 8.0F, 7.0F, 8.0F);
      ((Path)localObject).lineTo(17.0F, 8.0F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(41.0F, 8.0F);
      ((Path)localObject).cubicTo(41.552284F, 8.0F, 42.0F, 8.447715F, 42.0F, 9.0F);
      ((Path)localObject).lineTo(42.0F, 39.0F);
      ((Path)localObject).cubicTo(42.0F, 39.552284F, 41.552284F, 40.0F, 41.0F, 40.0F);
      ((Path)localObject).lineTo(31.0F, 40.0F);
      ((Path)localObject).cubicTo(30.447716F, 40.0F, 30.0F, 39.552284F, 30.0F, 39.0F);
      ((Path)localObject).lineTo(30.0F, 9.0F);
      ((Path)localObject).cubicTo(30.0F, 8.447715F, 30.447716F, 8.0F, 31.0F, 8.0F);
      ((Path)localObject).lineTo(41.0F, 8.0F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 2);
      localCanvas.drawPath((Path)localObject, localPaint1);
      localCanvas.restore();
      localCanvas.restore();
      localCanvas.restore();
      c.l(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.aii
 * JD-Core Version:    0.7.0.1
 */