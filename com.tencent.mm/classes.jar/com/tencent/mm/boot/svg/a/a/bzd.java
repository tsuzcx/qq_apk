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

public final class bzd
  extends c
{
  private final int height = 16;
  private final int width = 16;
  
  public final int a(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 16;
      return 16;
      Canvas localCanvas = (Canvas)paramVarArgs[0];
      paramVarArgs = (Looper)paramVarArgs[1];
      Object localObject1 = c.j(paramVarArgs);
      float[] arrayOfFloat = c.i(paramVarArgs);
      Object localObject2 = c.m(paramVarArgs);
      ((Paint)localObject2).setFlags(385);
      ((Paint)localObject2).setStyle(Paint.Style.FILL);
      Paint localPaint = c.m(paramVarArgs);
      localPaint.setFlags(385);
      localPaint.setStyle(Paint.Style.STROKE);
      ((Paint)localObject2).setColor(-16777216);
      localPaint.setStrokeWidth(1.0F);
      localPaint.setStrokeCap(Paint.Cap.BUTT);
      localPaint.setStrokeJoin(Paint.Join.MITER);
      localPaint.setStrokeMiter(4.0F);
      localPaint.setPathEffect(null);
      c.a(localPaint, paramVarArgs).setStrokeWidth(1.0F);
      localCanvas.save();
      localObject2 = c.a((Paint)localObject2, paramVarArgs);
      ((Paint)localObject2).setColor(-2130706433);
      arrayOfFloat = c.a(arrayOfFloat, 1.0F, 0.0F, -149.0F, 0.0F, 1.0F, -698.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      arrayOfFloat = c.a(arrayOfFloat, 1.0F, 0.0F, 0.0F, 0.0F, 1.0F, 654.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      arrayOfFloat = c.a(arrayOfFloat, 1.0F, 0.0F, 16.0F, 0.0F, 1.0F, 16.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      arrayOfFloat = c.a(arrayOfFloat, 1.0F, 0.0F, 73.0F, 0.0F, 1.0F, 28.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      arrayOfFloat = c.a(arrayOfFloat, 1.0F, 0.0F, 60.0F, 0.0F, 1.0F, 0.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      arrayOfFloat = c.a(arrayOfFloat, 1.0F, 0.0F, 1.333333F, 0.0F, 1.0F, 1.333333F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject1 = c.a((Paint)localObject2, paramVarArgs);
      localObject2 = c.n(paramVarArgs);
      ((Path)localObject2).moveTo(6.666667F, 0.0F);
      ((Path)localObject2).cubicTo(10.348565F, 0.0F, 13.333333F, 2.984768F, 13.333333F, 6.666667F);
      ((Path)localObject2).cubicTo(13.333333F, 10.348565F, 10.348565F, 13.333333F, 6.666667F, 13.333333F);
      ((Path)localObject2).cubicTo(2.984768F, 13.333333F, 0.0F, 10.348565F, 0.0F, 6.666667F);
      ((Path)localObject2).cubicTo(0.0F, 2.984768F, 2.984768F, 0.0F, 6.666667F, 0.0F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(6.666667F, 0.8F);
      ((Path)localObject2).cubicTo(3.426596F, 0.8F, 0.8F, 3.426596F, 0.8F, 6.666667F);
      ((Path)localObject2).cubicTo(0.8F, 9.906737F, 3.426596F, 12.533333F, 6.666667F, 12.533333F);
      ((Path)localObject2).cubicTo(9.906737F, 12.533333F, 12.533333F, 9.906737F, 12.533333F, 6.666667F);
      ((Path)localObject2).cubicTo(12.533333F, 3.426596F, 9.906737F, 0.8F, 6.666667F, 0.8F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(7.066667F, 5.333334F);
      ((Path)localObject2).lineTo(7.066667F, 10.0F);
      ((Path)localObject2).lineTo(6.266666F, 10.0F);
      ((Path)localObject2).lineTo(6.266666F, 5.333334F);
      ((Path)localObject2).lineTo(7.066667F, 5.333334F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(6.666667F, 3.333333F);
      ((Path)localObject2).cubicTo(7.034856F, 3.333333F, 7.333334F, 3.63181F, 7.333334F, 4.0F);
      ((Path)localObject2).cubicTo(7.333334F, 4.36819F, 7.034856F, 4.666667F, 6.666667F, 4.666667F);
      ((Path)localObject2).cubicTo(6.298477F, 4.666667F, 6.0F, 4.36819F, 6.0F, 4.0F);
      ((Path)localObject2).cubicTo(6.0F, 3.63181F, 6.298477F, 3.333333F, 6.666667F, 3.333333F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 2);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.restore();
      localCanvas.restore();
      localCanvas.restore();
      localCanvas.restore();
      localCanvas.restore();
      localCanvas.restore();
      c.l(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.bzd
 * JD-Core Version:    0.7.0.1
 */