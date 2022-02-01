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

public final class bsw
  extends c
{
  private final int height = 708;
  private final int width = 1080;
  
  public final int a(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 1080;
      return 708;
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
      localPaint2.setColor(-14605789);
      localCanvas.save();
      Object localObject3 = c.a(localPaint2, paramVarArgs);
      Path localPath = c.n(paramVarArgs);
      localPath.moveTo(0.0F, 0.0F);
      localPath.lineTo(1080.0F, 0.0F);
      localPath.lineTo(1080.0F, 708.0F);
      localPath.lineTo(0.0F, 708.0F);
      localPath.lineTo(0.0F, 0.0F);
      localPath.lineTo(0.0F, 0.0F);
      localPath.close();
      WeChatSVGRenderC2Java.setFillType(localPath, 2);
      localCanvas.drawPath(localPath, (Paint)localObject3);
      localCanvas.restore();
      localCanvas.save();
      localPaint2 = c.a(localPaint2, paramVarArgs);
      localObject3 = c.n(paramVarArgs);
      ((Path)localObject3).moveTo(410.17999F, 230.14999F);
      ((Path)localObject3).cubicTo(483.76001F, 229.8F, 557.35999F, 230.09F, 630.96002F, 230.0F);
      ((Path)localObject3).cubicTo(644.23999F, 230.16F, 657.53998F, 229.7F, 670.82001F, 230.17999F);
      ((Path)localObject3).cubicTo(671.31F, 246.78F, 670.84003F, 263.41F, 671.0F, 280.01999F);
      ((Path)localObject3).cubicTo(670.90997F, 315.04999F, 671.16998F, 350.09F, 670.87F, 385.10999F);
      ((Path)localObject3).cubicTo(660.31F, 369.45001F, 649.44F, 353.20999F, 633.51001F, 342.48999F);
      ((Path)localObject3).cubicTo(626.90997F, 338.22F, 618.79999F, 334.48999F, 610.82001F, 336.70999F);
      ((Path)localObject3).cubicTo(603.40002F, 338.92999F, 596.76001F, 343.09F, 590.39001F, 347.37F);
      ((Path)localObject3).cubicTo(587.12F, 349.67001F, 583.59003F, 351.70999F, 581.01001F, 354.82999F);
      ((Path)localObject3).cubicTo(586.59003F, 369.82999F, 595.29999F, 383.45001F, 604.40002F, 396.54001F);
      ((Path)localObject3).cubicTo(605.84003F, 398.60999F, 607.12F, 400.79001F, 608.29999F, 403.03F);
      ((Path)localObject3).cubicTo(601.09998F, 399.04999F, 595.96997F, 392.42999F, 590.32001F, 386.64001F);
      ((Path)localObject3).cubicTo(584.72998F, 379.94F, 578.84998F, 373.48999F, 573.34003F, 366.73999F);
      ((Path)localObject3).cubicTo(562.19F, 351.10001F, 551.17999F, 335.14001F, 537.27002F, 321.76001F);
      ((Path)localObject3).cubicTo(528.84998F, 313.73999F, 519.15002F, 306.5F, 507.82999F, 303.25F);
      ((Path)localObject3).cubicTo(497.41F, 300.29001F, 486.29999F, 303.04999F, 476.95001F, 308.0F);
      ((Path)localObject3).cubicTo(463.78F, 314.85999F, 452.48001F, 324.70999F, 441.81F, 334.92999F);
      ((Path)localObject3).cubicTo(433.54999F, 343.67999F, 425.38F, 352.54999F, 418.10001F, 362.16F);
      ((Path)localObject3).cubicTo(415.51001F, 365.54001F, 413.06F, 369.06F, 410.20001F, 372.23001F);
      ((Path)localObject3).cubicTo(409.72F, 350.14999F, 410.14999F, 328.04001F, 410.0F, 305.95001F);
      ((Path)localObject3).cubicTo(410.13F, 280.67999F, 409.73999F, 255.39999F, 410.17999F, 230.14999F);
      ((Path)localObject3).lineTo(410.17999F, 230.14999F);
      ((Path)localObject3).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject3, 2);
      localCanvas.drawPath((Path)localObject3, localPaint2);
      localCanvas.restore();
      localCanvas.save();
      localPaint1 = c.a(localPaint1, paramVarArgs);
      localPaint1.setColor(-13947602);
      localObject2 = c.a((float[])localObject2, 1.0F, 0.0F, 379.0F, 0.0F, 1.0F, 199.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject2);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject1 = c.a(localPaint1, paramVarArgs);
      localObject2 = c.n(paramVarArgs);
      ((Path)localObject2).moveTo(8.33F, 1.44F);
      ((Path)localObject2).cubicTo(9.51F, 1.18F, 10.71F, 1.03F, 11.93F, 1.0F);
      ((Path)localObject2).cubicTo(108.28F, 0.99F, 204.63F, 1.01F, 300.98001F, 0.99F);
      ((Path)localObject2).cubicTo(305.76999F, 1.08F, 310.67001F, 0.48F, 315.35999F, 1.66F);
      ((Path)localObject2).cubicTo(319.73999F, 2.95F, 322.20001F, 7.57F, 322.0F, 11.95F);
      ((Path)localObject2).cubicTo(322.01999F, 90.970001F, 321.95999F, 170.00999F, 322.03F, 249.03F);
      ((Path)localObject2).cubicTo(321.98001F, 252.00999F, 321.70999F, 255.3F, 319.54999F, 257.57999F);
      ((Path)localObject2).cubicTo(317.47F, 260.09F, 314.14001F, 260.98999F, 311.0F, 260.98999F);
      ((Path)localObject2).cubicTo(213.67999F, 261.03F, 116.35F, 260.95001F, 19.030001F, 261.03F);
      ((Path)localObject2).cubicTo(14.16F, 260.82001F, 8.46F, 261.98999F, 4.42F, 258.56F);
      ((Path)localObject2).cubicTo(1.57F, 256.28F, 0.96F, 252.44F, 0.98F, 249.0F);
      ((Path)localObject2).cubicTo(1.01F, 169.99001F, 1.0F, 90.980003F, 1.0F, 11.98F);
      ((Path)localObject2).cubicTo(0.74F, 7.33F, 3.6F, 2.48F, 8.33F, 1.44F);
      ((Path)localObject2).lineTo(8.33F, 1.44F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(31.18F, 31.15F);
      ((Path)localObject2).cubicTo(30.74F, 56.400002F, 31.129999F, 81.68F, 31.0F, 106.95F);
      ((Path)localObject2).cubicTo(31.15F, 129.03999F, 30.719999F, 151.14999F, 31.200001F, 173.23F);
      ((Path)localObject2).cubicTo(34.060001F, 170.06F, 36.509998F, 166.53999F, 39.099998F, 163.16F);
      ((Path)localObject2).cubicTo(46.380001F, 153.55F, 54.549999F, 144.67999F, 62.810001F, 135.92999F);
      ((Path)localObject2).cubicTo(73.480003F, 125.71F, 84.779999F, 115.86F, 97.949997F, 109.0F);
      ((Path)localObject2).cubicTo(107.3F, 104.05F, 118.41F, 101.29F, 128.83F, 104.25F);
      ((Path)localObject2).cubicTo(140.14999F, 107.5F, 149.85001F, 114.74F, 158.27F, 122.76F);
      ((Path)localObject2).cubicTo(172.17999F, 136.14F, 183.19F, 152.10001F, 194.34F, 167.74001F);
      ((Path)localObject2).cubicTo(199.85001F, 174.49001F, 205.73F, 180.94F, 211.32001F, 187.64F);
      ((Path)localObject2).cubicTo(216.97F, 193.42999F, 222.10001F, 200.05F, 229.3F, 204.03F);
      ((Path)localObject2).cubicTo(228.12F, 201.78999F, 226.84F, 199.61F, 225.39999F, 197.53999F);
      ((Path)localObject2).cubicTo(216.3F, 184.45F, 207.59F, 170.83F, 202.00999F, 155.83F);
      ((Path)localObject2).cubicTo(204.59F, 152.71001F, 208.12F, 150.67F, 211.39F, 148.37F);
      ((Path)localObject2).cubicTo(217.75999F, 144.09F, 224.39999F, 139.92999F, 231.82001F, 137.71001F);
      ((Path)localObject2).cubicTo(239.8F, 135.49001F, 247.91F, 139.22F, 254.50999F, 143.49001F);
      ((Path)localObject2).cubicTo(270.44F, 154.21001F, 281.31F, 170.45F, 291.87F, 186.11F);
      ((Path)localObject2).cubicTo(292.17001F, 151.09F, 291.91F, 116.05F, 292.0F, 81.019997F);
      ((Path)localObject2).cubicTo(291.84F, 64.410004F, 292.31F, 47.779999F, 291.82001F, 31.18F);
      ((Path)localObject2).cubicTo(278.54001F, 30.700001F, 265.23999F, 31.16F, 251.96001F, 31.0F);
      ((Path)localObject2).cubicTo(178.36F, 31.09F, 104.76F, 30.799999F, 31.18F, 31.15F);
      ((Path)localObject2).lineTo(31.18F, 31.15F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 2);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.restore();
      c.l(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.bsw
 * JD-Core Version:    0.7.0.1
 */