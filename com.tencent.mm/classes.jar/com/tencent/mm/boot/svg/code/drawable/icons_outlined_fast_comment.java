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

public class icons_outlined_fast_comment
  extends c
{
  private final int height = 25;
  private final int width = 25;
  
  public int doCommand(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 25;
      return 25;
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
      localObject2 = c.setMatrixFloatArray((float[])localObject2, 1.0F, 0.0F, 0.467348F, 0.0F, 1.0F, 0.595203F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject2);
      localCanvas.concat((Matrix)localObject1);
      localObject1 = c.instancePaint(localPaint1, paramVarArgs);
      ((Paint)localObject1).setColor(-436207616);
      localCanvas.save();
      localObject1 = c.instancePaint((Paint)localObject1, paramVarArgs);
      localObject2 = c.instancePath(paramVarArgs);
      ((Path)localObject2).moveTo(10.502944F, 17.799999F);
      ((Path)localObject2).lineTo(20.5F, 17.799999F);
      ((Path)localObject2).cubicTo(20.665686F, 17.799999F, 20.799999F, 17.665686F, 20.799999F, 17.5F);
      ((Path)localObject2).lineTo(20.799999F, 5.5F);
      ((Path)localObject2).cubicTo(20.799999F, 5.334314F, 20.665686F, 5.2F, 20.5F, 5.2F);
      ((Path)localObject2).lineTo(3.5F, 5.2F);
      ((Path)localObject2).cubicTo(3.334315F, 5.2F, 3.2F, 5.334314F, 3.2F, 5.5F);
      ((Path)localObject2).lineTo(3.2F, 17.5F);
      ((Path)localObject2).cubicTo(3.2F, 17.665686F, 3.334315F, 17.799999F, 3.5F, 17.799999F);
      ((Path)localObject2).lineTo(8.2F, 17.799999F);
      ((Path)localObject2).lineTo(8.2F, 20.102943F);
      ((Path)localObject2).lineTo(10.502944F, 17.799999F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(11.0F, 19.0F);
      ((Path)localObject2).lineTo(8.707107F, 21.292892F);
      ((Path)localObject2).cubicTo(8.316583F, 21.683418F, 7.683417F, 21.683418F, 7.292893F, 21.292892F);
      ((Path)localObject2).cubicTo(7.105357F, 21.105356F, 7.0F, 20.851004F, 7.0F, 20.585787F);
      ((Path)localObject2).lineTo(7.0F, 19.0F);
      ((Path)localObject2).lineTo(3.5F, 19.0F);
      ((Path)localObject2).cubicTo(2.671573F, 19.0F, 2.0F, 18.328426F, 2.0F, 17.5F);
      ((Path)localObject2).lineTo(2.0F, 5.5F);
      ((Path)localObject2).cubicTo(2.0F, 4.671573F, 2.671573F, 4.0F, 3.5F, 4.0F);
      ((Path)localObject2).lineTo(20.5F, 4.0F);
      ((Path)localObject2).cubicTo(21.328426F, 4.0F, 22.0F, 4.671573F, 22.0F, 5.5F);
      ((Path)localObject2).lineTo(22.0F, 17.5F);
      ((Path)localObject2).cubicTo(22.0F, 18.328426F, 21.328426F, 19.0F, 20.5F, 19.0F);
      ((Path)localObject2).lineTo(11.0F, 19.0F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 2);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.save();
      localObject1 = c.instancePaint(localPaint1, paramVarArgs);
      ((Paint)localObject1).setColor(-15198184);
      localObject2 = c.instancePath(paramVarArgs);
      ((Path)localObject2).moveTo(6.0F, 8.082094F);
      ((Path)localObject2).lineTo(18.0F, 8.082094F);
      ((Path)localObject2).lineTo(18.0F, 9.282094F);
      ((Path)localObject2).lineTo(6.0F, 9.282094F);
      ((Path)localObject2).lineTo(6.0F, 8.082094F);
      ((Path)localObject2).close();
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.save();
      localPaint1 = c.instancePaint(localPaint1, paramVarArgs);
      localPaint1.setColor(-15198184);
      localObject1 = c.instancePath(paramVarArgs);
      ((Path)localObject1).moveTo(6.0F, 11.038452F);
      ((Path)localObject1).lineTo(14.007202F, 11.038452F);
      ((Path)localObject1).lineTo(14.007202F, 12.238452F);
      ((Path)localObject1).lineTo(6.0F, 12.238452F);
      ((Path)localObject1).lineTo(6.0F, 11.038452F);
      ((Path)localObject1).close();
      localCanvas.drawPath((Path)localObject1, localPaint1);
      localCanvas.restore();
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.icons_outlined_fast_comment
 * JD-Core Version:    0.7.0.1
 */