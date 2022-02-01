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

public class scan_translation_hl
  extends c
{
  private final int height = 108;
  private final int width = 108;
  
  public int doCommand(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 108;
      return 108;
      Canvas localCanvas = (Canvas)paramVarArgs[0];
      paramVarArgs = (Looper)paramVarArgs[1];
      Object localObject1 = c.instanceMatrix(paramVarArgs);
      Object localObject3 = c.instanceMatrixArray(paramVarArgs);
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
      localObject2 = c.instancePaint((Paint)localObject2, paramVarArgs);
      ((Paint)localObject2).setColor(-12470759);
      localObject3 = c.setMatrixFloatArray((float[])localObject3, 1.0F, 0.0F, 16.0F, 0.0F, 1.0F, 9.0F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject3);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject1 = c.instancePaint((Paint)localObject2, paramVarArgs);
      localObject3 = c.instancePath(paramVarArgs);
      ((Path)localObject3).moveTo(34.169529F, 37.009228F);
      ((Path)localObject3).lineTo(35.931976F, 41.59285F);
      ((Path)localObject3).lineTo(38.864815F, 41.59285F);
      ((Path)localObject3).lineTo(32.066803F, 23.913153F);
      ((Path)localObject3).lineTo(31.717865F, 23.913153F);
      ((Path)localObject3).lineTo(28.785027F, 23.913153F);
      ((Path)localObject3).lineTo(21.987013F, 41.59285F);
      ((Path)localObject3).lineTo(24.919851F, 41.59285F);
      ((Path)localObject3).lineTo(26.682299F, 37.009228F);
      ((Path)localObject3).lineTo(34.169529F, 37.009228F);
      ((Path)localObject3).close();
      ((Path)localObject3).moveTo(33.162415F, 34.390011F);
      ((Path)localObject3).lineTo(27.689413F, 34.390011F);
      ((Path)localObject3).lineTo(30.425915F, 27.273148F);
      ((Path)localObject3).lineTo(33.162415F, 34.390011F);
      ((Path)localObject3).close();
      ((Path)localObject3).moveTo(13.695652F, 9.0F);
      ((Path)localObject3).lineTo(70.538116F, 9.0F);
      ((Path)localObject3).cubicTo(73.131454F, 9.0F, 75.233765F, 11.102315F, 75.233765F, 13.695652F);
      ((Path)localObject3).lineTo(75.233765F, 84.992531F);
      ((Path)localObject3).cubicTo(75.233765F, 87.585861F, 73.131454F, 89.688179F, 70.538116F, 89.688179F);
      ((Path)localObject3).lineTo(13.695652F, 89.688179F);
      ((Path)localObject3).cubicTo(11.102315F, 89.688179F, 9.0F, 87.585861F, 9.0F, 84.992531F);
      ((Path)localObject3).lineTo(9.0F, 13.695652F);
      ((Path)localObject3).cubicTo(9.0F, 11.102315F, 11.102315F, 9.0F, 13.695652F, 9.0F);
      ((Path)localObject3).close();
      ((Path)localObject3).moveTo(21.042503F, 53.150135F);
      ((Path)localObject3).lineTo(21.042503F, 57.717392F);
      ((Path)localObject3).lineTo(63.191265F, 57.717392F);
      ((Path)localObject3).lineTo(63.191265F, 53.150135F);
      ((Path)localObject3).lineTo(21.042503F, 53.150135F);
      ((Path)localObject3).close();
      ((Path)localObject3).moveTo(21.042503F, 63.807064F);
      ((Path)localObject3).lineTo(21.042503F, 68.374321F);
      ((Path)localObject3).lineTo(63.191265F, 68.374321F);
      ((Path)localObject3).lineTo(63.191265F, 63.807064F);
      ((Path)localObject3).lineTo(21.042503F, 63.807064F);
      ((Path)localObject3).close();
      ((Path)localObject3).moveTo(21.042503F, 72.941574F);
      ((Path)localObject3).lineTo(21.042503F, 77.508835F);
      ((Path)localObject3).lineTo(63.191265F, 77.508835F);
      ((Path)localObject3).lineTo(63.191265F, 72.941574F);
      ((Path)localObject3).lineTo(21.042503F, 72.941574F);
      ((Path)localObject3).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject3, 2);
      localCanvas.drawPath((Path)localObject3, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.save();
      localObject1 = c.instancePaint((Paint)localObject2, paramVarArgs);
      localObject2 = c.instancePath(paramVarArgs);
      ((Path)localObject2).moveTo(67.709343F, 6.086957F);
      ((Path)localObject2).lineTo(8.366434F, 6.086957F);
      ((Path)localObject2).cubicTo(7.069766F, 6.086957F, 6.018608F, 7.138114F, 6.018608F, 8.434783F);
      ((Path)localObject2).lineTo(6.018608F, 82.173912F);
      ((Path)localObject2).lineTo(4.695652F, 82.173912F);
      ((Path)localObject2).cubicTo(2.102315F, 82.173912F, -5.705862E-016F, 80.071594F, -8.881784E-016F, 77.478264F);
      ((Path)localObject2).lineTo(0.0F, 4.695652F);
      ((Path)localObject2).cubicTo(-3.175922E-016F, 2.102315F, 2.102315F, 2.252745E-015F, 4.695652F, 1.776357E-015F);
      ((Path)localObject2).lineTo(63.013691F, 0.0F);
      ((Path)localObject2).cubicTo(65.607025F, -5.08308E-015F, 67.709343F, 2.102315F, 67.709343F, 4.695652F);
      ((Path)localObject2).lineTo(67.709343F, 6.086957F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 2);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.scan_translation_hl
 * JD-Core Version:    0.7.0.1
 */