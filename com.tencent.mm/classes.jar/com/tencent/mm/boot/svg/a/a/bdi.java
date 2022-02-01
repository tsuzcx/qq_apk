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

public final class bdi
  extends c
{
  private final int height = 480;
  private final int width = 480;
  
  public final int a(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 480;
      return 480;
      Canvas localCanvas = (Canvas)paramVarArgs[0];
      paramVarArgs = (Looper)paramVarArgs[1];
      Object localObject1 = c.j(paramVarArgs);
      float[] arrayOfFloat = c.i(paramVarArgs);
      Object localObject2 = c.m(paramVarArgs);
      ((Paint)localObject2).setFlags(385);
      ((Paint)localObject2).setStyle(Paint.Style.FILL);
      Paint localPaint = c.m(paramVarArgs);
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
      arrayOfFloat = c.a(arrayOfFloat, 1.0F, 0.0F, 133.0F, 0.0F, 1.0F, 30.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject1);
      localPaint = c.a((Paint)localObject2, paramVarArgs);
      localPaint.setColor(-10197916);
      localCanvas.save();
      localPaint = c.a(localPaint, paramVarArgs);
      Path localPath = c.n(paramVarArgs);
      localPath.moveTo(46.0F, 3.02F);
      localPath.cubicTo(71.910004F, 0.31F, 98.0F, -0.21F, 124.04F, 0.1F);
      localPath.cubicTo(144.69F, 0.44F, 165.37F, 1.38F, 185.86F, 4.14F);
      localPath.cubicTo(195.27F, 5.44F, 204.67999F, 7.21F, 213.66F, 10.43F);
      localPath.cubicTo(216.28F, 11.49F, 218.85001F, 13.33F, 219.91F, 16.049999F);
      localPath.cubicTo(221.41F, 19.5F, 220.95F, 23.34F, 221.00999F, 26.99F);
      localPath.cubicTo(220.99001F, 88.639999F, 221.0F, 150.28F, 221.0F, 211.92F);
      localPath.cubicTo(216.38F, 210.98F, 211.7F, 210.39F, 207.0F, 210.14F);
      localPath.lineTo(207.0F, 39.0F);
      localPath.lineTo(15.0F, 39.0F);
      localPath.lineTo(15.0F, 349.0F);
      localPath.lineTo(117.8F, 349.0F);
      localPath.cubicTo(129.92F, 372.38F, 152.17999F, 390.20999F, 177.67F, 396.85999F);
      localPath.cubicTo(154.52F, 399.26001F, 131.24001F, 400.06F, 107.98F, 399.98999F);
      localPath.cubicTo(85.989998F, 399.85001F, 63.959999F, 399.12F, 42.110001F, 396.51001F);
      localPath.cubicTo(30.889999F, 394.98001F, 19.42F, 393.54999F, 8.92F, 389.10001F);
      localPath.cubicTo(4.08F, 387.20001F, 0.57F, 382.32001F, 0.99F, 377.03F);
      localPath.cubicTo(1.01F, 258.67999F, 0.99F, 140.34F, 1.01F, 21.99F);
      localPath.cubicTo(0.73F, 17.299999F, 3.14F, 12.48F, 7.65F, 10.71F);
      localPath.cubicTo(19.99F, 6.32F, 33.029999F, 4.46F, 46.0F, 3.02F);
      localPath.lineTo(46.0F, 3.02F);
      localPath.lineTo(46.0F, 3.02F);
      localPath.close();
      localPath.moveTo(107.32F, 365.42001F);
      localPath.cubicTo(100.42F, 367.94F, 99.400002F, 378.51001F, 105.73F, 382.26001F);
      localPath.cubicTo(111.39F, 386.41F, 120.33F, 382.01999F, 120.53F, 375.01999F);
      localPath.cubicTo(121.36F, 368.19F, 113.56F, 362.44F, 107.32F, 365.42001F);
      localPath.lineTo(107.32F, 365.42001F);
      localPath.lineTo(107.32F, 365.42001F);
      localPath.close();
      WeChatSVGRenderC2Java.setFillType(localPath, 2);
      localCanvas.drawPath(localPath, localPaint);
      localCanvas.restore();
      localCanvas.save();
      localPaint = c.a((Paint)localObject2, paramVarArgs);
      localPaint.setColor(-11286451);
      arrayOfFloat = c.a(arrayOfFloat, 1.0F, 0.0F, 107.0F, 0.0F, 1.0F, 210.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localPaint = c.a(localPaint, paramVarArgs);
      localPath = c.n(paramVarArgs);
      localPath.moveTo(40.419998F, 17.27F);
      localPath.cubicTo(57.599998F, 5.08F, 78.970001F, -1.01F, 100.0F, 0.15F);
      localPath.cubicTo(104.7F, 0.38F, 109.38F, 0.98F, 114.0F, 1.92F);
      localPath.cubicTo(135.63F, 6.26F, 155.55F, 18.48F, 169.25F, 35.77F);
      localPath.cubicTo(183.48F, 53.43F, 190.94F, 76.339996F, 189.89F, 98.989998F);
      localPath.cubicTo(189.14F, 118.74F, 181.97F, 138.16F, 169.71001F, 153.66F);
      localPath.cubicTo(159.17F, 167.14999F, 144.89F, 177.64999F, 128.89999F, 183.75999F);
      localPath.cubicTo(110.4F, 190.87F, 89.68F, 191.87F, 70.529999F, 186.84F);
      localPath.cubicTo(45.110001F, 180.13F, 22.9F, 162.35001F, 10.8F, 139.0F);
      localPath.cubicTo(0.54F, 119.54F, -2.54F, 96.43F, 2.15F, 74.940002F);
      localPath.cubicTo(7.02F, 51.799999F, 21.040001F, 30.799999F, 40.419998F, 17.27F);
      localPath.lineTo(40.419998F, 17.27F);
      localPath.close();
      localPath.moveTo(135.13F, 63.07F);
      localPath.cubicTo(116.74F, 81.309998F, 98.5F, 99.709999F, 80.139999F, 117.98F);
      localPath.cubicTo(72.239998F, 110.17F, 64.519997F, 102.18F, 56.52F, 94.489998F);
      localPath.cubicTo(54.07F, 92.440002F, 51.790001F, 95.459999F, 50.139999F, 97.029999F);
      localPath.cubicTo(48.560001F, 98.769997F, 45.189999F, 101.05F, 47.290001F, 103.64F);
      localPath.cubicTo(57.139999F, 113.8F, 67.300003F, 123.67F, 77.25F, 133.74001F);
      localPath.cubicTo(78.459999F, 135.3F, 80.949997F, 136.13F, 82.370003F, 134.34F);
      localPath.cubicTo(102.11F, 114.74F, 121.71F, 95.0F, 141.42F, 75.370003F);
      localPath.cubicTo(142.77F, 73.959999F, 144.36F, 72.709999F, 145.31F, 70.980003F);
      localPath.cubicTo(145.81F, 68.150002F, 142.77F, 66.639999F, 141.25F, 64.730003F);
      localPath.cubicTo(139.8F, 63.02F, 137.14999F, 60.790001F, 135.13F, 63.07F);
      localPath.lineTo(135.13F, 63.07F);
      localPath.close();
      WeChatSVGRenderC2Java.setFillType(localPath, 2);
      localCanvas.drawPath(localPath, localPaint);
      localCanvas.restore();
      localCanvas.restore();
      localCanvas.save();
      localObject2 = c.a((Paint)localObject2, paramVarArgs);
      ((Paint)localObject2).setColor(-1);
      arrayOfFloat = c.a(arrayOfFloat, 1.0F, 0.0F, 153.0F, 0.0F, 1.0F, 272.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject1 = c.a((Paint)localObject2, paramVarArgs);
      localObject2 = c.n(paramVarArgs);
      ((Path)localObject2).moveTo(89.129997F, 1.07F);
      ((Path)localObject2).cubicTo(91.150002F, -1.21F, 93.800003F, 1.02F, 95.25F, 2.73F);
      ((Path)localObject2).cubicTo(96.769997F, 4.64F, 99.809998F, 6.15F, 99.309998F, 8.98F);
      ((Path)localObject2).cubicTo(98.360001F, 10.71F, 96.769997F, 11.96F, 95.419998F, 13.37F);
      ((Path)localObject2).cubicTo(75.709999F, 33.0F, 56.110001F, 52.740002F, 36.369999F, 72.339996F);
      ((Path)localObject2).cubicTo(34.950001F, 74.129997F, 32.459999F, 73.300003F, 31.25F, 71.739998F);
      ((Path)localObject2).cubicTo(21.299999F, 61.669998F, 11.14F, 51.799999F, 1.29F, 41.639999F);
      ((Path)localObject2).cubicTo(-0.81F, 39.049999F, 2.56F, 36.77F, 4.14F, 35.029999F);
      ((Path)localObject2).cubicTo(5.79F, 33.459999F, 8.07F, 30.440001F, 10.52F, 32.490002F);
      ((Path)localObject2).cubicTo(18.52F, 40.18F, 26.24F, 48.169998F, 34.139999F, 55.98F);
      ((Path)localObject2).cubicTo(52.5F, 37.709999F, 70.739998F, 19.309999F, 89.129997F, 1.07F);
      ((Path)localObject2).lineTo(89.129997F, 1.07F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 2);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.restore();
      localCanvas.restore();
      c.l(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.bdi
 * JD-Core Version:    0.7.0.1
 */