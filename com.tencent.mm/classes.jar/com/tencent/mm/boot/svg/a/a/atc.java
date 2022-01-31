package com.tencent.mm.boot.svg.a.a;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;

public final class atc
  extends c
{
  private final int height = 96;
  private final int width = 96;
  
  protected final int b(int paramInt, Object... paramVarArgs)
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
      c.f(paramVarArgs);
      c.e(paramVarArgs);
      Paint localPaint = c.i(paramVarArgs);
      localPaint.setFlags(385);
      localPaint.setStyle(Paint.Style.FILL);
      Object localObject = c.i(paramVarArgs);
      ((Paint)localObject).setFlags(385);
      ((Paint)localObject).setStyle(Paint.Style.STROKE);
      localPaint.setColor(-16777216);
      ((Paint)localObject).setStrokeWidth(1.0F);
      ((Paint)localObject).setStrokeCap(Paint.Cap.BUTT);
      ((Paint)localObject).setStrokeJoin(Paint.Join.MITER);
      ((Paint)localObject).setStrokeMiter(4.0F);
      ((Paint)localObject).setPathEffect(null);
      c.a((Paint)localObject, paramVarArgs).setStrokeWidth(1.0F);
      localPaint = c.a(localPaint, paramVarArgs);
      localPaint.setColor(-8286571);
      localCanvas.save();
      localPaint = c.a(localPaint, paramVarArgs);
      localObject = c.j(paramVarArgs);
      ((Path)localObject).moveTo(80.99659F, 75.898659F);
      ((Path)localObject).cubicTo(80.944244F, 70.920204F, 79.929207F, 69.644585F, 63.000206F, 60.301033F);
      ((Path)localObject).cubicTo(59.50676F, 58.372242F, 52.14093F, 55.336243F, 57.002171F, 48.349346F);
      ((Path)localObject).cubicTo(57.38224F, 47.801998F, 57.622345F, 47.250103F, 57.758896F, 46.699345F);
      ((Path)localObject).cubicTo(60.690208F, 43.234344F, 62.828381F, 38.70993F, 62.974033F, 34.499588F);
      ((Path)localObject).lineTo(63.001347F, 34.499588F);
      ((Path)localObject).lineTo(63.001347F, 28.500414F);
      ((Path)localObject).lineTo(62.930794F, 28.500414F);
      ((Path)localObject).cubicTo(62.221863F, 18.878069F, 54.32576F, 15.0F, 48.001137F, 15.0F);
      ((Path)localObject).cubicTo(41.669689F, 15.0F, 33.765621F, 18.660725F, 33.069206F, 28.500414F);
      ((Path)localObject).lineTo(33.000931F, 28.500414F);
      ((Path)localObject).lineTo(33.000931F, 34.499588F);
      ((Path)localObject).lineTo(33.02824F, 34.499588F);
      ((Path)localObject).cubicTo(33.173897F, 38.70993F, 35.312069F, 43.234344F, 38.243378F, 46.699345F);
      ((Path)localObject).cubicTo(38.379932F, 47.248966F, 38.618896F, 47.801998F, 39.000103F, 48.349346F);
      ((Path)localObject).cubicTo(43.860207F, 55.336243F, 36.494381F, 58.373379F, 33.002068F, 60.301033F);
      ((Path)localObject).cubicTo(16.073069F, 69.644585F, 15.058035F, 70.920204F, 15.00569F, 75.898659F);
      ((Path)localObject).cubicTo(15.00569F, 75.908897F, 15.002275F, 75.919136F, 15.002275F, 75.930519F);
      ((Path)localObject).lineTo(15.002275F, 77.068451F);
      ((Path)localObject).cubicTo(15.002275F, 79.23848F, 16.762655F, 80.998863F, 18.933828F, 80.998863F);
      ((Path)localObject).lineTo(77.070724F, 80.998863F);
      ((Path)localObject).cubicTo(79.241898F, 80.998863F, 81.002274F, 79.23848F, 81.002274F, 77.068451F);
      ((Path)localObject).lineTo(81.002274F, 75.930519F);
      ((Path)localObject).cubicTo(81.0F, 75.920273F, 80.99659F, 75.910034F, 80.99659F, 75.898659F);
      ((Path)localObject).lineTo(80.99659F, 75.898659F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 2);
      localCanvas.drawPath((Path)localObject, localPaint);
      localCanvas.restore();
      c.h(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.atc
 * JD-Core Version:    0.7.0.1
 */