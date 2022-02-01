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

public class qr_code
  extends c
{
  private final int height = 24;
  private final int width = 24;
  
  public int doCommand(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 24;
      return 24;
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
      localPaint1.setColor(-419430401);
      localObject2 = c.setMatrixFloatArray((float[])localObject2, 1.0F, 0.0F, 3.0F, 0.0F, 1.0F, 3.0F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject2);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject1 = c.instancePaint(localPaint1, paramVarArgs);
      localObject2 = c.instancePath(paramVarArgs);
      ((Path)localObject2).moveTo(14.0F, 2.0F);
      ((Path)localObject2).lineTo(14.0F, 4.0F);
      ((Path)localObject2).lineTo(16.0F, 4.0F);
      ((Path)localObject2).lineTo(16.0F, 2.0F);
      ((Path)localObject2).lineTo(14.0F, 2.0F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(8.0F, 16.0F);
      ((Path)localObject2).lineTo(10.0F, 16.0F);
      ((Path)localObject2).lineTo(10.0F, 18.0F);
      ((Path)localObject2).lineTo(8.0F, 18.0F);
      ((Path)localObject2).lineTo(8.0F, 16.0F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(16.0F, 8.0F);
      ((Path)localObject2).lineTo(18.0F, 8.0F);
      ((Path)localObject2).lineTo(18.0F, 10.0F);
      ((Path)localObject2).lineTo(16.0F, 10.0F);
      ((Path)localObject2).lineTo(16.0F, 8.0F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(8.0F, 12.0F);
      ((Path)localObject2).lineTo(10.0F, 12.0F);
      ((Path)localObject2).lineTo(10.0F, 14.0F);
      ((Path)localObject2).lineTo(8.0F, 14.0F);
      ((Path)localObject2).lineTo(8.0F, 12.0F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(12.0F, 8.0F);
      ((Path)localObject2).lineTo(14.0F, 8.0F);
      ((Path)localObject2).lineTo(14.0F, 10.0F);
      ((Path)localObject2).lineTo(12.0F, 10.0F);
      ((Path)localObject2).lineTo(12.0F, 8.0F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(1.0F, 0.0F);
      ((Path)localObject2).lineTo(9.0F, 0.0F);
      ((Path)localObject2).cubicTo(9.552285F, 0.0F, 10.0F, 0.4477153F, 10.0F, 1.0F);
      ((Path)localObject2).lineTo(10.0F, 9.0F);
      ((Path)localObject2).cubicTo(10.0F, 9.552285F, 9.552285F, 10.0F, 9.0F, 10.0F);
      ((Path)localObject2).lineTo(1.0F, 10.0F);
      ((Path)localObject2).cubicTo(0.4477153F, 10.0F, 0.0F, 9.552285F, 0.0F, 9.0F);
      ((Path)localObject2).lineTo(0.0F, 1.0F);
      ((Path)localObject2).cubicTo(0.0F, 0.4477153F, 0.4477153F, 0.0F, 1.0F, 0.0F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(2.0F, 2.0F);
      ((Path)localObject2).lineTo(2.0F, 8.0F);
      ((Path)localObject2).lineTo(8.0F, 8.0F);
      ((Path)localObject2).lineTo(8.0F, 2.0F);
      ((Path)localObject2).lineTo(2.0F, 2.0F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(4.0F, 4.0F);
      ((Path)localObject2).lineTo(6.0F, 4.0F);
      ((Path)localObject2).lineTo(6.0F, 6.0F);
      ((Path)localObject2).lineTo(4.0F, 6.0F);
      ((Path)localObject2).lineTo(4.0F, 4.0F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(13.0F, 0.0F);
      ((Path)localObject2).lineTo(17.0F, 0.0F);
      ((Path)localObject2).cubicTo(17.552284F, 0.0F, 18.0F, 0.4477153F, 18.0F, 1.0F);
      ((Path)localObject2).lineTo(18.0F, 5.0F);
      ((Path)localObject2).cubicTo(18.0F, 5.552285F, 17.552284F, 6.0F, 17.0F, 6.0F);
      ((Path)localObject2).lineTo(13.0F, 6.0F);
      ((Path)localObject2).cubicTo(12.447716F, 6.0F, 12.0F, 5.552285F, 12.0F, 5.0F);
      ((Path)localObject2).lineTo(12.0F, 1.0F);
      ((Path)localObject2).cubicTo(12.0F, 0.4477153F, 12.447716F, 0.0F, 13.0F, 0.0F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(13.0F, 12.0F);
      ((Path)localObject2).lineTo(17.0F, 12.0F);
      ((Path)localObject2).cubicTo(17.552284F, 12.0F, 18.0F, 12.447716F, 18.0F, 13.0F);
      ((Path)localObject2).lineTo(18.0F, 17.0F);
      ((Path)localObject2).cubicTo(18.0F, 17.552284F, 17.552284F, 18.0F, 17.0F, 18.0F);
      ((Path)localObject2).lineTo(13.0F, 18.0F);
      ((Path)localObject2).cubicTo(12.447716F, 18.0F, 12.0F, 17.552284F, 12.0F, 17.0F);
      ((Path)localObject2).lineTo(12.0F, 13.0F);
      ((Path)localObject2).cubicTo(12.0F, 12.447716F, 12.447716F, 12.0F, 13.0F, 12.0F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(14.0F, 14.0F);
      ((Path)localObject2).lineTo(14.0F, 16.0F);
      ((Path)localObject2).lineTo(16.0F, 16.0F);
      ((Path)localObject2).lineTo(16.0F, 14.0F);
      ((Path)localObject2).lineTo(14.0F, 14.0F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(1.0F, 12.0F);
      ((Path)localObject2).lineTo(5.0F, 12.0F);
      ((Path)localObject2).cubicTo(5.552285F, 12.0F, 6.0F, 12.447716F, 6.0F, 13.0F);
      ((Path)localObject2).lineTo(6.0F, 17.0F);
      ((Path)localObject2).cubicTo(6.0F, 17.552284F, 5.552285F, 18.0F, 5.0F, 18.0F);
      ((Path)localObject2).lineTo(1.0F, 18.0F);
      ((Path)localObject2).cubicTo(0.4477153F, 18.0F, 0.0F, 17.552284F, 0.0F, 17.0F);
      ((Path)localObject2).lineTo(0.0F, 13.0F);
      ((Path)localObject2).cubicTo(0.0F, 12.447716F, 0.4477153F, 12.0F, 1.0F, 12.0F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(2.0F, 14.0F);
      ((Path)localObject2).lineTo(2.0F, 16.0F);
      ((Path)localObject2).lineTo(4.0F, 16.0F);
      ((Path)localObject2).lineTo(4.0F, 14.0F);
      ((Path)localObject2).lineTo(2.0F, 14.0F);
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
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.qr_code
 * JD-Core Version:    0.7.0.1
 */