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

public class honey_pay_main_logo
  extends c
{
  private final int height = 104;
  private final int width = 104;
  
  public int doCommand(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 104;
      return 104;
      Canvas localCanvas = (Canvas)paramVarArgs[0];
      paramVarArgs = (Looper)paramVarArgs[1];
      Object localObject = c.instanceMatrix(paramVarArgs);
      float[] arrayOfFloat = c.instanceMatrixArray(paramVarArgs);
      Paint localPaint2 = c.instancePaint(paramVarArgs);
      localPaint2.setFlags(385);
      localPaint2.setStyle(Paint.Style.FILL);
      Paint localPaint1 = c.instancePaint(paramVarArgs);
      localPaint1.setFlags(385);
      localPaint1.setStyle(Paint.Style.STROKE);
      localPaint2.setColor(-16777216);
      localPaint1.setStrokeWidth(1.0F);
      localPaint1.setStrokeCap(Paint.Cap.BUTT);
      localPaint1.setStrokeJoin(Paint.Join.MITER);
      localPaint1.setStrokeMiter(4.0F);
      localPaint1.setPathEffect(null);
      localPaint1 = c.instancePaint(localPaint1, paramVarArgs);
      localPaint1.setStrokeWidth(1.0F);
      localCanvas.save();
      localPaint2 = c.instancePaint(localPaint2, paramVarArgs);
      localPaint2.setColor(-15616);
      arrayOfFloat = c.setMatrixFloatArray(arrayOfFloat, 0.8987941F, -0.4383712F, 28.230295F, 0.4383712F, 0.8987941F, -15.78627F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject).reset();
      ((Matrix)localObject).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject);
      Path localPath = c.instancePath(paramVarArgs);
      localPath.moveTo(21.793938F, 18.856665F);
      localPath.lineTo(90.796371F, 43.881905F);
      localPath.cubicTo(92.528595F, 44.510136F, 93.421738F, 46.418655F, 92.79126F, 48.144703F);
      localPath.lineTo(79.092262F, 85.648125F);
      localPath.cubicTo(78.461784F, 87.374176F, 76.546432F, 88.26413F, 74.814201F, 87.635902F);
      localPath.lineTo(5.811771F, 62.610661F);
      localPath.cubicTo(4.079545F, 61.982433F, 3.186401F, 60.073914F, 3.816881F, 58.347866F);
      localPath.lineTo(17.515879F, 20.84444F);
      localPath.cubicTo(18.146358F, 19.118393F, 20.06171F, 18.228436F, 21.793938F, 18.856665F);
      localPath.close();
      localCanvas.saveLayerAlpha(null, 76, 31);
      localPaint2 = c.instancePaint(localPaint2, paramVarArgs);
      WeChatSVGRenderC2Java.setFillType(localPath, 2);
      localCanvas.drawPath(localPath, localPaint2);
      localCanvas.restore();
      localCanvas.restore();
      localCanvas.save();
      localPaint1 = c.instancePaint(localPaint1, paramVarArgs);
      localPaint1.setColor(-15616);
      localPaint1.setStrokeWidth(3.0F);
      localPaint1.setStrokeCap(Paint.Cap.ROUND);
      localPaint1.setStrokeJoin(Paint.Join.MITER);
      arrayOfFloat = c.setMatrixFloatArray(arrayOfFloat, 0.9975641F, 0.06975647F, -3.330513F, -0.06975647F, 0.9975641F, 3.923065F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject).reset();
      ((Matrix)localObject).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject);
      localObject = c.instancePath(paramVarArgs);
      ((Path)localObject).moveTo(59.294525F, 21.508471F);
      ((Path)localObject).cubicTo(64.629021F, 18.715134F, 70.330856F, 17.109463F, 76.400024F, 16.691454F);
      ((Path)localObject).cubicTo(85.764915F, 16.630167F, 93.192741F, 19.516296F, 96.613838F, 25.42067F);
      ((Path)localObject).cubicTo(103.76379F, 37.760567F, 90.705086F, 58.611069F, 67.446419F, 71.991562F);
      ((Path)localObject).cubicTo(44.187748F, 85.372063F, 19.536694F, 86.21563F, 12.386744F, 73.875732F);
      ((Path)localObject).cubicTo(11.534513F, 72.404892F, 10.96939F, 70.813141F, 10.674427F, 69.127533F);
      ((Path)localObject).cubicTo(10.217703F, 65.512238F, 10.431046F, 62.472187F, 11.314454F, 60.00737F);
      localCanvas.drawPath((Path)localObject, localPaint1);
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.honey_pay_main_logo
 * JD-Core Version:    0.7.0.1
 */