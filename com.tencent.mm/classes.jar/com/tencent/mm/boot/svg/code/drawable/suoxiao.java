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

public class suoxiao
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
      Object localObject = c.instanceMatrix(paramVarArgs);
      float[] arrayOfFloat = c.instanceMatrixArray(paramVarArgs);
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
      localPaint1 = c.instancePaint(localPaint1, paramVarArgs);
      localPaint1.setColor(-855638017);
      arrayOfFloat = c.setMatrixFloatArray(arrayOfFloat, 1.0F, 0.0F, 14.0F, 0.0F, 1.0F, 12.0F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject).reset();
      ((Matrix)localObject).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject);
      localCanvas.save();
      localPaint2 = c.instancePaint(localPaint1, paramVarArgs);
      Path localPath = c.instancePath(paramVarArgs);
      localPath.moveTo(15.25F, 30.75F);
      localPath.lineTo(15.25F, 45.0F);
      localPath.lineTo(10.75F, 45.0F);
      localPath.lineTo(10.749F, 38.431F);
      localPath.lineTo(4.09099F, 45.090992F);
      localPath.lineTo(0.9090098F, 41.909008F);
      localPath.lineTo(7.568F, 35.25F);
      localPath.lineTo(1.0F, 35.25F);
      localPath.lineTo(1.0F, 30.75F);
      localPath.close();
      WeChatSVGRenderC2Java.setFillType(localPath, 1);
      WeChatSVGRenderC2Java.setFillType(localPath, 1);
      localCanvas.drawPath(localPath, localPaint2);
      localCanvas.restore();
      localCanvas.save();
      localPaint2 = c.instancePaint(localPaint1, paramVarArgs);
      arrayOfFloat = c.setMatrixFloatArray(arrayOfFloat, 6.123234E-017F, -1.0F, 16.0F, 1.0F, 6.123234E-017F, -0.1590099F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject).reset();
      ((Matrix)localObject).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject);
      localPath = c.instancePath(paramVarArgs);
      localPath.moveTo(15.25F, 0.75F);
      localPath.lineTo(15.25F, 15.0F);
      localPath.lineTo(10.75F, 15.0F);
      localPath.lineTo(10.75F, 8.43F);
      localPath.lineTo(4.09099F, 15.09099F);
      localPath.lineTo(0.9090098F, 11.90901F);
      localPath.lineTo(7.57F, 5.249F);
      localPath.lineTo(1.0F, 5.25F);
      localPath.lineTo(1.0F, 0.75F);
      localPath.close();
      WeChatSVGRenderC2Java.setFillType(localPath, 1);
      WeChatSVGRenderC2Java.setFillType(localPath, 1);
      localCanvas.drawPath(localPath, localPaint2);
      localCanvas.restore();
      localCanvas.save();
      localPaint2 = c.instancePaint(localPaint1, paramVarArgs);
      arrayOfFloat = c.setMatrixFloatArray(arrayOfFloat, -1.0F, 0.0F, 76.159012F, 0.0F, 1.0F, 0.0F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject).reset();
      ((Matrix)localObject).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject);
      localPath = c.instancePath(paramVarArgs);
      localPath.moveTo(45.25F, 30.75F);
      localPath.lineTo(45.25F, 45.0F);
      localPath.lineTo(40.75F, 45.0F);
      localPath.lineTo(40.75F, 38.43F);
      localPath.lineTo(34.090992F, 45.090992F);
      localPath.lineTo(30.90901F, 41.909008F);
      localPath.lineTo(37.568001F, 35.25F);
      localPath.lineTo(31.0F, 35.25F);
      localPath.lineTo(31.0F, 30.75F);
      localPath.close();
      WeChatSVGRenderC2Java.setFillType(localPath, 1);
      WeChatSVGRenderC2Java.setFillType(localPath, 1);
      localCanvas.drawPath(localPath, localPaint2);
      localCanvas.restore();
      localCanvas.save();
      localPaint1 = c.instancePaint(localPaint1, paramVarArgs);
      arrayOfFloat = c.setMatrixFloatArray(arrayOfFloat, -6.123234E-017F, 1.0F, 30.159012F, 1.0F, 6.123234E-017F, -30.159012F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject).reset();
      ((Matrix)localObject).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject);
      localObject = c.instancePath(paramVarArgs);
      ((Path)localObject).moveTo(45.25F, 0.75F);
      ((Path)localObject).lineTo(45.25F, 15.0F);
      ((Path)localObject).lineTo(40.75F, 15.0F);
      ((Path)localObject).lineTo(40.75F, 8.43F);
      ((Path)localObject).lineTo(34.090992F, 15.09099F);
      ((Path)localObject).lineTo(30.90901F, 11.90901F);
      ((Path)localObject).lineTo(37.57F, 5.249F);
      ((Path)localObject).lineTo(31.0F, 5.25F);
      ((Path)localObject).lineTo(31.0F, 0.75F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 1);
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 1);
      localCanvas.drawPath((Path)localObject, localPaint1);
      localCanvas.restore();
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.suoxiao
 * JD-Core Version:    0.7.0.1
 */