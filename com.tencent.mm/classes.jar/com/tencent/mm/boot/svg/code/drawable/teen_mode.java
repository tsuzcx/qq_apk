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

public class teen_mode
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
      Object localObject1 = c.instanceMatrix(paramVarArgs);
      Object localObject3 = c.instanceMatrixArray(paramVarArgs);
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
      ((Paint)localObject2).setColor(-436207616);
      localObject3 = c.setMatrixFloatArray((float[])localObject3, 1.0F, 0.0F, 2.0F, 0.0F, 1.0F, 2.0F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject3);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject1 = c.instancePaint((Paint)localObject2, paramVarArgs);
      localObject3 = c.instancePath(paramVarArgs);
      ((Path)localObject3).moveTo(10.666667F, 10.953414F);
      ((Path)localObject3).lineTo(10.666667F, 17.862661F);
      ((Path)localObject3).cubicTo(10.666667F, 19.345488F, 9.464598F, 20.547558F, 7.981771F, 20.547558F);
      ((Path)localObject3).cubicTo(6.558257F, 20.547558F, 5.39349F, 19.43973F, 5.302586F, 18.039194F);
      ((Path)localObject3).lineTo(5.296875F, 17.862661F);
      ((Path)localObject3).lineTo(5.296875F, 17.162474F);
      ((Path)localObject3).lineTo(6.630209F, 17.162474F);
      ((Path)localObject3).lineTo(6.630209F, 17.862661F);
      ((Path)localObject3).cubicTo(6.630209F, 18.609108F, 7.235323F, 19.214224F, 7.981771F, 19.214224F);
      ((Path)localObject3).cubicTo(8.681565F, 19.214224F, 9.257142F, 18.682384F, 9.326355F, 18.000851F);
      ((Path)localObject3).lineTo(9.333333F, 17.862661F);
      ((Path)localObject3).lineTo(9.333333F, 10.953414F);
      ((Path)localObject3).lineTo(10.666667F, 10.953414F);
      ((Path)localObject3).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject3, 1);
      localCanvas.drawPath((Path)localObject3, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.save();
      localObject1 = c.instancePaint((Paint)localObject2, paramVarArgs);
      localObject2 = c.instancePath(paramVarArgs);
      ((Path)localObject2).moveTo(10.0F, 8.615331E-013F);
      ((Path)localObject2).cubicTo(15.424225F, 8.615331E-013F, 19.839767F, 4.318682F, 19.995737F, 9.705154F);
      ((Path)localObject2).lineTo(20.0F, 10.0F);
      ((Path)localObject2).lineTo(19.969925F, 10.953414F);
      ((Path)localObject2).lineTo(0.001804511F, 10.953414F);
      ((Path)localObject2).lineTo(0.0F, 10.0F);
      ((Path)localObject2).cubicTo(0.0F, 4.477152F, 4.477152F, 8.615331E-013F, 10.0F, 8.615331E-013F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(10.0F, 1.333333F);
      ((Path)localObject2).cubicTo(5.397627F, 1.333333F, 1.633151F, 4.920795F, 1.350382F, 9.449663F);
      ((Path)localObject2).lineTo(1.341111F, 9.62F);
      ((Path)localObject2).lineTo(18.656666F, 9.62F);
      ((Path)localObject2).lineTo(18.649616F, 9.451906F);
      ((Path)localObject2).cubicTo(18.372505F, 5.011417F, 14.751559F, 1.477209F, 10.275116F, 1.337617F);
      ((Path)localObject2).lineTo(10.0F, 1.333333F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 1);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.teen_mode
 * JD-Core Version:    0.7.0.1
 */