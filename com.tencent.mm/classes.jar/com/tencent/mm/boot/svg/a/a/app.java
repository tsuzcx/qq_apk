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

public final class app
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
      localPaint.setColor(-16777216);
      localCanvas.save();
      localPaint = c.a(localPaint, paramVarArgs);
      localObject = c.n(paramVarArgs);
      ((Path)localObject).moveTo(9.891169F, 34.200001F);
      ((Path)localObject).lineTo(23.527599F, 34.200001F);
      ((Path)localObject).cubicTo(24.316923F, 28.681755F, 28.681755F, 24.316923F, 34.200001F, 23.527599F);
      ((Path)localObject).lineTo(34.200001F, 9.891169F);
      ((Path)localObject).lineTo(9.891169F, 34.200001F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(37.799999F, 9.891169F);
      ((Path)localObject).lineTo(37.799999F, 23.527599F);
      ((Path)localObject).cubicTo(43.318245F, 24.316923F, 47.683079F, 28.681755F, 48.472401F, 34.200001F);
      ((Path)localObject).lineTo(62.108829F, 34.200001F);
      ((Path)localObject).lineTo(37.799999F, 9.891169F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(62.108829F, 37.799999F);
      ((Path)localObject).lineTo(48.472401F, 37.799999F);
      ((Path)localObject).cubicTo(47.683079F, 43.318245F, 43.318245F, 47.683079F, 37.799999F, 48.472401F);
      ((Path)localObject).lineTo(37.799999F, 62.108829F);
      ((Path)localObject).lineTo(62.108829F, 37.799999F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(34.200001F, 62.108829F);
      ((Path)localObject).lineTo(34.200001F, 48.472401F);
      ((Path)localObject).cubicTo(28.681755F, 47.683079F, 24.316923F, 43.318245F, 23.527599F, 37.799999F);
      ((Path)localObject).lineTo(9.891169F, 37.799999F);
      ((Path)localObject).lineTo(34.200001F, 62.108829F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(31.753386F, 7.246615F);
      ((Path)localObject).cubicTo(34.098724F, 4.901274F, 37.916859F, 4.916857F, 40.246616F, 7.246615F);
      ((Path)localObject).lineTo(64.753387F, 31.753386F);
      ((Path)localObject).cubicTo(67.098724F, 34.098724F, 67.083145F, 37.916859F, 64.753387F, 40.246616F);
      ((Path)localObject).lineTo(40.246616F, 64.753387F);
      ((Path)localObject).cubicTo(37.901276F, 67.098724F, 34.083141F, 67.083145F, 31.753386F, 64.753387F);
      ((Path)localObject).lineTo(7.246615F, 40.246616F);
      ((Path)localObject).cubicTo(4.901274F, 37.901276F, 4.916857F, 34.083141F, 7.246615F, 31.753386F);
      ((Path)localObject).lineTo(31.753386F, 7.246615F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(36.0F, 45.0F);
      ((Path)localObject).cubicTo(40.970562F, 45.0F, 45.0F, 40.970562F, 45.0F, 36.0F);
      ((Path)localObject).cubicTo(45.0F, 31.029438F, 40.970562F, 27.0F, 36.0F, 27.0F);
      ((Path)localObject).cubicTo(31.029438F, 27.0F, 27.0F, 31.029438F, 27.0F, 36.0F);
      ((Path)localObject).cubicTo(27.0F, 40.970562F, 31.029438F, 45.0F, 36.0F, 45.0F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 1);
      localCanvas.drawPath((Path)localObject, localPaint);
      localCanvas.restore();
      c.l(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.app
 * JD-Core Version:    0.7.0.1
 */