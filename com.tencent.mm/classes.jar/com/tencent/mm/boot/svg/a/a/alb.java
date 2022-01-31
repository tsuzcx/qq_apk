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

public final class alb
  extends c
{
  private final int height = 216;
  private final int width = 216;
  
  protected final int b(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 216;
      return 216;
      Canvas localCanvas = (Canvas)paramVarArgs[0];
      paramVarArgs = (Looper)paramVarArgs[1];
      c.f(paramVarArgs);
      c.e(paramVarArgs);
      Object localObject = c.i(paramVarArgs);
      ((Paint)localObject).setFlags(385);
      ((Paint)localObject).setStyle(Paint.Style.FILL);
      Paint localPaint = c.i(paramVarArgs);
      localPaint.setFlags(385);
      localPaint.setStyle(Paint.Style.STROKE);
      ((Paint)localObject).setColor(-16777216);
      localPaint.setStrokeWidth(1.0F);
      localPaint.setStrokeCap(Paint.Cap.BUTT);
      localPaint.setStrokeJoin(Paint.Join.MITER);
      localPaint.setStrokeMiter(4.0F);
      localPaint.setPathEffect(null);
      c.a(localPaint, paramVarArgs).setStrokeWidth(1.0F);
      localPaint = c.a((Paint)localObject, paramVarArgs);
      localPaint.setColor(-1);
      Path localPath = c.j(paramVarArgs);
      localPath.moveTo(108.0F, 0.0F);
      localPath.cubicTo(167.64676F, 0.0F, 216.0F, 48.353245F, 216.0F, 108.0F);
      localPath.cubicTo(216.0F, 167.64676F, 167.64676F, 216.0F, 108.0F, 216.0F);
      localPath.cubicTo(48.353245F, 216.0F, 0.0F, 167.64676F, 0.0F, 108.0F);
      localPath.cubicTo(0.0F, 48.353245F, 48.353245F, 0.0F, 108.0F, 0.0F);
      localPath.close();
      localCanvas.saveLayerAlpha(null, 230, 4);
      localCanvas.drawPath(localPath, c.a(localPaint, paramVarArgs));
      localCanvas.restore();
      localPaint = c.a((Paint)localObject, paramVarArgs);
      localPaint.setColor(-16777216);
      localObject = c.j(paramVarArgs);
      ((Path)localObject).moveTo(107.71468F, 130.56F);
      ((Path)localObject).lineTo(122.4F, 130.56F);
      ((Path)localObject).cubicTo(131.14819F, 130.56F, 138.24001F, 123.46819F, 138.24001F, 114.72F);
      ((Path)localObject).cubicTo(138.24001F, 105.97181F, 131.14819F, 98.879997F, 122.4F, 98.879997F);
      ((Path)localObject).lineTo(107.71468F, 98.879997F);
      ((Path)localObject).lineTo(86.400002F, 98.879997F);
      ((Path)localObject).lineTo(86.400002F, 110.4F);
      ((Path)localObject).lineTo(72.0F, 96.0F);
      ((Path)localObject).lineTo(86.400002F, 81.599998F);
      ((Path)localObject).lineTo(86.400002F, 93.120003F);
      ((Path)localObject).lineTo(122.4F, 93.120003F);
      ((Path)localObject).cubicTo(134.32935F, 93.120003F, 144.0F, 102.79065F, 144.0F, 114.72F);
      ((Path)localObject).cubicTo(144.0F, 126.64935F, 134.32935F, 136.32001F, 122.4F, 136.32001F);
      ((Path)localObject).lineTo(99.360001F, 136.32001F);
      ((Path)localObject).lineTo(99.360001F, 130.56F);
      ((Path)localObject).lineTo(107.71468F, 130.56F);
      ((Path)localObject).close();
      localCanvas.saveLayerAlpha(null, 204, 4);
      localPaint = c.a(localPaint, paramVarArgs);
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 2);
      localCanvas.drawPath((Path)localObject, localPaint);
      localCanvas.restore();
      c.h(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.alb
 * JD-Core Version:    0.7.0.1
 */