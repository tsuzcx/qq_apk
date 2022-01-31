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

public final class py
  extends c
{
  private final int height = 108;
  private final int width = 108;
  
  protected final int b(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 108;
      return 108;
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
      localCanvas.save();
      localObject = c.a(localPaint, paramVarArgs);
      ((Paint)localObject).setColor(-352965);
      Path localPath = c.j(paramVarArgs);
      localPath.moveTo(0.0F, 0.0F);
      localPath.lineTo(108.0F, 0.0F);
      localPath.lineTo(108.0F, 108.0F);
      localPath.lineTo(0.0F, 108.0F);
      localPath.lineTo(0.0F, 0.0F);
      localPath.close();
      WeChatSVGRenderC2Java.setFillType(localPath, 2);
      localCanvas.drawPath(localPath, (Paint)localObject);
      localCanvas.restore();
      localCanvas.save();
      localPaint = c.a(localPaint, paramVarArgs);
      localPaint.setColor(-1);
      localObject = c.j(paramVarArgs);
      ((Path)localObject).moveTo(81.0F, 72.0F);
      ((Path)localObject).lineTo(75.0F, 72.0F);
      ((Path)localObject).lineTo(75.0F, 69.0F);
      ((Path)localObject).lineTo(81.0F, 69.0F);
      ((Path)localObject).lineTo(81.0F, 63.0F);
      ((Path)localObject).lineTo(84.0F, 63.0F);
      ((Path)localObject).lineTo(84.0F, 69.0F);
      ((Path)localObject).lineTo(90.0F, 69.0F);
      ((Path)localObject).lineTo(90.0F, 72.0F);
      ((Path)localObject).lineTo(84.0F, 72.0F);
      ((Path)localObject).lineTo(84.0F, 78.0F);
      ((Path)localObject).lineTo(81.0F, 78.0F);
      ((Path)localObject).lineTo(81.0F, 72.0F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(70.593575F, 84.0F);
      ((Path)localObject).lineTo(26.608969F, 84.0F);
      ((Path)localObject).cubicTo(25.016039F, 84.0F, 24.0F, 82.823204F, 24.0F, 81.336769F);
      ((Path)localObject).lineTo(24.0F, 77.341476F);
      ((Path)localObject).cubicTo(24.0F, 74.146149F, 28.882536F, 71.76532F, 39.652912F, 65.622551F);
      ((Path)localObject).cubicTo(42.653629F, 63.911839F, 48.872398F, 61.217739F, 44.842228F, 55.012318F);
      ((Path)localObject).cubicTo(41.800369F, 50.327835F, 39.204819F, 48.315659F, 39.204819F, 40.414963F);
      ((Path)localObject).cubicTo(39.204819F, 32.215527F, 45.00322F, 24.0F, 54.0F, 24.0F);
      ((Path)localObject).cubicTo(62.99678F, 24.0F, 68.795181F, 32.215527F, 68.795181F, 40.414963F);
      ((Path)localObject).cubicTo(68.795181F, 48.315659F, 66.199631F, 50.327835F, 63.157772F, 55.012318F);
      ((Path)localObject).cubicTo(60.146255F, 59.649273F, 62.85746F, 62.325607F, 65.672424F, 64.096069F);
      ((Path)localObject).cubicTo(64.914856F, 66.085701F, 64.5F, 68.244385F, 64.5F, 70.5F);
      ((Path)localObject).cubicTo(64.5F, 75.876213F, 66.856773F, 80.701797F, 70.593575F, 84.0F);
      ((Path)localObject).lineTo(70.593575F, 84.0F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(69.0F, 70.501221F);
      ((Path)localObject).cubicTo(69.0F, 71.183273F, 69.050583F, 71.8535F, 69.148209F, 72.508362F);
      ((Path)localObject).cubicTo(70.117729F, 79.011879F, 75.726517F, 84.0F, 82.5F, 84.0F);
      ((Path)localObject).cubicTo(89.956757F, 84.0F, 96.0F, 77.956757F, 96.0F, 70.501221F);
      ((Path)localObject).cubicTo(96.0F, 63.044464F, 89.956757F, 57.0F, 82.5F, 57.0F);
      ((Path)localObject).cubicTo(75.044464F, 57.0F, 69.0F, 63.044464F, 69.0F, 70.501221F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 2);
      localCanvas.drawPath((Path)localObject, localPaint);
      localCanvas.restore();
      c.h(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.py
 * JD-Core Version:    0.7.0.1
 */