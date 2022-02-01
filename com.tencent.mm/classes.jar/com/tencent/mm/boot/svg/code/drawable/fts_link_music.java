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

public class fts_link_music
  extends c
{
  private final int height = 40;
  private final int width = 40;
  
  public int doCommand(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 40;
      return 40;
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
      localPaint1.setColor(-6710887);
      localObject2 = c.setMatrixFloatArray((float[])localObject2, 1.0F, 0.0F, 1.0F, 0.0F, 1.0F, 1.0F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject2);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject1 = c.instancePaint(localPaint1, paramVarArgs);
      localObject2 = c.instancePath(paramVarArgs);
      ((Path)localObject2).moveTo(10.040016F, 6.321322F);
      ((Path)localObject2).cubicTo(18.930199F, 4.424416F, 27.83037F, 2.587411F, 36.780487F, 1.0F);
      ((Path)localObject2).cubicTo(37.170055F, 9.995331F, 36.92033F, 19.020613F, 36.930321F, 28.025927F);
      ((Path)localObject2).cubicTo(36.830429F, 33.047737F, 29.958019F, 34.515343F, 26.801506F, 31.31057F);
      ((Path)localObject2).cubicTo(25.263205F, 29.473566F, 25.962433F, 26.388596F, 27.980204F, 25.200533F);
      ((Path)localObject2).cubicTo(30.037931F, 23.812798F, 32.625076F, 24.072374F, 34.972481F, 23.962553F);
      ((Path)localObject2).lineTo(34.972481F, 7.239824F);
      ((Path)localObject2).cubicTo(27.310944F, 8.767333F, 19.659393F, 10.304826F, 11.997854F, 11.832335F);
      ((Path)localObject2).cubicTo(11.897964F, 19.180351F, 12.187645F, 26.528368F, 11.867998F, 33.866402F);
      ((Path)localObject2).cubicTo(11.06888F, 39.277576F, 1.319647F, 39.477253F, 1.0F, 33.866402F);
      ((Path)localObject2).cubicTo(1.079912F, 29.293858F, 6.5239F, 28.73477F, 10.000061F, 28.954412F);
      ((Path)localObject2).cubicTo(10.020039F, 21.406721F, 9.960105F, 13.85903F, 10.040016F, 6.321322F);
      ((Path)localObject2).lineTo(10.040016F, 6.321322F);
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
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.fts_link_music
 * JD-Core Version:    0.7.0.1
 */