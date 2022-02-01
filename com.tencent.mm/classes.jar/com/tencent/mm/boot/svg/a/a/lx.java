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

public final class lx
  extends c
{
  private final int height = 96;
  private final int width = 96;
  
  public final int a(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 96;
      return 96;
      Canvas localCanvas = (Canvas)paramVarArgs[0];
      paramVarArgs = (Looper)paramVarArgs[1];
      Object localObject1 = c.j(paramVarArgs);
      float[] arrayOfFloat = c.i(paramVarArgs);
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
      localCanvas.save();
      arrayOfFloat = c.a(arrayOfFloat, 1.0F, 0.0F, 7.0F, 0.0F, 1.0F, 13.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject1 = c.a((Paint)localObject2, paramVarArgs);
      ((Paint)localObject1).setColor(-8617851);
      localObject2 = c.n(paramVarArgs);
      ((Path)localObject2).moveTo(40.500099F, 1.0E-004F);
      ((Path)localObject2).cubicTo(16.194099F, 1.0E-004F, 1.0E-004F, 14.5371F, 1.0E-004F, 32.4701F);
      ((Path)localObject2).cubicTo(1.0E-004F, 42.0741F, 4.6671F, 50.701099F, 12.7231F, 56.646099F);
      ((Path)localObject2).lineTo(8.1001F, 69.000099F);
      ((Path)localObject2).lineTo(23.6971F, 62.301102F);
      ((Path)localObject2).cubicTo(28.6931F, 63.997101F, 34.337101F, 64.941101F, 40.500099F, 64.941101F);
      ((Path)localObject2).cubicTo(64.740097F, 64.941101F, 81.000099F, 50.403099F, 81.000099F, 32.4701F);
      ((Path)localObject2).cubicTo(81.000099F, 14.5371F, 64.806099F, 1.0E-004F, 40.500099F, 1.0E-004F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(70.640099F, 39.745098F);
      ((Path)localObject2).lineTo(68.6931F, 45.421101F);
      ((Path)localObject2).cubicTo(66.319099F, 44.606098F, 61.024101F, 42.323101F, 56.2901F, 37.049099F);
      ((Path)localObject2).cubicTo(49.830101F, 45.303101F, 42.313099F, 46.000099F, 40.000099F, 46.000099F);
      ((Path)localObject2).cubicTo(37.687099F, 46.000099F, 30.170099F, 45.303101F, 23.7101F, 37.049099F);
      ((Path)localObject2).cubicTo(18.976101F, 42.323101F, 13.6811F, 44.606098F, 11.3071F, 45.421101F);
      ((Path)localObject2).lineTo(9.3601F, 39.745098F);
      ((Path)localObject2).cubicTo(11.3931F, 39.0471F, 16.1241F, 36.987099F, 20.1311F, 32.000099F);
      ((Path)localObject2).cubicTo(16.1241F, 27.0121F, 11.3931F, 24.9531F, 9.3601F, 24.2551F);
      ((Path)localObject2).lineTo(11.3071F, 18.5791F);
      ((Path)localObject2).cubicTo(13.6811F, 19.3941F, 18.976101F, 21.677099F, 23.7101F, 26.951099F);
      ((Path)localObject2).cubicTo(30.170099F, 18.6971F, 37.687099F, 18.000099F, 40.000099F, 18.000099F);
      ((Path)localObject2).cubicTo(42.313099F, 18.000099F, 49.830101F, 18.6971F, 56.2901F, 26.951099F);
      ((Path)localObject2).cubicTo(61.024101F, 21.677099F, 66.319099F, 19.3941F, 68.6931F, 18.5791F);
      ((Path)localObject2).lineTo(70.640099F, 24.2551F);
      ((Path)localObject2).cubicTo(68.607101F, 24.9531F, 63.875099F, 27.0121F, 59.868099F, 32.000099F);
      ((Path)localObject2).cubicTo(63.875099F, 36.987099F, 68.607101F, 39.0471F, 70.640099F, 39.745098F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(40.0F, 24.0F);
      ((Path)localObject2).cubicTo(38.298F, 24.0F, 32.505001F, 24.612F, 27.462999F, 32.0F);
      ((Path)localObject2).cubicTo(32.505001F, 39.388F, 38.298F, 40.0F, 40.0F, 40.0F);
      ((Path)localObject2).cubicTo(41.702F, 40.0F, 47.494999F, 39.388F, 52.536999F, 32.0F);
      ((Path)localObject2).cubicTo(47.494999F, 24.612F, 41.702F, 24.0F, 40.0F, 24.0F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 2);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.restore();
      c.l(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.lx
 * JD-Core Version:    0.7.0.1
 */