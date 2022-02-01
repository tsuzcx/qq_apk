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

public final class le
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
      localPaint1.setColor(-16268960);
      localObject2 = c.a((float[])localObject2, 1.0F, 0.0F, -10.0F, 0.0F, 1.0F, -10.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject2);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject1 = c.a(localPaint1, paramVarArgs);
      localObject2 = c.n(paramVarArgs);
      ((Path)localObject2).moveTo(21.434671F, 15.5F);
      ((Path)localObject2).cubicTo(23.081448F, 17.163496F, 24.1F, 19.461592F, 24.1F, 22.0F);
      ((Path)localObject2).cubicTo(24.1F, 24.538408F, 23.081448F, 26.836504F, 21.434671F, 28.5F);
      ((Path)localObject2).lineTo(19.949747F, 27.0F);
      ((Path)localObject2).cubicTo(21.255392F, 25.681099F, 22.0F, 23.902777F, 22.0F, 22.0F);
      ((Path)localObject2).cubicTo(22.0F, 20.097223F, 21.255392F, 18.318901F, 19.949747F, 17.0F);
      ((Path)localObject2).lineTo(21.434671F, 15.5F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(17.969849F, 19.0F);
      ((Path)localObject2).cubicTo(18.729898F, 19.767767F, 19.200001F, 20.828426F, 19.200001F, 22.0F);
      ((Path)localObject2).cubicTo(19.200001F, 23.171574F, 18.729898F, 24.232233F, 17.969849F, 25.0F);
      ((Path)localObject2).lineTo(17.969849F, 25.0F);
      ((Path)localObject2).lineTo(15.0F, 22.0F);
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
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.le
 * JD-Core Version:    0.7.0.1
 */