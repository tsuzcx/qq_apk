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

public class icons_outlined_lock
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
      localPaint1 = c.instancePaint(localPaint1, paramVarArgs);
      localPaint1.setColor(-436207616);
      localCanvas.save();
      localObject2 = c.setMatrixFloatArray((float[])localObject2, 1.0F, 0.0F, 4.0F, 0.0F, 1.0F, 2.0F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject2);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject1 = c.instancePaint(localPaint1, paramVarArgs);
      localObject2 = c.instancePath(paramVarArgs);
      ((Path)localObject2).moveTo(10.799999F, 7.0F);
      ((Path)localObject2).lineTo(10.799999F, 4.0F);
      ((Path)localObject2).cubicTo(10.799997F, 2.4536F, 9.546394F, 1.199997F, 8.0F, 1.199997F);
      ((Path)localObject2).cubicTo(6.4536F, 1.199997F, 5.199997F, 2.4536F, 5.199997F, 4.0F);
      ((Path)localObject2).lineTo(5.2F, 7.0F);
      ((Path)localObject2).lineTo(10.799999F, 7.0F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(14.8F, 8.2F);
      ((Path)localObject2).lineTo(1.2F, 8.2F);
      ((Path)localObject2).lineTo(1.2F, 18.799999F);
      ((Path)localObject2).lineTo(14.8F, 18.799999F);
      ((Path)localObject2).lineTo(14.8F, 8.2F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(8.0F, 11.0F);
      ((Path)localObject2).cubicTo(8.828427F, 11.0F, 9.5F, 11.671573F, 9.5F, 12.5F);
      ((Path)localObject2).cubicTo(9.5F, 13.115096F, 9.129771F, 13.64372F, 8.599999F, 13.875187F);
      ((Path)localObject2).lineTo(8.599999F, 16.0F);
      ((Path)localObject2).lineTo(7.4F, 16.0F);
      ((Path)localObject2).lineTo(7.4F, 13.875187F);
      ((Path)localObject2).cubicTo(6.870228F, 13.64372F, 6.5F, 13.115095F, 6.5F, 12.5F);
      ((Path)localObject2).cubicTo(6.5F, 11.671573F, 7.171573F, 11.0F, 8.0F, 11.0F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(4.0F, 4.0F);
      ((Path)localObject2).cubicTo(4.0F, 1.790861F, 5.790861F, 0.0F, 8.0F, 0.0F);
      ((Path)localObject2).cubicTo(10.209139F, 0.0F, 12.0F, 1.790861F, 12.0F, 4.0F);
      ((Path)localObject2).lineTo(12.0F, 7.0F);
      ((Path)localObject2).lineTo(14.999128F, 7.0F);
      ((Path)localObject2).cubicTo(15.551894F, 7.0F, 16.0F, 7.447489F, 16.0F, 7.998502F);
      ((Path)localObject2).lineTo(16.0F, 19.001497F);
      ((Path)localObject2).cubicTo(16.0F, 19.552956F, 15.555369F, 20.0F, 14.999128F, 20.0F);
      ((Path)localObject2).lineTo(1.000872F, 20.0F);
      ((Path)localObject2).cubicTo(0.4481055F, 20.0F, 0.0F, 19.552511F, 0.0F, 19.001497F);
      ((Path)localObject2).lineTo(0.0F, 7.998502F);
      ((Path)localObject2).cubicTo(0.0F, 7.447045F, 0.4446309F, 7.0F, 1.000872F, 7.0F);
      ((Path)localObject2).lineTo(4.0F, 7.0F);
      ((Path)localObject2).lineTo(4.0F, 4.0F);
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
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.icons_outlined_lock
 * JD-Core Version:    0.7.0.1
 */