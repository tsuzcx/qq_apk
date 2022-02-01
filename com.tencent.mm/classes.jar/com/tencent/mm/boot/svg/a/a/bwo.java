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

public final class bwo
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
      localCanvas.save();
      localPaint1 = c.a(localPaint1, paramVarArgs);
      localPaint1.setColor(-12799249);
      localObject2 = c.a((float[])localObject2, 1.0F, 0.0F, 13.0F, 0.0F, 1.0F, 14.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject2);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject1 = c.a(localPaint1, paramVarArgs);
      localObject2 = c.n(paramVarArgs);
      ((Path)localObject2).moveTo(3.0F, 1.0F);
      ((Path)localObject2).cubicTo(3.853062F, -0.05689766F, 5.482409F, 0.103281F, 7.0F, 0.0F);
      ((Path)localObject2).cubicTo(25.664316F, 0.07324726F, 44.346825F, 0.02319152F, 63.0F, 0.0F);
      ((Path)localObject2).cubicTo(65.938164F, -0.3372098F, 69.046921F, 1.835209F, 69.0F, 5.0F);
      ((Path)localObject2).cubicTo(69.056915F, 20.696211F, 68.966949F, 36.453758F, 69.0F, 52.0F);
      ((Path)localObject2).cubicTo(69.176865F, 54.744125F, 67.587502F, 57.517212F, 65.0F, 58.0F);
      ((Path)localObject2).cubicTo(58.361202F, 58.548363F, 51.673885F, 57.547245F, 45.0F, 58.0F);
      ((Path)localObject2).cubicTo(40.268459F, 60.520557F, 38.759064F, 66.88765F, 34.0F, 69.0F);
      ((Path)localObject2).cubicTo(30.462391F, 66.036697F, 28.483185F, 61.331459F, 25.0F, 59.0F);
      ((Path)localObject2).cubicTo(17.807467F, 57.327003F, 10.830264F, 58.658485F, 4.0F, 58.0F);
      ((Path)localObject2).cubicTo(1.394048F, 57.497192F, -0.175323F, 54.714092F, 0.0F, 52.0F);
      ((Path)localObject2).cubicTo(0.004605342F, 36.784126F, 0.01460133F, 21.37697F, 0.0F, 6.0F);
      ((Path)localObject2).cubicTo(-0.1153466F, 3.93755F, 0.6143608F, 1.725087F, 3.0F, 1.0F);
      ((Path)localObject2).lineTo(3.0F, 1.0F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(32.0F, 12.0F);
      ((Path)localObject2).cubicTo(26.251995F, 13.571525F, 25.514194F, 21.794676F, 28.0F, 26.0F);
      ((Path)localObject2).cubicTo(29.081913F, 28.353016F, 31.679375F, 30.572763F, 30.0F, 33.0F);
      ((Path)localObject2).cubicTo(26.373276F, 36.011143F, 21.077284F, 37.070564F, 18.0F, 41.0F);
      ((Path)localObject2).cubicTo(16.761658F, 42.266788F, 16.468559F, 45.667038F, 19.0F, 46.0F);
      ((Path)localObject2).cubicTo(28.263258F, 46.141258F, 37.692955F, 45.858742F, 47.0F, 46.0F);
      ((Path)localObject2).cubicTo(48.719532F, 45.788116F, 51.084538F, 46.534756F, 52.0F, 45.0F);
      ((Path)localObject2).cubicTo(52.155861F, 42.882267F, 52.03458F, 40.743237F, 50.0F, 40.0F);
      ((Path)localObject2).cubicTo(46.779015F, 36.555988F, 41.422382F, 35.70845F, 38.0F, 32.0F);
      ((Path)localObject2).cubicTo(38.47118F, 28.524542F, 41.786228F, 26.15345F, 42.0F, 23.0F);
      ((Path)localObject2).cubicTo(42.301678F, 20.190405F, 42.382534F, 17.244196F, 41.0F, 15.0F);
      ((Path)localObject2).cubicTo(38.936096F, 12.461651F, 35.418911F, 11.482944F, 32.0F, 12.0F);
      ((Path)localObject2).lineTo(32.0F, 12.0F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(12.0F, 18.0F);
      ((Path)localObject2).cubicTo(11.041728F, 22.185745F, 13.108466F, 25.968393F, 15.0F, 29.0F);
      ((Path)localObject2).cubicTo(12.269493F, 33.078186F, 3.214726F, 33.454472F, 5.0F, 40.0F);
      ((Path)localObject2).cubicTo(8.52481F, 40.287003F, 11.839776F, 39.861206F, 15.0F, 40.0F);
      ((Path)localObject2).cubicTo(18.234386F, 36.97966F, 22.245085F, 35.256676F, 26.0F, 33.0F);
      ((Path)localObject2).cubicTo(24.076502F, 31.850311F, 19.011971F, 30.681849F, 21.0F, 28.0F);
      ((Path)localObject2).cubicTo(22.787348F, 24.591984F, 24.127659F, 20.73012F, 22.0F, 17.0F);
      ((Path)localObject2).cubicTo(20.137421F, 13.838175F, 13.73258F, 14.313481F, 12.0F, 18.0F);
      ((Path)localObject2).lineTo(12.0F, 18.0F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(46.0F, 19.0F);
      ((Path)localObject2).cubicTo(44.853928F, 22.34409F, 47.186619F, 25.701599F, 49.0F, 29.0F);
      ((Path)localObject2).cubicTo(47.736687F, 31.267736F, 44.955791F, 31.970932F, 43.0F, 33.0F);
      ((Path)localObject2).cubicTo(46.738415F, 35.249207F, 50.731491F, 36.97253F, 54.0F, 40.0F);
      ((Path)localObject2).cubicTo(57.098003F, 39.834835F, 60.408588F, 40.320137F, 64.0F, 40.0F);
      ((Path)localObject2).cubicTo(64.197937F, 38.141224F, 64.289612F, 36.031635F, 63.0F, 35.0F);
      ((Path)localObject2).cubicTo(59.940014F, 32.882114F, 56.303463F, 31.842178F, 54.0F, 29.0F);
      ((Path)localObject2).cubicTo(55.987682F, 25.80064F, 58.116646F, 21.581469F, 56.0F, 18.0F);
      ((Path)localObject2).cubicTo(54.164314F, 13.727471F, 47.308857F, 14.272201F, 46.0F, 19.0F);
      ((Path)localObject2).lineTo(46.0F, 19.0F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 2);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.restore();
      c.l(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.bwo
 * JD-Core Version:    0.7.0.1
 */