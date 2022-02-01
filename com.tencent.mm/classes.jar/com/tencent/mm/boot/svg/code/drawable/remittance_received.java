package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;

public class remittance_received
  extends c
{
  private final int height = 270;
  private final int width = 270;
  
  public int doCommand(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 270;
      return 270;
      Canvas localCanvas = (Canvas)paramVarArgs[0];
      paramVarArgs = (Looper)paramVarArgs[1];
      c.instanceMatrix(paramVarArgs);
      c.instanceMatrixArray(paramVarArgs);
      Paint localPaint = c.instancePaint(paramVarArgs);
      localPaint.setFlags(385);
      localPaint.setStyle(Paint.Style.FILL);
      Object localObject = c.instancePaint(paramVarArgs);
      ((Paint)localObject).setFlags(385);
      ((Paint)localObject).setStyle(Paint.Style.STROKE);
      localPaint.setColor(-16777216);
      ((Paint)localObject).setStrokeWidth(1.0F);
      ((Paint)localObject).setStrokeCap(Paint.Cap.BUTT);
      ((Paint)localObject).setStrokeJoin(Paint.Join.MITER);
      ((Paint)localObject).setStrokeMiter(4.0F);
      ((Paint)localObject).setPathEffect(null);
      c.instancePaint((Paint)localObject, paramVarArgs).setStrokeWidth(1.0F);
      localPaint = c.instancePaint(localPaint, paramVarArgs);
      localPaint.setColor(-12601288);
      localCanvas.save();
      localPaint = c.instancePaint(localPaint, paramVarArgs);
      localObject = c.instancePath(paramVarArgs);
      ((Path)localObject).moveTo(131.16F, 0.0F);
      ((Path)localObject).lineTo(138.59F, 0.0F);
      ((Path)localObject).cubicTo(169.69F, 0.83F, 200.36F, 12.7F, 223.71001F, 33.279999F);
      ((Path)localObject).cubicTo(251.77F, 57.439999F, 268.82999F, 93.599998F, 270.0F, 130.59F);
      ((Path)localObject).lineTo(270.0F, 137.53F);
      ((Path)localObject).cubicTo(269.48001F, 168.53F, 257.85999F, 199.14999F, 237.66F, 222.67F);
      ((Path)localObject).cubicTo(213.11F, 251.69F, 175.86F, 269.39001F, 137.83F, 270.0F);
      ((Path)localObject).lineTo(132.41F, 270.0F);
      ((Path)localObject).cubicTo(106.69F, 269.5F, 81.139999F, 261.54999F, 59.82F, 247.12F);
      ((Path)localObject).cubicTo(35.240002F, 230.72F, 16.33F, 205.99001F, 7.01F, 177.95F);
      ((Path)localObject).cubicTo(2.53F, 164.82001F, 0.31F, 150.97F, 0.0F, 137.13F);
      ((Path)localObject).lineTo(0.0F, 133.07001F);
      ((Path)localObject).cubicTo(0.36F, 94.510002F, 18.290001F, 56.599998F, 47.889999F, 31.9F);
      ((Path)localObject).cubicTo(70.959999F, 12.2F, 100.85F, 0.89F, 131.16F, 0.0F);
      ((Path)localObject).lineTo(131.16F, 0.0F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(203.02F, 82.050003F);
      ((Path)localObject).cubicTo(171.35001F, 113.7F, 139.71001F, 145.38F, 108.03F, 177.02F);
      ((Path)localObject).cubicTo(95.980003F, 165.08F, 84.029999F, 153.03F, 72.010002F, 141.05F);
      ((Path)localObject).cubicTo(71.220001F, 140.00999F, 69.440002F, 139.34F, 68.410004F, 140.39F);
      ((Path)localObject).cubicTo(65.919998F, 142.64999F, 63.599998F, 145.10001F, 61.23F, 147.49001F);
      ((Path)localObject).cubicTo(59.98F, 148.45F, 60.299999F, 150.46001F, 61.490002F, 151.33F);
      ((Path)localObject).cubicTo(76.330002F, 166.21001F, 91.18F, 181.09F, 106.08F, 195.91F);
      ((Path)localObject).cubicTo(107.0F, 197.16F, 108.96F, 197.19F, 109.91F, 195.94F);
      ((Path)localObject).cubicTo(144.3F, 161.64999F, 178.59F, 127.26F, 212.96001F, 92.940002F);
      ((Path)localObject).cubicTo(214.03F, 91.970001F, 215.05F, 90.769997F, 214.44F, 89.230003F);
      ((Path)localObject).cubicTo(211.96001F, 86.510002F, 209.35001F, 83.910004F, 206.66F, 81.410004F);
      ((Path)localObject).cubicTo(205.59F, 80.260002F, 203.84F, 81.019997F, 203.02F, 82.050003F);
      ((Path)localObject).lineTo(203.02F, 82.050003F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 2);
      localCanvas.drawPath((Path)localObject, localPaint);
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.remittance_received
 * JD-Core Version:    0.7.0.1
 */