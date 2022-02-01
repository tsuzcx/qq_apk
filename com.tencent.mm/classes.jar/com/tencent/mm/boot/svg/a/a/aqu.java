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

public final class aqu
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
      localCanvas.save();
      localPaint = c.a(localPaint, paramVarArgs);
      localPaint.setColor(-436207616);
      localObject = c.n(paramVarArgs);
      ((Path)localObject).moveTo(36.0F, 6.0F);
      ((Path)localObject).cubicTo(52.568542F, 6.0F, 66.0F, 19.431458F, 66.0F, 36.0F);
      ((Path)localObject).cubicTo(66.0F, 52.568542F, 52.568542F, 66.0F, 36.0F, 66.0F);
      ((Path)localObject).cubicTo(19.431458F, 66.0F, 6.0F, 52.568542F, 6.0F, 36.0F);
      ((Path)localObject).cubicTo(6.0F, 19.431458F, 19.431458F, 6.0F, 36.0F, 6.0F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(36.0F, 10.8F);
      ((Path)localObject).cubicTo(22.082424F, 10.8F, 10.8F, 22.082424F, 10.8F, 36.0F);
      ((Path)localObject).cubicTo(10.8F, 49.917576F, 22.082424F, 61.200001F, 36.0F, 61.200001F);
      ((Path)localObject).cubicTo(49.917576F, 61.200001F, 61.200001F, 49.917576F, 61.200001F, 36.0F);
      ((Path)localObject).cubicTo(61.200001F, 22.082424F, 49.917576F, 10.8F, 36.0F, 10.8F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(47.39183F, 23.515844F);
      ((Path)localObject).cubicTo(47.463448F, 23.661095F, 47.473305F, 23.829126F, 47.419167F, 23.981754F);
      ((Path)localObject).lineTo(42.454319F, 37.982044F);
      ((Path)localObject).cubicTo(41.607559F, 40.742748F, 39.038189F, 42.75F, 36.0F, 42.75F);
      ((Path)localObject).cubicTo(32.272079F, 42.75F, 29.25F, 39.727921F, 29.25F, 36.0F);
      ((Path)localObject).cubicTo(29.25F, 33.343658F, 30.784407F, 31.045694F, 33.015236F, 29.944092F);
      ((Path)localObject).lineTo(33.008957F, 29.938238F);
      ((Path)localObject).lineTo(46.58836F, 23.243027F);
      ((Path)localObject).cubicTo(46.885567F, 23.096491F, 47.245296F, 23.218636F, 47.39183F, 23.515844F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 2);
      localCanvas.drawPath((Path)localObject, localPaint);
      localCanvas.restore();
      c.l(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.aqu
 * JD-Core Version:    0.7.0.1
 */