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

public final class api
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
      localCanvas.save();
      localPaint = c.a(localPaint, paramVarArgs);
      localPaint.setColor(-436207616);
      localObject = c.n(paramVarArgs);
      ((Path)localObject).moveTo(16.394873F, 2.744863F);
      ((Path)localObject).lineTo(17.818247F, 6.181233F);
      ((Path)localObject).lineTo(21.255136F, 7.605128F);
      ((Path)localObject).cubicTo(21.629316F, 7.760118F, 21.807005F, 8.189095F, 21.652014F, 8.563274F);
      ((Path)localObject).lineTo(20.228193F, 11.999358F);
      ((Path)localObject).lineTo(21.652014F, 15.436726F);
      ((Path)localObject).cubicTo(21.807005F, 15.810905F, 21.629316F, 16.239882F, 21.255136F, 16.394873F);
      ((Path)localObject).lineTo(17.818436F, 17.817028F);
      ((Path)localObject).lineTo(16.394873F, 21.255136F);
      ((Path)localObject).cubicTo(16.239882F, 21.629316F, 15.810905F, 21.807005F, 15.436726F, 21.652014F);
      ((Path)localObject).lineTo(11.999004F, 20.227514F);
      ((Path)localObject).lineTo(8.563274F, 21.652014F);
      ((Path)localObject).cubicTo(8.189095F, 21.807005F, 7.760118F, 21.629316F, 7.605128F, 21.255136F);
      ((Path)localObject).lineTo(6.181335F, 17.817757F);
      ((Path)localObject).lineTo(2.744863F, 16.394873F);
      ((Path)localObject).cubicTo(2.370684F, 16.239882F, 2.192996F, 15.810905F, 2.347986F, 15.436726F);
      ((Path)localObject).lineTo(3.771389F, 11.999633F);
      ((Path)localObject).lineTo(2.347986F, 8.563274F);
      ((Path)localObject).cubicTo(2.192996F, 8.189095F, 2.370684F, 7.760118F, 2.744863F, 7.605128F);
      ((Path)localObject).lineTo(6.181912F, 6.180115F);
      ((Path)localObject).lineTo(7.605128F, 2.744863F);
      ((Path)localObject).cubicTo(7.760118F, 2.370684F, 8.189095F, 2.192996F, 8.563274F, 2.347986F);
      ((Path)localObject).lineTo(11.99873F, 3.77071F);
      ((Path)localObject).lineTo(15.436726F, 2.347986F);
      ((Path)localObject).cubicTo(15.810905F, 2.192996F, 16.239882F, 2.370684F, 16.394873F, 2.744863F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(16.422754F, 8.54F);
      ((Path)localObject).lineTo(10.823438F, 14.139317F);
      ((Path)localObject).lineTo(8.057538F, 11.373417F);
      ((Path)localObject).lineTo(7.0F, 12.430955F);
      ((Path)localObject).lineTo(10.354426F, 15.787807F);
      ((Path)localObject).lineTo(10.354426F, 15.787807F);
      ((Path)localObject).lineTo(10.437046F, 15.858263F);
      ((Path)localObject).cubicTo(10.697526F, 16.045769F, 11.062864F, 16.022406F, 11.297163F, 15.788075F);
      ((Path)localObject).lineTo(11.297163F, 15.788075F);
      ((Path)localObject).lineTo(17.485281F, 9.602528F);
      ((Path)localObject).lineTo(16.422754F, 8.54F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 2);
      localCanvas.drawPath((Path)localObject, localPaint);
      localCanvas.restore();
      c.l(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.api
 * JD-Core Version:    0.7.0.1
 */