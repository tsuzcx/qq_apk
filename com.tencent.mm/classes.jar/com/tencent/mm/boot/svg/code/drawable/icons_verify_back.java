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

public class icons_verify_back
  extends c
{
  private final int height = 28;
  private final int width = 28;
  
  public int doCommand(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 28;
      return 28;
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
      localPaint1 = c.instancePaint(localPaint1, paramVarArgs);
      localPaint1.setColor(-1);
      localCanvas.save();
      localObject2 = c.setMatrixFloatArray((float[])localObject2, 1.0F, 0.0F, 2.333333F, 0.0F, 1.0F, 2.333333F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject2);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject1 = c.instancePaint(localPaint1, paramVarArgs);
      localObject2 = c.instancePath(paramVarArgs);
      ((Path)localObject2).moveTo(11.666667F, 0.0F);
      ((Path)localObject2).cubicTo(18.109989F, 0.0F, 23.333334F, 5.223345F, 23.333334F, 11.666667F);
      ((Path)localObject2).cubicTo(23.333334F, 18.109989F, 18.109989F, 23.333334F, 11.666667F, 23.333334F);
      ((Path)localObject2).cubicTo(5.223345F, 23.333334F, 0.0F, 18.109989F, 0.0F, 11.666667F);
      ((Path)localObject2).cubicTo(0.0F, 5.223345F, 5.223345F, 0.0F, 11.666667F, 0.0F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(12.778577F, 6.416667F);
      ((Path)localObject2).lineTo(8.384757F, 10.947684F);
      ((Path)localObject2).cubicTo(8.006012F, 11.338256F, 7.999698F, 11.988565F, 8.384757F, 12.385649F);
      ((Path)localObject2).lineTo(8.384757F, 12.385649F);
      ((Path)localObject2).lineTo(12.778577F, 16.916666F);
      ((Path)localObject2).lineTo(13.99829F, 15.677083F);
      ((Path)localObject2).lineTo(10.12697F, 11.666667F);
      ((Path)localObject2).lineTo(13.99829F, 7.65625F);
      ((Path)localObject2).lineTo(12.778577F, 6.416667F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 2);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.icons_verify_back
 * JD-Core Version:    0.7.0.1
 */