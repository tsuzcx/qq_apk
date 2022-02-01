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

public class icon_filled_activity
  extends c
{
  private final int height = 90;
  private final int width = 90;
  
  public int doCommand(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 90;
      return 90;
      Canvas localCanvas = (Canvas)paramVarArgs[0];
      paramVarArgs = (Looper)paramVarArgs[1];
      Object localObject1 = c.instanceMatrix(paramVarArgs);
      Object localObject2 = c.instanceMatrixArray(paramVarArgs);
      Object localObject3 = c.instancePaint(paramVarArgs);
      ((Paint)localObject3).setFlags(385);
      ((Paint)localObject3).setStyle(Paint.Style.FILL);
      Object localObject4 = c.instancePaint(paramVarArgs);
      ((Paint)localObject4).setFlags(385);
      ((Paint)localObject4).setStyle(Paint.Style.STROKE);
      ((Paint)localObject3).setColor(-16777216);
      ((Paint)localObject4).setStrokeWidth(1.0F);
      ((Paint)localObject4).setStrokeCap(Paint.Cap.BUTT);
      ((Paint)localObject4).setStrokeJoin(Paint.Join.MITER);
      ((Paint)localObject4).setStrokeMiter(4.0F);
      ((Paint)localObject4).setPathEffect(null);
      c.instancePaint((Paint)localObject4, paramVarArgs).setStrokeWidth(1.0F);
      localCanvas.save();
      localObject4 = c.instancePaint((Paint)localObject3, paramVarArgs);
      ((Paint)localObject4).setColor(-855310);
      Path localPath = c.instancePath(paramVarArgs);
      localPath.moveTo(0.0F, 0.0F);
      localPath.lineTo(90.0F, 0.0F);
      localPath.lineTo(90.0F, 90.0F);
      localPath.lineTo(0.0F, 90.0F);
      localPath.lineTo(0.0F, 0.0F);
      localPath.close();
      localCanvas.drawPath(localPath, (Paint)localObject4);
      localCanvas.restore();
      localCanvas.save();
      localObject3 = c.instancePaint((Paint)localObject3, paramVarArgs);
      ((Paint)localObject3).setColor(-2147483648);
      localObject4 = c.setMatrixFloatArray((float[])localObject2, 1.0F, 0.0F, 18.0F, 0.0F, 1.0F, 18.0F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject4);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject2 = c.instancePaint((Paint)localObject3, paramVarArgs);
      localObject3 = c.setMatrixFloatArray((float[])localObject4, 0.8987941F, -0.4383712F, 15.343878F, 0.4383712F, 0.8987941F, -7.476216F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject3);
      localCanvas.concat((Matrix)localObject1);
      localObject1 = c.instancePath(paramVarArgs);
      ((Path)localObject1).moveTo(22.157137F, 48.809395F);
      ((Path)localObject1).lineTo(5.970486F, 15.38923F);
      ((Path)localObject1).cubicTo(5.713478F, 14.835043F, 5.934237F, 14.176727F, 6.473492F, 13.889235F);
      ((Path)localObject1).cubicTo(6.525796F, 13.819521F, 6.592122F, 13.76152F, 6.668204F, 13.718965F);
      ((Path)localObject1).cubicTo(8.274843F, 12.573145F, 10.051613F, 11.686666F, 11.933543F, 11.091946F);
      ((Path)localObject1).cubicTo(13.843744F, 10.485227F, 15.828424F, 10.144188F, 17.831696F, 10.078435F);
      ((Path)localObject1).lineTo(18.642996F, 10.078435F);
      ((Path)localObject1).cubicTo(20.909342F, 10.082901F, 23.162401F, 10.42448F, 25.32811F, 11.091946F);
      ((Path)localObject1).cubicTo(27.85574F, 11.982647F, 30.497282F, 12.509542F, 33.173382F, 12.656806F);
      ((Path)localObject1).cubicTo(35.850674F, 12.656806F, 37.027058F, 11.635187F, 38.511738F, 10.337893F);
      ((Path)localObject1).lineTo(38.86871F, 10.029786F);
      ((Path)localObject1).cubicTo(39.240585F, 9.679944F, 39.729198F, 9.480572F, 40.239807F, 9.470328F);
      ((Path)localObject1).cubicTo(40.524784F, 9.470834F, 40.804604F, 9.546339F, 41.051109F, 9.689247F);
      ((Path)localObject1).cubicTo(41.935425F, 10.216272F, 41.911087F, 11.310863F, 41.821842F, 12.048699F);
      ((Path)localObject1).cubicTo(41.678219F, 12.981487F, 41.430584F, 13.895281F, 41.083561F, 14.773016F);
      ((Path)localObject1).cubicTo(40.095985F, 17.417664F, 38.564888F, 19.826162F, 36.588959F, 21.843266F);
      ((Path)localObject1).cubicTo(35.482128F, 22.963287F, 34.178581F, 23.87027F, 32.743393F, 24.518932F);
      ((Path)localObject1).lineTo(32.467552F, 24.632446F);
      ((Path)localObject1).cubicTo(31.249294F, 25.129654F, 29.94603F, 25.385744F, 28.630102F, 25.386497F);
      ((Path)localObject1).lineTo(27.778236F, 25.386497F);
      ((Path)localObject1).cubicTo(26.918259F, 25.313526F, 26.098845F, 25.281094F, 25.344336F, 25.281094F);
      ((Path)localObject1).cubicTo(18.853933F, 25.281094F, 17.361141F, 27.875681F, 16.046835F, 30.145945F);
      ((Path)localObject1).lineTo(15.981931F, 30.267565F);
      ((Path)localObject1).lineTo(24.501795F, 47.852638F);
      ((Path)localObject1).cubicTo(24.625086F, 48.13435F, 24.625086F, 48.454712F, 24.501795F, 48.73642F);
      ((Path)localObject1).cubicTo(24.3748F, 49.054676F, 24.122526F, 49.306797F, 23.804075F, 49.433716F);
      ((Path)localObject1).cubicTo(23.653135F, 49.487877F, 23.493896F, 49.514996F, 23.333521F, 49.514996F);
      ((Path)localObject1).cubicTo(22.839455F, 49.520954F, 22.384201F, 49.247967F, 22.157137F, 48.809395F);
      ((Path)localObject1).close();
      ((Path)localObject1).moveTo(14.675737F, 27.535141F);
      ((Path)localObject1).cubicTo(15.461037F, 26.334681F, 16.506346F, 25.326029F, 17.734339F, 24.583797F);
      ((Path)localObject1).cubicTo(19.681459F, 23.424341F, 22.188377F, 22.864883F, 25.409239F, 22.864883F);
      ((Path)localObject1).cubicTo(26.220539F, 22.864883F, 27.104856F, 22.864883F, 28.013514F, 22.978397F);
      ((Path)localObject1).lineTo(28.638214F, 22.978397F);
      ((Path)localObject1).cubicTo(30.926081F, 22.978397F, 33.084141F, 21.932455F, 35.039375F, 19.864893F);
      ((Path)localObject1).cubicTo(36.469852F, 18.315645F, 37.615166F, 16.525976F, 38.422497F, 14.578422F);
      ((Path)localObject1).cubicTo(38.62532F, 14.100045F, 38.795692F, 13.645992F, 38.925503F, 13.208156F);
      ((Path)localObject1).cubicTo(37.799786F, 14.082996F, 36.47163F, 14.660226F, 35.063713F, 14.886529F);
      ((Path)localObject1).cubicTo(34.452194F, 14.985987F, 33.833504F, 15.034801F, 33.213947F, 15.032475F);
      ((Path)localObject1).cubicTo(30.249949F, 14.893803F, 27.321131F, 14.33133F, 24.516809F, 13.362209F);
      ((Path)localObject1).cubicTo(22.602219F, 12.763239F, 20.608618F, 12.454405F, 18.60243F, 12.445995F);
      ((Path)localObject1).cubicTo(16.655602F, 12.450294F, 14.721017F, 12.753841F, 12.866538F, 13.345993F);
      ((Path)localObject1).cubicTo(11.410968F, 13.800372F, 10.020244F, 14.440807F, 8.728907F, 15.251392F);
      ((Path)localObject1).lineTo(14.675737F, 27.535141F);
      ((Path)localObject1).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject1, 2);
      localCanvas.drawPath((Path)localObject1, (Paint)localObject2);
      localCanvas.restore();
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.icon_filled_activity
 * JD-Core Version:    0.7.0.1
 */