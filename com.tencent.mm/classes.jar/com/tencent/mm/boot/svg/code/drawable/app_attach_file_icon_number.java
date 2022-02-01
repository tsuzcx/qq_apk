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

public class app_attach_file_icon_number
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
      Object localObject3 = c.instanceMatrixArray(paramVarArgs);
      Object localObject2 = c.instancePaint(paramVarArgs);
      ((Paint)localObject2).setFlags(385);
      ((Paint)localObject2).setStyle(Paint.Style.FILL);
      Object localObject4 = c.instancePaint(paramVarArgs);
      ((Paint)localObject4).setFlags(385);
      ((Paint)localObject4).setStyle(Paint.Style.STROKE);
      ((Paint)localObject2).setColor(-16777216);
      ((Paint)localObject4).setStrokeWidth(1.0F);
      ((Paint)localObject4).setStrokeCap(Paint.Cap.BUTT);
      ((Paint)localObject4).setStrokeJoin(Paint.Join.MITER);
      ((Paint)localObject4).setStrokeMiter(4.0F);
      ((Paint)localObject4).setPathEffect(null);
      c.instancePaint((Paint)localObject4, paramVarArgs).setStrokeWidth(1.0F);
      localCanvas.save();
      localObject3 = c.setMatrixFloatArray((float[])localObject3, 1.0F, 0.0F, 8.0F, 0.0F, 1.0F, 4.0F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject3);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject4 = c.instancePaint((Paint)localObject2, paramVarArgs);
      ((Paint)localObject4).setColor(-14824411);
      Object localObject5 = c.instancePath(paramVarArgs);
      ((Path)localObject5).moveTo(16.0F, 0.0F);
      ((Path)localObject5).lineTo(24.0F, 8.0F);
      ((Path)localObject5).lineTo(23.999863F, 1.049432F);
      ((Path)localObject5).cubicTo(23.999954F, 1.055166F, 24.0F, 1.060911F, 24.0F, 1.066667F);
      ((Path)localObject5).lineTo(24.0F, 30.933332F);
      ((Path)localObject5).cubicTo(24.0F, 31.522438F, 23.522438F, 32.0F, 22.933332F, 32.0F);
      ((Path)localObject5).lineTo(1.066667F, 32.0F);
      ((Path)localObject5).cubicTo(0.4775629F, 32.0F, 2.609151E-015F, 31.522438F, 0.0F, 30.933332F);
      ((Path)localObject5).lineTo(0.0F, 1.066667F);
      ((Path)localObject5).cubicTo(-7.21444E-017F, 0.4775629F, 0.4775629F, 5.523058E-016F, 1.066667F, 0.0F);
      ((Path)localObject5).lineTo(16.0F, 0.0F);
      ((Path)localObject5).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject5, 2);
      localCanvas.drawPath((Path)localObject5, (Paint)localObject4);
      localCanvas.restore();
      localObject5 = c.instancePaint((Paint)localObject2, paramVarArgs);
      ((Paint)localObject5).setColor(-16777216);
      localObject4 = c.instancePath(paramVarArgs);
      ((Path)localObject4).moveTo(24.0F, 8.0F);
      ((Path)localObject4).lineTo(17.066668F, 8.0F);
      ((Path)localObject4).cubicTo(16.477562F, 8.0F, 16.0F, 7.522437F, 16.0F, 6.933333F);
      ((Path)localObject4).lineTo(16.0F, 0.0F);
      ((Path)localObject4).lineTo(16.0F, 0.0F);
      ((Path)localObject4).lineTo(24.0F, 8.0F);
      ((Path)localObject4).close();
      localCanvas.saveLayerAlpha(null, 51, 31);
      localObject5 = c.instancePaint((Paint)localObject5, paramVarArgs);
      WeChatSVGRenderC2Java.setFillType((Path)localObject4, 2);
      localCanvas.drawPath((Path)localObject4, (Paint)localObject5);
      localCanvas.restore();
      localCanvas.save();
      localObject2 = c.instancePaint((Paint)localObject2, paramVarArgs);
      ((Paint)localObject2).setColor(-1);
      localObject3 = c.setMatrixFloatArray((float[])localObject3, 1.0F, 0.0F, 3.466667F, 0.0F, 1.0F, 11.466667F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject3);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject3 = c.setMatrixFloatArray((float[])localObject3, 1.0F, 0.0F, 3.2F, 0.0F, 1.0F, 4.266667F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject3);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject1 = c.instancePaint((Paint)localObject2, paramVarArgs);
      localObject3 = c.instancePath(paramVarArgs);
      ((Path)localObject3).moveTo(0.0F, 6.666667F);
      ((Path)localObject3).cubicTo(0.0F, 6.519391F, 0.1193907F, 6.4F, 0.2666667F, 6.4F);
      ((Path)localObject3).lineTo(1.866667F, 6.4F);
      ((Path)localObject3).cubicTo(2.013943F, 6.4F, 2.133333F, 6.519391F, 2.133333F, 6.666667F);
      ((Path)localObject3).lineTo(2.133333F, 7.733333F);
      ((Path)localObject3).cubicTo(2.133333F, 7.880609F, 2.013943F, 8.0F, 1.866667F, 8.0F);
      ((Path)localObject3).lineTo(0.2666667F, 8.0F);
      ((Path)localObject3).cubicTo(0.1193907F, 8.0F, 0.0F, 7.880609F, 0.0F, 7.733333F);
      ((Path)localObject3).lineTo(0.0F, 6.666667F);
      ((Path)localObject3).close();
      localCanvas.drawPath((Path)localObject3, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.save();
      localObject1 = c.instancePaint((Paint)localObject2, paramVarArgs);
      localObject3 = c.instancePath(paramVarArgs);
      ((Path)localObject3).moveTo(2.933333F, 4.266667F);
      ((Path)localObject3).cubicTo(2.933333F, 4.119391F, 3.052724F, 4.0F, 3.2F, 4.0F);
      ((Path)localObject3).lineTo(4.8F, 4.0F);
      ((Path)localObject3).cubicTo(4.947276F, 4.0F, 5.066667F, 4.119391F, 5.066667F, 4.266667F);
      ((Path)localObject3).lineTo(5.066667F, 7.733333F);
      ((Path)localObject3).cubicTo(5.066667F, 7.880609F, 4.947276F, 8.0F, 4.8F, 8.0F);
      ((Path)localObject3).lineTo(3.2F, 8.0F);
      ((Path)localObject3).cubicTo(3.052724F, 8.0F, 2.933333F, 7.880609F, 2.933333F, 7.733333F);
      ((Path)localObject3).lineTo(2.933333F, 4.266667F);
      ((Path)localObject3).close();
      localCanvas.drawPath((Path)localObject3, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.save();
      localObject1 = c.instancePaint((Paint)localObject2, paramVarArgs);
      localObject3 = c.instancePath(paramVarArgs);
      ((Path)localObject3).moveTo(6.133333F, 0.0F);
      ((Path)localObject3).lineTo(7.733333F, 0.0F);
      ((Path)localObject3).cubicTo(7.880609F, -2.705415E-017F, 8.0F, 0.1193907F, 8.0F, 0.2666667F);
      ((Path)localObject3).lineTo(8.0F, 7.733333F);
      ((Path)localObject3).cubicTo(8.0F, 7.880609F, 7.880609F, 8.0F, 7.733333F, 8.0F);
      ((Path)localObject3).lineTo(6.133333F, 8.0F);
      ((Path)localObject3).cubicTo(5.986057F, 8.0F, 5.866667F, 7.880609F, 5.866667F, 7.733333F);
      ((Path)localObject3).lineTo(5.866667F, 0.2666667F);
      ((Path)localObject3).cubicTo(5.866667F, 0.1193907F, 5.986057F, -1.394793E-016F, 6.133333F, 0.0F);
      ((Path)localObject3).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject3, 2);
      localCanvas.drawPath((Path)localObject3, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.save();
      localObject1 = c.instancePaint((Paint)localObject2, paramVarArgs);
      localObject3 = c.instancePath(paramVarArgs);
      ((Path)localObject3).moveTo(0.0F, 8.933333F);
      ((Path)localObject3).cubicTo(0.0F, 8.71242F, 0.1790861F, 8.533334F, 0.4F, 8.533334F);
      ((Path)localObject3).lineTo(10.8F, 8.533334F);
      ((Path)localObject3).cubicTo(11.020914F, 8.533334F, 11.2F, 8.71242F, 11.2F, 8.933333F);
      ((Path)localObject3).lineTo(11.2F, 9.133334F);
      ((Path)localObject3).cubicTo(11.2F, 9.354248F, 11.020914F, 9.533334F, 10.8F, 9.533334F);
      ((Path)localObject3).lineTo(0.4F, 9.533334F);
      ((Path)localObject3).cubicTo(0.1790861F, 9.533334F, 0.0F, 9.354248F, 0.0F, 9.133334F);
      ((Path)localObject3).lineTo(0.0F, 8.933333F);
      ((Path)localObject3).close();
      localCanvas.drawPath((Path)localObject3, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.save();
      localObject1 = c.instancePaint((Paint)localObject2, paramVarArgs);
      localObject2 = c.instancePath(paramVarArgs);
      ((Path)localObject2).moveTo(8.8F, 2.666667F);
      ((Path)localObject2).cubicTo(8.8F, 2.519391F, 8.919391F, 2.4F, 9.066667F, 2.4F);
      ((Path)localObject2).lineTo(10.666667F, 2.4F);
      ((Path)localObject2).cubicTo(10.813943F, 2.4F, 10.933333F, 2.519391F, 10.933333F, 2.666667F);
      ((Path)localObject2).lineTo(10.933333F, 7.733333F);
      ((Path)localObject2).cubicTo(10.933333F, 7.880609F, 10.813943F, 8.0F, 10.666667F, 8.0F);
      ((Path)localObject2).lineTo(9.066667F, 8.0F);
      ((Path)localObject2).cubicTo(8.919391F, 8.0F, 8.8F, 7.880609F, 8.8F, 7.733333F);
      ((Path)localObject2).lineTo(8.8F, 2.666667F);
      ((Path)localObject2).close();
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.restore();
      localCanvas.restore();
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.app_attach_file_icon_number
 * JD-Core Version:    0.7.0.1
 */