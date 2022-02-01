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

public class chatting_note_default_img
  extends c
{
  private final int height = 136;
  private final int width = 136;
  
  public int doCommand(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 136;
      return 136;
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
      localPaint2 = c.instancePaint(localPaint2, paramVarArgs);
      localPaint2.setStrokeWidth(1.0F);
      localCanvas.save();
      Paint localPaint3 = c.instancePaint(localPaint1, paramVarArgs);
      localPaint3.setColor(-921103);
      Path localPath = c.instancePath(paramVarArgs);
      localPath.moveTo(0.0F, 0.0F);
      localPath.lineTo(136.0F, 0.0F);
      localPath.lineTo(136.0F, 136.0F);
      localPath.lineTo(0.0F, 136.0F);
      localPath.lineTo(0.0F, 0.0F);
      localPath.close();
      localCanvas.drawPath(localPath, localPaint3);
      localCanvas.restore();
      localCanvas.save();
      localObject2 = c.setMatrixFloatArray((float[])localObject2, 1.0F, 0.0F, 34.0F, 0.0F, 1.0F, 42.0F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject2);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject1 = c.instancePaint(localPaint2, paramVarArgs);
      ((Paint)localObject1).setColor(-3552823);
      ((Paint)localObject1).setStrokeWidth(3.0F);
      localObject2 = c.instancePath(paramVarArgs);
      ((Path)localObject2).moveTo(1.5F, 6.0F);
      ((Path)localObject2).cubicTo(1.5F, 3.514719F, 3.514719F, 1.5F, 6.0F, 1.5F);
      ((Path)localObject2).lineTo(63.0F, 1.5F);
      ((Path)localObject2).cubicTo(65.485283F, 1.5F, 67.5F, 3.514719F, 67.5F, 6.0F);
      ((Path)localObject2).lineTo(67.5F, 47.0F);
      ((Path)localObject2).cubicTo(67.5F, 49.485283F, 65.485283F, 51.5F, 63.0F, 51.5F);
      ((Path)localObject2).lineTo(6.0F, 51.5F);
      ((Path)localObject2).cubicTo(3.514719F, 51.5F, 1.5F, 49.485283F, 1.5F, 47.0F);
      ((Path)localObject2).lineTo(1.5F, 6.0F);
      ((Path)localObject2).close();
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.save();
      localPaint1 = c.instancePaint(localPaint1, paramVarArgs);
      localPaint1.setColor(-3552823);
      localObject1 = c.instancePath(paramVarArgs);
      ((Path)localObject1).moveTo(2.0F, 40.476219F);
      ((Path)localObject1).lineTo(23.9226F, 20.0F);
      ((Path)localObject1).lineTo(48.016544F, 43.06765F);
      ((Path)localObject1).lineTo(44.841949F, 35.311966F);
      ((Path)localObject1).lineTo(54.734417F, 27.538553F);
      ((Path)localObject1).lineTo(68.0F, 40.476219F);
      ((Path)localObject1).lineTo(68.0F, 50.245495F);
      ((Path)localObject1).lineTo(2.0F, 50.245495F);
      ((Path)localObject1).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject1, 1);
      WeChatSVGRenderC2Java.setFillType((Path)localObject1, 2);
      localCanvas.drawPath((Path)localObject1, localPaint1);
      localCanvas.restore();
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.chatting_note_default_img
 * JD-Core Version:    0.7.0.1
 */