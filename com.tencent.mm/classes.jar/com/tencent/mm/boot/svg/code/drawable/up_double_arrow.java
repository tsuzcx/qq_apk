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

public class up_double_arrow
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
      float[] arrayOfFloat = c.instanceMatrixArray(paramVarArgs);
      Object localObject2 = c.instancePaint(paramVarArgs);
      ((Paint)localObject2).setFlags(385);
      ((Paint)localObject2).setStyle(Paint.Style.FILL);
      Object localObject3 = c.instancePaint(paramVarArgs);
      ((Paint)localObject3).setFlags(385);
      ((Paint)localObject3).setStyle(Paint.Style.STROKE);
      ((Paint)localObject2).setColor(-16777216);
      ((Paint)localObject3).setStrokeWidth(1.0F);
      ((Paint)localObject3).setStrokeCap(Paint.Cap.BUTT);
      ((Paint)localObject3).setStrokeJoin(Paint.Join.MITER);
      ((Paint)localObject3).setStrokeMiter(4.0F);
      ((Paint)localObject3).setPathEffect(null);
      c.instancePaint((Paint)localObject3, paramVarArgs).setStrokeWidth(1.0F);
      localObject3 = c.instancePath(paramVarArgs);
      ((Path)localObject3).moveTo(0.0F, 0.0F);
      ((Path)localObject3).lineTo(24.0F, 0.0F);
      ((Path)localObject3).lineTo(24.0F, 24.0F);
      ((Path)localObject3).lineTo(0.0F, 24.0F);
      ((Path)localObject3).lineTo(0.0F, 0.0F);
      ((Path)localObject3).close();
      localCanvas.save();
      arrayOfFloat = c.setMatrixFloatArray(arrayOfFloat, 6.123234E-017F, 1.0F, 5.0F, -1.0F, 6.123234E-017F, 12.0F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject3 = c.instancePaint((Paint)localObject2, paramVarArgs);
      ((Paint)localObject3).setColor(-11048043);
      arrayOfFloat = c.setMatrixFloatArray(arrayOfFloat, -1.0F, 1.224647E-016F, 8.041568F, -1.224647E-016F, -1.0F, 14.01054F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject3 = c.instancePaint((Paint)localObject3, paramVarArgs);
      Path localPath = c.instancePath(paramVarArgs);
      localPath.moveTo(7.587509F, 12.429892F);
      localPath.lineTo(6.526849F, 13.490552F);
      localPath.lineTo(0.7479515F, 7.711655F);
      localPath.cubicTo(0.3578262F, 7.321529F, 0.354366F, 6.692472F, 0.7479515F, 6.298886F);
      localPath.lineTo(6.526849F, 0.519989F);
      localPath.lineTo(7.587509F, 1.580649F);
      localPath.lineTo(2.162888F, 7.005271F);
      localPath.lineTo(7.587509F, 12.429892F);
      localPath.close();
      WeChatSVGRenderC2Java.setFillType(localPath, 2);
      localCanvas.drawPath(localPath, (Paint)localObject3);
      localCanvas.restore();
      localCanvas.restore();
      localCanvas.restore();
      localCanvas.save();
      arrayOfFloat = c.setMatrixFloatArray(arrayOfFloat, 6.123234E-017F, 1.0F, 5.0F, -1.0F, 6.123234E-017F, 19.5F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject2 = c.instancePaint((Paint)localObject2, paramVarArgs);
      ((Paint)localObject2).setColor(-11048043);
      arrayOfFloat = c.setMatrixFloatArray(arrayOfFloat, -1.0F, 1.224647E-016F, 8.041568F, -1.224647E-016F, -1.0F, 14.01054F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject1 = c.instancePaint((Paint)localObject2, paramVarArgs);
      localObject2 = c.instancePath(paramVarArgs);
      ((Path)localObject2).moveTo(7.587509F, 12.429892F);
      ((Path)localObject2).lineTo(6.526849F, 13.490552F);
      ((Path)localObject2).lineTo(0.7479515F, 7.711655F);
      ((Path)localObject2).cubicTo(0.3578262F, 7.321529F, 0.354366F, 6.692472F, 0.7479515F, 6.298886F);
      ((Path)localObject2).lineTo(6.526849F, 0.519989F);
      ((Path)localObject2).lineTo(7.587509F, 1.580649F);
      ((Path)localObject2).lineTo(2.162888F, 7.005271F);
      ((Path)localObject2).lineTo(7.587509F, 12.429892F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 2);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.restore();
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.up_double_arrow
 * JD-Core Version:    0.7.0.1
 */