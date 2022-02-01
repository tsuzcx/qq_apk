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

public class app_brand_destop_view_third_party_running_flag
  extends c
{
  private final int height = 24;
  private final int width = 24;
  
  public int doCommand(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 24;
      return 24;
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
      ((Paint)localObject2).setColor(-1);
      arrayOfFloat = c.setMatrixFloatArray(arrayOfFloat, 1.0F, 0.0F, 2.0F, 0.0F, 1.0F, 2.0F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localPaint = c.instancePaint((Paint)localObject2, paramVarArgs);
      localPaint.setColor(436207615);
      Path localPath = c.instancePath(paramVarArgs);
      localPath.moveTo(10.0F, 0.0F);
      localPath.cubicTo(15.522848F, 0.0F, 20.0F, 4.477152F, 20.0F, 10.0F);
      localPath.cubicTo(20.0F, 15.522848F, 15.522848F, 20.0F, 10.0F, 20.0F);
      localPath.cubicTo(4.477152F, 20.0F, 0.0F, 15.522848F, 0.0F, 10.0F);
      localPath.cubicTo(0.0F, 4.477152F, 4.477152F, 0.0F, 10.0F, 0.0F);
      localPath.close();
      localCanvas.drawPath(localPath, localPaint);
      localCanvas.restore();
      localCanvas.save();
      arrayOfFloat = c.setMatrixFloatArray(arrayOfFloat, 1.0F, 0.0F, 5.0F, 0.0F, 1.0F, 5.0F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject1 = c.instancePaint((Paint)localObject2, paramVarArgs);
      localObject2 = c.instancePath(paramVarArgs);
      ((Path)localObject2).moveTo(6.816196F, 0.05092412F);
      ((Path)localObject2).lineTo(3.186827F, 0.05092412F);
      ((Path)localObject2).cubicTo(2.446463F, 0.05589597F, 2.078647F, 0.09250341F, 1.66057F, 0.2246838F);
      ((Path)localObject2).cubicTo(0.9863201F, 0.4696597F, 0.4696597F, 0.9863201F, 0.2308901F, 1.642311F);
      ((Path)localObject2).cubicTo(0.09250536F, 2.078641F, 0.05589616F, 2.446491F, 0.05092412F, 3.183826F);
      ((Path)localObject2).lineTo(0.05092412F, 6.813168F);
      ((Path)localObject2).cubicTo(0.0558958F, 7.553488F, 0.09250185F, 7.921283F, 0.2246778F, 8.339411F);
      ((Path)localObject2).cubicTo(0.46967F, 9.013708F, 0.9863586F, 9.530372F, 1.642364F, 9.769054F);
      ((Path)localObject2).lineTo(1.780535F, 9.81067F);
      ((Path)localObject2).lineTo(1.953428F, 9.854168F);
      ((Path)localObject2).cubicTo(2.321302F, 9.937167F, 2.677088F, 9.95F, 3.637775F, 9.95F);
      ((Path)localObject2).lineTo(6.938094F, 9.947248F);
      ((Path)localObject2).cubicTo(7.487449F, 9.94035F, 7.76321F, 9.918043F, 8.046123F, 9.854258F);
      ((Path)localObject2).lineTo(8.218974F, 9.810801F);
      ((Path)localObject2).cubicTo(8.279244F, 9.793855F, 8.279244F, 9.793855F, 8.339471F, 9.775229F);
      ((Path)localObject2).cubicTo(9.013641F, 9.530372F, 9.53033F, 9.013708F, 9.76911F, 8.357689F);
      ((Path)localObject2).lineTo(9.810876F, 8.21892F);
      ((Path)localObject2).lineTo(9.854309F, 8.046077F);
      ((Path)localObject2).cubicTo(9.937185F, 7.678309F, 9.95F, 7.322618F, 9.95F, 6.362225F);
      ((Path)localObject2).lineTo(9.947246F, 3.061707F);
      ((Path)localObject2).cubicTo(9.939652F, 2.457209F, 9.913398F, 2.183872F, 9.833758F, 1.867899F);
      ((Path)localObject2).lineTo(9.775316F, 1.66057F);
      ((Path)localObject2).cubicTo(9.550755F, 1.042508F, 9.097903F, 0.5568641F, 8.518707F, 0.2963022F);
      ((Path)localObject2).lineTo(8.339411F, 0.2246778F);
      ((Path)localObject2).cubicTo(7.921283F, 0.09250185F, 7.553488F, 0.0558958F, 6.816196F, 0.05092412F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(3.189854F, 0.9509139F);
      ((Path)localObject2).lineTo(6.813168F, 0.9509139F);
      ((Path)localObject2).lineTo(7.017421F, 0.9533655F);
      ((Path)localObject2).cubicTo(7.465466F, 0.9614855F, 7.722117F, 0.9875667F, 7.964579F, 1.052536F);
      ((Path)localObject2).lineTo(8.049861F, 1.07661F);
      ((Path)localObject2).cubicTo(8.45587F, 1.22439F, 8.77561F, 1.54413F, 8.92339F, 1.950139F);
      ((Path)localObject2).lineTo(8.94274F, 2.018432F);
      ((Path)localObject2).cubicTo(9.022876F, 2.310617F, 9.044674F, 2.546793F, 9.049063F, 3.268325F);
      ((Path)localObject2).lineTo(9.049063F, 6.731557F);
      ((Path)localObject2).cubicTo(9.045355F, 7.341893F, 9.029196F, 7.60484F, 8.975822F, 7.84827F);
      ((Path)localObject2).lineTo(8.917178F, 8.068139F);
      ((Path)localObject2).cubicTo(8.775608F, 8.455874F, 8.455877F, 8.77559F, 8.049914F, 8.923296F);
      ((Path)localObject2).lineTo(7.98103F, 8.942824F);
      ((Path)localObject2).cubicTo(7.68894F, 9.022897F, 7.45284F, 9.044678F, 6.73155F, 9.049063F);
      ((Path)localObject2).lineTo(3.268358F, 9.049063F);
      ((Path)localObject2).cubicTo(2.657886F, 9.045349F, 2.394903F, 9.02917F, 2.151457F, 8.97573F);
      ((Path)localObject2).lineTo(1.93194F, 8.917128F);
      ((Path)localObject2).cubicTo(1.544123F, 8.77559F, 1.224392F, 8.455874F, 1.07661F, 8.049861F);
      ((Path)localObject2).cubicTo(0.9844553F, 7.756964F, 0.9553152F, 7.464182F, 0.9509139F, 6.810139F);
      ((Path)localObject2).lineTo(0.9509139F, 3.186854F);
      ((Path)localObject2).lineTo(0.9580066F, 2.801763F);
      ((Path)localObject2).cubicTo(0.9716862F, 2.404762F, 1.006316F, 2.173843F, 1.082816F, 1.93188F);
      ((Path)localObject2).cubicTo(1.22439F, 1.54413F, 1.54413F, 1.22439F, 1.950139F, 1.07661F);
      ((Path)localObject2).cubicTo(2.242984F, 0.9844567F, 2.535785F, 0.9553153F, 3.189854F, 0.9509139F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 1);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.restore();
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.app_brand_destop_view_third_party_running_flag
 * JD-Core Version:    0.7.0.1
 */