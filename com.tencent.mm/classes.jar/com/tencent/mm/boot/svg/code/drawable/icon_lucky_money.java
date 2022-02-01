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

public class icon_lucky_money
  extends c
{
  private final int height = 20;
  private final int width = 20;
  
  public int doCommand(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 20;
      return 20;
      Canvas localCanvas = (Canvas)paramVarArgs[0];
      paramVarArgs = (Looper)paramVarArgs[1];
      Object localObject1 = c.instanceMatrix(paramVarArgs);
      Object localObject2 = c.instanceMatrixArray(paramVarArgs);
      Paint localPaint = c.instancePaint(paramVarArgs);
      localPaint.setFlags(385);
      localPaint.setStyle(Paint.Style.FILL);
      Object localObject3 = c.instancePaint(paramVarArgs);
      ((Paint)localObject3).setFlags(385);
      ((Paint)localObject3).setStyle(Paint.Style.STROKE);
      localPaint.setColor(-16777216);
      ((Paint)localObject3).setStrokeWidth(1.0F);
      ((Paint)localObject3).setStrokeCap(Paint.Cap.BUTT);
      ((Paint)localObject3).setStrokeJoin(Paint.Join.MITER);
      ((Paint)localObject3).setStrokeMiter(4.0F);
      ((Paint)localObject3).setPathEffect(null);
      c.instancePaint((Paint)localObject3, paramVarArgs).setStrokeWidth(1.0F);
      localObject3 = c.instancePath(paramVarArgs);
      ((Path)localObject3).moveTo(0.0F, 0.0F);
      ((Path)localObject3).lineTo(20.0F, 0.0F);
      ((Path)localObject3).lineTo(20.0F, 20.0F);
      ((Path)localObject3).lineTo(0.0F, 20.0F);
      ((Path)localObject3).lineTo(0.0F, 0.0F);
      ((Path)localObject3).close();
      localCanvas.save();
      localPaint = c.instancePaint(localPaint, paramVarArgs);
      localPaint.setColor(-1);
      localObject2 = c.setMatrixFloatArray((float[])localObject2, 1.0F, 0.0F, 3.75F, 0.0F, 1.0F, 2.5F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject2);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.saveLayerAlpha(null, 230, 31);
      localCanvas.save();
      localObject1 = c.instancePaint(localPaint, paramVarArgs);
      localObject2 = c.instancePath(paramVarArgs);
      ((Path)localObject2).moveTo(6.25F, 7.552065F);
      ((Path)localObject2).cubicTo(5.530878F, 7.552065F, 4.947917F, 6.969104F, 4.947917F, 6.249982F);
      ((Path)localObject2).cubicTo(4.947917F, 5.53086F, 5.530878F, 4.947899F, 6.25F, 4.947899F);
      ((Path)localObject2).cubicTo(6.969122F, 4.947899F, 7.552084F, 5.53086F, 7.552084F, 6.249982F);
      ((Path)localObject2).cubicTo(7.552084F, 6.969104F, 6.969122F, 7.552065F, 6.25F, 7.552065F);
      ((Path)localObject2).moveTo(12.5F, 0.633325F);
      ((Path)localObject2).cubicTo(12.5F, 0.2835492F, 12.215434F, 5.553739E-013F, 11.880123F, 5.40129E-013F);
      ((Path)localObject2).lineTo(0.6198769F, 2.818267E-014F);
      ((Path)localObject2).cubicTo(0.2775284F, 1.261781E-014F, 6.694948E-015F, 0.2806284F, 1.510922E-014F, 0.633325F);
      ((Path)localObject2).lineTo(2.88658E-014F, 1.209952F);
      ((Path)localObject2).cubicTo(2.88658E-014F, 3.413002F, 1.909821F, 5.270095F, 4.519286F, 5.850347F);
      ((Path)localObject2).cubicTo(4.484643F, 5.990061F, 4.464286F, 6.135348F, 4.464286F, 6.285851F);
      ((Path)localObject2).cubicTo(4.464286F, 6.345548F, 4.4675F, 6.404526F, 4.473214F, 6.462785F);
      ((Path)localObject2).cubicTo(2.750536F, 6.193068F, 1.207857F, 5.538734F, 2.88658E-014F, 4.620616F);
      ((Path)localObject2).lineTo(5.609694E-014F, 15.001827F);
      ((Path)localObject2).cubicTo(5.699973E-014F, 15.345996F, 0.284566F, 15.625F, 0.6198769F, 15.625F);
      ((Path)localObject2).lineTo(11.880123F, 15.625F);
      ((Path)localObject2).cubicTo(12.222471F, 15.625F, 12.5F, 15.35298F, 12.5F, 15.001827F);
      ((Path)localObject2).lineTo(12.5F, 4.620616F);
      ((Path)localObject2).cubicTo(11.292143F, 5.538734F, 9.749464F, 6.193068F, 8.026786F, 6.462785F);
      ((Path)localObject2).cubicTo(8.0325F, 6.404526F, 8.035714F, 6.345548F, 8.035714F, 6.285851F);
      ((Path)localObject2).cubicTo(8.035714F, 6.135348F, 8.015357F, 5.990061F, 7.980714F, 5.850347F);
      ((Path)localObject2).cubicTo(10.590178F, 5.270095F, 12.5F, 3.413002F, 12.5F, 1.209952F);
      ((Path)localObject2).lineTo(12.5F, 0.633325F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 2);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.restore();
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.icon_lucky_money
 * JD-Core Version:    0.7.0.1
 */