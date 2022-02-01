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

public class mall_order_trade_empty_icon
  extends c
{
  private final int height = 180;
  private final int width = 180;
  
  public int doCommand(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 180;
      return 180;
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
      localPaint2.setColor(-1250068);
      localCanvas.save();
      Object localObject3 = c.instancePaint(localPaint2, paramVarArgs);
      Path localPath = c.instancePath(paramVarArgs);
      localPath.moveTo(0.0F, 0.0F);
      localPath.lineTo(179.88945F, 0.0F);
      localPath.cubicTo(179.96985F, 60.0F, 179.73871F, 120.0F, 180.0F, 180.0F);
      localPath.lineTo(0.0F, 180.0F);
      localPath.lineTo(0.0F, 0.0F);
      localPath.lineTo(0.0F, 0.0F);
      localPath.close();
      WeChatSVGRenderC2Java.setFillType(localPath, 2);
      localCanvas.drawPath(localPath, (Paint)localObject3);
      localCanvas.restore();
      localCanvas.save();
      localObject3 = c.instancePaint(localPaint2, paramVarArgs);
      localPath = c.instancePath(paramVarArgs);
      localPath.moveTo(88.300003F, 70.370003F);
      localPath.cubicTo(90.790001F, 69.099998F, 94.129997F, 71.169998F, 93.980003F, 73.989998F);
      localPath.cubicTo(94.199997F, 77.110001F, 90.139999F, 79.199997F, 87.709999F, 77.260002F);
      localPath.cubicTo(85.190002F, 75.699997F, 85.599998F, 71.510002F, 88.300003F, 70.370003F);
      localPath.lineTo(88.300003F, 70.370003F);
      localPath.close();
      WeChatSVGRenderC2Java.setFillType(localPath, 2);
      localCanvas.drawPath(localPath, (Paint)localObject3);
      localCanvas.restore();
      localCanvas.save();
      localObject3 = c.instancePaint(localPaint2, paramVarArgs);
      localPath = c.instancePath(paramVarArgs);
      localPath.moveTo(65.019997F, 97.050003F);
      localPath.cubicTo(68.669998F, 96.949997F, 72.309998F, 96.940002F, 75.959999F, 97.029999F);
      localPath.cubicTo(76.050003F, 100.01F, 76.050003F, 102.99F, 75.949997F, 105.97F);
      localPath.cubicTo(72.32F, 106.05F, 68.68F, 106.05F, 65.040001F, 105.96F);
      localPath.cubicTo(64.949997F, 102.99F, 64.949997F, 100.02F, 65.019997F, 97.050003F);
      localPath.lineTo(65.019997F, 97.050003F);
      localPath.close();
      WeChatSVGRenderC2Java.setFillType(localPath, 2);
      localCanvas.drawPath(localPath, (Paint)localObject3);
      localCanvas.restore();
      localCanvas.save();
      localObject3 = c.instancePaint(localPaint2, paramVarArgs);
      localPath = c.instancePath(paramVarArgs);
      localPath.moveTo(85.029999F, 97.040001F);
      localPath.cubicTo(88.669998F, 96.949997F, 92.32F, 96.949997F, 95.959999F, 97.040001F);
      localPath.cubicTo(96.050003F, 100.01F, 96.050003F, 102.98F, 95.970001F, 105.96F);
      localPath.cubicTo(92.32F, 106.05F, 88.68F, 106.05F, 85.040001F, 105.97F);
      localPath.cubicTo(84.949997F, 102.99F, 84.949997F, 100.02F, 85.029999F, 97.040001F);
      localPath.lineTo(85.029999F, 97.040001F);
      localPath.close();
      WeChatSVGRenderC2Java.setFillType(localPath, 2);
      localCanvas.drawPath(localPath, (Paint)localObject3);
      localCanvas.restore();
      localCanvas.save();
      localObject3 = c.instancePaint(localPaint2, paramVarArgs);
      localPath = c.instancePath(paramVarArgs);
      localPath.moveTo(105.05F, 97.029999F);
      localPath.cubicTo(108.69F, 96.940002F, 112.33F, 96.949997F, 115.98F, 97.050003F);
      localPath.cubicTo(116.05F, 100.02F, 116.05F, 102.99F, 115.96F, 105.96F);
      localPath.cubicTo(112.32F, 106.05F, 108.68F, 106.05F, 105.03F, 105.96F);
      localPath.cubicTo(104.95F, 102.98F, 104.95F, 100.01F, 105.05F, 97.029999F);
      localPath.lineTo(105.05F, 97.029999F);
      localPath.close();
      WeChatSVGRenderC2Java.setFillType(localPath, 2);
      localCanvas.drawPath(localPath, (Paint)localObject3);
      localCanvas.restore();
      localCanvas.save();
      localObject3 = c.instancePaint(localPaint2, paramVarArgs);
      localPath = c.instancePath(paramVarArgs);
      localPath.moveTo(65.040001F, 112.04F);
      localPath.cubicTo(68.68F, 111.95F, 72.32F, 111.95F, 75.959999F, 112.03F);
      localPath.cubicTo(76.040001F, 115.0F, 76.050003F, 117.98F, 75.980003F, 120.95F);
      localPath.cubicTo(72.330002F, 121.05F, 68.68F, 121.05F, 65.029999F, 120.95F);
      localPath.cubicTo(64.949997F, 117.98F, 64.949997F, 115.01F, 65.040001F, 112.04F);
      localPath.lineTo(65.040001F, 112.04F);
      localPath.close();
      WeChatSVGRenderC2Java.setFillType(localPath, 2);
      localCanvas.drawPath(localPath, (Paint)localObject3);
      localCanvas.restore();
      localCanvas.save();
      localObject3 = c.instancePaint(localPaint2, paramVarArgs);
      localPath = c.instancePath(paramVarArgs);
      localPath.moveTo(85.019997F, 112.05F);
      localPath.cubicTo(88.660004F, 111.95F, 92.309998F, 111.94F, 95.949997F, 112.03F);
      localPath.cubicTo(96.050003F, 115.01F, 96.050003F, 117.99F, 95.959999F, 120.96F);
      localPath.cubicTo(92.32F, 121.05F, 88.669998F, 121.05F, 85.029999F, 120.95F);
      localPath.cubicTo(84.949997F, 117.98F, 84.949997F, 115.02F, 85.019997F, 112.05F);
      localPath.lineTo(85.019997F, 112.05F);
      localPath.close();
      WeChatSVGRenderC2Java.setFillType(localPath, 2);
      localCanvas.drawPath(localPath, (Paint)localObject3);
      localCanvas.restore();
      localCanvas.save();
      localPaint2 = c.instancePaint(localPaint2, paramVarArgs);
      localObject3 = c.instancePath(paramVarArgs);
      ((Path)localObject3).moveTo(105.02F, 112.05F);
      ((Path)localObject3).cubicTo(108.67F, 111.95F, 112.31F, 111.94F, 115.96F, 112.03F);
      ((Path)localObject3).cubicTo(116.05F, 115.01F, 116.04F, 118.0F, 115.94F, 120.98F);
      ((Path)localObject3).cubicTo(112.31F, 121.05F, 108.68F, 121.05F, 105.05F, 120.98F);
      ((Path)localObject3).cubicTo(104.96F, 118.0F, 104.94F, 115.03F, 105.02F, 112.05F);
      ((Path)localObject3).lineTo(105.02F, 112.05F);
      ((Path)localObject3).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject3, 2);
      localCanvas.drawPath((Path)localObject3, localPaint2);
      localCanvas.restore();
      localCanvas.save();
      localPaint1 = c.instancePaint(localPaint1, paramVarArgs);
      localPaint1.setColor(-3355444);
      localObject2 = c.setMatrixFloatArray((float[])localObject2, 1.0F, 0.0F, 47.0F, 0.0F, 1.0F, 49.0F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject2);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject1 = c.instancePaint(localPaint1, paramVarArgs);
      localObject2 = c.instancePath(paramVarArgs);
      ((Path)localObject2).moveTo(24.15F, 5.27F);
      ((Path)localObject2).cubicTo(26.540001F, 3.4F, 29.02F, 1.65F, 31.639999F, 0.12F);
      ((Path)localObject2).cubicTo(36.169998F, 6.37F, 40.34F, 12.87F, 45.040001F, 18.99F);
      ((Path)localObject2).cubicTo(58.34F, 19.049999F, 71.650002F, 18.93F, 84.959999F, 19.030001F);
      ((Path)localObject2).cubicTo(85.050003F, 23.01F, 85.050003F, 27.0F, 84.949997F, 30.98F);
      ((Path)localObject2).cubicTo(56.98F, 31.01F, 29.01F, 31.02F, 1.04F, 30.98F);
      ((Path)localObject2).cubicTo(0.95F, 27.0F, 0.95F, 23.02F, 1.03F, 19.040001F);
      ((Path)localObject2).cubicTo(11.83F, 18.9F, 22.639999F, 19.110001F, 33.439999F, 18.950001F);
      ((Path)localObject2).cubicTo(30.57F, 14.24F, 26.98F, 10.01F, 24.15F, 5.27F);
      ((Path)localObject2).lineTo(24.15F, 5.27F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(41.299999F, 21.370001F);
      ((Path)localObject2).cubicTo(38.599998F, 22.51F, 38.189999F, 26.700001F, 40.709999F, 28.26F);
      ((Path)localObject2).cubicTo(43.139999F, 30.200001F, 47.200001F, 28.110001F, 46.98F, 24.99F);
      ((Path)localObject2).cubicTo(47.130001F, 22.17F, 43.790001F, 20.1F, 41.299999F, 21.370001F);
      ((Path)localObject2).lineTo(41.299999F, 21.370001F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 2);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.save();
      localObject1 = c.instancePaint(localPaint1, paramVarArgs);
      localObject2 = c.instancePath(paramVarArgs);
      ((Path)localObject2).moveTo(5.71F, 37.040001F);
      ((Path)localObject2).cubicTo(30.57F, 36.970001F, 55.439999F, 36.970001F, 80.300003F, 37.040001F);
      ((Path)localObject2).cubicTo(79.260002F, 50.349998F, 77.779999F, 63.630001F, 76.620003F, 76.93F);
      ((Path)localObject2).cubicTo(76.540001F, 79.099998F, 75.800003F, 82.099998F, 73.040001F, 81.910004F);
      ((Path)localObject2).cubicTo(54.040001F, 82.150002F, 35.02F, 81.889999F, 16.01F, 82.040001F);
      ((Path)localObject2).cubicTo(14.1F, 81.849998F, 11.64F, 82.419998F, 10.3F, 80.68F);
      ((Path)localObject2).cubicTo(9.4F, 78.970001F, 9.45F, 76.970001F, 9.2F, 75.110001F);
      ((Path)localObject2).cubicTo(8.13F, 62.41F, 6.65F, 49.740002F, 5.71F, 37.040001F);
      ((Path)localObject2).lineTo(5.71F, 37.040001F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(18.02F, 48.049999F);
      ((Path)localObject2).cubicTo(17.950001F, 51.02F, 17.950001F, 53.990002F, 18.040001F, 56.959999F);
      ((Path)localObject2).cubicTo(21.68F, 57.049999F, 25.32F, 57.049999F, 28.950001F, 56.970001F);
      ((Path)localObject2).cubicTo(29.049999F, 53.990002F, 29.049999F, 51.009998F, 28.959999F, 48.029999F);
      ((Path)localObject2).cubicTo(25.309999F, 47.939999F, 21.67F, 47.950001F, 18.02F, 48.049999F);
      ((Path)localObject2).lineTo(18.02F, 48.049999F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(38.029999F, 48.040001F);
      ((Path)localObject2).cubicTo(37.950001F, 51.02F, 37.950001F, 53.990002F, 38.040001F, 56.970001F);
      ((Path)localObject2).cubicTo(41.68F, 57.049999F, 45.32F, 57.049999F, 48.970001F, 56.959999F);
      ((Path)localObject2).cubicTo(49.049999F, 53.98F, 49.049999F, 51.009998F, 48.959999F, 48.040001F);
      ((Path)localObject2).cubicTo(45.32F, 47.950001F, 41.669998F, 47.950001F, 38.029999F, 48.040001F);
      ((Path)localObject2).lineTo(38.029999F, 48.040001F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(58.049999F, 48.029999F);
      ((Path)localObject2).cubicTo(57.950001F, 51.009998F, 57.950001F, 53.98F, 58.029999F, 56.959999F);
      ((Path)localObject2).cubicTo(61.68F, 57.049999F, 65.32F, 57.049999F, 68.959999F, 56.959999F);
      ((Path)localObject2).cubicTo(69.050003F, 53.990002F, 69.050003F, 51.02F, 68.980003F, 48.049999F);
      ((Path)localObject2).cubicTo(65.330002F, 47.950001F, 61.689999F, 47.939999F, 58.049999F, 48.029999F);
      ((Path)localObject2).lineTo(58.049999F, 48.029999F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(18.040001F, 63.040001F);
      ((Path)localObject2).cubicTo(17.950001F, 66.010002F, 17.950001F, 68.980003F, 18.030001F, 71.949997F);
      ((Path)localObject2).cubicTo(21.68F, 72.050003F, 25.33F, 72.050003F, 28.98F, 71.949997F);
      ((Path)localObject2).cubicTo(29.049999F, 68.980003F, 29.040001F, 66.0F, 28.959999F, 63.029999F);
      ((Path)localObject2).cubicTo(25.32F, 62.950001F, 21.68F, 62.950001F, 18.040001F, 63.040001F);
      ((Path)localObject2).lineTo(18.040001F, 63.040001F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(38.02F, 63.049999F);
      ((Path)localObject2).cubicTo(37.950001F, 66.019997F, 37.950001F, 68.980003F, 38.029999F, 71.949997F);
      ((Path)localObject2).cubicTo(41.669998F, 72.050003F, 45.32F, 72.050003F, 48.959999F, 71.959999F);
      ((Path)localObject2).cubicTo(49.049999F, 68.989998F, 49.049999F, 66.010002F, 48.950001F, 63.029999F);
      ((Path)localObject2).cubicTo(45.310001F, 62.939999F, 41.66F, 62.950001F, 38.02F, 63.049999F);
      ((Path)localObject2).lineTo(38.02F, 63.049999F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(58.02F, 63.049999F);
      ((Path)localObject2).cubicTo(57.939999F, 66.029999F, 57.959999F, 69.0F, 58.049999F, 71.980003F);
      ((Path)localObject2).cubicTo(61.68F, 72.050003F, 65.309998F, 72.050003F, 68.940002F, 71.980003F);
      ((Path)localObject2).cubicTo(69.040001F, 69.0F, 69.050003F, 66.010002F, 68.959999F, 63.029999F);
      ((Path)localObject2).cubicTo(65.309998F, 62.939999F, 61.669998F, 62.950001F, 58.02F, 63.049999F);
      ((Path)localObject2).lineTo(58.02F, 63.049999F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 2);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.mall_order_trade_empty_icon
 * JD-Core Version:    0.7.0.1
 */