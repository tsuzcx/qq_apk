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

public final class aad
  extends c
{
  private final int height = 210;
  private final int width = 210;
  
  protected final int b(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 210;
      return 210;
      Canvas localCanvas = (Canvas)paramVarArgs[0];
      paramVarArgs = (Looper)paramVarArgs[1];
      Object localObject1 = c.f(paramVarArgs);
      Object localObject2 = c.e(paramVarArgs);
      Paint localPaint1 = c.i(paramVarArgs);
      localPaint1.setFlags(385);
      localPaint1.setStyle(Paint.Style.FILL);
      Paint localPaint2 = c.i(paramVarArgs);
      localPaint2.setFlags(385);
      localPaint2.setStyle(Paint.Style.STROKE);
      localPaint1.setColor(-16777216);
      localPaint2.setStrokeWidth(1.0F);
      localPaint2.setStrokeCap(Paint.Cap.BUTT);
      localPaint2.setStrokeJoin(Paint.Join.MITER);
      localPaint2.setStrokeMiter(4.0F);
      localPaint2.setPathEffect(null);
      c.a(localPaint2, paramVarArgs).setStrokeWidth(1.0F);
      localPaint2 = c.a(localPaint1, paramVarArgs);
      localPaint2.setColor(-1250068);
      localCanvas.save();
      localPaint2 = c.a(localPaint2, paramVarArgs);
      Path localPath = c.j(paramVarArgs);
      localPath.moveTo(7.0F, 0.0F);
      localPath.lineTo(202.99001F, 0.0F);
      localPath.cubicTo(206.78F, 1.909775F, 209.48F, 5.589342F, 210.0F, 9.828842F);
      localPath.lineTo(210.0F, 197.96669F);
      localPath.cubicTo(209.55F, 201.70624F, 207.53F, 205.28583F, 204.24001F, 207.21559F);
      localPath.cubicTo(200.91F, 209.40533F, 196.77F, 208.93539F, 192.99001F, 208.99538F);
      localPath.cubicTo(132.64F, 208.93539F, 72.279999F, 209.02538F, 11.92F, 208.94539F);
      localPath.cubicTo(5.92F, 209.07538F, 0.64F, 204.07596F, 0.0F, 198.18666F);
      localPath.lineTo(0.0F, 10.008821F);
      localPath.cubicTo(0.4F, 5.679331F, 3.19F, 1.969768F, 7.0F, 0.0F);
      localPath.lineTo(7.0F, 0.0F);
      localPath.close();
      WeChatSVGRenderC2Java.setFillType(localPath, 2);
      localCanvas.drawPath(localPath, localPaint2);
      localCanvas.restore();
      localCanvas.save();
      localPaint1 = c.a(localPaint1, paramVarArgs);
      localPaint1.setColor(-4210753);
      localObject2 = c.a((float[])localObject2, 1.0F, 0.0F, 60.0F, 0.0F, 1.0F, 60.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject2);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject1 = c.a(localPaint1, paramVarArgs);
      localObject2 = c.j(paramVarArgs);
      ((Path)localObject2).moveTo(62.962128F, 1.907881F);
      ((Path)localObject2).cubicTo(65.416214F, 0.163596F, 68.771797F, 1.115935F, 70.674965F, 3.211082F);
      ((Path)localObject2).cubicTo(75.593155F, 8.002853F, 80.341057F, 12.965043F, 85.269264F, 17.74679F);
      ((Path)localObject2).cubicTo(87.062248F, 19.581297F, 89.305984F, 21.656395F, 88.965416F, 24.493364F);
      ((Path)localObject2).cubicTo(88.755066F, 27.189987F, 86.471268F, 28.944298F, 84.768433F, 30.76878F);
      ((Path)localObject2).cubicTo(79.840225F, 35.500404F, 75.172455F, 40.502693F, 70.214203F, 45.214264F);
      ((Path)localObject2).cubicTo(68.020546F, 47.570053F, 64.013878F, 47.610153F, 61.800194F, 45.244339F);
      ((Path)localObject2).cubicTo(56.821907F, 40.552814F, 52.16415F, 35.520451F, 47.215912F, 30.788828F);
      ((Path)localObject2).cubicTo(45.513081F, 28.944298F, 43.159161F, 27.179964F, 43.018925F, 24.463289F);
      ((Path)localObject2).cubicTo(42.718426F, 20.834375F, 46.063995F, 18.598883F, 48.237614F, 16.243095F);
      ((Path)localObject2).cubicTo(53.25597F, 11.571621F, 57.683338F, 6.258569F, 62.962128F, 1.907881F);
      ((Path)localObject2).lineTo(62.962128F, 1.907881F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 2);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.save();
      localObject1 = c.a(localPaint1, paramVarArgs);
      localObject2 = c.j(paramVarArgs);
      ((Path)localObject2).moveTo(2.457268F, 6.998506F);
      ((Path)localObject2).cubicTo(3.984404F, 5.740388F, 6.160325F, 6.159761F, 8.006862F, 6.0F);
      ((Path)localObject2).cubicTo(16.341236F, 6.149776F, 24.675608F, 5.860209F, 33.009983F, 6.119821F);
      ((Path)localObject2).cubicTo(35.325638F, 5.990015F, 37.112289F, 8.176744F, 36.912663F, 10.413398F);
      ((Path)localObject2).cubicTo(37.03244F, 19.449879F, 37.022457F, 28.496346F, 36.922646F, 37.532825F);
      ((Path)localObject2).cubicTo(37.152214F, 39.849361F, 35.285713F, 42.066044F, 32.900188F, 41.916267F);
      ((Path)localObject2).cubicTo(23.946974F, 42.076031F, 14.973799F, 41.956207F, 6.020587F, 41.966194F);
      ((Path)localObject2).cubicTo(3.814722F, 42.165894F, 1.169682F, 40.957703F, 1.169682F, 38.43148F);
      ((Path)localObject2).cubicTo(0.810356F, 30.123911F, 1.189645F, 21.786383F, 1.0F, 13.468826F);
      ((Path)localObject2).cubicTo(1.179663F, 11.312053F, 0.5508422F, 8.576146F, 2.457268F, 6.998506F);
      ((Path)localObject2).lineTo(2.457268F, 6.998506F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 2);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.save();
      localObject1 = c.a(localPaint1, paramVarArgs);
      localObject2 = c.j(paramVarArgs);
      ((Path)localObject2).moveTo(3.345114F, 52.505009F);
      ((Path)localObject2).cubicTo(12.136798F, 51.518299F, 21.08815F, 52.405342F, 29.939709F, 52.056503F);
      ((Path)localObject2).cubicTo(32.743866F, 51.797367F, 36.99501F, 52.315639F, 36.86528F, 56.033237F);
      ((Path)localObject2).cubicTo(37.044907F, 65.372086F, 37.044907F, 74.740829F, 36.86528F, 84.079681F);
      ((Path)localObject2).cubicTo(37.014969F, 86.690971F, 34.37048F, 88.245781F, 32.005405F, 87.956749F);
      ((Path)localObject2).cubicTo(23.014137F, 87.956749F, 14.002911F, 88.086311F, 5.011643F, 87.89695F);
      ((Path)localObject2).cubicTo(2.89605F, 88.036484F, 1.0F, 86.172699F, 1.119751F, 84.049782F);
      ((Path)localObject2).cubicTo(0.8702703F, 75.717575F, 1.149688F, 67.385368F, 1.0F, 59.053165F);
      ((Path)localObject2).cubicTo(1.059875F, 56.750843F, 0.7305613F, 53.561485F, 3.345114F, 52.505009F);
      ((Path)localObject2).lineTo(3.345114F, 52.505009F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 2);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.save();
      localPaint1 = c.a(localPaint1, paramVarArgs);
      localObject1 = c.j(paramVarArgs);
      ((Path)localObject1).moveTo(49.747242F, 52.320511F);
      ((Path)localObject1).cubicTo(59.009895F, 51.691734F, 68.332443F, 52.210724F, 77.615059F, 52.051037F);
      ((Path)localObject1).cubicTo(80.070457F, 51.731655F, 83.014946F, 53.148903F, 82.875206F, 55.983395F);
      ((Path)localObject1).cubicTo(83.104774F, 64.965942F, 82.945076F, 73.978432F, 82.955055F, 82.960983F);
      ((Path)localObject1).cubicTo(83.324364F, 85.575905F, 81.378014F, 88.270668F, 78.573265F, 87.931328F);
      ((Path)localObject1).cubicTo(69.570122F, 88.031136F, 60.556999F, 88.011177F, 51.55386F, 87.941307F);
      ((Path)localObject1).cubicTo(49.158344F, 88.210785F, 46.912552F, 86.29451F, 47.102196F, 83.8293F);
      ((Path)localObject1).cubicTo(46.912552F, 75.206047F, 47.112175F, 66.582802F, 47.012363F, 57.969536F);
      ((Path)localObject1).cubicTo(46.922531F, 55.813725F, 47.271877F, 52.979233F, 49.747242F, 52.320511F);
      ((Path)localObject1).lineTo(49.747242F, 52.320511F);
      ((Path)localObject1).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject1, 2);
      localCanvas.drawPath((Path)localObject1, localPaint1);
      localCanvas.restore();
      localCanvas.restore();
      c.h(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.aad
 * JD-Core Version:    0.7.0.1
 */