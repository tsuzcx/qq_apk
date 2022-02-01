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

public class icons_outlined_quote_voice
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
      Object localObject1 = c.instanceMatrix(paramVarArgs);
      Object localObject2 = c.instanceMatrixArray(paramVarArgs);
      Object localObject3 = c.instancePaint(paramVarArgs);
      ((Paint)localObject3).setFlags(385);
      ((Paint)localObject3).setStyle(Paint.Style.FILL);
      Object localObject4 = c.instancePaint(paramVarArgs);
      ((Paint)localObject4).setFlags(385);
      ((Paint)localObject4).setStyle(Paint.Style.STROKE);
      ((Paint)localObject3).setColor(-16777216);
      ((Paint)localObject4).setStrokeWidth(1.0F);
      ((Paint)localObject4).setStrokeCap(Paint.Cap.BUTT);
      ((Paint)localObject4).setStrokeJoin(Paint.Join.MITER);
      ((Paint)localObject4).setStrokeMiter(4.0F);
      ((Paint)localObject4).setPathEffect(null);
      c.instancePaint((Paint)localObject4, paramVarArgs).setStrokeWidth(1.0F);
      localObject3 = c.instancePaint((Paint)localObject3, paramVarArgs);
      ((Paint)localObject3).setColor(-16777216);
      localCanvas.save();
      localObject4 = c.setMatrixFloatArray((float[])localObject2, -1.0F, 0.0F, 58.5F, 0.0F, 1.0F, 4.5F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject4);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject2 = c.instancePaint((Paint)localObject3, paramVarArgs);
      localObject3 = c.setMatrixFloatArray((float[])localObject4, -1.0F, 0.0F, 45.0F, 0.0F, 1.0F, 0.0F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject3);
      localCanvas.concat((Matrix)localObject1);
      localObject1 = c.instancePath(paramVarArgs);
      ((Path)localObject1).moveTo(45.0F, 31.5F);
      ((Path)localObject1).cubicTo(45.0F, 43.80101F, 39.963615F, 54.937534F, 31.820807F, 62.999008F);
      ((Path)localObject1).lineTo(27.822594F, 59.043167F);
      ((Path)localObject1).cubicTo(34.825409F, 51.969753F, 39.150002F, 42.23991F, 39.150002F, 31.5F);
      ((Path)localObject1).cubicTo(39.150002F, 20.760595F, 34.825813F, 11.031158F, 27.82358F, 3.957829F);
      ((Path)localObject1).lineTo(31.819805F, -1.314504E-013F);
      ((Path)localObject1).cubicTo(39.963203F, 8.061553F, 45.0F, 19.198484F, 45.0F, 31.5F);
      ((Path)localObject1).close();
      ((Path)localObject1).moveTo(29.25F, 31.5F);
      ((Path)localObject1).cubicTo(29.25F, 39.49548F, 25.976496F, 46.734077F, 20.683876F, 51.974007F);
      ((Path)localObject1).lineTo(16.629457F, 47.962723F);
      ((Path)localObject1).cubicTo(20.815128F, 43.734924F, 23.4F, 37.919327F, 23.4F, 31.5F);
      ((Path)localObject1).cubicTo(23.4F, 25.081179F, 20.815536F, 19.265991F, 16.630445F, 15.038276F);
      ((Path)localObject1).lineTo(20.683878F, 11.025995F);
      ((Path)localObject1).cubicTo(25.976496F, 16.265926F, 29.25F, 23.50452F, 29.25F, 31.5F);
      ((Path)localObject1).close();
      ((Path)localObject1).moveTo(9.546944F, 22.050993F);
      ((Path)localObject1).cubicTo(11.989374F, 24.469379F, 13.5F, 27.810051F, 13.5F, 31.5F);
      ((Path)localObject1).cubicTo(13.5F, 35.190456F, 11.988961F, 38.531532F, 9.545941F, 40.950001F);
      ((Path)localObject1).lineTo(0.0F, 31.5F);
      ((Path)localObject1).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject1, 1);
      localCanvas.drawPath((Path)localObject1, (Paint)localObject2);
      localCanvas.restore();
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.icons_outlined_quote_voice
 * JD-Core Version:    0.7.0.1
 */