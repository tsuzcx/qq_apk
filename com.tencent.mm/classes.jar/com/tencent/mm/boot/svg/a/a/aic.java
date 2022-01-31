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

public final class aic
  extends c
{
  private final int height = 168;
  private final int width = 168;
  
  protected final int b(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 168;
      return 168;
      Canvas localCanvas = (Canvas)paramVarArgs[0];
      paramVarArgs = (Looper)paramVarArgs[1];
      Object localObject1 = c.f(paramVarArgs);
      Object localObject3 = c.e(paramVarArgs);
      Object localObject2 = c.i(paramVarArgs);
      ((Paint)localObject2).setFlags(385);
      ((Paint)localObject2).setStyle(Paint.Style.FILL);
      Paint localPaint = c.i(paramVarArgs);
      localPaint.setFlags(385);
      localPaint.setStyle(Paint.Style.STROKE);
      ((Paint)localObject2).setColor(-16777216);
      localPaint.setStrokeWidth(1.0F);
      localPaint.setStrokeCap(Paint.Cap.BUTT);
      localPaint.setStrokeJoin(Paint.Join.MITER);
      localPaint.setStrokeMiter(4.0F);
      localPaint.setPathEffect(null);
      c.a(localPaint, paramVarArgs).setStrokeWidth(1.0F);
      localObject2 = c.a((Paint)localObject2, paramVarArgs);
      ((Paint)localObject2).setColor(-8617594);
      localCanvas.save();
      localObject3 = c.a((float[])localObject3, 1.0F, 0.0F, 45.0F, 0.0F, 1.0F, 46.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject3);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject1 = c.a((Paint)localObject2, paramVarArgs);
      localObject3 = c.j(paramVarArgs);
      ((Path)localObject3).moveTo(42.0F, 2.0F);
      ((Path)localObject3).cubicTo(42.0F, 1.526703F, 42.533726F, 1.0F, 43.0F, 1.0F);
      ((Path)localObject3).lineTo(66.0F, 1.0F);
      ((Path)localObject3).cubicTo(66.467674F, 1.0F, 67.0F, 1.524671F, 67.0F, 2.0F);
      ((Path)localObject3).lineTo(67.0F, 20.0F);
      ((Path)localObject3).cubicTo(67.0F, 20.473297F, 66.46627F, 21.0F, 66.0F, 21.0F);
      ((Path)localObject3).lineTo(43.0F, 21.0F);
      ((Path)localObject3).cubicTo(42.532326F, 21.0F, 42.0F, 20.475328F, 42.0F, 20.0F);
      ((Path)localObject3).lineTo(42.0F, 2.0F);
      ((Path)localObject3).close();
      ((Path)localObject3).moveTo(77.0F, 23.0F);
      ((Path)localObject3).cubicTo(78.131439F, 23.242155F, 79.0F, 22.596409F, 79.0F, 22.0F);
      ((Path)localObject3).lineTo(79.0F, 1.0F);
      ((Path)localObject3).cubicTo(79.0F, 0.2719795F, 78.039513F, -0.1921499F, 77.0F, 0.0F);
      ((Path)localObject3).cubicTo(76.582535F, 0.5564573F, 72.149612F, 4.76049F, 69.0F, 8.0F);
      ((Path)localObject3).lineTo(69.0F, 15.0F);
      ((Path)localObject3).cubicTo(72.226425F, 18.18812F, 76.758263F, 22.516397F, 77.0F, 23.0F);
      ((Path)localObject3).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject3, 2);
      localCanvas.drawPath((Path)localObject3, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.save();
      localObject1 = c.a((Paint)localObject2, paramVarArgs);
      localObject2 = c.j(paramVarArgs);
      ((Path)localObject2).moveTo(29.119242F, 46.28759F);
      ((Path)localObject2).cubicTo(36.86187F, 54.187935F, 44.198097F, 57.893478F, 46.911064F, 57.676479F);
      ((Path)localObject2).cubicTo(49.624031F, 57.459484F, 56.380077F, 52.718697F, 59.569485F, 52.781796F);
      ((Path)localObject2).cubicTo(61.102341F, 52.812122F, 71.11908F, 59.724438F, 72.331604F, 60.523617F);
      ((Path)localObject2).cubicTo(73.544128F, 61.322792F, 74.668411F, 62.256332F, 74.457008F, 63.437634F);
      ((Path)localObject2).cubicTo(74.245605F, 64.618935F, 69.843369F, 77.630943F, 58.60445F, 75.829079F);
      ((Path)localObject2).cubicTo(47.36554F, 74.027214F, 31.696922F, 61.664673F, 22.76856F, 52.767635F);
      ((Path)localObject2).lineTo(29.119242F, 46.28759F);
      ((Path)localObject2).lineTo(29.119242F, 46.28759F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(29.119242F, 46.28759F);
      ((Path)localObject2).cubicTo(21.376614F, 38.387241F, 17.74505F, 30.901573F, 17.957714F, 28.133341F);
      ((Path)localObject2).cubicTo(18.170378F, 25.365108F, 22.816525F, 18.471439F, 22.754683F, 15.217063F);
      ((Path)localObject2).cubicTo(22.72496F, 13.652983F, 15.950641F, 3.4322F, 15.167418F, 2.194974F);
      ((Path)localObject2).cubicTo(14.384195F, 0.9577476F, 13.469295F, -0.1894346F, 12.311576F, 0.0262743F);
      ((Path)localObject2).cubicTo(11.153858F, 0.2419832F, -1.598383F, 4.7339F, 0.1675102F, 16.201754F);
      ((Path)localObject2).cubicTo(1.933403F, 27.669609F, 14.049142F, 43.657398F, 22.76856F, 52.767635F);
      ((Path)localObject2).lineTo(29.119242F, 46.28759F);
      ((Path)localObject2).lineTo(29.119242F, 46.28759F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 2);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.restore();
      c.h(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.aic
 * JD-Core Version:    0.7.0.1
 */