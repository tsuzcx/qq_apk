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

public class file_float_ball_icon_numbers
  extends c
{
  private final int height = 48;
  private final int width = 48;
  
  public int doCommand(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 48;
      return 48;
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
      localPaint2.setColor(-14824411);
      Path localPath = c.instancePath(paramVarArgs);
      localPath.moveTo(0.0F, 0.0F);
      localPath.lineTo(48.0F, 0.0F);
      localPath.lineTo(48.0F, 48.0F);
      localPath.lineTo(0.0F, 48.0F);
      localPath.lineTo(0.0F, 0.0F);
      localPath.close();
      localCanvas.drawPath(localPath, localPaint2);
      localCanvas.restore();
      localCanvas.save();
      localPaint1 = c.instancePaint(localPaint1, paramVarArgs);
      localPaint1.setColor(-1);
      localObject2 = c.setMatrixFloatArray((float[])localObject2, 1.0F, 0.0F, 14.0F, 0.0F, 1.0F, 16.0F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject2);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject1 = c.instancePaint(localPaint1, paramVarArgs);
      localObject2 = c.instancePath(paramVarArgs);
      ((Path)localObject2).moveTo(0.0F, 12.5F);
      ((Path)localObject2).cubicTo(0.0F, 12.223858F, 0.2238576F, 12.0F, 0.5F, 12.0F);
      ((Path)localObject2).lineTo(3.5F, 12.0F);
      ((Path)localObject2).cubicTo(3.776142F, 12.0F, 4.0F, 12.223858F, 4.0F, 12.5F);
      ((Path)localObject2).lineTo(4.0F, 14.5F);
      ((Path)localObject2).cubicTo(4.0F, 14.776142F, 3.776142F, 15.0F, 3.5F, 15.0F);
      ((Path)localObject2).lineTo(0.5F, 15.0F);
      ((Path)localObject2).cubicTo(0.2238576F, 15.0F, 0.0F, 14.776142F, 0.0F, 14.5F);
      ((Path)localObject2).lineTo(0.0F, 12.5F);
      ((Path)localObject2).close();
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.save();
      localObject1 = c.instancePaint(localPaint1, paramVarArgs);
      localObject2 = c.instancePath(paramVarArgs);
      ((Path)localObject2).moveTo(5.5F, 8.0F);
      ((Path)localObject2).cubicTo(5.5F, 7.723857F, 5.723857F, 7.5F, 6.0F, 7.5F);
      ((Path)localObject2).lineTo(9.0F, 7.5F);
      ((Path)localObject2).cubicTo(9.276142F, 7.5F, 9.5F, 7.723857F, 9.5F, 8.0F);
      ((Path)localObject2).lineTo(9.5F, 14.5F);
      ((Path)localObject2).cubicTo(9.5F, 14.776142F, 9.276142F, 15.0F, 9.0F, 15.0F);
      ((Path)localObject2).lineTo(6.0F, 15.0F);
      ((Path)localObject2).cubicTo(5.723857F, 15.0F, 5.5F, 14.776142F, 5.5F, 14.5F);
      ((Path)localObject2).lineTo(5.5F, 8.0F);
      ((Path)localObject2).close();
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.save();
      localObject1 = c.instancePaint(localPaint1, paramVarArgs);
      localObject2 = c.instancePath(paramVarArgs);
      ((Path)localObject2).moveTo(11.5F, 0.0F);
      ((Path)localObject2).lineTo(14.5F, 0.0F);
      ((Path)localObject2).cubicTo(14.776142F, -5.072653E-017F, 15.0F, 0.2238576F, 15.0F, 0.5F);
      ((Path)localObject2).lineTo(15.0F, 14.5F);
      ((Path)localObject2).cubicTo(15.0F, 14.776142F, 14.776142F, 15.0F, 14.5F, 15.0F);
      ((Path)localObject2).lineTo(11.5F, 15.0F);
      ((Path)localObject2).cubicTo(11.223858F, 15.0F, 11.0F, 14.776142F, 11.0F, 14.5F);
      ((Path)localObject2).lineTo(11.0F, 0.5F);
      ((Path)localObject2).cubicTo(11.0F, 0.2238576F, 11.223858F, 5.072653E-017F, 11.5F, 0.0F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 2);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.save();
      localObject1 = c.instancePaint(localPaint1, paramVarArgs);
      localObject2 = c.instancePath(paramVarArgs);
      ((Path)localObject2).moveTo(0.0F, 16.5F);
      ((Path)localObject2).cubicTo(0.0F, 16.223858F, 0.2238576F, 16.0F, 0.5F, 16.0F);
      ((Path)localObject2).lineTo(20.5F, 16.0F);
      ((Path)localObject2).cubicTo(20.776142F, 16.0F, 21.0F, 16.223858F, 21.0F, 16.5F);
      ((Path)localObject2).lineTo(21.0F, 16.5F);
      ((Path)localObject2).cubicTo(21.0F, 16.776142F, 20.776142F, 17.0F, 20.5F, 17.0F);
      ((Path)localObject2).lineTo(0.5F, 17.0F);
      ((Path)localObject2).cubicTo(0.2238576F, 17.0F, 0.0F, 16.776142F, 0.0F, 16.5F);
      ((Path)localObject2).lineTo(0.0F, 16.5F);
      ((Path)localObject2).close();
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.save();
      localPaint1 = c.instancePaint(localPaint1, paramVarArgs);
      localObject1 = c.instancePath(paramVarArgs);
      ((Path)localObject1).moveTo(16.5F, 5.0F);
      ((Path)localObject1).cubicTo(16.5F, 4.723857F, 16.723858F, 4.5F, 17.0F, 4.5F);
      ((Path)localObject1).lineTo(20.0F, 4.5F);
      ((Path)localObject1).cubicTo(20.276142F, 4.5F, 20.5F, 4.723857F, 20.5F, 5.0F);
      ((Path)localObject1).lineTo(20.5F, 14.5F);
      ((Path)localObject1).cubicTo(20.5F, 14.776142F, 20.276142F, 15.0F, 20.0F, 15.0F);
      ((Path)localObject1).lineTo(17.0F, 15.0F);
      ((Path)localObject1).cubicTo(16.723858F, 15.0F, 16.5F, 14.776142F, 16.5F, 14.5F);
      ((Path)localObject1).lineTo(16.5F, 5.0F);
      ((Path)localObject1).close();
      localCanvas.drawPath((Path)localObject1, localPaint1);
      localCanvas.restore();
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.file_float_ball_icon_numbers
 * JD-Core Version:    0.7.0.1
 */