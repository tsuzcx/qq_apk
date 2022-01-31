package com.tencent.mm.boot.svg.a.a;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.c;

public final class tc
  extends c
{
  private final int height = 30;
  private final int width = 30;
  
  protected final int b(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 30;
      return 30;
      Canvas localCanvas = (Canvas)paramVarArgs[0];
      paramVarArgs = (Looper)paramVarArgs[1];
      Object localObject1 = c.f(paramVarArgs);
      Object localObject3 = c.e(paramVarArgs);
      Object localObject2 = c.i(paramVarArgs);
      ((Paint)localObject2).setFlags(385);
      ((Paint)localObject2).setStyle(Paint.Style.FILL);
      Paint localPaint = c.i(paramVarArgs);
      localPaint.setFlags(385);
      localPaint.setStyle(Paint.Style.STROKE);
      ((Paint)localObject2).setColor(-16777216);
      localPaint.setStrokeWidth(1.0F);
      localPaint.setStrokeCap(Paint.Cap.BUTT);
      localPaint.setStrokeJoin(Paint.Join.MITER);
      localPaint.setStrokeMiter(4.0F);
      localPaint.setPathEffect(null);
      localObject2 = c.a(localPaint, paramVarArgs);
      ((Paint)localObject2).setStrokeWidth(1.0F);
      localObject2 = c.a((Paint)localObject2, paramVarArgs);
      ((Paint)localObject2).setColor(-5066062);
      ((Paint)localObject2).setStrokeWidth(2.0F);
      localCanvas.save();
      localObject3 = c.a((float[])localObject3, 1.0F, 0.0F, 2.0F, 0.0F, 1.0F, 2.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject3);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localPaint = c.a((Paint)localObject2, paramVarArgs);
      Path localPath = c.j(paramVarArgs);
      localPath.moveTo(1.759891F, 9.578414F);
      localPath.cubicTo(0.6770722F, 8.568604F, 0.0F, 7.129328F, 0.0F, 5.531915F);
      localPath.cubicTo(0.0F, 2.476723F, 2.476723F, 0.0F, 5.531915F, 0.0F);
      localPath.cubicTo(7.280762F, 0.0F, 8.840067F, 0.811529F, 9.853792F, 2.078551F);
      localPath.cubicTo(6.086365F, 3.10554F, 3.061316F, 5.932576F, 1.759891F, 9.578414F);
      localPath.close();
      localPath.moveTo(16.145893F, 2.078945F);
      localPath.cubicTo(17.159611F, 0.811697F, 18.719057F, 0.0F, 20.468084F, 0.0F);
      localPath.cubicTo(23.523277F, 0.0F, 26.0F, 2.476723F, 26.0F, 5.531915F);
      localPath.cubicTo(26.0F, 7.129978F, 25.322378F, 8.569773F, 24.238789F, 9.579644F);
      localPath.cubicTo(22.937773F, 5.933679F, 19.913073F, 3.106378F, 16.145893F, 2.078945F);
      localPath.close();
      localCanvas.drawPath(localPath, localPaint);
      localCanvas.restore();
      localCanvas.save();
      localPaint = c.a((Paint)localObject2, paramVarArgs);
      localPath = c.j(paramVarArgs);
      localPath.moveTo(13.0F, 1.659575F);
      localPath.cubicTo(19.263145F, 1.659575F, 24.340425F, 6.736856F, 24.340425F, 13.0F);
      localPath.cubicTo(24.340425F, 19.263145F, 19.263145F, 24.340425F, 13.0F, 24.340425F);
      localPath.cubicTo(6.736856F, 24.340425F, 1.659575F, 19.263145F, 1.659575F, 13.0F);
      localPath.cubicTo(1.659575F, 6.736856F, 6.736856F, 1.659575F, 13.0F, 1.659575F);
      localPath.close();
      localCanvas.drawPath(localPath, localPaint);
      localCanvas.restore();
      localCanvas.save();
      localPaint = c.a((Paint)localObject2, paramVarArgs);
      localPaint.setStrokeCap(Paint.Cap.SQUARE);
      localPath = c.j(paramVarArgs);
      localPath.moveTo(20.265247F, 22.957447F);
      localPath.lineTo(23.031206F, 25.723404F);
      localCanvas.drawPath(localPath, localPaint);
      localCanvas.restore();
      localCanvas.save();
      localPaint = c.a((Paint)localObject2, paramVarArgs);
      localPaint.setStrokeCap(Paint.Cap.SQUARE);
      localObject3 = c.a((float[])localObject3, -1.0F, 0.0F, 8.777304F, 0.0F, 1.0F, 0.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject3);
      localCanvas.concat((Matrix)localObject1);
      localObject1 = c.j(paramVarArgs);
      ((Path)localObject1).moveTo(3.28227F, 22.404255F);
      ((Path)localObject1).lineTo(5.495036F, 25.723404F);
      localCanvas.drawPath((Path)localObject1, localPaint);
      localCanvas.restore();
      localCanvas.save();
      localObject1 = c.a((Paint)localObject2, paramVarArgs);
      ((Paint)localObject1).setStrokeCap(Paint.Cap.SQUARE);
      localObject3 = c.j(paramVarArgs);
      ((Path)localObject3).moveTo(13.0F, 5.318182F);
      ((Path)localObject3).lineTo(13.0F, 13.0F);
      localCanvas.drawPath((Path)localObject3, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.save();
      localObject1 = c.a((Paint)localObject2, paramVarArgs);
      ((Paint)localObject1).setStrokeCap(Paint.Cap.SQUARE);
      localObject2 = c.j(paramVarArgs);
      ((Path)localObject2).moveTo(13.0F, 13.0F);
      ((Path)localObject2).lineTo(17.978724F, 15.954546F);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.restore();
      c.h(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.tc
 * JD-Core Version:    0.7.0.1
 */