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

public final class bbl
  extends c
{
  private final int height = 48;
  private final int width = 48;
  
  public final int a(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 48;
      return 48;
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
      localObject2 = c.a((float[])localObject2, 1.0F, 0.0F, -257.0F, 0.0F, 1.0F, -307.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject2);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject2 = c.a((float[])localObject2, 1.0F, 0.0F, 257.0F, 0.0F, 1.0F, 307.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject2);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject1 = c.a(localPaint1, paramVarArgs);
      ((Paint)localObject1).setColor(-3232652);
      localObject2 = c.n(paramVarArgs);
      ((Path)localObject2).moveTo(0.0F, 5.333334F);
      ((Path)localObject2).cubicTo(0.0F, 2.387815F, 2.387815F, 0.0F, 5.333334F, 0.0F);
      ((Path)localObject2).lineTo(42.666668F, 0.0F);
      ((Path)localObject2).cubicTo(45.612186F, 0.0F, 48.0F, 2.387815F, 48.0F, 5.333334F);
      ((Path)localObject2).lineTo(48.0F, 42.666668F);
      ((Path)localObject2).cubicTo(48.0F, 45.612186F, 45.612186F, 48.0F, 42.666668F, 48.0F);
      ((Path)localObject2).lineTo(5.333334F, 48.0F);
      ((Path)localObject2).cubicTo(2.387815F, 48.0F, 0.0F, 45.612186F, 0.0F, 42.666668F);
      ((Path)localObject2).lineTo(0.0F, 5.333334F);
      ((Path)localObject2).close();
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.save();
      localPaint1 = c.a(localPaint1, paramVarArgs);
      localPaint1.setColor(-1);
      localObject1 = c.n(paramVarArgs);
      ((Path)localObject1).moveTo(14.822541F, 37.755669F);
      ((Path)localObject1).lineTo(14.822541F, 36.495667F);
      ((Path)localObject1).lineTo(33.272541F, 36.495667F);
      ((Path)localObject1).lineTo(33.272541F, 37.755669F);
      ((Path)localObject1).lineTo(36.032543F, 37.755669F);
      ((Path)localObject1).lineTo(36.032543F, 16.875668F);
      ((Path)localObject1).lineTo(24.692541F, 16.875668F);
      ((Path)localObject1).cubicTo(25.082542F, 15.855667F, 25.382542F, 14.805667F, 25.622541F, 13.725667F);
      ((Path)localObject1).lineTo(37.442543F, 13.725667F);
      ((Path)localObject1).lineTo(37.442543F, 10.995667F);
      ((Path)localObject1).lineTo(10.562542F, 10.995667F);
      ((Path)localObject1).lineTo(10.562542F, 13.725667F);
      ((Path)localObject1).lineTo(22.712542F, 13.725667F);
      ((Path)localObject1).cubicTo(22.502542F, 14.805667F, 22.202541F, 15.855667F, 21.812542F, 16.875668F);
      ((Path)localObject1).lineTo(12.062542F, 16.875668F);
      ((Path)localObject1).lineTo(12.062542F, 37.755669F);
      ((Path)localObject1).lineTo(14.822541F, 37.755669F);
      ((Path)localObject1).close();
      ((Path)localObject1).moveTo(18.242542F, 33.855667F);
      ((Path)localObject1).lineTo(14.822541F, 33.855667F);
      ((Path)localObject1).lineTo(14.822541F, 19.485668F);
      ((Path)localObject1).lineTo(18.242542F, 19.485668F);
      ((Path)localObject1).lineTo(18.242542F, 33.855667F);
      ((Path)localObject1).close();
      ((Path)localObject1).moveTo(33.272541F, 33.855667F);
      ((Path)localObject1).lineTo(29.762541F, 33.855667F);
      ((Path)localObject1).lineTo(29.762541F, 19.485668F);
      ((Path)localObject1).lineTo(33.272541F, 19.485668F);
      ((Path)localObject1).lineTo(33.272541F, 33.855667F);
      ((Path)localObject1).close();
      ((Path)localObject1).moveTo(27.092541F, 22.605667F);
      ((Path)localObject1).lineTo(20.912542F, 22.605667F);
      ((Path)localObject1).lineTo(20.912542F, 19.485668F);
      ((Path)localObject1).lineTo(27.092541F, 19.485668F);
      ((Path)localObject1).lineTo(27.092541F, 22.605667F);
      ((Path)localObject1).close();
      ((Path)localObject1).moveTo(27.092541F, 28.185667F);
      ((Path)localObject1).lineTo(20.912542F, 28.185667F);
      ((Path)localObject1).lineTo(20.912542F, 25.065668F);
      ((Path)localObject1).lineTo(27.092541F, 25.065668F);
      ((Path)localObject1).lineTo(27.092541F, 28.185667F);
      ((Path)localObject1).close();
      ((Path)localObject1).moveTo(27.092541F, 33.855667F);
      ((Path)localObject1).lineTo(20.912542F, 33.855667F);
      ((Path)localObject1).lineTo(20.912542F, 30.615667F);
      ((Path)localObject1).lineTo(27.092541F, 30.615667F);
      ((Path)localObject1).lineTo(27.092541F, 33.855667F);
      ((Path)localObject1).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject1, 1);
      localCanvas.drawPath((Path)localObject1, localPaint1);
      localCanvas.restore();
      localCanvas.restore();
      localCanvas.restore();
      c.l(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.bbl
 * JD-Core Version:    0.7.0.1
 */