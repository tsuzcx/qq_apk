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

public final class byt
  extends c
{
  private final int height = 162;
  private final int width = 162;
  
  public final int a(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 162;
      return 162;
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
      arrayOfFloat = c.a(arrayOfFloat, 1.0F, 0.0F, 1.0F, 0.0F, 1.0F, 17.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject1);
      localPaint = c.a((Paint)localObject2, paramVarArgs);
      localPaint.setColor(-8929981);
      localCanvas.save();
      localPaint = c.a(localPaint, paramVarArgs);
      Object localObject3 = c.n(paramVarArgs);
      ((Path)localObject3).moveTo(99.830009F, 0.4743109F);
      ((Path)localObject3).cubicTo(101.02664F, -0.0366555F, 102.34294F, -0.136845F, 103.60938F, 0.1837613F);
      ((Path)localObject3).cubicTo(119.77388F, 3.580185F, 135.94836F, 6.936533F, 152.12283F, 10.312919F);
      ((Path)localObject3).cubicTo(155.31386F, 10.713676F, 158.11597F, 13.498944F, 157.99631F, 16.835255F);
      ((Path)localObject3).cubicTo(157.76695F, 19.460218F, 156.72987F, 21.924881F, 155.99194F, 24.429617F);
      ((Path)localObject3).cubicTo(151.94334F, 37.484306F, 147.88477F, 50.549015F, 143.85609F, 63.603706F);
      ((Path)localObject3).cubicTo(142.91873F, 66.469124F, 142.41017F, 69.715263F, 140.08672F, 71.849304F);
      ((Path)localObject3).cubicTo(137.91283F, 73.762924F, 135.25032F, 74.985229F, 132.78725F, 76.46804F);
      ((Path)localObject3).cubicTo(105.24477F, 92.538429F, 77.672379F, 108.57877F, 50.139866F, 124.6692F);
      ((Path)localObject3).cubicTo(47.427502F, 126.16203F, 44.69519F, 128.37621F, 41.404453F, 127.9454F);
      ((Path)localObject3).cubicTo(38.652199F, 127.72498F, 36.348682F, 125.87148F, 35.022415F, 123.52704F);
      ((Path)localObject3).cubicTo(23.774075F, 105.07214F, 12.445958F, 86.65731F, 1.227533F, 68.172348F);
      ((Path)localObject3).cubicTo(-1.325283F, 64.345108F, 0.2901708F, 58.754536F, 4.348748F, 56.720688F);
      ((Path)localObject3).cubicTo(33.865673F, 39.227604F, 63.402538F, 21.774595F, 92.909492F, 4.281511F);
      ((Path)localObject3).cubicTo(95.18309F, 2.95901F, 97.376915F, 1.456168F, 99.830009F, 0.4743109F);
      ((Path)localObject3).lineTo(99.830009F, 0.4743109F);
      ((Path)localObject3).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject3, 2);
      localCanvas.drawPath((Path)localObject3, localPaint);
      localCanvas.restore();
      localCanvas.save();
      localPaint = c.a((Paint)localObject2, paramVarArgs);
      localPaint.setColor(-655378);
      arrayOfFloat = c.a(arrayOfFloat, 1.0F, 0.0F, 28.0F, 0.0F, 1.0F, 30.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject3 = c.a(localPaint, paramVarArgs);
      Path localPath = c.n(paramVarArgs);
      localPath.moveTo(61.0F, 10.177664F);
      localPath.cubicTo(66.590332F, 6.831719F, 72.13002F, 3.41586F, 77.67984F, 0.0F);
      localPath.cubicTo(78.398888F, 1.208535F, 79.128059F, 2.407082F, 79.857239F, 3.605629F);
      localPath.cubicTo(75.705002F, 6.172518F, 71.542633F, 8.729419F, 67.360016F, 11.246368F);
      localPath.cubicTo(68.585426F, 13.223971F, 69.810844F, 15.201573F, 71.036263F, 17.179176F);
      localPath.cubicTo(74.894806F, 14.802058F, 78.743217F, 12.424939F, 82.622017F, 10.077785F);
      localPath.cubicTo(83.290428F, 11.196428F, 83.958839F, 12.325061F, 84.637375F, 13.453692F);
      localPath.cubicTo(80.788956F, 15.790859F, 76.950668F, 18.138014F, 73.092125F, 20.455206F);
      localPath.cubicTo(74.388435F, 22.612591F, 75.715126F, 24.759989F, 77.062073F, 26.887409F);
      localPath.cubicTo(81.295326F, 24.32052F, 85.518456F, 21.743645F, 89.741585F, 19.15678F);
      localPath.cubicTo(90.491013F, 20.325363F, 91.250572F, 21.493946F, 92.0F, 22.662531F);
      localPath.cubicTo(86.4198F, 26.168282F, 80.748451F, 29.544189F, 75.137863F, 33.0F);
      localPath.cubicTo(70.398239F, 25.409201F, 65.7295F, 17.77845F, 61.0F, 10.177664F);
      localPath.lineTo(61.0F, 10.177664F);
      localPath.close();
      WeChatSVGRenderC2Java.setFillType(localPath, 2);
      localCanvas.drawPath(localPath, (Paint)localObject3);
      localCanvas.restore();
      localCanvas.save();
      localObject3 = c.a(localPaint, paramVarArgs);
      localPath = c.n(paramVarArgs);
      localPath.moveTo(41.0F, 23.220709F);
      localPath.cubicTo(46.534267F, 19.783833F, 52.098888F, 16.386921F, 57.67363F, 13.0F);
      localPath.cubicTo(58.391972F, 14.19891F, 59.110313F, 15.387829F, 59.838772F, 16.576748F);
      localPath.cubicTo(55.710835F, 19.164396F, 51.522194F, 21.672117F, 47.363903F, 24.229792F);
      localPath.cubicTo(48.58812F, 26.198002F, 49.802219F, 28.166212F, 51.026436F, 30.144415F);
      localPath.cubicTo(54.891319F, 27.776567F, 58.746082F, 25.378746F, 62.651436F, 23.080835F);
      localPath.cubicTo(63.298954F, 24.199818F, 63.956593F, 25.308809F, 64.624344F, 26.417803F);
      localPath.cubicTo(60.759464F, 28.755676F, 56.935051F, 31.133514F, 53.080288F, 33.47139F);
      localPath.cubicTo(54.385445F, 35.609447F, 55.710835F, 37.747501F, 57.036228F, 39.885559F);
      localPath.cubicTo(61.275455F, 37.327885F, 65.484337F, 34.700272F, 69.733681F, 32.142597F);
      localPath.cubicTo(70.482376F, 33.321526F, 71.231071F, 34.500454F, 72.0F, 35.679382F);
      localPath.cubicTo(66.384789F, 39.116257F, 60.739231F, 42.503178F, 55.16449F, 46.0F);
      localPath.cubicTo(50.378918F, 38.446865F, 45.805809F, 30.763851F, 41.0F, 23.220709F);
      localPath.lineTo(41.0F, 23.220709F);
      localPath.close();
      WeChatSVGRenderC2Java.setFillType(localPath, 2);
      localCanvas.drawPath(localPath, (Paint)localObject3);
      localCanvas.restore();
      localCanvas.save();
      localObject3 = c.a(localPaint, paramVarArgs);
      localPath = c.n(paramVarArgs);
      localPath.moveTo(32.001217F, 28.78541F);
      localPath.cubicTo(34.872528F, 27.337238F, 38.737755F, 27.869221F, 40.635231F, 30.568535F);
      localPath.cubicTo(42.86401F, 32.923046F, 42.522663F, 36.321819F, 41.609066F, 39.1492F);
      localPath.cubicTo(47.020382F, 38.764992F, 48.044418F, 45.237438F, 52.0F, 47.54269F);
      localPath.cubicTo(50.514145F, 48.350513F, 49.048374F, 49.187893F, 47.5826F, 50.035122F);
      localPath.cubicTo(45.31366F, 47.503284F, 43.94828F, 43.533127F, 40.303925F, 42.676044F);
      localPath.cubicTo(37.010952F, 43.503571F, 34.320354F, 45.700459F, 31.449041F, 47.394917F);
      localPath.cubicTo(33.326439F, 50.419331F, 35.203835F, 53.443748F, 37.111347F, 56.44846F);
      localPath.cubicTo(35.745968F, 57.295689F, 34.380589F, 58.152771F, 33.005173F, 59.0F);
      localPath.cubicTo(28.356861F, 51.493149F, 23.698509F, 43.976444F, 19.0F, 36.499146F);
      localPath.cubicTo(23.357164F, 33.967304F, 27.49346F, 31.051258F, 32.001217F, 28.78541F);
      localPath.lineTo(32.001217F, 28.78541F);
      localPath.close();
      localPath.moveTo(25.0F, 36.890717F);
      localPath.cubicTo(26.418848F, 39.276909F, 27.877382F, 41.643387F, 29.355762F, 44.0F);
      localPath.cubicTo(32.183537F, 42.07724F, 35.547096F, 40.736237F, 37.789471F, 38.073952F);
      localPath.cubicTo(38.642765F, 35.529991F, 36.807194F, 32.187347F, 33.999264F, 32.0F);
      localPath.cubicTo(30.685312F, 32.956451F, 27.966681F, 35.214462F, 25.0F, 36.890717F);
      localPath.lineTo(25.0F, 36.890717F);
      localPath.close();
      WeChatSVGRenderC2Java.setFillType(localPath, 2);
      localCanvas.drawPath(localPath, (Paint)localObject3);
      localCanvas.restore();
      localCanvas.save();
      localPaint = c.a(localPaint, paramVarArgs);
      localObject3 = c.n(paramVarArgs);
      ((Path)localObject3).moveTo(0.0F, 48.884838F);
      ((Path)localObject3).cubicTo(5.224876F, 45.630322F, 10.449752F, 42.365696F, 15.615142F, 39.0F);
      ((Path)localObject3).cubicTo(16.358721F, 40.212864F, 17.102299F, 41.435833F, 17.845877F, 42.648697F);
      ((Path)localObject3).cubicTo(13.969356F, 45.084534F, 10.112663F, 47.55069F, 6.236143F, 49.966309F);
      ((Path)localObject3).cubicTo(7.435782F, 51.957428F, 8.625507F, 53.958652F, 9.825147F, 55.959877F);
      ((Path)localObject3).cubicTo(13.205949F, 53.81715F, 16.58675F, 51.674427F, 19.957638F, 49.521591F);
      ((Path)localObject3).cubicTo(20.631817F, 50.633385F, 21.315908F, 51.755283F, 22.0F, 52.867077F);
      ((Path)localObject3).cubicTo(18.629112F, 55.030014F, 15.24831F, 57.192955F, 11.837765F, 59.285145F);
      ((Path)localObject3).cubicTo(13.82064F, 62.681164F, 15.833259F, 66.04686F, 17.87562F, 69.402451F);
      ((Path)localObject3).cubicTo(16.527264F, 70.261559F, 15.188824F, 71.130783F, 13.850383F, 72.0F);
      ((Path)localObject3).cubicTo(9.200541F, 64.308426F, 4.630014F, 56.576416F, 0.0F, 48.884838F);
      ((Path)localObject3).lineTo(0.0F, 48.884838F);
      ((Path)localObject3).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject3, 2);
      localCanvas.drawPath((Path)localObject3, localPaint);
      localCanvas.restore();
      localCanvas.restore();
      localCanvas.save();
      localObject2 = c.a((Paint)localObject2, paramVarArgs);
      ((Paint)localObject2).setColor(-8929980);
      arrayOfFloat = c.a(arrayOfFloat, 1.0F, 0.0F, 52.0F, 0.0F, 1.0F, 62.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues(arrayOfFloat);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject1 = c.a((Paint)localObject2, paramVarArgs);
      localObject2 = c.n(paramVarArgs);
      ((Path)localObject2).moveTo(1.0F, 4.890715F);
      ((Path)localObject2).cubicTo(3.966681F, 3.214462F, 6.685312F, 0.9564503F, 9.999264F, -1.421086E-014F);
      ((Path)localObject2).cubicTo(12.807193F, 0.1873459F, 14.642765F, 3.529992F, 13.789472F, 6.073952F);
      ((Path)localObject2).cubicTo(11.547097F, 8.736237F, 8.183536F, 10.077239F, 5.355763F, 12.0F);
      ((Path)localObject2).cubicTo(3.877383F, 9.643385F, 2.418848F, 7.27691F, 1.0F, 4.890715F);
      ((Path)localObject2).lineTo(1.0F, 4.890715F);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.byt
 * JD-Core Version:    0.7.0.1
 */