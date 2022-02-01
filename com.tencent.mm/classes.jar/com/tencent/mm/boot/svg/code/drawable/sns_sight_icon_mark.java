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

public class sns_sight_icon_mark
  extends c
{
  private final int height = 30;
  private final int width = 42;
  
  public int doCommand(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 42;
      return 30;
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
      localObject2 = c.instancePaint((Paint)localObject2, paramVarArgs);
      ((Paint)localObject2).setColor(-1);
      localCanvas.save();
      localObject3 = c.setMatrixFloatArray((float[])localObject3, 1.0F, 0.0F, 0.0F, 0.0F, 1.0F, 3.0F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject3);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject1 = c.instancePaint((Paint)localObject2, paramVarArgs);
      localObject3 = c.instancePath(paramVarArgs);
      ((Path)localObject3).moveTo(3.0F, 21.0F);
      ((Path)localObject3).lineTo(25.0F, 21.0F);
      ((Path)localObject3).lineTo(25.0F, 3.0F);
      ((Path)localObject3).lineTo(3.0F, 3.0F);
      ((Path)localObject3).lineTo(3.0F, 21.0F);
      ((Path)localObject3).close();
      ((Path)localObject3).moveTo(0.0F, 2.004947F);
      ((Path)localObject3).cubicTo(0.0F, 0.8976452F, 0.8998975F, 0.0F, 1.991244F, 0.0F);
      ((Path)localObject3).lineTo(26.008757F, 0.0F);
      ((Path)localObject3).cubicTo(27.10849F, 0.0F, 28.0F, 0.8970262F, 28.0F, 2.004947F);
      ((Path)localObject3).lineTo(28.0F, 21.995054F);
      ((Path)localObject3).cubicTo(28.0F, 23.102354F, 27.100103F, 24.0F, 26.008757F, 24.0F);
      ((Path)localObject3).lineTo(1.991244F, 24.0F);
      ((Path)localObject3).cubicTo(0.8915104F, 24.0F, 0.0F, 23.102974F, 0.0F, 21.995054F);
      ((Path)localObject3).lineTo(0.0F, 2.004947F);
      ((Path)localObject3).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject3, 2);
      localCanvas.drawPath((Path)localObject3, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.save();
      localObject1 = c.instancePaint((Paint)localObject2, paramVarArgs);
      localObject2 = c.instancePath(paramVarArgs);
      ((Path)localObject2).moveTo(34.0F, 14.914493F);
      ((Path)localObject2).lineTo(39.0F, 18.323584F);
      ((Path)localObject2).lineTo(39.0F, 5.676416F);
      ((Path)localObject2).lineTo(34.0F, 9.085507F);
      ((Path)localObject2).lineTo(34.0F, 14.914493F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(31.0F, 7.5F);
      ((Path)localObject2).lineTo(39.51767F, 1.692498F);
      ((Path)localObject2).cubicTo(40.888622F, 0.7577572F, 42.0F, 1.341771F, 42.0F, 2.991091F);
      ((Path)localObject2).lineTo(42.0F, 21.008909F);
      ((Path)localObject2).cubicTo(42.0F, 22.660843F, 40.884727F, 23.239586F, 39.51767F, 22.307503F);
      ((Path)localObject2).lineTo(31.0F, 16.5F);
      ((Path)localObject2).lineTo(31.0F, 7.5F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 2);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.sns_sight_icon_mark
 * JD-Core Version:    0.7.0.1
 */