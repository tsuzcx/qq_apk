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

public final class bsn
  extends c
{
  private final int height = 216;
  private final int width = 1080;
  
  public final int a(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 1080;
      return 216;
      Canvas localCanvas = (Canvas)paramVarArgs[0];
      paramVarArgs = (Looper)paramVarArgs[1];
      Matrix localMatrix = c.j(paramVarArgs);
      float[] arrayOfFloat = c.i(paramVarArgs);
      Paint localPaint1 = c.m(paramVarArgs);
      localPaint1.setFlags(385);
      localPaint1.setStyle(Paint.Style.FILL);
      Object localObject = c.m(paramVarArgs);
      ((Paint)localObject).setFlags(385);
      ((Paint)localObject).setStyle(Paint.Style.STROKE);
      localPaint1.setColor(-16777216);
      ((Paint)localObject).setStrokeWidth(1.0F);
      ((Paint)localObject).setStrokeCap(Paint.Cap.BUTT);
      ((Paint)localObject).setStrokeJoin(Paint.Join.MITER);
      ((Paint)localObject).setStrokeMiter(4.0F);
      ((Paint)localObject).setPathEffect(null);
      c.a((Paint)localObject, paramVarArgs).setStrokeWidth(1.0F);
      localCanvas.save();
      localPaint1 = c.a(localPaint1, paramVarArgs);
      localObject = c.n(paramVarArgs);
      ((Path)localObject).moveTo(0.0F, 0.0F);
      ((Path)localObject).lineTo(1080.0F, 0.0F);
      ((Path)localObject).lineTo(1080.0F, 216.0F);
      ((Path)localObject).lineTo(0.0F, 216.0F);
      ((Path)localObject).lineTo(0.0F, 0.0F);
      ((Path)localObject).close();
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
      arrayOfFloat = c.a(arrayOfFloat, 1080.0F, 0.0F, 0.0F, 0.0F, 216.0F, 0.0F);
      localMatrix.reset();
      localMatrix.setValues(arrayOfFloat);
      WeChatSVGRenderC2Java.setLinearGradient(localPaint1, 0.5F, 0.0727838F, 0.5F, 1.0F, new int[] { 855638016, 0 }, new float[] { 0.0F, 1.0F }, localMatrix, 0);
      localCanvas.drawPath((Path)localObject, localPaint1);
      localCanvas.restore();
      c.l(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.bsn
 * JD-Core Version:    0.7.0.1
 */