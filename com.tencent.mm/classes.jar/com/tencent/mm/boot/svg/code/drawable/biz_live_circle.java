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

public class biz_live_circle
  extends c
{
  private final int height = 64;
  private final int width = 64;
  
  public int doCommand(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 64;
      return 64;
      Canvas localCanvas = (Canvas)paramVarArgs[0];
      paramVarArgs = (Looper)paramVarArgs[1];
      Matrix localMatrix = c.instanceMatrix(paramVarArgs);
      float[] arrayOfFloat = c.instanceMatrixArray(paramVarArgs);
      Paint localPaint1 = c.instancePaint(paramVarArgs);
      localPaint1.setFlags(385);
      localPaint1.setStyle(Paint.Style.FILL);
      Object localObject = c.instancePaint(paramVarArgs);
      ((Paint)localObject).setFlags(385);
      ((Paint)localObject).setStyle(Paint.Style.STROKE);
      localPaint1.setColor(-16777216);
      ((Paint)localObject).setStrokeWidth(1.0F);
      ((Paint)localObject).setStrokeCap(Paint.Cap.BUTT);
      ((Paint)localObject).setStrokeJoin(Paint.Join.MITER);
      ((Paint)localObject).setStrokeMiter(4.0F);
      ((Paint)localObject).setPathEffect(null);
      c.instancePaint((Paint)localObject, paramVarArgs).setStrokeWidth(1.0F);
      localCanvas.save();
      localPaint1 = c.instancePaint(localPaint1, paramVarArgs);
      localObject = c.instancePath(paramVarArgs);
      ((Path)localObject).moveTo(32.0F, 3.6F);
      ((Path)localObject).cubicTo(16.315113F, 3.6F, 3.6F, 16.315113F, 3.6F, 32.0F);
      ((Path)localObject).cubicTo(3.6F, 47.684887F, 16.315113F, 60.400002F, 32.0F, 60.400002F);
      ((Path)localObject).cubicTo(47.684887F, 60.400002F, 60.400002F, 47.684887F, 60.400002F, 32.0F);
      ((Path)localObject).cubicTo(60.400002F, 16.315113F, 47.684887F, 3.6F, 32.0F, 3.6F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(32.0F, 5.0F);
      ((Path)localObject).cubicTo(46.91169F, 5.0F, 59.0F, 17.088312F, 59.0F, 32.0F);
      ((Path)localObject).cubicTo(59.0F, 46.91169F, 46.91169F, 59.0F, 32.0F, 59.0F);
      ((Path)localObject).cubicTo(17.088312F, 59.0F, 5.0F, 46.91169F, 5.0F, 32.0F);
      ((Path)localObject).cubicTo(5.0F, 17.088312F, 17.088312F, 5.0F, 32.0F, 5.0F);
      ((Path)localObject).close();
      Paint localPaint2 = c.instancePaint(paramVarArgs);
      localPaint2.setFlags(385);
      localPaint2.setStyle(Paint.Style.FILL);
      Paint localPaint3 = c.instancePaint(paramVarArgs);
      localPaint3.setFlags(385);
      localPaint3.setStyle(Paint.Style.STROKE);
      localPaint2.setColor(-16777216);
      localPaint3.setStrokeWidth(1.0F);
      localPaint3.setStrokeCap(Paint.Cap.BUTT);
      localPaint3.setStrokeJoin(Paint.Join.MITER);
      localPaint3.setStrokeMiter(4.0F);
      localPaint3.setPathEffect(null);
      arrayOfFloat = c.setMatrixFloatArray(arrayOfFloat, 60.400002F, 0.0F, 3.6F, 0.0F, 60.400002F, 3.6F, 0.0F, 0.0F, 1.0F);
      localMatrix.reset();
      localMatrix.setValues(arrayOfFloat);
      WeChatSVGRenderC2Java.setLinearGradient(localPaint1, 0.0F, 1.0F, 1.0F, 0.0F, new int[] { -29318, -19835 }, new float[] { 0.0F, 1.0F }, localMatrix, 0);
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 1);
      localCanvas.drawPath((Path)localObject, localPaint1);
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.biz_live_circle
 * JD-Core Version:    0.7.0.1
 */