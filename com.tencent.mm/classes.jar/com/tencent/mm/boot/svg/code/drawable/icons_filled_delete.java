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

public class icons_filled_delete
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
      localPaint1 = c.instancePaint(localPaint1, paramVarArgs);
      localPaint1.setColor(-16777216);
      localCanvas.save();
      localObject2 = c.setMatrixFloatArray((float[])localObject2, 1.0F, 0.0F, 9.0F, 0.0F, 1.0F, 6.0F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject2);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject1 = c.instancePaint(localPaint1, paramVarArgs);
      localObject2 = c.instancePath(paramVarArgs);
      ((Path)localObject2).moveTo(46.235294F, 13.500007F);
      ((Path)localObject2).lineTo(43.832214F, 54.352333F);
      ((Path)localObject2).cubicTo(43.645664F, 57.523708F, 41.019428F, 60.0F, 37.842571F, 60.0F);
      ((Path)localObject2).lineTo(16.157431F, 60.0F);
      ((Path)localObject2).cubicTo(12.980573F, 60.0F, 10.354336F, 57.523708F, 10.167784F, 54.352333F);
      ((Path)localObject2).lineTo(7.764706F, 13.500007F);
      ((Path)localObject2).lineTo(1.5F, 13.500007F);
      ((Path)localObject2).lineTo(1.5F, 10.5F);
      ((Path)localObject2).cubicTo(1.5F, 9.671573F, 2.171573F, 9.0F, 3.0F, 9.0F);
      ((Path)localObject2).lineTo(51.0F, 9.0F);
      ((Path)localObject2).cubicTo(51.828426F, 9.0F, 52.5F, 9.671573F, 52.5F, 10.5F);
      ((Path)localObject2).lineTo(52.5F, 13.500007F);
      ((Path)localObject2).lineTo(46.235294F, 13.500007F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(21.0F, 1.500102F);
      ((Path)localObject2).lineTo(33.0F, 1.500102F);
      ((Path)localObject2).cubicTo(33.828426F, 1.500102F, 34.5F, 2.171675F, 34.5F, 3.000102F);
      ((Path)localObject2).lineTo(34.5F, 6.0F);
      ((Path)localObject2).lineTo(19.5F, 6.0F);
      ((Path)localObject2).lineTo(19.5F, 3.000102F);
      ((Path)localObject2).cubicTo(19.5F, 2.171675F, 20.171574F, 1.500102F, 21.0F, 1.500102F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(18.0F, 20.999945F);
      ((Path)localObject2).lineTo(19.5F, 47.999981F);
      ((Path)localObject2).lineTo(24.0F, 47.999981F);
      ((Path)localObject2).lineTo(22.800001F, 20.999945F);
      ((Path)localObject2).lineTo(18.0F, 20.999945F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(31.5F, 20.999945F);
      ((Path)localObject2).lineTo(30.0F, 47.999981F);
      ((Path)localObject2).lineTo(34.5F, 47.999981F);
      ((Path)localObject2).lineTo(36.0F, 20.999945F);
      ((Path)localObject2).lineTo(31.5F, 20.999945F);
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
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.icons_filled_delete
 * JD-Core Version:    0.7.0.1
 */