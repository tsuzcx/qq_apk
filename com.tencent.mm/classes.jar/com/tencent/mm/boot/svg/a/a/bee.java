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

public final class bee
  extends c
{
  private final int height = 108;
  private final int width = 108;
  
  public final int a(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 108;
      return 108;
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
      localPaint.setColor(-15683841);
      localCanvas.save();
      localPaint = c.a(localPaint, paramVarArgs);
      localObject = c.n(paramVarArgs);
      ((Path)localObject).moveTo(86.0F, 81.0F);
      ((Path)localObject).lineTo(23.0F, 81.0F);
      ((Path)localObject).cubicTo(21.344F, 81.0F, 20.0F, 79.656998F, 20.0F, 78.0F);
      ((Path)localObject).lineTo(20.0F, 31.0F);
      ((Path)localObject).cubicTo(20.0F, 29.343F, 21.344F, 28.0F, 23.0F, 28.0F);
      ((Path)localObject).lineTo(86.0F, 28.0F);
      ((Path)localObject).cubicTo(87.655998F, 28.0F, 89.0F, 29.343F, 89.0F, 31.0F);
      ((Path)localObject).lineTo(89.0F, 78.0F);
      ((Path)localObject).cubicTo(89.0F, 79.656998F, 87.655998F, 81.0F, 86.0F, 81.0F);
      ((Path)localObject).lineTo(86.0F, 81.0F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(24.0F, 32.0F);
      ((Path)localObject).lineTo(24.0F, 68.030998F);
      ((Path)localObject).lineTo(43.951F, 48.000999F);
      ((Path)localObject).lineTo(68.0F, 68.706001F);
      ((Path)localObject).lineTo(64.273003F, 61.914001F);
      ((Path)localObject).lineTo(71.0F, 54.0F);
      ((Path)localObject).lineTo(85.0F, 70.471001F);
      ((Path)localObject).lineTo(85.0F, 32.0F);
      ((Path)localObject).lineTo(24.0F, 32.0F);
      ((Path)localObject).lineTo(24.0F, 32.0F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 2);
      localCanvas.drawPath((Path)localObject, localPaint);
      localCanvas.restore();
      c.l(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.bee
 * JD-Core Version:    0.7.0.1
 */