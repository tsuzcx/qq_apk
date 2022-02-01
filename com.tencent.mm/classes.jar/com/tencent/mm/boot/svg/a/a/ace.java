package com.tencent.mm.boot.svg.a.a;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;

public final class ace
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
      c.j(paramVarArgs);
      c.i(paramVarArgs);
      Paint localPaint = c.m(paramVarArgs);
      localPaint.setFlags(385);
      localPaint.setStyle(Paint.Style.FILL);
      Object localObject = c.m(paramVarArgs);
      ((Paint)localObject).setFlags(385);
      ((Paint)localObject).setStyle(Paint.Style.STROKE);
      localPaint.setColor(-16777216);
      ((Paint)localObject).setStrokeWidth(1.0F);
      ((Paint)localObject).setStrokeCap(Paint.Cap.BUTT);
      ((Paint)localObject).setStrokeJoin(Paint.Join.MITER);
      ((Paint)localObject).setStrokeMiter(4.0F);
      ((Paint)localObject).setPathEffect(null);
      c.a((Paint)localObject, paramVarArgs).setStrokeWidth(1.0F);
      localPaint = c.a(localPaint, paramVarArgs);
      localPaint.setColor(-436207616);
      localCanvas.save();
      localPaint = c.a(localPaint, paramVarArgs);
      localObject = c.n(paramVarArgs);
      ((Path)localObject).moveTo(12.0F, 2.5F);
      ((Path)localObject).lineTo(20.0F, 5.5F);
      ((Path)localObject).lineTo(20.000801F, 9.049226F);
      ((Path)localObject).cubicTo(17.133373F, 10.242318F, 11.401675F, 12.630553F, 11.401675F, 12.630553F);
      ((Path)localObject).cubicTo(11.300027F, 12.665492F, 11.190457F, 12.685315F, 11.076135F, 12.685315F);
      ((Path)localObject).cubicTo(10.883926F, 12.685315F, 10.704655F, 12.631297F, 10.555481F, 12.539613F);
      ((Path)localObject).lineTo(10.555481F, 12.539613F);
      ((Path)localObject).lineTo(8.50798F, 11.171546F);
      ((Path)localObject).cubicTo(8.454648F, 11.134377F, 8.389434F, 11.112324F, 8.31762F, 11.112324F);
      ((Path)localObject).cubicTo(8.142308F, 11.112324F, 8.0F, 11.245636F, 8.0F, 11.410172F);
      ((Path)localObject).cubicTo(8.0F, 11.453039F, 8.011617F, 11.497147F, 8.030363F, 11.53605F);
      ((Path)localObject).lineTo(8.030363F, 11.53605F);
      ((Path)localObject).lineTo(9.765787F, 15.109726F);
      ((Path)localObject).lineTo(9.80724F, 15.194966F);
      ((Path)localObject).cubicTo(9.916017F, 15.376846F, 10.123275F, 15.5F, 10.361688F, 15.5F);
      ((Path)localObject).cubicTo(10.464393F, 15.5F, 10.56129F, 15.476212F, 10.647361F, 15.435822F);
      ((Path)localObject).lineTo(10.647361F, 15.435822F);
      ((Path)localObject).lineTo(10.717063F, 15.397909F);
      ((Path)localObject).cubicTo(10.717063F, 15.397909F, 16.174868F, 12.443493F, 20.001129F, 10.372263F);
      ((Path)localObject).lineTo(20.0F, 11.253789F);
      ((Path)localObject).cubicTo(20.0F, 16.100143F, 16.701654F, 20.324587F, 12.0F, 21.5F);
      ((Path)localObject).cubicTo(7.298345F, 20.324587F, 4.0F, 16.100143F, 4.0F, 11.253789F);
      ((Path)localObject).lineTo(4.0F, 5.5F);
      ((Path)localObject).lineTo(12.0F, 2.5F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 2);
      localCanvas.drawPath((Path)localObject, localPaint);
      localCanvas.restore();
      c.l(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.ace
 * JD-Core Version:    0.7.0.1
 */