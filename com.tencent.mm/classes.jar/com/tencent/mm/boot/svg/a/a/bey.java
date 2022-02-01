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

public final class bey
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
      Object localObject1 = c.j(paramVarArgs);
      Object localObject3 = c.i(paramVarArgs);
      Object localObject2 = c.m(paramVarArgs);
      ((Paint)localObject2).setFlags(385);
      ((Paint)localObject2).setStyle(Paint.Style.FILL);
      Object localObject4 = c.m(paramVarArgs);
      ((Paint)localObject4).setFlags(385);
      ((Paint)localObject4).setStyle(Paint.Style.STROKE);
      ((Paint)localObject2).setColor(-16777216);
      ((Paint)localObject4).setStrokeWidth(1.0F);
      ((Paint)localObject4).setStrokeCap(Paint.Cap.BUTT);
      ((Paint)localObject4).setStrokeJoin(Paint.Join.MITER);
      ((Paint)localObject4).setStrokeMiter(4.0F);
      ((Paint)localObject4).setPathEffect(null);
      localObject2 = c.a((Paint)localObject4, paramVarArgs);
      ((Paint)localObject2).setStrokeWidth(1.0F);
      localCanvas.save();
      localObject3 = c.a((float[])localObject3, 1.0F, 0.0F, -276.0F, 0.0F, 1.0F, -60.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject3);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject3 = c.a((float[])localObject3, 1.0F, 0.0F, 276.0F, 0.0F, 1.0F, 60.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject3);
      localCanvas.concat((Matrix)localObject1);
      localObject4 = c.n(paramVarArgs);
      ((Path)localObject4).moveTo(0.0F, 0.0F);
      ((Path)localObject4).lineTo(24.0F, 0.0F);
      ((Path)localObject4).lineTo(24.0F, 24.0F);
      ((Path)localObject4).lineTo(0.0F, 24.0F);
      ((Path)localObject4).lineTo(0.0F, 0.0F);
      ((Path)localObject4).close();
      localCanvas.save();
      localObject2 = c.a((Paint)localObject2, paramVarArgs);
      ((Paint)localObject2).setColor(-1);
      ((Paint)localObject2).setStrokeWidth(1.5F);
      localObject3 = c.a((float[])localObject3, 1.0F, 0.0F, 4.0F, 0.0F, 1.0F, 4.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject3);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.saveLayerAlpha(null, 230, 31);
      localCanvas.save();
      localObject1 = c.a((Paint)localObject2, paramVarArgs);
      localObject3 = c.n(paramVarArgs);
      ((Path)localObject3).moveTo(0.0F, 5.858134F);
      ((Path)localObject3).lineTo(-5.551115E-017F, 0.3761574F);
      ((Path)localObject3).cubicTo(-7.580177E-017F, 0.2104719F, 0.1343146F, 0.07615736F, 0.3F, 0.07615736F);
      ((Path)localObject3).lineTo(6.026039F, 0.07615736F);
      localCanvas.drawPath((Path)localObject3, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.save();
      localObject1 = c.a((Paint)localObject2, paramVarArgs);
      localObject3 = c.n(paramVarArgs);
      ((Path)localObject3).moveTo(0.0F, 10.096506F);
      ((Path)localObject3).lineTo(-5.551115E-017F, 15.578483F);
      ((Path)localObject3).cubicTo(4.798332E-016F, 15.744168F, 0.1343146F, 15.878483F, 0.3F, 15.878483F);
      ((Path)localObject3).lineTo(6.026039F, 15.878483F);
      localCanvas.drawPath((Path)localObject3, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.save();
      localObject1 = c.a((Paint)localObject2, paramVarArgs);
      localObject3 = c.n(paramVarArgs);
      ((Path)localObject3).moveTo(15.876585F, 9.997669F);
      ((Path)localObject3).lineTo(15.876585F, 15.67732F);
      ((Path)localObject3).cubicTo(15.876585F, 15.843005F, 15.74227F, 15.977321F, 15.576586F, 15.977321F);
      ((Path)localObject3).lineTo(9.850547F, 15.977321F);
      localCanvas.drawPath((Path)localObject3, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.save();
      localObject1 = c.a((Paint)localObject2, paramVarArgs);
      localObject2 = c.n(paramVarArgs);
      ((Path)localObject2).moveTo(15.876585F, 5.93445F);
      ((Path)localObject2).lineTo(15.876585F, 0.3F);
      ((Path)localObject2).cubicTo(15.876585F, 0.1343146F, 15.74227F, 6.912091E-016F, 15.576586F, 7.21645E-016F);
      ((Path)localObject2).lineTo(9.916438F, 0.0F);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.restore();
      localCanvas.restore();
      localCanvas.restore();
      localCanvas.restore();
      c.l(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.bey
 * JD-Core Version:    0.7.0.1
 */