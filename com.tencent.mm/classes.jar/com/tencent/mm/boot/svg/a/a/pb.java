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

public final class pb
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
      c.a(localPaint, paramVarArgs).setStrokeWidth(1.0F);
      localCanvas.saveLayerAlpha(null, 230, 31);
      localCanvas.save();
      arrayOfFloat = c.a(arrayOfFloat, -1.0F, 0.0F, 72.0F, 0.0F, 1.0F, 0.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.restore();
      localCanvas.save();
      localObject1 = c.a((Paint)localObject2, paramVarArgs);
      ((Paint)localObject1).setColor(-16777216);
      localObject2 = c.n(paramVarArgs);
      ((Path)localObject2).moveTo(34.667442F, 20.4F);
      ((Path)localObject2).cubicTo(38.549126F, 24.392387F, 40.950001F, 29.907822F, 40.950001F, 36.0F);
      ((Path)localObject2).cubicTo(40.950001F, 42.092178F, 38.549126F, 47.607613F, 34.667442F, 51.599998F);
      ((Path)localObject2).lineTo(31.167261F, 48.0F);
      ((Path)localObject2).cubicTo(34.153175F, 44.928932F, 36.0F, 40.686291F, 36.0F, 36.0F);
      ((Path)localObject2).cubicTo(36.0F, 31.313709F, 34.153175F, 27.071068F, 31.167261F, 24.0F);
      ((Path)localObject2).lineTo(34.667442F, 20.4F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(26.500357F, 28.799999F);
      ((Path)localObject2).cubicTo(28.291904F, 30.642641F, 29.4F, 33.188225F, 29.4F, 36.0F);
      ((Path)localObject2).cubicTo(29.4F, 38.811775F, 28.291904F, 41.357361F, 26.500357F, 43.200001F);
      ((Path)localObject2).lineTo(19.5F, 36.0F);
      ((Path)localObject2).lineTo(26.500357F, 28.799999F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 1);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.restore();
      c.l(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.pb
 * JD-Core Version:    0.7.0.1
 */