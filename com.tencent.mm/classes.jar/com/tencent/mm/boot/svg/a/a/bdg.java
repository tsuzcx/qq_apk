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

public final class bdg
  extends c
{
  private final int height = 24;
  private final int width = 24;
  
  public final int a(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 24;
      return 24;
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
      localCanvas.save();
      localPaint = c.a(localPaint, paramVarArgs);
      localPaint.setColor(-16777216);
      localObject = c.l(paramVarArgs);
      ((Path)localObject).moveTo(1.75F, 7.75F);
      ((Path)localObject).lineTo(22.25F, 7.75F);
      ((Path)localObject).cubicTo(22.664213F, 7.75F, 23.0F, 8.085787F, 23.0F, 8.5F);
      ((Path)localObject).cubicTo(23.0F, 8.914213F, 22.664213F, 9.25F, 22.25F, 9.25F);
      ((Path)localObject).lineTo(1.75F, 9.25F);
      ((Path)localObject).cubicTo(1.335787F, 9.25F, 1.0F, 8.914213F, 1.0F, 8.5F);
      ((Path)localObject).cubicTo(1.0F, 8.085787F, 1.335787F, 7.75F, 1.75F, 7.75F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(1.75F, 11.25F);
      ((Path)localObject).lineTo(22.25F, 11.25F);
      ((Path)localObject).cubicTo(22.664213F, 11.25F, 23.0F, 11.585787F, 23.0F, 12.0F);
      ((Path)localObject).cubicTo(23.0F, 12.414213F, 22.664213F, 12.75F, 22.25F, 12.75F);
      ((Path)localObject).lineTo(1.75F, 12.75F);
      ((Path)localObject).cubicTo(1.335787F, 12.75F, 1.0F, 12.414213F, 1.0F, 12.0F);
      ((Path)localObject).cubicTo(1.0F, 11.585787F, 1.335787F, 11.25F, 1.75F, 11.25F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(1.75F, 14.75F);
      ((Path)localObject).lineTo(22.25F, 14.75F);
      ((Path)localObject).cubicTo(22.664213F, 14.75F, 23.0F, 15.085787F, 23.0F, 15.5F);
      ((Path)localObject).cubicTo(23.0F, 15.914213F, 22.664213F, 16.25F, 22.25F, 16.25F);
      ((Path)localObject).lineTo(1.75F, 16.25F);
      ((Path)localObject).cubicTo(1.335787F, 16.25F, 1.0F, 15.914213F, 1.0F, 15.5F);
      ((Path)localObject).cubicTo(1.0F, 15.085787F, 1.335787F, 14.75F, 1.75F, 14.75F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 2);
      localCanvas.drawPath((Path)localObject, localPaint);
      localCanvas.restore();
      c.j(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.bdg
 * JD-Core Version:    0.7.0.1
 */