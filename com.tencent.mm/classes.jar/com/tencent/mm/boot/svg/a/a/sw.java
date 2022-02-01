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

public final class sw
  extends c
{
  private final int height = 292;
  private final int width = 378;
  
  public final int a(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 378;
      return 292;
      Canvas localCanvas = (Canvas)paramVarArgs[0];
      paramVarArgs = (Looper)paramVarArgs[1];
      Object localObject1 = c.j(paramVarArgs);
      Object localObject3 = c.i(paramVarArgs);
      Object localObject2 = c.m(paramVarArgs);
      ((Paint)localObject2).setFlags(385);
      ((Paint)localObject2).setStyle(Paint.Style.FILL);
      Paint localPaint = c.m(paramVarArgs);
      localPaint.setFlags(385);
      localPaint.setStyle(Paint.Style.STROKE);
      ((Paint)localObject2).setColor(-16777216);
      localPaint.setStrokeWidth(1.0F);
      localPaint.setStrokeCap(Paint.Cap.BUTT);
      localPaint.setStrokeJoin(Paint.Join.MITER);
      localPaint.setStrokeMiter(4.0F);
      localPaint.setPathEffect(null);
      c.a(localPaint, paramVarArgs).setStrokeWidth(1.0F);
      localObject2 = c.a((Paint)localObject2, paramVarArgs);
      ((Paint)localObject2).setColor(-13158344);
      localCanvas.save();
      localObject3 = c.a((float[])localObject3, 1.0F, 0.0F, 2.0F, 0.0F, 1.0F, 3.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject3);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject1 = c.a((Paint)localObject2, paramVarArgs);
      localObject3 = c.n(paramVarArgs);
      ((Path)localObject3).moveTo(14.0F, 226.0F);
      ((Path)localObject3).lineTo(360.0F, 226.0F);
      ((Path)localObject3).lineTo(360.0F, 14.0F);
      ((Path)localObject3).lineTo(14.0F, 14.0F);
      ((Path)localObject3).lineTo(14.0F, 226.0F);
      ((Path)localObject3).close();
      ((Path)localObject3).moveTo(13.0F, 227.0F);
      ((Path)localObject3).lineTo(361.0F, 227.0F);
      ((Path)localObject3).lineTo(361.0F, 13.0F);
      ((Path)localObject3).lineTo(13.0F, 13.0F);
      ((Path)localObject3).lineTo(13.0F, 227.0F);
      ((Path)localObject3).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject3, 2);
      localCanvas.drawPath((Path)localObject3, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.save();
      localObject1 = c.a((Paint)localObject2, paramVarArgs);
      localObject2 = c.n(paramVarArgs);
      ((Path)localObject2).moveTo(371.00021F, 225.99319F);
      ((Path)localObject2).cubicTo(371.00021F, 232.06219F, 366.0632F, 237.0002F, 359.99319F, 237.0002F);
      ((Path)localObject2).lineTo(206.0002F, 237.0002F);
      ((Path)localObject2).lineTo(206.0002F, 237.0002F);
      ((Path)localObject2).lineTo(168.0002F, 237.0002F);
      ((Path)localObject2).lineTo(168.0002F, 237.0002F);
      ((Path)localObject2).lineTo(14.0062F, 237.0002F);
      ((Path)localObject2).cubicTo(7.9382F, 237.0002F, 3.0002F, 232.06219F, 3.0002F, 225.99319F);
      ((Path)localObject2).lineTo(3.0002F, 14.0072F);
      ((Path)localObject2).cubicTo(3.0002F, 7.9372F, 7.9382F, 3.0002F, 14.0062F, 3.0002F);
      ((Path)localObject2).lineTo(359.99319F, 3.0002F);
      ((Path)localObject2).cubicTo(366.0632F, 3.0002F, 371.00021F, 7.9372F, 371.00021F, 14.0072F);
      ((Path)localObject2).lineTo(371.00021F, 225.99319F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(256.00021F, 278.73019F);
      ((Path)localObject2).lineTo(256.00021F, 284.00021F);
      ((Path)localObject2).lineTo(118.0002F, 284.00021F);
      ((Path)localObject2).lineTo(118.0002F, 278.73019F);
      ((Path)localObject2).lineTo(171.0002F, 273.73019F);
      ((Path)localObject2).lineTo(171.0002F, 240.0002F);
      ((Path)localObject2).lineTo(203.0002F, 240.0002F);
      ((Path)localObject2).lineTo(203.0002F, 273.73019F);
      ((Path)localObject2).lineTo(256.00021F, 278.73019F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(359.99319F, 0.0002F);
      ((Path)localObject2).lineTo(14.0072F, 0.0002F);
      ((Path)localObject2).cubicTo(6.2762F, 0.0002F, 0.0002F, 6.2712F, 0.0002F, 14.0072F);
      ((Path)localObject2).lineTo(0.0002F, 225.99319F);
      ((Path)localObject2).cubicTo(0.0002F, 233.73421F, 6.2712F, 240.0002F, 14.0072F, 240.0002F);
      ((Path)localObject2).lineTo(168.0002F, 240.0002F);
      ((Path)localObject2).lineTo(168.0002F, 271.00021F);
      ((Path)localObject2).lineTo(115.0002F, 276.00021F);
      ((Path)localObject2).lineTo(115.0002F, 287.00021F);
      ((Path)localObject2).lineTo(259.00021F, 287.00021F);
      ((Path)localObject2).lineTo(259.00021F, 276.00021F);
      ((Path)localObject2).lineTo(206.0002F, 271.00021F);
      ((Path)localObject2).lineTo(206.0002F, 240.0002F);
      ((Path)localObject2).lineTo(359.99319F, 240.0002F);
      ((Path)localObject2).cubicTo(367.72421F, 240.0002F, 374.00021F, 233.7292F, 374.00021F, 225.99319F);
      ((Path)localObject2).lineTo(374.00021F, 14.0072F);
      ((Path)localObject2).cubicTo(374.00021F, 6.2652F, 367.72919F, 0.0002F, 359.99319F, 0.0002F);
      ((Path)localObject2).lineTo(359.99319F, 0.0002F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 2);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.restore();
      c.l(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.sw
 * JD-Core Version:    0.7.0.1
 */