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

public class pc_with_phone
  extends c
{
  private final int height = 160;
  private final int width = 160;
  
  public int doCommand(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 160;
      return 160;
      Canvas localCanvas = (Canvas)paramVarArgs[0];
      paramVarArgs = (Looper)paramVarArgs[1];
      Object localObject2 = c.instanceMatrix(paramVarArgs);
      Object localObject3 = c.instanceMatrixArray(paramVarArgs);
      Paint localPaint1 = c.instancePaint(paramVarArgs);
      localPaint1.setFlags(385);
      localPaint1.setStyle(Paint.Style.FILL);
      Object localObject1 = c.instancePaint(paramVarArgs);
      ((Paint)localObject1).setFlags(385);
      ((Paint)localObject1).setStyle(Paint.Style.STROKE);
      localPaint1.setColor(-16777216);
      ((Paint)localObject1).setStrokeWidth(1.0F);
      ((Paint)localObject1).setStrokeCap(Paint.Cap.BUTT);
      ((Paint)localObject1).setStrokeJoin(Paint.Join.MITER);
      ((Paint)localObject1).setStrokeMiter(4.0F);
      ((Paint)localObject1).setPathEffect(null);
      localObject1 = c.instancePaint((Paint)localObject1, paramVarArgs);
      ((Paint)localObject1).setStrokeWidth(1.0F);
      localCanvas.save();
      Paint localPaint2 = c.instancePaint((Paint)localObject1, paramVarArgs);
      localPaint2.setColor(-16777216);
      localPaint2.setStrokeWidth(0.5F);
      Path localPath = c.instancePath(paramVarArgs);
      localPath.moveTo(30.0F, 58.535645F);
      localPath.lineTo(30.0F, 34.5F);
      localPath.lineTo(150.5F, 34.5F);
      localPath.lineTo(150.5F, 108.83334F);
      localPath.lineTo(44.54248F, 108.83334F);
      WeChatSVGRenderC2Java.setFillType(localPath, 1);
      localCanvas.drawPath(localPath, localPaint2);
      localCanvas.restore();
      localCanvas.save();
      localPaint2 = c.instancePaint((Paint)localObject1, paramVarArgs);
      localPaint2.setColor(-16777216);
      localPath = c.instancePath(paramVarArgs);
      localPath.moveTo(25.25F, 58.181324F);
      localPath.lineTo(25.25F, 34.666668F);
      localPath.cubicTo(25.25F, 32.457527F, 27.040861F, 30.666666F, 29.25F, 30.666666F);
      localPath.lineTo(150.25F, 30.666666F);
      localPath.cubicTo(152.45914F, 30.666666F, 154.25F, 32.457527F, 154.25F, 34.666668F);
      localPath.lineTo(154.25F, 108.66666F);
      localPath.cubicTo(154.25F, 110.87581F, 152.45914F, 112.66666F, 150.25F, 112.66666F);
      localPath.lineTo(44.818298F, 112.66666F);
      localPath.lineTo(44.818298F, 112.66666F);
      localCanvas.drawPath(localPath, localPaint2);
      localCanvas.restore();
      localCanvas.save();
      localPaint2 = c.instancePaint((Paint)localObject1, paramVarArgs);
      localPaint2.setColor(-16777216);
      localPath = c.instancePath(paramVarArgs);
      localPath.moveTo(96.0F, 113.0F);
      localPath.lineTo(96.0F, 124.84717F);
      localPath.lineTo(114.5F, 126.33289F);
      localPath.lineTo(114.5F, 129.33333F);
      localPath.lineTo(65.5F, 129.33333F);
      localPath.lineTo(65.5F, 126.33289F);
      localPath.lineTo(84.0F, 124.84717F);
      localPath.lineTo(84.0F, 113.0F);
      localPath.lineTo(96.0F, 113.0F);
      localPath.close();
      localCanvas.drawPath(localPath, localPaint2);
      localCanvas.restore();
      localCanvas.save();
      localObject3 = c.setMatrixFloatArray((float[])localObject3, 1.0F, 0.0F, 5.0F, 0.0F, 1.0F, 58.0F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject2).reset();
      ((Matrix)localObject2).setValues((float[])localObject3);
      localCanvas.concat((Matrix)localObject2);
      localObject2 = c.instancePath(paramVarArgs);
      ((Path)localObject2).moveTo(0.0F, 1.0F);
      ((Path)localObject2).lineTo(40.0F, 1.0F);
      ((Path)localObject2).lineTo(40.0F, 72.0F);
      ((Path)localObject2).lineTo(0.0F, 72.0F);
      ((Path)localObject2).lineTo(0.0F, 1.0F);
      ((Path)localObject2).close();
      localObject2 = c.instancePath(paramVarArgs);
      ((Path)localObject2).moveTo(0.0F, 0.0F);
      ((Path)localObject2).lineTo(40.0F, 0.0F);
      ((Path)localObject2).lineTo(40.0F, 71.0F);
      ((Path)localObject2).lineTo(0.0F, 71.0F);
      ((Path)localObject2).lineTo(0.0F, 0.0F);
      ((Path)localObject2).close();
      localCanvas.save();
      localObject2 = c.instancePaint((Paint)localObject1, paramVarArgs);
      ((Paint)localObject2).setColor(-16777216);
      ((Paint)localObject2).setStrokeWidth(1.071429F);
      localObject3 = c.instancePath(paramVarArgs);
      ((Path)localObject3).moveTo(0.5357143F, 3.75F);
      ((Path)localObject3).cubicTo(0.5357143F, 1.974799F, 1.974799F, 0.5357143F, 3.75F, 0.5357143F);
      ((Path)localObject3).lineTo(36.249996F, 0.5357143F);
      ((Path)localObject3).cubicTo(38.025196F, 0.5357143F, 39.464283F, 1.974799F, 39.464283F, 3.75F);
      ((Path)localObject3).lineTo(39.464283F, 67.678566F);
      ((Path)localObject3).cubicTo(39.464283F, 69.453766F, 38.025196F, 70.892853F, 36.249996F, 70.892853F);
      ((Path)localObject3).lineTo(3.75F, 70.892853F);
      ((Path)localObject3).cubicTo(1.974799F, 70.892853F, 0.5357143F, 69.453766F, 0.5357143F, 67.678566F);
      ((Path)localObject3).lineTo(0.5357143F, 3.75F);
      ((Path)localObject3).close();
      localCanvas.drawPath((Path)localObject3, (Paint)localObject2);
      localCanvas.restore();
      localCanvas.save();
      localObject1 = c.instancePaint((Paint)localObject1, paramVarArgs);
      ((Paint)localObject1).setColor(-16777216);
      ((Paint)localObject1).setStrokeWidth(0.5357143F);
      localObject2 = c.instancePath(paramVarArgs);
      ((Path)localObject2).moveTo(36.875F, 7.767857F);
      ((Path)localObject2).lineTo(36.875F, 62.232143F);
      ((Path)localObject2).lineTo(3.125F, 62.232143F);
      ((Path)localObject2).lineTo(3.125F, 7.767857F);
      ((Path)localObject2).lineTo(36.875F, 7.767857F);
      ((Path)localObject2).close();
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.save();
      localPaint1 = c.instancePaint(localPaint1, paramVarArgs);
      localPaint1.setColor(-16777216);
      localObject1 = c.instancePath(paramVarArgs);
      ((Path)localObject1).moveTo(17.5F, 3.571429F);
      ((Path)localObject1).lineTo(22.857143F, 3.571429F);
      ((Path)localObject1).lineTo(22.857143F, 4.642857F);
      ((Path)localObject1).lineTo(17.5F, 4.642857F);
      ((Path)localObject1).lineTo(17.5F, 3.571429F);
      ((Path)localObject1).close();
      localCanvas.drawPath((Path)localObject1, localPaint1);
      localCanvas.restore();
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.pc_with_phone
 * JD-Core Version:    0.7.0.1
 */