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

public final class ajb
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
      Object localObject1 = c.h(paramVarArgs);
      Object localObject3 = c.g(paramVarArgs);
      Object localObject2 = c.k(paramVarArgs);
      ((Paint)localObject2).setFlags(385);
      ((Paint)localObject2).setStyle(Paint.Style.FILL);
      Paint localPaint = c.k(paramVarArgs);
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
      localPaint = c.a((Paint)localObject2, paramVarArgs);
      localPaint.setColor(-10197916);
      localObject3 = c.a((float[])localObject3, 1.0F, 0.0F, 129.0F, 0.0F, 1.0F, 40.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject3);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localPaint = c.a(localPaint, paramVarArgs);
      Path localPath = c.l(paramVarArgs);
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
      localPath.close();
      localPath.moveTo(107.32F, 365.42001F);
      localPath.cubicTo(100.42F, 367.94F, 99.400002F, 378.51001F, 105.73F, 382.26001F);
      localPath.cubicTo(111.39F, 386.41F, 120.33F, 382.01999F, 120.53F, 375.01999F);
      localPath.cubicTo(121.36F, 368.19F, 113.56F, 362.44F, 107.32F, 365.42001F);
      localPath.lineTo(107.32F, 365.42001F);
      localPath.close();
      WeChatSVGRenderC2Java.setFillType(localPath, 2);
      localCanvas.drawPath(localPath, localPaint);
      localCanvas.restore();
      localCanvas.restore();
      localCanvas.save();
      localObject3 = c.a((float[])localObject3, 1.0F, 0.0F, 129.0F, 0.0F, 1.0F, 40.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject3);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.restore();
      localCanvas.save();
      localPaint = c.a((Paint)localObject2, paramVarArgs);
      localPaint.setColor(-5395027);
      localObject3 = c.a((float[])localObject3, 1.0F, 0.0F, 236.0F, 0.0F, 1.0F, 250.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject3);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localPaint = c.a(localPaint, paramVarArgs);
      localPath = c.l(paramVarArgs);
      localPath.moveTo(42.130001F, 16.09F);
      localPath.cubicTo(59.0F, 4.67F, 79.660004F, -0.97F, 100.0F, 0.15F);
      localPath.cubicTo(104.7F, 0.38F, 109.38F, 0.98F, 113.99F, 1.92F);
      localPath.cubicTo(135.39F, 6.21F, 155.12F, 18.209999F, 168.8F, 35.209999F);
      localPath.cubicTo(183.31F, 52.950001F, 190.95F, 76.099998F, 189.89F, 98.989998F);
      localPath.cubicTo(189.14F, 118.74F, 181.97F, 138.17F, 169.7F, 153.66F);
      localPath.cubicTo(159.14999F, 167.17F, 144.84F, 177.67999F, 128.82001F, 183.78999F);
      localPath.cubicTo(110.35F, 190.87F, 89.660004F, 191.87F, 70.540001F, 186.83F);
      localPath.cubicTo(45.110001F, 180.13F, 22.889999F, 162.36F, 10.8F, 139.0F);
      localPath.cubicTo(1.421086E-014F, 118.54F, -2.81F, 94.059998F, 2.92F, 71.650002F);
      localPath.cubicTo(8.520001F, 49.130001F, 22.83F, 28.959999F, 42.130001F, 16.09F);
      localPath.lineTo(42.130001F, 16.09F);
      localPath.close();
      localPath.moveTo(76.720001F, 53.779999F);
      localPath.cubicTo(71.110001F, 58.09F, 68.019997F, 65.099998F, 67.980003F, 72.110001F);
      localPath.cubicTo(72.07F, 72.160004F, 76.169998F, 72.120003F, 80.269997F, 72.150002F);
      localPath.cubicTo(80.599998F, 67.400002F, 82.889999F, 62.529999F, 87.440002F, 60.509998F);
      localPath.cubicTo(93.410004F, 57.810001F, 101.47F, 57.799999F, 106.39F, 62.619999F);
      localPath.cubicTo(111.52F, 68.459999F, 111.33F, 77.860001F, 107.13F, 84.169998F);
      localPath.cubicTo(102.24F, 91.129997F, 94.900002F, 96.059998F, 90.529999F, 103.44F);
      localPath.cubicTo(87.629997F, 108.31F, 87.160004F, 114.11F, 87.010002F, 119.66F);
      localPath.cubicTo(91.139999F, 119.68F, 95.279999F, 119.68F, 99.410004F, 119.66F);
      localPath.cubicTo(99.68F, 114.01F, 100.47F, 107.8F, 104.75F, 103.66F);
      localPath.cubicTo(110.08F, 98.309998F, 115.86F, 93.139999F, 119.35F, 86.330002F);
      localPath.cubicTo(123.82F, 78.199997F, 123.76F, 67.82F, 119.41F, 59.66F);
      localPath.cubicTo(116.01F, 53.23F, 109.1F, 49.369999F, 102.07F, 48.310001F);
      localPath.cubicTo(93.379997F, 46.990002F, 83.790001F, 48.209999F, 76.720001F, 53.779999F);
      localPath.lineTo(76.720001F, 53.779999F);
      localPath.close();
      localPath.moveTo(90.379997F, 134.5F);
      localPath.cubicTo(84.529999F, 136.88F, 85.459999F, 147.17F, 91.980003F, 147.86F);
      localPath.cubicTo(96.849998F, 149.28F, 102.23F, 145.17F, 101.18F, 139.97F);
      localPath.cubicTo(100.85F, 134.8F, 94.68F, 132.56F, 90.379997F, 134.5F);
      localPath.lineTo(90.379997F, 134.5F);
      localPath.close();
      WeChatSVGRenderC2Java.setFillType(localPath, 2);
      localCanvas.drawPath(localPath, localPaint);
      localCanvas.restore();
      localCanvas.restore();
      localCanvas.save();
      localObject2 = c.a((Paint)localObject2, paramVarArgs);
      ((Paint)localObject2).setColor(-1);
      localObject3 = c.a((float[])localObject3, 1.0F, 0.0F, 303.0F, 0.0F, 1.0F, 297.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject3);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject1 = c.a((Paint)localObject2, paramVarArgs);
      localObject3 = c.l(paramVarArgs);
      ((Path)localObject3).moveTo(9.72F, 6.78F);
      ((Path)localObject3).cubicTo(16.790001F, 1.21F, 26.379999F, -0.01F, 35.07F, 1.31F);
      ((Path)localObject3).cubicTo(42.099998F, 2.37F, 49.009998F, 6.23F, 52.41F, 12.66F);
      ((Path)localObject3).cubicTo(56.759998F, 20.82F, 56.82F, 31.200001F, 52.349998F, 39.330002F);
      ((Path)localObject3).cubicTo(48.860001F, 46.139999F, 43.080002F, 51.310001F, 37.75F, 56.66F);
      ((Path)localObject3).cubicTo(33.470001F, 60.799999F, 32.68F, 67.010002F, 32.41F, 72.660004F);
      ((Path)localObject3).cubicTo(28.280001F, 72.68F, 24.139999F, 72.68F, 20.01F, 72.660004F);
      ((Path)localObject3).cubicTo(20.16F, 67.110001F, 20.629999F, 61.310001F, 23.530001F, 56.439999F);
      ((Path)localObject3).cubicTo(27.9F, 49.060001F, 35.240002F, 44.130001F, 40.130001F, 37.169998F);
      ((Path)localObject3).cubicTo(44.330002F, 30.860001F, 44.52F, 21.459999F, 39.389999F, 15.62F);
      ((Path)localObject3).cubicTo(34.470001F, 10.8F, 26.41F, 10.81F, 20.440001F, 13.51F);
      ((Path)localObject3).cubicTo(15.89F, 15.53F, 13.6F, 20.4F, 13.27F, 25.15F);
      ((Path)localObject3).cubicTo(9.17F, 25.120001F, 5.07F, 25.16F, 0.98F, 25.110001F);
      ((Path)localObject3).cubicTo(1.02F, 18.1F, 4.11F, 11.09F, 9.72F, 6.78F);
      ((Path)localObject3).lineTo(9.72F, 6.78F);
      ((Path)localObject3).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject3, 2);
      localCanvas.drawPath((Path)localObject3, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.save();
      localObject1 = c.a((Paint)localObject2, paramVarArgs);
      localObject2 = c.l(paramVarArgs);
      ((Path)localObject2).moveTo(23.379999F, 87.5F);
      ((Path)localObject2).cubicTo(27.68F, 85.559998F, 33.849998F, 87.800003F, 34.18F, 92.970001F);
      ((Path)localObject2).cubicTo(35.23F, 98.169998F, 29.85F, 102.28F, 24.98F, 100.86F);
      ((Path)localObject2).cubicTo(18.459999F, 100.17F, 17.530001F, 89.879997F, 23.379999F, 87.5F);
      ((Path)localObject2).lineTo(23.379999F, 87.5F);
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
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.ajb
 * JD-Core Version:    0.7.0.1
 */