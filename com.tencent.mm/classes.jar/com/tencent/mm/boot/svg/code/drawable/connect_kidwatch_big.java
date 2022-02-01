package com.tencent.mm.boot.svg.code.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.c;

public class connect_kidwatch_big
  extends c
{
  private final int height = 120;
  private final int width = 120;
  
  public int doCommand(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 120;
      return 120;
      Canvas localCanvas = (Canvas)paramVarArgs[0];
      paramVarArgs = (Looper)paramVarArgs[1];
      Object localObject1 = c.instanceMatrix(paramVarArgs);
      float[] arrayOfFloat = c.instanceMatrixArray(paramVarArgs);
      Object localObject2 = c.instancePaint(paramVarArgs);
      ((Paint)localObject2).setFlags(385);
      ((Paint)localObject2).setStyle(Paint.Style.FILL);
      Object localObject3 = c.instancePaint(paramVarArgs);
      ((Paint)localObject3).setFlags(385);
      ((Paint)localObject3).setStyle(Paint.Style.STROKE);
      ((Paint)localObject2).setColor(-16777216);
      ((Paint)localObject3).setStrokeWidth(1.0F);
      ((Paint)localObject3).setStrokeCap(Paint.Cap.BUTT);
      ((Paint)localObject3).setStrokeJoin(Paint.Join.MITER);
      ((Paint)localObject3).setStrokeMiter(4.0F);
      ((Paint)localObject3).setPathEffect(null);
      localObject2 = c.instancePaint((Paint)localObject3, paramVarArgs);
      ((Paint)localObject2).setStrokeWidth(1.0F);
      localObject3 = c.instancePath(paramVarArgs);
      ((Path)localObject3).moveTo(0.0F, 0.0F);
      ((Path)localObject3).lineTo(120.0F, 0.0F);
      ((Path)localObject3).lineTo(120.0F, 120.0F);
      ((Path)localObject3).lineTo(0.0F, 120.0F);
      ((Path)localObject3).lineTo(0.0F, 0.0F);
      ((Path)localObject3).close();
      localCanvas.save();
      localObject2 = c.instancePaint((Paint)localObject2, paramVarArgs);
      ((Paint)localObject2).setColor(-16777216);
      ((Paint)localObject2).setStrokeWidth(0.6F);
      arrayOfFloat = c.setMatrixFloatArray(arrayOfFloat, 1.0F, 0.0F, 26.538462F, 0.0F, 1.0F, 6.923077F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject3 = c.instancePaint((Paint)localObject2, paramVarArgs);
      Path localPath = c.instancePath(paramVarArgs);
      localPath.moveTo(15.383311F, 17.0F);
      localPath.lineTo(52.616688F, 17.0F);
      localPath.cubicTo(57.965801F, 17.0F, 59.905518F, 17.556953F, 61.861073F, 18.602797F);
      localPath.cubicTo(63.816631F, 19.64864F, 65.351364F, 21.183371F, 66.397202F, 23.138926F);
      localPath.cubicTo(67.443047F, 25.094481F, 68.0F, 27.034199F, 68.0F, 32.383312F);
      localPath.lineTo(68.0F, 73.616692F);
      localPath.cubicTo(68.0F, 78.965797F, 67.443047F, 80.905518F, 66.397202F, 82.861076F);
      localPath.cubicTo(65.351364F, 84.816628F, 63.816631F, 86.351364F, 61.861073F, 87.397202F);
      localPath.cubicTo(59.905518F, 88.443047F, 57.965801F, 89.0F, 52.616688F, 89.0F);
      localPath.lineTo(15.383311F, 89.0F);
      localPath.cubicTo(10.034199F, 89.0F, 8.094482F, 88.443047F, 6.138926F, 87.397202F);
      localPath.cubicTo(4.18337F, 86.351364F, 2.648639F, 84.816628F, 1.602796F, 82.861076F);
      localPath.cubicTo(0.5569537F, 80.905518F, 1.294535E-015F, 78.965797F, -2.228004E-015F, 73.616692F);
      localPath.lineTo(4.143361E-016F, 32.383312F);
      localPath.cubicTo(-2.407412E-016F, 27.034199F, 0.5569537F, 25.094481F, 1.602796F, 23.138926F);
      localPath.cubicTo(2.648639F, 21.183371F, 4.18337F, 19.64864F, 6.138926F, 18.602797F);
      localPath.cubicTo(8.094482F, 17.556953F, 10.034199F, 17.0F, 15.383311F, 17.0F);
      localPath.close();
      localCanvas.drawPath(localPath, (Paint)localObject3);
      localCanvas.restore();
      localCanvas.save();
      localObject3 = c.instancePaint((Paint)localObject2, paramVarArgs);
      localPath = c.instancePath(paramVarArgs);
      localPath.moveTo(69.07692F, 34.615383F);
      localPath.cubicTo(69.629211F, 34.615383F, 70.07692F, 35.063099F, 70.07692F, 35.615383F);
      localPath.lineTo(70.07692F, 45.615383F);
      localPath.cubicTo(70.07692F, 46.167671F, 69.629211F, 46.615383F, 69.07692F, 46.615383F);
      localPath.cubicTo(68.524635F, 46.615383F, 68.07692F, 46.167671F, 68.07692F, 45.615383F);
      localPath.lineTo(68.07692F, 35.615383F);
      localPath.cubicTo(68.07692F, 35.063099F, 68.524635F, 34.615383F, 69.07692F, 34.615383F);
      localPath.close();
      localCanvas.drawPath(localPath, (Paint)localObject3);
      localCanvas.restore();
      localCanvas.save();
      localObject3 = c.instancePaint((Paint)localObject2, paramVarArgs);
      localPath = c.instancePath(paramVarArgs);
      localPath.moveTo(15.0F, 17.307692F);
      localPath.cubicTo(15.0F, 17.038795F, 15.412809F, 14.46272F, 15.45954F, 14.197914F);
      localPath.lineTo(17.080317F, 5.013512F);
      localPath.cubicTo(17.402721F, 3.186553F, 17.680937F, 2.550783F, 18.119043F, 1.918514F);
      localPath.cubicTo(18.55715F, 1.286246F, 19.12883F, 0.806617F, 19.827614F, 0.4850556F);
      localPath.cubicTo(20.5264F, 0.1634942F, 21.200844F, 0.0F, 23.056032F, 0.0F);
      localPath.lineTo(46.335613F, 0.0F);
      localPath.cubicTo(48.190804F, 0.0F, 48.86525F, 0.1634942F, 49.564034F, 0.4850556F);
      localPath.cubicTo(50.262817F, 0.806617F, 50.834496F, 1.286246F, 51.272602F, 1.918514F);
      localPath.cubicTo(51.710709F, 2.550783F, 51.988926F, 3.186553F, 52.311329F, 5.013512F);
      localPath.lineTo(54.215839F, 17.307692F);
      localCanvas.drawPath(localPath, (Paint)localObject3);
      localCanvas.restore();
      localCanvas.save();
      localObject3 = c.instancePaint((Paint)localObject2, paramVarArgs);
      arrayOfFloat = c.setMatrixFloatArray(arrayOfFloat, 1.0F, 0.0F, 0.0F, 0.0F, -1.0F, 195.0F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject1);
      localObject1 = c.instancePath(paramVarArgs);
      ((Path)localObject1).moveTo(15.0F, 106.15385F);
      ((Path)localObject1).cubicTo(15.0F, 105.88495F, 15.412809F, 103.30888F, 15.45954F, 103.04407F);
      ((Path)localObject1).lineTo(17.080317F, 93.859665F);
      ((Path)localObject1).cubicTo(17.402721F, 92.032707F, 17.680937F, 91.396935F, 18.119043F, 90.764671F);
      ((Path)localObject1).cubicTo(18.55715F, 90.132401F, 19.12883F, 89.652771F, 19.827614F, 89.331207F);
      ((Path)localObject1).cubicTo(20.5264F, 89.009651F, 21.200844F, 88.846153F, 23.056032F, 88.846153F);
      ((Path)localObject1).lineTo(46.335613F, 88.846153F);
      ((Path)localObject1).cubicTo(48.190804F, 88.846153F, 48.86525F, 89.009651F, 49.564034F, 89.331207F);
      ((Path)localObject1).cubicTo(50.262817F, 89.652771F, 50.834496F, 90.132401F, 51.272602F, 90.764671F);
      ((Path)localObject1).cubicTo(51.710709F, 91.396935F, 51.988926F, 92.032707F, 52.311329F, 93.859665F);
      ((Path)localObject1).lineTo(54.215839F, 106.15385F);
      localCanvas.drawPath((Path)localObject1, (Paint)localObject3);
      localCanvas.restore();
      localCanvas.save();
      localObject1 = c.instancePaint((Paint)localObject2, paramVarArgs);
      localObject2 = c.instancePath(paramVarArgs);
      ((Path)localObject2).moveTo(14.916658F, 26.0F);
      ((Path)localObject2).lineTo(53.083344F, 26.0F);
      ((Path)localObject2).cubicTo(55.140694F, 26.0F, 55.886738F, 26.214212F, 56.638874F, 26.616461F);
      ((Path)localObject2).cubicTo(57.39101F, 27.018707F, 57.981293F, 27.608988F, 58.383541F, 28.361126F);
      ((Path)localObject2).cubicTo(58.785786F, 29.113262F, 59.0F, 29.859306F, 59.0F, 31.916658F);
      ((Path)localObject2).lineTo(59.0F, 74.083344F);
      ((Path)localObject2).cubicTo(59.0F, 76.140694F, 58.785786F, 76.886742F, 58.383541F, 77.638878F);
      ((Path)localObject2).cubicTo(57.981293F, 78.391014F, 57.39101F, 78.981293F, 56.638874F, 79.383537F);
      ((Path)localObject2).cubicTo(55.886738F, 79.785789F, 55.140694F, 80.0F, 53.083344F, 80.0F);
      ((Path)localObject2).lineTo(14.916658F, 80.0F);
      ((Path)localObject2).cubicTo(12.859307F, 80.0F, 12.113262F, 79.785789F, 11.361125F, 79.383537F);
      ((Path)localObject2).cubicTo(10.608989F, 78.981293F, 10.018707F, 78.391014F, 9.61646F, 77.638878F);
      ((Path)localObject2).cubicTo(9.214213F, 76.886742F, 9.0F, 76.140694F, 9.0F, 74.083344F);
      ((Path)localObject2).lineTo(9.0F, 31.916658F);
      ((Path)localObject2).cubicTo(9.0F, 29.859306F, 9.214213F, 29.113262F, 9.61646F, 28.361126F);
      ((Path)localObject2).cubicTo(10.018707F, 27.608988F, 10.608989F, 27.018707F, 11.361125F, 26.616461F);
      ((Path)localObject2).cubicTo(12.113262F, 26.214212F, 12.859307F, 26.0F, 14.916658F, 26.0F);
      ((Path)localObject2).close();
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.connect_kidwatch_big
 * JD-Core Version:    0.7.0.1
 */