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

public final class ajb
  extends c
{
  private final int height = 72;
  private final int width = 72;
  
  protected final int b(int paramInt, Object... paramVarArgs)
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
      localPaint.setColor(-6710887);
      localCanvas.save();
      localObject = c.a(localPaint, paramVarArgs);
      Path localPath = c.j(paramVarArgs);
      localPath.moveTo(34.0F, 0.0F);
      localPath.lineTo(37.77F, 0.0F);
      localPath.cubicTo(46.830002F, 0.56F, 55.720001F, 4.44F, 61.959999F, 11.09F);
      localPath.cubicTo(67.889999F, 17.18F, 71.410004F, 25.42F, 72.0F, 33.880001F);
      localPath.lineTo(72.0F, 37.759998F);
      localPath.cubicTo(71.519997F, 46.610001F, 67.739998F, 55.23F, 61.419998F, 61.470001F);
      localPath.cubicTo(55.299999F, 67.709999F, 46.82F, 71.339996F, 38.150002F, 72.0F);
      localPath.lineTo(34.349998F, 72.0F);
      localPath.cubicTo(25.49F, 71.519997F, 16.809999F, 67.809998F, 10.58F, 61.459999F);
      localPath.cubicTo(4.3F, 55.27F, 0.55F, 46.73F, 0.0F, 37.950001F);
      localPath.lineTo(0.0F, 34.450001F);
      localPath.cubicTo(0.43F, 24.82F, 4.87F, 15.48F, 12.1F, 9.1F);
      localPath.cubicTo(18.08F, 3.66F, 25.969999F, 0.6F, 34.0F, 0.0F);
      localPath.lineTo(34.0F, 0.0F);
      localPath.close();
      localPath.moveTo(29.41F, 3.66F);
      localPath.cubicTo(18.26F, 5.87F, 8.62F, 14.23F, 4.9F, 24.969999F);
      localPath.cubicTo(0.62F, 36.669998F, 3.76F, 50.630001F, 12.68F, 59.330002F);
      localPath.cubicTo(22.99F, 69.980003F, 40.66F, 72.120003F, 53.18F, 64.160004F);
      localPath.cubicTo(66.790001F, 56.23F, 72.809998F, 37.900002F, 66.519997F, 23.450001F);
      localPath.cubicTo(60.91F, 9.13F, 44.439999F, 0.29F, 29.41F, 3.66F);
      localPath.lineTo(29.41F, 3.66F);
      localPath.close();
      WeChatSVGRenderC2Java.setFillType(localPath, 2);
      localCanvas.drawPath(localPath, (Paint)localObject);
      localCanvas.restore();
      localCanvas.save();
      localPaint = c.a(localPaint, paramVarArgs);
      localObject = c.j(paramVarArgs);
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
      c.h(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.ajb
 * JD-Core Version:    0.7.0.1
 */