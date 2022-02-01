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

public final class amr
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
      ((Path)localObject).moveTo(22.5F, 27.0F);
      ((Path)localObject).lineTo(22.5F, 19.5F);
      ((Path)localObject).cubicTo(22.5F, 12.044156F, 28.544155F, 6.0F, 36.0F, 6.0F);
      ((Path)localObject).cubicTo(43.455845F, 6.0F, 49.5F, 12.044156F, 49.5F, 19.5F);
      ((Path)localObject).lineTo(49.5F, 27.0F);
      ((Path)localObject).lineTo(56.997383F, 27.0F);
      ((Path)localObject).cubicTo(58.655682F, 27.0F, 60.0F, 28.342468F, 60.0F, 29.995506F);
      ((Path)localObject).lineTo(60.0F, 63.004494F);
      ((Path)localObject).cubicTo(60.0F, 64.658867F, 58.666107F, 66.0F, 56.997383F, 66.0F);
      ((Path)localObject).lineTo(15.002615F, 66.0F);
      ((Path)localObject).cubicTo(13.344316F, 66.0F, 12.0F, 64.657532F, 12.0F, 63.004494F);
      ((Path)localObject).lineTo(12.0F, 29.995506F);
      ((Path)localObject).cubicTo(12.0F, 28.341135F, 13.333893F, 27.0F, 15.002615F, 27.0F);
      ((Path)localObject).lineTo(22.5F, 27.0F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(27.0F, 27.0F);
      ((Path)localObject).lineTo(45.0F, 27.0F);
      ((Path)localObject).lineTo(45.0F, 19.5F);
      ((Path)localObject).cubicTo(45.0F, 14.529437F, 40.970562F, 10.5F, 36.0F, 10.5F);
      ((Path)localObject).cubicTo(31.029438F, 10.5F, 27.0F, 14.529437F, 27.0F, 19.5F);
      ((Path)localObject).lineTo(27.0F, 27.0F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(34.200001F, 47.625561F);
      ((Path)localObject).lineTo(34.200001F, 54.0F);
      ((Path)localObject).lineTo(37.799999F, 54.0F);
      ((Path)localObject).lineTo(37.799999F, 47.625561F);
      ((Path)localObject).cubicTo(39.389313F, 46.93116F, 40.5F, 45.345287F, 40.5F, 43.5F);
      ((Path)localObject).cubicTo(40.5F, 41.014717F, 38.485283F, 39.0F, 36.0F, 39.0F);
      ((Path)localObject).cubicTo(33.514717F, 39.0F, 31.5F, 41.014717F, 31.5F, 43.5F);
      ((Path)localObject).cubicTo(31.5F, 45.345287F, 32.610683F, 46.93116F, 34.200001F, 47.625561F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 2);
      localCanvas.drawPath((Path)localObject, localPaint);
      localCanvas.restore();
      c.l(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.amr
 * JD-Core Version:    0.7.0.1
 */