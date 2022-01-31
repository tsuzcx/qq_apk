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

public final class azi
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
      localPaint.setColor(-1);
      localCanvas.save();
      localPaint = c.a(localPaint, paramVarArgs);
      localObject = c.l(paramVarArgs);
      ((Path)localObject).moveTo(46.622131F, 76.745499F);
      ((Path)localObject).cubicTo(46.622131F, 76.745499F, 27.0F, 57.136356F, 27.0F, 41.21418F);
      ((Path)localObject).cubicTo(27.0F, 29.446882F, 36.40202F, 20.0F, 48.304348F, 20.0F);
      ((Path)localObject).cubicTo(59.59798F, 20.0F, 69.0F, 29.446882F, 69.0F, 41.21418F);
      ((Path)localObject).cubicTo(69.0F, 57.136356F, 49.377869F, 76.745499F, 49.377869F, 76.745499F);
      ((Path)localObject).cubicTo(48.628487F, 77.53978F, 47.383106F, 77.54187F, 46.622131F, 76.745499F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(48.0F, 48.0905F);
      ((Path)localObject).cubicTo(51.865993F, 48.0905F, 55.0F, 44.946362F, 55.0F, 41.067875F);
      ((Path)localObject).cubicTo(55.0F, 37.189384F, 51.865993F, 34.04525F, 48.0F, 34.04525F);
      ((Path)localObject).cubicTo(44.134007F, 34.04525F, 41.0F, 37.189384F, 41.0F, 41.067875F);
      ((Path)localObject).cubicTo(41.0F, 44.946362F, 44.134007F, 48.0905F, 48.0F, 48.0905F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 2);
      localCanvas.drawPath((Path)localObject, localPaint);
      localCanvas.restore();
      c.j(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.azi
 * JD-Core Version:    0.7.0.1
 */