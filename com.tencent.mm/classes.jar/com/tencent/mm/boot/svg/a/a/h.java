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

public final class h
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
      localPaint = c.a(localPaint, paramVarArgs);
      localPaint.setColor(-8617594);
      localCanvas.save();
      localPaint = c.a(localPaint, paramVarArgs);
      localObject = c.l(paramVarArgs);
      ((Path)localObject).moveTo(48.0F, 30.0F);
      ((Path)localObject).cubicTo(45.238575F, 30.0F, 43.0F, 27.761423F, 43.0F, 25.0F);
      ((Path)localObject).cubicTo(43.0F, 22.238577F, 45.238575F, 20.0F, 48.0F, 20.0F);
      ((Path)localObject).cubicTo(50.761425F, 20.0F, 53.0F, 22.238577F, 53.0F, 25.0F);
      ((Path)localObject).cubicTo(53.0F, 27.761423F, 50.761425F, 30.0F, 48.0F, 30.0F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(48.0F, 53.0F);
      ((Path)localObject).cubicTo(45.238575F, 53.0F, 43.0F, 50.761425F, 43.0F, 48.0F);
      ((Path)localObject).cubicTo(43.0F, 45.238575F, 45.238575F, 43.0F, 48.0F, 43.0F);
      ((Path)localObject).cubicTo(50.761425F, 43.0F, 53.0F, 45.238575F, 53.0F, 48.0F);
      ((Path)localObject).cubicTo(53.0F, 50.761425F, 50.761425F, 53.0F, 48.0F, 53.0F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(48.0F, 76.0F);
      ((Path)localObject).cubicTo(45.238575F, 76.0F, 43.0F, 73.761421F, 43.0F, 71.0F);
      ((Path)localObject).cubicTo(43.0F, 68.238579F, 45.238575F, 66.0F, 48.0F, 66.0F);
      ((Path)localObject).cubicTo(50.761425F, 66.0F, 53.0F, 68.238579F, 53.0F, 71.0F);
      ((Path)localObject).cubicTo(53.0F, 73.761421F, 50.761425F, 76.0F, 48.0F, 76.0F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 2);
      localCanvas.drawPath((Path)localObject, localPaint);
      localCanvas.restore();
      c.j(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.h
 * JD-Core Version:    0.7.0.1
 */