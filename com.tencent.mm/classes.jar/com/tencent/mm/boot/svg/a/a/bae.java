package com.tencent.mm.boot.svg.a.a;

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

public final class bae
  extends c
{
  private final int height = 216;
  private final int width = 16;
  
  public final int a(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 16;
      return 216;
      Canvas localCanvas = (Canvas)paramVarArgs[0];
      paramVarArgs = (Looper)paramVarArgs[1];
      Matrix localMatrix = c.j(paramVarArgs);
      Object localObject1 = c.i(paramVarArgs);
      Paint localPaint1 = c.m(paramVarArgs);
      localPaint1.setFlags(385);
      localPaint1.setStyle(Paint.Style.FILL);
      Object localObject2 = c.m(paramVarArgs);
      ((Paint)localObject2).setFlags(385);
      ((Paint)localObject2).setStyle(Paint.Style.STROKE);
      localPaint1.setColor(-16777216);
      ((Paint)localObject2).setStrokeWidth(1.0F);
      ((Paint)localObject2).setStrokeCap(Paint.Cap.BUTT);
      ((Paint)localObject2).setStrokeJoin(Paint.Join.MITER);
      ((Paint)localObject2).setStrokeMiter(4.0F);
      ((Paint)localObject2).setPathEffect(null);
      c.a((Paint)localObject2, paramVarArgs).setStrokeWidth(1.0F);
      localCanvas.save();
      localObject1 = c.a((float[])localObject1, 1.0F, 0.0F, -362.0F, 0.0F, 1.0F, -115.0F);
      localMatrix.reset();
      localMatrix.setValues((float[])localObject1);
      localCanvas.concat(localMatrix);
      localCanvas.save();
      localObject1 = c.a((float[])localObject1, 1.0F, 0.0F, 362.0F, 0.0F, -1.0F, 331.0F);
      localMatrix.reset();
      localMatrix.setValues((float[])localObject1);
      localCanvas.concat(localMatrix);
      localCanvas.save();
      localPaint1 = c.a(localPaint1, paramVarArgs);
      localObject2 = c.a((float[])localObject1, 1.0F, 0.0F, 0.0F, 0.0F, -1.0F, 216.0F);
      localMatrix.reset();
      localMatrix.setValues((float[])localObject2);
      localCanvas.concat(localMatrix);
      localObject1 = c.n(paramVarArgs);
      ((Path)localObject1).moveTo(0.0F, 0.0F);
      ((Path)localObject1).lineTo(16.0F, 0.0F);
      ((Path)localObject1).lineTo(16.0F, 216.0F);
      ((Path)localObject1).lineTo(0.0F, 216.0F);
      ((Path)localObject1).lineTo(0.0F, 0.0F);
      ((Path)localObject1).close();
      Paint localPaint2 = c.m(paramVarArgs);
      localPaint2.setFlags(385);
      localPaint2.setStyle(Paint.Style.FILL);
      Paint localPaint3 = c.m(paramVarArgs);
      localPaint3.setFlags(385);
      localPaint3.setStyle(Paint.Style.STROKE);
      localPaint2.setColor(-16777216);
      localPaint3.setStrokeWidth(1.0F);
      localPaint3.setStrokeCap(Paint.Cap.BUTT);
      localPaint3.setStrokeJoin(Paint.Join.MITER);
      localPaint3.setStrokeMiter(4.0F);
      localPaint3.setPathEffect(null);
      localObject2 = c.a((float[])localObject2, 16.0F, 0.0F, 0.0F, 0.0F, 216.0F, 0.0F);
      localMatrix.reset();
      localMatrix.setValues((float[])localObject2);
      WeChatSVGRenderC2Java.setLinearGradient(localPaint1, 0.5F, 0.0F, 0.5F, 1.0F, new int[] { 0, 587202560, -2147483648 }, new float[] { 0.0F, 0.1823065F, 1.0F }, localMatrix, 0);
      localCanvas.drawPath((Path)localObject1, localPaint1);
      localCanvas.restore();
      localCanvas.restore();
      localCanvas.restore();
      c.l(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.bae
 * JD-Core Version:    0.7.0.1
 */