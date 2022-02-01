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

public final class bke
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
      ((Path)localObject).moveTo(47.9995F, 20.0F);
      ((Path)localObject).cubicTo(30.878777F, 20.0F, 17.0F, 31.79821F, 17.0F, 46.35247F);
      ((Path)localObject).cubicTo(17.0F, 53.188591F, 20.061951F, 59.415703F, 25.08287F, 64.098785F);
      ((Path)localObject).cubicTo(23.80389F, 68.17186F, 21.427929F, 76.0F, 21.427929F, 76.0F);
      ((Path)localObject).lineTo(34.250721F, 69.972893F);
      ((Path)localObject).cubicTo(38.394653F, 71.719925F, 43.060581F, 72.70594F, 48.0005F, 72.70594F);
      ((Path)localObject).cubicTo(65.121223F, 72.70594F, 79.0F, 60.90773F, 79.0F, 46.351471F);
      ((Path)localObject).cubicTo(78.999001F, 31.79821F, 65.120224F, 20.0F, 47.9995F, 20.0F);
      ((Path)localObject).lineTo(47.9995F, 20.0F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 2);
      localCanvas.drawPath((Path)localObject, localPaint);
      localCanvas.restore();
      c.l(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.bke
 * JD-Core Version:    0.7.0.1
 */