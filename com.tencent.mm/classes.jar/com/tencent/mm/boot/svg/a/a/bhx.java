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

public final class bhx
  extends c
{
  private final int height = 90;
  private final int width = 90;
  
  public final int a(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 90;
      return 90;
      Canvas localCanvas = (Canvas)paramVarArgs[0];
      paramVarArgs = (Looper)paramVarArgs[1];
      Object localObject1 = c.j(paramVarArgs);
      float[] arrayOfFloat = c.i(paramVarArgs);
      Paint localPaint = c.m(paramVarArgs);
      localPaint.setFlags(385);
      localPaint.setStyle(Paint.Style.FILL);
      Object localObject2 = c.m(paramVarArgs);
      ((Paint)localObject2).setFlags(385);
      ((Paint)localObject2).setStyle(Paint.Style.STROKE);
      localPaint.setColor(-16777216);
      ((Paint)localObject2).setStrokeWidth(1.0F);
      ((Paint)localObject2).setStrokeCap(Paint.Cap.BUTT);
      ((Paint)localObject2).setStrokeJoin(Paint.Join.MITER);
      ((Paint)localObject2).setStrokeMiter(4.0F);
      ((Paint)localObject2).setPathEffect(null);
      localObject2 = c.a((Paint)localObject2, paramVarArgs);
      ((Paint)localObject2).setStrokeWidth(1.0F);
      localCanvas.save();
      arrayOfFloat = c.a(arrayOfFloat, 1.0F, 0.0F, -56.0F, 0.0F, 1.0F, -265.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      arrayOfFloat = c.a(arrayOfFloat, 1.0F, 0.0F, 56.0F, 0.0F, 1.0F, 265.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject1 = c.a((Paint)localObject2, paramVarArgs);
      ((Paint)localObject1).setColor(-16139513);
      ((Paint)localObject1).setStrokeWidth(6.0F);
      localObject2 = c.n(paramVarArgs);
      ((Path)localObject2).moveTo(3.0F, 45.0F);
      ((Path)localObject2).cubicTo(3.0F, 21.804039F, 21.804039F, 3.0F, 45.0F, 3.0F);
      ((Path)localObject2).lineTo(45.0F, 3.0F);
      ((Path)localObject2).cubicTo(68.195961F, 3.0F, 87.0F, 21.804039F, 87.0F, 45.0F);
      ((Path)localObject2).lineTo(87.0F, 45.0F);
      ((Path)localObject2).cubicTo(87.0F, 68.195961F, 68.195961F, 87.0F, 45.0F, 87.0F);
      ((Path)localObject2).lineTo(45.0F, 87.0F);
      ((Path)localObject2).cubicTo(21.804039F, 87.0F, 3.0F, 68.195961F, 3.0F, 45.0F);
      ((Path)localObject2).lineTo(3.0F, 45.0F);
      ((Path)localObject2).close();
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.save();
      localPaint = c.a(localPaint, paramVarArgs);
      localPaint.setColor(-16139513);
      localObject1 = c.n(paramVarArgs);
      ((Path)localObject1).moveTo(49.822151F, 67.367676F);
      ((Path)localObject1).lineTo(46.059238F, 63.604759F);
      ((Path)localObject1).cubicTo(50.438366F, 58.779804F, 53.118694F, 52.299812F, 53.118694F, 45.175297F);
      ((Path)localObject1).cubicTo(53.118694F, 38.068485F, 50.451668F, 31.602989F, 46.091843F, 26.781826F);
      ((Path)localObject1).lineTo(49.854874F, 23.018793F);
      ((Path)localObject1).cubicTo(55.131969F, 28.813019F, 58.363636F, 36.605614F, 58.363636F, 45.175297F);
      ((Path)localObject1).cubicTo(58.363636F, 53.76268F, 55.11861F, 61.569759F, 49.822151F, 67.367676F);
      ((Path)localObject1).close();
      ((Path)localObject1).moveTo(41.090847F, 58.636372F);
      ((Path)localObject1).lineTo(37.327278F, 54.872803F);
      ((Path)localObject1).cubicTo(39.788017F, 52.418816F, 41.317581F, 48.980961F, 41.317581F, 45.175297F);
      ((Path)localObject1).cubicTo(41.317581F, 41.387341F, 39.802212F, 37.963772F, 37.361561F, 35.512104F);
      ((Path)localObject1).lineTo(41.124847F, 31.748817F);
      ((Path)localObject1).cubicTo(44.482662F, 35.17379F, 46.562519F, 39.92448F, 46.562519F, 45.175297F);
      ((Path)localObject1).cubicTo(46.562519F, 50.443817F, 44.468616F, 55.208832F, 41.090847F, 58.636372F);
      ((Path)localObject1).close();
      ((Path)localObject1).moveTo(32.620003F, 50.165524F);
      ((Path)localObject1).lineTo(27.664072F, 45.209595F);
      ((Path)localObject1).lineTo(32.655266F, 40.218399F);
      ((Path)localObject1).cubicTo(33.950462F, 41.451469F, 34.761406F, 43.215885F, 34.761406F, 45.175297F);
      ((Path)localObject1).cubicTo(34.761406F, 47.152435F, 33.935726F, 48.931026F, 32.620003F, 50.165524F);
      ((Path)localObject1).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject1, 2);
      localCanvas.drawPath((Path)localObject1, localPaint);
      localCanvas.restore();
      localCanvas.restore();
      localCanvas.restore();
      c.l(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.bhx
 * JD-Core Version:    0.7.0.1
 */