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

public final class byr
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
      localPaint.setColor(-1);
      localCanvas.save();
      localPaint = c.a(localPaint, paramVarArgs);
      localObject = c.n(paramVarArgs);
      ((Path)localObject).moveTo(12.0F, 3.0F);
      ((Path)localObject).cubicTo(16.970562F, 3.0F, 21.0F, 7.029437F, 21.0F, 12.0F);
      ((Path)localObject).lineTo(21.0F, 18.0F);
      ((Path)localObject).lineTo(21.0F, 19.0F);
      ((Path)localObject).cubicTo(21.0F, 20.10457F, 20.10457F, 21.0F, 19.0F, 21.0F);
      ((Path)localObject).lineTo(17.0F, 21.0F);
      ((Path)localObject).cubicTo(16.447716F, 21.0F, 16.0F, 20.552284F, 16.0F, 20.0F);
      ((Path)localObject).lineTo(16.0F, 15.0F);
      ((Path)localObject).cubicTo(16.0F, 14.447716F, 16.447716F, 14.0F, 17.0F, 14.0F);
      ((Path)localObject).lineTo(19.0F, 14.0F);
      ((Path)localObject).lineTo(19.0F, 12.0F);
      ((Path)localObject).cubicTo(19.0F, 8.134007F, 15.865993F, 5.0F, 12.0F, 5.0F);
      ((Path)localObject).cubicTo(8.134007F, 5.0F, 5.0F, 8.134007F, 5.0F, 12.0F);
      ((Path)localObject).lineTo(5.0F, 14.0F);
      ((Path)localObject).lineTo(7.0F, 14.0F);
      ((Path)localObject).cubicTo(7.552285F, 14.0F, 8.0F, 14.447716F, 8.0F, 15.0F);
      ((Path)localObject).lineTo(8.0F, 20.0F);
      ((Path)localObject).cubicTo(8.0F, 20.552284F, 7.552285F, 21.0F, 7.0F, 21.0F);
      ((Path)localObject).lineTo(5.0F, 21.0F);
      ((Path)localObject).cubicTo(3.895431F, 21.0F, 3.0F, 20.10457F, 3.0F, 19.0F);
      ((Path)localObject).lineTo(3.0F, 12.0F);
      ((Path)localObject).cubicTo(3.0F, 7.029437F, 7.029437F, 3.0F, 12.0F, 3.0F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 2);
      localCanvas.drawPath((Path)localObject, localPaint);
      localCanvas.restore();
      c.l(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.byr
 * JD-Core Version:    0.7.0.1
 */