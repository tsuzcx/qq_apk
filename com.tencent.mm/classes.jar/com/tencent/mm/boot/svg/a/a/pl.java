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

public final class pl
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
      localCanvas.save();
      localPaint = c.a(localPaint, paramVarArgs);
      localPaint.setColor(-15819547);
      localObject = c.n(paramVarArgs);
      ((Path)localObject).moveTo(19.426306F, 8.069898F);
      ((Path)localObject).cubicTo(18.960836F, 7.191491F, 19.295588F, 6.102065F, 20.173994F, 5.636596F);
      ((Path)localObject).cubicTo(21.052401F, 5.171126F, 22.141829F, 5.505878F, 22.607296F, 6.384285F);
      ((Path)localObject).cubicTo(25.054684F, 11.002852F, 24.237564F, 16.734251F, 20.485281F, 20.486532F);
      ((Path)localObject).cubicTo(15.79899F, 25.172825F, 8.20101F, 25.172825F, 3.514719F, 20.486532F);
      ((Path)localObject).cubicTo(-1.171573F, 15.800241F, -1.171573F, 8.202262F, 3.514719F, 3.51597F);
      ((Path)localObject).cubicTo(7.267002F, -0.2363125F, 12.998399F, -1.053432F, 17.616966F, 1.393955F);
      ((Path)localObject).cubicTo(18.495373F, 1.859424F, 18.830126F, 2.948851F, 18.364656F, 3.827257F);
      ((Path)localObject).cubicTo(17.899187F, 4.705664F, 16.809761F, 5.040416F, 15.931354F, 4.574947F);
      ((Path)localObject).cubicTo(12.700203F, 2.862755F, 8.686935F, 3.434922F, 6.060303F, 6.061555F);
      ((Path)localObject).cubicTo(2.779899F, 9.341959F, 2.779899F, 14.660544F, 6.060303F, 17.940948F);
      ((Path)localObject).cubicTo(9.340707F, 21.221354F, 14.659293F, 21.221354F, 17.939697F, 17.940948F);
      ((Path)localObject).cubicTo(20.56633F, 15.314316F, 21.138496F, 11.301048F, 19.426306F, 8.069898F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 1);
      localCanvas.drawPath((Path)localObject, localPaint);
      localCanvas.restore();
      c.l(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.pl
 * JD-Core Version:    0.7.0.1
 */