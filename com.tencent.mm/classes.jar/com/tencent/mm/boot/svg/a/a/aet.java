package com.tencent.mm.boot.svg.a.a;

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

public final class aet
  extends c
{
  private final int height = 84;
  private final int width = 96;
  
  protected final int b(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 96;
      return 84;
      Canvas localCanvas = (Canvas)paramVarArgs[0];
      paramVarArgs = (Looper)paramVarArgs[1];
      Object localObject = c.f(paramVarArgs);
      float[] arrayOfFloat = c.e(paramVarArgs);
      Paint localPaint1 = c.i(paramVarArgs);
      localPaint1.setFlags(385);
      localPaint1.setStyle(Paint.Style.FILL);
      Paint localPaint2 = c.i(paramVarArgs);
      localPaint2.setFlags(385);
      localPaint2.setStyle(Paint.Style.STROKE);
      localPaint1.setColor(-16777216);
      localPaint2.setStrokeWidth(1.0F);
      localPaint2.setStrokeCap(Paint.Cap.BUTT);
      localPaint2.setStrokeJoin(Paint.Join.MITER);
      localPaint2.setStrokeMiter(4.0F);
      localPaint2.setPathEffect(null);
      c.a(localPaint2, paramVarArgs).setStrokeWidth(1.0F);
      localCanvas.save();
      arrayOfFloat = c.a(arrayOfFloat, 1.0F, 0.0F, -426.0F, 0.0F, 1.0F, -155.0F);
      ((Matrix)localObject).reset();
      ((Matrix)localObject).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject);
      localCanvas.save();
      arrayOfFloat = c.a(arrayOfFloat, 1.0F, 0.0F, 426.0F, 0.0F, 1.0F, 155.0F);
      ((Matrix)localObject).reset();
      ((Matrix)localObject).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject);
      localObject = c.j(paramVarArgs);
      ((Path)localObject).moveTo(0.0F, 0.0F);
      ((Path)localObject).lineTo(96.0F, 0.0F);
      ((Path)localObject).lineTo(96.0F, 84.0F);
      ((Path)localObject).lineTo(0.0F, 84.0F);
      ((Path)localObject).lineTo(0.0F, 0.0F);
      ((Path)localObject).close();
      localCanvas.save();
      localPaint1 = c.a(localPaint1, paramVarArgs);
      localPaint1.setColor(-15028967);
      localObject = c.j(paramVarArgs);
      ((Path)localObject).moveTo(41.154999F, 11.127351F);
      ((Path)localObject).cubicTo(43.969002F, 10.73235F, 46.896999F, 11.266351F, 49.409F, 12.58835F);
      ((Path)localObject).cubicTo(52.495998F, 14.18735F, 54.952F, 16.85535F, 56.558998F, 19.914351F);
      ((Path)localObject).cubicTo(58.526001F, 23.624352F, 59.286999F, 27.926352F, 58.903F, 32.095352F);
      ((Path)localObject).cubicTo(58.459999F, 36.971352F, 56.359001F, 41.782352F, 52.706001F, 45.103352F);
      ((Path)localObject).cubicTo(52.143002F, 45.61335F, 51.542F, 46.122353F, 51.189999F, 46.810352F);
      ((Path)localObject).cubicTo(50.931999F, 47.30035F, 51.012001F, 47.86935F, 51.0F, 48.401352F);
      ((Path)localObject).cubicTo(51.008999F, 48.778351F, 50.938999F, 49.19735F, 51.174F, 49.524349F);
      ((Path)localObject).cubicTo(51.646999F, 50.228352F, 52.41F, 50.65435F, 53.124001F, 51.076351F);
      ((Path)localObject).cubicTo(58.028F, 54.14035F, 62.931999F, 57.206352F, 67.835999F, 60.271351F);
      ((Path)localObject).cubicTo(68.166F, 60.472351F, 68.483002F, 60.698349F, 68.836998F, 60.858349F);
      ((Path)localObject).cubicTo(70.463997F, 61.622353F, 71.850998F, 62.887352F, 72.758003F, 64.438354F);
      ((Path)localObject).cubicTo(73.552002F, 65.78035F, 73.984001F, 67.333351F, 73.998001F, 68.892349F);
      ((Path)localObject).cubicTo(74.002998F, 70.261353F, 73.998001F, 71.629349F, 74.0F, 72.998352F);
      ((Path)localObject).lineTo(12.0F, 72.998352F);
      ((Path)localObject).cubicTo(12.001F, 71.631348F, 11.999F, 70.264351F, 12.001F, 68.897354F);
      ((Path)localObject).cubicTo(12.018F, 67.143349F, 12.561F, 65.399353F, 13.551F, 63.950352F);
      ((Path)localObject).cubicTo(14.462F, 62.59935F, 15.751F, 61.507351F, 17.23F, 60.827351F);
      ((Path)localObject).cubicTo(17.452F, 60.723351F, 17.658001F, 60.590351F, 17.864F, 60.459351F);
      ((Path)localObject).cubicTo(22.951F, 57.278351F, 28.039F, 54.100349F, 33.125999F, 50.91935F);
      ((Path)localObject).cubicTo(33.645F, 50.588352F, 34.147999F, 50.223351F, 34.576F, 49.778351F);
      ((Path)localObject).cubicTo(34.799F, 49.53735F, 35.026001F, 49.247353F, 35.0F, 48.899349F);
      ((Path)localObject).cubicTo(34.997002F, 48.430351F, 35.009998F, 47.961349F, 34.992001F, 47.493351F);
      ((Path)localObject).cubicTo(34.973F, 47.074352F, 34.778F, 46.686352F, 34.528999F, 46.358349F);
      ((Path)localObject).cubicTo(34.019001F, 45.677349F, 33.325001F, 45.173351F, 32.734001F, 44.57135F);
      ((Path)localObject).cubicTo(30.121F, 41.970352F, 28.375F, 38.567352F, 27.558001F, 34.98735F);
      ((Path)localObject).cubicTo(26.664F, 31.048351F, 26.841999F, 26.864351F, 28.112F, 23.028351F);
      ((Path)localObject).cubicTo(29.173F, 19.836351F, 31.014F, 16.872351F, 33.561001F, 14.657351F);
      ((Path)localObject).cubicTo(35.693001F, 12.799351F, 38.34F, 11.498351F, 41.154999F, 11.127351F);
      ((Path)localObject).lineTo(41.154999F, 11.127351F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(37.536999F, 16.642351F);
      ((Path)localObject).cubicTo(35.202999F, 18.136351F, 33.471001F, 20.44335F, 32.395F, 22.97435F);
      ((Path)localObject).cubicTo(30.924999F, 26.458351F, 30.627001F, 30.406351F, 31.454F, 34.089352F);
      ((Path)localObject).cubicTo(32.234001F, 37.58535F, 34.127998F, 40.915352F, 37.058998F, 43.040352F);
      ((Path)localObject).cubicTo(38.240002F, 43.861351F, 38.985001F, 45.25935F, 39.004002F, 46.698349F);
      ((Path)localObject).cubicTo(38.994999F, 47.799351F, 39.004002F, 48.900352F, 38.999001F, 50.00135F);
      ((Path)localObject).cubicTo(38.997002F, 50.496349F, 38.916F, 50.993351F, 38.731998F, 51.455349F);
      ((Path)localObject).cubicTo(38.297001F, 52.588352F, 37.328999F, 53.399349F, 36.327999F, 54.027351F);
      ((Path)localObject).cubicTo(30.816F, 57.52235F, 25.315001F, 61.03635F, 19.767F, 64.47435F);
      ((Path)localObject).cubicTo(19.065001F, 64.927353F, 18.299999F, 65.300354F, 17.693001F, 65.886353F);
      ((Path)localObject).cubicTo(16.837F, 66.674347F, 16.257999F, 67.815353F, 16.326F, 68.998352F);
      ((Path)localObject).cubicTo(34.109001F, 68.998352F, 51.891998F, 68.999352F, 69.674004F, 68.997353F);
      ((Path)localObject).cubicTo(69.693001F, 67.972351F, 69.241997F, 66.98735F, 68.571999F, 66.230354F);
      ((Path)localObject).cubicTo(67.781998F, 65.304352F, 66.667999F, 64.770348F, 65.662003F, 64.123352F);
      ((Path)localObject).cubicTo(60.332001F, 60.805351F, 55.037998F, 57.43235F, 49.737F, 54.069351F);
      ((Path)localObject).cubicTo(48.994999F, 53.597351F, 48.266998F, 53.06435F, 47.752998F, 52.340351F);
      ((Path)localObject).cubicTo(47.278999F, 51.693352F, 47.013F, 50.899349F, 47.004002F, 50.097351F);
      ((Path)localObject).cubicTo(46.992001F, 48.997353F, 47.007999F, 47.89735F, 46.994999F, 46.796352F);
      ((Path)localObject).cubicTo(46.991001F, 45.473351F, 47.583F, 44.152351F, 48.605999F, 43.305351F);
      ((Path)localObject).cubicTo(49.047001F, 42.94635F, 49.514F, 42.61935F, 49.937F, 42.236351F);
      ((Path)localObject).cubicTo(51.451F, 40.893353F, 52.626999F, 39.195351F, 53.459999F, 37.35535F);
      ((Path)localObject).cubicTo(55.112F, 33.663349F, 55.424F, 29.410351F, 54.446999F, 25.49435F);
      ((Path)localObject).cubicTo(53.692001F, 22.475351F, 52.112999F, 19.60535F, 49.724998F, 17.57535F);
      ((Path)localObject).cubicTo(48.016998F, 16.117352F, 45.859001F, 15.149351F, 43.605F, 15.02035F);
      ((Path)localObject).cubicTo(41.474998F, 14.87635F, 39.324001F, 15.486351F, 37.536999F, 16.642351F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(68.0F, 27.99835F);
      ((Path)localObject).lineTo(84.0F, 27.99835F);
      ((Path)localObject).lineTo(84.0F, 31.99835F);
      ((Path)localObject).lineTo(68.0F, 31.99835F);
      ((Path)localObject).lineTo(68.0F, 27.99835F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(64.0F, 39.998352F);
      ((Path)localObject).lineTo(84.0F, 39.998352F);
      ((Path)localObject).lineTo(84.0F, 43.998352F);
      ((Path)localObject).lineTo(64.0F, 43.998352F);
      ((Path)localObject).lineTo(64.0F, 39.998352F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(68.0F, 51.998352F);
      ((Path)localObject).lineTo(84.0F, 51.998352F);
      ((Path)localObject).lineTo(84.0F, 55.998352F);
      ((Path)localObject).lineTo(68.0F, 55.998352F);
      ((Path)localObject).lineTo(68.0F, 51.998352F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 2);
      localCanvas.drawPath((Path)localObject, localPaint1);
      localCanvas.restore();
      localCanvas.restore();
      localCanvas.restore();
      c.h(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.aet
 * JD-Core Version:    0.7.0.1
 */