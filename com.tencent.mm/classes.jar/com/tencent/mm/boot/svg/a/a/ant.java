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

public final class ant
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
      ((Path)localObject).moveTo(22.171946F, 30.944338F);
      ((Path)localObject).lineTo(12.183209F, 36.607288F);
      ((Path)localObject).lineTo(8.831939F, 24.219584F);
      ((Path)localObject).cubicTo(8.278817F, 22.160328F, 9.515207F, 20.03672F, 11.59755F, 19.489731F);
      ((Path)localObject).lineTo(24.091606F, 16.175617F);
      ((Path)localObject).lineTo(24.124142F, 27.565872F);
      ((Path)localObject).cubicTo(24.124142F, 28.949434F, 23.375799F, 30.236469F, 22.171946F, 30.944338F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(24.124142F, 45.616531F);
      ((Path)localObject).lineTo(24.091606F, 57.006786F);
      ((Path)localObject).lineTo(11.59755F, 53.692673F);
      ((Path)localObject).cubicTo(9.515207F, 53.145683F, 8.278817F, 51.022076F, 8.831939F, 48.962822F);
      ((Path)localObject).lineTo(12.183209F, 36.607288F);
      ((Path)localObject).lineTo(22.171946F, 42.270241F);
      ((Path)localObject).cubicTo(23.375799F, 42.945934F, 24.124142F, 44.232971F, 24.124142F, 45.616531F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(37.984734F, 51.279484F);
      ((Path)localObject).lineTo(47.940933F, 57.006786F);
      ((Path)localObject).lineTo(38.765614F, 66.048203F);
      ((Path)localObject).cubicTo(37.236393F, 67.560471F, 34.763611F, 67.560471F, 33.23439F, 66.048203F);
      ((Path)localObject).lineTo(24.091606F, 57.006786F);
      ((Path)localObject).lineTo(34.047806F, 51.279484F);
      ((Path)localObject).cubicTo(35.251659F, 50.571613F, 36.748344F, 50.571613F, 37.984734F, 51.279484F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(49.828056F, 42.238068F);
      ((Path)localObject).lineTo(59.816795F, 36.575115F);
      ((Path)localObject).lineTo(63.168064F, 48.930645F);
      ((Path)localObject).cubicTo(63.721188F, 50.989902F, 62.484795F, 53.113506F, 60.402454F, 53.660496F);
      ((Path)localObject).lineTo(47.908398F, 56.974613F);
      ((Path)localObject).lineTo(47.875862F, 45.584354F);
      ((Path)localObject).cubicTo(47.875862F, 44.232971F, 48.624203F, 42.945934F, 49.828056F, 42.238068F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(47.875862F, 27.565872F);
      ((Path)localObject).lineTo(47.908398F, 16.175617F);
      ((Path)localObject).lineTo(60.402454F, 19.489731F);
      ((Path)localObject).cubicTo(62.484795F, 20.03672F, 63.721188F, 22.160328F, 63.168064F, 24.219584F);
      ((Path)localObject).lineTo(59.816795F, 36.575115F);
      ((Path)localObject).lineTo(49.828056F, 30.912163F);
      ((Path)localObject).cubicTo(48.624203F, 30.236469F, 47.875862F, 28.949434F, 47.875862F, 27.565872F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(34.047806F, 21.90292F);
      ((Path)localObject).lineTo(24.091606F, 16.175617F);
      ((Path)localObject).lineTo(33.23439F, 7.134199F);
      ((Path)localObject).cubicTo(34.763611F, 5.621934F, 37.236393F, 5.621934F, 38.765614F, 7.134199F);
      ((Path)localObject).lineTo(47.908398F, 16.175617F);
      ((Path)localObject).lineTo(37.952198F, 21.90292F);
      ((Path)localObject).cubicTo(36.748344F, 22.61079F, 35.251659F, 22.61079F, 34.047806F, 21.90292F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 1);
      localCanvas.drawPath((Path)localObject, localPaint);
      localCanvas.restore();
      c.l(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.ant
 * JD-Core Version:    0.7.0.1
 */