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

public final class acg
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
      c.f(paramVarArgs);
      c.e(paramVarArgs);
      Paint localPaint = c.i(paramVarArgs);
      localPaint.setFlags(385);
      localPaint.setStyle(Paint.Style.FILL);
      Object localObject = c.i(paramVarArgs);
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
      localPaint.setColor(-16896);
      localCanvas.save();
      localPaint = c.a(localPaint, paramVarArgs);
      localObject = c.j(paramVarArgs);
      ((Path)localObject).moveTo(21.448311F, 69.122643F);
      ((Path)localObject).lineTo(46.491844F, 26.187445F);
      ((Path)localObject).cubicTo(47.320778F, 24.766298F, 48.675976F, 24.758957F, 49.509193F, 26.187445F);
      ((Path)localObject).lineTo(74.552727F, 69.122643F);
      ((Path)localObject).cubicTo(75.38166F, 70.543793F, 74.719376F, 71.709152F, 73.063896F, 71.709152F);
      ((Path)localObject).lineTo(22.937145F, 71.709152F);
      ((Path)localObject).cubicTo(21.285309F, 71.709152F, 20.615093F, 70.551132F, 21.448311F, 69.122643F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(46.700405F, 41.400345F);
      ((Path)localObject).cubicTo(46.150082F, 41.400345F, 45.72443F, 41.842537F, 45.750111F, 42.39727F);
      ((Path)localObject).lineTo(46.46933F, 57.932423F);
      ((Path)localObject).lineTo(49.530827F, 57.932423F);
      ((Path)localObject).lineTo(50.250046F, 42.39727F);
      ((Path)localObject).cubicTo(50.275536F, 41.846684F, 49.839088F, 41.400345F, 49.299751F, 41.400345F);
      ((Path)localObject).lineTo(46.700405F, 41.400345F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(48.000076F, 65.280014F);
      ((Path)localObject).cubicTo(49.268192F, 65.280014F, 50.2962F, 64.251999F, 50.2962F, 62.983891F);
      ((Path)localObject).cubicTo(50.2962F, 61.715775F, 49.268192F, 60.687767F, 48.000076F, 60.687767F);
      ((Path)localObject).cubicTo(46.731964F, 60.687767F, 45.703957F, 61.715775F, 45.703957F, 62.983891F);
      ((Path)localObject).cubicTo(45.703957F, 64.251999F, 46.731964F, 65.280014F, 48.000076F, 65.280014F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 2);
      localCanvas.drawPath((Path)localObject, localPaint);
      localCanvas.restore();
      c.h(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.acg
 * JD-Core Version:    0.7.0.1
 */