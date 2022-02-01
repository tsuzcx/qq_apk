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

public class c2c_transfer_icon
  extends c
{
  private final int height = 102;
  private final int width = 102;
  
  public int doCommand(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 102;
      return 102;
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
      localPaint1.setColor(-1);
      localCanvas.save();
      localPaint2 = c.instancePaint(localPaint1, paramVarArgs);
      Path localPath = c.instancePath(paramVarArgs);
      localPath.moveTo(51.0F, 102.0F);
      localPath.cubicTo(79.166519F, 102.0F, 102.0F, 79.166519F, 102.0F, 51.0F);
      localPath.cubicTo(102.0F, 22.833477F, 79.166519F, 0.0F, 51.0F, 0.0F);
      localPath.cubicTo(22.833477F, 0.0F, 0.0F, 22.833477F, 0.0F, 51.0F);
      localPath.cubicTo(0.0F, 79.166519F, 22.833477F, 102.0F, 51.0F, 102.0F);
      localPath.close();
      localPath.moveTo(51.0F, 98.0F);
      localPath.cubicTo(76.957382F, 98.0F, 98.0F, 76.957382F, 98.0F, 51.0F);
      localPath.cubicTo(98.0F, 25.042616F, 76.957382F, 4.0F, 51.0F, 4.0F);
      localPath.cubicTo(25.042616F, 4.0F, 4.0F, 25.042616F, 4.0F, 51.0F);
      localPath.cubicTo(4.0F, 76.957382F, 25.042616F, 98.0F, 51.0F, 98.0F);
      localPath.close();
      WeChatSVGRenderC2Java.setFillType(localPath, 2);
      localCanvas.drawPath(localPath, localPaint2);
      localCanvas.restore();
      localCanvas.save();
      localObject2 = c.setMatrixFloatArray((float[])localObject2, 1.0F, 0.0F, 15.0F, 0.0F, 1.0F, 14.0F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject2);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject1 = c.instancePaint(localPaint1, paramVarArgs);
      localObject2 = c.instancePath(paramVarArgs);
      ((Path)localObject2).moveTo(39.525219F, 40.287331F);
      ((Path)localObject2).lineTo(9.866667F, 40.287331F);
      ((Path)localObject2).lineTo(9.866667F, 44.853653F);
      ((Path)localObject2).cubicTo(9.866667F, 45.975304F, 10.76179F, 46.861992F, 11.865981F, 46.861992F);
      ((Path)localObject2).lineTo(37.883682F, 46.861992F);
      ((Path)localObject2).lineTo(36.885212F, 57.796623F);
      ((Path)localObject2).cubicTo(36.735928F, 59.431519F, 37.682396F, 59.961784F, 39.00135F, 58.957611F);
      ((Path)localObject2).lineTo(58.255604F, 44.29855F);
      ((Path)localObject2).cubicTo(61.15963F, 42.087593F, 60.55669F, 40.287331F, 56.896053F, 40.287331F);
      ((Path)localObject2).lineTo(39.525219F, 40.287331F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(32.008507F, 33.712669F);
      ((Path)localObject2).lineTo(61.996948F, 33.712669F);
      ((Path)localObject2).lineTo(61.996948F, 29.146349F);
      ((Path)localObject2).cubicTo(61.996948F, 28.024696F, 61.104416F, 27.138008F, 60.003418F, 27.138008F);
      ((Path)localObject2).lineTo(33.649654F, 27.138008F);
      ((Path)localObject2).lineTo(34.648121F, 16.203377F);
      ((Path)localObject2).cubicTo(34.797405F, 14.56848F, 33.850937F, 14.038217F, 32.531982F, 15.04239F);
      ((Path)localObject2).lineTo(13.277731F, 29.701452F);
      ((Path)localObject2).cubicTo(10.373704F, 31.912409F, 10.976645F, 33.712669F, 14.637279F, 33.712669F);
      ((Path)localObject2).lineTo(32.008507F, 33.712669F);
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
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.c2c_transfer_icon
 * JD-Core Version:    0.7.0.1
 */