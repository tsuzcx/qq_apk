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

public final class gf
  extends c
{
  private final int height = 192;
  private final int width = 192;
  
  protected final int b(int paramInt, Object... paramVarArgs)
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
      localPaint1 = c.a(localPaint1, paramVarArgs);
      localPaint1.setColor(-8421505);
      localCanvas.save();
      localObject2 = c.a((float[])localObject2, 1.0F, 0.0F, 52.0F, 0.0F, 1.0F, 60.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject2);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject1 = c.a(localPaint1, paramVarArgs);
      localObject2 = c.j(paramVarArgs);
      ((Path)localObject2).moveTo(51.209858F, 40.059639F);
      ((Path)localObject2).lineTo(3.504289F, 40.059639F);
      ((Path)localObject2).cubicTo(1.852776F, 40.059639F, 0.5F, 41.4067F, 0.5F, 43.068378F);
      ((Path)localObject2).lineTo(0.5F, 48.061665F);
      ((Path)localObject2).cubicTo(0.5F, 49.720272F, 1.845066F, 51.070408F, 3.504289F, 51.070408F);
      ((Path)localObject2).lineTo(46.778919F, 51.070408F);
      ((Path)localObject2).cubicTo(46.361961F, 58.577297F, 45.623863F, 68.698906F, 45.507942F, 69.592232F);
      ((Path)localObject2).cubicTo(45.34903F, 71.239311F, 47.599426F, 71.774551F, 50.015602F, 69.592232F);
      ((Path)localObject2).cubicTo(52.308044F, 67.733063F, 84.494987F, 45.123127F, 86.076859F, 42.994579F);
      ((Path)localObject2).cubicTo(88.448029F, 42.097687F, 87.434166F, 40.06258F, 86.076859F, 40.039284F);
      ((Path)localObject2).cubicTo(83.053604F, 40.02327F, 53.310036F, 40.061066F, 51.518154F, 40.039284F);
      ((Path)localObject2).cubicTo(51.416916F, 40.039772F, 51.314011F, 40.046738F, 51.209858F, 40.059639F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(36.790142F, 31.010767F);
      ((Path)localObject2).lineTo(84.495712F, 31.010767F);
      ((Path)localObject2).cubicTo(86.147224F, 31.010767F, 87.5F, 29.663708F, 87.5F, 28.002028F);
      ((Path)localObject2).lineTo(87.5F, 23.008741F);
      ((Path)localObject2).cubicTo(87.5F, 21.350136F, 86.154938F, 20.0F, 84.495712F, 20.0F);
      ((Path)localObject2).lineTo(41.221081F, 20.0F);
      ((Path)localObject2).cubicTo(41.638039F, 12.493111F, 42.376137F, 2.371502F, 42.492058F, 1.478172F);
      ((Path)localObject2).cubicTo(42.65097F, -0.1689065F, 40.400574F, -0.7041423F, 37.984398F, 1.478172F);
      ((Path)localObject2).cubicTo(35.691956F, 3.337342F, 3.505013F, 25.947277F, 1.923139F, 28.075827F);
      ((Path)localObject2).cubicTo(-0.4480297F, 28.972721F, 0.5658374F, 31.007828F, 1.923139F, 31.031122F);
      ((Path)localObject2).cubicTo(4.946396F, 31.047138F, 34.689964F, 31.009338F, 36.481846F, 31.031122F);
      ((Path)localObject2).cubicTo(36.583084F, 31.030634F, 36.685989F, 31.02367F, 36.790142F, 31.010767F);
      ((Path)localObject2).lineTo(36.790142F, 31.010767F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 2);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.restore();
      c.h(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.gf
 * JD-Core Version:    0.7.0.1
 */