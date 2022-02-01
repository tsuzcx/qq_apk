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

public final class amq
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
      localPaint1.setColor(-16777216);
      localObject2 = c.a((float[])localObject2, 1.0F, 0.0F, 9.0F, 0.0F, 1.0F, 9.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject2);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject1 = c.a(localPaint1, paramVarArgs);
      localObject2 = c.n(paramVarArgs);
      ((Path)localObject2).moveTo(54.0F, 36.0F);
      ((Path)localObject2).lineTo(54.0F, 51.0F);
      ((Path)localObject2).cubicTo(54.0F, 52.656853F, 52.656853F, 54.0F, 51.0F, 54.0F);
      ((Path)localObject2).lineTo(36.0F, 54.0F);
      ((Path)localObject2).lineTo(36.0F, 48.0F);
      ((Path)localObject2).lineTo(48.0F, 48.0F);
      ((Path)localObject2).lineTo(48.0F, 36.0F);
      ((Path)localObject2).lineTo(54.0F, 36.0F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(18.0F, 0.0F);
      ((Path)localObject2).lineTo(18.0F, 6.0F);
      ((Path)localObject2).lineTo(6.0F, 6.0F);
      ((Path)localObject2).lineTo(6.0F, 18.0F);
      ((Path)localObject2).lineTo(0.0F, 18.0F);
      ((Path)localObject2).lineTo(0.0F, 3.0F);
      ((Path)localObject2).cubicTo(0.0F, 1.343146F, 1.343146F, 1.998401E-015F, 3.0F, 1.998401E-015F);
      ((Path)localObject2).lineTo(18.0F, 0.0F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(43.751884F, 6.0F);
      ((Path)localObject2).lineTo(36.0F, 6.0F);
      ((Path)localObject2).lineTo(36.0F, 0.0F);
      ((Path)localObject2).lineTo(51.0F, 0.0F);
      ((Path)localObject2).cubicTo(52.656853F, -3.043592E-016F, 54.0F, 1.343146F, 54.0F, 3.0F);
      ((Path)localObject2).lineTo(54.0F, 18.0F);
      ((Path)localObject2).lineTo(48.0F, 18.0F);
      ((Path)localObject2).lineTo(48.0F, 10.240922F);
      ((Path)localObject2).lineTo(34.902641F, 23.334524F);
      ((Path)localObject2).lineTo(30.66F, 19.091883F);
      ((Path)localObject2).lineTo(43.751884F, 6.0F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(10.248116F, 47.994526F);
      ((Path)localObject2).lineTo(18.0F, 47.994526F);
      ((Path)localObject2).lineTo(18.0F, 53.994526F);
      ((Path)localObject2).lineTo(3.0F, 53.994526F);
      ((Path)localObject2).cubicTo(1.343146F, 53.994526F, 0.0F, 52.651379F, 0.0F, 50.994526F);
      ((Path)localObject2).lineTo(0.0F, 35.994526F);
      ((Path)localObject2).lineTo(6.0F, 35.994526F);
      ((Path)localObject2).lineTo(6.0F, 43.753601F);
      ((Path)localObject2).lineTo(19.097359F, 30.66F);
      ((Path)localObject2).lineTo(23.34F, 34.902641F);
      ((Path)localObject2).lineTo(10.248116F, 47.994526F);
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
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.amq
 * JD-Core Version:    0.7.0.1
 */