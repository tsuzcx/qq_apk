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

public final class bmt
  extends c
{
  private final int height = 290;
  private final int width = 290;
  
  public final int a(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 290;
      return 290;
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
      localPaint.setColor(-3833595);
      localObject = c.n(paramVarArgs);
      ((Path)localObject).moveTo(274.5553F, 275.0F);
      ((Path)localObject).cubicTo(245.11929F, 272.36899F, 198.08231F, 270.66501F, 145.06329F, 270.66501F);
      ((Path)localObject).cubicTo(92.044296F, 270.66501F, 45.0103F, 272.36899F, 15.5753F, 275.0F);
      ((Path)localObject).lineTo(15.0003F, 275.0F);
      ((Path)localObject).cubicTo(17.6523F, 245.59599F, 19.373301F, 198.364F, 19.373301F, 145.10001F);
      ((Path)localObject).cubicTo(19.373301F, 91.834999F, 17.6523F, 44.605999F, 15.0003F, 15.202F);
      ((Path)localObject).lineTo(15.0003F, 15.0F);
      ((Path)localObject).cubicTo(44.396301F, 17.66F, 91.7033F, 19.386F, 145.06329F, 19.386F);
      ((Path)localObject).cubicTo(198.3403F, 19.386F, 245.5833F, 17.665001F, 274.98929F, 15.013F);
      ((Path)localObject).cubicTo(272.3353F, 44.414001F, 270.61429F, 91.664001F, 270.61429F, 144.951F);
      ((Path)localObject).cubicTo(270.61429F, 198.306F, 272.3403F, 245.60699F, 275.00031F, 275.0F);
      ((Path)localObject).lineTo(274.5553F, 275.0F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(285.10831F, 144.94501F);
      ((Path)localObject).cubicTo(285.10831F, 85.510002F, 287.02829F, 32.807999F, 289.98831F, 0.014F);
      ((Path)localObject).cubicTo(257.1893F, 2.973F, 204.49429F, 4.892F, 145.0703F, 4.892F);
      ((Path)localObject).cubicTo(85.553299F, 4.892F, 32.7883F, 2.966F, 0.0003F, 0.0F);
      ((Path)localObject).lineTo(0.0003F, 0.225F);
      ((Path)localObject).cubicTo(2.9583F, 33.021999F, 4.8773F, 85.699997F, 4.8773F, 145.112F);
      ((Path)localObject).cubicTo(4.8773F, 204.522F, 2.9583F, 257.203F, 0.0003F, 290.0F);
      ((Path)localObject).lineTo(0.6413F, 290.0F);
      ((Path)localObject).cubicTo(33.473301F, 287.06601F, 85.934303F, 285.16501F, 145.0703F, 285.16501F);
      ((Path)localObject).cubicTo(204.20731F, 285.16501F, 256.6723F, 287.06601F, 289.5043F, 290.0F);
      ((Path)localObject).lineTo(290.00031F, 290.0F);
      ((Path)localObject).cubicTo(287.03329F, 257.215F, 285.10831F, 204.45599F, 285.10831F, 144.94501F);
      ((Path)localObject).lineTo(285.10831F, 144.94501F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 2);
      localCanvas.drawPath((Path)localObject, localPaint);
      localCanvas.restore();
      c.l(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.bmt
 * JD-Core Version:    0.7.0.1
 */