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

public class icons_outlined_pencil
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
      localCanvas.save();
      localPaint1 = c.instancePaint(localPaint1, paramVarArgs);
      localPaint1.setColor(-16777216);
      localObject2 = c.setMatrixFloatArray((float[])localObject2, 1.0F, 0.0F, 9.0F, 0.0F, 1.0F, 6.0F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject2);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject1 = c.instancePaint(localPaint1, paramVarArgs);
      localObject2 = c.instancePath(paramVarArgs);
      ((Path)localObject2).moveTo(33.0F, 3.0F);
      ((Path)localObject2).lineTo(33.0F, 6.6F);
      ((Path)localObject2).lineTo(3.6F, 6.6F);
      ((Path)localObject2).lineTo(3.6F, 53.400002F);
      ((Path)localObject2).lineTo(50.400002F, 53.400002F);
      ((Path)localObject2).lineTo(50.400002F, 24.0F);
      ((Path)localObject2).lineTo(54.0F, 24.0F);
      ((Path)localObject2).lineTo(54.0F, 54.0F);
      ((Path)localObject2).cubicTo(54.0F, 55.656853F, 52.656853F, 57.0F, 51.0F, 57.0F);
      ((Path)localObject2).lineTo(3.0F, 57.0F);
      ((Path)localObject2).cubicTo(1.343146F, 57.0F, 0.0F, 55.656853F, 0.0F, 54.0F);
      ((Path)localObject2).lineTo(0.0F, 6.0F);
      ((Path)localObject2).cubicTo(0.0F, 4.343146F, 1.343146F, 3.0F, 3.0F, 3.0F);
      ((Path)localObject2).lineTo(33.0F, 3.0F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(50.582645F, 2.23824F);
      ((Path)localObject2).cubicTo(51.166965F, 1.65392F, 52.114338F, 1.65392F, 52.698658F, 2.23824F);
      ((Path)localObject2).lineTo(54.814667F, 4.354252F);
      ((Path)localObject2).cubicTo(55.398991F, 4.938572F, 55.398991F, 5.885943F, 54.814667F, 6.470264F);
      ((Path)localObject2).lineTo(26.285717F, 34.999214F);
      ((Path)localObject2).lineTo(19.335936F, 38.885635F);
      ((Path)localObject2).cubicTo(18.903196F, 39.12764F, 18.356207F, 38.973019F, 18.114202F, 38.540279F);
      ((Path)localObject2).cubicTo(17.960512F, 38.265457F, 17.962038F, 37.930202F, 18.118221F, 37.656792F);
      ((Path)localObject2).lineTo(22.054068F, 30.766817F);
      ((Path)localObject2).lineTo(50.582645F, 2.23824F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 1);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.icons_outlined_pencil
 * JD-Core Version:    0.7.0.1
 */