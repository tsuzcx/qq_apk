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

public final class acf
  extends c
{
  private final int height = 60;
  private final int width = 96;
  
  public final int a(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 96;
      return 60;
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
      localCanvas.save();
      localObject = c.a(localPaint, paramVarArgs);
      ((Paint)localObject).setColor(117440512);
      Path localPath = c.n(paramVarArgs);
      localPath.moveTo(0.0F, 12.0F);
      localPath.cubicTo(0.0F, 5.372582F, 5.372582F, 0.0F, 12.0F, 0.0F);
      localPath.lineTo(84.0F, 0.0F);
      localPath.cubicTo(90.627419F, 0.0F, 96.0F, 5.372582F, 96.0F, 12.0F);
      localPath.lineTo(96.0F, 48.0F);
      localPath.cubicTo(96.0F, 54.627419F, 90.627419F, 60.0F, 84.0F, 60.0F);
      localPath.lineTo(12.0F, 60.0F);
      localPath.cubicTo(5.372582F, 60.0F, 0.0F, 54.627419F, 0.0F, 48.0F);
      localPath.lineTo(0.0F, 12.0F);
      localPath.close();
      localCanvas.drawPath(localPath, (Paint)localObject);
      localCanvas.restore();
      localCanvas.save();
      localPaint = c.a(localPaint, paramVarArgs);
      localPaint.setColor(-11048043);
      localObject = c.n(paramVarArgs);
      ((Path)localObject).moveTo(36.0F, 36.0F);
      ((Path)localObject).cubicTo(32.686291F, 36.0F, 30.0F, 33.313709F, 30.0F, 30.0F);
      ((Path)localObject).cubicTo(30.0F, 26.686291F, 32.686291F, 24.0F, 36.0F, 24.0F);
      ((Path)localObject).cubicTo(39.313709F, 24.0F, 42.0F, 26.686291F, 42.0F, 30.0F);
      ((Path)localObject).cubicTo(42.0F, 33.313709F, 39.313709F, 36.0F, 36.0F, 36.0F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(60.0F, 36.0F);
      ((Path)localObject).cubicTo(56.686291F, 36.0F, 54.0F, 33.313709F, 54.0F, 30.0F);
      ((Path)localObject).cubicTo(54.0F, 26.686291F, 56.686291F, 24.0F, 60.0F, 24.0F);
      ((Path)localObject).cubicTo(63.313709F, 24.0F, 66.0F, 26.686291F, 66.0F, 30.0F);
      ((Path)localObject).cubicTo(66.0F, 33.313709F, 63.313709F, 36.0F, 60.0F, 36.0F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 2);
      localCanvas.drawPath((Path)localObject, localPaint);
      localCanvas.restore();
      c.l(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.acf
 * JD-Core Version:    0.7.0.1
 */