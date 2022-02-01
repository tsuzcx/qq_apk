package com.tencent.mm.boot.svg.code.drawable;

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

public class shake_card_package_defaultlogo
  extends c
{
  private final int height = 168;
  private final int width = 168;
  
  public int doCommand(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 168;
      return 168;
      Canvas localCanvas = (Canvas)paramVarArgs[0];
      paramVarArgs = (Looper)paramVarArgs[1];
      Object localObject1 = c.instanceMatrix(paramVarArgs);
      Object localObject2 = c.instanceMatrixArray(paramVarArgs);
      Paint localPaint1 = c.instancePaint(paramVarArgs);
      localPaint1.setFlags(385);
      localPaint1.setStyle(Paint.Style.FILL);
      Paint localPaint2 = c.instancePaint(paramVarArgs);
      localPaint2.setFlags(385);
      localPaint2.setStyle(Paint.Style.STROKE);
      localPaint1.setColor(-16777216);
      localPaint2.setStrokeWidth(1.0F);
      localPaint2.setStrokeCap(Paint.Cap.BUTT);
      localPaint2.setStrokeJoin(Paint.Join.MITER);
      localPaint2.setStrokeMiter(4.0F);
      localPaint2.setPathEffect(null);
      c.instancePaint(localPaint2, paramVarArgs).setStrokeWidth(1.0F);
      localPaint2 = c.instancePaint(localPaint1, paramVarArgs);
      localPaint2.setColor(-16777216);
      localCanvas.saveLayerAlpha(null, 12, 31);
      localCanvas.save();
      localPaint2 = c.instancePaint(localPaint2, paramVarArgs);
      Path localPath = c.instancePath(paramVarArgs);
      localPath.moveTo(75.639999F, 0.0F);
      localPath.lineTo(92.349998F, 0.0F);
      localPath.cubicTo(108.49F, 2.54F, 124.47F, 8.31F, 137.10001F, 18.92F);
      localPath.cubicTo(146.41F, 26.74F, 154.39999F, 36.290001F, 159.53F, 47.360001F);
      localPath.cubicTo(163.95F, 56.220001F, 166.21001F, 65.93F, 168.0F, 75.599998F);
      localPath.lineTo(168.0F, 92.349998F);
      localPath.cubicTo(165.12F, 111.53F, 157.10001F, 130.37F, 142.86F, 143.85001F);
      localPath.cubicTo(129.5F, 157.55F, 111.09F, 165.10001F, 92.410004F, 168.0F);
      localPath.lineTo(75.580002F, 168.0F);
      localPath.cubicTo(56.68F, 165.11F, 38.040001F, 157.37F, 24.68F, 143.35001F);
      localPath.cubicTo(10.65F, 129.97F, 2.92F, 111.3F, 0.0F, 92.389999F);
      localPath.lineTo(0.0F, 75.589996F);
      localPath.cubicTo(2.9F, 56.919998F, 10.4F, 38.450001F, 24.17F, 25.139999F);
      localPath.cubicTo(37.619999F, 10.85F, 56.48F, 2.9F, 75.639999F, 0.0F);
      localPath.lineTo(75.639999F, 0.0F);
      localPath.close();
      localPath.moveTo(46.5F, 68.449997F);
      localPath.cubicTo(45.360001F, 76.589996F, 46.25F, 84.82F, 46.0F, 92.989998F);
      localPath.cubicTo(46.259998F, 100.47F, 45.34F, 108.01F, 46.540001F, 115.43F);
      localPath.cubicTo(51.869999F, 117.08F, 57.48F, 117.16F, 62.98F, 117.82F);
      localPath.cubicTo(76.25F, 119.33F, 89.510002F, 120.92F, 102.79F, 122.36F);
      localPath.cubicTo(108.34F, 122.9F, 113.87F, 124.28F, 119.47F, 123.62F);
      localPath.cubicTo(120.66F, 115.13F, 119.69F, 106.53F, 120.0F, 97.989998F);
      localPath.cubicTo(119.79F, 90.860001F, 120.64F, 83.669998F, 119.48F, 76.589996F);
      localPath.cubicTo(113.5F, 74.709999F, 107.17F, 74.800003F, 101.01F, 73.980003F);
      localPath.cubicTo(88.410004F, 72.470001F, 75.800003F, 71.0F, 63.18F, 69.650002F);
      localPath.cubicTo(57.630001F, 69.150002F, 52.09F, 67.550003F, 46.5F, 68.449997F);
      localPath.lineTo(46.5F, 68.449997F);
      localPath.close();
      WeChatSVGRenderC2Java.setFillType(localPath, 2);
      localCanvas.drawPath(localPath, localPaint2);
      localCanvas.restore();
      localCanvas.restore();
      localCanvas.save();
      localPaint2 = c.instancePaint(localPaint1, paramVarArgs);
      localPaint2.setColor(-16777216);
      localObject2 = c.setMatrixFloatArray((float[])localObject2, 1.0F, 0.0F, 45.0F, 0.0F, 1.0F, 68.0F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject2);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.saveLayerAlpha(null, 25, 31);
      localCanvas.save();
      localObject1 = c.instancePaint(localPaint2, paramVarArgs);
      localObject2 = c.instancePath(paramVarArgs);
      ((Path)localObject2).moveTo(1.5F, 0.45F);
      ((Path)localObject2).cubicTo(7.09F, -0.45F, 12.63F, 1.15F, 18.18F, 1.65F);
      ((Path)localObject2).cubicTo(30.799999F, 3.0F, 43.41F, 4.47F, 56.009998F, 5.98F);
      ((Path)localObject2).cubicTo(62.169998F, 6.8F, 68.5F, 6.71F, 74.480003F, 8.59F);
      ((Path)localObject2).cubicTo(75.639999F, 15.67F, 74.790001F, 22.860001F, 75.0F, 29.99F);
      ((Path)localObject2).cubicTo(74.690002F, 38.529999F, 75.660004F, 47.130001F, 74.470001F, 55.619999F);
      ((Path)localObject2).cubicTo(68.870003F, 56.279999F, 63.34F, 54.900002F, 57.790001F, 54.360001F);
      ((Path)localObject2).cubicTo(44.509998F, 52.919998F, 31.25F, 51.330002F, 17.98F, 49.82F);
      ((Path)localObject2).cubicTo(12.48F, 49.16F, 6.87F, 49.080002F, 1.54F, 47.43F);
      ((Path)localObject2).cubicTo(0.34F, 40.009998F, 1.26F, 32.470001F, 1.0F, 24.99F);
      ((Path)localObject2).cubicTo(1.25F, 16.82F, 0.36F, 8.59F, 1.5F, 0.45F);
      ((Path)localObject2).lineTo(1.5F, 0.45F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 2);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.restore();
      localCanvas.restore();
      localCanvas.save();
      localPaint1 = c.instancePaint(localPaint1, paramVarArgs);
      localPaint1.setColor(-1644826);
      localObject1 = c.instancePath(paramVarArgs);
      ((Path)localObject1).moveTo(50.357639F, 63.368923F);
      ((Path)localObject1).lineTo(113.62674F, 55.344185F);
      ((Path)localObject1).cubicTo(113.62674F, 55.344185F, 118.90408F, 54.899307F, 118.90408F, 59.134113F);
      ((Path)localObject1).cubicTo(118.90408F, 63.368923F, 118.90408F, 70.766945F, 118.90408F, 70.766945F);
      ((Path)localObject1).lineTo(50.357639F, 63.368923F);
      ((Path)localObject1).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject1, 2);
      localCanvas.drawPath((Path)localObject1, localPaint1);
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.shake_card_package_defaultlogo
 * JD-Core Version:    0.7.0.1
 */