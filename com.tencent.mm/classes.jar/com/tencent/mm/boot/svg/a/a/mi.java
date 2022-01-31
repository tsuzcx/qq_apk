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

public final class mi
  extends c
{
  private final int height = 96;
  private final int width = 96;
  
  protected final int b(int paramInt, Object... paramVarArgs)
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
      Object localObject1 = c.f(paramVarArgs);
      Object localObject2 = c.e(paramVarArgs);
      Paint localPaint1 = c.i(paramVarArgs);
      localPaint1.setFlags(385);
      localPaint1.setStyle(Paint.Style.FILL);
      Paint localPaint2 = c.i(paramVarArgs);
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
      localPaint1.setColor(-2500135);
      localObject2 = c.a((float[])localObject2, 1.0F, 0.0F, 21.0F, 0.0F, 1.0F, 21.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject2);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject1 = c.a(localPaint1, paramVarArgs);
      localObject2 = c.j(paramVarArgs);
      ((Path)localObject2).moveTo(1.750827F, 9.118188F);
      ((Path)localObject2).cubicTo(3.893294F, 5.123594F, 7.759701F, 2.384159F, 11.516493F, 0.04318783F);
      ((Path)localObject2).cubicTo(13.110888F, -0.2855443F, 13.8184F, 1.338193F, 14.665422F, 2.344313F);
      ((Path)localObject2).cubicTo(16.967329F, 5.711328F, 19.49843F, 8.928918F, 21.720619F, 12.355701F);
      ((Path)localObject2).cubicTo(22.487921F, 13.341898F, 21.899988F, 14.786327F, 20.813807F, 15.254521F);
      ((Path)localObject2).cubicTo(18.372391F, 16.977875F, 15.622059F, 18.173265F, 12.911589F, 19.398539F);
      ((Path)localObject2).cubicTo(14.197069F, 23.562481F, 16.658415F, 27.228342F, 19.588116F, 30.416048F);
      ((Path)localObject2).cubicTo(23.753471F, 34.95853F, 28.586479F, 39.242008F, 34.595356F, 41.0849F);
      ((Path)localObject2).cubicTo(36.080135F, 38.026695F, 37.355652F, 34.759296F, 39.617699F, 32.169285F);
      ((Path)localObject2).cubicTo(41.381496F, 31.37236F, 42.716801F, 33.145519F, 44.101933F, 33.922523F);
      ((Path)localObject2).cubicTo(47.290722F, 36.402958F, 50.828285F, 38.43512F, 53.837704F, 41.134708F);
      ((Path)localObject2).cubicTo(54.455532F, 42.59906F, 53.160088F, 43.744644F, 52.452572F, 44.880264F);
      ((Path)localObject2).cubicTo(50.150665F, 47.908585F, 47.709251F, 51.235752F, 44.012249F, 52.610451F);
      ((Path)localObject2).cubicTo(41.411392F, 53.61657F, 38.66106F, 52.461025F, 36.209679F, 51.544559F);
      ((Path)localObject2).cubicTo(20.993176F, 45.03965F, 8.477179F, 32.448212F, 2.17932F, 17.127298F);
      ((Path)localObject2).cubicTo(1.192788F, 14.616981F, 0.3258364F, 11.658391F, 1.750827F, 9.118188F);
      ((Path)localObject2).lineTo(1.750827F, 9.118188F);
      ((Path)localObject2).lineTo(1.750827F, 9.118188F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 2);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.restore();
      c.h(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.mi
 * JD-Core Version:    0.7.0.1
 */