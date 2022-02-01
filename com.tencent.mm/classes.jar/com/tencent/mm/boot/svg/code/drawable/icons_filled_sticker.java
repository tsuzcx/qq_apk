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

public class icons_filled_sticker
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
      localObject2 = c.setMatrixFloatArray((float[])localObject2, 1.0F, 0.0F, 6.0F, 0.0F, 1.0F, 6.0F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject2);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject1 = c.instancePaint(localPaint1, paramVarArgs);
      localObject2 = c.instancePath(paramVarArgs);
      ((Path)localObject2).moveTo(30.0F, 60.0F);
      ((Path)localObject2).cubicTo(13.431458F, 60.0F, 0.0F, 46.568542F, 0.0F, 30.0F);
      ((Path)localObject2).cubicTo(0.0F, 13.431458F, 13.431458F, 0.0F, 30.0F, 0.0F);
      ((Path)localObject2).cubicTo(46.568542F, 0.0F, 60.0F, 13.431458F, 60.0F, 30.0F);
      ((Path)localObject2).cubicTo(60.0F, 46.568542F, 46.568542F, 60.0F, 30.0F, 60.0F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(30.0F, 48.0F);
      ((Path)localObject2).cubicTo(38.607063F, 48.0F, 45.674892F, 41.409752F, 46.432735F, 33.0F);
      ((Path)localObject2).lineTo(13.567265F, 33.0F);
      ((Path)localObject2).cubicTo(14.325108F, 41.409752F, 21.392937F, 48.0F, 30.0F, 48.0F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(19.5F, 25.5F);
      ((Path)localObject2).cubicTo(21.985281F, 25.5F, 24.0F, 23.485281F, 24.0F, 21.0F);
      ((Path)localObject2).cubicTo(24.0F, 18.514719F, 21.985281F, 16.5F, 19.5F, 16.5F);
      ((Path)localObject2).cubicTo(17.014719F, 16.5F, 15.0F, 18.514719F, 15.0F, 21.0F);
      ((Path)localObject2).cubicTo(15.0F, 23.485281F, 17.014719F, 25.5F, 19.5F, 25.5F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(40.5F, 25.5F);
      ((Path)localObject2).cubicTo(42.985283F, 25.5F, 45.0F, 23.485281F, 45.0F, 21.0F);
      ((Path)localObject2).cubicTo(45.0F, 18.514719F, 42.985283F, 16.5F, 40.5F, 16.5F);
      ((Path)localObject2).cubicTo(38.014717F, 16.5F, 36.0F, 18.514719F, 36.0F, 21.0F);
      ((Path)localObject2).cubicTo(36.0F, 23.485281F, 38.014717F, 25.5F, 40.5F, 25.5F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 2);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.icons_filled_sticker
 * JD-Core Version:    0.7.0.1
 */