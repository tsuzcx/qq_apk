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

public class icon_filled_endline_night
  extends c
{
  private final int height = 4;
  private final int width = 69;
  
  public int doCommand(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 69;
      return 4;
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
      localPaint1.setColor(-16777216);
      localObject2 = c.setMatrixFloatArray((float[])localObject2, 1.0F, 0.0F, 0.5F, 0.0F, 1.0F, 0.0F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject2);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject1 = c.instancePaint(localPaint1, paramVarArgs);
      localObject2 = c.instancePath(paramVarArgs);
      ((Path)localObject2).moveTo(2.081668E-015F, 1.5F);
      ((Path)localObject2).lineTo(24.0F, 1.5F);
      ((Path)localObject2).lineTo(24.0F, 2.5F);
      ((Path)localObject2).lineTo(2.081668E-015F, 2.5F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 1);
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 2);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.save();
      localObject1 = c.instancePaint(localPaint1, paramVarArgs);
      localObject2 = c.instancePath(paramVarArgs);
      ((Path)localObject2).moveTo(34.0F, 0.0F);
      ((Path)localObject2).cubicTo(35.104568F, 0.0F, 36.0F, 0.8954305F, 36.0F, 2.0F);
      ((Path)localObject2).cubicTo(36.0F, 3.104569F, 35.104568F, 4.0F, 34.0F, 4.0F);
      ((Path)localObject2).cubicTo(33.151451F, 4.0F, 32.426327F, 3.471556F, 32.135773F, 2.72581F);
      ((Path)localObject2).cubicTo(32.380066F, 2.898665F, 32.6782F, 3.0F, 33.0F, 3.0F);
      ((Path)localObject2).cubicTo(33.828426F, 3.0F, 34.5F, 2.328427F, 34.5F, 1.5F);
      ((Path)localObject2).cubicTo(34.5F, 0.8333896F, 34.065163F, 0.268341F, 33.463661F, 0.07303324F);
      ((Path)localObject2).cubicTo(33.633682F, 0.02542525F, 33.813873F, 0.0F, 34.0F, 0.0F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 2);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.save();
      localPaint1 = c.instancePaint(localPaint1, paramVarArgs);
      localObject1 = c.instancePath(paramVarArgs);
      ((Path)localObject1).moveTo(44.0F, 1.5F);
      ((Path)localObject1).lineTo(68.0F, 1.5F);
      ((Path)localObject1).lineTo(68.0F, 2.5F);
      ((Path)localObject1).lineTo(44.0F, 2.5F);
      ((Path)localObject1).lineTo(44.0F, 1.5F);
      ((Path)localObject1).close();
      localCanvas.drawPath((Path)localObject1, localPaint1);
      localCanvas.restore();
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.icon_filled_endline_night
 * JD-Core Version:    0.7.0.1
 */