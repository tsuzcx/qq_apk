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

public final class aik
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
      ((Path)localObject).moveTo(33.75F, 36.119278F);
      ((Path)localObject).lineTo(28.591501F, 30.959999F);
      ((Path)localObject).lineTo(25.41F, 34.141979F);
      ((Path)localObject).lineTo(33.89352F, 42.627422F);
      ((Path)localObject).cubicTo(35.065006F, 43.799084F, 36.9645F, 43.799225F, 38.136162F, 42.627102F);
      ((Path)localObject).lineTo(46.620003F, 34.141979F);
      ((Path)localObject).lineTo(43.438499F, 30.959999F);
      ((Path)localObject).lineTo(38.25F, 36.149284F);
      ((Path)localObject).lineTo(38.25F, 21.0F);
      ((Path)localObject).lineTo(33.75F, 21.0F);
      ((Path)localObject).lineTo(33.75F, 36.119278F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(33.75F, 21.0F);
      ((Path)localObject).lineTo(33.75F, 6.0F);
      ((Path)localObject).lineTo(38.25F, 6.0F);
      ((Path)localObject).lineTo(38.25F, 21.0F);
      ((Path)localObject).lineTo(57.003132F, 21.0F);
      ((Path)localObject).cubicTo(58.652611F, 21.0F, 60.0F, 22.337517F, 60.0F, 23.987425F);
      ((Path)localObject).lineTo(60.0F, 63.012573F);
      ((Path)localObject).cubicTo(60.0F, 64.653236F, 58.662483F, 66.0F, 57.012573F, 66.0F);
      ((Path)localObject).lineTo(14.987426F, 66.0F);
      ((Path)localObject).cubicTo(13.346761F, 66.0F, 12.0F, 64.662483F, 12.0F, 63.012573F);
      ((Path)localObject).lineTo(12.0F, 23.987425F);
      ((Path)localObject).cubicTo(12.0F, 22.34676F, 13.341744F, 21.0F, 14.99687F, 21.0F);
      ((Path)localObject).lineTo(33.75F, 21.0F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 1);
      localCanvas.drawPath((Path)localObject, localPaint);
      localCanvas.restore();
      c.l(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.aik
 * JD-Core Version:    0.7.0.1
 */