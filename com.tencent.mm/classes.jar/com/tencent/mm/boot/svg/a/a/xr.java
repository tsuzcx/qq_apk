package com.tencent.mm.boot.svg.a.a;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;

public final class xr
  extends c
{
  private final int height = 54;
  private final int width = 60;
  
  public final int a(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 60;
      return 54;
      Canvas localCanvas = (Canvas)paramVarArgs[0];
      paramVarArgs = (Looper)paramVarArgs[1];
      Object localObject1 = c.h(paramVarArgs);
      Object localObject2 = c.g(paramVarArgs);
      Paint localPaint1 = c.k(paramVarArgs);
      localPaint1.setFlags(385);
      localPaint1.setStyle(Paint.Style.FILL);
      Paint localPaint2 = c.k(paramVarArgs);
      localPaint2.setFlags(385);
      localPaint2.setStyle(Paint.Style.STROKE);
      localPaint1.setColor(-16777216);
      localPaint2.setStrokeWidth(1.0F);
      localPaint2.setStrokeCap(Paint.Cap.BUTT);
      localPaint2.setStrokeJoin(Paint.Join.MITER);
      localPaint2.setStrokeMiter(4.0F);
      localPaint2.setPathEffect(null);
      c.a(localPaint2, paramVarArgs).setStrokeWidth(1.0F);
      localCanvas.save();
      localPaint1 = c.a(localPaint1, paramVarArgs);
      localPaint1.setColor(-1);
      localObject2 = c.a((float[])localObject2, 1.0F, 0.0F, 2.0F, 0.0F, 1.0F, 3.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject2);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject1 = c.a(localPaint1, paramVarArgs);
      localObject2 = c.l(paramVarArgs);
      ((Path)localObject2).moveTo(1.051323F, 4.949189F);
      ((Path)localObject2).cubicTo(0.731796F, 3.17122F, 1.930023F, 0.993708F, 3.927069F, 1.103582F);
      ((Path)localObject2).cubicTo(19.633831F, 0.9837193F, 35.350578F, 1.083605F, 51.057339F, 1.053639F);
      ((Path)localObject2).cubicTo(52.844696F, 0.724016F, 54.961563F, 1.942624F, 54.901653F, 3.910375F);
      ((Path)localObject2).cubicTo(55.041443F, 14.298506F, 54.931606F, 24.696625F, 54.951576F, 35.084755F);
      ((Path)localObject2).cubicTo(55.26112F, 36.872715F, 54.062893F, 39.090179F, 52.035892F, 38.960327F);
      ((Path)localObject2).cubicTo(42.370193F, 39.080193F, 32.694508F, 38.970318F, 23.028807F, 39.010273F);
      ((Path)localObject2).cubicTo(18.685234F, 41.996861F, 14.36163F, 45.003426F, 10.028042F, 48.0F);
      ((Path)localObject2).lineTo(10.028042F, 39.010273F);
      ((Path)localObject2).cubicTo(7.152297F, 38.590752F, 2.818708F, 40.328766F, 1.201102F, 37.052509F);
      ((Path)localObject2).cubicTo(0.8316482F, 26.364719F, 1.131205F, 15.646965F, 1.051323F, 4.949189F);
      ((Path)localObject2).lineTo(1.051323F, 4.949189F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(7.0F, 7.0F);
      ((Path)localObject2).lineTo(7.0F, 33.0F);
      ((Path)localObject2).lineTo(15.0F, 33.0F);
      ((Path)localObject2).lineTo(15.0F, 38.0F);
      ((Path)localObject2).cubicTo(17.34F, 36.330002F, 19.68F, 34.66F, 22.02F, 32.990002F);
      ((Path)localObject2).cubicTo(31.01F, 33.009998F, 40.009998F, 33.0F, 49.0F, 33.0F);
      ((Path)localObject2).lineTo(49.0F, 7.0F);
      ((Path)localObject2).lineTo(7.0F, 7.0F);
      ((Path)localObject2).lineTo(7.0F, 7.0F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 2);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.restore();
      c.j(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.xr
 * JD-Core Version:    0.7.0.1
 */