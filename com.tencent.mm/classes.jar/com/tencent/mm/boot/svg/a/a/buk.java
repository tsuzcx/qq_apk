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

public final class buk
  extends c
{
  private final int height = 40;
  private final int width = 40;
  
  public final int a(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 40;
      return 40;
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
      localPaint1 = c.a(localPaint2, paramVarArgs);
      localPaint1.setStrokeWidth(1.0F);
      localPaint1 = c.a(localPaint1, paramVarArgs);
      localPaint1.setColor(-4210753);
      localPaint1.setStrokeWidth(2.533333F);
      localCanvas.save();
      localObject2 = c.a((float[])localObject2, 1.0F, 0.0F, 1.0F, 0.0F, 1.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject2);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject1 = c.a(localPaint1, paramVarArgs);
      localObject2 = c.n(paramVarArgs);
      ((Path)localObject2).moveTo(1.266667F, 8.866667F);
      ((Path)localObject2).cubicTo(1.266667F, 4.669303F, 4.669303F, 1.266667F, 8.866667F, 1.266667F);
      ((Path)localObject2).lineTo(29.133333F, 1.266667F);
      ((Path)localObject2).cubicTo(33.330696F, 1.266667F, 36.733334F, 4.669303F, 36.733334F, 8.866667F);
      ((Path)localObject2).lineTo(36.733334F, 29.133333F);
      ((Path)localObject2).cubicTo(36.733334F, 33.330696F, 33.330696F, 36.733334F, 29.133333F, 36.733334F);
      ((Path)localObject2).lineTo(8.866667F, 36.733334F);
      ((Path)localObject2).cubicTo(4.669303F, 36.733334F, 1.266667F, 33.330696F, 1.266667F, 29.133333F);
      ((Path)localObject2).lineTo(1.266667F, 8.866667F);
      ((Path)localObject2).close();
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.save();
      localObject1 = c.a(localPaint1, paramVarArgs);
      ((Paint)localObject1).setStrokeCap(Paint.Cap.ROUND);
      ((Paint)localObject1).setStrokeJoin(Paint.Join.MITER);
      localObject2 = c.n(paramVarArgs);
      ((Path)localObject2).moveTo(15.2F, 27.866667F);
      ((Path)localObject2).lineTo(15.2F, 10.133333F);
      ((Path)localObject2).lineTo(25.333334F, 19.05872F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 1);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.restore();
      c.l(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.buk
 * JD-Core Version:    0.7.0.1
 */