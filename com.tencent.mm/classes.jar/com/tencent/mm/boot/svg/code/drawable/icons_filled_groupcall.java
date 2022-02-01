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

public class icons_filled_groupcall
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
      Object localObject3 = c.instanceMatrixArray(paramVarArgs);
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
      localObject2 = c.instancePaint((Paint)localObject2, paramVarArgs);
      ((Paint)localObject2).setColor(-16777216);
      localCanvas.save();
      localObject3 = c.setMatrixFloatArray((float[])localObject3, 1.0F, 0.0F, 6.75F, 0.0F, 1.0F, 9.0F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject3);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject1 = c.instancePaint((Paint)localObject2, paramVarArgs);
      localObject3 = c.instancePath(paramVarArgs);
      ((Path)localObject3).moveTo(21.11145F, 35.13855F);
      ((Path)localObject3).cubicTo(26.724855F, 40.751953F, 32.043621F, 43.384838F, 34.010521F, 43.230659F);
      ((Path)localObject3).cubicTo(35.977425F, 43.076477F, 40.875557F, 39.708019F, 43.187878F, 39.752857F);
      ((Path)localObject3).cubicTo(44.299198F, 39.774403F, 51.561333F, 44.685787F, 52.440414F, 45.25362F);
      ((Path)localObject3).cubicTo(53.319496F, 45.821457F, 54.134598F, 46.48476F, 53.981331F, 47.324108F);
      ((Path)localObject3).cubicTo(53.828064F, 48.163452F, 50.63644F, 57.408829F, 42.488228F, 56.128555F);
      ((Path)localObject3).cubicTo(34.340015F, 54.848282F, 22.980268F, 46.064373F, 16.507206F, 39.742794F);
      ((Path)localObject3).lineTo(21.11145F, 35.13855F);
      ((Path)localObject3).lineTo(21.11145F, 35.13855F);
      ((Path)localObject3).close();
      ((Path)localObject3).moveTo(21.11145F, 35.13855F);
      ((Path)localObject3).cubicTo(15.498045F, 29.525145F, 12.865161F, 24.206381F, 13.019342F, 22.239479F);
      ((Path)localObject3).cubicTo(13.173524F, 20.272577F, 16.541979F, 15.374443F, 16.497145F, 13.062124F);
      ((Path)localObject3).cubicTo(16.475595F, 11.950804F, 11.564215F, 4.688668F, 10.996378F, 3.809587F);
      ((Path)localObject3).cubicTo(10.428542F, 2.930505F, 9.765239F, 2.115402F, 8.925893F, 2.268669F);
      ((Path)localObject3).cubicTo(8.086547F, 2.421936F, -1.158827F, 5.61356F, 0.1214449F, 13.761772F);
      ((Path)localObject3).cubicTo(1.401717F, 21.909985F, 10.185628F, 33.26973F, 16.507206F, 39.742794F);
      ((Path)localObject3).lineTo(21.11145F, 35.13855F);
      ((Path)localObject3).lineTo(21.11145F, 35.13855F);
      ((Path)localObject3).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject3, 2);
      localCanvas.drawPath((Path)localObject3, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.save();
      localObject1 = c.instancePaint((Paint)localObject2, paramVarArgs);
      localObject2 = c.instancePath(paramVarArgs);
      ((Path)localObject2).moveTo(53.971874F, 0.05310206F);
      ((Path)localObject2).cubicTo(54.644039F, -0.140353F, 55.349998F, 0.1986633F, 55.349998F, 1.006461F);
      ((Path)localObject2).lineTo(55.349998F, 1.006461F);
      ((Path)localObject2).lineTo(55.349998F, 15.783524F);
      ((Path)localObject2).cubicTo(55.349998F, 16.505203F, 54.711605F, 16.976877F, 53.971874F, 16.736883F);
      ((Path)localObject2).cubicTo(53.702324F, 16.44676F, 50.371426F, 13.285236F, 48.0F, 11.115414F);
      ((Path)localObject2).lineTo(48.0F, 11.115414F);
      ((Path)localObject2).lineTo(48.0F, 5.617771F);
      ((Path)localObject2).cubicTo(50.314968F, 3.477228F, 53.573166F, 0.4064558F, 53.971874F, 0.05310206F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(45.001129F, 1.05F);
      ((Path)localObject2).cubicTo(45.497562F, 1.05F, 45.900002F, 1.435633F, 45.900002F, 1.914671F);
      ((Path)localObject2).lineTo(45.900002F, 14.885328F);
      ((Path)localObject2).cubicTo(45.900002F, 15.362873F, 45.496502F, 15.75F, 45.001129F, 15.75F);
      ((Path)localObject2).lineTo(27.898872F, 15.75F);
      ((Path)localObject2).cubicTo(27.402439F, 15.75F, 27.0F, 15.364367F, 27.0F, 14.885328F);
      ((Path)localObject2).lineTo(27.0F, 1.914671F);
      ((Path)localObject2).cubicTo(27.0F, 1.437127F, 27.403498F, 1.05F, 27.898872F, 1.05F);
      ((Path)localObject2).lineTo(45.001129F, 1.05F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 2);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.icons_filled_groupcall
 * JD-Core Version:    0.7.0.1
 */