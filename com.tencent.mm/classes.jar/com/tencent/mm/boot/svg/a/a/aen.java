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

public final class aen
  extends c
{
  private final int height = 144;
  private final int width = 144;
  
  public final int a(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 144;
      return 144;
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
      localPaint1.setColor(-15028967);
      localObject2 = c.a((float[])localObject2, 1.0F, 0.0F, 24.0F, 0.0F, 1.0F, 24.0F);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).setValues((float[])localObject2);
      localCanvas.concat((Matrix)localObject1);
      localCanvas.save();
      localObject1 = c.a(localPaint1, paramVarArgs);
      localObject2 = c.n(paramVarArgs);
      ((Path)localObject2).moveTo(41.623169F, 65.789192F);
      ((Path)localObject2).lineTo(41.977798F, 65.992409F);
      ((Path)localObject2).cubicTo(51.303997F, 69.16349F, 62.08437F, 65.164299F, 67.361F, 56.093422F);
      ((Path)localObject2).lineTo(68.911209F, 53.428516F);
      ((Path)localObject2).lineTo(65.566063F, 51.511677F);
      ((Path)localObject2).lineTo(64.015854F, 54.176582F);
      ((Path)localObject2).cubicTo(59.03817F, 62.733551F, 48.512413F, 65.723717F, 40.710613F, 61.253113F);
      ((Path)localObject2).cubicTo(32.254654F, 56.407665F, 29.600893F, 45.865349F, 34.578579F, 37.30838F);
      ((Path)localObject2).lineTo(36.128788F, 34.643475F);
      ((Path)localObject2).lineTo(36.274845F, 34.194435F);
      ((Path)localObject2).lineTo(32.783642F, 32.726635F);
      ((Path)localObject2).lineTo(31.233435F, 35.391541F);
      ((Path)localObject2).cubicTo(26.03302F, 44.331394F, 27.804018F, 55.403114F, 34.969021F, 61.877071F);
      ((Path)localObject2).lineTo(29.981249F, 70.516144F);
      ((Path)localObject2).lineTo(30.39813F, 75.444328F);
      ((Path)localObject2).cubicTo(30.483181F, 76.449745F, 31.284433F, 76.90377F, 32.189484F, 76.478569F);
      ((Path)localObject2).lineTo(36.665859F, 74.375504F);
      ((Path)localObject2).lineTo(41.623169F, 65.789192F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(96.0F, 48.0F);
      ((Path)localObject2).cubicTo(96.0F, 74.511047F, 74.509712F, 96.0F, 48.0F, 96.0F);
      ((Path)localObject2).cubicTo(21.490286F, 96.0F, 0.0F, 74.511047F, 0.0F, 48.0F);
      ((Path)localObject2).cubicTo(0.0F, 21.488955F, 21.490286F, 0.0F, 48.0F, 0.0F);
      ((Path)localObject2).cubicTo(74.509712F, 0.0F, 96.0F, 21.488955F, 96.0F, 48.0F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(63.940453F, 21.108919F);
      ((Path)localObject2).cubicTo(58.015858F, 17.731424F, 50.436932F, 19.741205F, 47.023098F, 25.579679F);
      ((Path)localObject2).lineTo(38.818642F, 39.611271F);
      ((Path)localObject2).cubicTo(35.400043F, 45.457897F, 37.430252F, 52.934784F, 43.356152F, 56.313019F);
      ((Path)localObject2).cubicTo(49.280746F, 59.690514F, 56.859673F, 57.680733F, 60.273506F, 51.842258F);
      ((Path)localObject2).lineTo(68.477959F, 37.810669F);
      ((Path)localObject2).cubicTo(71.896561F, 31.964041F, 69.866356F, 24.487156F, 63.940453F, 21.108919F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 1);
      localCanvas.drawPath((Path)localObject2, (Paint)localObject1);
      localCanvas.restore();
      localCanvas.restore();
      c.l(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.boot.svg.a.a.aen
 * JD-Core Version:    0.7.0.1
 */