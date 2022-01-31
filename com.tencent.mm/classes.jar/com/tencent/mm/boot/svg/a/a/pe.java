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

public final class pe
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
      localObject = c.a(localPaint, paramVarArgs);
      ((Paint)localObject).setColor(-1);
      Path localPath = c.l(paramVarArgs);
      localPath.moveTo(11.0F, 3.0F);
      localPath.cubicTo(15.970563F, 3.0F, 20.0F, 7.029437F, 20.0F, 12.0F);
      localPath.cubicTo(20.0F, 16.970562F, 15.970563F, 21.0F, 11.0F, 21.0F);
      localPath.cubicTo(6.029437F, 21.0F, 2.0F, 16.970562F, 2.0F, 12.0F);
      localPath.cubicTo(2.0F, 7.029437F, 6.029437F, 3.0F, 11.0F, 3.0F);
      localPath.close();
      localCanvas.drawPath(localPath, (Paint)localObject);
      localCanvas.restore();
      localPaint = c.a(localPaint, paramVarArgs);
      localPaint.setColor(-16268960);
      localCanvas.save();
      localPaint = c.a(localPaint, paramVarArgs);
      localObject = c.l(paramVarArgs);
      ((Path)localObject).moveTo(12.0F, 22.0F);
      ((Path)localObject).cubicTo(6.477152F, 22.0F, 2.0F, 17.522848F, 2.0F, 12.0F);
      ((Path)localObject).cubicTo(2.0F, 6.477152F, 6.477152F, 2.0F, 12.0F, 2.0F);
      ((Path)localObject).cubicTo(17.522848F, 2.0F, 22.0F, 6.477152F, 22.0F, 12.0F);
      ((Path)localObject).cubicTo(22.0F, 17.522848F, 17.522848F, 22.0F, 12.0F, 22.0F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(10.823438F, 14.139317F);
      ((Path)localObject).lineTo(8.057538F, 11.373417F);
      ((Path)localObject).lineTo(7.0F, 12.430955F);
      ((Path)localObject).lineTo(10.1187F, 15.552128F);
      ((Path)localObject).cubicTo(10.118736F, 15.552164F, 10.118773F, 15.5522F, 10.118809F, 15.552237F);
      ((Path)localObject).cubicTo(10.509253F, 15.942842F, 11.142417F, 15.942974F, 11.533023F, 15.55253F);
      ((Path)localObject).lineTo(17.485281F, 9.602528F);
      ((Path)localObject).lineTo(16.422754F, 8.54F);
      ((Path)localObject).lineTo(10.823438F, 14.139317F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 2);
      localCanvas.drawPath((Path)localObject, localPaint);
      localCanvas.restore();
      c.j(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.pe
 * JD-Core Version:    0.7.0.1
 */