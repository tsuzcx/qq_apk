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

public class amp3
  extends c
{
  private final int height = 51;
  private final int width = 34;
  
  public int doCommand(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 34;
      return 51;
      Canvas localCanvas = (Canvas)paramVarArgs[0];
      paramVarArgs = (Looper)paramVarArgs[1];
      Object localObject1 = c.instanceMatrix(paramVarArgs);
      Object localObject2 = c.instanceMatrixArray(paramVarArgs);
      Paint localPaint1 = c.instancePaint(paramVarArgs);
      localPaint1.setFlags(385);
      localPaint1.setStyle(Paint.Style.FILL);
      Paint localPaint2 = c.instancePaint(paramVarArgs);
      localPaint2.setFlags(385);
      localPaint2.setStyle(Paint.Style.STROKE);
      localPaint1.setColor(-16777216);
      localPaint2.setStrokeWidth(1.0F);
      localPaint2.setStrokeCap(Paint.Cap.BUTT);
      localPaint2.setStrokeJoin(Paint.Join.MITER);
      localPaint2.setStrokeMiter(4.0F);
      localPaint2.setPathEffect(null);
      c.instancePaint(localPaint2, paramVarArgs).setStrokeWidth(1.0F);
      localCanvas.save();
      localPaint1 = c.instancePaint(localPaint1, paramVarArgs);
      localPaint1.setColor(-1);
      localObject2 = c.setMatrixFloatArray((float[])localObject2, 1.0F, 0.0F, -166.0F, 0.0F, 1.0F, -50.0F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject2);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject2 = c.setMatrixFloatArray((float[])localObject2, 1.0F, 0.0F, 166.66667F, 0.0F, 1.0F, 50.25F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject2);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject1 = c.instancePaint(localPaint1, paramVarArgs);
      localObject2 = c.instancePath(paramVarArgs);
      ((Path)localObject2).moveTo(0.0F, 46.666668F);
      ((Path)localObject2).lineTo(10.0F, 46.666668F);
      ((Path)localObject2).lineTo(10.0F, 50.0F);
      ((Path)localObject2).lineTo(0.0F, 50.0F);
      ((Path)localObject2).lineTo(0.0F, 46.666668F);
      ((Path)localObject2).close();
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.save();
      localObject1 = c.instancePaint(localPaint1, paramVarArgs);
      localObject2 = c.instancePath(paramVarArgs);
      ((Path)localObject2).moveTo(0.0F, 40.0F);
      ((Path)localObject2).lineTo(13.333333F, 40.0F);
      ((Path)localObject2).lineTo(13.333333F, 43.333332F);
      ((Path)localObject2).lineTo(0.0F, 43.333332F);
      ((Path)localObject2).lineTo(0.0F, 40.0F);
      ((Path)localObject2).close();
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.save();
      localObject1 = c.instancePaint(localPaint1, paramVarArgs);
      localObject2 = c.instancePath(paramVarArgs);
      ((Path)localObject2).moveTo(0.0F, 33.333332F);
      ((Path)localObject2).lineTo(16.666666F, 33.333332F);
      ((Path)localObject2).lineTo(16.666666F, 36.666664F);
      ((Path)localObject2).lineTo(0.0F, 36.666664F);
      ((Path)localObject2).lineTo(0.0F, 33.333332F);
      ((Path)localObject2).close();
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localObject1 = c.instancePaint(localPaint1, paramVarArgs);
      ((Paint)localObject1).setColor(-1);
      localObject2 = c.instancePath(paramVarArgs);
      ((Path)localObject2).moveTo(0.0F, 26.666666F);
      ((Path)localObject2).lineTo(20.0F, 26.666666F);
      ((Path)localObject2).lineTo(20.0F, 30.0F);
      ((Path)localObject2).lineTo(0.0F, 30.0F);
      ((Path)localObject2).lineTo(0.0F, 26.666666F);
      ((Path)localObject2).close();
      localCanvas.saveLayerAlpha(null, 76, 31);
      localCanvas.drawPath((Path)localObject2, c.instancePaint((Paint)localObject1, paramVarArgs));
      localCanvas.restore();
      localObject1 = c.instancePaint(localPaint1, paramVarArgs);
      ((Paint)localObject1).setColor(-1);
      localObject2 = c.instancePath(paramVarArgs);
      ((Path)localObject2).moveTo(0.0F, 20.0F);
      ((Path)localObject2).lineTo(23.333334F, 20.0F);
      ((Path)localObject2).lineTo(23.333334F, 23.333334F);
      ((Path)localObject2).lineTo(0.0F, 23.333334F);
      ((Path)localObject2).lineTo(0.0F, 20.0F);
      ((Path)localObject2).close();
      localCanvas.saveLayerAlpha(null, 76, 31);
      localCanvas.drawPath((Path)localObject2, c.instancePaint((Paint)localObject1, paramVarArgs));
      localCanvas.restore();
      localObject1 = c.instancePaint(localPaint1, paramVarArgs);
      ((Paint)localObject1).setColor(-1);
      localObject2 = c.instancePath(paramVarArgs);
      ((Path)localObject2).moveTo(0.0F, 13.333333F);
      ((Path)localObject2).lineTo(26.666666F, 13.333333F);
      ((Path)localObject2).lineTo(26.666666F, 16.666666F);
      ((Path)localObject2).lineTo(0.0F, 16.666666F);
      ((Path)localObject2).lineTo(0.0F, 13.333333F);
      ((Path)localObject2).close();
      localCanvas.saveLayerAlpha(null, 76, 31);
      localCanvas.drawPath((Path)localObject2, c.instancePaint((Paint)localObject1, paramVarArgs));
      localCanvas.restore();
      localObject2 = c.instancePaint(localPaint1, paramVarArgs);
      ((Paint)localObject2).setColor(-1);
      localObject1 = c.instancePath(paramVarArgs);
      ((Path)localObject1).moveTo(0.0F, 6.666667F);
      ((Path)localObject1).lineTo(30.0F, 6.666667F);
      ((Path)localObject1).lineTo(30.0F, 10.0F);
      ((Path)localObject1).lineTo(0.0F, 10.0F);
      ((Path)localObject1).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject1, 1);
      localCanvas.saveLayerAlpha(null, 76, 31);
      localObject2 = c.instancePaint((Paint)localObject2, paramVarArgs);
      WeChatSVGRenderC2Java.setFillType((Path)localObject1, 2);
      localCanvas.drawPath((Path)localObject1, (Paint)localObject2);
      localCanvas.restore();
      localPaint1 = c.instancePaint(localPaint1, paramVarArgs);
      localPaint1.setColor(-1);
      localObject1 = c.instancePath(paramVarArgs);
      ((Path)localObject1).moveTo(0.0F, 0.0F);
      ((Path)localObject1).lineTo(33.333332F, 0.0F);
      ((Path)localObject1).lineTo(33.333332F, 3.333333F);
      ((Path)localObject1).lineTo(0.0F, 3.333333F);
      ((Path)localObject1).lineTo(0.0F, 0.0F);
      ((Path)localObject1).close();
      localCanvas.saveLayerAlpha(null, 76, 31);
      localCanvas.drawPath((Path)localObject1, c.instancePaint(localPaint1, paramVarArgs));
      localCanvas.restore();
      localCanvas.restore();
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.amp3
 * JD-Core Version:    0.7.0.1
 */