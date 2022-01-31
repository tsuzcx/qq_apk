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

public final class aej
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
      localPaint2 = c.a(localPaint2, paramVarArgs);
      localPaint2.setStrokeWidth(1.0F);
      localCanvas.save();
      localObject2 = c.a((float[])localObject2, 1.0F, 0.0F, 12.0F, 0.0F, 1.0F, 6.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject2);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject1 = c.a(localPaint2, paramVarArgs);
      ((Paint)localObject1).setColor(-16777216);
      ((Paint)localObject1).setStrokeWidth(3.6F);
      localObject2 = c.l(paramVarArgs);
      ((Path)localObject2).moveTo(1.8F, 18.004917F);
      ((Path)localObject2).lineTo(1.8F, 54.001087F);
      ((Path)localObject2).cubicTo(1.8F, 56.322994F, 3.68056F, 58.200001F, 6.006387F, 58.200001F);
      ((Path)localObject2).lineTo(41.993614F, 58.200001F);
      ((Path)localObject2).cubicTo(44.320652F, 58.200001F, 46.200001F, 56.321777F, 46.200001F, 54.001087F);
      ((Path)localObject2).lineTo(46.200001F, 18.004917F);
      ((Path)localObject2).cubicTo(46.200001F, 17.339945F, 45.660645F, 16.799999F, 44.997383F, 16.799999F);
      ((Path)localObject2).lineTo(3.002615F, 16.799999F);
      ((Path)localObject2).cubicTo(2.332884F, 16.799999F, 1.8F, 17.334574F, 1.8F, 18.004917F);
      ((Path)localObject2).close();
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.save();
      localPaint1 = c.a(localPaint1, paramVarArgs);
      localPaint1.setColor(-16777216);
      localObject1 = c.l(paramVarArgs);
      ((Path)localObject1).moveTo(12.0F, 12.0F);
      ((Path)localObject1).cubicTo(12.0F, 5.372583F, 17.372583F, 0.0F, 24.0F, 0.0F);
      ((Path)localObject1).cubicTo(30.627417F, 0.0F, 36.0F, 5.372583F, 36.0F, 12.0F);
      ((Path)localObject1).lineTo(35.999996F, 27.0F);
      ((Path)localObject1).lineTo(32.399998F, 27.0F);
      ((Path)localObject1).lineTo(32.399998F, 12.0F);
      ((Path)localObject1).cubicTo(32.39999F, 7.360799F, 28.639183F, 3.599991F, 23.99999F, 3.599991F);
      ((Path)localObject1).cubicTo(19.3608F, 3.599991F, 15.599991F, 7.360799F, 15.599991F, 11.99999F);
      ((Path)localObject1).lineTo(15.6F, 27.0F);
      ((Path)localObject1).lineTo(12.0F, 27.0F);
      ((Path)localObject1).lineTo(12.0F, 12.0F);
      ((Path)localObject1).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject1, 2);
      localCanvas.drawPath((Path)localObject1, localPaint1);
      localCanvas.restore();
      localCanvas.restore();
      c.j(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.aej
 * JD-Core Version:    0.7.0.1
 */