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

public final class cbu
  extends c
{
  private final int height = 16;
  private final int width = 16;
  
  public final int a(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 16;
      return 16;
      Canvas localCanvas = (Canvas)paramVarArgs[0];
      paramVarArgs = (Looper)paramVarArgs[1];
      Object localObject = c.j(paramVarArgs);
      float[] arrayOfFloat = c.i(paramVarArgs);
      Paint localPaint1 = c.m(paramVarArgs);
      localPaint1.setFlags(385);
      localPaint1.setStyle(Paint.Style.FILL);
      Paint localPaint2 = c.m(paramVarArgs);
      localPaint2.setFlags(385);
      localPaint2.setStyle(Paint.Style.STROKE);
      localPaint1.setColor(-16777216);
      localPaint2.setStrokeWidth(1.0F);
      localPaint2.setStrokeCap(Paint.Cap.BUTT);
      localPaint2.setStrokeJoin(Paint.Join.MITER);
      localPaint2.setStrokeMiter(4.0F);
      localPaint2.setPathEffect(null);
      localPaint2 = c.a(localPaint2, paramVarArgs);
      localPaint2.setStrokeWidth(1.0F);
      localCanvas.save();
      arrayOfFloat = c.a(arrayOfFloat, 1.0F, 0.0F, -265.0F, 0.0F, 1.0F, -671.0F);
      ((Matrix)localObject).reset();
      ((Matrix)localObject).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject);
      localCanvas.save();
      arrayOfFloat = c.a(arrayOfFloat, 1.0F, 0.0F, 66.0F, 0.0F, 1.0F, 602.0F);
      ((Matrix)localObject).reset();
      ((Matrix)localObject).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject);
      localCanvas.save();
      arrayOfFloat = c.a(arrayOfFloat, 1.0F, 0.0F, 198.0F, 0.0F, 1.0F, 68.0F);
      ((Matrix)localObject).reset();
      ((Matrix)localObject).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject);
      localObject = c.n(paramVarArgs);
      ((Path)localObject).moveTo(0.0F, 0.0F);
      ((Path)localObject).lineTo(18.0F, 0.0F);
      ((Path)localObject).lineTo(18.0F, 18.0F);
      ((Path)localObject).lineTo(0.0F, 18.0F);
      ((Path)localObject).lineTo(0.0F, 0.0F);
      ((Path)localObject).close();
      localCanvas.save();
      localPaint1 = c.a(localPaint1, paramVarArgs);
      localPaint2 = c.a(localPaint2, paramVarArgs);
      localPaint1.setColor(-5066062);
      localPaint2.setColor(-5066062);
      localPaint2.setStrokeWidth(0.2F);
      localObject = c.n(paramVarArgs);
      ((Path)localObject).moveTo(16.273369F, 4.989574F);
      ((Path)localObject).cubicTo(16.236847F, 4.97649F, 15.897717F, 4.863192F, 15.20087F, 4.863192F);
      ((Path)localObject).cubicTo(14.215761F, 4.863192F, 12.576522F, 5.093936F, 10.146522F, 6.069255F);
      ((Path)localObject).cubicTo(11.12087F, 5.16F, 12.914674F, 3.951383F, 15.672717F, 3.802341F);
      ((Path)localObject).cubicTo(15.852391F, 3.792766F, 15.990326F, 3.642447F, 15.980217F, 3.466915F);
      ((Path)localObject).cubicTo(15.970435F, 3.290745F, 15.810327F, 3.15F, 15.637174F, 3.166277F);
      ((Path)localObject).cubicTo(12.882391F, 3.314681F, 11.03413F, 4.423404F, 9.940761F, 5.371276F);
      ((Path)localObject).cubicTo(10.647717F, 4.251064F, 12.105978F, 2.834681F, 15.084783F, 2.159681F);
      ((Path)localObject).cubicTo(15.260218F, 2.119787F, 15.36913F, 1.948723F, 15.329021F, 1.777021F);
      ((Path)localObject).cubicTo(15.288587F, 1.605319F, 15.115108F, 1.498723F, 14.938044F, 1.538298F);
      ((Path)localObject).cubicTo(11.057935F, 2.417553F, 9.562174F, 4.464574F, 8.99087F, 5.757766F);
      ((Path)localObject).cubicTo(8.419239F, 4.464574F, 6.923478F, 2.417553F, 3.04337F, 1.538298F);
      ((Path)localObject).cubicTo(2.867935F, 1.498404F, 2.693152F, 1.605319F, 2.652391F, 1.777021F);
      ((Path)localObject).cubicTo(2.611957F, 1.948723F, 2.721196F, 2.119787F, 2.896631F, 2.159681F);
      ((Path)localObject).cubicTo(5.930217F, 2.846808F, 7.383913F, 4.278192F, 8.075217F, 5.400958F);
      ((Path)localObject).cubicTo(6.986087F, 4.447022F, 5.128044F, 3.316277F, 2.344239F, 3.166277F);
      ((Path)localObject).cubicTo(2.163261F, 3.151277F, 2.010978F, 3.291064F, 2.001196F, 3.466915F);
      ((Path)localObject).cubicTo(1.991087F, 3.642447F, 2.128696F, 3.792766F, 2.30837F, 3.802341F);
      ((Path)localObject).cubicTo(5.099674F, 3.953298F, 6.906196F, 5.190319F, 7.872065F, 6.102766F);
      ((Path)localObject).cubicTo(5.397718F, 5.096489F, 3.754565F, 4.862872F, 2.775652F, 4.862872F);
      ((Path)localObject).cubicTo(2.089239F, 4.862872F, 1.757609F, 4.977447F, 1.722065F, 4.990213F);
      ((Path)localObject).cubicTo(1.585109F, 5.040638F, 1.499022F, 5.174681F, 1.512065F, 5.317021F);
      ((Path)localObject).lineTo(2.297935F, 13.944894F);
      ((Path)localObject).cubicTo(2.312935F, 14.109574F, 2.45413F, 14.235319F, 2.622391F, 14.235319F);
      ((Path)localObject).cubicTo(2.624022F, 14.235319F, 2.625978F, 14.235319F, 2.627935F, 14.235319F);
      ((Path)localObject).lineTo(2.767174F, 14.234042F);
      ((Path)localObject).cubicTo(6.036196F, 14.234042F, 8.748261F, 16.102341F, 8.775326F, 16.121489F);
      ((Path)localObject).cubicTo(8.781522F, 16.126276F, 8.79F, 16.124361F, 8.796522F, 16.128191F);
      ((Path)localObject).cubicTo(8.803696F, 16.13266F, 8.807282F, 16.141277F, 8.815108F, 16.145426F);
      ((Path)localObject).cubicTo(8.862392F, 16.169361F, 8.913587F, 16.18117F, 8.965109F, 16.18117F);
      ((Path)localObject).cubicTo(9.015978F, 16.18117F, 9.067174F, 16.169361F, 9.11413F, 16.145426F);
      ((Path)localObject).cubicTo(9.121631F, 16.141596F, 9.124891F, 16.133297F, 9.132391F, 16.129148F);
      ((Path)localObject).cubicTo(9.138913F, 16.125319F, 9.147065F, 16.126915F, 9.153261F, 16.122446F);
      ((Path)localObject).cubicTo(9.180653F, 16.103617F, 11.926304F, 14.234042F, 15.196957F, 14.234042F);
      ((Path)localObject).lineTo(15.336196F, 14.235319F);
      ((Path)localObject).cubicTo(15.338152F, 14.235319F, 15.340109F, 14.235319F, 15.341413F, 14.235319F);
      ((Path)localObject).cubicTo(15.509348F, 14.235319F, 15.650543F, 14.110212F, 15.66587F, 13.94617F);
      ((Path)localObject).lineTo(16.486629F, 5.318617F);
      ((Path)localObject).cubicTo(16.5F, 5.174362F, 16.412283F, 5.039043F, 16.273369F, 4.989574F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(2.186739F, 5.53883F);
      ((Path)localObject).cubicTo(2.322391F, 5.518724F, 2.517391F, 5.500213F, 2.775652F, 5.500213F);
      ((Path)localObject).cubicTo(3.821087F, 5.500213F, 5.680761F, 5.785532F, 8.639348F, 7.127234F);
      ((Path)localObject).lineTo(8.639348F, 15.279255F);
      ((Path)localObject).cubicTo(7.683261F, 14.721064F, 5.504022F, 13.639468F, 2.920761F, 13.59766F);
      ((Path)localObject).lineTo(2.186739F, 5.53883F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(15.044348F, 13.597979F);
      ((Path)localObject).cubicTo(12.453913F, 13.639468F, 10.2525F, 14.726171F, 9.290544F, 15.282447F);
      ((Path)localObject).lineTo(9.290544F, 7.127234F);
      ((Path)localObject).cubicTo(12.250109F, 5.785532F, 14.134239F, 5.500213F, 15.200543F, 5.500213F);
      ((Path)localObject).cubicTo(15.468587F, 5.500213F, 15.670761F, 5.519362F, 15.810652F, 5.539787F);
      ((Path)localObject).lineTo(15.044348F, 13.597979F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 1);
      localCanvas.drawPath((Path)localObject, localPaint1);
      localCanvas.drawPath((Path)localObject, localPaint2);
      localCanvas.restore();
      localCanvas.restore();
      localCanvas.restore();
      localCanvas.restore();
      c.l(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.cbu
 * JD-Core Version:    0.7.0.1
 */