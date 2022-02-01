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

public class icons_outlined_mini_window_new
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
      localPaint1 = c.instancePaint(localPaint1, paramVarArgs);
      localPaint1.setColor(-436207616);
      localObject2 = c.setMatrixFloatArray((float[])localObject2, 1.0F, 0.0F, 3.18F, 0.0F, 1.0F, 3.18F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject2);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject1 = c.instancePaint(localPaint1, paramVarArgs);
      localObject2 = c.instancePath(paramVarArgs);
      ((Path)localObject2).moveTo(6.35267F, 10.29333F);
      ((Path)localObject2).cubicTo(6.904954F, 10.29333F, 7.35267F, 10.741045F, 7.35267F, 11.29333F);
      ((Path)localObject2).lineTo(7.35267F, 16.043329F);
      ((Path)localObject2).lineTo(5.85267F, 16.043329F);
      ((Path)localObject2).lineTo(5.85267F, 12.853835F);
      ((Path)localObject2).lineTo(1.06F, 17.644835F);
      ((Path)localObject2).lineTo(0.0F, 16.584835F);
      ((Path)localObject2).lineTo(4.790669F, 11.793835F);
      ((Path)localObject2).lineTo(1.60267F, 11.79333F);
      ((Path)localObject2).lineTo(1.60267F, 10.29333F);
      ((Path)localObject2).lineTo(6.35267F, 10.29333F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(16.58267F, 0.0F);
      ((Path)localObject2).lineTo(17.64267F, 1.06F);
      ((Path)localObject2).lineTo(12.852F, 5.851F);
      ((Path)localObject2).lineTo(16.040001F, 5.851505F);
      ((Path)localObject2).lineTo(16.040001F, 7.351505F);
      ((Path)localObject2).lineTo(11.29F, 7.351505F);
      ((Path)localObject2).cubicTo(10.737716F, 7.351505F, 10.29F, 6.90379F, 10.29F, 6.351505F);
      ((Path)localObject2).lineTo(10.29F, 1.601505F);
      ((Path)localObject2).lineTo(11.79F, 1.601505F);
      ((Path)localObject2).lineTo(11.79F, 4.791F);
      ((Path)localObject2).lineTo(16.58267F, 0.0F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 2);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.icons_outlined_mini_window_new
 * JD-Core Version:    0.7.0.1
 */