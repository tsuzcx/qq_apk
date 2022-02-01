package com.tencent.mm.boot.svg.a.a;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.c;

public final class cbo
  extends c
{
  private final int height = 16;
  private final int width = 16;
  
  public final int a(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 16;
      return 16;
      Canvas localCanvas = (Canvas)paramVarArgs[0];
      paramVarArgs = (Looper)paramVarArgs[1];
      Object localObject1 = c.j(paramVarArgs);
      Object localObject3 = c.i(paramVarArgs);
      Paint localPaint = c.m(paramVarArgs);
      localPaint.setFlags(385);
      localPaint.setStyle(Paint.Style.FILL);
      Object localObject2 = c.m(paramVarArgs);
      ((Paint)localObject2).setFlags(385);
      ((Paint)localObject2).setStyle(Paint.Style.STROKE);
      localPaint.setColor(-16777216);
      ((Paint)localObject2).setStrokeWidth(1.0F);
      ((Paint)localObject2).setStrokeCap(Paint.Cap.BUTT);
      ((Paint)localObject2).setStrokeJoin(Paint.Join.MITER);
      ((Paint)localObject2).setStrokeMiter(4.0F);
      ((Paint)localObject2).setPathEffect(null);
      localObject2 = c.a((Paint)localObject2, paramVarArgs);
      ((Paint)localObject2).setStrokeWidth(1.0F);
      localCanvas.save();
      localObject3 = c.a((float[])localObject3, 1.0F, 0.0F, -394.0F, 0.0F, 1.0F, -603.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject3);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject3 = c.a((float[])localObject3, 1.0F, 0.0F, 66.0F, 0.0F, 1.0F, 602.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject3);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject3 = c.a((float[])localObject3, 1.0F, 0.0F, 327.0F, 0.0F, 1.0F, 0.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject3);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject2 = c.a((Paint)localObject2, paramVarArgs);
      ((Paint)localObject2).setColor(-5066062);
      localObject3 = c.a((float[])localObject3, 1.0F, 0.0F, 1.5F, 0.0F, 1.0F, 2.25F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject3);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject1 = c.a((Paint)localObject2, paramVarArgs);
      localObject3 = c.n(paramVarArgs);
      ((Path)localObject3).moveTo(10.003614F, 7.676534F);
      ((Path)localObject3).cubicTo(9.463942F, 8.64106F, 8.048503F, 8.919226F, 6.842165F, 8.298307F);
      ((Path)localObject3).cubicTo(5.635827F, 7.677047F, 5.095085F, 6.39164F, 5.63458F, 5.427114F);
      ((Path)localObject3).cubicTo(6.174253F, 4.462589F, 7.589692F, 4.184423F, 8.79603F, 4.805512F);
      ((Path)localObject3).cubicTo(10.002546F, 5.426773F, 10.543287F, 6.712009F, 10.003614F, 7.676534F);
      ((Path)localObject3).moveTo(10.079537F, 4.06439F);
      ((Path)localObject3).cubicTo(7.381836F, 1.703815F, 3.468684F, 1.619439F, 1.339054F, 3.875688F);
      ((Path)localObject3).cubicTo(-0.7907462F, 6.131938F, -0.3303454F, 9.874747F, 2.367186F, 12.235322F);
      ((Path)localObject3).cubicTo(5.064887F, 14.595734F, 8.97821F, 14.680437F, 11.10784F, 12.424025F);
      ((Path)localObject3).cubicTo(13.23747F, 10.167775F, 12.777239F, 6.424965F, 10.079537F, 4.06439F);
      localCanvas.drawPath((Path)localObject3, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.save();
      localObject1 = c.a((Paint)localObject2, paramVarArgs);
      localObject2 = c.n(paramVarArgs);
      ((Path)localObject2).moveTo(12.304614F, 0.05176788F);
      ((Path)localObject2).cubicTo(13.397458F, -0.2112903F, 14.561358F, 0.554029F, 14.904305F, 1.760916F);
      ((Path)localObject2).cubicTo(15.247252F, 2.967966F, 14.639293F, 4.159598F, 13.54645F, 4.422657F);
      ((Path)localObject2).cubicTo(12.453607F, 4.685715F, 11.289882F, 3.920558F, 10.946759F, 2.713508F);
      ((Path)localObject2).cubicTo(10.603812F, 1.506459F, 11.211771F, 0.314988F, 12.304614F, 0.05176788F);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.restore();
      localPaint = c.a(localPaint, paramVarArgs);
      localPaint.setColor(-1);
      localObject1 = c.n(paramVarArgs);
      ((Path)localObject1).moveTo(0.0F, 0.0F);
      ((Path)localObject1).lineTo(18.0F, 0.0F);
      ((Path)localObject1).lineTo(18.0F, 18.0F);
      ((Path)localObject1).lineTo(0.0F, 18.0F);
      ((Path)localObject1).lineTo(0.0F, 0.0F);
      ((Path)localObject1).close();
      localCanvas.saveLayerAlpha(null, 0, 31);
      localCanvas.drawPath((Path)localObject1, c.a(localPaint, paramVarArgs));
      localCanvas.restore();
      localCanvas.restore();
      localCanvas.restore();
      localCanvas.restore();
      c.l(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.cbo
 * JD-Core Version:    0.7.0.1
 */