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

public class icon_filled_voice_call
  extends c
{
  private final int height = 40;
  private final int width = 40;
  
  public int doCommand(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 40;
      return 40;
      Canvas localCanvas = (Canvas)paramVarArgs[0];
      paramVarArgs = (Looper)paramVarArgs[1];
      Object localObject1 = c.instanceMatrix(paramVarArgs);
      Object localObject2 = c.instanceMatrixArray(paramVarArgs);
      Paint localPaint = c.instancePaint(paramVarArgs);
      localPaint.setFlags(385);
      localPaint.setStyle(Paint.Style.FILL);
      Object localObject3 = c.instancePaint(paramVarArgs);
      ((Paint)localObject3).setFlags(385);
      ((Paint)localObject3).setStyle(Paint.Style.STROKE);
      localPaint.setColor(-16777216);
      ((Paint)localObject3).setStrokeWidth(1.0F);
      ((Paint)localObject3).setStrokeCap(Paint.Cap.BUTT);
      ((Paint)localObject3).setStrokeJoin(Paint.Join.MITER);
      ((Paint)localObject3).setStrokeMiter(4.0F);
      ((Paint)localObject3).setPathEffect(null);
      c.instancePaint((Paint)localObject3, paramVarArgs).setStrokeWidth(1.0F);
      localObject3 = c.instancePath(paramVarArgs);
      ((Path)localObject3).moveTo(0.0F, 0.0F);
      ((Path)localObject3).lineTo(40.0F, 0.0F);
      ((Path)localObject3).lineTo(40.0F, 40.0F);
      ((Path)localObject3).lineTo(0.0F, 40.0F);
      ((Path)localObject3).lineTo(0.0F, 0.0F);
      ((Path)localObject3).close();
      localCanvas.save();
      localPaint = c.instancePaint(localPaint, paramVarArgs);
      localPaint.setColor(-16777216);
      localObject2 = c.setMatrixFloatArray((float[])localObject2, 1.0F, 0.0F, 4.166667F, 0.0F, 1.0F, 5.0F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject2);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject1 = c.instancePaint(localPaint, paramVarArgs);
      localObject2 = c.instancePath(paramVarArgs);
      ((Path)localObject2).moveTo(24.31072F, 21.053984F);
      ((Path)localObject2).cubicTo(23.98513F, 20.951157F, 23.849468F, 21.002571F, 23.55101F, 21.156813F);
      ((Path)localObject2).cubicTo(22.574242F, 21.670952F, 20.186581F, 22.904884F, 18.77569F, 23.598972F);
      ((Path)localObject2).cubicTo(18.422968F, 23.778921F, 18.043114F, 23.881748F, 17.608994F, 23.881748F);
      ((Path)localObject2).cubicTo(17.147741F, 23.881748F, 16.740753F, 23.753214F, 16.388031F, 23.547558F);
      ((Path)localObject2).cubicTo(14.407358F, 22.44216F, 12.535215F, 21.156813F, 10.934398F, 19.614395F);
      ((Path)localObject2).cubicTo(9.33358F, 18.097687F, 7.976955F, 16.323908F, 6.810258F, 14.447301F);
      ((Path)localObject2).cubicTo(6.593198F, 14.113111F, 6.457535F, 13.701799F, 6.457535F, 13.290488F);
      ((Path)localObject2).cubicTo(6.457535F, 12.904884F, 6.566065F, 12.51928F, 6.755993F, 12.18509F);
      ((Path)localObject2).cubicTo(7.48857F, 10.822622F, 8.790931F, 8.560412F, 9.33358F, 7.660668F);
      ((Path)localObject2).cubicTo(9.496375F, 7.377892F, 9.55064F, 7.223651F, 9.44211F, 6.940874F);
      ((Path)localObject2).lineTo(7.135848F, 1.131105F);
      ((Path)localObject2).cubicTo(6.83739F, 0.4627249F, 6.159078F, 0.02570694F, 5.345103F, 0.0F);
      ((Path)localObject2).cubicTo(5.019513F, 0.0F, 4.639658F, 0.128535F, 4.55826F, 0.1542417F);
      ((Path)localObject2).cubicTo(1.899275F, 1.079692F, 0.0F, 3.470437F, 0.0F, 6.298201F);
      ((Path)localObject2).cubicTo(0.0F, 7.095116F, 0.21706F, 7.840617F, 0.2441925F, 8.020566F);
      ((Path)localObject2).cubicTo(1.546553F, 13.419024F, 4.44973F, 18.226221F, 8.438208F, 22.005142F);
      ((Path)localObject2).cubicTo(12.426685F, 25.784061F, 17.500463F, 28.534704F, 23.198288F, 29.768637F);
      ((Path)localObject2).cubicTo(23.388216F, 29.820051F, 24.175058F, 30.0F, 25.016167F, 30.0F);
      ((Path)localObject2).cubicTo(28.00074F, 30.0F, 30.524063F, 28.200514F, 31.500834F, 25.681234F);
      ((Path)localObject2).cubicTo(31.527966F, 25.604113F, 31.690762F, 25.244215F, 31.663628F, 24.935732F);
      ((Path)localObject2).cubicTo(31.609364F, 24.164524F, 31.148111F, 23.521851F, 30.442665F, 23.239075F);
      ((Path)localObject2).lineTo(24.31072F, 21.053984F);
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
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.icon_filled_voice_call
 * JD-Core Version:    0.7.0.1
 */