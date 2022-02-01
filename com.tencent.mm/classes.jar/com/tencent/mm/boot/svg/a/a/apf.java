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

public final class apf
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
      ((Path)localObject).moveTo(38.25F, 13.099298F);
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
      ((Path)localObject).lineTo(33.75F, 13.129304F);
      ((Path)localObject).lineTo(28.591501F, 18.288582F);
      ((Path)localObject).lineTo(25.41F, 15.106602F);
      ((Path)localObject).lineTo(33.89352F, 6.62116F);
      ((Path)localObject).cubicTo(35.065006F, 5.449499F, 36.9645F, 5.449356F, 38.136162F, 6.62084F);
      ((Path)localObject).cubicTo(38.136269F, 6.620947F, 38.136375F, 6.621053F, 38.136482F, 6.62116F);
      ((Path)localObject).lineTo(38.136162F, 6.621481F);
      ((Path)localObject).lineTo(46.620003F, 15.106602F);
      ((Path)localObject).lineTo(43.438499F, 18.288582F);
      ((Path)localObject).lineTo(38.25F, 13.099298F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(33.75F, 21.0F);
      ((Path)localObject).lineTo(33.75F, 40.5F);
      ((Path)localObject).lineTo(38.25F, 40.5F);
      ((Path)localObject).lineTo(38.25F, 21.0F);
      ((Path)localObject).lineTo(33.75F, 21.0F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 1);
      localCanvas.drawPath((Path)localObject, localPaint);
      localCanvas.restore();
      c.l(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.apf
 * JD-Core Version:    0.7.0.1
 */