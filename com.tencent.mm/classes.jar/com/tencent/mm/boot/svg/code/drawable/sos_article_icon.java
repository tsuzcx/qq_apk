package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.c;

public class sos_article_icon
  extends c
{
  private final int height = 42;
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
      return 42;
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
      localObject3 = c.setMatrixFloatArray((float[])localObject3, 1.0F, 0.0F, 4.307692F, 0.0F, 1.0F, 2.076923F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject2).reset();
      ((Matrix)localObject2).setValues((float[])localObject3);
      localCanvas.concat((Matrix)localObject2);
      localCanvas.save();
      localObject2 = c.instancePaint((Paint)localObject1, paramVarArgs);
      ((Paint)localObject2).setColor(-4210753);
      ((Paint)localObject2).setStrokeWidth(2.3F);
      localObject3 = c.instancePath(paramVarArgs);
      ((Path)localObject3).moveTo(0.0F, 1.648806F);
      ((Path)localObject3).cubicTo(0.0F, 0.7381957F, 0.7381957F, 0.0F, 1.648806F, 0.0F);
      ((Path)localObject3).lineTo(30.658888F, 0.0F);
      ((Path)localObject3).cubicTo(31.569498F, 0.0F, 32.307693F, 0.7381957F, 32.307693F, 1.648806F);
      ((Path)localObject3).lineTo(32.307693F, 36.351192F);
      ((Path)localObject3).cubicTo(32.307693F, 37.261803F, 31.569498F, 38.0F, 30.658888F, 38.0F);
      ((Path)localObject3).lineTo(1.648806F, 38.0F);
      ((Path)localObject3).cubicTo(0.7381957F, 38.0F, 0.0F, 37.261803F, 0.0F, 36.351192F);
      ((Path)localObject3).lineTo(0.0F, 1.648806F);
      ((Path)localObject3).close();
      localCanvas.drawPath((Path)localObject3, (Paint)localObject2);
      localCanvas.restore();
      localCanvas.save();
      localObject2 = c.instancePaint(localPaint, paramVarArgs);
      localObject3 = c.instancePaint((Paint)localObject1, paramVarArgs);
      ((Paint)localObject2).setColor(-4737097);
      ((Paint)localObject3).setColor(-4737097);
      ((Paint)localObject3).setStrokeWidth(0.6F);
      Path localPath = c.instancePath(paramVarArgs);
      localPath.moveTo(4.038462F, 14.942307F);
      localPath.lineTo(21.0F, 14.942307F);
      localPath.lineTo(21.0F, 16.602564F);
      localPath.lineTo(4.038462F, 16.602564F);
      localPath.lineTo(4.038462F, 14.942307F);
      localPath.close();
      localCanvas.drawPath(localPath, (Paint)localObject2);
      localCanvas.drawPath(localPath, (Paint)localObject3);
      localCanvas.restore();
      localCanvas.save();
      localObject2 = c.instancePaint(localPaint, paramVarArgs);
      localObject3 = c.instancePaint((Paint)localObject1, paramVarArgs);
      ((Paint)localObject2).setColor(-4737097);
      ((Paint)localObject3).setColor(-4737097);
      ((Paint)localObject3).setStrokeWidth(0.6F);
      localPath = c.instancePath(paramVarArgs);
      localPath.moveTo(4.038462F, 19.923077F);
      localPath.lineTo(12.923077F, 19.923077F);
      localPath.lineTo(12.923077F, 21.583332F);
      localPath.lineTo(4.038462F, 21.583332F);
      localPath.lineTo(4.038462F, 19.923077F);
      localPath.close();
      localCanvas.drawPath(localPath, (Paint)localObject2);
      localCanvas.drawPath(localPath, (Paint)localObject3);
      localCanvas.restore();
      localCanvas.save();
      localObject2 = c.instancePaint(localPaint, paramVarArgs);
      localObject1 = c.instancePaint((Paint)localObject1, paramVarArgs);
      ((Paint)localObject2).setColor(-4737097);
      ((Paint)localObject1).setColor(-4737097);
      ((Paint)localObject1).setStrokeWidth(0.6F);
      localObject3 = c.instancePath(paramVarArgs);
      ((Path)localObject3).moveTo(4.038462F, 24.903847F);
      ((Path)localObject3).lineTo(14.538462F, 24.903847F);
      ((Path)localObject3).lineTo(14.538462F, 26.564102F);
      ((Path)localObject3).lineTo(4.038462F, 26.564102F);
      ((Path)localObject3).lineTo(4.038462F, 24.903847F);
      ((Path)localObject3).close();
      localCanvas.drawPath((Path)localObject3, (Paint)localObject2);
      localCanvas.drawPath((Path)localObject3, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.save();
      localPaint = c.instancePaint(localPaint, paramVarArgs);
      localPaint.setColor(-4737097);
      localObject1 = c.instancePath(paramVarArgs);
      ((Path)localObject1).moveTo(6.369543F, 6.0F);
      ((Path)localObject1).cubicTo(7.656963F, 6.0F, 8.700624F, 7.072651F, 8.700624F, 8.395833F);
      ((Path)localObject1).cubicTo(8.700624F, 9.719015F, 7.656963F, 10.791666F, 6.369543F, 10.791666F);
      ((Path)localObject1).cubicTo(5.082122F, 10.791666F, 4.038462F, 9.719015F, 4.038462F, 8.395833F);
      ((Path)localObject1).cubicTo(4.038462F, 7.072651F, 5.082122F, 6.0F, 6.369543F, 6.0F);
      ((Path)localObject1).close();
      localCanvas.drawPath((Path)localObject1, localPaint);
      localCanvas.restore();
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.sos_article_icon
 * JD-Core Version:    0.7.0.1
 */