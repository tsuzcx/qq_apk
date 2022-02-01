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

public final class ao
  extends c
{
  private final int height = 36;
  private final int width = 36;
  
  public final int a(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 36;
      return 36;
      Canvas localCanvas = (Canvas)paramVarArgs[0];
      paramVarArgs = (Looper)paramVarArgs[1];
      Object localObject1 = c.j(paramVarArgs);
      Object localObject3 = c.i(paramVarArgs);
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
      localObject2 = c.a((Paint)localObject2, paramVarArgs);
      ((Paint)localObject2).setColor(-1);
      localObject3 = c.a((float[])localObject3, 1.0F, 0.0F, 6.0F, 0.0F, 1.0F, 6.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject3);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject1 = c.a((Paint)localObject2, paramVarArgs);
      localObject3 = c.n(paramVarArgs);
      ((Path)localObject3).moveTo(11.324318F, 1.44F);
      ((Path)localObject3).lineTo(10.550886F, 4.533727F);
      ((Path)localObject3).lineTo(9.774231F, 4.772571F);
      ((Path)localObject3).cubicTo(9.32088F, 4.911989F, 8.882618F, 5.093915F, 8.464506F, 5.315609F);
      ((Path)localObject3).lineTo(7.746217F, 5.696465F);
      ((Path)localObject3).lineTo(5.010732F, 4.055173F);
      ((Path)localObject3).lineTo(4.055173F, 5.010732F);
      ((Path)localObject3).lineTo(5.696465F, 7.746217F);
      ((Path)localObject3).lineTo(5.315609F, 8.464506F);
      ((Path)localObject3).cubicTo(5.093915F, 8.882618F, 4.911989F, 9.32088F, 4.772571F, 9.774231F);
      ((Path)localObject3).lineTo(4.533727F, 10.550886F);
      ((Path)localObject3).lineTo(1.44F, 11.324318F);
      ((Path)localObject3).lineTo(1.44F, 12.675682F);
      ((Path)localObject3).lineTo(4.533727F, 13.449114F);
      ((Path)localObject3).lineTo(4.772571F, 14.225769F);
      ((Path)localObject3).cubicTo(4.911989F, 14.67912F, 5.093915F, 15.117382F, 5.315609F, 15.535494F);
      ((Path)localObject3).lineTo(5.696465F, 16.253782F);
      ((Path)localObject3).lineTo(4.055173F, 18.989267F);
      ((Path)localObject3).lineTo(5.010732F, 19.944826F);
      ((Path)localObject3).lineTo(7.746217F, 18.303535F);
      ((Path)localObject3).lineTo(8.464506F, 18.684391F);
      ((Path)localObject3).cubicTo(8.882618F, 18.906086F, 9.32088F, 19.088011F, 9.774231F, 19.227428F);
      ((Path)localObject3).lineTo(10.550886F, 19.466272F);
      ((Path)localObject3).lineTo(11.324318F, 22.559999F);
      ((Path)localObject3).lineTo(12.675682F, 22.559999F);
      ((Path)localObject3).lineTo(13.449114F, 19.466272F);
      ((Path)localObject3).lineTo(14.225769F, 19.227428F);
      ((Path)localObject3).cubicTo(14.67912F, 19.088011F, 15.117382F, 18.906086F, 15.535494F, 18.684391F);
      ((Path)localObject3).lineTo(16.253782F, 18.303535F);
      ((Path)localObject3).lineTo(18.989267F, 19.944826F);
      ((Path)localObject3).lineTo(19.944826F, 18.989267F);
      ((Path)localObject3).lineTo(18.303535F, 16.253782F);
      ((Path)localObject3).lineTo(18.684391F, 15.535494F);
      ((Path)localObject3).cubicTo(18.906086F, 15.117382F, 19.088011F, 14.67912F, 19.227428F, 14.225769F);
      ((Path)localObject3).lineTo(19.466272F, 13.449114F);
      ((Path)localObject3).lineTo(22.559999F, 12.675682F);
      ((Path)localObject3).lineTo(22.559999F, 11.324318F);
      ((Path)localObject3).lineTo(19.466272F, 10.550886F);
      ((Path)localObject3).lineTo(19.227428F, 9.774231F);
      ((Path)localObject3).cubicTo(19.088011F, 9.32088F, 18.906086F, 8.882618F, 18.684391F, 8.464506F);
      ((Path)localObject3).lineTo(18.303535F, 7.746217F);
      ((Path)localObject3).lineTo(19.944826F, 5.010732F);
      ((Path)localObject3).lineTo(18.989267F, 4.055173F);
      ((Path)localObject3).lineTo(16.253782F, 5.696465F);
      ((Path)localObject3).lineTo(15.535494F, 5.315609F);
      ((Path)localObject3).cubicTo(15.117382F, 5.093915F, 14.67912F, 4.911989F, 14.225769F, 4.772571F);
      ((Path)localObject3).lineTo(13.449114F, 4.533727F);
      ((Path)localObject3).lineTo(12.675682F, 1.44F);
      ((Path)localObject3).lineTo(11.324318F, 1.44F);
      ((Path)localObject3).close();
      ((Path)localObject3).moveTo(16.210062F, 4.043383F);
      ((Path)localObject3).lineTo(18.409077F, 2.723974F);
      ((Path)localObject3).cubicTo(18.881248F, 2.440671F, 19.485638F, 2.515075F, 19.875F, 2.904437F);
      ((Path)localObject3).lineTo(21.095562F, 4.125F);
      ((Path)localObject3).cubicTo(21.484924F, 4.514362F, 21.559328F, 5.118752F, 21.276026F, 5.590923F);
      ((Path)localObject3).lineTo(19.956617F, 7.789938F);
      ((Path)localObject3).cubicTo(20.218946F, 8.284686F, 20.43648F, 8.806827F, 20.603815F, 9.350954F);
      ((Path)localObject3).lineTo(23.091043F, 9.972761F);
      ((Path)localObject3).cubicTo(23.625244F, 10.106311F, 24.0F, 10.58629F, 24.0F, 11.136931F);
      ((Path)localObject3).lineTo(24.0F, 12.863069F);
      ((Path)localObject3).cubicTo(24.0F, 13.41371F, 23.625244F, 13.893689F, 23.091043F, 14.027239F);
      ((Path)localObject3).lineTo(20.603815F, 14.649046F);
      ((Path)localObject3).cubicTo(20.43648F, 15.193173F, 20.218946F, 15.715314F, 19.956617F, 16.210062F);
      ((Path)localObject3).lineTo(21.276026F, 18.409077F);
      ((Path)localObject3).cubicTo(21.559328F, 18.881248F, 21.484924F, 19.485638F, 21.095562F, 19.875F);
      ((Path)localObject3).lineTo(19.875F, 21.095562F);
      ((Path)localObject3).cubicTo(19.485638F, 21.484924F, 18.881248F, 21.559328F, 18.409077F, 21.276026F);
      ((Path)localObject3).lineTo(16.210062F, 19.956617F);
      ((Path)localObject3).cubicTo(15.715314F, 20.218946F, 15.193173F, 20.43648F, 14.649046F, 20.603815F);
      ((Path)localObject3).lineTo(14.027239F, 23.091043F);
      ((Path)localObject3).cubicTo(13.893689F, 23.625244F, 13.41371F, 24.0F, 12.863069F, 24.0F);
      ((Path)localObject3).lineTo(11.136931F, 24.0F);
      ((Path)localObject3).cubicTo(10.58629F, 24.0F, 10.106311F, 23.625244F, 9.972761F, 23.091043F);
      ((Path)localObject3).lineTo(9.350954F, 20.603815F);
      ((Path)localObject3).cubicTo(8.806827F, 20.43648F, 8.284686F, 20.218946F, 7.789938F, 19.956617F);
      ((Path)localObject3).lineTo(5.590923F, 21.276026F);
      ((Path)localObject3).cubicTo(5.118752F, 21.559328F, 4.514362F, 21.484924F, 4.125F, 21.095562F);
      ((Path)localObject3).lineTo(2.904437F, 19.875F);
      ((Path)localObject3).cubicTo(2.515075F, 19.485638F, 2.440671F, 18.881248F, 2.723974F, 18.409077F);
      ((Path)localObject3).lineTo(4.043383F, 16.210062F);
      ((Path)localObject3).cubicTo(3.781054F, 15.715314F, 3.56352F, 15.193173F, 3.396186F, 14.649046F);
      ((Path)localObject3).lineTo(0.9089572F, 14.027239F);
      ((Path)localObject3).cubicTo(0.3747568F, 13.893689F, 0.0F, 13.41371F, 0.0F, 12.863069F);
      ((Path)localObject3).lineTo(0.0F, 11.136931F);
      ((Path)localObject3).cubicTo(0.0F, 10.58629F, 0.3747568F, 10.106311F, 0.9089572F, 9.972761F);
      ((Path)localObject3).lineTo(3.396186F, 9.350954F);
      ((Path)localObject3).cubicTo(3.56352F, 8.806827F, 3.781054F, 8.284686F, 4.043383F, 7.789938F);
      ((Path)localObject3).lineTo(2.723974F, 5.590923F);
      ((Path)localObject3).cubicTo(2.440671F, 5.118752F, 2.515075F, 4.514362F, 2.904437F, 4.125F);
      ((Path)localObject3).lineTo(4.125F, 2.904437F);
      ((Path)localObject3).cubicTo(4.514362F, 2.515075F, 5.118752F, 2.440671F, 5.590923F, 2.723974F);
      ((Path)localObject3).lineTo(7.789938F, 4.043383F);
      ((Path)localObject3).cubicTo(8.284686F, 3.781054F, 8.806827F, 3.56352F, 9.350954F, 3.396186F);
      ((Path)localObject3).lineTo(9.972761F, 0.9089572F);
      ((Path)localObject3).cubicTo(10.106311F, 0.3747568F, 10.58629F, 0.0F, 11.136931F, 0.0F);
      ((Path)localObject3).lineTo(12.863069F, 0.0F);
      ((Path)localObject3).cubicTo(13.41371F, 0.0F, 13.893689F, 0.3747568F, 14.027239F, 0.9089572F);
      ((Path)localObject3).lineTo(14.649046F, 3.396186F);
      ((Path)localObject3).cubicTo(15.193173F, 3.56352F, 15.715314F, 3.781054F, 16.210062F, 4.043383F);
      ((Path)localObject3).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject3, 1);
      localCanvas.drawPath((Path)localObject3, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.save();
      localObject1 = c.a((Paint)localObject2, paramVarArgs);
      localObject2 = c.n(paramVarArgs);
      ((Path)localObject2).moveTo(12.0F, 15.6F);
      ((Path)localObject2).cubicTo(13.988225F, 15.6F, 15.6F, 13.988225F, 15.6F, 12.0F);
      ((Path)localObject2).cubicTo(15.6F, 10.011775F, 13.988225F, 8.4F, 12.0F, 8.4F);
      ((Path)localObject2).cubicTo(10.011775F, 8.4F, 8.4F, 10.011775F, 8.4F, 12.0F);
      ((Path)localObject2).cubicTo(8.4F, 13.988225F, 10.011775F, 15.6F, 12.0F, 15.6F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(12.0F, 17.040001F);
      ((Path)localObject2).cubicTo(9.216485F, 17.040001F, 6.96F, 14.783515F, 6.96F, 12.0F);
      ((Path)localObject2).cubicTo(6.96F, 9.216485F, 9.216485F, 6.96F, 12.0F, 6.96F);
      ((Path)localObject2).cubicTo(14.783515F, 6.96F, 17.040001F, 9.216485F, 17.040001F, 12.0F);
      ((Path)localObject2).cubicTo(17.040001F, 14.783515F, 14.783515F, 17.040001F, 12.0F, 17.040001F);
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
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.ao
 * JD-Core Version:    0.7.0.1
 */