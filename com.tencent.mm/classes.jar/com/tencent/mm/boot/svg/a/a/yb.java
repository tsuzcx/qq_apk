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

public final class yb
  extends c
{
  private final int height = 224;
  private final int width = 224;
  
  public final int a(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 224;
      return 224;
      Canvas localCanvas = (Canvas)paramVarArgs[0];
      paramVarArgs = (Looper)paramVarArgs[1];
      Object localObject1 = c.j(paramVarArgs);
      Object localObject3 = c.i(paramVarArgs);
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
      localObject3 = c.a((float[])localObject3, 1.0F, 0.0F, 25.0F, 0.0F, 1.0F, 60.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject3);
      localCanvas.concat((Matrix)localObject1);
      localPaint = c.a((Paint)localObject2, paramVarArgs);
      localPaint.setColor(-1749411);
      localCanvas.save();
      localPaint = c.a(localPaint, paramVarArgs);
      Path localPath = c.n(paramVarArgs);
      localPath.moveTo(78.050003F, 2.08F);
      localPath.cubicTo(92.32F, -2.34F, 108.61F, 0.42F, 120.54F, 9.45F);
      localPath.cubicTo(131.03F, 17.08F, 138.02F, 29.15F, 139.66F, 42.009998F);
      localPath.cubicTo(150.08F, 40.990002F, 160.89999F, 45.34F, 167.32001F, 53.669998F);
      localPath.cubicTo(174.74001F, 62.810001F, 176.09F, 76.300003F, 170.66F, 86.739998F);
      localPath.cubicTo(165.60001F, 96.970001F, 154.50999F, 103.83F, 143.08F, 103.73F);
      localPath.cubicTo(107.72F, 103.72F, 72.349998F, 103.76F, 36.990002F, 103.71F);
      localPath.cubicTo(21.48F, 103.54F, 6.85F, 92.760002F, 2.02F, 78.029999F);
      localPath.cubicTo(-2.32F, 65.620003F, 0.47F, 51.060001F, 9.16F, 41.18F);
      localPath.cubicTo(18.370001F, 30.18F, 33.970001F, 25.52F, 47.790001F, 29.139999F);
      localPath.cubicTo(53.349998F, 16.309999F, 64.620003F, 6.08F, 78.050003F, 2.08F);
      localPath.lineTo(78.050003F, 2.08F);
      localPath.close();
      localPath.moveTo(88.290001F, 34.290001F);
      localPath.cubicTo(86.160004F, 35.27F, 85.900002F, 37.849998F, 86.040001F, 39.91F);
      localPath.cubicTo(86.449997F, 50.299999F, 86.589996F, 60.700001F, 87.07F, 71.080002F);
      localPath.cubicTo(87.029999F, 73.459999F, 90.379997F, 74.739998F, 92.010002F, 73.029999F);
      localPath.cubicTo(93.220001F, 72.07F, 92.900002F, 70.400002F, 93.07F, 69.059998F);
      localPath.cubicTo(93.32F, 58.68F, 93.769997F, 48.310001F, 93.959999F, 37.93F);
      localPath.cubicTo(94.279999F, 34.98F, 90.809998F, 32.98F, 88.290001F, 34.290001F);
      localPath.lineTo(88.290001F, 34.290001F);
      localPath.close();
      localPath.moveTo(88.379997F, 80.230003F);
      localPath.cubicTo(85.150002F, 82.089996F, 88.199997F, 87.309998F, 91.360001F, 85.43F);
      localPath.cubicTo(95.050003F, 83.760002F, 91.720001F, 77.959999F, 88.379997F, 80.230003F);
      localPath.lineTo(88.379997F, 80.230003F);
      localPath.close();
      WeChatSVGRenderC2Java.setFillType(localPath, 2);
      localCanvas.drawPath(localPath, localPaint);
      localCanvas.restore();
      localCanvas.save();
      localObject2 = c.a((Paint)localObject2, paramVarArgs);
      ((Paint)localObject2).setColor(-1);
      localObject3 = c.a((float[])localObject3, 1.0F, 0.0F, 86.0F, 0.0F, 1.0F, 33.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject3);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject1 = c.a((Paint)localObject2, paramVarArgs);
      localObject3 = c.n(paramVarArgs);
      ((Path)localObject3).moveTo(2.29F, 1.29F);
      ((Path)localObject3).cubicTo(4.81F, -0.02F, 8.28F, 1.98F, 7.96F, 4.93F);
      ((Path)localObject3).cubicTo(7.77F, 15.31F, 7.32F, 25.68F, 7.07F, 36.060001F);
      ((Path)localObject3).cubicTo(6.9F, 37.400002F, 7.22F, 39.07F, 6.01F, 40.029999F);
      ((Path)localObject3).cubicTo(4.38F, 41.740002F, 1.03F, 40.459999F, 1.07F, 38.080002F);
      ((Path)localObject3).cubicTo(0.59F, 27.700001F, 0.45F, 17.299999F, 0.04F, 6.91F);
      ((Path)localObject3).cubicTo(-0.1F, 4.85F, 0.16F, 2.27F, 2.29F, 1.29F);
      ((Path)localObject3).lineTo(2.29F, 1.29F);
      ((Path)localObject3).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject3, 2);
      localCanvas.drawPath((Path)localObject3, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.save();
      localObject1 = c.a((Paint)localObject2, paramVarArgs);
      localObject2 = c.n(paramVarArgs);
      ((Path)localObject2).moveTo(2.38F, 47.23F);
      ((Path)localObject2).cubicTo(5.72F, 44.959999F, 9.05F, 50.759998F, 5.36F, 52.43F);
      ((Path)localObject2).cubicTo(2.2F, 54.310001F, -0.85F, 49.09F, 2.38F, 47.23F);
      ((Path)localObject2).lineTo(2.38F, 47.23F);
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
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.yb
 * JD-Core Version:    0.7.0.1
 */