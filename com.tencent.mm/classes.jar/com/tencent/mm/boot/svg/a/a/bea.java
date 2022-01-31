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

public final class bea
  extends c
{
  private final int height = 15;
  private final int width = 14;
  
  public final int a(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 14;
      return 15;
      Canvas localCanvas = (Canvas)paramVarArgs[0];
      paramVarArgs = (Looper)paramVarArgs[1];
      Object localObject1 = c.h(paramVarArgs);
      Object localObject2 = c.g(paramVarArgs);
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
      localPaint1 = c.a(localPaint2, paramVarArgs);
      localPaint1.setStrokeWidth(1.0F);
      localCanvas.save();
      localPaint1 = c.a(localPaint1, paramVarArgs);
      localPaint1.setColor(-5066062);
      localObject2 = c.a((float[])localObject2, 1.0F, 0.0F, -74.0F, 0.0F, 1.0F, -747.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject2);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject2 = c.a((float[])localObject2, 1.0F, 0.0F, 66.0F, 0.0F, 1.0F, 602.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject2);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject2 = c.a((float[])localObject2, 1.0F, 0.0F, 6.0F, 0.0F, 1.0F, 143.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject2);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject1 = c.a(localPaint1, paramVarArgs);
      localObject2 = c.l(paramVarArgs);
      ((Path)localObject2).moveTo(14.393222F, 10.420385F);
      ((Path)localObject2).lineTo(4.321909F, 15.7654F);
      ((Path)localObject2).cubicTo(3.882854F, 15.998414F, 3.338034F, 15.831385F, 3.10502F, 15.392329F);
      ((Path)localObject2).cubicTo(3.036059F, 15.262389F, 3.0F, 15.117526F, 3.0F, 14.970421F);
      ((Path)localObject2).lineTo(3.0F, 4.153231F);
      ((Path)localObject2).cubicTo(3.0F, 3.600946F, 3.447715F, 3.153231F, 4.0F, 3.153231F);
      ((Path)localObject2).cubicTo(4.171167F, 3.153231F, 4.339469F, 3.197166F, 4.488794F, 3.280832F);
      ((Path)localObject2).lineTo(14.411227F, 8.840247F);
      ((Path)localObject2).cubicTo(14.844859F, 9.083205F, 14.99943F, 9.631689F, 14.756472F, 10.065321F);
      ((Path)localObject2).cubicTo(14.671992F, 10.216099F, 14.545886F, 10.339364F, 14.393222F, 10.420385F);
      ((Path)localObject2).close();
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.restore();
      localCanvas.restore();
      localCanvas.restore();
      c.j(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.bea
 * JD-Core Version:    0.7.0.1
 */