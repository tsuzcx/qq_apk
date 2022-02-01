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

public class finder_live_mirror_icon
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
      localCanvas.saveLayerAlpha(null, 230, 31);
      localPaint1 = c.instancePaint(localPaint1, paramVarArgs);
      localPaint1.setColor(-16777216);
      localCanvas.save();
      localPaint2 = c.instancePaint(localPaint1, paramVarArgs);
      localObject2 = c.setMatrixFloatArray((float[])localObject2, -1.0F, 0.0F, 47.058353F, 0.0F, 1.0F, 0.0F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject2);
      localCanvas.concat((Matrix)localObject1);
      localObject1 = c.instancePath(paramVarArgs);
      ((Path)localObject1).moveTo(29.991686F, 4.666667F);
      ((Path)localObject1).lineTo(29.991686F, 27.333334F);
      ((Path)localObject1).lineTo(18.4F, 27.333334F);
      ((Path)localObject1).cubicTo(17.66362F, 27.333334F, 17.066668F, 26.73638F, 17.066668F, 26.0F);
      ((Path)localObject1).cubicTo(17.066668F, 25.882484F, 17.082203F, 25.765484F, 17.112871F, 25.652039F);
      ((Path)localObject1).lineTo(22.519642F, 5.65204F);
      ((Path)localObject1).cubicTo(22.676844F, 5.070543F, 23.204401F, 4.666667F, 23.806772F, 4.666667F);
      ((Path)localObject1).lineTo(29.991686F, 4.666667F);
      ((Path)localObject1).close();
      ((Path)localObject1).moveTo(29.991064F, 6.8F);
      ((Path)localObject1).lineTo(24.418352F, 6.8F);
      ((Path)localObject1).lineTo(19.443686F, 25.200001F);
      ((Path)localObject1).lineTo(29.991064F, 25.200001F);
      ((Path)localObject1).lineTo(29.991064F, 6.8F);
      ((Path)localObject1).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject1, 1);
      localCanvas.drawPath((Path)localObject1, localPaint2);
      localCanvas.restore();
      localCanvas.save();
      localObject1 = c.instancePaint(localPaint1, paramVarArgs);
      localObject2 = c.instancePath(paramVarArgs);
      ((Path)localObject2).moveTo(14.666667F, 4.666667F);
      ((Path)localObject2).lineTo(14.666667F, 27.333334F);
      ((Path)localObject2).lineTo(3.074981F, 27.333334F);
      ((Path)localObject2).cubicTo(2.338601F, 27.333334F, 1.741648F, 26.73638F, 1.741648F, 26.0F);
      ((Path)localObject2).cubicTo(1.741648F, 25.882484F, 1.757184F, 25.765484F, 1.787852F, 25.652039F);
      ((Path)localObject2).lineTo(7.194624F, 5.65204F);
      ((Path)localObject2).cubicTo(7.351825F, 5.070543F, 7.879383F, 4.666667F, 8.481753F, 4.666667F);
      ((Path)localObject2).lineTo(14.666667F, 4.666667F);
      ((Path)localObject2).lineTo(14.666667F, 4.666667F);
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
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.finder_live_mirror_icon
 * JD-Core Version:    0.7.0.1
 */