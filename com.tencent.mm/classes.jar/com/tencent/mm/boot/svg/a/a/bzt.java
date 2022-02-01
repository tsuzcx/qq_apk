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

public final class bzt
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
      localCanvas.saveLayerAlpha(null, 128, 31);
      localPaint1 = c.a(localPaint1, paramVarArgs);
      localPaint1.setColor(-1);
      localCanvas.save();
      localObject2 = c.a((float[])localObject2, 1.0F, 0.0F, 3.0F, 0.0F, 1.0F, 3.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject2);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject1 = c.a(localPaint1, paramVarArgs);
      localObject2 = c.n(paramVarArgs);
      ((Path)localObject2).moveTo(1.0F, 0.0F);
      ((Path)localObject2).lineTo(17.0F, 0.0F);
      ((Path)localObject2).cubicTo(17.552284F, -1.014531E-016F, 18.0F, 0.4477153F, 18.0F, 1.0F);
      ((Path)localObject2).lineTo(18.0F, 17.0F);
      ((Path)localObject2).cubicTo(18.0F, 17.552284F, 17.552284F, 18.0F, 17.0F, 18.0F);
      ((Path)localObject2).lineTo(1.0F, 18.0F);
      ((Path)localObject2).cubicTo(0.4477153F, 18.0F, 6.763538E-017F, 17.552284F, 0.0F, 17.0F);
      ((Path)localObject2).lineTo(0.0F, 1.0F);
      ((Path)localObject2).cubicTo(-6.763538E-017F, 0.4477153F, 0.4477153F, 1.014531E-016F, 1.0F, 0.0F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(4.198F, 5.848F);
      ((Path)localObject2).lineTo(4.198F, 6.992F);
      ((Path)localObject2).lineTo(5.87F, 6.992F);
      ((Path)localObject2).cubicTo(6.332F, 8.587F, 7.157F, 9.984F, 8.345F, 11.194F);
      ((Path)localObject2).cubicTo(7.201F, 12.162F, 5.749F, 12.866F, 4.0F, 13.317F);
      ((Path)localObject2).lineTo(4.616F, 14.329F);
      ((Path)localObject2).cubicTo(6.409F, 13.823F, 7.927F, 13.02F, 9.159F, 11.931F);
      ((Path)localObject2).cubicTo(10.325F, 12.899F, 11.788F, 13.713F, 13.548F, 14.373F);
      ((Path)localObject2).lineTo(14.186F, 13.394F);
      ((Path)localObject2).cubicTo(12.514F, 12.778F, 11.106F, 12.03F, 9.973F, 11.128F);
      ((Path)localObject2).cubicTo(10.985F, 10.017F, 11.755F, 8.642F, 12.283F, 6.992F);
      ((Path)localObject2).lineTo(13.944F, 6.992F);
      ((Path)localObject2).lineTo(13.944F, 5.848F);
      ((Path)localObject2).lineTo(9.786F, 5.848F);
      ((Path)localObject2).cubicTo(9.456F, 5.133F, 9.093F, 4.517F, 8.697F, 4.0F);
      ((Path)localObject2).lineTo(7.542F, 4.418F);
      ((Path)localObject2).cubicTo(7.938F, 4.869F, 8.279F, 5.342F, 8.554F, 5.848F);
      ((Path)localObject2).lineTo(4.198F, 5.848F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(6.97F, 6.992F);
      ((Path)localObject2).lineTo(11.095F, 6.992F);
      ((Path)localObject2).cubicTo(10.666F, 8.323F, 10.017F, 9.467F, 9.159F, 10.413F);
      ((Path)localObject2).cubicTo(8.147F, 9.423F, 7.421F, 8.29F, 6.97F, 6.992F);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.bzt
 * JD-Core Version:    0.7.0.1
 */