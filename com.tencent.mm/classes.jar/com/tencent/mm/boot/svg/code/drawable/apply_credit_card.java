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

public class apply_credit_card
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
      localPaint = c.instancePaint(localPaint, paramVarArgs);
      localPaint.setStrokeWidth(1.0F);
      localCanvas.save();
      localObject3 = c.setMatrixFloatArray((float[])localObject3, 1.0F, 0.0F, -160.0F, 0.0F, 1.0F, -984.0F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject2).reset();
      ((Matrix)localObject2).setValues((float[])localObject3);
      localCanvas.concat((Matrix)localObject2);
      localCanvas.save();
      localObject3 = c.setMatrixFloatArray((float[])localObject3, 1.0F, 0.0F, 160.0F, 0.0F, 1.0F, 984.0F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject2).reset();
      ((Matrix)localObject2).setValues((float[])localObject3);
      localCanvas.concat((Matrix)localObject2);
      localObject2 = c.instancePaint((Paint)localObject1, paramVarArgs);
      ((Paint)localObject2).setColor(-15658735);
      localCanvas.save();
      localObject2 = c.instancePaint((Paint)localObject2, paramVarArgs);
      localObject3 = c.instancePath(paramVarArgs);
      ((Path)localObject3).moveTo(17.50683F, 3.333333F);
      ((Path)localObject3).cubicTo(17.963295F, 3.333333F, 18.333334F, 3.703859F, 18.333334F, 4.167393F);
      ((Path)localObject3).lineTo(18.333334F, 15.832607F);
      ((Path)localObject3).cubicTo(18.333334F, 16.293245F, 17.953913F, 16.666666F, 17.50683F, 16.666666F);
      ((Path)localObject3).lineTo(2.493169F, 16.666666F);
      ((Path)localObject3).cubicTo(2.036705F, 16.666666F, 1.666667F, 16.296141F, 1.666667F, 15.832607F);
      ((Path)localObject3).lineTo(1.666667F, 4.167393F);
      ((Path)localObject3).cubicTo(1.666667F, 3.706755F, 2.046088F, 3.333333F, 2.493169F, 3.333333F);
      ((Path)localObject3).lineTo(17.50683F, 3.333333F);
      ((Path)localObject3).close();
      ((Path)localObject3).moveTo(17.333334F, 4.333334F);
      ((Path)localObject3).lineTo(2.666667F, 4.333334F);
      ((Path)localObject3).lineTo(2.666667F, 15.666667F);
      ((Path)localObject3).lineTo(17.333334F, 15.666667F);
      ((Path)localObject3).lineTo(17.333334F, 4.333334F);
      ((Path)localObject3).close();
      ((Path)localObject3).moveTo(6.666667F, 10.0F);
      ((Path)localObject3).cubicTo(7.126904F, 10.0F, 7.5F, 10.373096F, 7.5F, 10.833333F);
      ((Path)localObject3).lineTo(7.5F, 12.5F);
      ((Path)localObject3).cubicTo(7.5F, 12.960238F, 7.126904F, 13.333333F, 6.666667F, 13.333333F);
      ((Path)localObject3).lineTo(5.0F, 13.333333F);
      ((Path)localObject3).cubicTo(4.539763F, 13.333333F, 4.166667F, 12.960238F, 4.166667F, 12.5F);
      ((Path)localObject3).lineTo(4.166667F, 10.833333F);
      ((Path)localObject3).cubicTo(4.166667F, 10.373096F, 4.539763F, 10.0F, 5.0F, 10.0F);
      ((Path)localObject3).lineTo(6.666667F, 10.0F);
      ((Path)localObject3).close();
      ((Path)localObject3).moveTo(6.5F, 11.0F);
      ((Path)localObject3).lineTo(5.166667F, 11.0F);
      ((Path)localObject3).lineTo(5.166667F, 12.333333F);
      ((Path)localObject3).lineTo(6.5F, 12.333333F);
      ((Path)localObject3).lineTo(6.5F, 11.0F);
      ((Path)localObject3).close();
      ((Path)localObject3).moveTo(15.833333F, 6.666667F);
      ((Path)localObject3).lineTo(15.833333F, 7.666667F);
      ((Path)localObject3).lineTo(4.166667F, 7.666667F);
      ((Path)localObject3).lineTo(4.166667F, 6.666667F);
      ((Path)localObject3).lineTo(15.833333F, 6.666667F);
      ((Path)localObject3).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject3, 2);
      localCanvas.drawPath((Path)localObject3, (Paint)localObject2);
      localCanvas.restore();
      localObject2 = c.instancePaint((Paint)localObject1, paramVarArgs);
      ((Paint)localObject2).setColor(-2565928);
      localObject3 = c.instancePath(paramVarArgs);
      ((Path)localObject3).moveTo(0.0F, 0.0F);
      ((Path)localObject3).lineTo(20.0F, 0.0F);
      ((Path)localObject3).lineTo(20.0F, 20.0F);
      ((Path)localObject3).lineTo(0.0F, 20.0F);
      ((Path)localObject3).lineTo(0.0F, 0.0F);
      ((Path)localObject3).close();
      localCanvas.saveLayerAlpha(null, 0, 31);
      localCanvas.drawPath((Path)localObject3, c.instancePaint((Paint)localObject2, paramVarArgs));
      localCanvas.restore();
      localObject2 = c.instancePaint((Paint)localObject1, paramVarArgs);
      localPaint = c.instancePaint(localPaint, paramVarArgs);
      ((Paint)localObject2).setColor(-2565928);
      localPaint.setColor(-6842473);
      localObject1 = c.instancePath(paramVarArgs);
      ((Path)localObject1).moveTo(0.0F, 0.0F);
      ((Path)localObject1).lineTo(20.0F, 0.0F);
      ((Path)localObject1).lineTo(20.0F, 20.0F);
      ((Path)localObject1).lineTo(0.0F, 20.0F);
      ((Path)localObject1).lineTo(0.0F, 0.0F);
      ((Path)localObject1).close();
      localCanvas.saveLayerAlpha(null, 0, 31);
      localObject2 = c.instancePaint((Paint)localObject2, paramVarArgs);
      localPaint = c.instancePaint(localPaint, paramVarArgs);
      localCanvas.drawPath((Path)localObject1, (Paint)localObject2);
      localCanvas.drawPath((Path)localObject1, localPaint);
      localCanvas.restore();
      localCanvas.restore();
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.apply_credit_card
 * JD-Core Version:    0.7.0.1
 */