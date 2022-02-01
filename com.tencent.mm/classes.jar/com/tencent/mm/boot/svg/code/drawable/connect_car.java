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

public class connect_car
  extends c
{
  private final int height = 104;
  private final int width = 104;
  
  public int doCommand(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 104;
      return 104;
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
      localPaint1 = c.instancePaint(localPaint2, paramVarArgs);
      localPaint1.setStrokeWidth(1.0F);
      localCanvas.save();
      localPaint1 = c.instancePaint(localPaint1, paramVarArgs);
      localPaint1.setColor(-16777216);
      localPaint1.setStrokeWidth(0.8F);
      arrayOfFloat = c.setMatrixFloatArray(arrayOfFloat, 1.0F, 0.0F, 0.0F, 0.0F, 1.0F, 17.0F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject).reset();
      ((Matrix)localObject).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject);
      localCanvas.save();
      localPaint2 = c.instancePaint(localPaint1, paramVarArgs);
      Path localPath = c.instancePath(paramVarArgs);
      localPath.moveTo(88.755867F, 23.099455F);
      localPath.cubicTo(92.855408F, 23.099455F, 96.567001F, 24.746542F, 99.253609F, 27.410042F);
      localPath.cubicTo(101.84888F, 29.982988F, 103.48763F, 33.504501F, 103.59444F, 37.405212F);
      localPath.lineTo(103.59444F, 37.405212F);
      localPath.lineTo(103.24857F, 51.588764F);
      localPath.cubicTo(103.19301F, 53.736767F, 102.27876F, 55.666916F, 100.83691F, 57.060181F);
      localPath.cubicTo(99.464157F, 58.386681F, 97.613243F, 59.2267F, 95.568977F, 59.305489F);
      localPath.lineTo(95.568977F, 59.305489F);
      localPath.lineTo(8.747376F, 59.311573F);
      localPath.cubicTo(6.578142F, 59.311573F, 4.606412F, 58.454773F, 3.163192F, 57.060181F);
      localPath.cubicTo(1.79173F, 55.734932F, 0.8975354F, 53.923962F, 0.7657654F, 51.901733F);
      localPath.lineTo(0.7657654F, 51.901733F);
      localPath.lineTo(0.4049749F, 38.189144F);
      localPath.cubicTo(0.2999443F, 34.128178F, 1.865452F, 30.409615F, 4.480927F, 27.680161F);
      localPath.cubicTo(7.010063F, 25.040806F, 10.520879F, 23.326185F, 14.453171F, 23.120249F);
      localPath.lineTo(14.453171F, 23.120249F);
      localPath.close();
      localCanvas.drawPath(localPath, localPaint2);
      localCanvas.restore();
      localCanvas.save();
      localPaint2 = c.instancePaint(localPaint1, paramVarArgs);
      arrayOfFloat = c.setMatrixFloatArray(arrayOfFloat, 0.9659258F, -0.258819F, 5.301724F, 0.258819F, 0.9659258F, -1.696245F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject).reset();
      ((Matrix)localObject).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject);
      localPath = c.instancePath(paramVarArgs);
      localPath.moveTo(15.657042F, 17.890848F);
      localPath.lineTo(14.348248F, 17.750933F);
      localPath.cubicTo(13.877442F, 17.7006F, 13.441375F, 17.480009F, 13.122156F, 17.130695F);
      localPath.lineTo(12.291577F, 16.221811F);
      localPath.cubicTo(11.97562F, 15.876067F, 11.54507F, 15.656306F, 11.07945F, 15.603119F);
      localPath.lineTo(5.198644F, 14.931366F);
      localPath.cubicTo(4.279967F, 14.826427F, 3.41449F, 15.38375F, 3.130438F, 16.263184F);
      localPath.lineTo(2.810175F, 17.25473F);
      localPath.cubicTo(2.337133F, 18.719286F, 2.464534F, 20.311245F, 3.164443F, 21.681547F);
      localPath.lineTo(3.632799F, 22.598507F);
      localPath.cubicTo(4.007036F, 23.3312F, 4.803362F, 23.747957F, 5.619461F, 23.638227F);
      localPath.lineTo(12.089331F, 23.075294F);
      localCanvas.drawPath(localPath, localPaint2);
      localCanvas.restore();
      localCanvas.save();
      localPaint2 = c.instancePaint(localPaint1, paramVarArgs);
      arrayOfFloat = c.setMatrixFloatArray(arrayOfFloat, -0.9659258F, 0.258819F, 179.90298F, 0.258819F, 0.9659258F, -23.684677F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject).reset();
      ((Matrix)localObject).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject);
      localPath = c.instancePath(paramVarArgs);
      localPath.moveTo(100.61382F, 17.890848F);
      localPath.lineTo(99.305016F, 17.750933F);
      localPath.cubicTo(98.834213F, 17.7006F, 98.398148F, 17.480009F, 98.078926F, 17.130695F);
      localPath.lineTo(97.248352F, 16.221811F);
      localPath.cubicTo(96.932396F, 15.876067F, 96.501839F, 15.656306F, 96.036224F, 15.60312F);
      localPath.lineTo(90.155418F, 14.931366F);
      localPath.cubicTo(89.23674F, 14.826427F, 88.371262F, 15.38375F, 88.087212F, 16.263184F);
      localPath.lineTo(87.766945F, 17.25473F);
      localPath.cubicTo(87.293907F, 18.719286F, 87.421303F, 20.311245F, 88.121216F, 21.681547F);
      localPath.lineTo(88.589569F, 22.598507F);
      localPath.cubicTo(88.963806F, 23.3312F, 89.760132F, 23.747957F, 90.576233F, 23.638227F);
      localPath.lineTo(97.047386F, 22.853109F);
      localCanvas.drawPath(localPath, localPaint2);
      localCanvas.restore();
      localCanvas.save();
      localPaint2 = c.instancePaint(localPaint1, paramVarArgs);
      localPath = c.instancePath(paramVarArgs);
      localPath.moveTo(14.048651F, 23.257723F);
      localPath.lineTo(19.783968F, 12.553928F);
      localPath.cubicTo(23.788763F, 4.84107F, 31.761118F, 0.0F, 40.457989F, 0.0F);
      localPath.lineTo(62.742107F, 0.0F);
      localPath.cubicTo(71.43898F, 0.0F, 79.411331F, 4.84107F, 83.41613F, 12.553928F);
      localPath.lineTo(88.989738F, 23.257723F);
      localCanvas.drawPath(localPath, localPaint2);
      localCanvas.restore();
      localCanvas.save();
      localPaint2 = c.instancePaint(localPaint1, paramVarArgs);
      localPath = c.instancePath(paramVarArgs);
      localPath.moveTo(0.6791318F, 48.519604F);
      localPath.lineTo(0.759411F, 64.776207F);
      localPath.cubicTo(0.7725861F, 67.44416F, 2.941076F, 69.599998F, 5.611498F, 69.599998F);
      localPath.lineTo(12.610986F, 69.599998F);
      localPath.cubicTo(15.290752F, 69.599998F, 17.463131F, 67.429604F, 17.463131F, 64.752289F);
      localPath.lineTo(17.463131F, 59.711575F);
      localCanvas.drawPath(localPath, localPaint2);
      localCanvas.restore();
      localCanvas.save();
      localPaint2 = c.instancePaint(localPaint1, paramVarArgs);
      arrayOfFloat = c.setMatrixFloatArray(arrayOfFloat, -1.0F, 0.0F, 189.84555F, 0.0F, 1.0F, 0.0F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject).reset();
      ((Matrix)localObject).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject);
      localPath = c.instancePath(paramVarArgs);
      localPath.moveTo(86.530777F, 48.519604F);
      localPath.lineTo(86.611053F, 64.776207F);
      localPath.cubicTo(86.624229F, 67.444153F, 88.792725F, 69.599998F, 91.463142F, 69.599998F);
      localPath.lineTo(98.462631F, 69.599998F);
      localPath.cubicTo(101.1424F, 69.599998F, 103.31478F, 67.429604F, 103.31478F, 64.752289F);
      localPath.lineTo(103.31478F, 59.711575F);
      localCanvas.drawPath(localPath, localPaint2);
      localCanvas.restore();
      localCanvas.save();
      localPaint2 = c.instancePaint(localPaint1, paramVarArgs);
      arrayOfFloat = c.setMatrixFloatArray(arrayOfFloat, -0.9659258F, -0.258819F, 42.850792F, -0.258819F, 0.9659258F, 5.641416F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject).reset();
      ((Matrix)localObject).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject);
      localPath = c.instancePath(paramVarArgs);
      localPath.moveTo(9.815368F, 35.662468F);
      localPath.lineTo(13.044474F, 34.808121F);
      localPath.cubicTo(14.209912F, 34.499771F, 15.359911F, 34.135941F, 16.490536F, 33.717869F);
      localPath.lineTo(22.880451F, 31.355074F);
      localPath.cubicTo(24.156696F, 30.883158F, 25.574636F, 31.53455F, 26.047512F, 32.810001F);
      localPath.cubicTo(26.057766F, 32.837662F, 26.067524F, 32.865501F, 26.076778F, 32.893513F);
      localPath.cubicTo(26.59906F, 34.474327F, 26.642298F, 36.173889F, 26.201057F, 37.778736F);
      localPath.lineTo(26.077999F, 38.226318F);
      localPath.cubicTo(25.595577F, 39.980949F, 24.087198F, 41.261116F, 22.276136F, 41.452969F);
      localPath.lineTo(20.484247F, 41.642788F);
      localPath.cubicTo(17.600031F, 41.948322F, 14.690974F, 41.93956F, 11.808367F, 41.616657F);
      localPath.lineTo(9.882581F, 41.400936F);
      localPath.cubicTo(8.509759F, 41.247154F, 7.471398F, 40.08712F, 7.471082F, 38.706863F);
      localPath.cubicTo(7.470755F, 37.277916F, 8.433086F, 36.028191F, 9.815368F, 35.662468F);
      localPath.close();
      localCanvas.drawPath(localPath, localPaint2);
      localCanvas.restore();
      localCanvas.save();
      localPaint1 = c.instancePaint(localPaint1, paramVarArgs);
      arrayOfFloat = c.setMatrixFloatArray(arrayOfFloat, 0.9659258F, 0.258819F, -6.520418F, -0.258819F, 0.9659258F, 23.539434F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject).reset();
      ((Matrix)localObject).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject);
      localObject = c.instancePath(paramVarArgs);
      ((Path)localObject).moveTo(78.967995F, 35.662468F);
      ((Path)localObject).lineTo(82.197105F, 34.808121F);
      ((Path)localObject).cubicTo(83.362541F, 34.499771F, 84.512543F, 34.135941F, 85.643166F, 33.717869F);
      ((Path)localObject).lineTo(92.033081F, 31.355074F);
      ((Path)localObject).cubicTo(93.309326F, 30.883158F, 94.727264F, 31.53455F, 95.200142F, 32.810001F);
      ((Path)localObject).cubicTo(95.210396F, 32.837662F, 95.220154F, 32.865501F, 95.229408F, 32.893513F);
      ((Path)localObject).cubicTo(95.751686F, 34.474327F, 95.79493F, 36.173889F, 95.353683F, 37.778736F);
      ((Path)localObject).lineTo(95.230629F, 38.226318F);
      ((Path)localObject).cubicTo(94.748207F, 39.980949F, 93.23983F, 41.261116F, 91.428764F, 41.452969F);
      ((Path)localObject).lineTo(89.636871F, 41.642788F);
      ((Path)localObject).cubicTo(86.752663F, 41.948322F, 83.843605F, 41.93956F, 80.960999F, 41.616657F);
      ((Path)localObject).lineTo(79.03521F, 41.400936F);
      ((Path)localObject).cubicTo(77.662392F, 41.247154F, 76.624023F, 40.08712F, 76.623711F, 38.706863F);
      ((Path)localObject).cubicTo(76.623383F, 37.277916F, 77.585716F, 36.028191F, 78.967995F, 35.662468F);
      ((Path)localObject).close();
      localCanvas.drawPath((Path)localObject, localPaint1);
      localCanvas.restore();
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.connect_car
 * JD-Core Version:    0.7.0.1
 */