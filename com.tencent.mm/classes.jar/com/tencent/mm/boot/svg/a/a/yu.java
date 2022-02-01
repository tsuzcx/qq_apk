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

public final class yu
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
      localPaint.setColor(-436207616);
      localCanvas.save();
      localPaint = c.a(localPaint, paramVarArgs);
      localObject = c.n(paramVarArgs);
      ((Path)localObject).moveTo(12.75F, 4.366433F);
      ((Path)localObject).lineTo(12.75F, 7.0F);
      ((Path)localObject).lineTo(19.001043F, 7.0F);
      ((Path)localObject).cubicTo(19.550869F, 7.0F, 20.0F, 7.445839F, 20.0F, 7.995809F);
      ((Path)localObject).lineTo(20.0F, 21.004192F);
      ((Path)localObject).cubicTo(20.0F, 21.551081F, 19.554161F, 22.0F, 19.004192F, 22.0F);
      ((Path)localObject).lineTo(4.995809F, 22.0F);
      ((Path)localObject).cubicTo(4.44892F, 22.0F, 4.0F, 21.554161F, 4.0F, 21.004192F);
      ((Path)localObject).lineTo(4.0F, 7.995809F);
      ((Path)localObject).cubicTo(4.0F, 7.44892F, 4.447248F, 7.0F, 4.998957F, 7.0F);
      ((Path)localObject).lineTo(11.25F, 7.0F);
      ((Path)localObject).lineTo(11.25F, 4.376435F);
      ((Path)localObject).lineTo(9.5305F, 6.096194F);
      ((Path)localObject).lineTo(8.47F, 5.035534F);
      ((Path)localObject).lineTo(11.29784F, 2.207053F);
      ((Path)localObject).cubicTo(11.688335F, 1.8165F, 12.3215F, 1.816452F, 12.712053F, 2.206947F);
      ((Path)localObject).cubicTo(12.71209F, 2.206982F, 12.712125F, 2.207018F, 12.71216F, 2.207053F);
      ((Path)localObject).lineTo(12.712053F, 2.20716F);
      ((Path)localObject).lineTo(15.54F, 5.035534F);
      ((Path)localObject).lineTo(14.479501F, 6.096194F);
      ((Path)localObject).lineTo(12.75F, 4.366433F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(11.25F, 7.0F);
      ((Path)localObject).lineTo(11.25F, 13.5F);
      ((Path)localObject).lineTo(12.75F, 13.5F);
      ((Path)localObject).lineTo(12.75F, 7.0F);
      ((Path)localObject).lineTo(11.25F, 7.0F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 2);
      localCanvas.drawPath((Path)localObject, localPaint);
      localCanvas.restore();
      c.l(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.yu
 * JD-Core Version:    0.7.0.1
 */