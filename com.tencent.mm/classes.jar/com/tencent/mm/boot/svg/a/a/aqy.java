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

public final class aqy
  extends c
{
  private final int height = 72;
  private final int width = 72;
  
  public final int a(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 72;
      return 72;
      Canvas localCanvas = (Canvas)paramVarArgs[0];
      paramVarArgs = (Looper)paramVarArgs[1];
      c.h(paramVarArgs);
      c.g(paramVarArgs);
      Paint localPaint = c.k(paramVarArgs);
      localPaint.setFlags(385);
      localPaint.setStyle(Paint.Style.FILL);
      Object localObject = c.k(paramVarArgs);
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
      localPaint.setColor(-9276814);
      localCanvas.saveLayerAlpha(null, 128, 4);
      localCanvas.save();
      localObject = c.a(localPaint, paramVarArgs);
      Path localPath = c.l(paramVarArgs);
      localPath.moveTo(33.939999F, 0.0F);
      localPath.lineTo(37.860001F, 0.0F);
      localPath.cubicTo(45.959999F, 0.56F, 53.93F, 3.66F, 59.959999F, 9.15F);
      localPath.cubicTo(67.07F, 15.44F, 71.419998F, 24.59F, 72.0F, 34.049999F);
      localPath.lineTo(72.0F, 37.830002F);
      localPath.cubicTo(71.459999F, 47.59F, 66.849998F, 57.029999F, 59.389999F, 63.349998F);
      localPath.cubicTo(53.540001F, 68.459999F, 45.970001F, 71.349998F, 38.259998F, 72.0F);
      localPath.lineTo(34.110001F, 72.0F);
      localPath.cubicTo(25.1F, 71.449997F, 16.32F, 67.550003F, 10.09F, 60.970001F);
      localPath.cubicTo(4.16F, 54.900002F, 0.65F, 46.689999F, 0.0F, 38.25F);
      localPath.lineTo(0.0F, 34.130001F);
      localPath.cubicTo(0.55F, 24.370001F, 5.18F, 14.93F, 12.65F, 8.61F);
      localPath.cubicTo(18.549999F, 3.47F, 26.18F, 0.61F, 33.939999F, 0.0F);
      localPath.lineTo(33.939999F, 0.0F);
      localPath.close();
      localPath.moveTo(29.4F, 3.66F);
      localPath.cubicTo(23.120001F, 4.97F, 17.200001F, 8.12F, 12.68F, 12.67F);
      localPath.cubicTo(2.03F, 22.959999F, -0.12F, 40.650002F, 7.83F, 53.16F);
      localPath.cubicTo(16.0F, 67.239998F, 35.310001F, 73.150002F, 49.93F, 65.900002F);
      localPath.cubicTo(64.75F, 59.369999F, 72.739998F, 41.040001F, 67.360001F, 25.73F);
      localPath.cubicTo(62.610001F, 10.2F, 45.279999F, 0.06F, 29.4F, 3.66F);
      localPath.lineTo(29.4F, 3.66F);
      localPath.close();
      WeChatSVGRenderC2Java.setFillType(localPath, 2);
      localCanvas.drawPath(localPath, (Paint)localObject);
      localCanvas.restore();
      localCanvas.save();
      localPaint = c.a(localPaint, paramVarArgs);
      localObject = c.l(paramVarArgs);
      ((Path)localObject).moveTo(24.0F, 24.0F);
      ((Path)localObject).lineTo(48.0F, 24.0F);
      ((Path)localObject).lineTo(48.0F, 48.0F);
      ((Path)localObject).lineTo(24.0F, 48.0F);
      ((Path)localObject).lineTo(24.0F, 24.0F);
      ((Path)localObject).lineTo(24.0F, 24.0F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 2);
      localCanvas.drawPath((Path)localObject, localPaint);
      localCanvas.restore();
      localCanvas.restore();
      c.j(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.aqy
 * JD-Core Version:    0.7.0.1
 */