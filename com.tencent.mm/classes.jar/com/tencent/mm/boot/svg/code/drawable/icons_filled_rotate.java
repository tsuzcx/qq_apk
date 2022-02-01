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

public class icons_filled_rotate
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
      localPaint1 = c.instancePaint(localPaint1, paramVarArgs);
      localPaint1.setColor(-436207616);
      localCanvas.save();
      localPaint2 = c.instancePaint(localPaint1, paramVarArgs);
      Path localPath = c.instancePath(paramVarArgs);
      localPath.moveTo(12.0F, 33.0F);
      localPath.lineTo(42.0F, 33.0F);
      localPath.cubicTo(43.656853F, 33.0F, 45.0F, 34.343147F, 45.0F, 36.0F);
      localPath.lineTo(45.0F, 60.0F);
      localPath.cubicTo(45.0F, 61.656853F, 43.656853F, 63.0F, 42.0F, 63.0F);
      localPath.lineTo(12.0F, 63.0F);
      localPath.cubicTo(10.343145F, 63.0F, 9.0F, 61.656853F, 9.0F, 60.0F);
      localPath.lineTo(9.0F, 36.0F);
      localPath.cubicTo(9.0F, 34.343147F, 10.343145F, 33.0F, 12.0F, 33.0F);
      localPath.close();
      localPath.moveTo(15.0F, 39.0F);
      localPath.lineTo(15.0F, 57.0F);
      localPath.lineTo(39.0F, 57.0F);
      localPath.lineTo(39.0F, 39.0F);
      localPath.lineTo(15.0F, 39.0F);
      localPath.close();
      WeChatSVGRenderC2Java.setFillType(localPath, 1);
      localCanvas.drawPath(localPath, localPaint2);
      localCanvas.restore();
      localCanvas.save();
      localPaint1 = c.instancePaint(localPaint1, paramVarArgs);
      arrayOfFloat = c.setMatrixFloatArray(arrayOfFloat, -1.0F, 0.0F, 96.834526F, 0.0F, 1.0F, 0.0F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject).reset();
      ((Matrix)localObject).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject);
      localObject = c.instancePath(paramVarArgs);
      ((Path)localObject).moveTo(33.0F, 36.0F);
      ((Path)localObject).cubicTo(33.0F, 24.234737F, 41.465797F, 14.446767F, 52.638058F, 12.395418F);
      ((Path)localObject).lineTo(52.638058F, 12.395418F);
      ((Path)localObject).lineTo(47.485283F, 7.242641F);
      ((Path)localObject).lineTo(51.727921F, 3.0F);
      ((Path)localObject).lineTo(63.395184F, 14.667262F);
      ((Path)localObject).cubicTo(63.980972F, 15.253048F, 63.980972F, 16.202795F, 63.395184F, 16.788582F);
      ((Path)localObject).lineTo(51.727921F, 28.455845F);
      ((Path)localObject).lineTo(47.485283F, 24.213203F);
      ((Path)localObject).lineTo(53.322514F, 18.375973F);
      ((Path)localObject).cubicTo(45.145084F, 20.073561F, 39.0F, 27.319149F, 39.0F, 36.0F);
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 2);
      localCanvas.drawPath((Path)localObject, localPaint1);
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.icons_filled_rotate
 * JD-Core Version:    0.7.0.1
 */