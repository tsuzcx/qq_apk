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

public final class bkd
  extends c
{
  private final int height = 96;
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
      return 96;
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
      localPaint.setColor(-1);
      localCanvas.save();
      localObject = c.a(localPaint, paramVarArgs);
      Path localPath = c.n(paramVarArgs);
      localPath.moveTo(16.0F, 22.0F);
      localPath.cubicTo(15.747877F, 20.113762F, 16.916676F, 17.966154F, 19.0F, 18.0F);
      localPath.cubicTo(27.60569F, 17.91621F, 36.306747F, 18.066044F, 45.0F, 18.0F);
      localPath.cubicTo(45.067741F, 23.380123F, 44.897915F, 28.754135F, 45.0F, 34.0F);
      localPath.cubicTo(44.977833F, 35.596512F, 46.396374F, 37.034908F, 48.0F, 37.0F);
      localPath.cubicTo(53.249332F, 37.094841F, 58.623806F, 36.945011F, 64.0F, 37.0F);
      localPath.cubicTo(63.938343F, 49.67083F, 64.078201F, 62.356697F, 64.0F, 75.0F);
      localPath.cubicTo(64.018265F, 77.050323F, 61.880459F, 78.268967F, 60.0F, 78.0F);
      localPath.cubicTo(46.366405F, 77.919357F, 32.670483F, 78.019249F, 19.0F, 78.0F);
      localPath.cubicTo(16.966625F, 78.029236F, 15.737887F, 75.891617F, 16.0F, 74.0F);
      localPath.cubicTo(16.02759F, 56.693008F, 16.02759F, 39.292393F, 16.0F, 22.0F);
      localPath.lineTo(16.0F, 22.0F);
      localPath.close();
      localPath.moveTo(22.0F, 48.0F);
      localPath.lineTo(22.0F, 51.0F);
      localPath.lineTo(42.0F, 51.0F);
      localPath.lineTo(42.0F, 48.0F);
      localPath.lineTo(22.0F, 48.0F);
      localPath.lineTo(22.0F, 48.0F);
      localPath.close();
      localPath.moveTo(22.0F, 56.0F);
      localPath.lineTo(22.0F, 59.0F);
      localPath.lineTo(48.0F, 59.0F);
      localPath.lineTo(48.0F, 56.0F);
      localPath.lineTo(22.0F, 56.0F);
      localPath.lineTo(22.0F, 56.0F);
      localPath.close();
      localPath.moveTo(22.0F, 64.0F);
      localPath.lineTo(22.0F, 67.0F);
      localPath.lineTo(48.0F, 67.0F);
      localPath.lineTo(48.0F, 64.0F);
      localPath.lineTo(22.0F, 64.0F);
      localPath.lineTo(22.0F, 64.0F);
      localPath.close();
      WeChatSVGRenderC2Java.setFillType(localPath, 2);
      localCanvas.drawPath(localPath, (Paint)localObject);
      localCanvas.restore();
      localCanvas.save();
      localPaint = c.a(localPaint, paramVarArgs);
      localObject = c.n(paramVarArgs);
      ((Path)localObject).moveTo(48.0F, 18.0F);
      ((Path)localObject).cubicTo(53.348984F, 23.320744F, 58.669502F, 28.65147F, 64.0F, 34.0F);
      ((Path)localObject).cubicTo(59.008896F, 33.872387F, 54.007809F, 34.161884F, 49.0F, 34.0F);
      ((Path)localObject).cubicTo(48.807079F, 33.612839F, 48.35788F, 33.123692F, 48.0F, 33.0F);
      ((Path)localObject).cubicTo(47.848785F, 27.93272F, 48.118305F, 22.961369F, 48.0F, 18.0F);
      ((Path)localObject).lineTo(48.0F, 18.0F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 2);
      localCanvas.drawPath((Path)localObject, localPaint);
      localCanvas.restore();
      c.l(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.bkd
 * JD-Core Version:    0.7.0.1
 */