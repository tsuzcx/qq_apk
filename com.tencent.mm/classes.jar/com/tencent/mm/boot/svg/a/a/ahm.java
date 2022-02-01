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

public final class ahm
  extends c
{
  private final int height = 48;
  private final int width = 48;
  
  public final int a(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 48;
      return 48;
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
      ((Path)localObject).moveTo(30.978317F, 6.924232F);
      ((Path)localObject).cubicTo(32.202652F, 8.727818F, 32.531406F, 10.63063F, 32.531406F, 14.630878F);
      ((Path)localObject).cubicTo(32.531406F, 15.722366F, 32.239555F, 15.994292F, 32.629761F, 16.682739F);
      ((Path)localObject).cubicTo(33.4496F, 16.696165F, 37.600334F, 16.974831F, 38.73455F, 17.384256F);
      ((Path)localObject).cubicTo(40.143074F, 17.892702F, 41.223366F, 18.710272F, 41.772549F, 19.934034F);
      ((Path)localObject).cubicTo(43.732792F, 24.30208F, 41.271797F, 36.090961F, 36.667828F, 39.880844F);
      ((Path)localObject).cubicTo(35.286457F, 41.018406F, 32.486027F, 40.878471F, 30.341778F, 41.054058F);
      ((Path)localObject).cubicTo(29.332201F, 41.136524F, 25.178223F, 41.148354F, 17.932774F, 41.115559F);
      ((Path)localObject).lineTo(17.932419F, 19.555609F);
      ((Path)localObject).cubicTo(18.249929F, 19.397259F, 18.607109F, 19.197855F, 19.040604F, 18.943678F);
      ((Path)localObject).cubicTo(20.298344F, 18.206264F, 21.039513F, 17.369343F, 21.595888F, 15.898155F);
      ((Path)localObject).cubicTo(21.910469F, 15.065036F, 22.017292F, 14.247739F, 22.13168F, 11.829453F);
      ((Path)localObject).cubicTo(22.146851F, 11.50924F, 22.150642F, 11.408484F, 22.176422F, 10.681596F);
      ((Path)localObject).cubicTo(22.293335F, 7.385011F, 22.642885F, 6.210457F, 24.468605F, 5.362624F);
      ((Path)localObject).cubicTo(26.908642F, 4.229363F, 29.823425F, 5.222585F, 30.978317F, 6.924232F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(15.531559F, 20.245354F);
      ((Path)localObject).lineTo(15.532822F, 41.103699F);
      ((Path)localObject).cubicTo(13.817529F, 41.094589F, 11.956687F, 41.083508F, 9.950839F, 41.070717F);
      ((Path)localObject).cubicTo(8.248931F, 41.060577F, 6.870588F, 39.693882F, 6.870588F, 38.001579F);
      ((Path)localObject).lineTo(6.870588F, 23.440556F);
      ((Path)localObject).cubicTo(6.870588F, 21.740942F, 8.264331F, 20.371399F, 9.974019F, 20.371399F);
      ((Path)localObject).lineTo(13.723339F, 20.371399F);
      ((Path)localObject).cubicTo(14.33067F, 20.371399F, 14.912404F, 20.334341F, 15.531559F, 20.245354F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 2);
      localCanvas.drawPath((Path)localObject, localPaint);
      localCanvas.restore();
      c.l(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.ahm
 * JD-Core Version:    0.7.0.1
 */