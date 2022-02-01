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

public class icons_outlined_good
  extends c
{
  private final int height = 24;
  private final int width = 24;
  
  public int doCommand(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 24;
      return 24;
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
      localPaint1 = c.instancePaint(localPaint2, paramVarArgs);
      localPaint1.setStrokeWidth(1.0F);
      localCanvas.save();
      localPaint1 = c.instancePaint(localPaint1, paramVarArgs);
      localPaint1.setColor(-6842473);
      localObject2 = c.setMatrixFloatArray((float[])localObject2, 1.0F, 0.0F, 2.5F, 0.0F, 1.0F, 1.0F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject2);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject1 = c.instancePaint(localPaint1, paramVarArgs);
      localObject2 = c.instancePath(paramVarArgs);
      ((Path)localObject2).moveTo(3.5F, 8.346154F);
      ((Path)localObject2).lineTo(3.5F, 19.5F);
      ((Path)localObject2).lineTo(0.8494209F, 19.5F);
      ((Path)localObject2).lineTo(0.5F, 8.692308F);
      ((Path)localObject2).lineTo(3.5F, 8.346154F);
      ((Path)localObject2).close();
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.save();
      localObject1 = c.instancePaint(localPaint1, paramVarArgs);
      localObject2 = c.instancePath(paramVarArgs);
      ((Path)localObject2).moveTo(9.810811F, 0.5F);
      ((Path)localObject2).cubicTo(10.242683F, 0.5F, 10.619177F, 0.6535361F, 10.912958F, 0.9058222F);
      ((Path)localObject2).cubicTo(11.240121F, 1.186774F, 11.465509F, 1.586257F, 11.561556F, 2.029064F);
      ((Path)localObject2).cubicTo(11.710274F, 2.622721F, 11.781854F, 3.272979F, 11.781854F, 3.923077F);
      ((Path)localObject2).cubicTo(11.781854F, 5.204612F, 11.552982F, 6.371582F, 11.089932F, 7.423077F);
      ((Path)localObject2).lineTo(11.089932F, 7.423077F);
      ((Path)localObject2).lineTo(16.580177F, 7.423077F);
      ((Path)localObject2).cubicTo(17.196596F, 7.490523F, 17.814562F, 7.795818F, 18.185591F, 8.411823F);
      ((Path)localObject2).cubicTo(18.446613F, 8.802871F, 18.498081F, 9.237287F, 18.499941F, 9.667372F);
      ((Path)localObject2).cubicTo(18.464209F, 10.015849F, 18.438932F, 10.232803F, 18.420803F, 10.317602F);
      ((Path)localObject2).cubicTo(17.936535F, 12.582813F, 16.981899F, 16.898571F, 16.687799F, 18.143236F);
      ((Path)localObject2).cubicTo(16.490795F, 18.690409F, 16.266588F, 19.005083F, 15.963558F, 19.186201F);
      ((Path)localObject2).cubicTo(15.652905F, 19.371878F, 15.280899F, 19.5F, 14.907336F, 19.5F);
      ((Path)localObject2).lineTo(14.907336F, 19.5F);
      ((Path)localObject2).lineTo(3.5F, 19.5F);
      ((Path)localObject2).lineTo(3.5F, 8.280641F);
      ((Path)localObject2).cubicTo(5.308627F, 7.954559F, 6.447856F, 6.83919F, 7.038682F, 5.723351F);
      ((Path)localObject2).cubicTo(7.488668F, 4.873503F, 7.803633F, 3.821791F, 7.839469F, 2.786528F);
      ((Path)localObject2).cubicTo(7.839768F, 2.089062F, 8.027642F, 1.500112F, 8.393714F, 1.089865F);
      ((Path)localObject2).cubicTo(8.730702F, 0.7122116F, 9.217119F, 0.5F, 9.810811F, 0.5F);
      ((Path)localObject2).lineTo(9.810811F, 0.5F);
      ((Path)localObject2).close();
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.icons_outlined_good
 * JD-Core Version:    0.7.0.1
 */