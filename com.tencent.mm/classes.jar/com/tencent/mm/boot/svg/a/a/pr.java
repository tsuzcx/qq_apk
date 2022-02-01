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

public final class pr
  extends c
{
  private final int height = 39;
  private final int width = 39;
  
  public final int a(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 39;
      return 39;
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
      localPaint1.setColor(-1710619);
      localObject2 = c.a((float[])localObject2, 1.0F, 0.0F, -322.0F, 0.0F, 1.0F, -941.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject2);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject2 = c.a((float[])localObject2, 1.0F, 0.0F, 323.0F, 0.0F, 1.0F, 942.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject2);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject1 = c.a(localPaint1, paramVarArgs);
      localObject2 = c.n(paramVarArgs);
      ((Path)localObject2).moveTo(18.5F, 0.0F);
      ((Path)localObject2).cubicTo(8.282732F, -6.256272E-016F, 1.251254E-015F, 8.282732F, 0.0F, 18.5F);
      ((Path)localObject2).cubicTo(-1.251254E-015F, 28.717268F, 8.282732F, 37.0F, 18.5F, 37.0F);
      ((Path)localObject2).cubicTo(28.717268F, 37.0F, 37.0F, 28.717268F, 37.0F, 18.5F);
      ((Path)localObject2).cubicTo(37.0F, 13.593495F, 35.0509F, 8.887947F, 31.581476F, 5.418525F);
      ((Path)localObject2).cubicTo(28.112053F, 1.949102F, 23.406506F, 3.004368E-016F, 18.5F, 0.0F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(18.470951F, 34.999973F);
      ((Path)localObject2).cubicTo(9.365829F, 34.983944F, 1.99466F, 27.595451F, 2.000003F, 18.490316F);
      ((Path)localObject2).cubicTo(2.005346F, 9.385182F, 9.385182F, 2.005346F, 18.490316F, 2.000003F);
      ((Path)localObject2).cubicTo(27.595451F, 1.99466F, 34.983944F, 9.365829F, 34.999973F, 18.470951F);
      ((Path)localObject2).cubicTo(35.007698F, 22.857082F, 33.26873F, 27.065794F, 30.167261F, 30.167261F);
      ((Path)localObject2).cubicTo(27.065794F, 33.26873F, 22.857082F, 35.007698F, 18.470951F, 34.999973F);
      ((Path)localObject2).lineTo(18.470951F, 34.999973F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 1);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.save();
      localObject1 = c.a(localPaint1, paramVarArgs);
      localObject2 = c.n(paramVarArgs);
      ((Path)localObject2).moveTo(14.230769F, 27.508078F);
      ((Path)localObject2).lineTo(9.961538F, 27.508078F);
      ((Path)localObject2).lineTo(11.66923F, 9.961538F);
      ((Path)localObject2).lineTo(16.066538F, 9.961538F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 1);
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 1);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.save();
      localPaint1 = c.a(localPaint1, paramVarArgs);
      localObject1 = c.n(paramVarArgs);
      ((Path)localObject1).moveTo(21.150963F, 16.820768F);
      ((Path)localObject1).cubicTo(20.627676F, 17.163134F, 20.287874F, 17.724329F, 20.22702F, 18.346695F);
      ((Path)localObject1).cubicTo(20.166168F, 18.969063F, 20.390827F, 19.585449F, 20.837887F, 20.022692F);
      ((Path)localObject1).cubicTo(22.147118F, 21.801538F, 26.530195F, 27.508078F, 26.530195F, 27.508078F);
      ((Path)localObject1).lineTo(20.980194F, 27.508078F);
      ((Path)localObject1).cubicTo(19.115963F, 24.861155F, 18.247887F, 23.452307F, 16.525963F, 21.033077F);
      ((Path)localObject1).cubicTo(15.165143F, 19.326057F, 15.424838F, 16.843111F, 17.109425F, 15.454616F);
      ((Path)localObject1).cubicTo(17.820963F, 14.743077F, 20.254425F, 12.409231F, 22.801733F, 9.961538F);
      ((Path)localObject1).lineTo(28.10981F, 9.961538F);
      ((Path)localObject1).lineTo(21.150963F, 16.820768F);
      ((Path)localObject1).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject1, 1);
      localCanvas.drawPath((Path)localObject1, localPaint1);
      localCanvas.restore();
      localCanvas.restore();
      localCanvas.restore();
      c.l(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.pr
 * JD-Core Version:    0.7.0.1
 */