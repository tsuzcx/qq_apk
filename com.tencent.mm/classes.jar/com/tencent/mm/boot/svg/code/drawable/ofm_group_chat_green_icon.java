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

public class ofm_group_chat_green_icon
  extends c
{
  private final int height = 96;
  private final int width = 96;
  
  public int doCommand(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 96;
      return 96;
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
      localPaint1.setColor(-12206054);
      localObject2 = c.setMatrixFloatArray((float[])localObject2, 1.0F, 0.0F, 17.0F, 0.0F, 1.0F, 20.0F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject2);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject1 = c.instancePaint(localPaint1, paramVarArgs);
      localObject2 = c.instancePath(paramVarArgs);
      ((Path)localObject2).moveTo(30.9995F, 0.0F);
      ((Path)localObject2).cubicTo(13.878777F, 0.0F, 0.0F, 11.798211F, 0.0F, 26.35247F);
      ((Path)localObject2).cubicTo(0.0F, 33.188591F, 3.061951F, 39.415703F, 8.08287F, 44.098789F);
      ((Path)localObject2).cubicTo(6.80389F, 48.17186F, 4.427928F, 56.0F, 4.427928F, 56.0F);
      ((Path)localObject2).lineTo(17.250721F, 49.972893F);
      ((Path)localObject2).cubicTo(21.394655F, 51.719925F, 26.060579F, 52.70594F, 31.0005F, 52.70594F);
      ((Path)localObject2).cubicTo(48.121223F, 52.70594F, 62.0F, 40.90773F, 62.0F, 26.351471F);
      ((Path)localObject2).cubicTo(61.999001F, 11.798211F, 48.120224F, 0.0F, 30.9995F, 0.0F);
      ((Path)localObject2).lineTo(30.9995F, 0.0F);
      ((Path)localObject2).lineTo(30.9995F, 0.0F);
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
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.ofm_group_chat_green_icon
 * JD-Core Version:    0.7.0.1
 */