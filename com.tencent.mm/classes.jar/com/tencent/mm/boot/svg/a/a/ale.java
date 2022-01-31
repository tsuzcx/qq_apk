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

public final class ale
  extends c
{
  private final int height = 96;
  private final int width = 96;
  
  public final int a(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 96;
      return 96;
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
      localPaint1 = c.a(localPaint1, paramVarArgs);
      localPaint1.setColor(-1);
      localCanvas.save();
      localObject2 = c.a((float[])localObject2, 1.0F, 0.0F, 11.0F, 0.0F, 1.0F, 20.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject2);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject1 = c.a(localPaint1, paramVarArgs);
      localObject2 = c.l(paramVarArgs);
      ((Path)localObject2).moveTo(58.99807F, 24.0F);
      ((Path)localObject2).lineTo(47.996223F, 24.0F);
      ((Path)localObject2).cubicTo(47.445435F, 24.0F, 46.99807F, 24.443586F, 46.99807F, 24.990778F);
      ((Path)localObject2).lineTo(46.99807F, 29.009222F);
      ((Path)localObject2).cubicTo(46.99807F, 29.549025F, 47.444958F, 30.0F, 47.996223F, 30.0F);
      ((Path)localObject2).lineTo(58.99807F, 30.0F);
      ((Path)localObject2).lineTo(58.99807F, 41.001846F);
      ((Path)localObject2).cubicTo(58.99807F, 41.552635F, 59.441654F, 42.0F, 59.988846F, 42.0F);
      ((Path)localObject2).lineTo(64.007294F, 42.0F);
      ((Path)localObject2).cubicTo(64.547096F, 42.0F, 64.99807F, 41.553112F, 64.99807F, 41.001846F);
      ((Path)localObject2).lineTo(64.99807F, 30.0F);
      ((Path)localObject2).lineTo(75.999916F, 30.0F);
      ((Path)localObject2).cubicTo(76.550705F, 30.0F, 76.99807F, 29.556414F, 76.99807F, 29.009222F);
      ((Path)localObject2).lineTo(76.99807F, 24.990778F);
      ((Path)localObject2).cubicTo(76.99807F, 24.450975F, 76.551178F, 24.0F, 75.999916F, 24.0F);
      ((Path)localObject2).lineTo(64.99807F, 24.0F);
      ((Path)localObject2).lineTo(64.99807F, 12.998154F);
      ((Path)localObject2).cubicTo(64.99807F, 12.447365F, 64.554482F, 12.0F, 64.007294F, 12.0F);
      ((Path)localObject2).lineTo(59.988846F, 12.0F);
      ((Path)localObject2).cubicTo(59.449043F, 12.0F, 58.99807F, 12.446889F, 58.99807F, 12.998154F);
      ((Path)localObject2).lineTo(58.99807F, 24.0F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(55.995171F, 51.671585F);
      ((Path)localObject2).cubicTo(55.95076F, 47.447449F, 55.089516F, 46.365105F, 40.725517F, 38.437241F);
      ((Path)localObject2).cubicTo(37.761379F, 36.80069F, 31.511587F, 34.224689F, 35.636276F, 28.296413F);
      ((Path)localObject2).cubicTo(35.958759F, 27.832001F, 36.162483F, 27.363724F, 36.278343F, 26.896414F);
      ((Path)localObject2).cubicTo(38.765518F, 23.956413F, 40.579723F, 20.117517F, 40.703312F, 16.545103F);
      ((Path)localObject2).lineTo(40.726482F, 16.545103F);
      ((Path)localObject2).lineTo(40.726482F, 11.454897F);
      ((Path)localObject2).lineTo(40.666622F, 11.454897F);
      ((Path)localObject2).cubicTo(40.065102F, 3.290483F, 33.365379F, 0.0F, 27.999035F, 0.0F);
      ((Path)localObject2).cubicTo(22.626896F, 0.0F, 15.920414F, 3.106069F, 15.329517F, 11.454897F);
      ((Path)localObject2).lineTo(15.271586F, 11.454897F);
      ((Path)localObject2).lineTo(15.271586F, 16.545103F);
      ((Path)localObject2).lineTo(15.294759F, 16.545103F);
      ((Path)localObject2).cubicTo(15.418344F, 20.117517F, 17.232552F, 23.956413F, 19.719725F, 26.896414F);
      ((Path)localObject2).cubicTo(19.835587F, 27.362759F, 20.038345F, 27.832001F, 20.361794F, 28.296413F);
      ((Path)localObject2).cubicTo(24.485518F, 34.224689F, 18.235723F, 36.801655F, 15.272552F, 38.437241F);
      ((Path)localObject2).cubicTo(0.9085518F, 46.365105F, 0.04731035F, 47.447449F, 0.002896552F, 51.671585F);
      ((Path)localObject2).cubicTo(0.002896552F, 51.680275F, 0.0F, 51.688965F, 0.0F, 51.69862F);
      ((Path)localObject2).lineTo(0.0F, 52.664139F);
      ((Path)localObject2).cubicTo(0.0F, 54.505379F, 1.493655F, 55.999035F, 3.335862F, 55.999035F);
      ((Path)localObject2).lineTo(52.664139F, 55.999035F);
      ((Path)localObject2).cubicTo(54.506344F, 55.999035F, 56.0F, 54.505379F, 56.0F, 52.664139F);
      ((Path)localObject2).lineTo(56.0F, 51.69862F);
      ((Path)localObject2).cubicTo(55.99807F, 51.68993F, 55.995171F, 51.68124F, 55.995171F, 51.671585F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 2);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.restore();
      c.j(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.ale
 * JD-Core Version:    0.7.0.1
 */