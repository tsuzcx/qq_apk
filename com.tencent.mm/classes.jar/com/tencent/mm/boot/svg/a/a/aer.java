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

public final class aer
  extends c
{
  private final int height = 20;
  private final int width = 15;
  
  public final int a(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 15;
      return 20;
      Canvas localCanvas = (Canvas)paramVarArgs[0];
      paramVarArgs = (Looper)paramVarArgs[1];
      Object localObject1 = c.j(paramVarArgs);
      float[] arrayOfFloat = c.i(paramVarArgs);
      Object localObject2 = c.m(paramVarArgs);
      ((Paint)localObject2).setFlags(385);
      ((Paint)localObject2).setStyle(Paint.Style.FILL);
      Paint localPaint = c.m(paramVarArgs);
      localPaint.setFlags(385);
      localPaint.setStyle(Paint.Style.STROKE);
      ((Paint)localObject2).setColor(-16777216);
      localPaint.setStrokeWidth(1.0F);
      localPaint.setStrokeCap(Paint.Cap.BUTT);
      localPaint.setStrokeJoin(Paint.Join.MITER);
      localPaint.setStrokeMiter(4.0F);
      localPaint.setPathEffect(null);
      localCanvas.save();
      c.a(localPaint, paramVarArgs).setStrokeWidth(1.0F);
      arrayOfFloat = c.a(arrayOfFloat, 1.0F, 0.0F, -278.0F, 0.0F, 1.0F, -114.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject1 = c.a((Paint)localObject2, paramVarArgs);
      ((Paint)localObject1).setColor(-1);
      localObject2 = c.n(paramVarArgs);
      ((Path)localObject2).moveTo(286.10001F, 115.88284F);
      ((Path)localObject2).lineTo(286.10001F, 125.12132F);
      ((Path)localObject2).lineTo(284.89999F, 125.12132F);
      ((Path)localObject2).lineTo(284.89999F, 115.88285F);
      ((Path)localObject2).lineTo(282.81299F, 117.96985F);
      ((Path)localObject2).lineTo(281.96448F, 117.12132F);
      ((Path)localObject2).lineTo(284.79291F, 114.29289F);
      ((Path)localObject2).cubicTo(285.18341F, 113.90237F, 285.81659F, 113.90237F, 286.20709F, 114.29289F);
      ((Path)localObject2).lineTo(286.34854F, 114.43432F);
      ((Path)localObject2).lineTo(289.03552F, 117.12132F);
      ((Path)localObject2).lineTo(288.18701F, 117.96985F);
      ((Path)localObject2).lineTo(286.10001F, 115.88284F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(281.0F, 118.62132F);
      ((Path)localObject2).lineTo(281.0F, 119.82132F);
      ((Path)localObject2).lineTo(279.20001F, 119.82132F);
      ((Path)localObject2).lineTo(279.20001F, 132.42133F);
      ((Path)localObject2).lineTo(291.79999F, 132.42133F);
      ((Path)localObject2).lineTo(291.79999F, 119.82132F);
      ((Path)localObject2).lineTo(290.0F, 119.82132F);
      ((Path)localObject2).lineTo(290.0F, 118.62132F);
      ((Path)localObject2).lineTo(292.00104F, 118.62132F);
      ((Path)localObject2).cubicTo(292.55087F, 118.62132F, 293.0F, 119.06716F, 293.0F, 119.61713F);
      ((Path)localObject2).lineTo(293.0F, 132.62552F);
      ((Path)localObject2).cubicTo(293.0F, 133.17239F, 292.55417F, 133.62132F, 292.00418F, 133.62132F);
      ((Path)localObject2).lineTo(278.99582F, 133.62132F);
      ((Path)localObject2).cubicTo(278.44891F, 133.62132F, 278.0F, 133.17548F, 278.0F, 132.62552F);
      ((Path)localObject2).lineTo(278.0F, 119.61713F);
      ((Path)localObject2).cubicTo(278.0F, 119.07024F, 278.44724F, 118.62132F, 278.99896F, 118.62132F);
      ((Path)localObject2).lineTo(281.0F, 118.62132F);
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
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.aer
 * JD-Core Version:    0.7.0.1
 */