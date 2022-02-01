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

public class icons_filled_pic_error1
  extends c
{
  private final int height = 40;
  private final int width = 40;
  
  public int doCommand(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 40;
      return 40;
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
      localPaint2 = c.instancePaint(localPaint1, paramVarArgs);
      localPaint2.setColor(201326592);
      Path localPath = c.instancePath(paramVarArgs);
      localPath.moveTo(0.0F, 0.0F);
      localPath.lineTo(40.0F, 0.0F);
      localPath.lineTo(40.0F, 40.0F);
      localPath.lineTo(0.0F, 40.0F);
      localPath.lineTo(0.0F, 0.0F);
      localPath.close();
      localCanvas.drawPath(localPath, localPaint2);
      localCanvas.restore();
      localCanvas.save();
      localPaint1 = c.instancePaint(localPaint1, paramVarArgs);
      localPaint1.setColor(419430400);
      localObject2 = c.setMatrixFloatArray((float[])localObject2, 1.0F, 0.0F, 10.0F, 0.0F, 1.0F, 10.0F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject2);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject1 = c.instancePaint(localPaint1, paramVarArgs);
      localObject2 = c.instancePath(paramVarArgs);
      ((Path)localObject2).moveTo(17.50683F, 3.333333F);
      ((Path)localObject2).cubicTo(17.953913F, 3.333333F, 18.333334F, 3.734281F, 18.333334F, 4.228875F);
      ((Path)localObject2).lineTo(18.333334F, 15.771126F);
      ((Path)localObject2).cubicTo(18.333334F, 16.267626F, 17.963295F, 16.666666F, 17.50683F, 16.666666F);
      ((Path)localObject2).lineTo(2.493169F, 16.666666F);
      ((Path)localObject2).cubicTo(2.046088F, 16.666666F, 1.666667F, 16.265718F, 1.666667F, 15.771126F);
      ((Path)localObject2).lineTo(1.666667F, 4.228875F);
      ((Path)localObject2).cubicTo(1.666667F, 3.732374F, 2.036705F, 3.333333F, 2.493169F, 3.333333F);
      ((Path)localObject2).lineTo(17.50683F, 3.333333F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(17.083334F, 4.583334F);
      ((Path)localObject2).lineTo(2.916667F, 4.583334F);
      ((Path)localObject2).lineTo(2.916667F, 11.541333F);
      ((Path)localObject2).lineTo(6.832705F, 8.374382F);
      ((Path)localObject2).cubicTo(7.218166F, 8.062655F, 7.837188F, 8.077773F, 8.208746F, 8.404237F);
      ((Path)localObject2).lineTo(11.939102F, 11.681855F);
      ((Path)localObject2).lineTo(13.840919F, 10.064582F);
      ((Path)localObject2).cubicTo(14.226098F, 9.737031F, 14.838936F, 9.743686F, 15.212859F, 10.079236F);
      ((Path)localObject2).lineTo(17.082666F, 11.779333F);
      ((Path)localObject2).lineTo(17.083334F, 4.583334F);
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
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.icons_filled_pic_error1
 * JD-Core Version:    0.7.0.1
 */