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

public class login_app_default_avatar
  extends c
{
  private final int height = 120;
  private final int width = 120;
  
  public int doCommand(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 120;
      return 120;
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
      localObject2 = c.setMatrixFloatArray((float[])localObject2, 1.0F, 0.0F, -180.0F, 0.0F, 1.0F, -98.0F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject2);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject2 = c.setMatrixFloatArray((float[])localObject2, 1.0F, 0.0F, 180.0F, 0.0F, 1.0F, 98.0F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject2);
      localCanvas.concat((Matrix)localObject1);
      localObject1 = c.instancePaint(localPaint1, paramVarArgs);
      ((Paint)localObject1).setColor(-3552823);
      localCanvas.save();
      localObject1 = c.instancePaint((Paint)localObject1, paramVarArgs);
      localObject2 = c.instancePath(paramVarArgs);
      ((Path)localObject2).moveTo(0.0F, 0.0F);
      ((Path)localObject2).lineTo(120.0F, 0.0F);
      ((Path)localObject2).lineTo(120.0F, 120.0F);
      ((Path)localObject2).lineTo(0.0F, 120.0F);
      ((Path)localObject2).lineTo(0.0F, 0.0F);
      ((Path)localObject2).close();
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.save();
      localPaint1 = c.instancePaint(localPaint1, paramVarArgs);
      localPaint1.setColor(-1);
      localObject1 = c.instancePath(paramVarArgs);
      ((Path)localObject1).moveTo(84.015633F, 54.268833F);
      ((Path)localObject1).cubicTo(89.063972F, 49.220486F, 89.019447F, 40.999851F, 83.919144F, 35.899551F);
      ((Path)localObject1).cubicTo(78.819962F, 30.800369F, 70.595184F, 30.757744F, 65.549866F, 35.803066F);
      ((Path)localObject1).lineTo(53.803066F, 47.549866F);
      ((Path)localObject1).cubicTo(48.754719F, 52.598209F, 48.799248F, 60.818844F, 53.899551F, 65.919144F);
      ((Path)localObject1).lineTo(56.509949F, 63.308746F);
      ((Path)localObject1).cubicTo(52.866802F, 59.6656F, 52.805256F, 53.823605F, 56.441032F, 50.187832F);
      ((Path)localObject1).lineTo(68.187828F, 38.441032F);
      ((Path)localObject1).cubicTo(71.821533F, 34.807327F, 77.667282F, 34.868488F, 81.308746F, 38.509949F);
      ((Path)localObject1).cubicTo(84.951897F, 42.153095F, 85.013443F, 47.99509F, 81.377663F, 51.630867F);
      ((Path)localObject1).lineTo(75.504265F, 57.504265F);
      ((Path)localObject1).lineTo(78.142235F, 60.142231F);
      ((Path)localObject1).lineTo(84.015633F, 54.268833F);
      ((Path)localObject1).close();
      ((Path)localObject1).moveTo(35.803066F, 65.549866F);
      ((Path)localObject1).cubicTo(30.754721F, 70.598206F, 30.799248F, 78.818848F, 35.899551F, 83.919144F);
      ((Path)localObject1).cubicTo(40.99873F, 89.018326F, 49.223511F, 89.060951F, 54.268833F, 84.015633F);
      ((Path)localObject1).lineTo(66.015633F, 72.268829F);
      ((Path)localObject1).cubicTo(71.063972F, 67.22049F, 71.019447F, 58.999851F, 65.919144F, 53.899551F);
      ((Path)localObject1).lineTo(63.308746F, 56.509949F);
      ((Path)localObject1).cubicTo(66.951897F, 60.153095F, 67.013443F, 65.995087F, 63.377663F, 69.630867F);
      ((Path)localObject1).lineTo(51.630867F, 81.377663F);
      ((Path)localObject1).cubicTo(47.997158F, 85.011368F, 42.151413F, 84.950211F, 38.509949F, 81.308746F);
      ((Path)localObject1).cubicTo(34.866802F, 77.665596F, 34.805256F, 71.823608F, 38.441032F, 68.187828F);
      ((Path)localObject1).lineTo(44.31443F, 62.31443F);
      ((Path)localObject1).lineTo(41.676464F, 59.676464F);
      ((Path)localObject1).lineTo(35.803066F, 65.549866F);
      ((Path)localObject1).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject1, 2);
      localCanvas.drawPath((Path)localObject1, localPaint1);
      localCanvas.restore();
      localCanvas.restore();
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.login_app_default_avatar
 * JD-Core Version:    0.7.0.1
 */