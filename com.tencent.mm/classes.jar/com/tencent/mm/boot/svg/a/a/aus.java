package com.tencent.mm.boot.svg.a.a;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.c;

public final class aus
  extends c
{
  private final int height = 40;
  private final int width = 40;
  
  public final int a(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 40;
      return 40;
      Canvas localCanvas = (Canvas)paramVarArgs[0];
      paramVarArgs = (Looper)paramVarArgs[1];
      Object localObject = c.j(paramVarArgs);
      float[] arrayOfFloat = c.i(paramVarArgs);
      Paint localPaint1 = c.m(paramVarArgs);
      localPaint1.setFlags(385);
      localPaint1.setStyle(Paint.Style.FILL);
      Paint localPaint2 = c.m(paramVarArgs);
      localPaint2.setFlags(385);
      localPaint2.setStyle(Paint.Style.STROKE);
      localPaint1.setColor(-16777216);
      localPaint2.setStrokeWidth(1.0F);
      localPaint2.setStrokeCap(Paint.Cap.BUTT);
      localPaint2.setStrokeJoin(Paint.Join.MITER);
      localPaint2.setStrokeMiter(4.0F);
      localPaint2.setPathEffect(null);
      localPaint2 = c.a(localPaint2, paramVarArgs);
      localPaint2.setStrokeWidth(1.0F);
      localCanvas.save();
      arrayOfFloat = c.a(arrayOfFloat, 1.0F, 0.0F, 5.0F, 0.0F, 1.0F, 5.0F);
      ((Matrix)localObject).reset();
      ((Matrix)localObject).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject);
      localCanvas.save();
      localPaint2 = c.a(localPaint2, paramVarArgs);
      localPaint2.setColor(-16777216);
      localPaint2.setStrokeWidth(1.875F);
      Path localPath = c.n(paramVarArgs);
      localPath.moveTo(15.0F, 0.0F);
      localPath.cubicTo(23.284271F, 0.0F, 30.0F, 6.715729F, 30.0F, 15.0F);
      localPath.cubicTo(30.0F, 23.284271F, 23.284271F, 30.0F, 15.0F, 30.0F);
      localPath.cubicTo(6.715729F, 30.0F, 0.0F, 23.284271F, 0.0F, 15.0F);
      localPath.cubicTo(0.0F, 6.715729F, 6.715729F, 0.0F, 15.0F, 0.0F);
      localPath.close();
      localCanvas.drawPath(localPath, localPaint2);
      localCanvas.restore();
      localCanvas.save();
      localPaint1 = c.a(localPaint1, paramVarArgs);
      localPaint1.setColor(-16777216);
      arrayOfFloat = c.a(arrayOfFloat, 0.7071068F, -0.7071068F, 14.779029F, 0.7071068F, 0.7071068F, -6.304732F);
      ((Matrix)localObject).reset();
      ((Matrix)localObject).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject);
      localObject = c.n(paramVarArgs);
      ((Path)localObject).moveTo(0.0F, 13.75F);
      ((Path)localObject).lineTo(30.0F, 13.75F);
      ((Path)localObject).lineTo(30.0F, 15.625F);
      ((Path)localObject).lineTo(0.0F, 15.625F);
      ((Path)localObject).lineTo(0.0F, 13.75F);
      ((Path)localObject).close();
      localCanvas.drawPath((Path)localObject, localPaint1);
      localCanvas.restore();
      localCanvas.restore();
      c.l(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.aus
 * JD-Core Version:    0.7.0.1
 */