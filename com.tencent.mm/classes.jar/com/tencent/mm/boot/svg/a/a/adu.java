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

public final class adu
  extends c
{
  private final int height = 54;
  private final int width = 60;
  
  public final int a(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 60;
      return 54;
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
      localPaint1.setColor(-1);
      localObject2 = c.a((float[])localObject2, 1.0F, 0.0F, 4.0F, 0.0F, 1.0F, 2.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject2);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject1 = c.a(localPaint1, paramVarArgs);
      localObject2 = c.n(paramVarArgs);
      ((Path)localObject2).moveTo(6.101011F, 2.057324F);
      ((Path)localObject2).cubicTo(12.419818F, -2.027688F, 21.226343F, 0.3593974F, 26.002764F, 5.80275F);
      ((Path)localObject2).cubicTo(29.913458F, 1.408117F, 36.073051F, -0.889078F, 41.884361F, 0.3394218F);
      ((Path)localObject2).cubicTo(46.15329F, 1.198373F, 49.516685F, 4.71408F, 50.899857F, 8.769128F);
      ((Path)localObject2).cubicTo(52.929836F, 14.562054F, 52.034256F, 21.104065F, 49.168404F, 26.457527F);
      ((Path)localObject2).cubicTo(44.093456F, 36.205624F, 35.605358F, 43.866268F, 26.002764F, 49.0F);
      ((Path)localObject2).cubicTo(15.315523F, 43.227051F, 5.722878F, 34.327915F, 1.264885F, 22.801992F);
      ((Path)localObject2).cubicTo(-1.192981F, 15.840492F, -0.3173041F, 6.591787F, 6.101011F, 2.057324F);
      ((Path)localObject2).lineTo(6.101011F, 2.057324F);
      ((Path)localObject2).lineTo(6.101011F, 2.057324F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(6.614176F, 11.27121F);
      ((Path)localObject2).cubicTo(5.31161F, 15.999485F, 6.10707F, 21.24757F, 8.751974F, 25.366068F);
      ((Path)localObject2).cubicTo(13.007686F, 32.263554F, 19.450912F, 37.441662F, 26.003513F, 42.0F);
      ((Path)localObject2).cubicTo(31.064629F, 38.521271F, 35.90699F, 34.642685F, 39.924065F, 29.96439F);
      ((Path)localObject2).cubicTo(43.255054F, 26.065813F, 46.138596F, 21.297552F, 45.979504F, 15.979492F);
      ((Path)localObject2).cubicTo(46.198254F, 12.1209F, 44.686882F, 7.252676F, 40.441113F, 6.343008F);
      ((Path)localObject2).cubicTo(34.624313F, 4.603642F, 30.249281F, 9.891713F, 26.003513F, 12.950597F);
      ((Path)localObject2).cubicTo(21.837292F, 9.991676F, 17.651184F, 4.813565F, 11.963644F, 6.263037F);
      ((Path)localObject2).cubicTo(9.358513F, 6.672887F, 7.33009F, 8.782118F, 6.614176F, 11.27121F);
      ((Path)localObject2).lineTo(6.614176F, 11.27121F);
      ((Path)localObject2).lineTo(6.614176F, 11.27121F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 2);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.restore();
      c.l(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.adu
 * JD-Core Version:    0.7.0.1
 */