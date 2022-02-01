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

public class icons_finder_biz_profile
  extends c
{
  private final int height = 16;
  private final int width = 16;
  
  public int doCommand(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 16;
      return 16;
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
      arrayOfFloat = c.setMatrixFloatArray(arrayOfFloat, 1.0F, 0.0F, -16.0F, 0.0F, 1.0F, -242.0F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject).reset();
      ((Matrix)localObject).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject);
      localCanvas.save();
      arrayOfFloat = c.setMatrixFloatArray(arrayOfFloat, 1.0F, 0.0F, 16.0F, 0.0F, 1.0F, 242.0F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject).reset();
      ((Matrix)localObject).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject);
      localObject = c.instancePath(paramVarArgs);
      ((Path)localObject).moveTo(0.0F, 0.0F);
      ((Path)localObject).lineTo(16.0F, 0.0F);
      ((Path)localObject).lineTo(16.0F, 16.0F);
      ((Path)localObject).lineTo(0.0F, 16.0F);
      ((Path)localObject).lineTo(0.0F, 0.0F);
      ((Path)localObject).close();
      localCanvas.save();
      localPaint1 = c.instancePaint(localPaint1, paramVarArgs);
      localPaint1.setColor(-11048043);
      localObject = c.instancePath(paramVarArgs);
      ((Path)localObject).moveTo(12.511777F, 2.381048F);
      ((Path)localObject).cubicTo(13.240385F, 2.083871F, 13.863316F, 2.368952F, 14.187937F, 3.188299F);
      ((Path)localObject).cubicTo(14.419177F, 3.771809F, 14.445925F, 4.785284F, 14.330483F, 5.96021F);
      ((Path)localObject).lineTo(14.330483F, 5.96021F);
      ((Path)localObject).lineTo(14.286821F, 6.357463F);
      ((Path)localObject).cubicTo(14.278696F, 6.424546F, 14.270152F, 6.492034F, 14.261202F, 6.559884F);
      ((Path)localObject).lineTo(14.261202F, 6.559884F);
      ((Path)localObject).lineTo(14.202703F, 6.970932F);
      ((Path)localObject).lineTo(14.134953F, 7.388415F);
      ((Path)localObject).lineTo(14.058466F, 7.810122F);
      ((Path)localObject).lineTo(13.973753F, 8.233843F);
      ((Path)localObject).cubicTo(13.958978F, 8.304508F, 13.94388F, 8.375165F, 13.928473F, 8.445768F);
      ((Path)localObject).lineTo(13.928473F, 8.445768F);
      ((Path)localObject).lineTo(13.832384F, 8.868367F);
      ((Path)localObject).lineTo(13.729352F, 9.287456F);
      ((Path)localObject).lineTo(13.729352F, 9.287456F);
      ((Path)localObject).lineTo(13.675392F, 9.494992F);
      ((Path)localObject).lineTo(13.562906F, 9.904671F);
      ((Path)localObject).lineTo(13.444759F, 10.305314F);
      ((Path)localObject).lineTo(13.321465F, 10.694711F);
      ((Path)localObject).cubicTo(13.279565F, 10.822391F, 13.236893F, 10.947826F, 13.193533F, 11.070652F);
      ((Path)localObject).lineTo(13.193533F, 11.070652F);
      ((Path)localObject).lineTo(13.061479F, 11.430928F);
      ((Path)localObject).cubicTo(13.039155F, 11.489546F, 13.01668F, 11.547419F, 12.994065F, 11.604501F);
      ((Path)localObject).lineTo(12.994065F, 11.604501F);
      ((Path)localObject).lineTo(12.856789F, 11.937135F);
      ((Path)localObject).cubicTo(12.394177F, 13.011823F, 11.884214F, 13.733334F, 11.41236F, 13.733334F);
      ((Path)localObject).cubicTo(10.795905F, 13.733334F, 10.152272F, 13.111573F, 9.387535F, 11.994203F);
      ((Path)localObject).lineTo(9.387535F, 11.994203F);
      ((Path)localObject).lineTo(9.165663F, 11.661577F);
      ((Path)localObject).cubicTo(8.749865F, 11.023306F, 8.350221F, 10.324247F, 7.999117F, 9.658258F);
      ((Path)localObject).cubicTo(7.650216F, 10.323483F, 7.250362F, 11.022957F, 6.834338F, 11.661577F);
      ((Path)localObject).lineTo(6.834338F, 11.661577F);
      ((Path)localObject).lineTo(6.612465F, 11.994203F);
      ((Path)localObject).cubicTo(5.847728F, 13.111573F, 5.204095F, 13.733334F, 4.58764F, 13.733334F);
      ((Path)localObject).cubicTo(4.115786F, 13.733334F, 3.605823F, 13.011823F, 3.143211F, 11.937135F);
      ((Path)localObject).lineTo(3.143211F, 11.937135F);
      ((Path)localObject).lineTo(3.005934F, 11.604502F);
      ((Path)localObject).lineTo(3.005934F, 11.604502F);
      ((Path)localObject).lineTo(2.938521F, 11.430929F);
      ((Path)localObject).lineTo(2.806466F, 11.070654F);
      ((Path)localObject).cubicTo(2.763107F, 10.947828F, 2.720435F, 10.822392F, 2.678535F, 10.694713F);
      ((Path)localObject).lineTo(2.678535F, 10.694713F);
      ((Path)localObject).lineTo(2.555239F, 10.305316F);
      ((Path)localObject).lineTo(2.437092F, 9.904674F);
      ((Path)localObject).lineTo(2.324607F, 9.494996F);
      ((Path)localObject).lineTo(2.324607F, 9.494996F);
      ((Path)localObject).lineTo(2.270647F, 9.287459F);
      ((Path)localObject).lineTo(2.167615F, 8.868372F);
      ((Path)localObject).lineTo(2.071525F, 8.445773F);
      ((Path)localObject).cubicTo(2.056118F, 8.375171F, 2.04102F, 8.304514F, 2.026245F, 8.233849F);
      ((Path)localObject).lineTo(2.026245F, 8.233849F);
      ((Path)localObject).lineTo(1.941532F, 7.810128F);
      ((Path)localObject).lineTo(1.865044F, 7.388423F);
      ((Path)localObject).lineTo(1.797294F, 6.970941F);
      ((Path)localObject).cubicTo(1.786759F, 6.901835F, 1.776609F, 6.832998F, 1.766856F, 6.764475F);
      ((Path)localObject).lineTo(1.766856F, 6.764475F);
      ((Path)localObject).lineTo(1.713174F, 6.357474F);
      ((Path)localObject).lineTo(1.669512F, 5.960222F);
      ((Path)localObject).cubicTo(1.554069F, 4.785301F, 1.580815F, 3.771831F, 1.812051F, 3.188329F);
      ((Path)localObject).cubicTo(2.185715F, 2.245199F, 2.931439F, 2.034704F, 3.7654F, 2.518526F);
      ((Path)localObject).cubicTo(4.360453F, 2.863746F, 5.031508F, 3.559478F, 5.776469F, 4.542424F);
      ((Path)localObject).cubicTo(6.348707F, 5.297468F, 6.935032F, 6.183813F, 7.508117F, 7.129922F);
      ((Path)localObject).lineTo(7.508117F, 7.129922F);
      ((Path)localObject).lineTo(7.84276F, 7.691577F);
      ((Path)localObject).lineTo(7.99891F, 7.962481F);
      ((Path)localObject).lineTo(8.198024F, 7.622554F);
      ((Path)localObject).cubicTo(8.516869F, 7.079762F, 8.851301F, 6.536877F, 9.193587F, 6.013771F);
      ((Path)localObject).lineTo(9.538204F, 5.497993F);
      ((Path)localObject).cubicTo(9.955664F, 4.886592F, 10.361248F, 4.342723F, 10.748963F, 3.883455F);
      ((Path)localObject).cubicTo(11.400484F, 3.111697F, 11.983508F, 2.596512F, 12.511777F, 2.381048F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(7.24959F, 8.262669F);
      ((Path)localObject).lineTo(6.938694F, 7.735046F);
      ((Path)localObject).lineTo(6.613395F, 7.200721F);
      ((Path)localObject).cubicTo(6.12128F, 6.406032F, 5.622911F, 5.664281F, 5.138891F, 5.025635F);
      ((Path)localObject).cubicTo(4.4535F, 4.12129F, 3.843192F, 3.488539F, 3.363948F, 3.210506F);
      ((Path)localObject).cubicTo(2.934824F, 2.961549F, 2.74069F, 3.016347F, 2.555792F, 3.483031F);
      ((Path)localObject).cubicTo(2.34339F, 4.019007F, 2.354392F, 5.158417F, 2.547144F, 6.544828F);
      ((Path)localObject).lineTo(2.547144F, 6.544828F);
      ((Path)localObject).lineTo(2.61038F, 6.967805F);
      ((Path)localObject).lineTo(2.684272F, 7.403463F);
      ((Path)localObject).cubicTo(2.72384F, 7.624106F, 2.76731F, 7.848702F, 2.814541F, 8.07605F);
      ((Path)localObject).lineTo(2.814541F, 8.07605F);
      ((Path)localObject).lineTo(2.913977F, 8.534055F);
      ((Path)localObject).lineTo(3.023193F, 8.997256F);
      ((Path)localObject).cubicTo(3.038974F, 9.061625F, 3.054959F, 9.125611F, 3.071128F, 9.189183F);
      ((Path)localObject).lineTo(3.071128F, 9.189183F);
      ((Path)localObject).lineTo(3.170203F, 9.565373F);
      ((Path)localObject).lineTo(3.272789F, 9.930016F);
      ((Path)localObject).lineTo(3.377968F, 10.281513F);
      ((Path)localObject).lineTo(3.484822F, 10.618271F);
      ((Path)localObject).lineTo(3.592434F, 10.938693F);
      ((Path)localObject).lineTo(3.699886F, 11.241184F);
      ((Path)localObject).lineTo(3.806261F, 11.524148F);
      ((Path)localObject).lineTo(3.91064F, 11.78599F);
      ((Path)localObject).lineTo(4.012107F, 12.025113F);
      ((Path)localObject).lineTo(4.109743F, 12.239923F);
      ((Path)localObject).lineTo(4.202632F, 12.428823F);
      ((Path)localObject).lineTo(4.289854F, 12.590218F);
      ((Path)localObject).cubicTo(4.41598F, 12.810884F, 4.519887F, 12.933333F, 4.58764F, 12.933333F);
      ((Path)localObject).cubicTo(4.723211F, 12.933333F, 4.944335F, 12.771749F, 5.218051F, 12.477405F);
      ((Path)localObject).lineTo(5.218051F, 12.477405F);
      ((Path)localObject).lineTo(5.372369F, 12.30386F);
      ((Path)localObject).cubicTo(5.398892F, 12.272799F, 5.4258F, 12.240684F, 5.453068F, 12.207537F);
      ((Path)localObject).lineTo(5.453068F, 12.207537F);
      ((Path)localObject).lineTo(5.620805F, 11.996441F);
      ((Path)localObject).lineTo(5.796003F, 11.761612F);
      ((Path)localObject).cubicTo(5.855514F, 11.679495F, 5.91607F, 11.593596F, 5.977472F, 11.504086F);
      ((Path)localObject).lineTo(5.977472F, 11.504086F);
      ((Path)localObject).lineTo(6.164025F, 11.224906F);
      ((Path)localObject).cubicTo(6.674029F, 10.442024F, 7.164229F, 9.554415F, 7.561173F, 8.764768F);
      ((Path)localObject).lineTo(7.548F, 8.788667F);
      ((Path)localObject).lineTo(7.24959F, 8.262669F);
      ((Path)localObject).close();
      ((Path)localObject).moveTo(13.444196F, 3.483001F);
      ((Path)localObject).cubicTo(13.280115F, 3.068859F, 13.121586F, 2.996309F, 12.813907F, 3.121802F);
      ((Path)localObject).cubicTo(12.436378F, 3.275784F, 11.93461F, 3.719168F, 11.360261F, 4.399514F);
      ((Path)localObject).cubicTo(10.991957F, 4.835788F, 10.60209F, 5.358579F, 10.198887F, 5.949101F);
      ((Path)localObject).cubicTo(9.747949F, 6.609535F, 9.304407F, 7.31856F, 8.887818F, 8.02775F);
      ((Path)localObject).lineTo(8.887818F, 8.02775F);
      ((Path)localObject).lineTo(8.679712F, 8.386101F);
      ((Path)localObject).lineTo(8.451333F, 8.789333F);
      ((Path)localObject).lineTo(8.614134F, 9.10798F);
      ((Path)localObject).cubicTo(8.915883F, 9.689564F, 9.259644F, 10.305927F, 9.618827F, 10.883561F);
      ((Path)localObject).lineTo(9.618827F, 10.883561F);
      ((Path)localObject).lineTo(9.835975F, 11.224906F);
      ((Path)localObject).lineTo(10.022528F, 11.504086F);
      ((Path)localObject).cubicTo(10.083931F, 11.593596F, 10.144486F, 11.679495F, 10.203997F, 11.761612F);
      ((Path)localObject).lineTo(10.203997F, 11.761612F);
      ((Path)localObject).lineTo(10.379194F, 11.996441F);
      ((Path)localObject).lineTo(10.546931F, 12.207537F);
      ((Path)localObject).lineTo(10.546931F, 12.207537F);
      ((Path)localObject).lineTo(10.627631F, 12.30386F);
      ((Path)localObject).lineTo(10.781949F, 12.477405F);
      ((Path)localObject).cubicTo(11.055666F, 12.771749F, 11.276789F, 12.933333F, 11.41236F, 12.933333F);
      ((Path)localObject).cubicTo(11.480112F, 12.933333F, 11.58402F, 12.810884F, 11.710146F, 12.590218F);
      ((Path)localObject).lineTo(11.710146F, 12.590218F);
      ((Path)localObject).lineTo(11.797368F, 12.428823F);
      ((Path)localObject).lineTo(11.890257F, 12.239923F);
      ((Path)localObject).lineTo(11.987893F, 12.025113F);
      ((Path)localObject).lineTo(12.08936F, 11.78599F);
      ((Path)localObject).lineTo(12.193739F, 11.524148F);
      ((Path)localObject).lineTo(12.300114F, 11.241184F);
      ((Path)localObject).lineTo(12.407566F, 10.938693F);
      ((Path)localObject).lineTo(12.515178F, 10.618271F);
      ((Path)localObject).lineTo(12.622032F, 10.281513F);
      ((Path)localObject).lineTo(12.727211F, 9.930016F);
      ((Path)localObject).lineTo(12.829797F, 9.565373F);
      ((Path)localObject).lineTo(12.928872F, 9.189183F);
      ((Path)localObject).lineTo(12.976807F, 8.997256F);
      ((Path)localObject).lineTo(13.086023F, 8.534055F);
      ((Path)localObject).lineTo(13.185459F, 8.07605F);
      ((Path)localObject).cubicTo(13.232691F, 7.848702F, 13.27616F, 7.624106F, 13.315728F, 7.403462F);
      ((Path)localObject).lineTo(13.315728F, 7.403462F);
      ((Path)localObject).lineTo(13.38962F, 6.967804F);
      ((Path)localObject).lineTo(13.452856F, 6.544827F);
      ((Path)localObject).cubicTo(13.510681F, 6.128902F, 13.552149F, 5.735209F, 13.576134F, 5.373367F);
      ((Path)localObject).lineTo(13.576134F, 5.373367F);
      ((Path)localObject).lineTo(13.59425F, 5.0225F);
      ((Path)localObject).cubicTo(13.618661F, 4.343427F, 13.571642F, 3.804598F, 13.444196F, 3.483001F);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.icons_finder_biz_profile
 * JD-Core Version:    0.7.0.1
 */