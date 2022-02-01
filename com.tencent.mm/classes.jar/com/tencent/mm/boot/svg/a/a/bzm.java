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

public final class bzm
  extends c
{
  private final int height = 20;
  private final int width = 20;
  
  public final int a(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 20;
      return 20;
      Canvas localCanvas = (Canvas)paramVarArgs[0];
      paramVarArgs = (Looper)paramVarArgs[1];
      c.j(paramVarArgs);
      c.i(paramVarArgs);
      Paint localPaint1 = c.m(paramVarArgs);
      localPaint1.setFlags(385);
      localPaint1.setStyle(Paint.Style.FILL);
      Object localObject = c.m(paramVarArgs);
      ((Paint)localObject).setFlags(385);
      ((Paint)localObject).setStyle(Paint.Style.STROKE);
      localPaint1.setColor(-16777216);
      ((Paint)localObject).setStrokeWidth(1.0F);
      ((Paint)localObject).setStrokeCap(Paint.Cap.BUTT);
      ((Paint)localObject).setStrokeJoin(Paint.Join.MITER);
      ((Paint)localObject).setStrokeMiter(4.0F);
      ((Paint)localObject).setPathEffect(null);
      localObject = c.a((Paint)localObject, paramVarArgs);
      ((Paint)localObject).setStrokeWidth(1.0F);
      localCanvas.saveLayerAlpha(null, 204, 31);
      Paint localPaint2 = c.a(localPaint1, paramVarArgs);
      Paint localPaint3 = c.a((Paint)localObject, paramVarArgs);
      localPaint2.setColor(-2565928);
      localPaint3.setColor(-6842473);
      localPaint3.setStrokeWidth(1.6F);
      localObject = c.n(paramVarArgs);
      ((Path)localObject).moveTo(0.8F, 0.8F);
      ((Path)localObject).lineTo(19.199999F, 0.8F);
      ((Path)localObject).lineTo(19.199999F, 19.199999F);
      ((Path)localObject).lineTo(0.8F, 19.199999F);
      ((Path)localObject).lineTo(0.8F, 0.8F);
      ((Path)localObject).close();
      localCanvas.saveLayerAlpha(null, 0, 31);
      localPaint2 = c.a(localPaint2, paramVarArgs);
      localPaint3 = c.a(localPaint3, paramVarArgs);
      localCanvas.drawPath((Path)localObject, localPaint2);
      localCanvas.drawPath((Path)localObject, localPaint3);
      localCanvas.restore();
      localCanvas.save();
      localPaint1 = c.a(localPaint1, paramVarArgs);
      localPaint1.setColor(-10197008);
      localObject = c.n(paramVarArgs);
      ((Path)localObject).moveTo(12.384966F, 3.75F);
      ((Path)localObject).cubicTo(14.152719F, 3.75F, 14.80184F, 3.935651F, 15.453691F, 4.284266F);
      ((Path)localObject).cubicTo(16.105543F, 4.63288F, 16.617121F, 5.144457F, 16.965734F, 5.796309F);
      ((Path)localObject).cubicTo(17.314348F, 6.448161F, 17.5F, 7.09728F, 17.5F, 8.865034F);
      ((Path)localObject).lineTo(17.5F, 11.134966F);
      ((Path)localObject).cubicTo(17.5F, 12.902719F, 17.314348F, 13.55184F, 16.965734F, 14.203691F);
      ((Path)localObject).cubicTo(16.617121F, 14.855543F, 16.105543F, 15.367121F, 15.453691F, 15.715734F);
      ((Path)localObject).cubicTo(14.80184F, 16.064348F, 14.152719F, 16.25F, 12.384966F, 16.25F);
      ((Path)localObject).lineTo(7.615034F, 16.25F);
      ((Path)localObject).cubicTo(5.84728F, 16.25F, 5.198161F, 16.064348F, 4.546309F, 15.715734F);
      ((Path)localObject).cubicTo(3.894457F, 15.367121F, 3.38288F, 14.855543F, 3.034266F, 14.203691F);
      ((Path)localObject).cubicTo(2.685651F, 13.55184F, 2.5F, 12.902719F, 2.5F, 11.134966F);
      ((Path)localObject).lineTo(2.5F, 8.865034F);
      ((Path)localObject).cubicTo(2.5F, 7.09728F, 2.685651F, 6.448161F, 3.034266F, 5.796309F);
      ((Path)localObject).cubicTo(3.38288F, 5.144457F, 3.894457F, 4.63288F, 4.546309F, 4.284266F);
      ((Path)localObject).cubicTo(5.198161F, 3.935651F, 5.84728F, 3.75F, 7.615034F, 3.75F);
      ((Path)localObject).lineTo(12.384966F, 3.75F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(9.003333F, 6.6F);
      ((Path)localObject).cubicTo(8.727191F, 6.6F, 8.503333F, 6.823858F, 8.503333F, 7.1F);
      ((Path)localObject).lineTo(8.503333F, 7.1F);
      ((Path)localObject).lineTo(8.503333F, 12.9F);
      ((Path)localObject).cubicTo(8.503333F, 13.176143F, 8.727191F, 13.4F, 9.003333F, 13.4F);
      ((Path)localObject).cubicTo(9.279476F, 13.4F, 9.503333F, 13.176143F, 9.503333F, 12.9F);
      ((Path)localObject).lineTo(9.503333F, 12.9F);
      ((Path)localObject).lineTo(9.503333F, 7.1F);
      ((Path)localObject).cubicTo(9.503333F, 6.823858F, 9.279476F, 6.6F, 9.003333F, 6.6F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(13.003333F, 8.0F);
      ((Path)localObject).cubicTo(12.727191F, 8.0F, 12.503333F, 8.223858F, 12.503333F, 8.5F);
      ((Path)localObject).lineTo(12.503333F, 8.5F);
      ((Path)localObject).lineTo(12.503333F, 11.5F);
      ((Path)localObject).cubicTo(12.503333F, 11.776142F, 12.727191F, 12.0F, 13.003333F, 12.0F);
      ((Path)localObject).cubicTo(13.279476F, 12.0F, 13.503333F, 11.776142F, 13.503333F, 11.5F);
      ((Path)localObject).lineTo(13.503333F, 11.5F);
      ((Path)localObject).lineTo(13.503333F, 8.5F);
      ((Path)localObject).cubicTo(13.503333F, 8.223858F, 13.279476F, 8.0F, 13.003333F, 8.0F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(7.003333F, 8.0F);
      ((Path)localObject).cubicTo(6.727191F, 8.0F, 6.503333F, 8.223858F, 6.503333F, 8.5F);
      ((Path)localObject).lineTo(6.503333F, 8.5F);
      ((Path)localObject).lineTo(6.503333F, 11.5F);
      ((Path)localObject).cubicTo(6.503333F, 11.776142F, 6.727191F, 12.0F, 7.003333F, 12.0F);
      ((Path)localObject).cubicTo(7.279476F, 12.0F, 7.503333F, 11.776142F, 7.503333F, 11.5F);
      ((Path)localObject).lineTo(7.503333F, 11.5F);
      ((Path)localObject).lineTo(7.503333F, 8.5F);
      ((Path)localObject).cubicTo(7.503333F, 8.223858F, 7.279476F, 8.0F, 7.003333F, 8.0F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(11.003333F, 8.5F);
      ((Path)localObject).cubicTo(10.727191F, 8.5F, 10.503333F, 8.723858F, 10.503333F, 9.0F);
      ((Path)localObject).lineTo(10.503333F, 9.0F);
      ((Path)localObject).lineTo(10.503333F, 11.0F);
      ((Path)localObject).cubicTo(10.503333F, 11.276142F, 10.727191F, 11.5F, 11.003333F, 11.5F);
      ((Path)localObject).cubicTo(11.279476F, 11.5F, 11.503333F, 11.276142F, 11.503333F, 11.0F);
      ((Path)localObject).lineTo(11.503333F, 11.0F);
      ((Path)localObject).lineTo(11.503333F, 9.0F);
      ((Path)localObject).cubicTo(11.503333F, 8.723858F, 11.279476F, 8.5F, 11.003333F, 8.5F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 2);
      localCanvas.drawPath((Path)localObject, localPaint1);
      localCanvas.restore();
      localCanvas.restore();
      c.l(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.bzm
 * JD-Core Version:    0.7.0.1
 */