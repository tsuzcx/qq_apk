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

public final class aay
  extends c
{
  private final int height = 96;
  private final int width = 96;
  
  protected final int b(int paramInt, Object... paramVarArgs)
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
      localCanvas.save();
      localPaint = c.a(localPaint, paramVarArgs);
      localObject = c.j(paramVarArgs);
      ((Path)localObject).moveTo(31.0F, 26.001389F);
      ((Path)localObject).cubicTo(31.0F, 24.896053F, 31.895857F, 24.0F, 32.997391F, 24.0F);
      ((Path)localObject).lineTo(38.002609F, 24.0F);
      ((Path)localObject).cubicTo(39.105736F, 24.0F, 40.0F, 24.894938F, 40.0F, 26.001389F);
      ((Path)localObject).lineTo(40.0F, 69.998611F);
      ((Path)localObject).cubicTo(40.0F, 71.103951F, 39.104141F, 72.0F, 38.002609F, 72.0F);
      ((Path)localObject).lineTo(32.997391F, 72.0F);
      ((Path)localObject).cubicTo(31.894262F, 72.0F, 31.0F, 71.105064F, 31.0F, 69.998611F);
      ((Path)localObject).lineTo(31.0F, 26.001389F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(56.0F, 26.001389F);
      ((Path)localObject).cubicTo(56.0F, 24.896053F, 56.895859F, 24.0F, 57.997391F, 24.0F);
      ((Path)localObject).lineTo(63.002609F, 24.0F);
      ((Path)localObject).cubicTo(64.105736F, 24.0F, 65.0F, 24.894938F, 65.0F, 26.001389F);
      ((Path)localObject).lineTo(65.0F, 69.998611F);
      ((Path)localObject).cubicTo(65.0F, 71.103951F, 64.104141F, 72.0F, 63.002609F, 72.0F);
      ((Path)localObject).lineTo(57.997391F, 72.0F);
      ((Path)localObject).cubicTo(56.894264F, 72.0F, 56.0F, 71.105064F, 56.0F, 69.998611F);
      ((Path)localObject).lineTo(56.0F, 26.001389F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 2);
      localCanvas.drawPath((Path)localObject, localPaint);
      localCanvas.restore();
      c.h(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.aay
 * JD-Core Version:    0.7.0.1
 */