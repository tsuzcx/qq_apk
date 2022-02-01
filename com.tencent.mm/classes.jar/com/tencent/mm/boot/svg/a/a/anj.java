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

public final class anj
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
      localCanvas.save();
      arrayOfFloat = c.a(arrayOfFloat, 1.0F, 0.0F, 7.0F, 0.0F, 1.0F, 12.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject1 = c.a((Paint)localObject2, paramVarArgs);
      ((Paint)localObject1).setColor(-1);
      localObject2 = c.n(paramVarArgs);
      ((Path)localObject2).moveTo(55.334522F, 27.0F);
      ((Path)localObject2).lineTo(61.698486F, 33.36396F);
      ((Path)localObject2).lineTo(43.879395F, 51.183052F);
      ((Path)localObject2).cubicTo(43.566975F, 51.495472F, 43.168282F, 51.669037F, 42.760006F, 51.703751F);
      ((Path)localObject2).lineTo(42.606602F, 51.710258F);
      ((Path)localObject2).cubicTo(42.145943F, 51.710258F, 41.68528F, 51.534523F, 41.333809F, 51.183052F);
      ((Path)localObject2).lineTo(32.0F, 41.849243F);
      ((Path)localObject2).lineTo(38.36396F, 35.485283F);
      ((Path)localObject2).lineTo(42.605999F, 39.727001F);
      ((Path)localObject2).lineTo(55.334522F, 27.0F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(29.0F, 39.0F);
      ((Path)localObject2).lineTo(29.0F, 48.0F);
      ((Path)localObject2).lineTo(14.0F, 48.0F);
      ((Path)localObject2).lineTo(14.0F, 39.0F);
      ((Path)localObject2).lineTo(29.0F, 39.0F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(9.5F, 39.0F);
      ((Path)localObject2).lineTo(9.5F, 48.0F);
      ((Path)localObject2).lineTo(0.5F, 48.0F);
      ((Path)localObject2).lineTo(0.5F, 39.0F);
      ((Path)localObject2).lineTo(9.5F, 39.0F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(47.0F, 19.5F);
      ((Path)localObject2).lineTo(47.0F, 28.5F);
      ((Path)localObject2).lineTo(14.0F, 28.5F);
      ((Path)localObject2).lineTo(14.0F, 19.5F);
      ((Path)localObject2).lineTo(47.0F, 19.5F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(9.5F, 19.5F);
      ((Path)localObject2).lineTo(9.5F, 28.5F);
      ((Path)localObject2).lineTo(0.5F, 28.5F);
      ((Path)localObject2).lineTo(0.5F, 19.5F);
      ((Path)localObject2).lineTo(9.5F, 19.5F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(53.0F, 0.0F);
      ((Path)localObject2).lineTo(53.0F, 9.0F);
      ((Path)localObject2).lineTo(14.0F, 9.0F);
      ((Path)localObject2).lineTo(14.0F, 0.0F);
      ((Path)localObject2).lineTo(53.0F, 0.0F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(9.5F, 0.0F);
      ((Path)localObject2).lineTo(9.5F, 9.0F);
      ((Path)localObject2).lineTo(0.5F, 9.0F);
      ((Path)localObject2).lineTo(0.5F, 0.0F);
      ((Path)localObject2).lineTo(9.5F, 0.0F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 2);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.restore();
      c.l(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.anj
 * JD-Core Version:    0.7.0.1
 */