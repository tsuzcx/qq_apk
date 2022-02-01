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

public final class bbx
  extends c
{
  private final int height = 30;
  private final int width = 30;
  
  public final int a(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 30;
      return 30;
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
      localPaint.setColor(-1158579);
      localCanvas.save();
      localPaint = c.a(localPaint, paramVarArgs);
      localObject = c.n(paramVarArgs);
      ((Path)localObject).moveTo(13.68F, 0.0F);
      ((Path)localObject).lineTo(16.09F, 0.0F);
      ((Path)localObject).cubicTo(23.290001F, 0.5F, 29.35F, 6.53F, 30.0F, 13.69F);
      ((Path)localObject).lineTo(30.0F, 16.120001F);
      ((Path)localObject).cubicTo(29.49F, 23.290001F, 23.49F, 29.33F, 16.34F, 30.0F);
      ((Path)localObject).lineTo(13.89F, 30.0F);
      ((Path)localObject).cubicTo(6.7F, 29.49F, 0.65F, 23.469999F, 0.0F, 16.32F);
      ((Path)localObject).lineTo(0.0F, 13.88F);
      ((Path)localObject).cubicTo(0.52F, 6.7F, 6.53F, 0.66F, 13.68F, 0.0F);
      ((Path)localObject).lineTo(13.68F, 0.0F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 2);
      localCanvas.drawPath((Path)localObject, localPaint);
      localCanvas.restore();
      c.l(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.bbx
 * JD-Core Version:    0.7.0.1
 */