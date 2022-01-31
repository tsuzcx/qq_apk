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

public final class vo
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
      localPaint.setColor(-15028967);
      localCanvas.save();
      localPaint = c.a(localPaint, paramVarArgs);
      localObject = c.l(paramVarArgs);
      ((Path)localObject).moveTo(37.799999F, 59.92905F);
      ((Path)localObject).lineTo(37.799999F, 69.0F);
      ((Path)localObject).lineTo(34.200001F, 69.0F);
      ((Path)localObject).lineTo(34.200001F, 59.929047F);
      ((Path)localObject).cubicTo(22.615196F, 59.012062F, 13.5F, 49.320515F, 13.5F, 37.5F);
      ((Path)localObject).lineTo(13.5F, 33.0F);
      ((Path)localObject).lineTo(17.1F, 33.0F);
      ((Path)localObject).lineTo(17.1F, 37.5F);
      ((Path)localObject).cubicTo(17.1F, 47.938183F, 25.561819F, 56.400002F, 36.0F, 56.400002F);
      ((Path)localObject).cubicTo(46.438183F, 56.400002F, 54.900002F, 47.938183F, 54.900002F, 37.5F);
      ((Path)localObject).lineTo(54.900002F, 33.0F);
      ((Path)localObject).lineTo(58.5F, 33.0F);
      ((Path)localObject).lineTo(58.5F, 37.5F);
      ((Path)localObject).cubicTo(58.5F, 49.320515F, 49.384804F, 59.012062F, 37.799999F, 59.92905F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(22.5F, 19.5F);
      ((Path)localObject).cubicTo(22.5F, 12.044156F, 28.544155F, 6.0F, 36.0F, 6.0F);
      ((Path)localObject).cubicTo(43.455845F, 6.0F, 49.5F, 12.044156F, 49.5F, 19.5F);
      ((Path)localObject).lineTo(49.5F, 37.5F);
      ((Path)localObject).cubicTo(49.5F, 44.955845F, 43.455845F, 51.0F, 36.0F, 51.0F);
      ((Path)localObject).cubicTo(28.544155F, 51.0F, 22.5F, 44.955845F, 22.5F, 37.5F);
      ((Path)localObject).lineTo(22.5F, 19.5F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 1);
      localCanvas.drawPath((Path)localObject, localPaint);
      localCanvas.restore();
      c.j(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.vo
 * JD-Core Version:    0.7.0.1
 */