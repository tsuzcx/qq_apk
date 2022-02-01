package com.tencent.mm.boot.svg.a.a;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;

public final class bqz
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
      c.j(paramVarArgs);
      c.i(paramVarArgs);
      Paint localPaint = c.m(paramVarArgs);
      localPaint.setFlags(385);
      localPaint.setStyle(Paint.Style.FILL);
      Object localObject = c.m(paramVarArgs);
      ((Paint)localObject).setFlags(385);
      ((Paint)localObject).setStyle(Paint.Style.STROKE);
      localPaint.setColor(-16777216);
      ((Paint)localObject).setStrokeWidth(1.0F);
      ((Paint)localObject).setStrokeCap(Paint.Cap.BUTT);
      ((Paint)localObject).setStrokeJoin(Paint.Join.MITER);
      ((Paint)localObject).setStrokeMiter(4.0F);
      ((Paint)localObject).setPathEffect(null);
      c.a((Paint)localObject, paramVarArgs).setStrokeWidth(1.0F);
      localPaint = c.a(localPaint, paramVarArgs);
      localPaint.setColor(-7960954);
      localCanvas.save();
      localPaint = c.a(localPaint, paramVarArgs);
      localObject = c.n(paramVarArgs);
      ((Path)localObject).moveTo(37.779999F, 0.0F);
      ((Path)localObject).lineTo(41.060001F, 0.0F);
      ((Path)localObject).cubicTo(50.720001F, 0.32F, 60.25F, 4.09F, 67.279999F, 10.76F);
      ((Path)localObject).cubicTo(74.82F, 17.700001F, 79.360001F, 27.620001F, 80.0F, 37.82F);
      ((Path)localObject).lineTo(80.0F, 41.959999F);
      ((Path)localObject).cubicTo(79.400002F, 53.200001F, 73.959999F, 64.110001F, 65.110001F, 71.099998F);
      ((Path)localObject).cubicTo(58.68F, 76.449997F, 50.490002F, 79.360001F, 42.200001F, 80.0F);
      ((Path)localObject).lineTo(38.02F, 80.0F);
      ((Path)localObject).cubicTo(29.65F, 79.43F, 21.379999F, 76.489998F, 14.9F, 71.099998F);
      ((Path)localObject).cubicTo(5.88F, 63.970001F, 0.36F, 52.77F, 0.0F, 41.290001F);
      ((Path)localObject).lineTo(0.0F, 38.029999F);
      ((Path)localObject).cubicTo(0.57F, 27.75F, 5.14F, 17.73F, 12.73F, 10.75F);
      ((Path)localObject).cubicTo(19.48F, 4.33F, 28.540001F, 0.68F, 37.779999F, 0.0F);
      ((Path)localObject).lineTo(37.779999F, 0.0F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(22.35F, 21.530001F);
      ((Path)localObject).cubicTo(17.6F, 23.92F, 17.99F, 32.16F, 23.16F, 33.799999F);
      ((Path)localObject).cubicTo(27.59F, 35.099998F, 30.99F, 29.790001F, 29.809999F, 25.870001F);
      ((Path)localObject).cubicTo(29.309999F, 22.58F, 25.549999F, 19.780001F, 22.35F, 21.530001F);
      ((Path)localObject).lineTo(22.35F, 21.530001F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(53.400002F, 21.51F);
      ((Path)localObject).cubicTo(48.310001F, 23.959999F, 49.119999F, 33.049999F, 54.919998F, 33.959999F);
      ((Path)localObject).cubicTo(59.09F, 34.439999F, 61.82F, 29.6F, 60.82F, 25.93F);
      ((Path)localObject).cubicTo(60.349998F, 22.639999F, 56.619999F, 19.790001F, 53.400002F, 21.51F);
      ((Path)localObject).lineTo(53.400002F, 21.51F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(11.94F, 43.0F);
      ((Path)localObject).cubicTo(12.98F, 52.490002F, 18.9F, 61.77F, 28.15F, 65.019997F);
      ((Path)localObject).cubicTo(36.799999F, 68.0F, 46.700001F, 67.699997F, 55.110001F, 64.050003F);
      ((Path)localObject).cubicTo(63.240002F, 60.48F, 68.0F, 51.669998F, 68.07F, 43.0F);
      ((Path)localObject).cubicTo(49.59F, 39.130001F, 30.42F, 39.110001F, 11.94F, 43.0F);
      ((Path)localObject).lineTo(11.94F, 43.0F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 2);
      localCanvas.drawPath((Path)localObject, localPaint);
      localCanvas.restore();
      c.l(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.bqz
 * JD-Core Version:    0.7.0.1
 */