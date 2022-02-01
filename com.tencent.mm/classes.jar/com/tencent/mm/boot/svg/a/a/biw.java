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

public final class biw
  extends c
{
  private final int height = 96;
  private final int width = 96;
  
  public final int a(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 96;
      return 96;
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
      localCanvas.save();
      localObject = c.a(localPaint, paramVarArgs);
      Path localPath = c.n(paramVarArgs);
      localPath.moveTo(59.0F, 65.0F);
      localPath.lineTo(73.0F, 65.0F);
      localPath.lineTo(73.0F, 56.0F);
      localPath.lineTo(78.0F, 56.0F);
      localPath.lineTo(78.0F, 40.0F);
      localPath.lineTo(73.0F, 40.0F);
      localPath.lineTo(73.0F, 31.0F);
      localPath.lineTo(59.0F, 31.0F);
      localPath.lineTo(59.0F, 25.0F);
      localPath.lineTo(38.0F, 25.0F);
      localPath.lineTo(38.0F, 31.0F);
      localPath.lineTo(23.0F, 31.0F);
      localPath.lineTo(23.0F, 40.0F);
      localPath.lineTo(18.0F, 40.0F);
      localPath.lineTo(18.0F, 56.0F);
      localPath.lineTo(23.0F, 56.0F);
      localPath.lineTo(23.0F, 65.0F);
      localPath.lineTo(38.0F, 65.0F);
      localPath.lineTo(38.0F, 71.0F);
      localPath.lineTo(59.0F, 71.0F);
      localPath.lineTo(59.0F, 65.0F);
      localPath.close();
      localPath.moveTo(18.0F, 28.000444F);
      localPath.cubicTo(18.0F, 26.343344F, 19.337309F, 25.0F, 20.995937F, 25.0F);
      localPath.lineTo(75.004059F, 25.0F);
      localPath.cubicTo(76.658676F, 25.0F, 78.0F, 26.35178F, 78.0F, 28.000444F);
      localPath.lineTo(78.0F, 67.999557F);
      localPath.cubicTo(78.0F, 69.656654F, 76.662689F, 71.0F, 75.004059F, 71.0F);
      localPath.lineTo(20.995937F, 71.0F);
      localPath.cubicTo(19.341328F, 71.0F, 18.0F, 69.648216F, 18.0F, 67.999557F);
      localPath.lineTo(18.0F, 28.000444F);
      localPath.close();
      WeChatSVGRenderC2Java.setFillType(localPath, 2);
      localCanvas.drawPath(localPath, (Paint)localObject);
      localCanvas.restore();
      localCanvas.save();
      localPaint = c.a(localPaint, paramVarArgs);
      localObject = c.n(paramVarArgs);
      ((Path)localObject).moveTo(37.758621F, 45.672413F);
      ((Path)localObject).lineTo(36.0F, 49.189655F);
      ((Path)localObject).lineTo(43.913792F, 58.862068F);
      ((Path)localObject).lineTo(61.5F, 37.758621F);
      ((Path)localObject).lineTo(59.741379F, 36.0F);
      ((Path)localObject).lineTo(43.913792F, 50.948277F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 1);
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 2);
      localCanvas.drawPath((Path)localObject, localPaint);
      localCanvas.restore();
      c.l(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.biw
 * JD-Core Version:    0.7.0.1
 */