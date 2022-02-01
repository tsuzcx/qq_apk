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

public class ime_active_bg
  extends c
{
  private final int height = 283;
  private final int width = 704;
  
  public int doCommand(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 704;
      return 283;
      Canvas localCanvas = (Canvas)paramVarArgs[0];
      paramVarArgs = (Looper)paramVarArgs[1];
      Object localObject1 = c.instanceMatrix(paramVarArgs);
      Object localObject2 = c.instanceMatrixArray(paramVarArgs);
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
      localCanvas.save();
      localObject2 = c.setMatrixFloatArray((float[])localObject2, 1.0F, 0.0F, -23.0F, 0.0F, 1.0F, -1317.0F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject2);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject2 = c.setMatrixFloatArray((float[])localObject2, 1.0F, 0.0F, 23.0F, 0.0F, 1.0F, 1317.0F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject2);
      localCanvas.concat((Matrix)localObject1);
      localObject1 = c.instancePaint(localPaint1, paramVarArgs);
      ((Paint)localObject1).setColor(-16334496);
      localCanvas.save();
      localObject1 = c.instancePaint((Paint)localObject1, paramVarArgs);
      localObject2 = c.instancePath(paramVarArgs);
      ((Path)localObject2).moveTo(0.0F, 15.0F);
      ((Path)localObject2).cubicTo(0.0F, 6.715729F, 6.715729F, 0.0F, 15.0F, 0.0F);
      ((Path)localObject2).lineTo(689.0F, 0.0F);
      ((Path)localObject2).cubicTo(697.2843F, 0.0F, 704.0F, 6.715729F, 704.0F, 15.0F);
      ((Path)localObject2).lineTo(704.0F, 268.0F);
      ((Path)localObject2).cubicTo(704.0F, 276.28427F, 697.2843F, 283.0F, 689.0F, 283.0F);
      ((Path)localObject2).lineTo(15.0F, 283.0F);
      ((Path)localObject2).cubicTo(6.715729F, 283.0F, 0.0F, 276.28427F, 0.0F, 268.0F);
      ((Path)localObject2).lineTo(0.0F, 15.0F);
      ((Path)localObject2).close();
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.save();
      localObject1 = c.instancePaint(localPaint1, paramVarArgs);
      ((Paint)localObject1).setColor(419430399);
      localObject2 = c.instancePath(paramVarArgs);
      ((Path)localObject2).moveTo(669.0F, 200.0F);
      ((Path)localObject2).cubicTo(707.65991F, 200.0F, 739.0F, 231.34006F, 739.0F, 270.0F);
      ((Path)localObject2).cubicTo(739.0F, 308.65994F, 707.65991F, 340.0F, 669.0F, 340.0F);
      ((Path)localObject2).cubicTo(630.34009F, 340.0F, 599.0F, 308.65994F, 599.0F, 270.0F);
      ((Path)localObject2).cubicTo(599.0F, 231.34006F, 630.34009F, 200.0F, 669.0F, 200.0F);
      ((Path)localObject2).close();
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.save();
      localPaint1 = c.instancePaint(localPaint1, paramVarArgs);
      localPaint1.setColor(436207615);
      localObject1 = c.instancePath(paramVarArgs);
      ((Path)localObject1).moveTo(650.5F, -64.0F);
      ((Path)localObject1).cubicTo(728.64832F, -64.0F, 792.0F, -0.6482925F, 792.0F, 77.5F);
      ((Path)localObject1).cubicTo(792.0F, 155.64828F, 728.64832F, 219.0F, 650.5F, 219.0F);
      ((Path)localObject1).cubicTo(572.35168F, 219.0F, 509.0F, 155.64828F, 509.0F, 77.5F);
      ((Path)localObject1).cubicTo(509.0F, -0.6482925F, 572.35168F, -64.0F, 650.5F, -64.0F);
      ((Path)localObject1).close();
      localCanvas.drawPath((Path)localObject1, localPaint1);
      localCanvas.restore();
      localCanvas.restore();
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.ime_active_bg
 * JD-Core Version:    0.7.0.1
 */