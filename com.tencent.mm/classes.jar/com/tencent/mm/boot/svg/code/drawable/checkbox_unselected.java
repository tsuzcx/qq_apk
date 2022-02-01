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

public class checkbox_unselected
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
      Paint localPaint = c.instancePaint(paramVarArgs);
      localPaint.setFlags(385);
      localPaint.setStyle(Paint.Style.FILL);
      Object localObject3 = c.instancePaint(paramVarArgs);
      ((Paint)localObject3).setFlags(385);
      ((Paint)localObject3).setStyle(Paint.Style.STROKE);
      localPaint.setColor(-16777216);
      ((Paint)localObject3).setStrokeWidth(1.0F);
      ((Paint)localObject3).setStrokeCap(Paint.Cap.BUTT);
      ((Paint)localObject3).setStrokeJoin(Paint.Join.MITER);
      ((Paint)localObject3).setStrokeMiter(4.0F);
      ((Paint)localObject3).setPathEffect(null);
      c.instancePaint((Paint)localObject3, paramVarArgs).setStrokeWidth(1.0F);
      localObject3 = c.instancePath(paramVarArgs);
      ((Path)localObject3).moveTo(0.0F, 0.0F);
      ((Path)localObject3).lineTo(60.0F, 0.0F);
      ((Path)localObject3).lineTo(60.0F, 60.0F);
      ((Path)localObject3).lineTo(0.0F, 60.0F);
      ((Path)localObject3).lineTo(0.0F, 0.0F);
      ((Path)localObject3).close();
      localPaint = c.instancePaint(localPaint, paramVarArgs);
      localPaint.setColor(-5592406);
      localCanvas.save();
      localObject2 = c.setMatrixFloatArray((float[])localObject2, 1.0F, 0.0F, 6.0F, 0.0F, 1.0F, 6.0F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject2);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject1 = c.instancePaint(localPaint, paramVarArgs);
      localObject2 = c.instancePath(paramVarArgs);
      ((Path)localObject2).moveTo(0.0F, 6.0F);
      ((Path)localObject2).cubicTo(0.0F, 2.689151F, 2.683541F, 0.0F, 6.0F, 0.0F);
      ((Path)localObject2).lineTo(42.0F, 0.0F);
      ((Path)localObject2).cubicTo(45.310848F, 0.0F, 48.0F, 2.683541F, 48.0F, 6.0F);
      ((Path)localObject2).lineTo(48.0F, 42.0F);
      ((Path)localObject2).cubicTo(48.0F, 45.310848F, 45.31646F, 48.0F, 42.0F, 48.0F);
      ((Path)localObject2).lineTo(6.0F, 48.0F);
      ((Path)localObject2).cubicTo(2.689151F, 48.0F, 0.0F, 45.31646F, 0.0F, 42.0F);
      ((Path)localObject2).lineTo(0.0F, 6.0F);
      ((Path)localObject2).lineTo(0.0F, 6.0F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(3.0F, 5.0F);
      ((Path)localObject2).cubicTo(3.0F, 3.938929F, 3.936117F, 3.0F, 5.0F, 3.0F);
      ((Path)localObject2).lineTo(43.0F, 3.0F);
      ((Path)localObject2).cubicTo(44.061069F, 3.0F, 45.0F, 3.936117F, 45.0F, 5.0F);
      ((Path)localObject2).lineTo(45.0F, 43.0F);
      ((Path)localObject2).cubicTo(45.0F, 44.061069F, 44.063885F, 45.0F, 43.0F, 45.0F);
      ((Path)localObject2).lineTo(5.0F, 45.0F);
      ((Path)localObject2).cubicTo(3.938929F, 45.0F, 3.0F, 44.063885F, 3.0F, 43.0F);
      ((Path)localObject2).lineTo(3.0F, 5.0F);
      ((Path)localObject2).lineTo(3.0F, 5.0F);
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
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.checkbox_unselected
 * JD-Core Version:    0.7.0.1
 */