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

public final class azw
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
      Object localObject1 = c.h(paramVarArgs);
      float[] arrayOfFloat = c.g(paramVarArgs);
      Object localObject2 = c.k(paramVarArgs);
      ((Paint)localObject2).setFlags(385);
      ((Paint)localObject2).setStyle(Paint.Style.FILL);
      Paint localPaint = c.k(paramVarArgs);
      localPaint.setFlags(385);
      localPaint.setStyle(Paint.Style.STROKE);
      ((Paint)localObject2).setColor(-16777216);
      localPaint.setStrokeWidth(1.0F);
      localPaint.setStrokeCap(Paint.Cap.BUTT);
      localPaint.setStrokeJoin(Paint.Join.MITER);
      localPaint.setStrokeMiter(4.0F);
      localPaint.setPathEffect(null);
      c.a(localPaint, paramVarArgs).setStrokeWidth(1.0F);
      localCanvas.saveLayerAlpha(null, 204, 4);
      localCanvas.save();
      arrayOfFloat = c.a(arrayOfFloat, 1.0F, 0.0F, 12.0F, 0.0F, 1.0F, 12.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      arrayOfFloat = c.a(arrayOfFloat, 1.0F, 0.0F, 9.0F, 0.0F, 1.0F, 6.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject1);
      localObject1 = c.a((Paint)localObject2, paramVarArgs);
      ((Paint)localObject1).setColor(-1);
      localCanvas.save();
      localObject1 = c.a((Paint)localObject1, paramVarArgs);
      localObject2 = c.l(paramVarArgs);
      ((Path)localObject2).moveTo(48.757702F, 15.974849F);
      ((Path)localObject2).lineTo(27.774939F, 3.734904F);
      ((Path)localObject2).cubicTo(27.466654F, 3.555071F, 26.53348F, 3.554993F, 26.225061F, 3.734904F);
      ((Path)localObject2).lineTo(5.2423F, 15.974849F);
      ((Path)localObject2).lineTo(27.0F, 28.536663F);
      ((Path)localObject2).lineTo(48.757702F, 15.974849F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(50.400002F, 19.183588F);
      ((Path)localObject2).lineTo(28.799999F, 31.654354F);
      ((Path)localObject2).lineTo(28.799999F, 56.897388F);
      ((Path)localObject2).lineTo(49.597191F, 44.765697F);
      ((Path)localObject2).cubicTo(49.920998F, 44.576809F, 50.400002F, 43.743988F, 50.400002F, 43.37328F);
      ((Path)localObject2).lineTo(50.400002F, 19.183588F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(3.6F, 19.183588F);
      ((Path)localObject2).lineTo(3.6F, 43.37328F);
      ((Path)localObject2).cubicTo(3.6F, 43.736622F, 4.083672F, 44.579533F, 4.402809F, 44.765697F);
      ((Path)localObject2).lineTo(25.200001F, 56.897388F);
      ((Path)localObject2).lineTo(25.200001F, 31.654354F);
      ((Path)localObject2).lineTo(3.6F, 19.183588F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(24.411127F, 0.6252996F);
      ((Path)localObject2).cubicTo(25.840921F, -0.2087476F, 28.160156F, -0.2081187F, 29.588873F, 0.6252996F);
      ((Path)localObject2).lineTo(51.411125F, 13.354947F);
      ((Path)localObject2).cubicTo(52.840923F, 14.188994F, 54.0F, 16.218639F, 54.0F, 17.856966F);
      ((Path)localObject2).lineTo(54.0F, 43.37328F);
      ((Path)localObject2).cubicTo(54.0F, 45.025631F, 52.839844F, 47.041882F, 51.411125F, 47.875301F);
      ((Path)localObject2).lineTo(29.588873F, 60.604946F);
      ((Path)localObject2).cubicTo(28.159079F, 61.438995F, 25.839844F, 61.438366F, 24.411127F, 60.604946F);
      ((Path)localObject2).lineTo(2.588874F, 47.875301F);
      ((Path)localObject2).cubicTo(1.159078F, 47.041252F, 0.0F, 45.011608F, 0.0F, 43.37328F);
      ((Path)localObject2).lineTo(0.0F, 17.856966F);
      ((Path)localObject2).cubicTo(0.0F, 16.204617F, 1.160156F, 14.188366F, 2.588874F, 13.354947F);
      ((Path)localObject2).lineTo(24.411127F, 0.6252996F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 1);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.restore();
      localCanvas.restore();
      localCanvas.restore();
      c.j(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.azw
 * JD-Core Version:    0.7.0.1
 */