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

public class bottomsheet_icon_qzone
  extends c
{
  private final int height = 96;
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
      return 96;
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
      localObject2 = c.setMatrixFloatArray((float[])localObject2, 1.0F, 0.0F, 7.0F, 0.0F, 1.0F, 10.0F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject2);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject1 = c.instancePaint(localPaint1, paramVarArgs);
      ((Paint)localObject1).setColor(-13032);
      localObject2 = c.instancePath(paramVarArgs);
      ((Path)localObject2).moveTo(80.047546F, 28.325209F);
      ((Path)localObject2).lineTo(56.156776F, 25.964645F);
      ((Path)localObject2).cubicTo(54.329502F, 25.794123F, 53.919743F, 25.509708F, 53.348091F, 24.029768F);
      ((Path)localObject2).lineTo(43.131153F, 1.436689F);
      ((Path)localObject2).cubicTo(42.196808F, -0.4788964F, 40.668846F, -0.4788964F, 39.735756F, 1.436689F);
      ((Path)localObject2).lineTo(28.844881F, 24.029768F);
      ((Path)localObject2).cubicTo(28.102551F, 25.281931F, 27.759935F, 25.565722F, 25.960896F, 25.736866F);
      ((Path)localObject2).lineTo(2.818103F, 28.325209F);
      ((Path)localObject2).cubicTo(0.6921367F, 28.536808F, 0.2171199F, 29.913439F, 1.76265F, 31.384047F);
      ((Path)localObject2).lineTo(19.921844F, 48.020016F);
      ((Path)localObject2).cubicTo(20.777754F, 48.817863F, 20.791559F, 49.157665F, 20.549345F, 50.254242F);
      ((Path)localObject2).lineTo(15.893301F, 74.66893F);
      ((Path)localObject2).cubicTo(15.499859F, 76.764374F, 16.692736F, 77.603302F, 18.542603F, 76.537216F);
      ((Path)localObject2).lineTo(39.269524F, 64.609932F);
      ((Path)localObject2).cubicTo(40.725323F, 63.699436F, 42.067543F, 63.672676F, 43.495102F, 64.553917F);
      ((Path)localObject2).lineTo(64.322426F, 76.537216F);
      ((Path)localObject2).cubicTo(66.173546F, 77.603302F, 67.370811F, 76.761887F, 66.983643F, 74.668312F);
      ((Path)localObject2).lineTo(63.421963F, 55.188213F);
      ((Path)localObject2).cubicTo(65.554832F, 54.468781F, 67.621185F, 53.588158F, 68.856728F, 52.591778F);
      ((Path)localObject2).lineTo(68.355362F, 52.689487F);
      ((Path)localObject2).cubicTo(66.162247F, 53.104595F, 64.444786F, 53.423859F, 63.106956F, 53.669064F);
      ((Path)localObject2).cubicTo(63.014088F, 52.996304F, 63.002163F, 52.988216F, 63.002163F, 52.988216F);
      ((Path)localObject2).lineTo(62.524639F, 50.287849F);
      ((Path)localObject2).cubicTo(62.335133F, 49.07365F, 62.524639F, 48.654808F, 63.440159F, 47.781654F);
      ((Path)localObject2).lineTo(81.073509F, 31.351685F);
      ((Path)localObject2).cubicTo(82.635986F, 29.90037F, 82.174774F, 28.536808F, 80.047546F, 28.325209F);
      ((Path)localObject2).lineTo(80.047546F, 28.325209F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 2);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.save();
      localPaint1 = c.instancePaint(localPaint1, paramVarArgs);
      localPaint1.setColor(-1);
      localObject1 = c.instancePath(paramVarArgs);
      ((Path)localObject1).moveTo(15.39444F, 33.373692F);
      ((Path)localObject1).cubicTo(15.39444F, 33.373692F, 37.508133F, 28.216299F, 62.775639F, 32.517963F);
      ((Path)localObject1).cubicTo(62.856586F, 32.531654F, 62.796974F, 32.706535F, 62.877293F, 32.72147F);
      ((Path)localObject1).cubicTo(62.877293F, 32.72147F, 55.036694F, 38.188171F, 47.961014F, 43.054306F);
      ((Path)localObject1).cubicTo(42.398235F, 46.880497F, 37.307961F, 50.276646F, 36.872478F, 50.750252F);
      ((Path)localObject1).cubicTo(36.872478F, 50.750252F, 36.560608F, 50.806263F, 36.962208F, 51.00666F);
      ((Path)localObject1).cubicTo(37.262154F, 51.156025F, 37.981266F, 51.215771F, 37.981266F, 51.215771F);
      ((Path)localObject1).cubicTo(37.981266F, 51.215771F, 56.060143F, 53.182388F, 68.622673F, 52.667084F);
      ((Path)localObject1).cubicTo(68.622673F, 52.667084F, 50.095764F, 58.072792F, 22.619463F, 54.425217F);
      ((Path)localObject1).cubicTo(22.619463F, 54.425217F, 22.295673F, 54.306347F, 22.562361F, 54.132713F);
      ((Path)localObject1).cubicTo(24.73037F, 52.718117F, 43.409134F, 39.430378F, 48.484348F, 35.899178F);
      ((Path)localObject1).cubicTo(48.484348F, 35.899178F, 48.836372F, 35.622856F, 48.522625F, 35.565598F);
      ((Path)localObject1).cubicTo(48.772995F, 35.611652F, 45.382618F, 34.984947F, 40.362F, 34.538727F);
      ((Path)localObject1).cubicTo(33.066067F, 33.890862F, 22.360306F, 33.546703F, 15.55759F, 33.412277F);
      ((Path)localObject1).cubicTo(15.488564F, 33.409786F, 15.460955F, 33.37307F, 15.39444F, 33.373692F);
      ((Path)localObject1).lineTo(15.39444F, 33.373692F);
      ((Path)localObject1).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject1, 2);
      localCanvas.drawPath((Path)localObject1, localPaint1);
      localCanvas.restore();
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.bottomsheet_icon_qzone
 * JD-Core Version:    0.7.0.1
 */