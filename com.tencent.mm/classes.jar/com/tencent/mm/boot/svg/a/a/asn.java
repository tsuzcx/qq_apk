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

public final class asn
  extends c
{
  private final int height = 36;
  private final int width = 46;
  
  public final int a(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 46;
      return 36;
      Canvas localCanvas = (Canvas)paramVarArgs[0];
      paramVarArgs = (Looper)paramVarArgs[1];
      Object localObject1 = c.h(paramVarArgs);
      Object localObject3 = c.g(paramVarArgs);
      Object localObject2 = c.k(paramVarArgs);
      ((Paint)localObject2).setFlags(385);
      ((Paint)localObject2).setStyle(Paint.Style.FILL);
      Paint localPaint = c.k(paramVarArgs);
      localPaint.setFlags(385);
      localPaint.setStyle(Paint.Style.STROKE);
      ((Paint)localObject2).setColor(-16777216);
      localPaint.setStrokeWidth(1.0F);
      localPaint.setStrokeCap(Paint.Cap.BUTT);
      localPaint.setStrokeJoin(Paint.Join.MITER);
      localPaint.setStrokeMiter(4.0F);
      localPaint.setPathEffect(null);
      c.a(localPaint, paramVarArgs).setStrokeWidth(1.0F);
      localCanvas.save();
      localObject2 = c.a((Paint)localObject2, paramVarArgs);
      ((Paint)localObject2).setColor(-9205837);
      localObject3 = c.a((float[])localObject3, 1.0F, 0.0F, 1.0F, 0.0F, 1.0F, 0.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject3);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject1 = c.a((Paint)localObject2, paramVarArgs);
      localObject3 = c.l(paramVarArgs);
      ((Path)localObject3).moveTo(5.990267F, 0.0F);
      ((Path)localObject3).lineTo(37.955051F, 0.0F);
      ((Path)localObject3).cubicTo(40.559513F, 1.758437F, 40.860031F, 5.144684F, 42.122192F, 7.797411F);
      ((Path)localObject3).cubicTo(43.063805F, 10.480284F, 45.127342F, 13.555036F, 43.214066F, 16.308245F);
      ((Path)localObject3).cubicTo(40.839996F, 20.166758F, 35.060089F, 19.654299F, 32.565815F, 16.187666F);
      ((Path)localObject3).cubicTo(30.011436F, 19.634203F, 25.123058F, 19.865311F, 22.037769F, 17.021667F);
      ((Path)localObject3).cubicTo(18.942465F, 19.87536F, 14.074121F, 19.614107F, 11.52976F, 16.187666F);
      ((Path)localObject3).cubicTo(8.604748F, 20.4883F, 1.312249F, 19.734684F, 0.0F, 14.459374F);
      ((Path)localObject3).lineTo(0.0F, 12.891853F);
      ((Path)localObject3).cubicTo(2.093588F, 8.671605F, 2.574412F, 3.42644F, 5.990267F, 0.0F);
      ((Path)localObject3).lineTo(5.990267F, 0.0F);
      ((Path)localObject3).close();
      ((Path)localObject3).moveTo(7.052535F, 3.0F);
      ((Path)localObject3).cubicTo(5.774889F, 6.68386F, 4.008143F, 10.197542F, 3.0F, 13.971498F);
      ((Path)localObject3).cubicTo(4.307591F, 17.214895F, 8.759391F, 16.0737F, 9.617809F, 13.100585F);
      ((Path)localObject3).cubicTo(10.835567F, 13.080564F, 12.053323F, 13.020501F, 13.27108F, 12.910385F);
      ((Path)localObject3).cubicTo(14.119516F, 14.65221F, 15.756501F, 16.484131F, 17.912529F, 15.883501F);
      ((Path)localObject3).cubicTo(19.848963F, 15.112693F, 20.777252F, 13.00048F, 22.004992F, 11.448853F);
      ((Path)localObject3).cubicTo(23.402416F, 13.110595F, 24.470449F, 16.013638F, 27.025742F, 15.933554F);
      ((Path)localObject3).cubicTo(28.902285F, 16.153784F, 29.750723F, 14.251791F, 30.698977F, 13.030511F);
      ((Path)localObject3).lineTo(34.272392F, 13.030511F);
      ((Path)localObject3).cubicTo(35.260574F, 15.923543F, 39.592594F, 17.315001F, 41.0F, 13.981508F);
      ((Path)localObject3).cubicTo(40.021801F, 10.207553F, 38.235092F, 6.68386F, 36.96743F, 3.0F);
      ((Path)localObject3).lineTo(7.052535F, 3.0F);
      ((Path)localObject3).lineTo(7.052535F, 3.0F);
      ((Path)localObject3).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject3, 2);
      localCanvas.drawPath((Path)localObject3, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.save();
      localObject1 = c.a((Paint)localObject2, paramVarArgs);
      localObject2 = c.l(paramVarArgs);
      ((Path)localObject2).moveTo(4.0F, 21.0F);
      ((Path)localObject2).lineTo(7.0F, 21.0F);
      ((Path)localObject2).cubicTo(6.99F, 25.0F, 7.01F, 29.0F, 7.0F, 33.0F);
      ((Path)localObject2).cubicTo(17.0F, 32.990002F, 27.0F, 32.990002F, 37.0F, 33.0F);
      ((Path)localObject2).cubicTo(36.990002F, 29.0F, 37.009998F, 25.0F, 37.0F, 21.0F);
      ((Path)localObject2).lineTo(40.0F, 21.0F);
      ((Path)localObject2).lineTo(40.0F, 36.0F);
      ((Path)localObject2).lineTo(4.0F, 36.0F);
      ((Path)localObject2).lineTo(4.0F, 21.0F);
      ((Path)localObject2).lineTo(4.0F, 21.0F);
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
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.asn
 * JD-Core Version:    0.7.0.1
 */