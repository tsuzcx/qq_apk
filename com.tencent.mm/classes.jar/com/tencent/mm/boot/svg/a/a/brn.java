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

public final class brn
  extends c
{
  private final int height = 120;
  private final int width = 120;
  
  public final int a(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 120;
      return 120;
      Canvas localCanvas = (Canvas)paramVarArgs[0];
      paramVarArgs = (Looper)paramVarArgs[1];
      Object localObject1 = c.j(paramVarArgs);
      float[] arrayOfFloat = c.i(paramVarArgs);
      Paint localPaint = c.m(paramVarArgs);
      localPaint.setFlags(385);
      localPaint.setStyle(Paint.Style.FILL);
      Object localObject2 = c.m(paramVarArgs);
      ((Paint)localObject2).setFlags(385);
      ((Paint)localObject2).setStyle(Paint.Style.STROKE);
      localPaint.setColor(-16777216);
      ((Paint)localObject2).setStrokeWidth(1.0F);
      ((Paint)localObject2).setStrokeCap(Paint.Cap.BUTT);
      ((Paint)localObject2).setStrokeJoin(Paint.Join.MITER);
      ((Paint)localObject2).setStrokeMiter(4.0F);
      ((Paint)localObject2).setPathEffect(null);
      arrayOfFloat = c.a(arrayOfFloat, 1.666667F, 0.0F, 0.0F, 0.0F, 1.666667F, 0.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject1);
      c.a((Paint)localObject2, paramVarArgs).setStrokeWidth(1.0F);
      localCanvas.save();
      localObject1 = c.a(localPaint, paramVarArgs);
      ((Paint)localObject1).setColor(637534208);
      localObject2 = c.n(paramVarArgs);
      ((Path)localObject2).moveTo(36.0F, 0.0F);
      ((Path)localObject2).cubicTo(55.882252F, 0.0F, 72.0F, 16.117748F, 72.0F, 36.0F);
      ((Path)localObject2).cubicTo(72.0F, 55.882252F, 55.882252F, 72.0F, 36.0F, 72.0F);
      ((Path)localObject2).cubicTo(16.117748F, 72.0F, 0.0F, 55.882252F, 0.0F, 36.0F);
      ((Path)localObject2).cubicTo(0.0F, 16.117748F, 16.117748F, 0.0F, 36.0F, 0.0F);
      ((Path)localObject2).close();
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.save();
      localPaint = c.a(localPaint, paramVarArgs);
      localPaint.setColor(-1);
      localObject1 = c.n(paramVarArgs);
      ((Path)localObject1).moveTo(36.0F, 0.0F);
      ((Path)localObject1).cubicTo(55.882252F, 0.0F, 72.0F, 16.117748F, 72.0F, 36.0F);
      ((Path)localObject1).cubicTo(72.0F, 55.882252F, 55.882252F, 72.0F, 36.0F, 72.0F);
      ((Path)localObject1).cubicTo(16.117748F, 72.0F, 0.0F, 55.882252F, 0.0F, 36.0F);
      ((Path)localObject1).cubicTo(0.0F, 16.117748F, 16.117748F, 0.0F, 36.0F, 0.0F);
      ((Path)localObject1).close();
      ((Path)localObject1).moveTo(36.0F, 2.16F);
      ((Path)localObject1).cubicTo(17.310684F, 2.16F, 2.16F, 17.310684F, 2.16F, 36.0F);
      ((Path)localObject1).cubicTo(2.16F, 54.689316F, 17.310684F, 69.839996F, 36.0F, 69.839996F);
      ((Path)localObject1).cubicTo(54.689316F, 69.839996F, 69.839996F, 54.689316F, 69.839996F, 36.0F);
      ((Path)localObject1).cubicTo(69.839996F, 17.310684F, 54.689316F, 2.16F, 36.0F, 2.16F);
      ((Path)localObject1).close();
      ((Path)localObject1).moveTo(35.98428F, 47.686035F);
      ((Path)localObject1).cubicTo(37.778713F, 47.686035F, 39.142483F, 49.025879F, 39.142483F, 50.772461F);
      ((Path)localObject1).cubicTo(39.142483F, 52.519043F, 37.778713F, 53.858887F, 35.98428F, 53.858887F);
      ((Path)localObject1).cubicTo(34.237698F, 53.858887F, 32.850002F, 52.519043F, 32.850002F, 50.772461F);
      ((Path)localObject1).cubicTo(32.850002F, 49.025879F, 34.237698F, 47.686035F, 35.98428F, 47.686035F);
      ((Path)localObject1).close();
      ((Path)localObject1).moveTo(38.663967F, 15.475098F);
      ((Path)localObject1).lineTo(38.281155F, 42.063477F);
      ((Path)localObject1).lineTo(33.71133F, 42.063477F);
      ((Path)localObject1).lineTo(33.328518F, 15.475098F);
      ((Path)localObject1).lineTo(38.663967F, 15.475098F);
      ((Path)localObject1).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject1, 1);
      localCanvas.drawPath((Path)localObject1, localPaint);
      localCanvas.restore();
      c.l(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.brn
 * JD-Core Version:    0.7.0.1
 */