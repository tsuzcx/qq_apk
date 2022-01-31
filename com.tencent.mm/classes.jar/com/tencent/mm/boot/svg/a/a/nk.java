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

public final class nk
  extends c
{
  private final int height = 60;
  private final int width = 60;
  
  protected final int b(int paramInt, Object... paramVarArgs)
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
      Object localObject1 = c.f(paramVarArgs);
      Object localObject2 = c.e(paramVarArgs);
      Paint localPaint1 = c.i(paramVarArgs);
      localPaint1.setFlags(385);
      localPaint1.setStyle(Paint.Style.FILL);
      Paint localPaint2 = c.i(paramVarArgs);
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
      localPaint1.setColor(-1);
      localObject2 = c.a((float[])localObject2, 1.0F, 0.0F, 12.0F, 0.0F, 1.0F, 5.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject2);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject1 = c.a(localPaint1, paramVarArgs);
      localObject2 = c.j(paramVarArgs);
      ((Path)localObject2).moveTo(11.71F, 0.65F);
      ((Path)localObject2).cubicTo(13.16F, -0.49F, 15.54F, 0.4F, 15.97F, 2.18F);
      ((Path)localObject2).cubicTo(16.66F, 4.08F, 14.73F, 5.41F, 13.74F, 6.74F);
      ((Path)localObject2).cubicTo(7.06F, 13.89F, 4.53F, 24.790001F, 7.91F, 34.049999F);
      ((Path)localObject2).cubicTo(9.17F, 38.240002F, 11.95F, 41.66F, 14.49F, 45.110001F);
      ((Path)localObject2).cubicTo(15.89F, 47.779999F, 11.79F, 50.5F, 9.92F, 48.169998F);
      ((Path)localObject2).cubicTo(5.54F, 42.990002F, 2.1F, 36.799999F, 1.12F, 30.01F);
      ((Path)localObject2).cubicTo(-0.61F, 19.280001F, 3.6F, 7.83F, 11.71F, 0.65F);
      ((Path)localObject2).lineTo(11.71F, 0.65F);
      ((Path)localObject2).lineTo(11.71F, 0.65F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 2);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.save();
      localObject1 = c.a(localPaint1, paramVarArgs);
      localObject2 = c.j(paramVarArgs);
      ((Path)localObject2).moveTo(21.540001F, 8.56F);
      ((Path)localObject2).cubicTo(23.030001F, 7.48F, 25.01F, 8.49F, 25.709999F, 10.02F);
      ((Path)localObject2).cubicTo(26.07F, 11.88F, 24.530001F, 13.18F, 23.6F, 14.56F);
      ((Path)localObject2).cubicTo(19.870001F, 19.219999F, 18.799999F, 25.83F, 20.84F, 31.440001F);
      ((Path)localObject2).cubicTo(21.6F, 33.869999F, 23.290001F, 35.830002F, 24.469999F, 38.049999F);
      ((Path)localObject2).cubicTo(25.030001F, 39.939999F, 23.0F, 41.560001F, 21.24F, 40.919998F);
      ((Path)localObject2).cubicTo(12.08F, 32.68F, 12.35F, 16.700001F, 21.540001F, 8.56F);
      ((Path)localObject2).lineTo(21.540001F, 8.56F);
      ((Path)localObject2).lineTo(21.540001F, 8.56F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 2);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.save();
      localPaint1 = c.a(localPaint1, paramVarArgs);
      localObject1 = c.j(paramVarArgs);
      ((Path)localObject1).moveTo(30.629999F, 15.39F);
      ((Path)localObject1).cubicTo(32.52F, 13.6F, 36.110001F, 15.44F, 35.66F, 18.01F);
      ((Path)localObject1).cubicTo(35.07F, 20.610001F, 32.209999F, 22.23F, 32.25F, 25.08F);
      ((Path)localObject1).cubicTo(31.82F, 27.77F, 34.27F, 29.5F, 34.98F, 31.860001F);
      ((Path)localObject1).cubicTo(35.369999F, 34.540001F, 31.58F, 36.310001F, 29.799999F, 34.27F);
      ((Path)localObject1).cubicTo(25.33F, 28.870001F, 26.030001F, 20.48F, 30.629999F, 15.39F);
      ((Path)localObject1).lineTo(30.629999F, 15.39F);
      ((Path)localObject1).lineTo(30.629999F, 15.39F);
      ((Path)localObject1).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject1, 2);
      localCanvas.drawPath((Path)localObject1, localPaint1);
      localCanvas.restore();
      localCanvas.restore();
      c.h(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.nk
 * JD-Core Version:    0.7.0.1
 */