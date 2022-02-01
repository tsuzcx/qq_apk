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

public final class lx
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
      c.j(paramVarArgs);
      c.i(paramVarArgs);
      Paint localPaint = c.m(paramVarArgs);
      localPaint.setFlags(385);
      localPaint.setStyle(Paint.Style.FILL);
      Object localObject = c.m(paramVarArgs);
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
      localPaint.setColor(-8617851);
      localCanvas.save();
      localPaint = c.a(localPaint, paramVarArgs);
      localObject = c.n(paramVarArgs);
      ((Path)localObject).moveTo(72.0F, 44.0F);
      ((Path)localObject).lineTo(47.0F, 44.0F);
      ((Path)localObject).lineTo(47.0F, 52.0F);
      ((Path)localObject).lineTo(72.0F, 52.0F);
      ((Path)localObject).lineTo(72.0F, 60.0F);
      ((Path)localObject).lineTo(87.390762F, 48.0F);
      ((Path)localObject).lineTo(72.0F, 36.0F);
      ((Path)localObject).lineTo(72.0F, 44.0F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(80.0F, 26.0F);
      ((Path)localObject).lineTo(80.0F, 23.990396F);
      ((Path)localObject).cubicTo(80.0F, 17.382257F, 74.627258F, 12.0F, 67.999649F, 12.0F);
      ((Path)localObject).lineTo(28.000351F, 12.0F);
      ((Path)localObject).cubicTo(21.373957F, 12.0F, 16.0F, 17.368282F, 16.0F, 23.990396F);
      ((Path)localObject).lineTo(16.0F, 72.009605F);
      ((Path)localObject).cubicTo(16.0F, 78.617744F, 21.37274F, 84.0F, 28.000351F, 84.0F);
      ((Path)localObject).lineTo(67.999649F, 84.0F);
      ((Path)localObject).cubicTo(74.626045F, 84.0F, 80.0F, 78.631714F, 80.0F, 72.009605F);
      ((Path)localObject).lineTo(80.0F, 70.0F);
      ((Path)localObject).lineTo(72.0F, 70.0F);
      ((Path)localObject).lineTo(72.0F, 71.995094F);
      ((Path)localObject).cubicTo(72.0F, 74.20694F, 70.205948F, 76.0F, 67.990105F, 76.0F);
      ((Path)localObject).lineTo(28.009893F, 76.0F);
      ((Path)localObject).cubicTo(25.79529F, 76.0F, 24.0F, 74.200203F, 24.0F, 71.995094F);
      ((Path)localObject).lineTo(24.0F, 24.004908F);
      ((Path)localObject).cubicTo(24.0F, 21.793058F, 25.794052F, 20.0F, 28.009893F, 20.0F);
      ((Path)localObject).lineTo(67.990105F, 20.0F);
      ((Path)localObject).cubicTo(70.204712F, 20.0F, 72.0F, 21.799795F, 72.0F, 24.004908F);
      ((Path)localObject).lineTo(72.0F, 26.0F);
      ((Path)localObject).lineTo(80.0F, 26.0F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 2);
      localCanvas.drawPath((Path)localObject, localPaint);
      localCanvas.restore();
      c.l(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.lx
 * JD-Core Version:    0.7.0.1
 */