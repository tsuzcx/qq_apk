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

public final class aaj
  extends c
{
  private final int height = 24;
  private final int width = 24;
  
  public final int a(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 24;
      return 24;
      Object localObject1 = (Canvas)paramVarArgs[0];
      paramVarArgs = (Looper)paramVarArgs[1];
      Object localObject2 = c.h(paramVarArgs);
      float[] arrayOfFloat = c.g(paramVarArgs);
      Object localObject3 = c.k(paramVarArgs);
      ((Paint)localObject3).setFlags(385);
      ((Paint)localObject3).setStyle(Paint.Style.FILL);
      Paint localPaint = c.k(paramVarArgs);
      localPaint.setFlags(385);
      localPaint.setStyle(Paint.Style.STROKE);
      ((Paint)localObject3).setColor(-16777216);
      localPaint.setStrokeWidth(1.0F);
      localPaint.setStrokeCap(Paint.Cap.BUTT);
      localPaint.setStrokeJoin(Paint.Join.MITER);
      localPaint.setStrokeMiter(4.0F);
      localPaint.setPathEffect(null);
      localPaint = c.a(localPaint, paramVarArgs);
      localPaint.setStrokeWidth(1.0F);
      ((Canvas)localObject1).save();
      arrayOfFloat = c.a(arrayOfFloat, 1.0F, 0.0F, 3.0F, 0.0F, 1.0F, 3.0F);
      ((Matrix)localObject2).reset();
      ((Matrix)localObject2).setValues(arrayOfFloat);
      ((Canvas)localObject1).concat((Matrix)localObject2);
      ((Canvas)localObject1).save();
      arrayOfFloat = c.a(arrayOfFloat, 1.0F, 0.0F, 0.0F, 0.0F, 1.0F, 0.5625F);
      ((Matrix)localObject2).reset();
      ((Matrix)localObject2).setValues(arrayOfFloat);
      ((Canvas)localObject1).concat((Matrix)localObject2);
      ((Canvas)localObject1).save();
      localObject2 = c.a((Paint)localObject3, paramVarArgs);
      ((Paint)localObject2).setColor(-1);
      localObject3 = c.l(paramVarArgs);
      ((Path)localObject3).moveTo(4.0F, 4.890718F);
      ((Path)localObject3).lineTo(9.341856F, 1.145409F);
      ((Path)localObject3).cubicTo(9.818216F, 0.81142F, 10.475134F, 0.9268357F, 10.809122F, 1.403196F);
      ((Path)localObject3).cubicTo(10.933353F, 1.580385F, 11.0F, 1.791535F, 11.0F, 2.007935F);
      ((Path)localObject3).lineTo(11.0F, 14.870968F);
      ((Path)localObject3).cubicTo(11.0F, 15.452748F, 10.528375F, 15.924374F, 9.946595F, 15.924374F);
      ((Path)localObject3).cubicTo(9.766121F, 15.924374F, 9.588673F, 15.878006F, 9.431269F, 15.789718F);
      ((Path)localObject3).lineTo(4.0F, 12.743319F);
      ((Path)localObject3).lineTo(1.053405F, 12.743319F);
      ((Path)localObject3).cubicTo(0.4716255F, 12.743319F, 2.93292E-016F, 12.271693F, 2.220446E-016F, 11.689914F);
      ((Path)localObject3).lineTo(0.0F, 5.944123F);
      ((Path)localObject3).cubicTo(-7.124744E-017F, 5.362343F, 0.4716255F, 4.890718F, 1.053405F, 4.890718F);
      ((Path)localObject3).lineTo(4.0F, 4.890718F);
      ((Path)localObject3).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject3, 2);
      ((Canvas)localObject1).drawPath((Path)localObject3, (Paint)localObject2);
      ((Canvas)localObject1).restore();
      ((Canvas)localObject1).save();
      localPaint = c.a(localPaint, paramVarArgs);
      localPaint.setColor(-1);
      localPaint.setStrokeWidth(1.87272F);
      localPaint.setStrokeCap(Paint.Cap.ROUND);
      localObject2 = c.l(paramVarArgs);
      ((Path)localObject2).moveTo(14.029777F, 12.4375F);
      ((Path)localObject2).cubicTo(15.813192F, 12.025054F, 17.145054F, 10.392283F, 17.145054F, 8.440882F);
      ((Path)localObject2).cubicTo(17.145054F, 6.478635F, 15.798347F, 4.83857F, 14.0F, 4.4375F);
      ((Canvas)localObject1).drawPath((Path)localObject2, localPaint);
      ((Canvas)localObject1).restore();
      ((Canvas)localObject1).restore();
      ((Canvas)localObject1).restore();
      localObject1 = c.l(paramVarArgs);
      ((Path)localObject1).moveTo(0.0F, 0.0F);
      ((Path)localObject1).lineTo(24.0F, 0.0F);
      ((Path)localObject1).lineTo(24.0F, 24.0F);
      ((Path)localObject1).lineTo(0.0F, 24.0F);
      ((Path)localObject1).lineTo(0.0F, 0.0F);
      ((Path)localObject1).close();
      localObject1 = c.l(paramVarArgs);
      ((Path)localObject1).moveTo(0.0F, 0.0F);
      ((Path)localObject1).lineTo(24.0F, 0.0F);
      ((Path)localObject1).lineTo(24.0F, 24.0F);
      ((Path)localObject1).lineTo(0.0F, 24.0F);
      ((Path)localObject1).lineTo(0.0F, 0.0F);
      ((Path)localObject1).close();
      c.j(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.aaj
 * JD-Core Version:    0.7.0.1
 */