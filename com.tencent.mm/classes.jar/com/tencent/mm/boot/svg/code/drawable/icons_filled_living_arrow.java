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

public class icons_filled_living_arrow
  extends c
{
  private final int height = 72;
  private final int width = 72;
  
  public int doCommand(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 72;
      return 72;
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
      localPaint1.setColor(-436207616);
      localObject2 = c.setMatrixFloatArray((float[])localObject2, 1.0F, 0.0F, 9.62132F, 0.0F, 1.0F, 19.029436F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject2);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject1 = c.instancePaint(localPaint1, paramVarArgs);
      localObject2 = c.instancePath(paramVarArgs);
      ((Path)localObject2).moveTo(16.349243F, 1.421086E-014F);
      ((Path)localObject2).lineTo(20.591883F, 4.242641F);
      ((Path)localObject2).lineTo(7.864F, 16.969999F);
      ((Path)localObject2).lineTo(20.591883F, 29.698484F);
      ((Path)localObject2).lineTo(16.349243F, 33.941124F);
      ((Path)localObject2).lineTo(0.4393398F, 18.031223F);
      ((Path)localObject2).cubicTo(-0.1464466F, 17.445436F, -0.1464466F, 16.495689F, 0.4393398F, 15.909903F);
      ((Path)localObject2).lineTo(3.62132F, 12.727922F);
      ((Path)localObject2).lineTo(16.349243F, 1.421086E-014F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(34.349243F, 1.421086E-014F);
      ((Path)localObject2).lineTo(38.591885F, 4.242641F);
      ((Path)localObject2).lineTo(28.864F, 13.97F);
      ((Path)localObject2).lineTo(53.378681F, 13.970563F);
      ((Path)localObject2).lineTo(53.378681F, 19.970562F);
      ((Path)localObject2).lineTo(28.864F, 19.969999F);
      ((Path)localObject2).lineTo(38.591885F, 29.698484F);
      ((Path)localObject2).lineTo(34.349243F, 33.941124F);
      ((Path)localObject2).lineTo(18.439341F, 18.031223F);
      ((Path)localObject2).cubicTo(17.853554F, 17.445436F, 17.853554F, 16.495689F, 18.439341F, 15.909903F);
      ((Path)localObject2).lineTo(21.621321F, 12.727922F);
      ((Path)localObject2).lineTo(34.349243F, 1.421086E-014F);
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
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.icons_filled_living_arrow
 * JD-Core Version:    0.7.0.1
 */