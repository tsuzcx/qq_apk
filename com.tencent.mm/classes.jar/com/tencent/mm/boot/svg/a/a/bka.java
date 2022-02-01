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

public final class bka
  extends c
{
  private final int height = 79;
  private final int width = 66;
  
  public final int a(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 66;
      return 79;
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
      localPaint = c.a(localPaint, paramVarArgs);
      localObject = c.n(paramVarArgs);
      ((Path)localObject).moveTo(10.536117F, 55.789783F);
      ((Path)localObject).cubicTo(4.649229F, 49.986561F, 1.0F, 41.919441F, 1.0F, 33.0F);
      ((Path)localObject).cubicTo(1.0F, 15.326888F, 15.326888F, 1.0F, 33.0F, 1.0F);
      ((Path)localObject).cubicTo(50.673111F, 1.0F, 65.0F, 15.326888F, 65.0F, 33.0F);
      ((Path)localObject).cubicTo(65.0F, 41.959976F, 61.317528F, 50.059868F, 55.383484F, 55.868763F);
      ((Path)localObject).lineTo(55.435028F, 55.920311F);
      ((Path)localObject).lineTo(32.920311F, 78.435028F);
      ((Path)localObject).lineTo(10.405592F, 55.920311F);
      ((Path)localObject).lineTo(10.536117F, 55.789783F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 2);
      localCanvas.drawPath((Path)localObject, localPaint);
      localCanvas.restore();
      c.l(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.bka
 * JD-Core Version:    0.7.0.1
 */