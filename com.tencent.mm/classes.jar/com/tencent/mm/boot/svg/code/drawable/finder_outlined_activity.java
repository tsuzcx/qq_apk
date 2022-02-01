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

public class finder_outlined_activity
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
      Object localObject = c.instanceMatrix(paramVarArgs);
      float[] arrayOfFloat = c.instanceMatrixArray(paramVarArgs);
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
      localPaint1.setColor(-12233353);
      arrayOfFloat = c.setMatrixFloatArray(arrayOfFloat, 0.8987941F, -0.4383712F, 6.819501F, 0.4383712F, 0.8987941F, -3.322763F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject).reset();
      ((Matrix)localObject).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject);
      localObject = c.instancePath(paramVarArgs);
      ((Path)localObject).moveTo(9.847616F, 21.693064F);
      ((Path)localObject).lineTo(2.653549F, 6.839658F);
      ((Path)localObject).cubicTo(2.539323F, 6.593353F, 2.637438F, 6.300767F, 2.877108F, 6.172993F);
      ((Path)localObject).cubicTo(2.900354F, 6.142009F, 2.929832F, 6.116231F, 2.963646F, 6.097318F);
      ((Path)localObject).cubicTo(3.677708F, 5.588064F, 4.467383F, 5.194074F, 5.303797F, 4.929754F);
      ((Path)localObject).cubicTo(6.152775F, 4.660101F, 7.034855F, 4.508528F, 7.925198F, 4.479304F);
      ((Path)localObject).lineTo(8.285776F, 4.479304F);
      ((Path)localObject).cubicTo(9.293041F, 4.481289F, 10.2944F, 4.633102F, 11.256938F, 4.929754F);
      ((Path)localObject).cubicTo(12.380329F, 5.325621F, 13.554348F, 5.559797F, 14.743726F, 5.625247F);
      ((Path)localObject).cubicTo(15.933633F, 5.625247F, 16.45647F, 5.171194F, 17.116327F, 4.594619F);
      ((Path)localObject).lineTo(17.274982F, 4.457683F);
      ((Path)localObject).cubicTo(17.44026F, 4.302198F, 17.657421F, 4.213587F, 17.884359F, 4.209035F);
      ((Path)localObject).cubicTo(18.011015F, 4.20926F, 18.13538F, 4.242817F, 18.244938F, 4.306332F);
      ((Path)localObject).cubicTo(18.637966F, 4.540566F, 18.62715F, 5.027051F, 18.587486F, 5.354978F);
      ((Path)localObject).cubicTo(18.523653F, 5.76955F, 18.413591F, 6.17568F, 18.259359F, 6.565785F);
      ((Path)localObject).cubicTo(17.820438F, 7.741184F, 17.13995F, 8.811627F, 16.261759F, 9.708118F);
      ((Path)localObject).cubicTo(15.769835F, 10.205906F, 15.190481F, 10.609009F, 14.55262F, 10.897304F);
      ((Path)localObject).lineTo(14.430023F, 10.947754F);
      ((Path)localObject).cubicTo(13.888576F, 11.168736F, 13.309346F, 11.282553F, 12.724489F, 11.282888F);
      ((Path)localObject).lineTo(12.345882F, 11.282888F);
      ((Path)localObject).cubicTo(11.963671F, 11.250456F, 11.599486F, 11.236041F, 11.26415F, 11.236041F);
      ((Path)localObject).cubicTo(8.379526F, 11.236041F, 7.716063F, 12.389192F, 7.131927F, 13.398197F);
      ((Path)localObject).lineTo(7.10308F, 13.452251F);
      ((Path)localObject).lineTo(10.889687F, 21.267839F);
      ((Path)localObject).cubicTo(10.944483F, 21.393044F, 10.944483F, 21.535427F, 10.889687F, 21.660631F);
      ((Path)localObject).cubicTo(10.833244F, 21.802078F, 10.721123F, 21.914133F, 10.579589F, 21.970541F);
      ((Path)localObject).cubicTo(10.512505F, 21.994614F, 10.441732F, 22.006666F, 10.370454F, 22.006666F);
      ((Path)localObject).cubicTo(10.150869F, 22.009314F, 9.948534F, 21.887985F, 9.847616F, 21.693064F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(6.52255F, 12.237841F);
      ((Path)localObject).cubicTo(6.871572F, 11.704303F, 7.336154F, 11.256013F, 7.881928F, 10.926132F);
      ((Path)localObject).cubicTo(8.747315F, 10.410819F, 9.861502F, 10.16217F, 11.292995F, 10.16217F);
      ((Path)localObject).cubicTo(11.653573F, 10.16217F, 12.046603F, 10.16217F, 12.45045F, 10.212621F);
      ((Path)localObject).lineTo(12.728095F, 10.212621F);
      ((Path)localObject).cubicTo(13.744925F, 10.212621F, 14.704062F, 9.747758F, 15.573055F, 8.828841F);
      ((Path)localObject).cubicTo(16.208824F, 8.140287F, 16.717852F, 7.344879F, 17.076664F, 6.479299F);
      ((Path)localObject).cubicTo(17.166809F, 6.266686F, 17.242531F, 6.064885F, 17.300222F, 5.870291F);
      ((Path)localObject).cubicTo(16.799906F, 6.25911F, 16.209614F, 6.515656F, 15.583872F, 6.616235F);
      ((Path)localObject).cubicTo(15.312087F, 6.660439F, 15.037113F, 6.682134F, 14.761755F, 6.6811F);
      ((Path)localObject).cubicTo(13.444422F, 6.619468F, 12.142724F, 6.36948F, 10.896359F, 5.93876F);
      ((Path)localObject).cubicTo(10.04543F, 5.672551F, 9.159386F, 5.535291F, 8.267747F, 5.531554F);
      ((Path)localObject).cubicTo(7.40249F, 5.533464F, 6.542675F, 5.668374F, 5.718462F, 5.931552F);
      ((Path)localObject).cubicTo(5.071541F, 6.133499F, 4.453442F, 6.418137F, 3.879514F, 6.778397F);
      ((Path)localObject).lineTo(6.52255F, 12.237841F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 2);
      localCanvas.drawPath((Path)localObject, localPaint1);
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.finder_outlined_activity
 * JD-Core Version:    0.7.0.1
 */