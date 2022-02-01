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

public class c2c_remittance_icon
  extends c
{
  private final int height = 30;
  private final int width = 30;
  
  public int doCommand(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 30;
      return 30;
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
      localObject2 = c.setMatrixFloatArray((float[])localObject2, 1.0F, 0.0F, -2.0F, 0.0F, 1.0F, -2.0F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject2);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject1 = c.instancePaint(localPaint1, paramVarArgs);
      localObject2 = c.instancePath(paramVarArgs);
      ((Path)localObject2).moveTo(17.0F, 2.833333F);
      ((Path)localObject2).cubicTo(24.824034F, 2.833333F, 31.166666F, 9.175966F, 31.166666F, 17.0F);
      ((Path)localObject2).cubicTo(31.166666F, 24.824034F, 24.824034F, 31.166666F, 17.0F, 31.166666F);
      ((Path)localObject2).cubicTo(9.175966F, 31.166666F, 2.833333F, 24.824034F, 2.833333F, 17.0F);
      ((Path)localObject2).cubicTo(2.833333F, 9.175966F, 9.175966F, 2.833333F, 17.0F, 2.833333F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(17.0F, 4.533333F);
      ((Path)localObject2).cubicTo(10.11485F, 4.533333F, 4.533333F, 10.11485F, 4.533333F, 17.0F);
      ((Path)localObject2).cubicTo(4.533333F, 23.885149F, 10.11485F, 29.466667F, 17.0F, 29.466667F);
      ((Path)localObject2).cubicTo(23.885149F, 29.466667F, 29.466667F, 23.885149F, 29.466667F, 17.0F);
      ((Path)localObject2).cubicTo(29.466667F, 10.11485F, 23.885149F, 4.533333F, 17.0F, 4.533333F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(23.375F, 18.246666F);
      ((Path)localObject2).cubicTo(23.766201F, 18.246666F, 24.083334F, 18.563799F, 24.083334F, 18.955F);
      ((Path)localObject2).cubicTo(24.083334F, 19.164644F, 23.990467F, 19.363518F, 23.829727F, 19.498102F);
      ((Path)localObject2).lineTo(19.351057F, 23.248005F);
      ((Path)localObject2).cubicTo(19.111101F, 23.448915F, 18.753706F, 23.417263F, 18.552795F, 23.177305F);
      ((Path)localObject2).cubicTo(18.392162F, 22.985455F, 18.376373F, 22.71096F, 18.51395F, 22.501957F);
      ((Path)localObject2).lineTo(20.195972F, 19.946667F);
      ((Path)localObject2).lineTo(9.981667F, 19.946667F);
      ((Path)localObject2).lineTo(9.981667F, 18.246666F);
      ((Path)localObject2).lineTo(23.375F, 18.246666F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(15.512205F, 10.827898F);
      ((Path)localObject2).cubicTo(15.672838F, 11.019749F, 15.688626F, 11.294245F, 15.55105F, 11.503247F);
      ((Path)localObject2).lineTo(13.869027F, 14.058537F);
      ((Path)localObject2).lineTo(24.083334F, 14.058537F);
      ((Path)localObject2).lineTo(24.083334F, 15.758537F);
      ((Path)localObject2).lineTo(10.690001F, 15.758537F);
      ((Path)localObject2).cubicTo(10.298799F, 15.758537F, 9.981667F, 15.441405F, 9.981667F, 15.050203F);
      ((Path)localObject2).cubicTo(9.981667F, 14.840561F, 10.074533F, 14.641686F, 10.235272F, 14.507103F);
      ((Path)localObject2).lineTo(14.713943F, 10.757199F);
      ((Path)localObject2).cubicTo(14.953899F, 10.556288F, 15.311294F, 10.587941F, 15.512205F, 10.827898F);
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
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.c2c_remittance_icon
 * JD-Core Version:    0.7.0.1
 */