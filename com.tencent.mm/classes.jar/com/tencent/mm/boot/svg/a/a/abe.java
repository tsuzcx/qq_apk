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

public final class abe
  extends c
{
  private final int height = 24;
  private final int width = 24;
  
  public final int a(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 24;
      return 24;
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
      ((Path)localObject).moveTo(4.844094F, 7.672352F);
      ((Path)localObject).lineTo(6.25884F, 9.086903F);
      ((Path)localObject).cubicTo(5.48387F, 9.816408F, 5.0F, 10.851697F, 5.0F, 12.0F);
      ((Path)localObject).cubicTo(5.0F, 14.209139F, 6.790861F, 16.0F, 9.0F, 16.0F);
      ((Path)localObject).lineTo(13.447F, 15.998F);
      ((Path)localObject).lineTo(11.642458F, 14.333333F);
      ((Path)localObject).lineTo(13.087667F, 13.0F);
      ((Path)localObject).lineTo(16.700687F, 16.333334F);
      ((Path)localObject).cubicTo(17.099771F, 16.701523F, 17.099771F, 17.298477F, 16.700687F, 17.666666F);
      ((Path)localObject).lineTo(13.087667F, 21.0F);
      ((Path)localObject).lineTo(11.642458F, 19.666666F);
      ((Path)localObject).lineTo(13.447F, 18.0F);
      ((Path)localObject).lineTo(9.0F, 18.0F);
      ((Path)localObject).cubicTo(5.686292F, 18.0F, 3.0F, 15.313708F, 3.0F, 12.0F);
      ((Path)localObject).cubicTo(3.0F, 10.299465F, 3.70745F, 8.764164F, 4.844094F, 7.672352F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(12.357542F, 9.666667F);
      ((Path)localObject).lineTo(10.912333F, 11.0F);
      ((Path)localObject).lineTo(7.299313F, 7.666667F);
      ((Path)localObject).cubicTo(6.900229F, 7.298477F, 6.900229F, 6.701523F, 7.299313F, 6.333334F);
      ((Path)localObject).lineTo(10.912333F, 3.0F);
      ((Path)localObject).lineTo(12.357542F, 4.333334F);
      ((Path)localObject).lineTo(10.551F, 6.0F);
      ((Path)localObject).lineTo(15.0F, 6.0F);
      ((Path)localObject).cubicTo(18.313709F, 6.0F, 21.0F, 8.686292F, 21.0F, 12.0F);
      ((Path)localObject).cubicTo(21.0F, 13.700535F, 20.292551F, 15.235836F, 19.155907F, 16.327648F);
      ((Path)localObject).lineTo(17.741159F, 14.913096F);
      ((Path)localObject).cubicTo(18.51613F, 14.183592F, 19.0F, 13.148303F, 19.0F, 12.0F);
      ((Path)localObject).cubicTo(19.0F, 9.790861F, 17.209139F, 8.0F, 15.0F, 8.0F);
      ((Path)localObject).lineTo(10.552F, 8.0F);
      ((Path)localObject).lineTo(12.357542F, 9.666667F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 2);
      localCanvas.drawPath((Path)localObject, localPaint);
      localCanvas.restore();
      c.l(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.abe
 * JD-Core Version:    0.7.0.1
 */