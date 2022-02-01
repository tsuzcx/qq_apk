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

public class sns_img_delete
  extends c
{
  private final int height = 60;
  private final int width = 60;
  
  public int doCommand(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 60;
      return 60;
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
      localPaint2 = c.instancePaint(localPaint2, paramVarArgs);
      localPaint2.setStrokeWidth(1.0F);
      localCanvas.save();
      localObject2 = c.setMatrixFloatArray((float[])localObject2, 1.0F, 0.0F, 6.0F, 0.0F, 1.0F, 4.0F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject2);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      Object localObject3 = c.instancePaint(localPaint1, paramVarArgs);
      ((Paint)localObject3).setColor(-1);
      Path localPath = c.instancePath(paramVarArgs);
      localPath.moveTo(15.0F, 1.0F);
      localPath.cubicTo(15.0F, 0.4477152F, 15.447715F, 0.0F, 16.0F, 0.0F);
      localPath.lineTo(32.0F, 0.0F);
      localPath.cubicTo(32.552284F, 0.0F, 33.0F, 0.4477152F, 33.0F, 1.0F);
      localPath.lineTo(33.0F, 6.0F);
      localPath.cubicTo(33.0F, 6.552285F, 32.552284F, 7.0F, 32.0F, 7.0F);
      localPath.lineTo(16.0F, 7.0F);
      localPath.cubicTo(15.447715F, 7.0F, 15.0F, 6.552285F, 15.0F, 6.0F);
      localPath.lineTo(15.0F, 1.0F);
      localPath.close();
      localCanvas.drawPath(localPath, (Paint)localObject3);
      localCanvas.restore();
      localCanvas.save();
      localPaint2 = c.instancePaint(localPaint2, paramVarArgs);
      localPaint2.setColor(-1);
      localPaint2.setStrokeWidth(4.5F);
      localObject3 = c.instancePath(paramVarArgs);
      ((Path)localObject3).moveTo(7.25F, 8.25F);
      ((Path)localObject3).lineTo(40.75F, 8.25F);
      ((Path)localObject3).lineTo(40.75F, 50.75F);
      ((Path)localObject3).lineTo(7.25F, 50.75F);
      ((Path)localObject3).lineTo(7.25F, 8.25F);
      ((Path)localObject3).close();
      localCanvas.drawPath((Path)localObject3, localPaint2);
      localCanvas.restore();
      localCanvas.save();
      localPaint2 = c.instancePaint(localPaint1, paramVarArgs);
      localPaint2.setColor(-1);
      localObject2 = c.setMatrixFloatArray((float[])localObject2, 1.0F, 0.0F, 17.0F, 0.0F, 1.0F, 17.0F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject2);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject1 = c.instancePaint(localPaint2, paramVarArgs);
      localObject2 = c.instancePath(paramVarArgs);
      ((Path)localObject2).moveTo(0.0F, 1.0F);
      ((Path)localObject2).cubicTo(0.0F, 0.4477152F, 0.4477152F, -2.664535E-015F, 1.0F, -2.664535E-015F);
      ((Path)localObject2).lineTo(2.0F, -2.664535E-015F);
      ((Path)localObject2).cubicTo(2.552285F, -2.664535E-015F, 3.0F, 0.4477152F, 3.0F, 1.0F);
      ((Path)localObject2).lineTo(3.0F, 21.0F);
      ((Path)localObject2).cubicTo(3.0F, 21.552284F, 2.552285F, 22.0F, 2.0F, 22.0F);
      ((Path)localObject2).lineTo(1.0F, 22.0F);
      ((Path)localObject2).cubicTo(0.4477152F, 22.0F, 0.0F, 21.552284F, 0.0F, 21.0F);
      ((Path)localObject2).lineTo(0.0F, 1.0F);
      ((Path)localObject2).close();
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.save();
      localObject1 = c.instancePaint(localPaint2, paramVarArgs);
      localObject2 = c.instancePath(paramVarArgs);
      ((Path)localObject2).moveTo(11.998957F, -1.776357E-015F);
      ((Path)localObject2).cubicTo(11.447248F, -1.776357E-015F, 11.0F, 0.4394583F, 11.0F, 1.002462F);
      ((Path)localObject2).lineTo(11.0F, 20.997538F);
      ((Path)localObject2).cubicTo(11.0F, 21.551182F, 11.44266F, 22.0F, 11.998957F, 22.0F);
      ((Path)localObject2).lineTo(13.001043F, 22.0F);
      ((Path)localObject2).cubicTo(13.552752F, 22.0F, 14.0F, 21.560541F, 14.0F, 20.997538F);
      ((Path)localObject2).lineTo(14.0F, 1.002462F);
      ((Path)localObject2).cubicTo(14.0F, 0.4488174F, 13.55734F, -1.776357E-015F, 13.001043F, -1.776357E-015F);
      ((Path)localObject2).lineTo(11.998957F, -1.776357E-015F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 2);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.restore();
      localCanvas.save();
      localPaint1 = c.instancePaint(localPaint1, paramVarArgs);
      localPaint1.setColor(-1);
      localObject1 = c.instancePath(paramVarArgs);
      ((Path)localObject1).moveTo(0.0F, 7.0F);
      ((Path)localObject1).cubicTo(0.0F, 6.447715F, 0.4477152F, 6.0F, 1.0F, 6.0F);
      ((Path)localObject1).lineTo(47.0F, 6.0F);
      ((Path)localObject1).cubicTo(47.552284F, 6.0F, 48.0F, 6.447715F, 48.0F, 7.0F);
      ((Path)localObject1).lineTo(48.0F, 8.0F);
      ((Path)localObject1).cubicTo(48.0F, 8.552285F, 47.552284F, 9.0F, 47.0F, 9.0F);
      ((Path)localObject1).lineTo(1.0F, 9.0F);
      ((Path)localObject1).cubicTo(0.4477152F, 9.0F, 0.0F, 8.552285F, 0.0F, 8.0F);
      ((Path)localObject1).lineTo(0.0F, 7.0F);
      ((Path)localObject1).close();
      localCanvas.drawPath((Path)localObject1, localPaint1);
      localCanvas.restore();
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.sns_img_delete
 * JD-Core Version:    0.7.0.1
 */