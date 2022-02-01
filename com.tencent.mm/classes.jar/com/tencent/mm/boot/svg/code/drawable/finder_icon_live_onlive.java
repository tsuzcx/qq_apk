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

public class finder_icon_live_onlive
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
      localPaint1.setColor(-16777216);
      localObject2 = c.setMatrixFloatArray((float[])localObject2, 1.0F, 0.0F, 10.0F, 0.0F, 1.0F, 9.0F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject2);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject2 = c.setMatrixFloatArray((float[])localObject2, 1.0F, 0.0F, 0.5F, 0.0F, 1.0F, 0.0F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject2);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject1 = c.instancePaint(localPaint1, paramVarArgs);
      localObject2 = c.instancePath(paramVarArgs);
      ((Path)localObject2).moveTo(25.65F, 0.0F);
      ((Path)localObject2).cubicTo(27.647215F, 0.0F, 29.279764F, 1.32713F, 29.393654F, 3.000498F);
      ((Path)localObject2).lineTo(29.4F, 3.0F);
      ((Path)localObject2).lineTo(29.4F, 42.0F);
      ((Path)localObject2).cubicTo(29.397865F, 42.062374F, 29.4F, 42.124725F, 29.4F, 42.1875F);
      ((Path)localObject2).cubicTo(29.4F, 43.947906F, 27.721067F, 45.375F, 25.65F, 45.375F);
      ((Path)localObject2).cubicTo(23.578932F, 45.375F, 21.9F, 43.947906F, 21.9F, 42.1875F);
      ((Path)localObject2).cubicTo(21.9F, 42.124725F, 21.902136F, 42.062374F, 21.906345F, 42.0005F);
      ((Path)localObject2).lineTo(21.9F, 42.0F);
      ((Path)localObject2).lineTo(21.9F, 3.0F);
      ((Path)localObject2).cubicTo(22.020237F, 1.32713F, 23.652784F, 0.0F, 25.65F, 0.0F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 2);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.save();
      localObject1 = c.instancePaint(localPaint1, paramVarArgs);
      localObject2 = c.instancePath(paramVarArgs);
      ((Path)localObject2).moveTo(45.75F, 6.0F);
      ((Path)localObject2).cubicTo(47.747215F, 6.0F, 49.379765F, 7.32713F, 49.493652F, 9.000499F);
      ((Path)localObject2).lineTo(49.5F, 9.0F);
      ((Path)localObject2).lineTo(49.5F, 36.0F);
      ((Path)localObject2).cubicTo(49.497864F, 36.062374F, 49.5F, 36.124725F, 49.5F, 36.1875F);
      ((Path)localObject2).cubicTo(49.5F, 37.947906F, 47.821068F, 39.375F, 45.75F, 39.375F);
      ((Path)localObject2).cubicTo(43.678932F, 39.375F, 42.0F, 37.947906F, 42.0F, 36.1875F);
      ((Path)localObject2).cubicTo(42.0F, 36.124725F, 42.002136F, 36.062374F, 42.006348F, 36.0005F);
      ((Path)localObject2).lineTo(42.0F, 36.0F);
      ((Path)localObject2).lineTo(42.0F, 9.0F);
      ((Path)localObject2).cubicTo(42.120235F, 7.32713F, 43.752785F, 6.0F, 45.75F, 6.0F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 2);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.save();
      localObject1 = c.instancePaint(localPaint1, paramVarArgs);
      localObject2 = c.instancePath(paramVarArgs);
      ((Path)localObject2).moveTo(5.25F, 6.0F);
      ((Path)localObject2).cubicTo(7.247216F, 6.0F, 8.879764F, 7.32713F, 8.993653F, 9.000499F);
      ((Path)localObject2).lineTo(9.0F, 9.0F);
      ((Path)localObject2).lineTo(9.0F, 36.0F);
      ((Path)localObject2).cubicTo(8.997865F, 36.062374F, 9.0F, 36.124725F, 9.0F, 36.1875F);
      ((Path)localObject2).cubicTo(9.0F, 37.947906F, 7.321068F, 39.375F, 5.25F, 39.375F);
      ((Path)localObject2).cubicTo(3.178932F, 39.375F, 1.5F, 37.947906F, 1.5F, 36.1875F);
      ((Path)localObject2).cubicTo(1.5F, 36.124725F, 1.502135F, 36.062374F, 1.506346F, 36.0005F);
      ((Path)localObject2).lineTo(1.5F, 36.0F);
      ((Path)localObject2).lineTo(1.5F, 9.0F);
      ((Path)localObject2).cubicTo(1.620236F, 7.32713F, 3.252784F, 6.0F, 5.25F, 6.0F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 2);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.save();
      localPaint1 = c.instancePaint(localPaint1, paramVarArgs);
      localObject1 = c.instancePath(paramVarArgs);
      ((Path)localObject1).moveTo(5.25F, 48.0F);
      ((Path)localObject1).cubicTo(8.149495F, 48.0F, 10.5F, 49.997932F, 10.5F, 52.462502F);
      ((Path)localObject1).cubicTo(10.5F, 54.927071F, 8.149495F, 56.925003F, 5.25F, 56.925003F);
      ((Path)localObject1).cubicTo(2.350505F, 56.925003F, 0.0F, 54.927071F, 0.0F, 52.462502F);
      ((Path)localObject1).cubicTo(0.0F, 49.997932F, 2.350505F, 48.0F, 5.25F, 48.0F);
      ((Path)localObject1).close();
      localCanvas.drawPath((Path)localObject1, localPaint1);
      localCanvas.restore();
      localCanvas.restore();
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.finder_icon_live_onlive
 * JD-Core Version:    0.7.0.1
 */