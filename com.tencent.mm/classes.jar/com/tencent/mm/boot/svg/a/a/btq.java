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

public final class btq
  extends c
{
  private final int height = 63;
  private final int width = 63;
  
  public final int a(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 63;
      return 63;
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
      localPaint.setColor(-14624737);
      localCanvas.save();
      localPaint = c.a(localPaint, paramVarArgs);
      localObject = c.n(paramVarArgs);
      ((Path)localObject).moveTo(35.0F, 20.0F);
      ((Path)localObject).lineTo(50.492165F, 20.0F);
      ((Path)localObject).cubicTo(51.322575F, 20.0F, 52.0F, 19.326305F, 52.0F, 18.495262F);
      ((Path)localObject).lineTo(52.0F, 13.504739F);
      ((Path)localObject).cubicTo(52.0F, 12.668316F, 51.324917F, 12.0F, 50.492165F, 12.0F);
      ((Path)localObject).lineTo(12.507836F, 12.0F);
      ((Path)localObject).cubicTo(11.677424F, 12.0F, 11.0F, 12.673695F, 11.0F, 13.504739F);
      ((Path)localObject).lineTo(11.0F, 18.495262F);
      ((Path)localObject).cubicTo(11.0F, 19.331684F, 11.675081F, 20.0F, 12.507836F, 20.0F);
      ((Path)localObject).lineTo(27.0F, 20.0F);
      ((Path)localObject).lineTo(27.0F, 52.505199F);
      ((Path)localObject).cubicTo(27.0F, 53.323269F, 27.673695F, 54.0F, 28.504738F, 54.0F);
      ((Path)localObject).lineTo(33.495262F, 54.0F);
      ((Path)localObject).cubicTo(34.331684F, 54.0F, 35.0F, 53.330753F, 35.0F, 52.505199F);
      ((Path)localObject).lineTo(35.0F, 20.0F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 2);
      localCanvas.drawPath((Path)localObject, localPaint);
      localCanvas.restore();
      c.l(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.btq
 * JD-Core Version:    0.7.0.1
 */