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

public class icons_filled_live_err_red
  extends c
{
  private final int height = 64;
  private final int width = 64;
  
  public int doCommand(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 64;
      return 64;
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
      localPaint1.setColor(-372399);
      localCanvas.save();
      localObject2 = c.setMatrixFloatArray((float[])localObject2, 1.0F, 0.0F, 5.333333F, 0.0F, 1.0F, 5.333333F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject2);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject1 = c.instancePaint(localPaint1, paramVarArgs);
      localObject2 = c.instancePath(paramVarArgs);
      ((Path)localObject2).moveTo(26.666666F, 0.0F);
      ((Path)localObject2).cubicTo(41.39426F, 0.0F, 53.333332F, 11.939074F, 53.333332F, 26.666666F);
      ((Path)localObject2).cubicTo(53.333332F, 41.39426F, 41.39426F, 53.333332F, 26.666666F, 53.333332F);
      ((Path)localObject2).cubicTo(11.939074F, 53.333332F, 0.0F, 41.39426F, 0.0F, 26.666666F);
      ((Path)localObject2).cubicTo(0.0F, 11.939074F, 11.939074F, 0.0F, 26.666666F, 0.0F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(26.666666F, 36.72578F);
      ((Path)localObject2).cubicTo(25.416666F, 36.72578F, 24.440104F, 37.682812F, 24.440104F, 38.952343F);
      ((Path)localObject2).cubicTo(24.440104F, 40.202343F, 25.416666F, 41.178905F, 26.666666F, 41.178905F);
      ((Path)localObject2).cubicTo(27.936197F, 41.178905F, 28.893229F, 40.202343F, 28.893229F, 38.952343F);
      ((Path)localObject2).cubicTo(28.893229F, 37.682812F, 27.936197F, 36.72578F, 26.666666F, 36.72578F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(28.424479F, 12.8F);
      ((Path)localObject2).lineTo(24.908854F, 12.8F);
      ((Path)localObject2).lineTo(25.143229F, 31.628126F);
      ((Path)localObject2).lineTo(28.190104F, 31.628126F);
      ((Path)localObject2).lineTo(28.424479F, 12.8F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 1);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.icons_filled_live_err_red
 * JD-Core Version:    0.7.0.1
 */