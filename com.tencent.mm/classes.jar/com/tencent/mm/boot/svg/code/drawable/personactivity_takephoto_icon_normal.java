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

public class personactivity_takephoto_icon_normal
  extends c
{
  private final int height = 120;
  private final int width = 120;
  
  public int doCommand(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 120;
      return 120;
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
      localPaint1.setColor(-1);
      localCanvas.save();
      localObject2 = c.setMatrixFloatArray((float[])localObject2, 1.0F, 0.0F, 0.0F, 0.0F, 1.0F, 15.0F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject2);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject1 = c.instancePaint(localPaint1, paramVarArgs);
      localObject2 = c.instancePath(paramVarArgs);
      ((Path)localObject2).moveTo(8.001439F, 18.0F);
      ((Path)localObject2).cubicTo(3.582367F, 18.0F, 0.0F, 21.582798F, 0.0F, 25.997679F);
      ((Path)localObject2).lineTo(0.0F, 82.002319F);
      ((Path)localObject2).cubicTo(0.0F, 86.419319F, 3.591362F, 90.0F, 8.001439F, 90.0F);
      ((Path)localObject2).lineTo(111.99856F, 90.0F);
      ((Path)localObject2).cubicTo(116.41763F, 90.0F, 120.0F, 86.417198F, 120.0F, 82.002319F);
      ((Path)localObject2).lineTo(120.0F, 25.997679F);
      ((Path)localObject2).cubicTo(120.0F, 21.580683F, 116.40864F, 18.0F, 111.99856F, 18.0F);
      ((Path)localObject2).lineTo(8.001439F, 18.0F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(47.750492F, 0.0F);
      ((Path)localObject2).lineTo(60.0F, 0.0F);
      ((Path)localObject2).lineTo(60.0F, 18.0F);
      ((Path)localObject2).lineTo(23.340025F, 18.0F);
      ((Path)localObject2).cubicTo(33.061623F, 18.0F, 38.284004F, 0.0F, 47.750492F, 0.0F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(96.659973F, 18.0F);
      ((Path)localObject2).cubicTo(86.938377F, 18.0F, 81.715996F, 0.0F, 72.247398F, 0.0F);
      ((Path)localObject2).lineTo(60.0F, 0.0F);
      ((Path)localObject2).lineTo(60.0F, 18.0F);
      ((Path)localObject2).lineTo(96.659973F, 18.0F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(60.0F, 27.0F);
      ((Path)localObject2).cubicTo(74.912308F, 27.0F, 87.0F, 39.087692F, 87.0F, 54.0F);
      ((Path)localObject2).cubicTo(87.0F, 68.912308F, 74.912308F, 81.0F, 60.0F, 81.0F);
      ((Path)localObject2).cubicTo(45.087692F, 81.0F, 33.0F, 68.912308F, 33.0F, 54.0F);
      ((Path)localObject2).cubicTo(33.0F, 39.087692F, 45.087692F, 27.0F, 60.0F, 27.0F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(78.0F, 54.0F);
      ((Path)localObject2).cubicTo(78.0F, 63.941399F, 69.941399F, 72.0F, 60.0F, 72.0F);
      ((Path)localObject2).cubicTo(50.058601F, 72.0F, 42.0F, 63.941399F, 42.0F, 54.0F);
      ((Path)localObject2).cubicTo(42.0F, 44.058601F, 50.058601F, 36.0F, 60.0F, 36.0F);
      ((Path)localObject2).cubicTo(69.941399F, 36.0F, 78.0F, 44.058601F, 78.0F, 54.0F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(5.454546F, 6.431509F);
      ((Path)localObject2).lineTo(21.818182F, 6.431509F);
      ((Path)localObject2).lineTo(21.818182F, 12.407947F);
      ((Path)localObject2).lineTo(5.454546F, 12.407947F);
      ((Path)localObject2).lineTo(5.454546F, 6.431509F);
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
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.personactivity_takephoto_icon_normal
 * JD-Core Version:    0.7.0.1
 */