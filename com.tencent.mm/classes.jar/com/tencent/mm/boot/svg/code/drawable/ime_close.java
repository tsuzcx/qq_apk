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

public class ime_close
  extends c
{
  private final int height = 30;
  private final int width = 30;
  
  public int doCommand(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 30;
      return 30;
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
      localPaint1.setColor(-13158600);
      localObject2 = c.setMatrixFloatArray((float[])localObject2, 1.0F, 0.0F, -692.0F, 0.0F, 1.0F, -988.0F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject2);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject2 = c.setMatrixFloatArray((float[])localObject2, 1.0F, 0.0F, 692.0F, 0.0F, 1.0F, 988.0F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject2);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject1 = c.instancePaint(localPaint1, paramVarArgs);
      localObject2 = c.instancePath(paramVarArgs);
      ((Path)localObject2).moveTo(15.0F, 30.0F);
      ((Path)localObject2).lineTo(15.0F, 30.0F);
      ((Path)localObject2).cubicTo(6.715723F, 30.0F, 0.0F, 23.284275F, 0.0F, 15.0F);
      ((Path)localObject2).cubicTo(0.0F, 15.0F, 0.0F, 15.0F, 0.0F, 15.0F);
      ((Path)localObject2).lineTo(0.0F, 15.0F);
      ((Path)localObject2).cubicTo(0.0F, 6.715723F, 6.715723F, 0.0F, 15.0F, 0.0F);
      ((Path)localObject2).lineTo(15.0F, 0.0F);
      ((Path)localObject2).cubicTo(23.284277F, 0.0F, 30.0F, 6.715723F, 30.0F, 15.0F);
      ((Path)localObject2).lineTo(30.0F, 15.0F);
      ((Path)localObject2).cubicTo(30.0F, 23.284277F, 23.284277F, 30.0F, 15.0F, 30.0F);
      ((Path)localObject2).lineTo(15.0F, 30.0F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(15.000001F, 1.428748F);
      ((Path)localObject2).cubicTo(7.522501F, 1.428748F, 1.428751F, 7.524373F, 1.428751F, 14.999998F);
      ((Path)localObject2).cubicTo(1.428751F, 22.477497F, 7.524376F, 28.571247F, 15.000001F, 28.571247F);
      ((Path)localObject2).cubicTo(22.477501F, 28.571247F, 28.571251F, 22.475622F, 28.571251F, 14.999998F);
      ((Path)localObject2).cubicTo(28.571251F, 7.522498F, 22.475626F, 1.428748F, 15.000001F, 1.428748F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(16.095001F, 14.999998F);
      ((Path)localObject2).lineTo(21.903751F, 9.191248F);
      ((Path)localObject2).cubicTo(22.190626F, 8.904373F, 22.190626F, 8.428123F, 21.903751F, 8.096248F);
      ((Path)localObject2).lineTo(21.856876F, 8.047498F);
      ((Path)localObject2).lineTo(21.856876F, 8.047498F);
      ((Path)localObject2).cubicTo(21.565882F, 7.761865F, 21.099745F, 7.761865F, 20.80875F, 8.047498F);
      ((Path)localObject2).lineTo(15.000001F, 13.904998F);
      ((Path)localObject2).lineTo(9.191251F, 8.096248F);
      ((Path)localObject2).lineTo(9.191251F, 8.096248F);
      ((Path)localObject2).cubicTo(8.900029F, 7.809386F, 8.432473F, 7.809386F, 8.141251F, 8.096248F);
      ((Path)localObject2).lineTo(8.096251F, 8.143123F);
      ((Path)localObject2).cubicTo(7.809376F, 8.428123F, 7.809376F, 8.906248F, 8.096251F, 9.238123F);
      ((Path)localObject2).lineTo(13.905001F, 14.999998F);
      ((Path)localObject2).lineTo(8.096251F, 20.808748F);
      ((Path)localObject2).cubicTo(7.809376F, 21.095623F, 7.809376F, 21.571873F, 8.096251F, 21.903748F);
      ((Path)localObject2).lineTo(8.143126F, 21.952497F);
      ((Path)localObject2).lineTo(8.143126F, 21.952497F);
      ((Path)localObject2).cubicTo(8.434121F, 22.238131F, 8.900257F, 22.238131F, 9.191251F, 21.952497F);
      ((Path)localObject2).lineTo(15.000001F, 16.094997F);
      ((Path)localObject2).lineTo(20.80875F, 21.903748F);
      ((Path)localObject2).lineTo(20.808752F, 21.903748F);
      ((Path)localObject2).cubicTo(21.099972F, 22.190609F, 21.567528F, 22.190609F, 21.858751F, 21.903748F);
      ((Path)localObject2).lineTo(21.903751F, 21.856873F);
      ((Path)localObject2).cubicTo(22.190626F, 21.571873F, 22.190626F, 21.093748F, 21.903751F, 20.761873F);
      ((Path)localObject2).lineTo(16.095001F, 14.999998F);
      ((Path)localObject2).lineTo(16.095001F, 14.999998F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 1);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.restore();
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.ime_close
 * JD-Core Version:    0.7.0.1
 */