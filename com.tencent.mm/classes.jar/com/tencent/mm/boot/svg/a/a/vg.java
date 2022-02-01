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

public final class vg
  extends c
{
  private final int height = 120;
  private final int width = 120;
  
  public final int a(int paramInt, Object... paramVarArgs)
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
      localPaint2 = c.a(localPaint1, paramVarArgs);
      localPaint2.setColor(-14187817);
      Path localPath = c.n(paramVarArgs);
      localPath.moveTo(0.0F, 12.0F);
      localPath.cubicTo(0.0F, 5.372582F, 5.372582F, 0.0F, 12.0F, 0.0F);
      localPath.lineTo(108.0F, 0.0F);
      localPath.cubicTo(114.62742F, 0.0F, 120.0F, 5.372582F, 120.0F, 12.0F);
      localPath.lineTo(120.0F, 108.0F);
      localPath.cubicTo(120.0F, 114.62742F, 114.62742F, 120.0F, 108.0F, 120.0F);
      localPath.lineTo(12.0F, 120.0F);
      localPath.cubicTo(5.372582F, 120.0F, 0.0F, 114.62742F, 0.0F, 108.0F);
      localPath.lineTo(0.0F, 12.0F);
      localPath.close();
      localCanvas.drawPath(localPath, localPaint2);
      localCanvas.restore();
      localCanvas.save();
      localPaint1 = c.a(localPaint1, paramVarArgs);
      localPaint1.setColor(-1);
      localObject2 = c.a((float[])localObject2, 1.0F, 0.0F, 24.0F, 0.0F, 1.0F, 24.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject2);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject2 = c.a((float[])localObject2, 1.0F, 0.0F, 5.5F, 0.0F, 1.0F, 9.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject2);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject1 = c.a(localPaint1, paramVarArgs);
      localObject2 = c.n(paramVarArgs);
      ((Path)localObject2).moveTo(57.143349F, 34.893883F);
      ((Path)localObject2).cubicTo(57.423515F, 35.24025F, 57.403419F, 35.749748F, 57.080696F, 36.071285F);
      ((Path)localObject2).cubicTo(56.736694F, 36.41647F, 56.17873F, 36.41647F, 55.834732F, 36.071285F);
      ((Path)localObject2).lineTo(55.833549F, 36.072468F);
      ((Path)localObject2).cubicTo(55.718884F, 35.94598F, 55.60067F, 35.821857F, 55.478909F, 35.700096F);
      ((Path)localObject2).cubicTo(53.790829F, 34.012016F, 51.704369F, 32.965832F, 49.522156F, 32.559177F);
      ((Path)localObject2).cubicTo(49.447681F, 32.550903F, 49.373207F, 32.540264F, 49.299915F, 32.528442F);
      ((Path)localObject2).cubicTo(49.225441F, 32.515438F, 49.152149F, 32.501251F, 49.08004F, 32.484703F);
      ((Path)localObject2).cubicTo(48.427502F, 32.334572F, 47.80925F, 32.007122F, 47.300934F, 31.499989F);
      ((Path)localObject2).cubicTo(45.861099F, 30.058971F, 45.861099F, 27.724264F, 47.300934F, 26.28443F);
      ((Path)localObject2).cubicTo(48.741951F, 24.843412F, 51.076656F, 24.843412F, 52.517673F, 26.28443F);
      ((Path)localObject2).cubicTo(52.98698F, 26.753735F, 53.302608F, 27.319977F, 53.46574F, 27.918135F);
      ((Path)localObject2).cubicTo(53.501205F, 28.046986F, 53.529575F, 28.177021F, 53.549671F, 28.307055F);
      ((Path)localObject2).cubicTo(53.568588F, 28.426451F, 53.582771F, 28.545845F, 53.589867F, 28.665239F);
      ((Path)localObject2).cubicTo(54.01543F, 30.794256F, 55.052162F, 32.82634F, 56.702415F, 34.476593F);
      ((Path)localObject2).cubicTo(56.786346F, 34.560524F, 56.872643F, 34.64209F, 56.957756F, 34.722477F);
      ((Path)localObject2).cubicTo(57.001492F, 34.753212F, 57.04287F, 34.786312F, 57.080696F, 34.824139F);
      ((Path)localObject2).cubicTo(57.103157F, 34.8466F, 57.124435F, 34.870243F, 57.143349F, 34.893883F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(42.649014F, 43.721207F);
      ((Path)localObject2).cubicTo(42.368847F, 43.37484F, 42.388947F, 42.865345F, 42.711666F, 42.543804F);
      ((Path)localObject2).cubicTo(43.055668F, 42.198624F, 43.613632F, 42.198624F, 43.95763F, 42.543804F);
      ((Path)localObject2).lineTo(43.958813F, 42.542622F);
      ((Path)localObject2).cubicTo(44.073479F, 42.669109F, 44.191692F, 42.793232F, 44.313454F, 42.914993F);
      ((Path)localObject2).cubicTo(46.001534F, 44.603073F, 48.087994F, 45.649261F, 50.270206F, 46.055912F);
      ((Path)localObject2).cubicTo(50.344681F, 46.064186F, 50.419155F, 46.074825F, 50.492447F, 46.086647F);
      ((Path)localObject2).cubicTo(50.566921F, 46.099651F, 50.640213F, 46.113838F, 50.712322F, 46.130386F);
      ((Path)localObject2).cubicTo(51.364861F, 46.280518F, 51.983112F, 46.607967F, 52.491428F, 47.115101F);
      ((Path)localObject2).cubicTo(53.931263F, 48.556118F, 53.931263F, 50.890827F, 52.491428F, 52.330662F);
      ((Path)localObject2).cubicTo(51.050415F, 53.771679F, 48.715706F, 53.771679F, 47.274689F, 52.330662F);
      ((Path)localObject2).cubicTo(46.805382F, 51.861355F, 46.489754F, 51.295113F, 46.326622F, 50.696957F);
      ((Path)localObject2).cubicTo(46.291157F, 50.568104F, 46.262787F, 50.438068F, 46.242691F, 50.308037F);
      ((Path)localObject2).cubicTo(46.223774F, 50.188641F, 46.209591F, 50.069244F, 46.202496F, 49.949848F);
      ((Path)localObject2).cubicTo(45.776932F, 47.820835F, 44.7402F, 45.78875F, 43.089947F, 44.138496F);
      ((Path)localObject2).cubicTo(43.006016F, 44.054565F, 42.91972F, 43.973F, 42.834606F, 43.892616F);
      ((Path)localObject2).cubicTo(42.790871F, 43.861877F, 42.749496F, 43.828781F, 42.711666F, 43.790951F);
      ((Path)localObject2).cubicTo(42.689205F, 43.76849F, 42.667927F, 43.74485F, 42.649014F, 43.721207F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(54.309784F, 46.554771F);
      ((Path)localObject2).cubicTo(53.963417F, 46.834938F, 53.453922F, 46.814842F, 53.132381F, 46.492119F);
      ((Path)localObject2).cubicTo(52.787197F, 46.148121F, 52.787197F, 45.590153F, 53.132381F, 45.246155F);
      ((Path)localObject2).lineTo(53.131199F, 45.244972F);
      ((Path)localObject2).cubicTo(53.257687F, 45.130306F, 53.381809F, 45.012093F, 53.503571F, 44.890331F);
      ((Path)localObject2).cubicTo(55.19165F, 43.202251F, 56.237839F, 41.115791F, 56.644489F, 38.933578F);
      ((Path)localObject2).cubicTo(56.652763F, 38.859104F, 56.663403F, 38.78463F, 56.675224F, 38.711338F);
      ((Path)localObject2).cubicTo(56.688229F, 38.636864F, 56.702415F, 38.563572F, 56.718964F, 38.491463F);
      ((Path)localObject2).cubicTo(56.869095F, 37.840107F, 57.196545F, 37.220673F, 57.703678F, 36.712357F);
      ((Path)localObject2).cubicTo(59.144695F, 35.272522F, 61.479404F, 35.272522F, 62.919239F, 36.712357F);
      ((Path)localObject2).cubicTo(64.360252F, 38.153374F, 64.360252F, 40.488079F, 62.919239F, 41.929096F);
      ((Path)localObject2).cubicTo(62.449932F, 42.398403F, 61.88369F, 42.714031F, 61.285534F, 42.877163F);
      ((Path)localObject2).cubicTo(61.156681F, 42.912628F, 61.026646F, 42.940998F, 60.896614F, 42.961098F);
      ((Path)localObject2).cubicTo(60.777218F, 42.980011F, 60.657822F, 42.994194F, 60.538425F, 43.001289F);
      ((Path)localObject2).cubicTo(58.409412F, 43.426857F, 56.377327F, 44.463585F, 54.727074F, 46.113838F);
      ((Path)localObject2).cubicTo(54.643143F, 46.197769F, 54.561577F, 46.284065F, 54.481194F, 46.369179F);
      ((Path)localObject2).cubicTo(54.450455F, 46.412918F, 54.417358F, 46.454292F, 54.379528F, 46.492119F);
      ((Path)localObject2).cubicTo(54.357067F, 46.51458F, 54.333424F, 46.535858F, 54.309784F, 46.554771F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(45.482578F, 32.060436F);
      ((Path)localObject2).cubicTo(45.828945F, 31.780272F, 46.338444F, 31.800367F, 46.659981F, 32.123089F);
      ((Path)localObject2).cubicTo(47.005165F, 32.467091F, 47.005165F, 33.025055F, 46.659981F, 33.369053F);
      ((Path)localObject2).lineTo(46.661163F, 33.370235F);
      ((Path)localObject2).cubicTo(46.534676F, 33.484905F, 46.410553F, 33.603115F, 46.288792F, 33.724876F);
      ((Path)localObject2).cubicTo(44.600712F, 35.412956F, 43.554523F, 37.499416F, 43.147873F, 39.681629F);
      ((Path)localObject2).cubicTo(43.139599F, 39.756104F, 43.12896F, 39.830578F, 43.117138F, 39.90387F);
      ((Path)localObject2).cubicTo(43.104134F, 39.978344F, 43.089947F, 40.051636F, 43.073399F, 40.123749F);
      ((Path)localObject2).cubicTo(42.923267F, 40.776283F, 42.595818F, 41.394535F, 42.088684F, 41.902851F);
      ((Path)localObject2).cubicTo(40.647667F, 43.342686F, 38.312962F, 43.342686F, 36.873127F, 41.902851F);
      ((Path)localObject2).cubicTo(35.43211F, 40.461838F, 35.43211F, 38.127129F, 36.873127F, 36.686111F);
      ((Path)localObject2).cubicTo(37.34243F, 36.216805F, 37.908672F, 35.901176F, 38.506828F, 35.738045F);
      ((Path)localObject2).cubicTo(38.635681F, 35.702579F, 38.765717F, 35.67421F, 38.895748F, 35.654114F);
      ((Path)localObject2).cubicTo(39.015144F, 35.635197F, 39.134541F, 35.621014F, 39.253937F, 35.613918F);
      ((Path)localObject2).cubicTo(41.382954F, 35.188354F, 43.415035F, 34.151627F, 45.065289F, 32.501369F);
      ((Path)localObject2).cubicTo(45.14922F, 32.417439F, 45.230785F, 32.331142F, 45.311172F, 32.246033F);
      ((Path)localObject2).cubicTo(45.341908F, 32.202293F, 45.375008F, 32.160919F, 45.412834F, 32.123089F);
      ((Path)localObject2).cubicTo(45.435295F, 32.100628F, 45.458939F, 32.07935F, 45.482578F, 32.060436F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(50.966362F, 14.040161F);
      ((Path)localObject2).cubicTo(52.345909F, 16.873728F, 53.044548F, 19.878702F, 53.044548F, 22.96879F);
      ((Path)localObject2).cubicTo(53.044548F, 23.488928F, 53.022087F, 24.007883F, 52.981895F, 24.524475F);
      ((Path)localObject2).cubicTo(52.925152F, 24.459457F, 52.873138F, 24.390894F, 52.810486F, 24.329422F);
      ((Path)localObject2).cubicTo(51.58107F, 23.100008F, 49.70385F, 22.928598F, 48.284111F, 23.798647F);
      ((Path)localObject2).cubicTo(48.295933F, 23.546852F, 48.312481F, 23.295059F, 48.312481F, 23.043264F);
      ((Path)localObject2).cubicTo(48.312481F, 20.61517F, 47.760426F, 18.25209F, 46.674049F, 16.016684F);
      ((Path)localObject2).cubicTo(45.853649F, 14.333329F, 44.74836F, 12.764643F, 43.386543F, 11.356726F);
      ((Path)localObject2).cubicTo(39.87207F, 7.721675F, 34.92131F, 5.377511F, 29.445683F, 4.754528F);
      ((Path)localObject2).cubicTo(28.451511F, 4.641043F, 27.467979F, 4.584301F, 26.523457F, 4.584301F);
      ((Path)localObject2).cubicTo(25.623856F, 4.584301F, 24.68288F, 4.637497F, 23.725355F, 4.741524F);
      ((Path)localObject2).cubicTo(18.223721F, 5.339683F, 13.244587F, 7.672025F, 9.702925F, 11.310622F);
      ((Path)localObject2).cubicTo(8.3352F, 12.716175F, 7.223998F, 14.280133F, 6.397689F, 15.959941F);
      ((Path)localObject2).cubicTo(5.293579F, 18.209534F, 4.73325F, 20.592709F, 4.73325F, 23.043264F);
      ((Path)localObject2).cubicTo(4.73325F, 26.200735F, 5.701414F, 29.323923F, 7.532534F, 32.077103F);
      ((Path)localObject2).cubicTo(8.310375F, 33.246231F, 9.235984F, 34.33852F, 10.290444F, 35.3386F);
      ((Path)localObject2).cubicTo(10.665179F, 35.694424F, 11.055282F, 36.040787F, 11.463117F, 36.371784F);
      ((Path)localObject2).cubicTo(11.729096F, 36.589294F, 11.983254F, 36.78553F, 12.23623F, 36.973488F);
      ((Path)localObject2).cubicTo(12.735089F, 37.336403F, 13.034168F, 37.927467F, 13.034168F, 38.551632F);
      ((Path)localObject2).cubicTo(13.034168F, 38.778603F, 12.986883F, 38.979565F, 12.939598F, 39.147427F);
      ((Path)localObject2).cubicTo(12.72445F, 39.969006F, 12.433646F, 41.074299F, 12.222045F, 41.882874F);
      ((Path)localObject2).cubicTo(12.135749F, 42.211506F, 12.064821F, 42.481033F, 12.015172F, 42.671356F);
      ((Path)localObject2).lineTo(11.835488F, 43.397182F);
      ((Path)localObject2).cubicTo(11.835488F, 43.574505F, 11.973797F, 43.718723F, 12.144024F, 43.718723F);
      ((Path)localObject2).cubicTo(12.196038F, 43.718723F, 12.25278F, 43.697445F, 12.354444F, 43.63834F);
      ((Path)localObject2).lineTo(12.359172F, 43.635975F);
      ((Path)localObject2).lineTo(17.216545F, 40.772854F);
      ((Path)localObject2).cubicTo(17.270924F, 40.740936F, 17.322937F, 40.718475F, 17.377316F, 40.691288F);
      ((Path)localObject2).cubicTo(17.789879F, 40.476139F, 18.196531F, 40.366203F, 18.616188F, 40.366203F);
      ((Path)localObject2).cubicTo(18.885714F, 40.366203F, 19.148146F, 40.406395F, 19.396393F, 40.484413F);
      ((Path)localObject2).cubicTo(20.612804F, 40.841419F, 21.871775F, 41.101486F, 23.146111F, 41.270531F);
      ((Path)localObject2).cubicTo(23.338799F, 41.296539F, 23.531485F, 41.326092F, 23.725355F, 41.34737F);
      ((Path)localObject2).cubicTo(24.653326F, 41.449032F, 25.594301F, 41.501045F, 26.523457F, 41.501045F);
      ((Path)localObject2).cubicTo(27.467979F, 41.501045F, 28.451511F, 41.444305F, 29.445683F, 41.330822F);
      ((Path)localObject2).cubicTo(31.082933F, 41.145226F, 32.666988F, 40.800045F, 34.184841F, 40.317734F);
      ((Path)localObject2).cubicTo(34.051262F, 41.716194F, 34.722713F, 43.128841F, 36.021873F, 43.872398F);
      ((Path)localObject2).cubicTo(36.240566F, 43.996525F, 36.465172F, 44.095821F, 36.694504F, 44.172661F);
      ((Path)localObject2).cubicTo(34.572582F, 44.933952F, 32.335991F, 45.470642F, 30.01074F, 45.734257F);
      ((Path)localObject2).cubicTo(28.828611F, 45.869019F, 27.655937F, 45.93758F, 26.523457F, 45.93758F);
      ((Path)localObject2).cubicTo(25.413437F, 45.93758F, 24.288048F, 45.874928F, 23.180391F, 45.75317F);
      ((Path)localObject2).cubicTo(21.47576F, 45.566391F, 19.858606F, 45.267315F, 18.229631F, 44.799191F);
      ((Path)localObject2).lineTo(10.659268F, 48.598557F);
      ((Path)localObject2).cubicTo(10.617894F, 48.628109F, 10.572973F, 48.65057F, 10.529234F, 48.676579F);
      ((Path)localObject2).cubicTo(10.519777F, 48.682487F, 10.51032F, 48.686035F, 10.500863F, 48.691944F);
      ((Path)localObject2).cubicTo(10.201784F, 48.862171F, 9.861331F, 48.968563F, 9.492506F, 48.968563F);
      ((Path)localObject2).cubicTo(8.364754F, 48.968563F, 7.450967F, 48.053596F, 7.450967F, 46.927025F);
      ((Path)localObject2).cubicTo(7.450967F, 46.860825F, 7.465153F, 46.799355F, 7.471063F, 46.735519F);
      ((Path)localObject2).cubicTo(7.478156F, 46.651588F, 7.484067F, 46.566475F, 7.501799F, 46.486092F);
      ((Path)localObject2).cubicTo(7.531352F, 46.353691F, 7.572726F, 46.226021F, 7.627104F, 46.104263F);
      ((Path)localObject2).lineTo(7.932094F, 44.870117F);
      ((Path)localObject2).lineTo(8.992465F, 40.485596F);
      ((Path)localObject2).cubicTo(7.078596F, 38.92873F, 4.842006F, 36.38715F, 3.53457F, 34.421268F);
      ((Path)localObject2).cubicTo(1.222323F, 30.944624F, 1.136868E-013F, 26.984488F, 1.136868E-013F, 22.96879F);
      ((Path)localObject2).cubicTo(1.136868E-013F, 19.84915F, 0.7104603F, 16.821714F, 2.112467F, 13.968051F);
      ((Path)localObject2).cubicTo(3.144466F, 11.866223F, 4.531105F, 9.914526F, 6.231009F, 8.167338F);
      ((Path)localObject2).cubicTo(10.538692F, 3.741442F, 16.55928F, 0.9066939F, 23.183939F, 0.1867766F);
      ((Path)localObject2).cubicTo(24.32233F, 0.0626529F, 25.445354F, 0.0F, 26.523457F, 0.0F);
      ((Path)localObject2).cubicTo(27.653572F, 0.0F, 28.827429F, 0.06856356F, 30.01074F, 0.203326F);
      ((Path)localObject2).cubicTo(36.605846F, 0.952797F, 42.593334F, 3.801731F, 46.870281F, 8.225263F);
      ((Path)localObject2).cubicTo(48.561913F, 9.975997F, 49.940273F, 11.932423F, 50.966362F, 14.040161F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 2);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.restore();
      localCanvas.restore();
      c.l(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.vg
 * JD-Core Version:    0.7.0.1
 */