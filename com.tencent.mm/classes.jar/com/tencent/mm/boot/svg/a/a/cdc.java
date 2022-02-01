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

public final class cdc
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
      localCanvas.saveLayerAlpha(null, 204, 31);
      localCanvas.save();
      localPaint = c.a(localPaint, paramVarArgs);
      localPaint.setColor(-1);
      localObject = c.n(paramVarArgs);
      ((Path)localObject).moveTo(36.0F, 16.0F);
      ((Path)localObject).cubicTo(47.045696F, 16.0F, 56.0F, 24.954306F, 56.0F, 36.0F);
      ((Path)localObject).cubicTo(56.0F, 47.045696F, 47.045696F, 56.0F, 36.0F, 56.0F);
      ((Path)localObject).cubicTo(24.954306F, 56.0F, 16.0F, 47.045696F, 16.0F, 36.0F);
      ((Path)localObject).cubicTo(16.0F, 24.954306F, 24.954306F, 16.0F, 36.0F, 16.0F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(23.48019F, 26.306059F);
      ((Path)localObject).cubicTo(21.403099F, 28.984739F, 20.166666F, 32.347977F, 20.166666F, 36.0F);
      ((Path)localObject).cubicTo(20.166666F, 44.744507F, 27.255491F, 51.833332F, 36.0F, 51.833332F);
      ((Path)localObject).cubicTo(39.652023F, 51.833332F, 43.015259F, 50.596901F, 45.693943F, 48.51981F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(36.0F, 20.166666F);
      ((Path)localObject).cubicTo(32.347977F, 20.166666F, 28.984739F, 21.403099F, 26.306059F, 23.48019F);
      ((Path)localObject).lineTo(48.51981F, 45.693943F);
      ((Path)localObject).cubicTo(50.596901F, 43.015259F, 51.833332F, 39.652023F, 51.833332F, 36.0F);
      ((Path)localObject).cubicTo(51.833332F, 27.255491F, 44.744507F, 20.166666F, 36.0F, 20.166666F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 1);
      localCanvas.drawPath((Path)localObject, localPaint);
      localCanvas.restore();
      localCanvas.restore();
      c.l(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.cdc
 * JD-Core Version:    0.7.0.1
 */