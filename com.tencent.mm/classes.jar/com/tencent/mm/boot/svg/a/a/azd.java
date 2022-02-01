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

public final class azd
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
      localPaint.setColor(-5066062);
      localCanvas.save();
      localPaint = c.a(localPaint, paramVarArgs);
      localObject = c.n(paramVarArgs);
      ((Path)localObject).moveTo(20.25F, 36.0F);
      ((Path)localObject).cubicTo(20.25F, 38.899052F, 17.89905F, 41.25F, 15.0F, 41.25F);
      ((Path)localObject).cubicTo(12.10095F, 41.25F, 9.75F, 38.899052F, 9.75F, 36.0F);
      ((Path)localObject).cubicTo(9.75F, 33.099899F, 12.10095F, 30.75F, 15.0F, 30.75F);
      ((Path)localObject).cubicTo(17.89905F, 30.75F, 20.25F, 33.099899F, 20.25F, 36.0F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(36.0F, 30.75F);
      ((Path)localObject).cubicTo(38.899052F, 30.75F, 41.25F, 33.099899F, 41.25F, 36.0F);
      ((Path)localObject).cubicTo(41.25F, 38.899052F, 38.899052F, 41.25F, 36.0F, 41.25F);
      ((Path)localObject).cubicTo(33.100948F, 41.25F, 30.75F, 38.899052F, 30.75F, 36.0F);
      ((Path)localObject).cubicTo(30.75F, 33.099899F, 33.100948F, 30.75F, 36.0F, 30.75F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(57.0F, 30.75F);
      ((Path)localObject).cubicTo(59.899052F, 30.75F, 62.25F, 33.099899F, 62.25F, 36.0F);
      ((Path)localObject).cubicTo(62.25F, 38.899052F, 59.899052F, 41.25F, 57.0F, 41.25F);
      ((Path)localObject).cubicTo(54.100948F, 41.25F, 51.75F, 38.899052F, 51.75F, 36.0F);
      ((Path)localObject).cubicTo(51.75F, 33.099899F, 54.100948F, 30.75F, 57.0F, 30.75F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 2);
      localCanvas.drawPath((Path)localObject, localPaint);
      localCanvas.restore();
      c.l(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.azd
 * JD-Core Version:    0.7.0.1
 */