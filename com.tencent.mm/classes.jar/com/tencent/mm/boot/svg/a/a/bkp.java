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

public final class bkp
  extends c
{
  private final int height = 192;
  private final int width = 192;
  
  public final int a(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 192;
      return 192;
      Canvas localCanvas = (Canvas)paramVarArgs[0];
      paramVarArgs = (Looper)paramVarArgs[1];
      Object localObject1 = c.j(paramVarArgs);
      Object localObject2 = c.i(paramVarArgs);
      Paint localPaint1 = c.m(paramVarArgs);
      localPaint1.setFlags(385);
      localPaint1.setStyle(Paint.Style.FILL);
      Paint localPaint2 = c.m(paramVarArgs);
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
      localPaint1.setColor(-13421773);
      localObject2 = c.a((float[])localObject2, 1.0F, 0.0F, 48.0F, 0.0F, 1.0F, 48.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject2);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject2 = c.a((float[])localObject2, 1.0F, 0.0F, 9.0F, 0.0F, 1.0F, 18.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject2);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject1 = c.a(localPaint1, paramVarArgs);
      localObject2 = c.n(paramVarArgs);
      ((Path)localObject2).moveTo(78.0F, 27.0F);
      ((Path)localObject2).lineTo(78.0F, 57.0F);
      ((Path)localObject2).cubicTo(78.0F, 58.656853F, 76.656853F, 60.0F, 75.0F, 60.0F);
      ((Path)localObject2).lineTo(3.0F, 60.0F);
      ((Path)localObject2).cubicTo(1.343146F, 60.0F, 2.029061E-016F, 58.656853F, 0.0F, 57.0F);
      ((Path)localObject2).lineTo(0.0F, 27.0F);
      ((Path)localObject2).lineTo(-1.332268E-015F, 3.0F);
      ((Path)localObject2).cubicTo(-1.535174E-015F, 1.343146F, 1.343146F, -3.248354E-015F, 3.0F, -3.552714E-015F);
      ((Path)localObject2).lineTo(25.947657F, 1.021405E-014F);
      ((Path)localObject2).cubicTo(26.628872F, 1.069395E-014F, 27.289803F, 0.2318423F, 27.821741F, 0.6573936F);
      ((Path)localObject2).lineTo(33.678257F, 5.342607F);
      ((Path)localObject2).cubicTo(34.210197F, 5.768158F, 34.871128F, 6.0F, 35.552341F, 6.0F);
      ((Path)localObject2).lineTo(75.0F, 6.0F);
      ((Path)localObject2).cubicTo(76.656853F, 6.0F, 78.0F, 7.343146F, 78.0F, 9.0F);
      ((Path)localObject2).lineTo(78.0F, 27.0F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(75.0F, 18.802692F);
      ((Path)localObject2).lineTo(75.0F, 15.0F);
      ((Path)localObject2).cubicTo(75.0F, 13.343145F, 73.656853F, 12.0F, 72.0F, 12.0F);
      ((Path)localObject2).lineTo(6.0F, 12.0F);
      ((Path)localObject2).cubicTo(4.343146F, 12.0F, 3.0F, 13.343145F, 3.0F, 15.0F);
      ((Path)localObject2).lineTo(3.0F, 18.802692F);
      ((Path)localObject2).cubicTo(3.88252F, 18.292183F, 4.907138F, 18.0F, 6.0F, 18.0F);
      ((Path)localObject2).lineTo(72.0F, 18.0F);
      ((Path)localObject2).cubicTo(73.092865F, 18.0F, 74.117477F, 18.292183F, 75.0F, 18.802692F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 2);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.restore();
      localCanvas.restore();
      c.l(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.bkp
 * JD-Core Version:    0.7.0.1
 */