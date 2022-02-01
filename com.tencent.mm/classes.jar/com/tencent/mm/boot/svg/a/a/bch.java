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

public final class bch
  extends c
{
  private final int height = 32;
  private final int width = 32;
  
  public final int a(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 32;
      return 32;
      Canvas localCanvas = (Canvas)paramVarArgs[0];
      paramVarArgs = (Looper)paramVarArgs[1];
      Object localObject1 = c.j(paramVarArgs);
      float[] arrayOfFloat = c.i(paramVarArgs);
      Paint localPaint = c.m(paramVarArgs);
      localPaint.setFlags(385);
      localPaint.setStyle(Paint.Style.FILL);
      Object localObject2 = c.m(paramVarArgs);
      ((Paint)localObject2).setFlags(385);
      ((Paint)localObject2).setStyle(Paint.Style.STROKE);
      localPaint.setColor(-16777216);
      ((Paint)localObject2).setStrokeWidth(1.0F);
      ((Paint)localObject2).setStrokeCap(Paint.Cap.BUTT);
      ((Paint)localObject2).setStrokeJoin(Paint.Join.MITER);
      ((Paint)localObject2).setStrokeMiter(4.0F);
      ((Paint)localObject2).setPathEffect(null);
      c.a((Paint)localObject2, paramVarArgs).setStrokeWidth(1.0F);
      localObject2 = c.n(paramVarArgs);
      ((Path)localObject2).moveTo(0.0F, 0.0F);
      ((Path)localObject2).lineTo(32.0F, 0.0F);
      ((Path)localObject2).lineTo(32.0F, 32.0F);
      ((Path)localObject2).lineTo(0.0F, 32.0F);
      ((Path)localObject2).lineTo(0.0F, 0.0F);
      ((Path)localObject2).close();
      localCanvas.save();
      localPaint = c.a(localPaint, paramVarArgs);
      localPaint.setColor(-1);
      arrayOfFloat = c.a(arrayOfFloat, -1.83697E-016F, -1.0F, 33.0F, 1.0F, -1.83697E-016F, -1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject1);
      localObject1 = c.n(paramVarArgs);
      ((Path)localObject1).moveTo(17.83205F, 11.248075F);
      ((Path)localObject1).lineTo(23.963533F, 20.445299F);
      ((Path)localObject1).cubicTo(24.269886F, 20.904829F, 24.145712F, 21.525698F, 23.686184F, 21.83205F);
      ((Path)localObject1).cubicTo(23.521915F, 21.941563F, 23.328907F, 22.0F, 23.131483F, 22.0F);
      ((Path)localObject1).lineTo(10.868517F, 22.0F);
      ((Path)localObject1).cubicTo(10.316233F, 22.0F, 9.868517F, 21.552284F, 9.868517F, 21.0F);
      ((Path)localObject1).cubicTo(9.868517F, 20.802574F, 9.926955F, 20.609568F, 10.036467F, 20.445299F);
      ((Path)localObject1).lineTo(16.16795F, 11.248075F);
      ((Path)localObject1).cubicTo(16.474302F, 10.788547F, 17.095171F, 10.664372F, 17.554701F, 10.970725F);
      ((Path)localObject1).cubicTo(17.664553F, 11.043961F, 17.758816F, 11.138224F, 17.83205F, 11.248075F);
      ((Path)localObject1).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject1, 2);
      localCanvas.drawPath((Path)localObject1, localPaint);
      localCanvas.restore();
      c.l(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.bch
 * JD-Core Version:    0.7.0.1
 */