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

public final class jm
  extends c
{
  private final int height = 56;
  private final int width = 89;
  
  public final int a(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 89;
      return 56;
      Canvas localCanvas = (Canvas)paramVarArgs[0];
      paramVarArgs = (Looper)paramVarArgs[1];
      Object localObject1 = c.j(paramVarArgs);
      Object localObject2 = c.i(paramVarArgs);
      Paint localPaint1 = c.m(paramVarArgs);
      localPaint1.setFlags(385);
      localPaint1.setStyle(Paint.Style.FILL);
      Paint localPaint2 = c.m(paramVarArgs);
      localPaint2.setFlags(385);
      localPaint2.setStyle(Paint.Style.STROKE);
      localPaint1.setColor(-16777216);
      localPaint2.setStrokeWidth(1.0F);
      localPaint2.setStrokeCap(Paint.Cap.BUTT);
      localPaint2.setStrokeJoin(Paint.Join.MITER);
      localPaint2.setStrokeMiter(4.0F);
      localPaint2.setPathEffect(null);
      c.a(localPaint2, paramVarArgs).setStrokeWidth(1.0F);
      localCanvas.save();
      localObject2 = c.a((float[])localObject2, 1.0F, 0.0F, 1.0F, 0.0F, 1.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject2);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject1 = c.a(localPaint1, paramVarArgs);
      ((Paint)localObject1).setColor(-372399);
      localObject2 = c.n(paramVarArgs);
      ((Path)localObject2).moveTo(0.0F, 27.0F);
      ((Path)localObject2).cubicTo(0.0F, 12.088312F, 12.096977F, 0.0F, 26.990974F, 0.0F);
      ((Path)localObject2).lineTo(60.009026F, 0.0F);
      ((Path)localObject2).cubicTo(74.915726F, 0.0F, 87.0F, 12.085033F, 87.0F, 27.0F);
      ((Path)localObject2).lineTo(87.0F, 27.0F);
      ((Path)localObject2).cubicTo(87.0F, 41.91169F, 74.903023F, 54.0F, 60.009026F, 54.0F);
      ((Path)localObject2).lineTo(26.990974F, 54.0F);
      ((Path)localObject2).cubicTo(12.084271F, 54.0F, 0.0F, 41.914967F, 0.0F, 27.0F);
      ((Path)localObject2).lineTo(0.0F, 27.0F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 2);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.save();
      localPaint1 = c.a(localPaint1, paramVarArgs);
      localPaint1.setColor(-1);
      localObject1 = c.n(paramVarArgs);
      ((Path)localObject1).moveTo(30.299999F, 24.0F);
      ((Path)localObject1).cubicTo(31.200001F, 24.0F, 31.98F, 24.299999F, 32.639999F, 24.959999F);
      ((Path)localObject1).cubicTo(33.27F, 25.59F, 33.599998F, 26.370001F, 33.599998F, 27.27F);
      ((Path)localObject1).cubicTo(33.599998F, 28.17F, 33.27F, 28.92F, 32.639999F, 29.58F);
      ((Path)localObject1).cubicTo(31.98F, 30.24F, 31.200001F, 30.57F, 30.299999F, 30.57F);
      ((Path)localObject1).cubicTo(29.4F, 30.57F, 28.620001F, 30.24F, 27.959999F, 29.58F);
      ((Path)localObject1).cubicTo(27.299999F, 28.92F, 27.0F, 28.17F, 27.0F, 27.27F);
      ((Path)localObject1).cubicTo(27.0F, 26.370001F, 27.299999F, 25.59F, 27.959999F, 24.959999F);
      ((Path)localObject1).cubicTo(28.59F, 24.299999F, 29.370001F, 24.0F, 30.299999F, 24.0F);
      ((Path)localObject1).close();
      ((Path)localObject1).moveTo(42.900002F, 24.0F);
      ((Path)localObject1).cubicTo(43.799999F, 24.0F, 44.580002F, 24.299999F, 45.240002F, 24.959999F);
      ((Path)localObject1).cubicTo(45.869999F, 25.59F, 46.200001F, 26.370001F, 46.200001F, 27.27F);
      ((Path)localObject1).cubicTo(46.200001F, 28.17F, 45.869999F, 28.92F, 45.240002F, 29.58F);
      ((Path)localObject1).cubicTo(44.580002F, 30.24F, 43.799999F, 30.57F, 42.900002F, 30.57F);
      ((Path)localObject1).cubicTo(42.0F, 30.57F, 41.220001F, 30.24F, 40.560001F, 29.58F);
      ((Path)localObject1).cubicTo(39.900002F, 28.92F, 39.599998F, 28.17F, 39.599998F, 27.27F);
      ((Path)localObject1).cubicTo(39.599998F, 26.370001F, 39.900002F, 25.59F, 40.560001F, 24.959999F);
      ((Path)localObject1).cubicTo(41.189999F, 24.299999F, 41.970001F, 24.0F, 42.900002F, 24.0F);
      ((Path)localObject1).close();
      ((Path)localObject1).moveTo(55.5F, 24.0F);
      ((Path)localObject1).cubicTo(56.400002F, 24.0F, 57.18F, 24.299999F, 57.84F, 24.959999F);
      ((Path)localObject1).cubicTo(58.470001F, 25.59F, 58.799999F, 26.370001F, 58.799999F, 27.27F);
      ((Path)localObject1).cubicTo(58.799999F, 28.17F, 58.470001F, 28.92F, 57.84F, 29.58F);
      ((Path)localObject1).cubicTo(57.18F, 30.24F, 56.400002F, 30.57F, 55.5F, 30.57F);
      ((Path)localObject1).cubicTo(54.599998F, 30.57F, 53.82F, 30.24F, 53.16F, 29.58F);
      ((Path)localObject1).cubicTo(52.5F, 28.92F, 52.200001F, 28.17F, 52.200001F, 27.27F);
      ((Path)localObject1).cubicTo(52.200001F, 26.370001F, 52.5F, 25.59F, 53.16F, 24.959999F);
      ((Path)localObject1).cubicTo(53.790001F, 24.299999F, 54.57F, 24.0F, 55.5F, 24.0F);
      ((Path)localObject1).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject1, 2);
      localCanvas.drawPath((Path)localObject1, localPaint1);
      localCanvas.restore();
      localCanvas.restore();
      c.l(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.jm
 * JD-Core Version:    0.7.0.1
 */