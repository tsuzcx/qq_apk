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

public final class xc
  extends c
{
  private final int height = 78;
  private final int width = 78;
  
  public final int a(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 78;
      return 78;
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
      localPaint.setColor(-1776412);
      localCanvas.save();
      localPaint = c.a(localPaint, paramVarArgs);
      localObject = c.l(paramVarArgs);
      ((Path)localObject).moveTo(39.0F, 78.0F);
      ((Path)localObject).cubicTo(60.539104F, 78.0F, 78.0F, 60.539104F, 78.0F, 39.0F);
      ((Path)localObject).cubicTo(78.0F, 17.460896F, 60.539104F, 0.0F, 39.0F, 0.0F);
      ((Path)localObject).cubicTo(17.460896F, 0.0F, 0.0F, 17.460896F, 0.0F, 39.0F);
      ((Path)localObject).cubicTo(0.0F, 60.539104F, 17.460896F, 78.0F, 39.0F, 78.0F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(39.0F, 73.0F);
      ((Path)localObject).cubicTo(57.777683F, 73.0F, 73.0F, 57.777683F, 73.0F, 39.0F);
      ((Path)localObject).cubicTo(73.0F, 20.222319F, 57.777683F, 5.0F, 39.0F, 5.0F);
      ((Path)localObject).cubicTo(20.222319F, 5.0F, 5.0F, 20.222319F, 5.0F, 39.0F);
      ((Path)localObject).cubicTo(5.0F, 57.777683F, 20.222319F, 73.0F, 39.0F, 73.0F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 2);
      localCanvas.drawPath((Path)localObject, localPaint);
      localCanvas.restore();
      c.j(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.xc
 * JD-Core Version:    0.7.0.1
 */