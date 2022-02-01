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

public class icons_outlined_lock
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
      localObject2 = c.setMatrixFloatArray((float[])localObject2, 1.0F, 0.0F, 12.0F, 0.0F, 1.0F, 6.0F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject2);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject1 = c.instancePaint(localPaint1, paramVarArgs);
      localObject2 = c.instancePath(paramVarArgs);
      ((Path)localObject2).moveTo(12.0F, 21.0F);
      ((Path)localObject2).lineTo(12.0F, 12.0F);
      ((Path)localObject2).cubicTo(12.0F, 5.372583F, 17.372583F, 0.0F, 24.0F, 0.0F);
      ((Path)localObject2).cubicTo(30.627417F, 0.0F, 36.0F, 5.372583F, 36.0F, 12.0F);
      ((Path)localObject2).lineTo(36.0F, 21.0F);
      ((Path)localObject2).lineTo(44.997383F, 21.0F);
      ((Path)localObject2).cubicTo(46.655682F, 21.0F, 48.0F, 22.342468F, 48.0F, 23.995506F);
      ((Path)localObject2).lineTo(48.0F, 57.004494F);
      ((Path)localObject2).cubicTo(48.0F, 58.658867F, 46.666107F, 60.0F, 44.997383F, 60.0F);
      ((Path)localObject2).lineTo(3.002615F, 60.0F);
      ((Path)localObject2).cubicTo(1.344317F, 60.0F, 0.0F, 58.657532F, 0.0F, 57.004494F);
      ((Path)localObject2).lineTo(0.0F, 23.995506F);
      ((Path)localObject2).cubicTo(0.0F, 22.341135F, 1.333893F, 21.0F, 3.002615F, 21.0F);
      ((Path)localObject2).lineTo(12.0F, 21.0F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(15.6F, 21.0F);
      ((Path)localObject2).lineTo(32.399998F, 21.0F);
      ((Path)localObject2).lineTo(32.399998F, 12.0F);
      ((Path)localObject2).cubicTo(32.39999F, 7.360799F, 28.639183F, 3.599991F, 23.99999F, 3.599991F);
      ((Path)localObject2).cubicTo(19.3608F, 3.599991F, 15.599991F, 7.360799F, 15.599991F, 11.99999F);
      ((Path)localObject2).lineTo(15.6F, 21.0F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(3.6F, 24.6F);
      ((Path)localObject2).lineTo(3.6F, 56.400002F);
      ((Path)localObject2).lineTo(44.400002F, 56.400002F);
      ((Path)localObject2).lineTo(44.400002F, 24.6F);
      ((Path)localObject2).lineTo(3.6F, 24.6F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(22.199999F, 41.625561F);
      ((Path)localObject2).cubicTo(20.610685F, 40.93116F, 19.5F, 39.345287F, 19.5F, 37.5F);
      ((Path)localObject2).cubicTo(19.5F, 35.014717F, 21.514719F, 33.0F, 24.0F, 33.0F);
      ((Path)localObject2).cubicTo(26.485281F, 33.0F, 28.5F, 35.014717F, 28.5F, 37.5F);
      ((Path)localObject2).cubicTo(28.5F, 39.345287F, 27.389315F, 40.93116F, 25.799999F, 41.625561F);
      ((Path)localObject2).lineTo(25.799999F, 48.0F);
      ((Path)localObject2).lineTo(22.199999F, 48.0F);
      ((Path)localObject2).lineTo(22.199999F, 41.625561F);
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
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.icons_outlined_lock
 * JD-Core Version:    0.7.0.1
 */