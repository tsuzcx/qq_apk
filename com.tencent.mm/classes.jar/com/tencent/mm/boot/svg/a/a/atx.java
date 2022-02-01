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

public final class atx
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
      localPaint1 = c.a(localPaint1, paramVarArgs);
      localPaint1.setColor(-16777216);
      localPaint1.setStrokeWidth(3.8F);
      localCanvas.save();
      localObject2 = c.a((float[])localObject2, 1.0F, 0.0F, 13.5F, 0.0F, 1.0F, 7.5F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject2);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject1 = c.a(localPaint1, paramVarArgs);
      localObject2 = c.n(paramVarArgs);
      ((Path)localObject2).moveTo(22.5F, 1.9F);
      ((Path)localObject2).cubicTo(16.80991F, 1.9F, 11.657898F, 4.188965F, 7.928803F, 7.891573F);
      ((Path)localObject2).cubicTo(4.204629F, 11.589297F, 1.9F, 16.697329F, 1.9F, 22.340193F);
      ((Path)localObject2).cubicTo(1.9F, 38.491779F, 21.652529F, 54.777836F, 21.700645F, 54.819466F);
      ((Path)localObject2).cubicTo(21.922876F, 55.018337F, 22.219185F, 55.103367F, 22.507957F, 55.102718F);
      ((Path)localObject2).cubicTo(22.790081F, 55.102085F, 23.079666F, 55.019444F, 23.357542F, 54.768497F);
      ((Path)localObject2).cubicTo(23.357542F, 54.768497F, 43.099998F, 38.49152F, 43.099998F, 22.340193F);
      ((Path)localObject2).cubicTo(43.099998F, 16.697329F, 40.795372F, 11.589297F, 37.071198F, 7.891573F);
      ((Path)localObject2).cubicTo(33.342102F, 4.188965F, 28.19009F, 1.9F, 22.5F, 1.9F);
      ((Path)localObject2).close();
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.save();
      localObject1 = c.a(localPaint1, paramVarArgs);
      localObject2 = c.n(paramVarArgs);
      ((Path)localObject2).moveTo(22.5F, 13.9F);
      ((Path)localObject2).cubicTo(27.249649F, 13.9F, 31.1F, 17.750351F, 31.1F, 22.5F);
      ((Path)localObject2).cubicTo(31.1F, 27.249649F, 27.249649F, 31.1F, 22.5F, 31.1F);
      ((Path)localObject2).cubicTo(17.750351F, 31.1F, 13.9F, 27.249649F, 13.9F, 22.5F);
      ((Path)localObject2).cubicTo(13.9F, 17.750351F, 17.750351F, 13.9F, 22.5F, 13.9F);
      ((Path)localObject2).close();
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.restore();
      c.l(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.atx
 * JD-Core Version:    0.7.0.1
 */