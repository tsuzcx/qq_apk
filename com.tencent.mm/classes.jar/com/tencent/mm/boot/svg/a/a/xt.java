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

public final class xt
  extends c
{
  private final int height = 36;
  private final int width = 40;
  
  public final int a(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 40;
      return 36;
      Canvas localCanvas = (Canvas)paramVarArgs[0];
      paramVarArgs = (Looper)paramVarArgs[1];
      c.h(paramVarArgs);
      c.g(paramVarArgs);
      Paint localPaint = c.k(paramVarArgs);
      localPaint.setFlags(385);
      localPaint.setStyle(Paint.Style.FILL);
      Object localObject = c.k(paramVarArgs);
      ((Paint)localObject).setFlags(385);
      ((Paint)localObject).setStyle(Paint.Style.STROKE);
      localPaint.setColor(-16777216);
      ((Paint)localObject).setStrokeWidth(1.0F);
      ((Paint)localObject).setStrokeCap(Paint.Cap.BUTT);
      ((Paint)localObject).setStrokeJoin(Paint.Join.MITER);
      ((Paint)localObject).setStrokeMiter(4.0F);
      ((Paint)localObject).setPathEffect(null);
      c.a((Paint)localObject, paramVarArgs).setStrokeWidth(1.0F);
      localCanvas.save();
      localPaint = c.a(localPaint, paramVarArgs);
      localPaint.setColor(-11048043);
      localObject = c.l(paramVarArgs);
      ((Path)localObject).moveTo(6.223777F, 2.424301F);
      ((Path)localObject).cubicTo(10.598335F, -0.4037837F, 16.69516F, 1.248814F, 20.001913F, 5.017289F);
      ((Path)localObject).cubicTo(22.709318F, 1.97485F, 26.97365F, 0.3844845F, 30.996866F, 1.234984F);
      ((Path)localObject).cubicTo(33.952278F, 1.829643F, 36.280781F, 4.263594F, 37.238361F, 7.070935F);
      ((Path)localObject).cubicTo(38.643734F, 11.081422F, 38.023716F, 15.610507F, 36.039665F, 19.31675F);
      ((Path)localObject).cubicTo(32.526241F, 26.065432F, 26.649864F, 31.368956F, 20.001913F, 34.923077F);
      ((Path)localObject).cubicTo(12.603054F, 30.926418F, 5.961992F, 24.76548F, 2.87569F, 16.785994F);
      ((Path)localObject).cubicTo(1.17409F, 11.966495F, 1.780328F, 5.563545F, 6.223777F, 2.424301F);
      ((Path)localObject).lineTo(6.223777F, 2.424301F);
      ((Path)localObject).lineTo(6.223777F, 2.424301F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(6.579045F, 8.803145F);
      ((Path)localObject).cubicTo(5.677269F, 12.076567F, 6.227972F, 15.709856F, 8.059059F, 18.561125F);
      ((Path)localObject).cubicTo(11.005321F, 23.336306F, 15.466016F, 26.921152F, 20.002432F, 30.076923F);
      ((Path)localObject).cubicTo(23.506281F, 27.668571F, 26.858686F, 24.983397F, 29.639736F, 21.744577F);
      ((Path)localObject).cubicTo(31.945807F, 19.045563F, 33.942104F, 15.744459F, 33.831963F, 12.062725F);
      ((Path)localObject).cubicTo(33.983406F, 9.391392F, 32.937073F, 6.021083F, 29.997694F, 5.391313F);
      ((Path)localObject).cubicTo(25.970676F, 4.187137F, 22.941811F, 7.848109F, 20.002432F, 9.965798F);
      ((Path)localObject).cubicTo(17.118126F, 7.917315F, 14.22005F, 4.332469F, 10.282523F, 5.335949F);
      ((Path)localObject).cubicTo(8.478971F, 5.619691F, 7.074678F, 7.079927F, 6.579045F, 8.803145F);
      ((Path)localObject).lineTo(6.579045F, 8.803145F);
      ((Path)localObject).lineTo(6.579045F, 8.803145F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 2);
      localCanvas.drawPath((Path)localObject, localPaint);
      localCanvas.restore();
      c.j(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.xt
 * JD-Core Version:    0.7.0.1
 */