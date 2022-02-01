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

public class icons_outlined_voice
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
      localPaint = c.instancePaint(localPaint, paramVarArgs);
      localPaint.setColor(-16777216);
      localCanvas.save();
      localPaint = c.instancePaint(localPaint, paramVarArgs);
      localObject = c.instancePath(paramVarArgs);
      ((Path)localObject).moveTo(36.0F, 66.0F);
      ((Path)localObject).cubicTo(19.431458F, 66.0F, 6.0F, 52.568542F, 6.0F, 36.0F);
      ((Path)localObject).cubicTo(6.0F, 19.431458F, 19.431458F, 6.0F, 36.0F, 6.0F);
      ((Path)localObject).cubicTo(52.568542F, 6.0F, 66.0F, 19.431458F, 66.0F, 36.0F);
      ((Path)localObject).cubicTo(66.0F, 52.568542F, 52.568542F, 66.0F, 36.0F, 66.0F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(36.0F, 62.400002F);
      ((Path)localObject).cubicTo(50.580318F, 62.400002F, 62.400002F, 50.580318F, 62.400002F, 36.0F);
      ((Path)localObject).cubicTo(62.400002F, 21.419683F, 50.580318F, 9.6F, 36.0F, 9.6F);
      ((Path)localObject).cubicTo(21.419683F, 9.6F, 9.6F, 21.419683F, 9.6F, 36.0F);
      ((Path)localObject).cubicTo(9.6F, 50.580318F, 21.419683F, 62.400002F, 36.0F, 62.400002F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(36.92498F, 50.42498F);
      ((Path)localObject).cubicTo(40.728367F, 46.62159F, 42.900002F, 41.48727F, 42.900002F, 36.0F);
      ((Path)localObject).cubicTo(42.900002F, 30.51273F, 40.728367F, 25.378408F, 36.92498F, 21.575022F);
      ((Path)localObject).lineTo(39.470562F, 19.029438F);
      ((Path)localObject).cubicTo(43.813709F, 23.372583F, 46.5F, 29.372583F, 46.5F, 36.0F);
      ((Path)localObject).cubicTo(46.5F, 42.627419F, 43.813709F, 48.627419F, 39.470562F, 52.970562F);
      ((Path)localObject).lineTo(36.92498F, 50.42498F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(30.985281F, 44.485283F);
      ((Path)localObject).cubicTo(33.22353F, 42.247032F, 34.5F, 39.229118F, 34.5F, 36.0F);
      ((Path)localObject).cubicTo(34.5F, 32.770882F, 33.22353F, 29.752968F, 30.985281F, 27.514719F);
      ((Path)localObject).lineTo(33.530865F, 24.969133F);
      ((Path)localObject).cubicTo(36.353912F, 27.792179F, 38.099998F, 31.692179F, 38.099998F, 36.0F);
      ((Path)localObject).cubicTo(38.099998F, 40.307819F, 36.353912F, 44.207821F, 33.530865F, 47.030865F);
      ((Path)localObject).lineTo(30.985281F, 44.485283F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(27.591169F, 41.091167F);
      ((Path)localObject).lineTo(22.5F, 36.0F);
      ((Path)localObject).lineTo(27.591169F, 30.908831F);
      ((Path)localObject).cubicTo(28.894112F, 32.211777F, 29.700001F, 34.011776F, 29.700001F, 36.0F);
      ((Path)localObject).cubicTo(29.700001F, 37.988224F, 28.894112F, 39.788223F, 27.591169F, 41.091167F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 1);
      localCanvas.drawPath((Path)localObject, localPaint);
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.icons_outlined_voice
 * JD-Core Version:    0.7.0.1
 */