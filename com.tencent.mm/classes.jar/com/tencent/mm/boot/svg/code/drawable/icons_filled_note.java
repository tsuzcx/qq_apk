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

public class icons_filled_note
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
      localObject2 = c.setMatrixFloatArray((float[])localObject2, 1.0F, 0.0F, 12.0F, 0.0F, 1.0F, 6.0F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject2);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject1 = c.instancePaint(localPaint1, paramVarArgs);
      localObject2 = c.instancePath(paramVarArgs);
      ((Path)localObject2).moveTo(43.5F, 50.838852F);
      ((Path)localObject2).cubicTo(43.020569F, 50.96225F, 42.517948F, 51.027878F, 42.0F, 51.027878F);
      ((Path)localObject2).lineTo(4.5F, 51.027878F);
      ((Path)localObject2).lineTo(4.5F, 55.5F);
      ((Path)localObject2).lineTo(42.0F, 55.5F);
      ((Path)localObject2).cubicTo(42.828426F, 55.5F, 43.5F, 54.828426F, 43.5F, 54.0F);
      ((Path)localObject2).lineTo(43.5F, 50.838852F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(0.0F, 0.0F);
      ((Path)localObject2).lineTo(42.0F, 0.0F);
      ((Path)localObject2).cubicTo(45.313709F, -6.087184E-016F, 48.0F, 2.686292F, 48.0F, 6.0F);
      ((Path)localObject2).lineTo(48.0F, 54.0F);
      ((Path)localObject2).cubicTo(48.0F, 57.313709F, 45.313709F, 60.0F, 42.0F, 60.0F);
      ((Path)localObject2).lineTo(0.0F, 60.0F);
      ((Path)localObject2).lineTo(0.0F, 0.0F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(9.0F, 4.5F);
      ((Path)localObject2).lineTo(9.0F, 46.5F);
      ((Path)localObject2).lineTo(13.5F, 46.5F);
      ((Path)localObject2).lineTo(13.5F, 4.5F);
      ((Path)localObject2).lineTo(9.0F, 4.5F);
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
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.icons_filled_note
 * JD-Core Version:    0.7.0.1
 */