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

public final class bbt
  extends c
{
  private final int height = 159;
  private final int width = 159;
  
  public final int a(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 159;
      return 159;
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
      localPaint.setColor(-16777216);
      localCanvas.saveLayerAlpha(null, 23, 31);
      localCanvas.save();
      localPaint = c.a(localPaint, paramVarArgs);
      localObject = c.n(paramVarArgs);
      ((Path)localObject).moveTo(69.690002F, 0.0F);
      ((Path)localObject).lineTo(89.349998F, 0.0F);
      ((Path)localObject).cubicTo(106.27F, 2.71F, 122.64F, 9.98F, 134.92999F, 22.1F);
      ((Path)localObject).cubicTo(148.14999F, 34.619999F, 156.22F, 51.830002F, 159.0F, 69.699997F);
      ((Path)localObject).lineTo(159.0F, 89.290001F);
      ((Path)localObject).cubicTo(156.38F, 106.0F, 149.23F, 122.14F, 137.42999F, 134.39999F);
      ((Path)localObject).cubicTo(124.86F, 147.89999F, 107.45F, 156.17F, 89.339996F, 159.0F);
      ((Path)localObject).lineTo(69.669998F, 159.0F);
      ((Path)localObject).cubicTo(54.380001F, 156.5F, 39.5F, 150.47F, 27.73F, 140.23F);
      ((Path)localObject).cubicTo(12.48F, 127.48F, 2.96F, 108.82F, 0.0F, 89.290001F);
      ((Path)localObject).lineTo(0.0F, 69.660004F);
      ((Path)localObject).cubicTo(2.74F, 52.259998F, 10.43F, 35.459999F, 23.1F, 23.049999F);
      ((Path)localObject).cubicTo(35.509998F, 10.39F, 52.299999F, 2.75F, 69.690002F, 0.0F);
      ((Path)localObject).lineTo(69.690002F, 0.0F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(72.389999F, 1.64F);
      ((Path)localObject).cubicTo(50.029999F, 3.41F, 29.01F, 15.72F, 16.0F, 33.900002F);
      ((Path)localObject).cubicTo(5.98F, 47.41F, 1.2F, 64.290001F, 1.1F, 80.989998F);
      ((Path)localObject).cubicTo(1.79F, 91.019997F, 3.49F, 101.11F, 7.59F, 110.36F);
      ((Path)localObject).cubicTo(16.559999F, 131.17F, 34.91F, 147.82001F, 56.669998F, 154.32001F);
      ((Path)localObject).cubicTo(67.110001F, 157.23F, 78.169998F, 158.89F, 88.949997F, 157.08F);
      ((Path)localObject).cubicTo(109.53F, 154.89F, 128.7F, 143.64999F, 141.32001F, 127.36F);
      ((Path)localObject).cubicTo(157.73F, 106.72F, 162.16F, 77.57F, 153.09F, 52.869999F);
      ((Path)localObject).cubicTo(144.96001F, 30.370001F, 125.99F, 12.03F, 103.11F, 4.91F);
      ((Path)localObject).cubicTo(93.199997F, 2.07F, 82.690002F, 0.28F, 72.389999F, 1.64F);
      ((Path)localObject).lineTo(72.389999F, 1.64F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 2);
      localCanvas.drawPath((Path)localObject, localPaint);
      localCanvas.restore();
      localCanvas.restore();
      c.l(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.bbt
 * JD-Core Version:    0.7.0.1
 */