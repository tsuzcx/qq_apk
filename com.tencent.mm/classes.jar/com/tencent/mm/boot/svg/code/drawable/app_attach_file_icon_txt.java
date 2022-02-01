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

public class app_attach_file_icon_txt
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
      localObject4 = c.instancePaint((Paint)localObject2, paramVarArgs);
      ((Paint)localObject4).setColor(-1);
      localCanvas.save();
      localObject4 = c.instancePaint((Paint)localObject4, paramVarArgs);
      Object localObject5 = c.instancePath(paramVarArgs);
      ((Path)localObject5).moveTo(24.0F, 30.933332F);
      ((Path)localObject5).cubicTo(24.0F, 31.522438F, 23.522438F, 32.0F, 22.933332F, 32.0F);
      ((Path)localObject5).lineTo(1.066667F, 32.0F);
      ((Path)localObject5).cubicTo(0.4775629F, 32.0F, 2.609151E-015F, 31.522438F, 0.0F, 30.933332F);
      ((Path)localObject5).lineTo(0.0F, 1.066667F);
      ((Path)localObject5).cubicTo(-7.21444E-017F, 0.4775629F, 0.4775629F, 5.523058E-016F, 1.066667F, 0.0F);
      ((Path)localObject5).lineTo(16.0F, 0.0F);
      ((Path)localObject5).lineTo(24.0F, 8.0F);
      ((Path)localObject5).lineTo(24.0F, 30.933332F);
      ((Path)localObject5).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject5, 2);
      localCanvas.drawPath((Path)localObject5, (Paint)localObject4);
      localCanvas.restore();
      localObject4 = c.instancePaint((Paint)localObject2, paramVarArgs);
      ((Paint)localObject4).setColor(201326592);
      localCanvas.save();
      localObject4 = c.instancePaint((Paint)localObject4, paramVarArgs);
      localObject5 = c.instancePath(paramVarArgs);
      ((Path)localObject5).moveTo(24.0F, 30.933332F);
      ((Path)localObject5).cubicTo(24.0F, 31.522438F, 23.522438F, 32.0F, 22.933332F, 32.0F);
      ((Path)localObject5).lineTo(1.066667F, 32.0F);
      ((Path)localObject5).cubicTo(0.4775629F, 32.0F, 2.609151E-015F, 31.522438F, 0.0F, 30.933332F);
      ((Path)localObject5).lineTo(0.0F, 1.066667F);
      ((Path)localObject5).cubicTo(-7.21444E-017F, 0.4775629F, 0.4775629F, 5.523058E-016F, 1.066667F, 0.0F);
      ((Path)localObject5).lineTo(16.0F, 0.0F);
      ((Path)localObject5).lineTo(24.0F, 8.0F);
      ((Path)localObject5).lineTo(24.0F, 30.933332F);
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
      localCanvas.saveLayerAlpha(null, 25, 31);
      localObject5 = c.instancePaint((Paint)localObject5, paramVarArgs);
      WeChatSVGRenderC2Java.setFillType((Path)localObject4, 2);
      localCanvas.drawPath((Path)localObject4, (Paint)localObject5);
      localCanvas.restore();
      localCanvas.save();
      localObject2 = c.instancePaint((Paint)localObject2, paramVarArgs);
      ((Paint)localObject2).setColor(-16777216);
      localObject3 = c.setMatrixFloatArray((float[])localObject3, 1.0F, 0.0F, 4.266666F, 0.0F, 1.0F, 15.093334F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject3);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.saveLayerAlpha(null, 76, 31);
      localCanvas.save();
      localObject1 = c.instancePaint((Paint)localObject2, paramVarArgs);
      localObject3 = c.instancePath(paramVarArgs);
      ((Path)localObject3).moveTo(-8.881784E-016F, 0.0F);
      ((Path)localObject3).lineTo(15.36F, 0.0F);
      ((Path)localObject3).lineTo(15.36F, 1.066667F);
      ((Path)localObject3).lineTo(-8.881784E-016F, 1.066667F);
      ((Path)localObject3).lineTo(-8.881784E-016F, 0.0F);
      ((Path)localObject3).close();
      localCanvas.drawPath((Path)localObject3, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.save();
      localObject1 = c.instancePaint((Paint)localObject2, paramVarArgs);
      localObject3 = c.instancePath(paramVarArgs);
      ((Path)localObject3).moveTo(2.666667E-007F, 4.082667F);
      ((Path)localObject3).lineTo(15.36F, 4.082667F);
      ((Path)localObject3).lineTo(15.36F, 5.149334F);
      ((Path)localObject3).lineTo(2.666667E-007F, 5.149334F);
      ((Path)localObject3).lineTo(2.666667E-007F, 4.082667F);
      ((Path)localObject3).close();
      localCanvas.drawPath((Path)localObject3, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.save();
      localObject1 = c.instancePaint((Paint)localObject2, paramVarArgs);
      localObject2 = c.instancePath(paramVarArgs);
      ((Path)localObject2).moveTo(2.666668E-007F, 8.165334F);
      ((Path)localObject2).lineTo(8.533334F, 8.165334F);
      ((Path)localObject2).lineTo(8.533334F, 9.232F);
      ((Path)localObject2).lineTo(2.666668E-007F, 9.232F);
      ((Path)localObject2).lineTo(2.666668E-007F, 8.165334F);
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
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.app_attach_file_icon_txt
 * JD-Core Version:    0.7.0.1
 */