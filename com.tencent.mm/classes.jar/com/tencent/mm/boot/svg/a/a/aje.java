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

public final class aje
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
      localPaint.setColor(-16777216);
      localCanvas.save();
      localPaint = c.a(localPaint, paramVarArgs);
      localObject = c.n(paramVarArgs);
      ((Path)localObject).moveTo(36.0F, 6.0F);
      ((Path)localObject).cubicTo(52.568542F, 6.0F, 66.0F, 19.431458F, 66.0F, 36.0F);
      ((Path)localObject).cubicTo(66.0F, 52.568542F, 52.568542F, 66.0F, 36.0F, 66.0F);
      ((Path)localObject).cubicTo(19.431458F, 66.0F, 6.0F, 52.568542F, 6.0F, 36.0F);
      ((Path)localObject).cubicTo(6.0F, 19.431458F, 19.431458F, 6.0F, 36.0F, 6.0F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(31.5F, 24.0F);
      ((Path)localObject).lineTo(25.5F, 24.0F);
      ((Path)localObject).lineTo(30.0F, 33.0F);
      ((Path)localObject).lineTo(25.5F, 33.0F);
      ((Path)localObject).lineTo(25.5F, 37.5F);
      ((Path)localObject).lineTo(33.75F, 37.5F);
      ((Path)localObject).lineTo(33.75F, 40.5F);
      ((Path)localObject).lineTo(25.5F, 40.5F);
      ((Path)localObject).lineTo(25.5F, 45.0F);
      ((Path)localObject).lineTo(33.75F, 45.0F);
      ((Path)localObject).lineTo(33.75F, 49.5F);
      ((Path)localObject).lineTo(38.25F, 49.5F);
      ((Path)localObject).lineTo(38.25F, 45.0F);
      ((Path)localObject).lineTo(46.5F, 45.0F);
      ((Path)localObject).lineTo(46.5F, 40.5F);
      ((Path)localObject).lineTo(38.25F, 40.5F);
      ((Path)localObject).lineTo(38.25F, 37.5F);
      ((Path)localObject).lineTo(46.5F, 37.5F);
      ((Path)localObject).lineTo(46.5F, 33.0F);
      ((Path)localObject).lineTo(42.0F, 33.0F);
      ((Path)localObject).lineTo(46.5F, 24.0F);
      ((Path)localObject).lineTo(40.5F, 24.0F);
      ((Path)localObject).lineTo(36.0F, 33.0F);
      ((Path)localObject).lineTo(31.5F, 24.0F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 1);
      localCanvas.drawPath((Path)localObject, localPaint);
      localCanvas.restore();
      c.l(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.aje
 * JD-Core Version:    0.7.0.1
 */