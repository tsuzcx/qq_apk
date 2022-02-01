package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;

public class icons_filled_at
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
      c.instanceMatrix(paramVarArgs);
      c.instanceMatrixArray(paramVarArgs);
      Paint localPaint = c.instancePaint(paramVarArgs);
      localPaint.setFlags(385);
      localPaint.setStyle(Paint.Style.FILL);
      Object localObject = c.instancePaint(paramVarArgs);
      ((Paint)localObject).setFlags(385);
      ((Paint)localObject).setStyle(Paint.Style.STROKE);
      localPaint.setColor(-16777216);
      ((Paint)localObject).setStrokeWidth(1.0F);
      ((Paint)localObject).setStrokeCap(Paint.Cap.BUTT);
      ((Paint)localObject).setStrokeJoin(Paint.Join.MITER);
      ((Paint)localObject).setStrokeMiter(4.0F);
      ((Paint)localObject).setPathEffect(null);
      c.instancePaint((Paint)localObject, paramVarArgs).setStrokeWidth(1.0F);
      localCanvas.save();
      localPaint = c.instancePaint(localPaint, paramVarArgs);
      localPaint.setColor(-16777216);
      localObject = c.instancePath(paramVarArgs);
      ((Path)localObject).moveTo(34.394531F, 27.433594F);
      ((Path)localObject).cubicTo(30.667969F, 27.433594F, 28.453125F, 30.492188F, 28.453125F, 35.625F);
      ((Path)localObject).cubicTo(28.453125F, 40.722656F, 30.667969F, 43.816406F, 34.359375F, 43.816406F);
      ((Path)localObject).cubicTo(38.15625F, 43.816406F, 40.511719F, 40.6875F, 40.511719F, 35.625F);
      ((Path)localObject).cubicTo(40.511719F, 30.5625F, 38.15625F, 27.433594F, 34.394531F, 27.433594F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(35.554688F, 6.058594F);
      ((Path)localObject).cubicTo(52.21875F, 6.058594F, 63.925781F, 16.535156F, 63.925781F, 32.179688F);
      ((Path)localObject).cubicTo(63.925781F, 43.253906F, 58.6875F, 50.390625F, 50.109375F, 50.390625F);
      ((Path)localObject).cubicTo(45.75F, 50.390625F, 42.410156F, 48.28125F, 41.636719F, 44.871094F);
      ((Path)localObject).lineTo(41.144531F, 44.871094F);
      ((Path)localObject).cubicTo(39.703125F, 48.386719F, 36.75F, 50.285156F, 32.671875F, 50.285156F);
      ((Path)localObject).cubicTo(25.359375F, 50.285156F, 20.472656F, 44.34375F, 20.472656F, 35.414063F);
      ((Path)localObject).cubicTo(20.472656F, 26.871094F, 25.289063F, 21.035156F, 32.320313F, 21.035156F);
      ((Path)localObject).cubicTo(36.117188F, 21.035156F, 39.28125F, 22.933594F, 40.652344F, 26.027344F);
      ((Path)localObject).lineTo(41.144531F, 26.027344F);
      ((Path)localObject).lineTo(41.144531F, 21.808594F);
      ((Path)localObject).lineTo(48.28125F, 21.808594F);
      ((Path)localObject).lineTo(48.28125F, 40.617188F);
      ((Path)localObject).cubicTo(48.28125F, 43.042969F, 49.40625F, 44.589844F, 51.621094F, 44.589844F);
      ((Path)localObject).cubicTo(55.066406F, 44.589844F, 57.457031F, 40.195313F, 57.457031F, 32.707031F);
      ((Path)localObject).cubicTo(57.457031F, 19.910156F, 48.632813F, 11.648438F, 35.308594F, 11.648438F);
      ((Path)localObject).cubicTo(21.773438F, 11.648438F, 12.28125F, 21.421875F, 12.28125F, 35.554688F);
      ((Path)localObject).cubicTo(12.28125F, 50.355469F, 22.160156F, 59.003906F, 36.644531F, 59.003906F);
      ((Path)localObject).cubicTo(40.40625F, 59.003906F, 44.238281F, 58.511719F, 46.242188F, 57.773438F);
      ((Path)localObject).lineTo(46.242188F, 63.398438F);
      ((Path)localObject).cubicTo(43.5F, 64.207031F, 39.914063F, 64.699219F, 36.117188F, 64.699219F);
      ((Path)localObject).cubicTo(18.328125F, 64.699219F, 5.8125F, 53.554688F, 5.8125F, 35.378906F);
      ((Path)localObject).cubicTo(5.8125F, 17.941406F, 18.011719F, 6.058594F, 35.554688F, 6.058594F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 2);
      localCanvas.drawPath((Path)localObject, localPaint);
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.icons_filled_at
 * JD-Core Version:    0.7.0.1
 */