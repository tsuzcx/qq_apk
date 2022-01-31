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

public final class aiy
  extends c
{
  private final int height = 180;
  private final int width = 180;
  
  protected final int b(int paramInt, Object... paramVarArgs)
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
      c.f(paramVarArgs);
      c.e(paramVarArgs);
      Paint localPaint = c.i(paramVarArgs);
      localPaint.setFlags(385);
      localPaint.setStyle(Paint.Style.FILL);
      Object localObject = c.i(paramVarArgs);
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
      localCanvas.saveLayerAlpha(null, 179, 4);
      localCanvas.save();
      localObject = c.a(localPaint, paramVarArgs);
      Path localPath = c.j(paramVarArgs);
      localPath.moveTo(87.279999F, 0.0F);
      localPath.lineTo(92.510002F, 0.0F);
      localPath.cubicTo(113.57F, 0.61F, 134.34F, 8.79F, 149.99001F, 22.93F);
      localPath.cubicTo(168.12F, 38.950001F, 179.11F, 62.560001F, 180.0F, 86.720001F);
      localPath.lineTo(180.0F, 92.68F);
      localPath.cubicTo(179.38F, 113.25F, 171.50999F, 133.48F, 157.98F, 148.99001F);
      localPath.cubicTo(141.78999F, 167.8F, 117.59F, 179.28F, 92.779999F, 180.0F);
      localPath.lineTo(87.529999F, 180.0F);
      localPath.cubicTo(66.650002F, 179.42F, 46.09F, 171.37F, 30.469999F, 157.49001F);
      localPath.cubicTo(12.08F, 141.44F, 0.89F, 117.65F, 0.0F, 93.269997F);
      localPath.lineTo(0.0F, 87.279999F);
      localPath.cubicTo(0.7F, 63.650002F, 11.08F, 40.48F, 28.42F, 24.379999F);
      localPath.cubicTo(44.209999F, 9.43F, 65.559998F, 0.68F, 87.279999F, 0.0F);
      localPath.lineTo(87.279999F, 0.0F);
      localPath.close();
      localPath.moveTo(78.540001F, 6.79F);
      localPath.cubicTo(52.900002F, 10.12F, 29.4F, 26.190001F, 16.83F, 48.75F);
      localPath.cubicTo(5.72F, 68.220001F, 3.03F, 92.220001F, 9.41F, 113.7F);
      localPath.cubicTo(14.51F, 131.23F, 25.57F, 146.95F, 40.32F, 157.72F);
      localPath.cubicTo(54.299999F, 168.06F, 71.589996F, 173.82001F, 88.980003F, 173.98F);
      localPath.cubicTo(107.05F, 174.25F, 125.16F, 168.48F, 139.67999F, 157.72F);
      localPath.cubicTo(153.56F, 147.57001F, 164.19F, 133.06F, 169.63F, 116.75F);
      localPath.cubicTo(176.10001F, 97.620003F, 175.35001F, 76.150002F, 167.48F, 57.540001F);
      localPath.cubicTo(160.07001F, 39.759998F, 146.32001F, 24.719999F, 129.28F, 15.75F);
      localPath.cubicTo(113.87F, 7.52F, 95.830002F, 4.4F, 78.540001F, 6.79F);
      localPath.lineTo(78.540001F, 6.79F);
      localPath.close();
      WeChatSVGRenderC2Java.setFillType(localPath, 2);
      localCanvas.drawPath(localPath, (Paint)localObject);
      localCanvas.restore();
      localCanvas.save();
      localPaint = c.a(localPaint, paramVarArgs);
      localObject = c.j(paramVarArgs);
      ((Path)localObject).moveTo(66.010002F, 49.0F);
      ((Path)localObject).cubicTo(88.669998F, 62.68F, 111.34F, 76.330002F, 134.0F, 90.010002F);
      ((Path)localObject).cubicTo(111.33F, 103.67F, 88.669998F, 117.33F, 66.010002F, 131.0F);
      ((Path)localObject).cubicTo(66.0F, 103.67F, 66.0F, 76.339996F, 66.010002F, 49.0F);
      ((Path)localObject).lineTo(66.010002F, 49.0F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 2);
      localCanvas.drawPath((Path)localObject, localPaint);
      localCanvas.restore();
      localCanvas.restore();
      c.h(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.aiy
 * JD-Core Version:    0.7.0.1
 */