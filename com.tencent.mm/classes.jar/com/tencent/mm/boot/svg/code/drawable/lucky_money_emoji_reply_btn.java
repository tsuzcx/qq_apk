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

public class lucky_money_emoji_reply_btn
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
      float[] arrayOfFloat = c.instanceMatrixArray(paramVarArgs);
      Object localObject2 = c.instancePaint(paramVarArgs);
      ((Paint)localObject2).setFlags(385);
      ((Paint)localObject2).setStyle(Paint.Style.FILL);
      Paint localPaint = c.instancePaint(paramVarArgs);
      localPaint.setFlags(385);
      localPaint.setStyle(Paint.Style.STROKE);
      ((Paint)localObject2).setColor(-16777216);
      localPaint.setStrokeWidth(1.0F);
      localPaint.setStrokeCap(Paint.Cap.BUTT);
      localPaint.setStrokeJoin(Paint.Join.MITER);
      localPaint.setStrokeMiter(4.0F);
      localPaint.setPathEffect(null);
      c.instancePaint(localPaint, paramVarArgs).setStrokeWidth(1.0F);
      localCanvas.save();
      localObject2 = c.instancePaint((Paint)localObject2, paramVarArgs);
      ((Paint)localObject2).setColor(-3955858);
      arrayOfFloat = c.setMatrixFloatArray(arrayOfFloat, 1.0F, 0.0F, -124.0F, 0.0F, 1.0F, -377.0F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      arrayOfFloat = c.setMatrixFloatArray(arrayOfFloat, 1.0F, 0.0F, 108.0F, 0.0F, 1.0F, 363.0F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      arrayOfFloat = c.setMatrixFloatArray(arrayOfFloat, 1.0F, 0.0F, 16.0F, 0.0F, 1.0F, 14.0F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject1 = c.instancePaint((Paint)localObject2, paramVarArgs);
      localObject2 = c.instancePath(paramVarArgs);
      ((Path)localObject2).moveTo(30.0F, 0.0F);
      ((Path)localObject2).cubicTo(46.568542F, 0.0F, 60.0F, 13.431458F, 60.0F, 30.0F);
      ((Path)localObject2).cubicTo(60.0F, 46.568542F, 46.568542F, 60.0F, 30.0F, 60.0F);
      ((Path)localObject2).cubicTo(13.431458F, 60.0F, 0.0F, 46.568542F, 0.0F, 30.0F);
      ((Path)localObject2).cubicTo(0.0F, 13.431458F, 13.431458F, 0.0F, 30.0F, 0.0F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(30.0F, 3.6F);
      ((Path)localObject2).cubicTo(15.419683F, 3.6F, 3.6F, 15.419683F, 3.6F, 30.0F);
      ((Path)localObject2).cubicTo(3.6F, 44.580318F, 15.419683F, 56.400002F, 30.0F, 56.400002F);
      ((Path)localObject2).cubicTo(44.580318F, 56.400002F, 56.400002F, 44.580318F, 56.400002F, 30.0F);
      ((Path)localObject2).cubicTo(56.400002F, 15.419683F, 44.580318F, 3.6F, 30.0F, 3.6F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(48.0F, 31.5F);
      ((Path)localObject2).cubicTo(48.0F, 41.441124F, 39.941124F, 49.5F, 30.0F, 49.5F);
      ((Path)localObject2).cubicTo(20.058874F, 49.5F, 12.0F, 41.441124F, 12.0F, 31.5F);
      ((Path)localObject2).lineTo(48.0F, 31.5F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(43.946339F, 35.099998F);
      ((Path)localObject2).lineTo(16.053663F, 35.099998F);
      ((Path)localObject2).cubicTo(17.652218F, 41.310818F, 23.290178F, 45.900002F, 30.0F, 45.900002F);
      ((Path)localObject2).cubicTo(36.709824F, 45.900002F, 42.347782F, 41.310818F, 43.946339F, 35.099998F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(19.5F, 16.5F);
      ((Path)localObject2).cubicTo(21.985281F, 16.5F, 24.0F, 18.514719F, 24.0F, 21.0F);
      ((Path)localObject2).cubicTo(24.0F, 23.485281F, 21.985281F, 25.5F, 19.5F, 25.5F);
      ((Path)localObject2).cubicTo(17.014719F, 25.5F, 15.0F, 23.485281F, 15.0F, 21.0F);
      ((Path)localObject2).cubicTo(15.0F, 18.514719F, 17.014719F, 16.5F, 19.5F, 16.5F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(40.5F, 16.5F);
      ((Path)localObject2).cubicTo(42.985283F, 16.5F, 45.0F, 18.514719F, 45.0F, 21.0F);
      ((Path)localObject2).cubicTo(45.0F, 23.485281F, 42.985283F, 25.5F, 40.5F, 25.5F);
      ((Path)localObject2).cubicTo(38.014717F, 25.5F, 36.0F, 23.485281F, 36.0F, 21.0F);
      ((Path)localObject2).cubicTo(36.0F, 18.514719F, 38.014717F, 16.5F, 40.5F, 16.5F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 2);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.restore();
      localCanvas.restore();
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.lucky_money_emoji_reply_btn
 * JD-Core Version:    0.7.0.1
 */