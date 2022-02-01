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

public class chatting_note_default_img_one
  extends c
{
  private final int height = 135;
  private final int width = 300;
  
  public int doCommand(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 300;
      return 135;
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
      localPaint2.setColor(-921103);
      Path localPath = c.instancePath(paramVarArgs);
      localPath.moveTo(0.0F, 0.0F);
      localPath.lineTo(300.0F, 0.0F);
      localPath.lineTo(300.0F, 136.0F);
      localPath.lineTo(0.0F, 136.0F);
      localPath.lineTo(0.0F, 0.0F);
      localPath.close();
      localCanvas.drawPath(localPath, localPaint2);
      localCanvas.restore();
      localCanvas.save();
      localPaint1 = c.instancePaint(localPaint1, paramVarArgs);
      localPaint1.setColor(-3552823);
      localObject2 = c.setMatrixFloatArray((float[])localObject2, 1.0F, 0.0F, 111.0F, 0.0F, 1.0F, 39.0F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject2);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject1 = c.instancePaint(localPaint1, paramVarArgs);
      localObject2 = c.instancePath(paramVarArgs);
      ((Path)localObject2).moveTo(0.0F, 3.004289F);
      ((Path)localObject2).cubicTo(0.0F, 1.345066F, 1.338046F, 0.0F, 3.000426F, 0.0F);
      ((Path)localObject2).lineTo(75.999573F, 0.0F);
      ((Path)localObject2).cubicTo(77.656662F, 0.0F, 79.0F, 1.352776F, 79.0F, 3.004289F);
      ((Path)localObject2).lineTo(79.0F, 53.995712F);
      ((Path)localObject2).cubicTo(79.0F, 55.654934F, 77.661957F, 57.0F, 75.999573F, 57.0F);
      ((Path)localObject2).lineTo(3.000426F, 57.0F);
      ((Path)localObject2).cubicTo(1.343337F, 57.0F, 0.0F, 55.647224F, 0.0F, 53.995712F);
      ((Path)localObject2).lineTo(0.0F, 3.004289F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(4.0F, 4.0F);
      ((Path)localObject2).lineTo(75.0F, 4.0F);
      ((Path)localObject2).lineTo(75.0F, 53.0F);
      ((Path)localObject2).lineTo(4.0F, 53.0F);
      ((Path)localObject2).lineTo(4.0F, 4.0F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 2);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.save();
      localObject1 = c.instancePaint(localPaint1, paramVarArgs);
      localObject2 = c.instancePath(paramVarArgs);
      ((Path)localObject2).moveTo(60.921059F, 30.279995F);
      ((Path)localObject2).lineTo(50.039063F, 38.768322F);
      ((Path)localObject2).lineTo(53.859421F, 46.690155F);
      ((Path)localObject2).lineTo(27.177771F, 22.0F);
      ((Path)localObject2).lineTo(2.0F, 45.710293F);
      ((Path)localObject2).lineTo(2.0F, 56.5F);
      ((Path)localObject2).lineTo(77.96154F, 56.5F);
      ((Path)localObject2).lineTo(77.96154F, 45.710293F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 1);
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 2);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.chatting_note_default_img_one
 * JD-Core Version:    0.7.0.1
 */