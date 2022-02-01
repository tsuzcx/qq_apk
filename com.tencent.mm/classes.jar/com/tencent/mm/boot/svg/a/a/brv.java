package com.tencent.mm.boot.svg.a.a;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.c;

public final class brv
  extends c
{
  private final int height = 80;
  private final int width = 80;
  
  public final int a(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 80;
      return 80;
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
      localPaint1 = c.a(localPaint2, paramVarArgs);
      localPaint1.setStrokeWidth(1.0F);
      localCanvas.save();
      localPaint1 = c.a(localPaint1, paramVarArgs);
      localPaint1.setColor(-1);
      localPaint1.setStrokeWidth(4.0F);
      localObject2 = c.a((float[])localObject2, 1.0F, 0.0F, 4.0F, 0.0F, 1.0F, 16.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject2);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject1 = c.a(localPaint1, paramVarArgs);
      localObject2 = c.n(paramVarArgs);
      ((Path)localObject2).moveTo(36.925568F, 47.054665F);
      ((Path)localObject2).cubicTo(56.110641F, 47.054665F, 71.45919F, 26.668798F, 71.45919F, 26.668798F);
      ((Path)localObject2).cubicTo(72.148895F, 25.817219F, 72.177429F, 24.403841F, 71.5037F, 23.523014F);
      ((Path)localObject2).cubicTo(71.5037F, 23.523014F, 55.69043F, 0.967642F, 36.505352F, 0.967642F);
      ((Path)localObject2).cubicTo(17.320274F, 0.967642F, 1.459838F, 23.541723F, 1.459838F, 23.541723F);
      ((Path)localObject2).cubicTo(0.801489F, 24.417181F, 0.8427118F, 25.819351F, 1.562828F, 26.651388F);
      ((Path)localObject2).cubicTo(1.562828F, 26.651388F, 17.740492F, 47.054665F, 36.925568F, 47.054665F);
      ((Path)localObject2).lineTo(36.925568F, 47.054665F);
      ((Path)localObject2).close();
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.save();
      localObject1 = c.a(localPaint1, paramVarArgs);
      localObject2 = c.n(paramVarArgs);
      ((Path)localObject2).moveTo(22.42774F, 20.499218F);
      ((Path)localObject2).cubicTo(22.148413F, 21.589939F, 22.0F, 22.732264F, 22.0F, 23.908884F);
      ((Path)localObject2).cubicTo(22.0F, 31.55521F, 28.267693F, 37.753208F, 36.0F, 37.753208F);
      ((Path)localObject2).cubicTo(43.732307F, 37.753208F, 50.0F, 31.55521F, 50.0F, 23.908884F);
      ((Path)localObject2).cubicTo(50.0F, 16.262556F, 43.732307F, 10.064558F, 36.0F, 10.064558F);
      ((Path)localObject2).cubicTo(34.347454F, 10.064558F, 32.76181F, 10.347658F, 31.289946F, 10.867492F);
      ((Path)localObject2).lineTo(34.602558F, 20.195063F);
      ((Path)localObject2).lineTo(31.985279F, 23.138868F);
      ((Path)localObject2).lineTo(22.42774F, 20.499218F);
      ((Path)localObject2).lineTo(22.42774F, 20.499218F);
      ((Path)localObject2).close();
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.restore();
      c.l(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.brv
 * JD-Core Version:    0.7.0.1
 */