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

public final class avl
  extends c
{
  private final int height = 72;
  private final int width = 72;
  
  public final int a(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 72;
      return 72;
      Canvas localCanvas = (Canvas)paramVarArgs[0];
      paramVarArgs = (Looper)paramVarArgs[1];
      Object localObject1 = c.j(paramVarArgs);
      Object localObject2 = c.i(paramVarArgs);
      Paint localPaint1 = c.m(paramVarArgs);
      localPaint1.setFlags(385);
      localPaint1.setStyle(Paint.Style.FILL);
      Paint localPaint2 = c.m(paramVarArgs);
      localPaint2.setFlags(385);
      localPaint2.setStyle(Paint.Style.STROKE);
      localPaint1.setColor(-16777216);
      localPaint2.setStrokeWidth(1.0F);
      localPaint2.setStrokeCap(Paint.Cap.BUTT);
      localPaint2.setStrokeJoin(Paint.Join.MITER);
      localPaint2.setStrokeMiter(4.0F);
      localPaint2.setPathEffect(null);
      c.a(localPaint2, paramVarArgs).setStrokeWidth(1.0F);
      localCanvas.save();
      localPaint1 = c.a(localPaint1, paramVarArgs);
      localPaint1.setColor(-16777216);
      localObject2 = c.a((float[])localObject2, 1.0F, 0.0F, 5.0F, 0.0F, 1.0F, 5.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject2);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject1 = c.a(localPaint1, paramVarArgs);
      localObject2 = c.n(paramVarArgs);
      ((Path)localObject2).moveTo(59.5F, 42.154545F);
      ((Path)localObject2).cubicTo(60.494114F, 42.154545F, 61.299999F, 42.960434F, 61.299999F, 43.954544F);
      ((Path)localObject2).lineTo(61.299999F, 51.727272F);
      ((Path)localObject2).cubicTo(61.299999F, 57.014145F, 57.014145F, 61.299999F, 51.727272F, 61.299999F);
      ((Path)localObject2).lineTo(43.954544F, 61.299999F);
      ((Path)localObject2).cubicTo(42.960434F, 61.299999F, 42.154545F, 60.494114F, 42.154545F, 59.5F);
      ((Path)localObject2).cubicTo(42.154545F, 58.505886F, 42.960434F, 57.700001F, 43.954544F, 57.700001F);
      ((Path)localObject2).lineTo(51.727272F, 57.700001F);
      ((Path)localObject2).cubicTo(55.025917F, 57.700001F, 57.700001F, 55.025917F, 57.700001F, 51.727272F);
      ((Path)localObject2).lineTo(57.700001F, 43.954544F);
      ((Path)localObject2).cubicTo(57.700001F, 42.960434F, 58.505886F, 42.154545F, 59.5F, 42.154545F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(2.5F, 42.154545F);
      ((Path)localObject2).cubicTo(3.494113F, 42.154545F, 4.3F, 42.960434F, 4.3F, 43.954544F);
      ((Path)localObject2).lineTo(4.3F, 51.727272F);
      ((Path)localObject2).cubicTo(4.3F, 55.025917F, 6.974081F, 57.700001F, 10.272727F, 57.700001F);
      ((Path)localObject2).lineTo(18.045454F, 57.700001F);
      ((Path)localObject2).cubicTo(19.039568F, 57.700001F, 19.845455F, 58.505886F, 19.845455F, 59.5F);
      ((Path)localObject2).cubicTo(19.845455F, 60.494114F, 19.039568F, 61.299999F, 18.045454F, 61.299999F);
      ((Path)localObject2).lineTo(10.272727F, 61.299999F);
      ((Path)localObject2).cubicTo(4.985856F, 61.299999F, 0.7F, 57.014145F, 0.7F, 51.727272F);
      ((Path)localObject2).lineTo(0.7F, 43.954544F);
      ((Path)localObject2).cubicTo(0.7F, 42.960434F, 1.505888F, 42.154545F, 2.5F, 42.154545F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(41.331837F, 38.789127F);
      ((Path)localObject2).cubicTo(42.000584F, 39.524681F, 41.946426F, 40.66309F, 41.210873F, 41.331837F);
      ((Path)localObject2).cubicTo(38.668228F, 43.643543F, 35.235554F, 44.780224F, 31.0F, 44.780224F);
      ((Path)localObject2).cubicTo(26.764444F, 44.780224F, 23.33177F, 43.643543F, 20.789127F, 41.331837F);
      ((Path)localObject2).cubicTo(20.053576F, 40.66309F, 19.999416F, 39.524681F, 20.668163F, 38.789127F);
      ((Path)localObject2).cubicTo(21.33691F, 38.053574F, 22.475319F, 37.999416F, 23.210873F, 38.668163F);
      ((Path)localObject2).cubicTo(25.038824F, 40.33009F, 27.60615F, 41.180225F, 31.0F, 41.180225F);
      ((Path)localObject2).cubicTo(34.393848F, 41.180225F, 36.961178F, 40.33009F, 38.789127F, 38.668163F);
      ((Path)localObject2).cubicTo(39.524681F, 37.999416F, 40.66309F, 38.053574F, 41.331837F, 38.789127F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(31.0F, 23.200001F);
      ((Path)localObject2).cubicTo(31.994112F, 23.200001F, 32.799999F, 24.005888F, 32.799999F, 25.0F);
      ((Path)localObject2).lineTo(32.799999F, 34.0F);
      ((Path)localObject2).cubicTo(32.799999F, 34.994114F, 31.994112F, 35.799999F, 31.0F, 35.799999F);
      ((Path)localObject2).cubicTo(30.005888F, 35.799999F, 29.200001F, 34.994114F, 29.200001F, 34.0F);
      ((Path)localObject2).lineTo(29.200001F, 25.0F);
      ((Path)localObject2).cubicTo(29.200001F, 24.005888F, 30.005888F, 23.200001F, 31.0F, 23.200001F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(19.0F, 19.0F);
      ((Path)localObject2).cubicTo(20.656855F, 19.0F, 22.0F, 20.343145F, 22.0F, 22.0F);
      ((Path)localObject2).cubicTo(22.0F, 23.656855F, 20.656855F, 25.0F, 19.0F, 25.0F);
      ((Path)localObject2).cubicTo(17.343145F, 25.0F, 16.0F, 23.656855F, 16.0F, 22.0F);
      ((Path)localObject2).cubicTo(16.0F, 20.343145F, 17.343145F, 19.0F, 19.0F, 19.0F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(43.0F, 19.0F);
      ((Path)localObject2).cubicTo(44.656853F, 19.0F, 46.0F, 20.343145F, 46.0F, 22.0F);
      ((Path)localObject2).cubicTo(46.0F, 23.656855F, 44.656853F, 25.0F, 43.0F, 25.0F);
      ((Path)localObject2).cubicTo(41.343147F, 25.0F, 40.0F, 23.656855F, 40.0F, 22.0F);
      ((Path)localObject2).cubicTo(40.0F, 20.343145F, 41.343147F, 19.0F, 43.0F, 19.0F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(18.045454F, 0.7F);
      ((Path)localObject2).cubicTo(19.039568F, 0.7F, 19.845455F, 1.505888F, 19.845455F, 2.5F);
      ((Path)localObject2).cubicTo(19.845455F, 3.494113F, 19.039568F, 4.3F, 18.045454F, 4.3F);
      ((Path)localObject2).lineTo(10.272727F, 4.3F);
      ((Path)localObject2).cubicTo(6.974081F, 4.3F, 4.3F, 6.974081F, 4.3F, 10.272727F);
      ((Path)localObject2).lineTo(4.3F, 18.045454F);
      ((Path)localObject2).cubicTo(4.3F, 19.039568F, 3.494113F, 19.845455F, 2.5F, 19.845455F);
      ((Path)localObject2).cubicTo(1.505888F, 19.845455F, 0.7F, 19.039568F, 0.7F, 18.045454F);
      ((Path)localObject2).lineTo(0.7F, 10.272727F);
      ((Path)localObject2).cubicTo(0.7F, 4.985856F, 4.985856F, 0.7F, 10.272727F, 0.7F);
      ((Path)localObject2).lineTo(18.045454F, 0.7F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(51.727272F, 0.7F);
      ((Path)localObject2).cubicTo(57.014145F, 0.7F, 61.299999F, 4.985856F, 61.299999F, 10.272727F);
      ((Path)localObject2).lineTo(61.299999F, 18.045454F);
      ((Path)localObject2).cubicTo(61.299999F, 19.039568F, 60.494114F, 19.845455F, 59.5F, 19.845455F);
      ((Path)localObject2).cubicTo(58.505886F, 19.845455F, 57.700001F, 19.039568F, 57.700001F, 18.045454F);
      ((Path)localObject2).lineTo(57.700001F, 10.272727F);
      ((Path)localObject2).cubicTo(57.700001F, 6.974081F, 55.025917F, 4.3F, 51.727272F, 4.3F);
      ((Path)localObject2).lineTo(43.954544F, 4.3F);
      ((Path)localObject2).cubicTo(42.960434F, 4.3F, 42.154545F, 3.494113F, 42.154545F, 2.5F);
      ((Path)localObject2).cubicTo(42.154545F, 1.505888F, 42.960434F, 0.7F, 43.954544F, 0.7F);
      ((Path)localObject2).lineTo(51.727272F, 0.7F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 1);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.restore();
      c.l(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.avl
 * JD-Core Version:    0.7.0.1
 */