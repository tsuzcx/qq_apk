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

public final class bwc
  extends c
{
  private final int height = 14;
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
      return 14;
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
      localObject2 = c.a((Paint)localObject2, paramVarArgs);
      ((Paint)localObject2).setStrokeWidth(1.0F);
      localCanvas.save();
      localPaint = c.a(localPaint, paramVarArgs);
      localObject2 = c.a((Paint)localObject2, paramVarArgs);
      localPaint.setColor(-5066062);
      ((Paint)localObject2).setColor(-5066062);
      ((Paint)localObject2).setStrokeWidth(0.5F);
      arrayOfFloat = c.a(arrayOfFloat, 1.0F, 0.0F, -330.0F, 0.0F, 1.0F, -672.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      arrayOfFloat = c.a(arrayOfFloat, 1.0F, 0.0F, 66.0F, 0.0F, 1.0F, 602.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      arrayOfFloat = c.a(arrayOfFloat, 1.0F, 0.0F, 263.0F, 0.0F, 1.0F, 68.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      arrayOfFloat = c.a(arrayOfFloat, 1.0F, 0.0F, 2.0F, 0.0F, 1.0F, 3.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject1 = c.a(localPaint, paramVarArgs);
      localPaint = c.a((Paint)localObject2, paramVarArgs);
      localObject2 = c.n(paramVarArgs);
      ((Path)localObject2).moveTo(3.649918F, 12.45301F);
      ((Path)localObject2).cubicTo(1.637423F, 12.45301F, 0.0F, 10.992746F, 0.0F, 9.19892F);
      ((Path)localObject2).cubicTo(0.0F, 7.617091F, 1.246784F, 6.279875F, 2.96352F, 6.019696F);
      ((Path)localObject2).cubicTo(2.96352F, 6.019696F, 3.25409F, 5.993011F, 3.300048F, 6.226505F);
      ((Path)localObject2).cubicTo(3.357865F, 6.519299F, 2.973156F, 6.577858F, 2.740403F, 6.635675F);
      ((Path)localObject2).cubicTo(1.436544F, 6.949966F, 0.5218404F, 8.004766F, 0.5218404F, 9.19892F);
      ((Path)localObject2).cubicTo(0.5218404F, 10.683645F, 1.907238F, 11.891142F, 3.610632F, 11.891142F);
      ((Path)localObject2).cubicTo(5.314025F, 11.891142F, 6.699423F, 10.683645F, 6.699423F, 9.19892F);
      ((Path)localObject2).lineTo(6.699423F, 3.253349F);
      ((Path)localObject2).cubicTo(6.699423F, 1.458781F, 8.336845F, 0.0F, 10.34934F, 0.0F);
      ((Path)localObject2).cubicTo(12.361836F, 0.0F, 14.0F, 1.458781F, 14.0F, 3.253349F);
      ((Path)localObject2).cubicTo(14.0F, 4.846296F, 12.805845F, 6.144968F, 11.04834F, 6.471118F);
      ((Path)localObject2).cubicTo(10.764441F, 6.523747F, 10.430879F, 6.110129F, 11.246995F, 5.859586F);
      ((Path)localObject2).cubicTo(12.561974F, 5.455605F, 13.477418F, 4.490496F, 13.477418F, 3.253349F);
      ((Path)localObject2).cubicTo(13.477418F, 1.768624F, 12.092762F, 0.5611267F, 10.389368F, 0.5611267F);
      ((Path)localObject2).cubicTo(8.685974F, 0.5611267F, 7.301318F, 1.768624F, 7.301318F, 3.253349F);
      ((Path)localObject2).lineTo(7.301318F, 9.19892F);
      ((Path)localObject2).cubicTo(7.301318F, 10.992746F, 5.663896F, 12.45301F, 3.649918F, 12.45301F);
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 2);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.drawPath((Path)localObject2, localPaint);
      localCanvas.restore();
      localCanvas.restore();
      localCanvas.restore();
      localCanvas.restore();
      localCanvas.restore();
      c.l(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.bwc
 * JD-Core Version:    0.7.0.1
 */