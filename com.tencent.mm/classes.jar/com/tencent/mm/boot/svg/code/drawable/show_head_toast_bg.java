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

public class show_head_toast_bg
  extends c
{
  private final int height = 198;
  private final int width = 198;
  
  public int doCommand(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 198;
      return 198;
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
      localPaint1.setColor(-3355444);
      localCanvas.save();
      localPaint1 = c.instancePaint(localPaint1, paramVarArgs);
      arrayOfFloat = c.setMatrixFloatArray(arrayOfFloat, 0.7071068F, 0.7071068F, -41.007141F, -0.7071068F, 0.7071068F, 99.0F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject).reset();
      ((Matrix)localObject).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject);
      localObject = c.instancePath(paramVarArgs);
      ((Path)localObject).moveTo(168.0F, 99.0F);
      ((Path)localObject).lineTo(168.0F, 165.0F);
      ((Path)localObject).cubicTo(168.0F, 166.65686F, 166.65686F, 168.0F, 165.0F, 168.0F);
      ((Path)localObject).lineTo(99.0F, 168.0F);
      ((Path)localObject).cubicTo(60.892353F, 168.0F, 30.0F, 137.10765F, 30.0F, 99.0F);
      ((Path)localObject).cubicTo(30.0F, 60.892353F, 60.892353F, 30.0F, 99.0F, 30.0F);
      ((Path)localObject).cubicTo(137.10765F, 30.0F, 168.0F, 60.892353F, 168.0F, 99.0F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 2);
      localCanvas.drawPath((Path)localObject, localPaint1);
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.show_head_toast_bg
 * JD-Core Version:    0.7.0.1
 */