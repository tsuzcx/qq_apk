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

public final class aul
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
      ((Path)localObject).moveTo(53.417892F, 16.160769F);
      ((Path)localObject).cubicTo(48.769585F, 12.076537F, 42.674004F, 9.6F, 36.0F, 9.6F);
      ((Path)localObject).cubicTo(21.419683F, 9.6F, 9.6F, 21.419683F, 9.6F, 36.0F);
      ((Path)localObject).cubicTo(9.6F, 50.580318F, 21.419683F, 62.400002F, 36.0F, 62.400002F);
      ((Path)localObject).cubicTo(50.580318F, 62.400002F, 62.400002F, 50.580318F, 62.400002F, 36.0F);
      ((Path)localObject).cubicTo(62.400002F, 29.389311F, 59.97023F, 23.346127F, 55.955036F, 18.714792F);
      ((Path)localObject).lineTo(49.993065F, 24.676765F);
      ((Path)localObject).cubicTo(52.498829F, 27.76951F, 54.0F, 31.709446F, 54.0F, 36.0F);
      ((Path)localObject).cubicTo(54.0F, 45.941124F, 45.941124F, 54.0F, 36.0F, 54.0F);
      ((Path)localObject).cubicTo(26.058874F, 54.0F, 18.0F, 45.941124F, 18.0F, 36.0F);
      ((Path)localObject).cubicTo(18.0F, 26.058874F, 26.058874F, 18.0F, 36.0F, 18.0F);
      ((Path)localObject).cubicTo(40.354008F, 18.0F, 44.346951F, 19.5459F, 47.459892F, 22.118767F);
      ((Path)localObject).lineTo(53.417892F, 16.160769F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(44.899872F, 24.678791F);
      ((Path)localObject).cubicTo(42.450245F, 22.750416F, 39.35947F, 21.6F, 36.0F, 21.6F);
      ((Path)localObject).cubicTo(28.0471F, 21.6F, 21.6F, 28.0471F, 21.6F, 36.0F);
      ((Path)localObject).cubicTo(21.6F, 43.9529F, 28.0471F, 50.400002F, 36.0F, 50.400002F);
      ((Path)localObject).cubicTo(43.9529F, 50.400002F, 50.400002F, 43.9529F, 50.400002F, 36.0F);
      ((Path)localObject).cubicTo(50.400002F, 32.704128F, 49.292728F, 29.666874F, 47.42989F, 27.239939F);
      ((Path)localObject).lineTo(40.224293F, 34.445538F);
      ((Path)localObject).cubicTo(40.40263F, 34.930012F, 40.5F, 35.453636F, 40.5F, 36.0F);
      ((Path)localObject).cubicTo(40.5F, 38.485283F, 38.485283F, 40.5F, 36.0F, 40.5F);
      ((Path)localObject).cubicTo(33.514717F, 40.5F, 31.5F, 38.485283F, 31.5F, 36.0F);
      ((Path)localObject).cubicTo(31.5F, 33.514717F, 33.514717F, 31.5F, 36.0F, 31.5F);
      ((Path)localObject).cubicTo(36.614132F, 31.5F, 37.199528F, 31.623022F, 37.732891F, 31.845768F);
      ((Path)localObject).lineTo(44.899872F, 24.678791F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(36.0F, 66.0F);
      ((Path)localObject).cubicTo(19.431458F, 66.0F, 6.0F, 52.568542F, 6.0F, 36.0F);
      ((Path)localObject).cubicTo(6.0F, 19.431458F, 19.431458F, 6.0F, 36.0F, 6.0F);
      ((Path)localObject).cubicTo(52.568542F, 6.0F, 66.0F, 19.431458F, 66.0F, 36.0F);
      ((Path)localObject).cubicTo(66.0F, 52.568542F, 52.568542F, 66.0F, 36.0F, 66.0F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 1);
      localCanvas.drawPath((Path)localObject, localPaint);
      localCanvas.restore();
      c.l(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.aul
 * JD-Core Version:    0.7.0.1
 */