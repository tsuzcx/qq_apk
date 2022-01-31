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

public final class d
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
      localObject3 = c.a((float[])localObject3, 1.0F, 0.0F, 133.0F, 0.0F, 1.0F, 40.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject3);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localPaint = c.a(localPaint, paramVarArgs);
      Path localPath = c.l(paramVarArgs);
      localPath.moveTo(51.919998F, 2.43F);
      localPath.cubicTo(82.18F, -0.25F, 112.62F, -0.46F, 142.97F, 0.61F);
      localPath.cubicTo(163.46001F, 1.61F, 184.10001F, 2.83F, 204.13F, 7.54F);
      localPath.cubicTo(209.19F, 9.21F, 215.21001F, 9.75F, 218.83F, 14.11F);
      localPath.cubicTo(221.50999F, 17.83F, 220.99001F, 22.629999F, 221.0F, 26.959999F);
      localPath.cubicTo(220.99001F, 88.610001F, 221.0F, 150.27F, 221.0F, 211.92F);
      localPath.cubicTo(216.38F, 210.98F, 211.7F, 210.39999F, 207.0F, 210.14999F);
      localPath.lineTo(207.0F, 39.0F);
      localPath.lineTo(15.0F, 39.0F);
      localPath.lineTo(15.0F, 349.0F);
      localPath.cubicTo(49.27F, 349.0F, 83.529999F, 348.98999F, 117.8F, 349.0F);
      localPath.cubicTo(129.88F, 372.32999F, 152.05F, 390.07999F, 177.42999F, 396.81F);
      localPath.cubicTo(151.38F, 399.66F, 125.14F, 400.20999F, 98.949997F, 399.89999F);
      localPath.cubicTo(78.309998F, 399.56F, 57.639999F, 398.64999F, 37.169998F, 395.87F);
      localPath.cubicTo(28.58F, 394.60999F, 19.940001F, 393.20001F, 11.74F, 390.26999F);
      localPath.cubicTo(8.14F, 388.95999F, 4.37F, 387.09F, 2.47F, 383.57001F);
      localPath.cubicTo(0.42F, 380.07001F, 1.11F, 375.85001F, 1.0F, 371.98001F);
      localPath.cubicTo(1.01F, 255.32001F, 0.99F, 138.66F, 1.0F, 22.0F);
      localPath.cubicTo(0.72F, 17.299999F, 3.14F, 12.51F, 7.62F, 10.71F);
      localPath.cubicTo(21.860001F, 5.68F, 36.970001F, 3.9F, 51.919998F, 2.43F);
      localPath.lineTo(51.919998F, 2.43F);
      localPath.close();
      localPath.moveTo(107.29F, 365.42999F);
      localPath.cubicTo(100.42F, 367.97F, 99.410004F, 378.5F, 105.72F, 382.25F);
      localPath.cubicTo(111.4F, 386.44F, 120.41F, 381.97F, 120.54F, 374.92001F);
      localPath.cubicTo(121.3F, 368.12F, 113.5F, 362.45001F, 107.29F, 365.42999F);
      localPath.lineTo(107.29F, 365.42999F);
      localPath.close();
      WeChatSVGRenderC2Java.setFillType(localPath, 2);
      localCanvas.drawPath(localPath, localPaint);
      localCanvas.restore();
      localCanvas.restore();
      localCanvas.save();
      localPaint = c.a((Paint)localObject2, paramVarArgs);
      localPaint.setColor(-499359);
      localObject3 = c.a((float[])localObject3, 1.0F, 0.0F, 240.0F, 0.0F, 1.0F, 250.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject3);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localPaint = c.a(localPaint, paramVarArgs);
      localPath = c.l(paramVarArgs);
      localPath.moveTo(40.360001F, 17.309999F);
      localPath.cubicTo(57.549999F, 5.09F, 78.940002F, -1.01F, 100.0F, 0.15F);
      localPath.cubicTo(104.7F, 0.4F, 109.38F, 0.98F, 114.0F, 1.92F);
      localPath.cubicTo(135.62F, 6.25F, 155.53F, 18.469999F, 169.23F, 35.740002F);
      localPath.cubicTo(183.69F, 53.669998F, 191.16F, 77.019997F, 189.85001F, 100.01F);
      localPath.cubicTo(188.89F, 119.41F, 181.75F, 138.44F, 169.7F, 153.67F);
      localPath.cubicTo(159.17F, 167.16F, 144.88F, 177.64999F, 128.89F, 183.75999F);
      localPath.cubicTo(110.36F, 190.89F, 89.610001F, 191.87F, 70.43F, 186.81F);
      localPath.cubicTo(45.049999F, 180.08F, 22.879999F, 162.33F, 10.8F, 139.0F);
      localPath.cubicTo(0.54F, 119.53F, -2.54F, 96.419998F, 2.16F, 74.919998F);
      localPath.cubicTo(7.03F, 51.810001F, 21.02F, 30.84F, 40.360001F, 17.309999F);
      localPath.lineTo(40.360001F, 17.309999F);
      localPath.close();
      localPath.moveTo(90.089996F, 45.18F);
      localPath.cubicTo(89.860001F, 45.41F, 89.400002F, 45.889999F, 89.169998F, 46.130001F);
      localPath.cubicTo(88.760002F, 69.730003F, 89.139999F, 93.370003F, 88.980003F, 116.99F);
      localPath.cubicTo(88.919998F, 118.51F, 88.839996F, 121.1F, 91.050003F, 120.94F);
      localPath.cubicTo(94.199997F, 120.64F, 98.309998F, 122.11F, 100.83F, 119.9F);
      localPath.cubicTo(101.24F, 96.610001F, 100.85F, 73.290001F, 101.03F, 49.98F);
      localPath.cubicTo(100.81F, 48.369999F, 101.56F, 46.189999F, 99.889999F, 45.16F);
      localPath.cubicTo(96.639999F, 44.869999F, 93.339996F, 44.849998F, 90.089996F, 45.18F);
      localPath.lineTo(90.089996F, 45.18F);
      localPath.close();
      localPath.moveTo(90.139999F, 133.16F);
      localPath.cubicTo(89.889999F, 133.41F, 89.400002F, 133.91F, 89.160004F, 134.16F);
      localPath.cubicTo(88.860001F, 137.38F, 88.860001F, 140.64F, 89.160004F, 143.86F);
      localPath.cubicTo(89.400002F, 144.11F, 89.889999F, 144.59F, 90.139999F, 144.84F);
      localPath.cubicTo(93.480003F, 144.89F, 97.309998F, 145.66F, 100.39F, 144.39F);
      localPath.cubicTo(101.67F, 141.33F, 100.89F, 137.47F, 100.84F, 134.13F);
      localPath.cubicTo(100.59F, 133.89F, 100.11F, 133.41F, 99.870003F, 133.16F);
      localPath.cubicTo(96.629997F, 132.86F, 93.360001F, 132.86F, 90.139999F, 133.16F);
      localPath.lineTo(90.139999F, 133.16F);
      localPath.close();
      WeChatSVGRenderC2Java.setFillType(localPath, 2);
      localCanvas.drawPath(localPath, localPaint);
      localCanvas.restore();
      localCanvas.restore();
      localCanvas.save();
      localObject2 = c.a((Paint)localObject2, paramVarArgs);
      ((Paint)localObject2).setColor(-1);
      localObject3 = c.a((float[])localObject3, 1.0F, 0.0F, 328.0F, 0.0F, 1.0F, 294.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject3);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject1 = c.a((Paint)localObject2, paramVarArgs);
      localObject3 = c.l(paramVarArgs);
      ((Path)localObject3).moveTo(2.09F, 1.18F);
      ((Path)localObject3).cubicTo(5.34F, 0.85F, 8.64F, 0.87F, 11.89F, 1.16F);
      ((Path)localObject3).cubicTo(13.56F, 2.19F, 12.81F, 4.37F, 13.03F, 5.98F);
      ((Path)localObject3).cubicTo(12.85F, 29.290001F, 13.24F, 52.610001F, 12.83F, 75.900002F);
      ((Path)localObject3).cubicTo(10.31F, 78.110001F, 6.2F, 76.639999F, 3.05F, 76.940002F);
      ((Path)localObject3).cubicTo(0.84F, 77.099998F, 0.92F, 74.510002F, 0.98F, 72.989998F);
      ((Path)localObject3).cubicTo(1.14F, 49.369999F, 0.76F, 25.73F, 1.17F, 2.13F);
      ((Path)localObject3).cubicTo(1.4F, 1.89F, 1.86F, 1.41F, 2.09F, 1.18F);
      ((Path)localObject3).lineTo(2.09F, 1.18F);
      ((Path)localObject3).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject3, 2);
      localCanvas.drawPath((Path)localObject3, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.save();
      localObject1 = c.a((Paint)localObject2, paramVarArgs);
      localObject2 = c.l(paramVarArgs);
      ((Path)localObject2).moveTo(2.14F, 89.160004F);
      ((Path)localObject2).cubicTo(5.36F, 88.860001F, 8.63F, 88.860001F, 11.87F, 89.160004F);
      ((Path)localObject2).cubicTo(12.11F, 89.410004F, 12.59F, 89.889999F, 12.84F, 90.129997F);
      ((Path)localObject2).cubicTo(12.89F, 93.470001F, 13.67F, 97.330002F, 12.39F, 100.39F);
      ((Path)localObject2).cubicTo(9.31F, 101.66F, 5.48F, 100.89F, 2.14F, 100.84F);
      ((Path)localObject2).cubicTo(1.89F, 100.59F, 1.4F, 100.11F, 1.16F, 99.860001F);
      ((Path)localObject2).cubicTo(0.86F, 96.639999F, 0.86F, 93.379997F, 1.16F, 90.160004F);
      ((Path)localObject2).cubicTo(1.4F, 89.910004F, 1.89F, 89.410004F, 2.14F, 89.160004F);
      ((Path)localObject2).lineTo(2.14F, 89.160004F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 2);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.restore();
      c.j(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.d
 * JD-Core Version:    0.7.0.1
 */