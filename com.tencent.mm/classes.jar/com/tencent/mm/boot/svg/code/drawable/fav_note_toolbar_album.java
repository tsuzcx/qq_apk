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

public class fav_note_toolbar_album
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
      localObject2 = c.setMatrixFloatArray((float[])localObject2, 1.0F, 0.0F, 6.0F, 0.0F, 1.0F, 10.5F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject2);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject1 = c.instancePaint(localPaint1, paramVarArgs);
      localObject2 = c.instancePath(paramVarArgs);
      ((Path)localObject2).moveTo(56.400002F, 32.72654F);
      ((Path)localObject2).lineTo(56.400002F, 5.1F);
      ((Path)localObject2).lineTo(3.6F, 5.1F);
      ((Path)localObject2).lineTo(3.6F, 31.776659F);
      ((Path)localObject2).lineTo(18.597736F, 19.647776F);
      ((Path)localObject2).cubicTo(19.985397F, 18.525555F, 22.213877F, 18.579981F, 23.551487F, 19.755251F);
      ((Path)localObject2).lineTo(36.98077F, 31.55468F);
      ((Path)localObject2).lineTo(43.827309F, 25.732492F);
      ((Path)localObject2).cubicTo(45.213951F, 24.553312F, 47.42017F, 24.577269F, 48.766293F, 25.785252F);
      ((Path)localObject2).lineTo(56.400002F, 32.72654F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(56.399998F, 37.480827F);
      ((Path)localObject2).lineTo(46.278553F, 28.373676F);
      ((Path)localObject2).lineTo(39.713928F, 33.956127F);
      ((Path)localObject2).lineTo(43.747318F, 37.5F);
      ((Path)localObject2).lineTo(38.433502F, 37.5F);
      ((Path)localObject2).lineTo(21.018169F, 22.32025F);
      ((Path)localObject2).lineTo(3.6F, 36.40657F);
      ((Path)localObject2).lineTo(3.6F, 45.900002F);
      ((Path)localObject2).lineTo(56.400002F, 45.900002F);
      ((Path)localObject2).lineTo(56.400002F, 37.480827F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(2.975409F, 1.5F);
      ((Path)localObject2).lineTo(57.02459F, 1.5F);
      ((Path)localObject2).cubicTo(58.634083F, 1.5F, 60.0F, 2.943411F, 60.0F, 4.723949F);
      ((Path)localObject2).lineTo(60.0F, 46.276051F);
      ((Path)localObject2).cubicTo(60.0F, 48.063454F, 58.667866F, 49.5F, 57.02459F, 49.5F);
      ((Path)localObject2).lineTo(2.975409F, 49.5F);
      ((Path)localObject2).cubicTo(1.365917F, 49.5F, 0.0F, 48.056587F, 0.0F, 46.276051F);
      ((Path)localObject2).lineTo(0.0F, 4.723949F);
      ((Path)localObject2).cubicTo(0.0F, 2.936545F, 1.332136F, 1.5F, 2.975409F, 1.5F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 1);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.fav_note_toolbar_album
 * JD-Core Version:    0.7.0.1
 */