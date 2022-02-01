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

public class invite_friends_by_message
  extends c
{
  private final int height = 108;
  private final int width = 108;
  
  public int doCommand(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 108;
      return 108;
      Canvas localCanvas = (Canvas)paramVarArgs[0];
      paramVarArgs = (Looper)paramVarArgs[1];
      Object localObject1 = c.instanceMatrix(paramVarArgs);
      Object localObject3 = c.instanceMatrixArray(paramVarArgs);
      Object localObject2 = c.instancePaint(paramVarArgs);
      ((Paint)localObject2).setFlags(385);
      ((Paint)localObject2).setStyle(Paint.Style.FILL);
      Paint localPaint = c.instancePaint(paramVarArgs);
      localPaint.setFlags(385);
      localPaint.setStyle(Paint.Style.STROKE);
      ((Paint)localObject2).setColor(-16777216);
      localPaint.setStrokeWidth(1.0F);
      localPaint.setStrokeCap(Paint.Cap.BUTT);
      localPaint.setStrokeJoin(Paint.Join.MITER);
      localPaint.setStrokeMiter(4.0F);
      localPaint.setPathEffect(null);
      c.instancePaint(localPaint, paramVarArgs).setStrokeWidth(1.0F);
      localCanvas.save();
      localPaint = c.instancePaint((Paint)localObject2, paramVarArgs);
      localPaint.setColor(-15028967);
      Path localPath = c.instancePath(paramVarArgs);
      localPath.moveTo(0.0F, 0.0F);
      localPath.lineTo(108.0F, 0.0F);
      localPath.lineTo(108.0F, 108.0F);
      localPath.lineTo(0.0F, 108.0F);
      localPath.lineTo(0.0F, 0.0F);
      localPath.close();
      localCanvas.drawPath(localPath, localPaint);
      localCanvas.restore();
      localCanvas.save();
      localObject2 = c.instancePaint((Paint)localObject2, paramVarArgs);
      ((Paint)localObject2).setColor(-1);
      localObject3 = c.setMatrixFloatArray((float[])localObject3, 1.0F, 0.0F, 21.0F, 0.0F, 1.0F, 28.0F, 0.0F, 0.0F, 1.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject3);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject1 = c.instancePaint((Paint)localObject2, paramVarArgs);
      localObject3 = c.instancePath(paramVarArgs);
      ((Path)localObject3).moveTo(0.8766525F, 40.186584F);
      ((Path)localObject3).cubicTo(0.8766431F, 43.112465F, 3.548852F, 45.451363F, 6.220223F, 45.595936F);
      ((Path)localObject3).lineTo(14.445879F, 45.599041F);
      ((Path)localObject3).cubicTo(14.949696F, 45.599041F, 15.345015F, 45.979805F, 15.354844F, 46.453613F);
      ((Path)localObject3).cubicTo(15.354193F, 46.451729F, 15.354193F, 46.451729F, 15.353568F, 46.67424F);
      ((Path)localObject3).cubicTo(15.351624F, 47.48045F, 15.35267F, 48.375038F, 15.358912F, 49.221226F);
      ((Path)localObject3).cubicTo(15.364601F, 49.99255F, 15.374182F, 50.642342F, 15.388507F, 51.136318F);
      ((Path)localObject3).cubicTo(15.397058F, 51.431156F, 15.407271F, 51.670589F, 15.420083F, 51.858139F);
      ((Path)localObject3).cubicTo(15.428529F, 51.98177F, 15.438354F, 52.088585F, 15.451876F, 52.189358F);
      ((Path)localObject3).cubicTo(15.466083F, 52.290642F, 15.466083F, 52.290642F, 15.497457F, 52.443298F);
      ((Path)localObject3).cubicTo(15.53565F, 52.638466F, 15.53565F, 52.638466F, 15.819197F, 53.187637F);
      ((Path)localObject3).cubicTo(17.132549F, 54.203339F, 17.132549F, 54.203339F, 17.982939F, 54.085918F);
      ((Path)localObject3).cubicTo(18.439087F, 53.956871F, 18.439087F, 53.956871F, 18.627583F, 53.854057F);
      ((Path)localObject3).cubicTo(18.770927F, 53.775673F, 18.87991F, 53.699081F, 18.99534F, 53.607876F);
      ((Path)localObject3).cubicTo(19.109406F, 53.51775F, 19.23008F, 53.41098F, 19.375038F, 53.275429F);
      ((Path)localObject3).cubicTo(19.600636F, 53.064468F, 19.901455F, 52.767365F, 20.278923F, 52.384315F);
      ((Path)localObject3).cubicTo(20.923569F, 51.730137F, 21.786276F, 50.830742F, 22.815981F, 49.742722F);
      ((Path)localObject3).cubicTo(23.721895F, 48.784794F, 24.567696F, 47.883434F, 25.40901F, 46.982178F);
      ((Path)localObject3).cubicTo(25.703396F, 46.666821F, 25.976231F, 46.373959F, 26.220726F, 46.111065F);
      ((Path)localObject3).cubicTo(26.387348F, 45.931793F, 26.443598F, 45.871277F, 26.478994F, 45.833153F);
      ((Path)localObject3).cubicTo(26.647337F, 45.683655F, 26.868061F, 45.59919F, 27.095905F, 45.59919F);
      ((Path)localObject3).lineTo(58.663773F, 45.59919F);
      ((Path)localObject3).cubicTo(62.008965F, 45.661331F, 64.211769F, 42.940216F, 64.120995F, 40.124657F);
      ((Path)localObject3).lineTo(64.122101F, 6.282759F);
      ((Path)localObject3).cubicTo(64.203636F, 3.63596F, 61.691536F, 0.8764129F, 58.663612F, 0.8766431F);
      ((Path)localObject3).lineTo(6.031634F, 0.9366137F);
      ((Path)localObject3).cubicTo(3.065045F, 1.02983F, 0.8320851F, 3.362925F, 0.97887F, 5.953269F);
      ((Path)localObject3).lineTo(0.8766525F, 40.186584F);
      ((Path)localObject3).close();
      ((Path)localObject3).moveTo(19.600269F, 46.684479F);
      ((Path)localObject3).cubicTo(19.600883F, 46.466084F, 19.600883F, 46.466084F, 19.601082F, 46.418449F);
      ((Path)localObject3).cubicTo(19.542549F, 43.565197F, 17.245102F, 41.352325F, 14.445879F, 41.352325F);
      ((Path)localObject3).lineTo(6.410179F, 41.352325F);
      ((Path)localObject3).cubicTo(5.843438F, 41.294361F, 5.123357F, 40.653561F, 5.123357F, 40.192924F);
      ((Path)localObject3).lineTo(5.225786F, 5.891908F);
      ((Path)localObject3).lineTo(5.21884F, 5.713845F);
      ((Path)localObject3).cubicTo(5.20579F, 5.553008F, 5.537754F, 5.200155F, 6.101442F, 5.182257F);
      ((Path)localObject3).lineTo(58.666191F, 5.123355F);
      ((Path)localObject3).cubicTo(59.232662F, 5.123314F, 59.887787F, 5.842969F, 59.876369F, 6.218165F);
      ((Path)localObject3).lineTo(59.875385F, 40.193073F);
      ((Path)localObject3).cubicTo(59.894394F, 40.816822F, 59.449318F, 41.366623F, 58.70298F, 41.352837F);
      ((Path)localObject3).lineTo(27.095905F, 41.352478F);
      ((Path)localObject3).cubicTo(25.750111F, 41.352478F, 24.456951F, 41.877434F, 23.493828F, 42.811176F);
      ((Path)localObject3).cubicTo(23.360342F, 42.950703F, 23.360342F, 42.950703F, 23.111008F, 43.218967F);
      ((Path)localObject3).cubicTo(22.868242F, 43.480003F, 22.597191F, 43.770947F, 22.304676F, 44.084301F);
      ((Path)localObject3).cubicTo(21.469137F, 44.97937F, 20.629341F, 45.874329F, 19.840115F, 46.708912F);
      ((Path)localObject3).cubicTo(19.785852F, 46.766285F, 19.785852F, 46.766285F, 19.731583F, 46.823635F);
      ((Path)localObject3).cubicTo(19.687311F, 46.870415F, 19.643358F, 46.916836F, 19.599728F, 46.962891F);
      ((Path)localObject3).cubicTo(19.599867F, 46.869049F, 19.600048F, 46.776176F, 19.600269F, 46.684479F);
      ((Path)localObject3).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject3, 1);
      localCanvas.drawPath((Path)localObject3, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.save();
      localObject1 = c.instancePaint((Paint)localObject2, paramVarArgs);
      localObject3 = c.instancePath(paramVarArgs);
      ((Path)localObject3).moveTo(15.0F, 17.123358F);
      ((Path)localObject3).lineTo(39.0F, 17.123358F);
      ((Path)localObject3).cubicTo(40.172699F, 17.123358F, 41.123356F, 16.172697F, 41.123356F, 15.0F);
      ((Path)localObject3).cubicTo(41.123356F, 13.827302F, 40.172699F, 12.876643F, 39.0F, 12.876643F);
      ((Path)localObject3).lineTo(15.0F, 12.876643F);
      ((Path)localObject3).cubicTo(13.827302F, 12.876643F, 12.876643F, 13.827302F, 12.876643F, 15.0F);
      ((Path)localObject3).cubicTo(12.876643F, 16.172697F, 13.827302F, 17.123358F, 15.0F, 17.123358F);
      ((Path)localObject3).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject3, 1);
      localCanvas.drawPath((Path)localObject3, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.save();
      localObject1 = c.instancePaint((Paint)localObject2, paramVarArgs);
      localObject2 = c.instancePath(paramVarArgs);
      ((Path)localObject2).moveTo(15.0F, 30.123358F);
      ((Path)localObject2).lineTo(28.949892F, 30.123358F);
      ((Path)localObject2).cubicTo(30.122589F, 30.123358F, 31.073248F, 29.172697F, 31.073248F, 28.0F);
      ((Path)localObject2).cubicTo(31.073248F, 26.827303F, 30.122589F, 25.876642F, 28.949892F, 25.876642F);
      ((Path)localObject2).lineTo(15.0F, 25.876642F);
      ((Path)localObject2).cubicTo(13.827302F, 25.876642F, 12.876643F, 26.827303F, 12.876643F, 28.0F);
      ((Path)localObject2).cubicTo(12.876643F, 29.172697F, 13.827302F, 30.123358F, 15.0F, 30.123358F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 1);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.restore();
      c.done(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.mm.boot.svg.code.drawable.invite_friends_by_message
 * JD-Core Version:    0.7.0.1
 */