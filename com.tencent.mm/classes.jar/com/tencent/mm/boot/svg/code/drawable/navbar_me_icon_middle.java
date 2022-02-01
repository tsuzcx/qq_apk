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

public class navbar_me_icon_middle
  extends c
{
  private final int height = 84;
  private final int width = 96;
  
  public int doCommand(int paramInt, Object... paramVarArgs)
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
      arrayOfFloat = c.setMatrixFloatArray(arrayOfFloat, 1.0F, 0.0F, -897.0F, 0.0F, 1.0F, -151.0F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject).reset();
      ((Matrix)localObject).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject);
      localCanvas.save();
      arrayOfFloat = c.setMatrixFloatArray(arrayOfFloat, 1.0F, 0.0F, 907.0F, 0.0F, 1.0F, 155.0F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject).reset();
      ((Matrix)localObject).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject);
      localObject = c.instancePath(paramVarArgs);
      ((Path)localObject).moveTo(0.001716257F, 0.0F);
      ((Path)localObject).lineTo(76.001717F, 0.0F);
      ((Path)localObject).lineTo(76.001717F, 76.0F);
      ((Path)localObject).lineTo(0.001716257F, 76.0F);
      ((Path)localObject).lineTo(0.001716257F, 0.0F);
      ((Path)localObject).close();
      localCanvas.save();
      localPaint1 = c.instancePaint(localPaint1, paramVarArgs);
      localPaint1.setColor(-15028967);
      localObject = c.instancePath(paramVarArgs);
      ((Path)localObject).moveTo(31.39809F, 8.691818F);
      ((Path)localObject).cubicTo(34.192089F, 7.160818F, 37.526089F, 6.627818F, 40.653091F, 7.261818F);
      ((Path)localObject).cubicTo(43.757092F, 7.862818F, 46.576092F, 9.585818F, 48.717091F, 11.887817F);
      ((Path)localObject).cubicTo(51.335091F, 14.700818F, 53.007092F, 18.327818F, 53.66309F, 22.099817F);
      ((Path)localObject).cubicTo(54.618092F, 27.525818F, 53.563091F, 33.359818F, 50.446091F, 37.940819F);
      ((Path)localObject).cubicTo(49.59409F, 39.191818F, 48.588089F, 40.339817F, 47.44809F, 41.336819F);
      ((Path)localObject).cubicTo(46.953091F, 41.790817F, 46.442089F, 42.266819F, 46.15609F, 42.886818F);
      ((Path)localObject).cubicTo(45.938091F, 43.359818F, 46.015091F, 43.893818F, 46.00209F, 44.398819F);
      ((Path)localObject).cubicTo(46.01009F, 44.775818F, 45.94109F, 45.194817F, 46.17609F, 45.52282F);
      ((Path)localObject).cubicTo(46.64909F, 46.227818F, 47.41309F, 46.653816F, 48.12709F, 47.076817F);
      ((Path)localObject).cubicTo(53.092091F, 50.178818F, 58.057091F, 53.282818F, 63.022091F, 56.385818F);
      ((Path)localObject).cubicTo(63.28809F, 56.554817F, 63.554089F, 56.727818F, 63.84309F, 56.859818F);
      ((Path)localObject).cubicTo(65.467087F, 57.622818F, 66.852089F, 58.886818F, 67.759087F, 60.435818F);
      ((Path)localObject).cubicTo(68.554092F, 61.778816F, 68.986092F, 63.333817F, 69.000092F, 64.894821F);
      ((Path)localObject).cubicTo(69.005089F, 66.261818F, 69.000092F, 67.629814F, 69.00209F, 68.997818F);
      ((Path)localObject).lineTo(7.00209F, 68.997818F);
      ((Path)localObject).cubicTo(7.00309F, 67.629814F, 7.00009F, 66.262817F, 7.00309F, 64.895821F);
      ((Path)localObject).cubicTo(7.02009F, 63.070816F, 7.61009F, 61.257816F, 8.67409F, 59.774818F);
      ((Path)localObject).cubicTo(9.61409F, 58.440819F, 10.93609F, 57.398819F, 12.41909F, 56.73082F);
      ((Path)localObject).cubicTo(17.53709F, 53.547817F, 22.643089F, 50.342819F, 27.75709F, 47.151817F);
      ((Path)localObject).cubicTo(28.44409F, 46.725819F, 29.13409F, 46.276817F, 29.67609F, 45.668819F);
      ((Path)localObject).cubicTo(29.890091F, 45.433819F, 30.04109F, 45.128819F, 30.004089F, 44.802818F);
      ((Path)localObject).cubicTo(29.963091F, 44.109818F, 30.13109F, 43.354816F, 29.76709F, 42.722816F);
      ((Path)localObject).cubicTo(29.334089F, 41.951817F, 28.613091F, 41.413818F, 27.98509F, 40.812817F);
      ((Path)localObject).cubicTo(25.50909F, 38.448818F, 23.775089F, 35.364819F, 22.841089F, 32.083817F);
      ((Path)localObject).cubicTo(21.23609F, 26.404818F, 21.92609F, 20.047817F, 24.97509F, 14.964818F);
      ((Path)localObject).cubicTo(26.53409F, 12.374818F, 28.72209F, 10.126818F, 31.39809F, 8.691818F);
      ((Path)localObject).lineTo(31.39809F, 8.691818F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(32.603088F, 12.600818F);
      ((Path)localObject).cubicTo(30.362091F, 14.013818F, 28.667089F, 16.180819F, 27.57309F, 18.573818F);
      ((Path)localObject).cubicTo(26.03009F, 21.970818F, 25.64209F, 25.850819F, 26.33309F, 29.506817F);
      ((Path)localObject).cubicTo(26.91309F, 32.527817F, 28.276091F, 35.441818F, 30.445089F, 37.646816F);
      ((Path)localObject).cubicTo(31.00609F, 38.229816F, 31.64609F, 38.726818F, 32.28809F, 39.216816F);
      ((Path)localObject).cubicTo(33.376091F, 40.061817F, 34.01609F, 41.430817F, 34.007092F, 42.804817F);
      ((Path)localObject).cubicTo(33.994091F, 43.903816F, 34.01009F, 45.003819F, 33.998089F, 46.103817F);
      ((Path)localObject).cubicTo(33.990089F, 46.929817F, 33.701092F, 47.74482F, 33.20409F, 48.402817F);
      ((Path)localObject).cubicTo(32.442089F, 49.431816F, 31.286091F, 50.038818F, 30.23509F, 50.722816F);
      ((Path)localObject).cubicTo(25.13109F, 53.958817F, 20.035089F, 57.208817F, 14.89909F, 60.394817F);
      ((Path)localObject).cubicTo(14.11409F, 60.902817F, 13.250091F, 61.312817F, 12.58909F, 61.988819F);
      ((Path)localObject).cubicTo(11.78909F, 62.767818F, 11.26609F, 63.865818F, 11.32609F, 64.995819F);
      ((Path)localObject).cubicTo(29.11009F, 64.997818F, 46.895092F, 65.000816F, 64.679092F, 64.99482F);
      ((Path)localObject).cubicTo(64.699089F, 63.208817F, 63.388092F, 61.726818F, 61.910091F, 60.889816F);
      ((Path)localObject).cubicTo(56.129089F, 57.321819F, 50.408089F, 53.660816F, 44.67009F, 50.024818F);
      ((Path)localObject).cubicTo(43.64909F, 49.384819F, 42.66309F, 48.549816F, 42.243092F, 47.38382F);
      ((Path)localObject).cubicTo(41.957088F, 46.656818F, 42.001091F, 45.864819F, 42.00209F, 45.099819F);
      ((Path)localObject).cubicTo(42.000092F, 44.330818F, 42.006092F, 43.562817F, 41.997089F, 42.793819F);
      ((Path)localObject).cubicTo(41.99609F, 41.662819F, 42.425091F, 40.531818F, 43.194092F, 39.699818F);
      ((Path)localObject).cubicTo(43.630089F, 39.223816F, 44.18409F, 38.88382F, 44.671089F, 38.466816F);
      ((Path)localObject).cubicTo(46.650089F, 36.806816F, 48.083092F, 34.558819F, 48.953091F, 32.139816F);
      ((Path)localObject).cubicTo(50.318089F, 28.298819F, 50.351089F, 23.998817F, 49.050091F, 20.136818F);
      ((Path)localObject).cubicTo(48.125092F, 17.408817F, 46.485088F, 14.871818F, 44.168091F, 13.127818F);
      ((Path)localObject).cubicTo(42.512089F, 11.878818F, 40.492088F, 11.086818F, 38.411091F, 11.009818F);
      ((Path)localObject).cubicTo(36.369091F, 10.913817F, 34.32209F, 11.506818F, 32.603088F, 12.600818F);
      ((Path)localObject).lineTo(32.603088F, 12.600818F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 2);
      localCanvas.drawPath((Path)localObject, localPaint1);
      localCanvas.restore();
      localCanvas.restore();
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.navbar_me_icon_middle
 * JD-Core Version:    0.7.0.1
 */