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

public final class amp
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
      localPaint.setColor(-1);
      localCanvas.save();
      localPaint = c.a(localPaint, paramVarArgs);
      localObject = c.n(paramVarArgs);
      ((Path)localObject).moveTo(9.400753F, 4.5F);
      ((Path)localObject).lineTo(9.400753F, 3.0F);
      ((Path)localObject).cubicTo(9.400753F, 2.447715F, 9.764522F, 2.0F, 10.213253F, 2.0F);
      ((Path)localObject).lineTo(18.4939F, 2.0F);
      ((Path)localObject).cubicTo(18.942633F, 2.0F, 19.3064F, 2.447715F, 19.3064F, 3.0F);
      ((Path)localObject).lineTo(19.3064F, 17.001755F);
      ((Path)localObject).cubicTo(19.3064F, 17.554039F, 18.942633F, 18.001755F, 18.4939F, 18.001755F);
      ((Path)localObject).lineTo(17.27515F, 18.001755F);
      ((Path)localObject).lineTo(17.27515F, 6.0F);
      ((Path)localObject).cubicTo(17.27515F, 5.171573F, 16.729498F, 4.5F, 16.0564F, 4.5F);
      ((Path)localObject).lineTo(9.400753F, 4.5F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(15.211858F, 6.0F);
      ((Path)localObject).cubicTo(15.660589F, 6.0F, 16.024357F, 6.596954F, 16.024357F, 7.333334F);
      ((Path)localObject).lineTo(16.024357F, 20.666666F);
      ((Path)localObject).cubicTo(16.024357F, 21.403046F, 15.660589F, 22.0F, 15.211858F, 22.0F);
      ((Path)localObject).lineTo(5.8125F, 22.0F);
      ((Path)localObject).cubicTo(5.363769F, 22.0F, 5.0F, 21.403046F, 5.0F, 20.666666F);
      ((Path)localObject).lineTo(5.0F, 7.333334F);
      ((Path)localObject).cubicTo(5.0F, 6.596954F, 5.363769F, 6.0F, 5.8125F, 6.0F);
      ((Path)localObject).lineTo(15.211858F, 6.0F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(10.5F, 18.5F);
      ((Path)localObject).cubicTo(9.947715F, 18.5F, 9.5F, 18.947716F, 9.5F, 19.5F);
      ((Path)localObject).cubicTo(9.5F, 20.052284F, 9.947715F, 20.5F, 10.5F, 20.5F);
      ((Path)localObject).cubicTo(11.052284F, 20.5F, 11.5F, 20.052284F, 11.5F, 19.5F);
      ((Path)localObject).cubicTo(11.5F, 18.947716F, 11.052284F, 18.5F, 10.5F, 18.5F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 2);
      localCanvas.drawPath((Path)localObject, localPaint);
      localCanvas.restore();
      c.l(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.amp
 * JD-Core Version:    0.7.0.1
 */