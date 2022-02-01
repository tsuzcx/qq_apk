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

public final class bto
  extends c
{
  private final int height = 60;
  private final int width = 60;
  
  public final int a(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 60;
      return 60;
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
      c.a(localPaint2, paramVarArgs).setStrokeWidth(1.0F);
      localCanvas.save();
      localPaint1 = c.a(localPaint1, paramVarArgs);
      localPaint1.setColor(-2105120);
      localObject2 = c.a((float[])localObject2, 1.0F, 0.0F, 6.0F, 0.0F, 1.0F, 6.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject2);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject1 = c.a(localPaint1, paramVarArgs);
      localObject2 = c.n(paramVarArgs);
      ((Path)localObject2).moveTo(18.370001F, 1.52F);
      ((Path)localObject2).cubicTo(23.08F, 0.55F, 28.200001F, 0.64F, 32.689999F, 2.53F);
      ((Path)localObject2).cubicTo(41.169998F, 5.91F, 47.419998F, 14.72F, 47.029999F, 23.959999F);
      ((Path)localObject2).cubicTo(47.650002F, 36.290001F, 36.310001F, 47.639999F, 23.98F, 47.029999F);
      ((Path)localObject2).cubicTo(10.46F, 47.709999F, -1.15F, 34.209999F, 1.07F, 20.93F);
      ((Path)localObject2).cubicTo(2.04F, 11.65F, 9.54F, 3.93F, 18.370001F, 1.52F);
      ((Path)localObject2).lineTo(18.370001F, 1.52F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(5.04F, 17.360001F);
      ((Path)localObject2).cubicTo(7.12F, 19.25F, 7.11F, 22.209999F, 7.98F, 24.700001F);
      ((Path)localObject2).cubicTo(10.56F, 25.780001F, 13.04F, 27.059999F, 15.5F, 28.379999F);
      ((Path)localObject2).cubicTo(15.2F, 27.120001F, 14.76F, 25.91F, 14.18F, 24.77F);
      ((Path)localObject2).cubicTo(13.02F, 23.83F, 11.45F, 24.49F, 10.12F, 24.440001F);
      ((Path)localObject2).cubicTo(10.26F, 22.870001F, 9.41F, 20.870001F, 10.68F, 19.610001F);
      ((Path)localObject2).cubicTo(11.97F, 18.33F, 13.92F, 18.68F, 15.56F, 18.440001F);
      ((Path)localObject2).cubicTo(16.27F, 19.32F, 16.969999F, 20.190001F, 17.68F, 21.059999F);
      ((Path)localObject2).cubicTo(17.860001F, 18.91F, 17.17F, 16.469999F, 18.57F, 14.6F);
      ((Path)localObject2).cubicTo(20.530001F, 11.73F, 22.950001F, 9.18F, 24.959999F, 6.33F);
      ((Path)localObject2).lineTo(18.93F, 6.33F);
      ((Path)localObject2).cubicTo(19.0F, 7.24F, 19.16F, 9.05F, 19.23F, 9.96F);
      ((Path)localObject2).lineTo(20.48F, 10.29F);
      ((Path)localObject2).cubicTo(17.860001F, 11.08F, 17.120001F, 7.21F, 15.92F, 5.62F);
      ((Path)localObject2).cubicTo(10.94F, 7.98F, 7.02F, 12.21F, 5.04F, 17.360001F);
      ((Path)localObject2).lineTo(5.04F, 17.360001F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(17.15F, 27.129999F);
      ((Path)localObject2).cubicTo(17.83F, 28.030001F, 18.530001F, 28.93F, 19.110001F, 29.91F);
      ((Path)localObject2).cubicTo(19.58F, 32.279999F, 17.17F, 34.5F, 18.309999F, 36.830002F);
      ((Path)localObject2).cubicTo(19.379999F, 39.029999F, 22.16F, 38.939999F, 24.200001F, 39.459999F);
      ((Path)localObject2).cubicTo(24.1F, 41.009998F, 23.940001F, 42.560001F, 23.790001F, 44.119999F);
      ((Path)localObject2).cubicTo(26.84F, 43.830002F, 30.18F, 43.630001F, 32.470001F, 41.310001F);
      ((Path)localObject2).cubicTo(34.919998F, 39.119999F, 38.830002F, 37.009998F, 38.16F, 33.139999F);
      ((Path)localObject2).cubicTo(38.130001F, 31.02F, 35.310001F, 32.110001F, 34.009998F, 31.85F);
      ((Path)localObject2).cubicTo(31.969999F, 29.6F, 30.48F, 25.84F, 27.01F, 25.719999F);
      ((Path)localObject2).cubicTo(23.74F, 26.33F, 20.540001F, 27.889999F, 17.15F, 27.129999F);
      ((Path)localObject2).lineTo(17.15F, 27.129999F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 2);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.restore();
      c.l(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.bto
 * JD-Core Version:    0.7.0.1
 */