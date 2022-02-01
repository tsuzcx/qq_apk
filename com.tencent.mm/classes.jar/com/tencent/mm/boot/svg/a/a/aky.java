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

public final class aky
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
      localPaint1 = c.a(localPaint1, paramVarArgs);
      localPaint1.setColor(-16777216);
      localCanvas.save();
      localObject2 = c.a((float[])localObject2, 1.0F, 0.0F, 6.0F, 0.0F, 1.0F, 10.5F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject2);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject1 = c.a(localPaint1, paramVarArgs);
      localObject2 = c.n(paramVarArgs);
      ((Path)localObject2).moveTo(0.0F, 4.5F);
      ((Path)localObject2).cubicTo(-2.029061E-016F, 2.843146F, 1.343146F, 1.5F, 3.0F, 1.5F);
      ((Path)localObject2).lineTo(57.0F, 1.5F);
      ((Path)localObject2).cubicTo(58.656853F, 1.5F, 60.0F, 2.843146F, 60.0F, 4.5F);
      ((Path)localObject2).lineTo(60.0F, 43.5F);
      ((Path)localObject2).cubicTo(60.0F, 45.156853F, 58.656853F, 46.5F, 57.0F, 46.5F);
      ((Path)localObject2).lineTo(3.0F, 46.5F);
      ((Path)localObject2).cubicTo(1.343146F, 46.5F, -2.740258E-015F, 45.156853F, 0.0F, 43.5F);
      ((Path)localObject2).lineTo(0.0F, 4.5F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(18.0F, 52.649998F);
      ((Path)localObject2).cubicTo(18.0F, 51.407356F, 19.000694F, 50.399998F, 20.257862F, 50.399998F);
      ((Path)localObject2).lineTo(39.742138F, 50.399998F);
      ((Path)localObject2).cubicTo(40.98912F, 50.399998F, 42.0F, 51.398693F, 42.0F, 52.649998F);
      ((Path)localObject2).lineTo(42.0F, 54.899998F);
      ((Path)localObject2).lineTo(18.0F, 54.899998F);
      ((Path)localObject2).lineTo(18.0F, 52.649998F);
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
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.aky
 * JD-Core Version:    0.7.0.1
 */