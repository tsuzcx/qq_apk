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

public final class ut
  extends c
{
  private final int height = 84;
  private final int width = 84;
  
  public final int a(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 84;
      return 84;
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
      c.a(localPaint2, paramVarArgs).setStrokeWidth(1.0F);
      localCanvas.save();
      localPaint1 = c.a(localPaint1, paramVarArgs);
      localPaint1.setColor(-10526881);
      localObject2 = c.a((float[])localObject2, 1.0F, 0.0F, 11.0F, 0.0F, 1.0F, 11.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject2);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject1 = c.a(localPaint1, paramVarArgs);
      localObject2 = c.l(paramVarArgs);
      ((Path)localObject2).moveTo(35.23F, 1.25F);
      ((Path)localObject2).cubicTo(37.080002F, 0.35F, 38.799999F, 1.79F, 40.009998F, 3.04F);
      ((Path)localObject2).cubicTo(46.310001F, 9.38F, 52.630001F, 15.7F, 58.970001F, 22.0F);
      ((Path)localObject2).cubicTo(60.259998F, 23.23F, 61.630001F, 24.950001F, 60.740002F, 26.83F);
      ((Path)localObject2).cubicTo(59.310001F, 28.98F, 57.27F, 30.629999F, 55.48F, 32.470001F);
      ((Path)localObject2).cubicTo(46.810001F, 41.150002F, 38.110001F, 49.790001F, 29.48F, 58.5F);
      ((Path)localObject2).cubicTo(28.24F, 59.68F, 26.959999F, 61.220001F, 25.049999F, 60.970001F);
      ((Path)localObject2).cubicTo(18.33F, 61.029999F, 11.6F, 61.040001F, 4.88F, 60.970001F);
      ((Path)localObject2).cubicTo(2.66F, 61.25F, 0.75F, 59.240002F, 1.03F, 57.049999F);
      ((Path)localObject2).cubicTo(1.13F, 49.75F, 0.64F, 42.389999F, 1.29F, 35.130001F);
      ((Path)localObject2).cubicTo(9.14F, 26.42F, 17.85F, 18.459999F, 26.030001F, 10.03F);
      ((Path)localObject2).cubicTo(29.15F, 7.16F, 31.77F, 3.72F, 35.23F, 1.25F);
      ((Path)localObject2).lineTo(35.23F, 1.25F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(16.24F, 38.27F);
      ((Path)localObject2).cubicTo(12.02F, 39.369999F, 10.54F, 45.330002F, 13.78F, 48.25F);
      ((Path)localObject2).cubicTo(16.709999F, 51.459999F, 22.67F, 49.959999F, 23.73F, 45.740002F);
      ((Path)localObject2).cubicTo(25.299999F, 41.389999F, 20.58F, 36.689999F, 16.24F, 38.27F);
      ((Path)localObject2).lineTo(16.24F, 38.27F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 2);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.restore();
      c.j(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.ut
 * JD-Core Version:    0.7.0.1
 */