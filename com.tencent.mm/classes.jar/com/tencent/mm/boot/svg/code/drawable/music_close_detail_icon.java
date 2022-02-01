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

public class music_close_detail_icon
  extends c
{
  private final int height = 120;
  private final int width = 120;
  
  public int doCommand(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 120;
      return 120;
      Canvas localCanvas = (Canvas)paramVarArgs[0];
      paramVarArgs = (Looper)paramVarArgs[1];
      Object localObject = c.instanceMatrix(paramVarArgs);
      float[] arrayOfFloat = c.instanceMatrixArray(paramVarArgs);
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
      localPaint1 = c.instancePaint(localPaint1, paramVarArgs);
      arrayOfFloat = c.setMatrixFloatArray(arrayOfFloat, -0.7071068F, -0.7071068F, 131.87399F, 0.7071068F, -0.7071068F, 32.168152F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject).reset();
      ((Matrix)localObject).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject);
      localObject = c.instancePath(paramVarArgs);
      ((Path)localObject).moveTo(85.835419F, 16.085417F);
      ((Path)localObject).cubicTo(86.106865F, 16.356863F, 86.274757F, 16.731863F, 86.274757F, 17.146076F);
      ((Path)localObject).lineTo(86.274757F, 69.64608F);
      ((Path)localObject).cubicTo(86.274757F, 70.474503F, 85.60318F, 71.14608F, 84.774757F, 71.14608F);
      ((Path)localObject).lineTo(81.774757F, 71.14608F);
      ((Path)localObject).cubicTo(80.946327F, 71.14608F, 80.274757F, 70.474503F, 80.274757F, 69.64608F);
      ((Path)localObject).lineTo(80.274757F, 21.646076F);
      ((Path)localObject).lineTo(33.774757F, 21.646076F);
      ((Path)localObject).cubicTo(32.946331F, 21.646076F, 32.274757F, 20.974504F, 32.274757F, 20.146076F);
      ((Path)localObject).lineTo(32.274757F, 17.146076F);
      ((Path)localObject).cubicTo(32.274757F, 16.31765F, 32.946331F, 15.646077F, 33.774757F, 15.646077F);
      ((Path)localObject).lineTo(84.774757F, 15.646077F);
      ((Path)localObject).cubicTo(85.188972F, 15.646077F, 85.563972F, 15.81397F, 85.835419F, 16.085417F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 2);
      localCanvas.drawPath((Path)localObject, localPaint1);
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.music_close_detail_icon
 * JD-Core Version:    0.7.0.1
 */