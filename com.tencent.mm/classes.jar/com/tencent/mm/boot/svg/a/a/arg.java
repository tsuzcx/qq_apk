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

public final class arg
  extends c
{
  private final int height = 72;
  private final int width = 72;
  
  public final int a(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 72;
      return 72;
      Canvas localCanvas = (Canvas)paramVarArgs[0];
      paramVarArgs = (Looper)paramVarArgs[1];
      Object localObject1 = c.j(paramVarArgs);
      Object localObject2 = c.i(paramVarArgs);
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
      c.a(localPaint2, paramVarArgs).setStrokeWidth(1.0F);
      localCanvas.save();
      localPaint1 = c.a(localPaint1, paramVarArgs);
      localPaint1.setColor(-16777216);
      localObject2 = c.a((float[])localObject2, 1.0F, 0.0F, 6.0F, 0.0F, 1.0F, 6.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject2);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject1 = c.a(localPaint1, paramVarArgs);
      localObject2 = c.n(paramVarArgs);
      ((Path)localObject2).moveTo(35.103241F, 50.797146F);
      ((Path)localObject2).cubicTo(36.006195F, 51.213005F, 36.401066F, 52.282108F, 35.98521F, 53.185062F);
      ((Path)localObject2).cubicTo(35.037998F, 55.241745F, 33.918312F, 57.215744F, 32.639351F, 59.084743F);
      ((Path)localObject2).cubicTo(32.077942F, 59.905159F, 30.957752F, 60.11512F, 30.137339F, 59.553711F);
      ((Path)localObject2).cubicTo(29.316925F, 58.992302F, 29.10696F, 57.872112F, 29.668371F, 57.051697F);
      ((Path)localObject2).cubicTo(30.833138F, 55.349571F, 31.852819F, 53.551888F, 32.715328F, 51.679111F);
      ((Path)localObject2).cubicTo(33.131184F, 50.776161F, 34.200291F, 50.38129F, 35.103241F, 50.797146F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(26.973095F, 51.723434F);
      ((Path)localObject2).cubicTo(27.812162F, 52.256565F, 28.060173F, 53.36895F, 27.527044F, 54.208015F);
      ((Path)localObject2).cubicTo(26.604836F, 55.659431F, 25.571352F, 57.037769F, 24.43638F, 58.329563F);
      ((Path)localObject2).cubicTo(23.78023F, 59.076374F, 22.642906F, 59.149868F, 21.896093F, 58.493721F);
      ((Path)localObject2).cubicTo(21.149282F, 57.83757F, 21.075787F, 56.700245F, 21.731936F, 55.953434F);
      ((Path)localObject2).cubicTo(22.744154F, 54.801353F, 23.665953F, 53.571972F, 24.488514F, 52.277382F);
      ((Path)localObject2).cubicTo(25.021645F, 51.438316F, 26.134027F, 51.190308F, 26.973095F, 51.723434F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(45.671581F, 27.159506F);
      ((Path)localObject2).cubicTo(47.736778F, 37.402077F, 46.346062F, 47.816906F, 41.863087F, 57.019127F);
      ((Path)localObject2).cubicTo(41.427708F, 57.912827F, 40.350273F, 58.284374F, 39.45657F, 57.848995F);
      ((Path)localObject2).cubicTo(38.562866F, 57.413616F, 38.191322F, 56.336182F, 38.626701F, 55.442478F);
      ((Path)localObject2).cubicTo(42.76683F, 46.944027F, 44.050285F, 37.332432F, 42.142502F, 27.870552F);
      ((Path)localObject2).cubicTo(40.821354F, 21.308609F, 34.431656F, 17.062302F, 27.870638F, 18.385256F);
      ((Path)localObject2).cubicTo(21.309402F, 19.708363F, 17.063379F, 26.098976F, 18.385368F, 32.655781F);
      ((Path)localObject2).cubicTo(19.823709F, 39.698586F, 17.200043F, 46.845268F, 11.732828F, 51.323345F);
      ((Path)localObject2).cubicTo(10.963766F, 51.953266F, 9.829664F, 51.840469F, 9.199741F, 51.071407F);
      ((Path)localObject2).cubicTo(8.56982F, 50.302345F, 8.682614F, 49.168243F, 9.451677F, 48.538322F);
      ((Path)localObject2).cubicTo(13.896054F, 44.898029F, 16.026243F, 39.095547F, 14.85728F, 33.371716F);
      ((Path)localObject2).cubicTo(13.141436F, 24.861511F, 18.648844F, 16.572411F, 27.159033F, 14.856288F);
      ((Path)localObject2).cubicTo(35.669426F, 13.140263F, 43.958019F, 18.648493F, 45.671581F, 27.159506F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(20.526924F, 49.00985F);
      ((Path)localObject2).cubicTo(21.339741F, 49.582203F, 21.534672F, 50.705109F, 20.962317F, 51.517921F);
      ((Path)localObject2).cubicTo(19.927467F, 52.987537F, 18.744291F, 54.347996F, 17.431719F, 55.575985F);
      ((Path)localObject2).cubicTo(16.705774F, 56.25515F, 15.566708F, 56.217228F, 14.887544F, 55.491283F);
      ((Path)localObject2).cubicTo(14.208379F, 54.765339F, 14.246303F, 53.62627F, 14.972247F, 52.947109F);
      ((Path)localObject2).cubicTo(16.104628F, 51.887699F, 17.125677F, 50.713657F, 18.01885F, 49.44524F);
      ((Path)localObject2).cubicTo(18.591206F, 48.632427F, 19.714109F, 48.437492F, 20.526924F, 49.00985F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(51.680775F, 33.074394F);
      ((Path)localObject2).cubicTo(52.6744F, 33.043304F, 53.505096F, 33.823597F, 53.536186F, 34.817223F);
      ((Path)localObject2).cubicTo(53.700497F, 40.068714F, 53.093174F, 45.283905F, 51.749783F, 50.32275F);
      ((Path)localObject2).cubicTo(51.49369F, 51.28331F, 50.507397F, 51.854393F, 49.546837F, 51.598301F);
      ((Path)localObject2).cubicTo(48.586277F, 51.342209F, 48.01519F, 50.355915F, 48.271286F, 49.395355F);
      ((Path)localObject2).cubicTo(49.524708F, 44.693981F, 50.091236F, 39.829071F, 49.937946F, 34.929806F);
      ((Path)localObject2).cubicTo(49.906857F, 33.93618F, 50.687149F, 33.105484F, 51.680775F, 33.074394F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(32.03709F, 29.908262F);
      ((Path)localObject2).cubicTo(33.253765F, 35.942436F, 32.771351F, 42.071133F, 30.713652F, 47.733959F);
      ((Path)localObject2).cubicTo(30.374142F, 48.668297F, 29.34148F, 49.150501F, 28.407141F, 48.810993F);
      ((Path)localObject2).cubicTo(27.472799F, 48.471481F, 26.990595F, 47.43882F, 27.330107F, 46.504478F);
      ((Path)localObject2).cubicTo(29.163593F, 41.458687F, 29.593172F, 36.001236F, 28.508112F, 30.619812F);
      ((Path)localObject2).cubicTo(28.311623F, 29.645311F, 28.942326F, 28.696037F, 29.916826F, 28.499548F);
      ((Path)localObject2).cubicTo(30.891327F, 28.303059F, 31.840603F, 28.933762F, 32.03709F, 29.908262F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(30.51722F, 21.496611F);
      ((Path)localObject2).cubicTo(34.570164F, 21.61005F, 38.052143F, 24.510641F, 38.854324F, 28.533974F);
      ((Path)localObject2).cubicTo(40.129013F, 34.855824F, 39.864296F, 41.268559F, 38.144131F, 47.341446F);
      ((Path)localObject2).cubicTo(37.873203F, 48.297928F, 36.878189F, 48.85368F, 35.921707F, 48.582756F);
      ((Path)localObject2).cubicTo(34.965225F, 48.311829F, 34.409473F, 47.316814F, 34.680401F, 46.360332F);
      ((Path)localObject2).cubicTo(36.245403F, 40.835247F, 36.486172F, 35.002659F, 35.324581F, 29.241714F);
      ((Path)localObject2).cubicTo(34.851845F, 26.870726F, 32.800541F, 25.161928F, 30.416496F, 25.0952F);
      ((Path)localObject2).cubicTo(29.422773F, 25.067387F, 28.63975F, 24.239267F, 28.667562F, 23.245544F);
      ((Path)localObject2).cubicTo(28.695375F, 22.25182F, 29.523497F, 21.468796F, 30.51722F, 21.496611F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(26.503305F, 24.124804F);
      ((Path)localObject2).cubicTo(27.218733F, 24.815039F, 27.239153F, 25.954554F, 26.548918F, 26.669979F);
      ((Path)localObject2).cubicTo(25.374964F, 27.886778F, 24.857582F, 29.598694F, 25.196644F, 31.27989F);
      ((Path)localObject2).cubicTo(26.259748F, 36.455448F, 25.72419F, 41.722763F, 23.730188F, 46.504147F);
      ((Path)localObject2).cubicTo(23.347549F, 47.421669F, 22.293562F, 47.855278F, 21.37604F, 47.472637F);
      ((Path)localObject2).cubicTo(20.458517F, 47.09F, 20.024908F, 46.036011F, 20.407545F, 45.118488F);
      ((Path)localObject2).cubicTo(22.125814F, 40.99828F, 22.586676F, 36.465626F, 21.668985F, 31.997932F);
      ((Path)localObject2).cubicTo(21.092266F, 29.138441F, 21.971357F, 26.229698F, 23.95813F, 24.170416F);
      ((Path)localObject2).cubicTo(24.648365F, 23.454988F, 25.78788F, 23.434568F, 26.503305F, 24.124804F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(22.693542F, 10.732992F);
      ((Path)localObject2).cubicTo(23.130589F, 11.625881F, 22.761055F, 12.704006F, 21.868166F, 13.141052F);
      ((Path)localObject2).cubicTo(14.147672F, 16.92004F, 9.850913F, 25.48498F, 11.573627F, 34.029099F);
      ((Path)localObject2).cubicTo(12.478013F, 38.451149F, 10.872096F, 42.942085F, 7.487643F, 45.809834F);
      ((Path)localObject2).cubicTo(6.729192F, 46.452496F, 5.593367F, 46.358627F, 4.950707F, 45.600174F);
      ((Path)localObject2).cubicTo(4.308048F, 44.841724F, 4.401916F, 43.705898F, 5.160368F, 43.06324F);
      ((Path)localObject2).cubicTo(7.552264F, 41.03651F, 8.684618F, 37.869892F, 8.045639F, 34.745529F);
      ((Path)localObject2).cubicTo(5.996448F, 24.582232F, 11.103586F, 14.401922F, 20.28548F, 9.907617F);
      ((Path)localObject2).cubicTo(21.17837F, 9.470571F, 22.256495F, 9.840103F, 22.693542F, 10.732992F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(20.519489F, 4.146198F);
      ((Path)localObject2).cubicTo(20.925587F, 5.053582F, 20.519213F, 6.118368F, 19.61183F, 6.524465F);
      ((Path)localObject2).cubicTo(8.666192F, 11.423153F, 2.420104F, 23.284954F, 4.721518F, 35.197609F);
      ((Path)localObject2).cubicTo(4.74523F, 35.264191F, 4.763555F, 35.333332F, 4.777888F, 35.404297F);
      ((Path)localObject2).cubicTo(4.853945F, 35.780857F, 4.936934F, 36.151146F, 5.026998F, 36.515457F);
      ((Path)localObject2).cubicTo(5.265575F, 37.480518F, 4.676644F, 38.456257F, 3.711584F, 38.694836F);
      ((Path)localObject2).cubicTo(2.746524F, 38.933411F, 1.770783F, 38.344482F, 1.532206F, 37.379421F);
      ((Path)localObject2).cubicTo(1.448992F, 37.042812F, 1.371227F, 36.702377F, 1.298806F, 36.357964F);
      ((Path)localObject2).cubicTo(1.272349F, 36.280575F, 1.250514F, 36.201092F, 1.233997F, 36.119175F);
      ((Path)localObject2).cubicTo(-1.516543F, 22.477573F, 5.603093F, 8.849941F, 18.141224F, 3.238538F);
      ((Path)localObject2).cubicTo(19.048607F, 2.832441F, 20.113394F, 3.238814F, 20.519489F, 4.146198F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(52.48888F, 25.785164F);
      ((Path)localObject2).cubicTo(52.717522F, 26.919149F, 52.909573F, 28.056213F, 53.065109F, 29.1952F);
      ((Path)localObject2).cubicTo(53.199612F, 30.18017F, 52.510174F, 31.087685F, 51.5252F, 31.222189F);
      ((Path)localObject2).cubicTo(50.54023F, 31.356691F, 49.632717F, 30.667252F, 49.498211F, 29.682281F);
      ((Path)localObject2).cubicTo(49.352943F, 28.618477F, 49.173534F, 27.556267F, 48.960014F, 26.497286F);
      ((Path)localObject2).cubicTo(46.993202F, 16.75926F, 37.887318F, 10.181668F, 28.085663F, 11.321777F);
      ((Path)localObject2).cubicTo(27.098207F, 11.436636F, 26.204607F, 10.729258F, 26.089746F, 9.741802F);
      ((Path)localObject2).cubicTo(25.974888F, 8.754348F, 26.682268F, 7.860745F, 27.669722F, 7.745887F);
      ((Path)localObject2).cubicTo(39.327126F, 6.389921F, 50.150661F, 14.20825F, 52.48888F, 25.785164F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(59.199196F, 23.949324F);
      ((Path)localObject2).lineTo(59.248497F, 24.177744F);
      ((Path)localObject2).cubicTo(59.274124F, 24.252357F, 59.295139F, 24.329515F, 59.311157F, 24.40896F);
      ((Path)localObject2).cubicTo(59.637768F, 26.029118F, 59.828266F, 27.660305F, 59.88369F, 29.290478F);
      ((Path)localObject2).cubicTo(59.917469F, 30.284016F, 59.139431F, 31.116821F, 58.145893F, 31.1506F);
      ((Path)localObject2).cubicTo(57.152355F, 31.184381F, 56.31955F, 30.406342F, 56.28577F, 29.412804F);
      ((Path)localObject2).cubicTo(56.239365F, 28.047865F, 56.08511F, 26.681414F, 55.82201F, 25.322123F);
      ((Path)localObject2).cubicTo(55.798378F, 25.257835F, 55.780956F, 25.191372F, 55.767216F, 25.123228F);
      ((Path)localObject2).cubicTo(53.02832F, 11.539369F, 40.126575F, 2.504777F, 26.477898F, 4.526187F);
      ((Path)localObject2).cubicTo(25.494511F, 4.67183F, 24.579252F, 3.992704F, 24.433611F, 3.009318F);
      ((Path)localObject2).cubicTo(24.287968F, 2.025933F, 24.967093F, 1.110674F, 25.95048F, 0.9650316F);
      ((Path)localObject2).cubicTo(41.336342F, -1.313661F, 55.884392F, 8.743249F, 59.199196F, 23.949324F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 1);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.restore();
      c.l(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.arg
 * JD-Core Version:    0.7.0.1
 */