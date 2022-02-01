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

public class icons_filled_mike_off
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
      Matrix localMatrix = c.instanceMatrix(paramVarArgs);
      float[] arrayOfFloat = c.instanceMatrixArray(paramVarArgs);
      Paint localPaint = c.instancePaint(paramVarArgs);
      localPaint.setFlags(385);
      localPaint.setStyle(Paint.Style.FILL);
      Object localObject = c.instancePaint(paramVarArgs);
      ((Paint)localObject).setFlags(385);
      ((Paint)localObject).setStyle(Paint.Style.STROKE);
      localPaint.setColor(-16777216);
      ((Paint)localObject).setStrokeWidth(1.0F);
      ((Paint)localObject).setStrokeCap(Paint.Cap.BUTT);
      ((Paint)localObject).setStrokeJoin(Paint.Join.MITER);
      ((Paint)localObject).setStrokeMiter(4.0F);
      ((Paint)localObject).setPathEffect(null);
      c.instancePaint((Paint)localObject, paramVarArgs).setStrokeWidth(1.0F);
      localPaint = c.instancePaint(localPaint, paramVarArgs);
      localPaint.setColor(-16777216);
      localCanvas.save();
      localPaint = c.instancePaint(localPaint, paramVarArgs);
      localObject = c.instancePath(paramVarArgs);
      ((Path)localObject).moveTo(50.409134F, 44.045174F);
      ((Path)localObject).cubicTo(51.740875F, 41.665092F, 52.5F, 38.921196F, 52.5F, 36.0F);
      ((Path)localObject).lineTo(52.5F, 30.0F);
      ((Path)localObject).lineTo(57.0F, 30.0F);
      ((Path)localObject).lineTo(57.0F, 36.0F);
      ((Path)localObject).cubicTo(57.0F, 40.170326F, 55.784382F, 44.056732F, 53.688164F, 47.3242F);
      ((Path)localObject).lineTo(66.27565F, 59.91169F);
      ((Path)localObject).lineTo(63.09367F, 63.09367F);
      ((Path)localObject).lineTo(12.18198F, 12.18198F);
      ((Path)localObject).lineTo(15.363961F, 9.0F);
      ((Path)localObject).lineTo(24.005259F, 17.641298F);
      ((Path)localObject).cubicTo(24.194948F, 11.179807F, 29.492569F, 6.0F, 36.0F, 6.0F);
      ((Path)localObject).cubicTo(42.627419F, 6.0F, 48.0F, 11.372583F, 48.0F, 18.0F);
      ((Path)localObject).lineTo(48.0F, 36.0F);
      ((Path)localObject).cubicTo(48.0F, 37.662823F, 47.661789F, 39.246651F, 47.050407F, 40.686447F);
      ((Path)localObject).lineTo(50.409134F, 44.045174F);
      ((Path)localObject).lineTo(50.409134F, 44.045174F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(44.045174F, 50.409134F);
      ((Path)localObject).lineTo(47.3242F, 53.688164F);
      ((Path)localObject).cubicTo(44.652279F, 55.402313F, 41.566483F, 56.527615F, 38.25F, 56.880878F);
      ((Path)localObject).lineTo(38.25F, 66.0F);
      ((Path)localObject).lineTo(33.75F, 66.0F);
      ((Path)localObject).lineTo(33.75F, 56.880878F);
      ((Path)localObject).cubicTo(23.210026F, 55.75819F, 15.0F, 46.837872F, 15.0F, 36.0F);
      ((Path)localObject).lineTo(15.0F, 30.0F);
      ((Path)localObject).lineTo(19.5F, 30.0F);
      ((Path)localObject).lineTo(19.5F, 36.0F);
      ((Path)localObject).cubicTo(19.5F, 45.112698F, 26.887302F, 52.5F, 36.0F, 52.5F);
      ((Path)localObject).cubicTo(38.921196F, 52.5F, 41.665092F, 51.740875F, 44.045174F, 50.409134F);
      ((Path)localObject).lineTo(44.045174F, 50.409134F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(40.686447F, 47.050407F);
      ((Path)localObject).cubicTo(39.246651F, 47.661789F, 37.662823F, 48.0F, 36.0F, 48.0F);
      ((Path)localObject).cubicTo(29.372583F, 48.0F, 24.0F, 42.627419F, 24.0F, 36.0F);
      ((Path)localObject).lineTo(24.0F, 30.36396F);
      ((Path)localObject).lineTo(40.686447F, 47.050407F);
      ((Path)localObject).lineTo(40.686447F, 47.050407F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 1);
      localCanvas.drawPath((Path)localObject, localPaint);
      localCanvas.restore();
      localCanvas.save();
      arrayOfFloat = c.setMatrixFloatArray(arrayOfFloat, 0.7071068F, 0.7071068F, 11.121322F, -0.7071068F, 0.7071068F, 13.242639F, 0.0F, 0.0F, 1.0F);
      localMatrix.reset();
      localMatrix.setValues(arrayOfFloat);
      localCanvas.concat(localMatrix);
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.icons_filled_mike_off
 * JD-Core Version:    0.7.0.1
 */