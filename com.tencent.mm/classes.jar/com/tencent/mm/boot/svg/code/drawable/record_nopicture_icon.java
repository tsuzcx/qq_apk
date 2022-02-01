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

public class record_nopicture_icon
  extends c
{
  private final int height = 180;
  private final int width = 180;
  
  public int doCommand(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 180;
      return 180;
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
      localPaint1.setColor(-1315861);
      localObject2 = c.setMatrixFloatArray((float[])localObject2, 1.0F, 0.0F, 0.0F, 0.0F, 1.0F, 20.0F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject2);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject1 = c.instancePaint(localPaint1, paramVarArgs);
      localObject2 = c.instancePath(paramVarArgs);
      ((Path)localObject2).moveTo(171.0F, 90.189262F);
      ((Path)localObject2).lineTo(171.0F, 9.032258F);
      ((Path)localObject2).lineTo(9.0F, 9.032258F);
      ((Path)localObject2).lineTo(9.0F, 89.960342F);
      ((Path)localObject2).lineTo(60.553738F, 41.650661F);
      ((Path)localObject2).lineTo(121.92021F, 98.156937F);
      ((Path)localObject2).lineTo(113.13358F, 80.026909F);
      ((Path)localObject2).lineTo(138.16164F, 60.600388F);
      ((Path)localObject2).lineTo(171.0F, 90.189262F);
      ((Path)localObject2).lineTo(171.0F, 90.189262F);
      ((Path)localObject2).lineTo(171.0F, 90.189262F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(4.494371F, 0.0F);
      ((Path)localObject2).cubicTo(2.012198F, 0.0F, 0.0F, 2.019495F, 0.0F, 4.519171F);
      ((Path)localObject2).lineTo(0.0F, 135.48083F);
      ((Path)localObject2).cubicTo(0.0F, 137.9767F, 2.021484F, 140.0F, 4.494371F, 140.0F);
      ((Path)localObject2).lineTo(175.50563F, 140.0F);
      ((Path)localObject2).cubicTo(177.98781F, 140.0F, 180.0F, 137.9805F, 180.0F, 135.48083F);
      ((Path)localObject2).lineTo(180.0F, 4.519171F);
      ((Path)localObject2).cubicTo(180.0F, 2.023302F, 177.97852F, 0.0F, 175.50563F, 0.0F);
      ((Path)localObject2).lineTo(4.494371F, 0.0F);
      ((Path)localObject2).lineTo(4.494371F, 0.0F);
      ((Path)localObject2).lineTo(4.494371F, 0.0F);
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
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.record_nopicture_icon
 * JD-Core Version:    0.7.0.1
 */