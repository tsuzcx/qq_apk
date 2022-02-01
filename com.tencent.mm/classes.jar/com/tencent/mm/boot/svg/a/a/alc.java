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

public final class alc
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
      ((Path)localObject).moveTo(36.0F, 66.0F);
      ((Path)localObject).cubicTo(19.431458F, 66.0F, 6.0F, 52.568542F, 6.0F, 36.0F);
      ((Path)localObject).cubicTo(6.0F, 19.431458F, 19.431458F, 6.0F, 36.0F, 6.0F);
      ((Path)localObject).cubicTo(52.568542F, 6.0F, 66.0F, 19.431458F, 66.0F, 36.0F);
      ((Path)localObject).cubicTo(66.0F, 52.568542F, 52.568542F, 66.0F, 36.0F, 66.0F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(27.805887F, 33.599998F);
      ((Path)localObject).lineTo(42.0F, 33.599998F);
      ((Path)localObject).cubicTo(44.982338F, 33.599998F, 47.400002F, 36.017662F, 47.400002F, 39.0F);
      ((Path)localObject).cubicTo(47.400002F, 41.982338F, 44.982338F, 44.400002F, 42.0F, 44.400002F);
      ((Path)localObject).lineTo(36.0F, 44.400002F);
      ((Path)localObject).lineTo(36.0F, 48.0F);
      ((Path)localObject).lineTo(42.0F, 48.0F);
      ((Path)localObject).cubicTo(46.970562F, 48.0F, 51.0F, 43.970562F, 51.0F, 39.0F);
      ((Path)localObject).cubicTo(51.0F, 34.029438F, 46.970562F, 30.0F, 42.0F, 30.0F);
      ((Path)localObject).lineTo(27.976452F, 30.0F);
      ((Path)localObject).lineTo(32.030865F, 25.945585F);
      ((Path)localObject).lineTo(29.485281F, 23.400002F);
      ((Path)localObject).lineTo(22.060659F, 30.824621F);
      ((Path)localObject).cubicTo(21.474874F, 31.410408F, 21.474874F, 32.360157F, 22.060659F, 32.945942F);
      ((Path)localObject).lineTo(29.485281F, 40.370564F);
      ((Path)localObject).lineTo(32.030865F, 37.824978F);
      ((Path)localObject).lineTo(27.805887F, 33.599998F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 1);
      localCanvas.drawPath((Path)localObject, localPaint);
      localCanvas.restore();
      c.l(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.alc
 * JD-Core Version:    0.7.0.1
 */