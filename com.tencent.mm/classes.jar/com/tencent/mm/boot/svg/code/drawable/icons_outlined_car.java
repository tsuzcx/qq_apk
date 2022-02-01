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

public class icons_outlined_car
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
      Matrix localMatrix = c.instanceMatrix(paramVarArgs);
      float[] arrayOfFloat = c.instanceMatrixArray(paramVarArgs);
      Object localObject1 = c.instancePaint(paramVarArgs);
      ((Paint)localObject1).setFlags(385);
      ((Paint)localObject1).setStyle(Paint.Style.FILL);
      Object localObject2 = c.instancePaint(paramVarArgs);
      ((Paint)localObject2).setFlags(385);
      ((Paint)localObject2).setStyle(Paint.Style.STROKE);
      ((Paint)localObject1).setColor(-16777216);
      ((Paint)localObject2).setStrokeWidth(1.0F);
      ((Paint)localObject2).setStrokeCap(Paint.Cap.BUTT);
      ((Paint)localObject2).setStrokeJoin(Paint.Join.MITER);
      ((Paint)localObject2).setStrokeMiter(4.0F);
      ((Paint)localObject2).setPathEffect(null);
      localObject1 = c.instancePaint((Paint)localObject2, paramVarArgs);
      ((Paint)localObject1).setStrokeWidth(1.0F);
      localCanvas.save();
      localObject2 = c.instancePaint((Paint)localObject1, paramVarArgs);
      ((Paint)localObject2).setColor(-16777216);
      ((Paint)localObject2).setStrokeWidth(1.2F);
      Path localPath = c.instancePath(paramVarArgs);
      localPath.moveTo(13.56426F, 5.232216F);
      localPath.cubicTo(14.201277F, 5.232216F, 14.811565F, 5.410282F, 15.335421F, 5.729978F);
      localPath.cubicTo(15.859277F, 6.049673F, 16.2967F, 6.510998F, 16.587984F, 7.077517F);
      localPath.lineTo(16.587984F, 7.077517F);
      localPath.lineTo(17.635986F, 9.115768F);
      localPath.cubicTo(18.656149F, 9.026703F, 19.548983F, 9.319982F, 20.182356F, 9.868035F);
      localPath.cubicTo(20.740223F, 10.350753F, 21.092789F, 11.029289F, 21.151768F, 11.796018F);
      localPath.cubicTo(21.203257F, 12.465385F, 20.982704F, 13.08923F, 20.583101F, 13.558576F);
      localPath.cubicTo(20.188042F, 14.022585F, 19.618258F, 14.335212F, 18.965971F, 14.391179F);
      localPath.lineTo(18.965971F, 14.391179F);
      localPath.lineTo(5.239632F, 14.4F);
      localPath.cubicTo(4.57689F, 14.4F, 3.97689F, 14.131371F, 3.542576F, 13.697057F);
      localPath.cubicTo(3.112927F, 13.267407F, 2.845422F, 12.675613F, 2.839733F, 12.021248F);
      localPath.cubicTo(2.907005F, 11.162231F, 3.24557F, 10.434799F, 3.763575F, 9.919733F);
      localPath.cubicTo(4.354971F, 9.331692F, 5.177349F, 9.025495F, 6.064074F, 9.11551F);
      localPath.lineTo(6.064074F, 9.11551F);
      localPath.lineTo(7.441917F, 7.116476F);
      localPath.cubicTo(7.732494F, 6.533122F, 8.176911F, 6.058528F, 8.711603F, 5.731562F);
      localPath.cubicTo(9.236009F, 5.410888F, 9.847248F, 5.232216F, 10.485358F, 5.232216F);
      localPath.lineTo(10.485358F, 5.232216F);
      localPath.close();
      localCanvas.drawPath(localPath, (Paint)localObject2);
      localCanvas.restore();
      localCanvas.save();
      localObject2 = c.instancePaint((Paint)localObject1, paramVarArgs);
      ((Paint)localObject2).setColor(-16777216);
      ((Paint)localObject2).setStrokeWidth(1.2F);
      localPath = c.instancePath(paramVarArgs);
      localPath.moveTo(2.84436F, 11.863162F);
      localPath.lineTo(2.84436F, 16.0F);
      localPath.cubicTo(2.84436F, 16.828426F, 3.515933F, 17.5F, 4.344359F, 17.5F);
      localPath.lineTo(5.344359F, 17.5F);
      localPath.cubicTo(6.172787F, 17.5F, 6.844359F, 16.828426F, 6.844359F, 16.0F);
      localPath.lineTo(6.844359F, 14.167176F);
      localPath.lineTo(6.844359F, 14.167176F);
      localCanvas.drawPath(localPath, (Paint)localObject2);
      localCanvas.restore();
      localCanvas.save();
      localObject2 = c.instancePaint((Paint)localObject1, paramVarArgs);
      ((Paint)localObject2).setColor(-16777216);
      ((Paint)localObject2).setStrokeWidth(1.2F);
      arrayOfFloat = c.setMatrixFloatArray(arrayOfFloat, -1.0F, 0.0F, 38.321735F, 0.0F, 1.0F, 0.0F, 0.0F, 0.0F, 1.0F);
      localMatrix.reset();
      localMatrix.setValues(arrayOfFloat);
      localCanvas.concat(localMatrix);
      localPath = c.instancePath(paramVarArgs);
      localPath.moveTo(17.160868F, 11.863162F);
      localPath.lineTo(17.160868F, 16.0F);
      localPath.cubicTo(17.160868F, 16.828426F, 17.832441F, 17.5F, 18.660868F, 17.5F);
      localPath.lineTo(19.660868F, 17.5F);
      localPath.cubicTo(20.489294F, 17.5F, 21.160868F, 16.828426F, 21.160868F, 16.0F);
      localPath.lineTo(21.160868F, 14.167176F);
      localPath.lineTo(21.160868F, 14.167176F);
      localCanvas.drawPath(localPath, (Paint)localObject2);
      localCanvas.restore();
      localCanvas.save();
      localObject2 = c.instancePaint((Paint)localObject1, paramVarArgs);
      ((Paint)localObject2).setColor(-16777216);
      ((Paint)localObject2).setStrokeCap(Paint.Cap.ROUND);
      localPath = c.instancePath(paramVarArgs);
      localPath.moveTo(5.0F, 7.154218F);
      localPath.lineTo(6.535443F, 7.845782F);
      localCanvas.drawPath(localPath, (Paint)localObject2);
      localCanvas.restore();
      localCanvas.save();
      localObject2 = c.instancePaint((Paint)localObject1, paramVarArgs);
      ((Paint)localObject2).setColor(-16777216);
      ((Paint)localObject2).setStrokeCap(Paint.Cap.ROUND);
      arrayOfFloat = c.setMatrixFloatArray(arrayOfFloat, -1.0F, 0.0F, 36.464558F, 0.0F, 1.0F, 0.0F, 0.0F, 0.0F, 1.0F);
      localMatrix.reset();
      localMatrix.setValues(arrayOfFloat);
      localCanvas.concat(localMatrix);
      localPath = c.instancePath(paramVarArgs);
      localPath.moveTo(17.464558F, 7.154218F);
      localPath.lineTo(19.0F, 7.845782F);
      localCanvas.drawPath(localPath, (Paint)localObject2);
      localCanvas.restore();
      localCanvas.save();
      localObject1 = c.instancePaint((Paint)localObject1, paramVarArgs);
      ((Paint)localObject1).setColor(-16777216);
      ((Paint)localObject1).setStrokeWidth(1.2F);
      localObject2 = c.instancePath(paramVarArgs);
      ((Path)localObject2).moveTo(6.0F, 9.105143F);
      ((Path)localObject2).lineTo(17.879782F, 9.105143F);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.save();
      localObject1 = c.setMatrixFloatArray(arrayOfFloat, 1.0F, 0.0F, 17.464558F, 0.0F, 1.0F, 7.0F, 0.0F, 0.0F, 1.0F);
      localMatrix.reset();
      localMatrix.setValues((float[])localObject1);
      localCanvas.concat(localMatrix);
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.icons_outlined_car
 * JD-Core Version:    0.7.0.1
 */