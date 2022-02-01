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

public class icons_filled_scissor
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
      localPaint1.setColor(-436207616);
      localObject2 = c.setMatrixFloatArray((float[])localObject2, 1.0F, 0.0F, 9.0F, 0.0F, 1.0F, 9.0F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject2);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject1 = c.instancePaint(localPaint1, paramVarArgs);
      localObject2 = c.instancePath(paramVarArgs);
      ((Path)localObject2).moveTo(12.176471F, 28.852942F);
      ((Path)localObject2).cubicTo(18.90135F, 28.852942F, 24.352942F, 34.304531F, 24.352942F, 41.029411F);
      ((Path)localObject2).cubicTo(24.352942F, 47.754292F, 18.90135F, 53.205883F, 12.176471F, 53.205883F);
      ((Path)localObject2).cubicTo(5.451592F, 53.205883F, 0.0F, 47.754292F, 0.0F, 41.029411F);
      ((Path)localObject2).cubicTo(0.0F, 34.304531F, 5.451592F, 28.852942F, 12.176471F, 28.852942F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(41.823528F, 28.852942F);
      ((Path)localObject2).cubicTo(48.548409F, 28.852942F, 54.0F, 34.304531F, 54.0F, 41.029411F);
      ((Path)localObject2).cubicTo(54.0F, 47.754292F, 48.548409F, 53.205883F, 41.823528F, 53.205883F);
      ((Path)localObject2).cubicTo(35.098652F, 53.205883F, 29.647058F, 47.754292F, 29.647058F, 41.029411F);
      ((Path)localObject2).cubicTo(29.647058F, 34.304531F, 35.098652F, 28.852942F, 41.823528F, 28.852942F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(12.176471F, 34.676472F);
      ((Path)localObject2).cubicTo(8.667838F, 34.676472F, 5.823529F, 37.520779F, 5.823529F, 41.029411F);
      ((Path)localObject2).cubicTo(5.823529F, 44.538044F, 8.667838F, 47.382355F, 12.176471F, 47.382355F);
      ((Path)localObject2).cubicTo(15.685103F, 47.382355F, 18.529411F, 44.538044F, 18.529411F, 41.029411F);
      ((Path)localObject2).cubicTo(18.529411F, 37.520779F, 15.685103F, 34.676472F, 12.176471F, 34.676472F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(41.823528F, 34.676472F);
      ((Path)localObject2).cubicTo(38.314896F, 34.676472F, 35.470589F, 37.520779F, 35.470589F, 41.029411F);
      ((Path)localObject2).cubicTo(35.470589F, 44.538044F, 38.314896F, 47.382355F, 41.823528F, 47.382355F);
      ((Path)localObject2).cubicTo(45.332161F, 47.382355F, 48.176472F, 44.538044F, 48.176472F, 41.029411F);
      ((Path)localObject2).cubicTo(48.176472F, 37.520779F, 45.332161F, 34.676472F, 41.823528F, 34.676472F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(46.466427F, 0.1372338F);
      ((Path)localObject2).lineTo(46.873055F, 0.5711756F);
      ((Path)localObject2).cubicTo(49.730167F, 3.826816F, 49.841122F, 8.65159F, 47.205925F, 12.029105F);
      ((Path)localObject2).lineTo(46.829556F, 12.480422F);
      ((Path)localObject2).lineTo(46.466427F, 12.865156F);
      ((Path)localObject2).lineTo(26.99898F, 32.330177F);
      ((Path)localObject2).lineTo(7.533961F, 12.865156F);
      ((Path)localObject2).lineTo(7.170833F, 12.480422F);
      ((Path)localObject2).cubicTo(4.154855F, 9.093448F, 4.140355F, 3.9748F, 7.127334F, 0.5711756F);
      ((Path)localObject2).lineTo(7.533961F, 0.1372338F);
      ((Path)localObject2).lineTo(26.998922F, 19.604235F);
      ((Path)localObject2).lineTo(46.466427F, 0.1372338F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 2);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.icons_filled_scissor
 * JD-Core Version:    0.7.0.1
 */