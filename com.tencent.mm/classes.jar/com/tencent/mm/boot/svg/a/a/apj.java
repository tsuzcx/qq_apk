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

public final class apj
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
      c.h(paramVarArgs);
      c.g(paramVarArgs);
      Paint localPaint = c.k(paramVarArgs);
      localPaint.setFlags(385);
      localPaint.setStyle(Paint.Style.FILL);
      Object localObject = c.k(paramVarArgs);
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
      localPaint.setColor(-1);
      localCanvas.save();
      localPaint = c.a(localPaint, paramVarArgs);
      localObject = c.l(paramVarArgs);
      ((Path)localObject).moveTo(57.0F, 48.0F);
      ((Path)localObject).cubicTo(57.0F, 50.762001F, 59.237999F, 53.0F, 62.0F, 53.0F);
      ((Path)localObject).cubicTo(64.762001F, 53.0F, 67.0F, 50.762001F, 67.0F, 48.0F);
      ((Path)localObject).cubicTo(67.0F, 45.238998F, 64.762001F, 43.0F, 62.0F, 43.0F);
      ((Path)localObject).cubicTo(59.237999F, 43.0F, 57.0F, 45.238998F, 57.0F, 48.0F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(77.0F, 25.0F);
      ((Path)localObject).lineTo(19.0F, 25.0F);
      ((Path)localObject).cubicTo(17.344F, 25.0F, 16.0F, 26.343F, 16.0F, 28.0F);
      ((Path)localObject).lineTo(16.0F, 68.0F);
      ((Path)localObject).cubicTo(16.0F, 69.656998F, 17.344F, 71.0F, 19.0F, 71.0F);
      ((Path)localObject).lineTo(77.0F, 71.0F);
      ((Path)localObject).cubicTo(78.655998F, 71.0F, 80.0F, 69.656998F, 80.0F, 68.0F);
      ((Path)localObject).lineTo(80.0F, 58.0F);
      ((Path)localObject).lineTo(62.0F, 58.0F);
      ((Path)localObject).cubicTo(56.477001F, 58.0F, 52.0F, 53.522999F, 52.0F, 48.0F);
      ((Path)localObject).cubicTo(52.0F, 42.478001F, 56.477001F, 38.0F, 62.0F, 38.0F);
      ((Path)localObject).lineTo(80.0F, 38.0F);
      ((Path)localObject).lineTo(80.0F, 28.0F);
      ((Path)localObject).cubicTo(80.0F, 26.344F, 78.655998F, 25.0F, 77.0F, 25.0F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 2);
      localCanvas.drawPath((Path)localObject, localPaint);
      localCanvas.restore();
      c.j(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.apj
 * JD-Core Version:    0.7.0.1
 */