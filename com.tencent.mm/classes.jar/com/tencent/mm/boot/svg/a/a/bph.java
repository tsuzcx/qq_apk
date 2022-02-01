package com.tencent.mm.boot.svg.a.a;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;

public final class bph
  extends c
{
  private final int height = 120;
  private final int width = 120;
  
  public final int a(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 120;
      return 120;
      Canvas localCanvas = (Canvas)paramVarArgs[0];
      paramVarArgs = (Looper)paramVarArgs[1];
      c.j(paramVarArgs);
      c.i(paramVarArgs);
      Paint localPaint = c.m(paramVarArgs);
      localPaint.setFlags(385);
      localPaint.setStyle(Paint.Style.FILL);
      Object localObject = c.m(paramVarArgs);
      ((Paint)localObject).setFlags(385);
      ((Paint)localObject).setStyle(Paint.Style.STROKE);
      localPaint.setColor(-16777216);
      ((Paint)localObject).setStrokeWidth(1.0F);
      ((Paint)localObject).setStrokeCap(Paint.Cap.BUTT);
      ((Paint)localObject).setStrokeJoin(Paint.Join.MITER);
      ((Paint)localObject).setStrokeMiter(4.0F);
      ((Paint)localObject).setPathEffect(null);
      c.a((Paint)localObject, paramVarArgs).setStrokeWidth(1.0F);
      localPaint = c.a(localPaint, paramVarArgs);
      localPaint.setColor(-1);
      localCanvas.saveLayerAlpha(null, 192, 31);
      localCanvas.save();
      localObject = c.a(localPaint, paramVarArgs);
      Path localPath = c.n(paramVarArgs);
      localPath.moveTo(57.639999F, 0.0F);
      localPath.lineTo(62.279999F, 0.0F);
      localPath.cubicTo(76.760002F, 0.59F, 90.959999F, 6.52F, 101.4F, 16.59F);
      localPath.cubicTo(112.61F, 27.16F, 119.33F, 42.169998F, 120.0F, 57.540001F);
      localPath.lineTo(120.0F, 62.43F);
      localPath.cubicTo(119.34F, 77.550003F, 112.85F, 92.349998F, 101.95F, 102.89F);
      localPath.cubicTo(91.57F, 113.17F, 77.330002F, 119.24F, 62.779999F, 120.0F);
      localPath.lineTo(57.650002F, 120.0F);
      localPath.cubicTo(42.48F, 119.36F, 27.639999F, 112.85F, 17.09F, 101.92F);
      localPath.cubicTo(6.78F, 91.480003F, 0.68F, 77.160004F, 0.0F, 62.529999F);
      localPath.lineTo(0.0F, 57.619999F);
      localPath.cubicTo(0.63F, 42.939999F, 6.74F, 28.559999F, 17.08F, 18.09F);
      localPath.cubicTo(27.629999F, 7.16F, 42.470001F, 0.64F, 57.639999F, 0.0F);
      localPath.lineTo(57.639999F, 0.0F);
      localPath.close();
      localPath.moveTo(51.509998F, 4.65F);
      localPath.cubicTo(36.049999F, 6.93F, 21.799999F, 16.1F, 13.25F, 29.18F);
      localPath.cubicTo(4.8F, 41.830002F, 1.96F, 58.0F, 5.48F, 72.790001F);
      localPath.cubicTo(8.55F, 86.139999F, 16.780001F, 98.190002F, 28.040001F, 105.97F);
      localPath.cubicTo(39.279999F, 113.88F, 53.5F, 117.33F, 67.120003F, 115.54F);
      localPath.cubicTo(82.629997F, 113.66F, 97.089996F, 104.84F, 105.96F, 91.989998F);
      localPath.cubicTo(114.35F, 80.089996F, 117.7F, 64.82F, 115.18F, 50.48F);
      localPath.cubicTo(112.74F, 35.869999F, 104.15F, 22.440001F, 91.970001F, 14.03F);
      localPath.cubicTo(80.349998F, 5.86F, 65.540001F, 2.46F, 51.509998F, 4.65F);
      localPath.lineTo(51.509998F, 4.65F);
      localPath.close();
      WeChatSVGRenderC2Java.setFillType(localPath, 2);
      localCanvas.drawPath(localPath, (Paint)localObject);
      localCanvas.restore();
      localCanvas.save();
      localPaint = c.a(localPaint, paramVarArgs);
      localObject = c.n(paramVarArgs);
      ((Path)localObject).moveTo(42.009998F, 32.0F);
      ((Path)localObject).cubicTo(57.330002F, 41.349998F, 72.669998F, 50.66F, 87.989998F, 60.0F);
      ((Path)localObject).cubicTo(72.669998F, 69.339996F, 57.34F, 78.669998F, 42.009998F, 87.989998F);
      ((Path)localObject).cubicTo(42.0F, 69.330002F, 41.990002F, 50.669998F, 42.009998F, 32.0F);
      ((Path)localObject).lineTo(42.009998F, 32.0F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 2);
      localCanvas.drawPath((Path)localObject, localPaint);
      localCanvas.restore();
      localCanvas.restore();
      c.l(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.bph
 * JD-Core Version:    0.7.0.1
 */