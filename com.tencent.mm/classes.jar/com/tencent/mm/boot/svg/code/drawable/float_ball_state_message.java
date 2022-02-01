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

public class float_ball_state_message
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
      localPaint1 = c.instancePaint(localPaint1, paramVarArgs);
      localPaint1.setColor(-16268960);
      localCanvas.save();
      localObject2 = c.setMatrixFloatArray((float[])localObject2, 1.0F, 0.0F, 5.0F, 0.0F, 1.0F, 5.0F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject2);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject1 = c.instancePaint(localPaint1, paramVarArgs);
      localObject2 = c.instancePath(paramVarArgs);
      ((Path)localObject2).moveTo(39.583332F, 4.166667F);
      ((Path)localObject2).cubicTo(40.733925F, 4.166667F, 41.666668F, 5.099407F, 41.666668F, 6.25F);
      ((Path)localObject2).lineTo(41.666668F, 6.25F);
      ((Path)localObject2).lineTo(41.666668F, 43.75F);
      ((Path)localObject2).cubicTo(41.666668F, 44.900593F, 40.733925F, 45.833332F, 39.583332F, 45.833332F);
      ((Path)localObject2).lineTo(39.583332F, 45.833332F);
      ((Path)localObject2).lineTo(10.416667F, 45.833332F);
      ((Path)localObject2).cubicTo(9.266073F, 45.833332F, 8.333333F, 44.900593F, 8.333333F, 43.75F);
      ((Path)localObject2).lineTo(8.333333F, 43.75F);
      ((Path)localObject2).lineTo(8.333333F, 6.25F);
      ((Path)localObject2).cubicTo(8.333333F, 5.099407F, 9.266073F, 4.166667F, 10.416667F, 4.166667F);
      ((Path)localObject2).lineTo(10.416667F, 4.166667F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(22.916666F, 33.333332F);
      ((Path)localObject2).lineTo(14.583333F, 33.333332F);
      ((Path)localObject2).lineTo(14.583333F, 36.458332F);
      ((Path)localObject2).lineTo(22.916666F, 36.458332F);
      ((Path)localObject2).lineTo(22.916666F, 33.333332F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(22.916666F, 27.083334F);
      ((Path)localObject2).lineTo(14.583333F, 27.083334F);
      ((Path)localObject2).lineTo(14.583333F, 30.208334F);
      ((Path)localObject2).lineTo(22.916666F, 30.208334F);
      ((Path)localObject2).lineTo(22.916666F, 27.083334F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(30.208334F, 20.833334F);
      ((Path)localObject2).lineTo(14.583333F, 20.833334F);
      ((Path)localObject2).lineTo(14.583333F, 23.958334F);
      ((Path)localObject2).lineTo(30.208334F, 23.958334F);
      ((Path)localObject2).lineTo(30.208334F, 20.833334F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(17.708334F, 10.416667F);
      ((Path)localObject2).cubicTo(15.982444F, 10.416667F, 14.583333F, 11.815777F, 14.583333F, 13.541667F);
      ((Path)localObject2).cubicTo(14.583333F, 15.267556F, 15.982444F, 16.666666F, 17.708334F, 16.666666F);
      ((Path)localObject2).cubicTo(19.434223F, 16.666666F, 20.833334F, 15.267556F, 20.833334F, 13.541667F);
      ((Path)localObject2).cubicTo(20.833334F, 11.815777F, 19.434223F, 10.416667F, 17.708334F, 10.416667F);
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
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.float_ball_state_message
 * JD-Core Version:    0.7.0.1
 */