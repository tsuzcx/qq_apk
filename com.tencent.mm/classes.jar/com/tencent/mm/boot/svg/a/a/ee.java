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

public final class ee
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
      c.j(paramVarArgs);
      c.i(paramVarArgs);
      Object localObject = c.m(paramVarArgs);
      ((Paint)localObject).setFlags(385);
      ((Paint)localObject).setStyle(Paint.Style.FILL);
      Paint localPaint = c.m(paramVarArgs);
      localPaint.setFlags(385);
      localPaint.setStyle(Paint.Style.STROKE);
      ((Paint)localObject).setColor(-16777216);
      localPaint.setStrokeWidth(1.0F);
      localPaint.setStrokeCap(Paint.Cap.BUTT);
      localPaint.setStrokeJoin(Paint.Join.MITER);
      localPaint.setStrokeMiter(4.0F);
      localPaint.setPathEffect(null);
      c.a(localPaint, paramVarArgs).setStrokeWidth(1.0F);
      localCanvas.save();
      localPaint = c.a((Paint)localObject, paramVarArgs);
      localPaint.setColor(-1);
      Path localPath = c.n(paramVarArgs);
      localPath.moveTo(36.0F, 0.0F);
      localPath.cubicTo(55.882252F, 0.0F, 72.0F, 16.117748F, 72.0F, 36.0F);
      localPath.cubicTo(72.0F, 55.882252F, 55.882252F, 72.0F, 36.0F, 72.0F);
      localPath.cubicTo(16.117748F, 72.0F, 0.0F, 55.882252F, 0.0F, 36.0F);
      localPath.cubicTo(0.0F, 16.117748F, 16.117748F, 0.0F, 36.0F, 0.0F);
      localPath.close();
      localCanvas.drawPath(localPath, localPaint);
      localCanvas.restore();
      localPaint = c.a((Paint)localObject, paramVarArgs);
      localPaint.setColor(-16777216);
      localObject = c.n(paramVarArgs);
      ((Path)localObject).moveTo(33.0F, 33.0F);
      ((Path)localObject).lineTo(33.0F, 18.0F);
      ((Path)localObject).lineTo(39.0F, 18.0F);
      ((Path)localObject).lineTo(39.0F, 33.0F);
      ((Path)localObject).lineTo(54.0F, 33.0F);
      ((Path)localObject).lineTo(54.0F, 39.0F);
      ((Path)localObject).lineTo(39.0F, 39.0F);
      ((Path)localObject).lineTo(39.0F, 54.0F);
      ((Path)localObject).lineTo(33.0F, 54.0F);
      ((Path)localObject).lineTo(33.0F, 39.0F);
      ((Path)localObject).lineTo(18.0F, 39.0F);
      ((Path)localObject).lineTo(18.0F, 33.0F);
      ((Path)localObject).lineTo(33.0F, 33.0F);
      ((Path)localObject).close();
      localCanvas.saveLayerAlpha(null, 227, 31);
      localPaint = c.a(localPaint, paramVarArgs);
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 2);
      localCanvas.drawPath((Path)localObject, localPaint);
      localCanvas.restore();
      c.l(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.ee
 * JD-Core Version:    0.7.0.1
 */