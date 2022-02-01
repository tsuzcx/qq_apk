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

public class icons_outlined_coin_rm
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
      ((Path)localObject2).moveTo(19.202999F, 18.0F);
      ((Path)localObject2).cubicTo(23.345135F, 18.0F, 26.702999F, 21.357864F, 26.702999F, 25.5F);
      ((Path)localObject2).cubicTo(26.702999F, 28.71414F, 24.681171F, 31.456059F, 21.839949F, 32.523315F);
      ((Path)localObject2).lineTo(27.687F, 42.0F);
      ((Path)localObject2).lineTo(23.457001F, 42.0F);
      ((Path)localObject2).lineTo(17.903999F, 33.0F);
      ((Path)localObject2).lineTo(15.003F, 33.0F);
      ((Path)localObject2).lineTo(15.003F, 42.0F);
      ((Path)localObject2).lineTo(11.403F, 42.0F);
      ((Path)localObject2).lineTo(11.403F, 18.0F);
      ((Path)localObject2).lineTo(19.202999F, 18.0F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(33.380001F, 18.0F);
      ((Path)localObject2).lineTo(39.01078F, 31.430536F);
      ((Path)localObject2).lineTo(44.632999F, 18.0F);
      ((Path)localObject2).lineTo(48.306F, 18.0F);
      ((Path)localObject2).lineTo(48.306F, 42.0F);
      ((Path)localObject2).lineTo(44.706001F, 42.0F);
      ((Path)localObject2).lineTo(44.706001F, 26.774715F);
      ((Path)localObject2).lineTo(40.897999F, 36.0F);
      ((Path)localObject2).lineTo(37.124001F, 36.0F);
      ((Path)localObject2).lineTo(33.306F, 26.764219F);
      ((Path)localObject2).lineTo(33.306F, 42.0F);
      ((Path)localObject2).lineTo(29.705999F, 42.0F);
      ((Path)localObject2).lineTo(29.705999F, 18.0F);
      ((Path)localObject2).lineTo(33.380001F, 18.0F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(15.003F, 20.999001F);
      ((Path)localObject2).lineTo(15.003F, 29.999001F);
      ((Path)localObject2).lineTo(19.202999F, 30.0F);
      ((Path)localObject2).cubicTo(21.688282F, 30.0F, 23.702999F, 27.985281F, 23.702999F, 25.5F);
      ((Path)localObject2).cubicTo(23.702999F, 23.014719F, 21.688282F, 21.0F, 19.202999F, 21.0F);
      ((Path)localObject2).lineTo(15.003F, 20.999001F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 1);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.icons_outlined_coin_rm
 * JD-Core Version:    0.7.0.1
 */