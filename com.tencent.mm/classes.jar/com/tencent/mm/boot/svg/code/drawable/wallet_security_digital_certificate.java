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

public class wallet_security_digital_certificate
  extends c
{
  private final int height = 64;
  private final int width = 64;
  
  public int doCommand(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 64;
      return 64;
      Object localObject1 = (Canvas)paramVarArgs[0];
      paramVarArgs = (Looper)paramVarArgs[1];
      Object localObject2 = c.instanceMatrix(paramVarArgs);
      float[] arrayOfFloat = c.instanceMatrixArray(paramVarArgs);
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
      c.instancePaint(localPaint, paramVarArgs).setStrokeWidth(1.0F);
      ((Canvas)localObject1).save();
      arrayOfFloat = c.setMatrixFloatArray(arrayOfFloat, 1.0F, 0.0F, 10.0F, 0.0F, 1.0F, 5.0F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject2).reset();
      ((Matrix)localObject2).setValues(arrayOfFloat);
      ((Canvas)localObject1).concat((Matrix)localObject2);
      ((Canvas)localObject1).save();
      arrayOfFloat = c.setMatrixFloatArray(arrayOfFloat, 1.0F, 0.0F, 0.666667F, 0.0F, 1.0F, 0.333333F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject2).reset();
      ((Matrix)localObject2).setValues(arrayOfFloat);
      ((Canvas)localObject1).concat((Matrix)localObject2);
      localObject2 = c.instancePaint((Paint)localObject3, paramVarArgs);
      ((Paint)localObject2).setColor(-15616);
      ((Canvas)localObject1).save();
      localObject2 = c.instancePaint((Paint)localObject2, paramVarArgs);
      localObject3 = c.instancePath(paramVarArgs);
      ((Path)localObject3).moveTo(40.0F, 0.0F);
      ((Path)localObject3).cubicTo(41.472759F, 0.0F, 42.666668F, 1.193907F, 42.666668F, 2.666667F);
      ((Path)localObject3).lineTo(42.666668F, 50.666668F);
      ((Path)localObject3).cubicTo(42.666668F, 52.139427F, 41.472759F, 53.333332F, 40.0F, 53.333332F);
      ((Path)localObject3).lineTo(2.666667F, 53.333332F);
      ((Path)localObject3).cubicTo(1.193907F, 53.333332F, 0.0F, 52.139427F, 0.0F, 50.666668F);
      ((Path)localObject3).lineTo(0.0F, 2.666667F);
      ((Path)localObject3).cubicTo(0.0F, 1.193907F, 1.193907F, 0.0F, 2.666667F, 0.0F);
      ((Path)localObject3).lineTo(40.0F, 0.0F);
      ((Path)localObject3).close();
      ((Path)localObject3).moveTo(39.466667F, 3.2F);
      ((Path)localObject3).lineTo(3.2F, 3.2F);
      ((Path)localObject3).lineTo(3.2F, 50.133335F);
      ((Path)localObject3).lineTo(39.466667F, 50.133335F);
      ((Path)localObject3).lineTo(39.466667F, 3.2F);
      ((Path)localObject3).close();
      ((Path)localObject3).moveTo(18.666666F, 18.666666F);
      ((Path)localObject3).lineTo(18.666666F, 21.866667F);
      ((Path)localObject3).lineTo(8.0F, 21.866667F);
      ((Path)localObject3).lineTo(8.0F, 18.666666F);
      ((Path)localObject3).lineTo(18.666666F, 18.666666F);
      ((Path)localObject3).close();
      ((Path)localObject3).moveTo(24.0F, 10.666667F);
      ((Path)localObject3).lineTo(24.0F, 13.866667F);
      ((Path)localObject3).lineTo(8.0F, 13.866667F);
      ((Path)localObject3).lineTo(8.0F, 10.666667F);
      ((Path)localObject3).lineTo(24.0F, 10.666667F);
      ((Path)localObject3).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject3, 1);
      ((Canvas)localObject1).drawPath((Path)localObject3, (Paint)localObject2);
      ((Canvas)localObject1).restore();
      ((Canvas)localObject1).restore();
      ((Canvas)localObject1).restore();
      localObject1 = c.instancePath(paramVarArgs);
      ((Path)localObject1).moveTo(0.0F, 0.0F);
      ((Path)localObject1).lineTo(64.0F, 0.0F);
      ((Path)localObject1).lineTo(64.0F, 64.0F);
      ((Path)localObject1).lineTo(0.0F, 64.0F);
      ((Path)localObject1).lineTo(0.0F, 0.0F);
      ((Path)localObject1).close();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.wallet_security_digital_certificate
 * JD-Core Version:    0.7.0.1
 */