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

public final class azu
  extends c
{
  private final int height = 64;
  private final int width = 64;
  
  public final int a(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 64;
      return 64;
      Canvas localCanvas = (Canvas)paramVarArgs[0];
      paramVarArgs = (Looper)paramVarArgs[1];
      Object localObject1 = c.j(paramVarArgs);
      float[] arrayOfFloat = c.i(paramVarArgs);
      Object localObject2 = c.m(paramVarArgs);
      ((Paint)localObject2).setFlags(385);
      ((Paint)localObject2).setStyle(Paint.Style.FILL);
      Paint localPaint = c.m(paramVarArgs);
      localPaint.setFlags(385);
      localPaint.setStyle(Paint.Style.STROKE);
      ((Paint)localObject2).setColor(-16777216);
      localPaint.setStrokeWidth(1.0F);
      localPaint.setStrokeCap(Paint.Cap.BUTT);
      localPaint.setStrokeJoin(Paint.Join.MITER);
      localPaint.setStrokeMiter(4.0F);
      localPaint.setPathEffect(null);
      c.a(localPaint, paramVarArgs).setStrokeWidth(1.0F);
      localCanvas.save();
      arrayOfFloat = c.a(arrayOfFloat, 1.0F, 0.0F, -267.0F, 0.0F, 1.0F, -136.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      arrayOfFloat = c.a(arrayOfFloat, 1.0F, 0.0F, 267.0F, 0.0F, 1.0F, 136.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject1);
      localObject1 = c.a((Paint)localObject2, paramVarArgs);
      ((Paint)localObject1).setColor(-16777216);
      localCanvas.save();
      localObject1 = c.a((Paint)localObject1, paramVarArgs);
      localObject2 = c.n(paramVarArgs);
      ((Path)localObject2).moveTo(32.0F, 5.333334F);
      ((Path)localObject2).cubicTo(46.727592F, 5.333334F, 58.666668F, 17.272408F, 58.666668F, 32.0F);
      ((Path)localObject2).cubicTo(58.666668F, 39.42807F, 55.629566F, 46.14679F, 50.729397F, 50.982124F);
      ((Path)localObject2).lineTo(51.177071F, 50.52977F);
      ((Path)localObject2).cubicTo(51.010399F, 50.702225F, 50.841423F, 50.872444F, 50.670189F, 51.040367F);
      ((Path)localObject2).cubicTo(50.368256F, 51.336468F, 50.059284F, 51.625465F, 49.743568F, 51.907066F);
      ((Path)localObject2).cubicTo(49.716835F, 51.930912F, 49.690353F, 51.954437F, 49.663822F, 51.977913F);
      ((Path)localObject2).cubicTo(49.342503F, 52.262241F, 49.013821F, 52.539295F, 48.678497F, 52.808414F);
      ((Path)localObject2).cubicTo(48.661995F, 52.821659F, 48.645828F, 52.834599F, 48.62965F, 52.847523F);
      ((Path)localObject2).cubicTo(45.392883F, 55.432819F, 41.540752F, 57.280045F, 37.328178F, 58.134281F);
      ((Path)localObject2).lineTo(37.33279F, 58.133347F);
      ((Path)localObject2).lineTo(37.256996F, 58.148617F);
      ((Path)localObject2).cubicTo(36.870956F, 58.2258F, 36.481907F, 58.294647F, 36.090046F, 58.354961F);
      ((Path)localObject2).cubicTo(36.054695F, 58.360405F, 36.019672F, 58.365723F, 35.984627F, 58.370975F);
      ((Path)localObject2).cubicTo(35.799191F, 58.398762F, 35.612667F, 58.424698F, 35.425541F, 58.448692F);
      ((Path)localObject2).cubicTo(35.369091F, 58.455933F, 35.312172F, 58.463047F, 35.255196F, 58.469982F);
      ((Path)localObject2).cubicTo(35.083366F, 58.490891F, 34.911438F, 58.510124F, 34.739021F, 58.527718F);
      ((Path)localObject2).cubicTo(34.724178F, 58.529232F, 34.709156F, 58.53075F, 34.694126F, 58.532257F);
      ((Path)localObject2).cubicTo(34.494987F, 58.552238F, 34.295345F, 58.570011F, 34.095085F, 58.585575F);
      ((Path)localObject2).cubicTo(34.047504F, 58.589275F, 34.000164F, 58.592827F, 33.952793F, 58.596256F);
      ((Path)localObject2).cubicTo(33.783314F, 58.608521F, 33.613266F, 58.619213F, 33.442791F, 58.6283F);
      ((Path)localObject2).cubicTo(33.407295F, 58.630192F, 33.371906F, 58.632011F, 33.336498F, 58.633759F);
      ((Path)localObject2).cubicTo(33.13187F, 58.64386F, 32.926399F, 58.651661F, 32.720348F, 58.657127F);
      ((Path)localObject2).cubicTo(32.689941F, 58.657932F, 32.659966F, 58.658676F, 32.629978F, 58.65937F);
      ((Path)localObject2).cubicTo(32.567253F, 58.660828F, 32.504143F, 58.662071F, 32.440983F, 58.663094F);
      ((Path)localObject2).lineTo(32.0F, 58.666668F);
      ((Path)localObject2).lineTo(32.0F, 58.666668F);
      ((Path)localObject2).cubicTo(31.789318F, 58.666668F, 31.579206F, 58.664223F, 31.369694F, 58.659363F);
      ((Path)localObject2).lineTo(32.0F, 58.666668F);
      ((Path)localObject2).cubicTo(31.759592F, 58.666668F, 31.519928F, 58.663486F, 31.281046F, 58.657162F);
      ((Path)localObject2).cubicTo(31.073915F, 58.651676F, 30.867764F, 58.643848F, 30.662222F, 58.633694F);
      ((Path)localObject2).cubicTo(30.629131F, 58.632057F, 30.596735F, 58.630398F, 30.564356F, 58.628681F);
      ((Path)localObject2).cubicTo(30.391026F, 58.619488F, 30.217554F, 58.608601F, 30.04454F, 58.596062F);
      ((Path)localObject2).cubicTo(29.999208F, 58.592773F, 29.954235F, 58.589401F, 29.909292F, 58.585915F);
      ((Path)localObject2).cubicTo(29.708107F, 58.570316F, 29.507149F, 58.552444F, 29.306845F, 58.532356F);
      ((Path)localObject2).cubicTo(29.28949F, 58.530617F, 29.272135F, 58.528858F, 29.254782F, 58.527084F);
      ((Path)localObject2).cubicTo(29.088734F, 58.510101F, 28.923233F, 58.491608F, 28.758198F, 58.471607F);
      ((Path)localObject2).cubicTo(28.695084F, 58.463959F, 28.631474F, 58.45602F, 28.567932F, 58.447857F);
      ((Path)localObject2).cubicTo(28.380272F, 58.42374F, 28.193672F, 58.397743F, 28.007702F, 58.369823F);
      ((Path)localObject2).cubicTo(27.97743F, 58.365276F, 27.947412F, 58.360718F, 27.917414F, 58.35611F);
      ((Path)localObject2).cubicTo(27.727987F, 58.327007F, 27.539112F, 58.295895F, 27.350918F, 58.26281F);
      ((Path)localObject2).cubicTo(27.335026F, 58.260014F, 27.319065F, 58.257195F, 27.303108F, 58.254356F);
      ((Path)localObject2).cubicTo(27.119144F, 58.221668F, 26.935852F, 58.187096F, 26.753231F, 58.150658F);
      ((Path)localObject2).cubicTo(26.724974F, 58.14502F, 26.696083F, 58.139206F, 26.667212F, 58.133347F);
      ((Path)localObject2).cubicTo(22.557322F, 57.299995F, 18.786343F, 55.518166F, 15.596864F, 53.026455F);
      ((Path)localObject2).lineTo(15.370352F, 52.847523F);
      ((Path)localObject2).lineTo(15.349404F, 52.830776F);
      ((Path)localObject2).cubicTo(15.189836F, 52.703064F, 15.031766F, 52.573551F, 14.875226F, 52.44228F);
      ((Path)localObject2).lineTo(15.370352F, 52.847523F);
      ((Path)localObject2).cubicTo(15.175506F, 52.691895F, 14.982889F, 52.533592F, 14.792559F, 52.372669F);
      ((Path)localObject2).cubicTo(14.295941F, 51.952766F, 13.815305F, 51.515442F, 13.351187F, 51.061306F);
      ((Path)localObject2).cubicTo(13.317915F, 51.028751F, 13.28436F, 50.995747F, 13.250893F, 50.962654F);
      ((Path)localObject2).cubicTo(13.111716F, 50.825024F, 12.97471F, 50.686562F, 12.839224F, 50.546616F);
      ((Path)localObject2).cubicTo(12.834029F, 50.541248F, 12.828477F, 50.535511F, 12.822928F, 50.52977F);
      ((Path)localObject2).lineTo(12.573643F, 50.26833F);
      ((Path)localObject2).cubicTo(8.084096F, 45.496014F, 5.333334F, 39.069244F, 5.333334F, 32.0F);
      ((Path)localObject2).cubicTo(5.333334F, 17.272408F, 17.272408F, 5.333334F, 32.0F, 5.333334F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(32.0F, 8.533334F);
      ((Path)localObject2).cubicTo(19.039719F, 8.533334F, 8.533334F, 19.039719F, 8.533334F, 32.0F);
      ((Path)localObject2).cubicTo(8.533334F, 38.712532F, 11.351698F, 44.7668F, 15.869644F, 49.044022F);
      ((Path)localObject2).lineTo(24.731869F, 44.717716F);
      ((Path)localObject2).cubicTo(26.921005F, 43.649441F, 27.430023F, 41.283367F, 25.849188F, 39.409702F);
      ((Path)localObject2).lineTo(24.885101F, 38.267036F);
      ((Path)localObject2).cubicTo(23.329359F, 36.423115F, 22.007238F, 33.309536F, 21.526749F, 30.583244F);
      ((Path)localObject2).lineTo(21.509836F, 30.480856F);
      ((Path)localObject2).cubicTo(22.613081F, 30.576036F, 23.716351F, 30.6562F, 24.819639F, 30.72135F);
      ((Path)localObject2).cubicTo(25.285961F, 32.719452F, 26.268627F, 34.944485F, 27.330875F, 36.203499F);
      ((Path)localObject2).lineTo(28.294962F, 37.346169F);
      ((Path)localObject2).cubicTo(31.217697F, 40.810295F, 30.200571F, 45.609734F, 26.135252F, 47.593567F);
      ((Path)localObject2).lineTo(18.604624F, 51.270332F);
      ((Path)localObject2).cubicTo(22.402987F, 53.915638F, 27.020361F, 55.466667F, 32.0F, 55.466667F);
      ((Path)localObject2).cubicTo(36.979198F, 55.466667F, 41.596203F, 53.915909F, 45.394375F, 51.27103F);
      ((Path)localObject2).lineTo(37.865215F, 47.597439F);
      ((Path)localObject2).cubicTo(33.794331F, 45.611713F, 32.788193F, 40.80777F, 35.704899F, 37.350315F);
      ((Path)localObject2).lineTo(36.668983F, 36.207489F);
      ((Path)localObject2).cubicTo(37.727684F, 34.952511F, 38.712376F, 32.720802F, 39.180656F, 30.719244F);
      ((Path)localObject2).cubicTo(40.283699F, 30.656153F, 41.386696F, 30.576008F, 42.489677F, 30.480856F);
      ((Path)localObject2).cubicTo(42.024834F, 33.231907F, 40.685001F, 36.409664F, 39.114899F, 38.270863F);
      ((Path)localObject2).lineTo(38.150814F, 39.413689F);
      ((Path)localObject2).cubicTo(36.578754F, 41.277203F, 37.069836F, 43.649059F, 39.268131F, 44.721359F);
      ((Path)localObject2).lineTo(48.130356F, 49.044022F);
      ((Path)localObject2).cubicTo(52.648304F, 44.7668F, 55.466667F, 38.712532F, 55.466667F, 32.0F);
      ((Path)localObject2).cubicTo(55.466667F, 19.039719F, 44.960281F, 8.533334F, 32.0F, 8.533334F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(31.999592F, 26.133333F);
      ((Path)localObject2).cubicTo(37.333019F, 26.133333F, 42.666489F, 26.48889F, 48.0F, 27.200001F);
      ((Path)localObject2).lineTo(48.0F, 28.266666F);
      ((Path)localObject2).cubicTo(42.666302F, 28.977777F, 37.332832F, 29.333334F, 31.999592F, 29.333334F);
      ((Path)localObject2).cubicTo(26.666353F, 29.333334F, 21.333155F, 28.977777F, 16.0F, 28.266666F);
      ((Path)localObject2).lineTo(16.0F, 27.200001F);
      ((Path)localObject2).cubicTo(21.332968F, 26.48889F, 26.666164F, 26.133333F, 31.999592F, 26.133333F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(32.0F, 13.333333F);
      ((Path)localObject2).cubicTo(37.891037F, 13.333333F, 42.666668F, 18.114614F, 42.666668F, 24.000553F);
      ((Path)localObject2).lineTo(42.666805F, 25.001207F);
      ((Path)localObject2).cubicTo(41.600166F, 24.907639F, 40.533512F, 24.828104F, 39.466839F, 24.762602F);
      ((Path)localObject2).lineTo(39.466667F, 24.000553F);
      ((Path)localObject2).cubicTo(39.466667F, 19.87977F, 36.121574F, 16.533333F, 32.0F, 16.533333F);
      ((Path)localObject2).cubicTo(27.88349F, 16.533333F, 24.533333F, 19.880541F, 24.533333F, 23.99888F);
      ((Path)localObject2).lineTo(24.533508F, 24.762541F);
      ((Path)localObject2).cubicTo(23.466885F, 24.828033F, 22.400288F, 24.90756F, 21.333719F, 25.001122F);
      ((Path)localObject2).lineTo(21.333334F, 23.99888F);
      ((Path)localObject2).cubicTo(21.333334F, 18.108461F, 26.120949F, 13.333333F, 32.0F, 13.333333F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 2);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localObject1 = c.n(paramVarArgs);
      ((Path)localObject1).moveTo(0.0F, 0.0F);
      ((Path)localObject1).lineTo(64.0F, 0.0F);
      ((Path)localObject1).lineTo(64.0F, 64.0F);
      ((Path)localObject1).lineTo(0.0F, 64.0F);
      ((Path)localObject1).lineTo(0.0F, 0.0F);
      ((Path)localObject1).close();
      localCanvas.restore();
      localCanvas.restore();
      c.l(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.azu
 * JD-Core Version:    0.7.0.1
 */