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

public class icons_outlined_min_window
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
      Paint localPaint = c.instancePaint(paramVarArgs);
      localPaint.setFlags(385);
      localPaint.setStyle(Paint.Style.FILL);
      Object localObject2 = c.instancePaint(paramVarArgs);
      ((Paint)localObject2).setFlags(385);
      ((Paint)localObject2).setStyle(Paint.Style.STROKE);
      localPaint.setColor(-16777216);
      ((Paint)localObject2).setStrokeWidth(1.0F);
      ((Paint)localObject2).setStrokeCap(Paint.Cap.BUTT);
      ((Paint)localObject2).setStrokeJoin(Paint.Join.MITER);
      ((Paint)localObject2).setStrokeMiter(4.0F);
      ((Paint)localObject2).setPathEffect(null);
      c.instancePaint((Paint)localObject2, paramVarArgs).setStrokeWidth(1.0F);
      localObject2 = c.instancePath(paramVarArgs);
      ((Path)localObject2).moveTo(0.0F, 0.0F);
      ((Path)localObject2).lineTo(72.0F, 0.0F);
      ((Path)localObject2).lineTo(72.0F, 72.0F);
      ((Path)localObject2).lineTo(0.0F, 72.0F);
      ((Path)localObject2).lineTo(0.0F, 0.0F);
      ((Path)localObject2).close();
      localCanvas.save();
      localPaint = c.instancePaint(localPaint, paramVarArgs);
      localPaint.setColor(-1);
      arrayOfFloat = c.setMatrixFloatArray(arrayOfFloat, 0.7071068F, -0.7071068F, 35.571701F, 0.7071068F, 0.7071068F, -16.49164F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject1);
      localObject1 = c.instancePath(paramVarArgs);
      ((Path)localObject1).moveTo(38.400127F, 39.172203F);
      ((Path)localObject1).lineTo(50.42094F, 51.19302F);
      ((Path)localObject1).lineTo(47.23896F, 54.375F);
      ((Path)localObject1).lineTo(39.942097F, 47.079018F);
      ((Path)localObject1).lineTo(39.94302F, 67.693016F);
      ((Path)localObject1).lineTo(35.44302F, 67.693016F);
      ((Path)localObject1).lineTo(35.442097F, 47.077019F);
      ((Path)localObject1).lineTo(28.147078F, 54.375F);
      ((Path)localObject1).lineTo(24.965097F, 51.19302F);
      ((Path)localObject1).lineTo(36.985912F, 39.172203F);
      ((Path)localObject1).cubicTo(37.376438F, 38.781681F, 38.009602F, 38.781681F, 38.400127F, 39.172203F);
      ((Path)localObject1).close();
      ((Path)localObject1).moveTo(39.94302F, 1.69302F);
      ((Path)localObject1).lineTo(39.942097F, 22.305019F);
      ((Path)localObject1).lineTo(47.23896F, 15.011039F);
      ((Path)localObject1).lineTo(50.42094F, 18.19302F);
      ((Path)localObject1).lineTo(38.400127F, 30.213835F);
      ((Path)localObject1).cubicTo(38.009602F, 30.604359F, 37.376438F, 30.604359F, 36.985912F, 30.213835F);
      ((Path)localObject1).lineTo(36.985912F, 30.213835F);
      ((Path)localObject1).lineTo(24.965097F, 18.19302F);
      ((Path)localObject1).lineTo(28.147078F, 15.011039F);
      ((Path)localObject1).lineTo(35.442097F, 22.309019F);
      ((Path)localObject1).lineTo(35.44302F, 1.69302F);
      ((Path)localObject1).lineTo(39.94302F, 1.69302F);
      ((Path)localObject1).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject1, 2);
      localCanvas.drawPath((Path)localObject1, localPaint);
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.icons_outlined_min_window
 * JD-Core Version:    0.7.0.1
 */