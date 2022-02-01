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

public class sight_draft_entrance
  extends c
{
  private final int height = 90;
  private final int width = 90;
  
  public int doCommand(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 90;
      return 90;
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
      localPaint1.setColor(-6052957);
      localObject2 = c.setMatrixFloatArray((float[])localObject2, 1.0F, 0.0F, 10.0F, 0.0F, 1.0F, 18.0F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject2);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject1 = c.instancePaint(localPaint1, paramVarArgs);
      localObject2 = c.instancePath(paramVarArgs);
      ((Path)localObject2).moveTo(0.0F, 3.990053F);
      ((Path)localObject2).cubicTo(0.0F, 1.786408F, 1.789028F, 0.0F, 4.004258F, 0.0F);
      ((Path)localObject2).lineTo(27.995743F, 0.0F);
      ((Path)localObject2).cubicTo(30.207233F, 0.0F, 32.0F, 1.784293F, 32.0F, 3.990053F);
      ((Path)localObject2).lineTo(32.0F, 20.009947F);
      ((Path)localObject2).cubicTo(32.0F, 22.213593F, 30.210972F, 24.0F, 27.995743F, 24.0F);
      ((Path)localObject2).lineTo(4.004258F, 24.0F);
      ((Path)localObject2).cubicTo(1.792767F, 24.0F, 0.0F, 22.215706F, 0.0F, 20.009947F);
      ((Path)localObject2).lineTo(0.0F, 3.990053F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(3.0F, 3.993398F);
      ((Path)localObject2).cubicTo(3.0F, 3.444759F, 3.451279F, 3.0F, 4.0033F, 3.0F);
      ((Path)localObject2).lineTo(27.9967F, 3.0F);
      ((Path)localObject2).cubicTo(28.550808F, 3.0F, 29.0F, 3.444946F, 29.0F, 3.993398F);
      ((Path)localObject2).lineTo(29.0F, 20.006603F);
      ((Path)localObject2).cubicTo(29.0F, 20.555241F, 28.548721F, 21.0F, 27.9967F, 21.0F);
      ((Path)localObject2).lineTo(4.0033F, 21.0F);
      ((Path)localObject2).cubicTo(3.449193F, 21.0F, 3.0F, 20.555054F, 3.0F, 20.006603F);
      ((Path)localObject2).lineTo(3.0F, 3.993398F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(0.0F, 33.990051F);
      ((Path)localObject2).cubicTo(0.0F, 31.786407F, 1.789028F, 30.0F, 4.004258F, 30.0F);
      ((Path)localObject2).lineTo(27.995743F, 30.0F);
      ((Path)localObject2).cubicTo(30.207233F, 30.0F, 32.0F, 31.784294F, 32.0F, 33.990051F);
      ((Path)localObject2).lineTo(32.0F, 50.009949F);
      ((Path)localObject2).cubicTo(32.0F, 52.213593F, 30.210972F, 54.0F, 27.995743F, 54.0F);
      ((Path)localObject2).lineTo(4.004258F, 54.0F);
      ((Path)localObject2).cubicTo(1.792767F, 54.0F, 0.0F, 52.215706F, 0.0F, 50.009949F);
      ((Path)localObject2).lineTo(0.0F, 33.990051F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(3.0F, 33.993397F);
      ((Path)localObject2).cubicTo(3.0F, 33.444759F, 3.451279F, 33.0F, 4.0033F, 33.0F);
      ((Path)localObject2).lineTo(27.9967F, 33.0F);
      ((Path)localObject2).cubicTo(28.550808F, 33.0F, 29.0F, 33.444946F, 29.0F, 33.993397F);
      ((Path)localObject2).lineTo(29.0F, 50.006603F);
      ((Path)localObject2).cubicTo(29.0F, 50.555241F, 28.548721F, 51.0F, 27.9967F, 51.0F);
      ((Path)localObject2).lineTo(4.0033F, 51.0F);
      ((Path)localObject2).cubicTo(3.449193F, 51.0F, 3.0F, 50.555054F, 3.0F, 50.006603F);
      ((Path)localObject2).lineTo(3.0F, 33.993397F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(38.0F, 33.990051F);
      ((Path)localObject2).cubicTo(38.0F, 31.786407F, 39.789028F, 30.0F, 42.004257F, 30.0F);
      ((Path)localObject2).lineTo(65.995743F, 30.0F);
      ((Path)localObject2).cubicTo(68.20723F, 30.0F, 70.0F, 31.784294F, 70.0F, 33.990051F);
      ((Path)localObject2).lineTo(70.0F, 50.009949F);
      ((Path)localObject2).cubicTo(70.0F, 52.213593F, 68.210976F, 54.0F, 65.995743F, 54.0F);
      ((Path)localObject2).lineTo(42.004257F, 54.0F);
      ((Path)localObject2).cubicTo(39.792767F, 54.0F, 38.0F, 52.215706F, 38.0F, 50.009949F);
      ((Path)localObject2).lineTo(38.0F, 33.990051F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(41.0F, 33.993397F);
      ((Path)localObject2).cubicTo(41.0F, 33.444759F, 41.451279F, 33.0F, 42.0033F, 33.0F);
      ((Path)localObject2).lineTo(65.996704F, 33.0F);
      ((Path)localObject2).cubicTo(66.550804F, 33.0F, 67.0F, 33.444946F, 67.0F, 33.993397F);
      ((Path)localObject2).lineTo(67.0F, 50.006603F);
      ((Path)localObject2).cubicTo(67.0F, 50.555241F, 66.548721F, 51.0F, 65.996704F, 51.0F);
      ((Path)localObject2).lineTo(42.0033F, 51.0F);
      ((Path)localObject2).cubicTo(41.449192F, 51.0F, 41.0F, 50.555054F, 41.0F, 50.006603F);
      ((Path)localObject2).lineTo(41.0F, 33.993397F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(38.0F, 3.990053F);
      ((Path)localObject2).cubicTo(38.0F, 1.786408F, 39.789028F, 0.0F, 42.004257F, 0.0F);
      ((Path)localObject2).lineTo(65.995743F, 0.0F);
      ((Path)localObject2).cubicTo(68.20723F, 0.0F, 70.0F, 1.784293F, 70.0F, 3.990053F);
      ((Path)localObject2).lineTo(70.0F, 20.009947F);
      ((Path)localObject2).cubicTo(70.0F, 22.213593F, 68.210976F, 24.0F, 65.995743F, 24.0F);
      ((Path)localObject2).lineTo(42.004257F, 24.0F);
      ((Path)localObject2).cubicTo(39.792767F, 24.0F, 38.0F, 22.215706F, 38.0F, 20.009947F);
      ((Path)localObject2).lineTo(38.0F, 3.990053F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 2);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.sight_draft_entrance
 * JD-Core Version:    0.7.0.1
 */