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

public class icons_filled_caption
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
      Object localObject = c.instanceMatrix(paramVarArgs);
      float[] arrayOfFloat = c.instanceMatrixArray(paramVarArgs);
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
      localPaint1.setColor(-436207616);
      localCanvas.save();
      localPaint1 = c.instancePaint(localPaint1, paramVarArgs);
      arrayOfFloat = c.setMatrixFloatArray(arrayOfFloat, 1.0F, 0.0F, 0.0F, 0.0F, -1.0F, 72.174843F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject).reset();
      ((Matrix)localObject).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject);
      localObject = c.instancePath(paramVarArgs);
      ((Path)localObject).moveTo(62.768333F, 12.588635F);
      ((Path)localObject).cubicTo(64.158836F, 12.588635F, 65.286064F, 13.71586F, 65.286064F, 15.106362F);
      ((Path)localObject).lineTo(65.286064F, 57.068481F);
      ((Path)localObject).cubicTo(65.286064F, 58.458981F, 64.158836F, 59.586208F, 62.768333F, 59.586208F);
      ((Path)localObject).lineTo(9.056824F, 59.586208F);
      ((Path)localObject).cubicTo(7.666321F, 59.586208F, 6.539097F, 58.458981F, 6.539097F, 57.068481F);
      ((Path)localObject).lineTo(6.539097F, 15.106362F);
      ((Path)localObject).cubicTo(6.539097F, 13.71586F, 7.666321F, 12.588635F, 9.056824F, 12.588635F);
      ((Path)localObject).lineTo(62.768333F, 12.588635F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(43.990288F, 26.908209F);
      ((Path)localObject).lineTo(21.960175F, 26.908209F);
      ((Path)localObject).lineTo(21.960175F, 32.782906F);
      ((Path)localObject).lineTo(43.990288F, 32.782906F);
      ((Path)localObject).lineTo(43.990288F, 26.908209F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(16.827158F, 26.908209F);
      ((Path)localObject).lineTo(10.945119F, 26.908209F);
      ((Path)localObject).lineTo(10.945119F, 32.782906F);
      ((Path)localObject).lineTo(16.827158F, 32.782906F);
      ((Path)localObject).lineTo(16.827158F, 26.908209F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(61.614376F, 16.994658F);
      ((Path)localObject).lineTo(10.945119F, 16.994658F);
      ((Path)localObject).lineTo(10.945119F, 22.869354F);
      ((Path)localObject).lineTo(61.614376F, 22.869354F);
      ((Path)localObject).lineTo(61.614376F, 16.994658F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 2);
      localCanvas.drawPath((Path)localObject, localPaint1);
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.icons_filled_caption
 * JD-Core Version:    0.7.0.1
 */