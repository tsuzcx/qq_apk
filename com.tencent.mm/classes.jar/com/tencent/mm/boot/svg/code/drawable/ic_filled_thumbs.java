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

public class ic_filled_thumbs
  extends c
{
  private final int height = 48;
  private final int width = 48;
  
  public int doCommand(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 48;
      return 48;
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
      arrayOfFloat = c.setMatrixFloatArray(arrayOfFloat, 1.0F, 0.0F, -16.0F, 0.0F, 1.0F, -100.0F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      arrayOfFloat = c.setMatrixFloatArray(arrayOfFloat, 1.0F, 0.0F, 0.0F, 0.0F, 1.0F, 88.0F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      arrayOfFloat = c.setMatrixFloatArray(arrayOfFloat, 1.0F, 0.0F, 16.0F, 0.0F, 1.0F, 3.0F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      arrayOfFloat = c.setMatrixFloatArray(arrayOfFloat, 1.0F, 0.0F, 0.0F, 0.0F, 1.0F, 9.0F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localPaint = c.instancePaint((Paint)localObject2, paramVarArgs);
      localPaint.setColor(-526345);
      Path localPath = c.instancePath(paramVarArgs);
      localPath.moveTo(0.0F, 4.0F);
      localPath.cubicTo(0.0F, 1.790861F, 1.790861F, 0.0F, 4.0F, 0.0F);
      localPath.lineTo(44.0F, 0.0F);
      localPath.cubicTo(46.209141F, 0.0F, 48.0F, 1.790861F, 48.0F, 4.0F);
      localPath.lineTo(48.0F, 44.0F);
      localPath.cubicTo(48.0F, 46.209141F, 46.209141F, 48.0F, 44.0F, 48.0F);
      localPath.lineTo(4.0F, 48.0F);
      localPath.cubicTo(1.790861F, 48.0F, 0.0F, 46.209141F, 0.0F, 44.0F);
      localPath.lineTo(0.0F, 4.0F);
      localPath.close();
      localCanvas.drawPath(localPath, localPaint);
      localCanvas.restore();
      localCanvas.save();
      localObject2 = c.instancePaint((Paint)localObject2, paramVarArgs);
      ((Paint)localObject2).setColor(-15616);
      arrayOfFloat = c.setMatrixFloatArray(arrayOfFloat, 1.0F, 0.0F, 8.0F, 0.0F, 1.0F, 8.0F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject1 = c.instancePaint((Paint)localObject2, paramVarArgs);
      localObject2 = c.instancePath(paramVarArgs);
      ((Path)localObject2).moveTo(20.361448F, 5.952645F);
      ((Path)localObject2).cubicTo(21.126657F, 7.079886F, 21.332129F, 8.269144F, 21.332129F, 10.7693F);
      ((Path)localObject2).cubicTo(21.332129F, 11.451479F, 21.149721F, 11.621433F, 21.3936F, 12.051712F);
      ((Path)localObject2).cubicTo(21.906F, 12.060102F, 24.500208F, 12.234269F, 25.209095F, 12.490161F);
      ((Path)localObject2).cubicTo(26.089422F, 12.807939F, 26.764603F, 13.31892F, 27.107843F, 14.083771F);
      ((Path)localObject2).cubicTo(28.332994F, 16.813801F, 26.794872F, 24.18185F, 23.917391F, 26.550528F);
      ((Path)localObject2).cubicTo(23.054035F, 27.261503F, 21.303766F, 27.174044F, 19.963612F, 27.283785F);
      ((Path)localObject2).cubicTo(19.332603F, 27.335329F, 16.736202F, 27.342722F, 12.207496F, 27.322222F);
      ((Path)localObject2).lineTo(12.207098F, 13.847586F);
      ((Path)localObject2).cubicTo(12.405709F, 13.748565F, 12.629142F, 13.623837F, 12.900377F, 13.464798F);
      ((Path)localObject2).cubicTo(13.686465F, 13.003915F, 14.149695F, 12.480839F, 14.49743F, 11.561347F);
      ((Path)localObject2).cubicTo(14.694043F, 11.040648F, 14.760807F, 10.529837F, 14.832299F, 9.018408F);
      ((Path)localObject2).cubicTo(14.841782F, 8.818276F, 14.844151F, 8.755302F, 14.860264F, 8.300997F);
      ((Path)localObject2).cubicTo(14.933334F, 6.240632F, 15.151803F, 5.506536F, 16.292877F, 4.97664F);
      ((Path)localObject2).cubicTo(17.817902F, 4.268352F, 19.639641F, 4.889115F, 20.361448F, 5.952645F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(10.707108F, 14.278362F);
      ((Path)localObject2).lineTo(10.707365F, 27.314808F);
      ((Path)localObject2).cubicTo(9.635487F, 27.309116F, 8.472677F, 27.302191F, 7.219274F, 27.294199F);
      ((Path)localObject2).cubicTo(6.155582F, 27.287859F, 5.294118F, 26.433678F, 5.294118F, 25.375988F);
      ((Path)localObject2).lineTo(5.294118F, 16.275349F);
      ((Path)localObject2).cubicTo(5.294118F, 15.213089F, 6.165206F, 14.357124F, 7.233762F, 14.357124F);
      ((Path)localObject2).lineTo(9.577086F, 14.357124F);
      ((Path)localObject2).cubicTo(9.956631F, 14.357124F, 10.32018F, 14.333967F, 10.707108F, 14.278362F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 2);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.restore();
      localCanvas.restore();
      localCanvas.restore();
      localCanvas.restore();
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.ic_filled_thumbs
 * JD-Core Version:    0.7.0.1
 */