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

public final class cq
  extends c
{
  private final int height = 90;
  private final int width = 90;
  
  protected final int b(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 90;
      return 90;
      Canvas localCanvas = (Canvas)paramVarArgs[0];
      paramVarArgs = (Looper)paramVarArgs[1];
      Object localObject1 = c.f(paramVarArgs);
      Object localObject2 = c.e(paramVarArgs);
      Paint localPaint1 = c.i(paramVarArgs);
      localPaint1.setFlags(385);
      localPaint1.setStyle(Paint.Style.FILL);
      Paint localPaint2 = c.i(paramVarArgs);
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
      localObject2 = c.a((float[])localObject2, 1.0F, 0.0F, 11.0F, 0.0F, 1.0F, 0.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject2);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject1 = c.a(localPaint1, paramVarArgs);
      ((Paint)localObject1).setColor(-7645398);
      localObject2 = c.j(paramVarArgs);
      ((Path)localObject2).moveTo(46.0F, 0.0F);
      ((Path)localObject2).lineTo(68.0F, 22.0F);
      ((Path)localObject2).lineTo(68.0F, 87.0F);
      ((Path)localObject2).cubicTo(68.0F, 88.656853F, 66.656853F, 90.0F, 65.0F, 90.0F);
      ((Path)localObject2).lineTo(3.0F, 90.0F);
      ((Path)localObject2).cubicTo(1.343146F, 90.0F, 2.029061E-016F, 88.656853F, 0.0F, 87.0F);
      ((Path)localObject2).lineTo(0.0F, 3.0F);
      ((Path)localObject2).cubicTo(-2.029061E-016F, 1.343146F, 1.343146F, 3.043592E-016F, 3.0F, 0.0F);
      ((Path)localObject2).lineTo(46.0F, 0.0F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 2);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.save();
      localObject1 = c.a(localPaint1, paramVarArgs);
      ((Paint)localObject1).setColor(-9485023);
      localObject2 = c.j(paramVarArgs);
      ((Path)localObject2).moveTo(68.0F, 22.0F);
      ((Path)localObject2).lineTo(49.0F, 22.0F);
      ((Path)localObject2).cubicTo(47.343147F, 22.0F, 46.0F, 20.656855F, 46.0F, 19.0F);
      ((Path)localObject2).lineTo(46.0F, 0.0F);
      ((Path)localObject2).lineTo(68.0F, 22.0F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 2);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.save();
      localPaint1 = c.a(localPaint1, paramVarArgs);
      localPaint1.setColor(-1);
      localObject1 = c.j(paramVarArgs);
      ((Path)localObject1).moveTo(32.714287F, 22.674419F);
      ((Path)localObject1).lineTo(32.714287F, 15.116279F);
      ((Path)localObject1).lineTo(29.5F, 15.116279F);
      ((Path)localObject1).cubicTo(28.671574F, 15.116279F, 28.0F, 14.444706F, 28.0F, 13.616279F);
      ((Path)localObject1).lineTo(28.0F, 9.05814F);
      ((Path)localObject1).cubicTo(28.0F, 8.229713F, 28.671574F, 7.558139F, 29.5F, 7.558139F);
      ((Path)localObject1).lineTo(32.714287F, 7.558139F);
      ((Path)localObject1).lineTo(32.714287F, 0.0F);
      ((Path)localObject1).lineTo(37.5F, 2.220446E-016F);
      ((Path)localObject1).cubicTo(38.328426F, -6.659261E-016F, 39.0F, 0.6715729F, 39.0F, 1.5F);
      ((Path)localObject1).lineTo(39.0F, 6.058139F);
      ((Path)localObject1).cubicTo(39.0F, 6.886567F, 38.328426F, 7.558139F, 37.5F, 7.558139F);
      ((Path)localObject1).lineTo(34.285713F, 7.558139F);
      ((Path)localObject1).lineTo(34.285713F, 15.116279F);
      ((Path)localObject1).lineTo(37.5F, 15.116279F);
      ((Path)localObject1).cubicTo(38.328426F, 15.116279F, 39.0F, 15.787852F, 39.0F, 16.61628F);
      ((Path)localObject1).lineTo(39.0F, 21.174419F);
      ((Path)localObject1).cubicTo(39.0F, 22.002846F, 38.328426F, 22.674419F, 37.5F, 22.674419F);
      ((Path)localObject1).lineTo(34.285713F, 22.674419F);
      ((Path)localObject1).lineTo(34.285713F, 30.232557F);
      ((Path)localObject1).lineTo(37.5F, 30.232557F);
      ((Path)localObject1).cubicTo(38.328426F, 30.232557F, 39.0F, 30.904131F, 39.0F, 31.732557F);
      ((Path)localObject1).lineTo(39.0F, 36.290699F);
      ((Path)localObject1).cubicTo(39.0F, 37.119125F, 38.328426F, 37.790699F, 37.5F, 37.790699F);
      ((Path)localObject1).lineTo(32.714287F, 37.790699F);
      ((Path)localObject1).lineTo(32.714287F, 30.232557F);
      ((Path)localObject1).lineTo(29.5F, 30.232557F);
      ((Path)localObject1).cubicTo(28.671574F, 30.232557F, 28.0F, 29.560986F, 28.0F, 28.732557F);
      ((Path)localObject1).lineTo(28.0F, 24.174419F);
      ((Path)localObject1).cubicTo(28.0F, 23.345991F, 28.671574F, 22.674419F, 29.5F, 22.674419F);
      ((Path)localObject1).lineTo(32.714287F, 22.674419F);
      ((Path)localObject1).close();
      ((Path)localObject1).moveTo(29.5F, 42.325581F);
      ((Path)localObject1).lineTo(37.5F, 42.325581F);
      ((Path)localObject1).cubicTo(38.328426F, 42.325581F, 39.0F, 42.997154F, 39.0F, 43.825581F);
      ((Path)localObject1).lineTo(39.0F, 63.5F);
      ((Path)localObject1).cubicTo(39.0F, 64.32843F, 38.328426F, 65.0F, 37.5F, 65.0F);
      ((Path)localObject1).lineTo(29.5F, 65.0F);
      ((Path)localObject1).cubicTo(28.671574F, 65.0F, 28.0F, 64.32843F, 28.0F, 63.5F);
      ((Path)localObject1).lineTo(28.0F, 43.825581F);
      ((Path)localObject1).cubicTo(28.0F, 42.997154F, 28.671574F, 42.325581F, 29.5F, 42.325581F);
      ((Path)localObject1).close();
      ((Path)localObject1).moveTo(30.357143F, 54.418606F);
      ((Path)localObject1).lineTo(30.357143F, 62.732559F);
      ((Path)localObject1).lineTo(36.642857F, 62.732559F);
      ((Path)localObject1).lineTo(36.642857F, 54.418606F);
      ((Path)localObject1).lineTo(30.357143F, 54.418606F);
      ((Path)localObject1).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject1, 2);
      localCanvas.drawPath((Path)localObject1, localPaint1);
      localCanvas.restore();
      localCanvas.restore();
      c.h(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.cq
 * JD-Core Version:    0.7.0.1
 */