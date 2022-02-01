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

public class icon_history_card_empty
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
      localPaint2 = c.instancePaint(localPaint1, paramVarArgs);
      localPaint2.setColor(-2565928);
      Path localPath = c.instancePath(paramVarArgs);
      localPath.moveTo(0.0F, 0.0F);
      localPath.lineTo(32.0F, 0.0F);
      localPath.lineTo(32.0F, 32.0F);
      localPath.lineTo(0.0F, 32.0F);
      localPath.lineTo(0.0F, 0.0F);
      localPath.close();
      localCanvas.saveLayerAlpha(null, 0, 31);
      localCanvas.drawPath(localPath, c.instancePaint(localPaint2, paramVarArgs));
      localCanvas.restore();
      localCanvas.save();
      localPaint1 = c.instancePaint(localPaint1, paramVarArgs);
      localPaint1.setColor(-436207616);
      localObject2 = c.setMatrixFloatArray((float[])localObject2, 1.0F, 0.0F, 5.333333F, 0.0F, 1.0F, 2.666667F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject2);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject1 = c.instancePaint(localPaint1, paramVarArgs);
      localObject2 = c.instancePath(paramVarArgs);
      ((Path)localObject2).moveTo(20.0F, 0.0F);
      ((Path)localObject2).cubicTo(20.73638F, 0.0F, 21.333334F, 0.5969537F, 21.333334F, 1.333333F);
      ((Path)localObject2).lineTo(21.333334F, 25.333334F);
      ((Path)localObject2).cubicTo(21.333334F, 26.069714F, 20.73638F, 26.666666F, 20.0F, 26.666666F);
      ((Path)localObject2).lineTo(1.333333F, 26.666666F);
      ((Path)localObject2).cubicTo(0.5969537F, 26.666666F, 0.0F, 26.069714F, 0.0F, 25.333334F);
      ((Path)localObject2).lineTo(0.0F, 1.333333F);
      ((Path)localObject2).cubicTo(0.0F, 0.5969537F, 0.5969537F, 0.0F, 1.333333F, 0.0F);
      ((Path)localObject2).lineTo(20.0F, 0.0F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(19.333334F, 2.0F);
      ((Path)localObject2).lineTo(2.0F, 2.0F);
      ((Path)localObject2).lineTo(2.0F, 24.666666F);
      ((Path)localObject2).lineTo(19.333334F, 24.666666F);
      ((Path)localObject2).lineTo(19.333334F, 2.0F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(9.333333F, 14.666667F);
      ((Path)localObject2).lineTo(9.333333F, 16.666666F);
      ((Path)localObject2).lineTo(4.0F, 16.666666F);
      ((Path)localObject2).lineTo(4.0F, 14.666667F);
      ((Path)localObject2).lineTo(9.333333F, 14.666667F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(14.666667F, 10.0F);
      ((Path)localObject2).lineTo(14.666667F, 12.0F);
      ((Path)localObject2).lineTo(4.0F, 12.0F);
      ((Path)localObject2).lineTo(4.0F, 10.0F);
      ((Path)localObject2).lineTo(14.666667F, 10.0F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(14.666667F, 5.333334F);
      ((Path)localObject2).lineTo(14.666667F, 7.333334F);
      ((Path)localObject2).lineTo(4.0F, 7.333334F);
      ((Path)localObject2).lineTo(4.0F, 5.333334F);
      ((Path)localObject2).lineTo(14.666667F, 5.333334F);
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
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.icon_history_card_empty
 * JD-Core Version:    0.7.0.1
 */