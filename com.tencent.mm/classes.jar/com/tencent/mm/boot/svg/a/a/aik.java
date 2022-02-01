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

public final class aik
  extends c
{
  private final int height = 32;
  private final int width = 32;
  
  public final int a(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 32;
      return 32;
      Canvas localCanvas = (Canvas)paramVarArgs[0];
      paramVarArgs = (Looper)paramVarArgs[1];
      Object localObject1 = c.j(paramVarArgs);
      float[] arrayOfFloat = c.i(paramVarArgs);
      Paint localPaint = c.m(paramVarArgs);
      localPaint.setFlags(385);
      localPaint.setStyle(Paint.Style.FILL);
      Object localObject2 = c.m(paramVarArgs);
      ((Paint)localObject2).setFlags(385);
      ((Paint)localObject2).setStyle(Paint.Style.STROKE);
      localPaint.setColor(-16777216);
      ((Paint)localObject2).setStrokeWidth(1.0F);
      ((Paint)localObject2).setStrokeCap(Paint.Cap.BUTT);
      ((Paint)localObject2).setStrokeJoin(Paint.Join.MITER);
      ((Paint)localObject2).setStrokeMiter(4.0F);
      ((Paint)localObject2).setPathEffect(null);
      localPaint = c.a((Paint)localObject2, paramVarArgs);
      localPaint.setStrokeWidth(1.0F);
      localObject2 = c.n(paramVarArgs);
      ((Path)localObject2).moveTo(0.0F, 0.0F);
      ((Path)localObject2).lineTo(32.0F, 0.0F);
      ((Path)localObject2).lineTo(32.0F, 32.0F);
      ((Path)localObject2).lineTo(0.0F, 32.0F);
      ((Path)localObject2).lineTo(0.0F, 0.0F);
      ((Path)localObject2).close();
      localCanvas.save();
      localPaint = c.a(localPaint, paramVarArgs);
      localPaint.setColor(-1);
      localPaint.setStrokeWidth(1.5F);
      arrayOfFloat = c.a(arrayOfFloat, 1.0F, 0.0F, 9.0F, 0.0F, 1.0F, 9.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject2 = c.a(localPaint, paramVarArgs);
      Path localPath = c.n(paramVarArgs);
      localPath.moveTo(0.0F, 5.0F);
      localPath.lineTo(0.0F, 1.0F);
      localPath.cubicTo(-6.763538E-017F, 0.4477153F, 0.4477153F, 1.014531E-016F, 1.0F, 0.0F);
      localPath.lineTo(5.0F, 0.0F);
      localPath.lineTo(5.0F, 0.0F);
      localCanvas.drawPath(localPath, (Paint)localObject2);
      localCanvas.restore();
      localCanvas.save();
      localObject2 = c.a(localPaint, paramVarArgs);
      arrayOfFloat = c.a(arrayOfFloat, 1.0F, 0.0F, 0.0F, 0.0F, -1.0F, 23.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject1);
      localPath = c.n(paramVarArgs);
      localPath.moveTo(0.0F, 14.0F);
      localPath.lineTo(0.0F, 10.0F);
      localPath.cubicTo(-6.763538E-017F, 9.447715F, 0.4477153F, 9.0F, 1.0F, 9.0F);
      localPath.lineTo(5.0F, 9.0F);
      localPath.lineTo(5.0F, 9.0F);
      localCanvas.drawPath(localPath, (Paint)localObject2);
      localCanvas.restore();
      localCanvas.save();
      localObject2 = c.a(localPaint, paramVarArgs);
      arrayOfFloat = c.a(arrayOfFloat, -1.83697E-016F, -1.0F, 14.0F, 1.0F, -1.83697E-016F, -9.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject1);
      localPath = c.n(paramVarArgs);
      localPath.moveTo(9.0F, 5.0F);
      localPath.lineTo(9.0F, 1.0F);
      localPath.cubicTo(9.0F, 0.4477153F, 9.447715F, -3.426362E-016F, 10.0F, -4.440892E-016F);
      localPath.lineTo(14.0F, -4.440892E-016F);
      localPath.lineTo(14.0F, -4.440892E-016F);
      localCanvas.drawPath(localPath, (Paint)localObject2);
      localCanvas.restore();
      localCanvas.save();
      localPaint = c.a(localPaint, paramVarArgs);
      arrayOfFloat = c.a(arrayOfFloat, -1.83697E-016F, -1.0F, 23.0F, -1.0F, 1.83697E-016F, 23.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject1);
      localObject1 = c.n(paramVarArgs);
      ((Path)localObject1).moveTo(9.0F, 14.0F);
      ((Path)localObject1).lineTo(9.0F, 10.0F);
      ((Path)localObject1).cubicTo(9.0F, 9.447715F, 9.447715F, 9.0F, 10.0F, 9.0F);
      ((Path)localObject1).lineTo(14.0F, 9.0F);
      ((Path)localObject1).lineTo(14.0F, 9.0F);
      localCanvas.drawPath((Path)localObject1, localPaint);
      localCanvas.restore();
      localCanvas.restore();
      c.l(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.aik
 * JD-Core Version:    0.7.0.1
 */