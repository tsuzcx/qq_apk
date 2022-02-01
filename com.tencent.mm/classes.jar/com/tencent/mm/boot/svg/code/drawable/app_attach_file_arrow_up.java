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

public class app_attach_file_arrow_up
  extends c
{
  private final int height = 36;
  private final int width = 36;
  
  public int doCommand(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 36;
      return 36;
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
      arrayOfFloat = c.setMatrixFloatArray(arrayOfFloat, -1.83697E-016F, -1.0F, 33.0F, 1.0F, -1.83697E-016F, -1.0F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject).reset();
      ((Matrix)localObject).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject);
      localObject = c.instancePath(paramVarArgs);
      ((Path)localObject).moveTo(1.0F, 0.0F);
      ((Path)localObject).lineTo(37.0F, 0.0F);
      ((Path)localObject).lineTo(37.0F, 30.0F);
      ((Path)localObject).lineTo(1.0F, 30.0F);
      ((Path)localObject).lineTo(1.0F, 0.0F);
      ((Path)localObject).close();
      localCanvas.save();
      localPaint1 = c.instancePaint(localPaint1, paramVarArgs);
      localPaint1.setColor(-436207616);
      localObject = c.instancePath(paramVarArgs);
      ((Path)localObject).moveTo(11.684951F, 3.75F);
      ((Path)localObject).lineTo(15.354067F, 7.5F);
      ((Path)localObject).lineTo(10.609327F, 12.348F);
      ((Path)localObject).lineTo(21.433258F, 12.34835F);
      ((Path)localObject).lineTo(21.433258F, 17.651649F);
      ((Path)localObject).lineTo(10.610328F, 17.650999F);
      ((Path)localObject).lineTo(15.354067F, 22.5F);
      ((Path)localObject).lineTo(11.684951F, 26.25F);
      ((Path)localObject).lineTo(1.200137F, 15.534054F);
      ((Path)localObject).cubicTo(0.9097244F, 15.237239F, 0.9097244F, 14.762761F, 1.200137F, 14.465946F);
      ((Path)localObject).lineTo(4.346718F, 11.25F);
      ((Path)localObject).lineTo(11.684951F, 3.75F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(29.216629F, 12.34835F);
      ((Path)localObject).lineTo(29.216629F, 17.651649F);
      ((Path)localObject).lineTo(24.027716F, 17.651649F);
      ((Path)localObject).lineTo(24.027716F, 12.34835F);
      ((Path)localObject).lineTo(29.216629F, 12.34835F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(37.0F, 12.34835F);
      ((Path)localObject).lineTo(37.0F, 17.651649F);
      ((Path)localObject).lineTo(31.811087F, 17.651649F);
      ((Path)localObject).lineTo(31.811087F, 12.34835F);
      ((Path)localObject).lineTo(37.0F, 12.34835F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 2);
      localCanvas.drawPath((Path)localObject, localPaint1);
      localCanvas.restore();
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.app_attach_file_arrow_up
 * JD-Core Version:    0.7.0.1
 */