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

public class float_ball_state_finder
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
      localPaint2 = c.instancePaint(localPaint2, paramVarArgs);
      localPaint2.setStrokeWidth(1.0F);
      localCanvas.save();
      Paint localPaint3 = c.instancePaint(localPaint1, paramVarArgs);
      localPaint3.setColor(-352965);
      Path localPath = c.instancePath(paramVarArgs);
      localPath.moveTo(60.0F, 0.0F);
      localPath.cubicTo(93.137085F, 0.0F, 120.0F, 26.862915F, 120.0F, 60.0F);
      localPath.cubicTo(120.0F, 93.137085F, 93.137085F, 120.0F, 60.0F, 120.0F);
      localPath.cubicTo(26.862915F, 120.0F, 0.0F, 93.137085F, 0.0F, 60.0F);
      localPath.cubicTo(0.0F, 26.862915F, 26.862915F, 0.0F, 60.0F, 0.0F);
      localPath.close();
      localCanvas.drawPath(localPath, localPaint3);
      localCanvas.restore();
      localCanvas.save();
      arrayOfFloat = c.setMatrixFloatArray(arrayOfFloat, 1.0F, 0.0F, 24.0F, 0.0F, 1.0F, 24.0F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject).reset();
      ((Matrix)localObject).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject);
      localObject = c.instancePath(paramVarArgs);
      ((Path)localObject).moveTo(0.0F, 0.0F);
      ((Path)localObject).lineTo(72.0F, 0.0F);
      ((Path)localObject).lineTo(72.0F, 72.0F);
      ((Path)localObject).lineTo(0.0F, 72.0F);
      ((Path)localObject).lineTo(0.0F, 0.0F);
      ((Path)localObject).close();
      localCanvas.save();
      localPaint1 = c.instancePaint(localPaint1, paramVarArgs);
      localPaint2 = c.instancePaint(localPaint2, paramVarArgs);
      localPaint1.setColor(-1);
      localPaint2.setColor(-1);
      localPaint2.setStrokeWidth(1.5F);
      localObject = c.instancePath(paramVarArgs);
      ((Path)localObject).moveTo(17.714867F, 12.521391F);
      ((Path)localObject).cubicTo(20.004908F, 13.44775F, 22.545315F, 15.645851F, 25.37252F, 18.967289F);
      ((Path)localObject).cubicTo(27.020041F, 20.902817F, 28.743801F, 23.194654F, 30.517719F, 25.771339F);
      ((Path)localObject).cubicTo(32.475677F, 28.615353F, 34.393993F, 31.656507F, 36.195972F, 34.698944F);
      ((Path)localObject).cubicTo(38.071041F, 32.569256F, 39.465797F, 30.440718F, 40.825825F, 28.377422F);
      ((Path)localObject).lineTo(41.407867F, 27.497334F);
      ((Path)localObject).lineTo(42.575592F, 25.771339F);
      ((Path)localObject).cubicTo(44.34951F, 23.194654F, 46.073269F, 20.902817F, 47.720791F, 18.967289F);
      ((Path)localObject).cubicTo(50.547997F, 15.645851F, 53.088402F, 13.44775F, 55.378445F, 12.521391F);
      ((Path)localObject).cubicTo(57.09531F, 11.826891F, 58.682552F, 11.838786F, 60.029186F, 12.482003F);
      ((Path)localObject).cubicTo(61.340725F, 13.108459F, 62.441357F, 14.348611F, 63.186249F, 16.213264F);
      ((Path)localObject).cubicTo(65.099525F, 21.001545F, 63.790642F, 32.618187F, 61.082283F, 42.823254F);
      ((Path)localObject).cubicTo(59.722946F, 47.945225F, 58.020142F, 52.704884F, 56.226532F, 56.04995F);
      ((Path)localObject).cubicTo(55.381554F, 57.62582F, 54.512196F, 58.892654F, 53.651424F, 59.752964F);
      ((Path)localObject).cubicTo(52.738945F, 60.664955F, 51.821217F, 61.125771F, 50.949104F, 61.125771F);
      ((Path)localObject).cubicTo(48.641136F, 61.125771F, 46.282604F, 59.295658F, 43.561356F, 55.809723F);
      ((Path)localObject).cubicTo(42.39769F, 54.31905F, 41.182602F, 52.542404F, 39.933674F, 50.536915F);
      ((Path)localObject).cubicTo(38.938812F, 48.939388F, 37.960854F, 47.259769F, 37.019325F, 45.55616F);
      ((Path)localObject).cubicTo(35.443832F, 46.722153F, 34.313091F, 48.684723F, 33.159637F, 50.536915F);
      ((Path)localObject).cubicTo(31.910711F, 52.542404F, 30.695623F, 54.31905F, 29.531954F, 55.809723F);
      ((Path)localObject).cubicTo(26.810709F, 59.295658F, 24.452173F, 61.125771F, 22.144205F, 61.125771F);
      ((Path)localObject).cubicTo(21.272097F, 61.125771F, 20.354372F, 60.664959F, 19.441895F, 59.752972F);
      ((Path)localObject).cubicTo(18.581127F, 58.89267F, 17.711771F, 57.625843F, 16.866795F, 56.04998F);
      ((Path)localObject).cubicTo(15.073187F, 52.704933F, 13.370382F, 47.945297F, 12.011043F, 42.823349F);
      ((Path)localObject).cubicTo(9.302666F, 32.618279F, 7.993758F, 21.001619F, 9.906994F, 16.213434F);
      ((Path)localObject).cubicTo(10.651925F, 14.34868F, 11.752563F, 13.108501F, 13.064101F, 12.482028F);
      ((Path)localObject).cubicTo(14.410745F, 11.838786F, 15.997993F, 11.826888F, 17.714867F, 12.521391F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(14.930977F, 16.551762F);
      ((Path)localObject).cubicTo(14.599188F, 16.740349F, 14.362779F, 17.183575F, 14.090804F, 17.864397F);
      ((Path)localObject).cubicTo(12.900332F, 20.843746F, 13.448977F, 28.354488F, 15.211088F, 36.766678F);
      ((Path)localObject).lineTo(15.211088F, 36.766678F);
      ((Path)localObject).lineTo(15.629712F, 38.678913F);
      ((Path)localObject).lineTo(16.088438F, 40.608051F);
      ((Path)localObject).lineTo(16.355417F, 41.661987F);
      ((Path)localObject).cubicTo(17.34952F, 45.493809F, 18.503006F, 48.953751F, 19.56753F, 51.610027F);
      ((Path)localObject).cubicTo(20.220613F, 53.239651F, 20.83856F, 54.563904F, 21.36503F, 55.480522F);
      ((Path)localObject).cubicTo(21.58415F, 55.862022F, 21.787617F, 56.164558F, 22.319408F, 56.626308F);
      ((Path)localObject).cubicTo(23.052942F, 56.428833F, 24.389593F, 55.098671F, 25.975286F, 53.067383F);
      ((Path)localObject).cubicTo(27.036539F, 51.707909F, 28.164154F, 50.057617F, 29.331907F, 48.182472F);
      ((Path)localObject).cubicTo(30.28426F, 46.653214F, 31.224194F, 45.038574F, 32.128471F, 43.402309F);
      ((Path)localObject).lineTo(32.128471F, 43.402309F);
      ((Path)localObject).lineTo(33.225048F, 41.375816F);
      ((Path)localObject).lineTo(34.001286F, 39.880608F);
      ((Path)localObject).lineTo(33.18935F, 38.458813F);
      ((Path)localObject).lineTo(32.31406F, 36.964046F);
      ((Path)localObject).lineTo(31.250776F, 35.192356F);
      ((Path)localObject).cubicTo(29.816496F, 32.834183F, 28.319506F, 30.501034F, 26.802559F, 28.297609F);
      ((Path)localObject).cubicTo(25.112808F, 25.843184F, 23.479263F, 23.670023F, 21.935764F, 21.856699F);
      ((Path)localObject).cubicTo(19.59366F, 19.105167F, 17.559689F, 17.288795F, 14.930977F, 16.551762F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(57.075512F, 16.665077F);
      ((Path)localObject).cubicTo(55.533623F, 17.288795F, 53.499649F, 19.105167F, 51.157547F, 21.856699F);
      ((Path)localObject).cubicTo(49.614048F, 23.670023F, 47.980503F, 25.843184F, 46.290752F, 28.297609F);
      ((Path)localObject).cubicTo(44.774017F, 30.500731F, 43.277225F, 32.833553F, 41.842396F, 35.192635F);
      ((Path)localObject).lineTo(41.842396F, 35.192635F);
      ((Path)localObject).lineTo(40.365555F, 37.667419F);
      ((Path)localObject).lineTo(39.528271F, 40.727425F);
      ((Path)localObject).lineTo(40.073864F, 41.762241F);
      ((Path)localObject).lineTo(40.964767F, 43.402233F);
      ((Path)localObject).cubicTo(41.868652F, 45.037792F, 42.808815F, 46.652832F, 43.761402F, 48.182472F);
      ((Path)localObject).cubicTo(44.929157F, 50.057617F, 46.05677F, 51.707909F, 47.118023F, 53.067383F);
      ((Path)localObject).cubicTo(48.691952F, 55.083599F, 50.045139F, 56.509083F, 51.728279F, 55.480522F);
      ((Path)localObject).cubicTo(52.254753F, 54.563904F, 52.8727F, 53.239651F, 53.525784F, 51.610027F);
      ((Path)localObject).cubicTo(54.68708F, 48.712273F, 55.95425F, 44.858086F, 57.006058F, 40.603168F);
      ((Path)localObject).lineTo(57.006058F, 40.603168F);
      ((Path)localObject).lineTo(57.465839F, 38.669098F);
      ((Path)localObject).lineTo(57.657963F, 37.812153F);
      ((Path)localObject).cubicTo(59.601421F, 28.981955F, 60.242569F, 20.967857F, 59.002472F, 17.864313F);
      ((Path)localObject).cubicTo(58.730507F, 17.183514F, 58.494114F, 16.740318F, 57.075512F, 16.665077F);
      ((Path)localObject).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject, 1);
      localCanvas.drawPath((Path)localObject, localPaint1);
      localCanvas.drawPath((Path)localObject, localPaint2);
      localCanvas.restore();
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.float_ball_state_finder
 * JD-Core Version:    0.7.0.1
 */