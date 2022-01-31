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

public final class ts
  extends c
{
  private final int height = 135;
  private final int width = 135;
  
  protected final int b(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 135;
      return 135;
      Canvas localCanvas = (Canvas)paramVarArgs[0];
      paramVarArgs = (Looper)paramVarArgs[1];
      c.f(paramVarArgs);
      c.e(paramVarArgs);
      Paint localPaint = c.i(paramVarArgs);
      localPaint.setFlags(385);
      localPaint.setStyle(Paint.Style.FILL);
      Object localObject = c.i(paramVarArgs);
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
      localPaint.setColor(-9207928);
      localCanvas.save();
      localPaint = c.a(localPaint, paramVarArgs);
      localObject = c.j(paramVarArgs);
      ((Path)localObject).moveTo(64.309998F, 0.0F);
      ((Path)localObject).lineTo(70.360001F, 0.0F);
      ((Path)localObject).cubicTo(86.129997F, 0.75F, 101.58F, 7.05F, 113.16F, 17.809999F);
      ((Path)localObject).cubicTo(126.28F, 29.709999F, 134.19F, 46.959999F, 135.0F, 64.629997F);
      ((Path)localObject).lineTo(135.0F, 70.059998F);
      ((Path)localObject).cubicTo(134.28999F, 87.849998F, 126.34F, 105.24F, 113.14F, 117.21F);
      ((Path)localObject).cubicTo(101.65F, 127.9F, 86.330002F, 134.14999F, 70.699997F, 135.0F);
      ((Path)localObject).lineTo(64.610001F, 135.0F);
      ((Path)localObject).cubicTo(48.84F, 134.24001F, 33.369999F, 127.94F, 21.799999F, 117.16F);
      ((Path)localObject).cubicTo(8.65F, 105.22F, 0.75F, 87.889999F, 0.0F, 70.169998F);
      ((Path)localObject).lineTo(0.0F, 64.669998F);
      ((Path)localObject).cubicTo(0.8F, 47.0F, 8.69F, 29.74F, 21.809999F, 17.84F);
      ((Path)localObject).cubicTo(33.310001F, 7.13F, 48.650002F, 0.86F, 64.309998F, 0.0F);
      ((Path)localObject).lineTo(64.309998F, 0.0F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(39.369999F, 50.470001F);
      ((Path)localObject).cubicTo(37.77F, 51.380001F, 38.02F, 53.400002F, 37.98F, 54.959999F);
      ((Path)localObject).cubicTo(38.049999F, 64.0F, 37.919998F, 73.040001F, 38.040001F, 82.080002F);
      ((Path)localObject).cubicTo(37.950001F, 83.580002F, 39.360001F, 85.080002F, 40.889999F, 84.959999F);
      ((Path)localObject).cubicTo(53.290001F, 85.029999F, 65.690002F, 85.029999F, 78.089996F, 84.959999F);
      ((Path)localObject).cubicTo(79.610001F, 85.080002F, 81.040001F, 83.620003F, 80.959999F, 82.120003F);
      ((Path)localObject).cubicTo(81.059998F, 72.699997F, 80.980003F, 63.290001F, 81.0F, 53.869999F);
      ((Path)localObject).cubicTo(81.290001F, 52.110001F, 80.139999F, 49.93F, 78.139999F, 50.049999F);
      ((Path)localObject).cubicTo(66.769997F, 49.91F, 55.389999F, 50.07F, 44.02F, 49.98F);
      ((Path)localObject).cubicTo(42.490002F, 50.130001F, 40.759998F, 49.669998F, 39.369999F, 50.470001F);
      ((Path)localObject).lineTo(39.369999F, 50.470001F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(84.010002F, 64.470001F);
      ((Path)localObject).cubicTo(84.0F, 66.980003F, 83.989998F, 69.480003F, 84.0F, 71.989998F);
      ((Path)localObject).cubicTo(89.660004F, 76.010002F, 95.339996F, 80.0F, 101.01F, 84.010002F);
      ((Path)localObject).cubicTo(100.99F, 73.010002F, 101.01F, 62.009998F, 101.0F, 51.009998F);
      ((Path)localObject).cubicTo(95.32F, 55.470001F, 89.699997F, 60.009998F, 84.010002F, 64.470001F);
      ((Path)localObject).lineTo(84.010002F, 64.470001F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 2);
      localCanvas.drawPath((Path)localObject, localPaint);
      localCanvas.restore();
      c.h(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.ts
 * JD-Core Version:    0.7.0.1
 */