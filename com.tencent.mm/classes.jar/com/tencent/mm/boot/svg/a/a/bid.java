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

public final class bid
  extends c
{
  private final int height = 144;
  private final int width = 144;
  
  public final int a(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 144;
      return 144;
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
      localPaint1.setColor(-11286451);
      localObject2 = c.a((float[])localObject2, 1.0F, 0.0F, 44.0F, 0.0F, 1.0F, 22.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject2);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject1 = c.a(localPaint1, paramVarArgs);
      localObject2 = c.n(paramVarArgs);
      ((Path)localObject2).moveTo(11.594659F, 0.8389983F);
      ((Path)localObject2).cubicTo(22.046501F, -0.2211007F, 32.598267F, -0.2411025F, 43.070091F, 0.578974F);
      ((Path)localObject2).cubicTo(46.867126F, 0.9590095F, 50.724117F, 1.339045F, 54.311317F, 2.689171F);
      ((Path)localObject2).cubicTo(56.089931F, 3.269225F, 55.980015F, 5.439427F, 56.0F, 6.939568F);
      ((Path)localObject2).cubicTo(55.940048F, 36.002281F, 56.019985F, 65.054993F, 55.96003F, 94.107704F);
      ((Path)localObject2).cubicTo(56.239811F, 97.137985F, 52.752533F, 97.848053F, 50.504288F, 98.358101F);
      ((Path)localObject2).cubicTo(39.792648F, 100.29828F, 28.821213F, 100.17827F, 17.979675F, 99.708221F);
      ((Path)localObject2).cubicTo(12.933614F, 99.278183F, 7.697701F, 99.14817F, 2.941413F, 97.247993F);
      ((Path)localObject2).cubicTo(1.182785F, 96.67794F, 0.9329804F, 94.677757F, 1.012918F, 93.09761F);
      ((Path)localObject2).cubicTo(1.02291F, 64.40493F, 1.042895F, 35.702251F, 1.002926F, 7.009574F);
      ((Path)localObject2).cubicTo(1.102848F, 5.649447F, 0.813074F, 3.939288F, 2.072091F, 2.9992F);
      ((Path)localObject2).cubicTo(5.049767F, 1.599069F, 8.377171F, 1.269038F, 11.594659F, 0.8389983F);
      ((Path)localObject2).lineTo(11.594659F, 0.8389983F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(4.0F, 10.0F);
      ((Path)localObject2).lineTo(4.0F, 87.0F);
      ((Path)localObject2).lineTo(53.0F, 87.0F);
      ((Path)localObject2).lineTo(53.0F, 10.0F);
      ((Path)localObject2).lineTo(4.0F, 10.0F);
      ((Path)localObject2).lineTo(4.0F, 10.0F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(27.34189F, 91.352417F);
      ((Path)localObject2).cubicTo(24.280243F, 92.668205F, 27.048307F, 97.45562F, 29.763947F, 95.56292F);
      ((Path)localObject2).cubicTo(32.605408F, 94.196533F, 30.015589F, 89.722878F, 27.34189F, 91.352417F);
      ((Path)localObject2).lineTo(27.34189F, 91.352417F);
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
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.bid
 * JD-Core Version:    0.7.0.1
 */