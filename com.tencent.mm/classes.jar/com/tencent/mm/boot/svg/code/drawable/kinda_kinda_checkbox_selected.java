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

public class kinda_kinda_checkbox_selected
  extends c
{
  private final int height = 26;
  private final int width = 26;
  
  public int doCommand(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 26;
      return 26;
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
      localObject2 = c.setMatrixFloatArray((float[])localObject2, 1.0F, 0.0F, 1.0F, 0.0F, 1.0F, 1.0F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject2);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject1 = c.instancePaint(localPaint1, paramVarArgs);
      localObject2 = c.instancePath(paramVarArgs);
      ((Path)localObject2).moveTo(24.0F, 12.148149F);
      ((Path)localObject2).cubicTo(24.0F, 18.627556F, 18.627556F, 24.0F, 11.851851F, 24.0F);
      ((Path)localObject2).cubicTo(5.372445F, 24.0F, 0.0F, 18.627556F, 0.0F, 12.148149F);
      ((Path)localObject2).cubicTo(0.0F, 5.372445F, 5.372445F, 0.0F, 11.851851F, 0.0F);
      ((Path)localObject2).cubicTo(18.627556F, 0.0F, 24.0F, 5.372445F, 24.0F, 12.148149F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(10.363961F, 15.313708F);
      ((Path)localObject2).lineTo(7.06066F, 12.010407F);
      ((Path)localObject2).lineTo(6.0F, 13.071068F);
      ((Path)localObject2).lineTo(9.656855F, 16.727922F);
      ((Path)localObject2).cubicTo(10.047379F, 17.118446F, 10.680544F, 17.118446F, 11.071068F, 16.727922F);
      ((Path)localObject2).lineTo(18.738329F, 9.06066F);
      ((Path)localObject2).lineTo(17.67767F, 8.0F);
      ((Path)localObject2).lineTo(10.363961F, 15.313708F);
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
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.kinda_kinda_checkbox_selected
 * JD-Core Version:    0.7.0.1
 */