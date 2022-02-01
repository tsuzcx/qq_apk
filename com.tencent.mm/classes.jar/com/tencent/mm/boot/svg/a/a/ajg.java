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

public final class ajg
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
      localPaint.setColor(-16777216);
      localCanvas.save();
      localPaint = c.a(localPaint, paramVarArgs);
      localObject = c.n(paramVarArgs);
      ((Path)localObject).moveTo(4.131603F, 6.253572F);
      ((Path)localObject).lineTo(16.825377F, 18.946735F);
      ((Path)localObject).cubicTo(15.394642F, 19.61799F, 13.749804F, 20.0F, 12.0F, 20.0F);
      ((Path)localObject).cubicTo(10.871017F, 20.0F, 9.78573F, 19.840973F, 8.773454F, 19.547836F);
      ((Path)localObject).lineTo(8.773454F, 19.547836F);
      ((Path)localObject).lineTo(5.790501F, 20.978193F);
      ((Path)localObject).cubicTo(5.705353F, 21.019022F, 5.610383F, 21.034904F, 5.516583F, 21.024002F);
      ((Path)localObject).cubicTo(5.242288F, 20.992117F, 5.045775F, 20.74391F, 5.077659F, 20.469614F);
      ((Path)localObject).lineTo(5.077659F, 20.469614F);
      ((Path)localObject).lineTo(5.379757F, 17.870733F);
      ((Path)localObject).cubicTo(3.306998F, 16.313334F, 2.0F, 14.036405F, 2.0F, 11.5F);
      ((Path)localObject).cubicTo(2.0F, 9.520164F, 2.796337F, 7.698422F, 4.131603F, 6.253572F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(3.06066F, 3.06066F);
      ((Path)localObject).lineTo(4.12132F, 2.0F);
      ((Path)localObject).lineTo(6.513101F, 4.392634F);
      ((Path)localObject).cubicTo(8.088355F, 3.512222F, 9.973804F, 3.0F, 12.0F, 3.0F);
      ((Path)localObject).cubicTo(17.522848F, 3.0F, 22.0F, 6.80558F, 22.0F, 11.5F);
      ((Path)localObject).cubicTo(22.0F, 13.716352F, 21.002035F, 15.73458F, 19.367222F, 17.247734F);
      ((Path)localObject).lineTo(21.091883F, 18.970562F);
      ((Path)localObject).lineTo(20.031223F, 20.031223F);
      ((Path)localObject).lineTo(3.06066F, 3.06066F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 2);
      localCanvas.drawPath((Path)localObject, localPaint);
      localCanvas.restore();
      c.l(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.ajg
 * JD-Core Version:    0.7.0.1
 */