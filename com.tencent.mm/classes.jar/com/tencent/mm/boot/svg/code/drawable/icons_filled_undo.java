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

public class icons_filled_undo
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
      localObject2 = c.setMatrixFloatArray((float[])localObject2, 1.0F, 0.0F, 6.0F, 0.0F, 1.0F, 12.0F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject2);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject1 = c.instancePaint(localPaint1, paramVarArgs);
      localObject2 = c.instancePath(paramVarArgs);
      ((Path)localObject2).moveTo(35.25F, 22.13604F);
      ((Path)localObject2).lineTo(43.477921F, 30.36396F);
      ((Path)localObject2).lineTo(40.29594F, 33.54594F);
      ((Path)localObject2).lineTo(30.75F, 24.0F);
      ((Path)localObject2).lineTo(30.75F, 12.0F);
      ((Path)localObject2).lineTo(35.25F, 12.0F);
      ((Path)localObject2).lineTo(35.25F, 22.13604F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(9.395418F, 19.63806F);
      ((Path)localObject2).cubicTo(11.446767F, 8.465797F, 21.234737F, -5.329071E-015F, 33.0F, -7.105427E-015F);
      ((Path)localObject2).cubicTo(46.254833F, -8.881784E-015F, 57.0F, 10.745166F, 57.0F, 24.0F);
      ((Path)localObject2).cubicTo(57.0F, 37.254833F, 46.254833F, 48.0F, 33.0F, 48.0F);
      ((Path)localObject2).cubicTo(26.372583F, 48.0F, 20.372583F, 45.313709F, 16.029438F, 40.970562F);
      ((Path)localObject2).lineTo(20.272078F, 36.727921F);
      ((Path)localObject2).cubicTo(23.629839F, 40.085682F, 28.155792F, 42.0F, 33.0F, 42.0F);
      ((Path)localObject2).cubicTo(42.941124F, 42.0F, 51.0F, 33.941124F, 51.0F, 24.0F);
      ((Path)localObject2).cubicTo(51.0F, 14.058874F, 42.941124F, 6.0F, 33.0F, 6.0F);
      ((Path)localObject2).cubicTo(24.319149F, 6.0F, 17.073561F, 12.145084F, 15.375973F, 20.322512F);
      ((Path)localObject2).lineTo(21.213203F, 14.485281F);
      ((Path)localObject2).lineTo(25.455845F, 18.727922F);
      ((Path)localObject2).lineTo(13.788582F, 30.395184F);
      ((Path)localObject2).cubicTo(13.202796F, 30.98097F, 12.253048F, 30.98097F, 11.667262F, 30.395184F);
      ((Path)localObject2).lineTo(6.803447E-013F, 18.727922F);
      ((Path)localObject2).lineTo(4.242641F, 14.485281F);
      ((Path)localObject2).lineTo(9.395418F, 19.63806F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 2);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.icons_filled_undo
 * JD-Core Version:    0.7.0.1
 */