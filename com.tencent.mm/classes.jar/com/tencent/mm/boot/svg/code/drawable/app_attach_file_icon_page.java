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

public class app_attach_file_icon_page
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
      float[] arrayOfFloat = c.instanceMatrixArray(paramVarArgs);
      Paint localPaint = c.instancePaint(paramVarArgs);
      localPaint.setFlags(385);
      localPaint.setStyle(Paint.Style.FILL);
      Object localObject2 = c.instancePaint(paramVarArgs);
      ((Paint)localObject2).setFlags(385);
      ((Paint)localObject2).setStyle(Paint.Style.STROKE);
      localPaint.setColor(-16777216);
      ((Paint)localObject2).setStrokeWidth(1.0F);
      ((Paint)localObject2).setStrokeCap(Paint.Cap.BUTT);
      ((Paint)localObject2).setStrokeJoin(Paint.Join.MITER);
      ((Paint)localObject2).setStrokeMiter(4.0F);
      ((Paint)localObject2).setPathEffect(null);
      c.instancePaint((Paint)localObject2, paramVarArgs).setStrokeWidth(1.0F);
      localCanvas.save();
      arrayOfFloat = c.setMatrixFloatArray(arrayOfFloat, 1.0F, 0.0F, 8.0F, 0.0F, 1.0F, 4.0F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject2 = c.instancePaint(localPaint, paramVarArgs);
      ((Paint)localObject2).setColor(-28160);
      Object localObject3 = c.instancePath(paramVarArgs);
      ((Path)localObject3).moveTo(16.0F, 0.0F);
      ((Path)localObject3).lineTo(24.0F, 8.0F);
      ((Path)localObject3).lineTo(23.999863F, 1.049432F);
      ((Path)localObject3).cubicTo(23.999954F, 1.055166F, 24.0F, 1.060911F, 24.0F, 1.066667F);
      ((Path)localObject3).lineTo(24.0F, 30.933332F);
      ((Path)localObject3).cubicTo(24.0F, 31.522438F, 23.522438F, 32.0F, 22.933332F, 32.0F);
      ((Path)localObject3).lineTo(1.066667F, 32.0F);
      ((Path)localObject3).cubicTo(0.4775629F, 32.0F, 2.609151E-015F, 31.522438F, 0.0F, 30.933332F);
      ((Path)localObject3).lineTo(0.0F, 1.066667F);
      ((Path)localObject3).cubicTo(-7.21444E-017F, 0.4775629F, 0.4775629F, 5.523058E-016F, 1.066667F, 0.0F);
      ((Path)localObject3).lineTo(16.0F, 0.0F);
      ((Path)localObject3).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject3, 2);
      localCanvas.drawPath((Path)localObject3, (Paint)localObject2);
      localCanvas.restore();
      localObject3 = c.instancePaint(localPaint, paramVarArgs);
      ((Paint)localObject3).setColor(-16777216);
      localObject2 = c.instancePath(paramVarArgs);
      ((Path)localObject2).moveTo(24.0F, 8.0F);
      ((Path)localObject2).lineTo(17.066668F, 8.0F);
      ((Path)localObject2).cubicTo(16.477562F, 8.0F, 16.0F, 7.522437F, 16.0F, 6.933333F);
      ((Path)localObject2).lineTo(16.0F, 0.0F);
      ((Path)localObject2).lineTo(16.0F, 0.0F);
      ((Path)localObject2).lineTo(24.0F, 8.0F);
      ((Path)localObject2).close();
      localCanvas.saveLayerAlpha(null, 51, 31);
      localObject3 = c.instancePaint((Paint)localObject3, paramVarArgs);
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 2);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject3);
      localCanvas.restore();
      localCanvas.save();
      localPaint = c.instancePaint(localPaint, paramVarArgs);
      localPaint.setColor(-1);
      arrayOfFloat = c.setMatrixFloatArray(arrayOfFloat, 1.0F, 0.0F, 3.401026F, 0.0F, 1.0F, 11.53641F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      arrayOfFloat = c.setMatrixFloatArray(arrayOfFloat, 1.0F, 0.0F, 3.52721F, 0.0F, 1.0F, 3.396923F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject2 = c.instancePaint(localPaint, paramVarArgs);
      localObject3 = c.instancePath(paramVarArgs);
      ((Path)localObject3).moveTo(0.005097936F, 9.833333F);
      ((Path)localObject3).cubicTo(0.005097936F, 9.557191F, 0.2289555F, 9.333333F, 0.5050979F, 9.333333F);
      ((Path)localObject3).lineTo(9.638432F, 9.333333F);
      ((Path)localObject3).cubicTo(9.914574F, 9.333333F, 10.138432F, 9.557191F, 10.138432F, 9.833333F);
      ((Path)localObject3).lineTo(10.138432F, 9.833333F);
      ((Path)localObject3).cubicTo(10.138432F, 10.109475F, 9.914574F, 10.333333F, 9.638432F, 10.333333F);
      ((Path)localObject3).lineTo(0.5050979F, 10.333333F);
      ((Path)localObject3).cubicTo(0.2289555F, 10.333333F, 0.005097936F, 10.109475F, 0.005097936F, 9.833333F);
      ((Path)localObject3).lineTo(0.005097936F, 9.833333F);
      ((Path)localObject3).close();
      localCanvas.drawPath((Path)localObject3, (Paint)localObject2);
      localCanvas.restore();
      localCanvas.save();
      localPaint = c.instancePaint(localPaint, paramVarArgs);
      arrayOfFloat = c.setMatrixFloatArray(arrayOfFloat, 0.7071068F, -0.7071068F, 4.660243F, 0.7071068F, 0.7071068F, -1.930336F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject1);
      localObject1 = c.instancePath(paramVarArgs);
      ((Path)localObject1).moveTo(4.892127F, 9.72711F);
      ((Path)localObject1).lineTo(4.750411F, 10.571609F);
      ((Path)localObject1).cubicTo(4.742054F, 10.621408F, 4.69491F, 10.655004F, 4.645112F, 10.646646F);
      ((Path)localObject1).cubicTo(4.606658F, 10.640193F, 4.576528F, 10.610064F, 4.570075F, 10.571609F);
      ((Path)localObject1).lineTo(4.428359F, 9.72711F);
      ((Path)localObject1).cubicTo(4.416933F, 9.571078F, 4.405771F, 9.417341F, 4.394874F, 9.265897F);
      ((Path)localObject1).lineTo(4.925612F, 9.265897F);
      ((Path)localObject1).cubicTo(4.914714F, 9.417341F, 4.903553F, 9.571078F, 4.892127F, 9.72711F);
      ((Path)localObject1).close();
      ((Path)localObject1).moveTo(4.958467F, 8.804944F);
      ((Path)localObject1).lineTo(4.362019F, 8.804944F);
      ((Path)localObject1).cubicTo(4.184353F, 6.287388F, 4.08439F, 4.44508F, 4.062127F, 3.278019F);
      ((Path)localObject1).lineTo(5.258359F, 3.278019F);
      ((Path)localObject1).cubicTo(5.236096F, 4.44508F, 5.136132F, 6.287388F, 4.958467F, 8.804944F);
      ((Path)localObject1).close();
      ((Path)localObject1).moveTo(4.69257F, -1.327436F);
      ((Path)localObject1).cubicTo(4.935205F, -1.327526F, 5.135588F, -1.138003F, 5.149094F, -0.895745F);
      ((Path)localObject1).cubicTo(5.225127F, 0.4680319F, 5.263143F, 1.705953F, 5.263143F, 2.818019F);
      ((Path)localObject1).lineTo(4.057343F, 2.818019F);
      ((Path)localObject1).lineTo(4.057343F, 2.818019F);
      ((Path)localObject1).cubicTo(4.057343F, 1.70594F, 4.09536F, 0.4680035F, 4.171394F, -0.8957919F);
      ((Path)localObject1).cubicTo(4.184948F, -1.137972F, 4.385269F, -1.327436F, 4.627828F, -1.327436F);
      ((Path)localObject1).lineTo(4.69257F, -1.327436F);
      ((Path)localObject1).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject1, 2);
      localCanvas.drawPath((Path)localObject1, localPaint);
      localCanvas.restore();
      localCanvas.restore();
      localCanvas.restore();
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.app_attach_file_icon_page
 * JD-Core Version:    0.7.0.1
 */