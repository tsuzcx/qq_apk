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

public class icons_filled_start
  extends c
{
  private final int height = 32;
  private final int width = 32;
  
  public int doCommand(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 32;
      return 32;
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
      localPaint2 = c.instancePaint(localPaint1, paramVarArgs);
      localPaint2.setColor(-16268960);
      Path localPath = c.instancePath(paramVarArgs);
      localPath.moveTo(0.0F, 16.0F);
      localPath.cubicTo(0.0F, 7.163444F, 7.163444F, 0.0F, 16.0F, 0.0F);
      localPath.lineTo(16.0F, 0.0F);
      localPath.cubicTo(24.836555F, 0.0F, 32.0F, 7.163444F, 32.0F, 16.0F);
      localPath.lineTo(32.0F, 16.0F);
      localPath.cubicTo(32.0F, 24.836555F, 24.836555F, 32.0F, 16.0F, 32.0F);
      localPath.lineTo(16.0F, 32.0F);
      localPath.cubicTo(7.163444F, 32.0F, 0.0F, 24.836555F, 0.0F, 16.0F);
      localPath.lineTo(0.0F, 16.0F);
      localPath.close();
      localCanvas.drawPath(localPath, localPaint2);
      localCanvas.restore();
      localCanvas.save();
      localPaint1 = c.instancePaint(localPaint1, paramVarArgs);
      localPaint1.setColor(-1);
      localObject2 = c.setMatrixFloatArray((float[])localObject2, 1.0F, 0.0F, 7.0F, 0.0F, 1.0F, 6.0F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject2);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject1 = c.instancePaint(localPaint1, paramVarArgs);
      localObject2 = c.instancePath(paramVarArgs);
      ((Path)localObject2).moveTo(6.246782F, 4.045781F);
      ((Path)localObject2).lineTo(15.400478F, 9.276465F);
      ((Path)localObject2).cubicTo(15.800076F, 9.504806F, 15.938908F, 10.013851F, 15.710566F, 10.413449F);
      ((Path)localObject2).cubicTo(15.636742F, 10.542642F, 15.529672F, 10.649712F, 15.400478F, 10.723536F);
      ((Path)localObject2).lineTo(6.246782F, 15.95422F);
      ((Path)localObject2).cubicTo(5.847185F, 16.182562F, 5.338139F, 16.04373F, 5.109798F, 15.644133F);
      ((Path)localObject2).cubicTo(5.037846F, 15.518218F, 5.0F, 15.375706F, 5.0F, 15.230683F);
      ((Path)localObject2).lineTo(5.0F, 4.769316F);
      ((Path)localObject2).cubicTo(5.0F, 4.309079F, 5.373096F, 3.935983F, 5.833334F, 3.935983F);
      ((Path)localObject2).cubicTo(5.978356F, 3.935983F, 6.120868F, 3.973829F, 6.246782F, 4.045781F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 2);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.icons_filled_start
 * JD-Core Version:    0.7.0.1
 */