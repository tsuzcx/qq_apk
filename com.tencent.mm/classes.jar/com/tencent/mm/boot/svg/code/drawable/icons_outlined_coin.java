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

public class icons_outlined_coin
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
      localCanvas.save();
      localPaint1 = c.instancePaint(localPaint1, paramVarArgs);
      localPaint1.setColor(-16777216);
      localObject2 = c.setMatrixFloatArray((float[])localObject2, 1.0F, 0.0F, 6.0F, 0.0F, 1.0F, 6.0F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject2);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject1 = c.instancePaint(localPaint1, paramVarArgs);
      localObject2 = c.instancePath(paramVarArgs);
      ((Path)localObject2).moveTo(30.0F, 0.0F);
      ((Path)localObject2).cubicTo(46.568542F, 0.0F, 60.0F, 13.431458F, 60.0F, 30.0F);
      ((Path)localObject2).cubicTo(60.0F, 46.568542F, 46.568542F, 60.0F, 30.0F, 60.0F);
      ((Path)localObject2).cubicTo(13.431458F, 60.0F, 0.0F, 46.568542F, 0.0F, 30.0F);
      ((Path)localObject2).cubicTo(0.0F, 13.431458F, 13.431458F, 0.0F, 30.0F, 0.0F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(30.0F, 3.6F);
      ((Path)localObject2).cubicTo(15.419683F, 3.6F, 3.6F, 15.419683F, 3.6F, 30.0F);
      ((Path)localObject2).cubicTo(3.6F, 44.580318F, 15.419683F, 56.400002F, 30.0F, 56.400002F);
      ((Path)localObject2).cubicTo(44.580318F, 56.400002F, 56.400002F, 44.580318F, 56.400002F, 30.0F);
      ((Path)localObject2).cubicTo(56.400002F, 15.419683F, 44.580318F, 3.6F, 30.0F, 3.6F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(24.0F, 18.0F);
      ((Path)localObject2).lineTo(28.799F, 27.6F);
      ((Path)localObject2).lineTo(31.200001F, 27.6F);
      ((Path)localObject2).lineTo(36.0F, 18.0F);
      ((Path)localObject2).lineTo(40.5F, 18.0F);
      ((Path)localObject2).lineTo(35.700001F, 27.6F);
      ((Path)localObject2).lineTo(40.5F, 27.600037F);
      ((Path)localObject2).lineTo(40.5F, 31.200037F);
      ((Path)localObject2).lineTo(31.799999F, 31.200001F);
      ((Path)localObject2).lineTo(31.799999F, 34.5F);
      ((Path)localObject2).lineTo(40.5F, 34.5F);
      ((Path)localObject2).lineTo(40.5F, 38.099998F);
      ((Path)localObject2).lineTo(31.799999F, 38.099998F);
      ((Path)localObject2).lineTo(31.800074F, 43.5F);
      ((Path)localObject2).lineTo(28.200073F, 43.5F);
      ((Path)localObject2).lineTo(28.200001F, 38.099998F);
      ((Path)localObject2).lineTo(19.5F, 38.099998F);
      ((Path)localObject2).lineTo(19.5F, 34.5F);
      ((Path)localObject2).lineTo(28.200001F, 34.5F);
      ((Path)localObject2).lineTo(28.200001F, 31.200001F);
      ((Path)localObject2).lineTo(19.5F, 31.200037F);
      ((Path)localObject2).lineTo(19.5F, 27.600037F);
      ((Path)localObject2).lineTo(24.299F, 27.6F);
      ((Path)localObject2).lineTo(19.5F, 18.0F);
      ((Path)localObject2).lineTo(24.0F, 18.0F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 1);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.icons_outlined_coin
 * JD-Core Version:    0.7.0.1
 */