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

public class honey_pay_watermask
  extends c
{
  private final int height = 111;
  private final int width = 121;
  
  public int doCommand(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 121;
      return 111;
      Canvas localCanvas = (Canvas)paramVarArgs[0];
      paramVarArgs = (Looper)paramVarArgs[1];
      Object localObject = c.instanceMatrix(paramVarArgs);
      float[] arrayOfFloat = c.instanceMatrixArray(paramVarArgs);
      Paint localPaint2 = c.instancePaint(paramVarArgs);
      localPaint2.setFlags(385);
      localPaint2.setStyle(Paint.Style.FILL);
      Paint localPaint1 = c.instancePaint(paramVarArgs);
      localPaint1.setFlags(385);
      localPaint1.setStyle(Paint.Style.STROKE);
      localPaint2.setColor(-16777216);
      localPaint1.setStrokeWidth(1.0F);
      localPaint1.setStrokeCap(Paint.Cap.BUTT);
      localPaint1.setStrokeJoin(Paint.Join.MITER);
      localPaint1.setStrokeMiter(4.0F);
      localPaint1.setPathEffect(null);
      localPaint1 = c.instancePaint(localPaint1, paramVarArgs);
      localPaint1.setStrokeWidth(1.0F);
      localCanvas.save();
      localPaint2 = c.instancePaint(localPaint2, paramVarArgs);
      localPaint2.setColor(-1203649);
      arrayOfFloat = c.setMatrixFloatArray(arrayOfFloat, 0.8987941F, -0.4383712F, 30.552965F, 0.4383712F, 0.8987941F, -20.803411F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject).reset();
      ((Matrix)localObject).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject);
      Path localPath = c.instancePath(paramVarArgs);
      localPath.moveTo(31.454109F, 18.344019F);
      localPath.lineTo(106.61748F, 45.577366F);
      localPath.cubicTo(108.50436F, 46.261028F, 109.47725F, 48.337948F, 108.79048F, 50.216293F);
      localPath.lineTo(93.868355F, 91.028847F);
      localPath.cubicTo(93.181587F, 92.907188F, 91.095222F, 93.875671F, 89.208328F, 93.192009F);
      localPath.lineTo(14.044966F, 65.958664F);
      localPath.cubicTo(12.158075F, 65.275002F, 11.185187F, 63.198082F, 11.871959F, 61.319736F);
      localPath.lineTo(26.794083F, 20.507185F);
      localPath.cubicTo(27.480854F, 18.628839F, 29.567221F, 17.660357F, 31.454109F, 18.344019F);
      localPath.close();
      localCanvas.saveLayerAlpha(null, 108, 31);
      localPaint2 = c.instancePaint(localPaint2, paramVarArgs);
      WeChatSVGRenderC2Java.setFillType(localPath, 2);
      localCanvas.drawPath(localPath, localPaint2);
      localCanvas.restore();
      localCanvas.restore();
      localCanvas.save();
      localPaint1 = c.instancePaint(localPaint1, paramVarArgs);
      localPaint1.setColor(-1203649);
      localPaint1.setStrokeWidth(2.216448F);
      localPaint1.setStrokeCap(Paint.Cap.ROUND);
      localPaint1.setStrokeJoin(Paint.Join.MITER);
      arrayOfFloat = c.setMatrixFloatArray(arrayOfFloat, 0.9975641F, 0.06975647F, -3.45363F, -0.06975647F, 0.9975641F, 4.806033F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject).reset();
      ((Matrix)localObject).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject);
      localObject = c.instancePath(paramVarArgs);
      ((Path)localObject).moveTo(72.302963F, 21.229805F);
      ((Path)localObject).cubicTo(78.113754F, 18.189999F, 84.324677F, 16.44265F, 90.935738F, 15.98776F);
      ((Path)localObject).cubicTo(101.13679F, 15.921063F, 109.22781F, 19.061852F, 112.95436F, 25.4872F);
      ((Path)localObject).cubicTo(120.7427F, 38.915913F, 106.51804F, 61.606159F, 81.182709F, 76.16729F);
      ((Path)localObject).cubicTo(55.84737F, 90.728416F, 28.995327F, 91.646423F, 21.206989F, 78.217712F);
      ((Path)localObject).cubicTo(20.278666F, 76.617088F, 19.663086F, 74.884888F, 19.341787F, 73.050552F);
      ((Path)localObject).cubicTo(18.844284F, 69.116264F, 19.076675F, 65.807968F, 20.03896F, 63.125668F);
      localCanvas.drawPath((Path)localObject, localPaint1);
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.honey_pay_watermask
 * JD-Core Version:    0.7.0.1
 */