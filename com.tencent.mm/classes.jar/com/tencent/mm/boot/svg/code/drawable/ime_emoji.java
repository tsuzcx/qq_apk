package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.c;

public class ime_emoji
  extends c
{
  private final int height = 40;
  private final int width = 40;
  
  public int doCommand(int paramInt, Object... paramVarArgs)
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
      Object localObject2 = c.instanceMatrix(paramVarArgs);
      Object localObject3 = c.instanceMatrixArray(paramVarArgs);
      Object localObject1 = c.instancePaint(paramVarArgs);
      ((Paint)localObject1).setFlags(385);
      ((Paint)localObject1).setStyle(Paint.Style.FILL);
      Paint localPaint = c.instancePaint(paramVarArgs);
      localPaint.setFlags(385);
      localPaint.setStyle(Paint.Style.STROKE);
      ((Paint)localObject1).setColor(-16777216);
      localPaint.setStrokeWidth(1.0F);
      localPaint.setStrokeCap(Paint.Cap.BUTT);
      localPaint.setStrokeJoin(Paint.Join.MITER);
      localPaint.setStrokeMiter(4.0F);
      localPaint.setPathEffect(null);
      localPaint = c.instancePaint(localPaint, paramVarArgs);
      localPaint.setStrokeWidth(1.0F);
      localCanvas.save();
      localObject3 = c.setMatrixFloatArray((float[])localObject3, 1.0F, 0.0F, -556.0F, 0.0F, 1.0F, -981.0F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject2).reset();
      ((Matrix)localObject2).setValues((float[])localObject3);
      localCanvas.concat((Matrix)localObject2);
      localCanvas.save();
      localObject3 = c.setMatrixFloatArray((float[])localObject3, 1.0F, 0.0F, 556.0F, 0.0F, 1.0F, 981.0F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject2).reset();
      ((Matrix)localObject2).setValues((float[])localObject3);
      localCanvas.concat((Matrix)localObject2);
      localCanvas.save();
      localObject2 = c.instancePaint(localPaint, paramVarArgs);
      ((Paint)localObject2).setColor(-13158600);
      ((Paint)localObject2).setStrokeWidth(2.0F);
      localObject3 = c.instancePath(paramVarArgs);
      ((Path)localObject3).moveTo(20.0F, 1.0F);
      ((Path)localObject3).cubicTo(30.493412F, 1.0F, 39.0F, 9.506589F, 39.0F, 20.0F);
      ((Path)localObject3).cubicTo(39.0F, 30.493412F, 30.493412F, 39.0F, 20.0F, 39.0F);
      ((Path)localObject3).cubicTo(9.506589F, 39.0F, 1.0F, 30.493412F, 1.0F, 20.0F);
      ((Path)localObject3).cubicTo(1.0F, 9.506589F, 9.506589F, 1.0F, 20.0F, 1.0F);
      ((Path)localObject3).close();
      localCanvas.drawPath((Path)localObject3, (Paint)localObject2);
      localCanvas.restore();
      localCanvas.save();
      localObject2 = c.instancePaint((Paint)localObject1, paramVarArgs);
      ((Paint)localObject2).setColor(-13158600);
      localObject3 = c.instancePath(paramVarArgs);
      ((Path)localObject3).moveTo(13.0F, 13.0F);
      ((Path)localObject3).cubicTo(13.0F, 12.447715F, 13.447715F, 12.0F, 14.0F, 12.0F);
      ((Path)localObject3).lineTo(15.0F, 12.0F);
      ((Path)localObject3).cubicTo(15.552285F, 12.0F, 16.0F, 12.447715F, 16.0F, 13.0F);
      ((Path)localObject3).lineTo(16.0F, 18.0F);
      ((Path)localObject3).cubicTo(16.0F, 18.552284F, 15.552285F, 19.0F, 15.0F, 19.0F);
      ((Path)localObject3).lineTo(14.0F, 19.0F);
      ((Path)localObject3).cubicTo(13.447715F, 19.0F, 13.0F, 18.552284F, 13.0F, 18.0F);
      ((Path)localObject3).lineTo(13.0F, 13.0F);
      ((Path)localObject3).close();
      localCanvas.drawPath((Path)localObject3, (Paint)localObject2);
      localCanvas.restore();
      localCanvas.save();
      localObject1 = c.instancePaint((Paint)localObject1, paramVarArgs);
      ((Paint)localObject1).setColor(-13158600);
      localObject2 = c.instancePath(paramVarArgs);
      ((Path)localObject2).moveTo(24.0F, 13.0F);
      ((Path)localObject2).cubicTo(24.0F, 12.447715F, 24.447716F, 12.0F, 25.0F, 12.0F);
      ((Path)localObject2).lineTo(26.0F, 12.0F);
      ((Path)localObject2).cubicTo(26.552284F, 12.0F, 27.0F, 12.447715F, 27.0F, 13.0F);
      ((Path)localObject2).lineTo(27.0F, 18.0F);
      ((Path)localObject2).cubicTo(27.0F, 18.552284F, 26.552284F, 19.0F, 26.0F, 19.0F);
      ((Path)localObject2).lineTo(25.0F, 19.0F);
      ((Path)localObject2).cubicTo(24.447716F, 19.0F, 24.0F, 18.552284F, 24.0F, 18.0F);
      ((Path)localObject2).lineTo(24.0F, 13.0F);
      ((Path)localObject2).close();
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.save();
      localPaint = c.instancePaint(localPaint, paramVarArgs);
      localPaint.setColor(-13158600);
      localPaint.setStrokeWidth(2.0F);
      localObject1 = c.instancePath(paramVarArgs);
      ((Path)localObject1).moveTo(28.0F, 23.0F);
      ((Path)localObject1).lineTo(28.0F, 24.0F);
      ((Path)localObject1).cubicTo(28.0F, 25.656855F, 27.328426F, 27.156855F, 26.242641F, 28.242641F);
      ((Path)localObject1).cubicTo(25.156855F, 29.328426F, 23.656855F, 30.0F, 22.0F, 30.0F);
      ((Path)localObject1).lineTo(22.0F, 30.0F);
      ((Path)localObject1).lineTo(18.0F, 30.0F);
      ((Path)localObject1).cubicTo(16.343145F, 30.0F, 14.843145F, 29.328426F, 13.75736F, 28.242641F);
      ((Path)localObject1).cubicTo(12.671573F, 27.156855F, 12.0F, 25.656855F, 12.0F, 24.0F);
      ((Path)localObject1).lineTo(12.0F, 24.0F);
      ((Path)localObject1).lineTo(12.0F, 23.0F);
      ((Path)localObject1).lineTo(28.0F, 23.0F);
      ((Path)localObject1).close();
      localCanvas.drawPath((Path)localObject1, localPaint);
      localCanvas.restore();
      localCanvas.restore();
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.ime_emoji
 * JD-Core Version:    0.7.0.1
 */