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

public class icons_filled_mini_window
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
      localCanvas.save();
      localPaint2 = c.instancePaint(localPaint1, paramVarArgs);
      localPaint2.setColor(-16777216);
      Path localPath = c.instancePath(paramVarArgs);
      localPath.moveTo(19.5F, 3.0F);
      localPath.cubicTo(20.052284F, 3.0F, 20.5F, 3.447715F, 20.5F, 4.0F);
      localPath.lineTo(20.5F, 4.0F);
      localPath.lineTo(20.5F, 11.999F);
      localPath.lineTo(18.5F, 11.999F);
      localPath.lineTo(18.5F, 5.0F);
      localPath.lineTo(4.0F, 5.0F);
      localPath.lineTo(4.0F, 17.0F);
      localPath.lineTo(12.0F, 16.999001F);
      localPath.lineTo(12.0F, 19.0F);
      localPath.lineTo(3.0F, 19.0F);
      localPath.cubicTo(2.487164F, 19.0F, 2.064493F, 18.61396F, 2.006728F, 18.116621F);
      localPath.lineTo(2.0F, 18.0F);
      localPath.lineTo(2.0F, 4.0F);
      localPath.cubicTo(2.0F, 3.447715F, 2.447715F, 3.0F, 3.0F, 3.0F);
      localPath.lineTo(3.0F, 3.0F);
      localPath.close();
      WeChatSVGRenderC2Java.setFillType(localPath, 1);
      localCanvas.drawPath(localPath, localPaint2);
      localCanvas.restore();
      localCanvas.save();
      localPaint2 = c.instancePaint(localPaint1, paramVarArgs);
      localPaint2.setColor(-16777216);
      localPath = c.instancePath(paramVarArgs);
      localPath.moveTo(21.0F, 13.38F);
      localPath.lineTo(14.38F, 13.38F);
      localPath.cubicTo(13.827715F, 13.38F, 13.38F, 13.827715F, 13.38F, 14.38F);
      localPath.lineTo(13.38F, 19.998175F);
      localPath.cubicTo(13.380212F, 20.550377F, 13.827798F, 20.998058F, 14.38F, 20.998386F);
      localPath.lineTo(21.0F, 20.999788F);
      localPath.cubicTo(21.552284F, 21.000116F, 22.000095F, 20.552496F, 22.000212F, 20.000212F);
      localPath.cubicTo(22.000212F, 20.000141F, 22.000212F, 20.000071F, 22.0F, 20.0F);
      localPath.lineTo(22.0F, 14.38F);
      localPath.cubicTo(22.0F, 13.827715F, 21.552284F, 13.38F, 21.0F, 13.38F);
      localPath.close();
      localPath.moveTo(15.19F, 15.0F);
      localPath.lineTo(20.190001F, 15.0F);
      localPath.cubicTo(20.294933F, 15.0F, 20.379999F, 15.085066F, 20.379999F, 15.19F);
      localPath.lineTo(20.379999F, 19.190001F);
      localPath.cubicTo(20.379999F, 19.294933F, 20.294933F, 19.379999F, 20.190001F, 19.379999F);
      localPath.lineTo(15.19F, 19.379999F);
      localPath.cubicTo(15.085066F, 19.379999F, 15.0F, 19.294933F, 15.0F, 19.190001F);
      localPath.lineTo(15.0F, 15.19F);
      localPath.cubicTo(15.0F, 15.085066F, 15.085066F, 15.0F, 15.19F, 15.0F);
      localPath.close();
      WeChatSVGRenderC2Java.setFillType(localPath, 1);
      localCanvas.drawPath(localPath, localPaint2);
      localCanvas.restore();
      localCanvas.save();
      localPaint1 = c.instancePaint(localPaint1, paramVarArgs);
      localPaint1.setColor(-16777216);
      arrayOfFloat = c.setMatrixFloatArray(arrayOfFloat, 1.0F, 0.0F, 4.5F, 0.0F, 1.0F, 5.5F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject).reset();
      ((Matrix)localObject).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject);
      localCanvas.save();
      localPaint2 = c.instancePaint(localPaint1, paramVarArgs);
      localPath = c.instancePath(paramVarArgs);
      localPath.moveTo(6.5F, 7.003622F);
      localPath.lineTo(1.0F, 7.003622F);
      localPath.lineTo(1.0F, 7.003622F);
      localPath.lineTo(1.0F, 5.503622F);
      localPath.lineTo(5.502F, 5.503F);
      localPath.lineTo(5.502333F, 1.0F);
      localPath.lineTo(7.0F, 1.0F);
      localPath.lineTo(7.0F, 6.503622F);
      localPath.cubicTo(7.0F, 6.779764F, 6.776143F, 7.003622F, 6.5F, 7.003622F);
      localPath.close();
      WeChatSVGRenderC2Java.setFillType(localPath, 2);
      localCanvas.drawPath(localPath, localPaint2);
      localCanvas.restore();
      localCanvas.save();
      localPaint1 = c.instancePaint(localPaint1, paramVarArgs);
      arrayOfFloat = c.setMatrixFloatArray(arrayOfFloat, 0.7071068F, -0.7071068F, 3.792893F, 0.7071068F, 0.7071068F, -1.571068F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject).reset();
      ((Matrix)localObject).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject);
      localObject = c.instancePath(paramVarArgs);
      ((Path)localObject).moveTo(0.2928932F, 3.042893F);
      ((Path)localObject).lineTo(7.292893F, 3.042893F);
      ((Path)localObject).lineTo(7.292893F, 4.542893F);
      ((Path)localObject).lineTo(0.2928932F, 4.542893F);
      ((Path)localObject).lineTo(0.2928932F, 3.042893F);
      ((Path)localObject).close();
      localCanvas.drawPath((Path)localObject, localPaint1);
      localCanvas.restore();
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.icons_filled_mini_window
 * JD-Core Version:    0.7.0.1
 */