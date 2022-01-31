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

public final class eb
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
      localCanvas.save();
      localObject = c.a(localPaint, paramVarArgs);
      ((Paint)localObject).setColor(-1);
      Path localPath = c.l(paramVarArgs);
      localPath.moveTo(36.0F, 0.0F);
      localPath.cubicTo(55.882252F, 0.0F, 72.0F, 16.117748F, 72.0F, 36.0F);
      localPath.cubicTo(72.0F, 55.882252F, 55.882252F, 72.0F, 36.0F, 72.0F);
      localPath.cubicTo(16.117748F, 72.0F, 0.0F, 55.882252F, 0.0F, 36.0F);
      localPath.cubicTo(0.0F, 16.117748F, 16.117748F, 0.0F, 36.0F, 0.0F);
      localPath.close();
      localCanvas.drawPath(localPath, (Paint)localObject);
      localCanvas.restore();
      localCanvas.save();
      localPaint = c.a(localPaint, paramVarArgs);
      localPaint.setColor(-372399);
      localObject = c.l(paramVarArgs);
      ((Path)localObject).moveTo(23.485189F, 27.727831F);
      ((Path)localObject).cubicTo(21.914631F, 30.099129F, 21.0F, 32.942753F, 21.0F, 36.0F);
      ((Path)localObject).cubicTo(21.0F, 44.284271F, 27.715729F, 51.0F, 36.0F, 51.0F);
      ((Path)localObject).cubicTo(39.057247F, 51.0F, 41.900871F, 50.085369F, 44.272171F, 48.514809F);
      ((Path)localObject).lineTo(23.485189F, 27.727831F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(27.727831F, 23.485189F);
      ((Path)localObject).lineTo(48.514809F, 44.272171F);
      ((Path)localObject).cubicTo(50.085369F, 41.900871F, 51.0F, 39.057247F, 51.0F, 36.0F);
      ((Path)localObject).cubicTo(51.0F, 27.715729F, 44.284271F, 21.0F, 36.0F, 21.0F);
      ((Path)localObject).cubicTo(32.942753F, 21.0F, 30.099129F, 21.914631F, 27.727831F, 23.485189F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(36.0F, 57.0F);
      ((Path)localObject).cubicTo(24.40202F, 57.0F, 15.0F, 47.59798F, 15.0F, 36.0F);
      ((Path)localObject).cubicTo(15.0F, 24.40202F, 24.40202F, 15.0F, 36.0F, 15.0F);
      ((Path)localObject).cubicTo(47.59798F, 15.0F, 57.0F, 24.40202F, 57.0F, 36.0F);
      ((Path)localObject).cubicTo(57.0F, 47.59798F, 47.59798F, 57.0F, 36.0F, 57.0F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 2);
      localCanvas.drawPath((Path)localObject, localPaint);
      localCanvas.restore();
      c.j(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.eb
 * JD-Core Version:    0.7.0.1
 */