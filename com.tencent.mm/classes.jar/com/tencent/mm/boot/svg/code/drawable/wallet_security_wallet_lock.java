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

public class wallet_security_wallet_lock
  extends c
{
  private final int height = 32;
  private final int width = 32;
  
  public int doCommand(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 32;
      return 32;
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
      arrayOfFloat = c.setMatrixFloatArray(arrayOfFloat, 1.0F, 0.0F, 5.0F, 0.0F, 1.0F, 2.0F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject2).reset();
      ((Matrix)localObject2).setValues(arrayOfFloat);
      ((Canvas)localObject1).concat((Matrix)localObject2);
      ((Canvas)localObject1).save();
      arrayOfFloat = c.setMatrixFloatArray(arrayOfFloat, 1.0F, 0.0F, 0.333333F, 0.0F, 1.0F, 0.666667F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject2).reset();
      ((Matrix)localObject2).setValues(arrayOfFloat);
      ((Canvas)localObject1).concat((Matrix)localObject2);
      localObject2 = c.instancePaint((Paint)localObject3, paramVarArgs);
      ((Paint)localObject2).setColor(-15432210);
      ((Canvas)localObject1).save();
      localObject2 = c.instancePaint((Paint)localObject2, paramVarArgs);
      localObject3 = c.instancePath(paramVarArgs);
      ((Path)localObject3).moveTo(10.666667F, 0.5333334F);
      ((Path)localObject3).cubicTo(14.790393F, 0.5333334F, 18.133333F, 3.876274F, 18.133333F, 8.0F);
      ((Path)localObject3).cubicTo(18.133333F, 8.441828F, 17.775162F, 8.8F, 17.333334F, 8.8F);
      ((Path)localObject3).cubicTo(16.891506F, 8.8F, 16.533333F, 8.441828F, 16.533333F, 8.0F);
      ((Path)localObject3).cubicTo(16.533333F, 4.75993F, 13.906737F, 2.133333F, 10.666667F, 2.133333F);
      ((Path)localObject3).cubicTo(7.500234F, 2.133333F, 4.919708F, 4.641895F, 4.804047F, 7.78006F);
      ((Path)localObject3).lineTo(4.8F, 8.0F);
      ((Path)localObject3).lineTo(4.8F, 10.666667F);
      ((Path)localObject3).lineTo(20.133333F, 10.666667F);
      ((Path)localObject3).cubicTo(20.796076F, 10.666667F, 21.333334F, 11.203925F, 21.333334F, 11.866667F);
      ((Path)localObject3).lineTo(21.333334F, 25.466667F);
      ((Path)localObject3).cubicTo(21.333334F, 26.129408F, 20.796076F, 26.666666F, 20.133333F, 26.666666F);
      ((Path)localObject3).lineTo(1.2F, 26.666666F);
      ((Path)localObject3).cubicTo(0.5372583F, 26.666666F, 0.0F, 26.129408F, 0.0F, 25.466667F);
      ((Path)localObject3).lineTo(0.0F, 11.866667F);
      ((Path)localObject3).cubicTo(0.0F, 11.203925F, 0.5372583F, 10.666667F, 1.2F, 10.666667F);
      ((Path)localObject3).lineTo(3.2F, 10.666667F);
      ((Path)localObject3).lineTo(3.2F, 8.0F);
      ((Path)localObject3).cubicTo(3.2F, 3.876274F, 6.542941F, 0.5333334F, 10.666667F, 0.5333334F);
      ((Path)localObject3).close();
      ((Path)localObject3).moveTo(19.733334F, 12.266666F);
      ((Path)localObject3).lineTo(1.6F, 12.266666F);
      ((Path)localObject3).lineTo(1.6F, 25.066668F);
      ((Path)localObject3).lineTo(19.733334F, 25.066668F);
      ((Path)localObject3).lineTo(19.733334F, 12.266666F);
      ((Path)localObject3).close();
      ((Path)localObject3).moveTo(15.455034F, 14.747661F);
      ((Path)localObject3).lineTo(16.544966F, 15.919006F);
      ((Path)localObject3).lineTo(9.380325F, 22.585672F);
      ((Path)localObject3).cubicTo(9.073209F, 22.871443F, 8.597509F, 22.871443F, 8.290394F, 22.585672F);
      ((Path)localObject3).lineTo(4.788368F, 19.327053F);
      ((Path)localObject3).lineTo(5.878299F, 18.155708F);
      ((Path)localObject3).lineTo(8.83536F, 20.90724F);
      ((Path)localObject3).lineTo(15.455034F, 14.747661F);
      ((Path)localObject3).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject3, 1);
      ((Canvas)localObject1).drawPath((Path)localObject3, (Paint)localObject2);
      ((Canvas)localObject1).restore();
      ((Canvas)localObject1).restore();
      ((Canvas)localObject1).restore();
      localObject1 = c.instancePath(paramVarArgs);
      ((Path)localObject1).moveTo(0.0F, 0.0F);
      ((Path)localObject1).lineTo(32.0F, 0.0F);
      ((Path)localObject1).lineTo(32.0F, 32.0F);
      ((Path)localObject1).lineTo(0.0F, 32.0F);
      ((Path)localObject1).lineTo(0.0F, 0.0F);
      ((Path)localObject1).close();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.wallet_security_wallet_lock
 * JD-Core Version:    0.7.0.1
 */