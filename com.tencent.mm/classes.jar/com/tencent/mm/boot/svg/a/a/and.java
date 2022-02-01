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

public final class and
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
      ((Path)localObject).moveTo(37.800072F, 49.381016F);
      ((Path)localObject).cubicTo(44.406094F, 48.500637F, 49.5F, 42.841934F, 49.5F, 35.992504F);
      ((Path)localObject).lineTo(49.5F, 31.5F);
      ((Path)localObject).lineTo(45.900002F, 31.5F);
      ((Path)localObject).lineTo(45.900002F, 35.992504F);
      ((Path)localObject).cubicTo(45.900002F, 41.465343F, 41.468178F, 45.900002F, 36.0F, 45.900002F);
      ((Path)localObject).cubicTo(30.5322F, 45.900002F, 26.1F, 41.46571F, 26.1F, 35.992504F);
      ((Path)localObject).lineTo(26.1F, 31.5F);
      ((Path)localObject).lineTo(22.5F, 31.5F);
      ((Path)localObject).lineTo(22.5F, 35.992504F);
      ((Path)localObject).cubicTo(22.5F, 42.843365F, 27.59519F, 48.500771F, 34.200073F, 49.38102F);
      ((Path)localObject).lineTo(34.200073F, 54.0F);
      ((Path)localObject).lineTo(37.800072F, 54.0F);
      ((Path)localObject).lineTo(37.800072F, 49.381016F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(36.0F, 66.0F);
      ((Path)localObject).cubicTo(19.431458F, 66.0F, 6.0F, 52.568542F, 6.0F, 36.0F);
      ((Path)localObject).cubicTo(6.0F, 19.431458F, 19.431458F, 6.0F, 36.0F, 6.0F);
      ((Path)localObject).cubicTo(52.568542F, 6.0F, 66.0F, 19.431458F, 66.0F, 36.0F);
      ((Path)localObject).cubicTo(66.0F, 52.568542F, 52.568542F, 66.0F, 36.0F, 66.0F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(36.0F, 19.5F);
      ((Path)localObject).cubicTo(32.686291F, 19.5F, 30.0F, 22.186291F, 30.0F, 25.5F);
      ((Path)localObject).lineTo(30.0F, 36.0F);
      ((Path)localObject).cubicTo(30.0F, 39.313709F, 32.686291F, 42.0F, 36.0F, 42.0F);
      ((Path)localObject).cubicTo(39.313709F, 42.0F, 42.0F, 39.313709F, 42.0F, 36.0F);
      ((Path)localObject).lineTo(42.0F, 25.5F);
      ((Path)localObject).cubicTo(42.0F, 22.186291F, 39.313709F, 19.5F, 36.0F, 19.5F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 2);
      localCanvas.drawPath((Path)localObject, localPaint);
      localCanvas.restore();
      c.l(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.and
 * JD-Core Version:    0.7.0.1
 */