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

public final class bqh
  extends c
{
  private final int height = 45;
  private final int width = 45;
  
  public final int a(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 45;
      return 45;
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
      localPaint1.setColor(-16777216);
      localCanvas.save();
      localObject2 = c.a((float[])localObject2, 1.0F, 0.0F, 4.0F, 0.0F, 1.0F, 3.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject2);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject2 = c.a((float[])localObject2, 1.0F, 0.0F, 0.5F, 0.0F, 1.0F, 0.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject2);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject1 = c.a(localPaint1, paramVarArgs);
      localObject2 = c.n(paramVarArgs);
      ((Path)localObject2).moveTo(9.457563F, 7.808734F);
      ((Path)localObject2).cubicTo(11.167546F, 6.027428F, 13.166591F, 5.148177F, 14.952687F, 4.761591F);
      ((Path)localObject2).cubicTo(14.593289F, 4.266964F, 14.38131F, 3.65827F, 14.38131F, 3.0F);
      ((Path)localObject2).cubicTo(14.38131F, 1.342919F, 15.724614F, 0.0F, 17.38131F, 0.0F);
      ((Path)localObject2).cubicTo(19.038004F, 0.0F, 20.38131F, 1.342919F, 20.38131F, 3.0F);
      ((Path)localObject2).cubicTo(20.38131F, 3.65827F, 20.169329F, 4.266964F, 19.809931F, 4.761591F);
      ((Path)localObject2).cubicTo(23.826532F, 5.630951F, 28.920044F, 8.991799F, 29.38131F, 19.5F);
      ((Path)localObject2).cubicTo(29.192793F, 23.447571F, 29.636072F, 26.433947F, 30.30884F, 28.660011F);
      ((Path)localObject2).lineTo(37.466099F, 35.817268F);
      ((Path)localObject2).cubicTo(37.863621F, 36.214794F, 37.863781F, 36.846252F, 37.474403F, 37.23563F);
      ((Path)localObject2).lineTo(36.61694F, 38.093094F);
      ((Path)localObject2).cubicTo(36.2272F, 38.482834F, 35.592541F, 38.478752F, 35.198578F, 38.084789F);
      ((Path)localObject2).lineTo(0.09464216F, 2.980852F);
      ((Path)localObject2).cubicTo(-0.3028815F, 2.583328F, -0.303039F, 1.951868F, 0.08633687F, 1.562492F);
      ((Path)localObject2).lineTo(0.9438008F, 0.7050276F);
      ((Path)localObject2).cubicTo(1.33354F, 0.3152888F, 1.968198F, 0.31937F, 2.362161F, 0.7133328F);
      ((Path)localObject2).lineTo(9.457563F, 7.808734F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(6.360238F, 13.343368F);
      ((Path)localObject2).lineTo(29.01687F, 36.0F);
      ((Path)localObject2).lineTo(0.8813093F, 36.0F);
      ((Path)localObject2).lineTo(0.8813093F, 34.5F);
      ((Path)localObject2).cubicTo(0.8813093F, 34.5F, 5.943809F, 31.278849F, 5.38131F, 19.5F);
      ((Path)localObject2).cubicTo(5.487063F, 17.090797F, 5.836307F, 15.05729F, 6.360238F, 13.343368F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 2);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.restore();
      localCanvas.restore();
      c.l(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.bqh
 * JD-Core Version:    0.7.0.1
 */