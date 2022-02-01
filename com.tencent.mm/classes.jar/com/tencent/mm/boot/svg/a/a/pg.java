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

public final class pg
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
      localPaint.setColor(-15028967);
      localObject = c.n(paramVarArgs);
      ((Path)localObject).moveTo(45.424198F, 69.0F);
      ((Path)localObject).lineTo(39.625198F, 63.291F);
      ((Path)localObject).cubicTo(47.098202F, 56.445F, 51.769199F, 46.713001F, 51.769199F, 35.918999F);
      ((Path)localObject).cubicTo(51.769199F, 25.209F, 47.173199F, 15.546F, 39.8022F, 8.709F);
      ((Path)localObject).lineTo(45.6012F, 3.0F);
      ((Path)localObject).cubicTo(54.472198F, 11.295F, 60.001202F, 22.976999F, 60.001202F, 35.918999F);
      ((Path)localObject).cubicTo(60.001202F, 48.945F, 54.4002F, 60.695999F, 45.424198F, 69.0F);
      ((Path)localObject).moveTo(31.891199F, 55.674F);
      ((Path)localObject).lineTo(26.089199F, 49.959F);
      ((Path)localObject).cubicTo(30.058201F, 46.523998F, 32.5602F, 41.505001F, 32.5602F, 35.918999F);
      ((Path)localObject).cubicTo(32.5602F, 30.417F, 30.1332F, 25.466999F, 26.269199F, 22.035F);
      ((Path)localObject).lineTo(32.071201F, 16.323F);
      ((Path)localObject).cubicTo(37.438202F, 21.212999F, 40.792198F, 28.184999F, 40.792198F, 35.918999F);
      ((Path)localObject).cubicTo(40.792198F, 43.737F, 37.363201F, 50.775002F, 31.891199F, 55.674F);
      ((Path)localObject).moveTo(19.3032F, 43.278F);
      ((Path)localObject).lineTo(12.0012F, 36.087002F);
      ((Path)localObject).lineTo(19.495199F, 28.707001F);
      ((Path)localObject).cubicTo(21.610201F, 30.429001F, 22.957199F, 33.018002F, 22.957199F, 35.918999F);
      ((Path)localObject).cubicTo(22.957199F, 38.903999F, 21.5292F, 41.562F, 19.3032F, 43.278F);
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 2);
      localCanvas.drawPath((Path)localObject, localPaint);
      localCanvas.restore();
      c.l(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.pg
 * JD-Core Version:    0.7.0.1
 */