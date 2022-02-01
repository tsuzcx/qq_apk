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

public class refresh
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
      float[] arrayOfFloat = c.instanceMatrixArray(paramVarArgs);
      Object localObject2 = c.instancePaint(paramVarArgs);
      ((Paint)localObject2).setFlags(385);
      ((Paint)localObject2).setStyle(Paint.Style.FILL);
      Paint localPaint = c.instancePaint(paramVarArgs);
      localPaint.setFlags(385);
      localPaint.setStyle(Paint.Style.STROKE);
      ((Paint)localObject2).setColor(-16777216);
      localPaint.setStrokeWidth(1.0F);
      localPaint.setStrokeCap(Paint.Cap.BUTT);
      localPaint.setStrokeJoin(Paint.Join.MITER);
      localPaint.setStrokeMiter(4.0F);
      localPaint.setPathEffect(null);
      c.instancePaint(localPaint, paramVarArgs).setStrokeWidth(1.0F);
      localCanvas.save();
      arrayOfFloat = c.setMatrixFloatArray(arrayOfFloat, 1.0F, 0.0F, 9.0F, 0.0F, 1.0F, 6.0F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject1);
      localObject1 = c.instancePaint((Paint)localObject2, paramVarArgs);
      ((Paint)localObject1).setColor(-372399);
      localCanvas.save();
      localObject1 = c.instancePaint((Paint)localObject1, paramVarArgs);
      localObject2 = c.instancePath(paramVarArgs);
      ((Path)localObject2).moveTo(46.091885F, 13.908117F);
      ((Path)localObject2).cubicTo(50.977921F, 18.794155F, 54.0F, 25.544155F, 54.0F, 33.0F);
      ((Path)localObject2).cubicTo(54.0F, 47.91169F, 41.91169F, 60.0F, 27.0F, 60.0F);
      ((Path)localObject2).cubicTo(12.088312F, 60.0F, 0.0F, 47.91169F, 0.0F, 33.0F);
      ((Path)localObject2).cubicTo(0.0F, 18.088312F, 12.088312F, 6.0F, 27.0F, 6.0F);
      ((Path)localObject2).lineTo(27.0F, 9.6F);
      ((Path)localObject2).cubicTo(14.076537F, 9.6F, 3.6F, 20.076536F, 3.6F, 33.0F);
      ((Path)localObject2).cubicTo(3.6F, 45.923462F, 14.076537F, 56.400002F, 27.0F, 56.400002F);
      ((Path)localObject2).cubicTo(39.923462F, 56.400002F, 50.400002F, 45.923462F, 50.400002F, 33.0F);
      ((Path)localObject2).cubicTo(50.400002F, 26.706247F, 47.908665F, 20.816067F, 43.546299F, 16.453701F);
      ((Path)localObject2).lineTo(46.091885F, 13.908117F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(25.730843F, 9.633832F);
      ((Path)localObject2).cubicTo(13.397545F, 10.293022F, 3.6F, 20.502342F, 3.6F, 33.0F);
      ((Path)localObject2).cubicTo(3.6F, 45.923462F, 14.076537F, 56.400002F, 27.0F, 56.400002F);
      ((Path)localObject2).cubicTo(39.923462F, 56.400002F, 50.400002F, 45.923462F, 50.400002F, 33.0F);
      ((Path)localObject2).cubicTo(50.400002F, 26.706247F, 47.908665F, 20.816067F, 43.546299F, 16.453701F);
      ((Path)localObject2).lineTo(46.091885F, 13.908117F);
      ((Path)localObject2).cubicTo(50.977921F, 18.794155F, 54.0F, 25.544155F, 54.0F, 33.0F);
      ((Path)localObject2).cubicTo(54.0F, 47.91169F, 41.91169F, 60.0F, 27.0F, 60.0F);
      ((Path)localObject2).cubicTo(12.088312F, 60.0F, 0.0F, 47.91169F, 0.0F, 33.0F);
      ((Path)localObject2).cubicTo(0.0F, 18.928625F, 10.764283F, 7.371382F, 24.507618F, 6.113505F);
      ((Path)localObject2).lineTo(20.939697F, 2.545584F);
      ((Path)localObject2).lineTo(23.485281F, 3.03757E-013F);
      ((Path)localObject2).lineTo(30.909903F, 7.424621F);
      ((Path)localObject2).cubicTo(31.495689F, 8.010407F, 31.495689F, 8.960156F, 30.909903F, 9.545941F);
      ((Path)localObject2).lineTo(29.424978F, 11.030866F);
      ((Path)localObject2).lineTo(23.485281F, 16.970562F);
      ((Path)localObject2).lineTo(20.939697F, 14.424978F);
      ((Path)localObject2).lineTo(25.730843F, 9.633832F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 1);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.refresh
 * JD-Core Version:    0.7.0.1
 */