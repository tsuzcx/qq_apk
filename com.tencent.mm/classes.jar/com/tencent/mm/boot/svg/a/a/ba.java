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

public final class ba
  extends c
{
  private final int height = 16;
  private final int width = 18;
  
  public final int a(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 18;
      return 16;
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
      localPaint.setColor(-2130706433);
      localCanvas.save();
      localPaint = c.a(localPaint, paramVarArgs);
      localObject = c.n(paramVarArgs);
      ((Path)localObject).moveTo(17.85F, 4.471246F);
      ((Path)localObject).cubicTo(17.85F, 2.083537F, 15.704336F, 0.15F, 13.04952F, 0.15F);
      ((Path)localObject).cubicTo(10.394706F, 0.15F, 8.249042F, 2.083537F, 8.249042F, 4.471246F);
      ((Path)localObject).lineTo(8.249042F, 11.659744F);
      ((Path)localObject).cubicTo(8.249042F, 13.249447F, 6.752295F, 14.526997F, 4.902556F, 14.526997F);
      ((Path)localObject).cubicTo(3.052817F, 14.526997F, 1.55607F, 13.249447F, 1.55607F, 11.659744F);
      ((Path)localObject).cubicTo(1.55607F, 10.387886F, 2.53934F, 9.275574F, 3.944819F, 8.936325F);
      ((Path)localObject).cubicTo(4.346369F, 8.835942F, 4.722205F, 8.538944F, 4.866149F, 8.203844F);
      ((Path)localObject).cubicTo(4.886022F, 8.164565F, 4.898383F, 8.128106F, 4.904602F, 8.090797F);
      ((Path)localObject).cubicTo(4.909616F, 8.060711F, 4.910896F, 8.036348F, 4.910703F, 7.969648F);
      ((Path)localObject).cubicTo(4.910703F, 7.657002F, 4.642792F, 7.434345F, 4.231629F, 7.434345F);
      ((Path)localObject).lineTo(4.062389F, 7.432655F);
      ((Path)localObject).cubicTo(1.808381F, 7.773889F, 0.15F, 9.567279F, 0.15F, 11.659744F);
      ((Path)localObject).cubicTo(0.15F, 14.047454F, 2.295664F, 15.98099F, 4.950479F, 15.98099F);
      ((Path)localObject).cubicTo(7.605294F, 15.98099F, 9.750958F, 14.047454F, 9.750958F, 11.659744F);
      ((Path)localObject).lineTo(9.750958F, 4.471246F);
      ((Path)localObject).cubicTo(9.750958F, 2.881544F, 11.247705F, 1.603994F, 13.097445F, 1.603994F);
      ((Path)localObject).cubicTo(14.947183F, 1.603994F, 16.44393F, 2.881544F, 16.44393F, 4.471246F);
      ((Path)localObject).cubicTo(16.44393F, 5.78153F, 15.470822F, 6.900888F, 14.051334F, 7.243497F);
      ((Path)localObject).cubicTo(13.637197F, 7.335504F, 13.289134F, 7.613512F, 13.137077F, 7.968276F);
      ((Path)localObject).cubicTo(12.947331F, 8.395177F, 13.224476F, 8.744569F, 13.766768F, 8.744577F);
      ((Path)localObject).lineTo(13.973336F, 8.74237F);
      ((Path)localObject).cubicTo(16.235973F, 8.343673F, 17.85F, 6.573353F, 17.85F, 4.471246F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 1);
      localCanvas.drawPath((Path)localObject, localPaint);
      localCanvas.restore();
      c.l(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.ba
 * JD-Core Version:    0.7.0.1
 */