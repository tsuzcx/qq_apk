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

public class game_icon_vedio_empty
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
      float[] arrayOfFloat = c.instanceMatrixArray(paramVarArgs);
      Object localObject2 = c.instancePaint(paramVarArgs);
      ((Paint)localObject2).setFlags(385);
      ((Paint)localObject2).setStyle(Paint.Style.FILL);
      Paint localPaint = c.instancePaint(paramVarArgs);
      localPaint.setFlags(385);
      localPaint.setStyle(Paint.Style.STROKE);
      ((Paint)localObject2).setColor(-16777216);
      localPaint.setStrokeWidth(1.0F);
      localPaint.setStrokeCap(Paint.Cap.BUTT);
      localPaint.setStrokeJoin(Paint.Join.MITER);
      localPaint.setStrokeMiter(4.0F);
      localPaint.setPathEffect(null);
      c.instancePaint(localPaint, paramVarArgs).setStrokeWidth(1.0F);
      localCanvas.save();
      localObject2 = c.instancePaint((Paint)localObject2, paramVarArgs);
      ((Paint)localObject2).setColor(419430400);
      arrayOfFloat = c.setMatrixFloatArray(arrayOfFloat, 1.0F, 0.0F, -144.0F, 0.0F, 1.0F, -322.0F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      arrayOfFloat = c.setMatrixFloatArray(arrayOfFloat, 1.0F, 0.0F, 47.0F, 0.0F, 1.0F, 322.0F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      arrayOfFloat = c.setMatrixFloatArray(arrayOfFloat, 1.0F, 0.0F, 97.0F, 0.0F, 1.0F, 0.0F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      arrayOfFloat = c.setMatrixFloatArray(arrayOfFloat, 1.0F, 0.0F, 6.0F, 0.0F, 1.0F, 15.0F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject1 = c.instancePaint((Paint)localObject2, paramVarArgs);
      localObject2 = c.instancePath(paramVarArgs);
      ((Path)localObject2).moveTo(3.0F, 1.5F);
      ((Path)localObject2).lineTo(42.0F, 1.5F);
      ((Path)localObject2).cubicTo(43.656853F, 1.5F, 45.0F, 2.843146F, 45.0F, 4.5F);
      ((Path)localObject2).lineTo(45.0F, 37.5F);
      ((Path)localObject2).cubicTo(45.0F, 39.156853F, 43.656853F, 40.5F, 42.0F, 40.5F);
      ((Path)localObject2).lineTo(3.0F, 40.5F);
      ((Path)localObject2).cubicTo(1.343146F, 40.5F, 2.029061E-016F, 39.156853F, 0.0F, 37.5F);
      ((Path)localObject2).lineTo(0.0F, 4.5F);
      ((Path)localObject2).cubicTo(-2.029061E-016F, 2.843146F, 1.343146F, 1.5F, 3.0F, 1.5F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(48.0F, 15.0F);
      ((Path)localObject2).lineTo(58.125916F, 6.899268F);
      ((Path)localObject2).cubicTo(59.419701F, 5.86424F, 61.307579F, 6.074004F, 62.342606F, 7.367789F);
      ((Path)localObject2).cubicTo(62.768158F, 7.899729F, 63.0F, 8.56066F, 63.0F, 9.241875F);
      ((Path)localObject2).lineTo(63.0F, 32.758125F);
      ((Path)localObject2).cubicTo(63.0F, 34.414978F, 61.656853F, 35.758125F, 60.0F, 35.758125F);
      ((Path)localObject2).cubicTo(59.318787F, 35.758125F, 58.657852F, 35.526283F, 58.125916F, 35.100731F);
      ((Path)localObject2).lineTo(48.0F, 27.0F);
      ((Path)localObject2).lineTo(48.0F, 15.0F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 2);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.restore();
      localCanvas.restore();
      localCanvas.restore();
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.game_icon_vedio_empty
 * JD-Core Version:    0.7.0.1
 */