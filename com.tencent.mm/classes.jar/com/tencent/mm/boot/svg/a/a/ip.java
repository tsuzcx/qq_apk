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

public final class ip
  extends c
{
  private final int height = 242;
  private final int width = 245;
  
  protected final int b(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 245;
      return 242;
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
      localObject = c.a((Paint)localObject, paramVarArgs);
      ((Paint)localObject).setStrokeWidth(1.0F);
      localCanvas.save();
      localObject = c.a((Paint)localObject, paramVarArgs);
      ((Paint)localObject).setColor(-3552823);
      ((Paint)localObject).setStrokeWidth(4.0F);
      Path localPath = c.j(paramVarArgs);
      localPath.moveTo(123.0F, 7.0F);
      localPath.cubicTo(185.96046F, 7.0F, 237.0F, 58.039536F, 237.0F, 121.0F);
      localPath.cubicTo(237.0F, 183.96046F, 185.96046F, 235.0F, 123.0F, 235.0F);
      localPath.cubicTo(60.039536F, 235.0F, 9.0F, 183.96046F, 9.0F, 121.0F);
      localPath.cubicTo(9.0F, 58.039536F, 60.039536F, 7.0F, 123.0F, 7.0F);
      localPath.close();
      localCanvas.drawPath(localPath, (Paint)localObject);
      localCanvas.restore();
      localCanvas.save();
      localPaint = c.a(localPaint, paramVarArgs);
      localPaint.setColor(-3552823);
      localObject = c.j(paramVarArgs);
      ((Path)localObject).moveTo(117.13348F, 111.82906F);
      ((Path)localObject).lineTo(94.750854F, 89.446419F);
      ((Path)localObject).lineTo(94.750854F, 100.31056F);
      ((Path)localObject).lineTo(116.18076F, 121.74048F);
      ((Path)localObject).lineTo(94.750854F, 143.17038F);
      ((Path)localObject).lineTo(94.750854F, 154.18599F);
      ((Path)localObject).lineTo(117.13348F, 131.80336F);
      ((Path)localObject).lineTo(117.13348F, 165.4863F);
      ((Path)localObject).lineTo(116.81284F, 165.80695F);
      ((Path)localObject).lineTo(117.13348F, 165.80695F);
      ((Path)localObject).lineTo(117.13348F, 176.50191F);
      ((Path)localObject).lineTo(149.46358F, 144.17183F);
      ((Path)localObject).lineTo(148.58734F, 143.29559F);
      ((Path)localObject).lineTo(148.59369F, 143.28926F);
      ((Path)localObject).lineTo(127.12064F, 121.81621F);
      ((Path)localObject).lineTo(148.28012F, 100.65672F);
      ((Path)localObject).lineTo(148.23923F, 100.61583F);
      ((Path)localObject).lineTo(150.24332F, 98.61174F);
      ((Path)localObject).lineTo(117.13348F, 65.501915F);
      ((Path)localObject).lineTo(117.13348F, 75.7257F);
      ((Path)localObject).lineTo(117.13348F, 111.82906F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(124.9227F, 112.99854F);
      ((Path)localObject).lineTo(139.2686F, 98.652641F);
      ((Path)localObject).lineTo(124.9227F, 84.306732F);
      ((Path)localObject).lineTo(124.9227F, 112.99854F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(124.9227F, 157.6971F);
      ((Path)localObject).lineTo(138.53004F, 144.08975F);
      ((Path)localObject).lineTo(124.9227F, 130.48241F);
      ((Path)localObject).lineTo(124.9227F, 157.6971F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 2);
      localCanvas.drawPath((Path)localObject, localPaint);
      localCanvas.restore();
      c.h(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.ip
 * JD-Core Version:    0.7.0.1
 */