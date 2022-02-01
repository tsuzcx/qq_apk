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

public class icons_filled_mic_off
  extends c
{
  private final int height = 20;
  private final int width = 20;
  
  public int doCommand(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 20;
      return 20;
      Canvas localCanvas = (Canvas)paramVarArgs[0];
      paramVarArgs = (Looper)paramVarArgs[1];
      Matrix localMatrix = c.instanceMatrix(paramVarArgs);
      float[] arrayOfFloat = c.instanceMatrixArray(paramVarArgs);
      Paint localPaint = c.instancePaint(paramVarArgs);
      localPaint.setFlags(385);
      localPaint.setStyle(Paint.Style.FILL);
      Object localObject = c.instancePaint(paramVarArgs);
      ((Paint)localObject).setFlags(385);
      ((Paint)localObject).setStyle(Paint.Style.STROKE);
      localPaint.setColor(-16777216);
      ((Paint)localObject).setStrokeWidth(1.0F);
      ((Paint)localObject).setStrokeCap(Paint.Cap.BUTT);
      ((Paint)localObject).setStrokeJoin(Paint.Join.MITER);
      ((Paint)localObject).setStrokeMiter(4.0F);
      ((Paint)localObject).setPathEffect(null);
      c.instancePaint((Paint)localObject, paramVarArgs).setStrokeWidth(1.0F);
      localPaint = c.instancePaint(localPaint, paramVarArgs);
      localPaint.setColor(-436207616);
      localCanvas.save();
      localPaint = c.instancePaint(localPaint, paramVarArgs);
      localObject = c.instancePath(paramVarArgs);
      ((Path)localObject).moveTo(14.002537F, 12.23477F);
      ((Path)localObject).cubicTo(14.372465F, 11.573637F, 14.583333F, 10.811443F, 14.583333F, 10.0F);
      ((Path)localObject).lineTo(14.583333F, 8.333333F);
      ((Path)localObject).lineTo(15.833333F, 8.333333F);
      ((Path)localObject).lineTo(15.833333F, 10.0F);
      ((Path)localObject).cubicTo(15.833333F, 11.158424F, 15.495662F, 12.237981F, 14.913379F, 13.145612F);
      ((Path)localObject).lineTo(18.409903F, 16.642136F);
      ((Path)localObject).lineTo(17.52602F, 17.52602F);
      ((Path)localObject).lineTo(3.383884F, 3.383884F);
      ((Path)localObject).lineTo(4.267767F, 2.5F);
      ((Path)localObject).lineTo(6.668128F, 4.900361F);
      ((Path)localObject).cubicTo(6.720819F, 3.105502F, 8.192381F, 1.666667F, 10.0F, 1.666667F);
      ((Path)localObject).cubicTo(11.840949F, 1.666667F, 13.333333F, 3.159051F, 13.333333F, 5.0F);
      ((Path)localObject).lineTo(13.333333F, 10.0F);
      ((Path)localObject).cubicTo(13.333333F, 10.461895F, 13.239387F, 10.901847F, 13.069558F, 11.301791F);
      ((Path)localObject).lineTo(14.002537F, 12.23477F);
      ((Path)localObject).lineTo(14.002537F, 12.23477F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(12.23477F, 14.002537F);
      ((Path)localObject).lineTo(13.145612F, 14.913379F);
      ((Path)localObject).cubicTo(12.403411F, 15.389531F, 11.546246F, 15.702115F, 10.625F, 15.800243F);
      ((Path)localObject).lineTo(10.625F, 18.333334F);
      ((Path)localObject).lineTo(9.375F, 18.333334F);
      ((Path)localObject).lineTo(9.375F, 15.800243F);
      ((Path)localObject).cubicTo(6.447229F, 15.488386F, 4.166667F, 13.01052F, 4.166667F, 10.0F);
      ((Path)localObject).lineTo(4.166667F, 8.333333F);
      ((Path)localObject).lineTo(5.416667F, 8.333333F);
      ((Path)localObject).lineTo(5.416667F, 10.0F);
      ((Path)localObject).cubicTo(5.416667F, 12.531305F, 7.468695F, 14.583333F, 10.0F, 14.583333F);
      ((Path)localObject).cubicTo(10.811443F, 14.583333F, 11.573637F, 14.372465F, 12.23477F, 14.002537F);
      ((Path)localObject).lineTo(12.23477F, 14.002537F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(11.301791F, 13.069558F);
      ((Path)localObject).cubicTo(10.901847F, 13.239387F, 10.461895F, 13.333333F, 10.0F, 13.333333F);
      ((Path)localObject).cubicTo(8.159051F, 13.333333F, 6.666667F, 11.840949F, 6.666667F, 10.0F);
      ((Path)localObject).lineTo(6.666667F, 8.434434F);
      ((Path)localObject).lineTo(11.301791F, 13.069558F);
      ((Path)localObject).lineTo(11.301791F, 13.069558F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 2);
      localCanvas.drawPath((Path)localObject, localPaint);
      localCanvas.restore();
      localCanvas.save();
      arrayOfFloat = c.setMatrixFloatArray(arrayOfFloat, 0.7071068F, 0.7071068F, 4.755923F, -0.7071068F, 0.7071068F, 4.511845F, 0.0F, 0.0F, 1.0F);
      localMatrix.reset();
      localMatrix.setValues(arrayOfFloat);
      localCanvas.concat(localMatrix);
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.icons_filled_mic_off
 * JD-Core Version:    0.7.0.1
 */