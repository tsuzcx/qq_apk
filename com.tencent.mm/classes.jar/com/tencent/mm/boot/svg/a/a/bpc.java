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

public final class bpc
  extends c
{
  private final int height = 260;
  private final int width = 260;
  
  public final int a(int paramInt, Object... paramVarArgs)
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
      localPaint2.setColor(-1);
      localCanvas.save();
      Object localObject3 = c.a(localPaint2, paramVarArgs);
      Path localPath = c.n(paramVarArgs);
      localPath.moveTo(0.0F, 0.0F);
      localPath.lineTo(260.0F, 0.0F);
      localPath.lineTo(260.0F, 260.0F);
      localPath.lineTo(0.0F, 260.0F);
      localPath.lineTo(0.0F, 0.0F);
      localPath.lineTo(0.0F, 0.0F);
      localPath.close();
      localPath.moveTo(59.16F, 77.160004F);
      localPath.cubicTo(57.650002F, 77.860001F, 58.16F, 79.660004F, 57.990002F, 80.980003F);
      localPath.cubicTo(58.009998F, 114.71F, 58.0F, 148.42999F, 57.990002F, 182.16F);
      localPath.cubicTo(60.860001F, 183.35001F, 64.019997F, 182.89999F, 67.040001F, 182.95F);
      localPath.cubicTo(108.35F, 182.92999F, 149.67F, 182.95F, 190.98F, 182.94F);
      localPath.cubicTo(194.25F, 182.89999F, 197.55F, 183.16F, 200.8F, 182.74001F);
      localPath.cubicTo(202.32001F, 182.12F, 201.85001F, 180.36F, 202.00999F, 179.08F);
      localPath.cubicTo(201.99001F, 148.7F, 202.00999F, 118.33F, 202.0F, 87.949997F);
      localPath.cubicTo(201.97F, 84.68F, 202.2F, 81.389999F, 201.81F, 78.139999F);
      localPath.cubicTo(201.13F, 76.620003F, 199.33F, 77.120003F, 198.02F, 76.949997F);
      localPath.cubicTo(155.00999F, 76.980003F, 112.0F, 76.959999F, 68.989998F, 76.959999F);
      localPath.cubicTo(65.709999F, 77.0F, 62.419998F, 76.760002F, 59.16F, 77.160004F);
      localPath.lineTo(59.16F, 77.160004F);
      localPath.close();
      WeChatSVGRenderC2Java.setFillType(localPath, 2);
      localCanvas.drawPath(localPath, (Paint)localObject3);
      localCanvas.restore();
      localCanvas.save();
      localPaint2 = c.a(localPaint2, paramVarArgs);
      localObject3 = c.n(paramVarArgs);
      ((Path)localObject3).moveTo(64.019997F, 82.959999F);
      ((Path)localObject3).cubicTo(108.01F, 82.93F, 152.0F, 82.93F, 195.99001F, 82.959999F);
      ((Path)localObject3).cubicTo(196.00999F, 105.99F, 196.00999F, 129.02F, 195.98F, 152.05F);
      ((Path)localObject3).cubicTo(185.97F, 142.73F, 176.02F, 133.34F, 165.99001F, 124.03F);
      ((Path)localObject3).cubicTo(159.32001F, 129.34F, 152.66F, 134.66F, 146.03F, 140.00999F);
      ((Path)localObject3).cubicTo(148.31F, 145.33F, 150.69F, 150.60001F, 152.95F, 155.92999F);
      ((Path)localObject3).cubicTo(136.60001F, 140.00999F, 120.34F, 124.0F, 104.03F, 108.04F);
      ((Path)localObject3).cubicTo(90.620003F, 121.57F, 77.419998F, 135.3F, 64.019997F, 148.84F);
      ((Path)localObject3).cubicTo(63.98F, 126.88F, 63.990002F, 104.92F, 64.019997F, 82.959999F);
      ((Path)localObject3).lineTo(64.019997F, 82.959999F);
      ((Path)localObject3).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject3, 2);
      localCanvas.drawPath((Path)localObject3, localPaint2);
      localCanvas.restore();
      localCanvas.save();
      localPaint1 = c.a(localPaint1, paramVarArgs);
      localPaint1.setColor(-3552823);
      localObject2 = c.a((float[])localObject2, 1.0F, 0.0F, 57.0F, 0.0F, 1.0F, 76.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject2);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject1 = c.a(localPaint1, paramVarArgs);
      localObject2 = c.n(paramVarArgs);
      ((Path)localObject2).moveTo(2.169591F, 1.235247F);
      ((Path)localObject2).cubicTo(5.42845F, 0.8355052F, 8.717299F, 1.07535F, 11.996151F, 1.035376F);
      ((Path)localObject2).cubicTo(54.991104F, 1.035376F, 97.986053F, 1.055363F, 140.981F, 1.025382F);
      ((Path)localObject2).cubicTo(142.29054F, 1.195272F, 144.08992F, 0.6955957F, 144.76968F, 2.214613F);
      ((Path)localObject2).cubicTo(145.15955F, 5.462513F, 144.92963F, 8.750386F, 144.95961F, 12.018272F);
      ((Path)localObject2).cubicTo(144.9696F, 42.378635F, 144.94962F, 72.729004F, 144.9696F, 103.08937F);
      ((Path)localObject2).cubicTo(144.80966F, 104.36855F, 145.27951F, 106.1274F, 143.76004F, 106.747F);
      ((Path)localObject2).cubicTo(140.51117F, 107.16673F, 137.21233F, 106.9069F, 133.94347F, 106.94688F);
      ((Path)localObject2).cubicTo(92.647926F, 106.95687F, 51.342381F, 106.93688F, 10.046834F, 106.95687F);
      ((Path)localObject2).cubicTo(7.02789F, 106.9069F, 3.868996F, 107.35661F, 1.0F, 106.16738F);
      ((Path)localObject2).cubicTo(1.009997F, 72.459183F, 1.019993F, 38.760975F, 1.0F, 5.052778F);
      ((Path)localObject2).cubicTo(1.169941F, 3.733631F, 0.6601189F, 1.934794F, 2.169591F, 1.235247F);
      ((Path)localObject2).lineTo(2.169591F, 1.235247F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(7.026381F, 7.022502F);
      ((Path)localObject2).cubicTo(6.996383F, 28.984758F, 6.986383F, 50.947014F, 7.026381F, 72.909271F);
      ((Path)localObject2).cubicTo(20.425333F, 59.367882F, 33.624302F, 45.636471F, 47.033253F, 32.10508F);
      ((Path)localObject2).cubicTo(63.341976F, 48.066719F, 79.600708F, 64.078362F, 95.949425F, 80.0F);
      ((Path)localObject2).cubicTo(93.689606F, 74.669449F, 91.309792F, 69.398911F, 89.029968F, 64.078362F);
      ((Path)localObject2).cubicTo(95.659447F, 58.727814F, 102.31893F, 53.407269F, 108.98841F, 48.096722F);
      ((Path)localObject2).cubicTo(119.01762F, 57.407681F, 128.96684F, 66.798645F, 138.97606F, 76.119598F);
      ((Path)localObject2).cubicTo(139.00606F, 53.087234F, 139.00606F, 30.054869F, 138.98607F, 7.022502F);
      ((Path)localObject2).cubicTo(94.999504F, 6.992499F, 51.012939F, 6.992499F, 7.026381F, 7.022502F);
      ((Path)localObject2).lineTo(7.026381F, 7.022502F);
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
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.bpc
 * JD-Core Version:    0.7.0.1
 */