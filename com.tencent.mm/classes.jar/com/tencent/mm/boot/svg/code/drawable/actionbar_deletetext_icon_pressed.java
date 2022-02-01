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

public class actionbar_deletetext_icon_pressed
  extends c
{
  private final int height = 96;
  private final int width = 96;
  
  public int doCommand(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 96;
      return 96;
      Canvas localCanvas = (Canvas)paramVarArgs[0];
      paramVarArgs = (Looper)paramVarArgs[1];
      Object localObject1 = c.instanceMatrix(paramVarArgs);
      Object localObject2 = c.instanceMatrixArray(paramVarArgs);
      Object localObject3 = c.instancePaint(paramVarArgs);
      ((Paint)localObject3).setFlags(385);
      ((Paint)localObject3).setStyle(Paint.Style.FILL);
      Object localObject4 = c.instancePaint(paramVarArgs);
      ((Paint)localObject4).setFlags(385);
      ((Paint)localObject4).setStyle(Paint.Style.STROKE);
      ((Paint)localObject3).setColor(-16777216);
      ((Paint)localObject4).setStrokeWidth(1.0F);
      ((Paint)localObject4).setStrokeCap(Paint.Cap.BUTT);
      ((Paint)localObject4).setStrokeJoin(Paint.Join.MITER);
      ((Paint)localObject4).setStrokeMiter(4.0F);
      ((Paint)localObject4).setPathEffect(null);
      c.instancePaint((Paint)localObject4, paramVarArgs).setStrokeWidth(1.0F);
      localCanvas.save();
      localObject3 = c.instancePaint((Paint)localObject3, paramVarArgs);
      ((Paint)localObject3).setColor(654311423);
      localObject4 = c.setMatrixFloatArray((float[])localObject2, 1.0F, 0.0F, 8.0F, 0.0F, 1.0F, 8.0F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject4);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject2 = c.instancePaint((Paint)localObject3, paramVarArgs);
      localObject3 = c.setMatrixFloatArray((float[])localObject4, 0.7071068F, 0.7071068F, -16.568542F, -0.7071068F, 0.7071068F, 40.0F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject3);
      localCanvas.concat((Matrix)localObject1);
      localObject1 = c.instancePath(paramVarArgs);
      ((Path)localObject1).moveTo(37.0F, 37.0F);
      ((Path)localObject1).lineTo(37.0F, 12.995752F);
      ((Path)localObject1).cubicTo(37.0F, 12.450768F, 37.443588F, 12.0F, 37.99078F, 12.0F);
      ((Path)localObject1).lineTo(42.00922F, 12.0F);
      ((Path)localObject1).cubicTo(42.549026F, 12.0F, 43.0F, 12.445813F, 43.0F, 12.995752F);
      ((Path)localObject1).lineTo(43.0F, 37.0F);
      ((Path)localObject1).lineTo(67.00425F, 37.0F);
      ((Path)localObject1).cubicTo(67.549232F, 37.0F, 68.0F, 37.443588F, 68.0F, 37.99078F);
      ((Path)localObject1).lineTo(68.0F, 42.00922F);
      ((Path)localObject1).cubicTo(68.0F, 42.549026F, 67.554184F, 43.0F, 67.00425F, 43.0F);
      ((Path)localObject1).lineTo(43.0F, 43.0F);
      ((Path)localObject1).lineTo(43.0F, 67.00425F);
      ((Path)localObject1).cubicTo(43.0F, 67.549232F, 42.556412F, 68.0F, 42.00922F, 68.0F);
      ((Path)localObject1).lineTo(37.99078F, 68.0F);
      ((Path)localObject1).cubicTo(37.450974F, 68.0F, 37.0F, 67.554184F, 37.0F, 67.00425F);
      ((Path)localObject1).lineTo(37.0F, 43.0F);
      ((Path)localObject1).lineTo(12.995752F, 43.0F);
      ((Path)localObject1).cubicTo(12.450768F, 43.0F, 12.0F, 42.556412F, 12.0F, 42.00922F);
      ((Path)localObject1).lineTo(12.0F, 37.99078F);
      ((Path)localObject1).cubicTo(12.0F, 37.450974F, 12.445813F, 37.0F, 12.995752F, 37.0F);
      ((Path)localObject1).lineTo(37.0F, 37.0F);
      ((Path)localObject1).lineTo(37.0F, 37.0F);
      ((Path)localObject1).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject1, 2);
      localCanvas.drawPath((Path)localObject1, (Paint)localObject2);
      localCanvas.restore();
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.actionbar_deletetext_icon_pressed
 * JD-Core Version:    0.7.0.1
 */