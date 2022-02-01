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

public final class arq
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
      localCanvas.save();
      localPaint1 = c.a(localPaint1, paramVarArgs);
      localPaint1.setColor(-16777216);
      localObject2 = c.a((float[])localObject2, 1.0F, 0.0F, 12.0F, 0.0F, 1.0F, 15.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject2);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject1 = c.a(localPaint1, paramVarArgs);
      localObject2 = c.n(paramVarArgs);
      ((Path)localObject2).moveTo(46.5F, 25.5F);
      ((Path)localObject2).cubicTo(47.328426F, 25.5F, 48.0F, 26.171574F, 48.0F, 27.0F);
      ((Path)localObject2).cubicTo(48.0F, 27.43211F, 47.813652F, 27.843229F, 47.488693F, 28.128046F);
      ((Path)localObject2).lineTo(32.690472F, 41.098175F);
      ((Path)localObject2).cubicTo(32.19207F, 41.535007F, 31.433912F, 41.485096F, 30.99708F, 40.986694F);
      ((Path)localObject2).cubicTo(30.636261F, 40.57502F, 30.599783F, 39.971336F, 30.908403F, 39.519211F);
      ((Path)localObject2).lineTo(37.406178F, 30.0F);
      ((Path)localObject2).lineTo(-0.00327782F, 30.0F);
      ((Path)localObject2).lineTo(-0.00327782F, 25.5F);
      ((Path)localObject2).lineTo(46.5F, 25.5F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(16.999641F, 1.013306F);
      ((Path)localObject2).cubicTo(17.36046F, 1.424981F, 17.39694F, 2.028662F, 17.08832F, 2.48079F);
      ((Path)localObject2).lineTo(10.590546F, 12.0F);
      ((Path)localObject2).lineTo(48.0F, 12.0F);
      ((Path)localObject2).lineTo(48.0F, 16.5F);
      ((Path)localObject2).lineTo(1.496722F, 16.5F);
      ((Path)localObject2).cubicTo(0.6682951F, 16.5F, -0.00327782F, 15.828427F, -0.00327782F, 15.0F);
      ((Path)localObject2).cubicTo(-0.00327782F, 14.56789F, 0.1830697F, 14.156771F, 0.5080293F, 13.871955F);
      ((Path)localObject2).lineTo(15.306251F, 0.9018236F);
      ((Path)localObject2).cubicTo(15.804652F, 0.464992F, 16.562809F, 0.5149038F, 16.999641F, 1.013306F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 1);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.restore();
      c.l(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.arq
 * JD-Core Version:    0.7.0.1
 */