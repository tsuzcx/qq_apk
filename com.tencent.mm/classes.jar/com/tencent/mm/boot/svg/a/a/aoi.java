package com.tencent.mm.boot.svg.a.a;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.c;

public final class aoi
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
      Object localObject = c.k(paramVarArgs);
      ((Paint)localObject).setFlags(385);
      ((Paint)localObject).setStyle(Paint.Style.FILL);
      Paint localPaint = c.k(paramVarArgs);
      localPaint.setFlags(385);
      localPaint.setStyle(Paint.Style.STROKE);
      ((Paint)localObject).setColor(-16777216);
      localPaint.setStrokeWidth(1.0F);
      localPaint.setStrokeCap(Paint.Cap.BUTT);
      localPaint.setStrokeJoin(Paint.Join.MITER);
      localPaint.setStrokeMiter(4.0F);
      localPaint.setPathEffect(null);
      localPaint = c.a(localPaint, paramVarArgs);
      localPaint.setStrokeWidth(1.0F);
      localObject = c.a((Paint)localObject, paramVarArgs);
      ((Paint)localObject).setColor(-564640);
      localCanvas.save();
      localObject = c.a((Paint)localObject, paramVarArgs);
      Path localPath = c.l(paramVarArgs);
      localPath.moveTo(12.0F, 3.0F);
      localPath.cubicTo(16.970562F, 3.0F, 21.0F, 7.029437F, 21.0F, 12.0F);
      localPath.cubicTo(21.0F, 16.970562F, 16.970562F, 21.0F, 12.0F, 21.0F);
      localPath.cubicTo(7.029437F, 21.0F, 3.0F, 16.970562F, 3.0F, 12.0F);
      localPath.cubicTo(3.0F, 7.029437F, 7.029437F, 3.0F, 12.0F, 3.0F);
      localPath.close();
      localCanvas.drawPath(localPath, (Paint)localObject);
      localCanvas.restore();
      localCanvas.save();
      localPaint = c.a(localPaint, paramVarArgs);
      localPaint.setColor(-1);
      localPaint.setStrokeWidth(3.0F);
      localObject = c.l(paramVarArgs);
      ((Path)localObject).moveTo(12.0F, 1.5F);
      ((Path)localObject).cubicTo(17.79899F, 1.5F, 22.5F, 6.20101F, 22.5F, 12.0F);
      ((Path)localObject).cubicTo(22.5F, 17.79899F, 17.79899F, 22.5F, 12.0F, 22.5F);
      ((Path)localObject).cubicTo(6.20101F, 22.5F, 1.5F, 17.79899F, 1.5F, 12.0F);
      ((Path)localObject).cubicTo(1.5F, 6.20101F, 6.20101F, 1.5F, 12.0F, 1.5F);
      ((Path)localObject).close();
      localCanvas.drawPath((Path)localObject, localPaint);
      localCanvas.restore();
      c.j(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.aoi
 * JD-Core Version:    0.7.0.1
 */