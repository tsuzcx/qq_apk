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

public final class bbr
  extends c
{
  private final int height = 132;
  private final int width = 132;
  
  public final int a(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 132;
      return 132;
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
      localPaint2 = c.a(localPaint1, paramVarArgs);
      localPaint2.setColor(-7822636);
      localCanvas.save();
      localPaint2 = c.a(localPaint2, paramVarArgs);
      Path localPath = c.n(paramVarArgs);
      localPath.moveTo(63.080002F, 0.0F);
      localPath.lineTo(68.639999F, 0.0F);
      localPath.cubicTo(86.010002F, 0.73F, 102.96F, 8.520001F, 114.65F, 21.42F);
      localPath.cubicTo(125.1F, 32.689999F, 131.2F, 47.700001F, 132.0F, 63.02F);
      localPath.lineTo(132.0F, 68.709999F);
      localPath.cubicTo(131.25999F, 85.080002F, 124.34F, 101.1F, 112.68F, 112.64F);
      localPath.cubicTo(101.21F, 124.27F, 85.290001F, 131.17999F, 69.0F, 132.0F);
      localPath.lineTo(63.290001F, 132.0F);
      localPath.cubicTo(45.93F, 131.25F, 29.0F, 123.46F, 17.34F, 110.56F);
      localPath.cubicTo(6.91F, 99.32F, 0.82F, 84.330002F, 0.0F, 69.050003F);
      localPath.lineTo(0.0F, 63.009998F);
      localPath.cubicTo(0.8F, 47.689999F, 6.91F, 32.669998F, 17.370001F, 21.41F);
      localPath.cubicTo(28.99F, 8.57F, 45.82F, 0.84F, 63.080002F, 0.0F);
      localPath.lineTo(63.080002F, 0.0F);
      localPath.close();
      localPath.moveTo(43.119999F, 44.220001F);
      localPath.cubicTo(39.580002F, 45.310001F, 38.889999F, 49.560001F, 40.43F, 52.549999F);
      localPath.cubicTo(39.080002F, 53.810001F, 37.32F, 55.040001F, 37.23F, 57.080002F);
      localPath.cubicTo(36.880001F, 58.970001F, 38.189999F, 60.52F, 38.970001F, 62.099998F);
      localPath.cubicTo(37.380001F, 63.66F, 35.52F, 65.5F, 36.060001F, 67.970001F);
      localPath.cubicTo(36.209999F, 70.169998F, 38.119999F, 71.400002F, 39.790001F, 72.480003F);
      localPath.cubicTo(38.619999F, 73.82F, 37.049999F, 75.110001F, 37.02F, 77.050003F);
      localPath.cubicTo(36.650002F, 80.309998F, 39.66F, 83.260002F, 42.900002F, 82.970001F);
      localPath.cubicTo(49.860001F, 83.07F, 56.810001F, 82.959999F, 63.77F, 82.989998F);
      localPath.cubicTo(62.150002F, 89.220001F, 62.400002F, 95.809998F, 64.010002F, 102.01F);
      localPath.cubicTo(64.639999F, 105.52F, 68.510002F, 108.13F, 71.970001F, 107.48F);
      localPath.cubicTo(73.699997F, 106.68F, 73.449997F, 104.59F, 73.459999F, 103.04F);
      localPath.cubicTo(73.099998F, 97.440002F, 73.589996F, 91.529999F, 76.599998F, 86.650002F);
      localPath.cubicTo(79.18F, 82.720001F, 83.059998F, 78.769997F, 88.099998F, 78.809998F);
      localPath.cubicTo(89.989998F, 78.290001F, 92.790001F, 78.989998F, 93.82F, 76.879997F);
      localPath.cubicTo(94.269997F, 70.610001F, 93.860001F, 64.309998F, 94.0F, 58.029999F);
      localPath.cubicTo(93.870003F, 54.639999F, 94.550003F, 51.09F, 93.199997F, 47.869999F);
      localPath.cubicTo(84.139999F, 49.169998F, 76.709999F, 42.549999F, 67.959999F, 41.849998F);
      localPath.cubicTo(59.66F, 40.970001F, 51.07F, 41.599998F, 43.119999F, 44.220001F);
      localPath.lineTo(43.119999F, 44.220001F);
      localPath.close();
      WeChatSVGRenderC2Java.setFillType(localPath, 2);
      localCanvas.drawPath(localPath, localPaint2);
      localCanvas.restore();
      localCanvas.save();
      localPaint1 = c.a(localPaint1, paramVarArgs);
      localPaint1.setColor(-1);
      localObject2 = c.a((float[])localObject2, 1.0F, 0.0F, 35.0F, 0.0F, 1.0F, 41.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject2);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject1 = c.a(localPaint1, paramVarArgs);
      localObject2 = c.n(paramVarArgs);
      ((Path)localObject2).moveTo(8.12F, 3.22F);
      ((Path)localObject2).cubicTo(16.07F, 0.6F, 24.66F, -0.03F, 32.959999F, 0.85F);
      ((Path)localObject2).cubicTo(41.709999F, 1.55F, 49.139999F, 8.17F, 58.200001F, 6.87F);
      ((Path)localObject2).cubicTo(59.549999F, 10.09F, 58.869999F, 13.64F, 59.0F, 17.030001F);
      ((Path)localObject2).cubicTo(58.860001F, 23.309999F, 59.27F, 29.610001F, 58.82F, 35.880001F);
      ((Path)localObject2).cubicTo(57.790001F, 37.990002F, 54.990002F, 37.290001F, 53.099998F, 37.810001F);
      ((Path)localObject2).cubicTo(48.060001F, 37.77F, 44.18F, 41.720001F, 41.599998F, 45.650002F);
      ((Path)localObject2).cubicTo(38.59F, 50.529999F, 38.099998F, 56.439999F, 38.459999F, 62.040001F);
      ((Path)localObject2).cubicTo(38.450001F, 63.59F, 38.700001F, 65.68F, 36.970001F, 66.480003F);
      ((Path)localObject2).cubicTo(33.509998F, 67.129997F, 29.639999F, 64.519997F, 29.01F, 61.009998F);
      ((Path)localObject2).cubicTo(27.4F, 54.810001F, 27.15F, 48.220001F, 28.77F, 41.990002F);
      ((Path)localObject2).cubicTo(21.809999F, 41.959999F, 14.86F, 42.07F, 7.9F, 41.970001F);
      ((Path)localObject2).cubicTo(4.66F, 42.259998F, 1.65F, 39.310001F, 2.02F, 36.049999F);
      ((Path)localObject2).cubicTo(2.05F, 34.110001F, 3.62F, 32.82F, 4.79F, 31.48F);
      ((Path)localObject2).cubicTo(3.12F, 30.4F, 1.21F, 29.17F, 1.06F, 26.969999F);
      ((Path)localObject2).cubicTo(0.52F, 24.5F, 2.38F, 22.66F, 3.97F, 21.1F);
      ((Path)localObject2).cubicTo(3.19F, 19.52F, 1.88F, 17.969999F, 2.23F, 16.08F);
      ((Path)localObject2).cubicTo(2.32F, 14.04F, 4.08F, 12.81F, 5.43F, 11.55F);
      ((Path)localObject2).cubicTo(3.89F, 8.56F, 4.58F, 4.31F, 8.12F, 3.22F);
      ((Path)localObject2).lineTo(8.12F, 3.22F);
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
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.bbr
 * JD-Core Version:    0.7.0.1
 */