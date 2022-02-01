package com.tencent.mm.boot.svg.a.a;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;

public final class lk
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
      Object localObject1 = c.j(paramVarArgs);
      Object localObject2 = c.i(paramVarArgs);
      Paint localPaint1 = c.m(paramVarArgs);
      localPaint1.setFlags(385);
      localPaint1.setStyle(Paint.Style.FILL);
      Paint localPaint2 = c.m(paramVarArgs);
      localPaint2.setFlags(385);
      localPaint2.setStyle(Paint.Style.STROKE);
      localPaint1.setColor(-16777216);
      localPaint2.setStrokeWidth(1.0F);
      localPaint2.setStrokeCap(Paint.Cap.BUTT);
      localPaint2.setStrokeJoin(Paint.Join.MITER);
      localPaint2.setStrokeMiter(4.0F);
      localPaint2.setPathEffect(null);
      c.a(localPaint2, paramVarArgs).setStrokeWidth(1.0F);
      localPaint1 = c.a(localPaint1, paramVarArgs);
      localPaint1.setColor(-8617851);
      localCanvas.save();
      localObject2 = c.a((float[])localObject2, 1.0F, 0.0F, 10.0F, 0.0F, 1.0F, 10.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject2);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject1 = c.a(localPaint1, paramVarArgs);
      localObject2 = c.n(paramVarArgs);
      ((Path)localObject2).moveTo(20.0F, 65.0F);
      ((Path)localObject2).cubicTo(15.581831F, 65.0F, 12.0F, 61.418266F, 12.0F, 57.000221F);
      ((Path)localObject2).cubicTo(12.0F, 52.581734F, 15.581831F, 49.0F, 20.0F, 49.0F);
      ((Path)localObject2).cubicTo(24.418169F, 49.0F, 28.0F, 52.581734F, 28.0F, 57.000221F);
      ((Path)localObject2).cubicTo(28.0F, 61.418266F, 24.418169F, 65.0F, 20.0F, 65.0F);
      ((Path)localObject2).moveTo(75.814659F, 29.779163F);
      ((Path)localObject2).lineTo(47.199089F, 1.184477F);
      ((Path)localObject2).cubicTo(45.618633F, -0.394826F, 43.056522F, -0.394826F, 41.476063F, 1.184477F);
      ((Path)localObject2).lineTo(1.252038F, 41.379147F);
      ((Path)localObject2).cubicTo(0.3639593F, 42.266579F, -0.02474384F, 43.463757F, 0.08502881F, 44.622719F);
      ((Path)localObject2).lineTo(0.004948767F, 44.70319F);
      ((Path)localObject2).lineTo(0.0F, 76.915031F);
      ((Path)localObject2).lineTo(0.08502881F, 77.0F);
      ((Path)localObject2).cubicTo(5.808503F, 77.0F, 23.96283F, 76.973923F, 32.275406F, 76.961334F);
      ((Path)localObject2).lineTo(32.376633F, 76.860184F);
      ((Path)localObject2).cubicTo(33.526546F, 76.959991F, 34.710651F, 76.571571F, 35.59063F, 75.69268F);
      ((Path)localObject2).lineTo(75.814659F, 35.498009F);
      ((Path)localObject2).cubicTo(77.395111F, 33.918709F, 77.395111F, 31.358015F, 75.814659F, 29.779163F);
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 2);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.restore();
      c.l(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.lk
 * JD-Core Version:    0.7.0.1
 */