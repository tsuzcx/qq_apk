package com.tencent.mm.boot.svg.code.drawable;

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

public class icons_outlined_eyes_on
  extends c
{
  private final int height = 72;
  private final int width = 72;
  
  public int doCommand(int paramInt, Object... paramVarArgs)
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
      Object localObject1 = c.instanceMatrix(paramVarArgs);
      Object localObject2 = c.instanceMatrixArray(paramVarArgs);
      Paint localPaint1 = c.instancePaint(paramVarArgs);
      localPaint1.setFlags(385);
      localPaint1.setStyle(Paint.Style.FILL);
      Paint localPaint2 = c.instancePaint(paramVarArgs);
      localPaint2.setFlags(385);
      localPaint2.setStyle(Paint.Style.STROKE);
      localPaint1.setColor(-16777216);
      localPaint2.setStrokeWidth(1.0F);
      localPaint2.setStrokeCap(Paint.Cap.BUTT);
      localPaint2.setStrokeJoin(Paint.Join.MITER);
      localPaint2.setStrokeMiter(4.0F);
      localPaint2.setPathEffect(null);
      c.instancePaint(localPaint2, paramVarArgs).setStrokeWidth(1.0F);
      localPaint1 = c.instancePaint(localPaint1, paramVarArgs);
      localPaint1.setColor(-16777216);
      localCanvas.save();
      localObject2 = c.setMatrixFloatArray((float[])localObject2, 1.0F, 0.0F, 3.0F, 0.0F, 1.0F, 15.0F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject2);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject1 = c.instancePaint(localPaint1, paramVarArgs);
      localObject2 = c.instancePath(paramVarArgs);
      ((Path)localObject2).moveTo(33.0F, 38.400002F);
      ((Path)localObject2).cubicTo(45.102955F, 38.400002F, 56.058674F, 31.649624F, 61.943615F, 21.0F);
      ((Path)localObject2).cubicTo(56.058674F, 10.350376F, 45.102955F, 3.6F, 33.0F, 3.6F);
      ((Path)localObject2).cubicTo(20.897047F, 3.6F, 9.941325F, 10.350376F, 4.056384F, 21.0F);
      ((Path)localObject2).cubicTo(9.941325F, 31.649624F, 20.897047F, 38.400002F, 33.0F, 38.400002F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(33.0F, 0.0F);
      ((Path)localObject2).cubicTo(47.42337F, 0.0F, 59.916191F, 8.542883F, 66.0F, 21.0F);
      ((Path)localObject2).cubicTo(59.916191F, 33.457119F, 47.42337F, 42.0F, 33.0F, 42.0F);
      ((Path)localObject2).cubicTo(18.576628F, 42.0F, 6.083809F, 33.457119F, -1.096367E-011F, 21.0F);
      ((Path)localObject2).cubicTo(6.083809F, 8.542883F, 18.576628F, 0.0F, 33.0F, 0.0F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(33.0F, 29.4F);
      ((Path)localObject2).cubicTo(37.639191F, 29.4F, 41.400002F, 25.639193F, 41.400002F, 21.0F);
      ((Path)localObject2).cubicTo(41.400002F, 16.360807F, 37.639191F, 12.6F, 33.0F, 12.6F);
      ((Path)localObject2).cubicTo(28.360807F, 12.6F, 24.6F, 16.360807F, 24.6F, 21.0F);
      ((Path)localObject2).cubicTo(24.6F, 25.639193F, 28.360807F, 29.4F, 33.0F, 29.4F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(33.0F, 33.0F);
      ((Path)localObject2).cubicTo(26.372583F, 33.0F, 21.0F, 27.627417F, 21.0F, 21.0F);
      ((Path)localObject2).cubicTo(21.0F, 14.372583F, 26.372583F, 9.0F, 33.0F, 9.0F);
      ((Path)localObject2).cubicTo(39.627419F, 9.0F, 45.0F, 14.372583F, 45.0F, 21.0F);
      ((Path)localObject2).cubicTo(45.0F, 27.627417F, 39.627419F, 33.0F, 33.0F, 33.0F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 1);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.icons_outlined_eyes_on
 * JD-Core Version:    0.7.0.1
 */