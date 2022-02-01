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

public class float_ball_state_message
  extends c
{
  private final int height = 33;
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
      return 33;
      Canvas localCanvas = (Canvas)paramVarArgs[0];
      paramVarArgs = (Looper)paramVarArgs[1];
      Object localObject1 = c.instanceMatrix(paramVarArgs);
      float[] arrayOfFloat = c.instanceMatrixArray(paramVarArgs);
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
      arrayOfFloat = c.setMatrixFloatArray(arrayOfFloat, 1.0F, 0.0F, -374.0F, 0.0F, 1.0F, -200.0F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      arrayOfFloat = c.setMatrixFloatArray(arrayOfFloat, 1.0F, 0.0F, 366.0F, 0.0F, 1.0F, 192.0F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      arrayOfFloat = c.setMatrixFloatArray(arrayOfFloat, 1.0F, 0.0F, 8.0F, 0.0F, 1.0F, 8.5F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localPaint = c.instancePaint((Paint)localObject2, paramVarArgs);
      localPaint.setColor(-16268960);
      Path localPath = c.instancePath(paramVarArgs);
      localPath.moveTo(16.0F, 0.0F);
      localPath.cubicTo(24.836555F, 0.0F, 32.0F, 7.163444F, 32.0F, 16.0F);
      localPath.cubicTo(32.0F, 24.836555F, 24.836555F, 32.0F, 16.0F, 32.0F);
      localPath.cubicTo(7.163444F, 32.0F, 0.0F, 24.836555F, 0.0F, 16.0F);
      localPath.cubicTo(0.0F, 7.163444F, 7.163444F, 0.0F, 16.0F, 0.0F);
      localPath.close();
      localCanvas.drawPath(localPath, localPaint);
      localCanvas.restore();
      localCanvas.save();
      localObject2 = c.instancePaint((Paint)localObject2, paramVarArgs);
      ((Paint)localObject2).setColor(-1);
      arrayOfFloat = c.setMatrixFloatArray(arrayOfFloat, 1.0F, 0.0F, 6.0F, 0.0F, 1.0F, 6.0F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject1 = c.instancePaint((Paint)localObject2, paramVarArgs);
      localObject2 = c.instancePath(paramVarArgs);
      ((Path)localObject2).moveTo(15.833333F, 1.666667F);
      ((Path)localObject2).cubicTo(16.293571F, 1.666667F, 16.666666F, 2.039763F, 16.666666F, 2.5F);
      ((Path)localObject2).lineTo(16.666666F, 2.5F);
      ((Path)localObject2).lineTo(16.666666F, 17.5F);
      ((Path)localObject2).cubicTo(16.666666F, 17.960238F, 16.293571F, 18.333334F, 15.833333F, 18.333334F);
      ((Path)localObject2).lineTo(15.833333F, 18.333334F);
      ((Path)localObject2).lineTo(4.166667F, 18.333334F);
      ((Path)localObject2).cubicTo(3.70643F, 18.333334F, 3.333333F, 17.960238F, 3.333333F, 17.5F);
      ((Path)localObject2).lineTo(3.333333F, 17.5F);
      ((Path)localObject2).lineTo(3.333333F, 2.5F);
      ((Path)localObject2).cubicTo(3.333333F, 2.039763F, 3.70643F, 1.666667F, 4.166667F, 1.666667F);
      ((Path)localObject2).lineTo(4.166667F, 1.666667F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(9.166667F, 13.333333F);
      ((Path)localObject2).lineTo(5.833334F, 13.333333F);
      ((Path)localObject2).lineTo(5.833334F, 14.583333F);
      ((Path)localObject2).lineTo(9.166667F, 14.583333F);
      ((Path)localObject2).lineTo(9.166667F, 13.333333F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(9.166667F, 10.833333F);
      ((Path)localObject2).lineTo(5.833334F, 10.833333F);
      ((Path)localObject2).lineTo(5.833334F, 12.083333F);
      ((Path)localObject2).lineTo(9.166667F, 12.083333F);
      ((Path)localObject2).lineTo(9.166667F, 10.833333F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(12.083333F, 8.333333F);
      ((Path)localObject2).lineTo(5.833334F, 8.333333F);
      ((Path)localObject2).lineTo(5.833334F, 9.583333F);
      ((Path)localObject2).lineTo(12.083333F, 9.583333F);
      ((Path)localObject2).lineTo(12.083333F, 8.333333F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(7.083334F, 4.166667F);
      ((Path)localObject2).cubicTo(6.392977F, 4.166667F, 5.833334F, 4.726311F, 5.833334F, 5.416667F);
      ((Path)localObject2).cubicTo(5.833334F, 6.107023F, 6.392977F, 6.666667F, 7.083334F, 6.666667F);
      ((Path)localObject2).cubicTo(7.773689F, 6.666667F, 8.333333F, 6.107023F, 8.333333F, 5.416667F);
      ((Path)localObject2).cubicTo(8.333333F, 4.726311F, 7.773689F, 4.166667F, 7.083334F, 4.166667F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 2);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.restore();
      localCanvas.restore();
      localCanvas.restore();
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.float_ball_state_message
 * JD-Core Version:    0.7.0.1
 */