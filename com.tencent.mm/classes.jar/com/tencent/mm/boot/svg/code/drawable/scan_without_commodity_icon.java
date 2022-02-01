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

public class scan_without_commodity_icon
  extends c
{
  private final int height = 260;
  private final int width = 260;
  
  public int doCommand(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 260;
      return 260;
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
      localPaint2.setColor(-1);
      localCanvas.save();
      Object localObject3 = c.instancePaint(localPaint2, paramVarArgs);
      Path localPath = c.instancePath(paramVarArgs);
      localPath.moveTo(0.0F, 0.0F);
      localPath.lineTo(260.0F, 0.0F);
      localPath.lineTo(260.0F, 260.0F);
      localPath.lineTo(0.0F, 260.0F);
      localPath.lineTo(0.0F, 0.0F);
      localPath.lineTo(0.0F, 0.0F);
      localPath.close();
      localPath.moveTo(98.019997F, 72.029999F);
      localPath.cubicTo(85.5F, 76.809998F, 75.400002F, 87.309998F, 70.879997F, 99.900002F);
      localPath.cubicTo(66.489998F, 111.86F, 67.199997F, 125.65F, 73.080002F, 136.99001F);
      localPath.cubicTo(79.019997F, 148.74001F, 90.290001F, 157.60001F, 103.09F, 160.64F);
      localPath.cubicTo(115.81F, 163.78F, 129.85001F, 161.25999F, 140.53999F, 153.64999F);
      localPath.cubicTo(142.41F, 152.25F, 144.09F, 150.58F, 146.13F, 149.41F);
      localPath.cubicTo(147.89999F, 150.37F, 149.10001F, 152.06F, 150.50999F, 153.45F);
      localPath.cubicTo(162.66F, 165.64999F, 174.87F, 177.78999F, 187.00999F, 190.00999F);
      localPath.cubicTo(188.23F, 191.37F, 190.48F, 192.71001F, 191.99001F, 190.92999F);
      localPath.cubicTo(193.72F, 189.38F, 192.36F, 187.22F, 191.00999F, 186.0F);
      localPath.cubicTo(177.32001F, 172.33F, 163.64F, 158.63F, 149.95F, 144.95F);
      localPath.cubicTo(156.94F, 135.91F, 160.7F, 124.4F, 159.85001F, 112.96F);
      localPath.cubicTo(158.95F, 96.639999F, 148.92F, 81.169998F, 134.28F, 73.860001F);
      localPath.cubicTo(123.17F, 68.160004F, 109.65F, 67.510002F, 98.019997F, 72.029999F);
      localPath.lineTo(98.019997F, 72.029999F);
      localPath.close();
      WeChatSVGRenderC2Java.setFillType(localPath, 2);
      localCanvas.drawPath(localPath, (Paint)localObject3);
      localCanvas.restore();
      localCanvas.save();
      localPaint2 = c.instancePaint(localPaint2, paramVarArgs);
      localObject3 = c.instancePath(paramVarArgs);
      ((Path)localObject3).moveTo(108.33F, 75.440002F);
      ((Path)localObject3).cubicTo(117.0F, 74.150002F, 126.1F, 75.839996F, 133.67F, 80.269997F);
      ((Path)localObject3).cubicTo(143.50999F, 85.919998F, 150.64F, 95.93F, 153.00999F, 107.01F);
      ((Path)localObject3).cubicTo(155.37F, 117.63F, 153.42F, 129.23F, 147.35001F, 138.32001F);
      ((Path)localObject3).cubicTo(142.12F, 146.27F, 133.89999F, 152.19F, 124.69F, 154.60001F);
      ((Path)localObject3).cubicTo(114.09F, 157.45F, 102.33F, 155.86F, 92.970001F, 150.09F);
      ((Path)localObject3).cubicTo(84.610001F, 145.0F, 78.279999F, 136.71001F, 75.610001F, 127.29F);
      ((Path)localObject3).cubicTo(72.129997F, 115.35F, 74.470001F, 101.89F, 81.779999F, 91.830002F);
      ((Path)localObject3).cubicTo(87.959999F, 83.110001F, 97.720001F, 76.970001F, 108.33F, 75.440002F);
      ((Path)localObject3).lineTo(108.33F, 75.440002F);
      ((Path)localObject3).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject3, 2);
      localCanvas.drawPath((Path)localObject3, localPaint2);
      localCanvas.restore();
      localCanvas.save();
      localPaint1 = c.instancePaint(localPaint1, paramVarArgs);
      localPaint1.setColor(-3552823);
      localObject2 = c.setMatrixFloatArray((float[])localObject2, 1.0F, 0.0F, 68.0F, 0.0F, 1.0F, 69.0F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject2);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject1 = c.instancePaint(localPaint1, paramVarArgs);
      localObject2 = c.instancePath(paramVarArgs);
      ((Path)localObject2).moveTo(30.02F, 3.03F);
      ((Path)localObject2).cubicTo(41.650002F, -1.49F, 55.169998F, -0.84F, 66.279999F, 4.86F);
      ((Path)localObject2).cubicTo(80.919998F, 12.17F, 90.949997F, 27.639999F, 91.849998F, 43.959999F);
      ((Path)localObject2).cubicTo(92.699997F, 55.400002F, 88.940002F, 66.910004F, 81.949997F, 75.949997F);
      ((Path)localObject2).cubicTo(95.639999F, 89.629997F, 109.32F, 103.33F, 123.01F, 117.0F);
      ((Path)localObject2).cubicTo(124.36F, 118.22F, 125.72F, 120.38F, 123.99F, 121.93F);
      ((Path)localObject2).cubicTo(122.48F, 123.71F, 120.23F, 122.37F, 119.01F, 121.01F);
      ((Path)localObject2).cubicTo(106.87F, 108.79F, 94.660004F, 96.650002F, 82.510002F, 84.449997F);
      ((Path)localObject2).cubicTo(81.099998F, 83.059998F, 79.900002F, 81.370003F, 78.129997F, 80.410004F);
      ((Path)localObject2).cubicTo(76.089996F, 81.580002F, 74.410004F, 83.25F, 72.540001F, 84.650002F);
      ((Path)localObject2).cubicTo(61.849998F, 92.260002F, 47.810001F, 94.779999F, 35.09F, 91.639999F);
      ((Path)localObject2).cubicTo(22.290001F, 88.599998F, 11.02F, 79.739998F, 5.08F, 67.989998F);
      ((Path)localObject2).cubicTo(-0.8F, 56.650002F, -1.51F, 42.860001F, 2.88F, 30.9F);
      ((Path)localObject2).cubicTo(7.4F, 18.309999F, 17.5F, 7.81F, 30.02F, 3.03F);
      ((Path)localObject2).lineTo(30.02F, 3.03F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(40.330002F, 6.44F);
      ((Path)localObject2).cubicTo(29.719999F, 7.97F, 19.959999F, 14.11F, 13.78F, 22.83F);
      ((Path)localObject2).cubicTo(6.47F, 32.889999F, 4.13F, 46.349998F, 7.61F, 58.290001F);
      ((Path)localObject2).cubicTo(10.28F, 67.709999F, 16.610001F, 76.0F, 24.969999F, 81.089996F);
      ((Path)localObject2).cubicTo(34.330002F, 86.860001F, 46.09F, 88.449997F, 56.689999F, 85.599998F);
      ((Path)localObject2).cubicTo(65.900002F, 83.190002F, 74.120003F, 77.269997F, 79.349998F, 69.32F);
      ((Path)localObject2).cubicTo(85.419998F, 60.23F, 87.370003F, 48.630001F, 85.010002F, 38.009998F);
      ((Path)localObject2).cubicTo(82.639999F, 26.93F, 75.510002F, 16.92F, 65.669998F, 11.27F);
      ((Path)localObject2).cubicTo(58.099998F, 6.84F, 49.0F, 5.15F, 40.330002F, 6.44F);
      ((Path)localObject2).lineTo(40.330002F, 6.44F);
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
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.scan_without_commodity_icon
 * JD-Core Version:    0.7.0.1
 */