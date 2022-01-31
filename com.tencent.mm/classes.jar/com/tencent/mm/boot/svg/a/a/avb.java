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

public final class avb
  extends c
{
  private final int height = 240;
  private final int width = 273;
  
  protected final int b(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 273;
      return 240;
      Canvas localCanvas = (Canvas)paramVarArgs[0];
      paramVarArgs = (Looper)paramVarArgs[1];
      Object localObject1 = c.f(paramVarArgs);
      Object localObject3 = c.e(paramVarArgs);
      Object localObject2 = c.i(paramVarArgs);
      ((Paint)localObject2).setFlags(385);
      ((Paint)localObject2).setStyle(Paint.Style.FILL);
      Paint localPaint = c.i(paramVarArgs);
      localPaint.setFlags(385);
      localPaint.setStyle(Paint.Style.STROKE);
      ((Paint)localObject2).setColor(-16777216);
      localPaint.setStrokeWidth(1.0F);
      localPaint.setStrokeCap(Paint.Cap.BUTT);
      localPaint.setStrokeJoin(Paint.Join.MITER);
      localPaint.setStrokeMiter(4.0F);
      localPaint.setPathEffect(null);
      c.a(localPaint, paramVarArgs).setStrokeWidth(1.0F);
      localCanvas.save();
      localObject2 = c.a((Paint)localObject2, paramVarArgs);
      ((Paint)localObject2).setColor(-12810566);
      localObject3 = c.a((float[])localObject3, 1.0F, 0.0F, 13.0F, 0.0F, 1.0F, 15.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject3);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject1 = c.a((Paint)localObject2, paramVarArgs);
      localObject3 = c.j(paramVarArgs);
      ((Path)localObject3).moveTo(81.419998F, 3.53F);
      ((Path)localObject3).cubicTo(95.010002F, -1.21F, 111.01F, 0.68F, 122.61F, 9.4F);
      ((Path)localObject3).cubicTo(131.81F, 16.24F, 137.63F, 26.99F, 139.39999F, 38.23F);
      ((Path)localObject3).cubicTo(142.14F, 55.419998F, 137.67999F, 73.519997F, 127.81F, 87.800003F);
      ((Path)localObject3).cubicTo(125.42F, 91.040001F, 123.03F, 94.459999F, 119.58F, 96.669998F);
      ((Path)localObject3).cubicTo(115.73F, 98.970001F, 114.46F, 104.5F, 116.82F, 108.3F);
      ((Path)localObject3).cubicTo(117.96F, 110.49F, 120.26F, 111.59F, 122.4F, 112.57F);
      ((Path)localObject3).cubicTo(113.67F, 127.91F, 111.16F, 146.58F, 115.4F, 163.69F);
      ((Path)localObject3).cubicTo(117.69F, 173.22F, 122.14F, 182.16F, 128.07001F, 189.95F);
      ((Path)localObject3).cubicTo(86.269997F, 189.94F, 44.470001F, 189.83F, 2.68F, 189.86F);
      ((Path)localObject3).cubicTo(0.79F, 182.89999F, 0.06F, 175.60001F, 0.47F, 168.41F);
      ((Path)localObject3).cubicTo(1.99F, 158.77F, 9.44F, 151.60001F, 16.379999F, 145.37F);
      ((Path)localObject3).cubicTo(31.110001F, 132.98F, 48.139999F, 123.71F, 65.300003F, 115.14F);
      ((Path)localObject3).cubicTo(68.300003F, 113.53F, 71.690002F, 112.5F, 74.269997F, 110.21F);
      ((Path)localObject3).cubicTo(77.620003F, 107.25F, 77.959999F, 101.52F, 74.82F, 98.300003F);
      ((Path)localObject3).cubicTo(65.32F, 90.480003F, 59.09F, 79.290001F, 55.610001F, 67.620003F);
      ((Path)localObject3).cubicTo(51.68F, 53.939999F, 51.439999F, 38.66F, 57.48F, 25.559999F);
      ((Path)localObject3).cubicTo(62.040001F, 15.38F, 70.849998F, 7.16F, 81.419998F, 3.53F);
      ((Path)localObject3).lineTo(81.419998F, 3.53F);
      ((Path)localObject3).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject3, 2);
      localCanvas.drawPath((Path)localObject3, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.save();
      localObject1 = c.a((Paint)localObject2, paramVarArgs);
      localObject2 = c.j(paramVarArgs);
      ((Path)localObject2).moveTo(179.49001F, 85.57F);
      ((Path)localObject2).cubicTo(193.81F, 84.440002F, 208.47F, 88.43F, 220.17999F, 96.760002F);
      ((Path)localObject2).cubicTo(232.95F, 105.7F, 242.14999F, 119.57F, 245.32001F, 134.84F);
      ((Path)localObject2).cubicTo(248.47F, 149.59F, 246.09F, 165.46001F, 238.59F, 178.56F);
      ((Path)localObject2).cubicTo(231.36F, 191.39F, 219.45F, 201.5F, 205.59F, 206.49001F);
      ((Path)localObject2).cubicTo(189.73F, 212.32001F, 171.50999F, 211.3F, 156.42F, 203.71001F);
      ((Path)localObject2).cubicTo(143.23F, 197.17999F, 132.53999F, 185.82001F, 126.8F, 172.27F);
      ((Path)localObject2).cubicTo(120.63F, 157.92999F, 120.2F, 141.25999F, 125.52F, 126.59F);
      ((Path)localObject2).cubicTo(133.46001F, 103.93F, 155.49001F, 87.089996F, 179.49001F, 85.57F);
      ((Path)localObject2).lineTo(179.49001F, 85.57F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(179.21001F, 110.04F);
      ((Path)localObject2).cubicTo(179.14999F, 124.0F, 179.14F, 137.97F, 179.22F, 151.94F);
      ((Path)localObject2).cubicTo(179.06F, 154.46001F, 181.46001F, 156.49001F, 183.89999F, 156.24001F);
      ((Path)localObject2).cubicTo(195.3F, 156.32001F, 206.69F, 156.22F, 218.09F, 156.28999F);
      ((Path)localObject2).cubicTo(220.06F, 156.25F, 222.47F, 156.47F, 223.81F, 154.67999F);
      ((Path)localObject2).cubicTo(225.82001F, 151.94F, 224.96001F, 146.49001F, 220.98F, 146.21001F);
      ((Path)localObject2).cubicTo(210.42F, 146.00999F, 199.86F, 146.2F, 189.3F, 146.13F);
      ((Path)localObject2).cubicTo(189.21001F, 133.77F, 189.45F, 121.41F, 189.19F, 109.06F);
      ((Path)localObject2).cubicTo(188.35001F, 103.85F, 178.85001F, 104.55F, 179.21001F, 110.04F);
      ((Path)localObject2).lineTo(179.21001F, 110.04F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 2);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.restore();
      c.h(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.avb
 * JD-Core Version:    0.7.0.1
 */