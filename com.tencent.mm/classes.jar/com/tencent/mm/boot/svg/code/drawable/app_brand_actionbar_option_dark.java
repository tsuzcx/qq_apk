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

public class app_brand_actionbar_option_dark
  extends c
{
  private final int height = 18;
  private final int width = 56;
  
  public int doCommand(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 56;
      return 18;
      Canvas localCanvas = (Canvas)paramVarArgs[0];
      paramVarArgs = (Looper)paramVarArgs[1];
      Object localObject1 = c.instanceMatrix(paramVarArgs);
      Object localObject2 = c.instanceMatrixArray(paramVarArgs);
      Object localObject3 = c.instancePaint(paramVarArgs);
      ((Paint)localObject3).setFlags(385);
      ((Paint)localObject3).setStyle(Paint.Style.FILL);
      Object localObject4 = c.instancePaint(paramVarArgs);
      ((Paint)localObject4).setFlags(385);
      ((Paint)localObject4).setStyle(Paint.Style.STROKE);
      ((Paint)localObject3).setColor(-16777216);
      ((Paint)localObject4).setStrokeWidth(1.0F);
      ((Paint)localObject4).setStrokeCap(Paint.Cap.BUTT);
      ((Paint)localObject4).setStrokeJoin(Paint.Join.MITER);
      ((Paint)localObject4).setStrokeMiter(4.0F);
      ((Paint)localObject4).setPathEffect(null);
      c.instancePaint((Paint)localObject4, paramVarArgs).setStrokeWidth(1.0F);
      localCanvas.save();
      localObject3 = c.instancePaint((Paint)localObject3, paramVarArgs);
      ((Paint)localObject3).setColor(-16777216);
      localObject4 = c.setMatrixFloatArray((float[])localObject2, 1.0F, 0.0F, -586.0F, 0.0F, 1.0F, -423.0F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject4);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject2 = c.instancePaint((Paint)localObject3, paramVarArgs);
      localObject3 = c.setMatrixFloatArray((float[])localObject4, 6.123234E-017F, -1.0F, 1046.0F, 1.0F, 6.123234E-017F, -182.0F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject3);
      localCanvas.concat((Matrix)localObject1);
      localObject1 = c.instancePath(paramVarArgs);
      ((Path)localObject1).moveTo(614.0F, 404.0F);
      ((Path)localObject1).cubicTo(616.7558F, 404.0F, 619.0F, 406.23859F, 619.0F, 409.0F);
      ((Path)localObject1).cubicTo(619.0F, 411.7558F, 616.76141F, 414.0F, 614.0F, 414.0F);
      ((Path)localObject1).cubicTo(611.2442F, 414.0F, 609.0F, 411.76141F, 609.0F, 409.0F);
      ((Path)localObject1).cubicTo(609.0F, 406.2442F, 611.23859F, 404.0F, 614.0F, 404.0F);
      ((Path)localObject1).close();
      ((Path)localObject1).moveTo(614.0F, 423.0F);
      ((Path)localObject1).cubicTo(618.97168F, 423.0F, 623.0F, 427.02945F, 623.0F, 432.0F);
      ((Path)localObject1).cubicTo(623.0F, 436.97165F, 618.97058F, 441.0F, 614.0F, 441.0F);
      ((Path)localObject1).cubicTo(609.02832F, 441.0F, 605.0F, 436.97055F, 605.0F, 432.0F);
      ((Path)localObject1).cubicTo(605.0F, 427.02835F, 609.02942F, 423.0F, 614.0F, 423.0F);
      ((Path)localObject1).close();
      ((Path)localObject1).moveTo(614.0F, 450.0F);
      ((Path)localObject1).cubicTo(616.7558F, 450.0F, 619.0F, 452.23859F, 619.0F, 455.0F);
      ((Path)localObject1).cubicTo(619.0F, 457.7558F, 616.76141F, 460.0F, 614.0F, 460.0F);
      ((Path)localObject1).cubicTo(611.2442F, 460.0F, 609.0F, 457.76141F, 609.0F, 455.0F);
      ((Path)localObject1).cubicTo(609.0F, 452.2442F, 611.23859F, 450.0F, 614.0F, 450.0F);
      ((Path)localObject1).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject1, 2);
      localCanvas.drawPath((Path)localObject1, (Paint)localObject2);
      localCanvas.restore();
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.app_brand_actionbar_option_dark
 * JD-Core Version:    0.7.0.1
 */