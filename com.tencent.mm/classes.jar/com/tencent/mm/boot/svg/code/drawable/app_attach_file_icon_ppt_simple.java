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

public class app_attach_file_icon_ppt_simple
  extends c
{
  private final int height = 40;
  private final int width = 40;
  
  public int doCommand(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 40;
      return 40;
      Canvas localCanvas = (Canvas)paramVarArgs[0];
      paramVarArgs = (Looper)paramVarArgs[1];
      Object localObject2 = c.instanceMatrix(paramVarArgs);
      Object localObject3 = c.instanceMatrixArray(paramVarArgs);
      Object localObject1 = c.instancePaint(paramVarArgs);
      ((Paint)localObject1).setFlags(385);
      ((Paint)localObject1).setStyle(Paint.Style.FILL);
      Paint localPaint = c.instancePaint(paramVarArgs);
      localPaint.setFlags(385);
      localPaint.setStyle(Paint.Style.STROKE);
      ((Paint)localObject1).setColor(-16777216);
      localPaint.setStrokeWidth(1.0F);
      localPaint.setStrokeCap(Paint.Cap.BUTT);
      localPaint.setStrokeJoin(Paint.Join.MITER);
      localPaint.setStrokeMiter(4.0F);
      localPaint.setPathEffect(null);
      c.instancePaint(localPaint, paramVarArgs).setStrokeWidth(1.0F);
      localCanvas.save();
      localObject3 = c.setMatrixFloatArray((float[])localObject3, 1.0F, 0.0F, 8.0F, 0.0F, 1.0F, 4.0F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject2).reset();
      ((Matrix)localObject2).setValues((float[])localObject3);
      localCanvas.concat((Matrix)localObject2);
      localCanvas.save();
      localObject2 = c.instancePaint((Paint)localObject1, paramVarArgs);
      ((Paint)localObject2).setColor(-892609);
      localObject3 = c.instancePath(paramVarArgs);
      ((Path)localObject3).moveTo(16.0F, 0.0F);
      ((Path)localObject3).lineTo(24.0F, 8.0F);
      ((Path)localObject3).lineTo(23.999863F, 1.049432F);
      ((Path)localObject3).cubicTo(23.999954F, 1.055166F, 24.0F, 1.060911F, 24.0F, 1.066667F);
      ((Path)localObject3).lineTo(24.0F, 30.933332F);
      ((Path)localObject3).cubicTo(24.0F, 31.522438F, 23.522438F, 32.0F, 22.933332F, 32.0F);
      ((Path)localObject3).lineTo(1.066667F, 32.0F);
      ((Path)localObject3).cubicTo(0.4775629F, 32.0F, -1.16017E-014F, 31.522438F, -1.421086E-014F, 30.933332F);
      ((Path)localObject3).lineTo(-1.421086E-014F, 1.066667F);
      ((Path)localObject3).cubicTo(-1.4283E-014F, 0.4775629F, 0.4775629F, 5.523058E-016F, 1.066667F, 0.0F);
      ((Path)localObject3).lineTo(16.0F, 0.0F);
      ((Path)localObject3).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject3, 2);
      localCanvas.drawPath((Path)localObject3, (Paint)localObject2);
      localCanvas.restore();
      localObject2 = c.instancePaint((Paint)localObject1, paramVarArgs);
      ((Paint)localObject2).setColor(-16777216);
      localObject1 = c.instancePath(paramVarArgs);
      ((Path)localObject1).moveTo(24.0F, 8.0F);
      ((Path)localObject1).lineTo(17.066668F, 8.0F);
      ((Path)localObject1).cubicTo(16.477562F, 8.0F, 16.0F, 7.522437F, 16.0F, 6.933333F);
      ((Path)localObject1).lineTo(16.0F, 0.0F);
      ((Path)localObject1).lineTo(16.0F, 0.0F);
      ((Path)localObject1).lineTo(24.0F, 8.0F);
      ((Path)localObject1).close();
      localCanvas.saveLayerAlpha(null, 51, 31);
      localObject2 = c.instancePaint((Paint)localObject2, paramVarArgs);
      WeChatSVGRenderC2Java.setFillType((Path)localObject1, 2);
      localCanvas.drawPath((Path)localObject1, (Paint)localObject2);
      localCanvas.restore();
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.app_attach_file_icon_ppt_simple
 * JD-Core Version:    0.7.0.1
 */