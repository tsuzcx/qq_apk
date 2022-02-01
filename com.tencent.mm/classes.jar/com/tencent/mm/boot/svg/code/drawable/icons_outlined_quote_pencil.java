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

public class icons_outlined_quote_pencil
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
      Object localObject3 = c.instancePaint(paramVarArgs);
      ((Paint)localObject3).setFlags(385);
      ((Paint)localObject3).setStyle(Paint.Style.FILL);
      Paint localPaint = c.instancePaint(paramVarArgs);
      localPaint.setFlags(385);
      localPaint.setStyle(Paint.Style.STROKE);
      ((Paint)localObject3).setColor(-16777216);
      localPaint.setStrokeWidth(1.0F);
      localPaint.setStrokeCap(Paint.Cap.BUTT);
      localPaint.setStrokeJoin(Paint.Join.MITER);
      localPaint.setStrokeMiter(4.0F);
      localPaint.setPathEffect(null);
      localPaint = c.instancePaint(localPaint, paramVarArgs);
      localPaint.setStrokeWidth(1.0F);
      localObject3 = c.instancePaint((Paint)localObject3, paramVarArgs);
      localPaint = c.instancePaint(localPaint, paramVarArgs);
      ((Paint)localObject3).setColor(-16777216);
      localPaint.setColor(-16777216);
      localPaint.setStrokeWidth(1.5F);
      localCanvas.save();
      localObject2 = c.setMatrixFloatArray((float[])localObject2, 1.0F, 0.0F, 9.0F, 0.0F, 1.0F, 7.75F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject2);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject1 = c.instancePaint((Paint)localObject3, paramVarArgs);
      localObject2 = c.instancePaint(localPaint, paramVarArgs);
      localObject3 = c.instancePath(paramVarArgs);
      ((Path)localObject3).moveTo(33.0F, 2.0F);
      ((Path)localObject3).lineTo(33.0F, 5.6F);
      ((Path)localObject3).lineTo(3.6F, 5.6F);
      ((Path)localObject3).lineTo(3.6F, 52.400002F);
      ((Path)localObject3).lineTo(50.400002F, 52.400002F);
      ((Path)localObject3).lineTo(50.400002F, 23.0F);
      ((Path)localObject3).lineTo(54.0F, 23.0F);
      ((Path)localObject3).lineTo(54.0F, 53.0F);
      ((Path)localObject3).cubicTo(54.0F, 54.656853F, 52.656853F, 56.0F, 51.0F, 56.0F);
      ((Path)localObject3).lineTo(3.0F, 56.0F);
      ((Path)localObject3).cubicTo(1.343146F, 56.0F, 0.0F, 54.656853F, 0.0F, 53.0F);
      ((Path)localObject3).lineTo(0.0F, 5.0F);
      ((Path)localObject3).cubicTo(0.0F, 3.343146F, 1.343146F, 2.0F, 3.0F, 2.0F);
      ((Path)localObject3).lineTo(33.0F, 2.0F);
      ((Path)localObject3).close();
      ((Path)localObject3).moveTo(52.698658F, 1.23824F);
      ((Path)localObject3).lineTo(54.814667F, 3.354252F);
      ((Path)localObject3).cubicTo(55.398991F, 3.938573F, 55.398991F, 4.885943F, 54.814667F, 5.470264F);
      ((Path)localObject3).lineTo(26.285717F, 33.999214F);
      ((Path)localObject3).lineTo(19.335936F, 37.885635F);
      ((Path)localObject3).cubicTo(18.903196F, 38.12764F, 18.356207F, 37.973019F, 18.114202F, 37.540279F);
      ((Path)localObject3).cubicTo(17.960512F, 37.265457F, 17.962038F, 36.930202F, 18.118221F, 36.656792F);
      ((Path)localObject3).lineTo(22.054068F, 29.766817F);
      ((Path)localObject3).lineTo(50.582645F, 1.23824F);
      ((Path)localObject3).cubicTo(51.166965F, 0.6539196F, 52.114338F, 0.6539196F, 52.698658F, 1.23824F);
      ((Path)localObject3).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject3, 2);
      localCanvas.drawPath((Path)localObject3, (Paint)localObject1);
      localCanvas.drawPath((Path)localObject3, (Paint)localObject2);
      localCanvas.restore();
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.icons_outlined_quote_pencil
 * JD-Core Version:    0.7.0.1
 */