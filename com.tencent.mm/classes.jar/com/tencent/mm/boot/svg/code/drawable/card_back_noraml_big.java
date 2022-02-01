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

public class card_back_noraml_big
  extends c
{
  private final int height = 96;
  private final int width = 96;
  
  public int doCommand(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 96;
      return 96;
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
      localObject2 = c.setMatrixFloatArray((float[])localObject2, 1.0F, 0.0F, 16.0F, 0.0F, 1.0F, 15.0F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject2);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.saveLayerAlpha(null, 128, 31);
      localCanvas.save();
      localObject1 = c.instancePaint(localPaint1, paramVarArgs);
      localObject2 = c.instancePath(paramVarArgs);
      ((Path)localObject2).moveTo(0.98F, 33.0F);
      ((Path)localObject2).cubicTo(11.64F, 22.32F, 22.32F, 11.64F, 33.0F, 0.98F);
      ((Path)localObject2).cubicTo(34.900002F, 2.86F, 36.799999F, 4.76F, 38.68F, 6.66F);
      ((Path)localObject2).cubicTo(31.25F, 14.11F, 23.799999F, 21.540001F, 16.370001F, 28.99F);
      ((Path)localObject2).cubicTo(32.580002F, 29.01F, 48.790001F, 28.99F, 65.0F, 29.0F);
      ((Path)localObject2).cubicTo(65.0F, 31.690001F, 65.0F, 34.369999F, 64.989998F, 37.060001F);
      ((Path)localObject2).cubicTo(48.810001F, 37.080002F, 32.619999F, 37.049999F, 16.43F, 37.07F);
      ((Path)localObject2).cubicTo(23.84F, 44.5F, 31.27F, 51.91F, 38.68F, 59.34F);
      ((Path)localObject2).cubicTo(36.799999F, 61.240002F, 34.900002F, 63.139999F, 33.0F, 65.019997F);
      ((Path)localObject2).cubicTo(22.32F, 54.360001F, 11.64F, 43.68F, 0.98F, 33.0F);
      ((Path)localObject2).lineTo(0.98F, 33.0F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 2);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.restore();
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.card_back_noraml_big
 * JD-Core Version:    0.7.0.1
 */