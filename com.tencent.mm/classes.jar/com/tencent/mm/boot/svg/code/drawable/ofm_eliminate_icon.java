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

public class ofm_eliminate_icon
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
      localObject2 = c.setMatrixFloatArray((float[])localObject2, 1.0F, 0.0F, 23.0F, 0.0F, 1.0F, 12.0F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject2);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject1 = c.instancePaint(localPaint1, paramVarArgs);
      localObject2 = c.instancePath(paramVarArgs);
      ((Path)localObject2).moveTo(12.0F, 3.0F);
      ((Path)localObject2).cubicTo(19.75098F, -0.9802127F, 29.384819F, -1.150261F, 37.0F, 3.0F);
      ((Path)localObject2).cubicTo(44.480835F, 7.07208F, 49.642891F, 15.314427F, 50.0F, 24.0F);
      ((Path)localObject2).cubicTo(50.31316F, 31.679087F, 47.391994F, 39.1012F, 44.0F, 46.0F);
      ((Path)localObject2).cubicTo(38.738548F, 54.725651F, 32.14592F, 62.677914F, 25.0F, 70.0F);
      ((Path)localObject2).cubicTo(18.02029F, 62.857967F, 11.607736F, 55.075748F, 7.0F, 46.0F);
      ((Path)localObject2).cubicTo(3.114351F, 40.12149F, 0.2832232F, 33.219524F, -3.552714E-015F, 26.0F);
      ((Path)localObject2).cubicTo(-0.2870041F, 16.934889F, 4.584938F, 7.932325F, 12.0F, 3.0F);
      ((Path)localObject2).lineTo(12.0F, 3.0F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(14.0F, 18.0F);
      ((Path)localObject2).cubicTo(16.561224F, 21.426405F, 19.785715F, 24.075825F, 23.0F, 27.0F);
      ((Path)localObject2).cubicTo(19.82653F, 29.865299F, 16.67347F, 32.495094F, 14.0F, 36.0F);
      ((Path)localObject2).cubicTo(14.928572F, 36.439785F, 15.72449F, 37.2248F, 17.0F, 38.0F);
      ((Path)localObject2).cubicTo(19.846939F, 35.56646F, 22.571428F, 32.504906F, 26.0F, 30.0F);
      ((Path)localObject2).cubicTo(28.37755F, 32.465656F, 31.214285F, 35.164139F, 34.0F, 38.0F);
      ((Path)localObject2).cubicTo(35.367348F, 37.381802F, 36.336735F, 36.439785F, 37.0F, 35.0F);
      ((Path)localObject2).cubicTo(34.07143F, 32.455845F, 31.255102F, 29.718109F, 28.0F, 27.0F);
      ((Path)localObject2).cubicTo(31.285715F, 24.124889F, 34.459183F, 21.504906F, 37.0F, 18.0F);
      ((Path)localObject2).cubicTo(36.204082F, 17.550402F, 35.397961F, 16.7752F, 35.0F, 16.0F);
      ((Path)localObject2).cubicTo(31.265306F, 18.433542F, 28.55102F, 21.495094F, 26.0F, 24.0F);
      ((Path)localObject2).cubicTo(22.724489F, 21.514719F, 19.867348F, 18.79661F, 17.0F, 16.0F);
      ((Path)localObject2).cubicTo(16.020409F, 16.765388F, 15.020409F, 17.491526F, 14.0F, 18.0F);
      ((Path)localObject2).lineTo(14.0F, 18.0F);
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
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.ofm_eliminate_icon
 * JD-Core Version:    0.7.0.1
 */