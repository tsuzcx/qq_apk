package com.tencent.mm.boot.svg.a.a;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.c;

public final class bxv
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
      localObject = c.a((Paint)localObject, paramVarArgs);
      ((Paint)localObject).setStrokeWidth(1.0F);
      localCanvas.save();
      localObject = c.a((Paint)localObject, paramVarArgs);
      ((Paint)localObject).setColor(-15028967);
      ((Paint)localObject).setStrokeWidth(3.6F);
      Path localPath = c.n(paramVarArgs);
      localPath.moveTo(36.0F, 1.799999F);
      localPath.cubicTo(54.888138F, 1.799999F, 70.199997F, 17.11186F, 70.199997F, 36.0F);
      localPath.cubicTo(70.199997F, 54.888138F, 54.888138F, 70.199997F, 36.0F, 70.199997F);
      localPath.cubicTo(17.11186F, 70.199997F, 1.799999F, 54.888138F, 1.799999F, 36.0F);
      localPath.cubicTo(1.799999F, 17.11186F, 17.11186F, 1.799999F, 36.0F, 1.799999F);
      localPath.close();
      localCanvas.drawPath(localPath, (Paint)localObject);
      localCanvas.restore();
      localCanvas.save();
      localObject = c.a(localPaint, paramVarArgs);
      ((Paint)localObject).setColor(-15028967);
      localPath = c.n(paramVarArgs);
      localPath.moveTo(24.0F, 19.5F);
      localPath.lineTo(29.4F, 19.5F);
      localPath.lineTo(29.4F, 52.5F);
      localPath.lineTo(24.0F, 52.5F);
      localPath.lineTo(24.0F, 19.5F);
      localPath.close();
      localCanvas.drawPath(localPath, (Paint)localObject);
      localCanvas.restore();
      localCanvas.save();
      localPaint = c.a(localPaint, paramVarArgs);
      localPaint.setColor(-15028967);
      localObject = c.n(paramVarArgs);
      ((Path)localObject).moveTo(42.599991F, 19.5F);
      ((Path)localObject).lineTo(47.999992F, 19.5F);
      ((Path)localObject).lineTo(47.999992F, 52.5F);
      ((Path)localObject).lineTo(42.599991F, 52.5F);
      ((Path)localObject).lineTo(42.599991F, 19.5F);
      ((Path)localObject).close();
      localCanvas.drawPath((Path)localObject, localPaint);
      localCanvas.restore();
      c.l(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.bxv
 * JD-Core Version:    0.7.0.1
 */