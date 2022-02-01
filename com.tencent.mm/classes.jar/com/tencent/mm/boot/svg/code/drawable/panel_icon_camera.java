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

public class panel_icon_camera
  extends c
{
  private final int height = 192;
  private final int width = 192;
  
  public int doCommand(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 192;
      return 192;
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
      localPaint1.setColor(-13421773);
      localObject2 = c.setMatrixFloatArray((float[])localObject2, 1.0F, 0.0F, 48.0F, 0.0F, 1.0F, 48.0F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject2);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject2 = c.setMatrixFloatArray((float[])localObject2, 1.0F, 0.0F, 9.0F, 0.0F, 1.0F, 18.0F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject2);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject1 = c.instancePaint(localPaint1, paramVarArgs);
      localObject2 = c.instancePath(paramVarArgs);
      ((Path)localObject2).moveTo(52.114727F, 1.783564F);
      ((Path)localObject2).lineTo(58.5F, 12.0F);
      ((Path)localObject2).lineTo(73.501823F, 12.0F);
      ((Path)localObject2).cubicTo(75.986603F, 12.0F, 78.0F, 14.012099F, 78.0F, 16.49415F);
      ((Path)localObject2).lineTo(78.0F, 55.505848F);
      ((Path)localObject2).cubicTo(78.0F, 57.98341F, 75.984283F, 60.0F, 73.49778F, 60.0F);
      ((Path)localObject2).lineTo(4.502223F, 60.0F);
      ((Path)localObject2).cubicTo(2.006484F, 60.0F, 0.0F, 57.9879F, 0.0F, 55.505848F);
      ((Path)localObject2).lineTo(0.0F, 16.49415F);
      ((Path)localObject2).cubicTo(0.0F, 14.016589F, 2.013903F, 12.0F, 4.498179F, 12.0F);
      ((Path)localObject2).lineTo(19.5F, 12.0F);
      ((Path)localObject2).lineTo(25.885273F, 1.783564F);
      ((Path)localObject2).cubicTo(26.502096F, 0.7966468F, 27.944145F, 0.0F, 29.108805F, 0.0F);
      ((Path)localObject2).lineTo(48.891193F, 0.0F);
      ((Path)localObject2).cubicTo(50.05917F, 0.0F, 51.499081F, 0.7985287F, 52.114727F, 1.783564F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(39.0F, 51.0F);
      ((Path)localObject2).cubicTo(48.941124F, 51.0F, 57.0F, 42.941124F, 57.0F, 33.0F);
      ((Path)localObject2).cubicTo(57.0F, 23.058874F, 48.941124F, 15.0F, 39.0F, 15.0F);
      ((Path)localObject2).cubicTo(29.058874F, 15.0F, 21.0F, 23.058874F, 21.0F, 33.0F);
      ((Path)localObject2).cubicTo(21.0F, 42.941124F, 29.058874F, 51.0F, 39.0F, 51.0F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(39.0F, 45.0F);
      ((Path)localObject2).cubicTo(32.372581F, 45.0F, 27.0F, 39.627419F, 27.0F, 33.0F);
      ((Path)localObject2).cubicTo(27.0F, 26.372583F, 32.372581F, 21.0F, 39.0F, 21.0F);
      ((Path)localObject2).cubicTo(45.627419F, 21.0F, 51.0F, 26.372583F, 51.0F, 33.0F);
      ((Path)localObject2).cubicTo(51.0F, 39.627419F, 45.627419F, 45.0F, 39.0F, 45.0F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 2);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.restore();
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.panel_icon_camera
 * JD-Core Version:    0.7.0.1
 */