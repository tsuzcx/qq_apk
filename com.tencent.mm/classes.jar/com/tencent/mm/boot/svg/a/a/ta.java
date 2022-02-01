package com.tencent.mm.boot.svg.a.a;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.c;

public final class ta
  extends c
{
  private final int height = 245;
  private final int width = 357;
  
  public final int a(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 357;
      return 245;
      Canvas localCanvas = (Canvas)paramVarArgs[0];
      paramVarArgs = (Looper)paramVarArgs[1];
      Object localObject1 = c.j(paramVarArgs);
      Object localObject3 = c.i(paramVarArgs);
      Paint localPaint = c.m(paramVarArgs);
      localPaint.setFlags(385);
      localPaint.setStyle(Paint.Style.FILL);
      Object localObject2 = c.m(paramVarArgs);
      ((Paint)localObject2).setFlags(385);
      ((Paint)localObject2).setStyle(Paint.Style.STROKE);
      localPaint.setColor(-16777216);
      ((Paint)localObject2).setStrokeWidth(1.0F);
      ((Paint)localObject2).setStrokeCap(Paint.Cap.BUTT);
      ((Paint)localObject2).setStrokeJoin(Paint.Join.MITER);
      ((Paint)localObject2).setStrokeMiter(4.0F);
      ((Paint)localObject2).setPathEffect(null);
      localObject2 = c.a((Paint)localObject2, paramVarArgs);
      ((Paint)localObject2).setStrokeWidth(1.0F);
      localCanvas.save();
      Object localObject4 = c.a(localPaint, paramVarArgs);
      ((Paint)localObject4).setColor(-16777216);
      Path localPath = c.n(paramVarArgs);
      localPath.moveTo(20.0F, 0.0F);
      localPath.lineTo(21.0F, 0.0F);
      localPath.lineTo(21.0F, 245.0F);
      localPath.lineTo(20.0F, 245.0F);
      localPath.lineTo(20.0F, 0.0F);
      localPath.close();
      localCanvas.drawPath(localPath, (Paint)localObject4);
      localCanvas.restore();
      localCanvas.save();
      localPaint = c.a(localPaint, paramVarArgs);
      localPaint.setColor(-16777216);
      localObject4 = c.n(paramVarArgs);
      ((Path)localObject4).moveTo(335.0F, 0.0F);
      ((Path)localObject4).lineTo(336.0F, 0.0F);
      ((Path)localObject4).lineTo(336.0F, 245.0F);
      ((Path)localObject4).lineTo(335.0F, 245.0F);
      ((Path)localObject4).lineTo(335.0F, 0.0F);
      ((Path)localObject4).close();
      localCanvas.drawPath((Path)localObject4, localPaint);
      localCanvas.restore();
      localCanvas.save();
      localPaint = c.a((Paint)localObject2, paramVarArgs);
      localPaint.setColor(-16777216);
      localPaint.setStrokeWidth(3.0F);
      localObject4 = c.n(paramVarArgs);
      ((Path)localObject4).moveTo(8.790844F, 1.5F);
      ((Path)localObject4).lineTo(1.506977F, 243.5F);
      ((Path)localObject4).lineTo(355.49301F, 243.5F);
      ((Path)localObject4).lineTo(348.20917F, 1.5F);
      ((Path)localObject4).lineTo(8.790844F, 1.5F);
      ((Path)localObject4).close();
      localCanvas.drawPath((Path)localObject4, localPaint);
      localCanvas.restore();
      localCanvas.save();
      localPaint = c.a((Paint)localObject2, paramVarArgs);
      localPaint.setColor(-16777216);
      localObject3 = c.a((float[])localObject3, 1.0F, 0.0F, 37.0F, 0.0F, 1.0F, 25.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject3);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localPaint = c.a(localPaint, paramVarArgs);
      localObject4 = c.n(paramVarArgs);
      ((Path)localObject4).moveTo(-0.5F, -0.5F);
      ((Path)localObject4).lineTo(285.5F, -0.5F);
      ((Path)localObject4).lineTo(285.5F, 192.5F);
      ((Path)localObject4).lineTo(-0.5F, 192.5F);
      ((Path)localObject4).lineTo(-0.5F, -0.5F);
      ((Path)localObject4).close();
      localCanvas.drawPath((Path)localObject4, localPaint);
      localCanvas.restore();
      localCanvas.restore();
      localCanvas.save();
      localObject2 = c.a((Paint)localObject2, paramVarArgs);
      ((Paint)localObject2).setColor(-16777216);
      ((Paint)localObject2).setStrokeWidth(2.0F);
      localObject3 = c.a((float[])localObject3, 1.0F, 0.0F, 134.0F, 0.0F, 1.0F, 97.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject3);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject1 = c.a((Paint)localObject2, paramVarArgs);
      localObject3 = c.n(paramVarArgs);
      ((Path)localObject3).moveTo(1.0F, 3.0F);
      ((Path)localObject3).cubicTo(1.0F, 1.89543F, 1.89543F, 1.0F, 3.0F, 1.0F);
      ((Path)localObject3).lineTo(66.0F, 1.0F);
      ((Path)localObject3).cubicTo(67.104568F, 1.0F, 68.0F, 1.89543F, 68.0F, 3.0F);
      ((Path)localObject3).lineTo(68.0F, 49.0F);
      ((Path)localObject3).cubicTo(68.0F, 50.104568F, 67.104568F, 51.0F, 66.0F, 51.0F);
      ((Path)localObject3).lineTo(3.0F, 51.0F);
      ((Path)localObject3).cubicTo(1.89543F, 51.0F, 1.0F, 50.104568F, 1.0F, 49.0F);
      ((Path)localObject3).lineTo(1.0F, 3.0F);
      ((Path)localObject3).close();
      localCanvas.drawPath((Path)localObject3, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.save();
      localObject1 = c.a((Paint)localObject2, paramVarArgs);
      localObject2 = c.n(paramVarArgs);
      ((Path)localObject2).moveTo(99.0F, 50.075089F);
      ((Path)localObject2).lineTo(99.0F, 2.010823F);
      ((Path)localObject2).lineTo(75.395767F, 19.873486F);
      ((Path)localObject2).cubicTo(75.210114F, 20.013983F, 75.0F, 20.437353F, 75.0F, 20.675142F);
      ((Path)localObject2).lineTo(75.0F, 32.730263F);
      ((Path)localObject2).cubicTo(75.0F, 32.953712F, 75.210114F, 33.357872F, 75.396019F, 33.488506F);
      ((Path)localObject2).lineTo(99.0F, 50.075089F);
      ((Path)localObject2).close();
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.restore();
      c.l(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.ta
 * JD-Core Version:    0.7.0.1
 */