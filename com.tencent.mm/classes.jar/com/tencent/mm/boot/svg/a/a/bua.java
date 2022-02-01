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

public final class bua
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
      localObject = c.n(paramVarArgs);
      ((Path)localObject).moveTo(0.0F, 0.0F);
      ((Path)localObject).lineTo(96.0F, 0.0F);
      ((Path)localObject).lineTo(96.0F, 96.0F);
      ((Path)localObject).lineTo(0.0F, 96.0F);
      ((Path)localObject).lineTo(0.0F, 0.0F);
      ((Path)localObject).close();
      localCanvas.save();
      localPaint = c.a(localPaint, paramVarArgs);
      localPaint.setColor(-15028967);
      localObject = c.n(paramVarArgs);
      ((Path)localObject).moveTo(46.279175F, 21.000214F);
      ((Path)localObject).lineTo(46.279175F, 44.5821F);
      ((Path)localObject).lineTo(33.04137F, 33.706234F);
      ((Path)localObject).lineTo(31.0F, 36.192547F);
      ((Path)localObject).lineTo(45.372139F, 47.999035F);
      ((Path)localObject).lineTo(31.0F, 59.806595F);
      ((Path)localObject).lineTo(33.04137F, 62.292908F);
      ((Path)localObject).lineTo(46.279175F, 51.417042F);
      ((Path)localObject).lineTo(46.279175F, 75.0F);
      ((Path)localObject).lineTo(64.73941F, 59.746555F);
      ((Path)localObject).lineTo(50.43911F, 47.999035F);
      ((Path)localObject).lineTo(64.73941F, 36.251514F);
      ((Path)localObject).lineTo(46.279175F, 21.000214F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(49.495617F, 27.828722F);
      ((Path)localObject).lineTo(59.681019F, 36.244007F);
      ((Path)localObject).lineTo(49.495617F, 44.612122F);
      ((Path)localObject).lineTo(49.495617F, 27.828722F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(49.495617F, 51.385948F);
      ((Path)localObject).lineTo(59.681019F, 59.752991F);
      ((Path)localObject).lineTo(49.495617F, 68.16935F);
      ((Path)localObject).lineTo(49.495617F, 51.385948F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 2);
      localCanvas.drawPath((Path)localObject, localPaint);
      localCanvas.restore();
      c.l(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.bua
 * JD-Core Version:    0.7.0.1
 */