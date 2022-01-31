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

public final class cm
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
      Object localObject1 = c.h(paramVarArgs);
      Object localObject2 = c.g(paramVarArgs);
      Paint localPaint1 = c.k(paramVarArgs);
      localPaint1.setFlags(385);
      localPaint1.setStyle(Paint.Style.FILL);
      Paint localPaint2 = c.k(paramVarArgs);
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
      localObject2 = c.a((float[])localObject2, 1.0F, 0.0F, 11.0F, 0.0F, 1.0F, 0.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject2);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject1 = c.a(localPaint1, paramVarArgs);
      ((Paint)localObject1).setColor(-14824411);
      localObject2 = c.l(paramVarArgs);
      ((Path)localObject2).moveTo(46.0F, 0.0F);
      ((Path)localObject2).lineTo(68.0F, 22.0F);
      ((Path)localObject2).lineTo(68.0F, 87.0F);
      ((Path)localObject2).cubicTo(68.0F, 88.656853F, 66.656853F, 90.0F, 65.0F, 90.0F);
      ((Path)localObject2).lineTo(3.0F, 90.0F);
      ((Path)localObject2).cubicTo(1.343146F, 90.0F, 2.029061E-016F, 88.656853F, 0.0F, 87.0F);
      ((Path)localObject2).lineTo(0.0F, 3.0F);
      ((Path)localObject2).cubicTo(-2.029061E-016F, 1.343146F, 1.343146F, 3.043592E-016F, 3.0F, 0.0F);
      ((Path)localObject2).lineTo(46.0F, 0.0F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 2);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.save();
      localObject1 = c.a(localPaint1, paramVarArgs);
      ((Paint)localObject1).setColor(-15228131);
      localObject2 = c.l(paramVarArgs);
      ((Path)localObject2).moveTo(68.0F, 22.0F);
      ((Path)localObject2).lineTo(49.0F, 22.0F);
      ((Path)localObject2).cubicTo(47.343147F, 22.0F, 46.0F, 20.656855F, 46.0F, 19.0F);
      ((Path)localObject2).lineTo(46.0F, 0.0F);
      ((Path)localObject2).lineTo(68.0F, 22.0F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 2);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.save();
      localPaint1 = c.a(localPaint1, paramVarArgs);
      localPaint1.setColor(-1);
      localObject1 = c.l(paramVarArgs);
      ((Path)localObject1).moveTo(19.75F, 62.0F);
      ((Path)localObject1).lineTo(24.25F, 62.0F);
      ((Path)localObject1).cubicTo(24.664213F, 62.0F, 25.0F, 62.335785F, 25.0F, 62.75F);
      ((Path)localObject1).lineTo(25.0F, 65.25F);
      ((Path)localObject1).cubicTo(25.0F, 65.664215F, 24.664213F, 66.0F, 24.25F, 66.0F);
      ((Path)localObject1).lineTo(19.75F, 66.0F);
      ((Path)localObject1).cubicTo(19.335787F, 66.0F, 19.0F, 65.664215F, 19.0F, 65.25F);
      ((Path)localObject1).lineTo(19.0F, 62.75F);
      ((Path)localObject1).cubicTo(19.0F, 62.335785F, 19.335787F, 62.0F, 19.75F, 62.0F);
      ((Path)localObject1).close();
      ((Path)localObject1).moveTo(27.75F, 55.0F);
      ((Path)localObject1).lineTo(32.25F, 55.0F);
      ((Path)localObject1).cubicTo(32.664215F, 55.0F, 33.0F, 55.335785F, 33.0F, 55.75F);
      ((Path)localObject1).lineTo(33.0F, 65.25F);
      ((Path)localObject1).cubicTo(33.0F, 65.664215F, 32.664215F, 66.0F, 32.25F, 66.0F);
      ((Path)localObject1).lineTo(27.75F, 66.0F);
      ((Path)localObject1).cubicTo(27.335787F, 66.0F, 27.0F, 65.664215F, 27.0F, 65.25F);
      ((Path)localObject1).lineTo(27.0F, 55.75F);
      ((Path)localObject1).cubicTo(27.0F, 55.335785F, 27.335787F, 55.0F, 27.75F, 55.0F);
      ((Path)localObject1).close();
      ((Path)localObject1).moveTo(35.75F, 44.0F);
      ((Path)localObject1).lineTo(40.25F, 44.0F);
      ((Path)localObject1).cubicTo(40.664215F, 44.0F, 41.0F, 44.335785F, 41.0F, 44.75F);
      ((Path)localObject1).lineTo(41.0F, 65.25F);
      ((Path)localObject1).cubicTo(41.0F, 65.664215F, 40.664215F, 66.0F, 40.25F, 66.0F);
      ((Path)localObject1).lineTo(35.75F, 66.0F);
      ((Path)localObject1).cubicTo(35.335785F, 66.0F, 35.0F, 65.664215F, 35.0F, 65.25F);
      ((Path)localObject1).lineTo(35.0F, 44.75F);
      ((Path)localObject1).cubicTo(35.0F, 44.335785F, 35.335785F, 44.0F, 35.75F, 44.0F);
      ((Path)localObject1).close();
      ((Path)localObject1).moveTo(19.0F, 68.0F);
      ((Path)localObject1).lineTo(49.0F, 68.0F);
      ((Path)localObject1).cubicTo(49.552284F, 68.0F, 50.0F, 68.447716F, 50.0F, 69.0F);
      ((Path)localObject1).cubicTo(50.0F, 69.552284F, 49.552284F, 70.0F, 49.0F, 70.0F);
      ((Path)localObject1).lineTo(19.0F, 70.0F);
      ((Path)localObject1).cubicTo(18.447716F, 70.0F, 18.0F, 69.552284F, 18.0F, 69.0F);
      ((Path)localObject1).cubicTo(18.0F, 68.447716F, 18.447716F, 68.0F, 19.0F, 68.0F);
      ((Path)localObject1).close();
      ((Path)localObject1).moveTo(43.75F, 50.0F);
      ((Path)localObject1).lineTo(48.25F, 50.0F);
      ((Path)localObject1).cubicTo(48.664215F, 50.0F, 49.0F, 50.335785F, 49.0F, 50.75F);
      ((Path)localObject1).lineTo(49.0F, 65.25F);
      ((Path)localObject1).cubicTo(49.0F, 65.664215F, 48.664215F, 66.0F, 48.25F, 66.0F);
      ((Path)localObject1).lineTo(43.75F, 66.0F);
      ((Path)localObject1).cubicTo(43.335785F, 66.0F, 43.0F, 65.664215F, 43.0F, 65.25F);
      ((Path)localObject1).lineTo(43.0F, 50.75F);
      ((Path)localObject1).cubicTo(43.0F, 50.335785F, 43.335785F, 50.0F, 43.75F, 50.0F);
      ((Path)localObject1).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject1, 2);
      localCanvas.drawPath((Path)localObject1, localPaint1);
      localCanvas.restore();
      localCanvas.restore();
      c.j(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.cm
 * JD-Core Version:    0.7.0.1
 */