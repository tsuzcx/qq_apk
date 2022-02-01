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

public class icon_filled_brand_followed
  extends c
{
  private final int height = 20;
  private final int width = 20;
  
  public int doCommand(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 20;
      return 20;
      Canvas localCanvas = (Canvas)paramVarArgs[0];
      paramVarArgs = (Looper)paramVarArgs[1];
      Object localObject1 = c.instanceMatrix(paramVarArgs);
      float[] arrayOfFloat = c.instanceMatrixArray(paramVarArgs);
      Object localObject2 = c.instancePaint(paramVarArgs);
      ((Paint)localObject2).setFlags(385);
      ((Paint)localObject2).setStyle(Paint.Style.FILL);
      Paint localPaint = c.instancePaint(paramVarArgs);
      localPaint.setFlags(385);
      localPaint.setStyle(Paint.Style.STROKE);
      ((Paint)localObject2).setColor(-16777216);
      localPaint.setStrokeWidth(1.0F);
      localPaint.setStrokeCap(Paint.Cap.BUTT);
      localPaint.setStrokeJoin(Paint.Join.MITER);
      localPaint.setStrokeMiter(4.0F);
      localPaint.setPathEffect(null);
      c.instancePaint(localPaint, paramVarArgs).setStrokeWidth(1.0F);
      localCanvas.save();
      localObject2 = c.instancePaint((Paint)localObject2, paramVarArgs);
      ((Paint)localObject2).setColor(-436207616);
      arrayOfFloat = c.setMatrixFloatArray(arrayOfFloat, 1.0F, 0.0F, -372.0F, 0.0F, 1.0F, -124.0F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      arrayOfFloat = c.setMatrixFloatArray(arrayOfFloat, 1.0F, 0.0F, 366.0F, 0.0F, 1.0F, 118.0F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      arrayOfFloat = c.setMatrixFloatArray(arrayOfFloat, 1.0F, 0.0F, 6.0F, 0.0F, 1.0F, 6.0F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject1 = c.instancePaint((Paint)localObject2, paramVarArgs);
      localObject2 = c.instancePath(paramVarArgs);
      ((Path)localObject2).moveTo(13.917866F, 16.004614F);
      ((Path)localObject2).lineTo(18.110302F, 11.812178F);
      ((Path)localObject2).lineTo(18.979172F, 12.681047F);
      ((Path)localObject2).lineTo(14.352551F, 17.306339F);
      ((Path)localObject2).cubicTo(14.118257F, 17.540672F, 13.738358F, 17.540619F, 13.504077F, 17.306271F);
      ((Path)localObject2).cubicTo(13.504059F, 17.306252F, 13.504042F, 17.306234F, 13.504077F, 17.306164F);
      ((Path)localObject2).lineTo(11.227897F, 15.028761F);
      ((Path)localObject2).lineTo(11.227897F, 15.028761F);
      ((Path)localObject2).lineTo(12.084954F, 14.171703F);
      ((Path)localObject2).lineTo(13.917866F, 16.004614F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(9.916667F, 2.5F);
      ((Path)localObject2).cubicTo(11.757616F, 2.5F, 13.25F, 3.99415F, 13.25F, 5.833506F);
      ((Path)localObject2).lineTo(13.25F, 7.258488F);
      ((Path)localObject2).cubicTo(13.25F, 8.207747F, 12.750777F, 9.56905F, 12.140073F, 10.292977F);
      ((Path)localObject2).lineTo(11.838796F, 10.65011F);
      ((Path)localObject2).cubicTo(11.62527F, 10.903223F, 11.533543F, 11.186345F, 11.554481F, 11.453089F);
      ((Path)localObject2).lineTo(10.252683F, 11.452295F);
      ((Path)localObject2).cubicTo(10.235727F, 10.940444F, 10.392664F, 10.412518F, 10.739343F, 9.945456F);
      ((Path)localObject2).lineTo(10.845142F, 9.811866F);
      ((Path)localObject2).lineTo(11.14642F, 9.454733F);
      ((Path)localObject2).cubicTo(11.525756F, 9.005069F, 11.884873F, 8.072933F, 11.942092F, 7.426983F);
      ((Path)localObject2).lineTo(11.95F, 7.258488F);
      ((Path)localObject2).lineTo(11.95F, 5.833506F);
      ((Path)localObject2).cubicTo(11.95F, 4.71142F, 11.038946F, 3.8F, 9.916667F, 3.8F);
      ((Path)localObject2).cubicTo(8.846829F, 3.8F, 7.966723F, 4.630745F, 7.888924F, 5.681452F);
      ((Path)localObject2).lineTo(7.883333F, 5.832984F);
      ((Path)localObject2).lineTo(7.883333F, 7.257742F);
      ((Path)localObject2).cubicTo(7.883333F, 7.846972F, 8.209404F, 8.787188F, 8.583769F, 9.319098F);
      ((Path)localObject2).lineTo(8.686857F, 9.45347F);
      ((Path)localObject2).lineTo(8.988133F, 9.810554F);
      ((Path)localObject2).cubicTo(9.990453F, 10.998537F, 9.68577F, 12.647564F, 8.366272F, 13.396492F);
      ((Path)localObject2).lineTo(8.2155F, 13.475933F);
      ((Path)localObject2).lineTo(3.498539F, 15.777759F);
      ((Path)localObject2).cubicTo(3.443236F, 15.804746F, 3.34223F, 15.956275F, 3.310098F, 16.049063F);
      ((Path)localObject2).lineTo(3.3F, 16.09622F);
      ((Path)localObject2).lineTo(3.3F, 16.200001F);
      ((Path)localObject2).lineTo(9.916F, 16.200001F);
      ((Path)localObject2).lineTo(9.916F, 17.5F);
      ((Path)localObject2).lineTo(2.834525F, 17.5F);
      ((Path)localObject2).cubicTo(2.373629F, 17.5F, 2.0F, 17.129797F, 2.0F, 16.667969F);
      ((Path)localObject2).lineTo(2.0F, 16.09622F);
      ((Path)localObject2).cubicTo(2.0F, 15.525312F, 2.415126F, 14.859923F, 2.928415F, 14.609444F);
      ((Path)localObject2).lineTo(7.645376F, 12.307619F);
      ((Path)localObject2).cubicTo(8.329481F, 11.973783F, 8.488549F, 11.234385F, 7.994538F, 10.648866F);
      ((Path)localObject2).lineTo(7.693261F, 10.291781F);
      ((Path)localObject2).cubicTo(7.080265F, 9.565238F, 6.583334F, 8.207913F, 6.583334F, 7.257742F);
      ((Path)localObject2).lineTo(6.583334F, 5.832984F);
      ((Path)localObject2).cubicTo(6.583334F, 3.992228F, 8.079463F, 2.5F, 9.916667F, 2.5F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 2);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.restore();
      localCanvas.restore();
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.icon_filled_brand_followed
 * JD-Core Version:    0.7.0.1
 */