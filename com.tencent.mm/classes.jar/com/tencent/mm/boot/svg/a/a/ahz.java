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

public final class ahz
  extends c
{
  private final int height = 180;
  private final int width = 180;
  
  public final int a(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 180;
      return 180;
      Canvas localCanvas = (Canvas)paramVarArgs[0];
      paramVarArgs = (Looper)paramVarArgs[1];
      c.h(paramVarArgs);
      c.g(paramVarArgs);
      Paint localPaint = c.k(paramVarArgs);
      localPaint.setFlags(385);
      localPaint.setStyle(Paint.Style.FILL);
      Object localObject1 = c.k(paramVarArgs);
      ((Paint)localObject1).setFlags(385);
      ((Paint)localObject1).setStyle(Paint.Style.STROKE);
      localPaint.setColor(-16777216);
      ((Paint)localObject1).setStrokeWidth(1.0F);
      ((Paint)localObject1).setStrokeCap(Paint.Cap.BUTT);
      ((Paint)localObject1).setStrokeJoin(Paint.Join.MITER);
      ((Paint)localObject1).setStrokeMiter(4.0F);
      ((Paint)localObject1).setPathEffect(null);
      c.a((Paint)localObject1, paramVarArgs).setStrokeWidth(1.0F);
      localCanvas.save();
      localObject1 = c.a(localPaint, paramVarArgs);
      ((Paint)localObject1).setColor(1711276032);
      Object localObject2 = c.l(paramVarArgs);
      ((Path)localObject2).moveTo(90.0F, 0.0F);
      ((Path)localObject2).cubicTo(139.70563F, 0.0F, 180.0F, 40.294369F, 180.0F, 90.0F);
      ((Path)localObject2).cubicTo(180.0F, 139.70563F, 139.70563F, 180.0F, 90.0F, 180.0F);
      ((Path)localObject2).cubicTo(40.294369F, 180.0F, 0.0F, 139.70563F, 0.0F, 90.0F);
      ((Path)localObject2).cubicTo(0.0F, 40.294369F, 40.294369F, 0.0F, 90.0F, 0.0F);
      ((Path)localObject2).close();
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localObject2 = c.a(localPaint, paramVarArgs);
      ((Paint)localObject2).setColor(-1);
      localObject1 = c.l(paramVarArgs);
      ((Path)localObject1).moveTo(69.0F, 59.645351F);
      ((Path)localObject1).cubicTo(69.0F, 56.333775F, 71.315887F, 54.997013F, 74.191467F, 56.67054F);
      ((Path)localObject1).lineTo(126.27224F, 86.980492F);
      ((Path)localObject1).cubicTo(129.1394F, 88.649124F, 129.14781F, 91.349625F, 126.27224F, 93.023155F);
      ((Path)localObject1).lineTo(74.191467F, 123.33311F);
      ((Path)localObject1).cubicTo(71.324303F, 125.00174F, 69.0F, 123.65884F, 69.0F, 120.35829F);
      ((Path)localObject1).lineTo(69.0F, 59.645351F);
      ((Path)localObject1).close();
      localCanvas.saveLayerAlpha(null, 204, 4);
      localObject2 = c.a((Paint)localObject2, paramVarArgs);
      WeChatSVGRenderC2Java.setFillType((Path)localObject1, 2);
      localCanvas.drawPath((Path)localObject1, (Paint)localObject2);
      localCanvas.restore();
      localCanvas.save();
      localPaint = c.a(localPaint, paramVarArgs);
      localPaint.setColor(-855638017);
      localObject1 = c.l(paramVarArgs);
      ((Path)localObject1).moveTo(90.0F, 174.0F);
      ((Path)localObject1).cubicTo(136.39192F, 174.0F, 174.0F, 136.39192F, 174.0F, 90.0F);
      ((Path)localObject1).cubicTo(174.0F, 43.608082F, 136.39192F, 6.0F, 90.0F, 6.0F);
      ((Path)localObject1).cubicTo(43.608082F, 6.0F, 6.0F, 43.608082F, 6.0F, 90.0F);
      ((Path)localObject1).cubicTo(6.0F, 136.39192F, 43.608082F, 174.0F, 90.0F, 174.0F);
      ((Path)localObject1).close();
      ((Path)localObject1).moveTo(90.0F, 180.0F);
      ((Path)localObject1).cubicTo(40.294373F, 180.0F, 0.0F, 139.70563F, 0.0F, 90.0F);
      ((Path)localObject1).cubicTo(0.0F, 40.294373F, 40.294373F, 0.0F, 90.0F, 0.0F);
      ((Path)localObject1).cubicTo(139.70563F, 0.0F, 180.0F, 40.294373F, 180.0F, 90.0F);
      ((Path)localObject1).cubicTo(180.0F, 139.70563F, 139.70563F, 180.0F, 90.0F, 180.0F);
      ((Path)localObject1).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject1, 2);
      localCanvas.drawPath((Path)localObject1, localPaint);
      localCanvas.restore();
      c.j(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.ahz
 * JD-Core Version:    0.7.0.1
 */