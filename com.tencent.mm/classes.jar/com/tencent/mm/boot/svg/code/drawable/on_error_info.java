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

public class on_error_info
  extends c
{
  private final int height = 18;
  private final int width = 18;
  
  public int doCommand(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 18;
      return 18;
      Canvas localCanvas = (Canvas)paramVarArgs[0];
      paramVarArgs = (Looper)paramVarArgs[1];
      Object localObject1 = c.instanceMatrix(paramVarArgs);
      float[] arrayOfFloat = c.instanceMatrixArray(paramVarArgs);
      Paint localPaint = c.instancePaint(paramVarArgs);
      localPaint.setFlags(385);
      localPaint.setStyle(Paint.Style.FILL);
      Object localObject2 = c.instancePaint(paramVarArgs);
      ((Paint)localObject2).setFlags(385);
      ((Paint)localObject2).setStyle(Paint.Style.STROKE);
      localPaint.setColor(-16777216);
      ((Paint)localObject2).setStrokeWidth(1.0F);
      ((Paint)localObject2).setStrokeCap(Paint.Cap.BUTT);
      ((Paint)localObject2).setStrokeJoin(Paint.Join.MITER);
      ((Paint)localObject2).setStrokeMiter(4.0F);
      ((Paint)localObject2).setPathEffect(null);
      localObject2 = c.instancePaint((Paint)localObject2, paramVarArgs);
      ((Paint)localObject2).setStrokeWidth(1.0F);
      localCanvas.save();
      arrayOfFloat = c.setMatrixFloatArray(arrayOfFloat, 1.0F, 0.0F, -3.0F, 0.0F, 1.0F, -3.0F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      arrayOfFloat = c.setMatrixFloatArray(arrayOfFloat, 1.0F, 0.0F, 4.0F, 0.0F, 1.0F, 4.0F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject1 = c.instancePaint((Paint)localObject2, paramVarArgs);
      ((Paint)localObject1).setColor(-372399);
      ((Paint)localObject1).setStrokeWidth(0.888889F);
      localObject2 = c.instancePath(paramVarArgs);
      ((Path)localObject2).moveTo(15.838384F, 8.00678F);
      ((Path)localObject2).cubicTo(15.838384F, 3.540949F, 12.292933F, 0.0F, 7.821424F, 0.0F);
      ((Path)localObject2).cubicTo(3.545452F, 0.0F, 0.0F, 3.540949F, 0.0F, 8.00678F);
      ((Path)localObject2).cubicTo(0.0F, 12.277322F, 3.545452F, 15.818272F, 7.821424F, 15.818272F);
      ((Path)localObject2).cubicTo(12.292933F, 15.818272F, 15.838384F, 12.277322F, 15.838384F, 8.00678F);
      ((Path)localObject2).close();
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.save();
      localPaint = c.instancePaint(localPaint, paramVarArgs);
      localPaint.setColor(-372399);
      localObject1 = c.instancePath(paramVarArgs);
      ((Path)localObject1).moveTo(8.129927F, 10.750443F);
      ((Path)localObject1).cubicTo(8.558716F, 10.750443F, 8.906318F, 11.097604F, 8.906318F, 11.525848F);
      ((Path)localObject1).cubicTo(8.906318F, 11.954093F, 8.558716F, 12.301254F, 8.129927F, 12.301254F);
      ((Path)localObject1).cubicTo(7.701138F, 12.301254F, 7.353535F, 11.954093F, 7.353535F, 11.525848F);
      ((Path)localObject1).cubicTo(7.353535F, 11.097604F, 7.701138F, 10.750443F, 8.129927F, 10.750443F);
      ((Path)localObject1).close();
      ((Path)localObject1).moveTo(8.129927F, 4.237037F);
      ((Path)localObject1).cubicTo(8.561706F, 4.237037F, 8.890207F, 4.58459F, 8.870334F, 5.013318F);
      ((Path)localObject1).lineTo(8.870334F, 5.013318F);
      ((Path)localObject1).lineTo(8.675217F, 9.222487F);
      ((Path)localObject1).cubicTo(8.660004F, 9.55068F, 8.383294F, 9.819957F, 8.057353F, 9.819957F);
      ((Path)localObject1).lineTo(8.129536F, 9.814037F);
      ((Path)localObject1).lineTo(8.10568F, 9.812137F);
      ((Path)localObject1).cubicTo(7.852998F, 9.770977F, 7.648717F, 9.571741F, 7.596772F, 9.319399F);
      ((Path)localObject1).lineTo(7.584637F, 9.222487F);
      ((Path)localObject1).lineTo(7.38952F, 5.013318F);
      ((Path)localObject1).cubicTo(7.369724F, 4.586274F, 7.701138F, 4.237037F, 8.129927F, 4.237037F);
      ((Path)localObject1).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject1, 2);
      localCanvas.drawPath((Path)localObject1, localPaint);
      localCanvas.restore();
      localCanvas.restore();
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.on_error_info
 * JD-Core Version:    0.7.0.1
 */