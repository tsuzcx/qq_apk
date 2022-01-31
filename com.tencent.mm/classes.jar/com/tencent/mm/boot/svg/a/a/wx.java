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

public final class wx
  extends c
{
  private final int height = 6;
  private final int width = 14;
  
  public final int a(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 14;
      return 6;
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
      localPaint = c.a(localPaint, paramVarArgs);
      localPaint.setColor(-2500135);
      localObject = c.l(paramVarArgs);
      ((Path)localObject).moveTo(2.0F, 1.0F);
      ((Path)localObject).lineTo(12.0F, 1.0F);
      ((Path)localObject).cubicTo(12.552284F, 1.0F, 13.0F, 1.447715F, 13.0F, 2.0F);
      ((Path)localObject).lineTo(13.0F, 4.0F);
      ((Path)localObject).cubicTo(13.0F, 4.552285F, 12.552284F, 5.0F, 12.0F, 5.0F);
      ((Path)localObject).lineTo(2.0F, 5.0F);
      ((Path)localObject).cubicTo(1.447715F, 5.0F, 1.0F, 4.552285F, 1.0F, 4.0F);
      ((Path)localObject).lineTo(1.0F, 2.0F);
      ((Path)localObject).cubicTo(1.0F, 1.447715F, 1.447715F, 1.0F, 2.0F, 1.0F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 2);
      localCanvas.drawPath((Path)localObject, localPaint);
      localCanvas.restore();
      c.j(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.wx
 * JD-Core Version:    0.7.0.1
 */