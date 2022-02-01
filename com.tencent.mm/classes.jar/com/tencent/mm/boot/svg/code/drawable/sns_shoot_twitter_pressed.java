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

public class sns_shoot_twitter_pressed
  extends c
{
  private final int height = 60;
  private final int width = 60;
  
  public int doCommand(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 60;
      return 60;
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
      localPaint1.setColor(-12799249);
      localObject2 = c.setMatrixFloatArray((float[])localObject2, 1.0F, 0.0F, 12.0F, 0.0F, 1.0F, 5.0F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject2);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject1 = c.instancePaint(localPaint1, paramVarArgs);
      localObject2 = c.instancePath(paramVarArgs);
      ((Path)localObject2).moveTo(1.04F, 5.81F);
      ((Path)localObject2).cubicTo(0.91F, 1.08F, 7.16F, -1.81F, 10.71F, 1.3F);
      ((Path)localObject2).cubicTo(14.01F, 3.84F, 12.8F, 8.42F, 13.0F, 12.0F);
      ((Path)localObject2).cubicTo(18.34F, 12.05F, 23.690001F, 11.9F, 29.040001F, 12.06F);
      ((Path)localObject2).cubicTo(32.599998F, 11.89F, 35.619999F, 15.51F, 34.91F, 18.99F);
      ((Path)localObject2).cubicTo(34.509998F, 21.75F, 31.93F, 24.02F, 29.120001F, 23.950001F);
      ((Path)localObject2).cubicTo(23.75F, 24.1F, 18.379999F, 23.950001F, 13.01F, 24.0F);
      ((Path)localObject2).cubicTo(13.22F, 27.540001F, 11.9F, 32.220001F, 15.35F, 34.619999F);
      ((Path)localObject2).cubicTo(19.65F, 37.310001F, 25.030001F, 34.959999F, 29.6F, 36.599998F);
      ((Path)localObject2).cubicTo(33.23F, 38.189999F, 34.16F, 43.540001F, 31.23F, 46.240002F);
      ((Path)localObject2).cubicTo(28.549999F, 48.93F, 24.42F, 47.740002F, 21.030001F, 48.02F);
      ((Path)localObject2).cubicTo(15.1F, 48.470001F, 8.72F, 46.939999F, 4.53F, 42.5F);
      ((Path)localObject2).cubicTo(1.84F, 39.75F, 0.9F, 35.799999F, 1.0F, 32.049999F);
      ((Path)localObject2).cubicTo(1.03F, 23.299999F, 0.94F, 14.55F, 1.04F, 5.81F);
      ((Path)localObject2).lineTo(1.04F, 5.81F);
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
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.sns_shoot_twitter_pressed
 * JD-Core Version:    0.7.0.1
 */