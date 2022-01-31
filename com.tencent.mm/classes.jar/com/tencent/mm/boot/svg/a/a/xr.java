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

public final class xr
  extends c
{
  private final int height = 18;
  private final int width = 19;
  
  protected final int b(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 19;
      return 18;
      Canvas localCanvas = (Canvas)paramVarArgs[0];
      paramVarArgs = (Looper)paramVarArgs[1];
      Object localObject1 = c.f(paramVarArgs);
      float[] arrayOfFloat = c.e(paramVarArgs);
      Paint localPaint = c.i(paramVarArgs);
      localPaint.setFlags(385);
      localPaint.setStyle(Paint.Style.FILL);
      Object localObject2 = c.i(paramVarArgs);
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
      localPaint.setColor(-15616);
      ((Paint)localObject2).setColor(-15616);
      ((Paint)localObject2).setStrokeWidth(1.2F);
      arrayOfFloat = c.a(arrayOfFloat, 1.0F, 0.0F, -321.0F, 0.0F, 1.0F, -308.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      arrayOfFloat = c.a(arrayOfFloat, 1.0F, 0.0F, 0.0F, 0.0F, 1.0F, 227.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      arrayOfFloat = c.a(arrayOfFloat, 1.0F, 0.0F, 20.0F, 0.0F, 1.0F, 49.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      arrayOfFloat = c.a(arrayOfFloat, 1.0F, 0.0F, 0.0F, 0.0F, 1.0F, 16.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      arrayOfFloat = c.a(arrayOfFloat, 1.0F, 0.0F, 60.0F, 0.0F, 1.0F, 13.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject1 = c.a(localPaint, paramVarArgs);
      localPaint = c.a((Paint)localObject2, paramVarArgs);
      localObject2 = c.j(paramVarArgs);
      ((Path)localObject2).moveTo(245.3613F, 20.165895F);
      ((Path)localObject2).lineTo(250.31267F, 17.562805F);
      ((Path)localObject2).lineTo(255.26404F, 20.165895F);
      ((Path)localObject2).cubicTo(255.34189F, 20.206831F, 255.43108F, 20.220957F, 255.51779F, 20.206087F);
      ((Path)localObject2).cubicTo(255.73552F, 20.168741F, 255.88176F, 19.96196F, 255.84441F, 19.744225F);
      ((Path)localObject2).lineTo(254.89879F, 14.230793F);
      ((Path)localObject2).lineTo(258.90454F, 10.326159F);
      ((Path)localObject2).cubicTo(258.96753F, 10.264755F, 259.00851F, 10.184299F, 259.02118F, 10.097244F);
      ((Path)localObject2).cubicTo(259.05292F, 9.878626F, 258.90146F, 9.675649F, 258.68283F, 9.643882F);
      ((Path)localObject2).lineTo(253.14703F, 8.839482F);
      ((Path)localObject2).lineTo(250.67136F, 3.823197F);
      ((Path)localObject2).cubicTo(250.63242F, 3.744312F, 250.56857F, 3.680461F, 250.48969F, 3.641529F);
      ((Path)localObject2).cubicTo(250.29158F, 3.54376F, 250.05174F, 3.625095F, 249.95396F, 3.823197F);
      ((Path)localObject2).lineTo(247.47829F, 8.839482F);
      ((Path)localObject2).lineTo(241.94247F, 9.643882F);
      ((Path)localObject2).cubicTo(241.85542F, 9.656531F, 241.77496F, 9.697526F, 241.71356F, 9.76052F);
      ((Path)localObject2).cubicTo(241.55937F, 9.918714F, 241.56261F, 10.171959F, 241.72079F, 10.326159F);
      ((Path)localObject2).lineTo(245.72653F, 14.230793F);
      ((Path)localObject2).lineTo(244.78091F, 19.744225F);
      ((Path)localObject2).cubicTo(244.76604F, 19.830929F, 244.78017F, 19.920115F, 244.82111F, 19.99798F);
      ((Path)localObject2).cubicTo(244.9239F, 20.193518F, 245.16576F, 20.268696F, 245.3613F, 20.165895F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 2);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.drawPath((Path)localObject2, localPaint);
      localCanvas.restore();
      localCanvas.restore();
      localCanvas.restore();
      localCanvas.restore();
      localCanvas.restore();
      localCanvas.restore();
      c.h(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.xr
 * JD-Core Version:    0.7.0.1
 */