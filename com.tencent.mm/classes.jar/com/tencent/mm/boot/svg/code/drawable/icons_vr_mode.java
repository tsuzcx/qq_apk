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

public class icons_vr_mode
  extends c
{
  private final int height = 80;
  private final int width = 80;
  
  public int doCommand(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 80;
      return 80;
      Canvas localCanvas = (Canvas)paramVarArgs[0];
      paramVarArgs = (Looper)paramVarArgs[1];
      Object localObject1 = c.instanceMatrix(paramVarArgs);
      Object localObject2 = c.instanceMatrixArray(paramVarArgs);
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
      localPaint1.setColor(-1);
      localObject2 = c.setMatrixFloatArray((float[])localObject2, 1.0F, 0.0F, 4.0F, 0.0F, 1.0F, 5.0F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject2);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject2 = c.setMatrixFloatArray((float[])localObject2, 1.0F, 0.0F, 10.944563F, 0.0F, 1.0F, 7.428236F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject2);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject1 = c.instancePaint(localPaint1, paramVarArgs);
      localObject2 = c.instancePath(paramVarArgs);
      ((Path)localObject2).moveTo(26.599707F, 44.50074F);
      ((Path)localObject2).lineTo(13.174012F, 20.689857F);
      ((Path)localObject2).cubicTo(11.888547F, 18.410046F, 12.582877F, 15.524451F, 14.764727F, 14.078943F);
      ((Path)localObject2).cubicTo(16.915981F, 12.653705F, 19.812006F, 13.210377F, 21.281559F, 15.331605F);
      ((Path)localObject2).lineTo(29.585001F, 27.317202F);
      ((Path)localObject2).lineTo(35.895222F, 25.519569F);
      ((Path)localObject2).cubicTo(45.032524F, 22.916571F, 54.560268F, 28.164391F, 57.243961F, 37.27832F);
      ((Path)localObject2).lineTo(59.967999F, 46.529255F);
      ((Path)localObject2).cubicTo(61.19355F, 50.69128F, 59.235821F, 55.130035F, 55.335953F, 57.031475F);
      ((Path)localObject2).lineTo(43.918034F, 62.598454F);
      ((Path)localObject2).cubicTo(41.285561F, 63.881954F, 38.189831F, 63.786598F, 35.641338F, 62.343513F);
      ((Path)localObject2).lineTo(18.36338F, 52.559837F);
      ((Path)localObject2).cubicTo(16.08313F, 51.268642F, 14.912559F, 48.640503F, 15.478067F, 46.08181F);
      ((Path)localObject2).cubicTo(15.980861F, 43.806877F, 18.232653F, 42.370277F, 20.507584F, 42.87307F);
      ((Path)localObject2).lineTo(20.688755F, 42.917336F);
      ((Path)localObject2).lineTo(20.688755F, 42.917336F);
      ((Path)localObject2).lineTo(26.599707F, 44.50074F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 2);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.restore();
      localPaint1 = c.instancePaint(localPaint1, paramVarArgs);
      localPaint1.setColor(-1);
      localObject1 = c.instancePath(paramVarArgs);
      ((Path)localObject1).moveTo(27.981775F, 31.601889F);
      ((Path)localObject1).cubicTo(28.622484F, 31.601889F, 29.14188F, 32.176723F, 29.14188F, 32.885818F);
      ((Path)localObject1).lineTo(29.14188F, 32.885818F);
      ((Path)localObject1).lineTo(29.141983F, 43.585705F);
      ((Path)localObject1).lineTo(32.383198F, 43.585232F);
      ((Path)localObject1).cubicTo(32.44323F, 43.585232F, 32.502441F, 43.6007F, 32.556133F, 43.630413F);
      ((Path)localObject1).cubicTo(32.747158F, 43.736118F, 32.824585F, 43.993195F, 32.729073F, 44.204605F);
      ((Path)localObject1).lineTo(32.729073F, 44.204605F);
      ((Path)localObject1).lineTo(28.327652F, 53.947033F);
      ((Path)localObject1).cubicTo(28.290234F, 54.029858F, 28.229551F, 54.097019F, 28.154715F, 54.138432F);
      ((Path)localObject1).cubicTo(27.963692F, 54.244137F, 27.731411F, 54.158443F, 27.6359F, 53.947033F);
      ((Path)localObject1).lineTo(27.6359F, 53.947033F);
      ((Path)localObject1).lineTo(23.234478F, 44.204605F);
      ((Path)localObject1).cubicTo(23.20763F, 44.145176F, 23.193653F, 44.079647F, 23.193653F, 44.013206F);
      ((Path)localObject1).cubicTo(23.193653F, 43.776844F, 23.366785F, 43.585232F, 23.580355F, 43.585232F);
      ((Path)localObject1).lineTo(23.580355F, 43.585232F);
      ((Path)localObject1).lineTo(26.821983F, 43.585705F);
      ((Path)localObject1).lineTo(26.821672F, 32.885818F);
      ((Path)localObject1).lineTo(26.826982F, 32.762165F);
      ((Path)localObject1).cubicTo(26.883198F, 32.111084F, 27.378757F, 31.601889F, 27.981775F, 31.601889F);
      ((Path)localObject1).close();
      ((Path)localObject1).moveTo(10.553292F, 22.038719F);
      ((Path)localObject1).cubicTo(10.583006F, 22.092415F, 10.598475F, 22.151625F, 10.598475F, 22.211658F);
      ((Path)localObject1).lineTo(10.598F, 25.452871F);
      ((Path)localObject1).lineTo(23.898266F, 25.452974F);
      ((Path)localObject1).cubicTo(24.607359F, 25.452974F, 25.182194F, 25.972372F, 25.182194F, 26.613079F);
      ((Path)localObject1).cubicTo(25.182194F, 27.216099F, 24.672998F, 27.711658F, 24.021915F, 27.767872F);
      ((Path)localObject1).lineTo(23.898266F, 27.773184F);
      ((Path)localObject1).lineTo(10.598F, 27.772871F);
      ((Path)localObject1).lineTo(10.598475F, 31.0145F);
      ((Path)localObject1).cubicTo(10.598475F, 31.228069F, 10.406864F, 31.401201F, 10.170499F, 31.401201F);
      ((Path)localObject1).cubicTo(10.104057F, 31.401201F, 10.038528F, 31.387224F, 9.979102F, 31.360376F);
      ((Path)localObject1).lineTo(0.2366734F, 26.958956F);
      ((Path)localObject1).cubicTo(0.02526216F, 26.863443F, -0.06042917F, 26.631163F, 0.04527644F, 26.440142F);
      ((Path)localObject1).cubicTo(0.08668903F, 26.365303F, 0.1538482F, 26.304621F, 0.2366734F, 26.267202F);
      ((Path)localObject1).lineTo(9.979102F, 21.865782F);
      ((Path)localObject1).cubicTo(10.190514F, 21.770271F, 10.447587F, 21.847698F, 10.553292F, 22.038719F);
      ((Path)localObject1).close();
      ((Path)localObject1).moveTo(43.446709F, 22.038719F);
      ((Path)localObject1).cubicTo(43.552414F, 21.847698F, 43.809486F, 21.770271F, 44.020897F, 21.865782F);
      ((Path)localObject1).lineTo(44.020897F, 21.865782F);
      ((Path)localObject1).lineTo(53.763325F, 26.267202F);
      ((Path)localObject1).cubicTo(53.846153F, 26.304621F, 53.913311F, 26.365303F, 53.954723F, 26.440142F);
      ((Path)localObject1).cubicTo(54.060429F, 26.631163F, 53.974739F, 26.863443F, 53.763325F, 26.958956F);
      ((Path)localObject1).lineTo(53.763325F, 26.958956F);
      ((Path)localObject1).lineTo(44.020897F, 31.360376F);
      ((Path)localObject1).cubicTo(43.961472F, 31.387224F, 43.895943F, 31.401201F, 43.829502F, 31.401201F);
      ((Path)localObject1).cubicTo(43.593136F, 31.401201F, 43.401524F, 31.228069F, 43.401524F, 31.0145F);
      ((Path)localObject1).lineTo(43.401524F, 31.0145F);
      ((Path)localObject1).lineTo(43.402F, 27.772871F);
      ((Path)localObject1).lineTo(32.70211F, 27.773184F);
      ((Path)localObject1).lineTo(32.578461F, 27.767872F);
      ((Path)localObject1).cubicTo(31.927378F, 27.711658F, 31.418182F, 27.216099F, 31.418182F, 26.613079F);
      ((Path)localObject1).cubicTo(31.418182F, 25.972372F, 31.993017F, 25.452974F, 32.70211F, 25.452974F);
      ((Path)localObject1).lineTo(32.70211F, 25.452974F);
      ((Path)localObject1).lineTo(43.402F, 25.452871F);
      ((Path)localObject1).lineTo(43.401524F, 22.211658F);
      ((Path)localObject1).cubicTo(43.401524F, 22.151625F, 43.416992F, 22.092415F, 43.446709F, 22.038719F);
      ((Path)localObject1).close();
      ((Path)localObject1).moveTo(28.154715F, 0.04527644F);
      ((Path)localObject1).cubicTo(28.229551F, 0.08668903F, 28.290234F, 0.1538482F, 28.327652F, 0.2366734F);
      ((Path)localObject1).lineTo(32.729073F, 9.979102F);
      ((Path)localObject1).cubicTo(32.824585F, 10.190514F, 32.747158F, 10.447587F, 32.556133F, 10.553292F);
      ((Path)localObject1).cubicTo(32.502441F, 10.583006F, 32.44323F, 10.598475F, 32.383198F, 10.598475F);
      ((Path)localObject1).lineTo(29.141983F, 10.598F);
      ((Path)localObject1).lineTo(29.14188F, 21.297888F);
      ((Path)localObject1).cubicTo(29.14188F, 22.006983F, 28.622484F, 22.581818F, 27.981775F, 22.581818F);
      ((Path)localObject1).cubicTo(27.378757F, 22.581818F, 26.883198F, 22.072622F, 26.826982F, 21.421539F);
      ((Path)localObject1).lineTo(26.821672F, 21.297888F);
      ((Path)localObject1).lineTo(26.821983F, 10.598F);
      ((Path)localObject1).lineTo(23.580355F, 10.598475F);
      ((Path)localObject1).cubicTo(23.366785F, 10.598475F, 23.193653F, 10.406864F, 23.193653F, 10.170499F);
      ((Path)localObject1).cubicTo(23.193653F, 10.104057F, 23.20763F, 10.038528F, 23.234478F, 9.979102F);
      ((Path)localObject1).lineTo(27.6359F, 0.2366734F);
      ((Path)localObject1).cubicTo(27.731411F, 0.02526216F, 27.963692F, -0.06042917F, 28.154715F, 0.04527644F);
      ((Path)localObject1).close();
      localCanvas.saveLayerAlpha(null, 128, 31);
      localPaint1 = c.instancePaint(localPaint1, paramVarArgs);
      WeChatSVGRenderC2Java.setFillType((Path)localObject1, 1);
      localCanvas.drawPath((Path)localObject1, localPaint1);
      localCanvas.restore();
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.icons_vr_mode
 * JD-Core Version:    0.7.0.1
 */