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

public class icons_outlined_keyboard
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
      Object localObject3 = c.instanceMatrixArray(paramVarArgs);
      Object localObject2 = c.instancePaint(paramVarArgs);
      ((Paint)localObject2).setFlags(385);
      ((Paint)localObject2).setStyle(Paint.Style.FILL);
      Paint localPaint = c.instancePaint(paramVarArgs);
      localPaint.setFlags(385);
      localPaint.setStyle(Paint.Style.STROKE);
      ((Paint)localObject2).setColor(-16777216);
      localPaint.setStrokeWidth(1.0F);
      localPaint.setStrokeCap(Paint.Cap.BUTT);
      localPaint.setStrokeJoin(Paint.Join.MITER);
      localPaint.setStrokeMiter(4.0F);
      localPaint.setPathEffect(null);
      c.instancePaint(localPaint, paramVarArgs).setStrokeWidth(1.0F);
      localObject2 = c.instancePaint((Paint)localObject2, paramVarArgs);
      ((Paint)localObject2).setColor(-16777216);
      localCanvas.save();
      localObject3 = c.setMatrixFloatArray((float[])localObject3, 1.0F, 0.0F, 6.0F, 0.0F, 1.0F, 6.0F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject3);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject1 = c.instancePaint((Paint)localObject2, paramVarArgs);
      localObject3 = c.instancePath(paramVarArgs);
      ((Path)localObject3).moveTo(30.0F, 60.0F);
      ((Path)localObject3).cubicTo(13.431458F, 60.0F, 0.0F, 46.568542F, 0.0F, 30.0F);
      ((Path)localObject3).cubicTo(0.0F, 13.431458F, 13.431458F, 0.0F, 30.0F, 0.0F);
      ((Path)localObject3).cubicTo(46.568542F, 0.0F, 60.0F, 13.431458F, 60.0F, 30.0F);
      ((Path)localObject3).cubicTo(60.0F, 46.568542F, 46.568542F, 60.0F, 30.0F, 60.0F);
      ((Path)localObject3).close();
      ((Path)localObject3).moveTo(30.0F, 56.400002F);
      ((Path)localObject3).cubicTo(44.580318F, 56.400002F, 56.400002F, 44.580318F, 56.400002F, 30.0F);
      ((Path)localObject3).cubicTo(56.400002F, 15.419683F, 44.580318F, 3.6F, 30.0F, 3.6F);
      ((Path)localObject3).cubicTo(15.419683F, 3.6F, 3.6F, 15.419683F, 3.6F, 30.0F);
      ((Path)localObject3).cubicTo(3.6F, 44.580318F, 15.419683F, 56.400002F, 30.0F, 56.400002F);
      ((Path)localObject3).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject3, 1);
      localCanvas.drawPath((Path)localObject3, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.save();
      localObject1 = c.instancePaint((Paint)localObject2, paramVarArgs);
      localObject2 = c.instancePath(paramVarArgs);
      ((Path)localObject2).moveTo(13.5F, 18.0F);
      ((Path)localObject2).lineTo(19.5F, 18.0F);
      ((Path)localObject2).lineTo(19.5F, 24.0F);
      ((Path)localObject2).lineTo(13.5F, 24.0F);
      ((Path)localObject2).lineTo(13.5F, 18.0F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(22.5F, 18.0F);
      ((Path)localObject2).lineTo(28.5F, 18.0F);
      ((Path)localObject2).lineTo(28.5F, 24.0F);
      ((Path)localObject2).lineTo(22.5F, 24.0F);
      ((Path)localObject2).lineTo(22.5F, 18.0F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(31.5F, 18.0F);
      ((Path)localObject2).lineTo(37.5F, 18.0F);
      ((Path)localObject2).lineTo(37.5F, 24.0F);
      ((Path)localObject2).lineTo(31.5F, 24.0F);
      ((Path)localObject2).lineTo(31.5F, 18.0F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(40.5F, 18.0F);
      ((Path)localObject2).lineTo(46.5F, 18.0F);
      ((Path)localObject2).lineTo(46.5F, 24.0F);
      ((Path)localObject2).lineTo(40.5F, 24.0F);
      ((Path)localObject2).lineTo(40.5F, 18.0F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(13.5F, 27.0F);
      ((Path)localObject2).lineTo(19.5F, 27.0F);
      ((Path)localObject2).lineTo(19.5F, 33.0F);
      ((Path)localObject2).lineTo(13.5F, 33.0F);
      ((Path)localObject2).lineTo(13.5F, 27.0F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(22.5F, 27.0F);
      ((Path)localObject2).lineTo(28.5F, 27.0F);
      ((Path)localObject2).lineTo(28.5F, 33.0F);
      ((Path)localObject2).lineTo(22.5F, 33.0F);
      ((Path)localObject2).lineTo(22.5F, 27.0F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(21.0F, 39.0F);
      ((Path)localObject2).lineTo(39.0F, 39.0F);
      ((Path)localObject2).lineTo(39.0F, 45.0F);
      ((Path)localObject2).lineTo(21.0F, 45.0F);
      ((Path)localObject2).lineTo(21.0F, 39.0F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(31.5F, 27.0F);
      ((Path)localObject2).lineTo(37.5F, 27.0F);
      ((Path)localObject2).lineTo(37.5F, 33.0F);
      ((Path)localObject2).lineTo(31.5F, 33.0F);
      ((Path)localObject2).lineTo(31.5F, 27.0F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(40.5F, 27.0F);
      ((Path)localObject2).lineTo(46.5F, 27.0F);
      ((Path)localObject2).lineTo(46.5F, 33.0F);
      ((Path)localObject2).lineTo(40.5F, 33.0F);
      ((Path)localObject2).lineTo(40.5F, 27.0F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 2);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.icons_outlined_keyboard
 * JD-Core Version:    0.7.0.1
 */