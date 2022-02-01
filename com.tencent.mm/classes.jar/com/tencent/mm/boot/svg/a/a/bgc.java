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

public final class bgc
  extends c
{
  private final int height = 14;
  private final int width = 18;
  
  public final int a(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 18;
      return 14;
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
      ((Paint)localObject2).setColor(-1);
      arrayOfFloat = c.a(arrayOfFloat, 1.0F, 0.0F, -363.0F, 0.0F, 1.0F, -511.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      arrayOfFloat = c.a(arrayOfFloat, 1.0F, 0.0F, 356.0F, 0.0F, 1.0F, 502.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      arrayOfFloat = c.a(arrayOfFloat, 1.0F, 0.0F, 6.0F, 0.0F, 1.0F, 6.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject1 = c.a((Paint)localObject2, paramVarArgs);
      localObject2 = c.n(paramVarArgs);
      ((Path)localObject2).moveTo(5.0F, 5.416667F);
      ((Path)localObject2).lineTo(5.0F, 4.166667F);
      ((Path)localObject2).cubicTo(5.0F, 3.70643F, 5.373096F, 3.333333F, 5.833334F, 3.333333F);
      ((Path)localObject2).lineTo(17.5F, 3.333333F);
      ((Path)localObject2).cubicTo(17.960238F, 3.333333F, 18.333334F, 3.70643F, 18.333334F, 4.166667F);
      ((Path)localObject2).lineTo(18.333334F, 12.5F);
      ((Path)localObject2).cubicTo(18.333334F, 12.960238F, 17.960238F, 13.333333F, 17.5F, 13.333333F);
      ((Path)localObject2).lineTo(16.25F, 13.333333F);
      ((Path)localObject2).lineTo(16.25F, 6.666667F);
      ((Path)localObject2).cubicTo(16.25F, 5.976311F, 15.690356F, 5.416667F, 15.0F, 5.416667F);
      ((Path)localObject2).lineTo(5.0F, 5.416667F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(2.5F, 6.666667F);
      ((Path)localObject2).lineTo(14.166667F, 6.666667F);
      ((Path)localObject2).cubicTo(14.626904F, 6.666667F, 15.0F, 7.039763F, 15.0F, 7.5F);
      ((Path)localObject2).lineTo(15.0F, 15.833333F);
      ((Path)localObject2).cubicTo(15.0F, 16.293571F, 14.626904F, 16.666666F, 14.166667F, 16.666666F);
      ((Path)localObject2).lineTo(2.5F, 16.666666F);
      ((Path)localObject2).cubicTo(2.039763F, 16.666666F, 1.666667F, 16.293571F, 1.666667F, 15.833333F);
      ((Path)localObject2).lineTo(1.666667F, 7.5F);
      ((Path)localObject2).cubicTo(1.666667F, 7.039763F, 2.039763F, 6.666667F, 2.5F, 6.666667F);
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
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.bgc
 * JD-Core Version:    0.7.0.1
 */