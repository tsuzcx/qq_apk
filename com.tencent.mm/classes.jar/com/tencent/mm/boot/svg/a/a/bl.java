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

public final class bl
  extends c
{
  private final int height = 24;
  private final int width = 24;
  
  protected final int b(int paramInt, Object... paramVarArgs)
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
      c.f(paramVarArgs);
      c.e(paramVarArgs);
      Paint localPaint = c.i(paramVarArgs);
      localPaint.setFlags(385);
      localPaint.setStyle(Paint.Style.FILL);
      Object localObject = c.i(paramVarArgs);
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
      localPaint.setColor(-15028967);
      localCanvas.save();
      localPaint = c.a(localPaint, paramVarArgs);
      localObject = c.j(paramVarArgs);
      ((Path)localObject).moveTo(11.261719F, 22.134476F);
      ((Path)localObject).cubicTo(11.261719F, 22.134476F, 4.0F, 16.018278F, 4.0F, 10.0F);
      ((Path)localObject).cubicTo(4.0F, 5.581722F, 7.581722F, 2.0F, 12.0F, 2.0F);
      ((Path)localObject).cubicTo(16.418278F, 2.0F, 20.0F, 5.581722F, 20.0F, 10.0F);
      ((Path)localObject).cubicTo(20.0F, 16.018278F, 12.738281F, 22.134476F, 12.738281F, 22.134476F);
      ((Path)localObject).cubicTo(12.333565F, 22.50602F, 11.66946F, 22.502035F, 11.261719F, 22.134476F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(12.0F, 13.2F);
      ((Path)localObject).cubicTo(13.767311F, 13.2F, 15.2F, 11.767311F, 15.2F, 10.0F);
      ((Path)localObject).cubicTo(15.2F, 8.232689F, 13.767311F, 6.8F, 12.0F, 6.8F);
      ((Path)localObject).cubicTo(10.232689F, 6.8F, 8.8F, 8.232689F, 8.8F, 10.0F);
      ((Path)localObject).cubicTo(8.8F, 11.767311F, 10.232689F, 13.2F, 12.0F, 13.2F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 1);
      localCanvas.drawPath((Path)localObject, localPaint);
      localCanvas.restore();
      c.h(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.bl
 * JD-Core Version:    0.7.0.1
 */