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

public class icons_outlined_remove_from_list
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
      Object localObject2 = c.instanceMatrix(paramVarArgs);
      Object localObject3 = c.instanceMatrixArray(paramVarArgs);
      Paint localPaint = c.instancePaint(paramVarArgs);
      localPaint.setFlags(385);
      localPaint.setStyle(Paint.Style.FILL);
      Object localObject1 = c.instancePaint(paramVarArgs);
      ((Paint)localObject1).setFlags(385);
      ((Paint)localObject1).setStyle(Paint.Style.STROKE);
      localPaint.setColor(-16777216);
      ((Paint)localObject1).setStrokeWidth(1.0F);
      ((Paint)localObject1).setStrokeCap(Paint.Cap.BUTT);
      ((Paint)localObject1).setStrokeJoin(Paint.Join.MITER);
      ((Paint)localObject1).setStrokeMiter(4.0F);
      ((Paint)localObject1).setPathEffect(null);
      localObject1 = c.instancePaint((Paint)localObject1, paramVarArgs);
      ((Paint)localObject1).setStrokeWidth(1.0F);
      localCanvas.save();
      localObject3 = c.setMatrixFloatArray((float[])localObject3, 1.0F, 0.0F, 4.0F, 0.0F, 1.0F, 4.5F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject2).reset();
      ((Matrix)localObject2).setValues((float[])localObject3);
      localCanvas.concat((Matrix)localObject2);
      localCanvas.save();
      localObject2 = c.instancePaint((Paint)localObject1, paramVarArgs);
      ((Paint)localObject2).setColor(-16777216);
      ((Paint)localObject2).setStrokeWidth(1.2F);
      localObject3 = c.instancePath(paramVarArgs);
      ((Path)localObject3).moveTo(0.5F, 1.0F);
      ((Path)localObject3).lineTo(16.0F, 1.0F);
      localCanvas.drawPath((Path)localObject3, (Paint)localObject2);
      localCanvas.restore();
      localCanvas.save();
      localObject2 = c.instancePaint((Paint)localObject1, paramVarArgs);
      ((Paint)localObject2).setColor(-16777216);
      ((Paint)localObject2).setStrokeWidth(1.2F);
      localObject3 = c.instancePath(paramVarArgs);
      ((Path)localObject3).moveTo(0.5F, 7.5F);
      ((Path)localObject3).lineTo(16.0F, 7.5F);
      localCanvas.drawPath((Path)localObject3, (Paint)localObject2);
      localCanvas.restore();
      localCanvas.save();
      localObject1 = c.instancePaint((Paint)localObject1, paramVarArgs);
      ((Paint)localObject1).setColor(-16777216);
      ((Paint)localObject1).setStrokeWidth(1.2F);
      localObject2 = c.instancePath(paramVarArgs);
      ((Path)localObject2).moveTo(0.5F, 14.0F);
      ((Path)localObject2).lineTo(8.5F, 14.0F);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.save();
      localObject1 = c.instancePaint(localPaint, paramVarArgs);
      ((Paint)localObject1).setColor(-16777216);
      localObject2 = c.instancePath(paramVarArgs);
      ((Path)localObject2).moveTo(14.975205F, 10.5F);
      ((Path)localObject2).lineTo(15.823733F, 11.348528F);
      ((Path)localObject2).lineTo(10.248528F, 16.923733F);
      ((Path)localObject2).lineTo(9.4F, 16.075205F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 1);
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 1);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.save();
      localPaint = c.instancePaint(localPaint, paramVarArgs);
      localPaint.setColor(-16777216);
      localObject1 = c.instancePath(paramVarArgs);
      ((Path)localObject1).moveTo(10.248528F, 10.5F);
      ((Path)localObject1).lineTo(15.823733F, 16.075205F);
      ((Path)localObject1).lineTo(14.975205F, 16.923733F);
      ((Path)localObject1).lineTo(9.4F, 11.348528F);
      ((Path)localObject1).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject1, 1);
      WeChatSVGRenderC2Java.setFillType((Path)localObject1, 1);
      localCanvas.drawPath((Path)localObject1, localPaint);
      localCanvas.restore();
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.icons_outlined_remove_from_list
 * JD-Core Version:    0.7.0.1
 */