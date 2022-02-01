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

public class float_ball_state_mike_on
  extends c
{
  private final int height = 60;
  private final int width = 60;
  
  public int doCommand(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 60;
      return 60;
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
      localPaint1.setColor(-16268960);
      localCanvas.save();
      localObject2 = c.setMatrixFloatArray((float[])localObject2, 1.0F, 0.0F, 5.0F, 0.0F, 1.0F, 5.0F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject2);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject1 = c.instancePaint(localPaint1, paramVarArgs);
      localObject2 = c.instancePath(paramVarArgs);
      ((Path)localObject2).moveTo(13.541667F, 20.833334F);
      ((Path)localObject2).lineTo(13.541667F, 25.0F);
      ((Path)localObject2).cubicTo(13.541667F, 31.328262F, 18.671738F, 36.458332F, 25.0F, 36.458332F);
      ((Path)localObject2).cubicTo(31.328262F, 36.458332F, 36.458332F, 31.328262F, 36.458332F, 25.0F);
      ((Path)localObject2).lineTo(36.458332F, 20.833334F);
      ((Path)localObject2).lineTo(39.583332F, 20.833334F);
      ((Path)localObject2).lineTo(39.583332F, 25.0F);
      ((Path)localObject2).cubicTo(39.583332F, 32.52634F, 33.881866F, 38.721027F, 26.562386F, 39.500622F);
      ((Path)localObject2).lineTo(26.5625F, 45.833332F);
      ((Path)localObject2).lineTo(23.4375F, 45.833332F);
      ((Path)localObject2).lineTo(23.436659F, 39.500519F);
      ((Path)localObject2).cubicTo(16.117636F, 38.72049F, 10.416667F, 32.526012F, 10.416667F, 25.0F);
      ((Path)localObject2).lineTo(10.416667F, 20.833334F);
      ((Path)localObject2).lineTo(13.541667F, 20.833334F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(25.0F, 4.166667F);
      ((Path)localObject2).cubicTo(29.602373F, 4.166667F, 33.333332F, 7.897627F, 33.333332F, 12.5F);
      ((Path)localObject2).lineTo(33.333332F, 12.5F);
      ((Path)localObject2).lineTo(33.333332F, 25.0F);
      ((Path)localObject2).cubicTo(33.333332F, 29.602373F, 29.602373F, 33.333332F, 25.0F, 33.333332F);
      ((Path)localObject2).cubicTo(20.397627F, 33.333332F, 16.666666F, 29.602373F, 16.666666F, 25.0F);
      ((Path)localObject2).lineTo(16.666666F, 25.0F);
      ((Path)localObject2).lineTo(16.666666F, 12.5F);
      ((Path)localObject2).cubicTo(16.666666F, 7.897627F, 20.397627F, 4.166667F, 25.0F, 4.166667F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 2);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.float_ball_state_mike_on
 * JD-Core Version:    0.7.0.1
 */